ZTObjects.chartObjClass = {
  helper : {
    description : 'Drawing a graphic object in the document using a chart definition and a query',
    usage : 'Fill the Chart def file, and complete object definition filling the "Dataset" tab options'
  },
  newProperties:{
    generic:[
      {name:'chart def file',			propID:'def',			type:'chartdef',	validFunc:'checkChartDef',	tooltip:'Chart file',		defaultValue:''},
      {name:'type', propID:'ctype', type:'str', disabled: true}
    ],
    layout:[],
    print_options:[],
    dataset:[
      {name:'query',					propID:'query',			type:'str',					validFunc:'validQueryIndex',		tooltip:'Name of alternative query',		defaultValue:''},
      {name:'re execute',		propID:'reexecute',		type:ZTObjects.reexecute_select,	tooltip:'Re excecute query',			defaultValue:'false'
        ,hide_list:{'true':['this.dataset_exp'],'false':['this.dataset_value_params','this.dataset_value_expr']}
        ,show_list:{'true':['this.dataset_value_params','this.dataset_value_expr'],'false':['this.dataset_exp']}
      },
      {name:'expression',					propID:'exp',			type:'exp',							tooltip:'Expression to alternate over',		defaultValue:''},
      {name:'parameters',			propID:'value_params',			type:'str',			buttons:'edit',			actions:'LoadQP()'		
        ,tooltip:'List of query parameters',			defaultValue:''},
      {name:'values',			propID:'value_expr',			type:'str',			buttons:'edit',			actions:'LoadQP()'		
        ,tooltip:'List of query parameters value',			defaultValue:''}
    ],
    fields:[
      {name:'chart type', propID:'chart_type',type:'select[Category chart:category,XYZ chart:xyz,Measure chart:measure,Geographic chart:geo,hie,dep]', defaultValue:'',
        hide_list:{
          'category':['this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_min_field','this.fields_max_field','this.fields_val_field','this.fields_measure_series_field','this.fields_formula_name','this.fields_formula','this.fields_help_tips','this.fields_xKey_field','this.fields_measureKey_series_field','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class','this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'xyz':['this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_formula_name','this.fields_formula','this.fields_help_tips','this.fields_min_field','this.fields_max_field','this.fields_val_field','this.fields_measure_series_field','this.fields_labelKey_field','this.fields_measureKey_series_field','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level','this.fields_sfield','this.fields_sfieldlabel','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class','this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'measure':['this.fields_formula_name','this.fields_formula','this.fields_help_tips','this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_xKey_field','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level','this.fields_val_field','this.fields_measure_series_field','this.fields_measureKey_series_field','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class','this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'geo':['this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_formula_name','this.fields_formula','this.fields_help_tips','this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_labelKey_field','this.fields_xKey_field','this.fields_min_field','this.fields_max_field','this.fields_val_field','this.fields_measure_series_field','this.fields_measureKey_series_field','this.fields_sfield','this.fields_sfieldlabel','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class','this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'hie':['this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_labelKey_field','this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_xKey_field','this.fields_min_field','this.fields_max_field','this.fields_sfield','this.fields_sfieldlabel','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class','this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'dep':['this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_labelKey_field','this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_xKey_field','this.fields_min_field','this.fields_max_field','this.fields_sfield','this.fields_sfieldlabel','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'PCOORDS':['this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_label_field','this.fields_formula_name','this.fields_formula','this.fields_help_tips','this.fields_min_field','this.fields_max_field','this.fields_val_field','this.fields_measure_series_field','this.fields_labelKey_field','this.fields_measureKey_series_field','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class'
                        ,'this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords'],
          'VORONOI':['this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_formula_name','this.fields_formula','this.fields_help_tips','this.fields_min_field','this.fields_max_field','this.fields_val_field','this.fields_measure_series_field','this.fields_labelKey_field','this.fields_measureKey_series_field','this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level','this.fields_sfield','this.fields_sfieldlabel','this.fields_fieldpath','this.fields_fieldvalue'
                        ,'this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class']
        },
        show_list:{
          'category':['this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_labelKey_field','this.fields_sfield','this.fields_sfieldlabel'],
          'xyz':['this.fields_x_field','this.fields_y_field','this.fields_z_field','this.fields_xyz_series_field','this.fields_xKey_field'],
          'measure':['this.fields_label_field','this.fields_value_fields','this.fields_value_labels','this.fields_min_field','this.fields_max_field','this.fields_labelKey_field','this.fields_sfield','this.fields_sfieldlabel'],
          'geo':['this.fields_geo_0_field','this.fields_geo_1_field','this.fields_geo_value_field','this.fields_geo_dom_field','this.fields_geo_view','this.fields_geo_level'],
          'hie':['this.fields_fieldpath','this.fields_fieldvalue'],
          'dep':['this.fields_depfield_1','this.fields_depfield_2','this.fields_depvalue','this.fields_depclass','this.fields_depfield_1label','this.fields_depfield_2label','this.fields_depfield_1class','this.fields_depfield_2class'],
          'PCOORDS':['this.fields_sfield','this.fields_sfieldlabel','this.fields_value_fields','this.fields_value_labels'],
          'VORONOI':['this.fields_voro_class','this.fields_voro_cat','this.fields_voro_coords']
        }
        , tooltip:"Allows you to choose the chart type inserted from among those listed"
        , validFunc:'checkChartType'
        , disabled: true
      },
      {name:'labels and fields type',			propID:'valueparameter',	type:'select[query fields:false,from request:true]',	tooltip:'When expression, labels and fields as report parameters - must be values list with || as separator',	defaultValue:'false'},
      {name:'key field(s) for domain',	propID:'labelKey_field',		type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'', section:'X axis/categories and series'},
      {name:'labels for domain field(s)',	propID:'label_field',		type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will be placed as chart's domain", section:'X axis/categories and series'},
      {name:'series field', propID:'sfield',  type:'str', defaultValue:'', tooltip:"", section:"X axis/categories and series"},
      {name:'labels for series field', propID:'sfieldlabel',  type:'str', defaultValue:'', tooltip:"", section:"X axis/categories and series"},
      {name:'hierarchy path fields list',	propID:'fieldpath',	type:'str',	tooltip:"Indicates the fields (comma separated) that will be compose the hierarchy path",	section:"hierarchy fields"},
      {name:'value numeric field',	propID:'fieldvalue',	type:'str',	tooltip:"This field contains the numeric value to be represented",	section:"hierarchy fields"},
      {name:'first field key',	propID:'depfield_1',	type:'str',	extraClass:"col-3",	tooltip:"",	section:"Dependencies fields (relationships)"},
      {name:'first field label',	propID:'depfield_1label',	type:'str',	extraClass:"col-3",	tooltip:"",	section:"Dependencies fields (relationships)"},
      {name:'first classification field',	propID:'depfield_1class',	type:'str',	tooltip:"",	section:"Dependencies fields (relationships)"},
      {name:'second field key',	propID:'depfield_2',	type:'str',	extraClass:"col-3",	tooltip:"",	section:"Dependencies fields (relationships)"},
      {name:'second field label',	propID:'depfield_2label',	type:'str',	extraClass:"col-3",	tooltip:"",	section:"Dependencies fields (relationships)"},
      {name:'second classification field',	propID:'depfield_2class',	type:'str',	tooltip:"",	section:"Dependencies fields (relationships)"},
      {name:'value numeric field',	propID:'depvalue',	type:'str',	tooltip:"This field contains the numeric value to be represented",	section:"Dependencies fields (relationships)"},
      {name:'nodes classification',	propID:'depclass',	type:'str',	tooltip:"This property contains a configuration string for each node on chart (eg. node_name;node_type|....)",	section:"Dependencies fields (relationships)"},
      {name:'nodes classification', propID:'voro_class',  type:'str', tooltip:"", section:"Nodes"},
      {name:'nodes key field', propID:'voro_cat',  type:'str', tooltip:"", section:"Nodes"},
      {name:'nodes coordinates', propID:'voro_coords',  type:'str', tooltip:"", section:"Nodes"},
      {name:'value field(s)',	propID:'value_fields',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the fields that will be placed as chart's series", section:'y axis/values'},
      {name:'labels for value field(s)',	propID:'value_labels',	type:'str', buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates value fields' label", section:'y axis/values'},	
      {name:'formula name',	propID:'formula_name',	type:'str',	disabled:true,	defaultValue:''},
      {name:'formula',			propID:'formula',				type:'str',	disabled:true,	defaultValue:''},
      {name:'help tips',		propID:'help_tips',			type:'str',	disabled:true,	defaultValue:''},
      {name:'X axis field',	propID:'x_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will be placed as chart's domain", section:'XYZ axis'},
      {name:'Y axis field',	propID:'y_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will be setted as the Y axis dimension", section:'XYZ axis'},
      {name:'Z axis field (radius for Bubble Chart)',	propID:'z_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will be represented as the Z (3rd) axis dimension", section:'XYZ axis'},
      {name:'series field',	propID:'xyz_series_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will be placed as chart's series", section:'series'},
      {name:'key field for series',	propID:'xKey_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'', section:'series'},   
      {name:'minimum values field',	propID:'min_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will contain the minimum value for each data-interval evaluation", section:'values'},
      {name:'maximum values field',	propID:'max_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will contain the maximum value for each data-interval evaluation", section:'values'},
      {name:'value numeric field',	propID:'val_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will contain data value",	disabled:true},
      {name:'series field',	propID:'measure_series_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	tooltip:"Indicates the field that will be placed as chart's domain serie", disabled: true},
      {name:'series key field',	propID:'measureKey_series_field',	type:'str',	buttons:'edit',	actions:'LoadFieldsConfigurator()',		defaultValue:'',	disabled:true},
      {name:'Country field',	propID:'geo_0_field',	type:'str',	defaultValue:'',	tooltip:"This field indicates the country to be represent (eg. IT, US, Great Britain, Spain)", section:"geographic fields"},
      {name:'country administrative subdivision field',	propID:'geo_1_field',	type:'str',	defaultValue:'',	tooltip:"This field indicates the country's subdivision to be represent (eg. for Italy, '55' represent Lombardia - 'LO' represent province of Lodi - 'F205' represent Milan)", section:"geographic fields"},
      {name:'subdivision level', propID:'geo_level',  type:'select[country:0,first:1,second:2,third:3,local:loc]', tooltip:"For IT country: 0 - stato, 1 - regioni, 2 - province, 3 - comuni, locale - area (nord/centro/sud)<br>Others countries: 0 - country, 1/2/3 - 1st/2nd/3rd administrative subdivision", section:"geographic fields"},
      {name:'Map view choice',	propID:'geo_view',	type:'str',	defaultValue:'', tooltip: "This field is optional; if specified, it represent chart's start view (eg. Italy or IT)", section:"geographic fields"},
      {name:'Value numeric field',	propID:'geo_value_field',	type:'str', defaultValue:'',	tooltip:"This field contains the numeric value to be represented", section:"values"},
      {name:'Grouping series field',	propID:'geo_dom_field',	type:'str', defaultValue:'',	tooltip:"This field is optional; if specified, will be placed as chart's series", section:"series"}
    ],
    titles:[
      {name:'title',				propID:'title',					type:'str',		defaultValue:'',	tooltip:"Set chart title"},
      {name:'subtitle',				propID:'subtitle',					type:'str',	defaultValue:'',	tooltip:"Set chart subtitle"},
      {name:'series title',	propID:'titleSeries',	type:'str',		defaultValue:'',	tooltip:"Set series title"},
      {name:'domain axis title (x axis label)',			propID:'x_label',				type:'str',		defaultValue:'',	tooltip:"Set X (domain) axis label", section:'axis'},
      {name:'value axis title (y axis label)',			propID:'y_label',				type:'str',		defaultValue:'',	tooltip:"Set Y (value) axis label", section:'axis'},
      {name:'percent axis title (PARETO)',			propID:'percent_label',				type:'str',	defaultValue:'',	tooltip:"Set percent axis label", section:'pareto'}
    ],
    overwrite:[
      {name:'data order',					propID:'data_order',			type:'select[default:,row:row,column:column]',	defaultValue:'',	tooltip:"Allows you to choose the order of the dataset on chart",	section:'starting settings',	extraClass:"col-3"},
      {name:'focuskey',	propID:'focuskey',	type:'str',	defaultValue:'',	tooltip:"Allows you to highlight some elements on the chart",	section:'starting settings',	extraClass:"col-3"},
      {name:'legend', propID:'legend',	type:'select[default,hide,top,bottom,left,right]',	defaultValue:'default',	tooltip:"Allows you to overwrite legend position", section:'legend'},
      {name:'min value',	propID:'xmin_value',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the minimum value",	extraClass:"col-2",	section:'domain numeric axis'},
      {name:'max value',	propID:'xmax_value',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the maximum value",	extraClass:"col-2",	section:'domain numeric axis'},
      {name:'tick unit',	propID:'xtick_unit',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the axis tick unit",	extraClass:"col-2",	section:'domain numeric axis'},
      {name:'reference line',	propID:'xrefline',	type:'int',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'domain numeric axis'},
      {name:'reference line color',	propID:'xreflinecol',	type:'color',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'domain numeric axis'},
      {name:'min value',	propID:'min_value',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the minimum value",	extraClass:"col-2", section:'value axis'},
      {name:'max value',	propID:'max_value',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the maximum value",	extraClass:"col-2", section:'value axis'},
      {name:'tick unit',	propID:'tick_unit',	type:'int',	defaultValue:'',	tooltip:"Allows you to overwrite the axis tick unit",	extraClass:"col-2", section:'value axis'},
      {name:'reference line',	propID:'refline',	type:'int',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'value axis'},
      {name:'reference line color',	propID:'reflinecol',	type:'color',	defaultValue:'',	tooltip:"Allows you to set the reference value",	extraClass:"col-3",	section:'value axis'},
      {name:'value labels',	propID:'ovalue_labels',	type:'select[default,show,hide]',	defaultValue:'default',	tooltip:"Allows you to overwrite value labels position", section:'others'},
      {name:'date limit data load',	propID:'dataload_datelimit',	type:'str',	defaultValue:'',	tooltip:"Allows you to set a draw data limit (datetime)", section:'others'}
    ]
  }
};
ZTObjects.chartObjClass._GetChartProps = function (/* type, macro_type*/) {}

ZTObjects.extend( ZTObjects.stdObjClass, ZTObjects.chartObjClass );
ZTObjects.extend( ZTObjects.stdObjPrivacyClass, ZTObjects.chartObjClass, true );
ZTObjects.extend( ZTObjects.stdObjOptPrintClass, ZTObjects.chartObjClass );
ZTObjects.extend( ZTObjects.stdObjOutHyperLinkClass, ZTObjects.chartObjClass );
ZTObjects.extend( ZTObjects.stdObjNoteClass, ZTObjects.chartObjClass );

ZTObjects.chartObj = function(id, name, type, value, shadow, x, y, h, w) {
  this.objClass = ZTObjects.chartObjClass;
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
  this.uid = Upper(AlfaKeyGen(10));
  this.sequence = nAllItems;
  this.page = 1;

  //Hyperlink
  this.link_parameters = ""; //serve per evitare un errore in apertura della finestra keysvalue_edit.html

  //Non visibili
  this.scale = 100;
  this.show = true;
  this.html = "<img id=\'" + this.id + "' src='" + getObjImg('Chart') + "' style=\'border:1px solid #f3f3f3;z-index:2;width:50px;height:50px;position:absolute;top:" + this.y + "px;left:" + this.x + "px;\' onclick=\'clickItem(event)\'>";
};

ZTObjects.chartObj.prototype.writeDef = function () {
  var strsave = writeStandardDef(this);
  return strsave;
};

ZTObjects.chartObj.prototype.readDef = function (def) {
  readStandardDef(def);
};

ZTObjects.chartObj.prototype.readJsonDef = function (def) {
  readStandardJsonDef(def);
  //conversione - measure in category
  if( this.chart_type == 'measure' && !Empty( this.val_field )) {
    this.value_fields = this.val_field;
    this.val_field = "";
    this.labelKey_field = this.measureKey_series_field;
    this.measureKey_series_field = "";
    this.label_field = this.measure_series_field;
    this.measure_series_field = "";
  }
};

ZTObjects.chartObj.prototype.getKeys = function() {
  return this.link_parameters;
};

ZTObjects.chartObj.prototype.getValues = function() {
  return this.link_parameters_value;
};

ZTObjects.chartObj.prototype.getKeysLabels = function() {
  return this.value_labels;
};

ZTObjects.chartObj.prototype.getValuesFields = function() {
  return this.value_fields;
};

ZTObjects.chartObj.prototype.getQPKeys = function() {
  return this.value_params;
};

ZTObjects.chartObj.prototype.getQPValues = function() {
  return this.value_expr;
};