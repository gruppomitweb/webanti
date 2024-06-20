function FillCombosValues() {
FillCombo('BDCVNEPJXV','BDCVNEPJXV');
FillCombo('DQASOJYMWJ','DQASOJYMWJ');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('RVOXKWUSWH',function(){return WtH(w_COLLEG,'C',16,0,'')},w_COLLEG);
var tmp_MHLZXPEYVJ = ToHTag(AsControlValue(w_xRAGSOC));
if (Ne(e_MHLZXPEYVJ,tmp_MHLZXPEYVJ)) {
SPBOUILib.SetLabelValue('MHLZXPEYVJ','innerHTML',tmp_MHLZXPEYVJ);
e_MHLZXPEYVJ=tmp_MHLZXPEYVJ;
}
SPBOUILib.SetInputValue('SZFKAURTJA',function(){return WtH(w_ANNO,'C',4,0,'')},w_ANNO);
SPBOUILib.SetInputValue('PXVUKDVPLL',function(){return WtH(w_CONNESOPER,'C',16,0,'')},w_CONNESOPER);
var tmp_VWGJZMZAPH = ToHTag(AsControlValue(w_xRAGSOC2));
if (Ne(e_VWGJZMZAPH,tmp_VWGJZMZAPH)) {
SPBOUILib.SetLabelValue('VWGJZMZAPH','innerHTML',tmp_VWGJZMZAPH);
e_VWGJZMZAPH=tmp_VWGJZMZAPH;
}
SPBOUILib.SetInputValue('ENOHXMETFI',function(){return WtH(w_SALDO,'N',17,0,'999,999,999,999')},w_SALDO);
SPBOUILib.SetInputValue('APWPUKFDMF',function(){return WtH(w_QUANTITA,'N',6,0,'')},w_QUANTITA);
if(c=Ctrl('BDCVNEPJXV')) selectCombo(c,w_VALUTA,'C')
SPBOUILib.SetInputValue('KXSLYMBVDR',function(){return WtH(w_UNIQUER,'C',50,0,'')},w_UNIQUER);
SPBOUILib.SetInputValue('IWGAASAAMD',function(){return WtH(w_OLDINTER,'C',16,0,'')},w_OLDINTER);
if(c=Ctrl('AIQQNOUGRA')) ChkboxCheckUncheck(c,1,w_INVIATO)
if(c=Ctrl('AIQQNOUGRA')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('OKHZSQAMSZ',function(){return WtH(w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAINVIO);
SPBOUILib.SetInputValue('NMPRSQUWWU',function(){return WtH(w_DATAMODI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAMODI);
if(c=Ctrl('FPJQZIYEKX')) ChkboxCheckUncheck(c,1,w_ANNULLA)
if(c=Ctrl('FPJQZIYEKX')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('ICEJVXXFJJ',function(){return WtH(w_DATAANNU,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAANNU);
SPBOUILib.SetInputValue('ECLOQFLQTF',function(){return WtH(w_IDESITO,'C',13,0,'')},w_IDESITO);
if(c=Ctrl('ZHVHNJYLBS')) ChkboxCheckUncheck(c,1,w_INVSALDO)
if(c=Ctrl('ZHVHNJYLBS')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('EIWTVZVLOO',function(){return WtH(w_DTSALDO,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DTSALDO);
SPBOUILib.SetInputValue('SQOAICWIPS',function(){return WtH(w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAOPE);
if(c=Ctrl('MQNULTJTDU')) ChkboxCheckUncheck(c,'S',w_CFESTERO)
if(c=Ctrl('MQNULTJTDU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DQASOJYMWJ')) selectCombo(c,w_NATURA,'C')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay(Ctrl('ERFGDWAQVY'),Ne(w_INVIATO,1));
SetDisplay(Ctrl('KINMWWRRUA'),(Eq(w_INVIATO,1) && Eq(w_ANNULLA,1)) || Eq(w_INVIATO,0));
SetDisplay(Ctrl('LJBUMZNQNX'),Ne(w_INVIATO,1));
SetDisplay(Ctrl('JZEQARRYBY'),Ne(w_ANNULLA,1) && Ne(m_cFunction,'view'));
SetDisplay(Ctrl('QNVJXJSDFW'),Ne(w_ANNULLA,1) && Ne(m_cFunction,'view'));
SetDisplay('YBDSVYFUDJ_DIV',IsHiddenByStateDriver('AltriDel'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ANNO"]=['KFXMICMFOS','PSCRBRMUQP'];
HideUI.lblids["COLLEG"]=['KJQITLYMMC'];
HideUI.lblids["CONNESOPER"]=['VFEQDOQQHZ'];
HideUI.lblids["DATAMODI"]=['NYVMCAHSOD'];
HideUI.lblids["IDESITO"]=['WBTEEHJNEK'];
HideUI.lblids["NATURA"]=['YGUICXLTAA'];
HideUI.lblids["OLDINTER"]=['CKCOZYZVSP'];
HideUI.lblids["QUANTITA"]=['BHGIVCPLNL'];
HideUI.lblids["SALDO"]=['ZSIUNZUBNS'];
HideUI.lblids["UNIQUER"]=['OXLMBKAUES'];
HideUI.lblids["VALUTA"]=['YKKUHDUDJP'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function RVOXKWUSWH_Valid(e) {
SetActiveField(Ctrl('RVOXKWUSWH'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('RVOXKWUSWH') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('COLLEG','C',w_COLLEG,HtW(Ctrl('RVOXKWUSWH').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COLLEG(HtW(Ctrl('RVOXKWUSWH').value,'C'),null,e);
return l_bSetResult;
}
}
function RVOXKWUSWH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RVOXKWUSWH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RVOXKWUSWH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RVOXKWUSWH'),e);
}
function RVOXKWUSWH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RVOXKWUSWH')),'linkview_RVOXKWUSWH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SZFKAURTJA_Valid(e) {
SetActiveField(Ctrl('SZFKAURTJA'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('SZFKAURTJA') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('ANNO','C',w_ANNO,HtW(Ctrl('SZFKAURTJA').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNO(HtW(Ctrl('SZFKAURTJA').value,'C'),null,e);
return l_bSetResult;
}
}
function SZFKAURTJA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SZFKAURTJA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SZFKAURTJA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SZFKAURTJA'),e);
}
function PXVUKDVPLL_Valid(e) {
SetActiveField(Ctrl('PXVUKDVPLL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONNESOPER','C',w_CONNESOPER,HtW(Ctrl('PXVUKDVPLL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNESOPER(HtW(Ctrl('PXVUKDVPLL').value,'C'),null,e);
return l_bSetResult;
}
}
function PXVUKDVPLL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PXVUKDVPLL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PXVUKDVPLL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PXVUKDVPLL'),e);
}
function PXVUKDVPLL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('PXVUKDVPLL')),'linkview_PXVUKDVPLL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ENOHXMETFI_Valid(e) {
SetActiveField(Ctrl('ENOHXMETFI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SALDO','N',w_SALDO,HtW(Ctrl('ENOHXMETFI').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SALDO(HtW(Ctrl('ENOHXMETFI').value,'N'),null,e);
return l_bSetResult;
}
}
function ENOHXMETFI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ENOHXMETFI'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ENOHXMETFI',w_SALDO,'N',17,0,'999999999999');
SetActiveField(Ctrl('ENOHXMETFI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ENOHXMETFI'),e);
}
function ENOHXMETFI_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999999"));
}
function APWPUKFDMF_Valid(e) {
SetActiveField(Ctrl('APWPUKFDMF'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('QUANTITA','N',w_QUANTITA,HtW(Ctrl('APWPUKFDMF').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_QUANTITA(HtW(Ctrl('APWPUKFDMF').value,'N'),null,e);
return l_bSetResult;
}
}
function APWPUKFDMF_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('APWPUKFDMF'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('APWPUKFDMF'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('APWPUKFDMF'),e);
}
function BDCVNEPJXV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(getComboValue(Ctrl('BDCVNEPJXV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(getComboValue(Ctrl('BDCVNEPJXV')),'C'),null,e);
return l_bSetResult;
}
}
function BDCVNEPJXV_OnFocus(e) {
SetActiveField(Ctrl('BDCVNEPJXV'),true);
}
function BDCVNEPJXV_OnBlur(e) {
SetActiveField(Ctrl('BDCVNEPJXV'),false);
}
function KXSLYMBVDR_Valid(e) {
SetActiveField(Ctrl('KXSLYMBVDR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('UNIQUER','C',w_UNIQUER,HtW(Ctrl('KXSLYMBVDR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_UNIQUER(HtW(Ctrl('KXSLYMBVDR').value,'C'),null,e);
return l_bSetResult;
}
}
function KXSLYMBVDR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KXSLYMBVDR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KXSLYMBVDR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KXSLYMBVDR'),e);
}
function IWGAASAAMD_Valid(e) {
SetActiveField(Ctrl('IWGAASAAMD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('OLDINTER','C',w_OLDINTER,HtW(Ctrl('IWGAASAAMD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_OLDINTER(HtW(Ctrl('IWGAASAAMD').value,'C'),null,e);
return l_bSetResult;
}
}
function IWGAASAAMD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IWGAASAAMD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IWGAASAAMD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IWGAASAAMD'),e);
}
function AIQQNOUGRA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('INVIATO','N',w_INVIATO,ChkboxValueAssign(Ctrl('AIQQNOUGRA'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_INVIATO(ChkboxValueAssign(Ctrl('AIQQNOUGRA'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function AIQQNOUGRA_OnFocus(e) {
SetActiveField(Ctrl('AIQQNOUGRA'),true);
}
function AIQQNOUGRA_OnBlur(e) {
SetActiveField(Ctrl('AIQQNOUGRA'),false);
}
function OKHZSQAMSZ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('OKHZSQAMSZ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('OKHZSQAMSZ').value=ApplyPictureToDate(Ctrl('OKHZSQAMSZ').value,TranslatePicture(datePattern),'OKHZSQAMSZ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('OKHZSQAMSZ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('OKHZSQAMSZ');
}
}
}
SetActiveField(Ctrl('OKHZSQAMSZ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAINVIO','D',w_DATAINVIO,HtW(Ctrl('OKHZSQAMSZ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAINVIO(HtW(Ctrl('OKHZSQAMSZ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function OKHZSQAMSZ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OKHZSQAMSZ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('OKHZSQAMSZ',w_DATAINVIO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('OKHZSQAMSZ');
SetActiveField(Ctrl('OKHZSQAMSZ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OKHZSQAMSZ'),e);
}
function NMPRSQUWWU_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('NMPRSQUWWU'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('NMPRSQUWWU').value=ApplyPictureToDate(Ctrl('NMPRSQUWWU').value,TranslatePicture(datePattern),'NMPRSQUWWU');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('NMPRSQUWWU'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('NMPRSQUWWU');
}
}
}
SetActiveField(Ctrl('NMPRSQUWWU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAMODI','D',w_DATAMODI,HtW(Ctrl('NMPRSQUWWU').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAMODI(HtW(Ctrl('NMPRSQUWWU').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function NMPRSQUWWU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NMPRSQUWWU'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('NMPRSQUWWU',w_DATAMODI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('NMPRSQUWWU');
SetActiveField(Ctrl('NMPRSQUWWU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NMPRSQUWWU'),e);
}
function FPJQZIYEKX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ANNULLA','N',w_ANNULLA,ChkboxValueAssign(Ctrl('FPJQZIYEKX'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ANNULLA(ChkboxValueAssign(Ctrl('FPJQZIYEKX'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function FPJQZIYEKX_OnFocus(e) {
SetActiveField(Ctrl('FPJQZIYEKX'),true);
}
function FPJQZIYEKX_OnBlur(e) {
SetActiveField(Ctrl('FPJQZIYEKX'),false);
}
function ICEJVXXFJJ_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('ICEJVXXFJJ'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('ICEJVXXFJJ').value=ApplyPictureToDate(Ctrl('ICEJVXXFJJ').value,TranslatePicture(datePattern),'ICEJVXXFJJ');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('ICEJVXXFJJ'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('ICEJVXXFJJ');
}
}
}
SetActiveField(Ctrl('ICEJVXXFJJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAANNU','D',w_DATAANNU,HtW(Ctrl('ICEJVXXFJJ').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAANNU(HtW(Ctrl('ICEJVXXFJJ').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function ICEJVXXFJJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ICEJVXXFJJ'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('ICEJVXXFJJ',w_DATAANNU,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('ICEJVXXFJJ');
SetActiveField(Ctrl('ICEJVXXFJJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ICEJVXXFJJ'),e);
}
function ZHVHNJYLBS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('INVSALDO','N',w_INVSALDO,ChkboxValueAssign(Ctrl('ZHVHNJYLBS'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_INVSALDO(ChkboxValueAssign(Ctrl('ZHVHNJYLBS'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function ZHVHNJYLBS_OnFocus(e) {
SetActiveField(Ctrl('ZHVHNJYLBS'),true);
}
function ZHVHNJYLBS_OnBlur(e) {
SetActiveField(Ctrl('ZHVHNJYLBS'),false);
}
function EIWTVZVLOO_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('EIWTVZVLOO'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('EIWTVZVLOO').value=ApplyPictureToDate(Ctrl('EIWTVZVLOO').value,TranslatePicture(datePattern),'EIWTVZVLOO');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('EIWTVZVLOO'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('EIWTVZVLOO');
}
}
}
SetActiveField(Ctrl('EIWTVZVLOO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DTSALDO','D',w_DTSALDO,HtW(Ctrl('EIWTVZVLOO').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DTSALDO(HtW(Ctrl('EIWTVZVLOO').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function EIWTVZVLOO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('EIWTVZVLOO'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('EIWTVZVLOO',w_DTSALDO,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('EIWTVZVLOO');
SetActiveField(Ctrl('EIWTVZVLOO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('EIWTVZVLOO'),e);
}
function ERFGDWAQVY_Click() {
_modifyandopen('arpg_fam_variazione'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=400',false)
}
function KINMWWRRUA_Click() {
_modifyandopen('arpg_fam_cancella'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=200,width=400',false)
}
function SQOAICWIPS_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('SQOAICWIPS'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('SQOAICWIPS').value=ApplyPictureToDate(Ctrl('SQOAICWIPS').value,TranslatePicture(datePattern),'SQOAICWIPS');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('SQOAICWIPS'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('SQOAICWIPS');
}
}
}
SetActiveField(Ctrl('SQOAICWIPS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAOPE','D',w_DATAOPE,HtW(Ctrl('SQOAICWIPS').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAOPE(HtW(Ctrl('SQOAICWIPS').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function SQOAICWIPS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SQOAICWIPS'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('SQOAICWIPS',w_DATAOPE,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('SQOAICWIPS');
SetActiveField(Ctrl('SQOAICWIPS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SQOAICWIPS'),e);
}
function LJBUMZNQNX_Click() {
if (false || WindowConfirm(Translate('11257604157'))) {
Reinvio()
}
}
function JZEQARRYBY_Click() {
if (false || WindowConfirm(Translate('517218006'))) {
arrt_ae_opex_redelete([["pTipo",'D']])
}
}
function QNVJXJSDFW_Click() {
if (false || WindowConfirm(Translate('11257604157'))) {
arrt_ae_opex_redelete([["pTipo",'X']])
}
}
function DQASOJYMWJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NATURA','C',w_NATURA,HtW(getComboValue(Ctrl('DQASOJYMWJ')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NATURA(HtW(getComboValue(Ctrl('DQASOJYMWJ')),'C'),null,e);
return l_bSetResult;
}
}
function DQASOJYMWJ_OnFocus(e) {
SetActiveField(Ctrl('DQASOJYMWJ'),true);
}
function DQASOJYMWJ_OnBlur(e) {
SetActiveField(Ctrl('DQASOJYMWJ'),false);
}
linkpc_url.u('EARPHZNBLQ',function(){return 'ardt_delegaop?m_bInnerChild=true'+GetLinkPCKeys('ardt_delegaop')+'&m_bRowsChild='+EnableChild('ardt_delegaop')})
_ResetTracker();
function setEventHandlers() {
var c;
function JZEQARRYBY_wrap_OnClick(event) {
return JZEQARRYBY_Click();
}
SPBOUILib.SetButtonClick('JZEQARRYBY',JZEQARRYBY_wrap_OnClick);
function QNVJXJSDFW_wrap_OnClick(event) {
return QNVJXJSDFW_Click();
}
SPBOUILib.SetButtonClick('QNVJXJSDFW',QNVJXJSDFW_wrap_OnClick);
if (Ne(m_cFunction,'view')) {
function RVOXKWUSWH_wrap_Valid(event) {
return RVOXKWUSWH_Valid(event);
}
SPBOUILib.SetInputExit('RVOXKWUSWH',RVOXKWUSWH_wrap_Valid);
function RVOXKWUSWH_wrap_OnFocus(event) {
return RVOXKWUSWH_OnFocus(event);
}
SPBOUILib.SetInputEnter('RVOXKWUSWH',RVOXKWUSWH_wrap_OnFocus);
function RVOXKWUSWH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RVOXKWUSWH',RVOXKWUSWH_wrap_OnKeyDown);
function RVOXKWUSWH_ZOOM_setHandlers() {
function RVOXKWUSWH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RVOXKWUSWH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RVOXKWUSWH_ZOOM',RVOXKWUSWH_ZOOM_wrap_OnClick);
function RVOXKWUSWH_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RVOXKWUSWH_ZOOM',RVOXKWUSWH_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RVOXKWUSWH',RVOXKWUSWH_ZOOM_setHandlers);
function SZFKAURTJA_wrap_Valid(event) {
return SZFKAURTJA_Valid(event);
}
SPBOUILib.SetInputExit('SZFKAURTJA',SZFKAURTJA_wrap_Valid);
function SZFKAURTJA_wrap_OnFocus(event) {
return SZFKAURTJA_OnFocus(event);
}
SPBOUILib.SetInputEnter('SZFKAURTJA',SZFKAURTJA_wrap_OnFocus);
function SZFKAURTJA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SZFKAURTJA',SZFKAURTJA_wrap_OnKeyDown);
function PXVUKDVPLL_wrap_Valid(event) {
return PXVUKDVPLL_Valid(event);
}
SPBOUILib.SetInputExit('PXVUKDVPLL',PXVUKDVPLL_wrap_Valid);
function PXVUKDVPLL_wrap_OnFocus(event) {
return PXVUKDVPLL_OnFocus(event);
}
SPBOUILib.SetInputEnter('PXVUKDVPLL',PXVUKDVPLL_wrap_OnFocus);
function PXVUKDVPLL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PXVUKDVPLL',PXVUKDVPLL_wrap_OnKeyDown);
function PXVUKDVPLL_ZOOM_setHandlers() {
function PXVUKDVPLL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?PXVUKDVPLL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('PXVUKDVPLL_ZOOM',PXVUKDVPLL_ZOOM_wrap_OnClick);
function PXVUKDVPLL_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('PXVUKDVPLL_ZOOM',PXVUKDVPLL_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('PXVUKDVPLL',PXVUKDVPLL_ZOOM_setHandlers);
function ENOHXMETFI_wrap_Valid(event) {
return ENOHXMETFI_Valid(event);
}
SPBOUILib.SetInputExit('ENOHXMETFI',ENOHXMETFI_wrap_Valid);
function ENOHXMETFI_wrap_OnFocus(event) {
return ENOHXMETFI_OnFocus(event);
}
SPBOUILib.SetInputEnter('ENOHXMETFI',ENOHXMETFI_wrap_OnFocus);
function ENOHXMETFI_wrap_OnKeyPress(event) {
return ENOHXMETFI_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('ENOHXMETFI',ENOHXMETFI_wrap_OnKeyPress);
function ENOHXMETFI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ENOHXMETFI',ENOHXMETFI_wrap_OnKeyDown);
function APWPUKFDMF_wrap_Valid(event) {
return APWPUKFDMF_Valid(event);
}
SPBOUILib.SetInputExit('APWPUKFDMF',APWPUKFDMF_wrap_Valid);
function APWPUKFDMF_wrap_OnFocus(event) {
return APWPUKFDMF_OnFocus(event);
}
SPBOUILib.SetInputEnter('APWPUKFDMF',APWPUKFDMF_wrap_OnFocus);
function APWPUKFDMF_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('APWPUKFDMF',APWPUKFDMF_wrap_OnKeyPress);
function APWPUKFDMF_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('APWPUKFDMF',APWPUKFDMF_wrap_OnKeyDown);
function BDCVNEPJXV_wrap_Valid(event) {
return BDCVNEPJXV_Valid(event);
}
SPBOUILib.SetComboChange('BDCVNEPJXV',BDCVNEPJXV_wrap_Valid);
function BDCVNEPJXV_wrap_OnFocus(event) {
return BDCVNEPJXV_OnFocus(event);
}
SPBOUILib.SetInputEnter('BDCVNEPJXV',BDCVNEPJXV_wrap_OnFocus);
function BDCVNEPJXV_wrap_Blur(event) {
return BDCVNEPJXV_OnBlur(event);
}
SPBOUILib.SetInputExit('BDCVNEPJXV',BDCVNEPJXV_wrap_Blur);
function KXSLYMBVDR_wrap_Valid(event) {
return KXSLYMBVDR_Valid(event);
}
SPBOUILib.SetInputExit('KXSLYMBVDR',KXSLYMBVDR_wrap_Valid);
function KXSLYMBVDR_wrap_OnFocus(event) {
return KXSLYMBVDR_OnFocus(event);
}
SPBOUILib.SetInputEnter('KXSLYMBVDR',KXSLYMBVDR_wrap_OnFocus);
function KXSLYMBVDR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KXSLYMBVDR',KXSLYMBVDR_wrap_OnKeyDown);
function IWGAASAAMD_wrap_Valid(event) {
return IWGAASAAMD_Valid(event);
}
SPBOUILib.SetInputExit('IWGAASAAMD',IWGAASAAMD_wrap_Valid);
function IWGAASAAMD_wrap_OnFocus(event) {
return IWGAASAAMD_OnFocus(event);
}
SPBOUILib.SetInputEnter('IWGAASAAMD',IWGAASAAMD_wrap_OnFocus);
function IWGAASAAMD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IWGAASAAMD',IWGAASAAMD_wrap_OnKeyDown);
function AIQQNOUGRA_wrap_Valid(event) {
return AIQQNOUGRA_Valid(event);
}
SPBOUILib.SetCheckboxClick('AIQQNOUGRA',AIQQNOUGRA_wrap_Valid);
function AIQQNOUGRA_wrap_OnFocus(event) {
return AIQQNOUGRA_OnFocus(event);
}
SPBOUILib.SetInputEnter('AIQQNOUGRA',AIQQNOUGRA_wrap_OnFocus);
function AIQQNOUGRA_wrap_Blur(event) {
return AIQQNOUGRA_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AIQQNOUGRA',AIQQNOUGRA_wrap_Blur);
function OKHZSQAMSZ_wrap_Valid(event) {
return OKHZSQAMSZ_Valid(event);
}
SPBOUILib.SetInputExit('OKHZSQAMSZ',OKHZSQAMSZ_wrap_Valid);
function OKHZSQAMSZ_wrap_OnFocus(event) {
return OKHZSQAMSZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('OKHZSQAMSZ',OKHZSQAMSZ_wrap_OnFocus);
function OKHZSQAMSZ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('OKHZSQAMSZ',OKHZSQAMSZ_wrap_OnKeyPress);
function OKHZSQAMSZ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('OKHZSQAMSZ',OKHZSQAMSZ_wrap_OnKeyDown);
function NMPRSQUWWU_wrap_Valid(event) {
return NMPRSQUWWU_Valid(event);
}
SPBOUILib.SetInputExit('NMPRSQUWWU',NMPRSQUWWU_wrap_Valid);
function NMPRSQUWWU_wrap_OnFocus(event) {
return NMPRSQUWWU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NMPRSQUWWU',NMPRSQUWWU_wrap_OnFocus);
function NMPRSQUWWU_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('NMPRSQUWWU',NMPRSQUWWU_wrap_OnKeyPress);
function NMPRSQUWWU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('NMPRSQUWWU',NMPRSQUWWU_wrap_OnKeyDown);
function FPJQZIYEKX_wrap_Valid(event) {
return FPJQZIYEKX_Valid(event);
}
SPBOUILib.SetCheckboxClick('FPJQZIYEKX',FPJQZIYEKX_wrap_Valid);
function FPJQZIYEKX_wrap_OnFocus(event) {
return FPJQZIYEKX_OnFocus(event);
}
SPBOUILib.SetInputEnter('FPJQZIYEKX',FPJQZIYEKX_wrap_OnFocus);
function FPJQZIYEKX_wrap_Blur(event) {
return FPJQZIYEKX_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FPJQZIYEKX',FPJQZIYEKX_wrap_Blur);
function ICEJVXXFJJ_wrap_Valid(event) {
return ICEJVXXFJJ_Valid(event);
}
SPBOUILib.SetInputExit('ICEJVXXFJJ',ICEJVXXFJJ_wrap_Valid);
function ICEJVXXFJJ_wrap_OnFocus(event) {
return ICEJVXXFJJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('ICEJVXXFJJ',ICEJVXXFJJ_wrap_OnFocus);
function ICEJVXXFJJ_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('ICEJVXXFJJ',ICEJVXXFJJ_wrap_OnKeyPress);
function ICEJVXXFJJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('ICEJVXXFJJ',ICEJVXXFJJ_wrap_OnKeyDown);
function ZHVHNJYLBS_wrap_Valid(event) {
return ZHVHNJYLBS_Valid(event);
}
SPBOUILib.SetCheckboxClick('ZHVHNJYLBS',ZHVHNJYLBS_wrap_Valid);
function ZHVHNJYLBS_wrap_OnFocus(event) {
return ZHVHNJYLBS_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZHVHNJYLBS',ZHVHNJYLBS_wrap_OnFocus);
function ZHVHNJYLBS_wrap_Blur(event) {
return ZHVHNJYLBS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ZHVHNJYLBS',ZHVHNJYLBS_wrap_Blur);
function EIWTVZVLOO_wrap_Valid(event) {
return EIWTVZVLOO_Valid(event);
}
SPBOUILib.SetInputExit('EIWTVZVLOO',EIWTVZVLOO_wrap_Valid);
function EIWTVZVLOO_wrap_OnFocus(event) {
return EIWTVZVLOO_OnFocus(event);
}
SPBOUILib.SetInputEnter('EIWTVZVLOO',EIWTVZVLOO_wrap_OnFocus);
function EIWTVZVLOO_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('EIWTVZVLOO',EIWTVZVLOO_wrap_OnKeyPress);
function EIWTVZVLOO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('EIWTVZVLOO',EIWTVZVLOO_wrap_OnKeyDown);
function ERFGDWAQVY_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ERFGDWAQVY_Click():void(0));
}
SPBOUILib.SetButtonClick('ERFGDWAQVY',ERFGDWAQVY_wrap_OnClick);
function ERFGDWAQVY_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ERFGDWAQVY',ERFGDWAQVY_wrap_OnKeyDown);
function KINMWWRRUA_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?KINMWWRRUA_Click():void(0));
}
SPBOUILib.SetButtonClick('KINMWWRRUA',KINMWWRRUA_wrap_OnClick);
function KINMWWRRUA_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KINMWWRRUA',KINMWWRRUA_wrap_OnKeyDown);
function SQOAICWIPS_wrap_Valid(event) {
return SQOAICWIPS_Valid(event);
}
SPBOUILib.SetInputExit('SQOAICWIPS',SQOAICWIPS_wrap_Valid);
function SQOAICWIPS_wrap_OnFocus(event) {
return SQOAICWIPS_OnFocus(event);
}
SPBOUILib.SetInputEnter('SQOAICWIPS',SQOAICWIPS_wrap_OnFocus);
function SQOAICWIPS_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('SQOAICWIPS',SQOAICWIPS_wrap_OnKeyPress);
function SQOAICWIPS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('SQOAICWIPS',SQOAICWIPS_wrap_OnKeyDown);
function LJBUMZNQNX_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?LJBUMZNQNX_Click():void(0));
}
SPBOUILib.SetButtonClick('LJBUMZNQNX',LJBUMZNQNX_wrap_OnClick);
function LJBUMZNQNX_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('LJBUMZNQNX',LJBUMZNQNX_wrap_OnKeyDown);
function JZEQARRYBY_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('JZEQARRYBY',JZEQARRYBY_wrap_OnKeyDown);
function QNVJXJSDFW_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QNVJXJSDFW',QNVJXJSDFW_wrap_OnKeyDown);
function DQASOJYMWJ_wrap_Valid(event) {
return DQASOJYMWJ_Valid(event);
}
SPBOUILib.SetComboChange('DQASOJYMWJ',DQASOJYMWJ_wrap_Valid);
function DQASOJYMWJ_wrap_OnFocus(event) {
return DQASOJYMWJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('DQASOJYMWJ',DQASOJYMWJ_wrap_OnFocus);
function DQASOJYMWJ_wrap_Blur(event) {
return DQASOJYMWJ_OnBlur(event);
}
SPBOUILib.SetInputExit('DQASOJYMWJ',DQASOJYMWJ_wrap_Blur);
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
FocusFirstComponent.edit={"page_1":["PXVUKDVPLL"]};
FocusFirstComponent.query={"page_1":["RVOXKWUSWH"]};
FocusFirstComponent.otherwise={"page_1":["RVOXKWUSWH"]};
function Help() {
windowOpenForeground('../doc/armt_ae_opextrbo_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_delegaop() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_2')) {
if (ChildToLoad('EARPHZNBLQ')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('EARPHZNBLQ')) {
LoadContext.lc(1,'EARPHZNBLQ');
}
} else {
LibJavascript.RefreshChildGrid('EARPHZNBLQ');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"DatiBase"});
GetLayerID.Layers.push({"id":"YBDSVYFUDJ","name":"AltriDel"});
function DeclareWVs() {
var a = arguments;
w_COLLEG=a[0];
w_ANNO=a[1];
w_CONNESOPER=a[2];
w_SALDO=a[3];
w_QUANTITA=a[4];
w_VALUTA=a[5];
w_UNIQUER=a[6];
w_OLDINTER=a[7];
w_INVIATO=a[8];
w_DATAINVIO=a[9];
w_DATAMODI=a[10];
w_ANNULLA=a[11];
w_DATAANNU=a[12];
w_IDESITO=a[13];
w_INVSALDO=a[14];
w_DTSALDO=a[15];
w_DATAOPE=a[16];
w_CFESTERO=a[17];
w_NATURA=a[18];
w_xRAGSOC=a[19];
w_xRAGSOC2=a[20];
m_cWv_ardt_delegaop=a[21];
if (Gt(a.length,22)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['ANNO','COLLEG'];
}
function i_PrimaryKey() {
return 'opextrbo'+'\\'+CPLib.ToCPStr(w_COLLEG)+'\\'+CPLib.ToCPStr(w_ANNO);
}
GetLinkPCKeys.set_o('ardt_delegaop',false);
GetLinkPCKeys.o['ardt_delegaop']['COLLEG']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_COLLEG,'C');
}
}
GetLinkPCKeys.o['ardt_delegaop']['ANNO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_ANNO,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('EARPHZNBLQ',function(){return FrameRef('ardt_delegaop')},1,'ardt_delegaop',0,2)
GetSelectedChildPage.child={'ardt_delegaop': function(){return FrameRef('ardt_delegaop')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_ae_opextrbo',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_COLLEG,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGSOC,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"RVOXKWUSWH"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CONNESOPER,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGSOC2,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"PXVUKDVPLL"});
}
_Obli('COLLEG',0,'RVOXKWUSWH',false,"10565397709")
_Obli('INVIATO',1,'AIQQNOUGRA',false)
_Obli('ANNO',0,'SZFKAURTJA',false,"999531942")
_Obli('CONNESOPER',0,'PXVUKDVPLL',false,"1786626708")
_Obli('DATAMODI',2,'NMPRSQUWWU',false,"11268897251")
_Obli('SALDO',1,'ENOHXMETFI',false,"7713379")
_Obli('QUANTITA',1,'APWPUKFDMF',false,"11992988360")
_Obli('VALUTA',0,'BDCVNEPJXV',false,"1325098957")
_Obli('UNIQUER',0,'KXSLYMBVDR',false,"918159306")
_Obli('OLDINTER',0,'IWGAASAAMD',false,"11064762721")
_Obli('DATAANNU',2,'ICEJVXXFJJ',false)
_Obli('DATAINVIO',2,'OKHZSQAMSZ',false)
_Obli('NATURA',0,'DQASOJYMWJ',false,"12030926209")
_Obli('ANNULLA',1,'FPJQZIYEKX',false)
_Obli('INVSALDO',1,'ZHVHNJYLBS',false)
_Obli('DATAOPE',2,'SQOAICWIPS',false,"829201110")
_Obli('DTSALDO',2,'EIWTVZVLOO',false)
