import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_wu_chkerr_unicr extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ec70610b*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "wuchkunicr";
    }
    public double w_WUCODICE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_WUCODICE,context,"wuchkunicr","WUCODICE","N",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='WUCODICE' type='hidden' value="+SPLib.ToHTMLValue(w_WUCODICE,"N",10,0)+">" +
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
    armt_wu_chkerr_unicrBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_wuchkunicr;
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
      status.w_WUCODICE = BO.w_WUCODICE;
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
    return "WU Import Unicredit Errors";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_wu_chkerr_unicr";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 973;
    l_eg.m_nEntityHeight = 683;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"wuchkunicr","anadip","tbcitta","tbstati","tbmacage"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("box_ZQTAJGZBZW","",""),new ZoneItem("OldOnes","Dati Da Import","collapsible"),new ZoneItem("NewOnes","Dati Modificati","collapsible")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"WUCODICE"};
    l_eg.items = new SPItem[]{
                   new SPItem("WUNOMEFILE","C",50,0, "show","Nome File"),
                   new SPItem("WUTIPOPE","C",1,0, "show","Tipo Informazione"),
                   new SPItem("WUCODDIP","C",6,0, "show","Codice Dipendenza"),
                   new SPItem("WUDATINI","D",8,0, "show","Data Inizio Rapporto"),
                   new SPItem("WUTIPERR","C",2,0, "hide","Tipo Errore"),
                   new SPItem("WUCODICE","N",10,0, "edit","Progressivo"),
                   new SPItem("WUNCAPCLI","C",5,0, "edit","Nuovo CAP Cliente"),
                   new SPItem("WUNDATNAS","D",8,0, "edit","Nuova Data Nascita Cliente"),
                   new SPItem("WUNRDOCCLI","D",8,0, "edit","Nuova Data Rilascio Documento"),
                   new SPItem("WUNSDOCCLI","D",8,0, "edit","Nuova Data Scadenza Documento"),
                   new SPItem("WUNTDOCCLI","C",2,0, "edit","Tipo Documento"),
                   new SPItem("WUNCODDIP","C",6,0, "edit","Nuovo Codice Dipendenza"),
                   new SPItem("WUNCITCLI","C",40,0, "edit","Citt� Cliente"),
                   new SPItem("WUNBSTACLI","C",40,0, "edit","Nuovo Stato Nascita Cliente"),
                   new SPItem("WUNBCITCLI","C",40,0, "edit","Nuova Citt� Nascita Cliente"),
                   new SPItem("WUNOMCLI","C",40,0, "show","Nome Cliente"),
                   new SPItem("WUCOGCLI","C",40,0, "show","Cognome Cliente"),
                   new SPItem("WUCITCLI","C",40,0, "show","Citt� Cliente"),
                   new SPItem("WUCAPCLI","C",5,0, "show","CAP Cliente"),
                   new SPItem("WUINDCLI","C",60,0, "show","Indirizzo Cliente"),
                   new SPItem("WUBCITCLI","C",40,0, "show","Citt� Nascita Cliente"),
                   new SPItem("WUBSTACLI","C",40,0, "show","Stato Nascita Cliente"),
                   new SPItem("WUDATNAS","C",10,0, "show","Data Nascita Cliente"),
                   new SPItem("WUCODFIS","C",16,0, "show","Codice Fiscale"),
                   new SPItem("WUNDOCCLI","C",25,0, "show","N� Documento"),
                   new SPItem("WUADOCRIL","C",30,0, "show","Autorit� Rilascio"),
                   new SPItem("WURDOCCLI","C",10,0, "show","Data Rilascio Documento"),
                   new SPItem("WUSDOCCLI","C",10,0, "show","Data Scadenza Documento"),
                   new SPItem("WUSEXCLI","C",1,0, "show","Sesso Cliente"),
                   new SPItem("WUTDOCCLI","C",2,0, "show","Tipo Documento"),
                   new SPItem("WUFLGALL","C",1,0, "edit","Completata"),
                   new SPItem("WUNCODFIS","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("WUCODMAGE","C",5,0, "show","MacroAgente (Network)"),
                   new SPItem("xMADESCRI","C",60,0, "hide","Denominazione"),
                   new SPItem("xDESDIP","C",30,0, "hide","Descrizione"),
                   new SPItem("WUNOTE","M",10,0, "edit","Elenco Errori"),
                   new SPItem("WUFLGFRC","C",1,0, "edit","Forza caricamento movimento"),
                   new SPItem("WUDATFIN","D",8,0, "show","Data FIne Rapporto"),
                   new SPItem("WUCODRAP","C",16,0, "show","Codice Rapporto"),
                   new SPItem("WUNDATINI","D",8,0, "edit","Data Inizio Rapporto"),
                   new SPItem("WUNDATFIN","D",8,0, "edit","Data FIne Rapporto"),
                   new SPItem("WUSTACLI","C",40,0, "show","Stato Residenza Cliente"),
                   new SPItem("WUNSEXCLI","C",1,0, "edit","Nuovo Sesso Cliente")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_wu_chkerr_unicrBO BO) {
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
    l_translations=new String[][]{{"10019062122",p_Context.Translate("Nuovo Stato Nascita Cliente")},
    {"10298161835",p_Context.Translate("Forza caricamento movimento")},
    {"10301607880",p_Context.Translate("Forza Scrittura")},
    {"1053791145",p_Context.Translate("Nuova Citt� Nascita Cliente")},
    {"10613332584",p_Context.Translate("Data Rilascio Documento")},
    {"106196876",p_Context.Translate("Citt� Cliente")},
    {"10654635466",p_Context.Translate("Cognome Cliente")},
    {"10708247299",p_Context.Translate("Indirizzo Cliente")},
    {"10879867155",p_Context.Translate("Nuova Data Scadenza Documento")},
    {"10931565647",p_Context.Translate("WU Import Unicredit Errors")},
    {"11006832099",p_Context.Translate("Data FIne Rapporto")},
    {"11073364735",p_Context.Translate("CAP Cliente")},
    {"11116511596",p_Context.Translate("Codice Rapporto")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11446421191",p_Context.Translate("Progressivo")},
    {"11455142958",p_Context.Translate("Nuova Data Rilascio Documento")},
    {"11580812047",p_Context.Translate("Stati / Nazioni")},
    {"115887692",p_Context.Translate("Dipendenze / Agenti")},
    {"11660994966",p_Context.Translate("Nuova Data Nascita Cliente")},
    {"11739564906",p_Context.Translate("Correzione Completa")},
    {"11770531981",p_Context.Translate("Tipo Errore")},
    {"11771839348",p_Context.Translate("Data Nascita Cliente")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11966900553",p_Context.Translate("Completata")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"1269487251",p_Context.Translate("N� Documento")},
    {"15186643",p_Context.Translate("Citt�")},
    {"1702672879",p_Context.Translate("Nuovo Sesso Cliente")},
    {"1707155314",p_Context.Translate("MacroAgente (Network)")},
    {"171367507",p_Context.Translate("Nuovo CAP Cliente")},
    {"1716260079",p_Context.Translate("Stato Nascita Cliente")},
    {"1723670319",p_Context.Translate("Citt� Nascita Cliente")},
    {"1973525056",p_Context.Translate("Autorit� Rilascio")},
    {"200428503",p_Context.Translate("Nuovo Codice Dipendenza")},
    {"2009784983",p_Context.Translate("Elenco Errori")},
    {"2032298989",p_Context.Translate("Data Inizio Rapporto")},
    {"2051023769",p_Context.Translate("Stato Residenza Cliente")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"6131587",p_Context.Translate("Nome Cliente")},
    {"628384699",p_Context.Translate("Data Scadenza Documento")},
    {"684190680",p_Context.Translate("Tipo Informazione")},
    {"763806883",p_Context.Translate("Nome File")},
    {"98786908",p_Context.Translate("Sesso Cliente")}};
    return l_translations;
  }
  void WriteStyles(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_wu_chkerr_unicr.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wu_chkerr_unicr',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_wu_chkerr_unicr",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:683px;width:973px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
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
  void WriteControls_p1_b0(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:204px;display:block' page='1'>" +
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
       "<div id='ZQTAJGZBZW_DIV' class='UntitledBox'>" +
       "<div id='ZQTAJGZBZW' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<input name='WUNOMEFILE' id='FRJJPRUOYV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUNOMEFILE,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UPQGGDQSUQ_DIV'>" +
       "<label id='UPQGGDQSUQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome File:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<select name='WUTIPOPE' id='LDWZRELAZY' class='Combobox Disabled' disabled>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_WUTIPOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Apertura")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_WUTIPOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Aggiornamento")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_WUTIPOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Chiusura")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('LDWZRELAZY'),w_WUTIPOPE,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUCODICE' id='TYZCFXYXSP' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_WUCODICE,"N",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='11' size='10' fieldtype='N' style='display:none'>" +
      "");
      status.out.println(
       "<input name='WUCODMAGE' id='FHWIGGJJLC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCODMAGE,"C",5,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MLTVMLJQKT_DIV'>" +
       "<label id='MLTVMLJQKT' for='FHWIGGJJLC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("MacroAgente (Network):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PGAQTUPTSI_DIV'>" +
       "<label id='PGAQTUPTSI'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xMADESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='WUNOTE' id='AUBWLVTBES' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WZOXFCXKRT_DIV'>" +
       "<label id='WZOXFCXKRT' for='LDWZRELAZY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Informazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.out.println(
     "<div name='OldOnes' id='RSDQEMGAOL_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='RSDQEMGAOL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='RSDQEMGAOL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Da Import")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='RSDQEMGAOL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"RSDQEMGAOL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=RSDQEMGAOL_HEADER&m_cBoxId=RSDQEMGAOL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Da Import"))+"");
    }
    status.out.println(
     "<div id='RSDQEMGAOL' class='CollapsibleBody' style='position:relative;height:259px;display:block'>" +
    "");
    status.includeZoneAltInterface("OldOnes@BEGIN");
    if (status.includeZoneAltInterface("OldOnes")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("OldOnes@BEGIN") || status.HasZoneAltInterface("OldOnes@END")) {
        status.out.println(
         "<div id='RSDQEMGAOL_boxContent' style='position:relative;height:259px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='WUCODDIP' id='SAINYUGXKT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCODDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VFPEGKTENT_DIV'>" +
       "<label id='VFPEGKTENT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUDATINI' id='ZWACREYOWM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUDATINI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FULJTPTEYV_DIV'>" +
       "<label id='FULJTPTEYV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Inizio Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUNOMCLI' id='LGVFOMYNPG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUNOMCLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IYEFJVHBUP_DIV'>" +
       "<label id='IYEFJVHBUP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUCOGCLI' id='KXQAAJEHME' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCOGCLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VXLPQPNMRE_DIV'>" +
       "<label id='VXLPQPNMRE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUCITCLI' id='DSDXXCNFTB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCITCLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KHKCQNKAVF_DIV'>" +
       "<label id='KHKCQNKAVF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt� Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUCAPCLI' id='VGRIHHYXXD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCAPCLI,"C",5,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ANNDLELTUI_DIV'>" +
       "<label id='ANNDLELTUI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUINDCLI' id='CGAYBPFHFD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUINDCLI,"C",60,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='60' size='60' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CXQFMZWQBL_DIV'>" +
       "<label id='CXQFMZWQBL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUBCITCLI' id='XYZGDIEBQV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUBCITCLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TABSWVHCZN_DIV'>" +
       "<label id='TABSWVHCZN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt� Nascita Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUBSTACLI' id='JDYYUWYTGY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUBSTACLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MZKPVDVQSA_DIV'>" +
       "<label id='MZKPVDVQSA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Nascita Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUDATNAS' id='KTVPFMPGUX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUDATNAS,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CSGIQWNGXO_DIV'>" +
       "<label id='CSGIQWNGXO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Nascita Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XBYNQJGSTD_DIV'>" +
       "<label id='XBYNQJGSTD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUCODFIS' id='JMOAJRUZVG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCODFIS,"C",16,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JEPAFHMKJO_DIV'>" +
       "<label id='JEPAFHMKJO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ADLMRZLWWG_DIV'>" +
       "<label id='ADLMRZLWWG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUNDOCCLI' id='JNCAEVBDYL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUNDOCCLI,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CSXRNANFRD_DIV'>" +
       "<label id='CSXRNANFRD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N� Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUADOCRIL' id='DGJAFVSPZS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUADOCRIL,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VPSNKTDSLR_DIV'>" +
       "<label id='VPSNKTDSLR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorit� Rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WURDOCCLI' id='DRAAKQTXFV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WURDOCCLI,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CLEHMQOZVF_DIV'>" +
       "<label id='CLEHMQOZVF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rilascio Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUSDOCCLI' id='MGEWPRXRDF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUSDOCCLI,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LQIMPKLXCK_DIV'>" +
       "<label id='LQIMPKLXCK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Scadenza Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<select name='WUSEXCLI' id='RMCFXDIVEO' class='Combobox Disabled' disabled>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_WUSEXCLI))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_WUSEXCLI))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femmina")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('RMCFXDIVEO'),w_WUSEXCLI,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<select name='WUTDOCCLI' id='JOQUHREGBT' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<input name='WUDATFIN' id='MXRQJMATTY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUDATFIN,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ENPKAZVEKQ_DIV'>" +
       "<label id='ENPKAZVEKQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUCODRAP' id='SEVFVXQPIQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUCODRAP,"C",16,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BBLCNPLMLD_DIV'>" +
       "<label id='BBLCNPLMLD' for='SEVFVXQPIQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='WUSTACLI' id='BRKXQSUQEO' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_WUSTACLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AYNUUDNLXV_DIV'>" +
       "<label id='AYNUUDNLXV' for='BRKXQSUQEO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Residenza Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("OldOnes@BEGIN") || status.HasZoneAltInterface("OldOnes@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.includeZoneAltInterface("OldOnes@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("OldOnes")) {
      status.out.println("Ctrl('RSDQEMGAOL').style.height='auto';");
    } else {
      status.out.println("Ctrl('RSDQEMGAOL').setAttribute('band_height',259);");
    }
    status.out.println("Ctrl('RSDQEMGAOL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_JKOQQOCGZL")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_JKOQQOCGZL' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_JKOQQOCGZL")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_JKOQQOCGZL').style.height='auto';");
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
  void WriteControls_p1_b3(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.out.println(
     "<div name='NewOnes' id='JKOQQOCGZL_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='JKOQQOCGZL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='JKOQQOCGZL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Modificati")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='JKOQQOCGZL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"JKOQQOCGZL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=JKOQQOCGZL_HEADER&m_cBoxId=JKOQQOCGZL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Modificati"))+"");
    }
    status.out.println(
     "<div id='JKOQQOCGZL' class='CollapsibleBody' style='position:relative;height:174px;display:block'>" +
    "");
    status.includeZoneAltInterface("NewOnes@BEGIN");
    if (status.includeZoneAltInterface("NewOnes")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("NewOnes@BEGIN") || status.HasZoneAltInterface("NewOnes@END")) {
        status.out.println(
         "<div id='JKOQQOCGZL_boxContent' style='position:relative;height:174px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNCAPCLI' id='DNFJVJRGTH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNCAPCLI,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNDATNAS' id='DJOIOBUZTW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNDATNAS,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNRDOCCLI' id='PKOBXVTTQB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNRDOCCLI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNSDOCCLI' id='YCVYLQBAVQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNSDOCCLI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ATMIRGZJIT_DIV'>" +
       "<label id='ATMIRGZJIT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OZMVUXIVZE_DIV'>" +
       "<label id='OZMVUXIVZE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt� Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BDSYRBXZOM_DIV'>" +
       "<label id='BDSYRBXZOM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VDBPAWYBBX_DIV'>" +
       "<label id='VDBPAWYBBX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt� Nascita Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EYEPLDXQKM_DIV'>" +
       "<label id='EYEPLDXQKM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Nascita Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JLXIRLXRUF_DIV'>" +
       "<label id='JLXIRLXRUF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Nascita Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LXZNAJSOTJ_DIV'>" +
       "<label id='LXZNAJSOTJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='POXLHOKSCG_DIV'>" +
       "<label id='POXLHOKSCG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rilascio Doc.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BOJZSPVVUA_DIV'>" +
       "<label id='BOJZSPVVUA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Scadenza Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='WUNTDOCCLI' id='MCJVDAFNOQ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNCODDIP' id='RPXEDSQTUE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNCODDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='RPXEDSQTUE_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RPXEDSQTUE", "anadip", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNCITCLI' id='AZSYSFMRUL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNCITCLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
       "<button id='AZSYSFMRUL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "AZSYSFMRUL", "tbcitta", "armt_citta", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNBSTACLI' id='GPWUEBYSIT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNBSTACLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
       "<button id='GPWUEBYSIT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "GPWUEBYSIT", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNBCITCLI' id='SQSTTNXNEF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNBCITCLI,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
       "<button id='SQSTTNXNEF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SQSTTNXNEF", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ZZOJSEEQWY_DIV'>" +
       "<input name='WUFLGALL' id='ZZOJSEEQWY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_WUFLGALL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_WUFLGALL))?"CHECKED":"")+">" +
       "<label id='ZZOJSEEQWY_LBL' for='ZZOJSEEQWY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Correzione Completa"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNCODFIS' id='UBNCXWNHSA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNCODFIS,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GHZQTXZJUL_DIV'>" +
       "<label id='GHZQTXZJUL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='YYWDAHCCHA_DIV'>" +
       "<input name='WUFLGFRC' id='YYWDAHCCHA' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_WUFLGFRC,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_WUFLGFRC))?"CHECKED":"")+">" +
       "<label id='YYWDAHCCHA_LBL' for='YYWDAHCCHA' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Forza Scrittura"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNDATINI' id='WQBGAJEIXP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNDATINI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XRAAFNNGDO_DIV'>" +
       "<label id='XRAAFNNGDO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Inizio Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='WUNDATFIN' id='GEZZWCCIJK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_WUNDATFIN,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ALEMISVODS_DIV'>" +
       "<label id='ALEMISVODS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MVOVQAXRBO_DIV'>" +
       "<label id='MVOVQAXRBO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso Cliente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='WUNSEXCLI' id='TADITPUPOP' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_WUNSEXCLI))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_WUNSEXCLI))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femmina")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('TADITPUPOP'),w_WUNSEXCLI,'C');" +
       "</script>" +
      "");
      if (status.HasZoneAltInterface("NewOnes@BEGIN") || status.HasZoneAltInterface("NewOnes@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.includeZoneAltInterface("NewOnes@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("NewOnes")) {
      status.out.println("Ctrl('JKOQQOCGZL').style.height='auto';");
    } else {
      status.out.println("Ctrl('JKOQQOCGZL').setAttribute('band_height',174);");
    }
    status.out.println("Ctrl('JKOQQOCGZL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
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
  static void PrintState(armt_wu_chkerr_unicrBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_wu_chkerr_unicrBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_wu_chkerr_unicrBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_WUNOMEFILE,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUTIPOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCODDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUDATINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUTIPERR,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNCAPCLI,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNDATNAS,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNRDOCCLI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNSDOCCLI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNTDOCCLI,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNCODDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNCITCLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNBSTACLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNBCITCLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNOMCLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCOGCLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCITCLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCAPCLI,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUINDCLI,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUBCITCLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUBSTACLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUDATNAS,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCODFIS,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNDOCCLI,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUADOCRIL,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WURDOCCLI,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUSDOCCLI,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUSEXCLI,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUTDOCCLI,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUFLGALL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNCODFIS,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCODMAGE,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNOTE,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUFLGFRC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUDATFIN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUCODRAP,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNDATINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNDATFIN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUSTACLI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_WUNSEXCLI,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMADESCRI,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESDIP,"C",30,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_PGAQTUPTSI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(683,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(973,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_wu_chkerr_unicr"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'RPXEDSQTUE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RPXEDSQTUE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'AZSYSFMRUL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AZSYSFMRUL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'GPWUEBYSIT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GPWUEBYSIT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'SQSTTNXNEF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SQSTTNXNEF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'FHWIGGJJLC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"FHWIGGJJLC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'RPXEDSQTUE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'AZSYSFMRUL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'GPWUEBYSIT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'SQSTTNXNEF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'FHWIGGJJLC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_wu_chkerr_unicr","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_wu_chkerr_unicr",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_ZQTAJGZBZW"),"")) {
      status.quoteAndAppend("box_ZQTAJGZBZW","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("OldOnes"),"")) {
      status.quoteAndAppend("OldOnes","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("NewOnes"),"")) {
      status.quoteAndAppend("NewOnes","hide","box");
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
  void WriteMainFormScript(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wu_chkerr_unicr',false);");
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
        status.out.println("if(c=Ctrl('TYZCFXYXSP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DNFJVJRGTH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJOIOBUZTW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PKOBXVTTQB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YCVYLQBAVQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MCJVDAFNOQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RPXEDSQTUE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RPXEDSQTUE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AZSYSFMRUL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AZSYSFMRUL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GPWUEBYSIT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GPWUEBYSIT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SQSTTNXNEF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SQSTTNXNEF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZZOJSEEQWY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UBNCXWNHSA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AUBWLVTBES')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YYWDAHCCHA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WQBGAJEIXP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GEZZWCCIJK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TADITPUPOP')) SetDisabled(c,true);");
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
        status.out.println("if(c=Ctrl('TYZCFXYXSP')) SetDisabled(c,true);");
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
  armt_wu_chkerr_unicrBO getBO(ServletStatus status) {
    armt_wu_chkerr_unicrBO BO = new armt_wu_chkerr_unicrBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_wu_chkerr_unicrBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("wuchkunicr",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_wu_chkerr_unicrBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_tbtipdoc,"",""));
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
    status.out.println("var MCJVDAFNOQ_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_tbtipdoc,"",""));
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
    status.out.println("var JOQUHREGBT_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_wuchkunicr;
    String l_cPhName = BO.m_cPhName_wuchkunicr;
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    // * --- Area Manuale = BO - Query Key Set Init
    // * --- Fine Area Manuale
    int l_nIdx;
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_wu_chkerr_unicrBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_wuchkunicr+".WUCODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("wuchkunicr");
    String l_cPhName = CPSql.ManipulateTablePhName("wuchkunicr",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".WUCODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_wu_chkerr_unicrBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_wuchkunicr,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_wuchkunicr,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
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
  void Edit(ServletStatus status,armt_wu_chkerr_unicrBO BO,SPParameterSource source) {
    BO.Load(status.w_WUCODICE);
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
  void New(ServletStatus status,armt_wu_chkerr_unicrBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_wu_chkerr_unicrBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_WUCODICE = 0;
      } else {
        BO.w_WUCODICE = l_rsKeys.GetDouble("WUCODICE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_WUCODICE = BO.w_WUCODICE;
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
  void EditLoad(ServletStatus status,armt_wu_chkerr_unicrBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_wu_chkerr_unicrBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_WUCODICE);
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
  void DeleteMessage(ServletStatus status,armt_wu_chkerr_unicrBO BO,SPParameterSource source) {
    BO.Load(status.w_WUCODICE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({WUCODICE:"+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",643);
    item.put("w",973);
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
    item.put("altInterfaceFor","armt_wu_chkerr_unicr");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"OldOnes\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Da Import\",\"h\":259,\"name\":\"OldOnes\",\"page\":1,\"shrinkable\":true,\"spuid\":\"RSDQEMGAOL\",\"tabindex\":2,\"title_caption\":\"Dati Da Import\",\"titled\":true,\"type\":\"Box\",\"w\":960,\"x\":8,\"y\":204,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Dipendenza\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"WUCODDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SAINYUGXKT\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":152,\"y\":211,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VFPEGKTENT\",\"page\":1,\"spuid\":\"VFPEGKTENT\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Codice Dipendenza:\",\"w\":95,\"x\":56,\"y\":215,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Inizio Rapporto\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"WUDATINI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZWACREYOWM\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":152,\"y\":239,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FULJTPTEYV\",\"page\":1,\"spuid\":\"FULJTPTEYV\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Data Inizio Rapporto:\",\"w\":127,\"x\":24,\"y\":243,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"WUNOMCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LGVFOMYNPG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":152,\"y\":267,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IYEFJVHBUP\",\"page\":1,\"spuid\":\"IYEFJVHBUP\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Nome Cliente:\",\"w\":67,\"x\":84,\"y\":271,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"WUCOGCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KXQAAJEHME\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":704,\"y\":267,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VXLPQPNMRE\",\"page\":1,\"spuid\":\"VXLPQPNMRE\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Cognome Cliente:\",\"w\":85,\"x\":618,\"y\":271,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"WUCITCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DSDXXCNFTB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":152,\"y\":295,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KHKCQNKAVF\",\"page\":1,\"spuid\":\"KHKCQNKAVF\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Cliente:\",\"w\":63,\"x\":88,\"y\":299,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"WUCAPCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VGRIHHYXXD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":704,\"y\":295,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ANNDLELTUI\",\"page\":1,\"spuid\":\"ANNDLELTUI\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"CAP Cliente:\",\"w\":60,\"x\":643,\"y\":299,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":60,\"name\":\"WUINDCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"CGAYBPFHFD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":152,\"y\":323,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CXQFMZWQBL\",\"page\":1,\"spuid\":\"CXQFMZWQBL\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Indirizzo Cliente:\",\"w\":80,\"x\":71,\"y\":327,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Nascita Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"WUBCITCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XYZGDIEBQV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":152,\"y\":351,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TABSWVHCZN\",\"page\":1,\"spuid\":\"TABSWVHCZN\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Nascita Cliente:\",\"w\":101,\"x\":50,\"y\":355,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato Nascita Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"WUBSTACLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"JDYYUWYTGY\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":704,\"y\":351,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MZKPVDVQSA\",\"page\":1,\"spuid\":\"MZKPVDVQSA\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Stato Nascita Cliente:\",\"w\":104,\"x\":599,\"y\":355,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato Residenza Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"WUSTACLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BRKXQSUQEO\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":704,\"y\":322,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AYNUUDNLXV\",\"page\":1,\"spuid\":\"AYNUUDNLXV\",\"tabindex\":81,\"type\":\"Label\",\"value\":\"Stato Residenza Cliente:\",\"w\":118,\"x\":586,\"y\":326,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Nascita Cliente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"WUDATNAS\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KTVPFMPGUX\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":152,\"y\":379,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CSGIQWNGXO\",\"page\":1,\"spuid\":\"CSGIQWNGXO\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Data Nascita Cliente:\",\"w\":101,\"x\":50,\"y\":383,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XBYNQJGSTD\",\"page\":1,\"spuid\":\"XBYNQJGSTD\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Sesso Cliente:\",\"w\":68,\"x\":331,\"y\":383,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso Cliente\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"WUSEXCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RMCFXDIVEO\",\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":112,\"x\":400,\"y\":379,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale\",\"disabled\":\"true\",\"h\":20,\"maxlength\":16,\"name\":\"WUCODFIS\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"JMOAJRUZVG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":136,\"x\":704,\"y\":379,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JEPAFHMKJO\",\"page\":1,\"spuid\":\"JEPAFHMKJO\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":71,\"x\":632,\"y\":383,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ADLMRZLWWG\",\"page\":1,\"spuid\":\"ADLMRZLWWG\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":81,\"x\":70,\"y\":411,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Documento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"WUTDOCCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"JOQUHREGBT\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":224,\"x\":152,\"y\":407,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Documento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":25,\"name\":\"WUNDOCCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"JNCAEVBDYL\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":704,\"y\":407,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CSXRNANFRD\",\"page\":1,\"spuid\":\"CSXRNANFRD\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"N\\u00B0 Documento:\",\"w\":73,\"x\":630,\"y\":411,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 Rilascio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"WUADOCRIL\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DGJAFVSPZS\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":704,\"y\":435,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VPSNKTDSLR\",\"page\":1,\"spuid\":\"VPSNKTDSLR\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 Rilascio:\",\"w\":81,\"x\":622,\"y\":439,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio Documento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"WURDOCCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DRAAKQTXFV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":152,\"y\":435,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CLEHMQOZVF\",\"page\":1,\"spuid\":\"CLEHMQOZVF\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Data Rilascio Documento:\",\"w\":122,\"x\":29,\"y\":439,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Scadenza Documento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"WUSDOCCLI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MGEWPRXRDF\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":400,\"y\":435,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LQIMPKLXCK\",\"page\":1,\"spuid\":\"LQIMPKLXCK\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"Data Scadenza Documento:\",\"w\":133,\"x\":266,\"y\":439,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data FIne Rapporto\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"WUDATFIN\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MXRQJMATTY\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":704,\"y\":239,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ENPKAZVEKQ\",\"page\":1,\"spuid\":\"ENPKAZVEKQ\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"Data Fine Rapporto:\",\"w\":127,\"x\":576,\"y\":243,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Rapporto\",\"disabled\":\"true\",\"h\":20,\"maxlength\":16,\"name\":\"WUCODRAP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SEVFVXQPIQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":704,\"y\":211,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BBLCNPLMLD\",\"page\":1,\"spuid\":\"BBLCNPLMLD\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"Codice Rapporto:\",\"w\":84,\"x\":620,\"y\":215,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"NewOnes\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Modificati\",\"h\":174,\"name\":\"NewOnes\",\"page\":1,\"shrinkable\":true,\"spuid\":\"JKOQQOCGZL\",\"tabindex\":12,\"title_caption\":\"Dati Modificati\",\"titled\":true,\"type\":\"Box\",\"w\":960,\"x\":8,\"y\":464,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nuovo CAP Cliente\",\"h\":20,\"maxlength\":5,\"name\":\"WUNCAPCLI\",\"page\":1,\"spuid\":\"DNFJVJRGTH\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":704,\"y\":526,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BDSYRBXZOM\",\"page\":1,\"spuid\":\"BDSYRBXZOM\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"CAP Cliente:\",\"w\":60,\"x\":643,\"y\":530,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nuova Data Nascita Cliente\",\"h\":20,\"maxlength\":10,\"name\":\"WUNDATNAS\",\"page\":1,\"spuid\":\"DJOIOBUZTW\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":152,\"y\":582,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JLXIRLXRUF\",\"page\":1,\"spuid\":\"JLXIRLXRUF\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Data Nascita Cliente:\",\"w\":101,\"x\":50,\"y\":586,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nuova Data Rilascio Documento\",\"h\":20,\"maxlength\":10,\"name\":\"WUNRDOCCLI\",\"page\":1,\"spuid\":\"PKOBXVTTQB\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":480,\"y\":609,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nuova Data Scadenza Documento\",\"h\":20,\"maxlength\":10,\"name\":\"WUNSDOCCLI\",\"page\":1,\"spuid\":\"YCVYLQBAVQ\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":704,\"y\":610,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LXZNAJSOTJ\",\"page\":1,\"spuid\":\"LXZNAJSOTJ\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":81,\"x\":70,\"y\":614,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_POXLHOKSCG\",\"page\":1,\"spuid\":\"POXLHOKSCG\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Data Rilascio Doc.:\",\"w\":122,\"x\":357,\"y\":613,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BOJZSPVVUA\",\"page\":1,\"spuid\":\"BOJZSPVVUA\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Data Scadenza Documento:\",\"w\":133,\"x\":570,\"y\":614,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"WUNTDOCCLI\",\"page\":1,\"spuid\":\"MCJVDAFNOQ\",\"tabindex\":26,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":224,\"x\":152,\"y\":610,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ATMIRGZJIT\",\"page\":1,\"spuid\":\"ATMIRGZJIT\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Codice Dipendenza:\",\"w\":95,\"x\":56,\"y\":475,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Nuovo Codice Dipendenza\",\"h\":20,\"maxlength\":6,\"name\":\"WUNCODDIP\",\"page\":1,\"picker\":true,\"spuid\":\"RPXEDSQTUE\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":70,\"x\":152,\"y\":471,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OZMVUXIVZE\",\"page\":1,\"spuid\":\"OZMVUXIVZE\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Cliente:\",\"w\":63,\"x\":88,\"y\":530,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0 Cliente\",\"h\":20,\"maxlength\":40,\"name\":\"WUNCITCLI\",\"page\":1,\"picker\":true,\"spuid\":\"AZSYSFMRUL\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":152,\"y\":526,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EYEPLDXQKM\",\"page\":1,\"spuid\":\"EYEPLDXQKM\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Stato Nascita Cliente:\",\"w\":104,\"x\":599,\"y\":558,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Nuovo Stato Nascita Cliente\",\"h\":20,\"maxlength\":40,\"name\":\"WUNBSTACLI\",\"page\":1,\"picker\":true,\"spuid\":\"GPWUEBYSIT\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":238,\"x\":704,\"y\":554,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VDBPAWYBBX\",\"page\":1,\"spuid\":\"VDBPAWYBBX\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Nascita Cliente:\",\"w\":101,\"x\":50,\"y\":558,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Nuova Citt\\u00E0 Nascita Cliente\",\"h\":20,\"maxlength\":40,\"name\":\"WUNBCITCLI\",\"page\":1,\"picker\":true,\"spuid\":\"SQSTTNXNEF\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":152,\"y\":554,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Completata\",\"h\":21,\"label_text\":\"Correzione Completa\",\"maxlength\":1,\"name\":\"WUFLGALL\",\"page\":1,\"spuid\":\"ZZOJSEEQWY\",\"tabindex\":61,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":128,\"x\":832,\"y\":610,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"WUNCODFIS\",\"page\":1,\"spuid\":\"UBNCXWNHSA\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":704,\"y\":582,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GHZQTXZJUL\",\"page\":1,\"spuid\":\"GHZQTXZJUL\",\"tabindex\":63,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":71,\"x\":632,\"y\":586,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Forza caricamento movimento\",\"h\":21,\"label_text\":\"Forza Scrittura\",\"maxlength\":1,\"name\":\"WUFLGFRC\",\"page\":1,\"spuid\":\"YYWDAHCCHA\",\"tabindex\":70,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":128,\"x\":832,\"y\":582,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Inizio Rapporto\",\"h\":20,\"maxlength\":10,\"name\":\"WUNDATINI\",\"page\":1,\"spuid\":\"WQBGAJEIXP\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":88,\"x\":152,\"y\":498,\"zone\":\"pag1_2_10\",\"zonepath\":\"[1,2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XRAAFNNGDO\",\"page\":1,\"spuid\":\"XRAAFNNGDO\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"Data Inizio Rapporto:\",\"w\":127,\"x\":24,\"y\":502,\"zone\":\"pag1_2_10\",\"zonepath\":\"[1,2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data FIne Rapporto\",\"h\":20,\"maxlength\":10,\"name\":\"WUNDATFIN\",\"page\":1,\"spuid\":\"GEZZWCCIJK\",\"tabindex\":78,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":88,\"x\":704,\"y\":498,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ALEMISVODS\",\"page\":1,\"spuid\":\"ALEMISVODS\",\"tabindex\":79,\"type\":\"Label\",\"value\":\"Data Fine Rapporto:\",\"w\":127,\"x\":576,\"y\":502,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MVOVQAXRBO\",\"page\":1,\"spuid\":\"MVOVQAXRBO\",\"tabindex\":82,\"type\":\"Label\",\"value\":\"Sesso Cliente:\",\"w\":68,\"x\":411,\"y\":585,\"zone\":\"pag1_2_12\",\"zonepath\":\"[1,2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nuovo Sesso Cliente\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"WUNSEXCLI\",\"page\":1,\"spuid\":\"TADITPUPOP\",\"tabindex\":83,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":112,\"x\":480,\"y\":581,\"zone\":\"pag1_2_12\",\"zonepath\":\"[1,2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_ZQTAJGZBZW\",\"h\":196,\"name\":\"box_ZQTAJGZBZW\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ZQTAJGZBZW\",\"tabindex\":1,\"type\":\"Box\",\"w\":960,\"x\":8,\"y\":7,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome File\",\"disabled\":\"true\",\"h\":20,\"maxlength\":50,\"name\":\"WUNOMEFILE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FRJJPRUOYV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":384,\"x\":152,\"y\":14,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UPQGGDQSUQ\",\"page\":1,\"spuid\":\"UPQGGDQSUQ\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Nome File:\",\"w\":50,\"x\":101,\"y\":18,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Informazione\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"WUTIPOPE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LDWZRELAZY\",\"textlist\":\"Apertura,Aggiornamento,Chiusura\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":128,\"x\":832,\"y\":14,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZOXFCXKRT\",\"page\":1,\"spuid\":\"WZOXFCXKRT\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Tipo Informazione:\",\"w\":90,\"x\":742,\"y\":18,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"MacroAgente (Network)\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"WUCODMAGE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FHWIGGJJLC\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":152,\"y\":42,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MLTVMLJQKT\",\"page\":1,\"spuid\":\"MLTVMLJQKT\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"MacroAgente (Network):\",\"w\":119,\"x\":33,\"y\":46,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PGAQTUPTSI\",\"page\":1,\"spuid\":\"PGAQTUPTSI\",\"tabindex\":67,\"type\":\"Label\",\"w\":328,\"x\":208,\"y\":46,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Elenco Errori\",\"h\":119,\"name\":\"WUNOTE\",\"page\":1,\"scroll\":true,\"spuid\":\"AUBWLVTBES\",\"tabindex\":69,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":520,\"x\":232,\"y\":77,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
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
     "<script src='armt_wu_chkerr_unicr?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wu_chkerr_unicr_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wu_chkerr_unicr_edit.js'>" +
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
      status.out.println("w_WUNOMEFILE=a[0];");
      status.out.println("w_WUTIPOPE=a[1];");
      status.out.println("w_WUCODDIP=a[2];");
      status.out.println("w_WUDATINI=a[3];");
      status.out.println("w_WUTIPERR=a[4];");
      status.out.println("w_WUCODICE=a[5];");
      status.out.println("w_WUNCAPCLI=a[6];");
      status.out.println("w_WUNDATNAS=a[7];");
      status.out.println("w_WUNRDOCCLI=a[8];");
      status.out.println("w_WUNSDOCCLI=a[9];");
      status.out.println("w_WUNTDOCCLI=a[10];");
      status.out.println("w_WUNCODDIP=a[11];");
      status.out.println("w_WUNCITCLI=a[12];");
      status.out.println("w_WUNBSTACLI=a[13];");
      status.out.println("w_WUNBCITCLI=a[14];");
      status.out.println("w_WUNOMCLI=a[15];");
      status.out.println("w_WUCOGCLI=a[16];");
      status.out.println("w_WUCITCLI=a[17];");
      status.out.println("w_WUCAPCLI=a[18];");
      status.out.println("w_WUINDCLI=a[19];");
      status.out.println("w_WUBCITCLI=a[20];");
      status.out.println("w_WUBSTACLI=a[21];");
      status.out.println("w_WUDATNAS=a[22];");
      status.out.println("w_WUCODFIS=a[23];");
      status.out.println("w_WUNDOCCLI=a[24];");
      status.out.println("w_WUADOCRIL=a[25];");
      status.out.println("w_WURDOCCLI=a[26];");
      status.out.println("w_WUSDOCCLI=a[27];");
      status.out.println("w_WUSEXCLI=a[28];");
      status.out.println("w_WUTDOCCLI=a[29];");
      status.out.println("w_WUFLGALL=a[30];");
      status.out.println("w_WUNCODFIS=a[31];");
      status.out.println("w_WUCODMAGE=a[32];");
      status.out.println("w_WUNOTE=a[33];");
      status.out.println("w_WUFLGFRC=a[34];");
      status.out.println("w_WUDATFIN=a[35];");
      status.out.println("w_WUCODRAP=a[36];");
      status.out.println("w_WUNDATINI=a[37];");
      status.out.println("w_WUNDATFIN=a[38];");
      status.out.println("w_WUSTACLI=a[39];");
      status.out.println("w_WUNSEXCLI=a[40];");
      status.out.println("w_xMADESCRI=a[41];");
      status.out.println("w_xDESDIP=a[42];");
      status.out.println("if (Gt(a.length,43)) {");
      status.out.println("o_WUCODMAGE=w_WUCODMAGE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['WUCODICE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wu_chkerr_unicr_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(683,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","wuchkunicr");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","WUCODICE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({WUCODICE:"+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({WUCODICE:"+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({WUCODICE:"+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({WUCODICE:"+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_wu_chkerr_unicrBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({WUCODICE:"+SPLib.ToJSValue(BO.w_WUCODICE,"N",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_wu_chkerr_unicrBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_wu_chkerr_unicrBO BO,ServletStatus status) throws IOException {
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
  public String GetCheckVars(ServletStatus status,armt_wu_chkerr_unicrBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(BO.w_WUCODICE,"N",10,0));
      }
    } else if (CPLib.eq(p_cUID,"RPXEDSQTUE")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AZSYSFMRUL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GPWUEBYSIT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SQSTTNXNEF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"FHWIGGJJLC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_wu_chkerr_unicrBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_WUNCODDIP))) {
        a = GetCheckVars(status,BO,"RPXEDSQTUE");
        b = status.m_CheckVars.optString("RPXEDSQTUE");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_WUNCITCLI))) {
        a = GetCheckVars(status,BO,"AZSYSFMRUL");
        b = status.m_CheckVars.optString("AZSYSFMRUL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_WUNBSTACLI))) {
        a = GetCheckVars(status,BO,"GPWUEBYSIT");
        b = status.m_CheckVars.optString("GPWUEBYSIT");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_WUNBCITCLI))) {
        a = GetCheckVars(status,BO,"SQSTTNXNEF");
        b = status.m_CheckVars.optString("SQSTTNXNEF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_WUCODMAGE))) {
        a = GetCheckVars(status,BO,"FHWIGGJJLC");
        b = status.m_CheckVars.optString("FHWIGGJJLC");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
