import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_discouic_rilievi extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*RKKSIPEJVH*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("DaDatOpe",source.GetCaller().GetDate("DaDatOpe","D",8,0));
      source.SetParameter("ADatOpe",source.GetCaller().GetDate("ADatOpe","D",8,0));
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
    arpg_discouic_rilieviBO BO;
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
    return "Stampa Operazioni Rilievi Dati Aggregati (XBRL)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_discouic_rilievi";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 781;
    l_eg.m_nEntityHeight = 896;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"anadip","tbstati","tbcausin","tbsetsin"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("anno","N",4,0, "edit","Anno"),
                   new SPItem("mese","C",2,0, "edit","Mese"),
                   new SPItem("TipoOper","C",2,0, "edit","Tipo Operazione"),
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("DaDatOpe","D",8,0, "show","Da Data Operazione"),
                   new SPItem("ADatOpe","D",8,0, "show","A Data Operazione"),
                   new SPItem("rcoddip","C",6,0, "edit","Codice Dipendenza/Agenzia"),
                   new SPItem("xdesdip","C",30,0, "hide","Descrizione"),
                   new SPItem("rabicab","C",12,0, "edit","ABI + CAB Dipendenza"),
                   new SPItem("rcabdip","C",6,0, "edit","CAB Dipendenza"),
                   new SPItem("rpaecli","C",3,0, "edit","Paese Cliente"),
                   new SPItem("xpaesecli","C",40,0, "hide","Descrizione"),
                   new SPItem("rcabcli","C",6,0, "edit","CAB Cliente"),
                   new SPItem("rcodvoc","C",2,0, "edit","Causale Aggregata"),
                   new SPItem("xdescau","C",165,0, "hide","Descrizione"),
                   new SPItem("rflglire","C",1,0, "edit","Valuta"),
                   new SPItem("rsegno","C",1,0, "edit","Segno"),
                   new SPItem("rsetsin","C",3,0, "edit","Settorizzazione Sintetica"),
                   new SPItem("rpaecon","C",3,0, "edit","Paese Controparte"),
                   new SPItem("rcabcon","C",6,0, "edit","CAB Controparte"),
                   new SPItem("rpaeint","C",3,0, "edit","Paese Int. Controparte"),
                   new SPItem("rcabint","C",6,0, "edit","CAB Int. Controparte"),
                   new SPItem("xpaeseint","C",40,0, "hide","Descrizione"),
                   new SPItem("xpaesecon","C",40,0, "hide","Descrizione"),
                   new SPItem("xdesset","C",200,0, "hide","Descrizione")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_discouic_rilieviBO BO) {
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
    l_translations=new String[][]{{"10198810383",p_Context.Translate("Esecuzione trasferimento dati da provvisorie a definitive")},
    {"10302774925",p_Context.Translate("Paese Controparte")},
    {"10513349907",p_Context.Translate("Settorizazione Sintetica")},
    {"10775068380",p_Context.Translate("CAB Int. Controparte")},
    {"10844696278",p_Context.Translate("Stampa Operazioni/Frazionate")},
    {"10846498013",p_Context.Translate("Paese Int. Controparte")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10911345311",p_Context.Translate("Da Data Operazione")},
    {"109822566",p_Context.Translate("Valuta")},
    {"11073368319",p_Context.Translate("CAB Cliente")},
    {"1112132021",p_Context.Translate("la data di fine periodo deve essere superiore a quella di inizio periodo")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11472643172",p_Context.Translate("Stampa Operazioni Rilievi Dati Aggregati (XBRL)")},
    {"11933509554",p_Context.Translate("Codice Dipendenza/Agenzia")},
    {"167425256",p_Context.Translate("ABI + CAB Dipendenza")},
    {"1822089062",p_Context.Translate("A Data Operazione")},
    {"282420974",p_Context.Translate("Causali Sintetiche")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"335886693",p_Context.Translate("Causale Aggregata")},
    {"444829",p_Context.Translate("Mese")},
    {"484641",p_Context.Translate("Anno")},
    {"496599153",p_Context.Translate("Settorizzazione Sintetica")},
    {"551482149",p_Context.Translate("Agenzie / Dipendenze")},
    {"569232821",p_Context.Translate("CAB Controparte")},
    {"718315030",p_Context.Translate("La data di inizio periodo deve essere minore di quella fine periodo e superiore al 31-12-2011")},
    {"7383187",p_Context.Translate("Stati")},
    {"7753123",p_Context.Translate("Segno")},
    {"829257574",p_Context.Translate("Tipo Operazione")},
    {"98127897",p_Context.Translate("Paese Cliente")},
    {"984756930",p_Context.Translate("Tipo Intermediario")}};
    return l_translations;
  }
  void WriteStyles(arpg_discouic_rilieviBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_discouic_rilievi.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_discouic_rilieviBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_discouic_rilieviBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_discouic_rilieviBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_discouic_rilieviBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_discouic_rilieviBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(891);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_discouic_rilieviBO BO,ServletStatus status) {
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='anno' id='INCSNNUWOV' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_anno,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N' onkeypress=''>" +
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
     "<select name='TipoOper' id='PRCVTCPVCB' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("AI","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("AI",CPLib.Trim(BO.w_TipoOper))?"SELECTED":"")+">" +
     ""+status.context.Translate("SARA_BONIFICIALTRIITALIA")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("AE","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("AE",CPLib.Trim(BO.w_TipoOper))?"SELECTED":"")+">" +
     ""+status.context.Translate("SARA_BONIFICIALTRIESTERI")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("AO","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("AO",CPLib.Trim(BO.w_TipoOper))?"SELECTED":"")+">" +
     ""+status.context.Translate("SARA_ALTREOPERAZIONIALTRI")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("BI","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("BI",CPLib.Trim(BO.w_TipoOper))?"SELECTED":"")+">" +
     ""+status.context.Translate("SARA_BONIFICIBANCHE")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("BE","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("BE",CPLib.Trim(BO.w_TipoOper))?"SELECTED":"")+">" +
     ""+status.context.Translate("SARA_BONIFICIESTERI")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("BO","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("BO",CPLib.Trim(BO.w_TipoOper))?"SELECTED":"")+">" +
     ""+status.context.Translate("SARA_ALTREOPERAZIONI")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('PRCVTCPVCB'),w_TipoOper,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HPGJXQIVYG_DIV'>" +
     "<label id='HPGJXQIVYG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Anno:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='DaDatOpe' id='DPKVLWHCIG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DaDatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.out.println(
     "<input name='ADatOpe' id='MTJDZQTEIR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_ADatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_ZQEKBHAOQV()' tabindex='-1' id='ZQEKBHAOQV_HREF'>" +
     "<img id='ZQEKBHAOQV' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Esecuzione trasferimento dati da provvisorie a definitive"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Esecuzione trasferimento dati da provvisorie a definitive"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LICLPYJEJC_DIV'>" +
     "<label id='LICLPYJEJC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("PERIODO ESTRAZIONE OPERAZIONI"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_SNWBSRFWZT()' tabindex='-1' id='SNWBSRFWZT_HREF'>" +
     "<img id='SNWBSRFWZT' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Stampa Operazioni/Frazionate"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Stampa Operazioni/Frazionate"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='750' height='350' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
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
     "<div id='KQMKKBMXYE'>" +
    "");
    // GetPortlet_Log_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_KQMKKBMXYE;
    inclusionVars_KQMKKBMXYE = GetPortlet_KQMKKBMXYE_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_KQMKKBMXYE);
    String portletUID_KQMKKBMXYE = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+ portletUID_KQMKKBMXYE+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_KQMKKBMXYE),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.KQMKKBMXYE='"+portletUID_KQMKKBMXYE+"';" +
     "w_Log=ZtVWeb.getPortletById('"+portletUID_KQMKKBMXYE+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WUMEQIJBBJ_DIV'>" +
     "<label id='WUMEQIJBBJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("DATI AGGREGAZIONE DA RILIEVI"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GWMNZLYKOI_DIV'>" +
     "<label id='GWMNZLYKOI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rcoddip' id='OLAQSOZFCY' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rcoddip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='OLAQSOZFCY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='OLAQSOZFCY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JSTXFKSRUI_DIV'>" +
     "<label id='JSTXFKSRUI'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesdip)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rabicab' id='JGTODNXAVD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_rabicab,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RLTRRXKDVL_DIV'>" +
     "<label id='RLTRRXKDVL' for='JGTODNXAVD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ABI + CAB Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rcabdip' id='FMRCIWUEYR' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rcabdip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IAWXCLXXBQ_DIV'>" +
     "<label id='IAWXCLXXBQ' for='FMRCIWUEYR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rpaecli' id='UGMSDYOXMM' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rpaecli,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='UGMSDYOXMM_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UGMSDYOXMM_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MCSVMXGCHX_DIV'>" +
     "<label id='MCSVMXGCHX' for='UGMSDYOXMM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese Residenza Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XEUVCTYSYZ_DIV'>" +
     "<label id='XEUVCTYSYZ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xpaesecli)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rcabcli' id='GUVXBUJIEG' type='text' class='"+status.ObligatoryClass("Field",BO.GUVXBUJIEG_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_rcabcli,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MALQXATPGL_DIV'>" +
     "<label id='MALQXATPGL' for='GUVXBUJIEG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB Residenza Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rcodvoc' id='OZZYALMUYP' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rcodvoc,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='OZZYALMUYP_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='OZZYALMUYP_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AAENYRICVA_DIV'>" +
     "<label id='AAENYRICVA' for='OZZYALMUYP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Causale Aggregata:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KFXGDEJPQJ_DIV'>" +
     "<label id='KFXGDEJPQJ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdescau)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='rflglire' id='EVPCVZMBLL' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_rflglire))?"SELECTED":"")+">" +
     ""+status.context.Translate("Euro (3)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("4","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("4",CPLib.Trim(BO.w_rflglire))?"SELECTED":"")+">" +
     ""+status.context.Translate("Altra Valuta (4)")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('EVPCVZMBLL'),w_rflglire,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OOGZQWLABP_DIV'>" +
     "<label id='OOGZQWLABP' for='EVPCVZMBLL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valuta:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='rsegno' id='KUXBYNJIYY' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_rsegno))?"SELECTED":"")+">" +
     ""+status.context.Translate("Dare (D)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_rsegno))?"SELECTED":"")+">" +
     ""+status.context.Translate("Avere (A)")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('KUXBYNJIYY'),w_rsegno,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rsetsin' id='BOULPRIMLA' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rsetsin,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='BOULPRIMLA_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='BOULPRIMLA_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WFRNOUHQRD_DIV'>" +
     "<label id='WFRNOUHQRD' for='KUXBYNJIYY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Segno:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rpaecon' id='NJAIUIFRCH' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rpaecon,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='NJAIUIFRCH_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='NJAIUIFRCH_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HWSYIMZFAL_DIV'>" +
     "<label id='HWSYIMZFAL' for='NJAIUIFRCH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QIAJXTAKFW_DIV'>" +
     "<label id='QIAJXTAKFW'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xpaesecon)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rcabcon' id='RFAXHNVDNI' type='text' class='"+status.ObligatoryClass("Field",BO.RFAXHNVDNI_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_rcabcon,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IAOBJXLZTI_DIV'>" +
     "<label id='IAOBJXLZTI' for='RFAXHNVDNI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rpaeint' id='QWUXFRTCAK' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_rpaeint,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='QWUXFRTCAK_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='QWUXFRTCAK_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SVHHVTOUWB_DIV'>" +
     "<label id='SVHHVTOUWB' for='QWUXFRTCAK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese Int. Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BACOVSPFFU_DIV'>" +
     "<label id='BACOVSPFFU'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xpaeseint)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='rcabint' id='IYVNYANIYW' type='text' class='"+status.ObligatoryClass("Field",BO.IYVNYANIYW_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_rcabint,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EBMFNEDGHG_DIV'>" +
     "<label id='EBMFNEDGHG' for='IYVNYANIYW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB Int. Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HNXOTOMWCA_DIV'>" +
     "<label id='HNXOTOMWCA' for='BOULPRIMLA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Settorizzazione Sintetica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TTTIJIGSTS_DIV'>" +
     "<label id='TTTIJIGSTS'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesset)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JCKMEQWFOM_DIV'>" +
     "<label id='JCKMEQWFOM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mese:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HLPEMESXOO_DIV'>" +
     "<label id='HLPEMESXOO' for='PRCVTCPVCB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_URPSVVEIFI()' tabindex='-1' style='display:none' id='URPSVVEIFI_HREF'>" +
     "<img id='URPSVVEIFI' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Stampa Operazioni/Frazionate"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Stampa Operazioni/Frazionate"),"C",0,0)+">" +
     "</a>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_discouic_rilieviBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_discouic_rilieviBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_discouic_rilieviBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_anno,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mese,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TipoOper,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaDatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rcoddip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rabicab,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rcabdip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rpaecli,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xpaesecli,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rcabcli,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rcodvoc,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescau,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rflglire,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rsegno,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rsetsin,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rpaecon,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rcabcon,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rpaeint,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rcabint,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xpaeseint,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xpaesecon,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesset,"C",200,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_discouic_rilieviBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_FGMOCXNBFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JSTXFKSRUI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XEUVCTYSYZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KFXGDEJPQJ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QIAJXTAKFW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BACOVSPFFU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TTTIJIGSTS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(896,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(781,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_discouic_rilievi"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'OLAQSOZFCY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZ,CAB,ABICABSARAC,C,C,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    status.out.print(",'UGMSDYOXMM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'OZZYALMUYP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODVOCCODVOC,DESCRIZC,Ctbcausin",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
    status.out.print(",'BOULPRIMLA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("SETSINTSETSINT,DESCRIC,Ctbsetsin",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
    status.out.print(",'NJAIUIFRCH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'QWUXFRTCAK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_discouic_rilievi","");
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
  void WriteMainFormScript(arpg_discouic_rilieviBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_discouic_rilievi");
    status.out.println("function LanciaRep() {");
    status.out.println("  _lancia=Check()");
    status.out.println("  if (_lancia) {");
    status.out.println("    if (w_rpaecli=='086' && Empty(w_rcabcli)) {");
    status.out.println("      alert('Obbligatorio inserire il cab di residenza del cliente!')");
    status.out.println("      _lancia=false");
    status.out.println("    }  ");
    status.out.println("    if (_lancia) {");
    status.out.println("      _modifyandopen('arrt_discouic_rilievi'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)");
    status.out.println("    }");
    status.out.println("  } else {");
    status.out.println("    if (!Empty(LRTrim(m_cLastWorkVarErrorMsg))) {");
    status.out.println("      alert('Campo Obbligatorio: ' + AlertErrorMessage(m_cLastWorkVarErrorMsg))");
    status.out.println("    }  ");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("");
    status.out.println("function Lancio() {");
    status.out.println("  w_Log.Timer0.Start()");
    status.out.println("  w_Messaggi.Timer0.Start()");
    status.out.println("  href_URPSVVEIFI()  ");
    status.out.println("}  ");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_discouic_rilieviBO getBO(ServletStatus status) {
    arpg_discouic_rilieviBO BO = new arpg_discouic_rilieviBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_discouic_rilieviBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_discouic_rilieviBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_discouic_rilieviBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_discouic_rilieviBO BO) {
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
  void Discard(ServletStatus status,arpg_discouic_rilieviBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_discouic_rilieviBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",896);
    item.put("w",781);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_discouic_rilievi");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"class_Css\":\" \",\"comment\":\"Anno\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"anno\",\"page\":\"1\",\"spuid\":\"INCSNNUWOV\",\"tabindex\":\"1\",\"type\":\"Textbox\",\"w\":\"48\",\"x\":\"152\",\"y\":\"36\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Mese\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"mese\",\"page\":\"1\",\"spuid\":\"TCZMCNHUFI\",\"tabindex\":\"2\",\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"01"+"'"+","+"'"+"02"+"'"+","+"'"+"03"+"'"+","+"'"+"04"+"'"+","+"'"+"05"+"'"+","+"'"+"06"+"'"+","+"'"+"07"+"'"+","+"'"+"08"+"'"+","+"'"+"09"+"'"+","+"'"+"10"+"'"+","+"'"+"11"+"'"+","+"'"+"12"+"'"+"\",\"w\":\"152\",\"x\":\"264\",\"y\":\"36\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Tipo Operazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"TipoOper\",\"page\":\"1\",\"spuid\":\"PRCVTCPVCB\",\"tabindex\":\"3\",\"textlist\":\"SARA_BONIFICIALTRIITALIA,SARA_BONIFICIALTRIESTERI,SARA_ALTREOPERAZIONIALTRI,SARA_BONIFICIBANCHE,SARA_BONIFICIESTERI,SARA_ALTREOPERAZIONI\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"AI"+"'"+","+"'"+"AE"+"'"+","+"'"+"AO"+"'"+","+"'"+"BI"+"'"+","+"'"+"BE"+"'"+","+"'"+"BO"+"'"+"\",\"w\":\"528\",\"x\":\"152\",\"y\":\"90\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Anno_\",\"page\":\"1\",\"spuid\":\"HPGJXQIVYG_DIV\",\"tabindex\":\"6\",\"type\":\"Label\",\"value\":\"Anno:\",\"w\":\"132\",\"x\":\"20\",\"y\":\"40\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Da Data Operazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaDatOpe\",\"page\":\"1\",\"spuid\":\"DPKVLWHCIG\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"448\",\"y\":\"36\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"A Data Operazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"ADatOpe\",\"page\":\"1\",\"spuid\":\"MTJDZQTEIR\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"536\",\"y\":\"36\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Esecuzione trasferimento dati da provvisorie a definitive\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"31\",\"href\":\"javascript:href_ZQEKBHAOQV()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"ZQEKBHAOQV\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"9\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"736\",\"y\":\"16\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"PERIODO_ESTRAZIONE_OPERAZIONI\",\"page\":\"1\",\"spuid\":\"LICLPYJEJC_DIV\",\"tabindex\":\"10\",\"type\":\"Label\",\"value\":\"PERIODO ESTRAZIONE OPERAZIONI\",\"w\":\"213\",\"x\":\"13\",\"y\":\"15\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stampa Operazioni\\/Frazionate\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"31\",\"href\":\"javascript:href_SNWBSRFWZT()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"SNWBSRFWZT\",\"src\":\"images\\/print.gif\",\"tabindex\":\"11\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"688\",\"y\":\"16\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"315\",\"href\":\" \",\"name\":\"__iframe_width__750__height__350__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"750"+"'"+" height="+"'"+"350"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"760\",\"x\":\"16\",\"y\":\"576\",\"zone\":\"pag1_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"486\",\"zone\":\"pag1_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"147\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"333\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"DATI_AGGREGAZIONE_DA_RILIEVI\",\"page\":\"1\",\"spuid\":\"WUMEQIJBBJ_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"DATI AGGREGAZIONE DA RILIEVI\",\"w\":\"200\",\"x\":\"13\",\"y\":\"69\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Dipendenza_\",\"page\":\"1\",\"spuid\":\"GWMNZLYKOI_DIV\",\"tabindex\":\"16\",\"type\":\"Label\",\"value\":\"Codice Dipendenza:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"121\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Codice Dipendenza\\/Agenzia\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"rcoddip\",\"page\":\"1\",\"spuid\":\"OLAQSOZFCY\",\"tabindex\":\"17\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"152\",\"y\":\"117\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesdip\",\"page\":\"1\",\"spuid\":\"JSTXFKSRUI_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"w_xdesdip\",\"w\":\"232\",\"x\":\"232\",\"y\":\"121\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"ABI + CAB Dipendenza\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"12\",\"name\":\"rabicab\",\"page\":\"1\",\"spuid\":\"JGTODNXAVD\",\"tabindex\":\"20\",\"type\":\"Textbox\",\"w\":\"96\",\"x\":\"600\",\"y\":\"117\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"ABI___CAB_Dipendenza_\",\"page\":\"1\",\"spuid\":\"RLTRRXKDVL_DIV\",\"tabindex\":\"21\",\"type\":\"Label\",\"value\":\"ABI + CAB Dipendenza:\",\"w\":\"125\",\"x\":\"475\",\"y\":\"121\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"CAB Dipendenza\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"rcabdip\",\"page\":\"1\",\"spuid\":\"FMRCIWUEYR\",\"tabindex\":\"22\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"152\",\"y\":\"144\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"CAB_Dipendenza_\",\"page\":\"1\",\"spuid\":\"IAWXCLXXBQ_DIV\",\"tabindex\":\"23\",\"type\":\"Label\",\"value\":\"CAB Dipendenza:\",\"w\":\"144\",\"x\":\"8\",\"y\":\"148\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Paese Cliente\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"rpaecli\",\"page\":\"1\",\"spuid\":\"UGMSDYOXMM\",\"tabindex\":\"24\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"152\",\"y\":\"171\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Paese_Residenza_Cliente_\",\"page\":\"1\",\"spuid\":\"MCSVMXGCHX_DIV\",\"tabindex\":\"25\",\"type\":\"Label\",\"value\":\"Paese Residenza Cliente:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"175\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xpaesecli\",\"page\":\"1\",\"spuid\":\"XEUVCTYSYZ_DIV\",\"tabindex\":\"26\",\"type\":\"Label\",\"value\":\"w_xpaesecli\",\"w\":\"252\",\"x\":\"217\",\"y\":\"175\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"CAB Cliente\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"rcabcli\",\"page\":\"1\",\"spuid\":\"GUVXBUJIEG\",\"tabindex\":\"28\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"600\",\"y\":\"171\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"CAB_Residenza_Cliente_\",\"page\":\"1\",\"spuid\":\"MALQXATPGL_DIV\",\"tabindex\":\"29\",\"type\":\"Label\",\"value\":\"CAB Residenza Cliente:\",\"w\":\"208\",\"x\":\"392\",\"y\":\"175\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Causale Aggregata\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"2\",\"name\":\"rcodvoc\",\"page\":\"1\",\"spuid\":\"OZZYALMUYP\",\"tabindex\":\"30\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"152\",\"y\":\"198\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Causale_Aggregata_\",\"page\":\"1\",\"spuid\":\"AAENYRICVA_DIV\",\"tabindex\":\"31\",\"type\":\"Label\",\"value\":\"Causale Aggregata:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"202\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdescau\",\"page\":\"1\",\"spuid\":\"KFXGDEJPQJ_DIV\",\"tabindex\":\"32\",\"type\":\"Label\",\"value\":\"w_xdescau\",\"w\":\"544\",\"x\":\"217\",\"y\":\"202\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Valuta\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"rflglire\",\"page\":\"1\",\"spuid\":\"EVPCVZMBLL\",\"tabindex\":\"34\",\"textlist\":\"Euro (3),Altra Valuta (4)\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"3"+"'"+","+"'"+"4"+"'"+"\",\"w\":\"136\",\"x\":\"152\",\"y\":\"225\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Valuta_\",\"page\":\"1\",\"spuid\":\"OOGZQWLABP_DIV\",\"tabindex\":\"35\",\"type\":\"Label\",\"value\":\"Valuta:\",\"w\":\"136\",\"x\":\"16\",\"y\":\"229\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Segno\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"rsegno\",\"page\":\"1\",\"spuid\":\"KUXBYNJIYY\",\"tabindex\":\"36\",\"textlist\":\"Dare (D),Avere (A)\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"D"+"'"+","+"'"+"A"+"'"+"\",\"w\":\"112\",\"x\":\"600\",\"y\":\"225\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Settorizzazione Sintetica\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"rsetsin\",\"page\":\"1\",\"spuid\":\"BOULPRIMLA\",\"tabindex\":\"37\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"152\",\"y\":\"252\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Segno_\",\"page\":\"1\",\"spuid\":\"WFRNOUHQRD_DIV\",\"tabindex\":\"38\",\"type\":\"Label\",\"value\":\"Segno:\",\"w\":\"152\",\"x\":\"448\",\"y\":\"229\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Paese Controparte\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"rpaecon\",\"page\":\"1\",\"spuid\":\"NJAIUIFRCH\",\"tabindex\":\"39\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"152\",\"y\":\"279\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Paese_Controparte_\",\"page\":\"1\",\"spuid\":\"HWSYIMZFAL_DIV\",\"tabindex\":\"40\",\"type\":\"Label\",\"value\":\"Paese Controparte:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"283\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xpaesecon\",\"page\":\"1\",\"spuid\":\"QIAJXTAKFW_DIV\",\"tabindex\":\"41\",\"type\":\"Label\",\"value\":\"w_xpaesecon\",\"w\":\"252\",\"x\":\"217\",\"y\":\"283\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"CAB Controparte\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"rcabcon\",\"page\":\"1\",\"spuid\":\"RFAXHNVDNI\",\"tabindex\":\"42\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"600\",\"y\":\"279\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"CAB_Controparte_\",\"page\":\"1\",\"spuid\":\"IAOBJXLZTI_DIV\",\"tabindex\":\"43\",\"type\":\"Label\",\"value\":\"CAB Controparte:\",\"w\":\"168\",\"x\":\"432\",\"y\":\"283\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Paese Int. Controparte\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"rpaeint\",\"page\":\"1\",\"spuid\":\"QWUXFRTCAK\",\"tabindex\":\"44\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"152\",\"y\":\"306\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Paese_Int__Controparte_\",\"page\":\"1\",\"spuid\":\"SVHHVTOUWB_DIV\",\"tabindex\":\"45\",\"type\":\"Label\",\"value\":\"Paese Int. Controparte:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"310\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xpaeseint\",\"page\":\"1\",\"spuid\":\"BACOVSPFFU_DIV\",\"tabindex\":\"46\",\"type\":\"Label\",\"value\":\"w_xpaeseint\",\"w\":\"252\",\"x\":\"217\",\"y\":\"310\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"CAB Int. Controparte\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"rcabint\",\"page\":\"1\",\"spuid\":\"IYVNYANIYW\",\"tabindex\":\"47\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"600\",\"y\":\"306\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"CAB_Int__Controparte_\",\"page\":\"1\",\"spuid\":\"EBMFNEDGHG_DIV\",\"tabindex\":\"48\",\"type\":\"Label\",\"value\":\"CAB Int. Controparte:\",\"w\":\"184\",\"x\":\"416\",\"y\":\"310\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Settorizzazione_Sintetica_\",\"page\":\"1\",\"spuid\":\"HNXOTOMWCA_DIV\",\"tabindex\":\"51\",\"type\":\"Label\",\"value\":\"Settorizzazione Sintetica:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"256\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesset\",\"page\":\"1\",\"spuid\":\"TTTIJIGSTS_DIV\",\"tabindex\":\"52\",\"type\":\"Label\",\"value\":\"w_xdesset\",\"w\":\"544\",\"x\":\"216\",\"y\":\"256\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Mese_\",\"page\":\"1\",\"spuid\":\"JCKMEQWFOM_DIV\",\"tabindex\":\"54\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"63\",\"x\":\"200\",\"y\":\"40\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Operazione_\",\"page\":\"1\",\"spuid\":\"HLPEMESXOO_DIV\",\"tabindex\":\"55\",\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":\"152\",\"x\":\"0\",\"y\":\"94\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stampa Operazioni\\/Frazionate\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"31\",\"href\":\"javascript:href_URPSVVEIFI()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"URPSVVEIFI\",\"src\":\"images\\/print.gif\",\"tabindex\":\"56\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"640\",\"y\":\"16\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_discouic_rilieviBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_discouic_rilieviBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_discouic_rilieviBO BO,ServletStatus status) {
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
     "<script src='arpg_discouic_rilievi?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_discouic_rilievi_proc.js'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath("LibreriaMit.js");
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
    status.themeWriter.WriteBody_Begin(896,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_discouic_rilieviBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_discouic_rilieviBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_discouic_rilieviBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_discouic_rilieviBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_discouic_rilieviBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_discouic_rilieviBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("LibreriaMit.js");
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
      arrt_discouic_rilievi.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_discouic_rilieviBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_discouic_rilieviBO BO) {
    boolean result = true;
    return result;
  }
}
