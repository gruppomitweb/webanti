import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class opemt_scarti_import extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3aabb947*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "scarti_import";
    }
    public double w_IMPPROG;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IMPPROG,context,"scarti_import","IMPPROG","N",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='IMPPROG' type='hidden' value="+SPLib.ToHTMLValue(w_IMPPROG,"N",10,0)+">" +
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
    opemt_scarti_importBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_scarti_import;
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
      status.w_IMPPROG = BO.w_IMPPROG;
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
    return "Scarti Import Prestazioni";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "opemt_scarti_import";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1045;
    l_eg.m_nEntityHeight = 656;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"scarti_import","personbo","tipilegbo_m"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IMPPROG"};
    l_eg.items = new SPItem[]{
                   new SPItem("IMPPROG","N",10,0, "edit","ID SCarto"),
                   new SPItem("CODSTUDIO","C",11,0, "edit","Codice Intermediario"),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("NUMPROG","C",11,0, "edit","ID Operazione"),
                   new SPItem("DATAOPE","C",8,0, "edit","Data Operazione"),
                   new SPItem("FLAGFRAZ","C",1,0, "edit","Frazionata / Multiple / Coneessa"),
                   new SPItem("CAUOPER","C",4,0, "edit","Causale Operazione"),
                   new SPItem("CONNESREAL","C",11,0, "edit","Cliente"),
                   new SPItem("CONNESCLI","C",11,0, "edit","Escutore"),
                   new SPItem("CONNESBEN","C",11,0, "edit","Soggetto Servito"),
                   new SPItem("CONNALTRO","C",11,0, "edit","Controparte"),
                   new SPItem("DATAREG","C",8,0, "edit","Data Registrazione"),
                   new SPItem("STATOREG","C",1,0, "edit","Stato Registrazione"),
                   new SPItem("DATARETT","C",8,0, "edit","Data Rettifica"),
                   new SPItem("VALUTA","C",3,0, "edit","Valuta"),
                   new SPItem("IMPORTO","N",15,2, "edit","Importo"),
                   new SPItem("CONTANTI","N",15,2, "edit","Contanti"),
                   new SPItem("MEZPAG","C",30,0, "edit","Mezzo Pagamento / Origine"),
                   new SPItem("PRESTAZ","C",30,0, "edit","Prestazione"),
                   new SPItem("RAGIO","C",5,0, "edit","Ragionevolezza"),
                   new SPItem("MODSVOL","C",5,0, "edit","Modalità Svolgimento"),
                   new SPItem("AREAGEO","C",3,0, "edit","Area Geografica"),
                   new SPItem("TIPO","C",3,0, "edit","Tipo Rischio"),
                   new SPItem("AMMONT","C",2,0, "edit","Ammonater (Rischio)"),
                   new SPItem("DURAT","C",2,0, "edit","Durata (Rischio)"),
                   new SPItem("RAREA","N",3,0, "edit","Rischio Area"),
                   new SPItem("RRAGIO","N",3,0, "edit","Rischio Ragionevolezza"),
                   new SPItem("RCOMP","N",3,0, "edit","Rischio Comportamento"),
                   new SPItem("RTIPO","N",3,0, "edit","Rischio Tipologia"),
                   new SPItem("RFREQ","N",3,0, "edit","Rischio Frequenza"),
                   new SPItem("RIMP","N",3,0, "edit","Rischio Importo"),
                   new SPItem("xdestipope","C",254,0, "hide","Descrizione"),
                   new SPItem("TIPOOPER","C",2,0, "edit","Tipo Operatore"),
                   new SPItem("RAGSOCexec","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("RAGSOCreal","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("RAGSOCben","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("RAGSOCaltro","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("TXTERR","M",10,0, "edit","Errori Rilevati"),
                   new SPItem("DESPUNTO","C",80,0, "edit","Descrizione Punto"),
                   new SPItem("IMPPROG13","C",13,0, "edit","Progressivo Import con Anno")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,opemt_scarti_importBO BO) {
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
    l_translations=new String[][]{{"10323481349",p_Context.Translate("Rischio Importo")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10692492141",p_Context.Translate("Soggetto Servito")},
    {"10756545135",p_Context.Translate("Ragionevolezza")},
    {"10852410784",p_Context.Translate("Causale Operazione")},
    {"10874458778",p_Context.Translate("Tipo Operatore")},
    {"10915686795",p_Context.Translate("Escutore")},
    {"10961866158",p_Context.Translate("Descrizione Punto")},
    {"109822566",p_Context.Translate("Valuta")},
    {"11053408024",p_Context.Translate("Area Geografica")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11202170632",p_Context.Translate("ID SCarto")},
    {"11213057650",p_Context.Translate("Errori Rilevati")},
    {"11255940388",p_Context.Translate("Ammonater (Rischio)")},
    {"11258238247",p_Context.Translate("Stato Registrazione")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11329559720",p_Context.Translate("Data Rettifica")},
    {"11400294538",p_Context.Translate("Durata (Rischio)")},
    {"11639004473",p_Context.Translate("Tipo Rischio")},
    {"11966397783",p_Context.Translate("Rischio Frequenza")},
    {"11993250157",p_Context.Translate("ID Operazione")},
    {"12023087643",p_Context.Translate("Controparte")},
    {"1211771705",p_Context.Translate("Progressivo Import con Anno")},
    {"1223078771",p_Context.Translate("Rischio Ragionevolezza")},
    {"1823784963",p_Context.Translate("Cliente")},
    {"189314355",p_Context.Translate("Contanti")},
    {"1952583975",p_Context.Translate("Rischio Tipologia")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"1980048963",p_Context.Translate("Rischio Area")},
    {"1991862041",p_Context.Translate("Importo")},
    {"2069633825",p_Context.Translate("Frazionata / Multiple / Coneessa")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"2140645870",p_Context.Translate("Scarti Import Prestazioni")},
    {"277612735",p_Context.Translate("Prestazione")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"34329298",p_Context.Translate("Rischio Comportamento")},
    {"688674216",p_Context.Translate("Mezzo Pagamento / Origine")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"995044523",p_Context.Translate("Data Registrazione")}};
    return l_translations;
  }
  void WriteStyles(opemt_scarti_importBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../opemt_scarti_import.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(opemt_scarti_importBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('opemt_scarti_import',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"opemt_scarti_import",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(opemt_scarti_importBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(opemt_scarti_importBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:656px;width:1045px;display:none'>" +
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
  void WriteControls_p1_b0(opemt_scarti_importBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:656px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='IMPPROG' id='QXNYFHJEGV' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IMPPROG,"N",10,0,"9999999999", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='13' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='KRXSXYVUWN_DIV'>" +
     "<label id='KRXSXYVUWN' for='QXNYFHJEGV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID SCarto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HXRWXTIZXM_DIV'>" +
     "<label id='HXRWXTIZXM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operatore:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CODSTUDIO' id='UKBKMVGOYH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODSTUDIO,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TCSZHRJVBZ_DIV'>" +
     "<label id='TCSZHRJVBZ' for='UKBKMVGOYH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CODDIPE' id='EJPBJRCBZC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LZFEUSOVCQ_DIV'>" +
     "<label id='LZFEUSOVCQ' for='EJPBJRCBZC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='NUMPROG' id='WZJKEUSING' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMPROG,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XYBIALQMJL_DIV'>" +
     "<label id='XYBIALQMJL' for='WZJKEUSING'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATAOPE' id='KWDTDYVYAB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TKJZEQJCUY_DIV'>" +
     "<label id='TKJZEQJCUY' for='KWDTDYVYAB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='FLAGFRAZ' id='IBXSOHICPZ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
     ""+status.context.Translate("Normale")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
     ""+status.context.Translate("Frazionata")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
     ""+status.context.Translate("Multipla")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
     ""+status.context.Translate("Connessa")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('IBXSOHICPZ'),w_FLAGFRAZ,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WTPMYRLUAB_DIV'>" +
     "<label id='WTPMYRLUAB' for='IBXSOHICPZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CAUOPER' id='SKOBLXEJHQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAUOPER,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNESREAL' id='TRIYBQSKCQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESREAL,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='TRIYBQSKCQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "TRIYBQSKCQ", "personbo", "opemt_personbo", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LHIKNOBNIF_DIV'>" +
     "<label id='LHIKNOBNIF' for='SKOBLXEJHQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Causale Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNESCLI' id='DHRGEXYQZL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESCLI,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='DHRGEXYQZL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "DHRGEXYQZL", "personbo", "", "scarti")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HOGSTPBEIQ_DIV'>" +
     "<label id='HOGSTPBEIQ' for='DHRGEXYQZL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Esecutore:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KSTYBRETHR_DIV'>" +
     "<label id='KSTYBRETHR' for='TRIYBQSKCQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mittente/Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNESBEN' id='SQWOYVEXHD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESBEN,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='SQWOYVEXHD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "SQWOYVEXHD", "personbo", "opemt_personbo", "scarti")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNALTRO' id='SFOARTDXXG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNALTRO,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='SFOARTDXXG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "SFOARTDXXG", "personbo", "opemt_personbo", "scarti")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VTURHTDLDX_DIV'>" +
     "<label id='VTURHTDLDX' for='SQWOYVEXHD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Destinatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATAREG' id='DEETZAJZGP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAREG,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MTNZGOOFPL_DIV'>" +
     "<label id='MTNZGOOFPL' for='DEETZAJZGP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='STATOREG' id='VQGDODMLDL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_STATOREG,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QUMSNDCJBJ_DIV'>" +
     "<label id='QUMSNDCJBJ' for='VQGDODMLDL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATARETT' id='DXGRIVXEWI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARETT,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RPKJMPCTXQ_DIV'>" +
     "<label id='RPKJMPCTXQ' for='DXGRIVXEWI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rettifica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='VALUTA' id='AQBMLZYCWZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VALUTA,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZOTPJWCVTR_DIV'>" +
     "<label id='ZOTPJWCVTR' for='AQBMLZYCWZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valuta:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='IMPORTO' id='JXJXTMAQOR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPORTO,"N",15,2,"999999999999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NLQGCEUHFD_DIV'>" +
     "<label id='NLQGCEUHFD' for='JXJXTMAQOR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONTANTI' id='ZQKFPJRGCM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONTANTI,"N",15,2,"999999999999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EKUGPTGFJV_DIV'>" +
     "<label id='EKUGPTGFJV' for='ZQKFPJRGCM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Contanti:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='MEZPAG' id='AVIHKNTROH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MEZPAG,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IQRQCEPBBY_DIV'>" +
     "<label id='IQRQCEPBBY' for='AVIHKNTROH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo Pagamento / Origine:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='PRESTAZ' id='YZXCIDVOSB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PRESTAZ,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KLCZSTVZEQ_DIV'>" +
     "<label id='KLCZSTVZEQ' for='YZXCIDVOSB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prestazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RAGIO' id='DLWFDSLQHV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAGIO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BJFTULJQFC_DIV'>" +
     "<label id='BJFTULJQFC' for='DLWFDSLQHV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragionevolezza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='MODSVOL' id='PJPSCKBXWX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MODSVOL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SKCNNCRIHA_DIV'>" +
     "<label id='SKCNNCRIHA' for='PJPSCKBXWX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modalità Svolgimento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AREAGEO' id='BDJNXHSZPD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AREAGEO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VDSKTVRXCC_DIV'>" +
     "<label id='VDSKTVRXCC' for='BDJNXHSZPD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Area Geografica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TIPO' id='VQAMGIPHEI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DCVAVFQHMB_DIV'>" +
     "<label id='DCVAVFQHMB' for='VQAMGIPHEI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rischio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AMMONT' id='UJWCIKSUAD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AMMONT,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PAGZTRDOSQ_DIV'>" +
     "<label id='PAGZTRDOSQ' for='UJWCIKSUAD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ammontare (Rischio):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DURAT' id='XBMIQPAWVL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DURAT,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SVPXMUXZZL_DIV'>" +
     "<label id='SVPXMUXZZL' for='XBMIQPAWVL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Durata (Rischio):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RAREA' id='WELAXIKLEX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='3' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PGHFNETEYB_DIV'>" +
     "<label id='PGHFNETEYB' for='WELAXIKLEX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Area:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RRAGIO' id='ZIQAINPMOT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RRAGIO,"N",3,0,"999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='3' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AYESPEBHIK_DIV'>" +
     "<label id='AYESPEBHIK' for='ZIQAINPMOT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Ragionevolezza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RCOMP' id='ORMMYKQBOD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='3' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HHCMCOYBZM_DIV'>" +
     "<label id='HHCMCOYBZM' for='ORMMYKQBOD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Comportamento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RTIPO' id='CGNQJBONMH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RTIPO,"N",3,0,"999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='3' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FABUNHRYDG_DIV'>" +
     "<label id='FABUNHRYDG' for='CGNQJBONMH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Tipologia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RFREQ' id='MDWPLKDGMG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RFREQ,"N",3,0,"999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='3' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RTXIKLCNMY_DIV'>" +
     "<label id='RTXIKLCNMY' for='MDWPLKDGMG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Frequenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RIMP' id='UAFEGMLADT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RIMP,"N",3,0,"999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='3' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XIEBYYBREL_DIV'>" +
     "<label id='XIEBYYBREL' for='UAFEGMLADT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Importo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DCPQAUCUKK_DIV'>" +
     "<label id='DCPQAUCUKK' for='SFOARTDXXG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto Servito:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DRHGUGRFFE_DIV'>" +
     "<label id='DRHGUGRFFE'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdestipope)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TIPOOPER' id='KYUSCDSEVM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPOOPER,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='KYUSCDSEVM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "KYUSCDSEVM", "tipilegbo_m", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RBPZQRBRXS_DIV'>" +
     "<label id='RBPZQRBRXS'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOCexec)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ECXPYMDFHI_DIV'>" +
     "<label id='ECXPYMDFHI'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOCreal)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QLABLSZJHX_DIV'>" +
     "<label id='QLABLSZJHX'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOCben)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KXTRWBOXQV_DIV'>" +
     "<label id='KXTRWBOXQV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOCaltro)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<textarea name='TXTERR' id='ENRXTREYWX' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
     "</textarea>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NQYFIJGBPH_DIV'>" +
     "<label id='NQYFIJGBPH' for='ENRXTREYWX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errori Rilevati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DESPUNTO' id='WNUERUZGDR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESPUNTO,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DHVUNVLWKV_DIV'>" +
     "<label id='DHVUNVLWKV' for='WNUERUZGDR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione Punto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='IMPPROG13' id='EUHPECGOVY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPPROG13,"C",13,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='13' size='13' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AKLYOYOEUI_DIV'>" +
     "<label id='AKLYOYOEUI' for='EUHPECGOVY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo Import con Anno:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(opemt_scarti_importBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(opemt_scarti_importBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(opemt_scarti_importBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODSTUDIO,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAUOPER,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESREAL,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESCLI,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESBEN,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNALTRO,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARETT,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPORTO,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONTANTI,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_MEZPAG,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRESTAZ,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGIO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MODSVOL,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AREAGEO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AMMONT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DURAT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RRAGIO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RTIPO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RFREQ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOOPER,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TXTERR,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESPUNTO,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPPROG13,"C",13,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipope,"C",254,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOCexec,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOCreal,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOCben,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOCaltro,"C",70,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(opemt_scarti_importBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_DRHGUGRFFE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RBPZQRBRXS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ECXPYMDFHI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QLABLSZJHX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KXTRWBOXQV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(656,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1045,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"opemt_scarti_import"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'TRIYBQSKCQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TRIYBQSKCQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'DHRGEXYQZL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DHRGEXYQZL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"scarti",l_session)+"'"+"]");
      status.out.print(",'SQWOYVEXHD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SQWOYVEXHD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"scarti",l_session)+"'"+"]");
      status.out.print(",'SFOARTDXXG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SFOARTDXXG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"scarti",l_session)+"'"+"]");
      status.out.print(",'KYUSCDSEVM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KYUSCDSEVM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tipilegbo_m,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'TRIYBQSKCQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'DHRGEXYQZL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"scarti",l_session)+"'"+"]");
      status.out.print(",'SQWOYVEXHD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"scarti",l_session)+"'"+"]");
      status.out.print(",'SFOARTDXXG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"scarti",l_session)+"'"+"]");
      status.out.print(",'KYUSCDSEVM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tipilegbo_m,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("opemt_scarti_import","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"opemt_scarti_import",BO.GetCurrentState());
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
  void WriteMainFormScript(opemt_scarti_importBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('opemt_scarti_import',false);");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('QXNYFHJEGV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UKBKMVGOYH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EJPBJRCBZC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WZJKEUSING')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KWDTDYVYAB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IBXSOHICPZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SKOBLXEJHQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRIYBQSKCQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRIYBQSKCQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DHRGEXYQZL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DHRGEXYQZL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SQWOYVEXHD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SQWOYVEXHD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFOARTDXXG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFOARTDXXG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DEETZAJZGP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VQGDODMLDL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DXGRIVXEWI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AQBMLZYCWZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JXJXTMAQOR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZQKFPJRGCM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AVIHKNTROH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZXCIDVOSB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DLWFDSLQHV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PJPSCKBXWX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BDJNXHSZPD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VQAMGIPHEI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UJWCIKSUAD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XBMIQPAWVL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WELAXIKLEX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZIQAINPMOT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ORMMYKQBOD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CGNQJBONMH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDWPLKDGMG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UAFEGMLADT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KYUSCDSEVM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KYUSCDSEVM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ENRXTREYWX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WNUERUZGDR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EUHPECGOVY')) SetDisabled(c,true);");
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
        status.out.println("if(c=Ctrl('QXNYFHJEGV')) SetDisabled(c,true);");
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
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  opemt_scarti_importBO getBO(ServletStatus status) {
    opemt_scarti_importBO BO = new opemt_scarti_importBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(opemt_scarti_importBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("scarti_import",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,opemt_scarti_importBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,opemt_scarti_importBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(opemt_scarti_importBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_scarti_import;
    String l_cPhName = BO.m_cPhName_scarti_import;
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
      String l_cQueryFilter = opemt_scarti_importBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_scarti_import+".IMPPROG",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("scarti_import");
    String l_cPhName = CPSql.ManipulateTablePhName("scarti_import",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".IMPPROG",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,opemt_scarti_importBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = opemt_scarti_importBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_scarti_import,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_scarti_import,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,opemt_scarti_importBO BO) {
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
  void Edit(ServletStatus status,opemt_scarti_importBO BO,SPParameterSource source) {
    BO.Load(status.w_IMPPROG);
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
  void New(ServletStatus status,opemt_scarti_importBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,opemt_scarti_importBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,opemt_scarti_importBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_IMPPROG = 0;
      } else {
        BO.w_IMPPROG = l_rsKeys.GetDouble("IMPPROG");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_IMPPROG = BO.w_IMPPROG;
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
  void EditLoad(ServletStatus status,opemt_scarti_importBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,opemt_scarti_importBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_IMPPROG);
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
  void DeleteMessage(ServletStatus status,opemt_scarti_importBO BO,SPParameterSource source) {
    BO.Load(status.w_IMPPROG);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,opemt_scarti_importBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IMPPROG:"+SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,opemt_scarti_importBO BO) {
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
  void CreatePortlet(ServletStatus status,opemt_scarti_importBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",656);
    item.put("w",1045);
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
    item.put("altInterfaceFor","opemt_scarti_import");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"ID SCarto\",\"h\":20,\"maxlength\":13,\"name\":\"IMPPROG\",\"page\":1,\"spuid\":\"QXNYFHJEGV\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":88,\"x\":152,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRXSXYVUWN\",\"page\":1,\"spuid\":\"KRXSXYVUWN\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"ID SCarto:\",\"w\":143,\"x\":8,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HXRWXTIZXM\",\"page\":1,\"spuid\":\"HXRWXTIZXM\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Tipo Operatore:\",\"w\":100,\"x\":243,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DRHGUGRFFE\",\"page\":1,\"spuid\":\"DRHGUGRFFE\",\"tabindex\":65,\"type\":\"Label\",\"w\":640,\"x\":400,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Operatore\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPER\",\"page\":1,\"picker\":true,\"spuid\":\"KYUSCDSEVM\",\"tabindex\":66,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":344,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Intermediario\",\"h\":20,\"maxlength\":11,\"name\":\"CODSTUDIO\",\"page\":1,\"spuid\":\"UKBKMVGOYH\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":152,\"y\":35,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TCSZHRJVBZ\",\"page\":1,\"spuid\":\"TCSZHRJVBZ\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Codice Intermediario:\",\"w\":143,\"x\":8,\"y\":39,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Dipendenza\",\"h\":20,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"spuid\":\"EJPBJRCBZC\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":720,\"y\":35,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LZFEUSOVCQ\",\"page\":1,\"spuid\":\"LZFEUSOVCQ\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Codice Dipendenza:\",\"w\":143,\"x\":576,\"y\":39,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID Operazione\",\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG\",\"page\":1,\"spuid\":\"WZJKEUSING\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":152,\"y\":63,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XYBIALQMJL\",\"page\":1,\"spuid\":\"XYBIALQMJL\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"ID Operazione:\",\"w\":143,\"x\":8,\"y\":67,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":8,\"name\":\"DATAOPE\",\"page\":1,\"spuid\":\"KWDTDYVYAB\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":344,\"y\":63,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TKJZEQJCUY\",\"page\":1,\"spuid\":\"TKJZEQJCUY\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Data Operazione:\",\"w\":111,\"x\":232,\"y\":67,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Frazionata \\/ Multiple \\/ Coneessa\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGFRAZ\",\"page\":1,\"spuid\":\"IBXSOHICPZ\",\"tabindex\":12,\"textlist\":\"Normale,Frazionata,Multipla,Connessa\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":168,\"x\":720,\"y\":63,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WTPMYRLUAB\",\"page\":1,\"spuid\":\"WTPMYRLUAB\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Tipo:\",\"w\":63,\"x\":656,\"y\":67,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Registrazione\",\"h\":20,\"maxlength\":8,\"name\":\"DATAREG\",\"page\":1,\"spuid\":\"DEETZAJZGP\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":568,\"y\":63,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MTNZGOOFPL\",\"page\":1,\"spuid\":\"MTNZGOOFPL\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Data Registrazione:\",\"w\":127,\"x\":440,\"y\":67,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Causale Operazione\",\"h\":20,\"maxlength\":4,\"name\":\"CAUOPER\",\"page\":1,\"spuid\":\"SKOBLXEJHQ\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":152,\"y\":91,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHIKNOBNIF\",\"page\":1,\"spuid\":\"LHIKNOBNIF\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Causale Operazione:\",\"w\":143,\"x\":8,\"y\":95,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Cliente\",\"h\":20,\"maxlength\":11,\"name\":\"CONNESREAL\",\"page\":1,\"picker\":true,\"spuid\":\"TRIYBQSKCQ\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":152,\"y\":119,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Escutore\",\"h\":20,\"maxlength\":11,\"name\":\"CONNESCLI\",\"page\":1,\"picker\":true,\"spuid\":\"DHRGEXYQZL\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":152,\"y\":147,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HOGSTPBEIQ\",\"page\":1,\"spuid\":\"HOGSTPBEIQ\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Esecutore:\",\"w\":143,\"x\":8,\"y\":123,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KSTYBRETHR\",\"page\":1,\"spuid\":\"KSTYBRETHR\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Mittente\\/Cliente:\",\"w\":143,\"x\":8,\"y\":151,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_RBPZQRBRXS\",\"page\":1,\"spuid\":\"RBPZQRBRXS\",\"tabindex\":68,\"type\":\"Label\",\"w\":640,\"x\":304,\"y\":147,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_ECXPYMDFHI\",\"page\":1,\"spuid\":\"ECXPYMDFHI\",\"tabindex\":69,\"type\":\"Label\",\"w\":640,\"x\":304,\"y\":119,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Soggetto Servito\",\"h\":20,\"maxlength\":11,\"name\":\"CONNESBEN\",\"page\":1,\"picker\":true,\"spuid\":\"SQWOYVEXHD\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":152,\"y\":175,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VTURHTDLDX\",\"page\":1,\"spuid\":\"VTURHTDLDX\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Destinatario:\",\"w\":143,\"x\":8,\"y\":179,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_QLABLSZJHX\",\"page\":1,\"spuid\":\"QLABLSZJHX\",\"tabindex\":70,\"type\":\"Label\",\"w\":640,\"x\":304,\"y\":175,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Controparte\",\"h\":20,\"maxlength\":11,\"name\":\"CONNALTRO\",\"page\":1,\"picker\":true,\"spuid\":\"SFOARTDXXG\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":152,\"y\":203,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DCPQAUCUKK\",\"page\":1,\"spuid\":\"DCPQAUCUKK\",\"tabindex\":63,\"type\":\"Label\",\"value\":\"Soggetto Servito:\",\"w\":143,\"x\":8,\"y\":207,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_KXTRWBOXQV\",\"page\":1,\"spuid\":\"KXTRWBOXQV\",\"tabindex\":71,\"type\":\"Label\",\"w\":640,\"x\":304,\"y\":203,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato Registrazione\",\"h\":20,\"maxlength\":1,\"name\":\"STATOREG\",\"page\":1,\"spuid\":\"VQGDODMLDL\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":152,\"y\":231,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QUMSNDCJBJ\",\"page\":1,\"spuid\":\"QUMSNDCJBJ\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Stato Registrazione:\",\"w\":143,\"x\":8,\"y\":235,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rettifica\",\"h\":20,\"maxlength\":8,\"name\":\"DATARETT\",\"page\":1,\"spuid\":\"DXGRIVXEWI\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":568,\"y\":231,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RPKJMPCTXQ\",\"page\":1,\"spuid\":\"RPKJMPCTXQ\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Data Rettifica:\",\"w\":119,\"x\":448,\"y\":235,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Valuta\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":1,\"spuid\":\"AQBMLZYCWZ\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":152,\"y\":259,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZOTPJWCVTR\",\"page\":1,\"spuid\":\"ZOTPJWCVTR\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Valuta:\",\"w\":143,\"x\":8,\"y\":263,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo\",\"h\":20,\"maxlength\":18,\"name\":\"IMPORTO\",\"page\":1,\"spuid\":\"JXJXTMAQOR\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":152,\"y\":287,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NLQGCEUHFD\",\"page\":1,\"spuid\":\"NLQGCEUHFD\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":143,\"x\":8,\"y\":291,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti\",\"h\":20,\"maxlength\":18,\"name\":\"CONTANTI\",\"page\":1,\"spuid\":\"ZQKFPJRGCM\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":568,\"y\":280,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EKUGPTGFJV\",\"page\":1,\"spuid\":\"EKUGPTGFJV\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Contanti:\",\"w\":151,\"x\":416,\"y\":284,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mezzo Pagamento \\/ Origine\",\"h\":20,\"maxlength\":30,\"name\":\"MEZPAG\",\"page\":1,\"spuid\":\"AVIHKNTROH\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":152,\"y\":315,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IQRQCEPBBY\",\"page\":1,\"spuid\":\"IQRQCEPBBY\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Mezzo Pagamento \\/ Origine:\",\"w\":143,\"x\":8,\"y\":319,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prestazione\",\"h\":20,\"maxlength\":30,\"name\":\"PRESTAZ\",\"page\":1,\"spuid\":\"YZXCIDVOSB\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":568,\"y\":315,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KLCZSTVZEQ\",\"page\":1,\"spuid\":\"KLCZSTVZEQ\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Prestazione:\",\"w\":151,\"x\":416,\"y\":319,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ragionevolezza\",\"h\":20,\"maxlength\":5,\"name\":\"RAGIO\",\"page\":1,\"spuid\":\"DLWFDSLQHV\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":152,\"y\":343,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BJFTULJQFC\",\"page\":1,\"spuid\":\"BJFTULJQFC\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Ragionevolezza:\",\"w\":143,\"x\":8,\"y\":347,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Modalit\\u00E0 Svolgimento\",\"h\":20,\"maxlength\":5,\"name\":\"MODSVOL\",\"page\":1,\"spuid\":\"PJPSCKBXWX\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":152,\"y\":371,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SKCNNCRIHA\",\"page\":1,\"spuid\":\"SKCNNCRIHA\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Modalit\\u00E0 Svolgimento:\",\"w\":143,\"x\":8,\"y\":375,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Area Geografica\",\"h\":20,\"maxlength\":3,\"name\":\"AREAGEO\",\"page\":1,\"spuid\":\"BDJNXHSZPD\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":152,\"y\":399,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VDSKTVRXCC\",\"page\":1,\"spuid\":\"VDSKTVRXCC\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":143,\"x\":8,\"y\":403,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Rischio\",\"h\":20,\"maxlength\":3,\"name\":\"TIPO\",\"page\":1,\"spuid\":\"VQAMGIPHEI\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":152,\"y\":427,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DCVAVFQHMB\",\"page\":1,\"spuid\":\"DCVAVFQHMB\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Tipo Rischio:\",\"w\":143,\"x\":8,\"y\":431,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ammonater (Rischio)\",\"h\":20,\"maxlength\":2,\"name\":\"AMMONT\",\"page\":1,\"spuid\":\"UJWCIKSUAD\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":152,\"y\":455,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PAGZTRDOSQ\",\"page\":1,\"spuid\":\"PAGZTRDOSQ\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Ammontare (Rischio):\",\"w\":143,\"x\":8,\"y\":459,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Durata (Rischio)\",\"h\":20,\"maxlength\":2,\"name\":\"DURAT\",\"page\":1,\"spuid\":\"XBMIQPAWVL\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":152,\"y\":483,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SVPXMUXZZL\",\"page\":1,\"spuid\":\"SVPXMUXZZL\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Durata (Rischio):\",\"w\":143,\"x\":8,\"y\":487,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Area\",\"h\":20,\"maxlength\":6,\"name\":\"RAREA\",\"page\":1,\"spuid\":\"WELAXIKLEX\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":568,\"y\":399,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PGHFNETEYB\",\"page\":1,\"spuid\":\"PGHFNETEYB\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Rischio Area:\",\"w\":151,\"x\":416,\"y\":403,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Ragionevolezza\",\"h\":20,\"maxlength\":6,\"name\":\"RRAGIO\",\"page\":1,\"spuid\":\"ZIQAINPMOT\",\"tabindex\":53,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":568,\"y\":371,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AYESPEBHIK\",\"page\":1,\"spuid\":\"AYESPEBHIK\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"Rischio Ragionevolezza:\",\"w\":151,\"x\":416,\"y\":375,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Comportamento\",\"h\":20,\"maxlength\":6,\"name\":\"RCOMP\",\"page\":1,\"spuid\":\"ORMMYKQBOD\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":568,\"y\":343,\"zone\":\"pag1_23\",\"zonepath\":\"[1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HHCMCOYBZM\",\"page\":1,\"spuid\":\"HHCMCOYBZM\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Rischio Comportamento:\",\"w\":151,\"x\":416,\"y\":347,\"zone\":\"pag1_23\",\"zonepath\":\"[1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Tipologia\",\"h\":20,\"maxlength\":6,\"name\":\"RTIPO\",\"page\":1,\"spuid\":\"CGNQJBONMH\",\"tabindex\":57,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":568,\"y\":427,\"zone\":\"pag1_24\",\"zonepath\":\"[1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FABUNHRYDG\",\"page\":1,\"spuid\":\"FABUNHRYDG\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"Rischio Tipologia:\",\"w\":151,\"x\":416,\"y\":431,\"zone\":\"pag1_24\",\"zonepath\":\"[1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Frequenza\",\"h\":20,\"maxlength\":6,\"name\":\"RFREQ\",\"page\":1,\"spuid\":\"MDWPLKDGMG\",\"tabindex\":59,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":568,\"y\":483,\"zone\":\"pag1_25\",\"zonepath\":\"[1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RTXIKLCNMY\",\"page\":1,\"spuid\":\"RTXIKLCNMY\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"Rischio Frequenza:\",\"w\":151,\"x\":416,\"y\":487,\"zone\":\"pag1_25\",\"zonepath\":\"[1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Importo\",\"h\":20,\"maxlength\":6,\"name\":\"RIMP\",\"page\":1,\"spuid\":\"UAFEGMLADT\",\"tabindex\":61,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":568,\"y\":455,\"zone\":\"pag1_26\",\"zonepath\":\"[1,26]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XIEBYYBREL\",\"page\":1,\"spuid\":\"XIEBYYBREL\",\"tabindex\":62,\"type\":\"Label\",\"value\":\"Rischio Importo:\",\"w\":151,\"x\":416,\"y\":459,\"zone\":\"pag1_26\",\"zonepath\":\"[1,26]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errori Rilevati\",\"h\":105,\"name\":\"TXTERR\",\"page\":1,\"scroll\":true,\"spuid\":\"ENRXTREYWX\",\"tabindex\":75,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":752,\"x\":144,\"y\":546,\"zone\":\"pag1_27\",\"zonepath\":\"[1,27]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NQYFIJGBPH\",\"page\":1,\"spuid\":\"NQYFIJGBPH\",\"tabindex\":76,\"type\":\"Label\",\"value\":\"Errori Rilevati:\",\"w\":143,\"x\":0,\"y\":546,\"zone\":\"pag1_27\",\"zonepath\":\"[1,27]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione Punto\",\"h\":20,\"maxlength\":80,\"name\":\"DESPUNTO\",\"page\":1,\"spuid\":\"WNUERUZGDR\",\"tabindex\":77,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":152,\"y\":511,\"zone\":\"pag1_28\",\"zonepath\":\"[1,28]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DHVUNVLWKV\",\"page\":1,\"spuid\":\"DHVUNVLWKV\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"Descrizione Punto:\",\"w\":97,\"x\":55,\"y\":515,\"zone\":\"pag1_28\",\"zonepath\":\"[1,28]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Progressivo Import con Anno\",\"h\":20,\"maxlength\":13,\"name\":\"IMPPROG13\",\"page\":1,\"spuid\":\"EUHPECGOVY\",\"tabindex\":79,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":90,\"x\":808,\"y\":511,\"zone\":\"pag1_28\",\"zonepath\":\"[1,28]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AKLYOYOEUI\",\"page\":1,\"spuid\":\"AKLYOYOEUI\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"Progressivo Import con Anno:\",\"w\":157,\"x\":651,\"y\":515,\"zone\":\"pag1_28\",\"zonepath\":\"[1,28]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(opemt_scarti_importBO BO,ServletStatus status) {
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
     "<script src='opemt_scarti_import?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/opemt_scarti_import_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/opemt_scarti_import_edit.js'>" +
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
      status.out.println("w_IMPPROG=a[0];");
      status.out.println("w_CODSTUDIO=a[1];");
      status.out.println("w_CODDIPE=a[2];");
      status.out.println("w_NUMPROG=a[3];");
      status.out.println("w_DATAOPE=a[4];");
      status.out.println("w_FLAGFRAZ=a[5];");
      status.out.println("w_CAUOPER=a[6];");
      status.out.println("w_CONNESREAL=a[7];");
      status.out.println("w_CONNESCLI=a[8];");
      status.out.println("w_CONNESBEN=a[9];");
      status.out.println("w_CONNALTRO=a[10];");
      status.out.println("w_DATAREG=a[11];");
      status.out.println("w_STATOREG=a[12];");
      status.out.println("w_DATARETT=a[13];");
      status.out.println("w_VALUTA=a[14];");
      status.out.println("w_IMPORTO=a[15];");
      status.out.println("w_CONTANTI=a[16];");
      status.out.println("w_MEZPAG=a[17];");
      status.out.println("w_PRESTAZ=a[18];");
      status.out.println("w_RAGIO=a[19];");
      status.out.println("w_MODSVOL=a[20];");
      status.out.println("w_AREAGEO=a[21];");
      status.out.println("w_TIPO=a[22];");
      status.out.println("w_AMMONT=a[23];");
      status.out.println("w_DURAT=a[24];");
      status.out.println("w_RAREA=a[25];");
      status.out.println("w_RRAGIO=a[26];");
      status.out.println("w_RCOMP=a[27];");
      status.out.println("w_RTIPO=a[28];");
      status.out.println("w_RFREQ=a[29];");
      status.out.println("w_RIMP=a[30];");
      status.out.println("w_TIPOOPER=a[31];");
      status.out.println("w_TXTERR=a[32];");
      status.out.println("w_DESPUNTO=a[33];");
      status.out.println("w_IMPPROG13=a[34];");
      status.out.println("w_xdestipope=a[35];");
      status.out.println("w_RAGSOCexec=a[36];");
      status.out.println("w_RAGSOCreal=a[37];");
      status.out.println("w_RAGSOCben=a[38];");
      status.out.println("w_RAGSOCaltro=a[39];");
      status.out.println("m_PrimaryKeys=['IMPPROG'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/opemt_scarti_import_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(656,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","scarti_import");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","IMPPROG");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(opemt_scarti_importBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IMPPROG:"+SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(opemt_scarti_importBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IMPPROG:"+SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(opemt_scarti_importBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IMPPROG:"+SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(opemt_scarti_importBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IMPPROG:"+SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(opemt_scarti_importBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IMPPROG:"+SPLib.ToJSValue(BO.w_IMPPROG,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(opemt_scarti_importBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(opemt_scarti_importBO BO,ServletStatus status) throws IOException {
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
  public String GetCheckVars(ServletStatus status,opemt_scarti_importBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(BO.w_IMPPROG,"N",10,0));
      }
    } else if (CPLib.eq(p_cUID,"TRIYBQSKCQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DHRGEXYQZL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SQWOYVEXHD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SFOARTDXXG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KYUSCDSEVM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,opemt_scarti_importBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_TIPOOPER))) {
        a = GetCheckVars(status,BO,"KYUSCDSEVM");
        b = status.m_CheckVars.optString("KYUSCDSEVM");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
