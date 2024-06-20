/* global getFieldsList getFieldsObjList getFieldsDescMap setCurrentDateTime getBlob*/

/*jshint laxcomma: true */
/*** CLASSE RepDocumentText: gestisce la generazione/export del documento (report) in formato csv (standard e non)
  * Eredita da RepDocument - JSReportDocumentRuntime.js
*/
RepDocumentText = function (name, uid, format, isStandard, csvSeparator, csvHeader) {
  RepDocument.call(this);
  this.format = format.toLowerCase();
  this.gcurrpage = null;
  this.name = name;
  this.progrid = 0;
  this.datetime = new Date();
  if(Empty(uid)) uid = LibJavascript.AlfaKeyGen(5);
  this.uid = uid;
  this.parent = null;
  this.document = null;
  this.window = null;
  this.separator = isStandard?",":";";
  csvSeparator = LRTrim(csvSeparator);
  if(!Empty(csvSeparator) && Len(csvSeparator)==1)
    this.separator = csvSeparator;
  this.csvHeader = csvHeader;
  this.fieldsuid = [];
};

RepDocumentText.prototype = new RepDocument();
RepDocumentText.prototype.constructor = RepDocumentText;

RepDocumentText.prototype.Ctrl = function(id){
  return this.document.getElementById(id);
};

RepDocumentText.prototype.initProcess = function(allfields,container,bprint,imgfields,simulatedData){
  this.container = container;
  this.setParent();
  this.setDocument();
  this.setWindow();
  this.allfields = allfields;
  this.simulatedData = simulatedData;
  this.exportString = "";
  this.fieldsuid = getFieldsList(this.obj);
  this.fieldsobjs = getFieldsObjList(this.obj);
  this.fielddesc = getFieldsDescMap(this.obj);
  this.initLastRow();
  this.lastGrp = [];
  this.newLine = "\n";
  this.lastRec = [];
  this.writeHeader();
};

RepDocumentText.prototype.initLastRow = function(){
  this.lastRow = [];
  var rowobj = {};
  for(var i=0; i<this.fieldsuid.length; i++){
    if(this.format=="csvs" || this.format=="csv")
      rowobj = {value: "", item: ""};
    else
      rowobj = {value: "", item: this.fieldsobjs[this.fieldsuid[i]]};
    this.lastRow.push(rowobj);
  }
}

RepDocumentText.prototype.endProcess = function(){
  this.end = true;
  if (this.fieldsuid.length > 1)
    this.writeRow();
  this.writeFooter();
  if (this.format.indexOf("xml") < 0 || this.autodownload)
    this.download();
  else {  // xml - xmls
    if (this.autodownload)
      this.download();
    else
      this.printPreview();
  }
  this.execFncCallback();
};

RepDocumentText.prototype.drawCover = function(/*coverobj*/){
};

RepDocumentText.prototype.startLoading = function(){
}

RepDocumentText.prototype.updateLoading = function(){
}

RepDocumentText.prototype.appendFontsInDocument = function () {
}

RepDocumentText.prototype.setLimitPage = function(){
  this.gwork.limitpage = Infinity;
}

RepDocumentText.prototype.newPage = function(k,firstpage){
  if(Empty(firstpage) && this.obj.showPageZone){
    this.drawZone(k,'pagefooter','',false,true);
    this.drawZone(k,'pageheader','',false);
  }
}

RepDocumentText.prototype.getLastChildElement = function(){
  return {};
}

RepDocumentText.prototype.addCurrentZone = function(){
}

RepDocumentText.prototype.checkLimitPage = function(){
  return false;
}

RepDocumentText.prototype.splitStringCheck = function(){
  return false;
}

RepDocumentText.prototype.updateZoneHeight = function(){
}

RepDocumentText.prototype.writeHeader = function(){
  if(this.csvHeader && (this.format=="csvs" || this.format=="csv") && (this.fieldsuid.length > 0)){
    var tmp = "";
    for (var i = 0; i < this.fieldsuid.length - 1; i++) {
      tmp = "" + this.fielddesc[this.fieldsuid[i]];
      this.exportString += convertCsv(tmp, this.separator) + this.separator;
    }
    tmp = "" + this.fielddesc[this.fieldsuid[this.fieldsuid.length - 1]];
    this.exportString += convertCsv(tmp, this.separator);
  }
  else if(this.format.indexOf("xml")>=0){
    var txt="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+this.newLine;
    this.exportString=txt;
    this.exportString+="<REPORT ";
    this.exportString+="NAME=\""+this.obj.name+"\" ";
    this.exportString+="QUERY=\""+this.obj.datasource+"\"";
    this.exportString+=">"+this.newLine;
    if(this.format=="xml")
      this.exportString+="<RECORDS>"+this.newLine;
  }
}

RepDocumentText.prototype.writeFooter = function(){
  if(this.format.indexOf("xml")>=0){
    if(this.format=="xml")
      this.exportString+="</RECORDS>"+this.newLine;
    this.exportString+="</REPORT>";
  }
}

RepDocumentText.prototype.getItemValue = function (k, item, zoneid, repObj, useLastRecord) {
  if (item.type != "field" || (item.fieldDetail && Empty(item.fieldDetail.alias)))
    return "";
  var value;
  var mdata = useLastRecord ? repObj.lastRec : repObj.propertyValue[k];
  if (item.typeView.indexOf("date") >= 0) {
    if (mdata[item.fieldDetail.alias + '_pic'])
      value = mdata[item.fieldDetail.alias + '_pic'];
    else {
      value = mdata[item.fieldDetail.alias];
      value = setCurrentDateTime(value, item);
    }
  }
  else if (item.typeView == "numeric") {
    if (item.calculation && item.calculation.type != 'none')
      value = repObj.calcObjs[item.fieldDetail.alias][item.uid];
    else if (mdata[item.fieldDetail.alias + '_pic'])
      value = mdata[item.fieldDetail.alias + '_pic'];
    else {
      value = mdata[item.fieldDetail.alias];
      value = repObj.setFormatNumber(value, item.fieldDetail.len, item.fieldDetail.dec, item.stdPicture);
    }
  }
  else if (mdata[item.fieldDetail.alias + '_pic'])
    value = mdata[item.fieldDetail.alias + '_pic'];
  else
    value = Format(mdata[item.fieldDetail.alias], item.fieldDetail.len, item.fieldDetail.dec, item.stdPicture);
  return value;
};

RepDocumentText.prototype.isEoPreview = function () {
  return false;
}

RepDocumentText.prototype.addItemInZone = function(k,item,objzone,zoneid,value/*,yRel*/){
  var curindex = this.fieldsuid.indexOf(item.uid);
  if(curindex>=0 && this.format!="xmls"){
    if (this.fieldsuid.length == 1) {
      this.lastRow[curindex].value = value;
      this.writeRow();
    }
    else {
      if(this.grpBreak){
        this.resetRow(curindex);
        this.grpBreak = false;
      }
      if(curindex<this.lastElement)
        this.writeRow();
      if(zoneid.indexOf("page")>=0)
        value = "";
      this.lastRow[curindex].value = value;
      this.lastElement = curindex;
    }
  }
  else if(curindex>=0){
    this.lastRow[curindex].value = value;
    if(zoneid.indexOf("report")>=0)
      this.writeRow(zoneid,curindex);
    else if(zoneid.indexOf("group")>=0){
      if(!this.grpBreak){
        if(!this.lastGrp[zoneid])
          this.lastGrp[zoneid] = [];
        if(!this.lastGrp[zoneid][curindex+""])
          this.lastGrp[zoneid][curindex+""] = [];
        this.lastGrp[zoneid][curindex+""].push(value);
      }
      else{
        this.writeRow();
        this.lastGrp = [];
        this.lastGrp[zoneid] = [];
        this.lastGrp[zoneid][curindex+""] = [];
        this.lastGrp[zoneid][curindex+""].push(value);
        this.grpBreak = false;
      }
    }
  }
};

RepDocumentText.prototype.resetRow = function(fromidx){
  for(var i=fromidx; i<this.lastRow.length; i++)
    this.lastRow[i].value = "";
}

RepDocumentText.prototype.writeRow = function(zoneid,curindex){
  var i, j, keys;
  // ? Check if a string starts with a number
  function startsWithNumber(str) {
    return /^\d/.test(str);
  }
  function encodeXMLTag(tagname) {
    var ret = encodeSpecialCharsXML(tagname);
    if (startsWithNumber(ret)) ret = 'initWith' + ret;
    return ret;
  }
  function getXMLRow(tagname, tagvalue) {
    var ret = "";
    ret += "<" + encodeXMLTag(tagname) + ">";
    if( tagvalue != null )  ret += encodeTextForXML(tagvalue);
    ret += "</" + encodeXMLTag(tagname) + ">";
    return ret;
  }
  if ((this.format == "csvs" || this.format == "csv") && (this.lastRow.length > 0)) {
    this.exportString += this.newLine;
    var tmp = "";
    for (i = 0; i < this.lastRow.length - 1; i++) {
      tmp = "" + this.lastRow[i].value;//Strtran(this.lastRow[i].value," ","");
      this.exportString += convertCsv(tmp, this.separator) + this.separator;
    }
    if( this.lastRow[this.lastRow.length - 1].value!=null ) tmp = "" + this.lastRow[this.lastRow.length - 1].value;//Strtran(this.lastRow[this.lastRow.length-1].value," ","");
    this.exportString += convertCsv(tmp, this.separator);
  }
  else if(this.format=="csv2"){
    var mstr,mlen,diff;
    for(i=0; i<this.lastRow.length; i++){
      mstr = this.lastRow[i].value;
      if( mstr == null ) mstr = '';
      mlen = this.lastRow[i].item.len;
      diff = 0;
      if(mstr.length<mlen){
        diff = mlen-mstr.length;
        for(var s=0; s<diff; s++)
          mstr+=" ";
      }
      this.exportString+=mstr.slice(0,mlen);
    }
    this.exportString+=this.newLine;
  }
  else if(this.format=="xml"){
    this.exportString+="<RECORD>"+this.newLine;
    for(i=0; i<this.lastRow.length; i++){
      this.exportString+="<FIELD ";
      this.exportString+="NAME=\""+encodeSpecialCharsXML(this.fielddesc[this.fieldsuid[i]])+"\" ";
      this.exportString+="SIZE=\""+this.lastRow[i].item.len+"\" ";
      this.exportString+="TYPE=\""+this.lastRow[i].item.type+"\"";
      this.exportString+=">";
      if( this.lastRow[i].value != null ) this.exportString+=encodeTextForXML(this.lastRow[i].value);
      this.exportString+="</FIELD>"+this.newLine;
    }
    this.exportString+="</RECORD>"+this.newLine;
  }
  else if(this.format=="xmls"){
    if(zoneid && zoneid.indexOf("report")>=0){
      this.exportString+=getXMLRow(Strtran(this.fielddesc[this.fieldsuid[curindex]]," ",""),this.lastRow[curindex].value);
      this.exportString+=this.newLine;
    }
    else{
      var grp = "<SECTION EXPRESSION=\""+this.obj.groupbreak.items.toString()+"\">";
      this.exportString+=grp+this.newLine;
      if(this.lastGrp.groupheader){
        keys = Object.keys(this.lastGrp.groupheader);
        for(j=0; j<keys.length; j++){
          this.exportString+=getXMLRow(Strtran(this.fielddesc[this.fieldsuid[parseInt(keys[j])]]," ",""),this.lastGrp.groupheader[keys[j]][0]);
          this.exportString+=this.newLine;
        }
      }
      if(this.lastGrp.groupbody){
        keys = Object.keys(this.lastGrp.groupbody);
        var dlen = this.lastGrp.groupbody[keys[0]].length;
        for(i=0; i<dlen; i++){
          this.exportString+="<DETAIL>"+this.newLine;
          for(j=0; j<keys.length; j++){
            this.exportString+=getXMLRow(Strtran(this.fielddesc[this.fieldsuid[parseInt(keys[j])]]," ",""),this.lastGrp.groupbody[keys[j]][i]);
            this.exportString+=this.newLine;
          }
          this.exportString+="</DETAIL>"+this.newLine;
        }
      }
      if(this.lastGrp.groupfooter){
        keys = Object.keys(this.lastGrp.groupfooter);
        for(j=0; j<keys.length; j++){
          this.exportString+=getXMLRow(Strtran(this.fielddesc[this.fieldsuid[parseInt(keys[j])]]," ",""),this.lastGrp.groupfooter[keys[j]][0]);
          this.exportString+=this.newLine;
        }
      }
      this.exportString+="</SECTION>"+this.newLine;
    }
  }
}

RepDocumentText.prototype.pageNumber = function(){
}

RepDocumentText.prototype.removeLastLabelContinue = function(){
}

RepDocumentText.prototype.addLicense = function(){
}

RepDocumentText.prototype.download = function () {
  var mUrl,
  a = document.createElement('a');
  document.body.appendChild(a);
  a.style.display = "none";
  var ext = ".";
  if(this.format=="csvs" || this.format=="csv")
    ext+="csv";
  else if(this.format=="csv2")
    ext+="txt";
  else if(this.format.indexOf("xml")>=0)
    ext+="xml";
  var filename = (Empty(this.name) ? LibJavascript.AlfaKeyGen(10) : this.name) + ext,
  _Blob = getBlob();
  if(typeof a.download == "undefined"){
    if (navigator.msSaveBlob) {
      var csvData;
      if(this.format.indexOf("xml")>=0) {
        csvData = new _Blob(["\ufeff", this.exportString], {type: 'text/xml;charset=utf-8;'});
      }
      else {
        csvData = new _Blob(["\ufeff", this.exportString], {type: 'text/csv;charset=utf-8;'});
      }
      //navigator.msSaveBlob("\ufeff", csvData, filename);
      navigator.msSaveOrOpenBlob(csvData, filename);
    }
    else {
      (window.PSAlert||window).alert('Browser Not Implemented Client Side Download!!!');
    }
  }
  else {
    var typeApp = 'text/';
    if(this.format.indexOf("csv")>=0)
      typeApp+="csv";
    else // xml
      typeApp+="xml";
    typeApp += ';charset=utf-8;';
    var mData = new _Blob(["\ufeff", this.exportString], {type: typeApp});
    if (IsEdge()) {
      // https://developer.microsoft.com/en-us/microsoft-edge/platform/issues/7260192/
      navigator.msSaveOrOpenBlob(mData, filename);
    }
    else {
      mUrl = URL.createObjectURL(mData);
      a.href = mUrl;
      a.download = filename;
      a.click();
    }
    document.body.removeChild(a);
  }
};

RepDocumentText.prototype.drawPreviewValidator = function () {};

RepDocumentText.prototype.printPreview = function () {
  var _Blob = getBlob(),
  mData = new _Blob(["\ufeff", this.exportString], {type: 'text/xml;charset=utf-8;'}),
  mUrl = URL.createObjectURL(mData);  
  windowOpenForeground(mUrl, "", "left=50,top=50,status=no,toolbar=no,menubar=no,location=no,resizable=yes", null, null, null, 2)
};

function convertCsv(tmp, separator) {
  // riporto codice RPGenCSV
  var newLineWin = "\n",
  newLineLin = "\r",
  dblQuote = "\"";
  tmp = Strtran(tmp, dblQuote, (dblQuote + dblQuote));
  tmp = Strtran(tmp, newLineLin, newLineWin);
  if (tmp.indexOf(separator) >= 0 || tmp.indexOf(newLineWin) >= 0 || tmp.indexOf(dblQuote) >= 0)
    tmp = JSON.stringify(tmp);
  return tmp;
}

function encodeSpecialCharsXML(myString){
  var ret = myString.replace(/[^a-zA-Z0-9._-]/g, "");
  ret = Strtran(ret, " ", "");
  /*ret = Strtran(ret, "&", "");
  ret = Strtran(ret, "<", "");
  ret = Strtran(ret, ">", "");
  ret = Strtran(ret, "\"", "");
  ret = Strtran(ret, "'", "");
  ret = Strtran(ret, "\\r", "");
  ret = Strtran(ret, "(", "");
  ret = Strtran(ret, ")", "");
  ret = Strtran(ret, "=", "");
  ret = Strtran(ret, ",", "");
  ret = Strtran(ret, ":", "");
  ret = Strtran(ret, "*", "");
  ret = Strtran(ret, "%", "");
  ret = Strtran(ret, "_", "");
  ret = Strtran(ret, "+", "");
  ret = Strtran(ret, "/", "");
  ret = Strtran(ret, "\\", "");
  ret = Strtran(ret, "#", "");*/
  return ret;
}

function encodeTextForXML(myString){
  var str = myString;
  var res = '';
  var i;
  for(i = 0; i < str.length; i++){
      if(+str[i] || str[i].toLowerCase() !== str[i].toUpperCase()){
         res += str[i];
         continue;
      };
	  if((str[i] === '\r'))
		  res +='';
	  else if((str[i] === '<') || (str[i] === '>') || (str[i] === '/') || (str[i] === '&') || (str[i] === '\'') || (str[i] === '\"') || (str[i] === '\n') || (str[i] === ' ') || (str[i].charCodeAt(0) > 128) )
		res += '&#'+str[i].charCodeAt(0)+';';
	  else
		res += str[i];
  };
  return res;
}