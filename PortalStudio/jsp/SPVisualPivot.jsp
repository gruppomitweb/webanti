<%@page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.Library" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%!
void fillHt(HttpServletRequest request,PageContext pageContext, Sitepainter sp, Hashtable ht){
  request.setAttribute("content_boxes",ht);
  Map ZoomGrid=new HashMap();
  Map ZoomParameters=new HashMap();
  ZoomGrid.put("name","ZoomGrid");
  ZoomGrid.put("title","ZoomGrid");
  ZoomGrid.put("url","SPVisualPivot_portlet.jsp");
  ZoomGrid.put("opened","");
  ZoomParameters.put("name","ZoomParameters");
  ZoomParameters.put("title","ZoomParameters");
  ZoomParameters.put("url","SPPortalZoomParameters_portlet.jsp");
  ZoomParameters.put("opened","");
  ht.put("ZoomGrid",ZoomGrid);
  ht.put("ZoomParameters",ZoomParameters);
  
  Map ZoomChildren_group=new LinkedHashMap();
  // ArrayList ZoomChildren_group_list=new ArrayList();// lista per ordinamento gruppo
  // ArrayList ZoomChildren_group_titles=new ArrayList();
  // ArrayList ZoomChildren_group_opened=new ArrayList();

  String table=sp.getParameter("Table",""),
         urlparms,child,filteronfields,comment;

  /*
    Algortmo per coordinare emitter_padre con recaiver_figli

      ------- ALGORITMO JS ---------

      //imposta l'emitter $entity$_zoomSelectedRow
      var emtSuffix='';
      var emtName=this.EmitterName.Value();
      if(EmptyString(emtName)){
        emtName=this.EventName.Value();
        emtSuffix='_zoomSelectedRow';
      }
      if(EmptyString(emtName)) emtName=this.Autozoom.Value();
      if(EmptyString(emtName)) emtName=this.Table.Value();
      emtName+=emtSuffix;
      this.$entity$_zoomSelectedRow.name=this.$entity$_zoomSelectedRow.name.replace('$entity$_zoomSelectedRow',emtName);

  */
  String emtSuffix="";
  String emtName = sp.getParameter("EmitterName","");
  if("".equals(emtName)) {
    emtName = sp.getParameter("EventName","");
    emtSuffix = "_zoomSelectedRow";
  }
  if("".equals(emtName)){
		emtName = sp.getParameter("Autozoom",table);
  }
	emtName+=emtSuffix;

  Hashtable childHt,filteronfieldsHt;
  String k, detailbehaviour;
  for(java.util.Iterator children=sp.GetTableChildren(table); children.hasNext();){
    filteronfields="";
    childHt = (Hashtable)children.next();
    if (!sp.CanAccess((String)childHt.get("EntityName"))) continue;
    child = (String)childHt.get("Name");
    comment = (String)childHt.get("Comment");
    filteronfieldsHt =  (Hashtable)childHt.get("KeysMap");
    for (Enumeration ks = filteronfieldsHt.keys(); ks.hasMoreElements() ;) {
      k = (String)ks.nextElement();
      filteronfields += k + "->" + filteronfieldsHt.get(k) + (ks.hasMoreElements() ? "," : "");
    }

    String entityType=(String)childHt.get("EntityType");
    if (entityType.equals("detail") || entityType.equals("master/detail[1]")) detailbehaviour="select";
    else detailbehaviour="";

    if ("[0]".equals(JSPLib.Right(entityType,3))) entityType=JSPLib.Left(entityType,entityType.length()-3);
    else if("[1]".equals(JSPLib.Right(entityType,3))) entityType="detail";

    urlparms= "WaitForFilter=true" +
              "&Table=" + child +
              "&Autozoom=" +
              "&PKFields=" +
              "&ReceiverName=" + emtName +
              "&FilterOnFields=" + filteronfields +
              "&Popup=true"+
              "&DetailBehavior="+detailbehaviour+
              "&EntityType="+entityType+
              "&ConfigGridElements=-n"+
              "&Caption=" + (comment!=""?comment:child)+
              "&SPZTL=" +JSPLib.cmdHash("link,"+child+",default",request.getSession())+
              "&FixedFilter="+
              "&FieldFilter="+
              "&EmitterName=" + child;
    Map resource_child=new HashMap();
    resource_child.put("name",child);
    resource_child.put("url","../jsp/SPVisualPivot.jsp?" + urlparms);
    resource_child.put("title",comment!=""?comment:child);
    resource_child.put("opened","");
    
    ZoomChildren_group.put(child, resource_child);
    // ZoomChildren_group_list.add(child);
    // ZoomChildren_group_titles.add(comment!=""?comment:child);
    // ZoomChildren_group_opened.add("");
    ht.put(child, resource_child);
  }

  ht.put("ZoomChildren_group",ZoomChildren_group);
  // ht.put("ZoomChildren_list",ZoomChildren_group_list);
  // ht.put("ZoomChildren_titles",ZoomChildren_group_titles);
  // ht.put("ZoomChildren_opened",ZoomChildren_group_opened);
}
%><%
Sitepainter sp=new Sitepainter(request);
sp.setContentType(response);
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");
boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
fillHt(request,pageContext,sp,ht);
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPVisualPivot.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<style type="text/css">
  body {margin:0px}
</style>
<% sp.WritePortalStudioCSS(request, out); %>
<link rel='shortcut icon' href='../favicon.ico' />
<%}%>
<!--Generated by Plan Editor -->
<%
ArrayList menu_items=new java.util.ArrayList();
Hashtable ht=new Hashtable();
fillHt(request,pageContext,sp,ht);

request.setAttribute("menu_items",menu_items);
%>
<%if(!server_side_included && !client_side_included){
%></HEAD>
<BODY <%= sp.GetBodyClassAttribute("") %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}
String includerPageletId= (request.getAttribute("PageletId")!= null ? (String)request.getAttribute("PageletId"):sp.getParameter("PageletId",""));
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
String PageId = JSPLib.NewCPCCCHK();
%>
<script>
/*JS_MARKER_START*/
ZtVWeb.POM.addObj('<%=PageId%>','SPVisualPivot','planObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%
request.setAttribute("SPParentObjId",PageId);
request.setAttribute("planName","SPVisualPivot");
String forcePageletId = JSPLib.NewCPCCCHK();
request.setAttribute("forcePageletId",forcePageletId);
String t=sp.getParameter("tpl","");
if ("".equals(t)){
  t="SPVisualPivot_tpl";
}
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/"+t+".jsp",true))
  com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/"+t+".jsp"+(queryStringInclude!=null?"?"+queryStringInclude:""),false);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+"."+t,null);

%>
<script>
/*JS_MARKER_START*/
window.SPVisualPivot=new function(){
ZtVWeb.PageCtrl(this,'SPVisualPivot', '<%=forcePageletId%>', 'SPVisualPivot');
this.Calc=function(pagelet){
  <%if (((Map)ht.get("ZoomChildren_group")).size()>0){%>
    this.pagelet.EnablePageCall('ZoomChildren_group');
  <%}%>
}
this.ZoomGrid=this.pagelet.ZoomGrid;
this.ZoomParameters=this.pagelet.ZoomParameters;
<%if (((Map)ht.get("ZoomChildren_group")).size()>0){%>
  this.ZoomChildren_group=this.pagelet.ZoomChildren_group;
<%}%>
}
<%if (((Map)ht.get("ZoomChildren_group")).size()>0){%>
  window['<%=forcePageletId%>'].EnablePageCall('ZoomChildren_group');
<%}%>
ZtVWeb.addPage('SPVisualPivot', SPVisualPivot, 'SPVisualPivot','<%=includerPageletId%>' );
<%if(!server_side_included){%>
window.SPVisualPivot.Loaded();
<%}%>
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
