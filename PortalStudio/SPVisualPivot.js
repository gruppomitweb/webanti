/* global IsAny BatchJavascript GetStyleVariable getMultichromaticRangeColorPV*/
/* exported doVPV */
var filter_map;
function doVPV() {

  LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/ZtChartFunctions.js');

  var decoratorsFunctions = {};
  var caption='';
  var reload = true
  var viewHeaderFromConfig = true;
  var viewToolbarFromConfig = false;
  var advanced_suggester_active = false;
  var rcvNameGen = LibJavascript.AlfaKeyGen(5);
  var _this = this;
  var _listData = [];
  var _mSeparator = '##-##';
  var _saveConfig = false;

  this.hasFilters = false;  // indica se sono stati applicati filtri in vdm
  this.useMDataLevel = false;
  var _loadFixedFilters = null;
  this._copyObj = null;

  var securityOpts = {
    hidePivotFilters: _this.ConfigGridElements.Value().match(/-f/i)!=null,
    hideTitlePortlet: _this.ConfigGridElements.Value().match(/-h/i)!=null,
    hideSmallToolbar: _this.ConfigGridElements.Value().match(/-b/i)!=null,
    hidePrintButton: _this.ConfigGridElements.Value().match(/-p/i)!=null,
    hideConfigButton: _this.ConfigGridElements.Value().match(/-c/i)!=null
  };

  this.getZoomtitlesRefsByProperty = function(propertyName, fncAction) {
    var decoratorId = decoratorsFunctions[propertyName],
      decorator = decoratorId && ZtVWeb.getPortletById(decoratorId);
    if (decorator) {
      return fncAction.call(this, decorator);
    }
  };
  this.hasZoomtitlesID = function(propertyName) {
    return !!decoratorsFunctions[propertyName];
  };
  this.HideCaption=function() {
    var label = this.GetCurrentLabel()
    label.Value('');
    label.Ctrl.style.display='none'; //si deve usare display='none' e non visibility='hidden' per eliminare lo spazio occupato
    // this.Grid.topposition=0;
    // this.Grid.Ctrl.style.top=0; //la griglia viene riposizionata troppo tardi e c'e un problema di render iniziale
  }
  this.ShowCaption=function() {
    var label = this.GetCurrentLabel()
    label.Ctrl.style.display='';
  }

  this.GetCurrentCfgName =  function() {
    var cfgname = Strtran(this.ConfigName.Value(), '0/', '')
    cfgname = Strtran(cfgname, '1/', '')
    var idx = cfgname.indexOf('__');
    if (idx>-1) {
      cfgname = cfgname.substring(0, idx);
    }
    return cfgname;
  }

  this.GetCurrentVersion =  function() {
    var versions = this.__cfgObj.configuration.Versions||[];
    var versionname = 'default';
    var cfgname = this.ConfigName.Value();
    var idx = cfgname.indexOf('__');
    if (idx>-1) {
      versionname = cfgname.substring(idx+2);
      if (versions.indexOf(versionname)==-1) {
        versionname = '';//non dovrebbe mai succedere
      }
    }
    return versionname;
  }

  this.GetCurrentDataObj = function() {
    if( this.useMDataLevel )
      return this.mDataobj;
    return this.dataobj;
  }

  this.GetVersionsLabel=function() {
    // var version='';
    var frag = document.createDocumentFragment();
    if (this.menu_versioni) {
      var img = this.GetVersionsImage();
      if (typeof(img)=='string' && img!='') {
        if (SPTheme.portalZoomVersionItemOnLabel) {
          var lblVersion = Strtran(this.GetCurrentVersion(), '_', ' ');
          var span2 = document.createElement("span");
          span2.className = "SPPortalZoom_currentversion";
          span2.innerText = (lblVersion == 'default' ? '' : lblVersion);
          frag.appendChild(span2);
          // version = '<span class="SPPortalZoom_currentversion">' + (lblVersion=='default'?'':lblVersion) + '</span>' + version;
        }
        /** Formato JSON */
        if (Left(img,1)=='{' && Right(img,1)=='}') {
          img = JSON.parse(img);
          //lo stile tutto nel css generato
          var span = document.createElement("span");
          span.className = "SPPortalZoom_versionhandler";
          frag.appendChild(span);
          LibJavascript.Events.addEvent(span, "click", function(e){e.stopPropagation();this.menu_versioni.OpenMenu(span);}.bind(this));
          span.innerText = String.fromCharCode(img.Char);
          // version = "<span class='SPPortalZoom_versionhandler' onclick='"+this.formid+".menu_versioni.OpenMenu(this);event.stopPropagation();' onselectstart='return false;'>"+String.fromCharCode(img.Char)+"</span>";
        } else {
          var image = document.createElement("img");
          image.className = "SPPortalZoom_versionhandlerimage";
          image.src = img;
          LibJavascript.Events.addEvent(image, "click", function(e){e.stopPropagation();this.menu_versioni.OpenMenu(image);}.bind(this));
          frag.appendChild(image);
          // version = " <img class='SPPortalZoom_versionhandlerimage' style='cursor:pointer;' src='"+img+"' onclick='"+this.formid+".menu_versioni.OpenMenu(this)' onselectstart='return false;'></img>";
        }

      }
    }
    return frag;
  }

  var manageDocumentTitle = false;
  this.CaptionChanged=function(){
    if (!securityOpts.hideTitlePortlet && viewHeaderFromConfig) {
      this.getZoomtitlesRefsByProperty('SetCaption', function(portlet) {
        portlet.SetCaption(caption);
        this.HideCaption();
      }, this);
    }
    // } else {
      // (function(_this) {
      // function hideCaption() {
        // _this.HideCaption();
      // }
      //
      // _this.raiseCaptionChange(caption, hideCaption);
      // _this.raiseStatusChange(EmptyString(caption)?'':"zoom");
      // })(this);
    // }
    if(document.title=="" || manageDocumentTitle){
      document.title = caption;
      manageDocumentTitle = true;
    }
  }

  this.SetZoomTitle=function(){
    if((securityOpts.hideTitlePortlet || !viewHeaderFromConfig) && (this.hasZoomtitlesID('SetButtons') || this.hasZoomtitlesID('SetCaption'))) {
      function hide(portlet) {
        portlet.Ctrl.style.display='none';
      }
      this.getZoomtitlesRefsByProperty('SetButtons', hide);
      this.getZoomtitlesRefsByProperty('SetCaption', hide);
    } else if(this.hasZoomtitlesID('SetButtons') || this.hasZoomtitlesID('SetCaption')) {
      function show(portlet) {
        portlet.Ctrl.style.display='';
        portlet.setFormStep();
      }
      this.getZoomtitlesRefsByProperty('SetCaption', show);
      this.getZoomtitlesRefsByProperty('SetButtons', function(portlet){
        show(portlet);
        portlet.SetButtons(this.formid,this.ConfigGridElements.Value(),true/*this.autozoomCanAdd && !EmptyString(this.Grid.splinker)*/);
      }, this);
      this.CaptionChanged();
    }
  }

  function setZoomTitles(portlet) {
    var portletId = portlet.formid,
      zoomId = this.formid,
      containerId = (this.container && this.container.formid) || '';
    if(zoomId === portletId || containerId === portletId) { // salto me stesso e il mio contenitore diretto
      return;
    }
    if (portlet.portletname === 'SPVisualPivot' ||
      portlet.portletname === 'SPVisualPivotOL' ||
      (this.pageletId && this.pageletId !== portlet.pageletId)
    ) {
      // salto portlet che non appartengono alla stessa pagelet (quando questa c'e')
      // salto anche il portlet di zoom per evitare loop
      return;
    }
    addZoomtitleProp('SetButtons', portlet, zoomId);
    // addZoomtitleProp('Caption', portlet, zoomId); // imposizione:chi definisce SetCaption deve definire anche Caption
    addZoomtitleProp('SetCaption', portlet, zoomId);
    addZoomtitleProp('SetCssStyle', portlet, zoomId);
    addZoomtitleProp('SetSearchField', portlet, zoomId);
    addZoomtitleProp('SetLinkedConfs', portlet, zoomId);
    addZoomtitleProp('updateFilterButton', portlet, zoomId);
    addZoomtitleProp('SetActions', portlet, zoomId);
    addZoomtitleProp('SetOtherFields', portlet, zoomId);
    addZoomtitleProp('SetSaveConfig', portlet, zoomId);
    addZoomtitleProp('updateShowHideFieldsButton', portlet, zoomId);
    // addZoomtitleProp('AddField', portlet, zoomId);

    function addZoomtitleProp(propertyName, portletDecorator, zoomId) {
      var portletId = portletDecorator.formid,
        decoratorFunctionRef = portletDecorator[propertyName];

      if (decoratorFunctionRef) {
        // esiste una proprieta' del decoratore con il nome desiderato
        if (decoratorFunctionRef.zoomDecorator) {
          // funzione del decoratore gia' utilizzata da altro zoom
          return;
        }
        if (decoratorsFunctions[propertyName]) {
          // funzione gia' associata ad altro decoratore
          return
        }
        // associazione
        decoratorsFunctions[propertyName] = portletId; // associo la funzionalita' al decoratore
        portletDecorator[propertyName].zoomDecorator = zoomId; // associo la funzionalita' esposta dal decoratore allo zoom
      }
    }
  }

  ZtVWeb.addEventListener('portletloaded', function(e) {
    if(!e.detail.fromParent){ // stessa finestra
      setZoomTitles.call(this, e.detail.portlet);
    }
  }.bind(this));

  this.SearchZoomTitle=function(){
    if(!Empty(this.title_pagelet_decorator_id)){
      setZoomTitles.call(this, ZtVWeb.getPortletById(this.title_pagelet_decorator_id));
    }else{
      var portlets=ZtVWeb.getPortletsById();
      Object.keys(portlets).forEach(function(portletId){
        setZoomTitles.call(this, portlets[portletId]);
      }.bind(this));
    }
  }


  this.crumbObj = function (evt, ignoreFilterMap) {
    function operatorWithoutValue (op) {
      return ['empty', 'notempty', 'currentyear', 'lastyear', 'currentmonth', 'lastmonth',
        'last30days', 'last60days', 'last90days'].indexOf(op.toLowerCase()) >= 0;
    };
    var _dataobj = this.GetCurrentDataObj();
    var res = [],
      p_exp,
      p_op, op_suff = '_op', def_op = '=',
      p_type, type_suff = '_type', def_type = 'C',
      p_fixed, fixed_suff = '_fixed',
      p_queryP, queryP_suff = '_queryParm',
      p_visible, visible_suff = '_visible',
      p_userFilter, userFilter_suff = '_userFilter',
      p_picture, picture_suff = '_picture',
      p_defaultFilter, defaultFilter_suff = '_defaultFilter';
      if(!evt) return [];
    for (var p in evt) {
      if (!evt.hasOwnProperty(p)) {
        continue;
      }
      if (evt[p] != null && IsA(evt[p], 'O') && !IsA(evt[p], 'D')) {
        res = res.concat(this.crumbObj(evt[p], ignoreFilterMap));
        continue;
      }
      if ((p.match(op_suff + '$') && RTrim(p, op_suff) in evt) ||
        (p.match(type_suff + '$') && RTrim(p, type_suff) in evt) ||
        (Empty(evt[p]) && (p + op_suff) in evt && !operatorWithoutValue(evt[p+op_suff]))
        && (_dataobj.Fields_map && (p.toLowerCase() in _dataobj.Fields_map)) ||
        (filter_map && !(p in filter_map) && !ignoreFilterMap) ||
        p == "srcPortletId"
      ) continue;

      p_op = EmptyString(evt[p + op_suff]) ? def_op : evt[p + op_suff];//operatore
      p_type = EmptyString(evt[p + type_suff]) ? def_type : evt[p + type_suff];//tipo
      p_picture = EmptyString(evt[p + picture_suff]) ? '' : evt[p + picture_suff];//picture
      p_fixed = evt[p + fixed_suff] || false;//fisso
      p_queryP = evt[p + queryP_suff] || "";
      p_visible = evt[p + visible_suff] || false;//visible
      p_userFilter = evt[p + userFilter_suff] || false;//filtro da moschina
      p_defaultFilter = evt[p + defaultFilter_suff] || false;//filtro da moschina
      p_exp = evt[p];
      if (filter_map && !ignoreFilterMap) {
        p = filter_map[p];
      }
      res.push(
        {
          field: p,
          operator: p_op,
          expression: p_exp,
          type: p_type,
          picture: p_picture,
          fixed: p_fixed,
          queryparm: p_queryP,
          visible: p_visible,
          userFilter: p_userFilter,
          defaultFilter: p_defaultFilter
        });
    }
    return res;
  }

  this.SetFilters = function (evt, fixedFilter, onlyLoad) {
    var cGridPivot = this.GetCurrentPivot();
    if( cGridPivot.IsOpenUiDragDrop() ) {
      cGridPivot.ShowHideFields();
    }
    if( cGridPivot != null && cGridPivot.ztpivot )
      cGridPivot.ztpivot = null;
    reload = true;
    this.SetInnerFilters(evt, fixedFilter, onlyLoad)
  }

  this.SetInnerFilters = function (evt, fixedFilter, onlyLoad) {
    var keepFixed = false, keepUserFilter = false, keepDefaultFilter = false, ignoreFilterMap = false;
    var filters = this.crumbObj(evt, ignoreFilterMap);
    var cGridPivot = this.GetCurrentPivot();
    if( !cGridPivot ) return;

    function getFldIdx (field) {
      var fl = field.toLowerCase();
      var p = _this._copyObj.Fields.indexOf(fl);
      return p;
    }
    var _dataobj = this.GetCurrentDataObj();
    //rimuove i filtri precedenti
    if(!fixedFilter) cGridPivot.RemoveAllFilters(keepFixed, true, keepUserFilter, keepDefaultFilter); //primo parametro->false:elimina filtri fissi; secondo parametro->true:elimina filtri nascosti
    // eslint-disable-next-line no-cond-assign
    for (var i = 0, f; f = filters[i]; i++) {
      if (f.queryparm != "") {
        if (this[f.queryparm] && this[f.queryparm].Value) {
          this[f.queryparm].Value(f.expression);
        }
        else {
          this[f.queryparm] = new this.Var(f.expression);
          _dataobj.parms += "," + f.queryparm;
        }
      }
      else {
        var fidx;
        if ((fidx = getFldIdx(f.field)) != -1) {
          cGridPivot.AddFilter(
            cGridPivot.MakeFilter(f.field, f.operator, f.expression, _this._copyObj.fieldstypearray[fidx], true, f.userFilter, f.defaultFilter)
            , f.visible);
          cGridPivot.Filters[cGridPivot.Filters.length-1].picture = f.picture;
        }
        else if (this[f.field] && this[f.field].Value) {
          this[f.field].Value(f.expression);
        }
      }
    }

    if( onlyLoad == true ) return;

    cGridPivot.dispatchEvent('FiltersApplied');
    if (!fixedFilter){
      this.applyFilterOnDataobj(cGridPivot);
    }
    else {
      // quando leggo i filtri da vpv ridisegno (da controllare) + vdm zoom filter
      this.applyFilterOnPivot(cGridPivot);
    }
  }

  this.applyFilterOnDataobj = function (cGridPivot) {
    this.hasFilters = true;
    var _dataobj = this.GetCurrentDataObj();
    _dataobj.queryfilter = cGridPivot.CreateFilter();
    if( _dataobj.resetForNewQuery ) _dataobj.resetForNewQuery();
    _dataobj.Query();
    if (viewHeaderFromConfig && this.hasZoomtitlesID('updateFilterButton')) {
      this.getZoomtitlesRefsByProperty('updateFilterButton', function(portlet) {
        portlet.updateFilterButton();
      });
    }
    else {
      this.GetCurrentToolbar().UpdateItem('showVdm', {
        image:SPTheme.portalZoomFilterAppliedImage||{fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"}
      });
      var menuCtrl = this.GetCurrentMenu();
      if( menuCtrl ) menuCtrl.UpdateItem('showVdm', {
        action : function() {
          _this.ShowVdmMask();
          _this.CloseMenus();
        },
        image:SPTheme.portalZoomFilterAppliedImage||{fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"}
      });
    }
  }

  this.applyFilterOnPivot = function (ctrl) {
    if (!ctrl)
      return;
    ctrl.filter_change = true;
    this.hasFilters = true;
    ctrl.ApplyFilter();
    if (viewHeaderFromConfig && this.hasZoomtitlesID('updateFilterButton')) {
      this.getZoomtitlesRefsByProperty('updateFilterButton', function(portlet) {
        portlet.updateFilterButton();
      });
    }
    else {
      this.GetCurrentToolbar().UpdateItem('showVdm', {
        image:SPTheme.portalZoomFilterAppliedImage||{fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"}
      });
      var menuCtrl = this.GetCurrentMenu();
      if( menuCtrl ) menuCtrl.UpdateItem('showVdm', {
        image:SPTheme.portalZoomFilterAppliedImage||{fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"}
      });
    }
  }

  this.Chart.OperatorIndexes = this.GridPivot.OperatorIndexes = this.GridPivotB.OperatorIndexes = [ 'contains', 'like', '=', '<', '<=', '>=', '>', '<>', 'empty', 'notempty', 'currentmonth',
      'currentyear', 'lastmonth', 'lastyear', 'last30days', 'last60days', 'last90days' ];

  this.Chart.TypifyFilters = this.GridPivot.TypifyFilters = this.GridPivotB.TypifyFilters = function (filters, notFixed) {
    var Filters = [];
    for (var i = 0; i < filters.length;) {
      var o_filter = filters[i];
      if (notFixed && o_filter.fixed) {
        i++;
        continue;
      }
      var operator = typeof o_filter.operator == 'string' ? o_filter.operator : o_filter.operator.op;
      if (!EmptyString(o_filter.expression) || operator && this.operatorWithoutValue(operator)) {
        var n_filter = {};
        Filters.push(n_filter);
        n_filter.id = o_filter.id;
        n_filter.field = o_filter.field;
        n_filter.type = o_filter.type;
        n_filter.fixed = o_filter.fixed === 'true';
        n_filter.picture = o_filter.picture;
        n_filter.defaultFilter = o_filter.defaultFilter;
        n_filter.operator = this.OperatorIndexes.indexOf( o_filter.operator );
        n_filter.userFilter = o_filter.userFilter;
        n_filter.visible = o_filter.visible;
        var type = o_filter.type;
        var exp = o_filter.expression;
        var pict = o_filter.picture;
        if (type == 'D') {
          if (!IsAny(pict) || EmptyString(pict)) {
            pict = ZtVWeb.defaultDatePict;
          }
          if (typeof exp == 'string') {
            exp = ZtVWeb.valueToStr(ZtVWeb.strToValue(exp, type, pict), type);
          }
        } else if (type == 'T') {
          if (!IsAny(pict) || EmptyString(pict)) {
            pict = ZtVWeb.defaultDateTimePict;
          }
          if (typeof exp == 'string') {
            exp = ZtVWeb.valueToStr(ZtVWeb.strToValue(exp, type, pict), type);
          }
        } else if (type == 'N') {
          if (typeof exp != 'string') {
          } else if (isNaN(ZtVWeb.strToValue(exp, type, pict))) {
            exp = ZtVWeb.strToValue(exp, 'C', pict);
          } else {
            exp = ZtVWeb.strToValue(exp, type, pict);
          }
        } else if (type == 'L') {
          if (typeof exp == 'string') {
            exp = ZtVWeb.strToValue(exp, type, pict);
          }
        }
        n_filter.expression = exp;
        i++;
      } else if (!this._removeFilterByIndex(i, true)) {
        i++;
      }
    }
    return Filters;
  };

  this.GridPivot.CreateFilter = this.GridPivotB.CreateFilter = function (notFixed) {
    // genera frase SQL
    notFixed = Empty(notFixed) ? false : notFixed;
    var json = true;
    var dsource = this.datasource;
    var _dataobj = _this.GetCurrentDataObj();
    if (!this.datasource || (this.datasource.name != _dataobj.name))
      dsource = _dataobj;

    if (dsource.CreateFilter && !dsource.jsonFilters) {
      return dsource.CreateFilter(this.Filters, notFixed, this);
    }
    var isXMLDataProvider = !!dsource.root;
    //var JsonFilters = [];
    var filter = '';/*,
      sep = '',
      exp,
      type,
      pict = null;*/
      if (!isXMLDataProvider && json) {
        // Json Filters
        if (Empty(this.Filters)) {
          return '';
        }
        return JSON.stringify(this.TypifyFilters(this.Filters, notFixed));
      }
    /*for (var i = 0; i < this.Filters.length;) {
      var cur_filter = this.Filters[i];
      if (notFixed && cur_filter.fixed) {
        i++;
        continue;
      }
      var operator = typeof cur_filter.operator == 'string' ? cur_filter.operator : cur_filter.operator.op;
      if (!EmptyString(cur_filter.expression) || operator && this.operatorWithoutValue(operator)) {
        if (EmptyString(cur_filter.type) && dsource.fieldstypearray != null && !EmptyString(cur_filter.field)) {
          var fldIdx = dsource.getFldIdx(cur_filter.field);
          cur_filter.type = fldIdx == -1 ? 'C' : dsource.fieldstypearray[fldIdx];
        }
        filter += sep;
        var op = isXMLDataProvider && operator == '<>' ? '!=' : operator;
        type = cur_filter.type;
        if (!this.operatorWithoutValue(op)) {
          if (isXMLDataProvider && (op == 'contains' || op == 'like')) {
            if (op == 'contains') {
              filter += 'contains(translate(' + cur_filter.field + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),translate(";
            } else {
              filter += 'starts-with(translate(' + cur_filter.field + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),translate(";
            }
          } else {
            filter += cur_filter.field + ' ';
            filter += (op == 'contains' ? 'like' : op) + ' ';
          }
          pict = cur_filter.picture;
          exp = cur_filter.expression;
          if (!isXMLDataProvider) {
            if (type == 'D') {
              if (!IsAny(pict) || EmptyString(pict)) {
                pict = ZtVWeb.defaultDatePict;
              }
              if (typeof exp == 'string') {
                filter += ZtVWeb.toSQL(ZtVWeb.strToValue(exp, type, pict), type);
              } else {
                filter += ZtVWeb.toSQL(exp, type);
              }
            } else if (type == 'T') {
              if (!IsAny(pict) || EmptyString(pict)) {
                pict = ZtVWeb.defaultDateTimePict;
              }
              if (typeof exp == 'string') {
                filter += ZtVWeb.toSQL(ZtVWeb.strToValue(exp, type, pict), type);
              } else {
                filter += ZtVWeb.toSQL(exp, type);
              }
            } else if (type == 'N') {
              if (typeof exp != 'string') {
                filter += ZtVWeb.toSQL(exp, type);
              } else if (isNaN(ZtVWeb.strToValue(exp, type, pict))) {
                filter += ZtVWeb.toSQL(ZtVWeb.strToValue(exp, 'C', pict), 'C');
              } else {
                filter += ZtVWeb.toSQL(ZtVWeb.strToValue(exp, type, pict), type);
              }
            } else if (type == 'L') {
              if (typeof exp != 'string') {
                filter += ZtVWeb.toSQL(exp, type);
              } else {
                filter += ZtVWeb.toSQL(ZtVWeb.strToValue(exp, type), type);
              }
            } else {
              filter += ZtVWeb.toSQL(exp, type, isXMLDataProvider ? '' : op);
            }
          } else {
            // XMLDataprovider
            if (exp.indexOf('"') === -1) {
              exp = '"' + exp + '"';
            } else if (exp.indexOf("'") === -1) {
              exp = "'" + exp + "'";
            } else {
              exp = 'concat("' + exp.replace(/"/g, '",\'"\',"') + '")';
            }
            filter += exp;
          }
          if (isXMLDataProvider && (op == 'contains' || op == 'like')) {
            // filter+=')';
            filter += ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'))";
          }
          // 'currentyear', 'lastyear', 'currentmonth', 'lastmonth', 'last30days', 'last60days', 'last90days'
        } else if (op == 'currentyear') {
          filter += cur_filter.field + ' >= [FIRSTDAYCURRENTYEAR()] and ' + cur_filter.field + ' < [FIRSTDAYNEXTYEAR()]';
        } else if (op == 'lastyear') {
          filter += cur_filter.field + ' >= [FIRSTDAYPREVYEAR()] and ' + cur_filter.field + ' < [FIRSTDAYCURRENTYEAR()]';
        } else if (op == 'currentmonth') {
          filter += cur_filter.field + ' >= [FIRSTDAYCURRENTMONTH()] and ' + cur_filter.field + ' < [FIRSTDAYNEXTMONTH()]';
        } else if (op == 'lastmonth') {
          filter += cur_filter.field + ' >= [FIRSTDAYPREVMONTH()] and ' + cur_filter.field + ' < [FIRSTDAYCURRENTMONTH()]';
        } else if (op == 'last30days') {
          filter += cur_filter.field + ' >= [30DAYSBEFORE()] and ' + cur_filter.field + ' <= [CURRENTDATE' + (type == 'T' ? 'TIME' : '') + '()]';
        } else if (op == 'last60days') {
          filter += cur_filter.field + ' >= [60DAYSBEFORE()] and ' + cur_filter.field + ' <= [CURRENTDATE' + (type == 'T' ? 'TIME' : '') + '()]';
        } else if (op == 'last90days') {
          filter += cur_filter.field + ' >= [90DAYSBEFORE()] and ' + cur_filter.field + ' <= [CURRENTDATE' + (type == 'T' ? 'TIME' : '') + '()]';
        } else {
          var nullExp;
          switch (type) {
            case 'D':
              nullExp = 'NULL';
              break;
            case 'T':
              nullExp = 'NULL';
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
              if (isXMLDataProvider) {
                nullExp = "''";
              } else {
                nullExp = '';
              }
              break;
          }
          if (isXMLDataProvider) {
            filter = '(' + cur_filter.field + (op == 'notempty' ? '!=' : '=') + nullExp + ')';
          } else if (op == 'notempty') {
            if (type != 'C') {
              if ('NULL' == nullExp) {
                filter += cur_filter.field + ' is not null';
              } else {
                filter += cur_filter.field + ' <> ' + ZtVWeb.toSQL(nullExp, type) + ' and ' + cur_filter.field + ' is not null';
              }
            } else {
              filter += cur_filter.field + " > ' ' and " + cur_filter.field + ' is not null';
            }
          } else {
            filter += '(' + cur_filter.field + ' is null or ' + cur_filter.field + ' = ' + ZtVWeb.toSQL(nullExp, type) + ')';
          }
        }
        sep = ' and ';
        i++;
      } else if (!this._removeFilterByIndex(i, true)) {
        i++;
      }
    }*/
    return filter;
  }

  this.GetFilters = function () {
    var cGridPivot = this.GetCurrentPivot();
    if( !cGridPivot ) return;
    if(!cGridPivot.Filters) return; //todo chart
    var filters = [], f;
    // eslint-disable-next-line no-cond-assign
    for (var i = 0, filter; filter = cGridPivot.Filters[i++];) {
      f = JSON.parse( JSON.stringify(filter));
      f.fixed = false;
      filters.push(f);
    }
    return filters;
  }

  this.SetEmitters = function () {
    //imposta l'emitter $entity$_updateFilters
    var emtName = this.EmitterName.Value();
    /*if(EmptyString(emtName)){
      emtName=this.ConfigName.Value();
    }-*/
    this.$entity$_updateFilters.name = this.$entity$_updateFilters.name.replace('$entity$', emtName);
    this.$entity$_updateConfiguration.name = this.$entity$_updateConfiguration.name.replace('$entity$', emtName);
    this.$entity$_GetConfigurationField.name = this.$entity$_GetConfigurationField.name.replace('$entity$', emtName);
  }

  this.SetToolbarBox = function () {
    var toolbar = this.GetCurrentToolbar();
    var label = this.GetCurrentLabel();
    var box = this.GetCurrentBox();
    if (!viewHeaderFromConfig && viewToolbarFromConfig && toolbar && !securityOpts.hideSmallToolbar) {
      if(box) box.Expand();
        toolbar.getRenderHeight = null;
        label.getRenderHeight = function () {
          if (this.Ctrl != null) {
            this.Ctrl.style.height = 'auto';
            var h = this.Ctrl.offsetHeight;
            this.lastRenderHeight = ((this.shrinkable == 'true' || h > this.minheight) ? h : null)
            if (toolbar && !toolbar.IsHidden() && this.lastRenderHeight < SPTheme.portalZoomToolbarElementHeight) {
              this.lastRenderHeight = SPTheme.portalZoomToolbarElementHeight;
              this.Ctrl.style.height = this.lastRenderHeight + 'px';
              toolbar.Ctrl.style.height = SPTheme.portalZoomToolbarElementHeight + 'px';
            } else {
              toolbar.Ctrl.style.height = this.lastRenderHeight + 'px';
            }
          } else {
            this.lastRenderHeight = null
          }
          return this.lastRenderHeight
        }
        toolbar.setCtrlPos(
          toolbar.ctrl, toolbar.leftposition, toolbar.topposition, toolbar.controlwidth,
          SPTheme.portalZoomToolbarElementHeight, toolbar.anchor, this.width,
          this.height, false, false
        );
        toolbar.IconWidth(SPTheme.portalZoomToolbarElementHeight);
      //}
    }
    else {
      if(box) box.Collapse();
    }
  }

  this.GetConfigurationField = function () {
    var obj = {},
    i;
    for (i = 0; i < this.__cfgObj.cols.length; i++) {
      if (typeof (this.__cfgObj.cols[i].type) == 'undefined') this.setColType(this.__cfgObj.cols[i]);
      setFieldInObj(this.__cfgObj.cols[i], obj)
    }
    for (i = 0; i < this.__cfgObj.rows.length; i++) {
      if (typeof (this.__cfgObj.rows[i].type) == 'undefined') this.setColType(this.__cfgObj.rows[i]);
      setFieldInObj(this.__cfgObj.rows[i], obj)
    }
    /*for (i = 0; i < this.__cfgObj.measures.length; i++) {
      if (typeof (this.__cfgObj.measures[i].type) == 'undefined') this.setColType(this.__cfgObj.measures[i]);
      setFieldInObj(this.__cfgObj.measures[i], obj)
    }*/

    return obj;

    function setFieldInObj(fieldObj, obj) {
      if (!obj[fieldObj.field])
          obj[fieldObj.field] = {
          title: fieldObj.title,
          type: fieldObj.type || "C",
          hidden: false
        }
    }
  }

  this.setColType = function (col) {
    var t, field;
    field = clearField(col.field);
    if (this.datasource && (t = this.datasource.getType(field)) != null) {
      col.type = t;
    } else {
      col.type = ZtVWeb.getTypeFromPict(col.picture);
    }
    if (col.type == 'D' && (EmptyString(col.picture) || col.picture == null)) {
      col.picture = ZtVWeb.defaultDatePict;
    }
    if (col.type == 'T' && (EmptyString(col.picture) || col.picture == null)) {
      col.picture = ZtVWeb.defaultDateTimePict;
    }
  };

  /* menu functions
  */
  this.ShowHideFields = function() {
    var vobj = this.GetCurrentPivot();
    if( vobj && vobj.ShowHideFields) vobj.ShowHideFields();
    this.CloseMenus();
    var isextended = this.IsOpenUiDragDrop();
    var toolbar = this.GetCurrentToolbar();
    if( toolbar ) {
      toolbar.UpdateItem('expandreduce', {
        action:function() {
          _this.ShowHideFields();
        },
        title: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
        tooltip: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
        image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
        (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
      });
    }
    var menu = this.GetCurrentMenu()
    if( menu ) {
      menu.UpdateItem('expandreduce', {
        action:function() {
          _this.ShowHideFields();
        },
        title: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
        tooltip: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
        image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
        (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
      });
    }

  }

  this.IsOpenUiDragDrop = function() {
    var vobj = this.GetCurrentPivot();
    if( vobj && vobj.IsOpenUiDragDrop) {
      if(reload )
        return vobj.IsOpenUiDragDrop() && CharToBool(_this.__cfgObj.configuration.uiStartOpen+"");
      else
        return vobj.IsOpenUiDragDrop()
    }

    else return false;
  }

  this._initAfterReload = function() {
    reload = false;
    var pv = this.GetCurrentPivot();
    if (pv) {
      if( viewHeaderFromConfig ) {
        var dMenu = pv.ctrl.getElementsByClassName('SPPortalZoomBaseMenu');
        if( dMenu && dMenu[0]) dMenu[0].style.display = 'none';
      }
    }
    var isextended = this.IsOpenUiDragDrop();
    var toolbar = this.GetCurrentToolbar();
    if (toolbar && toolbar.IsInToolbar('expandreduce') || toolbar.IsInMenu('expandreduce'))
      toolbar.UpdateItem('expandreduce', {
          title: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
          tooltip: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
          image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
          (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
      });
      if (viewHeaderFromConfig && this.hasZoomtitlesID('updateShowHideFieldsButton')) {
        this.getZoomtitlesRefsByProperty('updateShowHideFieldsButton', function(portlet) {
          portlet.updateShowHideFieldsButton();
        });
      }
  }

  this.GridPivot_Rendered = function () {
    if( reload == true) {
      if (this.GridPivot.uiDragDrop && CharToBool(_this.__cfgObj.configuration.uiStartOpen+""))
        this.GridPivot.ShowHideFields();
      this.GridPivot.pvUpdateFiltersDiv();
    }
    this._initAfterReload()
  }

  this.Chart_Rendered = function () {
    if( document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_playMultiDimensional") )
      document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_playMultiDimensional").style.display = 'none';

    this.Chart.__forceNewSize = true;
    if (reload) {
      if (this.Chart.vpvPivotUI && this.Chart.vpvPivotUI._initOpts.uiDragDrop && CharToBool(_this.__cfgObj.configuration.uiStartOpen+""))
        this.Chart.ShowHideFields();
    }
    this._initAfterReload();
    this.Chart._updateFiltersDiv();

    var mydiv;
    //navbar tabs
    var combo = document.getElementById(this.Chart.ctrlid + '_ztchart_comboCursor');
    if( combo ) {
      combo.parentNode.style.display = 'none';
      var container = document.getElementById(this.Chart.ctrlid + '_ztchart_divchartcontainer');
      var nav = document.getElementById(this.Chart.ctrlid + '_chartTabsNavBar');
      var div;
      if( !nav ) {
          mydiv = document.createElement('div');
          mydiv.setAttribute('id', this.Chart.ctrlid + '_chartTabsNavBar');
          mydiv.style.margin = '1px 0 0 0';
          nav = mydiv;
      }

      if( document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_menuBar") ) {
        var referenceNode = document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_menuBar");
        container.insertBefore(nav, referenceNode.nextSibling);
      }
      else {
        container.prepend(nav);
      }
      nav.innerHTML = "";
      div = document.createElement("div");
      div.id = this.formid +'TabStrip';
      nav.appendChild(div);
      var js = {};
      js.name = 'TabStrip';
      js.ctrlid = this.formid +'TabStrip'
      js.x = 0;
      js.y = 0;
      js.w = 100;
      js.h = 24;
      js.expandcollapse = true;
      var zt = new ZtVWeb.TabStripControl(this, js);
      zt.addToForm(this, zt)
      this[js.name] = zt;
      //zt.setCtrlPos(zt.Ctrl, js.x, js.y, js.w, js.h, js.anchor, this.Chart.Ctrl.offsetWidth, this.Chart.Ctrl.offsetHeight,false,false);
      var z, c , selection;
      var pt = '', f, sp, exp;
      for(z=0; z<this.Chart.vpvDrillObj.columns.length; z++) {
        if( !Empty(pt) ) pt+= ' > ';
        f = this.Chart.vpvDrillObj.columns[z];
        if( f.desc ) {
          pt += f.desc;
        }
        else {
          if( f.expression != null ) {
            sp = f.expression.split(_mSeparator)
            exp = sp[sp.length-1]
          }
          else {
            exp = '   ';
          }
          pt += exp;
        }
      }
      if( !Empty(pt) ) pt+= ' > ';
      for(z=0; z<combo.length; z++){
        c = combo[z];
        zt.AddTab(c.value, pt + c.text)
        if(c.selected) selection = c.value;
      }
      if( selection ) zt.Select(selection);
    }

    //breadcrumbs
    if( this.Chart.vpvDrillObj.rows.length > 0 ) {
      var l = [], i;
      l.push( 'Root' );
      for( i=0; i<this.Chart.vpvDrillObj.rows.length; i++ ) {
        l.push(this.Chart.vpvDrillObj.rows[i].expression);
      }
      var __this = this;
      var fnc = function(svgElem, index) {
        if(!index)
          return;
        index = parseFloat(index);
        var j, draw = false;
        for( j=__this.Chart.vpvDrillObj.rows.length-1; j>=index; j-- ) {
          __this.Chart.vpvDrillObj.rows.pop();
         draw = true;
        }
        if( draw ) {
          __this.Chart.pvConfigureDraw();
          __this.Chart.pvDrawPivotData();
        }
        __this.refresh_menu.CloseMenu();
      }
      var confObj = {};
      confObj.color = '#357FC4';//confObj.css_class = 'breadcrumb';
      confObj.fnc = fnc;
      this.Chart.FillFixedBreadcrumb(l, confObj)
    }

    //
    if( combo ) {
      var item = {};
      item.multidimCurrentKey = combo.value;
      var childrend = [], childrenu = [];
      childrend = childrend.concat(this._makeDrillColumnsMenuChildren_down(item))
      childrenu = childrenu.concat(this._makeDrillColumnsMenuChildren_up())
      if( childrend.length > 0 || childrenu.length > 0 ) {
        if( document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_menuBar") )
          document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_menuBar").style.display = 'block';
        if( document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_menu") )
          document.getElementById(this.Chart.Ctrl.id + "_ztchart" + "_menu").style.display = 'block';

        var menuCtrl = this.Chart.GetMenuCtrl();
        if( childrend.length > 0 ) {
          menuCtrl.Append({
            title:FormatMsg('MSG_DRILL_DOWN'),
            tooltip:FormatMsg('MSG_DRILL_DOWN'),
            children:childrend,
            id:'actions_down'
          });
        }

        if( childrenu.length > 0 ) {
          menuCtrl.Append({
            title:FormatMsg('MSG_DRILL_UP'),
            tooltip:FormatMsg('MSG_DRILL_UP'),
            children:childrenu,
            id:'actions_up'
          });
        }
      }
    }
  }

  this.CloseMenus = function() {
    var menuCtrl = this.GetCurrentMenu();
    if( menuCtrl ) menuCtrl.CloseMenu();
    this.refresh_menu.CloseMenu();
  }

  this.TabStrip_Click = function(tabname) {
    var combo = document.getElementById(this.Chart.ctrlid + '_ztchart_comboCursor');
    if( combo ) {
      var z, c
      for(z=0; z<combo.length; z++){
        c = combo[z];
        if( c.value == tabname ) {
          c.selected = true;
          combo.dispatchEvent(new Event('change'));
          z = combo.length;
        }
      }
    }
    this.CloseMenus();
  }

  this.GridPivotB_Rendered = function () {
    this.CloseMenus();
    if( reload == true) {
        this.GridPivotB.pvUpdateFiltersDiv();
    }
    this.ChartB.rangefunc = "function:cssFncApplyChart"
    this.ChartB.SetChartDef(this.__cfgObj.configuration.chartDef);
    this.ChartB.SetUrlTooltip('../jsp-system/SPChartTooltipsR_portlet.jsp','default');

    // visione both con grafico - prima versione di Michel: gridpivot pilota sdp su chart
    var cData = this.GridPivotB.GetDataForChart();

    var _treeMap = _this.getChartMacroType(this.ChartB.ctype);
    if( _treeMap == 'hie' ) {
      this.ChartB.vmode = "";
      this.ChartB.propertyName = [];
      this.ChartB.propertyName.push('rowKey_pic');
      this.ChartB.propertyName.push('colKey_pic');
      this.ChartB.propertyName.push('rowKey');
      this.ChartB.propertyName.push('colKey');
      this.ChartB.propertyName.push(cData.Config.measures[0].alias);
      //this.ChartB.labelKey_field = this.vpvPivotUI.opts.columns[colLevel].alias+',' + this.vpvPivotUI.opts.rows[rowLevel].alias
      this.ChartB.label_field =  'colKey_pic' +',' +'rowKey_pic'
      this.ChartB.value_fields = cData.Config.measures[0].alias
      this.ChartB.label_series = ""
      this.ChartB.orgPName = this.ChartB.propertyName.slice();
      this.ChartB.makePropertyName();
    }
    else {
      /* setup props. multidim */
      this.ChartB.SetDataOrder('column')
      this.ChartB.vmode = "mdim";
      this.ChartB.multi_key_field = "colKey";
      this.ChartB.multi_label_field = "colKeyDesc";
      this.ChartB.multi_scale = false;
      this.ChartB.cursorType = "none";
      this.ChartB.multisubdivision = "default";

      var values = [];
      var labels = [];
      this.ChartB.propertyName = [];
      this.ChartB.propertyName.push('rowKey');
      this.ChartB.labelKey_field = 'rowKey'
      if(cData && cData.Config && cData.Config.measures){
        for( var i=0; i<cData.Config.measures.length; i++ ) {
          var o = cData.Config.measures[i];
          values.push(o.alias)
          labels.push(o.desc)
          this.ChartB.propertyName.push(o.alias)
        }
      }
      this.ChartB.propertyName.push('rowKey_pic');
      this.ChartB.label_field = 'rowKey_pic'
      this.ChartB.value_fields = values.join(',');
      this.ChartB.label_series = labels.join(',');
      this.ChartB.orgPName = this.ChartB.propertyName.slice();

      this.ChartB.makePropertyName();
      if( cData.columnsKeys && cData.columnsKeys.length > 2 ) {
        this.ChartB.cursorType = "combo";
      }
      else {
        this.ChartB.cursorType = "none";
      }
    }

    /* ------- */
    this.ChartB.__forceNewSize = true;
    this.ChartB.ctrl.style.bottom = '50%';
  	this.GridPivotB.ctrl.style.top = '55%';
    if( (reload == true) && this.GridPivotB.uiDragDrop && CharToBool(_this.__cfgObj.configuration.uiStartOpen+"")) {
      this.GridPivotB.ShowHideFields();
    }
    this._initAfterReload();
    this.StaticDataProviderB.FillExtData(cData.Fields, cData.Data);
  }

  this.TabStripB_Click = function(tabname) {
    var combo = document.getElementById(this.ChartB.ctrlid + '_ztchart_comboCursor');
    if( combo ) {
      var z, c
      for(z=0; z<combo.length; z++){
        c = combo[z];
        if( c.value == tabname ) {
          c.selected = true;
          combo.dispatchEvent(new Event('change'));
          z = combo.length;
        }
      }
    }
    this.CloseMenus();
  }

  this.ChartB_Rendered = function () {
    this.CloseMenus();
    //navbar tabs
    if( document.getElementById(this.ChartB.Ctrl.id + "_ztchart" + "_menuBar") )
      document.getElementById(this.ChartB.Ctrl.id + "_ztchart" + "_menuBar").style.display = 'none';
    var combo = document.getElementById(this.ChartB.ctrlid + '_ztchart_comboCursor');
    if( combo ) {
      combo.parentNode.style.display = 'none';
      var container = document.getElementById(this.ChartB.ctrlid + '_ztchart_divchartcontainer');
      var nav = document.getElementById(this.ChartB.ctrlid + '_chartTabsNavBar');

      var div;
      if( !nav ) {
          var mydiv = document.createElement('div');
          mydiv.setAttribute('id', this.ChartB.ctrlid + '_chartTabsNavBar');
          mydiv.style.width = this.ChartB.Ctrl.offsetWidth + 'px';
          mydiv.style.margin = '1px 0 0 0';
          nav = mydiv;
      }
      container.prepend(nav);
      nav.innerHTML = "";
      div = document.createElement("div");
      div.id = this.formid +'TabStripB';
      nav.appendChild(div);
      var js = {};
      js.name = 'TabStripB';
      js.ctrlid = this.formid +'TabStripB'
      js.x = 0;
      js.y = 0;
      js.width = 100;
      js.height = 24;
      var zt = new ZtVWeb.TabStripControl(this, js);
      zt.addToForm(this, zt)
      this[js.name] = zt;
      var z, c , selection;
      for(z=0; z<combo.length; z++){
        c = combo[z];
        zt.AddTab(c.value, c.text)
        if(c.selected) selection = c.value;
      }
      if( selection ) zt.Select(selection);
    }
  }

  this.GetCurrentPivot = function() {
    if(this.CurrentPage() == 1)
      return this.GridPivot;
    if(this.CurrentPage() == 2)
      return this.Chart;
    if(this.CurrentPage() == 3)
      return this.GridPivotB;
  }

  this.GetCurrentToolbar = function() {
    if(this.CurrentPage() == 1)
      return this.toolbar;
    if(this.CurrentPage() == 2)
      return this.toolbarA;
    if(this.CurrentPage() == 3)
      return this.toolbarB;
    return null;
  }

  this.GetCurrentBox = function() {
    if(this.CurrentPage() == 1)
      return this.BoxCollapse;
    if(this.CurrentPage() == 2)
      return this.BoxCollapseA;
    if(this.CurrentPage() == 3)
      return this.BoxCollapseB;
    return null;
  }

  this.GetCurrentLabel = function() {
    if(this.CurrentPage() == 1)
      return this.label;
    if(this.CurrentPage() == 2)
      return this.labelA;
    if(this.CurrentPage() == 3)
      return this.labelB;
  }

  this.GetCurrentMenu = function() {
    var cGridPivot = this.GetCurrentPivot();
    var ret = cGridPivot.GetMenuCtrl();
    if( ret && !this[ret.name + "_BeforeMenuOpen" ]) {
      this[ret.name + "_BeforeMenuOpen" ] = function() {
        this.refresh_menu.CloseMenu();
      }
    }
    return ret;
  }

  this.printZoom =function() { //da rivedere //todo chart
    this.CloseMenus();
    var GridPivotCtrl = this.GetCurrentPivot();
    var obj = this.__cfgObj;
    if( GridPivotCtrl != null && GridPivotCtrl.Print) {
      GridPivotCtrl.SetPrintMode(obj.configuration.PrintMode, obj.configuration.ReportName, obj.configuration.print_outputf, obj.configuration.print_option);
      GridPivotCtrl.SetPrintOptions(obj.configuration.print_model, obj.configuration.print_title, obj.configuration.print_hideexport,
        obj.configuration.print_hidesettings, obj.configuration.print_grep, obj.configuration.print_max);
        GridPivotCtrl.Print();
      }
  }

  this.refreshQuery = function() { //da rivedere  //todo chart
    var cGridPivot = this.GetCurrentPivot();
    if( cGridPivot.IsOpenUiDragDrop() ) cGridPivot.ShowHideFields();
    if( cGridPivot != null && cGridPivot.ztpivot )
      cGridPivot.ztpivot = null;
    reload = true;
    var _dataobj = this.GetCurrentDataObj();
    if( _dataobj.resetForNewQuery ) _dataobj.resetForNewQuery();
    _dataobj.Query();
  }

  this.ShowVdmMaskPrint=function(mywindow, iframeref){
    var params="&m_cDecoration=onlytitle";
    mywindow.windowOpenForeground(this.GetVdmUrl()+params, iframeref);
    this.$entity$_GetConfigurationField.Emit();
    this.$entity$_updateFilters.Emit();
  }

  this.ShowVdmMask = function() {
    var params="&closeWhenApplyFilter=true";
    var w = this.__cfgObj.configuration.vdmWidth ? (parseInt(this.__cfgObj.configuration.vdmWidth)) : 800;
    var h = this.__cfgObj.configuration.vdmWidth ? (parseInt(this.__cfgObj.configuration.vdmHeight)) : 600;
    layerOpenForeground(this.GetVdmUrl()+params,"filter","", w, h,null,1);
    this.$entity$_GetConfigurationField.Emit();
    this.$entity$_updateFilters.Emit();
 }

  this.GetVdmUrl = function() {
    var _dataobj = this.GetCurrentDataObj();
    var url="../jsp/SPMaskParameters_portlet.jsp?";
    if (!Empty(this.__cfgObj.configuration.vdmfile))
      url+= "ConfigName="+URLenc(this.__cfgObj.configuration.vdmfile);
    else
      url += "hideEditToolbar=true&QueryName="+URLenc(this.__cfgObj.configuration.query)+"&zoomConfigName="+URLenc(this.ConfigName.Value())+"&presetParams="+URLenc(_dataobj.parms)+"&hideQueryParameters=true"+"&disablePresetParams="+URLenc(this.__cfgObj.configuration.disablePresetParam);
    url= url + "&TitleMsg=MSG_SEARCH_FILTERS&offlineMode=false&zoomMode=true&hideAddFilterButton="+(!(CharToBool("" + this.__cfgObj.configuration.canFilter)))+"&ReceiverName="+URLenc(this.EmitterName.Value())+"&EmitterName="+URLenc(rcvNameGen)+"&"+this.QueryParmsFunc()+"&SPParentObjId="+URLenc(this.formid);
    return url;
 }

  this.this_PageLoaded = function (){
    if(window.waitForFooter){
      return;
    }
    this.SetReceivers();
    var _dataobj = this.GetCurrentDataObj();
    var linksFilters = this.GetSavedFilters(GetOpener(), this.pParent.Value());
    if( linksFilters ) {
      var queryparms = linksFilters.queryparams;
      if( queryparms ) {
        var keys = Object.keys(queryparms);
        var key, lp, v, i;
        if(!Empty(_dataobj.parms))
          lp = _dataobj.parms.split(',')
        else
          lp = [];
		  for( i=0; i<keys.length; i++ ) {
			key = keys[i]
			if(key.endsWith("__type")) continue;
			if(queryparms[key+"__type"] == 'DT') {
			  v = ZtVWeb.strToValue(queryparms[key], 'T')
			  if( this[key] ) this[key].Value (v)
			  else this[key] = new this.Var(v);
			}
			else {
			  if( this[key] ) this[key].Value (queryparms[key])
			  else this[key] = new this.Var(queryparms[key]);
			}
			if ( lp.indexOf(key)<0 ) lp.push(key);
		  }
        var newp = lp.join();
        //_dataobj.parms = newp;
        this.dataobj.parms = newp;
        this.mDataobj.parms = newp;
      }
    }
    _loadFixedFilters = null;
    if( linksFilters ) {
      _loadFixedFilters = linksFilters.fixedFilters
    }
    this.startVPV();
    this.SearchZoomTitle();
    this.vpv_Load();
    this.SetZoomTitle();
    this.SetToolbarBox();
  }

  this.vpv_Load = function () {
    //console.log(this.__cfgObj)
    viewHeaderFromConfig=(typeof(this.__cfgObj.configuration.header)=='undefined' || this.__cfgObj.configuration.header=='true');
    viewToolbarFromConfig=(this.__cfgObj.configuration.header=='toolbar');
    _saveConfig = false;
    this.SetCaption();
    this.manageToolbarBase();
    this.manageActionsBtns();
    this.manageLinkedConfsBtns();
  }

  this.manageToolbarBase = function () {
    var toolbar=this.GetCurrentToolbar(),label=this.GetCurrentLabel(),i;
    //var cGrid = this.GetCurrentPivot();
    if (!viewHeaderFromConfig && viewToolbarFromConfig && toolbar && !securityOpts.hideSmallToolbar) {
      toolbar.Show();
      label.Ctrl.style.right='';
      label.minheight=10;
      label.shrinkable='false';
      toolbar.getRenderHeight=null;
      if (!SPTheme.portalZoomVersionItemOnLabel) {
        toolbar.Append({
          id: 'versions_itm',
          title: FormatMsg('MSG_VERSIONS'),
          tooltip: FormatMsg('MSG_VERSIONS'),
          image: SPTheme.portalZoomVersionsImage||'',
          action: function(evt) {
            this.OpenMenu(GetEventSrcElement(evt));
          },
          target: this.menu_versioni
        },null,"versions");
        this.GetVersionsImage()
      } else {
       toolbar.Remove("versions");
      }
      var itms = toolbar.GetItems();
      for (i=0;i<itms.length;i++)
        if (itms[i].id.search(/linkedConf_\d+/)==0)
          toolbar.Remove(itms[i].id);

      var linkedConfs = this.__cfgObj.linkedConfs;
      if (linkedConfs && linkedConfs.length>0) {
        var img,lConfAct,ii;
        for (ii=0; ii<linkedConfs.length; ii++) {
          if (linkedConfs[ii].image_settings=='fontIcon'){
            img = {
              fontFamily:linkedConfs[ii].font_name,
              size:linkedConfs[ii].font_size,
              value:linkedConfs[ii].font_image,
              color:linkedConfs[ii].font_color
            }
          }
          else if (!Empty(linkedConfs[ii].imagetoolbar) ) {
            img = linkedConfs[ii].imagetoolbar;
          } else if (linkedConfs[ii].imagetype=='card') {
            img = GetStyleVariable("card_image", "../"+ZtVWeb.theme+"/images/zoom/linkedConf_card.png");
          } else if (linkedConfs[ii].imagetype=='chart') {
            img = GetStyleVariable("chart_image", "../"+ZtVWeb.theme+"/images/zoom/linkedConf_chart.png");
          } else {
            img = GetStyleVariable("grid_image", "../"+ZtVWeb.theme+"/images/zoom/linkedConf_grid.png");
          }
          lConfAct={
            id : 'linkedConf_'+ii
          , title : linkedConfs[ii].title_trad || linkedConfs[ii].title
          , tooltip : linkedConfs[ii].title_trad || linkedConfs[ii].title
          , image: img||''
          , action : 'javascript:'+this.formid+'.ChangeConfiguration('+(ii)+')'
          }
          toolbar.Append(lConfAct,ii+(this.autozoomCanAdd && !EmptyString(this.Grid.splinker)?1:0));
        }
      }

      if ((CharToBool("" + this.__cfgObj.configuration.canFilter) || !Empty(this.__cfgObj.configuration.vdmfile)) && !(CharToBool("" + this.__cfgObj.configuration.hideFiltersBtn))){
        var o = {fontFamily:'icons8_win10', value: "&#xee44", size: "20px"};
        if( this.hasFilters) o = {fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"};
        var vdmAct={
          id: 'showVdm',
          title: FormatMsg('MSG_FILTERS'),
          tooltip: FormatMsg('MSG_FILTERS'),
          image: o,
          action: 'javascript:'+this.formid+'.ShowVdmMask();'
        }
        if (!Empty(this.__cfgObj.configuration.vdmfile))
          toolbar.Append(vdmAct);
        else
          toolbar.AppendMenuItem(vdmAct);
      }
      if ( !securityOpts.hidePrintButton && this.printModeSecurity) { //canPrint
        if ( (typeof(this.__cfgObj.configuration.PrintMode)=='undefined' || this.__cfgObj.configuration.PrintMode!='None') ) {
          toolbar.Append({
            id: 'print_itm',
            title: FormatMsg('MSG_VZM_PRINT'),
            tooltip: FormatMsg('MSG_VZM_PRINT'),
            image: SPTheme.portalZoomPrintImage||'',
            action: 'javascript:'+this.formid+'.printZoom();'
          });
          //this.Grid.print_result=true;  //wip
        } else {
          toolbar.Remove('print_itm');
          //this.Grid.print_result=false;
        }

      }
      if( !securityOpts.hidePrintButton && this.printModeSecurity && this.__cfgObj.configuration.exportPivot && !(this.__cfgObj.configuration.viewmode == 'chart')){
        this.toolbar.Append({
          id:'exportPivot',
          title: FormatMsg('MSG_XLSX_PIVOT'),
          action:function(){ _this.SubmitListenerForm('exportPivot')},
          image:{ fontFamily:'icons8_win10', value: "&#xf51b", size: "20px"}
        });
      } else {
        this.toolbar.Remove('exportPivot');
      }

      if( !securityOpts.hidePrintButton && this.printModeSecurity && this.__cfgObj.configuration.exportTable){
        this.toolbar.Append({
          id:'exportTable',
          title: FormatMsg('MSG_XLSX_TABLE'),
          action:function(){ _this.SubmitListenerForm('exportTable')},
          image:{ fontFamily:'icons8_win10', value: "&#Xf51b", size: "20px"}
        });
        //lprint = 'exportTable'
      } else {
        this.toolbar.Remove('exportTable');
      }

      toolbar.AppendMenuItem({
          id: 'refresh_itm',
          title: FormatMsg('MSG_FORM_FUNCTION_REFRESH'),
          tooltip: FormatMsg('MSG_FORM_FUNCTION_REFRESH'),
          image: SPTheme.portalZoomRefreshImage||'',
          action: 'javascript:'+this.formid+'.refreshQuery();'
      });

      var ui = (this.__cfgObj.configuration.uiDragDrop === 'true');
      if(!ui){
        //nascosti
        toolbar.Remove('expandreduce');
      }else{
        var isextended = this.IsOpenUiDragDrop();
        if (toolbar.IsInToolbar('expandreduce') || toolbar.IsInMenu('expandreduce'))
          toolbar.UpdateItem('expandreduce', {
              title: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
              tooltip: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
              image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
              (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
          });
        else {
          var act={
            id:'expandreduce',
            title: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
            tooltip: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
            action:function() {
              _this.ShowHideFields();
            },
            image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
              (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
          }
          if (!Empty(this.vdmName)){
            if (!toolbar.AppendAfter(act,'showVdm') && !toolbar.AppendBefore(act,'print_itm') && !toolbar.AppendBefore(act,'refresh_itm'))
              toolbar.Append(act);
          }
          else { // bottone di showVdm nel menu
            if (!toolbar.AppendBefore(act,'print_itm') && !toolbar.AppendBefore(act,'refresh_itm') && !toolbar.AppendBefore(act,'showVdm'))
              toolbar.Append(act);
          }
        }
      }
    }
     else {
      if (toolbar) {
        toolbar.Hide();
      }
      label.minheight=10;
      label.Ctrl.style.right='0px';
      label.shrinkable='true';
    }
  }

  this.manageActionsBtns = function () {
    var actions = this.__cfgObj.actions;
    var defaultActions=[],
    toolbar=this.GetCurrentToolbar(), i, ii;
    this.hamburgerActions=[];
    for (i=0;actions!=null && i<actions.length; i++) {
      if (actions[i].visibility!='none')
        defaultActions.push(actions[i]);
      if (actions[i].showInMenu=='true')
        this.hamburgerActions.push(actions[i]);
    }

    if (viewHeaderFromConfig && this.hasZoomtitlesID('SetActions')) {
      this.getZoomtitlesRefsByProperty('SetActions', function(portlet){
        portlet.SetActions(defaultActions);
      }, this);
    }
    else if (viewToolbarFromConfig && toolbar) {  // small zoom with actions
        ii=0;
        while( toolbar.Remove( 'action' + ii ) ) {
          ii++;
        }
        for (i=0;i<defaultActions.length; i++) {
          var action={
            id:'action'+i,
            title: defaultActions[i].title_trad || defaultActions[i].title,
            image: defaultActions[i].image_settings=='fontIcon'?{
              fontFamily:defaultActions[i].font_name,
              size:defaultActions[i].font_size,
              value:defaultActions[i].font_image,
              color:defaultActions[i].font_color
            }:defaultActions[i].image,
            tooltip : defaultActions[i].tooltip || defaultActions[i].title_trad || defaultActions[i].title,
            action: (function(ZoomObj,_action){
                    return function(evt) {
                      ZoomObj.ExecAction(_action,evt);
                    }
                    })(this,defaultActions[i]),
            target: ''
          }
          if (CharToBool(defaultActions[i].important)){
            if (!Empty(this.__cfgObj.configuration.vdmfile)){ // il bottone dei filtri nella toolbar prima del bottone di espandi riduci
              if (!toolbar.AppendBefore(action,'showVdm') && !toolbar.AppendBefore(action,'print_itm') && !toolbar.AppendBefore(action,'refresh_itm'))
                toolbar.Append(action);
            }
            else if (!toolbar.AppendBefore(action,'print_itm') && !toolbar.AppendBefore(action,'refresh_itm') && !toolbar.AppendBefore(action,'showVdm')) // il bottone dei filtri nel menu
                toolbar.Append(action);
          }
          else
            toolbar.AppendMenuItem(action);
        }
    }
  }

  this.manageLinkedConfsBtns = function () {
    var linkedConfs = this.__cfgObj.linkedConfs,
      toolbar = this.GetCurrentToolbar();
    if (viewHeaderFromConfig) { //se da configurazione stabilisco che non si vede il titolo faccio finta che non ci sia
      this.getZoomtitlesRefsByProperty('SetLinkedConfs', function (portlet) {
        portlet.SetLinkedConfs(this.__cfgObj.linkedConfs);
      }, this);
    }
    else {
      var img, lConfAct, ii;
      ii = 0;
      while (toolbar.Remove('linkedConf_' + ii)) {
        ii++;
      }
      for (ii = 0; ii < linkedConfs.length; ii++) {
        if (linkedConfs[ii].image_settings == 'fontIcon') {
          img = {
            fontFamily: linkedConfs[ii].font_name,
            size: linkedConfs[ii].font_size,
            value: linkedConfs[ii].font_image,
            color: linkedConfs[ii].font_color
          }
        }
        else if (!Empty(linkedConfs[ii].imagetoolbar)) {
          img = linkedConfs[ii].imagetoolbar;
        }
        else if (linkedConfs[ii].imagetype == 'chart') {
          img = GetStyleVariable("chart_image", "../" + ZtVWeb.theme + "/images/zoom/linkedConf_chart.png");
        }
        else {
          img = GetStyleVariable("grid_image", "../" + ZtVWeb.theme + "/images/zoom/linkedConf_grid.png");
        }
        lConfAct = {
          id: 'linkedConf_' + ii
          , title: linkedConfs[ii].title_trad || linkedConfs[ii].title
          , tooltip: linkedConfs[ii].title_trad || linkedConfs[ii].title
          , image: img || ''
          , action: 'javascript:' + this.formid + '.ChangeConfiguration(' + (ii) + ')'
        }
        toolbar.Append(lConfAct, ii + (/*this.autozoomCanAdd*/1/*:0*/));
      }
    }
  }

  this.ExecAction=function(action,evt){
    if (typeof(action)=="string"){
      if (LibJavascript.JSONUtils.IsJsonString(action))
        action=JSON.parse(action);
      else { //presumo di aver passato il nome
        var i;
        for( i=0; i<this.__cfgObj.actions.length; i++ ) {
          if( this.__cfgObj.actions[i].actionName == action ) {
            action = this.__cfgObj.actions[i];
            i = this.__cfgObj.actions.length;
          }
        }
      }
    }
    if (Empty(action.confirmMessage_trad) || confirm(action.confirmMessage_trad)){
      this.CloseMenus();
      action.popup_style=action.popup_style||'by skin';
      if (action.url.indexOf('javascript:')===0)
        action.entityType='function';
      else if (action.entityType=='function')
        action.url='javascript:'+action.url;
      var dataobj=this.GetCurrentDataObj();
      if (action.entityType=='routine' && this.action_splinker){
        this.action_splinker.Servlet(action.url);
        var parameters='', parm='';
        /* da valutare - wip
        if (CharToBool(action.sendMemCurs)){
          this.mcParam=new this.Var(this.Grid.GetSelectedDataAsTrsString());
          parameters+=(action.memCursParam||'memorycursor')+'=mcParam,'
          parameters+=(action.checkAllParam||'checkAll')+'='+this.Grid.AllChecked()+','
        }*/
        this.qfParam=new this.Var(dataobj.queryfilter)
        parameters+=(action.queryFilterParam||'queryFilter')+'=qfParam,';
        parm=_this.QueryParmsFunc(',');
        parameters+=parm?parm:'';
        parameters+=','+ZtVWeb.fmtPctFldPct(action.parameter, dataobj.curRec-1, dataobj, null, this, false, true);
        parameters+=',m_bApplet=true';
        this.action_splinker.Parameters(parameters);
        if (action.progressBar=='true'){
          this.action_splinker.progressbar=true;
          this.action_splinker.Action('async routine');
          this.action_splinker.target='';
          this.action_splinker.popup='false';
          if (!Empty(action.progressBarPortlet))
            this.action_splinker.setProgressBarPortlet(action.progressBarPortlet);
          else
            this.action_splinker.setProgressBarPortlet('../jsp/SPSplinkerProgressBar_portlet.jsp');
        }
        else {
          this.action_splinker.progressbar=false;
          this.action_splinker.Action('');
          if (CharToBool(action.popup)){
            this.action_splinker.target=action.target;
            this.action_splinker.popup='true';
            this.action_splinker.popup_style=action.popup_style;
            this.action_splinker.popup_maximized=action.popup_maximized;
            this.action_splinker.popup_height=action.popup_height;
            this.action_splinker.popup_width=action.popup_width;
            this.action_splinker.showMsgOverlay=false;
          } else {
            this.action_splinker.popup='false';
            this.action_splinker.target='';
            this.action_splinker.showMsgOverlay=true;
          }
        }
        if (action.doQryAfterRoutine=='true'){
          if (action.progressBar=='true') {
            this.action_splinker_ProgressBarFinished=function() {
              if( dataobj.resetForNewQuery ) dataobj.resetForNewQuery();
              dataobj.Query();
            };
          }
          else {
            this.action_splinker_Response=function(resp){
              var bj=new BatchJavascript();
              bj.GetFromResponse(resp);
              if (bj.errmsg)
                alert(bj.errmsg)
              else {
                if( dataobj.resetForNewQuery ) dataobj.resetForNewQuery();
                dataobj.Query();
              }
            };
          }
        } else {
          this.action_splinker_Response=this.action_splinker_ProgressBarFinished=null;
        }
        this.action_splinker.Link();
      }
      else if (action.entityType=='function'){
        var rg=new RegExp(/javascript:([A-Za-z0-9_]+) *\(/);
        var match=action.url.match(rg);
        if (match && match[1])
          LibJavascript.IncludeFunction('SPVisualPivot',match[1],false);
        var clickFunc= ZtVWeb.makeStdLink(action.url,dataobj.curRec-1,dataobj,null,this,true);
        clickFunc=Strtran(clickFunc,'javascript:','');
        var actionFunc=new Function('evt', 'eval("{' + Strtran(clickFunc,'"','\\"') + '}");');
        actionFunc(evt);
        if (action.doQryAfterRoutine=='true'){
          if( dataobj.resetForNewQuery ) dataobj.resetForNewQuery();
          dataobj.Query();
        }
      }
      else if (action.target=='_self'){
        var a = document.createElement('a');
        var url = action.url;
        document.body.appendChild(a);
        a.href = ZtVWeb.makeStdLink(url,dataobj.curRec-1,dataobj,null,this,true);
        a.click();
        document.body.removeChild(a);
      }
      else {
        var rurl = action.url;
        var links=ZtVWeb.makeStdLink(rurl,dataobj.curRec-1,dataobj,null,this,true);
        var dim='',sep='';
        if (action.popup_height){
          dim+='height='+action.popup_height;
          sep=','
        }
        if (action.popup_width)
          dim+=sep+'width='+action.popup_width;
        if (action.popup_style=='layer' || (action.popup_style=='by skin' && window.SPTheme.activateModalPopup)) {
          window.layerOpenForeground.call(null, {
            url:links,
            name:''+new Date().getTime(),
            args:dim,
            maximized:action.popup_maximized
          });
        } else {
          var opts = dim ? ',' + dim : '';
          if (links.indexOf('/servlet/') > -1 || links.indexOf('_portlet.jsp') > -1) {
            opts += ',status=no,toolbar=no,menubar=no,location=no';
          }
          window.open(links, '_blank', 'scrollbars=yes,resizable=yes' + opts);
        }
      }
    }
  }

  this.ChangeConfiguration = function (i) {
    this.LinkedConfiguration(this.__cfgObj.linkedConfs[i].configname);
  }

  this.LinkedConfiguration = function (newcfg, forceLoad) {
    var i;
    if (this.menu_versioni)
      this.menu_versioni.CloseMenu();

    var type = '';
    for( i=0; i<this.__cfgObj.linkedConfs.length; i++) {
      if( this.__cfgObj.linkedConfs[i].configname == newcfg) {
          type = this.__cfgObj.linkedConfs[i].configtype
          i = this.__cfgObj.linkedConfs.length;
      }
    }

    if( type == 'zoom') {
      try {
        localStorage.setItem(_this.formid, JSON.stringify(this.RetrieveFilters()));
        var a = document.createElement('a');
        var table = '', configName = '';
        var sp = newcfg.split(".");
        configName = sp[0];
        table = sp[1].substr(0, sp[1].lastIndexOf('_vzm'))
        var url = '../jsp/SPPortalZoom.jsp?Table=';
        url += table;
        url += '&ConfigName=';
        url += configName;
        document.body.appendChild(a);
        if( url.indexOf('?') > 0 ) {
          url+='&pParent='+_this.formid;
        }
        else {
          url+='?pParent='+_this.formid;
        }
        var _dataobj = this.GetCurrentDataObj();
        a.href = ZtVWeb.makeStdLink(url,_dataobj.curRec-1,this.dataobj,null,this,true);
        a.click();
        document.body.removeChild(a);
      }
      catch(e) {
        alert('Error on changing configuration');
        console.log(e)
      }
      return;
    }

   /* var filters=[],_filters = this.GetCurrentPivot().Filters;
    for (i=0; i<_filters.length; i++){
        f = JSON.parse(JSON.stringify(_filters[i]));
        if(!f.fixed) f.userFilter = true;
        filters.push(f);
    }

    function setFiltersAndOrderby() {
      var i;
      var cGrid = this.GetCurrentPivot();
      if (!Empty(filters)){
        if (Empty(cGrid.Filters))
          cGrid.Filters = filters;
        else {
          for (i=0; i<filters.length; i++){
            cGrid.AddFilter(
              cGrid.MakeFilter(filters[i].field,filters[i].operator,filters[i].expression,
                filters[i].type,filters[i].fixed, filters[i].userFilter,filters[i].defaultFilter
              ), filters[i].visible
            );
          }
        }
      }
      cGrid.IDFilterSeed=filters.length;
    }*/
    this.LoadConfiguration(newcfg, true, null, forceLoad);
  }

  this.RetrieveFilters = function() {
    var _dataobj = this.GetCurrentDataObj();
    _dataobj.ParseParameters();
    var filters=[],_filters = this.GetCurrentPivot().Filters;
    var i, f;
    for (i=0; i<_filters.length; i++){
        f = JSON.parse(JSON.stringify(_filters[i]));
        if(!CharToBool(f.fixed)+"") f.userFilter = true;
        filters.push(f);
    }
    var sp = _dataobj.parms.split(','), s, qp={};
    for( i = 0; i<sp.length; i++ ) {
      s = sp[i];
      if(!Empty(s)) {
		if( this[s] ) {
			if( this[s].Value() instanceof Date) {
			 qp[s+"__type"] = 'DT'
			 qp[s] = FormatDateTime(this[s].Value(),'YYYY-MM-DD hh:mm:ss');
			}
			else {
			 qp[s] = this[s].Value();
			}
		}
     }
    }
    var o = {};
    o.fixedFilters = filters;
    o.queryparams = qp;
    return o;
  }

  this.GetSavedFilters = function( opener, uid ) {
    if(Empty(uid))
      return;
    var u = localStorage.getItem(uid)
    if(u ) {
      var o=null;
      try {
        o = JSON.parse(u);
      }
      catch(e) {}
      //localStorage.removeItem(uid) //per permettere ricarica iframe
      return o;
    }
    if( !opener)
      return null;
    if(!opener[uid] || !opener[uid].RetrieveFilters)
      return null;
    return opener[uid].RetrieveFilters();
  }

  this.Config = function () {
    var cnf = {}
    cnf.ConfigName = this.ConfigName.Value();
    cnf.User = parseInt("0"+this.__cfgObj.configuration.user, 10);
    cnf.Group = parseInt("0"+this.__cfgObj.configuration.group, 10);
    cnf.Custom = CharToBool(this.__cfgObj.configuration.custom);
    if(cnf.User > 0 ) {
      cnf.ConfigName += "_"+cnf.User
    }
    else if( cnf.Group > 0 ) {
      cnf.ConfigName += "_g"+cnf.Group
    }
    return cnf;
  }

  this.GetReload = function () {
    return reload;
  }

  this.LoadConfiguration = function (newcfg, keepFltrOrderby, callbackBeforeQuery, forceLoad) {
    if (this.ConfigName.Value() == newcfg && !forceLoad) {
      //se ricarico la stessa configurazione non faccio nulla
      return;
    }
    var _dataobj = this.GetCurrentDataObj();
    this.CloseMenus();
    this.ConfigName.Value(newcfg);
    this._resetCtrl();
    reload = true;
    this.GridPivot.SetDataProvider(null);
    this.GridPivotB.SetDataProvider(null);
    this.Chart.SetDataProvider(null);

    _dataobj.rowsconsumers = [];
    _listData = [];

    _dataobj.ParseParameters();

    this.startVPV();
    this.SearchZoomTitle();

    if (typeof (callbackBeforeQuery)=='function') {
      callbackBeforeQuery.call(this);
    }

    this.vpv_Load();
    this.SetZoomTitle();
    this.SetToolbarBox();
    this.$entity$_updateConfiguration.Emit();
  }

  this._resetCtrl = function () {
    this.GridPivot._resetCtrl();
    this.GridPivotB._resetCtrl();
    // chart
  }

  this.GridPivot_UIDragDrop = function() {
    if (this.configModeSecurity>0 ) {
      _saveConfig = true;
      if (viewHeaderFromConfig && this.hasZoomtitlesID('SetSaveConfig')) {
        this.getZoomtitlesRefsByProperty('SetSaveConfig', function(portlet){
          portlet.SetSaveConfig();
        }, this);
      }
      else {
        var toolbar = this.GetCurrentToolbar();
        if( toolbar ) {
          if( !toolbar.IsInToolbar('save') && !toolbar.IsInMenu('save') ) {
            toolbar.Append({
            id:'save',
            title: FormatMsg('PIVOT_SAVE_CONFIG'),
            tooltip: FormatMsg('PIVOT_SAVE_CONFIG'),
            action:function(){ _this.SaveVersion()},
            image:{ fontFamily:'icons8_win10', value: "&#xecb3", size: "20px"}
            },0)
          }
        }
      }
    }
    this.CloseMenus();
  }

  this.GridPivotB_UIDragDrop = function() {
    this.GridPivot_UIDragDrop();
  }

  this.Chart_UIDragDrop = function() {
    this.GridPivot_UIDragDrop();
  }

  this.SaveVersion = function() {
    this.InnerFormId.Value(this.formid)
    this.custom.Value(this.__cfgObj.configuration.custom)
    this.versionName.Value(this.GetCurrentVersion());
    if( this.__cfgObj.configuration.user_group == 'User' )
      this.userCode.Value(this.__cfgObj.configuration.user);
    else if( this.__cfgObj.configuration.user_group == 'Group' )
      this.groupCode.Value(this.__cfgObj.configuration.group);
    this.SPLinkPivotVersion.Link()
  }

  this.SaveConfigVersion = function(versionName, custom, usableBy, userCode, groupCode) {

      function retrieveOthDimensions (pivotObj) {
        var ret = {};
        ret.odimensions = [];
        ret.omeasures = [];
        var rows = [];
        var columns = [];
        var measures = [];
        var odimensions = [];
        var omeasures = [];
        var idimensions = [];
        var imeasures = [];
        var i, alias;
        for(i=0; i<pivotObj.opts.rows.length; i++)
          rows.push(pivotObj.opts.rows[i].alias);
        for(i=0; i<pivotObj.opts.columns.length; i++)
          columns.push(pivotObj.opts.columns[i].alias);
        for(i=0; i<pivotObj.opts.measures.length; i++)
          measures.push(pivotObj.opts.measures[i].alias);
        for(i=0; i<pivotObj._initOpts.rows.length; i++)
          idimensions.push(pivotObj._initOpts.rows[i].alias);
        for(i=0; i<pivotObj._initOpts.columns.length; i++)
          idimensions.push(pivotObj._initOpts.columns[i].alias);
        for(i=0; i<pivotObj._initOpts.measures.length; i++)
          imeasures.push(pivotObj._initOpts.measures[i].alias);
        for(i=0; i<pivotObj._initOpts.omeasures.length; i++)
          omeasures.push(pivotObj._initOpts.omeasures[i].alias);
        for(i=0; i<pivotObj._initOpts.odimensions.length; i++)
          odimensions.push(pivotObj._initOpts.odimensions[i].alias);
        var _copy;
        var _dobj = _this._copyObj;
        for( i=0; i<pivotObj.opts.fields.length; i++ ) {
          alias = pivotObj.opts.fields[i].alias;
          if( rows.indexOf(alias) >= 0) continue;
          if( columns.indexOf(alias) >= 0) continue;
          if( measures.indexOf(alias) >= 0) continue;
          if( idimensions.indexOf(alias) >= 0) {
            _copy = JSON.parse(JSON.stringify(pivotObj.opts.fields[i]));
            if( _dobj.Fields_map[alias] != undefined ) _copy.alias = _dobj.Fields_Case[_dobj.Fields_map[alias]];
            ret.odimensions.push(_copy);
          }
          else if( odimensions.indexOf(alias) >= 0) {
            _copy = JSON.parse(JSON.stringify(pivotObj.opts.fields[i]));
            if( _dobj.Fields_map[alias] != undefined ) _copy.alias = _dobj.Fields_Case[_dobj.Fields_map[alias]];
            ret.odimensions.push(_copy);
          }
          else if( imeasures.indexOf(alias) >= 0) {
            _copy = JSON.parse(JSON.stringify(pivotObj.opts.fields[i]));
            if( _dobj.Fields_map[alias] != undefined ) _copy.alias = _dobj.Fields_Case[_dobj.Fields_map[alias]];
            ret.omeasures.push(_copy);
          }
          else if( omeasures.indexOf(alias) >= 0) {
            _copy = JSON.parse(JSON.stringify(pivotObj.opts.fields[i]));
            if( _dobj.Fields_map[alias] != undefined ) _copy.alias = _dobj.Fields_Case[_dobj.Fields_map[alias]];
            ret.omeasures.push(_copy);
          }
        }
        return ret;
      }

      function _convertFields( arL ) {
        var j, o, a;
        var ret = [];
        for( j=0; j<arL.length; j++ ) {
          a = arL[j];
          o = {};
          o.field = a.alias;
          o.descrs = a.desc;
          o.keys = a.key;
          o.pictures = a.pictureFnc;
          o.sorts = a.orderby;
          o.sortsfields = a.orderfield;
          if( _this['myObj_'+ o.field] && _this['myObj_'+ o.field].condformats)
            o.condformats =  _this['myObj_'+ o.field].condformats;
          ret.push(o);
        }
        return ret;
      }

    var pv = this.GetCurrentPivot();
    var iPivot = pv._GetInnerPivotObj();
    if( iPivot ) {
      var bconfig = this.GetCurrentCfgName();
      var cconfig;
      versionName=Strtran(Trim(versionName),' ','');
      if (versionName=='default'){
        cconfig=bconfig;
      }
      else {
        cconfig=bconfig+"__"+versionName;
      }
      var _copy = JSON.parse(JSON.stringify(this.__cfgObj));
      _copy.rows = [];
      _copy.measures = [];
      _copy.cols = [];

      _copy.omeasures = [];
      _copy.odimensions = [];

      var i, j, alias, obj, f;
      for( i=0; i<iPivot.opts.rows.length; i++ ) {
        alias = iPivot.opts.rows[i].alias;
        f = false;
        for( j=0; j<this.__cfgObj.rows.length; j++ ) {
          obj = this.__cfgObj.rows[j];
          if( obj.field.toLowerCase() == alias.toLowerCase() ) {
            _copy.rows.push(this.__cfgObj.rows[j]);
            j = this.__cfgObj.rows;
            f = true;
          }
        }
        if( !f ) {
          for( j=0; j<this.__cfgObj.cols.length; j++ ) {
            obj = this.__cfgObj.cols[j];
            if( obj.field.toLowerCase() == alias.toLowerCase() ) {
              _copy.rows.push(this.__cfgObj.cols[j]);
              j = this.__cfgObj.cols;
              f = true;
            }
          }
        }
      }
      for( i=0; i<iPivot.opts.columns.length; i++ ) {
        alias = iPivot.opts.columns[i].alias;
        f = false;
        for( j=0; j<this.__cfgObj.rows.length; j++ ) {
          obj = this.__cfgObj.rows[j];
          if( obj.field.toLowerCase() == alias.toLowerCase() ) {
            _copy.cols.push(this.__cfgObj.rows[j]);
            j = this.__cfgObj.rows;
            f = true;
          }
        }
        if( !f ) {
          for( j=0; j<this.__cfgObj.cols.length; j++ ) {
            obj = this.__cfgObj.cols[j];
            if( obj.field.toLowerCase() == alias.toLowerCase() ) {
              _copy.cols.push(this.__cfgObj.cols[j]);
              j = this.__cfgObj.cols;
              f = true;
            }
          }
        }
      }
      for( i=0; i<iPivot.opts.measures.length; i++ ) {
        alias = iPivot.opts.measures[i].alias;
        f = false;
        for( j=0; j<this.__cfgObj.measures.length; j++ ) {
          obj = this.__cfgObj.measures[j];
          if( obj.field.toLowerCase() == alias.toLowerCase() ) {
            _copy.measures.push(this.__cfgObj.measures[j]);
            j = this.__cfgObj.measures;
            f = true;
          }
        }
      }

      var od = retrieveOthDimensions(iPivot);

      if( (this.__cfgObj.configuration.othDimMeas+"") == 'true' ) {
        if((this.__cfgObj.omeasures.length > 0) || (this.__cfgObj.odimensions.length > 0)) {
          _copy.odimensions = _convertFields(od.odimensions);
          _copy.omeasures = _convertFields(od.omeasures);
        }
      }
      else {
        _copy.configuration.othDimMeas = 'true';
        _copy.odimensions = _convertFields(od.odimensions);
        _copy.omeasures = _convertFields(od.omeasures);
      }

      var customizationParms = "&Custom="+( custom ? custom : 'false');
      if (usableBy=='user')
        customizationParms +=  "&NewUser=" + userCode;
      else if (usableBy=='group')
        customizationParms +=  "&NewGroup=" + groupCode;

      var offlinemode = false;
      var url = new JSURL("../servlet/SPVPVProxy?m_cAction=save"+
        "&ConfigName="+cconfig+
        "&vqr="+URLenc(_copy.configuration.query)+
        "&obj="+ URLenc(JSON.stringify(_copy)) +
        "&offlinemode="+URLenc(offlinemode) + customizationParms+
        "&fromFullEditor=false" +
        "&m_cID=" + this.savinghashparameter
        ,true);
      var output=url.Response();
      try {
        if( !Empty(output) ) {
          output = JSON.parse(output);
        }
        else {
          output = {};
          output.OK= true;
        }
        this.ConfigName.Value(cconfig)
        if ( !this.__cfgObj.configuration.Versions ) this.__cfgObj.configuration.Versions = [];
        if(( versionName != 'default' ) && (this.__cfgObj.configuration.Versions.indexOf(versionName) <0 )) this.__cfgObj.configuration.Versions.push(versionName)
        this._UpdateVersionsSubMenu(this.menu_versioni)
        if( this.GetCurrentMenu() )this._UpdateVersionsSubMenu(this.GetCurrentMenu())
        this.SetZoomTitle();
      }
      catch (e) {
        output.ERROR=true;
        output.MESSAGE='Error on save';
      }
    }
  }

  //menu version
  this.GetVersionsImage=function() {
    if (this.menu_versioni) {
      var versionColumn = this.menu_versioni.GetItem("versioni");
      if (
        !ZtVWeb.IsMobile() &&
        this.configModeSecurity>0 || (
          this.__cfgObj &&
          this.__cfgObj.configuration &&
          this.__cfgObj.configuration.Versions &&
          this.__cfgObj.configuration.Versions.length>0
        )
      ) {
        if (!versionColumn) {
          this.menu_versioni.Append({
            id: 'versioni'
          },null,1);
        } else {
          this.menu_versioni.Clean('versioni');
        }
        if (this.configModeSecurity>0 && !ZtVWeb.IsMobile()){
          /*this.menu_versioni.Append({
            id : 'smarteditor'
          , title : this.Grid.Translations['Edit_Version']||'Modifica versione'
          , tooltip : this.Grid.Translations['Edit_Version']||'Modifica versione'
          , image : SPTheme.portalZoomVersionsImage||''
          , action : 'javascript:' + this.formid+".OpenSmartEditor()"
          },'versioni',0);*/
          if (this.configModeSecurity==2) {
            this.menu_versioni.Append({
              id : 'visualpivoteditor'
            , title : FormatMsg('MSG_FULL_EDITOR')
            , tooltip : FormatMsg('MSG_FULL_EDITOR')
            , image : SPTheme.portalZoomEditorImage||''
            , action : 'javascript:' + this.formid+".OpenEditor()"
            },'versioni',1);
          }
        }
        this._UpdateVersionsSubMenu(this.menu_versioni);
        var lbl = SPTheme.portalZoomVersionList||'../visualweb/images/zoom_versions_list.png';
        return lbl;
      } else if (versionColumn) {
        this.menu_versioni.Remove('versioni');
      }
      return "";
    } else {
      return "";
    }

  }

    this.GetVersionsLabel=function() {
      // var version='';
      var frag = document.createDocumentFragment();
      if (this.menu_versioni) {
        var img = this.GetVersionsImage();
        if (typeof(img)=='string' && img!='') {
          if (SPTheme.portalZoomVersionItemOnLabel) {
            var lblVersion = Strtran(this.GetCurrentVersion(), '_', ' ');
            var span2 = document.createElement("span");
            span2.className = "SPPortalZoom_currentversion";
            span2.innerText = (lblVersion == 'default' ? '' : lblVersion);
            frag.appendChild(span2);
            // version = '<span class="SPPortalZoom_currentversion">' + (lblVersion=='default'?'':lblVersion) + '</span>' + version;
          }
          /** Formato JSON */
          if (Left(img,1)=='{' && Right(img,1)=='}') {
            img = JSON.parse(img);
            //lo stile tutto nel css generato
            var span = document.createElement("span");
            span.className = "SPPortalZoom_versionhandler";
            frag.appendChild(span);
            LibJavascript.Events.addEvent(span, "click", function(e){e.stopPropagation();this.menu_versioni.OpenMenu(span);}.bind(this));
            span.innerText = String.fromCharCode(img.Char);
            // version = "<span class='SPPortalZoom_versionhandler' onclick='"+this.formid+".menu_versioni.OpenMenu(this);event.stopPropagation();' onselectstart='return false;'>"+String.fromCharCode(img.Char)+"</span>";
          } else {
            var image = document.createElement("img");
            image.className = "SPPortalZoom_versionhandlerimage";
            image.src = img;
            LibJavascript.Events.addEvent(image, "click", function(e){e.stopPropagation();this.menu_versioni.OpenMenu(image);}.bind(this));
            frag.appendChild(image);
            // version = " <img class='SPPortalZoom_versionhandlerimage' style='cursor:pointer;' src='"+img+"' onclick='"+this.formid+".menu_versioni.OpenMenu(this)' onselectstart='return false;'></img>";
          }

        }
      }
      return frag;
    }

    this.ChangeVersion=function(i,forceLoad) {
      var vers = (i>-1 ? this.__cfgObj.configuration.Versions[i] : "");
      this.CloseMenus();
      if (this.menu_versioni)
        this.menu_versioni.CloseMenu();
      this.LoadVersion(vers,forceLoad);
    }

    this.LoadVersion=function(versionName,forceLoad) {
      var baseCfgName = this.ConfigName.Value();
      if (Empty(baseCfgName)) {
        baseCfgName = "default";
      }
      var idx = baseCfgName.indexOf('__');
      if (idx>-1) {
        baseCfgName = baseCfgName.substring(0,idx);
      }
      if (versionName=='default' || Empty(versionName)) {
        this.LinkedConfiguration(baseCfgName,forceLoad);
      } else {
        this.LinkedConfiguration(baseCfgName+ '__' + versionName,forceLoad);
      }
    }

    this.SetCaption=function(new_Caption){
      if (advanced_suggester_active) {
        return false; // in caso di advanced_suggester non setto nessuna caption
      }
      var version = this.GetVersionsLabel();
      var cpt;
      var addVersion = true;
      if (!EmptyString(new_Caption)) {
        caption=new_Caption;
        this.label.Value(ToHTML(new_Caption));
        if (this.label2){
          this.label2.Value(ToHTML(new_Caption));
        }
        this.ShowCaption();
        // this.Grid.topposition=1;
        // this.Grid.Ctrl.style.top=Max(1,this.Grid.Ctrl.offsetTop)+'px';
      } else if(!EmptyString(this.Caption.Value())) {
        cpt=this.Caption.Value();
        caption=cpt;
        this.label.Value(ToHTML(cpt));
        if (this.label2){
          this.label2.Value(ToHTML(cpt));
        }
        this.ShowCaption();
      } else if(this.__cfgObj && this.__cfgObj.configuration && !EmptyString(this.__cfgObj.configuration.caption) ) {
        cpt=this.__cfgObj.configuration.caption_trad || this.__cfgObj.configuration.caption;
        caption=cpt;
        this.label.Value(cpt);
        if (this.label2){
          this.label2.Value(cpt);
        }
        this.ShowCaption();
      } else {
        addVersion = false;
        caption='';
        if (!viewToolbarFromConfig)
          this.HideCaption();
        else
          this.ShowCaption();
      }
      if( addVersion && version ){
        this.label.Ctrltbl.appendChild(version);
        if (this.label2){
          this.label.Ctrltbl.appendChild(version);
        }
      }
      this.CaptionChanged();
    }

    this._UpdateVersionsSubMenu=function(menu) {
      if (menu) {
        this.menu_used = menu;
      }
      if (this.__cfgObj && this.__cfgObj.configuration && this.__cfgObj.configuration.Versions) {
        this.__cfgObj.configuration.Versions=this.__cfgObj.configuration.Versions.sort();
        var versions = this.__cfgObj.configuration.Versions;
        var versionname = 'default';
        var item = {id:'current_version',children:[],maxsubitems:0, alwaysVisible:true};
        if (versions.length>0) {
          versionname = this.GetCurrentVersion();
        }
        item.children.push({
          title : 'default'
        , action : 'javascript:'+this.formid+'.ChangeVersion('+(-1)+')'
        , highlight : versionname==='default'
        });
        for (var i=0;i<versions.length;i++) {
          item.children.push({
            title : Strtran(versions[i], '_', ' ')
          , action : 'javascript:'+this.formid+'.ChangeVersion('+(i)+')'
          , highlight : versionname===versions[i]
          });
        }
        var old = this.menu_used.GetItem('current_version','versioni');
        if (old) {
          this.menu_used.UpdateItem('current_version',item);
        } else {
          this.menu_used.Append(item,'versioni',0);
        }
      }
    }

    this.startVPV = function() {
      this.label.Value(this.Caption.Value())
      this.loadVPV.Link()
      this.label.Hide()
    }

    this.loadVPV_Result = function(result){
      var cfg_obj = JSON.parse(result);
      this.__cfgObj = cfg_obj;
      if (cfg_obj.error) { }	/** CHECK ERRORE **/
      else {
        this.applyConfiguration(cfg_obj);
      }
    }

    this.applyConfiguration = function(obj) {
      this.hasFilters = false;
      var _dataobj;
      if (!Empty(obj.configuration.portletsrc)){
        this.SPLinker.Servlet(obj.configuration.portletsrc)
      }
      var vMode = obj.configuration.viewmode;
      if (!Empty(this.ViewMode.Value()) && this.ViewMode.Value() != vMode)
        vMode = this.ViewMode.Value();

      if( obj.configuration.cachelevel == undefined ) obj.configuration.cachelevel = 0;
      else obj.configuration.cachelevel = parseInt(obj.configuration.cachelevel+"")
      if( obj.configuration.cachelevel2 == undefined ) obj.configuration.cachelevel2 = 0;
      else obj.configuration.cachelevel2 = parseInt(obj.configuration.cachelevel2+"")
      if( vMode == 'chart' ) {
        obj.configuration.cachelevel = 0;
        obj.configuration.cachelevel2 = 0;
      }
      if( obj.configuration.cachelevel > 0 || obj.configuration.cachelevel2 > 0)
        this.useMDataLevel = true;
      else
        this.useMDataLevel = false;

      _dataobj = this.GetCurrentDataObj();
      _dataobj.ChangeQuery(obj.configuration.query);
	 
      /*------------recupera lista campi query*/
      var cmdHash, sqlcmd;
      if( _dataobj._iqueries) {
		  sqlcmd = _dataobj._iqueries[0];
		  cmdHash = _dataobj.cmdHash[0];
	  }
      else {
		  sqlcmd = _dataobj.cmd;
		  cmdHash = _dataobj.cmdHash;
	  }
      var qFilter = [];
      qFilter.push({"ED" : true})

      var addr = '../servlet/SQLDataProviderServer'
        + '?rows=100'
        + '&startrow=0'
        + '&count=false'
        + '&cmdhash=' + cmdHash
        + '&sqlcmd=' + URLenc(sqlcmd)
        + '&_sqlcmd='+ URLenc(obj.configuration.query)
        + '&isclientdb=false'
        + '&queryfilter=' + URLenc(JSON.stringify(qFilter))
        ;

      var AllField = new JSURL(addr, true);
      AllField = AllField.Response();

      var JSONObj = JSON.parse(AllField);
      if (JSONObj.ERROR) {
        if(!this.dispatchEvent('Error',JSONObj.ERROR)){
          alert(JSONObj.ERROR);
        }
        return;
      }
      var _fields = JSONObj.Fields;
      var _data = JSONObj.Data;
      var queryprop = _data[_data.length - 1].split(',');
      var _fieldstypearray = queryprop[1].split('');
      var i;
      var fields = [], lfields = [], types = [];
      for (i = 0; i < _fields.length; i++) {
        fields.push(_fields[i]);
        types.push(_fieldstypearray[i]);
        lfields.push(_fields[i].toLowerCase());
      }
      /*------------*/

      switch(vMode) {
        case "both":
          this.ZtTabs.Select('page3');
          this.configurePivot(obj, this.GridPivotB);
          if( _listData.indexOf(this.ChartB.name + this.StaticDataProviderB.name) < 0 ) {
            this.ChartB.SetDataProvider(this.StaticDataProviderB);
            _listData.push(this.ChartB.name + this.StaticDataProviderB.name)
          }
          this.ChartB.EnableMenu();
          break;
        case "chart":
          this.ZtTabs.Select('page2')
          this.configureChart(obj);
          break;
        default:	// grid - pivot
          this.ZtTabs.Select('page1')
          this.configurePivot(obj, this.GridPivot);
          break;
      }

      _dataobj.Fields = lfields;
      _dataobj.Fields_Case = fields;
      _dataobj.FieldsCase_map = {};
      _dataobj.Fields_map = {};
      for( i=0; i<lfields.length; i++) {
        _dataobj.FieldsCase_map[fields[i]] = i;
        _dataobj.Fields_map[lfields[i]] = i;
      }
      _dataobj.fieldstypearray = types;

      this._copyObj = {};
      this._copyObj.Fields = lfields;
      this._copyObj.Fields_Case = fields;
      this._copyObj.FieldsCase_map = JSON.parse(JSON.stringify(_dataobj.FieldsCase_map));
      this._copyObj.Fields_map = JSON.parse(JSON.stringify(_dataobj.Fields_map));
      this._copyObj.fieldstypearray = JSON.parse(JSON.stringify(_dataobj.fieldstypearray));

      var ret = [];
      if( this.__cfgObj.arrayFilters ) {
        for( i=0; i<this.__cfgObj.arrayFilters.length; i++ ) {
          ret.push(this.__cfgObj.arrayFilters[i]);
        }
      }
      if( _loadFixedFilters && _loadFixedFilters.length > 0 ) {
        for( i=0; i<_loadFixedFilters.length; i++ ) {
          obj={};
          var field = _loadFixedFilters[i].field.toLowerCase();
          obj[field]=_loadFixedFilters[i].expression;
          obj[field+'_op']=_loadFixedFilters[i].operator;
          obj[field+'_type']=_loadFixedFilters[i].type;
          obj[field+'_picture']=_loadFixedFilters[i].picture;
          obj[field+'_fixed']=false;
          obj[field+'_visible']=true;
          obj[field+'_queryParm']='';
          ret.push(obj)
        }
      }
      _loadFixedFilters = null;

      if (CharToBool(this.__cfgObj.configuration.applyAdvancedFilter)) {
        this.SetInnerFilters(ret, false, true);
        this.ApplyAdvancedFilter();
      }
      else if (CharToBool(this.__cfgObj.configuration.openVdmBeforeQuery)) {
        this.SetInnerFilters(ret, false, true);
        this.$entity$_updateFilters.setParms();
        this.ShowVdmMask();
      }
      else {
        this.SetInnerFilters(ret, false);
      }
    }

    this.cssFncCompare = function(value, type, value1, value2, fcolor, bcolor, fontName, fontStyle, fontSize) {
      var v1 = parseFloat(value1+"");
      var v2 = parseFloat(value2+"");
      var v = parseFloat(value+"");
      //between,notbetween,equals,notequals,more,less,moreequals,lessequals
      var ret = {};
      if( !Empty(fcolor) ) ret.color = fcolor;
      if( !Empty(bcolor) ) ret.backgroundColor = bcolor;
      if( !Empty(fontName) ) ret.fontFamily = fontName;
      if( !Empty(fontStyle) ) {
        if (fontStyle.indexOf('italic') >= 0) ret.fontStyle = 'italic';
        if (fontStyle.indexOf('bold') >= 0) ret.fontWeight = 'bold';
      }
      if( !Empty(fontSize) ) ret.fontSize = fontSize + 'px';
      var retobj = false;
      switch(type) {
        case "between":
          if( v>=v1 && v<=v2) retobj = true;
        break;
        case "notbetween":
          if(!( v>=v1 && v<=v2)) retobj = true;
        break;
        case "equals":
          if( v == v1 ) retobj = true;
        break;
        case "notequals":
          if( v != v1 ) retobj = true;
        break;
        case "more":
          if( v > v1 ) retobj = true;
        break;
        case "less":
          if( v < v1 ) retobj = true;
        break;
        case "moreequals":
          if( v >= v1 ) retobj = true;
        break;
        case "lessequals":
          if( v <= v1 ) retobj = true;
        break;
      }
      if( retobj ) {
        return ret;
      }
    }

    this.cssFnc2Scale = function(value, value1, value2, bcolor1, bcolor2) {
      var v1 = parseFloat(value1+"");
      var v2 = parseFloat(value2+"");
      var v = parseFloat(value+"");
      var ranges = [];
      if(Empty(bcolor1)) bcolor1= '#ffffff'
      if(Empty(bcolor2)) bcolor2= '#ffffff'
      ranges.push( {color: bcolor1, value:v1})
      ranges.push( {color: bcolor2, value:v2})
      var color = getMultichromaticRangeColorPV(ranges, v); //ztchartfunctions
      if( color && ( (color[0]+color[1]+color[2]) > 0)) {
        return {backgroundColor : 'rgba(' + color[0] +', ' + color[1] + ', ' + color[2] + ', ' + color[3]/255 + ')'}
      }
    }

    this.cssFnc3Scale = function(value, value1, value2, value3, bcolor1, bcolor2, bcolor3) {
      var v1 = parseFloat(value1+"");
      var v2 = parseFloat(value2+"");
      var v3 = parseFloat(value3+"");
      var v = parseFloat(value+"");
      var ranges = [];
      if(Empty(bcolor1)) bcolor1= '#ffffff'
      if(Empty(bcolor2)) bcolor2= '#ffffff'
      if(Empty(bcolor3)) bcolor3= '#ffffff'
      ranges.push( {color: bcolor1, value:v1})
      ranges.push( {color: bcolor2, value:v2})
      ranges.push( {color: bcolor3, value:v3})
      var color = getMultichromaticRangeColorPV(ranges, v); //ztchartfunctions
      if( color && ( (color[0]+color[1]+color[2]) > 0)) {
        return {backgroundColor : 'rgba(' + color[0] +', ' + color[1] + ', ' + color[2] + ', ' + color[3]/255 + ')'}
      }

    }

    this.cssFncApplyChart = function( item ) {
      var p= {};
      if( item.isChangeDataOrder ) {
        p.measure = item.keyF
      }
      else {
        p.measure = item.valueField;
      }
      var ret = _this.cssFncApply(item.value, p);
      if( ret )
        return ret;
      else
        return item.color;
    }

    this.cssFncApply = function( value, pivotKeys ) {
      if( !pivotKeys || !pivotKeys.measure ) return;
      var measure = pivotKeys.measure.toLowerCase() ;
      var mo = this['myObj_'+measure];
      var i;
      if( !mo) {
        for( i=0; i<this.__cfgObj.measures.length; i++ ) {
          if( this.__cfgObj.measures[i].field.toLowerCase() == measure ) {
            this['myObj_'+measure] = this.__cfgObj.measures[i];
            mo = this['myObj_'+measure];
            i = this.__cfgObj.measures.length;
          }
        }
      }
      if( !mo) {
        for( i=0; i<this.__cfgObj.omeasures.length; i++ ) {
          if( this.__cfgObj.omeasures[i].field.toLowerCase() == measure ) {
            this['myObj_'+measure] = this.__cfgObj.omeasures[i];
            mo = this['myObj_'+measure];
            i = this.__cfgObj.omeasures.length;
          }
        }
      }
      if( !mo) {
        return;
      }
      var toret = null;
      if( !Empty(mo.condformats) ) {
        var j, cf, ret;
        for( j=mo.condformats.length-1; j>=0; j--) {
          cf = mo.condformats[j];
          ret = null;
          if( cf.condType == 'compare' ) {
            ret = this.cssFncCompare(value, cf.vCompareType, cf.vCompare1, cf.vCompare2, cf.vFontColor, cf.vBckColor, cf.vFontName, cf.vFontStyle, cf.vFontSize)
          }
          else if( cf.condType == '2scale' ) {
            ret = this.cssFnc2Scale(value, cf.sCompare1, cf.sCompare2, cf.sBckColor1, cf.sBckColor2)
          }
          else if( cf.condType == '3scale' ) {
            ret = this.cssFnc3Scale(value, cf.sCompare1, cf.sCompare2, cf.sCompare3, cf.sBckColor1, cf.sBckColor2, cf.sBckColor3)
          }
          if( ret ) {
            if( toret == null ) toret = {};
            toret = Object.assign( toret, ret);
            if( cf.stopApply == true ) {
              j = -1;
            }
          }
        }
      }
      return toret;
    }

    this.configurePivot = function(obj, GridPivotCtrl) {
      var _dataobj = this.GetCurrentDataObj();
      if( _listData.indexOf(GridPivotCtrl.name + _dataobj.name) < 0 ) {
        GridPivotCtrl.SetDataProvider(_dataobj);
        _listData.push(GridPivotCtrl.name + _dataobj.name)
      }

      function makeFncCondFormat(measure) {
        if( Empty(measure.condformats) )
          return "";
        else {
         return "function:cssFncApply";
        }
      }
      var i,
          cols = obj.cols ? obj.cols : [],
          rows = obj.rows ? obj.rows : [],
          msrs = obj.measures ? obj.measures : [],
          omsrs = obj.omeasures ? obj.omeasures : [],
          odims = obj.odimensions ? obj.odimensions : [];
      for (i = 0; i< cols.length; i++) {
        GridPivotCtrl.AddColumnField({
          'field': cols[i].field.toLowerCase(),
          'title': cols[i].descrs,
          'key': cols[i].keys,
          'picture': cols[i].pictures,
          'sorting':{'order': cols[i].sorts, 'field': cols[i].sortsfields}
        })
      }
      for (i = 0; i< rows.length; i++) {
        GridPivotCtrl.AddRowField({
          'field': rows[i].field.toLowerCase(),
          'title': rows[i].descrs,
          'key': rows[i].keys,
          'picture': rows[i].pictures,
          'sorting':{'order': rows[i].sorts, 'field': rows[i].sortsfields}
        })
      }
      for (i = 0; i< odims.length; i++) {
        GridPivotCtrl.AddOtherDimension({
          'field': odims[i].field.toLowerCase(),
          'title': odims[i].descrs,
          'key': odims[i].keys,
          'picture': odims[i].pictures,
          'sorting':{'order': odims[i].sorts, 'field': odims[i].sortsfields}
        })
      }
      for (i = 0; i< msrs.length; i++) {
        GridPivotCtrl.AddMeasureField({
          'field': msrs[i].field.toLowerCase(),
          'title': msrs[i].descrs,
          'format_func': makeFncCondFormat(msrs[i]),
          'picture': msrs[i].pictures
        })
        this['myObj_'+ msrs[i].field.toLowerCase()] = msrs[i];
      }
      for (i = 0; i< omsrs.length; i++) {
        GridPivotCtrl.AddOtherMeasure({
          'field': omsrs[i].field.toLowerCase(),
          'title': omsrs[i].descrs,
          'format_func': makeFncCondFormat(omsrs[i]),
          'picture': omsrs[i].pictures
        })
        this['myObj_'+ omsrs[i].field.toLowerCase()] = omsrs[i];
      }
      GridPivotCtrl.EnableMenu();
      GridPivotCtrl.SetMeasuresOptions(obj.configuration.measuresoncolumn, obj.configuration.hidemeasures, obj.configuration.measurestitle);
      GridPivotCtrl.EnableSortOnColumns(obj.configuration.columnsort);
      GridPivotCtrl.EnableSortOnRows(obj.configuration.rowsort);
      GridPivotCtrl.SetGrandTotals(obj.configuration.bigtotaltext, obj.configuration.rowbigtotal, obj.configuration.columnbigtotal);
      GridPivotCtrl.SetSubTotals(obj.configuration.subtotaltext, obj.configuration.rowsubtotal, obj.configuration.columnsubtotal);
      GridPivotCtrl.SetUIDragAndDrop(obj.configuration.uiDragDrop);
      GridPivotCtrl.SetOtherDimensions(obj.configuration.othDimMeas);
      GridPivotCtrl.SetPrintMode(obj.configuration.PrintMode, obj.configuration.ReportName, obj.configuration.print_outputf, obj.configuration.print_option);
      GridPivotCtrl.SetPrintOptions(obj.configuration.print_model, obj.configuration.print_title, obj.configuration.print_hideexport,
        obj.configuration.print_hidesettings, obj.configuration.print_grep, obj.configuration.print_max);
      GridPivotCtrl.SetCSS(this.theme, obj.configuration.css, obj.configuration.css_class);
      GridPivotCtrl.SetFilter(!securityOpts.hidePivotFilters && CharToBool(obj.configuration.canFilter+""));
      GridPivotCtrl.SetApplyFilter(true); // in caso di filtri fissi vanno applicati ma non modificabili
      if( _dataobj.ChangeConfigPivot ) {
        _dataobj.ChangeConfigPivot(GridPivotCtrl, this.__cfgObj.configuration.cachelevel, this.__cfgObj.configuration.cachelevel2)
      }
    }

    this.configureChart = function(obj) {
      this.GridPivot._setThis(this.Chart);
      this.Chart.rangefunc = "function:cssFncApplyChart"
      this.Chart.Filters = [];
      this.Chart.vpvPivotUI = null;
      this.Chart.ztVPivotUI = null;
      this.Chart.vpvDivTabs = true;
      // es. config default
      //var defaultChart = Empty(obj.configuration.chartDef);
      this.Chart.SetChartDef(obj.configuration.chartDef);	// lo fisso io in caso di default?
      this.Chart.SetUrlTooltip('../jsp-system/SPChartTooltipsR_portlet.jsp','default');
      // this.Chart.SetOtherChartTypes('all') - wip da opzionare

      this.Chart.EnableMenu();

      if( _listData.indexOf(this.Chart.name + this.StaticDataProviderB.name) < 0 ) {
        this.Chart.SetDataProvider(this.StaticDataProviderB);
        _listData.push(this.Chart.name + this.StaticDataProviderB.name)
      }

      LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/ZtPivotData.js');
      LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + '/ZtPivotUI.js');


      this.theme, obj.configuration.css

      var _cssFiles = [];
      if(!Empty(obj.configuration.css)) {
				_cssFiles.push(obj.configuration.css);
				_cssFiles.push(this.theme+ '/' +obj.configuration.css);
				_cssFiles.push('styles/' + obj.configuration.css);
				_cssFiles.push(this.theme+ '/styles/' +obj.configuration.css);
			}
      else {
        _cssFiles.push('styles/GridPivotObj.css');
				_cssFiles.push(this.theme+ '/' +'styles/GridPivotObj.css');
      }

      var lfiles = _cssFiles.toString();
      var URL = new ZtVWeb.JSURL(ZtVWeb.SPWebRootURL + '/servlet/SPPrxycizerServlet?files=' +  URLenc(lfiles), true );
      var url = URL.SetUnwrapMsg(false);
      var output = url.Response();
      if(!output.match("ACCESS DENIED")){
        _cssFiles = output.split(',');
      }
      this.Chart._cssFiles = _cssFiles;
    }

    this.QueryParmsFunc = function(sep) {
        var _dataobj = this.GetCurrentDataObj();
        sep = sep || '&';
        var res = '';
        if (Empty(_dataobj.parms)) {
          return res;
        }
        var params = _dataobj.parms.split(',');
        for (var i = 0; i < params.length; i++) {
            if( this[params[i]] ) {
                res += params[i] + '=' + URLenc(ZtVWeb.formatAsPrm(this[params[i]].Value())) + sep;
            }
        }
        return res;
    };

    this.QueryParmsObj = function() {
      var _dataobj = this.GetCurrentDataObj();
      var res = {};
      if (Empty(_dataobj.parms)) {
        return res;
      }
      var params = _dataobj.parms.split(',');
      for (var i = 0; i < params.length; i++) {
          if( this[params[i]] ) {
            res[params[i]] = this[params[i]].Value();
          }
      }
      return res;
  };

    this.GridPivot_Click = function(event, item){
      this._Link(item);
    }

    this.GridPivotB_Click = function(event, item){
      this._Link(item);
    }

    this.ChartB_Click = function(event, item){
      var pivotItem = this.GridPivotB.ConvertKeysToItem(item.keyF, item.multidimCurrentKey, item.valueField, item.value);
      this._Link(pivotItem);
    }


    this._Link = function(item) {
      if (Empty(this.__cfgObj.configuration.portletsrc))
        return;
      var _dataobj = this.GetCurrentDataObj();
      var p = '', i, idx, key, pa = [],
      linkparms = (this.__cfgObj.configuration.linkparms || "");
      if( linkparms.indexOf('jsClickItem') >= 0 ) {
        var zoomFilters = {};
        for (idx = 0; idx < item.columns.length; idx++) {
          var col = item.columns[idx];
          key = col.key ? col.key : col.alias;
          zoomFilters[key] = col.value;
          pa.push(key)
        }
        for (idx = 0; idx < item.rows.length; idx++) {
          var row = item.rows[idx];
          key = row.key ? row.key : row.alias;
          zoomFilters[key] = row.value;
          pa.push(key);
        }
        this.jsClickItem.Value((JSON.stringify(zoomFilters)));
      }
      else {
        if( item.rows ) {
          for( i=0; i<item.rows.length; i++ ) {
            if( !Empty(p) ) p += ',';
            p+= (item.rows[i].key ? item.rows[i].key : item.rows[i].alias ) + '=' + item.rows[i].value;
            pa.push((item.rows[i].key ? item.rows[i].key : item.rows[i].alias ))
          }
        }
        if( item.columns ) {
          for( i=0; i<item.columns.length; i++ ) {
            if( !Empty(p) ) p += ',';
            p+= (item.columns[i].key ? item.columns[i].key : item.columns[i].alias ) + '=' + item.columns[i].value;
            pa.push((item.columns[i].key ? item.columns[i].key : item.columns[i].alias ))
          }
        }
      }
      var sp = _dataobj.parms.split(','), s, f=false;
      var l = "," + linkparms + ","
      for( idx = 0; idx<sp.length; idx++ ) {
        s = sp[idx];
        if(!Empty(s)) {
          if( (pa.indexOf(s) < 0) ) {
            f = false;
            f = f || ( l.indexOf("," + s + ",") >= 0 )
            f = f || ( l.indexOf("," + s + "=") >= 0 )
            if( !f) {
              if( !Empty(p) ) p += ',';
              p += s;
            }
          }
        }
      }
      this.SPLinker.Parameters(linkparms+','+p)
      this.SPLinker.Link()
    }

    this.getChartMacroType = function (type) {
      var mtypes = {
                                  category: [ "HBAR","HBAR3D","PYRAMID","LAYEREDBARH",
                                    "PIE","PIE3D","RING","RINGPERC",
                                    /*"TREEMAP","TREEMAPBAR","TREEMAPBARH",*/"WORDCLOUD",
                                    "HSTACKBAR","HSTACKBAR3D","VSTACKBAR","VSTACKBAR3D",
                                    "LINES","AREA","STACKEDAREA","RADARLINE","RADARAREA",
                                    "VBAR","VBAR3D","PARETO","WATERF","LAYEREDBAR",
                                    "PCOORDS", "CAL"
                                  ],
                                  measure: [
                                    "ARCDIAL","THERMO",
                                    "LIGHTS","IMAGES",
                                    "DISPLAY","COUNTER","PADDLE"
                                  ],
                                  xyz: ["SCATTER", "BUBBLE", "ASTER", "AREABAR", "VORONOI"],
                                  geo: ["GEOMAP"],
                                  hie: ["SUNB", "SUNBSTR", "TREE", "TREESTR", "CPACK", "CPACKSTR", "FORCE", "TREEMAP","TREEMAPBAR","TREEMAPBARH","MARIMEKKO"],
                                  dep: ["MATRIX", "CHORD", "FORCESTR", "SANKEY"],
                                  classif: ["BCMATRIX"]
                                },
          mkeys = Object.keys(mtypes),
          found = false,
          rt = "";
      for (var t = 0; !found && t < mkeys.length; t++) {
        if (mtypes[mkeys[t]].indexOf(type) >= 0) {
          rt = mkeys[t];
          found = true;
        }
      }
      return rt;
    }

    this.SetReceivers = function(){
        //var SET_FILTER='_zoomSetFilter',
        var rcvSuffix="",
            rcvName=this.ReceiverName.Value();

        function penPusher(parmsObj) { //funzione passacarte per receiver di filtro
          this.$entity$_zoomSetFilter.receiveFnc(parmsObj);
        }

        if(EmptyString(rcvName)){
          rcvName=this.EventName.Value();
        }
        for(var i=0,rcvs=rcvName.split(','),l=rcvs.length; i<l; i++){//receivername multiplo
          rcvName=rcvs[i];
          this['on_'+rcvName+rcvSuffix]=penPusher;//impostato per l'utente
        }
        this['on_'+rcvNameGen]=penPusher; // evento usato dalle vdm per passare i filtri (se c'erano piu di uno zoom sulla stessa pagina, i filtri venivano applicati a tutti)
    }

    this.LoadMenuObject = function(menuCtrl) {
      //azioni

      var children = [];

      if( _saveConfig ) {
        children.push({
          id:'save',
          title: FormatMsg('PIVOT_SAVE_CONFIG'),
          tooltip: FormatMsg('PIVOT_SAVE_CONFIG'),
          action:function(){ _this.SaveVersion()},
          image:{ fontFamily:'icons8_win10', value: "&#xecb3", size: "20px"}
         })
      }

      var ui = (this.__cfgObj.configuration.uiDragDrop === 'true');
      if( ui ) {
        var isextended = this.IsOpenUiDragDrop();
        var act={
          id:'expandreduce',
          title: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
          tooltip: isextended ? FormatMsg('PIVOT_HIDE_FIELDS') : FormatMsg('PIVOT_SHOW_FIELDS'),
          action:function() {
            _this.ShowHideFields();
          },
          image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
            (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
        }
        children.push(act);
      }

      children.push({
        id: 'refresh_itm',
        title: FormatMsg('MSG_FORM_FUNCTION_REFRESH'),
        tooltip: FormatMsg('MSG_FORM_FUNCTION_REFRESH'),
        image: SPTheme.portalZoomRefreshImage||'',
        action : function() {
          _this.refreshQuery();
          _this.CloseMenus();
        }
      });
      if ( !securityOpts.hidePrintButton && this.printModeSecurity) { //canPrint
        if ( (typeof(this.__cfgObj.configuration.PrintMode)=='undefined' || this.__cfgObj.configuration.PrintMode!='None') ) {
          children.push({
                  id: 'print_itm',
                  title: FormatMsg('MSG_VZM_PRINT'),
                  tooltip: FormatMsg('MSG_VZM_PRINT'),
                  image: SPTheme.portalZoomPrintImage||'',
                    action : function() {
                      _this.printZoom();
                      _this.CloseMenus();
                    }
                  });
        }
      }

      if(!securityOpts.hidePrintButton && this.printModeSecurity && this.__cfgObj.configuration.exportPivot && !(this.__cfgObj.configuration.viewmode == 'chart')){
        children.push({
          id:'exportPivot',
          title: FormatMsg('MSG_XLSX_PIVOT'),
          action:function(){ _this.SubmitListenerForm('exportPivot')},
          image:{ fontFamily:'icons8_win10', value: "&#xf51b", size: "20px"}
        });
      }

      if(!securityOpts.hidePrintButton && this.printModeSecurity && this.__cfgObj.configuration.exportTable){
        children.push({
          id:'exportTable',
          title: FormatMsg('MSG_XLSX_TABLE'),
          action:function(){ _this.SubmitListenerForm('exportTable')},
          image:{ fontFamily:'icons8_win10', value: "&#xf51b", size: "20px"}
        });
      }

      if ((CharToBool("" + this.__cfgObj.configuration.canFilter) || !Empty(this.__cfgObj.configuration.vdmfile)) && !(CharToBool("" + this.__cfgObj.configuration.hideFiltersBtn))){
        var o = {fontFamily:'icons8_win10', value: "&#xee44", size: "20px"};
        if( this.hasFilters) o = {fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"};
        children.push({
                id: 'showVdm',
                title: FormatMsg('MSG_FILTERS'),
                tooltip: FormatMsg('MSG_FILTERS'),
                image: o,
                action : function() {
                  _this.ShowVdmMask();
                  _this.CloseMenus();
                }
              });
      }

      if( this.hamburgerActions ) {
        var hamburgerActions = this.hamburgerActions;
        var i;
        ii = 0
        while( menuCtrl.Remove( 'action' + ii,null,'actions') ) {
          ii++;
        }
        for (i=0; i<hamburgerActions.length; i++){
         children.push({
            title: hamburgerActions[i].title_trad || hamburgerActions[i].title,
            tooltip: hamburgerActions[i].tooltip || hamburgerActions[i].title_trad || hamburgerActions[i].title,
            image: hamburgerActions[i].image_settings=='fontIcon'?{
                fontFamily:hamburgerActions[i].font_name,
                size:hamburgerActions[i].font_size,
                value:hamburgerActions[i].font_image,
                color:hamburgerActions[i].font_color
              }:hamburgerActions[i].image,
              action:(function(ZoomObj,_action){
                        return function(evt) {
                          ZoomObj.ExecAction(_action,evt);
                        }
                    })(this,hamburgerActions[i]),
            target:hamburgerActions[i].entityType=='routine'?"":hamburgerActions[i].target||'',
            id:'action'+i
          })
        }
      }

      menuCtrl.Append({
        title:FormatMsg('MSG_ZOOM_ACTIONS'),
        tooltip:FormatMsg('MSG_ZOOM_ACTIONS'),
        children:children,
        id:'actions'
      });

      //versioni
      var versionColumn = menuCtrl.GetItem("versioni");
      //var cGrid = this.GetCurrentPivot();
      if (/*!this.splinker.offline &&*/
        this.configModeSecurity>0 || (
          this.__cfgObj &&
          this.__cfgObj.configuration &&
          this.__cfgObj.configuration.Versions &&
          this.__cfgObj.configuration.Versions.length>0
        )
      ) {
        if (!versionColumn) {
          menuCtrl.Append({
            id: 'versioni'
          , title: FormatMsg('MSG_VERSIONS')
          , tooltip: FormatMsg('MSG_VERSIONS')
          },null,1);
        } else {
          menuCtrl.Clean('versioni');
        }

        this._UpdateVersionsSubMenu(menuCtrl);
      } else if (versionColumn) {
        menuCtrl.Remove('versioni');
      }

      //linked
      //
      var linkedConfs = this.__cfgObj.linkedConfs;
      var img;
      if (linkedConfs && linkedConfs.length>0) {
        var linkedConfColumn = menuCtrl.GetItem("linkedconfiguration");
        if (!linkedConfColumn) {
          menuCtrl.Append({
            id: 'linkedconfiguration'
          , title: FormatMsg('MSG_VIEWS')
          , tooltip: FormatMsg('MSG_VIEWS')
          },null,2);
        } else {
          menuCtrl.Clean('linkedconfiguration');
        }
        for (var ii=0; ii<linkedConfs.length; ii++) {
          if (linkedConfs[ii].image_settings=='fontIcon'){
            img = {
              fontFamily:linkedConfs[ii].font_name,
              size:linkedConfs[ii].font_size,
              value:linkedConfs[ii].font_image,
              color:linkedConfs[ii].font_color
            }
          } else if (!Empty(linkedConfs[ii].imagetoolbar) ) {
            img = linkedConfs[ii].imagetoolbar;
          } else if (linkedConfs[ii].imagetype=='card') {
            img = GetStyleVariable("card_image", "../"+ZtVWeb.theme+"/images/zoom/linkedConf_card.png");
          } else if (linkedConfs[ii].imagetype=='chart') {
            img = GetStyleVariable("chart_image", "../"+ZtVWeb.theme+"/images/zoom/linkedConf_chart.png");
          } else {
            img = GetStyleVariable("grid_image", "../"+ZtVWeb.theme+"/images/zoom/linkedConf_grid.png");
          }
          menuCtrl.Append({
            title : linkedConfs[ii].title_trad || linkedConfs[ii].title
          , tooltip : linkedConfs[ii].title_trad || linkedConfs[ii].title
          , image: img
          , action : 'javascript:'+this.formid+'.ChangeConfiguration('+(ii)+')'
          },'linkedconfiguration');
        }
      } else {
        menuCtrl.Remove('linkedconfiguration');
      }
    }

    this.GridPivot.manageMenu = this.GridPivotB.manageMenu = function( divMenu ) { //overwrite
      if ( !divMenu.hasAttribute("id") ) {
				divMenu.id = this.ctrlid + "_menu";
        if( this.menuCtrl ) {
          this.menuCtrl.Clean();
          this.menuCtrl = null;
        }
			}
      if( !this.menuCtrl ) {
				var menuHeight = 24;
				var hmenu = new ZtVWeb.HamburgerMenuCtrl(this.form, divMenu.id, this.name+'hmenu', 0, 0, menuHeight, menuHeight, 'top-top', 'SPPortalZoomBaseMenu', 10);
				this.menuCtrl = hmenu;
        _this.LoadMenuObject(this.menuCtrl);
        this.menuCtrl.OpenMenu();
      }
    }

    this.ApplyAdvancedFilter=function(){
      var i;
      if (!Empty(this.__cfgObj.configuration.vdmfile)){
        var urlParms=this.QueryParmsObj(), zoomParms={},
        parms=this.GetFilters();
        for (i=0; i<parms.length;i++){
          zoomParms[Lower(parms[i].field)]=parms[i];
        }
        var fields=JSON.parse(new JSURL("../servlet/SPVDMProxy?action=loadinit&m_cConfigName=" + URLenc(this.__cfgObj.configuration.vdmfile)).Response());
        var parmsValue={}
        var fixedFilterCount=0;
        var fld,name,lowername;
        for (i=0; i<fields.listFields.length; i++){
          name=fields.listFields[i];
          fld=fields[name];
          fld.Value=function(){
            if (IsA(this.value,this.type)) {
              return this.value;
            }
            else {
            switch (this.type){
              case 'N':
                return Val(this.value);
              case 'L':
                  return CharToBool(this.value);
              case 'D':
              case 'T':
                  return ZtVWeb.strToValue(this.value,this.type);
              default:
                return this.value;
            }
            }
          }
          if (fld.isFilter){
            if (fld.queryFilter)
              name='w_'+name;
            parmsValue[fixedFilterCount]={}
            lowername=name;
            if (zoomParms[lowername]){
              parmsValue[fixedFilterCount][name]=zoomParms[lowername].expression;
              parmsValue[fixedFilterCount][name+'_op']=zoomParms[lowername].operator;
              parmsValue[fixedFilterCount][name+'_type']=zoomParms[lowername].type;
              parmsValue[fixedFilterCount][name+'_visible']=zoomParms[lowername].visible;
              parmsValue[fixedFilterCount][name+'_picture']=zoomParms[lowername].picture;
              parmsValue[fixedFilterCount][name+'_queryParm']='';
              delete zoomParms[lowername]
            }
            else{
              if (urlParms[name])
                parmsValue[fixedFilterCount][name]=urlParms[name];
              else {
                if (fld.calculateInitialValue){
                  var rg=new RegExp(/([A-Za-z0-9_]+) *\(/);
                  var match=fld.value.match(rg);
                  if (match && match[1]) {
                    try {
                      LibJavascript.IncludeFunction('SPPortalZoom',match[1],false);
                    } catch (e) {}
                  }
                  fld.value=eval(fld.value);
                  parmsValue[fixedFilterCount][name]=fld.Value();
                }
                else if (fld.type=='D')
                  parmsValue[fixedFilterCount][name]= FormatDate(fld.Value(),'YYYY-MM-DD');
                else if (fld.type=='T')
                  parmsValue[fixedFilterCount][name]= FormatDateTime(fld.Value(),'YYYY-MM-DD hh:mm:ss');
                else
                  parmsValue[fixedFilterCount][name]= fld.Value();
              }
              parmsValue[fixedFilterCount][name+'_op']=fld.initialOperation;
              parmsValue[fixedFilterCount][name+'_queryParm']=fld.queryFilter?name:'';
              parmsValue[fixedFilterCount][name+'_type']=fld.type;
              parmsValue[fixedFilterCount][name+'_visible']=!(fld.hiddenGroup || fld.hiddenInVariant);
            }
            fixedFilterCount++;
          }
        }
        for (name in zoomParms){ // copio i filtri dello zoom non presenti nella maschera
          parmsValue[fixedFilterCount]={};
          parmsValue[fixedFilterCount][name]=zoomParms[name].expression;
          parmsValue[fixedFilterCount][name+'_op']=zoomParms[name].operator;
          parmsValue[fixedFilterCount][name+'_type']=zoomParms[name].type;
          parmsValue[fixedFilterCount][name+'_visible']=zoomParms[name].visible;
          parmsValue[fixedFilterCount][name+'_picture']=zoomParms[name].picture;
          parmsValue[fixedFilterCount][name+'_queryParm']='';
          fixedFilterCount++;
        }
        parmsValue['removeFixed']=true;
        this.SetInnerFilters({row:parmsValue});
      }
      else {
        var cGridPivot = this.GetCurrentPivot();
        this.applyFilterOnDataobj(cGridPivot);
      }
    }

    this.Chart.fillMenuCtrl = function (menuCtrl, divID) {
        var viewHM = (_this.__cfgObj.configuration.header != 'true');
	      if (menuCtrl) {
	        menuCtrl.Clean();
	      }
        else {
          var text = document.querySelectorAll('.' + divID+'_hmenu_wrapper')
          var el, c;
          for (c = 0; c<text.length; c++) {
            el = text[c];
            el.parentNode.removeChild(el);
          }
          var menuHeight = 24;
          menuCtrl = new ZtVWeb.HamburgerMenuCtrl(this.form, divID, divID+'_hmenu', 0, 0, menuHeight, menuHeight, 'top-top', 'SPPortalZoomBaseMenu', 10);
        }
        if(viewHM)
	        _this.LoadMenuObject(menuCtrl);
	       return menuCtrl;
    }

    this.PivotExportXLSX = function() {
      var cPivot = this.GetCurrentPivot();
      if( cPivot && cPivot.Print ) {
        cPivot.SetPrintMode('auto', '', 'XLSX')
        cPivot.SetPrintOptions('pivot');
        cPivot.Print();
      }
    }

    this.TableExportXLSX = function() {
      var cPivot = this.GetCurrentPivot();
      if( cPivot && cPivot.Print ) {
        cPivot.SetPrintMode('auto', '', 'XLSX')
        cPivot.SetPrintOptions('table');
        cPivot.Print();
      }
    }

    //ViewMode = chart
    this.mDataobj_QueryExecuted = this.dataobj_QueryExecuted = function () {
      if (this.CurrentPage() != 2) { // 2 vista chart - sia impostata in vpv sia passata in url
        return;
      }

      function _fncMakeStdFnc(txt) {
        if( Empty(txt) ) return txt;
        if( txt.indexOf('function:window') == 0 ) return txt;
        if( txt.indexOf('javascript:window') == 0 ) return txt;
        if(txt.indexOf('function:') > -1) {
          txt = txt.replace(/\|/g, ',');
          txt = txt.replace(/function:/g, '');
          txt = 'function:'+'window'+'.'+_this.form.formid + '.' + txt;
        }
        else if(txt.indexOf('javascript:') > -1) {
          txt = txt.replace(/\|/g, ',');
          txt = txt.replace(/javascript:/g, '');
          txt = 'javascript:'+'window'+'.'+ txt;
        }
        else {
          txt = txt.replace(/\|/g, ',');
        }
        return txt;
      }

      function _fncGetType(alias) {
        var j;
        for( j=0; j<datasource.Fields.length; j++) {
          if( datasource.Fields[j].toLowerCase() == alias.toLowerCase() )
            return datasource.fieldstypearray[j];
        }
      }

      var datasource =this.GetCurrentDataObj()
      var _l =[];

      var i, mobj, cobj,
      cfg = this.__cfgObj,
      opts = { rows : [], columns : [], measures : [] , omeasures :[], odimensions:[], fields :[]};

      for (i = 0; i < cfg.rows.length; i++) {
        var robj = {};
        robj.alias = cfg.rows[i].field.toLowerCase();
        robj.field = cfg.rows[i].field;
        robj.desc = cfg.rows[i].descrs;
        robj.type =  _fncGetType(robj.alias);
        robj.key = cfg.rows[i].keys;
        robj.orderby = cfg.rows[i].sorts;
        robj.orderfield = cfg.rows[i].sortsfields;
        robj.pictureFnc = _fncMakeStdFnc(cfg.rows[i].pictures);
        opts.rows.push(robj);  // tenere la configurazione normale ... serve per avere i dati in un certo ordine
                                //la configurazione dell'oggetto chart poi indica il disegno
        opts.fields.push(robj);
        _l.push(robj.alias)

        //da rivedere campi chiave
        /*if( robj.key ) {
          mobj = {};
          mobj.alias =
        }*/
      }

      for (i = 0; i < cfg.cols.length; i++) {
        cobj = {};
        cobj.alias = cfg.cols[i].field.toLowerCase();
        cobj.field = cfg.cols[i].field;
        cobj.desc = cfg.cols[i].descrs;
        cobj.type = _fncGetType(cobj.alias);
        cobj.key = cfg.cols[i].keys;
        cobj.orderby = cfg.cols[i].sorts;
        cobj.orderfield = cfg.cols[i].sortsfields;
        cobj.pictureFnc = _fncMakeStdFnc(cfg.cols[i].pictures);
        opts.columns.push(cobj);
        opts.fields.push(cobj);
        _l.push(cobj.alias)
      }

      for (i = 0; i < cfg.measures.length; i++) {
        mobj = {};
        mobj.alias = cfg.measures[i].field.toLowerCase();
        mobj.desc = cfg.measures[i].descrs;
        mobj.type = _fncGetType(mobj.alias);
        mobj.pictureFnc = _fncMakeStdFnc(cfg.measures[i].pictures);
        this['myObj_'+mobj.alias] = cfg.measures[i];
        opts.measures.push(mobj);
        opts.fields.push(mobj);
        _l.push(mobj.alias);
      }

      var ui = (cfg.configuration.uiDragDrop === 'true');
      var oth = (cfg.configuration.othDimMeas === 'true');
      if( ui ) {
        if( oth ) {
          for (i = 0; i < cfg.odimensions.length; i++) {
            cobj = {};
            cobj.alias = cfg.odimensions[i].field.toLowerCase();
            cobj.field = cfg.odimensions[i].field;
            cobj.desc = cfg.odimensions[i].descrs;
            cobj.type = _fncGetType(cobj.alias);
            cobj.key = cfg.odimensions[i].keys;
            cobj.orderby = cfg.odimensions[i].sorts;
            cobj.orderfield = cfg.odimensions[i].sortsfields;
            cobj.pictureFnc = _fncMakeStdFnc(cfg.odimensions[i].pictures);
            opts.odimensions.push(cobj);
            opts.fields.push(cobj);
          }
          for (i = 0; i < cfg.omeasures.length; i++) {
            mobj = {};
            mobj.alias = cfg.omeasures[i].field.toLowerCase();
            mobj.desc = cfg.omeasures[i].descrs;
            mobj.type = datasource.fieldstypearray[ datasource.FieldsCase_map[mobj.alias] ];
            mobj.pictureFnc = _fncMakeStdFnc(cfg.omeasures[i].pictures);
            this['myObj_'+mobj.alias] = cfg.omeasures[i];
            opts.omeasures.push(mobj);
            opts.fields.push(mobj);
          }
        }
        else {
          for( i=0; i<datasource.Fields.length; i++ ) {
            var _f = datasource.Fields[i].toLowerCase();
            if( _l.indexOf(_f) >= 0 )
              continue;
            mobj = {};
            mobj.alias = _f;
            mobj.desc = _f
            mobj.type = datasource.fieldstypearray[i];
            opts.fields.push(mobj);
          }
        }
      }
      var _dataobj = this.GetCurrentDataObj();
      this.Chart.pivotOptions = JSON.parse(JSON.stringify(opts));
      this.Chart.pivotData = new ZtVPivotData(opts, _dataobj.Fields, _dataobj.Data);
      this.Chart.pivotOptions.uiDragDrop = ui;
      this.Chart.pivotOptions.othDimMeas = oth;
      this.Chart.pivotOptions.canFilter = (CharToBool("" + cfg.configuration.canFilter))

      var pOpts = {};
      pOpts.rows = opts.rows;
      pOpts.columns = opts.columns;
      pOpts.measures = opts.measures;
      pOpts.fields = opts.fields;
      var vpvPivotUI = {};
      vpvPivotUI._initOpts = this.Chart.pivotOptions;
      vpvPivotUI.opts = pOpts;
      if( !this._wKey) this._wKey = LibJavascript.CharKeyGen(5);
      vpvPivotUI._wKey = this._wKey;
      this.Chart.Ctrl.classList.add(cfg.configuration.css_class)
      this.Chart.Ctrl.classList.add('drillboxer')
      this.Chart.Ctrl.classList.add(vpvPivotUI._wKey)
      this.Chart.pvSetUIDragDrop(vpvPivotUI);

      this.Chart.pvResetDrillDownObj();
      this.Chart.pvConfigureDraw();
      //console.log(this.__cfgObj.arrayFilters, this.Chart.Filters)
      if (!Empty(this.__cfgObj.arrayFilters))
        this.SetInnerFilters(this.__cfgObj.arrayFilters, true);
      else
        this.Chart.pvDrawPivotData();
    }

    this.Chart.getColObj = function (field) {
      var i;
      if( !this.Cols ) this.Cols = [];
      var allFieldsObj;
      if( this.Cols.length > 0 ) {
        allFieldsObj = this.Cols;
        for (i = 0; i < allFieldsObj.length; i++) {
          if (allFieldsObj[i].field.toLowerCase() == field.toLowerCase()) {
            return allFieldsObj[i];
          }
        }
      }
      else {
        if( this.vpvPivotUI && this.vpvPivotUI.opts && this.vpvPivotUI.opts.fields ) {
          allFieldsObj = this.vpvPivotUI.opts.fields;
          var _index = -1;
          for (i = 0; i < allFieldsObj.length; i++) {
            if(!allFieldsObj[i].field) continue; //campo con field specificato
            if (allFieldsObj[i].field.toLowerCase() == field.toLowerCase()) {
              _index = i;
            }
            allFieldsObj[i].title = allFieldsObj[i].desc;
            this.Cols.push(allFieldsObj[i]);
          }
          if( _index >= 0 ) return allFieldsObj[_index];
        }
        else {
          var gr = _this.GetCurrentDataObj();
          if( gr && gr.Fields) {
            allFieldsObj = gr.Fields;
            for (i = 0; i < allFieldsObj.length; i++) {
              if(!allFieldsObj[i].field) continue; //campo con field specificato
              if (allFieldsObj[i].field.toLowerCase() == field.toLowerCase()) {
                _index = i;
              }
              allFieldsObj[i].title = allFieldsObj[i].desc;
              this.Cols.push(allFieldsObj[i]);
            }
            if( _index >= 0 ) return allFieldsObj[_index];
          }
        }
      }
      return null;
    };

    this.Chart.findFieldInCols = function (field) {
      var i;
      if( this.vpvPivotUI && this.vpvPivotUI.opts && this.vpvPivotUI.opts.fields) {
        var allFieldsObj = this.vpvPivotUI.opts.fields;
        for (i = 0; i < allFieldsObj.length; i++) {
          if(!allFieldsObj[i].field) continue; //campo con field specificato
          if (allFieldsObj[i].field.toLowerCase() == field.toLowerCase())
            return i;
        }
      }
      return null;
    }


    this.Chart.GetFilterDivPosition = function(handler) {
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
			if( handler ) return _fGetAbsoluteXY(handler);
			//return _fGetAbsoluteXY(this.htmlFLTable);
		}

    this.Chart._rowLayer = [];
    this.Chart.ToggleFilterAreaByExample = this.GridPivot.ToggleFilterAreaByExample;
    this.Chart.filterByExampleMask_IsVisible = this.GridPivot.filterByExampleMask_IsVisible;
    this.Chart.MakeFilter = this.GridPivot.MakeFilter;
    this.Chart.AddFilter = this.GridPivot.AddFilter;
    this.Chart.RemoveAllFilters = this.GridPivot.RemoveAllFilters;
    this.Chart.RemoveFilterAlias = this.GridPivot.RemoveFilterAlias;
    this.Chart.CreateFilter = this.GridPivot.CreateFilter;
    this.Chart.RefreshFiltersBar = this.GridPivot.RefreshFiltersBar;
    this.Chart.operatorWithoutValue = this.GridPivot.operatorWithoutValue;
    this.Chart._removeFilterByIndex = this.GridPivot._removeFilterByIndex;
    this.Chart.ToggleFilterArea = this.GridPivot.ToggleFilterArea;
    this.Chart.ToggleDetailFilterByExample = this.GridPivot.ToggleDetailFilterByExample;
    this.Chart.AvailableOperators = this.GridPivot.AvailableOperators;
    this.Chart.FilterAreaEmpty = this.GridPivot.FilterAreaEmpty;
    this.Chart.AddEmptyFilter = this.GridPivot.AddEmptyFilter;
    this.Chart.MakeWrapper = this.GridPivot.MakeWrapper;
    this.Chart.AddNewFilter = this.GridPivot.AddNewFilter;
    this.Chart.SetExpressionsFilters = this.GridPivot.SetExpressionsFilters;
    this.Chart.RemoveFilter = this.GridPivot.RemoveFilter;
    this.Chart.ManageKey = this.GridPivot.ManageKey;
    this.Chart.SetFilters = this.GridPivot.SetFilters;
    this.Chart.FilterByExample_custom = this.GridPivot.FilterByExample_custom;
    this.Chart.FilterByExample = this.GridPivot.FilterByExample;
    this.Chart.collectFields = this.GridPivot.collectFields;
    this.Chart.DisableTempFilter = this.GridPivot.DisableTempFilter;
    this.Chart._OutFilterByExample = this.GridPivot._OutFilterByExample;
    this.Chart.HoverFilterObjByExample = this.GridPivot.HoverFilterObjByExample;
    this.Chart.ShowFilterObjByExample = this.GridPivot.ShowFilterObjByExample;
    this.Chart.uiClosed = true;


    this.Chart.ApplyFilter = function () {
      if (!this.filter_change) {
			  for (var i = 0; i < this.Filters.length;) {
				var operator = typeof this.Filters[i].operator == 'string' ? this.Filters[i].operator : this.Filters[i].operator.op;
				if (!EmptyString(this.Filters[i].expression) || operator && this.operatorWithoutValue(operator)) {
				  i++;
				} else {
				  this._removeFilterByIndex(i, true);
				}
			  }
			} else {
				this.dispatchEvent('FiltersCreated');
        _this.dispatchEvent('FiltersApplied');
        var filter_mask = LibJavascript.DOM.Ctrl(_this.Chart.ctrlid + '_filterByExample_mask');
        filter_mask.style.display = 'none';
        this.pvConfigureDraw()
				this.pvDrawPivotData()
			}
			this.filter_change = false;
    }

    this.Chart.pvDrawPivotData = function () {
      var opts = this.vpvPivotUI.opts;
      opts.filters = this.Filters.slice();

      var rowLevel = this.vpvDrillObj.rows.length + 1;
      var colLevel = this.vpvDrillObj.columns.length + 1;

      var _f = {}
      var i;
      _f.rows = [];
      _f.columns = [];
      _f.measures = [];
      for( i=0; i<rowLevel; i++) {
        _f.rows.push(opts.rows[i])
      }
      for( i=0; i<opts.columns.length; i++) {
        _f.columns.push(opts.columns[i])
      }
      for( i=0; i<opts.measures.length; i++) {
        _f.measures.push(opts.measures[i])
      }

      var dFilters = [], f, fi, sp, exp, op;
      for( i=0; i<this.vpvDrillObj.rows.length; i++) {
          f = this.vpvDrillObj.rows[i];
          op = '='
          if( f.expression != null ) {
            sp = f.expression.split(_mSeparator)
            exp = sp[sp.length-1]
          }
          else {
            exp = null;
          }
          if( exp == null ) op = 'empty';
          fi = this.MakeFilter(f.alias, op, exp, f.type, f.fixed, f.userFilter, f.defaultFilter, f.visible);
          dFilters.push(fi)
      }
      for( i=0; i<this.vpvDrillObj.columns.length; i++) {
        f = this.vpvDrillObj.columns[i];
        op = '='
        if( f.expression != null ) {
          sp = f.expression.split(_mSeparator)
          exp = sp[sp.length-1]
        }
        else {
          exp = null;
        }
        if( opts.columns[i].type == 'N' ) exp = parseFloat(exp);
        if( exp == null ) op = 'empty';
        fi = this.MakeFilter(f.alias, op, exp, f.type, f.fixed, f.userFilter, f.defaultFilter, f.visible);
        dFilters.push(fi)
      }

      _f.filters = opts.filters.concat(dFilters)

      var cData = this.pivotData._getNestedDataTable(_f, colLevel);
      _this.StaticDataProviderB.FillExtData(cData.Fields, cData.Data);
    }

    this.Chart.DrillColumn = function(alias, value, vdecod ) {
      var opts = this.vpvPivotUI.opts;
      if( !alias ) {
        var cindex = this.vpvDrillObj.columns.length;
        alias = opts.columns[cindex].alias;
      }
      var dr = JSON.parse(JSON.stringify(this.vpvDrillObj.columns));
      var i, columns = [], r, o;
      for( i=0; i<opts.columns.length; i++ ) {
        r = opts.columns[i];
        if( r.alias.toLowerCase() == alias.toLowerCase() ) {
          o = {};
          if( r.key ) o.alias = r.key;
          else o.alias = alias;
          o.expression = value;
          o.type = r.type;
          o.desc = vdecod;
          columns.push(o);
          i = opts.rows.length;
        }
        else if( i<dr.length ) {
          columns.push( dr[i]);
        }
      }
      this.vpvDrillObj.columns = columns;
      this.pvConfigureDraw()
      this.pvDrawPivotData();
    }

    this.Chart.DrillRow = function(alias, value, vdecod) {
      var opts = this.vpvPivotUI.opts;
      if( !alias ) {
        var cindex = this.vpvDrillObj.rows.length;
        alias = opts.rows[cindex].alias;
      }
      var dr = JSON.parse(JSON.stringify(this.vpvDrillObj.rows));
      var i, rows = [], r, o;
      for( i=0; i<opts.rows.length; i++ ) {
        r = opts.rows[i];
        if( r.alias.toLowerCase() == alias.toLowerCase() ) {
          o = {};
          if( r.key ) o.alias = r.key;
          else o.alias = alias;
          o.expression = value;
          o.desc = vdecod
          o.type = r.type;
          rows.push(o);
          i = opts.rows.length;
        }
        else if( i<dr.length ) {
          rows.push( dr[i]);
        }
      }
      this.vpvDrillObj.rows = rows;
      this.pvConfigureDraw()
      this.pvDrawPivotData();
    }

    this.ChartLink = function() {
      if (Empty(this.__cfgObj.configuration.portletsrc))
        return;
        var _dataobj = this.GetCurrentDataObj();
      if( this.Chart.vpvCItem ) {
        var item = this.Chart.vpvCItem;
        var p = '', idx, key, sp, col, pa = [],
        linkparms = (this.__cfgObj.configuration.linkparms || "");
        var zoomFilters = {};
        var colkey = item.multidimCurrentKey;
        sp = colkey.split(_mSeparator)
        for (idx = 0; idx < sp.length; idx++) {
          col = this.Chart.vpvPivotUI.opts.columns[idx];
          key = col.key ? col.key : col.alias;
          zoomFilters[key] = sp[idx];
          pa.push(key);
        }

        if( item.isChangeDataOrder == true )
          colkey = !Empty(item.valueField) ? item.valueField : item.series;
        else
          colkey = !Empty(item.keyF) ? item.keyF : item.category;

        sp = colkey.split(_mSeparator)
        for (idx = 0; idx < sp.length; idx++) {
          col = this.Chart.vpvPivotUI.opts.rows[idx];
          key = col.key ? col.key : col.alias;
          zoomFilters[key] = sp[idx];
          pa.push(key);
        }
        if( linkparms.indexOf('jsClickItem') >= 0 ) {
          this.jsClickItem.Value((JSON.stringify(zoomFilters)));
        }
        else {
          var keys = Object.keys(zoomFilters)
          for (idx = 0; idx < keys.length; idx++) {
            if( !Empty(p) ) p += ',';
            p+= (keys[idx]) + '=' + zoomFilters[keys[idx]];
          }
        }
        sp = _dataobj.parms.split(',');
        var s, f=false;
        var l = "," + linkparms + ","
        for( idx = 0; idx<sp.length; idx++ ) {
          s = sp[idx];
          if(!Empty(s)) {
            if( (pa.indexOf(s) < 0) ) {
              f = false;
              f = f || ( l.indexOf("," + s + ",") >= 0 )
              f = f || ( l.indexOf("," + s + "=") >= 0 )
              if( !f) {
                if( !Empty(p) ) p += ',';
                p += s;
              }
            }
          }
        }
        this.SPLinker.Parameters(linkparms+','+p)
        this.SPLinker.Link()
      }
      this.Chart.vpvCItem = null;
      this.refresh_menu.CloseMenu();
    }

    this.ChartDrillRow = function() {
      if( this.Chart.vpvCItem ) {
        var item = this.Chart.vpvCItem;
        if( item.isChangeDataOrder == true  )
        this.Chart.DrillRow(null, !Empty(item.valueField) ? item.valueField : item.series, item.series)
        else
        this.Chart.DrillRow(null, !Empty(item.keyF) ? item.keyF : item.category, item.category)
      }
      this.Chart.vpvCItem = null;
      this.refresh_menu.CloseMenu();
    }

    this.ChartDrillUpRow = function() {
      if( this.Chart.vpvDrillObj.rows.length > 0 ) {
        this.Chart.vpvDrillObj.rows.pop();
        this.Chart.pvConfigureDraw();
        this.Chart.pvDrawPivotData();
      }
      this.refresh_menu.CloseMenu();
    }

    this.ChartDrillColumn = function() {
      var combo = document.getElementById(this.Chart.ctrlid + '_ztchart_comboCursor');
      if( this.Chart.vpvCItem ) {
          var item = this.Chart.vpvCItem;
          combo = document.getElementById(this.Chart.ctrlid + '_ztchart_comboCursor');
          var zvalue = item.multidimCurrentKey;
          if( combo ) {
            var z, c;
            for(z=0; z<combo.length; z++){
              c = combo[z];
              if( c.value == zvalue ) {
                zvalue = c.text;
                z = combo.length;
              }
            }
          }
          this.Chart.DrillColumn(null, item.multidimCurrentKey, zvalue)
      }
      else {

        if( combo ) {
          this.Chart.DrillColumn(null,combo.value, combo[combo.selectedIndex].text)
        }
        var menuCtrl = this.Chart.GetMenuCtrl();
        if( menuCtrl ) menuCtrl.CloseMenu();
      }
      this.Chart.vpvCItem = null;
      this.refresh_menu.CloseMenu();
    }

    this.ChartDrillUpColumn = function() {
      if( this.Chart.vpvDrillObj.columns.length > 0 ) {
        this.Chart.vpvDrillObj.columns.pop();
        this.Chart.pvConfigureDraw();
        this.Chart.pvDrawPivotData();
      }
      this.refresh_menu.CloseMenu();
    }

    this._makeDrillColumnsMenuChildren_up = function() {
      var zvalue, z, pt = '', f, sp, exp, dexp, children = [], mitem;
      if( this.Chart.vpvDrillObj.columns.length > 0 ) {
        dexp = this.Chart.vpvPivotUI.opts.columns[this.Chart.vpvDrillObj.columns.length-1].desc;
        pt = ''
        for(z=0; z<this.Chart.vpvDrillObj.columns.length; z++) {
          if( !Empty(pt) ) pt+= ' > ';
          f = this.Chart.vpvDrillObj.columns[z];
          if( f.desc ) {
            pt += f.desc;
          }
          else {
            if( f.expression != null ) {
              sp = f.expression.split(_mSeparator)
              exp = sp[sp.length-1]
            }
            else {
              exp = '   ';
            }
            pt += exp;
          }
        }
        zvalue = '';
        mitem = {}
        mitem.id = 'drillUpColumn'
        mitem.title = dexp + ' : ' + pt + zvalue
        mitem.action = 'javascript:'+this.formid+'.ChartDrillUpColumn()';
        mitem.image = { fontFamily:'icons8_win10', value: "&#xf7fc", size: "20px"}
        children.push(mitem)
      }
      return children
    }

    this._makeDrillColumnsMenuChildren_down = function(item) {
      var combo, c, zvalue, z, pt = '', f, sp, exp, dexp, children = [], mitem;
      if( this.Chart.vpvPivotUI.opts.columns.length-1 > this.Chart.vpvDrillObj.columns.length ) {
        if( this.Chart.vpvDrillObj.columns.length > 0 )
          dexp = this.Chart.vpvPivotUI.opts.columns[this.Chart.vpvDrillObj.columns.length].desc;
        else
          dexp = this.Chart.vpvPivotUI.opts.columns[0].desc;
        pt = ''
        for(z=0; z<this.Chart.vpvDrillObj.columns.length; z++) {
          if( !Empty(pt) ) pt+= ' > ';
          f = this.Chart.vpvDrillObj.columns[z];
          if( f.desc ) {
            pt += f.desc;
          }
          else {
            if( f.expression != null ) {
              sp = f.expression.split(_mSeparator)
              exp = sp[sp.length-1]
            }
            else {
              exp = '   ';
            }
            pt += exp;
          }

        }
        if( !Empty(pt) ) pt+= ' > ';
        combo = document.getElementById(this.Chart.ctrlid + '_ztchart_comboCursor');
        zvalue = item.multidimCurrentKey;
        if( combo ) {
          z, c;
          for(z=0; z<combo.length; z++){
            c = combo[z];
            if( c.value == zvalue ) {
              zvalue = c.text;
              z = combo.length;
            }
          }
        }
        mitem = {}
        mitem.id = 'drillColumn'
        mitem.title =  dexp + " : " + pt + zvalue
        mitem.action = 'javascript:'+this.formid+'.ChartDrillColumn()';
        mitem.image = { fontFamily:'icons8_win10', value: "&#xec73", size: "20px"}
        children.push(mitem)
      }
      return children
    }

    this._makeDrillRowsMenuChildren_down = function(item) {
      var dexp, children = [], mitem;
      if( this.Chart.vpvPivotUI.opts.rows.length-1 > this.Chart.vpvDrillObj.rows.length ) {
        if( this.Chart.vpvDrillObj.rows.length > 0 )
          dexp = this.Chart.vpvPivotUI.opts.rows[this.Chart.vpvDrillObj.rows.length].desc;
        else
          dexp = this.Chart.vpvPivotUI.opts.rows[0].desc;
        mitem = {}
        mitem.id = 'drillRow'
        if( item.isChangeDataOrder == true )
          mitem.title = dexp + ' : ' + (!Empty(item.series) ? item.series : item.valueField)
        else
          mitem.title = dexp + ' : ' + (!Empty(item.category) ? item.category : item.keyF)
        mitem.action = 'javascript:'+this.formid+'.ChartDrillRow()';
        mitem.image = { fontFamily:'icons8_win10', value: "&#xec73", size: "20px"}
        children.push(mitem)
      }
      return children;
    }

    this._makeDrillRowsMenuChildren_up = function() {
      var dexp, children = [], mitem;
      if( this.Chart.vpvDrillObj.rows.length > 0 ) {
        dexp = this.Chart.vpvPivotUI.opts.rows[this.Chart.vpvDrillObj.rows.length-1].desc;
        mitem = {}
        mitem.id = 'drillUpRow'
        mitem.title = dexp + ' : ' + (this.Chart.vpvDrillObj.rows[this.Chart.vpvDrillObj.rows.length-1].desc)
        mitem.action = 'javascript:'+this.formid+'.ChartDrillUpRow()';
        mitem.image = { fontFamily:'icons8_win10', value: "&#xf7fc", size: "20px"}
        children.push(mitem)
      }
      return children;
    }

    this.Chart_Click = function(event, item){
      this.Chart.vpvCItem = item;
      this.refresh_menu.Ctrl.style.height='';
      this.refresh_menu.Ctrl.style.width='';
      this.refresh_menu.Ctrl.style.top='';
      this.refresh_menu.Ctrl.style.left='';
      this.refresh_menu.Clean();

      var childrend = [], childrenu = [], children = [];

      if (!Empty(this.__cfgObj.configuration.portletsrc)) {
        var mitem = {}
        mitem.id = 'clink'
        mitem.title = FormatMsg('MSG_OPEN_LINK')
        mitem.action = 'javascript:'+this.formid+'.ChartLink()';
        mitem.image = { fontFamily:'icons8_win10', value: "&#xe923", size: "20px"}
        children.push(mitem)
      }
      childrend = childrend.concat(this._makeDrillRowsMenuChildren_down(this.Chart.vpvCItem))
      childrend = childrend.concat(this._makeDrillColumnsMenuChildren_down(this.Chart.vpvCItem))
      childrenu = childrenu.concat(this._makeDrillRowsMenuChildren_up())
      childrenu = childrenu.concat(this._makeDrillColumnsMenuChildren_up())

      if( children.length > 0 ) {
        this.refresh_menu.Append({
          title:FormatMsg('MSG_ZOOM_ACTIONS'),
          tooltip:FormatMsg('MSG_ZOOM_ACTIONS'),
          children:children,
          id:'actions'
        });
      }

      if( childrend.length > 0 ) {
        this.refresh_menu.Append({
          title:FormatMsg('MSG_DRILL_DOWN'),
          tooltip:FormatMsg('MSG_DRILL_DOWN'),
          children:childrend,
          id:'actions_down'
        });
      }

      if( childrenu.length > 0 ) {
        this.refresh_menu.Append({
          title:FormatMsg('MSG_DRILL_UP'),
          tooltip:FormatMsg('MSG_DRILL_UP'),
          children:childrenu,
          id:'actions_up'
        });
      }

      if( children.length > 0 || childrend.length > 0  || childrenu.length > 0 ) {
        this.refresh_menu.Ctrl.style.display = '';
        this.refresh_menu.setCtrlPos(this.refresh_menu.Ctrl,event.clientX,event.clientY,null,null,'top-left')
        this.refresh_menu.OpenMenu();
      }
    }

    //overwrite chart pv
    this.Chart.pvUIFilterData = function(id, ev, alias) {
			if (!CharToBool(_this.__cfgObj.configuration.canFilter+""))
			  return;
        this.ToggleFilterArea(id, ev, alias);
		}

		this.Chart.pvUIRemFilterData = function(alias) {
			if (!CharToBool(_this.__cfgObj.configuration.canFilter+"") && !CharToBool(_this.__cfgObj.configuration.canApplyFilter+""))
			  return;
        this.RemoveFilterAlias(alias);
		}

		this.Chart.pvGetWDraw = function() {
			return this._wDraw;
		}

		this.Chart.pvSetWDraw = function(benable) {
			this._wDraw = benable;
		}

		this.Chart.pvResetAndDraw = function() {
			var opts = {};
			opts.rows = [];
			opts.columns = [];
			opts.measures = [];
			var i, div, alias, o;

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

      var divP = document.getElementById(this.vpvPivotUI._wKey + "-rows");
      var divL = divP.getElementsByClassName("row-field");
      var gv;
      for( i=0; i<divL.length; i++ ) {
        div = divL[i];
        if( div.classList.contains("moving-field"))
          continue;
        alias = this._fGetHTMLAttribute(div, "alias").toLowerCase();
        o = {};
        o.alias = alias;
        gv = getDesc(alias, this.vpvPivotUI.opts.fields);
        o.desc = gv.desc;
        if( gv.key ) o.key = gv.key;
        opts.rows.push(o);
      }

      divP = document.getElementById(this.vpvPivotUI._wKey + "-columns");
      divL = divP.getElementsByClassName("col-field");
      for( i=0; i<divL.length; i++ ) {
        div = divL[i];
        if( div.classList.contains("moving-field"))
          continue;
        alias = this._fGetHTMLAttribute(div, "alias").toLowerCase();
        o = {};
        o.alias = alias;
        gv = getDesc(alias, this.vpvPivotUI.opts.fields);
        o.desc = gv.desc;
        if( gv.key ) o.key = gv.key;
        opts.columns.push(o);
      }

      divP = document.getElementById(this.vpvPivotUI._wKey + "-measures");
      divL = divP.getElementsByClassName("mea-field");
      for( i=0; i<divL.length; i++ ) {
        div = divL[i];
        if( div.classList.contains("moving-field"))
          continue;
        alias = this._fGetHTMLAttribute(div, "alias").toLowerCase();
        o = {};
        o.alias = alias;
        o.desc = getDesc(alias, this.vpvPivotUI.opts.fields).desc;
        opts.measures.push(o);
      }

      opts.fields = this.vpvPivotUI.opts.fields;

      this.vpvPivotUI.opts = JSON.parse(JSON.stringify(opts))
      _this.pvCheckDrawPivotOpts(opts, this.vpvPivotUI)
      this.vpvPivotUI.opts = JSON.parse(JSON.stringify(opts)) //con tutte le opzioni

      this.pvConfigureDraw()
      this.pvDrawPivotData();
		}


    this.GetMeasureDataSet = function(key) {
     // var opts = this.vpvPivotUI.opts;
      /*var rowLevel = _this.Chart.vpvDrillObj.rows.length;
      var colLevel = _this.Chart.vpvDrillObj.columns.length;
      _this.Chart.propertyName = [];
      _this.Chart.propertyName.push(_this.Chart.vpvPivotUI.opts.columns[colLevel].alias+'_pic');
      _this.Chart.propertyName.push(_this.Chart.vpvPivotUI.opts.rows[rowLevel].alias+'_pic');
      _this.Chart.propertyName.push(_this.Chart.vpvPivotUI.opts.columns[colLevel].alias);
      _this.Chart.propertyName.push(_this.Chart.vpvPivotUI.opts.rows[rowLevel].alias);
      _this.Chart.propertyName.push(_this.Chart.vpvPivotUI.opts.measures[0].alias);
      //this.labelKey_field = this.vpvPivotUI.opts.columns[colLevel].alias+',' + this.vpvPivotUI.opts.rows[rowLevel].alias
      _this.Chart.label_field =  _this.Chart.vpvPivotUI.opts.columns[colLevel].alias+'_pic' +',' + _this.Chart.vpvPivotUI.opts.rows[rowLevel].alias+'_pic'
      _this.Chart.value_fields = _this.Chart.vpvPivotUI.opts.measures[0].alias
      _this.Chart.label_series = ""
      _this.Chart.orgPName = _this.Chart.propertyName.slice();
      _this.Chart.makePropertyName();*/
      var i, j, index;
      var ret = [], row = [], crow;
      for( i=0; i<_this.StaticDataProviderB.Data.length; i++ ) {
        row = [];
        crow = _this.StaticDataProviderB.Data[i];
        for( j=0; j<_this.Chart.propertyName.length; j++ ) {
          if( _this.Chart.propertyName[j] == 'xmeasure')
            index = _this.StaticDataProviderB.Fields.indexOf(key);
          else
            index = _this.StaticDataProviderB.Fields.indexOf(_this.Chart.propertyName[j]);
          row.push(crow[index]);
        }
        ret.push(row)
      }
      return ret
    }

    this.Chart.pvConfigureDraw = function () {
      var i;
      var opts = this.vpvPivotUI.opts;
      var rowLevel = this.vpvDrillObj.rows.length;
      var colLevel = this.vpvDrillObj.columns.length;
      var _treeMap = _this.getChartMacroType(this.ctype);
      if( _treeMap == 'hie' ) {
        this.propertyName = [];
        this.vmode = "mdim";
        this.multi_scale = false;
        this.cursorType = "combo";
        this.multisubdivision = "default";
        var keylist = "", labellist = "";
        this.propertyName.push(this.vpvPivotUI.opts.columns[colLevel].alias+'_pic');
        this.propertyName.push(this.vpvPivotUI.opts.rows[rowLevel].alias+'_pic');
        this.propertyName.push(this.vpvPivotUI.opts.columns[colLevel].alias);
        this.propertyName.push(this.vpvPivotUI.opts.rows[rowLevel].alias);
        this.propertyName.push('xmeasure');
        for( i=0; i<this.vpvPivotUI.opts.measures.length; i++) {
          if( !Empty(keylist) ) keylist +=','
          if( !Empty(labellist) ) labellist +=','
          keylist += this.vpvPivotUI.opts.measures[i].alias;
          labellist += this.vpvPivotUI.opts.measures[i].desc;
        }
        //this.labelKey_field =  this.vpvPivotUI.opts.columns[colLevel].alias +',' + this.vpvPivotUI.opts.rows[rowLevel].alias
        this.label_field =  this.vpvPivotUI.opts.columns[colLevel].alias +',' + this.vpvPivotUI.opts.rows[rowLevel].alias//this.vpvPivotUI.opts.columns[colLevel].alias+'_pic' +',' + this.vpvPivotUI.opts.rows[rowLevel].alias+'_pic'
        this.value_fields = 'xmeasure'
        this.label_series = this.vpvPivotUI.opts.columns[colLevel].alias+'_pic' +',' + this.vpvPivotUI.opts.rows[rowLevel].alias+'_pic'
        this.orgPName = this.propertyName.slice();
        this.makePropertyName();
        this.SetMultiDataset(keylist, labellist, "prezzo","function:GetMeasureDataSet")
        return;
      }

      this.SetDataOrder('column')
      this.vmode = "mdim";
      this.multi_key_field = this.vpvPivotUI.opts.columns[colLevel].alias;
      this.multi_label_field = this.vpvPivotUI.opts.columns[colLevel].alias+'_pic';
      this.multi_scale = false;
      this.cursorType = "combo";
      this.multisubdivision = "default";

      this.propertyName = [];
      this.propertyName.push(this.vpvPivotUI.opts.rows[rowLevel].alias);
      this.labelKey_field = this.vpvPivotUI.opts.rows[rowLevel].alias
      var vals = "", labs = "";
        for (i = 0; i < opts.measures.length; i++) {
            vals += (opts.measures[i].alias + ",");
            labs += (opts.measures[i].desc + ",");
            this.propertyName.push(opts.measures[i].alias)
        }
      this.propertyName.push(this.vpvPivotUI.opts.rows[rowLevel].alias+'_pic');
      this.label_field = this.vpvPivotUI.opts.rows[rowLevel].alias+'_pic'
      this.value_fields = vals.slice(0, -1)
      this.label_series = labs.slice(0, -1)
      this.orgPName = this.propertyName.slice();

      this.subtitle = this.vpvPivotUI.opts.rows[0].desc;
      for( i=0; i<rowLevel; i++ ) {
        this.subtitle += ' > ' + this.vpvPivotUI.opts.rows[i+1].desc;
      }

      this.title = FormatMsg('MSG_VIEW') + ' [ ' + this.vpvPivotUI.opts.columns[0].desc;
      for( i=0; i<colLevel; i++ ) {
        this.title += ' > ' + this.vpvPivotUI.opts.columns[i+1].desc;
      }
      this.title += ' ]';

      this.makePropertyName();
    }

	  this.pvCheckDrawPivotOpts = function (drawOpts, vpvthis) {
      function _fIsNotUndefined(o) {
        return (o !== undefined)
      }
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
        drawOpts.columns.push(vpvthis.opts.columns[0])
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
         if(drawOpts.rows[i] && vpvthis.opts.rows[i]) {
           if(drawOpts.rows[i].alias != vpvthis.opts.rows[i].alias) {
             isValid = false;
           }
           else {
             for( k=0; k<vpvthis._initOpts.fields.length; k++ ) {
               if(drawOpts.rows[i].alias == vpvthis._initOpts.fields[k].alias) {
                 drawOpts.rows[i].desc = vpvthis._initOpts.fields[k].desc;
                 drawOpts.rows[i].key = vpvthis._initOpts.fields[k].key;
                 drawOpts.rows[i].pictureFnc = vpvthis._initOpts.fields[k].pictureFnc;
                 drawOpts.rows[i].type = vpvthis._initOpts.fields[k].type;

                 if ( _fIsNotUndefined(drawOpts.rows[i].orderfield) ) {
                   updRowsF.push(i);
                 }
                 else {
                   drawOpts.rows[i].orderfield = vpvthis._initOpts.fields[k].orderfield;
                 }
                 if ( _fIsNotUndefined(drawOpts.rows[i].orderby) ) {
                  updRowsO.push(i);
                 }
                 else {
                  drawOpts.rows[i].orderby = vpvthis._initOpts.fields[k].orderby;
                 }
                 k = vpvthis._initOpts.fields.length;
               }
             }
           }
         }
         else {
           isValid = false;
         }
      }
      for(i=0; isValid && i<drawOpts.columns.length; i++) {
        if(drawOpts.columns[i] && vpvthis.opts.columns[i]) {
           if(drawOpts.columns[i].alias != vpvthis.opts.columns[i].alias) {
             isValid = false;
           }
           else {
             for( k=0; k<vpvthis._initOpts.fields.length; k++ ) {
               if(drawOpts.columns[i].alias == vpvthis._initOpts.fields[k].alias) {
                 drawOpts.columns[i].desc = vpvthis._initOpts.fields[k].desc;
                 drawOpts.columns[i].key = vpvthis._initOpts.fields[k].key;
                 drawOpts.columns[i].pictureFnc = vpvthis._initOpts.fields[k].pictureFnc;
                 drawOpts.columns[i].lvalues = vpvthis._initOpts.fields[k].lvalues;
                 drawOpts.columns[i].type = vpvthis._initOpts.fields[k].type;
                 if ( _fIsNotUndefined(drawOpts.columns[i].orderfield) ) {
                   updColsF.push(i);
                 }
                 else {
                   drawOpts.columns[i].orderfield = vpvthis._initOpts.fields[k].orderfield;
                 }
                 if ( _fIsNotUndefined(drawOpts.columns[i].orderby) ) {
                  updColsO.push(i);
                 }
                 else {
                  drawOpts.columns[i].orderby = vpvthis._initOpts.fields[k].orderby;
                 }
                 k = vpvthis._initOpts.fields.length;
               }
             }
           }
         }
         else {
           isValid = false;
         }
      }

      drawOpts.measures = [];
      for(i=0; isValid && i<vpvthis.opts.measures.length; i++) {
        var f = false;
        for( k=0; k<vpvthis._initOpts.measures.length; k++ ) {
          if(vpvthis.opts.measures[i].alias == vpvthis._initOpts.measures[k].alias) {
            drawOpts.measures.push(vpvthis._initOpts.measures[k]);
            k = vpvthis._initOpts.measures.length;
            f = true;
          }
        }
        if(!f) {
          for( k=0; k<vpvthis._initOpts.fields.length; k++ ) {
            if(vpvthis.opts.measures[i].alias == vpvthis._initOpts.fields[k].alias) {
              drawOpts.measures.push(vpvthis._initOpts.fields[k]);
              k = vpvthis._initOpts.fields.length;
              f = true;
            }
          }
        }
      }

      if ( isValid ) {
        drawOpts.measuresOnColumn = vpvthis._initOpts.measuresOnColumn;
        drawOpts.subTotalOnRow = vpvthis._initOpts.subTotalOnRow;
        drawOpts.subTotalOnRowLevel = vpvthis._initOpts.subTotalOnRowLevel;
        drawOpts.subTotalOnColumn = vpvthis._initOpts.subTotalOnColumn;
        drawOpts.bigTotalOnRow = vpvthis._initOpts.bigTotalOnRow;
        drawOpts.bigTotalOnColumn = vpvthis._initOpts.bigTotalOnColumn;
        drawOpts.bigTotalTitle = vpvthis._initOpts.bigTotalTitle;
        drawOpts.subTotalTitle = vpvthis._initOpts.subTotalTitle;
        drawOpts.measuresTitle = vpvthis._initOpts.measuresTitle;
        drawOpts.sortRow = vpvthis._initOpts.sortRow;
        drawOpts.sortColumn = vpvthis._initOpts.sortColumn;
        drawOpts.hideMeasures = vpvthis._initOpts.hideMeasures;
        for(i=0; i<updRowsF.length; i++) {
          k = updRowsF[i];
          if( drawOpts.rows[k].orderfield == null) {
            delete vpvthis.opts.rows[k].orderfield;
            delete drawOpts.rows[k].orderfield;
          }
          else {
            vpvthis.opts.rows[k].orderfield = drawOpts.rows[k].orderfield;
          }
        }
        for(i=0; i<updRowsO.length; i++) {
          k = updRowsO[i];
           if( drawOpts.rows[k].orderby == null) {
            delete vpvthis.opts.rows[k].orderby;
            delete drawOpts.rows[k].orderby;
          }
          else {
            vpvthis.opts.rows[k].orderby = drawOpts.rows[k].orderby;
          }
        }
        for(i=0; i<updColsF.length; i++) {
          k = updColsF[i];
          if( drawOpts.columns[k].orderfield == null) {
            delete vpvthis.opts.columns[k].orderfield;
            delete drawOpts.columns[k].orderfield;
          }
          else {
            vpvthis.opts.columns[k].orderfield = drawOpts.columns[k].orderfield;
          }
        }
        for(i=0; i<updColsO.length; i++) {
          k = updColsO[i];
          if( drawOpts.columns[k].orderby == null) {
            delete vpvthis.opts.columns[k].orderby;
            delete drawOpts.columns[k].orderby;
          }
          else {
            vpvthis.opts.columns[k].orderby = drawOpts.columns[k].orderby;
          }
        }
      }
      return isValid;
    }

    this.Chart.IsOpenUiDragDrop = function() {
      if( this.vpvPivotUI && this.vpvPivotUI._initOpts.uiDragDrop ) {
        return !this.uiClosed;
      }
      return CharToBool(_this.__cfgObj.configuration.uiDragDrop+"");
    }

    this.Chart.ShowHideFields = function() {
      if( !this.vpvPivotUI || !this.vpvPivotUI._initOpts.uiDragDrop)
        return;
      var l = this.Ctrl.getElementsByClassName('drillboxconf');
			var i;
			for( i=0; i<l.length; i++) {
				if( l[i].style.display == 'none') {
          l[i].style.display = '';
          this.uiClosed = false;
        }
				else {
          l[i].style.display = 'none';
          this.uiClosed = true;
        }

			}
			var cfCols = this.Ctrl.getElementsByClassName('columns')
			var cfMeas = this.Ctrl.getElementsByClassName('measures')
			if( cfCols && cfMeas && cfCols[0] && cfMeas[0] && cfMeas[0].offsetHeight > 0)
				cfCols[0].style.height = cfMeas[0].offsetHeight + 'px';
    }

		this.Chart.pvGetTranslate = function(key) {
			if( ZtVWeb && ZtVWeb.PivotTranslations && ZtVWeb.PivotTranslations[key]) {
				return ZtVWeb.PivotTranslations[key];
			}
			return "MSG_" + key;
		}

    this.Chart._fGetHTMLAttribute = function (elem, attr) {
      return elem.getAttribute(attr);
    }

    this.Chart._updateFiltersDiv = function() {
      var filters = this.vpvPivotUI.opts.filters;
      if(!filters) filters = this.Filters;
      var l = this.Ctrl.getElementsByClassName('rem_filter');
		  var i,  alias, f;
		  var lalias = [], map = {};
		  if( filters)
        for( i=0; i<filters.length; i++ ) {
          lalias.push(filters[i].field.toLowerCase());
          map[filters[i].field.toLowerCase()] = filters[i];
        }
      for( i=0; i<l.length; i++ ) {
        alias = this._fGetHTMLAttribute(l[i], 'alias');
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
      this._OutFilterByExample();//filtri
    }

    this.Chart._GetInnerPivotObj = function() {
      return this.vpvPivotUI;
    }

    this.Chart.pvSetUIDragDrop = function ( vpvPivotUI ) {
      this.vpvPivotUI = vpvPivotUI;
    }

    this.Chart.pvResetDrillDownObj = function() {
      this.vpvDrillObj = {};
      this.vpvDrillObj.rows = [];
      this.vpvDrillObj.columns = [];
    }

    this.GridPivot._GetInnerPivotObj = this.GridPivotB._GetInnerPivotObj = function() {
      return this.ztpivot;
    }

    this.refresh_menu_AfterMenuClose = function() {
      this.refresh_menu.Ctrl.style.display = 'none';
    }

    this.OpenEditor=function() {
      this.refresh_menu.CloseMenu();
      var config = this.Config();
      //console.log(config)
      if (this.menu_versioni)
        this.menu_versioni.CloseMenu();
      window.open('../portalstudio/portalstudio.jsp?tool=visualpivot&id='+URLenc((config.ConfigName||'default'))+'&custom='+((config.Custom+'')=='true'),'_blank','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,width='+(window.screen.width-150)+',height='+(window.screen.height-150));
      var _this=this;
      window.ReportPivotConfiguration=function() {
        _this.LoadConfiguration(_this.ConfigName.Value()); //forzare il ricaricamento dopo salvataggio
      }
    }

    //chart print
    this.Chart.Print = function() {
      var printManager = this.getPrintManager();
			printManager.OnCinemaClick(function () {
				printManager.Close();
			});
			printManager.SetPrintData(this.GetPrintData());
			printManager.Show();
    }

    this.Chart.getPrintManager = function () {
			var grid = this;
			if (this.getPrintManager.singleton) {
			  return this.getPrintManager.singleton;
			}
			return this.getPrintManager.singleton = new function () {
			function getContainer() {
				var printCntID = grid.ctrlid + '_printManagerCnt',
				printCnt = document.getElementById(printCntID);
				if (!printCnt) {
				printCnt = document.createElement('div');
				printCnt.id = printCntID;
				printCnt.style.position = 'absolute';
				printCnt.style.width = '100%';
				printCnt.style.maxWidth = '500px';
				printCnt.className = 'toolsbar_items';
				getCinema().appendChild(printCnt);
				}
				return printCnt;
			} // getContainer

			function getCinema() {
				var printCinemaID = grid.ctrlid + '_printManagerCinema',
				printCinema = document.getElementById(printCinemaID);
				if (!printCinema) {
				printCinema = document.createElement('div');
				printCinema.id = printCinemaID;
				printCinema.style.position = 'absolute';
				printCinema.style.width = '100%';
				printCinema.style.height = '100%';
				printCinema.style.zIndex = '3';
				LibJavascript.DOM.insertElement(grid.Ctrl.parentElement, 0, printCinema);
				}
				return printCinema;
			} // getCinema

			this._GetPrintPortlet = function () {
				return ZtVWeb.getPortletInc(getContainer(), grid.printPortlet);
			}; // _GetPrintPortlet

			this.Show = function () {
				var printPortlet,
				ForcedPortletUID = '__SPRANDOMPORTLETUID__',
				printPortletUID = LibJavascript.AlfaKeyGen(5),
				printCnt = getContainer(),
				containsAttr = 'data-sp-contains-print-portlet',
				contansPrintPtl = !!printCnt.getAttribute(containsAttr);

				function replacer(str) {
				return str.replace(/(__SPRANDOMPORTLETUID__)/g, function () {
					return printPortletUID;
				});
				}
				if (!contansPrintPtl) {
				if (200 == ZtVWeb.Include('../jsp-system/' + grid.printPortlet + '_portlet.jsp?ForcedPortletUID=' + ForcedPortletUID, printCnt, false, replacer)) {
					printCnt.setAttribute(containsAttr, 'true');
				} else {
					throw new Error('Unable to include print portlet.');
				}
				}
				getCinema().style.display = '';
				printPortlet = this._GetPrintPortlet();
				printPortlet.addObserver('printPortlet', this);
				printPortlet.RcvPrintParms(this.GetPrintData());
			}; // Show

			this.printPortlet_CloseRequest = function () {
				this.Close();
			};

			this.Close = function () {
				getCinema().style.display = 'none';
				var pprint = this._GetPrintPortlet();
				if (pprint && pprint._isPrinting) {
				pprint._isPrinting = false;
				if (grid.isZoom) {
					var pzoom = grid.form;
					if (pzoom && pzoom._printZoom) {
					delete pzoom._printZoom;
					}
				}
				}
			}.bind(this); // Close

			this.GetContainer = function () {
				return getContainer();
			}; // GetContainer

			this.IsVisible = function () {
				return getCinema().style.display == 'none';
			}; // IsVisible

			var _printData;
			this.SetPrintData = function (data) {
				_printData = data;
			}; // SetPrintData

			this.GetPrintData = function () {
				return _printData;
			}; // GetPrintData

			var onCinemaClick = this.Close;
			this.OnCinemaClick = function (fncDoOnClick) {
				onCinemaClick = fncDoOnClick;
			}; // OnCinemaClick

			LibJavascript.Events.addEvent(getContainer(),
				'click',
				function (evt) {
				evt.stopPropagation();
				},
				false
			);
			LibJavascript.Events.addEvent(getCinema(),
				'click',
				function (evt) {
				return onCinemaClick(evt);
				},
				false
			);
			}();
		};

    this.Chart.GetPrintDataObj = function() {
			return this.printDataObj;
		}

    this.Chart.GetPrintData = function() {
			var ret;
      this.print_model = 'table';
      ret = _this.StaticDataProviderB._getCloneForPrint();
      ret.nRecs = _this.StaticDataProviderB.nRecs;
      ret.Data = _this.StaticDataProviderB.Data;
      ret.Fields_Case = _this.StaticDataProviderB.Fields_Case;
      ret.FieldsCase_map = {};
      ret.Fields_map = {};
      ret._dpType = "StaticDataProvider";
			var name = 'chartPivotPrint' + LibJavascript.AlfaKeyGen(5);
			var st = {};
			st["anchor"] = "";
			st["async"] = false;
			st["auto_exec"] = "true";
			st["ctrlid"] = this.form.formid + "_" + name + "_" + "InnerStaticDataProvider";
			// st["dataproviders"] = name; // non necessario essendo lui stesso riempito con i dati dalla FillExtData
			st["fieldsString"] = "";
			st["fieldstypeString"] = "";
			st["h"] = 20;
			st["hide"] = "false";
			st["layer"] = false;
			st["layout_steps_values"] = {};
			st["name"] = name + "_" + "InnerStaticDataProvider";
			st["page"] = 1;
			st["parms"] = "";
			st["parms_source"] = "";
			st["type"] = "StaticDataProvider";
			st["w"] =  120;
			st["x"] =  192;
			st["y"] =  -24;
			var _dataObj = new ZtVWeb.StaticDataProvider(this.form, st);
			this.form[st["name"]] = _dataObj;
			_dataObj.FillExtData(ret.Fields_Case, ret.Data);
			this.printDataObj = _dataObj;
			function GetFields (ret, drill) {
				var lfields = [];
				var i, o;
        o = {};
        o.alias = ret.rows[0].alias;
        o.desc = ret.rows[0].desc;
        o.type = 'C';
        o.align = 'left';
        lfields.push(o);
				for( i=0; i<drill.rows.length; i++ ) {
          o = {};
          o.alias = ret.rows[i+1].alias;
          o.desc = ret.rows[i+1].desc;
          o.type = 'C';
          o.align = 'left';
          lfields.push(o);
        }
        o = {};
          o.alias = ret.columns[0].alias;
          o.desc = ret.columns[0].desc;
          o.type = 'C';
          o.align = 'left';
          lfields.push(o);
        for( i=0; i<drill.columns.length; i++ ) {
          o = {};
          o.alias = ret.columns[i+1].alias;
          o.desc = ret.columns[i+1].desc;
          o.type = 'C';
          o.align = 'left';
          lfields.push(o);
        }
        for( i=0; i<ret.measures.length; i++ ) {
          o = {};
          o.alias = ret.measures[i].alias;
          o.desc = ret.measures[i].desc;
          o.type = 'C';
          o.align = 'right';
          o.len = 12;
          lfields.push(o);
        }
				return lfields;
			}
			this.printFields = GetFields(this.vpvPivotUI.opts, this.vpvDrillObj);

			var pGrep = this.print_grep;
			if( this.print_model == 'default') pGrep = true;
			return {
			  associatedTable: '', // Nome della gestione associata allo zoom
			  fields: JSON.stringify(this.printFields),
			  fieldstitle: '',
			  fieldspicture: '',
			  //fieldsorderby: grid.GetFieldsOrderBy(),
			  VqrName:  _dataObj.cmd,
			  //parms: _this.QueryParmsFunc(),
			  //m_cVZMParamBlock: grid.VZMParamBlock(), // Filtri presenti nella grid
			  outputFormat: this.print_outputf || '',
			  ReportName: this.ReportName || '',
			  PrintMode: this.PrintMode || '',
			  isSqlDataProvider: false,
			  gridName: this.name,
			  fromGrid: true,
			  title: this.print_title || '',
			  printMode: this.print_option || 'default',
			  printHideExport: this.print_hideexport || false,
			  printHideSettings: this.print_hidesettings || false,
			  printTotals: false,
			  maximized: this.print_max || false,
			  group_repeated: pGrep
			};
    }

    this.Chart.GetFields = function() {
			return JSON.stringify(this.printFields);
		}

    this.Chart.SetPrintMode = function(PrintMode, ReportName, print_outputf, print_option) {
      this.PrintMode = PrintMode;
			this.ReportName = ReportName;
			this.print_outputf = print_outputf;
			this.print_option = print_option;
    }

    this.Chart.SetPrintOptions = function(print_model, print_title, print_hideexport, print_hidesettings, print_grep, print_max) {
      this.print_model = print_model;
			this.print_title = print_title;
			this.print_hideexport = print_hideexport;
			this.print_hidesettings = print_hidesettings;
			this. print_grep = print_grep;
			this.print_max = print_max;
    }

    this.Chart._setVPV = this.ChartB._setVPV = function(ztChartObj) {
      ztChartObj.defSettings.hierarchy = { breadcrumb: { show: true, fixed: true } };
      ztChartObj.defSettings.range.applyColor = true;
      ztChartObj.objConfig.rangeBands = "function"
    }


    this.menu_versioni_BeforeMenuOpen = function() {
      this.CloseMenus();
    }

    this.refresh_menu_BeforeMenuOpen = function() {
      var menuCtrl = this.GetCurrentMenu();
      if(menuCtrl) menuCtrl.CloseMenu();
    }
}
