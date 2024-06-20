<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%
Sitepainter sp=new Sitepainter(request);
if (sp.CanAccessEditor("PortalStudio") || sp.isLogged()) {
  sp.setContentType(response);
  if (sp.CanAccessEditor("PortalStudio")) { // imposto lingua inglese coerente con PS
    sp.beginMutationSection();
    sp.setLanguage("ENG");
  }
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>SmartReport Editor - SitePainter Infinity PortalStudio</title>
  <script>
    var mversion = "1.0";
    var modelight = <%=sp.getParameter("modelight",false)%>;
    var openas = '<%=JSPLib.ToJSValue(sp.getParameter("openas",""))%>';
    var defaultEncoding = '<%= com.zucchetti.sitepainter.Library.m_cResponseEncoding %>';
    var cmdhash = '<%=JSPLib.cmdHash("SmartReport", request.getSession())%>';
  </script>

  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("SPReportMask.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/history.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/PortalCommonJS.js")%>'></script>
  <script>
    // inserisco le traduzioni prima di includere itemsObj per esigenze doc api
    var spTranslatedText = [];
    spTranslatedText["SMR_TEXT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TEXT"))%>';
    spTranslatedText["NEW_REPORT"] = '<%=JSPLib.ToJSValue(sp.translate("NEW_REPORT"))%>';
    spTranslatedText["SMR_DATASOURCE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCE"))%>';
    spTranslatedText["SMR_VDMMASK"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_VDMMASK"))%>';
    spTranslatedText["SMR_NEWDATAFIELD"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NEWDATAFIELD"))%>';
    spTranslatedText["SMR_STYLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_STYLE"))%>';
    spTranslatedText["SMR_ALIGNMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ALIGNMENT"))%>';
    spTranslatedText["SMR_IMAGESRC"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_IMAGESRC"))%>';
    spTranslatedText["SMR_LINESTYLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_LINESTYLE"))%>';
    spTranslatedText["SMR_HEIGHT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HEIGHT"))%>';
    spTranslatedText["SMR_REQUIREMENTS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REQUIREMENTS"))%>';
    spTranslatedText["SMR_TITLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TITLE"))%>';
    spTranslatedText["SMR_SEQUENCE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SEQUENCE"))%>';
    spTranslatedText["SMR_DATEFORMAT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATEFORMAT"))%>';
    spTranslatedText["SMR_TICKSTYLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TICKSTYLE"))%>';
    spTranslatedText["SMR_DASHSTYLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DASHSTYLE"))%>';
    spTranslatedText["SMR_BARCODEOPTIONS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BARCODEOPTIONS"))%>';
    spTranslatedText["SMR_QRCODECORRECTION"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_QRCODECORRECTION"))%>';
    spTranslatedText["SMR_REPORTCOMMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTCOMMENT"))%>';
    spTranslatedText["SMR_EDITTEXTCONTENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_EDITTEXTCONTENT"))%>';
    spTranslatedText["SMR_INSERTCOMMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_INSERTCOMMENT"))%>';
    spTranslatedText["SMR_FORMAT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FORMAT"))%>';
    spTranslatedText["SMR_HEIGHTMM"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HEIGHTMM"))%>';
    spTranslatedText["SMR_WIDTHMM"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_WIDTHMM"))%>';
    spTranslatedText["SMR_ORIENTATION"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ORIENTATION"))%>';
    spTranslatedText["SMR_RPTCUSTOM"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_RPTCUSTOM"))%>';
    spTranslatedText["SMR_SELECTDATASOURCE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SELECTDATASOURCE"))%>';
    spTranslatedText["SMR_DATASOURCENAME"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCENAME"))%>';
    spTranslatedText["SMR_REPORTTITLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTTITLE"))%>';
    spTranslatedText["SMR_REPORTLAYOUT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTLAYOUT"))%>';
    spTranslatedText["SMR_REPORTMODELLIST"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTMODELLIST"))%>';
    spTranslatedText["SMR_REPORTMODELTABLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTMODELTABLE"))%>';
    spTranslatedText["SMR_BREAKGROUPFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BREAKGROUPFIELDS"))%>';
    spTranslatedText["SMR_HEADERGROUPFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HEADERGROUPFIELDS"))%>';
    spTranslatedText["SMR_FOOTERGROUPFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FOOTERGROUPFIELDS"))%>';
    spTranslatedText["SMR_SELECTREPORTFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SELECTREPORTFIELDS"))%>';
    spTranslatedText["SMR_PAGESETTINGS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGESETTINGS"))%>';
    spTranslatedText["SMR_PAPER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAPER"))%>';
    spTranslatedText["SMR_PAGEMARGINS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGEMARGINS"))%>';
    spTranslatedText["SMR_PROPERTIES"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PROPERTIES"))%>';
    spTranslatedText["SMR_FILTERS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FILTERS"))%>';
    spTranslatedText["SMR_PAGEOPTIONS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGEOPTIONS"))%>';
    spTranslatedText["SMR_EDIT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_EDIT"))%>';
    spTranslatedText["SMR_DELETE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DELETE"))%>';
    spTranslatedText["SMR_SECTIONS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SECTIONS"))%>';
    spTranslatedText["SMR_SECTIONFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SECTIONFIELDS"))%>';
    spTranslatedText["SMR_DOWNLOADPDF"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOWNLOADPDF"))%>';
    spTranslatedText["SMR_RULERS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_RULERS"))%>';
    spTranslatedText["SMR_GRID"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GRID"))%>';
    spTranslatedText["SMR_DATASOURCEANDFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCEANDFIELDS"))%>';
    spTranslatedText["SMR_GENERICELEMENTS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GENERICELEMENTS"))%>';
    spTranslatedText["SMR_LABEL"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_LABEL"))%>';
    spTranslatedText["SMR_HORIZONTALLINE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HORIZONTALLINE"))%>';
    spTranslatedText["SMR_IMAGE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_IMAGE"))%>';
    spTranslatedText["SMR_CURRENTDATETIME"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CURRENTDATETIME"))%>';
    spTranslatedText["SMR_PAGENUMERATION"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGENUMERATION"))%>';
    spTranslatedText["SMR_CONTINUE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONTINUE"))%>';
    spTranslatedText["SMR_SIGNATUREMARKUP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SIGNATUREMARKUP"))%>';
    spTranslatedText["SMR_NOTUSED"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NOTUSED"))%>';
    spTranslatedText["SMR_USED"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_USED"))%>';
    spTranslatedText["SMR_PAGENUMBER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGENUMBER"))%>';
    spTranslatedText["SMR_TOTALPAGES"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TOTALPAGES"))%>';
    spTranslatedText["SMR_MILLIMETERS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MILLIMETERS"))%>';
    spTranslatedText["SMR_CENTIMETERS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CENTIMETERS"))%>';
    spTranslatedText["SMR_POINTS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_POINTS"))%>';
    spTranslatedText["SMR_DOCUMENTVIEW"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOCUMENTVIEW"))%>';
    spTranslatedText["SMR_DOCUMENTDESIGN"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOCUMENTDESIGN"))%>';
    spTranslatedText["SMR_DOCUMENTPDFVIEW"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOCUMENTPDFVIEW"))%>';
    spTranslatedText["SMR_OTHERSDOWNLOAD"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_OTHERSDOWNLOAD"))%>';
    spTranslatedText["SMR_CSVDOCUMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CSVDOCUMENT"))%>';
    spTranslatedText["SMR_STANDARDCSVDOCUMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_STANDARDCSVDOCUMENT"))%>';
    spTranslatedText["SMR_SDFDOCUMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SDFDOCUMENT"))%>';
    spTranslatedText["SMR_XMLDOCUMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_XMLDOCUMENT"))%>';
    spTranslatedText["SMR_STRUCTUREDXMLDOCUMENT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_STRUCTUREDXMLDOCUMENT"))%>';
    spTranslatedText["SMR_SNAPTOGRID"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SNAPTOGRID"))%>';
    spTranslatedText["SMR_NEWDATAFIELD"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NEWDATAFIELD"))%>';
    spTranslatedText["SMR_PAGENUMERATIONTYPE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGENUMERATIONTYPE"))%>';
    spTranslatedText["SMR_DATETIMEFORMAT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATETIMEFORMAT"))%>';
    spTranslatedText["SMR_CALCULATION"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CALCULATION"))%>';
    spTranslatedText["SMR_FIELDVIEWTYPE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FIELDVIEWTYPE"))%>';
    spTranslatedText["SMR_NONE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NONE"))%>';
    spTranslatedText["SMR_SUM"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SUM"))%>';
    spTranslatedText["SMR_OBLIGATORY"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_OBLIGATORY"))%>';
    spTranslatedText["SMR_GEOPOSITION"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GEOPOSITION"))%>';
    spTranslatedText["SMR_HIDEEXTRADATA"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HIDEEXTRADATA"))%>';
    spTranslatedText["SMR_BYGROUP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BYGROUP"))%>';
    spTranslatedText["SMR_PRINTAFTERPAGEHEADER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PRINTAFTERPAGEHEADER"))%>';
    spTranslatedText["SMR_STARTONNEWPAGE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_STARTONNEWPAGE"))%>';
    spTranslatedText["SMR_REPRINTONEACHPAGE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPRINTONEACHPAGE"))%>';
    spTranslatedText["SMR_PRINTATENDOFPAGE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PRINTATENDOFPAGE"))%>';
    spTranslatedText["SMR_PRINTFIELDSONGROUPBREAK"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PRINTFIELDSONGROUPBREAK"))%>';
    spTranslatedText["SMR_PRINTBEFOREPAGEFOOTER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PRINTBEFOREPAGEFOOTER"))%>';
    spTranslatedText["SMR_REPORTSECTIONS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTSECTIONS"))%>';
    spTranslatedText["SMR_PAGESECTIONS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGESECTIONS"))%>';
    spTranslatedText["SMR_GROUPSECTIONS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GROUPSECTIONS"))%>';
    spTranslatedText["SMR_GROUPING"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GROUPING"))%>';
    spTranslatedText["SMR_DATASOURCESFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCESFIELDS"))%>';
    spTranslatedText["SMR_GROUPHEADER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GROUPHEADER"))%>';
    spTranslatedText["SMR_ONEBANDBYGROUPING"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ONEBANDBYGROUPING"))%>';
    spTranslatedText["SMR_DETAIL"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DETAIL"))%>';
    spTranslatedText["SMR_ONEBANDBYDATASOURCESROW"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ONEBANDBYDATASOURCESROW"))%>';
    spTranslatedText["SMR_GROUPFOOTER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GROUPFOOTER"))%>';
    spTranslatedText["SMR_REPORTHEADER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTHEADER"))%>';
    spTranslatedText["SMR_REPORTFOOTER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTFOOTER"))%>';
    spTranslatedText["SMR_ONEBANDBYREPORT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ONEBANDBYREPORT"))%>';
    spTranslatedText["SMR_PAGEHEADER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGEHEADER"))%>';
    spTranslatedText["SMR_ONEBANDBYPAGE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ONEBANDBYPAGE"))%>';
    spTranslatedText["SMR_PAGEFOOTER"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGEFOOTER"))%>';
    spTranslatedText["SMR_PORTRAIT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PORTRAIT"))%>';
    spTranslatedText["SMR_LANDSCAPE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_LANDSCAPE"))%>';
    spTranslatedText["SMR_BARCODE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BARCODE"))%>';
    spTranslatedText["SMR_CUSTOM"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CUSTOM"))%>';
    spTranslatedText["SMR_AUTOMATIC"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_AUTOMATIC"))%>';
    spTranslatedText["SMR_MINIMUM"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MINIMUM"))%>';
    spTranslatedText["SMR_SELECTALL"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SELECTALL"))%>';
    spTranslatedText["SMR_TITLEANDMODEL"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TITLEANDMODEL"))%>';
    spTranslatedText["SMR_REPORTFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPORTFIELDS"))%>';
    spTranslatedText["SMR_GROUPINGFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GROUPINGFIELDS"))%>';
    spTranslatedText["SMR_HEADERFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HEADERFIELDS"))%>';
    spTranslatedText["SMR_FOOTERFIELDS"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FOOTERFIELDS"))%>';
    spTranslatedText["SMR_CONFIRMSAVE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONFIRMSAVE"))%>';
    spTranslatedText["SMR_CONFIRMREMOVE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONFIRMREMOVE"))%>';
    spTranslatedText["SMR_CONFIRMDELETE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONFIRMDELETE"))%>';
    spTranslatedText["SMR_CONFIRMREMWHOLE"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONFIRMREMWHOLE"))%>';
    spTranslatedText["SMR_CONFIRMCOLUMN"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONFIRMCOLUMN"))%>';
    spTranslatedText["SMR_CONFIRMROW"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CONFIRMROW"))%>';
    spTranslatedText["SMR_APPLY"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_APPLY"))%>';
    spTranslatedText["SMR_APPLYALL"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_APPLYALL"))%>';
    spTranslatedText["SMR_OK"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_OK"))%>';
    spTranslatedText["SMR_CANCEL"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CANCEL"))%>';
    spTranslatedText["SMR_NOTALLOWED"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NOTALLOWED"))%>';
    spTranslatedText["SMR_ADDTOBREAKGROUP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ADDTOBREAKGROUP"))%>';
    spTranslatedText["SMR_ADDTOSECTION"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ADDTOSECTION"))%>';
    spTranslatedText["SMR_STRETCHTORIGHT"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_STRETCHTORIGHT"))%>';

    //TOOLTIP
    spTranslatedText["SMR_DATASOURCEREFRESH_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCEREFRESH_TOOLTIP"))%>';
    spTranslatedText["SMR_DATASOURCEBOSELECT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCEBOSELECT_TOOLTIP"))%>';
    spTranslatedText["SMR_DATASOURCENEW_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCENEW_TOOLTIP"))%>';
    spTranslatedText["SMR_DATASOURCEEDIT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCEEDIT_TOOLTIP"))%>';
    spTranslatedText["SMR_DATASOURCESELECT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCESELECT_TOOLTIP"))%>';
    spTranslatedText["SMR_VDMSELECT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_VDMSELECT_TOOLTIP"))%>';
    spTranslatedText["SMR_VDMNEW_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_VDMNEW_TOOLTIP"))%>';
    spTranslatedText["SMR_VDMEDIT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_VDMEDIT_TOOLTIP"))%>';
    spTranslatedText["SMR_DATASOURCE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATASOURCE_TOOLTIP"))%>';
    spTranslatedText["SMR_VDMFILE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_VDMFILE_TOOLTIP"))%>';
    spTranslatedText["SMR_PFORMAT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PFORMAT_TOOLTIP"))%>';
    spTranslatedText["SMR_PHEIGHT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PHEIGHT_TOOLTIP"))%>';
    spTranslatedText["SMR_PWIDTH_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PWIDTH_TOOLTIP"))%>';
    spTranslatedText["SMR_PORIENTATION_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PORIENTATION_TOOLTIP"))%>';
    spTranslatedText["SMR_MTHEIGHT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MTHEIGHT_TOOLTIP"))%>';
    spTranslatedText["SMR_MBHEIGHT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MBHEIGHT_TOOLTIP"))%>';
    spTranslatedText["SMR_MLWIDTH_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MLWIDTH_TOOLTIP"))%>';
    spTranslatedText["SMR_MRWIDTH_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MRWIDTH_TOOLTIP"))%>';
    spTranslatedText["SMR_SHOWREPORTZONE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SHOWREPORTZONE_TOOLTIP"))%>';
    spTranslatedText["SMR_SHOWPAGEZONE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SHOWPAGEZONE_TOOLTIP"))%>';
    spTranslatedText["SMR_SHOWGROUPZONE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SHOWGROUPZONE_TOOLTIP"))%>';
    spTranslatedText["SMR_AFTERPAGEHEADER_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_AFTERPAGEHEADER_TOOLTIP"))%>';
    spTranslatedText["SMR_STARTNEWPAGE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_STARTNEWPAGE_TOOLTIP"))%>';
    spTranslatedText["SMR_HREPRINTONPAGE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_HREPRINTONPAGE_TOOLTIP"))%>';
    spTranslatedText["SMR_FREPRINTONPAGE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FREPRINTONPAGE_TOOLTIP"))%>';
    spTranslatedText["SMR_ATENDOFPAGE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_ATENDOFPAGE_TOOLTIP"))%>';
    spTranslatedText["SMR_PRINTONGROUPBREAK_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PRINTONGROUPBREAK_TOOLTIP"))%>';
    spTranslatedText["SMR_BEFOREPAGEFOOTER_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BEFOREPAGEFOOTER_TOOLTIP"))%>';
    spTranslatedText["SMR_SHOWRULERS_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SHOWRULERS_TOOLTIP"))%>';
    spTranslatedText["SMR_MEASUREUNIT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MEASUREUNIT_TOOLTIP"))%>';
    spTranslatedText["SMR_SHOWGRID_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SHOWGRID_TOOLTIP"))%>';
    spTranslatedText["SMR_SNAPGRID_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SNAPGRID_TOOLTIP"))%>';
    spTranslatedText["SMR_TICK50_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TICK50_TOOLTIP"))%>';
    spTranslatedText["SMR_TICK100_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TICK100_TOOLTIP"))%>';
    spTranslatedText["SMR_GTYPESMALL_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GTYPESMALL_TOOLTIP"))%>';
    spTranslatedText["SMR_GTYPELONG_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GTYPELONG_TOOLTIP"))%>';
    spTranslatedText["SMR_GTYPEPLAIN_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GTYPEPLAIN_TOOLTIP"))%>';
    spTranslatedText["SMR_SAVEAS_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SAVEAS_TOOLTIP"))%>';
    spTranslatedText["SMR_SAVE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SAVE_TOOLTIP"))%>';
    spTranslatedText["SMR_OPEN_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_OPEN_TOOLTIP"))%>';
    spTranslatedText["SMR_NEW_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NEW_TOOLTIP"))%>';
    spTranslatedText["SMR_WIZARD_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_WIZARD_TOOLTIP"))%>';
    spTranslatedText["SMR_DETAILS_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DETAILS_TOOLTIP"))%>';
    spTranslatedText["SMR_REPCUSTOM_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPCUSTOM_TOOLTIP"))%>';
    spTranslatedText["SMR_REPCOMMENT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REPCOMMENT_TOOLTIP"))%>';
    spTranslatedText["SMR_GPARAM_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_GPARAM_TOOLTIP"))%>';
    spTranslatedText["SMR_PAGES_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGES_TOOLTIP"))%>';
    spTranslatedText["SMR_DOCVIEW_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOCVIEW_TOOLTIP"))%>';
    spTranslatedText["SMR_UNDO_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_UNDO_TOOLTIP"))%>';
    spTranslatedText["SMR_REDO_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_REDO_TOOLTIP"))%>';
    spTranslatedText["SMR_EDITC_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_EDITC_TOOLTIP"))%>';
    spTranslatedText["SMR_FONTS_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FONTS_TOOLTIP"))%>';
    spTranslatedText["SMR_DELITEM_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DELITEM_TOOLTIP"))%>';
    spTranslatedText["SMR_DOCSECT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOCSECT_TOOLTIP"))%>';
    spTranslatedText["SMR_MENUMOB_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_MENUMOB_TOOLTIP"))%>';
    spTranslatedText["SMR_DOWNLPDF_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOWNLPDF_TOOLTIP"))%>';
    spTranslatedText["SMR_DOWNL_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DOWNL_TOOLTIP"))%>';
    spTranslatedText["SMR_FFAMILY_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FFAMILY_TOOLTIP"))%>';
    spTranslatedText["SMR_FSIZE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FSIZE_TOOLTIP"))%>';
    spTranslatedText["SMR_FBOLD_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FBOLD_TOOLTIP"))%>';
    spTranslatedText["SMR_FITALIC_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FITALIC_TOOLTIP"))%>';
    spTranslatedText["SMR_FUNDERLINE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FUNDERLINE_TOOLTIP"))%>';
    spTranslatedText["SMR_FSTRIKEOUT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FSTRIKEOUT_TOOLTIP"))%>';
    spTranslatedText["SMR_FCOLOR_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FCOLOR_TOOLTIP"))%>';
    spTranslatedText["SMR_FLEFT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FLEFT_TOOLTIP"))%>';
    spTranslatedText["SMR_FCENTER_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FCENTER_TOOLTIP"))%>';
    spTranslatedText["SMR_FRIGHT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FRIGHT_TOOLTIP"))%>';
    spTranslatedText["SMR_H_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_H_TOOLTIP"))%>';
    spTranslatedText["SMR_LCOLOR_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_LCOLOR_TOOLTIP"))%>';
    spTranslatedText["SMR_LSTRETCHR_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_LSTRETCHR_TOOLTIP"))%>';
    spTranslatedText["SMR_NAME_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_NAME_TOOLTIP"))%>';
    spTranslatedText["SMR_IMGPATH_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_IMGPATH_TOOLTIP"))%>';
    spTranslatedText["SMR_IMGSEARCH_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_IMGSEARCH_TOOLTIP"))%>';
    spTranslatedText["SMR_PAGEN_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_PAGEN_TOOLTIP"))%>';
    spTranslatedText["SMR_DATEFORMAT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_DATEFORMAT_TOOLTIP"))%>';
    spTranslatedText["SMR_TIMEFORMAT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TIMEFORMAT_TOOLTIP"))%>';
    spTranslatedText["SMR_CALCULATE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CALCULATE_TOOLTIP"))%>';
    spTranslatedText["SMR_TYPEVIEW_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TYPEVIEW_TOOLTIP"))%>';
    spTranslatedText["SMR_BARCODETYPE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BARCODETYPE_TOOLTIP"))%>';
    spTranslatedText["SMR_FCOLOROFF_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FCOLOROFF_TOOLTIP"))%>';
    spTranslatedText["SMR_FCOLORON_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_FCOLORON_TOOLTIP"))%>';
    spTranslatedText["SMR_SMDATEFORMAT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SMDATEFORMAT_TOOLTIP"))%>';
    spTranslatedText["SMR_SMTIMEFORMAT_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SMTIMEFORMAT_TOOLTIP"))%>';
    spTranslatedText["SMR_CALCBYGRP_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_CALCBYGRP_TOOLTIP"))%>';
    spTranslatedText["SMR_BREQUIRED_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BREQUIRED_TOOLTIP"))%>';
    spTranslatedText["SMR_BGEOPOSITION_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BGEOPOSITION_TOOLTIP"))%>';
    spTranslatedText["SMR_BHIDEEXTRA_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_BHIDEEXTRA_TOOLTIP"))%>';
    spTranslatedText["SMR_SEQUENCE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_SEQUENCE_TOOLTIP"))%>';
    spTranslatedText["SMR_TITLE_TOOLTIP"] = '<%=JSPLib.ToJSValue(sp.translate("SMR_TITLE_TOOLTIP"))%>';
  </script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/itemsObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/vweditor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/TabsMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/smartreport.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/canvasLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/rulersLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/promise-ie-polyfill.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/jszip.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/xlsx.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/bcmath-min.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/pdf417.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/JsBarcode.all.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/qrcode2.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/html2canvas.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("smartreport/fonts.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("JSReportDocumentRuntime.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("JSReportDocumentHtml.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("JSReportDocumentPdf.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("JSReportDocumentText.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("JSReportDocumentXlsx.js")%>'></script>

  <script>
    ZtVWeb.SetTheme('<%=sp.getSkin()%>');
    var themeobj = window.SPTheme;
    var tname = '<%=sp.getSkin()%>',
    id = '<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>',
    datasource = '<%=JSPLib.ToJSValue(sp.getParameter("datasource",""))%>',
    reportmodel = '<%=JSPLib.ToJSValue(sp.getParameter("reportmodel",""))%>',
    custom = '<%=sp.getParameter("custom",false)%>',
    fields = '<%=JSPLib.ToJSValue(sp.getParameter("fields",""))%>',
    portletID = '<%=JSPLib.ToJSValue(sp.getParameter("portletID",""))%>',
    gridID = '<%=JSPLib.ToJSValue(sp.getParameter("gridID",""))%>',
    configName = '<%=JSPLib.ToJSValue(sp.getParameter("configName",""))%>',
    cbfnc = '<%=JSPLib.ToJSValue(sp.getParameter("cbfnc",""))%>',
    ptl = '<%=JSPLib.ToJSValue(sp.getParameter("ptl",""))%>',
    updfnc = '<%=JSPLib.ToJSValue(sp.getParameter("updfnc",""))%>',
    ptoolbar = "",
    vdmMask = '<%=JSPLib.ToJSValue(sp.getParameter("vdmMask",""))%>',
    svrpTitle = null,
    uri = '<%=request.getRequestURI()%>',
    uriparms = '<%=JSPLib.getParametersList(request)%>';

    function loadSmartReport(e) {
      if (!Empty(portletID) && !Empty(gridID)) {
        var parentPortlet = GetOpener().ZtVWeb.getPortletById(portletID);
        if  (!parentPortlet) // apertura da editzoom che non e' un portlet
            parentPortlet = GetOpener().GetOpener().ZtVWeb.getPortletById(portletID);
        var gridCtrl = parentPortlet[gridID];
        dataobj = parentPortlet[gridCtrl.dataobj]._getCloneForPrint();
      }

      if (window.parent.location.href.indexOf("portalstudio.jsp") >= 0) {
      }
      else {
        svrpTitle = new function () {
          ZtVWeb.newForm(this, 'svrpTitle', 'svrpTitle', 100, 30, 'portlet', false);
          if (this.toolbarP = ZtVWeb.getPortletInc('toolbarP')) {
            this.toolbarP.setContainer(this, 'toolbarP');
            this.toolbarP_ctrl = new ZtVWeb.PortletCtrl(this, 'toolbarP', 'toolbarP', 0, 0, '100%', 40, ''); //defaultPosRef = 40
          }
          this.toolbarP_ctrl.Ctrl.style.position='fixed';
          this.toolbarP_ctrl.Ctrl.style.width='100%';
          this.toolbarP_ctrl.Ctrl.style.height=this.toolbarP.Ctrl.offsetHeight+'px';
          this.toolbarP.title.Value("SmartReport" + " <span class='SPPortalZoom_currentversion'>" + '<%=sp.translate("NEW_REPORT")%>' + "</span>");
          this.toolbarP.AddButton(GetStyleVariable("smartReportWizardImage", ''), "javascript:drawERWizardH()", '', '<%=sp.translate("RPT_WIZARD")%>', '<%=sp.translate("RPT_WIZARD")%>');
          if (!dataobj)
            this.toolbarP.AddButton(GetStyleVariable("smartReportNewImage", ''), "javascript:newReport()", '', '<%=sp.translate("ADMIN_NEW")%>', '<%=sp.translate("ADMIN_NEW")%>');
          this.toolbarP.AddButton(GetStyleVariable("smartReportSaveImage", '<%=sp.getThemedImage("../images/custom_toolbar/save.png",pageContext.getServletContext())%>'), "javascript:save()", '', '<%=sp.translate("MSG_VZM_SAVE")%>', '<%=sp.translate("MSG_VZM_SAVE")%>');
          if (!dataobj) {
            this.toolbarP.toolbar.AppendMenuItem({  id: "action_saveas"
                                                    ,image: GetStyleVariable("smartReportSaveAsImage", '<%=sp.getThemedImage("../images/custom_toolbar/saveas.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:saveAs()"
                                                    ,title: '<%=sp.translate("SAVE_AS")%>'
                                                    ,tooltip: '<%=sp.translate("SAVE_AS")%>'
                                                  });

            this.toolbarP.toolbar.AppendMenuItem({  id: "action_open"
                                                    ,image: GetStyleVariable("smartReportOpenImage", '<%=sp.getThemedImage("../toolbar/psys_select_model.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:openReport()"
                                                    ,title: '<%=sp.translate("RPT_OPEN_REPORT")%>'
                                                    ,tooltip: '<%=sp.translate("RPT_OPEN_REPORT")%>'
                                                  });
          }
          else {
            this.toolbarP.AddButton(GetStyleVariable("smartReportSaveAsImage", '<%=sp.getThemedImage("../images/custom_toolbar/saveas.png",pageContext.getServletContext())%>'), "javascript:saveAs()", '', '<%=sp.translate("SAVE_AS")%>', '<%=sp.translate("SAVE_AS")%>');
            this.toolbarP.AddButton(GetStyleVariable("smartReportPDFImage", '<%=sp.getThemedImage("../toolbar/psys_pdf.png",pageContext.getServletContext())%>'), "javascript:makePdf()", '', '<%=sp.translate("RPT_FORMAT_PDF")%>', '<%=sp.translate("RPT_FORMAT_PDF")%>');
            this.toolbarP.toolbar.AppendMenuItem({  id: "action_dw_csv"
                                                    ,image: GetStyleVariable("smartReportCSVImage", '<%=sp.getThemedImage("../toolbar/psys_csv.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:makeCsv()"
                                                    ,title: '<%=sp.translate("RPT_FORMAT_CSV")%>'
                                                    ,tooltip: '<%=sp.translate("RPT_FORMAT_CSV")%>'
                                                  });
            this.toolbarP.toolbar.AppendMenuItem({  id: "action_dw_csvs"
                                                    ,image: GetStyleVariable("smartReportCSVSImage", '<%=sp.getThemedImage("../toolbar/psys_csv.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:makeCsv(true)"
                                                    ,title: '<%=sp.translate("RPT_FORMAT_CSVS")%>'
                                                    ,tooltip: '<%=sp.translate("RPT_FORMAT_CSVS")%>'
                                                  });
            this.toolbarP.toolbar.AppendMenuItem({  id: "action_dw_csv2"
                                                    ,image: GetStyleVariable("smartReportSDFImage", '<%=sp.getThemedImage("../toolbar/psys_txt.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:makeCsv(false,true)"
                                                    ,title: '<%=sp.translate("RPT_FORMAT_CSV2")%>'
                                                    ,tooltip: '<%=sp.translate("RPT_FORMAT_CSV2")%>'
                                                  });
            this.toolbarP.toolbar.AppendMenuItem({  id: "action_dw_xml"
                                                    ,image: GetStyleVariable("smartReportXMLImage", '<%=sp.getThemedImage("../toolbar/psys_xml.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:makeXml()"
                                                    ,title: '<%=sp.translate("RPT_FORMAT_XML")%>'
                                                    ,tooltip: '<%=sp.translate("RPT_FORMAT_XML")%>'
                                                  });
            this.toolbarP.toolbar.AppendMenuItem({  id: "action_dw_xmls"
                                                    ,image: GetStyleVariable("smartReportXMLSImage", '<%=sp.getThemedImage("../toolbar/psys_xml.png",pageContext.getServletContext())%>')
                                                    ,action: "javascript:makeXml(true)"
                                                    ,title: '<%=sp.translate("RPT_FORMAT_XMLS")%>'
                                                    ,tooltip: '<%=sp.translate("RPT_FORMAT_XMLS")%>'
                                                  });
          }
          this.toolbarP.RearrangeAll();
        }
        Ctrl("toolbarZ").style.marginTop = 10 + "px";
      }
      var loadParms = { filename: id,
                        datasource: datasource,
                        reportmodel: reportmodel,
                        custom: custom,
                        fields: fields,
                        portletID: portletID,
                        gridID: gridID,
                        configName: configName,
                        cbfnc: cbfnc,
                        ptl: ptl,
                        updfnc: updfnc,
                        vdmMask: vdmMask,
                        isAdmin : <%=sp.CanAccessEditor("PortalStudio")%>
                      };
      doLoad(e, loadParms);
    };
  </script>

  <link rel="stylesheet" href="../<%=sp.getTheme()%>/portalstudio.css" type="text/css">
  <!-- CSS -->
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("Notimoo.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("smartreport/TabsMT.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("classeditor/fontList.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("smartreport/smartreport.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("smartreport/editor.css")%>" />
  <link rel="stylesheet" type="text/css" href="../<%=SPPrxycizer.proxycizedPath("filewindow.css")%>" />

</head>
<body onLoad="loadSmartReport(event)" onResize="resizeWindow(event)" onkeydown="manageItems(event)" onkeyup="window.setProperties(event)" style="height:800px">
  <div id='svrpTitle'>
    <div id='toolbarP'>
      <%
        out.flush();
        if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp",true))
        if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp",true))
        Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp",false);
      %>
    </div>
  </div>

  <div id="properties" style="top:0px; left:0px; width:0px;height:0px;visibility:hidden";></div>
	<div id="toolbarZ">
    <div class="cApi_container">
      <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()"></a>
      <div class="toolbarpipe"></div>
    </div>
    <div id="toolbarLeft"></div>
    <div id="toolbarRight"></div>
		<div id="toolbarCurTab"></div>
		<div id="toolbarCurTabPdf" class="documentView"></div>
			<div id="toolbarZone">
				<div id="toolbarItems"></div>
				<div id="toolbarMenu" style="visibility:hidden;"></div>
				<div id="documentToolbar" class="unselectable documentView"></div>
			<div id="designToolbar" class="unselectable"></div>
		</div>
	</div>

	<div id="report_page_frame"></div>
  <div id="i_mask_wrapper_parent" style="display:none">
  <div id="i_mask_wrapper">
    <iframe id="i_mask" name="i_mask" width="100%" frameBorder="0"></iframe>
  </div>
  </div>

	<div id="v_line"></div>
	<!-- RIGHELLI -->
	<div id="h_ruler" class="unselectable">
		<div id="h_rulerc"></div>
	</div>
	<div id="v_ruler" class="unselectable">
		<div id="v_rulerc"></div>
	</div>
	<div id="v_ruler_zones" class="unselectable"></div>
	<div id="rulergridopt" class="btncontainer iconbtnToolbar smartreport-icon-grid"></div>
	<div id="loading" class="loading" style="display:block"></div>

	<div id="loadingopac" style="display:none"></div>
	<div id="editinput" class="hiddenZone" style="z-index:102;position:absolute;border:1px solid #C3C3C3;background-color:#F3F3F3;">
		<span id="eititle" style="float:left;font-family:lucida grande,tahoma,verdana,arial,sans-serif;font-size:10pt;font-weight:bold;"></span>
		<textarea id="inputarea" class="hiddenZone" onkeyup="inputareaKeyUp(event)" onblur="inputareaToItem()"></textarea>
		<div id="inputcombo" class="hiddenZone"></div>
	</div>
	<!-- BACKCANVAS -->
	<div id="backcanvas" class="unselectable" onselectstart="noDefaultDrag(event)" onscroll="setScroll(event, this)" style="overflow:auto">
		<div id="barslimithandlers"></div>
		<div id="barslimit"></div>
		<div id="marginleft" style="cursor:e-resize;"  onmousedown="dragMargin(event)" class="documentView rightmar"><span id="marginleft_int" class="xmargin"></span></div>
		<div id="marginright" style="cursor:e-resize;"  onmousedown="dragMargin(event)" class="documentView leftmar"><span id="marginright_int" class="xmargin"></span></div>
		<div id="margintop" style="cursor:n-resize;"  onmousedown="dragMargin(event)" class="documentView topmar"><span id="margintop_int" class="ymargin"></span></div>
		<div id="marginbottom" style="cursor:n-resize;" onmousedown="dragMargin(event)" class="documentView bottommar"><span style="top:-15px" id="marginbottom_int" class="ymargin"></span></div>

		<div id="canvas" class="unselectable" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)">
			<div id="canvaslinks" class="unselectable designView"></div>
			<div id="drag" class="unselectable designView" style="overflow:hidden;z-index:102;border:1px solid #555555;position:absolute;visibility:hidden;width:1px;height:1px;top:1px;left:1px;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)">
				<div id="dragcontent" style="width:100%;height:100%;overflow:hidden;background:#FFFFFF;z-index:1999;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)"></div>
			</div>
			<div id="canvashandlers"></div>
			<div id="canvasdesign" class="unselectable designView">
				<div id="reportheader" class="unselectable designView zBand reportZ hiddenZone">
					<span class="spanbar title_label">Report header</span>
          <span class="spanbar subtitle_label">[one band by report]</span>
				</div>
				<div id="reportheadercontent" class="unselectable contentZone hiddenZone designView"></div>
				<div id="reportheaderlimit" class="unselectable limit reportL hiddenZone designView"></div>

				<div id="pageheader" class="unselectable designView zBand pageZ hiddenZone">
          <span class="spanbar title_label">Page header</span>
          <span class="spanbar subtitle_label">[one band by page]</span>
				</div>
				<div id="pageheadercontent" class="unselectable contentZone hiddenZone designView">  </div>
				<div id="pageheaderlimit" class="unselectable limit pageL hiddenZone designView"></div>

				<div id="groupbreak" class="unselectable designView zBand breakZone">
          <span class="spanbar title_label">Grouping</span>
          <span class="spanbar subtitle_label">[datasource's fields]</span>
					<div id="groupbreakcontentswitch" class="unselectable"></div>
					<div id="groupbreakcontentitems" class="unselectable"></div>
				</div>

				<div id="groupheader" class="unselectable designView zBand groupZ">
          <span class="spanbar title_label">Group header</span>
          <span class="spanbar subtitle_label">[one band by grouping]</span>
				</div>
				<div id="groupheadercontent" class="unselectable contentZone designView"></div>
				<div id="groupheaderlimit" class="unselectable limit groupL designView"></div>

				<div id="groupbody" class="unselectable designView zBandDetail detailZ">
          <span class="spanbar title_label">Detail</span>
          <span class="spanbar subtitle_label">[one band by datasource's row]</span>
				</div>
				<div id="groupbodycontent" class="unselectable contentZone designView"></div>
				<div id="groupbodylimit" class="unselectable limit detailL designView"></div>

				<div id="groupfooter" class="unselectable designView zBand groupZ">
          <span class="spanbar title_label">Group footer</span>
          <span class="spanbar subtitle_label">[one band by grouping]</span>
				</div>
				<div id="groupfootercontent" class="unselectable contentZone designView"></div>
				<div id="groupfooterlimit" class=" unselectable limit groupL designView"></div>

				<div id="pagefooter" class="unselectable designView zBand pageZ hiddenZone">
          <span class="spanbar title_label">Page footer</span>
          <span class="spanbar subtitle_label">[one band by page]</span>
				</div>
				<div id="pagefootercontent" class="unselectable contentZone hiddenZone designView"></div>
				<div id="pagefooterlimit" class="unselectable limit pageL hiddenZone designView"></div>

				<div id="reportfooter" class="unselectable designView zBand reportZ hiddenZone">
          <span class="spanbar title_label">Report footer</span>
          <span class="spanbar subtitle_label">[one band by report]</span>
				</div>
				<div id="reportfootercontent" class="unselectable contentZone hiddenZone designView"></div>
				<div id="reportfooterlimit" class="unselectable limit reportL hiddenZone designView"></div>
			</div>
			<div id="canvasdocprev" class="unselectable documentView" style="background-color:#c3c3c3;border:0px solid;overflow:hidden;"></div>
		</div>
	</div>

	<div id="shadowmenu" class="unselectable hiddenAdd">
		<div id="boxcontainer"></div>
	</div>
	</div>

	<div id="gadgets_pane" class="unselectable" style="display:none">
		<div id="gadgets_panerightbar" class="" title="Toggle SmartReport Editor Properties Explorer">
			<div id="gadgets_openclose"></div>
		</div>

		<div id="fieldlistTitle" class="unselectable gadgetlistTitle" for="fieldprop">
			<div id="fieldlistBar" class="text">Datasource & fields</div>
			<a id="fieldslist-toggler-document" class="gadgets_pane_toggler" title="" href="javascript:void(0)" style="background-position: 0% 100%;"></a>
		</div>


		<div id="fields_pane" class="unselectable gadgets_pane_item">
			<div id="fieldprop" style="height:100%;" class="unselectable navigator">
				<input onfocus="SetOnEditProp(true);" onblur="loadFieldsInput();" id="fielddatasource" class="inputSearchDefault" title="Specifies the chosen query or business object" type="text" placeholder="Datasource">
				<span id="bRefresh" title="Refresh datasource" onclick="javascript:refreshdata()" class="unselectable iconbtnToolbar smartreport-icon-reload" style="margin: 0;font-size: 30px;"></span>
				<span id="bBo" title="Select Business Object" style="float:right" onclick="javascript:selectbo()" class="unselectable iconbtnToolbar prop_tab smartreport-icon-bo"></span>
				<span id="bNewQuery" title="New Query" style="float:right" onclick="javascript:newvqr()"  class="unselectable iconbtnToolbar prop_tab smartreport-icon-add"></span>
				<span id="bEditQuery" title="Edit Query" style="float:right" onclick="javascript:editvqr()"  class="unselectable iconbtnToolbar prop_tab smartreport-icon-edit"></span>
				<span id="bQuery" title="Select Query" style="float:right" onclick="javascript:selectvqr()"  class="unselectable iconbtnToolbar prop_tab smartreport-icon-vqr"></span>
        <input onfocus="SetOnEditProp(true);" onblur="setVdmMask()" id="vdmfileinput" class="inputSearchDefault" title="Specifies the mask parameters" type="text" placeholder="Parameters mask">
				<span id="bNewVdm" title="New parameters mask" style="float:right" onclick="javascript:newvdm()"  class="unselectable iconbtnToolbar prop_tab smartreport-icon-add"></span>
				<span id="bEditVdm" title="Edit parameters mask" style="float:right" onclick="javascript:editvdm()"  class="unselectable iconbtnToolbar prop_tab smartreport-icon-edit"></span>
				<span id="bSelect" title="Select parameters mask" style="float:right" onclick="javascript:selectvdm()"  class="unselectable iconbtnToolbar prop_tab smartreport-icon-filter"></span>
				<div id="fieldLegend" class="hiddenZone fldLegend"></div>

				<div id="fields_container" style="float:left;width:182px;" class="unselectable">
					<div id="toolbarfldz" onscroll="removeAllFieldHandlers()">
						<div id="toolbarfld" style="z-index:101"></div>
						<div id="toolbarfldhandlers" style="z-index:101"></div>
					</div>
				</div>
			</div>
		</div>

		<div id="genlistTitle" class="unselectable gadgetlistTitle" for="genericitemprop">
			<div id="genlistBar" class="text">Generic elements</div>
			<a id="genericitems-toggler-document" class="gadgets_pane_toggler" title="" href="javascript:void(0)" style="background-position: 0% 100%;"></a>
		</div>
		<div id="genitems_pane" class="unselectable gadgets_pane_item">
			<div id="genericitemprop" class="unselectable navigator">
			</div>
		</div>

		<div style="display:none">
			<textarea id="translator"></textarea>
		</div>

		<span id="ruler" style="visibility:hidden;width:auto"></span>

		<!-- TOOLTIP BOX INFO -->
		<div id="tooltip_box" class="unselectable tooltips tooltipView designView"></div>
	</div>
</body>
<script src='../portalstudio/psHelp.js'></script>
</html>
<%
  if (sp.CanAccessEditor("PortalStudio"))
    sp.endMutationSection();
}
else
  response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
%>
