import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_chkdiana_all extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*YBYDTAYIYH*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("codinter",source.GetCaller().GetString("codinter","C",11,0));
      source.SetParameter("xragsoc",source.GetCaller().GetString("xragsoc","C",70,0));
      source.SetParameter("tipinter",source.GetCaller().GetString("tipinter","C",2,0));
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
    arpg_chkdiana_allBO BO;
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
    return "Preparazione file per Check Scarico OffLine";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_chkdiana_all";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 805;
    l_eg.m_nEntityHeight = 750;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"intermbo","anadip","personbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("codinter","C",11,0, "edit",""),
                   new SPItem("xragsoc","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("tipinter","C",2,0, "edit",""),
                   new SPItem("codage","C",6,0, "edit","Agenzia/Dipendenza:"),
                   new SPItem("codcli","C",16,0, "edit","Cliente"),
                   new SPItem("ragben","C",70,0, "edit","Beneficiario"),
                   new SPItem("DaData","D",8,0, "edit",""),
                   new SPItem("AData","D",8,0, "edit",""),
                   new SPItem("DaDataReg","D",8,0, "edit",""),
                   new SPItem("ADataReg","D",8,0, "edit",""),
                   new SPItem("tipoarch","C",1,0, "edit",""),
                   new SPItem("flgrae","C",1,0, "edit",""),
                   new SPItem("flgope","C",10,0, "edit",""),
                   new SPItem("flgfrz","C",10,0, "edit",""),
                   new SPItem("flgrap","C",1,0, "edit",""),
                   new SPItem("tiprap","C",1,0, "edit",""),
                   new SPItem("flgtit","C",1,0, "edit",""),
                   new SPItem("tiptip","C",1,0, "edit",""),
                   new SPItem("flgint","C",1,0, "edit",""),
                   new SPItem("flgdel","C",1,0, "edit",""),
                   new SPItem("flgchk","C",10,0, "edit",""),
                   new SPItem("flgsto","C",1,0, "edit",""),
                   new SPItem("destfold","C",80,0, "edit","Cartella Destinazione"),
                   new SPItem("xdesage","C",30,0, "hide","Descrizione"),
                   new SPItem("gUrlApp","C",80,0, "hide","URL Applicazione"),
                   new SPItem("gAzienda","C",10,0, "hide","Azienda"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("xragcli","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("gWebCHK","C",1,0, "hide","Collegamento a WEBCHK"),
                   new SPItem("stoper","C",1,0, "edit",""),
                   new SPItem("flgxls","C",10,0, "edit","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_chkdiana_allBO BO) {
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
    l_translations=new String[][]{{"10056338162",p_Context.Translate("URL Applicazione")},
    {"10100391661",p_Context.Translate("Beneficiario")},
    {"10634962900",p_Context.Translate("Intestatario Operazione")},
    {"1065830827",p_Context.Translate("La data di inizio registrazione deve essere uguale o inferiore a quella di fine registrazione")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10832346659",p_Context.Translate("Collegamento a WEBCHK")},
    {"10909621169",p_Context.Translate("Scrivere anche Cancellate e Modificate")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11038347256",p_Context.Translate("Scrittura diretta su WEBCHK")},
    {"11285859937",p_Context.Translate("Chiudi la procedura senza elaborare i dati")},
    {"11312864347",p_Context.Translate("Preparazione file per Check Scarico OffLine")},
    {"11376555280",p_Context.Translate("Confermi la generazione dello Scarico OffLine ?")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11404054622",p_Context.Translate("Intermediari")},
    {"11480189617",p_Context.Translate("Agenzie/Dipendenze")},
    {"11547283697",p_Context.Translate("Agenzia/Dipendenza:")},
    {"1187078281",p_Context.Translate("La data di inizio periodo deve essere uguale o inferiore a quella di fine periodo")},
    {"12057236694",p_Context.Translate("Frazionate")},
    {"12072144219",p_Context.Translate("La data di fine registrazione deve essere maggiore di quella di inizio registrazione")},
    {"145008573",p_Context.Translate("Cartella Destinazione")},
    {"155796076",p_Context.Translate("Scrittura 380 su Excel (XLSX)")},
    {"1627951949",p_Context.Translate("Operazioni")},
    {"1677589740",p_Context.Translate("La data di fine periodo deve essere maggiore di quella di inizio periodo")},
    {"1739899105",p_Context.Translate("Azienda")},
    {"1823784963",p_Context.Translate("Cliente")},
    {"2073422140",p_Context.Translate("Solo Legami attivi nell'intervallo di date selezionato")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"349045789",p_Context.Translate("Solo Rapporti attivi nell'intervallo di date selezionato")},
    {"359216348",p_Context.Translate("Inserire Delegati in registrazioni 31 e 32")},
    {"823728320",p_Context.Translate("Ripeti dati intestatario per ogni informazione")},
    {"870263752",p_Context.Translate("Premere il bottone per prelevare il file generato")},
    {"984756930",p_Context.Translate("Tipo Intermediario")}};
    return l_translations;
  }
  void WriteStyles(arpg_chkdiana_allBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_chkdiana_all.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_chkdiana_allBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_chkdiana_allBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_chkdiana_allBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_chkdiana_allBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_chkdiana_allBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(745);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_chkdiana_allBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<span class='SPLabel' id='PMDUYENKWL_DIV'>" +
     "<label id='PMDUYENKWL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='codinter' id='FCREPJBLHG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_codinter,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='FCREPJBLHG_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='FCREPJBLHG_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UWBJTJCNUU_DIV'>" +
     "<label id='UWBJTJCNUU'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsoc)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CCVJTGYXIP_DIV'>" +
     "<label id='CCVJTGYXIP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tipinter' id='RCFVSQQCNU' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
    "");
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipint,CPSql.BuildSQLPhrase("TIPOINT,DESCRI",BO.m_cPhName_tbtipint,"",""));
    try {
      while ( ! (l_rsLoad.Eof())) {
        status.out.println(
         "<option value="+SPLib.ToHTMLValue(l_rsLoad.GetString("TIPOINT"),"C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(l_rsLoad.GetString("TIPOINT"),CPLib.Trim(BO.w_tipinter))?"SELECTED":"")+">" +
         ""+SPLib.ToHTML(l_rsLoad.GetString("DESCRI"),"C",0,0)+"" +
         "</option>" +
        "");
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    status.out.println(
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('RCFVSQQCNU'),w_tipinter,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='codage' id='LMCBBKUTJY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_codage,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='LMCBBKUTJY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='LMCBBKUTJY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='codcli' id='VEYKPVUMPQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_codcli,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='VEYKPVUMPQ_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='VEYKPVUMPQ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ragben' id='CNQRKVJUGN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ragben,"C",70,0,"!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaData' id='HJLJFAMGNR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='HJLJFAMGNR_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HJLJFAMGNR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AData' id='XWZHWTENET' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='XWZHWTENET_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='XWZHWTENET_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaDataReg' id='HBWDBPTGKK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaDataReg,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='HBWDBPTGKK_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HBWDBPTGKK_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADataReg' id='WTEIEHYBUM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADataReg,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='WTEIEHYBUM_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='WTEIEHYBUM_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='YJWPZAWNZJ_DIV'>" +
     "<span id='YJWPZAWNZJ_0_container'>" +
     "<input id='YJWPZAWNZJ_0' name='YJWPZAWNZJ' type='radio' value="+SPLib.ToHTMLValue("D","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("D",CPLib.Trim(BO.w_tipoarch))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='YJWPZAWNZJ_0'>"+status.context.Translate("Definitivi (A.U.I.)")+"</label>" +
     "</span>" +
     "<span id='YJWPZAWNZJ_1_container'>" +
     "<input id='YJWPZAWNZJ_1' name='YJWPZAWNZJ' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_tipoarch))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='YJWPZAWNZJ_1'>"+status.context.Translate("Provvisori")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='flgrae' id='QNMKJLGOKW' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("R","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("R",CPLib.Trim(BO.w_flgrae))?"SELECTED":"")+">" +
     ""+status.context.Translate("Utilizza codifica RAE")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_flgrae))?"SELECTED":"")+">" +
     ""+status.context.Translate("Utilizza codifica ATECO")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('QNMKJLGOKW'),w_flgrae,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ACJYNBGGGK_DIV'>" +
     "<input name='flgope' id='ACJYNBGGGK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgope,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgope))?"CHECKED":"")+">" +
     "<label id='ACJYNBGGGK_LBL' for='ACJYNBGGGK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Operazioni"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='UGLRKSBAIN_DIV'>" +
     "<input name='flgfrz' id='UGLRKSBAIN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgfrz,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgfrz))?"CHECKED":"")+">" +
     "<label id='UGLRKSBAIN_LBL' for='UGLRKSBAIN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Frazionate"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='QXOCQTKHHM_DIV'>" +
     "<input name='flgrap' id='QXOCQTKHHM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgrap,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgrap))?"CHECKED":"")+">" +
     "<label id='QXOCQTKHHM_LBL' for='QXOCQTKHHM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Solo Rapporti attivi nell'intervallo di date selezionato"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tiprap' id='YKZIVVFLHM' class='Combobox' tabindex='-1' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_tiprap))?"SELECTED":"")+">" +
     ""+status.context.Translate("Rapporti attivi nel periodo")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_tiprap))?"SELECTED":"")+">" +
     ""+status.context.Translate("Rapporti attivi nel periodo escludendo le chiusure successive")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_tiprap))?"SELECTED":"")+">" +
     ""+status.context.Translate("Solo informazioni nel periodo")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("9","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("9",CPLib.Trim(BO.w_tiprap))?"SELECTED":"")+">" +
     ""+status.context.Translate("Non estrarre Rapporti per il periodo")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('YKZIVVFLHM'),w_tiprap,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='MPZNTAOLOD_DIV'>" +
     "<input name='flgtit' id='MPZNTAOLOD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgtit,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgtit))?"CHECKED":"")+">" +
     "<label id='MPZNTAOLOD_LBL' for='MPZNTAOLOD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Solo Legami attivi nell'intervallo di date selezionato"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tiptip' id='BGNWNQZSMR' class='Combobox' tabindex='-1' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_tiptip))?"SELECTED":"")+">" +
     ""+status.context.Translate("Legami attivi nel periodo")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_tiptip))?"SELECTED":"")+">" +
     ""+status.context.Translate("Legami attivi nel periodo escludendo le chiusure successive")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_tiptip))?"SELECTED":"")+">" +
     ""+status.context.Translate("Solo informazioni nel periodo")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("9","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("9",CPLib.Trim(BO.w_tiptip))?"SELECTED":"")+">" +
     ""+status.context.Translate("Non estrarre legami per il periodo")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('BGNWNQZSMR'),w_tiptip,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='BHRJFGYNWO_DIV'>" +
     "<input name='flgint' id='BHRJFGYNWO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgint,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgint))?"CHECKED":"")+">" +
     "<label id='BHRJFGYNWO_LBL' for='BHRJFGYNWO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Ripeti dati intestatario per ogni informazione"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='VIRLZRRHIQ_DIV'>" +
     "<input name='flgdel' id='VIRLZRRHIQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgdel,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgdel))?"CHECKED":"")+">" +
     "<label id='VIRLZRRHIQ_LBL' for='VIRLZRRHIQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Inserire Delegati in registrazioni 31 e 32"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='LJVZZPXJUZ_DIV' style='display:none'>" +
     "<input name='flgchk' id='LJVZZPXJUZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgchk,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgchk))?"CHECKED":"")+">" +
     "<label id='LJVZZPXJUZ_LBL' for='LJVZZPXJUZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Scrittura diretta su WEBCHK"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DRCOVPYYCV_DIV' style='display:none'>" +
     "<input name='flgsto' id='DRCOVPYYCV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgsto,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgsto))?"CHECKED":"")+">" +
     "<label id='DRCOVPYYCV_LBL' for='DRCOVPYYCV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Scrivere anche Cancellate e Modificate"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='destfold' id='BAPCIYCOIX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_destfold,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_MAYNQUHJSS()' tabindex='-1' style='display:none' id='MAYNQUHJSS_HREF'>" +
     "<img id='MAYNQUHJSS' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/elaborazione.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_LCFKHGNSPV()' tabindex='-1' style='display:none' id='LCFKHGNSPV_HREF'>" +
     "<img id='LCFKHGNSPV' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/view.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone per prelevare il file generato"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone per prelevare il file generato"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_NACPPABTRW()' tabindex='-1' id='NACPPABTRW_HREF'>" +
     "<img id='NACPPABTRW' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Chiudi la procedura senza elaborare i dati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Chiudi la procedura senza elaborare i dati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IWHDABKYSG_DIV'>" +
     "<label id='IWHDABKYSG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("PERIODO DA ESAMINARE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LQTOQIQYKP_DIV'>" +
     "<label id='LQTOQIQYKP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VGTGDVWOBC_DIV'>" +
     "<label id='VGTGDVWOBC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='USJHXUDNOM_DIV'>" +
     "<label id='USJHXUDNOM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipologia Archivi:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ENFIBHJIYH_DIV'>" +
     "<label id='ENFIBHJIYH' for='LMCBBKUTJY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia/Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UAIBAUYUDZ_DIV'>" +
     "<label id='UAIBAUYUDZ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesage)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MBIRXQHNIJ_DIV'>" +
     "<label id='MBIRXQHNIJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipologia Dati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione' name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
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
     "w_pMsg=ZtVWeb.getPortletById('"+portletUID_DYMVKIQWCA+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PNUSYHLNFS_DIV'>" +
     "<label id='PNUSYHLNFS' for='CNQRKVJUGN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LMKGHMEMXE_DIV'>" +
     "<label id='LMKGHMEMXE' for='VEYKPVUMPQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GOVQOOBBUD_DIV'>" +
     "<label id='GOVQOOBBUD'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragcli)+"" +
     "</label>" +
     "</span>" +
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
     "w_pLog=ZtVWeb.getPortletById('"+portletUID_KQMKKBMXYE+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OBJZKBQZTK_DIV'>" +
     "<label id='OBJZKBQZTK' for='BAPCIYCOIX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cartella Destinazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ASMHCXBGTS_DIV'>" +
     "<label id='ASMHCXBGTS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MXGGWPSZXH_DIV'>" +
     "<label id='MXGGWPSZXH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='stoper' id='XPNJJLILLB' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("R","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("R",CPLib.Trim(BO.w_stoper))?"SELECTED":"")+">" +
     ""+status.context.Translate("Storico Soggetti per Data Registrazione")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("O","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("O",CPLib.Trim(BO.w_stoper))?"SELECTED":"")+">" +
     ""+status.context.Translate("Storico Soggetti per Data Operazione")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('XPNJJLILLB'),w_stoper,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_WTUOJUZNCL()' tabindex='-1' style='display:none' id='WTUOJUZNCL_HREF'>" +
     "<img id='WTUOJUZNCL' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/elaborazione.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='OKPHQCXKRD_DIV' style='display:none'>" +
     "<input name='flgxls' id='OKPHQCXKRD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgxls,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgxls))?"CHECKED":"")+">" +
     "<label id='OKPHQCXKRD_LBL' for='OKPHQCXKRD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Scrittura 380 su Excel (XLSX)"))+"</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_chkdiana_allBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_chkdiana_allBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_chkdiana_allBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_codinter,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsoc,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipinter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_codage,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_codcli,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ragben,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaDataReg,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADataReg,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipoarch,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgrae,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgope,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgfrz,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgrap,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tiprap,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgtit,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tiptip,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgint,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgdel,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgchk,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgsto,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_destfold,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesage,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gUrlApp,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gAzienda,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragcli,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gWebCHK,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_stoper,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgxls,"C",10,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_chkdiana_allBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_UWBJTJCNUU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UAIBAUYUDZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FGMOCXNBFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GOVQOOBBUD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(750,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(805,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_chkdiana_all"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'FCREPJBLHG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODINTERCODINTER,RAGSOCC,Cintermbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'LMCBBKUTJY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    status.out.print(",'VEYKPVUMPQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_chkdiana_all","");
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
  void WriteMainFormScript(arpg_chkdiana_allBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_chkdiana_all");
    status.out.println("function Lancio() {");
    status.out.println("  w_pLog.Timer0.Start()  ");
    status.out.println("  w_pMsg.Timer0.Start()  ");
    status.out.println("  href_WTUOJUZNCL()");
    status.out.println("}  ");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_chkdiana_allBO getBO(ServletStatus status) {
    arpg_chkdiana_allBO BO = new arpg_chkdiana_allBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_chkdiana_allBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_chkdiana_allBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_chkdiana_allBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_chkdiana_allBO BO) {
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
  void Discard(ServletStatus status,arpg_chkdiana_allBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_chkdiana_allBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",750);
    item.put("w",805);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_chkdiana_all");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Intermediario_\",\"page\":\"1\",\"spuid\":\"PMDUYENKWL_DIV\",\"tabindex\":\"3\",\"type\":\"Label\",\"value\":\"Codice Intermediario:\",\"w\":\"103\",\"x\":\"48\",\"y\":\"11\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"11\",\"name\":\"codinter\",\"page\":\"1\",\"spuid\":\"FCREPJBLHG\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"78\",\"x\":\"152\",\"y\":\"7\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xragsoc\",\"page\":\"1\",\"spuid\":\"UWBJTJCNUU_DIV\",\"tabindex\":\"6\",\"type\":\"Label\",\"value\":\"w_xragsoc\",\"w\":\"352\",\"x\":\"256\",\"y\":\"11\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Intermediario_\",\"page\":\"1\",\"spuid\":\"CCVJTGYXIP_DIV\",\"tabindex\":\"7\",\"type\":\"Label\",\"value\":\"Tipo Intermediario:\",\"w\":\"91\",\"x\":\"60\",\"y\":\"37\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tipinter\",\"page\":\"1\",\"spuid\":\"RCFVSQQCNU\",\"tabindex\":\"8\",\"textlist\":\"\",\"type\":\"Combobox\",\"valuelist\":\"\",\"w\":\"456\",\"x\":\"152\",\"y\":\"33\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Agenzia\\/Dipendenza:\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"codage\",\"page\":\"1\",\"spuid\":\"LMCBBKUTJY\",\"tabindex\":\"9\",\"type\":\"Textbox\",\"w\":\"48\",\"x\":\"152\",\"y\":\"96\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Cliente\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"codcli\",\"page\":\"1\",\"spuid\":\"VEYKPVUMPQ\",\"tabindex\":\"10\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"152\",\"y\":\"126\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Beneficiario\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"70\",\"name\":\"ragben\",\"page\":\"1\",\"spuid\":\"CNQRKVJUGN\",\"tabindex\":\"11\",\"type\":\"Textbox\",\"w\":\"432\",\"x\":\"152\",\"y\":\"154\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaData\",\"page\":\"1\",\"spuid\":\"HJLJFAMGNR\",\"tabindex\":\"12\",\"type\":\"Textbox\",\"w\":\"70\",\"x\":\"152\",\"y\":\"182\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"AData\",\"page\":\"1\",\"spuid\":\"XWZHWTENET\",\"tabindex\":\"13\",\"type\":\"Textbox\",\"w\":\"70\",\"x\":\"552\",\"y\":\"184\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaDataReg\",\"page\":\"1\",\"spuid\":\"HBWDBPTGKK\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"70\",\"x\":\"152\",\"y\":\"210\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"ADataReg\",\"page\":\"1\",\"spuid\":\"WTEIEHYBUM\",\"tabindex\":\"15\",\"type\":\"Textbox\",\"w\":\"70\",\"x\":\"552\",\"y\":\"212\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"tipoarch\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"YJWPZAWNZJ\",\"tabindex\":\"16\",\"textlist\":\"Definitivi (A.U.I.),Provvisori\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"D"+"'"+","+"'"+"P"+"'"+"\",\"w\":\"193\",\"x\":\"152\",\"y\":\"242\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"flgrae\",\"page\":\"1\",\"spuid\":\"QNMKJLGOKW\",\"tabindex\":\"17\",\"textlist\":\"Utilizza codifica RAE,Utilizza codifica ATECO\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"R"+"'"+","+"'"+"A"+"'"+"\",\"w\":\"240\",\"x\":\"552\",\"y\":\"238\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgope\",\"page\":\"1\",\"spuid\":\"ACJYNBGGGK\",\"tabindex\":\"18\",\"type\":\"Checkbox\",\"w\":\"96\",\"x\":\"152\",\"y\":\"269\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgfrz\",\"page\":\"1\",\"spuid\":\"UGLRKSBAIN\",\"tabindex\":\"19\",\"type\":\"Checkbox\",\"w\":\"96\",\"x\":\"267\",\"y\":\"269\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgrap\",\"page\":\"1\",\"spuid\":\"QXOCQTKHHM\",\"tabindex\":\"20\",\"type\":\"Checkbox\",\"w\":\"288\",\"x\":\"152\",\"y\":\"300\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tiprap\",\"page\":\"1\",\"spuid\":\"YKZIVVFLHM\",\"tabindex\":\"21\",\"textlist\":\"Rapporti attivi nel periodo,Rapporti attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre Rapporti per il periodo\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"9"+"'"+"\",\"w\":\"320\",\"x\":\"472\",\"y\":\"300\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgtit\",\"page\":\"1\",\"spuid\":\"MPZNTAOLOD\",\"tabindex\":\"22\",\"type\":\"Checkbox\",\"w\":\"288\",\"x\":\"152\",\"y\":\"333\",\"zone\":\"pag1_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tiptip\",\"page\":\"1\",\"spuid\":\"BGNWNQZSMR\",\"tabindex\":\"23\",\"textlist\":\"Legami attivi nel periodo,Legami attivi nel periodo escludendo le chiusure successive,Solo informazioni nel periodo,Non estrarre legami per il periodo\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"9"+"'"+"\",\"w\":\"320\",\"x\":\"472\",\"y\":\"333\",\"zone\":\"pag1_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgint\",\"page\":\"1\",\"spuid\":\"BHRJFGYNWO\",\"tabindex\":\"24\",\"type\":\"Checkbox\",\"w\":\"248\",\"x\":\"152\",\"y\":\"368\",\"zone\":\"pag1_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgdel\",\"page\":\"1\",\"spuid\":\"VIRLZRRHIQ\",\"tabindex\":\"25\",\"type\":\"Checkbox\",\"w\":\"248\",\"x\":\"472\",\"y\":\"368\",\"zone\":\"pag1_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgchk\",\"page\":\"1\",\"spuid\":\"LJVZZPXJUZ\",\"tabindex\":\"26\",\"type\":\"Checkbox\",\"w\":\"184\",\"x\":\"152\",\"y\":\"401\",\"zone\":\"pag1_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgsto\",\"page\":\"1\",\"spuid\":\"DRCOVPYYCV\",\"tabindex\":\"27\",\"type\":\"Checkbox\",\"w\":\"256\",\"x\":\"472\",\"y\":\"401\",\"zone\":\"pag1_16\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Cartella Destinazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"80\",\"name\":\"destfold\",\"page\":\"1\",\"spuid\":\"BAPCIYCOIX\",\"tabindex\":\"28\",\"type\":\"Textbox\",\"w\":\"492\",\"x\":\"144\",\"y\":\"462\",\"zone\":\"pag1_19\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_MAYNQUHJSS()\",\"name\":\"images_elaborazione_gif\",\"page\":\"1\",\"spuid\":\"MAYNQUHJSS\",\"src\":\"images\\/elaborazione.gif\",\"tabindex\":\"29\",\"type\":\"Image\",\"w\":\"42\",\"x\":\"704\",\"y\":\"458\",\"zone\":\"pag1_20\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Premere il bottone per prelevare il file generato\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_LCFKHGNSPV()\",\"name\":\"images_view_gif\",\"page\":\"1\",\"spuid\":\"LCFKHGNSPV\",\"src\":\"images\\/view.gif\",\"tabindex\":\"30\",\"type\":\"Image\",\"w\":\"42\",\"x\":\"656\",\"y\":\"458\",\"zone\":\"pag1_20\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Chiudi la procedura senza elaborare i dati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_NACPPABTRW()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"NACPPABTRW\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"31\",\"type\":\"Image\",\"w\":\"42\",\"x\":\"752\",\"y\":\"458\",\"zone\":\"pag1_20\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"PERIODO_DA_ESAMINARE\",\"page\":\"1\",\"spuid\":\"IWHDABKYSG_DIV\",\"tabindex\":\"32\",\"type\":\"Label\",\"value\":\"PERIODO DA ESAMINARE\",\"w\":\"137\",\"x\":\"40\",\"y\":\"68\",\"zone\":\"pag1_21\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"LQTOQIQYKP_DIV\",\"tabindex\":\"33\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"135\",\"x\":\"16\",\"y\":\"186\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"VGTGDVWOBC_DIV\",\"tabindex\":\"34\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"143\",\"x\":\"408\",\"y\":\"188\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipologia_Archivi_\",\"page\":\"1\",\"spuid\":\"USJHXUDNOM_DIV\",\"tabindex\":\"35\",\"type\":\"Label\",\"value\":\"Tipologia Archivi:\",\"w\":\"81\",\"x\":\"70\",\"y\":\"242\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Agenzia_Dipendenza_\",\"page\":\"1\",\"spuid\":\"ENFIBHJIYH_DIV\",\"tabindex\":\"36\",\"type\":\"Label\",\"value\":\"Agenzia\\/Dipendenza:\",\"w\":\"128\",\"x\":\"24\",\"y\":\"100\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesage\",\"page\":\"1\",\"spuid\":\"UAIBAUYUDZ_DIV\",\"tabindex\":\"38\",\"type\":\"Label\",\"value\":\"w_xdesage\",\"w\":\"352\",\"x\":\"227\",\"y\":\"100\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipologia_Dati_\",\"page\":\"1\",\"spuid\":\"MBIRXQHNIJ_DIV\",\"tabindex\":\"39\",\"type\":\"Label\",\"value\":\"Tipologia Dati:\",\"w\":\"119\",\"x\":\"32\",\"y\":\"274\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"7\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione__name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"40\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+" name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"8\",\"x\":\"728\",\"y\":\"42\",\"zone\":\"\"}";
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
    s = "{\"comment\":\"\",\"h\":\"91\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"792\",\"x\":\"0\",\"y\":\"654\",\"zone\":\"pag1_23\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Beneficiario_\",\"page\":\"1\",\"spuid\":\"PNUSYHLNFS_DIV\",\"tabindex\":\"45\",\"type\":\"Label\",\"value\":\"Beneficiario:\",\"w\":\"128\",\"x\":\"24\",\"y\":\"158\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cliente_\",\"page\":\"1\",\"spuid\":\"LMKGHMEMXE_DIV\",\"tabindex\":\"46\",\"type\":\"Label\",\"value\":\"Cliente:\",\"w\":\"112\",\"x\":\"40\",\"y\":\"130\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xragcli\",\"page\":\"1\",\"spuid\":\"GOVQOOBBUD_DIV\",\"tabindex\":\"47\",\"type\":\"Label\",\"value\":\"w_xragcli\",\"w\":\"504\",\"x\":\"296\",\"y\":\"130\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"147\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"792\",\"x\":\"0\",\"y\":\"500\",\"zone\":\"pag1_22\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cartella_Destinazione_\",\"page\":\"1\",\"spuid\":\"OBJZKBQZTK_DIV\",\"tabindex\":\"51\",\"type\":\"Label\",\"value\":\"Cartella Destinazione:\",\"w\":\"115\",\"x\":\"28\",\"y\":\"466\",\"zone\":\"pag1_19\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Registrazione_\",\"page\":\"1\",\"spuid\":\"ASMHCXBGTS_DIV\",\"tabindex\":\"52\",\"type\":\"Label\",\"value\":\"Da Data Registrazione:\",\"w\":\"127\",\"x\":\"24\",\"y\":\"214\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Registrazione_\",\"page\":\"1\",\"spuid\":\"MXGGWPSZXH_DIV\",\"tabindex\":\"53\",\"type\":\"Label\",\"value\":\"A Data Registrazione:\",\"w\":\"143\",\"x\":\"408\",\"y\":\"216\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"stoper\",\"page\":\"1\",\"spuid\":\"XPNJJLILLB\",\"tabindex\":\"54\",\"textlist\":\"Storico Soggetti per Data Registrazione,Storico Soggetti per Data Operazione\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"R"+"'"+","+"'"+"O"+"'"+"\",\"w\":\"320\",\"x\":\"472\",\"y\":\"270\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_WTUOJUZNCL()\",\"name\":\"images_elaborazione_gif\",\"page\":\"1\",\"spuid\":\"WTUOJUZNCL\",\"src\":\"images\\/elaborazione.gif\",\"tabindex\":\"56\",\"type\":\"Image\",\"w\":\"42\",\"x\":\"752\",\"y\":\"392\",\"zone\":\"pag1_17\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgxls\",\"page\":\"1\",\"spuid\":\"OKPHQCXKRD\",\"tabindex\":\"57\",\"type\":\"Checkbox\",\"w\":\"184\",\"x\":\"152\",\"y\":\"434\",\"zone\":\"pag1_18\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_chkdiana_allBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_chkdiana_allBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_chkdiana_allBO BO,ServletStatus status) {
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
     "<script src='arpg_chkdiana_all?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_chkdiana_all_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(750,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_chkdiana_allBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_chkdiana_allBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_chkdiana_allBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_chkdiana_allBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_chkdiana_allBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_chkdiana_allBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    status.out.println(
     "<script src='SPPrxy/"+arrt_downloadfile_doc.m_cEntityUid+"/arrt_downloadfile_doc.js'>" +
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
      arrt_downloadfile_doc.GetCallableNames(callable);
      arrt_chkdiana_all.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_chkdiana_allBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_chkdiana_allBO BO) {
    boolean result = true;
    return result;
  }
}
