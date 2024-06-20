<%@page import="java.util.*" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %><%
Sitepainter sp=new Sitepainter(request);
sp.setContentType(response);%>
<%
String ps_skin=sp.getParameter("skinName","");
if(!"".equals(sp.getParameter("skinName",""))){
  sp.setSkin(ps_skin);
}
%>
<%boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");
boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Hashtable empty_group;//gruppo
ArrayList empty_group_list;// lista per ordinamento gruppo
ArrayList empty_group_titles;// titoli per le risorse
ArrayList empty_group_opened;// proprietà opened
if(ht.containsKey("empty_group")){
empty_group=(Hashtable)ht.get("empty_group");
empty_group_list=(ArrayList)ht.get("empty_list");
empty_group_titles=(ArrayList)ht.get("empty_titles");
empty_group_opened=(ArrayList)ht.get("empty_opened");
}else{
empty_group=new Hashtable();
ht.put("empty_group",empty_group);
empty_group_list=new ArrayList();
ht.put("empty_list",empty_group_list);
empty_group_titles=new ArrayList();
ht.put("empty_titles",empty_group_titles);
empty_group_opened=new ArrayList();
ht.put("empty_opened",empty_group_opened);
}
ht.put(" "," ");
empty_group.put(" "," ");
empty_group_list.add(" ");
empty_group_titles.add(" ");
empty_group_opened.add("");
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML>
<HEAD>
<%Library.WriteMetaTags(request,response,out);%>
<style type="text/css">
  body {margin:0px}
</style>
<link rel='shortcut icon' href='../favicon.ico' />
<TITLE><%=sp.translate("..:: WEBANTI :: Software Antiriciclaggio per Intermediari Finanziari :: Ver. 10.31/2012 ::..")%></TITLE>
<%}%>
<!--Plan Editor main -->
<%
Hashtable ht=new Hashtable();
request.setAttribute("content_boxes",ht);
Hashtable empty_group;//gruppo
ArrayList empty_group_list;// lista per ordinamento gruppo
ArrayList empty_group_titles;// titoli per le risorse
ArrayList empty_group_opened;// proprietà opened
if(ht.containsKey("empty_group")){
empty_group=(Hashtable)ht.get("empty_group");
empty_group_list=(ArrayList)ht.get("empty_list");
empty_group_titles=(ArrayList)ht.get("empty_titles");
empty_group_opened=(ArrayList)ht.get("empty_opened");
}else{
empty_group=new Hashtable();
ht.put("empty_group",empty_group);
empty_group_list=new ArrayList();
ht.put("empty_list",empty_group_list);
empty_group_titles=new ArrayList();
ht.put("empty_titles",empty_group_titles);
empty_group_opened=new ArrayList();
ht.put("empty_opened",empty_group_opened);
}
ht.put(" "," ");
empty_group.put(" "," ");
empty_group_list.add(" ");
empty_group_titles.add(" ");
empty_group_opened.add("");
if(!server_side_included && !client_side_included){
%></HEAD>
<BODY >
<%}
String t=request.getParameter("tpl");
if (t==null) t="index_tpl";
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getTheme()+"/"+t+".jsp",true))
  com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/"+t+".jsp"+(queryStringInclude!=null?"?"+queryStringInclude:""),false);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getTheme()+"."+t,null);

%>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
