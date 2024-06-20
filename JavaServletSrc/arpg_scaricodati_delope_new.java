import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_scaricodati_delope_new extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*KFLJOVSEHR*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
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
    arpg_scaricodati_delope_newBO BO;
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
    return "Estrazione Deleghe/Operazioni Extraconto per Agenzia Entrate";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_scaricodati_delope_new";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 801;
    l_eg.m_nEntityHeight = 453;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"intermbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("anno","N",4,0, "edit",""),
                   new SPItem("mese","C",2,0, "edit",""),
                   new SPItem("darett","D",8,0, "edit",""),
                   new SPItem("a_rett","D",8,0, "edit",""),
                   new SPItem("dadata","D",8,0, "show",""),
                   new SPItem("a_data","D",8,0, "show",""),
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("CFINVIO","C",16,0, "edit","Codice Fiscale Organo Invio File"),
                   new SPItem("CAFINVIO","C",5,0, "edit","Codice CAF Organo Invio"),
                   new SPItem("FILEINVIO","C",1,0, "edit","Tipo Preparazione FIle"),
                   new SPItem("DATAINVIO","D",8,0, "edit","Data Impegno Organo Invio"),
                   new SPItem("sogest","C",1,0, "hide",""),
                   new SPItem("gDescAzi","C",70,0, "hide","Descrizione Intermediario"),
                   new SPItem("mespre","C",1,0, "edit","")
                 };
    l_eg.m_lExecuteAtStart = true;
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_scaricodati_delope_newBO BO) {
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
    l_translations=new String[][]{{"10061897561",p_Context.Translate("Stampa contenuto dei file creati")},
    {"10119011931",p_Context.Translate("La data fine periodo deve essere superiore a quella di inizo periodo")},
    {"10199548784",p_Context.Translate("Rettifica di codice fiscale per soggetti esteri")},
    {"10457981292",p_Context.Translate("Descrizione Intermediario")},
    {"10603009286",p_Context.Translate("Crea file come invio mese precedente a quello delle rettifiche")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11949617228",p_Context.Translate("Codice Fiscale Organo Invio File")},
    {"12090677005",p_Context.Translate("Visualizza file creati")},
    {"1345161769",p_Context.Translate("Impossibile selezionare un periodo precedente al 30/04/2007")},
    {"1710843353",p_Context.Translate("Data Impegno Organo Invio")},
    {"1718742585",p_Context.Translate("Estrazione Deleghe/Operazioni Extraconto per Agenzia Entrate")},
    {"346962755",p_Context.Translate("Codice CAF Organo Invio")},
    {"369093584",p_Context.Translate("L'utilizzo di questa maschera consente date dal 2008 in avanti")},
    {"603506633",p_Context.Translate("Tipo Preparazione FIle")}};
    return l_translations;
  }
  void WriteStyles(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_scaricodati_delope_new.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(448);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    status.out.println(
     "<div id='UZOTDDZZSQ_DIV' class='UntitledBox'>" +
     "<div id='UZOTDDZZSQ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='anno' id='GTMJENMCMN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_anno,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='mese' id='TCZMCNHUFI' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("01","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("01",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Gennaio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("02","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("02",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Febbraio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("03","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("03",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Marzo")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("04","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("04",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Aprile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("05","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("05",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maggio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("06","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("06",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Giugno")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("07","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("07",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Luglio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("08","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("08",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Agosto")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("09","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("09",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Settembre")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("10","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("10",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Ottobre")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("11","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("11",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Novembre")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("12","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("12",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Dicembre")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('TCZMCNHUFI'),w_mese,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='ZUXUDAETFH' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Crea Comunicazione Deleghe / Operazioni Extraconto"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='ZUXUDAETFH_Click()'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DMMJSVFBEV_DIV'>" +
     "<label id='DMMJSVFBEV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Estrazione mensile Deleghe/Operazioni Extraconto per Agenzia delle Entrate"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LJMNABGSBL_DIV'>" +
     "<label id='LJMNABGSBL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("- Comunicazione deleghe e/o operazioni extraconto mensili -"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='ALQVOOWZEV' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Crea Modifiche / Annullamento"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='ALQVOOWZEV_Click()'>" +
    "");
    status.out.println(
     "<div id='ZCSEKJZUCO_DIV' class='UntitledBox'>" +
     "<div id='ZCSEKJZUCO' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VKDDBMFRDF_DIV'>" +
     "<label id='VKDDBMFRDF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("N.B.: I NOMI DEI FILE CREATI NON DEVONO ESSERE MODIFICATI PER NESSUN MOTIVO !!!"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LOFHMITIDO_DIV'>" +
     "<label id='LOFHMITIDO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Selezione Rettifiche / Cancellazioni"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='darett' id='CFLYSPTTDU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_darett,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='CFLYSPTTDU_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='CFLYSPTTDU_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WUVFEJTHRU_DIV'>" +
     "<label id='WUVFEJTHRU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='a_rett' id='DIUBYKKRGY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_a_rett,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='DIUBYKKRGY_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DIUBYKKRGY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PKXDCHNEXM_DIV'>" +
     "<label id='PKXDCHNEXM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='dadata' id='FSXHJAAZGG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_dadata,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NOYEUIKFXN_DIV'>" +
     "<label id='NOYEUIKFXN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='a_data' id='CLVVMIYSQG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_a_data,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LFJQIXRRKM_DIV'>" +
     "<label id='LFJQIXRRKM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YIXZTOKOBR_DIV'>" +
     "<label id='YIXZTOKOBR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Anno:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TTKGEZTDBH_DIV'>" +
     "<label id='TTKGEZTDBH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mese:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_CUBHMYHWXO()' tabindex='-1' id='CUBHMYHWXO_HREF'>" +
     "<img id='CUBHMYHWXO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_JBNBDKBIAJ()' tabindex='-1' id='JBNBDKBIAJ_HREF'>" +
     "<img id='JBNBDKBIAJ' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza file creati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Visualizza file creati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UDOTRXKADP_DIV' style='display:none'>" +
     "<label id='UDOTRXKADP'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione' name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='XKCJRWEKFU_DIV' class='UntitledBox'>" +
     "<div id='XKCJRWEKFU' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UFZQBBFAGD_DIV'>" +
     "<label id='UFZQBBFAGD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dati Impegno Alla Presentazione Telematica"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CFINVIO' id='MPIOZQPPPI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CFINVIO,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CTFPYTZIIH_DIV'>" +
     "<label id='CTFPYTZIIH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale Organo Invio File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CAFINVIO' id='YFPMFPWESC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAFINVIO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LASRRWOCQH_DIV'>" +
     "<label id='LASRRWOCQH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice CAF Organo Invio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='FILEINVIO' id='HMYRBXBREF' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FILEINVIO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Comunicazione predisposta da contribuente")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_FILEINVIO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Comunicazione predisposta da chi effettua la trasmissione")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('HMYRBXBREF'),w_FILEINVIO,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HAINTPIJUS_DIV'>" +
     "<label id='HAINTPIJUS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Preparazione FIle:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DATAINVIO' id='CQATNPZMEC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAINVIO,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FHSMWCMRII_DIV'>" +
     "<label id='FHSMWCMRII'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Impegno Organo Invio:"))+"" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_MPCMAMHQST()' tabindex='-1' id='MPCMAMHQST_HREF'>" +
     "<img id='MPCMAMHQST' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Stampa contenuto dei file creati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Stampa contenuto dei file creati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<div id='UABNRUNBPR_DIV' class='UntitledBox'>" +
     "<div id='UABNRUNBPR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='MOHZUWAWZD_DIV'>" +
     "<input name='mespre' id='MOHZUWAWZD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_mespre,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_mespre))?"CHECKED":"")+">" +
     "<label id='MOHZUWAWZD_LBL' for='MOHZUWAWZD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea file come invio mese precedente a quello delle rettifiche"))+"</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_scaricodati_delope_newBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_scaricodati_delope_newBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_scaricodati_delope_newBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_anno,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mese,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_darett,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a_rett,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dadata,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a_data,"D",8,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0)+","+SPLib.ToJSValue(BO.o_gIntemediario,"C",11,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_CFINVIO,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAFINVIO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FILEINVIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAINVIO,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_sogest,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDescAzi,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mespre,"C",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_UDOTRXKADP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(453,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(801,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_scaricodati_delope_new"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'AHMXEPADOR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODINTERCODINTER,CFINVIO,CAFINVIO,FILEINVIO,DATAINVIOC,C,C,C,Dintermbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_scaricodati_delope_new","");
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
  void WriteMainFormScript(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_scaricodati_delope_new");
    status.out.println("function Elabora2() {");
    status.out.println("  if (confirm('Confermi la generazione del file delle modifiche ?')) {");
    status.out.println("    w_bloccaedit = 'S';");
    status.out.println("    EnableControlsUnderCondition();");
    status.out.println("    SetLocationHref(null,'arrt_sd_modifiche_delope'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')   ");
    status.out.println("  }    ");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_scaricodati_delope_newBO getBO(ServletStatus status) {
    arpg_scaricodati_delope_newBO BO = new arpg_scaricodati_delope_newBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_scaricodati_delope_newBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
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
  void Discard(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",453);
    item.put("w",801);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_scaricodati_delope_new");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"441\",\"name\":\"Box_UZOTDDZZSQ\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"UZOTDDZZSQ\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"7\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"anno\",\"page\":\"1\",\"spuid\":\"GTMJENMCMN\",\"tabindex\":\"2\",\"type\":\"Textbox\",\"w\":\"36\",\"x\":\"56\",\"y\":\"77\",\"zone\":\"UZOTDDZZSQ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"mese\",\"page\":\"1\",\"spuid\":\"TCZMCNHUFI\",\"tabindex\":\"3\",\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"01"+"'"+","+"'"+"02"+"'"+","+"'"+"03"+"'"+","+"'"+"04"+"'"+","+"'"+"05"+"'"+","+"'"+"06"+"'"+","+"'"+"07"+"'"+","+"'"+"08"+"'"+","+"'"+"09"+"'"+","+"'"+"10"+"'"+","+"'"+"11"+"'"+","+"'"+"12"+"'"+"\",\"w\":\"112\",\"x\":\"136\",\"y\":\"77\",\"zone\":\"UZOTDDZZSQ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:ZUXUDAETFH_Click()\",\"name\":\"Crea_Comunicazione_Deleghe___Operazioni_Extraconto\",\"page\":\"1\",\"spuid\":\"ZUXUDAETFH\",\"tabindex\":\"4\",\"type\":\"Button\",\"value\":\"Crea Comunicazione Deleghe \\/ Operazioni Extraconto\",\"w\":\"302\",\"x\":\"472\",\"y\":\"70\",\"zone\":\"UZOTDDZZSQ_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Estrazione_mensile_Deleghe_Operazioni_Extraconto_per_Agenzia_delle_Entrate\",\"page\":\"1\",\"spuid\":\"DMMJSVFBEV_DIV\",\"tabindex\":\"5\",\"type\":\"Label\",\"value\":\"Estrazione mensile Deleghe\\/Operazioni Extraconto per Agenzia delle Entrate\",\"w\":\"760\",\"x\":\"16\",\"y\":\"14\",\"zone\":\"UZOTDDZZSQ_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"__Comunicazione_deleghe_e_o_operazioni_extraconto_mensili__\",\"page\":\"1\",\"spuid\":\"LJMNABGSBL_DIV\",\"tabindex\":\"6\",\"type\":\"Label\",\"value\":\"- Comunicazione deleghe e\\/o operazioni extraconto mensili -\",\"w\":\"760\",\"x\":\"16\",\"y\":\"35\",\"zone\":\"UZOTDDZZSQ_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:ALQVOOWZEV_Click()\",\"name\":\"Crea_Modifiche___Annullamento\",\"page\":\"1\",\"spuid\":\"ALQVOOWZEV\",\"tabindex\":\"7\",\"type\":\"Button\",\"value\":\"Crea Modifiche \\/ Annullamento\",\"w\":\"210\",\"x\":\"568\",\"y\":\"154\",\"zone\":\"UZOTDDZZSQ_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"name\":\"Box_ZCSEKJZUCO\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"ZCSEKJZUCO\",\"tabindex\":\"8\",\"type\":\"Box\",\"w\":\"760\",\"x\":\"16\",\"y\":\"322\",\"zone\":\"UZOTDDZZSQ_18\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"N_B___I_NOMI_DEI_FILE_CREATI_NON_DEVONO_ESSERE_MODIFICATI_PER_NESSUN_MOTIVO____\",\"page\":\"1\",\"spuid\":\"VKDDBMFRDF_DIV\",\"tabindex\":\"9\",\"type\":\"Label\",\"value\":\"N.B.: I NOMI DEI FILE CREATI NON DEVONO ESSERE MODIFICATI PER NESSUN MOTIVO !!!\",\"w\":\"744\",\"x\":\"24\",\"y\":\"329\",\"zone\":\"ZCSEKJZUCO_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Selezione_Rettifiche___Cancellazioni\",\"page\":\"1\",\"spuid\":\"LOFHMITIDO_DIV\",\"tabindex\":\"10\",\"type\":\"Label\",\"value\":\"Selezione Rettifiche \\/ Cancellazioni\",\"w\":\"760\",\"x\":\"16\",\"y\":\"126\",\"zone\":\"UZOTDDZZSQ_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"darett\",\"page\":\"1\",\"spuid\":\"CFLYSPTTDU\",\"tabindex\":\"11\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"72\",\"y\":\"154\",\"zone\":\"UZOTDDZZSQ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_\",\"page\":\"1\",\"spuid\":\"WUVFEJTHRU_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"43\",\"x\":\"24\",\"y\":\"158\",\"zone\":\"UZOTDDZZSQ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"a_rett\",\"page\":\"1\",\"spuid\":\"DIUBYKKRGY\",\"tabindex\":\"13\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"248\",\"y\":\"154\",\"zone\":\"UZOTDDZZSQ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_\",\"page\":\"1\",\"spuid\":\"PKXDCHNEXM_DIV\",\"tabindex\":\"14\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"43\",\"x\":\"200\",\"y\":\"158\",\"zone\":\"UZOTDDZZSQ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"dadata\",\"page\":\"1\",\"spuid\":\"FSXHJAAZGG\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"312\",\"y\":\"63\",\"zone\":\"UZOTDDZZSQ_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_\",\"page\":\"1\",\"spuid\":\"NOYEUIKFXN_DIV\",\"tabindex\":\"16\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"43\",\"x\":\"264\",\"y\":\"67\",\"zone\":\"UZOTDDZZSQ_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"a_data\",\"page\":\"1\",\"spuid\":\"CLVVMIYSQG\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"312\",\"y\":\"91\",\"zone\":\"UZOTDDZZSQ_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_\",\"page\":\"1\",\"spuid\":\"LFJQIXRRKM_DIV\",\"tabindex\":\"18\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"43\",\"x\":\"264\",\"y\":\"95\",\"zone\":\"UZOTDDZZSQ_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Anno_\",\"page\":\"1\",\"spuid\":\"YIXZTOKOBR_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Anno:\",\"w\":\"29\",\"x\":\"23\",\"y\":\"81\",\"zone\":\"UZOTDDZZSQ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Mese_\",\"page\":\"1\",\"spuid\":\"TTKGEZTDBH_DIV\",\"tabindex\":\"20\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"29\",\"x\":\"103\",\"y\":\"81\",\"zone\":\"UZOTDDZZSQ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_CUBHMYHWXO()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"CUBHMYHWXO\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"21\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"736\",\"y\":\"196\",\"zone\":\"UZOTDDZZSQ_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Visualizza file creati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_JBNBDKBIAJ()\",\"name\":\"images_search_gif\",\"page\":\"1\",\"spuid\":\"JBNBDKBIAJ\",\"src\":\"images\\/search.gif\",\"tabindex\":\"22\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"688\",\"y\":\"196\",\"zone\":\"UZOTDDZZSQ_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione__name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"UDOTRXKADP_DIV\",\"tabindex\":\"23\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+" name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"16\",\"x\":\"20\",\"y\":\"14\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"1\",\"name\":\"Box_XKCJRWEKFU\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"XKCJRWEKFU\",\"tabindex\":\"25\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"231\",\"zone\":\"UZOTDDZZSQ_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Dati_Impegno_Alla_Presentazione_Telematica\",\"page\":\"1\",\"spuid\":\"UFZQBBFAGD_DIV\",\"tabindex\":\"26\",\"type\":\"Label\",\"value\":\"Dati Impegno Alla Presentazione Telematica\",\"w\":\"776\",\"x\":\"8\",\"y\":\"238\",\"zone\":\"UZOTDDZZSQ_17\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Codice Fiscale Organo Invio File\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"CFINVIO\",\"page\":\"1\",\"spuid\":\"MPIOZQPPPI\",\"tabindex\":\"27\",\"type\":\"Textbox\",\"w\":\"128\",\"x\":\"176\",\"y\":\"259\",\"zone\":\"UZOTDDZZSQ_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Fiscale_Organo_Invio_File_\",\"page\":\"1\",\"spuid\":\"CTFPYTZIIH_DIV\",\"tabindex\":\"28\",\"type\":\"Label\",\"value\":\"Codice Fiscale Organo Invio File:\",\"w\":\"156\",\"x\":\"20\",\"y\":\"263\",\"zone\":\"UZOTDDZZSQ_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Codice CAF Organo Invio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"CAFINVIO\",\"page\":\"1\",\"spuid\":\"YFPMFPWESC\",\"tabindex\":\"29\",\"type\":\"Textbox\",\"w\":\"48\",\"x\":\"616\",\"y\":\"259\",\"zone\":\"UZOTDDZZSQ_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_CAF_Organo_Invio_\",\"page\":\"1\",\"spuid\":\"LASRRWOCQH_DIV\",\"tabindex\":\"30\",\"type\":\"Label\",\"value\":\"Codice CAF Organo Invio:\",\"w\":\"125\",\"x\":\"491\",\"y\":\"263\",\"zone\":\"UZOTDDZZSQ_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Tipo Preparazione FIle\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"FILEINVIO\",\"page\":\"1\",\"spuid\":\"HMYRBXBREF\",\"tabindex\":\"31\",\"textlist\":\"Comunicazione predisposta da contribuente,Comunicazione predisposta da chi effettua la trasmissione\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":\"264\",\"x\":\"176\",\"y\":\"287\",\"zone\":\"UZOTDDZZSQ_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Preparazione_FIle_\",\"page\":\"1\",\"spuid\":\"HAINTPIJUS_DIV\",\"tabindex\":\"32\",\"type\":\"Label\",\"value\":\"Tipo Preparazione FIle:\",\"w\":\"111\",\"x\":\"65\",\"y\":\"291\",\"zone\":\"UZOTDDZZSQ_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Data Impegno Organo Invio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DATAINVIO\",\"page\":\"1\",\"spuid\":\"CQATNPZMEC\",\"tabindex\":\"33\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"616\",\"y\":\"287\",\"zone\":\"UZOTDDZZSQ_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Data_Impegno_Organo_Invio_\",\"page\":\"1\",\"spuid\":\"FHSMWCMRII_DIV\",\"tabindex\":\"34\",\"type\":\"Label\",\"value\":\"Data Impegno Organo Invio:\",\"w\":\"138\",\"x\":\"478\",\"y\":\"291\",\"zone\":\"UZOTDDZZSQ_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"357\",\"zone\":\"UZOTDDZZSQ_19\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stampa contenuto dei file creati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_MPCMAMHQST()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"MPCMAMHQST\",\"src\":\"images\\/print.gif\",\"tabindex\":\"37\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"640\",\"y\":\"196\",\"zone\":\"UZOTDDZZSQ_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"1\",\"name\":\"Box_UABNRUNBPR\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"UABNRUNBPR\",\"tabindex\":\"39\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"119\",\"zone\":\"UZOTDDZZSQ_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"mespre\",\"page\":\"1\",\"spuid\":\"MOHZUWAWZD\",\"tabindex\":\"40\",\"type\":\"Checkbox\",\"w\":\"328\",\"x\":\"288\",\"y\":\"196\",\"zone\":\"UZOTDDZZSQ_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
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
     "<script src='arpg_scaricodati_delope_new?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_scaricodati_delope_new_proc.js'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_sd_modifiche_delope.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
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
    status.themeWriter.WriteBody_Begin(453,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_scaricodati_delope_newBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_scaricodati_delope_newBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_sd_modifiche_delope.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_finemese.m_cEntityUid+"/arfn_finemese.js'>" +
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
      arfn_finemese.GetCallableNames(callable);
      arrt_sd_aprichiudi_delope.GetCallableNames(callable);
      CPLib.AddToSet(callable,"arrt_sd_modifiche_delope");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_scaricodati_delope_newBO BO) {
    boolean result = true;
    return result;
  }
}
