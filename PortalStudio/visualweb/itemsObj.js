/* exported getobj removeAllClass getobj_def*/
// tutti gli elementi sono item+n e le ombre sono shadow+n
//########################################################
//Propriet� oggetti ###########################

if ( typeof(ZTObjects)=='undefined' ) {
var ZTObjects=new function(){
  this.anchor_select = 'select[,bottom-left-right,bottm-left-right(%),bottom-left,bottom-left(%)-right,bottom-left(%)-right(%),bottom-left(%),bottom-right,bottom-right(%),top-center,top-left-bottom,top-left-right-bottom,top-left-right,top-left-right(%)-bottom,top-left-right(%),top-left,top-left(%)-bottom,top-left(%)-right-bottom,top-left(%)-right,top-left(%)-right(%)-bottom,top-left(%)-right(%),top-left(%),top-right-bottom,top-right,top-right(%)-bottom,top-right(%)]';
  var types_select='select[character,date,datetime,logic,memo,numeric]',
      autocapitalize_select='select[on,off,words,characters]',
      tooltip_hide='The expression evaluated at every change, if true the item is hidden',
      tooltip_edit='The expression evaluated at every change, if true the item is enabled for input',
      tooltip_create='The expression that is evaluated server side at portlet request, if true the item is created else is exluded from portlet',
      tooltip_calc='The expression evaluated at every change that returns the new value for the item',
      tooltip_check='The expression evaluated before to submit the request',
      tooltip_init='if checked the expression calculate that returns the value for the item is evaluated when the portlet is loaded ',
      tooltip_css_Class= `Css class for item's HTML`,
      tooltip_helptips='Help text that appears when you hover the mouse pointer over the item',
      tooltip_tabindex='Tab index of the element',
      tooltip_template='You can write Html code with mustaches bracket "{{...}}" for Portalstudio Expressions.<br>Exemples:<br>' +
        ToHTML('<div>{{%myVariable%}}</div>')+'<br>'+
        ToHTML('<ul>')+'<br>'+
        ToHTML('{{#each %mySQLDataobj%}}')+'<br>'+
        ToHTML('{{#if %mySQLDataobj.Field1% > 500 }}')+'<br>'+
        ToHTML('<li> {{%mySQLDataobj.Field1%}} - {{%mySQLDataobj.Field2%}} </li>')+'<br>'+
        ToHTML('{{#elseif %mySQLDataobj.Field1% > 300 }}')+'<br>'+
        ToHTML('...')+'<br>'+
        ToHTML('{{#else}}')+'<br>'+
        ToHTML('...')+'<br>'+
        ToHTML('{{#endif}}')+'<br>'+
        ToHTML('{{#endeach}}')+'<br>'+
        ToHTML('</ul>')+
        '<br><br>You can call action code or global functions like this Exemple:<br>'+
        ToHTML('{{function:myFunc(\'%SQLDataobj5.CodArt%\')}} this write the return of myFunc()')+'<br>'+
        ToHTML('{{Format(\'%SQLDataobj5.CodArt%\',..,..)}} this write a Formatted expression')+'<br>'+
        ToHTML('<a class="label" href="javascript:void(0)" onclick="{{javascript:myFunc(\'%SQLDataobj1.CodArt%\',\'%var2%\',%int1%,...)}}" > this call myFunc on click event </a>'),
      stdMethods=['Disabled()','Enabled()','IsDisabled()','FadeIn()','FadeOut()','GetCtrl()','Hide()','IsHidden()','SetFadeEffects(#nTimeMs#)','Show()'],
      tooltip_font='Element font',
      tooltip_bgcolor='Backgroud color',
      tooltip_size='Font size of the item',
      tooltip_color='Font color of the element',
      tooltip_weight='Font attribute. The font can be displayed in:<br><ul><li>Bold</li><li>Normal</li></ul>',
      tooltip_href='Link URL that creates a hyperlink to the item',
      tooltip_target='Hyperlinks attribute. Allowed values are: <br><ul><li> _blank </li><li> _top </li><li>_self</li><li><i>NameFrame</i></li></ul>',
      tooltip_image='Format of the element being displayed. The expression will be evaluated at run-time and must be enclosed in quotes',
      tooltip_params='Comma-separated list of parameters to be used as a filter for DataObject extraction.';
      //timeformat_select = "select[,yyyy-mm-dd,dd-mm-yyyy,dd-MMM-yyyy,MMM-yyyy,yyyy,yyyy-mm-dd hh:mm:ss,yyyy-mm-dd hh:mm,hh:mm:ss,hh:mm]";
  this.findProp= function (propID, container){
    for( var j=0; j< container.length; j++){
      if( container[j].propID == propID ){
        return j;
        break;
      }
    }
    return -1;
  };

  this.extend = function( objA, objB){
    // La posizione della properties � definita dall'oggetto esteso
    var propsA = objA['newProperties'],
      propsB = objB['newProperties'];
    for( var prop in propsA ){
      for( var i=0; i< propsA[prop].length; i++ ){
        if( typeof(propsB[prop]) == 'undefined' ){
          propsB[prop] = propsA[prop];
          break;
        }
        var iB = this.findProp(propsA[prop][i].propID, propsB[prop]);
        if( iB == -1 ){
          propsB[prop].splice(i, 0, propsA[prop][i]);
        }
      }
    }
    if( objB['generateSignatureObject'] == undefined ) {
      objB['generateSignatureObject'] = objA['generateSignatureObject'];
    }
  }

  this.stdObjClass = {
    newProperties:{
      generic:[
        {name:'name',     propID:'name',     type:'str', section: 'main', tooltip:'Object name'},
        {name:'x',        propID:'x',        type:'int', section: 'positions', extraClass: 'col-3', tooltip:'X coordinate'},
        {name:'y',        propID:'y',        type:'int', section: 'positions', extraClass: 'col-3', tooltip:'Y coordinate'},
        {name:'sequence', propID:'sequence', type:'int', section: 'positions', extraClass: 'col-3', tooltip:'Set the runtime sequence'},
        {name:'width',    propID:'w',        type:'int', section: 'size', extraClass: 'col-3'},
        {name:'height',   propID:'h',        type:'int', section: 'size', extraClass: 'col-3'},
        {name:'', propID:'ctrlOfVariant',type:'str', disabled:'true'}
      ]
    },
    generateSignatureObject:function(obj, type){
      var objret = {};
      objret.name = '';
      objret.signature = '';
      objret.tooltip = '';
      try {
        var ff0, ffx;
        if( type == 'function' || type == 'event') {
          if ( typeof obj === 'string' ) {
            objret.name = obj;
            objret.signature = obj;
            objret.tooltip = '';
          }
          else if (Array.isArray(obj)) { //array
            var ff = obj;
            if( ff.length == 3) {
              //array di 3 voci (valore riportato, valore visualizzato, tooltip ) //dovrebbe essere standard
              objret.name = ff[1];
              objret.signature = ff[0];
              objret.tooltip = ff[2];
            }
            else if( ff.length == 2) {
              ff0 = ff[0] ;
              ffx = ff0.split('->');
              objret.name = ffx[0];
              objret.signature = ff[1];
              if ( ffx.length > 1)
                objret.tooltip = ffx[1];
              else
                objret.tooltip = '';
            }
            else {
              ff0 = ff[0];
              ffx = ff0.split('->');
              objret.name = ffx[0];
              objret.signature = ffx[0];
              if ( ffx.length > 1)
                objret.tooltip = ffx[1];
              else
                objret.tooltip = '';
            }
          }
          else { //object
            var ret = obj.tooltip;
            ret += '<br>';
            var signature = '(';
            if(obj.parameters && obj.parameters.length > 0) {
              ret += '<b>Parameters:</b>';
              ret += '<br><ul>';
              for( var k=0; k<obj.parameters.length; k++) {
                if( k > 0 ) {
                  signature += ', '
                }
                var param = obj.parameters[k];
                ret += '<li>';
                ret += '<b>' + param.name + '</b>' + '&emsp;&emsp;' + param.type;
                if( param.optional == true ) {
                  ret += '&emsp;&emsp;' + '[optional]';
                  signature += '#' + param.name + '#';
                }
                else {
                  signature += param.name;
                }
                ret += '<br>' + param.tooltip + '<br>';
                ret += '</li>';
              }
              ret += '</ul>';
            }
            signature += ')';
            if(obj.returnValue && !Empty(obj.returnValue)) {
              ret += '<b>Returns:</b>';
              ret += '<blockquote>' + obj.returnValue + '</blockquote>';
            }
            if(obj.usage && !Empty(obj.usage)) {
              ret += '<b>Usage:</b>';
              ret += '<blockquote>' + obj.usage + '</blockquote>';
            }
            objret.name = obj.name;
            objret.signature = obj.signature ? obj.signature : obj.name;
            if ( objret.signature.indexOf('(') < 0 ) {
              //make signature
              objret.signature += signature;
              objret.name = objret.signature;
            }
            objret.tooltip = ret;
          }
        }
        else {
          objret.name = "-- not define --";
        }
      }
      catch(e) {
        objret.name = "-- undefined --";
      }
      return objret;
    }
  }

  this.stdHiddenObjClass = {
    newProperties:{
      generic:[
        {name:'x',        propID:'x',       type:'int', disabled:'true'},
        {name:'y',        propID:'y',       type:'int', disabled:'true'},
        {name:'width',    propID:'w',       type:'int', disabled:'true'},
        {name:'height',   propID:'h',       type:'int', disabled:'true'}
      ]
    }
  }

  this.stdVisibleObjClass = {
    newProperties:{
      generic:[
        {name:'x',        propID:'x',                   type:'int', section: 'positions', extraClass: 'col-3', steppable:true, tooltip:'X coordinate'},
        {name:'y',        propID:'y',                   type:'int', section: 'positions', extraClass: 'col-3', steppable:true, tooltip:'Y coordinate'},
        {name:'anchor',   propID:'anchor',              type: this.anchor_select, section: 'positions', extraClass: 'col-4', steppable:true, tooltip:'If defined, anchors the current object to the page margins in absolute or relative (%) position, depending on the selected choice.'},
        {name:'z-index',  propID:'zindex',              type:'int', section: 'positions', extraClass: 'col-2', steppable:true, tooltip:'Indicates the level at which the element is located if multiple elements overlap.'},
        {name:'hidden',   propID:'hide',                type:'checkbox',  section: 'positions', extraClass: 'col-2', steppable:true, tooltip:'If the condition is true, the object will be hidden when the page loads'},
        {name:'layer',    propID:'layer',               type:'checkbox',  section: 'positions', extraClass: 'col-2', steppable:true, tooltip:"If checked, the object is removed from the flow of portlet resizes and repositions, i.e. it does not move the other controls or resize the form."},
        {name:'width',    propID:'w',                   type:'int', section: 'size',      extraClass: 'col-3', steppable:true, tooltip:'Object width'},
        {name:'height',   propID:'h',                   type:'int', section: 'size',      extraClass: 'col-3', steppable:true, tooltip:'Object height'},
        {name:'',         propID:'layout_steps_values', type:'str', disabled:'true'},
        {name:'',         propID:'wireframe_props',     type:'str', disabled:'true'}
      ],
      advanced:[
        {name :'Custom Id',propID:'spuid', type:'str',section: 'Alt Interface', extraClass: 'hide-title', extraClass: 'col-3',defaultValue: '', tooltip:'Force the UID for alternative interface'},
        {name:'zone',         propID:'zone',     type:'str', section: 'Alt Interface', extraClass: 'col-3', tooltip:'Set the zone name (microzones) for the item in alternative interface'},
        {name:'fixed-position',         propID:'fixed', section: 'Alt Interface',     type:'select[false,true]', extraClass: 'col-3', tooltip:'Set the fixed position of a Detail alternative interface'},
        {name:'',         propID:'rapp',                type:'str', disabled:'true'}
      ]
    },
    wireframe:function(/*obj*/){return "";}
  }
  this.extend( this.stdObjClass, this.stdHiddenObjClass );
  this.extend( this.stdObjClass, this.stdVisibleObjClass );

  this.formObjClass = {
		newProperties:{
			generic:[
        {name:'description', propID:'description', type:'description',extraClass: 'hide-title', section:'description'},
        {name:'', propID:'pagesProp', type:'str', disabled:'true'},
				{name:'pages', propID:'pages', type:'str', multiple:{'type':'combo','id':'pages'},
            buttons:"plus,BtnInsertBefore,del", actions: "addPage({'props':props,'tabName':tabName,'index':index}),insertPageBefore(index),deletePage({'props':props,'tabName':tabName,'index':index})",
            tooltip:'Pages list', section:'pages',setOnBlurFunc:'setCurrentPage',extraClass: 'hide-title'},
				{name:'page titles', propID:'pages_names', type:'str', multiple:{'type':'input','id':'pages'},
          tooltip:'Set the page title', section:'pages', setOnBlurFunc:'setPagesProp'},
				{name:'page as a layer', propID:'page_layer', type:'str', multiple:{'type':'checkbox','id':'pages'}, tooltip:'Page as a popup layer', section:'pages', setOnBlurFunc:'setPagesProp'},
				{name:'height', propID:'h', type:'int', multiple:{'type':'input','id':'pages'}, extraClass: 'col-3', steppable:true, setOnBlurFunc:'setPagesProp',
          tooltip:'Set a height portlet for the current portlet'},
				{name:'width', propID:'w', type:'str', multiple:{'type':'input','id':'pages'}, validFunc:'checkVLine', extraClass: 'col-3', steppable:true , setOnBlurFunc:'setPagesProp', tooltip:'Set a width portlet for the current portlet'},
				{name:'max width', propID:'max_w', type:'str', extraClass: 'col-3', tooltip:'Set the max width'},
				{name:'min width', propID:'min_w', type:'str', extraClass: 'col-3', tooltip:'Set the min width'},
				//{name:'current page', propID:'page', type:'int', tooltip:'Shows the current page', disabled:'true'},
        {name:'Anchors default', propID:'adaptive', type:'select[fixed,adaptive]',setOnBlurFunc:'setAdaptiveSettings',
          tooltip:'Default anchor of elements is set to top-left(%)-right(%) for an adaptive layout',section:'Adaptivity', extraClass: 'col-3'},
				{name:'vert. reference', propID:'v_line', type:'int', validFunc:'checkVLine',section:'Adaptivity', extraClass: 'col-3',
          tooltip:'Set the minimal width if this is in % and this is useful in the design for the right positions'},
        {name:'steps', propID:'steps', type:'str', tooltip:'steps', disabled:'true'},
        {name:'layout steps', propID:'layout_step', buttons:'FillSteps,plus,edit,del', actions:"fillLayoutStep(),addLayoutStep(),editLayoutStep(),delLayoutStep()", type:'steps_layout',
          tooltip:'Different layout settings for dimensions',section:'Adaptivity'},
        {name:'libraries', propID:'my_library', type:'str',
          tooltip:'A comma-separated list of javascript libraries to import',
          viewType:{type:'stringSeparatedValue'}},
        {name:'translate text', propID:'language', type:'checkbox',
            tooltip:'When this property is selected, the content will be translated', extraClass: 'col-3'},
        {name:'Lock items', propID:'lock_items', type:'checkbox',
          tooltip:'Locks the mouse move of the items',
          extraClass: 'col-3'},
        {name:'title', propID:'title', type:'select[none,default,custom]', section: 'title', tooltip:'Set a title portlet for the current portlet',
          hide_list:{'none':['this.generic_title_url','this.generic_title_block'],'default':['this.generic_title_url']},
          show_list:{'custom':['this.generic_title_url','this.generic_title_block'],'default':['this.generic_title_block']}
        },
        {name:'title url', propID:'title_url', type:'portlet', section: 'title',
          tooltip:'Set the title portlet url'},
        {name:'Block the title while scrolls', propID:'title_block', type:'checkbox',section: 'title',
          tooltip:"Do not move title when container scrolls"},
        {name:'Version', propID:'version', type:'str',noteditable:true,
          tooltip:'Version of generator'},
        {name:'', propID:'css_code', type:'str', disabled:'true'},
        {name:'', propID:'layout_steps_values', type:'str', disabled:'true'}
			],
      style:[
        {name:'positioning mode', propID:'positioning', type:'select[absolute,float]', section: 'positions',
          tooltip:'Set the position mode for the elements'},
        {name:'Don\'t move top on stretching', propID:'fixed_top', type:'checkbox', section: 'positions',
          tooltip:"Do not move items below an item that stretches" , extraClass: 'col-3'},
        {name:'Stretch height', propID:'stretch_height', type:'checkbox', section: 'positions',
          tooltip:"Stretch the height of the portlet.", extraClass: 'col-3'},
        {name:'Portlet position', propID:'portlet_position', type:'select[,align left,align center,align right]', section: 'positions',
          tooltip:'Set the horizontal position of the portlet inside his container'},
        {name:'image url', propID:'bg_image', type:'image', section: 'background',
          tooltip:'Set the image background'},
        {name:'image position', propID:'bg_image_position', type:'autocomplete[default:left top,left center,left bottom,right top,right center,right bottom,center top,center center,center bottom]',
          tooltip:'The background-position property sets the starting position of a background image.\nBy default, a background-image is placed at the top-left corner of an element, and repeated both vertically and horizontally.', section: 'background'},
        {name:'image size', propID:'bg_image_size', type:'autocomplete[default:cover,contain,initial,inherit]',
          tooltip:'The background-size property specifies the size of the background images.\nPossible values:auto,values in px or % ,cover,contain,initial,inherit.',
          section: 'background',
          extraClass: 'col-3'},
        {name:'image repeat', propID:'bg_image_repeat', type:'select[,repeat,repeat-x,repeat-y,no-repeat,initial,inherit]',
          tooltip:'The background-repeat property sets if/how a background image will be repeated\nBy default, a background-image is repeated both vertically and horizontally.',
          extraClass: 'col-3',
          section: 'background'},
        {name:'color', propID:'color', type:'color', section: 'background',
          tooltip:'Set the color background'},
        {name:'image url', propID:'container_bg_image', type:'image', section: 'container background',
          tooltip:'Set the container image background'},
        {name:'color', propID:'container_bg_color', type:'color', section: 'container background', extraClass: 'col-3',
          tooltip:'Set the container color background'},
        {name:'position', propID: 'container_bg_pos', type: 'select[left top,left center,left bottom,right top,right center,right bottom,center top,center center,center bottom]', defaultValue:true, extraClass: 'col-3', section: 'container background',
          tooltip:'Set the container background position'},
        {name:'file', propID:'css', type:'str',
          tooltip:'Set Css files separated by comma', section: 'css'},
        {name:'class', propID:'css_class', type:'css_class', section: 'css',
          tooltip:'Set css class'},
        {name:'tabstrip class', propID:'tabstrip_class', type:'css_class', section: 'css',
          tooltip:'Set the tabstrip css clss'},
        {name:'sp skin', propID:'sp_theme', type:'checkbox',
          tooltip:'When this property is selected, the portlet will be displayed using the css file of the current skin',
          extraClass: 'col-2',
          section: 'css'},
      ],
      security:[
        {name:'security', propID:'security', type:'select[logged,pagelet,profiled,administrator,public,none]',
          hide_list:{'none,public,logged,pagelet,administrator':['this.security_roles','this.security_sec_heredity']},
          show_list:{'profiled':['this.security_roles','this.security_sec_heredity']},
          tooltip:'Set the security check'
        },
        {name:'roles', propID:'roles', type:'str',
          tooltip:'A comma-separated list of roles that can execute the portlet'},
        {name:'security inherited from portlet', propID:'sec_heredity', type:'portlet',
          tooltip:'Inherits security from another portlet'},
        {name:'on security failure', propID:'on_security_failure', type:'select[login,empty,default page]',
          tooltip:'Set the landing page after failure security check'}
      ],
      advanced:[
        {name:'form type', propID:'form_type', type:'checkbox',
          hide_list:{'unchecked':['this.advanced_form_action','this.advanced_form_target','this.advanced_form_enctype']},
          show_list:{'checked':['this.advanced_form_action','this.advanced_form_target','this.advanced_form_enctype']},
          section:'form settings', extraClass: 'col-3',
          tooltip:'Set the the portlet as a form'},
        {name:'form action', propID:'form_action', type:'str', section:'form settings',
          tooltip:'Set the form action'},
        {name:'form action target', propID:'form_target', type:'str',section:'form settings',
          tooltip:'Set the form action target'},
        {name:'form enctype', propID:'form_enctype', type:'select[default,multipart/form-data]',section:'form settings',
          tooltip:'Set the form type'},
        {name:'client cache time', propID:'cache_time', type:'str',
          tooltip:'Set cache time with unit (s=seconds, m=minutes, h=hours)\nexample: 10m\ndefault is seconds',section:'cache settings'},
        {name:'server cache time', propID:'server_cache_time', type:'str',
          tooltip:'Set cache time with unit (s=seconds, m=minutes, h=hours)\nexample: 10m\ndefault is seconds',section:'cache settings'},
        {name:'Enable Cache in POST', propID:'cache_in_post', type:'checkbox',
          tooltip:'Enable the server cache also for the POST requests',section:'cache settings'},
        { name: 'Interface for BO', propID: 'altInterfaceFor', type:'str', buttons:'FillBO', actions:"fillBoItems()", extraClass: 'col-4' ,
          section: 'alternative interfaces',
          setOnBlurFunc:'selectZoneMode',
          tooltip:'Set the BO Entity for the Alternative Interface'},
        { name: 'Zone mode selection', propID: 'selectZone', type:'checkbox', extraClass: 'col-2', section: 'alternative interfaces' ,
          tooltip:'The click element selects all items of the same micro zone'},
        { name: 'Custom', propID: 'custom', type:'checkbox', section: 'alternative interfaces' ,
          tooltip:'Save in custom dir'},
        {name:'tags', propID:'tag', type:'str', section: 'misc',tooltip:'A comma-separated list of description tags for the portlet'},
        //{name:'sp Id', propID:'sp_uid', type:'checkbox', tooltip:'When this property is selected, the portlet can be used as an Alternate Interface for a SitePainter entity', extraClass: 'col-3', section: 'misc'},
        {name:'Hide Snap Lines', propID:'hsl', type:'checkbox',
          tooltip:'When this property is selected, the snipe lines are hidden',
          extraClass: 'col-3',
          section: 'misc'},
        {name:'hide pages tabs', propID:'tabstrip_hidden', type:'checkbox',
          tooltip:'This option allows you to hide the tab bar without compromising the operation of the pages.',
          extraClass: 'col-3',
          defaultValue:false,
          section: 'misc'},
        {name:'Wizard mode', propID:'wizard', type:'checkbox',
          tooltip:'Pages tabstrip is displayed using wizard style',
          extraClass: 'col-3',
          section: 'misc'},
        {name:'offline', propID:'offline', type:'checkbox', extraClass: 'col-3', section: 'misc',
          hide_list:{'unchecked':['this.advanced_manifest','this.advanced_shared_manifest']},
          show_list:{'checked':['this.advanced_manifest','this.advanced_shared_manifest']},
          tooltip:'Set the portlet in offline mode'
        },
        {name:'manifest custom resources', propID:'manifest',type:'str',
          tooltip:'Edit or add new manifest custom resources',
          noteditable:true},
        { name: 'Shared manifest', propID: 'shared_manifest', type: 'checkbox', extraClass: 'col-3', section: 'misc',
          tooltip:'Set the manifest as shared',
        },
        { name: '', propID: 'mode', type: 'str', disabled:'true' }
      ]
    },
    events: [ 'Loaded', 'Calculate','OnSubmit','AfterPageChange(n,oldn)','StepChanged(Step)','PageLoaded',
      ['ExpandedRow(rs,portletFatherObj)','ExpandedRow(rs,portletFatherObj)','Event called when the portlet is in a grid with expanding-row'],
      ['LayerClosed()', 'LayerClosed()', 'Event called when layer container where closed']
    ],
    functions:[ 'getPortlet(cPortletName)',['getPagelet() -> return pagelet container','getPagelet()'],'getTitlePortlet()','raiseEvent(cEventName)','ZtTabs.SetDisable(page#n#,#bDiasable#)','ZtTabs.Hide(#npage#,#bHide#)','ZtTabs.Select(page#n#)','ZtTabs.Prev()','ZtTabs.Next()','ZtTabs.SetCaption(page#n#,#cTxt#)','CurrentPage()']
  };
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

  this.PSToolbarCtrl = [
    {
      'id': 'label_ctrl',
      'action': {'func':'addItem','par':'Label'},
      'image': '../portalstudio/images/icon/bot_label_off.png',
      'title': 'Label',
      'draggable': true,
    },
    {
      'id': 'textbox_ctrl',
      'action': {'func':'addItem','par':'Textbox'},
      'image': '../portalstudio/images/icon/bot_Inputbox_off.png',
      'title': 'Textbox',
      'draggable': true,
    },
    {
      'id': 'button_ctrl',
      'action': {'func':'addItem','par':'Button'},
      'image': '../portalstudio/images/icon/bot_button_off.png',
      'title': 'Button',
      'draggable': true,
    },
    {
      'id': 'combobox_ctrl',
      'action': {'func':'addItem','par':'Combobox'},
      'image': '../portalstudio/images/icon/bot_select_off.png',
      'title': 'Combobox',
      'draggable': true,
    },
    {
      'id': 'radio_ctrl',
      'action': {'func':'addItem','par':'Radio'},
      'image': '../portalstudio/images/icon/bot_radio_off.png',
      'title': 'Radio',
      'draggable': true,
    },
    {
      'id': 'checkbox_ctrl',
      'action': {'func':'addItem','par':'Checkbox'},
      'image': '../portalstudio/images/icon/bot_checkbox_off.png',
      'title': 'Checkbox',
      'draggable': true,
    },
    {
      'id': 'image_ctrl',
      'action': {'func':'addItem','par':'Image'},
      'image': '../portalstudio/images/icon/bot_image_off.png',
      'title': 'Image',
      'draggable': true,
    },
    {
      'id': 'box_ctrl',
      'action': {'func':'addItem','par':'Box'},
      'image': '../portalstudio/images/icon/bot_boxarea_off.png',
      'title': 'Box',
      'draggable': true,
    },
    {
      'id': 'template_ctrl',
      'action': {'func':'addItem','par':'Template'},
      'image': '../portalstudio/images/icon/bot_template_off.png',
      'title': 'Template',
      'draggable': true,
    }
  ]

  this.PSToolbarDataCtrl = [
    {
      'id': 'variable_ctrl',
      'draggable': true,
      'action': {'func':'addItem','par':'Variable'},
      'image': '../portalstudio/images/icon/bot_Variable_off.png',
      'title': 'Variable',
    },
    {
      'id': 'sqldataobj_ctrl',
      'action': {'func':'addItem','par':'SQLDataobj'},
      'image': '../portalstudio/images/icon/bot_dataobj_sql_off.png',
      'title': 'SQL DataObj',
      'draggable': true,
    },
    {
      'id': 'xmldataobj_ctrl',
      'action': {'func':'addItem','par':'XMLDataobj'},
      'image': '../portalstudio/images/icon/bot_dataobj_xml_off.png',
      'title': 'XML DataObj',
      'draggable': true,
    },
    {
      'id': 'jsondataobj_ctrl',
      'action': {'func':'addItem','par':'JSONDataobj'},
      'image': '../portalstudio/images/icon/bot_dataobj_json_off.png',
      'title': 'JSON DataObj',
      'draggable': true,
    },
    {
      'id': 'staticdataobj_ctrl',
      'action': {'func':'addItem','par':'StaticDataProvider'},
      'image': '../portalstudio/images/icon/bot_dataobj_static_off.png',
      'title': 'Static DataObj',
      'draggable': true,
    },
    {
      'id': 'mleveldataobj_ctrl',
      'action': {'func':'addItem','par':'MLevelDataProvider'},
      'image': '../portalstudio/images/icon/bot_dataobj_multilevel_off.png',
      'title': 'Multi-Level DataObj',
      'draggable': true,
    }
  ]

    this.PSToolbarViewsCtrl = [
    {
      'id': 'grid_ctrl',
      'action': {'func':'addItem','par':'Grid'},
      'image': '../portalstudio/images/icon/bot_grid_off.png',
      'title': 'Grid',
      'draggable': true,
    },
    {
      'id': 'chart_ctrl',
      'action': {'func':'addItem','par':'Chart'},
      'image': '../portalstudio/images/icon/bot_graphics_off.png',
      'title': 'Chart',
      'draggable': true,
    },
    {
      'id': 'xZoom_ctrl',
      'action': {'func':'addItem','par':'XZoom'},
      'image': 'images/XZoom_small.png',
      'title': 'XZoom',
      'draggable': true,
    },
    {
      'id': 'gridpivot_ctrl',
      'action': {'func':'addItem','par':'GridPivot'},
      'image': 'images/bot_pivot.png',
      'title': 'Grid Pivot',
      'draggable': true,
    },
    {
      'id': 'dataMasher_ctrl',
      'action': {'func':'addItem','par':'DataMasher'},
      'image': '../portalstudio/images/icon/bot_DataMasher_off.png',
      'title': 'DataMasher',
      'draggable': true,
    },
    {
      'id': 'stdTreeview_ctrl',
      'action': {'func':'addItem','par':'StdTreeView'},
      'image': '../portalstudio/images/icon/TreeView_small.png',
      'title': 'StdTreeView',
      'draggable': true,
    }
  ]

  this.PSToolbarNavigationCtrl = [
    {
      'id': 'hamburger_ctrl',
      'action': {'func':'addItem','par':'HamburgerMenu'},
      'image': '../portalstudio/images/icon/bot_hamburger.png',
      'title': 'Hamburger Menu',
      'draggable': true,
    },
    {
      'id': 'toolbar_ctrl',
      'action': {'func':'addItem','par':'SPToolbar'},
      'image': '../portalstudio/images/icon/bot_toolbar.png',
      'title': 'SPToolbar',
      'draggable': true,
    },
    {
      'id': 'tabs_ctrl',
      'action': {'func':'addItem','par':'Tabs'},
      'image': '../portalstudio/images/icon/bot_tabs_off.png',
      'title': 'Tabs',
      'draggable': true,
    },
    {
      'id': 'SPLinker_ctrl',
      'action': { 'func': 'addItem', 'par': 'SPLinker' },
      'image': '../portalstudio/images/icon/bot_linksitepainter_off.png',
      'title': 'SPLinker',
      'draggable': true,
    }
  ]

  this.PSToolbarEventCtrl = [
    {
      'id': 'eventEmitter_ctrl',
      'action': {'func':'addItem','par':'EventEmitter'},
      'image': '../portalstudio/images/icon/bot_emitter.png',
      'title': 'EventEmitter',
      'draggable': true,
    },
    {
      'id': 'EventReceiver_ctrl',
      'action': {'func':'addItem','par':'EventReceiver'},
      'image': '../portalstudio/images/icon/bot_receiver.png',
      'title': 'EventReceiver',
      'draggable': true,
    }
  ]

  this.PSToolbarDataPageCtrl = [
    {
      'id': 'maskParameters_ctrl',
      'action': {'func':'addItem','par':'MaskParameters'},
      'image': '../portalstudio/images/component/bot_vdm.png',
      'title': 'MaskParameters',
      'draggable': true,
    },
    {
      'id': 'iframe_ctrl',
      'action': {'func':'addItem','par':'Iframe'},
      'image': '../portalstudio/images/icon/bot_iframe_off.png',
      'title': 'Iframe',
      'draggable': true,
    },
    {
      'id': 'portlet_ctrl',
      'action': {'func':'addItem','par':'Portlet'},
      'image': '../portalstudio/images/icon/bot_portlet.png',
      'title': 'Portlet',
      'draggable': true,
    }
  ]

  this.PSToolbarNote = [
    {
      'id': 'note_ctrl',
      'draggable': true,
      'action': {'func':'addItem','par':'Note'},
      'image': '../portalstudio/images/icon/bot_note_off.png',
      'title': 'Note',
    }
  ]

  this.PSAddOn = [
    {
      'id': 'newObj',
      'action': function() { loadNewObj() },
      'image': '../portalstudio/images/icon/btn_add.png',
      'title': 'Add component',
      'draggable': false,
    }
  ]

  this.PSToolbarAlign = [
    {
      'id': 'left_align',
      'action': function() { alignItems('left'); },
      'image': '../portalstudio/images/icon/btn_alignleft.png',
      'title': 'Align left',
    },
    {
      'id': 'right_align',
      'action': function() { alignItems('right'); },
      'image': '../portalstudio/images/icon/btn_alignright.png',
      'title': 'Align right',
    },
    {
      'id': 'hcenter_align',
      'action': function() { alignItems('middle'); },
      'image': '../portalstudio/images/icon/btn_alignmiddle.png',
      'title': 'Align horizontal center',
    },
    {
      'id': 'bottom_align',
      'action': function() { alignItems('bottom'); },
      'image': '../portalstudio/images/icon/btn_alignbottom.png',
      'title': 'Align bottom',
    },
    {
      'id': 'top_align',
      'action': function() { alignItems('top'); },
      'image': '../portalstudio/images/icon/btn_aligntop.png',
      'title': 'Align top',
    },
    {
      'id': 'vcenter_align',
      'action': function() { alignItems('center'); },
      'image': '../portalstudio/images/icon/btn_aligncenter.png',
      'title': 'Align vertical center',
    }
  ]

  this.PSToolbarResize = [
    {
      'id': 'x_delta_align',
      'action': function() { alignItems('x_delta'); },
      'image': '../portalstudio/images/icon/btn_x-delta.png',
      'title': 'Same horizontal distance',
    },
    {
      'id': 'y_delta_align',
      'action': function() { alignItems('y_delta'); },
      'image': '../portalstudio/images/icon/btn_y-delta.png',
      'title': 'Same vertical distance',
    },
    {
      'id': 'resizexy_align',
      'action': function() { alignItems('resizexy'); },
      'image': '../portalstudio/images/icon/btn_resize-xy.png',
      'title': 'Same size',
    },
    {
      'id': 'resizex_align',
      'action': function() { alignItems('resizex'); },
      'image': '../portalstudio/images/icon/btn_resize-x.png',
      'title': 'Same width',
    },
    {
      'id': 'resizey_align',
      'action': function() { alignItems('resizey'); },
      'image': '../portalstudio/images/icon/btn_resize-y.png',
      'title': 'Same height',
    }
  ]

  this.PSToolbarBring = [
    {
      'id': 'btn_to_front',
      'action': function() { bringToFront() },
      'image': '../portalstudio/images/icon/btn_bringfront.png',
      'title': 'Bring element to front',
    },
    {
      'id': 'btn_to_back',
      'action': function() { sendToBack() },
      'image': '../portalstudio/images/icon/btn_sendback.png',
      'title': 'Send element to back',
    },
    {
      'id': 'btn_forward',
      'action': function() { bringForward() },
      'image': '../portalstudio/images/icon/btn_bringforward.png',
      'title': 'Bring element forward',
    },
    {
      'id': 'btn_backward',
      'action': function() { sendBackward() },
      'image': '../portalstudio/images/icon/btn_sendbackward.png',
      'title': 'Send element backward',
    }
  ]

  this.PSToolbarTools = [
    {
      'id': 'btn_preview',
      'action': function() { togglePreview(); },
      'image': '../portalstudio/images/icon/btn_preview.png',
      'title': 'Preview',
      'withTitle': true,
    },
    {
      'id': 'btn_action_code',
      'action': function() { editItemEvent(); },
      'image': '../portalstudio/images/icon/btn_acode.png',
      'title': 'Action Code',
      'withTitle': true,
    }
  ]

  this.PSToolbarMode = [
    {
      'id': 'btn_normalmode',
      'action': () => { toggleMode("NORMAL") },
      'image': '../portalstudio/images/icon/btn_visualmode_off.png',
      'title': 'Portlet mode',
      'withTitle': true,
    },
    {
      'id': 'btn_logicview',
      'action': () => { toggleMode("LOGIC"); },
      'image': '../portalstudio/images/icon/btn_logicview.png',
      'title': 'Logic View',
      'withTitle': true,
    },
    {
      'id': 'btn_htmlmode',
      'action': () => { toggleMode("HTML"); },
      'image': '../portalstudio/images/icon/btn_htmlcode.png',
      'title': 'HTML Mode',
      'withTitle': true,
    // },
    // {
    //   'id': 'btn_grapesmode',
    //   'action': () => { toggleMode("GRAPES"); },
    //   'image': '../portalstudio/images/icon/btn_grapes.png',
    //   'title': 'Grapes Mode',
    //   'withTitle': true,
    }
  ]


  this.PSToolbarAction = [
    {
      'id': 'open',
      'action': function() { reload(); },
      'image': '../portalstudio/images/icon/btn_open.png',
      'title': 'Open',
      'withTitle': true,
    },
    {
      'id': 'save',
      'action': function() { save(); },
      'image': '../portalstudio/images/icon/btn_save.png',
      'title': 'Save Portlet',
    },
    {
      'id': 'input_action_open',
      'action': function() { },
      'title': 'Portlet Name',
      'innerHTML': '<input id="srcform" type="action" value="" title="Portlet name" onchange="currentname=this.value">',
    }
  ]



  this.EventEmitterClass={
    newProperties:{
      generic:[
        {name:'name', propID:'name',  type:'str', buttons:'pick', actions:"selectReceiver()",
          tooltip:'Item name. <br> The value of the \'Name\' property of the element is used as a prefix (<i>ElementName</i>_) of the functions and events of the element itself which will therefore have names with the syntax:<br><i>ItemName_FunctionName</i>'}
        ],
      functional:[
        {name:'Parms names', propID:'parmsNames', type:'str', tooltip:'A comma-separated list of names of parameters used by the Emitter to create a new event'},
        {name:'Parms values', propID:'parmsValues', type:'str', tooltip:'A comma-separated list of values of parameters used by the Emitter to create a new event'},
        {name:'Parms types', propID:'parmsTypes', type:'str', tooltip:'A comma-separated list of types of parameters used by the Emitter to create a new event'},
        {name:'Events objs', propID:'eventsObjs', type:'str', tooltip:'A comma-separated list of objects that launch the new event'},
        {name:'Events names', propID:'eventsNames', type:'str', tooltip:'A comma-separated list of starndard events that launch the new event'},
        {name:'Broadcast to', propID:'broadcast', type:'select[Window:all,pagelet,Tab/Layer:internal]', tooltip:'Broadcast to limit area',extraClass: 'col-3'},
        {name:'Persistent', propID:'persistent', type:'checkbox', tooltip:'The emitter is persistent and outputs the event to other portlets loaded later',extraClass: 'col-3'}
        ]
      },
    names:['../portalstudio/images/component/EventEmitter.png','../portalstudio/images/component/EventEmitter.png'],
    functions: ['Emit()']
  }
  this.extend( this.stdHiddenObjClass,  this.EventEmitterClass);

  this.EventReceiverClass={
	  newProperties:{
      generic:[
        {name:'name', propID:'name', type:'str', buttons:'pick', actions:"selectEmitter()",
          tooltip:'Unique identifier in the portlet. <br><br> The assigned name also represents the name of the event to be intercepted. The Event Emitter object, used to trigger it, must necessarily have the same name. <br><br> The events:<br><ul><li><i>_savedEntity</i></li><li><i>_loadedEntity</i></li><li><i>_deletedEntity</i></li><li><i>_discardedEntity</i></li></ul>are fired by the servlets that handle the management and can be captured and handled manuallyusing the following syntax:<br><br><i>EntityName_EventName</i>'}
        ],
      functional:[
        {name:'Parms names', propID:'parmsNames', type:'str', tooltip:'A comma-separated list of names of parameters received by the Receiver catching the event'},
        {name:'Action types', propID:'actTypes', type:'str', tooltip:'A comma-separated list of type of objects modified by the Receiver when catching the event'},
        {name:'Actions objs', propID:'actObjs', type:'str', tooltip:'A comma-separated list of objects modified by the Receiver when catching the event'},
        {name:'Objs values', propID:'objsValues', type:'str', tooltip:'A comma-separated list of objects modified by the Receiver when catching the event'},
        {name:'Attach to inclusion entity', propID:'included', type:'checkbox', tooltip:'When this property is selected, the Receiver will listen to the events of the entity includind it'},
        {name:'Broadcast from', propID:'broadcast', type:'select[Window:all,pagelet,Tab/Layer:internal]', tooltip:'Broadcast from limit area'}
        ]
    },
    names:['../portalstudio/images/component/EventReceiver.png','../portalstudio/images/component/EventReceiver.png'],
    connector:[
      {'type':'iParameter','propID':'actObjs','versus':'out'}
    ]
	}
  this.extend( this.stdHiddenObjClass,  this.EventReceiverClass );

  this.BoxObjClass ={
    newProperties:{
      generic:[],
			style:[
        { name: 'Css class',
          propID: 'class_Css',
          type: 'css_class',
          section: 'css class',
          extraClass: 'hide-title',
          tooltip: tooltip_css_Class
        }, {
          name: 'color',
          propID: 'bg_color',
          type: 'color',
          section: 'background color',
          extraClass: 'col-3',
          tooltip: 'Set box background color'
        }, {
          name: 'color',
          propID: 'border_color',
          type: 'color',
          section: 'border',
          extraClass: 'col-3',
          tooltip: 'Set box border color'
        }, {
          name: 'width',
          propID: 'border_weight',
          type: 'int',
          section: 'border',
          extraClass: 'col-3',
          tooltip: 'Set box border width'
        }
			],
      functional:[
        {
          name:"href",
          propID:'href',
          type:'str',
          section:'link',
          tooltip: tooltip_href
        }, {
          name:"target",
          propID:'target',
          type:'str',
          section:'link',
          tooltip: tooltip_target
        }, {
          name:'stretch',
          propID:'stretch',
          type:'checkbox',
          extraClass: 'col-3',
          section: 'height',
          tooltip:'When this property is selected, the Box will stretch in height dimension'
        }, {
          name:'shrinkable',
          propID:'shrinkable',
          type:'checkbox',
          section:'height',
          extraClass: 'col-3',
          tooltip: `The height of the Box may become smaller than the one set in the designer.
            If the Box is hidden, portlet height decrease for Box height`
        }, {
          name:'titled',
          propID:'titled',
          type:'checkbox',
          section:'title',
          extraClass: 'col-2',
          hide_list: {
            unchecked: [
              'functional.title_caption',
              'functional.title_portlet',
              'functional.collapsible',
              'functional.groupName'
            ],
            checked: []
          },
          show_list:{
            checked: [
              'functional.title_caption',
              'functional.title_portlet',
              'functional.collapsible',
              'functional.groupName'
            ],
            unchecked: []
          },
          tooltip: 'Set Box Title decorator'
        }, {
          name:'title caption',
          propID:'title_caption',
          type:'str',
          section:'title',
          extraClass: 'col-4',
          tooltip:'Set Box Title caption'
        }, {
          name:'title portlet custom',
          propID:'title_portlet',
          type:'decorators',
          section:'title',
          extraClass: 'col-6',
          tooltip:'Optional, title decorator portlet custom.<br>if empty, the default portlet "dafault_title_box" is set'
        }, {
          name:'collapsible/container mode',
          propID:'collapsible',
          type:'checkbox',
          section:'title',
          extraClass: 'col-3',
          tooltip:'the box is like a container that can be collapsed hiding all contained items',
          setOnBlurFunc:function(){if(getPropertyValue(false,'functional','collapsible')=='true'){ setPropertyValue(false,'functional','shrinkable','true'); }}
        }, {
          name:'group name',
          propID:'groupName',
          type:'str',
          section:'title',
          extraClass: 'col-3',
          tooltip:'Box with same groun name are regrouped in a tabbed structure'
        }
      ],
      expression:[
				{name:'hide undercond', propID:'hide_undercond', type:'exp', tooltip:tooltip_hide},
        {name:'create undercond', propID:'create_undercond', type:'exp', tooltip:tooltip_create}
			]
    },
    functions: stdMethods.concat([
      {
        name:'Collapse',
        tooltip:'Collapse box',
        usage: `To collapse box. If box is shrinkable, portlet will be reduced of box's size in height`,
        returnValue: '',
			  parameters : []
		  },
      {
        name:'Expand',
        tooltip:'Expand box',
        usage: `To collapse box. If box is shrinkable, portlet will be reduced of box's size in height`,
        returnValue: '',
			  parameters : []
		  },
      {
        name:'ToggleCollapse',
        tooltip:'Expand or collapse box',
        usage: `To collapse/expande box. If box is shrinkable, portlet will be reduced/expanded of box's size in height`,
        returnValue: '',
			  parameters : []
		  }
    ]),
    events: [
      {
        name:'Click',
        tooltip:'Event dispatched when box is clicked',
     	  parameters : []
		  }
    ],
    wireframe:function(obj, isVisualMode) {
      var background = (!Empty(obj.bg_color) ? obj.bg_color : '');
      var border = obj.border_weight + "px solid " + obj.border_color;
      var res = "";
      if(isVisualMode) {
        res += "<style>"+getClassCode(obj.class_Css)+"</style>";
      }
      res += "<div class='Box "+obj.class_Css+"'";
      if(isVisualMode) {
        res += "style='border:"+border
        +";width:"+obj.w+"px"
        +";height:"+obj.h+"px"
        +";background-color:"+background
        +";box-sizing: border-box;'";
      }
      res += "></div>";
      return res;
    }
  }
  this.extend( this.stdVisibleObjClass,  this.BoxObjClass );

  this.TextboxObjClass={
    newProperties:{
			generic:[
				{name:'help tips', propID:'help_tips', type:'str', tooltip:tooltip_helptips},
				{name:'tab index', propID:'tabindex', type:'int', extraClass: 'col-3', tooltip:tooltip_tabindex}
			],
			style:[
				{name:'Css class', propID:'class_Css', type:'css_class', section: 'css class', extraClass: 'hide-title', tooltip:'Set the Css class'},
				{name:'font', propID:'font', section: 'font', type:'font-websafe', tooltip:tooltip_font},
				{name:'font color', propID:'font_color', type:'str', section: 'font', tooltip:tooltip_color},
				{name:'font size', propID:'font_size', type:'str', section: 'font', extraClass: 'col-3', tooltip:tooltip_size},
				{name:'multi line (Textarea)', propID:'scroll', type:'checkbox', section: 'font', extraClass: 'col-3', tooltip:'If selected, the text is arranged in multiple lines'}
			],
			functional:[
				{name:'data source', propID:'dataobj', type:'data', section: 'database', tooltip:'Name of the Data Object to use'},
				{name:'field',   propID:'field', type:'singlefield', dataobjref:'dataobj', section: 'database', tooltip:'Field queried to evaluate the element'},
				{name:'var type', propID:'typevar', type:types_select, extraClass: 'col-3', tooltip:'Data type of the TextBox'},
				{name:'html5 type', propID:'typehtml5', type:'select[,date,datetime-local,time,email,tel,url,week,month,color]', extraClass: 'col-3',
          hide_list:{'date,datetime-local':['this.functional_picture']},
          show_list:{',time,email,tel,url,week,month,color':['this.functional_picture']},
          tooltip:"For Date and Datetime-local types the picture displayed is fixed by the browser.<br>To input a value in the Value() function you must have a format as 'YYYY-MM-DD' or 'YYYY-MM-DD HH:MM:SS'.<br>"
                   +"The other types are all string format."
        },
				{name:'maxlength', propID:'maxlength', type:'str', extraClass: 'col-2', tooltip:'Maximum number of characters accepted by the TextBox'},
				{name:'visible', propID:'visible', type:'checkbox', extraClass: 'col-2', tooltip:'If checked, the item is displayed'},
				{name:'autocomplete', propID:'autocomplete', type:'select[,on,off]', extraClass: 'col-2', tooltip:'If checked, autocompletion is activated when valuing the item'},
				{name:'password', propID:'password', type:'checkbox', extraClass: 'col-2', tooltip:'If checked, allows you to mask the input of the element by matching a \'*\' to each typed character'},
				{name:'readonly', propID:'readonly', type:'checkbox', extraClass: 'col-2', tooltip:'If checked, disable input of the item'},
				{name:'autocapitalize', propID:'autocapitalize', type:autocapitalize_select, extraClass: 'col-2', tooltip:'The autocapitalize attribute affects the behavior of other input mechanisms, such as virtual keyboards on mobile devices and voice input. It does not affect behavior when typing on a physical keyboard.'},
				{name:'picture', propID:'picture', type:'str', tooltip:'Set the output picture (standard of Sitepainter)'},
				{name:'initial par', propID:'init_par', type:'str', tooltip:'Initializing the element (server-side) with global variables or as a parameter received at the call of the portlet that contains it. The following values are possible: <br><ul><li>attribute</li><li>request</li><li>global &lt;type&gt;</li><li>\'&lt;ConstString&gt;\'</li></ul><br>Date must be YYYY-MM-DD'},
				{name:'zero filling', propID:'zerofilling', type:'checkbox', extraClass: 'col-2', tooltip:'Complete user input, prepending \'0\' characters to fill the length specified by the element\'s type'},
        {name:'autofocus',		propID:'autofocus',		type:'checkbox' ,tooltip:'Set focus on textbox on portlet load', extraClass: 'col-2'},
        {name:'picker', propID:'picker', type:'checkbox', extraClass: 'col-2', tooltip:'Set the picker for data type or for linked field in alternative interfaces.<br>it\'s possible to implement in action code a custom action in the _Pick() event'},
        {name:'Floating placeholder', propID:'floating_placeholder', type:'checkbox', tooltip:'The placeholder occupies the inside of the textbox but at the moment of focus it moves to position itself at the top of the input as a label.', extraClass: 'col-3'},
        {name:'placeholder', propID:'placeholder', type:'str', extraClass: 'col-3', tooltip:'Set the placeholder for the input'},
        {name:'draggable', propID:'draggable', type:'checkbox', section:'drag and drop', extraClass: 'col-2', tooltip:'Enable the draggable value of the input'},
        {name:'draggable name', propID:'draggable_name', type:'str', section:'drag and drop', extraClass: 'col-4', tooltip:'Set the drag logic name of the input to use in the droppable name in a other item'},
        {name:'droppable', propID:'droppable', type:'checkbox', section:'drag and drop', extraClass: 'col-2', tooltip:'Enable the droppable input'},
        {name:'droppable name', propID:'droppable_name', type:'str', section:'drag and drop', extraClass: 'col-4', tooltip:'Set the drop logic name of the input to use the drag from other items'},
        {name:'zoom', propID:'zoom', type:'str' , disabled:'true'}

			],
			expression:[
        {name:'init', propID:'init', type:'checkbox', extraClass: 'col-1', tooltip:'If checked, the expression indicated in the \'Calculate\' property will be executed only when the portlet loads'},
				{name:'calculate', propID:'calculate', type:'exp',tooltip:tooltip_calc, extraClass: 'col-5'},
				{name:'hide undercond', propID:'hide_undercond', type:'exp', tooltip:tooltip_hide},
				{name:'edit undercond', propID:'edit_undercond', type:'exp', tooltip:tooltip_edit},
        {name:'create undercond', propID:'create_undercond',type:'exp',tooltip:tooltip_create}
			]
    },
    events: [ 'Error(cCause)', 'Gotfocus', 'Lostfocus', 'onChange', 'Validate','Drop(val_obj,drop_obj)','DragEnter(objTarget)',
      'DragLeave(objTarget)','DragCancel()', 'Pick()', 'onKeyUp()'],
    functions: stdMethods.concat([ 'CanFocus()'
     , 'IsVisible()'
     , ['ReadOnly(#opt_bNewValue#) -> set/get read-only mode' , 'ReadOnly(#opt_bNewValue#)']
     , ['Set(#xNewValue#) -> set value with validations and calculations' , 'Set(#xNewValue#)']
     , ['SetFocus() -> returns true when text field gains focus; false otherwise' , 'SetFocus()']
     , ['Value(#opt_xNewValue#) -> set/get variable value. No validations nor calculations', 'Value(#opt_xNewValue#)']
     , ['Init(#NewValue#) -> set variable value. No onChange events', 'Init(#xNewValue#)']
     ]),
    connector:[
      {'type':'iRequest','propID':'init_par','versus':'in'},
      {'type':'iData','propID':'dataobj','versus':'in'},
      {'type':'iParameter','versus':'out'},
      {'type':'iParameter','versus':'in'}
    ],
    wireframe:function(obj){
      return "<input class='Textbox' type='text' value='"+obj.name+"'/>";
    }
  };
  this.extend( this.stdVisibleObjClass,  this.TextboxObjClass );

  this.VariableObjClass = {
    newProperties:{
      generic:[],
			functional:[
				{name:'server side only', propID:'server_side', type:'checkbox', section: '', extraClass: 'col-3', tooltip:'Generate only server side code'},
				{name:'reactive', propID:'reactive', type:'checkbox', section: '', extraClass: 'col-3', tooltip:'Reactive for others ctrls when changes the value'},
				{name:'dataobj', propID:'dataobj', type:'data', extraClass: 'col-3', section: 'database', tooltip:'Data Object based on the field that values ​​the \'Value\' property of the element is extracted'},
				{name:'field', propID:'field', type:'singlefield', extraClass: 'col-3',dataobjref:'dataobj', section: 'database', tooltip:'Field with which the element is valued'},
        {name:'var type', propID:'typevar', type:types_select, tooltip:'Data type of the item'},
				{name:'init par', propID:'init_par', type:'str', tooltip:'Initializing the element (server-side) with global variables or as a parameter received at the call of the portlet that contains it. The following values are possible:<br><ul><li>attribute</li><li>request</li><li>global &lt;type&gt;</li><li>\'&lt;ConstString&gt;\'</li></ul><br>Date must be YYYY-MM-DD'},
        {name:'encrypt', propID:'encrypt', type:'checkbox', extraClass: 'col-2', tooltip:'If checked, the value of the variable will be encrypted'},
        {name:'encrypt seed ', propID:'encrypt_pwd',tooltip:'Optional seed for this encryption.<br>If empty it is random generated and no other portlet can decrypt this element', type:'str', extraClass: 'col-4',validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;}}},
        {name:'decrypt', propID:'decrypt',type:'checkbox', extraClass: 'col-2', tooltip:'If checked, the value of the variable will be decrypted'},
        {name:'decrypt seed ', propID:'decrypt_pwd', type:'str', tooltip:'Optional seed for this decryption.<br>If empty it is random generated and only variables of this portlet can be decrypted.', extraClass: 'col-4',validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;}}}
			],
			expression:[
        {name:'init', propID:'init', type:'checkbox', extraClass: 'col-1', tooltip:tooltip_init},
				{name:'calculate', propID:'calculate', type:'exp',tooltip:tooltip_calc, extraClass: 'col-5'},
			]
    },
    events: ['Error(cCause)', 'onChange', 'Validate'],
    functions: [
       ['Set(#xNewValue#) -> set value with validations and calculations' , 'Set(#xNewValue#)']
     , ['Value(#opt_xNewValue#) -> set/get variable value. No validations nor calculations', 'Value(#opt_xNewValue#)']
     , ['Init(#NewValue#) -> set variable value. No onChange events', 'Init(#xNewValue#)']
   ],
    connector:[
      {'type':'iRequest','propID':'init_par','versus':'in'},
      {'type':'iData','propID':'dataobj','versus':'in'},
      {'type':'iData','versus':'out'},
      {'type':'iParameter','versus':'out'},
      {'type':'iParameter','versus':'in'}
    ],
    wireframe:function(obj){
      return "<input class='Textbox' type='text' value='"+obj.name+"' readonly />";
    }
  };
  this.extend( this.stdHiddenObjClass , this.VariableObjClass );

  this.TemplateObjClass={
    helper : {
      description : 'The component helps to create custom html elements to make graphic gadgets.<br>'+
                    'You can write html code with template tags {{..}} and interact with other Ps Ctrls such as Variables and Dataproviders.'
    },
    newProperties:{
      generic:[],
      style:[
        {
          name:'Css class',
          propID:'class_Css',
          type:'css_class',
          section: 'css class',
          extraClass: 'col-4',
          tooltip:'Set the Css class'
        }
      ],
      functional:[
        {
          name:'template code',
          propID:'code',
          type:'str',
          buttons:'edit',
          actions:'EditTemplate()',
          noteditable:true,
          setOnBlurFunc:'CreateTemplateConnectors',
          tooltip:tooltip_template,
          tooltip_width:400
        },
        {
          name: '',
          propID: 'dataobjs',
          type: 'str',
          disabled : 'true'
        }
      ]
    },
    names: ['../portalstudio/images/component/template.svg', '../portalstudio/images/component/template.svg'],
    functions: stdMethods,
    events: [
      {
        name:'Rendered',
        tooltip:'Event fired on html is rendered',
        usage: ``,
        returnValue: '',
				parameters : []
			}
    ],
    connector: [
      {'type': 'iData', 'propID':'dataobjs','versus':'in','multiple':true}
    ]
  };

  this.extend( this.stdVisibleObjClass,  this.TemplateObjClass );

  this.ButtonObjClass = {
		newProperties:{
			generic:[
				{name:'value', propID:'value', type:'str', tooltip:'Value displayed on the button'},
				{name:'help tips',  propID:'help_tips', type:'str', tooltip:tooltip_helptips},
				{name:'tab index', propID:'tabindex', type:'int', extraClass: 'col-3', tooltip:tooltip_tabindex}
			],
			style:[
				{name:'Css class', propID:'class_Css', type:'css_class', section: 'css class', extraClass: 'hide-title'},
				{name:'font', propID:'font', type:'font-websafe', tooltip:tooltip_font},
				{name:'background color', propID:'bg_color', type:'color', tooltip:tooltip_bgcolor},
				{name:'font color', propID:'font_color',type:'color', tooltip:tooltip_color},
				{name:'font size', propID:'font_size', type:'str', extraClass: 'col-3', tooltip:tooltip_size},
				{name:'border weight', propID:'border_weight', type:'int', extraClass: 'col-3', tooltip:'Width in pixels of the border'},
       	{name:'border color', propID:'border_color', type:'color', tooltip:'Element border color'}
			],
      functional:[
				{name:'type submit', propID:'type_submit', type:'checkbox', extraClass: 'col-3', tooltip:'Submit the form of the portlet it is in. It works only if the portlet is a form, ie if the \'Form type\' property of the form has the value \'True\'.'},
				{name:'type wizard', propID:'type_wizard', type:'select[,forward,back]', extraClass: 'col-3', tooltip:'If valued, the property establishes that the button is used to move between the pages of the portlet.<br><ul><li>Forward: next page</li><li>Back: previous page</li></ul>'}
      ],
			expression:[
				{name:'hide undercond', propID:'hide_undercond', type:'exp',tooltip:tooltip_hide},
				{name:'edit undercond', propID:'edit_undercond', type:'exp',tooltip:tooltip_edit},
        {name:'create undercond', propID:'create_undercond', type:'exp',tooltip:tooltip_create}
			]
    },
    events: ['Click','Gotfocus','Lostfocus'],
    functions: stdMethods.concat([
       'Reset()'
      , 'SetFocus()'
      , 'Submit(#cAction#)'
      , 'Value(#xNewValue#)'
    ]),
    wireframe: function(obj){
      return "<div type='button' class='Button'><span>"+(Empty(obj.value)?'Button':obj.value)+"</span></div>";
    }
  }
  this.extend( this.stdVisibleObjClass,  this.ButtonObjClass );

  this.ImageObjClass={
    newProperties:{
			generic:[
        {
          name:'keep proportions',
          propID:'keep_proportions',
          type:'select[yes:true,no:false,bounded]',
          section: 'size',
          extraClass: 'col-3',
          show_list:{
            'bounded': ['generic.bounded_position']
          },
          hide_list:{
            'true': ['generic.bounded_position'],
            'false': ['generic.bounded_position']
          },
          tooltip: `<ul>
            <li><b>Yes</b>: keeps the aspect ratio of the image by keeping the <i>width</i> set;</li>
            <li><b>No</b>: does not maintain proportions, so the image will be deformed;</li>
            <li><b>Bounded</b>: keeps the aspect ratio of the image and it will be contained in the dimensions assigned and will not exceed them in any case.</li>
            </ul>`
        }, {
          name:'bounded position',
          propID:'bounded_position',
          type:'select[,left,right,center]',
          section: 'size',
          extraClass: 'col-3',
          tooltip: 'Position of bounded image inside the ctrl container.'
        }, {
          name:'alternate text',
          propID:'alt',
          type:'str',
          section: 'accessibility',
          tooltip: 'Text shown if image error'
        }, {
          name:'help tips',
          propID:'help_tips',
          type:'str',
          section: 'accessibility',
          tooltip: 'Text shown on tooltip'
        }, {
          name:'tab index',
          propID:'tabindex',
          type:'int',
          extraClass: 'col-3',
          section: 'accessibility',
          tooltip: `Tabindex in page's elements sequence`
        }
			],
      style:[
        {
          name:'Css class',
          propID:'class_Css',
          type:'css_class',
          section: 'css class',
          extraClass: 'hide-title',
          tooltip: tooltip_css_Class
        }
      ],
      functional:[
        {
          name:'image settings',
          propID:'img_type',
          type:'select[src:default,font icon]',
          extraClass: 'col-3',
          section: 'image settings',
          show_list:{
            'default': ['functional.src', 'functional.srchover', 'functional.path_type'],
            'font icon': ['functional.font_image', 'functional.font_image_hover', 'functional.font_path', 'functional.font_name', 'functional.font_color', 'functional.font_color_hover', 'functional.font_size']
          },
          hide_list:{
            'default': ['functional.font_image', 'functional.font_image_hover', 'functional.font_path', 'functional.font_name', 'functional.font_color', 'functional.font_color_hover', 'functional.font_size'],
            'font icon': ['functional.src', 'functional.srchover', 'functional.path_type']
          },
          tooltip: `
            <p>Set image source type:
              <ul>
                <li>Src: image from url</li>
                <li>Font icon: image from glyphs of font</li>
              </ul>
            </p>`
        }, {
          name:'path type',
          propID:'path_type',
          type:'select[fixed:,themed,skin]',
          extraClass: 'col-3',
          section: 'image settings',
          tooltip: `
            <p>Image path type:
              <ul>
                <li>Fixed: image url is fixed</li>
                <li>Themed: image is searched in theme's folder, fallback in application folder</li>
                <li>Skin: image in skin's folder path. (Not serached in disk and not fallback)</li>
              </ul>
            </p>`
        }, {
          name:'name',
          propID:'font_name',
          type:'str',
          section: 'image settings',
          tooltip: `Set Icon font name. Font are available in fonts folder.`
        }, {
          name:'char',
          propID:'font_image',
          type:'str',
          extraClass: 'col-3',
          section: 'image settings',
          buttons:'pick',
          actions:'SelectIcons()',
          tooltip: `Set glyph. Format is Unicode like &#x[hexadecimal]`
        }, {
          name:'char hover',
          propID:'font_image_hover',
          type:'str',
          extraClass: 'col-3',
          section: 'image settings',
          buttons:'pick',
          actions:'SelectIcons()',
          tooltip: `Set glyph of image hover. Format is Unicode like &#x[hexadecimal]`
        }, {
          name:'color',
          propID:'font_color',
          type:'color',
          extraClass: 'col-3',
          section: 'image settings',
          tooltip: `Set image color`
        }, {
          name:'color hover',
          propID:'font_color_hover',
          type:'color',
          extraClass: 'col-3',
          section: 'image settings',
          tooltip: `Set color of image hover`
        }, {
          name:'char size(px)',
          propID:'font_size',
          type:'int',
          section: 'image settings',
          tooltip: `Set font size of glyph`
        }, {
          name:'src',
          propID:'src',
          type:'image',
          section: 'image settings',
          tooltip: `Set image's src`
        }, {
          name:'src hover',
          propID:'srchover',
          type:'image',
          section: 'image settings',
          tooltip: `Set src of image hover`
        }, {
          name:'server side',
          propID:'server_side',
          type:'checkbox',
          extraClass: 'col-3',
          tooltip: `Image is generated server side`
        }, {
          name:'dataobj',
          propID:'dataobj',
          type:'data',
          section: 'database',
          extraClass: 'col-3',
          tooltip: `Set database name for image src`
        }, {
          name:'field',
          propID:'field',
          type:'singlefield',
          dataobjref:'dataobj',
          section: 'database',
          tooltip: `Set database field name for image src`
        }, {
          name:'href',
          propID:'href',
          type:'str',
          section: 'link',
          tooltip: tooltip_href
        }, {
          name:'target',
          propID:'target',
          type:'str',
          section: 'link',
          extraClass: 'col-4',
          tooltip: tooltip_target
        }, {
          name:'submit',
          propID:'type_submit',
          type:'checkbox',
          section: 'link',
          extraClass: 'col-2',
          tooltip: `Set image click to submit form (if portlet type is form)`
        }
			],
			expression:[
				{
          name:'hide undercond',
          propID:'hide_undercond',
          type:'exp',
          tooltip:tooltip_hide
        }, {
          name:'edit undercond',
          propID:'edit_undercond',
          type:'exp',
          tooltip:tooltip_edit
        }, {
          name:'create undercond',
          propID:'create_undercond',
          type:'exp',
          tooltip:tooltip_create
        }
			]
    },
    events : [
      {
        name:'Click',
        tooltip:'Click image',
        usage: ``,
        returnValue: '',
				parameters : [
          {
            name: 'event',
            tooltip: 'standard pointer event',
            type: 'Object'
          },
        ]
			}, {
        name: 'OnError',
        tooltip:'Error in fetching image from src',
        usage:  `On error `,
        returnValue: '',
        parameters : []
      }, {
        name: 'OnLoad',
        tooltip: 'Event dispatched on image load',
        usage:  ``,
        returnValue: '',
				parameters : []
      }
    ],
    functions : stdMethods.concat([
       {
        name: 'CenterHorizontally',
        tooltip:'Center image in the middle of the portlet width',
        usage:  ``,
        returnValue: '',
        parameters : []
      }, {
        name: 'GetSrc',
        tooltip:'Get image src property',
        usage:  ``,
        returnValue: 'String',
        parameters : []
      }, {
        name: 'GetSrcHover',
        tooltip:'Get image src hover property',
        usage:  ``,
        returnValue: 'String',
        parameters : []
      }, {
        name: 'Reset',
        tooltip:'Reset event for portlet type Form',
        usage:  `Use it for reset all input of portlet type form`,
        returnValue: '',
        parameters : []
      }, {
        name: 'Resize',
        tooltip:'Resize image',
        usage:  `Use it for resize image`,
        returnValue: '',
        parameters : [
          {
            name: 'width',
            tooltip: "New image width in px. If type font icon it also set font-size (like min between width and height)",
            type: 'number',
            optional: false
          }, {
            name: 'height',
            tooltip: "New image height in px. If type font icon it also set font-size (like min between width and height)",
            type: 'number',
            optional:false
          }
        ]
      }, {
        name: 'Rotate',
        tooltip:'Getter/setter image rotation angle degree',
        usage:  `Use it for rotate image or to get current rotation angle degree. Return current angle's degree`,
        returnValue: 'number (current rotation degree)',
        parameters : [
          {
            name: 'angle',
            tooltip: "Rotation degree",
            type: 'number',
            optional: true
          }
        ]
      }, {
        name: 'SetAlt',
        tooltip:'Set image alternate text image',
        usage:  `Use if image cannot be displayed, it provides alternative information for image`,
        returnValue: '',
        parameters : [
          {
            name: 'text',
            tooltip: "Alternative text",
            type: 'string',
            optional: false
          }
        ]
      }, {
        name: 'SetHelpTips',
        tooltip:'Set title attribute',
        usage:  `Set title attribute that specifies extra information about image`,
        returnValue: '',
        parameters : [
          {
            name: 'text',
            tooltip: "Title text",
            type: 'string',
            optional: false
          }
        ]
      }, {
        name: 'Submit',
        tooltip:'Call submit of Form with action',
        usage:  `Use for call submit of Form`,
        returnValue: '',
        parameters : [
          {
            name: 'action',
            tooltip: "Action to submit",
            type: 'string',
            optional: false
          }
        ]
      }, {
        name: 'Value',
        tooltip: `Getter/setter of image's url or icon font`,
        usage:  `Set the src (and srchover) of image. If image type is "font icon", set the char in unicode encoding`,
        returnValue: '',
        parameters : [
          {
            name: 'src/char',
            tooltip: "Image src or char (unicode format like &#x[hexadecimal])",
            type: 'string',
            optional: false
          },
          {
            name: 'src-hover/char-hover',
            tooltip: "Image hover src or char (unicode format like &#x[hexadecimal])",
            type: 'string',
            optional: false
          }
        ]
      }
    ]),
    connector:[
      {'type':'iData','propID':'dataobj','versus':'in'}
    ],
    wireframe: function(obj,isVisualMode){
      if(isVisualMode) {
        var srcImage = (Empty(obj.src)) ? '../portalstudio/images/icon/imageicon.svg' : obj.src;
        var res = "";
        var classCode = getClassCode(obj.class_Css);

        if(!Empty(classCode)) {
          res += "<style>"+classCode+"</style>";
        }

        if(obj.path_type == "themed") {
          var image_url = "../" + skin + "//" + srcImage;
          var http = new XMLHttpRequest();
          http.open('HEAD', image_url, false);
          http.send();
          if(http.status != 404) {
            srcImage = image_url;
          }
        }

        res += "<div class='Image'><img class='"+obj.class_Css+"' src='"+srcImage+"' width='"+obj.w+"'";
        if(obj.keep_proportions == 'false')
          res += " height='"+obj.h+"'";
        res += " style='box-sizing: border-box;' /></div>";
        return res;
      } else {

        if(obj.img_type =='font icon'){
          ZtVWeb.RequireFont(obj.font_name);
          var size;
          if(Empty(obj.font_size)){
            size=Math.min(obj.w,obj.h);
          }else{
            size=obj.font_size;
          }
          return "<div style='font-family:"+obj.font_name+";font-size:"+size+"px;text-align:center;line-height:"+obj.h+"px;'>"+obj.font_image+"</div>";
        }

        if(obj.class_Css=='image-circle')
          return "<div class='Image image-default image-circle'></div>";
        else if(obj.class_Css=='image-thumbnail')
          return "<div class='Image image-default image-thumbnail'></div>";
        else
          return "<div class='Image image-default'></div>";
      }
    },
    preSet:[
      {'name':'Image default','class_Css':'image-default','wire_h':'120px','wire_w':'120px'},
      {'name':'Image cirlce','class_Css':'image-circle','wire_h':'120px','wire_w':'120px'},
      {'name':'Image thumbnail','class_Css':'image-thumbnail','wire_h':'120px','wire_w':'120px'}
    ]
  }
  this.extend( this.stdVisibleObjClass,  this.ImageObjClass );

  this.LabelObjClass={
    events:['Click','Drop(val_obj,drop_obj)','DragEnter(objTarget)','DragLeave(objTarget)','DragCancel()'],
    functions:
      stdMethods.concat([
          'AddCssClass(#cNewClassName#)'
        , [ 'HasCssClass(#cClassName#) -> true when label has specified css class name', 'HasCssClass(#cClassName#)' ]
        , [ 'Href(#opt_cNewHrefValue#) -> set/get hyperlink (href attribute)', 'Href(#opt_cNewHrefValue#)' ]
        , 'RemoveCssClass(#cClassName#)'
        , [ 'Value(#opt_xNewValue#) -> set/get variable value', 'Value(#opt_xNewValue#)' ]
        , [ 'setTooltip(#cText#) -> set new tooltip', 'setTooltip(#cText#)' ]
      ]),
    newProperties:{
			generic:[
				{name:'value', propID:'value', type:'str', section: 'value', extraClass: 'hide-title'},
				{name:'help tips', propID:'help_tips', type:'str', section: 'accessibility', tooltip:tooltip_helptips},
				{name:'tab index', propID:'tabindex', type:'int', section: 'accessibility', extraClass: 'col-3', tooltip:tooltip_tabindex}
			],
			style:[
				{name:'css class',   propID:'class_Css', type:'css_class', section: 'css class', extraClass: 'hide-title'},
				{name:'font',        propID:'font', type:'font-websafe', section:'font settings', tooltip:tooltip_font},
				{name:'font size',   propID:'font_size', type:'str', section:'font settings', extraClass: 'col-3', tooltip:tooltip_size},
				{name:'font percentage', propID:'fontpct', type:'int',
          tooltip:'Font size magnification (%) for current portlet step in responsive design', section:'font settings', extraClass: 'col-3', steppable:true},
				{name:'font color',  propID:'font_color', type:'color', section:'font settings', tooltip:tooltip_color},
				{name:'font weight', propID:'font_weight', type:'select[,normal,bold]', section:'font settings', extraClass: 'col-3', tooltip:tooltip_weight},
				{name:'align',       propID:'align', type:'select[,left,center,right,justify]', section:'font settings', extraClass: 'col-3', steppable:true,
          tooltip:'Set the horizontal text align inside the label container area'},
				{name:'heading',     propID:'heading', type:'select[,h1,h2,h3,h4]', section:'container settings', extraClass: 'col-2',
          tooltip:'Set the heading html tag'},
        {name:'nowrap',      propID:'nowrap', type:'checkbox',
          tooltip:'Text in only one line without overflow', section:'container settings', extraClass: 'col-2'},
        {name:'N. Col.',     propID:'n_col', type:'int',
          tooltip:'Number of columns to display the text', section:'container settings', extraClass: 'col-2', steppable:true},
				{name:'color',       propID:'bg_color', type:'color', section: 'background color', extraClass: 'hide-title',
          tooltip:tooltip_bgcolor}
			],
			functional:[
				{name:'href', propID:'href', type:'str', section:'Misc', tooltip:tooltip_href},
				{name:'target', propID:'target', type:'str', section:'Misc', tooltip:tooltip_target},
				{name:'picture', propID:'picture', type:'str', section:'Misc', tooltip:tooltip_image},
        {name:'shrinkable', propID:'shrinkable', type:'checkbox',
          tooltip:'The height of the Label may become smaller than the one set in the design', section:'Misc', extraClass: 'col-3'},
        {name:'associated input', propID:'assoc_input', type:'str', section:'Misc', extraClass: 'col-3',
          tooltip:'Set the input  that is bound to this label (for attribute)'},
				{name:'enable HTML', propID:'enable_HTML', type:'checkbox', section:'HTML Security', extraClass: 'col-3',
          tooltip:'Enable/disable the HTML output processing'},
				{name:'Secure HTML', propID:'sanitize', type:'select[none,xssPrevent,custom]', section:'HTML Security', extraClass: 'col-3',
          tooltip:'The HTML output is sanitized to prevent XSS Attack,\nxssPrevent allows the common HTML tags and disable scripts execution',
          hide_list:{'none,xssPrevent': ['this.functional_sanitize_tags']},
          show_list:{'custom' : ['this.functional_sanitize_tags']}
        },
        { name: 'Custom tags allowed', propID: 'sanitize_tags', type: 'str', section: 'HTML Security', extraClass: 'col-6',
          tooltip: 'Specifies the allowed HTML tags separated by a space, e.g. a br b div..' },
        { name: 'template', propID: 'template_code', type: 'str', section: '', buttons: 'edit', actions: 'EditTemplate()', noteditable: true, setOnBlurFunc: 'CreateTemplateConnectors',
          tooltip:tooltip_template,tooltip_width:400 },
        {name:'server side', propID:'server_side', type:'checkbox', section:'Server', extraClass: 'col-2',
          tooltip:'Set the server side generation code'},
				{name:'data source', propID:'dataobj', type:'data', section:'Server', extraClass: 'col-4',
          tooltip:'Set the data source to get the value'},
				{name:'field', propID:'field', type:'singlefield', section:'Server', dataobjref:'dataobj',
          tooltip:'Set the field if datasource selected'},
        {name:'draggable', propID:'draggable', type:'checkbox', section:'drag and drop', extraClass: 'col-2',
          tooltip:'Set the value as draggable'},
        {name:'draggable name', propID:'draggable_name', type:'str', section:'drag and drop', extraClass: 'col-4',
          tooltip:'Name of drag and drop operation'},
        {name:'droppable', propID:'droppable', type:'checkbox', section:'drag and drop', extraClass: 'col-2',
          tooltip:'Set the value as droppable'},
        {name:'droppable name', propID:'droppable_name', type:'str', section:'drag and drop', extraClass: 'col-4',
          tooltip:'Name of drag and drop operation'}
      ],
			expression:[
        {name:'init', propID:'init', type:'checkbox', extraClass: 'col-1', tooltip:tooltip_init},
				{name:'calculate', propID:'calculate', type:'exp', extraClass: 'col-5', tooltip:tooltip_calc},
				{name:'hide undercond', propID:'hide_undercond', type:'exp', tooltip:tooltip_hide},
        {name:'edit undercond', propID:'edit_undercond', type:'exp', tooltip:tooltip_edit},
				{name:'create undercond', propID:'create_undercond', type:'exp', tooltip:tooltip_create}
			]
    },
    connector:[
      {'type':'iRequest','propID':'value','versus':'in'},
      {'type':'iData','propID':'dataobj','versus':'in'}
    ],
    wireframe: function(obj,isVisualMode){
      var fontSize = (!Empty(obj.font_size) ? obj.font_size : '');
      var fontPct = (!Empty(obj.fontpct) ? obj.fontpct+'%' : '');
      var fontColor = (!Empty(obj.font_color) ? obj.font_color : '');
      var fontFamily = (!Empty(obj.font) ? obj.font : '');
      var background = (!Empty(obj.bg_color) ? obj.bg_color : '');
      var className='';
      if( obj.align == 'left')
          className += "left";
        if( obj.align == 'right')
          className += "right";
        if( obj.align == 'center')
          className += "center";
        if( obj.align == 'justify')
          className += "justify";
      var loremIpsum ="Lorem ipsum dolor sit amet, ei dolorem temporibus est. Laudem possim vivendum ea ius, duo fugit virtute volumus ea, eum prima reque clita eu."
      +"Mucius quaeque tincidunt quo eu. Et tale mutat quidam nec, possit singulis no eam. Eum in solet adipisci, usu te everti perfecto. Et copiosae vituperata pri, et pri verear accumsan. Nam inimicus aliquando ea, ad pro elit mutat aeque, probo molestiae usu ad"
      +"Mucius quaeque tincidunt quo eu. Et tale mutat quidam nec, possit singulis no eam. Eum in solet adipisci, usu te everti perfecto. Et copiosae vituperata pri, et pri verear accumsan. Nam inimicus aliquando ea, ad pro elit mutat aeque, probo molestiae usu ad";

      var tag = (!Empty(obj.heading) && isVisualMode == 'true') ? obj.heading : 'div';
      var res = "";
      if(isVisualMode) {
        res += "<style>"+getClassCode(obj.class_Css)+"</style>";
      }
      res += "<"+tag+" class='Label "+className+" "+obj.class_Css+"' style='";
      var defaultMode = "font-size:"+fontSize
          +";font-size:"+fontPct
          +";font-family:"+fontFamily
          +";text-align:"+obj.align;
      if(obj.n_col > 0) {
        defaultMode += ";-webkit-column-count:"+obj.n_col
          +";-moz-column-count:"+obj.n_col
          +";column-count:"+obj.n_col;
      }
      if(isVisualMode) {
        res += ";color:"+fontColor+";background:"+background;
        if(obj.nowrap == 'true') res+= ";white-space: nowrap";
        res += ";min-height: 100%;box-sizing: border-box;overflow:hidden;";
      }
        defaultMode += (obj.enable_HTML == "true" && (obj.sanitize == "" || obj.sanitize == "none") ? ";color:#D8000C;background: #FFBABA" : "");
      res += defaultMode +"'>";
      if(Empty(obj.value) || (obj.value=='Label text' && (obj.n_col>1 || obj.align == 'justify')))
        res += loremIpsum;
      else
        res += obj.value;

      res += "</"+tag+">";
      return res;
    },
    preSet:[
      {'name':'label sx','align':'left','value':'Label text','n_col':1},
      {'name':'label dx','align':'right','value':'Label text','n_col':1},
      {'name':'label center','align':'center','value':'Label text','n_col':1},
      {'name':'label justify','align':'justify','value':'Lorem ipsum dolor sit amet, ei dolorem temporibus est. Laudem possim vivendum ea ius..','n_col':1},
      {'name':'label 2 col','align':'left','n_col':2,'value':'Lorem ipsum dolor sit amet, ei dolorem temporibus est. Laudem possim vivendum ea ius..'}
    ],
    notifications: function (obj) {
      obj.notifications = [];
      if (obj.enable_HTML == "true" && (obj.sanitize == "" || obj.sanitize == "none")) {
        obj.notifications.push({ 'message': 'Warning: Security Xss vulnerability.', 'tab': 'functional', 'prop': 'sanitize' });
        return;
      }
    }
  }
  this.extend( this.stdVisibleObjClass,  this.LabelObjClass );

  this.SQLDataobjClass={
	  newProperties:{
      generic:[],
      functional:[
				{name:'param. source', propID:'parms_source', type:'str',tooltip:'one or more parameter sources can be specified', list:"true" },
				{name:'query', propID:'query', type:'str', setOnBlurFunc:function(){setPropertyValue(false,'functional','allowedqueries',getPropertyValue(false,'functional','query'));},
          tooltip: `<ul><li><b>query name</b> use query name for data form database</li>
                    <li><b>rows:<routine-function-name></b> define function that return memory cursor object </li>
                    <li><b>json:<url></b> define url that return json format data</li>`
        },
        {name:'allowed query', propID:'allowedqueries', type:'querylist', list:"true",
          tooltip: "Lists of allowed queries for this dataobj separated by commas or how they should start with using \"*\" (Es: myquery*).<br>if empty all queries are allowed (bad security)."},
				{name:'parameters',   propID:'parms', type:'parameters', tooltip:tooltip_params},
				{name:'n records', propID:'n_records', type:'str', tooltip:'Numeric value limiting record extraction'},
        {name:'exec mode', propID:'auto_exec', type:'select[client autoexec :true,client ondemand:false,client with server init:server-client,both server and client:server,sever and client ondemand:server-client-ondemand, server-only:server-only]',
          tooltip:"client autoexec: on loading it calls the data in ajax mode.(you can use only client ctrls)<br><br>"
                  +"client ondemand: it calls the data in ajax mode when calling the Query() function.(you can use only client ctrls)<br><br>"
                  +"client with server init: on loading it calls the data server side and then in ajax mode.(you can use only client ctrls)<br><br>"
                  +"both server and client: it calls the data both server side and in ajax mode.(you can use both server-side ctrls and client ctrls)<br><br>"
                  +"server and client ondemand: it calls the data both server side and in ajax mode, but client when calling the Query().(you can use both server-side ctrls and client ctrls)<br><br>"
                  +"server-only: it calls the data server side.(you can use only server-side ctrls)<br>"
        },
				{name:'count records', propID:'count', 	type:'checkbox', extraClass: 'col-3',
          tooltip: 'If checked, calculates the number of records extracted by the query associated with it.'},
        {name:'return fields type', propID:'return_fields_type',type:'checkbox', extraClass: 'col-3',
          tooltip:'If checked, the returned data structure also contains the type of data extracted from the DataObject'},
				{name:'async query', propID:'query_async', type:'checkbox', extraClass: 'col-3',
          tooltip:'If checked, the query on the DataObject is performed asynchronously'},
        {name:'offline', propID:'offline', type:'checkbox',
          hide_list:{'unchecked': ['this.functional_localDBName'], 'checked' :['functional.query_async']},
          show_list:{'checked' : ['this.functional_localDBName'], 'unchecked':['functional.query_async']},
          extraClass: 'col-3',
          tooltip:'If selected, the DataObject is of the offline type, ie it works on the local database relating to the offline application'
        },
        {name:'Local DB Name', propID:'localDBName', type:'str', extraClass: 'col-2',
          tooltip: "Sets the database to be queried using offline apps. Leave it blank to use the default app database name."
        },
        {name:'Appends Data', propID:'appendingData', type:'checkbox',disabled:"true", extraClass: 'col-2'},
        {name:'client db', propID:'clientDB', type:'checkbox', disabled:"true", extraClass: 'col-2'},
      ],
      extra: [
        {name:'long lasting query', propID:'long_query', type:'checkbox', extraClass: 'col-3', tooltip:'If the execution time is extended and if it is checked, the management of an additional customizable layer is activated'},
        {name:'time before coming out', propID:'init_time', type:'int', extraClass: 'col-3', tooltip: 'Time before coming out in ms'},
        {name:'waiting msg', propID:'waiting_mgs', type:'str', tooltip: 'HTML message for waiting'},
        {name:'dialog css class', propID:'dialog_css_class', type:'str', tooltip:'Customizable layer CSS class'}
      ],
      encrypt:[
        {name:'Encrypted output fields ', propID:'encrypted_fields', type:'datafield', dataobjref:'name' ,
          tooltip:'List fo fields to encrypt separated by commas.', extraClass: 'col-3', section:'Crypt value'},
        {name:'Encrypted fields seed ', propID:'encrypted_fields_pwd',
          tooltip:'Optional seed for this encryption.<br>If empty it is random generated and no other portlet can decrypt this element.', type:'str', extraClass: 'col-3', section:'Crypt value' ,
          validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;
          }}},
        {name:'Encrypted params', propID:'decrypted_parms' , type:'str',
          tooltip:'List of encrypted parameters separated by commas.', extraClass: 'col-3', section:'Crypt value'},
        {name:'Encrypted parms seed ', propID:'decrypted_parms_pwd', type:'str',
          tooltip:'Optional seed for this decryption.<br>If empty it is random generated and only variables of this portlet can be decrypted.', extraClass: 'col-3', section:'Crypt value',validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;}}},

      ]
		},
		events: ['RecordChanged','QueryExecuted','BeforeQuery','ConsumersRendered','Error(#message#)','Abort'],
		functions:[
       'Query(#opt_bKeepPage#)'
      ,'QueryTimeStamp(#timestamp#)'
      ,'ChangeQuery(#newQuery#)'
      ,'GetQueryCount()'
      ,'NextPage()'
      ,'PrevPage()'
      ,'Next()'
      ,'Prev()'
      ,'isLastRec()'
      ,'isFirstRec()'
      ,'CurRec()'
      ,'IsEmpty()'
      ,'rs.#field#'
      ,'SetOrderBy(#field dir#)'
      ,'FillExtData(#flds#,#data#)'
      ,['GetRowsNumber()', 'GetRowsNumber', 'Get rows number of query']
      ,['SetRowsNumber(#nRows#)', 'SetRowsNumber', 'Set rows number of query']
    ],
    connector:[
      {'type':'iData','propID':'parms_source','versus':'in'},
      {'type':'iParameter','propID':'parms','versus':'in'},
      {'type':'iData','versus':'out'}
    ],
    names:['../portalstudio/images/component/desk_dataobj_sql.png','../portalstudio/images/component/desk_dataobj_sql.png'],
    notifications:function(obj){
      obj.notifications=[];
      if(Empty(obj.query)){
        obj.notifications.push({'message':'Select a query.','tab':'functional','prop':'query'});
        return;
      }
    }
  }
  this.extend( this.stdHiddenObjClass , this.SQLDataobjClass );

  this.XMLDataobjClass={
		newProperties:{
      generic:[],
			functional:[
				{name:'source', propID:'source', type:'str'},
				{name:'xmldataobj', propID:'xmldataobj', type:'xmldata'},
				{name:'parameters', propID:'parms', type:'parameters', tooltip:tooltip_params},
				{name:'param. source', propID:'parms_source', type:'str'},
				{name:'root', propID:'root', type:'str'},
				{name:'auto exec', propID:'auto_exec', type:'select[true,false,server,server-only]'
          , hide_list: { 'server,server-only': ['this.functional_async'], 'true,false' : ['this.functional_n_records'] }
          , show_list: { 'server,server-only' : ['this.functional_n_records'], 'true,false' : ['this.functional_async'] }
        },
        {name:'async query', propID:'async', type:'checkbox'},
        {name:'n records', propID:'n_records', type:'int', tooltip:"n rows per page if server-side" }
			]
		},
		functions:[
       'Query(#timestamp#)'
      ,'Next()'
      ,'Prev()'
      ,'setXMLString(cXmlString)'
      ,'setXMLSourceString(cXmlString)'
      ,'rs.#field#'
      ,'SetFieldType(fld,type)'
    ],
    names:['../portalstudio/images/component/desk_dataobj_xml.png','../portalstudio/images/component/desk_dataobj_xml.png'],
		events:['RecordChanged','QueryExecuted'],
    connector:[
      {'type':'iXml','propName':'xmldataobj','propID':'xmldataobj','versus':'in'},
      {'type':'iData','propName':'param. source','propID':'parms_source','versus':'in'},
      {'type':'iParameter','propID':'parms','versus':'in'},
      {'type':'iData','versus':'out'},
      {'type':'iXml','versus':'out'}
    ]
	}
  this.extend( this.stdHiddenObjClass , this.XMLDataobjClass );

  this.JSONDataobjClass={
		newProperties:{
      generic:[],
			functional:[
				{name:'source', propID:'source', type:'str'},
				{name:'parameters', propID:'parms', type:'parameters', tooltip:tooltip_params},
				{name:'param. source', propID:'parms_source', type:'str', tooltip: 'Comma separated list of parameter source names'},
				{name:'root', propID:'root', type:'str', tooltip:'Indicates the json path from which to start'},
				{name:'auto exec', propID:'auto_exec', type:'select[true,false]',
          tooltip: 'true: on loading it calls the source data. <br> false: it calls the source data when calling the Query() function.'
        },
        {name:'async', propID:'async', type:'checkbox', tooltip: 'If checked, make calls to the server asynchronously'}
			]
		},
		functions:[
      {
        name:'Query',
        tooltip:'Call the data source',
        returnValue: ''
			}, {
        name:'Next',
        tooltip:'Select next record'
			}, {
        name:'Prev',
        tooltip:'Select prev record'
			}, {
        name:'setJSONString',
        tooltip:'Fill dataprovider with json data',
          parameters: [{
            name: 'cJSONString',
            tooltip: 'Json data',
            type: 'String'
          }]
			}, {
        name:'rs.#field#',
        tooltip:'Get record field value',
        returnValue: 'String or int'
			}, {
        name:'SetFieldType',
        tooltip:'Set the type of the field',
        parameters:[
          {
            name: 'fld',
            tooltip: 'Field name',
            type: 'String'
          },
          {
            name: 'type',
            tooltip: 'Type of the field',
            type: 'String'
          }
        ]
			}
    ],
    names:['../portalstudio/images/component/desk_dataobj_json.png','../portalstudio/images/component/desk_dataobj_json.png'],
		events:[{
        name:'QueryExecuted',
        tooltip:'Event dispatch when query has been executed'
      }, {
        name:'RecordChanged',
        tooltip:'Event dispatch when change current record'
      }, {
        name:'ConsumersRendered',
        tooltip:'Event dispatch when all the consumers attached to the dataprovider are rendered'
      }],
    connector:[
      {'type':'iData','propName':'param. source','propID':'parms_source','versus':'in'},
      {'type':'iParameter','propID':'parms','versus':'in'},
      {'type':'iData','versus':'out'}
    ]
	}
  this.extend( this.stdHiddenObjClass , this.JSONDataobjClass );

  this.StaticDataProviderClass={
    newProperties: {
      generic: [],
      functional:[
        {
          name:'Fields Name',
          propID:'alias',
          type:'str',
          viewType:{type:'stringSeparatedValue'},
          tooltip: 'Comma separated list of field names'
        }, {
          name: 'Fields Type',
          propID: 'fieldsType',
          type: 'str',
          viewType:{type:'stringSeparatedValue'},
          tooltip: 'Comma separated list of field types. Types can be one of (C,D,T,N,L,J)'
        }, {
          name: 'source db list',
          propID: 'dataproviders',
          type: 'select',
          buttons: 'plus,del',
          actions: "newMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})",
          multiple: {
            'type': 'combo',
            'id': 'dataproviders',
            'fillFnc': 'getDataproviders()'
          },
          section: 'ClientSide query',
          tootip: 'Ordered list of source of dataprovider. Specify the source for query'
        }, {
          name: 'query',
          propID: 'man_query',
          type: 'str',
          buttons: 'edit,pick',
          actions: 'ZTObjects.EditQuery(),EditClientQuery()',
          section: 'ClientSide query',
          tooltip: `<p>Query that operate <b>over source db list</b>.
            Query can be create with VisualQuery Editor or in manual mode.
            (Expert mode): "?" can replace in sequence the ordered datasource and the query parameters`
        }, {
          name: 'auto exec',
          propID: 'auto_exec',
          type: 'select[auto exec:true,manual exec:false]',
          section: 'ClientSide query',
          tooltip: 'Query is auto exec when datasource provide data. Is Manual exec if it will be called from action code'
        }, {
          name:'param. source',
          propID:'parms_source',
          type:'str',
          tooltip: 'Comma separated list of parameter source names'
        } ,{
          name: 'parameters',
          propID: 'parms',
          type: 'parameters',
          tooltip: tooltip_params
        },
      ]
    },
    functions: [
      {
        name:'FillData',
        tooltip:'Fill dataprovider with data matrix',
        usage: `Firt level matrix is the record data, the second level matrix is the data column values`,
        returnValue: '',
				parameters : [
          {
            name: 'data',
            tooltip: 'data matrix',
            type: 'Object'
          }
        ]
			}, {
        name:'Query',
        tooltip:'Query over data',
        usage: ``,
        returnValue: '',
				parameters : []
			}, {
        name:'Next',
        tooltip:'Select next record',
        usage: ``,
        returnValue: '',
				parameters : []
			}, {
        name:'Prev',
        tooltip:'Select prev record',
        usage: ``,
        returnValue: '',
				parameters : []
			}, {
        name:'SetOrderBy',
        tooltip:'Set order by from column and versus',
        usage: `SetOrderBy("field_name desc, field_name2 asc, ..")`,
        returnValue: '',
				parameters : [
          {
            name: 'orderby_field orderby_versus',
            tooltip: 'Comma separated list of pair of orderby field name and order by versus(asc or desc)',
            type: 'String'
          }
        ]
			}, {
        name:'rs.#field#',
        tooltip:'Get record field value',
        usage: ``,
        returnValue: 'String or int',
				parameters : []
			}, {
        name:'isLastRec',
        tooltip:'Return true if current is the last record of dataprovider',
        usage: ``,
        returnValue: 'Boolean',
				parameters : []
			}, {
        name:'isFirstRec',
        tooltip:'Return true if current is the first record of dataprovider',
        usage: ``,
        returnValue: 'Boolean',
				parameters : []
			}, {
        name:'SetQuery',
        tooltip:'Set sql query for AlaSQL mode',
        usage: ``,
        returnValue: '',
				parameters : [
          {
            name: 'jsonQuey',
            tooltip: `Text of Json query produced from Visual Query Editor called from
              Query field of this item. It can be copy/paste from query field to
              change this at run time`,
            type: 'String'
          }
        ]
			}
    ],
    events : [
      {
        name:'QueryExecuted',
        tooltip:'Event dispatch when query start',
        usage: ``,
        returnValue: '',
				parameters : []
			}, {
        name:'RecordChanged',
        tooltip:'Event dispatch when change current record',
        usage: ``,
        returnValue: '',
				parameters : []
			}
    ],
    names: ['../portalstudio/images/icon/bot_dataobj_static_off.png','../portalstudio/images/component/desk_dataobj_static.png'],
    connector:[
      {'type':'iData','propID':'parms_source','versus':'in'},
      {'type':'iParameter','propID':'parms','versus':'in'},
      {'type':'iData','propName':'source db','propID':'dataproviders','versus':'in'},
      {'type':'iData','versus':'out'}
    ]
  };
  this.extend(this.stdHiddenObjClass, this.StaticDataProviderClass);


  this.MaskParametersClass={
	newProperties:{
		Generic:[
			  {
          name:'name',
          propID:'name',
          type:'str',
          tooltip:'Name of the Ctrl'
        },
			  {name:'x',			propID:'x',				type:'int', section:'position', extraClass:'col-3'},
			  {name:'y',			propID:'y',				type:'int', section:'position', extraClass:'col-3'},
			  {name:'anchor',		propID:'anchor',		type:'select[,top-left,top-right,top-left-right]', section:'position'},
			  {name:'width',		propID:'w',				type:'int', section:'size', extraClass:'col-3'},
			  {name:'height',		propID:'h',				type:'int', section:'size', extraClass:'col-3'}
		],
		Functional:[
			  {
          name:'Config name',
          propID:'ConfigName',
          type:'vdmdef',
          tooltip:'Set the VDM configuration file'
        },
			  {
          name:'Emitter name',
          propID:'EmitterName',
          type:'str',
          tooltip:'Set the name of the emitter'
        },
			  {
          name:'Decoration',
          propID:'Decoration',
          type:'select[,none]',
          tooltip:'If none, the title of the vdm will be hidden'
        },
			  {
          name:'Version menu',
          propID:'versionMenu',
          type:'select[,none]',
          tooltip:'If none, the version menu will be hidden'
        },
			  //{name:'Dataobj',		propID:'dataobj',		type:'data'},
        {
          name:'Bo name',
          propID:'boName',
          type:'bofield',
          section:'Load data from BO',
          tooltip:'If specified, the mask will load the BO data'
        },
        {
          name:'Save BO button',
          propID:'saveBO',
          type:'checkbox',
          section:'Load data from BO',
          tooltip:'If true, a button will be added to be able to save the changes on the BO'
        },
        {
          name:'PK Fields',
          propID:'PKFields',
          type:'str',
          section:'Load data from BO',
          tooltip:'List, comma separated, of the primary keys'
        },
        {
          name:'PK Values',
          propID:'PKValues',
          type:'str',
          section:'Load data from BO',
          tooltip:'List, comma separated, of the values of the primary keys specified'
        }
		]
  },
  names : ['../portalstudio/images/component/bot_vdm.png','../portalstudio/images/component/bot_vdm.png'],
  functions:[
    {
      name:'GetParameterValue(#paramName#)',
      tooltip:'The function return the value of the field specified',
      returnValue:'any',
      parameters:[
        {
          name:'paramName',
          type:'string',
          tooltip:'The Field name'
        }
      ]
    },
    {
      name:'GetParametersValue()',
      tooltip:'The function return a JSON Object with all the parameters value',
      returnValue:'JSON Object'
    },
    {
      name:'Reload()',
      tooltip:'Reload the vdm mask and reset all the parameters',
      returnValue:''
    },
    {
      name:'Resize(#width#,#height#)',
      tooltip:'Resize the mask',
      parameters:[
        {
          name:'width',
          type:'int',
          tooltip:'The width of the mask'
        },
        {
          name:'height',
          type:'int',
          tooltip:'The height of the mask'
        }
      ]
    },
    {
      name:'SetConfigName(#configName#)',
      tooltip:'Change the vdm configuration file',
      parameters:[
        {
          name:'configName',
          type:'str',
          tooltip:'The VDM configuration file'
        }
      ]
    },
    {
      name:'SetEmitterName(#emitterName#)',
      tooltip:'Change the emitter name',
      parameters:[
        {
          name:'emitterName',
          type:'str',
          tooltip:'The emitter name'
        }
      ]
    },
    {
      name:'SetBOName(#boName#)',
      tooltip:'Set the BO name',
      parameters:[
        {
          name:'boName',
          type:'str',
          tooltip:'The BO name. The mask will load the data from the BO specified'
        }
      ]
    },
    {
      name:'SetPKFields(#PKFields#)',
      tooltip:'Set the list of the primary keys',
      parameters:[
        {
          name:'PKFields',
          type:'str',
          tooltip:'List, comma separated, of the primary keys'
        }
      ]
    },
    {
      name:'SetPKValues(#PKValues#)',
      tooltip:'Set the list of the primary keys values',
      parameters:[
        {
          name:'PKValues',
          type:'str',
          tooltip:'List, comma separated, of the primary keys values'
        }
      ]
    },
    {
      name:'SetValue(#paramName#,#paramValue#)',
      tooltip:'Set the value of a parameter',
      parameters:[
        {
          name:'paramName',
          type:'str',
          tooltip:'Name of a parameter to set the value'
        },
        {
          name:'paramValue',
          type:'any',
          tooltip:'The new value of the parameter'
        }
      ]
    }
  ],
};

this.XZoomClass = {
	newProperties:{
		generic:[
		  {name:'tableName',			propID:'tableName',		    type:'str', buttons:'pick', actions:'getTable()', tooltip:'Name of the table to which the zoom refers'},
		  {name:'key',			propID:'key',		    type:'str', tooltip:'Comma-separated list of primary keys'},
		  {name:'config',			propID:'config',		type:'str', buttons:'pick,edit,new', actions:'openConfigZoom(),editZoom(),newZoom()', tooltip:'Name of the configuration to which the zoom refers'},
		  {name:'autozoom',			propID:'autozoom',		type:'str', tooltip:'Name of the BO to which the zoom refers'}
		],
    functional:[
		  {name:'Grid Min Height',			propID:'minheight',		type:'str', extraClass: 'col-3', tooltip:'minimum height of the rendered content'},
		  {name:'Infinite Scroll',			propID:'infinite_scroll',		type:'checkbox', extraClass: 'col-3', tooltip:'activate the infinite scroll'},
		  {name:'checkbox',			propID:'checkbox',		type:'checkbox', extraClass: 'col-3', tooltip:'Activate the row checkbox'},
		  {name:'check All',			propID:'checkAll',		type:'select[false,true,true-of-Page]', extraClass: 'col-3', tooltip:'Activate select all checkbox'},
		  {name:'other parameters',			propID:'other',			type:'str' , tooltip:'Comma-separated list of other optional parameters'}
    ]
	  },
	events : ['Grid_onColumnClick','Grid_BeforeRowChange(currdRecIdx,nextRecIdx)','Grid_AfterRowChange(currRecIdx,prevRecIdx)'
           ,'Grid_BeforeRowChange_Click(currdRecIdx,nextRecIdx)','Grid_AfterRowChange_Click(currRecIdx,prevRecIdx)','Grid_SelectionChange(state)'
           ,'Grid_DataChange','Grid_Calculate(fld)','Grid_RowsChanged(rows)','Grid_SelectAllChange','Grid_Validate_SetCheckBoxAllOfPage','Grid_FiltersApplied','Grid_UpdatedBO(op,err)'
           ,'Grid_Rendered()','Chart_Rendered()'],
	functions : ['GetSelectedDataAsTrsString()','AllChecked()','SelectQueryName(#queryName#)'],
	names : ['images/XZoom_small.png','images/XZoom.png']
};

this.extend(this.stdVisibleObjClass, this.XZoomClass);


  this.GridObjClass={
    newProperties:{
      generic:[
        {name:'server side', propID:'server_side', type:'checkbox', section: 'data object', extraClass: 'col-2', tooltip:'Run server-side grid.<br><br>To activate this option, the <b><i>Exec mode</i></b> property of the associated dataobj must have the value <i>Server</i> or <i>Server-only</i>. In addition, the value of the dataobj\'s <b><i>Sequence</i></b> property must be less than the value of the grid\'s <b><i>Sequence</i></b> property.'},
        {name:'data source', propID:'dataobj', type:'data', section: 'data object', extraClass: 'col-4', tooltip:'DataObject associated with the grid.<br>The list contains all the DataObjects drawn in the portlet.'},
        {name:'n. rows', propID:'rows', type:'int', section: 'grid settings', extraClass: 'col-2', tooltip:'Number of rows to display'},
        {name:'align', propID:'align', type:'select[left,center,right]', section: 'grid settings', extraClass: 'col-2', tooltip:'Specifies the horizontal alignment of cell contents'},
        {name:'valign', propID:'valign', type:'select[,top,middle,bottom]', section: 'grid settings', extraClass: 'col-2', tooltip:'Specifies the vertical alignment of cell contents'}
      ],
      style:[
        {name:'font',propID:'font',type:'font-websafe', section: 'font' , extraClass: 'col-3', tooltip:tooltip_font},
        {name:'font color',propID:'font_color', type:'color', section: 'font', extraClass: 'col-3', tooltip:tooltip_color},
        {name:'font size',propID:'font_size',type:'str', section: 'font', extraClass: 'col-3', tooltip:tooltip_size},
        {name:'font weight',propID:'font_weight',type:'select[,normal,bold]', section: 'font', extraClass: 'col-3', tooltip:tooltip_weight},
        {name:'link underlined',propID:'link_underlined',type:'checkbox', extraClass: 'col-3', tooltip:'If checked, an underline is applied to the link'},
        {name:'title color',propID:'title_color',type:'color', section: 'table', tooltip:'Color applied to title'},
        {name:'over color',propID:'over_color',type:'color', extraClass: 'col-3', section: 'table', tooltip:'Color used when the mouse passes over a Hyperlink inside the grid'},
        {name:'line color',propID:'line_color',type:'color', extraClass: 'col-3', section: 'table', tooltip:'Color of the grid lines'},
        {name:'row color',propID:'row_color',type:'color', extraClass: 'col-3', section: 'table', tooltip:'Color used for the background of the grid lines'},
        {name:'row color odd',propID:'row_color_odd',type:'color', extraClass: 'col-3', section: 'table', tooltip:'Color used for the background of the odd lines of the grid'},
        {name:'cellspacing',propID:'cellspacing',type:'int', extraClass: 'col-3', section: 'table', tooltip:'Indicates the vertical and horizontal space between grid cells'},
        {name:'cellpadding',propID:'cellpadding',type:'int', extraClass: 'col-3', section: 'table', tooltip:'Indicates the vertical and horizontal space between the cell and its contents'},
        {name:'show all rows', propID:'empty_rows', type:'checkbox', tooltip:'Show all (Empty) rows to the end', extraClass: 'col-3'},
        {name:'hide empty rows', propID:'hide_empty_lines', type:'checkbox', tooltip:'Hide Empty lines (also the newLines)', extraClass: 'col-3'},
        {name:'Cards Rows',propID:'floatRows',type:'checkbox', tooltip:'Every row is an indipendent block in Card mode', extraClass: 'col-3'},
        {name:'height behaviour',propID:'scroll_bars',type:'select[grows:false,fixed height:true,fixed height with fixed titles:fixed-titles,incremental scroll:infinite_scroll]', tooltip:"Set the height behaviour" , extraClass: 'col-3'}
      ],
      functional:[
        {name:'filters',propID:'filters',type:'select[false,true,true-by-example]', tooltip:'Allows you to view the icon that allows the user to filter the data in the <b><i>Grid</i></b>.<br><br>Values allowed are:<br><ul><li><b>False</b>: the filter icon is not displayed</li><li><b>True</b>: the filter icon is displayed.</li><li><b>True-by-Example</b>: Gives the possibility to create an immediate filter on a field with the value of the selected cell</li> </ul>'},
        {name:'splinker',propID:'splinker',type:'str',extraClass: 'col-3', tooltip:'It allows you to specify a Sprinkler that is used to launch one of the managements associated with the tables involved in the query.<br><br> The call can be customized by adding parameters (for details see the <i>help</i> )'},
        {name:'Bo Operation position',propID:'splinker_pos',type:'select[left,left-layer,right,right-layer,toolsbar,expanding-row,swipe]', extraClass: 'col-3', tooltip:'The position where to show the splinker toolbar.'},
        {name:'Portlet In Row',propID:'portlet_in_row',type:'portlet',extraClass: 'col-6',tooltip:"Specifies a portlet that replaces the Splinker toolbar (expanding-row) to customize it.<br>It's possible to send Fields value as parameter like this way:<br>"
                                                                                                   +"example_portlet.jsp?Field1_param=%Field_name%.."},
        {name:'Render totals',propID:'render_totals',type:'checkbox', extraClass: 'col-2', tooltip:'If selected, the grid draws a field containing the totals as an additional cell at the end of the column'},
        {name:'group repeated', propID:'group_repeated', type:'checkbox', extraClass: 'col-2', tooltip:'Group all contiguous repeating fields and display only the first, subsequent repeating fields will be left blank'},
        {name:'shrinkable', propID:'shrinkable', type:'checkbox' ,tooltip:'The height of the grid may become smaller than the one set in the designer', extraClass: 'col-2'},
        {name:'enable navbar',propID:'nav_bar',type:'select[false,true,always]', section: 'navbar',
          hide_list:{'false': ['this.functional_nav_bar_firstlast','this.functional_nav_bar_addremove','this.functional_nav_bar_pagepanel'],'true,always':[]},
          show_list:{'true,always':['this.functional_nav_bar_firstlast','this.functional_nav_bar_addremove','this.functional_nav_bar_pagepanel'],'false':[]},
          tooltip:'Allows you to choose whether to insert the navigation bar.'
        },
        {name:'first/last page buttons', propID:'nav_bar_firstlast',type:'checkbox', extraClass: 'col-2', section: 'navbar',
          tooltip:'If checked, it shows the first and last page buttons'
        },
        {name:'add/remove rows buttons', propID:'nav_bar_addremove', type:'checkbox', extraClass: 'col-2', section: 'navbar',
          tooltip:'If selected, show the buttons to add and remove rows to the grid.<br>It is only available if the <b><i>Nav0bar</i></b> property is set to <i>True</i> or to <i>Always</i>.'
        },
        {name:'view page panel', propID:'nav_bar_pagepanel', type:'checkbox', extraClass: 'col-2', section: 'navbar',
          hide_list:{'unchecked' :['this.functional_nav_bar_changepage','this.functional_nav_bar_lastpage'],'checked':[]},
          show_list:{'checked' :['this.functional_nav_bar_changepage','this.functional_nav_bar_lastpage'],'unchecked':[]},
          tooltip:'If selected, shows the part displaying the current page and the number of pages'
        },
        {name:'view pages number', propID:'nav_bar_lastpage', type:'checkbox', section: 'navbar', extraClass: 'col-2',
          tooltip:'If checked, it shows the total number of pages (or, if not yet available, the number of pages loaded followed by the '+' symbol)'
        },
        {name:'enable change page input', propID:'nav_bar_changepage', type:'checkbox', section: 'navbar', extraClass: 'col-2',
          tooltip:'If checked, enable input to select the page you want to scroll to'
        },
        {name:'print result', propID:'print_result', type:'checkbox', section: 'print', extraClass: "col-3",
          hide_list:{
            'unchecked' :['this.functional_print_title','this.functional_print_option','this.functional_print_hideexport','this.functional_print_hidesettings'
                         , 'this.functional_print_totals','this.functional_print_size','this.functional_print_outputf','this.functional_print_max','this.functional_print_grep'],
            'checked':[]
          },
          show_list:{
            'checked' :['this.functional_print_title','this.functional_print_option','this.functional_print_hideexport','this.functional_print_hidesettings'
                       , 'this.functional_print_totals','this.functional_print_size','this.functional_print_outputf','this.functional_print_max','this.functional_print_grep'],
            'unchecked':[]
          },
          tooltip:'It allows printing the content of all the pages of the grid in various formats.<br>Available formats are:<ul><li>CSV</li><li>Standard CSV</li><li>HTML</li><li>PDF</li><li>PDF/A 1-B</li><li>SDF</li><li>XML</li><ul>'
        },
        {name:'columns width', propID:'print_size', type:'select[default,columns grid width:grid]', extraClass: 'col-3', section: 'print', tooltip:'default: the width of the column is sized according to the length of the field<br>columns\' grid width: the width of the column is sized according to the referred in grid'},
        {name:'output format', propID:'print_outputf', type:'select[default,PDF,HTML,CSV,CSV Std:CSVS,SDF:CSV2,XML,Struct.XML:XMLS,XLS,XLSX]', section: 'print', tooltip:'Select a fixed output format for the print', extraClass: 'col-3'},
        {name:'maximized print', propID:'print_max', type:'checkbox', section: 'print', tooltip:'Select for maximed layer', extraClass: 'col-3'},
        {name:'print option', propID:'print_option', type:'select[default,preview,print]', extraClass: 'col-3', section: 'print', tooltip:'default: Enable preview and print mode.<br>preview: Enable only preview mode.<br>print: Enable only priny mode.'},
        {name:'print title', propID:'print_title', type:'str', extraClass: 'col-3', section: 'print', tooltip:'Set title of the print'},
        {name:'print totals', propID:'print_totals', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Print totals in default model'},
        {name:'print as group repeated', propID:'print_grep', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'If checked, print as group repeated'},
        {name:'hide export options', propID:'print_hideexport', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Hide mail and download options'},
        {name:'hide settings options', propID:'print_hidesettings', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Hides the option for changing settings '}
      ],
      columns:[
        {name:'column properties', propID:'colProperties', type:'str', noteditable:true, section: 'columns', tooltip:'Grid column list'},
        {name:'', propID:'fields_type', type:'str', disabled:true},
        {name:'',propID:'resizablecolumns',type:'checkbox', disabled:true},
        {name:'draggable columns',propID:'draggablecolumns',type:'checkbox', extraClass: 'col-3', section: 'columns', tooltip:'If checked, enable the possibility to move the columns of the grid with a simple drag and drop on it'},
        {name:'draggable row values',propID:'draggable_row',type:'checkbox',tooltip:'You can drag the recmark containing an object with the fields values', extraClass: 'col-3', section: 'columns'},
        {name:'draggable name',propID:'draggable_name',type:'str',
          tooltip:'Name of drag and drop operation', extraClass: 'col-3', section: 'columns'},
        {name:'orderby', propID:'orderby', type:'checkbox', extraClass: 'col-3', section: 'columns', tooltip:'If checked, displays arrows for ascending or descending sort on each column of the grid'},
        {name:'extensible',propID:'extensible',type:'select[false,open-extended,open-reduced]', extraClass: 'col-3', section: 'columns',
          tooltip:'Make fields set as optional visible.<br><br>Possible value are:<br><ul><li><i><b>False</b></i>: This is the default setting. All fields are visible. Matches pre-implementation behavior;'+
                  '</li><br><li><i><b>Open-extended</b></i>: Display the grid with all its fields as for the value <i>False</i>; adds a button to the top right to collapse the optional fields of the grid;'+
                  '<br></li><li><b><i>Open-collapsed</i></b>: Display the grid with collapsed optional fields; adds a button to the top right to expand collapsed optional fields.'+
                  '</ul>Optional fields are set via the <i>Extensible fields</i> property as a comma-separated list of names.'
        },
        {name:'recMark',propID:'recMark',type:'checkbox', extraClass: 'col-3', section: 'columns', tooltip:'Current line marker'},
        {name:'hide default titles',propID:'hide_default_titles',type:'checkbox', extraClass: 'col-3', section: 'columns' ,tooltip:'Hide the default grid titles'}
      ],
      css_classes:[
        {name:'grid',propID:'css_class_grid',type:'css_class', section: 'css class', tooltip:'Class css for the grid set in skin editor'},
        {name:'Card container',propID:'css_class_card_container',type:'css_class', section: 'css class', tooltip:'Class css for the grid in card mode set in skin editor'},
        {name:'title',propID:'css_class_title',type:'css_class', section: 'css class', tooltip:'Class css for the title grid'},
        {name:'title hover',propID:'css_class_title_hover',type:'css_class', section: 'css class', tooltip:'Class css for the title hover grid'},
        {name:'row',propID:'css_class_row',type:'css_class', section: 'css class', tooltip:'Class css for the even rows grid'},
        {name:'row odd',propID:'css_class_row_odd',type:'css_class', section: 'css class', tooltip:'Class css for the odd rows grid'},
        {name:'row selected',propID:'css_class_row_selected',type:'css_class', section: 'css class', tooltip:'Class css for the selected row'},
        {name:'row hover',propID:'css_class_row_over',type:'css_class', section: 'css class', tooltip:'Class css for the selected row hover'},
        {name:'nav bar',propID:'css_class_nav_bar',type:'css_class', section: 'css class', tooltip:'Class css for the navigation bar'}
      ],
      editable:[
        {name:'Checkbox',propID:'checkbox',type:'select[false,true,Select All:true-selectAll,Select All of Page:true-selectAllOfPage]' ,tooltip:'Activate the row checkbox'},
        {name:'Pk checkbox/editable fields',propID:'checkbox_fields',type:'datafield', tooltip:'Activate the row checkbox',
          tooltip:'List of fields that identify the rows or that can be edited to be selected using the checkbox.'},
        {name:'Prechecked row field',propID:'preCheckbox_fld',type:'singlefield',
          tooltip:'field of boolean or numeric type (which assumes value 0 to represent \'False\' or value 1 to represent \'True\') present in the query that initializes the checkboxes of the grid'},
        {name:'Disabled row field',propID:'disabled_fld',type:'singlefield',
          tooltip:'field of boolean or numeric type (which assumes value 0 to represent \'False\' or value 1 to represent \'True\') to disable editing or selection of the checkboxes of a row of the Grid'},
        {name:'Checkbox data output',propID:'outDataObj',type:'data',
          tooltip:'Optional, indicates the dataobj to which the rows selected via the checkbox will be passed'} ,
        {name:'Checkbox homogeneity criteria',propID:'homogeneity_fields',type:'str',
          tooltip:'The criteria of homogeneity indicates the rule that unites the lines together.<br>'
          + 'In this area, the list of fields separated by commas that form this principle must be indicated.<br>'
          + 'Once the checkbox of a row has been selected, all the rows that have values ​​equal to the one selected in the homogeneity criteria fields will be editable or selectable, while the others will be deactivated'} ,
        {name:'Homogeneity criteria as filter',propID:'homogeneityAsFilter',type:'checkbox', extraClass: 'col-3',
          tooltip:'Specifies whether the homogeneity criteria should be used as a filter for display data'} ,
        {name:'keepMemCurs',propID:'keepMemCurs',type:'checkbox', extraClass: 'col-3',
          tooltip:'the memorycursor referring to the checkboxes is not reset when the query is redone'} ,
        {name:'Business Object',propID:'business_obj',type:'bofield' ,
          tooltip:'Bo name for the update (using editable fields) and delete operations of the current record'},
        {name:'Show Btn Update',propID:'show_btn_update',type:'checkbox', extraClass: 'col-3',
          tooltip:'Show the button for the update operation'},
        {name:'Show Btn Delete',propID:'show_btn_delete',type:'checkbox', extraClass: 'col-3',
          tooltip:'Show the button for the delete operation'}
      ],
      expression:[
				{name:'hide undercond', propID:'hide_undercond', type:'exp', tooltip:tooltip_hide}
      ]
    },
    events:['onColumnClick','onContextMenu(event)','RowClick(currReIdx)','BeforeRowChange(currdRecIdx,nextRecIdx)','AfterRowChange(currRecIdx,prevRecIdx)','BeforeRowChange_Click(currdRecIdx,nextRecIdx)'
      ,'AfterRowChange_Click(currRecIdx,prevRecIdx)','SelectionChange(state)','DataChange','StartEdit()','Validate(fld)','ValidateRow()','Validate_SetCheckBoxAllOfPage(bChecked)','After_SetCheckBoxAllOfPage(bChecked)'
      ,'Calculate(fld)','RowsChanged(rows)','SelectAllChange','FiltersApplied','UpdatedBO(op,err)','Rendered()','DragCancel()','Drop(val_obj,drop_obj)','DragEnter(objTarget)','DragLeave(objTarget)'],
    functions:['Hide()','Show()','NextPage()','PrevPage()','NextRecord()','PrevRecord()','Refresh(#bKeepCurRow#)','Eop()'
      ,'ColumnTitles(cColumnTitles)','ColumnFields(cColumnFields)','SetColumnLayer(cColumnField, cLayerDescr)','GetColumnLayerFields(cColumnField)'
      ,'GetColumnLayerCaptions(cColumnField)','SetRowLayer(cFieldsList)','GetRowLayerFields()','GetRowLayerCaptions()','SetSPLinkerActions(#cAtions#)'
      ,'SetExtensibleFields(#cExtensionFields#)','ExtendGrid()','ReduceGrid()', 'GetSelectedData()', 'GetSelectedDataAsTrsString(#opt_map#)', 'GetSelectAllAsTrsString()'
      ,'CHGSetParent(father)','EditValue(cFieldName,#xNewValue#)','RowCount()','RowValue(cFieldName,#nRow#)','CurrRow(#nNewRow#)','initMemCurs()','RowChecked(#bNewValue#)'
      ,'OpenRow(#nRow#,#cField#)','SetFocus(#cFld#)','CloseRow()','DisableField(#cField#)','EnableField(#cField#)','AllChecked(#bNewValue#)','SetMemoOptions(#bViewLayer#,#nCharacter#)'
      ,'EmptyHomogeneityFields()','SetHomogeneityFields(#cFieldList#)','UpdateBO()','DeleteBO()','QueryFilter()','ShowTopToolsbar()'
      ,['SetExpanded(#bExpanded#)','SetExpanded(#bExpanded#)','Set how the grid is loaded (extended or reduced)']
      ,['SetMobileFilterCaption(#cCaption#)','SetMobileFilterCaption(#cCaption#)','grid with filter only']
      ,['SetOrderBy(#fld#,#asc|desc#,...)','SetOrderBy(#fld#,#asc|desc#)', 'with no parameters it will blank orderby']
      ,['SetTextEmptyData(#cText#)','SetTextEmptyData(#cText#)','Set a custom text when the data grid is empty']
      ],
    connector:[
      {'type':'iData','propID':'dataobj','versus':'in'}
    ],
    wireframe:function(obj){
      var className='Grid';
      var colP=obj.colProperties;
      var checkbox=obj.checkbox;
      var titles=false;
      var editable=false;
      var columns=[];
      var col_class = [];
      var rows=parseInt(obj.rows);
      var i;
      if(colP){
        if(typeof(colP)=='string') {
          columns=JSON.parse(colP);
        }else {
          columns=colP;
        }
        if (checkbox != 'false') columns.unshift({'isCheckbox':true});
        for(i=0;i<columns.length;i++){
          if(!Empty(columns[i].title))
            titles=true;
          if(columns[i].isEditable=='true')
            editable=true;
          if(columns[i].enable_HTML && (Empty(columns[i].sanitize) || columns[i].sanitize == "none")){
            col_class[i] = "sanitize_none";
          }
        }
        if(titles){
          className='Grid Titles';
        }
      }

      var html='<table class=\''+className+'\'>';
      html+='<tr>';
      //Titoli
      for(i=0;i<columns.length;i++){
        html+='<th></th>';
      }
      html+='</tr>';
      //default all'inizio per non far vedere box vuoto
      if(columns.length==0){
        columns=[1,2,3,4,5]
        col_class = ["", "", "", "", ""];
      }
      //Rows
      for(i=0;i<rows && i<100;i++){
        html+='<tr>';
        for(var ii=0;ii<columns.length;ii++){
          html+=' <td class="'+col_class[ii]+'">'+(ii==0 && columns[ii].isCheckbox ?'<input type="checkbox"/>':'')+((editable && ii==columns.length-1)?'<input class="inputText" type="text"/>':'')+'</td>';
        }
        if(editable && i==4) break;
        html+='</tr>';
      }
      if(!Empty(obj.business_obj)){
          html+='<tr><td colspan="'+columns.length+'">';
          html+='<a class="Bo">&#xe6a8;</a><a class="Bo">&#xe660;</a>'
          html+='</td></tr>';

        }
      html+='</table>';
      return html;
    },
    preSet:[{'preset':true,'name':'Grid title','wire_h':'100px','rows':'10','colProperties':'[{"title":"title1"},{"title":"title2"}]','checkbox':'false','business_obj':''},
            {'preset':true,'name':'Grid title with checkbox','rows':'10'   ,'colProperties':'[{"title":"title1"},{"title":"title2"},{"title":"title3"}]','checkbox':'true','business_obj':''},
            {'preset':true,'name':'Grid title with Business Object','wire_h':'200px','rows':'10' ,'colProperties':'[{"title":"title1"},{"title":"title2"},{"title":"title3"}]','checkbox':'false','business_obj':'?','show_btn_update':'true','show_btn_delete':'true'}
           ],
    notifications:function(obj){
      var colP=obj.colProperties;
      var checkbox=obj.checkbox;
      var editable=false;
      var fieldscheck=false;
      var columns=[];
      var sanitize_none = false;
      if(colP){
        if(typeof(colP)=='string')
          columns=JSON.parse(colP);
        else
          columns=colP;
        for(var i=0;i<columns.length;i++){
          if(columns[i].isEditable==true)
            editable=true;
          if(!Empty(columns[i].field))
            fieldscheck=true;
          if(columns[i].enable_HTML && (columns[i].sanitize == "" || columns[i].sanitize == "none")){
            sanitize_none=true;
          }
        }
      }
      obj.notifications=[];
      if(Empty(obj.dataobj)){
        obj.notifications.push({'message':'Select a dataobj.','tab':'generic','prop':'dataobj'});
      }
      if(!fieldscheck){
        obj.notifications.push({'message':'Select fields in column properties.','tab':'columns','prop':'colProperties'});
      }
      if((checkbox=='true' || editable) && Empty(obj.checkbox_fields)){
        obj.notifications.push({'message':'Set the Pk checkbox/editable fields.','tab':'editable','prop':'checkbox_fields'});
      }
      if(obj.business_obj=='?'){
        obj.notifications.push({'message':'Set the business object.','tab':'editable','prop':'business_obj'});
      }
      if(!Empty(obj.business_obj) && !editable){
        obj.notifications.push({'message':'Set editable fields in column properties.','tab':'columns','prop':'colProperties'});
      }
      if(sanitize_none){
        obj.notifications.push({'message':'Warning: Security Xss vulnerability','tab':'columns','prop':'colProperties'});
      }
    }
  }
  this.extend( this.stdVisibleObjClass , this.GridObjClass );

  this.TabsObjClass={
    newProperties:{
      generic:[
      {name:'Sitepainter style', propID:'sp_tabstrip', type:'checkbox'}],
      style:[
        {name:'Css class', propID:'class_Css', type:'css_class', section: 'css class', tooltip:'Set the Css class'},
        {name:'CSS class selected', propID:'class_Css_selected', type:'str', section: 'deprecated'},
        {name:'font',propID:'font',type:'font-websafe', section: 'deprecated', tooltip:tooltip_font},
        {name:'font color',propID:'font_color',type:'color', section: 'deprecated', tooltip:tooltip_color},
        {name:'font size',propID:'font_size',type:'str', extraClass: 'col-3', section: 'deprecated', tooltip:tooltip_size},
        {name:'font weight',propID:'font_weight',type:'select[,normal,bold]', extraClass: 'col-3', section: 'deprecated', tooltip:tooltip_weight},
        {name:'background color', propID:'bg_color', type:'color', extraClass: 'col-3', section: 'deprecated', tooltip:tooltip_bgcolor},
        {name:'select color', propID:'selected_color', type:'color', extraClass: 'col-3', section: 'deprecated'},
        {name:'vertical', propID:'vertical', type:'checkbox', section: 'deprecated',
          hide_list:{'unchecked':['style.vertical_text'],'checked':[]},
          show_list:{'unchecked':[],'checked':['style.vertical_text']}
        },
        {name:'vertical text', propID:'vertical_text', type:'checkbox', section: 'deprecated'},
        {name:'shrinkable', propID:'shrinkable', type:'checkbox', section:'misc', tooltip:'The height of the Label may become smaller than the one set in the designer'}
      ],
      functional:[
        {name:'select item', propID:'selected_item', type:'str', section:'deprecated'},
        {name:'Cell distribution mode', propID:'cell_distr', type:'select[none,equispaced]', section:'deprecated'},
        {name:'links', propID:'links', type:'str', section:'deprecated'},
        {name:'href', propID:'href', type:'str', section:'deprecated', tooltip:tooltip_href},
        {name:'target', propID:'target', type:'str', section:'deprecated', tooltip:tooltip_target}
      ]
    },
    events:[
            ['Click(name)' , 'Click' , 'When the user click to expand a tab'],
            ['Collapse(name)' , 'Collapse' , 'When a tab is collapsed. Not available when Sitepainter style is false.']
           ],
    functions:[
                ['Select(nTab|tabName)', 'Select(nTab|tabName)', 'Select a tab'],
                ['Exists(tabName)', 'Exists(tabName)', 'Check if tabName exists. Not available when Sitepainter style is false.'],
                ['Clean', 'Clean', 'Set/get servlet action. Empty tab object. Not available when Sitepainter style is false.'],
                ['AddTab(tabName,caption[,element])', 'AddTab(tabName,caption[,element])', 'Add a new tab. Not available when Sitepainter style is false.'],
                ['isEmpty', 'isEmpty', 'Check if there is any tab.'],
               ],
    names:['../portalstudio/images/icon/Tabs.svg','../portalstudio/images/icon/Tabs.svg']
    // wireframe:function(obj){
      // return 'Tabs';
    // }
  }
  this.extend( this.stdVisibleObjClass , this.TabsObjClass );

  this.IframeObjClass={
    newProperties:{
      generic:[
        {
          name:'src',
          propID:'default_portlet',
          type:'str',
          tooltip: 'Iframe src. Set at portlet loaded. Path start from jsp folder'
        }
      ],
      style:[
				 {
          name:'auto resize',
          propID:'auto_resize',
          type:'checkbox',
          extraClass: 'col-2',
          tooltip: 'Iframe resize on load. New size is iframe content size'
        }, {
          name:'border',
          propID:'border',
          type:'checkbox',
          extraClass: 'col-2',
          tooltip: 'Iframe border'
        }
      ]
		},
    events:[
      {
        name:'Loaded',
        tooltip:'Event dispatch when iframe is loaded',
        usage: ``,
        returnValue: '',
				parameters : []
			}, {
        name:'Resized',
        tooltip:'Event dispatch when iframe is resized',
        usage: ``,
        returnValue: '',
				parameters : []
			}
    ],
		functions:[
      {
        name:'Reload',
        tooltip:'Reload iframe',
        usage: ``,
        returnValue: '',
				parameters : [
          {
            name: 'event',
            tooltip: 'standard load event',
            type: 'Object'
          }
        ]
			}, {
        name:'Load',
        tooltip:'Load iframe with this new src',
        usage: ``,
        returnValue: '',
				parameters : [
          {
            name: 'src',
            tooltip: 'Iframe src. Path start from jsp folder',
            type: 'string'
          }
        ]
			}, {
        name:'Resize',
        tooltip:'Reload iframe',
        usage: ``,
        returnValue: '',
				parameters : [
          {
            name: 'width',
            tooltip: 'New iframe width in px',
            type: 'number'
          }, {
            name: 'height',
            tooltip: 'New iframe height in px',
            type: 'number'
          }
        ]
			}
    ]
	}
  this.extend( this.stdVisibleObjClass , this.IframeObjClass );

  this.SPLinkerObjClass={
		newProperties:{
      generic:[],
			style:[
				{name:'popup', propID:'popup' , type:'checkbox', extraClass: 'col-3',
          hide_list:{'unchecked':['this.style_popup_style','this.style_popup_height','this.style_popup_width','this.style_popup_scroll'],'checked':[]},
          show_list:{'checked':['this.style_popup_style','this.style_popup_height','this.style_popup_width','this.style_popup_scroll'],'unchecked':[]},
          tooltip:'Set the opening mode of the servlet: <br><ul><li><i>TRUE</i>: the servlet is loaded in a popup, whose size is specified in \'Popup height\' and \'Popup width\'. </li><li><i>FALSE</i>: The servlet is opened in the portlet</li></ul>'
        },
				{name:'popup style', propID:'popup_style', type:'select[by skin,layer,layer-child,popup]', extraClass: 'col-3', tooltip:'By skin: is set in the skin editor between popup and layer.<br>' +
          'Layer: open a modal layer like a sibiling of the caller page.<br>' +
          'Layer-child: open a modal layer like a child of the caller page (Broadcast events inside are discendants of the events of the caller).'
          },
				{name:'popup height', propID:'popup_height', type:'str', extraClass: 'col-2', tooltip:'Height in pixels of the popup'},
				{name:'popup width', propID:'popup_width', type:'str', extraClass: 'col-2', tooltip:'Width in pixels of the popup'},
				{name:'maximized', propID:'popup_maximized', type:'select[by skin,true,false]', extraClass: 'col-2', tooltip:'The layer will be maximized open.'},

        {name:'popup scroll',  propID:'popup_scroll', type:'checkbox', extraClass: 'col-3', tooltip:'If checked, the popup will load with a scrollbar'},
				{name:'refresh', propID:'refresh', type:'checkbox', extraClass: 'col-3', tooltip:'If checked, the portlet will be reloaded when the servlet closes'}
			],
			functional:[
				{name:'type', propID:'entity_type' , type:'select[,master,detail,master/detail,dialog,routine,page,report,SmartReport:smartreport]',
          hide_list:{'report': ['functional.m_cAction','functional.servlet', 'functional.allowedentities']},
					show_list:{',master,detail,master/detail,dialog,routine,page': ['functional.m_cAction','functional.servlet']},
          tooltip:'Type of servlet to use'
        },
				{name:'Action', propID:'m_cAction',
          type:'select[,new,write,writeload,query,start,delete,deleterow,edit,editload,view,function,function autoexec,function server autoexec,async routine,autozoom,zoom,routine caller]',
          tooltip:'Action to apply to the servlet'
        },
        {name:'entity', propID:'servlet', type:'bofield' ,
          setOnBlurFunc:function(){setPropertyValue(false,'functional','allowedentities',getPropertyValue(false,'functional','servlet'));},
          tooltip:'Name of the servlet to use'
        },
        {name:'allowed entities', propID:'allowedentities',type:'str', list:"true",
        tooltip: "Lists of allowed entities for this splinker separated by commas or how they should start with using \"*\" (Es: myEntity*).<br>if empty all entities are allowed (bad security)."},
        {name:'parameters', propID:'parms', type:'parameters', tooltip:tooltip_params	},
        {name:'Encrypted params', propID:'decrypted_parms' , type:'str', tooltip:'List of encrypted parameters separated by commas.', extraClass: 'col-3'},
        {name:'Encrypt seed', propID:'decrypted_parms_pwd', type:'str',tooltip:'Optional seed for this decryption.<br>If empty it is random generated and only variables of this portlet can be decrypted.', extraClass: 'col-3',validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;}}},
				{name:'target', propID:'target', type:'str', tooltip:tooltip_target	},
        {name:'async', propID:'async', type:'checkbox', extraClass: 'col-3', tooltip:'If checked, make calls to the server asynchronously'},
        {name:'offline',    propID:'offline',   type:'checkbox', extraClass: 'col-3',
          hide_list:{'checked':['this.style_popup_scroll']},
          show_list:{'unchecked':['this.style_popup_scroll']},
          tooltip:'If selected, SPiLnkler makes the entity available even in the absence of a network connection.'
        },
        {name:'ProgressBar', propID:'progressbar', type:'checkbox', extraClass: 'col-3',
          validFunc:function(value,prop,input,index){
            if(value && itemsHTML[index]['async']!='true'){
              PSAlert.alert("The properties 'Async' must be true.");
              return false;
            }else{
              return true;
            }
          },
          tooltip:'If checked, insert the progress bar into the window'
        }
        //{name:'set id to retrieve progress messages', propID:'force_msg_id', type:'checkbox', tooltip:'Gives an id to the routine to check the status using the SPAsyncServlet servlet ', extraClass: 'col-3' }
      ],
      expression:[
        {name:'check Expression', propID:'check_exp', type:'str',tooltip:tooltip_check}
      ]
    },
    notifications:function(obj){
      obj.notifications=[];
      if(obj.async!='true' && obj.progressbar=='true'){
        obj.notifications.push({'message':'If progressbar is enabled the async properties must be true.','tab':'functional','prop':'async'});
      }
      if(obj.entity_type && obj.entity_type.test(/master|detail|master\/detail/)){
        obj.notifications.push({'message':'With BO is possible to add receiver with "<entity_name>_savedEntity'});
      }
    },
    events: [
	 ['Deleted(bResult)' , 'Deleted' , 'Deleted a record when viewing it']
    , ['Error(cCause)' , 'Error' , 'It is notified when an error occurs in the servelet , so when one of the action Write WriteLoad or Deleted connected to the servlet does not came to a successful conclusion']
    , ['FailedAccess(cMsg)' , 'FailedAccess' , 'The event is notified when missing the priviligies to do a modification or deletion operations on the object piloted by splinker']
    , ['FailedLogin(cMsg)' , 'FailedLogin(cMsg)' , 'The event is notified when the login operation is required before a modification or deletion operations on the object piloted by splinker']
    , ['Response(cMsg)' , 'Response(cMsg)' , 'The event is notified when a routine completes the esecution']
    , ['Result(result)' , 'Result(result)' , 'The event is notified when a function returns value']
    , ['Executed(result,cError)' , 'Executed(result,cError)' , 'Function performed upon completation of Splinker']
    , ['Updated' , 'Updated' , 'The event is notified when an editing operation is successfull']
    , ['ServerDown()' , 'ServerDown','Only for online splinker into offline context']
    , 'ProgressBarFinished'
    , ['LayerClosed()', 'LayerClosed', 'Only popup splinker in layer mode']
    , ['FailedCheck()', 'FailedCheck', 'The event is notified when the check fails.']
    ],
    functions: [
      ['Action(#cAction#)', 'Action(#cAction#)','Set/get servlet action']
     ,  ['DeleteMessage(#opt_cMessage#)' , 'DeleteMessage(#opt_cMessage#)' , 'Set/get query message on delete action']
     ,  ['Link()', 'Link()','Execute link and return the response from a function']
     ,  ['Parameters(#cParms#)', 'Parameters(#cParms#)' , 'Set/get parms value']
     ,  ['Servlet(#cServlet#)', 'Servlet(#cServlet#)' , 'Set/get servlet value']
     ,  ['SkipDeleteMessage(#opt_bSkip#)', 'SkipDeleteMessage(#opt_bSkip#)' , 'Set/get skip status. Empty parameter get status without setting']
     ,  ['CloseAtEnd(#lClose)','CloseAtEnd(#lClose)', 'Set m_cAtExit, default close']
     ,  ['setProgressBarPortlet(#portlet)','setProgressBarPortlet(#portlet)', 'Set a custom progressbar portlet']
     ,  ['setCustomClass(#class)','setCustomClass(#class)', 'Set a custom class for the layer']
    ],
    names:['../portalstudio/images/component/desk_splink.png','../portalstudio/images/component/desk_splink.png'],
    connector:[{'type':'iParameter','propID':'parms','versus':'in'}]
  };
  this.extend( this.stdHiddenObjClass , this.SPLinkerObjClass );

  this.PortletObjClass={
    newProperties:{
      generic:[],
      functional:[
				{
          name: 'themed',
          propID: 'themed',
          type: 'checkbox',
          tooltip: 'Portlet is search in skin folder before jsp folder. If portlet is not in skin it will be taken fron jsp folder'
        },
        {
          name:'is optional',
          propID:'isoptional',
          type:'checkbox',
          tooltip:'If checked will be ignored when portlet has errors or doesn\'t exist.'
        },
				{
          name:'src',
          propID:'src',
          type:'str',
          tooltip: 'Portlet src.(start from jsp folder)'
        }
      ]
    },
    wireframe: function(/*obj,isVisualMode*/){
      return "<div class='Portlet'></div>";
    }
  }
  this.extend( this.stdVisibleObjClass , this.PortletObjClass );

  this.CheckboxObjClass={
    newProperties:{
			generic:[
				{name:'help tips', propID:'help_tips',type:'str', tooltip:tooltip_helptips},
				{name:'tab index', propID:'tabindex', type:'int', extraClass: 'col-3', tooltip:tooltip_tabindex}
			],
      checkbox_values:[
        {name:'label text', propID:'label_text', type:'str', tooltip:'Content of the label next to the checkbox'},
        {name:'checked value', propID:'checked_value', type:'str', validFunc:'IsValidValue', extraClass: "col-3", tooltip:'Value assumed by the checkbox if it is selected. The default is true.'},
        {name:'unchecked value', propID:'unchecked_value', type:'str', validFunc:'IsValidValue', extraClass: "col-3", tooltip:'Value assumed by the checkbox if it is not selected. The default is false.'}
      ],
      functional:[
        {name:'var type', propID:'typevar', type:'select[character,numeric,logic]', validFunc:'IsValidCheckboxValues', tooltip:'Data type of the item'},
        {name:'data source', propID:'dataobj', type:'data', tooltip:'Data Object from which to start for the extraction of the current value. This Data Object must return only one record'},
				{name:'field', propID:'field', type:'singlefield', tooltip:'Field assigned to the item'},
        {name:'init par', propID:'init_par', type:'str' , tooltip:'Initializing the element (server-side) with global variables or as a parameter received at the call of the portlet that contains it. The following values are possible:<br><ul><li>attribute</li><li>request</li><li>global &lt;type&gt;</li><li>\'&lt;ConstString&gt;\'</li></ul>' , extraClass: "col-3"},
        {name:'disabled', propID:'disabled', type:'checkbox', extraClass: "col-3", tooltip:'If checked, the ComboBox is disabled'}
			],
      style:[
        {name:'label class', propID:'css_class', type:'css_class', tooltip:'Set the Css class'},
        {name:'input class', propID:'css_class_input', type:'css_class', tooltip:'CSS class to use for the input associated with the checkbox'},
        {name:'style type', propID:'style_type', type:'select[standard,slider]', tooltip:'Type of checkbox to use'}
      ],
			expression:[
        {name:'init', propID:'init', type:'checkbox' ,tooltip:tooltip_init},
				{name:'calculate', propID:'calculate', type:'exp',tooltip:tooltip_calc},
				{name:'hide undercond', propID:'hide_undercond', type:'exp',tooltip:tooltip_hide},
				{name:'edit undercond', propID:'edit_undercond', type:'exp',tooltip:tooltip_edit},
        {name:'create undercond', propID:'create_undercond', type:'exp',tooltip:tooltip_create}
			]
    },
    //propertiesNames:['name','x'  ,'y'  ,'height','width','sequence','init par' ,'anchor'     ,'help tips','tabindex'],  //propriet� da far vedere nella properties bar
    //properties:     ['name','x'  ,'y'  ,'h'     ,'w'    ,'sequence','init_par' ,'anchor'     ,'help_tips','tabindex'],  //propriet� da far vedere nella properties bar
    //propertyTypes:  ['str' ,'int','int','int'   ,'int'  ,'str'     ,'str'      ,anchor_select,'str'      ,'str'],
    events:['onChange'],
    functions:stdMethods.concat(['Value(#bNewValue#)','Init(#bNewValue#)']),
    wireframe:function(obj){
      //return "<input type='checkbox' class='Checkbox' onclick='return false'/>"+(!Empty(obj.label_text)?'<label class="label">'+obj.label_text+'</label>':'');
      //return "<input type='checkbox' class='Checkbox' style='height:"+(obj.h-2)+"px;width:"+(obj.w-2)+"px;box-sizing:border-box;'  onclick='return false'/>"+(!Empty(obj.label_text)?'<label class="label">'+obj.label_text+'</label>':'');
      return "<input  type='checkbox' class='Checkbox"+((!Empty(obj.label_text) || obj.preset)?' CheckboxLabel':'')+"'"+((!Empty(obj.label_text) || obj.preset)?"":" style='height:100%;width:100%'")+" onclick='return false'/>"+(!Empty(obj.label_text)?'<label class="Label" style="margin-left:4px;vertical-align:middle;">'+obj.label_text+'</label>':'');
    },
    preSet:[{'name':'Simple Checkbox with label','preset':true,'label_text':'','h':13,'w':13},
           {'name':'Checkbox with label','preset':true,'label_text':'Label text','h':20,'w':90}]
  }
  this.extend( this.stdVisibleObjClass , this.CheckboxObjClass );

  this.ComboboxObjClass = {
		newProperties:{
			generic:[
				{name:'help tips', propID:'help_tips',type:'str', tooltip:tooltip_helptips},
				{name:'tab index', propID:'tabindex', type:'int', extraClass: 'col-3', tooltip:tooltip_tabindex}
			],
			style:[
				{name:'font', propID:'font', type:'font-websafe', tooltip:tooltip_font},
				{name:'font size', propID:'font_size', type:'str', tooltip:tooltip_size},
				{name:'Css class', propID:'class_Css', type:'css_class', section: 'css class', extraClass: 'hide-title'}
			],
      elements_list:[
				//{name:'var type', propID:'typevar', type:types_select},
				{name:'data source', propID:'dataobj', type:'data', tooltip:'Data Object from which to extract the field that will set the \'Value\' and / or \'Text\' property of the element'},
				{name:'text', propID:'textlist', type:'datafield', tooltip:'You can set a field or static elements separated by \',\'.'},
				{name:'value', propID:'valuelist', type:'datafield', tooltip:'You can set a field or static elements separated by \',\'.'}
			],
			functional:[
				{name:'var type', propID:'typevar', type:types_select, tooltip:'Data type of the TextBox'},
				{name:'data source', propID:'dataobj_value', type:'data', tooltip:'Data Object from which to start for the extraction of the current value. This Data Object must return only one record'},
				{name:'field', propID:'field', type:'singlefield', dataobjref:'dataobj', tooltip:'Key field assigned to the item'},
				{name:'visible', propID:'visible', type:'checkbox', tooltip:'If checked, the field is displayed'},
				{name:'disabled', propID:'disabled',type:'checkbox', tooltip:'If checked, the ComboBox is disabled'},
				{name:'picture', propID:'picture', type:'str', tooltip:tooltip_image},
				{name:'initial par', propID:'init_par', type:'str' , tooltip:'Initializing the element (server-side) with global variables or as a parameter received at the call of the portlet that contains it. The following values are possible:<br><ul><li>attribute</li><li>request</li><li>global &lt;type&gt;</li><li>\'&lt;ConstString&gt;\'</li></ul><br>Date must be YYYY-MM-DD'},
        {name:'empty value',  propID:'empty_value', type:'checkbox', tooltip:'Allows you to enable/disable an empty value as the first element of the list in the combobox'}
			],
			expression:[
        {name:'init', propID:'init', type:'checkbox' ,tooltip:tooltip_init},
				{name:'calculate', propID:'calculate', type:'exp',tooltip:tooltip_calc},
				{name:'hide undercond', propID:'hide_undercond', type:'exp',tooltip:tooltip_hide},
				{name:'edit undercond', propID:'edit_undercond', type:'exp',tooltip:tooltip_edit},
        {name:'create undercond', propID:'create_undercond', type:'exp',tooltip:tooltip_create}
			]
    },
    //propertiesNames: ['name','x' ,'y'  ,'height','width','sequence','font'      ,'font size','css class','text'    ,'value'    ,'dataobj','init par','anchor'     ,'var type'  ,'picture','tabindex','visible' ,'disabled'],  //propriet� da far vedere nella properties bar
    //properties:      ['name','x' ,'y'  ,'h'     ,'w'    ,'sequence','font'      ,'font_size','class_Css','textlist','valuelist','dataobj','init_par','anchor'     ,'typevar'   ,'picture','tabindex','visible' ,'disabled'],  //propriet� da far vedere nella properties bar
    //propertyTypes:   ['str','int','int','int'   ,'int'  ,'str'     ,fonts_select,'str'      ,'str'      ,'str'     ,'str'      ,'data'   ,'str'     ,anchor_select,types_select,'str'    ,'str'     ,'checkbox','checkbox'],
    events:['onChange','Rendered'],
    functions:stdMethods.concat(['Text()','Value(#xNewValue#)','Init(#xNewValue#)','SetCurRec(#index#)','Refresh(#bKeepValue#)','FillDataStatic(#values#,#labels#)','SetEmptyLabel(#xNewValue#,#bRefresh#)']),
    connector:[
      {'type':'iData','propID':'dataobj','versus':'in'}
    ],
    wireframe:function(/*obj*/){
      return "<select class='Combobox'></select>";
    }
  }
  this.extend( this.stdVisibleObjClass , this.ComboboxObjClass );

  this.RadioObjClass = {
		newProperties:{
			generic:[
				{name:'tab index', propID:'tabindex', type:'int', extraClass: 'col-3', tooltip:tooltip_tabindex}
			],
			style:[
				{name:'font',     propID:'font', type:'font-websafe', tooltip:tooltip_font},
				{name:'font size', propID:'font_size', type:'str', tooltip:tooltip_size},
				{name:'Css class',  propID:'class_Css', type:'css_class', tooltip:'Set the Css class'},
        {name:'Orientation',propID:'orientation', type:'select[vertical,horizontal]', tooltip:'Indicates the orientation in which elements will be drawn' }
			],
      radio_values:[
        {name:'text',     propID:'textlist', type:'str', tooltip:'Text label of radio elemtents separetad by comma.'},
        {name:'value',   propID:'valuelist', type:'str', tooltip:'Value of radio elemtents separetad by comma.'},
        {name:'help tips',  propID:'helptipslist',type:'str', tooltip:'Help tips of radio elemtents separetad by comma. If set only one help tip, every radio elements will have the same tip.'}
      ],
			functional:[
				{name:'var type', propID:'typevar',   type:types_select, tooltip:'Data type of the item'},
				{name:'data source', propID:'dataobj',   type:'data', tooltip:'Data Object from which to start for the extraction of the current value. This Data Object must return only one record'},
        {name:'field', propID:'field', type:'singlefield', dataobjref:'dataobj', tooltip:'Field used to select the current value. This must be equal to one of the values ​​indicated in the \'Value\' property'},
				{name:'visible', propID:'visible',   type:'checkbox', tooltip:'If checked, the field is displayed'},
				{name:'disabled', propID:'disabled',  type:'checkbox', tooltip:'If checked, item is disabled'},
				{name:'picture', propID:'picture', type:'str', tooltip:tooltip_image},
				{name:'initial par', propID:'init_par', type:'str' , tooltip:'Initializing the element (server-side) with global variables or as a parameter received at the call of the portlet that contains it. The following values are possible:<br><ul><li>attribute</li><li>request</li><li>global &lt;type&gt;</li><li>\'&lt;ConstString&gt;\'</li></ul><br>Date must be YYYY-MM-DD'}
			],
			expression:[
        {name:'init', propID:'init', type:'checkbox' ,tooltip:tooltip_init},
				{name:'calculate', propID:'calculate', type:'exp',tooltip:tooltip_calc},
				{name:'hide undercond', propID:'hide_undercond', type:'exp',tooltip:tooltip_hide},
				{name:'edit undercond', propID:'edit_undercond', type:'exp',tooltip:tooltip_edit},
        {name:'create undercond', propID:'create_undercond', type:'exp',tooltip:tooltip_create}
			]
    },
    events:['onChange','Rendered'],
    functions:['Text()','Value(#xNewValue#)','Init(#xNewValue#)','FillDataStatic(#labels#,#values#)',['Flush()','Flush()','Flush the selected items']], //'SetCurRec(#nNewValue#)'
    wireframe:function(obj){
        var html = "",
          list = Trim(obj.textlist).split(",");
        if( Empty(obj.textlist) ){
          list = ['example_radio_1','example_radio_2','example_radio_3']
        }
        for(var ii=0; ii<list.length; ii++){
          html += "<div style='"+(obj.orientation=='horizontal'?'display:inline-block;':'')+"'>"
          + "<label>"
          + "<input type='radio' name='"+obj.name+"'>"
          + list[ii]
          + "</label>"
          + "</div>";
        }
      return html;
    }
  }
  this.extend( this.stdVisibleObjClass , this.RadioObjClass );

  this.DataMasherObjClass = {
    newProperties:{
      generic:[],
      style:[
          {name:'Vertical scroll bar',     propID:'vertical_scroll',    type:'checkbox', tooltip:'If checked, draw the vertical scroll bar when needed'},
          {name:'Horizontal scroll bar',   propID:'horizontal_scroll',  type:'checkbox', tooltip:'If checked, draw the horizontal scroll bar when needed'}
        ],
      css:[
          {name:'Css class datamasher',             propID:'css_class_datamasher',       type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the DataMasher properties'},
          {name:'Css class table',                  propID:'css_classContainerTable',    type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the DataMasher table properties.'},
          {name:'Css class column titles',          propID:'css_classColTit',            type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the column title properties'},
          {name:'Css class row titles',             propID:'css_classRowTit',            type:'css_class',    tooltip:'Name of the class in the style sheet to be applied to the row title properties'},
          {name:'Css class titles (empty cross)',   propID:'css_classTitlesEmptyCross',  type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the properties of the cell at the top left of the table, i.e. the cell used to contain Cols legend and Rows legend when present'},
          {name:'Css class cell (all)',             propID:'css_classCellAll',           type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the properties of all cells'},
          {name:'Css class cell (not empty)',       propID:'css_classCellNotEmpty',      type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the properties of the non-empty cells'},
          {name:'Css class cell (selected)',        propID:'css_classCellSelected',      type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the properties of the selected cells'},
          {name:'Css class marginal titles',        propID:'css_classMarginalTit',       type:'css_class',    tooltip:'Name of the class in the style sheet to apply to the row and column margin header cell properties'},
          {name:'Css class marginal cell',          propID:'css_classMarginalCell',      type:'css_class',    tooltip:'Name of the class in the style sheet to be applied to the row and column marginal data cell properties'},
          {name:'Css class layer',                  propID:'css_classLayer',             type:'css_class',    tooltip:'Name of the class present in the style sheet to be applied to the properties of the external layer displayed when the mouse passes over the cells'}
        ],
      functional:[
          {name:'data source',    propID:'dataobj',  type:'data',   tooltip:'Name of the Data Object from which to start for data extraction'}
        ],
      cell:[
          {name:'Data field',             propID:'data_fld',         type:'str',                                tooltip:'Name of the Dataobj field that will be displayed inside the DataMasher cells'},
          {name:'Cell align',             propID:'cell_align',       type:'select[None,left,center,right]',     tooltip:'Specifies the horizontal alignment of the item within the cell'},
          {name:'Filling function',       propID:'filling_fnc',      type:'select[Count,Totalize,Average,Maxvalue,Minvalue,Lastfound]', tooltip:'SQL aggregate function to be applied on the data present in the cells (default: Count)',
          hide_list:{'Count':['this.cell_cell_picture'],'Totalize,Average,Maxvalue,Minvalue,Lastfound':[]},
          show_list:{'Totalize,Average,Maxvalue,Minvalue,Lastfound':['this.cell_cell_picture'],'Count':[]}
          },
          {name:'Picture',             propID:'cell_picture',        type:'str'},
          {name:'Fixed cell size',        propID:'fixed_cell_size',  type:'checkbox',   tooltip:'If checked, enable a fixed cell size'},
          {name:'Layered',                propID:'layered',          type:'checkbox',   tooltip:'If checked, it enables the display of a Layer underlying the DataMasher table, to display the detailed content of the cells upon hovering with the mouse pointer',
          hide_list:{'unchecked':['this.cell_delay_show','this.cell_delay_hide'],'checked':[]},
          show_list:{'checked':['this.cell_delay_show','this.cell_delay_hide'],'unchecked':[]}
          },
          {name:'Layer delay show (ms)',  propID:'delay_show',       type:'int'},
          {name:'Layer delay hide (ms)',  propID:'delay_hide',       type:'int'}
        ],
      column:[
          {name:'Cols field',         propID:'cols_fld',          type:'str', tooltip:'Field associated with columns. Multiple fields can be entered in the same column by separating them with commas.'},
          {name:'Hidden cols field',      propID:'cols_fld_hide',     type:'str', tooltip:'Made invisible fields associated with the column'},
          {name:'Cols subfield',      propID:'subcols_fld',       type:'str', tooltip:'Field displayed as a sub-column for each column in the Database'},
          {name:'Hidden cols subfield',   propID:'subcols_fld_hide',  type:'str', tooltip:'Fields made invisible associated with the sub-column'},
          {name:'Cols content',           propID:'cols_split',        type:'select[12Hours-Months,24Hours,7Days,31Days,List from 1 to,List,Field]', tooltip:'Column content type',
          hide_list:{'12Hours-Months,24Hours,7Days,31Days,Field':['this.column_cols_list_value'],'List from 1 to,List':[]},
          show_list:{'List from 1 to,List':['this.column_cols_list_value'],'12Hours-Months,24Hours,7Days,31Days,Field':[]}},
          {name:'Cols list values',       propID:'cols_list_value',   type:'str', tooltip:'List, separated by commas, of the values ​​assumed by the list that will enhance the columns'},
          {name:'Cols legend',        propID:'cols_legend',       type:'str', tooltip:'Legend for columns, will be displayed in the top left cell'},
          {name:'Cols orderby',       propID:'cols_orderby',      type:'checkbox', tooltip:"if selected, enables column sorting. The matching criterion will be specified by the value of the 'Cols compare fnc' property"},
          {name:'Cols align',         propID:'cols_align',        type:'select[None,left,center,right]', tooltip:'Specifies the horizontal alignment of the item within the column'},
          {name:'Cols compare fnc',   propID:'cols_compare_fnc',  type:'str', tooltip:'Allows you to specify a javascript function to use to determine the ordering of columns'},
          {name:'Cols Marginal',      propID:'col_marginal',      type:'select[None,Totalize,Average,Maxvalue,Minvalue,Count]', tooltip:'It allows to visualize a marginal column whose cells are valued through a SQL aggregation function',
          hide_list:{'None,Count':['this.column_cols_picture'],'Totalize,Average,Maxvalue,Minvalue':[]},
          show_list:{'Totalize,Average,Maxvalue,Minvalue':['this.column_cols_picture'],'None,Count':[]}
          },
          {name:'Marginal Picture',   propID:'cols_picture',      type:'str', tooltip:'Contains the formatting of the data in the marginal column'}
        ],
      row:[
          {name:'Rows field',         propID:'rows_fld',          type:'str', tooltip:'Field associated with rows. Multiple fields can be entered in the same column by separating them with commas.'},
          {name:'Hidden rows field',  propID:'rows_fld_hide',     type:'str', tooltip:'Made invisible fields associated with the row'},
          {name:'Rows content',       propID:'rows_split',        type:'select[12HoursMonths,24Hours,7Days,31Days,List from 1 to,List,Field]', tooltip:'Field displayed as a sub-row for each row in the Database', hide_list:{'12Hours-Months,24Hours,7Days,31Days,Field':['this.row_rows_list_value'],'List from 1 to,List':[]},
          show_list:{'List from 1 to,List':['this.row_rows_list_value'],'12Hours-Months,24Hours,7Days,31Days':[]}},
          {name:'Rows list values',   propID:'rows_list_value',   type:'str', tooltip:'List, separated by commas, of the values ​​assumed by the list that will enhance the rows'},
          {name:'Rows legend',        propID:'rows_legend',       type:'str', tooltip:'Legend for rows, will be displayed in the top left cell'},
          {name:'Rows orderby',       propID:'rows_orderby',      type:'checkbox', tooltip:"if selected, enables row sorting. The matching criterion will be specified by the value of the 'Rows compare fnc' property"},
          {name:'Rows align',         propID:'rows_align',        type:'select[None,left,center,right]', tooltip:'Specifies the horizontal alignment of the item within the row'},
          {name:'Rows compare fnc',   propID:'rows_compare_fnc',  type:'str', tooltip:'Allows you to specify a javascript function to use to determine the ordering of rows'},
          {name:'Rows Marginal',      propID:'row_marginal',      type:'select[None,Totalize,Average,Maxvalue,Minvalue,Count]', tooltip:'It allows to visualize a marginal row whose cells are valued through a SQL aggregation function',
          hide_list:{'None,Count':['this.row_rows_picture'],'Totalize,Average,Maxvalue,Minvalue':[]},
          show_list:{'Totalize,Average,Maxvalue,Minvalue':['this.row_rows_picture'],'None,Count':[]}
          },
          {name:'Marginal Picture',   propID:'rows_picture',      type:'str', tooltip:'Contains the formatting of the data in the marginal row'}
        ]
    },
    names:['../portalstudio/images/component/DataMasher.svg','../portalstudio/images/component/DataMasher.svg'],

    functions:['GetColsValueList()',
             'GetRowsValueList()',
             'GetSubColsValueList()',
             'GetColTitleValue(#colTitleValue#)',
             'GetRowTitleValue(#rowTitleValue#)',
             'GetCellRowTitleValue(#htmlCell#)',
             'GetCellRowFieldTitleValue(#nameField#,#htmlCell#)',
             'GetCellRowTitleHideValue(#htmlCell#)',
             'GetCellRowFieldTitleHideValue(#nameField#,#htmlCell#)',
             'GetCellColTitleValue(#htmlCell#)',
             'GetCellColFieldTitleValue(#nameField#,#htmlCell#)',
             'GetCellColTitleHideValue(#htmlCell#)',
             'GetCellColFieldTitleHideValue(#nameField#,#htmlCell#)',
             'GetCellSubColTitleValue(#htmlCell#)',
             'GetCellSubColFieldTitleValue(#nameField#,#htmlCell#)',
             'GetCellSubColTitleHideValue(#htmlCell#)',
             'GetCellSubColFieldTitleHideValue(#nameField#,#htmlCell#)',
             'SelectCell(#htmlCell#)',
             'GetCellValue(#htmlCell#)',
             'GetSelectedHtmlCell()',
             'GetSelectedDataCell()',
             'GetHoveringHtmlCell()',
             'GetHoveringDataCell()',
             'GetHtmlLayer()',
             'SetBackgroundColorCell((htmlCell,cColor)',
             'SetTextColorCell(htmlCell,cColor)',
             'Populate(#arrayData#,#arrayFields#,#arrayTypes#)',
             'PopulateFromFunction(#fillingFunction#,#arrayFields#,#arrayTypes#)',
             'NotEmpty(#htmlCell#)'
           ],

    events:[
          'CellClick',
          'CellMouseOver',
          'Rendered',
          'SetRowsValueList()',
          'SetColsValueList()',
          'SetSubColsValueList()',
          'SetColTitleText(columnValue)',
          'SetSubColTitleText(columnValue)',
          'SetColMarginalTitleText(rowMargValue)',
          'SetRowTitleText(rowValue)',
          'SetRowMarginalTitleText(rowMargValue)',
          'SetCellText(rsArray)',
          'SetColTitleDecoration(htmlCell,cellValue)',
          'SetRowTitleDecoration(htmlCell,cellValue)',
          'SetCellDecoration(htmlCell,cellValue,rsArray)',
          'SetCellDecorationDefault(htmlCell,row,col)',
          'SetLayerHtml(htmlCell,rsArray)'
          ],
    connector:[
      {'type':'iData','propID':'dataobj','versus':'in'}
    ]
  }
  this.extend( this.stdVisibleObjClass , this.DataMasherObjClass );

  this.StdTreeViewObjClass={
    newProperties:{
      generic:[],
			style:[
				{name:'font', propID:'font', type:'font-websafe', tooltip:tooltip_font},
				{name:'font size', propID:'font_size', type:'int', tooltip:tooltip_size},
				{name:'font color', propID:'font_color', type:'str', tooltip:tooltip_color},
				{name:'Css', propID:'css', type:'str'},
				{name:'Css class', propID:'css_class', type:'css_class'},
				{name:'scroll bars', propID:'scroll_bars', type:'select[true,false]'},
				{name:'icons', propID:'set_icons', type:'str'}
			],
			functional:[
				{name:'Enable HTML', propID:'enable_html', 		type:'select[true,false]'},
				{name:'data source', propID:'dataobj', type:'data'},
				{name:'root label', propID:'root_label', type:'str'},
				{name:'root link', propID:'root_link', type:'str'},
				{name:'root value', propID:'root_node_value', type:'str'},
				{name:'field NodeID', propID:'field_NodeID', type:'str'},
				{name:'field Descr', propID:'field_NodeDescr', type:'str'},
				{name:'field picture', propID:'field_picture', type:'str'},
				{name:'hidden fields', propID:'hidden_fields', type:'str'},
				{name:'field ChildCount', propID:'field_ChildCount', type:'str'},
				{name:'node link', propID:'node_link', type:'str'},
				{name:'link target', propID:'frame', 	type:'str'},
        {name:'droppable', propID:'droppable', type:'checkbox', section:'drag and drop', extraClass: 'col-3'},
        {name:'droppable name', propID:'droppable_name', type:'str', section:'drag and drop', extraClass: 'col-3'}
			]
    },
    functions: ['AddDataSource(#dataobj#,#isTree#,#icons#)','getNodeByID(#id#,...)','expandNode(#id#,...)','collapseNode(#id#,...)','refreshNode(#id#,...)','getCurrentNode()','rs.#field#','openNodes(#IdNodes#)','getPath()'],
    events:  ['Click','rightClick','Drop(val_obj,drop_obj)','DragEnter(objTarget)','DragLeave(objTarget)'],
    names:['../portalstudio/images/component/TreeView.png','../portalstudio/images/component/TreeView.png'],
    connector:[
      {'type':'iData','propID':'dataobj','versus':'in'}
    ]
  }
  this.extend( this.stdVisibleObjClass , this.StdTreeViewObjClass );

  this.NoteObjClass={
    newProperties:{
        generic:[
          {name:'value', propID:'value',   type:'description', tooltip:'Value displayed in the note'},
        ],
        style:[
          {name:'font color',       propID:'font_color', type:'color', tooltip:tooltip_color},
          {name:'background color', propID:'bg_color',   type:'color', tooltip:tooltip_bgcolor}
        ]
    },
    functions: [],
    events:  [],
    connector:[],
    wireframe:function(obj){
      return '<textarea readonly=\'true\' style=\'width:100%;height:100%;box-sizing:border-box;margin:0;border:1px solid #E08018;font-family:monospace;background-color:'+obj.bg_color+';color:'+obj.font_color+';padding:2px;overflow:hidden;z-index:1;\'>'+obj.value+'</textarea>';
    }
  }
  this.extend( this.stdVisibleObjClass , this.NoteObjClass );

  this.SPToolbarObjClass={
    newProperties:{
      generic:[
        {
          name: 'icon Width',
          propID: 'iconWidth',
          type: 'int',
          tooltip: 'Width (in pixel) of the button icon'
        },
        {
          name:'max toolbar item',
          propID:'maxToolbarItem',
          type:'int',
          tooltip: 'Max number of visible button. The other buttons will be append to the menu'
        },
        {
          name:'toolbar align',
          propID:'toolbarAlign',
          type:'select[right,left]',
          tooltip: 'Starting point of the buttons'
        }
      ],
      style:[
        {
          name:'Toolbar background color',
          propID:'bg_color',
          type:'color',
          tooltip: 'Set the background color of the toolbar'        },
        {
          name:'Menu background color',
          propID:'menu_bg_color',
          type:'color',
          tooltip: 'Set the background color of the menu'
        },
        {
          name:'Css class',
          propID:'css_class',
          type:'css_class',
          tooltip: 'Set the CSS class'
        },
        {
          name:'Footer Action Button',
          propID:'FAB',
          type:'checkbox',
          tooltip: 'If true, the buttons will be added to a menu located at the bottom right of the page'
        }
      ]
    },
    functions: [
      {
        name:'Append({\n   id:#id#,\n   title:#title#,\n   tooltip:#tooltip#,'+
        '\n   image:{fontFamily:#font#, value:#char#, size:#size#,color:#color#},\n   action:#action#\n},#index#)',
        tooltip: 'Append the item/s to the toolbar, if there is space, or to the menu',
        returnValue: 'The function return true if the item has been added. The button may not be added when an element with the same id already exists',
        parameters: [
          {
            name: 'item',
            tooltip: 'Json Object or an array of objects with these properties: \n {id, title, tooltip, action: str | function, image: str' +
                    ' | {fontFamily,size,value,color,fontWeight}, cssClass}',
            type: 'Json object or array of objects',
          },
          {
            name: 'index',
            type: 'Numeric',
            tooltip: 'Position of the button',
            optional: true
          }
        ]
      },
      {
        name: 'AppendMenuItem({\n   id:#id#,\n   title:#title#,\n   tooltip:#tooltip#,'+
              '\n   image:{fontFamily:#font#, value:#char#, size:#size#,color:#color#},\n   action:#action#\n},#index#)',
        tooltip: 'Append item/s to the menu of the toolbar',
        returnValue: 'The function return true if the item has been added. The button may not be added when an element with the same id already exists',
        parameters : [
          {
            name: 'item',
            tooltip: 'Json Object or an array of objects with these properties: \n {id, title, tooltip, action: str | function, image: str' +
                    ' | {fontFamily,size,value,color,fontWeight}, cssClass}',
            type: 'Json object or array of objects',
          },
          {
            name: 'index',
            type: 'Numeric',
            tooltip: 'Position of the button in the menu',
            optional: true
          }
        ]
      },
      {
        name: 'AppendSubItem({\n   id:#id#,\n   title:#title#,\n   tooltip:#tooltip#,'+
              '\n   image:{fontFamily:#font#, value:#char#, size:#size#,color:#color#},\n   action:#action#\n},#parentId#)',
        tooltip: 'Append an item as a submenu of another item',
        parameters : [
          {
            name: 'item',
            tooltip: 'Json Object with these properties: \n {id, title, tooltip, action: str | function, image: str' +
                    ' | {fontFamily,size,value,color,fontWeight}, cssClass}',
            type: 'Json object',
          },
          {
            name: 'parentId',
            type: 'String',
            tooltip: 'Id of the button container'
          }
        ]
      },
      {
        name: 'AppendMenuSeparator(#id#,#index#)',
        tooltip: 'Append a separator to the menu of the toolbar',
        returnValue: '',
        parameters : [
          {
            name: 'id',
            tooltip: 'Id of the separator',
            type: 'String',
          },
          {
            name: 'index',
            type: 'Numeric',
            tooltip: 'Position of the separator in the menu',
            optional: true
          }
        ]
      },
      {
        name: 'Clean()',
        tooltip: 'Remove all the elements',
        returnValue: '',
        parameters : []
      },
      {
        name: 'Remove(#id#)',
        tooltip: 'Remove the element with the specified id',
        returnValue: '',
        parameters : [
          {
            name: 'id',
            type: 'String',
            tooltip: 'The id of the element to remove'
          }
        ]
      },
      {
        name: 'UpdateItem(#id#,{\n   title:#title#,\n   tooltip:#tooltip#,'+
        '\n   image:{fontFamily:#font#, value:#char#, size:#size#,color:#color#},\n   action:#action#\n}',
        tooltip: 'Update an element with the specified id',
        returnValue: '',
        parameters : [
          {
            name: 'id',
            type: 'String',
            tooltip: 'The id of the element to update'
          },
          {
            name: 'item',
            type: 'Json object',
            tooltip: 'An object with the properties to update'
          }
        ]
      },
      {
        name: 'GetItems()',
        tooltip: 'Returns the structure of items',
        parameters : []
      },
      {
        name: 'IsInToolbar(#id#)',
        tooltip: 'Return true if the element is visible in the toolbar',
        returnValue:'Boolean',
        parameters : [
          {
            name: 'id',
            type: 'String',
            tooltip: 'The id of the element'
          }
        ]
      },
      {
        name: 'IsInMenu(#id#)',
        tooltip: 'Return true if the element is visible in the menu',
        returnValue:'Boolean',
        parameters : [
          {
            name: 'id',
            type: 'String',
            tooltip: 'The id of the element'
          }
        ]
      }
    ],
    names : ['../portalstudio/images/component/bot_toolbar.png','../portalstudio/images/component/bot_toolbar.png'],
    events : [
      {
        name:'BeforeMenuOpen',
        tooltip:'Event dispatched before opening the menu'
      },
      {
        name:'AfterMenuOpen',
        tooltip:'Event dispatched after opening the menu'
      },
      {
        name:'BeforeMenuClose',
        tooltip:'Event dispatched before closing the menu'
      },
      {
        name:'AfterMenuClose',
        tooltip:'Event dispatched after closing the menu'
      },
    ],
    connector:[]
  }
  this.extend( this.stdVisibleObjClass , this.SPToolbarObjClass );

  this.HamburgerMenuClass={
    newProperties:{
      generic:[],
      style:[
        {name:'Css class',                propID:'class_Css',  type:'css_class', tooltip: 'Set the CSS class'},
        {name:'Max Subitem elements', propID:'maxsubitemelements', type:'int', tooltip: 'Maximum number of items to display. After this number a scollbar will appear inside the Hamburger Menu.'	}
      ],
      handler:[
        {name:'Handler',  propID:'visible_handler',  type:'checkbox',
        hide_list:{'unchecked':['this.handler_fontSize','this.handler_color','this.handler_bg_color']},
        show_list:{'checked':['this.handler_fontSize','this.handler_color','this.handler_bg_color']},
        tooltip:'If not checked, the handler for showing and hiding the menu will not appear. The menu will open only via function call from action code'},
        {name:'Font size',  propID:'fontSize',  type:'str', tooltip:'Set the handler font size'},
        {name:'color',     propID:'color',       type:'color', tooltip:'Set the handler color'},
        {name:'background color', propID:'bg_color', 	  type:'color', tooltip:'Set the handler background color' },
      ]
    },
    functions: [ ['Append(#item#,#parentID#,#index#) -> append item/s to the menu\n[id, title, tooltip, action : str | function ,\nchildren :'+
                  'Array, child_type : horizontal | vertical (default),\nimage: str | {fontFamily,size,value,color,fontWeight}]', 'Append({\n'+
                  '   id:#id#,\n   title:#title#,\n   tooltip:#tooltip#,\n   image:{fontFamily:#font#, value:#char#, size:#size#, color:#color#},'+'\n   action:#action#\n},#parentID#,#index#)']
                 ,['Clean() -> Empty menu content', 'Clean()']
                 ,'CloseMenu()'
                 ,'GetItem(#itemid#,#parentID#)'
                 ,'GetItemPosition(#itemid#, #parentID#)'
                 ,['GetItems() -> Returns the structure of items','GetItems()']
                 ,['OpenMenu()']
                 ,['Remove(#id#) -> Remove an element', 'Remove(#id#)']
                 ,['ShowItem(#id#,#isvisible#) -> Show/Hide an element', 'ShowItem(#id#,#isvisible#)']
                 ,['ToggleMenu()']
                 ,['UpdateItem(#itemid#,#item#) -> Update an element','UpdateItem(#itemid#,{\n   title:#title#,\n   '+
                  'tooltip:#tooltip#,\n   image:{fontFamily:#font#, value:#char#, size:#size#, color:#color#},'+'\n   action:#action#\n})']
               ],
    names : ['../portalstudio/images/icon/bot_hamburger.png','../portalstudio/images/icon/bot_hamburger.png'],
    events : [ 'BeforeMenuOpen', 'AfterMenuOpen', 'BeforeMenuClose','AfterMenuClose' ],
    connector:[]
  }
  this.extend( this.stdVisibleObjClass , this.HamburgerMenuClass );

// Oggetti ######################
this.formObj=function(h,w,color) {
  this.objClass = ZTObjects.formObjClass
  this.page = 1;//current page
  this.pages = "1";//pages list
  this.npages = 1;
  this.pages_names = ''; // titoli
  this.page_layer = ''; // se tipo layer
  this.pagesProp = [{ 'h':h,'w':w, 'title':'', 'layer':'','layout_steps_values':{} }];
  //this.currH = h;
  this.h = h;//multipla
  this.w = w//multipla;
  this.sequence = '';
  this.color = color;
  this.bg_image = '';
  this.v_line='';
  this.o_line = '';
  this.form_type = 'false';
  this.form_action = '';
  this.security = 'logged';
  this.on_security_failure = 'login';
  this.my_library = '';
  this.sp_theme = 'true';
  this.bg_image = '';
  this.css='';
  this.css_code="[]";
  this.cache_time = '';
  this.cache_in_post = 'false';
  this.language = 'false';
  this.sp_uid = 'false';
  this.description='';
  this.positioning = 'absolute';
  this.offline='false';
  this.shared_manifest = 'false';
  this.codemanifest='';
  this.manifest = 'Custom manifest';
  this.steps='';
  this.title='';
  this.title_url='';
  this.layout_steps_values = {};
  this.portlet_position='align center';
  this.mode="NORMAL";
  this.grapesCode="";
}
this.searchObj = function() {
  this.objClass = ZTObjects.searchObjClass;
  // this.cconstant = true;
  // this.cexpression = false;
  this.cwword = false;
  this.ccsensitive = false;
  this.chighlight = false;
  // this.csubsistute = false;
  // this.ssubstitute = '';
};

this.stdVisibleObj=function() {
  this.sequence = '';
  this.anchor = '';
  this.hide = 'false';
  this.layer = 'false';
  this.layout_steps_values = true;//Non pu� essere un oggetto
  this.steppable_prop_extra = ['hide'];
  this.zone = '';
}

this.stdHiddenObj = function () {
  this.sequence = '';
  this.hidden = true;
}

this.EventEmitterObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass=ZTObjects.EventEmitterClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.parmsNames=this.parmsValues=this.parmsTypes=this.eventsObjs=this.eventsNames='';
  this.broadcast='all';
  this.persistent='true';
  this.author='Zucchetti SitePainter';
};
this.EventEmitterObj.prototype = new this.stdHiddenObj;

this.EventReceiverObj=function(id,name,type,html,value,shadow,x,y) {
	this.objClass=ZTObjects.EventReceiverClass;
	this.id = id;
	this.name = name;
	this.type = type;
	this.html = html;
	this.value = value;
	this.shadow = shadow;
	this.x = x;
	this.y = y;
  this.h = 20;
  this.w = 120;
  this.sequence=''
  this.included = 'false';
  this.parmsNames=this.actTypes=this.actObjs=this.objsValues='';
  this.broadcast='all';
  this.author='Zucchetti SitePainter';
};
this.EventReceiverObj.prototype = new this.stdHiddenObj;

this.TextboxObj=function(id,name,type,html,value,shadow,x,y,h,w,dataobj,field,visible,init_par/*,scroll,readonly*/) {
  this.objClass = ZTObjects.TextboxObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.anchor='';
  this.font = '';
  this.font_size = '';
  this.color = '';
  this.dataobj = dataobj;
  this.field = field;
  this.visible = 'true';
  this.init_par = init_par;
  this.typevar = 'character';
  this.picture=''
  this.scroll = 'false';
  this.readonly = 'false';
  this.autocapitalize = 'on';
  this.class_Css = 'textbox';
  this.tabindex = '';
  this.pictures = '';
  this.zindex = 1;
  this.maxlength = '';
  this.placeholder = '';
  this.zerofilling = 'false';
  this.layout_steps_values = {};
  this.wireframe_props = 'name';
  this.author='Zucchetti SitePainter';
}
this.TextboxObj.prototype = new this.stdVisibleObj;

this.VariableObj=function(id,name,type,html,value,shadow,x,y,h,w,dataobj,field,init_par) {
  this.objClass = ZTObjects.VariableObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.font = 'verdana';
  this.font_size = '7pt';
  this.visible = 'false';
  this.scroll = 'false';
  this.readonly = 'false';
  this.dataobj = dataobj;
  this.typevar = 'character';
  this.field = field;
  this.init_par = init_par;
  this.server_side='false';
  this.wireframe_props = 'name';
  this.author='Zucchetti SitePainter';
}
this.VariableObj.prototype = new this.stdHiddenObj;

this.TemplateObj=function(id,name,type,html,value,shadow,x,y,h,w) {
  this.objClass = ZTObjects.TemplateObjClass;
	this.id = id;
	this.name = name;
	this.type = type;
	this.html = html;
	this.value = value;
	this.shadow = shadow;
	this.x = x;
	this.y = y;
	this.h = h;
	this.w = w;
  this.z_index = '1';
	this.author='Zucchetti SitePainter';
}
  this.TemplateObj.prototype = new this.stdVisibleObj;

this.BoxObj=function(id,name,type,html,value,shadow,x,y,h,w/*,bg_color,stretch*/) {
  this.objClass = ZTObjects.BoxObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.anchor='';
  this.stretch = 'false';
  this.zindex=0;
  this.class_Css = '';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.BoxObj.prototype=new this.stdVisibleObj;

this.ButtonObj=function(id,name,type,html,value,shadow,x,y/*,h,w,font,font_size,font_color,bg_color,border_color,border_weight*/) {
  this.objClass = ZTObjects.ButtonObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 25;
  this.w = 50;
  this.sequence='';
  this.anchor='';
  this.zindex = 1;
  this.font = '';
  this.font_size = '';
  this.font_color = '';
  this.bg_color = '';
  this.class_Css = 'button';
  this.border_weight = '';
  this.border_color = '';
  this.tabindex = '';
  this.type_submit = 'false';
  this.layout_steps_values = {};
  this.wireframe_props = 'value';
  this.author='Zucchetti SitePainter';
}
this.ButtonObj.prototype = new this.stdVisibleObj;

this.ImageObj=function(id,name,type,html,value,shadow,x,y,h,w,localsrc,src) {
  this.objClass = ZTObjects.ImageObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.sequence='';
  this.anchor='';
  this.localsrc = localsrc;
  this.srchover = '';
  this.src = src;
  this.keep_proportions = 'false';
  this.tabindex = '';
  this.zindex = 1;
  this.path_type='';
  this.type_submit = 'false';
  this.font_name = '';
  this.font_image = '';
  this.font_image_hover = '';
  this.img_type = 'default';
  this.class_Css = 'image';
  this.layout_steps_values = {};
  this.steppable_prop_extra=['hide','font_size'];
  this.author='Zucchetti SitePainter';
}
this.ImageObj.prototype = new this.stdVisibleObj;

this.LabelObj=function(id,name,type,html,value,shadow,x,y,h,w,font,font_color,font_size,font_weight,href,target,dataobj,field) {
  this.objClass = ZTObjects.LabelObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 200;
  this.font = '';
  this.font_color = '';
  this.font_weight = '';
  this.font_size = '';
  this.fontpct = '';
  this.bg_color = '';
  this.align = '';
  this.class_Css = 'label';
  this.target = target;
  this.dataobj = dataobj;
  this.field = field;
  this.picture = '';
  this.tabindex = '';
  this.enable_HTML = 'false';
  this.sanitize = 'xssPrevent';
  this.nowrap = 'false';
  this.zindex = 1;
  this.n_col = 1;
  this.template_code;
  //this.layout_steps_values = {};
  this.steppable_prop_extra=['hide','align','n_col','fontpct'];
  this.wireframe_props = 'align,value,n_col';
  this.author='Zucchetti SitePainter';
}
this.LabelObj.prototype=new this.stdVisibleObj;

this.SQLDataobj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass = ZTObjects.SQLDataobjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.query = '';
  this.allowedqueries = '';
  this.n_records = 10;
  this.count = 'false';
  this.auto_exec = 'true';
  this.query_async='true';
  this.return_fields_type = 'true';
  this.appendingData = 'false';
  this.offline = !EmptyString(formProp.offline)?formProp.offline:'false'; //parte offline se il portlet e' offline
  this.GetQueryFields=function(queryname,retDesc){
    var res=[];
    var types=[];
    var desc=[];
    var AllField = new JSURL("../servlet/SPVQRProxy?action=fields&filename="+queryname+"&offlinemode="+this.offline, true);
    AllField = AllField.Response();
    var rows, i;
    if(Left(AllField,9)=="BO_QUERY:"){
      AllField = Substr(AllField,10);
      var CSV_SEP="#!$";
      var row;
      rows = AllField.split(CSV_SEP);
      for (i=0; i<rows.length; i++){
        row=rows[i].split("|");
        res.push(row[0]);
        if(retDesc==true)
          desc.push(row[2]);
      }
    }
    else {
      var l_oFields = new TrsJavascript();
      l_oFields.reset();
      l_oFields.SetRow(0);
      l_oFields.BuildProperties(AllField);
      rows = GetProperty(l_oFields,'Rows','N');
      for (i=0; i<rows; i++){
        l_oFields.SetRow(i);
        res.push(GetProperty(l_oFields,'alias','C'));
        if(retDesc==true)
          desc.push(GetProperty(l_oFields,'desc','C'));
        types.push(GetProperty(l_oFields,'type','C'));
      }
    }
    return retDesc?[res,desc,types]:[res,types];
  }
  this.long_query = false;
  this.waiting_mgs = "";
  this.init_time = 0;
  this.dialog_css_class = "sqldataprovider";
  this.author='Zucchetti SitePainter';
}
this.SQLDataobj.prototype = new this.stdHiddenObj;

this.XMLDataobj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass = ZTObjects.XMLDataobjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.source = '';
  this.n_records = '';
  this.auto_exec = 'true';
  this.async='false';
  this.author='Zucchetti SitePainter';
}
  this.XMLDataobj.prototype = new this.stdHiddenObj;

this.JSONDataobj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass = ZTObjects.JSONDataobjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.source = '';
  this.auto_exec = 'true';
  this.async='false';
  this.author='Zucchetti SitePainter';
}
this.JSONDataobj.prototype = new this.stdHiddenObj;

this.StaticDataProvider=function(id,name,type,html,value,shadow,x,y) {
  this.objClass  = ZTObjects.StaticDataProviderClass;
  this.id        = id;
  this.name      = name;
  this.type      = type;
  this.html      = html;
  this.value     = value;
  this.shadow    = shadow;
  this.x         = x;
  this.y         = y;
  this.h         = 20;
  this.w         = 120;
  this.dataproviders= '';
  this.derivType = 'SQLDataobj';
  this.parms = '';
  this.parms_source = '';
  this.GetQueryFields=function(queryname,retDesc){
    var res=[];
    if (this.man_query && this.man_query.indexOf("{") == 0) {
      var l_oFields = new TrsJavascript();
      var types=[];
      var rows, i;
      var fields;
      if(retDesc==true)
        var desc=[];
      l_oFields.reset();
      l_oFields.SetRow(0);
      l_oFields.BuildProperties(this.man_query,true);
      fields = GetProperty(l_oFields, 'fields', 'C');
      l_oFields.BuildProperties(fields);
      rows = GetProperty(l_oFields, 'Rows', 'N');
      for (i = 0; i < rows; i++) {
        l_oFields.SetRow(i);
        res.push(GetProperty(l_oFields, 'alias', 'C'));
        if (retDesc == true){
          desc.push(GetProperty(l_oFields, 'desc', 'C'));
        }
        types.push(GetProperty(l_oFields, 'type', 'C'));
      }
      return retDesc ? [res, desc, types] : [res, types];
    }
    res = this["alias"].split(',');
    if (retDesc)
      return [res,res,this['fieldsType'].split(',')];
    else
      return [res,this['fieldsType'].split(',')];
  }
  this.auto_exec = 'true';
  this.man_query = '';
  this.author='Zucchetti SitePainter';
}
this.StaticDataProvider.prototype = new this.stdHiddenObj;

this.MaskParameters=function(id,name,type,html,value,shadow,x,y,h,w) {
	this.objClass =ZTObjects.MaskParametersClass;
	this.id = id;
	this.name = name;
	this.type = type;
	this.html = html;
	this.value = value;
	this.shadow = shadow;
	this.sequence = ' ';
	this.x = x;
	this.y = y;
	this.h = h;
	this.w = w;
  this.author='Zucchetti SitePainter';
}
this.MaskParameters.prototype = new this.stdHiddenObj;

this.XZoom=function(id,name,type,html,value,shadow,x,y,h,w) {
  this.objClass =ZTObjects.XZoomClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.sequence='';
  this.checkbox='false';
  this.checkAll='false';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.XZoom.prototype = new this.stdVisibleObj;

this.GridObj=function(id,name,type,html,value,shadow,x,y,h,w,dataobj,rows,columntitles,columnfields) {
  this.objClass = ZTObjects.GridObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 200;
  this.w = 300;
  this.anchor='';
  this.dataobj = dataobj;
  this.server_side ='false' ;
  this.rows = 10;
  this.empty_rows = 'false';
  this.valign = 'top';
  this.align = 'left';
  this.align = 'left';
  this.pictures = '';
  this.columnfields = columnfields;
  this.columntitles = '';
  this.columnformat = '';
  this.on_click = '';
  this.font = '';
  this.font_color = '';
  this.font_size = '';
  this.font_weight = '';
  this.over_color = '';
  this.link_underlined = '';
  this.line_color = '';
  this.title_color = '';
  this.row_color = '';
  this.css_class_grid='grid'
  this.css_class_title=''
  this.css_class_title_hover=''
  this.css_class_row=''
  this.css_class_row_odd=''
  this.css_class_row_over=''
  this.css_class_row_selected=''
  this.css_class_nav_bar=''
  this.filters='false'
  this.splinker=''
  this.cellspacing = '1';
  this.cellpadding = '3';
  this.draggablecolumns='false'
  this.resizablecolumns='false'
  this.checkbox='false'
  this.preCheckbox_fld='';
  this.homogeneityAsFilter='false';
  this.outDataObj='';
  this.extensible='false';
  this.scroll_bars='false';
  this.keepMemCurs='true';
  this.nav_bar_firstlast='true';
  this.nav_bar_addremove='true';
  this.nav_bar_changepage='true';
  this.nav_bar_lastpage='true';
  this.nav_bar_pagepanel='true';
  this.group_repeated='false';
  this.floatRows='false';
  this.layout_steps_values = {};
  this.wireframe_props='colProperties,checkbox,rows' ;
  this.author='Zucchetti SitePainter';
}
this.GridObj.prototype=new this.stdVisibleObj;

this.TabsObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass = ZTObjects.TabsObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 40;
  this.w = 120;
  this.sequence='';
  this.anchor='';
  this.font = 'Verdana';
  this.font_color = '#000000';
  this.font_size = '7pt';
  this.font_weight = 'bold';
  this.bg_color = '#FFFFFF';
  this.selected_color = '';
  this.vertical = 'false';
  this.vertical_text = 'false';
  this.links = '...';
  this.href='';
  this.target = '';
  this.sp_tabstrip = 'false';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.TabsObj.prototype=new this.stdVisibleObj;

this.IframeObj=function(id,name,type,html,value,shadow,x,y,h,w,auto_resize,default_portlet) {
  this.objClass = ZTObjects.IframeObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.h = 20;
  this.w = 120;
  this.sequence='';
  this.anchor='';
  this.auto_resize = 'false';
  this.default_portlet = default_portlet;
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.IframeObj.prototype=new this.stdVisibleObj;

this.SPLinkerObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass =ZTObjects.SPLinkerObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.popup = 'false';
  this.popup_scroll = 'false';
  this.popup_maximized = 'false';
  this.async = 'false';
  this.offline = formProp.offline; //parte offline se il portlet e' offline
  this.check_exp = '';
  this.author='Zucchetti SitePainter';
}
this.SPLinkerObj.prototype = new this.stdHiddenObj;
this.PortletObj=function(id,name,type,html,value,shadow,x,y,h,w) {
  this.objClass =ZTObjects.PortletObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;
  this.sequence='';
  this.anchor='';
  this.themed='false';
  this.isoptional='false';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.PortletObj.prototype=new this.stdVisibleObj;

this.CheckboxObj=function(id,name,type,html,value,shadow,x,y,h,w,label_text) {
  this.objClass =ZTObjects.CheckboxObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 25;
  this.w = 90;
  this.sequence='';
  this.zindex = 1;
  this.init_par ='';
  this.tabindex = '';
  this.typevar='logic';
  this.disabled='false';
  this.checked_value='true';
  this.unchecked_value='false';
  this.css_class='label';
  this.label_text=label_text;
  this.layout_steps_values = {};
  this.wireframe_props = 'label_text';
  this.author='Zucchetti SitePainter';
}
this.CheckboxObj.prototype = new this.stdVisibleObj;

this.ComboboxObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass =ZTObjects.ComboboxObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 20;
  this.w = 120;
  this.picture = '';
  this.zindex = 1;
  this.typevar = 'character';
  this.font = '';
  this.font_size = '';
  this.class_Css = 'combobox';
  this.tabindex = '';
	this.visible = 'true';
	this.disabled = 'false';
  this.empty_value='true';
  this.layout_steps_values = {};
  this.wireframe_props='name,textlist' ;
  this.author='Zucchetti SitePainter';
}
this.ComboboxObj.prototype=new this.stdVisibleObj;

this.RadioObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass =ZTObjects.RadioObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 70;
  this.w = 180;
  this.picture = '';
  this.zindex = 1;
  this.typevar = 'character';
  this.font = '';
  this.font_size = '';
  this.class_Css = 'radio';
  this.tabindex = '';
	this.visible = 'true';
	this.disabled = 'false';
  this.orientation = 'vertical';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.RadioObj.prototype = new this.stdVisibleObj;

this.DataMasherObj = function(id,name,type,html,value,shadow,x,y) {
  this.objClass = ZTObjects.DataMasherObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.w = 120;
  this.h = 100;
  this.rows_split = 'Field';
  this.cols_split = 'Field';
  this.row_marginal = 'None';
  this.col_marginal = 'None';
  this.css_class_datamasher = 'datamasher';
  this.delay_show = 0;
  this.delay_hide = 0;
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
}
this.DataMasherObj.prototype=new this.stdVisibleObj;

this.StdTreeViewObj=function(id,name,type,html,value,shadow,x,y/*,h,w*/) {
  this.objClass =ZTObjects.StdTreeViewObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.font = 'Verdana';
  this.font_size = 10;
  this.x = x;
  this.y = y;
  this.w = 130;
  this.h = 194;
  this.set_icons = ' ';
  this.css_class = ' ';
  this.sequence = ' ';
  this.scroll_bars = 'false';
  this.derivType='SQLDataobj';
  this.enable_html = 'false';
  this.layout_steps_values = {};
  this.droppable='false';
  this.author='Zucchetti SitePainter';
};
this.StdTreeViewObj.prototype=new this.stdVisibleObj;

this.HamburgerMenuObj=function(id,name,type,html,value,shadow,x,y/*,h,w*/) {
  this.objClass=ZTObjects.HamburgerMenuClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.w = 40;
  this.h = 40;
  this.anchor='';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
  this.visible_handler=true;
}
this.HamburgerMenuObj.prototype=new this.stdVisibleObj;

this.NoteObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass =ZTObjects.NoteObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.font_color = '#232323';
  this.bg_color = '#F8E44F';
  this.h=100;
  this.w=200;
  this.x = x;
  this.y = y;
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
};
this.NoteObj.prototype = new this.stdHiddenObj;

this.SPToolbarObj=function(id,name,type,html,value,shadow,x,y) {
  this.objClass =ZTObjects.SPToolbarObjClass;
  this.id = id;
  this.name = name;
  this.type = type;
  this.html = html;
  this.value = value;
  this.shadow = shadow;
  this.x = x;
  this.y = y;
  this.h = 40;
  this.w = 130;
  this.anchor='';
  this.layout_steps_values = {};
  this.author='Zucchetti SitePainter';
  this.iconWidth=30;
  this.css_class='sptoolbar';
}
this.SPToolbarObj.prototype=new this.stdVisibleObj;


//Oggetti per operazione UNDO
this.undoObj=function(id,action,x,y,x_init,y_init,obj,w,h,w_init,h_init) {
  this.id=id;
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
  this.author='Zucchetti SitePainter';
}
this.CreateFillSteps=function(tab,propID){
 var propBtnFill = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe692;'.substring(3,7),16))});
    propBtnFill.refId=tab+"_"+propID;
    propBtnFill.refPropId=propID;
    return propBtnFill;
}
this.CreateFillBO=function(tab,propID){
  var propBtnFill = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe692;'.substring(3,7),16))});
     propBtnFill.refId=tab+"_"+propID;
     propBtnFill.refPropId=propID;
     return propBtnFill;
}
this.CreateBtnInsertBefore=function(tab,propID){
  var propBtnInsertBefore = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xea64;'.substring(3,7),16)), style: '--icon-font-family: icons8_win10; --icon-size: 23px; width: 25px'});
  propBtnInsertBefore.refId=tab+"_"+propID;
  propBtnInsertBefore.refPropId=propID;
return propBtnInsertBefore;
}
this.TitleFillSteps=function(){
  return "Create common default steps";
}
this.TitleFillBO=function(){
  return "Pick the items from selected BO";
}
this.TitleBtnInsertBefore=function(){
  return "Insert page before current";
}
//
// this.Createsearch = function(tab, propID){
  // var propBtnInfo = new Element('div', {'class':'input_inline_btn search_btn', 'icon-data' : String.fromCharCode(parseInt('&#xe67f;'.substring(3,7),16))});
  // propBtnInfo.refId = tab + "_" + propID;
  // propBtnInfo.refPropId = propID;
  // return propBtnInfo;
// };
this.Titlesearch = function(){
  return "Find";
};

this.Createsubstitute = function(tab, propID){
  var propBtnInfo = new Element('div', {'class':'input_inline_btn substitute_btn', 'icon-data' : String.fromCharCode(parseInt('&#xe67f;'.substring(3,7),16))});
  propBtnInfo.refId = tab + "_" + propID;
  propBtnInfo.refPropId = propID;
  return propBtnInfo;
};

this.Titlesubstitute = function(){
  return "Substitute";
};

}
}
// Oggetto aggiunto
function getobj(obj,path){
  var urlobj = new JSURL((path? path : '' )+obj,true)
  var strobj=urlobj.Response()
  try{
    eval(strobj);
    return true;
  }catch(e){
    if(confirm('Component '+obj+' not installed.\nWould you like to see more details?')){
      var s=''
      for(var p in e) s+='\t'+p+' => '+e[p]+';\n';
      var re=new RegExp('\t','g');
      re.multiline=true;
      alert('Error properties:\n'+e.message+'\n'+s+'\nObject:\n'+strobj.replace(re,'    '));
    }
    return false;
  }
}

// cerco tra due percorsi
function getobj_def(obj, obj_js, path) {
  var urlobj = new JSURL((path? path : '' )+obj,true),
  strobj = urlobj.Response();
  try {
    eval(strobj);
    return true;
  }
  catch (e) {
    // provo con obj_js
    urlobj = new JSURL((path? path : '' )+obj_js,true),
    strobj = urlobj.Response();
    try {
      eval(strobj);
      return true;
    }
    catch (ee) {
      if (confirm('Components '+ obj +' and ' + obj_js + ' not installed.\nWould you like to see more details?')) {
        var s=''
        for(var p in e) s+='\t'+p+' => '+e[p]+';\n';
        var re=new RegExp('\t','g');
        re.multiline=true;
        alert('Error properties:\n'+e.message+'\n'+s+'\nObject:\n'+strobj.replace(re,'    '));
      }
      return false;
    }
  }
}

// recupera il codice css da una classe del class editor
function getClassCode(name) {
	for(var i = 0; i < classCssObj.length; i++) {
		if(classCssObj[i].name == name) {
			return classCssObj[i].code;
		}
	}
}

// rimuove tutte le classi e assegna le nuove (serve per la VisualMode)
function removeAllClass(originalClassName, newClassName) {
	for (var i=0; i < originalClassName.length; i++) {
		var paras = document.getElementsByClassName(originalClassName[i]);
		while(paras[0]) {
			paras[0].className = paras[0].className.replace(originalClassName[i],newClassName[i]);
		}
	}
}
