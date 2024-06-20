import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_estrai_xls extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*QJXUVPNSIC*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("dadata",source.GetCaller().GetDate("dadata","D",8,0));
      source.SetParameter("adata",source.GetCaller().GetDate("adata","D",8,0));
      source.SetParameter("cdadata",source.GetCaller().GetString("cdadata","C",8,0));
      source.SetParameter("c_adata",source.GetCaller().GetString("c_adata","C",8,0));
      source.SetParameter("nomefile",source.GetCaller().GetString("nomefile","C",80,0));
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
    arpg_estrai_xlsBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    if (CPLib.eq(status.m_cAction,"start") || CPLib.eq(status.m_cAction,"query")) {
      Start(status,BO);
    } else if (CPLib.eq(status.m_cAction,"save")) {
      Save(status,BO);
    } else if (CPLib.eq(status.m_cAction,"discard")) {
      Discard(status,BO);
    } else if (CPLib.eq(status.m_cAction,"painter")) {
      Painter(status);
    }
    if (CPLib.eq(status.m_cAction,"next")) {
      Next(status,BO);
    } else if (CPLib.eq(status.m_cAction,"previous")) {
      Previous(status,BO);
    }
    // * --- Area Manuale = Do Action
    // * --- Fine Area Manuale
    if (status.m_bExit &&  ! (CPLib.Empty(status.m_cAtExit))) {
      if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"workflow")) {
        ExitToWorkflow(status);
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
    } else if ( ! (CPLib.Empty(BO.LastErrorMessage()))) {
      // verra' stampato l'alert dopo
      status.m_bError = true;
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
    SPLib.NoCache(response);
    status.out = response.getWriter();
    if (CPLib.eq(status.m_cClientMode,"close")) {
      WriteExitPage(status);
    } else if (CPLib.eq(status.m_cAction,"createportlet")) {
      CreatePortlet(status,BO);
    } else {
      WriteFormPage(BO,status);
    }
  }
  public String getEntityTitle() {
    return "Estrazione Movimenti (Operazioni-Frazionate)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_estrai_xls";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 789;
    l_eg.m_nEntityHeight = 523;
    l_eg.isPublic = true;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"personbo","tbcitta","tbstati","tbmacage","anadip"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("connes","C",16,0, "edit","NDG Intestatario"),
                   new SPItem("ragosc","C",60,0, "edit","Nominativo"),
                   new SPItem("cCODFISC","C",16,0, "edit",""),
                   new SPItem("citnas","C",40,0, "edit","Citta di nascita"),
                   new SPItem("stanas","C",40,0, "edit","Stato di nascita"),
                   new SPItem("datnas","D",8,0, "edit","Data di nascita"),
                   new SPItem("ragben","C",60,0, "edit","Nominativo"),
                   new SPItem("staben","C",40,0, "edit","Stato di nascita"),
                   new SPItem("dadata","D",8,0, "edit",""),
                   new SPItem("adata","D",8,0, "edit",""),
                   new SPItem("flgmese","C",1,0, "edit",""),
                   new SPItem("codmag","C",5,0, "edit","MacroAgente"),
                   new SPItem("cDIP","C",6,0, "edit",""),
                   new SPItem("cMTCN","C",10,0, "edit",""),
                   new SPItem("tipofile","C",1,0, "edit","Tipo File"),
                   new SPItem("destfold","C",80,0, "edit","Cartella Destinazione"),
                   new SPItem("opesel","C",1,0, "edit",""),
                   new SPItem("frzsel","C",1,0, "edit",""),
                   new SPItem("attive","C",1,0, "edit",""),
                   new SPItem("tipoout","C",1,0, "edit","Tipo Output"),
                   new SPItem("cdadata","C",8,0, "hide",""),
                   new SPItem("c_adata","C",8,0, "hide",""),
                   new SPItem("xdesdip","C",30,0, "hide","Descrizione"),
                   new SPItem("nomefile","C",80,0, "hide",""),
                   new SPItem("gUrlApp","C",80,0, "hide","URL Applicazione"),
                   new SPItem("gFileName","C",80,0, "hide","NomeFile"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("xmadescri","C",60,0, "hide","Denominazione"),
                   new SPItem("nomefile","C",60,0, "edit","File di Selezione"),
                   new SPItem("gAzienda","C",10,0, "hide","Azienda"),
                   new SPItem("flgsto","C",1,0, "edit","Dati Storici Soggetto"),
                   new SPItem("flgncf","C",1,0, "edit",""),
                   new SPItem("flgsegno","C",1,0, "edit","")
                 };
    l_eg.m_lExecuteAtStart = false;
    l_eg.m_cQueryName = "";
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_estrai_xlsBO BO) {
    CPMNTChild[] l_MNTs = null;
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
    l_translations=new String[][]{{"10020699785",p_Context.Translate("Premere il bottone l'elaborazioni On-Line")},
    {"10056338162",p_Context.Translate("URL Applicazione")},
    {"1044021062",p_Context.Translate("Solo operazioni Attive")},
    {"10557974447",p_Context.Translate("La data di fine periodo non deve essere minore di quella di inizio periodo!")},
    {"10669633582",p_Context.Translate("Data di nascita")},
    {"10982022690",p_Context.Translate("File di Selezione")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11025719234",p_Context.Translate("NomeFile")},
    {"11056074708",p_Context.Translate("Crea un file per ogni mese")},
    {"11148782069",p_Context.Translate("MacroAgenti")},
    {"11148783093",p_Context.Translate("MacroAgente")},
    {"11172839772",p_Context.Translate("Tipo Output")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"12057236694",p_Context.Translate("Frazionate")},
    {"1206113244",p_Context.Translate("Elimina C. F. Fittizio")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12124197165",p_Context.Translate("Citta di nascita")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1311031053",p_Context.Translate("Dati Storici Soggetto")},
    {"1324886315",p_Context.Translate("Estrazione Movimenti (Operazioni-Frazionate)")},
    {"145008573",p_Context.Translate("Cartella Destinazione")},
    {"15186643",p_Context.Translate("Città")},
    {"1627951949",p_Context.Translate("Operazioni")},
    {"1739899105",p_Context.Translate("Azienda")},
    {"176491428",p_Context.Translate("Nominativo")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"528107534",p_Context.Translate("Premere il bottone l'elaborazione Batch")},
    {"733213761",p_Context.Translate("NDG Intestatario")},
    {"7383187",p_Context.Translate("Stati")},
    {"763848521",p_Context.Translate("Tipo File")}};
    return l_translations;
  }
  void WriteStyles(arpg_estrai_xlsBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_estrai_xls.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_estrai_xlsBO BO,ServletStatus status) {
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
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Messaggi_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_estrai_xlsBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_estrai_xlsBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_estrai_xlsBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(518);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_estrai_xlsBO BO,ServletStatus status) {
    status.out.println(
     "<div id='XLVFHSOSYH_DIV' class='UntitledBox'>" +
     "<div id='XLVFHSOSYH' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='connes' id='QEIVEBXKFW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_connes,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='QEIVEBXKFW_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='QEIVEBXKFW_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ragosc' id='IUARTFLDNM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ragosc,"C",60,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='cCODFISC' id='OUWMDLXPIS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_cCODFISC,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='citnas' id='FKOHLGHPDQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_citnas,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
     "<button id='FKOHLGHPDQ_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='FKOHLGHPDQ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='stanas' id='CYKHQWZLSC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_stanas,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
     "<button id='CYKHQWZLSC_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='CYKHQWZLSC_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='datnas' id='WWVZLGRRCI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_datnas,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='WWVZLGRRCI_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='WWVZLGRRCI_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ragben' id='OXKAWWOUJN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ragben,"C",60,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='staben' id='FWTFXGQZAI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_staben,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
     "<button id='FWTFXGQZAI_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='FWTFXGQZAI_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='dadata' id='DPKVLWHCIG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_dadata,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='DPKVLWHCIG_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DPKVLWHCIG_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='adata' id='MTJDZQTEIR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_adata,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='MTJDZQTEIR_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='MTJDZQTEIR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='RWVYYKSQTM_DIV'>" +
     "<input name='flgmese' id='RWVYYKSQTM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgmese,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgmese))?"CHECKED":"")+">" +
     "<label id='RWVYYKSQTM_LBL' for='RWVYYKSQTM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea un file per ogni mese"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='codmag' id='DZAJHOZNZJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_codmag,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='DZAJHOZNZJ_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DZAJHOZNZJ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='cDIP' id='FBVBGICYQT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_cDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='FBVBGICYQT_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='FBVBGICYQT_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='cMTCN' id='XECGCUVQNW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_cMTCN,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='DZUBEERBGN' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Seleziona"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='DZUBEERBGN_Click()'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tipofile' id='FLYXRDHNYB' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_tipofile))?"SELECTED":"")+">" +
     ""+status.context.Translate("MTCN")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_tipofile))?"SELECTED":"")+">" +
     ""+status.context.Translate("Codici Fiscali")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('FLYXRDHNYB'),w_tipofile,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='destfold' id='BAPCIYCOIX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_destfold,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='XPVFYUOOMG_DIV'>" +
     "<input name='opesel' id='XPVFYUOOMG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_opesel,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_opesel))?"CHECKED":"")+">" +
     "<label id='XPVFYUOOMG_LBL' for='XPVFYUOOMG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Operazioni"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DVVVZVWYQU_DIV'>" +
     "<input name='frzsel' id='DVVVZVWYQU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_frzsel,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_frzsel))?"CHECKED":"")+">" +
     "<label id='DVVVZVWYQU_LBL' for='DVVVZVWYQU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Frazionate"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='KVMSNZSHYQ_DIV'>" +
     "<input name='attive' id='KVMSNZSHYQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_attive,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_attive))?"CHECKED":"")+">" +
     "<label id='KVMSNZSHYQ_LBL' for='KVMSNZSHYQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Solo operazioni Attive"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='CNLUJUMTRH_DIV'>" +
     "<span id='CNLUJUMTRH_0_container'>" +
     "<input id='CNLUJUMTRH_0' name='CNLUJUMTRH' type='radio' value="+SPLib.ToHTMLValue("E","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("E",CPLib.Trim(BO.w_tipoout))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CNLUJUMTRH_0'>"+status.context.Translate("Excel")+"</label>" +
     "</span>" +
     "<span id='CNLUJUMTRH_1_container'>" +
     "<input id='CNLUJUMTRH_1' name='CNLUJUMTRH' type='radio' value="+SPLib.ToHTMLValue("T","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("T",CPLib.Trim(BO.w_tipoout))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CNLUJUMTRH_1'>"+status.context.Translate("Testo")+"</label>" +
     "</span>" +
     "<span id='CNLUJUMTRH_2_container'>" +
     "<input id='CNLUJUMTRH_2' name='CNLUJUMTRH' type='radio' value="+SPLib.ToHTMLValue("Z","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("Z",CPLib.Trim(BO.w_tipoout))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CNLUJUMTRH_2'>"+status.context.Translate("Database con Azzeramento")+"</label>" +
     "</span>" +
     "<span id='CNLUJUMTRH_3_container'>" +
     "<input id='CNLUJUMTRH_3' name='CNLUJUMTRH' type='radio' value="+SPLib.ToHTMLValue("D","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("D",CPLib.Trim(BO.w_tipoout))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CNLUJUMTRH_3'>"+status.context.Translate("Database in accodamento")+"</label>" +
     "</span>" +
     "<span id='CNLUJUMTRH_4_container'>" +
     "<input id='CNLUJUMTRH_4' name='CNLUJUMTRH' type='radio' value="+SPLib.ToHTMLValue("C","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("C",CPLib.Trim(BO.w_tipoout))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CNLUJUMTRH_4'>"+status.context.Translate("CSV")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_FXCLBAZMUC()' tabindex='-1' id='FXCLBAZMUC_HREF'>" +
     "<img id='FXCLBAZMUC' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/save.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone l'elaborazione Batch"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone l'elaborazione Batch"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_XURLGQZZMU()' tabindex='-1' id='XURLGQZZMU_HREF'>" +
     "<img id='XURLGQZZMU' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/elaborazione.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone l'elaborazioni On-Line"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone l'elaborazioni On-Line"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_PTXYMSWBZO()' tabindex='-1' id='PTXYMSWBZO_HREF'>" +
     "<img id='PTXYMSWBZO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HPGJXQIVYG_DIV'>" +
     "<label id='HPGJXQIVYG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BGHAITOPMU_DIV'>" +
     "<label id='BGHAITOPMU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HLQSHVFXVS_DIV'>" +
     "<label id='HLQSHVFXVS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TQJNOWMVHW_DIV'>" +
     "<label id='TQJNOWMVHW'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesdip)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IPCBNWYJLL_DIV'>" +
     "<label id='IPCBNWYJLL' for='WWVZLGRRCI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data di nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZAMUVZUHHN_DIV'>" +
     "<label id='ZAMUVZUHHN' for='CYKHQWZLSC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato di nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PUJCUNGGCR_DIV'>" +
     "<label id='PUJCUNGGCR' for='FKOHLGHPDQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citta di nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MILQDXSPXU_DIV'>" +
     "<label id='MILQDXSPXU' for='IUARTFLDNM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Intestatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BMUWSQCGLG_DIV'>" +
     "<label id='BMUWSQCGLG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("PARAMETRI DI SELEZIONE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CXSMATIXZS_DIV' style='display:none'>" +
     "<label id='CXSMATIXZS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MTCN:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MAKXXLLXNA_DIV' style='display:none'>" +
     "<label id='MAKXXLLXNA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='DYMVKIQWCA'>" +
    "");
    // GetPortlet_Messaggi_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_DYMVKIQWCA;
    inclusionVars_DYMVKIQWCA = GetPortlet_DYMVKIQWCA_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_DYMVKIQWCA);
    String portletUID_DYMVKIQWCA = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+ portletUID_DYMVKIQWCA+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_DYMVKIQWCA),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.DYMVKIQWCA='"+portletUID_DYMVKIQWCA+"';" +
     "w_Messaggi=ZtVWeb.getPortletById('"+portletUID_DYMVKIQWCA+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BRFEXEKXWS_DIV'>" +
     "<label id='BRFEXEKXWS' for='OXKAWWOUJN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WGMJUTZBBY_DIV'>" +
     "<label id='WGMJUTZBBY' for='FWTFXGQZAI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato di residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JLHFWAWERN_DIV'>" +
     "<label id='JLHFWAWERN' for='DZAJHOZNZJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MacroAgente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BUHXXVSCZH_DIV'>" +
     "<label id='BUHXXVSCZH'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xmadescri)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SKZNSKGZRP_DIV'>" +
     "<label id='SKZNSKGZRP' for='QEIVEBXKFW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("NDG Intestatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='nomefile' id='FPLBMQHLCU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_nomefile,"C",60,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QRXJMBXMQM_DIV'>" +
     "<label id='QRXJMBXMQM' for='FPLBMQHLCU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("File di Selezione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PIFFTCKSCU_DIV'>" +
     "<label id='PIFFTCKSCU' for='FLYXRDHNYB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='LDWRKOVJHN_DIV'>" +
     "<input name='flgsto' id='LDWRKOVJHN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgsto,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgsto))?"CHECKED":"")+">" +
     "<label id='LDWRKOVJHN_LBL' for='LDWRKOVJHN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Dati Storici Soggetto"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OJOGFQEVQE_DIV'>" +
     "<label id='OJOGFQEVQE' for='CNLUJUMTRH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Output:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QJBLEONCDX_DIV'>" +
     "<label id='QJBLEONCDX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Estrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OBJZKBQZTK_DIV'>" +
     "<label id='OBJZKBQZTK' for='BAPCIYCOIX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cartella Destinazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='VFBJBVZFDJ_DIV'>" +
     "<input name='flgncf' id='VFBJBVZFDJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgncf,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgncf))?"CHECKED":"")+">" +
     "<label id='VFBJBVZFDJ_LBL' for='VFBJBVZFDJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Elimina C. F. Fittizio"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='PBRMCZVHNN_DIV'>" +
     "<span id='PBRMCZVHNN_0_container'>" +
     "<input id='PBRMCZVHNN_0' name='PBRMCZVHNN' type='radio' value="+SPLib.ToHTMLValue("1","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("1",CPLib.Trim(BO.w_flgsegno))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='PBRMCZVHNN_0'>"+status.context.Translate("Segno Avere = SEND")+"</label>" +
     "</span>" +
     "<span id='PBRMCZVHNN_1_container'>" +
     "<input id='PBRMCZVHNN_1' name='PBRMCZVHNN' type='radio' value="+SPLib.ToHTMLValue("2","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("2",CPLib.Trim(BO.w_flgsegno))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='PBRMCZVHNN_1'>"+status.context.Translate("Segno Dare = SEND")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZWFWRKARRA_DIV'>" +
     "<label id='ZWFWRKARRA' for='CNLUJUMTRH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Segno:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_estrai_xlsBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_estrai_xlsBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_estrai_xlsBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_connes,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ragosc,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cCODFISC,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_citnas,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_stanas,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datnas,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ragben,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_staben,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dadata,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_adata,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgmese,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_codmag,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cMTCN,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipofile,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_destfold,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_opesel,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_frzsel,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_attive,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipoout,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cdadata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_adata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_nomefile,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gUrlApp,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFileName,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xmadescri,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gAzienda,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgsto,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgncf,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgsegno,"C",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_estrai_xlsBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_TQJNOWMVHW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FGMOCXNBFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BUHXXVSCZH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(523,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(789,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_estrai_xls"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'QEIVEBXKFW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'FKOHLGHPDQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CITTACITTACtbcitta",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
    status.out.print(",'CYKHQWZLSC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("DESCRIDESCRICtbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'FWTFXGQZAI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("DESCRIDESCRICtbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'DZAJHOZNZJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("MACODICEMACODICE,MADESCRIC,Ctbmacage",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
    status.out.print(",'FBVBGICYQT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    AppendCallableIDS(status,",");
    status.out.println("}");
    if (true) {
      status.out.print("var m_CheckVars=[");
      status.out.print(SPLib.ToJSValue(GetCheckVars(status, BO),"C",0,0));
      status.out.println("]");
    }
    if (CPLib.eq(status.context.GetGlobalString("IsSPAdministrationInstalled"),"yes") && CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("var m_cProgName = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    } else {
      status.out.println("Zoom.p="+SPLib.ToJSValue(entityGlobals.name,"C",0,0)+";");
    }
    if (CPLib.eq(status.context.GetGlobalString("IsPortalStudioInstalled"),"yes") && SPLib.CanAccessEditor(status.context,"PortalStudio")) {
      status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_estrai_xls","");
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
    status.out.println("var m_cFunction = " + SPLib.ToJSValue("dialog","C",0,0)+ ";");
    status.out.println("var m_bFieldsUpdated = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
    status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarErrorMsg = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_nRowsPerPage = " + SPLib.ToJSValue(entityGlobals.m_nRowsPerPage,"I",0,0)+ ";");
    status.out.println("var m_nCurrentRow = " + SPLib.ToJSValue(0,"N",0,0)+ ";");
    status.out.println("var m_nRows = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
    status.out.println("var m_nRowStatus = " + SPLib.ToJSValue(0,"N",0,0)+ ";");
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(arpg_estrai_xlsBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("EnableControlsUnderCondition();");
    status.out.println("var l_bStart = " + SPLib.ToJSValue(CPLib.eq(status.m_cAction,"start"),"L",0,0)+ ";");
    status.out.println("var l_cParamSeq = " + SPLib.ToJSValue((CPLib.eq(status.m_cAction,"start")?","+status.source.GetParameter("m_cParameterSequence","")+",":""),"C",0,0)+ ";");
    status.out.println("initNoLocalVars((l_bStart?1:0),l_cParamSeq);");
    status.out.println("calculateSidebarBandsPosition('page_1');");
    if ( ! (status.m_bHasRS)) {
      status.out.println("SetRegionalSettings();");
    }
    status.out.println("ReloadMenu();");
    status.out.println("setEventHandlers(false);");
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    status.out.println("SetDynamicClasses();");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
      }
    }
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- Fine Area Manuale");
    RaiseLoadedEntity(BO,status);
    status.out.println("CalculateAndResizeEntityHeight();");
    status.out.println("HideLoadingLayer();");
    if (status.m_bShowBOWarnings) {
      status.out.println("SubmitListenerForm(" + SPLib.ToJSValue(status.m_cAction,"C",0,0) + ");");
    }
    status.out.println("}");
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_estrai_xlsBO getBO(ServletStatus status) {
    arpg_estrai_xlsBO BO = new arpg_estrai_xlsBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_estrai_xlsBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_estrai_xlsBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_estrai_xlsBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_estrai_xlsBO BO) {
    boolean l_bResult;
    BO.SetFromContext(status.m_cWv);
    l_bResult = BO.Save();
    if (l_bResult) {
      status.m_cClientMode = "new";
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
    }
  }
  void Discard(ServletStatus status,arpg_estrai_xlsBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_estrai_xlsBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",523);
    item.put("w",789);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_estrai_xls");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"511\",\"name\":\"Box_XLVFHSOSYH\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"XLVFHSOSYH\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"7\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"NDG Intestatario\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"connes\",\"page\":\"1\",\"spuid\":\"QEIVEBXKFW\",\"tabindex\":\"2\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"144\",\"y\":\"42\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Nominativo\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"60\",\"name\":\"ragosc\",\"page\":\"1\",\"spuid\":\"IUARTFLDNM\",\"tabindex\":\"3\",\"type\":\"Textbox\",\"w\":\"372\",\"x\":\"144\",\"y\":\"70\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"cCODFISC\",\"page\":\"1\",\"spuid\":\"OUWMDLXPIS\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"624\",\"y\":\"70\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Citta di nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"40\",\"name\":\"citnas\",\"page\":\"1\",\"spuid\":\"FKOHLGHPDQ\",\"tabindex\":\"5\",\"type\":\"Textbox\",\"w\":\"252\",\"x\":\"144\",\"y\":\"98\",\"zone\":\"XLVFHSOSYH_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stato di nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"40\",\"name\":\"stanas\",\"page\":\"1\",\"spuid\":\"CYKHQWZLSC\",\"tabindex\":\"6\",\"type\":\"Textbox\",\"w\":\"252\",\"x\":\"144\",\"y\":\"126\",\"zone\":\"XLVFHSOSYH_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Data di nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"datnas\",\"page\":\"1\",\"spuid\":\"WWVZLGRRCI\",\"tabindex\":\"7\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"504\",\"y\":\"126\",\"zone\":\"XLVFHSOSYH_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Nominativo\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"60\",\"name\":\"ragben\",\"page\":\"1\",\"spuid\":\"OXKAWWOUJN\",\"tabindex\":\"8\",\"type\":\"Textbox\",\"w\":\"372\",\"x\":\"144\",\"y\":\"154\",\"zone\":\"XLVFHSOSYH_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stato di nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"40\",\"name\":\"staben\",\"page\":\"1\",\"spuid\":\"FWTFXGQZAI\",\"tabindex\":\"9\",\"type\":\"Textbox\",\"w\":\"252\",\"x\":\"144\",\"y\":\"182\",\"zone\":\"XLVFHSOSYH_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"dadata\",\"page\":\"1\",\"spuid\":\"DPKVLWHCIG\",\"tabindex\":\"10\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"144\",\"y\":\"210\",\"zone\":\"XLVFHSOSYH_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"adata\",\"page\":\"1\",\"spuid\":\"MTJDZQTEIR\",\"tabindex\":\"11\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"366\",\"y\":\"210\",\"zone\":\"XLVFHSOSYH_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgmese\",\"page\":\"1\",\"spuid\":\"RWVYYKSQTM\",\"tabindex\":\"12\",\"type\":\"Checkbox\",\"w\":\"145\",\"x\":\"624\",\"y\":\"209\",\"zone\":\"XLVFHSOSYH_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"MacroAgente\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"codmag\",\"page\":\"1\",\"spuid\":\"DZAJHOZNZJ\",\"tabindex\":\"13\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"144\",\"y\":\"238\",\"zone\":\"XLVFHSOSYH_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"cDIP\",\"page\":\"1\",\"spuid\":\"FBVBGICYQT\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"64\",\"x\":\"144\",\"y\":\"266\",\"zone\":\"XLVFHSOSYH_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"cMTCN\",\"page\":\"1\",\"spuid\":\"XECGCUVQNW\",\"tabindex\":\"15\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"624\",\"y\":\"266\",\"zone\":\"XLVFHSOSYH_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"href\":\"javascript:DZUBEERBGN_Click()\",\"name\":\"Seleziona\",\"page\":\"1\",\"spuid\":\"DZUBEERBGN\",\"tabindex\":\"16\",\"type\":\"Button\",\"value\":\"Seleziona\",\"w\":\"56\",\"x\":\"504\",\"y\":\"294\",\"zone\":\"XLVFHSOSYH_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Tipo File\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tipofile\",\"page\":\"1\",\"spuid\":\"FLYXRDHNYB\",\"tabindex\":\"17\",\"textlist\":\"MTCN,Codici Fiscali\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":\"152\",\"x\":\"624\",\"y\":\"294\",\"zone\":\"XLVFHSOSYH_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Cartella Destinazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"80\",\"name\":\"destfold\",\"page\":\"1\",\"spuid\":\"BAPCIYCOIX\",\"tabindex\":\"18\",\"type\":\"Textbox\",\"w\":\"492\",\"x\":\"144\",\"y\":\"322\",\"zone\":\"XLVFHSOSYH_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"opesel\",\"page\":\"1\",\"spuid\":\"XPVFYUOOMG\",\"tabindex\":\"19\",\"type\":\"Checkbox\",\"w\":\"80\",\"x\":\"144\",\"y\":\"350\",\"zone\":\"XLVFHSOSYH_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"frzsel\",\"page\":\"1\",\"spuid\":\"DVVVZVWYQU\",\"tabindex\":\"20\",\"type\":\"Checkbox\",\"w\":\"71\",\"x\":\"232\",\"y\":\"350\",\"zone\":\"XLVFHSOSYH_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"attive\",\"page\":\"1\",\"spuid\":\"KVMSNZSHYQ\",\"tabindex\":\"21\",\"type\":\"Checkbox\",\"w\":\"160\",\"x\":\"424\",\"y\":\"350\",\"zone\":\"XLVFHSOSYH_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Tipo Output\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"tipoout\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"CNLUJUMTRH\",\"tabindex\":\"22\",\"textlist\":\"Excel,Testo,Database con Azzeramento,Database in accodamento,CSV\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"E"+"'"+","+"'"+"T"+"'"+","+"'"+"Z"+"'"+","+"'"+"D"+"'"+","+"'"+"C"+"'"+"\",\"w\":\"488\",\"x\":\"144\",\"y\":\"378\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Premere il bottone l"+"'"+"elaborazione Batch\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_FXCLBAZMUC()\",\"name\":\"images_save_gif\",\"page\":\"1\",\"spuid\":\"FXCLBAZMUC\",\"src\":\"images\\/save.gif\",\"tabindex\":\"23\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"640\",\"y\":\"364\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Premere il bottone l"+"'"+"elaborazioni On-Line\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_XURLGQZZMU()\",\"name\":\"images_elaborazione_gif\",\"page\":\"1\",\"spuid\":\"XURLGQZZMU\",\"src\":\"images\\/elaborazione.gif\",\"tabindex\":\"24\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"688\",\"y\":\"364\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_PTXYMSWBZO()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"PTXYMSWBZO\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"25\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"736\",\"y\":\"364\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"HPGJXQIVYG_DIV\",\"tabindex\":\"26\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"132\",\"x\":\"12\",\"y\":\"214\",\"zone\":\"XLVFHSOSYH_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"BGHAITOPMU_DIV\",\"tabindex\":\"27\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"116\",\"x\":\"246\",\"y\":\"214\",\"zone\":\"XLVFHSOSYH_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Agenzia_\",\"page\":\"1\",\"spuid\":\"HLQSHVFXVS_DIV\",\"tabindex\":\"30\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"42\",\"x\":\"102\",\"y\":\"270\",\"zone\":\"XLVFHSOSYH_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesdip\",\"page\":\"1\",\"spuid\":\"TQJNOWMVHW_DIV\",\"tabindex\":\"32\",\"type\":\"Label\",\"value\":\"w_xdesdip\",\"w\":\"296\",\"x\":\"232\",\"y\":\"270\",\"zone\":\"XLVFHSOSYH_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Data_di_nascita_\",\"page\":\"1\",\"spuid\":\"IPCBNWYJLL_DIV\",\"tabindex\":\"33\",\"type\":\"Label\",\"value\":\"Data di nascita:\",\"w\":\"75\",\"x\":\"429\",\"y\":\"130\",\"zone\":\"XLVFHSOSYH_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Stato_di_nascita_\",\"page\":\"1\",\"spuid\":\"ZAMUVZUHHN_DIV\",\"tabindex\":\"34\",\"type\":\"Label\",\"value\":\"Stato di nascita:\",\"w\":\"78\",\"x\":\"66\",\"y\":\"130\",\"zone\":\"XLVFHSOSYH_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Citta_di_nascita_\",\"page\":\"1\",\"spuid\":\"PUJCUNGGCR_DIV\",\"tabindex\":\"35\",\"type\":\"Label\",\"value\":\"Citta di nascita:\",\"w\":\"75\",\"x\":\"69\",\"y\":\"102\",\"zone\":\"XLVFHSOSYH_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Intestatario_\",\"page\":\"1\",\"spuid\":\"MILQDXSPXU_DIV\",\"tabindex\":\"36\",\"type\":\"Label\",\"value\":\"Intestatario:\",\"w\":\"80\",\"x\":\"64\",\"y\":\"74\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#FFFF00\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"href\":\" \",\"name\":\"PARAMETRI_DI_SELEZIONE\",\"page\":\"1\",\"spuid\":\"BMUWSQCGLG_DIV\",\"tabindex\":\"37\",\"type\":\"Label\",\"value\":\"PARAMETRI DI SELEZIONE\",\"w\":\"776\",\"x\":\"8\",\"y\":\"6\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"38\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"88\",\"x\":\"376\",\"y\":\"28\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"MTCN_\",\"page\":\"1\",\"spuid\":\"CXSMATIXZS_DIV\",\"tabindex\":\"42\",\"type\":\"Label\",\"value\":\"MTCN:\",\"w\":\"32\",\"x\":\"592\",\"y\":\"270\",\"zone\":\"XLVFHSOSYH_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Fiscale_\",\"page\":\"1\",\"spuid\":\"MAKXXLLXNA_DIV\",\"tabindex\":\"43\",\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":\"71\",\"x\":\"549\",\"y\":\"74\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"427\",\"zone\":\"XLVFHSOSYH_17\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Controparte_\",\"page\":\"1\",\"spuid\":\"BRFEXEKXWS_DIV\",\"tabindex\":\"46\",\"type\":\"Label\",\"value\":\"Controparte:\",\"w\":\"80\",\"x\":\"64\",\"y\":\"158\",\"zone\":\"XLVFHSOSYH_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Stato_di_residenza_\",\"page\":\"1\",\"spuid\":\"WGMJUTZBBY_DIV\",\"tabindex\":\"47\",\"type\":\"Label\",\"value\":\"Stato di residenza:\",\"w\":\"120\",\"x\":\"24\",\"y\":\"186\",\"zone\":\"XLVFHSOSYH_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"MacroAgente_\",\"page\":\"1\",\"spuid\":\"JLHFWAWERN_DIV\",\"tabindex\":\"48\",\"type\":\"Label\",\"value\":\"MacroAgente:\",\"w\":\"74\",\"x\":\"70\",\"y\":\"242\",\"zone\":\"XLVFHSOSYH_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xmadescri\",\"page\":\"1\",\"spuid\":\"BUHXXVSCZH_DIV\",\"tabindex\":\"49\",\"type\":\"Label\",\"value\":\"w_xmadescri\",\"w\":\"416\",\"x\":\"224\",\"y\":\"242\",\"zone\":\"XLVFHSOSYH_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"NDG_Intestatario_\",\"page\":\"1\",\"spuid\":\"SKZNSKGZRP_DIV\",\"tabindex\":\"51\",\"type\":\"Label\",\"value\":\"NDG Intestatario:\",\"w\":\"107\",\"x\":\"37\",\"y\":\"46\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"File di Selezione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"60\",\"name\":\"nomefile\",\"page\":\"1\",\"spuid\":\"FPLBMQHLCU\",\"tabindex\":\"52\",\"type\":\"Textbox\",\"w\":\"352\",\"x\":\"144\",\"y\":\"294\",\"zone\":\"XLVFHSOSYH_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"File_di_Selezione_\",\"page\":\"1\",\"spuid\":\"QRXJMBXMQM_DIV\",\"tabindex\":\"53\",\"type\":\"Label\",\"value\":\"File di Selezione:\",\"w\":\"86\",\"x\":\"58\",\"y\":\"298\",\"zone\":\"XLVFHSOSYH_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_File_\",\"page\":\"1\",\"spuid\":\"PIFFTCKSCU_DIV\",\"tabindex\":\"54\",\"type\":\"Label\",\"value\":\"Tipo File:\",\"w\":\"47\",\"x\":\"577\",\"y\":\"298\",\"zone\":\"XLVFHSOSYH_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Dati Storici Soggetto\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgsto\",\"page\":\"1\",\"spuid\":\"LDWRKOVJHN\",\"tabindex\":\"56\",\"type\":\"Checkbox\",\"w\":\"118\",\"x\":\"624\",\"y\":\"41\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Output_\",\"page\":\"1\",\"spuid\":\"OJOGFQEVQE_DIV\",\"tabindex\":\"57\",\"type\":\"Label\",\"value\":\"Tipo Output:\",\"w\":\"67\",\"x\":\"77\",\"y\":\"377\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Estrazione_\",\"page\":\"1\",\"spuid\":\"QJBLEONCDX_DIV\",\"tabindex\":\"58\",\"type\":\"Label\",\"value\":\"Estrazione:\",\"w\":\"59\",\"x\":\"85\",\"y\":\"352\",\"zone\":\"XLVFHSOSYH_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cartella_Destinazione_\",\"page\":\"1\",\"spuid\":\"OBJZKBQZTK_DIV\",\"tabindex\":\"59\",\"type\":\"Label\",\"value\":\"Cartella Destinazione:\",\"w\":\"115\",\"x\":\"29\",\"y\":\"326\",\"zone\":\"XLVFHSOSYH_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgncf\",\"page\":\"1\",\"spuid\":\"VFBJBVZFDJ\",\"tabindex\":\"60\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"624\",\"y\":\"97\",\"zone\":\"XLVFHSOSYH_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"flgsegno\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"PBRMCZVHNN\",\"tabindex\":\"61\",\"textlist\":\"Segno Avere = SEND,Segno Dare = SEND\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":\"262\",\"x\":\"144\",\"y\":\"404\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Segno_\",\"page\":\"1\",\"spuid\":\"ZWFWRKARRA_DIV\",\"tabindex\":\"62\",\"type\":\"Label\",\"value\":\"Tipo Segno:\",\"w\":\"67\",\"x\":\"77\",\"y\":\"403\",\"zone\":\"XLVFHSOSYH_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_estrai_xlsBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_estrai_xlsBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_estrai_xlsBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),""),"page");
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
     "<script src='arpg_estrai_xls?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    l_cJsUid = SPPrxycizer.proxycizedPath("pageControls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_estrai_xls_proc.js'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/styleVariables.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calendar.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calculator.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    if (CPLib.ne(status.m_bAutoResize,"")) {
      status.out.println(
       "<script type='text/javascript'>" +
      "");
      status.out.println("var sv_WindowAutoResize = " + SPLib.ToJSValue(CPLib.eq(status.m_bAutoResize,"true"),"L",0,0)+ ";");
      status.out.println(
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
    status.out.println("AppletTag('HPar','Trs');");
    status.out.println("AppletTag('Batch');");
    status.out.println(
     "</script>" +
    "");
    status.m_cBodyAttributes = "onload=OnLoad() onhelp=CancelHelp()";
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false,true)";
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(523,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    status.out.println("AppletTag('Link');");
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    status.WriteSenderForm(entityGlobals,false);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
    status.out.println(
     "<script>" +
    "");
    if ( ! (CPLib.Empty(BO.LastErrorMessage()))) {
      status.out.println("var showed_error = "+SPLib.ToJSValue(BO.LastErrorMessage(),"L",0,0)+";");
      status.out.println("WindowAlert(showed_error);");
    }
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  void RaiseLoadedEntity(arpg_estrai_xlsBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_estrai_xlsBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(arpg_estrai_xlsBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(arpg_estrai_xlsBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(arpg_estrai_xlsBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_estrai_xlsBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
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
      arrt_start_estrai_xls.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_estrai_xlsBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_estrai_xlsBO BO) {
    boolean result = true;
    return result;
  }
}
