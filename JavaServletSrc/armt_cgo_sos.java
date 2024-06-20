import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_sos extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*a86fb793*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_sos";
    }
    public double w_SOSCODICE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SOSCODICE,context,"cgo_sos","SOSCODICE","N",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='SOSCODICE' type='hidden' value="+SPLib.ToHTMLValue(w_SOSCODICE,"N",10,0)+">" +
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
    armt_cgo_sosBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_sos;
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
      status.w_SOSCODICE = BO.w_SOSCODICE;
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
    return "Segnalazione Operazione Sospetta";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_sos";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 853;
    l_eg.m_nEntityHeight = 968;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_sos","anadip","tbluonas","cgo_operazioni_storico","tbstati","tbcitta"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("Operazione","INFORMAZIONI INERENTI L'OPERAZIONE OGGETTO DELLA SEGNALAZIONE","horizontal_section"),new ZoneItem("Segnalante","INFORMAZIONI GENERALI SUL SEGNALANTE","horizontal_section"),new ZoneItem("Persona","INFORMAZIONI SULLA PERSONA FISICA CUI L'OPERAZIONE VA RIFERITA","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"SOSCODICE"};
    l_eg.items = new SPItem[]{
                   new SPItem("SOSCODICE","N",10,0, "show","Numero Segnalazione"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("SOSCODDIP","C",6,0, "edit","Agenzia di Riferimento"),
                   new SPItem("SOSSEGNANT","C",15,0, "edit","N° Telefono"),
                   new SPItem("SOSSEGNAFAX","C",15,0, "edit","N° Fax"),
                   new SPItem("SOSSEGNAEM","C",40,0, "edit","EMail"),
                   new SPItem("SOSSEGNACF","C",16,0, "edit","Codice Fiscale Segnalante"),
                   new SPItem("SOSSEGNACOG","C",30,0, "edit","Cognome"),
                   new SPItem("SOSSEGNANOM","C",30,0, "edit","Nome"),
                   new SPItem("SOSSEGNALN","C",50,0, "edit","Luogo Nascita"),
                   new SPItem("SOSSEGNADN","D",8,0, "edit","Data di Nascita"),
                   new SPItem("SOSSEGNASX","C",1,0, "edit","Sesso"),
                   new SPItem("SOSSTATOOP","C",1,0, "edit","Stato Operazione"),
                   new SPItem("IDBIGLIETTO","C",28,0, "edit","ID Biglietto"),
                   new SPItem("SOSDATAOP","D",8,0, "edit","Data Operazione"),
                   new SPItem("SOSTIPOOP","C",1,0, "edit","Tipo Operazione"),
                   new SPItem("SOSIMPOPE","N",15,2, "edit","Importo Operazione"),
                   new SPItem("SOSMEZPAG","C",1,0, "edit","Mezzo Pagamento"),
                   new SPItem("SOSNUMBON","C",30,0, "edit","N° Bonifico"),
                   new SPItem("SOSBANASS","C",50,0, "edit","Banca Assegno"),
                   new SPItem("SOSNUMASS","C",30,0, "edit","Numero Assegno"),
                   new SPItem("SOSDESOPE","M",10,0, "edit","Descrizione dell'operazione"),
                   new SPItem("SOSMOTSOS","M",10,0, "edit","Descrizione motivi del sospetto"),
                   new SPItem("SOSCLIECOG","C",30,0, "edit","Cognome Cliente"),
                   new SPItem("SOSCLIENOM","C",30,0, "edit","Nome Cliente"),
                   new SPItem("SOSCLIELN","C",50,0, "edit","Luogo di nascita Cliente"),
                   new SPItem("SOSCLIEDN","D",8,0, "edit","Data di Nascita"),
                   new SPItem("SOSCLIESX","C",1,0, "edit","Sesso"),
                   new SPItem("SOSCLIECF","C",16,0, "edit","Codice Fiscale Cliente"),
                   new SPItem("SOSCLIEPAE","C",3,0, "edit","Paese di Residenza Cliente"),
                   new SPItem("SOSCLIECR","C",50,0, "edit","Comune"),
                   new SPItem("SOSCLIEIND","C",50,0, "edit","Indirizzo"),
                   new SPItem("SOSCLIECAR","C",5,0, "edit","CAP Residenza Cliente"),
                   new SPItem("SOSCLIETD","C",2,0, "edit","Tipo Documento Cliente"),
                   new SPItem("SOSCLIEND","C",15,0, "edit","N° Documento Cliente"),
                   new SPItem("SOSCLIEDRD","D",8,0, "edit","Data Rilascio"),
                   new SPItem("SOSCLIEDSD","D",8,0, "edit","Data Scadenza"),
                   new SPItem("SOSCLIEAUD","C",50,0, "edit","Autorità e Luogo Rilascio"),
                   new SPItem("SOSSEGNAPN","C",2,0, "show","Provincia di Nascita"),
                   new SPItem("SOSCLIEPN","C",2,0, "edit","Provicnia di Nascita Cliente"),
                   new SPItem("SOSCLIEPR","C",2,0, "edit","Provincia Residenza Cliente"),
                   new SPItem("xdesdip","C",30,0, "show","Descrizione"),
                   new SPItem("gUserCode","N",4,0, "hide","Codice Utente CP"),
                   new SPItem("SOSUTENTE","N",10,0, "hide","Utente"),
                   new SPItem("SOSDATSEG","D",8,0, "show","Data Segnalazione"),
                   new SPItem("xDESSTATO","C",40,0, "show","Descrizione")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_sosBO BO) {
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
    l_translations=new String[][]{{"10003478977",p_Context.Translate("Storico Registrazioni")},
    {"10066897585",p_Context.Translate("E' stato superato il limite massimo di 350 caratteri")},
    {"10078979362",p_Context.Translate("Agenzia di Riferimento")},
    {"10201018318",p_Context.Translate("Impossibile modificare una segnalazione")},
    {"10363969400",p_Context.Translate("Descrizione motivi del sospetto")},
    {"10465059384",p_Context.Translate("Codice Fiscale Cliente")},
    {"1053663553",p_Context.Translate("Numero Assegno")},
    {"10651434988",p_Context.Translate("Mezzo Pagamento")},
    {"10654635466",p_Context.Translate("Cognome Cliente")},
    {"10669633614",p_Context.Translate("Data di Nascita")},
    {"10675153370",p_Context.Translate("Importo Operazione")},
    {"10737443664",p_Context.Translate("Autorità e Luogo Rilascio")},
    {"10799817497",p_Context.Translate("N° Bonifico")},
    {"10869604963",p_Context.Translate("N° Telefono")},
    {"10985555519",p_Context.Translate("Segnalazione Operazione Sospetta")},
    {"11138315273",p_Context.Translate("Codice Utente CP")},
    {"113624115",p_Context.Translate("Comune")},
    {"113986709",p_Context.Translate("Utente")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11694162167",p_Context.Translate("Provicnia di Nascita Cliente")},
    {"11753347534",p_Context.Translate("Impossibile visualizzare la segnalazione selezionata")},
    {"11842673987",p_Context.Translate("(Descrizione Operazione) E' stato superato il limite massimo di 350 caratteri")},
    {"11845560570",p_Context.Translate("Codice Fiscale Segnalante")},
    {"11872865340",p_Context.Translate("Provincia di Nascita")},
    {"11910664466",p_Context.Translate("Paese di Residenza Cliente")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1275175384",p_Context.Translate("N° Documento Cliente")},
    {"1287421676",p_Context.Translate("Luogo di nascita Cliente")},
    {"132483918",p_Context.Translate("N° Fax")},
    {"1414023497",p_Context.Translate("Descrizione dell'operazione")},
    {"1464959469",p_Context.Translate("Impossibile eliminare una segnalazione")},
    {"15186643",p_Context.Translate("Città")},
    {"1625200191",p_Context.Translate("Luogo Nascita")},
    {"1743500738",p_Context.Translate("Numero Segnalazione")},
    {"176282827",p_Context.Translate("Attenzione! Data di rilascio superiore alla data fine validità. Verificare il corretto inserimento delle date.")},
    {"1801622885",p_Context.Translate("(Motivo del sospetto) E' stato superato il limite massimo di 350 caratteri")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"187973133",p_Context.Translate("Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento.")},
    {"1884688478",p_Context.Translate("Nazioni")},
    {"1943925269",p_Context.Translate("Banca Assegno")},
    {"1969246349",p_Context.Translate("Provincia Residenza Cliente")},
    {"2025824008",p_Context.Translate("Data Scadenza")},
    {"227139885",p_Context.Translate("Luoghi Nascita")},
    {"259661248",p_Context.Translate("CAP Residenza Cliente")},
    {"27131685",p_Context.Translate("Tipo Documento Cliente")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"383234328",p_Context.Translate("Stato Operazione")},
    {"443454",p_Context.Translate("Nome")},
    {"48541742",p_Context.Translate("ID Biglietto")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"6131587",p_Context.Translate("Nome Cliente")},
    {"7534101",p_Context.Translate("EMail")},
    {"7776675",p_Context.Translate("Sesso")},
    {"784106725",p_Context.Translate("Data Rilascio")},
    {"812059959",p_Context.Translate("Data Segnalazione")},
    {"819587209",p_Context.Translate("Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento.")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"829257574",p_Context.Translate("Tipo Operazione")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_sosBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_sos.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_sosBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_sos',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_sos",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_cgo_sosBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_cgo_sosBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:968px;width:853px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteControls_p1_b5(BO,status);
    WriteControls_p1_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"PAGE_1");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
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
  void WriteControls_p1_b0(armt_cgo_sosBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:35px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='SOSCODICE' id='IFUSPOLLJT' type='text' class='Field PrimaryKeyField "+(CPLib.ne(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_SOSCODICE,"N",10,0,"9999999999", status.m_oRegSettings)+" tabindex='-1' "+(CPLib.ne(status.m_cClientMode,"query")?"readonly":"")+" maxlength='13' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='KMHQEVWVNK_DIV'>" +
       "<label id='KMHQEVWVNK' for='IFUSPOLLJT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Segnalazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCODDIP' id='DHBRXDCHIH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCODDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UDWQJSNCSD_DIV'>" +
       "<label id='UDWQJSNCSD' for='DHBRXDCHIH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia di Riferimento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='xdesdip' id='KUSKRDMQOJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xdesdip,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='SOSDATSEG' id='DDVPAVKJFZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_SOSDATSEG,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BIJADGJZHV_DIV'>" +
       "<label id='BIJADGJZHV' for='DDVPAVKJFZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Segnalazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_cgo_sosBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Segnalante' id='DIAEKSWWEM_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='DIAEKSWWEM_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='DIAEKSWWEM_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("INFORMAZIONI GENERALI SUL SEGNALANTE")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='DIAEKSWWEM_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"DIAEKSWWEM\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=DIAEKSWWEM_HEADER&m_cBoxId=DIAEKSWWEM&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("INFORMAZIONI GENERALI SUL SEGNALANTE"))+"");
    }
    status.out.println(
     "<div id='DIAEKSWWEM' class='SectionBody' style='position:relative;height:182px;display:block'>" +
    "");
    status.includeZoneAltInterface("Segnalante@BEGIN");
    if (status.includeZoneAltInterface("Segnalante")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Segnalante@BEGIN") || status.HasZoneAltInterface("Segnalante@END")) {
        status.out.println(
         "<div id='DIAEKSWWEM_boxContent' style='position:relative;height:182px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='VQQEIXPUTK_DIV'>" +
       "<label id='VQQEIXPUTK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dati anagrafici del segnalante"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNANT' id='NHTTQSKNCE' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNANT,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNAFAX' id='IRAARTIBBY' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNAFAX,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNAEM' id='CGKCUTXIQV' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNAEM,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNACF' id='UVDPOGERZK' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNACF,"C",16,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNACOG' id='HNLUXWZZSG' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNACOG,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNANOM' id='NPOZCOOROF' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNANOM,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNALN' id='NMTFLCHLGD' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNALN,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
       "<button id='NMTFLCHLGD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NMTFLCHLGD", "tbluonas", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSSEGNADN' id='BLOPGSOJRJ' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNADN,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='BLOPGSOJRJ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSSEGNASX' id='EABOOAYYWK' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_SOSSEGNASX))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_SOSSEGNASX))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femmina")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('EABOOAYYWK'),w_SOSSEGNASX,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RSEQNBPPDH_DIV'>" +
       "<label id='RSEQNBPPDH' for='NHTTQSKNCE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VWICKVEUFP_DIV'>" +
       "<label id='VWICKVEUFP' for='IRAARTIBBY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Fax:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BGJTNRPVYT_DIV'>" +
       "<label id='BGJTNRPVYT' for='CGKCUTXIQV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("EMail:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EGGJNAFFFP_DIV'>" +
       "<label id='EGGJNAFFFP' for='UVDPOGERZK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WGYPGAIHQJ_DIV'>" +
       "<label id='WGYPGAIHQJ' for='HNLUXWZZSG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WSMJVYMWRD_DIV'>" +
       "<label id='WSMJVYMWRD' for='NPOZCOOROF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZQNTJKRAAL_DIV'>" +
       "<label id='ZQNTJKRAAL' for='NMTFLCHLGD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Luogo Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='SOSSEGNAPN' id='SPBNKEMPWP' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_SOSSEGNAPN,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='USIKKLDZOP_DIV'>" +
       "<label id='USIKKLDZOP' for='SPBNKEMPWP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OHZRZXFOTV_DIV'>" +
       "<label id='OHZRZXFOTV' for='BLOPGSOJRJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RXORNOZGHT_DIV'>" +
       "<label id='RXORNOZGHT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Contatti del segnalante (soggetto preposto a fornire informazioni relative alla segnalazione)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CQCOXHOFIH_DIV'>" +
       "<label id='CQCOXHOFIH' for='EABOOAYYWK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Segnalante@BEGIN") || status.HasZoneAltInterface("Segnalante@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_cgo_sosBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Segnalante@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Segnalante")) {
      status.out.println("Ctrl('DIAEKSWWEM').style.height='auto';");
    } else {
      status.out.println("Ctrl('DIAEKSWWEM').setAttribute('band_height',182);");
    }
    status.out.println("Ctrl('DIAEKSWWEM').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_cgo_sosBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_THCSTTAUJY")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_THCSTTAUJY' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_THCSTTAUJY")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_THCSTTAUJY').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(armt_cgo_sosBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Operazione' id='THCSTTAUJY_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='THCSTTAUJY_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='THCSTTAUJY_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("INFORMAZIONI INERENTI L'OPERAZIONE OGGETTO DELLA SEGNALAZIONE")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='THCSTTAUJY_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"THCSTTAUJY\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=THCSTTAUJY_HEADER&m_cBoxId=THCSTTAUJY&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("INFORMAZIONI INERENTI L'OPERAZIONE OGGETTO DELLA SEGNALAZIONE"))+"");
    }
    status.out.println(
     "<div id='THCSTTAUJY' class='SectionBody' style='position:relative;height:301px;display:block'>" +
    "");
    status.includeZoneAltInterface("Operazione@BEGIN");
    if (status.includeZoneAltInterface("Operazione")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "<div id='THCSTTAUJY_boxContent' style='position:relative;height:301px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSSTATOOP' id='MHDGPLPBBN' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_SOSSTATOOP))?"SELECTED":"")+">" +
       ""+status.context.Translate("Eseguita")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_SOSSTATOOP))?"SELECTED":"")+">" +
       ""+status.context.Translate("Non Eseguita")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('MHDGPLPBBN'),w_SOSSTATOOP,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDBIGLIETTO' id='UXJUHWBCMH' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDBIGLIETTO,"C",28,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='28' size='28' fieldtype='C' style='display:none'>" +
       "<button id='UXJUHWBCMH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UXJUHWBCMH", "cgo_operazioni_storico", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSDATAOP' id='CCDNZZPUCA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSDATAOP,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='CCDNZZPUCA_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSTIPOOP' id='AMJZYMJHYP' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("G","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("G",CPLib.Trim(BO.w_SOSTIPOOP))?"SELECTED":"")+">" +
       ""+status.context.Translate("Giocata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_SOSTIPOOP))?"SELECTED":"")+">" +
       ""+status.context.Translate("Vincita")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('AMJZYMJHYP'),w_SOSTIPOOP,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSIMPOPE' id='DXDTFLVDRK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSIMPOPE,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSMEZPAG' id='CUWGJLKVOE' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Altro Mezzo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Bonifico Italia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Bonifico Estero")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Bonifico Postale")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("C","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("C",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Assegno Circolare")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("B","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("B",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Assegno Bancario")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Carta di Credito")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_SOSMEZPAG))?"SELECTED":"")+">" +
       ""+status.context.Translate("Contante")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('CUWGJLKVOE'),w_SOSMEZPAG,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSNUMBON' id='AYIZLJVVCP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSNUMBON,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSBANASS' id='SYZBUNLLHR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSBANASS,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSNUMASS' id='SBVSTUFZNJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSNUMASS,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='SOSDESOPE' id='ABTEUVWFFQ' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='SOSMOTSOS' id='YBPKXABHYP' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RGSHLRGAOP_DIV'>" +
       "<label id='RGSHLRGAOP' for='MHDGPLPBBN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HKSFDQTCFO_DIV'>" +
       "<label id='HKSFDQTCFO' for='CCDNZZPUCA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EBPNPCQAOY_DIV'>" +
       "<label id='EBPNPCQAOY' for='AMJZYMJHYP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DPERQPUGQY_DIV'>" +
       "<label id='DPERQPUGQY' for='CUWGJLKVOE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo Pagamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WVYDDBJNAE_DIV'>" +
       "<label id='WVYDDBJNAE' for='ABTEUVWFFQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione Operazione:\n(Max 350 caratteri)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EIZRXIRZNI_DIV'>" +
       "<label id='EIZRXIRZNI' for='YBPKXABHYP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Motivi del sospetto:\n(Max 350 caratteri)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PHMVDMVXDH_DIV' style='display:none'>" +
       "<label id='PHMVDMVXDH' for='UXJUHWBCMH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Biglietto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FCSTUJGVOP_DIV'>" +
       "<label id='FCSTUJGVOP' for='DXDTFLVDRK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KJJMFNDTGT_DIV'>" +
       "<label id='KJJMFNDTGT' for='AYIZLJVVCP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Bonifico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RIKJBVFIOW_DIV'>" +
       "<label id='RIKJBVFIOW' for='SBVSTUFZNJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Assegno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QSZJDWFOBU_DIV'>" +
       "<label id='QSZJDWFOBU' for='SYZBUNLLHR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Banca Assegno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_cgo_sosBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Operazione@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Operazione")) {
      status.out.println("Ctrl('THCSTTAUJY').style.height='auto';");
    } else {
      status.out.println("Ctrl('THCSTTAUJY').setAttribute('band_height',301);");
    }
    status.out.println("Ctrl('THCSTTAUJY').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_cgo_sosBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_ALUYEPUVLF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_ALUYEPUVLF' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_ALUYEPUVLF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_ALUYEPUVLF').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b5(armt_cgo_sosBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Persona' id='ALUYEPUVLF_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='ALUYEPUVLF_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='ALUYEPUVLF_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("INFORMAZIONI SULLA PERSONA FISICA CUI L'OPERAZIONE VA RIFERITA")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='ALUYEPUVLF_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"ALUYEPUVLF\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=ALUYEPUVLF_HEADER&m_cBoxId=ALUYEPUVLF&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("INFORMAZIONI SULLA PERSONA FISICA CUI L'OPERAZIONE VA RIFERITA"))+"");
    }
    status.out.println(
     "<div id='ALUYEPUVLF' class='SectionBody' style='position:relative;height:371px;display:block'>" +
    "");
    status.includeZoneAltInterface("Persona@BEGIN");
    if (status.includeZoneAltInterface("Persona")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Persona@BEGIN") || status.HasZoneAltInterface("Persona@END")) {
        status.out.println(
         "<div id='ALUYEPUVLF_boxContent' style='position:relative;height:371px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIECOG' id='IAAFYFVCOO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIECOG,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIENOM' id='YZCTAZEUHT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIENOM,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIELN' id='EKWIYNRJCN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIELN,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
       "<button id='EKWIYNRJCN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "EKWIYNRJCN", "tbluonas", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEDN' id='ESIPESUKFU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEDN,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='ESIPESUKFU_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSCLIESX' id='ZAUFIWBFWS' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_SOSCLIESX))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_SOSCLIESX))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femmina")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('ZAUFIWBFWS'),w_SOSCLIESX,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIECF' id='YAUYCDEFNH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIECF,"C",16,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEPAE' id='CQREEAUGJZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEPAE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C' autocomplete='off'>" +
       "<button id='CQREEAUGJZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CQREEAUGJZ", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIECR' id='RNXXROADTV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIECR,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C' autocomplete='off'>" +
       "<button id='RNXXROADTV_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RNXXROADTV", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEIND' id='HRARTBAAAD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEIND,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIECAR' id='XZMROSWRMH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIECAR,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SOSCLIETD' id='YSEWNSQRQV' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEND' id='RGTEMJRSBB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEND,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEDRD' id='MDMENXCYFS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEDRD,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='MDMENXCYFS_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEDSD' id='SMDOEMVCES' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEDSD,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='SMDOEMVCES_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEAUD' id='LVYUCXICCL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEAUD,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NVOKWXFGOG_DIV'>" +
       "<label id='NVOKWXFGOG' for='IAAFYFVCOO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UWBUBYMXNH_DIV'>" +
       "<label id='UWBUBYMXNH' for='YZCTAZEUHT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KSCXKTBDNF_DIV'>" +
       "<label id='KSCXKTBDNF' for='EKWIYNRJCN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Luogo di nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEPN' id='GWPOQYXVMH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEPN,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SRKHBXIXTJ_DIV'>" +
       "<label id='SRKHBXIXTJ' for='GWPOQYXVMH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FGPSBECPQJ_DIV'>" +
       "<label id='FGPSBECPQJ' for='ESIPESUKFU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XOANTUVUZH_DIV'>" +
       "<label id='XOANTUVUZH' for='ZAUFIWBFWS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TJTUYNBQYT_DIV'>" +
       "<label id='TJTUYNBQYT' for='YAUYCDEFNH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KDQYMFMALB_DIV'>" +
       "<label id='KDQYMFMALB' for='CQREEAUGJZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OAMCQZDMKT_DIV'>" +
       "<label id='OAMCQZDMKT' for='XZMROSWRMH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOSCLIEPR' id='EOTGCHITKP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOSCLIEPR,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XUKGFRRXQU_DIV'>" +
       "<label id='XUKGFRRXQU' for='EOTGCHITKP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BCDMIWTOPN_DIV'>" +
       "<label id='BCDMIWTOPN' for='YSEWNSQRQV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GIPVDDJTVU_DIV'>" +
       "<label id='GIPVDDJTVU' for='RGTEMJRSBB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HLPYIABQPO_DIV'>" +
       "<label id='HLPYIABQPO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dati identificativi cliente"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AKQEPKXJHR_DIV'>" +
       "<label id='AKQEPKXJHR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Residenza"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VKRCBRSEXQ_DIV'>" +
       "<label id='VKRCBRSEXQ' for='RNXXROADTV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Comune:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BXTLAPVHVP_DIV'>" +
       "<label id='BXTLAPVHVP' for='HRARTBAAAD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BUCXTYSTDW_DIV'>" +
       "<label id='BUCXTYSTDW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dati Documento di Identità del Cliente"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RPUYWHBPLW_DIV'>" +
       "<label id='RPUYWHBPLW' for='MDMENXCYFS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KVXUAURODE_DIV'>" +
       "<label id='KVXUAURODE' for='SMDOEMVCES'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Scadenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XQKIDGOLHP_DIV'>" +
       "<label id='XQKIDGOLHP' for='LVYUCXICCL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità e Luogo Rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='xDESSTATO' id='RTYSMJWDZO' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xDESSTATO,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      if (status.HasZoneAltInterface("Persona@BEGIN") || status.HasZoneAltInterface("Persona@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_cgo_sosBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Persona@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Persona")) {
      status.out.println("Ctrl('ALUYEPUVLF').style.height='auto';");
    } else {
      status.out.println("Ctrl('ALUYEPUVLF').setAttribute('band_height',371);");
    }
    status.out.println("Ctrl('ALUYEPUVLF').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_cgo_sosBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_1' style='position:relative;height:5px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(armt_cgo_sosBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_sosBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_cgo_sosBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_SOSCODICE:BO.w_SOSCODICE,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCODDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNANT,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNAFAX,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNAEM,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNACF,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNACOG,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNANOM,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNALN,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNADN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNASX,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSTATOOP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSDATAOP,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSTIPOOP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSIMPOPE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSMEZPAG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSNUMBON,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSBANASS,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSNUMASS,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSDESOPE,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSMOTSOS,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIECOG,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIENOM,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIELN,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEDN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIESX,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIECF,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEPAE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIECR,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEIND,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIECAR,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIETD,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEND,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEDRD,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEDSD,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEAUD,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSSEGNAPN,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEPN,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSCLIEPR,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSUTENTE,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOSDATSEG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBIGLIETTO,"C",28,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gUserCode,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESSTATO,"C",40,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_sosBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(968,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(853,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_sos"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'DHBRXDCHIH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DHBRXDCHIH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'NMTFLCHLGD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NMTFLCHLGD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbluonas,"+"default",l_session)+"'"+"]");
      status.out.print(",'UXJUHWBCMH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UXJUHWBCMH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_operazioni_storico,"+"default",l_session)+"'"+"]");
      status.out.print(",'EKWIYNRJCN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EKWIYNRJCN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbluonas,"+"default",l_session)+"'"+"]");
      status.out.print(",'CQREEAUGJZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CQREEAUGJZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'RNXXROADTV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RNXXROADTV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'DHBRXDCHIH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'NMTFLCHLGD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbluonas,"+"default",l_session)+"'"+"]");
      status.out.print(",'UXJUHWBCMH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_operazioni_storico,"+"default",l_session)+"'"+"]");
      status.out.print(",'EKWIYNRJCN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbluonas,"+"default",l_session)+"'"+"]");
      status.out.print(",'CQREEAUGJZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'RNXXROADTV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_sos","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_sos",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Operazione"),"")) {
      status.quoteAndAppend("Operazione","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Segnalante"),"")) {
      status.quoteAndAppend("Segnalante","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Persona"),"")) {
      status.quoteAndAppend("Persona","hide","box");
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
  void WriteMainFormScript(armt_cgo_sosBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_sos',false);");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('DHBRXDCHIH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHTTQSKNCE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IRAARTIBBY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CGKCUTXIQV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UVDPOGERZK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HNLUXWZZSG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NPOZCOOROF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NMTFLCHLGD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NMTFLCHLGD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BLOPGSOJRJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BLOPGSOJRJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EABOOAYYWK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MHDGPLPBBN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UXJUHWBCMH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UXJUHWBCMH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CCDNZZPUCA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CCDNZZPUCA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AMJZYMJHYP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DXDTFLVDRK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CUWGJLKVOE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AYIZLJVVCP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SYZBUNLLHR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SBVSTUFZNJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ABTEUVWFFQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YBPKXABHYP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IAAFYFVCOO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZCTAZEUHT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EKWIYNRJCN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EKWIYNRJCN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESIPESUKFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESIPESUKFU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZAUFIWBFWS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YAUYCDEFNH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CQREEAUGJZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CQREEAUGJZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RNXXROADTV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RNXXROADTV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRARTBAAAD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XZMROSWRMH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YSEWNSQRQV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RGTEMJRSBB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDMENXCYFS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDMENXCYFS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SMDOEMVCES')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SMDOEMVCES_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LVYUCXICCL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GWPOQYXVMH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOTGCHITKP')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
      status.out.println("ExpandCollapseBoxesUnderCondition();");
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
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('IFUSPOLLJT')) SetDisabled(c,true);");
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
    status.out.println("function ChildSelectedPage(name) {");
    status.out.println("var l_cRes = '';");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
        status.out.println("if (Eq(p_uid,'SOSCODICE') || Empty(p_uid)) {");
        status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
        status.out.println("}");
      }
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_SOSCODICE','PRGSEGSOS');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('SOSCODICE',w_SOSCODICE,op_SOSCODICE,'N',10,0);");
        status.out.println("AutonumberApplet().SetETName('cgo_sos');");
        status.out.println("w_SOSCODICE=AutonumberApplet().GetAutonumberDouble('SOSCODICE');");
        status.out.println("}");
      }
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("op_codazi=m_cCompany;");
        status.out.println("op_SOSCODICE=w_SOSCODICE;");
        status.out.println("}");
      }
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_cgo_sosBO getBO(ServletStatus status) {
    armt_cgo_sosBO BO = new armt_cgo_sosBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_SOSCODICE = BO.w_SOSCODICE;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_cgo_sosBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_sos",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_sosBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_sosBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_tipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_cgo_tipdoc,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TIPDOC"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var YSEWNSQRQV_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_cgo_sosBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_sos;
    String l_cPhName = BO.m_cPhName_cgo_sos;
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
      String l_cQueryFilter = armt_cgo_sosBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_sos+".SOSCODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_sos");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_sos",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".SOSCODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_cgo_sosBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_sosBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_sos,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_sos,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_sosBO BO) {
    String _m = status.m_cMode;
    if ( ! (BO.m_bLoaded)) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    }
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
    status.m_cClientMode = "view";
  }
  void Edit(ServletStatus status,armt_cgo_sosBO BO,SPParameterSource source) {
    BO.Load(status.w_SOSCODICE);
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
  void New(ServletStatus status,armt_cgo_sosBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_sosBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_sosBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_SOSCODICE = 0;
      } else {
        BO.w_SOSCODICE = l_rsKeys.GetDouble("SOSCODICE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_SOSCODICE = BO.w_SOSCODICE;
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
  void EditLoad(ServletStatus status,armt_cgo_sosBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_sosBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_SOSCODICE);
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
  void DeleteMessage(ServletStatus status,armt_cgo_sosBO BO,SPParameterSource source) {
    BO.Load(status.w_SOSCODICE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_sosBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    double l_old_SOSCODICE = 0;
    if (CPLib.ne(BO.w_SOSCODICE,BO.op_SOSCODICE)) {
      l_old_SOSCODICE = BO.op_SOSCODICE;
    }
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({SOSCODICE:"+SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_SOSCODICE))) {
        BO.op_SOSCODICE = l_old_SOSCODICE;
      }
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
  void Discard(ServletStatus status,armt_cgo_sosBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_sosBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",908);
    item.put("w",853);
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
    item.put("altInterfaceFor","armt_cgo_sos");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"Numero Segnalazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":13,\"name\":\"SOSCODICE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"IFUSPOLLJT\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":136,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KMHQEVWVNK\",\"page\":1,\"spuid\":\"KMHQEVWVNK\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Numero Segnalazione:\",\"w\":117,\"x\":18,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Agenzia di Riferimento\",\"h\":20,\"maxlength\":6,\"name\":\"SOSCODDIP\",\"page\":1,\"spuid\":\"DHBRXDCHIH\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":352,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UDWQJSNCSD\",\"page\":1,\"spuid\":\"UDWQJSNCSD\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Agenzia di Riferimento:\",\"w\":122,\"x\":229,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"xdesdip\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KUSKRDMQOJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":248,\"x\":416,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Segnalazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"SOSDATSEG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DDVPAVKJFZ\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":776,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BIJADGJZHV\",\"page\":1,\"spuid\":\"BIJADGJZHV\",\"tabindex\":91,\"type\":\"Label\",\"value\":\"Data Segnalazione:\",\"w\":102,\"x\":674,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Segnalante\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"INFORMAZIONI GENERALI SUL SEGNALANTE\",\"h\":182,\"name\":\"Segnalante\",\"page\":1,\"shrinkable\":true,\"spuid\":\"DIAEKSWWEM\",\"stretch\":true,\"tabindex\":74,\"title_caption\":\"INFORMAZIONI GENERALI SUL SEGNALANTE\",\"titled\":true,\"type\":\"Box\",\"w\":840,\"x\":8,\"y\":35,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"#0000FF\",\"h\":19,\"name\":\"label_RXORNOZGHT\",\"page\":1,\"spuid\":\"RXORNOZGHT\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"Contatti del segnalante (soggetto preposto a fornire informazioni relative alla segnalazione)\",\"w\":824,\"x\":16,\"y\":39,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Telefono\",\"h\":20,\"maxlength\":15,\"name\":\"SOSSEGNANT\",\"page\":1,\"spuid\":\"NHTTQSKNCE\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":136,\"y\":70,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Fax\",\"h\":20,\"maxlength\":15,\"name\":\"SOSSEGNAFAX\",\"page\":1,\"spuid\":\"IRAARTIBBY\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":368,\"y\":70,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"EMail\",\"h\":20,\"maxlength\":40,\"name\":\"SOSSEGNAEM\",\"page\":1,\"spuid\":\"CGKCUTXIQV\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":256,\"x\":584,\"y\":70,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RSEQNBPPDH\",\"page\":1,\"spuid\":\"RSEQNBPPDH\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"N\\u00B0 Telefono:\",\"w\":67,\"x\":68,\"y\":74,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VWICKVEUFP\",\"page\":1,\"spuid\":\"VWICKVEUFP\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"N\\u00B0 Fax:\",\"w\":40,\"x\":327,\"y\":74,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BGJTNRPVYT\",\"page\":1,\"spuid\":\"BGJTNRPVYT\",\"tabindex\":45,\"type\":\"Label\",\"value\":\"EMail:\",\"w\":30,\"x\":553,\"y\":74,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"#0000FF\",\"h\":19,\"name\":\"label_VQQEIXPUTK\",\"page\":1,\"spuid\":\"VQQEIXPUTK\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Dati anagrafici del segnalante\",\"w\":824,\"x\":16,\"y\":105,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale Segnalante\",\"h\":20,\"maxlength\":16,\"name\":\"SOSSEGNACF\",\"page\":1,\"spuid\":\"UVDPOGERZK\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":136,\"y\":133,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":30,\"name\":\"SOSSEGNACOG\",\"page\":1,\"spuid\":\"HNLUXWZZSG\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":360,\"y\":133,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":30,\"name\":\"SOSSEGNANOM\",\"page\":1,\"spuid\":\"NPOZCOOROF\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":640,\"y\":133,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EGGJNAFFFP\",\"page\":1,\"spuid\":\"EGGJNAFFFP\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":140,\"x\":-5,\"y\":137,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WGYPGAIHQJ\",\"page\":1,\"spuid\":\"WGYPGAIHQJ\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":53,\"x\":306,\"y\":137,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WSMJVYMWRD\",\"page\":1,\"spuid\":\"WSMJVYMWRD\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":34,\"x\":605,\"y\":137,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Luogo Nascita\",\"h\":20,\"maxlength\":50,\"name\":\"SOSSEGNALN\",\"page\":1,\"picker\":true,\"spuid\":\"NMTFLCHLGD\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":161,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZQNTJKRAAL\",\"page\":1,\"spuid\":\"ZQNTJKRAAL\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Luogo Nascita:\",\"w\":78,\"x\":57,\"y\":165,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia di Nascita\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"SOSSEGNAPN\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SPBNKEMPWP\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":640,\"y\":161,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_USIKKLDZOP\",\"page\":1,\"spuid\":\"USIKKLDZOP\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Provincia di Nascita:\",\"w\":105,\"x\":534,\"y\":165,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data di Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"SOSSEGNADN\",\"page\":1,\"picker\":true,\"spuid\":\"BLOPGSOJRJ\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":136,\"y\":189,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OHZRZXFOTV\",\"page\":1,\"spuid\":\"OHZRZXFOTV\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Data di Nascita:\",\"w\":83,\"x\":52,\"y\":193,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOSSEGNASX\",\"page\":1,\"spuid\":\"EABOOAYYWK\",\"tabindex\":16,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":136,\"x\":640,\"y\":189,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CQCOXHOFIH\",\"page\":1,\"spuid\":\"CQCOXHOFIH\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":35,\"x\":605,\"y\":193,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Operazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"INFORMAZIONI INERENTI L"+"'"+"OPERAZIONE OGGETTO DELLA SEGNALAZIONE\",\"h\":301,\"name\":\"Operazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"THCSTTAUJY\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"INFORMAZIONI INERENTI L"+"'"+"OPERAZIONE OGGETTO DELLA SEGNALAZIONE\",\"titled\":true,\"type\":\"Box\",\"w\":840,\"x\":8,\"y\":224,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato Operazione\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOSSTATOOP\",\"page\":1,\"spuid\":\"MHDGPLPBBN\",\"tabindex\":17,\"textlist\":\"Eseguita,Non Eseguita\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"E"+"'"+","+"'"+"N"+"'"+"\",\"w\":104,\"x\":136,\"y\":238,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ID Biglietto\",\"h\":20,\"maxlength\":28,\"name\":\"IDBIGLIETTO\",\"page\":1,\"picker\":true,\"spuid\":\"UXJUHWBCMH\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":180,\"x\":344,\"y\":238,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"SOSDATAOP\",\"page\":1,\"picker\":true,\"spuid\":\"CCDNZZPUCA\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":60,\"x\":640,\"y\":238,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RGSHLRGAOP\",\"page\":1,\"spuid\":\"RGSHLRGAOP\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Stato Operazione:\",\"w\":96,\"x\":39,\"y\":242,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HKSFDQTCFO\",\"page\":1,\"spuid\":\"HKSFDQTCFO\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"Data Operazione:\",\"w\":93,\"x\":546,\"y\":242,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PHMVDMVXDH\",\"page\":1,\"spuid\":\"PHMVDMVXDH\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"ID Biglietto:\",\"w\":66,\"x\":278,\"y\":242,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Operazione\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOSTIPOOP\",\"page\":1,\"spuid\":\"AMJZYMJHYP\",\"tabindex\":20,\"textlist\":\"Giocata,Vincita\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"G"+"'"+","+"'"+"V"+"'"+"\",\"w\":104,\"x\":136,\"y\":266,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EBPNPCQAOY\",\"page\":1,\"spuid\":\"EBPNPCQAOY\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":90,\"x\":45,\"y\":270,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo Operazione\",\"h\":20,\"maxlength\":21,\"name\":\"SOSIMPOPE\",\"page\":1,\"spuid\":\"DXDTFLVDRK\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":640,\"y\":266,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FCSTUJGVOP\",\"page\":1,\"spuid\":\"FCSTUJGVOP\",\"tabindex\":90,\"type\":\"Label\",\"value\":\"Importo Operazione:\",\"w\":110,\"x\":530,\"y\":270,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mezzo Pagamento\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOSMEZPAG\",\"page\":1,\"spuid\":\"CUWGJLKVOE\",\"tabindex\":22,\"textlist\":\"Altro Mezzo,Bonifico Italia,Bonifico Estero,Bonifico Postale,Assegno Circolare,Assegno Bancario,Carta di Credito,Contante\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"I"+"'"+","+"'"+"E"+"'"+","+"'"+"P"+"'"+","+"'"+"C"+"'"+","+"'"+"B"+"'"+","+"'"+"V"+"'"+","+"'"+"S"+"'"+"\",\"w\":184,\"x\":136,\"y\":294,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DPERQPUGQY\",\"page\":1,\"spuid\":\"DPERQPUGQY\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Mezzo Pagamento:\",\"w\":100,\"x\":35,\"y\":298,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Bonifico\",\"h\":20,\"maxlength\":30,\"name\":\"SOSNUMBON\",\"page\":1,\"spuid\":\"AYIZLJVVCP\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":640,\"y\":294,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KJJMFNDTGT\",\"page\":1,\"spuid\":\"KJJMFNDTGT\",\"tabindex\":93,\"type\":\"Label\",\"value\":\"N\\u00B0 Bonifico:\",\"w\":61,\"x\":579,\"y\":298,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Banca Assegno\",\"h\":20,\"maxlength\":50,\"name\":\"SOSBANASS\",\"page\":1,\"spuid\":\"SYZBUNLLHR\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":322,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QSZJDWFOBU\",\"page\":1,\"spuid\":\"QSZJDWFOBU\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"Banca Assegno:\",\"w\":84,\"x\":52,\"y\":326,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Assegno\",\"h\":20,\"maxlength\":30,\"name\":\"SOSNUMASS\",\"page\":1,\"spuid\":\"SBVSTUFZNJ\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":640,\"y\":322,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RIKJBVFIOW\",\"page\":1,\"spuid\":\"RIKJBVFIOW\",\"tabindex\":94,\"type\":\"Label\",\"value\":\"Numero Assegno:\",\"w\":93,\"x\":547,\"y\":326,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione dell"+"'"+"operazione\",\"h\":161,\"name\":\"SOSDESOPE\",\"page\":1,\"scroll\":true,\"spuid\":\"ABTEUVWFFQ\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":288,\"x\":136,\"y\":350,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione motivi del sospetto\",\"h\":161,\"name\":\"SOSMOTSOS\",\"page\":1,\"scroll\":true,\"spuid\":\"YBPKXABHYP\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":288,\"x\":544,\"y\":350,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":29,\"name\":\"label_WVYDDBJNAE\",\"page\":1,\"spuid\":\"WVYDDBJNAE\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Descrizione Operazione:\\n(Max 350 caratteri)\",\"w\":129,\"x\":7,\"y\":350,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":29,\"name\":\"label_EIZRXIRZNI\",\"page\":1,\"spuid\":\"EIZRXIRZNI\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"Motivi del sospetto:\\n(Max 350 caratteri)\",\"w\":103,\"x\":440,\"y\":350,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Persona\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"INFORMAZIONI SULLA PERSONA FISICA CUI L"+"'"+"OPERAZIONE VA RIFERITA\",\"h\":371,\"name\":\"Persona\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ALUYEPUVLF\",\"stretch\":true,\"tabindex\":79,\"title_caption\":\"INFORMAZIONI SULLA PERSONA FISICA CUI L"+"'"+"OPERAZIONE VA RIFERITA\",\"titled\":true,\"type\":\"Box\",\"w\":840,\"x\":8,\"y\":532,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"#0000FF\",\"h\":19,\"name\":\"label_HLPYIABQPO\",\"page\":1,\"spuid\":\"HLPYIABQPO\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"Dati identificativi cliente\",\"w\":824,\"x\":16,\"y\":539,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome Cliente\",\"h\":20,\"maxlength\":30,\"name\":\"SOSCLIECOG\",\"page\":1,\"spuid\":\"IAAFYFVCOO\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":136,\"y\":567,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NVOKWXFGOG\",\"page\":1,\"spuid\":\"NVOKWXFGOG\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":93,\"x\":42,\"y\":571,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome Cliente\",\"h\":20,\"maxlength\":30,\"name\":\"SOSCLIENOM\",\"page\":1,\"spuid\":\"YZCTAZEUHT\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":640,\"y\":567,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UWBUBYMXNH\",\"page\":1,\"spuid\":\"UWBUBYMXNH\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":73,\"x\":566,\"y\":571,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Luogo di nascita Cliente\",\"h\":20,\"maxlength\":50,\"name\":\"SOSCLIELN\",\"page\":1,\"picker\":true,\"spuid\":\"EKWIYNRJCN\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":595,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KSCXKTBDNF\",\"page\":1,\"spuid\":\"KSCXKTBDNF\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"Luogo di nascita:\",\"w\":128,\"x\":7,\"y\":599,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provicnia di Nascita Cliente\",\"h\":20,\"maxlength\":2,\"name\":\"SOSCLIEPN\",\"page\":1,\"spuid\":\"GWPOQYXVMH\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":640,\"y\":595,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SRKHBXIXTJ\",\"page\":1,\"spuid\":\"SRKHBXIXTJ\",\"tabindex\":63,\"type\":\"Label\",\"value\":\"Provincia di Nascita:\",\"w\":145,\"x\":494,\"y\":599,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data di Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"SOSCLIEDN\",\"page\":1,\"picker\":true,\"spuid\":\"ESIPESUKFU\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":136,\"y\":623,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FGPSBECPQJ\",\"page\":1,\"spuid\":\"FGPSBECPQJ\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"Data di Nascita:\",\"w\":83,\"x\":52,\"y\":627,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SOSCLIESX\",\"page\":1,\"spuid\":\"ZAUFIWBFWS\",\"tabindex\":32,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":136,\"x\":640,\"y\":623,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XOANTUVUZH\",\"page\":1,\"spuid\":\"XOANTUVUZH\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":35,\"x\":604,\"y\":627,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale Cliente\",\"h\":20,\"maxlength\":16,\"name\":\"SOSCLIECF\",\"page\":1,\"spuid\":\"YAUYCDEFNH\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":136,\"x\":136,\"y\":651,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TJTUYNBQYT\",\"page\":1,\"spuid\":\"TJTUYNBQYT\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":117,\"x\":18,\"y\":655,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"#0000FF\",\"h\":19,\"name\":\"label_AKQEPKXJHR\",\"page\":1,\"spuid\":\"AKQEPKXJHR\",\"tabindex\":81,\"type\":\"Label\",\"value\":\"Residenza\",\"w\":824,\"x\":16,\"y\":679,\"zone\":\"pag1_4_8\",\"zonepath\":\"[1,4,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Paese di Residenza Cliente\",\"h\":20,\"maxlength\":3,\"name\":\"SOSCLIEPAE\",\"page\":1,\"picker\":true,\"spuid\":\"CQREEAUGJZ\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":707,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KDQYMFMALB\",\"page\":1,\"spuid\":\"KDQYMFMALB\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"Paese:\",\"w\":117,\"x\":18,\"y\":711,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"xDESSTATO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RTYSMJWDZO\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":376,\"x\":200,\"y\":707,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Comune\",\"h\":20,\"maxlength\":50,\"name\":\"SOSCLIECR\",\"page\":1,\"picker\":true,\"spuid\":\"RNXXROADTV\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":735,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Residenza Cliente\",\"h\":20,\"maxlength\":2,\"name\":\"SOSCLIEPR\",\"page\":1,\"spuid\":\"EOTGCHITKP\",\"tabindex\":69,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":640,\"y\":735,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XUKGFRRXQU\",\"page\":1,\"spuid\":\"XUKGFRRXQU\",\"tabindex\":70,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":148,\"x\":491,\"y\":739,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VKRCBRSEXQ\",\"page\":1,\"spuid\":\"VKRCBRSEXQ\",\"tabindex\":84,\"type\":\"Label\",\"value\":\"Comune:\",\"w\":80,\"x\":56,\"y\":739,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":50,\"name\":\"SOSCLIEIND\",\"page\":1,\"spuid\":\"HRARTBAAAD\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":763,\"zone\":\"pag1_4_11\",\"zonepath\":\"[1,4,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BXTLAPVHVP\",\"page\":1,\"spuid\":\"BXTLAPVHVP\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":48,\"x\":88,\"y\":767,\"zone\":\"pag1_4_11\",\"zonepath\":\"[1,4,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP Residenza Cliente\",\"h\":20,\"maxlength\":5,\"name\":\"SOSCLIECAR\",\"page\":1,\"spuid\":\"XZMROSWRMH\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":640,\"y\":763,\"zone\":\"pag1_4_12\",\"zonepath\":\"[1,4,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OAMCQZDMKT\",\"page\":1,\"spuid\":\"OAMCQZDMKT\",\"tabindex\":68,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":123,\"x\":516,\"y\":767,\"zone\":\"pag1_4_12\",\"zonepath\":\"[1,4,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"#0000FF\",\"h\":19,\"name\":\"label_BUCXTYSTDW\",\"page\":1,\"spuid\":\"BUCXTYSTDW\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"Dati Documento di Identit\\u00E0 del Cliente\",\"w\":824,\"x\":16,\"y\":791,\"zone\":\"pag1_4_13\",\"zonepath\":\"[1,4,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Documento Cliente\",\"h\":20,\"maxlength\":2,\"name\":\"SOSCLIETD\",\"page\":1,\"spuid\":\"YSEWNSQRQV\",\"tabindex\":38,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":819,\"zone\":\"pag1_4_14\",\"zonepath\":\"[1,4,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BCDMIWTOPN\",\"page\":1,\"spuid\":\"BCDMIWTOPN\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":119,\"x\":16,\"y\":823,\"zone\":\"pag1_4_14\",\"zonepath\":\"[1,4,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Documento Cliente\",\"h\":20,\"maxlength\":15,\"name\":\"SOSCLIEND\",\"page\":1,\"spuid\":\"RGTEMJRSBB\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":640,\"y\":819,\"zone\":\"pag1_4_15\",\"zonepath\":\"[1,4,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GIPVDDJTVU\",\"page\":1,\"spuid\":\"GIPVDDJTVU\",\"tabindex\":72,\"type\":\"Label\",\"value\":\"N\\u00B0 Documento:\",\"w\":119,\"x\":520,\"y\":823,\"zone\":\"pag1_4_15\",\"zonepath\":\"[1,4,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Rilascio\",\"h\":20,\"maxlength\":10,\"name\":\"SOSCLIEDRD\",\"page\":1,\"picker\":true,\"spuid\":\"MDMENXCYFS\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":136,\"y\":847,\"zone\":\"pag1_4_16\",\"zonepath\":\"[1,4,16]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RPUYWHBPLW\",\"page\":1,\"spuid\":\"RPUYWHBPLW\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"Data Rilascio:\",\"w\":71,\"x\":65,\"y\":851,\"zone\":\"pag1_4_16\",\"zonepath\":\"[1,4,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Scadenza\",\"h\":20,\"maxlength\":10,\"name\":\"SOSCLIEDSD\",\"page\":1,\"picker\":true,\"spuid\":\"SMDOEMVCES\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":640,\"y\":847,\"zone\":\"pag1_4_17\",\"zonepath\":\"[1,4,17]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KVXUAURODE\",\"page\":1,\"spuid\":\"KVXUAURODE\",\"tabindex\":88,\"type\":\"Label\",\"value\":\"Data Scadenza:\",\"w\":83,\"x\":557,\"y\":851,\"zone\":\"pag1_4_17\",\"zonepath\":\"[1,4,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 e Luogo Rilascio\",\"h\":20,\"maxlength\":50,\"name\":\"SOSCLIEAUD\",\"page\":1,\"spuid\":\"LVYUCXICCL\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":875,\"zone\":\"pag1_4_18\",\"zonepath\":\"[1,4,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XQKIDGOLHP\",\"page\":1,\"spuid\":\"XQKIDGOLHP\",\"tabindex\":89,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 e Luogo Rilascio:\",\"w\":134,\"x\":2,\"y\":879,\"zone\":\"pag1_4_18\",\"zonepath\":\"[1,4,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_sosBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),status.context.Translate("MSG_FORM_FUNCTION_"+status.m_cClientMode.toUpperCase())),"form");
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html " + ( SPLib.IsMobile( status.request )  ? "ps-stretch": "" )+ ">" +
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
     "<script src='armt_cgo_sos?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    l_cJsUid = SPPrxycizer.proxycizedPath("suggesterlib.js");
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_sos_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_sos_edit.js'>" +
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
      status.out.println("w_SOSCODICE=a[0];");
      status.out.println("op_SOSCODICE=a[1];");
      status.out.println("w_SOSCODDIP=a[2];");
      status.out.println("w_SOSSEGNANT=a[3];");
      status.out.println("w_SOSSEGNAFAX=a[4];");
      status.out.println("w_SOSSEGNAEM=a[5];");
      status.out.println("w_SOSSEGNACF=a[6];");
      status.out.println("w_SOSSEGNACOG=a[7];");
      status.out.println("w_SOSSEGNANOM=a[8];");
      status.out.println("w_SOSSEGNALN=a[9];");
      status.out.println("w_SOSSEGNADN=a[10];");
      status.out.println("w_SOSSEGNASX=a[11];");
      status.out.println("w_SOSSTATOOP=a[12];");
      status.out.println("w_SOSDATAOP=a[13];");
      status.out.println("w_SOSTIPOOP=a[14];");
      status.out.println("w_SOSIMPOPE=a[15];");
      status.out.println("w_SOSMEZPAG=a[16];");
      status.out.println("w_SOSNUMBON=a[17];");
      status.out.println("w_SOSBANASS=a[18];");
      status.out.println("w_SOSNUMASS=a[19];");
      status.out.println("w_SOSDESOPE=a[20];");
      status.out.println("w_SOSMOTSOS=a[21];");
      status.out.println("w_SOSCLIECOG=a[22];");
      status.out.println("w_SOSCLIENOM=a[23];");
      status.out.println("w_SOSCLIELN=a[24];");
      status.out.println("w_SOSCLIEDN=a[25];");
      status.out.println("w_SOSCLIESX=a[26];");
      status.out.println("w_SOSCLIECF=a[27];");
      status.out.println("w_SOSCLIEPAE=a[28];");
      status.out.println("w_SOSCLIECR=a[29];");
      status.out.println("w_SOSCLIEIND=a[30];");
      status.out.println("w_SOSCLIECAR=a[31];");
      status.out.println("w_SOSCLIETD=a[32];");
      status.out.println("w_SOSCLIEND=a[33];");
      status.out.println("w_SOSCLIEDRD=a[34];");
      status.out.println("w_SOSCLIEDSD=a[35];");
      status.out.println("w_SOSCLIEAUD=a[36];");
      status.out.println("w_SOSSEGNAPN=a[37];");
      status.out.println("w_SOSCLIEPN=a[38];");
      status.out.println("w_SOSCLIEPR=a[39];");
      status.out.println("w_SOSUTENTE=a[40];");
      status.out.println("w_SOSDATSEG=a[41];");
      status.out.println("w_gCodDip=a[42];");
      status.out.println("w_IDBIGLIETTO=a[43];");
      status.out.println("w_xdesdip=a[44];");
      status.out.println("w_gUserCode=a[45];");
      status.out.println("w_xDESSTATO=a[46];");
      status.out.println("op_codazi=a[47];");
      status.out.println("if (Gt(a.length,48)) {");
      status.out.println("o_SOSCODICE=w_SOSCODICE;");
      status.out.println("o_IDBIGLIETTO=w_IDBIGLIETTO;");
      status.out.println("o_SOSDATAOP=w_SOSDATAOP;");
      status.out.println("o_SOSDESOPE=w_SOSDESOPE;");
      status.out.println("o_SOSMOTSOS=w_SOSMOTSOS;");
      status.out.println("o_SOSCLIEDRD=w_SOSCLIEDRD;");
      status.out.println("o_SOSCLIEDSD=w_SOSCLIEDSD;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['SOSCODICE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_sos_proc.js'>" +
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
    status.m_cBodyAttributes = "onload=OnLoad() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(968,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("AppletTag('Link');");
      status.out.println("AppletTag('Autonumber');");
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
    f.SetParameter("Table","cgo_sos");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","SOSCODICE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_cgo_sosBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({SOSCODICE:"+SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_sosBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({SOSCODICE:"+SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_cgo_sosBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({SOSCODICE:"+SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_cgo_sosBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({SOSCODICE:"+SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_cgo_sosBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({SOSCODICE:"+SPLib.ToJSValue(BO.w_SOSCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_sosBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_sosBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+arfn_cgo_chkdata.m_cEntityUid+"/arfn_cgo_chkdata.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_cgo_sos_biglietto.m_cEntityUid+"/arrt_cgo_sos_biglietto.js'>" +
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
      arfn_cgo_chkdata.GetCallableNames(callable);
      arrt_cgo_sos_biglietto.GetCallableNames(callable);
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_cgo_sosBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(BO.w_SOSCODICE,"N",10,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gUserCode,"N",4,0));
    } else if (CPLib.eq(p_cUID,"DHBRXDCHIH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NMTFLCHLGD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UXJUHWBCMH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EKWIYNRJCN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CQREEAUGJZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RNXXROADTV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_sosBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_SOSCODDIP))) {
        a = GetCheckVars(status,BO,"DHBRXDCHIH");
        b = status.m_CheckVars.optString("DHBRXDCHIH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_SOSSEGNALN))) {
        a = GetCheckVars(status,BO,"NMTFLCHLGD");
        b = status.m_CheckVars.optString("NMTFLCHLGD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_SOSCLIELN))) {
        a = GetCheckVars(status,BO,"EKWIYNRJCN");
        b = status.m_CheckVars.optString("EKWIYNRJCN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_SOSCLIEPAE))) {
        a = GetCheckVars(status,BO,"CQREEAUGJZ");
        b = status.m_CheckVars.optString("CQREEAUGJZ");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
