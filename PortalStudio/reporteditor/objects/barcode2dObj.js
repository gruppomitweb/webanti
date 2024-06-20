ZTObjects.barcode2dObjClass={
  helper : {
    description : 'Expression Object to evaluate and to insert in the document as a barcode 2D',
    usage : 'Fill the Expression field, and select the Barcode type'
  },
  newProperties:{
    generic:[
      {name:'expression',				propID:'text',			type:'exp',			tooltip:'Expression to encode',				defaultValue:''},
      {name:'type',			propID:'barcodetype',			type:'select[QRCode,PDF417]',		tooltip:'Barcode Type',		defaultValue:'QRCode'
        ,hide_list:{
          'QRCode':[
          ],
          'PDF417':[
            'this.generic_errorcorrection'
          ]
        }
        ,show_list:{
          'QRCode':[
            'this.generic_errorcorrection'
          ],
          'PDF417':[
          ]
        }
        ,section:'barcode type'
      },
      {name:'error correction',			propID:'errorcorrection',			type:'select[L,M,Q,H]',		tooltip:'QRCode Error Correction Type',	defaultValue:'L',section:'barcode type'}
    ],
    layout:[],
    print_options:[],
    style:[]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.barcode2dObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.barcode2dObjClass );
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.barcode2dObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutNameClass, ZTObjects.barcode2dObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOutCsvClass, ZTObjects.barcode2dObjClass, true );
ZTObjects.extend( ZTObjects.stdObjExtPrintClass, ZTObjects.barcode2dObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintRemOutClass, ZTObjects.barcode2dObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutHyperLinkClass, ZTObjects.barcode2dObjClass );
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.barcode2dObjClass );
ZTObjects.extend( ZTObjects.stdObjStyleBarcodeClass, ZTObjects.barcode2dObjClass );

ZTObjects.barcode2dObj = function(id, name, type, value, html, x, y, h, w){
  this.objClass = ZTObjects.barcode2dObjClass;
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

ZTObjects.barcode2dObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.barcode2dObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.barcode2dObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};
