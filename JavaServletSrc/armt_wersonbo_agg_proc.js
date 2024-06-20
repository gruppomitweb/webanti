function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('DBFIZRPONS',function(){return WtH(w_EMAIL,'C',50,0,'')},w_EMAIL);
if(c=Ctrl('JYNIHKHNSF')) ChkboxCheckUncheck(c,'S',w_FLGEMAIL)
if(c=Ctrl('JYNIHKHNSF')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('TZSFXOGJGG',function(){return WtH(w_TELEFONO,'C',50,0,'')},w_TELEFONO);
if(c=Ctrl('LMZAVCTIKT')) ChkboxCheckUncheck(c,'S',w_FLGVALIDO)
if(c=Ctrl('LMZAVCTIKT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('HAONGEKSUB')) ChkboxCheckUncheck(c,'S',w_FLGANAVAL)
if(c=Ctrl('HAONGEKSUB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('FYSLTMPLOV',function(){return WtH(w_CLOCCUPA,'N',3,0,'')},w_CLOCCUPA);
SPBOUILib.SetInputValue('BGFCAXGJBL',function(){return WtH(w_NAZIONE,'C',3,0,'')},w_NAZIONE);
var tmp_FYLIIHUTPH = ToHTag(AsControlValue(w_xDesNaz));
if (Ne(e_FYLIIHUTPH,tmp_FYLIIHUTPH)) {
SPBOUILib.SetLabelValue('FYLIIHUTPH','innerHTML',tmp_FYLIIHUTPH);
e_FYLIIHUTPH=tmp_FYLIIHUTPH;
}
SPBOUILib.SetInputValue('NIRLEZVFLW',function(){return WtH(w_CLPRVDOM,'C',2,0,'')},w_CLPRVDOM);
if(c=Ctrl('CBYSBUCJMV')) selectCombo(c,w_REGRES,'C')
if(c=Ctrl('URHHMCUEEA')) ChkboxCheckUncheck(c,'S',w_FLGBL)
if(c=Ctrl('URHHMCUEEA')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('CANUTVNGFD',function(){return WtH(w_CATEG01,'C',2,0,'')},w_CATEG01);
var tmp_NRWNAJJVRA = ToHTag(AsControlValue(w_xC1DESCRI));
if (Ne(e_NRWNAJJVRA,tmp_NRWNAJJVRA)) {
SPBOUILib.SetLabelValue('NRWNAJJVRA','innerHTML',tmp_NRWNAJJVRA);
e_NRWNAJJVRA=tmp_NRWNAJJVRA;
}
SPBOUILib.SetInputValue('IXGRJLAKIQ',function(){return WtH(w_CATEG02,'C',2,0,'')},w_CATEG02);
var tmp_LNOFOPAOYD = ToHTag(AsControlValue(w_xC2DESCRI));
if (Ne(e_LNOFOPAOYD,tmp_LNOFOPAOYD)) {
SPBOUILib.SetLabelValue('LNOFOPAOYD','innerHTML',tmp_LNOFOPAOYD);
e_LNOFOPAOYD=tmp_LNOFOPAOYD;
}
SPBOUILib.SetInputValue('NKIXCWZJHO',function(){return WtH(w_CATEG03,'C',2,0,'')},w_CATEG03);
var tmp_WBTKNDJDFF = ToHTag(AsControlValue(w_xC3DESCRI));
if (Ne(e_WBTKNDJDFF,tmp_WBTKNDJDFF)) {
SPBOUILib.SetLabelValue('WBTKNDJDFF','innerHTML',tmp_WBTKNDJDFF);
e_WBTKNDJDFF=tmp_WBTKNDJDFF;
}
SPBOUILib.SetInputValue('JQLGHMLOKO',function(){return WtH(w_CATEG04,'C',2,0,'')},w_CATEG04);
var tmp_MWCFKQVNHF = ToHTag(AsControlValue(w_xC4DESCRI));
if (Ne(e_MWCFKQVNHF,tmp_MWCFKQVNHF)) {
SPBOUILib.SetLabelValue('MWCFKQVNHF','innerHTML',tmp_MWCFKQVNHF);
e_MWCFKQVNHF=tmp_MWCFKQVNHF;
}
SPBOUILib.SetInputValue('QVBZSFMTVP',function(){return WtH(w_CATEG05,'C',2,0,'')},w_CATEG05);
var tmp_HADVHTQAPE = ToHTag(AsControlValue(w_xC5DESCRI));
if (Ne(e_HADVHTQAPE,tmp_HADVHTQAPE)) {
SPBOUILib.SetLabelValue('HADVHTQAPE','innerHTML',tmp_HADVHTQAPE);
e_HADVHTQAPE=tmp_HADVHTQAPE;
}
if(c=Ctrl('SEUBTYJEKC')) ChkboxCheckUncheck(c,'S',w_FLGPREGIUD)
if(c=Ctrl('SEUBTYJEKC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('AIXHBUOLOH')) ChkboxCheckUncheck(c,'S',w_FLGTRUST)
if(c=Ctrl('AIXHBUOLOH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RJATPPKQJX')) ChkboxCheckUncheck(c,'S',w_FLGRISCHIO)
if(c=Ctrl('RJATPPKQJX')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('BFAZVGKRMM')) ChkboxCheckUncheck(c,'S',w_FLGFALSADIC)
if(c=Ctrl('BFAZVGKRMM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('TYXOFHIXSZ')) ChkboxCheckUncheck(c,'S',w_FLGEQUIFIN)
if(c=Ctrl('TYXOFHIXSZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('ONGFHKWFDC')) ChkboxCheckUncheck(c,'S',w_FLGRICINF)
if(c=Ctrl('ONGFHKWFDC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('HHZVXHZWFT',function(){return WtH(w_NUMCEL,'C',15,0,'')},w_NUMCEL);
SPBOUILib.SetInputValue('CJLHZBPFZE',function(){return WtH(w_EMAIL,'M',10,0,'')},w_EMAIL);
SPBOUILib.SetInputValue('PYRPYRCHAE',function(){return WtH(w_PEC,'C',50,0,'')},w_PEC);
SPBOUILib.SetInputValue('DRSQJFIQWH',function(){return WtH(w_REFERENTE,'C',50,0,'')},w_REFERENTE);
if(c=Ctrl('XFXZVUBUON')) ChkboxCheckUncheck(c,1,w_CONALTO)
if(c=Ctrl('XFXZVUBUON')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('GYAJLZIGMO')) ChkboxCheckUncheck(c,1,w_APPALTO)
if(c=Ctrl('GYAJLZIGMO')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('RFAIYHSGII_DIV',IsHiddenByStateDriver('Categorie'));
SetDisplay('YFAFHIMHLC_DIV',IsHiddenByStateDriver('SocRev'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CATEG01"]=['WWRYOVTMFY'];
HideUI.lblids["CATEG02"]=['HNQZARYXGS'];
HideUI.lblids["CATEG03"]=['BGEVFUGGOS'];
HideUI.lblids["CATEG04"]=['RHXCIUHRTU'];
HideUI.lblids["CATEG05"]=['GRCYFEKJWU'];
HideUI.lblids["CLOCCUPA"]=['VSLFLTAORI'];
HideUI.lblids["CLPRVDOM"]=['RKPADAREKN'];
HideUI.lblids["EMAIL"]=['NMMOYAZYFJ','PFHITGLPYJ'];
HideUI.lblids["NAZIONE"]=['RXOQQWNFRG'];
HideUI.lblids["NUMCEL"]=['USQLSETBFB'];
HideUI.lblids["PEC"]=['GIUWNGWRYA'];
HideUI.lblids["REFERENTE"]=['PNNBAMJIYZ'];
HideUI.lblids["REGRES"]=['HJQTMOWJVN'];
HideUI.lblids["TELEFONO"]=['ELIBEIUTYO'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function DBFIZRPONS_Valid(e) {
SetActiveField(Ctrl('DBFIZRPONS'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('EMAIL','C',w_EMAIL,HtW(Ctrl('DBFIZRPONS').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EMAIL(HtW(Ctrl('DBFIZRPONS').value,'C'),null,e);
return l_bSetResult;
}
}
function DBFIZRPONS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DBFIZRPONS'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DBFIZRPONS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DBFIZRPONS'),e);
}
function JYNIHKHNSF_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGEMAIL','C',w_FLGEMAIL,ChkboxValueAssign(Ctrl('JYNIHKHNSF'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGEMAIL(ChkboxValueAssign(Ctrl('JYNIHKHNSF'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function JYNIHKHNSF_OnFocus(e) {
SetActiveField(Ctrl('JYNIHKHNSF'),true);
}
function JYNIHKHNSF_OnBlur(e) {
SetActiveField(Ctrl('JYNIHKHNSF'),false);
}
function TZSFXOGJGG_Valid(e) {
SetActiveField(Ctrl('TZSFXOGJGG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TELEFONO','C',w_TELEFONO,HtW(Ctrl('TZSFXOGJGG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TELEFONO(HtW(Ctrl('TZSFXOGJGG').value,'C'),null,e);
return l_bSetResult;
}
}
function TZSFXOGJGG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TZSFXOGJGG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('TZSFXOGJGG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TZSFXOGJGG'),e);
}
function LMZAVCTIKT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGVALIDO','C',w_FLGVALIDO,ChkboxValueAssign(Ctrl('LMZAVCTIKT'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGVALIDO(ChkboxValueAssign(Ctrl('LMZAVCTIKT'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function LMZAVCTIKT_OnFocus(e) {
SetActiveField(Ctrl('LMZAVCTIKT'),true);
}
function LMZAVCTIKT_OnBlur(e) {
SetActiveField(Ctrl('LMZAVCTIKT'),false);
}
function HAONGEKSUB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGANAVAL','C',w_FLGANAVAL,ChkboxValueAssign(Ctrl('HAONGEKSUB'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGANAVAL(ChkboxValueAssign(Ctrl('HAONGEKSUB'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function HAONGEKSUB_OnFocus(e) {
SetActiveField(Ctrl('HAONGEKSUB'),true);
}
function HAONGEKSUB_OnBlur(e) {
SetActiveField(Ctrl('HAONGEKSUB'),false);
}
function FYSLTMPLOV_Valid(e) {
SetActiveField(Ctrl('FYSLTMPLOV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CLOCCUPA','N',w_CLOCCUPA,HtW(Ctrl('FYSLTMPLOV').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CLOCCUPA(HtW(Ctrl('FYSLTMPLOV').value,'N'),null,e);
return l_bSetResult;
}
}
function FYSLTMPLOV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FYSLTMPLOV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FYSLTMPLOV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FYSLTMPLOV'),e);
}
function BGFCAXGJBL_Valid(e) {
SetActiveField(Ctrl('BGFCAXGJBL'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NAZIONE','C',w_NAZIONE,HtW(Ctrl('BGFCAXGJBL').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NAZIONE(HtW(Ctrl('BGFCAXGJBL').value,'C'),null,e);
return l_bSetResult;
}
}
function BGFCAXGJBL_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BGFCAXGJBL'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BGFCAXGJBL'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BGFCAXGJBL'),e);
}
function BGFCAXGJBL_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BGFCAXGJBL')),'linkview_BGFCAXGJBL','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NIRLEZVFLW_Valid(e) {
SetActiveField(Ctrl('NIRLEZVFLW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CLPRVDOM','C',w_CLPRVDOM,HtW(Ctrl('NIRLEZVFLW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CLPRVDOM(HtW(Ctrl('NIRLEZVFLW').value,'C'),null,e);
return l_bSetResult;
}
}
function NIRLEZVFLW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NIRLEZVFLW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NIRLEZVFLW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NIRLEZVFLW'),e);
}
function CBYSBUCJMV_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('REGRES','C',w_REGRES,HtW(getComboValue(Ctrl('CBYSBUCJMV')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_REGRES(HtW(getComboValue(Ctrl('CBYSBUCJMV')),'C'),null,e);
return l_bSetResult;
}
}
function CBYSBUCJMV_OnFocus(e) {
SetActiveField(Ctrl('CBYSBUCJMV'),true);
}
function CBYSBUCJMV_OnBlur(e) {
SetActiveField(Ctrl('CBYSBUCJMV'),false);
}
function URHHMCUEEA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGBL','C',w_FLGBL,ChkboxValueAssign(Ctrl('URHHMCUEEA'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGBL(ChkboxValueAssign(Ctrl('URHHMCUEEA'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function URHHMCUEEA_OnFocus(e) {
SetActiveField(Ctrl('URHHMCUEEA'),true);
}
function URHHMCUEEA_OnBlur(e) {
SetActiveField(Ctrl('URHHMCUEEA'),false);
}
function CANUTVNGFD_Valid(e) {
SetActiveField(Ctrl('CANUTVNGFD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG01','C',w_CATEG01,HtW(Ctrl('CANUTVNGFD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG01(HtW(Ctrl('CANUTVNGFD').value,'C'),null,e);
return l_bSetResult;
}
}
function CANUTVNGFD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CANUTVNGFD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CANUTVNGFD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CANUTVNGFD'),e);
}
function CANUTVNGFD_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CANUTVNGFD')),'linkview_CANUTVNGFD','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function IXGRJLAKIQ_Valid(e) {
SetActiveField(Ctrl('IXGRJLAKIQ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG02','C',w_CATEG02,HtW(Ctrl('IXGRJLAKIQ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG02(HtW(Ctrl('IXGRJLAKIQ').value,'C'),null,e);
return l_bSetResult;
}
}
function IXGRJLAKIQ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IXGRJLAKIQ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IXGRJLAKIQ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IXGRJLAKIQ'),e);
}
function IXGRJLAKIQ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('IXGRJLAKIQ')),'linkview_IXGRJLAKIQ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NKIXCWZJHO_Valid(e) {
SetActiveField(Ctrl('NKIXCWZJHO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG03','C',w_CATEG03,HtW(Ctrl('NKIXCWZJHO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG03(HtW(Ctrl('NKIXCWZJHO').value,'C'),null,e);
return l_bSetResult;
}
}
function NKIXCWZJHO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NKIXCWZJHO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NKIXCWZJHO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NKIXCWZJHO'),e);
}
function NKIXCWZJHO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NKIXCWZJHO')),'linkview_NKIXCWZJHO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function JQLGHMLOKO_Valid(e) {
SetActiveField(Ctrl('JQLGHMLOKO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG04','C',w_CATEG04,HtW(Ctrl('JQLGHMLOKO').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG04(HtW(Ctrl('JQLGHMLOKO').value,'C'),null,e);
return l_bSetResult;
}
}
function JQLGHMLOKO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JQLGHMLOKO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JQLGHMLOKO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JQLGHMLOKO'),e);
}
function JQLGHMLOKO_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('JQLGHMLOKO')),'linkview_JQLGHMLOKO','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QVBZSFMTVP_Valid(e) {
SetActiveField(Ctrl('QVBZSFMTVP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CATEG05','C',w_CATEG05,HtW(Ctrl('QVBZSFMTVP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CATEG05(HtW(Ctrl('QVBZSFMTVP').value,'C'),null,e);
return l_bSetResult;
}
}
function QVBZSFMTVP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QVBZSFMTVP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QVBZSFMTVP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QVBZSFMTVP'),e);
}
function QVBZSFMTVP_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QVBZSFMTVP')),'linkview_QVBZSFMTVP','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SEUBTYJEKC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGPREGIUD','C',w_FLGPREGIUD,ChkboxValueAssign(Ctrl('SEUBTYJEKC'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGPREGIUD(ChkboxValueAssign(Ctrl('SEUBTYJEKC'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function SEUBTYJEKC_OnFocus(e) {
SetActiveField(Ctrl('SEUBTYJEKC'),true);
}
function SEUBTYJEKC_OnBlur(e) {
SetActiveField(Ctrl('SEUBTYJEKC'),false);
}
function AIXHBUOLOH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGTRUST','C',w_FLGTRUST,ChkboxValueAssign(Ctrl('AIXHBUOLOH'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGTRUST(ChkboxValueAssign(Ctrl('AIXHBUOLOH'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function AIXHBUOLOH_OnFocus(e) {
SetActiveField(Ctrl('AIXHBUOLOH'),true);
}
function AIXHBUOLOH_OnBlur(e) {
SetActiveField(Ctrl('AIXHBUOLOH'),false);
}
function RJATPPKQJX_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGRISCHIO','C',w_FLGRISCHIO,ChkboxValueAssign(Ctrl('RJATPPKQJX'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGRISCHIO(ChkboxValueAssign(Ctrl('RJATPPKQJX'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RJATPPKQJX_OnFocus(e) {
SetActiveField(Ctrl('RJATPPKQJX'),true);
}
function RJATPPKQJX_OnBlur(e) {
SetActiveField(Ctrl('RJATPPKQJX'),false);
}
function BFAZVGKRMM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGFALSADIC','C',w_FLGFALSADIC,ChkboxValueAssign(Ctrl('BFAZVGKRMM'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGFALSADIC(ChkboxValueAssign(Ctrl('BFAZVGKRMM'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function BFAZVGKRMM_OnFocus(e) {
SetActiveField(Ctrl('BFAZVGKRMM'),true);
}
function BFAZVGKRMM_OnBlur(e) {
SetActiveField(Ctrl('BFAZVGKRMM'),false);
}
function TYXOFHIXSZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGEQUIFIN','C',w_FLGEQUIFIN,ChkboxValueAssign(Ctrl('TYXOFHIXSZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGEQUIFIN(ChkboxValueAssign(Ctrl('TYXOFHIXSZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function TYXOFHIXSZ_OnFocus(e) {
SetActiveField(Ctrl('TYXOFHIXSZ'),true);
}
function TYXOFHIXSZ_OnBlur(e) {
SetActiveField(Ctrl('TYXOFHIXSZ'),false);
}
function ONGFHKWFDC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGRICINF','C',w_FLGRICINF,ChkboxValueAssign(Ctrl('ONGFHKWFDC'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGRICINF(ChkboxValueAssign(Ctrl('ONGFHKWFDC'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ONGFHKWFDC_OnFocus(e) {
SetActiveField(Ctrl('ONGFHKWFDC'),true);
}
function ONGFHKWFDC_OnBlur(e) {
SetActiveField(Ctrl('ONGFHKWFDC'),false);
}
function HHZVXHZWFT_Valid(e) {
SetActiveField(Ctrl('HHZVXHZWFT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMCEL','C',w_NUMCEL,HtW(Ctrl('HHZVXHZWFT').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMCEL(HtW(Ctrl('HHZVXHZWFT').value,'C'),null,e);
return l_bSetResult;
}
}
function HHZVXHZWFT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HHZVXHZWFT'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HHZVXHZWFT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HHZVXHZWFT'),e);
}
function CJLHZBPFZE_Valid(e) {
SetActiveField(Ctrl('CJLHZBPFZE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('EMAIL','M',w_EMAIL,HtW(Ctrl('CJLHZBPFZE').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EMAIL(HtW(Ctrl('CJLHZBPFZE').value,'M'),null,e);
return l_bSetResult;
}
}
function CJLHZBPFZE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CJLHZBPFZE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CJLHZBPFZE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CJLHZBPFZE'),e);
}
function PYRPYRCHAE_Valid(e) {
SetActiveField(Ctrl('PYRPYRCHAE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PEC','C',w_PEC,HtW(Ctrl('PYRPYRCHAE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PEC(HtW(Ctrl('PYRPYRCHAE').value,'C'),null,e);
return l_bSetResult;
}
}
function PYRPYRCHAE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PYRPYRCHAE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PYRPYRCHAE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PYRPYRCHAE'),e);
}
function DRSQJFIQWH_Valid(e) {
SetActiveField(Ctrl('DRSQJFIQWH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('REFERENTE','C',w_REFERENTE,HtW(Ctrl('DRSQJFIQWH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_REFERENTE(HtW(Ctrl('DRSQJFIQWH').value,'C'),null,e);
return l_bSetResult;
}
}
function DRSQJFIQWH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DRSQJFIQWH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DRSQJFIQWH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DRSQJFIQWH'),e);
}
function XFXZVUBUON_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CONALTO','N',w_CONALTO,ChkboxValueAssign(Ctrl('XFXZVUBUON'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONALTO(ChkboxValueAssign(Ctrl('XFXZVUBUON'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function XFXZVUBUON_OnFocus(e) {
SetActiveField(Ctrl('XFXZVUBUON'),true);
}
function XFXZVUBUON_OnBlur(e) {
SetActiveField(Ctrl('XFXZVUBUON'),false);
}
function GYAJLZIGMO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('APPALTO','N',w_APPALTO,ChkboxValueAssign(Ctrl('GYAJLZIGMO'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_APPALTO(ChkboxValueAssign(Ctrl('GYAJLZIGMO'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function GYAJLZIGMO_OnFocus(e) {
SetActiveField(Ctrl('GYAJLZIGMO'),true);
}
function GYAJLZIGMO_OnBlur(e) {
SetActiveField(Ctrl('GYAJLZIGMO'),false);
}
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function DBFIZRPONS_wrap_Valid(event) {
return DBFIZRPONS_Valid(event);
}
SPBOUILib.SetInputExit('DBFIZRPONS',DBFIZRPONS_wrap_Valid);
function DBFIZRPONS_wrap_OnFocus(event) {
return DBFIZRPONS_OnFocus(event);
}
SPBOUILib.SetInputEnter('DBFIZRPONS',DBFIZRPONS_wrap_OnFocus);
function DBFIZRPONS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DBFIZRPONS',DBFIZRPONS_wrap_OnKeyDown);
function JYNIHKHNSF_wrap_Valid(event) {
return JYNIHKHNSF_Valid(event);
}
SPBOUILib.SetCheckboxClick('JYNIHKHNSF',JYNIHKHNSF_wrap_Valid);
function JYNIHKHNSF_wrap_OnFocus(event) {
return JYNIHKHNSF_OnFocus(event);
}
SPBOUILib.SetInputEnter('JYNIHKHNSF',JYNIHKHNSF_wrap_OnFocus);
function JYNIHKHNSF_wrap_Blur(event) {
return JYNIHKHNSF_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('JYNIHKHNSF',JYNIHKHNSF_wrap_Blur);
function TZSFXOGJGG_wrap_Valid(event) {
return TZSFXOGJGG_Valid(event);
}
SPBOUILib.SetInputExit('TZSFXOGJGG',TZSFXOGJGG_wrap_Valid);
function TZSFXOGJGG_wrap_OnFocus(event) {
return TZSFXOGJGG_OnFocus(event);
}
SPBOUILib.SetInputEnter('TZSFXOGJGG',TZSFXOGJGG_wrap_OnFocus);
function TZSFXOGJGG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TZSFXOGJGG',TZSFXOGJGG_wrap_OnKeyDown);
function LMZAVCTIKT_wrap_Valid(event) {
return LMZAVCTIKT_Valid(event);
}
SPBOUILib.SetCheckboxClick('LMZAVCTIKT',LMZAVCTIKT_wrap_Valid);
function LMZAVCTIKT_wrap_OnFocus(event) {
return LMZAVCTIKT_OnFocus(event);
}
SPBOUILib.SetInputEnter('LMZAVCTIKT',LMZAVCTIKT_wrap_OnFocus);
function LMZAVCTIKT_wrap_Blur(event) {
return LMZAVCTIKT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('LMZAVCTIKT',LMZAVCTIKT_wrap_Blur);
function HAONGEKSUB_wrap_Valid(event) {
return HAONGEKSUB_Valid(event);
}
SPBOUILib.SetCheckboxClick('HAONGEKSUB',HAONGEKSUB_wrap_Valid);
function HAONGEKSUB_wrap_OnFocus(event) {
return HAONGEKSUB_OnFocus(event);
}
SPBOUILib.SetInputEnter('HAONGEKSUB',HAONGEKSUB_wrap_OnFocus);
function HAONGEKSUB_wrap_Blur(event) {
return HAONGEKSUB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('HAONGEKSUB',HAONGEKSUB_wrap_Blur);
function FYSLTMPLOV_wrap_Valid(event) {
return FYSLTMPLOV_Valid(event);
}
SPBOUILib.SetInputExit('FYSLTMPLOV',FYSLTMPLOV_wrap_Valid);
function FYSLTMPLOV_wrap_OnFocus(event) {
return FYSLTMPLOV_OnFocus(event);
}
SPBOUILib.SetInputEnter('FYSLTMPLOV',FYSLTMPLOV_wrap_OnFocus);
function FYSLTMPLOV_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('FYSLTMPLOV',FYSLTMPLOV_wrap_OnKeyPress);
function FYSLTMPLOV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FYSLTMPLOV',FYSLTMPLOV_wrap_OnKeyDown);
function BGFCAXGJBL_wrap_Valid(event) {
return BGFCAXGJBL_Valid(event);
}
SPBOUILib.SetInputExit('BGFCAXGJBL',BGFCAXGJBL_wrap_Valid);
function BGFCAXGJBL_wrap_OnFocus(event) {
return BGFCAXGJBL_OnFocus(event);
}
SPBOUILib.SetInputEnter('BGFCAXGJBL',BGFCAXGJBL_wrap_OnFocus);
function BGFCAXGJBL_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BGFCAXGJBL',BGFCAXGJBL_wrap_OnKeyDown);
function BGFCAXGJBL_ZOOM_setHandlers() {
function BGFCAXGJBL_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BGFCAXGJBL_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BGFCAXGJBL_ZOOM',BGFCAXGJBL_ZOOM_wrap_OnClick);
function BGFCAXGJBL_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BGFCAXGJBL_ZOOM',BGFCAXGJBL_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BGFCAXGJBL',BGFCAXGJBL_ZOOM_setHandlers);
function NIRLEZVFLW_wrap_Valid(event) {
return NIRLEZVFLW_Valid(event);
}
SPBOUILib.SetInputExit('NIRLEZVFLW',NIRLEZVFLW_wrap_Valid);
function NIRLEZVFLW_wrap_OnFocus(event) {
return NIRLEZVFLW_OnFocus(event);
}
SPBOUILib.SetInputEnter('NIRLEZVFLW',NIRLEZVFLW_wrap_OnFocus);
function NIRLEZVFLW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NIRLEZVFLW',NIRLEZVFLW_wrap_OnKeyDown);
function CBYSBUCJMV_wrap_Valid(event) {
return CBYSBUCJMV_Valid(event);
}
SPBOUILib.SetComboChange('CBYSBUCJMV',CBYSBUCJMV_wrap_Valid);
function CBYSBUCJMV_wrap_OnFocus(event) {
return CBYSBUCJMV_OnFocus(event);
}
SPBOUILib.SetInputEnter('CBYSBUCJMV',CBYSBUCJMV_wrap_OnFocus);
function CBYSBUCJMV_wrap_Blur(event) {
return CBYSBUCJMV_OnBlur(event);
}
SPBOUILib.SetInputExit('CBYSBUCJMV',CBYSBUCJMV_wrap_Blur);
function URHHMCUEEA_wrap_Valid(event) {
return URHHMCUEEA_Valid(event);
}
SPBOUILib.SetCheckboxClick('URHHMCUEEA',URHHMCUEEA_wrap_Valid);
function URHHMCUEEA_wrap_OnFocus(event) {
return URHHMCUEEA_OnFocus(event);
}
SPBOUILib.SetInputEnter('URHHMCUEEA',URHHMCUEEA_wrap_OnFocus);
function URHHMCUEEA_wrap_Blur(event) {
return URHHMCUEEA_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('URHHMCUEEA',URHHMCUEEA_wrap_Blur);
function CANUTVNGFD_wrap_Valid(event) {
return CANUTVNGFD_Valid(event);
}
SPBOUILib.SetInputExit('CANUTVNGFD',CANUTVNGFD_wrap_Valid);
function CANUTVNGFD_wrap_OnFocus(event) {
return CANUTVNGFD_OnFocus(event);
}
SPBOUILib.SetInputEnter('CANUTVNGFD',CANUTVNGFD_wrap_OnFocus);
function CANUTVNGFD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CANUTVNGFD',CANUTVNGFD_wrap_OnKeyDown);
function CANUTVNGFD_ZOOM_setHandlers() {
function CANUTVNGFD_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CANUTVNGFD_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CANUTVNGFD_ZOOM',CANUTVNGFD_ZOOM_wrap_OnClick);
function CANUTVNGFD_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CANUTVNGFD_ZOOM',CANUTVNGFD_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CANUTVNGFD',CANUTVNGFD_ZOOM_setHandlers);
function IXGRJLAKIQ_wrap_Valid(event) {
return IXGRJLAKIQ_Valid(event);
}
SPBOUILib.SetInputExit('IXGRJLAKIQ',IXGRJLAKIQ_wrap_Valid);
function IXGRJLAKIQ_wrap_OnFocus(event) {
return IXGRJLAKIQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('IXGRJLAKIQ',IXGRJLAKIQ_wrap_OnFocus);
function IXGRJLAKIQ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IXGRJLAKIQ',IXGRJLAKIQ_wrap_OnKeyDown);
function IXGRJLAKIQ_ZOOM_setHandlers() {
function IXGRJLAKIQ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IXGRJLAKIQ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IXGRJLAKIQ_ZOOM',IXGRJLAKIQ_ZOOM_wrap_OnClick);
function IXGRJLAKIQ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IXGRJLAKIQ_ZOOM',IXGRJLAKIQ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IXGRJLAKIQ',IXGRJLAKIQ_ZOOM_setHandlers);
function NKIXCWZJHO_wrap_Valid(event) {
return NKIXCWZJHO_Valid(event);
}
SPBOUILib.SetInputExit('NKIXCWZJHO',NKIXCWZJHO_wrap_Valid);
function NKIXCWZJHO_wrap_OnFocus(event) {
return NKIXCWZJHO_OnFocus(event);
}
SPBOUILib.SetInputEnter('NKIXCWZJHO',NKIXCWZJHO_wrap_OnFocus);
function NKIXCWZJHO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NKIXCWZJHO',NKIXCWZJHO_wrap_OnKeyDown);
function NKIXCWZJHO_ZOOM_setHandlers() {
function NKIXCWZJHO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NKIXCWZJHO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NKIXCWZJHO_ZOOM',NKIXCWZJHO_ZOOM_wrap_OnClick);
function NKIXCWZJHO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NKIXCWZJHO_ZOOM',NKIXCWZJHO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NKIXCWZJHO',NKIXCWZJHO_ZOOM_setHandlers);
function JQLGHMLOKO_wrap_Valid(event) {
return JQLGHMLOKO_Valid(event);
}
SPBOUILib.SetInputExit('JQLGHMLOKO',JQLGHMLOKO_wrap_Valid);
function JQLGHMLOKO_wrap_OnFocus(event) {
return JQLGHMLOKO_OnFocus(event);
}
SPBOUILib.SetInputEnter('JQLGHMLOKO',JQLGHMLOKO_wrap_OnFocus);
function JQLGHMLOKO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JQLGHMLOKO',JQLGHMLOKO_wrap_OnKeyDown);
function JQLGHMLOKO_ZOOM_setHandlers() {
function JQLGHMLOKO_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?JQLGHMLOKO_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('JQLGHMLOKO_ZOOM',JQLGHMLOKO_ZOOM_wrap_OnClick);
function JQLGHMLOKO_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('JQLGHMLOKO_ZOOM',JQLGHMLOKO_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('JQLGHMLOKO',JQLGHMLOKO_ZOOM_setHandlers);
function QVBZSFMTVP_wrap_Valid(event) {
return QVBZSFMTVP_Valid(event);
}
SPBOUILib.SetInputExit('QVBZSFMTVP',QVBZSFMTVP_wrap_Valid);
function QVBZSFMTVP_wrap_OnFocus(event) {
return QVBZSFMTVP_OnFocus(event);
}
SPBOUILib.SetInputEnter('QVBZSFMTVP',QVBZSFMTVP_wrap_OnFocus);
function QVBZSFMTVP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QVBZSFMTVP',QVBZSFMTVP_wrap_OnKeyDown);
function QVBZSFMTVP_ZOOM_setHandlers() {
function QVBZSFMTVP_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QVBZSFMTVP_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QVBZSFMTVP_ZOOM',QVBZSFMTVP_ZOOM_wrap_OnClick);
function QVBZSFMTVP_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QVBZSFMTVP_ZOOM',QVBZSFMTVP_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QVBZSFMTVP',QVBZSFMTVP_ZOOM_setHandlers);
function SEUBTYJEKC_wrap_Valid(event) {
return SEUBTYJEKC_Valid(event);
}
SPBOUILib.SetCheckboxClick('SEUBTYJEKC',SEUBTYJEKC_wrap_Valid);
function SEUBTYJEKC_wrap_OnFocus(event) {
return SEUBTYJEKC_OnFocus(event);
}
SPBOUILib.SetInputEnter('SEUBTYJEKC',SEUBTYJEKC_wrap_OnFocus);
function SEUBTYJEKC_wrap_Blur(event) {
return SEUBTYJEKC_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('SEUBTYJEKC',SEUBTYJEKC_wrap_Blur);
function AIXHBUOLOH_wrap_Valid(event) {
return AIXHBUOLOH_Valid(event);
}
SPBOUILib.SetCheckboxClick('AIXHBUOLOH',AIXHBUOLOH_wrap_Valid);
function AIXHBUOLOH_wrap_OnFocus(event) {
return AIXHBUOLOH_OnFocus(event);
}
SPBOUILib.SetInputEnter('AIXHBUOLOH',AIXHBUOLOH_wrap_OnFocus);
function AIXHBUOLOH_wrap_Blur(event) {
return AIXHBUOLOH_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AIXHBUOLOH',AIXHBUOLOH_wrap_Blur);
function RJATPPKQJX_wrap_Valid(event) {
return RJATPPKQJX_Valid(event);
}
SPBOUILib.SetCheckboxClick('RJATPPKQJX',RJATPPKQJX_wrap_Valid);
function RJATPPKQJX_wrap_OnFocus(event) {
return RJATPPKQJX_OnFocus(event);
}
SPBOUILib.SetInputEnter('RJATPPKQJX',RJATPPKQJX_wrap_OnFocus);
function RJATPPKQJX_wrap_Blur(event) {
return RJATPPKQJX_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RJATPPKQJX',RJATPPKQJX_wrap_Blur);
function BFAZVGKRMM_wrap_Valid(event) {
return BFAZVGKRMM_Valid(event);
}
SPBOUILib.SetCheckboxClick('BFAZVGKRMM',BFAZVGKRMM_wrap_Valid);
function BFAZVGKRMM_wrap_OnFocus(event) {
return BFAZVGKRMM_OnFocus(event);
}
SPBOUILib.SetInputEnter('BFAZVGKRMM',BFAZVGKRMM_wrap_OnFocus);
function BFAZVGKRMM_wrap_Blur(event) {
return BFAZVGKRMM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('BFAZVGKRMM',BFAZVGKRMM_wrap_Blur);
function TYXOFHIXSZ_wrap_Valid(event) {
return TYXOFHIXSZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('TYXOFHIXSZ',TYXOFHIXSZ_wrap_Valid);
function TYXOFHIXSZ_wrap_OnFocus(event) {
return TYXOFHIXSZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('TYXOFHIXSZ',TYXOFHIXSZ_wrap_OnFocus);
function TYXOFHIXSZ_wrap_Blur(event) {
return TYXOFHIXSZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('TYXOFHIXSZ',TYXOFHIXSZ_wrap_Blur);
function ONGFHKWFDC_wrap_Valid(event) {
return ONGFHKWFDC_Valid(event);
}
SPBOUILib.SetCheckboxClick('ONGFHKWFDC',ONGFHKWFDC_wrap_Valid);
function ONGFHKWFDC_wrap_OnFocus(event) {
return ONGFHKWFDC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ONGFHKWFDC',ONGFHKWFDC_wrap_OnFocus);
function ONGFHKWFDC_wrap_Blur(event) {
return ONGFHKWFDC_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ONGFHKWFDC',ONGFHKWFDC_wrap_Blur);
function HHZVXHZWFT_wrap_Valid(event) {
return HHZVXHZWFT_Valid(event);
}
SPBOUILib.SetInputExit('HHZVXHZWFT',HHZVXHZWFT_wrap_Valid);
function HHZVXHZWFT_wrap_OnFocus(event) {
return HHZVXHZWFT_OnFocus(event);
}
SPBOUILib.SetInputEnter('HHZVXHZWFT',HHZVXHZWFT_wrap_OnFocus);
function HHZVXHZWFT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HHZVXHZWFT',HHZVXHZWFT_wrap_OnKeyDown);
function CJLHZBPFZE_wrap_Valid(event) {
return CJLHZBPFZE_Valid(event);
}
SPBOUILib.SetInputExit('CJLHZBPFZE',CJLHZBPFZE_wrap_Valid);
function CJLHZBPFZE_wrap_OnFocus(event) {
return CJLHZBPFZE_OnFocus(event);
}
SPBOUILib.SetInputEnter('CJLHZBPFZE',CJLHZBPFZE_wrap_OnFocus);
function PYRPYRCHAE_wrap_Valid(event) {
return PYRPYRCHAE_Valid(event);
}
SPBOUILib.SetInputExit('PYRPYRCHAE',PYRPYRCHAE_wrap_Valid);
function PYRPYRCHAE_wrap_OnFocus(event) {
return PYRPYRCHAE_OnFocus(event);
}
SPBOUILib.SetInputEnter('PYRPYRCHAE',PYRPYRCHAE_wrap_OnFocus);
function PYRPYRCHAE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PYRPYRCHAE',PYRPYRCHAE_wrap_OnKeyDown);
function DRSQJFIQWH_wrap_Valid(event) {
return DRSQJFIQWH_Valid(event);
}
SPBOUILib.SetInputExit('DRSQJFIQWH',DRSQJFIQWH_wrap_Valid);
function DRSQJFIQWH_wrap_OnFocus(event) {
return DRSQJFIQWH_OnFocus(event);
}
SPBOUILib.SetInputEnter('DRSQJFIQWH',DRSQJFIQWH_wrap_OnFocus);
function DRSQJFIQWH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DRSQJFIQWH',DRSQJFIQWH_wrap_OnKeyDown);
function XFXZVUBUON_wrap_Valid(event) {
return XFXZVUBUON_Valid(event);
}
SPBOUILib.SetCheckboxClick('XFXZVUBUON',XFXZVUBUON_wrap_Valid);
function XFXZVUBUON_wrap_OnFocus(event) {
return XFXZVUBUON_OnFocus(event);
}
SPBOUILib.SetInputEnter('XFXZVUBUON',XFXZVUBUON_wrap_OnFocus);
function XFXZVUBUON_wrap_Blur(event) {
return XFXZVUBUON_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XFXZVUBUON',XFXZVUBUON_wrap_Blur);
function GYAJLZIGMO_wrap_Valid(event) {
return GYAJLZIGMO_Valid(event);
}
SPBOUILib.SetCheckboxClick('GYAJLZIGMO',GYAJLZIGMO_wrap_Valid);
function GYAJLZIGMO_wrap_OnFocus(event) {
return GYAJLZIGMO_OnFocus(event);
}
SPBOUILib.SetInputEnter('GYAJLZIGMO',GYAJLZIGMO_wrap_OnFocus);
function GYAJLZIGMO_wrap_Blur(event) {
return GYAJLZIGMO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GYAJLZIGMO',GYAJLZIGMO_wrap_Blur);
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
m_oFather.i_last_focused_item='child_armt_wersonbo_agg';
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
}
m_nLastError=0;
m_cLastMsgError='';
}
FocusFirstComponent.edit={"page_1":["DBFIZRPONS"]};
FocusFirstComponent.query={"page_1":["DBFIZRPONS"]};
FocusFirstComponent.otherwise={"page_1":["DBFIZRPONS"]};
function Help() {
windowOpenForeground('../doc/armt_wersonbo_agg_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"RFAIYHSGII","name":"Categorie"});
GetLayerID.Layers.push({"id":"YFAFHIMHLC","name":"SocRev"});
function DeclareWVs() {
var a = arguments;
w_CONNES=a[0];
w_EMAIL=a[1];
w_FLGEMAIL=a[2];
w_TELEFONO=a[3];
w_FLGVALIDO=a[4];
w_FLGANAVAL=a[5];
w_CLOCCUPA=a[6];
w_NAZIONE=a[7];
w_CLPRVDOM=a[8];
w_REGRES=a[9];
w_FLGBL=a[10];
w_CATEG01=a[11];
w_CATEG02=a[12];
w_CATEG03=a[13];
w_CATEG04=a[14];
w_CATEG05=a[15];
w_FLGPREGIUD=a[16];
w_FLGTRUST=a[17];
w_FLGRISCHIO=a[18];
w_FLGFALSADIC=a[19];
w_FLGEQUIFIN=a[20];
w_FLGRICINF=a[21];
w_CATEGORIA=a[22];
w_NUMCEL=a[23];
w_PEC=a[24];
w_REFERENTE=a[25];
w_CONALTO=a[26];
w_APPALTO=a[27];
w_sanumpro=a[28];
w_gTipInter=a[29];
w_xDesNaz=a[30];
w_xC1DESCRI=a[31];
w_xC2DESCRI=a[32];
w_xC3DESCRI=a[33];
w_xC4DESCRI=a[34];
w_xC5DESCRI=a[35];
m_PrimaryKeys=['sanumpro'];
}
function i_PrimaryKey() {
return 'wersonbo_agg'+'\\'+CPLib.ToCPStr(w_sanumpro);
}
function CheckZone(me) {
if (IsWndAccessible(window['m_oFather'])) {
return m_oFather.CheckZone('child_armt_wersonbo_agg');
}
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_wersonbo_agg',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_NAZIONE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_xDesNaz,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"BGFCAXGJBL"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg01','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG01,'C'); },"field":"C1CODICE","type":"C"},{"expression":function() { return WtA(w_xC1DESCRI,'C'); },"field":"C1DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg01','C'),"uid":"CANUTVNGFD"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg02','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG02,'C'); },"field":"C2CODICE","type":"C"},{"expression":function() { return WtA(w_xC2DESCRI,'C'); },"field":"C2DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg02','C'),"uid":"IXGRJLAKIQ"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg03','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG03,'C'); },"field":"C3CODICE","type":"C"},{"expression":function() { return WtA(w_xC3DESCRI,'C'); },"field":"C3DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg03','C'),"uid":"NKIXCWZJHO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg04','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG04,'C'); },"field":"C4CODICE","type":"C"},{"expression":function() { return WtA(w_xC4DESCRI,'C'); },"field":"C4DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg04','C'),"uid":"JQLGHMLOKO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg05','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG05,'C'); },"field":"C5CODICE","type":"C"},{"expression":function() { return WtA(w_xC5DESCRI,'C'); },"field":"C5DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg05','C'),"uid":"QVBZSFMTVP"});
}
_Obli('CATEG05',0,'QVBZSFMTVP',false,"157154740")
_Obli('CONALTO',1,'XFXZVUBUON',false,"10021363378")
_Obli('EMAIL',0,'DBFIZRPONS',false,"5297685")
_Obli('EMAIL',0,'CJLHZBPFZE',false,"5297685")
_Obli('FLGEMAIL',0,'JYNIHKHNSF',false,"1635179791")
_Obli('TELEFONO',0,'TZSFXOGJGG',false,"1700577956")
_Obli('FLGVALIDO',0,'LMZAVCTIKT',false,"12078005779")
_Obli('FLGANAVAL',0,'HAONGEKSUB',false,"10061745855")
_Obli('CLOCCUPA',1,'FYSLTMPLOV',false,"277358030")
_Obli('NAZIONE',0,'BGFCAXGJBL',false,"676788231")
_Obli('PEC',0,'PYRPYRCHAE',false,"18336")
_Obli('CLPRVDOM',0,'NIRLEZVFLW',false,"10195722547")
_Obli('REGRES',0,'CBYSBUCJMV',false,"12129590363")
_Obli('FLGBL',0,'URHHMCUEEA',false,"11640916362")
_Obli('CATEG01',0,'CANUTVNGFD',false,"157154740")
_Obli('CATEG02',0,'IXGRJLAKIQ',false,"157154996")
_Obli('CATEG03',0,'NKIXCWZJHO',false,"157155252")
_Obli('CATEG04',0,'JQLGHMLOKO',false,"157154740")
_Obli('FLGTRUST',0,'AIXHBUOLOH',false,"8105076")
_Obli('APPALTO',1,'GYAJLZIGMO',false,"10354796574")
_Obli('FLGRISCHIO',0,'RJATPPKQJX',false,"10964299298")
_Obli('REFERENTE',0,'DRSQJFIQWH',false,"11261912825")
_Obli('FLGFALSADIC',0,'BFAZVGKRMM',false,"116493960")
_Obli('FLGPREGIUD',0,'SEUBTYJEKC',false,"1744218234")
_Obli('FLGEQUIFIN',0,'TYXOFHIXSZ',false,"10659481672")
_Obli('FLGRICINF',0,'ONGFHKWFDC',false,"695992708")
_Obli('NUMCEL',0,'HHZVXHZWFT',false,"12009320712")
