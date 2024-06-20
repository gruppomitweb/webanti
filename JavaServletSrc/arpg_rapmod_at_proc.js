function SetControlsValue() {
var c;
var c;
if (Gt(m_nRows,0) && Lt(m_nCurrentRow,m_oTrsFW.length)) {
if (Ne(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),null)) {
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) ChkboxCheckUncheck(c,'S',w_TIPO)
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) ChkboxValueAssign(c,'S','N','C',1,0,'')
}
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
if (Gt(m_nRows,0)) {
SetDisplay(Ctrl('ACJEOURJYI'),true);
}
HideUI();
}
function href_FLFHSXPWZI() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_rapmod_at']));
SendData('start','arrt_rapmod_at'+'',HParApplet().asString());
}
function href_VRHQBWKFPP() {
SetHypPar('m_bQuery',AsAppletValue(true));
var action = (Eq(Left('arpg_rapmod_at'+''+'?',15),'arpg_rapmod_at?')?'query':'start');
SetHypPar('m_cAction',AsAppletValue(action));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SendData(action,'arpg_rapmod_at'+'',HParApplet().asString());
}
function href_HDSXZTLKVK() {
Update()
}
function href_ZWTNEMXOFQ() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('D'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_rapmod_at']));
SendData('start','arrt_seldes_rapmod_at'+'',HParApplet().asString());
}
function href_FCATLNLMSB() {
SetHypPar('m_cAction',AsAppletValue('start'));
SetHypPar('m_cMode',AsAppletValue('hyperlink'));
SetHypPar('pTipo',AsAppletValue('S'));
SetHypPar('m_cParameterSequence',AsAppletValue('pTipo'));
SetHypPar('m_cID',AsAppletValue(m_IDS['arrt_seldes_rapmod_at']));
SendData('start','arrt_seldes_rapmod_at'+'',HParApplet().asString());
}
function BBVZXDYMJX_Valid(e) {
var org = GetEventSrcElement(e);
if ( ! (org.focused)) {
var c = org.checked;
org.focus();
org.checked=c;
}
e=(Ne(e,null)?e:window.event);
return Set_TIPO(ChkboxValueAssign(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),'S','N','C',1,0,''),null,e);
}
function BBVZXDYMJX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function BBVZXDYMJX_OnBlur(e) {
SetActiveField(Ctrl('BBVZXDYMJX_'+m_nCurrentRow),false);
}
function BBVZXDYMJX_OnBlur(e) {
var org = GetEventSrcElement(e);
org.focused=false;
}
function BBVZXDYMJX_OnFocus(e) {
var org;
org=GetEventSrcElement(e);
org.focused=true;
ChangeRow(Val(Right(org.name,Len(org.name)-RAt('_',org.name))));
}
function href_PTXYMSWBZO() {
SetLocationHref(window.location,ToResource('jsp/start_page_logo_portlet.jsp'+'')+'')
}
_ResetTracker();
function setEventHandlers(detail) {
var c;
if (Eq(m_cFunction,'view')) {
} else {
}
var l_nOldRow = m_nCurrentRow;
m_nCurrentRow=0;
while (Lt(m_nCurrentRow,m_nRows)) {
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onclick=BBVZXDYMJX_Valid;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onfocus=BBVZXDYMJX_OnFocus;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onblur=BBVZXDYMJX_OnBlur;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onfocus=BBVZXDYMJX_OnFocus;
if(c=Ctrl('BBVZXDYMJX_'+m_nCurrentRow)) c.onblur=BBVZXDYMJX_OnBlur;
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
FocusFirstComponent.otherwise={"page_1":["BBVZXDYMJX_'+m_nCurrentRow+'"]};
function Help() {
windowOpenForeground('../doc/arpg_rapmod_at_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TIPO=a[0];
}
function i_PrimaryKey() {
return '';
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('arpg_rapmod_at',m_cSelectedPage);
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
FillFrmTrs('TIPO');
SubmitForm('save');
}
}
function Set_TIPO(ctrlValue,kmode,e) {
if (Ne(w_TIPO,ctrlValue)) {
var ctl = _GetCtl(e,'BBVZXDYMJX_'+m_nCurrentRow+'');
if (_tracker.goon(ctl,ctrlValue)) {
w_TIPO=ctrlValue;
SetModified(true);
var l_bResult = true;
SetErrorField(ctl,false);
l_bResult=_ChkObl('BBVZXDYMJX',0);
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
if ( ! (_ChkObl('BBVZXDYMJX',1))) {
_SignErr('BBVZXDYMJX_'+m_nCurrentRow+'');
m_cLastWorkVarErrorMsg='10345646977';
l_bResult=false;
w_TIPO='N';
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
l_oWv.setValue('TIPO',WtA(w_TIPO,'C'));
_FillChildren(l_oWv);
l_oWv.setValue('m_oTrs',TrsApplet().asString());
}
_FillChildren.n=[];
FillWv.n=["TIPO"];
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
  this.w_TIPO = arguments[0]
  this.t_TIPO = arguments[1]
  this.k_TIPO_RAPPORTO = arguments[2]
  this.m_nRowStatus = arguments[3]
}
function TrsQueryRow() {
  this.c_RAPPORTO = arguments[0]
  this.c_TIPO = arguments[1]
}
function TrsToWork() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
w_TIPO=row.w_TIPO;
m_nRowStatus=row.m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
c_RAPPORTO=row.c_RAPPORTO;
c_TIPO=row.c_TIPO;
}
}
function WorkToTrs() {
var row;
if (Lt(m_nCurrentRow,m_oTrsFW.length)) {
row=m_oTrsFW[m_nCurrentRow];
row.w_TIPO=w_TIPO;
row.m_nRowStatus=m_nRowStatus;
}
if (Lt(m_nCurrentRow,m_oTrsQuery.length)) {
row=m_oTrsQuery[m_nCurrentRow];
row.c_RAPPORTO=c_RAPPORTO;
row.c_TIPO=c_TIPO;
}
}
function BlankQueryFields() {
c_RAPPORTO='';
c_TIPO='';
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
var l_nStartRow = Val(document.FSender.StartRow.value);
var l_nPos = 0;
var l_DBMPSAJNIE = false;
var l_old_DBMPSAJNIE = l_DBMPSAJNIE;
Body_BeginHtml(45,'',0,'A','');
BlankQueryFields();
while ( ! (l_bEof)) {
l_oQuery=m_oTrsQuery[l_nIdx];
l_oFields=m_oTrsFW[l_nIdx];
l_nDeep=0;
if (Lt(l_nIdx,m_nRows)) {
m_nCurrentRow=l_nIdx;
TrsToWork();
l_DBMPSAJNIE=true;
if (Eq(l_nIdx,0)) {
l_nDeep=1;
} else {
if (Ne(l_old_DBMPSAJNIE,l_DBMPSAJNIE)) {
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
GroupFooter_BeginHtml(document,1,'791496269'+l_nIdx+'','A',true,false)
GroupFooter_EndHtml(document,1,'791496269'+l_nIdx+'','A')
} else {
}
l_nIdx=l_nIdx+1;
m_nCurrentRow=l_nIdx;
TrsToWork();
l_old_DBMPSAJNIE = l_DBMPSAJNIE;
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
Body_Buttons(Gt(l_nStartRow,1),m_bOtherRow,'A');
if (Gt(m_nRows,0) || Lt(l_nIdx,m_nRows)) {
Update_Button("ACJEOURJYI",Translate("113933141"),"","","","CLASS=FormDefault STYLE='display:"+(true?'none':'inline')+"'","")
}
Body_EndHtml('A');
}
function DrawLine(document) {
l_nIdx=Parms.Idx;
l_nDeep=Parms.Deep;
l_nEvenOdd=Parms.EvenOdd;
if (Ge(2,l_nDeep)) {
GroupHeader_BeginHtml(document,1,'1328367181'+l_nIdx+'','A',true,false)
document.writeln(
 "<div id='DIV_09832508"+l_nIdx+"' style='position:relative;height:17px'>" +
"")
document.writeln(
 "<span class=' SPLabel JUIALTQGYN_DIV'>" +
 "<label class='JUIALTQGYN'>" +
 ""+ToHTag(Translate("1805022818"))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
GroupHeader_EndHtml(document,1,'1328367181'+l_nIdx+'','A')
} else {
}
Row_BeginHtml(document,l_nEvenOdd,'10282246434'+l_nIdx+'','A',true,-1)
document.writeln(
 "<div id='DIV_097F1AC0"+l_nIdx+"' style='position:relative;height:22px'>" +
"")
document.writeln(
 "<span class='BBVZXDYMJX_DIV' id='BBVZXDYMJX_"+l_nIdx+"_DIV'>" +
 "<input name='TIPO_"+l_nIdx+"' id='BBVZXDYMJX_"+l_nIdx+"' type='checkbox' value="+ToHTMLValue(WtH(w_TIPO,"C",1,0,''))+" "+(Eq('S',w_TIPO)?'CHECKED':'')+">" +
 "<label id='BBVZXDYMJX_"+l_nIdx+"_LBL' for='BBVZXDYMJX_"+l_nIdx+"' class='SPLabel'>"+ToHTag(Translate("340732011"))+"</label>" +
 "</span>" +
"")
document.writeln(
 "<span class=' SPLabel RNOKLAJWBF_DIV'>" +
 "<label class='RNOKLAJWBF'>" +
 ""+ToHTag(WtH(c_RAPPORTO,'C',25,0,''))+"" +
 "</label>" +
 "</span>" +
"")
document.writeln(
 "</div>" +
"")
Row_EndHtml(document,l_nEvenOdd,'10282246434'+l_nIdx+'','A')
Parms.Idx=l_nIdx;
Parms.Deep=l_nDeep;
Parms.EvenOdd=l_nEvenOdd;
}
Parms=new Object();
_Obli('TIPO',0,'BBVZXDYMJX',false,"10345646977")
