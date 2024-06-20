import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_modopen1 extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*UZSNGULQSJ*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("datarett",source.GetCaller().GetDate("datarett","D",8,0));
      source.SetParameter("olddata",source.GetCaller().GetDate("olddata","D",8,0));
      source.SetParameter("oldintest",source.GetCaller().GetString("oldintest","C",16,0));
      source.SetParameter("newintest",source.GetCaller().GetString("newintest","C",16,0));
      source.SetParameter("xragnew",source.GetCaller().GetString("xragnew","C",70,0));
      source.SetParameter("oldprog",source.GetCaller().GetString("oldprog","C",15,0));
      source.SetParameter("oldidbase",source.GetCaller().GetString("oldidbase","C",10,0));
      source.SetParameter("oldrappo",source.GetCaller().GetString("oldrappo","C",25,0));
      source.SetParameter("oldnumrig",source.GetCaller().GetNumber("oldnumrig","N",10,0));
      source.SetParameter("oldfile",source.GetCaller().GetString("oldfile","C",15,0));
      source.SetParameter("xragold",source.GetCaller().GetString("xragold","C",70,0));
      source.SetParameter("olddatac",source.GetCaller().GetDate("olddatac","D",8,0));
      source.SetParameter("idesito",source.GetCaller().GetString("idesito","C",8,0));
      source.SetParameter("newdatec",source.GetCaller().GetDate("newdatec","D",8,0));
      source.SetParameter("newdate",source.GetCaller().GetDate("newdate","D",8,0));
      source.SetParameter("oldappo",source.GetCaller().GetString("oldappo","C",16,0));
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
    arpg_modopen1BO BO;
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
    return "Aggiorna i dati di apertura o intestatario";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_modopen1";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 677;
    l_eg.m_nEntityHeight = 509;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"personbo","tbcitta","tbstati"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("ragione","C",1,0, "edit",""),
                   new SPItem("datarett","D",8,0, "edit",""),
                   new SPItem("olddata","D",8,0, "edit",""),
                   new SPItem("oldintest","C",16,0, "edit",""),
                   new SPItem("xcfestero","N",1,0, "edit","Codice Fiscale Estero"),
                   new SPItem("xcodfisc","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("xcognome","C",26,0, "edit","Cognome"),
                   new SPItem("xnome","C",25,0, "edit","Nome"),
                   new SPItem("xsesso","C",1,0, "edit","Sesso"),
                   new SPItem("newintest","C",16,0, "edit",""),
                   new SPItem("xragnew","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xtipopers","C",1,0, "edit",""),
                   new SPItem("oldprog","C",15,0, "hide",""),
                   new SPItem("oldidbase","C",10,0, "hide",""),
                   new SPItem("oldrappo","C",25,0, "hide",""),
                   new SPItem("oldnumrig","N",10,0, "hide",""),
                   new SPItem("oldfile","C",15,0, "hide",""),
                   new SPItem("tipochg","C",1,0, "edit",""),
                   new SPItem("xnascomun","C",40,0, "edit","Luogo di Nascita"),
                   new SPItem("xtipinter","C",2,0, "edit","Provincia"),
                   new SPItem("xnasstato","C",40,0, "edit","Stato di nascita"),
                   new SPItem("xdatnasc","D",8,0, "edit","Data Nascita"),
                   new SPItem("xragold","C",70,0, "edit","Ragione Sociale"),
                   new SPItem("xdesccit","C",40,0, "edit","Città"),
                   new SPItem("xprovincia","C",2,0, "edit","Provincia"),
                   new SPItem("xcap","C",9,0, "edit","CAP"),
                   new SPItem("xpaese","C",3,0, "edit","Stato"),
                   new SPItem("xdessta","C",40,0, "hide","Descrizione"),
                   new SPItem("olddatac","D",8,0, "edit",""),
                   new SPItem("idesito","C",8,0, "edit","Esito Agenzia Entrate"),
                   new SPItem("newdatec","D",8,0, "edit",""),
                   new SPItem("newdate","D",8,0, "edit",""),
                   new SPItem("oldappo","C",16,0, "hide","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_modopen1BO BO) {
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
    l_translations=new String[][]{{"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10615814578",p_Context.Translate("Esito Agenzia Entrate")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"11777527481",p_Context.Translate("Data Nascita")},
    {"117818419",p_Context.Translate("Comuni")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"12095201017",p_Context.Translate("Aggiorna i dati di apertura o intestatario")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12123334500",p_Context.Translate("Luogo di Nascita")},
    {"15186643",p_Context.Translate("Città")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"206059350",p_Context.Translate("Codice Fiscale non attrib. dall'Agenzia delle Entrate ")},
    {"21587",p_Context.Translate("CAP")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"382511098",p_Context.Translate("Esegui aggiornamento dati")},
    {"443454",p_Context.Translate("Nome")},
    {"7383187",p_Context.Translate("Stati")},
    {"7776403",p_Context.Translate("Stato")},
    {"7776675",p_Context.Translate("Sesso")}};
    return l_translations;
  }
  void WriteStyles(arpg_modopen1BO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_modopen1.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_modopen1BO BO,ServletStatus status) {
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
  void WriteControls(arpg_modopen1BO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_modopen1BO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(504);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_modopen1BO BO,ServletStatus status) {
    status.out.println(
     "<div id='ODCPZZXLHY_DIV' class='UntitledBox'>" +
     "<div id='ODCPZZXLHY' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='ragione' id='FFEEVEUPBF' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_ragione))?"SELECTED":"")+">" +
     ""+status.context.Translate("Modifica dati per scarto da Entratel")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_ragione))?"SELECTED":"")+">" +
     ""+status.context.Translate("Rettifica di Comunicazione accettata da Entratel ma che si desidera cambiare")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('FFEEVEUPBF'),w_ragione,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XQSJGZVMDV_DIV'>" +
     "<label id='XQSJGZVMDV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rettifica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='datarett' id='JIYGZCDTPQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_datarett,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='JIYGZCDTPQ_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='JIYGZCDTPQ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='olddata' id='QLKRKJTVJT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_olddata,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oldintest' id='NEAUUYCSRF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oldintest,"C",16,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='NEAUUYCSRF_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='NEAUUYCSRF_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='WVHOQYPKFE_DIV'>" +
     "<input name='xcfestero' id='WVHOQYPKFE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_xcfestero,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_xcfestero)?"CHECKED":"")+">" +
     "<label id='WVHOQYPKFE_LBL' for='WVHOQYPKFE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale non attrib. dall'Agenzia delle Entrate "))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xcodfisc' id='KXGHBTYQDK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xcodfisc,"C",16,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xcognome' id='ZLEFBXLUTT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xcognome,"C",26,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='26' size='26' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xnome' id='TRZRNHUQSZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xnome,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='xsesso' id='VHDBEIXHTA' class='Combobox' tabindex='-1' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_xsesso))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maschile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_xsesso))?"SELECTED":"")+">" +
     ""+status.context.Translate("Femminile")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('VHDBEIXHTA'),w_xsesso,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NRLLUEOMLT_DIV'>" +
     "<label id='NRLLUEOMLT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Apertura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ISRGWEYPBE_DIV'>" +
     "<label id='ISRGWEYPBE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nuovo Intestatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='newintest' id='NOGBUOIVWB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_newintest,"C",16,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='NOGBUOIVWB_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='NOGBUOIVWB_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EHGZXQREHH_DIV'>" +
     "<label id='EHGZXQREHH'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragnew)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YMQGLGBXMV_DIV'>" +
     "<label id='YMQGLGBXMV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Vecchio Intestatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PUHCDZJWVF_DIV'>" +
     "<label id='PUHCDZJWVF'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragold)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='FRGFQEIHFB_DIV'>" +
     "<span id='FRGFQEIHFB_0_container'>" +
     "<input id='FRGFQEIHFB_0' name='FRGFQEIHFB' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_xtipopers))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='FRGFQEIHFB_0'>"+status.context.Translate("Persona Fisica")+"</label>" +
     "</span>" +
     "<span id='FRGFQEIHFB_1_container'>" +
     "<input id='FRGFQEIHFB_1' name='FRGFQEIHFB' type='radio' value="+SPLib.ToHTMLValue("D","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("D",CPLib.Trim(BO.w_xtipopers))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='FRGFQEIHFB_1'>"+status.context.Translate("Persona Giuridica")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_YBBLCLWLHJ()' tabindex='-1' id='YBBLCLWLHJ_HREF'>" +
     "<img id='YBBLCLWLHJ' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_MDWFLPZWFN()' tabindex='-1' style='display:none' id='MDWFLPZWFN_HREF'>" +
     "<img id='MDWFLPZWFN' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/elaborazione.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Esegui aggiornamento dati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Esegui aggiornamento dati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='ZSRVHHSRRD_DIV'>" +
     "<span id='ZSRVHHSRRD_0_container'>" +
     "<input id='ZSRVHHSRRD_0' name='ZSRVHHSRRD' type='radio' value="+SPLib.ToHTMLValue("M","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("M",CPLib.Trim(BO.w_tipochg))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='ZSRVHHSRRD_0'>"+status.context.Translate("Modifica dati Intestatario")+"</label>" +
     "</span>" +
     "<span id='ZSRVHHSRRD_1_container'>" +
     "<input id='ZSRVHHSRRD_1' name='ZSRVHHSRRD' type='radio' value="+SPLib.ToHTMLValue("C","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("C",CPLib.Trim(BO.w_tipochg))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='ZSRVHHSRRD_1'>"+status.context.Translate("Cambio Intestatario")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='VYHZGJKBSG_DIV' class='UntitledBox'>" +
     "<div id='VYHZGJKBSG' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HMTQCDJJDS_DIV'>" +
     "<label id='HMTQCDJJDS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modifica Dati Intestatario (Persona Fisica)"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AJUVDYOZZL_DIV'>" +
     "<label id='AJUVDYOZZL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SSUWRDQRDI_DIV'>" +
     "<label id='SSUWRDQRDI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HHYAFDYFPB_DIV'>" +
     "<label id='HHYAFDYFPB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HAZSNHXYTH_DIV'>" +
     "<label id='HAZSNHXYTH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DFMOVYUECJ_DIV'>" +
     "<label id='DFMOVYUECJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Comune di Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xnascomun' id='HBSWFKBFZJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xnascomun,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
     "<button id='HBSWFKBFZJ_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HBSWFKBFZJ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WHBMDRJRIX_DIV'>" +
     "<label id='WHBMDRJRIX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia (EE se estero)"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xtipinter' id='MPXBUDNRPY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xtipinter,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RNCFPZEWNP_DIV'>" +
     "<label id='RNCFPZEWNP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato di Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xnasstato' id='YDHXQFESNA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xnasstato,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
     "<button id='YDHXQFESNA_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='YDHXQFESNA_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OSVHVNFSTF_DIV'>" +
     "<label id='OSVHVNFSTF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data di Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xdatnasc' id='SBDBIBIUBZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xdatnasc,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.out.println(
     "<div id='OQKDUTOEEM_DIV' class='UntitledBox'>" +
     "<div id='OQKDUTOEEM' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xragold' id='ZAOZVSXTQF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xragold,"C",70,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TMGNSIMJWZ_DIV'>" +
     "<label id='TMGNSIMJWZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modifica Dati Intestatario (Persona Giuridica)"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xdesccit' id='WFUJRKYFYT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xdesccit,"C",40,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
     "<button id='WFUJRKYFYT_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='WFUJRKYFYT_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DECZZZAVTS_DIV'>" +
     "<label id='DECZZZAVTS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragione Sociale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FPPPNGTASY_DIV'>" +
     "<label id='FPPPNGTASY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città Sede Legale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xprovincia' id='QAZVAJDCHQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xprovincia,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xcap' id='ZRHYPFBGWI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xcap,"C",9,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='9' size='9' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SXBLVGTGMP_DIV'>" +
     "<label id='SXBLVGTGMP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HWPUVGUGYG_DIV'>" +
     "<label id='HWPUVGUGYG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nazione (UIC):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xpaese' id='CIECFYJCOG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_xpaese,"C",3,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='CIECFYJCOG_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='CIECFYJCOG_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<div id='QEMAGEFKQK_DIV' class='UntitledBox'>" +
     "<div id='QEMAGEFKQK' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AFTPFXBXCR_DIV'>" +
     "<label id='AFTPFXBXCR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cambio Intestatario"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WSJMXQEYEG_DIV'>" +
     "<label id='WSJMXQEYEG'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdessta)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AWATMAIZMU_DIV'>" +
     "<label id='AWATMAIZMU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MODIFICA DATI PER SCARTO RAPPORTO DA ENTRATEL ?"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XZISIOGTIO_DIV'>" +
     "<label id='XZISIOGTIO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C.A.P.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='olddatac' id='NCHAEUMUPJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_olddatac,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EVXMXJTANP_DIV'>" +
     "<label id='EVXMXJTANP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Chiusura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='idesito' id='RROSTBCQKE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_idesito,"C",8,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='8' size='8' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EFJEEIKTHM_DIV'>" +
     "<label id='EFJEEIKTHM' for='RROSTBCQKE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Esito Agenzia Entrate:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OLVLBDQTYW_DIV'>" +
     "<label id='OLVLBDQTYW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nuova Apertura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='newdatec' id='NICAEATMFV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_newdatec,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='NICAEATMFV_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='NICAEATMFV_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VYPUVNDTCE_DIV'>" +
     "<label id='VYPUVNDTCE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nuova Chiusura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='newdate' id='WYJHXYCTSP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_newdate,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='WYJHXYCTSP_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='WYJHXYCTSP_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_modopen1BL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_modopen1BL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_modopen1BL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_ragione,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datarett,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_olddata,"D",8,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_oldintest,"C",16,0)+","+SPLib.ToJSValue(BO.o_oldintest,"C",16,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_xcfestero,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcodfisc,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcognome,"C",26,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xnome,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xsesso,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_newintest,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragnew,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xtipopers,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldprog,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldidbase,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldrappo,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldnumrig,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldfile,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipochg,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xnascomun,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xtipinter,"C",2,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_xnasstato,"C",40,0)+","+SPLib.ToJSValue(BO.o_xnasstato,"C",40,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_xdatnasc,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragold,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesccit,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xprovincia,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcap,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xpaese,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdessta,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_olddatac,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idesito,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_newdatec,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_newdate,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldappo,"C",16,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_modopen1BO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_EHGZXQREHH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PUHCDZJWVF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WSJMXQEYEG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(509,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(677,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_modopen1"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'NEAUUYCSRF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'NOGBUOIVWB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'HBSWFKBFZJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CITTACITTA,PROVC,Ctbcitta",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
    status.out.print(",'YDHXQFESNA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("DESCRIDESCRICtbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'WFUJRKYFYT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CITTACITTA,CAP,PROVC,C,Ctbcitta",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
    status.out.print(",'CIECFYJCOG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODSTACODSTA,DESCRIC,Ctbstati",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
    status.out.print(",'EEESEXUZFK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOC,CODFISC,NASCOMUN,DATANASC,SESSO,NASSTATO,COGNOME,NOME,CFESTERO,DESCCIT,PAESE,PROVINCIA,CAP,TIPINTER,TIPOPERSC,C,C,C,D,C,C,C,C,N,C,C,C,C,C,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_modopen1","");
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
  void WriteMainFormScript(arpg_modopen1BO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_modopen1");
    status.out.println("function LanciaSalva() {");
    status.out.println("  if (Empty(w_datarett)) {");
    status.out.println("	  alert('La data di RETTIFICA è obbligatoria per le Variazioni/Cancellazioni')");
    status.out.println("	  return");
    status.out.println("  }  ");
    status.out.println("  if (Empty(w_newdate)) {");
    status.out.println("	  alert('Obbligatorio specificare data Inizio Rapporto')");
    status.out.println("	  return");
    status.out.println("  }");
    status.out.println("  if (w_tipochg=='M') {");
    status.out.println("	  if (Empty(w_xcodfisc) && w_xcfestero==0){");
    status.out.println("		  alert('Obbligatorio specificare Codice Fiscale Intestatario')");
    status.out.println("		  return");
    status.out.println("    }  ");
    status.out.println("    if (w_xtipopers=='P') {");
    status.out.println("		  if (Empty(w_xcognome)) {");
    status.out.println("			  alert('Obbligatorio specificare Cognome Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xnome)) {");
    status.out.println("			  alert('Obbligatorio specificare Nome Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xdatnasc)) {");
    status.out.println("			  alert('Obbligatorio specificare Data di nascita Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xsesso)) {");
    status.out.println("			  alert('Obbligatorio specificare Sesso Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xnascomun) && Empty(w_xnasstato)) {");
    status.out.println("			  alert('Obbligatorio specificare Comune/Stato di nascita Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xtipinter)) {");
    status.out.println("			  alert('Obbligatorio specificare Provincia Comune di nascita Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }    ");
    status.out.println("    } ");
    status.out.println("    else {");
    status.out.println("		  if (Empty(w_xragold)) {");
    status.out.println("			  alert('Obbligatorio specificare Denominazione Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xpaese)) {");
    status.out.println("			  alert('Obbligatorio specificare Stato sede legale Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xdesccit) && w_xpaese=='086') {");
    status.out.println("			  alert('Obbligatorio specificare Città sede legale Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }");
    status.out.println("		  if (Empty(w_xprovincia)&& w_xpaese=='086') {");
    status.out.println("			  alert('Obbligatorio specificare Provincia sede legale Intestatario')");
    status.out.println("			  return");
    status.out.println("		  }    ");
    status.out.println("    }");
    status.out.println("	} ");
    status.out.println("  else {");
    status.out.println("	  if (Empty(w_oldintest)) {");
    status.out.println("	    alert('Obbligatorio specificare Intestatario del Rapporto')");
    status.out.println("		  return");
    status.out.println("	  }");
    status.out.println("  }      ");
    status.out.println("  if (confirm('La modifica comporta obbligo di ricomunicare i dati!! \\n Si conferma la modifica ?')) {");
    status.out.println("    SetHypPar('m_cAction',AsAppletValue('start'));");
    status.out.println("    SetHypPar('m_cMode',AsAppletValue('hyperlink'));");
    status.out.println("    SendData('start',PlatformPathStart('arrt_modopen1')+'',HParApplet().asString());");
    status.out.println("  }  ");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_modopen1BO getBO(ServletStatus status) {
    arpg_modopen1BO BO = new arpg_modopen1BO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_modopen1BO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_modopen1BO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_modopen1BO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_modopen1BO BO) {
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
  void Discard(ServletStatus status,arpg_modopen1BO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_modopen1BO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",509);
    item.put("w",677);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_modopen1");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"497\",\"name\":\"Box_ODCPZZXLHY\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"ODCPZZXLHY\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"664\",\"x\":\"8\",\"y\":\"7\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"ragione\",\"page\":\"1\",\"spuid\":\"FFEEVEUPBF\",\"tabindex\":\"2\",\"textlist\":\"Modifica dati per scarto da Entratel,Rettifica di Comunicazione accettata da Entratel ma che si desidera cambiare\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"S"+"'"+","+"'"+"N"+"'"+"\",\"w\":\"328\",\"x\":\"336\",\"y\":\"11\",\"zone\":\"ODCPZZXLHY_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Data_Rettifica_\",\"page\":\"1\",\"spuid\":\"XQSJGZVMDV_DIV\",\"tabindex\":\"3\",\"type\":\"Label\",\"value\":\"Data Rettifica:\",\"w\":\"81\",\"x\":\"51\",\"y\":\"39\",\"zone\":\"ODCPZZXLHY_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"datarett\",\"page\":\"1\",\"spuid\":\"JIYGZCDTPQ\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"78\",\"x\":\"136\",\"y\":\"35\",\"zone\":\"ODCPZZXLHY_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"olddata\",\"page\":\"1\",\"spuid\":\"QLKRKJTVJT\",\"tabindex\":\"5\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"352\",\"y\":\"35\",\"zone\":\"ODCPZZXLHY_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"oldintest\",\"page\":\"1\",\"spuid\":\"NEAUUYCSRF\",\"tabindex\":\"6\",\"type\":\"Textbox\",\"w\":\"118\",\"x\":\"136\",\"y\":\"112\",\"zone\":\"ODCPZZXLHY_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Codice Fiscale Estero\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"xcfestero\",\"page\":\"1\",\"spuid\":\"WVHOQYPKFE\",\"tabindex\":\"7\",\"type\":\"Checkbox\",\"w\":\"280\",\"x\":\"384\",\"y\":\"140\",\"zone\":\"ODCPZZXLHY_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Codice Fiscale\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"xcodfisc\",\"page\":\"1\",\"spuid\":\"KXGHBTYQDK\",\"tabindex\":\"8\",\"type\":\"Textbox\",\"w\":\"136\",\"x\":\"136\",\"y\":\"161\",\"zone\":\"ODCPZZXLHY_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Cognome\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"26\",\"name\":\"xcognome\",\"page\":\"1\",\"spuid\":\"ZLEFBXLUTT\",\"tabindex\":\"9\",\"type\":\"Textbox\",\"w\":\"168\",\"x\":\"136\",\"y\":\"213\",\"zone\":\"VYHZGJKBSG_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Nome\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"25\",\"name\":\"xnome\",\"page\":\"1\",\"spuid\":\"TRZRNHUQSZ\",\"tabindex\":\"10\",\"type\":\"Textbox\",\"w\":\"162\",\"x\":\"352\",\"y\":\"213\",\"zone\":\"VYHZGJKBSG_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Sesso\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"xsesso\",\"page\":\"1\",\"spuid\":\"VHDBEIXHTA\",\"tabindex\":\"11\",\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":\"96\",\"x\":\"560\",\"y\":\"213\",\"zone\":\"VYHZGJKBSG_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Data_Apertura_\",\"page\":\"1\",\"spuid\":\"NRLLUEOMLT_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"Data Apertura:\",\"w\":\"108\",\"x\":\"240\",\"y\":\"39\",\"zone\":\"ODCPZZXLHY_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Nuovo_Intestatario_\",\"page\":\"1\",\"spuid\":\"ISRGWEYPBE_DIV\",\"tabindex\":\"13\",\"type\":\"Label\",\"value\":\"Nuovo Intestatario:\",\"w\":\"110\",\"x\":\"22\",\"y\":\"441\",\"zone\":\"QEMAGEFKQK_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"newintest\",\"page\":\"1\",\"spuid\":\"NOGBUOIVWB\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"118\",\"x\":\"136\",\"y\":\"437\",\"zone\":\"QEMAGEFKQK_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xragnew\",\"page\":\"1\",\"spuid\":\"EHGZXQREHH_DIV\",\"tabindex\":\"16\",\"type\":\"Label\",\"value\":\"w_xragnew\",\"w\":\"376\",\"x\":\"280\",\"y\":\"441\",\"zone\":\"QEMAGEFKQK_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Vecchio_Intestatario_\",\"page\":\"1\",\"spuid\":\"YMQGLGBXMV_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"Vecchio Intestatario:\",\"w\":\"118\",\"x\":\"14\",\"y\":\"116\",\"zone\":\"ODCPZZXLHY_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xragold\",\"page\":\"1\",\"spuid\":\"PUHCDZJWVF_DIV\",\"tabindex\":\"18\",\"type\":\"Label\",\"value\":\"w_xragold\",\"w\":\"384\",\"x\":\"280\",\"y\":\"116\",\"zone\":\"ODCPZZXLHY_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"xtipopers\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"FRGFQEIHFB\",\"tabindex\":\"19\",\"textlist\":\"Persona Fisica,Persona Giuridica\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"P"+"'"+","+"'"+"D"+"'"+"\",\"w\":\"214\",\"x\":\"136\",\"y\":\"140\",\"zone\":\"ODCPZZXLHY_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_YBBLCLWLHJ()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"YBBLCLWLHJ\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"20\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"336\",\"y\":\"469\",\"zone\":\"ODCPZZXLHY_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Esegui aggiornamento dati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_MDWFLPZWFN()\",\"name\":\"images_elaborazione_gif\",\"page\":\"1\",\"spuid\":\"MDWFLPZWFN\",\"src\":\"images\\/elaborazione.gif\",\"tabindex\":\"21\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"288\",\"y\":\"469\",\"zone\":\"ODCPZZXLHY_8\"}";
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
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"tipochg\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"ZSRVHHSRRD\",\"tabindex\":\"27\",\"textlist\":\"Modifica dati Intestatario,Cambio Intestatario\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"C"+"'"+"\",\"w\":\"279\",\"x\":\"136\",\"y\":\"91\",\"zone\":\"ODCPZZXLHY_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"88\",\"name\":\"Box_VYHZGJKBSG\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"VYHZGJKBSG\",\"tabindex\":\"28\",\"type\":\"Box\",\"w\":\"648\",\"x\":\"16\",\"y\":\"206\",\"zone\":\"ODCPZZXLHY_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Modifica_Dati_Intestatario__Persona_Fisica_\",\"page\":\"1\",\"spuid\":\"HMTQCDJJDS_DIV\",\"tabindex\":\"29\",\"type\":\"Label\",\"value\":\"Modifica Dati Intestatario (Persona Fisica)\",\"w\":\"238\",\"x\":\"16\",\"y\":\"189\",\"zone\":\"ODCPZZXLHY_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Fiscale_\",\"page\":\"1\",\"spuid\":\"AJUVDYOZZL_DIV\",\"tabindex\":\"30\",\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":\"72\",\"x\":\"60\",\"y\":\"165\",\"zone\":\"ODCPZZXLHY_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cognome_\",\"page\":\"1\",\"spuid\":\"SSUWRDQRDI_DIV\",\"tabindex\":\"31\",\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":\"49\",\"x\":\"83\",\"y\":\"217\",\"zone\":\"VYHZGJKBSG_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Nome_\",\"page\":\"1\",\"spuid\":\"HHYAFDYFPB_DIV\",\"tabindex\":\"32\",\"type\":\"Label\",\"value\":\"Nome:\",\"w\":\"31\",\"x\":\"317\",\"y\":\"217\",\"zone\":\"VYHZGJKBSG_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Sesso_\",\"page\":\"1\",\"spuid\":\"HAZSNHXYTH_DIV\",\"tabindex\":\"33\",\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":\"32\",\"x\":\"524\",\"y\":\"217\",\"zone\":\"VYHZGJKBSG_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Comune_di_Nascita_\",\"page\":\"1\",\"spuid\":\"DFMOVYUECJ_DIV\",\"tabindex\":\"34\",\"type\":\"Label\",\"value\":\"Comune di Nascita:\",\"w\":\"92\",\"x\":\"40\",\"y\":\"242\",\"zone\":\"VYHZGJKBSG_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Luogo di Nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"40\",\"name\":\"xnascomun\",\"page\":\"1\",\"spuid\":\"HBSWFKBFZJ\",\"tabindex\":\"35\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"136\",\"y\":\"238\",\"zone\":\"VYHZGJKBSG_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Provincia__EE_se_estero_\",\"page\":\"1\",\"spuid\":\"WHBMDRJRIX_DIV\",\"tabindex\":\"36\",\"type\":\"Label\",\"value\":\"Provincia (EE se estero)\",\"w\":\"114\",\"x\":\"425\",\"y\":\"241\",\"zone\":\"VYHZGJKBSG_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Provincia\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"2\",\"name\":\"xtipinter\",\"page\":\"1\",\"spuid\":\"MPXBUDNRPY\",\"tabindex\":\"37\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"544\",\"y\":\"238\",\"zone\":\"VYHZGJKBSG_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Stato_di_Nascita_\",\"page\":\"1\",\"spuid\":\"RNCFPZEWNP_DIV\",\"tabindex\":\"38\",\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":\"92\",\"x\":\"40\",\"y\":\"266\",\"zone\":\"VYHZGJKBSG_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stato di nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"40\",\"name\":\"xnasstato\",\"page\":\"1\",\"spuid\":\"YDHXQFESNA\",\"tabindex\":\"39\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"136\",\"y\":\"262\",\"zone\":\"VYHZGJKBSG_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Data_di_Nascita_\",\"page\":\"1\",\"spuid\":\"OSVHVNFSTF_DIV\",\"tabindex\":\"40\",\"type\":\"Label\",\"value\":\"Data di Nascita:\",\"w\":\"76\",\"x\":\"463\",\"y\":\"266\",\"zone\":\"VYHZGJKBSG_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Data Nascita\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"xdatnasc\",\"page\":\"1\",\"spuid\":\"SBDBIBIUBZ\",\"tabindex\":\"41\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"544\",\"y\":\"262\",\"zone\":\"VYHZGJKBSG_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"93\",\"name\":\"Box_OQKDUTOEEM\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"OQKDUTOEEM\",\"tabindex\":\"42\",\"type\":\"Box\",\"w\":\"648\",\"x\":\"16\",\"y\":\"318\",\"zone\":\"ODCPZZXLHY_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Ragione Sociale\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"70\",\"name\":\"xragold\",\"page\":\"1\",\"spuid\":\"ZAOZVSXTQF\",\"tabindex\":\"43\",\"type\":\"Textbox\",\"w\":\"438\",\"x\":\"136\",\"y\":\"325\",\"zone\":\"OQKDUTOEEM_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Modifica_Dati_Intestatario__Persona_Giuridica_\",\"page\":\"1\",\"spuid\":\"TMGNSIMJWZ_DIV\",\"tabindex\":\"44\",\"type\":\"Label\",\"value\":\"Modifica Dati Intestatario (Persona Giuridica)\",\"w\":\"256\",\"x\":\"16\",\"y\":\"301\",\"zone\":\"ODCPZZXLHY_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Citt\\u00E0\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"40\",\"name\":\"xdesccit\",\"page\":\"1\",\"spuid\":\"WFUJRKYFYT\",\"tabindex\":\"45\",\"type\":\"Textbox\",\"w\":\"262\",\"x\":\"136\",\"y\":\"353\",\"zone\":\"OQKDUTOEEM_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Ragione_Sociale_\",\"page\":\"1\",\"spuid\":\"DECZZZAVTS_DIV\",\"tabindex\":\"46\",\"type\":\"Label\",\"value\":\"Ragione Sociale:\",\"w\":\"79\",\"x\":\"53\",\"y\":\"329\",\"zone\":\"OQKDUTOEEM_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Citt\\u00E0_Sede_Legale_\",\"page\":\"1\",\"spuid\":\"FPPPNGTASY_DIV\",\"tabindex\":\"47\",\"type\":\"Label\",\"value\":\"Citt\\u00E0 Sede Legale:\",\"w\":\"88\",\"x\":\"44\",\"y\":\"357\",\"zone\":\"OQKDUTOEEM_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Provincia\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"2\",\"name\":\"xprovincia\",\"page\":\"1\",\"spuid\":\"QAZVAJDCHQ\",\"tabindex\":\"48\",\"type\":\"Textbox\",\"w\":\"32\",\"x\":\"480\",\"y\":\"353\",\"zone\":\"OQKDUTOEEM_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"CAP\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"9\",\"name\":\"xcap\",\"page\":\"1\",\"spuid\":\"ZRHYPFBGWI\",\"tabindex\":\"49\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"568\",\"y\":\"353\",\"zone\":\"OQKDUTOEEM_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Provincia_\",\"page\":\"1\",\"spuid\":\"SXBLVGTGMP_DIV\",\"tabindex\":\"50\",\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":\"47\",\"x\":\"428\",\"y\":\"357\",\"zone\":\"OQKDUTOEEM_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Nazione__UIC__\",\"page\":\"1\",\"spuid\":\"HWPUVGUGYG_DIV\",\"tabindex\":\"51\",\"type\":\"Label\",\"value\":\"Nazione (UIC):\",\"w\":\"71\",\"x\":\"61\",\"y\":\"385\",\"zone\":\"OQKDUTOEEM_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stato\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"xpaese\",\"page\":\"1\",\"spuid\":\"CIECFYJCOG\",\"tabindex\":\"52\",\"type\":\"Textbox\",\"w\":\"30\",\"x\":\"136\",\"y\":\"381\",\"zone\":\"OQKDUTOEEM_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"name\":\"Box_QEMAGEFKQK\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"QEMAGEFKQK\",\"tabindex\":\"53\",\"type\":\"Box\",\"w\":\"648\",\"x\":\"16\",\"y\":\"433\",\"zone\":\"ODCPZZXLHY_14\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Cambio_Intestatario\",\"page\":\"1\",\"spuid\":\"AFTPFXBXCR_DIV\",\"tabindex\":\"54\",\"type\":\"Label\",\"value\":\"Cambio Intestatario\",\"w\":\"256\",\"x\":\"16\",\"y\":\"416\",\"zone\":\"ODCPZZXLHY_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdessta\",\"page\":\"1\",\"spuid\":\"WSJMXQEYEG_DIV\",\"tabindex\":\"56\",\"type\":\"Label\",\"value\":\"w_xdessta\",\"w\":\"384\",\"x\":\"192\",\"y\":\"385\",\"zone\":\"OQKDUTOEEM_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"MODIFICA_DATI_PER_SCARTO_RAPPORTO_DA_ENTRATEL__\",\"page\":\"1\",\"spuid\":\"AWATMAIZMU_DIV\",\"tabindex\":\"57\",\"type\":\"Label\",\"value\":\"MODIFICA DATI PER SCARTO RAPPORTO DA ENTRATEL ?\",\"w\":\"310\",\"x\":\"16\",\"y\":\"15\",\"zone\":\"ODCPZZXLHY_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"C_A_P__\",\"page\":\"1\",\"spuid\":\"XZISIOGTIO_DIV\",\"tabindex\":\"58\",\"type\":\"Label\",\"value\":\"C.A.P.:\",\"w\":\"47\",\"x\":\"520\",\"y\":\"357\",\"zone\":\"OQKDUTOEEM_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"olddatac\",\"page\":\"1\",\"spuid\":\"NCHAEUMUPJ\",\"tabindex\":\"59\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"568\",\"y\":\"35\",\"zone\":\"ODCPZZXLHY_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Data_Chiusura_\",\"page\":\"1\",\"spuid\":\"EVXMXJTANP_DIV\",\"tabindex\":\"60\",\"type\":\"Label\",\"value\":\"Data Chiusura:\",\"w\":\"108\",\"x\":\"456\",\"y\":\"39\",\"zone\":\"ODCPZZXLHY_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Esito Agenzia Entrate\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"8\",\"name\":\"idesito\",\"page\":\"1\",\"spuid\":\"RROSTBCQKE\",\"tabindex\":\"61\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"136\",\"y\":\"63\",\"zone\":\"ODCPZZXLHY_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Esito_Agenzia_Entrate_\",\"page\":\"1\",\"spuid\":\"EFJEEIKTHM_DIV\",\"tabindex\":\"62\",\"type\":\"Label\",\"value\":\"Esito Agenzia Entrate:\",\"w\":\"128\",\"x\":\"8\",\"y\":\"67\",\"zone\":\"ODCPZZXLHY_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Nuova_Apertura_\",\"page\":\"1\",\"spuid\":\"OLVLBDQTYW_DIV\",\"tabindex\":\"64\",\"type\":\"Label\",\"value\":\"Nuova Apertura:\",\"w\":\"116\",\"x\":\"232\",\"y\":\"63\",\"zone\":\"ODCPZZXLHY_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"newdatec\",\"page\":\"1\",\"spuid\":\"NICAEATMFV\",\"tabindex\":\"65\",\"type\":\"Textbox\",\"w\":\"78\",\"x\":\"568\",\"y\":\"59\",\"zone\":\"ODCPZZXLHY_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Nuova_Chiusura_\",\"page\":\"1\",\"spuid\":\"VYPUVNDTCE_DIV\",\"tabindex\":\"66\",\"type\":\"Label\",\"value\":\"Nuova Chiusura:\",\"w\":\"108\",\"x\":\"456\",\"y\":\"63\",\"zone\":\"ODCPZZXLHY_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"newdate\",\"page\":\"1\",\"spuid\":\"WYJHXYCTSP\",\"tabindex\":\"67\",\"type\":\"Textbox\",\"w\":\"78\",\"x\":\"352\",\"y\":\"59\",\"zone\":\"ODCPZZXLHY_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_modopen1BO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_modopen1BO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_modopen1BO BO,ServletStatus status) {
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
     "<script src='arpg_modopen1?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_modopen1_proc.js'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath("Utilities.js");
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
    status.themeWriter.WriteBody_Begin(509,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_modopen1BO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_modopen1BO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_modopen1BO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_modopen1BO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_modopen1BO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_modopen1BO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("Utilities.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkcodfis.m_cEntityUid+"/arfn_chkcodfis.js'>" +
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
      arfn_chkcodfis.GetCallableNames(callable);
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_modopen1BO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_modopen1BO BO) {
    boolean result = true;
    return result;
  }
}
