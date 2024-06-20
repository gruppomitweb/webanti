<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples","")) || sp.CanModifyOwnQuery()) {
    boolean rewriteId=false;
    if(request.getQueryString()!=null && request.getQueryString().indexOf("filename=")==-1)
      rewriteId=true;
  boolean simplemode = sp.getParameter("simplemode",false);
  String item_index = sp.getParameter("for","");
  String item_prop = sp.getParameter("prop","");
%>

<!DOCTYPE html>
<html style='height:100%;width:100%;overflow-x:hidden;overflow-y:auto;margin:0;padding:0;'>
<head>
  <script type="text/javascript">
    if(<%=rewriteId%>) {
      window.location.href+="&filename="+'<%=JSPLib.ToJSValue(sp.getParameter("filename",""))%>';
    }
    var SPWebRootURL='<%=JSPLib.SPWebRootURL(request)%>';
    var offlinemode=<%=sp.getParameter("offlinemode",false)%>;
    var simplemode=<%=simplemode%>;
    var item_index='<%=item_index%>';
    var item_prop='<%=item_prop%>';
    var IsQueryTestInstalled=<%="yes".equals(sp.getGlobal("IsQueryTestInstalled",""))%>;
    var addSecurityBtn=<%="yes".equals(sp.getGlobal("IsSPAdministrationInstalled","")) && (sp.isAdministrator() || !sp.hasAdministeredUsers())%>;
    var cmdhash = '<%=JSPLib.cmdHash("visualquery", request.getSession())%>';
  </script>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>VisualQuery - Sitepainter Infinity Portalstudio</title>
  <link type="text/css" rel="stylesheet" href="../filewindow.css">
  <link type="text/css" rel="stylesheet" href="../portalstudio/TabsMT.css">
  <link type="text/css" rel="stylesheet" href='../<%=SPPrxycizer.proxycizedPath("visualquery/visualquery.css")%>'>
  <link type="text/css" rel="stylesheet" href="../portalstudio/nanoScrollerMT.css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link type="text/css" rel="stylesheet" href='../<%=SPPrxycizer.proxycizedPath("/properties.css")%>'>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-core.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualquery/visualquery.js")%>' charset="ISO-8859-1"></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualquery/VQRSelectableList.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/TabsMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>

  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
  <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
  <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />
</head>

<body onLoad="DoLoad('<%=JSPLib.ToJSValue(sp.getParameter("filename",""))%>',<%=sp.getParameter("frontendport",0)%>,'<%=JSPLib.ToJSValue(sp.getParameter("custom",""))%>',<%=sp.getParameter("offlinemode",false)%>)" onResize="callResizeFunction()" bgcolor="#ffffff" link="#FFFFFF" vlink="#FFFFFF" alink="#FFFFFF">
<input type="text" id="disable-user-mgr-1" style="display: none;" value="stop-user-mgr-1"/>
<input type="password" id="disable-pwd-mgr-1" style="display: none;" value="stop-pwd-mgr-1"/>
<div id="saving" style="z-index:102;position:absolute;background:#ffffff;left:0;top:0;display:none;text-align:center"></div>
<div id="savingpic" style="width:126px; position:absolute;display:none;z-index:103">
 <p style="padding:0;margin:0;font-size:16px;font-weight:bold; font-family:Tahoma,Verdana,Arial;text-align:center; color:#7E7C7C;">Saving...<br /><br />
  <img src="../visualweb/images/saving.gif" alt="Saving...">
 </p>
</div>

<!-- DICTIONARY =====================================================================================================-->
 <div style="width:100%; background:#f3f3f3; height:30px;" onselectstart="return false" >

    <!--td  align="center" valign="middle" class="titoli" style="width:180px;border-right:0px">

    </td-->
       <!--div style="float:right">
      <!-- TOOLBAR =====================================================================================================-->
        <!--div id="StandaloneToolbar" style="display:none">
          <a title="New" href="javascript:New();"><img src="images/bot_qd_new.png" alt="New" border=0></a>
          <a title="Open" href="javascript:Open();"><img src="images/bot_qd_open.png" alt="Open" border=0></a>
          <a title="Save" href="javascript:Save();"><img src="images/bot_qd_save.png" alt="Save" border=0></a>
          <a title="Save as" href="javascript:GetFilename('saveas');"><img src="images/bot_qd_saveas.png" alt="Save as" border=0></a>
        </div>

      </div-->
    <div id ='dictionaryTitle' class="titoli" style="">
      Dictionary
    </div>
    <div id='toolbar'></div>
  </div>
<div id="dictionaryPanel" style="position:relative;">

  <div id="dictPanelTitleTableContainer" style="display:block;overflow:hidden;padding-top:10px;">
  <table id="dictPanelTitleTable" style="width:100%; table-layout:fixed;" onselectstart="return false" cellspacing="0" border="0"cellpadding='0'>
  <tr id="dictPanelTitleTr" style="">
    <td id="title_tables" colspan="1" align="center" valign="middle" style="width:52%; " class="titoli">Tables</td>
    <td id="addbo" align="center" valign="middle" style="width:50px; background:#fff; padding-top:0; padding-bottom:0; padding-right:12px; padding-left:7px;" class="titoli">
      <input type="button" value="Add BO" class="bottoni" onClick="AddBOTable()">
    </td>
    <td id="addquery" align="center" valign="middle" style="width:70px;background:#fff; padding:0;  " class="titoli">
      <input type="button" value="Add Query" class="bottoni" onClick="AddTempTable()" style="float:right;">
    </td>
    <td id="addstoredprocedure" align="center" valign="middle" style="width:140px;background:#fff; padding:0;  " class="titoli">
      <input type="button" value="Add Stored Procedure" class="bottoni" onClick="toggleStoredProcedureDiv()" style="float:right;">
    </td>
    <td style="width:10px"> </td>
    <td id="title_fields"align="center"  valign="middle" style="width:40%" class="titoli" nowrap>
      <div id="lbl_fields">Fields</div>
    </td>
	</tr>
	<tr>
    <td id ='contentTable' colspan="4" style="" valign='top'>
     <div id="dictTablesTitDiv" style="overflow:auto;position:relative" class="">
      <table id="dictTablesTitles" style="width:100%" onselectstart="return false" border="0" cellspacing="0" cellpadding='0' class="internobianco">
        <tr style="cursor:default" class="TitleBar">
         <td id="tables_descr_title" class="DivTableTitle" onDblClick="SortTableList(0)" width="40%; padding-left:6px">Description</td>
         <td id="tables_name_title"  class="DivTableTitle" onDblClick="SortTableList(1)" width="35%;padding:0">Name</td>
         <td id="tables_module_title"  class="DivTableTitle" onDblClick="SortTableList(2)" width="25%">Module</td>
        </tr>
      </table>
      </div>
     <div id="dictTablesDiv" style="min-width:400px;" class="tableBackgroundDiv" onselectstart="return false">
    </div>
    </td>
    <td width='10'></td>
    <td id='contentField' colspan='1' style="width:10%,margin:0 auto;" valign='top'>
     <div id="dictFieldsDivTit" style="overflow:auto;position:relative;" class="">
      <table id="dictFieldsTitles" style="width:100%" onselectstart="return false" border="0" cellspacing="0" class="internobianco">
        <tr style="cursor:default" class="TitleBar">
         <td class="DivTableTitle" onDblClick="SortFieldList(0)" width="52%">Description</td>
         <td class="DivTableTitle" onDblClick="SortFieldList(1)" width="31%">Name</td>
         <td class="DivTableTitle" onDblClick="SortFieldList(2)" width="11%">Type</td>
         <td class="DivTableTitle" onDblClick="SortFieldList(3)" >Idx</td>
        </tr>
      </table>
      </div>
     <div id="dictFieldsDiv" style="min-width:250px;" class="tableBackgroundDiv" onselectstart="return false">
     </div>
    </td>
	</tr>
  <tr>
    <td colspan='6'>
      <table id="dictPanelRelTitleTable" style="width:100%" onselectstart="return false" border="0" cellspacing="0" class="internobianco" >
        <!--seconda tabella-->
        <tr id="dictPanelRelTitleTr" style="height:20px" class='TitleBar'>
          <td colspan="4" align="center" class="DivTableTitle" >
            <div id="lbl_relations" style='height:14px;' class='textClipped'>Relations</div>
          </td>
      </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td id="dictPanelRelTr" colspan="6" style="">
     <div id="dictPanelRelDiv" style="height:62px;" class="tableBackgroundDiv">
     </div>
    </td>
	</tr>
 </table>
 </div>
 <div id="tableopenclose"  title="Toggle tools selector"><div id="tlb-openclose-arrow">&nbsp;</div></div>
</div>

<!--  Wizard scelta campi tabella            -->
<!-- <div style="height:250px;top:70px;left:200px;position:absolute;visibility:hidden;z-index:1000; overflow:hidden" class="contenuto" id="wizardField">
  <a class="deleteIcon" style="position:absolute;right:4px;top:4px;" title="Close" href="javascript:void(0)" onclick="javascript:toggleWizardField()"><img src="images/del.png" border='0'></a>
  <div class='titoli' id='wizardFieldTitle' style="cursor:move; text-align:center; margin-bottom:5px; padding-right:20px" onMouseDown="dragToolbar(event,'wizardField',4);">
  </div>
  <div id='listFields' style='overflow:auto; height:150px'>
  </div>
  <div class='footer' align="right" style='margin-top:5px'>
    <button style="width:50px" id='btnWizard' onclick='SelectField()' accesskey="f" class="bottoni">Select</button>
  </div>
</div> -->


 <!-- div per specificare il nome della Stored Procedure  -->
 <div style="display:none;top:70px; left:500px;" class="contenuto" id="maskStoredProcedure">
  <div class='titoli' onMouseDown="dragToolbar(event,'maskStoredProcedure',4);" id='maskStoredProcedureTitle' style="cursor:move; font-weight:bold; margin-bottom:5px; padding-right:20px" >
    Stored procedure
 </div>
  <table>
  <tr>
    <td align='right' style='padding-left:5px'> Stored procedure:</td>
    <td>
      <input id="storedProcedureName" class="textbox" type="text" name="queryToCompare" size="30" />
    </td>
  </tr>
  </table>
  <div class='footer' align="right"  style='margin-top:5px'>
    <button style="margin-right:5px;" id='storedProcedureOk' accesskey="o" class="bottoni" onclick="AddStoredProcedure()">Ok</button>
    <button style="margin-right:5px;" accesskey="c" class="bottoni2" onclick='toggleStoredProcedureDiv()'>Close</button>
  </div>
</div>

<!-- Find =====================================================================================================-->
<div style="height:188px;width:275px;top:70px;left:300px;position:absolute;visibility:hidden;z-index:1000" class="contenuto" id="searchPanel">
  <table style="height:100%;width:100%;position:absolute;left:0;top:0" cellspacing="0" border="0" class="testo">
   <tr id="searchPanelCaptionTr" style="height:22px" onselectstart="return false;">
    <td align="center" class="titoli">
     <div style="cursor:move;" onMouseDown="dragToolbar(event,'searchPanel',4);">
      <b>Find</b>
     </div>
    </td>
   </tr>
   <tr style='height:134px;'>
    <td class="contenuto">
     <input id="tableDesc" type="text" style="position:absolute;top:29px;left:104px;width:165px" maxlength="100">
     <label style="position:absolute;top:35px;left:8px" onselectstart="return false">Table description:</label>

     <input id="tableName" type="text" style="position:absolute;top:54px;left:104px;width:165px" maxlength="100">
     <label style="position:absolute;top:60px;left:36px" onselectstart="return false">Table name:</label>

     <input id="fieldDesc" type="text" style="position:absolute;top:96px;left:104px;width:165px" maxlength="100">
     <label style="position:absolute;top:102px;left:12px" onselectstart="return false">Field description:</label>

     <input id="fieldName" type="text" style="position:absolute;top:121px;left:104px;width:165px" maxlength="100">
     <label style="position:absolute;top:127px;left:40px" onselectstart="return false">Field name:</label>
    </td>
   </tr>
   <tr style="height:20px" onselectstart="return false;">
    <td class="footer" valign="middle" align="right" nowrap>
     <button style="width:50px" onClick="Find()" accesskey="f" class="bottoni"><u>F</u>ind</button>&nbsp;
     <button style="width:50px" onClick="Find(true)" accesskey="n" class="bottoni"><u>N</u>ext</button>&nbsp;
     <button style="width:50px" id='closeMaskFind' accesskey="o" class="bottoni2" onclick='javascript:ToggleSearchPanel(event)'>Close</button>
    </td>
   </tr>
  </table>
</div>

 <!-- div per la modifica dei tipi dei campi e parametri  -->
<div class="contenuto pSheet" id="maskType">
  <div class='titoli textClipped' id='maskTypeTitle' onMouseDown="dragToolbar(event,'maskType',4);">
 </div>
 <div class='pTabs' id='maskTypeTab'>
   <div class='prop_tab' onclick='tabMaskType("type")' id='tab_type'>Type</div>
   <div class='prop_tab' onclick='tabMaskType("default")' id='tab_default'>Default value</div>
   <div class='prop_tab' onclick='tabMaskType("privacy")' id='tab_privacy'>Privacy</div>
 </div>
  <div style='padding:5px 12px;'>
    <div id='content_tab_type'>
      <div>
        <label class='properties_label'>
          <a>Type</a>
        </label>
        <span id='mask_type'></span>
      </div>
      <div>
        <label class='properties_label'>
            <a>Length</a>
        </label>
        <span id='mask_len'></span>
      </div>
      <div>
        <label class='properties_label'> <a>Decimals</a></label>
        <span id='mask_dec'></span>
      </div>
      <div id='mask_keep_spaces_tr' syle='display:none;'>
        <label class='properties_label'> <a>Keep spaces</a></label>
        <span id='mask_keep_spaces'></span>
      </div>
    </div>
    <div id='content_tab_default'>
      <div id='mask_default_value_div' style='display:none;'>
        <label class='properties_label'> <a>Default value</a></label>
        <span id='mask_default_value'></span>
      </div>
      <div id='mask_use_default_when_div' style='display:none;'>
        <label class='properties_label'> <a>Use default when</a></label>
        <span id='mask_use_default_when'></span>
      </div>
    </div>
    <div id='content_tab_privacy'>
      <div id='mask_privacy_tr' style='display:none;'>
        <label class='properties_label'> <a>Data Sensibility</a></label>
        <span id='mask_privacy'></span>
      </div>
      <div id='mask_identifier_tr' style='display:none;'>
        <label class='properties_label'> <a>Information that identifies the person</a></label>
        <span id='mask_identifier'></span>
      </div>
    </div>
  </div>
  <div class='footer' align="right" style='margin-top:5px'>
    <button style="width:50px" id='btnChangeType' accesskey="o" class="bottoni">Ok</button>
    <button style="width:50px" id='closeMaskType' accesskey="o" class="bottoni2" onclick='javascript:toggleMaskType()'>Close</button>
  </div>
</div>

 <!-- div per il confronto delle query  -->
<div style="display:none; top:70px; left:300px;" class="contenuto" id="maskQueryCompare">
  <div class='titoli' onMouseDown="dragToolbar(event,'maskQueryCompare',4);" id='maskQueryCompareTitle' style="cursor:move; font-weight:bold; margin-bottom:5px; padding-right:20px" >
    Compare queries
 </div>
  <table>
  <tr>
    <td align='right' style='padding-left:5px'> Query name:</td>
    <td>
      <input id="queryToCompare" class="textbox" type="text" name="queryToCompare" size="30" />
      <span id='searchQueryToCompare' onclick='GetFilename("queryToCompare")' tabindex="-1" icon-data='&#xe605;'></span>
      <span id='editQueryToCompare' onclick='openQuery(-1,Ctrl("queryToCompare").value)' tabindex="-1" icon-data='&#xe603;'></span>
    </td>
  </tr>
  </table>
  <div class='footer' align="right"  style='margin-top:5px'>
    <button style="margin-right:5px;" id='compareQuery' accesskey="o" class="bottoni" onclick='compareQuery()'>Compare</button>
    <button style="margin-right:5px;" accesskey="o" class="bottoni2" onclick='toggleMaskCompareQuery()'>Close</button>
  </div>
</div>

<%
  if("yes".equals(sp.getGlobal("IsQueryTestInstalled",""))){
%>

 <!-- div per la creazione di un test di configurazione  -->
<div style="height:120px;position:absolute;top:80px; left:990px; visibility:hidden;z-index:1000; overflow:hidden" class="contenuto" id="maskTestConf">
  <a class="deleteIcon" style="position:absolute;right:4px;top:4px;" title="Close" href="javascript:void(0)" onclick="javascript:toggleTestConfiguration()"><img src="images/del.png" border='0'></a>
  <div class='titoli' id='maskTestConfTitle' style="cursor:move; text-align:center; margin-bottom:5px; padding-right:20px" onMouseDown="dragToolbar(event,'maskTestConf',4);">
 Create configuration test
 </div>
  <table>
  <tr>
    <td align='right' style='padding-left:5px'> File name:</td>
    <td>
      <input id="configurationFileName" class="textbox" type="text" name="configurationFileName" size="30" />
      <button style="width:14px" id='searchTestConfigFile' class="bottoni" onclick="SelectConfigurationFileName()">?</button>
    </td>
  </tr>
  <tr id='saveParametersTr'>
    <td colspan='2'>
      <input id="saveParameters" class="checkbox" type="checkbox" name="saveParameters" />
      Save parameters
    </td>
  </tr>

  </table>
  <div class='footer' align="right"  style='margin-top:5px'>
    <button style="width:137px; visibility:hidden" id='modifyParValue' accesskey="m" class="bottoni">Modify Parameters Value</button>
    <button style="width:50px" id='saveTestConf' accesskey="o" class="bottoni">Save</button>
  </div>
</div>

<%
}
%>


 <!-- div per la scelta della query in union da aprire  -->
<div style="height:auto;position:absolute;visibility:hidden;z-index:1000; max-width:600px;" class="contenuto" id="unionQueryDiv">
  <div class='titoli textClipped' id='unionQueryTitle' style="cursor:move; text-align:center; margin-bottom:5px; padding-right:20px; padding-top:2px;padding-right:2px" onMouseDown="dragToolbar(event,'unionQueryDiv',4);">
  Select Query
 </div>
  <table cellpadding='0' id='unionQueryTable'>

  </table>
  <div class='footer' align="right" style='margin-top:5px'>
    <button style="width:50px" id='btnOpenUnionQuery' accesskey="o" class="bottoni" onclick='javascript:openUnionQuery()'>Open</button>
    <button style="width:50px" id='btnCloseUnionQuery' accesskey="o" class="bottoni2" onclick='javascript:toggleMaskUnion()'>Close</button>
  </div>
</div>

<!-- QUERY =====================================================================================================-->
 <div id="queryPanel" style="width:98%;position:relative;">
  <table width="100%" cellspacing="0" border="0">
   <tr style="height:30px">
    <td colspan="3" align="center" class="titoli" style='border-right:1px solid #fff; border-left:1px solid #fff;'>
      <div>Query</div>
    </td>
   </tr>
   <tr>
    <td style="padding-top:0;">
     <div id="tabPanel" style="padding:0;margin:0;" class="tab-pane">
      <ul id='tabList' class="label">
        <li helpProp="tables">Tables</li><li helpProp="fields">Fields, Group By and Order By, Pivot</li><li helpProp="calculatedfields">Calculated fields</li><li helpProp="fields_join">Join</li><li helpProp="filters">Filter</li><li helpProp="filtersparms">Filter Parameters</li><li id="access_tab" helpProp="access">Access</li><li id="note_tab" helpProp="note">Note</li>
      </ul>
      <span class='help_btn' onclick='HelpQuery()'></span>
      <div id="tabContents">
      <div id="TablesTab" style="padding:0;margin:0;height:253px;" class="tab-page tabContainer">
        <div>
          <div class='DivTableTitle DivTitle'>
            <span style='display:inline-block;width:32%; margin-left:20px;'>Description</span><span id="" style='display:inline-block;width:30%;'>Alias</span><span style='display:inline-block;width:20%;' >Table Name</span><span style='display:inline-block;width:14%;' >Temp Table</span>
          </div>
        <ul class="tableBackgroundDiv ulContainer" id="tables_ul">
        </ul>
        </div>
        <label id="union_label" for="union_file" class="label" style="margin-left:60px;">Union:</label>
        <input type="text" id="union_file" size="40"  onBlur="m_bUpdated=true;SetEditUnionVQR();">
        <span id="search_union_file" onClick="GetFilename('union')" tabindex="-1" icon-data='&#xe605;'></span>
        <span id="union_file_open" onClick="EditQuery();" style="display:none" icon-data='&#xe603;'></span>
        <input type="checkbox" id="chk_union_all" onChange="m_bUpdated=true;" style='margin-left:25px'>
        <label id="chk_union_all_label" for="chk_union_all" class="label" >All</label>
        <input type="checkbox" id="chk_multi_company" onChange="m_bUpdated=true;" style='margin-left:25px'>
        <label id="chk_multi_company_label" for="chk_multi_company" class="label" >Multi&nbsp;Company</label>
        <label id="default_companyList_label" for="default_companyList" class="label" style="margin-left:10px;">Default on empty company:</label>
        <input type="text" id='default_companyList' onBlur="m_bUpdated=true;">
        <input id="customQry" type="checkbox" name="customQry" onChange="changeCustom()" style='margin-left:20px'>
        <label id="customQry_label" for="customQry" class="label">Custom query</label>
        <input id="correspondingQry" type="button" value="Open default query" class="bottoni" onClick="OpenCorrespondingQry()" style='visibility:hidden'>
      </div>
      <div id="FieldsTab" style="padding:0;margin:0;height:253px;" class="tab-page tabContainer">
        <div id='FieldsContainer' style='min-width:640px;position:absolute;'> <!--da allargare-->
          <div>
            <div  class='DivTableTitle DivTitle'>
              <span style='position:absolute;left:0px;width:185px; margin-left:20px;'>Description</span><span id="fields_table_Name">Name</span><span style='position:absolute;right:181px;' >Alias</span><span style='position:absolute;right:63px;' >Type</span>
            </div>
            <ul class="tableBackgroundDiv ulContainer" id="fields_ul">
            </ul>
          </div>
          <input type="button" value="Add Blank Field" onClick="AddBlankField()" style="float:right;" class="bottoni">
        </div>
        <div id='tabPanelGroupPivot' class='tab-pane'>
          <ul id='tabListGroupPivot' class="label">
            <li>Group By and Order By</li><li>Pivot</li>
          </ul>
          <div id='tabContentsGroupPivot'>
            <div class='tab-page2'>
              <div class='middleContainerTitle'>
                <div class='DivTableTitle DivTitle' style='width:393px;'>
                  <span style='display:inline-block;position:relative;left:10px;float:left;' class=''>OrderBy Description</span>
                  <span id="" style='display:inline-block;position:relative; margin-left:20px;' class=''>Name</span>
                </div>
                <ul class="tableBackgroundDiv ulMiddleContainer" id="orderby_ul" style='border:none;border-top:1px solid #b0b0b0;'>
                </ul>
              </div>
              <div class='middleContainerTitle'>
                <div  class='DivTableTitle DivTitle' style='width:393px;'>
                  <span style='display:inline-block;position:relative;float:left;left:10px;' class=''>GroupBy Description</span>
                  <span id="" style='display:inline-block;position:relative; margin-left:20px;' class=''>Name</span>
                </div>
                <ul class="tableBackgroundDiv ulMiddleContainer" id="groupby_ul" style='border:none;border-top:1px solid #b0b0b0;'>
                </ul>
              </div>
              <input type="checkbox" id="chk_distinct" onChange="m_bUpdated=true;" >
              <label for="chk_distinct" class="label" style="">Distinct</label>
            </div>
            <div class='tab-page2'>
              <div style='width:288px; border-bottom:none;' class='middleContainerTitle'>
                <div  class='DivTableTitle DivTitle' style='width:282px;'>
                  <span style='display:inline-block;position:relative;left:10px;float:left;' class=''>Pivot Field</span>
                  <span style='display:inline-block;position:relative; margin-left:82px;' class=''>Name</span>
                </div>
                <ul class="tableBackgroundDiv ulMiddleContainer" id="pivotFields_ul" style='border:none;border-top:1px solid #b0b0b0;'>
                </ul>
              </div>
            <div style='position:absolute;right:0;top:0'>
              <label for="pivotType" class="label" >Type pivot</label><br/>
              <select id="pivotType" onChange="m_bUpdated=true;" style='width:105px;'>
                <option value='1'> Value</option>
                <option value='2'> Index</option>
                <option value='3'> 12 Hour/Month</option>
                <option value='4'> 31 Day</option>
                <option value='8'> 7 Day of week</option>
                <option value='9'> 24 Hours</option>
                <option value='5'> List value</option>
                <option value='6'> List index</option>
                <option value='7'> List from 1 to ...</option>
              </select>
              </div>
              <div class='middleContainerTitle' style='border-top: 1px solid #b0b0b0;'>
                <div  class='DivTableTitle DivTitle' style='width:393px;'>
                  <span style='display:inline-block;position:relative;float:left;left:10px;' class=''>Data field</span>
                  <span id="" style='display:inline-block;position:relative; margin-left:89px;' class=''>Name</span>
                </div>
                <ul class="tableBackgroundDiv ulMiddleContainer" id="pivotData_ul" style='border:none;border-top:1px solid #b0b0b0;'>
                </ul>
              </div>
              <label for='listQuery' class='label' style='margin-left:9px;' >List/Query</label>
              <input type='text' id='listQuery' onChange='m_bUpdated=true;' style='width:300px;' title="Bracket list of values, comma separated &#13es: (1,2,3) &#13es: ('a','b','c') &#13or query name &#13es: nome_della_query &#13or last sequence number &#13es: 52"/>
              <span id='search_pivot_query' onClick='AddListQuery()' icon-data='&#xe605;'></span>
            </div>
            </div>
          </div>
      </div>
      <div class="tab-page tabContainer" id="CalculatedFieldsTab" style="padding:0;margin:0;">
        <div>
          <div class='DivTableTitle DivTitle'>
            <span style='width:150px;display:inline-block; left:24px; position:absolute;'>Description</span><span id="" style='display:inline-block;left:160px;position:absolute;margin-left:24px;'>Expression</span><div style='text-align:left; width:230px; float:right;'>
              <span style='text-align:left;' >Alias</span><span style='position:relative;left:143px; text-align:left;' >Type</span>
            </div>
          </div>
        <ul id="calculatedFields_ul" class="tableBackgroundDiv ulContainer">
        </ul>
        </div>
        <input type="button" value="Add Blank Calculated Fields" onClick="AddBlankCalculatedField()" style="float:right;" class="bottoni">
      </div>
      <div class="tab-page tabContainer" id="JoinTab" style="padding:0;margin:0;">
        <div>
          <div class='DivTableTitle DivTitle'>
            <span style='width:25%;display:inline-block; left:24px; min-width:232px;position:absolute;'>Description</span><span id="" style='display:inline-block;left:25%;min-width:385px;position:absolute;right:50%; margin-left:24px;'>Expression</span><div style='text-align:left; width:291px; float:right;'>
              <span style='text-align:left;' >Type</span><span style='position:relative;left:51px; text-align:left;' >Table 1</span><span style='position:relative;left:96px; text-align:left;' >Table 2</span>
            </div>
          </div>
        <ul id="joins_ul" class="tableBackgroundDiv ulContainer">
        </ul>
        </div>
        <input type="button" value="Add Blank Join" onClick="AddBlankJoin()" style="float:right;" class="bottoni">
      </div>
      <div class="tab-page tabContainer" id="FilterTab" style="padding:0;margin:0;">
        <div>
          <div class='DivTableTitle DivTitle' style='text-align:left;'>
            <span style='width:25%;display:inline-block;left:20px;position:relative;'>Field Name</span>
            <span id="" style='display:inline-block;width:38px;left:46px;position:relative;'>Not</span>
            <span style='display:inline-block;width:90px;left:40px;position:relative;width:50px;' >Criteria</span>
            <span style='display:inline-block;left:83px;position:relative;' id='filter_table_Samp'>Example</span>
            <div style='display:inline-block; float:right; width:400px;'>
              <span style='display:inline-block;width:280px;'>Use filter when</span>
              <span style='display:inline-block;width:50px;' >Logical</span>
            </div>
          </div>
          <ul id="filters_ul" class="tableBackgroundDiv ulContainer">
          </ul>
        </div>
        <input type="button" value="Add Blank Filter" onClick="AddBlankFilter()" style="float:right;" class="bottoni">
      </div>
      <div class="tab-page tabContainer" id="FilterParamTab" style="padding:0;margin:0;">
         <div>
           <div class='DivTableTitle DivTitle'>
            <span style='width:20%;display:inline-block; left:20px; min-width:220px;position:relative;'>Field Name</span>
            <span style='display:inline-block;min-width:245px;position:relative;margin-left:21px;width:20%;'>Description</span>
            <span style='text-align:left;' >Type</span>
            <div style='position:absolute;display:inline-block;left:max(calc(40% + 65px), 535px);right:80px;'>
              <span style='text-align:left; width:50%;min-width:200px;display:inline-block;'>Check Expression</span>
              <span style='text-align:left;'>Default on Empty</span>
            </div>
            <div style='display:inline-block; position:absolute; right:0; text-align:left; width:52px;'>

              <span style='position:relative;text-align:left;' title='Remove on empty parameter'>RoE</span>
            </div>

          </div>
          <ul id="parameters_ul" class="tableBackgroundDiv ulContainer">
          </ul>
        </div>
        <div style='float:right;'>
        <input type="checkbox" id="chk_use_orderby" Checked="checked" onChange="m_bUpdated=true;">
        <label for="chk_use_orderby" class="label" style='margin-right:30px;'>Use OrderBy parameter</label>
        <input type="checkbox" id="chk_remove_filter" onChange="m_bUpdated=true;">
        <label for="chk_remove_filter" class="label" style='margin-right:30px;'>Remove filter on empty parameter</label>
        <input type="button" value="Add Blank Parameter" onClick="AddBlankParameter()" class="bottoni">
        </div>
      </div>
      <div class="tab-page" id="AccessTab" style="padding:0;margin:0;">
        <div class="access">
          <ul>
            <li style="float:right;">
              <fieldset>
                <legend class="label"accesskey=R >Remote&nbsp;</legend>
                <table>
                  <tr>
                    <td class="col_1">
                      <label id="lbl_remoteServer" for="remote_server" class="label">Server:</label>
                    </td><td class="col_2">
                      <table cellpadding=0 cellspacing=0><tr><td class="col_2">
                        <input type="text" id="remote_server"  onblur="m_bUpdated=true;" onchange="RemoteServer_change();">
                      </td><td>
                        <label for="remote_mode" class="label" style='padding-left:5px;'>&nbsp;Mode:&nbsp;</label>
                      </td><td>
                        <select type="text" id="remote_mode" onblur="m_bUpdated=true;"  onchange="SelectRemoteMode_change();">
                          <option value="native" selected >Native</option>
                          <option value="soap">SOAP</option>
                        </select>
                      <!--/td><td nowrap>
                        <a href="javascript:RefreshRemoteParameters();">
                          <img src="images/refresh.png" alt="Refresh remote parameters definition" border=0 style="margin-left:5px;">
                        </a-->
                      </td></tr></table>
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      <label for="remote_user" class="label">User:</label>
                    </td><td class="col_2">
                      <input type="text" id="remote_user"  onblur="m_bUpdated=true;SetRemoteUser(this.value);">
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      <label for="remote_password" class="label">Password:</label>
                    </td><td class="col_2">
                      <input type="password" id="remote_password"  onblur="m_bUpdated=true;SetRemotePassword(this.value);" onkeydown="">
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      <label for="remote_company" class="label">Company:</label>
                    </td><td class="col_2">
                      <input type="text" id="remote_company"  onblur="m_bUpdated=true;">
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      <label for="remote_instance" class="label">Instance:</label>
                    </td><td class="col_2">
                      <input type="text" id="remote_instance"  onblur="m_bUpdated=true;">
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      <label for="remote_vqr_name" class="label">Vqr:</label>
                    </td><td class="col_2">
                      <table cellpadding=0 cellspacing=0><tr><td class="col_2">
                        <input type="text" id="remote_vqr_name"  onblur="m_bUpdated=true;">
                      </td><td>
                        <input type="button" id="import_remote_vqr" class="bottoni" value="..." title="Select vqr" onclick="GetFilename('import');" style="margin-left:4px;height:20px;width:18px">
                      </td></tr></table>
                    </td>
                  </tr>
                </table>
              </fieldset>
            </li><li>
              <fieldset>
                <legend class="label"accesskey=S >Security&nbsp;</legend>
                <table>
                  <tr>
                    <td class="col_1">
                      <label for="security_roles" class="label">Security&nbsp;roles:</label>
                    </td><td class="col_2">
                      <input type="text" id="security_roles" sty_le="width:100%"  onBlur="m_bUpdated=true;">
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      <label for="security_key" class="label">Security&nbsp;key(s):</label>
                    </td><td class="col_2">
                      <input type="text" id="security_key" st_yle="width:100%"  onBlur="BOSecurity_Modified();m_bUpdated=true;" title='Use security definition of another object'>
                    </td>
                  </tr><tr>
                    <td class="col_1">
                      &nbsp;
                    </td><td class="col_2">
                      <input type="checkbox" id="chk_public" class="checkbox" onChange="m_bUpdated=true;" onClick="Public_Modified()">
                      <label for="chk_public" class="label" style='margin-right:18px;'>Public</label>
                      <input type="checkbox" id="chk_batch" class="checkbox" onChange="m_bUpdated=true;">
                      <label for="chk_batch" class="label">Routine</label>
                    </td>
                  </tr>
                </table>
              </fieldset>
            </li><li>
              <fieldset>
                <legend class="label"accesskey=C >Cache&nbsp;</legend>
                <label for="chk_cache" class="label" style="vertical-align:middle">&nbsp;Mode:</label>
                <select id="chk_cache" name="chk_cache" onchange="m_bUpdated=true;Cache_Modified();">
                  <option value="0">none</option>
                  <option value="1">all</option>
                  <option value="2">without parms</option>
                </select>
                <label for="cache_duration" class="label" style="vertical-align:middle">for</label>
                <input type="text" id="cache_duration"  disabled style="width:30px" onBlur="m_bUpdated=true;">
                <label for="cache_duration" class="label" style="vertical-align:middle">seconds</label>
              </fieldset>
            </li>
            <li>
              <fieldset>
                <legend class="label" accesskey=D >Data sensibility&nbsp;</legend>
                <label for="privacy" class="label" style="vertical-align:middle">&nbsp;Data sensibility:</label>
                <select id="privacy" name="privacy" onchange="SetUpdated();">
                  <option value="0">-</option>
                  <option value="1">Ruled-Health</option>
                  <option value="2">Ruled-Sensible</option>
                  <option value="3">Ruled-Judicial</option>
                  <option value="4">Ruled-Personal</option>
                  <option value="5">Ruled-Specific Risk</option>
                  <option value="6">Private</option>
                  <option value="7">Public</option>
                </select>
              </fieldset>
            </li>
          </ul>
        </div>
			</div>
      <div class="tab-page tabContainer" id="NoteTab" style="padding:0;margin:0;">
        <table width="100%" height="100%" cellspacing="0" cellpadding='0' class='internobianco'>
					<tr>
            <td valign="top" style='padding:0;margin:0;'>
              <div class='tableBackgroundDiv' style="width:100%;height:100%;margin:0;padding:0;border:none;">
                <textarea id="notes" style="width:100%;margin:0;box-sizing:border-box;height:100%;border:none; background:#f3f3f3;" onBlur="m_bUpdated=true;"></textarea>
              </div>
            </td>
					</tr>
				</table>
			</div>
		 </div>
     </div>
    </td>
	 </tr>
	</table>
 </div>

 <!-- preview -->
 <div id='preview_wrapper' class='preview_wrapper'>
 <span id="closePreviewBtn" onClick="closePreview()" title='Close preview'></span>
 <div id='iframe_wrapper'>

 <iframe id='preview' class='preview' frameborder='0'>
 </iframe>
 </div>
 </div>
</body>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
