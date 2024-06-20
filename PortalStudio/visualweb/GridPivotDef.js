ZTObjects.GridPivotObjClass={
  helper : {
    description : 'Allows you to create a pivot table for multidimensional data analysis.<br>The pivot grid summarizes large amounts of data in a cross-tabular format.<br>The data is grouped into row and column dimensions, with the measured fields.',
    usage : 'This component needs : <ul><li>a DataProvider (SQL Dataprovider, Static Dataprovider, Multi-Level Dataprovider)</li><li>rows dimensions, columns dimensions, and measures</li></ul>'
  },
  newProperties:{
    generic:[],
    style:[
      {name:'css class', propID:'cssClass',		type:'css_class', 	defaultValue:'drilldown', tooltip:"Specify component css class selector<br>if empty, the default value remains 'drilldown'"},
      {name:'css file', propID:'cssFile',			type:'str', 	defaultValue:'styles/GridPivotObj.css', tooltip:"Specify css file<br>if empty, no files will be uploaded"},
      {name:'height behaviour',propID:'scroll_bars',type:'select[grows:false,fixed height:true]', tooltip:"Set the height behaviour", defaultValue:"false"}
    ],
    dimensions_and_measures:[
      {name:'dataobj',			propID:'dataobj',			type:'data',		section:"data object",		tooltip:"Allows you to choose a data object from among those listed"},
      {name:'row',		propID:'rowfields',		type:'select',	dataobjref: 'dataobj',	section:"row dimensions",			tooltip:"Specify row field dimension from DataObj fields",	defaultValue:'',
        buttons:'plus,up,down,del',
        actions: "newMultipleProp({'props':props,tabName:tabName}),upMultipleProp({'props':props,tabName:tabName}),downMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})",
        multiple:{'listview': true, 'type':'combo','id':'rowfields','fillFnc': 'getQueryFieldsFromDataprovider({dataobjref:"dataobj"})' }
      },
      {name:'description',			propID:'rowdescrs',			type:'str',		defaultValue:'',	multiple:{'type':'input','id':'rowfields'},		section:"row dimensions"
        ,tooltip:"Specify row description on pivot"
      },
      {name:'key',					propID:'rowkeys',			type:'str',	defaultValue:'',	multiple:{'type':'input','id':'rowfields'},		section:"row dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify row field key from DataObj fields, to use if there are duplicate values on row dimension"
      },
      {name:'picture',				propID:'rowpictures',		type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'rowfields'},		section:"row dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify picture to apply to value, specially for date field<br>String as SitePainter standard format, or as a function like 'function:fncPicture' where fncPicture has the a signature like fncPicture(value, key) and must return the new value as string"
      },
      {name:'sort order',				propID:'rowsorts',			type:'select[,ascending:asc,descending:desc]',		 defaultValue:'',	multiple:{'type':'input','id':'rowfields'}, section:"row dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify sort on row dimension (asc or desc)"
      },
      {name:'sort by field',			propID:'rowsortsfields',	type:'str', defaultValue:'',	multiple:{'type':'input','id':'rowfields'},		section:"row dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify DataObj field to use for sorting"
      },
      {name:'column',		propID:'columnfields',		type:'select',		dataobjref: 'dataobj', section:"column dimensions",			tooltip:"Specify column field dimension from DataObj fields",	defaultValue:'',
      buttons:'plus,up,down,del',
      actions: "newMultipleProp({'props':props,tabName:tabName}),upMultipleProp({'props':props,tabName:tabName}),downMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})",
        multiple:{'listview': true, 'type':'combo','id':'columnfields','fillFnc': 'getQueryFieldsFromDataprovider({dataobjref:"dataobj"})'}
      },
      {name:'description',			propID:'columndescrs',			type:'str',		defaultValue:'',	multiple:{'type':'input','id':'columnfields'},		section:"column dimensions"
        ,tooltip:"Specify column description on pivot"
      },
      {name:'key',					propID:'columnkeys',			type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'columnfields'},		section:"column dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify column field key from DataObj fields, to use if there are duplicate values on column dimension"
      },
      {name:'picture',				propID:'columnpictures',		type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'columnfields'},		section:"column dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify picture to apply to value, specially for date field<br>String as SitePainter standard format, or as a function like 'function:fncPicture' where fncPicture has the a signature like fncPicture(value, key) and must return the new value as string"
      },
      {name:'sort order',				propID:'columnsorts',			type:'select[,ascending:asc,descending:desc]',		 defaultValue:'',	multiple:{'type':'input','id':'columnfields'},		section:"column dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify sort on column dimension (asc or desc)"
      },
      {name:'sort by field',			propID:'columnsortsfields',		type:'str',		defaultValue:'',	multiple:{'type':'input','id':'columnfields'},		section:"column dimensions",		extraClass:'col-3'
        ,tooltip:"Specify DataObj field to use for sorting"
      },
      {name:'list values',			propID:'columnlistvalues',		type:'str',		defaultValue:'',	multiple:{'type':'input','id':'columnfields'},		section:"column dimensions"
        ,tooltip:"List expected values"
      },
      {name:'measures',		propID:'measurefields',		type:'select',dataobjref: 'dataobj',		section:"measures",			tooltip:"Specify pivot measure fields (all numeric)",	defaultValue:'',
      buttons:'plus,up,down,del',
      actions: "newMultipleProp({'props':props,tabName:tabName}),upMultipleProp({'props':props,tabName:tabName}),downMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})",
        multiple:{'listview': true, 'type':'combo','id':'measurefields','fillFnc': 'getQueryFieldsFromDataprovider({dataobjref:"dataobj"})'}
      },
      {name:'description',				propID:'measuredescrs',				type:'str',		defaultValue:'',	multiple:{'type':'input','id':'measurefields'},		section:"measures",	extraClass:'col-3'
        ,tooltip:"Specify measure description on pivot"
      },
      {name:'conditional format function',			propID:'measurecondformats',		type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'measurefields'},		section:"measures",      extraClass: 'col-3'
        ,tooltip:"Specify conditional formatting function to apply to the cell <br> function as fncFormat(value, objPivot), where value is the measure value, objPivot is a json object with information about row, column, total, ..."
        + "<br>Function can return 'string'; will be apply as css class to the cell"
        + "<br> or json object mapping html standard style attributes; attributes will be apply inline to the cell"
      },
      {name:'picture',					propID:'measurepictures',			type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'measurefields'},		section:"measures",      extraClass: 'col-3'
        ,tooltip:"Specify picture to apply to value, specially for date field<br>String as SitePainter standard format, or as a function like 'function:fncPicture' where fncPicture has the a signature like fncPicture(value) and must return the new value as string"
      },
      {name:'measures position',	propID:'measuresoncolumn',	type:'select[column:true,row:false]',		section:"measures settings",			tooltip:"Specify where integrate measures on pivot, row or column",      extraClass: 'col-2'},
      {name:'measures on row column title',		propID:'measurestitle',			type:'str', 				section:"measures settings", 		tooltip:"Specify measures column title when measures are on row",      extraClass: 'col-2'},
      {name:'hide measures title',	propID:'hidemeasures',	type:'checkbox',		section:"measures settings",			tooltip:"Specify hiding or not measures title row or column",      extraClass: 'col-2'}
      ],
    functional:[
      {name:'data filter',		propID:'canFilter',				type:'checkbox', 	 		    tooltip:"Enable filters on data",	extraClass: 'col-2', section:"filter"},
      {name:'row sorting',		propID:'rowsort',				type:'checkbox', 	section:"sort", 		    tooltip:"Enable change sorting on rows",	extraClass: 'col-2'},
      {name:'column sorting',		propID:'columnsort',			type:'checkbox', 	section:"sort", 		    tooltip:"Enable change sorting on columns",	extraClass: 'col-2'},
      {name:'subtotal row',		propID:'rowsubtotal',			type:'checkbox', 	section:"total", 		tooltip:"Specify if adding subtotal on rows",      extraClass: 'col-2'},
      {name:'subtotal column',		propID:'columnsubtotal',		type:'checkbox', 	section:"total", 		tooltip:"Specify if adding subtotal on columns",      extraClass: 'col-2'},
      {name:'subtotal text',		propID:'subtotaltext',			type:'str', 				section:"total", 		tooltip:"Specify subtotal suffix text (to add to value) as 'value [subtotal text]'",      extraClass: 'col-2'},
      {name:'grand total row',		propID:'rowbigtotal',			type:'checkbox', 	section:"total", 		tooltip:"Specify if adding grand total on rows",      extraClass: 'col-2'},
      {name:'grand total column',		propID:'columnbigtotal',		type:'checkbox', 	section:"total", 		tooltip:"Specify if adding grand total on columns",      extraClass: 'col-2'},
      {name:'grand total text',		propID:'bigtotaltext',			type:'str', 				section:"total", 		tooltip:"Specify grand total text as title for row and column",      extraClass: 'col-2'},
      {name:'print result', propID:'print_result', type:'checkbox', section: 'print', 
          hide_list:{
            'unchecked' :['this.functional_print_model','this.functional_print_grep','this.functional_print_title','this.functional_print_option','this.functional_print_hideexport','this.functional_print_hidesettings'
                         , 'this.functional_print_totals','this.functional_print_size','this.functional_print_outputf','this.functional_print_max','this.functional_print_grep'],
            'checked':[]
          },
          show_list:{
            'checked' :['this.functional_print_model','this.functional_print_grep','this.functional_print_title','this.functional_print_option','this.functional_print_hideexport','this.functional_print_hidesettings'
                       , 'this.functional_print_totals','this.functional_print_size','this.functional_print_outputf','this.functional_print_max','this.functional_print_grep'],
            'unchecked':[]
          }
          , extraClass: 'col-2'
      },
      {name:'print model', propID:'print_model', type:'select[default,pivot,table]', extraClass: 'col-2', section: 'print',
        defaultValue: 'default',
        tooltip:'Select pivot model o table model for printing, as default the pivot model will be used and the print will be as group repeated'
      },
      {name:'print as group repeated', propID:'print_grep', type:'checkbox', extraClass: 'col-2', section: 'print', 
        defaultValue: true,
        tooltip:'As true, the repetead value of columns will not be written'
      },

      {name:'output format', propID:'print_outputf', type:'select[default,PDF,HTML,CSV,CSV Std:CSVS,SDF:CSV2,XML,Struct.XML:XMLS,XLS,XLSX]', section: 'print', tooltip:'Select a fixed output format for the print', extraClass: 'col-2'},
      {name:'print option', propID:'print_option', type:'select[default,preview,print]', extraClass: 'col-2', section: 'print', tooltip:'default: Enable preview and print mode.<br>preview: Enable only preview mode.<br>print: Enable only priny mode.'},
      {name:'print title', propID:'print_title', type:'str', extraClass: 'col-2', section: 'print'},
      //{name:'columns width', propID:'print_size', type:'select[default,columns grid width:grid]', extraClass: 'col-3', section: 'print', tooltip:'default: the width of the column is sized according to the length of the field<br>columns\' grid width: the width of the column is sized according to the referred in grid'},
      {name:'maximized print', propID:'print_max', type:'checkbox', section: 'print', tooltip:'Select for maximed layer', extraClass: 'col-2'},
      //{name:'print totals', propID:'print_totals', type:'checkbox', extraClass: 'col-3', section: 'print', tooltip:'Print totals in default model'},
      {name:'hide export options', propID:'print_hideexport', type:'checkbox', extraClass: 'col-2', section: 'print', tooltip:'Hide mail and download options'},
      {name:'hide settings options', propID:'print_hidesettings', type:'checkbox', extraClass: 'col-2', section: 'print', tooltip:'Hides the option for changing settings '}

    ],
    other_dimensions_and_measures:[
      {name:'UI drag and drop',		propID:'uiDragDrop',				type:'checkbox', 	 		    tooltip:"Enable UI for drag and drop dimensions",
          hide_list:{
            'unchecked' :[
              'this.other_dimensions_and_measures_othDimMeas',
              'this.other_dimensions_and_measures_odimfields',
              'this.other_dimensions_and_measures_odimdescrs',
              'this.other_dimensions_and_measures_odimkeys',
              'this.other_dimensions_and_measures_odimpictures',
              'this.other_dimensions_and_measures_odimsorts',
              'this.other_dimensions_and_measures_odimlistvalues',
              'this.other_dimensions_and_measures_odimsortsfields',
              'this.other_dimensions_and_measures_omeasfields',
              'this.other_dimensions_and_measures_omeasdescrs',
              'this.other_dimensions_and_measures_omeascondformats',
              'this.other_dimensions_and_measures_omeaspictures'
              ],
            'checked':[]
        },
        show_list:{
          'checked' :[
            'this.other_dimensions_and_measures_othDimMeas',
            'this.other_dimensions_and_measures_odimfields',
              'this.other_dimensions_and_measures_odimdescrs',
              'this.other_dimensions_and_measures_odimkeys',
              'this.other_dimensions_and_measures_odimpictures',
              'this.other_dimensions_and_measures_odimsorts',
              'this.other_dimensions_and_measures_odimlistvalues',
              'this.other_dimensions_and_measures_odimsortsfields',
              'this.other_dimensions_and_measures_omeasfields',
              'this.other_dimensions_and_measures_omeasdescrs',
              'this.other_dimensions_and_measures_omeascondformats',
              'this.other_dimensions_and_measures_omeaspictures'
          ],
          'unchecked':[]
        }
      },
      {name:'others dimensions and measures',		propID:'othDimMeas',				type:'checkbox', 	 		   tooltip:"Enable other dimensions and measures", defaultValue:true,
        hide_list:{
            'unchecked' :[
              'this.other_dimensions_and_measures_odimfields',
              'this.other_dimensions_and_measures_odimdescrs',
              'this.other_dimensions_and_measures_odimkeys',
              'this.other_dimensions_and_measures_odimpictures',
              'this.other_dimensions_and_measures_odimsorts',
              'this.other_dimensions_and_measures_odimlistvalues',
              'this.other_dimensions_and_measures_odimsortsfields',
              'this.other_dimensions_and_measures_omeasfields',
              'this.other_dimensions_and_measures_omeasdescrs',
              'this.other_dimensions_and_measures_omeascondformats',
              'this.other_dimensions_and_measures_omeaspictures'
              ],
            'checked':[]
        },
        show_list:{
          'checked' :[
            'this.other_dimensions_and_measures_odimfields',
              'this.other_dimensions_and_measures_odimdescrs',
              'this.other_dimensions_and_measures_odimkeys',
              'this.other_dimensions_and_measures_odimpictures',
              'this.other_dimensions_and_measures_odimsorts',
              'this.other_dimensions_and_measures_odimlistvalues',
              'this.other_dimensions_and_measures_odimsortsfields',
              'this.other_dimensions_and_measures_omeasfields',
              'this.other_dimensions_and_measures_omeasdescrs',
              'this.other_dimensions_and_measures_omeascondformats',
              'this.other_dimensions_and_measures_omeaspictures'
          ],
          'unchecked':[]
        }
      },
      {name:'other dimension',		propID:'odimfields',		type:'select',		dataobjref: 'dataobj', section:"other dimensions",			tooltip:"Specify other field dimension from DataObj fields",	defaultValue:'',
      buttons:'plus,up,down,del',
      actions: "newMultipleProp({'props':props,tabName:tabName}),upMultipleProp({'props':props,tabName:tabName}),downMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})",
        multiple:{'listview': true, 'type':'combo','id':'odimfields','fillFnc': 'getQueryFieldsFromDataprovider({dataobjref:"dataobj"})'}
      },
      {name:'description',			propID:'odimdescrs',			type:'str',		defaultValue:'',	multiple:{'type':'input','id':'odimfields'},		section:"other dimensions"
        ,tooltip:"Specify other dimension description on pivot"
      },
      {name:'key',					propID:'odimkeys',			type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'odimfields'},		section:"other dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify other dimension field key from DataObj fields, to use if there are duplicate values on other dimension"
      },
      {name:'picture',				propID:'odimpictures',		type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'odimfields'},		section:"other dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify picture to apply to value, specially for date field<br>String as SitePainter standard format, or as a function like 'function:fncPicture' where fncPicture has the a signature like fncPicture(value, key) and must return the new value as string"
      },
      {name:'sort order',				propID:'odimsorts',			type:'select[,ascending:asc,descending:desc]',		 defaultValue:'',	multiple:{'type':'input','id':'odimfields'},		section:"other dimensions",      extraClass: 'col-3'
        ,tooltip:"Specify sort on other dimension (asc or desc)"
      },
      {name:'sort by field',			propID:'odimsortsfields',		type:'str',		defaultValue:'',	multiple:{'type':'input','id':'odimfields'},		section:"other dimensions",		extraClass:'col-3'
        ,tooltip:"Specify DataObj field to use for sorting"
      },
      {name:'list values',			propID:'odimlistvalues',		type:'str',		defaultValue:'',	multiple:{'type':'input','id':'odimfields'},		section:"other dimensions"
        ,tooltip:"List expected values"
      },
	  
      {name:'other measure',		propID:'omeasfields',		type:'select',dataobjref: 'dataobj',		section:"other measures",			tooltip:"Specify pivot measure fields (all numeric)",	defaultValue:'',
      buttons:'plus,up,down,del',
      actions: "newMultipleProp({'props':props,tabName:tabName}),upMultipleProp({'props':props,tabName:tabName}),downMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})",
        multiple:{'listview': true, 'type':'combo','id':'omeasfields','fillFnc': 'getQueryFieldsFromDataprovider({dataobjref:"dataobj"})'}
      },
      {name:'description',				propID:'omeasdescrs',				type:'str',		defaultValue:'',	multiple:{'type':'input','id':'omeasfields'},		section:"other measures"
        ,tooltip:"Specify other measure description on pivot"
      },
      {name:'conditional format function',			propID:'omeascondformats',		type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'omeasfields'},		section:"other measures",      extraClass: 'col-3'
        ,tooltip:"Specify conditional formatting function to apply to the cell <br> function as fncFormat(value, objPivot), where value is the measure value, objPivot is a json object with information about row, column, total, ..."
        + "<br>Function can return 'string'; will be apply as css class to the cell"
        + "<br> or json object mapping html standard style attributes; attributes will be apply inline to the cell"
      },
      {name:'picture',					propID:'omeaspictures',			type:'str',		 defaultValue:'',	multiple:{'type':'input','id':'omeasfields'},		section:"other measures",      extraClass: 'col-3'
        ,tooltip:"Specify picture to apply to value, specially for date field<br>String as SitePainter standard format, or as a function like 'function:fncPicture' where fncPicture has the a signature like fncPicture(value) and must return the new value as string"
      }
    ]
  },
  names : ['images/bot_pivot.png','images/gridpivot.svg'],
  events : [
	{ name:'Click', tooltip:'Event dispatched when clicking on pivot element', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'the event returned', type: 'event object'},
        {name: 'item', tooltip: 'item is an object containing the information of the clicked element', type: 'object'}
      ]
    },
	{ name:'DrillDown', tooltip:'Event dispatched when drill-down on pivot element', usage:'', returnValue:'',
      parameters : [
        {name: 'event', tooltip: 'the event returned', type: 'event object'},
        {name: 'obj', tooltip: 'obj is an object containing the information about drill-down', type: 'object'}
      ]
    },
	{ name:'Rendered', tooltip:'Event dispatched the pivot element is rendered', usage:'', returnValue:'',
      parameters : []
    }
  ],
  functions : [
	  { name:'DrillDownRow(obj)', tooltip:'Execute drill down on row (open or close)', usage:'Once the pivot is drawn, it allows you to perform a row drill down', returnValue:'', signature: 'DrillDownRow({\n  \'row1\':\'value1\',\n  \'row2\':\'value2\'\n }\n)',
      parameters : [
        {name: 'obj', tooltip: 'js object with attribute-value, where attribute corresponds to a row dimension, and value is the value of the attribute, for example state: {\'Italy\', province: \Lombardy\', ...}', type:'Object', optional:false}
      ]
    },
	  { name:'DrillDownColumn(obj)', tooltip:'Execute drill down on column (open or close)', usage:'Once the pivot is drawn, it allows you to perform a column drill down', returnValue:'', signature: 'DrillDownColumn({\n  \'col1\':\'value1\',\n  \'col2\':\'value2\'\n }\n)',
      parameters : [
        {name: 'obj', tooltip: 'js object with attribute-value, where attribute corresponds to a column dimension, and value is the value of the attribute, for example state: {\'Italy\', province: \Lombardy\', ...}', type:'Object', optional:false}
      ]
    },
	  { name:'EnableSortOnRows', tooltip:'Enable or disable sort on rows', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "true for enable sorting, false otherwise", type:'boolean', optional:false}
      ]
    },
    { name:'EnableSortOnColumns',	tooltip:'Enable or disable sort on columns',	usage:'Use for grid pivot configuration before drawing',	returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "true for enable sorting, false otherwise", type:'boolean', optional:false}
      ]
    },
	  { name:'SetDataProvider(dataproviderCtrl)', signature:'SetDataProvider(this[\'dataprovider_name\'])', tooltip:'Set dataprovider object', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'dataproviderCtrl', tooltip: "dataprovider control object", type:'object', optional:false}
      ]
    },
	  { name:'SetMeasuresOnColumns', tooltip:'Enable/Disable measures integration on columns/rows', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "true for enable measures integration on columns, false for enable measures integration on rows", type:'boolean', optional:false}
      ]
    },
    { name:'SetFilter', tooltip:'Enable/Disable filter on data', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "true for enable filtering on data", type:'boolean', optional:false}
      ]
    },
    { name:'SetUIDragAndDrop', tooltip:'Enable/Disable configuration dimensions UI drag and drop', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "true for enable UI drag and drop configuration dimensions", type:'boolean', optional:false}
      ]
    },
    { name:'SetOtherDimensions', tooltip:'Enable/Disable other dimensions UI drag and drop', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'enable', tooltip: "true for enable UI drag and drop for other dimensions", type:'boolean', optional:false}
      ]
    },
	  { name:'SetSubTotals', tooltip:'Set sub-title, enable or disable sub totals on rows and columns', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
		    {name: 'subtitle', tooltip: 'subtotal suffix text (to add to value) as \'value [subtotal text]\'', type:'string', optional:false},
        {name: 'enable_row', tooltip: "true for enable subtotals on rows", type:'boolean', optional:false},
		    {name: 'enable_column', tooltip: "true for enable subtotals on columns", type:'boolean', optional:false}
      ]
    },
	  { name:'SetGrandTotals', tooltip:'Set title, enable or disable grand totals on rows and columns', usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
		    {name: 'title', tooltip: 'grand total text as title for row and column', type:'string', optional:false},
        {name: 'enable_row', tooltip: "true for enable grand totals on rows", type:'boolean', optional:false},
		    {name: 'enable_column', tooltip: "true for enable grand totals on columns", type:'boolean', optional:false}
      ]
    },
    { name:'AddRowField', signature:'AddRowField({\n  \'field\':\'alias\',\n  \'title\':\'desc\',\n  \'key\':\'key\',\n  \'picture\':\'pict\',\n  \'sorting\':{\'order\':\'order (desc or asc)\', \'field\':\'byfield\'}\n})', 
      tooltip:'Add row dimension object', 
      usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'rowObject', tooltip: "js object to add to rows dimensions", type:'object', optional:false}
      ]
    },
    { name:'AddColumnField', signature:'AddColumnField({\n  \'field\':\'alias\',\n  \'title\':\'desc\',\n  \'key\':\'key\',\n  \'picture\':\'pict\',\n  \'sorting\':{\'order\':\'order (desc or asc)\', \'field\':\'byfield\'} ,\n  \'listvalues\':\'value1,value2\' \n})', 
      tooltip:'Add column dimension object', 
      usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'columnObject', tooltip: "js object to add to columns dimensions", type:'object', optional:false}
      ]
    },
    { name:'AddMeasureField', signature:'AddMeasureField({\n  \'field\':\'alias\',\n  \'title\':\'desc\',\n  \'format_func\':\'funcstr\',\n  \'picture\':\'pict\'\n})', 
      tooltip:'Add measure object', 
      usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'measureObject',	tooltip: "js object to add measure",	type:'object',	optional:false}
      ]
    },
    { name:'AddOtherDimension', signature:'AddOtherDimension({\n  \'field\':\'alias\',\n  \'title\':\'desc\',\n  \'key\':\'key\',\n  \'picture\':\'pict\',\n  \'sorting\':{\'order\':\'order (desc or asc)\', \'field\':\'byfield\'},\n  \'listvalues\':\'value1,value2\' \n})', 
      tooltip:'Add other dimension object', 
      usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'dimObject', tooltip: "js object to add to other dimensions", type:'object', optional:false}
      ]
    },
    { name:'AddOtherMeasure', signature:'AddOtherMeasure({\n  \'field\':\'alias\',\n  \'title\':\'desc\',\n  \'format_func\':\'funcstr\',\n  \'picture\':\'pict\'\n})', 
      tooltip:'Add other measure object', 
      usage:'Use for grid pivot configuration before drawing', returnValue:'',
      parameters : [
        {name: 'measureObject',	tooltip: "js object to add other measures",	type:'object',	optional:false}
      ]
    },
    {
      name:'RedrawDimensions',signature:'RedrawDimensions([row1,row2], [column1,column2], [measure1,measure2])',
      tooltip:'Reset and redraw pivot with new dimensions', 
      usage:'Use for grid pivot after drawing', returnValue:'',
      parameters : [
        {name: 'rowsArrayList',	tooltip: "Array list of rows",	type:'object',	optional:false},
        {name: 'columnsArrayList',	tooltip: "Array list of columns",	type:'object',	optional:false},
        {name: 'measuresArrayList',	tooltip: "Array list of rows",	type:'object',	optional:false}
      ]
    },
    { name:'GetJSONViewData', signature:'GetJSONViewData()', 
      tooltip:'Retrieve json array of viewing data', 
      usage:'Use for grid pivot after drawing', returnValue:'json array',
      parameters : [
      ]
    },
    { name:'ShowHideFields', signature:'ShowHideFields()', 
      tooltip:'Show or Hide Fields for drag and drop, filtering...', 
      usage:'Use for grid pivot after drawing', returnValue:'',
      parameters : [
      ]
    } ,
    { name:'SetMeasuresOptions', signature:'ShowHideFields()', 
      tooltip:'Set measures settings', 
      usage:'Use for grid pivot before drawing', returnValue:'',
      parameters : [
        {name: 'onColumn',	tooltip: "As true, measures will be in column, otherwise in row",	type:'boolean',	optional:false},
        {name: 'hideTitle',	tooltip: "As true, mMeasures title will be hide",	type:'boolean',	optional:false},
        {name: 'measuresTitle',	tooltip: "Title shown for measures on row",	type:'string',	optional:false}
      ]
    }
  ],
  wireframe: function(/*obj*/){
    return "<div style='background-image:url(images/gridpivot.svg);background-size:100% 100%;overflow:hidden;width:100%;height:100%;'></div>";
  },
  notifications: function(obj){
	obj.notifications = [];
	if (Empty(obj.dataobj)) {
      obj.notifications.push({'message':'Select a dataobj.', 'tab':'dimensions_and_measures', 'prop':'dataobj'});
    }
	if (Empty(obj.rowfields)) {
      obj.notifications.push({'message':'Specify rows dimensions.', 'tab':'dimensions_and_measures', 'prop':'rowfields'});
    }
	if (Empty(obj.columnfields)) {
      obj.notifications.push({'message':'Specify columns dimensions.', 'tab':'dimensions_and_measures', 'prop':'columnfields'});
    }
	if (Empty(obj.measurefields)) {
      obj.notifications.push({'message':'Select measures.', 'tab':'dimensions_and_measures', 'prop':'measurefields'});
    }
  }
};
ZTObjects.extend( ZTObjects.stdVisibleObjClass , ZTObjects.GridPivotObjClass );

function initPropertiesDefaultValue(obj) {
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = [];
    var tab, ii, i;
    for (i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        mainObject[tab[ii].propID] = tab[ii].defaultValue;
      }
    }
  }
}

ZTObjects.GridPivotObj=function(id,name,type,html,value,shadow,x,y,h,w) {
	this.objClass = ZTObjects.GridPivotObjClass;
	initPropertiesDefaultValue(this);
	this.id = id;
	this.name = name;
	this.type = type;
	this.html = html;
	this.value = value;
	this.shadow = shadow;
	this.sequence = '';
	this.x = x;
	this.y = y;
	this.h = h;
	this.w = w;
	this.cssClass = 'drilldown';
  this.cssFile = 'styles/GridPivotObj.css';
	this.author='Zucchetti SitePainter';
	this.GetFieldsConfig = function()  {
		var ret = {};
		ret.rows = this.rowfields;
		ret.columns = this.columnfields;
		ret.measures = this.measurefields;
    ret.rowskeys = this.rowkeys;
    ret.columnskeys = this.columnkeys;
		return ret;
	}
	this.layout_steps_values = [];
}
ZTObjects.GridPivotObj.prototype = new ZTObjects.stdVisibleObj;