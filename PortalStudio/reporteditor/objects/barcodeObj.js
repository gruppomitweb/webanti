ZTObjects.barcodeObjClass={
  helper : {
    description : 'Expression Object to evaluate and to insert in the document as a barcode',
    usage : 'Fill the Expression field, and select the Barcode type'
  },
  newProperties:{
    generic:[
      {name:'expression',				propID:'text',			type:'exp',			tooltip:'Expression to encode',			defaultValue:''},
      {name:'type',			propID:'barcodetype',			type:'select[EAN-8,EAN-13,UPC-A,Code39,Code128,ITF,CODABAR]',			tooltip:'Barcode Type',	defaultValue:'EAN-8',section:'barcode type'}
    ],
    layout:[],
    print_options:[],
    style:[
      {name:'draw vertical',				propID:'vertical',			type:'checkbox',			tooltip:'Rotate the barcode as vertical',			defaultValue:false},
    ]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.barcodeObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.barcodeObjClass );
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.barcodeObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutNameClass, ZTObjects.barcodeObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutCsvClass, ZTObjects.barcodeObjClass, true );
ZTObjects.extend( ZTObjects.stdObjExtPrintClass, ZTObjects.barcodeObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintRemOutClass, ZTObjects.barcodeObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutHyperLinkClass, ZTObjects.barcodeObjClass );
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.barcodeObjClass );
ZTObjects.extend( ZTObjects.stdObjStyleBarcodeClass, ZTObjects.barcodeObjClass );


ZTObjects.barcodeObj = function(id, name, type, value, html, x, y, h, w){
  this.objClass = ZTObjects.barcodeObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = html;

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
};

ZTObjects.barcodeObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.barcodeObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.barcodeObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};
