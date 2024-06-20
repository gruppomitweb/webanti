function FillCombosValues() {
FillCombo('NLQNUCEFAF','NLQNUCEFAF');
}
function FillInGridCombosValues(currentRow) {
var postfix = (Gt(currentRow,-1)?'_'+currentRow:'');
}
function SetControlsValue() {
var c;
if (Empty(m_cAltInterface) && (Eq(m_cFunction,'view') || Eq(m_cFunction,'query'))) {
var tmp_AHAEFMDTZV = ToHTag(AsControlValue(w_dessta));
if (Ne(e_AHAEFMDTZV,tmp_AHAEFMDTZV)) {
SPBOUILib.SetLabelValue('AHAEFMDTZV','innerHTML',tmp_AHAEFMDTZV);
e_AHAEFMDTZV=tmp_AHAEFMDTZV;
}
if(c=Ctrl('NLQNUCEFAF')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('ZWNTMRMLZT',function(){return WtH(w_NUMDOCUM,'C',15,0,'')},w_NUMDOCUM);
SPBOUILib.SetInputValue('IWFQNNZEIO',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('DPXJJYNKQD',function(){return WtH(w_AUTRILASC,'C',30,0,'')},w_AUTRILASC);
SPBOUILib.SetInputValue('TFTPGRBHXL',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('XWVSEMUYKF',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('TNGAQJNMOX',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('OVPWCHXBKI',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('FVRVSFXLIG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('BZUPXAPSJB',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
} else {
var tmp_AHAEFMDTZV = ToHTag(AsControlValue(w_dessta));
if (Ne(e_AHAEFMDTZV,tmp_AHAEFMDTZV)) {
SPBOUILib.SetLabelValue('AHAEFMDTZV','innerHTML',tmp_AHAEFMDTZV);
e_AHAEFMDTZV=tmp_AHAEFMDTZV;
}
SPBOUILib.SetInputValue('XCOFZIDOBL',function(){return WtH(w_CONNESCLI,'C',16,0,'')},w_CONNESCLI);
if(c=Ctrl('NLQNUCEFAF')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('ZWNTMRMLZT',function(){return WtH(w_NUMDOCUM,'C',15,0,'')},w_NUMDOCUM);
SPBOUILib.SetInputValue('IWFQNNZEIO',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('DPXJJYNKQD',function(){return WtH(w_AUTRILASC,'C',30,0,'')},w_AUTRILASC);
SPBOUILib.SetInputValue('RNNLFXBYNE',function(){return WtH(w_xRagSocDoc,'C',70,0,'')},w_xRagSocDoc);
SPBOUILib.SetInputValue('TFTPGRBHXL',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('XWVSEMUYKF',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
SPBOUILib.SetInputValue('TNGAQJNMOX',function(){return WtH(w_DESCCIT,'C',30,0,'')},w_DESCCIT);
SPBOUILib.SetInputValue('OVPWCHXBKI',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('FVRVSFXLIG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('BZUPXAPSJB',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
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
function XCOFZIDOBL_Valid(e) {
SetActiveField(Ctrl('XCOFZIDOBL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESCLI','C',w_CONNESCLI,HtW(Ctrl('XCOFZIDOBL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESCLI(HtW(Ctrl('XCOFZIDOBL').value,'C'),null,e);
return l_bSetResult;
}
}
function XCOFZIDOBL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XCOFZIDOBL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XCOFZIDOBL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XCOFZIDOBL'),e);
}
function XCOFZIDOBL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('XCOFZIDOBL')),'linkview_XCOFZIDOBL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NLQNUCEFAF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPODOC','C',w_TIPODOC,HtW(getComboValue(Ctrl('NLQNUCEFAF')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPODOC(HtW(getComboValue(Ctrl('NLQNUCEFAF')),'C'),null,e);
return l_bSetResult;
}
}
function NLQNUCEFAF_OnFocus(e) {
SetActiveField(Ctrl('NLQNUCEFAF'),true);
}
function NLQNUCEFAF_OnBlur(e) {
SetActiveField(Ctrl('NLQNUCEFAF'),false);
}
function ZWNTMRMLZT_Valid(e) {
SetActiveField(Ctrl('ZWNTMRMLZT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMDOCUM','C',w_NUMDOCUM,HtW(Ctrl('ZWNTMRMLZT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMDOCUM(HtW(Ctrl('ZWNTMRMLZT').value,'C'),null,e);
return l_bSetResult;
}
}
function ZWNTMRMLZT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZWNTMRMLZT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZWNTMRMLZT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZWNTMRMLZT'),e);
}
function IWFQNNZEIO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('IWFQNNZEIO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('IWFQNNZEIO').value=ApplyPictureToDate(Ctrl('IWFQNNZEIO').value,TranslatePicture(datePattern),'IWFQNNZEIO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('IWFQNNZEIO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('IWFQNNZEIO');
}
}
}
SetActiveField(Ctrl('IWFQNNZEIO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARILASC','D',w_DATARILASC,HtW(Ctrl('IWFQNNZEIO').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARILASC(HtW(Ctrl('IWFQNNZEIO').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function IWFQNNZEIO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IWFQNNZEIO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('IWFQNNZEIO',w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('IWFQNNZEIO');
SetActiveField(Ctrl('IWFQNNZEIO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IWFQNNZEIO'),e);
}
function DPXJJYNKQD_Valid(e) {
SetActiveField(Ctrl('DPXJJYNKQD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AUTRILASC','C',w_AUTRILASC,HtW(Ctrl('DPXJJYNKQD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUTRILASC(HtW(Ctrl('DPXJJYNKQD').value,'C'),null,e);
return l_bSetResult;
}
}
function DPXJJYNKQD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DPXJJYNKQD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DPXJJYNKQD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DPXJJYNKQD'),e);
}
function TFTPGRBHXL_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('TFTPGRBHXL'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('TFTPGRBHXL').value=ApplyPictureToDate(Ctrl('TFTPGRBHXL').value,TranslatePicture(datePattern),'TFTPGRBHXL');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('TFTPGRBHXL'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('TFTPGRBHXL');
}
}
}
SetActiveField(Ctrl('TFTPGRBHXL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAVALI','D',w_DATAVALI,HtW(Ctrl('TFTPGRBHXL').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAVALI(HtW(Ctrl('TFTPGRBHXL').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function TFTPGRBHXL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TFTPGRBHXL'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('TFTPGRBHXL',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('TFTPGRBHXL');
SetActiveField(Ctrl('TFTPGRBHXL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TFTPGRBHXL'),e);
}
function XWVSEMUYKF_Valid(e) {
SetActiveField(Ctrl('XWVSEMUYKF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('XWVSEMUYKF').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('XWVSEMUYKF').value,'C'),null,e);
return l_bSetResult;
}
}
function XWVSEMUYKF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XWVSEMUYKF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XWVSEMUYKF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XWVSEMUYKF'),e);
}
function TNGAQJNMOX_Valid(e) {
SetActiveField(Ctrl('TNGAQJNMOX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('TNGAQJNMOX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('TNGAQJNMOX').value,'C'),null,e);
return l_bSetResult;
}
}
function TNGAQJNMOX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TNGAQJNMOX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TNGAQJNMOX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TNGAQJNMOX'),e);
}
function TNGAQJNMOX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('TNGAQJNMOX')),'linkview_TNGAQJNMOX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function OVPWCHXBKI_Valid(e) {
SetActiveField(Ctrl('OVPWCHXBKI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('OVPWCHXBKI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('OVPWCHXBKI').value,'C'),null,e);
return l_bSetResult;
}
}
function OVPWCHXBKI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OVPWCHXBKI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OVPWCHXBKI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OVPWCHXBKI'),e);
}
function FVRVSFXLIG_Valid(e) {
SetActiveField(Ctrl('FVRVSFXLIG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP','C',w_CAP,HtW(Ctrl('FVRVSFXLIG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('FVRVSFXLIG').value,'C'),null,e);
return l_bSetResult;
}
}
function FVRVSFXLIG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FVRVSFXLIG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FVRVSFXLIG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FVRVSFXLIG'),e);
}
function BZUPXAPSJB_Valid(e) {
SetActiveField(Ctrl('BZUPXAPSJB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('BZUPXAPSJB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('BZUPXAPSJB').value,'C'),null,e);
return l_bSetResult;
}
}
function BZUPXAPSJB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BZUPXAPSJB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BZUPXAPSJB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BZUPXAPSJB'),e);
}
function BZUPXAPSJB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BZUPXAPSJB')),'linkview_BZUPXAPSJB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function XCOFZIDOBL_wrap_Valid(event) {
return XCOFZIDOBL_Valid(event);
}
SPBOUILib.SetInputExit('XCOFZIDOBL',XCOFZIDOBL_wrap_Valid,SPBOUILib.Row.IN_GRID);
function XCOFZIDOBL_wrap_OnFocus(event) {
return XCOFZIDOBL_OnFocus(event);
}
SPBOUILib.SetInputEnter('XCOFZIDOBL',XCOFZIDOBL_wrap_OnFocus,SPBOUILib.Row.IN_GRID);
function XCOFZIDOBL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XCOFZIDOBL',XCOFZIDOBL_wrap_OnKeyDown,SPBOUILib.Row.IN_GRID);
function XCOFZIDOBL_ZOOM_setHandlers() {
function XCOFZIDOBL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XCOFZIDOBL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XCOFZIDOBL_ZOOM',XCOFZIDOBL_ZOOM_wrap_OnClick,SPBOUILib.Row.IN_GRID);
}
SPBOUILib.SetPicker('XCOFZIDOBL',XCOFZIDOBL_ZOOM_setHandlers);
function NLQNUCEFAF_wrap_Valid(event) {
return NLQNUCEFAF_Valid(event);
}
SPBOUILib.SetComboChange('NLQNUCEFAF',NLQNUCEFAF_wrap_Valid);
function NLQNUCEFAF_wrap_OnFocus(event) {
return NLQNUCEFAF_OnFocus(event);
}
SPBOUILib.SetInputEnter('NLQNUCEFAF',NLQNUCEFAF_wrap_OnFocus);
function NLQNUCEFAF_wrap_Blur(event) {
return NLQNUCEFAF_OnBlur(event);
}
SPBOUILib.SetInputExit('NLQNUCEFAF',NLQNUCEFAF_wrap_Blur);
function ZWNTMRMLZT_wrap_Valid(event) {
return ZWNTMRMLZT_Valid(event);
}
SPBOUILib.SetInputExit('ZWNTMRMLZT',ZWNTMRMLZT_wrap_Valid);
function ZWNTMRMLZT_wrap_OnFocus(event) {
return ZWNTMRMLZT_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZWNTMRMLZT',ZWNTMRMLZT_wrap_OnFocus);
function ZWNTMRMLZT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZWNTMRMLZT',ZWNTMRMLZT_wrap_OnKeyDown);
function IWFQNNZEIO_wrap_Valid(event) {
return IWFQNNZEIO_Valid(event);
}
SPBOUILib.SetInputExit('IWFQNNZEIO',IWFQNNZEIO_wrap_Valid);
function IWFQNNZEIO_wrap_OnFocus(event) {
return IWFQNNZEIO_OnFocus(event);
}
SPBOUILib.SetInputEnter('IWFQNNZEIO',IWFQNNZEIO_wrap_OnFocus);
function IWFQNNZEIO_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('IWFQNNZEIO',IWFQNNZEIO_wrap_OnKeyPress);
function IWFQNNZEIO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('IWFQNNZEIO',IWFQNNZEIO_wrap_OnKeyDown);
function DPXJJYNKQD_wrap_Valid(event) {
return DPXJJYNKQD_Valid(event);
}
SPBOUILib.SetInputExit('DPXJJYNKQD',DPXJJYNKQD_wrap_Valid);
function DPXJJYNKQD_wrap_OnFocus(event) {
return DPXJJYNKQD_OnFocus(event);
}
SPBOUILib.SetInputEnter('DPXJJYNKQD',DPXJJYNKQD_wrap_OnFocus);
function DPXJJYNKQD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DPXJJYNKQD',DPXJJYNKQD_wrap_OnKeyDown);
function TFTPGRBHXL_wrap_Valid(event) {
return TFTPGRBHXL_Valid(event);
}
SPBOUILib.SetInputExit('TFTPGRBHXL',TFTPGRBHXL_wrap_Valid);
function TFTPGRBHXL_wrap_OnFocus(event) {
return TFTPGRBHXL_OnFocus(event);
}
SPBOUILib.SetInputEnter('TFTPGRBHXL',TFTPGRBHXL_wrap_OnFocus);
function TFTPGRBHXL_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('TFTPGRBHXL',TFTPGRBHXL_wrap_OnKeyPress);
function TFTPGRBHXL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('TFTPGRBHXL',TFTPGRBHXL_wrap_OnKeyDown);
function XWVSEMUYKF_wrap_Valid(event) {
return XWVSEMUYKF_Valid(event);
}
SPBOUILib.SetInputExit('XWVSEMUYKF',XWVSEMUYKF_wrap_Valid);
function XWVSEMUYKF_wrap_OnFocus(event) {
return XWVSEMUYKF_OnFocus(event);
}
SPBOUILib.SetInputEnter('XWVSEMUYKF',XWVSEMUYKF_wrap_OnFocus);
function XWVSEMUYKF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XWVSEMUYKF',XWVSEMUYKF_wrap_OnKeyDown);
function TNGAQJNMOX_wrap_Valid(event) {
return TNGAQJNMOX_Valid(event);
}
SPBOUILib.SetInputExit('TNGAQJNMOX',TNGAQJNMOX_wrap_Valid);
function TNGAQJNMOX_wrap_OnFocus(event) {
return TNGAQJNMOX_OnFocus(event);
}
SPBOUILib.SetInputEnter('TNGAQJNMOX',TNGAQJNMOX_wrap_OnFocus);
function TNGAQJNMOX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TNGAQJNMOX',TNGAQJNMOX_wrap_OnKeyDown);
function TNGAQJNMOX_ZOOM_setHandlers() {
function TNGAQJNMOX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?TNGAQJNMOX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('TNGAQJNMOX_ZOOM',TNGAQJNMOX_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('TNGAQJNMOX',TNGAQJNMOX_ZOOM_setHandlers);
function OVPWCHXBKI_wrap_Valid(event) {
return OVPWCHXBKI_Valid(event);
}
SPBOUILib.SetInputExit('OVPWCHXBKI',OVPWCHXBKI_wrap_Valid);
function OVPWCHXBKI_wrap_OnFocus(event) {
return OVPWCHXBKI_OnFocus(event);
}
SPBOUILib.SetInputEnter('OVPWCHXBKI',OVPWCHXBKI_wrap_OnFocus);
function OVPWCHXBKI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OVPWCHXBKI',OVPWCHXBKI_wrap_OnKeyDown);
function FVRVSFXLIG_wrap_Valid(event) {
return FVRVSFXLIG_Valid(event);
}
SPBOUILib.SetInputExit('FVRVSFXLIG',FVRVSFXLIG_wrap_Valid);
function FVRVSFXLIG_wrap_OnFocus(event) {
return FVRVSFXLIG_OnFocus(event);
}
SPBOUILib.SetInputEnter('FVRVSFXLIG',FVRVSFXLIG_wrap_OnFocus);
function FVRVSFXLIG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FVRVSFXLIG',FVRVSFXLIG_wrap_OnKeyDown);
function BZUPXAPSJB_wrap_Valid(event) {
return BZUPXAPSJB_Valid(event);
}
SPBOUILib.SetInputExit('BZUPXAPSJB',BZUPXAPSJB_wrap_Valid);
function BZUPXAPSJB_wrap_OnFocus(event) {
return BZUPXAPSJB_OnFocus(event);
}
SPBOUILib.SetInputEnter('BZUPXAPSJB',BZUPXAPSJB_wrap_OnFocus);
function BZUPXAPSJB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BZUPXAPSJB',BZUPXAPSJB_wrap_OnKeyDown);
function BZUPXAPSJB_ZOOM_setHandlers() {
function BZUPXAPSJB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BZUPXAPSJB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BZUPXAPSJB_ZOOM',BZUPXAPSJB_ZOOM_wrap_OnClick);
}
SPBOUILib.SetPicker('BZUPXAPSJB',BZUPXAPSJB_ZOOM_setHandlers);
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
m_oFather.i_last_focused_item='child_ardt_xocopebo';
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
windowOpenForeground('../doc/ardt_xocopebo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_NUMPROG=a[0];
w_CONNESCLI=a[1];
w_TIPODOC=a[2];
w_NUMDOCUM=a[3];
w_DATARILASC=a[4];
w_AUTRILASC=a[5];
w_DATAVALI=a[6];
w_DOMICILIO=a[7];
w_DESCCIT=a[8];
w_PROVINCIA=a[9];
w_CAP=a[10];
w_PAESE=a[11];
w_xRagSocDoc=a[12];
w_dessta=a[13];
m_PrimaryKeys=['CONNESCLI','NUMPROG'];
}
function i_PrimaryKey() {
return 'xocopebo'+'\\'+CPLib.ToCPStr(w_NUMPROG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('ardt_xocopebo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESCLI,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRagSocDoc,'C'); },"field":"RAGSOC","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"XCOFZIDOBL"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_PROVINCIA,'C'); },"field":"PROV","type":"C"},{"expression":function() { return WtA(w_CAP,'C'); },"field":"CAP","type":"C"},{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"TNGAQJNMOX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"itemRepeated":true,"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"BZUPXAPSJB"});
}
function FocusFirstDetailComponent() {
var candidatesToFocus = ["XCOFZIDOBL"];
SetControlFocus(candidatesToFocus);
}
IsRepeatedChild.child=[];
function GetFullRowMsgError() {
return 'MSG_FULLROW_NOT_SAT';
}
_Obli('AUTRILASC',0,'DPXJJYNKQD',false,"10032163180")
_Obli('CONNESCLI',0,'XCOFZIDOBL',false,"10534477837")
_Obli('TIPODOC',0,'NLQNUCEFAF',false,"11429032151")
_Obli('NUMDOCUM',0,'ZWNTMRMLZT',false,"1734932797")
_Obli('DATARILASC',2,'IWFQNNZEIO',false,"1690077224")
_Obli('DOMICILIO',0,'XWVSEMUYKF',false,"554236824")
_Obli('PAESE',0,'BZUPXAPSJB',false,"7776403")
_Obli('DATAVALI',2,'TFTPGRBHXL',false,"1216938285")
_Obli('DESCCIT',0,'TNGAQJNMOX',false,"15186643")
_Obli('PROVINCIA',0,'OVPWCHXBKI',false,"10095365423")
_Obli('CAP',0,'FVRVSFXLIG',false,"21587")
