/*  exported dragstartx dragstarty newx newy mainitem index infindex nitem
    itemsHTMLArray imgHTML itemsHTML
 */
/*
global clCanvasLib nrPagesToView
*/
// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
var dragstartx, dragstarty, newx, newy, mainitem;
var index; // indice corrente del mainitem nell'Array
var infindex;
var nitem = 0; // numero item crescente
var itemsHTMLArray = new Array(); //array di array (per pagina) contenente tutti gli oggetti item con id, HTML, shadow, ecc
var imgHTML = new Array();
var itemsHTML = new Array();

if (typeof(ZTObjects) == 'undefined') {
    var ZTObjects = new function() {
    var type_select = "select[text,checkbox,radio,image]";
    var fonts_select = "select[Arial,Courier,Tahoma,Times New Roman,Verdana";
    var msg = new JSURL("../servlet/RPFontsList", true).Response();
    if (msg.length > 0) {
      var otherfontL = msg.split(',');
      for (var mm = 0; mm < otherfontL.length; mm++) {
        fonts_select += "," + otherfontL[mm].replace(/;/gi, ',');
      }
    }
    fonts_select += "]";
    var check_select = "select[Off,On]";
    var rotation_select = "select[0,90,180,270]";
    var align_select = "select[left,right,center]";
    var fonts_style = "select[normal,bold,italic,bold italic]";
    var fonts_effect = "select[,strikeout,underline,strikeout underline]";
    var format_select = "select[none,number,percentage,date,time,special]";
    var dateformat_select = "select[m/d,m/d/yy,m/d/yyyy,mm/dd/yy,mm/dd/yyyy,mm/yy,mm/yyyy,d-mmm,d-mmm-yy,d-mmm-yyyy,dd-mmm-yy,dd-mmm-yyyy,yy-mm-dd,yyyy-mm-dd,mm-yy,mmm-yyyy,mmmm-yy,mmmm-yyyy,m/d/yy h:MM tt,m/d/yyyy h:MM tt,m/d/yy HH:MM,m/d/yyyy HH:MM]";
    var timeformat_select = "select[HH:MM,h:MM tt,HH:MM:ss,h:MM:ss tt]";
    var specialformat_select = "select[Zip Code,Zip Code + 4,Phone Number,Social Security Number]";
    var numberseperator_select = "select[1234;56,1.234;56,1234.56,1;234.56]";
    var numbercurrency_select = "select[none,Euro,Dollar,Deutschmark,Franc,Guilder,Krona,Lira,Peseta,Pound,Yen]";
    var numbernegative_select = "select[minus,parentheses,red text,parentheses and red text]";
    var print_select = "select[All,Only First,Only Last,First and Last]";
    var datatype_select = "select[text,date,time,number]";

    this.formObjClass = {
      newProperties:{
        general:[
          {name:'pdf width',			propID:'width',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Pdf width'},
          {name:'pdf height',			propID:'height',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Pdf height'},
          {name:'',								propID:'proportions',			type:'checkbox',			disabled:true},
          {name:'rulers',					propID:'rulers',		type:'select[pt,mm,cm,pc,inch]',			convertFunc:'TranslateRulers',			validFunc:'ApplyUnit',			tooltip:'Unit of measurement used in the Editor'},
          {name:'description',		propID:'description',			type:'str',			tooltip:'Module\'s description'},
          {name:'pdf file',				propID:'file',			type:'str',			 noteditable:true,	buttons:'pick',			actions:'LoadPdf()',			tooltip:'Pdf file from which loading the pages'},
          {name:'source fields file',			propID:'fldfile',			type:'str',			noteditable:true,buttons:'pick,edit,reload',			actions:'LoadFieldsVrp(),EditVrp(),ReloadFields()',			tooltip:'File containing the fields'}
        ],
        global_font:[
          {name:'font',		propID:'font',		type:fonts_select,			tooltip:'Standard font'},
          {name:'size',		propID:'size',		type:'str',			tooltip:'Standard font size'},
          {name:'color',		propID:'color',		type:'str',			tooltip:'Standard font color'},
          {name:'style',		propID:'style',		type:fonts_style,			tooltip:'Standard font style'},
          {name:'effects',	propID:'effects',	type:fonts_effect,			tooltip:'Standard font effects'}
        ],
        global_pictures:[
          {name:'date picture',		propID:'datepic',		type:'str',			tooltip:'Standard picture for Date fields'},
          {name:'time picture',		propID:'timepic',		type:'str',			tooltip:'Standard picture for Time fields'},
          {name:'text picture',		propID:'textpic',		type:'str',			tooltip:'Standard picture for Text fields'},
          {name:'number picture',		propID:'numpic',		type:'str',			tooltip:'Standard picture for Number fields'}
        ]
      }
    };

    this.imgObjClass = {
      newProperties:{
        general:[
          {name:'name',			propID:'name',			type:'str',			tooltip:'Unique identifier for the Image in the current module'},
          {name:'src',			propID:'src',			type:'str'},
          {name:'rotation',		propID:'rotation',		type:rotation_select,		defaultValue:0},
          {name:'height',			propID:'h',				type:'int',		disabled:true},
          {name:'width',			propID:'w',				type:'int',		disabled:true}
        ]
      }
    };

    this.AreaObjClass = {
      newProperties:{
        general:[
          {name:'name (id)',			propID:'name',			type:'str',			tooltip:'Unique identifier for the Area in the current module'},
          {name:'current layer',		propID:'layer',			type:'layers',			tooltip:'Current Layer'},
          {name:'',					propID:'nlayers',		type:'int',		disabled:true},
          {name:'x',					propID:'x',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomX',			tooltip:'X coordinate'},
          {name:'y',					propID:'y',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomY',			tooltip:'Y coordinate'},
          {name:'height',				propID:'h',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomH',			tooltip:'Height'},
          {name:'width',				propID:'w',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomW',			tooltip:'Width'}
        ],
        detail_fields:[
          {name:'detail field',		propID:'detail',		type:'checkbox',			tooltip:'When this property is selected, the current Area will be reprinted in the page'},
          {name:'occurence number',	propID:'detailnumber',	type:'int',			tooltip:'Specify how many times the current Area will be reprinted in the page'},
          {name:'split with overflow',	propID:'stretch',	type:'checkbox',			tooltip:''},
          {name:'remove empty',		propID:'removeempty',	type:'checkbox',			tooltip:'When this property is selected, if all the fields in the current Area are empty, the Area will not be printed'}
        ]
      }
    };

    this.ZoneObjClass = {
      newProperties:{
        general:[
          {name:'name',				propID:'name',			type:'str',			tooltip:'Unique identifier for the DocField in the current module'},
          {name:'x',					propID:'x',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomX',			tooltip:'X coordinate'},
          {name:'y',					propID:'y',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomY',			tooltip:'Y coordinate'},
          {name:'height',				propID:'h',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomH',			tooltip:'Height'},
          {name:'width',				propID:'w',				type:'int',		convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	validFunc:'validUnitZoomW',			tooltip:'Width'},
          {name:'',					propID:'len',			type:'int',		disabled:true},
          {name:'',					propID:'dec',			type:'int',		disabled:true},
          {name:'',					propID:'picture',		type:'str',		disabled:true},
          {name:'area',				propID:'area',			type:'str',		noteditable:true,			tooltip:'Name of the Area containing the DocField'},
          {name:'num. layer',			propID:'layer',			type:'int',		noteditable:true,			tooltip:'Layer of the Area containing the DocField'}
        ],
        appareance:[
          {name:'text align',		propID:'align',			type:align_select,			tooltip:'Text Align'},
          {name:'global font',	propID:'globalfont',	type:'checkbox',	defaultValue:true
            ,hide_list:{'checked':['this.appareance_font','this.appareance_size','this.appareance_color','this.appareance_style','this.appareance_effects'],'unchecked':[]}
            ,show_list:{'checked':[],'unchecked':['this.appareance_font','this.appareance_size','this.appareance_color','this.appareance_style','this.appareance_effects']}
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Font'
          },
          {name:'font name',			propID:'font',		type:fonts_select,		tooltip:'Font applied when printing the current DocField'},
          {name:'font size',			propID:'size',		type:'str',		tooltip:'Font size applied when printing the current DocField'},
          {name:'font color',			propID:'color',		type:'str',		tooltip:'Font color applied when printing the current DocField'},
          {name:'font style',			propID:'style',		type:fonts_style,		tooltip:'Font style applied when printing the current DocField'},
          {name:'font effects',		propID:'effects',	type:fonts_effect,		tooltip:'Font effects applied when printing the current DocField'}
        ],
        format_picture:[
          {name:'Type',			propID:'datatype',		type:datatype_select
            ,show_list:{'text':['this.format_picture_lung']}
            ,hide_list:{'date':['this.format_picture_lung'],'time':['this.format_picture_lung'],'number':['this.format_picture_lung']}
            ,tooltip:'Field\'s type'
          },
          {name:'length',			propID:'lung',			type:'int',		tooltip:'Field\'s length'},
          {name:'',					propID:'len',			type:'int',		disabled:true},
          {name:'',					propID:'dec',			type:'int',		disabled:true},
          {name:'global pictures',	propID:'globalpic',	type:'checkbox'
            ,hide_list:{'checked':['this.format_picture_datapic']}
            ,show_list:{'unchecked':['this.format_picture_datapic']}
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Pictures'
          },
          {name:'Picture',			propID:'datapic',		type:'str',		tooltip:'Picture'}
        ],
        print_options:[
          {name:'type',							propID:'type_exp',			type:type_select
            ,hide_list:{'text':['this.print_options_checkdefault'],'checkbox':['this.print_options_replicate','this.print_options_replicatenumber'],'radio':['this.print_options_replicate','this.print_options_replicatenumber'],'image':['this.print_options_checkdefault','this.print_options_replicate','this.print_options_replicatenumber']}
            ,show_list:{'text':['this.print_options_printfield','this.print_options_replicate','this.print_options_replicatenumber'],'checkbox':['this.print_options_checkdefault','this.print_options_printfield'],'radio':['this.print_options_checkdefault','this.print_options_printfield'],'image':['this.print_options_printfield']}
            ,tooltip:'Specify how printing the field'
          },
          {name:'check default value',			propID:'checkdefault',		type:check_select,			tooltip:'Default value for checkbox'},
          {name:'specific TRUE value',			propID:'checktruevalue',		type:'str',			tooltip:'Value String for True',		defaultValue:''},
          {name:'print field',					propID:'printfield',		type:print_select,			tooltip:'Specify in which document\'s instance printing the field'},
          {name:'',								propID:'onlyfirst',			type:'checkbox',	disabled:true},
          {name:'',								propID:'onlylast',			type:'checkbox',	disabled:true},
          {name:'optical recognition fields',		propID:'replicate',			type:'checkbox',			tooltip:'When this property is selected, the field\'s value will be spelt out and each token will be printed in a new cell'},
          {name:'Max optical recognition number',	propID:'replicatenumber',	type:'int',			tooltip:'Maximum number of cell available when printing the DocField as an Optical Recognition Field'}
        ],
        detail_field:[
          {name:'detail field',															propID:'detail',					type:'checkbox',			tooltip:'When this property is selected, the current DocField will be reprinted in the page'},
          {name:'occurence number',													propID:'detailnumber',		type:'int',						tooltip:'Specify how many times the current DocField will be reprinted in the page'},
          {name:'split with overflow',											propID:'stretch',					type:'checkbox',			tooltip:''},
          {name:'work zone vertical delta (rulers unit)',		propID:'verticaldelta',		type:'int',	convertFunc:'convertUnit',	reconvertFunc:'reconvertUnit',	validFunc:'validUnitV',			tooltip:'Vertical distance between every instance of the current DocField'}
        ],
        editable_field:[
          {name:'format',					propID:'format',				type:format_select
            ,hide_list:{'none':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                                'this.editable_field_numbernegativeStyle','this.editable_field_dateformat','this.editable_field_timeformat',
                                'this.editable_field_specialformat','this.editable_field_customformat'],
                        'number':['this.editable_field_dateformat','this.editable_field_timeformat','this.editable_field_specialformat','this.editable_field_customformat'],
                        'percentage':['this.editable_field_dateformat','this.editable_field_timeformat','this.editable_field_specialformat','this.editable_field_customformat','this.editable_field_numbercurrencyStyle'],
                        'date':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                                'this.editable_field_numbernegativeStyle','this.editable_field_timeformat',
                                'this.editable_field_specialformat'],
                        'time':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                                'this.editable_field_numbernegativeStyle','this.editable_field_dateformat',
                                'this.editable_field_specialformat'],
                        'special':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                                'this.editable_field_numbernegativeStyle','this.editable_field_dateformat','this.editable_field_timeformat',
                                'this.editable_field_customformat']
            }
            ,show_list:{'none':[],
                        'number':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                                  'this.editable_field_numbernegativeStyle'],
                        'percentage':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle',
                                  'this.editable_field_numbernegativeStyle'],
                        'date':['this.editable_field_dateformat','this.editable_field_customformat'],
                        'time':['this.editable_field_timeformat','this.editable_field_customformat'],
                        'special':['this.editable_field_specialformat']
            }
            ,tooltip:'Format used when writing in the DocField if it is editable'
          },
          {name:'number decimal places',	propID:'numberformatdec',		type:'int',		tooltip:'Decimal digits'},
          {name:'number separator style',	propID:'numberseperatorStyle',	type:numberseperator_select,	convertFunc:'changeToComma',		tooltip:'Separator style'},
          {name:'number currency',		propID:'numbercurrencyStyle',	type:numbercurrency_select,		tooltip:'Currency'},
          {name:'negative number style',	propID:'numbernegativeStyle',	type:numbernegative_select,		tooltip:'Negative number style'},
          {name:'date format',			propID:'dateformat',			type:dateformat_select,	convertFunc:'convertToLowerCase',		tooltip:'Date format'},
          {name:'time format',			propID:'timeformat',			type:timeformat_select,		tooltip:'Time format'},
          {name:'special format',			propID:'specialformat',			type:specialformat_select,		tooltip:'Special format'},
          {name:'custom mask format',		propID:'customformat',			type:'str',		tooltip:'Custom format'}
        ],
        field:[
          {name:'editable field',			propID:'editfield',		type:'checkbox',			tooltip:''},
          {name:'obligatory',				propID:'obligatory',		type:'checkbox',			tooltip:''},
          {name:'obligatory condition',		propID:'oblcondition',		type:'str',			tooltip:'',	disabled:true}
        ],
        editable_text_field:[
          {name:'default value',			propID:'defaultvalue',	type:'str',		tooltip:'Default value suggested when the DocField is editable'},
          {name:'max characters number',	propID:'maxchar',		type:'int',		tooltip:'Maximum number of characters that the user can insert when the DocField is editable'},
          {name:'multi line',				propID:'multiline',		type:'checkbox',		tooltip:'When this property is selected, if the user inserts a text longer than the DocField width, the text will be write in several lines'},
          {name:'',						propID:'scroll',		type:'checkbox',	disabled:true,		tooltip:''}
        ]
      }
    };

    this.fieldObjClass = {
      newProperties:{
        general:[
          {name:'name',		propID:'name',		type:'str',			tooltip:'Unique identifier for the Field in the current module'},
          {name:'x',			propID:'x',			type:'int',			tooltip:'X coordinate'},
          {name:'y',			propID:'y',			type:'int',			tooltip:'Y coordinate'},
          {name:'h',			propID:'h',			type:'int',			tooltip:'Height'},
          {name:'w',			propID:'w',			type:'int',			tooltip:'Width'}
        ]
      }
    };

    this.stampObjClass = {
      newProperties:{
        general:[
          {name:'name',			propID:'name',		type:'str',			tooltip:'Unique identifier for the stamp/timbre'},
          {name:'stamp',		propID:'value',		type:'str',			tooltip:'Stamp/timbre to add to document',	noteditable:true},
          {name:'x',			propID:'x',			type:'int',			convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	tooltip:'X coordinate'},
          {name:'y',			propID:'y',			type:'int',			convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	tooltip:'Y coordinate'},
          {name:'h',			propID:'h',			type:'int',			convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	tooltip:'Height'},
          {name:'w',			propID:'w',			type:'int',			convertFunc:'convertUnitZoom',	reconvertFunc:'reconvertUnitZoom',	tooltip:'Width'},
          {name:'page',			propID:'page',		type:'int',		disabled:true}
        ],
        appareance:[
          {name:'text align',		propID:'align',			type:align_select,				disabled:true,	tooltip:'Text Align'},
          {name:'global font',	propID:'globalfont',	disabled:true,	type:'checkbox'
            ,hide_list:{'checked':['this.appareance_font','this.appareance_size','this.appareance_color','this.appareance_style', 'this.appareance_effects'],'unchecked':[]}
            ,show_list:{'checked':[],'unchecked':['this.appareance_font','this.appareance_size','this.appareance_color','this.appareance_style','this.appareance_effects']}
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Font'
          },
          {name:'font name',			propID:'font',			disabled:true,	type:fonts_select,		tooltip:'Font applied when printing the current DocField'},
          {name:'font size',			propID:'size',			disabled:true,	type:'str',		tooltip:'Font size applied when printing the current DocField'},
          {name:'font color',			propID:'color',			disabled:true,	type:'str',		tooltip:'Font color applied when printing the current DocField'},
          {name:'font style',			propID:'style',			disabled:true,	type:fonts_style,		tooltip:'Font style applied when printing the current DocField'},
          {name:'font effects',		propID:'effects',		disabled:true,	type:fonts_effect,		tooltip:'Font effects applied when printing the current DocField'},
          {name:'print field',					propID:'printfield',		disabled:true,	type:print_select,			tooltip:'Specify in which document\'s instance printing the field'},
          {name:'multi line',				propID:'multiline',		disabled:true,	type:'checkbox',		tooltip:'When this property is selected, if the user inserts a text longer than the DocField width, the text will be write in several lines'},
          {name:'draw border',				propID:'drawborder',		disabled:true,	type:'checkbox',		tooltip:''}
        ]
      }
    };

    this.signMarkObjClass={
      newProperties:{
        generic:[
          {name:'name',		propID:'name',		type:'str',			tooltip:'Unique identifier for the SignMark in the current module',	validFunc:'validXMLName'},
          {name:'title',				propID:'title',					type:'str',					defaultValue:'',	tooltip:'Sign markup title/description'},
          {name:'signature',		propID:'brequired',			type:'select[required:true,not required:false]',			defaultValue:'false',	tooltip:'Signature is required or not in the final document'},
          {name:'geo position',	propID:'bgeoposition',	type:'select[required:true,not required:false]',			defaultValue:'false',	tooltip:'Geo position for the signature is required or not'},
          {name:'date format',	propID:'dateformat',		type:'select[None,dd-MM-yyyy,dd/MM/yyyy,yyyy-MM-dd,yyyy/MM/dd]',	convertFunc:'convertDateTimeUpperCase', defaultValue:'None',	tooltip:'Set custom date format for the signature date',	extraClass:"col-3"},
          {name:'time format',	propID:'timeformat',		type:'select[None,HH:mm,HH:mm:ss,HH.mm,HH.mm.ss]',	convertFunc:'convertDateTimeLowerCase', defaultValue:'None',	tooltip:'Set custom time format for the signature hour',	extraClass:"col-3"},
          {name:'geo position and date in sign',				propID:'bhideextra',		type:'select[show:true,hide:false]',			defaultValue:'false',	tooltip:'Geo position and date visibile or not'},
          {name:'sequence',			propID:'sequence',			type:'int',			tooltip:'Specify the order in which signature will be required'},
          {name:'page',			propID:'page',		type:'int',		disabled:true},
          {name:'key',			propID:'key',		type:'str',		disabled:true},
          {name:'group',			propID:'group',		type:'str',		disabled:true},
          {name:'signtype',			propID:'signtype',		type:'str',		disabled:true},
          {name:'image',			propID:'image',		type:'str',		disabled:true},
          {name:'text',			propID:'text',		type:'str',		disabled:true},
          {name:'isMoved',			propID:'isMoved',		type:'checkbox',		disabled:true}
        ],
        layout:[
          {name:'x',						propID:'x',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',						propID:'y',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'width',				propID:'w',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Width',	extraClass:"col-3"},
          {name:'height',				propID:'h',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Height',	extraClass:"col-3"}
        ],
        print_options:[
          {name:'print field',					propID:'printfield',		type:'str',			tooltip:'Specify in which instance of the document printing the field',		defaultValue:'All'}
        ]
      }
    };

    this.formObj = function() {
      this.objClass = ZTObjects.formObjClass;
      this.height = 600;
      this.width = 600;
      this.proportions = 'false';
      this.description = '';
      this.file = '';
      this.fldfile = '';
      this.font = 'arial';
      this.size = '10';
      this.style = 'normal';
      this.effects = '';
      this.color = '';
      this.datepic = 'DD-MM-YYYY';
      this.timepic = 'hh:mm:ss';
      this.numpic = '999999999.99';
      this.textpic = '';
      this.v_line = 0;
      this.rulers = 'mm';
      this.type = "module";
    };

    this.ZoneObj = function(id, name, type, html, value, shadow, x, y, h, w) {
      this.objClass = ZTObjects.ZoneObjClass;
      this.id = id;
      this.name = name;
      this.type = type;
      this.typeName = "DocField";
      this.html = html;
      this.value = value;
      this.shadow = shadow;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;
      this.font = 'Verdana';
      this.size = '10pt';
      this.style = 'normal';
      this.effects = ' ';
      this.len = '10';
      this.dec = '0';
      this.exp = ' ';
      this.type_exp = 'text';
      this.align = 'left';
      this.page = 0;
      if (clCanvasLib != null) {
        this.scale = clCanvasLib.scale;
      }
      else {
        this.scale = CanvasLib.scale;
      }
      this.onlyfirst = false;
      this.onlylast = false;
      this.printfield = 'All';
      this.replicate = false;
      this.replicatenumber = '2';
      this.color = '#000000';
      this.globalfont = true;

      this.format = 'none';
      this.numberformatdec = '2';
      this.numberseperatorStyle = '1234,56';
      this.numbercurrencyStyle = 'none';
      this.numbernegativeStyle = 'minus';
      this.dateformat = 'm/d';
      this.timeformat = 'HH:MM';
      this.specialformat = 'Zip Code';
      this.customformat = ' ';

      this.detail = false;
      this.detailnumber = 0;
      this.verticaldelta = 0;
      this.checkdefault = '';
      this.defaultvalue = '';
      this.maxchar = 0;
      this.multiline = false;
      this.scroll = false;
      this.area = '';
      this.layer = 0;
      this.lung = '0';
      this.datapic = '';
      this.datatype = 'text';
      this.globalpic = true;
      this.hidden = false;
      this.stretch = false;
      this.editfield = false;
      this.edtname = false;
      this.name2 = '';
      this.color = "#000000";
      this.note = '';
      this.groupCheck = '';
      this.checktruevalue = '';

      this.isEdited = false;
      this.ishidden = false;
    };

    this.imgObj = function(id, name, type, html, value, shadow, pos, x, y, h, w, localsrc, src) {
      this.objClass = ZTObjects.imgObjClass;
      this.id = id;
      this.name = name;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;
      this.localsrc = localsrc;
      this.src = src;
      this.pos = pos;
      this.rotation = '0';
    };

    this.stampObj = function(id, name, type, html, value, shadow, x, y, w, h, page) {
      this.objClass = ZTObjects.stampObjClass;
      this.id = id;
      this.name = name;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;
      this.font = "Courier";
      this.size = '10';
      this.globalfont = false;
      this.color = "#000000";
      this.align = "left";
      this.effects = "";
      this.style = 'normal';
      this.page = page;
      this.scale = 100;
      this.isMoved = false;
      this.nrPagesToView = nrPagesToView;
      this.printfield = 'All';
      this.globalfont = false;
      this.multiline = false;
      this.drawborder = true;
      this.html = "<div id='" + this.id + "' type=text style='cursor:pointer;line-height:10pt;color:#000000;margin:0;padding:0px;overflow:hidden;z-index:2;border:1px solid gray;position:absolute;top:" + (y * this.scale / 100) + "px;left:" + (x * this.scale / 100) + "px;' class='transparentstamp'></div>";
      this.canvasw = 0;
      this.canvash = 0;
    };

    this.signMarkObj = function(id, name, type, x, y, w, h, page, value, key, sequence, group, signtype) {
      this.objClass = ZTObjects.signMarkObjClass;
      this.id = id;
      this.type = type;
      this.key = key;
      this.group = group;
      this.signtype = signtype;
      //Generic
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;
      this.uid = Upper(AlfaKeyGen(10));
      this.sequence = sequence;
      this.page = page;
      this.scale = 100;
      this.title = value;
      this.value = value;
      this.brequired = false;
      this.bgeoposition = false;
      this.dateformat = "None";
      this.timeformat = "None";
      this.bhideextra = false;
      this.show = true;
      this.font = 'Courier';
      this.size = '10';
      this.html = "<div class='signmark' id=\'" + this.id + "' style=\'z-index:2;width:" + (w * this.scale / 100) + "px;height:" +(h * this.scale / 100) + "px;position:absolute;top:" + (y * this.scale / 100) + "px;left:" + (x * this.scale / 100) + "px;\'></div>";
      this.canvasw = 0;
      this.canvash = 0;
      this.shadow = '';
      this.image = "";
      this.text = "";
    }

   //Oggetti per operazione UNDO
    this.undoObj = function(id, action, x, y, x_init, y_init, obj, w, h, w_init, h_init) {
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
  }
}
