function SendData(formaction) {
SubmitListenerForm('discard');
}
function SubmitListenerForm(formaction) {
if (Eq(m_bAlreadySubmitted,true)) {
WindowAlert(Translate('MSG_SERVER_DATA'));
return;
}
var Frm = document.FSender;
var bResult = true;
if (Eq(formaction,'delete')) {
if (m_bLoaded) {
bResult=WindowConfirm(Translate('MSG_PROCEED_WITH_DELETE'));
} else {
bResult=false;
WindowAlert(Translate('MSG_REC_NOT_SELECTED'));
}
} else if (Eq(formaction,'edit')) {
if (Eq(m_cLanguage,'eng')) {
document.FSender.DTRIL.value=FormatDate(HtmlToWork_Date(document.FSender.DTRIL.value),'DD-MM-YYYY');
}
Frm.m_cSelectedPage.value=GetSelectedPage(InitWvApplet()).asString();
if (m_bLoaded) {
} else {
bResult=false;
WindowAlert(Translate('MSG_REC_NOT_SELECTED'));
}
} else {
Frm.m_cSelectedPage.value='';
m_cSelectedPage='';
}
if (bResult) {
SubmitForm.SetAction(formaction);
Frm.m_cAltInterface.value=m_cAltInterface;
Frm.m_cLayerInterface.value=m_cLayerInterface;
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
}
}
var m_bIsMq = false;
function SetMultiQuery(e) {
var Frm = document.FSender;
if (m_bIsMq) {
var ctrl = GetEventSrcElement(e);
if (Ne(ctrl,null)) {
var id = ctrl.id;
if (Eq('function',typeof(id+'_Valid'))) {
window[id+'_Valid'](null);
}
}
m_bIsMq=false;
Frm.m_cMode.value='';
Frm.m_cAction.value='query';
Frm.m_cSelectedPage.value=GetSelectedPage(InitWvApplet()).asString();
// * --- Area Manuale = UI - Build Filter
// * --- Fine Area Manuale
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
} else {
Frm.m_cLastWhere.value='';
m_bIsMq=true;
}
}
function DoQuery(name,type,workvarValue,ctrlValue,sendfullkey) {
var l_bQuery = false;
if (sendfullkey) {
if (Ne(HtW(Ctrl('QOPKWXJPKL').value,'C'),w_CONNES)) {
l_bQuery=true;
}
if (Ne(HtW(Ctrl('INHXXZSCAR').value,'D'),w_DTRIL)) {
l_bQuery=true;
}
if (Ne(HtW(Ctrl('GOROYGEXRL').value,'C'),w_IDMOD)) {
l_bQuery=true;
}
}
if (Ne(ctrlValue,workvarValue) || l_bQuery) {
if (IsWndAccessible(window['m_oFather'])) {
// Gestione filtro avanzato figli-padri
if (m_oFather.DoQueryFromChild) {
m_oFather.DoQueryFromChild('rilevazioni',_flt_(m_cVirtName+'.'+name,ctrlValue,type),m_cVirtName);
}
} else {
var Frm = document.FSender;
if (m_bIsMq) {
if (Eq(Frm.m_cLastWhere.value,'')) {
Frm.m_cLastWhere.value=_flt_(m_cVirtName+'.'+name,ctrlValue,type);
} else {
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+' and '+_flt_(m_cVirtName+'.'+name,ctrlValue,type);
}
} else {
Frm.m_cLastWhere.value='';
if ( ! (Empty(ctrlValue))) {
Frm.m_cLastWhere.value=_flt_(m_cVirtName+'.'+name,ctrlValue,type);
}
if (sendfullkey) {
if (Ne(name,'CONNES') &&  ! (Empty(HtW(Ctrl('QOPKWXJPKL').value,'C')))) {
if ( ! (Empty(Frm.m_cLastWhere.value))) {
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+' and ';
}
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+_flt_(m_cVirtName+'.CONNES',HtW(Ctrl('QOPKWXJPKL').value,'C'),'C');
}
if (Ne(name,'DTRIL') &&  ! (Empty(HtW(Ctrl('INHXXZSCAR').value,'D')))) {
if ( ! (Empty(Frm.m_cLastWhere.value))) {
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+' and ';
}
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+_flt_(m_cVirtName+'.DTRIL',HtW(Ctrl('INHXXZSCAR').value,'D'),'D');
}
if (Ne(name,'IDMOD') &&  ! (Empty(HtW(Ctrl('GOROYGEXRL').value,'C')))) {
if ( ! (Empty(Frm.m_cLastWhere.value))) {
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+' and ';
}
Frm.m_cLastWhere.value=Frm.m_cLastWhere.value+_flt_(m_cVirtName+'.IDMOD',HtW(Ctrl('GOROYGEXRL').value,'C'),'C');
}
}
if (Ne(type,'M')) {
Frm.m_cLastOrderBy.value=m_cVirtName+'.'+name;
} else {
Frm.m_cLastOrderBy.value='';
}
Frm.m_cMode.value='';
Frm.m_cAction.value='query';
// * --- Area Manuale = UI - Build Filter
// * --- Fine Area Manuale
Frm.submit();
m_bAlreadySubmitted=true;
InstTR();
}
}
}
}
function DoQueryFromChild(childAlias,childWhere,allAliases) {
var keyWhere = '';
var firstAlias = allAliases.split("|")[0];
if (childAlias) {
if (window['DoQueryFrom_'+childAlias]) {
keyWhere=window["DoQueryFrom_"+childAlias](firstAlias);
} else {
_chNotF(childAlias,'detail','aosdt_rilevazioni');
return;
}
}
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.DoQueryFromChild('rilevazioni',keyWhere+' and '+childWhere,m_cVirtName+'|'+allAliases);
} else {
var Frm = document.FSender;
Frm.m_cLastWhere.value=keyWhere+' and '+childWhere;
Frm.m_cMode.value='';
Frm.m_cAction.value='query';
Frm.m_cAllVirtNames.value=m_cVirtName+'|'+allAliases;
Frm.submit();
}
}
function IsLastInPk(id) {
if ( ! (m_bQueryOnLatestKeyOnly)) {
return true;
}
if (Empty(IsLastInPk.Last)) {
for(var a=['QOPKWXJPKL','INHXXZSCAR','GOROYGEXRL'],i=2;i>=0;i--){
if (Ne(Ctrl(a[i]).style.display,'none') && Ne(Ctrl(a[i]).style.visibility,'hidden') &&  ! (GetDisabled(a[i]))) {
IsLastInPk.Last=a[i];
break;
}
}
}
return Eq(IsLastInPk.Last,id);
}
