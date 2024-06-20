import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_stprappo extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*UCYEPQOGBA*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("detope",source.GetCaller().GetString("detope","C",1,0));
      source.SetParameter("c_dadata",source.GetCaller().GetString("c_dadata","C",8,0));
      source.SetParameter("c_adata",source.GetCaller().GetString("c_adata","C",8,0));
      source.SetParameter("attiva",source.GetCaller().GetString("attiva","C",1,0));
      source.SetParameter("mod_attiva",source.GetCaller().GetString("mod_attiva","C",1,0));
      source.SetParameter("cancellata",source.GetCaller().GetString("cancellata","C",1,0));
      source.SetParameter("mod_copia",source.GetCaller().GetString("mod_copia","C",1,0));
      source.SetParameter("tipo",source.GetCaller().GetString("tipo","C",1,0));
      source.SetParameter("detana",source.GetCaller().GetString("detana","C",1,0));
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
    arpg_stprappoBO BO;
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
    return "Stampa Rapporti Continuativi (AUI)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_stprappo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 797;
    l_eg.m_nEntityHeight = 734;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"anarapbo","anadip","personbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("daRappo","C",25,0, "edit",""),
                   new SPItem("aRappo","C",25,0, "edit",""),
                   new SPItem("DaData","D",8,0, "edit",""),
                   new SPItem("AData","D",8,0, "edit",""),
                   new SPItem("coddip","C",6,0, "edit","Dipendenza / Agenzia"),
                   new SPItem("desrap1","C",50,0, "hide","Descrizione"),
                   new SPItem("desrap2","C",50,0, "hide","Descrizione"),
                   new SPItem("detope","C",1,0, "edit",""),
                   new SPItem("c_dadata","C",8,0, "hide",""),
                   new SPItem("c_adata","C",8,0, "hide",""),
                   new SPItem("attiva","C",1,0, "edit",""),
                   new SPItem("mod_attiva","C",1,0, "edit",""),
                   new SPItem("cancellata","C",1,0, "edit",""),
                   new SPItem("mod_copia","C",1,0, "edit",""),
                   new SPItem("tipo","C",1,0, "edit",""),
                   new SPItem("detana","C",1,0, "edit",""),
                   new SPItem("flgtit","C",1,0, "edit",""),
                   new SPItem("flgdel","C",1,0, "edit",""),
                   new SPItem("desdip","C",30,0, "hide","Descrizione"),
                   new SPItem("DaSogg","C",16,0, "edit","Da Soggetto"),
                   new SPItem("xDaRag","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("ASogg","C",16,0, "edit","Da Soggetto"),
                   new SPItem("xARag","C",70,0, "hide","Ragione Sociale")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_stprappoBO BO) {
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
    l_translations=new String[][]{{"10013320170",p_Context.Translate("2 - Copia di registrazione cancellata")},
    {"10050016386",p_Context.Translate("Dettaglio anagrafico (Solo Excel)")},
    {"10387154264",p_Context.Translate("Il valore deve essere maggiore o uguale a quello da Rapporto")},
    {"10522167224",p_Context.Translate("0 - registrazione attiva")},
    {"1056156582",p_Context.Translate("1 - registrazione derivante da modifica")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10684169980",p_Context.Translate("Stampa Rapporti Continuativi (AUI)")},
    {"11109078776",p_Context.Translate("Da Soggetto")},
    {"116285036",p_Context.Translate("Dipendenza / Agenzia")},
    {"12002828349",p_Context.Translate("Rapporti Continuativi in essere")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"176013972",p_Context.Translate("Delegati")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"217744641",p_Context.Translate("Stampa con dettaglio informazioni")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"338639962",p_Context.Translate("Titolari Effettivi")},
    {"346251140",p_Context.Translate("3 - Copia di registrazione modificata")}};
    return l_translations;
  }
  void WriteStyles(arpg_stprappoBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_stprappo.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_stprappoBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_stprappoBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_stprappoBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_stprappoBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(729);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_stprappoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='YPYMOEKGTF_DIV' class='UntitledBox'>" +
     "<div id='YPYMOEKGTF' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='daRappo' id='UYVYTEMEXX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_daRappo,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
     "<button id='UYVYTEMEXX_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UYVYTEMEXX_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='aRappo' id='CJWUHWULAR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_aRappo,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
     "<button id='CJWUHWULAR_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='CJWUHWULAR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaData' id='AITVTFTATA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='AITVTFTATA_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='AITVTFTATA_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='AData' id='KGOPKMFAZV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='KGOPKMFAZV_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='KGOPKMFAZV_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='coddip' id='ZNXWTQHRAY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_coddip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='ZNXWTQHRAY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='ZNXWTQHRAY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_XURLGQZZMU()' tabindex='"+status.m_nTabIndex+"' id='XURLGQZZMU_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
     "<span id='XURLGQZZMU'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)60165))+"" +
     "</span>" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PCILMATBXL_DIV'>" +
     "<label id='PCILMATBXL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VXJAZUGUIO_DIV'>" +
     "<label id='VXJAZUGUIO'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_desrap1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JGQCNSZOCQ_DIV'>" +
     "<label id='JGQCNSZOCQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XCBBNKIAUV_DIV'>" +
     "<label id='XCBBNKIAUV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_desrap2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='KRWIPWBLIZ_DIV'>" +
     "<input name='detope' id='KRWIPWBLIZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_detope,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_detope))?"CHECKED":"")+">" +
     "<label id='KRWIPWBLIZ_LBL' for='KRWIPWBLIZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Stampa con dettaglio informazioni"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_RPFMUWVENA()' tabindex='"+status.m_nTabIndex+"' id='RPFMUWVENA_HREF' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<span id='RPFMUWVENA'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)59890))+"" +
     "</span>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_RUYTQICXFP()' tabindex='"+status.m_nTabIndex+"' id='RUYTQICXFP_HREF' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<span id='RUYTQICXFP'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)60044))+"" +
     "</span>" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NGVOZRVMWR_DIV'>" +
     "<label id='NGVOZRVMWR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Informazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WICQRPVOOM_DIV'>" +
     "<label id='WICQRPVOOM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Informazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TGNDMRCJLI_DIV'>" +
     "<label id='TGNDMRCJLI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("STATO DELLA REGISTRAZIONE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NPNISIVXKK_DIV'>" +
     "<input name='attiva' id='NPNISIVXKK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_attiva,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("0",CPLib.Trim(BO.w_attiva))?"CHECKED":"")+">" +
     "<label id='NPNISIVXKK_LBL' for='NPNISIVXKK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("0 - registrazione attiva"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='XUIECEYUER_DIV' class='UntitledBox'>" +
     "<div id='XUIECEYUER' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='RFAMRJFBMI_DIV'>" +
     "<input name='mod_attiva' id='RFAMRJFBMI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_mod_attiva,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("1",CPLib.Trim(BO.w_mod_attiva))?"CHECKED":"")+">" +
     "<label id='RFAMRJFBMI_LBL' for='RFAMRJFBMI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("1 - registrazione derivante da modifica"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DMFWCILZEL_DIV'>" +
     "<input name='cancellata' id='DMFWCILZEL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_cancellata,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("2",CPLib.Trim(BO.w_cancellata))?"CHECKED":"")+">" +
     "<label id='DMFWCILZEL_LBL' for='DMFWCILZEL' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2 - Copia di registrazione cancellata"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='FNXXQDPJEK_DIV'>" +
     "<input name='mod_copia' id='FNXXQDPJEK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_mod_copia,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("3",CPLib.Trim(BO.w_mod_copia))?"CHECKED":"")+">" +
     "<label id='FNXXQDPJEK_LBL' for='FNXXQDPJEK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("3 - Copia di registrazione modificata"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='QAFQSIPUBY_DIV' class='UntitledBox'>" +
     "<div id='QAFQSIPUBY' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EIKNNNXYRB_DIV'>" +
     "<label id='EIKNNNXYRB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPO RAPPORTO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='HOUDAUAIJN_DIV'>" +
     "<div id='HOUDAUAIJN_0_container'>" +
     "<input id='HOUDAUAIJN_0' name='HOUDAUAIJN' type='radio' value="+SPLib.ToHTMLValue("T","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("T",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='HOUDAUAIJN_0'>"+status.context.Translate("Tutti i rapporti")+"</label>" +
     "</div>" +
     "<div id='HOUDAUAIJN_1_container'>" +
     "<input id='HOUDAUAIJN_1' name='HOUDAUAIJN' type='radio' value="+SPLib.ToHTMLValue("A","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("A",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='HOUDAUAIJN_1'>"+status.context.Translate("Solo i rapporti aperti")+"</label>" +
     "</div>" +
     "<div id='HOUDAUAIJN_2_container'>" +
     "<input id='HOUDAUAIJN_2' name='HOUDAUAIJN' type='radio' value="+SPLib.ToHTMLValue("C","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("C",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='HOUDAUAIJN_2'>"+status.context.Translate("Solo i rapporti chiusi")+"</label>" +
     "</div>" +
     "<div id='HOUDAUAIJN_3_container'>" +
     "<input id='HOUDAUAIJN_3' name='HOUDAUAIJN' type='radio' value="+SPLib.ToHTMLValue("1","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("1",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='HOUDAUAIJN_3'>"+status.context.Translate("Solo i rapporti aperti senza titolari")+"</label>" +
     "</div>" +
     "<div id='HOUDAUAIJN_4_container'>" +
     "<input id='HOUDAUAIJN_4' name='HOUDAUAIJN' type='radio' value="+SPLib.ToHTMLValue("2","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("2",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='HOUDAUAIJN_4'>"+status.context.Translate("Solo i rapporti chiusi senza titolari")+"</label>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='BGSKTJIZGQ_DIV'>" +
     "<input name='detana' id='BGSKTJIZGQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_detana,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_detana))?"CHECKED":"")+">" +
     "<label id='BGSKTJIZGQ_LBL' for='BGSKTJIZGQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Dettaglio anagrafico (Solo Excel)"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LMSVTJSWTT_DIV' style='display:none'>" +
     "<label id='LMSVTJSWTT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inserire anche i dati di:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ULDTTBEWIQ_DIV' style='display:none'>" +
     "<input name='flgtit' id='ULDTTBEWIQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgtit,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgtit))?"CHECKED":"")+">" +
     "<label id='ULDTTBEWIQ_LBL' for='ULDTTBEWIQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Titolari Effettivi"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='JVAYGFIMTX_DIV' style='display:none'>" +
     "<input name='flgdel' id='JVAYGFIMTX' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgdel,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgdel))?"CHECKED":"")+">" +
     "<label id='JVAYGFIMTX_LBL' for='JVAYGFIMTX' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Delegati"))+"</label>" +
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
     "<span class='SPLabel' id='YCCWJHXBSK_DIV'>" +
     "<label id='YCCWJHXBSK' for='ZNXWTQHRAY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dipendenza / Agenzia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UKVSKINWXW_DIV'>" +
     "<label id='UKVSKINWXW'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_desdip)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TYIWXFLLFY_DIV'>" +
     "<label id='TYIWXFLLFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='750' height='400' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaSogg' id='RGLTWKIWPY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaSogg,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='RGLTWKIWPY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='RGLTWKIWPY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NJZHHGRCUF_DIV'>" +
     "<label id='NJZHHGRCUF' for='RGLTWKIWPY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Soggetto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DPLASECNGE_DIV'>" +
     "<label id='DPLASECNGE'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xDaRag)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ASogg' id='USKGWKJFWW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASogg,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='USKGWKJFWW_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='USKGWKJFWW_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XWICOJPCNN_DIV'>" +
     "<label id='XWICOJPCNN' for='USKGWKJFWW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Soggetto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XADEIGCIYD_DIV'>" +
     "<label id='XADEIGCIYD'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xARag)+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_stprappoBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_stprappoBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_stprappoBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_daRappo,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_aRappo,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_coddip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desrap1,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desrap2,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_detope,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_dadata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_adata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_attiva,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mod_attiva,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cancellata,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mod_copia,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipo,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_detana,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgtit,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgdel,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaSogg,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDaRag,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASogg,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xARag,"C",70,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_stprappoBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_VXJAZUGUIO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XCBBNKIAUV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UKVSKINWXW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TYIWXFLLFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DPLASECNGE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XADEIGCIYD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(734,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(797,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_stprappo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'UYVYTEMEXX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("RAPPORTORAPPORTO,DESCRAPC,Canarapbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'CJWUHWULAR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("RAPPORTORAPPORTO,DESCRAPC,Canarapbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'ZNXWTQHRAY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    status.out.print(",'RGLTWKIWPY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'USKGWKJFWW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_stprappo","");
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
  void WriteMainFormScript(arpg_stprappoBO BO,ServletStatus status) {
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
  arpg_stprappoBO getBO(ServletStatus status) {
    arpg_stprappoBO BO = new arpg_stprappoBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_stprappoBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_stprappoBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_stprappoBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_stprappoBO BO) {
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
  void Discard(ServletStatus status,arpg_stprappoBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_stprappoBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",734);
    item.put("w",797);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_stprappo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"720\",\"name\":\"Box_YPYMOEKGTF\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"YPYMOEKGTF\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"784\",\"x\":\"8\",\"y\":\"9\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"25\",\"name\":\"daRappo\",\"page\":\"1\",\"spuid\":\"UYVYTEMEXX\",\"tabindex\":\"2\",\"type\":\"Textbox\",\"w\":\"162\",\"x\":\"104\",\"y\":\"18\",\"zone\":\"YPYMOEKGTF_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"25\",\"name\":\"aRappo\",\"page\":\"1\",\"spuid\":\"CJWUHWULAR\",\"tabindex\":\"3\",\"type\":\"Textbox\",\"w\":\"162\",\"x\":\"104\",\"y\":\"45\",\"zone\":\"YPYMOEKGTF_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaData\",\"page\":\"1\",\"spuid\":\"AITVTFTATA\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"152\",\"y\":\"126\",\"zone\":\"YPYMOEKGTF_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"AData\",\"page\":\"1\",\"spuid\":\"KGOPKMFAZV\",\"tabindex\":\"5\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"384\",\"y\":\"126\",\"zone\":\"YPYMOEKGTF_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Dipendenza \\/ Agenzia\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"coddip\",\"page\":\"1\",\"spuid\":\"ZNXWTQHRAY\",\"tabindex\":\"6\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"152\",\"y\":\"153\",\"zone\":\"YPYMOEKGTF_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_XURLGQZZMU()\",\"name\":\"_60165\",\"page\":\"1\",\"spuid\":\"XURLGQZZMU\",\"tabindex\":\"7\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"664\",\"y\":\"324\",\"zone\":\"YPYMOEKGTF_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Rapporto_\",\"page\":\"1\",\"spuid\":\"PCILMATBXL_DIV\",\"tabindex\":\"8\",\"type\":\"Label\",\"value\":\"Da Rapporto:\",\"w\":\"85\",\"x\":\"16\",\"y\":\"22\",\"zone\":\"YPYMOEKGTF_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"18\",\"href\":\" \",\"name\":\"w_desrap1\",\"page\":\"1\",\"spuid\":\"VXJAZUGUIO_DIV\",\"tabindex\":\"10\",\"type\":\"Label\",\"value\":\"w_desrap1\",\"w\":\"472\",\"x\":\"290\",\"y\":\"20\",\"zone\":\"YPYMOEKGTF_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Rapporto_\",\"page\":\"1\",\"spuid\":\"JGQCNSZOCQ_DIV\",\"tabindex\":\"11\",\"type\":\"Label\",\"value\":\"A Rapporto:\",\"w\":\"85\",\"x\":\"16\",\"y\":\"49\",\"zone\":\"YPYMOEKGTF_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"18\",\"href\":\" \",\"name\":\"w_desrap2\",\"page\":\"1\",\"spuid\":\"XCBBNKIAUV_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"w_desrap2\",\"w\":\"472\",\"x\":\"290\",\"y\":\"47\",\"zone\":\"YPYMOEKGTF_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"detope\",\"page\":\"1\",\"spuid\":\"KRWIPWBLIZ\",\"tabindex\":\"14\",\"type\":\"Checkbox\",\"w\":\"272\",\"x\":\"24\",\"y\":\"180\",\"zone\":\"YPYMOEKGTF_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_RPFMUWVENA()\",\"name\":\"_59890\",\"page\":\"1\",\"spuid\":\"RPFMUWVENA\",\"tabindex\":\"15\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"720\",\"y\":\"324\",\"zone\":\"YPYMOEKGTF_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_RUYTQICXFP()\",\"name\":\"_60044\",\"page\":\"1\",\"spuid\":\"RUYTQICXFP\",\"tabindex\":\"16\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"608\",\"y\":\"324\",\"zone\":\"YPYMOEKGTF_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Informazione_\",\"page\":\"1\",\"spuid\":\"NGVOZRVMWR_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"Da Data Informazione:\",\"w\":\"127\",\"x\":\"22\",\"y\":\"130\",\"zone\":\"YPYMOEKGTF_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Informazione_\",\"page\":\"1\",\"spuid\":\"WICQRPVOOM_DIV\",\"tabindex\":\"18\",\"type\":\"Label\",\"value\":\"A Data Informazione:\",\"w\":\"127\",\"x\":\"254\",\"y\":\"130\",\"zone\":\"YPYMOEKGTF_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"href\":\" \",\"name\":\"STATO_DELLA_REGISTRAZIONE\",\"page\":\"1\",\"spuid\":\"TGNDMRCJLI_DIV\",\"tabindex\":\"21\",\"type\":\"Label\",\"value\":\"STATO DELLA REGISTRAZIONE\",\"w\":\"248\",\"x\":\"16\",\"y\":\"234\",\"zone\":\"XUIECEYUER_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"attiva\",\"page\":\"1\",\"spuid\":\"NPNISIVXKK\",\"tabindex\":\"22\",\"type\":\"Checkbox\",\"w\":\"216\",\"x\":\"40\",\"y\":\"260\",\"zone\":\"XUIECEYUER_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"153\",\"name\":\"Box_XUIECEYUER\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"XUIECEYUER\",\"tabindex\":\"23\",\"type\":\"Box\",\"w\":\"248\",\"x\":\"16\",\"y\":\"234\",\"zone\":\"YPYMOEKGTF_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"mod_attiva\",\"page\":\"1\",\"spuid\":\"RFAMRJFBMI\",\"tabindex\":\"24\",\"type\":\"Checkbox\",\"w\":\"216\",\"x\":\"40\",\"y\":\"281\",\"zone\":\"XUIECEYUER_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"cancellata\",\"page\":\"1\",\"spuid\":\"DMFWCILZEL\",\"tabindex\":\"25\",\"type\":\"Checkbox\",\"w\":\"216\",\"x\":\"40\",\"y\":\"302\",\"zone\":\"XUIECEYUER_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"mod_copia\",\"page\":\"1\",\"spuid\":\"FNXXQDPJEK\",\"tabindex\":\"26\",\"type\":\"Checkbox\",\"w\":\"216\",\"x\":\"40\",\"y\":\"323\",\"zone\":\"XUIECEYUER_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"153\",\"name\":\"Box_QAFQSIPUBY\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"QAFQSIPUBY\",\"tabindex\":\"27\",\"type\":\"Box\",\"w\":\"248\",\"x\":\"304\",\"y\":\"234\",\"zone\":\"YPYMOEKGTF_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"href\":\" \",\"name\":\"TIPO_RAPPORTO\",\"page\":\"1\",\"spuid\":\"EIKNNNXYRB_DIV\",\"tabindex\":\"28\",\"type\":\"Label\",\"value\":\"TIPO RAPPORTO\",\"w\":\"240\",\"x\":\"304\",\"y\":\"234\",\"zone\":\"QAFQSIPUBY_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"117\",\"name\":\"tipo\",\"orientation\":\"vertical\",\"page\":\"1\",\"spuid\":\"HOUDAUAIJN\",\"tabindex\":\"29\",\"textlist\":\"Tutti i rapporti,Solo i rapporti aperti,Solo i rapporti chiusi,Solo i rapporti aperti senza titolari,Solo i rapporti chiusi senza titolari\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"T"+"'"+","+"'"+"A"+"'"+","+"'"+"C"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":\"232\",\"x\":\"312\",\"y\":\"261\",\"zone\":\"QAFQSIPUBY_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"detana\",\"page\":\"1\",\"spuid\":\"BGSKTJIZGQ\",\"tabindex\":\"30\",\"type\":\"Checkbox\",\"w\":\"272\",\"x\":\"24\",\"y\":\"207\",\"zone\":\"YPYMOEKGTF_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Inserire_anche_i_dati_di_\",\"page\":\"1\",\"spuid\":\"LMSVTJSWTT_DIV\",\"tabindex\":\"31\",\"type\":\"Label\",\"value\":\"Inserire anche i dati di:\",\"w\":\"121\",\"x\":\"360\",\"y\":\"207\",\"zone\":\"YPYMOEKGTF_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgtit\",\"page\":\"1\",\"spuid\":\"ULDTTBEWIQ\",\"tabindex\":\"32\",\"type\":\"Checkbox\",\"w\":\"120\",\"x\":\"491\",\"y\":\"202\",\"zone\":\"YPYMOEKGTF_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgdel\",\"page\":\"1\",\"spuid\":\"JVAYGFIMTX\",\"tabindex\":\"33\",\"type\":\"Checkbox\",\"w\":\"120\",\"x\":\"627\",\"y\":\"202\",\"zone\":\"YPYMOEKGTF_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"768\",\"x\":\"16\",\"y\":\"396\",\"zone\":\"YPYMOEKGTF_12\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Dipendenza___Agenzia_\",\"page\":\"1\",\"spuid\":\"YCCWJHXBSK_DIV\",\"tabindex\":\"35\",\"type\":\"Label\",\"value\":\"Dipendenza \\/ Agenzia:\",\"w\":\"138\",\"x\":\"14\",\"y\":\"157\",\"zone\":\"YPYMOEKGTF_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"18\",\"href\":\" \",\"name\":\"w_desdip\",\"page\":\"1\",\"spuid\":\"UKVSKINWXW_DIV\",\"tabindex\":\"37\",\"type\":\"Label\",\"value\":\"w_desdip\",\"w\":\"472\",\"x\":\"232\",\"y\":\"155\",\"zone\":\"YPYMOEKGTF_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"234\",\"href\":\" \",\"name\":\"__iframe_width__750__height__400__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"TYIWXFLLFY_DIV\",\"tabindex\":\"38\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"750"+"'"+" height="+"'"+"400"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"768\",\"x\":\"16\",\"y\":\"486\",\"zone\":\"YPYMOEKGTF_13\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Da Soggetto\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"DaSogg\",\"page\":\"1\",\"spuid\":\"RGLTWKIWPY\",\"tabindex\":\"39\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"104\",\"y\":\"72\",\"zone\":\"YPYMOEKGTF_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Soggetto_\",\"page\":\"1\",\"spuid\":\"NJZHHGRCUF_DIV\",\"tabindex\":\"40\",\"type\":\"Label\",\"value\":\"Da Soggetto:\",\"w\":\"85\",\"x\":\"16\",\"y\":\"76\",\"zone\":\"YPYMOEKGTF_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"18\",\"href\":\" \",\"name\":\"w_xDaRag\",\"page\":\"1\",\"spuid\":\"DPLASECNGE_DIV\",\"tabindex\":\"42\",\"type\":\"Label\",\"value\":\"w_xDaRag\",\"w\":\"472\",\"x\":\"248\",\"y\":\"72\",\"zone\":\"YPYMOEKGTF_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Da Soggetto\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"ASogg\",\"page\":\"1\",\"spuid\":\"USKGWKJFWW\",\"tabindex\":\"43\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"104\",\"y\":\"99\",\"zone\":\"YPYMOEKGTF_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Soggetto_\",\"page\":\"1\",\"spuid\":\"XWICOJPCNN_DIV\",\"tabindex\":\"44\",\"type\":\"Label\",\"value\":\"Da Soggetto:\",\"w\":\"85\",\"x\":\"16\",\"y\":\"103\",\"zone\":\"YPYMOEKGTF_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"18\",\"href\":\" \",\"name\":\"w_xARag\",\"page\":\"1\",\"spuid\":\"XADEIGCIYD_DIV\",\"tabindex\":\"45\",\"type\":\"Label\",\"value\":\"w_xARag\",\"w\":\"472\",\"x\":\"248\",\"y\":\"99\",\"zone\":\"YPYMOEKGTF_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_stprappoBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_stprappoBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_stprappoBO BO,ServletStatus status) {
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
     "<script src='arpg_stprappo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_stprappo_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(734,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_stprappoBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_stprappoBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_stprappoBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_stprappoBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_stprappoBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_stprappoBO BO,ServletStatus status) {
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
      arrt_stprappo.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_stprappoBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_stprappoBO BO) {
    boolean result = true;
    return result;
  }
}
