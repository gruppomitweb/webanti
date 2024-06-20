ZTObjects.signSVGObjClass={ //expObj
  helper : {
    description : 'Drawing a SVG graphic object in the document<br>The SVG tag must contain the attributes width and height, and will be loaded with the namespace "http://www.w3.org/2000/svg"',
    usage : 'Fill the Text type field as Expression and it will be evaluated. The result must be : <ul><li>an SVG string</li><li> or a string ending with .svg, indicating a file path</li></ul>'
  },
  newProperties:{
    generic:[
      {name:'Text',				propID:'exp',			type:'exp',			tooltip:'Constant text or Expression',			defaultValue:''},
      {name:'text type',			propID:'text_type',			type:'select[constant,expression]'
        ,tooltip:'Select whether the "Text field" is a constant or an expression'
        ,defaultValue:'constant'
        ,hide_list:{
          'constant':['this.generic_output_name','this.generic_column_title'],
          'expression':[]
        }
        ,show_list:{
          'constant':[],
          'expression':['this.generic_output_name','this.generic_column_title']
        }
      }
    ],
    layout:[],
    print_options:[]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.signSVGObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.signSVGObjClass );
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.signSVGObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutNameClass, ZTObjects.signSVGObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutCsvClass, ZTObjects.signSVGObjClass, true );
ZTObjects.extend( ZTObjects.stdObjExtPrintClass, ZTObjects.signSVGObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintRemOutClass, ZTObjects.signSVGObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutHyperLinkClass, ZTObjects.signSVGObjClass );
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.signSVGObjClass );


ZTObjects.signSVGObj = function(id, name, type, value, shadow, x, y, h, w) {
  this.objClass = ZTObjects.signSVGObjClass;
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
  this.html = "<img id=\'" + this.id + "' src='" + getObjImg('SignSVG') + "' style=\'border:1px solid #f3f3f3;z-index:2;width:50px;height:50px;position:absolute;top:" + this.y + "px;left:" + this.x + "px;\' onclick=\'clickItem(event)\'>";
};

ZTObjects.signSVGObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.signSVGObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.signSVGObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};
