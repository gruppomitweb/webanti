import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_modi_aggpers extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*VOPQFEAGVS*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("CONNES",source.GetCaller().GetString("CONNES","C",16,0));
      source.SetParameter("AREAGEO",source.GetCaller().GetString("AREAGEO","C",5,0));
      source.SetParameter("AREAGEO",source.GetCaller().GetString("AREAGEO","C",5,0));
      source.SetParameter("RAREA",source.GetCaller().GetNumber("RAREA","N",3,0));
      source.SetParameter("PKTBSPECIE",source.GetCaller().GetString("PKTBSPECIE","C",4,0));
      source.SetParameter("PKTBSPECIE",source.GetCaller().GetString("PKTBSPECIE","C",4,0));
      source.SetParameter("RNATGIU",source.GetCaller().GetNumber("RNATGIU","N",3,0));
      source.SetParameter("COMPORT",source.GetCaller().GetString("COMPORT","C",5,0));
      source.SetParameter("COMPORT",source.GetCaller().GetString("COMPORT","C",5,0));
      source.SetParameter("RCOMP",source.GetCaller().GetNumber("RCOMP","N",3,0));
      source.SetParameter("BANCABEN",source.GetCaller().GetString("BANCABEN","C",11,0));
      source.SetParameter("CITTADIN1",source.GetCaller().GetString("CITTADIN1","C",3,0));
      source.SetParameter("CITTADIN2",source.GetCaller().GetString("CITTADIN2","C",3,0));
      source.SetParameter("RESFISC",source.GetCaller().GetString("RESFISC","C",3,0));
      source.SetParameter("MITIG",source.GetCaller().GetNumber("MITIG","N",4,0));
      source.SetParameter("MITGDOC",source.GetCaller().GetString("MITGDOC","C",100,0));
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
    arpg_modi_aggpersBO BO;
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
    return "Modifica Dati per Agenzia Entrate (Soggetti)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_modi_aggpers";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 789;
    l_eg.m_nEntityHeight = 437;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"tbareegeog","tbareegeog_p","tbspecie","tbspecie_p","tbcondotta","tbcondotta_p","inter2bo","tbstati"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("xdesccomp","C",200,0, "hide","Descrizione"),
                   new SPItem("xdescnatgiu","C",60,0, "hide","Descrizione"),
                   new SPItem("xareegeog","C",50,0, "hide","Descrizione"),
                   new SPItem("CONNES","C",16,0, "edit",""),
                   new SPItem("AREAGEO","C",5,0, "edit",""),
                   new SPItem("AREAGEO","C",5,0, "hide",""),
                   new SPItem("RAREA","N",3,0, "edit","Indice Rischio"),
                   new SPItem("PKTBSPECIE","C",4,0, "edit","Modalità Svolgimento"),
                   new SPItem("PKTBSPECIE","C",4,0, "hide","Modalità Svolgimento"),
                   new SPItem("RNATGIU","N",3,0, "edit","Indice di rischio"),
                   new SPItem("COMPORT","C",5,0, "edit",""),
                   new SPItem("COMPORT","C",5,0, "hide",""),
                   new SPItem("RCOMP","N",3,0, "edit","Indice Rischio"),
                   new SPItem("BANCABEN","C",11,0, "edit","Codice Banca se Beneficiario"),
                   new SPItem("ragbanben","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("CITTADIN1","C",3,0, "edit","Cittadinanza 1"),
                   new SPItem("xDesCit1","C",40,0, "hide","Descrizione"),
                   new SPItem("CITTADIN2","C",3,0, "edit","Cittadinanza 3"),
                   new SPItem("RESFISC","C",3,0, "edit","Residenza Fiscale"),
                   new SPItem("xDesCit2","C",40,0, "hide","Descrizione"),
                   new SPItem("xResFis","C",40,0, "hide","Descrizione"),
                   new SPItem("MITIG","N",4,0, "edit","Mitigazione (+/-)"),
                   new SPItem("MITGDOC","C",100,0, "edit","Documentazione Mitigazione")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_modi_aggpersBO BO) {
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
    l_translations=new String[][]{{"10108547188",p_Context.Translate("Confermi il salvataggio delle informazioni ?")},
    {"1013244520",p_Context.Translate("Residenza Fiscale")},
    {"10608444682",p_Context.Translate("Banche / Intermediari")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11271146871",p_Context.Translate("Modifica Dati per Agenzia Entrate (Soggetti)")},
    {"11391158649",p_Context.Translate("Codice Banca se Beneficiario")},
    {"11512327745",p_Context.Translate("Salva i dati appena immessi")},
    {"11596038816",p_Context.Translate("Confermi l'uscita senza salvare i dati ?")},
    {"1310320066",p_Context.Translate("Indice Rischio")},
    {"1390365716",p_Context.Translate("Cittadinanza 1")},
    {"1392462868",p_Context.Translate("Cittadinanza 3")},
    {"1701052417",p_Context.Translate("Indice di rischio")},
    {"1799462310",p_Context.Translate("Chiudi la finestra senza salvare i dati")},
    {"210895516",p_Context.Translate("Documentazione Mitigazione")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"307787605",p_Context.Translate("Mitigazione (+/-)")},
    {"406226152",p_Context.Translate("Aree Geografiche")},
    {"955814582",p_Context.Translate("Ragionevolezza Operazione")}};
    return l_translations;
  }
  void WriteStyles(arpg_modi_aggpersBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_modi_aggpers.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_modi_aggpersBO BO,ServletStatus status) {
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
  void WriteControls(arpg_modi_aggpersBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_modi_aggpersBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(432);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_modi_aggpersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='IDIZVJSJFR_DIV' class='UntitledBox'>" +
     "<div id='IDIZVJSJFR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_RROILCAWGO()' tabindex='-1' id='RROILCAWGO_HREF'>" +
     "<img id='RROILCAWGO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/save.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Salva i dati appena immessi"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Salva i dati appena immessi"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_ZQEKBHAOQV()' tabindex='-1' id='ZQEKBHAOQV_HREF'>" +
     "<img id='ZQEKBHAOQV' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Chiudi la finestra senza salvare i dati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Chiudi la finestra senza salvare i dati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNES' id='TJVNAGXDHC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNES,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HWULSRGDNM_DIV'>" +
     "<label id='HWULSRGDNM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OMJUPGXWIC_DIV'>" +
     "<label id='OMJUPGXWIC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Comportamento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EAQLLTYHOL_DIV'>" +
     "<label id='EAQLLTYHOL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura Giuridica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QMLRYBDBVX_DIV'>" +
     "<label id='QMLRYBDBVX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Area Geografica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AREAGEO' id='BCFQRQNZJM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AREAGEO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='BCFQRQNZJM_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='BCFQRQNZJM_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RAREA' id='AKGZOBFEHJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MKGCFMDIFR_DIV'>" +
     "<label id='MKGCFMDIFR'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesccomp)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='PKTBSPECIE' id='HEAYXIPDHR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PKTBSPECIE,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
     "<button id='HEAYXIPDHR_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HEAYXIPDHR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RNATGIU' id='PMYHCHZIWV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RNATGIU,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WINLROSAWR_DIV'>" +
     "<label id='WINLROSAWR'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdescnatgiu)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='COMPORT' id='MUJANTNTBM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COMPORT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='MUJANTNTBM_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='MUJANTNTBM_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RCOMP' id='UFRMQEXWER' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OVBLOKMXTL_DIV'>" +
     "<label id='OVBLOKMXTL'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xareegeog)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DRGPYGQDOR_DIV'>" +
     "<label id='DRGPYGQDOR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomala"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ORCUTDLTMS_DIV'>" +
     "<label id='ORCUTDLTMS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA RISCHIO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VTQIWWWKBO_DIV'>" +
     "<label id='VTQIWWWKBO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("VALUTAZIONE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='BANCABEN' id='KGWDOFUOWE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_BANCABEN,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='KGWDOFUOWE_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='KGWDOFUOWE_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LYSAOMHYTT_DIV'>" +
     "<label id='LYSAOMHYTT' for='KGWDOFUOWE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Banca se Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JOCPJKPIZR_DIV'>" +
     "<label id='JOCPJKPIZR'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_ragbanben)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TGAEFMGYHI_DIV'>" +
     "<label id='TGAEFMGYHI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Altri Dati"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GWFURCXOUF_DIV'>" +
     "<label id='GWFURCXOUF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cittadinanze e Residenza se diverse da Italia"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CITTADIN1' id='UIYRMZBTXN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CITTADIN1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='UIYRMZBTXN_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UIYRMZBTXN_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HSXHLMNVRG_DIV'>" +
     "<label id='HSXHLMNVRG' for='UIYRMZBTXN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cittadinanza 1:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UHICKFPGEL_DIV'>" +
     "<label id='UHICKFPGEL'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xDesCit1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CITTADIN2' id='WTTMHORXIC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CITTADIN2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='WTTMHORXIC_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='WTTMHORXIC_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZXJRLOBYSB_DIV'>" +
     "<label id='ZXJRLOBYSB' for='WTTMHORXIC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cittadinanza 2:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JPSRYRGJWE_DIV'>" +
     "<label id='JPSRYRGJWE'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xDesCit2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RESFISC' id='IEFIVEJHWI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RESFISC,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='IEFIVEJHWI_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='IEFIVEJHWI_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IHHARYGXBL_DIV'>" +
     "<label id='IHHARYGXBL' for='IEFIVEJHWI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Residenza Fiscale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MHAGFLZFVW_DIV'>" +
     "<label id='MHAGFLZFVW'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xResFis)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DPTVOOMBGI_DIV'>" +
     "<label id='DPTVOOMBGI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mitigazione Rischio"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='MITIG' id='BYFWYCWDSS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITIG,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XEOWJEFHMR_DIV'>" +
     "<label id='XEOWJEFHMR' for='BYFWYCWDSS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mitigazione (+/-):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TDMTQHVPZW_DIV'>" +
     "<label id='TDMTQHVPZW' for='BYFWYCWDSS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("%"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='MITGDOC' id='JMJDZQCPOM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITGDOC,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YQUXOOFUTK_DIV'>" +
     "<label id='YQUXOOFUTK' for='JMJDZQCPOM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Documentazione Mitigazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_modi_aggpersBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_modi_aggpersBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_modi_aggpersBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_xdesccomp,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescnatgiu,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xareegeog,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_AREAGEO,"C",5,0)+","+SPLib.ToJSValue(BO.o_AREAGEO,"C",5,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_PKTBSPECIE,"C",4,0)+","+SPLib.ToJSValue(BO.o_PKTBSPECIE,"C",4,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_RNATGIU,"N",3,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_COMPORT,"C",5,0)+","+SPLib.ToJSValue(BO.o_COMPORT,"C",5,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BANCABEN,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ragbanben,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITTADIN1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDesCit1,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITTADIN2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESFISC,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDesCit2,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xResFis,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIG,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITGDOC,"C",100,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_modi_aggpersBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_MKGCFMDIFR = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WINLROSAWR = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OVBLOKMXTL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JOCPJKPIZR = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UHICKFPGEL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JPSRYRGJWE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MHAGFLZFVW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(437,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_modi_aggpers"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'BCFQRQNZJM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRI,RISCHIOC,C,Ntbareegeog",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
    status.out.print(",'ITDOCXMPBH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbareegeog_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'HEAYXIPDHR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSPECODSPE,DESCRIC,Ctbspecie",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbspecie,"+"default",l_session)+"'"+"]");
    status.out.print(",'DWJFSNZMHW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSPECODSPE,RISCHIOC,Ntbspecie_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbspecie_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'MUJANTNTBM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbcondotta",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcondotta,"+"default",l_session)+"'"+"]");
    status.out.print(",'BSNTWULPEA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbcondotta_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcondotta_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'KGWDOFUOWE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODINTERCODINTER,RAGSOCC,Cinter2bo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
    status.out.print(",'UIYRMZBTXN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'WTTMHORXIC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'IEFIVEJHWI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_modi_aggpers","");
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
  void WriteMainFormScript(arpg_modi_aggpersBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_modi_aggpers");
    status.out.println("function SalvaDati() {");
    status.out.println("  if (confirm('Confermi il salvataggio dei dati ?')) {");
    status.out.println("    SetHypPar('m_cAction',AsAppletValue('start'));");
    status.out.println("    SetHypPar('m_cMode',AsAppletValue('hyperlink'));");
    status.out.println("    SendData('start',PlatformPathStart('arrt_modi_aggpers')+'',HParApplet().asString());");
    status.out.println("    window.close()");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_modi_aggpersBO getBO(ServletStatus status) {
    arpg_modi_aggpersBO BO = new arpg_modi_aggpersBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_modi_aggpersBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_modi_aggpersBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_modi_aggpersBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_modi_aggpersBO BO) {
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
  void Discard(ServletStatus status,arpg_modi_aggpersBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_modi_aggpersBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",437);
    item.put("w",789);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_modi_aggpers");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"423\",\"name\":\"Box_IDIZVJSJFR\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"IDIZVJSJFR\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"9\",\"zone\":\"pag1_1\"}";
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
    s = "{\"class_Css\":\" \",\"comment\":\"Salva i dati appena immessi\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"29\",\"href\":\"javascript:href_RROILCAWGO()\",\"name\":\"images_save_gif\",\"page\":\"1\",\"spuid\":\"RROILCAWGO\",\"src\":\"images\\/save.gif\",\"tabindex\":\"5\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"688\",\"y\":\"396\",\"zone\":\"IDIZVJSJFR_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Chiudi la finestra senza salvare i dati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"29\",\"href\":\"javascript:href_ZQEKBHAOQV()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"ZQEKBHAOQV\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"6\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"736\",\"y\":\"396\",\"zone\":\"IDIZVJSJFR_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"CONNES\",\"page\":\"1\",\"spuid\":\"TJVNAGXDHC\",\"tabindex\":\"7\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"16\",\"y\":\"27\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#0000FF\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"TIPOLOGIA_E_VALUTAZIONE_RISCHIO__IIIa_DIRETTIVA_\",\"page\":\"1\",\"spuid\":\"HWULSRGDNM_DIV\",\"tabindex\":\"8\",\"type\":\"Label\",\"value\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)\",\"w\":\"776\",\"x\":\"8\",\"y\":\"9\",\"zone\":\"IDIZVJSJFR_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Comportamento_\",\"page\":\"1\",\"spuid\":\"OMJUPGXWIC_DIV\",\"tabindex\":\"9\",\"type\":\"Label\",\"value\":\"Comportamento:\",\"w\":\"137\",\"x\":\"19\",\"y\":\"109\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Natura_Giuridica_\",\"page\":\"1\",\"spuid\":\"EAQLLTYHOL_DIV\",\"tabindex\":\"10\",\"type\":\"Label\",\"value\":\"Natura Giuridica:\",\"w\":\"105\",\"x\":\"51\",\"y\":\"82\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Area_Geografica_\",\"page\":\"1\",\"spuid\":\"QMLRYBDBVX_DIV\",\"tabindex\":\"11\",\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":\"140\",\"x\":\"16\",\"y\":\"55\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"AREAGEO\",\"page\":\"1\",\"spuid\":\"BCFQRQNZJM\",\"tabindex\":\"12\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"51\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice Rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RAREA\",\"page\":\"1\",\"spuid\":\"AKGZOBFEHJ\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"51\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesccomp\",\"page\":\"1\",\"spuid\":\"MKGCFMDIFR_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"w_xdesccomp\",\"w\":\"432\",\"x\":\"232\",\"y\":\"109\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Modalit\\u00E0 Svolgimento\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"PKTBSPECIE\",\"page\":\"1\",\"spuid\":\"HEAYXIPDHR\",\"tabindex\":\"16\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"78\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice di rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RNATGIU\",\"page\":\"1\",\"spuid\":\"PMYHCHZIWV\",\"tabindex\":\"18\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"78\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdescnatgiu\",\"page\":\"1\",\"spuid\":\"WINLROSAWR_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"w_xdescnatgiu\",\"w\":\"432\",\"x\":\"232\",\"y\":\"82\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"COMPORT\",\"page\":\"1\",\"spuid\":\"MUJANTNTBM\",\"tabindex\":\"20\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"105\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice Rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RCOMP\",\"page\":\"1\",\"spuid\":\"UFRMQEXWER\",\"tabindex\":\"22\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"105\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xareegeog\",\"page\":\"1\",\"spuid\":\"OVBLOKMXTL_DIV\",\"tabindex\":\"23\",\"type\":\"Label\",\"value\":\"w_xareegeog\",\"w\":\"432\",\"x\":\"232\",\"y\":\"55\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Valutazione__da_0_a_20_Regolare___da_20_a_30_Attenzione___sopra_30_Anomala\",\"page\":\"1\",\"spuid\":\"DRGPYGQDOR_DIV\",\"tabindex\":\"24\",\"type\":\"Label\",\"value\":\"Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomala\",\"w\":\"776\",\"x\":\"8\",\"y\":\"135\",\"zone\":\"IDIZVJSJFR_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"TIPOLOGIA_RISCHIO\",\"page\":\"1\",\"spuid\":\"ORCUTDLTMS_DIV\",\"tabindex\":\"25\",\"type\":\"Label\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":\"456\",\"x\":\"16\",\"y\":\"33\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"VALUTAZIONE\",\"page\":\"1\",\"spuid\":\"VTQIWWWKBO_DIV\",\"tabindex\":\"26\",\"type\":\"Label\",\"value\":\"VALUTAZIONE\",\"w\":\"184\",\"x\":\"528\",\"y\":\"33\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Codice Banca se Beneficiario\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"11\",\"name\":\"BANCABEN\",\"page\":\"1\",\"spuid\":\"KGWDOFUOWE\",\"tabindex\":\"27\",\"type\":\"Textbox\",\"w\":\"78\",\"x\":\"160\",\"y\":\"180\",\"zone\":\"IDIZVJSJFR_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Banca_se_Beneficiario_\",\"page\":\"1\",\"spuid\":\"LYSAOMHYTT_DIV\",\"tabindex\":\"28\",\"type\":\"Label\",\"value\":\"Codice Banca se Beneficiario:\",\"w\":\"154\",\"x\":\"6\",\"y\":\"184\",\"zone\":\"IDIZVJSJFR_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_ragbanben\",\"page\":\"1\",\"spuid\":\"JOCPJKPIZR_DIV\",\"tabindex\":\"29\",\"type\":\"Label\",\"value\":\"w_ragbanben\",\"w\":\"448\",\"x\":\"264\",\"y\":\"184\",\"zone\":\"IDIZVJSJFR_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#0000FF\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Altri_Dati\",\"page\":\"1\",\"spuid\":\"TGAEFMGYHI_DIV\",\"tabindex\":\"31\",\"type\":\"Label\",\"value\":\"Altri Dati\",\"w\":\"776\",\"x\":\"8\",\"y\":\"153\",\"zone\":\"IDIZVJSJFR_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#0000FF\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cittadinanze_e_Residenza_se_diverse_da_Italia\",\"page\":\"1\",\"spuid\":\"GWFURCXOUF_DIV\",\"tabindex\":\"32\",\"type\":\"Label\",\"value\":\"Cittadinanze e Residenza se diverse da Italia\",\"w\":\"776\",\"x\":\"8\",\"y\":\"207\",\"zone\":\"IDIZVJSJFR_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Cittadinanza 1\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"CITTADIN1\",\"page\":\"1\",\"spuid\":\"UIYRMZBTXN\",\"tabindex\":\"33\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"160\",\"y\":\"234\",\"zone\":\"IDIZVJSJFR_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cittadinanza_1_\",\"page\":\"1\",\"spuid\":\"HSXHLMNVRG_DIV\",\"tabindex\":\"35\",\"type\":\"Label\",\"value\":\"Cittadinanza 1:\",\"w\":\"80\",\"x\":\"80\",\"y\":\"238\",\"zone\":\"IDIZVJSJFR_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xDesCit1\",\"page\":\"1\",\"spuid\":\"UHICKFPGEL_DIV\",\"tabindex\":\"36\",\"type\":\"Label\",\"value\":\"w_xDesCit1\",\"w\":\"448\",\"x\":\"224\",\"y\":\"238\",\"zone\":\"IDIZVJSJFR_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Cittadinanza 3\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"CITTADIN2\",\"page\":\"1\",\"spuid\":\"WTTMHORXIC\",\"tabindex\":\"37\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"160\",\"y\":\"261\",\"zone\":\"IDIZVJSJFR_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cittadinanza_2_\",\"page\":\"1\",\"spuid\":\"ZXJRLOBYSB_DIV\",\"tabindex\":\"38\",\"type\":\"Label\",\"value\":\"Cittadinanza 2:\",\"w\":\"80\",\"x\":\"80\",\"y\":\"265\",\"zone\":\"IDIZVJSJFR_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xDesCit2\",\"page\":\"1\",\"spuid\":\"JPSRYRGJWE_DIV\",\"tabindex\":\"39\",\"type\":\"Label\",\"value\":\"w_xDesCit2\",\"w\":\"448\",\"x\":\"224\",\"y\":\"265\",\"zone\":\"IDIZVJSJFR_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Residenza Fiscale\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"RESFISC\",\"page\":\"1\",\"spuid\":\"IEFIVEJHWI\",\"tabindex\":\"40\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"160\",\"y\":\"288\",\"zone\":\"IDIZVJSJFR_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Residenza_Fiscale_\",\"page\":\"1\",\"spuid\":\"IHHARYGXBL_DIV\",\"tabindex\":\"41\",\"type\":\"Label\",\"value\":\"Residenza Fiscale:\",\"w\":\"96\",\"x\":\"64\",\"y\":\"292\",\"zone\":\"IDIZVJSJFR_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xResFis\",\"page\":\"1\",\"spuid\":\"MHAGFLZFVW_DIV\",\"tabindex\":\"42\",\"type\":\"Label\",\"value\":\"w_xResFis\",\"w\":\"352\",\"x\":\"224\",\"y\":\"292\",\"zone\":\"IDIZVJSJFR_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#0000FF\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Mitigazione_Rischio\",\"page\":\"1\",\"spuid\":\"DPTVOOMBGI_DIV\",\"tabindex\":\"45\",\"type\":\"Label\",\"value\":\"Mitigazione Rischio\",\"w\":\"776\",\"x\":\"8\",\"y\":\"314\",\"zone\":\"IDIZVJSJFR_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Mitigazione (+\\/-)\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"MITIG\",\"page\":\"1\",\"spuid\":\"BYFWYCWDSS\",\"tabindex\":\"46\",\"type\":\"Textbox\",\"w\":\"42\",\"x\":\"160\",\"y\":\"342\",\"zone\":\"IDIZVJSJFR_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Mitigazione_______\",\"page\":\"1\",\"spuid\":\"XEOWJEFHMR_DIV\",\"tabindex\":\"47\",\"type\":\"Label\",\"value\":\"Mitigazione (+\\/-):\",\"w\":\"92\",\"x\":\"68\",\"y\":\"346\",\"zone\":\"IDIZVJSJFR_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"_\",\"page\":\"1\",\"spuid\":\"TDMTQHVPZW_DIV\",\"tabindex\":\"48\",\"type\":\"Label\",\"value\":\"%\",\"w\":\"92\",\"x\":\"208\",\"y\":\"346\",\"zone\":\"IDIZVJSJFR_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Documentazione Mitigazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"100\",\"name\":\"MITGDOC\",\"page\":\"1\",\"spuid\":\"JMJDZQCPOM\",\"tabindex\":\"49\",\"type\":\"Textbox\",\"w\":\"616\",\"x\":\"160\",\"y\":\"369\",\"zone\":\"IDIZVJSJFR_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Documentazione_Mitigazione_\",\"page\":\"1\",\"spuid\":\"YQUXOOFUTK_DIV\",\"tabindex\":\"50\",\"type\":\"Label\",\"value\":\"Documentazione Mitigazione:\",\"w\":\"152\",\"x\":\"8\",\"y\":\"373\",\"zone\":\"IDIZVJSJFR_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_modi_aggpersBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_modi_aggpersBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_modi_aggpersBO BO,ServletStatus status) {
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
     "<script src='arpg_modi_aggpers?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_modi_aggpers_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(437,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_modi_aggpersBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_modi_aggpersBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_modi_aggpersBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_modi_aggpersBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_modi_aggpersBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_modi_aggpersBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    status.out.println(
     "<script src='SPPrxy/"+arrt_modi_aggpers.m_cEntityUid+"/arrt_modi_aggpers.js'>" +
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
      arrt_modi_aggpers.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_modi_aggpersBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_modi_aggpersBO BO) {
    boolean result = true;
    return result;
  }
}
