import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_ae_aedelrig extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*dfc6dd0d*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "aederig";
    }
    public String w_IDBASE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDBASE,context,"aederig","IDBASE","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='IDBASE' type='hidden' value="+SPLib.ToHTMLValue(w_IDBASE,"C",10,0)+">" +
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
    armt_ae_aedelrigBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_aederig;
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
      status.w_IDBASE = BO.w_IDBASE;
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
    return "Deleghe";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_ae_aedelrig";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 791;
    l_eg.m_nEntityHeight = 404;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"aederig","personbo","aedecanc"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("box_YORQOIOBQN","",""),new ZoneItem("box_RGYIJRGRVR","",""),new ZoneItem("box_SWHJSXDMQR","",""),new ZoneItem("box_HDQLRPYTAN","Dati Comunicazione Apertura","titled_box"),new ZoneItem("box_ZUHLCKITMM","Dati Comunicazione Chiusura","titled_box"),new ZoneItem("box_TNLEGEGWAQ","Dati Comunicazione Rettifica","titled_box"),new ZoneItem("box_NNCELEXRKP","Dati Comunicazione Cancellazione","titled_box")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("RAPPORTO","C",25,0, "edit","Codice Rapporto"),
                   new SPItem("COINT","C",1,0, "edit","Tipo Rapporto"),
                   new SPItem("TIPOAG","C",2,0, "edit",""),
                   new SPItem("IDBASE","C",10,0, "hide",""),
                   new SPItem("CONNESINT","C",16,0, "edit","Codice Delegato"),
                   new SPItem("xcfestero","N",1,0, "hide","Codice Fiscale Estero"),
                   new SPItem("ADATA","D",8,0, "edit","data Inizio"),
                   new SPItem("ASPEDITO","N",1,0, "edit","Spedito Agenzia Entrate"),
                   new SPItem("AFILE","C",15,0, "edit","Nome File Spedizione"),
                   new SPItem("APROG","C",25,0, "edit","Progressivo"),
                   new SPItem("AOLDPROG","C",25,0, "hide","Vecchio Progressivo"),
                   new SPItem("AOLDFILE","C",15,0, "hide","Nome Vecchio File"),
                   new SPItem("CSPEDITO","N",1,0, "edit","Spedizione Chiusura"),
                   new SPItem("CPROG","C",25,0, "edit","Progressivo Atuale"),
                   new SPItem("COLDPROG","C",25,0, "hide","Vecchio Progressivo"),
                   new SPItem("CFILE","C",15,0, "edit","Nome file spedizione chiusura"),
                   new SPItem("COLDFILE","C",15,0, "hide","Vecchio file spedizione chiusura"),
                   new SPItem("IDRIF","C",10,0, "hide","ID RIferimento"),
                   new SPItem("NOCODFISC","C",1,0, "hide","Codice Fiscale Estero"),
                   new SPItem("ADTPRE","D",8,0, "hide",""),
                   new SPItem("CDTPRE","D",8,0, "hide",""),
                   new SPItem("xragsoc","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("CDATA","D",8,0, "edit","data Inizio"),
                   new SPItem("IDESITO","C",8,0, "edit","Esito AGE"),
                   new SPItem("PROGDLG","N",15,0, "hide","Progressivo Riga"),
                   new SPItem("ADATARET","D",8,0, "edit","Data Rettifica"),
                   new SPItem("RSPEDITO","N",1,0, "edit",""),
                   new SPItem("COLDFILE","C",15,0, "edit","Vecchio file spedizione chiusura"),
                   new SPItem("COLDPROG","C",25,0, "edit","Vecchio Progressivo"),
                   new SPItem("desctrap","C",110,0, "hide","Descrizione"),
                   new SPItem("IDBASE","C",10,0, "hide",""),
                   new SPItem("dtcanc","D",8,0, "show",""),
                   new SPItem("spcanc","N",1,0, "show",""),
                   new SPItem("filecanc","C",15,0, "show",""),
                   new SPItem("idcanc","C",25,0, "show",""),
                   new SPItem("DATESITO","D",8,0, "edit","Data Creazione Esito")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_ae_aedelrigBO BO) {
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
    l_translations=new String[][]{{"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"1025726040",p_Context.Translate("Data Creazione Esito")},
    {"1027202812",p_Context.Translate("Nome File Spedizione")},
    {"1039309729",p_Context.Translate("Nome file spedizione chiusura")},
    {"10580790440",p_Context.Translate("Codice Delegato")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10710533789",p_Context.Translate("Trasmesso con il file")},
    {"10938597242",p_Context.Translate("Nome Vecchio File")},
    {"11116511596",p_Context.Translate("Codice Rapporto")},
    {"11157094597",p_Context.Translate("Impossibile inserire (Dati storici)")},
    {"11284067142",p_Context.Translate("Esito AGE")},
    {"11329559720",p_Context.Translate("Data Rettifica")},
    {"11446421191",p_Context.Translate("Progressivo")},
    {"11638313586",p_Context.Translate("Impossibile modificare (Dati storici)")},
    {"11741368204",p_Context.Translate("Confermi l'annullamento della rettifica/cancellazione ?")},
    {"11797664083",p_Context.Translate("Tipologie Rapporto")},
    {"11827041086",p_Context.Translate("ID RIferimento")},
    {"1198480061",p_Context.Translate("Impossibile cancellare (Dati storici)")},
    {"1265210153",p_Context.Translate("Spedito Agenzia Entrate")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"1810743956",p_Context.Translate("Deleghe")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"218917798",p_Context.Translate("Spedizione Chiusura")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"45547646",p_Context.Translate("data Inizio")},
    {"533198559",p_Context.Translate("Vecchio Progressivo")},
    {"665673017",p_Context.Translate("Progressivo Riga")},
    {"863382899",p_Context.Translate("Vecchio file spedizione chiusura")},
    {"910975989",p_Context.Translate("Progressivo Atuale")}};
    return l_translations;
  }
  void WriteStyles(armt_ae_aedelrigBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_ae_aedelrig.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_ae_aedelrigBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ae_aedelrig',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_ae_aedelrig",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_ae_aedelrigBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_ae_aedelrigBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:404px;width:791px;display:none'>" +
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
  void WriteControls_p1_b0(armt_ae_aedelrigBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:404px'>" +
    "");
    status.out.println(
     "<div id='YORQOIOBQN_DIV' class='UntitledBox'>" +
     "<div id='YORQOIOBQN' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RAPPORTO' id='LXORWVRYJJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='COINT' id='JHOQNVHZXH' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_COINT))?"SELECTED":"")+">" +
     ""+status.context.Translate("Cointestato")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_COINT))?"SELECTED":"")+">" +
     ""+status.context.Translate("Non Cointestato")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_COINT))?"SELECTED":"")+">" +
     ""+status.context.Translate("Delega/Procura")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('JHOQNVHZXH'),w_COINT,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TIPOAG' id='BHAVHLFPAC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNESINT' id='DZWSXMBIHR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESINT,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='DZWSXMBIHR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "DZWSXMBIHR", "personbo", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADATA' id='HUMSCLHVTQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADATA,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='OYBCLSBWWU_DIV'>" +
     "<input name='ASPEDITO' id='OYBCLSBWWU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ASPEDITO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_ASPEDITO)?"CHECKED":"")+">" +
     "<label id='OYBCLSBWWU_LBL' for='OYBCLSBWWU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmesso con il file"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AFILE' id='EDCVGCRZZZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AFILE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TOFVCFNDFU_DIV'>" +
     "<label id='TOFVCFNDFU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Delegato:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='APROG' id='JINDLZUJGB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_APROG,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='LLONFBQGWC_DIV'>" +
     "<input name='CSPEDITO' id='LLONFBQGWC' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CSPEDITO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_CSPEDITO)?"CHECKED":"")+">" +
     "<label id='LLONFBQGWC_LBL' for='LLONFBQGWC' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmesso con il file"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPROG' id='YFRSEVUKNF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPROG,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CFILE' id='HBCZFDMLIW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CFILE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OICGZUOZYP_DIV'>" +
     "<label id='OICGZUOZYP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CTCKWHZVTZ_DIV'>" +
     "<label id='CTCKWHZVTZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rap. Ag. Entrate:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GDTYXHVEHO_DIV'>" +
     "<label id='GDTYXHVEHO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SVRLUYRVRK_DIV'>" +
     "<label id='SVRLUYRVRK'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsoc)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='RGYIJRGRVR_DIV' class='UntitledBox'>" +
     "<div id='RGYIJRGRVR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='SWHJSXDMQR_DIV' class='UntitledBox'>" +
     "<div id='SWHJSXDMQR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XLPPGWOBPA_DIV'>" +
     "<label id='XLPPGWOBPA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("APERTURA DELEGA"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='INHVWDNVJQ_DIV'>" +
     "<label id='INHVWDNVJQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CHIUSURA DELEGA"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EEPWGWPHCL_DIV'>" +
     "<label id='EEPWGWPHCL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Apertura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CDATA' id='EYLNNWDCKZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CDATA,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SXESAQVPYH_DIV'>" +
     "<label id='SXESAQVPYH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Apertura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PYCUXKNKCJ_DIV'>" +
     "<label id='PYCUXKNKCJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MVLNTEGKBL_DIV'>" +
     "<label id='MVLNTEGKBL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='RZXJJIHWRO' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Rettifica delle Comunicazioni Inviate"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='LBDAXRYAIV' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Cancellazione delle Comunicazioni Inviate"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.out.println(
     "<div id='HDQLRPYTAN_DIV' class='TitledBox'>" +
     "<span id='HDQLRPYTAN_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Dati Comunicazione Apertura")+"</span>" +
     "<div id='HDQLRPYTAN'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='ZUHLCKITMM_DIV' class='TitledBox'>" +
     "<span id='ZUHLCKITMM_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Dati Comunicazione Chiusura")+"</span>" +
     "<div id='ZUHLCKITMM'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='IDESITO' id='ZDQIQPDLMA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDESITO,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YBLTSMLFUZ_DIV'>" +
     "<label id='YBLTSMLFUZ' for='ZDQIQPDLMA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Esito AGE:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADATARET' id='GVMNAQQJWY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADATARET,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='JDNKWMLZTI_DIV'>" +
     "<input name='RSPEDITO' id='JDNKWMLZTI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_RSPEDITO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_RSPEDITO)?"CHECKED":"")+">" +
     "<label id='JDNKWMLZTI_LBL' for='JDNKWMLZTI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmesso con il file"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='COLDFILE' id='JWUIHKTDYH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COLDFILE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='COLDPROG' id='JCJVALRBTS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COLDPROG,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZQIDHWPUXR_DIV'>" +
     "<label id='ZQIDHWPUXR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rettifica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QUKJZLRVOL_DIV'>" +
     "<label id='QUKJZLRVOL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='TNLEGEGWAQ_DIV' class='TitledBox'>" +
     "<span id='TNLEGEGWAQ_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Dati Comunicazione Rettifica")+"</span>" +
     "<div id='TNLEGEGWAQ'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='NNCELEXRKP_DIV' class='TitledBox'>" +
     "<span id='NNCELEXRKP_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Dati Comunicazione Cancellazione")+"</span>" +
     "<div id='NNCELEXRKP'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WJDBESRNAN_DIV'>" +
     "<label id='WJDBESRNAN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cancellazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KBSYJLHZOZ_DIV'>" +
     "<label id='KBSYJLHZOZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='dtcanc' id='FMXMNQMEMH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_dtcanc,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span id='GRVAHWHFJH_DIV'>" +
     "<input name='spcanc' id='GRVAHWHFJH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_spcanc,"N",1,0,"", status.m_oRegSettings)+" disabled "+(CPLib.eq(1,BO.w_spcanc)?"CHECKED":"")+">" +
     "<label id='GRVAHWHFJH_LBL' for='GRVAHWHFJH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmesso con il file"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='filecanc' id='TZPQRTXHYT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_filecanc,"C",15,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='idcanc' id='GWASKALOUK' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_idcanc,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VQNRBICOXA_DIV' style='display:none'>" +
     "<label id='VQNRBICOXA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("OPERAZIONE CANCELLATA"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='URZTYMSMYS' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Annulla Rettifica"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATESITO' id='UCLGIPKHHK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATESITO,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CYWLVXKPWG_DIV'>" +
     "<label id='CYWLVXKPWG' for='UCLGIPKHHK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Creazione Esito:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_ae_aedelrigBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_ae_aedelrigBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_ae_aedelrigBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COINT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOAG,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_IDBASE:BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESINT,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADATA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASPEDITO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_APROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AOLDPROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AOLDFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CSPEDITO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLDPROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLDFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDRIF,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOCODFISC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADTPRE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDTPRE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDESITO,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROGDLG,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PROGDLG:BO.w_PROGDLG,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADATARET,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RSPEDITO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATESITO,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcfestero,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsoc,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desctrap,"C",110,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dtcanc,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_spcanc,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_filecanc,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcanc,"C",25,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_ae_aedelrigBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_SVRLUYRVRK = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(404,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(791,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_ae_aedelrig"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'DZWSXMBIHR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DZWSXMBIHR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'VQOCGQDTYC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VQOCGQDTYC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,aedecanc,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'DZWSXMBIHR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'VQOCGQDTYC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,aedecanc,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_ae_aedelrig","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_ae_aedelrig",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_YORQOIOBQN"),"")) {
      status.quoteAndAppend("box_YORQOIOBQN","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_RGYIJRGRVR"),"")) {
      status.quoteAndAppend("box_RGYIJRGRVR","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_SWHJSXDMQR"),"")) {
      status.quoteAndAppend("box_SWHJSXDMQR","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_HDQLRPYTAN"),"")) {
      status.quoteAndAppend("box_HDQLRPYTAN","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_ZUHLCKITMM"),"")) {
      status.quoteAndAppend("box_ZUHLCKITMM","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_TNLEGEGWAQ"),"")) {
      status.quoteAndAppend("box_TNLEGEGWAQ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_NNCELEXRKP"),"")) {
      status.quoteAndAppend("box_NNCELEXRKP","hide","box");
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
  void WriteMainFormScript(armt_ae_aedelrigBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ae_aedelrig',false);");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('LXORWVRYJJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JHOQNVHZXH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BHAVHLFPAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DZWSXMBIHR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DZWSXMBIHR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUMSCLHVTQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OYBCLSBWWU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EDCVGCRZZZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JINDLZUJGB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LLONFBQGWC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YFRSEVUKNF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HBCZFDMLIW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EYLNNWDCKZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZDQIQPDLMA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GVMNAQQJWY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JDNKWMLZTI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JWUIHKTDYH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JCJVALRBTS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UCLGIPKHHK')) SetDisabled(c,true);");
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
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
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
    status.out.println("function ChildSelectedPage(name) {");
    status.out.println("var l_cRes = '';");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
        status.out.println("if (Eq(p_uid,'IDBASE') || Empty(p_uid)) {");
        status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
        status.out.println("}");
      }
      status.out.println("var l_b1 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'PROGDLG') || Empty(p_uid)) {");
      status.out.println("l_b1= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_IDBASE','PRGAEDELEG');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('IDBASE',w_IDBASE,op_IDBASE,'C',10,0);");
        status.out.println("AutonumberApplet().SetETName('aederig');");
        status.out.println("w_IDBASE=AutonumberApplet().GetAutonumberString('IDBASE');");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PROGDLG','PROGAED');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PROGDLG',w_PROGDLG,op_PROGDLG,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('aederig');");
      status.out.println("w_PROGDLG=AutonumberApplet().GetAutonumberDouble('PROGDLG');");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("op_codazi=m_cCompany;");
        status.out.println("op_IDBASE=w_IDBASE;");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("op_PROGDLG=w_PROGDLG;");
      status.out.println("}");
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- armt_ae_aedelrig");
    status.out.println("function ModOpen() {");
    status.out.println("  if (confirm('La modifica comporta obbligo di ricomunicare i dati!! Vuoi proseguire ?')) {");
    status.out.println("    var l_oWv = InitWvApplet();");
    status.out.println("    l_oWv.setValue('oldintest',AsAppletValue(w_CONNESINT));");
    status.out.println("    l_oWv.setValue('olddata',AsAppletValue(w_ADATA));");
    status.out.println("    l_oWv.setValue('newintest',AsAppletValue(w_CONNESINT));");
    status.out.println("    l_oWv.setValue('newdate',AsAppletValue(w_ADATA));        ");
    status.out.println("    l_oWv.setValue('xragold',AsAppletValue(w_xragsoc));");
    status.out.println("    l_oWv.setValue('xragnew',AsAppletValue(w_xragsoc));");
    status.out.println("    l_oWv.setValue('oldprog',AsAppletValue(w_APROG));");
    status.out.println("    l_oWv.setValue('oldidbase',AsAppletValue(w_IDBASE));");
    status.out.println("    l_oWv.setValue('oldrappo',AsAppletValue(w_RAPPORTO));");
    status.out.println("    l_oWv.setValue('oldfile',AsAppletValue(w_AFILE));");
    status.out.println("    l_oWv.setValue('olddatac',AsAppletValue(w_CDATA));");
    status.out.println("    l_oWv.setValue('newdatec',AsAppletValue(w_CDATA)); ");
    status.out.println("    l_oWv.setValue('idesito',AsAppletValue(w_IDESITO));         ");
    status.out.println("    l_oWv.setValue('m_cParameterSequence',AsAppletValue('oldintest,olddata,newintest,newdate,xragold,xragnew,oldprog,oldidbase,oldrappo,oldfile,olddatac,newdatec,idesito'));");
    status.out.println("    _modifyandopen(PlatformPathStart('arpg_moddeleghe')+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,width=675,height=480,resizable=1',false)");
    status.out.println("  }  ");
    status.out.println("}");
    status.out.println("");
    status.out.println("function ModClose() {");
    status.out.println("  if (confirm('La modifica comporta obbligo di ricomunicare i dati!! Vuoi proseguire ?')) {");
    status.out.println("    var l_oWv = InitWvApplet();         ");
    status.out.println("    l_oWv.setValue('oldprog',AsAppletValue(w_APROG));");
    status.out.println("    l_oWv.setValue('oldidbase',AsAppletValue(w_IDBASE));");
    status.out.println("    l_oWv.setValue('oldrappo',AsAppletValue(w_RAPPORTO));");
    status.out.println("    l_oWv.setValue('oldfile',AsAppletValue(w_AFILE));");
    status.out.println("    l_oWv.setValue('m_cParameterSequence',AsAppletValue('oldprog,oldidbase,oldrappo,oldfile'));");
    status.out.println("    _modifyandopen(PlatformPathStart('arpg_clsdeleghe')+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,width=675,height=70,resizable=1',false)      ");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_ae_aedelrigBO getBO(ServletStatus status) {
    armt_ae_aedelrigBO BO = new armt_ae_aedelrigBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_IDBASE = BO.w_IDBASE;
    BO.op_PROGDLG = BO.w_PROGDLG;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_ae_aedelrigBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("aederig",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_ae_aedelrigBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_ae_aedelrigBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbrapp,CPSql.BuildSQLPhrase("CODICE,DESCRI",BO.m_cPhName_tbrapp,"","DESCRI"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var BHAVHLFPAC_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_ae_aedelrigBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_aederig;
    String l_cPhName = BO.m_cPhName_aederig;
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
      String l_cQueryFilter = armt_ae_aedelrigBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_aederig+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("aederig");
    String l_cPhName = CPSql.ManipulateTablePhName("aederig",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_ae_aedelrigBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_ae_aedelrigBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_aederig,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_aederig,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_ae_aedelrigBO BO) {
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
  void Edit(ServletStatus status,armt_ae_aedelrigBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
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
  void New(ServletStatus status,armt_ae_aedelrigBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_ae_aedelrigBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_ae_aedelrigBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_IDBASE = "";
      } else {
        BO.w_IDBASE = l_rsKeys.GetString("IDBASE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_IDBASE = BO.w_IDBASE;
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
  void EditLoad(ServletStatus status,armt_ae_aedelrigBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_ae_aedelrigBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_IDBASE);
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
  void DeleteMessage(ServletStatus status,armt_ae_aedelrigBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_ae_aedelrigBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    String l_old_IDBASE = "";
    if (CPLib.ne(BO.w_IDBASE,BO.op_IDBASE)) {
      l_old_IDBASE = BO.op_IDBASE;
    }
    double l_old_PROGDLG = 0;
    if (CPLib.ne(BO.w_PROGDLG,BO.op_PROGDLG)) {
      l_old_PROGDLG = BO.op_PROGDLG;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_IDBASE))) {
        BO.op_IDBASE = l_old_IDBASE;
      }
      if ( ! (CPLib.Empty(l_old_PROGDLG))) {
        BO.op_PROGDLG = l_old_PROGDLG;
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
  void Discard(ServletStatus status,armt_ae_aedelrigBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_ae_aedelrigBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",404);
    item.put("w",791);
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
    item.put("altInterfaceFor","armt_ae_aedelrig");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_YORQOIOBQN\",\"h\":392,\"name\":\"box_YORQOIOBQN\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"tabindex\":1,\"type\":\"Box\",\"w\":768,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Rapporto\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"spuid\":\"LXORWVRYJJ\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":136,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OICGZUOZYP\",\"page\":1,\"spuid\":\"OICGZUOZYP\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Codice Rapporto:\",\"w\":116,\"x\":16,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Rapporto\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"COINT\",\"page\":1,\"spuid\":\"JHOQNVHZXH\",\"tabindex\":3,\"textlist\":\"Cointestato,Non Cointestato,Delega\\/Procura\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":168,\"x\":600,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"TIPOAG\",\"page\":1,\"spuid\":\"BHAVHLFPAC\",\"tabindex\":4,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":368,\"x\":136,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CTCKWHZVTZ\",\"page\":1,\"spuid\":\"CTCKWHZVTZ\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Tipo Rap. Ag. Entrate:\",\"w\":116,\"x\":16,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDTYXHVEHO\",\"page\":1,\"spuid\":\"GDTYXHVEHO\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Natura Rapporto:\",\"w\":85,\"x\":512,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Esito AGE\",\"h\":20,\"maxlength\":8,\"name\":\"IDESITO\",\"page\":1,\"spuid\":\"ZDQIQPDLMA\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":696,\"y\":14,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YBLTSMLFUZ\",\"page\":1,\"spuid\":\"YBLTSMLFUZ\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"Esito AGE:\",\"w\":112,\"x\":581,\"y\":18,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Creazione Esito\",\"h\":20,\"maxlength\":10,\"name\":\"DATESITO\",\"page\":1,\"spuid\":\"UCLGIPKHHK\",\"tabindex\":63,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":552,\"y\":14,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CYWLVXKPWG\",\"page\":1,\"spuid\":\"CYWLVXKPWG\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"Data Creazione Esito:\",\"w\":114,\"x\":438,\"y\":18,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Delegato\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESINT\",\"page\":1,\"picker\":true,\"spuid\":\"DZWSXMBIHR\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":118,\"x\":136,\"y\":70,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TOFVCFNDFU\",\"page\":1,\"spuid\":\"TOFVCFNDFU\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Codice Delegato:\",\"w\":82,\"x\":53,\"y\":74,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SVRLUYRVRK\",\"page\":1,\"spuid\":\"SVRLUYRVRK\",\"tabindex\":28,\"type\":\"Label\",\"w\":432,\"x\":280,\"y\":74,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_RGYIJRGRVR\",\"h\":28,\"name\":\"box_RGYIJRGRVR\",\"page\":1,\"shrinkable\":true,\"spuid\":\"RGYIJRGRVR\",\"tabindex\":29,\"type\":\"Box\",\"w\":368,\"x\":16,\"y\":105,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_XLPPGWOBPA\",\"page\":1,\"spuid\":\"XLPPGWOBPA\",\"tabindex\":31,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"APERTURA DELEGA\",\"w\":352,\"x\":24,\"y\":112,\"zone\":\"pag1_1_4_1\",\"zonepath\":\"[1,1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_SWHJSXDMQR\",\"h\":28,\"name\":\"box_SWHJSXDMQR\",\"page\":1,\"shrinkable\":true,\"spuid\":\"SWHJSXDMQR\",\"tabindex\":30,\"type\":\"Box\",\"w\":368,\"x\":400,\"y\":105,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_INHVWDNVJQ\",\"page\":1,\"spuid\":\"INHVWDNVJQ\",\"tabindex\":32,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"CHIUSURA DELEGA\",\"w\":352,\"x\":408,\"y\":112,\"zone\":\"pag1_1_5_1\",\"zonepath\":\"[1,1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HDQLRPYTAN\",\"box_type\":\"titled_box\",\"comment\":\"Dati Comunicazione Apertura\",\"h\":91,\"name\":\"box_HDQLRPYTAN\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HDQLRPYTAN\",\"tabindex\":40,\"title_caption\":\"Dati Comunicazione Apertura\",\"titled\":true,\"type\":\"Box\",\"w\":368,\"x\":16,\"y\":147,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"data Inizio\",\"h\":20,\"maxlength\":10,\"name\":\"ADATA\",\"page\":1,\"spuid\":\"HUMSCLHVTQ\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":104,\"y\":154,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EEPWGWPHCL\",\"page\":1,\"spuid\":\"EEPWGWPHCL\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Data Apertura:\",\"w\":80,\"x\":22,\"y\":158,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Spedito Agenzia Entrate\",\"h\":21,\"label_text\":\"Trasmesso con il file\",\"maxlength\":4,\"name\":\"ASPEDITO\",\"page\":1,\"spuid\":\"OYBCLSBWWU\",\"tabindex\":9,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":120,\"x\":24,\"y\":181,\"zone\":\"pag1_1_6_2\",\"zonepath\":\"[1,1,6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome File Spedizione\",\"h\":20,\"maxlength\":15,\"name\":\"AFILE\",\"page\":1,\"spuid\":\"EDCVGCRZZZ\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":104,\"x\":144,\"y\":182,\"zone\":\"pag1_1_6_2\",\"zonepath\":\"[1,1,6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Progressivo\",\"h\":20,\"maxlength\":25,\"name\":\"APROG\",\"page\":1,\"spuid\":\"JINDLZUJGB\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":144,\"y\":210,\"zone\":\"pag1_1_6_3\",\"zonepath\":\"[1,1,6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PYCUXKNKCJ\",\"page\":1,\"spuid\":\"PYCUXKNKCJ\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Progressivo\",\"w\":56,\"x\":80,\"y\":214,\"zone\":\"pag1_1_6_3\",\"zonepath\":\"[1,1,6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_ZUHLCKITMM\",\"box_type\":\"titled_box\",\"comment\":\"Dati Comunicazione Chiusura\",\"h\":91,\"name\":\"box_ZUHLCKITMM\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ZUHLCKITMM\",\"tabindex\":41,\"title_caption\":\"Dati Comunicazione Chiusura\",\"titled\":true,\"type\":\"Box\",\"w\":368,\"x\":400,\"y\":147,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Spedizione Chiusura\",\"h\":21,\"label_text\":\"Trasmesso con il file\",\"maxlength\":4,\"name\":\"CSPEDITO\",\"page\":1,\"spuid\":\"LLONFBQGWC\",\"tabindex\":15,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":120,\"x\":408,\"y\":181,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome file spedizione chiusura\",\"h\":20,\"maxlength\":15,\"name\":\"CFILE\",\"page\":1,\"spuid\":\"HBCZFDMLIW\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":528,\"y\":182,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"data Inizio\",\"h\":20,\"maxlength\":10,\"name\":\"CDATA\",\"page\":1,\"spuid\":\"EYLNNWDCKZ\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":488,\"y\":154,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SXESAQVPYH\",\"page\":1,\"spuid\":\"SXESAQVPYH\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Data Apertura:\",\"w\":80,\"x\":406,\"y\":158,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Progressivo Atuale\",\"h\":20,\"maxlength\":25,\"name\":\"CPROG\",\"page\":1,\"spuid\":\"YFRSEVUKNF\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":528,\"y\":210,\"zone\":\"pag1_1_7_2\",\"zonepath\":\"[1,1,7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MVLNTEGKBL\",\"page\":1,\"spuid\":\"MVLNTEGKBL\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Progressivo\",\"w\":56,\"x\":464,\"y\":214,\"zone\":\"pag1_1_7_2\",\"zonepath\":\"[1,1,7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_NNCELEXRKP\",\"box_type\":\"titled_box\",\"comment\":\"Dati Comunicazione Cancellazione\",\"h\":91,\"name\":\"box_NNCELEXRKP\",\"page\":1,\"shrinkable\":true,\"spuid\":\"NNCELEXRKP\",\"tabindex\":53,\"title_caption\":\"Dati Comunicazione Cancellazione\",\"titled\":true,\"type\":\"Box\",\"w\":368,\"x\":400,\"y\":245,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WJDBESRNAN\",\"page\":1,\"spuid\":\"WJDBESRNAN\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"Cancellazione:\",\"w\":80,\"x\":406,\"y\":256,\"zone\":\"pag1_1_8_1\",\"zonepath\":\"[1,1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"dtcanc\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FMXMNQMEMH\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":488,\"y\":253,\"zone\":\"pag1_1_8_1\",\"zonepath\":\"[1,1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_KBSYJLHZOZ\",\"page\":1,\"spuid\":\"KBSYJLHZOZ\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Progressivo\",\"w\":56,\"x\":464,\"y\":312,\"zone\":\"pag1_1_8_2\",\"zonepath\":\"[1,1,8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":25,\"name\":\"idcanc\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"GWASKALOUK\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":528,\"y\":308,\"zone\":\"pag1_1_8_2\",\"zonepath\":\"[1,1,8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"disabled\":\"true\",\"h\":21,\"label_text\":\"Trasmesso con il file\",\"maxlength\":2,\"name\":\"spcanc\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"GRVAHWHFJH\",\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":115,\"x\":408,\"y\":279,\"zone\":\"pag1_1_8_3\",\"zonepath\":\"[1,1,8,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":15,\"name\":\"filecanc\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TZPQRTXHYT\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":528,\"y\":280,\"zone\":\"pag1_1_8_3\",\"zonepath\":\"[1,1,8,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_RZXJJIHWRO\",\"page\":1,\"picker\":true,\"spuid\":\"RZXJJIHWRO\",\"tabindex\":38,\"type\":\"Button\",\"value\":\"Rettifica delle Comunicazioni Inviate\",\"w\":208,\"x\":16,\"y\":343,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_LBDAXRYAIV\",\"page\":1,\"picker\":true,\"spuid\":\"LBDAXRYAIV\",\"tabindex\":39,\"type\":\"Button\",\"value\":\"Cancellazione delle Comunicazioni Inviate\",\"w\":231,\"x\":288,\"y\":343,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_URZTYMSMYS\",\"page\":1,\"picker\":true,\"spuid\":\"URZTYMSMYS\",\"tabindex\":62,\"type\":\"Button\",\"value\":\"Annulla Rettifica\",\"w\":208,\"x\":560,\"y\":343,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#FF0000\",\"h\":22,\"name\":\"label_VQNRBICOXA\",\"page\":1,\"spuid\":\"VQNRBICOXA\",\"tabindex\":61,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"OPERAZIONE CANCELLATA\",\"w\":544,\"x\":120,\"y\":371,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_TNLEGEGWAQ\",\"box_type\":\"titled_box\",\"comment\":\"Dati Comunicazione Rettifica\",\"h\":91,\"name\":\"box_TNLEGEGWAQ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"TNLEGEGWAQ\",\"tabindex\":51,\"title_caption\":\"Dati Comunicazione Rettifica\",\"titled\":true,\"type\":\"Box\",\"w\":368,\"x\":16,\"y\":246,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rettifica\",\"h\":20,\"maxlength\":10,\"name\":\"ADATARET\",\"page\":1,\"spuid\":\"GVMNAQQJWY\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":104,\"y\":253,\"zone\":\"pag1_1_11_1\",\"zonepath\":\"[1,1,11,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZQIDHWPUXR\",\"page\":1,\"spuid\":\"ZQIDHWPUXR\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Data Rettifica:\",\"w\":80,\"x\":22,\"y\":257,\"zone\":\"pag1_1_11_1\",\"zonepath\":\"[1,1,11,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"h\":21,\"label_text\":\"Trasmesso con il file\",\"maxlength\":4,\"name\":\"RSPEDITO\",\"page\":1,\"spuid\":\"JDNKWMLZTI\",\"tabindex\":46,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":120,\"x\":24,\"y\":280,\"zone\":\"pag1_1_11_2\",\"zonepath\":\"[1,1,11,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Vecchio file spedizione chiusura\",\"h\":20,\"maxlength\":15,\"name\":\"COLDFILE\",\"page\":1,\"spuid\":\"JWUIHKTDYH\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":104,\"x\":144,\"y\":281,\"zone\":\"pag1_1_11_2\",\"zonepath\":\"[1,1,11,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Vecchio Progressivo\",\"h\":20,\"maxlength\":25,\"name\":\"COLDPROG\",\"page\":1,\"spuid\":\"JCJVALRBTS\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":144,\"y\":309,\"zone\":\"pag1_1_11_3\",\"zonepath\":\"[1,1,11,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QUKJZLRVOL\",\"page\":1,\"spuid\":\"QUKJZLRVOL\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Progressivo\",\"w\":56,\"x\":80,\"y\":313,\"zone\":\"pag1_1_11_3\",\"zonepath\":\"[1,1,11,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_ae_aedelrigBO BO,ServletStatus status) {
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
     "<script src='armt_ae_aedelrig?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_aedelrig_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_aedelrig_edit.js'>" +
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
      status.out.println("w_RAPPORTO=a[0];");
      status.out.println("w_COINT=a[1];");
      status.out.println("w_TIPOAG=a[2];");
      status.out.println("w_IDBASE=a[3];");
      status.out.println("op_IDBASE=a[4];");
      status.out.println("w_CONNESINT=a[5];");
      status.out.println("w_ADATA=a[6];");
      status.out.println("w_ASPEDITO=a[7];");
      status.out.println("w_AFILE=a[8];");
      status.out.println("w_APROG=a[9];");
      status.out.println("w_AOLDPROG=a[10];");
      status.out.println("w_AOLDFILE=a[11];");
      status.out.println("w_CSPEDITO=a[12];");
      status.out.println("w_CPROG=a[13];");
      status.out.println("w_COLDPROG=a[14];");
      status.out.println("w_CFILE=a[15];");
      status.out.println("w_COLDFILE=a[16];");
      status.out.println("w_IDRIF=a[17];");
      status.out.println("w_NOCODFISC=a[18];");
      status.out.println("w_ADTPRE=a[19];");
      status.out.println("w_CDTPRE=a[20];");
      status.out.println("w_CDATA=a[21];");
      status.out.println("w_IDESITO=a[22];");
      status.out.println("w_PROGDLG=a[23];");
      status.out.println("op_PROGDLG=a[24];");
      status.out.println("w_ADATARET=a[25];");
      status.out.println("w_RSPEDITO=a[26];");
      status.out.println("w_DATESITO=a[27];");
      status.out.println("w_xcfestero=a[28];");
      status.out.println("w_xragsoc=a[29];");
      status.out.println("w_desctrap=a[30];");
      status.out.println("w_dtcanc=a[31];");
      status.out.println("w_spcanc=a[32];");
      status.out.println("w_filecanc=a[33];");
      status.out.println("w_idcanc=a[34];");
      status.out.println("op_codazi=a[35];");
      status.out.println("if (Gt(a.length,36)) {");
      status.out.println("o_IDBASE=w_IDBASE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['IDBASE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_aedelrig_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(404,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","aederig");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","IDBASE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_ae_aedelrigBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_ae_aedelrigBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_ae_aedelrigBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_ae_aedelrigBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_ae_aedelrigBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_ae_aedelrigBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_ae_aedelrigBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+arrt_delret_aederig.m_cEntityUid+"/arrt_delret_aederig.js'>" +
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
      arrt_delret_aederig.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_ae_aedelrigBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDBASE),"C",10,0));
      }
    } else if (CPLib.eq(p_cUID,"DZWSXMBIHR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VQOCGQDTYC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_ae_aedelrigBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_CONNESINT))) {
        a = GetCheckVars(status,BO,"DZWSXMBIHR");
        b = status.m_CheckVars.optString("DZWSXMBIHR");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
