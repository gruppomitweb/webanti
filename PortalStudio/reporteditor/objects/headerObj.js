ZTObjects.headerObjClass = {
  newProperties:{
    generic:[
          {name:'name',			noteditable:true,     propID:'name',			type:'str',			tooltip:'Unique identifier for the Header in the current report'},
          {name:'x',				propID:'x',				type:'int',			disabled:true,					convertFunc:'convertFromPixels',		reconvertFunc:'convertToPixels'},
          {name:'y',				propID:'y',				type:'int',		noteditable:true,					convertFunc:'convertFromPixels',		reconvertFunc:'convertToPixels',			tooltip:'Y coordinate'},
          {name:'uid',			propID:'uid',			type:'str',			disabled:true},
          {name:'sequence',			propID:'sequence',			type:'int',			noteditable:true,			disabled:true,			tooltip:'Sequence'},
          //{name:'bb_sequence',			propID:'bb_sequence',			type:'str',			disabled:true},
          {name:'page',				propID:'page',			type:'int',			disabled:true}
        ]
  }
};

ZTObjects.headerObj = function(id, name, type, value, shadow, x, y) {
  this.objClass = ZTObjects.headerObjClass;
  this.id = id;
  this.type = type;
  this.html = "";
  this.value = value;
  this.shadow = shadow;

 //Generic
  this.name = name;
  this.x = 0;
  this.y = y;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  //this.bb_sequence = nBarItems;
  this.page = 1;

 //Non visibili
  this.scale = 100;
  this.show = false;
  this.isBand = true;
  this.hidden = true;
  this.child = -1;
  this.bcolor = "#00CC00";
  this.title = "Page Header";
  this.level = 0;
};

ZTObjects.headerObj.prototype.getHtml = function() {
  return getBarHtml(this);
};

ZTObjects.headerObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.headerObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.headerObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};