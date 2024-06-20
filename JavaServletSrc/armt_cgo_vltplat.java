import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_vltplat extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*487ddc51*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_vltplat";
    }
    public String w_VPCODICE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_VPCODICE,context,"cgo_vltplat","VPCODICE","C",2,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='VPCODICE' type='hidden' value="+SPLib.ToHTMLValue(w_VPCODICE,"C",2,0)+">" +
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
    armt_cgo_vltplatBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_vltplat;
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
      status.w_VPCODICE = BO.w_VPCODICE;
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
    return "PIattaforme VLT (CGO)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_vltplat";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 637;
    l_eg.m_nEntityHeight = 841;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_vltplat"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("File","Cartella File di Import","horizontal_section"),new ZoneItem("File1","File di Import 1","horizontal_section"),new ZoneItem("File2","File di Import 2","horizontal_section"),new ZoneItem("File3","File di Import 3","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"VPCODICE"};
    l_eg.items = new SPItem[]{
                   new SPItem("VPCODICE","C",2,0, "edit","Codice"),
                   new SPItem("VPDESCRI","C",50,0, "edit","Descrizione"),
                   new SPItem("VPFLGATT","C",1,0, "edit","Piattaforma Attiva"),
                   new SPItem("VPIDAAMS","C",16,0, "edit","ID AAMS"),
                   new SPItem("VPCODPIAT","N",4,0, "edit","Codice Piasttaforma (da CSV)"),
                   new SPItem("VPSIGLAPIAT","C",3,0, "edit","Sigla Piattaforma"),
                   new SPItem("VPPROVENIENZA","C",1,0, "edit","Provenienza"),
                   new SPItem("VPVLTCODPLAT","N",4,0, "edit","Codice Piattaforma VLT"),
                   new SPItem("VPFLGCRYPTO","C",1,0, "edit","Check SSL"),
                   new SPItem("VFPKAYCRYPTO","M",10,0, "edit","Chiave Crittografazione"),
                   new SPItem("VPDIRFILE","C",30,0, "edit","Cartella File Import"),
                   new SPItem("VPFILEINTESTA1","C",1,0, "edit","Presenza riga intestazioni"),
                   new SPItem("VPFFILESPERATOR1","C",1,0, "edit","Separatore campi"),
                   new SPItem("VPFILEFORDATA1","C",1,0, "edit","Formato Data"),
                   new SPItem("VPPREFFILE1","C",30,0, "edit","Prefisso file"),
                   new SPItem("VPFILEINTESTA2","C",1,0, "edit","Presenza riga intestazioni"),
                   new SPItem("VPFFILESPERATOR2","C",1,0, "edit","Separatore campi"),
                   new SPItem("VPFILEFORDATA2","C",1,0, "edit","Formato Data"),
                   new SPItem("VPPREFFILE2","C",30,0, "edit","Prefisso file"),
                   new SPItem("VPFILEINTESTA3","C",1,0, "edit","Presenza riga intestazioni"),
                   new SPItem("VPFFILESPERATOR3","C",1,0, "edit","Separatore campi"),
                   new SPItem("VPFILEFORDATA3","C",1,0, "edit","Formato Data"),
                   new SPItem("VPPREFFILE3","C",30,0, "edit","Prefisso file"),
                   new SPItem("VPFLGPRESUF1","C",1,0, "edit","Prefisso o Suffisso"),
                   new SPItem("VPFLGPRESUF2","C",1,0, "edit","Prefisso o Suffisso"),
                   new SPItem("VPFLGPRESUF3","C",1,0, "edit","Prefisso o Suffisso"),
                   new SPItem("VFPFLAGIMPORT","C",1,0, "edit","Piattaforma per import"),
                   new SPItem("VFPTIPOFILE1","C",1,0, "edit","Tipo File 1 (Struttura)"),
                   new SPItem("VFPTIPOFILE2","C",1,0, "edit","Tipo File 2 (Struttura)"),
                   new SPItem("VFPTIPOFILE3","C",1,0, "edit","Tipo File 3 (Struttura)")
                 };
    l_eg.m_lHasHistorical = false;
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_vltplatBO BO) {
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
    l_translations=new String[][]{{"10160733186",p_Context.Translate("Tipo File 3 (Struttura)")},
    {"10160733442",p_Context.Translate("Tipo File 2 (Struttura)")},
    {"10160733698",p_Context.Translate("Tipo File 1 (Struttura)")},
    {"10357365663",p_Context.Translate("Codice Piasttaforma (da CSV)")},
    {"1035812146",p_Context.Translate("Presenza riga intestazione")},
    {"1035812210",p_Context.Translate("Presenza riga intestazioni")},
    {"10586713253",p_Context.Translate("Piattaforma per import")},
    {"11038861271",p_Context.Translate("Codice Piattaforma VLT")},
    {"11068679298",p_Context.Translate("Provenienza")},
    {"11124023430",p_Context.Translate("Attiva per import")},
    {"11244508806",p_Context.Translate("PIattaforme VLT (CGO)")},
    {"112851763",p_Context.Translate("Codice")},
    {"11319134336",p_Context.Translate("Attiva per inserimento Manuale")},
    {"11633640653",p_Context.Translate("Cartella File Import")},
    {"12056152049",p_Context.Translate("Check SSL")},
    {"1275677499",p_Context.Translate("Chiave Crittografazione")},
    {"1477784713",p_Context.Translate("ID AAMS")},
    {"1736088099",p_Context.Translate("Prefisso o Suffisso")},
    {"1745819304",p_Context.Translate("Piattaforma Attiva")},
    {"1795947504",p_Context.Translate("Prefisso file")},
    {"1908399461",p_Context.Translate("Separatore campi")},
    {"1991168906",p_Context.Translate("Formato Data")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"734312933",p_Context.Translate("Sigla Piattaforma")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_vltplatBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_vltplat.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_vltplatBO BO,ServletStatus status) {
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
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println(
       "<div id='tabsContainer'>" +
       " " +
       "</div>" +
      "");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__url",status.m_cAltInterface);
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "<script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
      status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("MSG_PAGE_NUMBER","1"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
      status.out.println("Z.Tabs.Set('tabs',tabs);");
      status.out.println("} else {");
      status.out.println("var tabs = Z.Tabs.Get('tabs')");
      status.out.println("}");
      AddExtendedTabs(status);
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_vltplat',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_vltplat",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_cgo_vltplatBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:841px;width:637px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteControls_p1_b5(BO,status);
    WriteControls_p1_b6(BO,status);
    WriteControls_p1_b7(BO,status);
    WriteControls_p1_b8(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"PAGE_1");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
    if ( ! (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,""))) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('page_1').style.display='block';");
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteControls_p1_b0(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:371px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPCODICE' id='ZGGIFYYPOE' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_VPCODICE,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='DXUSYAWUSF_DIV'>" +
       "<label id='DXUSYAWUSF' for='ZGGIFYYPOE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPDESCRI' id='OSLIHZCQKI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPDESCRI,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NWLFWHLCTQ_DIV'>" +
       "<label id='NWLFWHLCTQ' for='OSLIHZCQKI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CZVGGKXVIZ_DIV'>" +
       "<input name='VPFLGATT' id='CZVGGKXVIZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_VPFLGATT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFLGATT))?"CHECKED":"")+">" +
       "<label id='CZVGGKXVIZ_LBL' for='CZVGGKXVIZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Attiva per inserimento Manuale"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPIDAAMS' id='OFJLXZEHFJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPIDAAMS,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MPMDRVAJWY_DIV'>" +
       "<label id='MPMDRVAJWY' for='OFJLXZEHFJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID AAMS:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPCODPIAT' id='PVLHZPDZCG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPCODPIAT,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YPGVNHKNND_DIV'>" +
       "<label id='YPGVNHKNND' for='PVLHZPDZCG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Piasttaforma (da CSV):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPSIGLAPIAT' id='SBCJPJIQKL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPSIGLAPIAT,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZDFKZEFUWP_DIV'>" +
       "<label id='ZDFKZEFUWP' for='SBCJPJIQKL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sigla Piattaforma:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPPROVENIENZA' id='MWISDJAVFU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPPROVENIENZA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WNALTAKNFI_DIV'>" +
       "<label id='WNALTAKNFI' for='MWISDJAVFU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provenienza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPVLTCODPLAT' id='EPIRSSFGUY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPVLTCODPLAT,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NAOYNVOZFF_DIV'>" +
       "<label id='NAOYNVOZFF' for='EPIRSSFGUY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Piattaforma VLT:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='IOXCKXSDQO_DIV'>" +
       "<input name='VPFLGCRYPTO' id='IOXCKXSDQO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_VPFLGCRYPTO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFLGCRYPTO))?"CHECKED":"")+">" +
       "<label id='IOXCKXSDQO_LBL' for='IOXCKXSDQO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Check SSL"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='VFPKAYCRYPTO' id='OWDBUVHDZF' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2' style='display:none'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SSPIDBFNIE_DIV' style='display:none'>" +
       "<label id='SSPIDBFNIE' for='OWDBUVHDZF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Chiave SSL:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='TAWZTFESRW_DIV'>" +
       "<input name='VFPFLAGIMPORT' id='TAWZTFESRW' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_VFPFLAGIMPORT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_VFPFLAGIMPORT))?"CHECKED":"")+">" +
       "<label id='TAWZTFESRW_LBL' for='TAWZTFESRW' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Attiva per import"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.out.println(
     "<div name='File' id='UPMDALZWNE_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='UPMDALZWNE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='UPMDALZWNE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Cartella File di Import")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='UPMDALZWNE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"UPMDALZWNE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=UPMDALZWNE_HEADER&m_cBoxId=UPMDALZWNE&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Cartella File di Import"))+"");
    }
    status.out.println(
     "<div id='UPMDALZWNE' class='SectionBody' style='position:relative;height:49px;display:block'>" +
    "");
    status.includeZoneAltInterface("File@BEGIN");
    if (status.includeZoneAltInterface("File")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("File@BEGIN") || status.HasZoneAltInterface("File@END")) {
        status.out.println(
         "<div id='UPMDALZWNE_boxContent' style='position:relative;height:49px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPDIRFILE' id='CRNCQKHAZD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPDIRFILE,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TQARYJWENE_DIV'>" +
       "<label id='TQARYJWENE' for='CRNCQKHAZD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cartella File Import:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("File@BEGIN") || status.HasZoneAltInterface("File@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.includeZoneAltInterface("File@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("File")) {
      status.out.println("Ctrl('UPMDALZWNE').style.height='auto';");
    } else {
      status.out.println("Ctrl('UPMDALZWNE').setAttribute('band_height',49);");
    }
    status.out.println("Ctrl('UPMDALZWNE').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_XWPAALVUKU")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_XWPAALVUKU' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_XWPAALVUKU")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_XWPAALVUKU').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.out.println(
     "<div name='File1' id='XWPAALVUKU_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='XWPAALVUKU_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='XWPAALVUKU_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("File di Import 1")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='XWPAALVUKU_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"XWPAALVUKU\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=XWPAALVUKU_HEADER&m_cBoxId=XWPAALVUKU&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("File di Import 1"))+"");
    }
    status.out.println(
     "<div id='XWPAALVUKU' class='SectionBody' style='position:relative;height:105px;display:block'>" +
    "");
    status.includeZoneAltInterface("File1@BEGIN");
    if (status.includeZoneAltInterface("File1")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("File1@BEGIN") || status.HasZoneAltInterface("File1@END")) {
        status.out.println(
         "<div id='XWPAALVUKU_boxContent' style='position:relative;height:105px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='YRIBZBIKSQ_DIV'>" +
       "<input name='VPFILEINTESTA1' id='YRIBZBIKSQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_VPFILEINTESTA1,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFILEINTESTA1))?"CHECKED":"")+">" +
       "<label id='YRIBZBIKSQ_LBL' for='YRIBZBIKSQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Presenza riga intestazione"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFFILESPERATOR1' id='HSUYGDBUTJ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue(";","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(";",CPLib.Trim(BO.w_VPFFILESPERATOR1))?"SELECTED":"")+">" +
       ""+status.context.Translate(";")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(",","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(",",CPLib.Trim(BO.w_VPFFILESPERATOR1))?"SELECTED":"")+">" +
       ""+status.context.Translate(",")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(" ","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(" ",CPLib.Trim(BO.w_VPFFILESPERATOR1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Spazio")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('HSUYGDBUTJ'),w_VPFFILESPERATOR1,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DKHGDLJMIA_DIV'>" +
       "<label id='DKHGDLJMIA' for='HSUYGDBUTJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Separatore campi:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFILEFORDATA1' id='WWIDCEPGYS' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_VPFILEFORDATA1))?"SELECTED":"")+">" +
       ""+status.context.Translate("AAAAMMGG")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_VPFILEFORDATA1))?"SELECTED":"")+">" +
       ""+status.context.Translate("GGMMAAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_VPFILEFORDATA1))?"SELECTED":"")+">" +
       ""+status.context.Translate("MMGGAAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("4","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("4",CPLib.Trim(BO.w_VPFILEFORDATA1))?"SELECTED":"")+">" +
       ""+status.context.Translate("GG-MM-AAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("5","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("5",CPLib.Trim(BO.w_VPFILEFORDATA1))?"SELECTED":"")+">" +
       ""+status.context.Translate("MM-GG-AAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("6","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("6",CPLib.Trim(BO.w_VPFILEFORDATA1))?"SELECTED":"")+">" +
       ""+status.context.Translate("AAAA-MM-GG")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('WWIDCEPGYS'),w_VPFILEFORDATA1,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VTSRTHMMJK_DIV'>" +
       "<label id='VTSRTHMMJK' for='WWIDCEPGYS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Formato Data:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPPREFFILE1' id='WIFZHMQFSC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPPREFFILE1,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFLGPRESUF1' id='IWAAKTWPEO' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_VPFLGPRESUF1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Prefisso File")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFLGPRESUF1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Suffisso File")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('IWAAKTWPEO'),w_VPFLGPRESUF1,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VFPTIPOFILE1' id='UJQXAYYQOQ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VFPTIPOFILE1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Spielo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_VFPTIPOFILE1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Novomatic")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_VFPTIPOFILE1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Playtech")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_VFPTIPOFILE1))?"SELECTED":"")+">" +
       ""+status.context.Translate("Inspired")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('UJQXAYYQOQ'),w_VFPTIPOFILE1,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OQBNEWXCRA_DIV'>" +
       "<label id='OQBNEWXCRA' for='UJQXAYYQOQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo File 1 (Struttura):"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("File1@BEGIN") || status.HasZoneAltInterface("File1@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.includeZoneAltInterface("File1@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("File1")) {
      status.out.println("Ctrl('XWPAALVUKU').style.height='auto';");
    } else {
      status.out.println("Ctrl('XWPAALVUKU').setAttribute('band_height',105);");
    }
    status.out.println("Ctrl('XWPAALVUKU').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_BVXXKEJNHQ")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_BVXXKEJNHQ' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_BVXXKEJNHQ")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_BVXXKEJNHQ').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b5(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.out.println(
     "<div name='File2' id='BVXXKEJNHQ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='BVXXKEJNHQ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='BVXXKEJNHQ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("File di Import 2")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='BVXXKEJNHQ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"BVXXKEJNHQ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=BVXXKEJNHQ_HEADER&m_cBoxId=BVXXKEJNHQ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("File di Import 2"))+"");
    }
    status.out.println(
     "<div id='BVXXKEJNHQ' class='SectionBody' style='position:relative;height:105px;display:block'>" +
    "");
    status.includeZoneAltInterface("File2@BEGIN");
    if (status.includeZoneAltInterface("File2")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("File2@BEGIN") || status.HasZoneAltInterface("File2@END")) {
        status.out.println(
         "<div id='BVXXKEJNHQ_boxContent' style='position:relative;height:105px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='JSTNURAHAS_DIV'>" +
       "<input name='VPFILEINTESTA2' id='JSTNURAHAS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_VPFILEINTESTA2,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFILEINTESTA2))?"CHECKED":"")+">" +
       "<label id='JSTNURAHAS_LBL' for='JSTNURAHAS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Presenza riga intestazione"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFFILESPERATOR2' id='RMKWOZTKVK' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue(";","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(";",CPLib.Trim(BO.w_VPFFILESPERATOR2))?"SELECTED":"")+">" +
       ""+status.context.Translate(";")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(",","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(",",CPLib.Trim(BO.w_VPFFILESPERATOR2))?"SELECTED":"")+">" +
       ""+status.context.Translate(",")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(" ","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(" ",CPLib.Trim(BO.w_VPFFILESPERATOR2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Spazio")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('RMKWOZTKVK'),w_VPFFILESPERATOR2,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UIQPFTGBVY_DIV'>" +
       "<label id='UIQPFTGBVY' for='RMKWOZTKVK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Separatore campi:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFILEFORDATA2' id='WSOZNFILVU' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_VPFILEFORDATA2))?"SELECTED":"")+">" +
       ""+status.context.Translate("AAAAMMGG")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_VPFILEFORDATA2))?"SELECTED":"")+">" +
       ""+status.context.Translate("GGMMAAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_VPFILEFORDATA2))?"SELECTED":"")+">" +
       ""+status.context.Translate("MMGGAAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("4","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("4",CPLib.Trim(BO.w_VPFILEFORDATA2))?"SELECTED":"")+">" +
       ""+status.context.Translate("GG-MM-AAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("5","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("5",CPLib.Trim(BO.w_VPFILEFORDATA2))?"SELECTED":"")+">" +
       ""+status.context.Translate("MM-GG-AAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("6","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("6",CPLib.Trim(BO.w_VPFILEFORDATA2))?"SELECTED":"")+">" +
       ""+status.context.Translate("AAAA-MM-GG")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('WSOZNFILVU'),w_VPFILEFORDATA2,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ODSVLUCLCI_DIV'>" +
       "<label id='ODSVLUCLCI' for='WSOZNFILVU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Formato Data:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPPREFFILE2' id='KMMYWUIZJE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPPREFFILE2,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFLGPRESUF2' id='JNTTHSGKEW' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_VPFLGPRESUF2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Prefisso File")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFLGPRESUF2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Suffisso File")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('JNTTHSGKEW'),w_VPFLGPRESUF2,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VFPTIPOFILE2' id='XKZJHMFBOP' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VFPTIPOFILE2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Spielo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_VFPTIPOFILE2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Novomatic")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_VFPTIPOFILE2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Playtech")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_VFPTIPOFILE2))?"SELECTED":"")+">" +
       ""+status.context.Translate("Inspired")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('XKZJHMFBOP'),w_VFPTIPOFILE2,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DSURKWDFIJ_DIV'>" +
       "<label id='DSURKWDFIJ' for='XKZJHMFBOP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo File 2 (Struttura):"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("File2@BEGIN") || status.HasZoneAltInterface("File2@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.includeZoneAltInterface("File2@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("File2")) {
      status.out.println("Ctrl('BVXXKEJNHQ').style.height='auto';");
    } else {
      status.out.println("Ctrl('BVXXKEJNHQ').setAttribute('band_height',105);");
    }
    status.out.println("Ctrl('BVXXKEJNHQ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_PIFTFGCGKH")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_PIFTFGCGKH' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_PIFTFGCGKH")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_PIFTFGCGKH').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b7(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.out.println(
     "<div name='File3' id='PIFTFGCGKH_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='PIFTFGCGKH_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='PIFTFGCGKH_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("File di Import 3")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='PIFTFGCGKH_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"PIFTFGCGKH\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=PIFTFGCGKH_HEADER&m_cBoxId=PIFTFGCGKH&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("File di Import 3"))+"");
    }
    status.out.println(
     "<div id='PIFTFGCGKH' class='SectionBody' style='position:relative;height:105px;display:block'>" +
    "");
    status.includeZoneAltInterface("File3@BEGIN");
    if (status.includeZoneAltInterface("File3")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("File3@BEGIN") || status.HasZoneAltInterface("File3@END")) {
        status.out.println(
         "<div id='PIFTFGCGKH_boxContent' style='position:relative;height:105px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LGHPNQFTEZ_DIV'>" +
       "<input name='VPFILEINTESTA3' id='LGHPNQFTEZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_VPFILEINTESTA3,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFILEINTESTA3))?"CHECKED":"")+">" +
       "<label id='LGHPNQFTEZ_LBL' for='LGHPNQFTEZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Presenza riga intestazione"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFFILESPERATOR3' id='DRTQWCMRII' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue(";","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(";",CPLib.Trim(BO.w_VPFFILESPERATOR3))?"SELECTED":"")+">" +
       ""+status.context.Translate(";")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(",","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(",",CPLib.Trim(BO.w_VPFFILESPERATOR3))?"SELECTED":"")+">" +
       ""+status.context.Translate(",")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(" ","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(" ",CPLib.Trim(BO.w_VPFFILESPERATOR3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Spazio")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('DRTQWCMRII'),w_VPFFILESPERATOR3,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SYZSFZRUBB_DIV'>" +
       "<label id='SYZSFZRUBB' for='DRTQWCMRII'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Separatore campi:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFILEFORDATA3' id='WIOMSFLLSU' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_VPFILEFORDATA3))?"SELECTED":"")+">" +
       ""+status.context.Translate("AAAAMMGG")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_VPFILEFORDATA3))?"SELECTED":"")+">" +
       ""+status.context.Translate("GGMMAAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_VPFILEFORDATA3))?"SELECTED":"")+">" +
       ""+status.context.Translate("MMGGAAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("4","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("4",CPLib.Trim(BO.w_VPFILEFORDATA3))?"SELECTED":"")+">" +
       ""+status.context.Translate("GG-MM-AAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("5","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("5",CPLib.Trim(BO.w_VPFILEFORDATA3))?"SELECTED":"")+">" +
       ""+status.context.Translate("MM-GG-AAAA")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("6","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("6",CPLib.Trim(BO.w_VPFILEFORDATA3))?"SELECTED":"")+">" +
       ""+status.context.Translate("AAAA-MM-GG")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('WIOMSFLLSU'),w_VPFILEFORDATA3,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BCOMVSSXIR_DIV'>" +
       "<label id='BCOMVSSXIR' for='WIOMSFLLSU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Formato Data:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VPPREFFILE3' id='HYYEMIXZZH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_VPPREFFILE3,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VPFLGPRESUF3' id='TMKKDOYZLM' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_VPFLGPRESUF3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Prefisso File")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VPFLGPRESUF3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Suffisso File")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('TMKKDOYZLM'),w_VPFLGPRESUF3,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VFPTIPOFILE3' id='ADHTWRZDJL' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_VFPTIPOFILE3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Spielo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("N","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_VFPTIPOFILE3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Novomatic")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_VFPTIPOFILE3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Playtech")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_VFPTIPOFILE3))?"SELECTED":"")+">" +
       ""+status.context.Translate("Inspired")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('ADHTWRZDJL'),w_VFPTIPOFILE3,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RTYERWTCGQ_DIV'>" +
       "<label id='RTYERWTCGQ' for='ADHTWRZDJL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo File 3 (Struttura):"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("File3@BEGIN") || status.HasZoneAltInterface("File3@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.includeZoneAltInterface("File3@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("File3")) {
      status.out.println("Ctrl('PIFTFGCGKH').style.height='auto';");
    } else {
      status.out.println("Ctrl('PIFTFGCGKH').setAttribute('band_height',105);");
    }
    status.out.println("Ctrl('PIFTFGCGKH').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_1' style='position:relative;height:5px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(armt_cgo_vltplatBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_vltplatBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_cgo_vltplatBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPDESCRI,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFLGATT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPIDAAMS,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPCODPIAT,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPSIGLAPIAT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPPROVENIENZA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPVLTCODPLAT,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFLGCRYPTO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VFPKAYCRYPTO,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPDIRFILE,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFILEINTESTA1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFFILESPERATOR1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFILEFORDATA1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPPREFFILE1,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFILEINTESTA2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFFILESPERATOR2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFILEFORDATA2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPPREFFILE2,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFILEINTESTA3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFFILESPERATOR3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFILEFORDATA3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPPREFFILE3,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFLGPRESUF1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFLGPRESUF2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VPFLGPRESUF3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VFPFLAGIMPORT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VFPTIPOFILE1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VFPTIPOFILE2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VFPTIPOFILE3,"C",1,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_vltplatBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(841,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(637,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_vltplat"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      AppendCallableIDS(status,"");
    } else {
      AppendCallableIDS(status,"");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_vltplat","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_vltplat",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("File"),"")) {
      status.quoteAndAppend("File","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("File1"),"")) {
      status.quoteAndAppend("File1","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("File2"),"")) {
      status.quoteAndAppend("File2","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("File3"),"")) {
      status.quoteAndAppend("File3","hide","box");
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
    } else {
      status.out.println("var m_nLastRec = " + SPLib.ToJSValue(status.m_nLastRec,"N",0,0)+ ";");
      status.out.println("var m_nRecPos = " + SPLib.ToJSValue(status.m_nRecPos,"N",0,0)+ ";");
      status.out.println("var m_cVirtName = " + SPLib.ToJSValue(status.m_cVirtName,"C",0,0)+ ";");
    }
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(armt_cgo_vltplatBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_vltplat',false);");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('ZGGIFYYPOE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OSLIHZCQKI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZVGGKXVIZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OFJLXZEHFJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PVLHZPDZCG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SBCJPJIQKL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MWISDJAVFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EPIRSSFGUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IOXCKXSDQO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OWDBUVHDZF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CRNCQKHAZD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YRIBZBIKSQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HSUYGDBUTJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WWIDCEPGYS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WIFZHMQFSC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JSTNURAHAS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RMKWOZTKVK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WSOZNFILVU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KMMYWUIZJE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LGHPNQFTEZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DRTQWCMRII')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WIOMSFLLSU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HYYEMIXZZH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IWAAKTWPEO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JNTTHSGKEW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TMKKDOYZLM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TAWZTFESRW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UJQXAYYQOQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XKZJHMFBOP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ADHTWRZDJL')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
      status.out.println("ExpandCollapseBoxesUnderCondition();");
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
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('ZGGIFYYPOE')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    if (status.HasFoundlingChildren()) {
      status.out.println("LoadContext();");
    }
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
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_cgo_vltplatBO getBO(ServletStatus status) {
    armt_cgo_vltplatBO BO = new armt_cgo_vltplatBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_cgo_vltplatBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_vltplat",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_vltplatBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_vltplatBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_cgo_vltplatBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_vltplat;
    String l_cPhName = BO.m_cPhName_cgo_vltplat;
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
      String l_cQueryFilter = armt_cgo_vltplatBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_vltplat+".VPCODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_vltplat");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_vltplat",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".VPCODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_cgo_vltplatBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_vltplatBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_vltplat,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_vltplat,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_vltplatBO BO) {
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
  void Edit(ServletStatus status,armt_cgo_vltplatBO BO,SPParameterSource source) {
    BO.Load(status.w_VPCODICE);
    if (BO.m_bLoaded && BO.CanEdit()) {
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
  void New(ServletStatus status,armt_cgo_vltplatBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_vltplatBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_vltplatBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_VPCODICE = "";
      } else {
        BO.w_VPCODICE = l_rsKeys.GetString("VPCODICE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_VPCODICE = BO.w_VPCODICE;
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
  void EditLoad(ServletStatus status,armt_cgo_vltplatBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_vltplatBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_VPCODICE);
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
  void DeleteMessage(ServletStatus status,armt_cgo_vltplatBO BO,SPParameterSource source) {
    BO.Load(status.w_VPCODICE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_vltplatBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({VPCODICE:"+SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_cgo_vltplatBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_vltplatBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",761);
    item.put("w",637);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Page 1\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Page 1");
    item.put("altInterfaceFor","armt_cgo_vltplat");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"Codice\",\"h\":20,\"maxlength\":2,\"name\":\"VPCODICE\",\"page\":1,\"spuid\":\"ZGGIFYYPOE\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":152,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DXUSYAWUSF\",\"page\":1,\"spuid\":\"DXUSYAWUSF\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Codice:\",\"w\":103,\"x\":48,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Piattaforma Attiva\",\"h\":21,\"label_text\":\"Attiva per inserimento Manuale\",\"maxlength\":1,\"name\":\"VPFLGATT\",\"page\":1,\"spuid\":\"CZVGGKXVIZ\",\"tabindex\":5,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":288,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Piattaforma per import\",\"h\":21,\"label_text\":\"Attiva per import\",\"maxlength\":1,\"name\":\"VFPFLAGIMPORT\",\"page\":1,\"spuid\":\"TAWZTFESRW\",\"tabindex\":46,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":120,\"x\":488,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"h\":20,\"maxlength\":50,\"name\":\"VPDESCRI\",\"page\":1,\"spuid\":\"OSLIHZCQKI\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":376,\"x\":152,\"y\":35,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NWLFWHLCTQ\",\"page\":1,\"spuid\":\"NWLFWHLCTQ\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Descrizione:\",\"w\":103,\"x\":48,\"y\":39,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID AAMS\",\"h\":20,\"maxlength\":16,\"name\":\"VPIDAAMS\",\"page\":1,\"spuid\":\"OFJLXZEHFJ\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":152,\"y\":63,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MPMDRVAJWY\",\"page\":1,\"spuid\":\"MPMDRVAJWY\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"ID AAMS:\",\"w\":104,\"x\":48,\"y\":67,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Piasttaforma (da CSV)\",\"h\":20,\"maxlength\":5,\"name\":\"VPCODPIAT\",\"page\":1,\"spuid\":\"PVLHZPDZCG\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":488,\"y\":63,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YPGVNHKNND\",\"page\":1,\"spuid\":\"YPGVNHKNND\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Codice Piasttaforma (da CSV):\",\"w\":159,\"x\":329,\"y\":67,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sigla Piattaforma\",\"h\":20,\"maxlength\":3,\"name\":\"VPSIGLAPIAT\",\"page\":1,\"spuid\":\"SBCJPJIQKL\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":152,\"y\":91,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZDFKZEFUWP\",\"page\":1,\"spuid\":\"ZDFKZEFUWP\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Sigla Piattaforma:\",\"w\":104,\"x\":48,\"y\":95,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provenienza\",\"h\":20,\"maxlength\":1,\"name\":\"VPPROVENIENZA\",\"page\":1,\"spuid\":\"MWISDJAVFU\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":488,\"y\":91,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WNALTAKNFI\",\"page\":1,\"spuid\":\"WNALTAKNFI\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Provenienza:\",\"w\":69,\"x\":419,\"y\":95,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Piattaforma VLT\",\"h\":20,\"maxlength\":5,\"name\":\"VPVLTCODPLAT\",\"page\":1,\"spuid\":\"EPIRSSFGUY\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":36,\"x\":152,\"y\":119,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NAOYNVOZFF\",\"page\":1,\"spuid\":\"NAOYNVOZFF\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Codice Piattaforma VLT:\",\"w\":126,\"x\":26,\"y\":123,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Check SSL\",\"h\":21,\"label_text\":\"Check SSL\",\"maxlength\":1,\"name\":\"VPFLGCRYPTO\",\"page\":1,\"spuid\":\"IOXCKXSDQO\",\"tabindex\":16,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":144,\"x\":488,\"y\":119,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Chiave Crittografazione\",\"h\":217,\"name\":\"VFPKAYCRYPTO\",\"page\":1,\"scroll\":true,\"spuid\":\"OWDBUVHDZF\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":464,\"x\":152,\"y\":147,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SSPIDBFNIE\",\"page\":1,\"spuid\":\"SSPIDBFNIE\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Chiave SSL:\",\"w\":129,\"x\":23,\"y\":151,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"File\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Cartella File di Import\",\"h\":49,\"name\":\"File\",\"page\":1,\"shrinkable\":true,\"spuid\":\"UPMDALZWNE\",\"stretch\":true,\"tabindex\":19,\"title_caption\":\"Cartella File di Import\",\"titled\":true,\"type\":\"Box\",\"w\":608,\"x\":16,\"y\":371,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cartella File Import\",\"h\":20,\"maxlength\":30,\"name\":\"VPDIRFILE\",\"page\":1,\"spuid\":\"CRNCQKHAZD\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":248,\"x\":160,\"y\":385,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TQARYJWENE\",\"page\":1,\"spuid\":\"TQARYJWENE\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Cartella File Import:\",\"w\":104,\"x\":56,\"y\":389,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"File1\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"File di Import 1\",\"h\":105,\"name\":\"File1\",\"page\":1,\"shrinkable\":true,\"spuid\":\"XWPAALVUKU\",\"stretch\":true,\"tabindex\":27,\"title_caption\":\"File di Import 1\",\"titled\":true,\"type\":\"Box\",\"w\":608,\"x\":16,\"y\":427,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Presenza riga intestazioni\",\"h\":21,\"label_text\":\"Presenza riga intestazione\",\"maxlength\":1,\"name\":\"VPFILEINTESTA1\",\"page\":1,\"spuid\":\"YRIBZBIKSQ\",\"tabindex\":22,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":160,\"y\":441,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Separatore campi\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFFILESPERATOR1\",\"page\":1,\"spuid\":\"HSUYGDBUTJ\",\"tabindex\":23,\"textlist\":\";,,,Spazio\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+";"+"'"+","+"'"+","+"'"+","+"'"+" "+"'"+"\",\"w\":152,\"x\":456,\"y\":441,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DKHGDLJMIA\",\"page\":1,\"spuid\":\"DKHGDLJMIA\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Separatore campi:\",\"w\":96,\"x\":360,\"y\":445,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Formato Data\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFILEFORDATA1\",\"page\":1,\"spuid\":\"WWIDCEPGYS\",\"tabindex\":25,\"textlist\":\"AAAAMMGG,GGMMAAAA,MMGGAAAA,GG-MM-AAAA,MM-GG-AAAA,AAAA-MM-GG\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"4"+"'"+","+"'"+"5"+"'"+","+"'"+"6"+"'"+"\",\"w\":152,\"x\":456,\"y\":469,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VTSRTHMMJK\",\"page\":1,\"spuid\":\"VTSRTHMMJK\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Formato Data:\",\"w\":77,\"x\":379,\"y\":473,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prefisso file\",\"h\":20,\"maxlength\":30,\"name\":\"VPPREFFILE1\",\"page\":1,\"spuid\":\"WIFZHMQFSC\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":160,\"y\":469,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prefisso o Suffisso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFLGPRESUF1\",\"page\":1,\"spuid\":\"IWAAKTWPEO\",\"tabindex\":43,\"textlist\":\"Prefisso File,Suffisso File\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"P"+"'"+","+"'"+"S"+"'"+"\",\"w\":128,\"x\":24,\"y\":469,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo File 1 (Struttura)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VFPTIPOFILE1\",\"page\":1,\"spuid\":\"UJQXAYYQOQ\",\"tabindex\":47,\"textlist\":\"Spielo,Novomatic,Playtech,Inspired\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"S"+"'"+","+"'"+"N"+"'"+","+"'"+"P"+"'"+","+"'"+"I"+"'"+"\",\"w\":152,\"x\":456,\"y\":497,\"zone\":\"pag1_10_3\",\"zonepath\":\"[1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OQBNEWXCRA\",\"page\":1,\"spuid\":\"OQBNEWXCRA\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Tipo File 1 (Struttura):\",\"w\":117,\"x\":339,\"y\":501,\"zone\":\"pag1_10_3\",\"zonepath\":\"[1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"File2\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"File di Import 2\",\"h\":105,\"name\":\"File2\",\"page\":1,\"shrinkable\":true,\"spuid\":\"BVXXKEJNHQ\",\"stretch\":true,\"tabindex\":34,\"title_caption\":\"File di Import 2\",\"titled\":true,\"type\":\"Box\",\"w\":608,\"x\":16,\"y\":539,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Presenza riga intestazioni\",\"h\":21,\"label_text\":\"Presenza riga intestazione\",\"maxlength\":1,\"name\":\"VPFILEINTESTA2\",\"page\":1,\"spuid\":\"JSTNURAHAS\",\"tabindex\":29,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":160,\"y\":553,\"zone\":\"pag1_11_1\",\"zonepath\":\"[1,11,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Separatore campi\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFFILESPERATOR2\",\"page\":1,\"spuid\":\"RMKWOZTKVK\",\"tabindex\":30,\"textlist\":\";,,,Spazio\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+";"+"'"+","+"'"+","+"'"+","+"'"+" "+"'"+"\",\"w\":152,\"x\":456,\"y\":553,\"zone\":\"pag1_11_1\",\"zonepath\":\"[1,11,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UIQPFTGBVY\",\"page\":1,\"spuid\":\"UIQPFTGBVY\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Separatore campi:\",\"w\":96,\"x\":360,\"y\":557,\"zone\":\"pag1_11_1\",\"zonepath\":\"[1,11,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Formato Data\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFILEFORDATA2\",\"page\":1,\"spuid\":\"WSOZNFILVU\",\"tabindex\":32,\"textlist\":\"AAAAMMGG,GGMMAAAA,MMGGAAAA,GG-MM-AAAA,MM-GG-AAAA,AAAA-MM-GG\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"4"+"'"+","+"'"+"5"+"'"+","+"'"+"6"+"'"+"\",\"w\":152,\"x\":456,\"y\":581,\"zone\":\"pag1_11_2\",\"zonepath\":\"[1,11,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ODSVLUCLCI\",\"page\":1,\"spuid\":\"ODSVLUCLCI\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Formato Data:\",\"w\":77,\"x\":379,\"y\":585,\"zone\":\"pag1_11_2\",\"zonepath\":\"[1,11,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prefisso file\",\"h\":20,\"maxlength\":30,\"name\":\"VPPREFFILE2\",\"page\":1,\"spuid\":\"KMMYWUIZJE\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":160,\"y\":581,\"zone\":\"pag1_11_2\",\"zonepath\":\"[1,11,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prefisso o Suffisso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFLGPRESUF2\",\"page\":1,\"spuid\":\"JNTTHSGKEW\",\"tabindex\":44,\"textlist\":\"Prefisso File,Suffisso File\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"P"+"'"+","+"'"+"S"+"'"+"\",\"w\":128,\"x\":24,\"y\":581,\"zone\":\"pag1_11_2\",\"zonepath\":\"[1,11,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo File 2 (Struttura)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VFPTIPOFILE2\",\"page\":1,\"spuid\":\"XKZJHMFBOP\",\"tabindex\":49,\"textlist\":\"Spielo,Novomatic,Playtech,Inspired\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"S"+"'"+","+"'"+"N"+"'"+","+"'"+"P"+"'"+","+"'"+"I"+"'"+"\",\"w\":152,\"x\":456,\"y\":609,\"zone\":\"pag1_11_3\",\"zonepath\":\"[1,11,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DSURKWDFIJ\",\"page\":1,\"spuid\":\"DSURKWDFIJ\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Tipo File 2 (Struttura):\",\"w\":117,\"x\":339,\"y\":613,\"zone\":\"pag1_11_3\",\"zonepath\":\"[1,11,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"File3\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"File di Import 3\",\"h\":105,\"name\":\"File3\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PIFTFGCGKH\",\"stretch\":true,\"tabindex\":41,\"title_caption\":\"File di Import 3\",\"titled\":true,\"type\":\"Box\",\"w\":608,\"x\":16,\"y\":651,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Presenza riga intestazioni\",\"h\":21,\"label_text\":\"Presenza riga intestazione\",\"maxlength\":1,\"name\":\"VPFILEINTESTA3\",\"page\":1,\"spuid\":\"LGHPNQFTEZ\",\"tabindex\":36,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":160,\"y\":665,\"zone\":\"pag1_12_1\",\"zonepath\":\"[1,12,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Separatore campi\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFFILESPERATOR3\",\"page\":1,\"spuid\":\"DRTQWCMRII\",\"tabindex\":37,\"textlist\":\";,,,Spazio\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+";"+"'"+","+"'"+","+"'"+","+"'"+" "+"'"+"\",\"w\":152,\"x\":456,\"y\":665,\"zone\":\"pag1_12_1\",\"zonepath\":\"[1,12,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SYZSFZRUBB\",\"page\":1,\"spuid\":\"SYZSFZRUBB\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Separatore campi:\",\"w\":96,\"x\":360,\"y\":669,\"zone\":\"pag1_12_1\",\"zonepath\":\"[1,12,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Formato Data\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFILEFORDATA3\",\"page\":1,\"spuid\":\"WIOMSFLLSU\",\"tabindex\":39,\"textlist\":\"AAAAMMGG,GGMMAAAA,MMGGAAAA,GG-MM-AAAA,MM-GG-AAAA,AAAA-MM-GG\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"4"+"'"+","+"'"+"5"+"'"+","+"'"+"6"+"'"+"\",\"w\":152,\"x\":456,\"y\":693,\"zone\":\"pag1_12_2\",\"zonepath\":\"[1,12,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BCOMVSSXIR\",\"page\":1,\"spuid\":\"BCOMVSSXIR\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Formato Data:\",\"w\":77,\"x\":379,\"y\":697,\"zone\":\"pag1_12_2\",\"zonepath\":\"[1,12,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prefisso file\",\"h\":20,\"maxlength\":30,\"name\":\"VPPREFFILE3\",\"page\":1,\"spuid\":\"HYYEMIXZZH\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":160,\"y\":693,\"zone\":\"pag1_12_2\",\"zonepath\":\"[1,12,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prefisso o Suffisso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VPFLGPRESUF3\",\"page\":1,\"spuid\":\"TMKKDOYZLM\",\"tabindex\":45,\"textlist\":\"Prefisso File,Suffisso File\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"P"+"'"+","+"'"+"S"+"'"+"\",\"w\":128,\"x\":24,\"y\":693,\"zone\":\"pag1_12_2\",\"zonepath\":\"[1,12,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo File 3 (Struttura)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"VFPTIPOFILE3\",\"page\":1,\"spuid\":\"ADHTWRZDJL\",\"tabindex\":51,\"textlist\":\"Spielo,Novomatic,Playtech,Inspired\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"S"+"'"+","+"'"+"N"+"'"+","+"'"+"P"+"'"+","+"'"+"I"+"'"+"\",\"w\":152,\"x\":456,\"y\":721,\"zone\":\"pag1_12_3\",\"zonepath\":\"[1,12,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RTYERWTCGQ\",\"page\":1,\"spuid\":\"RTYERWTCGQ\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Tipo File 3 (Struttura):\",\"w\":117,\"x\":339,\"y\":725,\"zone\":\"pag1_12_3\",\"zonepath\":\"[1,12,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_vltplatBO BO,ServletStatus status) {
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
     "<script src='armt_cgo_vltplat?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    if (CPLib.gt(BO.extendedFields.length,0)) {
      l_cJsUid = SPPrxycizer.proxycizedPath("ExtendedFields.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_vltplat_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_vltplat_edit.js'>" +
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
      status.out.println("w_VPCODICE=a[0];");
      status.out.println("w_VPDESCRI=a[1];");
      status.out.println("w_VPFLGATT=a[2];");
      status.out.println("w_VPIDAAMS=a[3];");
      status.out.println("w_VPCODPIAT=a[4];");
      status.out.println("w_VPSIGLAPIAT=a[5];");
      status.out.println("w_VPPROVENIENZA=a[6];");
      status.out.println("w_VPVLTCODPLAT=a[7];");
      status.out.println("w_VPFLGCRYPTO=a[8];");
      status.out.println("w_VFPKAYCRYPTO=a[9];");
      status.out.println("w_VPDIRFILE=a[10];");
      status.out.println("w_VPFILEINTESTA1=a[11];");
      status.out.println("w_VPFFILESPERATOR1=a[12];");
      status.out.println("w_VPFILEFORDATA1=a[13];");
      status.out.println("w_VPPREFFILE1=a[14];");
      status.out.println("w_VPFILEINTESTA2=a[15];");
      status.out.println("w_VPFFILESPERATOR2=a[16];");
      status.out.println("w_VPFILEFORDATA2=a[17];");
      status.out.println("w_VPPREFFILE2=a[18];");
      status.out.println("w_VPFILEINTESTA3=a[19];");
      status.out.println("w_VPFFILESPERATOR3=a[20];");
      status.out.println("w_VPFILEFORDATA3=a[21];");
      status.out.println("w_VPPREFFILE3=a[22];");
      status.out.println("w_VPFLGPRESUF1=a[23];");
      status.out.println("w_VPFLGPRESUF2=a[24];");
      status.out.println("w_VPFLGPRESUF3=a[25];");
      status.out.println("w_VFPFLAGIMPORT=a[26];");
      status.out.println("w_VFPTIPOFILE1=a[27];");
      status.out.println("w_VFPTIPOFILE2=a[28];");
      status.out.println("w_VFPTIPOFILE3=a[29];");
      status.out.println("m_PrimaryKeys=['VPCODICE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_vltplat_proc.js'>" +
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
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/tabStrip.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
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
    status.themeWriter.WriteBody_Begin(841,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
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
    f.SetParameter("Table","cgo_vltplat");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","VPCODICE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_cgo_vltplatBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({VPCODICE:"+SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({VPCODICE:"+SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({VPCODICE:"+SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_cgo_vltplatBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({VPCODICE:"+SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_cgo_vltplatBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({VPCODICE:"+SPLib.ToJSValue(BO.w_VPCODICE,"C",2,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_vltplatBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_vltplatBO BO,ServletStatus status) throws IOException {
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
  public String GetCheckVars(ServletStatus status,armt_cgo_vltplatBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_VPCODICE),"C",2,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_vltplatBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
    }
    return result;
  }
}
