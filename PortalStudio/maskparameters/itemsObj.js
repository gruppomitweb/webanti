/* exported
    index itemsHTML m_bUpdated formProp last_index newPropObj
  */

var index = null; // indice corrente del mainitem  nell'Array
var itemsHTML = new Array()   //array contenente tutti gli oggetti item  con id ,HTML,shadow,ecc
var m_bUpdated = false;
var formProp = null;
var last_index, newPropObj;
var formProperties=['titleMsg','descriptionMask','mode','columns','maxLabelWidth','minLabelWidth','maxFieldWidth','onOkResource','onOkAction','onDiscardResource',
                    'onDiscardAction','target','discardTarget', 'offsetTop','libraries','listMinLabelWidth','cover','maskVersion','filterAtChange','onValidateFunction',
                    'errorMsg','initRoutine','progressBar','spuid','confirmRoutine','closeOnConfirm','confirmActionTitle','confirmActionTooltip','discardActionTitle',
                    'discardActionTooltip','listColumnWidth','emptyAllParam'];
var fieldProperties=['fieldName','description','type','len','dec','initialValue','isFilter','hiddenGroup','group','collapsedGroup','tooltip','displayLen',
                     'keepOnPreviousRow','viewType','linkedTable','zoomConfigName','zoomTitle','keyField','readField','linkedField','fixedFilter','fixedValue',
                     'nCriteria','looselyLinked','linkedFieldName', 'comboValues','comboLabels','tableName','tableKeyField','valueField','orderField','filterField',
                     'filterValue','queryName','queryParameters','maxQueryRow','checkedValue','uncheckedValue','editUnderCondition','hideUnderCondition','initialOperation',
                     'changeOperation','queryFilter','calculate','dependsOn','openZoom','zoomQryParam','check','errorMsg','hideEmptyValue','labelEmptyValue','calculateLabel',
                     'calculateInitialValue','obligatoryCondition','cover','uid','hiddenInVariant','labelWid','zeroFilling','extMask','labelCssClass','spuid','labelSpuid',
                     'linkButton','parameters','titleButton','styleButton','imageButton','classButton','picture','entityType','linkWidth','linkHeight','fillEmptyKeys',
                     'suggest','row_suggest','textWidth','textHeight','action','sendAllParams','target','popup','popupScroll','popupStyle','calculateTooltip','calculateZoomTitle',
                     'widthImage','heightImage','imageFont','imageChar','imageColor','imageSize','obligatoryMsg','hiddenLabel','radioOrientation','servlet','sendKeyZoomOnZoom'];
var groupProperties=['groupName','collapsedGroup','mode','columns','maxFieldWidth','maxLabelWidth','minLabelWidth','hideUnderCondition','listMinLabelWidth',
                     'uid','calculateLabel','editUnderCondition','visibility','groupSetName','listColumnWidth'];
var calculationProperties=['calculationRoutine','dependsOn','calculationName','calcUnderCondition','parameters'];
var labelProperties=['fieldName','description','uid','calculateLabel','hiddenGroup','hiddenInVariant','extMask','keepOnPreviousRow','cover','hideUnderCondition',
                     'labelCssClass','labelAlign','textAlign'];
var buttonProperties=['fieldName','uid','hiddenGroup','hiddenInVariant','extMask','keepOnPreviousRow','hideUnderCondition','editUnderCondition','linkButton',
                      'parameters','titleButton','styleButton','imageButton','classButton','entityType','linkWidth','linkHeight','action','sendAllParams','target',
                      'popup','popupScroll','popupStyle','widthImage','heightImage','imageFont','imageChar','imageColor','imageSize'];
var actionProperties=['actionName','title','tooltip','resource','action','parameters','target','progressBar','imageSettings','imageUrl','imageFont','imageChar',
                      'imageSize','imageColor','popup','resourceType','sendAllParams','popupStyle','popupHeight','popupWidth','popupScroll']

if(typeof(ZTObjects)=='undefined'){
  var ZTObjects=new function(){
    this.formObjClass={
      newProperties:{
        generic:[
          {name:'mask name', propID:'configName', type:'str', tooltip:'Mask name', noteditable:true},
          {name:'title' , propID:'titleMsg' ,type:'str', tooltip:'The title of the mask which will be visible in the decorator'},
          {name:'Description' , propID:'description' ,type:'str', tooltip:'Mask description' }
        ],
        layout:[
          {name:'mode' ,propID:'mode' ,type:'select[1 Vertical mask. Field and label on the same line:1,2 Vertical mask. Label over the field:2,3 Horizontal mask. Label over the field. All in the same row:3]', tooltip:'Display mode of the mask' },
          {name:'columns' ,propID:'columns' ,type:'int', validFunc:'IsNumericInput', tooltip:'Number of columns that divide the mask' },
          {name:'column width' ,propID:'listColumnWidth' ,type:'str', tooltip:'List, comma separated, of column width (in px or %) for each columns. \n If you specified only one value, the column will be applied for all columns. \n If not specified the values will be in percentage '},
          {name:'offset top' ,propID:'offsetTop', type:'int', validFunc:'IsNumericInput', tooltip:'The space to leave between the title and the fields (in px)' },
          {name:'max label width' ,propID:'maxLabelWidth' ,type:'int', validFunc:'IsNumericInput', tooltip: 'Max width of the label (in px)', section:'Size' },
          {name:'min label width' ,propID:'listMinLabelWidth' ,type:'str', tooltip:'List, comma separated, of min label width(in px) for each columns. \n If you specified only one value, the min label width will be applied for all columns.', section:'Size' },
          {name:'max field width' ,propID:'maxFieldWidth', type:'int', validFunc:'IsNumericInput', tooltip:'Max width of the field (in px)', section:'Size'}
        ],
        action:[
          {name:'confirm action title' , propID:'confirmActionTitle' ,type:'str', tooltip:'The title of confirm button', section:'Confirm action'},
          {name:'confirm action tooltip' , propID:'confirmActionTooltip' ,type:'str', tooltip:'The tooltip of confirm button', section:'Confirm action'},
          {name:'resource' , propID:'onOkResource' ,type:'str', tooltip:'Servlet called to confirm', section:'Confirm action'},
          {name:'action' ,propID:'onOkAction' ,
           type:'autocomplete[default:new,write,writeload,query,start,delete,deleterow,edit,editload,view,function,function autoexec,function server autoexec,async routine,autozoom,zoom,routine caller]',
           tooltip:'Action for the confirm servlet', section:'Confirm action'},
          {name:'target' ,propID:'target', type:'str', tooltip:'Target in which to run the confirm servlet', section:'Confirm action'},
          {name:'close mask' ,propID:'closeOnConfirm', type:'checkbox', tooltip:'If true, close mask on confirm', section:'Confirm action'},
          {name:'Progress bar' ,propID:'progressBar', type:'checkbox', tooltip:'Progress bar', section:'Confirm action'},
          {name:'discard action title' , propID:'discardActionTitle' ,type:'str', tooltip:'The title of discard button', section:'Discard action'},
          {name:'discard action tooltip' , propID:'discardActionTooltip' ,type:'str', tooltip:'The tooltip of discard button', section:'Discard action'},
          {name:'resource' ,propID:'onDiscardResource' ,type:'str', tooltip:'Servlet called to discard', section:'Discard action'},
          {name:'action' ,propID:'onDiscardAction',
          type:'autocomplete[default:new,write,writeload,query,start,delete,deleterow,edit,editload,view,function,function autoexec,function server autoexec,async routine,autozoom,zoom,routine caller]',
          tooltip:'Action for the discard servlet', section:'Discard action'},
          {name:'target' ,propID:'discardTarget', type:'str', tooltip:'Target in which to run the discard servlet', section:'Discard action'},
          {name:'empty All Parameter' ,propID:'emptyAllParam', type:'checkbox',
           tooltip:'If true, in zoom mode query parameters will also be emptied', section:'Refresh action'}
        ],
        advanced:[
          {name:'Libraries' ,propID:'libraries', type:'str', tooltip:'List, comma separated, of a javascript libraries to import' },
          {name:'Display in report cover', propID:'cover', type:'select[Dependent on each field:0,All fields:1]',
          tooltip:'If you select "All fields" option, all fields will be print always. \n Otherwise, each field will be displayed or not based on the value specified in the individual field'},
          {name:'filter at change', propID:'filterAtChange', type:'checkbox',
          tooltip:'If true, in zoom mode, the zoom will be filtered at change of each value'},
          {name:'Init routine' ,propID:'initRoutine', type:'str',
           tooltip:'Routine called when loading the mask. The fields will be initialized with the values of the routine caller variable' },
          {name:'Check function' ,propID:'onValidateFunction', type:'str', tooltip:'Sitepainter function called to confirm action' },
          {name:'Error message' ,propID:'errorMsg', type:'str', tooltip:'Error message displayed when the check function fails' },
          {name:'Confirm routine', propID:'confirmRoutine', type:'str', tooltip:'Routine called before confirm action'}
          // {name:'Parameters',propID:'confirmRoutineParameters', type:'str'}
          // {name:'sp id',propID:'spuid', type:'checkbox'}
        ],
        Customization:[
          {name:'save in custom dir' ,propID:'customVdm', type:'checkbox', tooltip:'Save in custom directory' },
          {name:'mask for user or group', propID:'user_group', type: 'select[,User:user,Group:group]',
            hide_list:{'':['this.Customization_user','this.Customization_group'],'user':['this.Customization_group'],'group':['this.Customization_user']},
            show_list:{'user':['this.Customization_user'],'group':['this.Customization_group']}
          },
          {name:'Group',propID:'group',type:'str',validFunc:'IsNumericInput', tooltip:'Set the group code'},
          {name:'User',propID:'user',type:'str',validFunc:'IsNumericInput', tooltip:'Set the user code'}
        ]
      }
    }

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

    this.PSToolbarAction = [
      { 'id': 'new'
        , 'class_name': 'btn'
        , 'action': function(){ reset(); }
        , 'image': '../portalstudio/images/icon/btn_new.png'
        , 'title': 'New'
      // },{ 'id': 'open'
        // , 'class_name': 'btn'
        // , 'action': function(){ openFile(); }
        // , 'image': '../portalstudio/images/icon/btn_open.png'
        // , 'title': 'Open'
      },{ 'id': 'save'
        , 'class_name': 'btn'
        , 'action': function(){ save(); }
        , 'image': '../portalstudio/images/icon/btn_save.png'
        , 'title': 'Save'
      },{ 'id': 'saveas'
        , 'class_name': 'btn'
        , 'action': function(){ saveAs('true'); }
        , 'image': '../portalstudio/images/icon/btn_saveAs.png'
        , 'title': 'Save As'
      },
      {
        'isSeparator': true
      },
      { 'id': 'addLabel'
        , 'class_name': 'btn'
        , 'action': function(){ addLabel(null,true); }
        , 'image': '../portalstudio/images/icon/bot_label_off.png'
        , 'title': 'Add label'
      },
      { 'id': 'addField'
        , 'class_name': 'btn'
        , 'action': function(){ addField(null,true); }
        , 'image': './images/add_field.png'
        , 'title': 'Add field'
      },
      { 'id': 'addGroup'
        , 'class_name': 'btn'
        , 'action': function(){ addGroup(null,true); }
        , 'image': './images/add_group.png'
        , 'title': 'Add group'
      },
      { 'id': 'addButton'
        , 'class_name': 'btn'
        , 'action': function(){ addButton(null,true); }
        , 'image': '../portalstudio/images/icon/bot_button_off.png'
        , 'title': 'Add button'
      },
      /*{ 'id': 'addCalculation'
        , 'class_name': 'btn'
        , 'action': function(){ addCalculation(null,true); }
        , 'image': './images/add_calculation.png'
        , 'title': 'Add calculation'
      },*/
      {
        'isSeparator': true
      },
      { 'id': 'check'
        , 'class_name': 'btn'
        , 'action': function(){ checkField(); }
        , 'image': './images/check_field.png'
        , 'title': 'Check field'
      }
    ]
    this.PSToolbarPreview = [
    /*{ 'id':'showHiddenVariant'
        , 'class_name': 'showHidden'
        , 'action': function(){}
        , 'image': ''
        , 'title': ''
        , 'innerHTML': '<div style="display:inline-block; width:19px; position:relative; bottom:3px;"><input type="checkbox" name="showHiddenVariant" id="check_showHiddenVariant" checked/></div> <div style="display:inline-block; width:97px; position:relative; top:2px;"> Show hidden in configuration</div>'

      },
      { 'id':'showHidden'
        , 'class_name': 'showHidden'
        , 'action': function(){}
        , 'image': ''
        , 'title': ''
        , 'innerHTML': '<div style="display:inline-block; width:19px; position:relative; bottom:3px;"><input type="checkbox" name="showHidden" id="check_showHidden"/></div> <div style="display:inline-block; width:80px; position:relative; top:2px;"> Show always hidden</div>'

      },
       { 'id':'showExtended'
        , 'class_name': 'showHidden'
        , 'action': function(){}s
        , 'image': ''
        , 'title': ''
        , 'innerHTML': '<div style="display:inline-block; width:19px; position:relative; bottom:3px;"><input type="checkbox" name="showExtended" id="check_showExtended"/></div> <div style="display:inline-block; width:100px; position:relative; top:2px;"> Show extended fields</div>'

      },*/
      { 'id': 'preview_config'
        , 'class_name': 'btn'
        , 'action': function(){ openPreviewConfig(); }
        , 'image': '../portalstudio/images/icon/btn_preview_config.png'
        , 'title': 'Open preview configurator'
      },
      { 'id': 'refresh'
        , 'class_name': 'btn'
        , 'action': function(){ refreshMask(); }
        , 'image': '../portalstudio/images/icon/btn_refresh.png'
        , 'title': 'Refresh mask prototype'
      },{ 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function(){ togglePreview(); }
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Go to preview'
      }
    ]
    this.fieldObjClass={
      newProperties:{
        generic:[
          {name:'name',propID:'fieldName',type:'str', tooltip:'Name of the field'},
          {name:'label',propID:'label',type:'str', tooltip:'Description of the field, wich will displayed in preview' ,alwaysUpdates:true, section:'Label'},
          {name:'calculate label',propID:'calculateLabel',type:'checkbox', tooltip:'if true, the label will be calculated', section:'Label', extraClass:'col-3'},
          {name:'hidden label',propID:'hiddenLabel',type:'checkbox', tooltip:'if true, the label will be hidden', section:'Label', extraClass:'col-3'},
          {name:'tooltip',propID:'tooltip',	type:'str', tooltip:'Tooltip of the field', section:'Label'},
          {name:'calculate tooltip',propID:'calculateTooltip',type:'checkbox', tooltip:'if true, the tooltip will be calculated', section:'Label'},
          {name:'Type filter',propID:'typeFilter',	type:'select[Query parameter,Zoom filter,No filter]',
          tooltip:'With Query parameter and Zoom filter options \nthe field is always sent and the difference between 2 \nis only in a zoom configuration: \nthe first indicates a vqr parameter and \nthe second a fixed filter. \nNo filter indicates a support field that is never sent'}
        ],
        functional:[
          {name:'type',propID:'objType',type:'select[Character:C,Numeric:N,Date:D,Logical:L,Memo:M,DateTime:T]', tooltip:'Type of the field',
            hide_list:{
              'C,D,L,M,T':['this.functional_dec'],
              'D,L,T':['this.functional_len']
              // 'C,N,D,L,T':['this.view_textWidth','this.view_textHeight']
            },
            show_list:{
              'N':['this.functional_dec'],
              'N,C,M':['this.functional_len']
              // 'M':['this.view_textWidth','this.view_textHeight']
            },
            section:'Type', extraClass:'hide-title'
          },
          {name:'length',propID:'len',type:'int', validFunc:'IsNumericInput', tooltip:'Length of the field', section:'Type', extraClass:'col-3'},
          {name:'decimals',propID:'dec',type:'int', validFunc:'IsNumericInput', tooltip:'Decimals number', section:'Type', extraClass:'col-3'},
          // {name:'sp id',propID:'spuid', type:'str'},
          // {name:'label sp id',propID:'labelSpuid', type:'str'},
          {name:'Value',propID:'initialValue',	type:'str', tooltip:'Initial value of the field.\nQuotes are not necessary for character field', section:'Init'},
          {name:'calculate',propID:'calculateInitialValue',type:'checkbox', tooltip:'If true, the init value will be calculated',section:'Init'},
          {name:'picture',propID:'picture',type:'str', tooltip:'The picture of the field'},
          {name:'zero filling',propID:'zeroFilling',type:'checkbox', tooltip:'Left adding of \'0\' characters until field length is reached'},
          {name:'Initial operation',propID:'initialOperation',
           type:'select[starts with:like,contains,=,<,<=,>=,>,<>,empty,not empty:notempty,current month:currentmonth,current year:currentyear,last month:lastmonth,last year:lastyear,last 30 days:last30days,last 60 days:last60days,last 90 days:last90days]',
           tooltip:'Initial value of the operation parameter. \nThis properties has sense only in a zoom configuration', section:'Zoom filter operation', extraClass:'col-3'},
          {name:'Enable change operation',propID:'changeOperation',	type:'checkbox',
           tooltip:'If true, the final user can modify the operation type. \nThis properties has sense only in a zoom configuration', section:'Zoom filter operation', extraClass:'col-3'}
        ],
        view:[
          {name:'visibility', propID:'visibility', type:'select[base:base,extended:extMask,hidden in configuration:hiddenInVariant,always hidden:hiddenGroup]',
           tooltip:'Visibility of the field. \n Base: the field is visible always \n Extended: the field is visible only in extended mode. \n Hidden in configuration: the field is hidden but you can make it visible from smart editor. \n Always hidden: the field is always hidden'},
          {name:'Display length',propID:'displayLen',	type:'int', validFunc:'IsNumericInput', tooltip:'Length of the input box of the field (in characters)', section:'Size'},
          {name:'label width',propID:'labelWid',	type:'int', validFunc:'IsNumericInput', tooltip:'Width of the label (in px)', section:'Size'},
          {name:'Textarea width',propID:'textWidth',	type:'int', validFunc:'IsNumericInput', tooltip:'Width of the textarea (in px)', section:'Size', extraClass:'col-3'},
          {name:'Textarea height',propID:'textHeight',	type:'int', validFunc:'IsNumericInput', tooltip:'Height of the textarea (in px)', section:'Size', extraClass:'col-3'},
          {name:'Keep on previous row',propID:'keepOnPreviousRow',	type:'checkbox', tooltip:'If checked, the field appears in the same row of the previous field', section:'Style'},
          {name:'Label Css class',propID:'labelCssClass', type:'str', tooltip:'Label Css Class', section:'Style'},
          {name:'Display in report cover', propID:'cover', type:'select[Default:0,Always:1,Never:2]',
          tooltip:'If you select "Default" option, the field will be printed in report cover only if valorised. \n If you select "Always" option, the field will be printed always. \n At last with the "Never" option, the field will not be printed.'}
        ],
        advanced:[
           {name:'view type', propID:'viewType',
            type:'select[Simple textbox:textbox,Linked field:link,Linked using:linkedUsing,Fixed combobox:combo,Combobox from table:tablecombo,Combobox from query:querycombo,Radio:radio,Checkbox:check,Password:password]',
            tooltip:'Display mode of the field',
            hide_list:{
              'textbox':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_hideEmptyValue',
                'this.advanced_labelEmptyValue',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'link':[
                'this.advanced_linkedFieldName',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_hideEmptyValue',
                'this.advanced_labelEmptyValue',
                'this.advanced_radioOrientation'
              ],
              'linkedUsing':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_zoomQryParam',
                'this.advanced_hideEmptyValue',
                'this.advanced_labelEmptyValue',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'combo':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'tablecombo':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'querycombo':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'radio':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_hideEmptyValue',
                'this.advanced_labelEmptyValue',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'check':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_hideEmptyValue',
                'this.advanced_labelEmptyValue',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ],
              'password':[
                'this.advanced_linkedTable',
                'this.advanced_zoomConfigName',
                'this.advanced_zoomTitle',
                'this.advanced_calculateZoomTitle',
                'this.advanced_keyField',
                'this.advanced_readField',
                'this.advanced_linkedField',
                'this.advanced_fixedFilter',
                'this.advanced_fixedValue',
                'this.advanced_nCriteria',
                'this.advanced_looselyLinked',
                'this.advanced_linkedFieldName',
                'this.advanced_comboValues',
                'this.advanced_comboLabels',
                'this.advanced_tableName',
                'this.advanced_tableKeyField',
                'this.advanced_valueField',
                'this.advanced_orderField',
                'this.advanced_filterField',
                'this.advanced_filterValue',
                'this.advanced_queryName',
                'this.advanced_queryParameters',
                'this.advanced_comboValues1',
                'this.advanced_comboLabels1',
                'this.advanced_maxQueryRow',
                'this.advanced_checkedValue',
                'this.advanced_uncheckedValue',
                'this.advanced_openZoom',
                'this.advanced_zoomQryParam',
                'this.advanced_hideEmptyValue',
                'this.advanced_labelEmptyValue',
                'this.advanced_fillEmptyKeys',
                'this.advanced_suggest',
                'this.advanced_row_suggest',
                'this.advanced_radioOrientation',
                'this.advanced_servlet',
                'this.advanced_sendKeyZoomOnZoom',
              ]
            },
            show_list:{
              'link':['this.advanced_linkedTable','this.advanced_zoomConfigName','this.advanced_zoomTitle','this.advanced_calculateZoomTitle',
              'this.advanced_keyField','this.advanced_readField','this.advanced_linkedField','this.advanced_fixedFilter','this.advanced_fixedValue',
              'this.advanced_nCriteria','this.advanced_looselyLinked','this.advanced_zoomQryParam','this.advanced_fillEmptyKeys','this.advanced_suggest',
              'this.advanced_row_suggest','this.advanced_servlet','this.advanced_sendKeyZoomOnZoom'],
              'linkedUsing':['this.advanced_linkedFieldName','this.advanced_openZoom'],
              'combo':['this.advanced_comboValues','this.advanced_comboLabels','this.advanced_hideEmptyValue', 'this.advanced_labelEmptyValue'],
              'tablecombo':['this.advanced_tableName','this.advanced_tableKeyField','this.advanced_valueField','this.advanced_orderField','this.advanced_filterField',
              'this.advanced_filterValue','this.advanced_hideEmptyValue','this.advanced_labelEmptyValue'],
              'querycombo':['this.advanced_queryName','this.advanced_queryParameters','this.advanced_comboValues1','this.advanced_comboLabels1','this.advanced_maxQueryRow',
              'this.advanced_hideEmptyValue','this.advanced_labelEmptyValue','this.advanced_orderField',],
              'radio':['this.advanced_comboValues','this.advanced_comboLabels','this.advanced_radioOrientation'],
              'check':['this.advanced_checkedValue','this.advanced_uncheckedValue']
            }
          },
          {name:'Linked table', propID:'linkedTable', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Name of the linked table'},
          {name:'zoom config name', propID:'zoomConfigName', type:'str', buttons:'pick,edit,new', actions:'openMask(),editZoom(),newZoom()',
           tooltip:'Name of the zoom configuration', section:'Zoom options'},
          {name:'Zoom title', propID:'zoomTitle', type:'str', tooltip:'Zoom title', section:'Zoom options'},
          {name:'Calculate Zoom title', propID:'calculateZoomTitle', type:'checkbox', tooltip:'If true, the title of the zoom will be calculated', section:'Zoom options'},
          {name:'Zoom on zoom', propID:'servlet', type:'bofield', tooltip:'Within zoom, this programs is called when the zoom button is pressed', section:'Zoom options'},
          {name:'Send key to zoom on zoom', propID:'sendKeyZoomOnZoom', type:'checkbox', section:'Zoom options', tooltip:'Send fixed vars to key fixed fields on Zoom on zoom'},
          {name:'query parameters', propID:'zoomQryParam', type:'str', tooltip:'List, comma separated of the query parameters', buttons:'pick', actions:'openMask()',
           validFunc:'validZoomQryParam', section:'Zoom options'},
          {name:'Key field', propID:'keyField', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Value that is reported in the linked field'},
          {name:'Read field', propID:'readField', type:'str', buttons:'pick', actions:'openMask()', tooltip:'List, comma separated, of the table field to report'},
          {name:'Linked field', propID:'linkedField', type:'str',
           tooltip:'List, comma separated, of the form field \nin which are reported the values of fields \nspecified in Read field properties', validFunc:'validLinkedField'},
          {name:'fixed filter', propID:'fixedFilter', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Name of the fixed filters be passed to zoom', section:'Filter'},
          {name:'fixed value', propID:'fixedValue', type:'str', tooltip:'Value of the fixed filters be passed to zoom', validFunc:'validFixedValue', section:'Filter'},
          {name:'Fill empty keys', propID:'fillEmptyKeys', type:'checkbox',extraClass:'col-3', tooltip:'Fill key fixed fields when empty'},
          {name:'loosely linked', propID:'looselyLinked', type:'checkbox',extraClass:'col-3',
           tooltip: 'When checked linking is used to read additional values and not to check field value'},
          {name:'n. criteria', propID:'nCriteria', type:'int',  validFunc:'IsNumericInput', tooltip:'Number of alternatively used read fields as search criteria'},
          {name:'Linked field name', propID:'linkedFieldName', type:'str',  tooltip:'Linked field name.', buttons: 'pick', actions:'openMask()', validFunc:'validLinkedFieldName'},
          {name:'Suggest', propID:'suggest', type:'checkbox',  tooltip:'Enable the suggester on user input',extraClass:'col-3'},
          {name:'Rows', propID:'row_suggest', type:'int',  tooltip:'Maximum number of rows shown by the suggester',extraClass:'col-3'},
          {name:'Open Zoom', propID:'openZoom', type:'checkbox',  tooltip:'If checked, the button to open the zoom will be displayed'},
          {name:'values', propID:'comboValues', type:'str', tooltip:'List, comma separated, of the options value \navailable in the combobox.', buttons:'pick', actions:'openMask()'},
          {name:'labels', propID:'comboLabels', type:'str', tooltip:'List, comma separated, of the options label \navailable in the combobox.'},
          {name:'table name', propID:'tableName', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Table name'},
          {name:'table key field', propID:'tableKeyField', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Table field that defines the values of the combobox'},
          {name:'value field', propID:'valueField', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Table field that defines the labels of the combobox'},
          {name:'filter field', propID:'filterField', type:'str', buttons:'pick', actions:'openMask()', tooltip:'List, comma separated, of filters in the table'},
          {name:'filter value', propID:'filterValue', type:'str', tooltip:'List, comma separated, of filter values', validFunc:'validFilterValue'},
          {name:'query name', propID:'queryName', type:'str', buttons:'pick,edit,new', actions:'openMask(),editQuery(),newQuery()', tooltip:'Name of query'},
          {name:'query parameters', propID:'queryParameters', type:'str', buttons:'pick', actions:'openMask()', tooltip:'List, comma separated, of the query parameters. \nes: param1=value1,param2=value2'},
          {name:'combo values', propID:'comboValues1', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Name of query column that defines the values of the combobox'},
          {name:'combo labels', propID:'comboLabels1', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Name of query column that defines the values of the combobox'},
          {name:'order by', propID:'orderField', type:'str', buttons:'pick', actions:'openMask()', tooltip:'Field for the order by \'clause\''},
          {name:'max row', propID:'maxQueryRow', type:'int',  validFunc:'IsNumericInput', tooltip:'Max number of options available in the combobox'},
          {name:'hide empty value', propID:'hideEmptyValue', type:'checkbox', tooltip:'if true, the empty option will not be available.'},
          {name:'Label for empty value', propID:'labelEmptyValue', type:'str', tooltip:'Label of the empty value.'},
          {name:'checked value', propID:'checkedValue', type:'str', tooltip:'Value of field when checked'},
          {name:'unchecked value', propID:'uncheckedValue', type:'str', tooltip: 'Value of field when unchecked'},
          {name:'Orientation', propID:'radioOrientation', type:'select[Vertical:vertical,Horizontal:horizontal]', tooltip: 'Radio orientation'}
        ],
        expression:[
          {name:'Edit when',propID:'editUnderCondition',	type:'str', tooltip:'If the condition is true the field will be editable. \n es: field1=\'abc\' and field2<>false \n es: not (field1+field2>=10)'},
          {name:'Hide when',propID:'hideUnderCondition',	type:'str', tooltip:'If the condition is true the field will be hidden. \n es: field1=\'abc\' and field2<>false \n es: not (field1+field2>=10)'},
          {name:'Obligatory condition',propID:'obligatoryCondition',	type:'str', tooltip:'If the condition is true, the field can\'t be empty. \n Attention: if the field is numeric, the value can\'t be 0 \n and if the field is logic, the value can\'t be false', section:'Obligatory'},
          {name:'Obligatory message',propID:'obligatoryMsg',	type:'str', tooltip:'Obligatory message', section:'Obligatory'},
          {name:'Expression',propID:'calculate',	type:'str', tooltip:'Calculate expression', section:'calculate'},
          {name:'Depends on',propID:'dependsOn',	type:'str', buttons:'pick', actions:'openMask()', tooltip:'List, comma separated, of field. The field value is recalculated each time (and only when) one of these field changes its values', validFunc:'validDependsOn', section:'calculate'},
          {name:'Expression', propID:'check', type:'str', tooltip:'Check expression', section:'Check'},
          {name:'Error message', propID:'errorMsg', type:'str', tooltip:'Error message', section:'Check'}
        ],
        button:[
          {name:'Entity type',propID:'entityType', type:'select[Web hyperlink:link,function JS:function,master,detail,master/detail,dialog,routine,page,report,SmartReport:smartreport]',
          tooltip:'Type of called entity',
            hide_list:{'report':['button.action','button.linkButton'],
                       'link':['button.action'],
                       'function':['button.action','button.parameters','button.sendAllParams','button.popup'],
                       'master,detail,master/detail':['button.sendAllParams']
                      },
            show_list:{'link':['button.linkButton','button.parameters','button.sendAllParams','button.popup'],
                       'function':['button.linkButton'],
                       'report':['button.sendAllParams','button.parameters','button.sendAllParams','button.popup'],
                       'master,detail,master/detail':['button.linkButton','button.action','button.parameters','button.popup'],
                       'dialog,routine,page,SmartReport':['button.action','button.linkButton','button.sendAllParams','button.parameters','button.popup']
                      }
          },
          {name:'action', propID:'action', type:'autocomplete[default:new,write,writeload,query,start,delete,deleterow,edit,editload,view,function,function autoexec,function server autoexec,async routine,autozoom,zoom,routine caller]',
           tooltip:'Action to perform on called entity'},
          {name:'Entity name',propID:'linkButton',type:'str',tooltip:'Name of called entity'},
          {name:'Parameter list',propID:'parameters',type:'str',buttons:'pick', actions:'openMask()',tooltip:'List of the parameters separated by &'},
          {name:'Send all params',propID:'sendAllParams',type:'checkbox', tooltip:'If checked, all the parameters will be sent to se entity'},
          {name:'Target',propID:'target',type:'str',tooltip:'Set the target'},
          {name:'Popup',propID:'popup',type:'checkbox', section:'popup', extraClass: 'col-3',tooltip:'Set the popup',
            hide_list:{
              'unchecked':['button.popupStyle','button.linkHeight','button.linkWidth','button.popupScroll']
            },
            show_list:{
              'checked':['button.popupStyle','button.linkHeight','button.linkWidth','button.popupScroll']
            }
          },
          {name:'popup style', propID:'popupStyle', type:'select[by skin,layer,popup]', tooltip:'Popup style', section:'popup', extraClass: 'col-3'},
          {name:'Popup height',propID:'linkHeight',type:'int',extraClass:'col-2', section:'popup',tooltip:'Height of the open window (in px)'},
          {name:'Popup width',propID:'linkWidth',type:'int',extraClass:'col-2', section:'popup',tooltip:'Width of the open window (in px)'},
          {name:'popup scroll', propID:'popupScroll', type:'checkbox', tooltip:'Popup scroll', section:'popup', extraClass: 'col-2'},
          {name:'Tooltip',propID:'titleButton',type:'str', section:'Button style', tooltip:'Tooltip of the button'},
          {name:'Style',propID:'styleButton',type:'select[Zoom style:zoom,Image:custom,Font icon:fontIcon]', section:'Button style', tooltip:'Type of the image',
            hide_list:{
              'zoom':['button.imageButton','button.classButton','button.widthImage','button.heightImage','button.imageFont','button.imageChar','button.imageSize','button.imageColor'],
              'custom':['button.imageFont','button.imageChar','button.imageSize','button.imageColor'],
              'fontIcon':['button.imageButton','button.classButton','button.widthImage','button.heightImage'],
            },
            show_list:{
              'custom':['button.imageButton','button.classButton','button.widthImage','button.heightImage'],
              'fontIcon':['button.imageFont','button.imageChar','button.imageSize','button.imageColor'],
            }
          },
          {name:'Url',propID:'imageButton',type:'str', section:'Button style', tooltip:'URL of the image'},
          {name:'width',propID:'widthImage',type:'int', section:'Button style', tooltip:'Width of the image (in px)', extraClass: 'col-3'},
          {name:'height',propID:'heightImage',type:'int', section:'Button style', tooltip:'Height of the image (in px)', extraClass: 'col-3'},
          {name:'Class CSS',propID:'classButton',type:'str', section:'Button style', tooltip:'CSS class of the button'},
          {name:'font', propID:'imageFont', type:'str',buttons:'pick', actions:'select_font()', section:'Button style', tooltip:'Font family of the Icon Font'},
          {name:'char', propID:'imageChar', type:'str', buttons:'pick', actions:'select_icon()', section:'Button style', tooltip:'Character of the Icon Font'},
          {name:'size', propID:'imageSize', type:'str', section:'Button style', tooltip:'Size of the Icon Font'},
          {name:'color', propID:'imageColor', type:'color', section:'Button style', tooltip:'Color of the icon font'}
        ]
      }
    }


    this.groupObjClass={
      newProperties:{
        generic:[
          {name:'title',propID:'groupName',type:'str', tooltip:'Title of the group', section:'Title'},
          {name:'Calculate title',propID:'calculateLabel',	type:'checkbox', tooltip:'If checked, the label will be calculated', section:'Title'},
          {name:'Collapsed group',propID:'collapsedGroup',	type:'checkbox', tooltip:'If checked, the group is initially collapsed'},
          {name:'Group name',propID:'groupSetName',	type:'str', tooltip:'Elements grouped by name. If specified, the gorups with the same set name will be displayed as tabs'}
        ],
        view:[
          {name:'visibility', propID:'visibility', type:'select[base:base,extended:extMask,hidden in configuration:hiddenInVariant]',
          tooltip:'Visibility of the group. \n Base: the group is visible always \n Extended: the group is visible only in extended mode. \n Hidden in configuration: the group is hidden but you can make it visible from smart editor.'},
          {name:'mode' ,propID:'mode' ,type:'select[1 Vertical mask. Field and label on the same line:1,2 Vertical mask. Label over the field:2,3 Horizontal mask. Label over the field. All in the same row:3]', tooltip:'Display mode of the group', section:'Layout' },
          {name:'columns' ,propID:'columns' ,type:'int', validFunc:'IsNumericInput', tooltip:'Number of columns that divide the group' , section:'Layout'},
          {name:'column width' ,propID:'listColumnWidth' ,type:'str', tooltip:'List, comma separated, of column width (in px or %) for each columns. \n If you specified only one value, the column will be applied for all columns. \n If not specified the values will be in percentage ', section:'Layout' },
          {name:'max label width' ,propID:'maxLabelWidth' ,type:'int', validFunc:'IsNumericInput', tooltip: 'Max width of the label (in px)', section:'Size'},
          // {name:'min label width' ,propID:'minLabelWidth' ,type:'int', validFunc:'IsNumericInput', tooltip:'Min width of the label (in px)' },
          {name:'min label width' ,propID:'listMinLabelWidth' ,type:'str', tooltip:'List, comma separated, of min label width(in px) for each columns. \n If you specified only one value, the min label width will be applied for all columns.', section:'Size' },
          {name:'max field width' ,propID:'maxFieldWidth', type:'int', validFunc:'IsNumericInput', tooltip:'Max width of the field (in px)', section:'Size' }
        ],
        expression:[
          {name:'Hide when',propID:'hideUnderCondition',	type:'str', tooltip:'If the condition is true the group will be hidden. \n es: field1=\'abc\' and field2<>false \n es: not (field1+field2>=10)'},
          {name:'Edit fields when',propID:'editUnderCondition',	type:'str', tooltip:'If the condition is true the fields in the group will be editable. \n es: field1=\'abc\' and field2<>false \n es: not (field1+field2>=10)'}
        ]
      }
    }

    this.calculationObjClass={
      newProperties:{
        generic:[
          {name:'name', propID:'calculationName', type:'str', tooltip:'Calculation name'},
          {name:'calculation routine', propID:'calculationRoutine', type:'str', tooltip:'Name of routine. The fields will be valorised with the values of the routine caller variable'},
          {name:'parameters',propID:'parameters',type:'str',buttons:'pick', actions:'openMask()', tooltip:'List of parameters to send to the routine'},
          {name:'depends on', propID:'dependsOn', type:'str', buttons:'pick', actions:'openMask()', tooltip:'List, comma separated, of field. When the specificated fields change, the routine runs', validFunc:'validDependsOn'},
          {name:'calculate when', propID:'calcUnderCondition', type:'str', tooltip:'If the condition is true, the routine runs'}
        ]
      }
    }

    this.labelObjClass={
      newProperties:{
        generic:[
          {name:'name', propID:'fieldName', type:'str', tooltip:'Label name'},
          {name:'label', propID:'description', type:'str', tooltip:'Label value', section:'Label'},
          {name:'Calculate', propID:'calculateLabel', type:'checkbox', tooltip:'If checked, the label will be calculated', section:'Label'}
        ],
        view:[
          {name:'visibility', propID:'visibility', type:'select[base:base,extended:extMask,hidden in configuration:hiddenInVariant,always hidden:hiddenGroup]',
           tooltip:'Visibility of the label. \n Base: the label is visible always \n Extended: the label is visible only in extended mode. \n Hidden in configuration: the label is hidden but you can make it visible from smart editor. \n Always hidden: the label is always hidden'},
          {name:'Keep on previous row',propID:'keepOnPreviousRow',	type:'checkbox', tooltip:'If checked, the label appears in the same row of the previous field', section:'Style'},
          {name:'Label css Class',propID:'labelCssClass', type:'str', tooltip:'Label Css class', section:'Style'},
          {name:'Label align',propID:'labelAlign', type:'select[default:default,right:right,left:left]', tooltip:'Label align', section:'Style'},
          {name:'Text align',propID:'textAlign', type:'select[right:right,center:center,left:left]', tooltip:'Text align', section:'Style'},
          {name:'Display in report cover', propID:'cover', type:'select[Always:1,Never:2]', tooltip:'If you select "Always" option, the label will be printed in report cover.'}
        ],
        expression:[
          {name:'hide when',propID:'hideUnderCondition', type:'str', tooltip: 'If the condition is true, the label will be hidden'},
        ]
      }
    }

    this.buttonObjClass={
      newProperties:{
        generic:[
          {name:'name', propID:'fieldName', type:'str', tooltip:'Button name'},
          {name:'title', propID:'titleButton', type:'str', tooltip:'Button title'}
        ],
        view:[
          {name:'visibility', propID:'visibility', type:'select[base:base,extended:extMask,hidden in configuration:hiddenInVariant,always hidden:hiddenGroup]',
           tooltip:'Visibility of the button. \n Base: the button is visible always \n Extended: the button is visible only in extended mode. \n Hidden in configuration: the button is hidden but you can make it visible from smart editor. \n Always hidden: the button is always hidden'},
          {name:'Keep on previous row',propID:'keepOnPreviousRow',	type:'checkbox', tooltip:'If checked, the button appears in the same row of the previous field'}
        ],
        functional:[
          {name:'Entity type',propID:'entityType', type:'select[Web hyperlink:link,function JS:function,Confirm action:confirmAction,master,detail,master/detail,dialog,routine,page,report,SmartReport:smartreport]',
            tooltip:'Type of called entity',
            hide_list:{'report':['functional.action','functional.linkButton'],
                       'link':['functional.action'],
                       'function':['functional.action','functional.parameters','functional.sendAllParams'],
                       'master,detail,master/detail':['functional.sendAllParams'],
                       'confirmAction':['functional.action','functional.linkButton','functional.parameters','functional.sendAllParams']
                      },
            show_list:{'link':['functional.linkButton','functional.parameters','functional.sendAllParams'],
                       'function':['functional.linkButton'],
                       'report':['functional.sendAllParams','functional.parameters','functional.sendAllParams'],
                       'master,detail,master/detail':['functional.linkButton','functional.action','functional.parameters'],
                       'dialog,routine,page,SmartReport':['functional.action','functional.linkButton','functional.sendAllParams','functional.parameters']
                      }
            },
          {name:'action', propID:'action',
          type:'autocomplete[default:new,write,writeload,query,start,delete,deleterow,edit,editload,view,function,function autoexec,function server autoexec,async routine,autozoom,zoom,routine caller]',
          tooltip:'Action to perform on called entity'},
          {name:'Entity',propID:'linkButton',type:'str',tooltip:'Name of called entity'},
          {name:'Parameter list',propID:'parameters',type:'str',buttons:'pick', actions:'openMask()',tooltip:'List of the parameters separated by &'},
          {name:'Send all params',propID:'sendAllParams',type:'checkbox', tooltip:'If checked, all the parameters will be sent to the entity'},
          {name:'target', propID:'target', type:'str', tooltip:'target',tooltip:'Set the target'}
        ],
        style:[
          {name:'Popup',propID:'popup',type:'checkbox', section:'popup', extraClass: 'col-3',tooltip:'Set the popup',
            hide_list:{
              'unchecked':['style.popupStyle','style.linkHeight','style.linkWidth','style.popupScroll']
            },
            show_list:{
              'checked':['style.popupStyle','style.linkHeight','style.linkWidth','style.popupScroll']
            }
          },
          {name:'popup style', propID:'popupStyle', type:'select[by skin,layer,popup]', tooltip:'popup style', section:'popup', extraClass: 'col-3'},
          {name:'Popup height',propID:'linkHeight',type:'int',extraClass:'col-2', section:'popup',tooltip:'Height of the open window (in px)'},
          {name:'Popup width',propID:'linkWidth',type:'int',extraClass:'col-2', section:'popup',tooltip:'Width of the open window (in px)'},
          {name:'popup scroll', propID:'popupScroll', type:'checkbox', tooltip:'Popup scroll', section:'popup', extraClass: 'col-2'},
          {name:'Style',propID:'styleButton',type:'select[Zoom style:zoom,Image:custom,Font icon:fontIcon]', section:'Button style', tooltip:'Type of the image',
            hide_list:{
              'zoom':['style.imageButton','style.classButton','style.widthImage','style.heightImage','style.imageFont','style.imageChar','style.imageSize','style.imageColor'],
              'custom':['style.imageFont','style.imageChar','style.imageSize','style.imageColor'],
              'fontIcon':['style.imageButton','style.classButton','style.widthImage','style.heightImage'],
            },
            show_list:{
              'custom':['style.imageButton','style.classButton','style.widthImage','style.heightImage'],
              'fontIcon':['style.imageFont','style.imageChar','style.imageSize','style.imageColor'],
            }
          },
          {name:'Url',propID:'imageButton',type:'str', section:'Button style', tooltip:'URL of the image'},
          {name:'width',propID:'widthImage',type:'int', section:'Button style', tooltip:'Width of the image (in px)', extraClass: 'col-3'},
          {name:'height',propID:'heightImage',type:'int', section:'Button style', tooltip:'Height of the image (in px)', extraClass: 'col-3'},
          {name:'Class CSS',propID:'classButton',type:'str', section:'Button style', tooltip:'CSS class of the button'},
          {name:'font', propID:'imageFont', type:'str', buttons:'pick', actions:'select_font()', section:'Button style', tooltip:'Font family of the Icon Font'},
          {name:'char', propID:'imageChar', type:'str', buttons:'pick', actions:'select_icon()', section:'Button style', tooltip:'Character of the Icon Font'},
          {name:'size', propID:'imageSize', type:'str', section:'Button style', tooltip:'Font size of the Icon Font'},
          {name:'color', propID:'imageColor', type:'color', section:'Button style', tooltip:'Color of the Icon Font'}
        ],
        expression:[
          {name:'edit when',propID:'editUnderCondition', type:'str', tooltip:'If the condition is true the button will be enabled. \n es: field1=\'abc\' and field2<>false \n es: not (field1+field2>=10)'},
          {name:'hide when',propID:'hideUnderCondition', type:'str', tooltip:'If the condition is true the button will be hidden. \n es: field1=\'abc\' and field2<>false \n es: not (field1+field2>=10)'}
        ]
      }
    }

    this.actionObjClass={
      newProperties:{
        generic:[
          {name:'name', propID:'actionName', type:'str', tooltip:'Action name. These actions will be added to the toolbar.'},
          {name:'title', propID:'title', type:'str', tooltip:'Title'},
          {name:'tooltip', propID:'tooltip', type:'str', tooltip:'Tooltip'}
        ],
        functional:[
          {name:'type', propID:'resourceType' , type:'select[,master,detail,master/detail,dialog,routine,page,report,SmartReport:smartreport],',tooltip:'Type of called entity',
            hide_list:{
              'report': ['functional.action','functional.resource'],
              'master,detail,master/detail':['functional.sendAllParams']
            },
            show_list:{
              'master,detail,master/detail':['functional.action','functional.resource'],
              ',dialog,routine,page,SmartReport': ['functional.action','functional.resource','functional.sendAllParams'],
              'report':['functional.sendAllParams']
            }
          },
          {name:'action', propID:'action',
          type:'autocomplete[default:new,write,writeload,query,start,delete,deleterow,edit,editload,view,function,function autoexec,function server autoexec,async routine,autozoom,zoom,routine caller]',
          tooltip:'Action to perform on called entity'},
          {name:'resource', propID:'resource', type:'str', tooltip:'Name of resource entity'},
          {name:'parameters', propID:'parameters', type:'str', tooltip:'parameters'},
          {name:'Send all params', propID:'sendAllParams', type:'checkbox', tooltip:'If checked, all the parameters will be sent to the resocurce'},
          {name:'target', propID:'target', type:'str', tooltip:'Set the target'},
          {name:'Progress bar', propID:'progressBar', type:'checkbox', tooltip:'Progress Bar'}
        ],
        style:[
          {name:'popup', propID:'popup', type:'checkbox', tooltip:'popup', section:'popup', extraClass: 'col-3',
            hide_list:{
              'unchecked':['style.popupStyle','style.popupHeight','style.popupWidth','style.popupScroll']
            },
            show_list:{
              'checked':['style.popupStyle','style.popupHeight','style.popupWidth','style.popupScroll']
            }
          },
          {name:'popup style', propID:'popupStyle', type:'select[by skin,layer,popup]', tooltip:'popup style', section:'popup', extraClass: 'col-3'},
          {name:'popup height', propID:'popupHeight', type:'str', tooltip:'Height of the open window (in px)', section:'popup', extraClass: 'col-2'},
          {name:'popup width', propID:'popupWidth', type:'str', tooltip:'Width of the open window (in px)', section:'popup', extraClass: 'col-2'},
          {name:'popup scroll', propID:'popupScroll', type:'checkbox', tooltip:'Popup scroll', section:'popup', extraClass: 'col-2'},
          {name:'image settings', propID:'imageSettings', type:'select[Default:default,Font icon:fontIcon]', section:'Image', tooltip:'Type of the image',
            hide_list:{
              'default':['this.style_imageFont','this.style_imageChar','this.style_imageSize','this.style_imageColor'],
              'fontIcon':['this.style_imageUrl']
            },
            show_list:{
              'default':['this.style_imageUrl'],
              'fontIcon':['this.style_imageFont','this.style_imageChar','this.style_imageSize','this.style_imageColor']
            }
          },
          {name:'url', propID:'imageUrl', type:'str', tooltip:'URL of the image', section:'Image'},
          {name:'font', propID:'imageFont', type:'str', tooltip:'Font family of the Icon Font', buttons:'pick', actions:'select_font()', section:'Image'},
          {name:'char', propID:'imageChar', type:'str', tooltip:'Character of the Icon Font', buttons:'pick', actions:'select_icon()', section:'Image'},
          {name:'size', propID:'imageSize', type:'str', tooltip:'Font size of the Icon Font', section:'Image'},
          {name:'color', propID:'imageColor', type:'color', tooltip:'Color of the Icon Font', section:'Image'}
        ]
      }
    }

    // OGGETTI-------------------------------------

    this.formObj=function(obj) {
      this.objClass = ZTObjects.formObjClass
      this.name='maskparameters';
      this.id='maskparameters';
      this.customVdm=obj.customVdm;
      for (var i=0; i<formProperties.length; i++){
        if (formProperties[i]=='descriptionMask')
          this.description=obj.descriptionMask?obj.descriptionMask:''
        else if (formProperties[i]=='listMinLabelWidth' || formProperties[i]=='listColumnWidth'){
          this[formProperties[i]]=''
          if (obj[formProperties[i]]){
            var sep=''
            for (var j=0; j<obj[formProperties[i]].length; j++){
              this[formProperties[i]]+=sep+obj[formProperties[i]][j]
              sep=','
            }
          }
          if (formProperties[i]=='listMinLabelWidth' && (Empty(this.listMinLabelWidth) || this.listMinLabelWidth=='0')){
            this.listMinLabelWidth=''+(obj.minLabelWidth||0)
          }
        }
        else
          this[formProperties[i]]=(obj[formProperties[i]]?obj[formProperties[i]]:'');
      }
      this.user_group=obj.user_group||'';
      this.user=obj.user||'';
      this.group=obj.group||'';
      this.configName=obj.configName||'';
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

    this.fieldObj=function(obj) {
      this.objClass = ZTObjects.fieldObjClass
      this.name=obj.realFieldName||obj.fieldName;
      this.id=obj.realFieldName||obj.fieldName;
      this.realFieldName=this.id;
      this.index=obj.index;
      this.type='field'
      this.visibility=obj.visibility;
      for (var i=0; i<fieldProperties.length; i++){
        if (fieldProperties[i]=='viewType' && obj[fieldProperties[i]]==''){
          this[fieldProperties[i]]='textbox'
        }
        else if (fieldProperties[i]=='description'){
          this.label=(obj[fieldProperties[i]]?obj[fieldProperties[i]]:'')
        }
        else if (fieldProperties[i]=='fixedFilter' || fieldProperties[i]=='fixedValue'){
          this[fieldProperties[i]]=''
          if (obj[fieldProperties[i]]){
            var sep=''
            for (var j=0; j<obj[fieldProperties[i]].length; j++){
              this[fieldProperties[i]]+=sep+obj[fieldProperties[i]][j]
              sep=','
            }
          }
        }
        else if (fieldProperties[i]=='comboValues' || fieldProperties[i]=='comboLabels'){
          this[fieldProperties[i]]=(obj[fieldProperties[i]]?obj[fieldProperties[i]]:'');
          this[fieldProperties[i]+'1']=(obj[fieldProperties[i]]?obj[fieldProperties[i]]:'');
        }
        else if (fieldProperties[i]=='isFilter'){
          if (obj[fieldProperties[i]])
            this.typeFilter='Query parameter'
          else this.typeFilter='No filter'
        }
        else if (fieldProperties[i]=='queryFilter'){
          if (obj[fieldProperties[i]]){
            if (obj.isFilter)
              this.typeFilter='Query parameter'
            else this.typeFilter='No filter'
          }
          else {
            if (obj.isFilter)
              this.typeFilter='Zoom filter'
            else this.typeFilter='No filter'
          }
        }
        else if (fieldProperties[i]=='type'){
          this.objType=obj.type;
        }
        else if (fieldProperties[i]=='linkedTable' && obj.linkedTable && obj.linkedTable.indexOf('.')!=-1){
          var table=obj.linkedTable.split('.');
          this.linkedTable=table[0];
          this.zoomConfigName=table[1];
        }
        else if (fieldProperties[i]=='zoomConfigName'){
          this.zoomConfigName=this.zoomConfigName||obj.zoomConfigName;
        }
        else
          this[fieldProperties[i]]=(obj[fieldProperties[i]]?obj[fieldProperties[i]]:'');
      }
      if (Empty(this.initialOperation))
        this.initialOperation='=';
    }

    this.groupObj=function(obj) {
      this.objClass = ZTObjects.groupObjClass;
      this.name=obj.groupName;
      this.id=obj.groupName;
      this.groupName=obj.groupName;
      this.type='group';
      this.index=obj.index;
      for (var i=0; i<groupProperties.length; i++){
        if (groupProperties[i]=='listMinLabelWidth' || groupProperties[i]=='listColumnWidth'){
          this[groupProperties[i]]=''
          if (obj[groupProperties[i]]){
            var sep=''
            for (var j=0; j<obj[groupProperties[i]].length; j++){
              this[groupProperties[i]]+=sep+obj[groupProperties[i]][j]
              sep=','
            }
          }
        }
        else
          this[groupProperties[i]]=(obj[groupProperties[i]]?obj[groupProperties[i]]:'');
      }
    }
    this.calculationObj=function(obj){
      this.objClass=ZTObjects.calculationObjClass;
      this.name=obj.calculationName;
      this.id=obj.calculationRoutine;
      this.type='calculation';
      this.index=obj.index;
      for (var i=0; i<calculationProperties.length; i++){
        this[calculationProperties[i]]=obj[calculationProperties[i]]||'';
      }
    }

    this.labelObj=function(obj){
      this.objClass=ZTObjects.labelObjClass;
      this.name=obj.fieldName;
      this.id=obj.fieldName;
      // this.label=obj.labelValue;
      this.type='label';
      this.index=obj.index;
      this.itemType="label"
      this.visibility=obj.visibility;
      for (var i=0; i<labelProperties.length; i++){
        this[labelProperties[i]]=obj[labelProperties[i]]||'';
      }
    }

    this.buttonObj=function(obj){
      this.objClass=ZTObjects.buttonObjClass;
      this.name=obj.fieldName;
      this.id=obj.fieldName;
      this.type='button';
      this.index=obj.index;
      this.itemType="button";
      this.visibility=obj.visibility;
      for (var i=0; i<buttonProperties.length; i++){
        this[buttonProperties[i]]=obj[buttonProperties[i]]||'';
      }
    }
    this.actionObj=function(obj){
      this.objClass=ZTObjects.actionObjClass;
      this.name=obj.actionName;
      this.id=obj.actionName;
      this.type='action';
      this.index=obj.index;
      for (var i=0; i<actionProperties.length; i++){
        this[actionProperties[i]]=obj[actionProperties[i]]||'';
      }
    }
  }
}
