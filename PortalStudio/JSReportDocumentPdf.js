/* global generateBarcode convertStringToPx ptTopx jspdf setCurrentDateTime zRuntime b64toBlob */
/*jshint laxcomma: true */
( function (window, document) {
/*** CLASSE RepDocumentPdf: gestisce la generazione/disegno del documento (report) in formato pdf
  * Eredita da RepDocument - JSReportDocumentRuntime.js
*/

function privateContext (name, uid) {

  var datauristring;

  function RepDocumentPdf (options, uid) {
    var jspdf =
        (document.getElementById("visualweb/jspdf.js") || {}).href ||
        (window.ZtVWeb
          ? ZtVWeb.SPWebRootURL + "/visualweb/jspdf.js"
          : "../visualweb/jspdf.js"),
      jspdfmore =
        (document.getElementById("visualweb/jspdf-more.js") || {}).href ||
        (window.ZtVWeb
          ? ZtVWeb.SPWebRootURL + "/visualweb/jspdf-more.js"
          : "../visualweb/jspdf-more.js");
    LibJavascript.RequireLibrary(jspdf);
    LibJavascript.RequireLibrary(jspdfmore);
    RepDocument.call(this);
    this.format = "pdf";
    this.gcurrpage = null;
    this.lastElement = null;
    this.datetime = new Date();
    this.options = options;
    if( typeof(options) == 'string' ){
      this.name = options || 'smartreport';
    }
    else {
      this.name = options.filePath || 'smartreport';
    }
    if(Empty(uid)) uid = LibJavascript.AlfaKeyGen(5);
    this.uid = uid;
  };

  RepDocumentPdf.prototype = new RepDocument();
  RepDocumentPdf.prototype.constructor = RepDocumentPdf;

  RepDocumentPdf.prototype.initProcess = function(allfields,container,bprint,imgfields,simulatedData){
    this.container = container;
    this.setParent();
    this.setDocument();
    this.setWindow();
    var pformat = this.obj.page.format.toLowerCase();
    var porientation = this.obj.page.orientation.toLowerCase();
    if(this.obj.page.format.toLowerCase() == 'custom') {
      var w = this.obj.page.width + "mm";
      var h = this.obj.page.height + "mm";
      var ww = convertStringToPx(w)/ptTopx;
      var hh = convertStringToPx(h)/ptTopx;
      if(porientation == 'portrait')
        porientation = 'n';
      else
        porientation = 's';
      pformat = [];
      pformat[0] = ww;
      pformat[1] = hh;
    }
    this.jspdf = new jspdf.jsPDF(porientation,"pt",pformat);
    if (bprint){
      this.jspdfprint = new jspdf.jsPDF(porientation,"pt",pformat);
      this.jspdfprint.autoPrint();
    }
    else
      this.jspdfprint = null;
    this.allfields = allfields;
    this.imgfields = imgfields;
    this.mrows = 0;
    this.lastRec = null;
    this.simulatedData = simulatedData;
  };

  RepDocumentPdf.prototype.appendFontsInDocument = function () {
    var list = this._fontList;
    for (var i = 0; i < list.length; i++) {
      this.jspdf.addFileToVFS(list[i] + ".ttf", window._fontMap[list[i]].cont);
      this.jspdf.addFont(list[i] + ".ttf", window._fontMap[list[i]].name, window._fontMap[list[i]].style);
      this.jspdf.addFont(list[i] + ".ttf", window._fontMap[list[i]].name.toLowerCase(), window._fontMap[list[i]].style);
      if (this.jspdfprint != null) {
        this.jspdfprint.addFileToVFS(list[i] + ".ttf", window._fontMap[list[i]].cont);
        this.jspdfprint.addFont(list[i] + ".ttf", window._fontMap[list[i]].name, window._fontMap[list[i]].style);
        this.jspdfprint.addFont(list[i] + ".ttf", window._fontMap[list[i]].name.toLowerCase(), window._fontMap[list[i]].style);
      }
    }
  };

  RepDocumentPdf.prototype.endProcess = function(){
    var totP = (this.isPreview && this.isEoPreview()) ? this.gwork.rpagecounter : this.gwork.pagecounter;
    this.jspdf.putTotalPages("Total pages", totP);
    if (this.jspdfprint != null)
      this.jspdfprint.putTotalPages("Total pages", totP);
    if(this.autoprint)this.jspdf.autoPrint();
    if(this.container.tagName.toLowerCase()=='iframe')
      this.addInFrame(this.container);
    else{
      this.setIFrame();
      this.addInFrame(document.getElementById(this.container.id+"ifrprev"));
    }
    this.removeLoading();
    if(this.autodownload)this.download();
    this.end = true;
    this.removeCanvasImages();
    if (!this._dontruncb)
      this.execFncCallback();
  };

  RepDocumentPdf.prototype.removeLastLabelContinue = function(){
    // ripreso da algoritmo page numb in jspdf.js
    function removelabelcontinue(jspdf){
      if(jspdf==null) return;
      var lastpage = jspdf.internal.getNumberOfPages();
      var i,n;
      var replaceExpression = new RegExp("CONTINUE_GF", 'g');
      for(n=1; n<=lastpage; n++){
        for(i=jspdf.internal.pages[n].length-1; i>=0; i--){
          if(jspdf.internal.pages[n][i].search(replaceExpression)>=0)
            jspdf.internal.pages[n].splice(i,1);
        }
      }

      replaceExpression = new RegExp("CONTINUE", 'g');
      for(i=jspdf.internal.pages[lastpage].length-1; i>=0; i--){
          if(jspdf.internal.pages[lastpage][i].search(replaceExpression)>=0)
            jspdf.internal.pages[lastpage].splice(i,1);
      }
    };
    removelabelcontinue(this.jspdf);
    removelabelcontinue(this.jspdfprint);
  };

  RepDocumentPdf.prototype.pageNumber = function(){
  };

  RepDocumentPdf.prototype.drawNewPage = function(firstpage){
    function insertpage(jspdf){
      if(jspdf==null) return;
      if(!firstpage)
        jspdf.addPage();
    };
    insertpage(this.jspdf);
    insertpage(this.jspdfprint);
    this.lastElement = null;
    this.updateLoading();
  };

  RepDocumentPdf.prototype.getLastChildElement = function(){
    return this.lastElement;
  };

  RepDocumentPdf.prototype.addCurrentZone = function (objzone /*, zoneid*//*, numrec*/ ){
    this.lastElement = { height : objzone.height /*px*/
                       , left : 0 /*px*/
                       , width : this.gwork.ww - ( this.gwork.marginl + this.gwork.marginr ) /*px*/
                       , top : ( ( ( this.lastElement || {} ).height || 0 )
                               + ( ( this.lastElement || {} ).top    || 0 )
                               ) /*px*/
                       }
    ;
  };

  RepDocumentPdf.prototype.updateZoneHeight = function(h){
    if(this.lastElement && this.lastElement.height)
      this.lastElement.height = this.lastElement.height+h;
  };

  RepDocumentPdf.prototype.getItemValue = function(k, item, zoneid, repObj, useLastRecord){
    var value = "";
    var mdata = useLastRecord?repObj.lastRec:repObj.propertyValue[k];
    if(item.type=="label"){
      value = item.value;
      if(item.isContinue && zoneid!="pagefooter" && repObj.lastGrpFooter)
        value+="_GF";
    }
    else if(item.typeView=="pagenum"){
      if(item.fieldDetail.desc == "Page number")
        value = repObj.gwork.pagecounter;
      else
        value = item.fieldDetail.desc;
    }
    else if(item.typeView.indexOf("date")>=0){
      if(item.isGeneric)
        value = setCurrentDateTime(repObj.datetime,item);
      else if(mdata[item.fieldDetail.alias+'_pic']) 
        value = mdata[item.fieldDetail.alias+'_pic'];
      else
        value = setCurrentDateTime(mdata[item.fieldDetail.alias],item);
    }
    else if(item.typeView=='numeric'){
      if(item.calculation && item.calculation.type!='none')
        value = repObj.setFormatNumber(repObj.calcObjs[item.fieldDetail.alias][item.uid],item.fieldDetail.len,item.fieldDetail.dec,item.stdPicture);
      else if ("value" in item) // totale
        value = repObj.setFormatNumber(item.value, null, null, item.stdPicture);
      else if(mdata[item.fieldDetail.alias+'_pic']) 
        value = mdata[item.fieldDetail.alias+'_pic'];
      else
        value = repObj.setFormatNumber(mdata[item.fieldDetail.alias],item.fieldDetail.len,item.fieldDetail.dec,item.stdPicture);
    }
    else if (item.fieldDetail && item.fieldDetail.type == "checkbox")
      item.style.imageSrc = (Empty(mdata[item.fieldDetail.alias])) ? repObj.uncheckedSrc : repObj.checkedSrc;
    else if (item.type!="line") {
      if(mdata[item.fieldDetail.alias+'_pic']) 
        value = mdata[item.fieldDetail.alias+'_pic'];
      else
        value = Format(mdata[item.fieldDetail.alias],item.fieldDetail.len,item.fieldDetail.dec,item.stdPicture);
    }
    return value;
  };

  RepDocumentPdf.prototype.getTextDimensions = function(text, font) {
    var fsize = convertStringToPx(font.size),
    px2pt = 72 / 96;
    var numr = 1;
    if(!Empty(text)) numr = text.split(/[\n\r]/g).length;
    var fstyle = "";
    if(font.weight == 'bold')
      fstyle = "bold";
    if(font.italic == 'italic')
      fstyle += "italic";
   /* if(!Empty(fstyle))
      this.jspdf.setFontStyle(fstyle);
    else
      this.jspdf.setFontStyle("normal");*/
    var fname = font.name;
    if (fname.indexOf("Times") >= 0)
      fname = "times";
    if(!Empty(fstyle))
      this.jspdf.setFont(fname, fstyle);
    else
      this.jspdf.setFont(fname, "normal");
    var w = Math.round(this.jspdf.getStringUnitWidth(text, { fontSize: fsize*px2pt} ) * fsize);
    return { width : w /*px*/
           , height: fsize * numr /*px*/
           };
  }

  RepDocumentPdf.prototype.addItemInZone = function (k, item, objzone, zoneid, value, yRel/*, split, nrow*/) {
    function hex2rgb ( colorhex ) {
      // inspired by jspdf
      var hex = parseInt( colorhex.substr( 1 ), 16 );
      return [ ( hex >> 16 ) & 255 /*R*/
             , ( hex >> 8  ) & 255 /*G*/
             ,   hex         & 255 /*B*/
             ];
    } // hex2rgb

    function insertinpdf(jspdf, repobj, zoneid){
      if (jspdf == null)
        return;

      var myimg, txtDimensions, msrc
      , px2pt = 72 / 96
      , posObj = { x : item.position.x + repobj.lastElement.left + repobj.gwork.marginl
                 , y : yRel + repobj.lastElement.top + repobj.gwork.margint
                 , w : item.position.width
                 , h : item.position.height
                 }
      , fstyle = ""
      ;
      var noprint = false;

      if (zoneid == "groupfooter" && repobj.obj.groupfooter.options.printOnGroupBreak && !repobj.lastGrpFooter)
        noprint = true;
      var opt, loaded;
      switch (item.typeView) {
        case "line":
          var tmpw = posObj.w;
          if (item.style.stretchToRight) {
            var nl = repobj.gwork.ww - repobj.gwork.marginl - repobj.gwork.marginr - posObj.x;
            tmpw = nl;
          }
          jspdf.setFillColor.apply( jspdf, hex2rgb( item.style.line.color ) );
          jspdf.setDrawColor.apply( jspdf, hex2rgb( item.style.line.color ) );
          if(item.style.line.onlyStroke) {
            jspdf.rect( posObj.x * px2pt /*x1*/
                         , posObj.y * px2pt /*y1*/
                         , tmpw * px2pt /*x2*/
                         , posObj.h * px2pt /*y2*/
                         , 'S'
                         );
          }
          else {
            jspdf.rect( posObj.x * px2pt /*x1*/
                         , posObj.y * px2pt /*y1*/
                         , tmpw * px2pt /*x2*/
                         , posObj.h * px2pt /*y2*/
                         , 'F'
                         );
          }

          break;
        case "barcode" :
          opt = {};
          msrc = LibJavascript.AlfaKeyGen(5);
          opt.x = Math.round(posObj.x*px2pt);
          opt.y = Math.round(posObj.y*px2pt);
          opt.width = Math.round(posObj.w*px2pt);
          opt.height = Math.round(posObj.h*px2pt);
          opt.alias = msrc;
          opt.nPage = jspdf.internal.getCurrentPageInfo().pageNumber;
          opt.barcode = true;
          opt._newWidth = 0;
          opt._msrc = msrc;
          repobj.optMapImg.push(opt);
          repobj.imgMap[msrc] = new Image();
          repobj.imgMap[msrc].id = msrc;
          loaded = function(){
            repobj.imgCount++;
            repobj.imgMap[msrc] = this;
            var item = repobj.optMapImg.filter(function(item){ return item._msrc == msrc; }),
            iw = this.width;
            if (!Empty(item) && !Empty(item[0])) {
              if (item[0].width < iw)
                item[0]._newWidth = iw * px2pt;
            }
          }
          generateBarcode(item, value, repobj.imgMap[msrc], opt.width, opt.height, loaded);
          break;
        case "html" :
          if (!repobj.simulatedData) {
            var mid = k + "_" + (item.colIdx || "") + "_" + zoneid + "_" + item.fieldDetail.alias,
            mvalue = item.style.htmlSrc;
            if (!item.isGeneric)
              mvalue = value;
            repobj.renderHTMLtoCanvas(item, mvalue, mid);

            if (noprint && !item.isGeneric) { }
            else {
              opt = {};
              opt.x = posObj.x*px2pt;
              opt.y = posObj.y*px2pt;
              opt.width = posObj.w*px2pt;
              opt.height = posObj.h*px2pt;
              opt.alias = mid;
              opt.nPage = jspdf.internal.getCurrentPageInfo().pageNumber;
              repobj.optMapImg.push(opt);
            }
          }
          break;
        case "image":
          if (!repobj.simulatedData) {
            if (item.isGeneric)
              msrc = item.style.imageSrc;
            else
              msrc = repobj.propertyValue[k][item.fieldDetail.alias];

            // tratto il caso src:tooltip che potrebbe arrivarmi da griglia o da query
            var dp_split = msrc.split(":");
            if (dp_split.length > 1)
              msrc = dp_split[0];

            if (msrc.indexOf(repobj.rootApp)!=0 && msrc.indexOf(repobj.rootAppB)!=0 && !Empty(msrc))
              msrc = repobj.rootApp + msrc;

            if (noprint && !item.isGeneric) { }
            else {
              if (repobj.offline) {
                myimg = repobj.imgMap[msrc];
                if (typeof(myimg) != "undefined")
                  jspdf.addImage(myimg,"png",posObj.x*px2pt,posObj.y*px2pt,posObj.w*px2pt,posObj.h*px2pt,myimg.src);
              }
              else {
                opt = {};
                opt.x = posObj.x*px2pt;
                opt.y = posObj.y*px2pt;
                if (item.isGeneric && item.fieldDetail && item.fieldDetail.type == "checkbox")
                  opt.width = opt.height = Math.min(posObj.w, posObj.h) * px2pt;
                else {
                  opt.width = posObj.w*px2pt;
                  opt.height = posObj.h*px2pt;
                }
                opt.alias = msrc;
                opt.nPage = jspdf.internal.getCurrentPageInfo().pageNumber;
                repobj.optMapImg.push(opt);

                if (!Empty(msrc) && !(msrc in repobj.imgMap)) {
                  repobj.imgMap[msrc] = new Image();
                  repobj.imgMap[msrc].src = msrc;

                  // onload
                  loaded = function() {
                    repobj.imgCount++;
                  }

                  if (repobj.imgMap[msrc].complete)
                    loaded();
                  else
                    repobj.imgMap[msrc].addEventListener('load', loaded);
                }
              }
            }
          }
          break;
        case "signmup":
          opt = {};
          opt.title = item.signmup.title;
          opt.obligatory = item.signmup.brequired;
          opt.requirePosition = item.signmup.bgeoposition;
          opt.signIdx = item.signmup.sequence;
          var df = item.signmup.dateformat;
          var tf = item.signmup.timeformat;
          if(df == 'None') df = '';
          if(tf == 'None') tf = '';
          if(!Empty(df)){
            df = Strtran(df, "Y", "y");
            df = Strtran(df, "D", "d");
          }
          if(!Empty(tf)){
            tf = Strtran(tf, "M", "m");
            tf = Strtran(tf, "S", "s");
          }
          if(!Empty(df) && !Empty(tf)) df = df + ' ' + tf;
          else if(Empty(df) && !Empty(tf)) df = tf;
          if(!Empty(df))
            opt.dateFormat = df;
          opt.hideExtraText = item.signmup.bhideextra;
          opt.x = Math.round(posObj.x*px2pt);
          opt.y = Math.round(posObj.y*px2pt);
          opt.width = Math.round(posObj.w*px2pt);
          opt.height = Math.round(posObj.h*px2pt);
          jspdf.createMarkup(opt);
          break;
        default:
          var numr = 1;
          value = value + '';
          var fname = item.style.font.fontName.toLowerCase();
          if (fname.indexOf("times") >= 0)
            fname = "times";
          if (!Empty(value))
            numr = value.split(/[\n\r]/g).length;
          txtDimensions = repobj.getTextDimensions(value
            , {
              name: fname
              , size: item.style.font.fontSize
              , weight: item.style.font.bold ? 'bold' : 'normal'
              , italic: item.style.font.italic ? 'italic' : 'normal'
            }
          );
          posObj.y += txtDimensions.height / numr;
          // font
          if (item.style.font.bold)
            fstyle = "bold";
          if (item.style.font.italic)
            fstyle += "italic";
          /*if(!Empty(fstyle))
            jspdf.setFontStyle(fstyle);
          else
            jspdf.setFontStyle("normal");*/
          if (!Empty(fstyle))
            jspdf.setFont(fname, fstyle);
          else
            jspdf.setFont(fname, "normal");
          var fsize = convertStringToPx(item.style.font.fontSize);
          jspdf.setFontSize(fsize * px2pt);
          jspdf.setTextColor(item.style.font.fontColor);

          if (item.style.font.right)
            posObj.x += posObj.w - txtDimensions.width;
          else if (item.style.font.center)
            posObj.x += (posObj.w - txtDimensions.width) / 2;

          if (noprint && item.type == 'field' && !item.isGeneric && item.typeView != "image")
            value = "";
          jspdf.text(value + '', posObj.x * px2pt, posObj.y * px2pt);

          if (item.style.font.underline) {
            jspdf.setDrawColor(item.style.font.fontColor);
            jspdf.line(posObj.x * px2pt, (posObj.y + 2) * px2pt, (posObj.x + txtDimensions.width + 2) * px2pt, (posObj.y + 2) * px2pt);
            jspdf.setDrawColor("#000000");  // ripristino default
          }

          if (item.style.font.strikeout) {
            jspdf.setDrawColor(item.style.font.fontColor);
            jspdf.line(posObj.x * px2pt, (posObj.y - (fsize / 2) + 2) * px2pt, (posObj.x + txtDimensions.width + 2) * px2pt, (posObj.y - (fsize / 2) + 2) * px2pt);
            jspdf.setDrawColor("#000000");  // ripristino default
          }

          break;
      }
    };

    if( value == null )  value = '';
    insertinpdf(this.jspdf, this, zoneid);
    insertinpdf(this.jspdfprint, this, zoneid);
  }; // addItemInZone

  RepDocumentPdf.prototype.renderHTMLtoCanvas = function (item, value, ctrlid) {
    var doc = document,
    mdiv = doc.createElement("div"),
    id = ctrlid + "_canvimg";
    if (!Empty(doc.getElementById(id)))
      mdiv = doc.getElementById(id);
    else {
      mdiv.id = id;
      mdiv.style.visibility = "hidden";
      mdiv.innerHTML = value;
      mdiv.style.position = "absolute";
      mdiv.style.top = "0px";
      mdiv.style.left = "0px";
      mdiv.style.width = item.position.width + "px";
      mdiv.style.height = item.position.height + "px";
      doc.body.appendChild(mdiv);
    }

    if (typeof html2canvas !== 'undefined') {
      var repobj = this;
      html2canvas(mdiv, {
          onrendered : function (newCanvas) {
            var img = new Image();
            img.src = newCanvas.toDataURL('image/png');
            repobj.imgMap[Strtran(id, "_canvimg", "")] = img;
            repobj.imgCount++;
            if (doc.getElementById(id))
              doc.getElementById(id).parentNode.removeChild(doc.getElementById(id));
          },
          width: item.position.width,
          height: item.position.height
      });
    }
  }

  var mcounter = 1;
  RepDocumentPdf.prototype.checkImages = function () {
    var repobj = this;
    var currimg = repobj.imgCount;
    var totimg = Object.keys(repobj.imgMap).length;

    if (currimg != totimg && mcounter <= 5) {
      setTimeout( function () {
        repobj.checkImages();
        mcounter ++;
      }, 250)
      return;
    }

    putImagesInPDF(this.jspdf);
    if (this.jspdfprint)
      putImagesInPDF(this.jspdfprint);

    function putImagesInPDF(jspdf) {
      /* potrebbero esserci problemi in rendering delle immagini gif */
      for (var kk = 0; kk < repobj.optMapImg.length; kk++) {
        jspdf.setPage(repobj.optMapImg[kk].nPage);
        try {
          if (repobj.optMapImg[kk].alias in repobj.imgMap) {
            var img = repobj.imgMap[repobj.optMapImg[kk].alias];
            jspdf.addImage( img,
                            "png",
                            repobj.optMapImg[kk].x,
                            repobj.optMapImg[kk].y,
                            repobj.optMapImg[kk]._newWidth || repobj.optMapImg[kk].width,
                            repobj.optMapImg[kk].height,
                            repobj.optMapImg[kk].alias
                          );
          }
        }
        catch (e) {
          //console.log(e)
        }
      }
    }

    this.endProcess();
    delete this.obj.emptyzone;

    if (this.end && this.format == "IARViewer" && window.navigator.userAgent.match( /zRuntime/ )) {
      this.view(this.fncCallBack);
    }
  }

  RepDocumentPdf.prototype.getDataUrl = function () {
    datauristring || ( datauristring = this.jspdf.output( 'datauristring' ) );
    return datauristring;
  };

  RepDocumentPdf.prototype.download = function () {
    var akey = LibJavascript.AlfaKeyGen(5);
    var a = document.createElement('a');
    a.setAttribute("id", akey);
    document.body.appendChild(a);
    this.generatePdfUrl(a, true);
  };

  RepDocumentPdf.prototype.addInFrame = function (iframe) {
    if (iframe) {
      if (Empty(iframe.name))
        iframe.name = iframe.id;
      this.generatePdfUrl(iframe);
    }
    this.removeLoading();
  };

  RepDocumentPdf.prototype.print = function () {
    if(this.jspdfprint==null) return;
    var self = this;
    if ( window.navigator.userAgent.match( /zRuntime/ ) ) {
      window.SPOfflineLib.importCordova(
        function saveAndPrint () {
          window.zRuntime.pdf.print( self.getDataUrl()
                                   , function success () {}
                                   , fail
                                   );
        }
      , fail
      );

      function fail (error) {
        console.log( error );
        alert( "Unexpected error: " + error );
      }
    }
    else {
      var iframeid = this.uid + "streamiframe"
        , iframe = document.getElementById( iframeid )
        ;
      if ( !iframe ) {
        iframe = document.createElement("IFRAME");
        iframe.id = iframeid;
        iframe.name = iframeid;
        iframe.width = "1px";
        iframe.height = "1px";
        iframe.frameborder = 0;
        iframe.style.border = 0;
        iframe.allowTransparency = true;
        document.body.appendChild(iframe);
      }
      this.generatePdfUrl(iframe);
    }
  };

  RepDocumentPdf.prototype.view = function (successCallback) {
    var self = this;
    if ( window.navigator.userAgent.match( /zRuntime/ ) ) {
      function fail (error) {
        console.log( error );
        alert( "Unexpected error: " + error );
      }

      function createView () {
        zRuntime.pdf.open( self.getDataUrl()
                                 , self.options
                                 , success
                                 , fail
                               );
        function success ( resultObj ) {
          /*
          resultObj
          {
            modified: indica se il pdf ha subito un processo di modifica da parte del viewer interno
            fileUri: percorso del file pdf sul dispositivo (se returnType = fileUri)
            base64: base64 del file pdf (se returnType = base64)
          }
          */
          if(successCallback){
            successCallback(resultObj, self);
          }
           window.close();
        }
      }

      (window.SPMobileLib || window.SPOfflineLib).importCordova( createView, fail );
    }
    else {
      var iframeid = this.uid+"streamiframe"
        , iframe = document.getElementById(iframeid)
        ;
      if ( !iframe ) {
        iframe = document.createElement("IFRAME");
        iframe.id = iframeid;
        iframe.name = iframeid;
        iframe.width = "1px";
        iframe.height = "1px";
        iframe.frameborder = 0;
        iframe.style.border = 0;
        iframe.allowTransparency = true;
        document.body.appendChild(iframe);
      }
      this.generatePdfUrl(iframe);
    }
  };

  RepDocumentPdf.prototype.drawPreviewValidator = function () {
    var mlimits;
    if(this.obj.page.format == 'custom') {
      mlimits = [];
      mlimits[0] = convertStringToPx(this.obj.page.width + "mm");
      mlimits[1] = convertStringToPx(this.obj.page.height + "mm");
    }
    else if (window.jsPDFPageFormats)
      mlimits = window.jsPDFPageFormats[this.obj.page.format.toLowerCase()];
    if (this.jspdf)
      drawTextValidator(this.jspdf, mlimits, this.obj, this.watermark);
    if (this.jspdfprint)
      drawTextValidator(this.jspdfprint, mlimits, this.obj, this.watermark);

    function drawTextValidator(jspdf, mlimits, obj, watermark) {
      //jspdf.setFontStyle("bold");
      jspdf.setFont("helvetica", "bold");
      jspdf.setFontSize(24);
      jspdf.setTextColor("#E51400");
      if(!Empty(watermark)) {
        var w = jspdf.getStringUnitWidth(watermark) * 24;
        if (obj.page.orientation.toLowerCase() == "portrait")
          jspdf.text(watermark, mlimits[0]/4, mlimits[1]/2 - Math.sin(45)*w/2, -45);
        else
          jspdf.text(watermark, mlimits[1]/4, mlimits[0]/2 - Math.sin(45)*w/2, -45);
      }
    }
  };

  RepDocumentPdf.prototype.generatePdfUrl = function (htmlItem, isDownload) {
    var durl = this.getDataUrl(),
    end_pos = durl.indexOf("base64,"),
    len = end_pos + ("base64,").length,
    mData = b64toBlob(durl.substr(len), "application/pdf", true),
    mUrl = URL.createObjectURL(mData);
    if (isDownload) {
      if (typeof htmlItem.download == "undefined") {
        if (navigator.msSaveBlob)
          navigator.msSaveBlob(mData, (Empty(this.name) ? LibJavascript.AlfaKeyGen(10) : this.name) + ".pdf");
        else
          (window.PSAlert||window).alert('Browser Not Implemented Client Side Download!!!');
      }
      else {
        htmlItem.href = mUrl;
        htmlItem.download = (Empty(this.name) ? LibJavascript.AlfaKeyGen(10) : this.name) + ".pdf";
        htmlItem.click();
        
      }
      document.body.removeChild(htmlItem);//rimuovere il link
    }
    else {
      var framedoc = ( htmlItem.contentWindow || htmlItem.contentDocument ).document;
      var srcurl;
      if (IsIE()) {
        if(mData.size <= 1572229) {  // valore in B testato su 2855 record in stampa da zoom e ultimo accettabile per la stampa - EG 20161020
          srcurl = ZtVWeb.SPWebRootURL + "/servlet/Base64DecodeDownload?base64data=" + durl + "&fileName=" + (Empty(this.name) ? LibJavascript.AlfaKeyGen(10) : this.name) + ".pdf";
          windowOpenForeground(srcurl, htmlItem.name, null, null, null, framedoc);
        }
        else {
          navigator.msSaveOrOpenBlob(mData)
          htmlItem.frameBorder = "no";
          htmlItem.allowTransparency = true;
          var msg = "RPT_TOO_BIG_FOR_VIEW";
          srcurl = "../jsp-system/SPReportMaskMessage_portlet.jsp?hideWarning=true&msgBox=" + msg;
          windowOpenForeground(srcurl, htmlItem.name, null, null, null, framedoc);
        }
      }
      else
        htmlItem.src = mUrl;
    }
  }

  return new RepDocumentPdf( name, uid );
} // privateContext
window.RepDocumentPdf = privateContext;
})(window, document);
