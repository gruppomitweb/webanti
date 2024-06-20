/*  exported dragstartx dragstarty newx newy mainitem index infindex itemsHTML imgHTML
    imgcountindex m_bUpdated fieldHTML fieldcountindex
    newObj
 */
/*  global newdesign ZoomOut ZoomIn Redo Undo toolbarPreview initPropertiesDefaultValue clCanvasLib msimplesheet msimplesheetqr
    openerAddItem openerAddFixedElements
*/

// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
var dragstartx, dragstarty, newx, newy, mainitem;
var index; // indice corrente del mainitem nell'Array
var infindex;
var nitem = 0; // numero item crescente
var itemsHTML = []; //array contenente tutti gli oggetti item con id, HTML, shadow, ecc
var itemsHTMLArray = [];
var imgHTML = [];
var countindex = []; //contatore indice array
var imgcountindex = 0;
var m_bUpdated = false;
var docpageindex = 0;
itemsHTMLArray[docpageindex] = [];
itemsHTML = itemsHTMLArray[docpageindex];
countindex[docpageindex] = 0;
var fieldHTML = [];
var fieldcountindex = 0;
var version = "1.5";
/*
  18/03/2013: 1.0 - Versione B60.
  31/10/2013: 1.1 - Versione B60 - Colori scritti nel def in codifica hex.
  01/10/2014: 1.2 - Versione B61 - Def in formato JSON.
  04/09/2018: 1.3 - Versione B61 - Valore di default di barcode
  24/11/2020: 1.4 - Versione B61 - Divisione Barcode e Barcode2D
 */

var newObj = {};

if (typeof(ZTObjects) == 'undefined') {
  var ZTObjects = new function () {
    var type_select = "select[text,checkbox,radio,image,signsvg,barcode,barcode2d]";
    var type_barcode = "select[EAN-8,EAN-13,UPC-A,Code39,Code128,ITF,CODABAR]";
    var type_barcode2d = "select[QRCode,PDF417]";
    var fonts_select = "select[Arial,Courier,Tahoma,Times New Roman,Verdana";
    var sign_select ="select[,Privacy:signPrivacy,Unfair:signUnfair]"
    var fonts_add = '';
    var msg = new JSURL("../servlet/RPFontsList", true).Response();
    if (msg.length > 0) {
      var otherfontL = msg.split(',');
      for (var mm = 0; mm < otherfontL.length; mm++) {
        if (otherfontL[mm].indexOf('fonts/DejaVu') < 0) {
          fonts_add += "," + otherfontL[mm].replace(/;/gi, ',');
        }
      }
    }
    if (fonts_add.length > 0) {
      fonts_add = ',separator-Fonts File' + ',fonts/DejaVuSans-ExtraLight.ttf' + fonts_add
    }
    fonts_select += fonts_add + "]";
    var check_select = "select[,Off,On]";
    var rulers_select = 'select[Points:pt,Millimeters:mm,Centimeters:cm,Picas:pc,Inches:inch]';
    var rotation_select = "select[0,90,180,270]";
    var align_select = "select[left,right,center]";
    var fonts_style = "select[normal,bold,italic,bold italic]";
    var fonts_effect = "select[,strikeout,underline,strikeout underline]";
    var format_select = "select[none,number,percentage,date,time,special]";
    var dateformat_select = "select[m/d,m/d/yy,m/d/yyyy,mm/dd/yy,mm/dd/yyyy,mm/yy,mm/yyyy,d-mmm,d-mmm-yy,d-mmm-yyyy,dd-mmm-yy,dd-mmm-yyyy,yy-mm-dd,yyyy-mm-dd,mm-yy,mmm-yyyy,mmmm-yy,mmmm-yyyy,m/d/yy h:MM tt,m/d/yyyy h:MM tt,m/d/yy HH:MM,m/d/yyyy HH:MM]";
    var timeformat_select = "select[HH:MM,h:MM tt,HH:MM:ss,h:MM:ss tt]";
    var specialformat_select = "select[Zip Code,Zip Code + 4,Phone Number,Social Security Number]";
    var numberseperator_select = "select[1234;56,1.234;56,1234.56,1;234.56]";
    var numbercurrency_select = "select[none,Euro,Dollar,Deutschmark,Franc,Guilder,Krona,Lira,Peseta,Pound,Yen]";
    var numbernegative_select = "select[minus,parentheses,red text,parentheses and red text]";
    var print_select2 = "select[All,Only First,Only Last,First and Last,Only Next,First Page of Last Sheet]";
    var datatype_select = "select[none,text,date,time,number]";

    this.PSToolbarAlign = [
      { 'id': 'bottom_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('bottom'); }
        , 'image': '../portalstudio/images/icon/btn_alignbottom.png'
        , 'title': 'Align bottom'
      },{ 'id': 'top_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('top'); }
        , 'image': '../portalstudio/images/icon/btn_aligntop.png'
        , 'title': 'Align top'
      },{ 'id': 'left_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('left'); }
        , 'image': '../portalstudio/images/icon/btn_alignleft.png'
        , 'title': 'Align left'
      },{ 'id': 'right_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('right'); }
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

	this.PSToolbarAlignLightQR = [
      { 'id': 'alignGroup'
        , 'class_name': 'btn'
        , 'action': function(){}
        , 'image': '../portalstudio/images/icon/btn_hbars.png'
        , 'title': 'Allinea campi'
      },
	  { 'id': 'bottom_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('bottom'); }
        , 'image': '../portalstudio/images/icon/btn_alignbottom.png'
        , 'title': 'Allinea in basso'
      },{ 'id': 'top_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('top'); }
        , 'image': '../portalstudio/images/icon/btn_aligntop.png'
        , 'title': 'Allinea in alto'
      },{ 'id': 'left_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('left'); }
        , 'image': '../portalstudio/images/icon/btn_alignleft.png'
        , 'title': 'Allinea a sinistra'
      },{ 'id': 'right_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('right'); }
        , 'image': '../portalstudio/images/icon/btn_alignright.png'
        , 'title': 'Allinea a destra'
      }
    ];
	
    this.PSToolbarResize = [
    { 'id': 'x_delta_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('x_delta'); }
        , 'image': '../portalstudio/images/icon/btn_x-delta.png'
        , 'title': 'Same horizontal distance'
      },{ 'id': 'y_delta_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('y_delta'); }
        , 'image': '../portalstudio/images/icon/btn_y-delta.png'
        , 'title': 'Same vertical distance'
      },{ 'id': 'resizexy_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('resizexy'); }
        , 'image': '../portalstudio/images/icon/btn_resize-xy.png'
        , 'title': 'Same size'
      },{ 'id': 'resizex_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('resizex'); }
        , 'image': '../portalstudio/images/icon/btn_resize-x.png'
        , 'title': 'Same width'
      },{ 'id': 'resizey_align'
        , 'class_name': 'btn'
        , 'action': function() { alignItems('resizey'); }
        , 'image': '../portalstudio/images/icon/btn_resize-y.png'
        , 'title': 'Same height'
      }
    ];

    this.PSToolbarResizeLightQR = [
      { 'id': 'deltaGroup'
        , 'class_name': 'btn'
        , 'action': function(){}
        , 'image': '../portalstudio/images/icon/progressbar_small.png'
        , 'title': 'Distribuisci campi'
      },
      { 'id': 'x_delta_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('x_delta'); }
        , 'image': '../portalstudio/images/icon/btn_x-delta.png'
        , 'title': 'Stessa distanza orizzontale'
      },{ 'id': 'y_delta_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('y_delta'); }
        , 'image': '../portalstudio/images/icon/btn_y-delta.png'
        , 'title': 'Stessa distanza verticale'
      },{ 'id': 'resizexy_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('resizexy'); }
        , 'image': '../portalstudio/images/icon/btn_resize-xy.png'
        , 'title': 'Stessa dimensione'
      },{ 'id': 'resizex_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('resizex'); }
        , 'image': '../portalstudio/images/icon/btn_resize-x.png'
        , 'title': 'Stessa larghezza'
      },{ 'id': 'resizey_align'
        , 'class_name': 'btn'
        , 'action': function(){ alignItems('resizey'); }
        , 'image': '../portalstudio/images/icon/btn_resize-y.png'
        , 'title': 'Stessa altezza'
      }
    ];

    /* Toolbar di edit per la modalita' generica. */
    this.PSToolbarAction = [
      { 'id': 'new'
        , 'class_name': 'btn'
        , 'action': function() { newdesign(); }
        , 'image': '../portalstudio/images/icon/btn_new.png'
        , 'title': 'New'
      },{ 'id': 'open'
        , 'class_name': 'btn'
        , 'action': function() { openModule(); }
        , 'image': '../portalstudio/images/icon/btn_open.png'
        , 'title': 'Open'
        , 'withTitle': true
      },{ 'id': 'save'
        , 'class_name': 'btn'
        , 'action': function() { save(); }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Save'
        , 'withTitle': true
      },{ 'id': 'saveas'
        , 'class_name': 'btn'
        , 'action': function() { saveAs(); }
        , 'image': '../portalstudio/images/icon/btn_saveAs.png'
        , 'title': 'Save As'
      }
    ];

    /* Toolbar di edit per la modalita' light.
       Si visualizza solo il bottone 'Save' e 'Save and Exit'.
     */
    this.PSToolbarActionLightQR = [
      { 'id': 'save'
        , 'class_name': 'btn'
        , 'action': function() { save(); }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Salva'
        , 'withTitle': true
      },{ 'id': 'saveclose'
        , 'class_name': 'btn'
        , 'action': function() { save('close'); }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Salva ed Esci'
        , 'withTitle': true
      }
    ];

    /* Toolbar di edit per la modalita' light.
       Si visualizza solo il bottone 'Save'.
     */
    this.PSToolbarActionLight = this.PSToolbarAction.slice(2, 3);

    /* Toolbar di edit per quando il disegnatore viene aperto in PortalStudio. */
    this.PSToolbarEdit = [
      { 'id': 'zoomoutdocpage'
        , 'class_name': 'btn'
        , 'action': function() { ZoomOut(); }
        , 'image': '../portalstudio/images/icon/btn_zoomOut2.png'
        , 'title': 'Zoom Out'
      },{ 'id': 'selectZoom'
        , 'class_name': 'remMarginLeft'
        , 'action': function() {}
        , 'title': 'Select Zoom Percent'
        , 'innerHTML': ' <select id="zoombox" name="zoombox" class="pdfTextbox" style="position:relative;top:0;padding:0px;border:1px solid #B6B6B6;" onchange="zoomindex=this.selectedIndex;zoom(this.options[this.selectedIndex].value)">'
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
        , 'action': function() { ZoomIn(); }
        , 'image': '../portalstudio/images/icon/btn_zoomIn2.png'
        , 'title': 'Zoom In'
      }
    ];

    /* Array contenente i bottoni da visualizzare solo quando il Module Editor e' aperto in modalita' stand alone.*/
    this.PSToolbarEditFull = [
      { 'id': 'copyBtn'
        , 'class_name': 'btn'
        , 'action': function() { CopyPaste(true,false); }
        , 'image': '../portalstudio/images/icon/btn_copy.png'
        , 'title': 'Copy'
      },{ 'id': 'cutBtn'
        , 'class_name': 'btn'
        , 'action': function() { CopyPaste(true,true); }
        , 'image': '../portalstudio/images/icon/btn_cut.png'
        , 'title': 'Cut'
      },{ 'id': 'pasteBtn'
        , 'class_name': 'btn'
        , 'action': function() { CopyPaste(false); }
        , 'image': '../portalstudio/images/icon/btn_paste.png'
        , 'title': 'Paste'
      },{ 'id': 'undoBtn'
        , 'class_name': 'btn'
        , 'action': function() { Undo(); }
        , 'image': '../portalstudio/images/icon/btn_undo.png'
        , 'title': 'Undo'
      },{ 'id': 'redoBtn'
        , 'class_name': 'btn'
        , 'action': function() { Redo(); }
        , 'image': '../portalstudio/images/icon/btn_redo.png'
        , 'title': 'Redo'
      }
    ];

    /* Array contenente i bottoni da visualizzare solo quando il Module Editor e' aperto in modalita' light qr.*/
	this.PSToolbarEditLight = [
      { 'id': 'undoBtn'
        , 'class_name': 'btn'
        , 'action': function() { Undo(); }
        , 'image': '../portalstudio/images/icon/btn_undo.png'
        , 'title': 'Undo'
      },{ 'id': 'redoBtn'
        , 'class_name': 'btn'
        , 'action': function() { Redo(); }
        , 'image': '../portalstudio/images/icon/btn_redo.png'
        , 'title': 'Redo'
      }
    ];
	
    this.PSToolbarEditLightQR = [
      { 'id': 'undoBtn'
        , 'class_name': 'btn'
        , 'action': function() { Undo(); }
        , 'image': '../portalstudio/images/icon/btn_undo.png'
        , 'title': 'Undo'
      },{ 'id': 'redoBtn'
        , 'class_name': 'btn'
        , 'action': function() { Redo(); }
        , 'image': '../portalstudio/images/icon/btn_redo.png'
        , 'title': 'Redo'
      }
    ];

    /* Toolbar di edit per la modalita' stand-alone del disegnatore.
       Si devono aggiungere i bottoni 'Cut', 'Copy', 'Paste', 'Undo'.
     */
    //this.PSToolbarEditFull = this.PSToolbarEdit.concat(additionalToolbarEdit);

    this.PSToolbarPreview = [
      { 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function() { toolbarPreview(); }
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Go to Preview'
        , 'withTitle': true
      }
    ];

    /* Toolbar dei control generica. */
    this.PSToolbarCtrl = [
      { 'id': 'addAreaBtn'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/btn_addlayer.png'
        , 'title': 'Area'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Area'}
      },{ 'id': 'adddocpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/btn_adddocpage.png'
        , 'title': 'Text'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Zone'}
      },{ 'id': 'addradiopage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_radio_off.png'
        , 'title': 'Radio'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Radio'}
      },{ 'id': 'adddocpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_checkbox_off.png'
        , 'title': 'Checkbox'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Checkbox'}
      },{ 'id': 'addimgpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_image_off.png'
        , 'title': 'Image'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Image'}
      },{ 'id': 'omr_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_omr_off.png'
        , 'title': 'Optical Mark (OMR)'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Omr'}
      }
    ];

    this.PSToolbarCtrlNoZone = [
      { 'id': 'addbarcpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode_off.png'
        , 'title': 'Barcode'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Barcode'}
      },{ 'id': 'addbarc2dpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode2d_off.png'
        , 'title': 'Barcode 2D'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Barcode2D'}
      },{ 'id': 'ssvg_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_signsvg.png'
        , 'title': 'Tiny SVG'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'SignSVG'}
      },{ 'id': 'smup_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_signmup.png'
        , 'title': 'Signature Markup'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'SignMark'}
      }
    ];

    this.PSToolbarCtrlEditable = [
      { 'id': 'adddocpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/btn_adddocpage.png'
        , 'title': 'Text'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Zone'}
      },{ 'id': 'addradiopage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_radio_off.png'
        , 'title': 'Radio'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Radio'}
      },{ 'id': 'adddocpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_checkbox_off.png'
        , 'title': 'Checkbox'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Checkbox'}
      }
    ];

    this.PSToolbarCtrlNotEditable = [
      { 'id': 'smup_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_signmup.png'
        , 'title': 'Signature Markup'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'SignMark'}
      },{ 'id': 'addimgpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_image_off.png'
        , 'title': 'Image'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Image'}
      },{ 'id': 'addbarcpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode_off.png'
        , 'title': 'Barcode'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Barcode'}
      },{ 'id': 'addbarc2dpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode2d_off.png'
        , 'title': 'Barcode 2D'
        , 'draggable' : true
        , 'action':{'func':'addItem','par':'Barcode2D'}
      }
    ];

    //Enrico: ipotetica toolbar per QRCode
    this.PSToolbarLightQR = [
      { 'id': 'addbarc2dpage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_barcode2d_off.png'
        , 'title': 'QRCode'
        , 'action': function() { openerAddItem('Barcode2D'); }
        , 'withTitle': true
      }
	  ,
	  { 'id': 'addfixedelempage'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/bot_boxarea_off.png'
        , 'title': 'Postalizzazione'
        , 'action': function() { openerAddFixedElements(); }
        , 'withTitle': true
      }
    ];

    this.PSToolbarPredefined = [
      { 'id': 'npag_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/page_num.png'
        , 'title': 'Page number'
        , 'action':{'func':'putSystemVarNumPage','par':''}
        , 'draggable': true
      },{ 'id': 'tpag_ctrl'
        , 'class_name': 'btn'
        , 'image': '../portalstudio/images/icon/total_pages.png'
        , 'title': 'Total page number'
        , 'action':{'func':'putSystemVarTotalPages','par':''}
        , 'draggable': true
      }
    ];

    this.findProp = function (propID, container) {
      for (var j = 0; j < container.length; j++) {
        if (container[j].propID == propID ) {
          return j;
          //break;
        }
      }
      return -1;
    }

    this.extend = function( objA, objB) { //itemsObj visualweb
      // La posizione della properties ? definita dall'oggetto esteso
      var propsA = objA['newProperties'],
      propsB = objB['newProperties'];
      var iB, i;
      for (var prop in propsA ) {
        for (i = 0; i < propsA[prop].length; i++ ) {
          if (typeof(propsB[prop]) == 'undefined' ) {
            propsB[prop] = propsA[prop];
            break;
          }
          iB = this.findProp(propsA[prop][i].propID, propsB[prop]);
          if (iB == -1 ) {
            propsB[prop].splice(i, 0, propsA[prop][i]);
          }
        }
      }
    }

    this.stdObjClass = {
      newProperties:{
        generic:[
          {name:'comment',			propID:'comment',			type:'str',			tooltip:'Object comment',		defaultValue:''},
          {name:'name',				propID:'name',			type:'str',			tooltip:'Unique identifier for the Object in the current module',		validFunc:'validXMLName'}
        ],
        layout:[
          {name:'x',						propID:'x',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',						propID:'y',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'width',				propID:'w',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Width',	extraClass:"col-3"},
          {name:'height',				propID:'h',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Height',	extraClass:"col-3"}
        ],
        print_options:[
          {name:'print field',					propID:'printfield',		type:print_select2,			tooltip:'Specify in which instance of the document printing the object',		defaultValue:'All'}
        ]
      }
    };

    this.stdObjClassLight = {
      newProperties:{
        generic:[
          {name:'description',			propID:'comment',			type:'str',			tooltip:'Field description',		defaultValue:''},
          {name:'field name',				propID:'name',			type:'str',			tooltip:'Field name for return value',		validFunc:'validXMLName'}
        ],
        layout:[
          {name:'x',						propID:'x',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',						propID:'y',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'width',				propID:'w',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Width',	extraClass:"col-3"},
          {name:'height',				propID:'h',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Height',	extraClass:"col-3"}
        ],
        notes:[
          {name:'user notes',				propID:'note',				type:'str',			tooltip:'User notes',			defaultValue:'',	buttons:'edit',	actions:'EditEUNotes()'}
        ]
      }
    };
	this.stdObjClassLightQR = {
      newProperties:{
        generic:[
          {name:'description',			propID:'comment',			type:'str',			tooltip:'Field description',		defaultValue:''},
          {name:'field name',				propID:'name',			type:'str',			tooltip:'Field name for return value',		validFunc:'validXMLName'}
        ],
        layout:[
          {name:'x',						propID:'x',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',						propID:'y',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'width',				propID:'w',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Width',	extraClass:"col-3"},
          {name:'height',				propID:'h',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Height',	extraClass:"col-3"},
		  {name:'canMove',				propID:'canMove',		type:'checkbox', defaultValue: true}
        ],
        notes:[
          {name:'user notes',				propID:'note',				type:'str',			tooltip:'User notes',			defaultValue:'',	buttons:'edit',	actions:'EditEUNotes()'}
        ]
      }
    };


    this.formObjClassLight={
      newProperties:{
        generic:[
          {name:'description',		propID:'description',			type:'str',			tooltip:'Description of the Module'},
          {name:'pdf width',			propID:'width',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Display the width of the Work zone',	extraClass:"col-3"},
          {name:'pdf height',			propID:'height',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Display the height of the Work zone',	extraClass:"col-3"},
          {name:'',								propID:'proportions',			type:'checkbox',			disabled:true},
          {name:'pdf file',				disabled:true,	propID:'file',			type:'str',			noteditable:true,		buttons:'pick',			actions:'LoadPdf()',			tooltip:'Pdf file from which loading the pages'},
          {name:'source fields file',		disabled:true, propID:'fldfile',			type:'str',			noteditable:true,		buttons:'pick,edit,reload',			actions:'LoadFieldsVrp(),EditVrp(),ReloadFields()',			tooltip:'Definition file (VRP file or XML file) of the fields'}
        ],
        global_definitions:[
          {name:'name',		propID:'font',		type:'advanced-font', fontList:fonts_select,			defaultValue:'DejaVu Sans Condensed, sans-serif',	tooltip:'Use this font when printing every DocField if not customized in the single DocField',	section:"font"},
          {name:'size',		propID:'size',		type:'str',			tooltip:'Use this font size when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'color',		propID:'color',		type:'color',			tooltip:'Use this font color when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'style',		propID:'weight',		type:fonts_style,			tooltip:'Use this font style when printing every DocField if not customized in the single DocField',	defaultValue:'normal',	extraClass:"col-3",	section:"font"},
          {name:'effects',	propID:'effects',	type:fonts_effect,			tooltip:'Use this font effects when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'date picture',		propID:'datepic',		type:'str',			tooltip:'Apply this picture to every Date DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'time picture',		propID:'timepic',		type:'str',			tooltip:'Apply this picture to every Time DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'text picture',		propID:'textpic',		type:'str',			tooltip:'Apply this picture to every Text DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'number picture',		propID:'numpic',		type:'str',			tooltip:'Apply this picture to every Number DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"}
        ],
        view:[
          {name:'rulers',					propID:'rulers',		type:rulers_select,		validFunc:'ApplyUnit',		tooltip:'Show the current unit of measurement'},
          {name:'Hide Snap Lines',		propID:'hsl',		type:'checkbox',		tooltip:'Hide the snap lines', extraClass:"col-3"},
          {name:'Lock items',		propID:'lock_items',		type:'checkbox',		tooltip:'Lock the mouse move of the items', extraClass:"col-3"}
        ]
      }
    };

    this.formObjClassLightQR={
      newProperties:{
        Dati:[
          {name:'Descrizione',		propID:'description',			type:'str',			tooltip:'Description of the Module'},
          {name:'pdf width',			propID:'width',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Display the width of the Work zone',	extraClass:"col-3"},
          {name:'pdf height',			propID:'height',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Display the height of the Work zone',	extraClass:"col-3"},
          {name:'',								propID:'proportions',			type:'checkbox',			disabled:true},
          {name:'File Pdf',				disabled:true,    propID:'file',			type:'str',			noteditable:true,		buttons:'pick',			actions:'LoadPdf()',			tooltip:'Pdf file from which loading the pages'},
		  {name:'source fields file',		disabled:true, propID:'fldfile',			type:'str',			noteditable:true,		buttons:'pick,edit,reload',			actions:'LoadFieldsVrp(),EditVrp(),ReloadFields()',			tooltip:'Definition file (VRP file or XML file) of the fields'}
        ],
        global_definitions:[
          {name:'name',		propID:'font',		type:'advanced-font', fontList:fonts_select,			defaultValue:'DejaVu Sans Condensed, sans-serif',  tooltip:'Use this font when printing every DocField if not customized in the single DocField',	section:"font"},
          {name:'size',		propID:'size',		type:'str',			tooltip:'Use this font size when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'color',		propID:'color',		type:'str',			tooltip:'Use this font color when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'style',		propID:'weight',		type:fonts_style,			tooltip:'Use this font style when printing every DocField if not customized in the single DocField',	defaultValue:'normal',	extraClass:"col-3",	section:"font"},
          {name:'effects',	propID:'effects',	type:fonts_effect,			tooltip:'Use this font effects when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'date picture',		propID:'datepic',		type:'str',			tooltip:'Apply this picture to every Date DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'time picture',		propID:'timepic',		type:'str',			tooltip:'Apply this picture to every Time DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'text picture',		propID:'textpic',		type:'str',			tooltip:'Apply this picture to every Text DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'number picture',		propID:'numpic',		type:'str',			tooltip:'Apply this picture to every Number DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"}
        ],
        view:[
          {name:'rulers',					propID:'rulers',		type:rulers_select,		validFunc:'ApplyUnit',		tooltip:'Show the current unit of measurement'},
          {name:'Hide Snap Lines',		propID:'hsl',		type:'checkbox',		tooltip:'Hide the snap lines', extraClass:"col-3"},
          {name:'Lock items',		propID:'lock_items',		type:'checkbox',		tooltip:'Lock the mouse move of the items', extraClass:"col-3"}
        ]
      }
    };

    this.formObjClass={
      newProperties:{
        generic:[
          {name:'pdf width',			propID:'width',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Display the width of the Work zone',	extraClass:"col-3"},
          {name:'pdf height',			propID:'height',			type:'int',			noteditable:true,			convertFunc:'convertUnit',			tooltip:'Display the height of the Work zone',	extraClass:"col-3"},
          {name:'',								propID:'proportions',			type:'checkbox',			disabled:true},
          {name:'description',		propID:'description',			type:'str',			tooltip:'Description of the Module'},
          {name:'pdf file',				propID:'file',			type:'str',			noteditable:true,		buttons:'pick',			actions:'LoadPdf()',			tooltip:'Pdf file from which loading the pages'},
          {name:'source fields file',			propID:'fldfile',			type:'str',			noteditable:true,		buttons:'pick,edit,reload',			actions:'LoadFieldsVrp(),EditVrp(),ReloadFields()',			tooltip:'Definition file (VRP file or XML file) of the fields'}
        ],
        global_definitions:[
          {name:'name',		propID:'font',		type:'advanced-font', fontList:fonts_select,			defaultValue:'DejaVu Sans Condensed, sans-serif',	tooltip:'Use this font when printing every DocField if not customized in the single DocField',	section:"font"},
          {name:'size',		propID:'size',		type:'str',			tooltip:'Use this font size when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'color',		propID:'color',		type:'color',			tooltip:'Use this font color when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'style',		propID:'weight',		type:fonts_style,			tooltip:'Use this font style when printing every DocField if not customized in the single DocField',	defaultValue:'normal',	extraClass:"col-3",	section:"font"},
          {name:'effects',	propID:'effects',	type:fonts_effect,			tooltip:'Use this font effects when printing every DocField if not customized in the single DocField',	extraClass:"col-3",	section:"font"},
          {name:'date picture',		propID:'datepic',		type:'str',			tooltip:'Apply this picture to every Date DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'time picture',		propID:'timepic',		type:'str',			tooltip:'Apply this picture to every Time DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'text picture',		propID:'textpic',		type:'str',			tooltip:'Apply this picture to every Text DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"},
          {name:'number picture',		propID:'numpic',		type:'str',			tooltip:'Apply this picture to every Number DocField if not customized in the single DocField',	extraClass:"col-3",	section:"pictures"}
        ],
        view:[
          {name:'rulers',					propID:'rulers',		type:rulers_select,		validFunc:'ApplyUnit',		tooltip:'Show the current unit of measurement'},
          {name:'Hide Snap Lines',		propID:'hsl',		type:'checkbox',		tooltip:'Hide the snap lines'},
          {name:'Lock items',		propID:'lock_items',		type:'checkbox',		tooltip:'Lock the mouse move of the items'}
        ]
      }
    };

    this.imgObjClass={ // rif. pdfBckCommon.js
      newProperties:{
        generic:[
          {name:'name',			propID:'name',			type:'str',			tooltip:'Unique identifier for the Image in the current module',		validFunc:'validXMLName'},
          {name:'src',			propID:'src',			type:'str'},
          {name:'rotation',		propID:'rotation',		type:rotation_select,		defaultValue:0},
          {name:'height',			propID:'h',				type:'int',			disabled:true},
          {name:'width',			propID:'w',				type:'int',			disabled:true}
        ]
      }
    };

    this.AreaObjClass={
      newProperties:{
        generic:[
          {name:'name',			propID:'name',			type:'str',			noteditable:true,		tooltip:'Unique identifier for the Area in the current module',		validFunc:'validXMLName'},
          {name:'current layer',		propID:'layer',			section:'layers',	type:'layers',		tooltip:'Current Layer',		defaultValue:1},
          {name:'',						propID:'nlayers',		section:'layers',	type:'int',		disabled:true},
          {name:'layers names',			propID:'layers_names',		section:'layers',	type:'str',			tooltip:'List of name of layers separated with ","',		defaultValue:''}
        ],
        detail_fields:[
          {name:'continue another area',				propID:'overarea',		type:'checkbox',		tooltip:'Continuing area from previous page',		defaultValue:false
            ,hide_list:{'unchecked':['this.detail_fields_previousarea','this.detail_fields_startnumber'],
                        'checked':[]}
            ,show_list:{'checked':['this.detail_fields_previousarea','this.detail_fields_startnumber'],
                        'unchecked':[]}
          },
          {name:'previous area name',					propID:'previousarea',		type:'str',			tooltip:'Previous Area name',		defaultValue:''},
          {name:'start occurence number ',				propID:'startnumber',	type:'int',			tooltip:'Start Occurrence Number Counting',		defaultValue:1,		validFunc:'validStartNumber'},
          {name:'detail field',					propID:'detail',		type:'checkbox',			tooltip:'Apply Detail Field property for all fields of all layers in the Area'
            ,hide_list:{'unchecked':['this.detail_fields_detailnumber','this.detail_fields_stretch','this.detail_fields_removeempty','this.detail_fields_plast','this.detail_fields_printblock']}
            ,show_list:{'checked':['this.detail_fields_detailnumber','this.detail_fields_stretch','this.detail_fields_removeempty','this.detail_fields_plast']}
            ,defaultValue:false
          },
          {name:'occurence number',				propID:'detailnumber',	type:'int',					tooltip:'Apply Detail Field Occurrence Number property for all fields of all layers in the Area',		defaultValue:0},
          {name:'split with overflow',			propID:'stretch',		type:'checkbox',			tooltip:''
            ,hide_list:{'unchecked':['this.detail_fields_printblock']}
            ,show_list:{'checked':['this.detail_fields_printblock']}
            ,defaultValue:false
          },
          {name:'print as block',				propID:'printblock',	type:'checkbox',			tooltip:'',		defaultValue:false},
          {name:'remove empty',					propID:'removeempty',	type:'checkbox'
            ,tooltip:'When this property is selected, if all the fields of all the layers in the Area are empty as not defined in XML data, the Area will not be printed and the row number of the Area will not be incremented'
            ,defaultValue:false},
          {name:'print from last page',			propID:'plast',			type:'checkbox',			tooltip:'Print from last page of principal document',		defaultValue:false}
        ],
        fields_structure:[
          {name:'Fields structure',							propID:'fieldsstructure',			type:'select[vertical,horizontal]',	validFunc:'validFieldsStructure'
            ,hide_list:{'vertical':['this.fields_structure_hreplicatednumber'],'horizontal':['this.fields_structure_vreplicatednumber'],}
            ,show_list:{'vertical':['this.fields_structure_vreplicatednumber'],'horizontal':['this.fields_structure_hreplicatednumber'],}
            ,tooltip:'Specify how printing the field'
            ,defaultValue:'vertical'
          },
          {name:'horizontal fields',		propID:'hreplicated',				type:'checkbox',			tooltip:'',			disabled:true
            ,defaultValue:false
          },
          {name:'Columns number',			propID:'hreplicatednumber',			type:'int',					tooltip:'',		defaultValue:0},
          {name:'vertical fields',		propID:'vreplicated',				type:'checkbox',			tooltip:'',			disabled:true
            ,defaultValue:true
          },
          {name:'Columns number',			propID:'vreplicatednumber',			type:'int',					tooltip:'',		defaultValue:1}
        ]
      }
    };

    this.extend( this.stdObjClass, this.AreaObjClass );

	this.AreaObjClassLightQR={
      newProperties:{
        generic:[
          {name:'name',			propID:'name',			type:'str',			noteditable:true,		tooltip:'Unique identifier for the Area in the current module',		validFunc:'validXMLName'},
		  {name:'canMove',				propID:'canMove',		type:'checkbox', defaultValue:false, disabled:true
			,hide_list:{
              'true':['this.style', 'this.layout', 'this.notes'],
			  'false':['this.style', 'this.layout', 'this.notes']
            }
		  },
		  {name:'fAreaKey',				propID:'fAreaKey',		type:'str', defaultValue:'', disabled:true}
         ],
        layout:[
          {name:'x',						propID:'x',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'X coordinate',	extraClass:"col-3",disabled:true},
          {name:'y',						propID:'y',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Y coordinate',	extraClass:"col-3",disabled:true},
          {name:'width',				propID:'w',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Width',	extraClass:"col-3",disabled:true},
          {name:'height',				propID:'h',				type:'int',			convertFunc:'convertUnitZoom',		reconvertFunc:'reconvertUnitZoom',		validFunc:'validUnitZoomX',			tooltip:'Height',	extraClass:"col-3",disabled:true}	  
        ],
        notes:[
          {name:'user notes',				propID:'note',				type:'str',			tooltip:'User notes',			defaultValue:'',	buttons:'edit',	actions:'EditEUNotes()',disabled:true}
        ]
      }
    };
	this.extend( this.stdObjClassLightQR, this.AreaObjClassLightQR );


    this.ZoneObjClassLight={
      helper : {
        description : 'Object identifying zone of PDF where insert data',
        //,usage : 'Fill the Expression field, and select the Barcode type',
        'text': {
          description :'Object identifying zone of PDF where insert data as text'
          //,usage:''
        },
        'checkbox': {
          description :'Object identifying zone of PDF where insert data as checkbox'
          //,usage:''
        },
        'radio': {
          description :'Object identifying zone of PDF where insert data as radio button'
          //,usage:''
        },
        'image': {
          description :'Object identifying zone of PDF where insert data as image'
          //,usage:''
        },
        'barcode': {
          description :'Object identifying zone of PDF where insert data as barcode'
          //,usage:''
        },
        'barcode2d': {
          description :'Object identifying zone of PDF where insert data as barcode 2d'
          //,usage:''
        },
        'signsvg': {
          description :'Object identifying zone of PDF where insert data as barcode SVG graphic'
          ,usage:'The data must be : <ul><li>an SVG string</li><li> or a string ending with .svg, indicating a file path</li></ul>'
        }
      },
      newProperties:{
        generic:[
          {name:'Object type',							propID:'type_exp',			type:type_select
            ,hide_list:{
              'text':['this.generic_checktruevalue','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch'],
              'checkbox':['this.generic_maxchar','this.style_align','this.editable_field','this.editable_field','this.detail_field_stretch','this.generic_defaultvalue','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'radio':['this.generic_maxchar','this.style_align','this.editable_field','this.editable_field','this.detail_field_stretch','this.generic_defaultvalue','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'image':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.style_align','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'barcode':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.generic_barcode2d','this.generic_errorcorrection','this.style_align','this.detail_field_stretch','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.print_options_replicate','this.print_options_replicatenumber', 'this.style_globalfont','this.style_drawborder','this.generic_datatype'],
              'barcode2d':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.generic_barcode','this.style_align','this.detail_field_stretch','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.print_options_replicate','this.print_options_replicatenumber', 'this.style_globalfont','this.style_drawborder','this.generic_datatype'],
              'signsvg':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.style_align','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_barcode2d','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype']
            }
            ,show_list:{
              'text':['this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.style_align','this.style_globalfont','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_defaultvalue','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'checkbox':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.style_globalfont','this.style','this.generic_checkdefault','this.generic_groupCheck'],
              'radio':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.style_globalfont','this.style','this.generic_checkdefault','this.generic_groupCheck'],
              'image':['this.generic_defaultvalue'],
              'barcode':['this.generic_barcode','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.generic_defaultvalue'],
              'barcode2d':['this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.generic_defaultvalue'],
              'signsvg':['this.generic_defaultvalue']
            }
            ,defaultValue:'text'
            ,noteditable:true
          },
          {name:'default value',			propID:'defaultvalue',	type:'str',		tooltip:'Default value suggested in PDF textual AcroField',		defaultValue:''},
          {name:'group identifier',			propID:'groupCheck',		type:'str',			tooltip:'Identifier to group checkbox and radio',		defaultValue:''},
          {name:'check default value',			propID:'checkdefault',		type:check_select,			tooltip:'Default value for checkbox',		defaultValue:''},
          {name:'specific TRUE value',			propID:'checktruevalue',		type:'str',			tooltip:'Value String for True',		defaultValue:''},
          {name:'barcode type',							propID:'barcode',			type:type_barcode,		tooltip:'Specify barcode type',		defaultValue:''},
          {name:'barcode type',							propID:'barcode2d',			type:type_barcode2d,		tooltip:'Specify barcode type',		defaultValue:''},
          {name:'QRCode Error correction',			propID:'errorcorrection',			type:'select[L,M,Q,H]',		tooltip:'QRCode Error Correction Type',	defaultValue:'L'},
          {name:'Type',			propID:'datatype',		type:datatype_select
            ,tooltip:'Data type of the DocField'
            ,defaultValue:'text'
            ,hide_list:{
              'number':['this.generic_maxchar'],
              'date':['this.generic_maxchar','this.generic_len', 'this.generic_dec'],
              'time':['this.generic_maxchar','this.generic_len', 'this.generic_dec'],
              'text':['this.generic_len', 'this.generic_dec'],
              'none':['this.generic_maxchar','this.generic_len', 'this.generic_dec'],
            }
            ,show_list:{
              'text':['this.generic_maxchar'],
              'number':['this.generic_len', 'this.generic_dec']
            }
          },
          {name:'Limit (text picture)',			propID:'lung',			type:'int'
            ,tooltip:'When this property is greater than 0, for Text data type, the XML data will be truncate to the indicated length, before applying the picture'
            ,defaultValue:0,	section:'Format',		disabled:true
          },
          {name:'length',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10', extraClass:'col-3'},
          {name:'decimals',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0', extraClass:'col-3'},
          {name:'global pictures',		propID:'globalpic',		type:'checkbox'
            ,hide_list:{'true':['this.generic_datapic']}
            ,show_list:{'false':['this.generic_datapic']}
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Pictures'
            ,defaultValue:true
            ,section:'Picture',		disabled:true
          },
          {name:'custom picture',			propID:'datapic',		type:'str',		tooltip:'Specify a picture to apply to the data of the DocField',		defaultValue:'',	section:'Picture',		disabled:true}
          ,
          {name:'editable',			propID:'editfield',		type:'checkbox',			tooltip:'Field is editable',		defaultValue:false, extraClass:'col-3'
            ,hide_list:{'false':['this.generic_obligatory']}
            ,show_list:{'true':['this.generic_obligatory']}
          },
          {name:'obligatory',				propID:'obligatory',		type:'checkbox',			tooltip:'Field compilation is required',		defaultValue:false, extraClass:'col-3'},
          {name:'max length',		propID:'maxchar',		type:'int',		tooltip:'Maximum number of characters',		defaultValue:0},
          {name:'obligatory condition',		propID:'oblcondition',		type:'str',			tooltip:'',		disabled:true,		defaultValue:''}
        ],
        layout:[
          {name:'',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10'},
          {name:'',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0'},
          {name:'',					propID:'picture',		type:'str',		disabled:true,		defaultValue:''}
        ],
        style:[
          {name:'text align',		propID:'align',			type:align_select,			tooltip:'Text alignment of the DocField',		defaultValue:'left',	section:"font"},
          {name:'global font',	propID:'globalfont',	type:'select[use global font:true,use custom font:false]'
            ,hide_list:{
              'true':['this.style_font','this.style_size','this.style_color','this.style_weight','this.style_effects'],
              'false':[]
            }
            ,show_list:{
              'true':[],
              'false':['this.style_font','this.style_size','this.style_color','this.style_weight','this.style_effects']
            }
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Font'
            ,defaultValue:true
            ,section:"font"
          },
          {name:'font',			propID:'font',		fontList:fonts_select,	type:'advanced-font',		tooltip:'Font applied when printing the current DocField',		defaultValue:'DejaVu Sans Condensed, sans-serif',	section:"font"},
          {name:'size',			propID:'size',		type:'str',		tooltip:'Font size applied when printing the current DocField',		defaultValue:'10pt',	extraClass:"col-3",	section:"font"},
          {name:'color',			propID:'color',		type:'color',		tooltip:'Font color applied when printing the current DocField',		defaultValue:'',	extraClass:"col-3",	section:"font"},
          {name:'style',			propID:'weight',		type:fonts_style,		tooltip:'Font style applied when printing the current DocField',		defaultValue:'normal',	extraClass:"col-3",	section:"font"},
          {name:'effects',		propID:'effects',	type:fonts_effect,		tooltip:'Font effects applied when printing the current DocField',		defaultValue:'',	extraClass:"col-3",	section:"font"},
          {name:'borders',	propID:'drawborder',	type:'select[show:true,hide:false]'
                ,hide_list:{
                  'true':[],
                  'false':['this.style_bordersempty','this.style_bordercolor','this.style_bordercontent','this.style_bordertop','this.style_borderbottom','this.style_borderleft','this.style_borderright','this.style_borderstroke']
                }
                ,show_list:{
                  'true':['this.style_bordersempty','this.style_bordercolor','this.style_bordercontent','this.style_bordertop','this.style_borderbottom','this.style_borderleft','this.style_borderright','this.style_borderstroke'],
                  'false':[]
                }
                ,defaultValue:false
                ,section:"borders"
          },
          {name:'top',	propID:'bordertop',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'bottom',	propID:'borderbottom',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'left',	propID:'borderleft',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'right',	propID:'borderright',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'width',	propID:'borderstroke',	type:'int',	defaultValue:1,	extraClass:"col-3",	section:"borders"},
          {name:'color',						propID:'bordercolor',	type:'color',	extraClass:"col-3",	section:"borders"},
          {name:'border to content',				propID:'bordercontent',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'borders empty fields',				propID:'bordersempty',		type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'Pixel Off color',			propID:'pixeloffcolor',			type:'color',	tooltip:'Color selected for Pixel OFF',	defaultValue:'#FFFFFF'},
          {name:'Pixel On color',			propID:'pixeloncolor',			type:'color',	tooltip:'Color selected for Pixel ON',	defaultValue:'#000000'}
        ]
      }
    };

    this.extend( this.stdObjClassLight, this.ZoneObjClassLight );


	this.ZoneObjClassLightQR={
      newProperties:{
        generic:[
          {name:'Object type',							propID:'type_exp',			type:type_select
            ,hide_list:{
              'text':['this.style', 'this.layout', 'this.notes', 'this.generic_checktruevalue','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor'],
              'checkbox':['this.style', 'this.layout', 'this.notes','this.generic_maxchar','this.generic_align','this.editable_field','this.editable_field','this.detail_field_stretch','this.generic_defaultvalue','this.generic_barcode','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'radio':['this.style', 'this.layout', 'this.notes','this.generic_maxchar','this.generic_align','this.editable_field','this.editable_field','this.detail_field_stretch','this.generic_defaultvalue','this.generic_barcode','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'image':['this.style', 'this.layout', 'this.notes','this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.generic_align','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'barcode':['this.style', 'this.layout', 'this.notes','this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.generic_align','this.detail_field_stretch','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.print_options_replicate','this.print_options_replicatenumber', 'this.style_globalfont','this.style_drawborder','this.generic_datatype'],
              'signsvg':['this.style', 'this.layout', 'this.notes','this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.generic_align','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype']
            }
            ,show_list:{
              'text':['this.generic_editfield','this.generic_obligatory','this.generic_maxchar','this.generic_align','this.style_globalfont','this.detail_field_stretch','this.editable_field','this.editable_field','this.generic_defaultvalue','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype'],
              'checkbox':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.style_globalfont','this.generic_checkdefault','this.generic_groupCheck'],
              'radio':['this.generic_checktruevalue','this.generic_editfield','this.generic_obligatory','this.style_globalfont','this.generic_checkdefault','this.generic_groupCheck'],
              'image':['this.generic_defaultvalue'],
              'barcode':['this.generic_barcode','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.generic_defaultvalue'],
              'signsvg':['this.generic_defaultvalue']
            }
            ,defaultValue:'text'
            ,disabled:true
          },
		  {name:'fAreaParentKey',				propID:'fAreaParentKey',		type:'str', defaultValue:'', disabled:true},
          {name:'default value',			propID:'defaultvalue',	type:'str',		tooltip:'Default value suggested in PDF textual AcroField',		defaultValue:''},
          {name:'group identifier',			propID:'groupCheck',		type:'str',			tooltip:'Identifier to group checkbox and radio',		defaultValue:''},        
          {name:'check default value',			propID:'checkdefault',		type:check_select,			tooltip:'Default value for checkbox',		defaultValue:''},
          {name:'specific TRUE value',			propID:'checktruevalue',		type:'str',			tooltip:'Value String for True',		defaultValue:''},
          {name:'barcode type',							propID:'barcode',			type:type_barcode,		tooltip:'Specify barcode type',		defaultValue:''},
          {name:'QRCode Error correction',			propID:'errorcorrection',			type:'select[L,M,Q,H]',		tooltip:'QRCode Error Correction Type',	defaultValue:'L'},
          {name:'Type',			propID:'datatype',		type:datatype_select
            ,tooltip:'Data type of the DocField'
            ,defaultValue:'text'
            ,hide_list:{
              'number':['this.generic_maxchar'],
              'date':['this.generic_maxchar','this.generic_len', 'this.generic_dec'],
              'time':['this.generic_maxchar','this.generic_len', 'this.generic_dec'],
              'text':['this.generic_len', 'this.generic_dec'],
              'none':['this.generic_maxchar','this.generic_len', 'this.generic_dec'],
            }
            ,show_list:{
              'text':['this.generic_maxchar'],
              'number':['this.generic_len', 'this.generic_dec']
            }
			, extraClass:"col-3"
          },
          {name:'text align',		propID:'align',			type:align_select,			tooltip:'Text alignment of the DocField',		defaultValue:'left', extraClass:"col-3"},
		  {name:'Limit (text picture)',			propID:'lung',			type:'int'
            ,tooltip:'When this property is greater than 0, for Text data type, the XML data will be truncate to the indicated length, before applying the picture'
            ,defaultValue:0, section:'Format',		disabled:true
          },
          {name:'length',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10', extraClass:'col-3'},
          {name:'decimals',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0', extraClass:'col-3'},
          {name:'global pictures',		propID:'globalpic',		type:'checkbox'
            ,hide_list:{'true':['this.generic_datapic']}
            ,show_list:{'false':['this.generic_datapic']}
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Pictures'
            ,defaultValue:true
            ,section:'Picture',		disabled:true
          },
          {name:'custom picture',			propID:'datapic',		type:'str',		tooltip:'Specify a picture to apply to the data of the DocField',		defaultValue:'', section:'Picture',		disabled:true}
          ,
		  {name:'max length',		propID:'maxchar',		type:'int',		    tooltip:'Maximum number of characters',		defaultValue:0},
          {name:'editable',			propID:'editfield',		type:'checkbox',			tooltip:'Field is editable',		defaultValue:false, extraClass:'col-3'  
            ,hide_list:{'false':['this.generic_obligatory']}
            ,show_list:{'true':['this.generic_obligatory']}
          },
          {name:'obligatory',				propID:'obligatory',		type:'checkbox',			tooltip:'Field compilation is required',		defaultValue:false, extraClass:'col-3'},
          {name:'obligatory condition',		propID:'oblcondition',		type:'str',			tooltip:'',		disabled:true,		defaultValue:''}
        ],
        layout:[
          {name:'',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10'},
          {name:'',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0'},
          {name:'',					propID:'picture',		type:'str',		disabled:true,		defaultValue:''}
        ],
        style:[
          {name:'text align',		propID:'align',			type:align_select,			tooltip:'Text alignment of the DocField',		defaultValue:'left',	section:"font",		disabled:true},
          {name:'global font',	propID:'globalfont',	type:'select[use global font:true,use custom font:false]'
            ,hide_list:{
              'true':['this.style_font','this.style_size','this.style_color','this.style_weight','this.style_effects'],
              'false':[]
            }
            ,show_list:{
              'true':[],
              'false':['this.style_font','this.style_size','this.style_color','this.style_weight','this.style_effects']
            }
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Font'
            ,defaultValue:true
            ,	section:"font"
			,		disabled:true
          },
          {name:'font',			propID:'font',		fontList:fonts_select,	type:'advanced-font',		tooltip:'Font applied when printing the current DocField',		defaultValue:'DejaVu Sans Condensed, sans-serif',	section:"font",		disabled:true},
          {name:'size',			propID:'size',		type:'str',		tooltip:'Font size applied when printing the current DocField',		defaultValue:'10pt',	extraClass:"col-3",	section:"font",		disabled:true},
          {name:'color',			propID:'color',		type:'str',		tooltip:'Font color applied when printing the current DocField',		defaultValue:'',	extraClass:"col-3",	section:"font",		disabled:true},
          {name:'style',			propID:'weight',		type:fonts_style,		tooltip:'Font style applied when printing the current DocField',		defaultValue:'normal',	extraClass:"col-3",	section:"font",		disabled:true},
          {name:'effects',		propID:'effects',	type:fonts_effect,		tooltip:'Font effects applied when printing the current DocField',		defaultValue:'',	extraClass:"col-3",	section:"font",		disabled:true},
          {name:'borders',	propID:'drawborder',	type:'select[show:true,hide:false]'
                ,hide_list:{
                  'true':[],
                  'false':['this.style_bordersempty','this.style_bordercolor','this.style_bordercontent','this.style_bordertop','this.style_borderbottom','this.style_borderleft','this.style_borderright','this.style_borderstroke']
                }
                ,show_list:{
                  'true':['this.style_bordersempty','this.style_bordercolor','this.style_bordercontent','this.style_bordertop','this.style_borderbottom','this.style_borderleft','this.style_borderright','this.style_borderstroke'],
                  'false':[]
                }
                ,defaultValue:false
                ,section:"borders"
				,		disabled:true
          },
          {name:'top',	propID:'bordertop',	type:'checkbox', defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'bottom',	propID:'borderbottom',	type:'checkbox', defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'left',	propID:'borderleft',	type:'checkbox', defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'right',	propID:'borderright',	type:'checkbox', defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'width',	propID:'borderstroke',	type:'int', defaultValue:1,	extraClass:"col-3",	section:"borders"},
          {name:'color',						propID:'bordercolor',	type:'color',	extraClass:"col-3",	section:"borders"},
          {name:'border to content',				propID:'bordercontent',	type:'checkbox', defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'borders empty fields',				propID:'bordersempty',		type:'checkbox', defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'Pixel Off color',			propID:'pixeloffcolor',			type:'color',	tooltip:'Color selected for Pixel OFF',	defaultValue:'#FFFFFF'},
          {name:'Pixel On color',			propID:'pixeloncolor',			type:'color',	tooltip:'Color selected for Pixel ON',	defaultValue:'#000000'}
        ]
      }
    };
    this.extend( this.stdObjClassLightQR, this.ZoneObjClassLightQR );
	

    this.ZoneObjClass={
      helper : {
        description : 'Object identifying zone of PDF where insert data',
        //,usage : 'Fill the Expression field, and select the Barcode type',
        'text': {
          description :'Object identifying zone of PDF where insert data as text'
          //,usage:''
        },
        'checkbox': {
          description :'Object identifying zone of PDF where insert data as checkbox'
          //,usage:''
        },
        'radio': {
          description :'Object identifying zone of PDF where insert data as radio button'
          //,usage:''
        },
        'image': {
          description :'Object identifying zone of PDF where insert data as image'
          //,usage:''
        },
        'barcode': {
          description :'Object identifying zone of PDF where insert data as barcode'
          //,usage:''
        },
        'barcode2d': {
          description :'Object identifying zone of PDF where insert data as barcode 2d'
          //,usage:''
        },
        'signsvg': {
          description :'Object identifying zone of PDF where insert data as barcode SVG graphic'
          ,usage:'The data must be : <ul><li>an SVG string</li><li> or a string ending with .svg, indicating a file path</li></ul>'
        }
      },
      newProperties:{
        generic:[
          {name:'type',							propID:'type_exp',			type:type_select
            ,hide_list:{
              'text':['this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch'],
              'checkbox,radio':['this.functional_maxchar','this.style_align','this.editable_field','this.editable_field','this.detail_field_stretch','this.generic_defaultvalue','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype', 'this.generic_lung', 'this.generic_globalpic', 'this.generic_datapic'],
              'image':['this.functional','this.functional_maxchar','this.style_align','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype', 'this.generic_lung', 'this.generic_globalpic', 'this.generic_datapic'],
              'barcode':['this.generic_editfield','this.functional','this.functional_maxchar','this.generic_barcode2d','this.generic_errorcorrection','this.style_align','this.detail_field_stretch','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.print_options_replicate','this.print_options_replicatenumber', 'this.style_globalfont','this.style_drawborder','this.generic_datatype', 'this.generic_lung'],
              'barcode2d':['this.generic_editfield','this.functional','this.functional_maxchar','this.generic_barcode','this.style_align','this.detail_field_stretch','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.print_options_replicate','this.print_options_replicatenumber', 'this.style_globalfont','this.style_drawborder','this.generic_datatype', 'this.generic_lung'],
              'signsvg':['this.generic_editfield','this.style_align','this.functional_maxchar','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_checkdefault','this.generic_groupCheck','this.generic_barcode','this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype', 'this.generic_lung', 'this.generic_globalpic', 'this.generic_datapic']
            }
            ,show_list:{
              'text':['this.generic_editfield','this.functional','this.functional_maxchar','this.style_align','this.style_globalfont','this.detail_field_stretch','this.style','this.editable_field','this.editable_field','this.generic_defaultvalue','this.print_options_replicate','this.print_options_replicatenumber','this.generic_datatype', 'this.generic_lung', 'this.generic_globalpic', 'this.generic_datapic'],
              'checkbox,radio':['this.generic_editfield','this.functional','this.style_globalfont','this.style','this.generic_checkdefault','this.generic_groupCheck'],
              'image':['this.generic_defaultvalue'],
              'barcode':['this.generic_barcode','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.generic_defaultvalue'],
              'barcode2d':['this.generic_barcode2d','this.generic_errorcorrection','this.style_pixeloffcolor','this.style_pixeloncolor','this.style_barcodestretch','this.generic_defaultvalue'],
              'signsvg':['this.generic_defaultvalue']
            }
            ,tooltip:'Specify how printing the field'
            ,defaultValue:'text'
            ,noteditable:true
            ,disabled:true
          },
          {name:'default value',			propID:'defaultvalue',	type:'str',		tooltip:'Default value suggested in PDF textual AcroField',		defaultValue:''},
          {name:'check default value',			propID:'checkdefault',		type:check_select,			tooltip:'Default value for checkbox',		defaultValue:''},
          {name:'specific TRUE value',			propID:'checktruevalue',		type:'str',			tooltip:'Value String for True',		defaultValue:'', disabled:true},
          {name:'barcode type',							propID:'barcode',			type:type_barcode,		tooltip:'Specify barcode type',		defaultValue:''},
          {name:'barcode type',							propID:'barcode2d',			type:type_barcode2d,		tooltip:'Specify barcode type',		defaultValue:''},
          {name:'QRCode Error correction',			propID:'errorcorrection',			type:'select[L,M,Q,H]',		tooltip:'QRCode Error Correction Type',	defaultValue:'L'},
          {name:'editable field',			section:'Format',  propID:'editfield',		type:'checkbox',			tooltip:'As true, the field will be always editable (as empty or not) when printing in editable mode',		defaultValue:false},
          {name:'Type',			propID:'datatype',		type:datatype_select
            ,tooltip:'Data type of the DocField'
            ,defaultValue:'text'
            ,section:'Format'
			,extraClass:"col-3"
          },
          {name:'Limit (text picture)',			propID:'lung',			type:'int'
            ,tooltip:'When this property is greater than 0, for Text data type, the XML data will be truncate to the indicated length, before applying the picture'
            ,defaultValue:0, section:'Format', extraClass:"col-3"
          },
		  
          {name:'',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10',	section:'Format'},
          {name:'',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0',	section:'Format'},
          {name:'global pictures',		propID:'globalpic',		type:'checkbox'
            ,hide_list:{'true':['this.generic_datapic']}
            ,show_list:{'false':['this.generic_datapic']}
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Pictures'
            ,defaultValue:true
            ,section:'Picture', extraClass:"col-3"
          },
          {name:'custom picture',			propID:'datapic',		type:'str',		tooltip:'Specify a picture to apply to the data of the DocField',		defaultValue:'', section:'Picture', extraClass:"col-3"}
        ],
        layout:[
          {name:'',					propID:'len',			type:'int',		disabled:true,		defaultValue:'10'},
          {name:'',					propID:'dec',			type:'int',		disabled:true,		defaultValue:'0'},
          {name:'',					propID:'picture',		type:'str',		disabled:true,		defaultValue:''},
          {name:'area',				propID:'area',			section:'area',	type:'str',		noteditable:true,			tooltip:'Name of the Area containing the DocField',		defaultValue:''},
          {name:'num. layer',			propID:'layer',			section:'area',	type:'int',		noteditable:true,			tooltip:'Layer of the Area containing the DocField',		defaultValue:0}
        ],
        print_options:[
          {name:'',								propID:'onlyfirst',			type:'checkbox',	disabled:true,		defaultValue:false},
          {name:'',								propID:'onlylast',			type:'checkbox',	disabled:true,		defaultValue:false},
          {name:'optical recognition fields',		section:'optical recognition', propID:'replicate',			type:'checkbox'
            ,tooltip:'When this property is selected, the value of the DocField will be spelt out and each token will be printed in a new cell',		defaultValue:false},
          {name:'Max optical recognition number',	section:'optical recognition', propID:'replicatenumber',	type:'int'
            ,tooltip:'Maximum number of cell available when printing the DocField as an Optical Recognition Field'
            ,defaultValue:2
          }
        ],
        style:[
          {name:'text align',		propID:'align',			type:align_select,			tooltip:'Text alignment of the DocField',		defaultValue:'left',	section:"font"},
          {name:'global font',	propID:'globalfont',	type:'select[use global font:true,use custom font:false]'
            ,hide_list:{
              'true':['this.style_font','this.style_size','this.style_color','this.style_weight','this.style_effects'],
              'false':[]
            }
            ,show_list:{
              'true':[],
              'false':['this.style_font','this.style_size','this.style_color','this.style_weight','this.style_effects']
            }
            ,tooltip:'When this property is selected, the DocField will be printed using the Global Font'
            ,defaultValue:true
            ,	section:"font"
          },
          {name:'font',			propID:'font',		fontList:fonts_select,	type:'advanced-font',		tooltip:'Font applied when printing the current DocField',		defaultValue:'DejaVu Sans Condensed, sans-serif',	section:"font"},
          {name:'size',			propID:'size',		type:'str',		tooltip:'Font size applied when printing the current DocField',		defaultValue:'10pt',	extraClass:"col-3",	section:"font"},
          {name:'color',			propID:'color',		type:'color',		tooltip:'Font color applied when printing the current DocField',		defaultValue:'',	extraClass:"col-3",	section:"font"},
          {name:'style',			propID:'weight',		type:fonts_style,		tooltip:'Font style applied when printing the current DocField',		defaultValue:'normal',	extraClass:"col-3",	section:"font"},
          {name:'effects',		propID:'effects',	type:fonts_effect,		tooltip:'Font effects applied when printing the current DocField',		defaultValue:'',	extraClass:"col-3",	section:"font"},
          {name:'borders',	propID:'drawborder',	type:'select[show:true,hide:false]'
                ,hide_list:{
                  'true':[],
                  'false':['this.style_bordersempty','this.style_bordercolor','this.style_bordercontent','this.style_bordertop','this.style_borderbottom','this.style_borderleft','this.style_borderright','this.style_borderstroke']
                }
                ,show_list:{
                  'true':['this.style_bordersempty','this.style_bordercolor','this.style_bordercontent','this.style_bordertop','this.style_borderbottom','this.style_borderleft','this.style_borderright','this.style_borderstroke'],
                  'false':[]
                }
                ,defaultValue:false
                ,section:"borders"
          },
          {name:'top',	propID:'bordertop',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'bottom',	propID:'borderbottom',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'left',	propID:'borderleft',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'right',	propID:'borderright',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'width',	propID:'borderstroke',	type:'int',	defaultValue:1,	extraClass:"col-3",	section:"borders"},
          {name:'color',						propID:'bordercolor',	type:'color',	extraClass:"col-3",	section:"borders"},
          {name:'border to content',				propID:'bordercontent',	type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'borders empty fields',				propID:'bordersempty',		type:'checkbox',	defaultValue:true,	extraClass:"col-3",	section:"borders"},
          {name:'Pixel Off color',			propID:'pixeloffcolor',			type:'color',	tooltip:'Color selected for Pixel OFF',	defaultValue:'#FFFFFF'},
          {name:'Pixel On color',	propID:'pixeloncolor',	type:'color',	tooltip:'Color selected for Pixel ON',	defaultValue:'#000000'},
          {name:'scale to frame size',	propID:'barcodestretch',	type:'checkbox',	tooltip:'Indicating whether a barcode resizes to fit the size of the barcode frame',	defaultValue:true}
        ],
        detail_field:[
          {name:'detail field',			propID:'detail',					type:'checkbox',			tooltip:'When this property is selected, the current DocField will be reprinted in the page'
            ,hide_list:{'unchecked':['this.detail_field_detailnumber','this.detail_field_stretch','this.detail_field_verticaldelta','this.detail_field_printblock']}
            ,show_list:{'checked':['this.detail_field_detailnumber','this.detail_field_stretch','this.detail_field_verticaldelta']}
            ,defaultValue:false
          },
          {name:'occurence number',													propID:'detailnumber',		type:'int'
            ,tooltip:'Specify how many times the current DocField will be reprinted in the page',		defaultValue:0, extraClass:"col-3"},
          {name:'work zone vertical delta (rulers unit)',		propID:'verticaldelta',		type:'int',		convertFunc:'convertUnit',		reconvertFunc:'reconvertUnit',		validFunc:'validUnitV'
            ,tooltip:'Vertical distance between every instance of the current DocField'
            ,defaultValue:0 ,extraClass:"col-3"
          },
          {name:'split with overflow',											propID:'stretch',					type:'checkbox',			tooltip:''
            ,hide_list:{'unchecked':['this.detail_field_printblock']}
            ,show_list:{'checked':['this.detail_field_printblock']}
            ,defaultValue:false, extraClass:"col-3"
          },
          {name:'print as block',				propID:'printblock',	type:'checkbox',			tooltip:'',		defaultValue:false ,extraClass:"col-3"},
        ],
        editable_field:[
          {name:'format',					propID:'format',				type:format_select
            ,hide_list:{
              'none':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                      'this.editable_field_numbernegativeStyle','this.editable_field_dateformat','this.editable_field_timeformat',
                      'this.editable_field_specialformat','this.editable_field_customformat'],
              'number':['this.editable_field_dateformat','this.editable_field_timeformat','this.editable_field_specialformat','this.editable_field_customformat'],
              'percentage':['this.editable_field_dateformat','this.editable_field_timeformat','this.editable_field_specialformat','this.editable_field_customformat',
                            'this.editable_field_numbercurrencyStyle'],
              'date':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                      'this.editable_field_numbernegativeStyle','this.editable_field_timeformat',
                      'this.editable_field_specialformat'],
              'time':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                      'this.editable_field_numbernegativeStyle','this.editable_field_dateformat',
                      'this.editable_field_specialformat'],
              'special':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                      'this.editable_field_numbernegativeStyle','this.editable_field_dateformat','this.editable_field_timeformat',
                      'this.editable_field_customformat']
            }
            ,show_list:{'none':[],
                        'number':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle','this.editable_field_numbercurrencyStyle',
                                  'this.editable_field_numbernegativeStyle'],
                        'percentage':['this.editable_field_numberformatdec','this.editable_field_numberseperatorStyle',
                                      'this.editable_field_numbernegativeStyle'],
                        'date':['this.editable_field_dateformat','this.editable_field_customformat'],
                        'time':['this.editable_field_timeformat','this.editable_field_customformat'],
                        'special':['this.editable_field_specialformat']
            }
            ,tooltip:'Specify editable PDF AcroField format'
            ,defaultValue:'none'
          },
          {name:'number decimal places',		propID:'numberformatdec',		type:'int',		tooltip:'Specify editable numeric PDF AcroField decimal digits',		defaultValue:2},
          {name:'number separator style',		propID:'numberseperatorStyle',		type:numberseperator_select,		convertFunc:'changeToComma'
            ,tooltip:'Specify editable numeric PDF AcroField separator style'
            ,defaultValue:'1234;56'
          },
          {name:'number currency',		propID:'numbercurrencyStyle',		type:numbercurrency_select,		tooltip:'Specify editable numeric PDF AcroField currency',		defaultValue:'none'},
          {name:'negative number style',		propID:'numbernegativeStyle',		type:numbernegative_select
            ,tooltip:'Specify editable numeric PDF AcroField negative number style',		defaultValue:'minus'},
          {name:'date format',			propID:'dateformat',			type:dateformat_select,		convertFunc:'convertToLowerCase'
            ,tooltip:'Specify editable date PDF AcroField format',		defaultValue:'m/d'},
          {name:'time format',			propID:'timeformat',			type:timeformat_select,		convertFunc:'convertToLowerCase', tooltip:'Specify editable Time PDF AcroField format',		defaultValue:'HH:MM'},
          {name:'special format',			propID:'specialformat',			type:specialformat_select,		tooltip:'Specify editable special PDF AcroField format',		defaultValue:'Zip Code'},
          {name:'custom mask format',		propID:'customformat',			type:'str',		tooltip:'Specify editable custom PDF AcroField format for the pre-selected format',		defaultValue:''},
          {section:'for text field', name:'max characters number',		propID:'maxchar',		type:'int',		tooltip:'Maximum number of characters that the user can insert in PDF textual AcroField',		defaultValue:0, extraClass:"col-3"},
          {section:'for text field', name:'multi line',				propID:'multiline',		type:'checkbox',		tooltip:'When this property is selected, the PDF textual AcroField allows multi lines edit',		defaultValue:false, extraClass:"col-3"},
          {name:'',						propID:'scroll',		type:'checkbox', disabled:true,		tooltip:'',		defaultValue:false}
        ],
        notes:[
          {name:'user notes',				propID:'note',				type:'str',			tooltip:'User notes',			defaultValue:'',	buttons:'edit',	actions:'EditEUNotes()'}
        ]
      }
    };
    this.extend( this.stdObjClass, this.ZoneObjClass );

    this.fieldObjClass={
      newProperties:{
        generic:[
          {name:'name',		propID:'name',		type:'str',			tooltip:'Unique identifier for the Field in the current module',	validFunc:'validXMLName'},
          {name:'x',			propID:'x',			type:'int',			tooltip:'X coordinate',	extraClass:"col-3"},
          {name:'y',			propID:'y',			type:'int',			tooltip:'Y coordinate',	extraClass:"col-3"},
          {name:'w',			propID:'w',			type:'int',			tooltip:'Width',	extraClass:"col-3"},
          {name:'h',			propID:'h',			type:'int',			tooltip:'Height',	extraClass:"col-3"}
        ]
      }
    };

    this.OmrObjClass={
      helper : {
        description : 'Object identifying zone of PDF where insert OMR (optical mark recognition)'
      },
      newProperties:{
        generic:[
          {name:'color',			propID:'color',			type:'str',		tooltip:'Omr color on pdf',	defaultValue:'#000000'}
        ]
      }
    };

    this.extend( this.stdObjClass, this.OmrObjClass );

    this.signMarkObjClass={
      helper : {
        description : 'Signature Markup Object - Insert in the "PDF Catalog" a markup for document future signatures'+
        '<br>Markups are insert as JSON Array with "it.zucchetti.signatures" as key in the document information catalog'
      },
      newProperties:{
        generic:[
          {name:'title',				propID:'title',					section:'signature', type:'str',					defaultValue:'',	tooltip:'Sign markup title/description'},
		      {name:'group',				propID:'group',			    section:'signature', type:'str',			defaultValue:'',  tooltip:'Sign markup group',		validFunc:'validXMLSignName' ,	extraClass:"col-3"},
          {name:'type',				  propID:'signtype',			section:'signature', type:sign_select,					defaultValue:'',	tooltip:'Sign markup type',	extraClass:"col-3"},
          {name:'obligatory',		propID:'brequired',			section:'signature', type:'select[required:true,not required:false]',			defaultValue:'false',	tooltip:'Signature is required or not in the final document',	extraClass:"col-3"},
          {name:'sequence',			propID:'sequence',			section:'signature',	type:'int',			tooltip:'Specify the order in which signature will be required',	extraClass:"col-3"},
          {name:'date format',	propID:'dateformat',		section:'Date and Time',	type:'select[None,dd-MM-yyyy,dd/MM/yyyy,yyyy-MM-dd,yyyy/MM/dd]',	convertFunc:'convertDateTimeUpperCase',	defaultValue:'None',	tooltip:'Set custom date format for the signature date',	extraClass:"col-3"},
          {name:'time format',	propID:'timeformat',		section:'Date and Time',	type:'select[None,HH:mm,HH:mm:ss,HH.mm,HH.mm.ss]',	convertFunc:'convertDateTimeLowerCase',	defaultValue:'None',	tooltip:'Set custom time format for the signature hour',	extraClass:"col-3"},
          {name:'geo position',	propID:'bgeoposition',	section:'geographic',	type:'select[required:true,not required:false]',			defaultValue:'false',	tooltip:'Geo position for the signature is required or not',	extraClass:"col-3"},
          {name:'geo position and date',				section:'geographic', propID:'bhideextra',		type:'select[show:true,hide:false]',			defaultValue:'false',	tooltip:'Geo position and date visibile or not',	extraClass:"col-3"}

        ]
      }
    };
    this.extend( this.stdObjClass, this.signMarkObjClass );

    this.signMarkObjClassLight={
      helper : {
        description : 'Signature Markup Object - Insert in the "PDF Catalog" a markup for document future signatures'+
        '<br>Markups are insert as JSON Array with "it.zucchetti.signatures" as key in the document information catalog'
      },
      newProperties:{
        generic:[
          {name:'title',				propID:'title',					section:'signature',	type:'str',					defaultValue:'',	tooltip:'Sign markup title/description'},
          {name:'signature',		propID:'brequired',			section:'signature',	type:'select[required:true,not required:false]',			defaultValue:'false',	tooltip:'Signature is required or not in the final document',	extraClass:"col-3"},
          {name:'sequence',			propID:'sequence',			section:'signature',	type:'int',			tooltip:'Specify the order in which signature will be required',	extraClass:"col-3"},
          {name:'date format',	propID:'dateformat',		section:'Date and Time',	type:'select[None,dd-MM-yyyy,dd/MM/yyyy,yyyy-MM-dd,yyyy/MM/dd]',	convertFunc:'convertDateTimeUpperCase',	defaultValue:'None',	tooltip:'Set custom date format for the signature date',	extraClass:"col-3"},
          {name:'time format',	propID:'timeformat',		section:'Date and Time',	type:'select[None,HH:mm,HH:mm:ss,HH.mm,HH.mm.ss]',	convertFunc:'convertDateTimeLowerCase',	defaultValue:'None',	tooltip:'Set custom time format for the signature hour',	extraClass:"col-3"},
          {name:'geo position',	propID:'bgeoposition',	section:'geographic',	type:'select[required:true,not required:false]',			defaultValue:'false',	tooltip:'Geo position for the signature is required or not',	extraClass:"col-3"},
          {name:'geo position and date',				section:'geographic', propID:'bhideextra',		type:'select[show:true,hide:false]',			defaultValue:'false',	tooltip:'Geo position and date visibile or not',	extraClass:"col-3"}
        ]
      }
    };
    this.extend( this.stdObjClassLight, this.signMarkObjClassLight );

    this.searchObjClass={
      newProperties:{
        search:[
          {name:'Find',									propID:'sfind',				type:'str',				buttons:'search',			actions:'KeyFind()'},
          // {name:'As constant',					propID:'cconstant',		type:'checkbox',	extraClass:"col-3"},
          // {name:'As expresssion',				propID:'cexpression',	type:'checkbox',	extraClass:"col-3"},
          {name:'whole word',						propID:'cwword',			type:'checkbox',	extraClass:"col-3"},
          {name:'Case sensitive',				propID:'ccsensitive',	type:'checkbox',	extraClass:"col-3"}
        ],
        results:[]
      }
    };

    this.formObj = function () {
      if ( msimplesheet == true ) {
        this.objClass = ZTObjects.formObjClassLight;
      }
	  else if ( msimplesheetqr == true ) {
        this.objClass = ZTObjects.formObjClassLightQR;
      }
      else {
        this.objClass = ZTObjects.formObjClass;
      }

      //Generic
      this.height = 600;
      this.width = 600;
      this.proportions = "false";
      this.description = "";
      this.file = "";
      this.fldfile = "";

      //View
      this.rulers = "mm";
      this.hsl = false;
      this.lock_items = false;

      //Global Font
      this.font = "DejaVu Sans Condensed, sans-serif";
      this.size = "10px";
      this.color = "";
      this.style = "normal";
      this.effects = "";

      //Global pictures
      this.datepic = "DD-MM-YYYY";
      this.timepic = "hh:mm:ss";
      this.textpic = "";
      this.numpic = "999999999.99";

      //Non visibili
      this.version = version;
      this.v_line = 0;
      this.page = 0;
      this.type = "module";
      this.maxcount = 0;
    }

    this.imgObj = function (id, name,	type, html, value, shadow, pos, x, y, h, w, localsrc, src) {
      this.objClass = ZTObjects.imgObjClass;
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;
      this.x = x;
      this.y = y;
      this.localsrc = localsrc;
      this.pos = pos;

      //Generic
      this.name = name;
      this.h = h;
      this.w = w;
      this.src = src;
      this.rotation = "0";
    }

    var maxchar = 20;

    this.fieldObj = function (id, name,	type, html, value, shadow, x, y, w, h, group, fname, desc) {
      this.objClass = ZTObjects.fieldObjClass;
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;

      //Generic
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;

      //Non visibili
      this.group = group;
      this.fname = fname;
      this.desc = desc;
      this.show = true;

      var dtitle = "Field: " + this.fname + "\n";
      dtitle += "Type: " + this.type + " (" + this.len + "," + this.dec + ")\n";
      dtitle += "Group: " + this.groupDesc;

      this.html = '<div id="item' + nitem + '" data-attr="' + nitem + '" data-title="' + dtitle + '" class="transparent-';
      if (this.detail) {
        this.html += 'detail';
      }
      else {
        this.html += 'field';
      }
      this.html += '" title="' + dtitle + '"';
      this.html+=' style="z-index:1; overflow:hidden; top:' + this.y + 'px; left:' + this.x + 'px;"';
      this.html+=' onmouseenter="drawDragShadow(event,\'' + this.id + '\')" >';

      // contenitore descrizioni
      this.html += '<div class="intcontainer';
      if (this.detail) {
        this.html += ' intdetail';
      }
      this.html += '">';

      var maxl = 35;
      if (this.detail) {
        maxl = 25;
      }
      var mname = this.desc;
      if (this.desc.length > maxl) {
        mname = this.desc.substring(0, maxl - 1) + "...";
      }
      // primo div interno
      this.html += '<div id="' + this.id + '_int" class="fldint">';
      this.html += ToHTML(mname);
      this.html += '</div>';
      // secondo div interno
      mname = this.fname;
      if (this.fname.length > maxl) {
        mname = this.fname.substring(0, maxl - 1) + "...";
      }
      this.html += '<div id="' + this.id + '_int_2" class="fldint2" >';
      this.html += ToHTML(mname);
      this.html += '</div></div>';
      // immagine tipo
      this.html += '<div class="typecontainer';
      if (this.detail) {
        this.html += ' typedetail';
      }
      this.html += '"';
      var micon = "&#xe";
      switch (this.type) {
        case "M":
          micon += "700";
          break;
        case "N":
          micon += "6b6";
          break;
        case "D":
          micon += "64e";
          break;
        case "T":
          micon += "648";
          break;
        case "I":
          micon += "60c";
          break;
        case "L":
          micon += "738";
          break;
        default: // C
          micon += "700";
          break;
      }

      this.html += ' icon-data="' + String.fromCharCode(parseInt(micon.substring(3,7),16));
      if (this.detail) {
        micon = "&#xe71b";
        this.html += ' ' + String.fromCharCode(parseInt(micon.substring(3,7),16));
      }
      this.html += '" ></div>';
      // generazione span x lunghezza - se memo o 20+ caratteri metto una linea continua
      if (this.type == "M" || this.len > maxchar) {
        this.html += '<span class="transparent-len"></span>';
      }
      else {
        for (var i = 0; i < this.len; i++) {
          this.html += '<span class="transparent-len-gap"></span>';
        }
      }
      this.html += '</div>';
    }

    this.ZoneObj = function (id, name,	type, html, value, shadow, x, y, h, w) {
      function mergePropertiesDefaultValue(obj) {
        if (ZTObjects.ZoneObjClass.newProperties) {
          var mainObject = obj;
          mainObject.objClass.properties = new Array();
          var tab, ii;
          for (var i in mainObject.objClass.newProperties) {
            tab = mainObject.objClass.newProperties[i];
            for (ii = 0; ii < tab.length; ii++) {
              if ( mainObject[tab[ii].propID] == undefined) {
                mainObject[tab[ii].propID] = tab[ii].defaultValue;
              }
            }
          }
        }
      }
      if (msimplesheet == true) {
        this.objClass = ZTObjects.ZoneObjClassLight;
        initPropertiesDefaultValue(this);
        mergePropertiesDefaultValue(this);
      }
	  else if (msimplesheetqr == true) {
        this.objClass = ZTObjects.ZoneObjClassLightQR;
        initPropertiesDefaultValue(this);
        mergePropertiesDefaultValue(this);
      }
      else {
        this.objClass = ZTObjects.ZoneObjClass;
        initPropertiesDefaultValue(this);
      }
      this.id = id;
      this.type = type;
      this.typeName = "DocField";
      this.html = html;
      this.shadow = shadow;
      this.value = value;

      //Generic
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;

      //style
      //Format Picture
      //Print options
      //Detail Field
      //Editable Field
      //Field
      //Editable text field

      //Non visibili
      this.exp = " ";
      this.page = docpageindex;
      if (clCanvasLib != null) {
        this.scale = clCanvasLib.scale;
      }
      else {
        this.scale = CanvasLib.scale;
      }
      this.show = true;
    }

    this.AreaObj = function (id, name, type, html, value, shadow, x, y, h, w) {
	  if (msimplesheetqr == true)
        this.objClass = ZTObjects.AreaObjClassLightQR;
	  else 
      this.objClass = ZTObjects.AreaObjClass;
      initPropertiesDefaultValue(this);
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;

      //Generic
      this.name = name;
      this.layer = 1;
      this.nlayers = 1;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;

      //Detail fields
      //Horizontal Fields

      //Non visibili
      this.page = docpageindex;
      if (clCanvasLib != null) {
        this.scale = clCanvasLib.scale;
      }
      else {
        this.scale = CanvasLib.scale;
      }
      this.show = true;
    }

    this.OmrObj = function (id, name,	type, html, value, shadow, x, y, w, h) {
      this.objClass = ZTObjects.OmrObjClass;
      initPropertiesDefaultValue(this);
      this.id = id;
      this.type = type;
      this.html = html;
      this.value = value;
      this.shadow = shadow;

      //Generic
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;

      this.page = docpageindex;
      if (clCanvasLib != null) {
        this.scale = clCanvasLib.scale;
      }
      else {
        this.scale = CanvasLib.scale;
      }
      this.show = true;
      this.html = '<div id=\'' + this.id + '\' style=\'z-index:1;border:' + 0 + 'px solid #000000;margin:0;position:absolute;top:' + this.y + 'px;left:' + this.x + 'px;width:' + this.w + 'px;height:' + this.h + 'px;background-color:' + this.color + ';\' onselectstart="noDefaultDrag(event)" onclick=\'clickItem(event)\'><img src="../visualweb/images/trasparent.gif" width="100%" height="100%"/></div>'
    }

    this.signMarkObj = function(id, name,	type, x, y, w, h) {
      if ( msimplesheet == true ) {
        this.objClass = ZTObjects.signMarkObjClassLight;
      }
      else {
        this.objClass = ZTObjects.signMarkObjClass;
      }
      initPropertiesDefaultValue(this);
      this.id = id;
      this.type = type;
      //Generic
      this.name = name;
      this.x = x;
      this.y = y;
      this.h = h;
      this.w = w;
      this.uid = Upper(AlfaKeyGen(10));
      this.sequence = nAllItems;

      this.page = docpageindex;
      if (clCanvasLib != null) {
        this.scale = clCanvasLib.scale;
      }
      else {
        this.scale = CanvasLib.scale;
      }
      this.show = true;
      this.html = "<img id=\'" + this.id + "' src='" + "../portalstudio/images/bot_signmup_128.png" + "' style=\'border:1px solid #f3f3f3;z-index:2;width:" + this.w + "px;height:" + this.h + "px;position:absolute;top:" + this.y + "px;left:" + this.x + "px;\' onclick=\'clickItem(event)\'>";
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

    //Enrico 08-04-2022: La sezione searchNav a noi non serve
	if( msimplesheetqr == false ) {
    this.searchObj = function() {
      this.objClass = ZTObjects.searchObjClass;
      this.cwword = false;
      this.ccsensitive = false;
      this.chighlight = false;
    }
	}

  }
}
