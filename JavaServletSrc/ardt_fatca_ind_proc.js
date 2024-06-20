function FillCombosValues() {
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
SPBOUILib.SetInputValue('IFBCBPALEW',function(){return WtH(w_TEL,'C',40,0,'')},w_TEL);
SPBOUILib.SetInputValue('UEPBJLELZW',function(){return WtH(w_EMAIL,'C',50,0,'')},w_EMAIL);
SPBOUILib.SetInputValue('ZMPPOYZHNV',function(){return WtH(w_CAREOF,'C',80,0,'')},w_CAREOF);
SPBOUILib.SetInputValue('FTFJYPXWVP',function(){return WtH(w_DISTRICTNA,'C',30,0,'')},w_DISTRICTNA);
SPBOUILib.SetInputValue('KVIVWRVRKO',function(){return WtH(w_POSTCODE,'C',20,0,'')},w_POSTCODE);
SPBOUILib.SetInputValue('OVMPQUGMRG',function(){return WtH(w_CITY,'C',40,0,'')},w_CITY);
SPBOUILib.SetInputValue('LFXQHONWYG',function(){return WtH(w_STREET,'C',60,0,'')},w_STREET);
SPBOUILib.SetInputValue('OFHLLCOTUR',function(){return WtH(w_BUILDINGID,'C',20,0,'')},w_BUILDINGID);
SPBOUILib.SetInputValue('RATJAZVXAR',function(){return WtH(w_FLOORIDENT,'C',20,0,'')},w_FLOORIDENT);
SPBOUILib.SetInputValue('NDGHNAKVLA',function(){return WtH(w_SUITEIDENT,'C',20,0,'')},w_SUITEIDENT);
SPBOUILib.SetInputValue('VRPGIQEPBU',function(){return WtH(w_POB,'C',20,0,'')},w_POB);
} else {
SPBOUILib.SetInputValue('QXOWROTOBD',function(){return WtH(w_COUNTRYCOD,'C',2,0,'')},w_COUNTRYCOD);
SPBOUILib.SetInputValue('YEXJRJTWPN',function(){return WtH(w_COUNTRYSUB,'C',30,0,'')},w_COUNTRYSUB);
if(c=Ctrl('WAXZSYSKZJ')) selectCombo(c,w_ADDRESSTYP,'C')
SPBOUILib.SetInputValue('IFBCBPALEW',function(){return WtH(w_TEL,'C',40,0,'')},w_TEL);
SPBOUILib.SetInputValue('UEPBJLELZW',function(){return WtH(w_EMAIL,'C',50,0,'')},w_EMAIL);
SPBOUILib.SetInputValue('ZMPPOYZHNV',function(){return WtH(w_CAREOF,'C',80,0,'')},w_CAREOF);
SPBOUILib.SetInputValue('FTFJYPXWVP',function(){return WtH(w_DISTRICTNA,'C',30,0,'')},w_DISTRICTNA);
SPBOUILib.SetInputValue('KVIVWRVRKO',function(){return WtH(w_POSTCODE,'C',20,0,'')},w_POSTCODE);
SPBOUILib.SetInputValue('OVMPQUGMRG',function(){return WtH(w_CITY,'C',40,0,'')},w_CITY);
SPBOUILib.SetInputValue('LFXQHONWYG',function(){return WtH(w_STREET,'C',60,0,'')},w_STREET);
SPBOUILib.SetInputValue('OFHLLCOTUR',function(){return WtH(w_BUILDINGID,'C',20,0,'')},w_BUILDINGID);
SPBOUILib.SetInputValue('RATJAZVXAR',function(){return WtH(w_FLOORIDENT,'C',20,0,'')},w_FLOORIDENT);
SPBOUILib.SetInputValue('NDGHNAKVLA',function(){return WtH(w_SUITEIDENT,'C',20,0,'')},w_SUITEIDENT);
SPBOUILib.SetInputValue('VRPGIQEPBU',function(){return WtH(w_POB,'C',20,0,'')},w_POB);
SPBOUILib.SetInputValue('DQKSNSLDIM',function(){return WtH(w_xdescpaese,'C',40,0,'')},w_xdescpaese);
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
function QXOWROTOBD_Valid(e) {
SuggesterLib.resetSuggest('QXOWROTOBD','QXOWROTOBD');
SetActiveField(Ctrl('QXOWROTOBD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COUNTRYCOD','C',w_COUNTRYCOD,HtW(Ctrl('QXOWROTOBD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COUNTRYCOD(HtW(Ctrl('QXOWROTOBD').value,'C'),null,e);
return l_bSetResult;
}
}
function QXOWROTOBD_OnFocus(e) {
QXOWROTOBD_OnKeyUp.oldValue=HtW(Ctrl('QXOWROTOBD').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QXOWROTOBD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QXOWROTOBD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QXOWROTOBD'),e);
}
function QXOWROTOBD_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QXOWROTOBD')),'linkview_QXOWROTOBD','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QXOWROTOBD_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('QXOWROTOBD').value,'C');
if (Eq(newValue,QXOWROTOBD_OnKeyUp.oldValue)) {
return;
}
QXOWROTOBD_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('QXOWROTOBD')) || IsMobile())) {
if (Gt(newValue.length,0)) {
SuggesterLib.callSuggest(Sugg_QXOWROTOBD,2);
} else {
SuggesterLib.resetSuggest('QXOWROTOBD','QXOWROTOBD');
}
}
}
function QXOWROTOBD_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('QXOWROTOBD','QXOWROTOBD',-1,e);
}
}
function YEXJRJTWPN_Valid(e) {
SetActiveField(Ctrl('YEXJRJTWPN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COUNTRYSUB','C',w_COUNTRYSUB,HtW(Ctrl('YEXJRJTWPN').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COUNTRYSUB(HtW(Ctrl('YEXJRJTWPN').value,'C'),null,e);
return l_bSetResult;
}
}
function YEXJRJTWPN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YEXJRJTWPN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YEXJRJTWPN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YEXJRJTWPN'),e);
}
function WAXZSYSKZJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ADDRESSTYP','C',w_ADDRESSTYP,HtW(getComboValue(Ctrl('WAXZSYSKZJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ADDRESSTYP(HtW(getComboValue(Ctrl('WAXZSYSKZJ')),'C'),null,e);
return l_bSetResult;
}
}
function WAXZSYSKZJ_OnFocus(e) {
SetActiveField(Ctrl('WAXZSYSKZJ'),true);
}
function WAXZSYSKZJ_OnBlur(e) {
SetActiveField(Ctrl('WAXZSYSKZJ'),false);
}
function IFBCBPALEW_Valid(e) {
SetActiveField(Ctrl('IFBCBPALEW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TEL','C',w_TEL,HtW(Ctrl('IFBCBPALEW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TEL(HtW(Ctrl('IFBCBPALEW').value,'C'),null,e);
return l_bSetResult;
}
}
function IFBCBPALEW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IFBCBPALEW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IFBCBPALEW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IFBCBPALEW'),e);
}
function UEPBJLELZW_Valid(e) {
SetActiveField(Ctrl('UEPBJLELZW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('EMAIL','C',w_EMAIL,HtW(Ctrl('UEPBJLELZW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EMAIL(HtW(Ctrl('UEPBJLELZW').value,'C'),null,e);
return l_bSetResult;
}
}
function UEPBJLELZW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UEPBJLELZW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UEPBJLELZW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UEPBJLELZW'),e);
}
function ZMPPOYZHNV_Valid(e) {
SetActiveField(Ctrl('ZMPPOYZHNV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAREOF','C',w_CAREOF,HtW(Ctrl('ZMPPOYZHNV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAREOF(HtW(Ctrl('ZMPPOYZHNV').value,'C'),null,e);
return l_bSetResult;
}
}
function ZMPPOYZHNV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZMPPOYZHNV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZMPPOYZHNV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZMPPOYZHNV'),e);
}
function FTFJYPXWVP_Valid(e) {
SetActiveField(Ctrl('FTFJYPXWVP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DISTRICTNA','C',w_DISTRICTNA,HtW(Ctrl('FTFJYPXWVP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DISTRICTNA(HtW(Ctrl('FTFJYPXWVP').value,'C'),null,e);
return l_bSetResult;
}
}
function FTFJYPXWVP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FTFJYPXWVP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FTFJYPXWVP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FTFJYPXWVP'),e);
}
function KVIVWRVRKO_Valid(e) {
SetActiveField(Ctrl('KVIVWRVRKO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('POSTCODE','C',w_POSTCODE,HtW(Ctrl('KVIVWRVRKO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_POSTCODE(HtW(Ctrl('KVIVWRVRKO').value,'C'),null,e);
return l_bSetResult;
}
}
function KVIVWRVRKO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KVIVWRVRKO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KVIVWRVRKO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KVIVWRVRKO'),e);
}
function OVMPQUGMRG_Valid(e) {
SetActiveField(Ctrl('OVMPQUGMRG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CITY','C',w_CITY,HtW(Ctrl('OVMPQUGMRG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CITY(HtW(Ctrl('OVMPQUGMRG').value,'C'),null,e);
return l_bSetResult;
}
}
function OVMPQUGMRG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OVMPQUGMRG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OVMPQUGMRG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OVMPQUGMRG'),e);
}
function LFXQHONWYG_Valid(e) {
SetActiveField(Ctrl('LFXQHONWYG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('STREET','C',w_STREET,HtW(Ctrl('LFXQHONWYG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_STREET(HtW(Ctrl('LFXQHONWYG').value,'C'),null,e);
return l_bSetResult;
}
}
function LFXQHONWYG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LFXQHONWYG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('LFXQHONWYG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LFXQHONWYG'),e);
}
function OFHLLCOTUR_Valid(e) {
SetActiveField(Ctrl('OFHLLCOTUR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('BUILDINGID','C',w_BUILDINGID,HtW(Ctrl('OFHLLCOTUR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_BUILDINGID(HtW(Ctrl('OFHLLCOTUR').value,'C'),null,e);
return l_bSetResult;
}
}
function OFHLLCOTUR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OFHLLCOTUR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OFHLLCOTUR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OFHLLCOTUR'),e);
}
function RATJAZVXAR_Valid(e) {
SetActiveField(Ctrl('RATJAZVXAR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('FLOORIDENT','C',w_FLOORIDENT,HtW(Ctrl('RATJAZVXAR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLOORIDENT(HtW(Ctrl('RATJAZVXAR').value,'C'),null,e);
return l_bSetResult;
}
}
function RATJAZVXAR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RATJAZVXAR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RATJAZVXAR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RATJAZVXAR'),e);
}
function NDGHNAKVLA_Valid(e) {
SetActiveField(Ctrl('NDGHNAKVLA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SUITEIDENT','C',w_SUITEIDENT,HtW(Ctrl('NDGHNAKVLA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SUITEIDENT(HtW(Ctrl('NDGHNAKVLA').value,'C'),null,e);
return l_bSetResult;
}
}
function NDGHNAKVLA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NDGHNAKVLA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NDGHNAKVLA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NDGHNAKVLA'),e);
}
function VRPGIQEPBU_Valid(e) {
SetActiveField(Ctrl('VRPGIQEPBU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('POB','C',w_POB,HtW(Ctrl('VRPGIQEPBU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_POB(HtW(Ctrl('VRPGIQEPBU').value,'C'),null,e);
return l_bSetResult;
}
}
function VRPGIQEPBU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VRPGIQEPBU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VRPGIQEPBU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VRPGIQEPBU'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function QXOWROTOBD_wrap_Valid(event) {
return QXOWROTOBD_Valid(event);
}
SPBOUILib.SetInputExit('QXOWROTOBD',QXOWROTOBD_wrap_Valid,SPBOUILib.Row.IN_GRID);
function QXOWROTOBD_wrap_OnFocus(event) {
return QXOWROTOBD_OnFocus(event);
}
SPBOUILib.SetInputEnter('QXOWROTOBD',QXOWROTOBD_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function QXOWROTOBD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QXOWROTOBD',QXOWROTOBD_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function QXOWROTOBD_ZOOM_setHandlers() {
function QXOWROTOBD_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QXOWROTOBD_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QXOWROTOBD_ZOOM',QXOWROTOBD_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('QXOWROTOBD',QXOWROTOBD_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('QXOWROTOBD',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?QXOWROTOBD_OnKeyUp(event):void(0));
},SPBOUILib.Row.IN_GRID);
function YEXJRJTWPN_wrap_Valid(event) {
return YEXJRJTWPN_Valid(event);
}
SPBOUILib.SetInputExit('YEXJRJTWPN',YEXJRJTWPN_wrap_Valid,SPBOUILib.Row.IN_GRID);
function YEXJRJTWPN_wrap_OnFocus(event) {
return YEXJRJTWPN_OnFocus(event);
}
SPBOUILib.SetInputEnter('YEXJRJTWPN',YEXJRJTWPN_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function YEXJRJTWPN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YEXJRJTWPN',YEXJRJTWPN_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function WAXZSYSKZJ_wrap_Valid(event) {
return WAXZSYSKZJ_Valid(event);
}
SPBOUILib.SetComboChange('WAXZSYSKZJ',WAXZSYSKZJ_wrap_Valid,SPBOUILib.Row.IN_GRID);
function WAXZSYSKZJ_wrap_OnFocus(event) {
return WAXZSYSKZJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('WAXZSYSKZJ',WAXZSYSKZJ_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function WAXZSYSKZJ_wrap_Blur(event) {
return WAXZSYSKZJ_OnBlur(event);
}
SPBOUILib.SetInputExit('WAXZSYSKZJ',WAXZSYSKZJ_wrap_Blur,SPBOUILib.Row.IN_GRID);
function IFBCBPALEW_wrap_Valid(event) {
return IFBCBPALEW_Valid(event);
}
SPBOUILib.SetInputExit('IFBCBPALEW',IFBCBPALEW_wrap_Valid);
function IFBCBPALEW_wrap_OnFocus(event) {
return IFBCBPALEW_OnFocus(event);
}
SPBOUILib.SetInputEnter('IFBCBPALEW',IFBCBPALEW_wrap_OnFocus);
function IFBCBPALEW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IFBCBPALEW',IFBCBPALEW_wrap_OnKeyDown);
function UEPBJLELZW_wrap_Valid(event) {
return UEPBJLELZW_Valid(event);
}
SPBOUILib.SetInputExit('UEPBJLELZW',UEPBJLELZW_wrap_Valid);
function UEPBJLELZW_wrap_OnFocus(event) {
return UEPBJLELZW_OnFocus(event);
}
SPBOUILib.SetInputEnter('UEPBJLELZW',UEPBJLELZW_wrap_OnFocus);
function UEPBJLELZW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UEPBJLELZW',UEPBJLELZW_wrap_OnKeyDown);
function ZMPPOYZHNV_wrap_Valid(event) {
return ZMPPOYZHNV_Valid(event);
}
SPBOUILib.SetInputExit('ZMPPOYZHNV',ZMPPOYZHNV_wrap_Valid);
function ZMPPOYZHNV_wrap_OnFocus(event) {
return ZMPPOYZHNV_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZMPPOYZHNV',ZMPPOYZHNV_wrap_OnFocus);
function ZMPPOYZHNV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZMPPOYZHNV',ZMPPOYZHNV_wrap_OnKeyDown);
function FTFJYPXWVP_wrap_Valid(event) {
return FTFJYPXWVP_Valid(event);
}
SPBOUILib.SetInputExit('FTFJYPXWVP',FTFJYPXWVP_wrap_Valid);
function FTFJYPXWVP_wrap_OnFocus(event) {
return FTFJYPXWVP_OnFocus(event);
}
SPBOUILib.SetInputEnter('FTFJYPXWVP',FTFJYPXWVP_wrap_OnFocus);
function FTFJYPXWVP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FTFJYPXWVP',FTFJYPXWVP_wrap_OnKeyDown);
function KVIVWRVRKO_wrap_Valid(event) {
return KVIVWRVRKO_Valid(event);
}
SPBOUILib.SetInputExit('KVIVWRVRKO',KVIVWRVRKO_wrap_Valid);
function KVIVWRVRKO_wrap_OnFocus(event) {
return KVIVWRVRKO_OnFocus(event);
}
SPBOUILib.SetInputEnter('KVIVWRVRKO',KVIVWRVRKO_wrap_OnFocus);
function KVIVWRVRKO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KVIVWRVRKO',KVIVWRVRKO_wrap_OnKeyDown);
function OVMPQUGMRG_wrap_Valid(event) {
return OVMPQUGMRG_Valid(event);
}
SPBOUILib.SetInputExit('OVMPQUGMRG',OVMPQUGMRG_wrap_Valid);
function OVMPQUGMRG_wrap_OnFocus(event) {
return OVMPQUGMRG_OnFocus(event);
}
SPBOUILib.SetInputEnter('OVMPQUGMRG',OVMPQUGMRG_wrap_OnFocus);
function OVMPQUGMRG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OVMPQUGMRG',OVMPQUGMRG_wrap_OnKeyDown);
function LFXQHONWYG_wrap_Valid(event) {
return LFXQHONWYG_Valid(event);
}
SPBOUILib.SetInputExit('LFXQHONWYG',LFXQHONWYG_wrap_Valid);
function LFXQHONWYG_wrap_OnFocus(event) {
return LFXQHONWYG_OnFocus(event);
}
SPBOUILib.SetInputEnter('LFXQHONWYG',LFXQHONWYG_wrap_OnFocus);
function LFXQHONWYG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LFXQHONWYG',LFXQHONWYG_wrap_OnKeyDown);
function OFHLLCOTUR_wrap_Valid(event) {
return OFHLLCOTUR_Valid(event);
}
SPBOUILib.SetInputExit('OFHLLCOTUR',OFHLLCOTUR_wrap_Valid);
function OFHLLCOTUR_wrap_OnFocus(event) {
return OFHLLCOTUR_OnFocus(event);
}
SPBOUILib.SetInputEnter('OFHLLCOTUR',OFHLLCOTUR_wrap_OnFocus);
function OFHLLCOTUR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OFHLLCOTUR',OFHLLCOTUR_wrap_OnKeyDown);
function RATJAZVXAR_wrap_Valid(event) {
return RATJAZVXAR_Valid(event);
}
SPBOUILib.SetInputExit('RATJAZVXAR',RATJAZVXAR_wrap_Valid);
function RATJAZVXAR_wrap_OnFocus(event) {
return RATJAZVXAR_OnFocus(event);
}
SPBOUILib.SetInputEnter('RATJAZVXAR',RATJAZVXAR_wrap_OnFocus);
function RATJAZVXAR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RATJAZVXAR',RATJAZVXAR_wrap_OnKeyDown);
function NDGHNAKVLA_wrap_Valid(event) {
return NDGHNAKVLA_Valid(event);
}
SPBOUILib.SetInputExit('NDGHNAKVLA',NDGHNAKVLA_wrap_Valid);
function NDGHNAKVLA_wrap_OnFocus(event) {
return NDGHNAKVLA_OnFocus(event);
}
SPBOUILib.SetInputEnter('NDGHNAKVLA',NDGHNAKVLA_wrap_OnFocus);
function NDGHNAKVLA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NDGHNAKVLA',NDGHNAKVLA_wrap_OnKeyDown);
function VRPGIQEPBU_wrap_Valid(event) {
return VRPGIQEPBU_Valid(event);
}
SPBOUILib.SetInputExit('VRPGIQEPBU',VRPGIQEPBU_wrap_Valid);
function VRPGIQEPBU_wrap_OnFocus(event) {
return VRPGIQEPBU_OnFocus(event);
}
SPBOUILib.SetInputEnter('VRPGIQEPBU',VRPGIQEPBU_wrap_OnFocus);
function VRPGIQEPBU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VRPGIQEPBU',VRPGIQEPBU_wrap_OnKeyDown);
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
m_oFather.i_last_focused_item='child_ardt_fatca_ind';
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
FocusFirstComponent.query={};
FocusFirstComponent.otherwise={};
function Help() {
windowOpenForeground('../doc/ardt_fatca_ind_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_CONNES=a[0];
w_COUNTRYCOD=a[1];
w_COUNTRYSUB=a[2];
w_ADDRESSTYP=a[3];
w_TEL=a[4];
w_EMAIL=a[5];
w_IDBASE=a[6];
w_CAREOF=a[7];
w_DISTRICTNA=a[8];
w_POSTCODE=a[9];
w_CITY=a[10];
w_STREET=a[11];
w_BUILDINGID=a[12];
w_FLOORIDENT=a[13];
w_SUITEIDENT=a[14];
w_POB=a[15];
w_CPROWNUM=a[16];
w_xdescpaese=a[17];
w_tipoIND=a[18];
m_PrimaryKeys=['CPROWNUM','CONNES'];
}
function i_PrimaryKey() {
return 'fatca_ind'+'\\'+CPLib.ToCPStr(w_CONNES);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_fatca_ind',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_COUNTRYCOD,'C'); },"field":"ISO2","type":"C"},{"expression":function() { return WtA(w_xdescpaese,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"QXOWROTOBD"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["QXOWROTOBD"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('DISTRICTNA',0,'FTFJYPXWVP',false)
_Obli('CAREOF',0,'ZMPPOYZHNV',false)
_Obli('COUNTRYCOD',0,'QXOWROTOBD',false)
_Obli('COUNTRYSUB',0,'YEXJRJTWPN',false)
_Obli('ADDRESSTYP',0,'WAXZSYSKZJ',false,"132341360")
_Obli('TEL',0,'IFBCBPALEW',false)
_Obli('EMAIL',0,'UEPBJLELZW',false)
_Obli('CITY',0,'OVMPQUGMRG',false)
_Obli('SUITEIDENT',0,'NDGHNAKVLA',false)
_Obli('POB',0,'VRPGIQEPBU',false)
_Obli('POSTCODE',0,'KVIVWRVRKO',false)
_Obli('STREET',0,'LFXQHONWYG',false)
_Obli('BUILDINGID',0,'OFHLLCOTUR',false)
_Obli('FLOORIDENT',0,'RATJAZVXAR',false)
