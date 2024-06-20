/*  exported dragstartx dragstarty newx newy mainitem index nitem nbaritem itemsHTML countindex
offsetimage fieldHTML fieldcountindex myGadgetPaneTimeOut
*/

/* global spTranslatedText */

//Tutti gli elementi sono item+n e le ombre sono shadow+n
//#######################################################
var dragstartx, dragstarty, newx, newy, mainitem;
var index; //indice corrente del mainitem nell'Array
var nitem = 0; //numero item crescente
var nbaritem = 0; //numero del item tipo bar crescente
var itemsHTML = []; //array contenente tutti gli oggetti item con id,HTML,shadow,ecc
var countindex = 0; //contatore indice array
var offsetimage = 6;

var fieldHTML = [];
var fieldcountindex = 0;
var rootApp = "../";
var myGadgetPaneTimeOut = '0';

function getTranslated(code, vdefault) {
  if(!code)
    return vdefault;
  if(window.GetOpener) {
    var w = window.GetOpener();
    if( w && w.getTranslated )
      return w.getTranslated(code, vdefault)
  }
  code = Upper( Strtran(code, " ", "") );
  code = Strtran(code, "[", "");
  code = Strtran(code, "]", "")
  code = Strtran(code, "'", "")
  if(!vdefault) vdefault = code;
  if( !spTranslatedText[code] || Empty( spTranslatedText[code] ) )
    return vdefault;
  if( spTranslatedText[code] == code )
    return vdefault;
  return spTranslatedText[code];
}

function initPropertiesDefaultValue(obj) {
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    var tab, ii;
    for (var i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        mainObject[tab[ii].propID] = tab[ii].defaultValue;
        if(!Empty(tab[ii].tooltip)) {
          tab[ii].tooltip_code = "SMR_" + tab[ii].propID + "_TOOLTIP";
        }
        if (typeof(tab[ii].defaultValue) == 'undefined') {
          if (tab[ii].type == 'str') { mainObject[tab[ii].propID] = ''; }
          else if (tab[ii].type == 'color') { mainObject[tab[ii].propID] = ''; }
          else if (tab[ii].type == 'checkbox') { mainObject[tab[ii].propID] = false; }
          else if (tab[ii].type == 'int') { mainObject[tab[ii].propID] = null; }
          else if (tab[ii].type.substring(0,7) == 'select[') {
            var s1 = tab[ii].type.substring(7, tab[ii].type.indexOf(","));
            var p = s1.indexOf(":");
            if (p >= 0) { s1 = s1.substring(p + 1); }
              mainObject[tab[ii].propID] = s1;
          }
        }
      }
    }
  }
}

function ConvertToView(item, isGeneric){
  if(!isGeneric) return item.fieldDet.desc;
  else{
    var str;
    if(item.typeView == 'datetime' && item.fieldDet.desc == 'Current datetime'){
      var d=new Date();
      str = item.fieldDet.desc;
      if(item.dateformat) str = FormatDate(d,item.dateformat);
      if(item.timeformat) str += " " + FormatDateTime(d,item.timeformat.toLowerCase());
      return str;
    }
    else if(item.typeView == 'pagenum'){
      str = getTranslated("SMR_" + item.fieldDet.desc, item.fieldDet.desc);
      return str;
    }
    else {
      return item.fieldDet.desc;
    }
  }
}

if (typeof(ZTObjects) == 'undefined') {
  var ZTObjects = new function () {
    this.format_select = "A0,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,letter,legal,tabloid,custom";
    this.orientation_select = "portrait,landscape";
    this.height_select = "select[0,1,2,3,4,5,6,7,8,9,10]";
    this.height_select2 = "select[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,17,18,19,20]";
    this.width_select = "select[0,1,2,3,4,5,6,7,8,9,10]";
    this.fonts_select = "Courier,DejaVu Sans,DejaVu Sans Condensed,DejaVu Sans Mono,DejaVu Serif,DejaVu Serif Condensed,Fira Sans,Helvetica,Open Sans,Raleway,Roboto,Times New Roman";
    this.measure_select = "millimeters,centimeters,points";
    this.pagenum_select = "Page number,Total pages";
    this.date_select = "DD-MM-YYYY,DD/MM/YYYY,YYYY-MM-DD,YYYY/MM/DD";
    this.time_select = "HH:MM,HH:MM:SS,HH.MM,HH.MM.SS";
    this.mupdate_select = "None,DD-MM-YYYY,DD/MM/YYYY,YYYY-MM-DD,YYYY/MM/DD";
    this.muptime_select = "None,HH:MM,HH:MM:SS,HH.MM,HH.MM.SS";
    this.calc_select = "none,sum";
    this.fldconv_select = "text,image,barcode";
    //this.pagepos_select = "Only first page,Only last page,Each page";
    this.viewmode_select = "Document design,Document view,Document PDF view";
    this.viewmode_values = "0,1,2";
    this.download_select = "Others download,CSV document,Standard CSV document,SDF document,XML document,Structured XML document";
    this.download_values = "DDOC,CSV,CSVS,SDF,XML,XMLS";
    this.barcode_select = "QRCode,PDF417,EAN-8,EAN-13,UPC-A,Code39,Code128,CODABAR";
    this.qrcodeselect_select = "L,M,Q,H";

    this.FormObjClass={
      newProperties:{
        generic:[
          {name:"Datasource", propID:"datasource", type:"str", validFunc:"SetDatasourceProp", tooltip:"Specifies the chosen query or business object", api_tab: spTranslatedText.SMR_DATASOURCEANDFIELDS },
          {name:"Parameters mask", propID:"vdmfile", type:"str", tooltip:"Specifies the chosen parameters mask", api_tab: spTranslatedText.SMR_DATASOURCEANDFIELDS}
        ],
        print:[
          {name:'paper format', propID:'pformat',type:"select["+this.format_select+"]", tooltip:'Choose report page format', defaultValue:"A4", actions:'setPageSettings', api_tab: spTranslatedText.SMR_PAGEOPTIONS, api_sect: spTranslatedText.SMR_FORMAT},
          {name:'paper height', propID:'pheight', type:"int", tooltip:'Set page format height (mm)',  defaultValue:"297", actions:'setPageSettings', api_tab: spTranslatedText.SMR_PAGEOPTIONS, api_sect: spTranslatedText.SMR_FORMAT},
          {name:'paper width',  propID:'pwidth',  type:"int", tooltip:'Set page format width (mm)',   defaultValue:"210", actions:'setPageSettings', api_tab: spTranslatedText.SMR_PAGEOPTIONS, api_sect: spTranslatedText.SMR_FORMAT},
          {name:'paper orientation', propID:'porientation',type:"select["+this.orientation_select+"]", tooltip:'Set report page format orientation', defaultValue:"portrait", actions:'setPageSettings', api_tab: spTranslatedText.SMR_PAGEOPTIONS, api_sect: spTranslatedText.SMR_ORIENTATION}
        ],
        margins:[
          {name:'margin top', propID:'mtheight', type:'str', tooltip:'', defaultValue:"11.88mm", validFunc:'SetPrintProp'},
          {name:'margin bottom', propID:'mbheight', type:'str', tooltip:'', defaultValue:"11.88mm", validFunc:'SetPrintProp'},
          {name:'margin left', propID:'mlwidth', type:'str', tooltip:'', defaultValue:"8.40mm", validFunc:'SetPrintProp'},
          {name:'margin right', propID:'mrwidth', type:'str', tooltip:'', defaultValue:"5mm", validFunc:'SetPrintProp'}
        ],
        designToolbar:[
          {name:"Report sections", propID:"showreportzone", type:"checkbox", defaultValue:false, actions:"showReportZone", tooltip:"Click to include/exclude report header and report footer from document", api_tab: spTranslatedText.SMR_SECTIONS},
          {name:"Page sections", propID:"showpagezone", type:"checkbox", defaultValue:false, actions:"showPageZone", tooltip:"Click to include/exclude page header and page footer from document", api_tab: spTranslatedText.SMR_SECTIONS},
          {name:"Group sections", propID:"showgroupzone",type:"checkbox", defaultValue:true, actions:"showGroupZone", tooltip:"Click to include/exclude group header and group footer from document", api_tab: spTranslatedText.SMR_SECTIONS}
        ],
        reportheader:[
          {name:"print after page header", propID:"afterPageHeader", type:"checkbox", defaultValue:false, tooltip:"Print report header after page header", api_tab: "Report section", api_sect: "Header"}
        ],
        pageheader:[],
        groupbreak:[
          {name:"start on new page", propID:"startNewPage", type:"checkbox", defaultValue:true, tooltip:"Begin a new page for each new data group", api_tab: "Grouping (break) section"}
        ],
        groupheader:[
          {name:"reprint on each page", propID:"hreprintOnPage", type:"checkbox", defaultValue:true, tooltip:"Reprint group header on new page", api_tab: "Group section", api_sect: "Header"}
        ],
        groupbody:[],
        groupfooter:[
          {name:"reprint on each page", propID:"freprintOnPage", type:"checkbox",defaultValue:true, tooltip:"Reprint group footer on new page", api_tab: "Group section", api_sect: "Footer"},
          {name:"print at end of page", propID:"atEndOfPage", type:"checkbox",defaultValue:true, tooltip:"Align group footer at the end of page", api_tab: "Group section", api_sect: "Footer"},
          {name:"print fields on group break", propID:"printOnGroupBreak", type:"checkbox", defaultValue:true, tooltip:"Print fields only when grouping condition changes", api_tab: "Group section", api_sect: "Footer"}
        ],
        pagefooter:[],
        reportfooter:[
          {name:"print before page footer", propID:"beforePageFooter", type:"checkbox",defaultValue:true, tooltip:"Print report footer before page footer", api_tab: "Report section", api_sect: "Footer"}
        ],
        rulersGrid:[
          {name:"Show rulers", propID:"showrulers", type:"checkbox", button:"Rulers", actions:"optRulers", defaultValue:true, tooltip:"Show or hide rulers", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_RULERS},
          {name:"Rulers unit", propID:"measureunit", type:"select["+this.measure_select+"]", text_select:this.measure_select, actions:"setMeasureUnit(event)", tooltip:"Set custom measure unit", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_RULERS},
          {name:"Show grid", propID:"showgrid", type:"checkbox", button:"Grid", actions:"optGrid", defaultValue:true, tooltip:"Show or hide grid", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID},
          {name:"Snap to grid", propID:"snapgrid", type:"checkbox", actions:"setSnapToGrid(event)", defaultValue:false, image:"url(images/snap.png)", tooltip:"Click to snap items to grid", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID},
          {name:"Rulers tick 50", propID:"tick50", addclass:"smartreport-icon-grid50", type:"str", button:"50", actions:"setMeasureTick50(event)", defaultValue:false, image:"url(images/50.png)", tooltip:"Click to set tick as 50% unit", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID},
          {name:"Rulers tick 100", propID:"tick100", addclass:"smartreport-icon-grid100", type:"str", button:"100", actions:"setMeasureTick100(event)", defaultValue:true, image:"url(images/100.png)", tooltip:"Click to set tick as 100% unit", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID},
          {name:"Grid type small dashed", propID:"gtypesmall", addclass:"smartreport-icon-gridsmall", type:"str", button:"-", actions:"setGridTypeSmall(event)", defaultValue:true, image:"url(images/smalld.png)", tooltip:"Click to set grid lines as small-dashed", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID},
          {name:"Grid type long dashed", propID:"gtypelong", addclass:"smartreport-icon-gridlong", type:"str", button:"_", actions:"setGridTypeLong(event)", defaultValue:false, image:"url(images/long.png)", tooltip:"Click to set grid lines as long-dashed", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID},
          {name:"Grid type plain", propID:"gtypeplain", addclass:"smartreport-icon-gridplain", type:"str", button:"__", actions:"setGridTypePlain(event)", defaultValue:false, image:"url(images/plain.png)", tooltip:"Click to set grid lines as plain", api_tab: "Ruler/grid button", api_sect: spTranslatedText.SMR_GRID}
        ],
        actionToolbar:[
          {name:"Save As", propID:"saveas", type:"str", actions:"reportsaveAs()", tooltip:"Save As", image:""/*, marginLeft:10*/, view:"floatright", addclass:"smartreport-icon-saveAs"},
          {name:"Save", propID:"save", type:"str", actions:"save()", tooltip:"Save", image:""/*, marginLeft:10*/, view:"floatright", addclass:"smartreport-icon-save"},
          {name:"Open", propID:"open", type:"str", actions:"openReport()", tooltip:"Open", image:""/*, marginLeft:10*/, view:"floatright", addclass:"smartreport-icon-open", icon: true},
          {name:"New", propID:"new", type:"str", actions:"newReport()", tooltip:"New", image:""/*, marginLeft:10*/, view:"floatright", addclass:"smartreport-icon-new"},
          {name:"Wizard", propID:"wizard", type:"str", actions:"drawERWizardH", tooltip:"Wizard", image:"", view:"floatright", addclass:"smartreport-icon-wizard", icon: true}
        ],
        wizardToolbar:[
          {name:"Wizard", propID:"wizard", type:"str", actions:"drawERWizardH", tooltip:"Wizard", image:"", view:"", withtext: true, addclass:"smartreport-icon-wizard", icon: true}
        ],
        leftToolbar_0: [
          {name:"Properties", propID:"details", type:"str", defaultValue:false, tooltip:"Set custom properties", actions:"editItem", addclass:"smartreport-icon-details", withtext: true, icon: true}
        ],
        leftToolbar_1: [
          {name:"Custom", propID:"repcustom", type:"checkbox", defaultValue:false, tooltip:"Set custom report", margin: 3, api_tab: spTranslatedText.SMR_PROPERTIES},
          {name:"Comment", propID:"repcomment", type:"str", defaultValue:"", tooltip:"Set/edit report comment", actions:"editItem", addclass:"smartreport-icon-comment", withtext: true, icon: true, api_tab: spTranslatedText.SMR_PROPERTIES}
        ],
        leftToolbar_2: [
          {name:"Filters", propID:"gparam", type:"str", actions:"showMask", tooltip:"Set datasource parameters (valid for Document and PDF views)", addclass:"smartreport-icon-filter", withtext: true, icon: true, view: "designView documentView pdfView", api_tab: spTranslatedText.SMR_FILTERS},
          {name:"Page options", propID:"pages", type:"str", actions:"editItem", tooltip:"Set page settings", addclass:"smartreport-icon-page", withtext: true, icon: true, view: "designView documentView pdfView"}
        ],
        rightToolbar_1: [
          {name:"doc view", propID:"docview", type:"select["+this.viewmode_values+"]", tooltip:"Choose document view", icon: true, text_select:this.viewmode_select, actions:"selectReportPageEvent", textclass:"combotext"}
        ],
        rightToolbar_2: [
          {name:"Undo", propID:"undo", type:"str", actions:"Undo", tooltip:"Undo action", addclass:"smartreport-icon-undo", icon: true, view: "designView documentView", api_tab: "Toolbar"},
          {name:"Redo", propID:"redo", type:"str", actions:"Redo", tooltip:"Redo action", addclass:"smartreport-icon-redo", icon: true, view: "designView documentView", api_tab: "Toolbar"},
          {name:"Edit", propID:"editc", type:"str", actions:"editItem", tooltip:"Edit item content", addclass:"smartreport-icon-edit", withtext: true, icon: true, view: "designView documentView", api_tab: "Toolbar"},
          {name:"Style", propID:"fonts", type:"str", actions:"editItem", tooltip:"Set font style", addclass:"smartreport-icon-font", withtext: true, icon: true, view: "designView documentView", api_tab: "Toolbar"},
          {name:"Delete", propID:"delitem", type:"str", actions:"editItem", tooltip:"Delete item", addclass:"smartreport-icon-delete", withtext: true, icon: true, view: "designView documentView", api_tab: "Toolbar"}
        ],
        rightToolbar_3: [
          {name:"Sections", propID:"docsect", type:"str", actions:"editItem", tooltip:"Set document sections", addclass:"smartreport-icon-sections", withtext: true, icon: true, view: "designView documentView", api_tab: "Toolbar"},
          {name:"Section fields", propID:"menumob", type:"str", actions:"editItem(event)", tooltip:"Show fields list and order (only Document view)", withtext: true, icon: true, addclass: "smartreport-icon-section", view: "documentView", api_tab: "Toolbar"},
          {name:"Download PDF", propID:"downlpdf", type:"str", actions:"", tooltip:"Download document pdf", addclass:"smartreport-icon-downloadpdf", withtext: true, icon: true, marginLeft:0, view:"pdfViewD"},
          {name:"Download", propID:"downl", type:"select["+this.download_values+"]", tooltip:"Choose download format", addclass:"combob", icon: true, text_select: this.download_select, view:"pdfViewD",actions:"makeDownloadEvent", addclass:"smartreport-icon-download", textclass:"combob"}
        ]
      },
      _api: {
        generic: "all",
        leftToolbar_1: "all",
        leftToolbar_2: ["gparam"],
        page_options: "print",
        toolbar: "rightToolbar_2",
        rightToolbar_3: ["docsect", "menumob"],
        sections: "designToolbar",
        reportheader: "reportheader",
        groupbreak: "groupbreak",
        groupheader: "groupheader",
        groupfooter: "groupfooter",
        reportfooter: "reportfooter",
        rulersGrid: "rulersGrid"
      }
    };

    this.fieldObjClass={
      newProperties:{
        generic:[
          {name:'name',  propID:'name',  type:'str',  tooltip:'Unique identifier for the Field in the current module'},
          {name:'x',  propID:'x',  type:'int',  tooltip:'X coordinate'},
          {name:'y',  propID:'y',  type:'int',  tooltip:'Y coordinate'},
          {name:'h',  propID:'h',  type:'int',  tooltip:'Height'},
          {name:'w',  propID:'w',  type:'int',  tooltip:'Width'}
        ],
        font:[
          {name:"Font family", propID:"ffamily", type:"select["+this.fonts_select+"]", actions:"setFontFamily", defaultValue:"Helvetica", tooltip:"Set the selected font", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_TEXT},
          {name:"Font size", propID:"fsize", type:"int", defaultValue:"10pt", button:"", actions:"setFontSize,setBiggerSize,setSmallerSize", image:"", tooltip:"Set custom font size;Click to increase font size;Click to decrease font size", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_TEXT},
          {name:"Font weight bold", propID:"fbold", type:"str", button:"B", actions:"setBold", image:"", defaultValue:"normal", tooltip:"Click to make text bold", addclass: "smartreport-icon-bold", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font weight italic", propID:"fitalic", type:"str", button:"I", actions:"setItalic", image:"", defaultValue:"normal", tooltip:"Click to make text italic", addclass: "smartreport-icon-italic", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font weight underline", propID:"funderline", type:"str", button:"U", actions:"setUnderline", image:"", defaultValue:"normal", tooltip:"Click to underline text", addclass: "smartreport-icon-underline", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font weight strikeout", propID:"fstrikeout", type:"str", button:"S", actions:"setStrikeout", image:"", defaultValue:"normal", tooltip:"Click to strikeout text", addclass: "smartreport-icon-strikeout", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font color", propID:"fcolor", type:"color", actions:"setFontColor", defaultValue:"#000000", tooltip:"Click to choose custom text color", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font alignment left", propID:"fleft", type:"str", button:"L", actions:"setAlignLeft", image:"", defaultValue:"left", tooltip:"Click to align text on the left side", addclass: "smartreport-icon-left", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_ALIGNMENT},
          {name:"Font alignment center", propID:"fcenter", type:"str", button:"C", actions:"setAlignCenter", image:"", defaultValue:"normal", tooltip:"Click to align text in center", addclass: "smartreport-icon-center", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_ALIGNMENT},
          {name:"Font alignment right", propID:"fright", type:"str", button:"R", actions:"setAlignRight", image:"", defaultValue:"normal", tooltip:"Click to align text on the right side", addclass: "smartreport-icon-right", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_ALIGNMENT}
        ],
        image:[
          {name:"Image path", propID:"imgPath", type:"str", actions:"setImagePath", defaultValue:"", tooltip:"Set the image path (relative)", api_tab: spTranslatedText.SMR_EDIT},
          {name:"Image search", propID:"imgSearch", type:"str", button:"S", actions:"searchImage", image:"url(images/search.png)", tooltip:"Click to search and select image"}
        ],
        pagenum:[
          {name:"Page numeration", propID:"pageN", type:"select["+this.pagenum_select+"]", text_select:this.pagenum_select, actions:"saveEditInput()", defaultValue:"Page number", tooltip:"Set different pictures of page numeration", api_tab: spTranslatedText.SMR_EDIT }
        ],
        date:[
          {name:"Date format", propID:"dateformat", type:"select["+this.date_select+"]",	convertFunc: "convertDateTimeUpperCase", image:"url(images/D.png)", actions:"saveEditInput()", defaultValue:'DD-MM-YYYY', tooltip:"Set custom date format", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_DATETIMEFORMAT},
          {name:"Time format", propID:"timeformat", type:"select["+this.time_select+"]",	convertFunc: "convertDateTimeLowerCase", image:"url(images/T.png)", actions:"saveEditInput()", defaultValue:'HH:MM', tooltip:"Set custom time format", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_DATETIMEFORMAT}
        ],
        num:[
          {name:"Calculation", propID:"calculate", type:"select["+this.calc_select+"]", image:"url(images/calc.png)", actions:"saveEditInput", defaultValue:"none", tooltip:"Set calculation on item", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_CALCULATION},
          {name:"By group", propID:"calcbygrp", type:"checkbox", actions:"saveEditInput", defaultValue:false, tooltip:"Select calculation by grouping", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_CALCULATION}
        ],
        fConv:[
          {name:"Field type view conversion", propID:"typeView", type:"select["+this.fldconv_select+"]", actions:"setTypeView()", defaultValue:"text", tooltip:"Change field type view", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_FIELDVIEWTYPE },
          {name:"Barcode type", propID:"barcodetype", type:"select["+this.barcode_select+"]", actions:"setBarcodeType()", defaultValue:'', tooltip:"Select barcode type", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_BARCODEOPTIONS},
          {name:"Barcode off-color", propID:"fcoloroff", type:"color", actions:"setBarcodeOffColor", defaultValue:"#ffffff", tooltip:"Click to choose off pixel color", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_BARCODEOPTIONS},
          {name:"Barcode on-color", propID:"fcoloron", type:"color", actions:"setBarcodeOnColor", defaultValue:"#000000", tooltip:"Click to choose on pixel color", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_BARCODEOPTIONS}/*,
          {name:"QRCode Correction", propID:"qrcodecorrection", type:"select["+this.qrcodeselect_select+"]", actions:"setQRCodeCorrection()", defaultValue:false, tooltip:"QRCode Error Correction"}*/
        ],
        signmup:[
          {name:"obligatory", propID:"brequired", type:"checkbox", actions:"saveEditInput", defaultValue:false, tooltip:"Set signature markup as obligatory", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_REQUIREMENTS},
          {name:"geo position", propID:"bgeoposition", type:"checkbox", actions:"saveEditInput", defaultValue:false, tooltip:"Enable geografic position", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_REQUIREMENTS},
          {name:"hide extra data", propID:"bhideextra", type:"checkbox", actions:"saveEditInput", defaultValue:true, tooltip:"Hide extra data information", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_REQUIREMENTS},
          {name:"Sequence", propID:"sequence", type:"int", actions:"saveEditInput", defaultValue:1, tooltip:"Set signature markup sequence order", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_REQUIREMENTS},
          {name:"Title", propID:"title", type:"str", actions:"", defaultValue:"", tooltip:"Set signature mark title", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_TITLE},
          {name:"Date format", propID:"smdateformat", type:"select["+this.mupdate_select+"]",	convertFunc: "convertDateTimeUpperCase", image:"url(images/D.png)", actions:"saveEditInput()", defaultValue:'None', tooltip:"Set custom date format", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_DATEFORMAT},
          {name:"Time format", propID:"smtimeformat", type:"select["+this.muptime_select+"]",	convertFunc: "convertDateTimeLowerCase", image:"url(images/T.png)", actions:"saveEditInput()", defaultValue:'None', tooltip:"Set custom time format", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_DATEFORMAT}
        ]
      },
      _api: {
        text: "fConv",
        image: ["imgPath"],
        numeric: "num",
        datetime: "date",
        allfields: [ { name:"Edit/Fonts properties applied to every field in datasource", 
          tooltip:"This element allows you to include all fields at once without having to enter them one at a time. This allows you to always have the report fields in line with those provided on the datasource. For each type of field it is possible to change the visualization and the font as if it had been inserted individually in the report.",
          api_tab: spTranslatedText.SMR_EDIT } ],
        font: "all"
      }
    };

    this.labelObjClass={
      newProperties:{
        generic:[
          {name:'x',  propID:'x',  type:'int'},
          {name:'y',  propID:'y',  type:'int'},
          {name:'width',  propID:'w',  type:'int'},
          {name:'height',  propID:'h',  type:'int'}
        ],
        font:[
          {name:"Font family", propID:"ffamily", type:"select["+this.fonts_select+"]", actions:"setFontFamily", defaultValue:"Helvetica", tooltip:"Set the selected font", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_TEXT},
          {name:"Font size", propID:"fsize", type:"int", defaultValue:"10pt", button:"", actions:"setFontSize,setBiggerSize,setSmallerSize", image:"", tooltip:"Set custom font size;Click to increase font size;Click to decrease font size", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_TEXT},
          {name:"Font weight bold", propID:"fbold", type:"str", button:"B", actions:"setBold", image:"", defaultValue:"normal", tooltip:"Click to make text bold", addclass: "smartreport-icon-bold", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font weight italic", propID:"fitalic", type:"str", button:"I", actions:"setItalic", image:"", defaultValue:"normal", tooltip:"Click to make text italic", addclass: "smartreport-icon-italic", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font weight underline", propID:"funderline", type:"str", button:"U", actions:"setUnderline", image:"", defaultValue:"normal", tooltip:"Click to underline text", addclass: "smartreport-icon-underline", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font weight strikeout", propID:"fstrikeout", type:"str", button:"S", actions:"setStrikeout", image:"", defaultValue:"normal", tooltip:"Click to strikeout text", addclass: "smartreport-icon-strikeout", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font color", propID:"fcolor", type:"color", actions:"setFontColor", defaultValue:"#000000", tooltip:"Click to choose custom text color", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_STYLE},
          {name:"Font alignment left", propID:"fleft", type:"str", button:"L", actions:"setAlignLeft", image:"", defaultValue:"left", tooltip:"Click to align text on the left side", addclass: "smartreport-icon-left", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_ALIGNMENT},
          {name:"Font alignment center", propID:"fcenter", type:"str", button:"C", actions:"setAlignCenter", image:"", defaultValue:"normal", tooltip:"Click to align text in center", addclass: "smartreport-icon-center", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_ALIGNMENT},
          {name:"Font alignment right", propID:"fright", type:"str", button:"R", actions:"setAlignRight", image:"", defaultValue:"normal", tooltip:"Click to align text on the right side", addclass: "smartreport-icon-right", api_tab: spTranslatedText.SMR_STYLE, api_sect: spTranslatedText.SMR_ALIGNMENT}
        ]
      },
      _api: {
        text: [ { name:"Edit content", type:"str", defaultValue:"Label", tooltip:"Click to edit content", api_tab: spTranslatedText.SMR_EDIT } ]
      }
    };

    this.lineObjClass={
      newProperties:{
        generic:[
          {name:'x',  propID:'x',  type:'int'},
          {name:'y',  propID:'y',  type:'int'},
          {name:'width',  propID:'w',  type:'int'},
          {name:'height',  propID:'h',  type:'int'}
        ],
        line:[
          {name:"Line height", propID:"h", type:"int", defaultValue:"1", actions:"setLineHeight", image:"url(images/plus.png),url(images/minus.png)", tooltip:"Set custom line height", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_LINESTYLE},
          {name:"Line color", propID:"lcolor", type:"color", defaultValue:"#000000", actions:"setLineColor", tooltip:"Click to choose custom line color", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_LINESTYLE},
          {name:"Stretch to right", propID:"lstretchr", type:"checkbox", actions:"setStretchRight", defaultValue:false, tooltip:"Click to stretch item to the right side", api_tab: spTranslatedText.SMR_EDIT, api_sect: spTranslatedText.SMR_LINESTYLE}
        ]
      },
      _api: {
        line: "all"
      }
    };

    this.genericItems = [
      { 'id': 'label'
        , 'image': 'smartreport-icon-label'
        , 'title': 'Label'
        , 'action': "drawGenericShadow(event,generic_label,\"label\")"
      },
      { 'id': 'line'
        , 'image': 'smartreport-icon-line'
        , 'title': 'Horizontal line'
        , 'action': "drawGenericShadow(event,generic_line,\"line\")"
      },
      { 'id': 'image'
        , 'image': 'smartreport-icon-image'
        , 'title': 'Image'
        , 'action': "drawGenericShadow(event,generic_image,\"image\")"
      },
      { 'id': 'datetime'
        , 'image': 'smartreport-icon-date'
        , 'title': 'Current datetime'
        , 'action': "drawGenericShadow(event,generic_datetime,\"datetime\")"
      },
      { 'id': 'pagenum'
        , 'image': 'smartreport-icon-pagenum'
        , 'title': 'Page numeration'
        , 'action': "drawGenericShadow(event,generic_pagenum,\"pagenum\")"
      },
      { 'id': 'continue'
        , 'image': 'smartreport-icon-label'
        , 'title': 'Continue'
        , 'action': "drawGenericShadow(event,generic_continue,\"continue\")"
      },
      { 'id': 'signmup'
        , 'image': 'smartreport-icon-sign'
        , 'title': 'Signature MarkUp'
        , 'action': "drawGenericShadow(event,generic_signmup,\"signmup\")"
      },
      { 'id': 'allfields'
        , 'image': 'smartreport-icon-fields'
        , 'title': 'All fields'
        , 'action': "drawGenericShadow(event,generic_allfields,\"allfields\")"
      }
    ];


    /********** OGGETTI *******************/
    this.printObj = function() {
      this.objClass = ZTObjects.PrintObjClass;
      this.type = 'Print';
      initPropertiesDefaultValue(this);
    };

    this.formObj = function() {
      this.objClass = ZTObjects.FormObjClass;
      initPropertiesDefaultValue(this);
      this.type = 'Form';
      this.page = 0;
      this.datasource ="";
    };

    this.fieldObj = function (name, alias, desc, len, type, dec) {
      this.objClass = ZTObjects.fieldObjClass;
      this.id = "itmFld_"+alias;
      this.name = name;

      this.alias = alias;
      this.desc = (Empty(desc))?alias:desc;
      this.len = (type=="M")?100:len;
      this.dec = dec;
      this.type = type;

      this.html="<div ";
      this.html+="id='"+this.id+"' ";
      this.html+="class='unselectable fieldObject";
      if (viewMode == documentView)
        this.html+=" fieldDocument";
      this.html+="'";
      if(viewMode!=documentView){
        this.html+=" onmouseenter='drawFldShadow(event,"+this.id+")'";
        //this.html+=" ontouchstart='drawFldShadow(event,"+this.id+")'";
      }
      this.html+=" >";

      this.html+="<div class='unselectable fieldObjectInside";
      if(viewMode==documentView)
        this.html+=" fieldDocumentInside";
      this.html+="'";
      this.html+=">";
      this.html+=ToStringHTML(this.desc);
      this.html+="</div>";

      //tipo
      this.html+="<span ";
      this.html+="class='unselectable iconFieldType ";
      switch (this.type) {
        case "C":
          this.html += "smartreport-icon-char";
          break;
        case "M":
          this.html += "smartreport-icon-memo";
          break;
        case "N":
          this.html += "smartreport-icon-num";
          break;
        case "D":
          this.html += "smartreport-icon-date";
          break;
        case "T":
          this.html += "smartreport-icon-time";
          break;
        case "L":
          this.html += "smartreport-icon-logic";
          break;
      }
      this.html+="'>";
      this.html+="</span>";

      this.html+="</div>";

      //avanzamento
      this.html+="<div ";
      this.html+="id='"+this.id+"len' ";
      this.html+="class='fieldObjectLen";
      if(viewMode==documentView)
        this.html+=" fieldDocumentLen";
      this.html+="'";
      this.html+=">";
      this.html+="<div ";
      this.html+="id='"+this.id+"lenColor' ";
      this.html+="class='fieldObjectLenC";
      if(viewMode==documentView)
        this.html+=" fieldDocumentLenC";
      this.html+="' ";
      this.html+="style='";
      divLen = 172;
      if(viewMode==documentView)
        divLen = 139;
      this.html+="width:"+Math.min(divLen,(lenFactor*this.len))+"px;";
      this.html+="'";
      this.html+=">";
      this.html+="</div>";
      this.html+="</div>";
    };

    this.fldObj = function(nId, uid, pos, field, isGen, picture, imageSrc, calc, isdoc){
      this.objClass = ZTObjects.fieldObjClass;
      initPropertiesDefaultValue(this);
      this.type = "field";
      this.id = "item"+nId;
      this.name = "field"+nId;
      this.x = pos.x;
      this.y = pos.y;
      this.w = pos.w;
      this.h = pos.h;
      this.fieldDet = {  alias: field.alias,
                type: field.type,
                len: field.len,
                dec: field.dec,
                desc: field.desc
              };

      this.isGeneric = isGen;

      if(imageSrc || !Empty(imageSrc))
        this.imgPath = imageSrc;

      if(picture && !Empty(picture.dateformat))
        this.dateformat = picture.dateformat;

      if(picture && !Empty(picture.timeformat))
        this.timeformat = picture.timeformat;

      if(calc && !Empty(calc.type)){
        this.calculate = calc.type;
        this.calcbygrp = calc.byGroup;
      }

      if(Empty(field.tView)){
        switch(this.fieldDet.type){
          case "C":
          case "M":
            this.typeView = "text";
            break;
          case "N":
            this.typeView = "numeric";
            break;
          case "D":
            this.typeView = "date";
            break;
          case "T":
            this.typeView = "datetime";
            break;
          case "I":
            this.typeView = "image";
            break;
          default:
            this.typeView = "text";
            break;
        }
      }
      else
        this.typeView = field.tView;

      /*if(this.typeView=="pagenum"){
        this.pageN = this.fieldDet.desc;
      }*/

      this.html="<div ";
      this.html+="id='"+this.id+"' ";
      if( this.typeView == "image" || this.typeView == "signmup")
        this.html+="class='unselectable labelFieldImg' ";
      else
        this.html+="class='unselectable labelField' ";
      this.html+="style='";
      this.html+="left:"+this.x+"px;";
      this.html+="top:"+this.y+"px;";
      this.html+="width:"+this.w+"px;";
      if(this.fieldDet.type=="M")
        this.html+="height:60px;";
      if(!Empty(this.h))
        this.html+="height:"+this.h+"px;";
      this.html+="'";
      this.html+=" onclick=' clickItem(event)'";
      this.html+=">";

      this.html+="<div ";
      this.html+="id='"+this.id+"_int' ";
      if(this.typeView != "image"){
        this.html+="class='unselectable labelFieldText ";
        if(isdoc)
          this.html+="textContainerDoc' ";
        else
          this.html+="textContainer' ";
      }
      else
        this.html+="class='unselectable textContainer hiddenZone' ";
      this.html+="title='[" + ToStringHTML(ConvertToView(this, this.isGeneric)) + "]' ";
      this.html+=">";
      this.html+="["+ ToStringHTML(ConvertToView(this, this.isGeneric)) + "]";
      this.html+="</div>";

      if(this.typeView == "image"){
        this.html+="<img ";
        this.html+="id='"+this.id+"_img' ";
        this.html+="class='unselectable' ";
        if(this.isGeneric)
          this.html+="alt='Image not found' ";
        else
          this.html+="alt='"+"["+ ToStringHTML(ConvertToView(this, this.isGeneric)) + "]' ";
        if(Empty(this.imgPath) || !this.imgPath)
          this.html+="src='' ";
        else
          this.html+="src='" + rootApp+this.imgPath + "' ";
        this.html+="style='";
        this.html+="width:"+(100)+"%;";
        this.html+="height:"+(100)+"%;";
        this.html+="'";
        this.html+="/>";
      }

      if(this.typeView == "barcode"){
        this.html+="<img ";
        this.html+="id='"+this.id+"_barcode' ";
        this.html+="class='unselectable' ";
        this.html+="style='";
        this.html+="width:"+(100)+"%;";
        this.html+="height:"+(100)+"%;";
        this.html+="'";
        this.html+="/>";
      }

      //tipo
      if(!this.isGeneric){
        this.html+="<span ";
        this.html+="id='"+this.id+"_icon' ";
        this.html+="class='fieldDescIcon'";
        this.html+=">";
        this.html+="</span>";
      }

      this.html+="</div>";

      this.shadow = null;
      this.zone = null;

      if (Empty(uid))
        this.uid = LibJavascript.AlfaKeyGen(5);
      else
        this.uid = uid;
    };

    this.labelObj = function(nId, uid, pos, desc, style, isCont, isdoc){
      this.objClass = ZTObjects.labelObjClass;
      initPropertiesDefaultValue(this);
      this.id = "item"+nId;
      this.name = "label"+nId;
      this.x = pos.x;
      this.y = pos.y;
      this.w = pos.w;
      this.h = pos.h;

      this.value = desc;
      this.type = "label";

      this.typeView = "text";
      this.style = style;
      this.isContinue = isCont;

      this.html="<div ";
      this.html+="id='"+this.id+"' ";
      this.html+="class='unselectable labelFieldDesc";
      this.html+="' ";
      this.html+="style='";
      this.html+="left:"+this.x+"px;";
      this.html+="top:"+this.y+"px;";
      this.html+="width:"+this.w+"px;";
      this.html+="height:"+this.h+"px;";
      this.html+="'";
      this.html+=" onclick='clickItem(event)'";
      this.html+=">";

      this.html+="<div ";
      this.html+="id='"+this.id+"_int' ";
      this.html+="class='unselectable labelFieldText ";
      if(isdoc)
        this.html+="textContainerDoc' ";
      else
        this.html+="textContainer' ";
      if(!Empty(this.style))
        this.html+=this.style;
      this.html+=">";
      this.html+=ToStringHTML(this.value);
      this.html+="</div>";
      this.html+="</div>";

      this.shadow = null;
      this.zone = null;

      if (Empty(uid))
        this.uid = LibJavascript.AlfaKeyGen(5);
      else
        this.uid = uid;
    };

    this.lineObj = function(nId, uid, pos, style){
      this.objClass = ZTObjects.lineObjClass;
      initPropertiesDefaultValue(this);
      this.id = "item"+nId;
      this.name = "line"+nId;
      this.x = pos.x;
      this.y = pos.y;
      this.w = pos.w;
      this.h = pos.h;

      this.type = "line";
      this.typeView = "line";

      if(style){
        this.h = style.height;
        this.lcolor = style.color;
      }

      this.html="<div ";
      this.html+="id='"+this.id+"' ";
      this.html+="class='unselectable lineItem' ";
      this.html+="style='";
      this.html+="left:"+this.x+"px;";
      this.html+="top:"+this.y+"px;";
      this.html+="width:"+this.w+"px;";
      this.html+="height:"+this.h+"px;";
      this.html+="position:absolute;";
      this.html+="background-color:#000000;";
      this.html+="'";
      this.html+=" onclick='clickItem(event)'";
      this.html+=" onmouseover='maximizeLine(event)'";
      this.html+=" onmouseout='minimizeLine(event)'";
      this.html+=">";
      this.html+="</div>";

      this.shadow = null;
      this.zone = null;

      if(Empty(uid))
        this.uid = LibJavascript.AlfaKeyGen(5);
      else
        this.uid = uid;
    };

    this.undoObj = function (id, action, x, y, x_init, y_init, obj, w, h, w_init, h_init) {
      this.id = id;
      this.action = action;
      this.x_init = x_init;
      this.y_init = y_init;
      this.x = x;
      this.y = y;
      this.w_init = w_init;
      this.h_init = h_init;
      this.w = w;
      this.h = h;
      this.obj = obj;
      if (this.obj) {
        if (!this.w) { this.w = parseInt(this.obj.w); }
        if (!this.h) { this.h = parseInt(this.obj.h); }
        this.scale = parseInt(this.obj.scale);
      }
    };

    this.af_labelObj = function (desc) {
      this.objClass = ZTObjects.labelObjClass;
      initPropertiesDefaultValue(this);
      this.value = desc;
      this.type = "label";
      this.typeView = "text";
      this.uid = LibJavascript.AlfaKeyGen(5);
    };

    this.af_fldObj = function (field) {
      this.objClass = ZTObjects.fieldObjClass;
      initPropertiesDefaultValue(this);
      this.type = "field";
      this.fieldDet = {  
        alias: field.alias,
        type: field.type,
        len: field.len,
        dec: field.dec,
        desc: field.desc
      };

      if (Empty(field.tView)) {
        switch (this.fieldDet.type) {
          case "C":
          case "M":
            this.typeView = "text";
            break;
          case "N":
            this.typeView = "numeric";
            break;
          case "D":
            this.typeView = "date";
            break;
          case "T":
            this.typeView = "datetime";
            break;
          case "I":
            this.typeView = "image";
            break;
          default:
            this.typeView = "text";
            break;
        }
      }
      else
        this.typeView = field.tView;

      this.uid = LibJavascript.AlfaKeyGen(5);
    };
  };
}
