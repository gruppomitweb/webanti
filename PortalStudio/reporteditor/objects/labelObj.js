ZTObjects.labelObjClass={
 helper : {
    description : 'Simple Label Text to insert in the document',
    usage : 'Fill the Text field. If the Text type field is Expression, the Text field will be evaluated as an expression'
  },
  newProperties:{
    generic:[
      {name:'text',			propID:'value',			type:'exp',			tooltip:'String text',			validFunc:'validText',			defaultValue:''},
      {name:'text type',			propID:'text_type',			type:'select[constant,expression]'
        ,tooltip:'Select whether the "Text field" is a constant or an expression'
        ,hide_list:{
          'constant':['this.generic_output_name','this.generic_column_title','this.generic_privacy','this.generic_data_danger_level','this.generic_identifier'],
          'expression':[]
        }
        ,show_list:{
          'constant':[],
          'expression':['this.generic_output_name','this.generic_column_title','this.generic_privacy','this.generic_data_danger_level','this.generic_identifier']
        }
      }
    ],
    layout:[],
    print_options:[
      {name:'simple truncate',				propID:'struncate',			type:'checkbox',	tooltip:'Truncate without ...',			defaultValue:false,	extraClass:"col-3", section:'Truncate text'}
    ],
    style:[ 
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
    ]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.labelObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.labelObjClass );
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.labelObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutNameClass, ZTObjects.labelObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutCsvClass, ZTObjects.labelObjClass, true );
ZTObjects.extend( ZTObjects.stdObjStyleFontClass, ZTObjects.labelObjClass );
ZTObjects.extend( ZTObjects.stdObjExtPrintClass, ZTObjects.labelObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintRemOutClass, ZTObjects.labelObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutHyperLinkClass, ZTObjects.labelObjClass );


ZTObjects.labelObj = function(id, name, type, value, shadow, x, y, h, w) {
  this.objClass = ZTObjects.labelObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.shadow = shadow;

  //Generic
  this.text_type = "constant";
  this.name = name;
  this.value = value;
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

  this.html = "<div id='" + this.id + "' type=text onclick='clickItem(event)'";
  var fz = parseInt(reportProp.font_size);
  if (fz <= 0) { fz = 10; }
  fz = fz * 96 / 72;
  this.html += " style='width:" + fz * 5 + "px;height:" + fz + "px;overflow:hidden;margin:0px;padding:0px;z-index:2;border:1px dotted #d9d9d9;position:absolute;top:" + this.y + "px;left:" + this.x + "px;'";
  this.html += " class='unselectable'><div id='" + this.id + "_int" + "'>" + ToReportHTML(this.value) + "</div></div>";
};

ZTObjects.labelObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.labelObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.labelObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};

ZTObjects.labelObj.prototype.getKeys = function() {
  return this.link_parameters;
};

ZTObjects.labelObj.prototype.getValues = function() {
  return this.link_parameters_value;
};
