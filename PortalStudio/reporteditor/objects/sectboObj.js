ZTObjects.sectboObjClass = {
  helper : {
    description : 'Define a Business Object and space of objects to insert in the document, as a sub-report',
    usage :  'Fill the Bo name field, specifying the Bo to execute'
  },
  newProperties:{
    generic:[
      {name:'Bo name',			propID:'busobj',			type:'str',			buttons:'pick',			actions:'LoadBO()',			validFunc:'validBOIndex',			tooltip:'Business Object',			defaultValue:'', section:'Business Object'},
      {name:'is Child',			propID:'ischild',			type:'checkbox'
        ,hide_list:{'checked':['this.generic_value_key','this.generic_value_expr'],'unchecked':[]}
        ,show_list:{'checked':[],'unchecked':['this.generic_value_key','this.generic_value_expr']}
        ,validFunc:'validBarProperty'
        ,tooltip:'When this property is selected, the selected BO is considered as a child of another BO'
        ,defaultValue:'false', section:'Business Object'},
      {name:'Bo parent',			propID:'boparent',			type:'str',			disabled:true,			defaultValue:'', section:'Business Object'},
      {name:'keys',			propID:'value_key',			type:'str',			buttons:'edit',			actions:'LoadKV()',			validFunc:'validBarProperty'
        ,tooltip:'List of key fields of the BO',			defaultValue:'', extraClass:"col-3", section:'Business Object'},
      {name:'values',			propID:'value_expr',			type:'str',			buttons:'edit',			actions:'LoadKV()',			validFunc:'validBarProperty'
        ,tooltip:'List of value of the key field of the BO',			defaultValue:'', extraClass:"col-3", section:'Business Object'}
    ],
    layout:[]
  }
};

ZTObjects.extend( ZTObjects.stdObjLayoutBarClass, ZTObjects.sectboObjClass );
ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.sectboObjClass );
ZTObjects.extend( ZTObjects.stdObjOutBarNameClass, ZTObjects.sectboObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOptBarPrintClass, ZTObjects.sectboObjClass );

ZTObjects.sectboObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.sectboObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = "";
  this.value = value;
  this.shadow = shadow;

 //Generic
  this.comment = name;
  this.name = name;
  this.y = y;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

 //Functional

 //Non visibili
  this.isBand = true;
  this.child = -1;
  this.bcolor = "#C16DF2";
  this.title = "Business Object";

  this.bokeys = [];
  this.x = x;
  this.show = true;
  if ( type.indexOf("_down") >= 0) {
    this.show = false;
  }
  this.scale = 100;
  this.hidden = true;
  this.level = 1;
};

ZTObjects.sectboObj.prototype.writeDef = function () {
  isSon();
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.sectboObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.sectboObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};

ZTObjects.sectboObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.sectboObj.prototype.getKeys = function() {
  return this.value_key;
};

ZTObjects.sectboObj.prototype.getValues = function() {
  return this.value_expr;
};
