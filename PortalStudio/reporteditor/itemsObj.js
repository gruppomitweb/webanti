/* exported dragstartx dragstarty newx newy mainitem index nitem nbaritem printgroupuid
  calconuid resetonuid into_variable_combo fieldHTML fieldcountindex getBarHtml
  getNavigatorDescBand getDescBand2 writeStandardDef readStandardDef readStandardJsonDef
  normalizeXML getPropID getObjImg getPropDescObj overBar outBar
  newObj
*/
/* global wizard newdesign openReport ZoomOut ZoomIn Redo generateXLSXModel toolbarPreview
  getIconDataFromAction trimNameDesc setPropertiesID scale translateCharacters reportProp
  getGroupUid 
*/

//Tutti gli elementi sono item+n e le ombre sono shadow+n 
//#######################################################
var dragstartx, dragstarty, newx, newy, mainitem;

var index; //indice corrente del mainitem nell'Array 
var nitem = 0; //numero item crescente
var nbaritem = 0; //numero del item tipo bar crescente
var itemsHTML = []; //array contenente tutti gli oggetti item con id,HTML,shadow,ecc
var countindex = 0; //contatore indice array
var offsetimage = 6;

var printgroupuid = "select[]";
var calconuid = "select[each record,end of report]";
var resetonuid = "select[end of report,end of page]";
var into_variable_combo = "select[]";

var fieldHTML = [];
var fieldcountindex = 0;

var newObj = {};

//Proprieta' oggetti ###########################
if (typeof(ZTObjects) == "undefined") {
  var ZTObjects = new function () {
    this.fonts_select = "select[Arial,Courier,Tahoma,Times New Roman,Verdana";
    this.encoding_select = "select[,UTF-8,UTF-16,ISO-8859-1,ISO-8859-2,ISO-8859-3,ISO-8859-4,ISO-8859-5,ISO-8859-6,ISO-8859-7,ISO-8859-8,ISO-8859-9,ISO-8859-10,ISO-8859-13,ISO-8859-14,ISO-8859-15,ISO-8859-16]";
    this.linktype_select = "select[,master,detail,master/detail,dialog,report,routine,page,event,system_function,user_program,web_hyperlink]";
    this.linkaction_select = "select[,start,query,edit,editload,new,delete,write,writeload,view]";
    this.linktarget_combo = "select[same window,new window]";

    this.format_select = "select[A4,A3,letter:LETTER,legal:LEGAL,custom:CUSTOM]";
    this.rotation_select = "select[,portrait:PORTRAIT,landscape:LANDSCAPE]";
    this.reexecute_select = "select[Execute Query at start (merge-join):false,Execute Query each time (sub-report):true]";

    this.applyGlobalFont = "select[use global font:true,use custom font:false]";
    this.requiredOrNot = "select[required:true,not required:false]";

    this.privacy_select = "select[Not defined:0,Ruled - Health:1,Ruled - Sensible:2,Ruled - Judicial:3,Ruled - Personal:4,Ruled - Specific Risk:7,Private:5,Public:6,Profiled:8,Secret:9]";
    this.data_danger_level_select = "select[0 - No risk:0,1 - Low risk:1,2 - Medium risk:2,3 - High risk:3]";

    var msg = new JSURL("../servlet/RPFontsList", true).Response();
    var fonts_add='';
    if (msg.length > 0) {
      var otherfontL = msg.split(",");
      for (var mm = 0; mm < otherfontL.length; mm++) {
        if(otherfontL[mm].indexOf('fonts/DejaVu') < 0) {
          fonts_add += "," + otherfontL[mm].replace(/;/gi, ',');
        }
      }
    }
    if (fonts_add.length > 0) {
      fonts_add = ',separator-Fonts File' + ',fonts/DejaVuSans-ExtraLight.ttf' + fonts_add
    }
    this.fonts_select += fonts_add + "]";
    this.bool_select = "select[false,true]";
    this.type_select = "select[character,numeric,date,logic,memo,datetime]";

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
      if (this.obj) {
        if (!this.w) { this.w = parseInt(this.obj.w); }
        if (!this.h) { this.h = parseInt(this.obj.h); }
        this.scale = parseInt(this.obj.scale);
      }
    };

    ////////
    this.findProp= function (propID, container) {
      for( var j=0; j< container.length; j++){
        if( container[j].propID == propID ){
          return j;
          break;
        }
      }
      return -1;
    }

    this.extend = function( objA, objB, pos) { //itemsObj visualweb
      // La posizione della properties e' definita dall'oggetto esteso
      var propsA = objA['newProperties'], propsB = objB['newProperties'];
      var tmpProps = null;
      var iB, k = 0;
      for (var prop in propsA ) {
        for (var i = 0; i< propsA[prop].length; i++ ) {
          if (typeof(propsB[prop]) == 'undefined' ) {
            propsB[prop] = JSON.parse(JSON.stringify(propsA[prop]));
            break;
          }
          iB = this.findProp(propsA[prop][i].propID, propsB[prop]);
          if ( iB == -1 ) {
            tmpProps = JSON.parse(JSON.stringify(propsA[prop]));
            if (pos == true) {
              for (k = 0; k < tmpProps.length; k++) {
                propsB[prop] = propsB[prop].concat(tmpProps[k]);
              }
            }
            else {
              for (k = 0; k < tmpProps.length; k++) {
                propsB[prop].splice(i+k, 0, tmpProps[k]);
              }
            }
          }
        }
      }
    }

    this.stdObjClass = {
      newProperties:{
        generic:[
          {name:'comment',			propID:'comment',			type:'str',			tooltip:'Object comment',		defaultValue:'', buttons:'plus', actions:'addCommentLabel()'},
          {name:'name',			disabled:true, noteditable:true,			propID:'name',			type:'str',			tooltip:'Unique identifier for the Object in the current report'},
          {name:'uid',			propID:'uid',			type:'str',			disabled:true},
          {name:'page',			propID:'page',			type:'int',			disabled:true}
        ],
        layout:[
          {name:'x',						propID:'x',				type:'int',			validFunc:'validCoordinate',					convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',						propID:'y',				type:'int',			validFunc:'validCoordinate',					convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'width',					propID:'w',				type:'int',			validFunc:'validCoordinate',					convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Width',	extraClass:"col-3"},
          {name:'height',					propID:'h',				type:'int',			validFunc:'validCoordinate',					convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Height',	extraClass:"col-3"}
        ]
      }
    };

    this.stdObjOptPrintClass = {
      newProperties:{
        print_options:[
          {name:'hide under condition',			propID:'hidecond',					type:'exp',			tooltip:'Object is hidden when this formula is TRUE',	defaultValue:''},
          {name:'Row print order',			propID:'sequence',	type:'int',			tooltip:'Specify the order in which printing the elements with the same Y coordinate'}
        ]
      }
    }

    this.stdObjOptBarPrintClass = {
      newProperties:{
        print_options:[
          {name:'hide under condition',			propID:'hidecond',			validFunc:'validBarProperty',					type:'exp',			tooltip:'Object is hidden when this formula is TRUE',	defaultValue:''}
        ]
      }
    }

    this.stdObjLayoutBarClass = {
      newProperties:{
        layout:[
          {name:'x',			disabled:true,						propID:'x',				type:'int',			convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'X coordinate'},
          {name:'y',			noteditable:true,						propID:'y',				type:'int',			convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Y coordinate'},
          {name:'width',			disabled:true,					propID:'w',				type:'int',		convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Width'},
          {name:'height',			disabled:true,					propID:'h',				type:'int',		convertFunc:'convertFromPixels',	reconvertFunc:'convertToPixels',			tooltip:'Height'},
          {name:'Row print order',			disabled:true,			propID:'sequence',	type:'int',			tooltip:'Specify the order in which printing the elements with the same Y coordinate'}
        ]
      }
    };

    this.stdObjPrivacyClass = {
      newProperties:{
        generic:[
          {name:'Privacy GDPR',		section:'privacy', propID:'privacy',		validFunc:'validPrivacy', type:this.privacy_select,		tooltip:'Data subject to privacy regulation',	defaultValue:'0'},
          {name:'Data Danger Level',		section:'privacy', propID:'data_danger_level',		validFunc:'validDataDangerLevel', type:this.data_danger_level_select,		tooltip:'Specify the danger level of the data for privacy',	defaultValue:'0'},
          {name:'Data subject identifier',		section:'privacy', propID:'identifier',		validFunc:'validIdentifier', type:'checkbox',		tooltip:'The field represents a data who can identify, directly or indirectly, the subject',	defaultValue:false}
        ]
      }
    };

    this.stdObjOutNameClass = {
      newProperties:{
        generic:[
          {name:'output name',		section:'output', propID:'output_name',		type:'str',		validFunc:'validXMLName',			tooltip:'Name in output file (XML, CSV, ...)',	defaultValue:''}
        ]
      }
    };

    this.stdObjOutBarNameClass = {
      newProperties:{
        generic:[
          {name:'output name',		section:'output', propID:'output_name',		type:'str',		validFunc:'validBarProperty',			tooltip:'Name in output file (XML, CSV, ...)',	defaultValue:''}
        ]
      }
    };

    this.stdObjBlockClass = {
      newProperties:{
        generic:[
          {name:'print as block',			propID:'printblock',			validFunc:'validBarProperty',			type:'checkbox',			tooltip:'Print as block',			defaultValue:false}
        ]
      }
    };

    this.stdObjOutCsvClass = {
      newProperties:{
        generic:[
          {name:'csv title',		section:'output', propID:'column_title',		type:'exp',			tooltip:'Expression title in output file CSV',	defaultValue:''}
        ]
      }
    }

    this.stdObjOutHyperLinkClass = {
      newProperties:{
        hyperlink:[
          {name:'entity type',				propID:'link_type',				type:this.linktype_select,	tooltip:'Type of called entity',	defaultValue:''},
          {name:'name type',					propID:'link_expr',				type:'select[constant,expression]'
            ,tooltip:'Select whether the specified string is a constant or an expression',	defaultValue:'constant',	extraClass:"col-3"},
          {name:'name',						propID:'link_name',				type:'str',			tooltip:'Name of called entity',	defaultValue:'',	extraClass:"col-3"},
          {name:'action',						propID:'link_action',			type:this.linkaction_select,			tooltip:'Action to perform on called entity',	defaultValue:''},
          {name:'parameters',					propID:'link_parameters',		type:'str',			tooltip:'Parameters for the called entity',	buttons:'edit',	actions:'LoadHY()',	extraClass:"col-3"},
          {name:'value',			propID:'link_parameters_value',	type:'str',			tooltip:'Values of parameters for the called entity',	buttons:'edit',	actions:'LoadHY()',	defaultValue:'',	extraClass:"col-3"},
          {name:'target',						propID:'link_target_src',		type:this.linktarget_combo
            ,tooltip:'Select where the called entity will be opened',	defaultValue:'same window'
            ,hide_list:{
              'same window':[
                'this.hyperlink_link_target',
                'this.hyperlink_link_w',
                'this.hyperlink_link_h'
              ],
              'new window':['this.hyperlink_link_target'],
              'frame':[
                'this.hyperlink_link_w',
                'this.hyperlink_link_h'
              ]
            }
            ,show_list:{
              'same window':[],
              'new window':[
                'this.hyperlink_link_w',
                'this.hyperlink_link_h'
              ],
              'frame':['this.hyperlink_link_target']
            }
          },
          {name:'frame',						propID:'link_target',			type:'str',			tooltip:'Name of the frame where the called entity will be opened',	defaultValue:''},
          {name:'window width',				propID:'link_w',				type:'str',			tooltip:'Width of the new browser window',	defaultValue:'0',	extraClass:"col-3"},
          {name:'window height',				propID:'link_h',				type:'str',			tooltip:'Height of the new browser window',	defaultValue:'0',	extraClass:"col-3"},
          {name:'exit at end',				propID:'exit_at_end',		disabled:true,			type:'checkbox',		tooltip:'On completion close the newly opened window',	defaultValue:false},
          {name:'enable under condition',		propID:'link_enable_cond',		type:'exp',			tooltip:'Hyperlink is enabled when this formula is TRUE',	defaultValue:''}
        ]
      }
    }

    this.stdObjNoteClass = {
      newProperties:{
        notes:[
          {name:'user notes',				propID:'note',				type:'str',			tooltip:'User notes',			defaultValue:'',	buttons:'edit',	actions:'EditEUNotes()'},
          {name:'technical notes',		propID:'technote',			type:'str',			tooltip:'Technical Notes',		defaultValue:'',	buttons:'edit',	actions:'EditETNotes()'}
        ]
      }
    };

    this.stdObjExtPrintClass = {
      newProperties:{
        print_options:[
          {name:'print always',					propID:'print_always',				type:'checkbox'
          ,tooltip:'Always prints the repeated values',		defaultValue:true
          ,hide_list:{
            'checked':[
              'this.print_options_print_in_newpage',
              'this.print_options_print_when_change_groupuid',
              'this.print_options_print_rowgroup'
            ],
            'unchecked':[]
          }
          ,show_list:{
            'checked':[],
            'unchecked':[
              'this.print_options_print_in_newpage',
              'this.print_options_print_when_change_groupuid',
              'this.print_options_print_rowgroup'
            ]
          }
          ,section:"printing"
          },
          {name:'print in new page',				propID:'print_in_newpage',			type:'checkbox'
            ,tooltip:'Prints the field in the first band of a new page that is not an overflow from a previous page',		defaultValue:false, section:"printing"},
          {name:'print group',				propID:'print_group',			type:'checkbox',	disabled:true,	defaultValue:false, section:"printing"},
          {name:'print when this group',	propID:'print_when_change_group',	type:'str',	disabled:true,	defaultValue:'', section:"printing"},
          {name:'print when group changes',	propID:'print_when_change_groupuid',	type:'function:getgroupuid',	convertFunc:'TranslateGroupUid',	validFunc:'ApplyGroupUidG'
            ,tooltip:'When selected group changes, the field is printed',		defaultValue:'', section:"printing", extraClass:"col-3"},
          {name:'print when previous fields on row change',				propID:'print_rowgroup',			type:'checkbox',	defaultValue:false, section:"printing"
          ,tooltip:'When at least one of previous fields in the row changes, the field is printed', extraClass:"col-3"}

        ]
      }
    };

    this.stdObjExtPrintRemOutClass = {
      newProperties:{
        print_options:[
        {name:'remove from output',			propID:'removefromout',			type:'str',		tooltip:'Select the output type in which the expression will not be printed'
          ,buttons:'edit',	actions:'LoadRemoveOutput()',		defaultValue:'', section:"printing"}
        ]
      }
    }

    this.stdObjStyleBarcodeClass = {
      newProperties:{
        style:[
          {name:'Pixel Off color',			propID:'pixeloffcolor',			type:'color',	tooltip:'Color selected for Pixel OFF',	defaultValue:'#ffffff'},
          {name:'Pixel On color',			propID:'pixeloncolor',			type:'color',	tooltip:'Color selected for Pixel ON',	defaultValue:'#000000'},
          {name:'scale to frame size',			propID:'barcodestretch',			type:'checkbox',	tooltip:'Indicating whether a barcode resizes to fit the size of the barcode frame',	defaultValue:true}
        ]
      }
    }

    this.stdObjStyleFontClass = {
      newProperties:{
        style:[
          {name:'align',			propID:'align',			type:'select[left,center,right]',			tooltip:'Alignment',			defaultValue:'left'},
          {name:'font',			propID:'global_font',			type:this.applyGlobalFont
            ,tooltip:'When this property is selected, the Expression will be printed using the Global Font',			defaultValue:true
            ,hide_list:{
              'true':[
                'this.style_font',
                'this.style_font_size',
                'this.style_font_weight',
                'this.style_font_effect'
              ],
              'false':[]
            }
            ,show_list:{
              'true':[],
              'false':[
                'this.style_font',
                'this.style_font_size',
                'this.style_font_weight',
                'this.style_font_effect'
              ]
            }
          },
          {name:'font name',			propID:'font',			type:'advanced-font',			tooltip:'Current font',	fontList:this.fonts_select},
          {name:'font size',			propID:'font_size',			type:'str',			tooltip:'Current font size'},
          {name:'font style',			propID:'font_weight',			type:'select[,normal,bold,italic,bold italic]',			tooltip:'Current font style',	extraClass:"col-3"},
          {name:'font effects',			propID:'font_effect',			type:'select[,strikeout,underline,strikeout underline]',			tooltip:'Current font effects',			defaultValue:'',	extraClass:"col-3"},
          {name:'font color type',					propID:'coltype',				type:'select[constant,expression]'
            ,tooltip:'Select whether the specified foreground color is a constant or an expression',	defaultValue:'constant'
            ,hide_list:{
              'constant':['this.style_colexp'],
              'expression':['this.style_color']
            }
            ,show_list:{
              'constant':['this.style_color'],
              'expression':['this.style_colexp']
            }
            ,extraClass:"col-3"
          },
          {name:'font color',			propID:'color',			type:'color',			tooltip:'Color selected for foreground',	defaultValue:'#000000',	extraClass:"col-3"},
          {name:'font color',			propID:'colexp',		type:'exp',				tooltip:'Color selected for foreground as expression, format #hex',	defaultValue:'',	extraClass:"col-3"}
        ]
      }
    }

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

    this.PSToolbarWizard = [
      { 'id': 'wiz'
        , 'class_name': 'btn'
        , 'action': function(){ wizard(); }
        , 'image': '../portalstudio/images/icon/btn_wizard.png'
        , 'title': 'Wizard'
        , 'withTitle': true
      }
    ];

    /* Array contenente i bottoni da visualizzare solo quando il Report Editor e' aperto in modalita' stand alone.*/
    this.PSToolbarActionFull = [
      { 'id': 'new'
        , 'class_name': 'btn'
        , 'action': function(){ newdesign(); }
        , 'image': '../portalstudio/images/icon/btn_new.png'
        , 'title': 'New'
      },{ 'id': 'open'
        , 'class_name': 'btn'
        , 'action': function(){ openReport(); }
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
        , 'action': function(){ saveAs('true'); }
        , 'image': '../portalstudio/images/icon/btn_saveAs.png'
        , 'title': 'Save As'
      }
    ];

    this.PSToolbarActionLight = this.PSToolbarActionFull.slice(2,3);

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
        , 'innerHTML': '<select name="zoombox" class="pdfTextbox" style="position:relative;top:0;padding:0px;border:1px solid #B6B6B6;" id="zoombox" onchange="zoomindex=this.selectedIndex;zoom(this.options[this.selectedIndex].value)">'
         + '<option value="50">50%</option>'
         + '<option value="75">75%</option>'
         + '<option value="100" selected>100%</option>'
         + '<option value="125">125%</option>'
         + '<option value="150">150%</option>'
         + '<option value="175">175%</option>'
         + '<option value="200">200%</option>'
         + '<option value="225">225%</option>'
         + '<option value="250">250%</option>'
         + '<option value="275">275%</option>'
         + '<option value="300">300%</option>'
         + '<option value="325">325%</option>'
         + '<option value="350">350%</option>'
         + '<option value="375">375%</option>'
         + '<option value="400">400%</option>'
         + '</select>'
      },{ 'id': 'zoomindocpage'
        , 'class_name': 'btn'
        , 'action': function(){ ZoomIn(); }
        , 'image': '../portalstudio/images/icon/btn_zoomIn2.png'
        , 'title': 'Zoom In'
      }
    ];

    /* Array contenente i bottoni da visualizzare solo quando il Report Editor e' aperto in modalita' stand alone.*/
    this.PSToolbarEditFull = [
      { 'id': 'copyBtn'
        , 'class_name': 'btn'
        , 'action': function(){ CopyPaste(true,false); }
        , 'image': '../portalstudio/images/icon/btn_copy.png'
        , 'title': 'Copy'
      },{ 'id': 'cutBtn'
        , 'class_name': 'btn'
        , 'action': function(){ CopyPaste(true,true); }
        , 'image': '../portalstudio/images/icon/btn_cut.png'
        , 'title': 'Cut'
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
      },{ 'id': 'redoBtn'
        , 'class_name': 'btn'
        , 'action': function(){ Redo(); }
        , 'image': '../portalstudio/images/icon/btn_redo.png'
        , 'title': 'Redo'
      }
    ];

    this.PSToolbarPreview = [
      { 'id': 'btn_model'
        , 'class_name': 'btn'
        , 'action': function(){ generateXLSXModel(); }
        , 'image': '../portalstudio/images/icon/btn_xlsx.png'
        , 'title': 'Generate XLSX model'
        , 'withTitle': true
      },
      { 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function(){ toolbarPreview(); }
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Go to Preview'
        , 'withTitle': true
      }
    ];

    this.PSToolbarCtrl = [
      { 'id': 'label_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_label_off.png'
        , 'title': 'Label'
        , 'action':{'func':'addItem','par':'Label'}
        , 'draggable': true
      },{ 'id': 'expr_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_Expression_off.png'
        , 'title': 'Expression'
        , 'action':{'func':'addItem','par':'Expr'}
        , 'draggable': true
      },{ 'id': 'box_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_boxarea_off.png'
        , 'title': 'Box'
        , 'action':{'func':'addItem','par':'Box'}
        , 'draggable': true
      },{ 'id': 'hline_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_horizontalline_off.png'
        , 'title': 'Horizontal line'
        , 'action':{'func':'addItem','par':'HLine'}
        , 'draggable': true
      },{ 'id': 'vline_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_verticalline_off.png'
        , 'title': 'Vertical line'
        , 'action':{'func':'addItem','par':'VLine'}
        , 'draggable': true
      },{ 'id': 'image_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_image_off.png'
        , 'title': 'Image'
        , 'action':{'func':'addItem','par':'Image'}
        , 'draggable': true
      }
    ];

    this.PSToolbarCtrlOthers = [
      { 'id': 'barcode_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode_off.png'
        , 'title': 'Barcode'
        , 'action':{'func':'addItem','par':'Barcode'}
        , 'draggable': true
      },{ 'id': 'barcode2d_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode2d_off.png'
        , 'title': 'Barcode 2D'
        , 'action':{'func':'addItem','par':'Barcode2D'}
        , 'draggable': true
      },{ 'id': 'chart_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_graphics_off.png'
        , 'title': 'Chart'
        , 'action':{'func':'addItem','par':'Chart'}
        , 'draggable': true
      },{ 'id': 'ssvg_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_signsvg.png'
        , 'title': 'Tiny SVG'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'SignSVG'}
      },{ 'id': 'tinyhtml_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_tinyhtml.png'
        , 'title': 'Tiny HTML'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'TinyHTML'}
      },{ 'id': 'smup_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_signmup.png'
        , 'title': 'Signature Markup'
        , 'action':{'func':'addItem','par':'SignMark'}
        , 'draggable': true
      }
    ];

    this.PSToolbarCtrlSections = [
      { 'id': 'autocover_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_autocover_off.png'
        , 'title': 'Parameters Mask'
        , 'action':{'func':'addItem','par':'AutoCover'}
        , 'draggable': true
      },
      { 'id': 'group_top_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_group_off.png'
        , 'title': 'Group'
        , 'action':{'func':'addItem','par':'Group_top'}
        , 'draggable': true
      },{ 'id': 'section_top_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_section_off.png'
        , 'title': 'Hide Section'
        , 'action':{'func':'addItem','par':'Section_top'}
        , 'draggable': true
      },{ 'id': 'query_top_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_altquery_off.png'
        , 'title': 'Alternative Query'
        , 'action':{'func':'addItem','par':'AltQuery_top'}
        , 'draggable': true
      },{ 'id': 'breakpage_top_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_pagebreak_off.png'
        , 'title': 'Break Page'
        , 'action':{'func':'addItem','par':'BreakPage'}
        , 'draggable': true
      },{ 'id': 'htmlsection_top_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_htmlsection_off.png'
        , 'title': 'Html Section'
        , 'action':{'func':'addItem','par':'HtmlSection'}
        , 'draggable': true
      },{ 'id': 'sectbo_top_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_sect_bo_off.png'
        , 'title': 'Business Object'
        , 'action':{'func':'addItem','par':'SectBo_top'}
        , 'draggable': true
      }
    ];

    this.PSToolbarPredefined = [
      { 'id': 'npag_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/page_num.png'
        , 'title': 'Page number'
        , 'action':{'func':'putSystemVar','par':'nNumPageStr'}
        , 'draggable': true
      },{ 'id': 'tpag_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/total_pages.png'
        , 'title': 'Total Page number'
        , 'action':{'func':'putSystemVar','par':'nTotalPagesStr'}
        , 'draggable': true
      }
    ];

    this.Createsearch = function(tab, propID){
      var propBtnInfo = new Element('div', {'class':'input_inline_btn search_btn', 'icon-data' : getIconDataFromAction('search')});
      propBtnInfo.refId = tab + "_" + propID;
      propBtnInfo.refPropId = propID;
      return propBtnInfo;
    };

    this.Titlesearch = function(){
      return "Find";
    };

    this.Createsubstitute = function(tab, propID){
      var propBtnInfo = new Element('div', {'class':'input_inline_btn substitute_btn', 'icon-data' : getIconDataFromAction('substitute')});
      propBtnInfo.refId = tab + "_" + propID;
      propBtnInfo.refPropId = propID;
      return propBtnInfo;
    };

    this.Titlesubstitute = function(){
      return "Substitute";
    };
  }
}

ZTObjects.searchObjClass={
  newProperties:{
    search:[
      {name:'Find',									propID:'sfind',				type:'str',				buttons:'search',			actions:'KeyFind()'},
      {name:'whole word',						propID:'cwword',			type:'checkbox',	extraClass:"col-3"},
      {name:'Case sensitive',				propID:'ccsensitive',	type:'checkbox',	extraClass:"col-3"},
      {name:'As constant',					propID:'cconstant',		type:'checkbox',	extraClass:"col-3"},
      {name:'As expresssion',				propID:'cexpression',	type:'checkbox',	extraClass:"col-3"},
    ],
    results:[
      {name:'Finding',											propID:'sfind',				type:'str',				noteditable:true},
      {name:'Substitute with',							propID:'ssubstitute',	type:'str',				buttons:'substitute',	actions:'KeyReplace()'},
      {name:'Hightlight',						propID:'chighlight',	type:'checkbox',	validFunc:'hightlightElementsO',	extraClass:"col-3"},
      {name:'Select all',	propID:'csubsistute',	type:'checkbox',	validFunc:'ReplaceAllElementsO',	extraClass:"col-3"}
    ]
  }
};

ZTObjects.fieldsObjClass={
  newProperties:{
    queries:[
      {name:'',				propID:'qr',			type:'str'}
    ],
    business_objects:[
      {name:'',				propID:'bo',			type:'str'}
    ],
    variables:[
      {name:'',				propID:'va',			type:'str'}
    ]
  }
};

ZTObjects.searchObj = function() {
  this.objClass = ZTObjects.searchObjClass;
  this.cconstant = true;
  this.cexpression = false;
  this.cwword = false;
  this.ccsensitive = false;
  this.chighlight = false;
  this.csubsistute = false;
  this.ssubstitute = '';
};

ZTObjects.fieldsObj = function() {
  this.objClass = ZTObjects.fieldsObjClass;
  this.qr = '';
  this.bo = '';
  this.va = '';
};

function overBar(obj) {
  if (!obj.hasClass("selected_bar")) {
    obj.addClass("hover_bar");//obj.style.borderWidth = "2px";
  }
}

function outBar(obj) {
  obj.removeClass("hover_bar");
}

function getBarHtml(obj) {
  var tooltip = "", result = "", expr = "";
  var barPos, barInfoPos, barInfoPoss, barInfoWidth;
  expr = getDescBand(obj, 25, true);
  expr = Strtran(expr, " ", "&nbsp;");

  barPos = parseInt(obj.y);
  barInfoPos = barPos + 3;
  barInfoPoss = barPos - 17;

  var l = Math.max(Ctrl("v_line2").offsetLeft, Ctrl("z_line").offsetLeft);
  barInfoWidth = (l + 150) + "px";

  tooltip = "Click to move bar " + Strtran(obj.name, "'", "\'");
  switch (obj.type) {
    case "HeaderBar_top":
      result = "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";border:0px solid;position:absolute;top:" + barInfoPoss + "px'>" + expr + "</div>";
      result += '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)" ></div>';
      tooltip = "Click to move bar " + Strtran(obj.title, "'", "\'");
      break;
    case "HeaderBar_bottom":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      tooltip = "Click to move bar " + Strtran(obj.title, "'", "\'");
      break;
    case "ReportBar_top":
      result = "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPoss + "px'>" + expr + "</div>";
      result += '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      tooltip = "Click to move bar " + Strtran(obj.title, "'", "\'");
      break;
    case "ReportBar_bottom":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      tooltip = "Click to move bar " + Strtran(obj.title, "'", "\'");
      break;
    case "Group_top":
      result = "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPoss + "px'>" + expr + "</div>";
      result += '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      break;
    case "Group_down":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      break;
    case "Section_top":
    case "AltQuery_top":
    case "SectBo_top":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      break;
    case "Section_down":
    case "AltQuery_down":
    case "SectBo_down":
      result = "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPoss + "px;display:none'></div>";
      result += '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      break;
    case "BreakPage":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      break;
    case "HtmlSection":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      break;
    case "AutoCover":
      result = '<div id="' + obj.id + '" class="unselected_bar" style="z-index:1;border-color:' + obj.bcolor + ';position:absolute;top:' + barPos + 'px;width:' + barInfoWidth + ';height:1px;z-index:100;cursor:n-resize;overflow:hidden" onmousedown="dragBar(event,this)" onmouseover="overBar(this)" onmouseout="outBar(this)"></div>';
      result += "<div id='info_" + obj.id + "' class='text_shadow_bar' style='z-index:1;width:" + barInfoWidth + ";position:absolute;top:" + barInfoPos + "px'>" + expr + "</div>";
      break;
  }

  if (result.length > 0) {
    result += '<div id="c1_' + obj.id + '" class="circle" title="' + tooltip + '" style="z-index:1;background:' + obj.bcolor + ';cursor:n-resize;position:absolute;top:' + (barPos - offsetimage) + 'px;left:' + -5 + 'px" onmousedown="dragBar(event,' + '\'' + obj.id + '\'' + ')"></div>';
    result += '<div id="c2_' + obj.id + '" class="circle" title="' + tooltip + '" style="z-index:1;background:' + obj.bcolor + ';cursor:n-resize;position:absolute;top:' + (barPos - offsetimage) + 'px;left:' + barInfoWidth + '" onmousedown="dragBar(event,' + '\'' + obj.id + '\'' + ')"></div>';
  }
  return result;
}

function getNavigatorDescBand(obj) {
  var description = "";
  if (typeof(obj.comment) != "undefined" && LRTrim(obj.comment) != "") {
    description = obj.comment;
  }
  else {
    if (obj.type.indexOf("Section") > -1) {
      description = obj.name;
    }
    else if (obj.type.indexOf("Group") > -1) {
      if (LRTrim(obj.output_name) != "") {
        description = obj.output_name;
      }
      else if (obj.child > 0 && LRTrim(itemsHTML[obj.child].output_name) != "") {
        description = itemsHTML[obj.child].output_name;
      }
      else {
        description = obj.name;
      }
    }
    else if (obj.type.indexOf("AltQuery") > -1) {
      if (LRTrim(obj.output_name) != "") {
        description = obj.output_name;
      }
      else {
        description = obj.name + " [" + obj.query + "]";
      }
    }
    else if (obj.type.indexOf("SectBo") > -1) {
      if (LRTrim(obj.output_name) != "") {
        description = obj.output_name;
      }
      else {
        description = obj.name + " [" + obj.busobj + "]";
      }
    }
    else if (obj.type.indexOf("HeaderBar") > -1) {
      description = obj.title;
    }
    else if (obj.type.indexOf("ReportBar") > -1) {
      description = obj.title;
    }
    else if (obj.type.indexOf("BreakPage") > -1) {
      description = obj.name;
    }
    else if (obj.type.indexOf("HtmlSection") > -1) {
      description = obj.name;
    }
    else if (obj.type.indexOf("AutoCover") > -1) {
      description = obj.name;
    }
    else {
      description = obj.title + " - " + obj.name;
    }
  }

  description = Strtran(description, "'", "\'");
  return description;
}

function getDescBand2(obj) {
  return getDescBand(obj, 0, true);
}

function getDescBand(obj, maxlen, add) {
  var description = "";
  if (obj.type.indexOf("Section") > -1) {
    if (typeof(obj.comment) != "undefined" && LRTrim(obj.comment) != "") {
      description = trimNameDesc(obj.comment, maxlen);
    }
    else {
      description = trimNameDesc(obj.name, maxlen);
    }
  }
  else if (obj.type.indexOf("Group") > -1) {
    if (typeof(obj.comment) != "undefined" && LRTrim(obj.comment) != "") {
      description = obj.comment;
    }
    else {
      if (LRTrim(obj.output_name) != "") {
        description = obj.output_name;
      }
      else if (obj.child > 0 && LRTrim(itemsHTML[obj.child].output_name) != "") {
        description = itemsHTML[obj.child].output_name;
      }
      else {
        description = obj.name;
      }
    }
    description = trimNameDesc(description, maxlen);
    if (add && add == true) {
      if (obj.type.indexOf("top") > 0){
        description += " - Header";
      }
      else {
        description += " - Footer";
      }
    }
  }
  else if (obj.type.indexOf("AltQuery") > -1) {
    if (typeof(obj.comment) != "undefined" && LRTrim(obj.comment) != "")
      description = trimNameDesc(obj.comment, maxlen);
    else {
      if (LRTrim(obj.output_name) != "") {
        description = trimNameDesc(obj.output_name, maxlen);
      }
      else {
        description = trimNameDesc(obj.name, maxlen) + " [" + obj.query + "]";
      }
    }
  }
  else if (obj.type.indexOf("SectBo") > -1) {
    if (typeof(obj.comment) != "undefined" && LRTrim(obj.comment) != "")
      description = trimNameDesc(obj.comment, maxlen);
    else {
      if (LRTrim(obj.output_name) != "") {
        description = trimNameDesc(obj.output_name, maxlen);
      }
      else {
        description = trimNameDesc(obj.name, maxlen) + " [" + obj.busobj + "]";
      }
    }
  }
  else if (obj.type.indexOf("HeaderBar") > -1) {
    description = trimNameDesc(obj.title, maxlen);
  }
  else if (obj.type.indexOf("ReportBar") > -1) {
    description = trimNameDesc(obj.title, maxlen);
  }
  else if (obj.type.indexOf("BreakPage") > -1 || obj.type.indexOf("AutoCover") > -1 || obj.type.indexOf("HtmlSection") > -1) {
    if (typeof(obj.comment) != "undefined" && LRTrim(obj.comment) != "") {
      description = trimNameDesc(obj.comment, maxlen);
    }
    else {
      description = trimNameDesc(obj.name, maxlen);
    }
  }
  else {
    description = obj.title + " - " + obj.name;
  }
  description = Strtran(description, "'", "\'");
  //description = ToHTMLValue(description);
  return description;
}

function writeStandardDef(obj) {
  var JsonItem = {type : obj.type}
  var propName, valueToSave;
  setPropertiesID(obj);
  for (var u = 0; u < obj.objClass.properties.length; u++) {
    propName = obj.objClass.properties[u];
    valueToSave = obj[propName];

    switch (propName) {
      case "x":
      case "xl":
      case "xr":
      case "y":
        if (valueToSave < 0) {
          PSAlert.alert("Attention: item " + obj.objClass.properties.name + " with position " + propName + " < 0!");
          valueToSave = 0;
        }
        else {
          valueToSave = Round((valueToSave * 100 / scale), 0);
        }
        break;
      case "w":
      case "h":
        if (valueToSave < 0) {
          PSAlert.alert("Attention: item " + obj.objClass.properties.name + " with dimension " + propName + " < 0!");
          valueToSave = 0;
        }
        else {
          valueToSave = Round((valueToSave * 100 / scale), 0);
        }
        break;
      case "picture":
        if (obj.global_picture == true) {
          continue;
        }
        break;
      case "font":
      case "font_size":
      case "font_weight":
      case "font_effect":
        if (obj.global_font == true) {
          continue;
        }
        break;
      case "print_in_newpage":
      case "print_group":
      case "print_when_change_groupuid":
        if (obj.print_always == true) {
          continue;
        }
        break;
      case "print_when_change_group":
        continue;
      case "resetuid":
      case "into_variable":
      case "calculate_onuid":
      case "calculate_when":
        if (obj.calculations == "nothing" || obj.calculations == "") {
          continue;
        }
        break;
      case "calculate_on":
      case "bb_calculate_on":
          continue;
      case "reset":
          continue;
        break;
      case "link_type":
      case "link_expr":
      case "link_action":
      case "link_parameters":
      case "link_parameters_value":
      case "link_target_src":
      case "link_target":
      case "link_w":
      case "link_h":
      case "exit_at_end":
      case "link_enable_cond":
        if (LRTrim(obj.link_name) == "") {
          continue;
        }
        break;
    }
    if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
      if (typeof(valueToSave) == "undefined" || valueToSave === "") {
        // Se la prop e' undefined allora la salvo come ' '
        valueToSave = " ";
      }
    }
    valueToSave = "" + valueToSave;
    if (valueToSave.length <= 0) {
      valueToSave = " ";
    }
    valueToSave = Strtran(valueToSave, '--', '##x2d;##x2d;');
    valueToSave = Strtran(valueToSave, '"', '\"');
    JsonItem[propName] = valueToSave;
  }
  return JsonItem;
}

function readStandardDef(itemProperties, arrayobj) {
  var propName, valueToLoad;
  for (var b = 0; b < itemProperties.length; b++) {
    propName = itemProperties[b];
    valueToLoad = translateCharacters(itemProperties[b + 1]);
    readProperty(propName, valueToLoad, arrayobj);
    b++;
  }
}

function readStandardJsonDef(JsonProperties, arrayobj) {
  var propName, valueToLoad;
  for (var b in JsonProperties) {
    propName = b;
    valueToLoad = translateCharacters(JsonProperties[propName]);
    readProperty(propName, valueToLoad, arrayobj);
  }
}

function readProperty(propName, valueToLoad, arrayobj) {
  var i;
  switch (propName) {
    /*case "":
      continue;*/
    case "x":
    case "xl":
    case "xr":
    case "y":
      if (arrayobj) {
        //Inserito per compatibilita' con la versione 4.0 del report in cui venivano scritti i valori x, y, w, h per le variabili.
        //arrayobj[arrayobj.length - 1][propName] = valueToLoad;
      }
      else {
        if (parseInt(valueToLoad) < 0) {
          PSAlert.alert("Attention: item " + itemsHTML[countindex - 1]["name"] + " with position " + propName + " < 0!");
          valueToLoad = 0;
        }
        itemsHTML[countindex - 1][propName] = parseInt(valueToLoad);
      }
      break;
    case "h":
    case "w":
      if (arrayobj) {
        //Inserito per compatibilita' con la versione 4.0 del report in cui venivano scritti i valori x,y,w,h per le variabili.
        //arrayobj[arrayobj.length - 1][propName] = valueToLoad;
      }
      else {
        if (parseInt(valueToLoad) < 0) {
          PSAlert.alert("Attention: item " + itemsHTML[countindex - 1]["name"] + " with position " + propName + " < 0!");
          valueToLoad = 0;
        }
        itemsHTML[countindex - 1][propName] = parseInt(valueToLoad);
      }
      break;

    case "uid":
      if (reportProp.version < "4.4") {
        //Errore presente solo nella versioni precedenti la 4.4. L'uid degli elementi copiati non veniva cambiato.
        for (i = 0; i < itemsHTML.length; i++) {
          if ((valueToLoad.toUpperCase()) == (itemsHTML[i].uid.toUpperCase())) {
            valueToLoad = Upper(AlfaKeyGen(10));
            i = itemsHTML.length;
          }
        }
      }
      itemsHTML[countindex - 1][propName] = valueToLoad;
      break;

    case "into_variable":
      if (reportProp.version == "4.0") {
        //Errore presente solo nella versione 4.0 e precedenti. Il valueToLoad della variabile veniva scritto in minuscolo.
        for (i = 0; i < reportVariables.length; i++) {
          if ((valueToLoad.toLowerCase()) == (reportVariables[i].name.toLowerCase())) {
            itemsHTML[countindex - 1][propName] = reportVariables[i].name;
            i = reportVariables.length;
          }
        }
      }
      else {
      //Dalla versione 4.1 posso operare tranquillamente
        itemsHTML[countindex - 1][propName] = valueToLoad;
      }
      break;

    case "link_hidecond":
      // Inserito questo test perche' nelle vecchie versioni generate con SitePainter (prima 2011), la link_enable_cond delle label era chiamata ling_hidecond.
      itemsHTML[countindex - 1].link_enable_cond = valueToLoad;
      break;

    case "reset":
      if (reportProp.version < "4.5") {
        if (itemsHTML[countindex - 1].reset != "end of page" && itemsHTML[countindex - 1].reset != "end of report") {
          itemsHTML[countindex - 1].resetuid = getGroupUid(valueToLoad);
        }
        else {
          itemsHTML[countindex - 1].resetuid = valueToLoad;
        }
      }
      break;

    case "resetuid":
      if (reportProp.version == "4.1" && (LRTrim(valueToLoad) == "" && itemsHTML[countindex - 1]["reset"] == "end of report")) {
        /* Errore presente solo nella versione 4.1.
           La proprieta' si svuotava quando si scriveva un valore nella proprieta' into variable perche' il suo valore era la stringa vuota nel def.*/
        itemsHTML[countindex - 1][propName] = "end of report";
      }
      else {
        //Dalla versione 4.2 posso operare tranquillamente
        itemsHTML[countindex - 1][propName] = valueToLoad;
      }
      break;

    case "calculate_on":
      if (reportProp.version < "4.5") {
        if (itemsHTML[countindex - 1].calculate_on != "each record" && itemsHTML[countindex - 1].calculate_on != "end of report") {
          itemsHTML[countindex - 1].calculate_onuid = getGroupUid(valueToLoad);
        }
        else {
          itemsHTML[countindex - 1].calculate_onuid = valueToLoad;
        }
      }
      break;

    case "calculate_onuid":
      if (reportProp.version == "4.1" && (LRTrim(valueToLoad) == "" && itemsHTML[countindex - 1]["calculate_on"] == "each record")) {
        /* Errore presente solo nella versione 4.1.
           La proprieta' si svuotava quando si scriveva un valore nella proprieta' into variable perche' il suo valore era la stringa vuota nel def.*/
        itemsHTML[countindex - 1][propName] = "each record";
      }
      else {
        //Dalla versione 4.2 posso operare tranquillamente
        itemsHTML[countindex - 1][propName] = valueToLoad;
      }
      break;

    case "print_when_change_group":
      if (reportProp.version < "4.5") {
        if (itemsHTML[countindex - 1].print_when_change_group != "") {
          itemsHTML[countindex - 1].print_when_change_groupuid = getGroupUid(valueToLoad);
        }
        else {
          itemsHTML[countindex - 1].print_when_change_groupuid = valueToLoad;
        }
      }
      break;

      case "link_target":
      if (reportProp.version < "4.1") {
        /* Errore presente solo nelle versioni precedenti la 4.2.
           La proprieta' link_target_src non esisteva nei vrp generati dal SitePainter Report Painter prima del 15/09/2011. */
        if (valueToLoad === "new") {
          itemsHTML[countindex - 1].link_target_src = "new window";
          itemsHTML[countindex - 1].link_target = "";
        }
        else if (Trim(valueToLoad) === "") {
          itemsHTML[countindex - 1].link_target_src = "same window";
        }
        else {
          itemsHTML[countindex - 1].link_target_src = "frame";
          itemsHTML[countindex - 1].link_target = valueToLoad;
        }
      }
      else {
        itemsHTML[countindex - 1].link_target = valueToLoad;
      }
      break;

    case "picture":
      if (reportProp.version < "4.8") {
        if (LRTrim(valueToLoad) != "") {
        /* Implementazione presente dalla versione 4.7.
           E' stata implementata la global picture. */
          itemsHTML[countindex - 1].global_picture = false;
        }
        else {
          itemsHTML[countindex - 1].global_picture = true;
          valueToLoad = "";
        }
      }
      itemsHTML[countindex - 1][propName] = valueToLoad;
      break;

    case "global_picture":
    case "global_font":
    case "struncate":
    case "stretch":
    case "print_always":
    case "print_in_newpage":
    case "exit_at_end":
    case "start_each_on_page":
    case "as_page_header":
    case "print_group_footer":
    case "as_page_footer":
    case "reprint_header":
    case "reprint_footer":
    case "printblock":
    case "reset_page_number":
    case "scale_to_frame_size":
    case "keep_proportions":
    case "clip_to_frame_size":
    case "print_not_found_image":
    case "printasbg":
    case "stretch_to_right":
      if (LRTrim(valueToLoad) == "true") {
        itemsHTML[countindex - 1][propName] = true;
      }
      else {
        itemsHTML[countindex - 1][propName] = false;
      }
      break;

    case "privacy":
    case "data_danger_level":
    case "identifier":
      reportProp.contentprivacy++;
      itemsHTML[countindex - 1][propName] = valueToLoad;
      break;

    case "font_weight":
      var font;
      if (arrayobj) {
        font = arrayobj[arrayobj.length - 1]['font'];
      }
      else {
        font = itemsHTML[countindex - 1]['font'];
      }

      if( font.indexOf('fonts/DejaVu') == 0 && font!='fonts/DejaVuSans-ExtraLight.ttf' ) {
        var font_weight = valueToLoad;
        valueToLoad = font;
        valueToLoad = valueToLoad.substring('fonts/'.length);
        valueToLoad = valueToLoad.substring(0, valueToLoad.indexOf('.ttf'));
        var vs = valueToLoad.split('-');
        var fcssL = vs[0].split(/(?=[A-Z])/);
        var fcss = '';
        fcss = fcssL[0]+fcssL[1];//DejaVu
        for (var k=2; k<fcssL.length; k++) {
          fcss += ' ' + fcssL[k]
        }
        if (arrayobj) {
          arrayobj[arrayobj.length - 1]['font'] = fcss + ', sans-serif';
        }
        else {
          itemsHTML[countindex - 1]['font'] = fcss + ', sans-serif';
        }
        if (vs[1]) {
          font_weight = '';
          if(vs[1].toLowerCase().indexOf('bold') >= 0) {
            font_weight = 'bold';
          }
          if(vs[1].toLowerCase().indexOf('italic')>=0 || vs[1].toLowerCase().indexOf('oblique')>=0) {
            font_weight += ' italic';
          }
          font_weight = font_weight.trim();
          if (font_weight.length > 0) {
            if (arrayobj) {
            arrayobj[arrayobj.length - 1][propName] = font_weight;
            }
            else {
            itemsHTML[countindex - 1][propName] = font_weight;
            }
          }
        }
        else {
          if (arrayobj) {
            arrayobj[arrayobj.length - 1][propName] = font_weight;
          }
          else {
            itemsHTML[countindex - 1][propName] = font_weight;
          }
        }
      }
      else {
        if (arrayobj) {
          arrayobj[arrayobj.length - 1][propName] = valueToLoad;
        }
        else {
          itemsHTML[countindex - 1][propName] = valueToLoad;
        }
      }
      break;

    default:
      if (arrayobj) {
        arrayobj[arrayobj.length - 1][propName] = valueToLoad;
      }
      else {
        itemsHTML[countindex - 1][propName] = valueToLoad;
      }
      break;
  }
}

function normalizeXML(testo) {
  return testo;
}

function getPropID(props, prop) {
  for (var b = 0; b < props.length; b++) {
    if (props[b][1] == prop) {
      return b;
    }
  }
}

function getObjImg(type/*, types*/) {
  var image_path = "../portalstudio/images/";
  switch (type.toLowerCase()) {
    case "label":
      image_path += "icon/bot_label_off.png";
      break;
    case "expr":
      image_path += "icon/bot_Expression_off.png";
      break;
    case "image":
      image_path += "bot_image_128.png";
      break;
    case "box":
      image_path += "icon/bot_boxarea_off.png";
      break;
    case "hline":
      image_path += "icon/bot_horizontalline_off.png";
      break;
    case "vline":
      image_path += "icon/bot_verticalline_off.png";
      break;
    case "chart":
      image_path += "bot_graphics_128.png";
      break;
    case "group":
    case "group_top":
    case "group_down":
      image_path += "icon/bot_group_off.png";
      break;
    case "section":
    case "section_top":
    case "section_down":
      image_path += "icon/bot_section_off.png";
      break;
    case "altquery":
    case "altquery_top":
    case "altquery_down":
      image_path += "icon/bot_altquery_off.png";
      break;
    case "breakpage":
      image_path += "icon/bot_pagebreak_off.png";
      break;
    case "htmlsection":
      image_path += "icon/bot_htmlsection_off.png";
      break;
    case "autocover":
      image_path += "icon/bot_autocover_off.png";
      break;
    case "sectbo":
    case "sectbo_top":
    case "sectbo_down":
      image_path += "icon/bot_sect_bo_off.png";
      break;
    case "variable":
      image_path += "icon/mn_Var_blue.png";
      break;
    case "barcode":
      image_path += "bot_barcode_128.png";
      break;
    case "barcode2d":
      image_path += "bot_barcode2d_128.png";
      break;
    case "signmark":
      image_path += "bot_signmup_128.png";
      break;
    case "signsvg":
      image_path += "bot_signsvg_128.png";
      break;
    case "tinyhtml":
      image_path += "bot_tinyhtml_128.png";
      break;
  }
  image_path += "";
  return image_path;
}

function getPropDescObj(obj, propID) {
  var ret = {};
  ret.desc = propID;
  ret.prop = propID;
  if (obj.objClass.newProperties) {
    var tab, i, ii;
    for (i in obj.objClass.newProperties) {
      tab = obj.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        if (tab[ii].propID == propID) {
          ret.desc = tab[ii].name;
          ret.tab = i;
          return ret;
        }
      }
    }
  }
  return ret;
}
