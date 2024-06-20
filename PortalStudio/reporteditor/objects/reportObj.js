/*
global defaultEncoding reportProp translateCharacters
*/

var defversion = "6.0";

ZTObjects.reportObjClass={
  newProperties:{
    generic:[
      {name:'comment',			propID:'title',			type:'str',			tooltip:'Comment'},
      {name:'query',			propID:'query',			type:'str',			validFunc:'validQuery',			tooltip:'Query'},
      {name:'substitute queries list',			propID:'queries_list',			type:'str',			buttons:'edit',			actions:'LoadQL()',			tooltip:'Other queries abilited for this report',			defaultValue:''},
      {name:'parameters mask',			propID:'vdmfile',			validFunc:'validVdmMask',			type:'str',			tooltip:'Parameters mask'},
      {name:'background pdf file',			propID:'pdffile',			type:'str',			validFunc:'ApplyPdf',			buttons:'pick',			actions:'LoadPdf()',			tooltip:'Background Pdf model file'},
      {name:'encoding',			propID:'encoding',	type:ZTObjects.encoding_select,	tooltip:'Define encoding for document generation'},
      {name:'page sections',			propID:'pageheadfoot',			type:ZTObjects.requiredOrNot,			validFunc:'validPageHF',			tooltip:'Design Page Header and Footer', section:"Sections", extraClass:"col-3"},
      {name:'report sections',			propID:'reportheadfoot',	type:ZTObjects.requiredOrNot,			validFunc:'validReportHF',			tooltip:'Design Report Header and Footer', section:"Sections", extraClass:"col-3"}
    ],
    global_definitions:[
      {name:'name',			propID:'font',			type:'advanced-font',	fontList:ZTObjects.fonts_select,			tooltip:'Global font',			validFunc:'validSetFont', section:"font"},
      {name:'size',			propID:'font_size',			type:'str',			tooltip:'Global font size',			validFunc:'validSetFont', section:"font"},
      {name:'style',			propID:'font_weight',			type:'select[,normal,bold,italic,bold italic]',			tooltip:'Global font style',			validFunc:'validSetFont', extraClass: "col-3", section:"font"},
      {name:'effects',			propID:'font_effect',			type:'select[,strikeout,underline,strikeout underline]',			tooltip:'Global font effects',			validFunc:'validSetFont', extraClass: "col-3", section:"font"},
      {name:'date picture',		propID:'picture_date',		type:'str',			tooltip:'Apply this picture to every Date expression if not chosen differently in the single expression', extraClass: "col-3", section:"pictures"},
      {name:'time picture',		propID:'picture_time',		type:'str',			tooltip:'Apply this picture to every Time expression if not chosen differently in the single expression', extraClass: "col-3", section:"pictures"},
      {name:'text picture',		propID:'picture_text',		type:'str',			tooltip:'Apply this picture to every Text expression if not chosen differently in the single expression', extraClass: "col-3", section:"pictures"},
      {name:'number picture',		propID:'picture_num',		type:'str',			tooltip:'Apply this picture to every Number expression if not chosen differently in the single expression', extraClass: "col-3", section:"pictures"}
    ],
    attributes:[
	  {name:'name',			propID:'attributes_name', type:'str',			buttons:'edit',			actions:'LoadAttributesNV()',			tooltip:'List of name of attributes',			defaultValue:'', extraClass:"col-3"},
      {name:'value',			propID:'attributes_value',			type:'str',			buttons:'edit',			actions:'LoadAttributesNV()',			tooltip:'List of value of attributes',			defaultValue:'', extraClass:"col-3"}
    ],
	  page_settings:[
      {name:'page format',			propID:'pformat',			type:ZTObjects.format_select,			validFunc:'ValidVerticalReference',			tooltip:'Document page format'
        ,hide_list:{'A4,A3,LETTER,LEGAL':['this.page_settings_cwidth','this.page_settings_cheight'],
              'CUSTOM':[]
        }
        ,show_list:{'CUSTOM':['this.page_settings_cwidth','this.page_settings_cheight'],
              'A4,A3,LETTER,LEGAL':[]
        }
        , extraClass: "col-3"
      },
      {name:'rotation',			propID:'rotation',			type:ZTObjects.rotation_select,			tooltip:'Document page rotation', extraClass: "col-3"},
      {name:'custom width',			propID:'cwidth',			type:'int',			convertFunc:'convertFromPointsNoScale',			reconvertFunc:'convertToPointsNoScale',			tooltip:'Document custom width (rulers unit)', extraClass: "col-3"},
      {name:'custom height',			propID:'cheight',			type:'int',			convertFunc:'convertFromPointsNoScale',			reconvertFunc:'convertToPointsNoScale',			tooltip:'Document custom height (rulers unit)', extraClass: "col-3"},
      {name:'top margin',			propID:'tmargin',			type:'int',			convertFunc:'convertFromPointsNoScale',			reconvertFunc:'convertToPointsNoScale',			tooltip:'Print top margin (rulers unit)', extraClass: "col-3"},
      {name:'bottom margin',			propID:'bmargin',			type:'int',			convertFunc:'convertFromPointsNoScale',			reconvertFunc:'convertToPointsNoScale',			tooltip:'Print bottom margin (rulers unit)', extraClass: "col-3"},
      {name:'left margin',			propID:'lmargin',			type:'int',			convertFunc:'convertFromPointsNoScale',			reconvertFunc:'convertToPointsNoScale',			tooltip:'Print left margin (rulers unit)', extraClass: "col-3"},
      {name:'no empty areas',			propID:'fiscaldoc',			type:'checkbox',			tooltip:'Set fiscal document, bar empty areas with *', section:"fiscal document"}
    ],
    security:[
      {name:'public access',			propID:'security_public',			type:'checkbox',			tooltip:'All users can access to this entity without a login', extraClass:"col-3"},
	    {name:'save in custom dir',			propID:'custom',			type:'checkbox',			tooltip:'Define if report is saved on custom directory', extraClass: "col-3"},
      {name:'design file',			propID:'dict_name',			type:'str',			tooltip:'Design file',			disabled:true},
      {name:'security roles access',			propID:'security_roles',			type:'str',			buttons:'edit',			actions:'LoadRV()',			tooltip:'Roles abilited for security'},
      {name:'security functions check',			propID:'check_values',			type:'str',			buttons:'edit',			actions:'LoadFV()',			tooltip:'Server-side functions to check before report execution.<br> Each function must return boolean : [true] value for a valid execution, [false] otherwise.',			defaultValue:''},
	    {name:'Data subject identifier',		section:'privacy', propID:'identifier', type:'checkbox',		tooltip:'The field represents a data who can identify, directly or indirectly, the subject',	defaultValue:false, extraClass:"col-3"},
	    {name:'Privacy GDPR',		section:'privacy',  propID:'privacy',		type:ZTObjects.privacy_select,		tooltip:'Privacy type',	defaultValue:'0', extraClass:"col-3"},     
      {name:'Privacy GDPR',		section:'privacy',  propID:'contentprivacy',		type:'int',		defaultValue:0,			disabled:true}
    ],
    notes:[
      {name:'author',			propID:'author',			type:'str',			tooltip:'Report author' , extraClass: "col-3"},
      {name:'client',			propID:'client',			type:'str',			tooltip:'Project final user', extraClass: "col-3"},
      {name:'user notes',			propID:'note',			type:'str',			tooltip:'User Notes',			buttons:'edit',			actions:'EditUNotes()', extraClass: "col-3"},
      {name:'technical notes',			propID:'technote',			type:'str',			tooltip:'Technical Notes',			buttons:'edit',			actions:'EditTNotes()', extraClass: "col-3"},
      {name:'version',			propID:'vers',			type:'str',			tooltip:'Report version'},
      {name:'date_creat',			propID:'date_creat',			type:'str',			disabled:true},
      {name:'date_rev',			propID:'date_rev',			type:'str',			disabled:true},
      {name:'form_class',			propID:'form_class',			type:'str',			disabled:true},
      {name:'grid_dx',			propID:'grid_dx',			type:'int',			disabled:true},
      {name:'grid_dy',			propID:'grid_dy',			type:'int',			disabled:true},
      {name:'grid_show',			propID:'grid_show',			type:'int',			disabled:true},
      {name:'grid_use',			propID:'grid_use',			type:'int',			disabled:true},
      {name:'snaplines_show',			propID:'snaplines_show',			type:'str',			disabled:true},
      {name:'language',			propID:'language',			type:'str',			disabled:true},
      {name:'merge',			propID:'merge',			type:'checkbox',			disabled:true},
      {name:'modcnt',			propID:'modcnt',			type:'int',			disabled:true},
      {name:'os',			propID:'os',			type:'str',			disabled:true},
      {name:'usr_def',			propID:'usr_def',			type:'str',			disabled:true},
      {name:'libraries',			propID:'libraries',			type:'str',			disabled:true}
    ],
    view:[
      {name:'rulers',			propID:'workunit',			type:'select[px,mm,cm,pc,inch]', convertFunc:'TranslateRulers',			validFunc:'ApplyUnit',			tooltip:'Unit of measurement', extraClass:"col-3"},
      {name:'vertical reference',			propID:'v_line',			type:'int',			convertFunc:'convertFromPixelsNoScale',			reconvertFunc:'convertToPixelsNoScale',			tooltip:'Vertical Reference (rulers unit)', extraClass:"col-3"},
      {name:'Hide Snap Lines',			propID:'hsl',			type:'checkbox',			tooltip:'Hide Snap Lines', extraClass:"col-3"},
      {name:'Lock items',			propID:'lock_items',			type:'checkbox',			tooltip:'Lock the mouse move of the items', extraClass:"col-3"},
      {name:'Section Bars Free Handle',			propID:'show_movinghandle',			type:'checkbox',			validFunc:'ApplyMovingHandle',			tooltip:'Enable SectionBars Free Handle'}
    ],
    excel_settings:[
      {name:'Sheet Name Expression',			propID:'sheetNameExpr',			type:'exp',			defaultValue:'', tooltip:'Expression to evaluate, result will be used as excel sheet name'},
      {name:'New Sheet on Change Expression',		propID:'sheetNewExpr',			type:'exp',			defaultValue:'', tooltip:'Expression to evaluate, on change value a new sheet will be add to excel output'}
    ]
  }
};

ZTObjects.reportObj = function() {
  this.objClass = ZTObjects.reportObjClass;
  this.type = "report";
  this.version = defversion;

 //Generic
  this.title = "";
  this.query = "";
  this.queries_list = "";
  this.encoding = defaultEncoding;
  this.vdmfile = "";
  this.pageheadfoot = true;
  this.reportheadfoot = false;

 //Global Font
  this.font = "DejaVu Sans Condensed, sans-serif";
  this.font_size = "10";
  this.font_weight = "normal";
  this.font_effect = "";

 //Global picture
  this.picture_date = "";
  this.picture_time = "";
  this.picture_text = "";
  this.picture_num = "";

 //Print settings
  this.rotation = " ";
  this.pformat = "A4";
  this.cwidth = 0;
  this.cheight = 0;
  this.tmargin = 14;
  this.bmargin = 14;
  this.lmargin = 14;
  this.fiscaldoc = false;

 //Attributes
  this.attributes_name = "";
  this.attributes_value = "";

 //Security
  this.security_public = false;
  this.security_access = false;
  this.security_roles = "";
  this.dict_name = "";
  this.check_values = "";

 //View
  this.v_line = 0;
  this.workunit = "px";
  this.pdffile = "";
  this.hsl = "false";
  this.show_movinghandle = "false";
  this.lock_items = "false";

 //Notes
  this.author = "";
  this.client = "";
  this.date_creat = ZtVWeb.applyPicture(new Date(),'D',0,"YYYY-MM-DD");
  this.date_rev = ZtVWeb.applyPicture(new Date(),'D',0,"YYYY-MM-DD");
  this.form_class = " ";
  this.grid_dx = " ";
  this.grid_dy = " ";
  this.grid_show = 0;
  this.grid_use = 0;
  this.snaplines_show = 0;
  this.language = "";
  this.merge = false;
  this.modcnt = 0;
  this.os = "";
  this.note = "";
  this.technote = "";
  this.usr_def = "";
  this.vers = "";
  this.libraries = "";

 //Customization
  this.custom = false;

 //Non visibili
  this.scale = 100;
  this.page = 1;
  this.maxcount = 0;

  //privacy
  this.privacy = "0";
  this.contentprivacy = 0;
  this.identifier = false;
};

ZTObjects.reportObj.prototype.writeDef = function () {
  var JsonReportItem = {type : 'report'}
  var valueToSave = "", i;
  var modcnt = Val(this.modcnt) + 1;

  JsonReportItem["name"] = currentname;
  JsonReportItem["version"] = defversion;
  JsonReportItem["title"] = Strtran(this.title, '"', '\"');
  JsonReportItem["query"] = this.query;
  JsonReportItem["queries_list"] = this.queries_list;
  JsonReportItem["font"] = this.font;
  JsonReportItem["font_size"] = this.font_size;
  JsonReportItem["font_weight"] = this.font_weight;
  JsonReportItem["font_effect"] = this.font_effect;
  JsonReportItem["picture_date"] = Strtran(this.picture_date, '"', '\"');
  JsonReportItem["picture_time"] = Strtran(this.picture_time, '"', '\"');
  JsonReportItem["picture_text"] = Strtran(this.picture_text, '"', '\"');
  JsonReportItem["picture_num"] = Strtran(this.picture_num, '"', '\"');
  JsonReportItem["pageheadfoot"] = this.pageheadfoot;
  JsonReportItem["reportheadfoot"] = this.reportheadfoot;
  JsonReportItem["security_public"] = this.security_public;
  JsonReportItem["dict_name"] = Strtran(this.dict_name, '"', '\"');
  JsonReportItem["security_access"] = this.security_access;
  JsonReportItem["security_roles"] = Strtran(this.security_roles, '"', '\"');
  JsonReportItem["author"] = Strtran(this.author, '"', '\"');
  JsonReportItem["client"] = Strtran(this.client, '"', '\"');
  JsonReportItem["date_creat"] = this.date_creat;
  JsonReportItem["date_rev"] = (ZtVWeb.applyPicture(new Date(),"D",0,"YYYY-MM-DD"));
  JsonReportItem["modcnt"] = modcnt;
  JsonReportItem["note"] = Strtran(this.note, '"', '\"');
  JsonReportItem["technote"] = Strtran(this.technote, '"', '\"');
  JsonReportItem["vers"] = Strtran(this.vers, '"', '\"');
  JsonReportItem["v_line"] = this.v_line;
  JsonReportItem["workunit"] = this.workunit;
  JsonReportItem["pdffile"] = this.pdffile;
  JsonReportItem["vdmfile"] = this.vdmfile;
  JsonReportItem["encoding"] = this.encoding;
  JsonReportItem["hsl"] = this.hsl;
  JsonReportItem["lock_items"] = this.lock_items;
  JsonReportItem["maxcount"] = this.maxcount;
  JsonReportItem["check_values"] = Strtran(this.check_values, '"', '\"');
 // Print Settings
  JsonReportItem["rotation"] = this.rotation;
  JsonReportItem["pformat"] = this.pformat;
  JsonReportItem["cwidth"] = this.cwidth;
  JsonReportItem["cheight"] = this.cheight;
  JsonReportItem["tmargin"] = this.tmargin;
  JsonReportItem["bmargin"] = this.bmargin;
  JsonReportItem["lmargin"] = this.lmargin;
  JsonReportItem["fiscaldoc"] = this.fiscaldoc;
  //privacy
  JsonReportItem["privacy"] = this.privacy;
  JsonReportItem["identifier"] = this.identifier;
  JsonReportItem["contentprivacy"] = this.contentprivacy;
  //Excel
  JsonReportItem["sheetNameExpr"] = Strtran(this.sheetNameExpr, '"', '\"');
  JsonReportItem["sheetNewExpr"] = Strtran(this.sheetNewExpr, '"', '\"');


 // Attributes
  if (LRTrim(reportProp.attributes_name).length > 0) {
    valueToSave = Strtran(reportProp.attributes_value, "--", "##x2d;##x2d;");
    valueToSave = Strtran(valueToSave, "||", "##x7c;##x7c;");
    var nameAttr = reportProp.attributes_name.split(",");
    var valueAttr = valueToSave.split(",");
    valueToSave = "";
    for (i = 0; i < nameAttr.length; i++) {
      if (LRTrim(nameAttr[i]) == "") {
        valueToSave += "";
      }
      else {
        valueToSave += nameAttr[i] + "=" + valueAttr[i];
        if (i < nameAttr.length - 1) {
          valueToSave += ",";
        }
      }
    }
    valueToSave = Strtran(valueToSave, '"', '\"');
  }
  else {
    valueToSave += "";
  }
  JsonReportItem["attributes"] = valueToSave;

  return JsonReportItem;
};

ZTObjects.reportObj.prototype.readDef = function (itemProperties) {
  var propName, valueToLoad;
  // Gestione dell'encoding non scritto nel def, ovvero precedenti al 06/07/2012 (versione 4.2)
  var found = -1;
  found = LibJavascript.Array.indexOf(itemProperties, "encoding");
  if (found < 0) {
    reportProp.encoding = "";
  }
  for (var b = 0; b < itemProperties.length; b++) {
    propName = itemProperties[b];
    valueToLoad = itemProperties[b + 1];

    valueToLoad = translateCharacters(valueToLoad);
    readReportProperty(propName, valueToLoad);
    b++;
  }
};

ZTObjects.reportObj.prototype.readJsonDef = function (itemProperties) {
  var propName, valueToLoad;
  for (var b in itemProperties) {
    propName = b;
    valueToLoad = itemProperties[b];

    valueToLoad = translateCharacters(valueToLoad);
    readReportProperty(propName, valueToLoad);
  }
};

function readReportProperty(propName, valueToLoad) {
  switch (propName) {
    case "encoding":
      reportProp.encoding = valueToLoad;
      break;
    case "attributes":
      var attributesName = "";
      var attributesValue = "";
      var attributes = [];
      var tmpAttribute = [];
      attributes = valueToLoad.split(",");
      for (var idx = 0; idx < attributes.length; idx++) {
        tmpAttribute = attributes[idx].split("=");
        if (LRTrim(tmpAttribute[0]) != '') {
          attributesName += tmpAttribute[0];
          attributesValue += tmpAttribute[1];
          if (idx < (attributes.length - 1)) {
            attributesName += ',';
            attributesValue += ',';
          }
        }
      }
      reportProp["attributes_name"] = attributesName;
      reportProp["attributes_value"] = attributesValue;
      break;
    case "query":
	case "queries_list":
    case "vdmfile":
      reportProp[propName] = LRTrim(valueToLoad);
      break;
    case "maxcount":
      reportProp[propName] = parseInt(valueToLoad);
      break;
    case "pageheadfoot":
    case "reportheadfoot":
    case "fiscaldoc":
    case "security_public":
    case "hsl":
    case "lock_items":
    case "custom":
    case "identifier":
      if (LRTrim(valueToLoad) == "true") {
        reportProp[propName] = true;
      }
      else {
        reportProp[propName] = false;
      }
      break;
    case "pformat":
      reportProp[propName] = valueToLoad.toUpperCase();
    break;
    case "contentprivacy":
    break;
	case "font_weight":
	var font = reportProp.font;
	if( font.indexOf('fonts/DejaVu') == 0 && font!='fonts/DejaVuSans-ExtraLight.ttf' ) {
		  var font_weight = RTrim(valueToLoad);
		  valueToLoad = font;
		  valueToLoad = valueToLoad.substring('fonts/'.length);
		  valueToLoad = valueToLoad.substring(0, valueToLoad.indexOf('.ttf'));
		  var vs = valueToLoad.split('-');
		  var fcssL = vs[0].split(/(?=[A-Z])/);
		  var fcss='';
		  fcss = fcssL[0]+fcssL[1];//DejaVu
		  for(var k=2; k<fcssL.length; k++) {
			  fcss += ' ' + fcssL[k]
		  }
		  reportProp['font'] = fcss + ', sans-serif';
		  if (vs[1]) {
			font_weight = '';
			if(vs[1].toLowerCase().indexOf('bold') >= 0) {
				font_weight = 'bold';
			}
			if(vs[1].toLowerCase().indexOf('italic')>=0 || vs[1].toLowerCase().indexOf('oblique')>=0) {
				font_weight += ' italic';
			}
			font_weight = font_weight.trim();
			if (font_weight.length > 0) {
			  reportProp[propName] = font_weight;
			}
		  }
		  else {
			reportProp[propName] = font_weight;
		  }
	  }
	  else {
			reportProp[propName] = valueToLoad;
	  }
	break;

    default:
      reportProp[propName] = RTrim(valueToLoad);
      break;
  }
}

ZTObjects.reportObj.prototype.getAttributesKeys = function() {
  return this.attributes_name;
};

ZTObjects.reportObj.prototype.getAttributesValues = function() {
  return this.attributes_value;
};

ZTObjects.reportObj.prototype.getRolesValues = function() {
  return this.security_roles;
};

ZTObjects.reportObj.prototype.getCheckValues = function() {
  return this.check_values;
};

ZTObjects.reportObj.prototype.getQueriesList = function() {
  return this.queries_list;
};

ZTObjects.formObj = ZTObjects.reportObj;

/* Versioni del report
25/06/2010 4.0 Rivisitazione grafica del ReportEditor.
18/11/2011 4.1 Sixsigma, 2724: Posizionamento elementi del report nella parte xml del vrp.
23/05/2012 4.2 Nuova versione del disegnatore, si rende impossibile la rigenerazione dei nuovi report salvati con il PortalStudio ReportEditor.
10/08/2012 4.3 Def alleggerito delle proprieta' inutili.
17/09/2012 4.4 Oggetti copiati mantenevano lo stesso uid dell'item originale
28/12/2012 4.5 Aggiunte proprieta' di stampa (formato di pagina, orientamento di pagina, dimensioni di pagina, fiscaldoc,...) nel def del report.
22/05/2013 4.6 Build60 - Modifiche per Erika in B59 riguardanti i box.
15/07/2014 4.7 Build61 - Def in formato JSON.
15/07/2015 4.8 Build61 - Picture globale.
03/10/2019 4.9 Build61.5 - Hide under condition degli elementi convertite due volte quando contengono caratteri particolari.
*/
