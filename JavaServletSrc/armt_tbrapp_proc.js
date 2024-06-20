function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('QPKQOSKHNE',function(){return WtH(w_IMP12022,'C',250,0,'')},w_IMP12022);
SPBOUILib.SetInputValue('UXHOBDXZYD',function(){return WtH(w_IMP22022,'C',250,0,'')},w_IMP22022);
SPBOUILib.SetInputValue('SGYPEZIWSO',function(){return WtH(w_IMP32022,'C',250,0,'')},w_IMP32022);
SPBOUILib.SetInputValue('PWLMWGXLJT',function(){return WtH(w_IMP42022,'C',250,0,'')},w_IMP42022);
SPBOUILib.SetInputValue('RRLCWIMLZS',function(){return WtH(w_IMP52022,'C',250,0,'')},w_IMP52022);
SPBOUILib.SetInputValue('MFEVNPBTPC',function(){return WtH(w_IMP62022,'C',250,0,'')},w_IMP62022);
SPBOUILib.SetInputValue('ADJOBBEXVH',function(){return WtH(w_CODICE,'C',2,0,'')},w_CODICE);
SPBOUILib.SetInputValue('ZERUEFFPAN',function(){return WtH(w_DESCRI,'C',150,0,'')},w_DESCRI);
SPBOUILib.SetInputValue('NHIBLOVEPP',function(){return WtH(w_NOTE,'C',254,0,'')},w_NOTE);
SPBOUILib.SetInputValue('ISRIBATOWG',function(){return WtH(w_IMP1,'C',250,0,'')},w_IMP1);
SPBOUILib.SetInputValue('CJNBNYNUXU',function(){return WtH(w_IMP2,'C',250,0,'')},w_IMP2);
SPBOUILib.SetInputValue('GHRZZISGXZ',function(){return WtH(w_IMP3,'C',250,0,'')},w_IMP3);
SPBOUILib.SetInputValue('QVCQRBWCAT',function(){return WtH(w_IMP4,'C',250,0,'')},w_IMP4);
SPBOUILib.SetInputValue('VWCEDYCYHE',function(){return WtH(w_IMP5,'C',250,0,'')},w_IMP5);
SPBOUILib.SetInputValue('JZHAQSZZBZ',function(){return WtH(w_IMP6,'C',250,0,'')},w_IMP6);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('TFQVKXQXHO_DIV',IsHiddenByStateDriver('D2022'));
SetDisplay('PBZPZCASCW_DIV',IsHiddenByStateDriver('DBase'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODICE"]=['WYYRDQQIXN'];
HideUI.lblids["DESCRI"]=['LTDNQXYFTA'];
HideUI.lblids["IMP1"]=['VFFHROEFUG'];
HideUI.lblids["IMP12022"]=['PRAZMPMEBX'];
HideUI.lblids["IMP2"]=['LYEOZLTJBB'];
HideUI.lblids["IMP22022"]=['JMOQSTYGIR'];
HideUI.lblids["IMP3"]=['BLLWFBOIXZ'];
HideUI.lblids["IMP32022"]=['JXNHOLCKWS'];
HideUI.lblids["IMP4"]=['YQWZBWPUWH'];
HideUI.lblids["IMP42022"]=['VLWJKAMWMQ'];
HideUI.lblids["IMP5"]=['NOHUTOFZXQ'];
HideUI.lblids["IMP52022"]=['XVSRXUJOAB'];
HideUI.lblids["IMP6"]=['OJJWQMIQGE'];
HideUI.lblids["IMP62022"]=['PLTOMLIRRM'];
HideUI.lblids["NOTE"]=['OPVBTUWWMZ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function QPKQOSKHNE_Valid(e) {
SetActiveField(Ctrl('QPKQOSKHNE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP12022','C',w_IMP12022,HtW(Ctrl('QPKQOSKHNE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP12022(HtW(Ctrl('QPKQOSKHNE').value,'C'),null,e);
return l_bSetResult;
}
}
function QPKQOSKHNE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QPKQOSKHNE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QPKQOSKHNE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QPKQOSKHNE'),e);
}
function UXHOBDXZYD_Valid(e) {
SetActiveField(Ctrl('UXHOBDXZYD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP22022','C',w_IMP22022,HtW(Ctrl('UXHOBDXZYD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP22022(HtW(Ctrl('UXHOBDXZYD').value,'C'),null,e);
return l_bSetResult;
}
}
function UXHOBDXZYD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UXHOBDXZYD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UXHOBDXZYD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UXHOBDXZYD'),e);
}
function SGYPEZIWSO_Valid(e) {
SetActiveField(Ctrl('SGYPEZIWSO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP32022','C',w_IMP32022,HtW(Ctrl('SGYPEZIWSO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP32022(HtW(Ctrl('SGYPEZIWSO').value,'C'),null,e);
return l_bSetResult;
}
}
function SGYPEZIWSO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SGYPEZIWSO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SGYPEZIWSO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SGYPEZIWSO'),e);
}
function PWLMWGXLJT_Valid(e) {
SetActiveField(Ctrl('PWLMWGXLJT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP42022','C',w_IMP42022,HtW(Ctrl('PWLMWGXLJT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP42022(HtW(Ctrl('PWLMWGXLJT').value,'C'),null,e);
return l_bSetResult;
}
}
function PWLMWGXLJT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PWLMWGXLJT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PWLMWGXLJT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PWLMWGXLJT'),e);
}
function RRLCWIMLZS_Valid(e) {
SetActiveField(Ctrl('RRLCWIMLZS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP52022','C',w_IMP52022,HtW(Ctrl('RRLCWIMLZS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP52022(HtW(Ctrl('RRLCWIMLZS').value,'C'),null,e);
return l_bSetResult;
}
}
function RRLCWIMLZS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RRLCWIMLZS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RRLCWIMLZS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RRLCWIMLZS'),e);
}
function MFEVNPBTPC_Valid(e) {
SetActiveField(Ctrl('MFEVNPBTPC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP62022','C',w_IMP62022,HtW(Ctrl('MFEVNPBTPC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP62022(HtW(Ctrl('MFEVNPBTPC').value,'C'),null,e);
return l_bSetResult;
}
}
function MFEVNPBTPC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MFEVNPBTPC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MFEVNPBTPC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MFEVNPBTPC'),e);
}
function ADJOBBEXVH_Valid(e) {
SetActiveField(Ctrl('ADJOBBEXVH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICE','C',w_CODICE,HtW(Ctrl('ADJOBBEXVH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICE(HtW(Ctrl('ADJOBBEXVH').value,'C'),null,e);
return l_bSetResult;
}
}
function ADJOBBEXVH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ADJOBBEXVH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ADJOBBEXVH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ADJOBBEXVH'),e);
}
function ZERUEFFPAN_Valid(e) {
SetActiveField(Ctrl('ZERUEFFPAN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRI','C',w_DESCRI,HtW(Ctrl('ZERUEFFPAN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRI(HtW(Ctrl('ZERUEFFPAN').value,'C'),null,e);
return l_bSetResult;
}
}
function ZERUEFFPAN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZERUEFFPAN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZERUEFFPAN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZERUEFFPAN'),e);
}
function NHIBLOVEPP_Valid(e) {
SetActiveField(Ctrl('NHIBLOVEPP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTE','C',w_NOTE,HtW(Ctrl('NHIBLOVEPP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTE(HtW(Ctrl('NHIBLOVEPP').value,'C'),null,e);
return l_bSetResult;
}
}
function NHIBLOVEPP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NHIBLOVEPP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NHIBLOVEPP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NHIBLOVEPP'),e);
}
function ISRIBATOWG_Valid(e) {
SetActiveField(Ctrl('ISRIBATOWG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP1','C',w_IMP1,HtW(Ctrl('ISRIBATOWG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP1(HtW(Ctrl('ISRIBATOWG').value,'C'),null,e);
return l_bSetResult;
}
}
function ISRIBATOWG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ISRIBATOWG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ISRIBATOWG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ISRIBATOWG'),e);
}
function CJNBNYNUXU_Valid(e) {
SetActiveField(Ctrl('CJNBNYNUXU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP2','C',w_IMP2,HtW(Ctrl('CJNBNYNUXU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP2(HtW(Ctrl('CJNBNYNUXU').value,'C'),null,e);
return l_bSetResult;
}
}
function CJNBNYNUXU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CJNBNYNUXU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CJNBNYNUXU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CJNBNYNUXU'),e);
}
function GHRZZISGXZ_Valid(e) {
SetActiveField(Ctrl('GHRZZISGXZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP3','C',w_IMP3,HtW(Ctrl('GHRZZISGXZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP3(HtW(Ctrl('GHRZZISGXZ').value,'C'),null,e);
return l_bSetResult;
}
}
function GHRZZISGXZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GHRZZISGXZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GHRZZISGXZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GHRZZISGXZ'),e);
}
function QVCQRBWCAT_Valid(e) {
SetActiveField(Ctrl('QVCQRBWCAT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP4','C',w_IMP4,HtW(Ctrl('QVCQRBWCAT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP4(HtW(Ctrl('QVCQRBWCAT').value,'C'),null,e);
return l_bSetResult;
}
}
function QVCQRBWCAT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QVCQRBWCAT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QVCQRBWCAT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QVCQRBWCAT'),e);
}
function VWCEDYCYHE_Valid(e) {
SetActiveField(Ctrl('VWCEDYCYHE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP5','C',w_IMP5,HtW(Ctrl('VWCEDYCYHE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP5(HtW(Ctrl('VWCEDYCYHE').value,'C'),null,e);
return l_bSetResult;
}
}
function VWCEDYCYHE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VWCEDYCYHE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VWCEDYCYHE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VWCEDYCYHE'),e);
}
function JZHAQSZZBZ_Valid(e) {
SetActiveField(Ctrl('JZHAQSZZBZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMP6','C',w_IMP6,HtW(Ctrl('JZHAQSZZBZ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMP6(HtW(Ctrl('JZHAQSZZBZ').value,'C'),null,e);
return l_bSetResult;
}
}
function JZHAQSZZBZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JZHAQSZZBZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JZHAQSZZBZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JZHAQSZZBZ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QPKQOSKHNE_wrap_Valid(event) {
return QPKQOSKHNE_Valid(event);
}
SPBOUILib.SetInputExit('QPKQOSKHNE',QPKQOSKHNE_wrap_Valid);
function QPKQOSKHNE_wrap_OnFocus(event) {
return QPKQOSKHNE_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPKQOSKHNE',QPKQOSKHNE_wrap_OnFocus);
function QPKQOSKHNE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QPKQOSKHNE',QPKQOSKHNE_wrap_OnKeyDown);
function UXHOBDXZYD_wrap_Valid(event) {
return UXHOBDXZYD_Valid(event);
}
SPBOUILib.SetInputExit('UXHOBDXZYD',UXHOBDXZYD_wrap_Valid);
function UXHOBDXZYD_wrap_OnFocus(event) {
return UXHOBDXZYD_OnFocus(event);
}
SPBOUILib.SetInputEnter('UXHOBDXZYD',UXHOBDXZYD_wrap_OnFocus);
function UXHOBDXZYD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UXHOBDXZYD',UXHOBDXZYD_wrap_OnKeyDown);
function SGYPEZIWSO_wrap_Valid(event) {
return SGYPEZIWSO_Valid(event);
}
SPBOUILib.SetInputExit('SGYPEZIWSO',SGYPEZIWSO_wrap_Valid);
function SGYPEZIWSO_wrap_OnFocus(event) {
return SGYPEZIWSO_OnFocus(event);
}
SPBOUILib.SetInputEnter('SGYPEZIWSO',SGYPEZIWSO_wrap_OnFocus);
function SGYPEZIWSO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SGYPEZIWSO',SGYPEZIWSO_wrap_OnKeyDown);
function PWLMWGXLJT_wrap_Valid(event) {
return PWLMWGXLJT_Valid(event);
}
SPBOUILib.SetInputExit('PWLMWGXLJT',PWLMWGXLJT_wrap_Valid);
function PWLMWGXLJT_wrap_OnFocus(event) {
return PWLMWGXLJT_OnFocus(event);
}
SPBOUILib.SetInputEnter('PWLMWGXLJT',PWLMWGXLJT_wrap_OnFocus);
function PWLMWGXLJT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PWLMWGXLJT',PWLMWGXLJT_wrap_OnKeyDown);
function RRLCWIMLZS_wrap_Valid(event) {
return RRLCWIMLZS_Valid(event);
}
SPBOUILib.SetInputExit('RRLCWIMLZS',RRLCWIMLZS_wrap_Valid);
function RRLCWIMLZS_wrap_OnFocus(event) {
return RRLCWIMLZS_OnFocus(event);
}
SPBOUILib.SetInputEnter('RRLCWIMLZS',RRLCWIMLZS_wrap_OnFocus);
function RRLCWIMLZS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RRLCWIMLZS',RRLCWIMLZS_wrap_OnKeyDown);
function MFEVNPBTPC_wrap_Valid(event) {
return MFEVNPBTPC_Valid(event);
}
SPBOUILib.SetInputExit('MFEVNPBTPC',MFEVNPBTPC_wrap_Valid);
function MFEVNPBTPC_wrap_OnFocus(event) {
return MFEVNPBTPC_OnFocus(event);
}
SPBOUILib.SetInputEnter('MFEVNPBTPC',MFEVNPBTPC_wrap_OnFocus);
function MFEVNPBTPC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MFEVNPBTPC',MFEVNPBTPC_wrap_OnKeyDown);
function ADJOBBEXVH_wrap_Valid(event) {
return ADJOBBEXVH_Valid(event);
}
SPBOUILib.SetInputExit('ADJOBBEXVH',ADJOBBEXVH_wrap_Valid);
function ADJOBBEXVH_wrap_OnFocus(event) {
return ADJOBBEXVH_OnFocus(event);
}
SPBOUILib.SetInputEnter('ADJOBBEXVH',ADJOBBEXVH_wrap_OnFocus);
function ADJOBBEXVH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ADJOBBEXVH',ADJOBBEXVH_wrap_OnKeyDown);
function ZERUEFFPAN_wrap_Valid(event) {
return ZERUEFFPAN_Valid(event);
}
SPBOUILib.SetInputExit('ZERUEFFPAN',ZERUEFFPAN_wrap_Valid);
function ZERUEFFPAN_wrap_OnFocus(event) {
return ZERUEFFPAN_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZERUEFFPAN',ZERUEFFPAN_wrap_OnFocus);
function ZERUEFFPAN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZERUEFFPAN',ZERUEFFPAN_wrap_OnKeyDown);
function NHIBLOVEPP_wrap_Valid(event) {
return NHIBLOVEPP_Valid(event);
}
SPBOUILib.SetInputExit('NHIBLOVEPP',NHIBLOVEPP_wrap_Valid);
function NHIBLOVEPP_wrap_OnFocus(event) {
return NHIBLOVEPP_OnFocus(event);
}
SPBOUILib.SetInputEnter('NHIBLOVEPP',NHIBLOVEPP_wrap_OnFocus);
function NHIBLOVEPP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NHIBLOVEPP',NHIBLOVEPP_wrap_OnKeyDown);
function ISRIBATOWG_wrap_Valid(event) {
return ISRIBATOWG_Valid(event);
}
SPBOUILib.SetInputExit('ISRIBATOWG',ISRIBATOWG_wrap_Valid);
function ISRIBATOWG_wrap_OnFocus(event) {
return ISRIBATOWG_OnFocus(event);
}
SPBOUILib.SetInputEnter('ISRIBATOWG',ISRIBATOWG_wrap_OnFocus);
function ISRIBATOWG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ISRIBATOWG',ISRIBATOWG_wrap_OnKeyDown);
function CJNBNYNUXU_wrap_Valid(event) {
return CJNBNYNUXU_Valid(event);
}
SPBOUILib.SetInputExit('CJNBNYNUXU',CJNBNYNUXU_wrap_Valid);
function CJNBNYNUXU_wrap_OnFocus(event) {
return CJNBNYNUXU_OnFocus(event);
}
SPBOUILib.SetInputEnter('CJNBNYNUXU',CJNBNYNUXU_wrap_OnFocus);
function CJNBNYNUXU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CJNBNYNUXU',CJNBNYNUXU_wrap_OnKeyDown);
function GHRZZISGXZ_wrap_Valid(event) {
return GHRZZISGXZ_Valid(event);
}
SPBOUILib.SetInputExit('GHRZZISGXZ',GHRZZISGXZ_wrap_Valid);
function GHRZZISGXZ_wrap_OnFocus(event) {
return GHRZZISGXZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('GHRZZISGXZ',GHRZZISGXZ_wrap_OnFocus);
function GHRZZISGXZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GHRZZISGXZ',GHRZZISGXZ_wrap_OnKeyDown);
function QVCQRBWCAT_wrap_Valid(event) {
return QVCQRBWCAT_Valid(event);
}
SPBOUILib.SetInputExit('QVCQRBWCAT',QVCQRBWCAT_wrap_Valid);
function QVCQRBWCAT_wrap_OnFocus(event) {
return QVCQRBWCAT_OnFocus(event);
}
SPBOUILib.SetInputEnter('QVCQRBWCAT',QVCQRBWCAT_wrap_OnFocus);
function QVCQRBWCAT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QVCQRBWCAT',QVCQRBWCAT_wrap_OnKeyDown);
function VWCEDYCYHE_wrap_Valid(event) {
return VWCEDYCYHE_Valid(event);
}
SPBOUILib.SetInputExit('VWCEDYCYHE',VWCEDYCYHE_wrap_Valid);
function VWCEDYCYHE_wrap_OnFocus(event) {
return VWCEDYCYHE_OnFocus(event);
}
SPBOUILib.SetInputEnter('VWCEDYCYHE',VWCEDYCYHE_wrap_OnFocus);
function VWCEDYCYHE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VWCEDYCYHE',VWCEDYCYHE_wrap_OnKeyDown);
function JZHAQSZZBZ_wrap_Valid(event) {
return JZHAQSZZBZ_Valid(event);
}
SPBOUILib.SetInputExit('JZHAQSZZBZ',JZHAQSZZBZ_wrap_Valid);
function JZHAQSZZBZ_wrap_OnFocus(event) {
return JZHAQSZZBZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('JZHAQSZZBZ',JZHAQSZZBZ_wrap_OnFocus);
function JZHAQSZZBZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JZHAQSZZBZ',JZHAQSZZBZ_wrap_OnKeyDown);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
// used only in child entities
}
function DoUpdate(p_bResult) {
if (Ne(m_cFunction,'query') && Ne(m_cFunction,'view')) {
Calculate();
SaveDependsOn();
SetControlsValue();
SetDynamicClasses();
SetDynamicTooltip();
EnableControlsUnderCondition();
SaveLabelDependsOn();
}
if ( ! (p_bResult)) {
DisplayErrorMessage();
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["QPKQOSKHNE"]};
FocusFirstComponent.query={"page_1":["QPKQOSKHNE"]};
FocusFirstComponent.otherwise={"page_1":["QPKQOSKHNE"]};
function Help() {
windowOpenForeground('../doc/armt_tbrapp_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"TFQVKXQXHO","name":"D2022"});
GetLayerID.Layers.push({"id":"PBZPZCASCW","name":"DBase"});
function DeclareWVs() {
var a = arguments;
w_IMP12022=a[0];
w_IMP22022=a[1];
w_IMP32022=a[2];
w_IMP42022=a[3];
w_IMP52022=a[4];
w_IMP62022=a[5];
w_IDBASE=a[6];
w_CODICE=a[7];
w_DESCRI=a[8];
w_NOTE=a[9];
w_IMP1=a[10];
w_IMP2=a[11];
w_IMP3=a[12];
w_IMP4=a[13];
w_IMP5=a[14];
w_IMP6=a[15];
m_PrimaryKeys=['IDBASE'];
}
function i_PrimaryKey() {
return 'tbrapp'+'\\'+CPLib.ToCPStr(w_IDBASE);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_tbrapp',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
}
_Obli('IMP12022',0,'QPKQOSKHNE',false,"1991862090")
_Obli('IMP22022',0,'UXHOBDXZYD',false,"1991862091")
_Obli('IMP32022',0,'SGYPEZIWSO',false,"1991862092")
_Obli('IMP42022',0,'PWLMWGXLJT',false,"1991862093")
_Obli('IMP52022',0,'RRLCWIMLZS',false,"728551511")
_Obli('IMP62022',0,'MFEVNPBTPC',false,"11748287033")
_Obli('CODICE',0,'ADJOBBEXVH',false,"112851763")
_Obli('IMP2',0,'CJNBNYNUXU',false,"1991862090")
_Obli('DESCRI',0,'ZERUEFFPAN',false,"285808099")
_Obli('NOTE',0,'NHIBLOVEPP',false,"10593486746")
_Obli('IMP1',0,'ISRIBATOWG',false,"1991862090")
_Obli('IMP4',0,'QVCQRBWCAT',false,"1991862093")
_Obli('IMP3',0,'GHRZZISGXZ',false,"1991862092")
_Obli('IMP5',0,'VWCEDYCYHE',false,"728551511")
_Obli('IMP6',0,'JZHAQSZZBZ',false,"11748287033")
