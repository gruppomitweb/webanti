function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('BUQHTQZEWF',function(){return WtH(w_CPCODMAG,'C',5,0,'')},w_CPCODMAG);
SPBOUILib.SetInputValue('PUGRYTGEHQ',function(){return WtH(w_CPCODAJW,'C',9,0,'')},w_CPCODAJW);
SPBOUILib.SetInputValue('FFNWZCKHDB',function(){return WtH(w_CPRAGSOC,'C',30,0,'')},w_CPRAGSOC);
SPBOUILib.SetInputValue('VAFIDWPHCA',function(){return WtH(w_CPDOMICI,'C',40,0,'')},w_CPDOMICI);
SPBOUILib.SetInputValue('PHXZPOWUHE',function(){return WtH(w_CP_CITTA,'C',30,0,'')},w_CP_CITTA);
SPBOUILib.SetInputValue('XPYTVNWCHO',function(){return WtH(w_CPERR_01,'C',60,0,'')},w_CPERR_01);
SPBOUILib.SetInputValue('VFFCZHRBSV',function(){return WtH(w_CPERR_02,'C',60,0,'')},w_CPERR_02);
SPBOUILib.SetInputValue('YFVSZTUKFJ',function(){return WtH(w_CPERR_03,'C',60,0,'')},w_CPERR_03);
SPBOUILib.SetInputValue('FBLLPINCSQ',function(){return WtH(w_CPERR_04,'C',60,0,'')},w_CPERR_04);
SPBOUILib.SetInputValue('NREHZLHXUK',function(){return WtH(w_CPERR_05,'C',60,0,'')},w_CPERR_05);
SPBOUILib.SetInputValue('WMBIMGHLXA',function(){return WtH(w_CPERR_06,'C',60,0,'')},w_CPERR_06);
SPBOUILib.SetInputValue('MUIQATNACU',function(){return WtH(w_CPERR_07,'C',60,0,'')},w_CPERR_07);
SPBOUILib.SetInputValue('MCFYJRFQLY',function(){return WtH(w_CPERR_08,'C',60,0,'')},w_CPERR_08);
SPBOUILib.SetInputValue('FVWFZMVAXM',function(){return WtH(w_CPERR_09,'C',60,0,'')},w_CPERR_09);
SPBOUILib.SetInputValue('FBNHYNDMJM',function(){return WtH(w_CPERR_10,'C',60,0,'')},w_CPERR_10);
SPBOUILib.SetInputValue('UPIBHMCFWQ',function(){return WtH(w_CPFLGCOR,'C',1,0,'')},w_CPFLGCOR);
SPBOUILib.SetInputValue('VQBNKYNPCH',function(){return WtH(w_CPFLGFOR,'C',1,0,'')},w_CPFLGFOR);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CPCODAJW"]=['RLMKMBMYWN'];
HideUI.lblids["CPCODMAG"]=['FGJGISOCRH'];
HideUI.lblids["CPDOMICI"]=['XVALWRRSQW'];
HideUI.lblids["CPERR_01"]=['FUFCACTQCQ'];
HideUI.lblids["CPERR_02"]=['WVGTEDJQXS'];
HideUI.lblids["CPERR_03"]=['GNJKEPAFQG'];
HideUI.lblids["CPERR_04"]=['MYIBJOKLHM'];
HideUI.lblids["CPERR_05"]=['RONDZMRNWA'];
HideUI.lblids["CPERR_06"]=['TOTPAIZNJM'];
HideUI.lblids["CPERR_07"]=['IENYFAVPAY'];
HideUI.lblids["CPERR_08"]=['RLVBRMKVLK'];
HideUI.lblids["CPERR_09"]=['UDNLAIKCZT'];
HideUI.lblids["CPERR_10"]=['URAFRLWJGA'];
HideUI.lblids["CPFLGCOR"]=['TLSSWSIGYB'];
HideUI.lblids["CPFLGFOR"]=['NKHUJTBNTZ'];
HideUI.lblids["CPRAGSOC"]=['UUZFJIKNDH'];
HideUI.lblids["CP_CITTA"]=['FBJUZQYAYI'];
function BUQHTQZEWF_Valid(e) {
SetActiveField(Ctrl('BUQHTQZEWF'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('BUQHTQZEWF') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CPCODMAG','C',w_CPCODMAG,HtW(Ctrl('BUQHTQZEWF').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPCODMAG(HtW(Ctrl('BUQHTQZEWF').value,'C'),null,e);
return l_bSetResult;
}
}
function BUQHTQZEWF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BUQHTQZEWF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BUQHTQZEWF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BUQHTQZEWF'),e);
}
function PUGRYTGEHQ_Valid(e) {
SetActiveField(Ctrl('PUGRYTGEHQ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('PUGRYTGEHQ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CPCODAJW','C',w_CPCODAJW,HtW(Ctrl('PUGRYTGEHQ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPCODAJW(HtW(Ctrl('PUGRYTGEHQ').value,'C'),null,e);
return l_bSetResult;
}
}
function PUGRYTGEHQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PUGRYTGEHQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PUGRYTGEHQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PUGRYTGEHQ'),e);
}
function FFNWZCKHDB_Valid(e) {
SetActiveField(Ctrl('FFNWZCKHDB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPRAGSOC','C',w_CPRAGSOC,HtW(Ctrl('FFNWZCKHDB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPRAGSOC(HtW(Ctrl('FFNWZCKHDB').value,'C'),null,e);
return l_bSetResult;
}
}
function FFNWZCKHDB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FFNWZCKHDB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FFNWZCKHDB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FFNWZCKHDB'),e);
}
function VAFIDWPHCA_Valid(e) {
SetActiveField(Ctrl('VAFIDWPHCA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPDOMICI','C',w_CPDOMICI,HtW(Ctrl('VAFIDWPHCA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPDOMICI(HtW(Ctrl('VAFIDWPHCA').value,'C'),null,e);
return l_bSetResult;
}
}
function VAFIDWPHCA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VAFIDWPHCA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VAFIDWPHCA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VAFIDWPHCA'),e);
}
function PHXZPOWUHE_Valid(e) {
SetActiveField(Ctrl('PHXZPOWUHE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CP_CITTA','C',w_CP_CITTA,HtW(Ctrl('PHXZPOWUHE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CP_CITTA(HtW(Ctrl('PHXZPOWUHE').value,'C'),null,e);
return l_bSetResult;
}
}
function PHXZPOWUHE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PHXZPOWUHE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PHXZPOWUHE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PHXZPOWUHE'),e);
}
function XPYTVNWCHO_Valid(e) {
SetActiveField(Ctrl('XPYTVNWCHO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_01','C',w_CPERR_01,HtW(Ctrl('XPYTVNWCHO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_01(HtW(Ctrl('XPYTVNWCHO').value,'C'),null,e);
return l_bSetResult;
}
}
function XPYTVNWCHO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XPYTVNWCHO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XPYTVNWCHO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XPYTVNWCHO'),e);
}
function VFFCZHRBSV_Valid(e) {
SetActiveField(Ctrl('VFFCZHRBSV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_02','C',w_CPERR_02,HtW(Ctrl('VFFCZHRBSV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_02(HtW(Ctrl('VFFCZHRBSV').value,'C'),null,e);
return l_bSetResult;
}
}
function VFFCZHRBSV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VFFCZHRBSV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VFFCZHRBSV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VFFCZHRBSV'),e);
}
function YFVSZTUKFJ_Valid(e) {
SetActiveField(Ctrl('YFVSZTUKFJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_03','C',w_CPERR_03,HtW(Ctrl('YFVSZTUKFJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_03(HtW(Ctrl('YFVSZTUKFJ').value,'C'),null,e);
return l_bSetResult;
}
}
function YFVSZTUKFJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YFVSZTUKFJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YFVSZTUKFJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YFVSZTUKFJ'),e);
}
function FBLLPINCSQ_Valid(e) {
SetActiveField(Ctrl('FBLLPINCSQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_04','C',w_CPERR_04,HtW(Ctrl('FBLLPINCSQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_04(HtW(Ctrl('FBLLPINCSQ').value,'C'),null,e);
return l_bSetResult;
}
}
function FBLLPINCSQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBLLPINCSQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBLLPINCSQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBLLPINCSQ'),e);
}
function NREHZLHXUK_Valid(e) {
SetActiveField(Ctrl('NREHZLHXUK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_05','C',w_CPERR_05,HtW(Ctrl('NREHZLHXUK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_05(HtW(Ctrl('NREHZLHXUK').value,'C'),null,e);
return l_bSetResult;
}
}
function NREHZLHXUK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NREHZLHXUK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NREHZLHXUK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NREHZLHXUK'),e);
}
function WMBIMGHLXA_Valid(e) {
SetActiveField(Ctrl('WMBIMGHLXA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_06','C',w_CPERR_06,HtW(Ctrl('WMBIMGHLXA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_06(HtW(Ctrl('WMBIMGHLXA').value,'C'),null,e);
return l_bSetResult;
}
}
function WMBIMGHLXA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WMBIMGHLXA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WMBIMGHLXA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WMBIMGHLXA'),e);
}
function MUIQATNACU_Valid(e) {
SetActiveField(Ctrl('MUIQATNACU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_07','C',w_CPERR_07,HtW(Ctrl('MUIQATNACU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_07(HtW(Ctrl('MUIQATNACU').value,'C'),null,e);
return l_bSetResult;
}
}
function MUIQATNACU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MUIQATNACU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MUIQATNACU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MUIQATNACU'),e);
}
function MCFYJRFQLY_Valid(e) {
SetActiveField(Ctrl('MCFYJRFQLY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_08','C',w_CPERR_08,HtW(Ctrl('MCFYJRFQLY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_08(HtW(Ctrl('MCFYJRFQLY').value,'C'),null,e);
return l_bSetResult;
}
}
function MCFYJRFQLY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MCFYJRFQLY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MCFYJRFQLY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MCFYJRFQLY'),e);
}
function FVWFZMVAXM_Valid(e) {
SetActiveField(Ctrl('FVWFZMVAXM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_09','C',w_CPERR_09,HtW(Ctrl('FVWFZMVAXM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_09(HtW(Ctrl('FVWFZMVAXM').value,'C'),null,e);
return l_bSetResult;
}
}
function FVWFZMVAXM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FVWFZMVAXM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FVWFZMVAXM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FVWFZMVAXM'),e);
}
function FBNHYNDMJM_Valid(e) {
SetActiveField(Ctrl('FBNHYNDMJM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPERR_10','C',w_CPERR_10,HtW(Ctrl('FBNHYNDMJM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPERR_10(HtW(Ctrl('FBNHYNDMJM').value,'C'),null,e);
return l_bSetResult;
}
}
function FBNHYNDMJM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FBNHYNDMJM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FBNHYNDMJM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FBNHYNDMJM'),e);
}
function UPIBHMCFWQ_Valid(e) {
SetActiveField(Ctrl('UPIBHMCFWQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPFLGCOR','C',w_CPFLGCOR,HtW(Ctrl('UPIBHMCFWQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPFLGCOR(HtW(Ctrl('UPIBHMCFWQ').value,'C'),null,e);
return l_bSetResult;
}
}
function UPIBHMCFWQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UPIBHMCFWQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UPIBHMCFWQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UPIBHMCFWQ'),e);
}
function VQBNKYNPCH_Valid(e) {
SetActiveField(Ctrl('VQBNKYNPCH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CPFLGFOR','C',w_CPFLGFOR,HtW(Ctrl('VQBNKYNPCH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CPFLGFOR(HtW(Ctrl('VQBNKYNPCH').value,'C'),null,e);
return l_bSetResult;
}
}
function VQBNKYNPCH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VQBNKYNPCH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VQBNKYNPCH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VQBNKYNPCH'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function BUQHTQZEWF_wrap_Valid(event) {
return BUQHTQZEWF_Valid(event);
}
SPBOUILib.SetInputExit('BUQHTQZEWF',BUQHTQZEWF_wrap_Valid);
function BUQHTQZEWF_wrap_OnFocus(event) {
return BUQHTQZEWF_OnFocus(event);
}
SPBOUILib.SetInputEnter('BUQHTQZEWF',BUQHTQZEWF_wrap_OnFocus);
function BUQHTQZEWF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BUQHTQZEWF',BUQHTQZEWF_wrap_OnKeyDown);
function PUGRYTGEHQ_wrap_Valid(event) {
return PUGRYTGEHQ_Valid(event);
}
SPBOUILib.SetInputExit('PUGRYTGEHQ',PUGRYTGEHQ_wrap_Valid);
function PUGRYTGEHQ_wrap_OnFocus(event) {
return PUGRYTGEHQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('PUGRYTGEHQ',PUGRYTGEHQ_wrap_OnFocus);
function PUGRYTGEHQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PUGRYTGEHQ',PUGRYTGEHQ_wrap_OnKeyDown);
function FFNWZCKHDB_wrap_Valid(event) {
return FFNWZCKHDB_Valid(event);
}
SPBOUILib.SetInputExit('FFNWZCKHDB',FFNWZCKHDB_wrap_Valid);
function FFNWZCKHDB_wrap_OnFocus(event) {
return FFNWZCKHDB_OnFocus(event);
}
SPBOUILib.SetInputEnter('FFNWZCKHDB',FFNWZCKHDB_wrap_OnFocus);
function FFNWZCKHDB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FFNWZCKHDB',FFNWZCKHDB_wrap_OnKeyDown);
function VAFIDWPHCA_wrap_Valid(event) {
return VAFIDWPHCA_Valid(event);
}
SPBOUILib.SetInputExit('VAFIDWPHCA',VAFIDWPHCA_wrap_Valid);
function VAFIDWPHCA_wrap_OnFocus(event) {
return VAFIDWPHCA_OnFocus(event);
}
SPBOUILib.SetInputEnter('VAFIDWPHCA',VAFIDWPHCA_wrap_OnFocus);
function VAFIDWPHCA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VAFIDWPHCA',VAFIDWPHCA_wrap_OnKeyDown);
function PHXZPOWUHE_wrap_Valid(event) {
return PHXZPOWUHE_Valid(event);
}
SPBOUILib.SetInputExit('PHXZPOWUHE',PHXZPOWUHE_wrap_Valid);
function PHXZPOWUHE_wrap_OnFocus(event) {
return PHXZPOWUHE_OnFocus(event);
}
SPBOUILib.SetInputEnter('PHXZPOWUHE',PHXZPOWUHE_wrap_OnFocus);
function PHXZPOWUHE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PHXZPOWUHE',PHXZPOWUHE_wrap_OnKeyDown);
function XPYTVNWCHO_wrap_Valid(event) {
return XPYTVNWCHO_Valid(event);
}
SPBOUILib.SetInputExit('XPYTVNWCHO',XPYTVNWCHO_wrap_Valid);
function XPYTVNWCHO_wrap_OnFocus(event) {
return XPYTVNWCHO_OnFocus(event);
}
SPBOUILib.SetInputEnter('XPYTVNWCHO',XPYTVNWCHO_wrap_OnFocus);
function XPYTVNWCHO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XPYTVNWCHO',XPYTVNWCHO_wrap_OnKeyDown);
function VFFCZHRBSV_wrap_Valid(event) {
return VFFCZHRBSV_Valid(event);
}
SPBOUILib.SetInputExit('VFFCZHRBSV',VFFCZHRBSV_wrap_Valid);
function VFFCZHRBSV_wrap_OnFocus(event) {
return VFFCZHRBSV_OnFocus(event);
}
SPBOUILib.SetInputEnter('VFFCZHRBSV',VFFCZHRBSV_wrap_OnFocus);
function VFFCZHRBSV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VFFCZHRBSV',VFFCZHRBSV_wrap_OnKeyDown);
function YFVSZTUKFJ_wrap_Valid(event) {
return YFVSZTUKFJ_Valid(event);
}
SPBOUILib.SetInputExit('YFVSZTUKFJ',YFVSZTUKFJ_wrap_Valid);
function YFVSZTUKFJ_wrap_OnFocus(event) {
return YFVSZTUKFJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('YFVSZTUKFJ',YFVSZTUKFJ_wrap_OnFocus);
function YFVSZTUKFJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YFVSZTUKFJ',YFVSZTUKFJ_wrap_OnKeyDown);
function FBLLPINCSQ_wrap_Valid(event) {
return FBLLPINCSQ_Valid(event);
}
SPBOUILib.SetInputExit('FBLLPINCSQ',FBLLPINCSQ_wrap_Valid);
function FBLLPINCSQ_wrap_OnFocus(event) {
return FBLLPINCSQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('FBLLPINCSQ',FBLLPINCSQ_wrap_OnFocus);
function FBLLPINCSQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FBLLPINCSQ',FBLLPINCSQ_wrap_OnKeyDown);
function NREHZLHXUK_wrap_Valid(event) {
return NREHZLHXUK_Valid(event);
}
SPBOUILib.SetInputExit('NREHZLHXUK',NREHZLHXUK_wrap_Valid);
function NREHZLHXUK_wrap_OnFocus(event) {
return NREHZLHXUK_OnFocus(event);
}
SPBOUILib.SetInputEnter('NREHZLHXUK',NREHZLHXUK_wrap_OnFocus);
function NREHZLHXUK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NREHZLHXUK',NREHZLHXUK_wrap_OnKeyDown);
function WMBIMGHLXA_wrap_Valid(event) {
return WMBIMGHLXA_Valid(event);
}
SPBOUILib.SetInputExit('WMBIMGHLXA',WMBIMGHLXA_wrap_Valid);
function WMBIMGHLXA_wrap_OnFocus(event) {
return WMBIMGHLXA_OnFocus(event);
}
SPBOUILib.SetInputEnter('WMBIMGHLXA',WMBIMGHLXA_wrap_OnFocus);
function WMBIMGHLXA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WMBIMGHLXA',WMBIMGHLXA_wrap_OnKeyDown);
function MUIQATNACU_wrap_Valid(event) {
return MUIQATNACU_Valid(event);
}
SPBOUILib.SetInputExit('MUIQATNACU',MUIQATNACU_wrap_Valid);
function MUIQATNACU_wrap_OnFocus(event) {
return MUIQATNACU_OnFocus(event);
}
SPBOUILib.SetInputEnter('MUIQATNACU',MUIQATNACU_wrap_OnFocus);
function MUIQATNACU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MUIQATNACU',MUIQATNACU_wrap_OnKeyDown);
function MCFYJRFQLY_wrap_Valid(event) {
return MCFYJRFQLY_Valid(event);
}
SPBOUILib.SetInputExit('MCFYJRFQLY',MCFYJRFQLY_wrap_Valid);
function MCFYJRFQLY_wrap_OnFocus(event) {
return MCFYJRFQLY_OnFocus(event);
}
SPBOUILib.SetInputEnter('MCFYJRFQLY',MCFYJRFQLY_wrap_OnFocus);
function MCFYJRFQLY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MCFYJRFQLY',MCFYJRFQLY_wrap_OnKeyDown);
function FVWFZMVAXM_wrap_Valid(event) {
return FVWFZMVAXM_Valid(event);
}
SPBOUILib.SetInputExit('FVWFZMVAXM',FVWFZMVAXM_wrap_Valid);
function FVWFZMVAXM_wrap_OnFocus(event) {
return FVWFZMVAXM_OnFocus(event);
}
SPBOUILib.SetInputEnter('FVWFZMVAXM',FVWFZMVAXM_wrap_OnFocus);
function FVWFZMVAXM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FVWFZMVAXM',FVWFZMVAXM_wrap_OnKeyDown);
function FBNHYNDMJM_wrap_Valid(event) {
return FBNHYNDMJM_Valid(event);
}
SPBOUILib.SetInputExit('FBNHYNDMJM',FBNHYNDMJM_wrap_Valid);
function FBNHYNDMJM_wrap_OnFocus(event) {
return FBNHYNDMJM_OnFocus(event);
}
SPBOUILib.SetInputEnter('FBNHYNDMJM',FBNHYNDMJM_wrap_OnFocus);
function FBNHYNDMJM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FBNHYNDMJM',FBNHYNDMJM_wrap_OnKeyDown);
function UPIBHMCFWQ_wrap_Valid(event) {
return UPIBHMCFWQ_Valid(event);
}
SPBOUILib.SetInputExit('UPIBHMCFWQ',UPIBHMCFWQ_wrap_Valid);
function UPIBHMCFWQ_wrap_OnFocus(event) {
return UPIBHMCFWQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('UPIBHMCFWQ',UPIBHMCFWQ_wrap_OnFocus);
function UPIBHMCFWQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UPIBHMCFWQ',UPIBHMCFWQ_wrap_OnKeyDown);
function VQBNKYNPCH_wrap_Valid(event) {
return VQBNKYNPCH_Valid(event);
}
SPBOUILib.SetInputExit('VQBNKYNPCH',VQBNKYNPCH_wrap_Valid);
function VQBNKYNPCH_wrap_OnFocus(event) {
return VQBNKYNPCH_OnFocus(event);
}
SPBOUILib.SetInputEnter('VQBNKYNPCH',VQBNKYNPCH_wrap_OnFocus);
function VQBNKYNPCH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VQBNKYNPCH',VQBNKYNPCH_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["FFNWZCKHDB"]};
FocusFirstComponent.query={"page_1":["BUQHTQZEWF"]};
FocusFirstComponent.otherwise={"page_1":["BUQHTQZEWF"]};
function Help() {
windowOpenForeground('../doc/armt_wu_poschk_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CPCODMAG=a[0];
w_CPCODAJW=a[1];
w_CPRAGSOC=a[2];
w_CPDOMICI=a[3];
w_CP_CITTA=a[4];
w_CPERR_01=a[5];
w_CPERR_02=a[6];
w_CPERR_03=a[7];
w_CPERR_04=a[8];
w_CPERR_05=a[9];
w_CPERR_06=a[10];
w_CPERR_07=a[11];
w_CPERR_08=a[12];
w_CPERR_09=a[13];
w_CPERR_10=a[14];
w_CPFLGCOR=a[15];
w_CPFLGFOR=a[16];
m_PrimaryKeys=['CPCODAJW','CPCODMAG'];
}
function i_PrimaryKey() {
return 'wuposchk'+'\\'+CPLib.ToCPStr(w_CPCODMAG)+'\\'+CPLib.ToCPStr(w_CPCODAJW);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wu_poschk',m_cSelectedPage);
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
_Obli('CPCODMAG',0,'BUQHTQZEWF',false,"11309552526")
_Obli('CPCODAJW',0,'PUGRYTGEHQ',false,"1270072299")
_Obli('CPRAGSOC',0,'FFNWZCKHDB',false,"10662833243")
_Obli('CPDOMICI',0,'VAFIDWPHCA',false,"49939619")
_Obli('CP_CITTA',0,'PHXZPOWUHE',false,"15186643")
_Obli('CPERR_01',0,'XPYTVNWCHO',false,"919169381")
_Obli('CPERR_02',0,'VFFCZHRBSV',false,"1187604837")
_Obli('CPERR_03',0,'YFVSZTUKFJ',false,"1456040293")
_Obli('CPERR_04',0,'FBLLPINCSQ',false,"1724475749")
_Obli('CPERR_05',0,'NREHZLHXUK',false,"1992911205")
_Obli('CPERR_06',0,'WMBIMGHLXA',false,"12033620635")
_Obli('CPERR_07',0,'MUIQATNACU',false,"11765185179")
_Obli('CPERR_08',0,'MCFYJRFQLY',false,"11496749723")
_Obli('CPERR_09',0,'FVWFZMVAXM',false,"11228314267")
_Obli('CPERR_10',0,'FBNHYNDMJM',false,"919169429")
_Obli('CPFLGCOR',0,'UPIBHMCFWQ',false,"11816161592")
_Obli('CPFLGFOR',0,'VQBNKYNPCH',false,"11710185840")
