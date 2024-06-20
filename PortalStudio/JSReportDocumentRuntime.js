/*  exported gwork JSRepDrawDocumentViewProvider convertPxToString setCurrentDateTime
    getFieldsList getFieldsObjList getFieldsDescMap ToStringHTML b64toBlob generateBarcode
    _DrawDocumentViewProvider getBlob
 */
/*  global gwork ArrayBuffer _srepFonts jspdffontMap
 */
/* inclusione js nei portlet jsp/SPSmartReportPrint,jsp-system/SPPortalZoomSmartPrint,smartreport/smartreport.jsp
    smartreport/promise-ie-polyfill.js
    visualweb/jszip.js
    visualweb/xlsx.js 
    visualweb/jspdf.js --> spostata inclusione in jsrepdocPDF
    visualweb/jspdf-more.js --> spostata inclusione in jsrepdocPDF
    visualweb/bcmath-min.js
    visualweb/pdf417.js
    visualweb/JsBarcode.all.js
    visualweb/qrcode2.js
    visualweb/html2canvas.js
*/

var docSettings = {
    A0:{w:"2383pt",h:"3370pt"},
    A1:{w:"1683pt",h:"2383pt"},
    A2:{w:"1190pt",h:"1683pt"},
    A3:{w:"842pt",h:"1190pt"},
    A4:{w:"595pt",h:"842pt"},
    A5:{w:"419pt",h:"595pt"},
    A6:{w:"297pt",h:"419pt"},
    A7:{w:"209pt",h:"297pt"},
    A8:{w:"147pt",h:"209pt"},
    A9:{w:"104pt",h:"147pt"},
    A10:{w:"73pt",h:"104pt"},
    letter:{w:"612pt",h:"792pt"},
    legal:{w:"612pt",h:"1008pt"},
    tabloid:{w:"792pt",h:"1224pt"}
};

function RepDocument(){
  this.gwork = {};
  this.propertyValue = [];
  this.allfields = [];
  this.mrows = 0;
  this.obj = {};
  this.calcObjs = {};
  this.lastRec = null;
  this.lastRecIndex = 0//-1;
  this.loadingDiv = null;
  this.container = null;
  this.lastGrpFooter = false;
  this.end = false;
  this.rootApp = "../";
  this.rootAppB = "..\\";
  this.imgfields = [];
  this.imgMap = [];
  this.optMapImg = [];
  this.mImages = 0;
  this.imgSrc = [];
  this.imgCount = 0;
  this.havnext = true;
  this.simulatedData = false;
  this.grpBreak = false;
  this.autoprint = false;
  this.autodownload = false;
  this.errorMessages = {
                          JSVRP_NODATA: "RPT_ERROR_NO_RECORD",
                          JSVRP_PRINTERR: "RPT_ERROR_GENERIC",
                          JSVRP_NOTFDATAS: "RPT_ERROR_NOTFOUND_FIELD"
                       };
  this.listMissingFields = [];
  this.rowsCounter = 0;
  this.limitDataPreview = 5;
  this.watermark = "";
  this.license = "";
  this.watermarkIsImage = false;
  this.managed = false;
  this.checkedSrc = "../smartreport/images/checked.png";
  this.uncheckedSrc = "../smartreport/images/unchecked.png"
}

RepDocument.prototype.beforeProcess = function(allfields,container,bprint,imgfields,simulatedData) {
  this.getAllFonts();
  this.initProcess(allfields,container,bprint,imgfields,simulatedData);
  
  this.appendFontsInDocument();
}

RepDocument.prototype.getAllFonts = function () {
  var list = getFontsFromObj(this.obj);
  if (window._fontMap) {
    var fkeys = Object.keys(window._fontMap),
    olist = fkeys.filter(function (font) {
      var tmpname = window._fontMap[font].name;
      if (window._fontMap[font].style != "normal") {
        if (window._fontMap[font].style == "bolditalic")
          tmpname += "_bold_italic";
        else
          tmpname += ("_" + window._fontMap[font].style);
      }
      return (list.indexOf(tmpname) >= 0);
    });
    this._fontList = olist;
  }  
}

RepDocument.prototype.initPage = function(/*coverobj*/) {
}

RepDocument.prototype.addLicense = function() {
  if (Empty(this.license))
    return;
  this.addCurrentZone({height:this.gwork.hh}, "license", this.gwork.rpagecounter)
  var item = {};
  item.uid = "sreport_license";
  item.type = "label";
  item.typeView = "text";
  item.value = this.license;

  item.position = {};
  item.position.x = 0;
  item.position.height = 6*96/72;
  item.position.y = this.gwork.hh - ((this.getLastChildElement() ? this.getLastChildElement().top : 0) + this.gwork.margint) - item.position.height - this.gwork.marginb;
  item.position.yRelative = item.position.y;
  item.position.width = this.gwork.ww;

  item.style = {};
  item.style.font = {};
  item.style.font.fontName = 'Helvetica';
  item.style.font.fontSize = '6pt';
  item.style.font.center = true;
  item.style.font.fontColor = "#000000";

  this.addItemInZone(null, item, "", "", this.license, item.position.y);
}

RepDocument.prototype.drawCover = function(coverobj){
  if(!coverobj || Empty(coverobj) || coverobj==null)
    return;
  if(!coverobj.coverPrint)
    return;
  if(!coverobj.objString || Empty(coverobj.objString) || coverobj.objString == null)
    return;
  try {
    var ypos = 20; // 40px
    var flist = JSON.parse(coverobj.objString);
    if(flist.length < 1)
      return;
    var firsty = -1;
    var lastzoomY = -1;
    var zoomX = 0;
    var c = 1;
    this.initPage(coverobj);
    this.addCurrentZone({height:this.gwork.hh}, "cover", c)
    c++;
    for(var k=0; k<flist.length; k++) {
      var obj = flist[k];
      var item = {};
      item.position = {};
      var x = obj.x;
      var y = obj.y;
      item.position.width = obj.w;
      item.position.height = obj.h;
      var type = obj.type;
      var value = obj.value;
      if(!value || value==null) value = "";

      if (firsty < 0) { firsty = y; }
      if (value == null) { value = ""; }
      if (type.toLowerCase() == "check") { /*y -= 3;*/ }
      if (type.toLowerCase() == "zoom" || type.toLowerCase() == "calendar") {
        if (y == lastzoomY) {
          zoomX += obj.w;
        }
        else {
          zoomX = obj.w;
          lastzoomY = y;
        }
        continue;
      }
      else if (obj.h <= 0 && obj.w >= 0) {
        if (y == lastzoomY) {
          zoomX += obj.w;
        }
      }

      if (obj.h <= 0 || obj.w <= 0) {
        continue;
      }
      if ( y == lastzoomY){
        x -= zoomX;
      }

      item.position.x = x;
      item.position.y = y + ypos - firsty;
      item.typeView = 'label';

      if(item.position.y + item.position.height > this.gwork.limitpage) {
        this.newPage();
        if(!coverobj.numPageCover)
          this.gwork.pagecounter--;

        this.addCurrentZone({height:0}, "cover", c)
        c++;
        firsty = y;
        item.position.y = y + ypos - firsty;
      }
      item.style = {};
      item.style.font = {};

      item.style.font.fontName = obj.font;
      item.style.font.fontSize = obj.fontSize;
      if ( type == 'check') {
        if(value == 'true') value = 'X';
        else value = '';
      }
      if( obj.align ) {
        if( obj.align == 'right' ) item.style.font.right = true;
        else item.style.font.right = false;
        if( obj.align == 'center' ) item.style.font.center = true;
        else item.style.font.center = false;
      }
      if ( type == 'label') item.style.font.italic = true;
      else item.style.font.italic = false;

      if ( type == 'group' ) item.style.font.bold = true;
      else item.style.font.bold = false;

      item.style.font.underline = false;
      item.style.font.strikeout = false;
      item.style.font.fontColor = "#000000";
      item.fieldDetail = {};
      item.fieldDetail.desc = value;
      this.addItemInZone(k,item,"","",value,ypos+item.position.y);
      var iteml, dims, xl, yl;
      if ( type == 'group' ) {
        iteml = {};
        iteml.position = {};
        dims = this.getTextDimensions(value, { name : item.style.font.fontName
                                             , size : item.style.font.fontSize
                                             , weight : item.style.font.bold ? 'bold' : 'normal'
                                             , italic : item.style.font.italic ? 'italic' : 'normal'
                                             });
        xl = item.position.x + dims.width + 10;
        yl = item.position.y + dims.height/2 + 1;
        iteml.position.x = xl;
        iteml.position.y = yl;
        iteml.position.height = 1;
        iteml.typeView = 'line';
        iteml.type = 'line';
        iteml.style = item.style;
        iteml.style.line = {};
        iteml.style.line.color = "#000000"
        var nl = this.gwork.ww - this.gwork.marginl - this.gwork.marginr - iteml.position.x;
        iteml.position.width = nl;
        iteml.fieldDetail = {};
        iteml.fieldDetail.desc = value;
        this.addItemInZone(k,iteml,"","","",ypos+iteml.position.y);
      }
      else if( type == 'check' ) {
        iteml = {};
        iteml.position = {};
        dims = this.getTextDimensions('X', { name : item.style.font.fontName
                                             , size : item.style.font.fontSize
                                             , weight : item.style.font.bold ? 'bold' : 'normal'
                                             , italic : item.style.font.italic ? 'italic' : 'normal'
                                             });
        xl = item.position.x;
        yl = item.position.y;
        iteml.position.x = xl;
        iteml.position.y = yl;
        iteml.position.height = dims.height;
        iteml.position.width = dims.width;
        iteml.typeView = 'line';
        iteml.type = 'line';
        iteml.style = item.style;
        iteml.style.line = {};
        iteml.style.line.color = "#000000"
        iteml.style.line.onlyStroke = true;
        iteml.fieldDetail = {};
        iteml.fieldDetail.desc = value;
        this.addItemInZone(k,iteml,"","","",ypos+iteml.position.y);
      }
    }
    this.newPage();
    if(!coverobj.numPageCover)
      this.gwork.pagecounter--;
  }
  catch (e) {
    console.error(e.stack);
  }
};

RepDocument.prototype.setGWork = function(obj){
  var w, h;
  if(docSettings && docSettings[obj.page.format]){
    w = docSettings[obj.page.format].w;
    h = docSettings[obj.page.format].h;
  }
  else{
    if(obj.page.format == 'custom') {
      w = obj.page.width + "mm"
      h = obj.page.height + "mm"
    }
    else if(window.jsPDFPageFormats && window.jsPDFPageFormats[obj.page.format]){
      w = window.jsPDFPageFormats[obj.page.format][0]+"pt";
      h = window.jsPDFPageFormats[obj.page.format][1]+"pt";
    }
    else { //A4
      w = '595pt';
      h = '842pt';
    }
  }
  var tmp;
  this.gwork={};
  if(obj.page.orientation=="landscape"){
    tmp = w;
    w = h;
    h = tmp;
  }
  this.gwork.ww = convertStringToPx(w);
  this.gwork.hh = convertStringToPx(h);

  this.gwork.marginr = convertStringToPx(obj.page.margins.right,this.gwork.ww);
  this.gwork.marginl = convertStringToPx(obj.page.margins.left,this.gwork.ww);
  this.gwork.margint = convertStringToPx(obj.page.margins.top,this.gwork.hh);
  this.gwork.marginb = convertStringToPx(obj.page.margins.bottom,this.gwork.hh);
  this.obj = obj;
  var zones = [];
  if(this.obj.showGroupZone)
    zones.push('groupfooter');
  if(this.obj.showPageZone)
    zones.push('pagefooter');
  if(this.obj.showReportZone)
    zones.push('reportfooter');
  //calcobjs - only footer
  for(var l=0; l<zones.length; l++){
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for(var k=0; k<melements.length; k++){
      if(melements[k].calculation && melements[k].calculation.type=='sum'){
        if(Empty(this.calcObjs[melements[k].fieldDetail.alias])) this.calcObjs[melements[k].fieldDetail.alias]={};
        this.calcObjs[melements[k].fieldDetail.alias][melements[k].uid]=0;
      }
    }
  }
  return this.gwork;
};

RepDocument.prototype.setLimitPage = function(){
  this.gwork.limitpage = (this.gwork.hh-this.gwork.marginb);
  if(this.obj.showGroupZone)
    if(this.obj.groupfooter.options.reprintOnPage)
      this.gwork.limitpage = this.gwork.limitpage - this.obj.groupfooter.height;
  if(this.obj.showPageZone)
    this.gwork.limitpage = this.gwork.limitpage - this.obj.pagefooter.height;

  if(!Empty(this.license)) {
    var dims = this.getTextDimensions(this.license, { name : 'Helvetica'
                                             , size : '6pt'
                                             , weight : 'normal'
                                             , italic : 'normal'
                                             });
    this.gwork.limitpage = this.gwork.limitpage - dims.height;
  }
};

RepDocument.prototype.newPage = function(k,firstpage){
  if (this.isEoPreview())
    return;

  if (Empty(firstpage)) {
    if(this.obj.showPageZone && k)
      this.drawZone(k,'pagefooter','',false,true);
    this.pageNumber();
    this.drawPreviewValidator();
    this.addLicense();
    this.gwork.pagecounter++;
    this.gwork.rpagecounter++;
  }

  if (this.isEoPreview())
    return;

  this.drawNewPage(firstpage);
  if(Empty(firstpage))
    if(this.obj.showPageZone && k)
      this.drawZone(k,'pageheader','',false);
};

RepDocument.prototype.getZoneElementsYMap=function(items){
  var ret = {};
  var item;
  for(var k=0;k<items.length; k++){
    item = items[k];
    if(!(ret[item.position.yRelative+'']))
      ret[item.position.yRelative+'']=[];
    ret[item.position.yRelative+''].push(item);
  }
  return ret;
};

RepDocument.prototype.getTextDimensions = function(text, font/*, itemwidth*/) {
    function cssSize (size, um) {
      /* '2pt'      -> '2pt'
      *  '2'        -> '2px'
      *   2         -> '2px'
      *  '2','pt'   -> '2pt'
      *   2 ,'pt'   -> '2pt'
      *  '2pt','px' -> '2pt'
      */
      var matches = ( '' + size ).match( /(-?\d+(?:\.\d*)?)(.*)/ ) || [ null, null, null ]
        , val = parseInt( matches[1], 10) || 0
        ;
      um = matches[2] || um || 'px';
      return val + um;
    } // cssSize
    /*http://stackoverflow.com/questions/118241/calculate-text-width-with-javascript*/
    var id = 'smartreportpdftxtmeter'
      , el = document.getElementById( id )
      ;
    if ( !el ) {
      el = document.createElement( id );
      el.id = id;
      el.style.display = 'inline-block';
      el.style.position = 'absolute';
      el.style.whiteSpace = 'pre'; /*mantiene whiteSpace*/
      el.style.visibility = 'hidden';
      el.style.height = 'auto';
      el.style.width = 'auto';
      document.body.appendChild( el );
    }
    el.textContent = text;
    el.style.fontFamily = font.name;
    el.style.fontStyle = font.style;
    el.style.fontWeight = font.weight;
    el.style.fontSize = cssSize( font.size, 'px' );
    return { width : el.clientWidth /*px*/
           , height: el.clientHeight /*px*/
           }
    ;
};

RepDocument.prototype.splitString = function(value, font, width, gap){
  var mvalue = value;
  var p = value.length;
  if(p-gap <=0) return value;
  value = value.substring(0, p-gap);
  var dim = this.getTextDimensions(value, { name : font.fontName
                                           , size : font.fontSize
                                           , weight : font.bold ? 'bold' : 'normal'
                                           , italic : font.italic ? 'italic' : 'normal'
                                           });
  if(dim.width<=width)
    return value;
  gap = gap + dim.width/width;
  return this.splitString (mvalue, font, width, gap);
}

RepDocument.prototype.drawZone = function(k,zoneid,numrec,check,useLastRecord){
  if (this.isEoPreview())
    return;
  if(typeof(numrec) == 'undefined') numrec = '';
  if(typeof(check) == 'undefined') check = true;
  var objzone = this.obj[zoneid];
  var lc = this.getLastChildElement();
  if(!Empty(lc) && check){
    if(this.checkLimitPage(lc,objzone)){
      this.drawZoneGroupFooter(this.lastRecIndex,lc,false);
      this.newPage(k);
      if(this.obj.showGroupZone)
        if(this.obj.groupheader.options.reprintOnPage)
          this.drawZone(k,'groupheader','',false);
    }
  }
  if (this.isEoPreview())
    return;
  this.addCurrentZone(objzone,zoneid,numrec);
  var delta = 0;
  if(objzone.items.length>0){
    //strecth
    var zoneYMap = this.getZoneElementsYMap(objzone.items);
    var items;
    var value;
    var item;
    var zoneKeys = Object.keys(zoneYMap);
    zoneKeys.sort(function(a,b){ return a-b;});
    var key = "", x, j, jj, ii, yRel;
    for(ii=0; ii<zoneKeys.length; ii++){
      key = zoneKeys[ii];
      var rowdelta = 0;
      items = zoneYMap[key];
      var stretchobj = [];
      var maxrows = 0;
      for (j = 0; j < items.length; j++) {
        item = items[j];
        item.colIdx = j;
        value = this.getItemValue(k, item, zoneid, this, useLastRecord);
        if (this.splitStringCheck(check, item, value)) {
          var msobj = {};
          msobj.item = item;
          msobj.strings = [];
          msobj.rowdelta = 0;
          var arrValue = value.split(/[\n\r]/g);
          for (x = 0; x < arrValue.length; x++) {
            value = arrValue[x];
            while (value.length > 0) {
              var vori = value,
              valuev = this.splitString(vori, item.style.font, item.position.width, 0),
              isArray = Array.isArray(valuev),
              p = valuev.length;
              if (isArray && p > 0) {
                msobj.strings = msobj.strings.concat(valuev);
                value = "";
              }
              else {
                value = vori.substring(p);
                if (valuev.length === 0) {
                  msobj.strings.push(value);
                  value = "";
                }
                else
                  msobj.strings.push(valuev);
              }
            }
          }
          stretchobj.push(msobj);
          maxrows = Math.max(maxrows, msobj.strings.length);
        }
        else{
          yRel = item.position.yRelative + delta;
          this.addItemInZone(k,item,objzone,zoneid,value,yRel);
        }
      }
      //print stretch
      var xprog = 0;
      for(x=0; x<maxrows; x++){
        for(j=0; j<stretchobj.length; j++){
          var mobj = stretchobj[j];
          item = mobj.item;
          if(!Empty(mobj.strings[x])){
            yRel = item.position.yRelative;
            yRel = yRel + (x-xprog)*convertStringToPx(item.style.font.fontSize)*1.1 + delta;
            lc = this.getLastChildElement();
            if(!Empty(lc) && check && (this.gwork.margint+objzone.height+lc.top+yRel>this.gwork.limitpage)){
              for(jj=0; jj<stretchobj.length; jj++)
                rowdelta = Math.max(rowdelta, stretchobj[jj].rowdelta-stretchobj[jj].item.position.height);
              delta = delta+rowdelta;
              rowdelta = 0;
              this.updateZoneHeight(delta);
              lc = this.getLastChildElement();
              this.drawZoneGroupFooter(this.lastRecIndex,lc,false);
              this.newPage(k);
              if(this.obj.showGroupZone)
                if(this.obj.groupheader.options.reprintOnPage)
                  this.drawZone(k,'groupheader','',false);
              this.addCurrentZone(objzone,zoneid,numrec);
              lc = this.getLastChildElement();
              xprog = x;
              delta = 0;
              yRel = item.position.yRelative;
              for(jj=0; jj<stretchobj.length; jj++)
                stretchobj[jj].rowdelta = 0;
            }
            mobj.rowdelta = mobj.rowdelta + convertStringToPx(item.style.font.fontSize)*1.1;
            this.addItemInZone(k,item,objzone,zoneid,mobj.strings[x], yRel, true, x);
          }
        }
      }

      //ricalcolare delta
      for(j=0; j<stretchobj.length; j++)
        rowdelta = Math.max(rowdelta, stretchobj[j].rowdelta-stretchobj[j].item.position.height+ convertStringToPx(item.style.font.fontSize)*1.1);
      delta = delta+rowdelta;
    }
  }
  this.updateZoneHeight(delta);
  this.updateLoading();
};

RepDocument.prototype.checkLimitPage = function(lc,objzone){
  return (this.gwork.margint+objzone.height+lc.top+lc.height>this.gwork.limitpage);
}

RepDocument.prototype.splitStringCheck = function(check,item,value){
  if(/*!check || */(item.type!='field' && !item.titleStretch) || (item.fieldDetail && item.fieldDetail.type!='M' && item.fieldDetail.type!='C') || Empty(value))
    return false;
  if (item.typeView != 'text')
    return false;
  var nlcr = new RegExp('\\r|\\n','g');
  var font = { name : item.style.font.fontName
             , size : item.style.font.fontSize
             , weight : item.style.font.bold ? 'bold' : 'normal'
             , italic : item.style.font.italic ? 'italic' : 'normal'
             };
  return (value.search(nlcr)>=0 || this.getTextDimensions(value, font).width>item.position.width);
}

RepDocument.prototype.drawZoneGroupFooter = function(k,lc,breakg){
  if (this.isEoPreview())
    return;
  var p = this.gwork.limitpage-(this.gwork.margint+lc.top+lc.height);
  this.obj.emptyzone = {};
  this.obj.emptyzone.items = [];
  this.obj.emptyzone.height = p;
  if(this.obj.showGroupZone){
    var check = false;
    if (!this.obj.groupfooter.options.reprintOnPage && !this.obj.groupfooter.options.atEndOfPage)
      check = true;
    if (breakg) {
      var lm = this.gwork.limitpage;
      // aggiungo x valutazione ev. salto pagina
      if (this.obj.groupfooter.options.reprintOnPage && this.lastGrpFooter)
        lm = lm + this.obj.groupfooter.height;
      // altezza di pagina e di gruppo diverse
      if (!this.obj.groupfooter.options.reprintOnPage && this.obj.groupfooter.options.atEndOfPage)
        lm = lm - this.obj.groupfooter.height;
      if (this.gwork.margint + this.obj.groupfooter.height + lc.top + lc.height > lm) {
        lm = lm + this.obj.groupfooter.height;
        if (this.obj.groupfooter.options.reprintOnPage && this.lastGrpFooter)
          lm = lm - this.obj.groupfooter.height;
        p = lm-(this.gwork.margint+lc.top+lc.height);
        this.obj.emptyzone.height = p;
        this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
        this.newPage(k);
        if(this.obj.showGroupZone)
          if(this.obj.groupheader.options.reprintOnPage)
            this.drawZone(k,'groupheader','',check);
        lc = this.getLastChildElement();
        lm = this.gwork.limitpage;
        if(this.obj.groupfooter.options.atEndOfPage){
          lm = lm - this.obj.groupfooter.height;
          p = lm-(this.gwork.margint+lc.top+lc.height);
          this.obj.emptyzone.height = p;
          this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
          this.drawZone(k,'groupfooter','',check);
        }
        else{
          this.drawZone(k,'groupfooter','',check);
        }
      }
      else{
        if (this.obj.groupfooter.options.reprintOnPage && this.lastGrpFooter)
          lm = lm - this.obj.groupfooter.height;
        if(this.obj.groupfooter.options.atEndOfPage){
          p = lm-(this.gwork.margint+lc.top+lc.height);
          this.obj.emptyzone.height = p;
          this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
          this.drawZone(k,'groupfooter','',check);
        }
        else
          this.drawZone(k,'groupfooter','',check);
      }
    }
    else if (this.obj.groupfooter.options.reprintOnPage || (this.lastGrpFooter && !this.obj.groupfooter.options.reprintOnPage)) {
      if(this.obj.groupfooter.options.atEndOfPage) {
        this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
        this.drawZone(k,'groupfooter','',check);
      }
      else{
        this.drawZone(k,'groupfooter','',check);
        lc = this.getLastChildElement();
        p = this.gwork.limitpage-(this.gwork.margint+lc.top);
        this.obj.emptyzone.height = p;
        this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
      }
    }
    else
      this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
  }
  else
    this.drawZone(k,'emptyzone',this.gwork.rpagecounter,false);
  delete this.obj.emptyzone;
};

RepDocument.prototype.isEof = function(){
  if (this.offline) {
    if (this.datasource.Eof()) {
      return true;
    }
    if (this.isPreview && this.rowsCounter >= 200) {
      return true
    }
    if (!this.isPreview && this.rowsCounter >= 1500) {
      return true;
    }
  }
  else {
    if (this.isPreview && this.rowsCounter >= 200) {
      this.end = true;
      return true
    }
  }
  return false;
}

RepDocument.prototype.isEoPreview = function () {
  if (this.isPreview) {
    if (this.gwork.rpagecounter > this.limitDataPreview || this.gwork.pagecounter > this.limitDataPreview) {
      if (this.gwork.rpagecounter > this.limitDataPreview)
        this.gwork.rpagecounter --;
      return true;
    }
  }
  return false;
}

RepDocument.prototype.paramUpdated = function(){
  var tmpdata = [];
  var i = this.datasource.getGlobalCurRec();
  var j;
  tmpdata[i]={};
  for(j=0; j<this.allfields.length; j++){
    if( !( this.allfields[j] in this.datasource.rs ) && !( this.allfields[j].toLowerCase() in this.datasource.rs ) && !( this.allfields[j].toUpperCase() in this.datasource.rs )){
      if(this.listMissingFields.indexOf(this.allfields[j]) < 0)
        this.listMissingFields.push(this.allfields[j]);
    }
    if(Empty(this.listMissingFields) || this.listMissingFields.length == 0) {
      if( ( this.allfields[j] in this.datasource.rs ) )
        tmpdata[i][this.allfields[j]] = this.datasource.rs[this.allfields[j]];
      else if( ( this.allfields[j].toLowerCase() in this.datasource.rs ) )
        tmpdata[i][this.allfields[j]] = this.datasource.rs[this.allfields[j].toLowerCase()];
      else if( ( this.allfields[j].toUpperCase() in this.datasource.rs ) )
        tmpdata[i][this.allfields[j]] = this.datasource.rs[this.allfields[j].toUpperCase()];
    }
  }

  if(Empty(this.listMissingFields) || this.listMissingFields.length == 0) {
    this.propertyValue.push(tmpdata[i]);
    this.rowsCounter = this.rowsCounter + 1;
    if(this.imgfields && this.imgfields.fields){
      for(j=0; j<this.imgfields.fields.length; j++){
        if(this.imgSrc.indexOf(tmpdata[i][this.imgfields.fields[j]])<0)
          this.imgSrc.push(tmpdata[i][this.imgfields.fields[j]]);
      }
      this.preloadImagesOFFLINE(this);
    }
  }

  if ( this.execQuery && !this.isEof() ) {
    var _this = this;
    setTimeout(function() {
      _this.datasource.Next();
    }, 1);
  }
  else if ( this.execQuery && this.isEof() ) {
    this.datasource.dispatchEvent('ConsumersRendered');
  }
};

RepDocument.prototype.FillData = function (datasource) {
  this.propertyValue = [];
  if (datasource.getRecCount() <= 0)
    return;
  for (var i = 0; i < datasource.getRecCount() && !this.isEof(); i++) {
    var checkGroupR = true;
    this.propertyValue[i] = {};
    for (var j=0; j<this.allfields.length; j++) {
      var field = this.allfields[j];
      if (!datasource.hasField(field) && !datasource.hasField(field.toLowerCase()) && !datasource.hasField(field.toUpperCase())) {
        var tmpVal = evaluateFieldValue(field, i, datasource);
        if (!Empty(tmpVal.nflist)) {
          for (var k = 0; k < tmpVal.nflist.length; k++) {
            if (this.listMissingFields.indexOf(tmpVal.nflist[k]) < 0)
              this.listMissingFields.push(tmpVal.nflist[k]);
          }
        }
        else
          this.propertyValue[i][field] = tmpVal.value;
      }
      else {
        this.propertyValue[i][field] = datasource.getValue(i, field);
        field = field + "_pic";
        if (datasource.hasField(field) || datasource.hasField(field.toLowerCase()) || datasource.hasField(field.toUpperCase())) {
          this.propertyValue[i][field] = datasource.getValue(i, field);
        }
      }
        

      if (Empty(this.listMissingFields) || this.listMissingFields.length == 0) {
        if (datasource.hasField(field))
          this.propertyValue[i][field] = datasource.getValue(i,field)
        else if (datasource.hasField(field.toLowerCase()))
          this.propertyValue[i][field] = datasource.getValue(i,field.toLowerCase())
        else if (datasource.hasField(field.toUpperCase()))
          this.propertyValue[i][field] = datasource.getValue(i,field.toUpperCase())
      }

      this.propertyValue[i][field + "-bck"] = this.propertyValue[i][field];
      if (this.group_repeated && checkGroupR) {
        if (i > 0 && j < this.allfields.length - 1) { //ultima colonna grid sempre stampata
          if (this.propertyValue[i-1]) {
            var isDate = (IsA(this.propertyValue[i-1][field + "-bck"], 'T') && IsA(this.propertyValue[i][field + "-bck"], 'T'));
            if (isDate) {
              if (Empty(this.pictureMap) || Empty(this.pictureMap[field])) {
                if ((this.propertyValue[i-1][field + "-bck"]).getTime() == (this.propertyValue[i][field + "-bck"]).getTime())
                  this.propertyValue[i][field] = "";
                else
                  checkGroupR = false;
              }
              else {
                var dateCur = FormatDateTime(this.propertyValue[i][field + "-bck"], this.pictureMap[field]),
                datePrec = FormatDateTime(this.propertyValue[i-1][field + "-bck"], this.pictureMap[field]);
                if (datePrec == dateCur)
                  this.propertyValue[i][field] = "";
                else
                  checkGroupR = false;
              }
            }
            else {
              if ((!Empty(this.propertyValue[i-1][field + "-bck"]) || this.propertyValue[i-1][field + "-bck"] == 0) && this.propertyValue[i-1][field + "-bck"] == this.propertyValue[i][field + "-bck"]) // eslint-disable-line max-len
                this.propertyValue[i][field] = "";
              else
                checkGroupR = false;
            }
          }
        }
      }
    }
    if(Empty(this.listMissingFields) || this.listMissingFields.length == 0)
      this.exec(this.propertyValue[i], i);
    this.rowsCounter ++;
  }
}

function evaluateFieldValue(txt, idx, datasource) {
  // ripresa da ZtVWeb.fmtPctFldPct
  var nflist = [],
  notfound = false,
  txt_par = txt.split('%');
  for (var fldname, fldval, i = 1, l = txt_par.length; i < l;) {
    notfound = false;
    fldname = txt_par[i];
    fldval = datasource && datasource.hasField(fldname) ? datasource.getStr(idx, fldname) : (function() { notfound = true; return ""; }());
    fldval = Trim(fldval.toString());
    if (!notfound) {
      txt = Strtran(txt, '%' + fldname + '%', fldval);
      i += 2;
    }
    else {
      nflist.push(fldname);
      i++;
    }
  }
  return { value : txt, nflist : nflist };
}

RepDocument.prototype.UpdateCurRec = function(datasource){
  this.FillData(datasource);
}

RepDocument.prototype.exec = function(record,k){
  if (this.isEoPreview()) {
    // e' sicuro la preview edt
    this.rowsCounter = 200;
    return;
  }
  if(this.mrows===0){
    this.lastGrpFooter = false;
    this.grpBreak = false;
    this.newPage(this.mrows,true);
    if(this.obj.showReportZone){
      if(this.obj.reportheader.options.afterPageHeader){
        if(this.obj.showPageZone)
          this.drawZone(k,'pageheader');
        this.drawZone(k,'reportheader');
      }
      else{
        this.drawZone(k,'reportheader');
        if(this.obj.showPageZone)
          this.drawZone(k,'pageheader');
      }
    }
    else if(this.obj.showPageZone)
      this.drawZone(k,'pageheader');
    if(this.obj.showGroupZone)
      this.drawZone(k,'groupheader');
  }
  else if(startNewGroup(record,this.obj,this.lastRec)){
    this.lastGrpFooter = true;
    this.drawZoneGroupFooter(this.lastRecIndex,this.getLastChildElement(),true);
    if(startNewPage(this.obj))
      this.newPage(k);
    this.grpBreak = true;
    if(this.obj.showGroupZone)
      this.drawZone(k,'groupheader');

    var zones = [];
    if(this.obj.showGroupZone)
      zones.push('groupfooter');
    if(this.obj.showPageZone)
      zones.push('pagefooter');
    if(this.obj.showReportZone)
      zones.push('reportfooter');
    //calcobjs - only footer
    for(var l=0; l<zones.length; l++){
      var melements = getZoneElementsType(this.obj, zones[l], 'field');
      for(var kk=0; kk<melements.length; kk++){
        if(melements[kk].calculation && melements[kk].calculation.type=='sum' && melements[kk].calculation.byGroup){
          this.calcObjs[melements[kk].fieldDetail.alias][melements[kk].uid]=0;
        }
      }
    }
    this.lastGrpFooter = false;
    this.grpBreak = false;
  }

  this.drawZone(k,'groupbody',this.mrows);
  this.mrows = this.mrows + 1;

  for(var key in this.calcObjs){
    for(var uid in this.calcObjs[key]){
      this.calcObjs[key][uid] = this.calcObjs[key][uid] + record[key];
    }
  }
  this.lastRec = record;
  this.lastRecIndex = k;
};

RepDocument.prototype.startLoading = function(){
  this.loadingDiv = this.document.createElement("div");
  this.loadingDiv.id = this.container.id + "_loading";
/*  this.loadingDiv.style.width = "100%";
  this.loadingDiv.style.height = this.container.offsetHeight+"px";
  this.loadingDiv.style.zIndex = 1500;
  this.loadingDiv.style.backgroundColor = "#F3F3F3";
  this.loadingDiv.style.opacity = 0.5;
  this.loadingDiv.textContent = 'loading...';*/

  this.loadingDiv.style.width = "100%";
  this.loadingDiv.style.height = "100%";
  this.loadingDiv.style.position = "absolute";
  this.loadingDiv.style.zIndex = 2000;
  this.loadingDiv.style.backgroundColor = "#FFFFFF";
  this.loadingDiv.style.display = "block";
  this.loadingDiv.style.opacity = 1;
  this.loadingDiv.className = "spModalLayer loading";


  this.parent.appendChild(this.loadingDiv);
};

RepDocument.prototype.updateLoading = function(){
  if(this.loadingDiv !== null)
    this.loadingDiv.style.height = this.loadingDiv.parentNode.offsetHeight+"px";
};

RepDocument.prototype.removeLoading = function(){
  if(this.loadingDiv || ( this.loadingDiv = this.document.getElementById(this.container.id+"_loading"))){
    this.loadingDiv.parentNode.removeChild(this.loadingDiv);
    this.loadingDiv = null;
  }
};

RepDocument.prototype.setParent = function( _parent ){
  this.parent = ( _parent
                ? _parent
                : ( this.container.tagName.toLowerCase() == "iframe"
                  ? this.container.contentWindow.document.body
                  : this.container
                  )
                );
};

RepDocument.prototype.setDocument = function( _document ){
  this.document = ( _document
                  ? _document
                  : ( this.container.tagName.toLowerCase() == "iframe"
                    ? this.container.contentWindow.document
                    : document
                    )
                  );
};

RepDocument.prototype.setWindow = function( _window ){
  this.window = ( _window
                ? _window
                : ( this.container.tagName.toLowerCase() == "iframe"
                  ? this.container.contentWindow
                  : window
                  )
                );
};

RepDocument.prototype.setIFrame = function (w, h) {
  if (document.getElementById(this.container.id + "ifrprev"))
    return;
  var ifr = document.createElement("IFRAME");
  ifr.id = this.container.id + "ifrprev";
  ifr.name = this.container.id + "ifrprev";
  ifr.frameBorder = 0;
  ifr.allowTransparency = true;
  ifr.style.border = 0;
  if (Empty(w))
    ifr.width = "100%"//this.container.offsetWidth;
  else
    ifr.width = w;
  if (Empty(h))
    ifr.height = "100%";//this.container.offsetHeight;
  else
    ifr.height = h;
  ifr.style.display = "block";
  this.container.appendChild(ifr);
};

RepDocument.prototype.download = function () {
};

RepDocument.prototype.setFormatNumber = function (val,len,dec,pict) {
  var ret = "";
  dec = parseInt(dec);
  if(!Empty(pict)){
    ret = Format(val,len,dec,pict);
    return ret;
  }
  pict = "999999999";
  if(dec!==0)
    ret = Format(val,len,dec,pict+"." + Replicate("9",dec));
  else
    ret = Format(val,len,dec,pict);
  return ret;
};

RepDocument.prototype.preloadImagesOFFLINE = function(repobj){
  var myimg,msrc,i;
  var allsrc = repobj.imgSrc.concat(repobj.imgfields.generic);
  // immagini per checkbox
  allsrc = allsrc.concat([repobj.checkedSrc, repobj.uncheckedSrc]);
  var newImages = [];
  for(i=0; i<allsrc.length; i++){
    msrc = allsrc[i];
    if(msrc.indexOf(repobj.rootApp)!=0 && msrc.indexOf(repobj.rootAppB)!=0 && !Empty(msrc))
      msrc = repobj.rootApp+msrc;
    if(repobj.simulatedData)
      msrc = "";

    if(!Empty(msrc) && Empty(repobj.imgMap[msrc])){
      myimg = new Image();
      repobj.imgMap[msrc] = myimg;
      if(Empty(newImages[msrc]))
        newImages[msrc] = myimg;
    }
  }

  var allImages = Object.keys(newImages);
  for(i=0; i<allImages.length; i++){
    myimg = newImages[allImages[i]];
    myimg.src = allImages[i];

    function loaded(){
      repobj.imgCount++;
      repobj.continueExecOFFLINE(repobj);
    }

    if(myimg.complete)
      loaded();
    else
      myimg.addEventListener('load', loaded);
    myimg.onerror = function(){
      repobj.imgCount++;
      repobj.continueExecOFFLINE(repobj);
    }
  }
}

RepDocument.prototype.continueExecOFFLINE = function(repobj){
  var currimg = repobj.imgCount;
  var totimg = Object.keys(repobj.imgMap).length;
  if(repobj.propertyValue.length>0 && currimg==totimg && !repobj.end && repobj.isEof())
    repobj.documentExecOFFLINE(repobj);
  if (repobj.end && repobj.format == "IARViewer" && window.navigator.userAgent.match( /zRuntime/ )) {
    repobj.view(repobj.fncCallBack);
  }
  if(repobj.fncCallBack && !Empty(repobj.args) && repobj.end && repobj.execCallback){
    repobj.args.push(repobj);
    repobj.fncCallBack.apply(null,repobj.args);
    repobj.execCallback = false;
  }
}

RepDocument.prototype.documentExecOFFLINE = function(repobj){
  if (repobj.end)
    return;
  repobj.totalNRecords = repobj.propertyValue.length;
  while (repobj.propertyValue.length > 1) {
    repobj.exec(repobj.propertyValue[0],0);
    repobj.propertyValue.splice(0,1);
    if (repobj.isEoPreview())
      repobj.propertyValue = [];
  }
  if (!repobj.isEoPreview()) {
    repobj.exec(repobj.propertyValue[0],0);
    repobj.lastGrpFooter = true;
    repobj.drawZoneGroupFooter(repobj.propertyValue.length-1,repobj.getLastChildElement(), true);  // lo tratto come rottura di gruppo perche' e' l'ultimo
    var p, lc = repobj.getLastChildElement();
    if(repobj.obj.showGroupZone)
      if(repobj.obj.groupfooter.options.reprintOnPage)
        repobj.gwork.limitpage = repobj.gwork.limitpage + repobj.obj.groupfooter.height;
    if(repobj.obj.showReportZone && repobj.obj.reportfooter.items.length>0){
      if(repobj.obj.reportfooter.options.beforePageFooter){
        var zoneid = 'reportfooter';
        if(repobj.gwork.margint+repobj.obj[zoneid].height+lc.top+lc.height>repobj.gwork.limitpage){
          p = repobj.gwork.limitpage-(repobj.gwork.margint+lc.top+lc.height);
          repobj.obj.emptyzone = {};
          repobj.obj.emptyzone.items = [];
          repobj.obj.emptyzone.height = p;
          repobj.drawZone(repobj.propertyValue.length-1,'emptyzone',repobj.gwork.rpagecounter,false);
          repobj.newPage(repobj.propertyValue.length-1);
        }
        repobj.drawZone(repobj.propertyValue.length-1,'reportfooter','',false);
        if(repobj.obj.showPageZone){
          lc = repobj.getLastChildElement();
          p = repobj.gwork.limitpage-(repobj.gwork.margint+lc.top+lc.height);
          repobj.obj.emptyzone = {};
          repobj.obj.emptyzone.items = [];
          repobj.obj.emptyzone.height = p;
          repobj.drawZone(repobj.propertyValue.length-1,'emptyzone',repobj.gwork.rpagecounter,false);
          repobj.drawZone(repobj.propertyValue.length-1,'pagefooter','',false);
        }
      }
      else{
        if(repobj.obj.showPageZone){
          p = repobj.gwork.limitpage-(repobj.gwork.margint+lc.top+lc.height);
          repobj.obj.emptyzone = {};
          repobj.obj.emptyzone.items = [];
          repobj.obj.emptyzone.height = p;
          repobj.drawZone(repobj.propertyValue.length-1,'emptyzone',repobj.gwork.rpagecounter,false);
          repobj.newPage(repobj.propertyValue.length-1);
        }
        repobj.drawZone(repobj.propertyValue.length-1,'reportfooter','',false);
      }
    }
    else if(repobj.obj.showPageZone){
      p = repobj.gwork.limitpage-(repobj.gwork.margint+lc.top+lc.height);
      repobj.obj.emptyzone = {};
      repobj.obj.emptyzone.items = [];
      repobj.obj.emptyzone.height = p;
      repobj.drawZone(repobj.propertyValue.length-1,'emptyzone',repobj.gwork.rpagecounter,false);
      repobj.drawZone(repobj.propertyValue.length-1,'pagefooter','',false);
    }
    repobj.pageNumber();
    repobj.drawPreviewValidator();
    repobj.removeLastLabelContinue();
    repobj.addLicense();
  }
  repobj.removeLastLabelContinue();
  repobj._dontruncb = true;
  repobj.endProcess();
  delete repobj.obj.emptyzone;
  repobj.propertyValue.splice(0,1);
}

RepDocument.prototype.documentExec = function () {
  this.lastGrpFooter = true;
  this.drawZoneGroupFooter(this.lastRecIndex, this.getLastChildElement(), true);  // lo tratto come rottura di gruppo perche' e' l'ultimo
  var p, lc = this.getLastChildElement();
  if (this.obj.showGroupZone)
    if (this.obj.groupfooter.options.reprintOnPage)
      this.gwork.limitpage = this.gwork.limitpage + this.obj.groupfooter.height;
  if (this.obj.showReportZone && this.obj.reportfooter.items.length > 0) {
    if(this.obj.reportfooter.options.beforePageFooter){
      var zoneid = 'reportfooter';
      if(this.gwork.margint+this.obj[zoneid].height+lc.top+lc.height>this.gwork.limitpage){
        p = this.gwork.limitpage-(this.gwork.margint+lc.top+lc.height);
        this.obj.emptyzone = {};
        this.obj.emptyzone.items = [];
        this.obj.emptyzone.height = p;
        this.drawZone(this.lastRecIndex,'emptyzone',this.gwork.rpagecounter,false);
        this.newPage(this.lastRecIndex);
      }
      this.drawZone(this.lastRecIndex,'reportfooter','',false);
      if(this.obj.showPageZone){
        lc = this.getLastChildElement();
        p = this.gwork.limitpage-(this.gwork.margint+lc.top+lc.height);
        this.obj.emptyzone = {};
        this.obj.emptyzone.items = [];
        this.obj.emptyzone.height = p;
        this.drawZone(this.lastRecIndex,'emptyzone',this.gwork.rpagecounter,false);
        this.drawZone(this.lastRecIndex,'pagefooter','',false);
      }
    }
    else{
      if(this.obj.showPageZone){
        p = this.gwork.limitpage-(this.gwork.margint+lc.top+lc.height);
        this.obj.emptyzone = {};
        this.obj.emptyzone.items = [];
        this.obj.emptyzone.height = p;
        this.drawZone(this.lastRecIndex,'emptyzone',this.gwork.rpagecounter,false);
        this.newPage(this.lastRecIndex);
      }
      this.drawZone(this.lastRecIndex,'reportfooter','',false);
    }
  }
  else if(this.obj.showPageZone){
    p = this.gwork.limitpage-(this.gwork.margint+lc.top+lc.height);
    this.obj.emptyzone = {};
    this.obj.emptyzone.items = [];
    this.obj.emptyzone.height = p;
    this.drawZone(this.lastRecIndex,'emptyzone',this.gwork.rpagecounter,false);
    this.drawZone(this.lastRecIndex,'pagefooter','',false);
  }


  this.pageNumber();
  this.drawPreviewValidator();
  this.removeLastLabelContinue();
  this.addLicense();
  // solo pdf images
  var _this = this;
  setTimeout( function () {
    _this.checkImages();
  }, 0);

  this.managed = true;
}

RepDocument.prototype.checkImages = function () {
  this.endProcess();
  delete this.obj.emptyzone;
}

RepDocument.prototype.renderHTMLtoCanvas = function (item, value, ctrlid) {
  var doc = document,
  mdiv = doc.createElement("div"),
  id = ctrlid + "_canvimg";
  if (!Empty(doc.getElementById(id)))
    mdiv = doc.getElementById(id);
  else {
    mdiv.id = id;
    mdiv.className = "__canvimg";
    mdiv.innerHTML = value;
    mdiv.style.position = "absolute";
    mdiv.style.top = "0px";
    mdiv.style.left = "0px";
    mdiv.style.width = item.position.width + "px";
    mdiv.style.height = item.position.height + "px";
    doc.body.appendChild(mdiv);
  }

  if (typeof html2canvas !== 'undefined') {
    html2canvas(mdiv, {
        onrendered : function (newCanvas) {
          doc.getElementById(Strtran(id, "_canvimg", "") + "_img").src = newCanvas.toDataURL('image/png');
          doc.getElementById(id).parentNode.removeChild(doc.getElementById(id));
        },
        width: item.position.width,
        height: item.position.height
    });
  }
}

RepDocument.prototype.removeCanvasImages = function () {
  var imgs = document.getElementsByClassName("__canvimg");
  for (var i = imgs.length - 1; i >= 0; i--) {
    var par = imgs[i].parentNode;
    if (par)
      par.removeChild(imgs[i]);
  }
}

RepDocument.prototype.execFncCallback = function () {
  if (this.fncCallBack && !Empty(this.args) && this.end && this.execCallback) {
    if (this.format != "IARViewer"){
      this.args.push(this);
      this.fncCallBack.apply(null, this.args);
    }
    this.execCallback = false;
  }
}

/********** FUNZIONI COMUNI **********/
function JSRepDrawDocumentViewProvider(obj, format, SdataProvider, container, dwnlName, actionObj, isSimulatedData, fncCallBack, isPreview, offline) {
  if (format.toLowerCase() == "iarviewer") {
    format = 'IARViewer';
  }

  if (offline === undefined)
    offline = true;
  
  if (offline) {
    JSRepDrawDocumentViewProviderOFFLINE(obj, format, SdataProvider, container, dwnlName, actionObj, isSimulatedData, fncCallBack, isPreview);
    return;
  }

  if (window._fontsDone)
    _DrawDocumentViewProvider(obj, format, SdataProvider, container, dwnlName, actionObj, isSimulatedData, fncCallBack, isPreview);
  else {
    window._tmpArgs = [obj, format, SdataProvider, container, dwnlName, actionObj, isSimulatedData, fncCallBack, isPreview];
    preloadFonts();
  }
}

function preloadFonts() {
  if (typeof ZtVWeb != "undefined") {
    var rootFonts = ZtVWeb.SPWebRootURL + "/fonts",
    xhr,
    blob,
    path,
    count = 0;

    for (var i = 0; i < _srepFonts.length; i++) {
      path = rootFonts + "/" + _srepFonts[i][0] + "/" + _srepFonts[i][1];
      xhr = new XMLHttpRequest();
      xhr.open('GET', path + ".ttf", true);
      xhr.responseType = 'blob';
      xhr.onload = function (/*e*/) {
        if (this.status == 200) {
          blob = this.response;
          if (!(_srepFonts[this.__index][1] in jspdffontMap)) {
            jspdffontMap[_srepFonts[this.__index][1]] = {};
            jspdffontMap[_srepFonts[this.__index][1]].blob = blob;
          }
          count++;
          if (count == _srepFonts.length)
            loadBlobs();
        }
      };
      xhr.__index = i;
      xhr.send();
    }
  }
}

function loadBlobs() {
  var fblob,
  count = 0,
  fileReader;
	for (var i = 0; i < _srepFonts.length; i++) {
    fblob = jspdffontMap[_srepFonts[i][1]].blob;
    try {
      fileReader = new FileReader();
      fileReader.__index = i;
      fileReader.onload = function (e) {
        var filecontent = e.target.result;
        filecontent = filecontent.substr(filecontent.indexOf('base64,') + 7);
        if (jspdffontMap[_srepFonts[this.__index][1]]) {
          jspdffontMap[_srepFonts[this.__index][1]].cont = filecontent;
          jspdffontMap[_srepFonts[this.__index][1]].name = _srepFonts[this.__index][2];
          jspdffontMap[_srepFonts[this.__index][1]].style = _srepFonts[this.__index][3];
          jspdffontMap[_srepFonts[this.__index][1]].css = Strtran(_srepFonts[this.__index][0], "_", "");
        }
        count++;
        if (count == _srepFonts.length) {
          window._fontsDone = true;
          if (window._tmpArgs)
            _DrawDocumentViewProvider.apply(this, window._tmpArgs);
        }
      };

      fileReader.readAsDataURL(fblob);
    }
    catch (e) { 
      console.log("error in file reader");
    }
  }
}

function _DrawDocumentViewProvider(obj, format, SdataProvider, container, dwnlName, actionObj, isSimulatedData, fncCallBack, isPreview) {
  delete window._tmpArgs;

  actionObj || ( actionObj = {} );
  var uid = container.id + "_jsrep",
  myobserver = {
    SdataProvider_ConsumersRendered : function () {
      exec();
    }
  },
  
  allfields = getZoneAlias(obj),
  imgfields = getImagesAlias(obj);

  if (Empty(dwnlName))
    dwnlName = obj.name;

  if (format == "html")
    window[uid] = new RepDocumentHtml(dwnlName, uid);
  else if (format == "pdf" || format == "IARViewer")
    window[uid] = new RepDocumentPdf(dwnlName, uid);
  else if (format == "xls" || format == "xlsx")
    window[uid] = new RepDocumentXlsx(dwnlName, uid, format);
  else  // CSVS CSV CSV2 XML XMLS
    window[uid] = new RepDocumentText(dwnlName, uid, format, format.toLowerCase() == "csvs", actionObj.coverobj.csvSeparator, actionObj.coverobj.csvHeader);

  window[uid].offline = false;
  window[uid].theme = actionObj.theme;
  window[uid].format = format;
  window[uid].group_repeated = actionObj.group_repeated;
  window[uid].pictureMap = actionObj.pictureMap;

  function downloadListener () {
    if (window[uid].datasource.getRecCount() == 0)
      return;
    window[uid].download();
  }

  window[uid].autoprint = Empty(actionObj.autoprint) ? false : actionObj.autoprint;
  window[uid].autodownload = Empty(actionObj.autodownload) ? false : actionObj.autodownload;

  var downloadCtrl = actionObj.cdownload;
  if (downloadCtrl) {
    if (downloadCtrl.tagName)
      downloadCtrl.onclick = downloadListener;
    else if (downloadCtrl.addObserver)
      downloadCtrl.addObserver( 'downloadCtrl', { downloadCtrl_Click: downloadListener } );
  }

  function printListener () {
    window[uid].print();
  }

  var bprint = false,
  printCtrl = actionObj.cprint;
  if (printCtrl) {
    bprint = true;
    if (printCtrl.tagName)
      printCtrl.onclick = printListener;
    else if (printCtrl.addObserver)
      printCtrl.addObserver( 'printCtrl', { printCtrl_Click: printListener } );
  }
  
  window[uid].isPreview = isPreview;
  if (window[uid].isPreview)
    window[uid].name = window[uid].name + "_preview";
  var pprops = new JSURL("../servlet/SPReportGet?action=getReportLicenze&filename=printlicenze");
  pprops = JSON.parse(pprops.Response());

  if (window[uid].isPreview)
    window[uid].watermark = "VALID DOCUMENT ONLY AS PREVIEW";
  else if(pprops.hasWatermark)
    window[uid].watermark = pprops.watermark;
  window[uid].license = pprops.license;
  window[uid].watermarkIsImage = pprops.hasWatermarkAsImage;

  gwork = window[uid].setGWork(obj);
  window[uid].beforeProcess(allfields, container, bprint, imgfields, isSimulatedData);
  window[uid].startLoading();
  window[uid].setLimitPage();
  window[uid].gwork.pagecounter = 1;
  window[uid].gwork.rpagecounter = 1;
  window[uid].drawCover(actionObj.coverobj);

  var cpDP = SdataProvider._getCloneForPrint();
  cpDP.nRows = 1;
  cpDP.count = "true";
  cpDP.Query();

  SdataProvider.addRowConsumer(window[uid]);
  window[uid].datasource = SdataProvider;

  if (cpDP.querycount > 0)
    window[uid].datasource.nRows = cpDP.querycount;
  else
    window[uid].datasource.nRows = 5000;

  window[uid].execQuery = true;
  window[uid].datasource.addObserver("SdataProvider", myobserver);
  window[uid].datasource.Query();

  window[uid].args = Array.prototype.slice.call(arguments);
  window[uid].fncCallBack = fncCallBack;
  window[uid].execCallback = true;
  window[uid]._dontruncb = (format == "IARViewer" && window.navigator.userAgent.match(/zRuntime/));

  LibJavascript.Events.addEvent(window, 'resize', function (evt) { resize(evt, uid); })

  function exec(){
    if( !window[uid] ) return;
    try {
      if ((window[uid].end && !fncCallBack) || window[uid].managed) {
        window[uid].removeLoading();
        return;
      }

      var hasnext;
      if (!window[uid].isEof() || (window[uid].isPreview && !window[uid].isEoPreview())) {
        hasnext = window[uid].datasource.getRecCount()>0 && window[uid].datasource.NextPage();
        if (hasnext === undefined)
          hasnext = true;
      }
      else
        hasnext = false;

      if (window[uid].datasource.getRecCount() == 0) {
        printMessageDiv(uid, window[uid].errorMessages.JSVRP_NODATA);
        window[uid].end = true;
      }
      else if (!Empty(window[uid].listMissingFields) && window[uid].listMissingFields.length > 0) {
        getFieldsDetailMap(window[uid].obj);
        var msg = window[uid].errorMessages.JSVRP_NOTFDATAS;
        printMessageDiv(uid, msg);
        window[uid].end = true;
      }
      else if ((hasnext == false || window[uid].isEof()) && window[uid].datasource.getRecCount() > 0)
        window[uid].documentExec();

      if (window[uid].end && format == "IARViewer" && window.navigator.userAgent.match(/zRuntime/))
        window[uid].view(window[uid].fncCallBack);

      window[uid].execFncCallback();
    }
    catch (e) {
      console.error(e.message);
      printMessageDiv(uid, window[uid].errorMessages.JSVRP_PRINTERR);
    }
  }
}

function JSRepDrawDocumentViewProviderOFFLINE(obj, format, SdataProvider, container, dwnlName, actionObj, isSimulatedData, fncCallBack, isPreview) {
  actionObj || ( actionObj = {} );
  container || ( container = document.createElement( 'div' ) );
  container.id || ( container.id = LibJavascript.AlfaKeyGen() );
  var uid = container.id + "_jsrep";
  var myobserver = {
    SdataProvider_ConsumersRendered:function(){
      execOFFLINE();
    }
  };

  if (Empty(dwnlName))
    dwnlName = obj.name;
  if (dwnlName && dwnlName.filePath)
    dwnlName = dwnlName.filePath;

  var allfields = getZoneAlias(obj);
  var imgfields = getImagesAlias(obj);
  //var isSimulatedData = Empty(SdataProvider.cmd); // da problemi su SPSmartReportPrint quando stampo BO off
  if(format=="html")
    window[uid] = new RepDocumentHtml(dwnlName, uid);
  else if(format=="pdf" || format=="IARViewer")
    window[uid] = new RepDocumentPdf(dwnlName, uid);
  window[uid].theme = actionObj.theme;

  function downloadListener () {
    if (window[uid].datasource.getRecCount() == 0)
      return;
    window[uid].download();
  }

  window[uid].autoprint = Empty(actionObj.autoprint) ? false : actionObj.autoprint;
  window[uid].autodownload = Empty(actionObj.autodownload) ? false : actionObj.autodownload;

  var downloadCtrl = actionObj.cdownload;
  if ( downloadCtrl ) {
    if ( downloadCtrl.tagName /*HTMLElement*/) {
      downloadCtrl.onclick = downloadListener; //downloadCtrl.addEventListener( 'click', downloadListener, false ); //scatena due volte l'evento????
    } else if ( downloadCtrl.addObserver /*PortalStudio Ctrl*/ ) {
      downloadCtrl.addObserver( 'downloadCtrl', { downloadCtrl_Click: downloadListener } );
    }
  }

  function printListener () {
    window[uid].print();
  }

  var bprint = false;
  var printCtrl = actionObj.cprint;
  if ( printCtrl ) {
    bprint = true;
    if ( printCtrl.tagName /*HTMLElement*/) {
      printCtrl.onclick=printListener; //printCtrl.addEventListener( 'click', printListener, false );  //scatena due volte l'evento????
    } else if ( printCtrl.addObserver /*PortalStudio Ctrl*/ ) {
      printCtrl.addObserver( 'printCtrl', { printCtrl_Click: printListener } );
    }
  }

  var pprops = new JSURL("../servlet/SPReportGet?action=getReportLicenze&filename=printlicenze");
  pprops = JSON.parse(pprops.Response());
  if(isPreview)
    window[uid].watermark = "VALID DOCUMENT ONLY AS PREVIEW";
  else if(pprops.hasWatermark)
    window[uid].watermark = pprops.watermark;
  window[uid].license = pprops.license;
  window[uid].watermarkIsImage = pprops.hasWatermarkAsImage;


  gwork = window[uid].setGWork(obj);
  window[uid].beforeProcess(allfields,container,bprint,imgfields,isSimulatedData);
  window[uid].startLoading();
  window[uid].setLimitPage();
  window[uid].gwork.pagecounter = 1;
  window[uid].gwork.rpagecounter = 1;
  window[uid].drawCover(actionObj.coverobj);
  SdataProvider.addParmConsumer(window[uid]);
  window[uid].datasource = SdataProvider;
  window[uid].execQuery = true;
  SdataProvider.addObserver("SdataProvider", myobserver);
  SdataProvider.Query();
  window[uid].args = Array.prototype.slice.call(arguments);
  window[uid].fncCallBack = fncCallBack;
  window[uid].execCallback = true;
  window[uid]._dontruncb = true;
  window[uid].offline = true;
  window[uid].format = format;

  window[uid].isPreview = isPreview;
  if (window[uid].isPreview)
    window[uid].name = window[uid].name + "_preview";

  function execOFFLINE(){
    try {
      if (window[uid].end && !fncCallBack)
        return;
      var currimg = window[uid].imgCount;
      var totimg = Object.keys(window[uid].imgMap).length;
      if(window[uid].datasource.getRecCount()==0){
        printMessageDiv(uid, window.TransDict.RPT_ERROR_NO_RECORD);
        window[uid].end = true;
      }
      else if(!Empty(window[uid].listMissingFields) && window[uid].listMissingFields.length > 0) {
        var mapfields = getFieldsDetailMap(window[uid].obj);
        var msg = window.TransDict.RPT_ERROR_GENERIC;
        msg += "<br />";
        for (var ff = 0; ff < window[uid].listMissingFields.length; ff++) {
          var alias = window[uid].listMissingFields[ff];
          msg += alias + " ( " + mapfields[alias] + " ) " + window.TransDict.RPT_ERROR_NOTFOUND_FIELD;
          msg += "<br />";
        }
        printMessageDiv(uid, msg);
        window[uid].end = true;
      }
      else if(window[uid].datasource.getRecCount() > 0 && window[uid].propertyValue.length > 0 && window[uid].isEof() && currimg == totimg && !window[uid].end)
        window[uid].documentExecOFFLINE(window[uid]);
      
      if (window[uid].end && format == "IARViewer" && window.navigator.userAgent.match(/zRuntime/))
        window[uid].view(window[uid].fncCallBack);

      window[uid].execFncCallback();
    }
    catch(e){
      console.error(e.stack);
      printMessageDiv(uid, window.TransDict.RPT_ERROR_GENERIC);
    }
  }
}

function startNewPage(obj){
  if(obj.groupbreak.options.startNewPage)
    return true;
  if(obj.showGroupZone)
    if(obj.groupfooter.options.atEndOfPage)
      return true;
  return false;
}

function startNewGroup(currRec,obj,lastRec){
  var ret = false;

  for(var k=0; !ret && k<obj.groupbreak.items.length; k++){
    var curv = currRec[obj.groupbreak.items[k]];
    var lastv = lastRec[obj.groupbreak.items[k]];
    if(curv!==lastv) ret = true;
  }
  return ret;
}

var ptTopx = 96/72;
function convertStringToPx(st,dimref){
  st = st + "";
  if(endsWith(st,'%')){
    if(dimref)
      return parseFloat(st)*dimref/100;
    else
      return parseFloat(st);
  }
  else{
    if(endsWith(st,"pt")) return convertToPixel("pt",parseFloat(st))*ptTopx;
    else if(endsWith(st,"mm")) return convertToPixel("mm",parseFloat(st))*ptTopx;
    else if(endsWith(st,"cm")) return convertToPixel("cm",parseFloat(st))*ptTopx;
    else return parseFloat(st);
  }
}

function convertPxToString(ab,wunit){
  var c = parseFloat(convertFromPixel(wunit,ab/ptTopx)).toFixed(2);
  if(wunit=='px') return c+"pt";
  return c+wunit;
}

function convertFromPixel(workunit,ab){
	if(workunit=="mm")
		return ab/2.834;
	else if(workunit=="cm")
		return ab/28.34;
	else if(workunit=="pc")
		return ab/12;
	else if(workunit=="inch")
		return ab/72;
	else
		return ab;
}

function convertToPixel(workunit,ab){
	if(workunit=="mm")
		return ab*2.834;
	else if(workunit=="cm")
		return ab*28.34;
	else if(workunit=="pc")
		return ab*12;
	else if(workunit=="inch")
		return ab*72;
	else
		return ab;
}

function setCurrentDateTime(d, item) {
  if (Empty(d))
    return "";
  var str = item.fieldDetail.desc;
  // quando non arriva una picture gestita lato editore o costruita con oggetto picture, valuto la proprieta' stdPicture con metodo Format
  if (/*!item.picture &&*/ item.stdPicture)
    str = Format(d, 0, 0, item.stdPicture);
  else if (item.picture) {
    var isD = IsA(d, 'D');
    if (!isD)
      d = new Date(d);
    if (item.picture.dateformat) str = FormatDate(d, item.picture.dateformat);
    if (item.picture.timeformat) str += " " + FormatDateTime(d, item.picture.timeformat.toLowerCase());
  }
  return str;
}

function getZoneElementsType(currentObj, zone, type){
  var ret = [];
  for(var i=0; i<currentObj[zone].items.length; i++){
    var o = currentObj[zone].items[i];
    if(o.type==type)
      ret.push(o);
  }
  return ret;
}

function getZoneAlias(obj){
  var ret = [];
  var zones = [];
  if(obj.showGroupZone){
    zones.push('groupheader');
    zones.push('groupfooter');
  }
  if(obj.showPageZone){
    zones.push('pageheader');
    zones.push('pagefooter');
  }
  if(obj.showReportZone){
    zones.push('reportheader');
    zones.push('reportfooter');
  }
  zones.push('groupbody');
  var k;
  for(var l=0; l<zones.length; l++){
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for(k=0; k<melements.length; k++){
      if(!Empty(melements[k].fieldDetail.alias) && ret.indexOf(melements[k].fieldDetail.alias)<0)
        ret.push(melements[k].fieldDetail.alias);
    }
  }
  for(k=0; k<obj.groupbreak.items.length; k++){
    if(ret.indexOf(obj.groupbreak.items[k])<0)
        ret.push(obj.groupbreak.items[k]);
  }
  return ret;
}

function getFieldsList(obj){
  var ret = [];
  var zones = [];
  if(obj.showReportZone){
    if(obj.reportheader.options.afterPageHeader){
      if(obj.showPageZone)
        zones.push('pageheader');
      zones.push('reportheader');
    }
    else
      zones.push('reportheader');
  }
  if(obj.showPageZone && zones.indexOf("pageheader")<0)
    zones.push('pageheader');
  if(obj.showGroupZone)
    zones.push('groupheader');
  zones.push('groupbody');
  if(obj.showGroupZone)
    zones.push('groupfooter');
  if(obj.showReportZone && obj.reportfooter.options.beforePageFooter)
    zones.push('reportfooter');
  if(obj.showPageZone)
    zones.push('pagefooter');
  if(obj.showReportZone && zones.indexOf("reportfooter")<0)
    zones.push('reportfooter');

  var k;
  for(var l=0; l<zones.length; l++){
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for (k = 0; k < melements.length; k++) {
      var typeView = melements[k].typeView.toLowerCase();
      if (!Empty(melements[k].fieldDetail.alias) && typeView != "signmup")  // per coerenza con web report
        ret.push(melements[k].uid);
    }
  }
  return ret;
}

function getFieldsObjList(obj){
  var ret = [];
  var zones = [];
  if(obj.showReportZone){
    if(obj.reportheader.options.afterPageHeader){
      if(obj.showPageZone)
        zones.push('pageheader');
      zones.push('reportheader');
    }
    else
      zones.push('reportheader');
  }
  if(obj.showPageZone && zones.indexOf("pageheader")<0)
    zones.push('pageheader');
  if(obj.showGroupZone)
    zones.push('groupheader');
  zones.push('groupbody');
  if(obj.showGroupZone)
    zones.push('groupfooter');
  if(obj.showReportZone && obj.reportfooter.options.beforePageFooter)
    zones.push('reportfooter');
  if(obj.showPageZone)
    zones.push('pagefooter');
  if(obj.showReportZone && zones.indexOf("reportfooter")<0)
    zones.push('reportfooter');

  var k;
  for(var l=0; l<zones.length; l++){
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for (k = 0; k < melements.length; k++) {
      var typeView = melements[k].typeView.toLowerCase();
      if (!Empty(melements[k].fieldDetail.alias) && typeView != "signmup")  // per coerenza con web report
        ret[melements[k].uid] = melements[k].fieldDetail;
    }
  }
  return ret;
}

function getFieldsDescMap(obj){
  var ret = [];
  var zones = [];
  if(obj.showReportZone){
    if(obj.reportheader.options.afterPageHeader){
      if(obj.showPageZone)
        zones.push('pageheader');
      zones.push('reportheader');
    }
    else
      zones.push('reportheader');
  }
  if(obj.showPageZone && zones.indexOf("pageheader")<0)
    zones.push('pageheader');
  if(obj.showGroupZone)
    zones.push('groupheader');
  zones.push('groupbody');
  if(obj.showGroupZone)
    zones.push('groupfooter');
  if(obj.showReportZone && obj.reportfooter.options.beforePageFooter)
    zones.push('reportfooter');
  if(obj.showPageZone)
    zones.push('pagefooter');
  if(obj.showReportZone && zones.indexOf("reportfooter")<0)
    zones.push('reportfooter');

  var k;
  for(var l=0; l<zones.length; l++){
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for (k = 0; k < melements.length; k++) {
      var typeView = melements[k].typeView.toLowerCase();
      if (!Empty(melements[k].fieldDetail.alias) && typeView != "signmup")  // per coerenza con web report
        ret[melements[k].uid] = Empty(melements[k].fieldDetail.desc) ? melements[k].fieldDetail.alias : melements[k].fieldDetail.desc;
    }
  }
  return ret;
}

function endsWith(str, suffix) {
  return str.indexOf(suffix, str.length - suffix.length) !== -1;
}

function ToStringHTML(p_cVar) {
  if(Empty(p_cVar)) return p_cVar;
  var arrsplit = p_cVar.split(/[\n\r]/g);
  if(arrsplit.length>0){
    p_cVar = ToHTML(arrsplit[0]);
    for(var k=1; k<arrsplit.length; k++)
      p_cVar = p_cVar + '<br/>' + ToHTML(arrsplit[k]);
  }
  p_cVar = Strtran(p_cVar, " ", "&nbsp;");
	return p_cVar;
}

function getImagesAlias(obj){
  var ret = {};
  var zones = [];
  if(obj.showGroupZone){
    zones.push('groupheader');
    zones.push('groupfooter');
  }
  if(obj.showPageZone){
    zones.push('pageheader');
    zones.push('pagefooter');
  }
  if(obj.showReportZone){
    zones.push('reportheader');
    zones.push('reportfooter');
  }
  zones.push('groupbody');
  var l,k;
  ret.fields = [];
  ret.generic = [];
  for(l=0; l<zones.length; l++){
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for(k=0; k<melements.length; k++){
      if(melements[k].typeView=="image"){
        if(!Empty(melements[k].fieldDetail.alias) && ret.fields.indexOf(melements[k].fieldDetail.alias)<0)
          ret.fields.push(melements[k].fieldDetail.alias);
        else
          ret.generic.push(melements[k].style.imageSrc);
      }
    }
  }
  return ret;
}

function printMessageDiv(uid, msg) {
  window[uid].removeLoading();
  if(window[uid].offline) {
    var errdiv = document.createElement("div");
    errdiv.className = "label";
    errdiv.innerHTML = msg;
    errdiv.style.textAlign = "center";
    window[uid].container.innerHTML = "";
    window[uid].container.appendChild(errdiv);
  }
  else {
    var srcurl = "../jsp-system/SPReportMaskMessage_portlet.jsp?title=RPT_ERROR&msgBox=" + msg
    var iframe;
    if(window[uid].container.tagName.toLowerCase()=='iframe') {
      iframe = window[uid].container;
    }
    else {
      window[uid].setIFrame();
      iframe = document.getElementById(window[uid].container.id+"ifrprev");
    }
    if (iframe) {
      iframe.frameborder = 0;
      iframe.style.border = 0;
      iframe.allowTransparency = true;
      if(!window[uid].offline && (window[uid].autodownload || window[uid].autoprint)) {
        iframe.onload = function() {
          var framedoc = ( this.contentWindow || this.contentDocument );
          if(framedoc && framedoc.ZtVWeb &&  framedoc.ZtVWeb.getPortletWindow("SPReportMaskMessage")) {
            var ptl = framedoc.ZtVWeb.getPortletWindow("SPReportMaskMessage");
            if(ptl.labelText)
              alert (ptl.labelText.Value());
          }
        }
      }
      var framedoc = ( iframe.contentWindow || iframe.contentDocument ).document;
      windowOpenForeground(srcurl, iframe.name, null, null, null, framedoc);
    }
  }
}

function getFieldsDetailMap(obj) {
  var ret = [];
  var zones = [];
  if (obj.showReportZone) {
    if (obj.reportheader.options.afterPageHeader) {
      if (obj.showPageZone)
        zones.push('pageheader');
      zones.push('reportheader');
    }
    else
      zones.push('reportheader');
  }
  if (obj.showPageZone && zones.indexOf("pageheader") < 0)
    zones.push('pageheader');
  if (obj.showGroupZone)
    zones.push('groupheader');
  zones.push('groupbody');
  if (obj.showGroupZone)
    zones.push('groupfooter');
  if (obj.showReportZone && obj.reportfooter.options.beforePageFooter)
    zones.push('reportfooter');
  if (obj.showPageZone)
    zones.push('pagefooter');
  if (obj.showReportZone && zones.indexOf("reportfooter") < 0)
    zones.push('reportfooter');

  var k;
  for (var l = 0; l < zones.length; l++) {
    var melements = getZoneElementsType(obj, zones[l], 'field');
    for (k = 0; k < melements.length; k++) {
      if (!Empty(melements[k].fieldDetail.alias) && !ret[melements[k].fieldDetail.alias])
        ret[melements[k].fieldDetail.alias] = Empty(melements[k].fieldDetail.desc) ? melements[k].fieldDetail.alias : melements[k].fieldDetail.desc;
    }
  }
  return ret;
}

function b64toBlob(b64Data, contentType, isB64) {
  contentType = contentType || '';
  var byteCharacters = isB64 ? atob(b64Data) : b64Data,
  len = byteCharacters.length,
  buffer = new ArrayBuffer(len),
  view = new Uint8Array(buffer);
  for (var i = 0; i < len; i++) {
    view[i] = byteCharacters.charCodeAt(i);
  }
  var blob,
  _Blob = getBlob();
  blob = new _Blob([view], {type: contentType});
  return blob;
}

function getBlob() {
  /*var _Blob = Blob;
  if (window.GetOpener() && window.GetOpener().Blob)
    _Blob = window.GetOpener().Blob;
  return _Blob;
  */
  return Blob;
}

function transformTag(tagIdOrElem, tagType){
  var elem = (tagIdOrElem instanceof HTMLElement) ? tagIdOrElem : document.getElementById(tagIdOrElem);
  if(!elem || !(elem instanceof HTMLElement))return;
  var children = elem.childNodes;
  var parent = elem.parentNode;
  if(!parent)
    return false;
  if(elem.tagName.toLowerCase() == tagType.toLowerCase())
    return false;
  var newNode = document.createElement(tagType||"span");
  for(var a=0;a<elem.attributes.length;a++){
      newNode.setAttribute(elem.attributes[a].nodeName, elem.attributes[a].value);
  }
  for(var i= 0,clen=children.length;i<clen;i++){
      newNode.appendChild(children[0]); //0...always point to the first non-moved element
  }
  newNode.style.cssText = elem.style.cssText;
  parent.replaceChild(newNode,elem);
  return true;
}

function generateBarcode(item, value, ctrl, w, h, imgOnLoad, create) {
  if (!ctrl)
    return;
  try {
    var barcodetype = item.barcode.type.toLowerCase();
    if (barcodetype == 'upc-a')
      barcodetype = 'upc';
    if (barcodetype == 'ean-8')
      barcodetype = 'ean8';
    if (barcodetype == 'ean-13')
      barcodetype = 'ean13';
    var ctrlid = ctrl.id;
    switch (barcodetype) {
      case  "qrcode": //qrcode2.js
        if (create)
          return;
        if (transformTag(ctrl, "div"))
          ctrl = Ctrl(ctrlid);
        ctrl.innerHTML = "";
        var oQRCode = new QRCode(ctrl, {
          width : w,
          height : h,
          colorDark : item.barcode.pixeloncolor,
          colorLight : item.barcode.pixeloffcolor
        });
        oQRCode._oDrawing._elImage.style.width = "100%";
        oQRCode._oDrawing._elImage.style.height = "100%";
        if (imgOnLoad)
          oQRCode._oDrawing._elImage.addEventListener('load', imgOnLoad);
        oQRCode.makeCode(value);
        transformTag(ctrl, "div")
        ctrl.setAttribute("data-value",value);
        break;
      case "pdf417": //bcmath-min.js pdf417.js
        if (transformTag(ctrl, "img"))
          ctrl = Ctrl(ctrlid);
        PDF417.init(value);
        var barcode = PDF417.getBarcodeArray();
        // block sizes (width and height) in pixels
        var bw = 2;
        var bh = 2;
        var canvas = document.createElement('canvas');
        //ctrl.appendChild(canvas);
        canvas.width = bw * barcode['num_cols'];
        canvas.height = bh * barcode['num_rows'];
        var ctx = canvas.getContext('2d');
        // graph barcode elements
        var y = 0;
        // for each row
        for (var r = 0; r < barcode.num_rows; ++r) {
          var x = 0;
          // for each column
          for (var c = 0; c < barcode.num_cols; ++c) {
            if (barcode['bcode'][r][c] == 1) {
              ctx.fillStyle = item.barcode.pixeloncolor;
              ctx.fillRect(x, y, bw, bh);
            }
            else {
              ctx.fillStyle = item.barcode.pixeloffcolor;
              ctx.fillRect(x, y, bw, bh);
            }
            x += bw;
          }
          y += bh;
        }
        if (imgOnLoad)
          ctrl.addEventListener('load', imgOnLoad);
        ctrl.setAttribute("data-value",value);
        ctrl.src = canvas.toDataURL("image/png");
        break;
      case "ean8"://JsBarcode.all.js
      case "ean13":
      case "upc":
      case "code39":
      case "code128":
      case "codabar":
      default:
        if (transformTag(ctrl, "img"))
          ctrl = Ctrl(ctrlid);
        if (imgOnLoad)
          ctrl.addEventListener('load', imgOnLoad);
        ctrl.setAttribute("data-value", value);
        JsBarcode(ctrl, value, {
          format: barcodetype,
          lineColor: item.barcode.pixeloncolor,
          background: item.barcode.pixeloffcolor,
          height: h,
          margin: 0,
          displayValue: false
        })
        
        if (ctrl.tagName.toLowerCase() == "svg") {
          ctrl.setAttribute("preserveAspectRatio", "none");
          ctrl.setAttribute("width", "100%");
          ctrl.setAttribute("height", "100%");
          var svg_w = parseFloat(ctrl.getAttribute("width"));
          if (svg_w > w) {
            item._newWidth = svg_w;
          }
        }

        break;
    }
  }
  catch(e) {
    //console.log(e)
  }
}

function resize(evt, uid) {
  if (evt && evt.srcElement) {
    var wnd = evt.srcElement;
    if (!wnd[uid] || !wnd[uid].end)
      return;
    wnd[uid].container.style.height = (wnd.innerHeight - 2) + "px";
  }
}

function getFontsFromObj(obj) {
  var sections = [ 
      'reportheader' 
    , 'pageheader'
    , 'groupheader'
    , 'groupbreak'
    , 'groupbody'
    , 'groupfooter'
    , 'pagefooter'
    , 'reportfooter'
  ],
  flist = [],
  tarr,
  font;
  for (var i = 0; i < sections.length; i++) {
    tarr = obj[sections[i]].items;
    for (var j = 0; j < tarr.length; j++) {
      if (tarr[j].style && tarr[j].style.font && tarr[j].style.font.fontName) {
        font = tarr[j].style.font.fontName;
        if (tarr[j].style.font.bold)
          font += "_bold";
        if (tarr[j].style.font.italic)
          font += "_italic";
        if (flist.indexOf(font) < 0)
          flist.push(font);
      }
    }
  }
  
  return flist;
}
