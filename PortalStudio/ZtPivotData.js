/*  global NullDate NullDateTime

*/

if (typeof(ZtVPivotData) == "undefined") {
	function ZtVPivotData(pivotOpts, Fields, Data, bMerge, iaContext) {
		var _this = this;
		var _asEmpty = "[empty]";
		var _mSeparator = '##-##'; 
		var _nSeparator = '####';
		var _level0Key = '#zeroLevel#';
		var _znull = 'znull';
		var _btotal = '_btotal'; 
		var _tot = '_total';
		this.Fields = Fields;
		this.Data = Data;
		this.WData;//ia
		this.WTotal;//ia
		this.bMerge = bMerge; //PortalStudio Control
		this.pivotOpts = pivotOpts;
		this.iaContext = iaContext;
		if(this.bMerge == undefined || this.bMerge == null) {
			this.bMerge = false;
		}
		if(this.iaContext == undefined || this.iaContext == null) {
			this.iaContext = true;
		}
		this.nestedData;
		this.nestedDataOpts;
		this.nestedFieldsKeysMap;
		this.nestedOrderRowsKeysMap;
		this.nestedOrderColumnsKeysMap;
		
		this.WTotalRowsMap = {};

		this._cacheDataProvider = null;
		this._filterDataProvider = null;

		LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/spofflineapp/scripts/QueryLoader.js');
		LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/d3.js');
		LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/AlaSQL.js');
	  	LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/StaticDataProviderObj.js');

		if ( this.Data.length> 0 && !Array.isArray(this.Data[this.Data.length-1]) ) {
			this.Data = this.Data.slice(0, this.Data.length-1)
		}

		// init {
			var form = {  width: 100, 
				height: 100,
				ctrls: [],
				formid: LibJavascript.AlfaKeyGen(5),
				class_name: "portlet",
				portletname: "printGr",
				Step : "",
				Step_old : "",
				Steps : []
			 };
			var id = 'zpivotdata' + LibJavascript.AlfaKeyGen(5);
			var name = id + "_1";
			var st = {};
			st["anchor"] = "";
			st["async"] = false;
			st["auto_exec"] = "false";
			st["ctrlid"] = form.formid + "_" + name + "_" + "InnerStaticDataProvider";
			st["fieldsString"] = "";
			st["fieldstypeString"] = "";
			st["h"] = 1;
			st["hide"] = "false";
			st["layer"] = false;
			st["layout_steps_values"] = {};
			st["name"] = name + "_" + "InnerStaticDataProvider";
			st["page"] = 1;
			st["parms"] = "";
			st["parms_source"] = "";
			st["type"] = "StaticDataProvider";
			st["w"] =  1;
			st["x"] =  0;
			st["y"] =  0;
			var _dataObj = new ZtVWeb.StaticDataProvider(form, st);
			form[st["name"]] = _dataObj;
			_dataObj.dontupdate = true
			_dataObj.getQuery = function() {
				return '/*' + LibJavascript.AlfaKeyGen(5) + '*/ SELECT * FROM ?';
			}

			st = {};
			name = id + "_2";
			st["anchor"] = "";
			st["async"] = false;
			st["auto_exec"] = "true";
			st["ctrlid"] = form.formid + "_" + name + "_" + "InnerStaticDataProvider";
			st["dataproviders"] = _dataObj.name;
			st["fieldsString"] = "";
			st["fieldstypeString"] = "";
			st["h"] = 1;
			st["hide"] = "false";
			st["layer"] = false;
			st["layout_steps_values"] = {};
			st["name"] = name + "_" + "InnerStaticDataProvider";
			st["page"] = 1;
			st["parms"] = "";
			st["parms_source"] = "";
			st["type"] = "StaticDataProvider";
			st["w"] =  1;
			st["x"] =  1;
			st["y"] =  1;
			st["query"] =  "SELECT * FROM ?";
			var _dataObjf = new ZtVWeb.StaticDataProvider(form, st);
			form[st["name"]] = _dataObjf;
			_dataObjf.query = "SELECT * FROM ?";
			_dataObjf.dontupdate = true;

			this._cacheDataProvider = _dataObj;
			this._filterDataProvider = _dataObjf;
		//}
		
		this.update = function(Fields, Data, confOpts, lDrillFilters) {
			function searchForArray(haystack, needle){
			  var i, j, current;
			  for(i = 0; i < haystack.length; ++i){
				if(needle.length === haystack[i].length){
				  current = haystack[i];
				  for(j = 0; j < needle.length && needle[j] === current[j]; ++j);
				  if(j === needle.length)
					return i;
				}
			  }
			  return -1;
			}
			if ( Data.length> 0 && !Array.isArray(Data[Data.length-1]) ) {
				Data = Data.slice(0, Data.length-1)
			}

			if(this.bMerge == true) {
				var force = false;
				var _data = Data;
				var i, j, pfilter;
				if ( Fields.length >= this.Fields.length ) {
					for(i=0; i<Fields.length; i++) {
						var idx = this.Fields.indexOf(Fields[i]);
						if (idx == i )
							continue;
						if( idx < 0 ) {
							this.Fields.splice(i, 0, Fields[i]);
							for (j=0; j<confOpts.rows.length; j++) {
								if ( confOpts.rows[j].alias == Fields[i] ) {
									this.nestedDataOpts.rows.push(confOpts.rows[j]);
									j = confOpts.rows.length;
								}
							}
							for (j=0; j<this.Data.length; j++) {
								this.Data[j].splice(i, 0, _znull)
							}
						}
						else { //no dovrebbe girare ... i campi devono arrivare sempre rispettando ordine dei precedenti
							var tmp;
							for (j=0; j<_data.length; j++) {
								tmp =_data[j][i];
								_data[j][i] = _data[j][idx];
								_data[j][idx] = tmp;

							}
							tmp = Fields[i];
							Fields[i] = Fields[idx];
							Fields[idx] = tmp;
							i--;//devo riprocessare l'indice i
						}
					}
					force = true;
				}
				else if( Fields.length < this.Fields.length ) {
					_data = Data.slice();
					for(i=0; i<Fields.length; i++) {
						if(!Fields[i]) continue;
						if(Fields[i]==_znull) continue;
						var idx = this.Fields.indexOf(Fields[i]);
						if (idx == i )
							continue;
						if( idx < 0 ) {
							this.Fields.splice(i, 0, Fields[i]);
							for (j=0; j<confOpts.rows.length; j++) {
								if ( confOpts.rows[j].alias == Fields[i] ) {
									this.nestedDataOpts.rows.push(confOpts.rows[j]);
									j = confOpts.rows.length;
						}
							}
							for (j=0; j<this.Data.length; j++) {
								this.Data[j].splice(i, 0, _znull)
							}
						}
						else {
							var tmp, ttmp, nf = false;
						for (j=0; j<_data.length; j++) {
								tmp =_data[j][i];
								if(!_data[j][idx]) {
									nf = true;
									_data[j][i] = _znull;
						}
								else {
									_data[j][i] = _data[j][idx];
								}
								_data[j][idx] = tmp;
							}
							if( nf ) {
									ttmp = Fields[i];
									Fields[i] = _znull;
									Fields[idx] = ttmp;
								}
								else {
									ttmp = Fields[i];
									Fields[i] = Fields[idx];
									Fields[idx] = ttmp;
									i--;//devo riprocessare l'indice i
					}
				}
					}
					force = true;
				}
				//controllare se ci sono gia' i dati

				if (_data.length > 0) {
					if( searchForArray(this.Data, _data[0]) < 0) {
						if ( _data.length> 0 && !Array.isArray(_data[_data.length-1]) ) {
							_data = _data.slice(0, _data.length-1)
						}
						this.Data = this.Data.concat(_data);
						force = true;
					}
				}
				if (force) {
					this.getNestedData(this.nestedDataOpts, true);
				}
				return force;
			}
			else {
				this.Fields = Fields;
				this.Data = Data;
				if ( this.Data.length> 0 && !Array.isArray(this.Data[this.Data.length-1]) ) {
					this.Data = this.Data.slice(0, this.Data.length-1)
				}
				this.getNestedData(this.nestedDataOpts, true);
				return true;
			}
		}
		
		this.isProgressive = function() {
			return this.bMerge;
		}
		
		this.updateWTotal = function(rowkey, ret) {
			var frows;
			if(this.WTotal && this.WTotal.length > 0) {
				if (this.WTotalRowsMap[rowkey] != undefined) {
					frows = this.WTotalRowsMap[rowkey];
				}
				else {
					var rowsvalues = rowkey.split(_mSeparator);
					frows = this.WTotal.filter(function(row) {
						for (var i=0; i<_this.pivotOpts.rows.length; i++) {
						var ind, indp;
						var field;
						if ( _this.pivotOpts.rows[i].key ) {
							field = _this.pivotOpts.rows[i].key + _tot;
							indp = _this.Fields.indexOf(field);
							ind = _this.Fields.indexOf(_this.pivotOpts.rows[i].key);
							if (indp < 0) {
								field = _this.pivotOpts.rows[i].alias + _tot;
								indp = _this.Fields.indexOf(field);
								if(ind < 0) {
									ind = _this.Fields.indexOf(_this.pivotOpts.rows[i].alias);
								}
                			}
						}
						else {
							field = _this.pivotOpts.rows[i].alias + _tot;
							indp = _this.Fields.indexOf(field);
							ind = _this.Fields.indexOf(_this.pivotOpts.rows[i].alias);
						}
						if( ind < 0 || indp < 0) {
							return false;
						}
						if ( (rowsvalues[i] == _level0Key+_btotal)  || (rowsvalues[i] == _level0Key)) {
							if ( row[indp] != 1 && row[indp] != true ) {
								return false;
							}
						}
						else if ( i<rowsvalues.length ) {
							if ( rowsvalues[i] != row[ind] ) {
								return false;
							}
						}
						else if ( row[indp] != 1 && row[indp] != true ) {
							return false;
						}
						}
					 return true;
					});
					this.WTotalRowsMap[rowkey] = frows;
				}
				
				if (!ret) {
					return;
				}
				var colkeys = Object.keys(ret);
				for(var j=0; j<colkeys.length; j++) {
					var colsvalues = colkeys[j].split(_mSeparator);
					var fcols;
					if (_this.pivotOpts.columns.length == 1 && _this.pivotOpts.columns[0].alias.length == 0) { //caso pivot senza colonne
						fcols = frows;
					}
					else {
						fcols = frows.filter(function(row) {
							for (var i=0; i<_this.pivotOpts.columns.length; i++){
								var ind, indp;
								var field;
								if ( _this.pivotOpts.columns[i].key ) {
									field = _this.pivotOpts.columns[i].key + _tot;
									indp = _this.Fields.indexOf(field);
									ind = _this.Fields.indexOf(_this.pivotOpts.columns[i].key);
									if (indp < 0) {
										field = _this.pivotOpts.columns[i].alias + _tot;
										indp = _this.Fields.indexOf(field);
										if(ind < 0) {
											ind = _this.Fields.indexOf(_this.pivotOpts.columns[i].alias);
										}
									}
								}
								else {
									field = _this.pivotOpts.columns[i].alias + _tot;
									indp = _this.Fields.indexOf(field);
									ind = _this.Fields.indexOf(_this.pivotOpts.columns[i].alias);
								}
								if( ind < 0 || indp < 0) {
									return false;
								}
								if ( colsvalues[i] == _level0Key ) {
									if ( row[indp] != 1 && row[indp] != true ) {
										return false;
									}
								}
								else if ( i<colsvalues.length ) {
									if ( colsvalues[i] != row[ind] ) {
										return false;
									}
								}
								else if ( row[indp] != 1 && row[indp] != true ) {
									return false;
								}
							}
							return true;
						});
					}						
					for (var i=0; i<_this.pivotOpts.measures.length; i++){
						var field = _this.pivotOpts.measures[i].alias;
						var ind = _this.Fields.indexOf(field);
						if( ind < 0 ) {
							continue;
						}
						for (var k=0; k<fcols.length; k++) {
							if ( k==0 ){
								ret[colkeys[j]][field] = 0;
							}
							ret[colkeys[j]][field] += parseFloat(fcols[k][ind])
						}
					}
				}
			}
		}
		
		this.getNestedData = function ( opts, force ) {
			function applyDataFilter(Fields, Data, opts) {
				var ret = {};
				ret.Fields = Fields;
				if( !opts.filters || (opts.filters.length == 0) ) {
					ret.Data = Data;
					return ret;
				}
				//query
				var j, field, filter;
				var jstQuery = {};
				var cmd = _this._cacheDataProvider.name;
				jstQuery.tables = [];
				jstQuery.tables.push ( {"name":cmd, "alias":cmd, "desc":cmd} );
				jstQuery.fields = [];
				jstQuery.groupBy = [];
				jstQuery.wheres = [];
				var measuresList = [];
				for ( j=0; j<opts.measures.length; j++ ){
					measuresList.push(opts.measures[j].alias)
				}
				for ( j=0; j<Fields.length; j++ ){
					field = Fields[j];
					jstQuery.fields.push( {
					  "desc": field,
					  "exp": cmd + "." + field,
					  "alias": field,
					  "defaultValue": "",
					  "useDefaultWhen": "",
					  "privacy": "0",
					  "identifier": "false",
					  "index": j+'',
					  "type": 'C',
					  "len": "0",
					  "dec": "0",
					  "calculated": "false"
					});
				}
				for ( j=0; j<opts.filters.length; j++ ){
					filter = opts.filters[j];
					var type = filter.type;
					switch (type.charAt(0)) {
						case 'D':
							nullExp = NullDate();
						case 'T':
							nullExp = NullDateTime();
						break;
						case 'N':
							nullExp = 0;
						break;
						case 'L':
							nullExp = false;
						break;
						case 'M':
						case 'C':
						default:
							nullExp = "";
						break;
					}
					if ( !Empty(filter.expression ) ) {
						var op = filter.operator;
						var exp = filter.expression;
						if ( op.toLowerCase() == 'contains' ) {
							op = 'like';
							exp = '%' + exp + '%';
						}
						else if ( op.toLowerCase() == 'like' ) {
							exp = exp + '%';
						}
						if( type == 'N') {
							jstQuery.wheres.push( {
								"field":  filter.field.toLowerCase(),
								"not": "",
								"const": "" + exp + "",
								"useFilterWhen": "",
								"having": "",
								"op": op,
								"lOp": "OR"
							  });
							jstQuery.wheres.push( {
								"field":  filter.field.toLowerCase(),
								"not": "",
								"const": "'" + exp + "'",
								"useFilterWhen": "",
								"having": "",
								"op": op,
								"lOp": "AND"
							  });
						}
						else {
							jstQuery.wheres.push( {
								"field":  filter.field.toLowerCase(),
								"not": "",
								"const": "'" + exp + "'",
								"useFilterWhen": "",
								"having": "",
								"op": op,
								"lOp": "AND"
							  });
						}
					}
					else {
						var nullExp;
						if ( filter.operator.toLowerCase() == 'empty' ) {
							jstQuery.wheres.push({
								"field": filter.field.toLowerCase(),
								"not": "",
								"const": "",
								"useFilterWhen": "",
								"having": "",
								"op": "is null",
								"lOp": "OR"
							});
							jstQuery.wheres.push( {
								"field":filter.field.toLowerCase(),
								"not": "",
								"const": "''",
								"useFilterWhen": "",
								"having": "",
								"op": "=",
								"lOp": "OR"
							});
							jstQuery.wheres.push( {
								"field":filter.field.toLowerCase(),
								"not": "",
								"const": "'" + nullExp + "'",
								"useFilterWhen": "",
								"having": "",
								"op": "=",
								"lOp": "AND"
							});
						}
						else if ( filter.operator.toLowerCase() == 'notempty' ) {
							if (type != 'C') {
								/*if(nullExp.equals("NULL"))
								  queryfilter = field +" is not null";
								else
								  queryfilter = field + " <> " + nullExp + " and " + field +" is not null";*/
								jstQuery.wheres.push({
									"field": filter.field.toLowerCase(),
									"not": "",
									"const": "'" + nullExp + "'",
									"useFilterWhen": "",
									"having": "",
									"op": "<>",
									"lOp": "AND"
								});
								jstQuery.wheres.push( {
									"field":filter.field.toLowerCase(),
									"not": "",
									"const": "",
									"useFilterWhen": "",
									"having": "",
									"op": "is not null",
									"lOp": "AND"
								});
								jstQuery.wheres.push({
									"field": filter.field.toLowerCase(),
									"not": "",
									"const": "' '",
									"useFilterWhen": "",
									"having": "",
									"op": ">",
									"lOp": "AND"
								});
							} else {
								jstQuery.wheres.push({
									"field": filter.field.toLowerCase(),
									"not": "",
									"const": "' '",
									"useFilterWhen": "",
									"having": "",
									"op": ">",
									"lOp": "AND"
								});
								jstQuery.wheres.push( {
									"field":filter.field.toLowerCase(),
									"not": "",
									"const": "",
									"useFilterWhen": "",
									"having": "",
									"op": "is not null",
									"lOp": "AND"
								});
							}
						}
					}
				}
				jstQuery.orderBy = [];
				jstQuery.parameters = [];
				jstQuery.distinct = "";
				jstQuery.remove_filter = false;
				jstQuery.union = "";
				jstQuery.union_all = false;
				jstQuery.use_orderby = false;

				_this._filterDataProvider.queryObj = jstQuery;
				
				var jsData = {};
				jsData.Fields = Fields;
				jsData.Data = Data.slice();
				jsData.Data.push([])
				jsData.name = _this._cacheDataProvider.name;

				try {
					_this._filterDataProvider.FillData(jsData);
					ret.Fields = _this._filterDataProvider.Fields;
					ret.Data = _this._filterDataProvider.Data;
				}
				catch(e) {
					console.log(e)
					ret.ERROR = e.message;
				}
				return ret;
			}

			if (!force && this.nestedDataOpts && this.nestedData) {
				if((opts.rows.length <= this.nestedDataOpts.rows.length) && (opts.columns.length <= this.nestedDataOpts.columns.length)) {
					return this.nestedData;
				}
			}
			
			if(!opts) {
			  opts = this.nestedDataOpts;
			}
			
			function createNestingFunction(fields, fieldsKeyMap, ordersKeyMap, nobj, level, rowLength){
			  var alias = nobj.alias, key = nobj.key, orderfield = nobj.orderfield;
			  var aliasIndex = fields.indexOf(alias);
			  var keyIndex = fields.indexOf(key);
			  var orderIndex = fields.indexOf(orderfield);
			  var orderFieldAsMeasure = false;

			  if(orderIndex >= 0) {
				  for(var l=0; l<opts.measures.length; l++) {
					if(opts.measures[l].alias == orderfield) {
						orderFieldAsMeasure = true;
						l = opts.measures.length;
					}
				  }
			  }
			  
			  function makeRowKey(d, _level) {
				  return makeKey('rows', d, _level)
			  }
			  function makeColumnKey(d, _level) {
				  return makeKey('columns', d, _level)
			  }
			  function makeKey(objKey, d, _level) {
				  var ret='';
				  for (var i=0; i<=_level; i++) {
					  if (ret) {
						  ret += _mSeparator;
					  }
					  var nobj = opts[objKey][i];
					  if( nobj ) {
					  var alias = nobj.alias, key = nobj.key;
					  var aliasIndex = fields.indexOf(alias);
					  var keyIndex = fields.indexOf(key);
					  var _ret;
					  if (keyIndex >= 0) {
						  _ret = d[keyIndex];
						  if(Object.prototype.toString.call(_ret) === '[object Date]') {
							  _ret = _ret.toISOString()
						  }
					  }
					  else if (aliasIndex >= 0) {
						  _ret = d[aliasIndex];
						  if(Object.prototype.toString.call(_ret) === '[object Date]') {
							  _ret = _ret.toISOString()
						  }
					  }
					  ret += _ret;
				  }
				  }
				  return ret;
			  }
			 			  
			  return function(d){
				var _ret;
				var rowkey;
				var colkey;
				var vfloat;
				  if (keyIndex >= 0) {
					  if(d[keyIndex] === '') {
              			_ret =  _asEmpty;
					  }
					  else {
						  _ret = d[keyIndex];
						  if(Object.prototype.toString.call(_ret) === '[object Date]') {
							_ret = _ret.toISOString()
						  }
					  }
					  if ( aliasIndex >= 0 && d[aliasIndex] != _znull ) {
						fieldsKeyMap[alias + _nSeparator + _ret] = d[aliasIndex];
					  }
					  if (orderIndex >= 0 && d[orderIndex] != _znull) {
						if (level < rowLength) {
							rowkey = makeRowKey(d, level);
							if(rowkey === '') {
							rowkey = _asEmpty;
							}
							ordersKeyMap[rowkey + _nSeparator + orderfield] = d[orderIndex];
						}
						else if( d[orderIndex] != _znull ){
							colkey = makeColumnKey(d, level-rowLength);
							if( orderFieldAsMeasure ) {
								if (ordersKeyMap[colkey + _nSeparator + orderfield] == undefined )
									ordersKeyMap[colkey + _nSeparator + orderfield] = 0;
								vfloat = parseFloat(d[orderIndex]);
								ordersKeyMap[colkey + _nSeparator + orderfield] += vfloat;
							}
							else {
								ordersKeyMap[colkey + _nSeparator + orderfield] = d[orderIndex];
							}
						}
					  }
					  return _ret;
				  }
				  else if (aliasIndex >= 0) {
					  if(d[aliasIndex] === '') {
						  _ret = _asEmpty;
					  }
					  else {
						  _ret = d[aliasIndex];
						  if(Object.prototype.toString.call(_ret) === '[object Date]') {
							_ret = _ret.toISOString()
						  }
					  }
					  if (orderIndex >= 0 && d[orderIndex] != _znull) {
						if (level < rowLength) {
							rowkey = makeRowKey(d, level);
							if(rowkey === '') {
								rowkey = _asEmpty;
							}
							ordersKeyMap[rowkey + _nSeparator + orderfield] = d[orderIndex];
						}
						else if( d[orderIndex] != _znull ){
							colkey = makeColumnKey(d, level-rowLength);
							if (ordersKeyMap[colkey + _nSeparator + orderfield] == undefined ) {
								vfloat = parseFloat(d[orderIndex]);
								if (isNaN(vfloat)) {
									ordersKeyMap[colkey + _nSeparator + orderfield] = d[orderIndex];
								}
								else {
									ordersKeyMap[colkey + _nSeparator + orderfield] = parseFloat(vfloat);
								}
							}
							else if (!isNaN(ordersKeyMap[colkey + _nSeparator + orderfield])){
								vfloat = parseFloat(d[orderIndex]);
								if (!isNaN(vfloat)) {
									ordersKeyMap[colkey + _nSeparator + orderfield] += vfloat
								}
							}
						}
					  }
					  return _ret;
				  }
				  else if( alias == '' ){
					  return _znull;
				  }
				  else {
					  return undefined;
				  }
			  };
			}
				
			function aggregateRollingUpFunction(rowColLevel, key, node, measuresArray) {
				function _isNumeric(n) {
					return !isNaN(parseFloat(n)) && isFinite(n);
				  }

				var ret;
				var i;
				var j;
				if ( node.total ) {
					ret = node.total;
				}
				else if ( node.value ) {
					node.total = node.value;
					ret = node.total;
				}
				var _key;
				if ( key == _level0Key ) {
					_key = node.key;
				}
				else {
					_key = key + _mSeparator + node.key;
				}
				
				if (!ret) {
					var sum = {};
					for (i=0; i<measuresArray.length; i++) {
						sum[measuresArray[i].alias] = 0;
					}
					var hznull = false;
					if (node.values) {
						for (j=0; j<node.values.length; j++) {
							var o = aggregateRollingUpFunction(rowColLevel+1, _key, node.values[j], measuresArray);
							for (i=0; i<measuresArray.length; i++) {
									if(!hznull)  {
										if( _isNumeric(o[measuresArray[i].alias]) )
											sum[measuresArray[i].alias] += parseFloat(o[measuresArray[i].alias]);
									}
							}
							if( node.values[j].key == _znull) hznull = true;
						}
					}
					node.total = sum;
					ret = node.total;
				}
				
				var rowkey, colkey, rcObj = {};
				if (rowColLevel < opts.rows.length) {
					rowkey = _key;
					colkey = _level0Key;
				}
				else {
					var sp = _key.split(_mSeparator);
					rowkey = sp[0]
					for(i=1; i<opts.rows.length; i++) {
						rowkey += _mSeparator + sp[i];
					}
					colkey = sp[opts.rows.length];
					for(i=opts.rows.length+1; i<sp.length; i++) {
						colkey += _mSeparator + sp[i];
					}
				}
				rcObj[colkey] = ret;
				_this.updateWTotal(rowkey, rcObj);
				
				if (rowColLevel < opts.rows.length) {
					for (i=0; i<measuresArray.length; i++) {
						if ( ordersRowsKeyMap[rowkey + _nSeparator + measuresArray[i].alias] != undefined ) {
							ordersRowsKeyMap[rowkey + _nSeparator + measuresArray[i].alias] = ret[measuresArray[i].alias];
							i = measuresArray.length;
						}
					}
				}
				else {
					for (i=0; i<measuresArray.length; i++) {
						if ( ordersColumnsKeyMap[colkey + _nSeparator + measuresArray[i].alias] != undefined ) {
							var _rcObj = {};
							rowkey = _level0Key+_btotal;
							_rcObj[colkey] = {}
							_rcObj[colkey][measuresArray[i].alias] = undefined;
							_this.updateWTotal(rowkey, _rcObj);
							if (_rcObj[colkey][measuresArray[i].alias] != undefined) {
								ordersColumnsKeyMap[colkey + _nSeparator + measuresArray[i].alias] = _rcObj[colkey][measuresArray[i].alias];
							}
							i = measuresArray.length;
						}
					}
				}
				//console.log(key, ret)
				return ret;
			}
					
			var nestobj = d3.nest();
			var fieldsKeyMap = {};
			var ordersRowsKeyMap = {};
			var ordersColumnsKeyMap = {};
      		var i, j, d, nz;
			if( this.bMerge ) {
				var c = 0;
				for( i=0; i<_this.pivotOpts.rows.length; i++) {
					if( _this.Fields.indexOf(_this.pivotOpts.rows[i].alias) >= 0) {
						if(!Empty(_this.pivotOpts.rows[i].key)) c++;
					}
				}
				for( i=0; i<_this.pivotOpts.columns.length; i++) {
					if( _this.Fields.indexOf(_this.pivotOpts.columns[i].alias) >= 0) {
					if(!Empty(_this.pivotOpts.columns[i].key)) c++;
					c++;
				}
				}
				nz = _this.Fields.length - c - _this.pivotOpts.measures.length;
				for (i=0; i<nz; i++) {
					nestobj = nestobj.key(createNestingFunction(_this.Fields, fieldsKeyMap, ordersRowsKeyMap,  _this.pivotOpts.rows[i], i, nz));
				}
			}
			else {
				nz = opts.length;
			for (i=0; i<opts.rows.length; i++) {
					nestobj = nestobj.key(createNestingFunction(_this.Fields, fieldsKeyMap, ordersRowsKeyMap,  opts.rows[i], i, nz));
				}
			}
			
			for (j=0; j<opts.columns.length; j++) {
				if( _this.Fields.indexOf(opts.columns[j].alias) >= 0)
				nestobj = nestobj.key(createNestingFunction(_this.Fields, fieldsKeyMap, ordersColumnsKeyMap, opts.columns[j], nz+j, nz));
			}
			
			nestobj = nestobj.rollup(function(v) {
				var o = {};
				for (var i=0; i<opts.measures.length; i++) {
					if ( v.length == 1 ) {
						var ind = _this.Fields.indexOf(opts.measures[i].alias);
						if (ind < 0)
							o[opts.measures[i].alias] = null;
						else
							o[opts.measures[i].alias] = parseFloat( v[0][ind] );
					}
					else {
					o[opts.measures[i].alias] = d3.sum(v, function(d) {
						var ind = _this.Fields.indexOf(opts.measures[i].alias);
						if (ind < 0)
							return 0;
						return d[ind]; 
					})
				}
				}
				return o;
			});

			if (!this.bMerge && this.iaContext) {
				var dataFilter = [];
				var totFilter = [];
				for ( i=0; i<this.Data.length; i++ ) {
					var row = this.Data[i];
          			var f=false;
          			var field;
					for(j=0; !f && j<this.pivotOpts.rows.length; j++) {
            			var ind = -1;
						if ( this.pivotOpts.rows[j].key ) {
							field = this.pivotOpts.rows[j].key + _tot;
							ind = this.Fields.indexOf(field);
							if (ind < 0) {
							  field = this.pivotOpts.rows[j].alias + _tot;
								ind = this.Fields.indexOf(field);
							}
						}
						else {
							field = this.pivotOpts.rows[j].alias + _tot;
							ind = this.Fields.indexOf(field);
						}

						if ( ind >= 0 && (row[ind] == 1 || row[ind] == true) ) {
							f = true;
						}
					}
					for(j=0; !f && j<this.pivotOpts.columns.length; j++) {
						if ( this.pivotOpts.columns[j].key ){
							field = this.pivotOpts.columns[j].key + _tot;
							ind = this.Fields.indexOf(field);
							if (ind < 0) {
							field = this.pivotOpts.columns[j].alias + _tot;
								ind = this.Fields.indexOf(field);
							}
						}
						else {
							field = this.pivotOpts.columns[j].alias + _tot;
							ind = this.Fields.indexOf(field);
						}
						if ( ind >= 0 && (row[ind] == 1) || row[ind] == true) {
							f = true;
						}
					}
					if (f) {
						totFilter.push(row);
					}
					else {
						dataFilter.push(row);
					}
				}
				this.WData = dataFilter;
				this.WTotal = totFilter;
				d = applyDataFilter(this.Fields, this.WData, opts)
				nestobj = nestobj.entries(d.Data);
			}
			else {
				d = applyDataFilter(this.Fields, this.Data, opts)
				nestobj = nestobj.entries(d.Data); //
			}
			
			for (i=0; i <nestobj.length; i++) {
				var ob = nestobj[i];
				aggregateRollingUpFunction(0, _level0Key, ob, opts.measures)
			}

			this.nestedFieldsKeysMap = fieldsKeyMap;
			this.nestedOrderRowsKeysMap = ordersRowsKeyMap;
			this.nestedOrderColumnsKeysMap = ordersColumnsKeyMap;
			this.nestedData = nestobj;
			this.nestedDataOpts = opts;
			this.filterDataObj = d;

			var _mo = {};
			_mo.key = _level0Key;
			_mo.values = nestobj;
			this.sortRowsRollingUp(opts, 0, _level0Key, _mo);
			return this.nestedData;
		}

		this._getNestedDataTable = function (opts, columnLevel) {
			this.getNestedData(opts, true);
			var ret = {};
			ret.Fields = [];
			ret.Data = [];
			var z, i;
			var data = this.nestedData;
			function aggregateDataToTable(level, node, opts, colLevel, objArr, colPrevKey, rowPrevKey) {
				var r, _pObjArr = objArr, alias;
				if (level >= opts.rows.length+colLevel) {
					return;
				}
				if( level >= 0 ) {
					if (level < opts.rows.length) {
						if (level == 0) {
							rowPrevKey = node.key;
							r = [];
							r.push(rowPrevKey)
							r.push(
								_this._getApplyPicture(opts.rows[level].pictureFnc, _this._getFieldAliasKeyValue(opts.rows[level], rowPrevKey), node.key, opts.rows[level].type)
								)
							_pObjArr.Data.push(r);
						}
						else {
							rowPrevKey += _mSeparator + node.key;
						}
						if( level > 0 ) {
							if( _pObjArr == null ) _pObjArr = objArr;
							r;
							if( _pObjArr.Data.length > 0) r = _pObjArr.Data[_pObjArr.Data.length -1];
							else {
								r = [];
								_pObjArr.Data.push(r)
							}
							r[level*2] = rowPrevKey;
							r[level*2+1] = (
								_this._getApplyPicture(opts.rows[level].pictureFnc, _this._getFieldAliasKeyValue(opts.rows[level], node.key), node.key, opts.rows[level].type)
								)
						}
						
						alias = opts.rows[level].alias;
						_pObjArr.Fields[level*2] = (alias)
						_pObjArr.Fields[level*2+1] =(alias + '_pic')
					}
					else if (level < opts.rows.length+colLevel) {
						var zl = level-opts.rows.length;
						if ( zl == 0 ) {
							colPrevKey = node.key;
						}
						else {
							colPrevKey += _mSeparator + node.key;
						}
						r;
						if( _pObjArr == null ) _pObjArr = objArr;
						if( _pObjArr.Data.length > 0) r = _pObjArr.Data[_pObjArr.Data.length -1];
						else {
							r = [];
							_pObjArr.Data.push(r)	
						}
						var pindex = opts.rows.length*2;
						r[pindex + zl*2] = colPrevKey;
						if( opts.columns[zl].key) {
							r[pindex + zl*2+1] = 
							_this._getApplyPicture(opts.columns[zl].pictureFnc, _this._getFieldAliasKeyValue(opts.columns[zl], node.key), node.key, opts.columns[zl].type);
						}
						else
							r[pindex + zl*2+1] = node.key;
						alias = opts.columns[zl].alias;
						_pObjArr.Fields[pindex + zl*2] = alias;
						_pObjArr.Fields[pindex + zl*2+1] = alias + '_pic'

						if( zl == (colLevel-1) ) {
							var _r = r.concat([]);
							for( i=0; i<opts.measures.length; i++) {
								r.push(node.total[opts.measures[i].alias])
								r.push(
									_this._getApplyPicture(opts.measures[i].pictureFnc, node.total[opts.measures[i].alias], null, opts.measures[i].type)
									)
							}
							_pObjArr.Data.push(_r)	
						}
					}
				}
				
				if (level < opts.rows.length+colLevel) { 
					if (node.values) {
						var j;
						if( _pObjArr == null ) _pObjArr = objArr;
						for (j=0; j<node.values.length; j++) {
							aggregateDataToTable (level+1, node.values[j], opts, colLevel, _pObjArr, colPrevKey, rowPrevKey);
						}
					}
				}
			}

			for(z=0; z<data.length; z++) {
				var node = data[z];
				var objArr = {};
				objArr.Fields = [];
				objArr.Data = []
				aggregateDataToTable(0, node, opts, columnLevel, objArr);
				objArr.Data.pop();
				ret.Data = ret.Data.concat(objArr.Data);
				if( ret.Fields.length == 0 )
					ret.Fields = ret.Fields.concat(objArr.Fields);
			}
			for(z=0; z<opts.measures.length; z++) {
				ret.Fields.push(opts.measures[z].alias);
				ret.Fields.push(opts.measures[z].alias+'_pic');
			}
			return ret;
		}

		this._getApplyPicture = function(pictureFnc, ret, key, type) {
			var __ret, __key;
			function _fCheckIfDate(strDate) {
				if (typeof(strDate) != 'string')
					return false;
				var reg = /^(-?(?:[1-9][0-9]*)?[0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(.[0-9]+)?(Z)?$/g;
				if (strDate) {
					return strDate.match(reg) != null;
				}
				return false;
			}
			if(pictureFnc != undefined) {
				if (_fCheckIfDate(ret) == true) {
					ret = new Date(ret);
				}
				var _key = key;
				if( key ) {
					var _asDate = _fCheckIfDate(_key);
					if ( _asDate == true) {
						_key = new Date(_key);
					}
				}
        		var fnc, evalStr;
				if(Object.prototype.toString.call(pictureFnc) === '[object Function]') {
					ret = pictureFnc(ret, _key);
				}
				else if(pictureFnc.indexOf('function:') > -1) {
					fnc = pictureFnc;
					fnc = fnc.replace(/function:/g, '');
					if ( !_asDate )  {
						if ( ret != null  && (typeof ret === 'string'))
							__ret = ret.replace(/'/g, "\\'");
						else
							__ret = ret;
						if ( _key != null && (typeof _key === 'string'))
							__key = _key.replace(/'/g, "\\'");
						else
							__key = _key;
						evalStr =  fnc + '(' + __ret + ',' + __key +  ')';
					}
					else {
						evalStr =  fnc + '(' + '\'' + ret + '\'' + ',' + _key + ')';
					}
					ret = eval(evalStr);
				}
				else if(pictureFnc.indexOf('javascript:') > -1) {
					fnc = pictureFnc;
					fnc = fnc.replace(/javascript:/g, '');
					if ( !_asDate )  {
						evalStr =  fnc + '('  + ret +  ','  + _key  + ')';
					}
					else {
						evalStr =  fnc + '(' + '\'' + ret + '\'' + ',' + _key + ')';
					}
					ret = eval(evalStr);
				}
				else { //string
					fnc = pictureFnc;
					try {
						if( type == 'D' || type == 'T') {
							ret = new Date(ret)
						}
						else if(type == 'N') {
							ret = parseFloat(ret);
						}
						else if(type == 'L') {
							ret = ( ret.toLowerCase() === 'true' );
						}
					}
					catch(e) {}
					ret = Format(ret, null, null, fnc)
				}
			}
			return ret;
		}

		this._getFieldAliasKeyValue = function(rowColObj, key) {
			var ret = key;
			if (this.nestedFieldsKeysMap) {
				var _ret = this.nestedFieldsKeysMap[rowColObj.alias + _nSeparator + key];
				if ( _ret != undefined )
					ret = _ret;
			}
			if( ret == _asEmpty ) ret = '';
			return ret;
		}
		
		this.sortRowsRollingUp = function (opts, rowLevel, key, node) {
				if(rowLevel<0 || rowLevel >= opts.rows.length)
					return;

				if (opts.rows[rowLevel] && opts.rows[rowLevel].orderby) {
					var _orderby = opts.rows[rowLevel].orderby.toLowerCase();
					var _aliasOrder = opts.rows[rowLevel].orderfield;
					if(node && node.values) {
						node.values.sort(function(a, b)  {
							var akey, bkey;
							if (key == _level0Key) {
								akey = a.key;
								bkey = b.key;
							}
							else {
								akey = key + _mSeparator + a.key;
								bkey = key + _mSeparator+ b.key;
							}
							var _a = _this.nestedOrderRowsKeysMap[akey + _nSeparator + _aliasOrder];
							var _b = _this.nestedOrderRowsKeysMap[bkey + _nSeparator + _aliasOrder];
							if (_a == undefined || _b == undefined ) {
								_a = a.key;
								_b = b.key;
							}
							if (_orderby == 'asc') {
								if( _this._isNumeric(_a) && _this._isNumeric(_b) )
									return parseFloat(_a) - parseFloat(_b);
								else if ( typeof(_a) == 'string' && typeof(_b) == 'string' )
									return _a.localeCompare(_b);
								else
									return 0;
							}
							else if (_orderby == 'desc') {
								if( _this._isNumeric(_a) && _this._isNumeric(_b) )
									return parseFloat(_b) - parseFloat(_a);
								else if ( typeof(_a) == 'string' && typeof(_b) == 'string' )
									return _b.localeCompare(_a);
								else
									return 0;
							}
							
						});
					}
				}
				if (node && node.values) {
					for (var j=0; j<node.values.length; j++) {
						var _key;
						if ( key == _level0Key ) {
							_key = node.values[j].key;
						}
						else {
							_key = key + _mSeparator + node.values[j].key;
						}
						this.sortRowsRollingUp(opts, rowLevel+1, _key, node.values[j]);
					}						
				}
		}
			
		this.sortColumnsRollingUp = function(opts, columnIndex, arrayToSort, columnKey) {
			if ( columnIndex<0 || columnIndex >= opts.columns.length)
				return;
			if (opts.columns[columnIndex].orderby) {
				var _orderby = opts.columns[columnIndex].orderby.toLowerCase();
				var _aliasOrder = opts.columns[columnIndex].orderfield;
				if(_this.nestedOrderColumnsKeysMap) {
					arrayToSort.sort(function(a, b) {
						var akey, bkey;
						if (columnKey == _level0Key) {
							akey = a
							bkey = b;
						}
						else {
							akey = columnKey + _mSeparator + a;
							bkey = columnKey + _mSeparator+ b;
						}
						var _a = _this.nestedOrderColumnsKeysMap[akey + _nSeparator + _aliasOrder];
						var _b = _this.nestedOrderColumnsKeysMap[bkey + _nSeparator + _aliasOrder];
						if (_a == undefined || _b == undefined ) {
							_a = a;
							_b = b;
						}
						if (_orderby == 'asc') {
							if( _this._isNumeric(_a) && _this._isNumeric(_b) )
								return parseFloat(_a) - parseFloat(_b);
							else if ( typeof(_a) == 'string' && typeof(_b) == 'string' )
								return _a.localeCompare(_b);
							else
								return 0;
						}
						else if (_orderby == 'desc') {
							if( _this._isNumeric(_a) && _this._isNumeric(_b) )
								return parseFloat(_b) - parseFloat(_a);
							else if ( typeof(_a) == 'string' && typeof(_b) == 'string' )
								return _b.localeCompare(_a);
							else
								return 0;
						}
					});
				}
			}
		}
		
		this._isNumeric = function(n) {
		  return !isNaN(parseFloat(n)) && isFinite(n);
		}
	}
}