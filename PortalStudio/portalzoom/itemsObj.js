/*global disablePresetParam hideFiltersBtn editableBySmartEditor*/

/* exported
    index m_bUpdated formProp itemsHTML last_index
  */
 var index = null; // indice corrente del mainitem  nell'Array
var itemsHTML = new Array()   //array contenente tutti gli oggetti item  con id ,HTML,shadow,ecc
var m_bUpdated = false;
var formProp = null;
var last_index;

if(typeof(ZTObjects)=='undefined'){
  var ZTObjects=new function(){
    this.formObjClass={
      newProperties:{
        Generic:[
          {name:'Configuration name' ,propID:'name' ,type:'str', noteditable:true, tooltip:'To change configuration name select save as from menu' },
          {name:'table' ,propID:'table' ,type:'str', noteditable:true, tooltip:'Table name is not editable'},
          {name:'Description',propID:'description',type:'str', tooltip:'Zoom description'},
          {name:'Caption',propID:'Caption',type:'str', tooltip:'Define zoom title, visible on the top of the page.'},
          {name:'query file' ,propID:'query' ,type:'str', buttons:"PickBO", actions:"SelectBO()" , tooltip:'Select query or BO of this zoom'},
          {name:'allowed query', propID:'allowedqueries', type:'querylist', list:"true",
          tooltip: "Lists of allowed queries for this zoom separated by commas or how they should start with using \"*\" (Es: myquery*).<br>if empty only query file is allowed."},
          {name:'Rows for each page', propID:'GridRows', type:'str',validFunc:'EmptyOrIsNaturalInput', tooltip: 'Number of rows for each block of loading data. With infinite scroll mode the value will be at least 100.'},
          {name:'count all rows at zoom startup', propID:'CountRows', type:'checkbox', tooltip:'select to know the number of pages at zoom startup, otherwise the user cannot go to the last page directly'},
          {name:'Parameters mask', propID:'vdmfile', type:'vdmdef'},
          {name:'Param mask width', propID:'vdmWidth', type:'int', extraClass: 'col-3'},
          {name:'Param mask height', propID:'vdmHeight', type:'int', extraClass: 'col-3'},
          {
            name: 'Print mode', propID: 'PrintMode', type: 'select[Auto,None,SmartReport]', tooltip: "Auto: prints all records and every column applying user's sort(s) and filter(s) criteria. Resulting document may contains data outside margins.<br>None: zoom can't be printed.<br>Report: Use specific report configuration.",
            hide_list: {
              'None': ['this.Generic_ReportName', 'this.Generic_print_option', 'this.Generic_print_title', 'this.Generic_print_hideexport', 'this.Generic_print_hidesettings', 'this.Generic_print_size', 'this.Generic_print_totals'],
              'Auto': ['this.Generic_ReportName'],
              'SmartReport': []
            },
            show_list: {
              'SmartReport': ['this.Generic_ReportName', 'this.Generic_print_option', 'this.Generic_print_title', 'this.Generic_print_hideexport', 'this.Generic_print_hidesettings', 'this.Generic_print_size', 'this.Generic_print_totals'],
              'Auto': ['this.Generic_print_option', 'this.Generic_print_title', 'this.Generic_print_hideexport', 'this.Generic_print_hidesettings', 'this.Generic_print_size', 'this.Generic_print_totals'],
              'None': []
            },
            section: 'print'
          },
          {name:'Report name', propID:'ReportName', type:'str', tooltip:'Report configuration used for print action.',
           buttons:"pick,edit,new", actions:"SelectReport(),EditReport(),NewReport()",
           section:'print'
          },
          {name:'columns width', propID:'print_size', type:'select[default,columns grid width:grid]', section: 'print', tooltip:'default: the width of the column is sized according to the length of the field<br>columns\' grid width: the width of the column is sized according to the referred in grid'},
          {name:'output format', propID:'print_outputf', type:'select[default,PDF,HTML,CSV,CSV Std:CSVS,SDF:CSV2,XML,Struct.XML:XMLS,XLS,XLSX]', section: 'print', tooltip:'Select a fixed output format for the print', extraClass: 'col-3'},
          {name:'maximized print', propID:'print_max', type:'checkbox', section: 'print', tooltip:'Select for maximed layer', extraClass: 'col-3'},
          {name:'print option', propID:'print_option', type:'select[default,preview,print]', section: 'print', tooltip:'default: Enable preview and print mode.<br>preview: Enable only preview mode.<br>print: Enable only priny mode.'},
          {name:'print title', propID:'print_title', type:'str', section: 'print', tooltip:'Specifies the title'},
          {name:'print totals', propID:'print_totals', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Print totals in default model'},
          {name:'print as group repeated', propID:'print_grep', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'If checked, print as group repeated'},
          {name:'hide export options', propID:'print_hideexport', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Hide mail and download options'},
          {name:'hide settings options', propID:'print_hidesettings', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Hides the option for changing settings'}
        ],
        ViewOptions:[
          {name:'default view mode', propID:'defaultViewMode', section:'style', type:'select[grid,card,chart]', tooltip:'Set the default view mode: Grid (a row for each record), Card (a card for each record), Chart (view data into a chart)',
            hide_list:{'grid,chart':['this.ViewOptions_css_class_card_container']},
            show_list:{'card':['this.ViewOptions_css_class_card_container']}
          },
          {name:'css file', propID:'css', type:'str',section:'style', tooltip:'Select a css file to include in this PortalZoom configuration.'},
          {name:'Class for zoom',propID:'css_class',type:'css_class',section:'style',tooltip:'Select a css class from the skin the default is grid'},
          {name:'Class for card container',propID:'css_class_card_container',type:'css_class',section:'style',tooltip:'Select a css class from the skin for the container of each card (only Card mode)'},
          {name:'inner (px)', propID:'paddingCard', type:'int', extraClass: 'col-3', section: 'space of each card', tooltip:'Set the space (padding) into each card (only Card mode)'},
          {name:'outer (px)', propID:'marginCard', type:'int', extraClass: 'col-3', section: 'space of each card', tooltip:'Set the space (margin) into each card (only Card mode)'},
          {name:'enable filters',propID:'filters',type:'checkbox', section:'Filters options', extraClass: 'col-3',tooltip:'Enable user filters into the zoom'},
          {name:'Hide filters button',propID:'hideFiltersBtn',type:'checkbox', section:'Filters options', extraClass: 'col-3', tooltip: 'Check to hide filters advanced mask button'},
          {name:'Open filters configuration before query',propID:'openVdmBeforeQuery',type:'checkbox', section:'Filters options', tooltip:'Check to open filters advanced mask before first query'},
          {name:'Apply advanced filter',propID:'applyAdvancedFilter',type:'checkbox', section:'Filters options', extraClass: 'col-3', tooltip:'Check to apply advanced filters before first query'},
          {name:'Disable preset parameters',propID:'disablePresetParam',type:'checkbox', section:'Filters options', extraClass: 'col-3', tooltip:'Check to disable parameters modify assigned from URL'},
          {name:'show zoom header',propID:'header',type:'select[Titled by skin:true,Small zoom with actions:toolbar,Small zoom:false]', tooltip:'Set the header mode: Titled by skin (include skin-decoration, if present) or without skin decoration, with toolbar of action or none'},
          {name:'Tile Starting',propID:'TotalsStarting',type:'select[left,right]', extraClass: 'col-3', tooltip:'Select alignment of total tiles'},
          {name:'View Totals',propID:'TotalsPosition', extraClass: 'col-3', type:'select[grid,bottom-tile,top-tile,hidden]', tooltip:'Select position of totals (if presents): on the bottom of the grid or as tiles',
            hide_list:{'grid,hidden':['this.ViewOptions_TotalsStarting']},
            show_list:{'bottom-tile,top-tile':['this.ViewOptions_TotalsStarting']}
          }
        ],
        GridOptions:[
          {name:'show grid titles',propID:'titles',type:'select[no:false,all:true,only in secondary bar:extra]', tooltip:'Set the visibility of column titles'},
          {name:'show empty rows',propID:'emptyrows',type:'checkbox', extraClass: 'col-3', tooltip:'Check to see all empty rows (defined by Generic Rows property)'},
          {name:'show record mark',propID:'recordmark',type:'checkbox', extraClass: 'col-3', tooltip:'Check to see the record mark on the left of the grid'},
          {name:'View checkbox', propID:'activateCheckbox',type:'select[false,true,Select All:true-selectAll,Select All of Page:true-selectAllOfPage]', extraClass: 'col-3', tooltip:'Check to activate checkbox of selection of rows'},
          {name:'Portlet In Row',propID:'portlet_in_row',type:'portlet',extraClass: 'col-6',tooltip:"Specifies a portlet that replaces the Splinker toolbar (expanding-row) to customize it.<br>It's possible to send Fields value as parameter like this way:<br>"
          +"example_portlet.jsp?Field1_param=%Field_name%.."},
          {name:'In-row opened', propID:'start_in_row',type:'checkbox', extraClass: 'col-3',tooltip: 'First row with \"in-row\" toolbar starts opened.'},
          {name:'Infinite scroll',propID:'infiniteScroll',type:'checkbox',extraClass: 'col-3',tooltip:"Actives the scroll infinite"},
          {name:'Row preview src',propID:'row_preview_src',type:'portlet',extraClass: 'col-6',tooltip:"Specifies the src (portlet,pagelet,jsp..) that shows the row preview, the zoom must have a tpl with a static resource called 'zoom_preview'."},
          {name:'Group repeated',propID:'group_repeated',type:'checkbox', tooltip:'Group all contiguous repeating fields and display only the first, subsequent repeating fields will be left blank'}
        ],
        ChartOptions:[
          {name:'min height', propID:'chartminH', type:'int', section:'size', extraClass: 'col-3', tooltip:'Set min height of chart'},
          {name:'max height', propID:'chartmaxH', type:'int', section:'size', extraClass: 'col-3', tooltip:'Set max height of chart'},
          {name:'compress chart space', propID:'compactChart', type:'select[default:none,compact to left side:left,compact to right side:right]', defaultValue:"none", section:'size', tooltip:"Collapse chart space left or right, by default the chart takes up all the space"},
          {name:'chart def', propID:'chartDef', type:'chartdef', validFunc:'checkChartDef', section:'configuration', tooltip:"Set chart definition"},
          {name:'chart type', propID:'chart_type',type:'select[Category chart:category,XYZ chart:xyz,Measure chart:measure,Geographic chart:geo]', defaultValue:'category',
            hide_list:{
              'category':['this.ChartOptions_x_field','this.ChartOptions_y_field','this.ChartOptions_z_field','this.ChartOptions_xyz_series_field','this.ChartOptions_min_field','this.ChartOptions_max_field','this.ChartOptions_val_field','this.ChartOptions_measure_series_field','this.ChartOptions_xKey_field','this.ChartOptions_measureKey_series_field','this.ChartOptions_geo_0_field','this.ChartOptions_geo_1_field','this.ChartOptions_geo_level','this.ChartOptions_geo_value_field','this.ChartOptions_geo_dom_field','this.ChartOptions_geo_view'],
              'xyz':['this.ChartOptions_labelField','this.ChartOptions_valueFields','this.ChartOptions_label_series','this.ChartOptions_min_field','this.ChartOptions_max_field','this.ChartOptions_val_field','this.ChartOptions_measure_series_field','this.ChartOptions_labelKey_field','this.ChartOptions_measureKey_series_field','this.ChartOptions_geo_0_field','this.ChartOptions_geo_1_field','this.ChartOptions_geo_level','this.ChartOptions_geo_value_field','this.ChartOptions_geo_dom_field','this.ChartOptions_geo_view'],
              'measure':['this.ChartOptions_labelField','this.ChartOptions_valueFields','this.ChartOptions_label_series','this.ChartOptions_x_field','this.ChartOptions_y_field','this.ChartOptions_z_field','this.ChartOptions_xyz_series_field','this.ChartOptions_labelKey_field','this.ChartOptions_xKey_field','this.ChartOptions_geo_0_field','this.ChartOptions_geo_1_field','this.ChartOptions_geo_level','this.ChartOptions_geo_value_field','this.ChartOptions_geo_dom_field','this.ChartOptions_geo_view'],
              'geo':['this.ChartOptions_x_field','this.ChartOptions_y_field','this.ChartOptions_z_field','this.ChartOptions_xyz_series_field','this.ChartOptions_min_field','this.ChartOptions_max_field','this.ChartOptions_val_field','this.ChartOptions_measure_series_field','this.ChartOptions_xKey_field','this.ChartOptions_measureKey_series_field','this.ChartOptions_labelField','this.ChartOptions_valueFields','this.ChartOptions_label_series','this.ChartOptions_labelKey_field']
            },
            show_list:{
              'category':['this.ChartOptions_labelField','this.ChartOptions_valueFields','this.ChartOptions_label_series','this.ChartOptions_labelKey_field'],
              'xyz':['this.ChartOptions_x_field','this.ChartOptions_y_field','this.ChartOptions_z_field','this.ChartOptions_xyz_series_field','this.ChartOptions_xKey_field'],
              'measure':['this.ChartOptions_min_field','this.ChartOptions_max_field','this.ChartOptions_val_field','this.ChartOptions_measure_series_field','this.ChartOptions_measureKey_series_field'],
              'geo':['ChartOptions.geo_0_field', 'ChartOptions.geo_1_field', 'ChartOptions.geo_value_field', 'ChartOptions.geo_dom_field', 'ChartOptions.geo_view', 'ChartOptions.geo_level', 'ChartOptions.geo_level_2', 'ChartOptions.geo_level_3'
                , 'ChartOptions.geo_view_select', 'ChartOptions.geo_onlydata', 'ChartOptions.markers_desc', 'ChartOptions.markers_lat', 'ChartOptions.markers_lng', 'ChartOptions.markers_key', 'ChartOptions.markers_type']
            }
            , tooltip:"Allows you to choose the chart type inserted from among those listed"
            , validFunc:'checkChartType'
            , section:'configuration'
            , disabled: true
          },
          {name:'domain field', propID:'labelField', type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will be placed as chart's domain", section: "configuration"},
          {name:'key field for domain', propID:'labelKey_field', type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that contains keys for domain's each value (like primary key)", section: "configuration"},
          {name:'series fields', propID:'valueFields', type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the fields that will be placed as chart's series", section: "configuration"},
          {name:'labels for series fields', propID:'label_series', type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the value field labels to be displayed in the legend", defaultValue:"", section: "configuration"},
          {name:'minimum values field', propID:'min_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will contain the minimum value for each data-interval evaluation", section: "configuration"},
          {name:'maximum values field', propID:'max_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will contain the maximum value for each data-interval evaluation", section: "configuration"},
          {name:'X axis field', propID:'x_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will be placed as chart's domain", section: "configuration"},
          {name:'Y axis field', propID:'y_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will be setted as the Y axis dimension", section: "configuration"},
          {name:'Z axis field (radius for Bubble Chart)', propID:'z_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will be represented as the Z (3rd) axis dimension", section: "configuration"},
          {name:'series field', propID:'xyz_series_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will be placed as chart's series", section: "configuration"},
          {name:'key field for series', propID:'xKey_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that contains keys for series' each value (like primary key)", section: "configuration"},
          {name:'value numeric field', propID:'val_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will contain data value", section: "values", disabled: true},
          {name:'category field', propID:'measure_series_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', tooltip:"Indicates the field that will be placed as chart's domain serie", section: "domain-category", disabled: true},
          {name:'category key field', propID:'measureKey_series_field',  type:'str', buttons:'edit', actions:'LoadChartFieldsConfigurator(this)', section: "domain-category", disabled: true, tooltip: "Key field if the category field contains duplicates"},
          { name: 'view', propID: 'geo_view_select', type: 'select[world:0,world with Antartic:1,continent:2,country:3]', tooltip: "It represent chart's start view", section: "map settings",
            hide_list: {
              '0': ['ChartOptions.geo_level_2', 'ChartOptions.geo_level_3'],
              '1': ['ChartOptions.geo_level_2', 'ChartOptions.geo_level_3'],
              '2': ['ChartOptions.geo_level', 'ChartOptions.geo_level_3'],
              '3': ['ChartOptions.geo_level', 'ChartOptions.geo_level_2']
            },
            show_list: {
              '0': ['ChartOptions.geo_level'],
              '1': ['ChartOptions.geo_level'],
              '2': ['ChartOptions.geo_level_2'],
              '3': ['ChartOptions.geo_level_3']
            }
          },
          { name: 'view subdivision level', propID: 'geo_level', type: 'select[continents:con,country:0]', tooltip: "Choose subdivision view on map", section: "map settings" },
          { name: 'view subdivision level', propID: 'geo_level_2', type: 'select[continents:con,country:0,country-1st adm.sub.:1]', tooltip: "Choose subdivision view on map", section: "map settings" },
          { name: 'view subdivision level', propID: 'geo_level_3', type: 'select[country:0,country-1st:1,country-2nd:2,country-3rd:3,country-local:loc]', tooltip: "Choose subdivision view on map<br>For IT country: 0 - stato, 1 - regioni, 2 - province, 3 - comuni, locale - area (nord/centro/sud)", section: "map settings" },
          { name: 'main geo-path view', propID: 'geo_view', type: 'str', tooltip: "It represents an initial view path (comma delimited) specified with ISO 3166 alpha-2 codes (eg. EU or EU,IT or IT,52)", section: "map settings", extraClass: "col-3" },
          { name: 'draw only data elements', propID: 'geo_onlydata', type: 'checkbox', tooltip: "Draws only the geo-elements found in the dataset", defaultValue: true, section: "map settings", extraClass: "col-3" },
          { name: 'main field', propID: 'geo_0_field', type: 'str', buttons: '', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field indicates the main geographic area to be represent, consistent with map view (eg. IT, US, Great Britain, Spain)", section: "geographic fields and values" },
          { name: 'subdivision field', propID: 'geo_1_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field indicates the main geographic area subdivision to be represent, consistent with map view (eg. for Italy, '55' represent Lombardia - 'LO' represent province of Lodi - 'F205' represent Milan)", section: "geographic fields and values" },
          { name: 'value numeric field', propID: 'geo_value_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field contains the numeric value to be represented", section: "geographic fields and values" },
          { name: 'grouping series field', propID: 'geo_dom_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field is optional; if specified, will be placed as chart's series", section: "geographic fields and values" }
        ],
        LinkOptions:[
          {name:'Entity name',propID:'Autozoom',type:'str',buttons:"PickBO", actions:"SelectBO({hideLinkedTables:true})", tooltip: 'Set the name of the entity for new/view/edit/delete actions'},
          {name:'Keys for link and editable fields',propID:'PKFields',type:'str',buttons:"pick", actions:"SelectPKFields()",tooltip:'Set the list (comma separated) of fields of the primary key'},
          {name:'Entity type',propID:'entityType',type:'select[master,detail,master/detail,dialog]',tooltip:'Set the type of the entity'},
          {name:'Show Update Button', propID:'show_btn_update', type:'checkbox',tooltip:'User can save modified fields'},
          {name:'Show Delete Button', propID:'show_btn_delete', type:'checkbox',tooltip:'User can delete selected records'},
          {name:'Message of BO saved',propID:'BOSavedOkMsg',type:'str',tooltip:'Compile to change default saved BO message'},
          {name:'Message of delete BO confirm',propID:'confirmBODeleteMsg',type:'str',tooltip:'Compile to change default delete BO message'},
          {name:'Popup', propID:'Popup', type:'checkbox',tooltip:'Define popup default link'},
          {name:'ToolsPosition', propID:'toolsPosition', type:'select[,left,right,left-layer,right-layer,expanding-row,swipe]', tooltip:'Select links position, in mobile mode only layer mode is enable'},
          {name:'Message of delete confirm',propID:'delMessage',type:'str',tooltip:'Compile to change default delete message'},
          {name:'show button to load new record',propID:'LinkAdd',type:'select[Always:force,By security:true,Never:false]',tooltip:'Set the visibility of new action',
          hide_list:{'false':['this.LinkOptions_LinkAddExposed']},
          show_list:{'force':['this.LinkOptions_LinkAddExposed'],'true':['this.LinkOptions_LinkAddExposed']}},
          {name:'action for new record button',propID:'newAction',type:'str',tooltip:'Set a page that substitute the new action'},
          {name:'expose new button on linkzoom menu',propID:'LinkAddExposed',type:'checkbox', tooltip:'Expose new button on context menu near to link zoom.'},
          {name:'show button to view current record',propID:'LinkAccess',type:'select[Always:force,By security:true,Never:false]',tooltip:'Set the visibility of access action',
          hide_list:{'false':['this.LinkOptions_LinkAccessExposed']},
          show_list:{'force':['this.LinkOptions_LinkAccessExposed'],'true':['this.LinkOptions_LinkAccessExposed']}},
          {name:'expose view button on linkzoom menu',propID:'LinkAccessExposed',type:'checkbox', tooltip:'Expose view button on context menu near to link zoom only if the field is filled.'},
          {name:'show button to edit current record',propID:'LinkEdit',type:'select[Always:force,By security:true,Never:false]',tooltip:'Set the visibility of edit action'},
          {name:'show button to delete current record',propID:'LinkDelete',type:'select[Always:force,By security:true,Never:false]',tooltip:'Set the visibility of delete action'},
          {name:'show button to go to query mode',propID:'LinkQuery',type:'select[Always:force,Default:true,Never:false]',tooltip:'Set the visibility of query action',}
        ],
        Customization:[
          {name:'Save in custom dir', propID:'custom', type:'checkbox', tooltip:'Check to save the zoom into custom directory'},
          {name:'zoom for user or group', propID:'user_group', type: 'select[,User,Group]', tooltip: "Specify if chart is custom for user or group",
            hide_list:{'':['this.Customization_user','this.Customization_group'],'User':['this.Customization_group'],'Group':['this.Customization_user']},
            show_list:{'User':['this.Customization_user'],'Group':['this.Customization_group']}
          },
          {name:'Group',propID:'group',type:'str',validFunc:'IsNumericInput', tooltip: "Indicates group code"},
          {name:'User',propID:'user',type:'str',validFunc:'IsNumericInput', tooltip: "Indicates user code"},
          {name:'editable by smart editor ', propID:'editableBySmartEditor', type:'checkbox', tooltip:'Check to enable zoom edit into smart editor for all logged users'}
        ]
      }
    }

    this.actionObjClass={
      newProperties:{
        generic:[
           {name:'name',propID:'actionName',type:'str', tooltip:'Name of the action'},
           {name:'title',propID:'title',type:'str', tooltip:'Description of the action'},
           {name:'tooltip',propID:'tooltip',type:'str', tooltip:'Tooltip of the action'},
           {name:'confirm message',propID:'confirmMessage',type:'str', tooltip:'Confirm message before activate action'},
           {name:'entity Type',propID:'entityType', type:'select[hyperlink,routine,function]', tooltip:'Type of the entity',
            hide_list:{
              'hyperlink':['this.generic_parameter','this.generic_sendMemCurs','this.generic_memCursParam','this.generic_checkAllParam','this.generic_queryFilterParam','this.generic_doQryAfterRoutine','this.generic_progressBar','this.generic_progressBarPortlet'],
              'function':['this.generic_parameter','this.generic_sendMemCurs','this.generic_memCursParam','this.generic_checkAllParam','this.generic_queryFilterParam','this.generic_progressBar','this.generic_progressBarPortlet','this.generic_target']},
            show_list:{
              'function':['this.generic_doQryAfterRoutine'],
              'routine':['this.generic_parameter','this.generic_sendMemCurs','this.generic_memCursParam','this.generic_checkAllParam','this.generic_queryFilterParam','this.generic_doQryAfterRoutine','this.generic_progressBar','this.generic_progressBarPortlet','this.generic_target'],
              'hyperlink':['this.generic_target']}},
           {name:'entity',propID:'url',type:'str', tooltip:'Entity url'},
           {name:'target',propID:'target',type:'str', tooltip:'Target of link'},
           {name:'parameter', propID:'parameter', type:'str', tooltip:'List of parameters (comma separated)'},
           {name:'Send memory cursor', propID:'sendMemCurs', type:'checkbox', tooltip:'Send memory cursor of the grid (only with checkbox activated) to the resource called'},
           {name:'Memory cursor parameter name', propID:'memCursParam', type:'str', tooltip:'Name of the parameter of the resource to send the memory cursor (default name: memorycursor)'},
           {name:'Check all parameter name', propID:'checkAllParam', type:'str', tooltip:'Name of the parameter of the resource to send the check-all value (default name: checkAll)'},
           {name:'Query filter parameter name', propID:'queryFilterParam', type:'str', tooltip:'Name of the parameter of the resource to send the list of (default name: queryFilter)'},
           {name:'Execute query after routine', propID:'doQryAfterRoutine', type:'checkbox',tooltip:'Check to refresh data after routine execution'},
           {name:'Progress bar', propID:'progressBar', type:'checkbox', tooltip:'Check to activate progress bar (async routine mode)',
            hide_list:{'unchecked':['this.generic_progressBarPortlet']},
            show_list:{'checked':['this.generic_progressBarPortlet']}
           },
           {name:'Progress bar portlet', propID:'progressBarPortlet', type:'str', buttons:'edit,pick', actions:'editPortlet(),selectPortlet()', tooltip:'Url of custom portlet to view while routine execution'}
        ],
        view:[
          {name:'visibility',propID:'visibility',type:'select[default,in row:row,none]', tooltip:'Visibility of the action',
            hide_list:{'row':['this.view_important'],'none':['this.view_important','this.view_hideWhen','this.view_toExpose']},
            show_list:{'default':['this.view_important','this.view_hideWhen','this.view_toExpose'],'row':['this.view_important','this.view_hideWhen','this.view_toExpose']}
          },
          {name:'expose on linkzoom menu',propID:'toExpose',type:'checkbox', tooltip:'Check to expose this action on all links that use this configuration.'},
          {name:'important',propID:'important',type:'checkbox', tooltip:'Check to define action as important (not important isn\'t visible on reduced zoom)'},
          {name:'hide when',propID:'hideWhen',type:'str', tooltip:'Hide action when. The expression is evaluated only for row actions'},
          {name:'show in hamburger menu',propID:'showInMenu',type:'checkbox'}
        ],
        style:[
          {name:'image settings', propID:'image_settings', type:'select[Default:default,Font icon:fontIcon]', tooltip:'image type (url or font icon)', section:'image',
            hide_list:{
              'default':['this.style_font_name','this.style_font_image','this.style_font_size','this.style_font_color'],
              'fontIcon':['this.style_image']
            },
            show_list:{
              'default':['this.style_image'],
              'fontIcon':['this.style_font_name','this.style_font_image','this.style_font_size','this.style_font_color']
            }
          },
          {name:'image',propID:'image',type:'str', tooltip:'Image path', section:'image'},
          {name:'Font',propID:'font_name',type:'str', section:'image', tooltip:'Set font name'},
          {name:'char', propID:'font_image', type:'str', tooltip:'Set font image of selected',buttons:'pick', actions:'SelectIcons()', section:'image'},
          {name:'size (in px)', propID:'font_size', type:'str', tooltip:'Set size of icon (in px)', section:'image'},
          {name:'color', propID:'font_color', type:'color', tooltip:'Set color of icon', section:'image'},
          {name:'popup',propID:'popup',type:'checkbox', tooltip:'Check to open action as popup', section:'Popup', extraClass:'col-3'},
          {name:'popup style', propID:'popup_style', type:'select[by skin,layer,popup]', tooltip:'Set popup style (defined by skin or always layer/popup)', section:'Popup', extraClass: 'col-3'},
          {name:'popup width',propID:'popup_width', type:'int', section:'Popup', extraClass:'col-2', tooltip:'Set popup width'},
          {name:'popup height',propID:'popup_height', type:'int', section:'Popup', extraClass:'col-2', tooltip:'Set popup height'},
          {name:'maximized', propID:'popup_maximized', type:'select[by skin,true,false]', section:'Popup', extraClass: 'col-2', tooltip:'The layer will be maximized open.'}
        ]
      }
    }

    this.linkedConfigurationObjClass={
      newProperties:{
        generic:[
          {name:'name',propID:'linkedConfName',type:'str', tooltip:'Name of the linked configuration'},
          {name:'title',propID:'title',type:'str', tooltip:'Description of the linked configuration'},
          {name:'configuration type', propID:'configtype',type:'select[,zoom,pivot]', tooltip:'Type of the linked configuration'},
          {name:'configuration name', propID:'configname', type:'str', tooltip:'Configuration to open',buttons:'PickCfg,edit',actions:'SelectCfg(),EditCfg()'},
          {name:'image type', propID:'imagetype',type:'select[grid,card,chart]',tooltip:'Select the type of image'},
          {name:'button on tabs (only for supported skins)', propID:'ontabs', type:'checkbox',tooltip:'Select to put this item on tabs bar'},
          {name:'button on toolbar (desktop mode is always on toolbar)', propID:'ontoolbar', type:'checkbox',tooltip:'Select to put this item on toolbar'},
          {name:'image settings', propID:'image_settings', type:'select[Default:default,Font icon:fontIcon]', tooltip:'image type (url or font icon)', section:'image',
          hide_list:{
            'default':['this.generic_font_name','this.generic_font_image','this.generic_font_size','this.generic_font_color'],
            'fontIcon':['this.generic_imagetoolbar']
          },
          show_list:{
            'default':['this.generic_imagetoolbar'],
            'fontIcon':['this.generic_font_name','this.generic_font_image','this.generic_font_size','this.generic_font_color']
          }
        },
          {name:'image', propID:'imagetoolbar', type:'image', tooltip:'Image path'},
          {name:'Font',propID:'font_name',type:'str', tooltip:'Set font name'},
          {name:'char', propID:'font_image', type:'str', tooltip:'Set font image of selected',buttons:'pick', actions:'SelectIcons()'},
          {name:'size (in px)', propID:'font_size', type:'str', tooltip:'Set size of icon (in px)'},
          {name:'color', propID:'font_color', type:'color', tooltip:'Set color of icon'},
        ]
      }
    }
    this.PSToolbarAction = [
      { 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function(){ _togglePreview() }
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Go to Preview'
      },
      { 'id': 'btn_cols'
        , 'class_name': 'btn'
        , 'action': function(){ toggleRowView(); }
        , 'image': '../portalstudio/images/icon/btn_zoom_wiz.png'
        , 'title': 'Open row view'
      },
      { 'id': 'btn_secondaryBar'
        , 'class_name': 'btn'
        , 'action': function(){ toggleSecondaryBarView(); }
        , 'image': '../portalstudio/images/icon/btn_zoom_extra_title.png'
        , 'title': 'Open secondary bar view'
      },
      { 'id': 'btn_filters'
        , 'class_name': 'btn'
        , 'action': function(){ toggleManageFilters(); }
        , 'image': '../portalstudio/images/icon/btn_filter.png'
        , 'title': 'Manage filters'
      }
    ]
    // OGGETTI-------------------------------------

    this.formObj=function(/*obj*/) {
      this.objClass = ZTObjects.formObjClass;
      this.id='zoomeditor';
      this.itemType="zoomeditor";
      this.type="Zoom";
      this.paddingCard="5";
      this.marginCard="5";
      this.defaultViewMode='grid';
      this.filters='true';
      this.titles='true';
      this.header='true';
      this.emptyrows='true';
      this.recordmark='true';
      this.toolsPosition='';
      this.Popup='true';
      this.LinkAdd='true';
      this.LinkAddExposed='false';
      this.LinkAccess='true';
      this.LinkAccessExposed='false';
      this.LinkEdit='true';
      this.LinkDelete='true';
      this.css_class='grid';
      this.TotalsPosition='grid';
      this.TotalsStarting='left';
      this.PrintMode = 'Auto';
      this.chart_type='category';
      this.PKFields='';
      this.show_btn_update='false';
      this.show_btn_delete='false';
      this.openVdmBeforeQuery='false';
      this.disablePresetParam=disablePresetParam;
      this.activateCheckbox='false';
      this.applyAdvancedFilter='false';
      this.hideFiltersBtn=hideFiltersBtn;
      this.editableBySmartEditor=editableBySmartEditor;
      this.infiniteScroll='false';
      this.group_repeated='false';
      this.LinkQuery='true';
    }
    this.CreatePickBO=function(tab,propID){
      var propBtnPick = new Element('div',{'class':'input_inline_btn', 'icon-data':  String.fromCharCode(parseInt('&#xe6e1;'.substring(3,7),16))});
      propBtnPick.refId=tab+"_"+propID;
      propBtnPick.refPropId=propID;
      return propBtnPick;
    }
    this.TitlePickBO=function(){
      return "Select BO";
    }
    this.CreatePickCfg=function(tab,propID){
      var propBtnPick = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe6f6;'.substring(3,7),16))});
      propBtnPick.refId=tab+"_"+propID;
      propBtnPick.refPropId=propID;
      return propBtnPick;
    }
    this.TitlePickCfg=function(){
      return "Select Configuration";
    }
    this.actionObj=function(obj){
      this.objClass = ZTObjects.actionObjClass;
      this.title=obj.title;
      this.tooltip=obj.tooltip;
      this.actionName=obj.actionName||obj.title;
      this.name=this.actionName;
      this.url=obj.url;
      this.image=obj.image;
      this.type='action';
      this.id=obj.title;
      this.element=obj.element;
      this.visibility=obj.visibility;
      this.important=obj.important;
      this.hideWhen=obj.hideWhen;
      this.image_settings=obj.image_settings;
      this.font_name=obj.font_name;
      this.font_image=obj.font_image;
      this.font_size=obj.font_size;
      this.font_color=obj.font_color;
      this.entityType=obj.entityType;
      this.parameter=obj.parameter;
      this.sendMemCurs=obj.sendMemCurs;
      this.memCursParam=obj.memCursParam;
      this.checkAllParam=obj.checkAllParam;
      this.queryFilterParam=obj.queryFilterParam;
      this.doQryAfterRoutine=obj.doQryAfterRoutine;
      this.showInMenu=obj.showInMenu;
      this.popup_height=obj.popup_height;
      this.popup_width=obj.popup_width;
      this.progressBar=obj.progressBar;
      this.progressBarPortlet=obj.progressBarPortlet;
      this.target=obj.target;
      this.popup=obj.popup;
      this.popup_style=obj.popup_style;
      this.popup_maximized=obj.popup_maximized;
      this.confirmMessage=obj.confirmMessage;
      this.toExpose=obj.toExpose;
    }
    this.linkedConfigurationObj=function(obj){
      this.objClass = ZTObjects.linkedConfigurationObjClass;
      this.title=obj.title;
      this.linkedConfName=obj.linkedConfName||obj.title;
      this.name=this.linkedConfName;
      this.configtype=obj.configtype;
      this.configname=obj.configname;
      this.imagetype=obj.imagetype;
      this.type='linkedConfiguration';
      this.id=obj.title;
      this.element=obj.element;
      this.ontoolbar=obj.ontoolbar;
      this.ontabs=obj.ontabs;
      this.imagetoolbar=obj.imagetoolbar;
      this.image_settings=obj.image_settings;
      this.font_name=obj.font_name;
      this.font_image=obj.font_image;
      this.font_color=obj.font_color;
      this.font_size=obj.font_size;
    }
  }
}
