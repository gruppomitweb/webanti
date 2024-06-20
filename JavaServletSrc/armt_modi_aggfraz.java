import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_modi_aggfraz extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ATFZNXJWIB*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("OPERAG",source.GetCaller().GetString("OPERAG","C",3,0));
      source.SetParameter("RESPINS",source.GetCaller().GetString("RESPINS","C",30,0));
      source.SetParameter("INFORM",source.GetCaller().GetString("INFORM","C",30,0));
      source.SetParameter("NOPROT",source.GetCaller().GetNumber("NOPROT","N",1,0));
      source.SetParameter("IDBASE",source.GetCaller().GetString("IDBASE","C",10,0));
      source.SetParameter("RAGIO",source.GetCaller().GetString("RAGIO","C",5,0));
      source.SetParameter("MODSVOL",source.GetCaller().GetString("MODSVOL","C",5,0));
      source.SetParameter("AREAGEO",source.GetCaller().GetString("AREAGEO","C",5,0));
      source.SetParameter("NATURA",source.GetCaller().GetString("NATURA","C",50,0));
      source.SetParameter("SCOPO",source.GetCaller().GetString("SCOPO","C",50,0));
      source.SetParameter("TIPO",source.GetCaller().GetString("TIPO","C",3,0));
      source.SetParameter("RFREQ",source.GetCaller().GetNumber("RFREQ","N",3,0));
      source.SetParameter("RAREA",source.GetCaller().GetNumber("RAREA","N",3,0));
      source.SetParameter("RCOMP",source.GetCaller().GetNumber("RCOMP","N",3,0));
      source.SetParameter("RRAGIO",source.GetCaller().GetNumber("RRAGIO","N",3,0));
      source.SetParameter("RTIPO",source.GetCaller().GetNumber("RTIPO","N",3,0));
      source.SetParameter("RIMP",source.GetCaller().GetNumber("RIMP","N",3,0));
      source.SetParameter("AMMONT",source.GetCaller().GetString("AMMONT","C",5,0));
      source.SetParameter("DURAT",source.GetCaller().GetString("DURAT","C",5,0));
      source.SetParameter("TIPO",source.GetCaller().GetString("TIPO","C",3,0));
      source.SetParameter("RAGIO",source.GetCaller().GetString("RAGIO","C",5,0));
      source.SetParameter("MODSVOL",source.GetCaller().GetString("MODSVOL","C",5,0));
      source.SetParameter("AREAGEO",source.GetCaller().GetString("AREAGEO","C",5,0));
      source.SetParameter("AMMONT",source.GetCaller().GetString("AMMONT","C",5,0));
      source.SetParameter("DURAT",source.GetCaller().GetString("DURAT","C",5,0));
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
    armt_modi_aggfrazBO BO;
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
    return "Modifica Dati per Agenzia Entrate (Frazionate)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_modi_aggfraz";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 725;
    l_eg.m_nEntityHeight = 426;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"tbtipope","tbplauso","tbsvolgim","tbareegeog","tbtiporisc","tbimporto","tbdurata","tbtiporisc_p","tbplauso_p","tbsvolgim_p","tbareegeog_p","tbimporto_p","tbdurata_p"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("OPERAG","C",3,0, "edit",""),
                   new SPItem("RESPINS","C",30,0, "edit",""),
                   new SPItem("INFORM","C",30,0, "edit",""),
                   new SPItem("xdescrag","C",50,0, "hide","Descrizione"),
                   new SPItem("xmodsvol","C",50,0, "hide","Descrizione"),
                   new SPItem("xareegeog","C",50,0, "hide","Descrizione"),
                   new SPItem("xdescopeage","C",254,0, "hide","Descrizione"),
                   new SPItem("NOPROT","N",1,0, "edit",""),
                   new SPItem("IDBASE","C",10,0, "hide",""),
                   new SPItem("RAGIO","C",5,0, "edit",""),
                   new SPItem("MODSVOL","C",5,0, "edit","Modalità Svolgimento"),
                   new SPItem("AREAGEO","C",5,0, "edit",""),
                   new SPItem("NATURA","C",50,0, "edit",""),
                   new SPItem("SCOPO","C",50,0, "edit",""),
                   new SPItem("TIPO","C",3,0, "edit",""),
                   new SPItem("xdesctipor","C",100,0, "hide","Descrizione"),
                   new SPItem("RFREQ","N",3,0, "edit",""),
                   new SPItem("RAREA","N",3,0, "edit","Indice Rischio"),
                   new SPItem("RCOMP","N",3,0, "edit","Indice di rischio"),
                   new SPItem("RRAGIO","N",3,0, "edit","Indice di rischio"),
                   new SPItem("RTIPO","N",3,0, "edit","Indice di Rischio"),
                   new SPItem("RIMP","N",3,0, "edit",""),
                   new SPItem("AMMONT","C",5,0, "edit","Importo"),
                   new SPItem("DURAT","C",5,0, "edit",""),
                   new SPItem("xdurat","C",200,0, "hide","Descrizione"),
                   new SPItem("xammont","C",200,0, "hide","Descrizione"),
                   new SPItem("TIPO","C",3,0, "hide",""),
                   new SPItem("RAGIO","C",5,0, "hide",""),
                   new SPItem("MODSVOL","C",5,0, "hide","Modalità Svolgimento"),
                   new SPItem("AREAGEO","C",5,0, "hide",""),
                   new SPItem("AMMONT","C",5,0, "hide","Importo"),
                   new SPItem("DURAT","C",5,0, "hide","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_modi_aggfrazBO BO) {
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
    l_translations=new String[][]{{"10049460300",p_Context.Translate("Tipologia Rischio")},
    {"10196692374",p_Context.Translate("Non inviare agenzia Entrate")},
    {"103243324",p_Context.Translate("Tipo Operazione Agenzia Entrate")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11512327745",p_Context.Translate("Salva i dati appena immessi")},
    {"11857520945",p_Context.Translate("Ammontare Operazione")},
    {"1310320066",p_Context.Translate("Indice Rischio")},
    {"165129764",p_Context.Translate("Modifica Dati per Agenzia Entrate (Frazionate)")},
    {"1701044225",p_Context.Translate("Indice di Rischio")},
    {"1701052417",p_Context.Translate("Indice di rischio")},
    {"1799462310",p_Context.Translate("Chiudi la finestra senza salvare i dati")},
    {"1991862041",p_Context.Translate("Importo")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"406226152",p_Context.Translate("Aree Geografiche")},
    {"492819232",p_Context.Translate("Frequenza Operazioni")},
    {"955814582",p_Context.Translate("Ragionevolezza Operazione")}};
    return l_translations;
  }
  void WriteStyles(armt_modi_aggfrazBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/armt_modi_aggfraz.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(armt_modi_aggfrazBO BO,ServletStatus status) {
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
  void WriteControls(armt_modi_aggfrazBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(armt_modi_aggfrazBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(421);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(armt_modi_aggfrazBO BO,ServletStatus status) {
    status.out.println(
     "<span class='SPLabel' id='PIAIOUTMLP_DIV'>" +
     "<label id='PIAIOUTMLP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WNUAUHZXGB_DIV'>" +
     "<label id='WNUAUHZXGB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Responsabile Inserimento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UEOPGTWLUL_DIV'>" +
     "<label id='UEOPGTWLUL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Annotazioni Varie:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='OPERAG' id='QGVSOMWQKO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_OPERAG,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='QGVSOMWQKO_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='QGVSOMWQKO_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RESPINS' id='VXNCZZQUTU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RESPINS,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='INFORM' id='UHKTWUYPMH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_INFORM,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='XQEWDORSRU_DIV'>" +
     "<input name='NOPROT' id='XQEWDORSRU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOPROT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOPROT)?"CHECKED":"")+">" +
     "<label id='XQEWDORSRU_LBL' for='XQEWDORSRU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non inviare agenzia Entrate"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IFYTOFMTWY_DIV'>" +
     "<label id='IFYTOFMTWY'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdescopeage)+"" +
     "</label>" +
     "</span>" +
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
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragionevolezza Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EAQLLTYHOL_DIV'>" +
     "<label id='EAQLLTYHOL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modalità Svolgimento:"))+"" +
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
     "<input name='RAGIO' id='MUJANTNTBM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAGIO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='MUJANTNTBM_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='MUJANTNTBM_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='MODSVOL' id='HEAYXIPDHR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MODSVOL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='HEAYXIPDHR_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HEAYXIPDHR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AREAGEO' id='BCFQRQNZJM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AREAGEO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='BCFQRQNZJM_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='BCFQRQNZJM_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MKGCFMDIFR_DIV'>" +
     "<label id='MKGCFMDIFR'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdescrag)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WINLROSAWR_DIV'>" +
     "<label id='WINLROSAWR'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xmodsvol)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OVBLOKMXTL_DIV'>" +
     "<label id='OVBLOKMXTL'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xareegeog)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KFTGHDJCYW_DIV'>" +
     "<label id='KFTGHDJCYW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='NATURA' id='TMQBHKYHRS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NATURA,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='SCOPO' id='MJXJDMQQRI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SCOPO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YXRVJJQAOH_DIV'>" +
     "<label id='YXRVJJQAOH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Scopo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RKBYWIRAZI_DIV'>" +
     "<label id='RKBYWIRAZI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Es. Natura = Mutuo; Scopo = Acquisto beni di consumo"))+"" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TIPO' id='FKIUXYFTAY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='FKIUXYFTAY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='FKIUXYFTAY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IMIRLRSKNU_DIV'>" +
     "<label id='IMIRLRSKNU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipologia Rischio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VCGKYDPCZH_DIV'>" +
     "<label id='VCGKYDPCZH'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesctipor)+"" +
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
     "<input name='RFREQ' id='CXKIEWTPXM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RFREQ,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RAREA' id='AKGZOBFEHJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RCOMP' id='PMYHCHZIWV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RRAGIO' id='UFRMQEXWER' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RRAGIO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RTIPO' id='HJNXGLDJPH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RTIPO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RIMP' id='EZKIGVHOME' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RIMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KRTOISVCUF_DIV'>" +
     "<label id='KRTOISVCUF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HMWWZRPUTP_DIV'>" +
     "<label id='HMWWZRPUTP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Frequenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AMMONT' id='HMBPBMNNSQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AMMONT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='HMBPBMNNSQ_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HMBPBMNNSQ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DURAT' id='XJFWPDTBUT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DURAT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='XJFWPDTBUT_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='XJFWPDTBUT_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YGMVSHOXQQ_DIV'>" +
     "<label id='YGMVSHOXQQ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xammont)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JQLJCTWIDF_DIV'>" +
     "<label id='JQLJCTWIDF'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdurat)+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(armt_modi_aggfrazBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_modi_aggfrazBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(armt_modi_aggfrazBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_OPERAG,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESPINS,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_INFORM,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescrag,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xmodsvol,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xareegeog,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescopeage,"C",254,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOPROT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_RAGIO,"C",5,0)+","+SPLib.ToJSValue(BO.o_RAGIO,"C",5,0)+"]");
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_MODSVOL,"C",5,0)+","+SPLib.ToJSValue(BO.o_MODSVOL,"C",5,0)+"]");
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_AREAGEO,"C",5,0)+","+SPLib.ToJSValue(BO.o_AREAGEO,"C",5,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_NATURA,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SCOPO,"C",50,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_TIPO,"C",3,0)+","+SPLib.ToJSValue(BO.o_TIPO,"C",3,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipor,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RFREQ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RRAGIO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RTIPO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIMP,"N",3,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_AMMONT,"C",5,0)+","+SPLib.ToJSValue(BO.o_AMMONT,"C",5,0)+"]");
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_DURAT,"C",5,0)+","+SPLib.ToJSValue(BO.o_DURAT,"C",5,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_xdurat,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xammont,"C",200,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_modi_aggfrazBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_IFYTOFMTWY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MKGCFMDIFR = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WINLROSAWR = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OVBLOKMXTL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VCGKYDPCZH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YGMVSHOXQQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JQLJCTWIDF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(426,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(725,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_modi_aggfraz"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'QGVSOMWQKO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbtipope",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
    status.out.print(",'MUJANTNTBM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbplauso",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
    status.out.print(",'HEAYXIPDHR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbsvolgim",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
    status.out.print(",'BCFQRQNZJM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbareegeog",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
    status.out.print(",'FKIUXYFTAY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbtiporisc",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
    status.out.print(",'HMBPBMNNSQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbimporto",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
    status.out.print(",'XJFWPDTBUT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,DESCRIC,Ctbdurata",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
    status.out.print(",'ZXAGFQXBRH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbtiporisc_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'UVOSMLOZGD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbplauso_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'UUIMACOHVM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbsvolgim_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'JSRWGYXWUP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbareegeog_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'OXGJIOYQVA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbimporto_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto_p,"+"default",l_session)+"'"+"]");
    status.out.print(",'ZBLNCBPFUK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODICECODICE,RISCHIOC,Ntbdurata_p",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata_p,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_modi_aggfraz","");
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
  void WriteMainFormScript(armt_modi_aggfrazBO BO,ServletStatus status) {
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
    status.out.println("// * --- armt_modi_aggfraz");
    status.out.println("function SalvaDati() {");
    status.out.println("  if (confirm('Confermi il salvataggio dei dati ?')) {");
    status.out.println("    SetHypPar('m_cAction',AsAppletValue('start'));");
    status.out.println("    SetHypPar('m_cMode',AsAppletValue('hyperlink'));");
    status.out.println("    SendData('start',PlatformPathStart('arrt_modi_aggfraz')+'',HParApplet().asString());");
    status.out.println("    window.close()");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_modi_aggfrazBO getBO(ServletStatus status) {
    armt_modi_aggfrazBO BO = new armt_modi_aggfrazBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_modi_aggfrazBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_modi_aggfrazBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,armt_modi_aggfrazBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,armt_modi_aggfrazBO BO) {
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
  void Discard(ServletStatus status,armt_modi_aggfrazBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,armt_modi_aggfrazBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",426);
    item.put("w",725);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","armt_modi_aggfraz");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Operazione_\",\"page\":\"1\",\"spuid\":\"PIAIOUTMLP_DIV\",\"tabindex\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":\"82\",\"x\":\"76\",\"y\":\"22\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Responsabile_Inserimento_\",\"page\":\"1\",\"spuid\":\"WNUAUHZXGB_DIV\",\"tabindex\":\"2\",\"type\":\"Label\",\"value\":\"Responsabile Inserimento:\",\"w\":\"127\",\"x\":\"31\",\"y\":\"49\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Annotazioni_Varie_\",\"page\":\"1\",\"spuid\":\"UEOPGTWLUL_DIV\",\"tabindex\":\"3\",\"type\":\"Label\",\"value\":\"Annotazioni Varie:\",\"w\":\"87\",\"x\":\"70\",\"y\":\"76\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"OPERAG\",\"page\":\"1\",\"spuid\":\"QGVSOMWQKO\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"18\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"30\",\"name\":\"RESPINS\",\"page\":\"1\",\"spuid\":\"VXNCZZQUTU\",\"tabindex\":\"5\",\"type\":\"Textbox\",\"w\":\"192\",\"x\":\"160\",\"y\":\"45\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"30\",\"name\":\"INFORM\",\"page\":\"1\",\"spuid\":\"UHKTWUYPMH\",\"tabindex\":\"6\",\"type\":\"Textbox\",\"w\":\"192\",\"x\":\"160\",\"y\":\"72\",\"zone\":\"pag1_4\"}";
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
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"NOPROT\",\"page\":\"1\",\"spuid\":\"XQEWDORSRU\",\"tabindex\":\"11\",\"type\":\"Checkbox\",\"w\":\"153\",\"x\":\"560\",\"y\":\"45\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdescopeage\",\"page\":\"1\",\"spuid\":\"IFYTOFMTWY_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"w_xdescopeage\",\"w\":\"480\",\"x\":\"232\",\"y\":\"22\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Salva i dati appena immessi\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"29\",\"href\":\"javascript:href_RROILCAWGO()\",\"name\":\"images_save_gif\",\"page\":\"1\",\"spuid\":\"RROILCAWGO\",\"src\":\"images\\/save.gif\",\"tabindex\":\"13\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"624\",\"y\":\"387\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Chiudi la finestra senza salvare i dati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"29\",\"href\":\"javascript:href_ZQEKBHAOQV()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"ZQEKBHAOQV\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"14\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"672\",\"y\":\"387\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"TIPOLOGIA_E_VALUTAZIONE_RISCHIO__IIIa_DIRETTIVA_\",\"page\":\"1\",\"spuid\":\"HWULSRGDNM_DIV\",\"tabindex\":\"16\",\"type\":\"Label\",\"value\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)\",\"w\":\"712\",\"x\":\"8\",\"y\":\"162\",\"zone\":\"pag1_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Ragionevolezza_Operazione_\",\"page\":\"1\",\"spuid\":\"OMJUPGXWIC_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"Ragionevolezza Operazione:\",\"w\":\"137\",\"x\":\"19\",\"y\":\"328\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Modalit\\u00E0_Svolgimento_\",\"page\":\"1\",\"spuid\":\"EAQLLTYHOL_DIV\",\"tabindex\":\"18\",\"type\":\"Label\",\"value\":\"Modalit\\u00E0 Svolgimento:\",\"w\":\"105\",\"x\":\"51\",\"y\":\"301\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Area_Geografica_\",\"page\":\"1\",\"spuid\":\"QMLRYBDBVX_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":\"140\",\"x\":\"16\",\"y\":\"274\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"RAGIO\",\"page\":\"1\",\"spuid\":\"MUJANTNTBM\",\"tabindex\":\"20\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"324\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Modalit\\u00E0 Svolgimento\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"MODSVOL\",\"page\":\"1\",\"spuid\":\"HEAYXIPDHR\",\"tabindex\":\"21\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"297\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"AREAGEO\",\"page\":\"1\",\"spuid\":\"BCFQRQNZJM\",\"tabindex\":\"22\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"270\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdescrag\",\"page\":\"1\",\"spuid\":\"MKGCFMDIFR_DIV\",\"tabindex\":\"23\",\"type\":\"Label\",\"value\":\"w_xdescrag\",\"w\":\"432\",\"x\":\"232\",\"y\":\"328\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xmodsvol\",\"page\":\"1\",\"spuid\":\"WINLROSAWR_DIV\",\"tabindex\":\"24\",\"type\":\"Label\",\"value\":\"w_xmodsvol\",\"w\":\"432\",\"x\":\"232\",\"y\":\"301\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xareegeog\",\"page\":\"1\",\"spuid\":\"OVBLOKMXTL_DIV\",\"tabindex\":\"25\",\"type\":\"Label\",\"value\":\"w_xareegeog\",\"w\":\"432\",\"x\":\"232\",\"y\":\"274\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Natura_\",\"page\":\"1\",\"spuid\":\"KFTGHDJCYW_DIV\",\"tabindex\":\"26\",\"type\":\"Label\",\"value\":\"Natura:\",\"w\":\"37\",\"x\":\"119\",\"y\":\"103\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"50\",\"name\":\"NATURA\",\"page\":\"1\",\"spuid\":\"TMQBHKYHRS\",\"tabindex\":\"27\",\"type\":\"Textbox\",\"w\":\"312\",\"x\":\"160\",\"y\":\"99\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"50\",\"name\":\"SCOPO\",\"page\":\"1\",\"spuid\":\"MJXJDMQQRI\",\"tabindex\":\"28\",\"type\":\"Textbox\",\"w\":\"312\",\"x\":\"160\",\"y\":\"126\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Scopo_\",\"page\":\"1\",\"spuid\":\"YXRVJJQAOH_DIV\",\"tabindex\":\"29\",\"type\":\"Label\",\"value\":\"Scopo:\",\"w\":\"37\",\"x\":\"119\",\"y\":\"130\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Es__Natura___Mutuo__Scopo___Acquisto_beni_di_consumo\",\"page\":\"1\",\"spuid\":\"RKBYWIRAZI_DIV\",\"tabindex\":\"30\",\"type\":\"Label\",\"value\":\"Es. Natura = Mutuo; Scopo = Acquisto beni di consumo\",\"w\":\"265\",\"x\":\"160\",\"y\":\"387\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Valutazione__da_0_a_20_Regolare___da_20_a_30_Attenzione___sopra_30_Anomala\",\"page\":\"1\",\"spuid\":\"DRGPYGQDOR_DIV\",\"tabindex\":\"31\",\"type\":\"Label\",\"value\":\"Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomala\",\"w\":\"365\",\"x\":\"160\",\"y\":\"405\",\"zone\":\"pag1_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"TIPO\",\"page\":\"1\",\"spuid\":\"FKIUXYFTAY\",\"tabindex\":\"32\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"351\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipologia_Rischio_\",\"page\":\"1\",\"spuid\":\"IMIRLRSKNU_DIV\",\"tabindex\":\"33\",\"type\":\"Label\",\"value\":\"Tipologia Rischio:\",\"w\":\"137\",\"x\":\"19\",\"y\":\"355\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesctipor\",\"page\":\"1\",\"spuid\":\"VCGKYDPCZH_DIV\",\"tabindex\":\"34\",\"type\":\"Label\",\"value\":\"w_xdesctipor\",\"w\":\"432\",\"x\":\"232\",\"y\":\"355\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"TIPOLOGIA_RISCHIO\",\"page\":\"1\",\"spuid\":\"ORCUTDLTMS_DIV\",\"tabindex\":\"36\",\"type\":\"Label\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":\"456\",\"x\":\"16\",\"y\":\"189\",\"zone\":\"pag1_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"VALUTAZIONE\",\"page\":\"1\",\"spuid\":\"VTQIWWWKBO_DIV\",\"tabindex\":\"37\",\"type\":\"Label\",\"value\":\"VALUTAZIONE\",\"w\":\"184\",\"x\":\"528\",\"y\":\"189\",\"zone\":\"pag1_15\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RFREQ\",\"page\":\"1\",\"spuid\":\"CXKIEWTPXM\",\"tabindex\":\"38\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"216\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice Rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RAREA\",\"page\":\"1\",\"spuid\":\"AKGZOBFEHJ\",\"tabindex\":\"39\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"270\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice di rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RCOMP\",\"page\":\"1\",\"spuid\":\"PMYHCHZIWV\",\"tabindex\":\"40\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"297\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice di rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RRAGIO\",\"page\":\"1\",\"spuid\":\"UFRMQEXWER\",\"tabindex\":\"41\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"324\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Indice di Rischio\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RTIPO\",\"page\":\"1\",\"spuid\":\"HJNXGLDJPH\",\"tabindex\":\"42\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"351\",\"zone\":\"pag1_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"4\",\"name\":\"RIMP\",\"page\":\"1\",\"spuid\":\"EZKIGVHOME\",\"tabindex\":\"43\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"680\",\"y\":\"243\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Importo_\",\"page\":\"1\",\"spuid\":\"KRTOISVCUF_DIV\",\"tabindex\":\"44\",\"type\":\"Label\",\"value\":\"Importo:\",\"w\":\"105\",\"x\":\"51\",\"y\":\"247\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Frequenza_\",\"page\":\"1\",\"spuid\":\"HMWWZRPUTP_DIV\",\"tabindex\":\"45\",\"type\":\"Label\",\"value\":\"Frequenza:\",\"w\":\"140\",\"x\":\"16\",\"y\":\"220\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Importo\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"AMMONT\",\"page\":\"1\",\"spuid\":\"HMBPBMNNSQ\",\"tabindex\":\"46\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"243\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"DURAT\",\"page\":\"1\",\"spuid\":\"XJFWPDTBUT\",\"tabindex\":\"47\",\"type\":\"Textbox\",\"w\":\"46\",\"x\":\"160\",\"y\":\"216\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xammont\",\"page\":\"1\",\"spuid\":\"YGMVSHOXQQ_DIV\",\"tabindex\":\"48\",\"type\":\"Label\",\"value\":\"w_xammont\",\"w\":\"432\",\"x\":\"232\",\"y\":\"247\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdurat\",\"page\":\"1\",\"spuid\":\"JQLJCTWIDF_DIV\",\"tabindex\":\"49\",\"type\":\"Label\",\"value\":\"w_xdurat\",\"w\":\"432\",\"x\":\"232\",\"y\":\"220\",\"zone\":\"pag1_7\"}";
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
    s = "{}";
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
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,armt_modi_aggfrazBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,armt_modi_aggfrazBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(armt_modi_aggfrazBO BO,ServletStatus status) {
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
     "<script src='armt_modi_aggfraz?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/armt_modi_aggfraz_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(426,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(armt_modi_aggfrazBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_modi_aggfrazBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_modi_aggfrazBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_modi_aggfrazBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_modi_aggfrazBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_modi_aggfrazBO BO,ServletStatus status) {
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
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
  }
  public String GetCheckVars(ServletStatus status,armt_modi_aggfrazBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,armt_modi_aggfrazBO BO) {
    boolean result = true;
    return result;
  }
}
