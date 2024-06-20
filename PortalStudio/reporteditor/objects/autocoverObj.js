ZTObjects.autocoverObjClass = {
  helper : {
    description : 'Insert (only one by report on the cover tab) automatically the cover object (Parameters Mask) use as filter for the report'
  },
  newProperties:{
    generic:[
      {name:'comment',		noteditable:true,		propID:'comment',		type:'str'					,tooltip:'Comment',		defaultValue:'Parameters mask'},
      {name:'name',			disabled:true, noteditable:true,			propID:'name',			type:'str',			tooltip:'Unique identifier cover line'},
      {name:'uid',			propID:'uid',		type:'str',		disabled:true},
      {name:'page',			propID:'page',		type:'int',		disabled:true},
      {name:'left margin',				propID:'lmargin',		type:'int'			,convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',	tooltip:'Left margin',		defaultValue:0, section:"Group Title"},
      {name:'right line margin',		propID:'rmargin',		type:'int'			,convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',	tooltip:'Right margin',		defaultValue:0, section:"Group Title"},
      {name:'line height',				propID:'lheight',		type:'int'			,tooltip:'Line height',		defaultValue:1, section:"Group Title"}
    ],
    layout:[
      {name:'y',				propID:'y',				type:'int',			noteditable:true,				convertFunc:'convertFromPixels',		reconvertFunc:'convertToPixels',			tooltip:'Y coordinate'}
    ]
  }
};

ZTObjects.autocoverObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.autocoverObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = "";
  this.value = value;
  this.shadow = shadow;
  this.child = -1;

 //Generic
  this.name = name;
  this.x = 0;
  this.y = y;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 0;

 //Groups Title
  this.lmargin = 0;
  this.lheight = 1;
  this.rmargin = 0;

 //Non visibili
  this.isBand = true;
  this.bcolor = "#0B6B69";
  this.title = "Auto Cover";
  this.scale = 100;
  this.show = true;
  this.hidden = true;
};

ZTObjects.autocoverObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.autocoverObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.autocoverObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.autocoverObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};