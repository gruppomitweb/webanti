ZTObjects.sectionObjClass = {
  helper : {
    description : 'Define a Hide section of space of objects to insert in the document under condition',
    usage :  'Fill the "hide under condition" field, specifying validation expression'
  },
  newProperties:{
    generic:[],
    layout:[],
    print_options:[
      {name:'Row print order',			propID:'sequence',	disabled:true, type:'int',			tooltip:'Specify the order in which printing the elements with the same Y coordinate'}
    ]
  }
};

ZTObjects.extend( ZTObjects.stdObjLayoutBarClass, ZTObjects.sectionObjClass );
ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.sectionObjClass );
ZTObjects.extend( ZTObjects.stdObjBlockClass, ZTObjects.sectionObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOptBarPrintClass, ZTObjects.sectionObjClass );

ZTObjects.sectionObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.sectionObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = '';
  this.value = value;
  this.shadow = shadow;

 //Generic
  this.comment = name;
  this.name = name;
  this.y = y;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

 //Non visibili
  this.child = -1;
  this.x = 0;
  this.isBand = true;
  this.bcolor = '#D80000';
  this.title = 'Section';
  this.scale = 100;
  this.show = true;
  if ( type.indexOf("_down") >= 0) {
    this.show = false;
  }
  this.hidden = true;
  this.level = 1;
};

ZTObjects.sectionObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.sectionObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.sectionObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.sectionObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};