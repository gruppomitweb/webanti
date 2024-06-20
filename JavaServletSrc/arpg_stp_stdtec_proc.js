function SetControlsValue() {
var c;
var c;
if(c=Ctrl('UQFVYWSNYY')) c.value = WtH(w_daCodDip,'C',6,0,'')
if(c=Ctrl('HXBJUMEZIA')) c.value = WtH(w_aCodDip,'C',6,0,'')
if(c=Ctrl('DPKVLWHCIG')) c.value = WtH(w_DaDatOpe,'D',8,0,TranslatePicture('DD-MM-YYYY'))
if(c=Ctrl('MTJDZQTEIR')) c.value = WtH(w_ADatOpe,'D',8,0,TranslatePicture('DD-MM-YYYY'))
if(c=Ctrl('UYVYTEMEXX')) c.value = WtH(w_daCodCli,'C',16,0,'')
if(c=Ctrl('CJWUHWULAR')) c.value = WtH(w_aCodCli,'C',16,0,'')
var tmp_VXJAZUGUIO = ToHTag(AsControlValue(w_RAGSOC1));
if (Ne(e_VXJAZUGUIO,tmp_VXJAZUGUIO)) {
if(c=Ctrl('VXJAZUGUIO')) c.innerHTML=tmp_VXJAZUGUIO;
e_VXJAZUGUIO=tmp_VXJAZUGUIO;
}
var tmp_XCBBNKIAUV = ToHTag(AsControlValue(w_RAGSOC2));
if (Ne(e_XCBBNKIAUV,tmp_XCBBNKIAUV)) {
if(c=Ctrl('XCBBNKIAUV')) c.innerHTML=tmp_XCBBNKIAUV;
e_XCBBNKIAUV=tmp_XCBBNKIAUV;
}
var tmp_RXKVDVJPTZ = ToHTag(AsControlValue(w_DESCRIZ1));
if (Ne(e_RXKVDVJPTZ,tmp_RXKVDVJPTZ)) {
if(c=Ctrl('RXKVDVJPTZ')) c.innerHTML=tmp_RXKVDVJPTZ;
e_RXKVDVJPTZ=tmp_RXKVDVJPTZ;
}
var tmp_LNFAXDLCMF = ToHTag(AsControlValue(w_DESCRIZ2));
if (Ne(e_LNFAXDLCMF,tmp_LNFAXDLCMF)) {
if(c=Ctrl('LNFAXDLCMF')) c.innerHTML=tmp_LNFAXDLCMF;
e_LNFAXDLCMF=tmp_LNFAXDLCMF;
}
SetCollapsibleCaptions();
}
function SetCollapsibleCaptions() {
}
function HideControlsUnderCondition() {
var h;
HideUI();
}
HideUI.lblids["daCodDip"]=['ZWZOQIGZCX'];
HideUI.lblids["aCodDip"]=['BGOVXFIBXQ'];
HideUI.lblids["DaDatOpe"]=['HPGJXQIVYG'];
HideUI.lblids["ADatOpe"]=['BGHAITOPMU'];
HideUI.lblids["aCodCli"]=['JGQCNSZOCQ'];
function UQFVYWSNYY_Valid(e) {
SetActiveField(Ctrl('UQFVYWSNYY'),false);
e=(Gt(arguments.length,0)?e:window.event);
return Set_daCodDip(HtW(Ctrl('UQFVYWSNYY').value,'C'),null,e)
}
function UQFVYWSNYY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UQFVYWSNYY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UQFVYWSNYY'),true);
SetLastFocusedOnParent();
Ctrl('UQFVYWSNYY').select();
}
function UQFVYWSNYY_ZOOM_Click() {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
if(typeof(link_url)!='undefined') layerOpenForeground(link_url(link_index(Ctrl('UQFVYWSNYY'))),openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
}
function HXBJUMEZIA_Valid(e) {
SetActiveField(Ctrl('HXBJUMEZIA'),false);
e=(Gt(arguments.length,0)?e:window.event);
return Set_aCodDip(HtW(Ctrl('HXBJUMEZIA').value,'C'),null,e)
}
function HXBJUMEZIA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HXBJUMEZIA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HXBJUMEZIA'),true);
SetLastFocusedOnParent();
Ctrl('HXBJUMEZIA').select();
}
function HXBJUMEZIA_ZOOM_Click() {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
if(typeof(link_url)!='undefined') layerOpenForeground(link_url(link_index(Ctrl('HXBJUMEZIA'))),openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
}
function DPKVLWHCIG_Valid(e) {
var dateisok = false;
if (Eq(enteredInDate,Ctrl('DPKVLWHCIG'))) {
Ctrl('DPKVLWHCIG').value=ApplyPictureToDate(Ctrl('DPKVLWHCIG').value,TranslatePicture('DD-MM-YYYY'),'DPKVLWHCIG');
enteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
}
}
SetActiveField(Ctrl('DPKVLWHCIG'),false);
e=(Gt(arguments.length,0)?e:window.event);
return Set_DaDatOpe(HtW(Ctrl('DPKVLWHCIG').value,'D'),null,e) && dateisok
}
function DPKVLWHCIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPKVLWHCIG'))) {
DisplayErrorMessage();
}
Ctrl('DPKVLWHCIG').value=WtH(w_DaDatOpe,'D',8,0,TranslatePicture('DDMMYYYY'));
enteredInDate=this;
SetActiveField(Ctrl('DPKVLWHCIG'),true);
SetLastFocusedOnParent();
Ctrl('DPKVLWHCIG').select();
}
function DPKVLWHCIG_ZOOM_Click() {
LaunchCalendar(Ctrl('DPKVLWHCIG'));
}
function MTJDZQTEIR_Valid(e) {
var dateisok = false;
if (Eq(enteredInDate,Ctrl('MTJDZQTEIR'))) {
Ctrl('MTJDZQTEIR').value=ApplyPictureToDate(Ctrl('MTJDZQTEIR').value,TranslatePicture('DD-MM-YYYY'),'MTJDZQTEIR');
enteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
}
}
SetActiveField(Ctrl('MTJDZQTEIR'),false);
e=(Gt(arguments.length,0)?e:window.event);
return Set_ADatOpe(HtW(Ctrl('MTJDZQTEIR').value,'D'),null,e) && dateisok
}
function MTJDZQTEIR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MTJDZQTEIR'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('MTJDZQTEIR'))) {
Ctrl('MTJDZQTEIR').value=WtH(w_ADatOpe,'D',8,0,TranslatePicture('DDMMYYYY'));
}
enteredInDate=this;
SetActiveField(Ctrl('MTJDZQTEIR'),true);
SetLastFocusedOnParent();
Ctrl('MTJDZQTEIR').select();
}
function MTJDZQTEIR_ZOOM_Click() {
LaunchCalendar(Ctrl('MTJDZQTEIR'));
}
function UYVYTEMEXX_Valid(e) {
SetActiveField(Ctrl('UYVYTEMEXX'),false);
e=(Gt(arguments.length,0)?e:window.event);
return Set_daCodCli(HtW(Ctrl('UYVYTEMEXX').value,'C'),null,e)
}
function UYVYTEMEXX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UYVYTEMEXX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UYVYTEMEXX'),true);
SetLastFocusedOnParent();
Ctrl('UYVYTEMEXX').select();
}
function UYVYTEMEXX_ZOOM_Click() {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
if(typeof(link_url)!='undefined') layerOpenForeground(link_url(link_index(Ctrl('UYVYTEMEXX'))),openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
}
function CJWUHWULAR_Valid(e) {
SetActiveField(Ctrl('CJWUHWULAR'),false);
e=(Gt(arguments.length,0)?e:window.event);
return Set_aCodCli(HtW(Ctrl('CJWUHWULAR').value,'C'),null,e)
}
function CJWUHWULAR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CJWUHWULAR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CJWUHWULAR'),true);
SetLastFocusedOnParent();
Ctrl('CJWUHWULAR').select();
}
function CJWUHWULAR_ZOOM_Click() {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
if(typeof(link_url)!='undefined') layerOpenForeground(link_url(link_index(Ctrl('CJWUHWULAR'))),openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
}
function href_XURLGQZZMU() {
_modifyandopen('arrt_stp_stdtec'+'?m_cAction=start&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,,width=700,,height=500,resizable=1,scrollbars=yes',null)
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
if(c=Ctrl('UQFVYWSNYY')) c.onblur=UQFVYWSNYY_Valid;
if(c=Ctrl('UQFVYWSNYY')) c.onfocus=UQFVYWSNYY_OnFocus;
if(c=Ctrl('HXBJUMEZIA')) c.onblur=HXBJUMEZIA_Valid;
if(c=Ctrl('HXBJUMEZIA')) c.onfocus=HXBJUMEZIA_OnFocus;
if(c=Ctrl('DPKVLWHCIG')) c.onblur=DPKVLWHCIG_Valid;
if(c=Ctrl('DPKVLWHCIG')) c.onfocus=DPKVLWHCIG_OnFocus;
if(c=Ctrl('DPKVLWHCIG')) c.onkeypress=CheckDateChar;
if(c=Ctrl('MTJDZQTEIR')) c.onblur=MTJDZQTEIR_Valid;
if(c=Ctrl('MTJDZQTEIR')) c.onfocus=MTJDZQTEIR_OnFocus;
if(c=Ctrl('MTJDZQTEIR')) c.onkeypress=CheckDateChar;
if(c=Ctrl('UYVYTEMEXX')) c.onblur=UYVYTEMEXX_Valid;
if(c=Ctrl('UYVYTEMEXX')) c.onfocus=UYVYTEMEXX_OnFocus;
if(c=Ctrl('CJWUHWULAR')) c.onblur=CJWUHWULAR_Valid;
if(c=Ctrl('CJWUHWULAR')) c.onfocus=CJWUHWULAR_OnFocus;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetCollapsibleCaptions();
SetDynamicClasses();
EnableControlsUnderCondition();
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
function FocusFirstComponent() {
SetControlFocus('UQFVYWSNYY');
}
function FocusLayerFirstComponent(layer) {
}
function Help() {
windowOpenForeground('../doc/arpg_stp_stdtec_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
function DeclareWVs() {
var a = arguments;
w_daCodDip=a[0];
w_aCodDip=a[1];
w_DaDatOpe=a[2];
w_ADatOpe=a[3];
w_daCodCli=a[4];
w_aCodCli=a[5];
w_RAGSOC1=a[6];
w_RAGSOC2=a[7];
w_c_dadata=a[8];
w_c_adata=a[9];
w_DESCRIZ1=a[10];
w_DESCRIZ2=a[11];
}
function i_PrimaryKey() {
return ''
}
function CheckZone(me) {
return true
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_stp_stdtec',m_cSelectedPage);
return GetSelectedChildPage(p_d)
}
function DisplayErrorMessage() {
if (Le(m_nLastError,-1)) {
return
}
if (Eq(typeof(m_cErrorInChild),'undefined') || Empty(m_cErrorInChild)) {
var l_cErrorMsg = m_cLastMsgError;
if (Eq(l_cErrorMsg,'')) {
if (Eq(m_nLastError,1)) {
l_cErrorMsg='MSG_OBBLI_FIELD';
} else if (Eq(m_nLastError,2)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else if (Eq(m_nLastError,3)) {
l_cErrorMsg='MSG_VALUE_NOT_ALLOWED';
} else {
l_cErrorMsg='MSG_UNSPEC_ERROR';
}
}
if (Eq(m_nLastError,1)) {
alert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg))
} else {
alert(Translate(l_cErrorMsg))
}
if (Ne(m_cLastWorkVarError,'')) {
SetControlFocus(m_cLastWorkVarError);
SetErrorField(m_cLastWorkVarError,true);
m_cLastWorkVarError='';
}
} else {
try {
eval("DisplayErrorMessage_"+m_cErrorInChild+"()")
} catch(l_exeption) {
return
}
}
}
function ResetErrorVars() {
m_nLastError=0;
m_cLastMsgError='';
m_cLastWorkVarError='';
m_cErrorInChild='';
}
function EnableControlsUnderCondition() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (Ne(typeof(tabs),'undefined')) {
tabs.CheckTabStrip();
}
DisableUI();
HideControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function SetDynamicClasses() {
var c;
}
function SetSectionsHeight(id,m_nCurrentRow) {
}
function AdjustOnResize() {
var i = 0;
while (Lt(i,m_nRows)) {
i=i+1;
}
}
function InitVariables() {
}
function Set_daCodDip(ctrlValue,kmode,e) {
if (Ne(w_daCodDip,ctrlValue)) {
var ctl = _GetCtl(e,'UQFVYWSNYY');
if (_tracker.goon(ctl,ctrlValue)) {
w_daCodDip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UQFVYWSNYY');
if (l_bResult) {
l_bResult=Link_UQFVYWSNYY(kmode);
if ( ! (l_bResult)) {
w_daCodDip=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true
}
}
return true
}
_Obli('daCodDip',0,'UQFVYWSNYY',false)
function Set_aCodDip(ctrlValue,kmode,e) {
if (Ne(w_aCodDip,ctrlValue)) {
var ctl = _GetCtl(e,'HXBJUMEZIA');
if (_tracker.goon(ctl,ctrlValue)) {
w_aCodDip=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('HXBJUMEZIA');
if (l_bResult) {
l_bResult=Link_HXBJUMEZIA(kmode);
if ( ! (l_bResult)) {
w_aCodDip=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',6,0,''));
} else {
_ResetTracker();
}
return l_bResult
} else {
ctl.value=WtH('','C',6,0,'');
_ResetTracker();
return true
}
}
return true
}
_Obli('aCodDip',0,'HXBJUMEZIA',false)
function Set_DaDatOpe(ctrlValue,kmode,e) {
if (Ne(w_DaDatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'DPKVLWHCIG');
if (_tracker.goon(ctl,ctrlValue)) {
w_DaDatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('DPKVLWHCIG');
DoUpdate(l_bResult);
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture('DDMMYYYY'));
_ResetTracker();
return true
}
}
return true
}
_Obli('DaDatOpe',2,'DPKVLWHCIG',false)
function Set_ADatOpe(ctrlValue,kmode,e) {
if (Ne(w_ADatOpe,ctrlValue)) {
var ctl = _GetCtl(e,'MTJDZQTEIR');
if (_tracker.goon(ctl,ctrlValue)) {
w_ADatOpe=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('MTJDZQTEIR');
if (l_bResult) {
l_bResult=Ge(w_ADatOpe,w_DaDatOpe);
if ( ! (l_bResult)) {
m_nLastError=2;
m_cLastMsgError=AlertErrorMessage('10557974447');
}
if ( ! (l_bResult)) {
w_ADatOpe=HtW('','D');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'D',8,0,TranslatePicture('DDMMYYYY')));
} else {
_ResetTracker();
}
return l_bResult
} else {
ctl.value=WtH(NullDate(),'D',8,0,TranslatePicture('DDMMYYYY'));
_ResetTracker();
return true
}
}
return true
}
_Obli('ADatOpe',2,'MTJDZQTEIR',false)
function Set_daCodCli(ctrlValue,kmode,e) {
if (Ne(w_daCodCli,ctrlValue)) {
var ctl = _GetCtl(e,'UYVYTEMEXX');
if (_tracker.goon(ctl,ctrlValue)) {
w_daCodCli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('UYVYTEMEXX');
if (l_bResult) {
l_bResult=Link_UYVYTEMEXX(kmode);
if ( ! (l_bResult)) {
w_daCodCli=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true
}
}
return true
}
_Obli('daCodCli',0,'UYVYTEMEXX',false)
function Set_aCodCli(ctrlValue,kmode,e) {
if (Ne(w_aCodCli,ctrlValue)) {
var ctl = _GetCtl(e,'CJWUHWULAR');
if (_tracker.goon(ctl,ctrlValue)) {
w_aCodCli=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('CJWUHWULAR');
if (l_bResult) {
l_bResult=Link_CJWUHWULAR(kmode);
if ( ! (l_bResult)) {
w_aCodCli=HtW('','C');
}
}
DoUpdate(l_bResult);
if ( ! (l_bResult)) {
_RetFoc(e,ctrlValue,WtH(ctrlValue,'C',16,0,''));
} else {
_ResetTracker();
}
return l_bResult
} else {
ctl.value=WtH('','C',16,0,'');
_ResetTracker();
return true
}
}
return true
}
_Obli('aCodCli',0,'CJWUHWULAR',false)
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
w_c_dadata=(Empty(w_DaDatOpe)?'':DateToChar(w_DaDatOpe));
w_c_adata=(Empty(w_ADatOpe)?'':DateToChar(w_ADatOpe));
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function Link_UQFVYWSNYY(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(w_daCodDip);
l_Appl.SetStringKey('CODDIP',w_daCodDip,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('UQFVYWSNYY');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_daCodDip=l_Appl.GetStringValue('CODDIP',6,0);
w_DESCRIZ1=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_UQFVYWSNYY_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UQFVYWSNYY();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/'+PlatformPathStart('SPVisualZoom')+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult
}
function Link_UQFVYWSNYY_Blank() {
w_daCodDip='';
w_DESCRIZ1='';
}
function LOpt_UQFVYWSNYY() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('UQFVYWSNYY','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UQFVYWSNYY'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1813072817'),'C'));
return l_oWv
}
function Link_HXBJUMEZIA(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(w_aCodDip);
l_Appl.SetStringKey('CODDIP',w_aCodDip,6,0);
l_Appl.SetFields('CODDIP,DESCRIZ');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('anadip');
l_Appl.SetID('HXBJUMEZIA');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_aCodDip=l_Appl.GetStringValue('CODDIP',6,0);
w_DESCRIZ2=l_Appl.GetStringValue('DESCRIZ',30,0);
} else {
Link_HXBJUMEZIA_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_HXBJUMEZIA();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/'+PlatformPathStart('SPVisualZoom')+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult
}
function Link_HXBJUMEZIA_Blank() {
w_aCodDip='';
w_DESCRIZ2='';
}
function LOpt_HXBJUMEZIA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('anadip','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CODDIP','C'));
l_oWv.setValue('LinkedField',WtA('CODDIP','C'));
l_oWv.setValue('UID',WtA('HXBJUMEZIA','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['HXBJUMEZIA'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('1813072817'),'C'));
return l_oWv
}
function Link_UYVYTEMEXX(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(w_daCodCli);
l_Appl.SetStringKey('CONNES',w_daCodCli,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('UYVYTEMEXX');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_daCodCli=l_Appl.GetStringValue('CONNES',16,0);
w_RAGSOC1=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_UYVYTEMEXX_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_UYVYTEMEXX();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/'+PlatformPathStart('SPVisualZoom')+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult
}
function Link_UYVYTEMEXX_Blank() {
w_daCodCli='';
w_RAGSOC1='';
}
function LOpt_UYVYTEMEXX() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('UYVYTEMEXX','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['UYVYTEMEXX'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv
}
function Link_CJWUHWULAR(kmode) {
var l_bResult = true;
var l_nRec = 0;
var l_cLinkUrl;
var l_Appl = LinkApplet();
var l_bEmp = Empty(w_aCodCli);
l_Appl.SetStringKey('CONNES',w_aCodCli,16,0);
l_Appl.SetFields('CONNES,RAGSOC');
l_Appl.SetTypes('C,C');
l_Appl.LinkTable('personbo');
l_Appl.SetID('CJWUHWULAR');
l_nRec=l_Appl.DoLink((Eq(kmode,null)?2:kmode));
l_bResult=Ne(l_nRec,0);
if (Eq(l_nRec,1)) {
w_aCodCli=l_Appl.GetStringValue('CONNES',16,0);
w_RAGSOC2=l_Appl.GetStringValue('RAGSOC',70,0);
} else {
Link_CJWUHWULAR_Blank();
}
if (Eq(l_nRec,2)) {
var openername = 'linkview_'+LibJavascript.AlfaKeyGen(3);
var l_cFieldFilter = l_Appl.GetWhereFieldExprUnencoded();
var l_cFixedFilter = l_Appl.GetWhereFixedExprUnencoded();
var l_cAndOpForField = '';
if ( ! (Empty(l_cFieldFilter))) {
l_cAndOpForField=' and ';
}
var l_oWv = LOpt_CJWUHWULAR();
l_oWv.setValue('FieldFilter',l_cFieldFilter);
if ( ! (Empty(l_Appl.GetWhereAddedFixedFiltersUnencoded()))) {
if ( ! (Empty(l_cFixedFilter))) {
l_cFixedFilter=l_cFixedFilter+' and ';
}
l_cFixedFilter=l_cFixedFilter+l_Appl.GetWhereAddedFixedFiltersUnencoded();
}
l_oWv.setValue('FixedFilter',l_cFixedFilter);
var initEntityFields = '';
l_cLinkUrl='../servlet/'+PlatformPathStart('SPVisualZoom')+'?m_cWv='+URLenc(l_oWv.asString());
layerOpenForeground(l_cLinkUrl,openername,'toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes');
m_nLastError=-2;
} else {
if ( ! (l_bResult)) {
m_nLastError=3;
if (Lt(l_nRec,0)) {
m_cLastMsgError=Translate('MSG_CONNECT_SERVER');
}
}
}
return l_bResult
}
function Link_CJWUHWULAR_Blank() {
w_aCodCli='';
w_RAGSOC2='';
}
function LOpt_CJWUHWULAR() {
var l_oWv = InitWvApplet();
l_oWv.setValue('Table',WtA('personbo','C'));
l_oWv.setValue('Linkzoom',WtA(true,'L'));
l_oWv.setValue('PKFields',WtA('CONNES','C'));
l_oWv.setValue('LinkedField',WtA('CONNES','C'));
l_oWv.setValue('UID',WtA('CJWUHWULAR','C'));
l_oWv.setValue('SPZTL',WtA(m_IDS['CJWUHWULAR'][1],'C'));
l_oWv.setValue('Caption',WtA(Translate('10505367639'),'C'));
return l_oWv
}
function ReportLinkValue(varName,value) {
var bResult = false;
if (Eq(varName,'UQFVYWSNYY')) {
last_focused_comp=Ctrl('UQFVYWSNYY');
Set_daCodDip(HtW(value,'C'),0);
bResult=true;
}
if (Eq(varName,'HXBJUMEZIA')) {
last_focused_comp=Ctrl('HXBJUMEZIA');
Set_aCodDip(HtW(value,'C'),0);
bResult=true;
}
if (Eq(varName,'UYVYTEMEXX')) {
last_focused_comp=Ctrl('UYVYTEMEXX');
Set_daCodCli(HtW(value,'C'),0);
bResult=true;
}
if (Eq(varName,'CJWUHWULAR')) {
last_focused_comp=Ctrl('CJWUHWULAR');
Set_aCodCli(HtW(value,'C'),0);
bResult=true;
}
return bResult
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
alert(Translate('MSG_SERVER_DATA'));
return
}
var Frm = document.FSender;
if (Eq(formaction,'discard')) {
return
}
if ((Ne(formaction,'next') && Ne(formaction,'previous') && Ne(formaction,'save')) || CheckRow()) {
SubmitForm(formaction,url,data);
} else {
DoUpdate(false);
}
}
function Check() {
var l_bResult = true;
ResetErrorVars();
m_nLastError=0;
if ( ! (_ChkObl('UQFVYWSNYY',1))) {
_SignErr('UQFVYWSNYY');
l_bResult=false;
w_daCodDip=HtW('','C');
} else if ( ! (_ChkObl('HXBJUMEZIA',1))) {
_SignErr('HXBJUMEZIA');
l_bResult=false;
w_aCodDip=HtW('','C');
} else if ( ! (_ChkObl('DPKVLWHCIG',1))) {
_SignErr('DPKVLWHCIG');
l_bResult=false;
w_DaDatOpe=HtW('','D');
} else if (( ! (_ChkObl('MTJDZQTEIR',1))) || ( ! (Ge(w_ADatOpe,w_DaDatOpe)))) {
_SignErr('MTJDZQTEIR','10557974447');
l_bResult=false;
w_ADatOpe=HtW('','D');
} else if ( ! (_ChkObl('UYVYTEMEXX',1))) {
_SignErr('UYVYTEMEXX');
l_bResult=false;
w_daCodCli=HtW('','C');
} else if ( ! (_ChkObl('CJWUHWULAR',1))) {
_SignErr('CJWUHWULAR');
l_bResult=false;
w_aCodCli=HtW('','C');
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult
}
function link_index(lc) {
if (Eq(Ctrl('UQFVYWSNYY_ZOOM'),lc)) {
return 0
}
if (Eq(Ctrl('UQFVYWSNYY'),lc)) {
return 0
}
if (Eq(Ctrl('HXBJUMEZIA_ZOOM'),lc)) {
return 1
}
if (Eq(Ctrl('HXBJUMEZIA'),lc)) {
return 1
}
if (Eq(Ctrl('DPKVLWHCIG_ZOOM'),lc)) {
return 2
}
if (Eq(Ctrl('MTJDZQTEIR_ZOOM'),lc)) {
return 2
}
if (Eq(Ctrl('UYVYTEMEXX_ZOOM'),lc)) {
return 2
}
if (Eq(Ctrl('UYVYTEMEXX'),lc)) {
return 2
}
if (Eq(Ctrl('CJWUHWULAR_ZOOM'),lc)) {
return 3
}
if (Eq(Ctrl('CJWUHWULAR'),lc)) {
return 3
}
return -1
}
function link_url(index) {
var l_oWv;
if (Eq(index,0)) {
l_oWv=LOpt_UQFVYWSNYY();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/"+PlatformPathStart("SPVisualZoom")+'?m_cWv='+URLenc(l_oWv.asString())
}
if (Eq(index,1)) {
l_oWv=LOpt_HXBJUMEZIA();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/"+PlatformPathStart("SPVisualZoom")+'?m_cWv='+URLenc(l_oWv.asString())
}
if (Eq(index,2)) {
l_oWv=LOpt_UYVYTEMEXX();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/"+PlatformPathStart("SPVisualZoom")+'?m_cWv='+URLenc(l_oWv.asString())
}
if (Eq(index,3)) {
l_oWv=LOpt_CJWUHWULAR();
var l_cFixedFilter = '';
var l_cFieldFilter = '';
var l_cAndOp = '';
var l_cAndOpForField = '';
var initEntityFields = '';
return "../servlet/"+PlatformPathStart("SPVisualZoom")+'?m_cWv='+URLenc(l_oWv.asString())
}
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('daCodDip',WtA(w_daCodDip,'C'));
l_oWv.setValue('aCodDip',WtA(w_aCodDip,'C'));
l_oWv.setValue('DaDatOpe',WtA(w_DaDatOpe,'D'));
l_oWv.setValue('ADatOpe',WtA(w_ADatOpe,'D'));
l_oWv.setValue('daCodCli',WtA(w_daCodCli,'C'));
l_oWv.setValue('aCodCli',WtA(w_aCodCli,'C'));
l_oWv.setValue('RAGSOC1',WtA(w_RAGSOC1,'C'));
l_oWv.setValue('RAGSOC2',WtA(w_RAGSOC2,'C'));
l_oWv.setValue('c_dadata',WtA(w_c_dadata,'C'));
l_oWv.setValue('c_adata',WtA(w_c_adata,'C'));
l_oWv.setValue('DESCRIZ1',WtA(w_DESCRIZ1,'C'));
l_oWv.setValue('DESCRIZ2',WtA(w_DESCRIZ2,'C'));
_FillChildren(l_oWv);
}
_FillChildren.n=[];
FillWv.n=["daCodDip","aCodDip","DaDatOpe","ADatOpe","daCodCli","aCodCli","RAGSOC1","RAGSOC2","c_dadata","c_adata","DESCRIZ1","DESCRIZ2"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
if (IsWndAccessible(opener)) {
if (start) {
if (Empty(w_DaDatOpe) && Ne(opener.w_DaDatOpe,null)) {
TransferBetweenWindows(opener,'w_DaDatOpe',null,'Set_DaDatOpe');
}
if (Empty(w_ADatOpe) && Ne(opener.w_ADatOpe,null)) {
TransferBetweenWindows(opener,'w_ADatOpe',null,'Set_ADatOpe');
}
if (Empty(w_c_dadata) && Ne(opener.w_c_dadata,null)) {
TransferBetweenWindows(opener,'w_c_dadata','w_c_dadata');
}
if (Empty(w_c_adata) && Ne(opener.w_c_adata,null)) {
TransferBetweenWindows(opener,'w_c_adata','w_c_adata');
}
}
}
m_bCalculating=true;
Link_UQFVYWSNYY();
Link_HXBJUMEZIA();
Link_UYVYTEMEXX();
Link_CJWUHWULAR();
w_c_dadata=(Empty(w_DaDatOpe)?'':DateToChar(w_DaDatOpe));
w_c_adata=(Empty(w_ADatOpe)?'':DateToChar(w_ADatOpe));
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
DoUpdate(true);
if (IsWndAccessible(opener)) {
var xAccessErr; try{opener.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(opener.Ctrl),'undefined') && Ne(opener.Ctrl('FSender'),null) && Ne(typeof(opener.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=window.opener.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
function CheckRow() {
var l_bResult = true;
ResetErrorVars();
if (Lt(m_nCurrentRow,m_nRows)) {
}
return l_bResult
}
