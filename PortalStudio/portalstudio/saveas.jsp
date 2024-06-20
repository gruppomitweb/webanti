<%@ page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="java.util.*" %><%@ page import="org.json.JSONObject" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  SPJSPBridge.CPResultSet rs;
  String tool=sp.getParameter("tool","portlet");
  String planmode=sp.getParameter("mode","false");
  String tablename=sp.getParameter("tablename","");
  String filter=sp.getParameter("filter","");
  boolean custom=sp.getParameter("custom",false);
%>
<!DOCTYPE html>
<html>
<head>
<title>Save as</title>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <link rel="stylesheet" href="../filewindow.css" type="text/css">
  <style>
    body, html{
      height:100%;
      margin:0;
      padding:0;
      overflow-x:hidden;
      overflow-y:auto;
    }
    body{
      background-color:#FFFFFF;
      font-family: "Open Sans";
    }

    #tools{
        padding:5px;
        text-align:center;
        background:#E8E8E8;
        overflow:hidden;
        height:20px;
        line-height:20px;
        border-bottom: 1px solid #C3C3C3;
        background: #D2D2D2;
    }
    #saveasname {
      border: 0;
      border-bottom: 1px solid #d5d5d5;
      grid-column: 2 / 3;
    }
    body.row2 #saveasname {
      grid-column: 2 / 5;
    }
    #buttons{
      margin-left:15px;
        color:#676767;
    }
    #footer{
        padding:5px;
        overflow:hidden;
        bottom:0;
        position:absolute;
        width:100%;
        border-top: 1px solid #C3C3C3;
        background: #D2D2D2;
      display: grid;
      column-gap: 2px;
      box-sizing: border-box;
    }
    #footer {
      grid-template-columns: [label] 100px [input] 1fr [btns] auto;
      grid-template-rows: auto;
    }
    body.row2 #footer {
      grid-template-columns: [label] auto [comb1] 1fr [comb2] 1fr [btns] auto;
      grid-template-rows: auto auto;
    }
    #footer select,
    #footer input {
      border: 0;
      border-bottom: 1px solid #d5d5d5;
      outline: none;
    }
    span{
      padding: 5px;
      font-size: 12px;
      color: #000;
    }
    #themes{
      grid-column: 1 / 4;
    }
    .active{
        color: #FFFFFF;
        background-position:0px -96px;
        border: 1px solid #028433;
        cursor:default;
    }
    .selected-file{
        border: 2px solid #EAC57E !important;
        background: #F0F4FE !important;
    }

    #list{
        border-top: 0;
        top:31px;
        bottom:0;
        width:100%;
        overflow-x:hidden;
        overflow-y:auto;
        z-index:1;
        bottom:0;
        position:absolute;
        background:#FFFFFF;
      margin-bottom: 39px;
    }
    body.row2 #list {
      margin-bottom: 65px;
    }

    #list .file-item{
        margin:0;
        padding:0;
        padding:3px 5px;
        cursor:default;
        border-bottom:1px dotted #DEDEDE;
        background:#FFFFFF;
    }
    #list .file-item p{
        padding:0;
        margin:0;
    }
    #list .file-item .name{
        font-size:11px;
        font-weight:bold;
        color:#898989;
    }
    #list .file-item .description{
        font-size:9px;
        color:#BCBCBC;
        font-style:italic;
        padding:2px 0px 0px 5px;
    }
  }
  </style>
<script>
window.addEvent('domready',function(){
  var planmode='<%=JSPLib.ToJSValue(planmode)%>';
  Ctrl("saveasname").focus();
<%if(tool.equals("pagelet") || tool.equals("pageleteditor") || tool.equals("css") || tool.equals("classeditor") || tool.equals("decorators")){%>
  Themes_List('<%=JSPLib.ToJSValue(tool)%>');
<%}%>
  if(planmode=='asModel') document.title='Save as Model';
  makeUpList()
});

function closeWindow(){
  var SPModalLayerId='<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
  if(!Empty(SPModalLayerId))
    getOpener().closeSPModalLayer();
  else
    window.close();
  if(getOpener().parent)getOpener().parent.is_Saving=false;
}

function getOpener() {
  return (window.opener?window.opener:(window.caller?window.caller:window.parent));
}

function makeUpList(){
/*aggiunta degli effetti alla lista*/
$$('.file-item').each(function(el){
  el.addEvents({
    'mouseenter':function(){
      this.setStyle('background','#F0F4FE');
    },
    'mouseleave':function(){
      this.setStyle('background','#FFFFFF');
    },
    'dblclick' :function(){
      var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
      if (this.getElement('p') != undefined) {
        var text_path= this.getElement('p').innerHTML;
        if(text_path.indexOf("...]")>-1 && text_path.indexOf("[")>-1 && text_path.length>5){
          text_path=Trim(Strtran(text_path,"[",""));
          folder_path+=Trim(Strtran("/"+text_path,"...]",""));
          window.location.href='saveas.jsp?tool=<%=JSPLib.ToJSValue(tool)%>&folder_path='+URLenc(folder_path)<%
          if ("portalzoom".equals(tool))
            out.print("+'&filter="+ filter +"'");
          %>;
        }else if(text_path.indexOf("[...]")>-1){
          folder_path=folder_path.substring(0,folder_path.lastIndexOf("/"));
          window.location.href='saveas.jsp?tool=<%=JSPLib.ToJSValue(tool)%>&folder_path='+URLenc(folder_path)<%
          if ("portalzoom".equals(tool))
            out.print("+'&filter="+ filter +"'");
          %>;
        }
      }
    },
    'click':function(){
      var name=this.getElement('p');
      if(name != undefined && name.innerHTML.indexOf("..]")==-1)
        Ctrl("saveasname").value=name.innerHTML;
      else
        Ctrl("saveasname").value='';
    },
    'keydown':function(e){
      e = e ? e : window.event;
      var keyCode = GetKeyCode(e);
      if(keyCode==13)
        setSave();
      else if(keyCode==27)
        closeWindow();
    }
  });
});
}

function setSave(){
  if (Ctrl("saveasname").value!=""){
    var windowOpener = getOpener();
    var save_value=Ctrl("saveasname").value;

    save_value=Strtran(save_value,"../","");
    var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
    var custom=<%=custom%>;
    //if (folder_path!='')folderpath+='/'
    let x = "<%=tool%>";
  <%if(tool.equals("portlet")){%>
    var url = new JSURL("../servlet/JSPReader?type=portlet&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=(!Empty(folder_path)?folder_path+'/':'')+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
      }
    }else{
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=(!Empty(folder_path)?folder_path+'/':'')+save_value;
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
    }
    windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:folder_path});
  <%} else if(tool.equals("variant")){%>
    let variant_folder_path = "";
    if(Ctrl("select_1") && Ctrl("select_1").value!="-"){
      variant_folder_path=Ctrl("select_1").value + "/" + Ctrl("select_2").value;
    }
    var url = new JSURL("../servlet/JSPReader?type=variant&name="+save_value+"&folder_path="+variant_folder_path+"/jsp-variants/&check=true",true);
    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=(!Empty(folder_path)?folder_path+'/':'')+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
      }
    }else{
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(null,{"name": save_value, "folder_path": variant_folder_path});
    }
    // windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue("portlet")%>',save_value,{folder_path:folder_path});
  <%} else if(tool.equals("report")){%>
    var url = new JSURL("../servlet/JSPReader?type=webreport&name="+save_value+"&folder_path="+folder_path+"&check=true&custom="+custom,true);
    var conf = true;
    output = url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){}
      else
        conf = false;
    }
    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        windowOpener.AddRecentOpen('<%=tool%>',save_value,{custom:custom});
      }
      else{
        windowOpener.currentname=save_value;
        windowOpener.save();
      }
      windowOpener.forcePreviewReload=true;
    }
  <%} else if(tool.equals("scandoc")){%>
    var url = new JSURL("../servlet/JSPReader?type=scandoc&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
    var conf = true;
    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){}
      else
        conf = false;
    }

    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:folder_path});
      }
      else{
        windowOpener.currentname=save_value;
        windowOpener.save();
      }
    }

  // MENUEDITOR
  <%} else if(tool.equals("menu")){%>
    var parameters= "&offlinemode=<%=JSPLib.ToJSValue(sp.getParameter("offlinemode","false"))%>" + (custom? "&custom=true" : "" );
    var url = new JSURL("../servlet/JSPReader?type=menu&name="+save_value+"&folder_path="+folder_path+"&check=true"+parameters,true);
    var conf = true;
    output=url.Response();

    if(output=="found"){
      if(confirm("File already existing overwrite?")){}
      else
        conf = false;
    }

    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        // windowOpener.AddRecentOpen('<%=tool%>',save_value,folder_path);
      } else{
        windowOpener.currentname=save_value;
        windowOpener.save();
      }
    }

  <%} else if(tool.equals("module")){%>
    var url = new JSURL("../servlet/JSPReader?type=module&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
    var conf = true;
    output=url.Response();

    if(output=="found"){
      if(confirm("File already existing overwrite?")){
      }
      else
        conf = false;
    }

    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:folder_path});
      }
      else{
        windowOpener.currentname=save_value;
        windowOpener.save();
      }
    }

  <%} else if(tool.equals("classeditor")){%>
    var ok = true;
    if(Ctrl("themes_list").value!="") {
      var url = new JSURL("../servlet/JSPReader?type=classeditor&folder_path=", true);
      var classes = url.Response().split(',');
      ok = (classes.indexOf(save_value + ".ce.css") > -1) ? true : false;
      folder_path = Ctrl("themes_list").value+"/styles";
      var allStylesDefault = GetOpener().restoreClassFromFile("styles/"+ save_value);
      var found = false;
      for(var i = 0; allStylesDefault && i < allStylesDefault.length && !found; i++) {
        if(allStylesDefault[i].class_name == GetOpener().newObj.class_name) found = true;
      }
      ok = found;
    } else {
      folder_path = "styles";
    }

    if(ok) {
      GetOpener().saveClass({newPosition: folder_path +"/"+ save_value});
    } else {
      alert("You must create this class in the default css in styles folder before save it in a skinned css!");
      return;
    }

  <%} else if(tool.equals("maskparameters")){%>
    var filter='<%=JSPLib.ToJSValue(filter)%>';
    filter=filter.split('__')[0];
    if (!Empty(filter))
      filter+='__';
    if (save_value==Strtran(filter,'__','') && Empty(document.getElementById("user_group").value)){
      alert("Deafult mask can't be overwritten!");
    }
    else if (save_value==filter){
      alert("You must specify the variant name");
    }
    else if (Empty(filter) || save_value.indexOf(filter)==0 || confirm("This mask will not be considered variant of the original. \n Do you want to continue?")){
      <%if (!"".equals(filter)){
        if (sp.isAdministrator()){%>
          if (document.getElementById("user_group")){
            var user_group=document.getElementById("user_group").value;
            if (!Empty(user_group)){
              var u_g=document.getElementById('fld_'+user_group).value;
              if (!Empty(u_g)){
                save_value+='_'+(user_group=='group'?'g':'')+u_g;
              }
            }
          }
          custom=false;
        <%}else {%>
          save_value+='_<%=(int)sp.getUserCode()%>';
          custom=true;
        <%}
      }%>
      var url = new JSURL("../servlet/JSPReader?type=maskparameters&name="+save_value+"&custom="+custom+"&check=true",true);
      var conf = true;
      output=url.Response();
      if(output=="found"){
        if(confirm("File already existing overwrite?")){
          if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex])
            windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].forceSaveVdm=true;
          else windowOpener.forceSaveVdm=true;
        }
        else
          conf = false;
      }
      if(conf){
        if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
          windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:folder_path});
        }
        else{
          windowOpener.currentname=save_value;
          windowOpener.save();
        }
      }
    }

  /* EGhisalberti init editing - 20131023 */
  <%} else if(tool.equals("chart")){%>
    var url = new JSURL("../servlet/JSPReader?type=chart&name="+save_value+"&custom="+custom+"&check=true",true);
    var conf = true;
    output = url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){}
      else
        conf = false;
    }
    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{custom:custom});
      }
      else{
        windowOpener.currentname=save_value;
        windowOpener.save();
      }
    }
  /* EGhisalberti end editing */
  /* EGhisalberti init editing - 20131023 */
  <%} else if(tool.equals("visualpivot")){%>
    var url = new JSURL("../servlet/JSPReader?type=visualpivot&name="+save_value+"&custom="+custom+"&check=true",true);
    var conf = true;
    output = url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){}
      else
        conf = false;
    }
    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].configname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{custom:custom});
      }
      else{
        windowOpener.configname=save_value;
        windowOpener.save();
      }
    }
  /* EGhisalberti end editing */
  <%} else if(tool.equals("plan")){%>
    var planmode='<%=JSPLib.ToJSValue(planmode)%>'
    //CUSTOM CMS
    var isCMS = <%=sp.getParameter("isCMS",false)%>
    if(!isCMS)
      var url = new JSURL("../servlet/JSPReader?type=plan&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
    else
      if(planmode=='asModel')
        var url = new JSURL("../servlet/JSPReader?type=plan&name="+save_value+"&folder_path="+folder_path+"&check=true&fromCMS=true&planmode=asModel",true);
      else
        var url = new JSURL("../servlet/JSPReader?type=plan&name="+save_value+"&folder_path="+folder_path+"&check=true&fromCMS=true",true);

    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        //CUSTOM CMS
        if(!isCMS){
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=folder_path+save_value;
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(planmode);
        }
        else{
          windowOpener.frames[0].currentname=folder_path+save_value;
          windowOpener.frames[0].save(planmode);
        }
      }
    }else{
      if(!isCMS){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=folder_path+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(planmode);
      }
      else{
        windowOpener.frames[0].currentname=folder_path+save_value;
        windowOpener.frames[0].save(planmode);
      }
    }
    //CUSTOM CMS
    if(!isCMS)
      windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:folder_path});
  <%} else if(tool.equals("css")){%>
      folder_path = Ctrl("themes_list").value;
      if(folder_path!=""){ // se cerca di salvare in cartella del tema
        var url = new JSURL("../servlet/JSPReader?type=css&name="+save_value+"&check=true",true);
        output=url.Response();
        if(output!="found"){
          alert("First save as not themed.");
          return;
        }
      }
      //if(folder_path!='')folder_tmp='../../'+folder_path;else folder_tmp='';
      var url = new JSURL("../servlet/JSPReader?type=css&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
      output=url.Response();
      if(output=="found"){
        if(confirm("File already existing overwrite?")){
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].fileName=folder_path+'/styles/'+save_value;
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(folder_path);
        }
      }else{
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].fileName=folder_path+'/styles/'+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(folder_path);
      }
      windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:folder_path});
  <%} else if(tool.equals("decorators")){%>
      var themed=false;
      if(Ctrl("themes_list").value!=""){
        themed=true;
        folder_path=Ctrl("themes_list").value+"/jsp-decorators";
      }else
        folder_path="jsp-decorators";
      if(themed){ // se cerca di salvare in cartella del tema
        var url = new JSURL("../servlet/JSPReader?type=decorators&name="+save_value+"&folder_path=jsp-decorators&check=true",true);
        output=url.Response();
        if(output!="found"){
          alert("First save as not themed.");
          return;
        }
      }
      var url = new JSURL("../servlet/JSPReader?type=decorators&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
      output=url.Response();
      if(output=="found"){
        if(confirm("File already existing overwrite?")){
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname="../"+folder_path+'/'+save_value;
          windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        }
      }else{
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname="../"+folder_path+'/'+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
      }
      windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:Ctrl("themes_list").value});
  <%} else if(tool.equals("pagelet")){%>
    if(Ctrl("themes_list").value!=""){ //salva il file nella cartella del tema
      folder_path="/../"+Ctrl("themes_list").value;
    }
    if(folder_path.indexOf("../")>-1){ // se cerca di salvare in cartella del tema
      var url = new JSURL("../servlet/JSPReader?type=pagelet&name="+save_value+"&folder_path=&check=true",true);
      output=url.Response();
      if(output!="found"){
        alert("First save the pagelet in the jsp root.");
        return
      }
    }
    var url = new JSURL("../servlet/JSPReader?type=pagelet&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=folder_path+'/'+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(Ctrl('themes_list').value);
      }
    }else{
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=folder_path+'/'+save_value;
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(Ctrl('themes_list').value);
    }
    windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:Ctrl("themes_list").value});
  <%} else if(tool.equals("pageleteditor")){%>
    if(Ctrl("themes_list").value!=""){ //salva il file nella cartella del tema
      folder_path="/../"+Ctrl("themes_list").value;
    }
    if(folder_path.indexOf("../")>-1){ // se cerca di salvare in cartella del tema
      var url = new JSURL("../servlet/JSPReader?type=pageleteditor&name="+save_value+"&folder_path=&check=true",true);
      output=url.Response();
      if(output!="found"){
        alert("First save the pagelet in the jsp root.");
        return
      }
    }
    var url = new JSURL("../servlet/JSPReader?type=pageleteditor&name="+save_value+"&folder_path="+folder_path+"&check=true",true);
    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=folder_path+'/'+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(Ctrl('themes_list').value);
      }
    }else{
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=folder_path+'/'+save_value;
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save(Ctrl('themes_list').value);
    }
    windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{folder_path:Ctrl("themes_list").value});
  <%} else if(tool.equals("portalzoom")){%>
    var url = new JSURL('../servlet/JSPReader?type=portalzoom&filter=<%=JSPLib.ToJSValue(filter)%>'+'&tablename=<%= JSPLib.ToJSValue(tablename) %>'+'&folder_path=<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>&name='+save_value+"&check=true&custom="+custom,true);
    var conf = true;
    output=url.Response();

    if(output=="found"){
      if(confirm("File already existing overwrite?")){
      }
      else
        conf = false;
    }

    if(conf){
      windowOpener.saveNewName(save_value);
    }
  <%} else if(tool.equals("manualjsp")){%>
    var url = new JSURL("../servlet/JSPReader?type=pagelet&name="+Strtran(save_value,".jsp","")+"&folder_path="+folder_path+"&check=true",true);
    output=url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].fileName=Strtran(save_value,".jsp","");
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
      }
    }else{
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].fileName=Strtran(save_value,".jsp","");
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
    }
    windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{});
 <%} else if(tool.equals("smartreport")){%>
    var url = new JSURL("../servlet/JSPReader?type=smartreport&name="+save_value+"check=true&custom="+custom,true);
    var conf = true;
    output = url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){}
      else
        conf = false;
    }
    if(conf){
      if(windowOpener.frames['portalstudioframe'+windowOpener.currentIndex]){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
        windowOpener.AddRecentOpen('<%=JSPLib.ToJSValue(tool)%>',save_value,{custom:custom});
      }
      else{
        windowOpener.currentname=save_value;
        windowOpener.save();
      }
      windowOpener.forcePreviewReload=true;
    }
  <%} else if(tool.equals("interfaces")){%>
    var url = new JSURL("../servlet/JSPReader?type=interfaces&name="+save_value+"&check=true&folder_path="+folder_path+"&custom="+custom,true);
    var conf = true;
    output = url.Response();
    if(output=="found"){
      if(confirm("File already existing overwrite?")){
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=(!Empty(folder_path)?folder_path+'/':'')+save_value;
        windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
      }
    }else{
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].currentname=(!Empty(folder_path)?folder_path+'/':'')+save_value;
      windowOpener.frames['portalstudioframe'+windowOpener.currentIndex].save();
    }
  <%}%>
  }
  closeWindow();
}
function DoOnKeyDown(e){
  e = e ? e : window.event;
  var keyCode = GetKeyCode(e);
  if(keyCode==13)
    setSave();
  else if(keyCode==27)
  closeWindow();
}
function Themes_List(tool){
  var url=new JSURL("../servlet/JSPReader?type=themes",true);
  var output=url.Response();
  var list=output.split(",");
  for(var i=0;i<list.length-1;i++){
    opt=new Option;
    opt.text=list[i];
    opt.value=list[i];
    Ctrl("themes_list").options[i+1]=opt;
  }
}
function changeUserGroup(){
  var u_g=document.getElementById("user_group").value;
  if (u_g=='user'){
    document.getElementById('lbl_user').style.display='';
    document.getElementById('fld_user').style.display='';
    document.getElementById('lbl_group').style.display='none';
    document.getElementById('fld_group').style.display='none';
  }
  else if(u_g=='group'){
    document.getElementById('lbl_user').style.display='none';
    document.getElementById('fld_user').style.display='none';
    document.getElementById('lbl_group').style.display='';
    document.getElementById('fld_group').style.display='';
  }
  else {
    document.getElementById('lbl_user').style.display='none';
    document.getElementById('fld_user').style.display='none';
    document.getElementById('lbl_group').style.display='none';
    document.getElementById('fld_group').style.display='none';
  }
}

function updateList(tool) { // aggiorna la lista dei css in base allo skin selezionato
  var path = document.getElementById("themes_list").value;
  var url = new JSURL("../servlet/JSPReader?type="+tool+"&folder_path="+path, true);
  var classes = url.Response();
  classes = classes.split(',');

  // rimuovo quelle vecchie
  var paras = document.getElementsByClassName('file-item');
  while(paras[0]) paras[0].parentNode.removeChild(paras[0]);

  // aggiungo quelle nuove
  if (typeof(classes) != 'undefined') {
    for (var i = 0; i < classes.length; i++) {
      var div = document.createElement("div");
      div.className = "file-item";
      var p = document.createElement("p");
      p.className = "name";
      p.appendChild(document.createTextNode(classes[i].replace(".ce.css", "")));
      document.getElementById("list").appendChild(div).appendChild(p);
    }
    makeUpList();
  }
}
var data = { standard: [], sites: {}, templates: {}}
function setData( d ) {
  d.reduce( (acc,e) => {
      let s = e.split("/");
      if( s[0] != "" ) {
        let name = s[s.length -1].indexOf("_variant.jsp") > 0 ? Strtran(s[s.length -1], "_variant.jsp", "") : null;
        if( s.length > 1) {
          let folder_name = s[1];
          if( s[0] == "sites") {
            if ( !data.sites[folder_name] ){
              data.sites[folder_name] = { url: []};
            }
            if( name ) {
              data.sites[folder_name].url.push( name );
            }
          } else if( s[0] == "templates" ) {
            if ( !data.templates[folder_name] ){
              data.templates[folder_name] = { url: []};
            }
            if( name ){
              data.templates[folder_name].url.push( name );
            }
          } else if( name ) {
            data.standard.push( name ) ;
          }
        }
      }
      return acc;
  }, data );
}
function getData(){
  return data;
}

function selectFolder(){
  let path  = document.getElementById("select_1").value;
  let folders = ["-"];
  if( path != "-") {
    folders = Object.keys(getData()[path]);
  }
  let select_2 = document.getElementById("select_2");
  select_2.innerHTML = "";
  folders.forEach( (f,i) => {
    let opt = new Option(f,f, false, false);
    select_2.appendChild(opt);
  })
  select_2.value = folders[0];
  select_2.onchange();
}

function changeFolder(){
  let path  = document.getElementById("select_1").value;
  let path2 = document.getElementById("select_2").value;


  // rimuovo quelle vecchie
  var paras = document.getElementsByClassName('file-item');
  while(paras[0]) paras[0].parentNode.removeChild(paras[0]);

  // aggiungo quelle nuove
  let variants = [];
  if( path != "-" && path2 ){
    variants = getData()[path][path2].url;
  } else if( path == "-"){
    variants = getData().standard;
  }
  for (var i = 0; i < variants.length; i++) {
    var div = document.createElement("div");
    div.className = "file-item";
    var p = document.createElement("p");
    p.className = "name";
    p.appendChild(document.createTextNode(variants[i]));
    document.getElementById("list").appendChild(div).appendChild(p);
  }
  makeUpList();

}

</script>

<body style="border:0;margin:0;width:100%;min-width:520px;">
  <div id="tools" ><span>A<u>v</u>ailable files:</span></div>
    <div id="list">
    <script>
      var folder_path='<%=JSPLib.ToJSValue(sp.getParameter("folder_path",""))%>';
      let custom = <%=custom%>;
<%if("portlet".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=portlet&folder_path="+folder_path);
      portletFiles = portletFiles.Response();
      if(folder_path!="")
        document.write("<div class='file-item'><p class='name'>[...]</p></div>");
      if(portletFiles!=""){
        var Files=portletFiles.split(",");
        for(var i=0;i<Files.length;i++){
          document.write("<div class='file-item'><p class='name'>"+Strtran(Files[i], "_portlet.jsp", "")+"</p></div>");
        }
      }
<%} else if(tool.equals("interfaces")){%>
  console.log(folder_path);
      portletFiles = new JSURL("../servlet/JSPReader?type=interfaces&folder_path="+folder_path+"&custom=" + custom);
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, "_portlet.jsp", "");
      if(folder_path!='')
        document.write("<div class='file-item'><p class='name'>[...]</p></div>");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if(tool.equals("pagelet")){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=pagelet&folder_path="+folder_path);
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".jsp", "");
      if(folder_path!='')
        document.write("<div class='file-item'><p class='name'>[...]</p></div>");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if(tool.equals("pageleteditor")){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=pageleteditor&folder_path="+folder_path);
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".jsp", "");
      if(folder_path!='')
        document.write("<div class='file-item'><p class='name'>[...]</p></div>");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if(tool.equals("report")){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=webreport&custom=<%=custom%>");
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".vrp", "");
      portletFiles = Strtran(portletFiles, ".VRP", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<% } else if(tool.equals("scandoc")){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=scandoc");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".sca","");
      portletFiles=Strtran(portletFiles,".SCA","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
//MENUEDITOR
<%} else if("menu".equals(tool)){%>
      portletFiles = new JSURL('../servlet/JSPReader?type=menu&custom=<%=custom%>&offlinemode=<%=JSPLib.ToJSValue(sp.getParameter("offlinemode","false"))%>');
      portletFiles = portletFiles.Response();
      portletFiles=Strtran(portletFiles,".vmn","");
      portletFiles=Strtran(portletFiles,".VMN","");
      portletFiles=Strtran(portletFiles,".offline","");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
//END MENUEDITOR
<% } else if(tool.equals("module")){%>
      portletFiles=new JSURL("../servlet/JSPReader?type=module");
      portletFiles=portletFiles.Response();
      portletFiles=Strtran(portletFiles,".mrp","");
      portletFiles=Strtran(portletFiles,".MRP","");
      var Files=portletFiles.split(',');
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if(tool.equals("plan")){%>
      var isCMS = <%=sp.getParameter("isCMS",false)%>
      var planmode='<%=JSPLib.ToJSValue(planmode)%>';
      if(!isCMS)
        portletFiles = new JSURL("../servlet/JSPReader?type=plan");
      else{
        if(planmode=='asModel')
          portletFiles = new JSURL("../servlet/JSPReader?type=plan&fromCMS=true&planmode=asModel");
        else
          portletFiles = new JSURL("../servlet/JSPReader?type=plan&fromCMS=true");
      }
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".plandef", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Strtran(Files[i], ".plandef", "")+"</p></div>");
      }
<%} else if(tool.equals("css")){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=css");
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".css", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Strtran(Files[i], ".css", "")+"</p></div>");
      }
<%} else if(tool.equals("classeditor")){%>
      var url = new JSURL("../servlet/JSPReader?type=classeditor", true);
      var classes = url.Response();
      classes = classes.split(',');
      if (typeof(classes) != 'undefined') {
        for (var i = 0; i < classes.length; i++) {
          document.write("<div class='file-item'><p class='name'>"+ classes[i].replace(".ce.css", "") +"</p></div>");
        }
      }
<%} else if(tool.equals("decorators")){%>
    <%if(!"".equals(sp.getParameter("pagelet_template_folder",""))){%>
      folder_path='..<%=JSPLib.ToJSValue(sp.getParameter("pagelet_template_folder",""))%>'+"jsp-decorators";
    <%}else{%>
      folder_path="../../jsp-decorators";
    <%}%>
      portletFiles = new JSURL("../servlet/JSPReader?type=decorators&folder_path="+folder_path);
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, "._portlet.jsp", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Strtran(Files[i], "_portlet.jsp", "")+"</p></div>");
      }
<%} else if("maskparameters".equals(tool)){%>
      <%if (!sp.isAdministrator())
          custom=true;
        else if (!"".equals(filter))
          custom=true;
      %>
      var filter = '<%= JSPLib.ToJSValue(filter.split("__")[0]) %>';
      if (!Empty(filter))
        filter+='__';
      portletFiles = new JSURL("../servlet/JSPReader?type=maskparameters&custom="+'<%=custom%>'+"&filter="+filter);
      portletFiles = portletFiles.Response();
      portletFiles=Strtran(portletFiles,".vdm","");
      portletFiles=Strtran(portletFiles,".VDM","");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if("chart".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=chart&custom=<%=custom%>");
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".chartdef", "");
      portletFiles = Strtran(portletFiles, ".CHARTDEF", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if("visualpivot".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=visualpivot&custom=<%=custom%>");
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".vpv", "");
      portletFiles = Strtran(portletFiles, ".VPV", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if("smartreport".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=smartreport&custom=<%=custom%>");
      portletFiles = portletFiles.Response();
      portletFiles = Strtran(portletFiles, ".svrp", "");
      portletFiles = Strtran(portletFiles, ".SVRP", "");
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if("portalzoom".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=portalzoom&folder_path="+folder_path+'&filter=<%= JSPLib.ToJSValue(filter) %>'+'&tablename=<%= JSPLib.ToJSValue(tablename) %>'+"&custom="+'<%=custom%>');
      portletFiles = portletFiles.Response();
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
<%} else if("variant".equals(tool)){%>
      portletFiles = new JSURL("../servlet/JSPReader?type=variant&folder_path="+folder_path+"&listFolder=true");
      portletFiles = portletFiles.Response();
      setData( portletFiles.split(",") );
      let files = getData().standard
      for(var i=0;i<files.length;i++){
        document.write("<div class='file-item'><p class='name'>" + files[i] + "</p></div>");
      }
<%} else {%>
      portletFiles = new JSURL("../servlet/JSPReader");
      portletFiles = portletFiles.Response();
      var Files=portletFiles.split(",");
      for(var i=0;i<Files.length;i++){
        document.write("<div class='file-item'><p class='name'>"+Files[i]+"</p></div>");
      }
  <%}%>
    </script>
    </div>
    <div id="footer"><span >File <u>n</u>ame:</span>
      <input id="saveasname" type="text" value="" accesskey="n" onKeyDown="DoOnKeyDown(event)">
<%if(tool.equals("pagelet") || tool.equals("pageleteditor") || tool.equals("css") || tool.equals("classeditor") || tool.equals("decorators")){%>
    <script>
      document.body.classList.add("row2");
    </script>
  <%if(tool.equals("pagelet") || tool.equals("pageleteditor") ){%>
    <span >Save in theme:</span>
    <select id="themes_list" class="propertiesTablePValueCheckbox">
      <option value="">-</option>
    </select>
  <%}else if(tool.equals("css")){%>
    <span >Save in theme:</span>
    <select id="themes_list" class="propertiesTablePValueCheckbox" onchange="updateList('<%=JSPLib.ToJSValue(tool)%>')">
      <option value="">-</option>
    </select>
  <%}else if(tool.equals("classeditor") || tool.equals("css")){%>
    <span >Save in theme:</span>
    <select id="themes_list" class="propertiesTablePValueCheckbox" onchange="updateList('<%=JSPLib.ToJSValue(tool)%>')">
      <option value="">-</option>
    </select>
  <%}else if(tool.equals("decorators")){%>
    <span style="float:left">Save as decorator in theme:</span>
    <select id="themes_list" class="propertiesTablePValueCheckbox">
      <option value="">-</option>
    </select>
  <%}else if(tool.equals("portalzoom")){%>
    <span >Custom directory:</span>
    <select id="themes_list" class="propertiesTablePValueCheckbox">
      <option value="0">no</option>
      <option value="1">yes</option>
    </select>
  <%}%>
<%}else if (tool.equals("maskparameters")){%>
  <script>
    Ctrl('saveasname').value='<%= JSPLib.ToJSValue(filter) %>';
  </script>
    <%if (!"".equals(filter) && sp.isAdministrator()){%>
      <script>
        document.body.classList.add("row2");
      </script>
      <span>User or group:</span>
      <select id="user_group" class="propertiesTablePValueCheckbox" onchange='changeUserGroup()'>
        <option value="">-</option>
        <option value="user">User</option>
        <option value="group">Group</option>
      </select>
      <span id='lbl_user' style='display:none;'>User:</span>
      <input id='fld_user' type='textbox' value='' style='display:none'/>
      <span id='lbl_group' style='display:none;'>Group:</span>
      <input id='fld_group' type='textbox' value='' style='display:none'/>
      </div>
    <%}%>
  <%} else if ( "variant".equals(tool)) {
        if( "S".equals(sp.getGlobal("g_CMS", "" )) ) {%>
          <script>
            document.body.classList.add("row2");
          </script>
          <span>Sites/Templates:</span>
          <select id="select_1" class="propertiesTablePValueCheckbox" onchange='selectFolder()'>
            <option value="-" selected>-</option>
            <option value="sites">Sites</option>
            <option value="templates">Templates</option>
          </select>
          <select id="select_2" class="propertiesTablePValueCheckbox" onchange='changeFolder()'>
          </select>
        <%}
    }%>
    <div id='buttons'>
      <button onclick="setSave()" accesskey="s" class="bottoni"><u>S</u>ave as</button>&nbsp;
      <button onclick="closeWindow();" accesskey="c" class="bottoni"><u>C</u>ancel</button>
    </div>
</body>
</html>
