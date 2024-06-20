ZTObjects.ChartObjClass = {
  helper : {
    description : 'Drawing SVG chart from DataProvider Objects (SQLDataObj, XMLDataObj, ...)',
    usage : 'This component needs : <ul><li>a chart definition file that can be created with the wizard or with the PS/Chart Editor</li><li>a DataProvider (client-side) defined in the portlet or a query VQR (server-side)</li></ul>'
  },
  newProperties : {
    generic:[
      {name:'type/chartdef', propID:'def', type:'chartdef', validFunc:'checkChartDef', section:'main', tooltip:"Set chart definition", section: "chart definition"},
      { name: 'type', propID: 'ctype', type: 'str', disabled: true }
    ],
    dataset: [
      {name: 'chart type', propID: 'chart_type', type: 'select[Category chart:category,XYZ chart:xyz,Measure chart:measure,Geographic chart:geo,Hierarchy chart:hie,Dependencies chart:dep]', defaultValue: 'category'
        , tooltip:"Allows you to choose the chart type inserted from among those listed"
        , validFunc:'checkChartType'
        , disabled: true
      },
      {name:'server-side', propID:'gendataset', type:'select[false,true]'
        , hide_list:{
          'true':['this.dataset_dataobj','this.functional_chartNavbar','this.functional_chartNavbarFirstlast','this.functional_chartNavbarAddRemove','this.functional_chartNavbarPagepanel','this.functional_chartNavbarChangepage','this.functional_chartNavbarLastpage'],
          'false':['this.dataset_auto_exec','this.dataset_query','this.dataset_parms']
        }
        , show_list:{
          'true':['this.dataset_auto_exec','this.dataset_query','this.dataset_parms'],
          'false':['this.dataset_dataobj','this.functional_chartNavbar','this.functional_chartNavbarFirstlast','this.functional_chartNavbarAddRemove','this.functional_chartNavbarPagepanel','this.functional_chartNavbarChangepage','this.functional_chartNavbarLastpage']
        }
        , tooltip:"If checked, indicates a server-side query"
        , extraClass: "col-3" ,section: "dataset", disabled: true
      },
      {name:'auto exec', propID:'auto_exec', type:'select[true,false]', extraClass: "col-3", section: "dataset"},
      {name:'dataobj', propID:'dataobj', type:'data', tooltip:"Allows you to choose a data object from among those listed"/*, extraClass: "col-3"*/},
      {name:'query', 	propID:'query', type:'str', tooltip:"Indicates query name"/*, extraClass: "col-3"*/ ,section: "dataset"},
      {name:'parameters', propID:'parms', type:'parameters', tooltip:"Indicates any query parameters"/*, extraClass: "col-3"*/ ,section: "dataset"},
      {name:'data label', propID:'othlabel', type:'str', defaultValue:'', tooltip:"Insert label to identify others (aggregate) datas", extraClass: "col-3", section: 'aggregate data'},
      {name:'view detail in menu', propID:'othmenu', type:'select[true,false]', defaultValue:'true', tooltip:"Insert 'view detail' voice in menu", extraClass: "col-3", section: 'aggregate data'},
      {name:'criterion for aggregation', propID:'othtype', type:'select[limit,function]', defaultValue:'limit'
        , hide_list:{
            'limit' : ['this.dataset_othfunc'],
            'function' : ['this.dataset_othlimits']
          }
        , show_list:{
            'limit' : ['this.dataset_othlimits'],
            'function' : ['this.dataset_othfunc']
          }
        , tooltip:"Insert criterion for aggregation", extraClass: "col-3", section: 'aggregate data'},
      {name:'data limit(s)', propID:'othlimits', type:'str', defaultValue:'', tooltip:"Insert one or more limit for each series to aggregate data", extraClass: "col-3", section: 'aggregate data'},
      {name:'aggregation function', propID:'othfunc', type:'str', defaultValue:'', tooltip:"Insert function definition to aggregate data. Function must be return boolean value (true for aggregate, false otherwise)", extraClass: "col-3", section: 'aggregate data'}
      //       {name:'domain field values type', propID:'domain_type', type:'select[default:false,string:true]', tooltip:"", section: "X axis/categories and series"},
      // dato temporale
/*       {name:'domain view type',		propID:'datatype',		type:'select[default,continuous,with holes:holes]', defaultValue: "default"
        , tooltip:'Let you choose different data visualizations', section:"time-based dataset"
        , hide_list:{
          'default':['this.dataset_and_fields_missval','this.dataset_and_fields_discunit','this.dataset_and_fields_discval'],
          'continuous':[],
          'holes':[]
        }
        , show_list:{
          'default':[],
          'continuous':['this.dataset_and_fields_missval','this.dataset_and_fields_discunit','this.dataset_and_fields_discval'],
          'holes':['this.dataset_and_fields_missval','this.dataset_and_fields_discunit','this.dataset_and_fields_discval']
        }
      },
      {name:'missing value',		propID:'missval',		type:'select[default,show,hide]', defaultValue: "default", tooltip:'Let you choose if visualize missing values or not', section:"time-based dataset"},
      {name:'discontinuity step',		propID:'discunit',		type:'select[day:d,month:M,year:y,hours:h,minutes:m,seconds:s]', extraClass: "col-3", tooltip:'Let you choose timing step for discontinuity', section:"time-based dataset"},
      {name:'discontinuity step value',		propID:'discval', type:'int', extraClass: "col-3", tooltip:'Let you set tick step for discontinuity', section:"time-based dataset"},
*/
    ],
    fields : [],
    functional:[
      {name:'view mode', propID:'vmode', type:'select[default,data-motion charts:mdim]'
        , hide_list:{
          'default':[/*'this.functional_ismulti',*/'this.functional_multi_key_field','this.functional_multi_scale','this.functional_multi_label_field','this.functional_key_start','this.functional_dsetFunct',
          'this.functional_multi_autochange','this.functional_cursorType','this.functional_cursorPosition','this.functional_cursorAlignment','this.functional_multisubdivision', 'this.functional_cstroke','this.functional_ccolor'],
          'mdim':['this.functional_chartNavbar','this.functional_chartNavbarFirstlast','this.functional_chartNavbarAddRemove','this.functional_chartNavbarPagepanel','this.functional_chartNavbarChangepage','this.functional_chartNavbarLastpage']
        }
        , show_list:{
          'mdim':[/*'this.functional_ismulti',*/'this.functional_multi_key_field','this.functional_multi_scale','this.functional_multi_label_field','this.functional_key_start','this.functional_dsetFunct',
          'this.functional_multi_autochange','this.functional_cursorType','this.functional_cursorPosition','this.functional_cursorAlignment','this.functional_multisubdivision', 'this.functional_cstroke','this.functional_ccolor'],
          'default':['this.functional_chartNavbar','this.functional_chartNavbarFirstlast','this.functional_chartNavbarAddRemove','this.functional_chartNavbarPagepanel','this.functional_chartNavbarChangepage','this.functional_chartNavbarLastpage']
        }
        , defaultValue:'default'
        , tooltip:"Default value indicates simple chart view mode, meanwhile data-motion indicates chart with data dictionary view mode"
      },
      {name:'enable navbar', propID:'chartNavbar', type:'select[false,true]',defaultValue:'false',
        hide_list:{
          'false': ['this.functional_chartNavbarFirstlast','this.functional_chartNavbarAddRemove','this.functional_chartNavbarPagepanel','this.functional_chartNavbarChangepage','this.functional_chartNavbarLastpage'],
          'true':[/*'this.functional_ismulti','this.functional_multi_key_field','this.functional_multi_scale','this.functional_multi_label_field','this.functional_key_start','this.functional_dsetFunct','this.functional_multi_autochange'*/]
        },
        show_list:{
          'true': ['this.functional_chartNavbarFirstlast','this.functional_chartNavbarAddRemove','this.functional_chartNavbarPagepanel','this.functional_chartNavbarChangepage','this.functional_chartNavbarLastpage'],
          'false':[/*'this.functional_ismulti','this.functional_multi_key_field','this.functional_multi_scale','this.functional_multi_label_field','this.functional_key_start','this.functional_dsetFunct','this.functional_multi_autochange'*/]
        }
        , tooltip:"If true, inserts a navigation bar under the chart"
        , section: "navbar"
      },
      {name:'first/last page buttons', propID:'chartNavbarFirstlast',type:'checkbox',defaultValue:true, tooltip:"If checked, inserts first page button and last page button in the navigation bar", extraClass: "col-2", section: "navbar"},
      {name:'add/remove rows buttons', propID:'chartNavbarAddRemove', type:'checkbox', tooltip:"If checked, inserts add and remove rows buttons", extraClass: "col-2", section: "navbar"},
      {name:'view page panel', propID:'chartNavbarPagepanel', type:'checkbox',defaultValue:false, tooltip:"If checked, inserts page panel in the navigation bar", extraClass: "col-2", section: "navbar"},
      {name:'view pages number', propID:'chartNavbarLastpage', type:'checkbox',defaultValue:false, tooltip:"If checked, inserts page numbers in the page panel", extraClass: "col-2", section: "navbar"},
      {name:'enable change page input', propID:'chartNavbarChangepage', type:'checkbox', defaultValue:false, tooltip:"If checked, enable page input in the page panel", extraClass: "col-2", section: "navbar"},
      {name:'key field or keys list', propID:'multi_key_field', type:'str', defaultValue:'', tooltip:"Set dataset key field name or keys list"/*, extraClass: "col-3"*/, section: "data-motion single chart configuration"},
      {name:'label field or labels list', propID:'multi_label_field', type:'str', defaultValue:'', tooltip:"Set dataset key-label field name or key-labels list"/*, extraClass: "col-3"*/, section: "data-motion single chart configuration"},
      {name:'start with specific chart (key)', propID:'key_start', type:'str', defaultValue:'', tooltip:"Set dataset key start"/*, extraClass: "col-3"*/, section: "data-motion single chart configuration"},
  //     {name:'dataset get function', propID:'dsetFunct', type:'str', defaultValue:'', tooltip:"Indicates the function to get the data", extraClass: "col-3", section: "data-motion single chart configuration"},
//      {name:'start with animation', propID:'multi_autochange', type:'select[true,false]', defaultValue:'false', tooltip:"If checked, multi-dimensional view starts automatically"/*, extraClass: "col-3"*/, section: "layout settings"},
      {name:'keep same scale in every charts', propID:'multi_scale', type:'select[true,false]', defaultValue:'false', tooltip:"Allows you to keep the same value scale in chart"/*, extraClass: "col-3"*/, section: "layout settings"},
      {name:'single chart label view mode',propID:'cursorType', type:'select[none,axis,value,combo]',defaultValue:'axis', tooltip:'Let you choose different types of multidimensional data cursor',
        hide_list:{
          'axis':['this.functional_multisubdivision'],
          'value':['this.functional_cstroke','this.functional_ccolor','this.functional_multisubdivision'],
          'combo':['this.functional_cstroke','this.functional_ccolor','this.functional_multisubdivision'],
          'none':['this.functional_cursorPosition','this.functional_cursorAlignment','this.functional_cstroke','this.functional_ccolor']
      },
        show_list:{
          'axis':['this.functional_cursorPosition','this.functional_cursorAlignment','this.functional_cstroke','this.functional_ccolor'],
          'value':['this.functional_cursorPosition','this.functional_cursorAlignment'],
          'combo':['this.functional_cursorPosition','this.functional_cursorAlignment'],
          'none':['this.functional_multisubdivision']
        },
        section: "layout settings"
      },
      {name:'position',propID:'cursorPosition',type:'select[top,bottom]',defaultValue:'top', tooltip:'Set cursor or title position',section: "layout settings", extraClass: "col-3"},
      {name:'alignment',propID:'cursorAlignment',type:'select[left,right]',defaultValue:'right', tooltip:'Set cursor or title alignment',section: "layout settings", extraClass: "col-3"},
      {name:'area subdivision', propID:'multisubdivision',type:'select[default,vertical proportional:vscrollprop,vertical:vscrollfirst]',defaultValue:'default', tooltip:'Set area subdivison',section: "layout settings", extraClass: "col-3",
        hide_list:{
          'default':['this.functional_multisubheight']
        },
        show_list:{
          'vscrollfirst':['this.functional_multisubheight']
        }
      },
      {name:'first chart height(%)',propID:'multisubheight',type:'int',defaultValue:'', tooltip:'Set first chart height %',section: "layout settings", extraClass: "col-3"},
      {name:'color',propID:'ccolor',type:'color', tooltip:'Set cursor color', defaultValue:'#000000',section:"layout settings", extraClass: "col-3"},
      {name:'stroke',propID:'cstroke',type:'int', tooltip:'Set cursor stroke', defaultValue:1,section:"layout settings", extraClass: "col-3"},
      {name:'show domain crossfilter', propID:'zfshow', type:'select[hide:default,only domain crossfilter:zoom,chart with domain crossfilter:chartzoom]'
        ,hide_list:{
          'default':['this.functional_zftype','this.functional_zfseries'],
          'zoom':[],
          'chartzoom':[]
        }
        ,show_list:{
          'default':[],
          'zoom':['this.functional_zftype','this.functional_zfseries'],
          'chartzoom':['this.functional_zftype','this.functional_zfseries']
        }
        , tooltip:"Allows you to choose if show domain crossfilter alone, with chart or none"
        , section: 'crossfilter'
        , defaultValue:'default'
      },
      {name:'crossfilter\'s elements type', propID:'zftype', type:'select[default,line,area,bar]', defaultValue:'default', tooltip:"Set the type of the cursor element", section: 'crossfilter'},
      {name:'crossfilter\'s values fields', propID:'zfseries', type:'str', defaultValue:'', tooltip:"Specifies the fields that will be represented as series in the cursor area", section: 'crossfilter'}
    ],
    titles:[
      {name:'title', 	propID:'title', 		type:'str', tooltip:"Set chart title"},
      {name:'subtitle', 	propID:'subtitle', 		type:'str', defaultValue:'', tooltip:"Set chart subtitle"},
      {name:'series title', propID:'titleSeries', type:'str', tooltip:"Set series title"},
      {name:'x axis title (label)', propID:'x_label', 	type:'str', tooltip:"Set X (domain) axis label", section :"axis"},
      {name:'y axis title (label)', propID:'y_label', 	type:'str', tooltip:"Set Y (value) axis label", section :"axis"},
      {name:'percent axis title', propID:'percent_label', 	type:'str', defaultValue:'', tooltip:"Set percent axis label", section :"axis"}
    ],
    plot_layout:[
      {name:'real chart width', propID:'chartW', type:'int', tooltip:'Real chart width', extraClass: "col-3", section :"dimensions"},
      {name:'real chart height', propID:'chartH', type:'int', tooltip:'Real chart height', extraClass: "col-3", section :"dimensions"},
      {name:'compress chart space', propID:'compactChart', type:'select[default:none,compact to left side:left,compact to right side:right]', tooltip:"Collapse chart space left or right, by default the chart takes up all the space", defaultValue:"none", section:'dimensions'},
      {name:'legend position', propID:'legend', type:'select[default,hide,top,bottom,left,right]', defaultValue:'default', tooltip:"Allows you to overwrite legend position", extraClass: "col-3", section : "legend"},
      {name:'limit for visualization', propID:'legendlimit', type:'str', defaultValue:'', tooltip:"Allows you to define costant or percentage limit for legend visualization", extraClass: "col-3", section : "legend"},
      {name:'min value',	propID:'xmin_value',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the minimum value",	extraClass:"col-2",	section:'domain numeric axis'},
      {name:'max value',	propID:'xmax_value',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the maximum value",	extraClass:"col-2",	section:'domain numeric axis'},
      {name:'tick unit',	propID:'xtick_unit',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the axis tick unit",	extraClass:"col-2",	section:'domain numeric axis'},
      {name:'reference line',	propID:'xrefline',	type:'int',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'domain numeric axis'},
      {name:'reference line color',	propID:'xreflinecol',	type:'color',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'domain numeric axis'},
      {name:'min value', propID:'min_value', type:'int', defaultValue:'', tooltip:"Allows you to overwrite the minimum value", extraClass: "col-3", section : "value axis"},
      {name:'max value', propID:'max_value', type:'int', defaultValue:'', tooltip:"Allows you to overwrite the maximum value", extraClass: "col-3", section : "value axis"},
      {name:'tick unit', propID:'tick_unit', type:'int', defaultValue:'', tooltip:"Allows you to overwrite the axis tick unit", extraClass: "col-3", section : "value axis"},
      {name:'precision', propID:'vaxis_precision', type:'int', defaultValue:'', tooltip:"Allows you to set value axis precision", extraClass: "col-3", section : "value axis"},
      {name:'reference line',	propID:'refline',	type:'int',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'value axis'},
      {name:'reference line color',	propID:'reflinecol',	type:'color',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'value axis'},
    /*   {name:'format', propID:'dateformat', type:timeformat_select, tooltip:'Let you choose the date format to be applied', section:"time axis format and settings"},
      {name:'custom format', propID:'tcustformat', type:'str', tooltip:'Allows you to set a custom date format to be applied', section:"time axis format and settings"},
      {name:'tick unit', propID:'tdomainunit', type:'select[day:d,month:M,year:y,hours:h,minutes:m,seconds:s]', tooltip:'Let you choose the time unit to be applied', section:"time axis format and settings", extraClass: "col-3"},
      {name:'tick value', propID:'tdomainvalue', type:'int', tooltip:'Set the tick interval between two dates', section:"time axis format and settings", extraClass: "col-3"},
      {name:'datetime limit to load data', propID:'dataload_datelimit', type:'str', defaultValue:'', tooltip:"Allows you to set a draw data limit (datetime)", section : "time axis format and settings"},
      {name:'type', propID:'datatype', type:'select[default,continuous,with holes:holes]', tooltip:'Let you choose different data visualizations', section:"time axis format and settings", disabled: true},
    */
      {name:'animate elements', propID:'elanimate', type:'select[default,disable,enable]', defaultValue:'default', tooltip:"Allows you to overwrite the setting of animation on chart", section: 'animation', extraClass:"col-3"},
      {name:'duration animation', propID:'danimation', type:'str', defaultValue:'', tooltip:"Allows you to overwrite the duration of animation on chart", section: 'animation', extraClass:"col-3"}
    ],
    values_settings: [
      {name:'type', propID:'pic_type', type:'select[standard:true,custom:false]', defaultValue:'true', section:'picture', tooltip:"Set picture type"
        , hide_list:{
          'true':[],
          'false':['this.values_settings_pic_prefix','this.values_settings_pic_suffix']
        }
        , show_list:{
          'true':['this.values_settings_pic_prefix','this.values_settings_pic_suffix'],
          'false':[]
        }
      },
      {name:'prefix', propID:'pic_prefix', type:'str', section:'picture', tooltip:"Set prefix on each value"},
      {name:'suffix', propID:'pic_suffix', type:'str', section:'picture', tooltip:"Set suffix on each value"},
      {name:'display picture', propID:'pic_cust', type:'str', section:'picture', tooltip:"Set picture or function on numeric values"},
      {name:'type', propID:'typecondform', type:'select[default,function]', defaultValue:'default', tooltip:"Select conditional formatting's type", section: 'conditional formatting'
        , hide_list:{
          'default':['this.values_settings_rangefunc'],
          'function':['this.values_settings_rangebands']
        }
        , show_list:{
          'default':['this.values_settings_rangebands'],
          'function':['this.values_settings_rangefunc']
        }
      },
      {name:'range bands', propID:'rangebands', type:'str', buttons:'edit', actions:'LoadRangeMask()', defaultValue:'', tooltip:"Allows you to set one or more range bands on chart", section: 'conditional formatting'},
      {name:'custom function', propID:'rangefunc', type:'str', defaultValue:'', tooltip:"Custom function for conditional formatting", section: 'conditional formatting'},
      {name:'value labels', propID:'value_labels', type:'select[default,hide]', defaultValue:'default', tooltip:"Allows you to overwrite value labels position", section: 'labels on chart'}
    ],
    hyperlinks_and_tooltips:[
      {name:'generic parameters', propID:'linkparms', type:'parameters', tooltip:"Indicates any url parameters", section: "parameters name (both url links and tooltip)"},
      {name:'multi-dimensional key parameter', propID:'multidimKeyName', type:'str', tooltip: "Indicates the name of the parameter referred to multi-dimensional key", section : "parameters name (both links and tooltip)"},  
      {name:'tooltips', propID:'ctooltip', type:'select[default,show,hide]', tooltip: "Tooltips visibility", section : "tooltip"},
      {name:'url or src', propID:'portletsrc', type:'str', tooltip: "Let you specify url or src for tooltips", extraClass: "col-3", section : "tooltip"},
      {name:'position', propID:'ttpos', type:'select[default,fixed]', tooltip: "Tooltip's position [Default, Fixed]"
        , hide_list : {
          'default' : ['this.hyperlinks_and_tooltips_ttx', 'this.hyperlinks_and_tooltips_tty', 'this.hyperlinks_and_tooltips_ttw', 'this.hyperlinks_and_tooltips_tth'],
          'fixed' : [],
        }
        , show_list:{
          'default' : [],
          'fixed' : ['this.hyperlinks_and_tooltips_ttx', 'this.hyperlinks_and_tooltips_tty', 'this.hyperlinks_and_tooltips_ttw', 'this.hyperlinks_and_tooltips_tth']
        }
        , extraClass: "col-3"
        , section : "tooltip"
      },
      {name:'x', propID:'ttx', type:'str', tooltip: "If position fixed, set X coordinate", extraClass: "col-3", section : "tooltip"},
      {name:'y', propID:'tty', type:'str', tooltip: "If position fixed, set Y coordinate", extraClass: "col-3", section : "tooltip"},
      {name:'width', propID:'ttw', type:'str', tooltip: "If position fixed, set width", extraClass: "col-3", section : "tooltip"},
      {name:'height', propID:'tth', type:'str', tooltip: "If position fixed, set height", extraClass: "col-3", section : "tooltip"},
      {name:'timeout (ms)', propID:'ttout', type:'str', tooltip: "Display's time of the tooltip (in milliseconds)", section : "tooltip"},
      // link
      {name:'url or function', propID:'url', 	type:'str', tooltip:"Let you specify url or function link", extraClass: "col-3", section : "hyperlink"},
      {name:'type', 		propID:'urlType', type:'select[script,link]'
        ,hide_list:{
          'script':['this.hyperlinks_and_tooltips_target','this.hyperlinks_and_tooltips_popup','this.hyperlinks_and_tooltips_popup_height','this.hyperlinks_and_tooltips_popup_width'],
          'link':[]
        }
        ,show_list:{
          'script':[],
          'link':['this.hyperlinks_and_tooltips_target','this.hyperlinks_and_tooltips_popup','this.hyperlinks_and_tooltips_popup_height','this.hyperlinks_and_tooltips_popup_width']
        }
        , tooltip:"Let you choose the type of hyperlink that will be applied on click on chart elements", extraClass: "col-3", section : "hyperlink"
      },
      {name:'target', 		propID:'target', type:'str', tooltip:"Indicates the html attribute target", section : "hyperlink"},
      {name:'popup', 		propID:'popup', 	type:'select[true,false]', tooltip:"If checked, hyperlink page will be open in a new window", extraClass: "col-3"
        , hide_list : {
          'true' : [],
          'false' : ['this.hyperlinks_and_tooltips_popup_type','this.hyperlinks_and_tooltips_popup_width','this.hyperlinks_and_tooltips_popup_height']
        }
        , show_list:{
          'true' : ['this.hyperlinks_and_tooltips_popup_type','this.hyperlinks_and_tooltips_popup_width','this.hyperlinks_and_tooltips_popup_height'],
          'false' : []
        }
        , default:'false', section : "hyperlink"},
      {name:'popup type', 		propID:'popup_type', 	type:'select[by skin,layer,popup]', tooltip:"If checked, hyperlink page will be open in a new window", extraClass: "col-3", default:'popup', section : "hyperlink"},
      {name:'popup width', propID:'popup_width', type:'int', tooltip:"Set popup window width", extraClass: "col-3", section : "hyperlink"},
      {name:'popup height', propID:'popup_height', type:'int', tooltip:"Set popup window height", extraClass: "col-3", section : "hyperlink"}
    ],
    advanced:[
      {name:'visual effect on click on element', propID:'selclicks', type:'select[disable:false,enable:true]', defaultValue:'true', tooltip:'Enable or disable all clicks (selections) on chart', extraClass: "col-3", section :"Chart effects"},
      {name:'filters (legend and domain)', propID:'exclicks', type:'select[disable:false,enable:true]', defaultValue:'true', tooltip:'Enable or disable filtres (exclusions) on chart', extraClass: "col-3", section :"Chart effects"},
      {name:'data order type', 		propID:'data_order', type:'select[default:,row:row,column:column]', defaultValue:'default', tooltip:"Allows you to choose the order of the dataset on chart", extraClass: "col-3", section: 'starting settings'},
      {name:'focus on element(s)', propID:'focuskey', type:'str', defaultValue:'', tooltip:"Allows you to highlight some elements on the chart", extraClass: "col-3", section: 'starting settings'},
      {name:'excluded series', propID:'exclSer', type:'str', defaultValue:'', tooltip:"Allows you to exclude one or more series from chart", section: 'starting settings'},
      {name:'position', propID:'menuPosition', type:'select[left,right,hide]', defaultValue:'left', tooltip:"Lets you choose the menu bar position on chart"
        ,hide_list:{
          'left':[],
          'right':[],
          'hide':['this.advanced_enable_menu_sel', 'this.advanced_exportFileName', 'this.advanced_othlimits','this.advanced_othlabel','this.advanced_enable_change_order','this.advanced_other_chart','this.advanced_downloadlist'
                  ,'this.advanced_grid_chart','this.advanced_grch_domain','this.advanced_grch_key','this.advanced_grch_values','this.advanced_grch_serie']
        }
        ,show_list:{
          'left':['this.advanced_enable_menu_sel', 'this.advanced_exportFileName','this.advanced_othlimits','this.advanced_othlabel','this.advanced_enable_change_order','this.advanced_other_chart','this.advanced_downloadlist'
                  ,'this.advanced_grid_chart','this.advanced_grch_domain','this.advanced_grch_key','this.advanced_grch_values','this.advanced_grch_serie'],
          'right':['this.advanced_enable_menu_sel', 'this.advanced_exportFileName','this.advanced_othlimits','this.advanced_othlabel','this.advanced_enable_change_order','this.advanced_other_chart','this.advanced_downloadlist'
                  ,'this.advanced_grid_chart','this.advanced_grch_domain','this.advanced_grch_key','this.advanced_grch_values','this.advanced_grch_serie'],
          "hide":[]
        }, section: 'menu'
      },
      {name:'selections on values', propID:'enable_menu_sel', type:'select[disable:false,enable:true]', defaultValue:false, tooltip:"If enabled, makes possible menu selection on chart", extraClass: "col-3", section: 'menu'},
      {name:'change data order', propID:'enable_change_order', type:'select[disable:false,enable:true]', defaultValue:false, tooltip:"If checked, makes possible the rotation of the dataset's order on chart", extraClass: "col-3", section: 'menu'},
      {name:'download file name', propID:'exportFileName', type:'str', defaultValue:'', tooltip:"Specifies the export file name", extraClass: "col-3", section: 'menu'},
      {name:'download file extension', propID:'downloadlist', type:'str', buttons:'edit', actions:'LoadFileList()', defaultValue:'', tooltip:"Specifies the export file extension to download the chart", extraClass: "col-3", section: 'menu'},
      {name:'other chart types list', propID:'other_chart', type:'str', buttons:'edit', actions:'LoadChartList()', defaultValue:'', tooltip:"Specifies the other chart types related to the choosen one", section: 'menu'},
      {name:'grid view', propID:'grid_chart', type:'select[disable:false,enable:true]', defaultValue:false, tooltip:"View chart data in a grid", section: 'menu'
        , hide_list:{
          'true':[],
          'false':['this.advanced_grch_domain','this.advanced_grch_key','this.advanced_grch_values','this.advanced_grch_serie','this.advanced_grch_fields'],
        }
        , show_list:{
          'true':['this.advanced_grch_domain','this.advanced_grch_key','this.advanced_grch_values','this.advanced_grch_serie','this.advanced_grch_fields'],
          'false':[]
        }
      },
      {name:'grid column title for domain', propID:'grch_domain', type:'str', defaultValue:"", tooltip:"Specifies the grid column title for domain", section: 'menu'},
      {name:'grid column title for keys', propID:'grch_key', type:'str', defaultValue:"", tooltip:"Specifies the grid column title for keys", section: 'menu'},
      {name:'grid column title for values', propID:'grch_values', type:'str', defaultValue:"", tooltip:"Specifies the grid column title for values", section: 'menu'},
      {name:'grid column title for serie', propID:'grch_serie', type:'str', defaultValue:"", tooltip:"Specifies the grid column title for serie", section: 'menu'}
    ]
  },
  events : [
    { name:'Click', tooltip:'Event dispatched when clicking on chart element', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'item', tooltip: 'Item is an object containing the information of the clicked element', type: 'object'}
      ]
    },
    { name:'LegendClick', tooltip:'Event dispatched when clicking on legend element', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'item', tooltip: 'Item is an object containing the information of the clicked element', type: 'object'}
      ]
    },
    { name:'TitleClick', tooltip:'Event dispatched when clicking on chart title', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'item', tooltip: 'Item is an object containing the information of the clicked element', type: 'object'}
      ]
    },
    { name:'ExclusionFilter', tooltip:'Event dispatched when filtering an element', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'item', tooltip: 'Item is an object containing the information of the excluded element', type: 'object'}
      ]
    },
    { name:'ElementMouseOver', tooltip:'Event dispatched when the mouse is over a chart element', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'item', tooltip: 'Item is an object containing the information of the clicked element', type: 'object'}
      ]
    },
    { name:'ChangeMultiDimensional', tooltip:'Event dispatched when the multi-dimensional data (key) changes', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'multidimKey', tooltip: 'Key of current multi-dataset', type: 'string'}
      ]
    },
    { name:'FilterAction', tooltip:'Event dispatched when cursor window changes', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'action', tooltip: 'Action happened on cursor', type: 'string'},
        {name: 'start', tooltip: 'Start of the cursor window', type: 'string'},
        {name: 'end', tooltip: 'End of the cursor window', type: 'string'},
        {name: 'multidimKey', tooltip: 'Current multi-dimensional key', type: 'string'}
      ]
    },
    { name:'MenuClick', tooltip:'Event dispatched when clicking on context menu', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'},
        {name: 'item', tooltip: 'Item is an object containing the information of the clicked element', type: 'object'}
      ]
    },
    { name:'Drawing', tooltip:'Event dispatched when chart starts to draw', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'}
      ]
    },
    { name:'Rendered', tooltip:'Event dispatched when chart ends to draw', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'}
      ]
    },
    { name:'Error', tooltip:'Event dispatched when an error occurred', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'The event returned', type: 'event object'}
      ]
    }
  ],
  functions : [
    {name:'Hide()', tooltip:'Hide object', returnValue:'', parameters:[], usage:''},
    {name:'SetChartLanguage(stringLang,#dontDraw#)', signature:'SetChartLanguage(stringLang,#dontDraw#)', tooltip:'Set chart object language', returnValue:'', usage:'Usually set <b>before</b> draw',
      parameters: [
        {name: 'stringLang', tooltip: 'The language (ITA, ENG,...)', type: 'String'},
        {name: 'dontDraw', tooltip: 'Set drawing or not (default value as false - force drawing after language settings)', type:'Logic', optional:true}
      ]
    },
    { name:'Show', tooltip:'Show object', usage:'', returnValue:'', parameters : [] },
    { name:'HideLegend()', tooltip:'Hide legend', returnValue:'', parameters:[], usage:''},
    { name:'ShowLegend(stringPosition)', tooltip:'Show legend in a given position', usage:'', returnValue:'',
      parameters : [
        {name: 'stringPosition', tooltip: 'Legend position: top, bottom, left, right', type:'String', optional:false}
      ]
    },
    { name:'HideValueLabels()', tooltip:'Hide value labels', returnValue:'', parameters:[], usage:''},
    { name:'ShowValueLabels()', tooltip:'Show value labels', returnValue:'', parameters:[], usage:''},
    { name:'HideChartMenu()', tooltip:'Hide chart menu', returnValue:'', parameters:[], usage:''},
    { name:'ShowChartMenu(stringPosition)', tooltip:'Show chart menu in a given position', usage:'', returnValue:'',
      parameters : [
        { name: 'stringPosition', tooltip: 'Chart menu position: left, right', type:'String', optional:false}
      ]
    },
    { name:'HasAggregateData()', tooltip:'show if there is any aggregate data or not', returnValue:'', parameters:[], usage:''},
    { name:'ClearRangeBands()', tooltip:'Clear range bands (with the possibility to reload it)', returnValue:'', parameters:[], usage:''},
    { name:'RemoveRangeBands()', tooltip:'Permanently delete/remove the object RangeBands', returnValue:'', parameters:[], usage:''},
    { name:'GetPngB64()', tooltip:'Get the basic B64 string of the chart in PNG format', returnValue:'', parameters:[], usage:''},
    { name:'GetJpegB64()', tooltip:'Get the basic B64 string of the chart in JPEG format', returnValue:'', parameters:[], usage:''},
    { name:'GetPdfB64()', tooltip:'Get the basic B64 string of the chart in PDF format', returnValue:'', parameters:[], usage:''},
    { name:'GetSelectedItems()', tooltip:'Get selected items', returnValue:'', parameters:[], usage:''},
    { name:'GetNotSelectedItems()', tooltip:'Get not selected items', returnValue:'', parameters:[], usage:''},
    { name:'SetChartDef(defName)', tooltip:'Set which chart definition file to load', usage:'', returnValue:'',
      parameters : [
        { name: 'defName', tooltip: 'Chart definition file name', type:'String', optional:false}
      ]
    },
    { name:'SetQuery(vqrName,#parameters#)', tooltip:'Set the query', usage:'', returnValue:'',
      parameters : [
        { name: 'vqrName', tooltip: 'Query name', type:'String', optional:false},
        { name: 'parameters', tooltip: 'Query parameters', type:'String', optional:true}
      ]
    },
    { name:'SetDataProvider(dataObject)', tooltip:'Set the data provider', usage:'', returnValue:'',
      parameters : [
        { name: 'dataObject', tooltip: 'Object data provider', type:'String', optional:false}
      ]
    },
    { name:'SetFieldsCategoryChart(domainFld,valuesFld,#seriesFld#,#keyFld#)', tooltip:'Set the fields of the Category chart', usage:'', returnValue:'',
      parameters : [
        {name: 'domainFld', tooltip: 'Domain field', type:'String', optional:false},
        {name: 'valuesFld', tooltip: 'Values field', type:'String', optional:false},
        {name: 'seriesFld', tooltip: 'Series field', type:'String', optional:true},
        {name: 'keyFld', tooltip: 'Key field', type:'String', optional:true}
      ]
    },
    { name:'SetFieldsXYZChart(xFld,yFld,#zFld#,seriesFld,#keyFld#)', tooltip:'Set the fields of the XYZ chart', usage:'', returnValue:'',
      parameters : [
        {name: 'xFld', tooltip: 'X axis field', type:'String', optional:false},
        {name: 'yFld', tooltip: 'Y axis field', type:'String', optional:false},
        {name: 'zFld', tooltip: 'Z axis field (only for Bubble chart)', type:'String', optional:true},
        {name: 'seriesFld', tooltip: 'Series field', type:'String', optional:false},
        {name: 'keyFld', tooltip: 'Key field', type:'String', optional:true}
      ]
    },
    { name:'SetFieldsMeasureChart(domainFld,valuesFld,#minFld#,#maxFld#,#keyFld#)', tooltip:'Set the fields of the Measure chart', usage:'', returnValue:'',
      parameters : [
        {name: 'domainFld', tooltip: 'Domain field', type:'String', optional:false},
        {name: 'valuesFld', tooltip: 'Values field', type:'String', optional:false},
        {name: 'minFld', tooltip: 'Field of minimum value', type:'String', optional:true},
        {name: 'maxFld', tooltip: 'Field of maximum value', type:'String', optional:true},
        {name: 'keyFld', tooltip: 'Key field', type:'String', optional:true}
      ]
    },
    { name:'SetFieldsGeoChart(countryFld,#countrySubFld#,valuesFld,#seriesFld#,geoLevel,#geoView#)', tooltip:'Set the fields of the Geographic chart', usage:'', returnValue:'',
      parameters : [
        {name: 'countryFld', tooltip: 'Country field', type:'String', optional:false},
        {name: 'countrySubFld', tooltip: ' Country administrative subdivision field', type:'String', optional:true},
        {name: 'valuesFld', tooltip: 'Values field', type:'String', optional:false},
        {name: 'seriesFld', tooltip: 'Series field', type:'String', optional:true},
        {name: 'geoLevel', tooltip: 'Geographic level', type:'String', optional:false},
        {name: 'geoView', tooltip: 'Geographic view (first geographical display)', type:'String', optional:true}
      ]
    },
    { name:'SetTitles(#stringTitle#,#stringSubitle#,#stringLegendSeriesTitle#)', tooltip:'Set the titles on the chart', usage:'', returnValue:'',
      parameters : [
        {name: 'stringTitle', tooltip: "Title", type:'String', optional:true},
        {name: 'stringSubitle', tooltip: "Subtitle", type:'String', optional:true},
        {name: 'stringLegendSeriesTitle', tooltip: "Legend series title", type:'String', optional:true}
      ]
    },
    { name:'SetAxisTitles(#stringXaxis#,#stringYaxis#,#stringPercentAxis#)', tooltip:'Set the titles of the axis', usage:'', returnValue:'',
      parameters : [
        {name: 'stringXaxis', tooltip: "Title of the X axis", type:'String', optional:true},
        {name: 'stringYaxis', tooltip: "Title of the Y axis", type:'String', optional:true},
        {name: 'stringPercentAxis', tooltip: "Title of the percent axis (only for Pareto)", type:'String', optional:true}
      ]
    },
    { name:'SetLegendLimit(limit)', tooltip:'Set the limit of the legend', usage:'', returnValue:'',
      parameters : [
        {name: 'limit', tooltip: "Value of the legend's limit", type:'numeric', optional:false}
      ]
    },
    { name:'SetValueAxisParameters(#min#,#max#,#tick#,#precision#)', tooltip:'Set the value axis parameters', usage:'', returnValue:'',
      parameters : [
        {name: 'min', tooltip: "Minimum value", type:'numeric', optional:true},
        {name: 'max', tooltip: "Maximum value", type:'numeric', optional:true},
        {name: 'tick', tooltip: "Tick between one value and the next", type:'numeric', optional:true},
        {name: 'precision', tooltip: "Precision applied on value axis", type:'numeric', optional:true}
      ]
    },
    { name:'SetRealChartSize(width,height)', tooltip:'Set the real size of the chart', usage:'', returnValue:'',
      parameters : [
        {name: 'width', tooltip: "Width value", type:'numeric', optional:false},
        {name: 'height', tooltip: "Height value", type:'numeric', optional:false}
      ]
    },
    { name:'SetAggregateData(stringLimitsOrFunc,#stringLabels#)', tooltip:'Set the aggregate data', usage:'', returnValue:'',
      parameters : [
        {name: 'stringLimitsOrFunc', tooltip: "string of the limit or function that determines the aggregation", type:'String', optional:false},
        {name: 'stringLabels', tooltip: "Labels", type:'String', optional:true}
      ]
    },
    { name:'SetScriptHyperlink(stringFnc)', tooltip:'Set the hyperlink script', usage:'', returnValue:'',
      parameters : [
        {name: 'stringFnc', tooltip: "String of the function", type:'String', optional:false}
      ]
    },
    { name:'SetLinkHyperlink(urlFnc,#target#,#popup#,#popupHeight#,#popupWidth#)', tooltip:'Set the hyperlink link', usage:'', returnValue:'',
      parameters : [
        {name: 'urlFnc', tooltip: "Url or function link", type:'String', optional:false},
        {name: 'target', tooltip: "Indicates the html attribute target", type:'String', optional:true},
        {name: 'popup', tooltip: "If checked, hyperlink page will be open in a new window", type:'String', optional:true},
        {name: 'popupHeight', tooltip: "Popup's height", type:'numeric', optional:true},
        {name: 'popupWidth', tooltip: "Popup's width", type:'numeric', optional:true}
      ]
    },
    { name:'AddRangeBand(#stringLabel#,minValue,maxValue,stringColorHex,booleanIsPercent,#stringImgPath#)', tooltip:'Add the range bands', usage:'', returnValue:'',
      parameters : [
        {name: 'stringLabel', tooltip: "Label", type:'String', optional:true},
        {name: 'minValue', tooltip: "Minimum value of the range band", type:'numeric', optional:false},
        {name: 'maxValue', tooltip: "Maximum value of the range band", type:'numeric', optional:false},
        {name: 'stringColorHex', tooltip: "Range band's color (Hex)", type:'String', optional:false},
        {name: 'booleanIsPercent', tooltip: "True if the rang band is in percentage (else false)", type:'boolean', optional:false},
        {name: 'stringImgPath', tooltip: "Image's path", type:'String', optional:true}
      ]
    },
    { name:'SetUrlTooltip(url,position,#x#,#y#,#width#,#height#,#timeoutms#)', tooltip:"Set the tooltip's url", usage:'', returnValue:'',
      parameters : [
        {name: 'url', tooltip: "Tooltip's url or source", type:'String', optional:false},
        {name: 'position', tooltip: "Tooltip's position [Default, Fixed]", type:'String', optional:false},
        {name: 'x', tooltip: "X coordinate", type:'numeric', optional:true},
        {name: 'y', tooltip: "Y coordinate", type:'numeric', optional:true},
        {name: 'width', tooltip: "Width value", type:'numeric', optional:true},
        {name: 'height', tooltip: "Heightvalue", type:'numeric', optional:true},
        {name: 'timeoutms', tooltip: "Display's time of the tooltip (in milliseconds)", type:'numeric', optional:true}
      ]
    },
    { name:'SetMultiDataset(keysList,#labelList#,#keyStart#,#getDataFunc#)', tooltip:'Set multi dataset', usage:'', returnValue:'',
      parameters : [
        {name: 'keysList', tooltip: "Dataset key field name or keys list", type:'String', optional:false},
        {name: 'labelList', tooltip: "Dataset key-label field name or key-labels list", type:'String', optional:true},
        {name: 'keyStart', tooltip: "Dataset key start", type:'String', optional:true},
        {name: 'getDataFunc', tooltip: "The function to get the data", type:'String', optional:true}
      ]
    },
    { name:'SetHyperlinkOrTooltipParametersName(#category#,#valueY#,#valueZ#,#series#,#categoryKey#,#multidimKey#,#geocountryname#,#geosubname#)', tooltip:'Set the name of the hyperlink or tooltip parameters', usage:'', returnValue:'',
      parameters : [
        {name: 'category', tooltip: "The name of the parameter referred to categories", type:'String', optional:true},
        {name: 'valueY', tooltip: "The name of the parameter referred to values", type:'String', optional:true},
        {name: 'valueZ', tooltip: "The name of the parameter referred to z value", type:'String', optional:true},
        {name: 'series', tooltip: "The name of the parameter referred to series", type:'String', optional:true},
        {name: 'categoryKey', tooltip: "The name of the parameter referred to category key", type:'String', optional:true},
        {name: 'multidimKey', tooltip: "If the chart is drawn in multi-dimensional mode, multidimKey is the parameter representation key", type:'String', optional:true},
        {name: 'geocountryname', tooltip: "The name of the country to be represented", type:'String', optional:true},
        {name: 'geosubname', tooltip: "The name of the subdivision of the country to be represented", type:'String', optional:true}
      ]
    },
    { name:'SetDataOrder(stringOrder)', tooltip:'Set data order', usage:'', returnValue:'',
      parameters : [
        {name: 'stringOrder', tooltip: "Order [Row;Column]", type:'String', optional:false}
      ]
    },
    { name:'ChangeDataOrderOnChart(booleanEnable)', tooltip:'Change data order on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'booleanEnable', tooltip: "True if the option is visible on the menu, else false", type:'boolean', optional:false}
      ]
    },
    { name:'DontUpdate', tooltip:'Update settings or not while drawing', usage:'', returnValue:'',
      parameters : [
        {name: 'update', tooltip: "True for update, false otherwise", type:'boolean', optional:true}
      ]
    },
    { name:'SetDataLoadDateLimit', tooltip:'Load data until the specified date', usage:'', returnValue:'',
      parameters : [
        {name: 'datetime', tooltip: "String in YYYY-MM-DD format", type:'String', optional:false}
      ]
    },
    { name:'SetFocusKey', tooltip:'Allows to set one or more elements highlighted (NOT selected)', usage:'', returnValue:'',
      parameters : [
        {name: 'key', tooltip: "Possible values: min, max, first, last, category name, series name (comma separated)", type:'String', optional:false}
      ]
    },
    { name:'GetAggregateData', tooltip:'Returns the data who has been aggregated', usage:'', returnValue:'',
      parameters : [
        {name: 'valuesFld', tooltip: "Returns data only for the alias specified as parameter", type:'String', optional:true}
      ]
    },
    { name:'VisualEffectOnClick', tooltip:'Enable or disable visual effects when user clicks elements', usage:'', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "True for enable effects, false otherwise", type:'boolean', optional:false}
      ]
    },
    { name:'ExclusionsOnChart', tooltip:'Enable or disable exclusions (filters) on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "True for enable exclusions, false otherwise", type:'boolean', optional:false}
      ]
    },
    { name:'SetOtherChartTypes', tooltip:'Sets one or more chart types related to the drawing type', usage:'', returnValue:'',
      parameters : [
        {name: 'types', tooltip: "Comma separated list of types", type:'string', optional:true}
      ]
    },
    { name:'SetDownloadFile', tooltip:'Sets allowed download types and file name', usage:'', returnValue:'',
      parameters : [
        {name: 'extensions', tooltip: "Comma separated list of download types", type:'string', optional:false},
        {name: 'name', tooltip: "Download file name", type:'string', optional:true}
      ]
    },
    { name:'SetExcludedSeries', tooltip:'Sets one or more series to be excluded on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'list', tooltip: "Comma separated list of series names", type:'string', optional:false}
      ]
    },
    { name:'GetCSVdata', tooltip:'Returns data in CSV format', usage:'', returnValue:'',
      parameters : [
        {name: 'selection', tooltip: "If there\'s one or more selected elements on chart, true returns only selections", type:'boolean', optional:true}
      ]
    },
    { name:'GetXMLdata', tooltip:'Returns data in XML format', usage:'', returnValue:'',
      parameters : [
        {name: 'selection', tooltip: "If there\'s one or more selected elements on chart, true returns only selections", type:'boolean', optional:true}
      ]
    },
    { name:'SelectItem', tooltip:'Allows to select one item on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'item', tooltip: "Item is an object with the following properties: category, series, value", type:'string', optional:false}
      ]
    },
    { name:'UnselectItem', tooltip:'Allows to unselect one item on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'item', tooltip: "Item is an object with the following properties: category, series, value", type:'string', optional:false}
      ]
    },
    { name:'SelectItems', tooltip:'Allows to select one or more items on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'itemsArray', tooltip: "Array of items that are objects with the following properties: category, series, value", type:'string', optional:false}
      ]
    },
    { name:'UnselectItems', tooltip:'Allows to unselect one item on chart', usage:'', returnValue:'',
      parameters : [
        {name: 'item', tooltip: "Array of items that are objects with the following properties: category, series, value", type:'string', optional:false}
      ]
    },
    { name:'SetColorForSerie', tooltip:'Allows to specify and override colors on chart\'s elements', usage:'', returnValue:'',
      parameters : [
        {name: 'value_field', tooltip: "Name of the value field (alias)", type:'string', optional:false},
        {name: 'color', tooltip: "Color string in rgb or hex format", type:'string', optional:false},
        {name: 'gradient', tooltip: "Color string in rgb or hex format", type:'string', optional:true}
      ]
    },
    { name:'GetSeriesColors', tooltip:'Returns the colors applied on chart\'s elements', usage:'', returnValue:'', parameters : [] },
    { name:'SetFieldsHierarchyChart', tooltip:'Sets the fields to be drawn on chart (hierarchies charts)', usage:'', returnValue:'',
      parameters : [
        {name: 'pathFlds', tooltip: "Comma separated list of alias that composed the hierarchy path to be represented", type:'string', optional:false},
        {name: 'valueFld', tooltip: "Value field specified for the last element of hierarchy path", type:'string', optional:true}
      ]
    },
    { name:'Update', tooltip:'Refresh chart', usage:'', returnValue:'', parameters : [] },
    ['SetSeriesConfiguration(#array_items#) -> set different configurations on series; available chart types: LINES,SLINES (only shapes like scatter),VBAR,AREA,STACKEDAREA,VSTACKBAR,LAYEREDBAR'
      , 'SetSeriesConfiguration([\n  { serie:#name#, type:#chart_type#, ownerScale:#bool# }\n])'],
      { name:'SetSeriesColors', tooltip:'Sets the colors on elements', usage:'', returnValue:'',
      parameters : [
        {name: 'array_colors', tooltip: "Array list of colors (hex or rgb)", type:'array', optional:false},
        {name: 'applyeach', tooltip: "If true, sets the colors on each elements not by series", type:'boolean', optional:true}
      ]
    },
    { name: 'GetExcludedItems', tooltip: 'Returns excluded items on chart', usage: '', returnValue: '', parameters: [] },
    {
      name: 'SetGeoMarkersUrlTooltip(url,position,#x#,#y#,#width#,#height#,#timeoutms#)', tooltip: "Set the tooltip for geo-markers", usage: '', returnValue: '',
      parameters: [
        { name: 'url', tooltip: "Tooltip's url or source", type: 'String', optional: false },
        { name: 'position', tooltip: "Tooltip's position [default, fixed]", type: 'String', optional: false },
        { name: 'x', tooltip: "X coordinate", type: 'numeric', optional: true },
        { name: 'y', tooltip: "Y coordinate", type: 'numeric', optional: true },
        { name: 'width', tooltip: "Width value", type: 'numeric', optional: true },
        { name: 'height', tooltip: "Heightvalue", type: 'numeric', optional: true },
        { name: 'timeoutms', tooltip: "Display's time of the tooltip (in milliseconds)", type: 'numeric', optional: true }
      ]
    },
    {
      name: 'CenterAndZoomMap', tooltip: 'Sets the center and the zoom of the geographic map', usage: '', returnValue: '',
      parameters: [
        { name: 'centerCoords', tooltip: "Array of lat,lng coordinates", type: 'array', optional: true },
        { name: 'zoomLevel', tooltip: "Sets level on a 1-10 scale of zoom", type: 'int', optional: true }
      ]
    }
  ],
  connector : [
    { 'type' : 'iData', 'propID' : 'dataobj', 'versus' : 'in' },
    { 'type' : 'iData', 'propID' : 'add_dataobj', 'versus' : 'in' },
    { 'type' : 'iParameter' , 'propID' : 'parms', 'versus' : 'in'},
    { 'type' : 'iParameter' , 'propID' : 'linkparms', 'versus' : 'in'}
  ],
  names : ['../portalstudio/images/icon/bot_graphics_off.png','../portalstudio/images/icon/chart.svg'],
  notifications : function(obj) {
    obj.notifications = [];
    if (Empty(obj.def)) {
      obj.notifications.push({'message':'Select chart definition.', 'tab':'generic', 'prop':'def'});
    }
    if (Empty(obj.dataobj)) {
      obj.notifications.push({'message':'Select a dataobj.', 'tab':'dataset', 'prop':'dataobj'});
    }
    switch(obj.chart_type) {
      case "category":
        if(Empty(obj.label_field))
          obj.notifications.push({'message':'Select domain field.', 'tab':'fields', 'prop':'label_field'});
        if(Empty(obj.value_fields))
          obj.notifications.push({'message':'Select values field(s).', 'tab':'fields', 'prop':'value_fields'});
        break;
      case "xyz":
        if(Empty(obj.x_field))
          obj.notifications.push({'message':'Select domain x field.', 'tab':'fields', 'prop':'x_field'});
        if(Empty(obj.y_field))
          obj.notifications.push({'message':'Select value y field.', 'tab':'fields', 'prop':'y_field'});
        if(Empty(obj.xyz_series_field))
          obj.notifications.push({'message':'Select series field.', 'tab':'fields', 'prop':'xyz_series_field'});
        break;
      case "measure":
        if(Empty(obj.val_field))
          obj.notifications.push({'message':'Select values field.', 'tab':'fields', 'prop':'val_field'});
        if(Empty(obj.measure_series_field))
          obj.notifications.push({'message':'Select series field.', 'tab':'fields', 'prop':'measure_series_field'});
        break;
      case "geo":
        if(Empty(obj.geo_0_field))
          obj.notifications.push({'message':'Select geographic domain field.', 'tab':'fields', 'prop':'geo_0_field'});
        if(Empty(obj.geo_value_field))
          obj.notifications.push({'message':'Select values field.', 'tab':'fields', 'prop':'geo_value_field'});
        break;
    }
  },
  wireframe : function (/*obj*/) {
    return "<div style='background-image:url(../portalstudio/images/icon/chart.svg);background-size:100% 100%;overflow:hidden;width:100%;height:100%;'></div>";
  },
//  wizard : { hasWizard : true, fncName : "StartChartWizard" },
  _allProps: {
    dataset : [
      {name:'additional dataobj', propID:'add_dataobj', type:'data', tooltip:"Allows you to choose another data object from among those listed", extraClass: "col-3", _innerpos: 4 }
    ],
    fields : [
      // campi
      { name: 'key field(s) for domain', propID: 'labelKey_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that contains keys for domain's each value (like primary key)", section: "X axis/categories and series" },
      { name: 'labels for domain field(s)', propID: 'label_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be placed as chart's domain", section: "X axis/categories and series" },
      { name: 'series field', propID: 'sfield', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', defaultValue: '', tooltip: "Indicates the series field", section: "X axis/categories and series" },
      { name: 'labels for series field', propID: 'sfieldlabel', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', defaultValue: '', tooltip: "Indicates the labels for series field", section: "X axis/categories and series" },
      { name: 'values field(s)', propID: 'value_fields', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the fields that will be placed as chart's series", section: "Y axis/values" },
      { name: 'labels for values field(s)', propID: 'label_series', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the value field labels to be displayed in the legend", defaultValue: "", section: "Y axis/values" },
      { name: 'value numeric field', propID: 'val_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will contain data value", section: "values"},
      { name: 'minimum values field', propID: 'min_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will contain the minimum value for each data-interval evaluation", section: "values" },
      { name: 'maximum values field', propID: 'max_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will contain the maximum value for each data-interval evaluation", section: "values" },
      { name: 'X axis field', propID: 'x_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be placed as chart's domain", section: "XYZ axes" },
      { name: 'Y axis field', propID: 'y_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be setted as the Y axis dimension", section: "XYZ axes" },
      { name: 'Z axis field (radius for Bubble Chart)', propID: 'z_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be represented as the Z (3rd) axis dimension", section: "XYZ axes" },
      { name: 'series field', propID: 'xyz_series_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be placed as chart's series", section: "series" },
      { name: 'key field for series', propID: 'xKey_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that contains keys for series' each value (like primary key)", section: "series" },
      { name: 'category field', propID: 'measure_series_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be placed as chart's domain serie", section: "domain-category", disabled: true },
      { name: 'category key field', propID: 'measureKey_series_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', section: "domain-category", disabled: true },
      { name: 'values mapping configuration', propID: 'mapSeries', type: 'str', buttons: 'edit', actions: 'LoadSeriesConfigurator()', tooltip: "This property contains a configuration string to have different types for values in chart", section: "different chart-type elements for values" },
      { name: 'automatic values scaling (multiple axes)', propID: 'manualScale', type: 'select[enable:false,disable:true]', defaultValue: 'false', tooltip: "This property sets whether the numerical scales must be differentiated by order of numerical size", section: "different chart-type elements for values" },
      { name: 'hierarchy path fields list', propID: 'fieldpath', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the fields (comma separated) that will be compose the hierarchy path", section: "hierarchy fields" },
      { name: 'hierarchy path key-fields list', propID: 'keyfieldpath', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the key-fields (comma separated) that will be compose the hierarchy path", section: "hierarchy fields" },
      { name: 'value numeric field', propID: 'fieldvalue', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field contains the numeric value to be represented", section: "hierarchy fields" },
      { name: 'first field key', propID: 'depfield_1', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the first field key", section: "Dependencies fields (relationships)" },
      { name: 'first field label', propID: 'depfield_1label', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the first field label", section: "Dependencies fields (relationships)" },
      { name: 'first classification field', propID: 'depfield_1class', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the first classification field", section: "Dependencies fields (relationships)" },
      { name: 'second field key', propID: 'depfield_2', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the second field key", section: "Dependencies fields (relationships)" },
      { name: 'second field label', propID: 'depfield_2label', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the second field label", section: "Dependencies fields (relationships)" },
      { name: 'second classification field', propID: 'depfield_2class', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the second classification field", section: "Dependencies fields (relationships)" },
      { name: 'value numeric field', propID: 'depvalue', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field contains the numeric value to be represented", section: "Dependencies fields (relationships)" },
      { name: 'nodes classification', propID: 'depclass', type: 'str', buttons: 'edit', actions: 'LoadClassificationConfigurator()', tooltip: "This property contains a configuration string for each node on chart (eg. node_name;node_type|....)", section: "Dependencies fields (relationships)" },
      { name: 'classification label field', propID: 'class_label', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the label for classification band", section: "Additional fields" },
      { name: 'classification key field', propID: 'class_key', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Key field if the classification label field contains duplicates", section: "Additional fields" },
      { name: 'x axis from value', propID: 'class_xfrom', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the lower limit value to be represented on the x-axis for the classification band", section: "Additional fields" },
      { name: 'x axis to value', propID: 'class_xto', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the upper limit value to be represented on the x-axis for the classification band; optional if the values to represent on the x-axis are discrete (strings)", section: "Additional fields" },
      { name: 'y axis from value', propID: 'class_yfrom', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the lower limit value to be represented on the y-axis for the classification band", section: "Additional fields" },
      { name: 'y axis to value', propID: 'class_yto', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "Indicates the upper limit value to be represented on the y-axis for the classification band; optional if the values to represent on the y-axis are discrete (strings)", section: "Additional fields" },
      { name: 'category field', propID: 'class_cat', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Category set of values to represent on the classification bands", section: "Values", extraClass: "col-3" },
      { name: 'category key field', propID: 'class_keycat', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Key field if the category field contains duplicates", section: "Values", extraClass: "col-3" },
      { name: 'x value field', propID: 'class_xval', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Pair of fields (separated by comma) which identifies the classification (and possible sub-classification) in x of the values to be represented", section: "Values" },
      { name: 'y value field', propID: 'class_yval', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "pair of fields (separated by comma) which identifies the classification (and possible sub-classification) in y of the values to be represented", section: "Values" },
      { name: 'sub-classification axis', propID: 'class_subaxis', type: 'select[disable:false,enable:true]', defaultValue: "false", tooltip: "If 'Enabled', it enables the sub-classification of the represented values", section: "Values" },
      { name: 'nodes classification', propID: 'voro_class', type: 'str', buttons: 'edit', actions: 'LoadClassificationConfigurator()', tooltip: "Classification (series) of the values to be represented", section: "Nodes" },
      { name: 'nodes key field', propID: 'voro_cat', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Key field if the nodes classification contains duplicates", section: "Nodes" },
      { name: 'nodes coordinates', propID: 'voro_coords', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Pair of fields (separated by comma) that identify the x and y values to be represented", section: "Nodes" },
      { name: 'view', propID: 'geo_view_select', type: 'select[world:0,world with Antartic:1,continent:2,country:3]', tooltip: "It represent chart's start view", section: "map settings",
        hide_list: {
          '0': ['this.fields_geo_level_2', 'this.fields_geo_level_3'],
          '1': ['this.fields_geo_level_2', 'this.fields_geo_level_3'],
          '2': ['this.fields_geo_level', 'this.fields_geo_level_3'],
          '3': ['this.fields_geo_level', 'this.fields_geo_level_2']
        },
        show_list: {
          '0': ['this.fields_geo_level'],
          '1': ['this.fields_geo_level'],
          '2': ['this.fields_geo_level_2'],
          '3': ['this.fields_geo_level_3']
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
      { name: 'grouping series field', propID: 'geo_dom_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field is optional; if specified, will be placed as chart's series", section: "geographic fields and values" },
      { name: 'dataobj', propID: 'markers_dataobj', type: 'data', tooltip: "Allows you to choose a data object from among those listed", section: "markers" },
      { name: 'latitude field', propID: 'markers_lat', type: 'str', tooltip: "This field represents the latitude coordinate of each marker", extraClass: "col-3", section: "markers" },
      { name: 'longitude field', propID: 'markers_lng', type: 'str', tooltip: "This field represents the longitude coordinateof each marker", extraClass: "col-3", section: "markers" },
      { name: 'description field', propID: 'markers_desc', type: 'str', tooltip: "This field represents the description of each marker", extraClass: "col-3", section: "markers" },
      { name: 'key field (optional)', propID: 'markers_key', type: 'str', tooltip: "This field is optional; it represents the key of each marker if the description isn't unique", extraClass: "col-3", section: "markers" },
      { name: 'marker type', propID: 'markers_type', type: 'select[circle:0,marker:1,map pin:2,neuter pin:3,geo fence:4]', tooltip: "Select marker type", section: "markers" }
    ],
    hyperlinks_and_tooltips : [
      {name:'category/serie key parameter', propID:'categoryKeyName', type:'str', /*extraClass: "col-3",*/ section : "parameters name (both links and tooltip)", _innerpos: 1},
      {name:'category (X) parameter', propID:'categoryname', type:'str', tooltip:"Indicates the name of the parameter referred to categories", /*extraClass: "col-3",*/ section : "parameters name (both links and tooltip)", _innerpos: 1},
      {name:'serie parameter', propID:'seriesname', type:'str', tooltip:"Indicates the name of the parameter referred to series", section : "parameters name (both links and tooltip)", _innerpos: 1},
      {name:'value (Y) parameter', propID:'valuename', type:'str', tooltip:"Indicates the name of the parameter referred to values", section : "parameters name (both links and tooltip)", _innerpos: 1},
      {name:'value (Z) parameter', propID:'valuezname', type:'str', tooltip:"Indicates the name of the parameter referred to z value", section : "parameters name (both links and tooltip)", _innerpos: 1},
      {name:'country parameter', propID:'countryname', type:'str', /*extraClass: "col-3",*/ section : "parameters name (both links and tooltip)", _innerpos: 1},
      {name:'country administrative subdivision parameter', propID:'csubname', type:'str', tooltip:"Indicates the name of the parameter referred to categories", /*extraClass: "col-3",*/ section : "parameters name (both links and tooltip)", _innerpos: 1},
    ],
    advanced : [
      {name:'grid column fields', propID:'grch_fields', type:'str', defaultValue:"", tooltip:"", section: 'menu'}
    ]
  }
};

ZTObjects.ChartObjClass._GetChartProps = function (type, macro_type) {
  var i,
  hyp_minLen = 17,
  reverseProps = ['hyperlinks_and_tooltips'],
  show_list = {
    'category': ['fields.label_field', 'fields.sfield', 'fields.sfieldlabel', 'fields.value_fields', 'fields.label_series', 'fields.labelKey_field', 'fields.mapSeries', 'fields.manualScale'
      , 'hyperlinks_and_tooltips.categoryKeyName', 'hyperlinks_and_tooltips.categoryname', 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'
      , 'advanced.grch_fields'],
    'xyz': ['fields.x_field', 'fields.y_field', 'fields.z_field', 'fields.xyz_series_field', 'fields.xKey_field'
      , 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename', 'hyperlinks_and_tooltips.valuezname'
      , 'advanced.grch_fields'],
    'measure': ['fields.label_field', 'fields.sfield', 'fields.sfieldlabel', 'fields.value_fields', 'fields.label_series', 'fields.labelKey_field', 'fields.min_field', 'fields.max_field'
      , 'hyperlinks_and_tooltips.categoryKeyName', 'hyperlinks_and_tooltips.categoryname', 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'
      , 'advanced.grch_fields'],
    'geo': ['fields.geo_0_field', 'fields.geo_1_field', 'fields.geo_value_field', 'fields.geo_dom_field', 'fields.geo_view', 'fields.geo_level', 'fields.geo_level_2', 'fields.geo_level_3'
      , 'fields.geo_view_select', 'fields.geo_onlydata', 'fields.markers_dataobj', 'fields.markers_desc', 'fields.markers_lat', 'fields.markers_lng', 'fields.markers_key', 'fields.markers_type'
      , 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename', 'hyperlinks_and_tooltips.countryname', 'hyperlinks_and_tooltips.csubname'],
    'hie': ['fields.fieldpath', 'fields.fieldvalue', 'fields.keyfieldpath'
      , 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'],
    'dep': ['fields.depfield_1', 'fields.depfield_2', 'fields.depvalue', 'fields.depclass', 'fields.depfield_1label', 'fields.depfield_2label', 'fields.depfield_1class', 'fields.depfield_2class'
      , 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'],
    'classif': ['fields.class_label', 'fields.class_key', 'fields.class_xfrom', 'fields.class_xto', 'fields.class_yfrom', 'fields.class_yto'
      , 'fields.class_cat', 'fields.class_xval', 'fields.class_yval', 'fields.class_zval', 'fields.class_keycat'
      , 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'
      , 'advanced.grch_fields'
      , 'dataset.add_dataobj'],
    'PCOORDS': ['fields.sfield', 'fields.sfieldlabel', 'fields.value_fields', 'fields.label_series'
      , 'hyperlinks_and_tooltips.categoryKeyName', 'hyperlinks_and_tooltips.categoryname', 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'
      , 'advanced.grch_fields'],
    'VORONOI': ['fields.voro_class', 'fields.voro_cat', 'fields.voro_coords'
      , 'hyperlinks_and_tooltips.categoryKeyName', 'hyperlinks_and_tooltips.categoryname', 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'
      , 'advanced.grch_fields'],
    'RINGPERC': ['fields.label_field', 'fields.labelKey_field', 'fields.max_field', 'fields.val_field'
      , 'hyperlinks_and_tooltips.categoryKeyName', 'hyperlinks_and_tooltips.categoryname', 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename'],
    'ASTER': ['fields.x_field', 'fields.y_field', 'fields.xyz_series_field', 'fields.xKey_field', 'fields.min_field', 'fields.max_field'
      , 'hyperlinks_and_tooltips.seriesname', 'hyperlinks_and_tooltips.valuename', 'hyperlinks_and_tooltips.valuezname'
      , 'advanced.grch_fields'
    ]
  };

  // normalizzazione oggetto newProperties //
  this.newProperties.fields = []; // i campi li svuoto sempre
  if (this.newProperties.hyperlinks_and_tooltips.length > hyp_minLen) {
    // tolgo campi che non servono - non svuoto per non perdere quelli base
    var props = this.newProperties.hyperlinks_and_tooltips,
    end_key = "multidimKeyName",
    end_idx = -1;
    for (i = props.length - 1; i > 0; i--) {
      if (props[i].propID == end_key) {
        end_idx = i;
        continue;
      }
      else if (end_idx > 0)
        props.splice(i, 1);
    }
  }
  if (this.newProperties.dataset[4].propID == "add_dataobj")
    this.newProperties.dataset.splice(4, 1);
  if (this.newProperties.advanced[this.newProperties.advanced.length - 1].propID == "grch_fields")
    this.newProperties.advanced.splice(-1, 1);
  // --- ///

  if (Empty(show_list[type]) && Empty(show_list[macro_type]))
    return;

  for (var tab in this._allProps) {
    var allFlds = this._allProps[tab];
    if (reverseProps.indexOf(tab) >= 0)  // leggo array al contrario
      allFlds = (this._allProps[tab].slice()).reverse();
    for (i = 0; i < allFlds.length; i++) {
      var str_prop = tab + "." + allFlds[i].propID;
      if ( (show_list[type] && show_list[type].length > 0 && show_list[type].indexOf(str_prop) >= 0) ||
          (show_list[macro_type] && show_list[macro_type].length > 0 && show_list[macro_type].indexOf(str_prop) >= 0)
      ) {
        if (!Empty(allFlds[i]._innerpos) || allFlds[i]._innerpos === 0)
          this.newProperties[tab].splice(allFlds[i]._innerpos, 0, allFlds[i]);
        else 
          this.newProperties[tab].push(allFlds[i]);
      }
    }
  }
};

ZTObjects.extend(ZTObjects.stdVisibleObjClass, ZTObjects.ChartObjClass);

ZTObjects.ChartObj = function (id, name, type, html, value, shadow, x, y, h, w) {
  this.objClass = ZTObjects.ChartObjClass;
  this.isDef = true;
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
  this.sequence = '';
  this.anchor = '';
  this.auto_exec = 'true';
  this.layout_steps_values = {};
  this.author = 'Zucchetti SitePainter';
}
ZTObjects.ChartObj.prototype = new ZTObjects.stdVisibleObj;