<%@ page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors"
%><%@ page import="com.zucchetti.SPBridge.*"
%><%@ page import="com.zucchetti.PortalStudio.JSPLib"
%><%@ page import="com.zucchetti.sitepainter.SPPrxycizer"
%><%@ page import="com.zucchetti.sitepainter.Library"
%><%
Sitepainter sp=Sitepainter.getSitepainter(request);
%><!DOCTYPE html>
<html <%if(sp.isOfflineInstallation(request)){%> <%=com.zucchetti.spofflineapp.Library.getManifestAttribute( request )%>="<%=JSPLib.SPWebRootURL(request)%>/spofflineapp/manifests/<%=sp.getParameter("m_cSPOfflineApp",(sp.getGlobal("i_lOfflineApplicationMode" , false ) ?  sp.getGlobal("i_cEntryPoint","") : "spofflineapp" ))%>_app_manifest.jsp"<%}%>>
<head><%
Library.SetMimeType(response,"text/html");
String filters="";
String zoomFields="";
String versions="";
String currentVersion="";
String zoomUID="";
String curRow="";
String vdmName="";
if(!sp.isOfflineInstallation(request)){
  filters=sp.getParameter("filters","");
  zoomFields=sp.getParameter("zoomFields","");
  versions=sp.getParameter("versions","");
  currentVersion=sp.getParameter("currentVersion","");
  zoomUID=sp.getParameter("zoomUID","");
  curRow=sp.getParameter("curRow","");
  vdmName=sp.getParameter("vdmName","");
}
%>
<title>Configuration Zoom</title>
<link type='text/css' rel='STYLESHEET' href='../<%=sp.getSkin()%>/portalstudio.css'>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<script src='../<%=sp.getSkin()%>/styleVariables.js'></script>

<style>
html,body{
height:100% !important;

}

ul{
  list-style-type: none;
  margin:0;
  padding:0;
}

.orderType{
  position: absolute;
  right:0px;
  display: none;
}

.selectedOrder .orderType, .selectedOrder .checkOrder, .fieldList .checkColumn{
  display: inline-block;
}

.selectedOrder .checkOrder, .selectedColumn .checkColumn{
  visibility:visible;
}

.checkOrder, .checkColumn{
  visibility:hidden;
  vertical-align:bottom;
}

.ascending .ascendingOrderActive, .ascending .descendingOrder, .descending .descendingOrderActive, .descending .ascendingOrder{
  display: inline-block;
}

.ascending .ascendingOrder, .ascending .descendingOrderActive, .descending .descendingOrder, .descending .ascendingOrderActive{
  display: none;
}


.char .dateOperator,
.memo .logicOperator, .memo .numericOperator, .memo .dateOperator,
.logic .charOperator, .logic .numericOperator, .logic .emptyOperator, .logic .dateOperator,
.numeric .charOperator, .numeric .dateOperator,
.date .charOperator{
  display: none;
}

.filterValue{
  width:calc(100% - 40px);
}

.deleteImage{
  vertical-align: bottom;
  cursor: pointer;
}

.checkVersion{
  position:absolute;
  right:0;
  display: none;
 }

 .selected .checkVersion{
  display: inline-block;
 }

 #noFilter{
   display: none;
 }

 #vdmFilter{
   padding-left:15px;
 }

 #cinema{
  height: 100%;
  width: 100%;
  position: absolute;
  z-index:100;
 }

 #filter{
   opacity:0.5;
 }

 .redPoint{
   /* display:inline-block; */
   float:right;
   background-color:#e84232;
   margin-top:3px;
   margin-right:3px;
   width:4px;
   height:4px;
   border:none;
   border-radius:2px;
   display:none;
 }

</style>
</head>
<body onLoad='DoLoad()' class='mobile PortalZoomConfigurator'>
<div id='SPConfigZoom'>
  <div class="SPFAB" id='newFilterBtn' onclick='createFilter()'>
    <div style="display: table; height: 40px;" id='newFilterBtnDiv'>
    <!---a class="newFilterBtn"></a-->
  </div></div>
  <div id='toolbar' class='toolbar'>

  </div>

  <div id='container'>
    <div class='tab_container' id='tab_container'>
      <div id='tab_filter' class='tab filterTab' onclick='selectTab(this)'></div>
      <div id='tab_order' class='tab orderTab' onclick='selectTab(this)'></div>
      <div id='tab_version' class='tab versionsTab' onclick='selectTab(this)'></div>
    </div>
    <div id='content'>
      <div id='cinema'></div>
      <div id='filter'>
        <div>
          <ul id='fieldList' class='columnListContainer'>
          </ul>
        </div>
        <div id='appliedFilterTitle' class='appliedFilterTitle'><%=sp.translate("MSG_LIST_FILTERS_VIEWS")%></div>
        <div id='vdmFilter'>
        </div>
        <ul id='listFilter'>
          <li id='noFilter'><span class='filterName'><%=sp.translate("MSG_NO_FILTERS")%></span></li>
        </ul>
        <div id='newFilter' style='display:none;'>
          <div class='newFilterTitle' id='newFilterTitle'><span><%=sp.translate("MSG_NEW_FILTER")%></span></div>
          <!--span><%=sp.translate("MSG_VZM_FIELD")%></span-->
          <div class='filterFieldContainer'>
            <select id='comboField' class='filterField' onchange='selectFieldName(this)'></select>
          </div>
          <!--span><%=sp.translate("MSG_OPERATOR")%></span-->
          <div id='listOperator' class='listOperatorContainer'>
            <div class='listOperator charOperator' onclick='selectElement(this)' id='contains' name='contains'><%=sp.translate("MSG_CONTAINS")%></div>
            <div class='listOperator charOperator' onclick='selectElement(this)' name='like'><%=sp.translate("MSG_STARTS_WITH")%></div>
            <div class='listOperator logicOperator' onclick='selectElement(this)' id='equals' name='='>=</div>
            <div class='listOperator numericOperator' onclick='selectElement(this)' name='<'>&lt;</div>
            <div class='listOperator numericOperator' onclick='selectElement(this)' name='<='>&lt;=</div>
            <div class='listOperator numericOperator' onclick='selectElement(this)' name='>='>&gt;=</div>
            <div class='listOperator numericOperator' onclick='selectElement(this)' name='>'>&gt;</div>
            <div class='listOperator logicOperator' onclick='selectElement(this)' name='<>'>&lt;&gt;</div>
            <div class='listOperator emptyOperator' onclick='selectElement(this)' name='empty'><%=sp.translate("MSG_EMPTY")%></div>
            <div class='listOperator emptyOperator' onclick='selectElement(this)' name='notEmpty'><%=sp.translate("MSG_NOTEMPTY")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='currentmonth'><%=sp.translate("MSG_CURRENTMONTH")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='currentyear'><%=sp.translate("MSG_CURRENTYEAR")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='lastmonth'><%=sp.translate("MSG_LASTMONTH")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='lastyear'><%=sp.translate("MSG_LASTYEAR")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='last30days'><%=sp.translate("MSG_LAST30DAYS")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='last60days'><%=sp.translate("MSG_LAST60DAYS")%></div>
            <div class='listOperator dateOperator' onclick='selectElement(this)' name='last90days'><%=sp.translate("MSG_LAST90DAYS")%></div>
          </div>
          <!--span><%=sp.translate("MSG_VALUE")%></span-->
          <input id='filterValue' class='filterValue' placeholder='value'/>
        </div>
      </div>
      <div id='order' style='display:none'>
        <ul id='orderByList' class='orderByContainer'>
        </ul>
      </div>
      <div id='versions'  style='display:none'>
        <ul id='versionContainer' class='versionContainer'></ul>
      </div>
    </div>
  </div>
</div>
<script>
  var fieldObj={};
  var listOperator={
    contains:'<%=sp.translate("MSG_CONTAINS")%>',
    like:'<%=sp.translate("MSG_STARTS_WITH")%>',
    empty:'<%=sp.translate("MSG_EMPTY")%>',
    notEmpty:'<%=sp.translate("MSG_NOTEMPTY")%>',
    currentmonth:'<%=sp.translate("MSG_CURRENTMONTH")%>',
    currentyear:'<%=sp.translate("MSG_CURRENTYEAR")%>',
    lastmonth:'<%=sp.translate("MSG_LASTMONTH")%>',
    lastyear:'<%=sp.translate("MSG_LASTYEAR")%>',
    last30days:'<%=sp.translate("MSG_LAST30DAYS")%>',
    last60days:'<%=sp.translate("MSG_LAST60DAYS")%>',
    last90days:'<%=sp.translate("MSG_LAST90DAYS")%>'
  }
  var zoomFields,zoomUID,versions,curRow,currentVersion,deleteImage,vdmName,offline=false;
  function DoLoad(){
    var filters;
    <%if(sp.isOfflineInstallation(request)){%>
      var m_oSPParameterSource = new ZtVWeb.SPParameterSource();
      filters=JSON.parse(m_oSPParameterSource.GetInclusionParameter('filters',''));
      zoomFields=JSON.parse(m_oSPParameterSource.GetInclusionParameter('zoomFields',''));
      curRow=JSON.parse(m_oSPParameterSource.GetInclusionParameter('curRow',''));
      versions=JSON.parse(m_oSPParameterSource.GetInclusionParameter('versions',''));
      currentVersion=m_oSPParameterSource.GetInclusionParameter('currentVersion','');
      zoomUID=m_oSPParameterSource.GetInclusionParameter('zoomUID','');
      vdmName=m_oSPParameterSource.GetInclusionParameter('vdmName','');
      offline=true;
    <%}else{%>
      filters=JSON.parse('<%=JSPLib.ToJSValue(filters)%>');
      zoomFields=JSON.parse('<%=JSPLib.ToJSValue(zoomFields)%>');
      curRow=JSON.parse('<%=JSPLib.ToJSValue(curRow)%>');
      versions=JSON.parse('<%=JSPLib.ToJSValue(versions)%>');
      currentVersion='<%=JSPLib.ToJSValue(currentVersion)%>';
      zoomUID='<%=JSPLib.ToJSValue(zoomUID)%>';
      vdmName='<%=JSPLib.ToJSValue(vdmName)%>';
    <%}%>

    deleteImage=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigDeleteFilter,'','',"onclick='deleteFilter(this)'",'','deleteImage')

    //toolbar
    var apply=Empty(SPTheme.portalZoomConfigurator_toolbar_acceptImage)?'<span onclick="apply()"><%=sp.translate("RPT_APPLY")%></span>':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigurator_toolbar_acceptImage,'','',"onclick='apply()'",'','');
    document.getElementById('toolbar').innerHTML=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigurator_toolbar_backImage,'','',"onclick='closeModalLayer()'",'','')+
    "<div class='searchDiv'><input id='search' class='searchBox'/></div>"+apply;

    //tab
    var image=Empty(SPTheme.portalZoomConfigurator_order_tab_image)?'':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigurator_order_tab_image,'','','','','');
    document.getElementById('tab_order').innerHTML=image+'<span><%=sp.translate("MSG_ORDER")%></span><div class="redPoint" id="redPoint_order"></div>';
    image=Empty(SPTheme.portalZoomConfigurator_versions_tab_image)?'':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigurator_versions_tab_image,'','','','','');
    document.getElementById('tab_version').innerHTML=image+'<span><%=sp.translate("MSG_ZOOMVIEWS")%></span>';
    image=Empty(SPTheme.portalZoomConfigurator_filter_tab_image)?'':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigurator_filter_tab_image,'','','','','');
    document.getElementById('tab_filter').innerHTML=image+'<span><%=sp.translate("MSG_FILTERS")%></span><div class="redPoint" id="redPoint_filter"></div>';

    document.getElementById('newFilterBtnDiv').innerHTML=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigAddFilter,'','',"",'','newFilterBtn')

    //campi filtro + campi ordinamento
    var orderByList='', listVersions='',comboField='', fieldList='',
      ascendingImage=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigAscendingOrder,'','',"onclick='selectOrderType(event,this)'",'','ascendingOrder'),
      ascendingActiveImage=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigAscendingOrderActive,'','','','','ascendingOrderActive'),
      descendingImage=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigDescendingOrder,'','',"onclick='selectOrderType(event,this)'",'','descendingOrder'),
      descendingActiveImage=LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigDescendingOrderActive,'','','','','descendingOrderActive'),
      selectedImage=Empty(SPTheme.portalZoomConfigSelectedOrder)?'':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigSelectedOrder,'','','','','checkOrder');
      selectedColImage=Empty(SPTheme.portalZoomConfigSelectedColumn)?'':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigSelectedColumn,'','','','','checkColumn');
    for (var i=0; i<zoomFields.length;i++){
      fieldObj[Lower(zoomFields[i].field)]=zoomFields[i];
      if (zoomFields[i].field.indexOf('html:')!=0){
        comboField+="<option value='"+zoomFields[i].field+"'>"+zoomFields[i].title+"</option>";
        fieldList+="<li onclick='selectField(this)' class='columnList' name='"+zoomFields[i].field+"' id='fieldList_"+zoomFields[i].field+"'>"+selectedColImage+'<span>'+zoomFields[i].title+"</span></li>";
        orderByList+="<li onclick='selectOrderBy(this)' class='orderBy "+(zoomFields[i].orderbystatus=='asc'?"selectedOrder ascending":zoomFields[i].orderbystatus=='desc'?"selectedOrder descending":"ascending")+"' name='"+zoomFields[i].field+"' id='order_"+zoomFields[i].field+"'>"+selectedImage+"<span>"+zoomFields[i].title+"</span><div class='orderType'>"+ascendingImage+ascendingActiveImage+descendingImage+descendingActiveImage+"</div></li>";
      }
    }
    // document.getElementById('comboField').innerHTML=comboField;
    document.getElementById('comboField').innerHTML=comboField;
    document.getElementById('orderByList').innerHTML=orderByList;
    document.getElementById('fieldList').innerHTML=fieldList;
    LibJavascript.CssClassNameUtils.addClass(document.getElementById('fieldList').firstChild,'selectedColumn');
    // filtri preimpostati da moschina
    for (var i=0; i<filters.length; i++){
      addFilter(filters[i]);
    }

    if (!Empty(vdmName)){
      var url="../jsp/SPMaskParameters_portlet.jsp?"+(offline?"m_cSPOfflineApp="+SPOfflineLib.getEntryPointName()+"&":"")+"ConfigName="+URLenc(vdmName)+"&hideEditToolbar=true&m_cDecoration=none&zoomMode=true&hideAddFilterButton=true";
      ZtVWeb.Include(url,"vdmFilter",true);
    }

    selectedImage=Empty(SPTheme.portalZoomConfigSelectedVersion)?'':LibJavascript.DOM.GenerateIcon(SPTheme.portalZoomConfigSelectedVersion,'','','','','checkVersion');
    listVersions+="<li class='versions "+(currentVersion=='default'?'selected':'')+"' onclick='selectElement(this)' name='default'><span>default</span>"+selectedImage+"</li>";
    for (var i=0; i<versions.length;i++){
      listVersions+="<li class='versions "+(currentVersion==versions[i]?'selected':'')+"'  onclick='selectElement(this)'  name='"+versions[i]+"'><span>"+versions[i]+"</span>"+selectedImage+"</li>";
    }
    if (versions.length==0)
      document.getElementById('tab_container').removeChild(document.getElementById('tab_version'));
    document.getElementById('versionContainer').innerHTML=listVersions;

    selectTab(document.getElementById('tab_filter'));
    selectFieldName(document.getElementById('comboField'));
    if (document.getElementById("listFilter").getElementsByTagName("li").length==1 && Empty(vdmName)){
      // document.getElementById('noFilter').style.display='inline-block';
      document.getElementById('listFilter').style.display='none';
      document.getElementById('appliedFilterTitle').style.display='none';
    }
    else {
      document.getElementById('listFilter').style.display='inline-block';
      document.getElementById('appliedFilterTitle').style.display='inline-block';
      document.getElementById('noFilter').style.display='none';
    }
  }
  function selectElement(el){
    LibJavascript.CssClassNameUtils.removeClass(el.parentNode.getElementsByClassName('selected')[0], 'selected');
    LibJavascript.CssClassNameUtils.addClass(el, 'selected');
  }
  function selectTab(el){
    selectElement(el);
    var tab=el.id;
    var filterDiv=document.getElementById('filter');
    document.getElementById('cinema').style.display='none';
    filterDiv.style.display=tab=='tab_filter'?'block':'none';
    filterDiv.style.opacity=1;
    document.getElementById('order').style.display=tab=='tab_order'?'block':'none';
    document.getElementById('versions').style.display=tab=='tab_version'?'block':'none';
    document.getElementById('newFilterBtn').style.display=tab=='tab_filter'?'block':'none';
    document.getElementById('redPoint_order').style.display=(tab=='tab_order' || document.getElementById('orderByList').getElementsByClassName('selectedOrder').length==0) ?'none':'inline-block';
    document.getElementById('redPoint_filter').style.display=(tab=='tab_filter' || (document.getElementById("listFilter").getElementsByTagName("li").length==1 && Empty(vdmName)))?'none':'inline-block';
  }

  // function changeComboField(el){
  //   document.getElementById('listField').value=el.value;
  // }

  function selectFieldName(el){
    var fld=el.value;
    // if (Empty(document.getElementById('search').value))
    //   document.getElementById('comboField').value=fld;
    switch(fieldObj[Lower(fld)].type){
      case 'C':
        document.getElementById('listOperator').classList='listOperatorContainer char';
        selectElement(document.getElementById('contains'));
        break;
      case 'M':
        document.getElementById('listOperator').classList='listOperatorContainer memo';
        selectElement(document.getElementById('contains'));
        break;
      case 'D':
      case 'T':
        document.getElementById('listOperator').classList='listOperatorContainer date';
        selectElement(document.getElementById('equals'));
        break;
      case 'N':
        document.getElementById('listOperator').classList='listOperatorContainer numeric';
        selectElement(document.getElementById('equals'));
        break;
      case 'L':
        document.getElementById('listOperator').classList='listOperatorContainer logic';
        selectElement(document.getElementById('equals'));
        break;
    }
    document.getElementById('filterValue').value=curRow[fld]
  }

  function operatorWithoutValue (op) {
      return ['empty', 'notempty', 'currentyear', 'lastyear', 'currentmonth', 'lastmonth',
        'last30days', 'last60days', 'last90days'].indexOf(op.toLowerCase()) >= 0;
  };

  function createFilter(){
    document.getElementById('newFilter').style.display='block';
    document.getElementById('listFilter').style.display='block';
    document.getElementById('appliedFilterTitle').style.display='block';
    document.getElementById('fieldList').style.display='none';
    document.getElementById('search').disabled=true;
    document.getElementById('search').value='';
    document.getElementById('newFilterBtn').onclick=addFilter
  }

  function addFilter(filter){
    var li=document.createElement('li'),filterHtml;
    if (!filter || !filter.field){
      filter={
        field:document.getElementById('comboField').value,
        operator:document.getElementById('listOperator').getElementsByClassName('selected')[0].getAttribute('name'),
        expression:document.getElementById('filterValue').value
      }
    }
    filter.expression=operatorWithoutValue(filter.operator)?'':filter.expression;
    filterHtml="<div><span class='filterName' name='"+filter.field+"'>"+(fieldObj[Lower(filter.field)].title||filter.field)+"</span>"+
        "<span class='filterOperator' name='"+filter.operator+"'>"+(listOperator[filter.operator]||filter.operator)+"</span>"+
        "<span class='value'  name='"+filter.expression+"'>"+filter.expression+"</span></div>"+deleteImage;
    li.innerHTML=filterHtml;
    document.getElementById("listFilter").appendChild(li);
    document.getElementById('noFilter').style.display='none';
    document.getElementById('listFilter').style.display='inline-block';
    document.getElementById('appliedFilterTitle').style.display='inline-block';
  }
  function deleteFilter(el){
    el.parentNode.parentNode.removeChild(el.parentNode);
    if (document.getElementById("listFilter").getElementsByTagName("li").length==1 && Empty(vdmName)){
      document.getElementById('listFilter').style.display='none';
      document.getElementById('appliedFilterTitle').style.display='none';
    }
  }
  function selectField(el){
    LibJavascript.CssClassNameUtils.removeClass(document.getElementById('fieldList').getElementsByClassName('selectedColumn')[0],'selectedColumn');
    LibJavascript.CssClassNameUtils.addClass(el,'selectedColumn');
  }
  function selectOrderBy(el){
    if (LibJavascript.CssClassNameUtils.hasClass(el,'selectedOrder')){
      LibJavascript.CssClassNameUtils.removeClass(el,'selectedOrder');
    }
    else {
      LibJavascript.CssClassNameUtils.addClass(el,'selectedOrder');
    }
  }
  function selectOrderType(evt,el){
    if (evt){
      evt.preventDefault();
      evt.stopPropagation();
    }
    var li=el.parentNode.parentNode;
    if (LibJavascript.CssClassNameUtils.hasClass(el,'ascendingOrder')){
      LibJavascript.CssClassNameUtils.addClass(li,'ascending');
      LibJavascript.CssClassNameUtils.removeClass(li,'descending');
    }
    else if (LibJavascript.CssClassNameUtils.hasClass(el,'descendingOrder')){
      LibJavascript.CssClassNameUtils.addClass(li,'descending');
      LibJavascript.CssClassNameUtils.removeClass(li,'ascending');
    }
  }

  function getZoomFields(){
    var nOrderBy=1;
    for (var i=0; i<zoomFields.length; i++){
      var li=document.getElementById('order_'+zoomFields[i].field)
      if (li && LibJavascript.CssClassNameUtils.hasClass(li,'selectedOrder')){
        zoomFields[i].orderbyidx=nOrderBy;
        zoomFields[i].orderbystatus=LibJavascript.CssClassNameUtils.hasClass(li,'ascending')?'asc':'desc';
        nOrderBy++;
      }
      else {
        zoomFields[i].orderbyidx=0;
        zoomFields[i].orderbystatus='';
      }
    }
    return zoomFields;
  }

  function getFilters(){
    var _filters=[],filter,elements,fld,type;
    var listFilters=document.getElementById("listFilter").getElementsByTagName("li");
    for (var i=1; i<listFilters.length; i++){ // il primo li � per la label filtro vuoto
      elements=listFilters[i].getElementsByTagName('span');
      fld=elements[0].getAttribute('name');
      type=fieldObj[Lower(fld)].type;
        filter={
          field:fld,
          operator:elements[1].getAttribute('name'),
          expression:elements[2].getAttribute('name'),
          type:type,
          userFilter:true
        }
        _filters.push(filter);
    }
    var searchValue=document.getElementById('search').value;
    fld=document.getElementById('fieldList').getElementsByClassName('selectedColumn')[0].getAttribute('name');
    if (!Empty(searchValue) && fld){
      type=fieldObj[Lower(fld)].type;
      _filters.push({
          field:fld,
          operator:(type=='C'||type=='M')?'contains':'=',
          expression:searchValue,
          type:type
      });
    }
    if (!Empty(vdmName))
      _filters=_filters.concat(ZtVWeb.getPortletWindow('SPMaskParameters').getZoomParametersValue());
    return _filters;
  }

  function getVersion(){
    var curVersion=document.getElementById('versionContainer').getElementsByClassName('selected')[0].getAttribute('name');
    if (curVersion=='default')
      return -1;
    else
      return versions.indexOf(curVersion);
  }

  function closeModalLayer(){
    ZtVWeb.topWindow.spModalLayer.getInstace(frameElement.id).confirmClose();
  }

  function apply(){
    GetOpener()[zoomUID].applyZoom(getZoomFields(),null,getFilters());
    GetOpener()[zoomUID].ChangeVersion(getVersion());
    close();
  }
</script>
</body>
  </html>
