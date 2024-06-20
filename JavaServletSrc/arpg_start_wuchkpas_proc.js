function SetControlsValue() {
var c;
var c;
if(c=Ctrl('WIRRRKLEWO')) selectRadio(c,w_tipodest,'C')
if(c=Ctrl('JAKNEJNBKZ')) ChkboxCheckUncheck(c,'S',w_opextc)
if(c=Ctrl('JAKNEJNBKZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RQAECCWOBF')) selectRadio(c,w_destfin,'C')
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('KDKDULGISN_'+m_nCurrentRow),null)) {
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) ChkboxCheckUncheck(c,'S',w_WUFLGSEL)
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) ChkboxValueAssign(c,'S','N','C',1,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('RPLXQTUPFS'),true);
}
HideUI();
}
HideUI.lblids["tipodest"]=['NJQSNRJAXM'];
function WIRRRKLEWO_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_tipodest(HtW(getRadioValue(Ctrl('WIRRRKLEWO')),'C'),null,e);
}
function JAKNEJNBKZ_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_opextc(ChkboxValueAssign(Ctrl('JAKNEJNBKZ'),'S','N','C',1,0,''),null,e);
}
function JAKNEJNBKZ_OnFocus(e) {
SetActiveField(Ctrl('JAKNEJNBKZ'),true);
}
function JAKNEJNBKZ_OnBlur(e) {
SetActiveField(Ctrl('JAKNEJNBKZ'),false);
}
function RQAECCWOBF_Valid(e) {
e=(Ne(e,null)?e:window.event);
return Set_destfin(HtW(getRadioValue(Ctrl('RQAECCWOBF')),'C'),null,e);
}
function href_FLFHSXPWZI() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_wuchkpas']));
SendData('start','arrt_wuchkpas'+'',HParApplet().asString());
}
function href_VRHQBWKFPP() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_start_wuchkpas']));
SendData('start','arrt_start_wuchkpas'+'',HParApplet().asString());
}
function href_HDSXZTLKVK() {
Update()
}
function href_ZWTNEMXOFQ() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('D'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_wuchkpas']));
SendData('start','arrt_seldes_wuchkpas'+'',HParApplet().asString());
}
function href_FCATLNLMSB() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('S'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_wuchkpas']));
SendData('start','arrt_seldes_wuchkpas'+'',HParApplet().asString());
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
function KDKDULGISN_Valid(e) {
var org = GetEventSrcElement(e);
if ( ! (org.focused)) {
var c = org.checked;
org.focus();
org.checked=c;
}
e=(Ne(e,null)?e:window.event);
return Set_WUFLGSEL(ChkboxValueAssign(Ctrl('KDKDULGISN_'+m_nCurrentRow),'S','N','C',1,0,''),null,e);
}
function KDKDULGISN_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function KDKDULGISN_OnBlur(e) {
SetActiveField(Ctrl('KDKDULGISN_'+m_nCurrentRow),false);
}
function KDKDULGISN_OnBlur(e) {
var org = GetEventSrcElement(e);
org.focused=false;
}
function KDKDULGISN_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
c=Ctrl('WIRRRKLEWO');
if ( ! (Empty(c))) {
c[0].onclick=WIRRRKLEWO_Valid;
c[1].onclick=WIRRRKLEWO_Valid;
}
if(c=Ctrl('JAKNEJNBKZ')) c.onclick=JAKNEJNBKZ_Valid;
if(c=Ctrl('JAKNEJNBKZ')) c.onfocus=JAKNEJNBKZ_OnFocus;
if(c=Ctrl('JAKNEJNBKZ')) c.onblur=JAKNEJNBKZ_OnBlur;
c=Ctrl('RQAECCWOBF');
if ( ! (Empty(c))) {
c[0].onclick=RQAECCWOBF_Valid;
c[1].onclick=RQAECCWOBF_Valid;
}
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) c.onclick=KDKDULGISN_Valid;
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) c.onfocus=KDKDULGISN_OnFocus;
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) c.onblur=KDKDULGISN_OnBlur;
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) c.onfocus=KDKDULGISN_OnFocus;
if(c=Ctrl('KDKDULGISN_'+m_nCurrentRow)) c.onblur=KDKDULGISN_OnBlur;
m_nCurrentRow=m_nCurrentRow+1;
}
m_nCurrentRow=l_nOldRow;
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
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
function DoFieldsUpdate(p_bResult) {
m_bFieldsUpdated=true;
DoUpdate(p_bResult);
}
FocusFirstComponent.otherwise={"page_1":["WIRRRKLEWO"]};
function Help() {
windowOpenForeground('../doc/arpg_start_wuchkpas_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_WUFLGSEL=a[0];
w_tipodest=a[1];
w_opextc=a[2];
w_destfin=a[3];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_start_wuchkpas',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function DisplayErrorMessage() {
if (Le(m_nLastError,-1)) {
return;
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
WindowAlert(Translate(m_cObblFieldName)+' : '+Translate(l_cErrorMsg));
} else {
if (Eq(l_cErrorMsg,'MSG_VALUE_NOT_ALLOWED') && Ne(m_cLastWorkVarErrorMsg,'')) {
WindowAlert(Translate(m_cLastWorkVarErrorMsg)+': '+Translate(l_cErrorMsg));
} else {
WindowAlert(Translate(l_cErrorMsg));
}
}
if (Ne(m_cLastWorkVarError,'')) {
SetControlFocus(m_cLastWorkVarError);
SetErrorField(m_cLastWorkVarError,true);
m_cLastWorkVarError='';
}
} else if (Ne(typeof('DisplayErrorMessage_'+m_cErrorInChild),'undefined')) {
DisplayErrorMessageOfChild(m_cErrorInChild);
}
}
function ResetErrorVars() {
m_nLastError=0;
m_cLastMsgError='';
m_cLastWorkVarError='';
m_cLastWorkVarErrorMsg='';
m_cErrorInChild='';
}
function EnableControlsUnderCondition() {
var l_bEnabled = true;
// * --- Area Manuale = UI - Enable Controls Init
// * --- Fine Area Manuale
if (Ne(typeof(tabs),'undefined')) {
tabs.CheckTabStrip();
}
l_bEnabled= ! (Eq(w_tipodest,'D')) || IsDisabledByStateDriver('opextc');
SetDisabled(Ctrl('JAKNEJNBKZ'),l_bEnabled);
DisableUI();
if (Gt(m_nRows,0)) {
}
HideControlsUnderCondition();
ObligatoryControlsUnderCondition();
// * --- Area Manuale = UI - Enable Controls End
// * --- Fine Area Manuale
}
function ObligatoryControlsUnderCondition() {
var l_bObligatory = true;
}
function SetDynamicClasses() {
var c;
}
function SetDynamicTooltip() {
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
function Update() {
var l_bUpdate;
var l_nRow;
l_nRow=0;
l_bUpdate=true;
if (m_bFieldsUpdated) {
while (l_bUpdate && Lt(m_nCurrentRow,m_nRows)) {
ChangeRow(l_nRow);
l_bUpdate=l_bUpdate && Eq(m_nCurrentRow,l_nRow);
l_nRow=l_nRow+1;
}
}
if (l_bUpdate) {
FillFrmTrs('WUFLGSEL');
SubmitForm('save');
}
}
function Set_tipodest(ctrlValue,kmode,e) {
if (Ne(w_tipodest,ctrlValue)) {
var ctl = _GetCtl(e,'WIRRRKLEWO');
if (_tracker.goon(ctl,ctrlValue)) {
w_tipodest=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('WIRRRKLEWO',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_opextc(ctrlValue,kmode,e) {
if (Ne(w_opextc,ctrlValue)) {
var ctl = _GetCtl(e,'JAKNEJNBKZ');
if (_tracker.goon(ctl,ctrlValue)) {
w_opextc=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('JAKNEJNBKZ',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_destfin(ctrlValue,kmode,e) {
if (Ne(w_destfin,ctrlValue)) {
var ctl = _GetCtl(e,'RQAECCWOBF');
if (_tracker.goon(ctl,ctrlValue)) {
w_destfin=ctrlValue;
SetModified(false);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('RQAECCWOBF',0);
DoUpdate(l_bResult);
} else {
ctl.value=WtH('','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Set_WUFLGSEL(ctrlValue,kmode,e) {
if (Ne(w_WUFLGSEL,ctrlValue)) {
var ctl = _GetCtl(e,'KDKDULGISN_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_WUFLGSEL=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('KDKDULGISN',0);
DoFieldsUpdate(l_bResult);
} else {
ctl.value=WtH('N','C',1,0,'');
_ResetTracker();
return true;
}
}
return true;
}
function Calculate() {
var l_bTmpRes;
var l_bResult = true;
m_bCalculating=true;
// * --- Area Manuale = UI - Calculate
// * --- Fine Area Manuale
m_bCalculating=false;
}
function SaveDependsOn() {
}
function SaveLabelDependsOn() {
}
function SendData(formaction,url,data) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
if (Eq(formaction,'discard')) {
return;
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
if ( ! (_ChkObl('WIRRRKLEWO',1))) {
_SignErr('WIRRRKLEWO');
m_cLastWorkVarErrorMsg='tipodest';
l_bResult=false;
w_tipodest=HtW('','C');
} else if ((Eq(w_tipodest,'D')) && ( ! (_ChkObl('JAKNEJNBKZ',1)))) {
_SignErr('JAKNEJNBKZ');
m_cLastWorkVarErrorMsg='opextc';
l_bResult=false;
w_opextc='N';
} else if ( ! (_ChkObl('RQAECCWOBF',1))) {
_SignErr('RQAECCWOBF');
m_cLastWorkVarErrorMsg='destfin';
l_bResult=false;
w_destfin=HtW('','C');
} else if ( ! (_ChkObl('KDKDULGISN',1))) {
_SignErr('KDKDULGISN_'+m_nCurrentRow+'');
m_cLastWorkVarErrorMsg='1500692548';
l_bResult=false;
w_WUFLGSEL='N';
}
// * --- Area Manuale = UI - Check Form
// * --- Fine Area Manuale
return l_bResult;
}
function link_index(lc) {
return -1;
}
function link_url(index) {
var l_oWv;
}
function FillWv() {
var l_oWv = InitWvApplet();
l_oWv.setValue('WUFLGSEL',WtA(w_WUFLGSEL,'C'));
l_oWv.setValue('tipodest',WtA(w_tipodest,'C'));
l_oWv.setValue('opextc',WtA(w_opextc,'C'));
l_oWv.setValue('destfin',WtA(w_destfin,'C'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["WUFLGSEL","tipodest","opextc","destfin"];
function SetModified(bRepeated) {
m_bUpdated=true;
if (bRepeated) {
if (Le(m_nCurrentRow,m_oTrsFW.length)) {
m_nRowStatus=1;
}
}
}
function initNoLocalVars(start,pseq) {
m_bCalculating=true;
if (start && Eq(At(',tipodest,',pseq),0)) {
w_tipodest='P';
}
if (start && Eq(At(',opextc,',pseq),0)) {
w_opextc='N';
}
if (start && Eq(At(',destfin,',pseq),0)) {
w_destfin='O';
}
m_bCalculating=false;
SaveDependsOn();
SetControlsValue();
EnableControlsUnderCondition();
SaveLabelDependsOn();
DoUpdate(true);
var l_oCaller;
if (IsWndAccessible(l_oCaller)) {
var xAccessErr; try{l_oCaller.Ctrl;}catch(e){xAccessErr=1;} //IE security access error
if ( ! (xAccessErr) && Ne(typeof(l_oCaller.Ctrl),'undefined') && Ne(l_oCaller.Ctrl('FSender'),null) && Ne(typeof(l_oCaller.Ctrl('FSender').m_cOldCPCCCHK),'undefined')) {
m_cCPCCCHK=l_oCaller.Ctrl('FSender').m_cOldCPCCCHK.value;
}
}
}
function CheckRow() {
var l_bResult = true;
ResetErrorVars();
if (Lt(m_nCurrentRow,m_nRows)) {
}
return l_bResult;
}
function TrsFWRow() {
  this.w_WUFLGSEL = arguments[0]
  this.t_WUFLGSEL = arguments[1]
  this.k_WUFLGSEL_WUNOMEFILE = arguments[2]
  this.k_WUFLGSEL_WURIFEMTCN = arguments[3]
  this.m_nRowStatus = arguments[4]
}
function TrsQueryRow() {
  this.c_WUNOMEFILE = arguments[0]
  this.c_WURIFEMTCN = arguments[1]
  this.c_WUNCLIENTE = arguments[2]
  this.c_WUCODDIPEN = arguments[3]
  this.c_WUTIPESITO = arguments[4]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_WUFLGSEL=row.w_WUFLGSEL;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_WUNOMEFILE=row.c_WUNOMEFILE;
c_WURIFEMTCN=row.c_WURIFEMTCN;
c_WUNCLIENTE=row.c_WUNCLIENTE;
c_WUCODDIPEN=row.c_WUCODDIPEN;
c_WUTIPESITO=row.c_WUTIPESITO;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_WUFLGSEL=w_WUFLGSEL;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_WUNOMEFILE=c_WUNOMEFILE;
row.c_WURIFEMTCN=c_WURIFEMTCN;
row.c_WUNCLIENTE=c_WUNCLIENTE;
row.c_WUCODDIPEN=c_WUCODDIPEN;
row.c_WUTIPESITO=c_WUTIPESITO;
}
}
function BlankQueryFields() {
c_WUNOMEFILE='';
c_WURIFEMTCN='';
c_WUNCLIENTE='';
c_WUCODDIPEN='';
c_WUTIPESITO='';
}
function FillHTMLRow() {
var l_nIdx = 0;
var l_oQuery;
var l_oFields;
var l_nEvenOdd = 0;
var l_nPrev = 0;
var l_nNext = 0;
var l_bEof;
l_bEof=Eq(m_nRows,0);
var l_nDeep;
l_nDeep=-1;
var l_nPos = 0;
var l_YQPVPCMNBZ = false;
var l_old_YQPVPCMNBZ = l_YQPVPCMNBZ;
Body_BeginHtml(70,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_YQPVPCMNBZ=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_YQPVPCMNBZ,l_YQPVPCMNBZ)) {
l_nDeep=2;
} else {
l_nDeep=3;
}
}
} else {
l_bEof=true;
l_nDeep=1;
}
l_nIdx=l_nIdx-1;
if (Ge(l_nIdx,0)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
}
if (Ge(2,l_nDeep) && Ge(l_nIdx,0)) {
GroupFooter_BeginHtml(document,1,'10511760461'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'10511760461'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_YQPVPCMNBZ = l_YQPVPCMNBZ;
if ( ! (l_bEof)) {
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
DrawLine(document);
l_nEvenOdd = l_nEvenOdd+1;
}
if ( ! (l_bEof)) {
l_nIdx=l_nIdx+1;
}
}
if (Gt(m_nRows,0) || Lt(l_nIdx,m_nRows)) {
Update_Button("RPLXQTUPFS",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'10511629389'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_09E80B28"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel PTADQANBXD_DIV'>" +
 "<label class='PTADQANBXD'>" +
 ""+ToHTag(Translate("763806883"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel CZUHROMQZB_DIV'>" +
 "<label class='CZUHROMQZB'>" +
 ""+ToHTag(Translate("338061"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel REIDMAKUJF_DIV'>" +
 "<label class='REIDMAKUJF'>" +
 ""+ToHTag(Translate("55887572"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel LOXDFNNHHV_DIV'>" +
 "<label class='LOXDFNNHHV'>" +
 ""+ToHTag(Translate("1823784963"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'10511629389'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'11433720909'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_09E619A0"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<span class='KDKDULGISN_DIV' id='KDKDULGISN_"+l_nIdx+"_DIV'>" +
 "<input name='WUFLGSEL_"+l_nIdx+"' id='KDKDULGISN_"+l_nIdx+"' type='checkbox' value="+ToHTMLValue(WtH(w_WUFLGSEL,"C",1,0,''))+" "+(Eq('S',w_WUFLGSEL)?'CHECKED':'')+">" +
 "<label id='KDKDULGISN_"+l_nIdx+"_LBL' for='KDKDULGISN_"+l_nIdx+"' class='SPLabel'>"+ToHTag(Translate("146644790"))+"</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel YDQCTHKKQK_DIV'>" +
 "<label class='YDQCTHKKQK'>" +
 ""+ToHTag(WtH(c_WUNOMEFILE,'C',20,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel SNJMSNTMRK_DIV'>" +
 "<label class='SNJMSNTMRK'>" +
 ""+ToHTag(WtH(c_WURIFEMTCN,'C',10,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel BWGBGJOALI_DIV'>" +
 "<label class='BWGBGJOALI'>" +
 ""+ToHTag(WtH(c_WUCODDIPEN,'C',6,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel ORXETWTLRF_DIV'>" +
 "<label class='ORXETWTLRF'>" +
 ""+ToHTag(WtH(c_WUNCLIENTE,'C',40,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'11433720909'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('tipodest',0,'WIRRRKLEWO',false)
_Obli('opextc',0,'JAKNEJNBKZ',false)
_Obli('destfin',0,'RQAECCWOBF',false)
_Obli('WUFLGSEL',0,'KDKDULGISN',false,"1500692548")
