ZTObjects.signMarkObjClass = {
  helper : {
    description : 'Signature Markup Object - Insert in the "PDF Catalog" a markup for document future signatures'+
    '<br>Markups are insert as JSON Array with "it.zucchetti.signatures" as key in the document information catalog'
  },
  newProperties:{
    generic:[
      {name:'title',				propID:'title',				type:'str',				tooltip:'Sign markup title/description',		defaultValue:'', section:'signature',	extraClass:"col-3"},
      {name:'type',				  propID:'signtype',			section:'signature', type:'select[Privacy:signPrivacy,Unfair:signUnfair]',					defaultValue:'',	tooltip:'Sign markup type',	extraClass:"col-3"},
      {name:'signature',		propID:'brequired',		type:ZTObjects.requiredOrNot,			tooltip:'Signature is required or not in the final document',	defaultValue:'false', section:'signature', extraClass: "col-3"},
      {name:'sequence',			propID:'sequence',		type:'int',			tooltip:'Specify the order in which signature will be required', section:'signature', extraClass: "col-3"},
      {name:'date format',	propID:'dateformat',	type:'select[None,dd-MM-yyyy,dd/MM/yyyy,yyyy-MM-dd,yyyy/MM/dd]',	convertFunc: "convertDateTimeUpperCase", tooltip:'Set custom date format for the signature date',	defaultValue:'None', extraClass: "col-3", section:'Date and Time'},
      {name:'time format',	propID:'timeformat',	type:'select[None,HH:mm,HH:mm:ss,HH.mm,HH.mm.ss]',	convertFunc: "convertDateTimeLowerCase",	tooltip:'Set custom time format for the signature hour',	defaultValue:'None', extraClass: "col-3", section:'Date and Time'},
      {name:'geo position',	propID:'bgeoposition',	type:ZTObjects.requiredOrNot,		tooltip:'Geo position for the signature is required or not',	defaultValue:'false', section:'geographic', extraClass: "col-3"},   
      {name:'geo position and date',			propID:'bhideextra',	type:'select[show:true,hide:false]',	tooltip:'Geo position and date visibile or not',		defaultValue:'false', section:'geographic', extraClass: "col-3"}
    ],
    layout:[],
    print_options:[]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.signMarkObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.signMarkObjClass );
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.signMarkObjClass );

ZTObjects.signMarkObj = function(id, name, type, value, shadow, x, y, h, w) {
  this.objClass = ZTObjects.signMarkObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.value = value;
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

  //Non visibili
  this.scale = 100;
  this.show = true;
  this.html = "<img id=\'" + this.id + "' src='" + getObjImg('SignMark') + "' style=\'border:1px solid #f3f3f3;z-index:2;width:50px;height:50px;position:absolute;top:" + this.y + "px;left:" + this.x + "px;\' onclick=\'clickItem(event)\'>";
};

ZTObjects.signMarkObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.signMarkObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.signMarkObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};