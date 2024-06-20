function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('NSUYYWAOJV',function(){return WtH(w_IDAMLANNO,'C',4,0,'')},w_IDAMLANNO);
} else {
SPBOUILib.SetInputValue('NSUYYWAOJV',function(){return WtH(w_IDAMLANNO,'C',4,0,'')},w_IDAMLANNO);
SPBOUILib.SetInputValue('UASFCHXLRC',function(){return WtH(w_IDBASE,'C',10,0,'')},w_IDBASE);
SPBOUILib.SetInputValue('AFSDOMRNZC',function(){return WtH(w_LIV1,'C',3,0,'')},w_LIV1);
SPBOUILib.SetInputValue('LMBDWDWYOJ',function(){return WtH(w_LIV2,'C',3,0,'')},w_LIV2);
SPBOUILib.SetInputValue('OUCAYORICR',function(){return WtH(w_LIV3,'C',3,0,'')},w_LIV3);
SPBOUILib.SetInputValue('WFEQRDUEHK',function(){return WtH(w_N1,'N',15,2,'999999999999.99')},w_N1);
SPBOUILib.SetInputValue('AXLQDUTMKE',function(){return WtH(w_N2,'N',15,2,'999999999999.99')},w_N2);
SPBOUILib.SetInputValue('UQEGOTONHO',function(){return WtH(w_N3,'N',15,2,'999999999999.99')},w_N3);
SPBOUILib.SetInputValue('VLPHUFHRWG',function(){return WtH(w_N4,'N',15,2,'999999999999.99')},w_N4);
SPBOUILib.SetInputValue('RNANYATLJA',function(){return WtH(w_N5,'N',15,2,'999999999999.99')},w_N5);
SPBOUILib.SetInputValue('FGZMGIETJK',function(){return WtH(w_N6,'N',15,2,'999999999999.99')},w_N6);
SPBOUILib.SetInputValue('TTSVMTXSHK',function(){return WtH(w_N7,'N',15,2,'999999999999.99')},w_N7);
SPBOUILib.SetInputValue('BCQNNDGTFP',function(){return WtH(w_C1,'C',100,0,'')},w_C1);
SPBOUILib.SetInputValue('YQPUAGHCIC',function(){return WtH(w_C2,'C',100,0,'')},w_C2);
SPBOUILib.SetInputValue('VBELTUYZHN',function(){return WtH(w_C3,'C',100,0,'')},w_C3);
SPBOUILib.SetInputValue('BYRSYJQNCL',function(){return WtH(w_C4,'C',100,0,'')},w_C4);
SPBOUILib.SetInputValue('PCMHVKTTLL',function(){return WtH(w_C5,'C',100,0,'')},w_C5);
SPBOUILib.SetInputValue('RTBHNLUHZE',function(){return WtH(w_C6,'C',100,0,'')},w_C6);
SPBOUILib.SetInputValue('SWIJFJKKLJ',function(){return WtH(w_C7,'C',100,0,'')},w_C7);
SPBOUILib.SetInputValue('OIVQOXTGIZ',function(){return WtH(w_BOX,'M',10,0,'')},w_BOX);
}
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
HideUI.lblids["IDAMLANNO"]=['KOCAYKNGCM'];
function NSUYYWAOJV_Valid(e) {
SetActiveField(Ctrl('NSUYYWAOJV'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('NSUYYWAOJV') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('IDAMLANNO','C',w_IDAMLANNO,HtW(Ctrl('NSUYYWAOJV').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDAMLANNO(HtW(Ctrl('NSUYYWAOJV').value,'C'),null,e);
return l_bSetResult;
}
}
function NSUYYWAOJV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NSUYYWAOJV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NSUYYWAOJV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NSUYYWAOJV'),e);
}
function UASFCHXLRC_Valid(e) {
SetActiveField(Ctrl('UASFCHXLRC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDBASE','C',w_IDBASE,HtW(Ctrl('UASFCHXLRC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDBASE(HtW(Ctrl('UASFCHXLRC').value,'C'),null,e);
return l_bSetResult;
}
}
function UASFCHXLRC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UASFCHXLRC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UASFCHXLRC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UASFCHXLRC'),e);
}
function AFSDOMRNZC_Valid(e) {
SetActiveField(Ctrl('AFSDOMRNZC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIV1','C',w_LIV1,HtW(Ctrl('AFSDOMRNZC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIV1(HtW(Ctrl('AFSDOMRNZC').value,'C'),null,e);
return l_bSetResult;
}
}
function AFSDOMRNZC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AFSDOMRNZC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AFSDOMRNZC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AFSDOMRNZC'),e);
}
function LMBDWDWYOJ_Valid(e) {
SetActiveField(Ctrl('LMBDWDWYOJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIV2','C',w_LIV2,HtW(Ctrl('LMBDWDWYOJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIV2(HtW(Ctrl('LMBDWDWYOJ').value,'C'),null,e);
return l_bSetResult;
}
}
function LMBDWDWYOJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LMBDWDWYOJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LMBDWDWYOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LMBDWDWYOJ'),e);
}
function OUCAYORICR_Valid(e) {
SetActiveField(Ctrl('OUCAYORICR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('LIV3','C',w_LIV3,HtW(Ctrl('OUCAYORICR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_LIV3(HtW(Ctrl('OUCAYORICR').value,'C'),null,e);
return l_bSetResult;
}
}
function OUCAYORICR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OUCAYORICR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OUCAYORICR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OUCAYORICR'),e);
}
function WFEQRDUEHK_Valid(e) {
SetActiveField(Ctrl('WFEQRDUEHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N1','N',w_N1,HtW(Ctrl('WFEQRDUEHK').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N1(HtW(Ctrl('WFEQRDUEHK').value,'N'),null,e);
return l_bSetResult;
}
}
function WFEQRDUEHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WFEQRDUEHK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WFEQRDUEHK',w_N1,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('WFEQRDUEHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WFEQRDUEHK'),e);
}
function WFEQRDUEHK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function AXLQDUTMKE_Valid(e) {
SetActiveField(Ctrl('AXLQDUTMKE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N2','N',w_N2,HtW(Ctrl('AXLQDUTMKE').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N2(HtW(Ctrl('AXLQDUTMKE').value,'N'),null,e);
return l_bSetResult;
}
}
function AXLQDUTMKE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AXLQDUTMKE'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AXLQDUTMKE',w_N2,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('AXLQDUTMKE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AXLQDUTMKE'),e);
}
function AXLQDUTMKE_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function UQEGOTONHO_Valid(e) {
SetActiveField(Ctrl('UQEGOTONHO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N3','N',w_N3,HtW(Ctrl('UQEGOTONHO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N3(HtW(Ctrl('UQEGOTONHO').value,'N'),null,e);
return l_bSetResult;
}
}
function UQEGOTONHO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UQEGOTONHO'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('UQEGOTONHO',w_N3,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('UQEGOTONHO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UQEGOTONHO'),e);
}
function UQEGOTONHO_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function VLPHUFHRWG_Valid(e) {
SetActiveField(Ctrl('VLPHUFHRWG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N4','N',w_N4,HtW(Ctrl('VLPHUFHRWG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N4(HtW(Ctrl('VLPHUFHRWG').value,'N'),null,e);
return l_bSetResult;
}
}
function VLPHUFHRWG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VLPHUFHRWG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('VLPHUFHRWG',w_N4,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('VLPHUFHRWG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VLPHUFHRWG'),e);
}
function VLPHUFHRWG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function RNANYATLJA_Valid(e) {
SetActiveField(Ctrl('RNANYATLJA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N5','N',w_N5,HtW(Ctrl('RNANYATLJA').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N5(HtW(Ctrl('RNANYATLJA').value,'N'),null,e);
return l_bSetResult;
}
}
function RNANYATLJA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RNANYATLJA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('RNANYATLJA',w_N5,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('RNANYATLJA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RNANYATLJA'),e);
}
function RNANYATLJA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function FGZMGIETJK_Valid(e) {
SetActiveField(Ctrl('FGZMGIETJK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N6','N',w_N6,HtW(Ctrl('FGZMGIETJK').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N6(HtW(Ctrl('FGZMGIETJK').value,'N'),null,e);
return l_bSetResult;
}
}
function FGZMGIETJK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FGZMGIETJK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('FGZMGIETJK',w_N6,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('FGZMGIETJK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FGZMGIETJK'),e);
}
function FGZMGIETJK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function TTSVMTXSHK_Valid(e) {
SetActiveField(Ctrl('TTSVMTXSHK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('N7','N',w_N7,HtW(Ctrl('TTSVMTXSHK').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_N7(HtW(Ctrl('TTSVMTXSHK').value,'N'),null,e);
return l_bSetResult;
}
}
function TTSVMTXSHK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TTSVMTXSHK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('TTSVMTXSHK',w_N7,'N',15,2,'999999999999.99');
SetActiveField(Ctrl('TTSVMTXSHK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TTSVMTXSHK'),e);
}
function TTSVMTXSHK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999.99"));
}
function BCQNNDGTFP_Valid(e) {
SetActiveField(Ctrl('BCQNNDGTFP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C1','C',w_C1,HtW(Ctrl('BCQNNDGTFP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C1(HtW(Ctrl('BCQNNDGTFP').value,'C'),null,e);
return l_bSetResult;
}
}
function BCQNNDGTFP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BCQNNDGTFP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BCQNNDGTFP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BCQNNDGTFP'),e);
}
function YQPUAGHCIC_Valid(e) {
SetActiveField(Ctrl('YQPUAGHCIC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C2','C',w_C2,HtW(Ctrl('YQPUAGHCIC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C2(HtW(Ctrl('YQPUAGHCIC').value,'C'),null,e);
return l_bSetResult;
}
}
function YQPUAGHCIC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YQPUAGHCIC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YQPUAGHCIC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YQPUAGHCIC'),e);
}
function VBELTUYZHN_Valid(e) {
SetActiveField(Ctrl('VBELTUYZHN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C3','C',w_C3,HtW(Ctrl('VBELTUYZHN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C3(HtW(Ctrl('VBELTUYZHN').value,'C'),null,e);
return l_bSetResult;
}
}
function VBELTUYZHN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VBELTUYZHN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VBELTUYZHN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VBELTUYZHN'),e);
}
function BYRSYJQNCL_Valid(e) {
SetActiveField(Ctrl('BYRSYJQNCL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C4','C',w_C4,HtW(Ctrl('BYRSYJQNCL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C4(HtW(Ctrl('BYRSYJQNCL').value,'C'),null,e);
return l_bSetResult;
}
}
function BYRSYJQNCL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYRSYJQNCL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BYRSYJQNCL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYRSYJQNCL'),e);
}
function PCMHVKTTLL_Valid(e) {
SetActiveField(Ctrl('PCMHVKTTLL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C5','C',w_C5,HtW(Ctrl('PCMHVKTTLL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C5(HtW(Ctrl('PCMHVKTTLL').value,'C'),null,e);
return l_bSetResult;
}
}
function PCMHVKTTLL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PCMHVKTTLL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PCMHVKTTLL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PCMHVKTTLL'),e);
}
function RTBHNLUHZE_Valid(e) {
SetActiveField(Ctrl('RTBHNLUHZE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C6','C',w_C6,HtW(Ctrl('RTBHNLUHZE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C6(HtW(Ctrl('RTBHNLUHZE').value,'C'),null,e);
return l_bSetResult;
}
}
function RTBHNLUHZE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RTBHNLUHZE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RTBHNLUHZE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RTBHNLUHZE'),e);
}
function SWIJFJKKLJ_Valid(e) {
SetActiveField(Ctrl('SWIJFJKKLJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('C7','C',w_C7,HtW(Ctrl('SWIJFJKKLJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_C7(HtW(Ctrl('SWIJFJKKLJ').value,'C'),null,e);
return l_bSetResult;
}
}
function SWIJFJKKLJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SWIJFJKKLJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SWIJFJKKLJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SWIJFJKKLJ'),e);
}
function OIVQOXTGIZ_Valid(e) {
SetActiveField(Ctrl('OIVQOXTGIZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BOX','M',w_BOX,HtW(Ctrl('OIVQOXTGIZ').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BOX(HtW(Ctrl('OIVQOXTGIZ').value,'M'),null,e);
return l_bSetResult;
}
}
function OIVQOXTGIZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OIVQOXTGIZ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OIVQOXTGIZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OIVQOXTGIZ'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function NSUYYWAOJV_wrap_Valid(event) {
return NSUYYWAOJV_Valid(event);
}
SPBOUILib.SetInputExit('NSUYYWAOJV',NSUYYWAOJV_wrap_Valid);
function NSUYYWAOJV_wrap_OnFocus(event) {
return NSUYYWAOJV_OnFocus(event);
}
SPBOUILib.SetInputEnter('NSUYYWAOJV',NSUYYWAOJV_wrap_OnFocus);
function NSUYYWAOJV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NSUYYWAOJV',NSUYYWAOJV_wrap_OnKeyDown);
function UASFCHXLRC_wrap_Valid(event) {
return UASFCHXLRC_Valid(event);
}
SPBOUILib.SetInputExit('UASFCHXLRC',UASFCHXLRC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function UASFCHXLRC_wrap_OnFocus(event) {
return UASFCHXLRC_OnFocus(event);
}
SPBOUILib.SetInputEnter('UASFCHXLRC',UASFCHXLRC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function UASFCHXLRC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UASFCHXLRC',UASFCHXLRC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AFSDOMRNZC_wrap_Valid(event) {
return AFSDOMRNZC_Valid(event);
}
SPBOUILib.SetInputExit('AFSDOMRNZC',AFSDOMRNZC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AFSDOMRNZC_wrap_OnFocus(event) {
return AFSDOMRNZC_OnFocus(event);
}
SPBOUILib.SetInputEnter('AFSDOMRNZC',AFSDOMRNZC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AFSDOMRNZC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AFSDOMRNZC',AFSDOMRNZC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function LMBDWDWYOJ_wrap_Valid(event) {
return LMBDWDWYOJ_Valid(event);
}
SPBOUILib.SetInputExit('LMBDWDWYOJ',LMBDWDWYOJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function LMBDWDWYOJ_wrap_OnFocus(event) {
return LMBDWDWYOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LMBDWDWYOJ',LMBDWDWYOJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function LMBDWDWYOJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LMBDWDWYOJ',LMBDWDWYOJ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function OUCAYORICR_wrap_Valid(event) {
return OUCAYORICR_Valid(event);
}
SPBOUILib.SetInputExit('OUCAYORICR',OUCAYORICR_wrap_Valid,SPBOUILib.Row.IN_GRID);
function OUCAYORICR_wrap_OnFocus(event) {
return OUCAYORICR_OnFocus(event);
}
SPBOUILib.SetInputEnter('OUCAYORICR',OUCAYORICR_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function OUCAYORICR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OUCAYORICR',OUCAYORICR_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function WFEQRDUEHK_wrap_Valid(event) {
return WFEQRDUEHK_Valid(event);
}
SPBOUILib.SetInputExit('WFEQRDUEHK',WFEQRDUEHK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function WFEQRDUEHK_wrap_OnFocus(event) {
return WFEQRDUEHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('WFEQRDUEHK',WFEQRDUEHK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function WFEQRDUEHK_wrap_OnKeyPress(event) {
return WFEQRDUEHK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('WFEQRDUEHK',WFEQRDUEHK_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function WFEQRDUEHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WFEQRDUEHK',WFEQRDUEHK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function AXLQDUTMKE_wrap_Valid(event) {
return AXLQDUTMKE_Valid(event);
}
SPBOUILib.SetInputExit('AXLQDUTMKE',AXLQDUTMKE_wrap_Valid,SPBOUILib.Row.IN_GRID);
function AXLQDUTMKE_wrap_OnFocus(event) {
return AXLQDUTMKE_OnFocus(event);
}
SPBOUILib.SetInputEnter('AXLQDUTMKE',AXLQDUTMKE_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function AXLQDUTMKE_wrap_OnKeyPress(event) {
return AXLQDUTMKE_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('AXLQDUTMKE',AXLQDUTMKE_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function AXLQDUTMKE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AXLQDUTMKE',AXLQDUTMKE_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function UQEGOTONHO_wrap_Valid(event) {
return UQEGOTONHO_Valid(event);
}
SPBOUILib.SetInputExit('UQEGOTONHO',UQEGOTONHO_wrap_Valid,SPBOUILib.Row.IN_GRID);
function UQEGOTONHO_wrap_OnFocus(event) {
return UQEGOTONHO_OnFocus(event);
}
SPBOUILib.SetInputEnter('UQEGOTONHO',UQEGOTONHO_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function UQEGOTONHO_wrap_OnKeyPress(event) {
return UQEGOTONHO_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('UQEGOTONHO',UQEGOTONHO_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function UQEGOTONHO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UQEGOTONHO',UQEGOTONHO_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VLPHUFHRWG_wrap_Valid(event) {
return VLPHUFHRWG_Valid(event);
}
SPBOUILib.SetInputExit('VLPHUFHRWG',VLPHUFHRWG_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VLPHUFHRWG_wrap_OnFocus(event) {
return VLPHUFHRWG_OnFocus(event);
}
SPBOUILib.SetInputEnter('VLPHUFHRWG',VLPHUFHRWG_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VLPHUFHRWG_wrap_OnKeyPress(event) {
return VLPHUFHRWG_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('VLPHUFHRWG',VLPHUFHRWG_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function VLPHUFHRWG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VLPHUFHRWG',VLPHUFHRWG_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function RNANYATLJA_wrap_Valid(event) {
return RNANYATLJA_Valid(event);
}
SPBOUILib.SetInputExit('RNANYATLJA',RNANYATLJA_wrap_Valid,SPBOUILib.Row.IN_GRID);
function RNANYATLJA_wrap_OnFocus(event) {
return RNANYATLJA_OnFocus(event);
}
SPBOUILib.SetInputEnter('RNANYATLJA',RNANYATLJA_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function RNANYATLJA_wrap_OnKeyPress(event) {
return RNANYATLJA_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('RNANYATLJA',RNANYATLJA_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function RNANYATLJA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RNANYATLJA',RNANYATLJA_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function FGZMGIETJK_wrap_Valid(event) {
return FGZMGIETJK_Valid(event);
}
SPBOUILib.SetInputExit('FGZMGIETJK',FGZMGIETJK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function FGZMGIETJK_wrap_OnFocus(event) {
return FGZMGIETJK_OnFocus(event);
}
SPBOUILib.SetInputEnter('FGZMGIETJK',FGZMGIETJK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function FGZMGIETJK_wrap_OnKeyPress(event) {
return FGZMGIETJK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('FGZMGIETJK',FGZMGIETJK_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function FGZMGIETJK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FGZMGIETJK',FGZMGIETJK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function TTSVMTXSHK_wrap_Valid(event) {
return TTSVMTXSHK_Valid(event);
}
SPBOUILib.SetInputExit('TTSVMTXSHK',TTSVMTXSHK_wrap_Valid,SPBOUILib.Row.IN_GRID);
function TTSVMTXSHK_wrap_OnFocus(event) {
return TTSVMTXSHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('TTSVMTXSHK',TTSVMTXSHK_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function TTSVMTXSHK_wrap_OnKeyPress(event) {
return TTSVMTXSHK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('TTSVMTXSHK',TTSVMTXSHK_wrap_OnKeyPress,SPBOUILib.Row.IN_GRID);
function TTSVMTXSHK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TTSVMTXSHK',TTSVMTXSHK_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function BCQNNDGTFP_wrap_Valid(event) {
return BCQNNDGTFP_Valid(event);
}
SPBOUILib.SetInputExit('BCQNNDGTFP',BCQNNDGTFP_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BCQNNDGTFP_wrap_OnFocus(event) {
return BCQNNDGTFP_OnFocus(event);
}
SPBOUILib.SetInputEnter('BCQNNDGTFP',BCQNNDGTFP_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BCQNNDGTFP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BCQNNDGTFP',BCQNNDGTFP_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function YQPUAGHCIC_wrap_Valid(event) {
return YQPUAGHCIC_Valid(event);
}
SPBOUILib.SetInputExit('YQPUAGHCIC',YQPUAGHCIC_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YQPUAGHCIC_wrap_OnFocus(event) {
return YQPUAGHCIC_OnFocus(event);
}
SPBOUILib.SetInputEnter('YQPUAGHCIC',YQPUAGHCIC_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YQPUAGHCIC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YQPUAGHCIC',YQPUAGHCIC_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function VBELTUYZHN_wrap_Valid(event) {
return VBELTUYZHN_Valid(event);
}
SPBOUILib.SetInputExit('VBELTUYZHN',VBELTUYZHN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function VBELTUYZHN_wrap_OnFocus(event) {
return VBELTUYZHN_OnFocus(event);
}
SPBOUILib.SetInputEnter('VBELTUYZHN',VBELTUYZHN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function VBELTUYZHN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VBELTUYZHN',VBELTUYZHN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function BYRSYJQNCL_wrap_Valid(event) {
return BYRSYJQNCL_Valid(event);
}
SPBOUILib.SetInputExit('BYRSYJQNCL',BYRSYJQNCL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function BYRSYJQNCL_wrap_OnFocus(event) {
return BYRSYJQNCL_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYRSYJQNCL',BYRSYJQNCL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function BYRSYJQNCL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BYRSYJQNCL',BYRSYJQNCL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function PCMHVKTTLL_wrap_Valid(event) {
return PCMHVKTTLL_Valid(event);
}
SPBOUILib.SetInputExit('PCMHVKTTLL',PCMHVKTTLL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function PCMHVKTTLL_wrap_OnFocus(event) {
return PCMHVKTTLL_OnFocus(event);
}
SPBOUILib.SetInputEnter('PCMHVKTTLL',PCMHVKTTLL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function PCMHVKTTLL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PCMHVKTTLL',PCMHVKTTLL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function RTBHNLUHZE_wrap_Valid(event) {
return RTBHNLUHZE_Valid(event);
}
SPBOUILib.SetInputExit('RTBHNLUHZE',RTBHNLUHZE_wrap_Valid,SPBOUILib.Row.IN_GRID);
function RTBHNLUHZE_wrap_OnFocus(event) {
return RTBHNLUHZE_OnFocus(event);
}
SPBOUILib.SetInputEnter('RTBHNLUHZE',RTBHNLUHZE_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function RTBHNLUHZE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RTBHNLUHZE',RTBHNLUHZE_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function SWIJFJKKLJ_wrap_Valid(event) {
return SWIJFJKKLJ_Valid(event);
}
SPBOUILib.SetInputExit('SWIJFJKKLJ',SWIJFJKKLJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function SWIJFJKKLJ_wrap_OnFocus(event) {
return SWIJFJKKLJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('SWIJFJKKLJ',SWIJFJKKLJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function SWIJFJKKLJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SWIJFJKKLJ',SWIJFJKKLJ_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function OIVQOXTGIZ_wrap_Valid(event) {
return OIVQOXTGIZ_Valid(event);
}
SPBOUILib.SetInputExit('OIVQOXTGIZ',OIVQOXTGIZ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function OIVQOXTGIZ_wrap_OnFocus(event) {
return OIVQOXTGIZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OIVQOXTGIZ',OIVQOXTGIZ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
if (m_bExtended) {
SetEventsAndStylesToExtendedFields();
}
}
if (Eq(m_nChildStatus,0)) {
if (Eq(m_cFunction,'query') && Ne(document.FrmToolbar,null)) {
document.FrmToolbar.pos.onkeypress=RecPositionInput;
document.FrmToolbar.pos.onblur=SelectRecord;
}
}
}
function NotifyEvent(p_cEvent) {
var old_c;
}
function SetLastFocusedOnParent() {
if (IsWndAccessible(window['m_oFather'])) {
m_oFather.i_last_focused_item='child_ardt_amldati';
m_oFather.last_focused_comp=null;
m_oFather.SetLastFocusedOnParent();
}
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
m_bStopChangeRow=true;
} else if (Ne('undefined',typeof(m_nLastError))) {
m_bStopChangeRow=Eq(m_nLastError,-2);
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={};
FocusFirstComponent.query={"page_1":["NSUYYWAOJV"]};
FocusFirstComponent.otherwise={"page_1":["NSUYYWAOJV"]};
function Help() {
windowOpenForeground('../doc/ardt_amldati_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_IDAMLANNO=a[0];
w_IDBASE=a[1];
w_LIV1=a[2];
w_LIV2=a[3];
w_LIV3=a[4];
w_N1=a[5];
w_N2=a[6];
w_N3=a[7];
w_N4=a[8];
w_N5=a[9];
w_N6=a[10];
w_N7=a[11];
w_C1=a[12];
w_C2=a[13];
w_C3=a[14];
w_C4=a[15];
w_C5=a[16];
w_C6=a[17];
w_C7=a[18];
w_BOX=a[19];
m_PrimaryKeys=['IDBASE','IDAMLANNO'];
}
function i_PrimaryKey() {
return 'amldati'+'\\'+CPLib.ToCPStr(w_IDAMLANNO);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_amldati',m_cSelectedPage);
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
function FocusFirstDetailComponent() {
var candidatesToFocus = ["UASFCHXLRC"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('IDAMLANNO',0,'NSUYYWAOJV',false,"999531942")
_Obli('IDBASE',0,'UASFCHXLRC',false)
_Obli('LIV1',0,'AFSDOMRNZC',false)
_Obli('LIV2',0,'LMBDWDWYOJ',false)
_Obli('LIV3',0,'OUCAYORICR',false)
_Obli('N1',1,'WFEQRDUEHK',false)
_Obli('N2',1,'AXLQDUTMKE',false)
_Obli('N3',1,'UQEGOTONHO',false)
_Obli('N4',1,'VLPHUFHRWG',false)
_Obli('N5',1,'RNANYATLJA',false)
_Obli('N6',1,'FGZMGIETJK',false)
_Obli('N7',1,'TTSVMTXSHK',false)
_Obli('C1',0,'BCQNNDGTFP',false)
_Obli('C2',0,'YQPUAGHCIC',false)
_Obli('C3',0,'VBELTUYZHN',false)
_Obli('C4',0,'BYRSYJQNCL',false)
_Obli('C5',0,'PCMHVKTTLL',false)
_Obli('C6',0,'RTBHNLUHZE',false)
_Obli('C7',0,'SWIJFJKKLJ',false)
_Obli('BOX',0,'OIVQOXTGIZ',false)
