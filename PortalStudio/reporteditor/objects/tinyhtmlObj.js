ZTObjects.tinyHTMLObjClass={ //expObj
  helper : {
    description : 'Insert simple raw HTML in Report',
    usage : 'Fill the Text type field as Expression and it will be evaluated.'
  },
  newProperties:{
    generic:[
      {name:'Text',				propID:'exp',			type:'exp',			tooltip:'Constant text or Expression',			defaultValue:''},
      {name:'text type',			propID:'text_type',			type:'select[constant,expression]'
        ,tooltip:'Select whether the "Text field" is a constant or an expression'
        ,defaultValue:'constant'
      }
    ],
    layout:[],
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

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.tinyHTMLObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.tinyHTMLObjClass );
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.tinyHTMLObjClass, true );
ZTObjects.extend(ZTObjects.stdObjStyleFontClass, ZTObjects.tinyHTMLObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintClass, ZTObjects.tinyHTMLObjClass, true);
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.tinyHTMLObjClass );


ZTObjects.tinyHTMLObj = function(id, name, type, value, shadow, x, y, h, w) {
  this.objClass = ZTObjects.tinyHTMLObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
 //Generic
  this.name = name;
  this.value = value;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

  //Non visibili
  this.scale = 100;
  this.show = true;
  this.html = "<img id=\'" + this.id + "' src='" + getObjImg('tinyHTML') + "' style=\'border:1px solid #f3f3f3;z-index:2;width:50px;height:50px;position:absolute;top:" + this.y + "px;left:" + this.x + "px;\' onclick=\'clickItem(event)\'>";
};

ZTObjects.tinyHTMLObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.tinyHTMLObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.tinyHTMLObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};
