
// definizione VPivot //Controller
if (typeof(ZtVPivot) == "undefined") { 
    function ZtVPivot(opts, htmlContainer, PSCtrl, bQueryLevel) {
	  this._initOpts = opts; //copia configurazione originale
	  this.opts = opts;
	  this.bQueryLevel = bQueryLevel;
	  this.ztVPivotData;
	  this.ztVPivotUI;
	  this.htmlContainer = htmlContainer;
	  this.PSCtrl = PSCtrl; //PortalStudio Control
	  var _mSeparator = '##-##';
	  var _nSeparator = '####'; 
	  var _kSeparator = '||#||';
	  var _level0Key = '#zeroLevel#';
	  var _znull = 'znull';
	  var _btotal = '_btotal';
	  var _npad = 3;
	  var _cssmode = 'csscol';
	  var _asEmpty = "[empty]";
	  var _refID;
	  this.drawOpts;
	  this.nestedData;
	  this.drawingColumns;
	  this.drawingColumnsSort = {};
	  this.aggregateobjRets;
	  this.drillKeys = {};
	  this._wKey = LibJavascript.CharKeyGen(5);
	  
	  var _this = this;
	  
	  LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/ZtPivotData.js');
	  LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/ZtPivotUI.js');
	  LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/HamburgerMenuObj.js');
	  
	  var options = {
		root: null,
		rootMargin: "0px",
		threshold: 1
	 };
     this.PSObserver = new IntersectionObserver(_fHandleIntersectionObserver, options);
	 this.PSObserver.parent = this;
	 
	 this._workVars={};
	 
	 if( PSCtrl && PSCtrl.ctrlid ) _refID = PSCtrl && PSCtrl.ctrlid;
	 else _refID = LibJavascript.AlfaKeyGen(5);

	 if( PSCtrl && PSCtrl.h )  this._initOpts.containerHeight = PSCtrl.h;
	 else this._initOpts.containerWidth = this.htmlContainer.offsetHeight;
	 if( PSCtrl && PSCtrl.w )  this._initOpts.containerHeight = PSCtrl.w;
	 else this._initOpts.containerWidth = this.htmlContainer.offsetWidth;
	 
	 if (this.opts.scroll_bars == undefined) {
		this.opts.scroll_bars = 'false';
	 }

	  if (this.opts.measuresOnColumn == undefined) {
		  this.opts.measuresOnColumn = false;
	  }
	  if (this.opts.measuresOnColumn == false) {
		  _cssmode = 'cssrow';
	  }
	  
	  if(this.opts.hideMeasures == undefined) {
		this.opts.hideMeasures = false;
	  } 
	  
	  if (this.opts.subTotalOnRow == undefined) {
		  this.opts.subTotalOnRow = false;
	  }
	  if (this.opts.subTotalOnRowLevel == undefined) {
		  this.opts.subTotalOnRowLevel = false;
	  }
	  if (this.opts.subTotalOnColumn == undefined) {
		  this.opts.subTotalOnColumn = false;
	  }
	  if (this.opts.bigTotalOnRow == undefined) {
		  this.opts.bigTotalOnRow = false;
	  }
	  if (this.opts.bigTotalOnColumn == undefined) {
		  this.opts.bigTotalOnColumn = false;
	  }
	  if (this.opts.bigTotalTitle == undefined) {
		  this.opts.bigTotalTitle = "Total";
	  }
	  if (this.opts.subTotalTitle == undefined) {
		  this.opts.subTotalTitle = "Total";
	  }
	  if (this.opts.measuresTitle == undefined) {
		  this.opts.measuresTitle = "Measures";
	  }
	  if (this.opts.columns == undefined) {
		  this.opts.columns = [];
	  }
	  if (this.opts.columns.length == 0) {
		this.opts.columns.push({alias:"", desc:""})
	  }
	  if (this.opts.sortRow == undefined) {
		  this.opts.sortRow = false;
	  }
	  if (this.opts.sortColumn == undefined) {
		  this.opts.sortColumn = false;
	  }
	  if (this.opts.cssClass == undefined || Empty(this.opts.cssClass)) {
		this.opts.cssClass = 'drilldown';
	  }
	  var sheetw = document.createElement('style');
	  sheetw.innerHTML = "";
	  var ctr = "";
	  if( this.PSCtrl && this.PSCtrl.ctrl) {
		this.PSCtrl.ctrl.classList.add(this._wKey) 
		ctr = "." + this._wKey + " ";
	  }
	  sheetw.innerHTML += ctr + "." + this.opts.cssClass + " {white-space:break-spaces !important; word-wrap: break-word} " //rimozione da css//evita modifica manuale vecchio css
	  
	  var i, field, dones = [], cwidth, mcwidth=0;
	  for( i=0; i<this.opts.measures.length; i++ ) {
		field = this.opts.measures[i];
		if( !field.cssWidth ) {
			cwidth = _fGetTextSize(document.body, field.desc, field.pictureFnc).width;
		}
		else {
			cwidth = parseInt(field.cssWidth+'');
		}
		mcwidth = Math.max(mcwidth, cwidth);
		dones.push(field.alias)
		sheetw.innerHTML += ctr + ".csscol ." + field.alias + " {width:" + cwidth +"px} "
	  }
	  for( i=0; i<this.opts.omeasures.length; i++ ) {
		field = this.opts.omeasures[i];
		if( !field.cssWidth ) {
			cwidth = _fGetTextSize(document.body, field.desc, field.pictureFnc).width;
		}
		else {
			cwidth = parseInt(field.cssWidth+'');
		}
		mcwidth = Math.max(mcwidth, cwidth);
		dones.push(field.alias)
		sheetw.innerHTML += ctr + ".csscol ." + field.alias + " {width:" + cwidth +"px} "
	  }
	  for( i=0; i<this.opts.fields.length; i++ ) {
		field = this.opts.fields[i];
		if( dones.indexOf(field.alias) >= 0) continue;
		if( field.type != 'N') continue;
		if( !field.cssWidth ) {
			cwidth = _fGetTextSize(document.body, field.desc, '').width;
		}
		else {
			cwidth = parseInt(field.cssWidth+'');
		}
		mcwidth = Math.max(mcwidth, cwidth);
		dones.push(field.alias)
		sheetw.innerHTML += ctr + ".csscol ." + field.alias + " {width:" + cwidth +"px} "
	  }
	  sheetw.innerHTML += ctr + ".columndata.cssrow"  + " {width:" + mcwidth +"px} "
	  sheetw.innerHTML += ctr + ".columntitle.cssrow"  + " {width:" + mcwidth +"px} "
	  sheetw.innerHTML += ctr + ".columntitle .columntotal.cssrow"  + " {width:" + mcwidth +"px} "
	  
	  var _mstr = " .drilldown table.t-data td, .drilldown table.t-columns td, "
	   + " .drilldown td.td-view-description table td, "
	   + " .drilldown_table .columndata "
	   //+ ","
	   //+ ".drilldown .drilldown_table .td-view-row, "
	   //+ ".drilldown .td-view-description .t-rows-header .columnheader, "
	   //+ ".drilldown .td-subtotal,"
	   //+" .drilldown .td-row-subtotal, "
	   //+" .drilldown .drilldown_table .td-view-columns .td-subtotal, "
	   //+ ".drilldown .drilldown_table .td-view-columns .td-bigtotal, "
	   //+ ".drilldown .drilldown_table .td-view-rows .td-row-subtotal, "
	   //+ ".drilldown .drilldown_table .td-view-rows .td-row-bigtotal" //da rimuovere dopo - settare width delle colonne di righe

	   _mstr = Strtran(_mstr, ".drilldown ", ctr + "." + this.opts.cssClass + " ")

	   sheetw.innerHTML +=  _mstr + " {white-space:break-spaces !important; word-wrap: break-word} " //rimozione da css//evita modifica manuale vecchio css
	   document.body.appendChild(sheetw);

	  if (this.opts.spTheme == undefined) {
		this.opts.spTheme = false;
	  }
	  if (this.opts.uiDragDrop == undefined) {
		this.opts.uiDragDrop = true;
	  }
	  if (this.opts.othDimMeas == undefined) {
		this.opts.othDimMeas = true;
	  }
	  if (this.opts._cssFiles == undefined) {
		this.opts._cssFiles = [];
		if (!this.PSCtrl ) { 
			this.opts._cssFiles.push('styles/GridPivotObj.css');
		}
	  }
	  this.opts._cssFiles.push('classeditor/fontList.css');
	  
	  if( !this._initOpts.onclickFnc && this.PSCtrl ) {
		  this._initOpts.onclickFnc = function(event, o) {
			var ctrl = _this.PSCtrl;
			if (event) {
				if(ctrl.dispatchEvent) ctrl.dispatchEvent('Click', event, o); 
			}
		  }
	  }

	  if( !this._initOpts.onDrillDown && this.PSCtrl ) {
		  this._initOpts.onDrillDown = function(event, o) {
			var ctrl = _this.PSCtrl;
			if( o && !o.found && ctrl.drillDown ) {
				ctrl.drillDown(o);
			}
			if (event) {
				if(ctrl.dispatchEvent) ctrl.dispatchEvent('DrillDown', event, o); 
			}
		  }
	  }

	  if( !this._initOpts.onRendered && this.PSCtrl ) {
		  this._initOpts.onRendered = function() {
			var ctrl = _this.PSCtrl;
			if(ctrl.dispatchEvent) ctrl.dispatchEvent('Rendered'); 
		  }
	  }

	  this.hasMenu = this.PSCtrl && (this._initOpts.uiDragDrop || this._initOpts.print_result || this._initOpts.canFilter);

	  if( this.PSCtrl && this.PSCtrl.IsMenuEnable) this.hasMenu = this.hasMenu || this.PSCtrl.IsMenuEnable();

	  this.manageMenu = function( divMenu ) {
		if ( this.PSCtrl ) {
			this.PSCtrl.manageMenu(divMenu);
		}
	  }

	  this._resetAndDraw = function( rows, columns, measures ) {
		this.mViewer._resetAndDraw(rows, columns, measures);
	  }

	  this._showHideConfig = function() {
		this.mViewer._showHideConfig();
		if ( this.uiClosed!= null ) {
			if (this.uiClosed ) this.uiClosed = false;
			else this.uiClosed = true;
			if( this.PSCtrl && this.PSCtrl.adjustFormHeight ) this.PSCtrl.adjustFormHeight();
		}
		else this.uiClosed = true;
	  }

	  this._retrieveDataOnView = function() {
		return this.mViewer._retrieveDataOnView();
	  }

	  this._retrieveDataPivotOnView = function() {
		return this.mViewer._retrieveDataPivotOnView();
	  }

	  this._filterData = function (id, ev, alias) {
		if (!this._initOpts.canFilter)
			return;
		if( this.PSCtrl && this.PSCtrl.ToggleFilterArea ) {
			this.PSCtrl.ToggleFilterArea(id, ev, alias);
		}
	  }

	  this._removeFilterData = function (alias) {
		if (!this._initOpts.canFilter && !this._initOpts.canApplyFilter)
			return;
		if( this.PSCtrl && this.PSCtrl.RemoveFilterAlias ) {
			this.PSCtrl.RemoveFilterAlias(alias);
		}
	  }

	  this.applyFilter = function(filters, asyncFnc) {
		var _nDrawOpts ;
		if( this.drawOpts ) _nDrawOpts =_fjsonCopy(this.drawOpts);
		else _nDrawOpts = {}
		_nDrawOpts.filters = filters;
		this.redraw(_nDrawOpts, asyncFnc);
	  }

	  this._updateFiltersDiv = function(filters) {
		if(!filters)
			filters = this.drawOpts.filters;
		if( !filters && this.PSCtrl && this.PSCtrl.Filters )
			filters = this.PSCtrl.Filters;
		
		var l = this.htmlContainer.getElementsByClassName('rem_filter');
		var i,  alias, f;
		var lalias = [], map = {};
		if( filters)
			for( i=0; i<filters.length; i++ ) {
				lalias.push(filters[i].field.toLowerCase());
				map[filters[i].field.toLowerCase()] = filters[i];
			}
		for( i=0; i<l.length; i++ ) {
			alias = _fGetHTMLAttribute(l[i], 'alias');
			if( lalias.indexOf(alias) < 0 ) {
				l[i].style.display = 'none';
			}
			else {
				f = map[alias];
				if( f && f.fixed == true ) l[i].style.opacity = .3;
				else l[i].style.opacity = 1;
				l[i].style.display = 'inline';
			}
		}
		if( this.PSCtrl && this.PSCtrl._OutFilterByExample ) this.PSCtrl._OutFilterByExample();
	  }

	  this._printData = function() {
		if( this.PSCtrl && this.PSCtrl.Print ) {
			this.PSCtrl.Print();
			return;
		}
	  }

	  this.getFilterDivPosition = function(handler) {
		return this.mViewer.getFilterDivPosition(handler);
	  }

	  this._retrieveDataForChart = function() {
		return this.mViewer._retrieveDataForChart();
	  }

	  this._convertKeysToItem = function (rowskey, columnskey, measure, value) {
		var opts = this.opts;
		var o = {};
		/*o.isRowTotal = frHtmlObj.isRowTotal;
		o.isRowBigTotal = frHtmlObj.isRowBigTotal;
		o.isColumnBigTotal = frHtmlObj.isColumnBigTotal; 
		o.isColumnTotal = frHtmlObj.isColumnTotal;*/
		o.rows = [];
		o.columns = [];
		o.measure = {};
		var lsplit, i, s;
		//var index = this.drawOpts.rowsSubLevel[level].indexOf(key);
		var index = 0; //da calcolare o ricevere da oggetto chart - in lavorazione
		if (rowskey && rowskey != _level0Key) {
			lsplit = rowskey.split(_mSeparator);
			for (i=0; i<lsplit.length; i++) {
				s = {};
				if ( opts.rows[i].key ) 
					s.key = opts.rows[i].key;
				s.alias = opts.rows[i].alias;
				if( lsplit[i] == _asEmpty)
					s.value = null
				else {
					s.value = lsplit[i];
					if(opts.rows[i].type == 'N')
						s.value = parseFloat(s.value)
				}
				o.rows.push(s);
			}
		}
		if (columnskey && columnskey != _level0Key) {
			lsplit = columnskey.split(_mSeparator);
			for (i=0; i<lsplit.length; i++) {
				s = {};
				if ( opts.columns[i].key )
					s.key = opts.columns[i].key;
				s.alias = opts.columns[i].alias;
				s.value = lsplit[i];
				if( lsplit[i] == _asEmpty)
					s.value = null
				else {
					s.value = lsplit[i];
					if(opts.columns[i].type == 'N')
						s.value = parseFloat(s.value)
				}
				o.columns.push(s);
			}
		}
		o.measure.alias = measure;
		var mindex = null;
		for(i=0; i<opts.measures.length; i++) {
			if ( opts.measures[i].alias == measure ) {
				mindex = i;
				i = opts.measures.length;
			}
		}
		o.measure.index = mindex;
		if( value != undefined ) {
			o.measure.value = value;
		}
		else if( index!= null ) {
			var tdmeasure = _fPad(mindex) + measure;
			o.measure.value = this.mViewer.valueMap[index+_kSeparator+rowskey+_kSeparator+columnskey+_kSeparator+tdmeasure];

		}
		return o;
	  }
	    
	  function dataViewer(htmlContainer, ztController) {
		  this.htmlContainer = htmlContainer;
		  this.htmlTable;
		  this.tdAreaColumns;
		  this.tdAreaRows;
		  this.tdAreaData;
		  this.tdAreaDescription;
		  this.aggregateDataMap = [];
		  this.valueMap = [];
		  this.valueMapKeys = [];
		  this.valueMapKeysAndNull = [];
		  this.ztController = ztController;
		
		this._showHideConfig = function () {
			var l = this.htmlContainer.getElementsByClassName('drillboxconf');
			var i;
			for( i=0; i<l.length; i++) {
				if( l[i].style.display == 'none')
					l[i].style.display = '';
				else
					l[i].style.display = 'none';
			}
			var cfCols = this.htmlContainer.getElementsByClassName('columns')
			var cfMeas = this.htmlContainer.getElementsByClassName('measures')
			if( cfCols && cfMeas && cfCols[0] && cfMeas[0] && cfMeas[0].offsetHeight > 0)
				cfCols[0].style.height = cfMeas[0].offsetHeight + 'px';
		}

		this._retrieveDataForChart = function() {
			var ret = {};
			ret.Fields = [];
			ret.FieldsDesc = [];
			ret.Types = [];
			ret.Data = [];
			ret.Config = _fjsonCopy(this.ztController.drawOpts);
			ret.State = _fjsonCopy(this.getState());
			var i, j, key, sl, sp, rows, columns, measure, index, nrow, push, lkey;
			var elKeys = [], pelKeys = [], pelKeysRows = {};
			for( i=0; i<this.ztController.drawOpts.rows.length; i++ ) {
				sl = this.ztController.drawOpts.rows[i];
				if( sl.key ) {
					ret.Fields.push(sl.key);
					ret.FieldsDesc.push(sl.key);
					ret.Types.push('C');
				}
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push(sl.type);
			}
			ret.Fields.push('rowKey');
			ret.FieldsDesc.push('rowKey');
			ret.Types.push('C');
			ret.Fields.push('rowKeyDesc');
			ret.FieldsDesc.push('rowKeyDesc');
			ret.Types.push('C');
			ret.Fields.push('rowKey_pic');
			ret.FieldsDesc.push('rowKey_pic');
			ret.Types.push('C');
			
			for( i=0; i<this.ztController.drawOpts.columns.length; i++ ) {
				sl = this.ztController.drawOpts.columns[i];
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push(sl.type);
			}
			ret.Fields.push('colKey');
			ret.FieldsDesc.push('colKey');
			ret.Types.push('C');
			ret.Fields.push('colKeyDesc');
			ret.FieldsDesc.push('colKeyDesc');
			ret.Types.push('C');
			ret.Fields.push('colKey_pic');
			ret.FieldsDesc.push('colKey_pic');
			ret.Types.push('C');
			for( i=0; i<this.ztController.drawOpts.measures.length; i++ ) {
				sl = this.ztController.drawOpts.measures[i];
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push(sl.type);
				ret.Fields.push(sl.alias + '_pic');
				ret.FieldsDesc.push(sl.desc + '_pic');
				ret.Types.push('C');
			}
			
			var rowLevels = [], colLevels = [];
			var _lrkeys = [], _lckeys = [];
			if( ret.State.rowsSubLevel.length > 0 ) rowLevels = ret.State.rowsSubLevel[ret.State.rowsSubLevel.length-1];
			if( ret.State.columnsSubLevel.length > 0 ) colLevels = ret.State.columnsSubLevel[ret.State.columnsSubLevel.length-1];

			for( i=0; i<this.valueMapKeysAndNull.length; i++ ) {
				key = this.valueMapKeysAndNull[i];
				if( elKeys.indexOf(key) >= 0) continue;
				if( key.indexOf(_level0Key) >= 0) continue;
				sl = key.split(_kSeparator);
				index = sl[0];
				rows = sl[1];
				columns = sl[2];
				measure = sl[3];
				nrow = [];
				sp = rows.split(_mSeparator);
				push = false;
				if( (rowLevels.length == 0) && (colLevels.length ==0) ) push = true;
				else {
					if( rowLevels.length > 0 ) {
						push = false;
						for( j=0; !push && j<rowLevels.length; j++ ) {
							lkey = rowLevels[j];
							if( rows.startsWith(lkey+_mSeparator) && (rows.length > lkey.length) ) {
								push = true;
							}
						}
					}
					else {
						push = true;
					}
					if( push ) {
						if( colLevels.length > 0 ) {
							push = false;
							for( j=0; !push && j<colLevels.length; j++ ) {
								lkey = colLevels[j];
								if( columns.startsWith(lkey+_mSeparator) && (columns.length > lkey.length) ) {
									push = true;
								}
							}
						}
					}
				}
				if( push ) {
					var rowsdesc='', columnsdesc='';
					var rowtitle='', columntitle='';
					for( j=0; j<Math.min(sp.length, this.ztController.drawOpts.rows.length); j++ ) {
						if((this.ztController.opts.rows[j].key))
							nrow.push(sp[j]);
						if(sp[j] == _asEmpty)
							nrow.push(null)
						else {
							var t = this.ztController._getFieldAliasKeyValue(this.ztController.opts.rows[j], sp[j]);
							nrow.push(t);
							if( Empty(rowsdesc) ) rowsdesc = t;
							else rowsdesc += ' > ' + t;
						}
						rowtitle+= ' ' + this.ztController.opts.rows[j].desc;
					}
					for( j=sp.length; j<this.ztController.drawOpts.rows.length; j++ ) {
						nrow.push(null);
					}
					nrow.push(rows); //rowskey
					nrow.push(rowsdesc);
					nrow.push(sp[sp.length-1]);
					if( _lrkeys.indexOf(rows) == -1 ) _lrkeys.push(rows);
					ret.Config.rowtitle = rowtitle;
					sp = columns.split(_mSeparator);
					var _sp = sp.slice(0, sp.length-1).join(_kSeparator);
					var w;
					for( j=0; j<Math.min(sp.length, this.ztController.drawOpts.columns.length); j++ ) {
						if((this.ztController.opts.columns[j].key))
							nrow.push(sp[j]);
						if(sp[j] == _asEmpty)
							nrow.push(null)
						else {
							var tc = this.ztController._getFieldAliasKeyValue(this.ztController.opts.columns[j], sp[j]);
							nrow.push(tc);
							if( Empty(columnsdesc) ) columnsdesc = tc;
							else columnsdesc += ' > ' + tc;
						}
						columntitle+= ' ' + this.ztController.opts.columns[j].desc;
						if( j == Math.min(sp.length, this.ztController.drawOpts.columns.length) -1 ) {
							if( this.ztController.opts.columns[j].lvalues ) {
								for( w=0; w<this.ztController.opts.columns[j].lvalues.length; w++) {
									var lv = this.ztController.opts.columns[j].lvalues[w];
									var xk
									if( _sp.length > 0 )
										xk = index+_kSeparator+rows+_kSeparator+_sp+_mSeparator+lv
									else
										xk = index+_kSeparator+rows+_kSeparator+lv
									if( pelKeys.indexOf(xk) >= 0) continue;
									pelKeys.push(xk)
									pelKeysRows[xk] = nrow.slice();
								}
							}
						}
					}
					for( j=sp.length; j<this.ztController.drawOpts.columns.length; j++ ) {
						nrow.push(null);
					}
					nrow.push(columns); //columnsskey
					nrow.push(columnsdesc);
					nrow.push(sp[sp.length-1]);
					if( _lckeys.indexOf(columns) == -1 ) _lckeys.push(columns);
					ret.Config.columntitle = columntitle;
					key = index+_kSeparator+rows+_kSeparator+columns;
					for( j=0; j<this.ztController.drawOpts.measures.length; j++ ) {
						measure = _fPad(j)+this.ztController.drawOpts.measures[j].alias;
						if( this.valueMap[key+_kSeparator+measure] ) {
							nrow.push(this.valueMap[key+_kSeparator+measure]);
						}
						else {
							nrow.push(null);
						}
						if( this.valueMap[key+_kSeparator+measure + '_pic'] ) {
							nrow.push(this.valueMap[key+_kSeparator+measure + '_pic']);
						}
						else {
							nrow.push(null);
						}
						elKeys.push(key+_kSeparator+measure);
					}
					ret.Data.push(nrow);
				}
			}

			ret.rowKeys = _lrkeys;
			ret.columnsKeys = _lckeys;

			return ret;
		}
		
		this._retrieveDataOnView = function() {
			var ret = {};
			ret.Fields = [];
			ret.FieldsDesc = [];
			ret.Types = [];
			ret.Data = [];
			ret.Config = _fjsonCopy(this.ztController.drawOpts);
			var i, j, key, sl, sp, rows, columns, measure, index, nrow;
			var elKeys = [];
			for( i=0; i<this.ztController.drawOpts.rows.length; i++ ) {
				sl = this.ztController.drawOpts.rows[i];
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push(sl.type);
				ret.Fields.push(sl.alias+ '_pic');
				ret.FieldsDesc.push(sl.desc+ '_pic');
				ret.Types.push('C');
			}
			for( i=0; i<this.ztController.drawOpts.columns.length; i++ ) {
				sl = this.ztController.drawOpts.columns[i];
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push(sl.type);
				ret.Fields.push(sl.alias+ '_pic');
				ret.FieldsDesc.push(sl.desc+ '_pic');
				ret.Types.push('C');
			}
			for( i=0; i<this.ztController.drawOpts.measures.length; i++ ) {
				sl = this.ztController.drawOpts.measures[i];
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push(sl.type);
				ret.Fields.push(sl.alias+ '_pic');
				ret.FieldsDesc.push(sl.desc+ '_pic');
				ret.Types.push('C');
			}
			
			var lkey = '', ltmp;
			nrow = [];
			for( i=0; i<this.valueMapKeys.length; i++ ) {
				key = this.valueMapKeys[i];
				if( elKeys.indexOf(key) >= 0) continue;
				if( key.indexOf(_level0Key) >= 0) continue;
				sl = key.split(_kSeparator);
				index = sl[0];
				rows = sl[1];
				columns = sl[2];
				measure = sl[3];
				if( !Empty(lkey) && lkey != (rows+_kSeparator+columns)) {
					ret.Data.push(nrow);
					nrow = [];
				}
				lkey = rows+_kSeparator+columns;
				sp = rows.split(_mSeparator);
				for( j=0; j<Math.min(sp.length, this.ztController.drawOpts.rows.length); j++ ) {
					if(sp[j] == _asEmpty) {
						nrow.push(null)
						nrow.push(null)//_pic
					}
					else{
						ltmp = this.ztController._getFieldAliasKeyValue(this.ztController.opts.rows[j], sp[j])
							if( this.ztController.opts.rows[j].type == 'N' )
								nrow.push(parseFloat(ltmp));
							else
								nrow.push(ltmp);
						nrow.push(ltmp); // _pic
					}
				}
				for( j=sp.length; j<this.ztController.drawOpts.rows.length; j++ ) {
					nrow.push(null);
				}
				sp = columns.split(_mSeparator);
				for( j=0; j<Math.min(sp.length, this.ztController.drawOpts.columns.length); j++ ) {
					if(sp[j] == _asEmpty) {
						nrow.push(null)
						nrow.push(null)//_pic
					}
					else{
						ltmp = this.ztController._getFieldAliasKeyValue(this.ztController.opts.columns[j], sp[j])
							if( this.ztController.opts.columns[j].type == 'N' )
								nrow.push(parseFloat(ltmp));
							else
								nrow.push(ltmp);
						nrow.push(ltmp); // _pic
					}
				}
				for( j=sp.length; j<this.ztController.drawOpts.columns.length; j++ ) {
					nrow.push(null);
				}
				key = index+_kSeparator+rows+_kSeparator+columns;
				for( j=0; j<this.ztController.drawOpts.measures.length; j++ ) {
					measure = _fPad(j)+this.ztController.drawOpts.measures[j].alias;
						if( this.valueMap[key+_kSeparator+measure] ) {
							nrow.push(this.valueMap[key+_kSeparator+measure]);
						}
						else {
							nrow.push(null);
						}
					if( this.valueMap[key+_kSeparator+measure+ '_pic'] ) {
						nrow.push(this.valueMap[key+_kSeparator+measure+'_pic']);
						}
						else {
							nrow.push(null);
						}
					elKeys.push(key);
				}
			}
			if( !Empty(lkey) ) {
				ret.Data.push(nrow);
				nrow = [];
			}
			return ret;
		}

		this._retrieveDataPivotOnView = function() {
			var ret = {};
			ret.Fields = [];
			ret.FieldsDesc = [];
			ret.HFieldsDesc = [];
			ret.HFieldsKey = [];
			ret.Types = [];
			ret.Data = [];
			ret.Config = _fjsonCopy(this.ztController.drawOpts);
			
			var i, j, k, key, sl, sp, rows, columns, measure, nrow;
			var elKeys = [];
			for( i=0; i<this.ztController.drawOpts.rows.length; i++ ) {
				sl = this.ztController.drawOpts.rows[i];
				ret.Fields.push(sl.alias);
				ret.FieldsDesc.push(sl.desc);
				ret.Types.push('C');
			}
			var tcolsH = this.htmlTable.getElementsByClassName("t-columns");
			rows = tcolsH[0].getElementsByTagName('tr');
			var lastrow = rows[rows.length - 1];
			var tds = lastrow.getElementsByTagName('td');
			lastrow.style.height = "0px";
			lastrow.style.visibility = 'collapse'
			for( i=0; i<tds.length; i++ ) {
				var tkey = _fGetHTMLAttribute(tds[i], 'tckey')
				var tm = _fGetHTMLAttribute(tds[i], 'tdmeasure')
				if(!tkey || !tm) continue;
				sl = tkey.split(_mSeparator);
				for ( j=0; j<sl.length; j++ ) {
					if( !ret.HFieldsDesc[j] ) {
						ret.HFieldsDesc[j] = [];
						ret.HFieldsKey[j] = [];
						for( k=0; k<this.ztController.drawOpts.rows.length; k++ ) {
							ret.HFieldsDesc[j].push(this.ztController.drawOpts.rows[k].desc);
							ret.HFieldsKey[j].push(this.ztController.drawOpts.rows[k].desc);
						}
					}
					if( tkey.indexOf(_level0Key) >= 0) ret.HFieldsDesc[j].push(this.ztController.opts.bigTotalTitle);
					else ret.HFieldsDesc[j].push(sl[j]);
					ret.HFieldsKey[j].push(sl[j])
				}
				for ( j=sl.length; j<this.ztController.drawOpts.columns.length; j++ ) {
					if( !ret.HFieldsDesc[j] ) {
						ret.HFieldsDesc[j] = [];
						ret.HFieldsKey[j] = [];
						for( k=0; k<this.ztController.drawOpts.rows.length; k++ ) {
							ret.HFieldsDesc[j].push(this.ztController.drawOpts.rows[k].desc);
							ret.HFieldsKey[j].push(this.ztController.drawOpts.rows[k].desc);
						}
					}
					ret.HFieldsDesc[j].push('');
					ret.HFieldsKey[j].push('');
				}
				if( !ret.HFieldsDesc[this.ztController.drawOpts.columns.length] ) {
					ret.HFieldsDesc[this.ztController.drawOpts.columns.length] = [];
					ret.HFieldsKey[this.ztController.drawOpts.columns.length] = [];
					for( k=0; k<this.ztController.drawOpts.rows.length; k++ ) {
						ret.HFieldsDesc[this.ztController.drawOpts.columns.length].push(this.ztController.drawOpts.rows[k].desc);
						ret.HFieldsKey[this.ztController.drawOpts.columns.length].push(this.ztController.drawOpts.rows[k].desc);
					}
				}
				var pindex = parseInt(tm.substring(0, 4))
				ret.HFieldsDesc[this.ztController.drawOpts.columns.length].push(this.ztController.drawOpts.measures[pindex].desc);
				if( tkey.indexOf(_level0Key) >= 0) ret.HFieldsKey[this.ztController.drawOpts.columns.length].push(this.ztController.opts.bigTotalTitle);
				else ret.HFieldsKey[this.ztController.drawOpts.columns.length].push(tkey);
				tkey = tkey + _mSeparator + tm
				ret.Fields.push(tkey);
				ret.FieldsDesc.push(tkey);
				ret.Types.push('N');
				ret.Fields.push(tkey+'_pic');
				ret.FieldsDesc.push(tkey+'_pic');
				ret.Types.push('C');
			}
			var lrow = '';
			nrow = [];
			for( i=0; i<this.valueMapKeys.length; i++ ) {
				key = this.valueMapKeys[i];
				if( elKeys.indexOf(key) >= 0) continue;
				//if( key.indexOf(_level0Key) >= 0) continue;
				sl = key.split(_kSeparator);
				index = sl[0];
				rows = sl[1];
				columns = sl[2];
				measure = sl[3];
				if( /*(columns==_level0Key) ||*/ (!Empty(lrow) && lrow != rows)) {
					ret.Data.push(nrow);
					nrow = [];
				}
				lrow = rows;
				if( nrow.length == 0 ) {
					sp = rows.split(_mSeparator);
					for( j=0; j<Math.min(sp.length, this.ztController.drawOpts.rows.length); j++ ) {
						if(sp[j] == _asEmpty) {
							nrow.push(null)
						}
						else {
							if( key.indexOf(_btotal) >= 0) nrow.push(this.ztController.opts.bigTotalTitle);
							//else if( key.indexOf(_level0Key) >= 0) nrow.push(this.ztController._getFieldAliasKeyValue(this.ztController.opts.rows[j], sp[j]) + 'xxx');
							else  nrow.push(this.ztController._getFieldAliasKeyValue(this.ztController.opts.rows[j], sp[j]));
						}
					}
					for( j=sp.length; j<this.ztController.drawOpts.rows.length; j++ ) {
						nrow.push(null);
					}
					for( j=this.ztController.drawOpts.rows.length; j<ret.Fields.length; j++ ) {
						nrow.push(null);
					}
				}
				var mcolumn = columns+_mSeparator+measure;
				var p = ret.Fields.indexOf(mcolumn);
				if( p < 0 ){
					ret.Fields.push(mcolumn);
					ret.FieldsDesc.push(mcolumn);
					ret.Types.push('C');
					p = ret.Fields.length-1;
					for( j=0; j<ret.Data.length; j++ ){
						ret.Data[j].push(null);
					}
				}

				if( this.valueMap[key] ) {
					nrow[p] = this.valueMap[key];
				}
				p = ret.Fields.indexOf(mcolumn+'_pic');
				if( this.valueMap[key+ '_pic'] ) {
					nrow[p] = this.valueMap[key+'_pic'];
				}
				elKeys.push(key);
			}
			if( !Empty(lrow) ) {
				ret.Data.push(nrow);
				nrow = [];
			}
			return ret;

		}

		this.init = function(initUi) {
			//var fempty = true;
			var ftableParent = null;
			if ( initUi == true || this.ztController.forceRedraw == true) {
				this.htmlContainer.innerHTML = "";
				ftableParent = this.htmlContainer;
				this.htmlZTable = null;
			}
			else {
				if( (this.ztController._initOpts.uiDragDrop || this.ztController._initOpts.print_result || this.ztController._initOpts.canFilter) && this.htmlTable ) {
					ftableParent = this.htmlTable.parentNode;
					ftableParent.innerHTML = "";
				}	
				else {
					this.htmlContainer.innerHTML = "";
					ftableParent = this.htmlContainer;
				}
			}
			  
			if ( !htmlContainer.classList.contains(this.ztController.opts.cssClass) ) {
				  htmlContainer.classList.add(this.ztController.opts.cssClass);
			}

			this.ztController.forceRedraw = false;
			  
			this.htmlContainer.style.overflowX = 'hidden';
			this.htmlContainer.style.overflowY = 'hidden';
			this.htmlContainer.style.visibility = 'hidden';

			if( !this.htmlZTable ) {
				this.htmlZTable = document.createElement('div');
				this.htmlCTable = document.createElement('div');
				this.htmlZETable = document.createElement('div');
				this.htmlContainer.appendChild(this.htmlCTable);
				this.htmlContainer.appendChild(this.htmlZETable);
				this.htmlContainer.appendChild(this.htmlZTable);
				this.htmlZTable.classList.add('drillboxer');
				this.htmlZETable.classList.add('label');
				this.ztVPivotUI = new ZtVPivotUI(this.ztController._initOpts, this.ztController.opts, this.htmlZTable, this.ztController.PSCtrl,this.ztController._wKey);
				ftableParent = this.ztVPivotUI.draw();
			}
			 
			  this.htmlTable = document.createElement('table');
			  _fSetHTMLAttribute(this.htmlContainer, "wUid", this.ztController._wKey);
			  ftableParent.appendChild(this.htmlTable);
			  this.htmlTable.classList.add("drilldown_table");
			  var tr = document.createElement('tr');
			  this.tdAreaDescription = document.createElement('td');
			  var td = this.tdAreaDescription;
			  td.classList.add("td-view-description", _cssmode);
			  tr.appendChild(this.tdAreaDescription);
			  this.tdAreaColumns = document.createElement('td');
			  td = this.tdAreaColumns;
			  td.classList.add("td-view-columns", _cssmode);
			  tr.appendChild(this.tdAreaColumns);
			  this.htmlTable.appendChild(tr);
			  
			  tr = document.createElement('tr');
			  this.tdAreaRows = document.createElement('td');
			  td = this.tdAreaRows;
			  td.classList.add("td-view-rows", _cssmode);
			  tr.appendChild(this.tdAreaRows);
			  this.tdAreaData = document.createElement('td');
			  td = this.tdAreaData;
			  td.classList.add("td-view-data", _cssmode);
			  tr.appendChild(this.tdAreaData);
			  this.htmlTable.appendChild(tr);
			  this.aggregateDataMap = [];
			  this.valueMap = [];
			  this.valueMapKeys = [];
			  this.valueMapKeysAndNull = [];

			  if( initUi ) {
			  	_this._showHideConfig();
				_this.uiClosed = true;
			  }
		}
		
		this._resetAndDraw = function(rows, columns, measures) {
			this.ztController.forceRedraw = true;
			var opts = {};
			opts.rows = [];
			opts.columns = [];
			opts.measures = [];
			var i, div, alias, o;
			var drawOpts = {};
			drawOpts.rows = [];
			drawOpts.columns = [];
			var _rows = [], _columns = [], _measures = [], _rowskeys = [], _colskeys = [];
			function getDesc(alias, fields) {
				var i;
				var ret = {};
				for( i=0; i<fields.length; i++ ) {
					if( alias.toLowerCase() == fields[i].alias.toLowerCase() ) {
						ret.desc = fields[i].desc
						if( fields[i].key ) ret.key = fields[i].key;
						return ret;
					}
						
				}
				ret.desc = alias;
				return ret;
			}
			if( !rows ) {
				var divP = document.getElementById(this.ztController._wKey + "-rows");
				var divL = divP.getElementsByClassName("row-field");
				var gv;
				for( i=0; i<divL.length; i++ ) {
					div = divL[i];
					if( div.classList.contains("moving-field"))
						continue;
					alias = _fGetHTMLAttribute(div, "alias").toLowerCase();
					o = {};
					o.alias = alias;
					gv = getDesc(alias, this.ztController.opts.fields);
					o.desc = gv.desc;
					if( gv.key ) o.key = gv.key;
					opts.rows.push(o);
					if( drawOpts.rows.length == 0) drawOpts.rows.push(o);
					_rows.push(alias);
					if(o.key) _rowskeys.push(o.key);
					else _rowskeys.push('');
				}
			}
			else {
				for( i=0; i<rows.length; i++ ) {
					alias = rows[i]
					o = {};
					o.alias = alias;
					gv = getDesc(alias, this.ztController.opts.fields);
					o.desc = gv.desc;
					if( gv.key ) o.key = gv.key;
					opts.rows.push(o);
					if( drawOpts.rows.length == 0) drawOpts.rows.push(o);
					_rows.push(alias);
					if(o.key) _rowskeys.push(o.key);
					else _rowskeys.push('');
				}
			}

			if( !columns ) {
				divP = document.getElementById(this.ztController._wKey + "-columns");
				divL = divP.getElementsByClassName("col-field");
				for( i=0; i<divL.length; i++ ) {
					div = divL[i];
					if( div.classList.contains("moving-field"))
						continue;
					alias = _fGetHTMLAttribute(div, "alias").toLowerCase();
					o = {};
					o.alias = alias;
					gv = getDesc(alias, this.ztController.opts.fields);
					o.desc = gv.desc;
					if( gv.key ) o.key = gv.key;
					opts.columns.push(o);
					_columns.push(alias);
					if(o.key) _colskeys.push(o.key);
					else _colskeys.push('');
				}
			}
			else {
				for( i=0; i<columns.length; i++ ) {
					alias = columns[i]
					o = {};
					o.alias = alias;
					gv = getDesc(alias, this.ztController.opts.fields);
					o.desc = gv.desc;
					if( gv.key ) o.key = gv.key;
					opts.columns.push(o);
					_columns.push(alias);
					if(o.key) _colskeys.push(o.key);
				}
			}

			if( !measures ) {
				divP = document.getElementById(this.ztController._wKey + "-measures");
				divL = divP.getElementsByClassName("mea-field");
				for( i=0; i<divL.length; i++ ) {
					div = divL[i];
					if( div.classList.contains("moving-field"))
						continue;
					alias = _fGetHTMLAttribute(div, "alias").toLowerCase();
					o = {};
					o.alias = alias;
					o.desc = getDesc(alias, this.ztController.opts.fields).desc;
					opts.measures.push(o);
					_measures.push(alias);
				}
			}
			else {
				for( i=0; i<measures.length; i++ ) {
					alias = measures[i]
					o = {};
					o.alias = alias;
					o.desc = getDesc(alias, this.ztController.opts.fields).desc;
					opts.measures.push(o);
					_measures.push(alias);
				}
			}

			opts.fields = this.ztController.opts.fields;
			var fb;
			if( !this.ztController.bQueryLevel) {
				this.ztController.opts = opts;
				this.ztController._checkDrawOpts(drawOpts)
				fb = this.ztController.drawOpts.filters;
				drawOpts.filters = fb;
				this.ztController.drawOpts = drawOpts;
				this.ztController.aggregateObjRets = null;
				this.ztController.drawingColumns = null;

				this.ztController.dataOpts.rows = _fjsonCopy(this.ztController.drawOpts.rows); 
				this.ztController.dataOpts.columns = _fjsonCopy(this.ztController.opts.columns); //sempre tutte le colonne
				this.ztController.dataOpts.measures = _fjsonCopy(this.ztController.drawOpts.measures);
				this.ztController.dataOpts.filters = _fjsonCopy(this.ztController.drawOpts.filters);
				this.ztController.nestedData = this.ztController.ztVPivotData.getNestedData(this.ztController.dataOpts, true);

				var fnc = function() {
					var vState = _this.mViewer.getState();
					_this.drawOpts.columnsSubLevel = vState.columnsSubLevel;
					_this.drawOpts.rowsSubLevel = vState.rowsSubLevel;
					_this._updateFiltersDiv();
					//_this.PSObserver.observe(_this.htmlContainer);
				}
				this.draw(false, fnc);
				/*if( this.ztController.PSCtrl && this.ztController.PSCtrl.dispatchEvent) 
					this.ztController.PSCtrl.dispatchEvent('UIDragDrop'); */
			}
			else {
				this.ztController.opts = opts;
				this.ztController._checkDrawOpts(drawOpts)
				fb = this.ztController.drawOpts.filters;
				drawOpts.filters = fb;
				this.ztController.drawOpts = drawOpts;
				this.ztController.aggregateObjRets = null;
				this.ztController.drawingColumns = null;
				this.ztController.PSCtrl._resetAndDraw(_rows, _columns, _measures, _rowskeys, _colskeys); //altro giro devo rieseguire le query del mleveldataprovider
			}
		}

		this.applyOnCellClick = function(e, frHtmlObj, opts) {
			if(this.ztController._initOpts.onclickFnc) {
				var rowskey = null;
				var level = null, index = null;
				var table, tr;
				if (!frHtmlObj.isRowBigTotal) {
					table = this.tdAreaRows.getElementsByClassName("t-rows");
					if (table) {
						table = table[0];
						tr = table.rows[frHtmlObj.rowIndex];
						if(tr) {
							level = parseInt(_fGetHTMLAttribute(tr, "dlevel"));
							index = parseInt(_fGetHTMLAttribute(tr, "dindex"));
							if(frHtmlObj.isRowTotal && level > 0 ) {
								level = level - 1;
							}
							if ( tr.cells.length > level ) {
								rowskey = _fGetHTMLAttribute(tr.cells[level],"trkey");
							}
						}
					}
				}
				else {
					rowskey = _level0Key+_btotal;
					table = this.tdAreaRows.getElementsByClassName("t-rows");
					if (table) {
						table = table[0];
						tr = table.rows[frHtmlObj.rowIndex];
						if(tr) {
							index = parseInt(_fGetHTMLAttribute(tr, "dindex"));
						}
					}
				}
				var o = {};
				o.isRowTotal = frHtmlObj.isRowTotal;
				o.isRowBigTotal = frHtmlObj.isRowBigTotal;
				o.isColumnBigTotal = frHtmlObj.isColumnBigTotal;
				o.isColumnTotal = frHtmlObj.isColumnTotal;
				o.rows = [];
				o.columns = [];
				o.measure = {};
				var lsplit, i, s;
				if (rowskey && rowskey.indexOf(_level0Key)<0) {
					lsplit = rowskey.split(_mSeparator);
					for (i=0; i<lsplit.length; i++) {
						s = {};
						if ( opts.rows[i].key ) 
							s.key = opts.rows[i].key;
						s.alias = opts.rows[i].alias;
						if( lsplit[i] == _asEmpty)
							s.value = null
						else {
							s.value = lsplit[i];
							if(opts.rows[i].type == 'N')
								s.value = parseFloat(s.value)
						}
						o.rows.push(s);
					}
				}
				if (frHtmlObj.columnskey && frHtmlObj.columnskey != _level0Key) {
					lsplit = frHtmlObj.columnskey.split(_mSeparator);
					for (i=0; i<lsplit.length; i++) {
						s = {};
						if ( opts.columns[i].key )
							s.key = opts.columns[i].key;
						s.alias = opts.columns[i].alias;
						s.value = lsplit[i];
						if( lsplit[i] == _asEmpty)
							s.value = null
						else {
							s.value = lsplit[i];
							if(opts.columns[i].type == 'N')
								s.value = parseFloat(s.value)
						}
						o.columns.push(s);
					}
				}
				o.measure.alias = frHtmlObj.tdmeasure.substr(_npad);
				o.measure.index = parseInt(frHtmlObj.tdmeasure.substr(0, _npad));
				if( index!= null ) {
					o.measure.value = this.valueMap[index+_kSeparator+rowskey+_kSeparator+frHtmlObj.columnskey+_kSeparator+frHtmlObj.tdmeasure];
				}
				this.ztController._initOpts.onclickFnc(e, o);
			}
		}

		this.drawColumns = function(opts, columns, columnsSort, maxColumnLevel) {
			var _dataViewer = this;
			function onSortColumn() {
				var td = this.parentNode;
				var level = td.cellIndex;
				_dataViewer.ztController.sortColumn(opts.columns[level].alias, opts.columns[level].orderfield, Empty(opts.columns[level].orderby) ? 'asc' : undefined);
			}
			function drillDownColumn(e) {
				var td = this.parentNode;
				var tr = td.parentNode;
				var key = _fGetHTMLAttribute(td, "tckey");
				var level = parseInt(_fGetHTMLAttribute(tr, "column-level"))+1;
				_dataViewer.ztController._drillDownColumn(e, level, key);
			}
			function makeTRColumnsLevel(level, opts, columns, columnsSort, key, retArr, maxColumnLevel) {
				var ret = 0;
				if( level > opts.columns.length-1 ) {
					return ret;
				}
				if ( columns[key] || columns[level + _nSeparator + key] ) {
					var columnsLevel = columns[level + _nSeparator + key];
					if (!columnsLevel) {
						columnsLevel = columns[key];
					}

					if(!retArr[level]) {
						retArr[level] = document.createElement('tr');
					}
					if( opts.columns[level].orderby && columnsSort[level + _nSeparator + key] == undefined) {
						_dataViewer.ztController._sortColumnsRollingUp(opts, level, columnsLevel, key);
						columnsSort[level + _nSeparator + key]="";
					}
					
					var tr = retArr[level];
					_fSetHTMLAttribute(tr, "column-level", level);
					
					if (level>0 && retArr[level-1]) {
						var trp = retArr[level-1];
						var tdp = trp.lastChild.previousSibling;//trp.cells[tr.cells.length-1];
						while (tdp && (tdp.classList.contains("td-subempty") || tdp.classList.contains("td-subtotal") || tdp.classList.contains("td-bigtotal"))) {
							tdp = tdp.previousSibling;
						}
						if ( tdp ) {
							tdp = tdp.nextSibling;
						}
						else if(trp.firstChild) {
							tdp = trp.firstChild;
						}
						while (tdp && (tdp.classList.contains("td-subempty") || tdp.classList.contains("td-subtotal") || tdp.classList.contains("td-bigtotal"))) {
							var tdx = document.createElement('td');
							var divx = document.createElement('div');
							divx.classList.add("columndiv", _cssmode);
							tdx.appendChild(divx);
							if (tdp.classList.contains("td-subtotal")) {
								tdx.classList.add("td-view-column", "td-subtotal", _cssmode);
								//tdx.classList.add("td-view-lastlevel");
							}
							else if (tdp.classList.contains("td-bigtotal")) {
								tdx.classList.add("td-view-column", "td-bigtotal", "td-view-title", _cssmode);
								//tdx.classList.add("td-view-lastlevel");
							}
							else {
								tdx.classList.add("td-view-column", "td-subempty", _cssmode);
							}
							_fSetHTMLAttribute(tdx, "tckey", _fGetHTMLAttribute(tdp, "tckey"));
							if(opts.measuresOnColumn) {
								tdx.colSpan = opts.measures.length;
								if( opts.measures.length>0 )divx.classList.add(opts.measures[0].alias);
							}
							else tdx.colSpan = 1;
							tr.appendChild(tdx);
							tdp = tdp.nextSibling;
						}
					}

					var td, div;
					if( level > 0 && opts.columnsSubLevel) {
						if(opts.columnsSubLevel[level-1] && opts.columnsSubLevel[level-1].length>0 && opts.columnsSubLevel[level-1].indexOf(key)>=0) {}
						else {
							td = document.createElement('td');
							div = document.createElement('div');
							div.classList.add("columndiv", _cssmode);
							td.appendChild(div);
							td.classList.add("td-view-column", "td-subempty", _cssmode);
							tr.appendChild(td);
							_fSetHTMLAttribute(td, "tckey", key);
							if(opts.measuresOnColumn) {
								td.colSpan = opts.measures.length;
								if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
							}
							else td.colSpan = 1;
							return ret;
						}
					}

					for ( var i=0; i<columnsLevel.length; i++) {
						if ( columnsLevel[i].indexOf(_znull) >= 0 ) { //nModif
							continue;
						}
						td = document.createElement('td');
						div = document.createElement('div');
						div.classList.add("columndiv", _cssmode);
						if ( columnsLevel[i] != _znull ) {
							_fApplyPicture(_dataViewer.ztController._getFieldAliasKeyValue(opts.columns[level], columnsLevel[i])+'', opts.columns[level].pictureFnc, div, opts.columns[level].type);//div.innerHTML = ToHTML(_dataViewer.ztController._getFieldAliasKeyValue(opts.columns[level], columnsLevel[i]));//ToHTML(columnsLevel[i]);
							div.title = columnsLevel[i];
						}
						td.appendChild(div);
						td.classList.add("td-view-column", _cssmode);
						tr.appendChild(td);
						
						var r = 0;
						if ( key == _level0Key ) {
							_fSetHTMLAttribute(td, "tckey", columnsLevel[i]);
							r = makeTRColumnsLevel(level+1, opts, columns, columnsSort, columnsLevel[i], retArr, maxColumnLevel);
							if ( r > 0 ) {
								td.colSpan = r;
								
								div.classList.add("toggle");
								div.classList.add("openlevel", "columndiv", "columntitle", _cssmode);
								div.classList.remove("closelevel");
								div.style.cursor = 'pointer';
								div.onclick = drillDownColumn;
								if(opts.measuresOnColumn) {
									if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
								}
							}
							else {
								if (level < maxColumnLevel-1) {
									div.classList.add("toggle");
									div.classList.add("closelevel", "columndiv", "columntitle", _cssmode);
									div.classList.remove("openlevel");
									div.style.cursor = 'pointer';
									div.onclick = drillDownColumn;
								}
								else {
									div.classList.add("columndiv", "columntitle", _cssmode);
									div.style.cursor = 'default';
									td.classList.add("td-view-title");
								}
								if(opts.measuresOnColumn) {
									td.colSpan = opts.measures.length;
									if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
								}
								else td.colSpan = 1;
							}
							ret += td.colSpan;
						}
						else {
							_fSetHTMLAttribute(td, "tckey", key+_mSeparator+columnsLevel[i]);
							r = makeTRColumnsLevel(level+1, opts, columns, columnsSort, key+_mSeparator+columnsLevel[i], retArr, maxColumnLevel);
							if ( r > 0 ) {
								td.colSpan = r;
								div.classList.add("toggle");
								div.classList.add("openlevel", "columndiv", "columntitle", _cssmode);
								div.classList.remove("closelevel");
								div.style.cursor = 'pointer';
								div.onclick = drillDownColumn;
								if(opts.measuresOnColumn) {
									if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
								}
							}
							else {
								if (level < maxColumnLevel-1) {
									div.classList.add("toggle");
									div.classList.add("closelevel", "columndiv", "columntitle", _cssmode);
									div.classList.remove("openlevel");
									div.style.cursor = 'pointer';
									div.onclick = drillDownColumn;
								}
								else {
									div.classList.add("columndiv", "columntitle", _cssmode);
									div.style.cursor = 'default';
									td.classList.add("td-view-title");
								}
								if(opts.measuresOnColumn) {
									td.colSpan = opts.measures.length;
									if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
								}
								else td.colSpan = 1;
							}
							ret += td.colSpan
						}
						if( _this._initOpts.canFilter ) {
							td.onmouseover = function(e) {
								if( _this.PSCtrl && _this.PSCtrl.HoverFilterObjByExample) {
									var rkey = this.getAttribute("tckey");
									if( rkey != null ) {
										var sp = rkey.split(_mSeparator);
										_this.PSCtrl.HoverFilterObjByExample(e, this.firstChild, _this.opts.columns[sp.length-1].alias, "col:"+rkey)
									}
								}
							}
							td.onmouseleave = function(e) {
								var rkey = this.getAttribute("tckey");
								if( rkey != null ) {
									if( _this.PSCtrl && _this.PSCtrl.OutFilterObjByExample) {
										_this.PSCtrl.OutFilterObjByExample(e, this, "tckey", rkey)
									}
								}
							}
						}
						//subtotal columns?
						if ( r > 0 && opts.subTotalOnColumn && (level < opts.columns.length-1) ) {
							if(opts.measuresOnColumn) td.colSpan += opts.measures.length;
							else td.colSpan += 1;
							if(opts.measuresOnColumn) ret += opts.measures.length;
							else ret += 1;
						}
					}
					var lsplit;
					if ( opts.subTotalOnColumn && (level <= opts.columns.length-1) && (key !=_level0Key)) {
						td = document.createElement('td');
						div = document.createElement('div');
						div.classList.add("columndiv", "columntitle", "columntotal", _cssmode);
						_fSetHTMLAttribute(td, "tckey", key);
						if(opts.measuresOnColumn) {
							td.colSpan = opts.measures.length;
							if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
						}
						else td.colSpan = 1;
						lsplit = key.split(_mSeparator);
						var v = _dataViewer.ztController._getFieldAliasKeyValue(opts.columns[lsplit.length-1], lsplit[lsplit.length-1])
						v += " [" + _fGetCounter(columns[level+_nSeparator+key]) + "]";
						var k;
						if( !Empty(opts.subTotalTitle) ) v+= "["+ opts.subTotalTitle + "]";
						div.innerHTML = ToHTML(v);
						td.appendChild(div);
						td.classList.add("td-view-column", "td-subtotal", _cssmode);
						td.classList.add("td-view-title");
						tr.appendChild(td);
						if(opts.measuresOnColumn) {
							for( k=1; k<opts.measures.length; k++ ) {
								div = document.createElement('div');
								div.classList.add("columndiv", "columntitle", "columntotal", _cssmode);	
								div.classList.add(opts.measures[k].alias);
								td.appendChild(div);
							}
						}
					}
					if ( opts.bigTotalOnColumn && (key ==_level0Key) ) {
						td = document.createElement('td');
						div = document.createElement('div');
						div.classList.add("columndiv", "columntitle", "columnbigtotal", _cssmode);
						_fSetHTMLAttribute(td, "tckey", key);
						if(opts.measuresOnColumn) {
							td.colSpan = opts.measures.length;
							if( opts.measures.length>0 ) div.classList.add(opts.measures[0].alias);
						}
						else td.colSpan = 1;
						lsplit = key.split(_mSeparator);
						div.innerHTML = ToHTML(opts.bigTotalTitle);
						td.appendChild(div);
						td.classList.add("td-view-column", "td-bigtotal", "td-view-title", _cssmode);
						tr.appendChild(td);
						if(opts.measuresOnColumn) {
							for( k=1; k<opts.measures.length; k++ ) {
								div = document.createElement('div');
								div.classList.add("columndiv", "columntitle", "columnbigtotal", _cssmode);	
								div.classList.add(opts.measures[k].alias);
								td.appendChild(div);
							}
						}
					}
					
				}
				return ret;
			}
		
			var retArr = [];
			
			makeTRColumnsLevel(0, opts, columns, columnsSort, _level0Key, retArr, maxColumnLevel);
      
			var tr, i, j;
			for (i=retArr.length-1; i>0; i--) {
				tr = retArr[i];
				for (j=i; j>0; j--) {
					var trp = retArr[j-1];
					if (trp) {
						var tdp = trp.lastChild;
						while (tdp && (tdp.classList.contains("td-subempty") || tdp.classList.contains("td-subtotal") || tdp.classList.contains("td-bigtotal"))) {
							tdp = tdp.previousSibling;
						}
						if ( tdp ) {
							tdp = tdp.nextSibling;
						}
						else if(trp.firstChild) {
							tdp = trp.firstChild;
						}
						while (tdp && (tdp.classList.contains("td-subempty") || tdp.classList.contains("td-subtotal")|| tdp.classList.contains("td-bigtotal"))) {
							var tdx = document.createElement('td');
							var divx = document.createElement('div');
							divx.classList.add("columndiv", _cssmode);
							//divx.innerHTML = tdp.firstChild.innerHTML;
							tdx.appendChild(divx);
							if (tdp.classList.contains("td-subtotal")) {
								tdx.classList.add("td-view-column", "td-subtotal", _cssmode);
							}
							else if (tdp.classList.contains("td-bigtotal")) {
								tdx.classList.add("td-view-column", "td-bigtotal", "td-view-title", _cssmode);
							}
							else {
								tdx.classList.add("td-view-column", "td-subempty", _cssmode);
							}
							_fSetHTMLAttribute(tdx, "tckey", _fGetHTMLAttribute(tdp, "tckey"));
							if(opts.measuresOnColumn) {
								tdx.colSpan = opts.measures.length;
								if( opts.measures.length>0 ) divx.classList.add(opts.measures[0].alias);
							}
							else tdx.colSpan = 1;
							tr.appendChild(tdx);
							tdp = tdp.nextSibling;
						}
					}
				}
			}		
	
			this.tdAreaColumns.innerHTML = "";
			var table = document.createElement('table');
			table.classList.add("t-columns-title", _cssmode);
			tr = document.createElement('tr');
			tr.classList.add("t-columns-head", _cssmode);
			var div;
			for (i=0; i<opts.columns.length; i++) {
				var td = document.createElement('td');
				td.classList.add("td-columns-title", _cssmode);
				div = document.createElement('div');
				div.classList.add("columnheader", _cssmode);
				div.style.cursor = 'default';
				if( opts.sortColumn == true ) {
					if(opts.columns[i].orderby == 'desc') {
					  div.classList.add("col-asc");
					}
					else if(opts.columns[i].orderby == 'asc') {
					  div.classList.add("col-desc");
					}
					else{
						div.classList.add("col-sort");
					}
					div.onclick = onSortColumn;
					div.style.cursor = 'pointer';
				}
				div.innerHTML = ToHTML(opts.columns[i].desc);
				td.appendChild(div);
				div.style.cssFloat = 'left';
				div = document.createElement('div');
				div.classList.add("columnheader", "rem_filter", _cssmode);
				_fSetHTMLAttribute(div, "alias", opts.columns[i].alias)
				if( _this.PSCtrl && _this.PSCtrl.pvGetTranslate ) div.title = _this.PSCtrl.pvGetTranslate("Remove_Filters");
				div.onclick = function() {
					_this._removeFilterData(_fGetHTMLAttribute(this, 'alias'));
				}
				div.style.cursor = 'pointer';
				div.style.display = 'none';
				td.appendChild(div);
				tr.appendChild(td);
			}
			table.appendChild(tr);
			
			var table2 = document.createElement('table');
			table2.classList.add("t-columns", _cssmode);
			for ( i=0; i<retArr.length; i++) {
				table2.appendChild(retArr[i]);
			}

			div = document.createElement('div');
			div.classList.add("tdiv-data-columns", _cssmode);
			var divz = document.createElement('div');
			divz.classList.add("tdiv-columns", _cssmode);
			div.appendChild(table);
			div.appendChild(divz);
			
			divz.appendChild(table2);
			this.tdAreaColumns.appendChild(div);
			if(opts.measuresOnColumn) {
				var trmeasures = document.createElement('tr');
				if (retArr.length > 0) {
					var tds = retArr[retArr.length-1].cells;
					for ( i=0; i<tds.length; i++) {
						for (j=0; j<opts.measures.length; j++) {
							td = document.createElement('td');
							div = document.createElement('div');
							div.classList.add("columndiv", "measuretitle", "measure"+j, _cssmode, opts.measures[j].alias);
							if(!opts.hideMeasures) div.innerHTML = ToHTML(opts.measures[j].desc);
							td.appendChild(div);
							_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(tds[i], "class"));
							_fSetHTMLAttribute(td, "tckey", _fGetHTMLAttribute(tds[i], "tckey"));
							_fSetHTMLAttribute(td, "tdmeasure", _fPad(j)+opts.measures[j].alias);
							td.classList.add("td-measuretitle", "measure"+j, _cssmode);
							trmeasures.appendChild(td);
						}
					}
				}
				table2.appendChild(trmeasures);
				return trmeasures;
			}
			else {
				return retArr[retArr.length-1];
			}
		}
		
		this.drawRows = function(opts, objRets, columnsTdCells, maxRowLevel, maxSubRowLevel) {
			var _dataViewer = this;
			function onSortRow() {
				var td = this.parentNode;
				var level = td.cellIndex;
				_dataViewer.ztController.sortRow(opts.rows[level].alias, opts.rows[level].orderfield, Empty(opts.rows[level].orderby) ? 'asc' : undefined);
			}
			function drillDownRow(e) {
				var td = this.parentNode;
				var key = _fGetHTMLAttribute(td, "trkey");
				var level = td.cellIndex;
				_dataViewer.ztController._drillDownRow(e, level, key);
			}

			function onmouseRowOver(e) {
				var div = e.target;
				div.parentNode.parentNode.classList.add('gridrow_over'); //tr
				var rindex = div.parentNode.parentNode.rowIndex;
				var trows = _this.htmlContainer.getElementsByClassName('t-data');
				var ttable = trows[0];
				ttable.rows[rindex].classList.add('gridrow_over')
			}

			function onmouseRowLeave(e) {
				var div = e.target;
				div.parentNode.parentNode.classList.remove('gridrow_over'); //tr
				var rindex = div.parentNode.parentNode.rowIndex;
				var trows = _this.htmlContainer.getElementsByClassName('t-data');
				var ttable = trows[0];
				ttable.rows[rindex].classList.remove('gridrow_over')
			}
			
			function oncellClick(e) {
				if(_dataViewer.ztController._initOpts.onclickFnc) {
					var div = e.target;
					var td = this.parentNode;
					var frHtmlObj = {};
					frHtmlObj.columnskey = _fGetHTMLAttribute(td, "tckey");
					frHtmlObj.tdmeasure = _fGetHTMLAttribute(td, "tdmeasure");
					frHtmlObj.cellIndex = td.cellIndex;
					var tr = td.parentNode;
					frHtmlObj.rowIndex = tr.rowIndex;
					frHtmlObj.isColumnTotal = td.classList.contains("td-subtotal");
					frHtmlObj.isRowTotal = td.classList.contains("td-row-subtotal")
					frHtmlObj.isColumnBigTotal = td.classList.contains("td-bigtotal");
					frHtmlObj.isRowBigTotal = td.classList.contains("td-row-bigtotal")
					frHtmlObj.textHTML = div.innerHTML;
					_dataViewer.applyOnCellClick(e, frHtmlObj, _dataViewer.ztController.opts);
				}
			}

			function onmouseOver(e) {
				var div = e.target;
				var i, tr, tckey, tw, td;
				div.parentNode.parentNode.classList.add('gridrow_over'); //tr
				var rindex = div.parentNode.parentNode.rowIndex;
				var cindex = div.parentNode.cellIndex;
				var trows = _this.htmlContainer.getElementsByClassName('t-rows');
				var ttable = trows[0];
				ttable.rows[rindex].classList.add('gridrow_over')

				ttable = div.parentNode.parentNode.parentNode;
				for( i=0; i<ttable.rows.length; i++ ) {
					tr = ttable.rows[i];
					tr.cells[cindex].classList.add('gridrow_over');
				}

				var tcols = _this.htmlContainer.getElementsByClassName('t-columns');
				ttable = tcols[0];
				tr = ttable.rows[ttable.rows.length-1];
				tr.cells[cindex].classList.add('gridrow_over');
				tckey = _fGetHTMLAttribute(tr.cells[cindex], 'tckey')
				tckey = tckey.split(_mSeparator)
				for( i=0; i<ttable.rows.length-1; i++ ) {
					tr = ttable.rows[i];
					if( i == 0 ) tw = tckey[i];
					else if(tckey.length > i ) tw += _mSeparator + tckey[i];
					td = tr.querySelector("[tckey=\"" + tw + "\"]");
					if( td ) td.classList.add('gridrow_over');
				}		
			}

			function onmouseLeave(e) {
				var div = e.target;
				var i, tr, tckey, tw, td;
				div.parentNode.parentNode.classList.remove('gridrow_over'); //tr
				var trows = _this.htmlContainer.getElementsByClassName('t-rows');
				var rindex = div.parentNode.parentNode.rowIndex;
				var cindex = div.parentNode.cellIndex;
				var ttable = trows[0];
				ttable.rows[rindex].classList.remove('gridrow_over');

				ttable = div.parentNode.parentNode.parentNode;
				for( i=0; i<ttable.rows.length; i++ ) {
					tr = ttable.rows[i];
					tr.cells[cindex].classList.remove('gridrow_over');
				}

				var tcols = _this.htmlContainer.getElementsByClassName('t-columns');
				ttable = tcols[0];
				tr = ttable.rows[ttable.rows.length-1];
				tr.cells[cindex].classList.remove('gridrow_over');
				tckey = _fGetHTMLAttribute(tr.cells[cindex], 'tckey')
				tckey = tckey.split(_mSeparator)
				for( i=0; i<ttable.rows.length-1; i++ ) {
					tr = ttable.rows[i];
					if( i == 0 ) tw = tckey[i];
					else if(tckey.length > i ) tw += _mSeparator + tckey[i];
					td = tr.querySelector("[tckey=\"" + tw + "\"]");
					if( td ) td.classList.remove('gridrow_over');
				}
			}
			
			function makeTRRowsDataWithMeasures(index, level, refObj, opts, columnsTds, rows, key, retRows, retData, maxRowLevel, maxSubRowLevel, measuresMap, bigTotal) {
				var mrows = Math.min(maxSubRowLevel, opts.rows.length);
				if ( rows[key] ) {
					var tr, td, div, j, measure, tdmeasure, ao, columnkey, k, i, trdata, ltr, ltd, n, tckey, lastDataTr;
					if (  Array.isArray(rows[key]) ) {
						if( level > 0 && opts.rowsSubLevel) {
							if(opts.rowsSubLevel[level-1] && opts.rowsSubLevel[level-1].length>0 && opts.rowsSubLevel[level-1].indexOf(key)>=0) {
							}
							else {
								for (k=0; k<opts.measures.length; k++) {
									measure = opts.measures[k];
									tr = retRows[retRows.length-(1+k)];
									if ( tr ) {
										td = tr.cells[level-1];
										div = td.firstChild;
										if (div.innerHTML.length > 0) {
											div.classList.add("toggle", "closelevel", _cssmode);
											div.classList.remove("openlevel");
										}
										for(j=level; j<opts.rows.length - tr.cells.length; j++) {
											td = document.createElement('td');
											div = document.createElement('div');
											td.appendChild(div);
											td.classList.add("td-view-row", "td-row-subempty", _cssmode);
											tr.appendChild(td);
										}
									}
									lastDataTr = retData[retData.length-(1+k)];
									if ( lastDataTr ) {
										for ( j=0; j<lastDataTr.cells.length; j++) {
											td = lastDataTr.cells[j];
											columnkey = _fGetHTMLAttribute(td, "tckey");
											tdmeasure = _fGetHTMLAttribute(td, "tdmeasure");
											ao = _dataViewer.getAggregateValue(rows, key, index);
											if ( ao && ao[columnkey]) {
												var v;
												if(measuresMap[tdmeasure]) {
													v = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].pictureFnc, td.children[0]);
												}
												else {
													v = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], null, td.children[0]); //assegnazione valori
												}
												if(measuresMap[tdmeasure]) {
													_fApplyCss(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].cssFnc, td, key, columnkey, tdmeasure.substr(_npad));//td.classList.add(measuresMap[tdmeasure].cssFnc(ao[columnkey][tdmeasure.substr(_npad)]));
												}
												_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure] = ao[columnkey][tdmeasure.substr(_npad)];
												_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure + '_pic'] = v;
												_dataViewer.valueMapKeys.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
												if(_dataViewer.ztController._initOpts.onclickFnc) {
													div = td.children[0];
													div.style.cursor = 'pointer';
													div.onclick = oncellClick; //lastdata bigtotal? empty?
												}
												if( td.children[0])
													div = td.children[0];
												else
													div = td;
												div.onmouseover = onmouseOver;
												div.onmouseleave = onmouseLeave;
											}
											_dataViewer.valueMapKeysAndNull.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
										}
									}
								}
								return;
							}
						}

						for ( var l=0; l<rows[key].length; l++) {
							var o = rows[key][l];
							if ( o.value == _znull ) {
								continue;
							}
							if ( o.level < opts.rows.length ) {
								tr = document.createElement('tr');
								_fSetHTMLAttribute(tr, "dlevel", o.level);	
								_fSetHTMLAttribute(tr, "dindex", index);
								//add row
								for(j=0; j<mrows+1; j++) {
									td = document.createElement('td');
									div = document.createElement('div');
									if ( j == o.level ) {
										_fApplyPicture(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[level], o.value)+'', opts.rows[level].pictureFnc, div, opts.rows[level].type);//div.innerHTML = ToHTML(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[o.level], o.value));//ToHTML(o.value);
										div.title = o.value;
										if (key == _level0Key) {
											_fSetHTMLAttribute(td, "trkey", o.value);
										}
										else {
											_fSetHTMLAttribute(td, "trkey", key+_mSeparator+o.value);
										}
										if ((j==opts.rows.length-1 && j==maxRowLevel-1)) {
											div.style.cursor = 'default';
										}
										else  if(!bigTotal && j==opts.rows.length-1 && j<maxRowLevel-1) {
											div.classList.add("toggle", "closelevel", _cssmode);
											div.classList.remove("openlevel");
											div.style.cursor = 'pointer';
											div.onclick = drillDownRow;
										}
										else if(!bigTotal){
											div.classList.add("toggle", "openlevel", _cssmode);
											div.classList.remove("closelevel");
											div.style.cursor = 'pointer';
											div.onclick = drillDownRow;
										}
										div.onmouseover = onmouseRowOver;
										div.onmouseleave = onmouseRowLeave;
									}
									else if (retRows[retRows.length-1]) {
										ltr = retRows[retRows.length-1];
										ltd = ltr.cells[j];
										_fSetHTMLAttribute(td, "trkey", _fGetHTMLAttribute(ltd, "trkey"));
									}
									if( !bigTotal && _this._initOpts.canFilter )  {
										td.onmouseover = function(e) {
											if( _this.PSCtrl && _this.PSCtrl.HoverFilterObjByExample) {
												var rkey = this.getAttribute("trkey");
												if( rkey != null ) {
													var sp = rkey.split(_mSeparator);
													_this.PSCtrl.HoverFilterObjByExample(e, this.firstChild, _this.opts.rows[sp.length-1].alias, "row:"+rkey)
												}
											}
										}
										td.onmouseleave = function(e) {
											var rkey = this.getAttribute("trkey");
											if( rkey != null ) {
												if( _this.PSCtrl && _this.PSCtrl.OutFilterObjByExample) {
													_this.PSCtrl.OutFilterObjByExample(e, this, "trkey", rkey)
												}
											}
										}
									}
									td.appendChild(div);
									if (bigTotal) {
										td.classList.add("td-view-row", "td-row-bigtotal", "measure"+l, _cssmode);
									}
									else {
										td.classList.add("td-view-row", "measure"+k, _cssmode);
									}
									tr.appendChild(td);
								}
								
								var trows = [];
								var tdatarows = [];
								for(i=0; i<opts.measures.length; i++) {
									measure = opts.measures[i];
									var trp = tr.cloneNode(true);
									for (n=0; n<trp.cells.length-1; n++) {
										if (i!=0 && n == o.level) {
											trp.cells[n].firstChild.innerHTML = "";
											trp.cells[n].firstChild.style.cursor = 'default';
											trp.cells[n].firstChild.onclick = null;
											trp.cells[n].firstChild.classList.remove("toggle");
											trp.cells[n].firstChild.classList.remove("openlevel");
											trp.cells[n].firstChild.classList.remove("closelevel");
										}
										else if (trp.cells[n].firstChild.style.cursor == 'pointer'){
											trp.cells[n].firstChild.onclick = drillDownRow;
											//div.onmouseover = onmouseRowOver;
											//div.onmouseleave = onmouseRowLeave;
										}
									}
									if(!opts.hideMeasures) trp.cells[trp.cells.length-1].firstChild.innerHTML = ToHTML(measure.desc);
									trows.push(trp);									
									trdata = document.createElement('tr');
									_fSetHTMLAttribute(trdata, "dlevel", o.level);
									_fSetHTMLAttribute(trdata, "dindex", index);
									for ( j=0; j<columnsTds.length; j++) {
										td = document.createElement('td');
										div = document.createElement('div');
										div.classList.add("columndiv", "columndata",  "measure"+i, _cssmode, opts.measures[i].alias);
										tckey = _fGetHTMLAttribute(columnsTds[j], "tckey");
										_fSetHTMLAttribute(td, "tckey", tckey);
										tdmeasure = _fPad(i)+measure.alias;
										_fSetHTMLAttribute(td, "tdmeasure", tdmeasure);
										td.appendChild(div);
										_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class")  + " td-view-data-measure" + " measure"+i);//td.classList.add("td-view-data-measure");
										if(bigTotal) {
											_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-row-bigtotal" + " measure"+i);
										}
										trdata.appendChild(td);
									}
									tdatarows.push(trdata);
								}
								for(n=0; n<tdatarows.length; n++) {
									if (retRows[retRows.length-(opts.measures.length-n)]) {
										var dlevel = _fGetHTMLAttribute(retRows[retRows.length-(opts.measures.length-n)], "dlevel");
										if(parseInt(dlevel) == (o.level-1)) {
											tr = retRows[retRows.length-(opts.measures.length-n)];
											_fSetHTMLAttribute(tr, "dlevel", o.level);
											_fSetHTMLAttribute(tr, "dindex", index);
											div = tr.cells[o.level].firstChild;
											div.innerHTML = trows[n].cells[o.level].firstChild.innerHTML;
											div.title = o.value;
											if ( (o.level==opts.rows.length-1 && o.level==maxRowLevel-1)) {
												div.style.cursor = 'default';
											}
											else  if( n==0 && !bigTotal && o.level==opts.rows.length-1 && o.level<maxRowLevel-1) {
												div.classList.add("toggle", "closelevel", _cssmode);
												div.classList.remove("openlevel");
												div.style.cursor = 'pointer';
												div.onclick = drillDownRow;
											}
											else if(n==0 && !bigTotal){
												div.classList.add("toggle", "openlevel", _cssmode);
												div.classList.remove("closelevel");
												div.style.cursor = 'pointer';
												div.onclick = drillDownRow;
											}
											div.onmouseover = onmouseRowOver;
											div.onmouseleave = onmouseRowLeave;
											if ( o.level == 0 ) {
												_fSetHTMLAttribute(tr.cells[o.level], "trkey", o.value);
											}
											else { //o.level > 0
												var prKey = _fGetHTMLAttribute(tr.cells[o.level-1], "trkey");
												_fSetHTMLAttribute(tr.cells[o.level], "trkey", prKey + _mSeparator + o.value)
											}
											trdata = retData[retData.length-1];
											_fSetHTMLAttribute(trdata, "dlevel", o.level);
											_fSetHTMLAttribute(trdata, "dindex", index);
										}
										else {
											retRows.push(trows[n]);
											retData.push(tdatarows[n]);
										}
									}
									else {
										retRows.push(trows[n]);
										retData.push(tdatarows[n]);
									}
								}						
							}
							if ( o.value != _znull ) {
								makeTRRowsDataWithMeasures(index, level+1,refObj, opts, columnsTds, rows, key+_mSeparator+o.value, retRows, retData, maxRowLevel, maxSubRowLevel, measuresMap, false); // eslint-disable-line max-len
							}
						}
						//subtotalonrow
						if ( opts.subTotalOnRow ) {
							tr = document.createElement('tr');
							_fSetHTMLAttribute(tr, "dlevel", level);
							_fSetHTMLAttribute(tr, "dindex", index);
							for(i=0; i<mrows+1; i++) {
								td = document.createElement('td');
								div = document.createElement('div');
								td.classList.add("td-view-row", "td-row-subtotal", _cssmode);
								if ( (opts.subTotalOnRowLevel && (i == level-1)) ||  (!opts.subTotalOnRowLevel && (i == level)) ) {
									var lsplit = key.split(_mSeparator);
									var vx = _dataViewer.ztController._getFieldAliasKeyValue(opts.rows[lsplit.length-1], lsplit[lsplit.length-1])
									vx += " [" + _fGetCounter(rows[key]) + "]";
									if( !Empty(opts.subTotalTitle) ) vx+= "["+ opts.subTotalTitle + "]";
									div.innerHTML = ToHTML(vx);
									td.classList.add("td-row-subtotal-mark");
								}
								_fSetHTMLAttribute(td, "trkey", key);
								div.style.cursor = 'default';
								td.appendChild(div);
								tr.appendChild(td);
							}
							for ( i=0; i<opts.measures.length; i++) {
								measure = opts.measures[i];
								var trc = tr.cloneNode(true);
								if(!opts.hideMeasures)  trc.cells[trc.cells.length-1].firstChild.innerHTML = ToHTML(measure.desc);
								if ( i!=0 && trc.cells[level-1] && opts.subTotalOnRowLevel) {
									trc.cells[level-1].firstChild.innerHTML = "";
								}
								if ( i!=0 && trc.cells[level] && !opts.subTotalOnRowLevel) {
									trc.cells[level].firstChild.innerHTML = "";
								}
								trc.cells[trc.cells.length-1].classList.add("td-row-subtotal-mark");
								if((trc.cells.length-2 > 0 ) && trc.cells[trc.cells.length-2].firstChild ){
									div = trc.cells[trc.cells.length-2].firstChild;
									div.onmouseover = onmouseRowOver;
									div.onmouseleave = onmouseRowLeave;
								}
								for ( j=0; j<trc.cells.length; j++) {
									trc.cells[j].classList.add("measure"+i);
									div = trc.cells[j].firstChild;
									div.onmouseover = onmouseRowOver;
									div.onmouseleave = onmouseRowLeave;
								}
								trdata = document.createElement('tr');
								_fSetHTMLAttribute(trdata, "dlevel", level);
								_fSetHTMLAttribute(trdata, "dindex", index);
								for ( j=0; j<columnsTds.length; j++) {
									td = document.createElement('td');
									div = document.createElement('div');
									div.classList.add("columndiv", "columndata", "measure"+i, _cssmode, opts.measures[i].alias);
									div.style.cursor = 'default';
									tckey = _fGetHTMLAttribute(columnsTds[j], "tckey");
									_fSetHTMLAttribute(td, "tckey", tckey);
									tdmeasure = _fPad(i)+measure.alias
									_fSetHTMLAttribute(td, "tdmeasure", tdmeasure);
									td.appendChild(div);
									_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-view-data-measure td-row-subtotal td-row-subtotal-mark" + " measure"+i);//td.classList.add("td-view-data-measure");
									if(bigTotal) {
										_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-row-bigtotal" + " measure"+i);
									}
									trdata.appendChild(td);
									ao = _dataViewer.getAggregateValue(rows, key, index);
									columnkey = tckey;
									if ( ao && ao[columnkey]) {	
										var vz;							
										if(measuresMap[tdmeasure]) {
											vz = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].pictureFnc, td.children[0]);
										}
										else {
											vz = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], null, td.children[0]); //assegnazione valori
										}
										if(measuresMap[tdmeasure]) {
											_fApplyCss(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].cssFnc, td, key, columnkey, tdmeasure.substr(_npad));//td.classList.add(measuresMap[tdmeasure].cssFnc(ao[columnkey][tdmeasure.substr(_npad)]));
										}
										_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure] = ao[columnkey][tdmeasure.substr(_npad)];
										_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure + '_pic'] = vz;
										_dataViewer.valueMapKeys.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
										if(_dataViewer.ztController._initOpts.onclickFnc) {
											div = td.children[0];
											div.style.cursor = 'pointer';
											div.onclick = oncellClick; //subtotal
										}
										if( td.children[0])
											div = td.children[0];
										else
											div = td;
										div.onmouseover = onmouseOver;
										div.onmouseleave = onmouseLeave;
									}
									_dataViewer.valueMapKeysAndNull.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
								}
								retRows.push(trc);
								retData.push(trdata);
							}
						}
					}
					else if(rows[key].level != undefined && rows[key].value != _znull){ //new rows
						for(k=0; k<opts.measures.length; k++) {
							measure = opts.measures[k];
							tr = document.createElement('tr');
							_fSetHTMLAttribute(tr, "dlevel", rows[key].level);
							_fSetHTMLAttribute(tr, "dindex", index);
							trdata = document.createElement('tr');
							_fSetHTMLAttribute(trdata, "dlevel", rows[key].level);
							_fSetHTMLAttribute(trdata, "dindex", index);
							//add rows
							for(i=0; i<mrows+1; i++) {
								td = document.createElement('td');
								div = document.createElement('div');
								if ( i == rows[key].level) {
									if ( k == 0 ) {
										_fApplyPicture(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[level], rows[key].value)+'', opts.rows[level].pictureFnc, div, opts.rows[level].type);//div.innerHTML = ToHTML(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[rows[key].level], rows[key].value));//ToHTML(rows[key].value);
										div.title = rows[key].value;
									}
									if (key == _level0Key) {
										_fSetHTMLAttribute(td, "trkey", rows[key].value);
									}
									else {
										_fSetHTMLAttribute(td, "trkey", key+_mSeparator+rows[key].value);
									}
									if ( div.innerHTML.length ==0 || (i==opts.rows.length-1 && i==maxRowLevel-1)) {
										div.style.cursor = 'default';
									}
									else if( k == 0 && !bigTotal && i==opts.rows.length-1 && i<maxRowLevel-1) {
										div.classList.add("toggle", "closelevel", _cssmode);
										div.classList.remove("openlevel");
										div.style.cursor = 'pointer';
										div.onclick = drillDownRow;
									}
									else if( k == 0 && !bigTotal ) {
										div.classList.add("toggle", "openlevel", _cssmode);
										div.classList.remove("closelevel");
										div.style.cursor = 'pointer';
										div.onclick = drillDownRow;
									}
									else {
										div.style.cursor = 'default';
									}
									div.onmouseover = onmouseRowOver;
									div.onmouseleave = onmouseRowLeave;
								}
								else if ( i == mrows ) {
									if(!opts.hideMeasures) div.innerHTML = ToHTML(measure.desc);
									div.onmouseover = onmouseRowOver;
									div.onmouseleave = onmouseRowLeave;
									div.style.cursor = 'default';
									if (key == _level0Key) {
										_fSetHTMLAttribute(td, "trkey", rows[key].value);
									}
									else {
										_fSetHTMLAttribute(td, "trkey", key+_mSeparator+rows[key].value);
									}
									_fSetHTMLAttribute(td, "tdmeasure", _fPad(k)+measure.alias);
								}
								else if (retRows[retRows.length-1]) {
									ltr = retRows[retRows.length-1];
									ltd = ltr.cells[i];
									_fSetHTMLAttribute(td, "trkey", _fGetHTMLAttribute(ltd, "trkey"));								
								}
								if( _this._initOpts.canFilter ) {
									td.onmouseover = function(e) {
										if( _this.PSCtrl && _this.PSCtrl.HoverFilterObjByExample) {
											var rkey = this.getAttribute("trkey");
											if( rkey != null ) {
												var sp = rkey.split(_mSeparator);
												_this.PSCtrl.HoverFilterObjByExample(e, this.firstChild, _this.opts.rows[sp.length-1].alias, "row:"+rkey)
											}
										}
									}
									td.onmouseleave = function(e) {
										var rkey = this.getAttribute("trkey");
										if( rkey != null ) {
											if( _this.PSCtrl && _this.PSCtrl.OutFilterObjByExample) {
												_this.PSCtrl.OutFilterObjByExample(e, this, "trkey", rkey)
											}
										}
									}
								}
								td.appendChild(div);
								if (bigTotal) {
									td.classList.add("td-view-row", "td-row-bigtotal", "measure"+k, _cssmode);
								}
								else {
									td.classList.add("td-view-row", "measure"+k, _cssmode);
								}
								tr.appendChild(td);
							}
							for ( j=0; j<columnsTds.length; j++) {
								td = document.createElement('td');
								div = document.createElement('div');
								div.classList.add("columndiv", "columndata", "measure"+k, _cssmode, opts.measures[k].alias);
								div.style.cursor = 'default';
								tckey = _fGetHTMLAttribute(columnsTds[j], "tckey");
								_fSetHTMLAttribute(td, "tckey", tckey);
								tdmeasure = _fPad(k)+measure.alias;
								_fSetHTMLAttribute(td, "tdmeasure", tdmeasure);
								td.appendChild(div);
								_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-view-data-measure" + " measure"+k);//td.classList.add("td-view-data-measure");
								if(bigTotal) {
									_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-row-bigtotal" + " measure"+k);
								}
								trdata.appendChild(td);
							}
							retRows.push(tr);
							retData.push(trdata);
						}
						if (key == _level0Key) {
							makeTRRowsDataWithMeasures(index, level+1,refObj, opts, columnsTds, rows, rows[key].value, retRows, retData, maxRowLevel, maxSubRowLevel, measuresMap, false); // eslint-disable-line max-len
						}
					}
					else { //set columns
						_this.ztVPivotData.updateWTotal(key, rows[key]);
						for (k=0; k<opts.measures.length; k++){
							lastDataTr = retData[retData.length-(1+k)];
							if ( lastDataTr ) {
								for ( j=0; j<lastDataTr.cells.length; j++) {
									td = lastDataTr.cells[j];
									columnkey = _fGetHTMLAttribute(td, "tckey");
									tdmeasure = _fGetHTMLAttribute(td, "tdmeasure");
									if ( rows[key][columnkey] ) {
										var vy;
										if(measuresMap[tdmeasure]) {
											vy = _fApplyPicture(rows[key][columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].pictureFnc, td.children[0]);
										}
										else {
											vy = _fApplyPicture(rows[key][columnkey][tdmeasure.substr(_npad)], null, td.children[0]); //assegnazione valori
										}
										if(measuresMap[tdmeasure]) {
											_fApplyCss(rows[key][columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].cssFnc, td, key, columnkey, tdmeasure.substr(_npad));//td.classList.add(measuresMap[tdmeasure].cssFnc(rows[key][columnkey][tdmeasure.substr(_npad)]));
										}
										_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure] = rows[key][columnkey][tdmeasure.substr(_npad)];
										_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure + '_pic'] = vy;
										_dataViewer.valueMapKeys.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
										if(_dataViewer.ztController._initOpts.onclickFnc) {
											div = td.children[0];
											div.style.cursor = 'pointer';
											div.onclick = oncellClick;
										}
										if( td.children[0])
											div = td.children[0];
										else
											div = td;
										div.onmouseover = onmouseOver;
										div.onmouseleave = onmouseLeave;
									}
									_dataViewer.valueMapKeysAndNull.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
								}
							}
						}
					}
				}
			}

			function makeTRRowsData(index, level, refObj, opts, columnsTds, rows, key, retRows, retData, maxRowLevel, maxSubRowLevel, measuresMap, bigTotal) {
				var mrows = Math.min(maxSubRowLevel, opts.rows.length);
				if ( rows[key] ) {
					var tr, td, div, j, lastDataTr, columnkey, tdmeasure, ao, i, trdata, ltr, ltd, tckey, mi;
					if (  Array.isArray(rows[key]) ) {
						if( level > 0 && opts.rowsSubLevel) {
							if(opts.rowsSubLevel[level-1] && opts.rowsSubLevel[level-1].length>0 && opts.rowsSubLevel[level-1].indexOf(key)>=0) {
							}
							else {
								tr = retRows[retRows.length-1];
								if ( tr ) {
									td = tr.cells[level-1];
									div = td.firstChild;
									div.classList.add("toggle", "closelevel", _cssmode);
									div.classList.remove("openlevel");
									for(j=level; j<opts.rows.length - tr.cells.length; j++) {
										td = document.createElement('td');
										div = document.createElement('div');
										td.appendChild(div);
										td.classList.add("td-view-row td-row-subempty", _cssmode);
										tr.appendChild(td);
									}
								}
								lastDataTr = retData[retData.length-1];
								if ( lastDataTr ) {
									for ( j=0; j<lastDataTr.cells.length; j++) {
										td = lastDataTr.cells[j];
										columnkey = _fGetHTMLAttribute(td, "tckey");
										tdmeasure = _fGetHTMLAttribute(td, "tdmeasure");
										ao = _dataViewer.getAggregateValue(rows, key, index);
										if ( ao && ao[columnkey]) {
											var vz;
											if(measuresMap[tdmeasure]) {
												vz = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].pictureFnc, td.children[0]);
											}
											else {
												vz = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], null, td.children[0]); //assegnazione valori
											}
											if(measuresMap[tdmeasure]) {
												_fApplyCss(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].cssFnc, td, key, columnkey, tdmeasure.substr(_npad));//td.classList.add(measuresMap[tdmeasure].cssFnc(ao[columnkey][tdmeasure.substr(_npad)]));
											}
											_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure] = ao[columnkey][tdmeasure.substr(_npad)];
											_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure + '_pic'] = vz;
											_dataViewer.valueMapKeys.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
											if(_dataViewer.ztController._initOpts.onclickFnc) {
												div = td.children[0];
												div.style.cursor = 'pointer';
												div.onclick = oncellClick;
											}
											if( td.children[0])
												div = td.children[0];
											else
												div = td;
											div.onmouseover = onmouseOver;
											div.onmouseleave = onmouseLeave;
										}
										_dataViewer.valueMapKeysAndNull.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
									}
								}
								return;
							}
						}
						for ( i=0; i<rows[key].length; i++) {
							var o = rows[key][i];
							if ( o.value == _znull ) {
								continue;
							}
							if ( o.level < opts.rows.length ) {
								tr = document.createElement('tr');
								_fSetHTMLAttribute(tr, "dlevel", o.level);	
								_fSetHTMLAttribute(tr, "dindex", index);
								trdata = document.createElement('tr');
								_fSetHTMLAttribute(trdata, "dlevel", o.level);
								_fSetHTMLAttribute(trdata, "dindex", index);
								//add row
								for(j=0; j<mrows; j++) {
									td = document.createElement('td');
									div = document.createElement('div');
									if ( j == o.level ) {
										_fApplyPicture(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[level], o.value)+'', opts.rows[level].pictureFnc, div, opts.rows[level].type);//div.innerHTML = ToHTML(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[o.level], o.value));//ToHTML(o.value);
										if (key == _level0Key) {
											_fSetHTMLAttribute(td, "trkey", o.value);
										}
										else {
											_fSetHTMLAttribute(td, "trkey", key+_mSeparator+o.value);
											
										}
										if(!bigTotal) {
											div.title = o.value;
										}
										if ( div.innerHTML.length ==0 || (j==opts.rows.length-1 && j==maxRowLevel-1)) {
											div.style.cursor = 'default';
										}
										else  if(!bigTotal && j==opts.rows.length-1 && j<maxRowLevel-1) {
											div.classList.add("toggle", "closelevel", _cssmode);
											div.classList.remove("openlevel");
											div.style.cursor = 'pointer';
											div.onclick = drillDownRow;
										}
										else if(!bigTotal){
											div.classList.add("toggle", "openlevel", _cssmode);
											div.classList.remove("closelevel");
											div.style.cursor = 'pointer';
											div.onclick = drillDownRow;
										}
										div.onmouseover = onmouseRowOver;
										div.onmouseleave = onmouseRowLeave;
										if( !bigTotal && _this._initOpts.canFilter ) {
											td.onmouseover = function(e) {
												if( _this.PSCtrl && _this.PSCtrl.HoverFilterObjByExample) {
													var rkey = this.getAttribute("trkey");
													if( rkey != null ) {
														var sp = rkey.split(_mSeparator);
														_this.PSCtrl.HoverFilterObjByExample(e, this.firstChild, _this.opts.rows[sp.length-1].alias, "row:"+rkey)
													}
												}
											}
											td.onmouseleave = function(e) {
												var rkey = this.getAttribute("trkey");
												if( rkey != null ) {
													if( _this.PSCtrl && _this.PSCtrl.OutFilterObjByExample) {
														_this.PSCtrl.OutFilterObjByExample(e, this, "trkey", rkey)
													}
												}
											}
										}
									}
									else if (retRows[retRows.length-1]) {
										ltr = retRows[retRows.length-1];
										ltd = ltr.cells[j];
										_fSetHTMLAttribute(td, "trkey", _fGetHTMLAttribute(ltd, "trkey"));
									}
									td.appendChild(div);
									if (bigTotal) {
										td.classList.add("td-view-row td-row-bigtotal", _cssmode);
									}
									else {
										td.classList.add("td-view-row", _cssmode);
									}
									tr.appendChild(td);
								}
								for ( j=0; j<columnsTds.length; j++) {
									td = document.createElement('td');
									div = document.createElement('div');
									mi = j%(opts.measures.length);
									div.classList.add("columndiv", "columndata", "measure"+mi, _cssmode, opts.measures[mi].alias);
									tckey = _fGetHTMLAttribute(columnsTds[j], "tckey");
									_fSetHTMLAttribute(td, "tckey", tckey);
									tdmeasure = _fGetHTMLAttribute(columnsTds[j], "tdmeasure");
									_fSetHTMLAttribute(td, "tdmeasure", tdmeasure);
									td.appendChild(div);
									_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class")  + " td-view-data-measure");//td.classList.add("td-view-data-measure");
									if(bigTotal) {
										_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-row-bigtotal");
									}
									td.classList.remove("td-measuretitle", _cssmode);
									trdata.appendChild(td);
								}
								if (retRows[retRows.length-1]) {
									var dlevel = _fGetHTMLAttribute(retRows[retRows.length-1], "dlevel");
									if(parseInt(dlevel) == (o.level-1)) {
										tr = retRows[retRows.length-1];
										_fSetHTMLAttribute(tr, "dlevel", o.level);
										_fSetHTMLAttribute(tr, "dindex", index);
										div = tr.cells[o.level].firstChild;
										_fApplyPicture(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[level], o.value)+'', opts.rows[level].pictureFnc, div, opts.rows[level].type);//div.innerHTML = ToHTML(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[o.level], o.value));//ToHTML(o.value);
										div.title = o.value;
										if ((o.level==opts.rows.length-1 && o.level==maxRowLevel-1)) {
											div.style.cursor = 'default';
										}
										else  if( !bigTotal && o.level==opts.rows.length-1 && o.level<maxRowLevel-1) {
											div.classList.add("toggle", "closelevel", _cssmode);
											div.classList.remove("openlevel");
											div.style.cursor = 'pointer';
											div.onclick = drillDownRow;
										}
										else if(!bigTotal){
											div.classList.add("toggle", "openlevel", _cssmode);
											div.classList.remove("closelevel");
											div.style.cursor = 'pointer';
											div.onclick = drillDownRow;
										}
										div.onmouseover = onmouseRowOver;
										div.onmouseleave = onmouseRowLeave;
										if ( o.level == 0 ) {
											_fSetHTMLAttribute(tr.cells[o.level], "trkey", o.value);
										}
										else { //o.level > 0
											var prKey = _fGetHTMLAttribute(tr.cells[o.level-1], "trkey");
											_fSetHTMLAttribute(tr.cells[o.level], "trkey", prKey + _mSeparator + o.value)
										}
										trdata = retData[retData.length-1];
										_fSetHTMLAttribute(trdata, "dlevel", o.level);
										_fSetHTMLAttribute(trdata, "dindex", index);
									}
									else {
										retRows.push(tr);
										retData.push(trdata);
									}
								}
								else {
									retRows.push(tr);
									retData.push(trdata);
								}
							}
							if ( o.value != _znull ) {
								makeTRRowsData(index, level+1,refObj, opts, columnsTds, rows, key+_mSeparator+o.value, retRows, retData, maxRowLevel, maxSubRowLevel, measuresMap, false); // eslint-disable-line max-len
							}
						}
						//subtotalonrow
						if ( opts.subTotalOnRow ) {
							tr = document.createElement('tr');
							_fSetHTMLAttribute(tr, "dlevel", level);
							_fSetHTMLAttribute(tr, "dindex", index);
							trdata = document.createElement('tr');
							_fSetHTMLAttribute(trdata, "dlevel", level);
							_fSetHTMLAttribute(trdata, "dindex", index);
							for(i=0; i<mrows; i++) {
								td = document.createElement('td');
								div = document.createElement('div');
								if ( (opts.subTotalOnRowLevel && (i == level-1)) ||  (!opts.subTotalOnRowLevel && (i == level)) ) {
									var lsplit = key.split(_mSeparator);
									var v = _dataViewer.ztController._getFieldAliasKeyValue(opts.rows[lsplit.length-1], lsplit[lsplit.length-1])
									v += " [" + _fGetCounter(rows[key]) + "]";
									if( !Empty(opts.subTotalTitle) ) v+= "["+ opts.subTotalTitle + "]";
									div.innerHTML = ToHTML(v);
								}
								_fSetHTMLAttribute(td, "trkey", key);
								div.style.cursor = 'default';
								td.appendChild(div);
								td.classList.add("td-view-row", "td-row-subtotal");
								if ( (opts.subTotalOnRowLevel && (i >= level-1)) ||  (!opts.subTotalOnRowLevel && (i >= level)) ) {
									td.classList.add("td-row-subtotal-mark");
								}
								td.classList.add(_cssmode);
								tr.appendChild(td);
								div.onmouseover = onmouseRowOver;
								div.onmouseleave = onmouseRowLeave;
							}
							for ( j=0; j<columnsTds.length; j++) {
								td = document.createElement('td');
								div = document.createElement('div');
								mi = j%(opts.measures.length);
								div.classList.add("columndiv", "columndata", "measure"+mi, _cssmode, opts.measures[mi].alias);
								div.style.cursor = 'default';
								tckey = _fGetHTMLAttribute(columnsTds[j], "tckey");
								_fSetHTMLAttribute(td, "tckey", tckey);
								tdmeasure = _fGetHTMLAttribute(columnsTds[j], "tdmeasure");
								_fSetHTMLAttribute(td, "tdmeasure", tdmeasure);
								td.appendChild(div);
								_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-view-data-measure td-row-subtotal td-row-subtotal-mark");//td.classList.add("td-view-data-measure");
								if(bigTotal) {
									_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-row-bigtotal");
								}
								trdata.appendChild(td);
								ao = _dataViewer.getAggregateValue(rows, key, index);
								columnkey = tckey;
								if ( ao && ao[columnkey]) {
									var vk;
									if(measuresMap[tdmeasure]) {
										vk = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].pictureFnc, td.children[0]);
									}
									else {
										vk = _fApplyPicture(ao[columnkey][tdmeasure.substr(_npad)], null, td.children[0]); //assegnazione valori
									}
									if(measuresMap[tdmeasure]) {
										_fApplyCss(ao[columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].cssFnc, td, key, columnkey, tdmeasure.substr(_npad));//td.classList.add(measuresMap[tdmeasure].cssFnc(ao[columnkey][tdmeasure.substr(_npad)]));
									}
									_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure] = ao[columnkey][tdmeasure.substr(_npad)];
									_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure + '_pic'] = vk;
									_dataViewer.valueMapKeys.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
									if(_dataViewer.ztController._initOpts.onclickFnc) {
										div = td.children[0];
										div.style.cursor = 'pointer';
										div.onclick = oncellClick; //subtotal column
									}
									if( td.children[0])
										div = td.children[0];
									else
										div = td;
									div.onmouseover = onmouseOver;
									div.onmouseleave = onmouseLeave;
								}
								_dataViewer.valueMapKeysAndNull.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
							}
							retRows.push(tr);
							retData.push(trdata);
						}
					}
					else if(rows[key].level != undefined && rows[key].value != _znull){ //new row
						tr = document.createElement('tr');
						_fSetHTMLAttribute(tr, "dlevel", rows[key].level);
						_fSetHTMLAttribute(tr, "dindex", index);
						trdata = document.createElement('tr');
						_fSetHTMLAttribute(trdata, "dlevel", rows[key].level);
						_fSetHTMLAttribute(trdata, "dindex", index);
						//add row
						for(i=0; i<mrows; i++) {
							td = document.createElement('td');
							div = document.createElement('div');
							if ( i == rows[key].level ) {
								_fApplyPicture(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[level], rows[key].value)+'', opts.rows[level].pictureFnc, div, opts.rows[level].type);//div.innerHTML = ToHTML(_dataViewer.ztController._getFieldAliasKeyValue(opts.rows[rows[key].level], rows[key].value));//ToHTML(rows[key].value);
								div.title = rows[key].value;
								if (key == _level0Key) {
									_fSetHTMLAttribute(td, "trkey", rows[key].value);
								}
								else {
									_fSetHTMLAttribute(td, "trkey", key+_mSeparator+rows[key].value);
								}
								if ((i==opts.rows.length-1 && i==maxRowLevel-1)) {
									div.style.cursor = 'default';
								}
								else if( !bigTotal && i==opts.rows.length-1 && i<maxRowLevel-1) {
									div.classList.add("toggle", "closelevel", _cssmode);
									div.classList.remove("openlevel");
									div.style.cursor = 'pointer';
									div.onclick = drillDownRow;
								}
								else if(!bigTotal) {
									div.classList.add("toggle", "openlevel", _cssmode);
									div.classList.remove("closelevel");
									div.style.cursor = 'pointer';
									div.onclick = drillDownRow;
								}
								div.onmouseover = onmouseRowOver;
								div.onmouseleave = onmouseRowLeave;
							}
							else if (retRows[retRows.length-1]) {
								ltr = retRows[retRows.length-1];
								ltd = ltr.cells[i];
								_fSetHTMLAttribute(td, "trkey", _fGetHTMLAttribute(ltd, "trkey"));
							}
							if( !bigTotal && _this._initOpts.canFilter ) {
								td.onmouseover = function(e) {
										if( _this.PSCtrl && _this.PSCtrl.HoverFilterObjByExample) {
											var rkey = this.getAttribute("trkey");
											if( rkey != null ) {
												var sp = rkey.split(_mSeparator);
												_this.PSCtrl.HoverFilterObjByExample(e, this.firstChild, _this.opts.rows[sp.length-1].alias, "row:"+rkey)
											}
										}
								}
								td.onmouseleave = function(e) {
									var rkey = this.getAttribute("trkey");
									if( rkey != null ) {
										if( _this.PSCtrl && _this.PSCtrl.OutFilterObjByExample) {
											_this.PSCtrl.OutFilterObjByExample(e, this, "trkey", rkey)
										}
									}
								}
							}
							td.appendChild(div);
							if (bigTotal) {
								td.classList.add("td-view-row", "td-row-bigtotal", _cssmode);
							}
							else {
								td.classList.add("td-view-row", _cssmode);
							}
							tr.appendChild(td);
						}
						for ( j=0; j<columnsTds.length; j++) {
							td = document.createElement('td');
							div = document.createElement('div');
							mi = j%(opts.measures.length);
							div.classList.add("columndiv", "columndata", "measure"+mi, _cssmode, opts.measures[mi].alias);
							div.style.cursor = 'default';
							tckey = _fGetHTMLAttribute(columnsTds[j], "tckey");
							_fSetHTMLAttribute(td, "tckey", tckey);
							tdmeasure = _fGetHTMLAttribute(columnsTds[j], "tdmeasure");
							_fSetHTMLAttribute(td, "tdmeasure", tdmeasure);
							td.appendChild(div);
							_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-view-data-measure");//td.classList.add("td-view-data-measure");
							if(bigTotal) {
								_fSetHTMLAttribute(td, "class", _fGetHTMLAttribute(columnsTds[j], "class") + " td-row-bigtotal");
							}
							trdata.appendChild(td);
						}
						retRows.push(tr);
						retData.push(trdata);
						
						if (key == _level0Key) {
							makeTRRowsData(index, level+1,refObj, opts, columnsTds, rows, rows[key].value, retRows, retData, maxRowLevel, maxSubRowLevel, measuresMap, false);
						}
					}
					else { //set columns
						_this.ztVPivotData.updateWTotal(key, rows[key]);
						lastDataTr = retData[retData.length-1];
						if ( lastDataTr ) {
							for ( j=0; j<lastDataTr.cells.length; j++) {
								td = lastDataTr.cells[j];
								columnkey = _fGetHTMLAttribute(td, "tckey");
								tdmeasure = _fGetHTMLAttribute(td, "tdmeasure");
								if ( rows[key][columnkey] ) {
									var vo;
									if(measuresMap[tdmeasure]) {
										vo = _fApplyPicture(rows[key][columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].pictureFnc, td.children[0]);
									}
									else {
										vo = _fApplyPicture(rows[key][columnkey][tdmeasure.substr(_npad)], null, td.children[0]); //assegnazione valori
									}
									if(measuresMap[tdmeasure]) {
										_fApplyCss(rows[key][columnkey][tdmeasure.substr(_npad)], measuresMap[tdmeasure].cssFnc, td, key, columnkey, tdmeasure.substr(_npad));//td.classList.add(measuresMap[tdmeasure].cssFnc(rows[key][columnkey][tdmeasure.substr(_npad)]));
									}
									_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure] = rows[key][columnkey][tdmeasure.substr(_npad)];
									_dataViewer.valueMap[index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure + '_pic'] = vo;
									_dataViewer.valueMapKeys.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
									if(_dataViewer.ztController._initOpts.onclickFnc) {
										div = td.children[0];
										div.style.cursor = 'pointer';
										div.onclick = oncellClick; //lastdata bigtotal?
									}
									if( td.children[0])
										div = td.children[0];
									else
										div = td;
									div.onmouseover = onmouseOver;
									div.onmouseleave = onmouseLeave;
								}
								_dataViewer.valueMapKeysAndNull.push(index+_kSeparator+key+_kSeparator+columnkey+_kSeparator+tdmeasure);
							}
						}
					}
				}
			}
						
			this.tdAreaRows.innerHTML = "";
			this.tdAreaData.innerHTML = "";
			var table = document.createElement('table');
			table.classList.add("t-rows", _cssmode);
			var tableData = document.createElement('table');
			tableData.classList.add("t-data", _cssmode);
			var measuresMap = [];
			var k;

			for(k=0; k<opts.measures.length; k++) {
				measuresMap[_fPad(k) + opts.measures[k].alias] = opts.measures[k];
			}
			
			//--
			//-- modifiche dopo check di performance ia
			//-- disegnare subito per rendering
			//-- ma due volte ciclo, per altezza delle righe
			
			var retData = [];
			var retRows;
			var mheight, lcol, mwidthz = 0;
			var bigRowTotal, mcount = 0;

			var div = document.createElement('div');
			div.classList.add("tdiv-rows", _cssmode);
			div.appendChild(table);
			this.tdAreaRows.appendChild(div);
			
			var divdata = document.createElement('div');
			divdata.classList.add("tdiv-data-columns", "tdiv-data", _cssmode);
			divdata.appendChild(tableData);
			this.tdAreaData.appendChild(divdata);
			divdata.onscroll = function() {
				var columndiv = _this.htmlContainer.getElementsByClassName("tdiv-columns");
				if (columndiv.length > 0) {
					columndiv[0].scrollLeft = this.scrollLeft;
				}
				var rowdiv = _this.htmlContainer.getElementsByClassName("tdiv-rows");
				if (rowdiv.length > 0) {
					rowdiv[0].scrollTop = this.scrollTop;
				}
			}
			this.tdAreaDescription.innerHTML = "";

			for (i = 0; i < objRets.length; i++) {
				retRows = [];
				retData[i] = []
				var objRet = objRets[i];
				if (opts.measuresOnColumn) {
					makeTRRowsData(i, 0, this, opts, columnsTdCells, objRet.rows, _level0Key, retRows, retData[i], maxRowLevel, maxSubRowLevel, measuresMap, false);
				}
				else {
					makeTRRowsDataWithMeasures(i, 0, this, opts, columnsTdCells, objRet.rows, _level0Key, retRows, retData[i], maxRowLevel, maxSubRowLevel, measuresMap, false);
				}
				if (opts.bigTotalOnRow) {
					bigRowTotal = _fMergeDeepSum(bigRowTotal, _dataViewer.getAggregateValue(objRet.rows, _level0Key, i));
				}
				if (retRows.length == 0)
					continue;
				
				objRet.retRows = retRows;
				mcount += retRows.length;
			}
			
			let l = 0, c = 0;
			var _interval;
			_interval = setInterval(function run() {
				objRet = objRets[l];
				if( !objRet) {
					clearInterval(_interval)
					endDraw();
					_this.PSObserver.observe(_this.htmlContainer);
					return;
				}
				retRows = objRet.retRows;
				var j;
				for (j = 0; j < retRows.length; j++) {
					table.appendChild(retRows[j]);
					tableData.appendChild(retData[l][j]);
					var height = Math.max(retRows[j].offsetHeight, retData[l][j].offsetHeight)+2;
					retRows[j].style.height =  height + 'px' //altezze righe
					retData[l][j].style.height =  height + 'px' //altezze righe
				}
				l++
				c+= retRows.length;
				if( _this.PSCtrl && _this.PSCtrl.updateLoadingDiv ) _this.PSCtrl.updateLoadingDiv(c, mcount);
			}, 10);
			

			function endDraw() {
				var ctable = _this.mViewer.tdAreaColumns.getElementsByClassName("t-columns");
				var ctablet = _this.mViewer.tdAreaColumns.getElementsByClassName("t-columns-title");
				var i, j, ttable, tr, cH = 0, td;
	
				if (ctablet && ctablet.length > 0) {
					ctablet = ctablet[0];
					ttable = document.createElement('table');
					ttable.classList.add("t-rows-header-title", _cssmode);
					for (i=0; i<ctablet.rows.length; i++) {
						tr = document.createElement('tr');
						ttable.appendChild(tr);
						cH = ctablet.rows[i].offsetHeight;
						
						if( i==0 && _this.mViewer.ztController.hasMenu) {
							td = document.createElement('td');
							td.classList.add("td-menu-ctrl", _cssmode);
							div = document.createElement('div');
							div.classList.add("refresh_menu_ctrl", "SPPortalZoomBaseMenu", "global_handler", "closed", _cssmode);
							div.style.cursor = 'pointer';
							div.onclick = function() {
								_this.manageMenu(this);
							}
							td.appendChild(div);
							tr.appendChild(td);
						}
						else if( i==0 && !_this.mViewer.ztController.hasMenu) {
							tr.style.height = 0 + "px";
						}
						else {
							tr.style.height = cH + "px";
						}	
					}
					_this.mViewer.tdAreaDescription.appendChild(ttable);
				}
				if (ctable && ctable.length > 0) {
					ctable = ctable[0];
					ttable = document.createElement('table');
					ttable.classList.add("t-rows-header", _cssmode);
					for (i=0; i<ctable.rows.length; i++) {
						tr = document.createElement('tr');
						tr.classList.add("tr-row-header", _cssmode);
						ttable.appendChild(tr);
						tr.style.height = cH + "px";
						if ( i!= ctable.rows.length-1 ) {
							for (j=0; j<opts.rows.length; j++) {
								td = document.createElement('td');
								td.classList.add("td-row-header", _cssmode);
								div = document.createElement('div');
								div.classList.add("columnheader", _cssmode);
								div.style.cursor = 'default';
								td.appendChild(div);
								tr.appendChild(td);
							}
						}					
					}
					tr = ttable.rows[ttable.rows.length-1];
					for (i=0; i<opts.rows.length; i++) {
						td = document.createElement('td');
						td.classList.add("td-row-header", _cssmode);
						div = document.createElement('div');
						div.classList.add("columnheader", _cssmode);
						div.style.cursor = 'default';
						div.style.cssFloat = 'left';
						if( opts.sortRow == true ) {
							if(opts.rows[i].orderby == 'desc') {
							  div.classList.add("row-asc");
							}
							else if(opts.rows[i].orderby == 'asc') {
							  div.classList.add("row-desc");
							}
							else {
							  div.classList.add("row-sort");
							}
							div.onclick = onSortRow;
							div.style.cursor = 'pointer';
						}
						div.innerHTML = ToHTML(opts.rows[i].desc);
						td.appendChild(div);
						div = document.createElement('div');
						div.classList.add("columnheader", "rem_filter", _cssmode);
						_fSetHTMLAttribute(div, "alias", opts.rows[i].alias)
						if( _this.PSCtrl && _this.PSCtrl.pvGetTranslate ) div.title = _this.PSCtrl.pvGetTranslate("Remove_Filters");
						div.onclick = function() {
							_this._removeFilterData(_fGetHTMLAttribute(this, 'alias'));
						}
						div.style.cursor = 'pointer';
						div.style.display = 'none';
						td.appendChild(div);
						tr.appendChild(td);
					}
	
					if (!opts.measuresOnColumn) {
						td = document.createElement('td');
						td.classList.add("td-row-header", _cssmode);
						div = document.createElement('div');
						div.classList.add("columnheader", _cssmode);
						if(!opts.hideMeasures) div.innerHTML = ToHTML(opts.measuresTitle);
						div.style.cursor = 'default';
						td.appendChild(div);
						tr.appendChild(td);
					}
					_this.mViewer.tdAreaDescription.appendChild(ttable);
				}
				
				var maxw = [];
						
				if (bigRowTotal) {
					var lbigRowTotal = {};
					lbigRowTotal[_level0Key] = {};
					lbigRowTotal[_level0Key].level = 0;
					lbigRowTotal[_level0Key].value = _level0Key+_btotal;
					lbigRowTotal[_level0Key+_btotal] = bigRowTotal;
					retRows = [];
					retData[i] = [];
					if (opts.measuresOnColumn) {
						makeTRRowsData(i, 0, _this.mViewer, opts, columnsTdCells, lbigRowTotal, _level0Key, retRows, retData[i], maxRowLevel, maxSubRowLevel, measuresMap, true);
					}
					else {
						makeTRRowsDataWithMeasures(i, 0, _this.mViewer, opts, columnsTdCells, lbigRowTotal, _level0Key, retRows, retData[i], 
							maxRowLevel, maxSubRowLevel, measuresMap, true);
					}
					mwidthz = 0;
					for(j=0; j<retRows.length; j++) {
						table.appendChild(retRows[j]);
						if ( j==0 ) {
							retRows[j].firstChild.firstChild.innerHTML = ToHTML(opts.bigTotalTitle);
						}
						else {
							retRows[j].firstChild.firstChild.innerHTML = "";
						}
						tableData.appendChild(retData[i][j]);
						mheight = Math.max(retRows[j].offsetHeight, retData[i][j].offsetHeight);
						retData[i][j].style.height = mheight + "px";
						retRows[j].style.height = mheight + "px";
						lcol = retData[i][j].cells[j];
						if (lcol)
							mwidthz = Math.max(mwidthz,  _fGetOffset(lcol).w);
					}
				}
				_dataViewer.ztController._workVars.maxColumns = maxw;
				_this._updateFiltersDiv();
				_this._drawing = false;
			}
		}

		this.draw = function(initUi, fnc) {
			_this._drawing = true;
			function execdraw(_this, initUi) {
				_this._asyncdraw(initUi)
				if( fnc ) fnc()
			}
			if( this.ztController.PSCtrl && this.ztController.PSCtrl.showLoadingDiv ) this.ztController.PSCtrl.showLoadingDiv();
			setTimeout(execdraw, 15, this, initUi, fnc)
		}

		this._asyncdraw = function(initUi) {
			function aggregateForData(level, node, opts, objRet, colPrevKey, rowPrevKey) {
				if (level > opts.rows.length+opts.columns.length) {
					return;
				}
				var datakey;
				if (level < opts.rows.length) {
					var r;
					if (level == 0) {
						objRet.rows[_level0Key] = {};
						r = {};
						r.value = node.key;
						r.total = node.total;
						r.level = level;
						objRet.rows[_level0Key] = r;
						rowPrevKey = node.key;
					}
					else {
						if (!objRet.rows[rowPrevKey]) {
							objRet.rows[rowPrevKey] = [];
						}
						var o = objRet.rows[rowPrevKey];
						r = {};
						r.value = node.key;
						r.total = node.total;
						r.level = level;
						o.push(r);
						rowPrevKey += _mSeparator + node.key;
					}
				}
				else if (level < opts.rows.length+opts.columns.length) {
					var zl = level-opts.rows.length;
					if ( zl == 0 ) {
						if(!objRet.columns[_level0Key]) {
							objRet.columns[_level0Key] = [];
						}
						if ( objRet.columns[_level0Key].indexOf(node.key) < 0 ) {
							objRet.columns[_level0Key].push(node.key);
						}
						colPrevKey = node.key;
						datakey = 0;
					}
					else {
						if (colPrevKey) {
							var colPrevKeyT = zl + _nSeparator + colPrevKey;
							if ( !objRet.columns[colPrevKeyT] ) {
								objRet.columns[colPrevKeyT] = [];
							}
							if ( objRet.columns[colPrevKeyT].indexOf(node.key) < 0 ) {
								objRet.columns[colPrevKeyT].push(node.key);
							}
							datakey = colPrevKey;
						}
						else { //strano
							colPrevKey = '';
						}
						colPrevKey += _mSeparator + node.key;
					}
				}
				if (datakey != undefined) {
					if (!objRet.rows[rowPrevKey]) {
						objRet.rows[rowPrevKey] = {};
					}
					if (objRet.rows[rowPrevKey] && colPrevKey) {
						objRet.rows[rowPrevKey][colPrevKey] = node.total;
						
					}
				}
				if (node.values) {
					var k, j, nv;
					if( (level == (opts.rows.length-1)) && node.values[0].key == _znull) {
						nv = node.values[0];
						if(nv.values) {
						for( k=0; k<nv.values.length; k++) {
							aggregateForData (level+1, nv.values[k], opts, objRet, colPrevKey, rowPrevKey);
						}
					}
					}
					else {
						for (j=0; j<node.values.length; j++) {
							aggregateForData (level+1, node.values[j], opts, objRet, colPrevKey, rowPrevKey);
						}
					}
				}
				else {
					aggregateForData (level+1, node, opts, objRet, colPrevKey, rowPrevKey);	
				}
				if(!objRet.rows[rowPrevKey]) {
					objRet.rows[rowPrevKey] = {};
				}
				objRet.rows[rowPrevKey][_level0Key] = node.total;
			}
			this.init(initUi);
			var opts = this.ztController.drawOpts;
			var data = this.ztController.nestedData;
			/*console.log(1, data, opts)

			//test sort totals.....
			var ix, jx, iz, row, meas = [], dsort, dz;
			for( ix=0; ix<opts.measures.length; ix++ ) {
				meas.push(opts.measures[ix].alias.toLowerCase())
			}
			for( ix=0; ix<opts.rows.length; ix++ ) {
				row = opts.rows[ix];
				if( row.orderby && row.orderfield ) {
					if( meas.indexOf(row.orderfield.toLowerCase()) >= 0 ) {
						if( ix == 0) {
							dsort = data;
							dsort.sort ( function(a, b)  {
								if( row.orderby == 'asc')
									return a.total[row.orderfield.toLowerCase()] - b.total[row.orderfield.toLowerCase()];
								else if( row.orderby == 'desc')
									return b.total[row.orderfield.toLowerCase()] - a.total[row.orderfield.toLowerCase()];
								else
									return 0;
							} )
						}
						else {
							if( ix == 2 ) debugger
							for( jx=0; jx<data.length; jx++ ) {
								dsort = null;
								iz = 1;
								dz = data[jx];
								while( (dsort == null) && iz<=ix ) {
									if( !dz.values) iz = ix+1;
									else if ( iz == ix ) {
										dsort = dz.values;
									}
									else {
										dz = dz.values;
									}
									iz++;
								}
								
								if( dsort ) {
									dsort.sort ( function(a, b)  {
										if( row.orderby == 'asc')
											return a.total[row.orderfield.toLowerCase()] - b.total[row.orderfield.toLowerCase()];
										else if( row.orderby == 'desc')
											return b.total[row.orderfield.toLowerCase()] - a.total[row.orderfield.toLowerCase()];
										else
											return 0;
									} )
								}
								console.log(ix, dsort)
							}
						}
					}
				}
			}
			/*data.sort ( function( a, b) {
				console.log(a.total.prezzo, b.total.prezzo)
				return a.total.prezzo - b.total.prezzo;
			})

			console.log(2, data)*/

			/*if( !opts.filters || opts.filters.length == 0) {
				if(this.htmlFLTable) {
					this.htmlFLTable.classList.remove('notempty');
					this.htmlFLTable.classList.add('empty');
				}
			}
			else {
				if(this.htmlFLTable) {
					this.htmlFLTable.classList.remove('empty');
					this.htmlFLTable.classList.add('notempty');
				}
			}*/

			this.htmlCTable.innerHTML = '';
			this.htmlCTable.className = '';
			this.htmlZETable.innerHTML = '';
			//this.htmlZTable.style.display = 'table';
			var maxRowLevel = this.ztController.opts.rows.length;
			var maxColumnLevel = this.ztController.opts.columns.length;
			var maxSubRowLevel = 1;
			var i, j;
			if ( opts.rowsSubLevel ) {
				for (i=1; i<=opts.rowsSubLevel.length-1; i++) {
					if (opts.rowsSubLevel[i] && opts.rowsSubLevel[i].length == 0) {
						i = opts.rowsSubLevel.length;
					}
					else if ( opts.rowsSubLevel[i] && opts.rowsSubLevel[i].length > 0 ) {
						var str = opts.rowsSubLevel[i].toString();
						var out = false;
						for (j=0; !out && j<opts.rowsSubLevel[i-1].length; j++) {
							var pk = opts.rowsSubLevel[i-1][j];
							if (str.indexOf(pk+_mSeparator)>=0){
								maxSubRowLevel++;
								out = true;
							}
						}
						if (!out) {
							i = opts.rowsSubLevel.length;
						}
					}
				}
				maxSubRowLevel++;
			}
			else {
				maxSubRowLevel = opts.rows.length;
			}

      		var objRets, columns, keys;
			if (!this.ztController.aggregateObjRets || !this.ztController.drawingColumns) {
				objRets = [];
				columns = [];	
				for (i=0; i<data.length; i++) {
					var node = data[i];
					var objRet = {};
					objRet.rows = [];
					objRet.columns = [];
					aggregateForData(0, node, opts, objRet);
					objRets.push(objRet);
					keys = Object.keys(objRet.columns);
					for (j=0; j<keys.length; j++) {
						if(!columns[keys[j]]) {
							columns[keys[j]] = [];
						}
						columns[keys[j]] = columns[keys[j]].concat(objRet.columns[keys[j]]);
					}
				}
				this.ztController.drawingColumns = columns;
				this.ztController.drawingColumnsSort = {};
				this.ztController.aggregateObjRets = objRets;
				//console.log(data, objRets)
			}
			columns = this.ztController.drawingColumns;
			var columnsSort = this.ztController.drawingColumnsSort;
			objRets = this.ztController.aggregateObjRets;
			keys = Object.keys(columns);

			function addRecursiveValues(level, key) {
				if( !columns[key]) columns[key]=[];
				for( var i=0; i<opts.columns[level].lvalues.length; i++ ) {
					var v = opts.columns[level].lvalues[i];
					if( columns[key].indexOf(v) < 0 ) {
						columns[key].push(v);
						var klevel;
						if( level == 0) {
							klevel = (level+1) + _nSeparator + v;
						}
						else {
							var _key = key.substring(key.indexOf(_nSeparator)+_nSeparator.length)
							klevel = (level+1) + _nSeparator + _key + _mSeparator + v;
						}
						if( opts.columns[level+1] && opts.columns[level+1].lvalues)
							addRecursiveValues(level+1, klevel)
						else 
							columns[klevel] = [_asEmpty]
					}
				}
			}
			for (j=0; j<keys.length; j++) {
				var key = keys[j];
				var level = 0;
				if( key.indexOf(_nSeparator) > 0 ) {
					level = parseInt(key.substring(0, key.indexOf(_nSeparator)));
				}
				if( opts.columns[level] && opts.columns[level].lvalues ){
					addRecursiveValues(level, key);
				}
				columns[key] = _fUniqueArray(columns[key]);
			}

			var trmeasures = null;
			
			if( data.length > 0 ) {
				trmeasures = this.drawColumns(opts, columns, columnsSort, maxColumnLevel);
				if(trmeasures) {
					this.drawRows(opts, objRets, trmeasures.cells, maxRowLevel, maxSubRowLevel);
				}
			}
			else {
				var _tr = this.ztController.mViewer.htmlTable.rows[0];
				var _td = _tr.cells[0];
				var _div;
				if( this.ztController.hasMenu ) {
					_td.classList.add("td-menu-ctrl", _cssmode);
					_div = document.createElement('div');
					_div.classList.add("refresh_menu_ctrl", "SPPortalZoomBaseMenu", "global_handler", "closed", _cssmode);
					_div.style.cursor = 'pointer';
					_div.onclick = function() {
						_this.manageMenu(this);
					}
					_td.appendChild(_div);
				}

				_tr = this.ztController.mViewer.htmlTable.rows[1];
				_td = _tr.cells[1];
				_div = document.createElement('div');
				_div.classList.add("label");
				_td.appendChild(_div);
				if( this.ztController.PSCtrl && this.ztController.PSCtrl.pvGetTranslate)
					_div.innerHTML = this.ztController.PSCtrl.pvGetTranslate("Empty_Data");
				else
					_div.innerHTML = 'Empty Data';

				this.ztController.mViewer.htmlContainer.style.visibility = 'visible';
				if( this.ztController.PSCtrl && this.ztController.PSCtrl.adjustFormHeight ) this.ztController.PSCtrl.adjustFormHeight();
				if( this.ztController.PSCtrl && this.ztController.PSCtrl.hideLoadingDiv ) this.ztController.PSCtrl.hideLoadingDiv();
				if( this.ztController._initOpts.onRendered ) {
					this.ztController._initOpts.onRendered();
				}
				return;
			}
				
			if( initUi && this.htmlCTable ) this.htmlCTable.click();
		}
		
		this.getState = function() {
			var ret = {};
			ret.columnsSubLevel = []
			ret.rowsSubLevel = []
			var divs = this.tdAreaColumns.getElementsByClassName("openlevel");
			var i, div, td, tr, key, level;
			if ( divs.length > 0 ) {
				for(i=0; i<divs.length; i++) {
					div = divs[i];
					td = div.parentNode;
					tr = td.parentNode;
					key = _fGetHTMLAttribute(td, "tckey");
					level = parseInt(_fGetHTMLAttribute(tr, "column-level"));
					if ( !ret.columnsSubLevel[level] ) {
						ret.columnsSubLevel[level] = [];
					}
					if ( ret.columnsSubLevel[level].indexOf(key) < 0 ) {
						ret.columnsSubLevel[level].push(key);
					}
				}
			}
			divs = this.tdAreaRows.getElementsByClassName("openlevel");
			if ( divs.length > 0 ) {
				for(i=0; i<divs.length; i++) {
					div = divs[i];
					td = div.parentNode;
					tr = td.parentNode;
					key = _fGetHTMLAttribute(td, "trkey");
					level = td.cellIndex;
					if ( !ret.rowsSubLevel[level] ) {
						ret.rowsSubLevel[level] = [];
					}
					if ( ret.rowsSubLevel[level].indexOf(key) < 0 ) {
						ret.rowsSubLevel[level].push(key);
					}
				}
			}
			return ret;
		}
		
		this.getAggregateValue = function(rows, key, index) {
			function getSub(rows, key, mArr, mArrZ) {
				if(!rows || !rows[key])
					return;
				if (  Array.isArray(rows[key]) ) {
					for( var i=0; i<rows[key].length; i++) {
						getSub(rows, key+_mSeparator+rows[key][i].value, mArr, mArrZ);
					}
				}
				else {
					if (key.indexOf(_znull) < 0) {
						mArr.push(rows[key])
					}
					else {
						var ind = key.split(_znull).length - 1;
						if(!mArrZ[ind]) {
							mArrZ[ind] = [];
						}
						mArrZ[ind].push(rows[key])
					}
				}
			}
			function calSub(mArr) {
				var ret = {};
				for (var i=0; i<mArr.length; i++) {
					var o = mArr[i];
					var keys = Object.keys(o);
					for(var j=0; j<keys.length; j++) {
						var mkey = keys[j];
						var okey = o[mkey];
						if (!ret[mkey]) {
							ret[mkey] = {};
						}
						if (okey != undefined) {
							var mxKeys = Object.keys(okey);
							for(var k=0; k<mxKeys.length; k++) {
								var nkey = mxKeys[k];
								if ( ret[mkey][nkey] ) {
									ret[mkey][nkey] += parseFloat(okey[nkey]);
								}
								else {
									ret[mkey][nkey] = okey[nkey];
								}
							}
						}
					}
				}
				return ret;
			}
			if (this.aggregateDataMap[key] && this.aggregateDataMap[key][index]) {
				return this.aggregateDataMap[key][index];
			}
			var ret = null;
			if(!rows || !rows[key])
				return ret;
			var mArr, mArrZ;
			if( key == _level0Key ) {
				mArr = [];
				mArrZ = [];
				getSub(rows, rows[key].value, mArr, mArrZ);
				if ( mArrZ.length > 0 ) {
					ret = calSub(mArrZ[mArrZ.length-1]);
				}
				else {
					ret = calSub(mArr);
				}
				
			}
			else {
				if (  Array.isArray(rows[key]) ) {
					mArr = [];
					mArrZ = [];
					for( var i=0; i<rows[key].length; i++) {
						getSub(rows, key+_mSeparator+rows[key][i].value, mArr, mArrZ);
					}
					if ( mArrZ.length > 0 ) {
						ret = calSub(mArrZ[mArrZ.length-1]);
					}
					else {
						ret = calSub(mArr);
					}
				}
				else {
					ret = rows[key];
				}
			}

			if (!this.aggregateDataMap[key]) {
				this.aggregateDataMap[key] = [];
			}
			_this.ztVPivotData.updateWTotal(key, ret);
			this.aggregateDataMap[key][index] = ret;
			return ret;
		}

		this.getFilterDivPosition = function(handler) {
			if( handler ) return _fGetAbsoluteXY(handler);
			//return _fGetAbsoluteXY(this.htmlFLTable);
		}
	  }
	  
	  try {
		this.mViewer = new dataViewer(this.htmlContainer, this);
	  }
	  catch(error) {
		  _fOnError(this.htmlContainer, error);
		  return;
	  }
	  
	  this.updateDraw = function(Fields, Data, bDraw, Filters) {
		  try {
			if( this.ztVPivotData == null ) {
				if ( this.bQueryLevel == true ) {
					this.ztVPivotData =  new ZtVPivotData(this.opts, Fields, Data, true, this.PSCtrl==null);
				}
				else {
					this.ztVPivotData =  new ZtVPivotData(this.opts, Fields, Data, false, this.PSCtrl==null);
				}
				this.aggregateObjRets = null;
				bDraw = true;
			}
			else {
				if ( this.bQueryLevel == true ) {
					var r = this.ztVPivotData.update(Fields, Data, this.opts, this._lastDrill);
					if (r) {
						this.aggregateObjRets = null;
					}
				}
				else {
					this.ztVPivotData =  new ZtVPivotData(this.opts, Fields, Data, false, this.PSCtrl==null);
					this.aggregateObjRets = null;
					bDraw = true;
					this.drillKeys = {};
					this.drawOpts.rows = [];
					this.drawOpts.columns = [];
					this.dataOpts.measures = [];
					this.drawOpts.rows.push(this.opts.rows[0]);
					this.drawOpts.columns.push(this.opts.columns[0]);
					this.drawOpts.measures = _fjsonCopy(this.opts.measures);
					this._SdrawOpts = null;
					this._SdrillKeys = null;
					this.drawOpts.rowsSubLevel = null;
					this.drawOpts.columnsSubLevel = null;
				}
			}
			if(bDraw == undefined || bDraw == null) {
			  bDraw = true;
			}
			if(bDraw == true) {
			  var force = (this.drawOpts.rows.length != this.dataOpts.rows.length);
			  this.drawOpts.filters = Filters;
			  this.dataOpts.rows = _fjsonCopy(this.drawOpts.rows); //si raggruppa solo per le righe richieste, se cambiano bisogna elaborare di nuovo i dati
			  this.dataOpts.columns = _fjsonCopy(this.opts.columns); //si raggruppa sempre con tutte le colonne
			  this.dataOpts.measures = _fjsonCopy(this.drawOpts.measures);
			  this.dataOpts.filters = _fjsonCopy(this.drawOpts.filters);
			  this.nestedData = this.ztVPivotData.getNestedData(this.dataOpts, force);
			  var fnc = function() {
				_this._updateFiltersDiv();
				//_this.PSObserver.observe(_this.htmlContainer);
			  }
			  this.mViewer.draw(false, fnc);
			}
		  }
		  catch(error) {
			_fOnError(this.htmlContainer, error);
			return;
		  }
	  }

	  this._checkDrawOpts = function (drawOpts) {
		var isValid = true;
		var updRowsF = [], updRowsO = [];
		var updColsF = [], updColsO = [];
		var i, k;
		if (drawOpts.columns == undefined) {
			drawOpts.columns = [];
		}
		if (drawOpts.rows == undefined) {
			drawOpts.rows = [];
		}
		if (drawOpts.columns.length == 0) {
			drawOpts.columns.push(this.opts.columns[0])
		}

		for(i=drawOpts.rows.length-1; i>=0; i--) {
			if(!drawOpts.rows[i]) {
			   drawOpts.rows.splice(i, 1);
			}
		}
		for(i=drawOpts.columns.length-1; i>=0; i--) {
			if(!drawOpts.columns[i]) {
			   drawOpts.columns.splice(i, 1);
			}
		}

		for(i=0; isValid && i<drawOpts.rows.length; i++) {
		   if(drawOpts.rows[i] && this.opts.rows[i]) {
			   if(drawOpts.rows[i].alias != this.opts.rows[i].alias) {
				   isValid = false;
			   }
			   else {
				   for( k=0; k<this._initOpts.fields.length; k++ ) {
					   if(drawOpts.rows[i].alias == this._initOpts.fields[k].alias) {
						   drawOpts.rows[i].desc = this._initOpts.fields[k].desc;
						   drawOpts.rows[i].key = this._initOpts.fields[k].key;
						   drawOpts.rows[i].pictureFnc = this._initOpts.fields[k].pictureFnc;
						   drawOpts.rows[i].type = this._initOpts.fields[k].type;

						   if ( _fIsNotUndefined(drawOpts.rows[i].orderfield) ) {
							   updRowsF.push(i);
						   }
						   else {
							   drawOpts.rows[i].orderfield = this._initOpts.fields[k].orderfield;
						   }
						   if ( _fIsNotUndefined(drawOpts.rows[i].orderby) ) {
							  updRowsO.push(i);
						   }
						   else {
							  drawOpts.rows[i].orderby = this._initOpts.fields[k].orderby;
						   }
						   k = this._initOpts.fields.length;
					   }
				   }
			   }
		   }
		   else {
			   isValid = false;
		   }
		}
		for(i=0; isValid && i<drawOpts.columns.length; i++) {
			if(drawOpts.columns[i] && this.opts.columns[i]) {
			   if(drawOpts.columns[i].alias != this.opts.columns[i].alias) {
				   isValid = false;
			   }
			   else {
				   for( k=0; k<this._initOpts.fields.length; k++ ) {
					   if(drawOpts.columns[i].alias == this._initOpts.fields[k].alias) {
						   drawOpts.columns[i].desc = this._initOpts.fields[k].desc;
						   drawOpts.columns[i].key = this._initOpts.fields[k].key;
						   drawOpts.columns[i].pictureFnc = this._initOpts.fields[k].pictureFnc;
						   drawOpts.columns[i].lvalues = this._initOpts.fields[k].lvalues;
						   drawOpts.columns[i].type = this._initOpts.fields[k].type;

						   if ( _fIsNotUndefined(drawOpts.columns[i].orderfield) ) {
							   updColsF.push(i);
						   }
						   else {
							   drawOpts.columns[i].orderfield = this._initOpts.fields[k].orderfield;
						   }
						   if ( _fIsNotUndefined(drawOpts.columns[i].orderby) ) {
							  updColsO.push(i);
						   }
						   else {
							  drawOpts.columns[i].orderby = this._initOpts.fields[k].orderby;
						   }
						   k = this._initOpts.fields.length;
					   }
				   }
			   }
		   }
		   else {
			   isValid = false;
		   }
		}


		drawOpts.measures = [];
		for(i=0; isValid && i<this.opts.measures.length; i++) {
		  var f = false;
		  for( k=0; k<this._initOpts.measures.length; k++ ) {
			  if(this.opts.measures[i].alias == this._initOpts.measures[k].alias) {
				  drawOpts.measures.push(this._initOpts.measures[k]);
				  k = this._initOpts.measures.length;
				  f = true;
			  }	
		  }
		  if(!f) {
			  for( k=0; k<this._initOpts.fields.length; k++ ) {
				  if(this.opts.measures[i].alias == this._initOpts.fields[k].alias) {
					  drawOpts.measures.push(this._initOpts.fields[k]);
					  k = this._initOpts.fields.length;
					  f = true;
				  }	
			  }
		  }	
		}

		if ( isValid ) {
			drawOpts.measuresOnColumn = this._initOpts.measuresOnColumn;
			drawOpts.subTotalOnRow = this._initOpts.subTotalOnRow;
			drawOpts.subTotalOnRowLevel = this._initOpts.subTotalOnRowLevel;
			drawOpts.subTotalOnColumn = this._initOpts.subTotalOnColumn;
			drawOpts.bigTotalOnRow = this._initOpts.bigTotalOnRow;
			drawOpts.bigTotalOnColumn = this._initOpts.bigTotalOnColumn;
			drawOpts.bigTotalTitle = this._initOpts.bigTotalTitle;
			drawOpts.subTotalTitle = this._initOpts.subTotalTitle;
			drawOpts.measuresTitle = this._initOpts.measuresTitle;
			drawOpts.sortRow = this._initOpts.sortRow;
			drawOpts.sortColumn = this._initOpts.sortColumn;
			drawOpts.hideMeasures = this._initOpts.hideMeasures;
			for(i=0; i<updRowsF.length; i++) {
				k = updRowsF[i];
				if( drawOpts.rows[k].orderfield == null) {
					delete this.opts.rows[k].orderfield;
					delete drawOpts.rows[k].orderfield;
				}
				else {
				  this.opts.rows[k].orderfield = drawOpts.rows[k].orderfield;
				}
			}
			for(i=0; i<updRowsO.length; i++) {
				k = updRowsO[i];
				 if( drawOpts.rows[k].orderby == null) {
					delete this.opts.rows[k].orderby;
					delete drawOpts.rows[k].orderby;
				}
				else {
				  this.opts.rows[k].orderby = drawOpts.rows[k].orderby;
				}
			}
			for(i=0; i<updColsF.length; i++) {
				k = updColsF[i];
				if( drawOpts.columns[k].orderfield == null) {
					delete this.opts.columns[k].orderfield;
					delete drawOpts.columns[k].orderfield;
				}
				else {
				  this.opts.columns[k].orderfield = drawOpts.columns[k].orderfield;
				}
			}
			for(i=0; i<updColsO.length; i++) {
				k = updColsO[i];
				if( drawOpts.columns[k].orderby == null) {
					delete this.opts.columns[k].orderby;
					delete drawOpts.columns[k].orderby;
				}
				else {
				  this.opts.columns[k].orderby = drawOpts.columns[k].orderby;
				}
			}
		}
		return isValid;
	}
		
	  this.draw = function(drawOpts, Fields, Data) {
		  var src, l, i;
		  var files;
		  var count = 0;
		  function _asyncDraw(myPivot, count, length) {
			if ( count >= length ) {
				try {
					var fnc = function(){
						var vState = _this.mViewer.getState();
						_this.drawOpts.columnsSubLevel = vState.columnsSubLevel;
						_this.drawOpts.rowsSubLevel = vState.rowsSubLevel;
						_this._updateFiltersDiv();
						//_this.PSObserver.observe(_this.htmlContainer);
					}
					myPivot.mViewer.draw(true, fnc);
				}
				catch(error) {
					_fOnError(myPivot.htmlContainer, error);
					return;
				}
			}
		  }
		  function _spprxycizerCss() {
			if ( (!_this.PSCtrl || (_this.PSCtrl && _this.PSCtrl._forceCSS )) && ZtVWeb) {
				var lfiles = _this.opts._cssFiles.toString();
				var URL = new ZtVWeb.JSURL(ZtVWeb.SPWebRootURL + '/servlet/SPPrxycizerServlet?files=' +  URLenc(lfiles), true );
				var url = URL.SetUnwrapMsg(false);
				var output = url.Response();
				if(!output.match("ACCESS DENIED")){
					_this.opts._cssFiles = output.split(',');
				}
			}
		  }
		  function _inLoad(/*src, status*/) {
			count++;
			_asyncDraw(_this, count, files.length);
		  }
		  
		  try {
			  if ( this.bQueryLevel == true ) {
				  this.ztVPivotData =  new ZtVPivotData(this.opts, Fields, Data, true, this.PSCtrl==null);
			  }
			  else {
				  this.ztVPivotData =  new ZtVPivotData(this.opts, Fields, Data, false, this.PSCtrl==null);
			  }  
			  if (!this._checkDrawOpts(drawOpts)) {
				  var error = new Error('Invalid configuration');
				  _fOnError(this.htmlContainer, error);
				  return;
			  }
			  this.dataOpts = {};
			  this.drawOpts = drawOpts;
			  this.dataOpts.rows = _fjsonCopy(drawOpts.rows); //si raggruppa solo per le righe richieste, se cambiano bisogna elaborare di nuovo i dati
			  this.dataOpts.columns = _fjsonCopy(this.opts.columns); //si raggruppa sempre con tutte le colonne
			  this.dataOpts.measures = _fjsonCopy(this.opts.measures);
			  this.nestedData = this.ztVPivotData.getNestedData(this.dataOpts);
  
			  _spprxycizerCss();
			  
			  files = this.opts._cssFiles;
			  _asyncDraw(_this, count, files.length); //caso 0

			  for ( i=0; i<files.length; i++)  {
				src = files[i];
				/*if(ZtVWeb) {
					ZtVWeb.RequireCSS(src, _inLoad);
				}
				else*/ {
					  l = document.createElement('link');
					  l.rel = 'StyleSheet';
					  l.type = 'text/css';
					  l.onload = function() {
						requestAnimationFrame ( function () {
							_inLoad();
						});
					  }
					  l.onerror = function() {
						requestAnimationFrame ( function () {
							_inLoad();
						});
					  }
					  l.href = '../' + src;
					  document.getElementsByTagName('head')[0].appendChild(l);
				}
			  }
			}
			catch(error) {
				_fOnError(this.htmlContainer, error);
				return;
			}
	  }
	  
	  this.redraw = function(drawOpts, asynFnc) {
		  try {
			var _bck = _fjsonCopy(this.drawOpts);
			delete _bck.columnsSubLevel;
			delete _bck.rowsSubLevel;
			
			if (!this._checkDrawOpts(drawOpts)) {
			  var error = new Error('Invalid configuration');
			  _fOnError(this.htmlContainer, error);
			  return;
			}
			
			if(JSON.stringify(_bck) === JSON.stringify(drawOpts)) {
			  return;
			}

			this.aggregateObjRets = null;
			var i;
			for(i=0; i<Math.min(this.drawOpts.rows.length, drawOpts.rows.length); i++) {
			  this.drawOpts.rows[i] = drawOpts.rows[i];
			}
			for(i=0; i<Math.min(this.drawOpts.columns.length, drawOpts.columns.length); i++) {
			  this.drawOpts.columns[i] = drawOpts.columns[i];
			}
			this.drawOpts.filters = drawOpts.filters;
			
			this.dataOpts.rows = _fjsonCopy(this.drawOpts.rows); 
			this.dataOpts.columns = _fjsonCopy(this.opts.columns); 
			this.dataOpts.measures = _fjsonCopy(this.drawOpts.measures);
			this.dataOpts.filters = _fjsonCopy(this.drawOpts.filters);
			this.nestedData = this.ztVPivotData.getNestedData(this.dataOpts, true);
			var fnc = function() {
				_this._updateFiltersDiv();
				//_this.PSObserver.observe(_this.htmlContainer);
				if( asynFnc) asynFnc();
			  }
			  this.mViewer.draw(false, fnc);
		  }
		  catch(error) {
			_fOnError(this.htmlContainer, error);
			return;
		  }
	  }
	  
	  this._sortRowColumn = function(objkey, alias, orderfield, orderby) {
		  var dOpts = {};
		  dOpts[objkey] = [];
		  var f = false;
		  var rowO;
		  for(var i=0; !f && i<this.opts[objkey].length; i++) {
			dOpts[objkey].push({"alias": this.opts[objkey][i].alias});
			if (this.opts[objkey][i].alias == alias) {
				f = true;
				rowO = this.opts[objkey][i];
			}
		  }
		  if(f == true) {
			  var cindex = dOpts[objkey].length-1;
			  if(_fIsNotUndefined(orderfield)) {
				  dOpts[objkey][cindex].orderfield = orderfield;
			  }
			  if(_fIsNotUndefined(orderby)) {
				  dOpts[objkey][cindex].orderby = orderby;
			  }
			  else {
				  if (rowO.orderby == 'asc') {
					  dOpts[objkey][cindex].orderby = 'desc';
				  }
				  else if (rowO.orderby == 'desc') {
					  dOpts[objkey][cindex].orderby = 'asc';
				  }
			  }
			  this.redraw(dOpts);
		  }
	  }
	  
	  this.sortRow = function(alias, orderfield, orderby) {
		  this._sortRowColumn('rows', alias, orderfield, orderby);
	  }
	  
	  this.sortColumn = function(alias, orderfield, orderby) {
		  this._sortRowColumn('columns', alias, orderfield, orderby);
	  }
	  
	  this._drillDownColumn = function(e, level, key) {
		  if( level <= 0 )
			  return;
		  this._drillColKey = key;
		  this._saveState();
		  var openclose;
		  if ( !this.drawOpts.columnsSubLevel ) {
			  this.drawOpts.columnsSubLevel = [];
		  }
		  if ( !this.drawOpts.columnsSubLevel[level-1] ) {
			  this.drawOpts.columnsSubLevel[level-1] = [];
		  }
		  var index = this.drawOpts.columnsSubLevel[level-1].indexOf(key);
		  var i, s, sx, j;
		  if (index < 0) {
			  this.drawOpts.columnsSubLevel[level-1].push(key);
			  s = key.split(_mSeparator)
			  for (i=0; i<level-1; i++) {
				if( i==0) sx = s[i];
				else sx += _mSeparator + s[i];
				if ( !this.drawOpts.columnsSubLevel[i] ) {
					this.drawOpts.columnsSubLevel[i] = [];
				}
				if( this.drawOpts.columnsSubLevel[i].indexOf(sx) < 0 ) {
					this.drawOpts.columnsSubLevel[i].push(sx);
				}
			  }
			  openclose = true;
		  }
		  else {
			  this.drawOpts.columnsSubLevel[level-1].splice(index, 1);
			  for( i=level; i<this.drawOpts.columnsSubLevel.length; i++ ) {
				  for( j=0; j<this.drawOpts.columnsSubLevel[i].length; j++ ) {
					  if( this.drawOpts.columnsSubLevel[i][j].indexOf(key) == 0 ) {
						  this.drawOpts.columnsSubLevel[i].splice(j, 1);
					  }
				  }
			  }
			  openclose = false;
		  }
		  		  
		  var lastColumnLevel = this.drawOpts.columns.length;
		  this.drawOpts.columns = [];
		  this.drawOpts.columns.push(this.opts.columns[0]);
		  for (i=0; i<this.drawOpts.columnsSubLevel.length; i++) {
			  if (!this.drawOpts.columnsSubLevel[i] || this.drawOpts.columnsSubLevel[i].length == 0) {
				  i = this.drawOpts.columnsSubLevel.length;
			  }
			  else {
				  this.drawOpts.columns.push(this.opts.columns[i+1]);
			  }
		  }

		  this._checkDrawOpts(this.drawOpts)
		  //nModif
		  if ( this.drawOpts.columns.length > lastColumnLevel ) { //da ottimizzare -- evitare di elaborare i dati se non serve!!!! //forse salvare per livello
			this.aggregateObjRets = null;
		}

		var o = {};
		o.level = level;
		o.drillDownRow = false;
		o.drill = [];
		o.isOpen = openclose;
		var lsplit = key.split(_mSeparator);
		var dkey = 'column' + _mSeparator + key;
		for( i=0; i<this.drawOpts.rows.length; i++)
			dkey += _mSeparator + this.drawOpts.rows[i].alias;
		var found = (this.drillKeys[dkey] != undefined);
		for (i=0; i<lsplit.length; i++) {
		  s = {};
		  if ( this.opts.columns[i].key )
			  s.key = this.opts.columns[i].key;
		  s.alias = this.opts.columns[i].alias;
		  s.value = lsplit[i];
		  o.drill.push(s);
		}

		if (found || !openclose || !this.bQueryLevel) {
			this.dataOpts.rows = _fjsonCopy(this.drawOpts.rows); //si raggruppa solo per le righe richieste, se cambiano bisogna elaborare di nuovo i dati
			this.dataOpts.columns = _fjsonCopy(this.opts.columns); //si raggruppa sempre con tutte le colonne //non e' piu' vero!
			this.dataOpts.measures = _fjsonCopy(this.drawOpts.measures);
			this.dataOpts.filters = _fjsonCopy(this.drawOpts.filters);
			this.nestedData = this.ztVPivotData.getNestedData(this.dataOpts, true);
		   if (!found) {
			   found = true;
		   }
		   var fnc = function() {
			  _this._updateFiltersDiv();
			  //_this.PSObserver.observe(_this.htmlContainer);
			  _this.drillKeys[dkey] = 1;
			  if(_this._initOpts.onDrillDown) {
				  o.found = found;
				  _this._initOpts.onDrillDown(e, o)
			  }
			  if (found || !openclose || !_this.bQueryLevel) {
				 // _this.PSObserver.observe(_this.htmlContainer);
			  }
			}
		  this.mViewer.draw(false, fnc);
		}
		else {
			  this.aggregateObjRets = null;
			  this.drillKeys[dkey] = 1;
			  if(this._initOpts.onDrillDown) {
				  o.found = found;
				  this._initOpts.onDrillDown(e, o)
			  }
			  if (found || !openclose || !this.bQueryLevel) {
				  this.PSObserver.observe(this.htmlContainer);
			  }
		}
		  /*if ( (this.drawOpts.rows.length != this.dataOpts.rows.length) ) {
			 this.dataOpts.rows = _fjsonCopy(this.drawOpts.rows); //si raggruppa solo per le righe richieste, se cambiano bisogna elaborare di nuovo i dati
			 this.dataOpts.columns = _fjsonCopy(this.opts.columns); //si raggruppa sempre con tutte le colonne
			 this.dataOpts.measures = _fjsonCopy(this.drawOpts.measures);
			 this.dataOpts.filters = _fjsonCopy(this.drawOpts.filters);
			 this.nestedData = this.ztVPivotData.getNestedData(this.dataOpts, true);
			 this.aggregateObjRets = null;
		  }
		  if ( (this.drawOpts.columns.length > lastColumnLevel) ) {
			 //non dovrebbe servire rifare getNestedData, perche al momento generiamo sempre con tutte le colonne
			 this.aggregateObjRets = null;
		  }
		  var fnc = function() {
			_this._updateFiltersDiv();
			if(_this._initOpts.onDrillDown) {
			  var o = {};
			  o.level = level - 1;
			  o.drillDownRow = false;
			  o.drill = [];
			  o.isOpen = openclose;
			  var lsplit = key.split(_mSeparator);
			  for (i=0; i<lsplit.length; i++) {
				s = {};
				  if ( _this.opts.columns[i].key )
					  s.key = _this.opts.columns[i].key;
				  s.alias = _this.opts.columns[i].alias;
				s.value = lsplit[i];
				o.drill.push(s);
			  }
				_this._initOpts.onDrillDown(e, o)
			}
			_this.PSObserver.observe(_this.htmlContainer);
		  }
		  this.mViewer.draw(false, fnc);*/
	  }
	  
	  this._drillDownRow = function(e, level, key) {
		  if( level < 0 )
			  return;
		  this._drillRowKey = key;
		  this._saveState();
		  var openclose;
		  if ( !this.drawOpts.rowsSubLevel ) {
			  this.drawOpts.rowsSubLevel = [];
		  }
		  if ( !this.drawOpts.rowsSubLevel[level] ) {
			  this.drawOpts.rowsSubLevel[level] = [];
		  }
		  var index = this.drawOpts.rowsSubLevel[level].indexOf(key);
		  var i, s, sx;
		  if (index < 0) {
			  this.drawOpts.rowsSubLevel[level].push(key);
			  s = key.split(_mSeparator)
			  for (i=0; i<level; i++) {
				if( i==0) sx = s[i];
				else sx += _mSeparator + s[i];
				if ( !this.drawOpts.rowsSubLevel[i] ) {
					this.drawOpts.rowsSubLevel[i] = [];
				}
				if( this.drawOpts.rowsSubLevel[i].indexOf(sx) < 0 ) {
					this.drawOpts.rowsSubLevel[i].push(sx);
				}
			  }
			  openclose = true;
		  }
		  else {
			  this.drawOpts.rowsSubLevel[level].splice(index, 1);
			  var c,k,l,pL,cL,vL,f;
			  for( c=level+1; c<this.drawOpts.rowsSubLevel.length; c++) {
				pL = this.drawOpts.rowsSubLevel[c-1];
				cL = this.drawOpts.rowsSubLevel[c];
				for(k=cL.length-1; k>=0; k--) {
					vL = cL[k];
					f = false;
					for(l=0; !f && l<pL.length; l++) {
						if( vL.indexOf(pL[l]) == 0 )
						 f = true;
					}
					if( !f ) {
						cL.splice(k, 1);
					}
				}
			  }
			  openclose = false;
		  }
		  var lastRowLevel = this.drawOpts.rows.length;
		  this.drawOpts.rows = [];
		  this.drawOpts.rows.push(this.opts.rows[0]);
		  
		  for (i=0; i<this.drawOpts.rowsSubLevel.length; i++) {
			if (!this.drawOpts.rowsSubLevel[i] || this.drawOpts.rowsSubLevel[i].length == 0) {
				i = this.drawOpts.rowsSubLevel.length;
			  }
			  else {
				this.drawOpts.rows.push(this.opts.rows[i+1]);
			  }
		  }

		  this._checkDrawOpts(this.drawOpts)

		  if ( this.drawOpts.rows.length > lastRowLevel ) { //da ottimizzare -- evitare di elaborare i dati se non serve!!!! //forse salvare per livello
			  this.aggregateObjRets = null;
		  }

		  var o = {};
		  o.level = level;
		  o.drillDownRow = true;
		  o.drill = [];
		  o.isOpen = openclose;
		  var lsplit = key.split(_mSeparator);
		  var dkey = 'row' + _mSeparator + key;
		  for( i=0; i<this.drawOpts.columns.length; i++)
			dkey += _mSeparator + this.drawOpts.columns[i].alias;
		  var found = (this.drillKeys[dkey] != undefined);
		  for (i=0; i<lsplit.length; i++) {
			s = {};
			if ( this.opts.rows[i].key )
				s.key = this.opts.rows[i].key;
			s.alias = this.opts.rows[i].alias;
			s.value = lsplit[i];
			o.drill.push(s);
		  }

		  if (found || !openclose || !this.bQueryLevel) {
			//if ( (this.drawOpts.rows.length != this.dataOpts.rows.length) ) {
				 this.dataOpts.rows = _fjsonCopy(this.drawOpts.rows); //si raggruppa solo per le righe richieste, se cambiano bisogna elaborare di nuovo i dati
				 this.dataOpts.columns = _fjsonCopy(this.opts.columns); //si raggruppa sempre con tutte le colonne //non e' piu' vero!
				 this.dataOpts.measures = _fjsonCopy(this.drawOpts.measures);
				 this.dataOpts.filters = _fjsonCopy(this.drawOpts.filters);
				 this.nestedData = this.ztVPivotData.getNestedData(this.dataOpts, true);
			 //}
			 if (!found) {
				 found = true;
			 }
			 var fnc = function() {
				_this._updateFiltersDiv();
				//_this.PSObserver.observe(_this.htmlContainer);
				_this.drillKeys[dkey] = 1;
				if(_this._initOpts.onDrillDown) {
					o.found = found;
					_this._initOpts.onDrillDown(e, o)
				}
				if (found || !openclose || !_this.bQueryLevel) {
					//_this.PSObserver.observe(_this.htmlContainer);
				}
			  }
			this.mViewer.draw(false, fnc);
		  }
		  else {
			  	this.aggregateObjRets = null;
				this.drillKeys[dkey] = 1;
				if(this._initOpts.onDrillDown) {
					o.found = found;
					this._initOpts.onDrillDown(e, o)
				}
				if (found || !openclose || !this.bQueryLevel) {
					this.PSObserver.observe(this.htmlContainer);
				}
	  	  }
	  }
	  
	  this.execDrillDownRow = function(valuesArray) {
		  if (!valuesArray || valuesArray.length==0)
			  return;
		  var level = valuesArray.length - 1;
		  var key = valuesArray[0];
		  for (var i=1; i<valuesArray.length; i++) {
				key += _mSeparator + valuesArray[i];
		  }
		  this._drillDownRow(null, level, key);
	  }
	  
	  this.execDrillDownColumn = function(valuesArray) {
		  if (!valuesArray || valuesArray.length==0)
			  return;
		  var level = valuesArray.length;
		  var key = valuesArray[0];
		  for (var i=1; i<valuesArray.length; i++) {
				key += _mSeparator + valuesArray[i];
		  }
		  this._drillDownColumn(null, level, key);
	  }
	  
	  this._saveState = function() {
		  this._SdrawOpts = _fjsonCopy(this.drawOpts);
		  this._SdrillKeys = _fjsonCopy(this.drillKeys);
	  }
	
	  this._restoreState = function() {
		  if ( this._SdrawOpts && this._SdrawOpts!= null ) {
			  this.drawOpts = _fjsonCopy(this._SdrawOpts);
			  this.drawOpts.measures = this.opts.measures;
			  this._SdrawOpts = null;
		  }
		  if ( this._SdrillKeys && this._SdrillKeys!= null ) {
			  this.drillKeys = _fjsonCopy(this._SdrillKeys); 
			  this._SdrillKeys = null;
		  }
	  }
	  
	  this._getFieldAliasKeyValue = function(rowColObj, key) {
		  if (this.ztVPivotData) {
			  return this.ztVPivotData._getFieldAliasKeyValue(rowColObj, key);
		  }
		  return key;
	  }

	  this._sortColumnsRollingUp = function(opts, columnIndex, arrayToSort, columnKey) {
		  if (this.ztVPivotData) {
			  return this.ztVPivotData.sortColumnsRollingUp(opts, columnIndex, arrayToSort, columnKey);
		  }
	  }

	  this._refresh = function () {
		if( _this.drawing == false )
			_fAdjustContainer(_this.htmlContainer);
	  }

	  //FUNCTIONS
	  function _fIsNotUndefined(o) {
		  return (o !== undefined)
	  }
	  
	  function _fjsonCopy(src) {
		if( src )
			return JSON.parse(JSON.stringify(src));
		return null;
	  }
	  
	  function _fAdjustHeightTables(htmlTable, className1, className2, myPivot) {
		var trows = htmlTable.getElementsByClassName(className1);
		var trowsh = htmlTable.getElementsByClassName(className2);
		if(trows && trowsh && trows[0] && trowsh[0] && trows[0].rows && trowsh[0].rows) {
			for (var i=0; i<trows[0].rows.length; i++) {
				if ( i == 0 && myPivot && myPivot.opts.columns.length == 1 && myPivot.opts.columns[0].alias.length == 0) { ////caso pivot senza colonne
					trows[0].rows[i].style.display = 'none';
					trowsh[0].rows[i].style.display = 'none';
				}
				else {
					var maxh = Math.max(trows[0].rows[i].offsetHeight, trowsh[0].rows[i].offsetHeight);
					trows[0].rows[i].style.height = maxh + "px";
					trowsh[0].rows[i].style.height = maxh + "px";
				}
			}
		}
	  }
	  
	  function _fAdjustWidthTables(htmlTable, className1, className2) {
		var trows = htmlTable.getElementsByClassName(className1);
		var trowsh = htmlTable.getElementsByClassName(className2);
		if(trows && trowsh && trows[0] && trowsh[0] && trows[0].rows && trowsh[0].rows) {
			var trh = trowsh[0].rows[trowsh[0].rows.length-1];
			var tr = trows[0].rows[trows[0].rows.length-1];
			if(trh && tr)
			for (var i=0; i<trh.cells.length; i++) {
				var td1 = trh.cells[i];
				var td2 = tr.cells[i];
				var w1 = _fGetOffset(td1).w;
				var w2 = _fGetOffset(td2).w;
				var w = Math.max(w1, w2);
				if(td1) {
					if(td1.childNodes.length > 1) {
						td1.firstChild.style.width = (w-td1.childNodes[1].offsetWidth) + "px";
						td1.childNodes[1].style.width = (td1.childNodes[1].offsetWidth) + "px";
					}
					else {
						td1.firstChild.style.width = (w) + "px";
					}

				}
				if(td2){
					if(td2.childNodes.length > 1) {
						td2.firstChild.style.width = (w-td2.childNodes[1].offsetWidth) + "px";
						td2.childNodes[1].style.width = (td2.childNodes[1].offsetWidth) +"px";
					}
					else {
						td2.firstChild.style.width = (w) + "px";
					}
				} 
			}
		}
	  }
	
	  function _fAdjustContainer(ctrl) {
		ctrl.style.overflowX = '';
		ctrl.style.overflowY = '';
		  var htmlTable = ctrl.getElementsByTagName('table')[0];
		  if(!htmlTable || !htmlTable.getElementsByClassName) {
			  ctrl.style.overflowX = '';
			  ctrl.style.overflowY = '';
			return;
		  }
		  if ( _this.lwidth && _this.lheight ) {
			  if ( (_this.lwidth == ctrl.offsetWidth) &&  (_this.lheight == ctrl.offsetHeight) ) {
				ctrl.style.overflowX = '';
				ctrl.style.overflowY = '';
				return;
			}
		  }
		  var tdrows = htmlTable.getElementsByClassName("td-view-rows");
		  var dvcolumns = htmlTable.getElementsByClassName("tdiv-data-columns");
		  var maxW = 0;
		  var i;
		  for (i=0; i<tdrows.length; i++) {
			maxW = Math.max(tdrows[i].offsetWidth, maxW);
		  }
		  var div, cW = ctrl.offsetWidth;
		  for (i=0; i<dvcolumns.length; i++) {
			if (cW - maxW > 0) {
			  if (dvcolumns[i].offsetWidth <= (cW - maxW)) {
				dvcolumns[i].style.maxWidth = (cW - maxW) + "px";
				dvcolumns[i].style.width = null;
			  }
			  else {
				dvcolumns[i].style.width = (cW - maxW) + "px";
			  }
			}
			else {
			  ctrl.style.overflowX = 'scroll'
			}
			if ( dvcolumns[i].classList.contains("tdiv-data") ) {
			  div = dvcolumns[i];
			}
		  }
		  //height
		  var tdcolumns = htmlTable.getElementsByClassName("td-view-columns");
		  var maxH = 0;
		  var divr, divr2, cH = ctrl.offsetHeight;
		  for (i=0; i<tdcolumns.length; i++) {
			maxH = Math.max(tdcolumns[i].offsetHeight, maxH);
		  }
		  if( (_this._initOpts.scroll_bars == 'true') && _this._initOpts.containerHeight > 0 ) cH = _this._initOpts.containerHeight;

		  //console.log(cH, maxH)
		  if (div && (cH - maxH > 0) ) {
			div.style.maxHeight = (cH - maxH) + "px"; //div tdiv-data
			divr = htmlTable.getElementsByClassName("tdiv-rows");
			divr[0].style.maxHeight = (cH - maxH) + "px";
		  }
		  else {
			ctrl.style.overflowY = 'scroll'
		  }
		  divr2 = htmlTable.getElementsByClassName("tdiv-data-columns");
		  if( divr2.length > 0 ) {
			divr2[0].classList.remove("tdiv-rows-overflowy");
			divr2[0].classList.remove(_cssmode);
			if (div && (div.clientHeight < div.scrollHeight)) { //scroll ver
				divr = htmlTable.getElementsByClassName("tdiv-columns");
				divr2[0].classList.add("tdiv-rows-overflowy");
			}
			divr2[0].classList.add(_cssmode);
		  }
		  divr = htmlTable.getElementsByClassName("tdiv-rows");
		  if( divr.length > 0 ) {
			divr[0].classList.remove("tdiv-rows-overflowx");
			divr[0].classList.remove(_cssmode);
			if (div && (div.clientWidth < div.scrollWidth)) { //scroll hor
			  divr[0].classList.add("tdiv-rows-overflowx");
			}
			divr[0].classList.add(_cssmode);
		  }
		  _this.lwidth = ctrl.offsetWidth;
		  _this.lheight = ctrl.offsetHeight;
		  //console.log(_this.lheight)
	  }

	  function _fUniqueArray(arrArg) {
		  return arrArg.filter(function(elem, pos,arr) {
			return arr.indexOf(elem) == pos;
		  });
	  }
	  
	  function _fReplaceSpecialChars(mtext) {
		  return mtext;
	  }
	  
	  function _fUnReplaceSpecialChars(mtext) {
		  return mtext;
	  }

	  function _fMergeDeepSum (o1, o2) {
		var tempNewObj = o1;
		if(o1==null) return o2;
		//if o1 is an object - {}
		if(o1.length === undefined && typeof o1 !== "number" && typeof o1 != "function") {
		  for(var key in o2){
			if(typeof o2[key]=="function")
			  continue;
			var value = o2[key];
			if(o1[key] === undefined) {
			  tempNewObj[key] = value;
			} else {
			  tempNewObj[key] = _fMergeDeepSum(o1[key], o2[key]);
			}
		  }
		}
		//else if o1 is an array - []
		else if(o1.length > 0 && typeof o1 !== "string" && typeof o1 != "function") {
		  for(var indexc in o2){
			if(typeof o2[indexc] == "function")
			  continue;
			if(o1[indexc] === undefined){
			  tempNewObj.push(o2[indexc]);
			}
			else{
			  var tmp = _fMergeDeepSum(o1[indexc], o2[indexc]);
			  tempNewObj[indexc] = tmp;
			}
		  };
		}
		//handling other types like string or number
		else if(typeof o1 != "function"){
		  //taking value from the second object o2
		  //could be modified to keep o1 value with tempNewObj = o1;
		  //if(typeof o1 !== "undefined") -- corretto EG
		  
		  //Modifica per sum
		  tempNewObj = o1+o2;
		}
		return tempNewObj;
	}
	 
	  function _fOnError(ctrl, error) {
		  if (ctrl) {
			   if(_this.PSCtrl && _this.PSCtrl.pvGetTranslate) {
				ctrl.innerHTML = _this.PSCtrl.pvGetTranslate("Error_msg");
			   }
			   else {
				ctrl.innerHTML = "ZTC_ERROR";
			   }
			   if(console.error) console.error(error);
		  }
		  else if(error) {
			  if(console.error) console.error(error);
		  }
	  }
	  
	  function _fHandleIntersectionObserver(entries, observer) {
		var htmlTable = entries[0].target;
		observer.unobserve(htmlTable);

		if ( observer.parent._reqAnimationId ) {
			cancelAnimationFrame(observer.parent.reqAnimationId);
		}	
		//observer.parent._timer = setTimeout(function(myPivot) {
		var myPivot = observer.parent;
		observer.parent._reqAnimationId = requestAnimationFrame ( function () {
			var htmlTable = entries[0].target;
			_fAdjustWidthTables(htmlTable, "t-rows", "t-rows-header");
			_fAdjustHeightTables(htmlTable, "t-rows-header", "t-columns", myPivot);
			if(myPivot.hasMenu 
				|| !myPivot._initOpts.hideMeasures && myPivot._initOpts.measuresOnColumn
				||  !myPivot._initOpts.measuresOnColumn
				) _fAdjustHeightTables(htmlTable, "t-rows-header-title", "t-columns-title", myPivot);
			_this.lwidth = 0;
			_this.lheight = 0;
			var trowsH, row;
			if( myPivot._initOpts.measuresOnColumn && myPivot._initOpts.hideMeasures ) {
				trowsH = htmlTable.getElementsByClassName("t-rows-header-title");
				if( trowsH.length == 0 ) return;
				var rows = trowsH[0].getElementsByTagName('tr');
				var tcolsH = htmlTable.getElementsByClassName("t-columns");
				rows = tcolsH[0].getElementsByTagName('tr');
				var lastrow = rows[rows.length - 1];
				var tds = lastrow.getElementsByTagName('td');
				lastrow.style.height = "0px";
				lastrow.style.visibility = 'collapse'
				var i;
				for( i=0; i<tds.length; i++ ) {
					tds[i].style.height = '0px';
					tds[i].classList.remove("td-measuretitle");
				}
				lastrow = rows[rows.length - 2];
				tds = lastrow.getElementsByTagName('td');
				for( i=0; i<tds.length; i++ ) {
					tds[i].classList.add("columntitle");
					tds[i].firstChild.classList.remove("columntitle");
					tds[i].firstChild.classList.remove("columnbigtotal");
					tds[i].firstChild.style.borderColor = 'transparent'
				}
			}
			else if( !myPivot._initOpts.measuresOnColumn && myPivot._initOpts.hideMeasures ) {
				trowsH = htmlTable.getElementsByClassName("t-rows");
				if( trowsH.length == 0 ) return;
				rows = trowsH[0].getElementsByTagName('tr');
				for( i=0; i<rows.length; i++ ) {
					row = rows[i];
					tds = row.lastChild;
					tds.style.display = 'none'
				}
				trowsH = htmlTable.getElementsByClassName("t-rows-header");
				rows = trowsH[0].getElementsByTagName('tr');
				for( i=0; i<rows.length; i++ ) {
					row = rows[i];
					tds = row.lastChild;
					tds.style.display = 'none'
				}
			}

			_fAdjustContainer(htmlTable);

			var scrTop = 0, scrLeft = 0;
			var rowdiv = myPivot.htmlContainer.getElementsByClassName("tdiv-data");
			if (myPivot._drillRowKey) {
				if (rowdiv && rowdiv.length > 0) {
					var _rDrill = document.querySelector("[trkey='" + myPivot._drillRowKey +"']");
					if( _rDrill) {
						// Get the top, left coordinates of two elements
						var eleRect = _rDrill.children[0].getBoundingClientRect();
						var targetRect = rowdiv[0].getBoundingClientRect();
						// Calculate the top and left positions
						scrTop = eleRect.top - targetRect.top - targetRect.height/2; //- targetRect.height/2; cercando di centrare
					}
				}
			}
			
			if (myPivot._drillColKey) {
				if (rowdiv && rowdiv.length > 0) {
					_rDrill = document.querySelector("[tckey='" + myPivot._drillColKey +"']");
					if( _rDrill) {
						// Get the top, left coordinates of two elements
						eleRect = _rDrill.children[0].getBoundingClientRect();
						targetRect =rowdiv[0].getBoundingClientRect();
						// Calculate the top and left positions
						scrLeft = eleRect.left - targetRect.left - targetRect.width/2;
					}
				}
			}
		
			var cfCols = htmlTable.getElementsByClassName('columns')
			var cfMeas = htmlTable.getElementsByClassName('measures')
			if( cfCols && cfMeas && cfCols[0] && cfMeas[0] && cfMeas[0].offsetHeight > 0)
				cfCols[0].style.height = cfMeas[0].offsetHeight + 'px';

			myPivot.mViewer.htmlContainer.style.visibility = 'visible';
			if( myPivot.PSCtrl && myPivot.PSCtrl.adjustFormHeight ) myPivot.PSCtrl.adjustFormHeight();
			if( myPivot.PSCtrl && myPivot.PSCtrl.hideLoadingDiv ) myPivot.PSCtrl.hideLoadingDiv();
			if( myPivot._initOpts.onRendered ) {
				myPivot._initOpts.onRendered();
			}

			if (rowdiv && rowdiv.length > 0) {
				rowdiv[0].scrollTo(scrLeft, scrTop);
			}
		});

		htmlTable.onmouseout = function(e) {
			if( e && e.relatedTarget && e.relatedTarget.hasAttribute('filterbyexample_handler')) return;
			if( myPivot && myPivot.PSCtrl && myPivot.PSCtrl._OutFilterByExample) {
				myPivot.PSCtrl._OutFilterByExample(e)
			}
		}
		htmlTable.onmouseover = function(e) {
			if( e && e.relatedTarget && !e.relatedTarget.hasAttribute('filterbyexample_handler')) return;
			if( myPivot && myPivot.PSCtrl && myPivot.PSCtrl._OutFilterByExample) {
				myPivot.PSCtrl._OutFilterByExample(e)
			}
		}
	  }
	  
	  function _fGetOffset(itm){
		  if (!itm)
			  return {w:0, h:0};
		  var bl =  parseInt(LibJavascript.DOM.getComputedStyle( itm, "border-left-width" )),
			br = parseInt(LibJavascript.DOM.getComputedStyle( itm, "border-right-width" )),
			ml = parseInt(LibJavascript.DOM.getComputedStyle( itm, "margin-left" )),
			mr = parseInt(LibJavascript.DOM.getComputedStyle( itm, "margin-right" )),
			pl = parseInt(LibJavascript.DOM.getComputedStyle( itm, "padding-left" )),
			pr = parseInt(LibJavascript.DOM.getComputedStyle( itm, "padding-right" )),
			gapw = bl+br+ml+mr+pl+pr,
			w = itm.offsetWidth - ( gapw),
			h = 0;
		  return {w:w, h:h}
	  }

	  function _fGetAbsoluteXY(itm) {
		if (!itm)
			return {'x':0,'y':0};
		var x = 0, y = 0;
		while (itm != null) {
			y += itm.offsetTop;
			x += itm.offsetLeft;
			itm = itm.offsetParent;
		}
		return {'x':x,'y':y};
	  }
	  
	  function _fPad(num) {
		var size = _npad;
		var s = num+"";
		while (s.length < size) s = "0" + s;
		return s;
	  }
	  
	  function _fSetHTMLAttribute(elem, attr, value) {
		if (attr == "class") {
			elem.setAttribute(attr, value);
			elem.classList.remove("td-measuretitle");
			elem.classList.remove("td-view-title");
		}
		else {
			elem.setAttribute(attr, _fReplaceSpecialChars(value));
		}
	  }
	  
	  function _fGetHTMLAttribute(elem, attr) {
		  if (attr == "class") {
			return elem.getAttribute(attr);
		}
		else {
			return _fUnReplaceSpecialChars(elem.getAttribute(attr));
		}
	  }
	  
	  function _fApplyPicture(value, fnc, htmlE, type){
				var v;
				if (fnc != undefined) {
					v = _this.ztVPivotData._getApplyPicture(fnc, value, null, type);
					htmlE.innerHTML = ToHTML(v);
				}
				else {
					if( value != null ) {
						if(typeof value == 'number') v = (value.toFixed(2))+"";
						else v = value;
						htmlE.innerHTML = ToHTML(v);
					}
					else {
						v = '';
						htmlE.innerHTML = ToHTML(v);
					}
				}
				return v;
	  }
			
	  function _fApplyCss(value, fnc, htmlE, rowkey, columnkey, aliasMeasure){
				if(fnc != undefined) {
					var pivotKeys = {};
					pivotKeys.rows = null;
					pivotKeys.columns = null;
					pivotKeys.measure = aliasMeasure;
					var lsplit, s, i;
					if (rowkey.indexOf(_level0Key) < 0) {
						pivotKeys.rows = [];
						lsplit = rowkey.split(_mSeparator);
						for (i=0; i<lsplit.length; i++) {
							s = {};
							if ( _this.opts.rows[i].key ) 
								s.key = _this.opts.rows[i].key;
							s.alias = _this.opts.rows[i].alias;
							s.value = lsplit[i];
							pivotKeys.rows.push(s);
						}
					}
					if (columnkey.indexOf(_level0Key) < 0) {
						pivotKeys.columns = [];
						lsplit = columnkey.split(_mSeparator);
						for (i=0; i<lsplit.length; i++) {
							s = {};
							if ( _this.opts.columns[i].key ) 
								s.key = _this.opts.columns[i].key;
							s.alias = _this.opts.columns[i].alias;
							s.value = lsplit[i];
							pivotKeys.columns.push(s);
						}
					}
					var ret;
					if(typeof fnc === 'string') {
						if(fnc.indexOf('function:') > -1) {
							fnc = fnc.replace(/function:/g, '');							
						}
						else if(fnc.indexOf('javascript:') > -1) {
							fnc = fnc.replace(/javascript:/g, '');
						}
						var evalStr =  fnc + '(' + value + ',' + 'pivotKeys' + ')';
						ret = eval(evalStr);
					}
					else {
						ret = fnc(value, pivotKeys);
					}
					if ( ret!=undefined ) {
						if (typeof ret === 'string' || ret instanceof String) {
							if(ret.length >0) {
								htmlE.classList.add(ret);
							}
						}
						else { //object
							var keys = Object.keys(ret);
							for(i=0; i<keys.length; i++) {
								htmlE.style[keys[i]] = ret[keys[i]];
							}
						}
					}
				}
	  }

	  function _fGetTextSize(divParent, value, pictureFnc) {
		var tb = document.getElementById(_refID + "_temp");
		if( !tb ) {
			tb = document.createElement('div');
			tb.id = _refID + "_temp";
			tb.style.visibility = 'hidden';
			tb.style.height = 'auto';
			tb.style.width = 'fit-content' ;
			divParent.appendChild(tb);
		}
		tb.innerHTML = value;
		var ret = {};
		ret.width = tb.offsetWidth;
		ret.height = tb.offsetHeight;
		var defNumPic = "999999.99";
		if (!Empty(pictureFnc)) {
			if( !(Object.prototype.toString.call(pictureFnc) === '[object Function]') && ((pictureFnc.indexOf('function:')==-1)) && ((pictureFnc.indexOf('javascript:')==-1)) ) {
				defNumPic = pictureFnc;
			}
		}
		if( defNumPic.toLocaleLowerCase().startsWith("@z") ) defNumPic = defNumPic.substring(2);
		tb.innerHTML = defNumPic;
		ret.width = Math.max(ret.width, tb.offsetWidth) + 10;
		ret.height = Math.max(ret.height, tb.offsetHeight) + 10;
		return ret;
	  }

	  function _fGetCounter(rowsColsArr) {
		var i, c=0;
		for( i=0; i<rowsColsArr.length; i++) {
			if(rowsColsArr[i].value) {
				if( rowsColsArr[i].value == _znull ) c++;
			}
			else {
				if( rowsColsArr[i] == _znull ) c++;
			}
		}
		return rowsColsArr.length-c;
	  }
	}
  };
  
  