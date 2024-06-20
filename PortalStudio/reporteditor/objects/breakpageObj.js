ZTObjects.breakpageObjClass = {
  helper : {
    description : 'Insert a BreakPage in the document'
  },
  newProperties:{
    generic:[
      {name:'comment',		propID:'comment',		type:'str'					,tooltip:'Comment',		defaultValue:''},
      {name:'page break under condition',			propID:'breakpagecond',			type:'exp',		tooltip:'Starts a new page when this formula is TRUE',		defaultValue:''},
      {name:'name',			disabled:true,  propID:'name',			type:'str',			noteditable:true,			tooltip:'Unique identifier for the Page Break in the current report'},
      {name:'uid',			propID:'uid',		type:'str',		disabled:true},
      {name:'sequence',			propID:'sequence',	type:'int',			disabled:true,			tooltip:'Sequence'},
      {name:'page',				propID:'page',	type:'int',		disabled:true}
    ],
    layout:[
      {name:'y',				propID:'y',				type:'int',			noteditable:true,				convertFunc:'convertFromPixels',		reconvertFunc:'convertToPixels',			tooltip:'Y coordinate'}
    ]
  }
};

ZTObjects.breakpageObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.breakpageObjClass;
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
  this.bcolor = "#0000FF";
  this.title = "Page Break";
  this.scale = 100;
  this.show = true;
  this.hidden = true;
};

ZTObjects.breakpageObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.breakpageObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.breakpageObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.breakpageObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};