/* global PrepareJsCalendar Min BatchJavascript EmptyNumber GetStyleVariable
    Val RTrim CountChar SPOfflineLib*/
/* exported doZoom */
function doZoom() {
  var zoom_portlet = this;
  var viewMode;
  var currentCss = [];
  var rcvNameGen=LibJavascript.AlfaKeyGen(5);
  var decoratorsFunctions = {};
  var userModGridRows = false;
  var advanced_suggester = [];
  var advanced_suggester_active = false;

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
  function setZoomTitles(portlet) {
    var portletId = portlet.formid,
      zoomId = this.formid,
      containerId = (this.container && this.container.formid) || '';
    if(zoomId === portletId || containerId === portletId) { // salto me stesso e il mio contenitore diretto
      return;
    }
    if (portlet.portletname === 'SPPortalZoomBase' ||
      portlet.portletname === 'SPPortalZoomBaseOL' ||
      portlet.portletname.startsWith('default_title_form') || // decoratore delle entita' non puo' essere degli zoom
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
  this.setDefaultMobileLayout = function(){
    var new_Cols = [];
    var type_obj;
    var type, length;
    var indnewCols = [];//Campi cercati (Descr,Codice,ecc) volgiamo riempire 3 campi
    var indnewColsOthers = []; // Altri campi
    //Cerco eventuali campi di interesse (descrizioni o codici)
    for(var c = this.vzmstructure.Cols.length-1; c > -1  ; c--){
      if (this.vzmstructure.Cols[c].type_obj) {
        type_obj = this.vzmstructure.Cols[c].type_obj.match(/([A-Z])+((\()([0-9]+).*)?/);
        type = type_obj[1];
        length = parseInt(type_obj[4]);
      } else {
        type = 'C';
        length = 0;
      }
      /* type_obj.groups:
      * 1: type (C,N,D,M,T)
      * 4: length
      */
      if( type == "C" &&  length > 15 || type == "M"){ //ind 0 campo descrittivo
        if(indnewCols[0] != null){
          indnewColsOthers.splice(0,0,indnewCols[0]);//lo scarto e va in others
        }
        indnewCols[0] = c;
      } else if( type == "N" || (type == "C" && length < 15 )){ //ind 1,2 codici
        if( this.vzmstructure.Cols[c] != new_Cols[indnewCols[1]] ){
          indnewCols.splice(1,0,c);
        }
      }else{
        indnewColsOthers.splice(0,0,c);
      }
    }
    if(indnewCols.length<3){ //se � rimasto un buco vuoto lo riempio con gli altri campi
      for(var cc=0,co=0; cc < 3; cc++){
        if(indnewCols[cc] == null){
          if(indnewColsOthers[co] != null){
            indnewCols[cc] = indnewColsOthers[co];
            co++;
          }
        }
      }
    }

    // Creo nuovo array di Colonne con le prop. Mobile incolonnate con layout predefinito
    new_Cols[0] = this.vzmstructure.Cols[indnewCols[0]]; //Prima cella con solo lettera Maiuscola
    new_Cols[3] = JSON.parse(JSON.stringify(this.vzmstructure.Cols[indnewCols[0]]));   //Secondo campo Descr
    new_Cols[3].new_line = true;
    new_Cols[3].height = "20px";
    new_Cols[3].col_class = "field_nome";
    new_Cols[0].col_class = "capitalize";
    new_Cols[0].field = "initletter2:" + new_Cols[0].field;
    new_Cols[0].row_span = "5";


    new_Cols[1] = LibJavascript.JSONUtils.adjust({field:'html:&nbsp;'}, this.Grid.getColSchema()); // spazio sopra
    new_Cols[1].height = "30px";
    //Primo campo
    if(this.vzmstructure.Cols[indnewCols[1]]==null){
      new_Cols[2] = LibJavascript.JSONUtils.adjust({field:'html:&nbsp;'}, this.Grid.getColSchema());
    }else{
      new_Cols[2] = this.vzmstructure.Cols[indnewCols[1]];
    }
    //new_Cols[2] = (this.vzmstructure.Cols[indnewCols[1]]==null?:this.vzmstructure.Cols[indnewCols[1]]); //Primo campo
    new_Cols[2].new_line = true;
    new_Cols[2].height = "13px";
    new_Cols[2].col_class = "field_codice";

    //Terzo campo
    if(this.vzmstructure.Cols[indnewCols[2]]==null){
      new_Cols[4] = LibJavascript.JSONUtils.adjust({field:'html:&nbsp;'}, this.Grid.getColSchema());
    }else{
      new_Cols[4] = this.vzmstructure.Cols[indnewCols[2]];
    }
    //new_Cols[4] = (this.vzmstructure.Cols[indnewCols[2]]==null?this.Grid.getColSchema():this.vzmstructure.Cols[indnewCols[2]]);
    new_Cols[4].new_line = true;
    new_Cols[4].height = "13px";
    new_Cols[2].col_class = "field_prezzo";

    new_Cols[5] = LibJavascript.JSONUtils.adjust({field:'html:&nbsp;'}, this.Grid.getColSchema()); // spazio sotto
    new_Cols[5].new_line = true;
    new_Cols[5].height = "30px";

    this.vzmstructure.Configuration.titles = 'false'; // nascondo i titoli
    this.vzmstructure.Configuration.defaultViewMode = 'card'; // modalit� card
    this.vzmstructure.Configuration.css_class_card_container = 'autovzm';
    this.vzmstructure.Configuration.toolsPosition = "expanding-row";
    this.vzmstructure.Cols = new_Cols; // sostituisco l'array delle colonne
  }.bind(this);

  if(ZtVWeb.IsMobile() && this.vzmstructure.Configuration.defaultConfiguration == 'true'){
    this.setDefaultMobileLayout();
  }
  ZtVWeb.addEventListener('portletloaded', function(e) {
    if(!e.detail.fromParent){ // stessa finestra
      setZoomTitles.call(this, e.detail.portlet);
    }
  }.bind(this));

  var advanced_suggester_string = this.AdvancedSuggester.Value();
  advanced_suggester_active = !Empty(advanced_suggester_string);

  if (advanced_suggester_active) {
    advanced_suggester = advanced_suggester_string.split(',');
    // nascondo la caption e svuoto il valore per futuri ridisegnamenti
    this.Caption.Value('');
    this.vzmstructure.Configuration.Caption = '';
    this.label.Ctrl.style.display='none';
    this.vzmstructure.Configuration.header='false'

    var param = this.ConfigGridElements.Value();  // carico i parametri dell'utente
    param += '-r'; // record mark
    param += '-s'; // le righe vuote
    param += '-h'; // decoratore nav/bar
    this.ConfigGridElements.Value(param);
  }

  this.doZoom=function(){
    if (this.menu_versioni) {
      this.menu_versioni.Ctrl.style.height='';
      this.menu_versioni.Ctrl.style.width='';
      this.menu_versioni.Ctrl.style.top='';
      this.menu_versioni.Ctrl.style.left='';
      this.menu_versioni.setCtrlPos(this.menu_versioni.Ctrl,null,null,null,null,'top-right');
      if( ZtVWeb.IsMobile())
        this.menu_versioni.setSide('center');
      this.menu_versioni.Hide();
    }
    //imposta la griglia
    this.SetGrid();

    this.SetTiles();
    //imposta il nome dell'emitter
    this.SetEmitters();

    paramAutozoom=(EmptyString(this.UID.Value())?this.Autozoom.Value():this.Linkzoomprg.Value());
    paramEntityType=this.EntityType.Value();

    //imposta spliker
    this.SetSPLinkers();

    //imposta la query
    this.SetQuery();

    this.SetToolbarBox();
  }

  this.SetCss = function() {
    currentCss = Empty(this.vzmstructure.Configuration['css']) ? [] : this.vzmstructure.Configuration['css'].split(",");
    // aggiungo i file di currentCss
    for(var i = 0; i < currentCss.length; i++) {
      ZtVWeb.RequireThemedCSS(currentCss[i].replace(".ce.css", ".ce.min.css"));
    }
  }


  this.SetTiles=function() {
    if (this.box_tiles) {
      this.box_tiles.FillData=function(datasource) {
        var i, col;
        var structure = [], groupbys = [];
        // eslint-disable-next-line no-cond-assign
        for (i=0; col=this.form.Grid.Cols[i]; i++){
          if (col.groupby) {
            groupbys.push({
              title : col.title
            , value : col.field
            , picture : col.pict_total
            });
          }
        }
        // eslint-disable-next-line no-cond-assign
        for (i=0; col=this.form.Grid.Cols[i]; i++){
          if (col.exp && (typeof(col.tileVisibility)=='undefined' ||col.tileVisibility=="base" || (col.tileVisibility=="extended" && (this.form.Grid.IsExtended()|| !this.form.Grid.IsExtensible())))) {
            structure.push({
              title : col.descr
            , value : col.field
            , tileModeGroupBy : col.tileModeGroupBy
            , tileBackgroundColor : col.tileBackgroundColor
            , tileVersion : col.tileVersion
            , picture : col.pict_total
            });
          }
        }
      this.Ctrl.innerHTML="";
      if (this.Ctrl.style.display!='none')
        this.Ctrl.style.display='flex';
      this.Ctrl.style.flexDirection='row';
      if (this.form.vzmstructure.Configuration.TotalsStarting=='right') {
        this.Ctrl.style.justifyContent='flex-end';
      } else {
        this.Ctrl.style.justifyContent='flex-start';
      }
      this.Ctrl.style.alignItems='stretch';
      this.Ctrl.style.flexOrientation='column';
        var j, k, el, title, value, nRecs, subel, tileModeGroupBy;
        for(i=0,nRecs=datasource.getRecCount(); i<nRecs; i++){
          for(j=0; j<structure.length; j++){
            tileModeGroupBy = structure[j].tileModeGroupBy !== "none";
            el = document.createElement('div');
            var txt = '';
            if (structure[j].tileVersion) {
              txt=ZtVWeb.fmtPctFldPct(structure[j].tileVersion,i,datasource,null,this.form,false,true); //formatta i %campo%
              txt=(new Function("return " + txt)).call(this.form);
            }
            el.className = 'tile_container ' + ' Tile' + (txt ? ' ' + txt : '' );
            if (!Empty(structure[j].tileBackgroundColor)) {
              txt = '';
              if (structure[j].tileBackgroundColor) {
                txt=ZtVWeb.fmtPctFldPct(structure[j].tileBackgroundColor,i,datasource,null,this.form,false,true); //formatta i %campo%
                txt=(new Function("return " + txt)).call(this.form);
              }
              if (txt!='') {
                el.style.backgroundColor = txt;
              }
            }
            if (tileModeGroupBy) {
              for(k=0; k<groupbys.length; k++){
                subel = document.createElement('div');
                subel.className = 'tile_groupby';
                el.appendChild(subel);
                if (groupbys[k].title) {
                  title = document.createElement('div')
                  title.className = 'tile_groupby_title'
                  title.innerHTML = groupbys[k].title
                  subel.appendChild(title);
                }
                value = document.createElement('div')
                value.className = 'tile_groupby_value'
                value.innerHTML = Trim(ZtVWeb.applyPicture(datasource.getValue(i,groupbys[k].value),'',0, groupbys[k].picture));
                subel.appendChild(value);
              }
            }
            subel = document.createElement('div');
            subel.className = 'tile_element';
            el.appendChild(subel);

            if (structure[j].title) {
              title = document.createElement('div')
              title.className = 'tile_title'
              title.innerHTML = structure[j].title
              subel.appendChild(title);
            } else {
              title = document.createElement('br')
              subel.appendChild(title);
            }
            value = document.createElement('div')
            value.className = 'tile_value'
            value.innerHTML = Trim(ZtVWeb.applyPicture(datasource.getValue(i,structure[j].value),'N',0,structure[j].picture));
            subel.appendChild(value);
            this.Ctrl.appendChild(el);
          }
        }
        // var elements = this.Ctrl.children, maxh=0,maxw=0;
        // for (var i=0;i<elements.length;i++) {
          // maxh = Max(maxh,elements[i].offsetHeight);
          // maxw = Max(maxh,elements[i].offsetWidth);
        // }
        // for (var i=0;i<elements.length;i++) {
          // elements[i].style.height = maxh+'px';
          // elements[i].style.width  = maxw+'px';
        // }
        // if (this.Grid.scroll_bars=='infinite_scroll')
        if (this.form.Grid.scroll_bars=='infinite_scroll') {
          // vedi SetGridScroll
          if (Left(this.form.vzmstructure.Configuration.TotalsPosition,6)=='bottom' ) {
            this.form.Grid.Ctrl.style.bottom = this.Ctrl.offsetHeight + 'px';
          } else {
            this.form.Grid.Ctrl.style.bottom = '0px';
          }
        }
        this.form.adjustHeight();
      };
      this.box_tiles.UpdateCurRec=function(/*datasource*/) {
        // debugger
      };
      this.box_tiles.minheight=10;
      this.box_tiles.shrinkable='true'
      this.box_tiles.getRenderHeight=function(){
        if (this.Ctrl!=null){
          this.Ctrl.style.height='auto';
          var h=this.Ctrl.offsetHeight;
          this.lastRenderHeight=h;
        } else {
          this.lastRenderHeight=null
        }
        return this.lastRenderHeight
      }
      this.Grid_ExtendedGrid=function() {
        if (!this.box_tiles.IsHidden())
          this.box_tiles.FillData(this.totalizer);
      }
      this.Grid_ReducedGrid=function() {
        if (!this.box_tiles.IsHidden())
          this.box_tiles.FillData(this.totalizer);
      }

    }
  }
  this.SetToolbarBox=function() {
    var toolbar=this.toolbar;
    var label=this.label;
    if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart'))){
      toolbar=this.toolbar2;
      label=this.label2;
    }
    if (toolbar) {
      toolbar.getRenderHeight=null;
      label.getRenderHeight=function(){
        if (this.Ctrl!=null){
          this.Ctrl.style.height='auto';
          var h=this.Ctrl.offsetHeight;
          this.lastRenderHeight=( (this.shrinkable=='true' ||h>this.minheight)?h:null)
          if (toolbar && !toolbar.IsHidden() && this.lastRenderHeight<SPTheme.portalZoomToolbarElementHeight) {
            this.lastRenderHeight=SPTheme.portalZoomToolbarElementHeight;
            this.Ctrl.style.height=this.lastRenderHeight+'px';
            toolbar.Ctrl.style.height=SPTheme.portalZoomToolbarElementHeight+'px';
          } else {
            toolbar.Ctrl.style.height=this.lastRenderHeight+'px';
          }
        } else {
          this.lastRenderHeight=null
        }
        return this.lastRenderHeight
      }
      toolbar.setCtrlPos(
        toolbar.ctrl,toolbar.leftposition,toolbar.topposition,toolbar.controlwidth,
        SPTheme.portalZoomToolbarElementHeight,toolbar.anchor,this.width,
        this.height,false,false
      );
      toolbar.IconWidth(SPTheme.portalZoomToolbarElementHeight);
    }
  }
  this.mergeColStruct=function(newColStruct) {
    var i, j, orderby=false;
    this.vzmstructure.Cols=[];
    for (i=0;i<newColStruct.length;i++) {
      if (this.tmpStructure[newColStruct[i].id]){
        this.vzmstructure.Cols[i]=this.tmpStructure[newColStruct[i].id];
        this.vzmstructure.Cols[i].inExtGrid=newColStruct[i].inExtGrid;
        this.vzmstructure.Cols[i].hidden=newColStruct[i].hidden;
        this.vzmstructure.Cols[i].tileVisibility=newColStruct[i].tileVisibility||'base';
        this.vzmstructure.Cols[i].show_extra_title=newColStruct[i].show_extra_title;
        this.vzmstructure.Cols[i].extracolidx=newColStruct[i].extracolidx;
        this.vzmstructure.Cols[i].orderbystatus=newColStruct[i].orderbystatus;
        this.vzmstructure.Cols[i].orderbyidx=newColStruct[i].orderbyidx;
      }
      else {
        this.vzmstructure.Cols[i]=JSON.parse(JSON.stringify(newColStruct[i]));
      }
      this.vzmstructure.Cols[i].Layer=[];
      for (j=0; j<newColStruct[i].Layer.length; j++){
        if (this.tmpStructure[newColStruct[i].Layer[j].id]){
          this.vzmstructure.Cols[i].Layer[j]=this.tmpStructure[newColStruct[i].Layer[j].id];
          this.vzmstructure.Cols[i].Layer[j].inExtGrid=newColStruct[i].Layer[j].inExtGrid;
          this.vzmstructure.Cols[i].Layer[j].hidden=newColStruct[i].Layer[j].hidden;
          this.vzmstructure.Cols[i].Layer[j].show_extra_title=newColStruct[i].Layer[j].show_extra_title;
          this.vzmstructure.Cols[i].Layer[j].extracolidx=newColStruct[i].Layer[j].extracolidx;
        }
        else {
          this.vzmstructure.Cols[i].Layer[j]=newColStruct[i].Layer[j];
        }
      }
      if (this.vzmstructure.Cols[i].orderbyidx!=0 && !Empty(this.vzmstructure.Cols[i].orderbystatus))
        orderby=true;
    }
    this.vzmstructure.Configuration.OrderBy=orderby?'true':'false'
  }
  this.mergeRowLayerStruct=function(newRowLayerStruct) {
    var i;
    this.vzmstructure.RowLayer=[];
    for (i=0;i<newRowLayerStruct.length;i++) {
      if (this.tmpStructure[newRowLayerStruct[i].id]){
        this.vzmstructure.RowLayer[i]=this.tmpStructure[newRowLayerStruct[i].id];
        this.vzmstructure.RowLayer[i].inExtGrid=newRowLayerStruct[i].inExtGrid;
        this.vzmstructure.RowLayer[i].hidden=newRowLayerStruct[i].hidden;
        this.vzmstructure.RowLayer[i].show_extra_title=newRowLayerStruct[i].show_extra_title;
        this.vzmstructure.RowLayer[i].extracolidx=newRowLayerStruct[i].extracolidx;
      }
      else
        this.vzmstructure.RowLayer[i]=newRowLayerStruct[i];
    }
  }
  this.mergeFiltersStruct=function(newFiltersStruct) {
    if (typeof(newFiltersStruct)=='object' && typeof(newFiltersStruct.length)=='number') {
      var i;
      this.vzmstructure.ArrayFilters=[];
      for (i=0;i<newFiltersStruct.length;i++) {
        if (newFiltersStruct[i].field){
          var obj={};
          obj[newFiltersStruct[i].field]=newFiltersStruct[i].expression;
          obj[newFiltersStruct[i].field+'_op']=newFiltersStruct[i].operator;
          obj[newFiltersStruct[i].field+'_fixed']=false;
          obj[newFiltersStruct[i].field+'_visible']=true;
          this.vzmstructure.ArrayFilters.push(obj);
        }
        else
          this.vzmstructure.ArrayFilters.push(newFiltersStruct[i]);
      }
    }
  }
  this.applyZoom=function(newColStruct,newRowLayerStruct,newFiltersStruct,totalsPosition,totalsStarting) {
    this.mergeColStruct(newColStruct);
    if (newRowLayerStruct)
      this.mergeRowLayerStruct(newRowLayerStruct);
    this.mergeFiltersStruct(newFiltersStruct);
    if (totalsPosition && totalsStarting){
      this.vzmstructure.Configuration.TotalsPosition=totalsPosition;
      this.vzmstructure.Configuration.TotalsStarting=totalsStarting;
    }
    this.yet_done=false;
    this.Grid.dontupdate=true;
    if (this.GridChart)
      this.GridChart.dontupdate=true;
    this.dataobj.firstQuery('true','',this.vzmstructure);
    if (this.dataobj2){
      try{
      this.dataobj2.firstQuery('true','',this.vzmstructure);
      }
      catch(e){}
    }
    this.$entity$_GetConfigurationField.Emit();
    var filters=this.Grid.Filters.slice();
    this.updateFilters();
    for (i=0; i<filters.length; i++){
      if (filters[i].fixed){
        this.Grid.AddFilter(
          this.Grid.MakeFilter(filters[i].field,filters[i].operator,filters[i].expression,
            filters[i].type,filters[i].fixed, filters[i].userFilter,filters[i].defaultFilter
          ), filters[i].visible
        );
      }
    }
    this.Grid.dontupdate=false;
    if (this.GridChart)
      this.GridChart.dontupdate=false;
    this.getZoomtitlesRefsByProperty('SetButtons', function(titlePortlet) {
      titlePortlet.SetButtons(this.formid,this.ConfigGridElements.Value(),this.autozoomCanAdd && !EmptyString(this.Grid.splinker))
    });

    this.getZoomtitlesRefsByProperty('updateFilterButton', function (titlePortlet) {
      titlePortlet.updateFilterButton(this.formid, newFiltersStruct.length > 0, newColStruct.filter(function (col) { return col.orderbyidx > 0;}).length > 0);
    });
    if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart'))){
      this.GridChart_FiltersCreated();
    }
    this.dataobj.Query();
    if (this.menu_versioni) this.menu_versioni.CloseMenu();
  }
  var cfgSaverId=this.formid+"_cfgSaver";

  this.updateFilters=function(){
    if (typeof(this.vzmstructure.ArrayFilters)=='object' && typeof(this.vzmstructure.ArrayFilters.length)=='number') {
      var newfilters=[];
      newfilters.row={removeFixed:true};
      var i;
      for (i=0;i<this.vzmstructure.ArrayFilters.length;i++) {
        if (!this.vzmstructure.ArrayFilters[i].hidden) {
          newfilters.push(this.vzmstructure.ArrayFilters[i]);
        }
      }
      this.SetFilter(newfilters,true);
    }
  }

  this.updateFilterVisibility=function(){
    for (var i=0; i<this.Grid.Filters.length; i++){
      var f=this.Grid.Filters[i]
      // if (f.userFilter || f.fixed){
        var found=false,j,k,c,cl,rl;
        for (j=0; j<this.Grid.Cols.length && !found; j++){
          c=this.Grid.Cols[j];
          if (Lower(f.field)==Lower(clearField(c.field))){
            found=true;
            if (c.hidden)
              f.visible=false;
            else f.visible=true;
          }
          for (k=0;k<c.Layer.length && !found;k++){
            cl=c.Layer[k];
            if (Lower(f.field)==Lower(clearField(cl.field))){
              found=true;
              if (cl.hidden)
                f.visible=false;
              else f.visible=true;
            }
          }
        }
        for (j=0; j<this.Grid._rowLayer.length && !found; j++){
          rl=this.Grid._rowLayer[j];
          if (Lower(f.field)==Lower(clearField(rl.field))){
            found=true;
            if (rl.hidden)
              f.visible=false;
            else f.visible=true;
          }
        }
        if (!found)
          f.visible=false;
      }
    // }
  }

  this.saveZoom=function(newColStruct,newRowLayerStruct,newFiltersStruct,_saveas,totalsPosition,totalsStarting,configName,hideZoomVersion) {
    if (typeof(newFiltersStruct)=='boolean') {
      _saveas=newFiltersStruct;
      newFiltersStruct=null;
    }
    this.confirmZoom=function(newcfg) {
      var oldVzmStructure=JSON.parse(JSON.stringify(this.vzmstructure));
      var oldFilters=JSON.parse(JSON.stringify(this.Grid.Filters));
      this.mergeColStruct(newColStruct);
      this.mergeRowLayerStruct(newRowLayerStruct);
      this.mergeFiltersStruct(newFiltersStruct);
      if (totalsPosition && totalsStarting){
        this.vzmstructure.Configuration.TotalsPosition=totalsPosition;
        this.vzmstructure.Configuration.TotalsStarting=totalsStarting;
      }
      if (newcfg.indexOf("1/")===0){
        this.vzmstructure.Configuration.Custom="true";
        newcfg=newcfg.substring(2);
      }
      else if (newcfg.indexOf("0/")===0){
        this.vzmstructure.Configuration.Custom="false";
        newcfg=newcfg.substring(2);
      }
      var u_g=new RegExp(/_g\d+$/).exec(newcfg);
      if (u_g){
        this.vzmstructure.Configuration.Group=u_g[0].substring(2);
        this.vzmstructure.Configuration.User='0';
      }
      else {
        u_g=new RegExp(/_\d+$/).exec(newcfg);
        if (u_g)
          this.vzmstructure.Configuration.User=u_g[0].substring(1);
        else
          this.vzmstructure.Configuration.User='0';
        this.vzmstructure.Configuration.Group='0';
      }
      newcfg=newcfg.replace(/_g?\d+$/,"");
      this.ConfigName.Value(newcfg);
      var idx = newcfg.indexOf('__');
      if (idx>-1) {
        newcfg=newcfg.substring(idx+2);
        if (this.vzmstructure.Configuration.Versions.indexOf(newcfg)==-1 && !hideZoomVersion)
          this.vzmstructure.Configuration.Versions.push(newcfg);
      }
      this.yet_done=false;
      this.Grid.dontupdate=true;
      this.dataobj.firstQuery('true','',this.vzmstructure);
      this.$entity$_GetConfigurationField.Emit();
      var filters=JSON.parse(JSON.stringify(this.Grid.Filters));
      this.updateFilters();
      for (var i=0; i<filters.length; i++){
        if (filters[i].fixed){
          this.Grid.AddFilter(
            this.Grid.MakeFilter(filters[i].field,filters[i].operator,filters[i].expression,
              filters[i].type,filters[i].fixed, filters[i].userFilter,filters[i].defaultFilter
            ), filters[i].visible
          );
        }
      }
      this.dataobj.queryfilter=this.Grid.CreateFilter(false, true)
      this.Grid.dontupdate=false;
      if(!this.cfgSaver){
        // eslint-disable-next-line no-cond-assign
        if(this.cfgSaver=ZtVWeb.getPortletInc(cfgSaverId)){
          this.cfgSaver.setContainer(this,'cfgSaver');
          this.cfgSaver_ctrl=new ZtVWeb.PortletCtrl(this,cfgSaverId,'cfgSaver',null,null,300,0,'top-left-right');
        }
      }
      if(!this.cfgSaver){ //nel 99% dei casi non si e' loggati
        alert(this.Grid.Translations["error_saving_config"]);
        return;
      }
      this.cfgSaver.Save(this);
      if (hideZoomVersion){
        this.vzmstructure=oldVzmStructure;
        this.mergeFiltersStruct(oldFilters);
        this.yet_done=false;
        this.Grid.dontupdate=true;
        this.Grid.filters=oldFilters;
        this.dataobj.firstQuery('true','',this.vzmstructure);
        this.$entity$_GetConfigurationField.Emit();
        filters=JSON.parse(JSON.stringify(this.Grid.Filters));
        this.updateFilters();
        for (i=0; i<filters.length; i++){
          if (filters[i].fixed){
            this.Grid.AddFilter(
              this.Grid.MakeFilter(filters[i].field,filters[i].operator,filters[i].expression,
                filters[i].type,filters[i].fixed, filters[i].userFilter,filters[i].defaultFilter
              ), filters[i].visible
            );
          }
        }
        this.Grid.dontupdate=false;
      }
      if (this.menu_versioni) this.menu_versioni.CloseMenu();
      this.confirmZoom=null;
    }
    if (_saveas){
      this.oldConf=this.ConfigName.Value();
      this.confirmZoom(configName);
    }
    else {
      this.oldConf='';
      this.confirmZoom(this.ConfigName.Value());
    }
    this.getZoomtitlesRefsByProperty('SetButtons', function(portlet){
      portlet.SetButtons(this.formid,this.ConfigGridElements.Value(),this.autozoomCanAdd && !EmptyString(this.Grid.splinker))
    })
  }
  this.this_SaveOk=function(){
    this.dataobj.Query();
  };
  this.deleteZoom=function(){
    this.ChangeVersion(-1,true);
  }
  this.OpenSmartEditor=function() {
    if(!this.cfgSaver_loaded){
      var dock = document.createElement('div');
      dock.style.display='none';
      dock.style.position='relative';
      dock.id = cfgSaverId;
      this.Ctrl.appendChild(dock);
      this.cfgSaver_loaded = 200==ZtVWeb.Include("../jsp-system/SPPortalZoomConfigurationBuilder_portlet.jsp", cfgSaverId,true);
    }
    var cols = [], col, c, l, i, previousPicture, gridcol;
    this.tmpStructure={};
    for (i=0; i<this.vzmstructure.Cols.length; i++){
      c = this.vzmstructure.Cols[i];
      gridcol=this.Grid.GetColById(c.id);
      this.tmpStructure[c.id]=c;
      previousPicture=c.picture||"";
      if (typeof(c.type)=='undefined') this.Grid.setColType(c);
      c.picture=previousPicture;
      col = {
        id:c.id,
        type:c.type,
        field:c.field,
        title:c.title,
        title2:c.title2||c.title,
        hidden:c.hidden,
        inExtGrid:c.inExtGrid,
        Layer : [],
        show_extra_title:c.show_extra_title,
        extracolidx:c.extracolidx,
        orderbystatus:gridcol.orderbystatus,
        orderbyidx:gridcol.orderbyidx
      }
      for (var j=0; j<this.vzmstructure.Cols[i].Layer.length; j++){
        l = this.vzmstructure.Cols[i].Layer[j];
        this.tmpStructure[l.id]=l;
        previousPicture=l.picture||"";
        if (typeof(l.type)=='undefined') this.Grid.setColType(l);
        l.picture=previousPicture;
        col.Layer.push({
          id:l.id,
          type:l.type,
          field:l.field,
          title:l.title,
          title2:l.title2||l.title,
          hidden:l.hidden,
          inExtGrid:l.inExtGrid,
          show_extra_title:l.show_extra_title,
          extracolidx:l.extracolidx
        })
      }
      if (!Empty(this.vzmstructure.Cols[i].exp)){
        col.tile=this.vzmstructure.Cols[i].descr||this.vzmstructure.Cols[i].title_trad||this.vzmstructure.Cols[i].field;
        col.tileVisibility=this.vzmstructure.Cols[i].tileVisibility;
      }
      cols.push(col);
    }
    var rowLayer=[], rl;
    for (i=0; i<this.vzmstructure.RowLayer.length; i++){
      rl = this.vzmstructure.RowLayer[i];
      this.tmpStructure[rl.id]=rl;
      if (typeof(rl.type)=='undefined') this.Grid.setColType(rl);
      rowLayer.push({
        id:rl.id,
        type:rl.type,
        field:rl.field,
        title:rl.title,
        title2:rl.title2||rl.title,
        hidden:rl.hidden,
        inExtGrid:rl.inExtGrid,
        show_extra_title:rl.show_extra_title,
        extracolidx:rl.extracolidx
      })
    }

    var height_width;
    if (ZtVWeb.IsMobile() || (window.SPTheme && SPTheme['activateModalPopup']||false)) {
      height_width=''
    } else {
      height_width='650'
    }
    var filters;
    if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart')))
      filters=this.GridChart.Filters;
    else
      filters=this.Grid.Filters;
    this.refresh_menu.CloseMenu();
    if (this.menu_versioni)
      this.menu_versioni.CloseMenu();
    windowOpenForeground('../portalzoom/editZoom.jsp?zoomUID='+URLenc(this.formid)+'&zoomName='+URLenc(this.ConfigName.Value()||'default')+
      '&zoomFields='+URLenc(JSON.stringify(cols))+'&rowLayer='+URLenc(JSON.stringify(rowLayer))+'&filters='+URLenc(JSON.stringify(filters))+
      '&totalsPosition='+URLenc(this.vzmstructure.Configuration.TotalsPosition||'')+'&totalsStarting='+URLenc(this.vzmstructure.Configuration.TotalsStarting||'')+
      '&caption='+URLenc(caption)+'&versionName='+URLenc(this.GetCurrentVersion())+'&vqrName='+URLenc(this.VQRName.Value())+'&tableName='+URLenc(this.Table.Value())+
      '&viewMode='+URLenc(viewMode)+"&hideFilter="+URLenc(this.vzmstructure.Configuration.filters=="false")+"&user="+URLenc(this.Specific.User)+
      "&group="+URLenc(this.Specific.Group)+"&custom="+URLenc(this.Specific.Custom),
      '_blank',
      'toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,width='+
      height_width+',height='+height_width+',left='+(window.screen.width/2-325)+',top='+(window.screen.height/2-325));
  }

  this.getReports=function(){
    function getLabelFileName(mfile, defaultName) {
      var ret = "";
      if (Empty(defaultName))
        ret = mfile.slice(mfile.indexOf("__") + 2);
      else if (mfile.indexOf(configName) >= 0)	// versione
        ret = mfile.split("__")[2];
      else if (mfile.indexOf(defaultName) >= 0)	// defualt
        ret = "[default] " + mfile.split("__")[1];
      return ret;
    }
    var reports={};
    var configName = (this.ConfigName.Value()||'default')+'.'+this.Table.Value();
    var defName = this.ConfigName.Value()||'default';
    var idx=defName.indexOf('__');
    if (idx>-1){
      defName=defName.substring(0,idx)+'.'+this.Table.Value();
    }
    else defName='';
    var list = new JSURL("../servlet/SPReportGet?action=getSmartReportVFiles&filename=" + configName, true);
    list = list.Response();
    if (!Empty(list)) {
      var mfiles = list.split(",");
      for (var i = 0; i < mfiles.length; i++) {
        var custom=false;
        var fname = mfiles[i].slice(0, mfiles[i].indexOf(".svrp"));
        if ( fname.indexOf("1/") == 0) {	// e' custom
          fname = Strtran(fname, "1/", "");
          custom=true;
        }
        var label=getLabelFileName(fname, defName);
        if (!reports[label])
          reports[label]={value:fname,custom:custom}
        else reports[label].custom=true;
      }
    }
    return reports;
  }

  this.getFieldsForPrint=function(){
    // column
    var ret = [],
    idx = 0,
    cols = [],
    i, j;
    // faccio un array con tutte le colonne
    for (i = 0; i < this.vzmstructure.Cols.length; i++) {
      if (!("printable" in this.vzmstructure.Cols[i]))
        this.vzmstructure.Cols[i].printable = true; // retrocomp.
      if (this.vzmstructure.Cols[i].printable) {
        cols.push(this.vzmstructure.Cols[i].field);
        for (j = 0; j < this.vzmstructure.Cols[i].Layer.length; j++) {
          cols.push(this.vzmstructure.Cols[i].Layer[j].field)
        }
      }
    }
    for (i = 0; i < this.vzmstructure.RowLayer.length; i++) {
      cols.push(this.vzmstructure.RowLayer[i].field);
    }
    var fds = Object.keys( this.vzmstructure.HideFields );
    for (i = 0; i < fds.length; i++) {
      cols.push(fds[i])
    }
    var typeFields=new JSURL("../servlet/SPVQRProxy?action=typeField&filename=" + this.VQRName.Value()+"&fields="+URLenc(cols.toString()), true).Response();
    typeFields=JSON.parse(typeFields);
    // column layer
    for (i = 0; i < this.vzmstructure.Cols.length; i++) {
      var col = this.vzmstructure.Cols[i];
      idx = cols.indexOf(col.field);
      if (idx >= 0 && !col.hidden && col.printable) {
        ret.push({
          alias : col.field,
          desc : col.title_trad||col.title,
          type : typeFields[idx][0],
          len : typeFields[idx][1],
          dec : typeFields[idx][2],
          collayer : false,
          extfield : false,
          hiddenfield : false,
          rowlayer : false
        });
      }
      //idx++;
      for (j = 0; j < col.Layer.length; j++) {
        var coll = col.Layer[j];
        idx = cols.indexOf(coll.field);
        if (idx >= 0 && !col.hidden && !coll.hidden && col.printable && coll.printable)
          ret.push({
            alias : coll.field,
            desc : coll.title_trad||coll.title,
            type : typeFields[idx][0],
            len : typeFields[idx][1],
            dec : typeFields[idx][2],
            collayer : true,
            extfield : false,
            hiddenfield : false,
            rowlayer : false
          });
        //idx++;
      }

    }

    // row layer
    for (i = 0; i < this.vzmstructure.RowLayer.length; i++) {
      var row = this.vzmstructure.RowLayer[i];
      idx = cols.indexOf(row.field);
      if (idx >= 0 && !row.hidden && row.printable)
        ret.push({
          alias : row.field,
          desc : row.title_trad||row.title,
          type : typeFields[idx][0],
          len : typeFields[idx][1],
          dec : typeFields[idx][2],
          collayer : false,
          extfield : false,
          hiddenfield : false,
          rowlayer : true
        });
      //idx++;
    }

    // hidden
    for (i = 0; i < fds.length; i++) {
      idx = cols.indexOf(fds[i]);
      if (idx >= 0) {
        ret.push({
          alias : fds[i],
          desc : '',
          type : typeFields[idx][0],
          len : typeFields[idx][1],
          dec : typeFields[idx][2],
          collayer : false,
          extfield : false,
          hiddenfield : true,
          rowlayer : false
        });
      }
      //idx++;
    }
    return JSON.stringify( ret );
  }

  this.OpenEditor=function() {
    if(!this.cfgSaver_loaded){
      var dock = document.createElement('div');
      dock.style.display='none';
      dock.style.position='relative';
      dock.id = cfgSaverId;
      this.Ctrl.appendChild(dock);
      this.cfgSaver_loaded = 200==ZtVWeb.Include("../jsp-system/SPPortalZoomConfigurationBuilder_portlet.jsp", cfgSaverId,true);
    }
    this.refresh_menu.CloseMenu();
    if (this.menu_versioni)
      this.menu_versioni.CloseMenu();
    window.open('../portalstudio/portalstudio.jsp?tool=portalzoom&id='+URLenc((this.ConfigName.Value()||'default')+'['+this.Table.Value()+']')+'&custom='+(this.vzmstructure.Configuration.Custom=='true'),'_blank','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,width='+(window.screen.width-150)+',height='+(window.screen.height-150));
    var _this=this;
    window.ReportZoomConfiguration=function() {
      _this.LoadConfiguration(_this.ConfigName.Value()); //forzare il ricaricamento dopo salvataggio
    }
  }
  this.getColumns=function() {
    return JSON.stringify(this.Grid.Cols);
  }

  var reload=true;
  var viewHeaderFromConfig=true;
  var viewToolbarFromConfig=false;
  var paramAutozoom='', paramEntityType='';
  var isHistoricalZoom=false;
  var caption='';
  var configModeSecurity=this.configModeSecurity;
  this.printModeSecurity = (typeof this.printModeSecurity == "undefined" ? true : this.printModeSecurity);
  this.vdmName=this.vzmstructure.Configuration.vdmName;
  delete this.vzmstructure.Configuration.vdmName;
  this.GetConfigurationField=function(){
    var obj={};
    for (var i=0; i<this.vzmstructure.Cols.length; i++){
      if (!this.vzmstructure.Cols[i].isImage && !ZtVWeb.isExpr(this.vzmstructure.Cols[i].field) && !this.dataobj.isCalculated(this.vzmstructure.Cols[i].field)){
        if (typeof(this.vzmstructure.Cols[i].type)=='undefined') this.Grid.setColType(this.vzmstructure.Cols[i]);
        if (!obj[this.vzmstructure.Cols[i].field] || obj[this.vzmstructure.Cols[i].field].hidden)
          obj[this.vzmstructure.Cols[i].field]={
            title:this.vzmstructure.Cols[i].title_trad || this.vzmstructure.Cols[i].title,
            type:this.vzmstructure.Cols[i].type,
            hidden:this.vzmstructure.Cols[i].hidden
          }
      }
      if (this.vzmstructure.Cols[i].Layer && this.vzmstructure.Cols[i].Layer.length>0){
        for (var j=0; j<this.vzmstructure.Cols[i].Layer.length; j++){
          if (!this.vzmstructure.Cols[i].Layer[j].isImage
            && !ZtVWeb.isExpr(this.vzmstructure.Cols[i].Layer[j].field)
            && !this.dataobj.isCalculated(this.vzmstructure.Cols[i].Layer[j].field)){
            if (typeof(this.vzmstructure.Cols[i].Layer[j].type)=='undefined') this.Grid.setColType(this.vzmstructure.Cols[i].Layer[j]);
            if (!obj[this.vzmstructure.Cols[i].Layer[j].field] || obj[this.vzmstructure.Cols[i].Layer[j].field].hidden)
              obj[this.vzmstructure.Cols[i].Layer[j].field]={
                title:this.vzmstructure.Cols[i].Layer[j].title_trad || this.vzmstructure.Cols[i].Layer[j].title,
                type:this.vzmstructure.Cols[i].Layer[j].type,
                hidden:this.vzmstructure.Cols[i].Layer[j].hidden
              }
          }
        }
      }
    }
    for (i=0; i<this.vzmstructure.RowLayer.length; i++){
      if (!this.vzmstructure.RowLayer[i].isImage && !ZtVWeb.isExpr(this.vzmstructure.RowLayer[i].field) && !this.dataobj.isCalculated(this.vzmstructure.RowLayer[i].field)){
        if (typeof(this.vzmstructure.RowLayer[i].type)=='undefined') this.Grid.setColType(this.vzmstructure.RowLayer[i]);
        if (!obj[this.vzmstructure.RowLayer[i].field] || obj[this.vzmstructure.RowLayer[i].field].hidden)
          obj[this.vzmstructure.RowLayer[i].field]={
            title:this.vzmstructure.RowLayer[i].title,
            type:this.vzmstructure.RowLayer[i].type,
            hidden:this.vzmstructure.RowLayer[i].hidden
          }
      }
    }
    for (var hf in this.vzmstructure.HideFields){
      obj[hf]={
        title:hf,
        type:'C',
        hidden:true
      }
    }
    return obj;
  }

  this.HideCaption=function() {
    this.label.Value('');
    this.label.Ctrl.style.display='none'; //si deve usare display='none' e non visibility='hidden' per eliminare lo spazio occupato
    if (this.label2){
      this.label2.Value('')
      this.label2.Ctrl.style.display='none';
    }
    // this.Grid.topposition=0;
    // this.Grid.Ctrl.style.top=0; //la griglia viene riposizionata troppo tardi e c'e un problema di render iniziale
  }
  this.ShowCaption=function() {
    this.label.Ctrl.style.display='';
    if (this.label2) {
      this.label2.Ctrl.style.display='';
    }
  }
  this.GetVersionsImage=function() {
  if (this.menu_versioni) {
    var versionColumn = this.menu_versioni.GetItem("versioni");
    if (
      !ZtVWeb.IsMobile() &&
      this.configModeSecurity>0 || (
        this.vzmstructure &&
        this.vzmstructure.Configuration &&
        this.vzmstructure.Configuration.Versions &&
        this.vzmstructure.Configuration.Versions.length>0
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
        this.menu_versioni.Append({
          id : 'smarteditor'
        , title : this.Grid.Translations['Edit_Version']||'Modifica versione'
        , tooltip : this.Grid.Translations['Edit_Version']||'Modifica versione'
        , image : SPTheme.portalZoomVersionsImage||''
        , action : 'javascript:' + this.formid+".OpenSmartEditor()"
        },'versioni',0);
        if (this.configModeSecurity==2) {
          this.menu_versioni.Append({
            id : 'portalzoomeditor'
          , title : this.Grid.Translations['Full_Editor']||'Editor completo'
          , tooltip : this.Grid.Translations['Full_Editor']||'Editor completo'
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
    // this.refresh_menu.Hide();
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
          this.menu_versioni.SetHandler(span);
          LibJavascript.Events.addEvent(span, "click", function(e){e.stopPropagation();this.menu_versioni.ToggleMenu(span);}.bind(this));
          span.innerText = String.fromCharCode(img.Char);
          // version = "<span class='SPPortalZoom_versionhandler' onclick='"+this.formid+".menu_versioni.OpenMenu(this);event.stopPropagation();' onselectstart='return false;'>"+String.fromCharCode(img.Char)+"</span>";
        } else {
          var image = document.createElement("img");
          image.className = "SPPortalZoom_versionhandlerimage";
          image.src = img;
          LibJavascript.Events.addEvent(image, "click", function(e){e.stopPropagation();this.menu_versioni.ToggleMenu(image);}.bind(this));
          frag.appendChild(image);
          // version = " <img class='SPPortalZoom_versionhandlerimage' style='cursor:pointer;' src='"+img+"' onclick='"+this.formid+".menu_versioni.OpenMenu(this)' onselectstart='return false;'></img>";
        }

      }
    }
    return frag;
  }
  this.ChangeVersion=function(i,forceLoad) {
    var vers = (i>-1 ? this.vzmstructure.Configuration.Versions[i] : "");
    this.refresh_menu.CloseMenu();
    if (this.menu_versioni)
      this.menu_versioni.CloseMenu();
    // this.menu_versioni.menuClose(true);
    // if (!Empty(vers))
    this.LoadVersion(vers,forceLoad);
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
    } else if(this.vzmstructure && this.vzmstructure.Configuration && !EmptyString(this.vzmstructure.Configuration.Caption) ) {
      cpt=this.vzmstructure.Configuration.Caption_trad || this.vzmstructure.Configuration.Caption;
      caption=cpt;
      this.label.Value(ToHTML(cpt));
      if (this.label2){
        this.label2.Value(ToHTML(cpt));
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
  this.GetCaption=function(){
    if (this.hasZoomtitlesID('SetCaption')) {
      return this.getZoomtitlesRefsByProperty('SetCaption', function(decorator){
        return decorator.Caption.Value();
      });
    } else {
      return this.Caption.Value();
    }
  }
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
  if (this.refresh_menu)
    InitializeMenu.call(this);
  this.Grid_GridRenderNewSplinker=function() {
    return false;
  }
  function HamburgerInit() {
    var gridName = (viewMode==='chart' ? 'GridChart' : 'Grid' );
    var oldRendered = this[gridName+'_Rendered'];
    this[gridName+'_Rendered']=function() {
      var grdRefresh = document.getElementById(this[gridName].ctrlid + "_gridrefresh");
      if (grdRefresh && !advanced_suggester_active) {
        if(viewMode=='card' && !this.Grid.renderTitles) {//
          this.refresh_menu.Show('right','SPPortalZoomBaseMenuRight');
          LibJavascript.CssClassNameUtils.removeClass(this.refresh_menu.Ctrl,'SPPortalZoomBaseMenu');
          LibJavascript.CssClassNameUtils.addClass(this.refresh_menu.Ctrl,'SPPortalZoomBaseMenuRight');
        } else {
          this.refresh_menu.Show();
        }
        grdRefresh.appendChild(this.refresh_menu.Ctrl);
        //azzero gli spazi creati dallo skin
        this.refresh_menu.Ctrl.style.position='relative';
        if (viewMode=='card'){
          grdRefresh.style.float='left';
          if(this.Grid.renderTitles) {//
            grdRefresh.className='grid_title grid_cell_extra_title';
          }
          grdRefresh.style.padding='0px';
          grdRefresh.style.margin='0px';
        }
        else {
          grdRefresh.parentNode.style.padding='0px';
          grdRefresh.parentNode.style.margin='0px';
        }
      }
      if (oldRendered)
        oldRendered.call(this);
      this[gridName+'_Rendered']=oldRendered;
      oldRendered = null;
    }
    HamburgerInitReady=function(){};
    return "<div id='" + this[gridName].ctrlid + "_gridrefresh' class='ZoomGridRefreshContainer' ></div>";
  }
  var HamburgerInitReady;
  SetHamburgerInit.call(this);
  function SetHamburgerInit() { //da chiamare con this->portlet
    if (viewHeaderFromConfig && this.hasZoomtitlesID('SetButtons')) {
      HamburgerInitReady=function(){};
    } else {
      HamburgerInitReady=HamburgerInit;
    }
  }
  this.Grid_GridRefreshContent=this.Grid_GridNewSplinkerContent=this.GridChart_GridRefreshContent=function() {
    return HamburgerInitReady.call(this);
  }
  this.GetCurrentVersion=function() {
    var versions = this.vzmstructure.Configuration.Versions||[];
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
  this._UpdateVersionsSubMenu=function(menu) {
    if (menu) {
      this.menu_used = menu;
    }
    if (this.vzmstructure && this.vzmstructure.Configuration && this.vzmstructure.Configuration.Versions) {
      this.vzmstructure.Configuration.Versions=this.vzmstructure.Configuration.Versions.sort();
      var versions = this.vzmstructure.Configuration.Versions;
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
  this.refresh_menu_BeforeMenuOpen=function() {
    var versionColumn = this.refresh_menu.GetItem("versioni");
    if (!this.splinker.offline &&
      this.configModeSecurity>0 || (
        this.vzmstructure &&
        this.vzmstructure.Configuration &&
        this.vzmstructure.Configuration.Versions &&
        this.vzmstructure.Configuration.Versions.length>0
      )
    ) {
      if (!versionColumn) {
        this.refresh_menu.Append({
          id: 'versioni'
        , title: this.Grid.Translations['Versions']||'Versioni'
        , tooltip: this.Grid.Translations['Versions']||'Versioni'
        },null,1);
      } else {
        this.refresh_menu.Clean('versioni');
      }
      if (!ZtVWeb.IsMobile()){
        if (this.configModeSecurity>0){
          this.refresh_menu.Append({
            id : 'smarteditor'
          , title : this.Grid.Translations['Edit_Version']||'Modifica versione'
          , tooltip : this.Grid.Translations['Edit_Version']||'Modifica versione'
          , image: SPTheme.portalZoomVersionsImage||''
          , action : 'javascript:' + this.formid+".OpenSmartEditor()"
          },'versioni',0);
          if (this.configModeSecurity==2) {
            this.refresh_menu.Append({
              id : 'portalzoomeditor'
            , title : this.Grid.Translations['Full_Editor']||'Editor completo'
            , tooltip : this.Grid.Translations['Full_Editor']||'Editor completo'
            , image : SPTheme.portalZoomEditorImage||''
            , action : 'javascript:' + this.formid+".OpenEditor()"
            },'versioni',1);
          }
        }
      }
      this._UpdateVersionsSubMenu(this.refresh_menu);

    } else if (versionColumn) {
      this.refresh_menu.Remove('versioni');
    }
      var linkedConfs = this.vzmstructure.Configuration.linkedConfs;
      var img;
      if (linkedConfs && linkedConfs.length>0) {
        var linkedConfColumn = this.refresh_menu.GetItem("linkedconfiguration");
        if (!linkedConfColumn) {
          this.refresh_menu.Append({
            id: 'linkedconfiguration'
          , title: this.Grid.Translations['Views']||'Visualizzazioni'
          , tooltip: this.Grid.Translations['Views']||'Visualizzazioni'
          },null,2);
        } else {
          this.refresh_menu.Clean('linkedconfiguration');
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
          this.refresh_menu.Append({
            title : linkedConfs[ii].title_trad || ''
          , tooltip : linkedConfs[ii].title_trad || ''
          , image: img
          , action : 'javascript:'+this.formid+'.ChangeConfiguration('+(ii)+')'
          },'linkedconfiguration');
        }
      } else {
        this.refresh_menu.Remove('linkedconfiguration');
      }
  }
  this.refresh_menu_AfterMenuOpen=function() {
    this.refresh_menu.ShowItem('additem',this.ConfigGridElements.Value().indexOf("-n")==-1 && this.autozoomCanAdd && !EmptyString(this.Grid.splinker));
  }
  this.refreshFromMenu=function() {
    this.refreshQuery();
    this.refresh_menu.CloseMenu();
  }
  function InitializeMenu() {
    this.refresh_menu.Clean();
    var children = [];
    children.push({
            id: 'additem',
            title:this.Grid.Translations["New"],
            image:SPTheme.portalZoomAddRecordImage||'',
            action : function() {
              zoom_portlet.AddNewRecord();
              zoom_portlet.refresh_menu.CloseMenu();
            }
          });
    children.push({
              title: this.Grid.Translations["Refresh"],
              image:SPTheme.portalZoomRefreshImage||'',
              action : function() {
                zoom_portlet.refreshQuery();
                zoom_portlet.refresh_menu.CloseMenu();
              }
            });
    if ( !this.ConfigGridElements.Value().match(/-p/i) && this.printModeSecurity) { //canPrint
      if ( (typeof(this.vzmstructure.Configuration.PrintMode)=='undefined' || this.vzmstructure.Configuration.PrintMode!='None') ) {
        children.push({
                  title: this.Grid.Translations["Print"],
                  image: SPTheme.portalZoomPrintImage||'',
                  action : function() {
                    zoom_portlet.printZoom();
                    zoom_portlet.refresh_menu.CloseMenu();
                  }
                });
      }
    }
    if ((this.vzmstructure.Configuration.filters!="false" || !Empty(this.vdmName)) && this.vzmstructure.Configuration.hideFiltersBtn!='true'){
      children.push({
              title: this.Grid.Translations["Filters"],
              image: SPTheme.portalZoomShowVdmImage||'',
              action : function() {
                zoom_portlet.ShowVdmMask();
                zoom_portlet.refresh_menu.CloseMenu();
              }
            });
    }
    if(!EmptyString(this.Autozoom.Value()) && !EmptyString(this.PKFields.Value())){
      if (this.m_cAction && this.m_cAction.Value()=="autozoom" || this.vzmstructure.Configuration.LinkQuery=='force')
        this.Grid.autozoom=this.Autozoom.Value()+(this.m_cAltInterface?"?m_cAltInterface="+this.m_cAltInterface.Value():"");
        this.Grid.autozoom=this.Autozoom.Value()+(this.m_cZoneAltInterface?"?m_cZoneAltInterface="+this.m_cZoneAltInterface.Value():"");
    }

    if(this.vzmstructure.Configuration.LinkQuery!='false' && !EmptyString(this.Autozoom.Value()) && !EmptyString(this.PKFields.Value()) && ((this.m_cAction && this.m_cAction.Value()=="autozoom") || this.vzmstructure.Configuration.LinkQuery=='force')){
      children.push({
              title: this.Grid.Translations["Query"]||"Query",
              image: SPTheme.grid_img_action_query||'',
              action : function() {
                zoom_portlet.refresh_menu.CloseMenu();
                if(zoom_portlet.m_cZoneAltInterface){
                  window.location='../servlet/'+zoom_portlet.Autozoom.Value()+"?m_cZoneAltInterface="+zoom_portlet.m_cZoneAltInterface.Value();
                }else{
                  window.location='../servlet/'+zoom_portlet.Autozoom.Value()+(zoom_portlet.m_cAltInterface?"?m_cAltInterface="+zoom_portlet.m_cAltInterface.Value():"");;
                }
              }
            });
    }
    this.refresh_menu.Append({
      title:FormatMsg('MSG_ZOOM_ACTIONS'),
      children:children,
      id:'actions'
    });
    this.refresh_menu.Ctrl.style.height='';
    this.refresh_menu.Ctrl.style.width='';
    this.refresh_menu.Ctrl.style.top='';
    this.refresh_menu.Ctrl.style.left='';
    this.refresh_menu.setCtrlPos(this.refresh_menu.Ctrl,null,null,null,null,'top-left')
    // this.refresh_menu.setCtrlVars(0,0,0,0,'top-left');
  }
  this.SetZoomTitle=function(){
    if((this.ConfigGridElements.Value().match(/-h/i) || !viewHeaderFromConfig) && (this.hasZoomtitlesID('SetButtons') || this.hasZoomtitlesID('SetCaption'))) {
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
        portlet.SetButtons(this.formid,this.ConfigGridElements.Value(),this.autozoomCanAdd && !EmptyString(this.Grid.splinker));
      }, this);
      this.CaptionChanged();
    }
  }
  var manageDocumentTitle = false;
  this.CaptionChanged=function(){
    if (!this.ConfigGridElements.Value().match(/-h/i) && viewHeaderFromConfig) {
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
      // debugger
      // _this.raiseCaptionChange(caption, hideCaption);
      // _this.raiseStatusChange(EmptyString(caption)?'':"zoom");
      // })(this);
    // }
    if(document.title=="" || manageDocumentTitle){
      document.title = caption;
      manageDocumentTitle = true;
    }
  }

  this.AppendCssStyle=function() {
    this.getZoomtitlesRefsByProperty('SetCssStyle', function(portlet){
      portlet.SetCssStyle();
    });
        // var css = '#'+this.label.ctrlid+' img'+(this.label2 ? ', #'+this.label2.ctrlid+' img '+titlecss:'')+'{ cursor:pointer; position:relative; top: 2px; height: 12px; }',
            // head = document.head || document.getElementsByTagName('head')[0],
            // style = document.createElement('style');

        // style.type = 'text/css';
        // if (style.styleSheet){
          // style.styleSheet.cssText = css;
        // } else {
          // style.appendChild(document.createTextNode(css));
        // }

        // head.appendChild(style);

  }

  this.SetGridScroll=function(infinite){
    if (infinite){
      this.Grid.scroll_bars='infinite_scroll';
      this.Grid.nav_bar='false';
      this.Grid.showScrollBars=true;
      this.Grid.empty_rows='false';
      //Se � impostata l'altezza non faccio lo stretch 100% in altezza
      if(!this.GridMinHeight || Empty(this.GridMinHeight.Value())){
        /* Se mi trovo in una pagelet ma questa non e' stretch non posso forzare l'html a stretch */
        if(!this.pageletId) {
          document.querySelector('html').setAttribute("ps-stretch","");
        } /* else if(!document.querySelector('html').getAttribute("ps-stretch")){
          console.error("Zoom with infinite scroll without GridMinHeight in pagelet item non-stretch");
        } */
        LibJavascript.CssClassNameUtils.addClass(this.Ctrl,"stretch_height");
        LibJavascript.CssClassNameUtils.addClass(this.Ctrl_container,"stretch_height");
        this.stretch_height = true;
        this.Ctrl.style.height = '';
        this.Grid.anchor='top-left-right-bottom';
        this.Grid.stretchHeight=true;
        this.Grid.Ctrl.style.bottom='0px'
      }
    }
    else {
      this.Grid.scroll_bars='false';
      this.Grid.nav_bar='true';
      this.Grid.showScrollBars=false; //-------
      this.Grid.empty_rows='false';
      LibJavascript.CssClassNameUtils.removeClass(this.Ctrl,"stretch_height");
      LibJavascript.CssClassNameUtils.removeClass(this.Ctrl_container,"stretch_height");
      this.stretch_height=false;
      this.Grid.anchor='top-left-right';
      this.stretchHeight=null;
      this.Grid.Ctrl.style.bottom='';
    }
  }
  this.enablePreview = function(){
    if(this.Grid.hasInjectedRow() && this.Grid.oldToggleInjectedRow != null){
      if(this.Grid.oldToggleInjectedRow){
        this.Grid.toggleInjectedRow();
        this.Grid.oldToggleInjectedRow = null;
      }
    }
    this.Grid.enablePreview = true;
    this.Grid.togglePreviewRow(this.Grid.curRec);

  }
  this.disablePreview = function(){
    this.Grid.enablePreview = false;
    this.Grid.togglePreviewRow();
  }
  this.hasPreviewRow = function(){
    return this.Grid.hasPreviewRow();
  }
  this.SetGrid=function(){
    if (((','+this.PKFields.Value().toLowerCase()+',').indexOf(',cphstk,')!=-1 && this.FixedFilter.Value().toLowerCase().indexOf('cphstk=1')==-1) || !Empty(this.HistoryFilterDate.Value()))
      isHistoricalZoom=true;
    var rowsSetBySkin=false;
    this.SearchZoomTitle();
    this.AppendCssStyle();
    var canPrint=true;
    this.dataobj.count=this.QueryCount.Value() || "false";
    this.Grid.isZoom=true;
    if ( ZtVWeb.IsMobile() && !( this.PrintMode && this.PrintMode.Value() ) ) {
      if (!this.hasZoomtitlesID('SetCaption')) {
        this.HideCaption();
      } else {
        this.Grid.showFilterPortlet=false;
      }
    }
    this.Grid.row_preview_src = this.vzmstructure.Configuration.row_preview_src;
    this.Grid.oldTogglePreviewRow = -1;
    this.Grid.defaultPreviewRowSrc;

    this.Grid.togglePreviewRow = function (idx) {
      if( !this.enablePreview && idx != null ){
        return
      }
      if (this.form.getPagelet() && this.form.getPagelet().zoom_preview){
        var zoom_preview = this.form.getPagelet().zoom_preview;
        if(this.defaultPreviewRowSrc == null){
          this.defaultPreviewRowSrc = zoom_preview.init_url;
        }
        if(!this.enablePreview) {
          zoom_preview.hideItem();
          this.oldTogglePreviewRow = -1;
        } else {
          var url;
          if( this.EmptyData ){
            url = this.defaultPreviewRowSrc;
          }else{
            url = this.row_preview_src;
        }
          url += (url.indexOf('.jsp?') > -1 ? '&' : '?') + 'SPreviewRowPortletId=' + this.form.formid ;
          url = ZtVWeb.fmtPctFldPct(url, (idx-1), this.datasource, null, this.form, true, false);
          if(zoom_preview.structure.url != url){
          zoom_preview.setSrc(url);
          }
          zoom_preview.showItem();
          ZtVWeb.raiseEvent('PreviewedRow', {rs:this.datasource.rs,obj:this.form}, null, null, this.form.getPagelet().name, 'pagelet', false, null);
          ( this.EmptyData ? this.oldTogglePreviewRow = -2 : this.oldTogglePreviewRow = idx);
        //}else if(!this.enablePreview){ // Quando riclicco sulla stessa riga si chiude
        }
      }
    }
    this.HideFields={};//Array di stringhe con tutti i fields delle colonne nascoste
    this.UsedFields={};//Array di stringhe con tutti i fields delle colonne visibili (cols,columnlayer,rowlayer)
    if (SPTheme.ZoomGridRows>0 && EmptyNumber(this.GridRows.Value())) {
      this.GridRows.Value(SPTheme.ZoomGridRows);
      rowsSetBySkin=true;
    }
    if(!(EmptyString(this.UID.Value()) || EmptyString(this.LinkedField.Value()))){ //il reporto di un valore
      this.Grid.LinkValueUid = this.UID.Value();
      this.Grid.LinkValueField = this.LinkedField.Value();
      this.Grid.LinkFillEmptyKey = this.FillEmptyKey.Value();
      this.Grid.LinkPKFields = this.PKFields.Value();
      this.Popup.Value("true");
      if (SPTheme.ZoomLinkGridRows>0 && EmptyNumber(this.GridRows.Value())) {
        this.GridRows.Value(SPTheme.ZoomLinkGridRows);
        rowsSetBySkin=true;
      }
      this.ConfigGridElements.Value(this.ConfigGridElements.Value()+'-e-d');
      var SPThemeWidth = SPTheme.WindowZoomWidth,
        SPThemeHeight = SPTheme.WindowZoomHeight;
        if(SPTheme.AdvancedSuggesterWidth && SPTheme.AdvancedSuggesterHeight) {
        SPThemeWidth = SPTheme.AdvancedSuggesterWidth,
        SPThemeHeight = SPTheme.AdvancedSuggesterHeight;
      }
      if(SPThemeWidth && SPThemeHeight) {
        try {
          if (parent==window)
            window.resizeTo(SPThemeWidth, SPThemeHeight);
        } catch(e){}
      }
    }
    if(!EmptyNumber(this.GridRows.Value())){
      this.Grid.rows=this.GridRows.Value();
      this.GridRowsParam.Value(this.GridRows.Value());
      this.RowsParamValid=!rowsSetBySkin;
    } else {
      this.GridRows.Value(this.Grid.rows);
      this.GridRowsParam.Value(this.Grid.rows);
      this.RowsParamValid=false;
    }
    // if(!EmptyString(this.Autozoom.Value()) && !EmptyString(this.PKFields.Value())){
      // if (this.m_cAction && this.m_cAction.Value()=="autozoom") this.Grid.autozoom=this.Autozoom.Value()+(this.m_cAltInterface?"?m_cAltInterface="+this.m_cAltInterface.Value():"");
      // this.Grid.SetSPLinkerActions(this.ConfigGridElements.Value());
    // }
    this.Grid.rowMinHeight = this.RowMinHeight.Value() ? this.RowMinHeight.Value() : ( SPTheme.sv_ZoomRowMinHeight ? SPTheme.sv_ZoomRowMinHeight : 18);
    if(EmptyString(this.AllowOrderBy.Value())){
      this.AllowOrderBy.Value('true');
    }
    this.Grid.isorderby=this.AllowOrderBy.Value()=='true';
    var cge=this.ConfigGridElements.Value();
    if(!EmptyString(cge)){
      //toglie recMark
      if(cge.match(/-r/i)){
        this.Grid.recMark='false';
      }
      if(cge.match(/-c/i)){
        this.configModeSecurity=configModeSecurity=0;
      }
      if(cge.match(/-p/i)){
        canPrint=false;
      }
    }
    canPrint = (canPrint && this.printModeSecurity);
    var confNavbar=this.ConfigNavbar.Value();
    if(!EmptyString(confNavbar)){
      if (confNavbar.match(/-fl/i)) { // first/last page btn
        this.Grid.navbar_mode.firstlast = false;
      }
      if (confNavbar.match(/-ar/i)) { // add/remove row button
        this.Grid.navbar_mode.addremove = false;
      }
      if (confNavbar.match(/-p([^in]|$)/i)) { // page panel
        this.Grid.navbar_mode.pagepanel = false;
      }
      if (confNavbar.match(/-pi/i)) { // enable change page input
        this.Grid.navbar_mode.changepage = false;
      }
      if (confNavbar.match(/-pn/i)) { // page number
        this.Grid.navbar_mode.lastpage = false;
      }
      if (confNavbar.match(/-a([^r]|$)/i)) { // navbar always
        this.Grid.nav_bar='always'
      }
      if (confNavbar.match(/-h/i)) { // navbar false
        this.Grid.nav_bar='false'
      }
    }
    if(this.GridMinHeight && !Empty(this.GridMinHeight.Value())){
      var h=this.GridMinHeight.Value();
      var gh=this.Grid.minheight;
      var dh= h-gh;
      this.Grid.minheight = h;
      this.Grid.controlheight = h;
      this.Grid.Ctrl.style.height = h+'px';
      this.height = (this.height+dh); // l'altezza del portlet viene impostata dalla adjustFormHeight
      this.heights[0] = '' + this.height;
      this.Ctrl.style.height=this.height+'px';
      var scroller = document.getElementById('tbl'+this.Grid.ctrlid+'_scroller');
      if (scroller) {
        scroller.style.height=h+'px';
      }
    }
    if (this.MemoChars.Value()!="") {
      var nCharacter =Val(this.MemoChars.Value());
      if (nCharacter>0) this.Grid.SetMemoOptions(true,nCharacter);
      else this.Grid.SetMemoOptions(false);
    }
    //colonne griglia draggabili
    // if (!ZtVWeb.IsMobile() && !this.Grid.floatRows)
      // this.Grid.draggablecolumns=true;
    if (isHistoricalZoom && cge.match(/-e/i)==null) {
      var editAndSplit=FormatMsg("MSG_EDIT_AND_SPLIT")
      if(editAndSplit=="MSG_EDIT_AND_SPLIT")editAndSplit="Edit and split";
      this.Tools_Titles.Value(editAndSplit+','+this.Tools_Titles.Value());
      this.Tools_Urls.Value('javascript:void('+this.formid+'.'+this.Grid.splinker+".Link('"+this.dataobj.name+"'|null|null|'edithist'));,"+this.Tools_Urls.Value());
      this.Tools_Targets.Value(','+this.Tools_Targets.Value());
      this.Tools_Imgs.Value(Strtran(SPTheme.portalZoomEditHistorical||ZtVWeb.SPWebRootURL+"/visualweb/images/grid_edit_hist.png",',','|')+","+this.Tools_Imgs.Value());
      this.Tools_Tooltips.Value(editAndSplit+','+this.Tools_Tooltips.Value());
      if (!ZtVWeb.IsMobile()){
       ZtVWeb.RequireLibrary('../controls.js')
       ZtVWeb.RequireLibrary(ZtVWeb.SPWebRootURL+'/'+ZtVWeb.theme+'/calendar.js')
       PrepareJsCalendar(false)
      }
    }

    if (canPrint){
      //per stampare la griglia
      this.Grid.GetPrintData = function () {
        zoom_portlet.Grid.print_size = zoom_portlet.vzmstructure.Configuration.print_size;
        return {
          associatedTable: zoom_portlet.vzmstructure.Configuration.Autozoom // Nome della gestione associata allo zoom
          , fields: zoom_portlet.Grid.GetFields()
          , fieldsorderby: zoom_portlet.Grid.GetFieldsOrderBy()
          , VqrName: zoom_portlet.VQRName.Value() // Nome della query associata allo zoom (anche query da BO)
          , parms: zoom_portlet.Grid.QueryParmsFunc()
          , m_cVZMParamBlock: zoom_portlet.Grid.VZMParamBlock() //Filtri presenti nello zoom
          , outputFormat: zoom_portlet.vzmstructure.Configuration.print_outputf || ""
          , title: zoom_portlet.PrintTitle.Value() || zoom_portlet.vzmstructure.Configuration.print_title_trad || zoom_portlet.vzmstructure.Configuration.print_title ||
            zoom_portlet.GetCaption() || zoom_portlet.vzmstructure.Configuration.Caption
          , openerID: zoom_portlet.formid
          , gridName: zoom_portlet.Grid.name
          , isSqlDataProvider: zoom_portlet.vzmstructure.Configuration.PrintMode != 'SmartReport'
          , configurationName: zoom_portlet.ConfigName.Value() || 'default'
          , vzmstructure: zoom_portlet.vzmstructure
          , tableName: zoom_portlet.Table.Value()
          , ReportName: zoom_portlet.ReportName.Value()
          , printMode: zoom_portlet.vzmstructure.Configuration.print_option || 'default'
          , printHideExport: zoom_portlet.vzmstructure.Configuration.print_hideexport || false
          , printHideSettings: zoom_portlet.vzmstructure.Configuration.print_hidesettings || false
          , isExtended: zoom_portlet.Grid.IsExtended()
          , vocalPrint: zoom_portlet._printvocal || false
          , outformat: zoom_portlet._printformat || ''
          , printTotals: (zoom_portlet.vzmstructure.Configuration.print_totals && zoom_portlet.vzmstructure.Configuration.TotalsPosition != 'hidden') || false
          , maximized: zoom_portlet.vzmstructure.Configuration.print_max || false
          , group_repeated: (CharToBool(zoom_portlet.vzmstructure.Configuration.print_grep) /*&& (CharToBool(zoom_portlet.Grid.group_repeated)*/ || false)
        };
      };
      if (this.GridChart) {
        this.GridChart.GetPrintData = function () {
          return {
            associatedTable: zoom_portlet.vzmstructure.Configuration.Autozoom // Nome della gestione associata allo zoom
            , fields: zoom_portlet.GridChart.GetFields()
            , fieldsorderby: zoom_portlet.GridChart.GetFieldsOrderBy()
            , VqrName: zoom_portlet.VQRName.Value() // Nome della query associata allo zoom (anche query da BO)
            , parms: zoom_portlet.GridChart.QueryParmsFunc()
            , m_cVZMParamBlock: zoom_portlet.GridChart.VZMParamBlock() //Filtri presenti nello zoom
            , outputFormat: zoom_portlet.vzmstructure.Configuration.print_outputf || ""
            , title: zoom_portlet.GetCaption() || zoom_portlet.vzmstructure.Configuration.Caption
            , openerID: zoom_portlet.formid
            , gridName: zoom_portlet.Chart.name
            , isSqlDataProvider: zoom_portlet.vzmstructure.Configuration.PrintMode != 'SmartReport'
            , configurationName: zoom_portlet.ConfigName.Value() || 'default'
            , vzmstructure: zoom_portlet.vzmstructure
            , tableName: zoom_portlet.Table.Value()
            , printMode: zoom_portlet.vzmstructure.Configuration.print_option || 'default'
            , printHideExport: zoom_portlet.vzmstructure.Configuration.print_hideexport || false
            , printHideSettings: zoom_portlet.vzmstructure.Configuration.print_hidesettings || false
            , vocalPrint: zoom_portlet._printvocal || false
            , outformat: zoom_portlet._printformat || ''
            , printTotals: (zoom_portlet.vzmstructure.Configuration.print_totals && zoom_portlet.vzmstructure.Configuration.TotalsPosition != 'hidden') || false
            , maximized: zoom_portlet.vzmstructure.Configuration.print_max || false
            , group_repeated: (CharToBool(zoom_portlet.vzmstructure.Configuration.print_grep) /*&& (CharToBool(zoom_portlet.Grid.group_repeated)*/ || false)
          };
        };
      }

    } else {
      this.Grid.print_result=false;
    }

    this.Grid.HideTopToolsbarToggler();
    this.Grid.TopToolsbarTogglerLocked=true;
    if (ZtVWeb.IsMobile()) {
      this.configModeSecurity=Min(configModeSecurity,1);
    }
    //aggiunge il pulsante di editing...e tutto il resto

    if (this.PrintMode.Value()) {
      this.label.Hide();
      if (this.label2){
        this.label2.Hide();
      }
      if (this.toolbar) {
        this.toolbar.Hide();
      }
      if (this.toolbar2){
        this.toolbar2.Hide();
      }
      this.Ctrl.querySelector('div').style.visibility = "hidden";
      this.Grid.addObserver( 'grid',
        { grid_Rendered :
          function () {
            if ( zoom_portlet.Grid.datasource.Data.length == 1) {
              return;
            }else{
              if (!this.tpl) {
                this.tpl = makeTpl( 'p' && 'l' );
                fillDataRows( this.data.__rows___ );
              } else {
                fillDataRows( this.data.__rows___ );
              }
              if (!zoom_portlet.Grid.datasource.eof) {
                zoom_portlet.Grid.NextPage();
              } else {
                var tpl = this.tpl
                  , data = this.data
                  ;
                  /*
                function makeHelpPreview (options) {
                  var div
                    , h = document.createElement( 'h1' )
                    , txt = 'se non riesci a stampare '
                    , a = document.createElement( 'a' )
                    , onDownloadPdf = options.onDownloadPdf
                    , container = options.container
                    ;

                  if ( !onDownloadPdf ) {
                    throw new Error( 'Argument not found: \'onDownloadPdf\' callback.' );
                  }
                  if ( !container ) {
                    throw new Error( 'Invalid argument: \'container\' must be HTMLElement reference.' );
                  }

                  function getOnDownloadPdfCallback () {
                    return function (evt) {
                      onDownloadPdf( evt );
                    };
                  }

                  div = document.getElementById( 'headerPDF' );
                  if  ( div ) {
                    // esiste gia'
                    if ( div.parentNode != container ) {
                      // bisogna riposizionarlo
                      container.appendChild( div.parentNode.removeChild( div ) );
                    }
                  } else {
                   div = ( function () {
                      var div = document.createElement( 'div' );
                      div.id = 'headerPDF';
                      return div;
                    } )();

                    h.appendChild( document.createTextNode( txt ) );
                    h.style.fontFamily = 'OpenSans-Light';
                    h.style.padding = '30px';
                    a.href = 'javascript: void(0);';
                    a.addEventListener( 'click', function (e) {
                      getOnDownloadPdfCallback()( e );
                    }, false );
                    a.appendChild( document.createTextNode( 'clicca qui' ) );
                    h.appendChild( a );
                    h.appendChild( document.createTextNode( ' per scaricare il PDF' ) );
                    div.id = 'headerPDF';
                    div.appendChild( h );
                    container.appendChild( div );
                  }
                } // makeHelpPreview
                */


                window.SPPrintOffline.makeHelpPreview(
                  { container : zoom_portlet.Ctrl
                  , onDownloadPdf : function () {
                      window.SPPrintOffline.printPDF( { template : tpl
                                                      , data : data
                                                      , mode : 'pdf'
                                                      , caller : zoom_portlet
                                                      }
                                                    );
                    }
                  }
                );

                window.SPPrintOffline.printPDF( { template : this.tpl
                                                , data : this.data
                                                , caller : zoom_portlet
                                                }
                                              );
              }
            }
          }
        , tpl : null
        , data : { __rows___ : [] }
        }
      );
      function getItemUID (field, idx, repeated) {
        if ( field.match( /image:%/ ) ) {
          return field.replace( /image:%/g, '' ).replace( /%/g, '' ) + '_' + idx + ( repeated ? '_r' : '' );
        }
        return field + '_' + idx + ( repeated ? '_r' : '' );
      }

      function makeTpl(Orientation){ // costruisce la struttura del template
        var Tpl = { obj : 'section'
                  , type : 'normal'
                  , orientation : 'p' && Orientation
                  , hasRepeated : zoom_portlet.Grid.datasource.Data.length > 0
                  , startItem : 'prompt'
                  , fromDOM : true
                  , targetEngine : '0.0.1'
                  , items : {}
                  }
          , items = Tpl.items
          , grid_cells = zoom_portlet.Ctrl.querySelectorAll( '.grid_cell' )
          , cols = zoom_portlet.Grid.Cols
          , fSize_normal = 12
          , fSize_big = 16
          , lineHeightProportion = 1.15
          ;
          window.SPPrintOffline.initDoc( Tpl.orientation )

        items.prompt = window.SPPrintOffline.createItem(
          { uid : 'prompt'
          , margin_bottom : 15
          , margin_right : 200
          , width : 200
          , height : fSize_big * lineHeightProportion
          , type : 'string'
          , section : 'header'
          , repeated : false
          , value : window.decodeURIComponent( zoom_portlet.Caption.Value() )
          , fontSize : fSize_big
          , fontStyle : 'bold'
          , bottom: 'line1'
          , right: 'dateCurrent'
          , renderto: 'string'
          }
        );
        items.dateCurrent = window.SPPrintOffline.createItem(
          { uid : 'dateCurrent'
          // , margin_bottom : 25
          , margin_right : 2
          , width : 128
          , height : fSize_normal * lineHeightProportion
          , type : 'string'
          , section : 'header'
          , repeated : false
          , value : ZtVWeb.applyPicture( new Date(), 'T', 0, 'DD-MM-YYYY hh:mm' )
          , fontSize : fSize_normal
          , fontStyle : 'normal'
          , top : null
          , left : 'prompt'
          , renderto : 'string'
         }
        );
        items.line1 = window.SPPrintOffline.createItem(
          { uid : 'line1'
          , margin_bottom : 5 + fSize_normal * lineHeightProportion
          , height : 1
          , margin_right : 2
          , type : 'line'
          , section : 'header'
          , repeated : false
          , bottom: getItemUID( cols[0].field, 0 )
          , renderto: 'string'
          }
        );

        // intestazione colonne
        var cellsFontSizePx = parseFloat( getComputedStyle(grid_cells[0]).fontSize );
        cols.forEach( function (col, j, cols) {
          var nextIdx, right, left, bottom, prevIdx
            , uid = getItemUID( col.field, j )
            , itemWidthPt = fSize_normal * grid_cells[j].offsetWidth/*px*/ / cellsFontSizePx // pt ( formula => wColPx : fontSizePx = wColPt : fSize_normal )
            , isImage = /image:%/.test( col.field )
            // , isInitLetter = /initletter:%/.test( col.field )
            // , isInitLetter2 = /initletter2:%/.test( col.field )
            , fieldName = isImage ? col.field.replace( /image:%/g, '' ).replace( /%/g, '' ) : col.field
            , fldFromDataObj = !!~zoom_portlet.dataobj.getFldIdx( fieldName )
            , typeFromDB = fldFromDataObj ? zoom_portlet.dataobj.getType( fieldName ) : col.type /*ZtVWeb.getTypeFromPict( col.picture )*/
            ;

          /* preso da VisualWEB.js: campo con pict numerica e senza allineamento viene trattato visivamente come numerico */
          if ( !col.align && ZtVWeb.getTypeFromPict( col.picture ).match( /N/ ) ) {
            typeFromDB = 'N';
          }

          if ( j == 0 ) {
            bottom = 'line2';
          } else {
            bottom = getItemUID( col.field, j, true );
            prevIdx = j - 1;
            left = getItemUID( cols[prevIdx].field, prevIdx );
          }

          if ( j < cols.length - 1 ) {
            nextIdx = j + 1;
            right = getItemUID( cols[nextIdx].field, nextIdx );
          }

          items[uid] = window.SPPrintOffline.createItem(
            { uid : uid
            , margin_right : 2
            , width : itemWidthPt
            , height : fSize_normal * lineHeightProportion
            , type : 'string'
            , section : 'header'
            , repeated : false
            , value : col.title || ' '
            , fontSize : fSize_normal
            , fontStyle : 'bold'
            , left: left
            , bottom: bottom
            , right: right
            , renderto: 'string'
            , align : typeFromDB === 'N' ? 'right' : col.align || 'left'
            }
          );
        } ); // for headers
        items.line2 = window.SPPrintOffline.createItem(
          { uid : 'line2'
          , margin_top : -5
          , margin_bottom : 5 + fSize_normal * lineHeightProportion
          , margin_right : 2
          , height : 1
          , type : 'line'
          , section : 'header'
          , repeated : false
          , top: getItemUID( cols[0].field, 0 )
          , bottom: getItemUID( cols[0].field, 0, true )
          , renderto: 'string'
          }
        );
        items.line3 = window.SPPrintOffline.createItem(
          { uid : 'line3'
          , margin_bottom : 10
          , margin_right : 2
          , height : 1
          , type : 'line'
          , section : 'footer'
          , repeated : false
          , top : getItemUID( cols[0].field, 0, true )
          , renderto: 'string'
          }
        );

        cols.forEach( function (col, j/*, cols*/) { // campi ripetuti
          var isImage = /image:%/.test( col.field )
            , fieldName = isImage ? col.field.replace( /image:%/g, '' ).replace( /%/g, '' ) : col.field
            , uid = getItemUID( col.field, j, true )
            , fldFromDataObj = !!~zoom_portlet.dataobj.getFldIdx( fieldName )
            , typeFromDB = fldFromDataObj ? zoom_portlet.dataobj.getType( fieldName ) : col.type /*ZtVWeb.getTypeFromPict( col.picture )*/
            // , isInitLetter = /initletter:%/.test( col.field )
            // , isInitLetter2 = /initletter2:%/.test( col.field )
            ;

          /* preso da VisualWEB.js: campo con pict numerica e senza allineamento viene trattato visivamente come numerico */
          if ( !col.align && ZtVWeb.getTypeFromPict( col.picture ).match( /N/ ) ) {
            typeFromDB = 'N';
          }

          items[uid] = window.SPPrintOffline.createItem (
            { uid : uid
            , margin_bottom : 5
            , margin_right : isImage ? 0.5 : 2
            , width : isImage ? null : fSize_normal * grid_cells[j].offsetWidth/*px*/ / cellsFontSizePx // pt ( wColPx : fontSizePx = wColPt : fSize_normal )
            , height : isImage ? null : fSize_normal * lineHeightProportion
            , type : 'field'
            , typeFromDB : typeFromDB
            , section : 'body'
            , repeated : true
            , value : uid
            , fontSize : isImage ? null : fSize_normal
            , fontStyle : isImage ? null : 'normal'
            , top : ( j == 0 ? 'line2' : getItemUID( col.field, j, false ) )
            , bottom: ( j == 0 ? 'line3' : null )
            , renderto: isImage ? 'image' : 'string'
            , align : typeFromDB === 'N' ? 'right' : col.align || 'left'
            }
          );
        } );
        return Tpl;
      } // makeTpl

      function fillDataRows (rows) {
        var row, rowIdx, nRows, colIdx
          , grid = zoom_portlet.Grid
          , datasource = grid.datasource
          , cols = grid.Cols
          , colNames = []
          ;
        for ( colIdx = 0; colIdx < cols.length; colIdx++ ) { // colonne
          colNames.push( cols[colIdx].field.replace( /image:%/g, '' ).replace( /%/, '' ) );
        }
        // scrivo i dati
        for ( rowIdx = datasource.nStartRow, nRows = datasource.getRecCount(); rowIdx < nRows; rowIdx++ ) { // righe
          row = {};
          cols.forEach( function (col, colIdx, cols) { // colonne
            row[getItemUID( cols[colIdx].field, colIdx, true )] = datasource.getValue( rowIdx, colNames[colIdx] );
          } ); // colonne-for
          rows.push( row );
        } // righe for
      } // fillDataRows

      var source = GetOpener();
      if (source) {
        var openerForm = this.OpenerFormId.Value()
        this.vzmstructure= source[openerForm].vzmstructure;

        var clone=function (myObj){ //funzione per copia profonda dei filtri
          if(typeof(myObj) != 'object') return myObj;
          if(myObj == null) return myObj;
          var myNewObj = new Object();
          for(var i in myObj)
            myNewObj[i] = clone(myObj[i]);
          return myNewObj;
        };
        this.Grid.Filters=[];
        this.vzmstructure.ArrayFilters=null;
        for(var i=0;i<source[openerForm].Grid.Filters.length;i++) {
          this.Grid.Filters.push(clone(source[openerForm].Grid.Filters[i]));
        }
        this.Grid.datasource=this.dataobj;
        this.dataobj.queryfilter=this.Grid.CreateFilter(false, true);
        this.dataobj.orderby=source[openerForm].dataobj.orderby
        this.Grid.dontupdate=false;   //quando il portlet non e' in attesa di un filtro non viene fatto il rendering a griglia vuota
        /* griglia assegna colonne */
        this.Grid.SetColumns(JSON.parse(source[openerForm].getColumns()));
        this.addTotalizer();
        this.yet_done=true;
      }
    }

  this.LinkedConfiguration=function(newcfg,forceLoad) {
    var type = '';
    var i;
    for( i=0; i<this.vzmstructure.Configuration.linkedConfs.length; i++) {
      if( this.vzmstructure.Configuration.linkedConfs[i].configname == newcfg) {
          type = this.vzmstructure.Configuration.linkedConfs[i].configtype
          i = this.vzmstructure.Configuration.linkedConfs.length;
      }
    }
    if ( type == 'pivot' ) {
      try {
        localStorage.setItem(this.formid, JSON.stringify(this.RetrieveFilters()));
        var a = document.createElement('a');
        var url = '../jsp/SPVisualPivot.jsp?ConfigName='+newcfg+'&tpl=SPVisualPivot_tpl'
        document.body.appendChild(a);
        if( url.indexOf('?') > 0 ) {
          url+='&pParent='+this.formid;
        }
        else {
          url+='?pParent='+this.formid;
        }
        a.href = ZtVWeb.makeStdLink(url,this.dataobj.curRec-1,this.dataobj,null,this,true);
        a.click();
        document.body.removeChild(a);
      }
      catch(e) {
        alert('Error on changing configuration');
        console.log(e)
      }
      return;
    }

    if (this.menu_versioni)
      this.menu_versioni.CloseMenu();
    var ordered_cols=[];//array x ordiare in base all'indice
    if (viewMode!="chart"){
      var _col;
      // eslint-disable-next-line no-cond-assign
      for(i=0; _col=this.Grid.Cols[i]; i++){
        if(_col.orderbyidx){
          ordered_cols.push(LibJavascript.JSONUtils.purge(_col, ['orderbyidx','orderbystatus','orderbyfld']));
        }
      }
      ordered_cols.sort(function(c1,c2){//ordino l'array temp in base all'idx
        var res=c1.orderbyidx-c2.orderbyidx;
        return res;
      });
    }
    var filters=[],_filters = viewMode=="chart"?this.GridChart.Filters:this.Grid.Filters;
    for (i=0; i<_filters.length; i++){
      if (_filters[i].userFilter || _filters[i].fixed)
        filters.push(JSON.parse(JSON.stringify(_filters[i])));
    }
    function setFiltersAndOrderby() {
      var i;
      if (viewMode=="chart"){
        if (!Empty(filters)){
          if (Empty(this.GridChart.Filters))
            this.GridChart.Filters = filters;
          else {
            for (i=0; i<filters.length; i++){
              this.GridChart.AddFilter(
                this.GridChart.MakeFilter(
                  filters[i].field,filters[i].operator,filters[i].expression,filters[i].type,
                  filters[i].fixed, filters[i].userFilter,filters[i].defaultFilter
                ),filters[i].visible
              );
            }
          }
        }
        this.dataobj.queryfilter=this.GridChart.CreateFilter(false, true);
        this.GridChart.IDFilterSeed=filters.length;
        this.GridChart.RefreshFiltersBar(true,this.GridChart.ctrlid)
      }
      else {
        if (!Empty(filters)){
          if (Empty(this.Grid.Filters))
            this.Grid.Filters = filters;
          else {
            for (i=0; i<filters.length; i++){
              this.Grid.AddFilter(
                this.Grid.MakeFilter(filters[i].field,filters[i].operator,filters[i].expression,
                  filters[i].type,filters[i].fixed, filters[i].userFilter,filters[i].defaultFilter
                ), filters[i].visible
              );
            }
          }
        }
        this.Grid.IDFilterSeed=filters.length;
        this.Grid.RefreshFiltersBar(true,this.Grid.ctrlid)
        this.dataobj.queryfilter=this.Grid.CreateFilter(false, true);
        if (ordered_cols.length>0) {
          for(i=0; i<ordered_cols.length; i++){
            var idx = LibJavascript.Array.indexOf(this.Grid.Cols, ordered_cols[i].orderbyfld, function(el,fld) {
              return el.orderbyfld==fld;
            });
            if (idx>-1) {
              this.Grid.Cols[idx].orderbyidx = ordered_cols[i].orderbyidx;
              this.Grid.Cols[idx].orderbystatus = ordered_cols[i].orderbystatus;
            }
          }
        }
      }
    }
    this.LoadConfiguration(newcfg,true,setFiltersAndOrderby,forceLoad);
  }
  this.LoadConfiguration=function(newcfg,keepFltrOrderby,callbackBeforeQuery, forceLoad) {
    if ((this.ConfigName.Value()==newcfg || (Empty(this.ConfigName.Value()) && newcfg=='default')) && !forceLoad) {
      //se ricarico la stessa configurazione non faccio nulla
      return;
    }
    this.ConfigName.Value(newcfg);
    this.yet_done=false;
    this.SPVZM_action.Value('');
    this.SPVZM_vqr.Value('');
    userModGridRows = false;
    this.SetQuery(keepFltrOrderby);
    this.Autozoom.Value(paramAutozoom);
    this.dataobj.ParseParameters();
    var vzmstructure;
    if (this.splinker.offline)
      vzmstructure=window.GetVZM(this.Table.Value(),this.ConfigName.Value());
    else vzmstructure=eval('('+new ZtVWeb.JSURL("../servlet/SQLDataProviderServer?sqlcmd="+this.dataobj.cmd+(!Empty(this.dataobj.newcmd)?'&_sqlcmd='+this.dataobj.newcmd:'')+"&SPVZMStructureOnly=true&cmdhash="+this.dataobj.cmdHash+"&orderby=&queryfilter="+(this.dataobj.strparms?this.dataobj.strparms:''),true).Response()+')');
    if (vzmstructure.ERROR) {
      alert("ERROR: "+ vzmstructure.ERROR);
      return;
    } else {
      this.vzmstructure=vzmstructure;
    }
    if (this.configModeSecurity==2) {
      var cfg=newcfg.split("/");
      if (cfg.length>1) this.ConfigName.Value(cfg[1]);
    }
    this.vdmName=this.vzmstructure.Configuration.vdmName;
    delete this.vzmstructure.Configuration.vdmName;
    this.Grid.dontupdate=true;
    this.updateFilters();
    if (typeof (callbackBeforeQuery)=='function') {
      callbackBeforeQuery.call(this);
    }
    this.dataobj.firstQuery('true','',this.vzmstructure);
    // devo aggiornare la visibilt� dei filtri
    this.updateFilterVisibility();
    this.$entity$_GetConfigurationField.Emit();
    this.Grid.dontupdate=false;
    if (this.vzmstructure.Configuration.defaultViewMode!='chart' || this.splinker.offline){
      if (CharToBool(this.vzmstructure.Configuration.applyAdvancedFilter))
        this.ApplyAdvancedFilter();
      else if (CharToBool(this.vzmstructure.Configuration.openVdmBeforeQuery))
        this.ShowVdmMask();
      else this.dataobj.Query();
    }
    else {
      this.GridChart_FiltersCreated();
    }
    reload=true;
    this.$entity$_updateConfiguration.Emit();
    this.SetZoomTitle();
  }

  this.Config=function(){
    var cnf = {}
    cnf.ConfigName = this.ConfigName.Value();
    cnf.User = this.Specific.User;
    cnf.Custom = this.Specific.Custom;
    cnf.Group = this.Specific.Group;
    return cnf;
  }

  if (this.configModeSecurity>0) {
  //configurazione per tutti

  this.GetFiltersConfiguration=function(conf) {
    conf.ArrayFilters=[];
    var filterProps =  ['field', 'operator', 'expression'];
    for (var i=0;i<this.Grid.Filters.length;i++) {
      if (!this.Grid.Filters[i].fixed && this.Grid.Filters[i].visible) {
        conf.ArrayFilters.push(LibJavascript.JSONUtils.purge(this.Grid.Filters[i], filterProps))
      }
    }
  }
  this.GetDataSave=function(conf){
    var i;
    var globalProps = [ 'titles', 'TotalsPosition' , 'TotalsStarting', 'GridRows' ]
    conf.Configuration={};
    for (i=0;i<globalProps.length;i++) { //inizializzo con i valori che sono arrivati dalla configurazione aperta in precedenza
      if (typeof(this.vzmstructure.Configuration[globalProps[i]])!='undefined' &&
          this.vzmstructure.Configuration[globalProps[i]]!='undefined') {
        conf.Configuration[globalProps[i]] = this.vzmstructure.Configuration[globalProps[i]];
      }
    }
    if (this.vzmstructure.ArrayFilters) {
      conf.ArrayFilters = this.vzmstructure.ArrayFilters;
    }
    this.GetDataSave_Options(conf);
    this.GetDataSave_Grid(conf);
    conf.Action = 'save';
    conf.SourceConfigName = this.oldConf;
    return conf;
  }

  this.GetDataSave_Options=function(conf){
    if (conf){
      //se non e' stato creato il portlet delle opzioni assegna il numero di righe della grid per il salvataggio
      if (userModGridRows)
        conf.GridRows = this.Grid.rows;
      conf.OrderBy  = this.confOrderBy;
      conf.Custom   = this.Specific.Custom||false;
      conf.Group    = this.Specific.Group||0;
      conf.User     = this.Specific.User||0;
      return conf;
    } else {
      //implementata dall'item della toolbar
      return {};
    }
  }
  this.GetDataSave_Grid=function(conf){
    var colProps = ["id","field","inExtGrid","hidden",'tileVisibility',"show_extra_title","extracolidx","Layer"],
    rowLayerProps = ["id","field","inExtGrid","hidden","show_extra_title","extracolidx"];

    if (conf.OrderBy){
      colProps.push("orderbyidx");
      colProps.push("orderbystatus");
    }

    //Cols
    conf.Cols = LibJavascript.JSONUtils.purge(this.Grid.Cols, colProps);
    var i, j, k, col, layer, colLayer, rl;
    // eslint-disable-next-line no-cond-assign
    for(i=0; col=conf.Cols[i]; i++){ //cicla nelle cols per eliminare elementi undefined e per effettuare il purge nei layer
      for (k=0;k<colProps.length;k++) {
        if (col[colProps[k]]==undefined)
          delete col[colProps[k]];
      }
      layer = col.Layer;
      if(!EmptyArray(layer)){
       col.Layer = LibJavascript.JSONUtils.purge(layer, colProps);
        // eslint-disable-next-line no-cond-assign
        for (j=0; colLayer=col.Layer[j]; j++) {
          for (k=0;k<colProps.length;k++) {
            if (colLayer[colProps[k]]==undefined)
              delete colLayer[colProps[k]];
          }
        }
      }
    }
    //RowLayer
    conf.RowLayer = LibJavascript.JSONUtils.purge(this.Grid._rowLayer, rowLayerProps);
    // eslint-disable-next-line no-cond-assign
    for(i=0; rl=conf.RowLayer[i]; i++){//cicla nel rowlayer per eliminare elementi undefined
      for (k=0;k<rowLayerProps.length;k++) {
        if (rl[rowLayerProps[k]]==undefined)
          delete rl[rowLayerProps[k]];
      }
    }
    return conf;
  }

  //fine configurazione per tutti
    // if (this.configModeSecurity==2){
      // if (typeof(anchorToFeature)!='undefined'){
        // var helpItem=this.Grid.TopToolsbar.CreateAndAddItem({
          // name: 'cfghelp_itm',
          // title: "Help",
          // image: '../portalstudio/images/help.png',
          // href: 'javascript:Help("portalzoom_interfaccia_base_toolbar");' //see AdjOnState
        // },null,"vzm_configuration");

        // grid.addObserver('grid',helpItem);
      // }
    // }
  }
  window.m_bIsZoom = true;
  // function GetContainerHeightAndOffset(frame) {
  //   if (frame) {
  //     if (frame.getAttribute('portlet_id')!=null && frame.contentWindow.parent.frameElement) { //se lo zoom e' dentro a un iframe di portlet ridimensionabile
  //       var ho = GetContainerHeightAndOffset(frame.contentWindow.parent.frameElement);
  //       var pos = LibJavascript.DOM.getAbsolutePos(frame);
  //       return {h:ho.h,o:ho.o + pos.y};
  //     } else {
  //       return {h:frame.parentNode.offsetHeight, o:0};
  //     }
  //   }
  //   return { h:0, o :0};
  // }
  if (ZtVWeb.IsMobile()) {
    // this.Grid_BeforeResize=function() {
      // if (this.PrintMode && this.PrintMode.Value()) {
      // } else {
        // if (window.frameElement) {
          // var wHO = GetContainerHeightAndOffset(window.frameElement);
          // var wH = wHO.h - wHO.o;
          // wH = wH - this.Ctrl.offsetTop;
          // var TopToolsbarContainer;
          // if (TopToolsbarContainer = this.Grid.TopToolsbarContainer()) {
            // wH = wH - TopToolsbarContainer.offsetHeight;
          // }
          // this.Grid.minheight = wH;
          // this.Grid.scroll_bars='true';
          // this.Grid.Ctrl.style.height = wH + 'px';
          // this.height = wH;
          // this.Ctrl.style.height=wH+'px';
          // var scroller = document.getElementById('tbl'+this.Grid.ctrlid+'_scroller');
          // if (scroller) {
            // scroller.style.height=wH+'px';
          // }
        // }
      // }
    // }
    // this.Grid_BeforeResize();
  }
  this.Grid.SetPrintPortlet("SPPortalZoomPrint");
  if (this.GridChart)
    this.GridChart.SetPrintPortlet("SPPortalZoomPrint");
  } //this.configModeSecurity>0

  this.SetEmitters=function(){
    //imposta l'emitter $entity$_zoomSelectedRow
    var emtSuffix='';
    var emtName=this.EmitterName.Value();
    if(EmptyString(emtName)){
      emtName=this.EventName.Value();
      emtSuffix='_zoomSelectedRow';
      if(EmptyString(emtName)){
        emtName=this.Autozoom.Value();
        if(EmptyString(emtName)){
          emtName=this.Table.Value();
        }
      }
    }
    emtName+=emtSuffix;
    this.$entity$_zoomSelectedRow.name=this.$entity$_zoomSelectedRow.name.replace('$entity$_zoomSelectedRow',emtName);

    //imposta l'emitter $entity$_callChildren
    this.$entity$_callChildren.name=this.$entity$_callChildren.name.replace('$entity$', this.Table.Value());

    //imposta l'emitter $entity$_updateFilters
    emtName=this.EmitterName.Value();
    if(EmptyString(emtName)){
      emtName=this.Table.Value();
    }
    this.$entity$_updateFilters.name=this.$entity$_updateFilters.name.replace('$entity$', emtName);
    this.$entity$_updateConfiguration.name=this.$entity$_updateConfiguration.name.replace('$entity$', emtName);
    this.$entity$_NumberOfLoadedRecords.name=this.$entity$_NumberOfLoadedRecords.name.replace('$entity$', emtName);
    this.$entity$_GetConfigurationField.name=this.$entity$_GetConfigurationField.name.replace('$entity$', emtName);
  }
  this.SetReceivers=function(){
    var SET_FILTER='_zoomSetFilter',
        rcvSuffix="",
        rcvName=this.ReceiverName.Value(),
        boname = ( this.Autozoom.Value() || this.Linkzoomprg.Value() );

    function penPusher (parmsObj) {//funzione passacarte per receiver di filtro
      this.$entity$_zoomSetFilter.receiveFnc(parmsObj);
    }

    if(EmptyString(rcvName)){
      rcvName=this.EventName.Value();
      if(EmptyString(rcvName)){
        rcvName=this.Autozoom.Value();
        rcvSuffix=SET_FILTER;
        if(EmptyString(rcvName)){
          rcvName=this.Table.Value();
        }
      }
    }
    for(var i=0,rcvs=rcvName.split(','),l=rcvs.length; i<l; i++){//receivername multiplo
      rcvName=rcvs[i];
      this['on_'+rcvName+rcvSuffix]=penPusher;//impostato per l'utente
    }
    this['on_'+rcvNameGen]=penPusher; // evento usato dalle vdm per passare i filtri (se c'erano pi� di uno zoom sulla stessa pagina, i filtri venivano applicati a tutti)
    this['on_'+this.Table.Value()+SET_FILTER]=penPusher;//impostato per ricevere filtri da SPPortalZoomParameters

    if ( boname ) {
      this['on_'+boname+'_savedEntity']=function(parmsObj){
        this.$entity$_savedEntity.receiveFnc(parmsObj);
      };
      this['on_'+boname+'_deletedEntity']=function(parmsObj){
        this.$entity$_deletedEntity.receiveFnc(parmsObj);
      };
      this.splinker_Deleted=function(bResult) {
        if (bResult) {
          var PKS = {};
          var cur_rs = this.GetRS();
          for (f in cur_rs) {
            if ((','+Lower(this.PKFields.Value())+',').indexOf(','+Lower(f)+',')>-1) {
              PKS[this.dataobj.Fields_map[this.dataobj.Fields_map[f.toLowerCase()]]] = cur_rs[f];
            }
          }
          ZtVWeb.raiseEvent(boname+'_deletedEntity', PKS);
        }
      }
    }
  }

  this.SetWaitForFilter=function(){
    var par_val=this.WaitForFilter.Value();
    this.WaitForFilter.typevar='logic';
    this.WaitForFilter.type='L';
    if(EmptyString(par_val)){
      this.WaitForFilter.Value(!EmptyString(this.ReceiverName.Value()));
    }
  }

  this.SetSPLinkers=function(){
    var autozoom=this.Autozoom.Value();
    if(!EmptyString(autozoom) && !EmptyString(this.PKFields.Value())) {
      var detailbehavior = this.DetailBehavior.Value(),
          autosize = Empty(this.PopupW.Value()) || Empty(this.PopupH.Value()),
          parms = this.PKFields.Value().replace(/;/,','),
          altinterface = (this.m_cAltInterface?this.m_cAltInterface.Value():""); //,
          // ZoneAltInterface = (this.m_cZoneAltInterface?this.m_cZoneAltInterface.Value():"");
      parms+= EmptyString(autozoom) ? '' : ',m_cDetailBehavior='+detailbehavior;
      if (!this.splinker.offline) {
        parms+= EmptyString(autozoom) ? '' : ',m_cAltInterface='+altinterface;
        parms+= EmptyString(autozoom) ? '' : ',m_cZoneAltInterface';
        parms+= autosize ? ',m_bAutoResize=true' : '';
      }
      if (this.m_cAtExit) {
        if (Left(this.m_cAtExit.Value(),5)=='close') {
          this.splinker.CloseAtEnd(true);
          this.parent_splinker.CloseAtEnd(true);
        }
        if (Right(this.m_cAtExit.Value(),6)=='reload') {
          this.splinker.refresh = SPTheme.modalZoomMultiple ? "false" : "true" ;
          this.parent_splinker.refresh = SPTheme.modalZoomMultiple ? "false" : "true" ;
        }
      }
      var popupaction = this.PopupAtExit.Value();
      if (popupaction=='continue') {
          this.splinker.CloseAtEnd(false);
          this.parent_splinker.CloseAtEnd(false);
          this.splinker.refresh="false";
          this.parent_splinker.refresh="false";
      } else if (popupaction=='close&reload') {
          this.splinker.CloseAtEnd(true);
          this.parent_splinker.CloseAtEnd(true);
          this.splinker.refresh = SPTheme.modalZoomMultiple ? "false" : "true" ;
          this.parent_splinker.refresh = SPTheme.modalZoomMultiple ? "false" : "true" ;
      } else if (popupaction=='close') {
          this.splinker.CloseAtEnd(true);
          this.parent_splinker.CloseAtEnd(true);
          this.splinker.refresh="false";
          this.parent_splinker.refresh="false";
      }
      if (!this.splinker.offline && (','+this.PKFields.Value().toLowerCase()+',').indexOf(',cphstk,')==-1 && this.vzmstructure && this.vzmstructure["Fields"].join(" ").toLowerCase().indexOf(" cpfromdate ") != -1) {
        parms += ',m_dHistoricalLoadStart'
      }
      if (this.LayerInterface && !EmptyString(this.LayerInterface.Value())) {
        parms+=',m_cLayerInterface=LayerInterface';
      }
      this.splinker.Parameters(parms); this.splinker_hist.Parameters(parms+',m_dNewHistoricalCPFromDate');
      this.splinker.Servlet(autozoom); this.parent_splinker.Servlet(autozoom); this.splinker_hist.Servlet(autozoom);
      this.splinker._servlet = autozoom;
      this.splinker_hist.SkipDeleteMessage(true);
      var popup = this.vzmstructure.Configuration.Popup||'',
          target='',
          popupW=this.PopupW.Value(),
          popupH=this.PopupH.Value(),
          delMsg=this.SetDelMessage.Value();
      switch(this.Popup.Value().toLowerCase()){
        case 'true':
          popup='true';
          break;
        case 'false':
          popup='false';
          break;
        case '':
          if (SPTheme.modalZoomMultiple && popup=='') {
            popup='true';
            this.splinker.refresh='false';
          }
          break;
        default:
          target = (this.Popup.Value()||"").toLowerCase()=='layer' ? 'Grid' : this.Popup.Value();
          break;
      }
      this.splinker.popup=popup; this.parent_splinker.popup=popup;
      this.splinker.target=target; this.parent_splinker.target=target; this.splinker_hist.target=target;
      this.splinker.popup_height=popupH; this.parent_splinker.popup_height=popupH; this.splinker_hist.popup_height=popupH;
      this.splinker.popup_width=popupW; this.parent_splinker.popup_width=popupW; this.splinker_hist.popup_width=popupW;
      this.Grid.splinker='splinker';
      this.splinker.async = popup=='true'; //se non e' a popup non posso farlo asincrono
      if(!EmptyString(this.EntityType.Value())){
        this.splinker_hist.entity_type=this.splinker.entity_type=this.EntityType.Value();
        this.parent_splinker.entity_type=this.EntityType.Value();
        if (this.EntityType.Value().toLowerCase()=='dialog') {
          this.parent_splinker.Action('start');
          this.splinker.Action('start');
        }
      }
      if(!EmptyString(delMsg)){
        this.splinker.DeleteMessage(delMsg);
      }
      if(this.WaitForFilter.Value() || !EmptyString(this.InitEntityFields.Value()) || !EmptyString(this.FixedFilterURL.Value())){
        this.Grid.parent_splinker='parent_splinker';
      }
    } else {
      this.Grid.splinker=' ';
      this.Grid.parent_splinker=' ';
    }
  }

  if (!this.ChangeQueryName) {
    this.ChangeQueryName = function(){
      var q='vzm:'+this.Table.Value();
      if(!Empty(this.ConfigName.Value())){
        q+='.'+this.ConfigName.Value();
      }
      this.dataobj.cmd = q;
      this.dataobj.ChangeQuery('');
      if (this.dataobj2) {
        this.dataobj2.cmd = q;
        this.dataobj2.ChangeQuery('');
      }
    };
  }

  this.SetQuery=function(keepFltrOrderby){
    this.ChangeQueryName();
    if ( ! ( (this.PrintMode && this.PrintMode.Value()) || keepFltrOrderby ) ) {
      this.dataobj.queryfilter='';
      this.dataobj.orderby='';
      if (this.dataobj2){
        this.dataobj2.queryfilter='';
        this.dataobj2.orderby='';
      }
    }
    this.dataobj.nRows=this.Grid.rows;
    if (!EmptyString(this.FixedFilter.Value()) || !EmptyString(this.FieldFilter.Value())) {
      let jsonFilter = [];
      if (!EmptyString(this.dataobj.queryfilter)) {
        jsonFilter = JSON.parse(this.dataobj.queryfilter);
      }
      if(!EmptyString(this.FixedFilter.Value())){
        jsonFilter.push({ unsafeExpr : this.FixedFilter.Value()});
      }
      if(!EmptyString(this.FieldFilter.Value())){
        jsonFilter.push({ unsafeExpr : this.FieldFilter.Value()});
      }
      this.dataobj.queryfilter=JSON.stringify(jsonFilter);
      if (this.dataobj2) {
        this.dataobj2.queryfilter=this.dataobj.queryfilter;
      }
    }
  }

  function adjImgItem(itm){
    var field = itm.field_orig||itm.field;
    if(itm.isImage){
      itm.field_orig = field;
      itm.field = 'image:%'+field+'%'+(EmptyString(itm.tooltip) ? '' : ':'+itm.tooltip);
      if ( !ZtVWeb.IsMobile() && !itm.width) {
        itm.width = "1%";
      }
    }
    if(itm.checkbox){
      itm.field_orig = field;
      itm.field = 'checkbox:'+field+(EmptyString(itm.tooltip) ? '' : ':'+itm.tooltip);
      itm.width="1%";
    }
    if (itm.field_trad) {
      itm.field_orig = field;
      itm.field = itm.field_trad;
    }

    return itm;
  }
  this.Grid_RowsChanged=function(rows){
    this.GridRows.Value(rows);
    userModGridRows = true;
  }
  this.Grid_Validate=function(fld) {
    if (isHistoricalZoom && fld=='cpfromdate') {
      this.m_dNewHistoricalCPFromDate.Value(this.Grid.RowValue('cpfromdate'));
      return this.splinker_hist.Link('dataobj',this.dataobj.curRec-1,null,'changefromdate');
    } else {
      return true;
    }
  }

  this.Grid_onColumnOver=function(col_id) {
    this.getZoomtitlesRefsByProperty('SetSearchField', function(portlet){
      portlet.SetSearchField(this.Grid.Cols[col_id]);
    }, this);
  }

  // Funzione che controlla il placeholder del campo di ricerca del zoom_title del mobile
  /*
  this.Grid_onShowColumnMenu=function(col_id,ul) {
    var searchClass = 'search';
    if( LibJavascript.CssClassNameUtils.getElementsByClassName(searchClass,ul).length==0 ) {
      var ico_ord_find = (SPTheme.grid_ico_orderby_find||ZtVWeb.SPWebRootURL+'/visualweb/images/grid_find.gif');
      ul.innerHTML = '<li class="grid_orderby_li '+searchClass+'" style="background:URL('+ico_ord_find+') no-repeat left center;cursor:pointer;" onclick="return (function(event){window.'+this.formid+'.Grid.toggleOrderbyList(\''+ul.id+'\','+col_id+');window.'+this.formid+'.Search('+col_id+');event.preventDefault();event.cancelBubble=true;event.stopPropagation();return;})(event)">Cerca</li>' + ul.innerHTML
    }
  }
  */
  /*
  this.Search = function(col) {
    if (!EmptyString(this.Zoomtitle)) {
      var titlePortlet=null;
      var portlets=ZtVWeb.getPortletsById();
      titlePortlet=portlets[this.Zoomtitle];
      if (titlePortlet.SetSearchField){
        titlePortlet.SetSearchField(this.Grid.Cols[col]);
      }
    }
  }
  */
  this.AddNewRecord=function() {
    if (this.autozoomCanAdd){
      if (!EmptyString(this.vzmstructure.Configuration.newAction)){
        var link = ZtVWeb.makeStdLink(this.vzmstructure.Configuration.newAction,this.dataobj.curRec-1,this.dataobj,null,this,true);
        ZtVWeb.Popup(link,"",{});
      }
      else if (!EmptyString(this.Grid.splinker)) {
        if(this.WaitForFilter.Value() || !EmptyString(this.InitEntityFields.Value()) || !EmptyString(this.FixedFilterURL.Value()))
          this.parent_splinker.Link();
        else
        // ATTENZIONE: Inserita la setTimeout per correggere il non corretto funzionamento in caso di Integrazione Browser Embedded
        setTimeout("window."+this.formid+".splinker.Link(null,null,null,'"+(this.Grid.SPLinkerActions.N.action||'new')+"')",10);
      }
    }
  }

  this.printZoom=function() {
    if ( this.vzmstructure.Configuration.PrintMode == 'None' ) {
      return; /* Do nothing */
    }
    this._printZoom = true;
    if (this.vzmstructure.Configuration.PrintMode=='SmartReport' )
      this.ReportName.Value( this.vzmstructure.Configuration.ReportName );
    if ( (typeof(this.vzmstructure.Configuration.PrintMode)=='undefined' || this.vzmstructure.Configuration.PrintMode=='Auto' || this.vzmstructure.Configuration.PrintMode=='SmartReport') ) {
      var printManager;
      if ( viewMode == 'chart' ){
        printManager = this.GridChart.getPrintManager();
        printManager.SetPrintData( this.GridChart.GetPrintData() ); //ridefinita in SPPortalZoom.js
      }
      else{
        printManager = this.Grid.getPrintManager();
        printManager.SetPrintData( this.Grid.GetPrintData() ); //ridefinita in SPPortalZoom.js
      }
      printManager.OnCinemaClick( function () {
        printManager.Close();
      } );
      printManager.Show();
    } /*else if (this.vzmstructure.Configuration.PrintMode=='SmartReport' ) {
      this.ReportName.Value( this.vzmstructure.Configuration.ReportName );
      this.spl_smartreport.Link();
    }*/
  }

  this.this_Loaded=function(){
    if(window.waitForFooter){
      return;
    }
    this.SetZoomTitle();
    if (viewHeaderFromConfig) { //se da configurazione stabilisco che non si vede il titolo faccio finta che non ci sia
      this.getZoomtitlesRefsByProperty('SetLinkedConfs', function(portlet){
        portlet.SetLinkedConfs(this.vzmstructure.Configuration.linkedConfs);
      }, this);
    }
  }


  this.getNumRecords=function(){
    if(this.yet_done){
      return this.dataobj.GetQueryCount();
    }
  }

  this.Grid_Rendered_Online=function() { //ho preferito dare nome Online per non modificare la Impl usata nell'offline
    this.Grid.Ctrl.style.opacity=1;
    var toolbar=viewMode=='chart'?this.toolbar2:this.toolbar;
    if (this.hasZoomtitlesID('SetButtons') || (toolbar && viewToolbarFromConfig)) {
      var btn = LibJavascript.DOM.Ctrl(this.Grid.ctrlid+'_row_layer_expandreduce');
      if (btn) btn.style.display='none';
    }
    SetHamburgerInit.call(this); //quando si va a ridisegnare la griglia non sempre si rifa la query
  }
  this.Grid_Rendered_Impl=function() {
    if (this.PrintMode && this.PrintMode.Value())
      this.Grid.scrollertable=null;
    this.Grid_Rendered_Online();
  }
  this.dataobj_QueryExecuted_Impl=function() {
    var i, j, ii;
    if(this.yet_done || !this.vzmstructure){
      if(this.yet_done){
        this.$entity$_NumberOfLoadedRecords.Emit();
      }
      SetHamburgerInit.call(this); //da tenere qui sempre per inizializzare la funzione ad ogni ridisegno
      return;
    }
    viewHeaderFromConfig=(typeof(this.vzmstructure.Configuration.header)=='undefined' || this.vzmstructure.Configuration.header=='true');
    viewToolbarFromConfig=(this.vzmstructure.Configuration.header=='toolbar');
    SetHamburgerInit.call(this); //da tenere qui sempre per inizializzare la funzione ad ogni ridisegno
    this.yet_done=true;
    this.vzmstructure.Configuration=this.vzmstructure.Configuration||{}
    this.Specific={};
    this.Specific.User=parseInt(this.vzmstructure.Configuration.User,10);
    this.Specific.Group=parseInt(this.vzmstructure.Configuration.Group,10);
    this.Specific.Custom=this.vzmstructure.Configuration.Custom=="true";
    if (this.vzmstructure.Configuration.CountRows && !this.splinker.offline) { //offline non ha countrows implementato
      this.dataobj.count= this.vzmstructure.Configuration.CountRows;
    }

    if((this.ConfigScroll && this.ConfigScroll.Value()=='infinite') || this.vzmstructure.Configuration.infiniteScroll=='true' ||
      ZtVWeb.IsMobile() /* && this.vzmstructure.Configuration.infiniteScroll!='false'  */){
      this.SetGridScroll(true);
    }
    else this.SetGridScroll(false);

    if (this.vzmstructure.Configuration && ((this.vzmstructure.Configuration.OrderBy && this.vzmstructure.Configuration.OrderBy=="false") || !this.vzmstructure.Configuration.OrderBy)){
      this.confOrderBy=false;
    }
    var ordered_cols=[];
    if (this.vzmstructure.Configuration &&  this.vzmstructure.Configuration.OrderBy && this.vzmstructure.Configuration.OrderBy=="true") {
      this.confOrderBy=true;
    }

    var cge=this.ConfigGridElements.Value()
    //toglie filtro
    if(cge.match(/-f/i) || (typeof(this.vzmstructure.Configuration.filters)!='undefined' && this.vzmstructure.Configuration.filters=='false')){
      this.Grid.show_filters='false';
      delete this.Grid.filterByExample;
      if (this.GridChart) {
        this.GridChart.show_filters='false';
      }
    } else {
      this.Grid.show_filters='true';
      if (!ZtVWeb.IsMobile() ) {
        this.Grid.filterByExample='true';
      }
      if (this.GridChart) {
        this.GridChart.show_filters='true';
      }
    }
    if (this.vzmstructure.Configuration.Autozoom) {
      this.Autozoom.Value(this.vzmstructure.Configuration.Autozoom);
      this.SetReceivers();
    } else
      this.Autozoom.Value(paramAutozoom);

    this.EntityType.Value(this.vzmstructure.Configuration.entityType ? this.vzmstructure.Configuration.entityType : paramEntityType );

    //imposta i PKFields e Autozoom letti da XDC se non vengono passati manualmente
    if(EmptyString(this.PKFields.Value())){
      this.PKFields.Value(this.vzmstructure.Configuration.PKFields);
    }

    if(!EmptyString(this.Autozoom.Value()) && !EmptyString(this.PKFields.Value())){
      if (this.m_cAction && this.m_cAction.Value()=="autozoom")
        this.Grid.autozoom=this.Autozoom.Value()+(this.m_cAltInterface?"?m_cAltInterface="+this.m_cAltInterface.Value():"");
        this.Grid.autozoom=this.Autozoom.Value()+(this.m_cZoneAltInterface?"?m_cZoneAltInterface="+this.m_cZoneAltInterface.Value():"");
    }

    this.Grid.show_btn_update = this.vzmstructure.Configuration.show_btn_update||'false';
    this.Grid.show_btn_delete = this.vzmstructure.Configuration.show_btn_delete||'false';
    this.Grid.m_cID = this.vzmstructure.Configuration.editboid||'';
    this.splinker.m_cID = this.vzmstructure.Configuration.m_cID||'';
    this.Grid.checkbox=false;
    this.Grid.hmg_as_filter=false;
    this.Grid.sel_fields=this.PKFields.Value().split(',');
    if (this.Grid.show_btn_update === 'true' || this.Grid.show_btn_delete === 'true') {
      this.Grid.business_obj=this.Autozoom.Value();
      this.Grid.keepMemCurs=true;
      //this.Grid.sel_fields=this.PKFields.Value().split(',');
      if (this.Grid.show_btn_delete === 'true') {
        this.Grid.checkbox=true;
      }
      this.Grid.confirmBODeleteMsg=this.vzmstructure.Configuration.confirmBODeleteMsg_trad||this.vzmstructure.Configuration.confirmBODeleteMsg||''
      this.Grid.BOSavedOkMsg=this.vzmstructure.Configuration.BOSavedOkMsg_trad||this.vzmstructure.Configuration.BOSavedOkMsg||''
    } else {
      this.Grid.keepMemCurs=false;
      //if (isHistoricalZoom && cge.match(/-e/i)==null) {
        //this.Grid.sel_fields=this.PKFields.Value().split(',');
      //} else {
        //this.Grid.sel_fields=[];
      //}
      this.Grid.business_obj='';
      this.Grid.confirmBODeleteMsg=''
      this.Grid.BOSavedOkMsg=''
    }
    this.Grid.checkbox=false;
    this.Grid.checkboxAll=false;
    this.Grid.checkboxAllOfPage=false;
    if((this.ActivateCheckbox && this.ActivateCheckbox.Value()=='true') || this.vzmstructure.Configuration.activateCheckbox=='true'){
      this.Grid.checkbox='true';
      this.Grid.sel_fields=this.PKFields.Value().split(',');
    }
    if((this.ActivateCheckboxAll && this.ActivateCheckboxAll.Value()=='true') || this.vzmstructure.Configuration.activateCheckboxAll=='true' ||
      this.vzmstructure.Configuration.activateCheckbox=='true-selectAll'){
      this.Grid.checkbox=true;
      this.Grid.checkboxAll=true;
      this.Grid.sel_fields=this.PKFields.Value().split(',');
    }
    if((this.ActivateCheckboxAll && this.ActivateCheckboxAll.Value()=='true-of-Page') || this.vzmstructure.Configuration.activateCheckbox=='true-selectAllOfPage'){
      this.Grid.checkbox=true;
      this.Grid.checkboxAll=true;
      this.Grid.checkboxAllOfPage=true;
      this.Grid.sel_fields=this.PKFields.Value().split(',');
    }
    var ds=this.dataobj;
    //griglia estensibile
    var foundExtFlds = false, foundExtraTitle=false;
    var cols=[],col;
    var cloneCol=function (myObj){
      if(myObj == null) return myObj;
      var myNewObj = {};
      for(var i in myObj) {
        if (i=='Layer')
          myNewObj[i] = []
        else
          myNewObj[i] = myObj[i];
      }
      return myNewObj;
    };
    if( ZtVWeb.IsSmartphone() ){
      var plain_grid = this.vzmstructure.Cols.every(function(col){
        return !col.new_line;
      });
      if(false && plain_grid) { // solo se la cfg non ha colonne a capo
        if(false){
          var temp = [], cf;
          for (i = 0, l = this.vzmstructure.Cols.length; i < l; i++){
            cf = this.vzmstructure.Cols[i];
            temp.push({field: "html:"+(cf.title||''), new_line: i>0?true:false, align: "right", "class": "columnar_title", Layer:[], fixedwidth:'1px'})
            // cf.title_attr = cf.title_trad || cf.title || '';
            cf.title = '';
            delete cf.title_trad;
            cf.class = (cf.class||'')+' columnar_value';
            temp.push(cf);
          }
          this.vzmstructure.Cols = temp;
          // this.Grid.floatRows=true;
        } else {

          for (i = 0, l = this.vzmstructure.Cols.length; i < l; i++){
            cf = this.vzmstructure.Cols[i];
            cf.class = (cf.class||'')+' columnar_value';
            cf.new_line = i>0 ?true:(cf.newline||false);
            cf.title_attr = cf.title_trad || cf.title || '';
            // cf.title = '';
            delete cf.title_trad;
            // this.Grid.floatRows=true;
          }
        }
        if(this.vzmstructure.Configuration.titles != "extra"){
          this.vzmstructure.Configuration.titles = "false";
          this.Grid.renderTitles=false;
        }
      }
    }
    for (i=0;i<this.vzmstructure.Cols.length;i++) {
      col=cloneCol(this.vzmstructure.Cols[i]);
      if(advanced_suggester_active && advanced_suggester.indexOf(col.field) == -1) {
        continue; // se advanced_suggester attivo e la colonna non è nell'array la salto
      }
      col.isCheckbox = col.checkbox;
        if (col.orderbyidx && this.confOrderBy){
          ordered_cols[col.orderbyidx-1]=col;
        }
        if (col.title_trad){
          col.title_orig=col.title;
          col.title=col.title_trad;
          delete col.title_trad;
        }
        if (col.tooltip_trad){
          col.tooltip_orig=col.tooltip;
          col.tooltip=col.tooltip_trad;
          delete col.tooltip_trad;
        }
        adjImgItem(col);
        if(col.isInitLetter){
          col.field = 'initletter:'+col.field ;
        }
        if(col.isInitLetter2){
          col.field = 'initletter2:'+col.field ;
        }
        if (col.title_tooltip_trad){
          col.title_tooltip_orig=col.title_tooltip;
          col.title_tooltip=col.title_tooltip_trad;
          delete col.title_tooltip_trad;
        }
        if (col.tileBackgroundColor_trad){
          col.tileBackgroundColor_orig=col.tileBackgroundColor;
          col.tileBackgroundColor=col.tileBackgroundColor_trad;
          delete col.tileBackgroundColor_trad;
        }
        if (col.tileVersion_trad){
          col.tileVersion_orig=col.tileVersion;
          col.tileVersion=col.tileVersion_trad;
          delete col.tileVersion_trad;
        }
        if (col.picture!="" && (ZtVWeb.getTypeFromPict(col.picture)).match(/N/) && Empty(col.align)) {
          col.orig_align='';
          col.align="right";
        }
        if (isHistoricalZoom && col.field =='cpfromdate') {
          col.editable = true;
        }
        if(col.inExtGrid==1){//assegna e se vero non prosegue
          foundExtFlds=true;
        }
        if (col.tileVisibility=='extended') {
          foundExtFlds=true;
        }
        foundExtraTitle=foundExtraTitle||col.show_extra_title;
        var cl;
        for (j=0; j<this.vzmstructure.Cols[i].Layer.length; j++){
          // if (this.vzmstructure.Cols[i].Layer[j].hidden!==true){
            cl=cloneCol(this.vzmstructure.Cols[i].Layer[j]);
            cl.isCheckbox = cl.checkbox;
            if (cl.title_trad){
              cl.title_orig=cl.title;
              cl.title=cl.title_trad;
              delete cl.title_trad;
            }
            if (cl.tooltip_trad){
              cl.tooltip_orig=cl.tooltip;
              cl.tooltip=cl.tooltip_trad;
              delete cl.tooltip_trad;
            }
            adjImgItem(cl);
            if (cl.title_tooltip_trad){
              cl.title_tooltip_orig=cl.title_tooltip;
              cl.title_tooltip=cl.title_tooltip_trad;
              delete cl.title_tooltip_trad;
            }
            if (cl.picture!="" && (ZtVWeb.getTypeFromPict(cl.picture)).match(/N/) && Empty(cl.align)) {
              cl.orig_align='';
              cl.align="right";
            }
            col.Layer.push(cl);
            if (cl.inExtGrid==1)
              foundExtFlds=true;
            foundExtraTitle=foundExtraTitle||cl.show_extra_title;
          // }
        }
        cols.push(col);
      // }
    }
    var rowLayer=[], rl;
    // eslint-disable-next-line no-cond-assign
    for(i=0; rl=this.vzmstructure.RowLayer[i];i++){
      // if (true ||  rl.hidden!==true){
        rl.isCheckbox = rl.checkbox;
        if (rl.title_trad){
          rl.title_orig=rl.title;
          rl.title=rl.title_trad;
          delete rl.title_trad;
        }
        if (rl.tooltip_trad){
          rl.tooltip_orig=rl.tooltip;
          rl.tooltip=rl.tooltip_trad;
          delete rl.tooltip_trad;
        }
        adjImgItem(rl);
        if (rl.picture!="" && (ZtVWeb.getTypeFromPict(rl.picture)).match(/N/) && Empty(rl.align)) {
          rl.orig_align='';
          rl.align="right";
        }
        rowLayer.push(rl);
        if (rl.inExtGrid==1)
          foundExtFlds=true;
        foundExtraTitle=foundExtraTitle||rl.show_extra_title;
      // }
    }
    if (this.vzmstructure.Configuration &&  this.vzmstructure.Configuration.OrderBy && this.vzmstructure.Configuration.OrderBy=="true") {
      //costruisco la stringa di orderby
      var ordbystr='';
      for(i=0; i<ordered_cols.length; i++){
        var _col;
        // eslint-disable-next-line no-cond-assign
        if (_col=ordered_cols[i])
          ordbystr += (_col.field_orig||_col.field)+
            (_col.orderbystatus=='desc' ? ' desc' : '')+
            (i!=ordered_cols.length-1 ? ', ' : '');
      }
      this.dataobj.setOrderBy(ordbystr);
    }

    if (this.vzmstructure.HideFields) {
      this.HideFields={};
      for (j in this.vzmstructure.HideFields){
        this.HideFields[j.toUpperCase()]=this.vzmstructure.HideFields[j];
      }
    }
    this.Grid.dontupdate=!this.WaitForFilter.Value();//quando il portlet non e' in attesa di un filtro non viene fatto il rendering a griglia vuota
    //griglia assegna colonne
    this.Grid.SetColumns(cols);
    if (this.GridChart)
      this.GridChart.SetColumns(JSON.parse(JSON.stringify(cols)));
    //griglia assegna rowLayer
    this.Grid.SetRowLayer(rowLayer);

    var gridRows=Val(this.vzmstructure.Configuration.GridRows);
    //lo scroll infinito deve avere almeno 100 righe altrimenti diventa macchinoso mentre si scrolla
    if(this.Grid.scroll_bars == 'infinite_scroll'){
      if(gridRows < 100){
        gridRows = 100;
      }
    }
    //griglia assegna numero di righe
    if (gridRows && gridRows>0 && !this.RowsParamValid){
      this.dataobj.nRows = this.Grid.rows = gridRows;
    } else {
      this.dataobj.nRows = this.Grid.rows = this.GridRowsParam.Value();
    }
    var extensible = (foundExtFlds ? this.Extensible.Value() || 'true' : 'false');
    this.Grid.existsExtensible=foundExtFlds;
    this.Grid.extFields=(foundExtFlds? ['true']:[]);//retrocompatibilita decoratori
    this.Grid.isShowExtraTitles=foundExtraTitle;
    var extend;
    if(extensible.match(/false/i)){
      extensible='false';
    } else if(extensible.match(/true/i)){
      extensible='open-reduced';
      extend=false;
    }
    if(extensible.match(/open\-reduced/i)){
      extensible='open-reduced';
      extend=false;
    }
    if(extensible.match(/open\-extended/i)){
      extensible='open-extended';
      extend=true;
    }
    if (typeof(extend)!='undefined')
      this.Grid.SetExpanded(extend);
    else
      this.Grid.extensible=extensible;
    if (this.hasZoomtitlesID('SetButtons')) {
      this.Grid.TopToolsbar.RemoveItem('expandoreduce_itm');
    } else
      this.Grid.TopToolsbar.GetItem('expandoreduce_itm').grid_Rendered();


    //griglia layer di riga
    if((EmptyString(this.ConfigGridElements.Value()) || this.ConfigGridElements.Value().toUpperCase().indexOf('-L')==-1) && !ZtVWeb.IsMobile()){
      this.Grid.forceRowLayerColumn(true);
    }
    //assegna VQRName
    if(!EmptyString(this.vzmstructure.Configuration.VQRName)){
      this.VQRName.Value(this.vzmstructure.Configuration.VQRName);
    }
    //assegna i diritti di accesso
    function CanViewBtn(type,chr) {
      var viewBtn;
      if ( cge.match(new RegExp('\\+'+chr,'i')) ) {
        viewBtn = true;
      } else if ( cge.match(new RegExp('-'+chr,'i')) ) {
        viewBtn = false;
      } else if ( this.vzmstructure.Configuration['Link'+type]==='force' ) {
        viewBtn = true;
      } else if ( this.vzmstructure.Configuration['Link'+type]==='false' ) {
        viewBtn = false;
      } else if (type=='Add' && !Empty(this.vzmstructure.Configuration.newAction))
        viewBtn=true;
      else {
        viewBtn = this.vzmstructure.Configuration['AutozoomCan'+type];
      }
      return viewBtn;
    }
    var viewBtn = CanViewBtn.call(this,'Access','v');
    var editBtn = CanViewBtn.call(this,'Edit','e');
    var deleteBtn = CanViewBtn.call(this,'Delete','d');
    var addBtn = CanViewBtn.call(this,'Add','n');
    this.autozoomCanAdd = addBtn;
    this.Grid.SetSPLinkerActions((viewBtn?'+':'-')+'V'+(editBtn?'+':'-')+'E'+(deleteBtn?'+':'-')+'D'+(addBtn?'+':'-')+'N');

    if(cge.match(/-q/i)){
      this.Grid.SPLinkerActions.V.action='query';
    }
    if(cge.match(/-t/i)) {
      this.Grid.renderTitles=false;
      if (this.GridChart) {
        this.GridChart.renderTitles=false;
        if (this.GridChart.show_filters=='false') {
          this.GridChart.Ctrl.display='none';
        }
      }
    } else {
      this.Grid.renderTitles=(typeof(this.vzmstructure.Configuration.titles)=='undefined' || this.vzmstructure.Configuration.titles=='true' || this.vzmstructure.Configuration.titles=='extra');
      this.Grid.hide_default_titles=this.vzmstructure.Configuration.titles=='extra'
      if (this.GridChart) {
        this.GridChart.renderTitles=(typeof(this.vzmstructure.Configuration.titles)=='undefined' || this.vzmstructure.Configuration.titles=='true'  || this.vzmstructure.Configuration.titles=='extra');
        this.GridChart.hide_default_titles=this.vzmstructure.Configuration.titles=='extra'
        if (!this.GridChart.renderTitles) {
          this.GridChart.Ctrl.style.display='none';
        } else {
          this.GridChart.Ctrl.style.display='inline-block';
        }
      }
    }
    //toglie righe vuote
    if(cge.match(/-s/i) || (typeof(this.vzmstructure.Configuration.emptyrows)!='undefined' && this.vzmstructure.Configuration.emptyrows=='false')){
      this.Grid.empty_rows='false';
    } else {
      this.Grid.empty_rows='true';
    }

    this.GridRows.Value(this.Grid.rows);
    if(!Empty(this.vzmstructure.Configuration.portlet_in_row)){
      this.Grid.portlet_in_row = this.vzmstructure.Configuration.portlet_in_row;
    }else{
      this.Grid.portlet_in_row = '';
    }
    if(!Empty(this.vzmstructure.Configuration.start_in_row)){
      this.Grid.start_in_row = this.vzmstructure.Configuration.start_in_row;
    }
    //posiziona i tools
    var tpos=this.Tools_Position.Value().toLowerCase();
    var pos;
    if(!EmptyString(tpos)){
      pos='left';
      switch(tpos){
        case 'left-layer' : pos='left-layer' ; break;
        case 'right'      : pos='right'      ; break;
        case 'right-layer': pos='right-layer'; break;
        case 'toolsbar'   : pos='toolsbar'   ; break;
        case 'expanding-row': pos='expanding-row'; break;
        case 'swipe': pos='swipe'; break;
      }
      this.Grid.SplinkerToolsPosition(pos);
    } else if (this.vzmstructure.Configuration.toolsPosition) {
      pos='left';
      switch(this.vzmstructure.Configuration.toolsPosition){
        case 'left-layer' : pos='left-layer' ; break;
        case 'right'      : pos='right'      ; break;
        case 'right-layer': pos='right-layer'; break;
        case 'toolsbar'   : pos='toolsbar'   ; break;
        case 'expanding-row' : pos='expanding-row'; break;
        case 'swipe': pos='swipe'; break;
      }
      this.Grid.SplinkerToolsPosition(pos);
    } else if (SPTheme.portalZoomSplinkerPosition) {
      pos='left';
      switch(SPTheme.portalZoomSplinkerPosition){
        case 'left-layer' : pos='left-layer' ; break;
        case 'right'      : pos='right'      ; break;
        case 'right-layer': pos='right-layer'; break;
        case 'toolsbar'   : pos='toolsbar'   ; break;
        case 'expanding-row': pos='expanding-row'; break;
        case 'swipe': pos='swipe'; break;
      }
      this.Grid.SplinkerToolsPosition(pos);
    }

    if(!EmptyString(this.Autozoom.Value()) && !EmptyString(this.PKFields.Value())){
      this.SetSPLinkers();
    }
    if ( Empty(this.SetDelMessage.Value()) && (!Empty(this.vzmstructure.Configuration.delMessage_trad) || !Empty(this.vzmstructure.Configuration.delMessage) ) ) {
      this.splinker.DeleteMessage(this.vzmstructure.Configuration.delMessage_trad||this.vzmstructure.Configuration.delMessage);
    }
    var gridClass = !Empty(this.vzmstructure.Configuration.css_class) ? this.vzmstructure.Configuration.css_class : 'grid';
    gridClass = this.ViewMode.Value() == "card" && gridClass == "grid" ? "gridFloat" : gridClass;
    gridClass = this.vzmstructure.Configuration.defaultViewMode=="card" && gridClass == "grid" ? "gridFloat" : gridClass;
    this.Grid.CssClass(gridClass,this.Grid.name+"_ctrl");
    var gridClassSingle = !Empty(this.vzmstructure.Configuration.css_class_card_container) ? this.vzmstructure.Configuration.css_class_card_container : '';
    this.Grid.css_class_card_container = gridClassSingle;
    //imposta la caption
    //dipendenza da this.vzmstructure.Configuration.Caption
    this.SetCaption();
    if(!this.Options){//sovrascritta all'apertura di options
      this.Options=function(){};
    }

    this.Grid.TopToolsbar.RemoveItem('filter_itm');
    if (this.GridChart)
      this.GridChart.TopToolsbar.RemoveItem('filter_itm');
    var toolbar=this.toolbar,label=this.label;
    if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart'))){
      toolbar=this.toolbar2;
      label=this.label2;
    }
    if (toolbar && !this.ConfigGridElements.Value().match(/-b/i)  && viewToolbarFromConfig) {
      toolbar.Show();
      label.Ctrl.style.right='';
      label.minheight=10;
      label.shrinkable='false';
      toolbar.getRenderHeight=null;
      if (!SPTheme.portalZoomVersionItemOnLabel) {

        toolbar.Append({
          id: 'versions_itm',
          title: this.Grid.Translations['Versions']||'Versioni',
          tooltip: this.Grid.Translations['Versions']||'Versioni',
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

      var linkedConfs = this.vzmstructure.Configuration.linkedConfs;
      if (linkedConfs && linkedConfs.length>0) {
        var img,lConfAct;
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
          , title : linkedConfs[ii].title_trad || ''
          , tooltip : linkedConfs[ii].title_trad || ''
          , image: img||''
          , action : 'javascript:'+this.formid+'.ChangeConfiguration('+(ii)+')'
          }
          // if (!toolbar.AppendBefore(lConfAct,'expandreduce'))
          toolbar.Append(lConfAct,ii+(this.autozoomCanAdd && !EmptyString(this.Grid.splinker)?1:0));
        }
      }
      if (this.autozoomCanAdd && !EmptyString(this.Grid.splinker)) {
        toolbar.Append({
          id: 'new_itm',
          title: this.Grid.Translations["New"],
          tooltip: this.Grid.Translations["New"],
          image: SPTheme.portalZoomAddRecordImage||'',
          action: 'javascript:'+this.formid+'.AddNewRecord();'
        },0);
      }
      else {
        toolbar.Remove('new_itm');
      }
      if ((this.vzmstructure.Configuration.filters!="false" || !Empty(this.vdmName)) && this.vzmstructure.Configuration.hideFiltersBtn!='true'){
        var vdmAct={
          id: 'showVdm',
          title: this.Grid.Translations["Filters"],
          tooltip: this.Grid.Translations["Filters"],
          image: SPTheme.portalZoomShowVdmImage||'',
          action: 'javascript:'+this.formid+'.ShowVdmMask();'
        }
        if (!Empty(this.vdmName))
          toolbar.Append(vdmAct);
        else
          toolbar.AppendMenuItem(vdmAct);
      }
      if ( !this.ConfigGridElements.Value().match(/-p/i) && this.printModeSecurity) { //canPrint
        if ( (typeof(this.vzmstructure.Configuration.PrintMode)=='undefined' || this.vzmstructure.Configuration.PrintMode!='None') ) {
          toolbar.Append({
            id: 'print_itm',
            title: this.Grid.Translations["Print"],
            tooltip: this.Grid.Translations["Print"],
            image: SPTheme.portalZoomPrintImage||'',
            action: 'javascript:'+this.formid+'.printZoom();'
          });
          this.Grid.print_result=true;
        } else {
          toolbar.Remove('print_itm');
          this.Grid.print_result=false;
        }
      }
      if (!this.splinker.offline) {
        toolbar.AppendMenuItem({
          id: 'refresh_itm',
          title: this.Grid.Translations["Refresh"],
          tooltip: this.Grid.Translations["Refresh"],
          image: SPTheme.portalZoomRefreshImage||'',
          action: 'javascript:'+this.formid+'.refreshQuery();'
        });
      }
      if(this.Grid.extensible=='false' || EmptyArray(this.Grid.extFields)){
        //nascosti
        toolbar.Remove('expandreduce');
      }else{
        var isextended = this.Grid.IsExtended();
        if (toolbar.IsInToolbar('expandreduce') || toolbar.IsInMenu('expandreduce'))
          toolbar.UpdateItem('expandreduce', {
              title: isextended ? this.Grid.Translations["Reduce_grid"] : this.Grid.Translations["Expand_grid"],
              image:isextended?(SPTheme.portalZoomReduceImage||{fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"}):
              (SPTheme.portalZoomExpandImage||{ fontFamily:'icons8_win10', value: "&#xee18", size: "20px"})
          });
        else {
          var act={
            id:'expandreduce',
            title: isextended ? this.Grid.Translations["Reduce_grid"] : this.Grid.Translations["Expand_grid"],
            action:'javascript:'+this.formid+'.expandOReduce();',
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

    } else {
      if (toolbar) {
        toolbar.Hide();
      }
      label.minheight=10;
      label.Ctrl.style.right='0px';
      label.shrinkable='true';
    }
    this.addTotalizer();
    var tabstrip=window[this.formid+'_tabstrip'];
    ds.rowsconsumers=[];
    //se il default e' card ma viene passato "grid" devo annullare il card
    if ((this.vzmstructure.Configuration.defaultViewMode=='card' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='card')) {
      if (!Empty(this.vzmstructure.Configuration.paddingCard))
        this.Grid.paddingFloat = parseInt(this.vzmstructure.Configuration.paddingCard);
      if (!Empty(this.vzmstructure.Configuration.marginCard))
        this.Grid.marginFloat = parseInt(this.vzmstructure.Configuration.marginCard);
      this.Grid.floatRows=true;
      this.Grid.empty_rows='false';
      this.Grid.recMark='false';
      //delete this.Grid.filterByExample;
      this.Grid.TopToolsbarTogglerLocked=true;
      this.Grid.HideTopToolsbarToggler();
      if (tabstrip){
        tabstrip.Collapse("page2");
        tabstrip.Expand("page1");
        this.Chart.DontUpdate(true);
        this.GridChart_FiltersCreated=null;
        this.Chart._refresh = null;
      }
      ds.addRowConsumer(this.Grid);
      viewMode="card";
      this.Grid.CssClass(gridClass,this.Grid.name+"_ctrl");
    }
    else if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart'))){
      tabstrip.Collapse("page1");
      tabstrip.Expand("page2");
      this.Chart.setDef(this.vzmstructure.Configuration.chartDef);
      this.Chart.dontOverwrite = true;
      // 5062/SS
      var ctrlW = this.Ctrl.offsetWidth - 2,  // bordi
      theoricalHeight = this.Grid.rowMinHeight * this.Grid.rows,
      minHeight = parseInt(this.vzmstructure.Configuration.chartminH) || 150,
      maxHeight = parseInt(this.vzmstructure.Configuration.chartmaxH) || 300,
      chartHeight = Math.max(theoricalHeight, minHeight);
      chartHeight = Math.min(chartHeight, maxHeight);

      this.Chart.setCtrlChartSize(ctrlW, chartHeight);
      this.Chart.setChartSize(ctrlW, chartHeight);
      this.Chart._refresh = function () {
        var formW = this.form.Ctrl.offsetWidth - 2; // bordi
        if (!this._ztc()) {
          this.DontUpdate(false);
          this.setCtrlChartSize(formW, chartHeight);
          this.adjustFormHeight();
          this._drawChart();
          return;
        }
        if (!this._applyNewSize(formW, chartHeight))
          return;
        this.setCtrlChartSize(formW, chartHeight);
        this.Ctrl.style.top = this.form.GridChart.Ctrl.offsetHeight + "px";
        this.setChartSize(formW, chartHeight);
        this.adjustFormHeight();
        this._drawChart();
      }
      this.Chart.compactChart = this.vzmstructure.Configuration.compactChart || "none";
      this.Chart.manualScale = this.vzmstructure.Configuration.manualScale || false;
      this.Chart.setChartType(this.vzmstructure.Configuration.chart_type);
      if (this.vzmstructure.Configuration.chart_type=='geo'){
        /*this.Chart.setFieldsGeoChart(
          this.vzmstructure.Configuration.geo_0_field, this.vzmstructure.Configuration.geo_1_field,
          this.vzmstructure.Configuration.geo_value_field, this.vzmstructure.Configuration.geo_dom_field,
          this.vzmstructure.Configuration.geo_level, this.vzmstructure.Configuration.geo_view
        );*/
        this.Chart.geo_0_field = this.vzmstructure.Configuration.geo_0_field;
        this.Chart.geo_1_field = this.vzmstructure.Configuration.geo_1_field;
        this.Chart.geo_dom_field = this.vzmstructure.Configuration.geo_dom_field;
        this.Chart.geo_value_field = this.vzmstructure.Configuration.geo_value_field;
        this.Chart.geo_view_select = this.vzmstructure.Configuration.geo_view_select;
        this.Chart.geo_view = this.vzmstructure.Configuration.geo_view;
        this.Chart.geo_level_2 = this.vzmstructure.Configuration.geo_level_2;
        this.Chart.geo_level_3 = this.vzmstructure.Configuration.geo_level_3;
        this.Chart.geo_level = this.vzmstructure.Configuration.geo_level;
        this.Chart.geo_onlydata = this.vzmstructure.Configuration.geo_onlydata;
        this.Chart.propertyName = [];
        this.Chart.makePropertyName(this.Chart.chart_type);
      }
      else {
        var domain,values,series,key;
        switch (this.vzmstructure.Configuration.chart_type){
          case 'xyz':
            domain=this.vzmstructure.Configuration.x_field;
            values=this.vzmstructure.Configuration.y_field+","+this.vzmstructure.Configuration.z_field;
            series=this.vzmstructure.Configuration.xyz_series_field
            key=this.vzmstructure.Configuration.xKey_field
          break;
          case 'measure':
            domain=this.vzmstructure.Configuration.measure_series_field;
            values=this.vzmstructure.Configuration.min_field+","+this.vzmstructure.Configuration.max_field+","+this.vzmstructure.Configuration.val_field;
            series="";
            key=this.vzmstructure.Configuration.measureKey_series_field;
          break;
          default:
            domain=this.vzmstructure.Configuration.labelField;
            values=this.vzmstructure.Configuration.valueFields;
            series=this.vzmstructure.Configuration.label_series;
            key=this.vzmstructure.Configuration.labelKey_field;
        }
        this.Chart.setFields(domain,values,series,key);
      }
      /*this.Chart.DontUpdate(false);
      this.Chart.Draw();
      this.Chart.DontUpdate(true);*/
      this.GridChart_FiltersCreated=function(){
        this.dataobj2.queryfilter=this.dataobj.queryfilter
        this.dataobj.queryfilter='[{"ED" : true }]';
        this.Chart.DontUpdate(false);
        this.dataobj2.Query();
      }
      ds.addRowConsumer(this.GridChart);
      this.GridChart.recMark=( viewHeaderFromConfig && this.hasZoomtitlesID('SetButtons') ? 'false' : 'true');
      viewMode="chart";
    }
    else {
      this.Grid.floatRows=false;
      if(this.ConfigGridElements.Value().match(/-r/i)){
        this.Grid.recMark='false';
      } else if(this.ConfigGridElements.Value().match(/\+r/i)){
        this.Grid.recMark='true';
      } else if (this.vzmstructure.Configuration.recordmark=='false'){
        this.Grid.recMark='false';
      } else {
        this.Grid.recMark='true';
      }
      if (ZtVWeb.IsMobile()) {
        this.configModeSecurity=Min(configModeSecurity,1);
      } else {
        this.configModeSecurity=configModeSecurity;
      }
      if (tabstrip){
        tabstrip.Collapse("page2");
        tabstrip.Expand("page1");
        this.Chart.DontUpdate(true);
        this.GridChart_FiltersCreated=null;
        this.Chart._refresh = null;
      }
      ds.addRowConsumer(this.Grid);
      viewMode="grid";
      this.Grid.CssClass(gridClass,this.Grid.name+"_ctrl");
      this.Grid.group_repeated=this.vzmstructure.Configuration.group_repeated;
    }
    //spostato per avere la viewMode corretta
    //aggiunge i tools alla griglia
    this.Grid.Tools=[];
    var tools = (viewMode=='chart' ? [] : this.Grid.Tools );
    if(!EmptyString(this.Tools_Urls.Value())){
      var titles  =this.Tools_Titles.Value().split(',');
      var urls    =this.Tools_Urls.Value().split(',');
      var targets =this.Tools_Targets.Value().split(',');
      var imgs    =this.Tools_Imgs.Value().split(',');
      var tooltips=this.Tools_Tooltips.Value().split(',');
      var l=urls.length;
      for(i=0; i<l; i++){
        tools.push({
          Title  : titles[i]   || "",
          URL    : urls[i]     || "",
          Target : targets[i]  || "",
          Img    : Strtran(imgs[i],'|',',')  || "",
          Tooltip: tooltips[i] || "",
          CustomAction: true,
          MakeStdLink : true
        });
      }
    }
    var actions = this.vzmstructure.Configuration.actions;
    var defaultActions=[],rowActions=[],hamburgerActions=[];
    toolbar=viewMode=='chart'?this.toolbar2:this.toolbar;
    for (i=0;actions!=null && i<actions.length; i++) {
      if (actions[i].visibility=='row')
        rowActions.push(actions[i]);
      else if (actions[i].visibility!='none')
      defaultActions.push(actions[i]);
      if (actions[i].showInMenu=='true')
        hamburgerActions.push(actions[i]);
    }
    if (this.refresh_menu){
      ii=0;
      while( this.refresh_menu.Remove( 'action' + ii,null,'actions') ) {
        ii++;
      }
      for (i=0; i<hamburgerActions.length; i++){
        this.refresh_menu.Append({
          title: hamburgerActions[i].title_trad || "",
          tooltip: hamburgerActions[i].tooltip || hamburgerActions[i].title_trad || "",
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
        },'actions')
      }
    }

    if (viewHeaderFromConfig && this.hasZoomtitlesID('SetActions')) {
      this.getZoomtitlesRefsByProperty('SetActions', function(portlet){
        portlet.SetActions(defaultActions);
        if (viewMode!='chart'){
          for (i=0;i<rowActions.length; i++) {
            tools.push({
              Title  : rowActions[i].title_trad || "",
              URL    : "javascript:"+this.formid+".ExecAction("+LibJavascript.ToJSValue(JSON.stringify(rowActions[i]))+")",
              Target : '',
              Img    : rowActions[i].image_settings=='fontIcon'?{
                          font:rowActions[i].font_name,
                          size:rowActions[i].font_size,
                          value:rowActions[i].font_image,
                          color:rowActions[i].font_color
                      }:(rowActions[i].image||''),
              Tooltip: rowActions[i].tooltip || rowActions[i].title_trad || "",
              CustomAction : true,
              HideWhen : rowActions[i].hideWhen_trad
            });
          }
        }
      }, this);
    }
    else if (toolbar && viewToolbarFromConfig) {  // small zoom with actions
      if (viewMode=='chart'){ // sono in grafico
        for (i=0;defaultActions!=null && i<defaultActions.length; i++) {
          tools.push({
            Title  : defaultActions[i].title_trad || "",
            URL    : "javascript:"+this.formid+".ExecAction("+LibJavascript.ToJSValue(JSON.stringify(defaultActions[i]))+")",
            Target : '',
            Img    : defaultActions[i].image_settings=='fontIcon'?{
                        font:defaultActions[i].font_name,
                        size:defaultActions[i].font_size,
                        value:defaultActions[i].font_image,
                        color:defaultActions[i].font_color
                     }:(defaultActions[i].image||''),
            Tooltip: defaultActions[i].tooltip || defaultActions[i].title_trad || "",
            CustomAction : true,
            HideWhen : defaultActions[i].hideWhen_trad
          });
        }
      }
      else {
        ii=0;
        while( toolbar.Remove( 'action' + ii ) ) {
          ii++;
        }
        for (i=0;i<defaultActions.length; i++) {
          var action={
            id:'action'+i,
            title: defaultActions[i].title_trad,
            image: defaultActions[i].image_settings=='fontIcon'?{
              fontFamily:defaultActions[i].font_name,
              size:defaultActions[i].font_size,
              value:defaultActions[i].font_image,
              color:defaultActions[i].font_color
            }:defaultActions[i].image,
            tooltip : defaultActions[i].tooltip || defaultActions[i].title_trad,
            action: (function(ZoomObj,_action){
                    return function(evt) {
                      ZoomObj.ExecAction(_action,evt);
                    }
                    })(this,defaultActions[i]),
            target: ''
          }
          if (CharToBool(defaultActions[i].important)){
            if (!Empty(this.vdmName)){ // il bottone dei filtri � nella toolbar prima del bottone di espandi riduci
              if (!toolbar.AppendBefore(action,'showVdm') && !toolbar.AppendBefore(action,'expandreduce') && !toolbar.AppendBefore(action,'print_itm') && !toolbar.AppendBefore(action,'refresh_itm'))
                toolbar.Append(action);
            }
            else if (!toolbar.AppendBefore(action,'expandreduce') && !toolbar.AppendBefore(action,'print_itm') && !toolbar.AppendBefore(action,'refresh_itm') && !toolbar.AppendBefore(action,'showVdm')) // il bottone dei filtri � nel menu
                toolbar.Append(action);
          }
          else
            toolbar.AppendMenuItem(action);
        }
        for (i=0;i<rowActions.length; i++) {
          tools.push({
            Title  : rowActions[i].title_trad || "",
            URL    : "javascript:"+this.formid+".ExecAction("+LibJavascript.ToJSValue(JSON.stringify(rowActions[i]))+")",
            Target : '',
            Img    : rowActions[i].image_settings=='fontIcon'?{
                      font:rowActions[i].font_name,
                      size:rowActions[i].font_size,
                      value:rowActions[i].font_image,
                      color:rowActions[i].font_color
                    }:(rowActions[i].image||''),
            Tooltip: rowActions[i].tooltip || rowActions[i].title_trad || "",
            CustomAction : true,
            HideWhen : rowActions[i].hideWhen_trad
          });
        }
      }
    }
    else {
      actions=viewMode=='chart'?defaultActions:actions;
      for (i=0;actions!=null && i<actions.length; i++) {
        if (actions[i].showInMenu!="true" || actions[i].visibility=="row"){
          tools.push({
            Title  : actions[i].title_trad || "",
            URL    : "javascript:"+this.formid+".ExecAction("+LibJavascript.ToJSValue(JSON.stringify(actions[i]))+")",
            Target : '',
            Img    :  actions[i].image_settings=='fontIcon'?{
                        font:actions[i].font_name,
                        size:actions[i].font_size,
                        value:actions[i].font_image,
                        color:actions[i].font_color
                      }:(actions[i].image||''),
            Tooltip: actions[i].tooltip || actions[i].title_trad || "",
            CustomAction : true,
            HideWhen : actions[i].hideWhen_trad
          });
        }
      }
    }
    if ( viewToolbarFromConfig && tools !== this.Grid.Tools ) {
      ii=0;
      while( this.toolbar2.Remove( 'action' + ii ) ) {
        ii++;
      }
      for (ii=0;ii<tools.length;ii++) {
        this.toolbar2.AppendMenuItem({
          id:'action'+ii,
          title: tools[ii].Title,
          image: tools[ii].Img,
          tooltip : tools[ii].Tooltip,
          action: (function(ZoomObj,url) {
            return function() {
              var link = ZtVWeb.makeStdLink(url,ZoomObj.dataobj2.curRec-1,ZoomObj.dataobj2,null,ZoomObj,true);
              ZtVWeb.Popup(link,"",{});
            }
          })(this,tools[ii].URL),
          target: ''
        });
      }
    }
    if (viewHeaderFromConfig) { //se da configurazione stabilisco che non si vede il titolo faccio finta che non ci sia
      this.getZoomtitlesRefsByProperty('SetLinkedConfs', function(portlet){
        portlet.SetLinkedConfs(this.vzmstructure.Configuration.linkedConfs);
      }, this);
    }
    this.SetToolbarBox();
    this.SetCss();
    if(this.Grid.hasInjectedRow()){
      this.Grid.enablePreview = false;
    }else{
      this.Grid.enablePreview = true;
    }
  }
  //chiamata dall'emitter
  this.GetRS=function(){
    var curRS={};
    for(var p in this.dataobj.rs){
      curRS[p]=ZtVWeb.valueToStr(this.dataobj.rs[p],this.dataobj.fieldstypearray[this.dataobj.Fields_map[p.toLowerCase()]]);
    }
    return curRS;
  }
  //chiamata dall'emitter
  this.GetRS_EOF=function(){
    return this.dataobj.Data.length==1;
  }

  //imposta la proprieta' "configuration" dell'emitter _callChildren
  this.GetConfiguration=function(){
    return { Children: this.vzmstructure.Configuration.Children,
             EmitterName: this.$entity$_zoomSelectedRow.name
           };
  }

  this.refreshQuery=function(forceRefreshChild){
    if (viewMode=="chart"){
      this.Chart.Draw()
    }
    else {
      this.dataobj.SetForceRecordChanged(forceRefreshChild||false);
      this.Grid.Refresh(this.dataobj.keepCurRec); //viene riassegnato sempre, quindi bisogna passarlo in ogni caso
    }
  }

  this.GetReload=function() {
  return reload;
  }
  this.SetFilter=function(evt, first){
    var filters,filter='',has_rs_eof,PARENT_RS_EOF, has_forceRC,PARENT_SET_ORDERBY;
    var keepFixed=true, keepUserFilter=false, keepDefaultFilter=false, ignoreFilterMap=false;
    try{
      if (evt && evt.row && evt.row.removeFixed) {
        keepFixed=false;
      }
      if (evt && ( ( typeof(evt.keepDynamicFilter)=='boolean' && evt.keepDynamicFilter ) || ( evt.row && typeof(evt.row.keepDynamicFilter)=='boolean' && evt.row.keepDynamicFilter ) )) {
        keepUserFilter=keepDefaultFilter=true;
      } else {
        if (evt && ( ( typeof(evt.keepUserFilter)=='boolean' && evt.keepUserFilter ) || ( evt.row && typeof(evt.row.keepUserFilter)=='boolean' && evt.row.keepUserFilter ) )) {
          keepUserFilter=true;
        }
        if (evt && ( ( typeof(evt.keepDefaultFilter)=='boolean' && evt.keepDefaultFilter ) || ( evt.row && typeof(evt.row.keepDefaultFilter)=='boolean' && evt.row.keepDefaultFilter ) )) {
          keepDefaultFilter=true;
        }
      }
      if (evt && ( typeof evt.setOrderBy == 'object' && evt.setOrderBy.constructor.toString() == Array.toString() )) {
        PARENT_SET_ORDERBY=evt.setOrderBy;
        delete evt.setOrderBy;
      } else if  (evt && evt.row && ( typeof evt.row.setOrderBy == 'object' && evt.row.setOrderBy.constructor.toString() == Array.toString() )) {
        PARENT_SET_ORDERBY=evt.row.setOrderBy;
        delete evt.row.setOrderBy;
      }
      if (typeof PARENT_SET_ORDERBY != 'undefined') {
        this.Grid.SetOrderBy(PARENT_SET_ORDERBY);
        this.GridChart.SetOrderBy(PARENT_SET_ORDERBY);
      }
      // eslint-disable-next-line no-cond-assign
      if (has_forceRC = "forceRC" in evt) {
        this.dataobj.SetForceRecordChanged(evt.forceRC);
        delete evt.forceRC;
      }
      has_rs_eof= "RS_EOF" in evt
      PARENT_RS_EOF=evt.RS_EOF;
      delete evt.RS_EOF;//Ripristinato alla fine della funzione
      if (typeof(evt.ignoreFilterMap)=='boolean'){
        ignoreFilterMap=evt.ignoreFilterMap;
        delete evt.ignoreFilterMap;
      }

      //SetFilter con json esterno da RetrieveFilters (zoom o pivot)
      var cevt = this.convertToZoomFilters(evt);
      if( cevt.length > 0 ) evt = cevt;
      ///

      var n=0, i, f;
      for (n=0;typeof(evt[n])!='undefined';n++);
      //algoritmo per generare i filtri da una stringa, attenzione: funziona se prima e dopo l'operatore c'e uno spazio. Non pensato per operatori a piu parole.
      function parseFilter(filt,fixed) {
        if ( EmptyString(filt) ) return '';
        var newfilt = []
        var fltrs=LibJavascript.SplitNoConst(filt,' and ');
        for (var i = 0; i < fltrs.length; i++) {
          if (EmptyString(fltrs[i]))
            continue;
          var primospazio = fltrs[i].indexOf(" ");
          var field = fltrs[i].substring(0, primospazio);
          var secondospazio = fltrs[i].substring(primospazio + 1).indexOf(" ") + primospazio + 1;
          var operator = Lower(fltrs[i].substring(primospazio + 1, secondospazio));
          var exp = fltrs[i].substring(secondospazio + 1);
          if ( ( this.dataobj.Fields_map && this.dataobj.Fields_map[field.toLowerCase()] != undefined  )
             || (this.dataobj2 && this.dataobj2.Fields_map && this.dataobj2.Fields_map[field.toLowerCase()] != undefined  ) ) {
            var type;
            if (['=','<>','>','>=','<','<=','like','contains','empty','notempty'].indexOf(operator)==-1) {
              //operatore non valido
            } else if (exp.length > 1 && ((Left(exp, 1) == '"' && Right(exp, 1) == '"') || (Left(exp, 1) == "'" && Right(exp, 1) == "'"))) {
              type = "C";
              exp = exp.substring(1, exp.length - 1)
              exp = Strtran(exp, "''", "'");
              if (Empty(exp) ) {
                if ( operator == '=') {
                  operator = 'empty';
                } else if ( operator == '<>' || operator == '>') {
                  operator = 'notempty';
                }
              }
            } else if (exp.length > 1 && Left(exp, 1) == '{' && Right(exp, 1) == '}') {
              if (Left(exp, 2) == '{d')
                type = "D";
              if (Left(exp, 3) == '{ts')
                type = "T";
              var primoapice = exp.indexOf("'");
              var secondoapice = exp.substring(primoapice + 1).indexOf("'") + primoapice + 1;
              exp = exp.substring(primoapice + 1, secondoapice);
              if (exp.indexOf('0100-01-01') == 0) {
                if ( operator == '=') {
                  operator = 'empty';
                  exp = '';
                } else if ( operator == '<>') {
                  operator = 'notempty';
                  exp = '';
                }
              }
            } else {
              type = "N";
              if (exp == '0') {
                if ( operator == '=') {
                  operator = 'empty';
                  exp = '';
                } else if ( operator == '<>') {
                  operator = 'notempty';
                  exp = '';
                }
              }
            }
            var flt = {};
            flt[field] = exp;
            flt[field + "_op"] = operator;
            flt[field + '_type'] = type;
            flt[field + '_fixed'] = fixed;
            flt[field + '_visible'] = true;
            evt[n] = flt;
            n = n + 1;
          } else {
            newfilt.push(fltrs[i]);
          }
        }
        return newfilt.join(' and ');
      }
      //tutti i filtri che vengono gestiti dalla moschina vengono rimossi dalla stringa per non avere frasi errate.
      //es. campo = {d '0100-01-01} viene convertito con operatore empty
      this.FieldFilter.Value(parseFilter.call(this,this.FieldFilter.Value(),false));
      this.FixedFilter.Value(parseFilter.call(this,this.FixedFilter.Value(),true));
      filters=this.crumbObj(evt,ignoreFilterMap);
    }catch(e){
      has_rs_eof= false;
      PARENT_RS_EOF=false;
      filters=[];
      keepFixed=false;
      keepUserFilter=false;
    }
    //rimuove i filtri precedenti
    this.Grid.RemoveAllFilters(keepFixed,true,keepUserFilter, keepDefaultFilter); //primo parametro->false:elimina filtri fissi; secondo parametro->true:elimina filtri nascosti
    //l'oggetto evt e' condiviso dagli altri reciver. ATTENZIONE A  MODIFICARLO!
    if (this.GridChart)
      this.GridChart.RemoveAllFilters(keepFixed,true,keepUserFilter);
    if(!this.WaitForFilter.Value() || !PARENT_RS_EOF){
      this.updateFilterVisibility();
      //imposta il filtro sul dataprovider
	  if( !Empty(this.dataobj.parms) && this.dataobj.parms[this.dataobj.parms.length-1] != ',' ) this.dataobj.parms+=','
    if (this.dataobj2) {
	    if( !Empty(this.dataobj2.parms) && this.dataobj2.parms[this.dataobj2.parms.length-1] != ',' )
      this.dataobj2.parms+=','
    }
      if(this.Grid.datasource || (viewMode=='chart' && this.GridChart.datasource)){
        // eslint-disable-next-line no-cond-assign
        for(i=0,f; f=filters[i]; i++){
          if (f.queryparm!="") {
            if(this[f.queryparm] && this[f.queryparm].Value){
              this[f.queryparm].Value(f.expression);
            } else {
              this[f.queryparm]=new this.Var(f.expression);
              this.dataobj.parms+=f.queryparm+",";
              if (viewMode=='chart')
                this.dataobj2.parms+=f.queryparm+",";
            }
          } else {
            var fidx;
            if((fidx=this.dataobj.getFldIdx(f.field))!=-1){
              if (viewMode=='chart')
                this.GridChart.AddFilter(
                  this.GridChart.MakeFilter(
                    f.field,f.operator,f.expression,this.dataobj.fieldstypearray[fidx],
                    f.fixed,f.userFilter,f.defaultFilter
                  ),f.visible
                );
              else
                this.Grid.AddFilter(this.Grid.MakeFilter(f.field,f.operator,f.expression,this.dataobj.fieldstypearray[fidx],f.fixed,f.userFilter,f.defaultFilter),f.visible);
            }else if(this[f.field] && this[f.field].Value){
              this[f.field].Value(f.expression);
            } else if (f.field.startsWith('w_')) {
              this[f.field]=new this.Var(f.expression);
              this.dataobj.parms+=f.field+",";
              if (viewMode=='chart')
                this.dataobj2.parms+=f.field+",";
            }
          }
        }
        if (viewMode=='chart')
          filter=this.GridChart.CreateFilter(false, true);
        else
          filter=this.Grid.CreateFilter(false, true);
      }else{
        let FiltersArray = [];
        // eslint-disable-next-line no-cond-assign
        for(i=0; f=filters[i++];){
          let n_filter = {};
          FiltersArray.push(n_filter);
          n_filter.field = f.field;
          n_filter.type = f.type;
          n_filter.operator = this.OperatorIndexes.indexOf( f.operator );
          let exp = f.expression;
          let pict;
          if (n_filter.type == 'D') {
            pict = ZtVWeb.defaultDatePict;
            if (typeof exp == 'string') {
              exp = ZtVWeb.valueToStr(ZtVWeb.strToValue(exp, n_filter.type, pict), n_filter.type);
            }
          } else if (n_filter.type == 'T') {
            pict = ZtVWeb.defaultDateTimePict;
            if (typeof exp == 'string') {
              exp = ZtVWeb.valueToStr(ZtVWeb.strToValue(exp, n_filter.type, pict), n_filter.type);
            }
          } else if (n_filter.type == 'N') {
            if (typeof exp != 'string') {
            } else if (isNaN(ZtVWeb.strToValue(exp, n_filter.type, pict))) {
              exp = ZtVWeb.strToValue(exp, 'C', pict);
            } else {
              exp = ZtVWeb.strToValue(exp, n_filter.type, pict);
            }
          } else if (n_filter.type == 'L') {
            if (typeof exp == 'string') {
              exp = ZtVWeb.strToValue(exp, n_filter.type, pict);
            }
          }
          n_filter.expression = exp;
        }
        if ( FiltersArray.length > 0 ) {
          filter=JSON.stringify(FiltersArray);
        }
      }
      this.updateFilterVisibility();
    }else{
      filter='[{"ED" : true }]';
    }
    if(EmptyString(filter)) filter='[{"ED" : false }]';
    //imposta parte fissa della chiave per parent_splinker
    this.SetParentSPLinker_keys(filters);

    //imposta caption ereditata
    if(!EmptyString(this.Caption.Value()))
      this.SetCaption(this.CaptionByFilters(filters));

    //reimposta RS_EOF se cancellato
    if(has_rs_eof){
      evt.RS_EOF=PARENT_RS_EOF;
    }
    if ( typeof (PARENT_SET_ORDERBY) !='undefined') {
      evt.setOrderBy = PARENT_SET_ORDERBY;
    }
    if (has_forceRC){
      this.dataobj.GetForceRecordChanged();
      if (this.dataobj2)
        this.dataobj2.GetForceRecordChanged();
    }

    //esegue la query
    this.dataobj.async=true;
    this.dataobj.querycount=-1;
    if (this.dataobj2){
      this.dataobj2.async=true;
      this.dataobj2.querycount=-1;
    }
    if (first){
      if (!EmptyString(this.FixedFilter.Value()) || !EmptyString(this.FieldFilter.Value())) {
        let jsonFilter = [];
        if (!EmptyString(filter)) {
          jsonFilter = JSON.parse(filter);
        }
        if(!EmptyString(this.FixedFilter.Value())){
          jsonFilter.push({ unsafeExpr : this.FixedFilter.Value()});
        }
        if(!EmptyString(this.FieldFilter.Value())){
          jsonFilter.push({ unsafeExpr : this.FieldFilter.Value()});
        }
        filter = JSON.stringify(jsonFilter);
      }
      this.dataobj.queryfilter=filter;
      if (this.dataobj2) {
        this.dataobj2.queryfilter=filter;
      }
    } else if(EmptyString(filter)){//se ha usato la grid x produrre i filtri li fa applicare dalla grid
      this.Grid.filter_change=true;
      this.Grid.ApplyFilter();
    }else {
      this.dataobj.queryfilter=filter;
      if (viewMode=='chart' && this.dataobj2){
        this.dataobj2.queryfilter=filter;
        this.GridChart.ApplyFilter();
        this.dataobj2.Query();
      } else {
        this.dataobj.Query();
        this.Grid.dispatchEvent('FiltersApplied');
      }
    }
    if (!first){
      if (this.hasZoomtitlesID('updateFilterButton')) {
        this.getZoomtitlesRefsByProperty('updateFilterButton', function(portlet) {
          portlet.updateFilterButton();
        });
      } else {
        var toolbar=this.toolbar;
        if (viewMode=='chart'){
          toolbar=this.toolbar2;
        }
        if (this.Grid.Filters.length > 0) {
        toolbar.UpdateItem('showVdm', {
          image:SPTheme.portalZoomFilterAppliedImage||{fontFamily:'icons8_win10', value: "&#xefaf", size: "20px"}
        });
        } else {
          toolbar.UpdateItem('showVdm', {
            image:SPTheme.portalZoomFilterAppliedImage||{fontFamily:'icons8_win10', value: "&#xee44", size: "20px"}
          });
        }
      }
    }
  }

  this.Grid_FiltersApplied=function(){
    this.$entity$_updateFilters.Emit();
    if (!this._printZoom)
      return;
    if (!this.ConfigGridElements.Value().match(/-p/i) && this.printModeSecurity && this.vzmstructure.Configuration.PrintMode!='None') {
      var pman = this.Grid.getPrintManager(),
      pprint = pman._GetPrintPortlet();
      if (pprint && !pprint._isPrinting)
        pman.Close();
    }
  }

  this.GetFilters=function(){
    var filters=[];
    // eslint-disable-next-line no-cond-assign
    for(var i=0,filter; filter=this.Grid.Filters[i++]; ){
      filters.push(filter);
    }
    return filters;
  }

  this.SetParentSPLinker_keys=function(filters){
    var pkfields=this.PKFields.Value();
    var inherited_pkfields=this.InheritedPKFields.Value();
    var p="", i, f;
    if(!EmptyString(inherited_pkfields)){ //campi del padre passati esplicitamente
      //for(var i=0,fields=inherited_pkfields.split(','),f; f=fields[i++]; p+=f+'='+rs[f]+',');//bug: la riga corrente � vuota
      // eslint-disable-next-line no-cond-assign
      for(i=0; f=filters[i++];){
        if(inherited_pkfields.match(new RegExp("[^,]?"+f.field+"[,$]?"))){
          p+=f.field+'='+f.expression+',';
        }
      }
      p=p.substring(0,p.length-1);
    } else if(this.WaitForFilter.Value() && !EmptyString(pkfields)){ //campi in comune intuiti dal filtro applicato
      // eslint-disable-next-line no-cond-assign
      for(i=0; f=filters[i++];){
        //con la condizione filtra solo nei campi chiave
        if(f.operator=="=" && pkfields.match(new RegExp("[^,]?"+f.field+"[,$]?"))){
          p+=f.field+'='+f.expression+',';
        }
      }
      p=p.substring(0,p.length-1);
    }
    var parametri;
    if (!EmptyString(this.FixedFilterURL.Value())){
      var parFixURL="";
      parametri=this.FixedFilterURL.Value().split('&');
      for(i=0;i<parametri.length;i++){
        if (Left(parametri[i],3)!="m_c")
          parFixURL+=parametri[i]+",";
      }
      p+= parFixURL;
    }

    if (!EmptyString(this.InitEntityFields.Value())){
      parametri=this.InitEntityFields.Value().split(',');
      for(i=0;i<parametri.length;i++){
        p+=parametri[i]+",";
      }
      p=p.substring(0,p.length-1);
    }

    if (this.LayerInterface && !EmptyString(this.LayerInterface.Value())) {
      p+=',m_cLayerInterface=LayerInterface';
    }
    this.parent_splinker.Parameters(p+',m_cDetailBehavior=NewRow'+this.DetailBehavior.Value());
  }

  this.CaptionByFilters=function(filters){
    var cpt=this.Caption.Value();
    if (Empty(cpt)) cpt = this.vzmstructure.Configuration.Caption_trad || this.vzmstructure.Configuration.Caption;
    if(!Empty(cpt) && cpt.match(/%[\w]+%/i)){
      // eslint-disable-next-line no-cond-assign
      for(var i=0,f; f=filters[i++]; cpt=cpt.replace(new RegExp("%"+f.field+"%"), f.expression) );
    }
    return cpt;
  }

  this.crumbObj=function(evt,ignoreFilterMap){
    var res=[],
        p_exp,
        p_op, op_suff='_op', def_op='=',
        p_type, type_suff='_type', def_type='C',
        p_fixed, fixed_suff='_fixed',
        p_queryP, queryP_suff='_queryParm',
        p_visible, visible_suff='_visible',
        p_userFilter, userFilter_suff='_userFilter',
        p_defaultFilter, defaultFilter_suff='_defaultFilter';
    for(var p in evt){
      if (!evt.hasOwnProperty(p)) {
        continue;
      }
      if(evt[p]!=null && IsA(evt[p],'O') && !IsA(evt[p],'D')){
        res=res.concat(this.crumbObj(evt[p],ignoreFilterMap));
        continue;
      }
      if((p.match(op_suff+'$') && RTrim(p,op_suff) in evt) ||
         (p.match(type_suff+'$') && RTrim(p,type_suff) in evt) ||
         (Empty(evt[p]) && (p+op_suff) in evt && !this.Grid.operatorWithoutValue(evt[p+op_suff])) && (p.toLowerCase() in this.dataobj.Fields_map) ||
         (filter_map && !(p in filter_map) && !ignoreFilterMap) ||
         p=="srcPortletId"
        ) continue;
      p_op=EmptyString(evt[p+op_suff]) ? def_op : evt[p+op_suff];//operatore
      p_type=EmptyString(evt[p+type_suff]) ? def_type : evt[p+type_suff];//tipo
      p_fixed=evt[p+fixed_suff]||false;//fisso
      p_queryP=evt[p+queryP_suff]||"";
      p_visible=evt[p+visible_suff]||false;//visibile
      p_userFilter=evt[p+userFilter_suff]||false;//filtro da moschina
      p_defaultFilter=evt[p+defaultFilter_suff]||false;//filtro da moschina
      p_exp=evt[p];
      if(filter_map && !ignoreFilterMap){
        p=filter_map[p];
      }
      res.push(
        {
          field:  p,
          operator: p_op,
          expression: p_exp,
          type: p_type,
          fixed: p_fixed,
          queryparm: p_queryP,
          visible: p_visible,
          userFilter: p_userFilter,
          defaultFilter: p_defaultFilter});
    }
    return res;
  }
  this.SelectQueryName=function(queryName,notRefresh) {
    this.dataobj.ChangeQuery(queryName);
    if (this.dataobj2) {
      this.dataobj2.ChangeQuery(queryName);
    }
    if (!notRefresh) {
      this.refreshQuery();
    }
  }

  if(window.location.href.indexOf("/SPPortalZoomBase_portlet.jsp?")>-1){
    document.body.style.padding=0;
    document.body.style.margin=0;
  }

  //imposta WaitForFilter a true se esite receivername
  this.SetWaitForFilter();

  //imposta la funzione di receive
  this.SetReceivers();

  //crea la mappa di corrispondenza per i campi emitter->receiver
  var filter_map;
  if(!EmptyString(this.FilterOnFields.Value())){
    var s_map=this.FilterOnFields.Value();
    var fields=s_map.split(',');
    if(!EmptyArray(fields))
      filter_map={};
    var f_from,f_to;
    // eslint-disable-next-line no-cond-assign
    for(var i=0,f; f=fields[i++];){
      f=Strtran(f,'&gt;','>');
      f=f.split('->');
      f_from=f[0].split('|');
      f_to=f[1]?Trim(f[1]):Trim(f_from[0]);
      // eslint-disable-next-line no-cond-assign
      for(var k=0,ff; ff=f_from[k++];){
        filter_map[Trim(ff)]=f_to;
        filter_map[Lower(Trim(ff))]=f_to;
      }
    }
  }

  this.addTotalizer=function(){
    if (this.vzmstructure.Configuration.TotalsPosition=='hidden'){
      this.Grid.renderTotals=false;
      if (this.box_tiles)
        this.box_tiles.Hide();
      return;
    }
    var fields="",exps="",groupby="", descr="";
    // eslint-disable-next-line no-cond-assign
    for (var i=0, col; col=this.Grid.Cols[i]; i++){
      if (col.groupby) groupby+=col.field+",";
      else {
        if (col.exp && col.tileVisibility!="hidden" ) {
          exps+=col.exp+",";
          fields+=col.field+",";
          descr+=col.descr+",";
        }
      }
    }
    if(Trim(exps)!="") {
      if (this.vzmstructure.Configuration.TotalsPosition && Right(this.vzmstructure.Configuration.TotalsPosition,4)=='tile') {
        if (this.box_tiles) {
          if (this.totalizer.rowsconsumers.indexOf(this.box_tiles)==-1)
            this.totalizer.addRowConsumer(this.box_tiles);
          this.Grid.renderTotals=false;
          var hGrid=30;
          if (Left(this.vzmstructure.Configuration.TotalsPosition,6)=='bottom') {
            var tileTop=40;
            if(!Empty(this.GridMinHeight.Value())){
              hGrid=parseInt(this.GridMinHeight.Value());
              tileTop=10+parseInt(hGrid);
            }
            this.Grid.setCtrlPos(this.Grid.ctrl,0,10,150,hGrid,'top-left-right',this.width,this.height,false,false);
            // if(!Empty(this.GridMinHeight.Value())){
              // tileTop=10+this.Grid.getTableHeight();
            // }
            this.box_tiles.setCtrlPos(this.box_tiles.ctrl,0,tileTop,150,10,'bottom-left-right',this.width,this.height,false,false);
            this.box_tiles.ctrl.style.top='auto';
          } else { //top
            if(!Empty(this.GridMinHeight.Value())){
              hGrid=parseInt(this.GridMinHeight.Value());
            }
            this.box_tiles.ctrl.style.bottom='';
            this.Grid.setCtrlPos(this.Grid.ctrl,0,20,150,hGrid,'top-left-right',this.width,this.height,false,false);

            this.box_tiles.setCtrlPos(this.box_tiles.ctrl,0,10,150,10,'top-left-right',this.width,this.height,false,false);
            this.box_tiles.ctrl.style.top='';
          }
          this.box_tiles.Show();
        }
      } else{
        this.Grid.renderTotals=true;
        if (this.box_tiles) {
          this.box_tiles.Hide();
          var idx = this.totalizer.rowsconsumers.indexOf(this.box_tiles);
          if (idx>-1) {
            this.totalizer.rowsconsumers.splice(idx,1);
          }
        }
      }
    } else {
      this.Grid.renderTotals=false;
      if (this.box_tiles)
        this.box_tiles.Hide();
    }
    if(CountChar(",",descr)==descr.length) descr=""; //se ci sono solo virgole imposta le descrizioni a "" cos� non si visualizzano i titoli
    this.dataobj.addTotalizer("totalizer",exps.substring(0,exps.length-1),fields.substring(0,fields.length-1),groupby.substring(0,groupby.length-1),descr.substring(0,descr.length-1));
  }


  //////////////////// ZBOVIEWER//ZPDFVIEWER
  this.GetBOName=function(){ //default bo
    return (this.vzmstructure.Configuration.Autozoom?this.vzmstructure.Configuration.Autozoom:this.Autozoom.Value())+(this.vzmstructure.Configuration.EntityOptions?this.vzmstructure.Configuration.EntityOptions:"");
  }

  this.GetBOKeysValues=function(){
    var za = this.PKFields.Value().split(',');
    var ret = '';
    for(var x=0; x<za.length; x++){
      if(this.dataobj){
        ret+=za[x]+"|"+this.dataobj.getStr(this.dataobj.curRec-1, za[x]);
        if(x!=za.length-1)
          ret+=",";
      }
    }
    return ret;
  }

  this.MoveBONext=function(){
    if(this.dataobj){
      this.dataobj.Next();
    }
  }

  this.MoveBOPrevious=function(){
    if(this.dataobj){
      this.dataobj.Prev();
    }
  }

  this.GetBOEof=function(){
    if(this.dataobj)
      return this.dataobj.Eof();
    else
      return true;
  }

  this.GetBOBof=function(){
    if(this.dataobj && this.dataobj.curRec+this.dataobj.nStartRow==1)
      return true;
    else
      return false;
  }

  this.AddRowConsumer=function(ctrl){
    if(this.dataobj)
      this.dataobj.addRowConsumer(ctrl);
  }

  this.RemoveRowConsumer=function(ctrl){
    if(this.dataobj){
      var ind = this.dataobj.rowsconsumers.indexOf(ctrl);
      if(ind>=0) this.dataobj.rowsconsumers.splice(ind, 1);
    }
  }
  ///////////////////////

  if(!EmptyString(this.Table.Value())){
    this.doZoom();
  }
  this.GetColsForVersion=function() {
    var cols = [], col, cl, newcol;
    for (var i=0;i<this.Grid.Cols.length;i++) {
      col = this.Grid.Cols[i];
      newcol = { id : col.id,
                  field : col.field,
                  title: col.title,
                  type : col.type,
                  Layer : []
                }
      for (var j=0;j<col.Layer.length;j++) {
        cl = col.Layer[j];
        newcol.Layer.push({ id : cl.id,
                  field : cl.field,
                  title: cl.title,
                  type : cl.type
                });
      }
      cols.push(newcol);
    }
    return cols;
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
  this.ChangeConfiguration=function(i) {
    this.refresh_menu.CloseMenu();
    this.LinkedConfiguration(this.vzmstructure.Configuration.linkedConfs[i].configname);
  }
  this.SaveFilters=function() {
    if(!this.cfgSaver_loaded){
      var dock = document.createElement('div');
      dock.style.display='none';
      dock.style.position='relative';
      dock.id = cfgSaverId;
      this.Ctrl.appendChild(dock);
      this.cfgSaver_loaded = 200==ZtVWeb.Include("../jsp-system/SPPortalZoomConfigurationBuilder_portlet.jsp", cfgSaverId,true);
    }
    if(!this.cfgSaver){
      // eslint-disable-next-line no-cond-assign
      if(this.cfgSaver=ZtVWeb.getPortletInc(cfgSaverId)){
        this.cfgSaver.setContainer(this,'cfgSaver');
        this.cfgSaver_ctrl=new ZtVWeb.PortletCtrl(this,cfgSaverId,'cfgSaver',null,null,300,0,'top-left-right');
      }
    }
    if (this.cfgSaver) {
      this.cfgSaver.SaveFilters(this);
    } else { //nel 99% dei casi non si e' loggati
      alert(this.Grid.Translations["error_saving_config"]);
      return;
    }
  }

  this.GetVdmUrl=function(){
    var url="../jsp/SPMaskParameters_portlet.jsp?"+(this.splinker.offline?"m_cSPOfflineApp="+SPOfflineLib.getEntryPointName()+"&":"");
    if (!Empty(this.vdmName))
      url+= "ConfigName="+URLenc(this.vdmName)+(this.splinker.offline?"&hideEditToolbar=true":"");
    else {
      if (this.VQRName.Value().indexOf("BO:")==0)
        url+= "hideEditToolbar=true&ConfigObject="+URLenc(JSON.stringify({}))+"&zoomConfigName="+URLenc(this.ConfigName.Value()||'default');
      else {
        url+= "hideEditToolbar=true&QueryName="+URLenc(this.VQRName.Value())+"&zoomConfigName="+URLenc(this.ConfigName.Value()||'default')+(this.splinker.offline?"":"&presetParams="+URLenc(this.presetParams)+"&hideQueryParameters=true"+"&disablePresetParams="+URLenc(this.vzmstructure.Configuration.disablePresetParam));
      }
    }
    url+="&TitleMsg=MSG_SEARCH_FILTERS&offlineMode="+this.splinker.offline+"&zoomMode=true&Table="+URLenc(this.Table.Value())+"&hideAddFilterButton="+(this.vzmstructure.Configuration.filters=='false')+(this.splinker.offline?"#":"&")+"ReceiverName="+URLenc(this.EmitterName.Value())+"&EmitterName="+URLenc(rcvNameGen)+"&"+this.Grid.QueryParmsFunc()+"&SPParentObjId="+URLenc(this.formid);
    return url;
  }
  this.ShowVdmMaskPrint=function(mywindow, iframeref){
    var params="&m_cDecoration=onlytitle";
    mywindow.windowOpenForeground(this.GetVdmUrl()+params, iframeref);
    this.$entity$_GetConfigurationField.Emit();
    this.$entity$_updateFilters.Emit();
  }
  this.ShowVdmMask=function(){
    if (ZtVWeb.IsMobile()){
      this.OpenConfigZoom();
      return;
    }
    else {
      var params="&closeWhenApplyFilter=true";
      var isMobile=ZtVWeb.IsMobile();
      layerOpenForeground(this.GetVdmUrl()+params,"filter","",isMobile?null:(parseInt(this.vzmstructure.Configuration.vdmWidth)||800),isMobile?null:(parseInt(this.vzmstructure.Configuration.vdmHeight)||600),null,1);
      this.$entity$_GetConfigurationField.Emit();
      this.$entity$_updateFilters.Emit();
    }
  }

  this.ApplyAdvancedFilter=function(){
    var i;
    if (!Empty(this.vdmName)){
      var urlParms={},zoomParms={}
      var parms=this.Grid.QueryParmsFunc().split("&"); // parametri passati via url
      for (i=0; i<parms.length;i++){
        var p=parms[i].split('=');
        if (p[0] && p[1])
          urlParms[p[0]]=p[1];
      }
      parms=this.GetFilters();
      for (i=0; i<parms.length;i++){
        zoomParms[Lower(parms[i].field)]=parms[i];
      }
      var fields=JSON.parse(new JSURL("../servlet/SPVDMProxy?action=loadinit&m_cConfigName=" + URLenc(this.vdmName)).Response());
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
            parmsValue[fixedFilterCount][name+'_visible']=zoomParms[lowername].visibile;
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
        parmsValue[fixedFilterCount][name+'_visible']=zoomParms[name].visibile;
        parmsValue[fixedFilterCount][name+'_queryParm']='';
        fixedFilterCount++;
      }
      parmsValue['removeFixed']=true;
      this.SetFilter({row:parmsValue});
    }
    else
      this.dataobj.Query()
  }

  this.OpenConfigZoom=function(){
    var cols=[],c,col,gridcol,i,curRow={};
    this.tmpStructure={};
    for (i=0; i<this.vzmstructure.Cols.length; i++){
      c = this.vzmstructure.Cols[i];
      if (!c.isImage && !ZtVWeb.isExpr(c.field)){
        gridcol=this.Grid.GetColById(c.id);
        this.tmpStructure[c.id]=c;
        if (typeof(c.type)=='undefined') this.Grid.setColType(c);
        col = {
          id:c.id,
          type:c.type,
          field:c.field,
          title:c.title,
          title2:c.title2||c.title,
          hidden:c.hidden,
          inExtGrid:c.inExtGrid,
          Layer : [],
          show_extra_title:c.show_extra_title,
          extracolidx:c.extracolidx,
          orderbystatus:gridcol.orderbystatus,
          orderbyidx:gridcol.orderbyidx
        }
        cols.push(col);
        curRow[c.field]=this.dataobj.getStr(this.dataobj.curRec-1, c.field)
      }
    }
    var filters;
    if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart')))
      filters=this.GridChart.Filters;
    else
      filters=this.Grid.Filters;
    var url='../portalzoom/SPConfigZoom.jsp'+(this.splinker.offline?'#':'?')+'zoomUID='+this.formid+'&zoomName='+URLenc(this.ConfigName.Value()||'default')+
        '&zoomFields='+URLenc(JSON.stringify(cols))+'&filters='+URLenc(JSON.stringify(filters))+
        '&curRow='+URLenc(JSON.stringify(curRow))+
        '&versions='+URLenc(JSON.stringify(this.vzmstructure.Configuration.Versions||[]))+
        '&currentVersion='+URLenc(this.GetCurrentVersion())+
        '&vdmName='+URLenc(this.vdmName);
    layerOpenForeground(url,"orderby","",null,null,null,1);
  }

  this.expandOReduce=function(){
    var wasextended = this.Grid.IsExtended();
    this.Grid.ExpandOReduce();
    var toolbar=this.toolbar;
    if (viewMode=='chart'){
      toolbar=this.toolbar2;
    }
    toolbar.UpdateItem('expandreduce', {
      title: wasextended ? this.Grid.Translations["Expand_grid"] : this.Grid.Translations["Reduce_grid"],
      image:wasextended?(SPTheme.portalZoomExpandImage||{fontFamily:'icons8_win10', value: "&#xee18", size: "20px"}):
            (SPTheme.portalZoomReduceImage||{ fontFamily:'icons8_win10', value: "&#xefd2", size: "20px"})
    });
  }
  this.ExecAction=function(action,evt){
    if (typeof(action)=="string"){
      if (LibJavascript.JSONUtils.IsJsonString(action))
        action=JSON.parse(action);
      else { //presumo di aver passato il nome
        action = this.vzmstructure.Configuration.actions.find(element => element.actionName == action);
      }

    }
    if (Empty(action.confirmMessage_trad) || confirm(action.confirmMessage_trad)){
      action.popup_style=action.popup_style||'by skin';
      if (action.url.indexOf('javascript:')===0)
        action.entityType='function';
      else if (action.entityType=='function')
        action.url='javascript:'+action.url;
      if (this.refresh_menu) this.refresh_menu.CloseMenu();
      var dataobj=this.dataobj;
      if (viewMode=='chart')
        dataobj=this.dataobj2;
      if (action.entityType=='routine' && this.action_splinker){
        this.action_splinker.Servlet(action.url);
        var parameters='', parm='';
        if (CharToBool(action.sendMemCurs)){
          this.mcParam=new this.Var(this.Grid.GetSelectedDataAsTrsString());
          parameters+=(action.memCursParam||'memorycursor')+'=mcParam,'
          parameters+=(action.checkAllParam||'checkAll')+'='+this.Grid.AllChecked()+','
        }
        this.qfParam=new this.Var(dataobj.queryfilter)
        parameters+=(action.queryFilterParam||'queryFilter')+'=qfParam,';
        parm=this.Grid.QueryParmsFunc(',');
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
          this.action_splinker.Action('execute');
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
              dataobj.Query();
            };
          } else {
            this.action_splinker_Response=function(resp){
              var bj=new BatchJavascript();
              bj.GetFromResponse(resp);
              if (bj.errmsg)
                alert(bj.errmsg)
              else {
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
          LibJavascript.IncludeFunction('SPPortalZoom',match[1],false);
        var clickFunc= ZtVWeb.makeStdLink(action.url,dataobj.curRec-1,dataobj,null,this,true);
        clickFunc=Strtran(clickFunc,'javascript:','');
        var actionFunc=new Function('evt', 'eval("{' + Strtran(clickFunc,'"','\\"') + '}");');
        actionFunc(evt);
        if (action.doQryAfterRoutine=='true')
          dataobj.Query();
      }
      else if (action.target=='_self'){
        var a = document.createElement('a');
        document.body.appendChild(a);
        a.href = ZtVWeb.makeStdLink(action.url,dataobj.curRec-1,dataobj,null,this,true);
        a.click();
        document.body.removeChild(a);
      }
      else {
        var links=ZtVWeb.makeStdLink(action.url,dataobj.curRec-1,dataobj,null,this,true);
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
  this.Grid_LayoutChanged=function(){
    var c, l;
    this.tmpStructure={};
    for (var i=0; i<this.vzmstructure.Cols.length; i++){
      c = this.vzmstructure.Cols[i];
      this.tmpStructure[c.id]=c;6
      for (var j=0; j<this.vzmstructure.Cols[i].Layer.length; j++){
        l = this.vzmstructure.Cols[i].Layer[j];
        this.tmpStructure[l.id]=l;
      }
    }
    var rl;
    for (i=0; i<this.vzmstructure.RowLayer.length; i++){
      rl = this.vzmstructure.RowLayer[i];
      this.tmpStructure[rl.id]=rl;
    }
    this.mergeColStruct(this.Grid.Cols)
    this.mergeRowLayerStruct(this.Grid._rowLayer)
  }

  this.convertToZoomFilters = function(linksFilters) { //settare prima di chiamare startZoom
    var ret = [];
    if( linksFilters ) {
      var _filters = null, i, queryparms = null, obj;
      _filters = linksFilters.fixedFilters;
      if (_filters ) {
        for( i=0; i<_filters.length; i++ ) {
            obj={};
            obj[_filters[i].field]=_filters[i].expression;
            obj[_filters[i].field+'_op']=_filters[i].operator;
            obj[_filters[i].field+'_type']=_filters[i].type;
            obj[_filters[i].field+'_fixed']=false;
            obj[_filters[i].field+'_visible']=true;
            obj[_filters[i].field+'_queryParm']='';
            ret.push(obj)
        }
      }
      queryparms = linksFilters.queryparams;
      if( queryparms ) {
        var keys = Object.keys(queryparms);
        var key, v;
        for( i=0; i<keys.length; i++ ) {
          obj={};
          key = keys[i]
          if(key.endsWith("__type")) continue;
          if(queryparms[key+"__type"] == 'DT') {
            v = ZtVWeb.strToValue(queryparms[key], 'T')
            obj[key] = v;
          }
          else {
            obj[key] = queryparms[key];
          }
          obj[key+'_queryParm'] = key;
          ret.push(obj)
        }
      }
    }
    return ret;
  }

  this.startZoom=function() {
    var _filters =null, i, _objFilters = null;
    var linksFilters = this.GetSavedFilters(GetOpener(), this.pParent.Value());
    if( linksFilters ) {
      _filters = linksFilters.fixedFilters;
      var queryparms = linksFilters.queryparams;
      if( queryparms ) {
        var keys = Object.keys(queryparms);
        var key, lp, v;
        if(!Empty(this.dataobj.parms))
          lp = this.dataobj.parms.split(',')
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
        this.dataobj.parms = newp;
        if (this.dataobj2 && ((this.vzmstructure.Configuration.defaultViewMode == 'chart' && (!this.ViewMode || this.ViewMode.Value() != 'grid')) || (this.ViewMode && this.ViewMode.Value() == 'chart')))
        this.dataobj2.parms = newp;
      }
      if( linksFilters.FixedFilter ) this.FixedFilter.Value(linksFilters.FixedFilter)
      if( linksFilters.FieldFilter ) this.FieldFilter.Value(linksFilters.FieldFilter)
    }
    if (_filters ) {
      _objFilters = [];
      for( i=0; i<_filters.length; i++ ) {
          var obj={};
          obj[_filters[i].field]=_filters[i].expression;
          obj[_filters[i].field+'_op']=_filters[i].operator;
          obj[_filters[i].field+'_fixed']=false;
          obj[_filters[i].field+'_visible']=true;
          _objFilters.push(obj)
      }
    }

    if (this.vzmstructure && this.vzmstructure.Fields.length > 0) {
      this.Grid.Ctrl.style.opacity = 0.1;
      this.dataobj.firstQuery('true', '', this.vzmstructure);
      if (this.dataobj2 && ((this.vzmstructure.Configuration.defaultViewMode == 'chart' && (!this.ViewMode || this.ViewMode.Value() != 'grid')) || (this.ViewMode && this.ViewMode.Value() == 'chart')))
        this.dataobj2.firstQuery('true', '', this.vzmstructure);
      this.$entity$_GetConfigurationField.setParms();
      this.$entity$_GetConfigurationField.Emit();
      this.dataobj.nRows = this.GridRows.Value();
      if (this.dataobj2)
        this.dataobj2.nRows = this.GridRows.Value();
      if (this.splinker.offline) {
        this.Grid_Rendered = this.Grid_Rendered_Impl;
      }
      if (this.vzmstructure.ArrayFilters || _objFilters) {
        if(!_objFilters) _objFilters=[];
        if(!this.vzmstructure.ArrayFilters) this.vzmstructure.ArrayFilters=[];
        var newfilters=[];
        newfilters.row={removeFixed:true};
        for (i=0;i<this.vzmstructure.ArrayFilters.length;i++) {
            newfilters.push(this.vzmstructure.ArrayFilters[i]);
        }
        for (i=0;i<_objFilters.length;i++) {
          newfilters.push(_objFilters[i]);
        }
        this.SetFilter(newfilters, true);
      } else {
        this.SetParentSPLinker_keys([]);
      }
      if (!this.WaitForFilter.Value() && !((this.vzmstructure.Configuration.defaultViewMode == 'chart' && (!this.ViewMode || this.ViewMode.Value() != 'grid')) || (this.ViewMode && this.ViewMode.Value() == 'chart'))) {
        this.Grid.dontupdate = false;
        if (this._time)
          alert(new Date().getTime() - this._time);
        if (CharToBool(this.vzmstructure.Configuration.applyAdvancedFilter))
          this.ApplyAdvancedFilter();
        else if (CharToBool(this.vzmstructure.Configuration.openVdmBeforeQuery)) {
          this.$entity$_updateFilters.setParms();
          this.ShowVdmMask();
        } else
          this.dataobj.Query();
      } else if (this.dataobj2 && (!this.WaitForFilter.Value() && (((!this.ViewMode || Empty(this.ViewMode.Value())) && this.vzmstructure.Configuration.defaultViewMode == 'chart') || (this.ViewMode && this.ViewMode.Value() == "chart")))) {
        //this.Chart.dontupdate = false;
        this.Chart.DontUpdate(true);
        this.dataobj2.Query();
      }
    }
  }

  this.printZoomVocal = function (outputFormat) {
    this._printvocal = true;
    this._printformat = outputFormat;
    this.printZoom();
  }

  /***** */
  //MG
  //passaggio tra visualzoom e visualpivot
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

  this.RetrieveFilters = function() {
    this.SetQuery(true);
    this.dataobj.ParseParameters();
    var _filters;
    if (!this.splinker.offline && ((this.vzmstructure.Configuration.defaultViewMode=='chart' && (!this.ViewMode || this.ViewMode.Value()!='grid')) || (this.ViewMode && this.ViewMode.Value()=='chart')))
      _filters=this.GridChart.Filters;
    else
      _filters=this.Grid.Filters;
    var filters=[];
    var i, f;
    for (i=0; i<_filters.length; i++){
        f = JSON.parse(JSON.stringify(_filters[i]));
        if(!CharToBool(f.fixed)+"") f.userFilter = true;
        filters.push(f);
    }
    var sp = this.dataobj.parms.split(','), s, qp={};
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
    o.FixedFilter = this.FixedFilter.Value();
    o.FieldFilter = this.FieldFilter.Value();
    return o;
  }


}
