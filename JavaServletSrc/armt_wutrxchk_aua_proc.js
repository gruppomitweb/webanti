function FillCombosValues() {
FillCombo('TTQTFXMWFO','TTQTFXMWFO');
FillCombo('QVAFKIBICA','QVAFKIBICA');
FillCombo('GYMTADSNZN','GYMTADSNZN');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LPQRPTUZNB',function(){return WtH(w_TRXCODPRG,'N',15,0,'999999999999999')},w_TRXCODPRG);
SPBOUILib.SetInputValue('OAJHZGVXDW',function(){return WtH(w_TRXCOGNOM,'C',50,0,'')},w_TRXCOGNOM);
SPBOUILib.SetInputValue('IJWHZPPSVS',function(){return WtH(w_TRXNOME,'C',50,0,'')},w_TRXNOME);
if(c=Ctrl('GOZRBLFKLS')) ChkboxCheckUncheck(c,'S',w_TRXFLGCF)
if(c=Ctrl('GOZRBLFKLS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('NIGZXFUTGU',function(){return WtH(w_TRXCODFIS,'C',16,0,'')},w_TRXCODFIS);
SPBOUILib.SetInputValue('CAICHGXWXW',function(){return WtH(w_TRXLUONAS,'C',50,0,'')},w_TRXLUONAS);
SPBOUILib.SetInputValue('QWQZUBRCXK',function(){return WtH(w_TRXNUMDOC,'C',30,0,'')},w_TRXNUMDOC);
SPBOUILib.SetInputValue('EMCTEYNINS',function(){return WtH(w_TRXDATSCA,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATSCA);
SPBOUILib.SetInputValue('ETDFWVULIM',function(){return WtH(w_TRXDATRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATRIL);
if(c=Ctrl('TTQTFXMWFO')) selectCombo(c,w_TRXTIPDOC,'C')
SPBOUILib.SetInputValue('YZULLMXBBH',function(){return WtH(w_TRXMTCN,'C',10,0,'')},w_TRXMTCN);
SPBOUILib.SetInputValue('BYTTMKVPJF',function(){return WtH(w_TRXDATNAS,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATNAS);
SPBOUILib.SetInputValue('VUPAGTECJJ',function(){return WtH(w_TRXDATOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRXDATOPE);
if(c=Ctrl('ATGEKSLXET')) selectCombo(c,w_TRXSESSO,'C')
if(c=Ctrl('QVAFKIBICA')) selectCombo(c,w_doctype,'C')
if(c=Ctrl('CMGWBYDKHQ')) ChkboxCheckUncheck(c,'S',w_TRXFLGFOR)
if(c=Ctrl('CMGWBYDKHQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('GYMTADSNZN')) selectCombo(c,w_TRXFORCE,'C')
SPBOUILib.SetInputValue('ZEJILKQXXT',function(){return WtH(w_xTRXPROVINCIA,'C',2,0,'')},w_xTRXPROVINCIA);
if(c=Ctrl('PPLBWAIBLM')) ChkboxCheckUncheck(c,'S',w_FLGDATIOLD)
if(c=Ctrl('PPLBWAIBLM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('HUXCGVAMUP',function(){return WtH(w_xtipdoc,'C',2,0,'')},w_xtipdoc);
SPBOUILib.SetInputValue('FKGNMENYXR',function(){return WtH(w_xtnumdoc,'C',15,0,'')},w_xtnumdoc);
SPBOUILib.SetInputValue('EMFAOZJHRN',function(){return WtH(w_TRXTFINLAV,'T',14,0,TranslatePicture(GetDatePicture(true,'T'),'T'))},w_TRXTFINLAV);
SPBOUILib.SetInputValue('WCMXGFBEVX',function(){return WtH(w_TRDFINLAV,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_TRDFINLAV);
SPBOUILib.SetInputValue('ZGTJLSVSXA',function(){return WtH(w_TRFLGINLAV,'C',1,0,'')},w_TRFLGINLAV);
SPBOUILib.SetInputValue('FMRBWPDSBR',function(){return WtH(w_TRXFLGAUA,'C',1,0,'')},w_TRXFLGAUA);
SPBOUILib.SetInputValue('XONXBNGAAH',function(){return WtH(w_TRXESITO,'C',1,0,'')},w_TRXESITO);
SPBOUILib.SetInputValue('OHDLYDFRFV',function(){return WtH(w_TRXAUTRIL,'C',50,0,'')},w_TRXAUTRIL);
SPBOUILib.SetInputValue('PXDVUJVPPR',function(){return WtH(w_xDESCRIZ,'C',30,0,'')},w_xDESCRIZ);
SPBOUILib.SetInputValue('HZPBCLSNRS',function(){return WtH(w_TRXCODDIP,'C',10,0,'')},w_TRXCODDIP);
SPBOUILib.SetInputValue('ZDYTXRRFLT',function(){return WtH(w_finalized,'C',1,0,'')},w_finalized);
SPBOUILib.SetInputValue('BLTFRBAHBH',function(){return WtH(w_xluonas,'C',50,0,'')},w_xluonas);
if(c=Ctrl('TQMBDRYXLU')) ChkboxCheckUncheck(c,'S',w_TRXFLGCON)
if(c=Ctrl('TQMBDRYXLU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('EPEPXVTDDF')) selectCombo(c,w_TRSSEGNO,'C')
SPBOUILib.SetInputValue('FNVGSTOZTQ',function(){return WtH(w_TRXIMPORTO,'N',15,2,'999999999999.99')},w_TRXIMPORTO);
SPBOUILib.SetInputValue('EVKHOJDUVF',function(){return WtH(w_TRXCONTAN,'N',15,2,'999999999999.99')},w_TRXCONTAN);
SPBOUILib.SetInputValue('FCRFUHHVHU',function(){return WtH(w_TRXUNIQUE,'C',10,0,'')},w_TRXUNIQUE);
SPBOUILib.SetInputValue('LGVQVJPZZP',function(){return WtH(w_TRXCOGCON,'C',100,0,'')},w_TRXCOGCON);
SPBOUILib.SetInputValue('OKKVRBSRDN',function(){return WtH(w_TRXNOMCON,'C',100,0,'')},w_TRXNOMCON);
SPBOUILib.SetInputValue('FDXEUOOSVN',function(){return WtH(w_TRXDESTIN,'C',100,0,'')},w_TRXDESTIN);
SPBOUILib.SetInputValue('UTGSXNXPVT',function(){return WtH(w_TRXCODCAS,'C',4,0,'')},w_TRXCODCAS);
if(c=Ctrl('FMRUIANURB')) selectCombo(c,w_TRXRECTYPE,'C')
SPBOUILib.SetInputValue('UTFQIBBLAF',function(){return WtH(w_TRXCODMAG,'C',5,0,'')},w_TRXCODMAG);
SPBOUILib.SetInputValue('NSNBJQWLKR',function(){return WtH(w_TRXCODUNI,'C',18,0,'')},w_TRXCODUNI);
SPBOUILib.SetInputValue('YUKRVYFISB',function(){return WtH(w_xMADESCRI,'C',60,0,'')},w_xMADESCRI);
SPBOUILib.SetInputValue('UUXGHAXWLH',function(){return WtH(w_TRXNAZRES,'C',50,0,'')},w_TRXNAZRES);
SPBOUILib.SetInputValue('XSZDOLIZKJ',function(){return WtH(w_TRXCITRES,'C',50,0,'')},w_TRXCITRES);
SPBOUILib.SetInputValue('AQPBKHBXWC',function(){return WtH(w_TRXDOMICI,'C',100,0,'')},w_TRXDOMICI);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('CMGWBYDKHQ_DIV',true);
SetDisplay(Ctrl('GUYNDNSZRL'),arfn_chkcodfis(w_TRXCODFIS,'086',0));
SetDisplay('PPLBWAIBLM_DIV',true);
SetDisplay(Ctrl('HUXCGVAMUP'),true || IsHiddenByStateDriver('xtipdoc'));
SetDisplay(Ctrl('FKGNMENYXR'),true || IsHiddenByStateDriver('xtnumdoc'));
SetDisplay(Ctrl('EMFAOZJHRN'),true || IsHiddenByStateDriver('TRXTFINLAV'));
SetDisplay(Ctrl('WCMXGFBEVX'),true || IsHiddenByStateDriver('TRDFINLAV'));
SetDisplay(Ctrl('ZGTJLSVSXA'),true || IsHiddenByStateDriver('TRFLGINLAV'));
SetDisplay(Ctrl('FMRBWPDSBR'),true || IsHiddenByStateDriver('TRXFLGAUA'));
SetDisplay(Ctrl('XONXBNGAAH'),true || IsHiddenByStateDriver('TRXESITO'));
SetDisplay(Ctrl('ZDYTXRRFLT'),true || IsHiddenByStateDriver('finalized'));
SetDisplay(Ctrl('BLTFRBAHBH'),true || IsHiddenByStateDriver('xluonas'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["TRSSEGNO"]=['HAJXBCFZUB'];
HideUI.lblids["TRXAUTRIL"]=['JQQNBNBWZZ'];
HideUI.lblids["TRXCITRES"]=['YSJTRGSOUR'];
HideUI.lblids["TRXCODCAS"]=['MEUEEEUOXT'];
HideUI.lblids["TRXCODDIP"]=['CKTPLYQSNF'];
HideUI.lblids["TRXCODFIS"]=['HOQDCOUNGL'];
HideUI.lblids["TRXCODMAG"]=['VIWNSSMTML'];
HideUI.lblids["TRXCODPRG"]=['NESFDLHKJF'];
HideUI.lblids["TRXCODUNI"]=['XIUAHOQEHG'];
HideUI.lblids["TRXCOGCON"]=['ZUININVXNT'];
HideUI.lblids["TRXCOGNOM"]=['COLILEINDD'];
HideUI.lblids["TRXCONTAN"]=['AIMDTEHGSW'];
HideUI.lblids["TRXDATNAS"]=['RWVGLFMUMW'];
HideUI.lblids["TRXDATOPE"]=['NRJSRMLPEW'];
HideUI.lblids["TRXDATRIL"]=['JGCMMJIMXW'];
HideUI.lblids["TRXDATSCA"]=['TUGPOVJSHM'];
HideUI.lblids["TRXDESTIN"]=['ZVELAFATZL'];
HideUI.lblids["TRXDOMICI"]=['YCSZPDCPKE'];
HideUI.lblids["TRXFLGCON"]=['HWRRLNPDOJ'];
HideUI.lblids["TRXFORCE"]=['VVELSWKIWG'];
HideUI.lblids["TRXIMPORTO"]=['TYFYRRXXWC'];
HideUI.lblids["TRXLUONAS"]=['WHFMFQMGTQ'];
HideUI.lblids["TRXMTCN"]=['DYDCEKIOPZ'];
HideUI.lblids["TRXNAZRES"]=['DMPAIYJLOW'];
HideUI.lblids["TRXNOMCON"]=['DSHVDLPTCM'];
HideUI.lblids["TRXNOME"]=['JWSTZAKUTI'];
HideUI.lblids["TRXNUMDOC"]=['DKXGIHHVGO'];
HideUI.lblids["TRXRECTYPE"]=['XXKUBGHLZL'];
HideUI.lblids["TRXSESSO"]=['UWFFZZSTIY'];
HideUI.lblids["TRXTIPDOC"]=['FQDGNGQULN'];
HideUI.lblids["TRXUNIQUE"]=['ULSRWVYTMU'];
HideUI.lblids["doctype"]=['FLZZDEVWLH'];
HideUI.lblids["xTRXPROVINCIA"]=['VYEJURLTUG'];
function LPQRPTUZNB_Valid(e) {
SetActiveField(Ctrl('LPQRPTUZNB'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LPQRPTUZNB') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('TRXCODPRG','N',w_TRXCODPRG,HtW(Ctrl('LPQRPTUZNB').value,'N'),m_bQueryOnLatestKeyOnly);
}
}
}
function LPQRPTUZNB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LPQRPTUZNB'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('LPQRPTUZNB',w_TRXCODPRG,'N',15,0,'999999999999999');
SetActiveField(Ctrl('LPQRPTUZNB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LPQRPTUZNB'),e);
}
function LPQRPTUZNB_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999999"));
}
function OAJHZGVXDW_Valid(e) {
SetActiveField(Ctrl('OAJHZGVXDW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCOGNOM','C',w_TRXCOGNOM,HtW(Ctrl('OAJHZGVXDW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCOGNOM(HtW(Ctrl('OAJHZGVXDW').value,'C'),null,e);
return l_bSetResult;
}
}
function OAJHZGVXDW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OAJHZGVXDW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OAJHZGVXDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OAJHZGVXDW'),e);
}
function IJWHZPPSVS_Valid(e) {
SetActiveField(Ctrl('IJWHZPPSVS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXNOME','C',w_TRXNOME,HtW(Ctrl('IJWHZPPSVS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXNOME(HtW(Ctrl('IJWHZPPSVS').value,'C'),null,e);
return l_bSetResult;
}
}
function IJWHZPPSVS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IJWHZPPSVS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IJWHZPPSVS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IJWHZPPSVS'),e);
}
function GOZRBLFKLS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFLGCF','C',w_TRXFLGCF,ChkboxValueAssign(Ctrl('GOZRBLFKLS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFLGCF(ChkboxValueAssign(Ctrl('GOZRBLFKLS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function GOZRBLFKLS_OnFocus(e) {
SetActiveField(Ctrl('GOZRBLFKLS'),true);
}
function GOZRBLFKLS_OnBlur(e) {
SetActiveField(Ctrl('GOZRBLFKLS'),false);
}
function NIGZXFUTGU_Valid(e) {
SetActiveField(Ctrl('NIGZXFUTGU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXCODFIS','C',w_TRXCODFIS,HtW(Ctrl('NIGZXFUTGU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXCODFIS(HtW(Ctrl('NIGZXFUTGU').value,'C'),null,e);
return l_bSetResult;
}
}
function NIGZXFUTGU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NIGZXFUTGU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NIGZXFUTGU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NIGZXFUTGU'),e);
}
function CAICHGXWXW_Valid(e) {
SuggesterLib.resetSuggest('CAICHGXWXW','CAICHGXWXW');
SetActiveField(Ctrl('CAICHGXWXW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXLUONAS','C',w_TRXLUONAS,HtW(Ctrl('CAICHGXWXW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXLUONAS(HtW(Ctrl('CAICHGXWXW').value,'C'),null,e);
return l_bSetResult;
}
}
function CAICHGXWXW_OnFocus(e) {
CAICHGXWXW_OnKeyUp.oldValue=HtW(Ctrl('CAICHGXWXW').value,'C');
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CAICHGXWXW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CAICHGXWXW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CAICHGXWXW'),e);
}
function CAICHGXWXW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CAICHGXWXW')),'linkview_CAICHGXWXW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function CAICHGXWXW_OnKeyUp(e) {
var evt = (window.event?window.event:e);
var newValue = HtW(Ctrl('CAICHGXWXW').value,'C');
if (Eq(newValue,CAICHGXWXW_OnKeyUp.oldValue)) {
return;
}
CAICHGXWXW_OnKeyUp.oldValue=newValue;
if ( ! (GetDisabled(Ctrl('CAICHGXWXW')) || IsMobile())) {
if (Gt(newValue.length,2)) {
SuggesterLib.callSuggest(Sugg_CAICHGXWXW,1);
} else {
SuggesterLib.resetSuggest('CAICHGXWXW','CAICHGXWXW');
}
}
}
function CAICHGXWXW_ValidSuggest(e) {
e=(window.event?window.event:e);
if (e) {
return SuggesterLib.select_suggest('CAICHGXWXW','CAICHGXWXW',-1,e);
}
}
function QWQZUBRCXK_Valid(e) {
SetActiveField(Ctrl('QWQZUBRCXK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXNUMDOC','C',w_TRXNUMDOC,HtW(Ctrl('QWQZUBRCXK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXNUMDOC(HtW(Ctrl('QWQZUBRCXK').value,'C'),null,e);
return l_bSetResult;
}
}
function QWQZUBRCXK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QWQZUBRCXK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QWQZUBRCXK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QWQZUBRCXK'),e);
}
function EMCTEYNINS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EMCTEYNINS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EMCTEYNINS').value=ApplyPictureToDate(Ctrl('EMCTEYNINS').value,TranslatePicture(datePattern),'EMCTEYNINS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('EMCTEYNINS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EMCTEYNINS');
}
}
}
SetActiveField(Ctrl('EMCTEYNINS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATSCA','D',w_TRXDATSCA,HtW(Ctrl('EMCTEYNINS').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATSCA(HtW(Ctrl('EMCTEYNINS').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function EMCTEYNINS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EMCTEYNINS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('EMCTEYNINS',w_TRXDATSCA,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('EMCTEYNINS');
SetActiveField(Ctrl('EMCTEYNINS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EMCTEYNINS'),e);
}
function EMCTEYNINS_ZOOM_Click() {
LaunchCalendar(Ctrl('EMCTEYNINS'));
}
function ETDFWVULIM_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ETDFWVULIM'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ETDFWVULIM').value=ApplyPictureToDate(Ctrl('ETDFWVULIM').value,TranslatePicture(datePattern),'ETDFWVULIM');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ETDFWVULIM'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ETDFWVULIM');
}
}
}
SetActiveField(Ctrl('ETDFWVULIM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATRIL','D',w_TRXDATRIL,HtW(Ctrl('ETDFWVULIM').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATRIL(HtW(Ctrl('ETDFWVULIM').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ETDFWVULIM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ETDFWVULIM'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ETDFWVULIM',w_TRXDATRIL,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ETDFWVULIM');
SetActiveField(Ctrl('ETDFWVULIM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ETDFWVULIM'),e);
}
function ETDFWVULIM_ZOOM_Click() {
LaunchCalendar(Ctrl('ETDFWVULIM'));
}
function TTQTFXMWFO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXTIPDOC','C',w_TRXTIPDOC,HtW(getComboValue(Ctrl('TTQTFXMWFO')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXTIPDOC(HtW(getComboValue(Ctrl('TTQTFXMWFO')),'C'),null,e);
return l_bSetResult;
}
}
function TTQTFXMWFO_OnFocus(e) {
SetActiveField(Ctrl('TTQTFXMWFO'),true);
}
function TTQTFXMWFO_OnBlur(e) {
SetActiveField(Ctrl('TTQTFXMWFO'),false);
}
function BYTTMKVPJF_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BYTTMKVPJF'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BYTTMKVPJF').value=ApplyPictureToDate(Ctrl('BYTTMKVPJF').value,TranslatePicture(datePattern),'BYTTMKVPJF');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BYTTMKVPJF'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BYTTMKVPJF');
}
}
}
SetActiveField(Ctrl('BYTTMKVPJF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXDATNAS','D',w_TRXDATNAS,HtW(Ctrl('BYTTMKVPJF').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXDATNAS(HtW(Ctrl('BYTTMKVPJF').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BYTTMKVPJF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYTTMKVPJF'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BYTTMKVPJF',w_TRXDATNAS,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BYTTMKVPJF');
SetActiveField(Ctrl('BYTTMKVPJF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYTTMKVPJF'),e);
}
function BYTTMKVPJF_ZOOM_Click() {
LaunchCalendar(Ctrl('BYTTMKVPJF'));
}
function ATGEKSLXET_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXSESSO','C',w_TRXSESSO,HtW(getComboValue(Ctrl('ATGEKSLXET')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXSESSO(HtW(getComboValue(Ctrl('ATGEKSLXET')),'C'),null,e);
return l_bSetResult;
}
}
function ATGEKSLXET_OnFocus(e) {
SetActiveField(Ctrl('ATGEKSLXET'),true);
}
function ATGEKSLXET_OnBlur(e) {
SetActiveField(Ctrl('ATGEKSLXET'),false);
}
function CMGWBYDKHQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFLGFOR','C',w_TRXFLGFOR,ChkboxValueAssign(Ctrl('CMGWBYDKHQ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFLGFOR(ChkboxValueAssign(Ctrl('CMGWBYDKHQ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CMGWBYDKHQ_OnFocus(e) {
SetActiveField(Ctrl('CMGWBYDKHQ'),true);
}
function CMGWBYDKHQ_OnBlur(e) {
SetActiveField(Ctrl('CMGWBYDKHQ'),false);
}
function GYMTADSNZN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFORCE','C',w_TRXFORCE,HtW(getComboValue(Ctrl('GYMTADSNZN')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFORCE(HtW(getComboValue(Ctrl('GYMTADSNZN')),'C'),null,e);
return l_bSetResult;
}
}
function GYMTADSNZN_OnFocus(e) {
SetActiveField(Ctrl('GYMTADSNZN'),true);
}
function GYMTADSNZN_OnBlur(e) {
SetActiveField(Ctrl('GYMTADSNZN'),false);
}
function PPLBWAIBLM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGDATIOLD','C',w_FLGDATIOLD,ChkboxValueAssign(Ctrl('PPLBWAIBLM'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGDATIOLD(ChkboxValueAssign(Ctrl('PPLBWAIBLM'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PPLBWAIBLM_OnFocus(e) {
SetActiveField(Ctrl('PPLBWAIBLM'),true);
}
function PPLBWAIBLM_OnBlur(e) {
SetActiveField(Ctrl('PPLBWAIBLM'),false);
}
function href_NAKIBNYQOP() {
SaveForced()
}
function HUXCGVAMUP_Valid(e) {
SetActiveField(Ctrl('HUXCGVAMUP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xtipdoc','C',w_xtipdoc,HtW(Ctrl('HUXCGVAMUP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xtipdoc(HtW(Ctrl('HUXCGVAMUP').value,'C'),null,e);
return l_bSetResult;
}
}
function HUXCGVAMUP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HUXCGVAMUP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HUXCGVAMUP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HUXCGVAMUP'),e);
}
function FKGNMENYXR_Valid(e) {
SetActiveField(Ctrl('FKGNMENYXR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xtnumdoc','C',w_xtnumdoc,HtW(Ctrl('FKGNMENYXR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xtnumdoc(HtW(Ctrl('FKGNMENYXR').value,'C'),null,e);
return l_bSetResult;
}
}
function FKGNMENYXR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FKGNMENYXR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FKGNMENYXR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FKGNMENYXR'),e);
}
function EMFAOZJHRN_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EMFAOZJHRN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
Ctrl('EMFAOZJHRN').value=ApplyPictureToDateTime(Ctrl('EMFAOZJHRN').value,TranslatePicture(dateTimePattern),'EMFAOZJHRN');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal) {
CheckDateValidity(Ctrl('EMFAOZJHRN'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EMFAOZJHRN');
}
}
}
SetActiveField(Ctrl('EMFAOZJHRN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXTFINLAV','T',w_TRXTFINLAV,HtW(Ctrl('EMFAOZJHRN').value,'T'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXTFINLAV(HtW(Ctrl('EMFAOZJHRN').value,'T'),null,e) && dateisok;
return l_bSetResult;
}
}
function EMFAOZJHRN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EMFAOZJHRN'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.datetimeLocal)) {
SPBOUILib.WtH('EMFAOZJHRN',w_TRXTFINLAV,'T',14,0,TranslatePicture(GetDatePicture(false,'T'),'T'));
}
m_oEnteredInDate=Ctrl('EMFAOZJHRN');
SetActiveField(Ctrl('EMFAOZJHRN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EMFAOZJHRN'),e);
}
function WCMXGFBEVX_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('WCMXGFBEVX'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('WCMXGFBEVX').value=ApplyPictureToDate(Ctrl('WCMXGFBEVX').value,TranslatePicture(datePattern),'WCMXGFBEVX');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('WCMXGFBEVX'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('WCMXGFBEVX');
}
}
}
SetActiveField(Ctrl('WCMXGFBEVX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRDFINLAV','D',w_TRDFINLAV,HtW(Ctrl('WCMXGFBEVX').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRDFINLAV(HtW(Ctrl('WCMXGFBEVX').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function WCMXGFBEVX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WCMXGFBEVX'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('WCMXGFBEVX',w_TRDFINLAV,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('WCMXGFBEVX');
SetActiveField(Ctrl('WCMXGFBEVX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WCMXGFBEVX'),e);
}
function ZGTJLSVSXA_Valid(e) {
SetActiveField(Ctrl('ZGTJLSVSXA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRFLGINLAV','C',w_TRFLGINLAV,HtW(Ctrl('ZGTJLSVSXA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRFLGINLAV(HtW(Ctrl('ZGTJLSVSXA').value,'C'),null,e);
return l_bSetResult;
}
}
function ZGTJLSVSXA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZGTJLSVSXA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZGTJLSVSXA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZGTJLSVSXA'),e);
}
function FMRBWPDSBR_Valid(e) {
SetActiveField(Ctrl('FMRBWPDSBR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXFLGAUA','C',w_TRXFLGAUA,HtW(Ctrl('FMRBWPDSBR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXFLGAUA(HtW(Ctrl('FMRBWPDSBR').value,'C'),null,e);
return l_bSetResult;
}
}
function FMRBWPDSBR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FMRBWPDSBR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FMRBWPDSBR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FMRBWPDSBR'),e);
}
function XONXBNGAAH_Valid(e) {
SetActiveField(Ctrl('XONXBNGAAH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TRXESITO','C',w_TRXESITO,HtW(Ctrl('XONXBNGAAH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TRXESITO(HtW(Ctrl('XONXBNGAAH').value,'C'),null,e);
return l_bSetResult;
}
}
function XONXBNGAAH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XONXBNGAAH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('XONXBNGAAH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XONXBNGAAH'),e);
}
function href_BEDRTSBAMO() {
SaveFinalize()
}
function ZDYTXRRFLT_Valid(e) {
SetActiveField(Ctrl('ZDYTXRRFLT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('finalized','C',w_finalized,HtW(Ctrl('ZDYTXRRFLT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_finalized(HtW(Ctrl('ZDYTXRRFLT').value,'C'),null,e);
return l_bSetResult;
}
}
function ZDYTXRRFLT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ZDYTXRRFLT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ZDYTXRRFLT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ZDYTXRRFLT'),e);
}
function BLTFRBAHBH_Valid(e) {
SetActiveField(Ctrl('BLTFRBAHBH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('xluonas','C',w_xluonas,HtW(Ctrl('BLTFRBAHBH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_xluonas(HtW(Ctrl('BLTFRBAHBH').value,'C'),null,e);
return l_bSetResult;
}
}
function BLTFRBAHBH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BLTFRBAHBH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BLTFRBAHBH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BLTFRBAHBH'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
function NAKIBNYQOP_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_NAKIBNYQOP():void(0));
}
SPBOUILib.SetImageClick('NAKIBNYQOP',NAKIBNYQOP_wrap_OnClick);
function NAKIBNYQOP_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('NAKIBNYQOP',NAKIBNYQOP_wrap_OnKeyDown);
function BEDRTSBAMO_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_BEDRTSBAMO():void(0));
}
SPBOUILib.SetImageClick('BEDRTSBAMO',BEDRTSBAMO_wrap_OnClick);
function BEDRTSBAMO_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BEDRTSBAMO',BEDRTSBAMO_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function LPQRPTUZNB_wrap_Valid(event) {
return LPQRPTUZNB_Valid(event);
}
SPBOUILib.SetInputExit('LPQRPTUZNB',LPQRPTUZNB_wrap_Valid);
function LPQRPTUZNB_wrap_OnFocus(event) {
return LPQRPTUZNB_OnFocus(event);
}
SPBOUILib.SetInputEnter('LPQRPTUZNB',LPQRPTUZNB_wrap_OnFocus);
function LPQRPTUZNB_wrap_OnKeyPress(event) {
return LPQRPTUZNB_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('LPQRPTUZNB',LPQRPTUZNB_wrap_OnKeyPress);
function LPQRPTUZNB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LPQRPTUZNB',LPQRPTUZNB_wrap_OnKeyDown);
function OAJHZGVXDW_wrap_Valid(event) {
return OAJHZGVXDW_Valid(event);
}
SPBOUILib.SetInputExit('OAJHZGVXDW',OAJHZGVXDW_wrap_Valid);
function OAJHZGVXDW_wrap_OnFocus(event) {
return OAJHZGVXDW_OnFocus(event);
}
SPBOUILib.SetInputEnter('OAJHZGVXDW',OAJHZGVXDW_wrap_OnFocus);
function OAJHZGVXDW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OAJHZGVXDW',OAJHZGVXDW_wrap_OnKeyDown);
function IJWHZPPSVS_wrap_Valid(event) {
return IJWHZPPSVS_Valid(event);
}
SPBOUILib.SetInputExit('IJWHZPPSVS',IJWHZPPSVS_wrap_Valid);
function IJWHZPPSVS_wrap_OnFocus(event) {
return IJWHZPPSVS_OnFocus(event);
}
SPBOUILib.SetInputEnter('IJWHZPPSVS',IJWHZPPSVS_wrap_OnFocus);
function IJWHZPPSVS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IJWHZPPSVS',IJWHZPPSVS_wrap_OnKeyDown);
function GOZRBLFKLS_wrap_Valid(event) {
return GOZRBLFKLS_Valid(event);
}
SPBOUILib.SetCheckboxClick('GOZRBLFKLS',GOZRBLFKLS_wrap_Valid);
function GOZRBLFKLS_wrap_OnFocus(event) {
return GOZRBLFKLS_OnFocus(event);
}
SPBOUILib.SetInputEnter('GOZRBLFKLS',GOZRBLFKLS_wrap_OnFocus);
function GOZRBLFKLS_wrap_Blur(event) {
return GOZRBLFKLS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GOZRBLFKLS',GOZRBLFKLS_wrap_Blur);
function NIGZXFUTGU_wrap_Valid(event) {
return NIGZXFUTGU_Valid(event);
}
SPBOUILib.SetInputExit('NIGZXFUTGU',NIGZXFUTGU_wrap_Valid);
function NIGZXFUTGU_wrap_OnFocus(event) {
return NIGZXFUTGU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NIGZXFUTGU',NIGZXFUTGU_wrap_OnFocus);
function NIGZXFUTGU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NIGZXFUTGU',NIGZXFUTGU_wrap_OnKeyDown);
function CAICHGXWXW_wrap_Valid(event) {
return CAICHGXWXW_Valid(event);
}
SPBOUILib.SetInputExit('CAICHGXWXW',CAICHGXWXW_wrap_Valid);
function CAICHGXWXW_wrap_OnFocus(event) {
return CAICHGXWXW_OnFocus(event);
}
SPBOUILib.SetInputEnter('CAICHGXWXW',CAICHGXWXW_wrap_OnFocus);
function CAICHGXWXW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CAICHGXWXW',CAICHGXWXW_wrap_OnKeyDown);
function CAICHGXWXW_ZOOM_setHandlers() {
function CAICHGXWXW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CAICHGXWXW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CAICHGXWXW_ZOOM',CAICHGXWXW_ZOOM_wrap_OnClick);
function CAICHGXWXW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CAICHGXWXW_ZOOM',CAICHGXWXW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CAICHGXWXW',CAICHGXWXW_ZOOM_setHandlers);
SPBOUILib.SetInputKeyUp('CAICHGXWXW',function(event) {
  return (Eq(m_cFunction,'edit') || Eq(m_cFunction,'new')?CAICHGXWXW_OnKeyUp(event):void(0));
});
function QWQZUBRCXK_wrap_Valid(event) {
return QWQZUBRCXK_Valid(event);
}
SPBOUILib.SetInputExit('QWQZUBRCXK',QWQZUBRCXK_wrap_Valid);
function QWQZUBRCXK_wrap_OnFocus(event) {
return QWQZUBRCXK_OnFocus(event);
}
SPBOUILib.SetInputEnter('QWQZUBRCXK',QWQZUBRCXK_wrap_OnFocus);
function QWQZUBRCXK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QWQZUBRCXK',QWQZUBRCXK_wrap_OnKeyDown);
function EMCTEYNINS_wrap_Valid(event) {
return EMCTEYNINS_Valid(event);
}
SPBOUILib.SetInputExit('EMCTEYNINS',EMCTEYNINS_wrap_Valid);
function EMCTEYNINS_wrap_OnFocus(event) {
return EMCTEYNINS_OnFocus(event);
}
SPBOUILib.SetInputEnter('EMCTEYNINS',EMCTEYNINS_wrap_OnFocus);
function EMCTEYNINS_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('EMCTEYNINS',EMCTEYNINS_wrap_OnKeyPress);
function EMCTEYNINS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('EMCTEYNINS',EMCTEYNINS_wrap_OnKeyDown);
function EMCTEYNINS_ZOOM_setHandlers() {
function EMCTEYNINS_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?EMCTEYNINS_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('EMCTEYNINS_ZOOM',EMCTEYNINS_ZOOM_wrap_OnClick);
function EMCTEYNINS_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('EMCTEYNINS_ZOOM',EMCTEYNINS_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('EMCTEYNINS',EMCTEYNINS_ZOOM_setHandlers);
function ETDFWVULIM_wrap_Valid(event) {
return ETDFWVULIM_Valid(event);
}
SPBOUILib.SetInputExit('ETDFWVULIM',ETDFWVULIM_wrap_Valid);
function ETDFWVULIM_wrap_OnFocus(event) {
return ETDFWVULIM_OnFocus(event);
}
SPBOUILib.SetInputEnter('ETDFWVULIM',ETDFWVULIM_wrap_OnFocus);
function ETDFWVULIM_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ETDFWVULIM',ETDFWVULIM_wrap_OnKeyPress);
function ETDFWVULIM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ETDFWVULIM',ETDFWVULIM_wrap_OnKeyDown);
function ETDFWVULIM_ZOOM_setHandlers() {
function ETDFWVULIM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ETDFWVULIM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ETDFWVULIM_ZOOM',ETDFWVULIM_ZOOM_wrap_OnClick);
function ETDFWVULIM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ETDFWVULIM_ZOOM',ETDFWVULIM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ETDFWVULIM',ETDFWVULIM_ZOOM_setHandlers);
function TTQTFXMWFO_wrap_Valid(event) {
return TTQTFXMWFO_Valid(event);
}
SPBOUILib.SetComboChange('TTQTFXMWFO',TTQTFXMWFO_wrap_Valid);
function TTQTFXMWFO_wrap_OnFocus(event) {
return TTQTFXMWFO_OnFocus(event);
}
SPBOUILib.SetInputEnter('TTQTFXMWFO',TTQTFXMWFO_wrap_OnFocus);
function TTQTFXMWFO_wrap_Blur(event) {
return TTQTFXMWFO_OnBlur(event);
}
SPBOUILib.SetInputExit('TTQTFXMWFO',TTQTFXMWFO_wrap_Blur);
function BYTTMKVPJF_wrap_Valid(event) {
return BYTTMKVPJF_Valid(event);
}
SPBOUILib.SetInputExit('BYTTMKVPJF',BYTTMKVPJF_wrap_Valid);
function BYTTMKVPJF_wrap_OnFocus(event) {
return BYTTMKVPJF_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYTTMKVPJF',BYTTMKVPJF_wrap_OnFocus);
function BYTTMKVPJF_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BYTTMKVPJF',BYTTMKVPJF_wrap_OnKeyPress);
function BYTTMKVPJF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BYTTMKVPJF',BYTTMKVPJF_wrap_OnKeyDown);
function BYTTMKVPJF_ZOOM_setHandlers() {
function BYTTMKVPJF_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BYTTMKVPJF_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BYTTMKVPJF_ZOOM',BYTTMKVPJF_ZOOM_wrap_OnClick);
function BYTTMKVPJF_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BYTTMKVPJF_ZOOM',BYTTMKVPJF_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BYTTMKVPJF',BYTTMKVPJF_ZOOM_setHandlers);
function ATGEKSLXET_wrap_Valid(event) {
return ATGEKSLXET_Valid(event);
}
SPBOUILib.SetComboChange('ATGEKSLXET',ATGEKSLXET_wrap_Valid);
function ATGEKSLXET_wrap_OnFocus(event) {
return ATGEKSLXET_OnFocus(event);
}
SPBOUILib.SetInputEnter('ATGEKSLXET',ATGEKSLXET_wrap_OnFocus);
function ATGEKSLXET_wrap_Blur(event) {
return ATGEKSLXET_OnBlur(event);
}
SPBOUILib.SetInputExit('ATGEKSLXET',ATGEKSLXET_wrap_Blur);
function CMGWBYDKHQ_wrap_Valid(event) {
return CMGWBYDKHQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('CMGWBYDKHQ',CMGWBYDKHQ_wrap_Valid);
function CMGWBYDKHQ_wrap_OnFocus(event) {
return CMGWBYDKHQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('CMGWBYDKHQ',CMGWBYDKHQ_wrap_OnFocus);
function CMGWBYDKHQ_wrap_Blur(event) {
return CMGWBYDKHQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CMGWBYDKHQ',CMGWBYDKHQ_wrap_Blur);
function GYMTADSNZN_wrap_Valid(event) {
return GYMTADSNZN_Valid(event);
}
SPBOUILib.SetComboChange('GYMTADSNZN',GYMTADSNZN_wrap_Valid);
function GYMTADSNZN_wrap_OnFocus(event) {
return GYMTADSNZN_OnFocus(event);
}
SPBOUILib.SetInputEnter('GYMTADSNZN',GYMTADSNZN_wrap_OnFocus);
function GYMTADSNZN_wrap_Blur(event) {
return GYMTADSNZN_OnBlur(event);
}
SPBOUILib.SetInputExit('GYMTADSNZN',GYMTADSNZN_wrap_Blur);
function PPLBWAIBLM_wrap_Valid(event) {
return PPLBWAIBLM_Valid(event);
}
SPBOUILib.SetCheckboxClick('PPLBWAIBLM',PPLBWAIBLM_wrap_Valid);
function PPLBWAIBLM_wrap_OnFocus(event) {
return PPLBWAIBLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('PPLBWAIBLM',PPLBWAIBLM_wrap_OnFocus);
function PPLBWAIBLM_wrap_Blur(event) {
return PPLBWAIBLM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PPLBWAIBLM',PPLBWAIBLM_wrap_Blur);
function HUXCGVAMUP_wrap_Valid(event) {
return HUXCGVAMUP_Valid(event);
}
SPBOUILib.SetInputExit('HUXCGVAMUP',HUXCGVAMUP_wrap_Valid);
function HUXCGVAMUP_wrap_OnFocus(event) {
return HUXCGVAMUP_OnFocus(event);
}
SPBOUILib.SetInputEnter('HUXCGVAMUP',HUXCGVAMUP_wrap_OnFocus);
function HUXCGVAMUP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HUXCGVAMUP',HUXCGVAMUP_wrap_OnKeyDown);
function FKGNMENYXR_wrap_Valid(event) {
return FKGNMENYXR_Valid(event);
}
SPBOUILib.SetInputExit('FKGNMENYXR',FKGNMENYXR_wrap_Valid);
function FKGNMENYXR_wrap_OnFocus(event) {
return FKGNMENYXR_OnFocus(event);
}
SPBOUILib.SetInputEnter('FKGNMENYXR',FKGNMENYXR_wrap_OnFocus);
function FKGNMENYXR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FKGNMENYXR',FKGNMENYXR_wrap_OnKeyDown);
function EMFAOZJHRN_wrap_Valid(event) {
return EMFAOZJHRN_Valid(event);
}
SPBOUILib.SetInputExit('EMFAOZJHRN',EMFAOZJHRN_wrap_Valid);
function EMFAOZJHRN_wrap_OnFocus(event) {
return EMFAOZJHRN_OnFocus(event);
}
SPBOUILib.SetInputEnter('EMFAOZJHRN',EMFAOZJHRN_wrap_OnFocus);
function EMFAOZJHRN_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('EMFAOZJHRN',EMFAOZJHRN_wrap_OnKeyPress);
function EMFAOZJHRN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('EMFAOZJHRN',EMFAOZJHRN_wrap_OnKeyDown);
function WCMXGFBEVX_wrap_Valid(event) {
return WCMXGFBEVX_Valid(event);
}
SPBOUILib.SetInputExit('WCMXGFBEVX',WCMXGFBEVX_wrap_Valid);
function WCMXGFBEVX_wrap_OnFocus(event) {
return WCMXGFBEVX_OnFocus(event);
}
SPBOUILib.SetInputEnter('WCMXGFBEVX',WCMXGFBEVX_wrap_OnFocus);
function WCMXGFBEVX_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('WCMXGFBEVX',WCMXGFBEVX_wrap_OnKeyPress);
function WCMXGFBEVX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('WCMXGFBEVX',WCMXGFBEVX_wrap_OnKeyDown);
function ZGTJLSVSXA_wrap_Valid(event) {
return ZGTJLSVSXA_Valid(event);
}
SPBOUILib.SetInputExit('ZGTJLSVSXA',ZGTJLSVSXA_wrap_Valid);
function ZGTJLSVSXA_wrap_OnFocus(event) {
return ZGTJLSVSXA_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZGTJLSVSXA',ZGTJLSVSXA_wrap_OnFocus);
function ZGTJLSVSXA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZGTJLSVSXA',ZGTJLSVSXA_wrap_OnKeyDown);
function FMRBWPDSBR_wrap_Valid(event) {
return FMRBWPDSBR_Valid(event);
}
SPBOUILib.SetInputExit('FMRBWPDSBR',FMRBWPDSBR_wrap_Valid);
function FMRBWPDSBR_wrap_OnFocus(event) {
return FMRBWPDSBR_OnFocus(event);
}
SPBOUILib.SetInputEnter('FMRBWPDSBR',FMRBWPDSBR_wrap_OnFocus);
function FMRBWPDSBR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FMRBWPDSBR',FMRBWPDSBR_wrap_OnKeyDown);
function XONXBNGAAH_wrap_Valid(event) {
return XONXBNGAAH_Valid(event);
}
SPBOUILib.SetInputExit('XONXBNGAAH',XONXBNGAAH_wrap_Valid);
function XONXBNGAAH_wrap_OnFocus(event) {
return XONXBNGAAH_OnFocus(event);
}
SPBOUILib.SetInputEnter('XONXBNGAAH',XONXBNGAAH_wrap_OnFocus);
function XONXBNGAAH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('XONXBNGAAH',XONXBNGAAH_wrap_OnKeyDown);
function ZDYTXRRFLT_wrap_Valid(event) {
return ZDYTXRRFLT_Valid(event);
}
SPBOUILib.SetInputExit('ZDYTXRRFLT',ZDYTXRRFLT_wrap_Valid);
function ZDYTXRRFLT_wrap_OnFocus(event) {
return ZDYTXRRFLT_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZDYTXRRFLT',ZDYTXRRFLT_wrap_OnFocus);
function ZDYTXRRFLT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ZDYTXRRFLT',ZDYTXRRFLT_wrap_OnKeyDown);
function BLTFRBAHBH_wrap_Valid(event) {
return BLTFRBAHBH_Valid(event);
}
SPBOUILib.SetInputExit('BLTFRBAHBH',BLTFRBAHBH_wrap_Valid);
function BLTFRBAHBH_wrap_OnFocus(event) {
return BLTFRBAHBH_OnFocus(event);
}
SPBOUILib.SetInputEnter('BLTFRBAHBH',BLTFRBAHBH_wrap_OnFocus);
function BLTFRBAHBH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BLTFRBAHBH',BLTFRBAHBH_wrap_OnKeyDown);
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
if (Ne(typeof(w_Cases),'undefined')) {
w_Cases.raiseEvent('armt_wutrxchk_aua_'+Strtran(p_cEvent,' ','_'));
}
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
FocusFirstComponent.edit={"page_1":["OAJHZGVXDW"]};
FocusFirstComponent.query={"page_1":["LPQRPTUZNB","OAJHZGVXDW"]};
FocusFirstComponent.otherwise={"page_1":["OAJHZGVXDW"]};
function Help() {
windowOpenForeground('../doc/armt_wutrxchk_aua_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
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
w_TRXCODPRG=a[0];
op_TRXCODPRG=a[1];
w_TRXCOGNOM=a[2];
w_TRXNOME=a[3];
w_TRXFLGCF=a[4];
w_TRXCODFIS=a[5];
w_TRXLUONAS=a[6];
w_TRXNUMDOC=a[7];
w_TRXDATSCA=a[8];
w_TRXDATRIL=a[9];
w_TRXTIPDOC=a[10];
w_TRXMTCN=a[11];
w_TRXDATNAS=a[12];
w_TRXDATOPE=a[13];
w_TRXFLGCON=a[14];
w_TRSSEGNO=a[15];
w_TRXIMPORTO=a[16];
w_TRXCONTAN=a[17];
w_TRXUNIQUE=a[18];
w_TRXCOGCON=a[19];
w_TRXNOMCON=a[20];
w_TRXDESTIN=a[21];
w_TRXCODCAS=a[22];
w_TRXRECTYPE=a[23];
w_TRXCODMAG=a[24];
w_TRXCODUNI=a[25];
w_TRXSESSO=a[26];
w_TRXNASSTATO=a[27];
w_TRXNASCOMUN=a[28];
w_TRXFLGAUAQ1=a[29];
w_TRXFLGAUAQ2=a[30];
w_TRXFLGAUAQ3=a[31];
w_TRXFLGAUAQ4=a[32];
w_TRXFLGAUAQ5=a[33];
w_TRXFLGAUA=a[34];
w_TRXFLGFOR=a[35];
w_TRXFORCE=a[36];
w_TRXDATRICERCA=a[37];
w_TRXNAZRES=a[38];
w_TRXCITRES=a[39];
w_TRXDOMICI=a[40];
w_TRXTFINLAV=a[41];
w_TRDFINLAV=a[42];
w_TRFLGINLAV=a[43];
w_TRXESITO=a[44];
w_TRXAUTRIL=a[45];
w_TRXCODDIP=a[46];
w_TRXUTENTE=a[47];
w_TRXTINILAV=a[48];
w_TRXDINILAV=a[49];
w_xMADESCRI=a[50];
w_doctype=a[51];
w_sesso=a[52];
w_xTRXPROVINCIA=a[53];
w_FLGDATIOLD=a[54];
w_xtipdoc=a[55];
w_xtnumdoc=a[56];
w_xDESCRIZ=a[57];
w_finalized=a[58];
w_xluonas=a[59];
if (Gt(a.length,60)) {
o_xtnumdoc=w_xtnumdoc;
o_TRXCODDIP=w_TRXCODDIP;
o_TRXCODMAG=w_TRXCODMAG;
o_TRXNAZRES=w_TRXNAZRES;
o_TRXCITRES=w_TRXCITRES;
}
m_PrimaryKeys=['TRXCODPRG'];
}
function i_PrimaryKey() {
return 'wutrxchk'+'\\'+CPLib.ToCPStr(w_TRXCODPRG);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wutrxchk_aua',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
l_aActions.push({"action":"href_NAKIBNYQOP","always":0,"forceid":true,"id":"NAKIBNYQOP","img":"..\/images\/force.png","important":true,"migrateTo":"","title":"6887734","tooltip":"6887734"});
l_aActions.push({"action":"href_BEDRTSBAMO","always":0,"forceid":true,"id":"BEDRTSBAMO","img":"..\/images\/final.png","important":true,"migrateTo":"","title":"553813303","tooltip":"553813303"});
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TRXLUONAS,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_xTRXPROVINCIA,'C'); },"field":"PROVINCIA","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbluonas','C'),"uid":"CAICHGXWXW"});
}
_Obli('xtnumdoc',0,'FKGNMENYXR',false)
_Obli('TRXCOGNOM',0,'OAJHZGVXDW',false,"1816546867")
_Obli('TRXNOME',0,'IJWHZPPSVS',false,"443454")
_Obli('TRXFLGCF',0,'GOZRBLFKLS',false,"1563406272")
_Obli('TRXCODFIS',0,'NIGZXFUTGU',false,"10782899903")
_Obli('TRXLUONAS',0,'CAICHGXWXW',false,"12123333988")
_Obli('TRXNUMDOC',0,'QWQZUBRCXK',false,"10759885763")
_Obli('TRXDATSCA',2,'EMCTEYNINS',false,"628384699")
_Obli('TRXDATRIL',2,'ETDFWVULIM',false,"10613332584")
_Obli('TRXTIPDOC',0,'TTQTFXMWFO',false,"11429032151")
_Obli('TRXESITO',0,'XONXBNGAAH',false,"125267528")
_Obli('TRXDATNAS',2,'BYTTMKVPJF',false,"10703188046")
_Obli('TRXFORCE',0,'GYMTADSNZN',true,"707662893",null,null,function() { return Eq(w_TRXFLGFOR,'S') })
_Obli('TRXSESSO',0,'ATGEKSLXET',false,"7776675")
_Obli('TRXFLGFOR',0,'CMGWBYDKHQ',false,"1636021524")
_Obli('TRXFLGAUA',0,'TZHYQAUMDE',false,"887948673")
_Obli('TRXFLGAUA',0,'FMRBWPDSBR',false,"753730945")
_Obli('TRFLGINLAV',0,'ZGTJLSVSXA',false,"11651685846")
_Obli('TRFLGINLAV',0,'RWTMBAJLQJ',false,"11651685846")
_Obli('TRDFINLAV',2,'WCMXGFBEVX',false,"10681623869")
_Obli('xtipdoc',0,'HUXCGVAMUP',false)
_Obli('finalized',0,'ZDYTXRRFLT',false)
_Obli('xluonas',0,'BLTFRBAHBH',false)
_Obli('TRXTFINLAV',3,'EMFAOZJHRN',false,"10847907928")
_Obli('FLGDATIOLD',0,'PPLBWAIBLM',false)
