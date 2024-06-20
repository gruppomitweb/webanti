ZTObjects.imageObjClass = {
  helper : {
    description : 'Image to insert in the document',
    usage : 'Fill the Source field. If the Source type field is Expression, the Source field will be evaluated as an expression<br>The result must indicate a file path'
  },
  newProperties:{
    generic:[
      {name:'source',			propID:'src',			type:'str',			buttons:'pick,edit',	actions:'SelectImage(),EditImage()',	tooltip:'Image source',	defaultValue:''},
      {name:'source type',			propID:'src_type',			type:'select[constant,expression]',			tooltip:'Select whether the Image name is a constant or an expression'
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
    print_options:[
      {name:'print Not Found image',			propID:'print_not_found_image',			type:'checkbox',			tooltip:'Print Not found image when the selected image is missing',			defaultValue:true,	extraClass:"col-3", section:'Image Not Found'}
    ],
    style:[
      {name:'scale to frame size',			propID:'scale_to_frame_size',			type:'checkbox',			validFunc:'validImageOptions'
        ,tooltip:'Indicating whether an image resizes to fit the size of the image frame',			defaultValue:false,	extraClass:"col-2"
        ,hide_list:{
          'checked':[],
          'unchecked':['this.style_keep_proportions','this.style_circle_to_frame_size']
        }
        ,show_list:{
          'checked':['this.style_keep_proportions','this.style_circle_to_frame_size'],
          'unchecked':[]
        }
      },
      {name:'keep proportions',			propID:'keep_proportions',			type:'checkbox',			tooltip:'Indicating that the image must not be distorted',			defaultValue:false,	extraClass:"col-2"},
      {name:'circle to frame size',		propID:'circle_to_frame_size',		type:'checkbox',			tooltip:'Indicating whether an image is clipped to a circle inside the image frame',			defaultValue:false,	extraClass:"col-2"},
      {name:'clip to frame size',		propID:'clip_to_frame_size',		type:'checkbox',			validFunc:'validImageOptions'
        ,tooltip:'Indicating whether an image is clipped to the size of the image frame',			defaultValue:false,	extraClass:"col-6"},
      {name:'align to right',			propID:'align_to_right_border',			type:'checkbox',			disabled:true,			defaultValue:false}
    ]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.imageObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.imageObjClass);
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.imageObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutNameClass, ZTObjects.imageObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutCsvClass, ZTObjects.imageObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintClass, ZTObjects.imageObjClass, true);
ZTObjects.extend( ZTObjects.stdObjExtPrintRemOutClass, ZTObjects.imageObjClass, true);
ZTObjects.extend( ZTObjects.stdObjOutHyperLinkClass, ZTObjects.imageObjClass);
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.imageObjClass);

ZTObjects.imageObj = function(id, name, type, html, value, shadow, x, y, h, w, localsrc, src) {
  this.objClass = ZTObjects.imageObjClass;
  initPropertiesDefaultValue(this);
  this.id = id;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;

  //Generic
  this.src_type = "constant";
  this.src = src;
  this.name = name;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

  //Hyperlink
  this.link_parameters = ""; // Serve per evitare un errore in apertura della finestra keysvalue_edit.html

  //Non visibili
  this.localsrc = localsrc;
  this.scale = 100;
  this.show = true;
  this.removefromout = "CSV,CSVS,CSV2,XML,XMLS,XLS,XLSX"; //retrocompatibilità
};

ZTObjects.imageObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.imageObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.imageObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};

ZTObjects.imageObj.prototype.getKeys = function() {
  return this.link_parameters;
};

ZTObjects.imageObj.prototype.getValues = function() {
  return this.link_parameters_value;
};
