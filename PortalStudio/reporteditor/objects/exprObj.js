ZTObjects.ExprObjClass = {
  helper : {
    description : 'Expression Object to evaluate and to insert in the document',
    usage : 'Fill the Expression field, and select the Expression type'
  },
  newProperties:{
    generic:[
      {name:'expression',			propID:'exp',				type:'exp',					tooltip:'Expression',		defaultValue:''},
      {name:'Expression type',			propID:'type_exp',		type:ZTObjects.type_select
        ,tooltip:'Expression type',		defaultValue:'character'
        ,hide_list:{
          'character,logic,date,datetime,memo':['this.generic_dec'],
          'numeric':[]
        }
        ,show_list:{
          'character,logic,date,datetime,memo':[],
          'numeric':['this.generic_dec']
        }
      },
      {name:'length',			propID:'len',			type:'int',					tooltip:'Expression type length',	defaultValue:10},
      {name:'decimal digits',			propID:'dec',			type:'int',					tooltip:'Decimal digits of the expression type',	defaultValue:''}
    ],
    layout:[],
    print_options:[],
    style:[
      {name:'expression picture',		propID:'global_picture',		type:'select[use global picture:true,use custom picture:false]'
        ,tooltip:'When this property is selected, the Expression will be printed using the Global Picture',	defaultValue:true
        ,hide_list:{
          'true':[
            'this.style_picture'
          ],
          'false':[]
        }
        ,show_list:{
          'true':[],
          'false':[
            'this.style_picture'
          ]
        }
      },
      {name:'picture',			propID:'picture',		type:'exp',					tooltip:'Display format',	defaultValue:''},
      {name:'background-color type',					propID:'bgcoltype',				type:'select[constant,expression]'
            ,tooltip:'Select whether the specified background color is a constant or an expression',	defaultValue:'constant'
            ,hide_list:{
              'constant':['this.style_bgcolexp'],
              'expression':['this.style_bgcolor']
            }
            ,show_list:{
              'constant':['this.style_bgcolor'],
              'expression':['this.style_bgcolexp']
            }
            ,extraClass:"col-3"
          },
          {name:'background-color',			propID:'bgcolor',			type:'color',			tooltip:'Color selected for background-color',	defaultValue:'#FFFFFF',	extraClass:"col-3"},
          {name:'background-color',			propID:'bgcolexp',		type:'exp',				tooltip:'Color selected for background-color as expression, format #hex',	defaultValue:'',	extraClass:"col-3"}
    ],
    print_options:[
      {name:'stretch with overflow',						propID:'stretch',					type:'checkbox',			tooltip:'Use more rows to show long contens',	defaultValue:false,	extraClass:"col-3"
        ,hide_list:{
            'checked':[
              'this.print_options_struncate'
            ],
            'unchecked':[]
          }
          ,show_list:{
            'checked':[],
            'unchecked':[
              'this.print_options_struncate'
            ]
          }, section:'Stretch or Truncate text'
      },
      {name:'simple truncate',				propID:'struncate',			type:'checkbox',	tooltip:'Truncate without ...',			defaultValue:false,	extraClass:"col-3", section:'Stretch or Truncate text'}
    ],
    special_definitions:[
      {name:'calculations',		propID:'calculations',		type:'select[nothing,count,sum,max,min,average]'
        ,tooltip:'Allowable calculations',	defaultValue:'nothing'
        ,hide_list:{
          'nothing':[
            'this.special_definitions_resetuid',
            'this.special_definitions_into_variable',
            'this.special_definitions_calculate_onuid',
            'this.special_definitions_calculate_when'
          ],
          'count,sum,max,min,average':[]
        }
        ,show_list:{
          'nothing':[],
          'count,sum,max,min,average':[
            'this.special_definitions_resetuid',
            'this.special_definitions_into_variable',
            'this.special_definitions_calculate_onuid',
            'this.special_definitions_calculate_when'
          ]
        }
      },
      {name:'reset',				propID:'reset',				type:'select[end of report,end of page]',	disabled:true,	defaultValue:'end of report'},
      {name:'reset on',			propID:'resetuid',			type:resetonuid,	convertFunc:'TranslateGroupUid',	validFunc:'ApplyGroupUidR'
        ,tooltip:'Select the point at which the expression is set to its initial value',	defaultValue:'end of report'},
      {name:'into variable',		propID:'into_variable',		type:into_variable_combo,			tooltip:'Variable written by calculation',	defaultValue:''},
      {name:'calculate',			propID:'calculate_on',		type:'select[each record,end of report]',	disabled:true,	defaultValue:'each record'},
      {name:'calculate on',		propID:'bb_calculate_on',		type:'str',	disabled:true,	defaultValue:'false'},
      {name:'calculate on',		propID:'calculate_onuid',		type:calconuid,	convertFunc:'TranslateGroupUid',	validFunc:'ApplyGroupUidC'
        ,tooltip:'Select the point at which the calculations are executed',	defaultValue:'each record'},
      {name:'calculate when',			propID:'calculate_when',				type:'exp',					tooltip:'Calculate variable when this condition is true',		defaultValue:''}
    ]
  }
};

ZTObjects.extend(ZTObjects.stdObjClass, ZTObjects.ExprObjClass);
ZTObjects.extend(ZTObjects.stdObjOptPrintClass, ZTObjects.ExprObjClass);
ZTObjects.extend(ZTObjects.stdObjPrivacyClass, ZTObjects.ExprObjClass, true);
ZTObjects.extend(ZTObjects.stdObjOutNameClass, ZTObjects.ExprObjClass, true);
ZTObjects.extend(ZTObjects.stdObjOutCsvClass, ZTObjects.ExprObjClass, true);
ZTObjects.extend(ZTObjects.stdObjStyleFontClass, ZTObjects.ExprObjClass, true);
ZTObjects.extend(ZTObjects.stdObjExtPrintClass, ZTObjects.ExprObjClass, true);
ZTObjects.extend(ZTObjects.stdObjExtPrintRemOutClass, ZTObjects.ExprObjClass, true);
ZTObjects.extend(ZTObjects.stdObjOutHyperLinkClass, ZTObjects.ExprObjClass);
ZTObjects.extend(ZTObjects.stdObjNoteClass, ZTObjects.ExprObjClass);

ZTObjects.ExprObj = function(id, name, type, value, shadow, x, y, h, w){
  this.objClass = ZTObjects.ExprObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.shadow = shadow;

  //Generic
  this.name = name;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

  //Style
  this.font = reportProp.font;
  this.font_size = reportProp.font_size;
  this.font_weight = reportProp.font_weight;
  this.font_effect = reportProp.font_effect;

  //Hyperlink
  this.link_parameters = ""; // Serve per evitare un errore in apertura della finestra keysvalue_edit.html

  //Non visibili
  this.scale = 100;
  this.show = true;
  var fz = parseInt(reportProp.font_size);
  if (fz <= 0) { fz = 10; }
  fz = fz * 96 / 72 + 5;

  this.html = "<div id='" + this.id + "' type=text onclick='clickItem(event)'";
  this.html += " style='width:" + fz * 5 + "px;height:" + fz + "px;color:#000000;margin:0;padding:2px;overflow:hidden;z-index:2;border:1px solid gray;position:absolute;top:" + this.y + "px;left:" + this.x + "px;'";
  this.html += " class='unselectable'><div id='" + this.id + "_int" + "'>Expr</div></div>";
};

ZTObjects.ExprObj.prototype.writeDef = function() {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.ExprObj.prototype.readDef = function(def) {
  readStandardDef(def);
};

ZTObjects.ExprObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};

ZTObjects.ExprObj.prototype.getKeys = function() {
  return this.link_parameters;
};

ZTObjects.ExprObj.prototype.getValues = function() {
  return this.link_parameters_value;
};
