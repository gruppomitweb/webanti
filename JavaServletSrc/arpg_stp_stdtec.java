import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_stp_stdtec extends SPDialogServlet implements SPInvokable {
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("DaDatOpe",source.GetCaller().GetDate("DaDatOpe","D",8,0));
      source.SetParameter("ADatOpe",source.GetCaller().GetDate("ADatOpe","D",8,0));
      source.SetParameter("c_dadata",source.GetCaller().GetString("c_dadata","C",8,0));
      source.SetParameter("c_adata",source.GetCaller().GetString("c_adata","C",8,0));
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
    // Ora esegue l' operazione richiesta da m_cAction
    arpg_stp_stdtecBO BO;
    BO = getBO(status);
    if (CPLib.eq(status.m_cAction,"start") || CPLib.eq(status.m_cAction,"query")) {
      Start(status,BO);
    } else if (CPLib.eq(status.m_cAction,"save")) {
      Save(status,BO);
    } else if (CPLib.eq(status.m_cAction,"discard")) {
      Discard(status,BO);
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
    } else {
      WriteFormPage(BO,status);
    }
  }
  public String getEntityTitle() {
    return "Stampa Verifica Operazioni (Standard Tecnici)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_stp_stdtec";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 712;
    l_eg.m_nEntityHeight = 216;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.zoomableTables = new String[]{"anadip","personbo"};
    l_eg.items = new SPItem[]{
                   new SPItem("daCodDip","C",6,0),
                   new SPItem("aCodDip","C",6,0),
                   new SPItem("DaDatOpe","D",8,0),
                   new SPItem("ADatOpe","D",8,0),
                   new SPItem("daCodCli","C",16,0),
                   new SPItem("aCodCli","C",16,0),
                   new SPItem("RAGSOC1","C",70,0),
                   new SPItem("RAGSOC2","C",70,0),
                   new SPItem("c_dadata","C",8,0),
                   new SPItem("c_adata","C",8,0),
                   new SPItem("DESCRIZ1","C",30,0),
                   new SPItem("DESCRIZ2","C",30,0)
                 };
    l_eg.m_lExecuteAtStart = false;
    l_eg.m_cQueryName = "";
    return l_eg;
  }
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"10662833243",p_Context.Translate("Ragione Sociale")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"844885719",p_Context.Translate("Stampa Verifica Operazioni (Standard Tecnici)")},
    {"1813072817",p_Context.Translate("Agenzie")},
    {"10557974447",p_Context.Translate("La data di fine periodo non deve essere minore di quella di inizio periodo!")},
    {"10505367639",p_Context.Translate("Persone / Società / Legali Rappresentanti")}};
    return l_translations;
  }
  void WriteStyles(arpg_stp_stdtecBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/HGIQCEYPZG/arpg_stp_stdtec.css'>" +
      "");
    }
  }
  void WriteSenderForm(ServletStatus status) {
    status.out.println(
     "<form name='FSender' style='margin:0' method='POST' action='"+status.m_cURL+"'>" +
    "");
    status.out.println(
     "<div>" +
    "");
    status.out.println(
     "<input name='m_cAction' type='hidden' value="+SPLib.ToHTMLValue("search","C",0,0,"", status.m_oRegSettings)+">" +
    "");
    status.out.println(
     "<input name='m_cMode' type='hidden' value="+SPLib.ToHTMLValue("","C",0,0,"", status.m_oRegSettings)+">" +
    "");
    status.out.println(
     "<input name='m_cAtExit' type='hidden' value="+SPLib.ToHTMLValue(status.m_cAtExit,"C",0,0,"", status.m_oRegSettings)+">" +
    "");
    status.out.println(
     "<input name='m_cDecoration' type='hidden' value="+SPLib.ToHTMLValue(status.m_cDecoration,"C",0,0,"", status.m_oRegSettings)+">" +
    "");
    status.out.println(
     "<input name='StartRow' type='hidden' value="+SPLib.ToHTMLValue(status.m_nStartRow,"I",0,0,"", status.m_oRegSettings)+">" +
    "");
    status.out.println(
     "<input name='m_nRows' type='hidden' value="+SPLib.ToHTMLValue(status.m_nRows,"I",0,0,"", status.m_oRegSettings)+">" +
    "");
    status.out.println(
     "<input name='m_bQuery' type='hidden' value="+SPLib.ToHTMLValue("indifferent","L",0,0,"", status.m_oRegSettings)+">" +
    "");
    if ( ! (status.m_bHasRS)) {
      status.out.println(
       "<input name='m_cRegionalSettings' type='hidden' value="+SPLib.ToHTMLValue("","C",0,0,"", status.m_oRegSettings)+">" +
      "");
    }
    status.out.println(
     "<input name='m_cWv' type='hidden' value="+SPLib.ToHTMLValue("","C",0,0,"", status.m_oRegSettings)+">" +
    "");
    if (CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")) {
    }
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</form>" +
    "");
  }
  void WriteMainForm(arpg_stp_stdtecBO BO,ServletStatus status) {
    status.out.println(
     "<div id='FrmMain' class='FormDefault'>" +
    "");
    if (CPLib.ne(status.m_cAltInterface,"")) {
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(arpg_stp_stdtecBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
  }
  void WriteControls_p1(arpg_stp_stdtecBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(216);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_stp_stdtecBO BO,ServletStatus status) {
    status.out.println(
     "<div id='XLVFHSOSYH_DIV'>" +
     "<div id='XLVFHSOSYH' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='daCodDip' id='UQFVYWSNYY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_daCodDip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6'>" +
     "<button id='UQFVYWSNYY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UQFVYWSNYY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='aCodDip' id='HXBJUMEZIA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_aCodDip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6'>" +
     "<button id='HXBJUMEZIA_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HXBJUMEZIA_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaDatOpe' id='DPKVLWHCIG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaDatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='DPKVLWHCIG_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DPKVLWHCIG_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADatOpe' id='MTJDZQTEIR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='MTJDZQTEIR_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='MTJDZQTEIR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='daCodCli' id='UYVYTEMEXX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_daCodCli,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16'>" +
     "<button id='UYVYTEMEXX_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UYVYTEMEXX_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='aCodCli' id='CJWUHWULAR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_aCodCli,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16'>" +
     "<button id='CJWUHWULAR_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='CJWUHWULAR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_XURLGQZZMU()' id='XURLGQZZMU_HREF' tabindex='-1'>" +
     "<img id='XURLGQZZMU' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_PTXYMSWBZO()' id='PTXYMSWBZO_HREF' tabindex='-1'>" +
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
     "<span class='SPLabel' id='PCILMATBXL_DIV'>" +
     "<label id='PCILMATBXL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VXJAZUGUIO_DIV'>" +
     "<label id='VXJAZUGUIO'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOC1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JGQCNSZOCQ_DIV'>" +
     "<label id='JGQCNSZOCQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XCBBNKIAUV_DIV'>" +
     "<label id='XCBBNKIAUV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOC2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZWZOQIGZCX_DIV'>" +
     "<label id='ZWZOQIGZCX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Agenzia/Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RXKVDVJPTZ_DIV'>" +
     "<label id='RXKVDVJPTZ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_DESCRIZ1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BGOVXFIBXQ_DIV'>" +
     "<label id='BGOVXFIBXQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ad Agenzia/Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LNFAXDLCMF_DIV'>" +
     "<label id='LNFAXDLCMF'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_DESCRIZ2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
    status.out.println(
     "<div id='SUGGEST_DIV_1' style='position:absolute;visibility:hidden'>" +
     "</div>" +
    "");
  }
  static void PrintState(arpg_stp_stdtecBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_stp_stdtecBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_stp_stdtecBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_daCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_aCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaDatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_daCodCli,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_aCodCli,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC1,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC2,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_dadata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_adata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRIZ1,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRIZ2,"C",30,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_stp_stdtecBO BO,ServletStatus status) {
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_VXJAZUGUIO = 'EEBWYSSZOT';");
    status.out.println("var e_XCBBNKIAUV = 'OMYFQFQBKS';");
    status.out.println("var e_RXKVDVJPTZ = 'KZUVAXOZJM';");
    status.out.println("var e_LNFAXDLCMF = 'KAYJAPTOYI';");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var enteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(216,"N",0,0)+ ";");
    status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(712,"N",0,0)+ ";");
    status.out.println("var m_bCalculating = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_nUserCode = " + SPLib.ToJSValue(status.context.UserCode(),"N",0,0)+ ";");
    status.out.println("var m_GroupsList = "+"["+status.context.GetGroupsList()+"]"+";");
    status.out.println("var m_RolesList = "+"["+status.context.GetAuthority().GetCurrentAssignement().GetRoleNames()+"]"+";");
    status.out.println("var m_cCompany = " + SPLib.ToJSValue(status.context.GetCompany(),"C",0,0)+ ";");
    status.out.println("var m_cLanguage = " + SPLib.ToJSValue(status.context.GetLanguage(),"C",0,0)+ ";");
    status.out.println("var m_cUserName = " + SPLib.ToJSValue(status.context.UserName(),"C",0,0)+ ";");
    status.out.println("var m_cAltInterface = " + SPLib.ToJSValue(status.m_cAltInterface,"C",0,0)+ ";");
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_stp_stdtec"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'UQFVYWSNYY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"']");
    status.out.print(",'HXBJUMEZIA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"']");
    status.out.print(",'UYVYTEMEXX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"']");
    status.out.print(",'CJWUHWULAR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"']");
    AppendCallableIDS(status,",");
    status.out.println("}");
    if (CPLib.eq(status.context.GetGlobalString("IsSPAdministrationInstalled"),"yes") && CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("var m_cProgName = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    } else {
      status.out.println("Zoom.p="+SPLib.ToJSValue(entityGlobals.name,"C",0,0)+";");
    }
    if (CPLib.eq(status.context.GetGlobalString("IsPortalStudioInstalled"),"yes") && SPLib.CanAccessEditor(status.context,"PortalStudio")) {
      status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_stp_stdtec","");
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
    status.PrintStateArrays();
    status.out.println("var m_cFunction = " + SPLib.ToJSValue("dialog","C",0,0)+ ";");
    status.out.println("var m_bFieldsUpdated = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
    status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
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
  void WriteMainFormScript(arpg_stp_stdtecBO BO,ServletStatus status) {
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("EnableControlsUnderCondition();");
    if (CPLib.eq(status.m_cAction,"start")) {
      status.out.println("initNoLocalVars(1,',"+status.source.GetParameter("m_cParameterSequence","")+",')");
    } else {
      status.out.println("initNoLocalVars(0);");
    }
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
    if (SPLib.IsMobile(status.request)) {
      status.out.println("if ( ! (window.frameElement)) {");
      status.out.println("setTimeout(function() { window.scrollTo(0, 1) }, 300);");
      status.out.println("}");
    }
    status.out.println("}");
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_stp_stdtecBO getBO(ServletStatus status) {
    arpg_stp_stdtecBO BO = new arpg_stp_stdtecBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_stp_stdtecBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_stp_stdtecBO BO) {
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_stp_stdtecBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_stp_stdtecBO BO) {
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
  void Discard(ServletStatus status,arpg_stp_stdtecBO BO) {
    status.m_bExit = true;
  }
  void Next(ServletStatus status,arpg_stp_stdtecBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_stp_stdtecBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_stp_stdtecBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),status.context.Translate("MSG_FORM_FUNCTION_"+status.m_cClientMode.toUpperCase())),"page");
    if ( ! (SPLib.IsIE7(status.request))) {
      status.out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
    }
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<head>" +
    "");
    status.out.println(
     "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/queryPage.css'>" +
    "");
    status.out.println(
     "<link rel='shortcut icon' href='../favicon.ico'>" +
    "");
    WriteMetaTags(status);
    status.out.println(
     "<script src='arpg_stp_stdtec?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='../controls.js' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    status.out.println("function PlatformPathStart(p_cName) {");
    status.out.println("return p_cName");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script src='../stdFunctions.js' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='../pageControls.js' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/GZQZEWYYDO/arpg_stp_stdtec_proc.js' type='text/javascript'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    status.out.println(
     "<script src='../"+status.m_cTheme+"/styleVariables.js' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='../"+status.m_cTheme+"/calendar.js' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='../"+status.m_cTheme+"/calculator.js' type='text/javascript'>" +
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
     "<script type='text/javascript'>" +
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
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=ManageKeys(event,false,false,true)";
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(216,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    status.out.println("AppletTag('Link');");
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    WriteSenderForm(status);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    if ( ! (CPLib.Empty(BO.LastErrorMessage()))) {
      status.out.println("var showed_error = "+SPLib.ToJSValue(BO.LastErrorMessage(),"L",0,0)+";");
      status.out.println("alert(showed_error);");
    }
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  void RaiseLoadedEntity(arpg_stp_stdtecBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:\""+status.m_cClientMode+"\"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_stp_stdtecBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script type='text/javascript'>" +
      "");
      RaiseEventSavedEntity(status,SPLib.ToJSValue("({})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(arpg_stp_stdtecBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script type='text/javascript'>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(arpg_stp_stdtecBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script type='text/javascript'>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(arpg_stp_stdtecBO BO,ServletStatus status) {
    WriteExitPage(status,SPLib.ToJSValue("({})","C",0,0));
  }
  void IncludeJS(ServletStatus status) {
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
      arrt_stp_stdtec.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
}
