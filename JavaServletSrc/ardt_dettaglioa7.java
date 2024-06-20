import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class ardt_dettaglioa7 extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3440b345*!";
  static public class ServletStatus extends SPDetailChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "detta7";
    }
    public String w_ANNO;
    public String w_SEMESTRE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_ANNO,context,"detta7","ANNO","C",4,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SEMESTRE,context,"detta7","SEMESTRE","C",1,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
      }
    }
    void FillParameters() {
      m_Parameters = source.GetParametersProperties();
      m_cWv = (CPLib.gt(m_Parameters.size(),0)?"_not_empty_":"");
    }
    public void MergeCallerVars(SPParameterSource source) {
    }
    public void WriteSenderFormPKVars() {
      ServletStatus status = this;
      if (CPLib.eq(m_cClientMode,"query") || CPLib.eq(m_cClientMode,"view")) {
        status.out.println(
         "<input name='ANNO' type='hidden' value="+SPLib.ToHTMLValue(w_ANNO,"C",4,0)+">" +
        "");
        status.out.println(
         "<input name='SEMESTRE' type='hidden' value="+SPLib.ToHTMLValue(w_SEMESTRE,"C",1,0)+">" +
        "");
      }
    }
  }
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    // Inizializzazione delle variabili della classe globale di stato
    ServletStatus status = new ServletStatus();
    status.containing = this;
    SPParameterSource source = SPLib.GetSource(request);
    // Controlla lo stato di login e la sicurezza associata alla procedura
    if ( ! (EnterServlet(status,source,request,response))) {
      return;
    }
    boolean requiredPwd;
    requiredPwd = (CPLib.eq(status.m_cAction,"delete")?false:false);
    boolean requiredOTP;
    requiredOTP = (CPLib.eq(status.m_cAction,"delete")?false:false);
    int accessType;
    accessType = (requiredOTP?3:((requiredPwd?2:SPLib.AccessType((CPLib.eq(status.m_cAction,"delete")?"delete":"access"),entityGlobals.name))));
    if ( ! (CheckAccessSecurity(status,(CPLib.eq(accessType,3)?"OTP":(CPLib.eq(accessType,2)?"password":""))))) {
      RequestPwdOrOTP(status,(CPLib.eq(accessType,3)?"OTP":"password"));
      return;
    }
    // Ora esegue l' operazione richiesta da m_cAction
    ardt_dettaglioa7BO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_detta7;
    if (CPLib.eq(status.m_cAction,"start")) {
      status.m_cMode = "";
      status.m_cClientMode = "query";
      BO.Blank();
    } else if (CPLib.eq(status.m_cAction,"query")) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"view")) {
      View(status,BO);
    } else if (CPLib.eq(status.m_cAction,"first")) {
      MoveTo(status,1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"previous")) {
      MoveTo(status,status.m_nRecPos-1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"next")) {
      MoveTo(status,status.m_nRecPos+1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"last")) {
      MoveTo(status,status.m_nLastRec);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"moveto")) {
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"edit")) {
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"editload")) {
      EditLoad(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"write")) {
      Write(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"writeload")) {
      Write(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"new")) {
      New(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"save")) {
      Save(status,BO);
    } else if (CPLib.eq(status.m_cAction,"discard")) {
      Discard(status,BO);
    } else if (CPLib.eq(status.m_cAction,"delete")) {
      Delete(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"deletemessage")) {
      DeleteMessage(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"painter")) {
      Painter(status);
    } else if (CPLib.eq(status.m_cAction,"autozoom")) {
      OpenZoom(status,source);
    } else if (CPLib.eq(status.m_cAction,"zoom")) {
      OpenPSZoom(status,source);
    } else if (CPLib.eq(status.m_cAction,"deleterow")) {
      DeleteRow(status,BO,source);
    }
    // * --- Area Manuale = Do Action
    // * --- Fine Area Manuale
    //  status.m_cClientMode: stato che deve assumere il client
    //  status.m_bError: indica se si e' verificato un errore
    //  status.m_bExit: indica se e' un punto di uscita
    //  status.m_cAtExit: azione di uscita
    Forward localForward = Forward.Unforwarded;
    if ( ! (status.m_bExit) || CPLib.Empty(status.m_cAtExit)) {
    } else if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"workflow")) {
      ExitToWorkflow(status);
    } else if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"activity")) {
      ExitToActivity(status,BO);
    } else if (status.m_bError && CPLib.ne(status.m_cClientMode,"bringback")) {
      // Il programma da eseguire in uscita non sa come visualizzare l' errore, viene quindi lanciata la pagina di errore che poi eseguira' il programma di uscita
      status.m_cClientMode = "error";
    } else if (status.m_bError) {
    } else if (CPLib.eq(status.m_cAtExit,"new")) {
      status.CleanInterfaceSettings();
      New(status,BO,source);
    } else if (CPLib.eq(status.m_cAtExit,"edit")) {
      status.w_ANNO = BO.w_ANNO;
      status.w_SEMESTRE = BO.w_SEMESTRE;
      BO.Initialize();
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAtExit,"autozoom")) {
      // Si puo' proseguire con lo zoom
      OpenZoom(status,source);
    } else if (CPLib.eq(status.m_cAtExit,"close")) {
      // Si puo' proseguire con la chiusura della pagina corrente
      status.m_cClientMode = "close";
    } else if (CPLib.eq(status.m_cAtExit,"close&reload")) {
      // Si puo' proseguire con la chiusura della pagina corrente e rinfrescare il chiamante
      status.m_bReload = true;
      status.m_cClientMode = "close";
    } else {
      status.m_cAtExit = "workflow"+"\n"+"@END"+"\n"+status.m_cAtExit;
      ManageWorkflow(status,"@END");
    }
    // ora interpreta la seconda parte del workflow (i vari set sull' oggetto reale)
    ExecuteWorkflowStartingScript(status,BO);
    // Ora manda la pagina di risposta
    NotifyEvent("Response start",status,BO);
    if (Forward.IsForwarded(status.forwardedto)) {
      SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
      return;
    }
    SPLib.SetContentType(response);
    if ("get".equalsIgnoreCase(request.getMethod())) {
      SPLib.NoCache(response);
    }
    status.out = response.getWriter();
    if (CPLib.eq(status.m_cClientMode,"error")) {
      WriteErrorPage(status);
    } else if (CPLib.eq(status.m_cClientMode,"close")) {
      WriteExitPage(BO,status,localForward);
    } else if (CPLib.eq(status.m_cClientMode,"bringback")) {
      BringBackPage(BO,status);
    } else if (CPLib.eq(status.m_cAction,"createportlet")) {
      CreatePortlet(status,BO);
    } else {
      WriteFormPage(BO,status);
    }
  }
  public String getEntityTitle() {
    return "DETTAGLIO A7";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "ardt_dettaglioa7";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1076;
    l_eg.m_nEntityHeight = 482;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"detta7","vocea7","sottovocea7","tb00016","tb01217","tb02147"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"ANNO","SEMESTRE"};
    l_eg.keyRepeatedColumns = new String[]{"CPROWNUM"};
    l_eg.items = new SPItem[]{
                   new SPItem("ANNO","C",4,0, "hide","Annno"),
                   new SPItem("SEMESTRE","C",1,0, "hide","SEMESTRE"),
                   new SPItem("VOCE","C",5,0, "edit","Voce"),
                   new SPItem("SOTTOVOCE","C",2,0, "edit","Sottovoce"),
                   new SPItem("RESID","C",1,0, "edit","Residenza"),
                   new SPItem("PROVINCIA","C",5,0, "edit","Provincia"),
                   new SPItem("STATO","C",3,0, "edit","Stato"),
                   new SPItem("VAL01217","C",5,0, "edit","Oggetto dei reclami"),
                   new SPItem("VAL02147","C",5,0, "edit","Tipo Restituzione"),
                   new SPItem("VAL02148","D",8,0, "edit","Data Efficacia"),
                   new SPItem("VAL02149","C",6,0, "edit","Progressivo Manovra"),
                   new SPItem("DATAEFF","D",8,0, "hide","Data Effettuazione"),
                   new SPItem("IMPORTO","N",15,2, "edit","Importo/Numero"),
                   new SPItem("IDBASEA7","C",10,0, "hide","IDBASE RIga"),
                   new SPItem("CPROWNUM","N",4,0, "hide",""),
                   new SPItem("FLGRESID","C",1,0, "hide","Flag Residenza"),
                   new SPItem("FLG00015","C",1,0, "hide","Attiva Provincia"),
                   new SPItem("FLG00016","C",1,0, "hide","Attiva Stato"),
                   new SPItem("FLG01217","C",1,0, "hide","Attiva Tab 1217"),
                   new SPItem("FLG02147","C",1,0, "hide","Attiva Tab 2147"),
                   new SPItem("FLG02148","C",1,0, "hide","Attiva Tab 2148"),
                   new SPItem("FLG02149","C",1,0, "hide","Attiva Tab 2149"),
                   new SPItem("xDESCRI","C",160,0, "hide","Descrizione"),
                   new SPItem("xDESVOCE","C",160,0, "hide","Descrizione")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(1);
      org.json.JSONArray l_sidebarPageItems;
    }
    if (CPLib.ge(p_nPage,0) && CPLib.lt(p_nPage,i_sidebarItems.size())) {
      return i_sidebarItems.get(p_nPage);
    } else {
      return new org.json.JSONArray();
    }
  }
  // m_layerGroups inizializzato dal primo accesso a FillLayerGroups
  org.json.JSONObject m_layerGroups = null;
  public void FillLayerGroups(CPMNTChild[] p_MNTs) {
    if (CPLib.IsNull(m_layerGroups)) {
      org.json.JSONObject l_layerGroups = null;
      l_layerGroups = new org.json.JSONObject("{}");
      if ( ! (CPLib.IsNull(p_MNTs))) {
        CPLib.AppendFoundlingChildOnLayerGroup(p_MNTs,l_layerGroups);
      }
      m_layerGroups = l_layerGroups;
    }
  }
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,ardt_dettaglioa7BO BO) {
    CPMNTChild[] l_MNTs = BO.m_MNTs;
    FillLayerGroups(l_MNTs);
    return GetGenericLayerGroupHeader(getLayerGroup(p_cGroupName),p_cLayerName,p_cLayerId,BO.m_Ctx,l_MNTs);
  }
  public org.json.JSONArray getLayerGroup(String group) {
    return m_layerGroups.getJSONArray(group);
  }
  org.json.JSONArray i_notifyItems = null;
  public org.json.JSONArray getNotifyItems() {
    if (CPLib.IsNull(i_notifyItems)) {
      i_notifyItems = new org.json.JSONArray();
    }
    return i_notifyItems;
  }
  ArrayList<org.json.JSONArray> i_contextmenu = null;
  public org.json.JSONArray getContextMenu(int p_nPage) {
    if (CPLib.IsNull(i_contextmenu)) {
      i_contextmenu = InitializeContextMenuArray(1);
      org.json.JSONArray l_contextmenuPageItems;
    }
    if (CPLib.ge(p_nPage,0) && CPLib.lt(p_nPage,i_contextmenu.size())) {
      return i_contextmenu.get(p_nPage);
    } else {
      return new org.json.JSONArray();
    }
  }
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"10095365423",p_Context.Translate("Provincia")},
    {"10262589875",p_Context.Translate("Tipo Restituzione")},
    {"10524661789",p_Context.Translate("DETTAGLIO A7")},
    {"10789175827",p_Context.Translate("Data Efficacia")},
    {"11214349292",p_Context.Translate("%1")},
    {"11483234909",p_Context.Translate("SEMESTRE")},
    {"11495876696",p_Context.Translate("Sottovoce")},
    {"11506666269",p_Context.Translate("Attiva Provincia")},
    {"1151843906",p_Context.Translate("IDBASE RIga")},
    {"11560194558",p_Context.Translate("Attiva Tab 2149")},
    {"11576971774",p_Context.Translate("Attiva Tab 2148")},
    {"11593748990",p_Context.Translate("Attiva Tab 2147")},
    {"11596447825",p_Context.Translate("Flag Residenza")},
    {"11596833278",p_Context.Translate("Attiva Tab 1217")},
    {"11602249308",p_Context.Translate("Oggetto dei reclami")},
    {"12019815305",p_Context.Translate("%1")},
    {"1452570117",p_Context.Translate("Attiva Stato")},
    {"1847733175",p_Context.Translate("Importo/Numero")},
    {"237553103",p_Context.Translate("Progressivo Manovra")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"347802115",p_Context.Translate("Residenza")},
    {"440902",p_Context.Translate("Voce")},
    {"457286",p_Context.Translate("Voci")},
    {"729767095",p_Context.Translate("Data Effettuazione")},
    {"7755041",p_Context.Translate("Annno")},
    {"7776403",p_Context.Translate("Stato")},
    {"MSG_MD_TAB_FOOTER",p_Context.Translate("MSG_MD_TAB_FOOTER")},
    {"MSG_MD_TAB_HEADER",p_Context.Translate("MSG_MD_TAB_HEADER")},
    {"MSG_MD_TAB_ROWS",p_Context.Translate("MSG_MD_TAB_ROWS")}};
    return l_translations;
  }
  org.json.JSONArray i_detailMenuItems = null;
  public org.json.JSONArray getDetailMenuItems() {
    if (CPLib.IsNull(i_detailMenuItems)) {
      i_detailMenuItems = new org.json.JSONArray();
    }
    return i_detailMenuItems;
  }
  void WriteStyles(ardt_dettaglioa7BO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../ardt_dettaglioa7.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(ardt_dettaglioa7BO BO,ServletStatus status) {
    status.out.println(
     "<div id='FrmMain' class='FormDefault'>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("if ( ! (Empty(m_cLayerInterface))) {");
    status.out.println("document.getElementById('FrmMain').style.display='none';");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='subTitleContainer' class='subTitleContainer' style='display:none'>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("SetSubTitle("+SPLib.ToJSValue(status.context.Translate(""),"C",0,0)+");");
    status.out.println(
     "</script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println(
       "<div id='tabsContainer'>" +
       " " +
       "</div>" +
      "");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__url",status.m_cAltInterface);
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
      HTMLRowScript(BO,status);
      status.out.println(
       "<style>" +
      "");
      status.out.println(".GVMMKABWWU {top:0px;position:absolute;left:0px;height:16px;width:512px;z-index:1; }");
      status.out.println(".NNRZYWQBXJ {top:0px;position:absolute;left:520px;height:16px;width:528px;z-index:1; }");
      status.out.println(
       "</style>" +
      "");
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "<script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
      status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("MSG_PAGE_NUMBER","1"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
      status.out.println("Z.Tabs.Set('tabs',tabs);");
      status.out.println("} else {");
      status.out.println("var tabs = Z.Tabs.Get('tabs')");
      status.out.println("}");
      AddExtendedTabs(status);
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_dettaglioa7',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"ardt_dettaglioa7",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(ardt_dettaglioa7BO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(ardt_dettaglioa7BO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:482px;width:1076px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"PAGE_1");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
    if ( ! (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,""))) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('page_1').style.display='block';");
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteControls_p1_b0(ardt_dettaglioa7BO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:482px'>" +
    "");
    status.out.println(
     "<div name id='GridTable_Header' class='GridTable_Header' style='position:absolute;top:6px;left:6px;height:19px;width:1070px;z-index:0'>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel GridTable_HeaderTitle' id='EYBPXHGUZY_DIV'>" +
     "<label id='EYBPXHGUZY' for='GVMMKABWWU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Voce"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel GridTable_HeaderTitle' id='NPOUDYSLPC_DIV'>" +
     "<label id='NPOUDYSLPC' for='NNRZYWQBXJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottovoce"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BKLPQLOWPY_DIV'>" +
     "<label id='BKLPQLOWPY' for='SNYJQPAYYR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QYXREWCOCK_DIV'>" +
     "<label id='QYXREWCOCK' for='MVCFXMIIPY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CKEDGOYWAR_DIV'>" +
     "<label id='CKEDGOYWAR' for='MDEBFTECJW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DHTENWMMKQ_DIV'>" +
     "<label id='DHTENWMMKQ' for='NHFRSWSJPA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Oggetto dei reclami:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NOMPGQKWQY_DIV'>" +
     "<label id='NOMPGQKWQY' for='KYDBUIQLMM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Restituzione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YZSDTWZADK_DIV'>" +
     "<label id='YZSDTWZADK' for='CNCQNTLDXJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Efficacia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UJZUUASOGW_DIV'>" +
     "<label id='UJZUUASOGW' for='PDCPOALMKJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo Manovra:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VSGBYENSVC_DIV'>" +
     "<label id='VSGBYENSVC' for='OWRKSPYBFW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo/Numero:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='GridTable_Container' style='position:absolute;top:25px;left:6px;height:291px;width:1070px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
     "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:291px;width:1070px;overflow:scroll'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:1070px;height:291px;overflow:auto;'>" +
     "<table id='GridTable' style='position:relative;top:0px;left:0px;width:1064px' cellspacing='0' cellpadding='0' border='0'>" +
     "<tr>" +
     "<td></td>" +
     "</tr>" +
     "</table>" +
     "</div>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<div id='GridTable_ButtonPanel' style='position:absolute;top:0px;left:8px;z-index:4'>" +
       ""+printButtonPanelContent(status,0,"lower_right",false,getDetailMenuItems(),false,"")+"" +
       "</div>" +
      "");
    }
    HTMLRowScript(BO,status);
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='RESID' id='MVCFXMIIPY' class='"+status.ObligatoryClass("Combobox",BO.MVCFXMIIPY_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_RESID))?"SELECTED":"")+">" +
     ""+status.context.Translate("1-Rapporti con soggetti residenti in Italia")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_RESID))?"SELECTED":"")+">" +
     ""+status.context.Translate("2-Rapporti con soggetti non residenti in Italia")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('MVCFXMIIPY'),w_RESID,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='PROVINCIA' id='SNYJQPAYYR' class='"+status.ObligatoryClass("Combobox",BO.SNYJQPAYYR_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='STATO' id='MDEBFTECJW' class='"+status.ObligatoryClass("Combobox",BO.MDEBFTECJW_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='VAL01217' id='NHFRSWSJPA' class='"+status.ObligatoryClass("Combobox",BO.NHFRSWSJPA_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='VAL02147' id='KYDBUIQLMM' class='"+status.ObligatoryClass("Combobox",BO.KYDBUIQLMM_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='VAL02148' id='CNCQNTLDXJ' type='text' class='"+status.ObligatoryClass("Field",BO.CNCQNTLDXJ_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_VAL02148,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
     "<button id='CNCQNTLDXJ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='VAL02149' id='PDCPOALMKJ' type='text' class='"+status.ObligatoryClass("Field",BO.PDCPOALMKJ_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_VAL02149,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='6' size='6' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='IMPORTO' id='OWRKSPYBFW' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_IMPORTO,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='21' size='15' fieldtype='N'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+1;
    status.out.println(
     "</div>" +
    "");
  }
  void HTMLRowScript(ardt_dettaglioa7BO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:1048px;height:18px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_VOCE;");
    status.out.println("var w_SOTTOVOCE;");
    status.out.println("var w_RESID;");
    status.out.println("var w_PROVINCIA;");
    status.out.println("var w_STATO;");
    status.out.println("var w_VAL01217;");
    status.out.println("var w_VAL02147;");
    status.out.println("var w_VAL02148;");
    status.out.println("var w_VAL02149;");
    status.out.println("var w_DATAEFF;");
    status.out.println("var w_IMPORTO;");
    status.out.println("var w_IDBASEA7;");
    status.out.println("var w_CPROWNUM;");
    status.out.println("var w_FLGRESID;");
    status.out.println("var w_FLG00015;");
    status.out.println("var w_FLG00016;");
    status.out.println("var w_FLG01217;");
    status.out.println("var w_FLG02147;");
    status.out.println("var w_FLG02148;");
    status.out.println("var w_FLG02149;");
    status.out.println("var w_xDESCRI;");
    status.out.println("var w_xDESVOCE;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_VOCE=row[prefix+'VOCE'];");
    status.out.println("w_SOTTOVOCE=row[prefix+'SOTTOVOCE'];");
    status.out.println("w_RESID=row[prefix+'RESID'];");
    status.out.println("w_PROVINCIA=row[prefix+'PROVINCIA'];");
    status.out.println("w_STATO=row[prefix+'STATO'];");
    status.out.println("w_VAL01217=row[prefix+'VAL01217'];");
    status.out.println("w_VAL02147=row[prefix+'VAL02147'];");
    status.out.println("w_VAL02148=row[prefix+'VAL02148'];");
    status.out.println("w_VAL02149=row[prefix+'VAL02149'];");
    status.out.println("w_DATAEFF=row[prefix+'DATAEFF'];");
    status.out.println("w_IMPORTO=row[prefix+'IMPORTO'];");
    status.out.println("w_IDBASEA7=row[prefix+'IDBASEA7'];");
    status.out.println("w_CPROWNUM=row[prefix+'CPROWNUM'];");
    status.out.println("w_FLGRESID=row[prefix+'FLGRESID'];");
    status.out.println("w_FLG00015=row[prefix+'FLG00015'];");
    status.out.println("w_FLG00016=row[prefix+'FLG00016'];");
    status.out.println("w_FLG01217=row[prefix+'FLG01217'];");
    status.out.println("w_FLG02147=row[prefix+'FLG02147'];");
    status.out.println("w_FLG02148=row[prefix+'FLG02148'];");
    status.out.println("w_FLG02149=row[prefix+'FLG02149'];");
    status.out.println("w_xDESCRI=row[prefix+'xDESCRI'];");
    status.out.println("w_xDESVOCE=row[prefix+'xDESVOCE'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<select name='VOCE' id='GVMMKABWWU' class='Combobox GridTable_EditRowItem ' title='\"+Strtran(AlertErrorMessage('11214349292',w_xDESVOCE),'\\\\n','&#10;')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<select name='SOTTOVOCE' id='NNRZYWQBXJ' class='Combobox GridTable_EditRowItem ' title='\"+Strtran(AlertErrorMessage('12019815305',w_xDESCRI),'\\\\n','&#10;')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "\"+render_combobox(null,'qbe_sottovocea7',['?w_VOCE'],[WtA(w_VOCE,'C')],GetDynComboId('NNRZYWQBXJ'),'SOTTOVOCE','DESCRI','',w_SOTTOVOCE)+\"" +
     "</select>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(9);
    status.m_nTabIndex = status.m_nTabIndex+(0);
    status.m_nAfterDetailElementTabIndex = status.m_nTabIndex;
    status.out.println("s=s+\""+
     "<input name='AfterDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(-9);
    status.m_nTabIndex = status.m_nTabIndex-(0);
    status.out.println("} else {");
    status.out.println("if ( ! (IsHiddenByStateDriver('VOCE'))) {");
    status.out.println("s=s+\""+
     "<select id='GVMMKABWWU_\"+m_nCurrentRow+\"' class='Combobox GridTable_QueryRowItem GVMMKABWWU' title='\"+Strtran(AlertErrorMessage('11214349292',w_xDESVOCE),'\\\\n','&#10;')+\"' disabled>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('SOTTOVOCE'))) {");
    status.out.println("s=s+\""+
     "<select id='NNRZYWQBXJ_\"+m_nCurrentRow+\"' class='Combobox GridTable_QueryRowItem NNRZYWQBXJ' title='\"+Strtran(AlertErrorMessage('12019815305',w_xDESCRI),'\\\\n','&#10;')+\"' disabled>" +
     "\"+render_combobox(null,'qbe_sottovocea7',['?w_VOCE'],[WtA(w_VOCE,'C')],GetDynComboId('NNRZYWQBXJ'),'SOTTOVOCE','DESCRI','',w_SOTTOVOCE)+\"" +
     "</select>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:1048px;height:18px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  static void PrintState(ardt_dettaglioa7BL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(ardt_dettaglioa7BL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(ardt_dettaglioa7BL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_ANNO,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VOCE,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOTTOVOCE,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESID,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VAL01217,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VAL02147,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VAL02148,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VAL02149,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAEFF,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPORTO,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASEA7,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPROWNUM,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGRESID,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLG00015,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLG00016,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLG01217,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLG02147,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLG02148,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLG02149,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESCRI,"C",160,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESVOCE,"C",160,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(ardt_dettaglioa7BL BO,ServletStatus status) {
    int k;
    int l_nSelectRow = -1;
    boolean l_bForceSelect = false;
    if (CPLib.Empty(status.m_cDetailBehavior) && status.m_bBrowserUpdate &&  ! (CPLib.Empty(BO.LastErrorMessage()))) {
      status.out.print("if (Empty(m_cDetailBehavior)) {");
      status.out.print("m_cDetailBehavior='select';");
      status.out.print("}");
      l_nSelectRow = BO.m_nCurrentRow;
      l_bForceSelect = true;
    } else if (CPLib.ne(CPLib.Lower(CPLib.Left(status.m_cDetailBehavior,6)),"select")) {
      l_nSelectRow = -2;
    }
    status.out.print("m_oTrs=[");
    k = 0;
    while (CPLib.lt(k,BO.m_oTrs.size())) {
      BO.SetRow(k);
      if (CPLib.eq(l_nSelectRow,-1)) {
        l_nSelectRow = k;
      }
      status.out.print(" new TrsRow(");
      status.out.print(""+SPLib.ToJSValue(BO.w_VOCE,"C",5,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_SOTTOVOCE,"C",2,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_RESID,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_PROVINCIA,"C",5,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_STATO,"C",3,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_VAL01217,"C",5,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_VAL02147,"C",5,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_VAL02148,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_VAL02149,"C",6,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DATAEFF,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IMPORTO,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDBASEA7,"C",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CPROWNUM,"N",4,0)+",");
      if ( ! (l_bForceSelect) && CPLib.eq(l_nSelectRow,k) && ( ! (status.source.Has("CPROWNUM")) || CPLib.ne(BO.w_CPROWNUM,status.source.GetParameter("CPROWNUM",0)))) {
        l_nSelectRow = -1;
      }
      status.out.print(""+SPLib.ToJSValue(BO.w_FLGRESID,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_FLG00015,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_FLG00016,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_FLG01217,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_FLG02147,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_FLG02148,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_FLG02149,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_xDESCRI,"C",160,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_xDESVOCE,"C",160,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.m_nRowStatus,"N",0,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.m_cOldRowCPCCCHK,"C",10,0)+"");
      int l;
      for ( l = 0; CPLib.lt(l,BO.work_children.length); l = l + (1)) {
        if ( ! (CPLib.eq(BO.work_children[l],null))) {
          status.out.print(","+SPLib.ToJSValue(BO.work_children[l],"C",0,0)+"");
        } else {
          status.out.print(",''");
        }
      }
      status.out.print(")");
      k = k+1;
      if (CPLib.lt(k,BO.m_oTrs.size())) {
        status.out.print(",");
      }
    }
    status.out.println("]");
    if (CPLib.gt(l_nSelectRow,-1)) {
      BO.SetRow(l_nSelectRow);
    } else {
      BO.SetRow(0);
    }
    // Variabile che contiene il numero di riga corrente nel transitorio
    status.out.println("m_nCurrentRow="+SPLib.ToJSValue(BO.m_nCurrentRow,"N",0,0)+";");
    status.out.println("m_cOldRowCPCCCHK=\""+BO.m_cOldRowCPCCCHK+"\";");
    PrintStateDetailWorkVars_Deleted(BO,status);
  }
  static void PrintStateDetailWorkVars_Deleted(ardt_dettaglioa7BL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      ardt_dettaglioa7BO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (ardt_dettaglioa7BO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_VOCE,"C",5,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_SOTTOVOCE,"C",2,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_RESID,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PROVINCIA,"C",5,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_STATO,"C",3,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_VAL01217,"C",5,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_VAL02147,"C",5,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_VAL02148,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_VAL02149,"C",6,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DATAEFF,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IMPORTO,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDBASEA7,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CPROWNUM,"N",4,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLGRESID,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLG00015,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLG00016,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLG01217,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLG02147,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLG02148,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_FLG02149,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_xDESCRI,"C",160,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_xDESVOCE,"C",160,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.m_nRowStatus,"N",0,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.m_cOldRowCPCCCHK,"C",10,0);
        int l;
        for ( l = 0; CPLib.lt(l,l_Row.work_children.length); l = l + (1)) {
          if ( ! (CPLib.eq(l_Row.work_children[l],null))) {
            l_cTrs = l_cTrs+","+SPLib.ToJSValue(l_Row.work_children[l],"C",0,0);
          } else {
            l_cTrs = l_cTrs+",''";
          }
        }
        l_cTrs = l_cTrs+")";
        k = k+1;
        if (CPLib.lt(k,BO.m_oDeletedRows.size())) {
          l_cTrs = l_cTrs+",";
        }
      }
      l_cTrs = l_cTrs+"]";
      status.out.println("m_oDeletedRows="+l_cTrs+";");
      status.out.println("m_nRowStatus="+SPLib.ToJSValue(BO.m_nRowStatus,"N",0,0)+";");
      status.out.println("m_bHeaderUpdated="+SPLib.ToJSValue(BO.m_bHeaderUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(ardt_dettaglioa7BO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var m_oFather;");
    status.out.println("var m_bRowsChild = "+status.m_bRowsChild+";");
    status.out.println("var m_nChildStatus = " + SPLib.ToJSValue(status.m_nChildStatus,"N",0,0)+ ";");
    status.out.println("var m_bResetOnUnload = true;");
    status.out.println("var m_bChildDisabled = false;");
    if (CPLib.eq(status.m_nChildStatus,1)) {
      status.out.println("var m_cCPCCCHK = " + SPLib.ToJSValue("","C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(482,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1076,"N",0,0)+ ";");
    }
    status.out.println("var m_bCalculating = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_nUserCode = " + SPLib.ToJSValue(status.context.UserCode(),"N",0,0)+ ";");
    status.out.println("var m_GroupsList = "+"["+status.context.GetGroupsList()+"]"+";");
    status.out.println("var m_RolesList = "+"["+status.context.GetAuthority().GetCurrentAssignement().GetRoleNames()+"]"+";");
    status.out.println("var m_cCompany = " + SPLib.ToJSValue(status.context.GetCompany(),"C",0,0)+ ";");
    status.out.println("var m_cLanguage = " + SPLib.ToJSValue(status.context.GetLanguage(),"C",0,0)+ ";");
    status.out.println("var m_cUserName = " + SPLib.ToJSValue(status.context.UserName(),"C",0,0)+ ";");
    status.out.println("var m_cAltInterface = " + SPLib.ToJSValue(status.m_cAltInterface,"C",0,0)+ ";");
    status.out.println("var m_cLayerInterface = " + SPLib.ToJSValue(status.m_cLayerInterface,"C",0,0)+ ";");
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_dettaglioa7"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'GVMMKABWWU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GVMMKABWWU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,vocea7,"+"default",l_session)+"'"+"]");
      status.out.print(",'NNRZYWQBXJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NNRZYWQBXJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,sottovocea7,"+"default",l_session)+"'"+",'"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_sottovocea7",l_session)+"'"+"]");
      status.out.print(",'MDEBFTECJW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MDEBFTECJW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tb00016,"+"default",l_session)+"'"+"]");
      status.out.print(",'NHFRSWSJPA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NHFRSWSJPA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tb01217,"+"default",l_session)+"'"+",'"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_tb01217",l_session)+"'"+"]");
      status.out.print(",'KYDBUIQLMM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KYDBUIQLMM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tb02147,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'GVMMKABWWU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,vocea7,"+"default",l_session)+"'"+"]");
      status.out.print(",'NNRZYWQBXJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,sottovocea7,"+"default",l_session)+"'"+","+"'"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_sottovocea7",l_session)+"'"+"]");
      status.out.print(",'MDEBFTECJW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tb00016,"+"default",l_session)+"'"+"]");
      status.out.print(",'NHFRSWSJPA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tb01217,"+"default",l_session)+"'"+","+"'"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_tb01217",l_session)+"'"+"]");
      status.out.print(",'KYDBUIQLMM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tb02147,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    }
    status.out.println("}");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      if (CPLib.IsNull(status.m_CheckVars)) {
        status.out.print("var m_CheckVars={");
        status.out.print("'_':"+SPLib.ToJSValue(GetCheckVars(status, BO, m_cEntityUid),"C",0,0));
        status.out.println("}");
      } else {
        status.out.print("var m_CheckVars=");
        status.m_CheckVars.write(status.out);
        status.out.println(";");
      }
    }
    if (CPLib.eq(status.context.GetGlobalString("IsSPAdministrationInstalled"),"yes") && CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("var m_cProgName = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    } else {
      status.out.println("Zoom.p="+SPLib.ToJSValue(entityGlobals.name,"C",0,0)+";");
    }
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("ardt_dettaglioa7","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"ardt_dettaglioa7",BO.GetCurrentState());
    for (String disabled_item : l_vrtState.DisabledFields().split(",")) {
      if ( ! (CPLib.Empty(disabled_item))) {
        status.quoteAndAppend(disabled_item,"disable","item");
      }
    }
    for (String hidden_item : l_vrtState.HiddenFields().split(",")) {
      if ( ! (CPLib.Empty(hidden_item))) {
        status.quoteAndAppend(hidden_item,"hide","item");
      }
    }
    for (String obligatory_item : l_vrtState.ObligatoryFields().split(",")) {
      if ( ! (CPLib.Empty(obligatory_item))) {
        status.quoteAndAppend(obligatory_item,"obligatory","item");
      }
    }
    for (String disabled_tab : l_vrtState.DisabledTabs().split(",")) {
      if ( ! (CPLib.Empty(disabled_tab))) {
        status.quoteAndAppend(disabled_tab,"disable","tab");
      }
    }
    for (String hidden_tab : l_vrtState.HiddenTabs().split(",")) {
      if ( ! (CPLib.Empty(hidden_tab))) {
        status.quoteAndAppend(hidden_tab,"hide","tab");
      }
    }
    for (String hidden_box : l_vrtState.HiddenBoxes().split(",")) {
      if ( ! (CPLib.Empty(hidden_box))) {
        status.quoteAndAppend(hidden_box,"hide","box");
      }
    }
    for (String disabled_box : l_vrtState.DisabledBoxes().split(",")) {
      if ( ! (CPLib.Empty(disabled_box))) {
        status.quoteAndAppend(disabled_box,"disable","box");
      }
    }
    status.PrintStateArrays();
    status.out.println("var m_cFunction = " + SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+ ";");
    status.out.println("var m_cDataLanguage = " + SPLib.ToJSValue(CPLib.Upper(BO.m_Ctx.GetDataLanguage()),"C",0,0)+ ";");
    status.out.println("var m_cOldCPCCCHK = " + SPLib.ToJSValue(BO.m_cOldCPCCCHK,"C",0,0)+ ";");
    status.out.println("var m_bLoaded = " + SPLib.ToJSValue(BO.m_bLoaded,"L",0,0)+ ";");
    status.out.println("var m_cPrvsStt = " + SPLib.ToJSValue(BO.m_cPreviousState,"C",0,0)+ ";");
    status.out.println("var m_FoundlingCopyWorkVar;");
    status.out.println("m_FoundlingCopyWorkVar=[];");
    status.out.println("var m_FoundlingHideExpression;");
    status.out.println("m_FoundlingHideExpression=[];");
    status.out.println("var m_FoundlingEditExpression;");
    status.out.println("m_FoundlingEditExpression=[];");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
      status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastWorkVarErrorMsg = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_bStopChangeRow = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    } else {
      status.out.println("var m_nLastRec = " + SPLib.ToJSValue(status.m_nLastRec,"N",0,0)+ ";");
      status.out.println("var m_nRecPos = " + SPLib.ToJSValue(status.m_nRecPos,"N",0,0)+ ";");
      status.out.println("var m_cVirtName = " + SPLib.ToJSValue(status.m_cVirtName,"C",0,0)+ ";");
    }
    status.out.println("var m_SaveContextRepeatedChild = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cDetailBehavior = " + SPLib.ToJSValue(status.m_cDetailBehavior,"C",0,0)+ ";");
    status.out.println("var m_bAlternateColorRows = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("function TrsRow() {");
    status.out.println("if (Eq(arguments.length,1)) {");
    status.out.println("this.VOCE=w_VOCE;");
    status.out.println("this.SOTTOVOCE=w_SOTTOVOCE;");
    status.out.println("this.RESID=w_RESID;");
    status.out.println("this.PROVINCIA=w_PROVINCIA;");
    status.out.println("this.STATO=w_STATO;");
    status.out.println("this.VAL01217=w_VAL01217;");
    status.out.println("this.VAL02147=w_VAL02147;");
    status.out.println("this.VAL02148=w_VAL02148;");
    status.out.println("this.VAL02149=w_VAL02149;");
    status.out.println("this.DATAEFF=w_DATAEFF;");
    status.out.println("this.IMPORTO=w_IMPORTO;");
    status.out.println("this.IDBASEA7=w_IDBASEA7;");
    status.out.println("this.CPROWNUM=w_CPROWNUM;");
    status.out.println("this.FLGRESID=w_FLGRESID;");
    status.out.println("this.FLG00015=w_FLG00015;");
    status.out.println("this.FLG00016=w_FLG00016;");
    status.out.println("this.FLG01217=w_FLG01217;");
    status.out.println("this.FLG02147=w_FLG02147;");
    status.out.println("this.FLG02148=w_FLG02148;");
    status.out.println("this.FLG02149=w_FLG02149;");
    status.out.println("this.xDESCRI=w_xDESCRI;");
    status.out.println("this.xDESVOCE=w_xDESVOCE;");
    status.out.println("this.m_nRowStatus=arguments[0];");
    status.out.println("this.m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;");
    int l;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
      }
    }
    status.out.println("} else {");
    status.out.println("this.VOCE=arguments[0];");
    status.out.println("this.SOTTOVOCE=arguments[1];");
    status.out.println("this.RESID=arguments[2];");
    status.out.println("this.PROVINCIA=arguments[3];");
    status.out.println("this.STATO=arguments[4];");
    status.out.println("this.VAL01217=arguments[5];");
    status.out.println("this.VAL02147=arguments[6];");
    status.out.println("this.VAL02148=arguments[7];");
    status.out.println("this.VAL02149=arguments[8];");
    status.out.println("this.DATAEFF=arguments[9];");
    status.out.println("this.IMPORTO=arguments[10];");
    status.out.println("this.IDBASEA7=arguments[11];");
    status.out.println("this.CPROWNUM=arguments[12];");
    status.out.println("this.FLGRESID=arguments[13];");
    status.out.println("this.FLG00015=arguments[14];");
    status.out.println("this.FLG00016=arguments[15];");
    status.out.println("this.FLG01217=arguments[16];");
    status.out.println("this.FLG02147=arguments[17];");
    status.out.println("this.FLG02148=arguments[18];");
    status.out.println("this.FLG02149=arguments[19];");
    status.out.println("this.xDESCRI=arguments[20];");
    status.out.println("this.xDESVOCE=arguments[21];");
    status.out.println("this.m_nRowStatus=arguments[22];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[23];");
    int lastRow;
    lastRow = 24;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=arguments["+(lastRow+l)+"];");
      }
    }
    status.out.println("}");
    status.out.println("}");
    status.out.println("function TrsToWork() {");
    status.out.println("var row;");
    status.out.println("row=m_oTrs[m_nCurrentRow];");
    status.out.println("if (Ne(row,null)) {");
    status.out.println("w_VOCE=row.VOCE;");
    status.out.println("w_SOTTOVOCE=row.SOTTOVOCE;");
    status.out.println("w_RESID=row.RESID;");
    status.out.println("w_PROVINCIA=row.PROVINCIA;");
    status.out.println("w_STATO=row.STATO;");
    status.out.println("w_VAL01217=row.VAL01217;");
    status.out.println("w_VAL02147=row.VAL02147;");
    status.out.println("w_VAL02148=row.VAL02148;");
    status.out.println("w_VAL02149=row.VAL02149;");
    status.out.println("w_DATAEFF=row.DATAEFF;");
    status.out.println("w_IMPORTO=row.IMPORTO;");
    status.out.println("w_IDBASEA7=row.IDBASEA7;");
    status.out.println("w_CPROWNUM=row.CPROWNUM;");
    status.out.println("w_FLGRESID=row.FLGRESID;");
    status.out.println("w_FLG00015=row.FLG00015;");
    status.out.println("w_FLG00016=row.FLG00016;");
    status.out.println("w_FLG01217=row.FLG01217;");
    status.out.println("w_FLG02147=row.FLG02147;");
    status.out.println("w_FLG02148=row.FLG02148;");
    status.out.println("w_FLG02149=row.FLG02149;");
    status.out.println("w_xDESCRI=row.xDESCRI;");
    status.out.println("w_xDESVOCE=row.xDESVOCE;");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("m_nRowStatus=row.m_nRowStatus;");
      status.out.println("m_cOldRowCPCCCHK=row.m_cOldRowCPCCCHK;");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"=row.m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
        }
      }
      status.out.println("} else {");
      status.out.println("w_VOCE='';");
      status.out.println("w_SOTTOVOCE='';");
      status.out.println("w_RESID='1';");
      status.out.println("w_PROVINCIA='';");
      status.out.println("w_STATO='';");
      status.out.println("w_VAL01217='';");
      status.out.println("w_VAL02147='';");
      status.out.println("w_VAL02148=NullDate();");
      status.out.println("w_VAL02149='';");
      status.out.println("w_DATAEFF=NullDate();");
      status.out.println("w_IMPORTO=0;");
      status.out.println("w_IDBASEA7='';");
      status.out.println("w_CPROWNUM=0;");
      status.out.println("w_FLGRESID='';");
      status.out.println("w_FLG00015='';");
      status.out.println("w_FLG00016='';");
      status.out.println("w_FLG01217='';");
      status.out.println("w_FLG02147='';");
      status.out.println("w_FLG02148='';");
      status.out.println("w_FLG02149='';");
      status.out.println("w_xDESCRI='';");
      status.out.println("w_xDESVOCE='';");
      status.out.println("m_nRowStatus=2;");
      status.out.println("m_cOldRowCPCCCHK='';");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"='';");
        }
      }
    }
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query") && CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("SaveDependsOn();");
      status.out.println("SaveLabelDependsOn();");
    }
    status.out.println("}");
    status.out.println("_GridRowHeight='18';");
    status.out.println("CPRowNumName='w_CPROWNUM';");
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(ardt_dettaglioa7BO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("if (IsIE()) {");
    status.out.println("if (Ne(document.readyState,'complete')) {");
    status.out.println("document.onreadystatechange=OnLoad;");
    status.out.println("return;");
    status.out.println("} else {");
    status.out.println("document.onreadystatechange=null;");
    status.out.println("}");
    status.out.println("}");
    if (CPLib.eq(status.m_nChildStatus,1)) {
      status.out.println("m_oFather=window[NameForCaller()];");
    } else if (CPLib.eq(status.m_nChildStatus,2)) {
      status.out.println("m_oFather=window.parent;");
    }
    if (status.m_bAutoFill) {
      status.out.println("if (IsWndAccessible(m_oFather)) {");
      status.out.println("SetFromContext(m_oFather.m_cWv_ardt_dettaglioa7);");
      status.out.println("}");
    }
    if (CPLib.eq(status.m_nChildStatus,1)) {
      status.out.println("m_cCPCCCHK="+SPLib.ToJSValue(status.m_cFatherCPCCCHK,"C",0,0)+";");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableEntity=EnableEntityWhenReady;");
    }
    status.out.println("_IAmReady=true;");
    if ((CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) && CPLib.gt(status.m_nChildStatus,0)) {
      status.out.println("if (IsWndAccessible(m_oFather)) {");
      status.out.println("m_oFather.SetChildVariables_ardt_dettaglioa7();");
      status.out.println("}");
    }
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_dettaglioa7',Ne(m_nChildStatus,0));");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('MVCFXMIIPY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SNYJQPAYYR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDEBFTECJW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHFRSWSJPA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KYDBUIQLMM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNCQNTLDXJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNCQNTLDXJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PDCPOALMKJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OWRKSPYBFW')) SetDisabled(c,true);");
      } else if (( ! (CPLib.Empty(status.m_cAltInterface))) && CPLib.eq(status.m_cClientMode,"query")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('GVMMKABWWU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NNRZYWQBXJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MVCFXMIIPY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SNYJQPAYYR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDEBFTECJW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHFRSWSJPA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KYDBUIQLMM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNCQNTLDXJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNCQNTLDXJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PDCPOALMKJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OWRKSPYBFW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNCQNTLDXJ_ZOOM')) SetDisabled(c,false);");
      }
      status.out.println("HideControlsUnderCondition();");
    }
    status.out.println("if ( ! (Empty(m_cLayerInterface))) {");
    status.out.println("SubstituteInterface(m_cLayerInterface);");
    status.out.println("}");
    if (status.m_bError) {
      status.out.println("HideLoadingLayer();");
      status.out.println("WindowAlert(showed_database_error);");
      status.out.println("HideLoadingLayer(false);");
    }
    if ( ! (status.m_bHasRS)) {
      status.out.println("SetRegionalSettings();");
    }
    status.out.println("ReloadMenu();");
    status.out.println("setEventHandlers(false);");
    status.out.println("if (Eq(m_oFather,null)) {");
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    if (CPLib.eq(status.m_cClientMode,"query") && CPLib.gt(status.m_nChildStatus,0)) {
      status.out.println("} else if (m_bRowsChild) {");
    }
    status.out.println("}");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    if (status.HasFoundlingChildren()) {
      status.out.println("LoadContext();");
      status.out.println("LoadContext(true);");
    }
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- Fine Area Manuale");
    RaiseLoadedEntity(BO,status);
    status.out.println("CalculateAndResizeEntityHeight();");
    status.out.println("HideLoadingLayer();");
    if (status.is_live_editing) {
      status.out.println("CreateAltInterfaceEditTool(" + SPLib.ToJSValue(entityGlobals.name,"C",0,0) + ");");
    }
    if (status.m_bShowBOWarnings) {
      status.out.println("SubmitListenerForm(" + SPLib.ToJSValue(status.m_cAction,"C",0,0) + ");");
    }
    status.out.println("}");
    status.out.println("function OnUnload() {");
    status.out.println("if (IsWndAccessible(m_oFather)) {");
    status.out.println("// * --- Area Manuale = UI - OnUnload");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("if (Eq(m_nChildStatus,1) && m_bResetOnUnload) {");
    status.out.println("m_oFather.m_oardt_dettaglioa7=null;");
    status.out.println("}");
    status.out.println("}");
    status.out.println("}");
    status.out.println("function ChildSelectedPage(name) {");
    status.out.println("var l_cRes = '';");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  ardt_dettaglioa7BO getBO(ServletStatus status) {
    ardt_dettaglioa7BO BO = new ardt_dettaglioa7BO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(ardt_dettaglioa7BO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("detta7",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,ardt_dettaglioa7BO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,ardt_dettaglioa7BO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_vocea7",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",5,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("VOCE"),"C",5,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var GVMMKABWWU_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tb00015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",5,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("SIGLASV"),"C",5,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("PROVINCIA"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var SNYJQPAYYR_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    SPBridge.HMCaller _h_MDEBFTECJW = new SPBridge.HMCaller();
    _h_MDEBFTECJW.Set("tiposv","A7");
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tb00016",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_MDEBFTECJW,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("COD"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var MDEBFTECJW_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    SPBridge.HMCaller _h_NHFRSWSJPA = new SPBridge.HMCaller();
    _h_NHFRSWSJPA.Set("VOCE",BO.w_VOCE);
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tb01217",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_NHFRSWSJPA,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",5,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("COD"),"C",5,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var NHFRSWSJPA_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tb02147,CPSql.BuildSQLPhrase("COD,DESCRI",BO.m_cPhName_tb02147,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",5,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("COD"),"C",5,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var KYDBUIQLMM_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(ardt_dettaglioa7BO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_detta7;
    String l_cPhName = BO.m_cPhName_detta7;
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    // * --- Area Manuale = BO - Query Key Set Init
    // * --- Fine Area Manuale
    int l_nIdx;
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = ardt_dettaglioa7BL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_detta7+".ANNO, "+BO.m_cVirtName_detta7+".SEMESTRE"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," distinct  "+BO.m_cVirtName_detta7+".ANNO, "+BO.m_cVirtName_detta7+".SEMESTRE"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    } else {
      l_rsKeys = new CPResultSet();
    }
    l_nIdx = 1;
    while (CPLib.lt(l_nIdx,status.m_nRecPos) &&  ! (l_rsKeys.Eof())) {
      l_rsKeys.Next();
      l_nIdx = l_nIdx+1;
    }
    // * --- Area Manuale = BO - Query Key Set End
    // * --- Fine Area Manuale
    return l_rsKeys;
  }
  CPResultSet QueryKeyCursor(SPMasterServletStatus status) {
    String l_cServer = status.context.GetServer("detta7");
    String l_cPhName = CPSql.ManipulateTablePhName("detta7",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".ANNO, "+l_cPhName+".SEMESTRE"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," "+l_cPhName+".ANNO, "+l_cPhName+".SEMESTRE"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,ardt_dettaglioa7BO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = ardt_dettaglioa7BL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (CPLib.eq(CPSql.GetDataBaseType(BO.m_cServer_detta7),CPSql.m_nInformix)) {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_detta7,CPSql.BuildSQLPhrase(" count( distinct  "+BO.m_cVirtName_detta7+".ANNO, "+BO.m_cVirtName_detta7+".SEMESTRE) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_detta7,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      } else {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_detta7,CPSql.BuildSQLPhrase(" count(*) as reccount","("+CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_detta7+".ANNO, "+BO.m_cVirtName_detta7+".SEMESTRE",CPLib.GetTablesWithAliases(BO.m_cPhName_detta7,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,"")+") CountFrom","",""));
      }
      try {
        status.m_nLastRec = l_rsCount.GetInt("reccount");
        if (CPLib.eq(status.m_nLastRec,0)) {
          status.m_nRecPos = 0;
        } else {
          status.m_nRecPos = 1;
        }
      } finally {
        l_rsCount.Close();
      }
    } else {
      status.m_nRecPos = 0;
      status.m_nLastRec = 0;
    }
    status.m_cMode = "";
  }
  void View(ServletStatus status,ardt_dettaglioa7BO BO) {
    String _m = status.m_cMode;
    if ( ! (BO.m_bLoaded)) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    }
    if (CPLib.eq(status.m_nChildStatus,0)) {
      if ( ! (status.m_bError) &&  ! (BO.m_bLoaded) && CPLib.ne(_m,"empty")) {
        status.m_cErrMsg = "MSG_RECORD_NOT_FOUND";
        status.m_bError = true;
        status.m_bExit = true;
        if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
          // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
          SetWorkflowPlaceholders(status,BO);
        }
      } else {
        NotifyEvent("View",status,BO);
      }
    }
    status.m_cClientMode = "view";
  }
  void Edit(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    BO.Load(status.w_ANNO,status.w_SEMESTRE);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_VOCE = "";
        BO.w_SOTTOVOCE = "";
        BO.w_RESID = "";
        BO.w_PROVINCIA = "";
        BO.w_STATO = "";
        BO.w_VAL01217 = "";
        BO.w_VAL02147 = "";
        BO.w_VAL02148 = CPLib.NullDate();
        BO.w_VAL02149 = "";
        BO.w_DATAEFF = CPLib.NullDate();
        BO.w_IMPORTO = 0;
        BO.w_IDBASEA7 = "";
        BO.w_CPROWNUM = 0;
        BO.w_FLGRESID = "";
        BO.w_FLG00015 = "";
        BO.w_FLG00016 = "";
        BO.w_FLG01217 = "";
        BO.w_FLG02147 = "";
        BO.w_FLG02148 = "";
        BO.w_FLG02149 = "";
        BO.w_xDESCRI = "";
        BO.w_xDESVOCE = "";
        BO.m_cOldRowCPCCCHK = "";
      } else {
        BO.SetRow(0);
      }
      NotifyEvent("Edit Started",status,BO);
      // A valle dela NotifyEvent imposto le variabili passate da hyperlink e simili
      if (SetPassedWorkVars(status,BO,source,entityGlobals.keyColumns)) {
        // Posso <dimenticare> che m_cMode="hyperlink"
        status.m_cMode = "edit";
        status.m_cClientMode = "edit";
      } else {
        status.m_cClientMode = "error";
      }
    } else {
      if (BO.m_bLoaded) {
        status.m_cErrMsg = (CPLib.Empty(BO.LastErrorMessage())?"":BO.LastErrorMessage());
      } else {
        status.m_cErrMsg = "MSG_RECORD_NOT_FOUND";
      }
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cClientMode = "query";
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
    if ( ! (CPLib.IsNull(source)) && source.Has("m_OnlyContext")) {
      status.m_cClientMode = "bringback";
    }
  }
  void New(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    BO.Initialize();
    if (BO.CanAdd()) {
      NotifyEvent("New record",status,BO);
      // A valle della NotifyEvent imposto le variabili passate da hyperlink e simili
      if (CPLib.IsNull(source) || SetPassedWorkVars(status,BO,source)) {
        // Posso <dimenticare> che m_cMode="hyperlink"
        status.m_cMode = "new";
        status.m_cClientMode = "new";
      } else {
        status.m_cClientMode = "error";
      }
    } else {
      status.m_cErrMsg = BO.m_cLastMsgError;
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cClientMode = "query";
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
    if ( ! (CPLib.IsNull(source)) && source.Has("m_OnlyContext")) {
      status.m_cClientMode = "bringback";
    }
  }
  void Write(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    if (HasAllKeys(status,source)) {
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"write")) {
      status.m_bError = true;
      status.m_cClientMode = "error";
      status.m_cErrMsg = "MSG_WRITE_FAILED_FOR_KEY";
    }
    if ( ! (BO.m_bLoaded) && CPLib.eq(status.m_cAction,"writeload")) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      New(status,BO,source);
    }
    if ( ! (status.m_bError)) {
      l_bResult = BO.CanSave();
      l_bResult = l_bResult && BO.BRCanSave();
      if (l_bResult) {
        BO.m_Sql.BeginTransaction();
        l_bResult = BO.Save(true);
        l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
        l_bTrsOk = BO.m_Sql.EndTransaction();
        if (l_bResult && l_bTrsOk && BO.IsUpdated()) {
          if (BO.m_bLoaded) {
            BO.NotifyEvent("Record Updated");
          } else {
            BO.NotifyEvent("Record Inserted");
          }
        }
      }
      if ( ! (CPLib.Empty(l_cTrsMsgErr))) {
        l_bResult = false;
        l_bTrsOk = false;
        if (BO.m_Sql.CanTranslateErrorMessage()) {
          l_cTrsMsgErr = status.context.Translate("MSG_CANNOT_SAVE_DATA");
        }
      }
      if (l_bTrsOk && l_bResult) {
        status.m_bExit = true;
        status.m_cClientMode = "query";
      } else {
        status.m_bError = true;
        status.m_cClientMode = "error";
        if ( ! (l_bTrsOk)) {
          // Gestione dell'errore di transazione
          if (CPLib.ne(l_cTrsMsgErr,"")) {
            status.m_cErrMsg = l_cTrsMsgErr;
          }
        } else if ( ! (l_bResult)) {
          CheckErrorToBrowser(BO.m_nLastError,BO.LastErrorMessage(),status);
        }
      }
    }
    // la write non ha parte visuale
    status.m_cClientMode = "bringback";
  }
  void LoadCurrentRecord(ServletStatus status,ardt_dettaglioa7BO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_ANNO = "";
        status.w_SEMESTRE = "";
      } else {
        BO.w_ANNO = l_rsKeys.GetString("ANNO");
        BO.w_SEMESTRE = l_rsKeys.GetString("SEMESTRE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_ANNO = BO.w_ANNO;
        status.w_SEMESTRE = BO.w_SEMESTRE;
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_VOCE = "";
          BO.w_SOTTOVOCE = "";
          BO.w_RESID = "";
          BO.w_PROVINCIA = "";
          BO.w_STATO = "";
          BO.w_VAL01217 = "";
          BO.w_VAL02147 = "";
          BO.w_VAL02148 = CPLib.NullDate();
          BO.w_VAL02149 = "";
          BO.w_DATAEFF = CPLib.NullDate();
          BO.w_IMPORTO = 0;
          BO.w_IDBASEA7 = "";
          BO.w_CPROWNUM = 0;
          BO.w_FLGRESID = "";
          BO.w_FLG00015 = "";
          BO.w_FLG00016 = "";
          BO.w_FLG01217 = "";
          BO.w_FLG02147 = "";
          BO.w_FLG02148 = "";
          BO.w_FLG02149 = "";
          BO.w_xDESCRI = "";
          BO.w_xDESVOCE = "";
          BO.m_cOldRowCPCCCHK = "";
        } else {
          BO.SetRow(0);
        }
      }
    } finally {
      // In ogni evenienza bisogna liberare la connessione del database
      l_rsKeys.Close();
    }
    status.m_cClientMode = "query";
    if (BO.m_bLoaded &&  ! (BO.CanView())) {
      status.m_cErrMsg = BO.LastErrorMessage();
      status.m_bError = true;
      status.m_bExit = true;
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
  }
  void EditLoad(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_ANNO,status.w_SEMESTRE);
      l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
      l_bTrsOk = BO.m_Sql.EndTransaction();
      if (l_bResult && l_bTrsOk) {
        BO.NotifyEvent("Record Deleted");
        status.m_bBODeleted = true;
      }
      status.m_cClientMode = "query";
      if (l_bTrsOk) {
        if (CPLib.gt(status.m_nLastRec,1)) {
          if (CPLib.eq(status.m_nRecPos,status.m_nLastRec)) {
            status.m_nRecPos = status.m_nRecPos-1;
          }
          status.m_nLastRec = status.m_nLastRec-1;
          LoadCurrentRecord(status,BO);
        } else {
          status.m_nLastRec = 0;
          status.m_nRecPos = 0;
          BO.Blank();
        }
      } else {
        status.m_bError = true;
        // Gestione dell'errore di transazione
        if (CPLib.ne(l_cTrsMsgErr,"")) {
          status.m_cErrMsg = l_cTrsMsgErr;
        }
      }
      status.m_bExit = true;
    } else {
      status.m_bError = true;
      status.m_cClientMode = "error";
      status.m_cErrMsg = "MSG_DELETE_FAILED_FOR_KEY";
    }
    if ( ! (l_bResult) &&  ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
      SetWorkflowPlaceholders(status,BO);
    } else if (l_bBringBack) {
      status.m_cClientMode = "bringback";
    }
  }
  void DeleteMessage(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    BO.Load(status.w_ANNO,status.w_SEMESTRE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,ardt_dettaglioa7BO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    if (CheckVars(status,BO)) {
      if (( ! (BO.IsLoaded()) || status.CheckOP(BO.m_cOldCPCCCHK))) {
        l_bResult = BO.CanSave();
        l_bResult = l_bResult && BO.BRCanSave();
        if (l_bResult) {
          BO.m_Sql.BeginTransaction();
          l_bResult = BO.Save(true);
          l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
          l_bTrsOk = BO.m_Sql.EndTransaction();
          if (l_bResult && l_bTrsOk && BO.IsUpdated()) {
            if (BO.m_bLoaded) {
              BO.NotifyEvent("Record Updated");
            } else {
              BO.NotifyEvent("Record Inserted");
            }
          }
        }
        if ( ! (CPLib.Empty(l_cTrsMsgErr))) {
          l_bResult = false;
          l_bTrsOk = false;
          if (BO.m_Sql.CanTranslateErrorMessage()) {
            l_cTrsMsgErr = status.context.Translate("MSG_CANNOT_SAVE_DATA");
          }
        }
      } else {
        BO.m_cLastMsgError = "MSG_LOOK_INTO_COUNTERS";
        BO.m_nLastError = 0;
        l_bResult = false;
      }
    } else {
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cMode = "error";
      BO.m_cLastMsgError = "MSG_ERROR_SAVING_CONFIG";
      BO.m_nLastError = 0;
      l_bResult = false;
    }
    if (l_bTrsOk && l_bResult) {
      status.m_bExit = true;
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({ANNO:"+SPLib.ToJSValue(BO.w_ANNO,"C",4,0)+",SEMESTRE:"+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
      if (CPLib.eq(status.m_cMode,"new")) {
        if (CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"edit")) {
          New(status,BO,null);
        }
      } else {
        status.m_cClientMode = "query";
      }
    } else {
      status.m_bError = true;
      status.m_cClientMode = status.m_cMode;
      if ( ! (l_bTrsOk)) {
        // Gestione dell'errore di transazione
        if (CPLib.ne(l_cTrsMsgErr,"")) {
          status.m_cErrMsg = l_cTrsMsgErr;
        }
      } else if ( ! (l_bResult)) {
        CheckErrorToBrowser(BO.m_nLastError,BO.LastErrorMessage(),status);
      }
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
  }
  void Discard(ServletStatus status,ardt_dettaglioa7BO BO) {
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    if (CPLib.eq(status.m_cMode,"edit")) {
      NotifyEvent("Edit Aborted",status,BO);
    }
    // valorizzazione dei placeholder del workflow: la blank puo' cancellare i valori preesistenti
    SetWorkflowPlaceholders(status,BO);
    if (CPLib.eq(status.m_cMode,"new")) {
      NotifyEvent("New record aborted",status,BO);
      BO.Blank();
    } else if (CPLib.eq(status.m_cMode,"edit") && CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"autozoom")) {
      LoadCurrentRecord(status,BO);
    }
    status.m_cClientMode = "query";
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,ardt_dettaglioa7BO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",482);
    item.put("w",1076);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Page 1\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Page 1");
    item.put("altInterfaceFor","ardt_dettaglioa7");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"h\":16,\"name\":\"label_NPOUDYSLPC\",\"page\":1,\"spuid\":\"NPOUDYSLPC\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Sottovoce\",\"w\":72,\"x\":528,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_EYBPXHGUZY\",\"page\":1,\"spuid\":\"EYBPXHGUZY\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Voce\",\"w\":42,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":287,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"MFMHXFHWRR\",\"type\":\"BodyDetail\",\"w\":1104,\"x\":8,\"y\":26,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Residenza\",\"empty_value\":\"false\",\"fixed\":true,\"h\":20,\"maxlength\":1,\"name\":\"RESID\",\"page\":1,\"repeated\":true,\"spuid\":\"MVCFXMIIPY\",\"tabindex\":3,\"textlist\":\"1-Rapporti con soggetti residenti in Italia,2-Rapporti con soggetti non residenti in Italia\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":400,\"x\":160,\"y\":322,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QYXREWCOCK\",\"page\":1,\"spuid\":\"QYXREWCOCK\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Residenza:\",\"w\":152,\"x\":8,\"y\":326,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"fixed\":true,\"h\":20,\"maxlength\":5,\"name\":\"PROVINCIA\",\"page\":1,\"repeated\":true,\"spuid\":\"SNYJQPAYYR\",\"tabindex\":4,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":904,\"x\":160,\"y\":350,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BKLPQLOWPY\",\"page\":1,\"spuid\":\"BKLPQLOWPY\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":152,\"x\":8,\"y\":354,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato\",\"fixed\":true,\"h\":20,\"maxlength\":3,\"name\":\"STATO\",\"page\":1,\"repeated\":true,\"spuid\":\"MDEBFTECJW\",\"tabindex\":5,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":904,\"x\":160,\"y\":378,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CKEDGOYWAR\",\"page\":1,\"spuid\":\"CKEDGOYWAR\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Stato:\",\"w\":152,\"x\":8,\"y\":382,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Oggetto dei reclami\",\"fixed\":true,\"h\":20,\"maxlength\":5,\"name\":\"VAL01217\",\"page\":1,\"repeated\":true,\"spuid\":\"NHFRSWSJPA\",\"tabindex\":6,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":904,\"x\":160,\"y\":406,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DHTENWMMKQ\",\"page\":1,\"spuid\":\"DHTENWMMKQ\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Oggetto dei reclami:\",\"w\":152,\"x\":8,\"y\":410,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Restituzione\",\"fixed\":true,\"h\":20,\"maxlength\":5,\"name\":\"VAL02147\",\"page\":1,\"repeated\":true,\"spuid\":\"KYDBUIQLMM\",\"tabindex\":7,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":904,\"x\":160,\"y\":434,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NOMPGQKWQY\",\"page\":1,\"spuid\":\"NOMPGQKWQY\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Tipo Restituzione:\",\"w\":152,\"x\":8,\"y\":438,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UJZUUASOGW\",\"page\":1,\"spuid\":\"UJZUUASOGW\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Progressivo Manovra:\",\"w\":168,\"x\":256,\"y\":466,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Efficacia\",\"fixed\":true,\"h\":20,\"maxlength\":10,\"name\":\"VAL02148\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"CNCQNTLDXJ\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":160,\"y\":462,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YZSDTWZADK\",\"page\":1,\"spuid\":\"YZSDTWZADK\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Data Efficacia:\",\"w\":152,\"x\":8,\"y\":466,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Progressivo Manovra\",\"fixed\":true,\"h\":20,\"maxlength\":6,\"name\":\"VAL02149\",\"page\":1,\"repeated\":true,\"spuid\":\"PDCPOALMKJ\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":112,\"x\":424,\"y\":462,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VSGBYENSVC\",\"page\":1,\"spuid\":\"VSGBYENSVC\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Importo\\/Numero:\",\"w\":128,\"x\":832,\"y\":466,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo\\/Numero\",\"fixed\":true,\"h\":20,\"maxlength\":21,\"name\":\"IMPORTO\",\"page\":1,\"repeated\":true,\"spuid\":\"OWRKSPYBFW\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":960,\"y\":462,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":39,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HGXSNMJWYQ\",\"type\":\"Box\",\"w\":1048,\"x\":8,\"y\":6,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Voce\",\"h\":17,\"maxlength\":5,\"name\":\"VOCE\",\"page\":1,\"repeated\":true,\"spuid\":\"GVMMKABWWU\",\"tabindex\":1,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":512,\"x\":8,\"y\":28,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Sottovoce\",\"h\":17,\"maxlength\":2,\"name\":\"SOTTOVOCE\",\"page\":1,\"repeated\":true,\"spuid\":\"NNRZYWQBXJ\",\"tabindex\":2,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":528,\"x\":528,\"y\":28,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,ardt_dettaglioa7BO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_ANNO,status.w_SEMESTRE);
    if (BO.m_bLoaded) {
      while (CPLib.lt(l_nRow,BO.m_oTrs.size()) &&  ! (l_bFound)) {
        l_bFound = CPLib.eqr(source.GetParameter("CPROWNUM",0),BO.m_oTrs.get(l_nRow).w_CPROWNUM);
        if ( ! (l_bFound)) {
          l_nRow = l_nRow+1;
        }
      }
      if (l_bFound) {
        BO.SetRow(l_nRow);
        if (BO.CanDeleteRow()) {
          BO.m_Sql.BeginTransaction();
          BO.DeleteRow();
          BO.Update();
          l_bTrsOk = BO.m_Sql.EndTransaction();
          if (l_bTrsOk) {
            status.m_bBODeleted = true;
          } else {
            status.m_bError = true;
            status.m_cErrMsg = BO.m_Sql.TransactionErrorMessage();
          }
        } else {
          status.m_bError = true;
          if (CPLib.ne(BO.m_cLastMsgError,"")) {
            status.m_cErrMsg = BO.m_cLastMsgError;
          }
        }
      }
    } else {
      status.m_bError = true;
      // Gestione dell'errore di transazione
      if (CPLib.ne(BO.m_cLastMsgError,"")) {
        status.m_cErrMsg = BO.m_cLastMsgError;
      }
    }
    if (l_bBringBack) {
      status.m_cClientMode = "bringback";
    }
  }
  void WriteFormPage(ardt_dettaglioa7BO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),status.context.Translate("MSG_FORM_FUNCTION_"+status.m_cClientMode.toUpperCase())),"form");
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html " + ( SPLib.IsMobile( status.request ) && status.m_nChildStatus != 2 ? "ps-stretch": "" )+ ">" +
    "");
    status.out.println(
     "<head>" +
    "");
    status.WriteSkinnedCss();
    status.out.println(
     "<link rel='shortcut icon' href='../favicon.ico'>" +
    "");
    WriteMetaTags(status);
    String l_cJsUid;
    com.zucchetti.sitepainter.Library.WriteLegacyScripts(status.request,status.out);
    com.zucchetti.sitepainter.Library.WriteFrameworkScripts(status.request,status.out);
    status.out.println(
     "<script src='ardt_dettaglioa7?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (com.zucchetti.sitepainter.Library.IsMobile(status.request)) {
      l_cJsUid = SPPrxycizer.proxycizedPath("spmobilelib.js");
      status.out.println(
       "<script>" +
      "");
      status.out.println("if ( ! (window.SPMobileLib)) {");
      status.out.println("LibJavascript.RequireLibrary(\"../"+l_cJsUid+"\");");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    }
    status.out.println(
     "<script>" +
    "");
    status.out.println("function PlatformPathStart(p_cName) {");
    status.out.println("return p_cName;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (status.is_live_editing) {
      l_cJsUid = SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
      l_cJsUid = SPPrxycizer.proxycizedPath("LiveEditing.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    l_cJsUid = SPPrxycizer.proxycizedPath("SPBOUILib.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0)) {
      l_cJsUid = SPPrxycizer.proxycizedPath("ExtendedFields.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_dettaglioa7_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_dettaglioa7_edit.js'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      l_cJsUid = SPPrxycizer.proxycizedPath("sppainterentity.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
      PrintPainterProps(status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("function DeclareWVs() {");
      status.out.println("var a = arguments;");
      status.out.println("w_ANNO=a[0];");
      status.out.println("w_SEMESTRE=a[1];");
      status.out.println("w_VOCE=a[2];");
      status.out.println("w_SOTTOVOCE=a[3];");
      status.out.println("w_RESID=a[4];");
      status.out.println("w_PROVINCIA=a[5];");
      status.out.println("w_STATO=a[6];");
      status.out.println("w_VAL01217=a[7];");
      status.out.println("w_VAL02147=a[8];");
      status.out.println("w_VAL02148=a[9];");
      status.out.println("w_VAL02149=a[10];");
      status.out.println("w_DATAEFF=a[11];");
      status.out.println("w_IMPORTO=a[12];");
      status.out.println("w_IDBASEA7=a[13];");
      status.out.println("w_CPROWNUM=a[14];");
      status.out.println("w_FLGRESID=a[15];");
      status.out.println("w_FLG00015=a[16];");
      status.out.println("w_FLG00016=a[17];");
      status.out.println("w_FLG01217=a[18];");
      status.out.println("w_FLG02147=a[19];");
      status.out.println("w_FLG02148=a[20];");
      status.out.println("w_FLG02149=a[21];");
      status.out.println("w_xDESCRI=a[22];");
      status.out.println("w_xDESVOCE=a[23];");
      status.out.println("if (Gt(a.length,24)) {");
      status.out.println("o_VOCE=w_VOCE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CPROWNUM','SEMESTRE','ANNO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_dettaglioa7_proc.js'>" +
       "</script>" +
      "");
    }
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/styleVariables.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calendar.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calculator.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (CPLib.ne(status.m_bAutoResize,"")) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("var sv_WindowAutoResize = " + SPLib.ToJSValue(CPLib.eq(status.m_bAutoResize,"true"),"L",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/tabStrip.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    status.themeWriter.WriteInclude();
    l_cJsUid = SPPrxycizer.proxycizedPath("SPBOUILib.Row.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("tablefuncts.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    WriteStyles(BO,status);
    status.out.println(
     "<title>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate(entityGlobals.userName))+"" +
     "</title>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("AppletTag('Trs',null,true);");
    if ( ! (status.m_bHasRS)) {
      status.out.println("AppletTag('Settings','Trs');");
    }
    status.out.println("AppletTag('Wv','Trs');");
    status.out.println("m_oBodyDynamicsCombo.push(['NNRZYWQBXJ','SOTTOVOCE','C']);");
    status.out.println("AppletTag('Batch');");
    status.out.println(
     "</script>" +
    "");
    status.m_cBodyAttributes = "onload=OnLoad() onunload=OnUnload() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(482,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("AppletTag('Link');");
    }
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    status.AssignOP(BO.m_cOldCPCCCHK);
    status.WriteSenderForm(entityGlobals,BO.m_bLoaded);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
    PrintWarns(BO,status,BO.IsLoaded());
    status.out.println(
     "</html>" +
    "");
  }
  void OpenZoom(ServletStatus status,SPParameterSource source) {
    ForwardZoom("../jsp/SPPortalZoom.jsp",status,source);
  }
  void OpenPSZoom(ServletStatus status,SPParameterSource source) {
    ForwardZoom("../jsp/SPPortalZoomBase_portlet.jsp",status,source);
  }
  void ForwardZoom(String p_cForwardZoomResource,ServletStatus status,SPParameterSource source) {
    SPLib.NoCache(status.response);
    Forward f;
    f = new Forward(SPLib.GetZoomResource(p_cForwardZoomResource),false,Forward.Start,false);
    f.SetParameter("Table","detta7");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","ANNO,SEMESTRE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(ardt_dettaglioa7BO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({ANNO:"+SPLib.ToJSValue(BO.w_ANNO,"C",4,0)+",SEMESTRE:"+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(ardt_dettaglioa7BO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({ANNO:"+SPLib.ToJSValue(BO.w_ANNO,"C",4,0)+",SEMESTRE:"+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(ardt_dettaglioa7BO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({ANNO:"+SPLib.ToJSValue(BO.w_ANNO,"C",4,0)+",SEMESTRE:"+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(ardt_dettaglioa7BO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({ANNO:"+SPLib.ToJSValue(BO.w_ANNO,"C",4,0)+",SEMESTRE:"+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(ardt_dettaglioa7BO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({ANNO:"+SPLib.ToJSValue(BO.w_ANNO,"C",4,0)+",SEMESTRE:"+SPLib.ToJSValue(BO.w_SEMESTRE,"C",1,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(ardt_dettaglioa7BO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(ardt_dettaglioa7BO BO,ServletStatus status) throws IOException {
    if (CPLib.eq(BO.m_nLastError,4) || CPLib.eq(BO.m_nLastError,5)) {
      RequestPwdOrOTP(status,(CPLib.eq(BO.m_nLastError,5)?"OTP":"password"));
      return;
    }
    String msg = status.context.Translate("MSG_END_ROUTINE");
    SPLib.SetContentType(status.response);
    SPLib.NoCache(status.response);
    status.out = status.response.getWriter();
    String l_cJsUid;
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (status.m_bError) {
      msg = status.context.Translate("MSG_END_ROUTINE_WITH_MSG");
      status.out.println(
       "<body onkeydown='window.ManageKeys(event,false,false)'>" +
      "");
    } else {
      status.out.println(
       "<body>" +
      "");
    }
    status.out.println(
     "<p>" +
     ""+msg+"" +
     "</p>" +
    "");
    String l_cPreviousErr = status.m_cErrMsg;
    String l_cUserErr = status.m_cErrMsg;
    if (status.m_bError) {
      status.out.println(
       "<script>" +
      "");
      WriteJSError(status);
      l_cUserErr = status.m_cErrMsg;
      status.m_cErrMsg = l_cPreviousErr;
      status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    status.out.println(
     "<!--" +
    "");
    if (CPLib.eq(status.source.GetParameter("m_OnlyContext","_no_"),"_no_")) {
      String l_cOut;
      if (status.m_bError) {
        l_cOut = SPLib.ToJSValue("KO("+SPLib.GetWriteVarErrorName(status)+")"+UserDBMessage(status),"C",0,0);
      } else {
        l_cOut = "OK";
        if (status.m_cAction.endsWith("message")) {
          l_cOut = l_cOut+" "+SPLib.ToJSValue(status.m_cBOWarnMessageDeleted,"C",0,0);
        } else if (status.m_cAction.startsWith("delete")) {
          l_cOut = l_cOut+" "+status.m_bBODeleted;
        }
      }
      l_cOut = CPLib.ToProperties(l_cOut);
      l_cOut = com.zucchetti.sitepainter.Library.ToHTMLEuro(l_cOut);
      status.out.println("Function return value:"+l_cOut+"");
    } else {
      status.m_cErrMsg = l_cUserErr;
      status.out.println("js:BO="+SPLib.ToJSValue(BO.GetContext(),"M",0,0)+"");
    }
    status.out.println(
     " -->" +
    "");
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    /* --- Area Manuale = UI - Include */
    /* --- Fine Area Manuale */
  }
  // m_CallableNames inizializzato dal primo accesso a GetCallableNames
  private static volatile String[] m_CallableNames;
  public static String[] GetCallableNames() {
    if (CPLib.IsNull(m_CallableNames)) {
      java.util.Set building = new java.util.HashSet();
      GetCallableNames(building);
      m_CallableNames = CPLib.SetOfStringsAsArray(building);
    }
    return (String[])m_CallableNames.clone();
  }
  public static void GetCallableNames(java.util.Set callable) {
    if (CPLib.IsNull(m_CallableNames)) {
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
  }
  public String GetCheckVars(ServletStatus status,ardt_dettaglioa7BO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_ANNO),"C",4,0));
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_SEMESTRE),"C",1,0));
      }
    } else if (CPLib.eq(p_cUID,"GVMMKABWWU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NNRZYWQBXJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MDEBFTECJW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NHFRSWSJPA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KYDBUIQLMM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,ardt_dettaglioa7BO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      int l_nRow = 0;
      org.json.JSONObject _detail = status.m_CheckVars.optJSONObject("_detail");
      if (CPLib.IsNull(_detail)) {
        _detail = new org.json.JSONObject();
      }
      while (CPLib.lt(l_nRow,BO.Rows())) {
        BO.SetRow(l_nRow);
        if (BO.IsRowUpdated()) {
          org.json.JSONObject _row = _detail.optJSONObject(String.valueOf(l_nRow));
          if (CPLib.IsNull(_row)) {
            _row = new org.json.JSONObject();
          }
          if (result &&  ! (CPLib.Empty(BO.w_VOCE))) {
            a = GetCheckVars(status,BO,"GVMMKABWWU");
            b = _row.optString("GVMMKABWWU");
            result = CPLib.eq(a,b);
          }
          if (result &&  ! (CPLib.Empty(BO.w_SOTTOVOCE))) {
            a = GetCheckVars(status,BO,"NNRZYWQBXJ");
            b = _row.optString("NNRZYWQBXJ");
            result = CPLib.eq(a,b);
          }
          if (result &&  ! (CPLib.Empty(BO.w_STATO))) {
            a = GetCheckVars(status,BO,"MDEBFTECJW");
            b = _row.optString("MDEBFTECJW");
            result = CPLib.eq(a,b);
          }
          if (result &&  ! (CPLib.Empty(BO.w_VAL01217))) {
            a = GetCheckVars(status,BO,"NHFRSWSJPA");
            b = _row.optString("NHFRSWSJPA");
            result = CPLib.eq(a,b);
          }
          if (result &&  ! (CPLib.Empty(BO.w_VAL02147))) {
            a = GetCheckVars(status,BO,"KYDBUIQLMM");
            b = _row.optString("KYDBUIQLMM");
            result = CPLib.eq(a,b);
          }
        }
        l_nRow = l_nRow+1;
      }
    }
    return result;
  }
}
