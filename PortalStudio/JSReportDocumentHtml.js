/*  global generateBarcode docSettings ToStringHTML setCurrentDateTime
    drawIconField
 */

/*jshint laxcomma: true */
/*** CLASSE RepDocumentHtml: gestisce la generazione/disegno del documento (report) in formato html
  * Eredita da RepDocument - JSReportDocumentRuntime.js
*/
RepDocumentHtml = function (name, uid) {
  RepDocument.call(this);
  this.format = "html";
  this.gcurrpage = null;
  this.name = name;
  this.progrid = 0;
  this.datetime = new Date();
  if(Empty(uid)) uid = LibJavascript.AlfaKeyGen(5);
  this.uid = uid;
  this.parent = null;
  this.document = null;
  this.window = null;
  this.barcodesItems = [];
  this.barcodesCtrls = [];
};
RepDocumentHtml.prototype = new RepDocument();
RepDocumentHtml.prototype.constructor = RepDocumentHtml;

RepDocumentHtml.prototype.Ctrl = function(id){
    return this.document.getElementById(id);
};

RepDocumentHtml.prototype.initProcess = function(allfields,container,bprint,imgfields,simulatedData){
  this.container = container;
  this.setParent();
  this.setDocument();
  this.setWindow();
  this.parent.innerHTML="";
  if(window.tool && window.tool=='smartreport'){
    if(window.winitprocess) window.winitprocess();
  }
  this.allfields = allfields;
  this.imgfields = imgfields;
  this.mrows = 0;
  this.lastRec = null;
  this.progrid = 0;
  this.simulatedData = simulatedData;
};

RepDocumentHtml.prototype.appendFontsInDocument = function () {
  var list = this._fontList;
  this._cssString = "";
  for (var i = 0; i < list.length; i++)
    this._cssString += "<link type='text/css' rel='STYLESHEET' href='../fonts/" + window._fontMap[list[i]].css + ".css'>";
  this.document.head.innerHTML += this._cssString;
}

RepDocumentHtml.prototype.endProcess = function(){
  for(var i=0; i<this.barcodesItems.length; i++) {
    var item = this.barcodesItems[i];
    var ctrl = this.barcodesCtrls[i];
    generateBarcode(item, ctrl.getAttribute("data-value"), ctrl, item.position.width,  item.position.height);
    if (!Empty(item._newWidth)) {
      item.position.width = item._newWidth;
      this.Ctrl(ctrl.parentElement.id).style.width = item._newWidth + "px";
    }
  }

  this.removeLoading();

  if(window.tool && window.tool=='smartreport'){
    if(window.wendprocess) window.wendprocess();
  }
  else
    this.removeAllSignatureMarkups();

  if (window.tool && window.tool=='smartreport'){}
  else {
    var w, h, tmp;
    if (docSettings && docSettings[this.obj.page.format]) { // sono in pt
      w = docSettings[this.obj.page.format].w;
      h = docSettings[this.obj.page.format].h;
    }
    else if (this.obj.page.format == "custom") {
      w = this.obj.page.width + "mm";
      h = this.obj.page.height + "mm";
    }
    else { //A4 
      w = '595pt';
      h = '842pt';
    }
    if (this.obj.page.orientation == "landscape") {
      tmp = w;
      w = h;
      h = tmp;
    }

    //var hprint = (parseFloat(h) - 1) + (this.obj.page.format == "custom" ? "mm" : "pt"),
    var stylehead = "";
    stylehead += "<style type=\"text/css\">.imagePrintclass a::after{content:'\\ec0b'}</style>";
    stylehead += "<style type=\"text/css\" media=\"screen\"> ";
    stylehead += "body {background-color:rgb(82,86,89);overflow:hidden;margin:0px 0px 0px 0px;} ";
    stylehead += ".report {height:100%;width:100%;overflow:hidden} ";
    // stylehead += ".contentZone {position:relative;width:" + w + ";height:" + h + ";margin:5px auto;background-color:#FFFFFF} ";
    stylehead += ".contentZone {position:relative;background-color:#FFFFFF} ";
    stylehead += ".pgbreak {} ";
    stylehead += ".toolbar {position:fixed;z-index:9999;text-align:center;height:48px;width:100%;background-color:rgb(50, 54, 57);box-shadow:rgba(0, 0, 0, 0.14) 0px 2px 2px 0px, rgba(0, 0, 0, 0.12) 0px 1px 5px 0px, rgba(0, 0, 0, 0.2) 0px 3px 1px -2px} ";
    stylehead += ".ptextbox { border-bottom: 1px solid #b1b1b1; text-align: right; outline: 0; max-width: 40px; } ";
    stylehead += ".pagecontainer {position:absolute;top:50px;width:100%;height:calc(100% - 50px);overflow:auto;background-color:#A0A0A0;} ";
    stylehead += "</style>";
    stylehead += "<style type=\"text/css\" media=\"print\"> ";
    stylehead += '@page {' +
                // 'size: ' +  w +  ' ' + h + '; ' +
                 'margin: 0pt; padding: 0pt; border: 0pt solid transparent; ' +
                 'border: 0pt solid transparent; ' +
                 '@top-left-corner,    @top-left,    @top-center,    @top-right, @top-right-corner, ' +
                 '@right-top, @right-middle, @right-bottom, ' +
                 '@bottom-left-corner, @bottom-left, @bottom-center, @bottom-right, @bottom-right-corner, ' +
                 '@left-top, @left-middle, @left-bottom {' +
                   'content: ""; display: inline-block; height: 0px; overflow: hidden;' +
                   'margin: 0pt; padding: 0pt; border: 0pt solid transparent;' +
                 '}' +
                '}';
    stylehead += "* { margin: 0px; padding: 0px; border: 0px solid transparent; box-sizing: border-box; } ";
    stylehead += "body {overflow-x:hidden; width:" + w + "; margin:0px 0px 0px 0px; overflow:hidden} ";
    stylehead += ".toolbar {display:none} ";
    stylehead += ".pagecontainer {} ";
    stylehead += ".pgbreak {} ";
    stylehead += ".imagePrintclass {display:none} ";
    stylehead += ".report {} ";
    // stylehead += ".contentZone {margin:0px;position:relative;width:" + w + ";height:" + hprint + ";} ";
    stylehead += ".contentZone {margin:0px;position:relative;} ";
    stylehead += "</style>";
    
    if (this.theme) {
      stylehead+="<link type='text/css' rel='STYLESHEET' href='../" + this.theme + "/portalstudio.css'>"
      stylehead+="<link type='text/css' rel='STYLESHEET' href='../" + this.theme + "/formPage.css'>"
      stylehead+="<script src='../"+this.theme+"/webReport.js'></script>"
    }

    if (!Empty(this._cssString))
      stylehead += this._cssString;

    var mhtml = this.parent.innerHTML,
    inHTML = "";
    if(this.container.tagName.toLowerCase() != "iframe"){
      this.parent.innerHTML = "";
      this.setIFrame();
      this.setParent(document.getElementById(this.container.id+"ifrprev"));
      this.setDocument(document.getElementById(this.container.id+"ifrprev").contentWindow.document);
      this.setWindow(document.getElementById(this.container.id+"ifrprev").contentWindow);
      this.document.head.innerHTML = stylehead;

      inHTML = "<div class='report'>";
      inHTML+= "<div class='toolbar'>"
      inHTML+= "<div style='left:0px;position:absolute;margin:12px 12px 12px 16px;'><span style='color:#ffffff' class='label'>[smrname]</span></div>"
      inHTML+= "<div style='display: inline-block;'><div style='float:left;margin-top:12px;'>"
      inHTML+= "<input style='display:none;color:#ffffff' id='pagenumber' type='number' min='0' size='3' value='1' maxlength='5' class='textbox ptextbox'>"
      inHTML+= "</div><div style='float:left;margin:12px 5px 5px 5px;'><span style='display:none;color:#ffffff'>/</span><span id='pagenumberMax' class='label' style='color:#ffffff;position:relative;'>[nmax]</span></div></div>"
      inHTML+= "<div onclick='window.print()' style='float:right;cursor:pointer;margin:12px 16px 12px 12px;' id='_cTEMSRBNQPR_imagePrint' class='imagePrintclass'>"
      inHTML+= "<a style='text-decoration: none;font-size:20px;font-family:icons8_win10;font-weight:normal;color:rgba(0,0,0,.93);color:#ffffff'></a>"
      inHTML+= "</div>"
      inHTML+= '</div>'; //toolbar
      inHTML+= "<div class='pagecontainer'>"
      inHTML+= mhtml;
      inHTML+= '</div>';//pagecontainer
      inHTML+= '</div>';//report
      //this.document.body.innerHTML = mhtml;
      inHTML = Strtran(inHTML, "[smrname]", this.name);
      inHTML = Strtran(inHTML, "[nmax]",'[ ' +  ((this.isPreview && this.isEoPreview()) ? this.gwork.rpagecounter : this.gwork.pagecounter ) + ' pages ]');
      this.document.body.innerHTML = inHTML;
      document.getElementById(this.container.id+"ifrprev").height = "100%";
      document.getElementById(this.container.id+"ifrprev").frameborder = 0;
      document.getElementById(this.container.id+"ifrprev").style.border = 0;
      document.getElementById(this.container.id+"ifrprev").allowTransparency = true;
      document.getElementById(this.container.id+"ifrprev").style.backgroundColor = "rgb(82,86,89)";
      this.parent.style.border = 0;
      this.parent.style.margin = 0;
      this.parent.style.overflow = "hidden";
    }
    else{
      if(Empty(this.container.style.backgroundColor))
        this.container.style.backgroundColor = "rgb(82,86,89)";
    }
  }
  this.end = true;
  this.removeCanvasImages();

  var ifr = document.getElementById(this.container.id+"ifrprev");
  if (ifr) {
    ifr.onload = function () {
      // tutela nel caso l'iframe non si sia ancora caricato
      this.contentWindow.document.head.innerHTML = stylehead;
      this.contentWindow.document.body.innerHTML = inHTML;
    }
  }

  this.execFncCallback();
};

RepDocumentHtml.prototype.removeLastLabelContinue = function(){
  var toremove = [];
  var i;
  var lblco = this.document.getElementsByClassName("labelcontinue_gf");
  for(i=0; i<lblco.length; i++){
    toremove.push(lblco[i]);
  }
  var lblc = this.document.getElementsByClassName("labelcontinue_pf");
  for(i=0; i<lblc.length; i++){
    if(lblc[i].parentNode.id.indexOf("zpagem"+this.gwork.rpagecounter)>=0)
      toremove.push(lblc[i]);
  }
  for(i=0; i<toremove.length; i++){
    if(toremove[i])
      toremove[i].parentNode.removeChild(toremove[i]);
  }
};

RepDocumentHtml.prototype.removeAllSignatureMarkups = function(){
  var toremove = [];
  var i;
  var lblco = this.document.getElementsByClassName("signmup");
  for(i=0; i<lblco.length; i++){
    toremove.push(lblco[i]);
  }
  for(i=0; i<toremove.length; i++){
    if(toremove[i])
      toremove[i].parentNode.removeChild(toremove[i]);
  }
};

RepDocumentHtml.prototype.pageNumber = function(){
  var lz = this.document.getElementsByClassName("pagenumber");
  var pp, p;
  for(var i=0; i<lz.length; i++){
    p = lz[i];
    while(p.parentNode && p.parentNode.id.indexOf('page')!==0){
      p=p.parentNode;
    }
    p=p.parentNode;
    //if(this.Ctrl(lz[i].id+'_int').innerHTML.indexOf('[')>=0)
    pp = parseInt(Strtran(p.id,'page','')) + this.gwork.pagecounter - this.gwork.rpagecounter;
    if (this.isPreview && this.isEoPreview())
      pp = parseInt(Strtran(p.id,'page',''));
    this.Ctrl(lz[i].id+'_int').innerHTML = pp;//this.gwork.pagecounter
  }

  lz = this.document.getElementsByClassName("totalpages");
  for(i=0; i<lz.length; i++){
    pp = this.gwork.pagecounter;
    if (this.isPreview && this.isEoPreview())
      pp = this.gwork.rpagecounter;
    this.Ctrl(lz[i].id+'_int').innerHTML = pp;
  }
};

RepDocumentHtml.prototype.drawNewPage = function(firstpage){
  if(Empty(firstpage)){
    var p = this.document.createElement("p");
    p.style.pageBreakAfter='always';
    p.className = 'pgbreak';
    this.loadingDiv.parentNode.appendChild(p);
  }

  if(!Ctrl("page" + this.gwork.rpagecounter)) {
    var page = this.document.createElement("div");
    page.style.position='relative';
    page.style.width = "auto"; // this.gwork.ww+"px";
    page.style.height = (this.gwork.hh-2)+"px";
    page.style.backgroundColor="#FFFFFF";
    page.style.border ="1px solid #F3F3F3";
    page.id="page" + this.gwork.rpagecounter;
    page.className = "contentZone";
    this.loadingDiv.parentNode.appendChild(page);
    if(window.tool && window.tool=='smartreport'){
      if(window.fzoneclick) page.addEvent('click', window.fzoneclick);
      if(window.wpagegrid) window.wpagegrid(this.gwork); //grid
    }
    //grid end
    page = this.document.createElement("div");
    page.style.position='absolute';
    page.style.top=this.gwork.margint+"px";
    page.style.left=this.gwork.marginl+"px";
    page.style.width =  (this.gwork.ww-this.gwork.marginr-this.gwork.marginl)+"px";
    page.style.height =  (this.gwork.hh-this.gwork.margint-this.gwork.marginb)+"px";
    page.style.border ="0px solid #C3C3C3";
    page.id="zpagem" + this.gwork.rpagecounter;
    this.Ctrl("page" + this.gwork.rpagecounter).appendChild(page);
    this.gcurrpage = this.Ctrl("zpagem" + this.gwork.rpagecounter);
  }
  this.updateLoading();
};

RepDocumentHtml.prototype.getLastChildElement = function(){
  var mylc = {};
  if(this.gcurrpage && !Empty(this.gcurrpage.lastChild)){
    mylc.top = this.gcurrpage.lastChild.offsetTop;
    mylc.left = this.gcurrpage.lastChild.offsetLeft;
    mylc.width = this.gcurrpage.lastChild.offsetWidth;
    mylc.height = this.gcurrpage.lastChild.offsetHeight;
  }
  else {
    mylc.top = 0;
    mylc.left = 0;
    mylc.width = 0;
    mylc.height = 0;
  }
  return mylc;
};

RepDocumentHtml.prototype.addCurrentZone = function(objzone,zoneid,numrec){
  var zpage = this.document.createElement("div");
  zpage.style.position='relative';
  zpage.style.height =  objzone.height+"px";
  if(this.gcurrpage) {
    zpage.id=this.gcurrpage.id+zoneid+numrec;
    this.gcurrpage.appendChild(zpage);
  }
  if(zoneid=='groupbody')
    this.Ctrl(zpage.id).className += " bodyZoneZ";
};

RepDocumentHtml.prototype.updateZoneHeight = function(h){
  if(!Empty(this.gcurrpage.lastChild))
    this.gcurrpage.lastChild.style.height = (this.gcurrpage.lastChild.offsetHeight+h) + 'px';
};

RepDocumentHtml.prototype.updateFontProperties = function(stObj, rid){
  if (stObj.typeView == "image" || stObj.typeView == "barcode" || stObj.typeView == "html")
    return;
  if(stObj.type=="line") return;
  var cText = this.Ctrl(rid+"_int");
  if(stObj.style.font.bold)
    cText.style.fontWeight = "bold";
  else
    cText.style.fontWeight = "normal";
  if(stObj.style.font.italic)
    cText.style.fontStyle = "italic";
  else
    cText.style.fontStyle = "normal";
  cText.style.fontSize = stObj.style.font.fontSize;
  cText.style.fontFamily = stObj.style.font.fontName;

  var tmptext = "";
  if(stObj.style.font.underline)
    tmptext += "underline ";
  if(stObj.style.font.strikeout)
    tmptext += "line-through ";
  cText.style.textDecoration = tmptext;

  if(stObj.style.font.center)
    cText.style.textAlign = "center";
  else if(stObj.style.font.right)
    cText.style.textAlign = "right";
  else
    cText.style.textAlign = "left";

  cText.style.color = stObj.style.font.fontColor;
};

RepDocumentHtml.prototype.applyLineStyleProperties = function(item, rid){
  if(item.type!="line") return;
  if(!item.style.line.onlyStroke)
    this.Ctrl(rid).style.borderTop = item.position.height+"px solid " + item.style.line.color;
  else
    this.Ctrl(rid).style.border = "1px solid " + item.style.line.color;
  if(item.style.stretchToRight){
    var nl = this.gwork.ww - this.gwork.marginl - this.gwork.marginr - this.Ctrl(rid).offsetLeft;
    this.Ctrl(rid).style.width = nl + "px";
  }
};

RepDocumentHtml.prototype.initPage = function(coverobj) {
  this.newPage();
  if(!coverobj.numPageCover)
    this.gwork.pagecounter--;
}

RepDocumentHtml.prototype.generateHtmlElement = function(it){
  var ritem = {};
  ritem.id = 'item'+this.progrid;
  ritem.uidfor = it.uid;
  ritem.html = "";
  ritem.yRel = it.position.yRelative;
  if(it.type=="line"){
    ritem.html="<div ";
    ritem.html+="id='"+ritem.id+"' ";
    ritem.html+="class='unselectable lineItem' ";
    ritem.html+="style='";
    ritem.html+="left:"+it.position.x+"px;";
    ritem.html+="top:"+it.position.y+"px;";
    ritem.html+="width:"+it.position.width+"px;";
    if(!it.style.line.onlyStroke)
      ritem.html+="height:1px;";
    else
      ritem.html+="height:"+(it.position.height-2)+"px;";
    ritem.html+="position:absolute;";
    ritem.html+="'>";
    ritem.html+="</div>";
  }
  else if (it.typeView == "image" || it.typeView == "html"){
    ritem.html="<div ";
    ritem.html+="id='"+ritem.id+"' ";
    ritem.html+="class='unselectable labelFieldImg' ";
    ritem.html+="style='";
    ritem.html+="left:"+it.position.x+"px;";
    ritem.html+="top:"+it.position.y+"px;";
    if (it.fieldDetail && it.fieldDetail.type == "checkbox") {
      var size = Math.min(it.position.width, it.position.height);
      ritem.html+="width:"+size+"px;";
      ritem.html+="height:"+size+"px;";
    }
    else {
      ritem.html+="width:"+it.position.width+"px;";
      ritem.html+="height:"+it.position.height+"px;";
    }
    ritem.html+="'";
    ritem.html+=">";
    ritem.html+="<img ";
    ritem.html+="id='"+ritem.id+"_img' ";
    ritem.html+="class='unselectable' ";
    ritem.html+="alt='Image not found' ";
    ritem.html+="style='";
    ritem.html+="width:"+(100)+"%;";
    ritem.html+="height:"+(100)+"%;";
    ritem.html+="'";
    ritem.html+="/>";
    ritem.html+="</div>";
  }
  else if(it.typeView == "barcode"){
    ritem.html="<div ";
    ritem.html+="id='"+ritem.id+"' ";
    ritem.html+="class='unselectable labelFieldImg' ";
    ritem.html+="style='";
    ritem.html+="left:"+it.position.x+"px;";
    ritem.html+="top:"+it.position.y+"px;";
    ritem.html+="width:"+it.position.width+"px;";
    ritem.html+="height:"+it.position.height+"px;";
    ritem.html+="'";
    ritem.html+=">";
    ritem.html+="<svg ";  //"<img ";
    ritem.html+="id='"+ritem.id+"_barcode' ";
    ritem.html+="class='unselectable' ";
   // ritem.html+="style='";
   // ritem.html+="width:"+(100)+"%;";
   // ritem.html+="height:"+(100)+"%;";
   // ritem.html+="'";
    ritem.html+="/>";
    ritem.html+="</div>";
  }
  else{ // tutto cio' che e' testo
    ritem.html="<div ";
    ritem.html+="id='"+ritem.id+"' ";
    ritem.html+="class='unselectable labelFieldDesc";
    ritem.html+="' ";
    ritem.html+="style='";
    ritem.html+="left:"+it.position.x+"px;";
    ritem.html+="top:"+it.position.y+"px;";
    ritem.html+="width:"+it.position.width+"px;";
    ritem.html+="height:"+it.position.height+"px;";
    ritem.html+="'>";
    ritem.html+="<div ";
    ritem.html+="id='"+ritem.id+"_int' ";
    ritem.html+="class='unselectable labelFieldText textContainerDoc";
    ritem.html+="' ";
    ritem.html+=">";
    if(it.type=="label")
      ritem.html+=ToStringHTML(it.value);
    else if(it.typeView == "pagenum")
      ritem.html+="["+ToStringHTML(it.fieldDetail.desc)+"]";
    else
      ritem.html+=ToStringHTML(it.fieldDetail.desc);
    ritem.html+="</div>";
    ritem.html+="</div>";
  }
  this.progrid++;
  return ritem;
};

RepDocumentHtml.prototype.getItemValue = function(k, item, zoneid, repObj, useLastRecord){
  var value;
  var noprint = false;
  var mdata = useLastRecord?repObj.lastRec:repObj.propertyValue[k];

  if(zoneid == "groupfooter" && repObj.obj.groupfooter.options.printOnGroupBreak && !repObj.lastGrpFooter)
    noprint = true;

  if (item.typeView.indexOf("date") >= 0) {
    if(item.isGeneric)
      value = repObj.datetime;
    else if(mdata[item.fieldDetail.alias+'_pic']) 
      value = mdata[item.fieldDetail.alias+'_pic'];
    else
      value = mdata[item.fieldDetail.alias];
    value = setCurrentDateTime(value,item);
  }
  else if(item.typeView=="numeric"){
    if(item.calculation && item.calculation.type!='none') {
      value = repObj.calcObjs[item.fieldDetail.alias][item.uid];
      value = repObj.setFormatNumber(value,item.fieldDetail.len,item.fieldDetail.dec,item.stdPicture);
    }
    else if(mdata[item.fieldDetail.alias+'_pic']) 
        value = mdata[item.fieldDetail.alias+'_pic'];
    else {
      value = mdata[item.fieldDetail.alias];
      value = repObj.setFormatNumber(value,item.fieldDetail.len,item.fieldDetail.dec,item.stdPicture);
    }
  }
  else if(item.typeView=="image"){
    if (!item.isGeneric && repObj.simulatedData)
      value = "";
    else {
      if (item.isGeneric) {
        if (item.fieldDetail && item.fieldDetail.type == "checkbox")
          item.style.imageSrc = (Empty(mdata[item.fieldDetail.alias])) ? repObj.uncheckedSrc : repObj.checkedSrc;
        value = item.style.imageSrc;
      }
      else if (noprint)
        value = "";
      else
        value = mdata[item.fieldDetail.alias];
    }

    // tratto il caso src:tooltip che potrebbe arrivarmi da griglia o da query
    var dp_split = value.split(":");
    if (dp_split.length > 1)
      value = dp_split[0];
  }
  else if (item.typeView == "html") {
    if (!item.isGeneric && repObj.simulatedData)
      value = "";
    else {
      if (item.isGeneric) {
        if (item.fieldDetail && item.fieldDetail.type == "checkbox")
          item.style.imageSrc = (Empty(mdata[item.fieldDetail.alias])) ? repObj.uncheckedSrc : repObj.checkedSrc;
        value = item.style.imageSrc;
      }
      else if (noprint)
        value = "";
      else if(mdata[item.fieldDetail.alias+'_pic']) 
        value = mdata[item.fieldDetail.alias+'_pic'];
      else
        value = mdata[item.fieldDetail.alias];
    }
  }
  else if(item.type=='field' && !item.isGeneric) {
    if(mdata[item.fieldDetail.alias+'_pic']) 
        value = mdata[item.fieldDetail.alias+'_pic'];
    else
        value = Format(mdata[item.fieldDetail.alias],item.fieldDetail.len,item.fieldDetail.dec,item.stdPicture);
  }
  if(item.type=='field' && item.isGeneric && item.typeView!="pagenum" && item.typeView.indexOf("date")<0 && item.typeView!="image")
    value = item.fieldDetail.desc;

  if(noprint && item.type=='field' && !item.isGeneric && item.typeView!="image")
    value = "";

  if(item.type=='label')
    value = item.value;

  return value;
};

RepDocumentHtml.prototype.addItemInZone = function(k,item,objzone,zoneid, value, yRel, split, nrow){
  if(!this.gcurrpage)
    return;
  if( value == null )  value = '';
  var currpage = this.gcurrpage.lastChild;
  var ritem = null;
  if(typeof(split) == 'undefined') split = false;
  if(window.tool && window.tool=='smartreport'){
    if(window.waddinzone) ritem = window.waddinzone(item,zoneid,true,split,nrow);
  }
  if(Empty(ritem))
    ritem = this.generateHtmlElement(item);
  if(Empty(yRel)) yRel = ritem.yRel;
  currpage.innerHTML += ritem.html;
  this.Ctrl(ritem.id).style.position = 'absolute';
  if(item.style && item.style.line && item.style.line.onlyStroke) yRel = yRel - 2;
  this.Ctrl(ritem.id).style.top = yRel+"px";
  if(item.type!="line"){
    this.Ctrl(ritem.id).style.border = "1px"; //forzatura
    this.Ctrl(ritem.id).style.backgroundColor = 'transparent';
  }

  this.Ctrl(ritem.id).className += (" "+ritem.uidfor);

  if(item.typeView=="pagenum"){
    if(item.fieldDetail.desc == "Total pages")
      this.Ctrl(ritem.id).className += " totalpages";
    else if(item.fieldDetail.desc == "Page number")
      this.Ctrl(ritem.id).className += " pagenumber";
  }

  if(item.isContinue && zoneid == "pagefooter")
    this.Ctrl(ritem.id).className += " labelcontinue_pf";
  else if(item.isContinue && this.lastGrpFooter)
    this.Ctrl(ritem.id).className += " labelcontinue_gf";

  if(item.typeView == "signmup")
    this.Ctrl(ritem.id).className += " signmup";

  if(window.tool && window.tool=='smartreport'){
    if(window.wupdatehtmlitem) window.wupdatehtmlitem(item,ritem,this.gwork);
  }
  else{
    this.updateFontProperties(item, ritem.id);
    this.applyLineStyleProperties(item, ritem.id);
  }

  if(item.typeView=="barcode"){
    generateBarcode(item, value, this.Ctrl(ritem.id+"_barcode"), this.Ctrl(ritem.id+"_barcode").offsetWidth, this.Ctrl(ritem.id+"_barcode").offsetHeight, null, true);
    this.Ctrl(ritem.id+"_barcode").setAttribute("data-value", value);
    this.barcodesItems.push(item);
    this.barcodesCtrls.push(this.Ctrl(ritem.id+"_barcode"));
  }
  else if(item.typeView=="image"){
    var msrc = "";
    if(value.indexOf(this.rootApp)==0 || value.indexOf(this.rootAppB)==0|| Empty(value))
      msrc = value;
    else
      msrc = this.rootApp+value;
    this.Ctrl(ritem.id+"_img").src = msrc;
  }
  else if (item.typeView == "html") {
    var mvalue = item.style.htmlSrc;
    if (!item.isGeneric)
      mvalue = value;
    this.renderHTMLtoCanvas(item, mvalue, ritem.id);
  }
  else if(item.type!='line') {
    if(window.tool && window.tool=='smartreport'){
      this.Ctrl(ritem.id+'_int').innerHTML = ToStringHTML(value);
      if(item.calculation && item.calculation.type!='none')
        drawIconField("calc",ritem);
    }
    else {
      this.Ctrl(ritem.id+'_int').innerHTML = ToStringHTML(value);
    }
  }

  if(window.tool && window.tool=='smartreport'){
    if(split && nrow!=0)
      $(ritem.id).addClass("noclick");
  }
};

RepDocumentHtml.prototype.download = function () {
  var akey = LibJavascript.AlfaKeyGen(5);
  var a = document.createElement('a');
  a.setAttribute("id", akey);
  this.document.body.appendChild(a);
  if(typeof a.download == "undefined"){
    (window.PSAlert||window).alert('Browser Not Implemented Client Side Download!!!');
  }
  else{
    var base64doc = btoa(unescape(encodeURIComponent(this.document.documentElement.innerHTML)));
    a.href = 'data:text/html;base64,' + base64doc;
    a.download = (Empty(this.name)?LibJavascript.AlfaKeyGen(10):this.name)+".html";
    a.click();
  }
  document.body.removeChild(a);
};

RepDocumentHtml.prototype.getImageBase64 = function(imgid,src,w,h){
  var divId = "mspan_"+this.uid;
  var myDiv = this.Ctrl(divId);
  if(Empty(myDiv)){
    myDiv = this.document.createElement("div");
    myDiv.id = divId;
    this.document.body.appendChild(myDiv);
    myDiv.style.width=w+'px';
    myDiv.style.height=h+'px';
    myDiv.style.display='none';
    myDiv.style.position="absolute";
    myDiv.style.left="400px";
    myDiv.style.top="400px";
  }

  divId = this.uid+"_canvas_"+imgid;
  var canvas = this.Ctrl(divId);
  if(Empty(canvas)){
    canvas = this.document.createElement("CANVAS");
    canvas.id = divId;
    canvas.width = w;
    canvas.height = h;
    myDiv.appendChild(canvas);
  }

  var mimg = new Image();
  mimg.id = this.uid+"_image_"+imgid;
  myDiv.appendChild(mimg);

  var muid = this.uid;
  mimg.onload = function(){
    var ctx = window[muid].Ctrl(muid+"_canvas_"+imgid).getContext("2d");
    ctx.drawImage(this, 0, 0, this.width, this.height, 0, 0, w, h);
    var dataURL = window[muid].Ctrl(muid+"_canvas_"+imgid).toDataURL("image/png");
    window[muid].Ctrl(imgid).src = dataURL;
  };
  var msrc = "";
  if (src.indexOf(this.rootApp)==0 || src.indexOf(this.rootAppB)==0)
    msrc = src;
  else
    msrc = this.rootApp+src;
  mimg.src = msrc;
};

RepDocumentHtml.prototype.print = function(){
  if(!this.window.frameElement || this.window.frameElement.id!=this.container.id+"ifrprev")
    this.setWindow(document.getElementById(this.container.id+"ifrprev").contentWindow);
  if(this.window !== null){
    this.window.print();
  }
};

RepDocumentHtml.prototype.drawPreviewValidator = function () {
  if (this.isEoPreview())
    return;
  if (!Empty(this.watermark) && this.gcurrpage) {
    var div = this.document.createElement("div");
    div.className = "validatorPreviewLabel";
    div.textContent = this.watermark;
    div.style.top = - (this.gcurrpage.offsetHeight / 2) + "px";
    div.style.position = 'relative';
    div.style.transform = 'rotate(45deg)';
    div.style.fontSize = '24pt';
    div.style.color = '#E51400';
    div.style.fontWeight = 'bold';
    div.style.textAlign = 'center';
    div.style.fontFamily = 'Helvetica';
    div.style.zIndex =  1500;
    this.gcurrpage.appendChild(div);
  }
};
