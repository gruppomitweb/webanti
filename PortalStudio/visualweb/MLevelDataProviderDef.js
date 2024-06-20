/* exported wizardconfig SetMLevelConfiguration */

ZTObjects.MLevelDataProviderObjClass={
	helper : {
		usage : 
		'It was born first as a support to the Grid Pivot component, where there is the need to find the data only if required, to avoid heavy server-side data extraction.'
		+ '<br>Queries are performed by grouping the data with any required calculations (... at the moment sum on the fields ...).'
		+ '<br>By increasing the depth levels of the queries (... typically, drilldown ...), filters are added.'
		,
		description : 
		'Allows the definition of queries (1 or more) to be executed based on the level of the data to be extracted.'
		+ '<br>The first query can be performed with multiple data levels (without filters) and client-side caching.'
		+ '<br>At this point, the data will be retrieved directly on the client, until the pre-load limit level is exceeded.'
		,
		drawing :
		{
			src:'../portalstudio/images/component/multi-level-dataprovider-helper.png',
			width:'350px'
		}
	},
	newProperties:{
		generic:[
		], 
		functional:[
				/*{name:'exec mode', 		propID:'auto_exec', 	type:'select[client autoexec :true,client ondemand:false]', extraClass: 'col-3'},
				{name:'async query', 	propID:'async', 	type:'select[false,true]', extraClass: 'col-3'},*/
				{name:'query',			propID:'queries',			type:'str', section:'datasources', defaultValue:''
					,buttons:'wizard,plus,edit,up,down,del'
					,actions: "wizardconfig(this),newMultipleProp({'props':props,tabName:tabName}),editMultipleProp({'props':props,tabName:tabName}),upMultipleProp({'props':props,tabName:tabName}),downMultipleProp({'props':props,tabName:tabName}),delMultipleProp({'props':props,tabName:tabName})" 
					,multiple:{'listview': true, 'type':'combo','id':'queries'}
					,tooltip:"Specify query (vqr) name"
				},
				{name:'Row level limit',	propID:'uptolevels',	type:'int', section:'datasources', defaultValue:''
					,multiple:{'type':'input','id':'queries'}
					,tooltip:"Indicates to what level dimension on row this query is used"
				},
				{name:'Column level limit',	propID:'uptolevels2',	type:'int', section:'datasources', defaultValue:''
					,multiple:{'type':'input','id':'queries'}
					,tooltip:"Indicates to what level dimension on column this query is used"
				},
				{name:'param. source', 	propID:'parms_source', 	type:'str', section:'parameters', tooltip:'one or more parameter sources can be specified'},
				{name:'parameters',   	propID:'parms', 		type:'parameters', section:'parameters', tooltip: 'Comma-separated list of parameters to be used as a filter for DataObject extraction.'},
				{name:'rows fields',			propID:'filterfields',	type:'str', section:'row dimensions'
					,tooltip:"Indicates the progressive and ordered grouping dimensions<br>if empty, inherits values from a compatible object, such as the GridPivot for example"
				},
				{name:'rows fields keys',		propID:'filterfieldskeys',	type:'str', section:'row dimensions'
					,tooltip:"Indicates the progressive and ordered grouping dimensions<br>if empty, inherits values from a compatible object, such as the GridPivot for example"
				},
				{name:'Prefetched row fields on first query',	propID:'cachelevel', type:'int', section:'row dimensions', defaultValue:''
					,tooltip:"Indicates up to how many rows aggregated dimensions will be included on the the first query cached client-side"
				},
				{name:'columns fields',			propID:'fields',		type:'str', section:'column dimensions'
					,tooltip:"Indicates the following fixed dimensions, after the progressive ones indicated<br>if empty, inherits values from a compatible object, such as the GridPivot for example"
				},
				{name:'columns keys fields',			propID:'fieldskeys',		type:'str', section:'column dimensions'
					,tooltip:"Indicates the following fixed dimensions, after the progressive ones indicated<br>if empty, inherits values from a compatible object, such as the GridPivot for example"
				},
				{name:'Prefetched columns fields on first query',	propID:'cachelevel2', type:'int', section:'column dimensions', defaultValue:''
					,tooltip:"Indicates up to how many columns aggregated dimensions will be included on the the first query cached client-side"
				},
				{name:'measures',	propID:'measures',		type:'str', section:'measures'
					,tooltip:"Indicates the calculated measures<br>if empty, inherits values from a compatible object, such as the GridPivot for example"
				}
		],
		encrypt:[
			{name:'Encrypted output fields ',	propID:'encrypted_fields', 
			type:'str', tooltip:'List fo dimensions to encrypt separated by commas.', extraClass: 'col-3', section:'crypt value'
			},
			{name:'Encrypted fields seed ', 	propID:'encrypted_fields_pwd',
				tooltip:'Optional seed for this encryption.<br>If empty it is random generated and no other portlet can decrypt this element.', 
				type:'str', extraClass: 'col-3', section:'crypt value' ,
				validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;}}
			},
			{name:'Encrypted params', propID:'decrypted_parms' , type:'str', tooltip:'List of encrypted parameters separated by commas.', extraClass: 'col-3', section:'crypt value'},
			{name:'Encrypted params seed ', propID:'decrypted_parms_pwd', type:'str', 
				tooltip:'Optional seed for this decryption.<br>If empty it is random generated and only variables of this portlet can be decrypted.', 
				extraClass: 'col-3', section:'crypt value',
				validFunc:function(v){if(v.length>10){PSAlert.alert('Length must be max 10');return false}else{return true;}}
			}
		]
	},
	names: ['../portalstudio/images/icon/bot_dataobj_multilevel_off.png','../portalstudio/images/icon/bot_dataobj_multilevel_off.png'],
    notifications:function(obj){
      obj.notifications=[];
      if(Empty(obj.queries)){
        obj.notifications.push({'message':'Select a query.','tab':'functional','prop':'queries'});
      }
	  var i;
	  var ret;
	  if( !Empty(obj.filterfields) || !Empty(obj.fields) || !Empty(obj.measures) ) {
		  for(i = 0; i<itemsHTML.length; i++)  {
			  if(itemsHTML[i].name != obj.name) {
				  if ( itemsHTML[i].dataobj == obj.name )  {
					  if ( itemsHTML[i].GetFieldsConfig )  {
						  ret = itemsHTML[i].GetFieldsConfig();
						  if( (ret.rows != obj.filterfields) || (ret.columns != obj.fields) || (ret.measures != obj.measures) )  {
							  obj.notifications.push({'message':'Incompatible configuration with ' + itemsHTML[i].name,'tab':'functional','prop':'filterfields'});
							return;
						  }
					  }
				  }  
			  }
		  }
	  }
	  else {
		  for(i = 0; i<itemsHTML.length; i++)  {
			  if(itemsHTML[i].name != obj.name) {
				  if ( itemsHTML[i].dataobj == obj.name )  {
					  if ( itemsHTML[i].GetFieldsConfig )  {
						  ret = itemsHTML[i].GetFieldsConfig();
						  obj.filterfields = ret.rows;
						  obj.fields = ret.columns;
						  obj.measures = ret.measures;
						  obj.filterfieldskeys = ret.rowskeys;
						  obj.fieldskeys = ret.columnskeys;
						  i = itemsHTML.length;
						  } 
					  }
				  }  
			  
			  }
	  }
	  if( Empty(obj.filterfields) ) {
		obj.notifications.push({'message':'Specify progressive aggregate dimensions','tab':'functional','prop':'filterfields'});
	  }
	  if( Empty(obj.measures) ) {
		obj.notifications.push({'message':'Specify measures','tab':'functional','prop':'measures'});
	  }
    },
	events: [
		{ name:'RecordChanged', tooltip:'Event dispatched when current record changes',
     	 parameters : []
		},
		{ name:'QueryExecuted', tooltip:'Event dispatched after query execution',
     	 parameters : []
		},
		{ name:'BeforeQuery', tooltip:'Event dispatched before query execution',
     	 parameters : []
		},
		{ name:'ConsumersRendered', tooltip:'Event dispatched once the data is passed to consumers',
     	 parameters : []
    	},
		{ name:'Abort', tooltip:'Event dispatched on aborting query',
     	 parameters : [
			{name: 'jsonCause', tooltip: 'json object describing event cause', type: 'object'},
        	{name: 'strMessage', tooltip: 'generic error message', type: 'str'}
		 ]
    	},
		{ name:'Error', tooltip:'Event dispatched on error',
     	 parameters : [
			{name: 'jsonCause', tooltip: 'json object describing event cause', type: 'object'},
        	{name: 'strMessage', tooltip: 'generic error message', type: 'str'}
		 ]
    	}
	],
	functions: [
		{ name:'Query', tooltip:'Find query level and execute it with paramters and level filters', usage:'To call for executing new query level, after fields level changing', returnValue:'',
			parameters : []
		},
		{ name:'ResetAllLevelFields', tooltip:'Clears loaded level fields and filters', usage:'To remove all level fields and filters, before setting new', returnValue:'',
			parameters : []
		},
		{ name:'SetLevelField', usage:'Set progressive level field and value, before query execution', returnValue:'',
			tooltip:'Set progressive level field and value'
			+"",
			parameters : [
				{name: 'alias', tooltip: "Dataprovider field alias, must be one of progressive level field", type:'string', optional:false},
				{name: 'value', tooltip: "Value to apply as filter", type:'string', optional:true}
			]
		},
		{ name:'GetQueryCount', tooltip:'Returns the number of records', usage:'To use after query execution', returnValue:'number of records (number)',
			parameters : []
		},
		{ name:'Next', tooltip:'Move the next record', usage:'To use after query execution', returnValue:'boolean',
			parameters : []
		},
		{ name:'Prev', tooltip:'Move the previous record', usage:'To use after query execution', returnValue:'boolean',
			parameters : []
		},
		{ name:'isLastRec', tooltip:'Check if the current record is the last', usage:'To use after query execution', returnValue:'boolean',
			parameters : []
		},
		{ name:'isFirstRec', tooltip:'Check if the current record is the first', usage:'To use after query execution', returnValue:'boolean',
			parameters : []
		},
		{ name:'IsEmpty', tooltip:'Check for records', usage:'To use after query execution', returnValue:'boolean',
			parameters : []
		},
		{ name:'GetRecField', tooltip:'Get field value on current record', usage:'To use after query execution', returnValue:'field value',
			parameters : [
				{name: 'field', tooltip: "Dataprovider field alias", type:'string', optional:false}
			]
		},
		{ name:'HasField', tooltip:'Check field value on current record', usage:'To use after query execution', returnValue:'boolean',
			parameters : [
				{name: 'field', tooltip: "Dataprovider field alias", type:'string', optional:false}
			]
		}
	]
};
ZTObjects.extend(ZTObjects.stdHiddenObjClass, ZTObjects.MLevelDataProviderObjClass);

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

function wizardconfig(obj) {
	openSPModalLayer("../jsp-system/SPMLevelDataConfig_portlet.jsp?objIndex="+obj.index, 100, 100, 660, 225, false, 1, false,false,null,true);
}

function SetMLevelConfiguration(cindex, jsConfig) {
	console.log(cindex, jsConfig)
	var obj = itemsHTML[cindex];
	index = cindex;
	var i, queries, uptolevels, uptolevels2;
	if( obj ) {
		queries = jsConfig.queries;
		uptolevels = jsConfig.uptolevels;
		uptolevels2 = jsConfig.uptolevels2;
		obj.queries = '';
		obj.uptolevels = '';
		obj.uptolevels2 = '';
		for( i=0; i<queries.length; i++ ) {
			if(!Empty(queries[i])) {
				if(!Empty(obj.queries)) {
					obj.queries +=','
					obj.uptolevels +=','
					obj.uptolevels2 +=','
				}
				obj.queries += queries[i];
				obj.uptolevels += uptolevels[i];
				obj.uptolevels2 += uptolevels2[i];
			}
		}
		if( jsConfig.prefetched ) {
			obj.cachelevel = jsConfig.prefetched.row;
			obj.cachelevel2 = jsConfig.prefetched.column;
		}
	}
	Properties(true)
}

ZTObjects.MLevelDataProviderObj=function(id,name,type,html,value,shadow,x,y) {
	this.objClass = ZTObjects.MLevelDataProviderObjClass;
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
	this.h = 20;
	this.w = 120;
	this.hidden = true;
	this.parms = '';
	this.parms_source = '';
	this.author = 'Zucchetti SitePainter';
}
// ZTObjects.MLevelDataProviderObj.prototype = new ZTObjects.stdVisibleObj;