/*  global
 */

if (typeof(ZtVPivotUI) == "undefined") { 
    function ZtVPivotUI(initOpts, opts, htmlZTable, PSCtrl, wKey) {
        this.opts = opts;
        this.PSCtrl = PSCtrl;
        this.htmlZTable = htmlZTable;
        this.initOpts = initOpts;
        this._wKey = wKey;
        var _uithis = this;

        LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/jquery.js');
        LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/jquery-ui.js');
        LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/jquery.ui.touch-punch.js');

        this.draw = function() {
            var ret;
            var tr1 = document.createElement('div');
            var tr2 = document.createElement('div');
            tr1.classList.add('drillboxer-row');
            tr1.classList.add('first');
            tr2.classList.add('drillboxer-row');
            tr2.classList.add('second');
            this.htmlZTable.appendChild(tr1);
            this.htmlZTable.appendChild(tr2);
            var td11 = document.createElement('div');
            var td12 = document.createElement('div');
            var tdnf = document.createElement('div');
            td11.classList.add('drillbox');
            td12.classList.add('drillbox');
            tdnf.classList.add('drillbox');
            tdnf.classList.add('drillboxconf');
            tdnf.classList.add('fields');
            td11.classList.add('drillboxconf');
            td11.classList.add('measures');
            td12.classList.add('drillboxconf');
            tr1.appendChild(tdnf);
            tr1.appendChild(td11);
            tr1.appendChild(td12);
            var td21 = document.createElement('div');
            var td22 = document.createElement('div');
            td21.classList.add('drillbox');
            td21.classList.add('drillboxconf');
            td21.classList.add('rows');
            td22.classList.add('drillbox');
            td22.classList.add('inner');
            tr2.appendChild(td21);
            tr2.appendChild(td22);

            divE = document.createElement('div');

            if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                str = this.PSCtrl.pvGetTranslate('Title_Measures');
            else 
                str = 'Values'
            divE.innerHTML = ToHTML(str);
            divE.classList.add('title');
            td11.appendChild(divE);

            divE = document.createElement('div');
            if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                str = this.PSCtrl.pvGetTranslate('Title_Rows');
            else 
                str = 'Rows'
            divE.innerHTML = ToHTML(str);
            divE.classList.add('title');
            td21.appendChild(divE);

            if( this.initOpts.uiDragDrop && opts.fields ) {
                var divUiList = document.createElement('div');
                divUiList.classList.add(this._wKey + "-group-fields", this._wKey + "-group-fields-measures", this._wKey + "-group-fields-dimensions", "gen-fields");
                divUiList.id = this._wKey + "-fields";
                var i, divE, divEE, divCE, type, str;
                var map = {};
                
                var divUiColumns = document.createElement('div');
                divUiColumns.classList.add(this._wKey + "-group-fields", this._wKey + "-group-fields-dimensions", "col-fields");
                divUiColumns.id = this._wKey + "-columns";

                divE = document.createElement('div');
                divE.classList.add('fields');
                divEE = document.createElement('div');
                if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                    str = this.PSCtrl.pvGetTranslate('Title_Fields'); 
                else 
                    str = 'Fields'
                divEE.innerHTML = ToHTML(str);
                divEE.classList.add('title');
                divE.appendChild(divEE)
                divE.appendChild(divUiList)
                tdnf.appendChild(divE);//td12.appendChild(divE);
                for( i=0; i<opts.columns.length; i++) {
                    divE = document.createElement('div');
                    type = _fncGetFieldDescAndType(opts.fields, opts.columns[i].alias, "").type;
                    divE.classList.add(this._wKey + "-single-field-" + type, this._wKey + "-single-field-dimension", "col-field");
                    
                    divEE = document.createElement('div');
                    divEE.id = this._wKey + "_" + opts.columns[i].alias.toLowerCase();
                    divEE.innerHTML = ToHTML(opts.columns[i].desc);
                    divEE.classList.add("alias_filter");
                    if (this.initOpts.canFilter) divEE.style.cursor = 'pointer';
                    divEE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divEE, 'alias', opts.columns[i].alias.toLowerCase());

                    divCE = document.createElement('div');
                    divCE.id = this._wKey + "_rem_" + opts.columns[i].alias.toLowerCase();
                    //divCE.innerHTML = ToHTML(opts.columns[i].desc);
                    divCE.classList.add("rem_filter");
                    if( this.PSCtrl && this.PSCtrl.pvGetTranslate) 
                        divCE.title = this.PSCtrl.pvGetTranslate('Remove_Filters');
                    if (this.initOpts.canFilter) divCE.style.cursor = 'pointer';
                    divCE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divCE, 'alias', opts.columns[i].alias.toLowerCase());

                    divE.appendChild(divEE);
                    divE.appendChild(divCE);
                    divCE.style.display = 'none';

                    _fSetHTMLAttribute(divE, 'alias', opts.columns[i].alias.toLowerCase());
                    
                    divUiColumns.appendChild(divE);
                    map[opts.columns[i].alias] = true;
                }
                divE = document.createElement('div');
                divE.classList.add('columns');
                divEE = document.createElement('div');
                if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                    str = this.PSCtrl.pvGetTranslate('Title_Columns');
                else 
                    str = 'Columns'
                divEE.innerHTML = ToHTML(str);
                divEE.classList.add('title');
                divE.appendChild(divEE)
                divE.appendChild(divUiColumns)
                td12.appendChild(divE);

                var divUiRows = document.createElement('div');
                divUiRows.classList.add(this._wKey + "-group-fields", this._wKey + "-group-fields-dimensions", "row-fields");
                divUiRows.id = this._wKey + "-rows";
                for( i=0; i<opts.rows.length; i++) {
                    divE = document.createElement('div');
                    type = _fncGetFieldDescAndType(opts.fields, opts.rows[i].alias, "").type;
                    divE.classList.add(this._wKey + "-single-field-"+type, this._wKey + "-single-field-dimension", "row-field"); 
                    
                    divEE = document.createElement('div');
                    divEE.id = this._wKey + "_" + opts.rows[i].alias.toLowerCase();
                    divEE.innerHTML = ToHTML(opts.rows[i].desc);
                    divEE.classList.add("alias_filter");
                    if (this.initOpts.canFilter) divEE.style.cursor = 'pointer';
                    divEE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divEE, 'alias', opts.rows[i].alias.toLowerCase());

                    divCE = document.createElement('div');
                    divCE.id = this._wKey + "_rem_" + opts.rows[i].alias.toLowerCase();
                    //divCE.innerHTML = ToHTML(opts.columns[i].desc);
                    divCE.classList.add("rem_filter");
                    if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                    divCE.title = this.PSCtrl.pvGetTranslate('Remove_Filters');
                    if (this.initOpts.canFilter) divCE.style.cursor = 'pointer';
                    divCE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divCE, 'alias', opts.rows[i].alias.toLowerCase());

                    divE.appendChild(divEE);
                    divE.appendChild(divCE);
                    divCE.style.display = 'none';

                    //divE.innerHTML = ToHTML(opts.rows[i].desc);
                    _fSetHTMLAttribute(divE, 'alias', opts.rows[i].alias.toLowerCase());
                    divUiRows.appendChild(divE);
                    map[opts.rows[i].alias] = true;
                }
                td21.appendChild(divUiRows);
                var divUiMeas = document.createElement('div');
                divUiMeas.classList.add(this._wKey + "-group-fields", this._wKey + "-group-fields-measures", "mea-fields");
                divUiMeas.id = this._wKey + "-measures";
                for( i=0; i<opts.measures.length; i++) {
                    divE = document.createElement('div');
                    type = _fncGetFieldDescAndType(opts.fields, opts.measures[i].alias, "").type;
                    divE.classList.add(this._wKey + "-single-field-" + type, this._wKey + "-single-field-measure", "mea-field", "defined-measure");
                    
                    divEE = document.createElement('div');
                    divEE.id = this._wKey + "_" + opts.measures[i].alias.toLowerCase();
                    divEE.innerHTML = ToHTML(opts.measures[i].desc);
                    divEE.classList.add("alias_filter");
                    if (this.initOpts.canFilter) divEE.style.cursor = 'pointer';
                    divEE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divEE, 'alias', opts.measures[i].alias.toLowerCase());

                    divCE = document.createElement('div');
                    divCE.id = this._wKey + "_rem_" + opts.measures[i].alias.toLowerCase();
                    //divCE.innerHTML = ToHTML(opts.columns[i].desc);
                    divCE.classList.add("rem_filter");
                    if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                    divCE.title = this.PSCtrl.pvGetTranslate('Remove_Filters');
                    if (this.initOpts.canFilter) divCE.style.cursor = 'pointer';
                    divCE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divCE, 'alias', opts.measures[i].alias.toLowerCase());

                    divE.appendChild(divEE);
                    divE.appendChild(divCE);
                    divCE.style.display = 'none';

                    //divE.innerHTML = ToHTML(opts.measures[i].desc);
                    _fSetHTMLAttribute(divE, 'alias', opts.measures[i].alias.toLowerCase());
                    divUiMeas.appendChild(divE);
                    map[opts.measures[i].alias] = true;
                }
                
                td11.appendChild(divUiMeas);

                function _findmeasure(alias, _this) {
                    var i, f;
                    f = false;
                    for( i=0; !f && i<_this.initOpts.measures.length; i++ ) {
                        if(_this.initOpts.measures[i].alias == alias) {
                            f = true;
                        }
                    }
                    if( f ) return true;
                    f = false;
                    for( i=0; !f && i<_this.initOpts.omeasures.length; i++ ) {
                        if(_this.initOpts.omeasures[i].alias == alias) {
                            f = true;
                        }
                    }
                    return f;
                }
                function _finddimension(alias, _this) {
                    var i, f;
                    f = false;
                    for( i=0; !f && i<_this.initOpts.rows.length; i++ ) {
                        if(_this.initOpts.rows[i].alias == alias) {
                            f = true;
                        }
                    }
                    for( i=0; !f && i<_this.initOpts.columns.length; i++ ) {
                        if(_this.initOpts.columns[i].alias == alias) {
                            f = true;
                        }
                    }
                    if( f ) return true;
                    f = false;
                    for( i=0; !f && i<_this.initOpts.odimensions.length; i++ ) {
                        if(_this.initOpts.odimensions[i].alias == alias) {
                            f = true;
                        }
                    }
                    return f;
                }
                function _addfield(oField, _this) {
                    divE = document.createElement('div');
                    type = _fncGetFieldDescAndType(opts.fields, oField.alias, "").type;

                    if( _this.initOpts.othDimMeas) {
                        if( (_this.initOpts.odimensions.length > 0) ||  (_this.initOpts.omeasures.length > 0) ) {
                            if( _findmeasure(oField.alias, _this) )
                                divE.classList.add(_this._wKey + "-single-field-" + type, _this._wKey + "-single-field-measure","gen-field", "defined-measure");
                            else
                                divE.classList.add(_this._wKey + "-single-field-" + type, _this._wKey + "-single-field-dimension", "gen-field");
                        }
                        else {
                            if( _findmeasure(oField.alias, _this) || ( (type == 'N') && !_finddimension(oField.alias, _this) ) )
                                divE.classList.add(_this._wKey + "-single-field-" + type, _this._wKey + "-single-field-measure","gen-field", "defined-measure");
                            else
                                divE.classList.add(_this._wKey + "-single-field-" + type, _this._wKey + "-single-field-dimension","gen-field");
                        }
                    }
                    else {
                        if( _findmeasure(oField.alias, _this) )
                            divE.classList.add(_this._wKey + "-single-field-" + type, _this._wKey + "-single-field-measure","gen-field", "defined-measure");
                        else
                            divE.classList.add(_this._wKey + "-single-field-" + type, _this._wKey + "-single-field-dimension", "gen-field");
                    }

                    
                    divEE = document.createElement('div');
                    divEE.id = _this._wKey + "_" + oField.alias.toLowerCase();
                    divEE.innerHTML = ToHTML(oField.desc);
                    divEE.classList.add("alias_filter");
                    if (_this.initOpts.canFilter) divEE.style.cursor = 'pointer';
                    divEE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divEE, 'alias', oField.alias.toLowerCase());

                    divCE = document.createElement('div');
                    divCE.id = _this._wKey + "_rem_" + oField.alias.toLowerCase();
                    //divCE.innerHTML = ToHTML(_opts.columns[i].desc);
                    divCE.classList.add("rem_filter");
                    if( this.PSCtrl && this.PSCtrl.pvGetTranslate)
                    divCE.title = _this.PSCtrl._FTranslations.Remove_Filters;
                    if (_this.initOpts.canFilter) divCE.style.cursor = 'pointer';
                    divCE.onclick = function() {
                        if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
                    }
                    _fSetHTMLAttribute(divCE, 'alias', oField.alias.toLowerCase());

                    divE.appendChild(divEE);
                    divE.appendChild(divCE);
                    divCE.style.display = 'none';

                    //divE.innerHTML = ToHTML(oField.desc);
                    _fSetHTMLAttribute(divE, 'alias', oField.alias.toLowerCase());
                    divUiList.appendChild(divE);
                }

                if( this.initOpts.othDimMeas) {
                    for( i=0; i<opts.fields.length; i++) {
                        if( !map[opts.fields[i].alias] ) {
                            _addfield(opts.fields[i], this)									
                        }
                    }
                }
                else {
                    for( i=0; i<this.initOpts.rows.length; i++) {
                        if( !map[this.initOpts.rows[i].alias] ) {
                            _addfield(this.initOpts.rows[i], this)									
                        }
                    }
                    for( i=0; i<this.initOpts.columns.length; i++) {
                        if( !map[this.initOpts.columns[i].alias] ) {
                            _addfield(this.initOpts.columns[i], this)									
                        }
                    }
                    for( i=0; i<this.initOpts.measures.length; i++) {
                        if( !map[this.initOpts.measures[i].alias] ) {
                            _addfield(this.initOpts.measures[i], this)									
                        }
                    }
                }
            }
            if( divUiMeas ) {
                var mMaxW = Math.max(divUiMeas.offsetWidth, divUiRows.offsetWidth);
                divUiMeas.style.width = mMaxW + "px";
                divUiRows.style.width = mMaxW + "px";
            }

            ret = td22;

            this.setEvents();
            
            return ret;
        }

        this.setEvents = function() {
            $('#' + _uithis._wKey + "-fields").sortable({
				containment: "parent",
    			tolerance: "pointer",
				stop: function(event, ui) {
					ui.item[0].classList.remove("mea-field");
					ui.item[0].classList.remove("row-field");
					ui.item[0].classList.remove("col-field");
					ui.item[0].classList.add("gen-field");
					ui.item[0].children[0].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
					}
					ui.item[0].children[1].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
					}
					if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvSetWDraw) {
                        _uithis.PSCtrl.pvSetWDraw(true);
                        if( _uithis.PSCtrl.pvResetAndDraw ) _uithis.PSCtrl.pvResetAndDraw();
                    }
				}
			});
			$('#' + _uithis._wKey + "-rows").sortable({
				containment: "parent",
    			tolerance: "pointer",
				stop: function(event, ui) {
					ui.item[0].classList.remove("mea-field");
					ui.item[0].classList.add("row-field");
					ui.item[0].classList.remove("col-field");
					ui.item[0].classList.remove("gen-field");
					ui.item[0].children[0].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
					}
					ui.item[0].children[1].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
					}
					if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvSetWDraw) {
                        _uithis.PSCtrl.pvSetWDraw(true);
                        if( _uithis.PSCtrl.pvResetAndDraw ) _uithis.PSCtrl.pvResetAndDraw();
                    }
				}
			});
			$('#' + _uithis._wKey + "-columns").sortable({
				containment: "parent",
    			tolerance: "pointer",
				stop: function(event, ui) {
					ui.item[0].classList.remove("mea-field");
					ui.item[0].classList.remove("row-field");
					ui.item[0].classList.add("col-field");
					ui.item[0].classList.remove("gen-field");
					ui.item[0].children[0].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
					}
					ui.item[0].children[1].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
					}
                    if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) {

                    }
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvSetWDraw) {
                        _uithis.PSCtrl.pvSetWDraw(true);
                        if( _uithis.PSCtrl.pvResetAndDraw ) _uithis.PSCtrl.pvResetAndDraw();
                    }
				}
			});
			$('#' + _uithis._wKey + "-measures").sortable({
				containment: "parent",
    			tolerance: "pointer",
				stop: function(event, ui) {
					ui.item[0].classList.add("mea-field");
					ui.item[0].classList.remove("row-field");
					ui.item[0].classList.remove("col-field");
					ui.item[0].classList.remove("gen-field");
					ui.item[0].children[0].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIFilterData) _uithis.PSCtrl.pvUIFilterData(this.id, null, _fGetHTMLAttribute(this, 'alias'));
					}
					ui.item[0].children[1].onclick = function() {
						if(_uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvUIRemFilterData) _uithis.PSCtrl.pvUIRemFilterData(_fGetHTMLAttribute(this, 'alias'));
					}
					if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvSetWDraw) {
                        _uithis.PSCtrl.pvSetWDraw(true);
                        if( _uithis.PSCtrl.pvResetAndDraw ) _uithis.PSCtrl.pvResetAndDraw();
                    }
				}
			});
						
			$('.' + _uithis._wKey + "-single-field-dimension").draggable({
				cursor: 'move',
				cursorAt: { top: 0, left: 0 },
				connectToSortable: '.' + _uithis._wKey + "-group-fields-dimensions",
				revert: false,
				revertDuration: 0,
				helper:'clone',
				opacity:0.7,
				stop: function(/*event, ui*/){
                    var _r = false;
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvGetWDraw) _r = _uithis.PSCtrl.pvGetWDraw();
					if( _r == true )
						$(this).remove();
					else
						this.classList.remove("moving-field");
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvSetWDraw) _uithis.PSCtrl.pvSetWDraw(false);
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.dispatchEvent) _uithis.PSCtrl.dispatchEvent('UIDragDrop');
				},
				start:  function(/*event, ui*/){
					this.classList.add("moving-field");
				}
			});
			$('.' + _uithis._wKey + "-single-field-measure").draggable({
				cursor: 'move',
				connectToSortable: '.' + _uithis._wKey + "-group-fields-measures",
				revert: false,
				revertDuration: 0,
				helper:'clone',
				opacity:0.7,
				stop: function(/*event, ui*/){
					var _r = false;
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvGetWDraw) _r = _uithis.PSCtrl.pvGetWDraw();
					if( _r == true )
						$(this).remove();
					else
						this.classList.remove("moving-field");
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.pvSetWDraw)   _uithis.PSCtrl.pvSetWDraw(false);
                    if( _uithis && _uithis.PSCtrl && _uithis.PSCtrl.dispatchEvent) _uithis.PSCtrl.dispatchEvent('UIDragDrop');
				},
				start:  function(/*event, ui*/){
					this.classList.add("moving-field");
				}
			});

        }
    }

    function _fSetHTMLAttribute(elem, attr, value) {
		if (attr == "class") {
			elem.setAttribute(attr, value);
			elem.classList.remove("td-measuretitle");
			elem.classList.remove("td-view-title");
		}
		else {
			elem.setAttribute(attr, value);
		}
	}

    function _fGetHTMLAttribute(elem, attr) {
        return elem.getAttribute(attr);
    }

    function _fncGetFieldDescAndType(FieldsArray, aliasValue, descValue){
		var ret = {};
		if (FieldsArray){
		  var alias = "", desc = "", type = "";
		  for (var i = 0; i < FieldsArray.length; i++) {
			alias = FieldsArray[i].alias.toLowerCase();
			if( FieldsArray[i].desc_trad ) desc =FieldsArray[i].desc_trad;
			else desc = FieldsArray[i].desc;
			type = FieldsArray[i].type;
			if(alias == aliasValue.toLowerCase()) {
			  ret.type = type;
			  if(!Empty(descValue)) {
				  ret.desc = descValue;
			  }
			  else if(!Empty(desc)) {
				ret.desc = desc;
			  }
			  else ret.desc = aliasValue;
			  return ret;
			}
		  }
		}
		ret.type = 'C';
		if(!Empty(descValue)) {
		  ret.desc = descValue;
		}
		else {
		ret.desc = aliasValue;
		}
		return ret;
	}
}