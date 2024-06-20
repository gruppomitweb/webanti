/* global getFieldsList getFieldsObjList getFieldsDescMap XLSX */

/*jshint laxcomma: true */
/*** CLASSE RepDocumentXlsx: gestisce la generazione/export del documento (report) in formato xls/xlsx
  * Eredita da RepDocument - JSReportDocumentRuntime.js
*/
RepDocumentXlsx = function (name, uid, format) {
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
  this.fieldsuid = [];
  this.dtpict = {};
  this.exportCells = [];
  this.widthCells = [];
  this.__sst = false;
};

RepDocumentXlsx.prototype = new RepDocument();
RepDocumentXlsx.prototype.constructor = RepDocumentXlsx;

RepDocumentXlsx.prototype.Ctrl = function(id){
  return this.document.getElementById(id);
};

RepDocumentXlsx.prototype.initProcess = function(allfields,container,bprint,imgfields,simulatedData){
  this.container = container;
  this.setParent();
  this.setDocument();
  this.setWindow();
  this.allfields = allfields;
  this.simulatedData = simulatedData;
  this.fieldsuid = getFieldsList(this.obj);
  this.fieldsobjs = getFieldsObjList(this.obj);
  this.fielddesc = getFieldsDescMap(this.obj);
  this.initLastRow();
  this.lastGrp = [];
  this.lastRec = [];
  this.writeHeader();
};

RepDocumentXlsx.prototype.initLastRow = function(){
  this.lastRow = [];
  for(var i=0; i<this.fieldsuid.length; i++){
    this.lastRow.push({});
  }
}

RepDocumentXlsx.prototype.endProcess = function(){
  this.end = true;
  this.writeRow();
  this.writeFooter();
  this.download();
};

RepDocumentXlsx.prototype.drawCover = function(/*coverobj*/){
};

RepDocumentXlsx.prototype.startLoading = function(){
}

RepDocumentXlsx.prototype.updateLoading = function(){
}

RepDocumentXlsx.prototype.appendFontsInDocument = function () {
}

RepDocumentXlsx.prototype.setLimitPage = function(){
  this.gwork.limitpage = Infinity;
}

RepDocumentXlsx.prototype.newPage = function(k,firstpage){
  if(Empty(firstpage) && this.obj.showPageZone){
    this.drawZone(k,'pagefooter','',false,true);
    this.drawZone(k,'pageheader','',false);
  }
}

RepDocumentXlsx.prototype.getLastChildElement = function(){
  return {};
}

RepDocumentXlsx.prototype.addCurrentZone = function(){
}

RepDocumentXlsx.prototype.checkLimitPage = function(){
  return false;
}

RepDocumentXlsx.prototype.splitStringCheck = function(){
  return false;
}

RepDocumentXlsx.prototype.updateZoneHeight = function(){
}

RepDocumentXlsx.prototype.writeHeader = function(){
    var i, j, item;
    var tmp = "",
      _cells = [];
  if( this.obj.pivot ) {
    var items = this.obj.groupheader.items; 
    for ( i=items.length-1; i>=0; i-- ) {
      item = items[i];
      if( item.alias == 'lbl_columns') {
        for( j=0; j<this.obj.pivot.rows.length; j++ ) {
           if(!this.widthCells[j])  this.widthCells[j]= 0;
           this.widthCells[j] = Math.max(this.widthCells[j], 0);
          _cells.push( { t: 's', v: '' , s:{font:{bold:true}}} )
        }
        tmp=item.value;
        _cells.push( { t: 's', v: tmp , s:{font:{bold:true}}} )  // testo
        if(!this.widthCells[j])  this.widthCells[j]= 0;
           this.widthCells[j] = Math.max(this.widthCells[j], tmp.length);
        this.exportCells.push(_cells);
        i = -1;
      }
    }
    _cells = [];
    for ( i=0; i<items.length; i++ ) {
      item = items[i];
      if( item.alias == 'lbl_columns') {
        i = items.length;
      }
      else {
        item.colIdx = this.fieldsuid.indexOf('fld_tgroupbody'+item.alias);
        if( item.colIdx == 0 ) {
          if( _cells.length > 0) this.exportCells.push(_cells);
          _cells = [];
        }
        tmp=item.value;
        _cells.push( { t: 's', v: tmp , s:{font:{bold:true}}} )  // testo
        if(!this.widthCells[item.colIdx])  this.widthCells[item.colIdx]= 0;
        this.widthCells[item.colIdx] = Math.max(this.widthCells[item.colIdx], tmp.length);
      }
    }
    if( _cells.length > 0) this.exportCells.push(_cells);
  }
  else {
    if((this.fieldsuid.length > 0)){
      for(i=0; i<this.fieldsuid.length; i++){
        tmp=""+this.fielddesc[this.fieldsuid[i]];
        _cells.push( { t: 's', v: tmp } )  // testo
        if(!this.widthCells[i])  this.widthCells[i]= 0;
        this.widthCells[i] = Math.max(this.widthCells[i], tmp.length);
      }
      this.exportCells.push(_cells);
    }
  }
}

RepDocumentXlsx.prototype.writeFooter = function(){
}

RepDocumentXlsx.prototype.getItemValue = function(k,item,zoneid,repObj,useLastRecord){
  if(item.type!="field" || (item.fieldDetail && Empty(item.fieldDetail.alias)))
    return "";
  var value,
  mdata = useLastRecord?repObj.lastRec:repObj.propertyValue[k];
  if(item.typeView.indexOf("date")>=0 && !Empty(mdata[item.fieldDetail.alias])){
    value = mdata[item.fieldDetail.alias].toISOString();
    value = new Date(value);
    this.setDateTimePicture(item);
  }
  else if(item.typeView=="numeric"){
    if(item.calculation && item.calculation.type!='none')
      value = repObj.calcObjs[item.fieldDetail.alias][item.uid];
    else
      value = mdata[item.fieldDetail.alias];
  }
  else {
    value = mdata[item.fieldDetail.alias];
  }
  return value;
};

RepDocumentXlsx.prototype.setDateTimePicture = function (item) {
  if (!Empty(this.dtpict[item.uid]))
    return;
  var sptolib = {};
  sptolib["dd-mm-yyyy"] = "dd-mm-yyyy";
  sptolib["dd/mm/yyyy"] = "dd/mm/yyyy";
  sptolib["yyyy-mm-dd"] = "yyyy-mm-dd";
  sptolib["yyyy/mm/dd"] = "yyyy/mm/dd";
  sptolib["hh:mm"] = "hh:mm";
  sptolib["hh:mm:ss"] = "hh:mm:ss";
  sptolib["hh.mm"] = sptolib["hh:mm"];  // non supportato da lib
  sptolib["hh.mm.ss"] = sptolib["hh.mm.ss"]; // non supportato da lib
  sptolib["dd-mm-YYYY hh:mm:ss"] = sptolib["dd-mm-yyyy"] + " " + sptolib["hh:mm:ss"];
  
  if (!item.picture && item.stdPicture)
    this.dtpict[item.uid] = sptolib[item.stdPicture.toLowerCase()];
  else if (item.picture) {
    if (item.picture.dateformat) this.dtpict[item.uid] = sptolib[item.picture.dateformat.toLowerCase()];
    if (item.picture.timeformat) this.dtpict[item.uid] += " " + sptolib[item.picture.timeformat.toLowerCase()];
  }
  else
    this.dtpict[item.uid] = sptolib["dd-mm-yyyy"];
}

RepDocumentXlsx.prototype.isEoPreview = function () {
  return false;
}

RepDocumentXlsx.prototype.addItemInZone = function (k, item, objzone, zoneid, value/*,yRel*/) {
  var curindex = this.fieldsuid.indexOf(item.uid);
  if (curindex >= 0) {
    if( value == null ) value = '';
    if (this.grpBreak) {
      this.resetRow(curindex);
      this.grpBreak = false;
    }
    if ((curindex < this.lastElement) || ((curindex == this.lastElement) && this.fieldsuid.length == 1))
      this.writeRow();
    if (zoneid.indexOf("page") >= 0)
      value = "";
    
    if (item.typeView.indexOf("date") >= 0) {
      // memorizzo valore raw della data
      var oneDay = 24 * 60 * 60 * 1000,
      secondDate = new Date(1900, 0, 1),
      firstDate  = value;
      if (!Empty(value)) {
        var diffDays = ((firstDate - secondDate) / oneDay),
        _1900b = new Date(1900,1,28,23,59,59,999),
        tz_1 = Math.round(firstDate.getTimezoneOffset() / 60),
        tz_2 = Math.round(secondDate.getTimezoneOffset() / 60);
        if (tz_1 != tz_2) {
          // test timezone
          var diffHrs = Math.abs(tz_1) - Math.abs(tz_2),
          factor = tz_1 < 0 ? -1 : 1;
          secondDate = new Date(secondDate.getTime() + (factor * diffHrs * 60 * 60 * 1000));
          diffDays = ((firstDate - secondDate) / oneDay);
        }
        if (value.getTime() > _1900b.getTime()) {
          // excel 1900 leap year bug
          diffDays = diffDays + 1;
        }
        diffDays = diffDays + 1; // +1 conteggio anche 1gen1900

        var sp_pict = "";
        if (!item.picture && item.stdPicture)
          sp_pict = item.stdPicture;
        else if (item.picture) {
          if (item.picture.dateformat) sp_pict = item.picture.dateformat;
          if (item.picture.timeformat) sp_pict += " " + item.picture.timeformat.toLowerCase();
        }
        this.lastRow[curindex] = { t: 'n', v: diffDays, z: this.dtpict[item.uid], w: Format(value, null, null, sp_pict) };  // d-dt
        if(!this.widthCells[curindex])  this.widthCells[curindex]= 0;
           this.widthCells[curindex] = Math.max(this.widthCells[curindex], this.lastRow[curindex].w.length);
      }
      else {
        this.lastRow[curindex] = { t: 'n', v: '', z: '', w: '' }; // data empty
        if(!this.widthCells[curindex])  this.widthCells[curindex]= 0;
           this.widthCells[curindex] = Math.max(this.widthCells[curindex], this.lastRow[curindex].w.length);
      }
    }
    else if (item.typeView == "numeric") {
      this.lastRow[curindex] = { t: 'n', v: value };  // num
      if(!this.widthCells[curindex])  this.widthCells[curindex]= 0;
      this.widthCells[curindex] = Math.max(this.widthCells[curindex], "99999.999".length);
    }
    else {
      if (this.format == "xls" && !this.__sst && value!=null && value.length > 255)
        this.__sst = true;
      this.lastRow[curindex] = { t: 's', v: value };  // txt
      if(!this.widthCells[curindex])  this.widthCells[curindex]= 0;
      this.widthCells[curindex] = Math.max(this.widthCells[curindex], value.length);
    }
    this.lastElement = curindex;
  }
};

RepDocumentXlsx.prototype.resetRow = function(fromidx){
  for(var i=fromidx; i<this.lastRow.length; i++) {
    this.lastRow[i] = {};
  }

}

RepDocumentXlsx.prototype.writeRow = function(){
  if (this.lastRow.length > 0) {
    var _cells = JSON.stringify(this.lastRow);
    this.exportCells.push(JSON.parse(_cells));
  }
}

RepDocumentXlsx.prototype.pageNumber = function(){
}

RepDocumentXlsx.prototype.removeLastLabelContinue = function(){
}

RepDocumentXlsx.prototype.addLicense = function(){
}

RepDocumentXlsx.prototype.download = function () {
  /*js-xlsx*/
  var ext = "." + this.format, i,
  downloadname = (Empty(this.name) ? LibJavascript.AlfaKeyGen(10) : this.name) + ext,
  ws, wb;
  wb = XLSX.utils.book_new();
  if (this.format == "xls" && this.exportCells.length > 65536) // formato xls non supporta 65.536+ righe
    ws = XLSX.utils.aoa_to_sheet(this.exportCells.slice(0, 65536));
  else
    ws = XLSX.utils.aoa_to_sheet(this.exportCells);

  XLSX.utils.book_append_sheet(wb, ws, 'Doc 1');
  var wscols = [];
  for( i=0; i< this.widthCells.length; i++ ) {
    if( !this.widthCells[i]) 
      wscols.push(null)
    else {
      wscols.push({wch:this.widthCells[i]})
    }
  }
  wb["Sheets"]["Doc 1"]['!cols'] = wscols;
  var opts = { raw: true, cellDates: true, dateNF: this.dtpict };
  if (this.format == "xls" && this.__sst) // xls non supporta di default stringhe > 255; imposto tipo long string (+ lento in mem)
    opts.bookSST = true;
  XLSX.writeFile(wb, downloadname, opts);
};

RepDocumentXlsx.prototype.drawPreviewValidator = function () {
};

