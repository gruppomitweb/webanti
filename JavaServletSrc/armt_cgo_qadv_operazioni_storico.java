import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_qadv_operazioni_storico extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*cf1cf591*!";
  static public class ServletStatus extends SPMasterChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_qadv_operazioni_storico";
    }
    public String w_SNAINUMOPE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SNAINUMOPE,context,"cgo_qadv_operazioni_storico","SNAINUMOPE","C",15,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='SNAINUMOPE' type='hidden' value="+SPLib.ToHTMLValue(w_SNAINUMOPE,"C",15,0)+">" +
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
    armt_cgo_qadv_operazioni_storicoBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_qadv_operazioni_storico;
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
      status.w_SNAINUMOPE = BO.w_SNAINUMOPE;
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
    return "CGO Questionario ADV Storico";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_qadv_operazioni_storico";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 960;
    l_eg.m_nEntityHeight = 753;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_qadv_operazioni_storico"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"SNAINUMOPE"};
    l_eg.items = new SPItem[]{
                   new SPItem("QADV_DOMANDA01","N",2,0, "edit","Domanda 1"),
                   new SPItem("QADV_DOMANDA02","N",2,0, "edit","Domanda 2"),
                   new SPItem("QADV_DOMANDA03","N",2,0, "edit","Domanda 3"),
                   new SPItem("QADV_DOMANDA03_1","C",1,0, "edit","Motivo No 1"),
                   new SPItem("QADV_DOMANDA03_2","C",1,0, "edit","Motivo No 2"),
                   new SPItem("QADV_DOMANDA03_3","C",1,0, "edit","Motivo No 3"),
                   new SPItem("QADV_MOTIVO03","M",10,0, "edit","Motivo Risposta 3"),
                   new SPItem("QADV_DOMANDA04","N",2,0, "edit","Domanda 4"),
                   new SPItem("QADV_DOMANDA04_1","C",1,0, "edit","Motivo No 1"),
                   new SPItem("QADV_DOMANDA04_2","C",1,0, "edit","Motivo No2"),
                   new SPItem("QADV_DOMANDA04_3","C",1,0, "edit","Motivo No 3"),
                   new SPItem("QADV_DOMANDA04_4","C",1,0, "edit","Motivo No 4"),
                   new SPItem("QADV_DOMANDA05","N",2,0, "edit","Domanda 5"),
                   new SPItem("QADV_MOTIVO05","M",10,0, "edit","Motivo Risposta 4"),
                   new SPItem("QADV_DOMANDA06","N",2,0, "edit","Domanda 6"),
                   new SPItem("QADV_DOMANDA07","N",2,0, "edit","Domanda 7"),
                   new SPItem("QADV_DOMANDA08","N",2,0, "edit","Domanda 8"),
                   new SPItem("QADV_DOMANDA09","N",2,0, "edit","Domanda 9"),
                   new SPItem("QADV_DOMANDA10","N",2,0, "edit","Domanda 10"),
                   new SPItem("QADV_DOMANDA11","N",2,0, "edit","Domanda 11"),
                   new SPItem("QADV_DOMANDA12","N",2,0, "edit","Domanda 12"),
                   new SPItem("SNAINUMOPE","C",15,0, "hide","N. Operazione"),
                   new SPItem("QADV_PUNTEGGIO01","N",3,0, "show","Punteggio Domanda 1"),
                   new SPItem("QADV_PUNTEGGIO02","N",3,0, "show","Punteggio Domanda 2"),
                   new SPItem("QADV_PUNTEGGIO03","N",3,0, "show","Punteggio Domanda 3"),
                   new SPItem("QADV_PUNTEGGIO04","N",3,0, "show","Punteggio Domanda 4"),
                   new SPItem("QADV_MOTIVO04","M",10,0, "edit","Motivo Risposta 4"),
                   new SPItem("QADV_PUNTEGGIO05","N",3,0, "show","Punteggio Domanda 5"),
                   new SPItem("QADV_PUNTEGGIO06","N",3,0, "show","Punteggio Domanda 6"),
                   new SPItem("QADV_PUNTEGGIO07","N",3,0, "show","Punteggio Domanda 7"),
                   new SPItem("QADV_PUNTEGGIO08","N",3,0, "show","Punteggio Domanda 8"),
                   new SPItem("QADV_PUNTEGGIO09","N",3,0, "show","Punteggio Domanda 9"),
                   new SPItem("QADV_PUNTEGGIO10","N",3,0, "show","Punteggio Domanda 10"),
                   new SPItem("QADV_PUNTEGGIO11","N",3,0, "show","Punteggio Domanda 11"),
                   new SPItem("QADV_PUNTEGGIO12","N",3,0, "show","Punteggio Domanda 12"),
                   new SPItem("QADV_FLGCOMPLETO","C",1,0, "edit","Questionario Completo"),
                   new SPItem("QADV_TOTALE","N",3,0, "show","Punteggio Questionario")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_qadv_operazioni_storicoBO BO) {
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
    l_translations=new String[][]{{"10663169693",p_Context.Translate("Comportamento Sospetto")},
    {"10775655593",p_Context.Translate("Assenza Vincita")},
    {"11098511157",p_Context.Translate("Affluenza Eccessiva")},
    {"11302053008",p_Context.Translate("Punteggio Domanda 12")},
    {"11302057104",p_Context.Translate("Punteggio Domanda 11")},
    {"11302061200",p_Context.Translate("Punteggio Domanda 10")},
    {"11302255760",p_Context.Translate("Punteggio Domanda 9")},
    {"11302256016",p_Context.Translate("Punteggio Domanda 8")},
    {"11302256272",p_Context.Translate("Punteggio Domanda 7")},
    {"11302256528",p_Context.Translate("Punteggio Domanda 6")},
    {"11302256784",p_Context.Translate("Punteggio Domanda 5")},
    {"11302257040",p_Context.Translate("Punteggio Domanda 4")},
    {"11302257296",p_Context.Translate("Punteggio Domanda 3")},
    {"11302257552",p_Context.Translate("Punteggio Domanda 2")},
    {"11302257808",p_Context.Translate("Punteggio Domanda 1")},
    {"11339591926",p_Context.Translate("Motivo Risposta 4")},
    {"11339591927",p_Context.Translate("Motivo Risposta 3")},
    {"11385126830",p_Context.Translate("Personale Impegnato in Altro")},
    {"11713788590",p_Context.Translate("Questionario Completo")},
    {"11993250504",p_Context.Translate("N. Operazione")},
    {"124587724",p_Context.Translate("Motivo No2")},
    {"124599980",p_Context.Translate("Motivo No 1")},
    {"124600236",p_Context.Translate("Motivo No 2")},
    {"124600492",p_Context.Translate("Motivo No 3")},
    {"124600748",p_Context.Translate("Motivo No 4")},
    {"1720232937",p_Context.Translate("CGO Questionario ADV Storico")},
    {"1739883621",p_Context.Translate("Domanda 1")},
    {"1739883622",p_Context.Translate("Domanda 2")},
    {"1739883623",p_Context.Translate("Domanda 3")},
    {"1739883624",p_Context.Translate("Domanda 4")},
    {"1739883625",p_Context.Translate("Domanda 5")},
    {"1739883626",p_Context.Translate("Domanda 6")},
    {"1739883627",p_Context.Translate("Domanda 7")},
    {"1739883628",p_Context.Translate("Domanda 8")},
    {"1739883629",p_Context.Translate("Domanda 9")},
    {"1739884389",p_Context.Translate("Domanda 10")},
    {"1739884405",p_Context.Translate("Domanda 11")},
    {"1739884421",p_Context.Translate("Domanda 12")},
    {"282714462",p_Context.Translate("Punteggio Questionario")},
    {"286003410",p_Context.Translate("Tempo di gioco molto breve (meno di 10 minuti)")},
    {"302754130",p_Context.Translate("Questionario completato")},
    {"7772929",p_Context.Translate("Altro")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_qadv_operazioni_storico.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_qadv_operazioni_storico',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_qadv_operazioni_storico",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:753px;width:960px;display:none'>" +
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
  void WriteControls_p1_b0(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:753px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA01' id='QISCOZIXKK' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA01)?"SELECTED":"")+">" +
     ""+status.context.Translate("Meno di 10")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA01)?"SELECTED":"")+">" +
     ""+status.context.Translate("Tra 10 e 20")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_QADV_DOMANDA01)?"SELECTED":"")+">" +
     ""+status.context.Translate("Tra 20 e 30")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(4,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(4,BO.w_QADV_DOMANDA01)?"SELECTED":"")+">" +
     ""+status.context.Translate("Oltre i 30")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('QISCOZIXKK'),w_QADV_DOMANDA01,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA02' id='WBZKOKXYXU' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA02)?"SELECTED":"")+">" +
     ""+status.context.Translate("Cliente fisso (tutti i giorni)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA02)?"SELECTED":"")+">" +
     ""+status.context.Translate("Cliente abituale (almeno 2gg alla settimana)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_QADV_DOMANDA02)?"SELECTED":"")+">" +
     ""+status.context.Translate("Saltuario (Al max 1 volta alla settimana)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(4,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(4,BO.w_QADV_DOMANDA02)?"SELECTED":"")+">" +
     ""+status.context.Translate("Occasionale - Mai visto prima")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('WBZKOKXYXU'),w_QADV_DOMANDA02,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA03' id='FQNOXMHNDA' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA03)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA03)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('FQNOXMHNDA'),w_QADV_DOMANDA03,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ZZAXIZEFKI_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA03_1' id='ZZAXIZEFKI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA03_1,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA03_1))?"CHECKED":"")+">" +
     "<label id='ZZAXIZEFKI_LBL' for='ZZAXIZEFKI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Affluenza Eccessiva"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='YMMKALGQQM_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA03_2' id='YMMKALGQQM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA03_2,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA03_2))?"CHECKED":"")+">" +
     "<label id='YMMKALGQQM_LBL' for='YMMKALGQQM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Personale Impegnato in Altro"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='TIXQDCBYJJ_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA03_3' id='TIXQDCBYJJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA03_3,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA03_3))?"CHECKED":"")+">" +
     "<label id='TIXQDCBYJJ_LBL' for='TIXQDCBYJJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Altro"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<textarea name='QADV_MOTIVO03' id='HOWAZKTGQK' class='"+status.ObligatoryClass("Memo",BO.HOWAZKTGQK_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2' style='display:none'>" +
     "</textarea>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA04' id='ATNBYAZJII' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA04)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA04)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('ATNBYAZJII'),w_QADV_DOMANDA04,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='KBUHMXAJEA_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA04_1' id='KBUHMXAJEA' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA04_1,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA04_1))?"CHECKED":"")+">" +
     "<label id='KBUHMXAJEA_LBL' for='KBUHMXAJEA' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Assenza Vincita"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='TJQKPGPGYX_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA04_2' id='TJQKPGPGYX' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA04_2,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA04_2))?"CHECKED":"")+">" +
     "<label id='TJQKPGPGYX_LBL' for='TJQKPGPGYX' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tempo di gioco molto breve (meno di 10 minuti)"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='SAFBZXXNOG_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA04_3' id='SAFBZXXNOG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA04_3,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA04_3))?"CHECKED":"")+">" +
     "<label id='SAFBZXXNOG_LBL' for='SAFBZXXNOG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Comportamento Sospetto"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='AJOULWEBQJ_DIV' style='display:none'>" +
     "<input name='QADV_DOMANDA04_4' id='AJOULWEBQJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_DOMANDA04_4,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_DOMANDA04_4))?"CHECKED":"")+">" +
     "<label id='AJOULWEBQJ_LBL' for='AJOULWEBQJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Altro"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA05' id='GQFWKUDIZX' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA05)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Richiesta pagamento cash oltre soglia")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA05)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Richiesta intestazione assegno ad altro soggetto")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_QADV_DOMANDA05)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Richiesta di bonifico a conto non intestato")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(4,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(4,BO.w_QADV_DOMANDA05)?"SELECTED":"")+">" +
     ""+status.context.Translate("No: Indicatore ticket nella norma")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(5,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(5,BO.w_QADV_DOMANDA05)?"SELECTED":"")+">" +
     ""+status.context.Translate("No: Indicatori di condotta e di gioco regolari")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(6,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(6,BO.w_QADV_DOMANDA05)?"SELECTED":"")+">" +
     ""+status.context.Translate("No: Altro")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('GQFWKUDIZX'),w_QADV_DOMANDA05,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<textarea name='QADV_MOTIVO05' id='NAOHLRJFKW' class='"+status.ObligatoryClass("Memo",BO.NAOHLRJFKW_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2' style='display:none'>" +
     "</textarea>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA06' id='NXAIQESKYE' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA06)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA06)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('NXAIQESKYE'),w_QADV_DOMANDA06,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA07' id='TANVFQSZEQ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA07)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Libero Professionista")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA07)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Commerciante-Artigiano")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_QADV_DOMANDA07)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Imprenditore")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(4,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(4,BO.w_QADV_DOMANDA07)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Dipendente")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(5,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(5,BO.w_QADV_DOMANDA07)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Altro")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(6,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(6,BO.w_QADV_DOMANDA07)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('TANVFQSZEQ'),w_QADV_DOMANDA07,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA08' id='OUKEHIZPFY' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA08)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA08)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Il cliente non gradisce fornire informazioni")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_QADV_DOMANDA08)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si: Il cliente ha fornito informazioni sul punto")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('OUKEHIZPFY'),w_QADV_DOMANDA08,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA09' id='CTLRUBZHIS' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA09)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA09)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('CTLRUBZHIS'),w_QADV_DOMANDA09,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA10' id='BJMTLOURHC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA10)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA10)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('BJMTLOURHC'),w_QADV_DOMANDA10,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA11' id='YOEMCDHBCJ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA11)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA11)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('YOEMCDHBCJ'),w_QADV_DOMANDA11,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='QADV_DOMANDA12' id='RGKOIXTSHJ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_QADV_DOMANDA12)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_QADV_DOMANDA12)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('RGKOIXTSHJ'),w_QADV_DOMANDA12,'N');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HVOXPQWYNJ_DIV'>" +
     "<label id='HVOXPQWYNJ' for='QISCOZIXKK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("1. Presenze clienti in sala al momento della presentazione del ticket:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO01' id='OECUQDKYXU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO01,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YAVCLUSAVL_DIV'>" +
     "<label id='YAVCLUSAVL' for='WBZKOKXYXU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("2. Il presentatore del ticket è:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO02' id='JJYJUWYAKE' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO02,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VMTTCEOZYW_DIV'>" +
     "<label id='VMTTCEOZYW' for='FQNOXMHNDA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("3. La realizzazione della vincita è stato oggetto di visione dal personale?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO03' id='UVWAAAVUWZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO03,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JPWJVELENU_DIV'>" +
     "<label id='JPWJVELENU' for='ATNBYAZJII'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("4. Il ticket presenta anomalie?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO04' id='FFUQSVAYEB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO04,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<textarea name='QADV_MOTIVO04' id='IPNCGLSXHQ' class='"+status.ObligatoryClass("Memo",BO.IPNCGLSXHQ_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2' style='display:none'>" +
     "</textarea>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RBOEXYCQKR_DIV'>" +
     "<label id='RBOEXYCQKR' for='GQFWKUDIZX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("5. La vincita presenta anomalie:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO05' id='XOTWBTARMT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO05,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HURAWBJINT_DIV'>" +
     "<label id='HURAWBJINT' for='NXAIQESKYE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("6. Si è in grado di garantire che il presentatore del ticket è il medesimo soggetto che ha realizzato la vincita?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO06' id='JGBGHVXNJF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO06,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UVKJPSBTQL_DIV'>" +
     "<label id='UVKJPSBTQL' for='TANVFQSZEQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("7. La sala conosce l'attività lavorativa del cliente?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO07' id='DHWGKFUJOL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO07,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ETFQYWJUTI_DIV'>" +
     "<label id='ETFQYWJUTI' for='OUKEHIZPFY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("8. In questo caso (no alla 7) si è in grado comunque di ipotizzare la provenienza delle somme impiegate al gioco?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO08' id='ARUMVNSASG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO08,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AOXLXNKIET_DIV'>" +
     "<label id='AOXLXNKIET' for='CTLRUBZHIS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("9. Il cliente passa tempo in sala anche senza giocare?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO09' id='VNHCROEXJK' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO09,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TLTEZRKXTA_DIV'>" +
     "<label id='TLTEZRKXTA' for='BJMTLOURHC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("10. Il cliente appare amico di altri clienti o sembra conoscerne altri?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO10' id='XNYSEMUDNB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO10,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IEKBDQWIOD_DIV'>" +
     "<label id='IEKBDQWIOD' for='YOEMCDHBCJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("11. Il cliente conosce le procedure antiriciclaggio?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO11' id='XVAODNFUGF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO11,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LWMEEVTYOG_DIV'>" +
     "<label id='LWMEEVTYOG' for='RGKOIXTSHJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("12. Il cliente è solito chiedere l'emissione di un ticket per giocare?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_PUNTEGGIO12' id='CASIBCNBDS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_PUNTEGGIO12,"N",3,0,"999", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='RVNBZEITUY_DIV'>" +
     "<input name='QADV_FLGCOMPLETO' id='RVNBZEITUY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_QADV_FLGCOMPLETO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_QADV_FLGCOMPLETO))?"CHECKED":"")+">" +
     "<label id='RVNBZEITUY_LBL' for='RVNBZEITUY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Questionario completato"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QFUTYXKNVG_DIV' style='display:none'>" +
     "<label id='QFUTYXKNVG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Se No (Motivo): "))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UICEKEORFQ_DIV' style='display:none'>" +
     "<label id='UICEKEORFQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Se Si (Motivo): "))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='QADV_TOTALE' id='FARFBCSTGE' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_QADV_TOTALE,"N",3,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DLXVZPWPDL_DIV' style='display:none'>" +
     "<label id='DLXVZPWPDL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Punteggio"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SZQOSRCBBI_DIV' style='display:none'>" +
     "<label id='SZQOSRCBBI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Totale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_cgo_qadv_operazioni_storicoBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_qadv_operazioni_storicoBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_cgo_qadv_operazioni_storicoBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_QADV_DOMANDA01,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA02,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA03,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA03_1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA03_2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA03_3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_MOTIVO03,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA04,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA04_1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA04_2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA04_3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA04_4,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA05,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_MOTIVO05,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA06,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA07,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA08,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA09,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA10,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA11,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_DOMANDA12,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO01,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO02,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO03,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO04,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_MOTIVO04,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO05,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO06,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO07,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO08,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO09,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO10,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO11,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_PUNTEGGIO12,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_FLGCOMPLETO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_QADV_TOTALE,"N",3,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(753,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(960,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_qadv_operazioni_storico"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      AppendCallableIDS(status,"");
    } else {
      AppendCallableIDS(status,"");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_qadv_operazioni_storico","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_qadv_operazioni_storico",BO.GetCurrentState());
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
    } else {
      status.out.println("var m_nLastRec = " + SPLib.ToJSValue(status.m_nLastRec,"N",0,0)+ ";");
      status.out.println("var m_nRecPos = " + SPLib.ToJSValue(status.m_nRecPos,"N",0,0)+ ";");
      status.out.println("var m_cVirtName = " + SPLib.ToJSValue(status.m_cVirtName,"C",0,0)+ ";");
    }
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
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
      status.out.println("SetFromContext(m_oFather.m_cWv_armt_cgo_qadv_operazioni_storico);");
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
      status.out.println("m_oFather.SetChildVariables_armt_cgo_qadv_operazioni_storico();");
      status.out.println("}");
    }
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_qadv_operazioni_storico',Ne(m_nChildStatus,0));");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('QISCOZIXKK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WBZKOKXYXU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FQNOXMHNDA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZZAXIZEFKI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YMMKALGQQM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TIXQDCBYJJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HOWAZKTGQK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATNBYAZJII')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KBUHMXAJEA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TJQKPGPGYX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SAFBZXXNOG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AJOULWEBQJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GQFWKUDIZX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NAOHLRJFKW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NXAIQESKYE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TANVFQSZEQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OUKEHIZPFY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CTLRUBZHIS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BJMTLOURHC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YOEMCDHBCJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RGKOIXTSHJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IPNCGLSXHQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RVNBZEITUY')) SetDisabled(c,true);");
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
      status.out.println("SetDisabled('QISCOZIXKK',m_bRowsChild);");
      status.out.println("SetDisabled('WBZKOKXYXU',m_bRowsChild);");
      status.out.println("SetDisabled('FQNOXMHNDA',m_bRowsChild);");
      status.out.println("SetDisabled('ZZAXIZEFKI',m_bRowsChild);");
      status.out.println("SetDisabled('YMMKALGQQM',m_bRowsChild);");
      status.out.println("SetDisabled('TIXQDCBYJJ',m_bRowsChild);");
      status.out.println("SetDisabled('HOWAZKTGQK',m_bRowsChild);");
      status.out.println("SetDisabled('ATNBYAZJII',m_bRowsChild);");
      status.out.println("SetDisabled('KBUHMXAJEA',m_bRowsChild);");
      status.out.println("SetDisabled('TJQKPGPGYX',m_bRowsChild);");
      status.out.println("SetDisabled('SAFBZXXNOG',m_bRowsChild);");
      status.out.println("SetDisabled('AJOULWEBQJ',m_bRowsChild);");
      status.out.println("SetDisabled('GQFWKUDIZX',m_bRowsChild);");
      status.out.println("SetDisabled('NAOHLRJFKW',m_bRowsChild);");
      status.out.println("SetDisabled('NXAIQESKYE',m_bRowsChild);");
      status.out.println("SetDisabled('TANVFQSZEQ',m_bRowsChild);");
      status.out.println("SetDisabled('OUKEHIZPFY',m_bRowsChild);");
      status.out.println("SetDisabled('CTLRUBZHIS',m_bRowsChild);");
      status.out.println("SetDisabled('BJMTLOURHC',m_bRowsChild);");
      status.out.println("SetDisabled('YOEMCDHBCJ',m_bRowsChild);");
      status.out.println("SetDisabled('RGKOIXTSHJ',m_bRowsChild);");
      status.out.println("SetDisabled('OECUQDKYXU',m_bRowsChild);");
      status.out.println("SetDisabled('JJYJUWYAKE',m_bRowsChild);");
      status.out.println("SetDisabled('UVWAAAVUWZ',m_bRowsChild);");
      status.out.println("SetDisabled('FFUQSVAYEB',m_bRowsChild);");
      status.out.println("SetDisabled('IPNCGLSXHQ',m_bRowsChild);");
      status.out.println("SetDisabled('XOTWBTARMT',m_bRowsChild);");
      status.out.println("SetDisabled('JGBGHVXNJF',m_bRowsChild);");
      status.out.println("SetDisabled('DHWGKFUJOL',m_bRowsChild);");
      status.out.println("SetDisabled('ARUMVNSASG',m_bRowsChild);");
      status.out.println("SetDisabled('VNHCROEXJK',m_bRowsChild);");
      status.out.println("SetDisabled('XNYSEMUDNB',m_bRowsChild);");
      status.out.println("SetDisabled('XVAODNFUGF',m_bRowsChild);");
      status.out.println("SetDisabled('CASIBCNBDS',m_bRowsChild);");
      status.out.println("SetDisabled('RVNBZEITUY',m_bRowsChild);");
      status.out.println("SetDisabled('FARFBCSTGE',m_bRowsChild);");
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
    status.out.println("m_oFather.m_oarmt_cgo_qadv_operazioni_storico=null;");
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
  armt_cgo_qadv_operazioni_storicoBO getBO(ServletStatus status) {
    armt_cgo_qadv_operazioni_storicoBO BO = new armt_cgo_qadv_operazioni_storicoBO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(armt_cgo_qadv_operazioni_storicoBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_qadv_operazioni_storico",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_qadv_operazioni_storico;
    String l_cPhName = BO.m_cPhName_cgo_qadv_operazioni_storico;
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
      String l_cQueryFilter = armt_cgo_qadv_operazioni_storicoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_qadv_operazioni_storico+".SNAINUMOPE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_qadv_operazioni_storico");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_qadv_operazioni_storico",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".SNAINUMOPE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_qadv_operazioni_storicoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_qadv_operazioni_storico,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_qadv_operazioni_storico,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
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
  void Edit(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,SPParameterSource source) {
    BO.Load(status.w_SNAINUMOPE);
    if (BO.m_bLoaded && BO.CanEdit()) {
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
  void New(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_SNAINUMOPE = "";
      } else {
        BO.w_SNAINUMOPE = l_rsKeys.GetString("SNAINUMOPE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_SNAINUMOPE = BO.w_SNAINUMOPE;
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
  void EditLoad(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_SNAINUMOPE);
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
  void DeleteMessage(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,SPParameterSource source) {
    BO.Load(status.w_SNAINUMOPE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",753);
    item.put("w",960);
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
    item.put("altInterfaceFor","armt_cgo_qadv_operazioni_storico");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"Domanda 1\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA01\",\"page\":1,\"spuid\":\"QISCOZIXKK\",\"tabindex\":1,\"textlist\":\"Meno di 10,Tra 10 e 20,Tra 20 e 30,Oltre i 30\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3,4\",\"w\":432,\"x\":8,\"y\":31,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HVOXPQWYNJ\",\"page\":1,\"spuid\":\"HVOXPQWYNJ\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"1. Presenze clienti in sala al momento della presentazione del ticket:\",\"w\":588,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 1\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO01\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OECUQDKYXU\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":31,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":19,\"name\":\"label_DLXVZPWPDL\",\"page\":1,\"spuid\":\"DLXVZPWPDL\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Punteggio\",\"w\":71,\"x\":889,\"y\":0,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 2\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA02\",\"page\":1,\"spuid\":\"WBZKOKXYXU\",\"tabindex\":2,\"textlist\":\"Cliente fisso (tutti i giorni),Cliente abituale (almeno 2gg alla settimana),Saltuario (Al max 1 volta alla settimana),Occasionale - Mai visto prima\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3,4\",\"w\":432,\"x\":8,\"y\":80,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_YAVCLUSAVL\",\"page\":1,\"spuid\":\"YAVCLUSAVL\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"2. Il presentatore del ticket \\u00E8:\",\"w\":588,\"x\":8,\"y\":59,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 2\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO02\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"JJYJUWYAKE\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":80,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 3\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA03\",\"page\":1,\"spuid\":\"FQNOXMHNDA\",\"tabindex\":3,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":129,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_VMTTCEOZYW\",\"page\":1,\"spuid\":\"VMTTCEOZYW\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"3. La realizzazione della vincita \\u00E8 stato oggetto di visione dal personale?\",\"w\":588,\"x\":8,\"y\":108,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No 1\",\"h\":21,\"label_text\":\"Affluenza Eccessiva\",\"maxlength\":1,\"name\":\"QADV_DOMANDA03_1\",\"page\":1,\"spuid\":\"ZZAXIZEFKI\",\"tabindex\":4,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":115,\"x\":96,\"y\":157,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No 2\",\"h\":21,\"label_text\":\"Personale Impegnato in Altro\",\"maxlength\":1,\"name\":\"QADV_DOMANDA03_2\",\"page\":1,\"spuid\":\"YMMKALGQQM\",\"tabindex\":5,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":200,\"x\":224,\"y\":157,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QFUTYXKNVG\",\"page\":1,\"spuid\":\"QFUTYXKNVG\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Se No (Motivo): \",\"w\":85,\"x\":8,\"y\":157,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No 3\",\"h\":21,\"label_text\":\"Altro\",\"maxlength\":1,\"name\":\"QADV_DOMANDA03_3\",\"page\":1,\"spuid\":\"TIXQDCBYJJ\",\"tabindex\":6,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":115,\"x\":96,\"y\":178,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Motivo Risposta 3\",\"h\":63,\"name\":\"QADV_MOTIVO03\",\"page\":1,\"scroll\":true,\"spuid\":\"HOWAZKTGQK\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":472,\"x\":448,\"y\":129,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 3\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO03\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"UVWAAAVUWZ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":129,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 4\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA04\",\"page\":1,\"spuid\":\"ATNBYAZJII\",\"tabindex\":8,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":227,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_JPWJVELENU\",\"page\":1,\"spuid\":\"JPWJVELENU\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"4. Il ticket presenta anomalie?\",\"w\":588,\"x\":8,\"y\":206,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No 1\",\"h\":21,\"label_text\":\"Assenza Vincita\",\"maxlength\":1,\"name\":\"QADV_DOMANDA04_1\",\"page\":1,\"spuid\":\"KBUHMXAJEA\",\"tabindex\":9,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":104,\"x\":96,\"y\":254,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No 3\",\"h\":21,\"label_text\":\"Comportamento Sospetto\",\"maxlength\":1,\"name\":\"QADV_DOMANDA04_3\",\"page\":1,\"spuid\":\"SAFBZXXNOG\",\"tabindex\":11,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":152,\"x\":256,\"y\":255,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_UICEKEORFQ\",\"page\":1,\"spuid\":\"UICEKEORFQ\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Se Si (Motivo): \",\"w\":85,\"x\":8,\"y\":255,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No2\",\"h\":21,\"label_text\":\"Tempo di gioco molto breve (meno di 10 minuti)\",\"maxlength\":1,\"name\":\"QADV_DOMANDA04_2\",\"page\":1,\"spuid\":\"TJQKPGPGYX\",\"tabindex\":10,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":272,\"x\":96,\"y\":276,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Motivo No 4\",\"h\":21,\"label_text\":\"Altro\",\"maxlength\":1,\"name\":\"QADV_DOMANDA04_4\",\"page\":1,\"spuid\":\"AJOULWEBQJ\",\"tabindex\":12,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":64,\"x\":376,\"y\":276,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 5\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA05\",\"page\":1,\"spuid\":\"GQFWKUDIZX\",\"tabindex\":13,\"textlist\":\"Si: Richiesta pagamento cash oltre soglia,Si: Richiesta intestazione assegno ad altro soggetto,Si: Richiesta di bonifico a conto non intestato,No: Indicatore ticket nella norma,No: Indicatori di condotta e di gioco regolari,No: Altro\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3,4,5,6\",\"w\":432,\"x\":8,\"y\":332,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_RBOEXYCQKR\",\"page\":1,\"spuid\":\"RBOEXYCQKR\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"5. La vincita presenta anomalie:\",\"w\":588,\"x\":8,\"y\":311,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Motivo Risposta 4\",\"h\":42,\"name\":\"QADV_MOTIVO05\",\"page\":1,\"scroll\":true,\"spuid\":\"NAOHLRJFKW\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":472,\"x\":448,\"y\":332,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 5\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO05\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XOTWBTARMT\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":332,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 6\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA06\",\"page\":1,\"spuid\":\"NXAIQESKYE\",\"tabindex\":15,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":402,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HURAWBJINT\",\"page\":1,\"spuid\":\"HURAWBJINT\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"6. Si \\u00E8 in grado di garantire che il presentatore del ticket \\u00E8 il medesimo soggetto che ha realizzato la vincita?\",\"w\":588,\"x\":8,\"y\":381,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 6\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO06\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"JGBGHVXNJF\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":402,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 7\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA07\",\"page\":1,\"spuid\":\"TANVFQSZEQ\",\"tabindex\":16,\"textlist\":\"Si: Libero Professionista,Si: Commerciante-Artigiano,Si: Imprenditore,Si: Dipendente,Si: Altro,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3,4,5,6\",\"w\":432,\"x\":8,\"y\":451,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_UVKJPSBTQL\",\"page\":1,\"spuid\":\"UVKJPSBTQL\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"7. La sala conosce l"+"'"+"attivit\\u00E0 lavorativa del cliente?\",\"w\":588,\"x\":8,\"y\":430,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 7\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO07\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DHWGKFUJOL\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":451,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 8\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA08\",\"page\":1,\"spuid\":\"OUKEHIZPFY\",\"tabindex\":17,\"textlist\":\"No,Si: Il cliente non gradisce fornire informazioni,Si: Il cliente ha fornito informazioni sul punto\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3\",\"w\":432,\"x\":8,\"y\":500,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ETFQYWJUTI\",\"page\":1,\"spuid\":\"ETFQYWJUTI\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"8. In questo caso (no alla 7) si \\u00E8 in grado comunque di ipotizzare la provenienza delle somme impiegate al gioco?\",\"w\":588,\"x\":8,\"y\":479,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 8\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO08\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ARUMVNSASG\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":500,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 9\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA09\",\"page\":1,\"spuid\":\"CTLRUBZHIS\",\"tabindex\":18,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":549,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_AOXLXNKIET\",\"page\":1,\"spuid\":\"AOXLXNKIET\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"9. Il cliente passa tempo in sala anche senza giocare?\",\"w\":588,\"x\":8,\"y\":528,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 9\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO09\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VNHCROEXJK\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":549,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 10\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA10\",\"page\":1,\"spuid\":\"BJMTLOURHC\",\"tabindex\":19,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":598,\"zone\":\"pag1_23\",\"zonepath\":\"[1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_TLTEZRKXTA\",\"page\":1,\"spuid\":\"TLTEZRKXTA\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"10. Il cliente appare amico di altri clienti o sembra conoscerne altri?\",\"w\":588,\"x\":8,\"y\":577,\"zone\":\"pag1_23\",\"zonepath\":\"[1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 10\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO10\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XNYSEMUDNB\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":598,\"zone\":\"pag1_24\",\"zonepath\":\"[1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 11\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA11\",\"page\":1,\"spuid\":\"YOEMCDHBCJ\",\"tabindex\":20,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":647,\"zone\":\"pag1_25\",\"zonepath\":\"[1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_IEKBDQWIOD\",\"page\":1,\"spuid\":\"IEKBDQWIOD\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"11. Il cliente conosce le procedure antiriciclaggio?\",\"w\":588,\"x\":8,\"y\":626,\"zone\":\"pag1_25\",\"zonepath\":\"[1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 11\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO11\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XVAODNFUGF\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":647,\"zone\":\"pag1_26\",\"zonepath\":\"[1,26]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domanda 12\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":5,\"name\":\"QADV_DOMANDA12\",\"page\":1,\"spuid\":\"RGKOIXTSHJ\",\"tabindex\":21,\"textlist\":\"Si,No\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2\",\"w\":432,\"x\":8,\"y\":696,\"zone\":\"pag1_27\",\"zonepath\":\"[1,27]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LWMEEVTYOG\",\"page\":1,\"spuid\":\"LWMEEVTYOG\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"12. Il cliente \\u00E8 solito chiedere l"+"'"+"emissione di un ticket per giocare?\",\"w\":588,\"x\":8,\"y\":675,\"zone\":\"pag1_27\",\"zonepath\":\"[1,27]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 12\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO12\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"CASIBCNBDS\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":696,\"zone\":\"pag1_28\",\"zonepath\":\"[1,28]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Questionario\",\"disabled\":\"true\",\"h\":23,\"maxlength\":4,\"name\":\"QADV_TOTALE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FARFBCSTGE\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":48,\"x\":912,\"y\":728,\"zone\":\"pag1_29\",\"zonepath\":\"[1,29]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":19,\"name\":\"label_SZQOSRCBBI\",\"page\":1,\"spuid\":\"SZQOSRCBBI\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Totale:\",\"w\":59,\"x\":851,\"y\":734,\"zone\":\"pag1_29\",\"zonepath\":\"[1,29]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punteggio Domanda 4\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"QADV_PUNTEGGIO04\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FFUQSVAYEB\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":928,\"y\":227,\"zone\":\"pag1_30\",\"zonepath\":\"[1,30]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Motivo Risposta 4\",\"h\":70,\"name\":\"QADV_MOTIVO04\",\"page\":1,\"scroll\":true,\"spuid\":\"IPNCGLSXHQ\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":472,\"x\":448,\"y\":227,\"zone\":\"pag1_30\",\"zonepath\":\"[1,30]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Questionario Completo\",\"h\":21,\"label_text\":\"Questionario completato\",\"maxlength\":1,\"name\":\"QADV_FLGCOMPLETO\",\"page\":1,\"spuid\":\"RVNBZEITUY\",\"tabindex\":48,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":168,\"x\":8,\"y\":731,\"zone\":\"pag1_31\",\"zonepath\":\"[1,31]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
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
     "<script src='armt_cgo_qadv_operazioni_storico?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_qadv_operazioni_storico_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_qadv_operazioni_storico_edit.js'>" +
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
      status.out.println("w_QADV_DOMANDA01=a[0];");
      status.out.println("w_QADV_DOMANDA02=a[1];");
      status.out.println("w_QADV_DOMANDA03=a[2];");
      status.out.println("w_QADV_DOMANDA03_1=a[3];");
      status.out.println("w_QADV_DOMANDA03_2=a[4];");
      status.out.println("w_QADV_DOMANDA03_3=a[5];");
      status.out.println("w_QADV_MOTIVO03=a[6];");
      status.out.println("w_QADV_DOMANDA04=a[7];");
      status.out.println("w_QADV_DOMANDA04_1=a[8];");
      status.out.println("w_QADV_DOMANDA04_2=a[9];");
      status.out.println("w_QADV_DOMANDA04_3=a[10];");
      status.out.println("w_QADV_DOMANDA04_4=a[11];");
      status.out.println("w_QADV_DOMANDA05=a[12];");
      status.out.println("w_QADV_MOTIVO05=a[13];");
      status.out.println("w_QADV_DOMANDA06=a[14];");
      status.out.println("w_QADV_DOMANDA07=a[15];");
      status.out.println("w_QADV_DOMANDA08=a[16];");
      status.out.println("w_QADV_DOMANDA09=a[17];");
      status.out.println("w_QADV_DOMANDA10=a[18];");
      status.out.println("w_QADV_DOMANDA11=a[19];");
      status.out.println("w_QADV_DOMANDA12=a[20];");
      status.out.println("w_SNAINUMOPE=a[21];");
      status.out.println("w_QADV_PUNTEGGIO01=a[22];");
      status.out.println("w_QADV_PUNTEGGIO02=a[23];");
      status.out.println("w_QADV_PUNTEGGIO03=a[24];");
      status.out.println("w_QADV_PUNTEGGIO04=a[25];");
      status.out.println("w_QADV_MOTIVO04=a[26];");
      status.out.println("w_QADV_PUNTEGGIO05=a[27];");
      status.out.println("w_QADV_PUNTEGGIO06=a[28];");
      status.out.println("w_QADV_PUNTEGGIO07=a[29];");
      status.out.println("w_QADV_PUNTEGGIO08=a[30];");
      status.out.println("w_QADV_PUNTEGGIO09=a[31];");
      status.out.println("w_QADV_PUNTEGGIO10=a[32];");
      status.out.println("w_QADV_PUNTEGGIO11=a[33];");
      status.out.println("w_QADV_PUNTEGGIO12=a[34];");
      status.out.println("w_QADV_FLGCOMPLETO=a[35];");
      status.out.println("w_QADV_TOTALE=a[36];");
      status.out.println("m_PrimaryKeys=['SNAINUMOPE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_qadv_operazioni_storico_proc.js'>" +
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
    WriteStyles(BO,status);
    status.out.println(
     "<title>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate(entityGlobals.userName))+"" +
     "</title>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if ( ! (status.m_bHasRS)) {
      status.out.println("AppletTag('Settings','Trs');");
    }
    status.out.println("AppletTag('Wv','Trs');");
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
    status.themeWriter.WriteBody_Begin(753,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    status.AssignOP(BO.m_cOldCPCCCHK);
    status.WriteSenderForm(entityGlobals,BO.m_bLoaded);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
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
    f.SetParameter("Table","cgo_qadv_operazioni_storico");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","SNAINUMOPE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_qadv_operazioni_storicoBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("Utilities.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
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
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_SNAINUMOPE),"C",15,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_qadv_operazioni_storicoBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
    }
    return result;
  }
}
