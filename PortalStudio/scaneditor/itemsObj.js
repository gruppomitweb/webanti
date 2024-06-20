/* exported
    itemsHTMLArray dragstartx dragstarty newx newy mainitem index infindex nitem
    itemsHTML imgHTML m_bUpdated imgcountindex fieldHTML fieldcountindex
  */

/* global newdesign ZoomOut ZoomIn initPropertiesDefaultValue clCanvasLib
*/

// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
var dragstartx, dragstarty, newx, newy, mainitem;
var index; // indice corrente del mainitem  nell'Array
var infindex;
var nitem = 0; // numero item crescente
var itemsHTMLArray = []; //array contenente tutti gli oggetti item con id, HTML, shadow, ecc
var itemsHTML = [];
var imgHTML = [];
var countindex = []; //contatore indice array
var imgcountindex = 0;
var m_bUpdated = false;
var docpageindex = 0;
itemsHTMLArray[docpageindex] = [];
countindex[docpageindex] = 0;
var fieldHTML = [];
var fieldcountindex = 0;
var version = "1.1";
/*
  18/03/2013: 1.0 - Versione B60.
  01/10/2014: 1.1 - Versione B61 - Def in formato JSON.
 */

if (typeof(ZTObjects) == 'undefined') {
  var ZTObjects = new function () {
    var fonts_select = "select[,Arial,Courier,MS Sans Serif,Tahoma,Times New Roman,Verdana]";
    var type_select = "select[character,numeric,date,logic,memo,dateTime]";
    var rotation_select = "select[0,90,180,270]";
    var align_select = "select[left,right,center]";
    var fonts_style = "select[,normal,bold,italic,bold italic]";
    var fonts_effect = "select[,strikeout,underline,strikeout underline]";
    var barcode_type = "select[,Barcode Auto,Barcode Code 39,Barcode Code 128,Barcode Data Matrix,Barcode QR code,Barcode ITF Code,Barcode EAN 13]";

    this.PSToolbarAlign = [
      { 'id': 'bottom_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('bottom'); }
        , 'image': '../portalstudio/images/icon/btn_alignbottom.png'
        , 'title': 'Align bottom'
      },{ 'id': 'top_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('top'); }
        , 'image': '../portalstudio/images/icon/btn_aligntop.png'
        , 'title': 'Align top'
      },{ 'id': 'left_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('left'); }
        , 'image': '../portalstudio/images/icon/btn_alignleft.png'
        , 'title': 'Align left'
      },{ 'id': 'right_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('right'); }
        , 'image': '../portalstudio/images/icon/btn_alignright.png'
        , 'title': 'Align right'
      },{ 'id': 'vcenter_align'
        , 'action': function() { alignItems('center'); }
        , 'image': '../portalstudio/images/icon/btn_aligncenter.png'
        , 'title': 'Align vertical center'
      },{ 'id': 'hcenter_align'
        , 'action': function() { alignItems('middle'); }
        , 'image': '../portalstudio/images/icon/btn_alignmiddle.png'
        , 'title': 'Align horizontal center'
      }
    ];
    
    this.PSToolbarResize = [
    { 'id': 'x_delta_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('x_delta'); }
        , 'image': '../portalstudio/images/icon/btn_x-delta.png'
        , 'title': 'Same horizontal distance'
      },{ 'id': 'y_delta_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('y_delta'); }
        , 'image': '../portalstudio/images/icon/btn_y-delta.png'
        , 'title': 'Same vertical distance'
      },{ 'id': 'resizexy_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('resizexy'); }
        , 'image': '../portalstudio/images/icon/btn_resize-xy.png'
        , 'title': 'Same size'
      },{ 'id': 'resizex_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('resizex'); }
        , 'image': '../portalstudio/images/icon/btn_resize-x.png'
        , 'title': 'Same width'
      },{ 'id': 'resizey_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('resizey'); }
        , 'image': '../portalstudio/images/icon/btn_resize-y.png'
        , 'title': 'Same height'
      }
    ];

    this.PSToolbarAction = [
      { 'id': 'new'
        , 'class_name': 'btn'
        , 'action': function(){ newdesign(); }
        , 'image': '../portalstudio/images/icon/btn_new.png'
        , 'title': 'New'
      },{ 'id': 'open'
        , 'class_name': 'btn'
        , 'action': function(){ openModule(); }
        , 'image': '../portalstudio/images/icon/btn_open.png'
        , 'title': 'Open'
         , 'withTitle': true
      },{ 'id': 'save'
        , 'class_name': 'btn'
        , 'action': function(){ save(); }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Save'
         , 'withTitle': true
      },{ 'id': 'saveas'
        , 'class_name': 'btn'
        , 'action': function(){ saveAs(); }
        , 'image': '../portalstudio/images/icon/btn_saveAs.png'
        , 'title': 'Save As'
      }
    ]

    /* Toolbar di edit per la modalita' light.
       Si visualizza solo il bottone 'Save'.
    */
    this.PSToolbarActionLight = this.PSToolbarAction.slice(2, 3);

    this.PSToolbarCtrl = [
      { 'id': 'addnewzone'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/btn_adddocpage.png'
        , 'title': 'Add Zone'
        , 'draggable': true
        , 'action': {'func':'addItem','par':'Zone'}
        , 'withTitle': true
      }
    ]

    /* Toolbar di edit per quando il disegnatore viene aperto in PortalStudio. */
    this.PSToolbarEdit = [
      { 'id': 'zoomoutdocpage'
        , 'class_name': 'btn'
        , 'action': function(){ ZoomOut(); }
        , 'image': '../portalstudio/images/icon/btn_zoomOut2.png'
        , 'title': 'Zoom Out'
      },{ 'id': 'selectZoom'
        , 'class_name': 'remMarginLeft'
        , 'action': function(){}
        , 'title': 'Select Zoom Percent'
        , 'innerHTML': ' <select name="zoombox" class="pdfTextbox" style="position:relative;top:0;padding:0px;border:1px solid #B6B6B6;" id="zoombox" onchange="zoomindex=this.selectedIndex;zoom(this.options[this.selectedIndex].value)">'
            +'<option value="50">50%</option>'
            +'<option value="75">75%</option>'
            +'<option value="100" selected>100%</option>'
            +'<option value="125">125%</option>'
            +'<option value="150">150%</option>'
            +'<option value="175">175%</option>'
            +'<option value="200">200%</option>'
            +'<option value="225">225%</option>'
            +'<option value="250">250%</option>'
            +'<option value="275">275%</option>'
            +'<option value="300">300%</option>'
            +'<option value="325">325%</option>'
            +'<option value="350">350%</option>'
            +'<option value="375">375%</option>'
            +'<option value="400">400%</option>'
          +'</select>'
      },{ 'id': 'zoomindocpage'
        , 'class_name': 'btn'
        , 'action': function(){ ZoomIn(); }
        , 'image': '../portalstudio/images/icon/btn_zoomIn2.png'
        , 'title': 'Zoom In'
      }
    ]

    /* Array contenente i bottoni da visualizzare solo quando lo Scan Editor e' aperto in modalita' stand alone. */
    var additionalToolbarEdit = [
      { 'id': 'cutBtn'
        , 'class_name': 'btn'
        , 'action': function(){ CopyPaste(true,true); }
        , 'image': '../portalstudio/images/icon/btn_cut.png'
        , 'title': 'Cut'
      },{ 'id': 'copyBtn'
        , 'class_name': 'btn'
        , 'action': function(){ CopyPaste(true,false); }
        , 'image': '../portalstudio/images/icon/btn_copy.png'
        , 'title': 'Copy'
      },{ 'id': 'pasteBtn'
        , 'class_name': 'btn'
        , 'action': function(){ CopyPaste(false); }
        , 'image': '../portalstudio/images/icon/btn_paste.png'
        , 'title': 'Paste'
      },{ 'id': 'undoBtn'
        , 'class_name': 'btn'
        , 'action': function(){ Undo(); }
        , 'image': '../portalstudio/images/icon/btn_undo.png'
        , 'title': 'Undo'
      }
    ]

    /* Toolbar di edit per la modalita' stand-alone del disegnatore.
       Si devono aggiungere i bottoni 'Cut', 'Copy', 'Paste', 'Undo'.
     */
    this.PSToolbarEditFull = this.PSToolbarEdit.concat(additionalToolbarEdit);

    this.PSToolbarPreview = [
      { 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function(){ Preview(); }
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Go to Preview'
        , 'withTitle': true
      }
    ]

    this.formObjClass={
      newProperties:{
        generic:[
          {name:'width',			propID:'width',			type:'int',			disabled:true,				tooltip:'Display the height of the Work zone'},
          {name:'height',			propID:'height',		type:'int',			disabled:true,			tooltip:'Display the height of the Work zone'},
          {name:'description',		propID:'description',	type:'str',			tooltip:'Description of the Module'},
          //{name:'file',				propID:'file',			type:'str',			disabled:true,			tooltip:'Pdf file from which loading the pages'}
          {name:'pdf file',				propID:'file',			type:'str',			 noteditable:true, buttons:'pick',			actions:'LoadPdf()',		tooltip:'Pdf scan file'}
        ],
        view:[
          {name:'Hide Snap Lines',		propID:'hsl',		type:'checkbox',			tooltip:'When this property is selected, show the Snap Lines', extraClass: "col-3"},
          {name:'Lock items',		propID:'lock_items',		type:'checkbox',		tooltip:'Lock the mouse move of the items', extraClass: "col-3"}
        ]
      }
    };

    this.imgObjClass={
      newProperties:{
        generic:[
          {name:'name',			propID:'name',			type:'str',			tooltip:'Unique identifier for the Image in the current module'},
          {name:'src',			propID:'src',			type:'str'},
          {name:'rotation',		propID:'rotation',		type:rotation_select,		defaultValue:'0'},
          {name:'height',			propID:'h',				type:'int',			disabled:true},
          {name:'width',			propID:'w',				type:'int',			disabled:true}
        ]
      }
    };

    this.fieldObjClass={
      newProperties:{
        generic:[
          {name:'name',		propID:'name',		type:'str',			tooltip:'Unique identifier for the Field in the current module'},
          {name:'x',			propID:'x',			type:'int',			tooltip:'X coordinate'},
          {name:'y',			propID:'y',			type:'int',			tooltip:'Y coordinate'},
          {name:'h',			propID:'h',			type:'int',			tooltip:'Height'},
          {name:'w',			propID:'w',			type:'int',			tooltip:'Width'}
        ]
      }
    };

    this.ZoneObjClass={
      helper : {
        description : 'Zone Object identifying zone in pdf to read'
      },
      newProperties:{
        generic:[
          //{name:'page',					propID:'page',			type:'int',			tooltip:'Page', disabled:true},
          {name:'name',					propID:'name',			type:'str',			tooltip:'Unique identifier for the DocField in the current module'},
          {name:'len',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10'},
          {name:'dec',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0'},
          {name:'picture',				propID:'picture',		type:'str',		disabled:true,		defaultValue:''},
          {name:'text align',			propID:'align',			type:align_select,	tooltip:'Text alignment of the DocField',		disabled:true,		defaultValue:'left'},
          {name:'font name',			propID:'font',		type:fonts_select,		tooltip:'Font applied when printing the current DocField',		disabled:true,		defaultValue:'Verdana'},
          {name:'font size',			propID:'size',		type:'str',		tooltip:'Font size applied when printing the current DocField',		disabled:true,		defaultValue:'10'},
          {name:'font style',			propID:'weight',		type:fonts_style,		tooltip:'Font style applied when printing the current DocField',		disabled:true,		defaultValue:'normal'},
          {name:'font effects',			propID:'effects',	type:fonts_effect,		tooltip:'Font effects applied when printing the current DocField',		disabled:true,		defaultValue:''},
          {name:'type',					propID:'type_exp',			type:type_select,		tooltip:'Specify how printing the field',		disabled:true,		defaultValue:'character'},
          {name:'barcode',				propID:'barcode',			type:barcode_type,		tooltip:'Specify barcode type to read<br>If empty, zone will be read as text',		defaultValue:''}
        ],
        layout:[
          {name:'x',					propID:'x',				type:'int',					tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',					propID:'y',				type:'int',					tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'height',				propID:'h',				type:'int',					tooltip:'Height',	extraClass:"col-3"},
          {name:'width',				propID:'w',				type:'int',					tooltip:'Width',	extraClass:"col-3"}
        ]
      }
    };


    this.formObj = function () {
      this.objClass = ZTObjects.formObjClass;
     //General
      this.height = 600;
      this.width = 600;

      //View
      this.hsl = false;
      this.lock_items = false;

     //Non visibili
      this.page = 0;
      this.version = version;
      this.type = "scandoc";
    }

    this.imgObj = function (id, name, type, html, value, shadow, pos, x, y, h, w, localsrc, src) {
      this.objClass = ZTObjects.imgObjClass;
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;

     //General
      this.name = name;
      this.src = src;
      this.rotation = "0";
      this.h = h;
      this.w = w;

     //Non visibili
      this.x = x;
      this.y = y;
      this.localsrc = localsrc;
      this.pos = pos;
    }

    this.fieldObj = function (id, name, type, html, value, shadow, x, y, h, w, group, fname, desc, detail) {
      this.objClass = ZTObjects.fieldObjClass;
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;

     //General
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;

     //Non visibili
      this.group = group;
      this.fname = fname;
      this.desc = desc;
      this.detail = detail;
    }

    this.ZoneObj = function (id, name, type, html, value, shadow, x, y, h, w) {
      this.objClass = ZTObjects.ZoneObjClass;
      initPropertiesDefaultValue(this);
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;

     //General
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;

     //Non visibili
      this.page = docpageindex;
      this.scale = clCanvasLib.scale;
      this.fieldindex = "";
    }

    //Oggetti per operazione UNDO
    this.undoObj = function (id, action, x, y, x_init, y_init, obj, w, h, w_init, h_init) {
      this.id = id;
      this.action = action;
      this.x_init = x_init;
      this.y_init = y_init;
      this.x = x;
      this.y = y;
      this.w_init = w_init;
      this.h_init = h_init;
      this.w = w;
      this.h = h;
      this.obj = obj;
      this.page = docpageindex;
      if (this.obj) {
        this.w = parseInt(this.obj.w);
        this.h = parseInt(this.obj.h);
        this.scale = parseInt(this.obj.scale);
      }
    }
  }
}
