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
        generic:[
          {name:'Description',propID:'description',type:'str', tooltip:'Pivot description'},
          {name:'Caption',propID:'caption',type:'str', tooltip:'Define Pivot title'},
          {name:'query file' ,propID:'query' ,type:'str', tooltip:'Select query', section:'datasource'},
          {name:'allowed query', propID:'allowedqueries', section:'datasource', type:'querylist', list:"true", tooltip: "Lists of allowed queries for this zoom separated by commas or how they should start with using \"*\" (Es: myquery*).<br>if empty only query file is allowed."},
          //{name:'progressive queries on row' ,propID:'progrRow' , type:'checkbox', tooltip:'Execute query by level on Row drill-down.<br> Only available on pivot object, not on chart.', section:'datasource'},
          {name:'Prefetched Row fields',	propID:'cachelevel', type:'int', section:'datasource', defaultValue:''
					,tooltip:"Indicates up to how many rows aggregated dimensions will be included on the the first query execution cached client-side"
            ,buttons:'edit', actions: "checkDataSourceLevel({'props':props,tabName:tabName})" ,	extraClass: 'col-3'
				  },
          {name:'Prefetched Columns fields',	propID:'cachelevel2', type:'int', section:'datasource', defaultValue:''
            ,tooltip:"Indicates up to how many columns aggregated dimensions will be included on the the first query execution cached client-side"
            ,buttons:'edit', actions: "checkDataSourceLevel({'props':props,tabName:tabName})" ,	extraClass: 'col-3'
				  },
          {name:'Parameters mask', propID:'vdmfile', type:'vdmdef',section:'parameters', tooltip:'Parameters mask to use on filtering'},
          {name:'Parameters mask width', propID:'vdmWidth', type:'int', extraClass: 'col-3',section:'parameters', tooltip:'Parameters mask width on opening'},
          {name:'Parameters mask height', propID:'vdmHeight', type:'int', extraClass: 'col-3',section:'parameters', tooltip:'Parameters mask height on opening'},
          {name:'url', propID:'portletsrc', type:'str', section:'Click on pivot cell', tooltip:'Url to execute on cell click'},
          {name:'parameters', propID:'linkparms', type:'str', section:'Click on pivot cell', tooltip:"Parameters to use with cell click Url <br>Variable jsClickItem will be used as parameter if specified <br> jsClikItem contains a string of the json representation for the click item"}
        ],
        view_options:[
          {name:'view mode', propID: 'viewmode', type: 'select[pivot:grid,chart,both]', tooltip:'Visual Pivot view mode <br>Pivot as only pivot view <br>Chart as only chart view <br>Both as pivot and chart combined view, with chart controlling by pivot'},
          {name:'Header menu mode',propID:'header',type:'select[Titled by skin:true,Small menu with actions:toolbar,Small menu:false]', tooltip:'Visual Pivot header menu options'},
          {name:'css file', propID:'css', type:'str',section:'style', tooltip:'Select a css file to include in this VisualPivot configuration.'},
          {name:'class for pivot',propID:'css_class',type:'css_class',section:'style', tooltip:'Select a css class from the skin the default is drilldown', defaultValue:'drilldown'},
          {name:'enable filters',propID:'canFilter',type:'checkbox', section:'filters options', extraClass: 'col-3', tooltip:'Enable filtering'},
          {name:'Hide filters button',propID:'hideFiltersBtn',type:'checkbox', section:'filters options', extraClass: 'col-3', tooltip:'Hide filtering on menu'},
          {name:'Open filters configuration before query',propID:'openVdmBeforeQuery',type:'checkbox', section:'filters options', tooltip:'On loading, open filters configuration or parameters mask'},
          {name:'Apply advanced filter',propID:'applyAdvancedFilter',type:'checkbox', section:'filters options', extraClass: 'col-3', tooltip:'Applying predefined filters on configuartion or on parameters mask'},
          {name:'Disable preset parameters',propID:'disablePresetParam',type:'checkbox', section:'filters options', extraClass: 'col-3', tooltip:'On loading open filters configuration (not or parameters mask), predefined parameters will not be editable'}
        ],
        pivot_options: [
          {name:'UI drag and drop',		propID:'uiDragDrop',				type:'checkbox', 	 		    tooltip:"Enable UI for drag and drop dimensions",	extraClass: 'col-3'},
          {name:'Start UI open',		propID:'uiStartOpen',				type:'checkbox', 	 		    tooltip:"Start with UI open",	extraClass: 'col-3'},
          {name:'Enable other dimensions and measures',		propID:'othDimMeas',				type:'checkbox', 	 		    tooltip:"Enable other dimensions and measures"},
          {name:'row sorting',		propID:'rowsort',				type:'checkbox', 	section:"sort", 		    tooltip:"Enable change sorting on rows",	extraClass: 'col-3'},
          {name:'column sorting',		propID:'columnsort',			type:'checkbox', 	section:"sort", 		    tooltip:"Enable change sorting on columns",	extraClass: 'col-3'},
          {name:'subtotal text',		propID:'subtotaltext',			type:'str', 				section:"totals", 		tooltip:"Specify subtotal suffix text (to add to value) as 'value [subtotal text]'" },
          {name:'subtotal row',		propID:'rowsubtotal',			type:'checkbox', 	section:"totals", 		tooltip:"Specify if adding subtotal on rows",      extraClass: 'col-3'},
          {name:'subtotal column',		propID:'columnsubtotal',		type:'checkbox', 	section:"totals", 		tooltip:"Specify if adding subtotal on columns",      extraClass: 'col-3'},
          {name:'grand total text',		propID:'bigtotaltext',			type:'str', 				section:"totals", 		tooltip:"Specify grand total text as title for row and column" },
          {name:'grand total row',		propID:'rowbigtotal',			type:'checkbox', 	section:"totals", 		tooltip:"Specify if adding grand total on rows",      extraClass: 'col-3'},
          {name:'grand total column',		propID:'columnbigtotal',		type:'checkbox', 	section:"totals", 		tooltip:"Specify if adding grand total on columns",      extraClass: 'col-3'},
          {name:'measures position',	propID:'measuresoncolumn',	type:'select[column:true,row:false]',		defaultValue: 'false', section:"measures settings",			tooltip:"Specify where integrate measures on pivot, row or column",      extraClass: 'col-2'},
          {name:'measures on row column title',		propID:'measurestitle',			type:'str', 				section:"measures settings", 		tooltip:"Specify measures column title when measures are on row",      extraClass: 'col-2'},
          {name:'hide measures title',	propID:'hidemeasures',	type:'checkbox',		section:"measures settings",			tooltip:"Specify hiding or not measures title row or column",      extraClass: 'col-2'},
        ],
        chart_options: [
          {name:'type/chartdef', propID:'chartDef', type:'chartdef', validFunc:'checkChartDef', tooltip:"Set chart definition"},
          { name: 'type', propID: 'chart_type', type: 'str', defaultValue: 'category', disabled: true, validFunc:'checkChartType' }
        ],
        print_options:[
          {name:'direct export as Pivot',	propID:'exportPivot',	type:'checkbox',		section:"export XLSX",			extraClass: 'col-3', tooltip:"Export pivot on xlxs as pivot format <br> NOT as excel pivot object<br> Available only on pivot and both (pivot and chart) mode"},
          {name:'direct export as Table',	propID:'exportTable',	type:'checkbox',		section:"export XLSX",		  extraClass: 'col-3', tooltip:"Export pivot on xlxs as table format"},
          {
            name: 'Print mode', propID: 'PrintMode', type: 'select[Auto,None,SmartReport]', tooltip: "Auto: prints all records and every column applying user's sort(s) and filter(s) criteria. Resulting document may contains data outside margins.<br>None: zoom can't be printed.<br>Report: Use specific report configuration.",
            hide_list: { 
              'None': ['print_options.ReportName', 'print_options.print_option', 'print_options.print_title', 'print_options.print_hideexport', 'print_options.print_hidesettings', 'print_options.print_size', 'print_options.print_totals'],
              'Auto': ['print_options.ReportName'],
              'SmartReport': []
            },
            show_list: { 
              'SmartReport': ['print_options.ReportName', 'print_options.print_option', 'print_options.print_title', 'print_options.print_hideexport', 'print_options.print_hidesettings', 'print_options.print_size', 'print_options.print_totals'],
              'Auto': ['print_options.print_option', 'print_options.print_title', 'print_options.print_hideexport', 'print_options.print_hidesettings', 'print_options.print_size', 'print_options.print_totals'],
              'None': []
            },
            section: 'print'
          },
          {name:'Report name', propID:'ReportName', type:'str', tooltip:'Report configuration used for print action.',
           buttons:"pick,edit,new", actions:"SelectReport(),EditReport(),NewReport()",
           section:'print'
          },
          
          {name:'print model', propID:'print_model', type:'select[default,pivot,table]', extraClass: 'col-3', section: 'print',
            defaultValue: 'default',
            tooltip:'Select pivot model o table model for printing, as default the pivot model will be used and the print will be as group repeated'
          },
          {name:'print as group repeated', propID:'print_grep', type:'checkbox', extraClass: 'col-3', section: 'print', 
            defaultValue: true,
            tooltip:'As true, the repetead value of columns will not be written'
          },
          {name:'output format', propID:'print_outputf', type:'select[default,PDF,HTML,CSV,CSV Std:CSVS,SDF:CSV2,XML,Struct.XML:XMLS,XLS,XLSX]', section: 'print', tooltip:'Select a fixed output format for the print', extraClass: 'col-3'},
          {name:'maximized print', propID:'print_max', type:'checkbox', section: 'print', tooltip:'Select for maximed layer', extraClass: 'col-3'},
          {name:'print option', propID:'print_option', type:'select[default,preview,print]', section: 'print', tooltip:'default: Enable preview and print mode.<br>preview: Enable only preview mode.<br>print: Enable only priny mode.'},
          {name:'print title', propID:'print_title', type:'str', section: 'print', tooltip:'Specifies the title'},
          {name:'hide export options', propID:'print_hideexport', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Hide mail and download options'},
          {name:'hide settings options', propID:'print_hidesettings', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Hides the option for changing settings'}
        ],
        customization:[
          {name:'Save in custom dir', propID:'custom', type:'checkbox', defaultValue: false},
          {name:'visual pivot for user or group', propID:'user_group', type: 'select[,User,Group]',
            hide_list:{'':['this.customization_user','this.customization_group'],'User':['this.customization_group'],'Group':['this.customization_user']},
            show_list:{'User':['this.customization_user'],'Group':['this.customization_group']}
          },
          {name:'Group',propID:'group',type:'str',validFunc:'IsNumericInput'},
          {name:'User',propID:'user',type:'str',validFunc:'IsNumericInput'},
          {name:'editable by smart editor ', propID:'editableBySmartEditor', type:'checkbox', disabled: true}
        ]
      },
      _allProps: {
        chartFields : [
          // campi
          { name: 'key field(s) for domain', propID: 'labelKey_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that contains keys for domain's each value (like primary key)", section: "X axis/categories and series" },
          { name: 'labels for domain field(s)', propID: 'label_field', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "Indicates the field that will be placed as chart's domain", section: "X axis/categories and series" },
          { name: 'series field', propID: 'sfield', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', defaultValue: '', tooltip: "", section: "X axis/categories and series" },
          { name: 'labels for series field', propID: 'sfieldlabel', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', defaultValue: '', tooltip: "", section: "X axis/categories and series" },
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
          { name: 'first field key', propID: 'depfield_1', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Dependencies fields (relationships)" },
          { name: 'first field label', propID: 'depfield_1label', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Dependencies fields (relationships)" },
          { name: 'first classification field', propID: 'depfield_1class', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Dependencies fields (relationships)" },
          { name: 'second field key', propID: 'depfield_2', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Dependencies fields (relationships)" },
          { name: 'second field label', propID: 'depfield_2label', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Dependencies fields (relationships)" },
          { name: 'second classification field', propID: 'depfield_2class', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Dependencies fields (relationships)" },
          { name: 'value numeric field', propID: 'depvalue', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "This field contains the numeric value to be represented", section: "Dependencies fields (relationships)" },
          { name: 'nodes classification', propID: 'depclass', type: 'str', buttons: 'edit', actions: 'LoadClassificationConfigurator()', tooltip: "This property contains a configuration string for each node on chart (eg. node_name;node_type|....)", section: "Dependencies fields (relationships)" },
          { name: 'classification label field', propID: 'class_label', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Additional fields" },
          { name: 'classification key field', propID: 'class_key', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Additional fields" },
          { name: 'x axis from value', propID: 'class_xfrom', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Additional fields" },
          { name: 'x axis to value', propID: 'class_xto', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Additional fields" },
          { name: 'y axis from value', propID: 'class_yfrom', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Additional fields" },
          { name: 'y axis to value', propID: 'class_yto', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', extraClass: "col-3", tooltip: "", section: "Additional fields" },
          { name: 'category field', propID: 'class_cat', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Values", extraClass: "col-3" },
          { name: 'category key field', propID: 'class_keycat', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Values", extraClass: "col-3" },
          { name: 'x value field', propID: 'class_xval', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Values" },
          { name: 'y value field', propID: 'class_yval', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Values" },
          { name: 'sub-classification axis', propID: 'class_subaxis', type: 'select[disable:false,enable:true]', defaultValue: "false", tooltip: "", section: "Values" },
          { name: 'nodes classification', propID: 'voro_class', type: 'str', buttons: 'edit', actions: 'LoadClassificationConfigurator()', tooltip: "", section: "Nodes" },
          { name: 'nodes key field', propID: 'voro_cat', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Nodes" },
          { name: 'nodes coordinates', propID: 'voro_coords', type: 'str', buttons: 'edit', actions: 'LoadFieldsConfigurator(this)', tooltip: "", section: "Nodes" },
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
          { name: 'latitude field', propID: 'markers_lat', type: 'str', tooltip: "This field represents the latitude coordinate of each marker", extraClass: "col-3", section: "markers" },
          { name: 'longitude field', propID: 'markers_lng', type: 'str', tooltip: "This field represents the longitude coordinateof each marker", extraClass: "col-3", section: "markers" },
          { name: 'description field', propID: 'markers_desc', type: 'str', tooltip: "This field represents the description of each marker", extraClass: "col-3", section: "markers" },
          { name: 'key field (optional)', propID: 'markers_key', type: 'str', tooltip: "This field is optional; it represents the key of each marker if the description isn't unique", extraClass: "col-3", section: "markers" },
          { name: 'marker type', propID: 'markers_type', type: 'select[circle:0,marker:1,map pin:2,neuter pin:3,geo fence:4]', tooltip: "Select marker type", section: "markers" }
        ]
      },
      _GetChartProps : function (ctype, /*macro*/type) {
        var i,
        show_list = {
          'category': ['label_field', 'sfield', 'sfieldlabel', 'value_fields', 'label_series', 'labelKey_field', 'mapSeries', 'manualScale'],
          'xyz': ['x_field', 'y_field', 'z_field', 'xyz_series_field', 'xKey_field'],
          'measure': ['label_field', 'sfield', 'sfieldlabel', 'value_fields', 'label_series', 'labelKey_field', 'min_field', 'max_field'],
          'geo': ['geo_0_field', 'geo_1_field', 'geo_value_field', 'geo_dom_field', 'geo_view', 'geo_level', 'geo_level_2', 'geo_level_3'
            , 'geo_view_select', 'geo_onlydata', 'markers_desc', 'markers_lat', 'markers_lng', 'markers_key', 'markers_type'],
          'hie': ['fieldpath', 'fieldvalue', 'keyfieldpath'],
          'dep': ['depfield_1', 'depfield_2', 'depvalue', 'depclass', 'depfield_1label', 'depfield_2label', 'depfield_1class', 'depfield_2class'],
          'classif': ['class_label', 'class_key', 'class_xfrom', 'class_xto', 'class_yfrom', 'class_yto'
            , 'class_cat', 'class_xval', 'class_yval', 'class_zval', 'class_keycat'],
          'PCOORDS': ['sfield', 'sfieldlabel', 'value_fields', 'label_series'],
          'VORONOI': ['voro_class', 'voro_cat', 'voro_coords'],
          'RINGPERC': ['label_field', 'labelKey_field', 'max_field', 'val_field'],
          'ASTER': ['x_field', 'y_field', 'xyz_series_field', 'xKey_field', 'min_field', 'max_field']
        };
        
        return;
        
        // normalizzazione oggetto newProperties //
        this.newProperties.chart_options.splice(2, this.newProperties.chart_options.length - 2); // i campi li svuoto sempre da idx 2
        if (Empty(show_list[type]))
          return;
        
          // per ora solo chart
        //for (var tab in this._allProps) {
          var allFlds = this._allProps.chartFields; //[tab];
          for (i = 0; i < allFlds.length; i++) {
            var str_prop = /*tab + "." +*/ allFlds[i].propID;
            if (show_list[type] && show_list[type].length > 0 && show_list[type].indexOf(str_prop) >= 0) {
              this.newProperties/*[tab]*/.chart_options.push(allFlds[i]);
            }
          }
        //}
      }
    }

    this.actionObjClass={
      newProperties:{
        generic:[
           {name:'name',propID:'actionName',type:'str', tooltip:'Name of the action'},
           {name:'title',propID:'title',type:'str', tooltip:'Description of the action'},
           {name:'tooltip',propID:'tooltip',type:'str', tooltip:'Tooltip of the action'},
           {name:'confirm message',propID:'confirmMessage',type:'str', tooltip:'Confirm message'},
           {name:'entity Type',propID:'entityType', type:'select[hyperlink,routine,function]', tooltip:'Type of the entity',
            hide_list:{
              'hyperlink':['this.generic_parameter','this.generic_sendMemCurs','this.generic_memCursParam','this.generic_checkAllParam','this.generic_queryFilterParam','this.generic_doQryAfterRoutine','this.generic_progressBar','this.generic_progressBarPortlet'],
              'function':['this.generic_parameter','this.generic_sendMemCurs','this.generic_memCursParam','this.generic_checkAllParam','this.generic_queryFilterParam','this.generic_progressBar','this.generic_progressBarPortlet','this.generic_target']},
            show_list:{
              'function':['this.generic_doQryAfterRoutine'],
              'routine':['this.generic_parameter','this.generic_sendMemCurs','this.generic_memCursParam','this.generic_checkAllParam','this.generic_queryFilterParam','this.generic_doQryAfterRoutine','this.generic_progressBar','this.generic_progressBarPortlet','this.generic_target'],
              'hyperlink':['this.generic_target']}},
           {name:'entity',propID:'url',type:'str', tooltip:'Entity'},
           {name:'target',propID:'target',type:'str', tooltip:'Target'},
           {name:'parameter', propID:'parameter', type:'str'},
           {name:'Send memory cursor', propID:'sendMemCurs', type:'checkbox'},
           {name:'Memory cursor parameter name', propID:'memCursParam', type:'str'},
           {name:'Check all parameter name', propID:'checkAllParam', type:'str'},
           {name:'Query filter parameter name', propID:'queryFilterParam', type:'str'},
           {name:'Execute query after routine', propID:'doQryAfterRoutine', type:'checkbox'},
           {name:'Progress bar', propID:'progressBar', type:'checkbox',
            hide_list:{'unchecked':['this.generic_progressBarPortlet']},
            show_list:{'checked':['this.generic_progressBarPortlet']}
           },
           {name:'Progress bar portlet', propID:'progressBarPortlet', type:'str', buttons:'edit,pick', actions:'editPortlet(),selectPortlet()'}
        ],
        view:[
          {name:'visibility',propID:'visibility',type:'select[default,none]', tooltip:'Visibility of the action',
            hide_list:{'row':['this.view_important'],'none':['this.view_important','this.view_hideWhen']},
            show_list:{'default':['this.view_important','this.view_hideWhen'],'row':['this.view_important','this.view_hideWhen']}
          },
          {name:'important',propID:'important',type:'checkbox', tooltip:'Important action'},
          {name:'hide when',propID:'hideWhen',type:'str', tooltip:'Hide action when. The expression is evaluated only for row actions'},
          {name:'show in hamburger menu',propID:'showInMenu',type:'checkbox'}
        ],
        style:[
          {name:'image settings', propID:'image_settings', type:'select[Default:default,Font icon:fontIcon]', tooltip:'image type', section:'image',
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
          {name:'Font',propID:'font_name',type:'str', section:'image'},
          {name:'char', propID:'font_image', type:'str', tooltip:'char',buttons:'pick', actions:'SelectIcons()', section:'image'},
          {name:'size (in px)', propID:'font_size', type:'str', tooltip:'size', section:'image'},
          {name:'color', propID:'font_color', type:'color', tooltip:'color', section:'image'},
          {name:'popup',propID:'popup',type:'checkbox', tooltip:'Popup', section:'Popup', extraClass:'col-3'},
          {name:'popup style', propID:'popup_style', type:'select[by skin,layer,popup]', tooltip:'popup style', section:'Popup', extraClass: 'col-3'},
          {name:'popup width',propID:'popup_width', type:'int', section:'Popup', extraClass:'col-2'},
          {name:'popup height',propID:'popup_height', type:'int', section:'Popup', extraClass:'col-2'},
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
          {name:'image type', propID:'imagetype',type:'select[grid,chart]',tooltip:'select the type of image'},
          {name:'button on tabs (only for supported skins)', propID:'ontabs', type:'checkbox',tooltip:'select to put this item on tabs bar'},
          {name:'button on toolbar (desktop mode is always on toolbar)', propID:'ontoolbar', type:'checkbox',tooltip:'select to put this item on toolbar'},
          {name:'image settings', propID:'image_settings', type:'select[Default:default,Font icon:fontIcon]', tooltip:'image type', section:'image',
          hide_list:{
            'default':['this.generic_font_name','this.generic_font_image','this.generic_font_size','this.generic_font_color'],
            'fontIcon':['this.generic_imagetoolbar']
          },
          show_list:{
            'default':['this.generic_imagetoolbar'],
            'fontIcon':['this.generic_font_name','this.generic_font_image','this.generic_font_size','this.generic_font_color']
          }
        },
          {name:'image', propID:'imagetoolbar', type:'image', tooltip:'select an image'},
          {name:'Font',propID:'font_name',type:'str'},
          {name:'char', propID:'font_image', type:'str', tooltip:'char',buttons:'pick', actions:'SelectIcons()'},
          {name:'size (in px)', propID:'font_size', type:'str', tooltip:'size'},
          {name:'color', propID:'font_color', type:'color', tooltip:'color'},
        ]
      }
    }

    this.PSToolbarAction = [
      { 'id': 'btn_preview'
        , 'class_name': 'btn'
        , 'action': function(){ togglePreview(); }
        , 'image': '../portalstudio/images/icon/btn_preview.png'
        , 'title': 'Go to Preview'
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
      this.id='vpivoteditor';
      this.itemType="vpivoteditor";
      this.type="vpivot";
      this.PrintMode = 'Auto';
      this.PKFields='';
      this.show_btn_update='false';
      this.show_btn_delete='false';
      this.openVdmBeforeQuery='false';
      this.chart_type = 'category';
      this.css_class='drilldown';
     // this.disablePresetParam=disablePresetParam;
     // this.applyAdvancedFilter='false';
     // this.hideFiltersBtn=hideFiltersBtn;
     // this.editableBySmartEditor=editableBySmartEditor;
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
    }
    this.linkedConfigurationObj=function(obj){
      this.objClass = ZTObjects.linkedConfigurationObjClass;
      this.title=obj.title;
      this.linkedConfName=obj.linkedConfName||obj.title;
      this.name=this.linkedConfName;
      this.configname=obj.configname;
      this.configtype=obj.configtype;
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
