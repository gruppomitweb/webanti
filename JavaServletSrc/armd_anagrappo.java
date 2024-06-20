import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armd_anagrappo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*fefe87c5*!";
  static public class ServletStatus extends SPMasterDetailServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "aetesta";
    }
    public String w_RAPPORTO;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_RAPPORTO,context,"aetesta","RAPPORTO","C",25,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='RAPPORTO' type='hidden' value="+SPLib.ToHTMLValue(w_RAPPORTO,"C",25,0)+">" +
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
    armd_anagrappoBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_aetesta;
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
      status.w_RAPPORTO = BO.w_RAPPORTO;
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
    return "Informazioni Rapporti per Agenzia delle Entrate (DDR 2007/9647)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armd_anagrappo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 767;
    l_eg.m_nEntityHeight = 579;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"aetesta","personbo","aecanc"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Aperture/Chiusure","page"),new ZoneItem("page_2","Saldi Annuali","page"),new ZoneItem("box_XDYFKZMJHC","",""),new ZoneItem("box_KLSWWEOHOR","",""),new ZoneItem("box_BJDGPHQYFI","",""),new ZoneItem("box_WNPHGDFVJX","",""),new ZoneItem("box_RANZSHNOJF","",""),new ZoneItem("box_UBHZWYZYEF","Dati Esito Agenzia Entrate","titled_box"),new ZoneItem("box_TGJYPNQVEJ","","")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"RAPPORTO"};
    l_eg.keyRepeatedColumns = new String[]{"CPROWNUM"};
    l_eg.items = new SPItem[]{
                   new SPItem("RAPPORTO","C",25,0, "edit","Codice Rapporto"),
                   new SPItem("TIPOAG","C",2,0, "edit","Tipo Rapporto"),
                   new SPItem("COINT","C",1,0, "edit","Tipo Rapporto"),
                   new SPItem("RIFANA","C",1,0, "hide","Riferimento Anagrafico"),
                   new SPItem("PROGAET","N",15,0, "hide",""),
                   new SPItem("CONNESINT","C",16,0, "edit","Codice Intestatario"),
                   new SPItem("ASPEDITO","N",1,0, "edit","Apertura Spedita"),
                   new SPItem("ADATA","D",8,0, "edit","Data Apertura"),
                   new SPItem("APROG","C",25,0, "edit","Riferimento Spedizione Apertura"),
                   new SPItem("AOLDPROG","C",25,0, "hide","Precedente progressivo spedizione"),
                   new SPItem("AFILE","C",15,0, "edit","Riferimento file spedizione"),
                   new SPItem("AOLDFILE","C",15,0, "hide","Riferimento file vecchia spedizione"),
                   new SPItem("ADATARET","D",8,0, "hide","Data rettifica apertura"),
                   new SPItem("CSPEDITO","N",1,0, "edit","Data Spedizione Chiusura"),
                   new SPItem("CDATA","D",8,0, "edit","Data Chiusura Rapporto"),
                   new SPItem("CPROG","C",25,0, "edit","Riferimento spedizione chiusura"),
                   new SPItem("COLDPROG","C",25,0, "hide","Precedente riferimento chiusura"),
                   new SPItem("CFILE","C",15,0, "edit","File spedizione Chiusura"),
                   new SPItem("COLDFILE","C",15,0, "hide","Precedente file spedizione chiusura"),
                   new SPItem("CDATARET","D",8,0, "hide","Data rettifica chiusura"),
                   new SPItem("CFESTERO","N",1,0, "hide","Codice Fiscale Estero"),
                   new SPItem("IDRIF","C",10,0, "hide",""),
                   new SPItem("NOCODFISC","C",1,0, "hide","No codice fiscale (Non assegnato agenzia entrate)"),
                   new SPItem("IDBASE","C",10,0, "hide","IDBASE"),
                   new SPItem("xragsoc","C",70,0, "show","Ragione Sociale"),
                   new SPItem("ADATA","D",8,0, "edit","Data Apertura"),
                   new SPItem("CDATA","D",8,0, "edit","Data Chiusura Rapporto"),
                   new SPItem("CPROWNUM","N",4,0, "hide","N° Riga"),
                   new SPItem("IDESITO","C",8,0, "show","ID ESITO"),
                   new SPItem("ADATARET","D",8,0, "edit","Data rettifica apertura"),
                   new SPItem("RSPEDITO","N",1,0, "edit","Rettifica Inviata"),
                   new SPItem("COLDFILE","C",15,0, "edit","Precedente file spedizione chiusura"),
                   new SPItem("COLDPROG","C",25,0, "edit","Precedente riferimento chiusura"),
                   new SPItem("IDBASE","C",10,0, "hide","IDBASE"),
                   new SPItem("dtcanc","D",8,0, "show",""),
                   new SPItem("spcanc","N",1,0, "show",""),
                   new SPItem("filecanc","C",15,0, "show",""),
                   new SPItem("idcanc","C",25,0, "show",""),
                   new SPItem("PROGAER","N",15,0, "hide","Progressivo Riga"),
                   new SPItem("DATESITO","D",8,0, "show","Data Generazione Esito"),
                   new SPItem("UNIQUECODE","C",50,0, "show","Codice Univo Rapporto"),
                   new SPItem("CAB","C",5,0, "edit","CAB"),
                   new SPItem("VALUTA","C",3,0, "edit","Valuta")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(2);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armd_anagrappoBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(2);
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
    {"10579329647",p_Context.Translate("Codice Univo Rapporto")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"1095110115",p_Context.Translate("Codice Intestatario")},
    {"109822566",p_Context.Translate("Valuta")},
    {"10991326470",p_Context.Translate("Precedente file spedizione chiusura")},
    {"10996202746",p_Context.Translate("Data Apertura")},
    {"11116236915",p_Context.Translate("File spedizione Chiusura")},
    {"11116511596",p_Context.Translate("Codice Rapporto")},
    {"11149805813",p_Context.Translate("Data Spedizione Chiusura")},
    {"11157094597",p_Context.Translate("Impossibile inserire (Dati storici)")},
    {"11261000588",p_Context.Translate("No codice fiscale (Non assegnato agenzia entrate)")},
    {"11446733597",p_Context.Translate("Trasmesso")},
    {"11446733611",p_Context.Translate("Trasmessa")},
    {"11551486958",p_Context.Translate("Riferimento Anagrafico")},
    {"11638313586",p_Context.Translate("Impossibile modificare (Dati storici)")},
    {"11741368204",p_Context.Translate("Confermi l'annullamento della rettifica/cancellazione ?")},
    {"11745066193",p_Context.Translate("Riferimento file spedizione")},
    {"11752966299",p_Context.Translate("Precedente riferimento chiusura")},
    {"1198480061",p_Context.Translate("Impossibile cancellare (Dati storici)")},
    {"12020423442",p_Context.Translate("Precedente progressivo spedizione")},
    {"1205724772",p_Context.Translate("Rettifica Inviata")},
    {"1223128201",p_Context.Translate("ID ESITO")},
    {"1264402456",p_Context.Translate("Data rettifica apertura")},
    {"1560126028",p_Context.Translate("La modifica comporta obbligo di ricomunicare i dati!! Vuoi proseguire ?")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"1742621518",p_Context.Translate("N° Riga")},
    {"1747631465",p_Context.Translate("Data Chiusura Rapporto")},
    {"18003",p_Context.Translate("CAB")},
    {"1801270096",p_Context.Translate("Data rettifica chiusura")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"2064983401",p_Context.Translate("Informazioni Rapporti per Agenzia delle Entrate (DDR 2007/9647)")},
    {"264260953",p_Context.Translate("Riferimento Spedizione Apertura")},
    {"348541329",p_Context.Translate("Apertura Spedita")},
    {"375560777",p_Context.Translate("Data Generazione Esito")},
    {"400950191",p_Context.Translate("Riferimento file vecchia spedizione")},
    {"665673017",p_Context.Translate("Progressivo Riga")},
    {"78075529",p_Context.Translate("IDBASE")},
    {"803225745",p_Context.Translate("Riferimento spedizione chiusura")},
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
  void WriteStyles(armd_anagrappoBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armd_anagrappo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armd_anagrappoBO BO,ServletStatus status) {
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
    status.out.println(
     "<div id='tabsContainer'>" +
     " " +
     "</div>" +
    "");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__url",status.m_cAltInterface);
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
      HTMLRowScript(BO,status);
      status.out.println(
       "<style>" +
      "");
      status.out.println(".ZWBKZJLHCV {top:0px;position:absolute;left:72px;height:16px;width:110px;background-color:Transparent;z-index:1; }");
      status.out.println(".ZWBKZJLHCV_ZOOM { position:absolute;top:0px;left:183px;height:17px;width:17px;background-color:Transparent;background-repeat:no-repeat;background-position:center;margin:0;border-width:0;padding:0;z-index:1;}");
      status.out.println(".ZYSXZRLIHG {top:0px;position:absolute;left:0px;height:16px;width:64px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".YQJXLYYDEK {top:0px;position:absolute;left:648px;height:16px;width:64px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".VCSXGLJKMU {top:0px;position:absolute;left:208px;height:16px;width:432px;background-color:Transparent;z-index:1; }");
      status.out.println(
       "</style>" +
      "");
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "<script>" +
    "");
    status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Aperture/Chiusure"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Saldi Annuali"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armd_anagrappo',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armd_anagrappo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armd_anagrappoBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,3);
  }
  void WriteControls_p1(armd_anagrappoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:579px;width:767px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteLayerExtendedRepeatedFields(BO.extendedFields_trs,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Aperture/Chiusure");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armd_anagrappoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:495px;width:767px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Saldi Annuali");
    PrintSidebarContent(2,status,getSidebarItems(1),false);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armd_anagrappoBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:579px'>" +
    "");
    status.out.println(
    "");
    status.out.println(
     "<div id='XDYFKZMJHC_DIV' class='UntitledBox'>" +
     "<div id='XDYFKZMJHC' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RAPPORTO' id='UOVJKJLZBV' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UBDRZPYJRT_DIV'>" +
     "<label id='UBDRZPYJRT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TIPOAG' id='GGLQTNYWZF' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VVKODWZEWZ_DIV'>" +
     "<label id='VVKODWZEWZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='COINT' id='BLOIDAPXRQ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_COINT))?"SELECTED":"")+">" +
     ""+status.context.Translate("Cointestato")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_COINT))?"SELECTED":"")+">" +
     ""+status.context.Translate("Non Cointestato")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('BLOIDAPXRQ'),w_COINT,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UGCBYIEUDJ_DIV'>" +
     "<label id='UGCBYIEUDJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DCTZJXUJAS_DIV'>" +
     "<label id='DCTZJXUJAS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Intestatario"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ODIDTFEFFZ_DIV'>" +
     "<label id='ODIDTFEFFZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Apertura"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ORBYBKHYQK_DIV'>" +
     "<label id='ORBYBKHYQK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Chiusura"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PXDMJWSUND_DIV'>" +
     "<label id='PXDMJWSUND'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Inizio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZERFIEYGRR_DIV'>" +
     "<label id='ZERFIEYGRR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JMAPGZEWUL_DIV'>" +
     "<label id='JMAPGZEWUL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento Spedizione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OZYRKTIKPF_DIV'>" +
     "<label id='OZYRKTIKPF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VBDRLFPBBZ_DIV'>" +
     "<label id='VBDRLFPBBZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AIGHLABXVU_DIV'>" +
     "<label id='AIGHLABXVU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento Spedizione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='KLSWWEOHOR_DIV' class='UntitledBox'>" +
     "<div id='KLSWWEOHOR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='BJDGPHQYFI_DIV' class='UntitledBox'>" +
     "<div id='BJDGPHQYFI' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HXAIQPNTTR_DIV'>" +
     "<label id='HXAIQPNTTR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("APERTURA DEL RAPPORTO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BSRYSFCEAT_DIV'>" +
     "<label id='BSRYSFCEAT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CHIUSURA DEL RAPPORTO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='GCHWZOBGPB' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Rettifica Comunicazioni Inviate"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='NALNSNTYAI' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Cancellazione comunicazioni inviate"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='HWWOJAYWAI' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Apre Anagrafica"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TTPYWGQBMJ_DIV'>" +
     "<label id='TTPYWGQBMJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rettifica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IYPZKVMVKZ_DIV'>" +
     "<label id='IYPZKVMVKZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KDPEUBXAAZ_DIV'>" +
     "<label id='KDPEUBXAAZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento Spedizione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='WNPHGDFVJX_DIV' class='UntitledBox'>" +
     "<div id='WNPHGDFVJX' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PLNXDEJCTD_DIV'>" +
     "<label id='PLNXDEJCTD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("RETTIFICA DEL RAPPORTO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='RANZSHNOJF_DIV' class='UntitledBox'>" +
     "<div id='RANZSHNOJF' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PHHCOECSMM_DIV'>" +
     "<label id='PHHCOECSMM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CANCELLAZIONE DEL RAPPORTO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RETYYQHGRS_DIV'>" +
     "<label id='RETYYQHGRS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cancellazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IMTYCPFWNU_DIV'>" +
     "<label id='IMTYCPFWNU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FRZVZSKKXF_DIV'>" +
     "<label id='FRZVZSKKXF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Riferimento Spedizione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UDPOLEMYNZ_DIV' style='display:none'>" +
     "<label id='UDPOLEMYNZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("OPERAZIONE\nCANCELLATA"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='RHOMZTFXOQ' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Annulla Rettifica"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.out.println(
     "<div id='UBHZWYZYEF_DIV' class='TitledBox'>" +
     "<span id='UBHZWYZYEF_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Dati Esito Agenzia Entrate")+"</span>" +
     "<div id='UBHZWYZYEF'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MMLVTODRRS_DIV'>" +
     "<label id='MMLVTODRRS' for='IANSHYURPV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID ESITO:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JUCNEACWKX_DIV'>" +
     "<label id='JUCNEACWKX' for='YJETHTLSAS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Generazione Esito:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='GridTable_Container' style='position:absolute;top:88px;left:14px;height:150px;width:734px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
     "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:150px;width:734px;overflow:scroll'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:734px;height:150px;overflow:auto;'>" +
     "<table id='GridTable' style='position:relative;top:0px;left:0px;width:728px' cellspacing='0' cellpadding='0' border='0'>" +
     "<tr>" +
     "<td></td>" +
     "</tr>" +
     "</table>" +
     "</div>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<div id='GridTable_ButtonPanel' style='position:absolute;top:0px;left:16px;z-index:4'>" +
       ""+printButtonPanelContent(status,1,"lower_right",false,getDetailMenuItems(),false,"")+"" +
       "</div>" +
      "");
    }
    status.out.println(
     "<div class='GridTable_VerticalLines' style='position:absolute;top:88px;left:84px;height:150px;width:1px'>" +
     "</div>" +
    "");
    status.out.println(
     "<div class='GridTable_VerticalLines' style='position:absolute;top:88px;left:220px;height:150px;width:1px'>" +
     "</div>" +
    "");
    status.out.println(
     "<div class='GridTable_VerticalLines' style='position:absolute;top:88px;left:660px;height:150px;width:1px'>" +
     "</div>" +
    "");
    HTMLRowScript(BO,status);
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='VKTPGVCBJR_DIV'>" +
     "<input name='ASPEDITO' id='VKTPGVCBJR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ASPEDITO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" "+(CPLib.eq(1,BO.w_ASPEDITO)?"CHECKED":"")+">" +
     "<label id='VKTPGVCBJR_LBL' for='VKTPGVCBJR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmessa"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='APROG' id='SQFHVLZLRL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_APROG,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AFILE' id='CCYVNDNRFK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AFILE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GZYOVGKBQU_DIV'>" +
     "<input name='CSPEDITO' id='GZYOVGKBQU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CSPEDITO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" "+(CPLib.eq(1,BO.w_CSPEDITO)?"CHECKED":"")+">" +
     "<label id='GZYOVGKBQU_LBL' for='GZYOVGKBQU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmesso"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPROG' id='RPTFBMPRFK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPROG,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CFILE' id='GEAGHOYNJV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CFILE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADATA' id='KGVKWENSDZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADATA,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CDATA' id='UJYQWLUHMX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CDATA,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<input name='IDESITO' id='IANSHYURPV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IDESITO,"C",8,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='8' size='8' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADATARET' id='LJUMSXSYFZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADATARET,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ZEWCJCWNSV_DIV'>" +
     "<input name='RSPEDITO' id='ZEWCJCWNSV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_RSPEDITO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" "+(CPLib.eq(1,BO.w_RSPEDITO)?"CHECKED":"")+">" +
     "<label id='ZEWCJCWNSV_LBL' for='ZEWCJCWNSV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmessa"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='COLDFILE' id='YYRSSVEWOX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COLDFILE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='COLDPROG' id='FDSYVBCPAC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COLDPROG,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='dtcanc' id='CGGFGFHNLQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_dtcanc,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span id='PULJPVPYAY_DIV'>" +
     "<input name='spcanc' id='PULJPVPYAY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_spcanc,"N",1,0,"", status.m_oRegSettings)+" disabled "+(CPLib.eq(1,BO.w_spcanc)?"CHECKED":"")+">" +
     "<label id='PULJPVPYAY_LBL' for='PULJPVPYAY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trasmessa"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='filecanc' id='CPXILLMFYQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_filecanc,"C",15,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='idcanc' id='MQSDKNMJUI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_idcanc,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='DATESITO' id='YJETHTLSAS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATESITO,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
    "");
    AddExtendedRepeatedFieldsButton(BO.extendedFields_trs,status,744,89);
    status.m_nTabIndex = status.m_nTabIndex+1;
    status.out.println(
     "</div>" +
    "");
  }
  void HTMLRowScript(armd_anagrappoBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:712px;height:17px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_CONNESINT;");
    status.out.println("var w_ASPEDITO;");
    status.out.println("var w_ADATA;");
    status.out.println("var w_APROG;");
    status.out.println("var w_AOLDPROG;");
    status.out.println("var w_AFILE;");
    status.out.println("var w_AOLDFILE;");
    status.out.println("var w_ADATARET;");
    status.out.println("var w_CSPEDITO;");
    status.out.println("var w_CDATA;");
    status.out.println("var w_CPROG;");
    status.out.println("var w_COLDPROG;");
    status.out.println("var w_CFILE;");
    status.out.println("var w_COLDFILE;");
    status.out.println("var w_CDATARET;");
    status.out.println("var w_IDRIF;");
    status.out.println("var w_NOCODFISC;");
    status.out.println("var w_IDBASE;");
    status.out.println("var w_CPROWNUM;");
    status.out.println("var w_IDESITO;");
    status.out.println("var w_RSPEDITO;");
    status.out.println("var w_PROGAER;");
    status.out.println("var w_DATESITO;");
    status.out.println("var w_CFESTERO;");
    status.out.println("var w_xragsoc;");
    status.out.println("var w_dtcanc;");
    status.out.println("var w_spcanc;");
    status.out.println("var w_filecanc;");
    status.out.println("var w_idcanc;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_CONNESINT=row[prefix+'CONNESINT'];");
    status.out.println("w_ASPEDITO=row[prefix+'ASPEDITO'];");
    status.out.println("w_ADATA=row[prefix+'ADATA'];");
    status.out.println("w_APROG=row[prefix+'APROG'];");
    status.out.println("w_AOLDPROG=row[prefix+'AOLDPROG'];");
    status.out.println("w_AFILE=row[prefix+'AFILE'];");
    status.out.println("w_AOLDFILE=row[prefix+'AOLDFILE'];");
    status.out.println("w_ADATARET=row[prefix+'ADATARET'];");
    status.out.println("w_CSPEDITO=row[prefix+'CSPEDITO'];");
    status.out.println("w_CDATA=row[prefix+'CDATA'];");
    status.out.println("w_CPROG=row[prefix+'CPROG'];");
    status.out.println("w_COLDPROG=row[prefix+'COLDPROG'];");
    status.out.println("w_CFILE=row[prefix+'CFILE'];");
    status.out.println("w_COLDFILE=row[prefix+'COLDFILE'];");
    status.out.println("w_CDATARET=row[prefix+'CDATARET'];");
    status.out.println("w_IDRIF=row[prefix+'IDRIF'];");
    status.out.println("w_NOCODFISC=row[prefix+'NOCODFISC'];");
    status.out.println("w_IDBASE=row[prefix+'IDBASE'];");
    status.out.println("w_CPROWNUM=row[prefix+'CPROWNUM'];");
    status.out.println("w_IDESITO=row[prefix+'IDESITO'];");
    status.out.println("w_RSPEDITO=row[prefix+'RSPEDITO'];");
    status.out.println("w_PROGAER=row[prefix+'PROGAER'];");
    status.out.println("w_DATESITO=row[prefix+'DATESITO'];");
    status.out.println("w_CFESTERO=row[prefix+'CFESTERO'];");
    status.out.println("w_xragsoc=row[prefix+'xragsoc'];");
    status.out.println("w_dtcanc=row[prefix+'dtcanc'];");
    status.out.println("w_spcanc=row[prefix+'spcanc'];");
    status.out.println("w_filecanc=row[prefix+'filecanc'];");
    status.out.println("w_idcanc=row[prefix+'idcanc'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='CONNESINT' id='ZWBKZJLHCV' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_CONNESINT),'C',16,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='16' size='16' fieldtype='C'>" +
     "<button id='ZWBKZJLHCV_ZOOM' type='button' class='GridZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='ADATA' id='ZYSXZRLIHG' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='CDATA' id='YQJXLYYDEK' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "\"");
    status.out.println("s=s+\""+
     "<input name='xragsoc' id='VCSXGLJKMU' type='text' class='Field Disabled GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_xragsoc),'C',70,0,'')+\"' tabindex='-1' readonly maxlength='70' size='70' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(13);
    status.m_nTabIndex = status.m_nTabIndex+((CPLib.gt(BO.extendedFields_trs.length,0)?1:0));
    status.m_nAfterDetailElementTabIndex = status.m_nTabIndex;
    status.out.println("s=s+\""+
     "<input name='AfterDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(-13);
    status.m_nTabIndex = status.m_nTabIndex-((CPLib.gt(BO.extendedFields_trs.length,0)?1:0));
    status.out.println("} else {");
    status.out.println("if ( ! (IsHiddenByStateDriver('CONNESINT'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem ZWBKZJLHCV' value='\"+WtH(ToHTML(w_CONNESINT),'C',16,0,'')+\"' tabindex='-1' readonly size='16'>" +
     "<button type='button' class='ZWBKZJLHCV_ZOOM GridZoomButtonEnabled' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" disabled class='ZWBKZJLHCV_ZOOM GridZoomButtonEnabled'>" +
     "</button>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('ADATA'))) {");
    status.out.println("s=s+\""+
     "<input type='"+(SPLib.IsMobile(status.request)?"date":"text")+"' class='Field Disabled GridTable_QueryRowItem ZYSXZRLIHG' value='\"+WtH(w_ADATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='-1' readonly size='8'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('CDATA'))) {");
    status.out.println("s=s+\""+
     "<input type='"+(SPLib.IsMobile(status.request)?"date":"text")+"' class='Field Disabled GridTable_QueryRowItem YQJXLYYDEK' value='\"+WtH(w_CDATA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='-1' readonly size='8'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('xragsoc'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled Disabled GridTable_QueryRowItem VCSXGLJKMU' value='\"+WtH(ToHTML(w_xragsoc),'C',70,0,'')+\"' tabindex='-1' readonly size='70'>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:712px;height:17px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b0(armd_anagrappoBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:495px'>" +
    "");
    status.out.println(
     "<div id='TGJYPNQVEJ_DIV' class='UntitledBox'>" +
     "<div id='TGJYPNQVEJ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_ae_saldianno_rap' id='KGHSUPPYWT' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "<input name='UNIQUECODE' id='LTLFYOYQAO' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_UNIQUECODE,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JXLGEAUZTQ_DIV'>" +
     "<label id='JXLGEAUZTQ' for='LTLFYOYQAO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Univo Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CAB' id='CODMGYDXYT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAB,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FRUUOBVPDA_DIV'>" +
     "<label id='FRUUOBVPDA' for='CODMGYDXYT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='VALUTA' id='AKLWIUMNVR' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KSMLUMFLML_DIV'>" +
     "<label id='KSMLUMFLML' for='AKLWIUMNVR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valuta:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armd_anagrappoBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armd_anagrappoBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_ae_saldianno_rap.IsUpdated()) {
      BO.m_cWv_ardt_ae_saldianno_rap = BO.ardt_ae_saldianno_rap.GetContext();
    }
  }
  static void PrintStateWorkVars(armd_anagrappoBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOAG,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COINT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIFANA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESINT,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASPEDITO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADATA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_APROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AOLDPROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AOLDFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADATARET,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CSPEDITO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLDPROG,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLDFILE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATARET,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDRIF,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOCODFISC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPROWNUM,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDESITO,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RSPEDITO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_UNIQUECODE,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAB,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROGAER,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PROGAER:BO.w_PROGAER,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROGAET,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PROGAET:BO.w_PROGAET,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATESITO,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsoc,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dtcanc,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_spcanc,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_filecanc,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcanc,"C",25,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_ae_saldianno_rap,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_ae_saldianno_rap");
    } else if (CPLib.eq(BO.m_cWv_ardt_ae_saldianno_rap,"_not_empty_")) {
      BO.m_cWv_ardt_ae_saldianno_rap = BO.ardt_ae_saldianno_rap.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_saldianno_rap,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_saldianno_rap,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(armd_anagrappoBL BO,ServletStatus status) {
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
      status.out.print(""+SPLib.ToJSValue(BO.w_CONNESINT,"C",16,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_ASPEDITO,"N",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_ADATA,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_APROG,"C",25,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_AOLDPROG,"C",25,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_AFILE,"C",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_AOLDFILE,"C",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_ADATARET,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CSPEDITO,"N",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CDATA,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CPROG,"C",25,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_COLDPROG,"C",25,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CFILE,"C",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_COLDFILE,"C",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CDATARET,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDRIF,"C",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_NOCODFISC,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_xragsoc,"C",70,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_ADATA,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CDATA,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CPROWNUM,"N",4,0)+",");
      if ( ! (l_bForceSelect) && CPLib.eq(l_nSelectRow,k) && ( ! (status.source.Has("CPROWNUM")) || CPLib.ne(BO.w_CPROWNUM,status.source.GetParameter("CPROWNUM",0)))) {
        l_nSelectRow = -1;
      }
      status.out.print(""+SPLib.ToJSValue(BO.w_IDESITO,"C",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_ADATARET,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_RSPEDITO,"N",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_COLDFILE,"C",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_COLDPROG,"C",25,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_dtcanc,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_spcanc,"N",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_filecanc,"C",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_idcanc,"C",25,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_PROGAER,"N",15,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DATESITO,"D",8,0)+",");
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
      for ( l = 0; CPLib.lt(l,BO.work_extended.length); l = l + (1)) {
        status.out.print(","+SPLib.ToJSValue(BO.work_extended[l].GetValue(),"C",0,0)+"");
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
  static void PrintStateDetailWorkVars_Deleted(armd_anagrappoBL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      armd_anagrappoBO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (armd_anagrappoBO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CONNESINT,"C",16,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_ASPEDITO,"N",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_ADATA,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_APROG,"C",25,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_AOLDPROG,"C",25,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_AFILE,"C",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_AOLDFILE,"C",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_ADATARET,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CSPEDITO,"N",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CDATA,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CPROG,"C",25,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_COLDPROG,"C",25,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CFILE,"C",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_COLDFILE,"C",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CDATARET,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CFESTERO,"N",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDRIF,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_NOCODFISC,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDBASE,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_xragsoc,"C",70,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_ADATA,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CDATA,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CPROWNUM,"N",4,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDESITO,"C",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_ADATARET,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_RSPEDITO,"N",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_COLDFILE,"C",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_COLDPROG,"C",25,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDBASE,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_dtcanc,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_spcanc,"N",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_filecanc,"C",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_idcanc,"C",25,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PROGAER,"N",15,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DATESITO,"D",8,0)+",";
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
        for ( l = 0; CPLib.lt(l,l_Row.work_extended.length); l = l + (1)) {
          l_cTrs = l_cTrs+","+SPLib.ToJSValue(l_Row.work_extended[l].GetValue(),"C",0,0);
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
  void WriteMainFormVarScript(armd_anagrappoBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(579,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(767,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armd_anagrappo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'ZWBKZJLHCV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZWBKZJLHCV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'NQPTOOEBKN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NQPTOOEBKN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,aecanc,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'ZWBKZJLHCV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'NQPTOOEBKN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,aecanc,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armd_anagrappo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armd_anagrappo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_XDYFKZMJHC"),"")) {
      status.quoteAndAppend("box_XDYFKZMJHC","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_KLSWWEOHOR"),"")) {
      status.quoteAndAppend("box_KLSWWEOHOR","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_BJDGPHQYFI"),"")) {
      status.quoteAndAppend("box_BJDGPHQYFI","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_WNPHGDFVJX"),"")) {
      status.quoteAndAppend("box_WNPHGDFVJX","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_RANZSHNOJF"),"")) {
      status.quoteAndAppend("box_RANZSHNOJF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_UBHZWYZYEF"),"")) {
      status.quoteAndAppend("box_UBHZWYZYEF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_TGJYPNQVEJ"),"")) {
      status.quoteAndAppend("box_TGJYPNQVEJ","hide","box");
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
    status.out.println("var m_bAlternateColorRows = " + SPLib.ToJSValue(true,"L",0,0)+ ";");
    status.out.println("function TrsRow() {");
    status.out.println("if (Eq(arguments.length,1)) {");
    status.out.println("this.CONNESINT=w_CONNESINT;");
    status.out.println("this.ASPEDITO=w_ASPEDITO;");
    status.out.println("this.ADATA=w_ADATA;");
    status.out.println("this.APROG=w_APROG;");
    status.out.println("this.AOLDPROG=w_AOLDPROG;");
    status.out.println("this.AFILE=w_AFILE;");
    status.out.println("this.AOLDFILE=w_AOLDFILE;");
    status.out.println("this.ADATARET=w_ADATARET;");
    status.out.println("this.CSPEDITO=w_CSPEDITO;");
    status.out.println("this.CDATA=w_CDATA;");
    status.out.println("this.CPROG=w_CPROG;");
    status.out.println("this.COLDPROG=w_COLDPROG;");
    status.out.println("this.CFILE=w_CFILE;");
    status.out.println("this.COLDFILE=w_COLDFILE;");
    status.out.println("this.CDATARET=w_CDATARET;");
    status.out.println("this.CFESTERO=w_CFESTERO;");
    status.out.println("this.IDRIF=w_IDRIF;");
    status.out.println("this.NOCODFISC=w_NOCODFISC;");
    status.out.println("this.IDBASE=w_IDBASE;");
    status.out.println("this.xragsoc=w_xragsoc;");
    status.out.println("this.ADATA=w_ADATA;");
    status.out.println("this.CDATA=w_CDATA;");
    status.out.println("this.CPROWNUM=w_CPROWNUM;");
    status.out.println("this.IDESITO=w_IDESITO;");
    status.out.println("this.ADATARET=w_ADATARET;");
    status.out.println("this.RSPEDITO=w_RSPEDITO;");
    status.out.println("this.COLDFILE=w_COLDFILE;");
    status.out.println("this.COLDPROG=w_COLDPROG;");
    status.out.println("this.IDBASE=w_IDBASE;");
    status.out.println("this.dtcanc=w_dtcanc;");
    status.out.println("this.spcanc=w_spcanc;");
    status.out.println("this.filecanc=w_filecanc;");
    status.out.println("this.idcanc=w_idcanc;");
    status.out.println("this.PROGAER=w_PROGAER;");
    status.out.println("this.DATESITO=w_DATESITO;");
    status.out.println("this.m_nRowStatus=arguments[0];");
    status.out.println("this.m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;");
    int l;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
      }
    }
    for ( l = 0; CPLib.lt(l,BO.extendedFields_trs.length); l = l + (1)) {
      XDCFieldValue l_oField = BO.extendedFields_trs[l];
      status.out.println("this."+l_oField.GetLogicalName()+"=w_"+l_oField.GetLogicalName()+";");
    }
    status.out.println("} else {");
    status.out.println("this.CONNESINT=arguments[0];");
    status.out.println("this.ASPEDITO=arguments[1];");
    status.out.println("this.ADATA=arguments[2];");
    status.out.println("this.APROG=arguments[3];");
    status.out.println("this.AOLDPROG=arguments[4];");
    status.out.println("this.AFILE=arguments[5];");
    status.out.println("this.AOLDFILE=arguments[6];");
    status.out.println("this.ADATARET=arguments[7];");
    status.out.println("this.CSPEDITO=arguments[8];");
    status.out.println("this.CDATA=arguments[9];");
    status.out.println("this.CPROG=arguments[10];");
    status.out.println("this.COLDPROG=arguments[11];");
    status.out.println("this.CFILE=arguments[12];");
    status.out.println("this.COLDFILE=arguments[13];");
    status.out.println("this.CDATARET=arguments[14];");
    status.out.println("this.CFESTERO=arguments[15];");
    status.out.println("this.IDRIF=arguments[16];");
    status.out.println("this.NOCODFISC=arguments[17];");
    status.out.println("this.IDBASE=arguments[18];");
    status.out.println("this.xragsoc=arguments[19];");
    status.out.println("this.ADATA=arguments[20];");
    status.out.println("this.CDATA=arguments[21];");
    status.out.println("this.CPROWNUM=arguments[22];");
    status.out.println("this.IDESITO=arguments[23];");
    status.out.println("this.ADATARET=arguments[24];");
    status.out.println("this.RSPEDITO=arguments[25];");
    status.out.println("this.COLDFILE=arguments[26];");
    status.out.println("this.COLDPROG=arguments[27];");
    status.out.println("this.IDBASE=arguments[28];");
    status.out.println("this.dtcanc=arguments[29];");
    status.out.println("this.spcanc=arguments[30];");
    status.out.println("this.filecanc=arguments[31];");
    status.out.println("this.idcanc=arguments[32];");
    status.out.println("this.PROGAER=arguments[33];");
    status.out.println("this.DATESITO=arguments[34];");
    status.out.println("this.m_nRowStatus=arguments[35];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[36];");
    int lastRow;
    lastRow = 37;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=arguments["+(lastRow+l)+"];");
      }
    }
    lastRow = lastRow+BO.m_MNTs.length;
    for ( l = 0; CPLib.lt(l,BO.extendedFields_trs.length); l = l + (1)) {
      XDCFieldValue l_oField = BO.extendedFields_trs[l];
      status.out.println("this."+l_oField.GetLogicalName()+"=arguments["+(lastRow+l)+"];");
    }
    status.out.println("}");
    status.out.println("}");
    status.out.println("function TrsToWork() {");
    status.out.println("var row;");
    status.out.println("row=m_oTrs[m_nCurrentRow];");
    status.out.println("if (Ne(row,null)) {");
    status.out.println("w_CONNESINT=row.CONNESINT;");
    status.out.println("w_ASPEDITO=row.ASPEDITO;");
    status.out.println("w_ADATA=row.ADATA;");
    status.out.println("w_APROG=row.APROG;");
    status.out.println("w_AOLDPROG=row.AOLDPROG;");
    status.out.println("w_AFILE=row.AFILE;");
    status.out.println("w_AOLDFILE=row.AOLDFILE;");
    status.out.println("w_ADATARET=row.ADATARET;");
    status.out.println("w_CSPEDITO=row.CSPEDITO;");
    status.out.println("w_CDATA=row.CDATA;");
    status.out.println("w_CPROG=row.CPROG;");
    status.out.println("w_COLDPROG=row.COLDPROG;");
    status.out.println("w_CFILE=row.CFILE;");
    status.out.println("w_COLDFILE=row.COLDFILE;");
    status.out.println("w_CDATARET=row.CDATARET;");
    status.out.println("w_CFESTERO=row.CFESTERO;");
    status.out.println("w_IDRIF=row.IDRIF;");
    status.out.println("w_NOCODFISC=row.NOCODFISC;");
    status.out.println("w_IDBASE=row.IDBASE;");
    status.out.println("w_xragsoc=row.xragsoc;");
    status.out.println("w_ADATA=row.ADATA;");
    status.out.println("w_CDATA=row.CDATA;");
    status.out.println("w_CPROWNUM=row.CPROWNUM;");
    status.out.println("w_IDESITO=row.IDESITO;");
    status.out.println("w_ADATARET=row.ADATARET;");
    status.out.println("w_RSPEDITO=row.RSPEDITO;");
    status.out.println("w_COLDFILE=row.COLDFILE;");
    status.out.println("w_COLDPROG=row.COLDPROG;");
    status.out.println("w_IDBASE=row.IDBASE;");
    status.out.println("w_dtcanc=row.dtcanc;");
    status.out.println("w_spcanc=row.spcanc;");
    status.out.println("w_filecanc=row.filecanc;");
    status.out.println("w_idcanc=row.idcanc;");
    status.out.println("w_PROGAER=row.PROGAER;");
    status.out.println("w_DATESITO=row.DATESITO;");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("m_nRowStatus=row.m_nRowStatus;");
      status.out.println("m_cOldRowCPCCCHK=row.m_cOldRowCPCCCHK;");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"=row.m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
        }
      }
      for ( l = 0; CPLib.lt(l,BO.extendedFields_trs.length); l = l + (1)) {
        XDCFieldValue l_oField = BO.extendedFields_trs[l];
        status.out.println("w_"+l_oField.GetLogicalName()+"=row."+l_oField.GetLogicalName()+";");
      }
      status.out.println("} else {");
      status.out.println("w_CONNESINT='';");
      status.out.println("w_ASPEDITO=0;");
      status.out.println("w_ADATA=NullDate();");
      status.out.println("w_APROG='';");
      status.out.println("w_AOLDPROG='';");
      status.out.println("w_AFILE='';");
      status.out.println("w_AOLDFILE='';");
      status.out.println("w_ADATARET=NullDate();");
      status.out.println("w_CSPEDITO=0;");
      status.out.println("w_CDATA=NullDate();");
      status.out.println("w_CPROG='';");
      status.out.println("w_COLDPROG='';");
      status.out.println("w_CFILE='';");
      status.out.println("w_COLDFILE='';");
      status.out.println("w_CDATARET=NullDate();");
      status.out.println("w_CFESTERO=0;");
      status.out.println("w_IDRIF='';");
      status.out.println("w_NOCODFISC=(Eq(w_CFESTERO,1)?'S':'N');");
      status.out.println("w_IDBASE='';");
      status.out.println("w_xragsoc='';");
      status.out.println("w_ADATA=NullDate();");
      status.out.println("w_CDATA=NullDate();");
      status.out.println("w_CPROWNUM=0;");
      status.out.println("w_IDESITO='';");
      status.out.println("w_ADATARET=NullDate();");
      status.out.println("w_RSPEDITO=0;");
      status.out.println("w_COLDFILE='';");
      status.out.println("w_COLDPROG='';");
      status.out.println("w_IDBASE='';");
      status.out.println("w_dtcanc=NullDate();");
      status.out.println("w_spcanc=0;");
      status.out.println("w_filecanc='';");
      status.out.println("w_idcanc='';");
      status.out.println("w_PROGAER=0;");
      status.out.println("w_DATESITO=NullDate();");
      status.out.println("m_nRowStatus=2;");
      status.out.println("m_cOldRowCPCCCHK='';");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"='';");
        }
      }
      for ( l = 0; CPLib.lt(l,BO.extendedFields_trs.length); l = l + (1)) {
        XDCFieldValue l_oField = BO.extendedFields_trs[l];
        status.out.println("w_"+l_oField.GetLogicalName()+"=GetBlankValue('"+l_oField.GetType()+"');");
      }
    }
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query") && CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("SaveDependsOn();");
      status.out.println("SaveLabelDependsOn();");
    }
    status.out.println("}");
    status.out.println("_GridRowHeight='17';");
    status.out.println("CPRowNumName='w_CPROWNUM';");
    WriteExtendedFieldsVars(BO.extendedFields,BO.extendedFields_trs,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(armd_anagrappoBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armd_anagrappo',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('UOVJKJLZBV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GGLQTNYWZF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BLOIDAPXRQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VKTPGVCBJR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SQFHVLZLRL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CCYVNDNRFK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GZYOVGKBQU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RPTFBMPRFK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GEAGHOYNJV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KGVKWENSDZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UJYQWLUHMX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LJUMSXSYFZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZEWCJCWNSV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YYRSSVEWOX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FDSYVBCPAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CODMGYDXYT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AKLWIUMNVR')) SetDisabled(c,true);");
      } else if (( ! (CPLib.Empty(status.m_cAltInterface))) && CPLib.eq(status.m_cClientMode,"query")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('ZWBKZJLHCV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZWBKZJLHCV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VKTPGVCBJR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZYSXZRLIHG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SQFHVLZLRL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CCYVNDNRFK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GZYOVGKBQU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YQJXLYYDEK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RPTFBMPRFK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GEAGHOYNJV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VCSXGLJKMU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KGVKWENSDZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UJYQWLUHMX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IANSHYURPV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LJUMSXSYFZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZEWCJCWNSV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YYRSSVEWOX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FDSYVBCPAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CGGFGFHNLQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PULJPVPYAY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CPXILLMFYQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MQSDKNMJUI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YJETHTLSAS')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('KGHSUPPYWT')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('KGHSUPPYWT',linkpc_url('KGHSUPPYWT'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('UOVJKJLZBV')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
    status.out.println("LoadContext(true);");
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
    status.out.println("if (Eq(name,'ardt_ae_saldianno_rap')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_ae_saldianno_rap")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'PROGAET') || Empty(p_uid)) {");
      status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      status.out.println("var l_b1 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'PROGAER') || Empty(p_uid)) {");
      status.out.println("l_b1= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      status.out.println("if (l_b0) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PROGAET','PROGAET');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PROGAET',w_PROGAET,op_PROGAET,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('aetesta');");
      status.out.println("w_PROGAET=AutonumberApplet().GetAutonumberDouble('PROGAET');");
      status.out.println("}");
      status.out.println("if (l_b1) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PROGAER','PROGAER');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PROGAER',w_PROGAER,op_PROGAER,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('aetesta');");
      status.out.println("w_PROGAER=AutonumberApplet().GetAutonumberDouble('PROGAER');");
      status.out.println("}");
      status.out.println("if (l_b0) {");
      status.out.println("op_codazi=m_cCompany;");
      status.out.println("op_PROGAET=w_PROGAET;");
      status.out.println("}");
      status.out.println("if (l_b1) {");
      status.out.println("op_PROGAER=w_PROGAER;");
      status.out.println("}");
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
  armd_anagrappoBO getBO(ServletStatus status) {
    armd_anagrappoBO BO = new armd_anagrappoBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_PROGAER = BO.w_PROGAER;
    BO.op_PROGAET = BO.w_PROGAET;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armd_anagrappoBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("aetesta",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
    t = xdc.GetXDCTable("aerighe",true);
    BO.extendedFields_trs = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armd_anagrappoBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armd_anagrappoBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbrapp,CPSql.BuildSQLPhrase("CODICE,DESCRI",BO.m_cPhName_tbrapp,"",""));
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
    status.out.println("var GGLQTNYWZF_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbvalute,CPSql.BuildSQLPhrase("CODVAL,DESCRI",BO.m_cPhName_tbvalute,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODVAL"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var AKLWIUMNVR_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armd_anagrappoBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_aetesta;
    String l_cPhName = BO.m_cPhName_aetesta;
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
      String l_cQueryFilter = armd_anagrappoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_aetesta+".RAPPORTO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("aetesta");
    String l_cPhName = CPSql.ManipulateTablePhName("aetesta",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".RAPPORTO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armd_anagrappoBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armd_anagrappoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_aetesta,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_aetesta,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armd_anagrappoBO BO) {
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
  void Edit(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_CONNESINT = "";
        BO.w_ASPEDITO = 0;
        BO.w_ADATA = CPLib.NullDate();
        BO.w_APROG = "";
        BO.w_AOLDPROG = "";
        BO.w_AFILE = "";
        BO.w_AOLDFILE = "";
        BO.w_ADATARET = CPLib.NullDate();
        BO.w_CSPEDITO = 0;
        BO.w_CDATA = CPLib.NullDate();
        BO.w_CPROG = "";
        BO.w_COLDPROG = "";
        BO.w_CFILE = "";
        BO.w_COLDFILE = "";
        BO.w_CDATARET = CPLib.NullDate();
        BO.w_CFESTERO = 0;
        BO.w_IDRIF = "";
        BO.w_NOCODFISC = "";
        BO.w_IDBASE = "";
        BO.w_xragsoc = "";
        BO.w_ADATA = CPLib.NullDate();
        BO.w_CDATA = CPLib.NullDate();
        BO.w_CPROWNUM = 0;
        BO.w_IDESITO = "";
        BO.w_ADATARET = CPLib.NullDate();
        BO.w_RSPEDITO = 0;
        BO.w_COLDFILE = "";
        BO.w_COLDPROG = "";
        BO.w_IDBASE = "";
        BO.w_dtcanc = CPLib.NullDate();
        BO.w_spcanc = 0;
        BO.w_filecanc = "";
        BO.w_idcanc = "";
        BO.w_PROGAER = 0;
        BO.w_DATESITO = CPLib.NullDate();
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
  void New(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armd_anagrappoBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_RAPPORTO = "";
      } else {
        BO.w_RAPPORTO = l_rsKeys.GetString("RAPPORTO");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_RAPPORTO = BO.w_RAPPORTO;
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_CONNESINT = "";
          BO.w_ASPEDITO = 0;
          BO.w_ADATA = CPLib.NullDate();
          BO.w_APROG = "";
          BO.w_AOLDPROG = "";
          BO.w_AFILE = "";
          BO.w_AOLDFILE = "";
          BO.w_ADATARET = CPLib.NullDate();
          BO.w_CSPEDITO = 0;
          BO.w_CDATA = CPLib.NullDate();
          BO.w_CPROG = "";
          BO.w_COLDPROG = "";
          BO.w_CFILE = "";
          BO.w_COLDFILE = "";
          BO.w_CDATARET = CPLib.NullDate();
          BO.w_CFESTERO = 0;
          BO.w_IDRIF = "";
          BO.w_NOCODFISC = "";
          BO.w_IDBASE = "";
          BO.w_xragsoc = "";
          BO.w_ADATA = CPLib.NullDate();
          BO.w_CDATA = CPLib.NullDate();
          BO.w_CPROWNUM = 0;
          BO.w_IDESITO = "";
          BO.w_ADATARET = CPLib.NullDate();
          BO.w_RSPEDITO = 0;
          BO.w_COLDFILE = "";
          BO.w_COLDPROG = "";
          BO.w_IDBASE = "";
          BO.w_dtcanc = CPLib.NullDate();
          BO.w_spcanc = 0;
          BO.w_filecanc = "";
          BO.w_idcanc = "";
          BO.w_PROGAER = 0;
          BO.w_DATESITO = CPLib.NullDate();
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
  void EditLoad(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_RAPPORTO);
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
  void DeleteMessage(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armd_anagrappoBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    double l_old_PROGAER = 0;
    if (CPLib.ne(BO.w_PROGAER,BO.op_PROGAER)) {
      l_old_PROGAER = BO.op_PROGAER;
    }
    double l_old_PROGAET = 0;
    if (CPLib.ne(BO.w_PROGAET,BO.op_PROGAET)) {
      l_old_PROGAET = BO.op_PROGAET;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_PROGAER))) {
        BO.op_PROGAER = l_old_PROGAER;
      }
      if ( ! (CPLib.Empty(l_old_PROGAET))) {
        BO.op_PROGAET = l_old_PROGAET;
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
  void Discard(ServletStatus status,armd_anagrappoBO BO) {
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
  void CreatePortlet(ServletStatus status,armd_anagrappoBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",579);
    item.put("w",767);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Aperture\\/Chiusure\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Saldi Annuali\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Aperture/Chiusure,Saldi Annuali");
    item.put("altInterfaceFor","armd_anagrappo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XDYFKZMJHC\",\"h\":567,\"name\":\"box_XDYFKZMJHC\",\"page\":1,\"shrinkable\":true,\"spuid\":\"XDYFKZMJHC\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Rapporto\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"spuid\":\"UOVJKJLZBV\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":104,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Rapporto\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOAG\",\"page\":1,\"spuid\":\"GGLQTNYWZF\",\"tabindex\":4,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":256,\"x\":352,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DCTZJXUJAS\",\"page\":1,\"spuid\":\"DCTZJXUJAS\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Intestatario\",\"w\":92,\"x\":88,\"y\":70,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ORBYBKHYQK\",\"page\":1,\"spuid\":\"ORBYBKHYQK\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Chiusura\",\"w\":64,\"x\":664,\"y\":70,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UGCBYIEUDJ\",\"page\":1,\"spuid\":\"UGCBYIEUDJ\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Natura:\",\"w\":72,\"x\":31,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UBDRZPYJRT\",\"page\":1,\"spuid\":\"UBDRZPYJRT\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Codice Rapporto:\",\"w\":84,\"x\":16,\"y\":18,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VVKODWZEWZ\",\"page\":1,\"spuid\":\"VVKODWZEWZ\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Tipo Rapporto:\",\"w\":72,\"x\":279,\"y\":18,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ODIDTFEFFZ\",\"page\":1,\"spuid\":\"ODIDTFEFFZ\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Apertura\",\"w\":69,\"x\":16,\"y\":70,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":146,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"FIXUIJJRJQ\",\"type\":\"BodyDetail\",\"w\":768,\"x\":16,\"y\":89,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_UBHZWYZYEF\",\"box_type\":\"titled_box\",\"comment\":\"Dati Esito Agenzia Entrate\",\"h\":35,\"name\":\"box_UBHZWYZYEF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"UBHZWYZYEF\",\"tabindex\":38,\"title_caption\":\"Dati Esito Agenzia Entrate\",\"titled\":true,\"type\":\"Box\",\"w\":728,\"x\":16,\"y\":490,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID ESITO\",\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":8,\"name\":\"IDESITO\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"IANSHYURPV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":208,\"y\":497,\"zone\":\"pag1_1_4_1\",\"zonepath\":\"[1,1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MMLVTODRRS\",\"page\":1,\"spuid\":\"MMLVTODRRS\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"ID ESITO:\",\"w\":52,\"x\":156,\"y\":501,\"zone\":\"pag1_1_4_1\",\"zonepath\":\"[1,1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Generazione Esito\",\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":10,\"name\":\"DATESITO\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"YJETHTLSAS\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":576,\"y\":497,\"zone\":\"pag1_1_4_2\",\"zonepath\":\"[1,1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JUCNEACWKX\",\"page\":1,\"spuid\":\"JUCNEACWKX\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Data Generazione Esito:\",\"w\":127,\"x\":449,\"y\":501,\"zone\":\"pag1_1_4_2\",\"zonepath\":\"[1,1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_NALNSNTYAI\",\"page\":1,\"picker\":true,\"spuid\":\"NALNSNTYAI\",\"tabindex\":23,\"type\":\"Button\",\"value\":\"Cancellazione comunicazioni inviate\",\"w\":208,\"x\":233,\"y\":539,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_RHOMZTFXOQ\",\"page\":1,\"picker\":true,\"spuid\":\"RHOMZTFXOQ\",\"tabindex\":37,\"type\":\"Button\",\"value\":\"Annulla Rettifica\",\"w\":152,\"x\":450,\"y\":539,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_GCHWZOBGPB\",\"page\":1,\"picker\":true,\"spuid\":\"GCHWZOBGPB\",\"tabindex\":22,\"type\":\"Button\",\"value\":\"Rettifica Comunicazioni Inviate\",\"w\":208,\"x\":17,\"y\":539,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":19,\"name\":\"button_HWWOJAYWAI\",\"page\":1,\"picker\":true,\"spuid\":\"HWWOJAYWAI\",\"tabindex\":24,\"type\":\"Button\",\"value\":\"Apre Anagrafica\",\"w\":120,\"x\":624,\"y\":47,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_KLSWWEOHOR\",\"h\":28,\"name\":\"box_KLSWWEOHOR\",\"page\":1,\"shrinkable\":true,\"spuid\":\"KLSWWEOHOR\",\"tabindex\":18,\"type\":\"Box\",\"w\":360,\"x\":16,\"y\":259,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_HXAIQPNTTR\",\"page\":1,\"spuid\":\"HXAIQPNTTR\",\"tabindex\":20,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"APERTURA DEL RAPPORTO\",\"w\":344,\"x\":24,\"y\":266,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_BJDGPHQYFI\",\"h\":28,\"name\":\"box_BJDGPHQYFI\",\"page\":1,\"shrinkable\":true,\"spuid\":\"BJDGPHQYFI\",\"tabindex\":19,\"type\":\"Box\",\"w\":360,\"x\":384,\"y\":259,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_BSRYSFCEAT\",\"page\":1,\"spuid\":\"BSRYSFCEAT\",\"tabindex\":21,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"CHIUSURA DEL RAPPORTO\",\"w\":344,\"x\":392,\"y\":266,\"zone\":\"pag1_1_8_1\",\"zonepath\":\"[1,1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Data Spedizione Chiusura\",\"fixed\":true,\"h\":21,\"label_text\":\"Trasmesso\",\"maxlength\":4,\"name\":\"CSPEDITO\",\"page\":1,\"repeated\":true,\"spuid\":\"GZYOVGKBQU\",\"tabindex\":9,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":71,\"x\":392,\"y\":315,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Apertura Spedita\",\"fixed\":true,\"h\":21,\"label_text\":\"Trasmessa\",\"maxlength\":4,\"name\":\"ASPEDITO\",\"page\":1,\"repeated\":true,\"spuid\":\"VKTPGVCBJR\",\"tabindex\":2,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":71,\"x\":24,\"y\":315,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Riferimento file spedizione\",\"fixed\":true,\"h\":20,\"maxlength\":15,\"name\":\"AFILE\",\"page\":1,\"repeated\":true,\"spuid\":\"CCYVNDNRFK\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":208,\"y\":315,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OZYRKTIKPF\",\"page\":1,\"spuid\":\"OZYRKTIKPF\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Data Fine:\",\"w\":55,\"x\":390,\"y\":298,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VBDRLFPBBZ\",\"page\":1,\"spuid\":\"VBDRLFPBBZ\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Riferimento File:\",\"w\":80,\"x\":492,\"y\":319,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PXDMJWSUND\",\"page\":1,\"spuid\":\"PXDMJWSUND\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Data Inizio:\",\"w\":64,\"x\":16,\"y\":298,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZERFIEYGRR\",\"page\":1,\"spuid\":\"ZERFIEYGRR\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Riferimento File:\",\"w\":80,\"x\":125,\"y\":319,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Chiusura Rapporto\",\"fixed\":true,\"h\":20,\"maxlength\":10,\"name\":\"CDATA\",\"page\":1,\"repeated\":true,\"spuid\":\"UJYQWLUHMX\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":448,\"y\":294,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Apertura\",\"fixed\":true,\"h\":20,\"maxlength\":10,\"name\":\"ADATA\",\"page\":1,\"repeated\":true,\"spuid\":\"KGVKWENSDZ\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":80,\"y\":294,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"File spedizione Chiusura\",\"fixed\":true,\"h\":20,\"maxlength\":15,\"name\":\"CFILE\",\"page\":1,\"repeated\":true,\"spuid\":\"GEAGHOYNJV\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":576,\"y\":315,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JMAPGZEWUL\",\"page\":1,\"spuid\":\"JMAPGZEWUL\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Riferimento Spedizione:\",\"w\":113,\"x\":92,\"y\":347,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Riferimento Spedizione Apertura\",\"fixed\":true,\"h\":20,\"maxlength\":25,\"name\":\"APROG\",\"page\":1,\"repeated\":true,\"spuid\":\"SQFHVLZLRL\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":208,\"y\":343,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AIGHLABXVU\",\"page\":1,\"spuid\":\"AIGHLABXVU\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Riferimento Spedizione:\",\"w\":113,\"x\":459,\"y\":347,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Riferimento spedizione chiusura\",\"fixed\":true,\"h\":20,\"maxlength\":25,\"name\":\"CPROG\",\"page\":1,\"repeated\":true,\"spuid\":\"RPTFBMPRFK\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":576,\"y\":343,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_WNPHGDFVJX\",\"h\":28,\"name\":\"box_WNPHGDFVJX\",\"page\":1,\"shrinkable\":true,\"spuid\":\"WNPHGDFVJX\",\"tabindex\":28,\"type\":\"Box\",\"w\":360,\"x\":16,\"y\":371,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_PLNXDEJCTD\",\"page\":1,\"spuid\":\"PLNXDEJCTD\",\"tabindex\":29,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"RETTIFICA DEL RAPPORTO\",\"w\":344,\"x\":24,\"y\":378,\"zone\":\"pag1_1_12_1\",\"zonepath\":\"[1,1,12,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_RANZSHNOJF\",\"h\":28,\"name\":\"box_RANZSHNOJF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"RANZSHNOJF\",\"tabindex\":30,\"type\":\"Box\",\"w\":360,\"x\":384,\"y\":371,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_PHHCOECSMM\",\"page\":1,\"spuid\":\"PHHCOECSMM\",\"tabindex\":31,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"CANCELLAZIONE DEL RAPPORTO\",\"w\":344,\"x\":392,\"y\":378,\"zone\":\"pag1_1_13_1\",\"zonepath\":\"[1,1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TTPYWGQBMJ\",\"page\":1,\"spuid\":\"TTPYWGQBMJ\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Rettifica:\",\"w\":70,\"x\":8,\"y\":410,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data rettifica apertura\",\"fixed\":true,\"h\":20,\"maxlength\":10,\"name\":\"ADATARET\",\"page\":1,\"repeated\":true,\"spuid\":\"LJUMSXSYFZ\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":80,\"y\":406,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":10,\"name\":\"dtcanc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"CGGFGFHNLQ\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":456,\"y\":406,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RETYYQHGRS\",\"page\":1,\"spuid\":\"RETYYQHGRS\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Cancellazione:\",\"w\":75,\"x\":379,\"y\":410,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":15,\"name\":\"filecanc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"CPXILLMFYQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":576,\"y\":434,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Precedente file spedizione chiusura\",\"fixed\":true,\"h\":20,\"maxlength\":15,\"name\":\"COLDFILE\",\"page\":1,\"repeated\":true,\"spuid\":\"YYRSSVEWOX\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":208,\"y\":434,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"disabled\":\"true\",\"fixed\":true,\"h\":21,\"label_text\":\"Trasmessa\",\"maxlength\":2,\"name\":\"spcanc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"PULJPVPYAY\",\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":71,\"x\":384,\"y\":437,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Rettifica Inviata\",\"fixed\":true,\"h\":21,\"label_text\":\"Trasmessa\",\"maxlength\":4,\"name\":\"RSPEDITO\",\"page\":1,\"repeated\":true,\"spuid\":\"ZEWCJCWNSV\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":71,\"x\":24,\"y\":434,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IYPZKVMVKZ\",\"page\":1,\"spuid\":\"IYPZKVMVKZ\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Riferimento File:\",\"w\":80,\"x\":125,\"y\":438,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IMTYCPFWNU\",\"page\":1,\"spuid\":\"IMTYCPFWNU\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Riferimento File:\",\"w\":80,\"x\":492,\"y\":438,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Precedente riferimento chiusura\",\"fixed\":true,\"h\":20,\"maxlength\":25,\"name\":\"COLDPROG\",\"page\":1,\"repeated\":true,\"spuid\":\"FDSYVBCPAC\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":208,\"y\":462,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KDPEUBXAAZ\",\"page\":1,\"spuid\":\"KDPEUBXAAZ\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Riferimento Spedizione:\",\"w\":113,\"x\":92,\"y\":466,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":25,\"name\":\"idcanc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"MQSDKNMJUI\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":576,\"y\":462,\"zone\":\"pag1_1_18\",\"zonepath\":\"[1,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FRZVZSKKXF\",\"page\":1,\"spuid\":\"FRZVZSKKXF\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Riferimento Spedizione:\",\"w\":113,\"x\":459,\"y\":466,\"zone\":\"pag1_1_18\",\"zonepath\":\"[1,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#FF0000\",\"h\":39,\"name\":\"label_UDPOLEMYNZ\",\"page\":1,\"spuid\":\"UDPOLEMYNZ\",\"tabindex\":35,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"OPERAZIONE\\nCANCELLATA\",\"w\":139,\"x\":612,\"y\":530,\"zone\":\"pag1_1_19\",\"zonepath\":\"[1,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":91,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ECBUSYJPRO\",\"type\":\"Box\",\"w\":712,\"x\":16,\"y\":17,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Rapporto\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"COINT\",\"page\":1,\"spuid\":\"BLOIDAPXRQ\",\"tabindex\":6,\"textlist\":\"Cointestato,Non Cointestato\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":160,\"x\":104,\"y\":42,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Chiusura Rapporto\",\"h\":17,\"maxlength\":10,\"name\":\"CDATA\",\"page\":1,\"repeated\":true,\"spuid\":\"YQJXLYYDEK\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":664,\"y\":91,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ragione Sociale\",\"disabled\":\"true\",\"h\":17,\"maxlength\":70,\"name\":\"xragsoc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"VCSXGLJKMU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":224,\"y\":91,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intestatario\",\"h\":17,\"maxlength\":16,\"name\":\"CONNESINT\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"ZWBKZJLHCV\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":110,\"x\":88,\"y\":91,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Apertura\",\"h\":17,\"maxlength\":10,\"name\":\"ADATA\",\"page\":1,\"repeated\":true,\"spuid\":\"ZYSXZRLIHG\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":64,\"x\":16,\"y\":91,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_TGJYPNQVEJ\",\"h\":483,\"name\":\"box_TGJYPNQVEJ\",\"page\":2,\"shrinkable\":true,\"spuid\":\"TGJYPNQVEJ\",\"tabindex\":1,\"type\":\"Box\",\"w\":744,\"x\":8,\"y\":7,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JXLGEAUZTQ\",\"page\":2,\"spuid\":\"JXLGEAUZTQ\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Codice Univo Rapporto:\",\"w\":125,\"x\":9,\"y\":25,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB\",\"h\":20,\"maxlength\":5,\"name\":\"CAB\",\"page\":2,\"spuid\":\"CODMGYDXYT\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":568,\"y\":21,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FRUUOBVPDA\",\"page\":2,\"spuid\":\"FRUUOBVPDA\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":26,\"x\":542,\"y\":25,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Univo Rapporto\",\"disabled\":\"true\",\"h\":20,\"maxlength\":50,\"name\":\"UNIQUECODE\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"LTLFYOYQAO\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":21,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Valuta\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":2,\"spuid\":\"AKLWIUMNVR\",\"tabindex\":7,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":312,\"x\":136,\"y\":49,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KSMLUMFLML\",\"page\":2,\"spuid\":\"KSMLUMFLML\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Valuta:\",\"w\":37,\"x\":97,\"y\":53,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":278,\"name\":\"ardt_ae_saldianno_rap\",\"page\":2,\"spuid\":\"KGHSUPPYWT\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":728,\"x\":16,\"y\":84,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,armd_anagrappoBO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_RAPPORTO);
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
  void WriteFormPage(armd_anagrappoBO BO,ServletStatus status) {
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
     "<script src='armd_anagrappo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    status.out.println("InstTR();");
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
    if ((CPLib.gt(BO.extendedFields.length,0) || CPLib.gt(BO.extendedFields_trs.length,0))) {
      l_cJsUid = SPPrxycizer.proxycizedPath("ExtendedFields.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armd_anagrappo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armd_anagrappo_edit.js'>" +
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
      status.out.println("w_TIPOAG=a[1];");
      status.out.println("w_COINT=a[2];");
      status.out.println("w_RIFANA=a[3];");
      status.out.println("w_CONNESINT=a[4];");
      status.out.println("w_ASPEDITO=a[5];");
      status.out.println("w_ADATA=a[6];");
      status.out.println("w_APROG=a[7];");
      status.out.println("w_AOLDPROG=a[8];");
      status.out.println("w_AFILE=a[9];");
      status.out.println("w_AOLDFILE=a[10];");
      status.out.println("w_ADATARET=a[11];");
      status.out.println("w_CSPEDITO=a[12];");
      status.out.println("w_CDATA=a[13];");
      status.out.println("w_CPROG=a[14];");
      status.out.println("w_COLDPROG=a[15];");
      status.out.println("w_CFILE=a[16];");
      status.out.println("w_COLDFILE=a[17];");
      status.out.println("w_CDATARET=a[18];");
      status.out.println("w_IDRIF=a[19];");
      status.out.println("w_NOCODFISC=a[20];");
      status.out.println("w_IDBASE=a[21];");
      status.out.println("w_CPROWNUM=a[22];");
      status.out.println("w_IDESITO=a[23];");
      status.out.println("w_RSPEDITO=a[24];");
      status.out.println("w_UNIQUECODE=a[25];");
      status.out.println("w_CAB=a[26];");
      status.out.println("w_VALUTA=a[27];");
      status.out.println("w_PROGAER=a[28];");
      status.out.println("op_PROGAER=a[29];");
      status.out.println("w_PROGAET=a[30];");
      status.out.println("op_PROGAET=a[31];");
      status.out.println("w_DATESITO=a[32];");
      status.out.println("w_CFESTERO=a[33];");
      status.out.println("w_xragsoc=a[34];");
      status.out.println("w_dtcanc=a[35];");
      status.out.println("w_spcanc=a[36];");
      status.out.println("w_filecanc=a[37];");
      status.out.println("w_idcanc=a[38];");
      status.out.println("op_codazi=a[39];");
      status.out.println("m_cWv_ardt_ae_saldianno_rap=a[40];");
      status.out.println("if (Gt(a.length,41)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,41)) {");
      status.out.println("o_TIPOAG=w_TIPOAG;");
      status.out.println("o_IDBASE=w_IDBASE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CPROWNUM','RAPPORTO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armd_anagrappo_proc.js'>" +
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
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/tabStrip.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
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
    status.themeWriter.WriteBody_Begin(579,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","aetesta");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","RAPPORTO");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armd_anagrappoBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armd_anagrappoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armd_anagrappoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armd_anagrappoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armd_anagrappoBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armd_anagrappoBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armd_anagrappoBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("LibreriaMit.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_ae_chkdel.m_cEntityUid+"/arfn_ae_chkdel.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_delret_aerighe.m_cEntityUid+"/arrt_delret_aerighe.js'>" +
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
      arfn_ae_chkdel.GetCallableNames(callable);
      arrt_delret_aerighe.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"ardt_ae_saldianno_rap");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armd_anagrappoBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_RAPPORTO),"C",25,0));
      }
    } else if (CPLib.eq(p_cUID,"ZWBKZJLHCV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NQPTOOEBKN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armd_anagrappoBO BO) {
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
          if (result &&  ! (CPLib.Empty(BO.w_CONNESINT))) {
            a = GetCheckVars(status,BO,"ZWBKZJLHCV");
            b = _row.optString("ZWBKZJLHCV");
            result = CPLib.eq(a,b);
          }
          if (result &&  ! (CPLib.Empty(BO.w_IDBASE))) {
            a = GetCheckVars(status,BO,"NQPTOOEBKN");
            b = _row.optString("NQPTOOEBKN");
            result = CPLib.eq(a,b);
          }
        }
        l_nRow = l_nRow+1;
      }
    }
    return result;
  }
}
