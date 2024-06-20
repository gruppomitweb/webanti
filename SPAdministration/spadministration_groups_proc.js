function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('GQMQADKZER',function(){return WtH(w_idfolder,'N',6,0,'')},w_idfolder);
SPBOUILib.SetInputValue('SLTEEWARRT',function(){return WtH(w_code,'N',6,0,'999999')},w_code);
SPBOUILib.SetInputValue('IGYAELXEXR',function(){return WtH(w_name,'C',50,0,'')},w_name);
if(c=Ctrl('AWEWRIIVNS')) selectCombo(c,w_grptype,'C')
SPBOUILib.SetInputValue('XMHFZMIAMS',function(){return WtH(w_datestart,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestart);
SPBOUILib.SetInputValue('KNAKRRMCNW',function(){return WtH(w_datestop,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_datestop);
SPBOUILib.SetInputValue('VJQMUEKTSX',function(){return WtH(w_pwdcomplexity,'N',3,0,'')},w_pwdcomplexity);
SPBOUILib.SetInputValue('BBOWMTSSOW',function(){return WtH(w_pwddaysduration,'N',4,0,'')},w_pwddaysduration);
SPBOUILib.SetInputValue('AKJBCTEQJP',function(){return WtH(w_pwdciclicity,'N',4,0,'')},w_pwdciclicity);
SPBOUILib.SetInputValue('SOASGKKWLW',function(){return WtH(w_captchalevel,'N',4,0,'')},w_captchalevel);
var tmp_DRGTXCMDVI = ToHTag(AsControlValue('/'+UserAdmin.GetPasswordRatingMaxReachable()));
if (Ne(e_DRGTXCMDVI,tmp_DRGTXCMDVI)) {
SPBOUILib.SetLabelValue('DRGTXCMDVI','innerHTML',tmp_DRGTXCMDVI);
e_DRGTXCMDVI=tmp_DRGTXCMDVI;
}
SPBOUILib.SetInputValue('HFWINMHKPE',function(){return WtH(w_grpdescription,'M',10,0,'')},w_grpdescription);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay(Ctrl('GQMQADKZER'),true || IsHiddenByStateDriver('idfolder'));
SetDisplay(Ctrl('QLCHTSHZNI'),true);
SetDisplay('EDWZXXHLLG_DIV',IsHiddenByStateDriver('box_EDWZXXHLLG'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["captchalevel"]=['OLRRJSKSLR'];
HideUI.lblids["code"]=['YKCGEUAQNO'];
HideUI.lblids["company"]=['QLCHTSHZNI'];
HideUI.lblids["datestart"]=['MRBKYUENGX'];
HideUI.lblids["datestop"]=['ZTZOBAMZRU'];
HideUI.lblids["grpdescription"]=['JNUWUCCLZX'];
HideUI.lblids["grptype"]=['QLXYNDBKBY'];
HideUI.lblids["name"]=['ORGIAKWWFA'];
HideUI.lblids["pwdciclicity"]=['PUPZWRUBQZ'];
HideUI.lblids["pwdcomplexity"]=['QYGWLPNULE'];
HideUI.lblids["pwddaysduration"]=['HADNBQNYMD'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function GQMQADKZER_Valid(e) {
SetActiveField(Ctrl('GQMQADKZER'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('idfolder','N',w_idfolder,HtW(Ctrl('GQMQADKZER').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_idfolder(HtW(Ctrl('GQMQADKZER').value,'N'),null,e);
return l_bSetResult;
}
}
function GQMQADKZER_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('GQMQADKZER'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('GQMQADKZER'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('GQMQADKZER'),e);
}
function SLTEEWARRT_Valid(e) {
SetActiveField(Ctrl('SLTEEWARRT'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SLTEEWARRT') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('code','N',w_code,HtW(Ctrl('SLTEEWARRT').value,'N'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_code(HtW(Ctrl('SLTEEWARRT').value,'N'),null,e);
return l_bSetResult;
}
}
function SLTEEWARRT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SLTEEWARRT'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('SLTEEWARRT',w_code,'N',6,0,'999999');
SetActiveField(Ctrl('SLTEEWARRT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SLTEEWARRT'),e);
}
function SLTEEWARRT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999"));
}
function IGYAELXEXR_Valid(e) {
SetActiveField(Ctrl('IGYAELXEXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('name','C',w_name,HtW(Ctrl('IGYAELXEXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_name(HtW(Ctrl('IGYAELXEXR').value,'C'),null,e);
return l_bSetResult;
}
}
function IGYAELXEXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IGYAELXEXR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IGYAELXEXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IGYAELXEXR'),e);
}
function AWEWRIIVNS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('grptype','C',w_grptype,HtW(getComboValue(Ctrl('AWEWRIIVNS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_grptype(HtW(getComboValue(Ctrl('AWEWRIIVNS')),'C'),null,e);
return l_bSetResult;
}
}
function AWEWRIIVNS_OnFocus(e) {
SetActiveField(Ctrl('AWEWRIIVNS'),true);
}
function AWEWRIIVNS_OnBlur(e) {
SetActiveField(Ctrl('AWEWRIIVNS'),false);
}
function XMHFZMIAMS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XMHFZMIAMS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XMHFZMIAMS').value=ApplyPictureToDate(Ctrl('XMHFZMIAMS').value,TranslatePicture(datePattern),'XMHFZMIAMS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XMHFZMIAMS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XMHFZMIAMS');
}
}
}
SetActiveField(Ctrl('XMHFZMIAMS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestart','D',w_datestart,HtW(Ctrl('XMHFZMIAMS').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestart(HtW(Ctrl('XMHFZMIAMS').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XMHFZMIAMS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XMHFZMIAMS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XMHFZMIAMS',w_datestart,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('XMHFZMIAMS');
SetActiveField(Ctrl('XMHFZMIAMS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XMHFZMIAMS'),e);
}
function XMHFZMIAMS_ZOOM_Click() {
LaunchCalendar(Ctrl('XMHFZMIAMS'));
}
function KNAKRRMCNW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('KNAKRRMCNW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('KNAKRRMCNW').value=ApplyPictureToDate(Ctrl('KNAKRRMCNW').value,TranslatePicture(datePattern),'KNAKRRMCNW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('KNAKRRMCNW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('KNAKRRMCNW');
}
}
}
SetActiveField(Ctrl('KNAKRRMCNW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('datestop','D',w_datestop,HtW(Ctrl('KNAKRRMCNW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_datestop(HtW(Ctrl('KNAKRRMCNW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function KNAKRRMCNW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KNAKRRMCNW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('KNAKRRMCNW',w_datestop,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('KNAKRRMCNW');
SetActiveField(Ctrl('KNAKRRMCNW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KNAKRRMCNW'),e);
}
function KNAKRRMCNW_ZOOM_Click() {
LaunchCalendar(Ctrl('KNAKRRMCNW'));
}
function VJQMUEKTSX_Valid(e) {
SetActiveField(Ctrl('VJQMUEKTSX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwdcomplexity','N',w_pwdcomplexity,HtW(Ctrl('VJQMUEKTSX').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwdcomplexity(HtW(Ctrl('VJQMUEKTSX').value,'N'),null,e);
return l_bSetResult;
}
}
function VJQMUEKTSX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VJQMUEKTSX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VJQMUEKTSX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VJQMUEKTSX'),e);
}
function BBOWMTSSOW_Valid(e) {
SetActiveField(Ctrl('BBOWMTSSOW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwddaysduration','N',w_pwddaysduration,HtW(Ctrl('BBOWMTSSOW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwddaysduration(HtW(Ctrl('BBOWMTSSOW').value,'N'),null,e);
return l_bSetResult;
}
}
function BBOWMTSSOW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BBOWMTSSOW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BBOWMTSSOW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BBOWMTSSOW'),e);
}
function AKJBCTEQJP_Valid(e) {
SetActiveField(Ctrl('AKJBCTEQJP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('pwdciclicity','N',w_pwdciclicity,HtW(Ctrl('AKJBCTEQJP').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_pwdciclicity(HtW(Ctrl('AKJBCTEQJP').value,'N'),null,e);
return l_bSetResult;
}
}
function AKJBCTEQJP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AKJBCTEQJP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AKJBCTEQJP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AKJBCTEQJP'),e);
}
function SOASGKKWLW_Valid(e) {
SetActiveField(Ctrl('SOASGKKWLW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('captchalevel','N',w_captchalevel,HtW(Ctrl('SOASGKKWLW').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_captchalevel(HtW(Ctrl('SOASGKKWLW').value,'N'),null,e);
return l_bSetResult;
}
}
function SOASGKKWLW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SOASGKKWLW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SOASGKKWLW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SOASGKKWLW'),e);
}
function HFWINMHKPE_Valid(e) {
SetActiveField(Ctrl('HFWINMHKPE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('grpdescription','M',w_grpdescription,HtW(Ctrl('HFWINMHKPE').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_grpdescription(HtW(Ctrl('HFWINMHKPE').value,'M'),null,e);
return l_bSetResult;
}
}
function HFWINMHKPE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HFWINMHKPE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HFWINMHKPE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HFWINMHKPE'),e);
}
linkpc_url.u('CRFACLOJKX',function(){return 'spadministration_subgroups?m_bInnerChild=true'+GetLinkPCKeys('spadministration_subgroups')+'&m_bRowsChild='+EnableChild('spadministration_subgroups')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function GQMQADKZER_wrap_Valid(event) {
return GQMQADKZER_Valid(event);
}
SPBOUILib.SetInputExit('GQMQADKZER',GQMQADKZER_wrap_Valid);
function GQMQADKZER_wrap_OnFocus(event) {
return GQMQADKZER_OnFocus(event);
}
SPBOUILib.SetInputEnter('GQMQADKZER',GQMQADKZER_wrap_OnFocus);
function GQMQADKZER_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('GQMQADKZER',GQMQADKZER_wrap_OnKeyPress);
function GQMQADKZER_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('GQMQADKZER',GQMQADKZER_wrap_OnKeyDown);
function SLTEEWARRT_wrap_Valid(event) {
return SLTEEWARRT_Valid(event);
}
SPBOUILib.SetInputExit('SLTEEWARRT',SLTEEWARRT_wrap_Valid);
function SLTEEWARRT_wrap_OnFocus(event) {
return SLTEEWARRT_OnFocus(event);
}
SPBOUILib.SetInputEnter('SLTEEWARRT',SLTEEWARRT_wrap_OnFocus);
function SLTEEWARRT_wrap_OnKeyPress(event) {
return SLTEEWARRT_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('SLTEEWARRT',SLTEEWARRT_wrap_OnKeyPress);
function SLTEEWARRT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SLTEEWARRT',SLTEEWARRT_wrap_OnKeyDown);
function IGYAELXEXR_wrap_Valid(event) {
return IGYAELXEXR_Valid(event);
}
SPBOUILib.SetInputExit('IGYAELXEXR',IGYAELXEXR_wrap_Valid);
function IGYAELXEXR_wrap_OnFocus(event) {
return IGYAELXEXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('IGYAELXEXR',IGYAELXEXR_wrap_OnFocus);
function IGYAELXEXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IGYAELXEXR',IGYAELXEXR_wrap_OnKeyDown);
function AWEWRIIVNS_wrap_Valid(event) {
return AWEWRIIVNS_Valid(event);
}
SPBOUILib.SetComboChange('AWEWRIIVNS',AWEWRIIVNS_wrap_Valid);
function AWEWRIIVNS_wrap_OnFocus(event) {
return AWEWRIIVNS_OnFocus(event);
}
SPBOUILib.SetInputEnter('AWEWRIIVNS',AWEWRIIVNS_wrap_OnFocus);
function AWEWRIIVNS_wrap_Blur(event) {
return AWEWRIIVNS_OnBlur(event);
}
SPBOUILib.SetInputExit('AWEWRIIVNS',AWEWRIIVNS_wrap_Blur);
function XMHFZMIAMS_wrap_Valid(event) {
return XMHFZMIAMS_Valid(event);
}
SPBOUILib.SetInputExit('XMHFZMIAMS',XMHFZMIAMS_wrap_Valid);
function XMHFZMIAMS_wrap_OnFocus(event) {
return XMHFZMIAMS_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMHFZMIAMS',XMHFZMIAMS_wrap_OnFocus);
function XMHFZMIAMS_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XMHFZMIAMS',XMHFZMIAMS_wrap_OnKeyPress);
function XMHFZMIAMS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XMHFZMIAMS',XMHFZMIAMS_wrap_OnKeyDown);
function XMHFZMIAMS_ZOOM_setHandlers() {
function XMHFZMIAMS_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XMHFZMIAMS_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XMHFZMIAMS_ZOOM',XMHFZMIAMS_ZOOM_wrap_OnClick);
function XMHFZMIAMS_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XMHFZMIAMS_ZOOM',XMHFZMIAMS_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XMHFZMIAMS',XMHFZMIAMS_ZOOM_setHandlers);
function KNAKRRMCNW_wrap_Valid(event) {
return KNAKRRMCNW_Valid(event);
}
SPBOUILib.SetInputExit('KNAKRRMCNW',KNAKRRMCNW_wrap_Valid);
function KNAKRRMCNW_wrap_OnFocus(event) {
return KNAKRRMCNW_OnFocus(event);
}
SPBOUILib.SetInputEnter('KNAKRRMCNW',KNAKRRMCNW_wrap_OnFocus);
function KNAKRRMCNW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('KNAKRRMCNW',KNAKRRMCNW_wrap_OnKeyPress);
function KNAKRRMCNW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('KNAKRRMCNW',KNAKRRMCNW_wrap_OnKeyDown);
function KNAKRRMCNW_ZOOM_setHandlers() {
function KNAKRRMCNW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KNAKRRMCNW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('KNAKRRMCNW_ZOOM',KNAKRRMCNW_ZOOM_wrap_OnClick);
function KNAKRRMCNW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KNAKRRMCNW_ZOOM',KNAKRRMCNW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('KNAKRRMCNW',KNAKRRMCNW_ZOOM_setHandlers);
function VJQMUEKTSX_wrap_Valid(event) {
return VJQMUEKTSX_Valid(event);
}
SPBOUILib.SetInputExit('VJQMUEKTSX',VJQMUEKTSX_wrap_Valid);
function VJQMUEKTSX_wrap_OnFocus(event) {
return VJQMUEKTSX_OnFocus(event);
}
SPBOUILib.SetInputEnter('VJQMUEKTSX',VJQMUEKTSX_wrap_OnFocus);
function VJQMUEKTSX_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('VJQMUEKTSX',VJQMUEKTSX_wrap_OnKeyPress);
function VJQMUEKTSX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VJQMUEKTSX',VJQMUEKTSX_wrap_OnKeyDown);
function BBOWMTSSOW_wrap_Valid(event) {
return BBOWMTSSOW_Valid(event);
}
SPBOUILib.SetInputExit('BBOWMTSSOW',BBOWMTSSOW_wrap_Valid);
function BBOWMTSSOW_wrap_OnFocus(event) {
return BBOWMTSSOW_OnFocus(event);
}
SPBOUILib.SetInputEnter('BBOWMTSSOW',BBOWMTSSOW_wrap_OnFocus);
function BBOWMTSSOW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('BBOWMTSSOW',BBOWMTSSOW_wrap_OnKeyPress);
function BBOWMTSSOW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BBOWMTSSOW',BBOWMTSSOW_wrap_OnKeyDown);
function AKJBCTEQJP_wrap_Valid(event) {
return AKJBCTEQJP_Valid(event);
}
SPBOUILib.SetInputExit('AKJBCTEQJP',AKJBCTEQJP_wrap_Valid);
function AKJBCTEQJP_wrap_OnFocus(event) {
return AKJBCTEQJP_OnFocus(event);
}
SPBOUILib.SetInputEnter('AKJBCTEQJP',AKJBCTEQJP_wrap_OnFocus);
function AKJBCTEQJP_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('AKJBCTEQJP',AKJBCTEQJP_wrap_OnKeyPress);
function AKJBCTEQJP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AKJBCTEQJP',AKJBCTEQJP_wrap_OnKeyDown);
function SOASGKKWLW_wrap_Valid(event) {
return SOASGKKWLW_Valid(event);
}
SPBOUILib.SetInputExit('SOASGKKWLW',SOASGKKWLW_wrap_Valid);
function SOASGKKWLW_wrap_OnFocus(event) {
return SOASGKKWLW_OnFocus(event);
}
SPBOUILib.SetInputEnter('SOASGKKWLW',SOASGKKWLW_wrap_OnFocus);
function SOASGKKWLW_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('SOASGKKWLW',SOASGKKWLW_wrap_OnKeyPress);
function SOASGKKWLW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SOASGKKWLW',SOASGKKWLW_wrap_OnKeyDown);
function HFWINMHKPE_wrap_Valid(event) {
return HFWINMHKPE_Valid(event);
}
SPBOUILib.SetInputExit('HFWINMHKPE',HFWINMHKPE_wrap_Valid);
function HFWINMHKPE_wrap_OnFocus(event) {
return HFWINMHKPE_OnFocus(event);
}
SPBOUILib.SetInputEnter('HFWINMHKPE',HFWINMHKPE_wrap_OnFocus);
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
FocusFirstComponent.edit={"page_1":["IGYAELXEXR"]};
FocusFirstComponent.query={"page_1":["SLTEEWARRT"]};
FocusFirstComponent.otherwise={"page_1":["SLTEEWARRT"]};
function Help() {
windowOpenForeground('../doc/spadministration_groups_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_spadministration_subgroups() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('CRFACLOJKX')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('CRFACLOJKX')) {
LoadContext.lc(1,'CRFACLOJKX');
}
} else {
LibJavascript.RefreshChildGrid('CRFACLOJKX');
}
}
}
GetLayerID.Layers.push({"id":"EDWZXXHLLG","name":"box_EDWZXXHLLG"});
function DeclareWVs() {
var a = arguments;
w_code=a[0];
w_name=a[1];
w_grptype=a[2];
w_datestart=a[3];
w_datestop=a[4];
w_company=a[5];
w_pwdcomplexity=a[6];
w_pwddaysduration=a[7];
w_pwdciclicity=a[8];
w_captchalevel=a[9];
w_grpdescription=a[10];
w_idfolder=a[11];
w_init_code=a[12];
m_cWv_spadministration_subgroups=a[13];
if (Gt(a.length,14)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['code'];
}
function i_PrimaryKey() {
return 'cpgroups'+'\\'+CPLib.ToCPStr(w_code);
}
GetLinkPCKeys.set_o('spadministration_subgroups',false);
GetLinkPCKeys.o['spadministration_subgroups']['groupcode']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_code,'N');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('CRFACLOJKX',function(){return FrameRef('spadministration_subgroups')},1,'spadministration_subgroups',1,1)
GetSelectedChildPage.child={'spadministration_subgroups': function(){return FrameRef('spadministration_subgroups')}}
function GetSelectedPage(p_d) {
p_d.setValue('spadministration_groups',m_cSelectedPage);
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
_Obli('idfolder',1,'GQMQADKZER',false)
_Obli('code',1,'SLTEEWARRT',false,"960685589")
_Obli('name',0,'IGYAELXEXR',false,"1682105886")
_Obli('grptype',0,'AWEWRIIVNS',false,"10364714463")
_Obli('datestart',2,'XMHFZMIAMS',false,"20009153")
_Obli('datestop',2,'KNAKRRMCNW',false,"556515051")
_Obli('grpdescription',0,'HFWINMHKPE',false,"1209777154")
_Obli('pwdcomplexity',1,'VJQMUEKTSX',false,"11873255554")
_Obli('pwddaysduration',1,'BBOWMTSSOW',false,"1076819334")
_Obli('pwdciclicity',1,'AKJBCTEQJP',false,"11641847591")
_Obli('captchalevel',1,'SOASGKKWLW',false,"10075957577")
