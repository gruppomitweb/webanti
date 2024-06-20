ZTObjects.boxObjClass = {
  helper : {
    description : 'Simple Box to draw in the document'
  },
  newProperties:{
    generic:[
      {name:'background color type',					propID:'bg_coltype',				type:'select[constant,expression]'
        ,tooltip:'Select whether the specified background color is a constant or an expression',	defaultValue:'constant'
        ,hide_list:{
          'constant':['this.generic_bg_colexp'],
          'expression':['this.generic_bg_color']
        }
        ,show_list:{
          'constant':['this.generic_bg_color'],
          'expression':['this.generic_bg_colexp']
        }
        ,extraClass:"col-3"
      },
      {name:'background color',			propID:'bg_color',			type:'color',			tooltip:'Fill the box with the selected background color',	defaultValue:'transparent',	extraClass:"col-3"},
      {name:'background color',			propID:'bg_colexp',		type:'exp',				tooltip:'Fill the box with the selected background color as expression, format #hex',	defaultValue:'',	extraClass:"col-3"},
      {name:'border color type',					propID:'border_coltype',				type:'select[constant,expression]'
        ,tooltip:'Select whether the specified border color is a constant or an expression',	defaultValue:'constant'
        ,hide_list:{
          'constant':['this.generic_border_colexp'],
          'expression':['this.generic_border_color']
        }
        ,show_list:{
          'constant':['this.generic_border_color'],
          'expression':['this.generic_border_colexp']
        }
        ,extraClass:"col-3"
      },
      {name:'border color',			propID:'border_color',			type:'color',			tooltip:'Draw the border with the selected color',	defaultValue:'#000000',	extraClass:"col-3"},
      {name:'border color',			propID:'border_colexp',		type:'exp',				tooltip:'Draw the border with the selected color as expression, format #hex',	defaultValue:'',	extraClass:"col-3"},
      {name:'border width',			propID:'border_width',		type:'int',			tooltip:'Draw the border with the selected width'},
      {name:'print as background',			propID:'printasbg',		type:'checkbox',			tooltip:'Print as background',		defaultValue:false,	extraClass:"col-3"},
      {name:'stretch to right',		propID:'stretch_to_right',	type:'checkbox',			tooltip:'Stretch the box to the right page border',		defaultValue:false,	extraClass:"col-3"},
      {name:'align to right',			propID:'align_to_right',	type:'checkbox',		disabled:true,	tooltip:'Align the to the right page border',		defaultValue:false}
    ],
    layout:[],
    print_options:[
      {name:'print only on',	propID:'printonlyon',			type:'select[,Only First,Only Last,First and Last,Only Next,First Page of Last Sheet]',			defaultValue:'', section:"Optical recognition markup", tooltip:'Select box drawing mode as optical recognition markup'}
    ]
  }
};

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.boxObjClass );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.boxObjClass );

ZTObjects.boxObj = function(id, name, type, value, shadow, x, y, h, w, bg_color, border_width) {
  this.objClass = ZTObjects.boxObjClass;
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
  this.border_width = border_width;
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

  //Non visibili
  this.zindex = 0;
  this.show = true;
  this.scale = 100;

  this.html = "<div id=\'" + this.id + "\' style=\'z-index:1;border:" + this.border_width + "px solid #000000;margin:0;position:absolute;top:" + this.ypos + "px;left:" + this.xpos + "px;width:" + this.w + "px;height:" + this.h + "px;background-color:" + this.bg_color + ";\' onselectstart=\'noDefaultDrag(event)\' onclick=\'clickItem(event)\' onmousedown=\'putItem2(event)\'><img src=\"../visualweb/images/trasparent.gif\" width=\"100%\" height=\"100%\"/></div>";
};

ZTObjects.boxObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.boxObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.boxObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
};
