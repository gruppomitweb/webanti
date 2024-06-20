ZTObjects.htmlsectionObjClass = {
  helper : {
    description : 'Insert a HtmlSection in the document'
  },
  newProperties:{
    generic:[
      {name:'Text',				propID:'exp',			type:'exp',			tooltip:'Constant text or Expression',			defaultValue:''},
      {name:'text type',			propID:'text_type',			type:'select[constant,expression]'
        ,tooltip:'Select whether the "Text field" is a constant or an expression'
        ,defaultValue:'constant'
        ,hide_list:{
          'constant':['this.generic_output_name','this.generic_column_title','this.generic_privacy','this.generic_data_danger_level','this.generic_identifier'],
          'expression':[]
        }
        ,show_list:{
          'constant':[],
          'expression':['this.generic_output_name','this.generic_column_title','this.generic_privacy','this.generic_data_danger_level','this.generic_identifier']
        }
      },
      {name:'print as block',			propID:'printblock',			type:'checkbox',			tooltip:'Print as block',			defaultValue:false, disabled:true}
    ],
    layout:[
      {name:'Left margin',				propID:'xl',				type:'int',			defaultValue:0, convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Left margin'},
      {name:'Right margin',				propID:'xr',				type:'int',			defaultValue:0, convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Right margin'}
    ],
    print_options:[],
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

ZTObjects.extend( ZTObjects.stdObjLayoutBarClass, ZTObjects.htmlsectionObjClass);
ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.htmlsectionObjClass);
ZTObjects.extend( ZTObjects.stdObjBlockClass, ZTObjects.htmlsectionObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutBarNameClass, ZTObjects.htmlsectionObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOptBarPrintClass, ZTObjects.htmlsectionObjClass);
ZTObjects.extend(ZTObjects.stdObjStyleFontClass, ZTObjects.htmlsectionObjClass, true);

ZTObjects.htmlsectionObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.htmlsectionObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = "";
  this.value = value;
  this.shadow = shadow;
  this.child = -1;

 //Generic
  this.comment = name;
  this.name = name;
  this.x = 0;
  this.y = y;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

 //Non visibili
  this.isBand = true;
  this.bcolor = "#FFDB58";
  this.title = "Html section";
  this.scale = 100;
  this.show = true;
  this.hidden = true;
};

ZTObjects.htmlsectionObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.htmlsectionObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.htmlsectionObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.htmlsectionObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};