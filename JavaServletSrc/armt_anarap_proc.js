function FillCombosValues() {
FillCombo('ZFOHYLVPYN','ZFOHYLVPYN');
FillCombo('BHAVHLFPAC','BHAVHLFPAC');
FillCombo('QBUCLWUNFT','QBUCLWUNFT');
FillCombo('LSSRJEUOJW','LSSRJEUOJW');
FillCombo('SMVVFHCEHA','SMVVFHCEHA');
}
function SetControlsValue() {
var c;
var tmp_subtitle = ToHTag(AsControlValue(w_titolo));
if (Ne(e_subtitle,tmp_subtitle)) {
SetSubTitle(tmp_subtitle);
e_subtitle=tmp_subtitle;
}
SPBOUILib.SetInputValue('LXORWVRYJJ',function(){return WtH(w_RAPPORTO,'C',25,0,'@!')},w_RAPPORTO);
SPBOUILib.SetInputValue('AQAARAIPOR',function(){return WtH(w_DESCRAP,'C',50,0,'')},w_DESCRAP);
if(c=Ctrl('ZFOHYLVPYN')) selectCombo(c,w_TIPORAP,'C')
if(c=Ctrl('BHAVHLFPAC')) selectCombo(c,w_TIPOAG,'C')
if(c=Ctrl('QBUCLWUNFT')) selectCombo(c,w_ISOAGE,'C')
if(c=Ctrl('AABRTCZWUY')) ChkboxCheckUncheck(c,1,w_NOPROT)
if(c=Ctrl('AABRTCZWUY')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('BCLYMGMBLK')) selectCombo(c,w_FLAGLIRE,'C')
SPBOUILib.SetInputValue('RUMXLFCOKA',function(){return WtH(w_VALUTA,'C',3,0,'')},w_VALUTA);
var tmp_XQILBJQNNS = ToHTag(AsControlValue(w_descval));
if (Ne(e_XQILBJQNNS,tmp_XQILBJQNNS)) {
SPBOUILib.SetLabelValue('XQILBJQNNS','innerHTML',tmp_XQILBJQNNS);
e_XQILBJQNNS=tmp_XQILBJQNNS;
}
SPBOUILib.SetInputValue('WRZZQXZUXK',function(){return WtH(w_IBAN,'C',30,0,'')},w_IBAN);
if(c=Ctrl('LSSRJEUOJW')) selectCombo(c,w_CODOGG,'C')
SPBOUILib.SetInputValue('VSHUPFYWOC',function(){return WtH(w_NATURA,'C',50,0,'')},w_NATURA);
SPBOUILib.SetInputValue('VASVGQZJGP',function(){return WtH(w_SCOPO,'C',50,0,'')},w_SCOPO);
SPBOUILib.SetInputValue('CKJQULDXKW',function(){return WtH(w_DURAT,'C',5,0,'')},w_DURAT);
SPBOUILib.SetInputValue('VEAKSOSZMJ',function(){return WtH(w_DURAT,'C',5,0,'')},w_DURAT);
SPBOUILib.SetInputValue('MXYTQLATHC',function(){return WtH(w_RFREQ,'N',3,0,'')},w_RFREQ);
SPBOUILib.SetInputValue('SXTYCPHBIM',function(){return WtH(w_AMMONT,'C',5,0,'')},w_AMMONT);
SPBOUILib.SetInputValue('FLHYCYAKON',function(){return WtH(w_AMMONT,'C',5,0,'')},w_AMMONT);
SPBOUILib.SetInputValue('KBIUAXUDXA',function(){return WtH(w_RIMP,'N',3,0,'')},w_RIMP);
SPBOUILib.SetInputValue('QJSTZIPOQB',function(){return WtH(w_AREAGEO,'C',5,0,'')},w_AREAGEO);
SPBOUILib.SetInputValue('MDMTUJRAZF',function(){return WtH(w_AREAGEO,'C',5,0,'')},w_AREAGEO);
SPBOUILib.SetInputValue('UDAYHICPVB',function(){return WtH(w_RAREA,'N',3,0,'')},w_RAREA);
SPBOUILib.SetInputValue('SFFFOYOWNH',function(){return WtH(w_MODSVOL,'C',5,0,'')},w_MODSVOL);
SPBOUILib.SetInputValue('ZKJUEEUNAK',function(){return WtH(w_MODSVOL,'C',5,0,'')},w_MODSVOL);
SPBOUILib.SetInputValue('ETALZDRBSO',function(){return WtH(w_RCOMP,'N',3,0,'')},w_RCOMP);
SPBOUILib.SetInputValue('NOBMPHKVTX',function(){return WtH(w_RAGIO,'C',5,0,'')},w_RAGIO);
SPBOUILib.SetInputValue('EAWVSIWQBM',function(){return WtH(w_RAGIO,'C',5,0,'')},w_RAGIO);
SPBOUILib.SetInputValue('QBTVZDKLCO',function(){return WtH(w_RRAGIO,'N',3,0,'')},w_RRAGIO);
SPBOUILib.SetInputValue('DJOWYRMDDC',function(){return WtH(w_TIPO,'C',5,0,'')},w_TIPO);
SPBOUILib.SetInputValue('DTDVSGUEWE',function(){return WtH(w_TIPO,'C',2,0,'')},w_TIPO);
SPBOUILib.SetInputValue('RUWEXWJASG',function(){return WtH(w_RTIPO,'N',3,0,'')},w_RTIPO);
var tmp_CMKJDFEFFI = ToHTag(AsControlValue(w_xdescareag));
if (Ne(e_CMKJDFEFFI,tmp_CMKJDFEFFI)) {
SPBOUILib.SetLabelValue('CMKJDFEFFI','innerHTML',tmp_CMKJDFEFFI);
e_CMKJDFEFFI=tmp_CMKJDFEFFI;
}
var tmp_DXOTWSGBKN = ToHTag(AsControlValue(w_xdescmodsvo));
if (Ne(e_DXOTWSGBKN,tmp_DXOTWSGBKN)) {
SPBOUILib.SetLabelValue('DXOTWSGBKN','innerHTML',tmp_DXOTWSGBKN);
e_DXOTWSGBKN=tmp_DXOTWSGBKN;
}
var tmp_FXHEISJAJE = ToHTag(AsControlValue(w_xdescplauso));
if (Ne(e_FXHEISJAJE,tmp_FXHEISJAJE)) {
SPBOUILib.SetLabelValue('FXHEISJAJE','innerHTML',tmp_FXHEISJAJE);
e_FXHEISJAJE=tmp_FXHEISJAJE;
}
var tmp_GHHOMNKDDQ = ToHTag(AsControlValue(w_xdesctipor));
if (Ne(e_GHHOMNKDDQ,tmp_GHHOMNKDDQ)) {
SPBOUILib.SetLabelValue('GHHOMNKDDQ','innerHTML',tmp_GHHOMNKDDQ);
e_GHHOMNKDDQ=tmp_GHHOMNKDDQ;
}
var tmp_BCFLBBQSRN = ToHTag(AsControlValue(w_xdescammo));
if (Ne(e_BCFLBBQSRN,tmp_BCFLBBQSRN)) {
SPBOUILib.SetLabelValue('BCFLBBQSRN','innerHTML',tmp_BCFLBBQSRN);
e_BCFLBBQSRN=tmp_BCFLBBQSRN;
}
var tmp_QEXJCFPJBM = ToHTag(AsControlValue(w_xdescfreq));
if (Ne(e_QEXJCFPJBM,tmp_QEXJCFPJBM)) {
SPBOUILib.SetLabelValue('QEXJCFPJBM','innerHTML',tmp_QEXJCFPJBM);
e_QEXJCFPJBM=tmp_QEXJCFPJBM;
}
if(c=Ctrl('SMVVFHCEHA')) selectCombo(c,w_RISGLOB,'C')
SPBOUILib.SetInputValue('MXITFMGTNB',function(){return WtH(w_DATAPROF,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAPROF);
SPBOUILib.SetInputValue('QLLLNEUVYW',function(){return WtH(w_DATAREVPROF,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAREVPROF);
SPBOUILib.SetInputValue('DOXBACRWUU',function(){return WtH(w_MITIG,'N',4,0,'')},w_MITIG);
SPBOUILib.SetInputValue('OXGBDTWKSX',function(){return WtH(w_MITGDOC,'C',100,0,'')},w_MITGDOC);
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
SPBOUILib.SetInputValue('QGMBPIURNH',function(){return WtH(w_titolo,'C',90,0,'')},w_titolo);
if(c=Ctrl('GIJHAKTZAN')) ChkboxCheckUncheck(c,1,w_NOCANC)
if(c=Ctrl('GIJHAKTZAN')) ChkboxValueAssign(c,1,0,'N',1,0,'')
var tmp_TEKSYGREXN = ToHTag(AsControlValue(w_xDESDIPE));
if (Ne(e_TEKSYGREXN,tmp_TEKSYGREXN)) {
SPBOUILib.SetLabelValue('TEKSYGREXN','innerHTML',tmp_TEKSYGREXN);
e_TEKSYGREXN=tmp_TEKSYGREXN;
}
SPBOUILib.SetInputValue('HBPZQIPSZE',function(){return WtH(w_CODDIPE,'C',6,0,'')},w_CODDIPE);
SPBOUILib.SetInputValue('SSYXHQXJLD',function(){return WtH(w_MACODICE,'C',5,0,'')},w_MACODICE);
SPBOUILib.SetInputValue('YSBAKLZECK',function(){return WtH(w_SPLITCODE,'C',15,0,'')},w_SPLITCODE);
var tmp_TWSRQQLPNA = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_TWSRQQLPNA,tmp_TWSRQQLPNA)) {
SPBOUILib.SetLabelValue('TWSRQQLPNA','innerHTML',tmp_TWSRQQLPNA);
e_TWSRQQLPNA=tmp_TWSRQQLPNA;
}
SPBOUILib.SetInputValue('UYHOJSIFEU',function(){return WtH(w_CODICELR,'C',16,0,'')},w_CODICELR);
var tmp_CQBNLOGUOF = ToHTag(AsControlValue(w_xRAGLEG));
if (Ne(e_CQBNLOGUOF,tmp_CQBNLOGUOF)) {
SPBOUILib.SetLabelValue('CQBNLOGUOF','innerHTML',tmp_CQBNLOGUOF);
e_CQBNLOGUOF=tmp_CQBNLOGUOF;
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
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay('RFAIYHSGII_DIV',IsHiddenByStateDriver('Categorie'));
SetDisplay(Ctrl('KKXIPNXBWK'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('QBUCLWUNFT'),Ne(w_TIPOAG,'96') && Ne(w_TIPOAG,'97') || IsHiddenByStateDriver('ISOAGE'));
SetDisplay(Ctrl('ZBUITWBMLO'),Ne(w_gTipInter,'14'));
SetDisplay(Ctrl('BXHLWVGOYO'),Ne(w_gTipInter,'14'));
SetDisplay(Ctrl('TQNAPDCWFY'),Ne(w_TIPOAG,'96') && Ne(w_TIPOAG,'97'));
SetDisplay('GJZISGEBVV_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay(Ctrl('QIETKIRGON'),Utilities.Make(window).IsInGroup(9));
SetDisplay('LZCEHELAXJ_DIV',IsHiddenByStateDriver('Rapporto'));
SetDisplay('EHSQLOIDHO_DIV',IsHiddenByStateDriver('Deleghe'));
SetDisplay('LWDMGLAEON_DIV',IsHiddenByStateDriver('Garantiti'));
SetDisplay('TUIMYVJMXF_DIV',IsHiddenByStateDriver('Dipendenza'));
SetDisplay('MUCCIMEJEB_DIV',IsHiddenByStateDriver('Saldi'));
SetDisplay('GURCMCSTQS_DIV',IsHiddenByStateDriver('SaldiCanali'));
SetDisplay('PHCJDNQLLF_DIV',IsHiddenByStateDriver('AltriDati'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["AMMONT"]=['LXNMWSOUMF'];
HideUI.lblids["AREAGEO"]=['NAVNOGNZNE'];
HideUI.lblids["CATEG01"]=['WWRYOVTMFY'];
HideUI.lblids["CATEG02"]=['HNQZARYXGS'];
HideUI.lblids["CATEG03"]=['BGEVFUGGOS'];
HideUI.lblids["CATEG04"]=['RHXCIUHRTU'];
HideUI.lblids["CATEG05"]=['GRCYFEKJWU'];
HideUI.lblids["CODDIPE"]=['CBLDNZTZNA'];
HideUI.lblids["CODICELR"]=['XDJAPZOPHJ'];
HideUI.lblids["CODOGG"]=['ZVXDABBVZA'];
HideUI.lblids["DATAPROF"]=['TTZXYWANKG'];
HideUI.lblids["DATAREVPROF"]=['ROVJICRYAM'];
HideUI.lblids["DESCRAP"]=['VEBJKDHMDC'];
HideUI.lblids["DURAT"]=['ZUVXJIZOSF'];
HideUI.lblids["FLAGLIRE"]=['OUQKLNQVMP'];
HideUI.lblids["IBAN"]=['WHSTCJKJTS','FYRUSHCQJD'];
HideUI.lblids["ISOAGE"]=['TQNAPDCWFY'];
HideUI.lblids["MACODICE"]=['JIHVKRMSZD'];
HideUI.lblids["MITGDOC"]=['PKJNNGBWFM'];
HideUI.lblids["MITIG"]=['VCBMHLXJMD'];
HideUI.lblids["MODSVOL"]=['LHTXLTQYIK'];
HideUI.lblids["NATURA"]=['BVGYBYGMJB'];
HideUI.lblids["RAGIO"]=['HGXSBHTFKF'];
HideUI.lblids["RAPPORTO"]=['OICGZUOZYP'];
HideUI.lblids["RISGLOB"]=['JKZZQYXAFS'];
HideUI.lblids["SCOPO"]=['EWATRAIADP'];
HideUI.lblids["SPLITCODE"]=['FFCVEAIHJV'];
HideUI.lblids["TIPO"]=['OKFGBGYVWD'];
HideUI.lblids["TIPOAG"]=['CTCKWHZVTZ'];
HideUI.lblids["TIPORAP"]=['GDCHKTFQUK'];
HideUI.lblids["VALUTA"]=['MILRATMPIJ'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond= ! (Empty(w_CATEG01) && Empty(w_CATEG02) && Empty(w_CATEG03) && Empty(w_CATEG04) && Empty(w_CATEG05));
if (Ne(o_RFAIYHSGII_expand,cond)) {
ExpandCollapsibleBox('RFAIYHSGII',cond);
o_RFAIYHSGII_expand=cond;
}
cond=Empty(w_CATEG01) && Empty(w_CATEG02) && Empty(w_CATEG03) && Empty(w_CATEG04) && Empty(w_CATEG05);
if (Ne(o_RFAIYHSGII_collapse,cond)) {
CollapseCollapsibleBox('RFAIYHSGII',cond);
o_RFAIYHSGII_collapse=cond;
}
}
function LXORWVRYJJ_Valid(e) {
SetActiveField(Ctrl('LXORWVRYJJ'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('LXORWVRYJJ') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('RAPPORTO','C',w_RAPPORTO,HtW(Ctrl('LXORWVRYJJ').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAPPORTO(HtW(Ctrl('LXORWVRYJJ').value,'C'),null,e);
return l_bSetResult;
}
}
function LXORWVRYJJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('LXORWVRYJJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('LXORWVRYJJ',w_RAPPORTO,'C',25,0,'@!');
SetActiveField(Ctrl('LXORWVRYJJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LXORWVRYJJ'),e);
}
function LXORWVRYJJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function AQAARAIPOR_Valid(e) {
SetActiveField(Ctrl('AQAARAIPOR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCRAP','C',w_DESCRAP,HtW(Ctrl('AQAARAIPOR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCRAP(HtW(Ctrl('AQAARAIPOR').value,'C'),null,e);
return l_bSetResult;
}
}
function AQAARAIPOR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AQAARAIPOR'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('AQAARAIPOR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AQAARAIPOR'),e);
}
function ZFOHYLVPYN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPORAP','C',w_TIPORAP,HtW(getComboValue(Ctrl('ZFOHYLVPYN')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPORAP(HtW(getComboValue(Ctrl('ZFOHYLVPYN')),'C'),null,e);
return l_bSetResult;
}
}
function ZFOHYLVPYN_OnFocus(e) {
SetActiveField(Ctrl('ZFOHYLVPYN'),true);
}
function ZFOHYLVPYN_OnBlur(e) {
SetActiveField(Ctrl('ZFOHYLVPYN'),false);
}
function KKXIPNXBWK_Click() {
if (false || WindowConfirm(Translate('1273209170'))) {
_modifyandopen(ToResource('jsp/pg_copia51_portlet.jsp'+'?cRapporto='+URLenc(w_RAPPORTO)+'&m_cParameterSequence=cRapporto')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=360,width=800',null)
}
}
function BHAVHLFPAC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOAG','C',w_TIPOAG,HtW(getComboValue(Ctrl('BHAVHLFPAC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOAG(HtW(getComboValue(Ctrl('BHAVHLFPAC')),'C'),null,e);
return l_bSetResult;
}
}
function BHAVHLFPAC_OnFocus(e) {
SetActiveField(Ctrl('BHAVHLFPAC'),true);
}
function BHAVHLFPAC_OnBlur(e) {
SetActiveField(Ctrl('BHAVHLFPAC'),false);
}
function QBUCLWUNFT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('ISOAGE','C',w_ISOAGE,HtW(getComboValue(Ctrl('QBUCLWUNFT')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ISOAGE(HtW(getComboValue(Ctrl('QBUCLWUNFT')),'C'),null,e);
return l_bSetResult;
}
}
function QBUCLWUNFT_OnFocus(e) {
SetActiveField(Ctrl('QBUCLWUNFT'),true);
}
function QBUCLWUNFT_OnBlur(e) {
SetActiveField(Ctrl('QBUCLWUNFT'),false);
}
function AABRTCZWUY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOPROT','N',w_NOPROT,ChkboxValueAssign(Ctrl('AABRTCZWUY'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOPROT(ChkboxValueAssign(Ctrl('AABRTCZWUY'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function AABRTCZWUY_OnFocus(e) {
SetActiveField(Ctrl('AABRTCZWUY'),true);
}
function AABRTCZWUY_OnBlur(e) {
SetActiveField(Ctrl('AABRTCZWUY'),false);
}
function BCLYMGMBLK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLAGLIRE','C',w_FLAGLIRE,HtW(getComboValue(Ctrl('BCLYMGMBLK')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLAGLIRE(HtW(getComboValue(Ctrl('BCLYMGMBLK')),'C'),null,e);
return l_bSetResult;
}
}
function BCLYMGMBLK_OnFocus(e) {
SetActiveField(Ctrl('BCLYMGMBLK'),true);
}
function BCLYMGMBLK_OnBlur(e) {
SetActiveField(Ctrl('BCLYMGMBLK'),false);
}
function RUMXLFCOKA_Valid(e) {
SetActiveField(Ctrl('RUMXLFCOKA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('VALUTA','C',w_VALUTA,HtW(Ctrl('RUMXLFCOKA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_VALUTA(HtW(Ctrl('RUMXLFCOKA').value,'C'),null,e);
return l_bSetResult;
}
}
function RUMXLFCOKA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RUMXLFCOKA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RUMXLFCOKA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RUMXLFCOKA'),e);
}
function RUMXLFCOKA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('RUMXLFCOKA')),'linkview_RUMXLFCOKA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function WRZZQXZUXK_Valid(e) {
SetActiveField(Ctrl('WRZZQXZUXK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IBAN','C',w_IBAN,HtW(Ctrl('WRZZQXZUXK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IBAN(HtW(Ctrl('WRZZQXZUXK').value,'C'),null,e);
return l_bSetResult;
}
}
function WRZZQXZUXK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WRZZQXZUXK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('WRZZQXZUXK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WRZZQXZUXK'),e);
}
function LSSRJEUOJW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CODOGG','C',w_CODOGG,HtW(getComboValue(Ctrl('LSSRJEUOJW')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODOGG(HtW(getComboValue(Ctrl('LSSRJEUOJW')),'C'),null,e);
return l_bSetResult;
}
}
function LSSRJEUOJW_OnFocus(e) {
SetActiveField(Ctrl('LSSRJEUOJW'),true);
}
function LSSRJEUOJW_OnBlur(e) {
SetActiveField(Ctrl('LSSRJEUOJW'),false);
}
function VSHUPFYWOC_Valid(e) {
SetActiveField(Ctrl('VSHUPFYWOC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NATURA','C',w_NATURA,HtW(Ctrl('VSHUPFYWOC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NATURA(HtW(Ctrl('VSHUPFYWOC').value,'C'),null,e);
return l_bSetResult;
}
}
function VSHUPFYWOC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VSHUPFYWOC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VSHUPFYWOC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VSHUPFYWOC'),e);
}
function href_ZBUITWBMLO() {
_modifyandopen(ToResource('jsp/pg_tbnatura_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function VASVGQZJGP_Valid(e) {
SetActiveField(Ctrl('VASVGQZJGP'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SCOPO','C',w_SCOPO,HtW(Ctrl('VASVGQZJGP').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SCOPO(HtW(Ctrl('VASVGQZJGP').value,'C'),null,e);
return l_bSetResult;
}
}
function VASVGQZJGP_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VASVGQZJGP'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VASVGQZJGP'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VASVGQZJGP'),e);
}
function href_BXHLWVGOYO() {
_modifyandopen(ToResource('jsp/pg_tbscopo_portlet.jsp'+'')+'?m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function CKJQULDXKW_Valid(e) {
SetActiveField(Ctrl('CKJQULDXKW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DURAT','C',w_DURAT,HtW(Ctrl('CKJQULDXKW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DURAT(HtW(Ctrl('CKJQULDXKW').value,'C'),null,e);
return l_bSetResult;
}
}
function CKJQULDXKW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('CKJQULDXKW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('CKJQULDXKW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('CKJQULDXKW'),e);
}
function CKJQULDXKW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('CKJQULDXKW')),'linkview_CKJQULDXKW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function MXYTQLATHC_Valid(e) {
SetActiveField(Ctrl('MXYTQLATHC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RFREQ','N',w_RFREQ,HtW(Ctrl('MXYTQLATHC').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RFREQ(HtW(Ctrl('MXYTQLATHC').value,'N'),null,e);
return l_bSetResult;
}
}
function MXYTQLATHC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXYTQLATHC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MXYTQLATHC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXYTQLATHC'),e);
}
function SXTYCPHBIM_Valid(e) {
SetActiveField(Ctrl('SXTYCPHBIM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AMMONT','C',w_AMMONT,HtW(Ctrl('SXTYCPHBIM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AMMONT(HtW(Ctrl('SXTYCPHBIM').value,'C'),null,e);
return l_bSetResult;
}
}
function SXTYCPHBIM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SXTYCPHBIM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SXTYCPHBIM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SXTYCPHBIM'),e);
}
function SXTYCPHBIM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SXTYCPHBIM')),'linkview_SXTYCPHBIM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function KBIUAXUDXA_Valid(e) {
SetActiveField(Ctrl('KBIUAXUDXA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RIMP','N',w_RIMP,HtW(Ctrl('KBIUAXUDXA').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RIMP(HtW(Ctrl('KBIUAXUDXA').value,'N'),null,e);
return l_bSetResult;
}
}
function KBIUAXUDXA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KBIUAXUDXA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KBIUAXUDXA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KBIUAXUDXA'),e);
}
function QJSTZIPOQB_Valid(e) {
SetActiveField(Ctrl('QJSTZIPOQB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AREAGEO','C',w_AREAGEO,HtW(Ctrl('QJSTZIPOQB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AREAGEO(HtW(Ctrl('QJSTZIPOQB').value,'C'),null,e);
return l_bSetResult;
}
}
function QJSTZIPOQB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QJSTZIPOQB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QJSTZIPOQB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QJSTZIPOQB'),e);
}
function QJSTZIPOQB_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('QJSTZIPOQB')),'linkview_QJSTZIPOQB','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function UDAYHICPVB_Valid(e) {
SetActiveField(Ctrl('UDAYHICPVB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAREA','N',w_RAREA,HtW(Ctrl('UDAYHICPVB').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAREA(HtW(Ctrl('UDAYHICPVB').value,'N'),null,e);
return l_bSetResult;
}
}
function UDAYHICPVB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UDAYHICPVB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UDAYHICPVB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UDAYHICPVB'),e);
}
function SFFFOYOWNH_Valid(e) {
SetActiveField(Ctrl('SFFFOYOWNH'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MODSVOL','C',w_MODSVOL,HtW(Ctrl('SFFFOYOWNH').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MODSVOL(HtW(Ctrl('SFFFOYOWNH').value,'C'),null,e);
return l_bSetResult;
}
}
function SFFFOYOWNH_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SFFFOYOWNH'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SFFFOYOWNH'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SFFFOYOWNH'),e);
}
function SFFFOYOWNH_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SFFFOYOWNH')),'linkview_SFFFOYOWNH','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ETALZDRBSO_Valid(e) {
SetActiveField(Ctrl('ETALZDRBSO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RCOMP','N',w_RCOMP,HtW(Ctrl('ETALZDRBSO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RCOMP(HtW(Ctrl('ETALZDRBSO').value,'N'),null,e);
return l_bSetResult;
}
}
function ETALZDRBSO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ETALZDRBSO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('ETALZDRBSO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ETALZDRBSO'),e);
}
function NOBMPHKVTX_Valid(e) {
SetActiveField(Ctrl('NOBMPHKVTX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAGIO','C',w_RAGIO,HtW(Ctrl('NOBMPHKVTX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAGIO(HtW(Ctrl('NOBMPHKVTX').value,'C'),null,e);
return l_bSetResult;
}
}
function NOBMPHKVTX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOBMPHKVTX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOBMPHKVTX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOBMPHKVTX'),e);
}
function NOBMPHKVTX_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('NOBMPHKVTX')),'linkview_NOBMPHKVTX','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function QBTVZDKLCO_Valid(e) {
SetActiveField(Ctrl('QBTVZDKLCO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RRAGIO','N',w_RRAGIO,HtW(Ctrl('QBTVZDKLCO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RRAGIO(HtW(Ctrl('QBTVZDKLCO').value,'N'),null,e);
return l_bSetResult;
}
}
function QBTVZDKLCO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QBTVZDKLCO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('QBTVZDKLCO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QBTVZDKLCO'),e);
}
function DJOWYRMDDC_Valid(e) {
SetActiveField(Ctrl('DJOWYRMDDC'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPO','C',w_TIPO,HtW(Ctrl('DJOWYRMDDC').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPO(HtW(Ctrl('DJOWYRMDDC').value,'C'),null,e);
return l_bSetResult;
}
}
function DJOWYRMDDC_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DJOWYRMDDC'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DJOWYRMDDC'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DJOWYRMDDC'),e);
}
function DJOWYRMDDC_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('DJOWYRMDDC')),'linkview_DJOWYRMDDC','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function RUWEXWJASG_Valid(e) {
SetActiveField(Ctrl('RUWEXWJASG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RTIPO','N',w_RTIPO,HtW(Ctrl('RUWEXWJASG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RTIPO(HtW(Ctrl('RUWEXWJASG').value,'N'),null,e);
return l_bSetResult;
}
}
function RUWEXWJASG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RUWEXWJASG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RUWEXWJASG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RUWEXWJASG'),e);
}
function SMVVFHCEHA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('RISGLOB','C',w_RISGLOB,HtW(getComboValue(Ctrl('SMVVFHCEHA')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RISGLOB(HtW(getComboValue(Ctrl('SMVVFHCEHA')),'C'),null,e);
return l_bSetResult;
}
}
function SMVVFHCEHA_OnFocus(e) {
SetActiveField(Ctrl('SMVVFHCEHA'),true);
}
function SMVVFHCEHA_OnBlur(e) {
SetActiveField(Ctrl('SMVVFHCEHA'),false);
}
function MXITFMGTNB_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('MXITFMGTNB'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('MXITFMGTNB').value=ApplyPictureToDate(Ctrl('MXITFMGTNB').value,TranslatePicture(datePattern),'MXITFMGTNB');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('MXITFMGTNB'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('MXITFMGTNB');
}
}
}
SetActiveField(Ctrl('MXITFMGTNB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAPROF','D',w_DATAPROF,HtW(Ctrl('MXITFMGTNB').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAPROF(HtW(Ctrl('MXITFMGTNB').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function MXITFMGTNB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXITFMGTNB'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('MXITFMGTNB',w_DATAPROF,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('MXITFMGTNB');
SetActiveField(Ctrl('MXITFMGTNB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXITFMGTNB'),e);
}
function MXITFMGTNB_ZOOM_Click() {
LaunchCalendar(Ctrl('MXITFMGTNB'));
}
function QLLLNEUVYW_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('QLLLNEUVYW'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('QLLLNEUVYW').value=ApplyPictureToDate(Ctrl('QLLLNEUVYW').value,TranslatePicture(datePattern),'QLLLNEUVYW');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('QLLLNEUVYW'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('QLLLNEUVYW');
}
}
}
SetActiveField(Ctrl('QLLLNEUVYW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAREVPROF','D',w_DATAREVPROF,HtW(Ctrl('QLLLNEUVYW').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAREVPROF(HtW(Ctrl('QLLLNEUVYW').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function QLLLNEUVYW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('QLLLNEUVYW'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('QLLLNEUVYW',w_DATAREVPROF,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('QLLLNEUVYW');
SetActiveField(Ctrl('QLLLNEUVYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('QLLLNEUVYW'),e);
}
function QLLLNEUVYW_ZOOM_Click() {
LaunchCalendar(Ctrl('QLLLNEUVYW'));
}
function DOXBACRWUU_Valid(e) {
SetActiveField(Ctrl('DOXBACRWUU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MITIG','N',w_MITIG,HtW(Ctrl('DOXBACRWUU').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MITIG(HtW(Ctrl('DOXBACRWUU').value,'N'),null,e);
return l_bSetResult;
}
}
function DOXBACRWUU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DOXBACRWUU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('DOXBACRWUU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DOXBACRWUU'),e);
}
function OXGBDTWKSX_Valid(e) {
SetActiveField(Ctrl('OXGBDTWKSX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MITGDOC','C',w_MITGDOC,HtW(Ctrl('OXGBDTWKSX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MITGDOC(HtW(Ctrl('OXGBDTWKSX').value,'C'),null,e);
return l_bSetResult;
}
}
function OXGBDTWKSX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OXGBDTWKSX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OXGBDTWKSX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OXGBDTWKSX'),e);
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
function GIJHAKTZAN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOCANC','N',w_NOCANC,ChkboxValueAssign(Ctrl('GIJHAKTZAN'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOCANC(ChkboxValueAssign(Ctrl('GIJHAKTZAN'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function GIJHAKTZAN_OnFocus(e) {
SetActiveField(Ctrl('GIJHAKTZAN'),true);
}
function GIJHAKTZAN_OnBlur(e) {
SetActiveField(Ctrl('GIJHAKTZAN'),false);
}
function href_ZFPXBMEPWE() {
arrt_calcola_datarevprof_rap([["pObj",this]])
}
function QIETKIRGON_Click() {
Crea3132()
}
function HBPZQIPSZE_Valid(e) {
SetActiveField(Ctrl('HBPZQIPSZE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODDIPE','C',w_CODDIPE,HtW(Ctrl('HBPZQIPSZE').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODDIPE(HtW(Ctrl('HBPZQIPSZE').value,'C'),null,e);
return l_bSetResult;
}
}
function HBPZQIPSZE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HBPZQIPSZE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HBPZQIPSZE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HBPZQIPSZE'),e);
}
function HBPZQIPSZE_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('HBPZQIPSZE')),'linkview_HBPZQIPSZE','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function SSYXHQXJLD_Valid(e) {
SetActiveField(Ctrl('SSYXHQXJLD'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MACODICE','C',w_MACODICE,HtW(Ctrl('SSYXHQXJLD').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MACODICE(HtW(Ctrl('SSYXHQXJLD').value,'C'),null,e);
return l_bSetResult;
}
}
function SSYXHQXJLD_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SSYXHQXJLD'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SSYXHQXJLD'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SSYXHQXJLD'),e);
}
function SSYXHQXJLD_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SSYXHQXJLD')),'linkview_SSYXHQXJLD','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function YSBAKLZECK_Valid(e) {
SetActiveField(Ctrl('YSBAKLZECK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SPLITCODE','C',w_SPLITCODE,HtW(Ctrl('YSBAKLZECK').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SPLITCODE(HtW(Ctrl('YSBAKLZECK').value,'C'),null,e);
return l_bSetResult;
}
}
function YSBAKLZECK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YSBAKLZECK'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YSBAKLZECK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YSBAKLZECK'),e);
}
function UYHOJSIFEU_Valid(e) {
SetActiveField(Ctrl('UYHOJSIFEU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODICELR','C',w_CODICELR,HtW(Ctrl('UYHOJSIFEU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODICELR(HtW(Ctrl('UYHOJSIFEU').value,'C'),null,e);
return l_bSetResult;
}
}
function UYHOJSIFEU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UYHOJSIFEU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UYHOJSIFEU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UYHOJSIFEU'),e);
}
function UYHOJSIFEU_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('UYHOJSIFEU')),'linkview_UYHOJSIFEU','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
linkpc_url.u('ZSYGOPYXSA',function(){return 'ardt_garantbo?m_bInnerChild=true'+GetLinkPCKeys('ardt_garantbo')+'&m_bRowsChild='+EnableChild('ardt_garantbo')})
linkpc_url.u('XUXHMWVHFR',function(){return 'ardt_ae_saldianno_rap?m_bInnerChild=true'+GetLinkPCKeys('ardt_ae_saldianno_rap')+'&m_bRowsChild='+EnableChild('ardt_ae_saldianno_rap')})
linkpc_url.u('BOCKZFOGBL',function(){return 'ardt_saldi_idp?m_bInnerChild=true'+GetLinkPCKeys('ardt_saldi_idp')+'&m_bRowsChild='+EnableChild('ardt_saldi_idp')})
_ResetTracker();
function setEventHandlers() {
var c;
function KKXIPNXBWK_wrap_OnClick(event) {
return KKXIPNXBWK_Click();
}
SPBOUILib.SetButtonClick('KKXIPNXBWK',KKXIPNXBWK_wrap_OnClick);
function ZBUITWBMLO_wrap_OnClick(event) {
return href_ZBUITWBMLO();
}
SPBOUILib.SetImageClick('ZBUITWBMLO',ZBUITWBMLO_wrap_OnClick);
function ZBUITWBMLO_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ZBUITWBMLO',ZBUITWBMLO_wrap_OnKeyDown);
function BXHLWVGOYO_wrap_OnClick(event) {
return href_BXHLWVGOYO();
}
SPBOUILib.SetImageClick('BXHLWVGOYO',BXHLWVGOYO_wrap_OnClick);
function BXHLWVGOYO_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BXHLWVGOYO',BXHLWVGOYO_wrap_OnKeyDown);
function ZFPXBMEPWE_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_ZFPXBMEPWE():void(0));
}
SPBOUILib.SetImageClick('ZFPXBMEPWE',ZFPXBMEPWE_wrap_OnClick);
function ZFPXBMEPWE_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ZFPXBMEPWE',ZFPXBMEPWE_wrap_OnKeyDown);
function QIETKIRGON_wrap_OnClick(event) {
return QIETKIRGON_Click();
}
SPBOUILib.SetButtonClick('QIETKIRGON',QIETKIRGON_wrap_OnClick);
if (Ne(m_cFunction,'view')) {
function LXORWVRYJJ_wrap_Valid(event) {
return LXORWVRYJJ_Valid(event);
}
SPBOUILib.SetInputExit('LXORWVRYJJ',LXORWVRYJJ_wrap_Valid);
function LXORWVRYJJ_wrap_OnFocus(event) {
return LXORWVRYJJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('LXORWVRYJJ',LXORWVRYJJ_wrap_OnFocus);
function LXORWVRYJJ_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('LXORWVRYJJ',LXORWVRYJJ_wrap_OnKeyPress);
function LXORWVRYJJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('LXORWVRYJJ',LXORWVRYJJ_wrap_OnKeyDown);
function AQAARAIPOR_wrap_Valid(event) {
return AQAARAIPOR_Valid(event);
}
SPBOUILib.SetInputExit('AQAARAIPOR',AQAARAIPOR_wrap_Valid);
function AQAARAIPOR_wrap_OnFocus(event) {
return AQAARAIPOR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AQAARAIPOR',AQAARAIPOR_wrap_OnFocus);
function AQAARAIPOR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AQAARAIPOR',AQAARAIPOR_wrap_OnKeyDown);
function ZFOHYLVPYN_wrap_Valid(event) {
return ZFOHYLVPYN_Valid(event);
}
SPBOUILib.SetComboChange('ZFOHYLVPYN',ZFOHYLVPYN_wrap_Valid);
function ZFOHYLVPYN_wrap_OnFocus(event) {
return ZFOHYLVPYN_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZFOHYLVPYN',ZFOHYLVPYN_wrap_OnFocus);
function ZFOHYLVPYN_wrap_Blur(event) {
return ZFOHYLVPYN_OnBlur(event);
}
SPBOUILib.SetInputExit('ZFOHYLVPYN',ZFOHYLVPYN_wrap_Blur);
function KKXIPNXBWK_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KKXIPNXBWK',KKXIPNXBWK_wrap_OnKeyDown);
function BHAVHLFPAC_wrap_Valid(event) {
return BHAVHLFPAC_Valid(event);
}
SPBOUILib.SetComboChange('BHAVHLFPAC',BHAVHLFPAC_wrap_Valid);
function BHAVHLFPAC_wrap_OnFocus(event) {
return BHAVHLFPAC_OnFocus(event);
}
SPBOUILib.SetInputEnter('BHAVHLFPAC',BHAVHLFPAC_wrap_OnFocus);
function BHAVHLFPAC_wrap_Blur(event) {
return BHAVHLFPAC_OnBlur(event);
}
SPBOUILib.SetInputExit('BHAVHLFPAC',BHAVHLFPAC_wrap_Blur);
function QBUCLWUNFT_wrap_Valid(event) {
return QBUCLWUNFT_Valid(event);
}
SPBOUILib.SetComboChange('QBUCLWUNFT',QBUCLWUNFT_wrap_Valid);
function QBUCLWUNFT_wrap_OnFocus(event) {
return QBUCLWUNFT_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBUCLWUNFT',QBUCLWUNFT_wrap_OnFocus);
function QBUCLWUNFT_wrap_Blur(event) {
return QBUCLWUNFT_OnBlur(event);
}
SPBOUILib.SetInputExit('QBUCLWUNFT',QBUCLWUNFT_wrap_Blur);
function AABRTCZWUY_wrap_Valid(event) {
return AABRTCZWUY_Valid(event);
}
SPBOUILib.SetCheckboxClick('AABRTCZWUY',AABRTCZWUY_wrap_Valid);
function AABRTCZWUY_wrap_OnFocus(event) {
return AABRTCZWUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('AABRTCZWUY',AABRTCZWUY_wrap_OnFocus);
function AABRTCZWUY_wrap_Blur(event) {
return AABRTCZWUY_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('AABRTCZWUY',AABRTCZWUY_wrap_Blur);
function BCLYMGMBLK_wrap_Valid(event) {
return BCLYMGMBLK_Valid(event);
}
SPBOUILib.SetComboChange('BCLYMGMBLK',BCLYMGMBLK_wrap_Valid);
function BCLYMGMBLK_wrap_OnFocus(event) {
return BCLYMGMBLK_OnFocus(event);
}
SPBOUILib.SetInputEnter('BCLYMGMBLK',BCLYMGMBLK_wrap_OnFocus);
function BCLYMGMBLK_wrap_Blur(event) {
return BCLYMGMBLK_OnBlur(event);
}
SPBOUILib.SetInputExit('BCLYMGMBLK',BCLYMGMBLK_wrap_Blur);
function RUMXLFCOKA_wrap_Valid(event) {
return RUMXLFCOKA_Valid(event);
}
SPBOUILib.SetInputExit('RUMXLFCOKA',RUMXLFCOKA_wrap_Valid);
function RUMXLFCOKA_wrap_OnFocus(event) {
return RUMXLFCOKA_OnFocus(event);
}
SPBOUILib.SetInputEnter('RUMXLFCOKA',RUMXLFCOKA_wrap_OnFocus);
function RUMXLFCOKA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RUMXLFCOKA',RUMXLFCOKA_wrap_OnKeyDown);
function RUMXLFCOKA_ZOOM_setHandlers() {
function RUMXLFCOKA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?RUMXLFCOKA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('RUMXLFCOKA_ZOOM',RUMXLFCOKA_ZOOM_wrap_OnClick);
function RUMXLFCOKA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('RUMXLFCOKA_ZOOM',RUMXLFCOKA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('RUMXLFCOKA',RUMXLFCOKA_ZOOM_setHandlers);
function WRZZQXZUXK_wrap_Valid(event) {
return WRZZQXZUXK_Valid(event);
}
SPBOUILib.SetInputExit('WRZZQXZUXK',WRZZQXZUXK_wrap_Valid);
function WRZZQXZUXK_wrap_OnFocus(event) {
return WRZZQXZUXK_OnFocus(event);
}
SPBOUILib.SetInputEnter('WRZZQXZUXK',WRZZQXZUXK_wrap_OnFocus);
function WRZZQXZUXK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WRZZQXZUXK',WRZZQXZUXK_wrap_OnKeyDown);
function LSSRJEUOJW_wrap_Valid(event) {
return LSSRJEUOJW_Valid(event);
}
SPBOUILib.SetComboChange('LSSRJEUOJW',LSSRJEUOJW_wrap_Valid);
function LSSRJEUOJW_wrap_OnFocus(event) {
return LSSRJEUOJW_OnFocus(event);
}
SPBOUILib.SetInputEnter('LSSRJEUOJW',LSSRJEUOJW_wrap_OnFocus);
function LSSRJEUOJW_wrap_Blur(event) {
return LSSRJEUOJW_OnBlur(event);
}
SPBOUILib.SetInputExit('LSSRJEUOJW',LSSRJEUOJW_wrap_Blur);
function VSHUPFYWOC_wrap_Valid(event) {
return VSHUPFYWOC_Valid(event);
}
SPBOUILib.SetInputExit('VSHUPFYWOC',VSHUPFYWOC_wrap_Valid);
function VSHUPFYWOC_wrap_OnFocus(event) {
return VSHUPFYWOC_OnFocus(event);
}
SPBOUILib.SetInputEnter('VSHUPFYWOC',VSHUPFYWOC_wrap_OnFocus);
function VSHUPFYWOC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VSHUPFYWOC',VSHUPFYWOC_wrap_OnKeyDown);
function VASVGQZJGP_wrap_Valid(event) {
return VASVGQZJGP_Valid(event);
}
SPBOUILib.SetInputExit('VASVGQZJGP',VASVGQZJGP_wrap_Valid);
function VASVGQZJGP_wrap_OnFocus(event) {
return VASVGQZJGP_OnFocus(event);
}
SPBOUILib.SetInputEnter('VASVGQZJGP',VASVGQZJGP_wrap_OnFocus);
function VASVGQZJGP_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VASVGQZJGP',VASVGQZJGP_wrap_OnKeyDown);
function CKJQULDXKW_wrap_Valid(event) {
return CKJQULDXKW_Valid(event);
}
SPBOUILib.SetInputExit('CKJQULDXKW',CKJQULDXKW_wrap_Valid);
function CKJQULDXKW_wrap_OnFocus(event) {
return CKJQULDXKW_OnFocus(event);
}
SPBOUILib.SetInputEnter('CKJQULDXKW',CKJQULDXKW_wrap_OnFocus);
function CKJQULDXKW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('CKJQULDXKW',CKJQULDXKW_wrap_OnKeyDown);
function CKJQULDXKW_ZOOM_setHandlers() {
function CKJQULDXKW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?CKJQULDXKW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('CKJQULDXKW_ZOOM',CKJQULDXKW_ZOOM_wrap_OnClick);
function CKJQULDXKW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('CKJQULDXKW_ZOOM',CKJQULDXKW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('CKJQULDXKW',CKJQULDXKW_ZOOM_setHandlers);
function MXYTQLATHC_wrap_Valid(event) {
return MXYTQLATHC_Valid(event);
}
SPBOUILib.SetInputExit('MXYTQLATHC',MXYTQLATHC_wrap_Valid);
function MXYTQLATHC_wrap_OnFocus(event) {
return MXYTQLATHC_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXYTQLATHC',MXYTQLATHC_wrap_OnFocus);
function MXYTQLATHC_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('MXYTQLATHC',MXYTQLATHC_wrap_OnKeyPress);
function MXYTQLATHC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MXYTQLATHC',MXYTQLATHC_wrap_OnKeyDown);
function SXTYCPHBIM_wrap_Valid(event) {
return SXTYCPHBIM_Valid(event);
}
SPBOUILib.SetInputExit('SXTYCPHBIM',SXTYCPHBIM_wrap_Valid);
function SXTYCPHBIM_wrap_OnFocus(event) {
return SXTYCPHBIM_OnFocus(event);
}
SPBOUILib.SetInputEnter('SXTYCPHBIM',SXTYCPHBIM_wrap_OnFocus);
function SXTYCPHBIM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SXTYCPHBIM',SXTYCPHBIM_wrap_OnKeyDown);
function SXTYCPHBIM_ZOOM_setHandlers() {
function SXTYCPHBIM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SXTYCPHBIM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SXTYCPHBIM_ZOOM',SXTYCPHBIM_ZOOM_wrap_OnClick);
function SXTYCPHBIM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SXTYCPHBIM_ZOOM',SXTYCPHBIM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SXTYCPHBIM',SXTYCPHBIM_ZOOM_setHandlers);
function KBIUAXUDXA_wrap_Valid(event) {
return KBIUAXUDXA_Valid(event);
}
SPBOUILib.SetInputExit('KBIUAXUDXA',KBIUAXUDXA_wrap_Valid);
function KBIUAXUDXA_wrap_OnFocus(event) {
return KBIUAXUDXA_OnFocus(event);
}
SPBOUILib.SetInputEnter('KBIUAXUDXA',KBIUAXUDXA_wrap_OnFocus);
function KBIUAXUDXA_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('KBIUAXUDXA',KBIUAXUDXA_wrap_OnKeyPress);
function KBIUAXUDXA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KBIUAXUDXA',KBIUAXUDXA_wrap_OnKeyDown);
function QJSTZIPOQB_wrap_Valid(event) {
return QJSTZIPOQB_Valid(event);
}
SPBOUILib.SetInputExit('QJSTZIPOQB',QJSTZIPOQB_wrap_Valid);
function QJSTZIPOQB_wrap_OnFocus(event) {
return QJSTZIPOQB_OnFocus(event);
}
SPBOUILib.SetInputEnter('QJSTZIPOQB',QJSTZIPOQB_wrap_OnFocus);
function QJSTZIPOQB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QJSTZIPOQB',QJSTZIPOQB_wrap_OnKeyDown);
function QJSTZIPOQB_ZOOM_setHandlers() {
function QJSTZIPOQB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QJSTZIPOQB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QJSTZIPOQB_ZOOM',QJSTZIPOQB_ZOOM_wrap_OnClick);
function QJSTZIPOQB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QJSTZIPOQB_ZOOM',QJSTZIPOQB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QJSTZIPOQB',QJSTZIPOQB_ZOOM_setHandlers);
function UDAYHICPVB_wrap_Valid(event) {
return UDAYHICPVB_Valid(event);
}
SPBOUILib.SetInputExit('UDAYHICPVB',UDAYHICPVB_wrap_Valid);
function UDAYHICPVB_wrap_OnFocus(event) {
return UDAYHICPVB_OnFocus(event);
}
SPBOUILib.SetInputEnter('UDAYHICPVB',UDAYHICPVB_wrap_OnFocus);
function UDAYHICPVB_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('UDAYHICPVB',UDAYHICPVB_wrap_OnKeyPress);
function UDAYHICPVB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UDAYHICPVB',UDAYHICPVB_wrap_OnKeyDown);
function SFFFOYOWNH_wrap_Valid(event) {
return SFFFOYOWNH_Valid(event);
}
SPBOUILib.SetInputExit('SFFFOYOWNH',SFFFOYOWNH_wrap_Valid);
function SFFFOYOWNH_wrap_OnFocus(event) {
return SFFFOYOWNH_OnFocus(event);
}
SPBOUILib.SetInputEnter('SFFFOYOWNH',SFFFOYOWNH_wrap_OnFocus);
function SFFFOYOWNH_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SFFFOYOWNH',SFFFOYOWNH_wrap_OnKeyDown);
function SFFFOYOWNH_ZOOM_setHandlers() {
function SFFFOYOWNH_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SFFFOYOWNH_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SFFFOYOWNH_ZOOM',SFFFOYOWNH_ZOOM_wrap_OnClick);
function SFFFOYOWNH_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SFFFOYOWNH_ZOOM',SFFFOYOWNH_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SFFFOYOWNH',SFFFOYOWNH_ZOOM_setHandlers);
function ETALZDRBSO_wrap_Valid(event) {
return ETALZDRBSO_Valid(event);
}
SPBOUILib.SetInputExit('ETALZDRBSO',ETALZDRBSO_wrap_Valid);
function ETALZDRBSO_wrap_OnFocus(event) {
return ETALZDRBSO_OnFocus(event);
}
SPBOUILib.SetInputEnter('ETALZDRBSO',ETALZDRBSO_wrap_OnFocus);
function ETALZDRBSO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('ETALZDRBSO',ETALZDRBSO_wrap_OnKeyPress);
function ETALZDRBSO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ETALZDRBSO',ETALZDRBSO_wrap_OnKeyDown);
function NOBMPHKVTX_wrap_Valid(event) {
return NOBMPHKVTX_Valid(event);
}
SPBOUILib.SetInputExit('NOBMPHKVTX',NOBMPHKVTX_wrap_Valid);
function NOBMPHKVTX_wrap_OnFocus(event) {
return NOBMPHKVTX_OnFocus(event);
}
SPBOUILib.SetInputEnter('NOBMPHKVTX',NOBMPHKVTX_wrap_OnFocus);
function NOBMPHKVTX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NOBMPHKVTX',NOBMPHKVTX_wrap_OnKeyDown);
function NOBMPHKVTX_ZOOM_setHandlers() {
function NOBMPHKVTX_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?NOBMPHKVTX_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('NOBMPHKVTX_ZOOM',NOBMPHKVTX_ZOOM_wrap_OnClick);
function NOBMPHKVTX_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('NOBMPHKVTX_ZOOM',NOBMPHKVTX_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('NOBMPHKVTX',NOBMPHKVTX_ZOOM_setHandlers);
function QBTVZDKLCO_wrap_Valid(event) {
return QBTVZDKLCO_Valid(event);
}
SPBOUILib.SetInputExit('QBTVZDKLCO',QBTVZDKLCO_wrap_Valid);
function QBTVZDKLCO_wrap_OnFocus(event) {
return QBTVZDKLCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('QBTVZDKLCO',QBTVZDKLCO_wrap_OnFocus);
function QBTVZDKLCO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('QBTVZDKLCO',QBTVZDKLCO_wrap_OnKeyPress);
function QBTVZDKLCO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('QBTVZDKLCO',QBTVZDKLCO_wrap_OnKeyDown);
function DJOWYRMDDC_wrap_Valid(event) {
return DJOWYRMDDC_Valid(event);
}
SPBOUILib.SetInputExit('DJOWYRMDDC',DJOWYRMDDC_wrap_Valid);
function DJOWYRMDDC_wrap_OnFocus(event) {
return DJOWYRMDDC_OnFocus(event);
}
SPBOUILib.SetInputEnter('DJOWYRMDDC',DJOWYRMDDC_wrap_OnFocus);
function DJOWYRMDDC_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DJOWYRMDDC',DJOWYRMDDC_wrap_OnKeyDown);
function DJOWYRMDDC_ZOOM_setHandlers() {
function DJOWYRMDDC_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?DJOWYRMDDC_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('DJOWYRMDDC_ZOOM',DJOWYRMDDC_ZOOM_wrap_OnClick);
function DJOWYRMDDC_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('DJOWYRMDDC_ZOOM',DJOWYRMDDC_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('DJOWYRMDDC',DJOWYRMDDC_ZOOM_setHandlers);
function RUWEXWJASG_wrap_Valid(event) {
return RUWEXWJASG_Valid(event);
}
SPBOUILib.SetInputExit('RUWEXWJASG',RUWEXWJASG_wrap_Valid);
function RUWEXWJASG_wrap_OnFocus(event) {
return RUWEXWJASG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RUWEXWJASG',RUWEXWJASG_wrap_OnFocus);
function RUWEXWJASG_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('RUWEXWJASG',RUWEXWJASG_wrap_OnKeyPress);
function RUWEXWJASG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RUWEXWJASG',RUWEXWJASG_wrap_OnKeyDown);
function SMVVFHCEHA_wrap_Valid(event) {
return SMVVFHCEHA_Valid(event);
}
SPBOUILib.SetComboChange('SMVVFHCEHA',SMVVFHCEHA_wrap_Valid);
function SMVVFHCEHA_wrap_OnFocus(event) {
return SMVVFHCEHA_OnFocus(event);
}
SPBOUILib.SetInputEnter('SMVVFHCEHA',SMVVFHCEHA_wrap_OnFocus);
function SMVVFHCEHA_wrap_Blur(event) {
return SMVVFHCEHA_OnBlur(event);
}
SPBOUILib.SetInputExit('SMVVFHCEHA',SMVVFHCEHA_wrap_Blur);
function MXITFMGTNB_wrap_Valid(event) {
return MXITFMGTNB_Valid(event);
}
SPBOUILib.SetInputExit('MXITFMGTNB',MXITFMGTNB_wrap_Valid);
function MXITFMGTNB_wrap_OnFocus(event) {
return MXITFMGTNB_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXITFMGTNB',MXITFMGTNB_wrap_OnFocus);
function MXITFMGTNB_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('MXITFMGTNB',MXITFMGTNB_wrap_OnKeyPress);
function MXITFMGTNB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('MXITFMGTNB',MXITFMGTNB_wrap_OnKeyDown);
function MXITFMGTNB_ZOOM_setHandlers() {
function MXITFMGTNB_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?MXITFMGTNB_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('MXITFMGTNB_ZOOM',MXITFMGTNB_ZOOM_wrap_OnClick);
function MXITFMGTNB_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('MXITFMGTNB_ZOOM',MXITFMGTNB_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('MXITFMGTNB',MXITFMGTNB_ZOOM_setHandlers);
function QLLLNEUVYW_wrap_Valid(event) {
return QLLLNEUVYW_Valid(event);
}
SPBOUILib.SetInputExit('QLLLNEUVYW',QLLLNEUVYW_wrap_Valid);
function QLLLNEUVYW_wrap_OnFocus(event) {
return QLLLNEUVYW_OnFocus(event);
}
SPBOUILib.SetInputEnter('QLLLNEUVYW',QLLLNEUVYW_wrap_OnFocus);
function QLLLNEUVYW_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('QLLLNEUVYW',QLLLNEUVYW_wrap_OnKeyPress);
function QLLLNEUVYW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('QLLLNEUVYW',QLLLNEUVYW_wrap_OnKeyDown);
function QLLLNEUVYW_ZOOM_setHandlers() {
function QLLLNEUVYW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?QLLLNEUVYW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('QLLLNEUVYW_ZOOM',QLLLNEUVYW_ZOOM_wrap_OnClick);
function QLLLNEUVYW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QLLLNEUVYW_ZOOM',QLLLNEUVYW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('QLLLNEUVYW',QLLLNEUVYW_ZOOM_setHandlers);
function DOXBACRWUU_wrap_Valid(event) {
return DOXBACRWUU_Valid(event);
}
SPBOUILib.SetInputExit('DOXBACRWUU',DOXBACRWUU_wrap_Valid);
function DOXBACRWUU_wrap_OnFocus(event) {
return DOXBACRWUU_OnFocus(event);
}
SPBOUILib.SetInputEnter('DOXBACRWUU',DOXBACRWUU_wrap_OnFocus);
function DOXBACRWUU_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('DOXBACRWUU',DOXBACRWUU_wrap_OnKeyPress);
function DOXBACRWUU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DOXBACRWUU',DOXBACRWUU_wrap_OnKeyDown);
function OXGBDTWKSX_wrap_Valid(event) {
return OXGBDTWKSX_Valid(event);
}
SPBOUILib.SetInputExit('OXGBDTWKSX',OXGBDTWKSX_wrap_Valid);
function OXGBDTWKSX_wrap_OnFocus(event) {
return OXGBDTWKSX_OnFocus(event);
}
SPBOUILib.SetInputEnter('OXGBDTWKSX',OXGBDTWKSX_wrap_OnFocus);
function OXGBDTWKSX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OXGBDTWKSX',OXGBDTWKSX_wrap_OnKeyDown);
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
function GIJHAKTZAN_wrap_Valid(event) {
return GIJHAKTZAN_Valid(event);
}
SPBOUILib.SetCheckboxClick('GIJHAKTZAN',GIJHAKTZAN_wrap_Valid);
function GIJHAKTZAN_wrap_OnFocus(event) {
return GIJHAKTZAN_OnFocus(event);
}
SPBOUILib.SetInputEnter('GIJHAKTZAN',GIJHAKTZAN_wrap_OnFocus);
function GIJHAKTZAN_wrap_Blur(event) {
return GIJHAKTZAN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GIJHAKTZAN',GIJHAKTZAN_wrap_Blur);
function QIETKIRGON_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QIETKIRGON',QIETKIRGON_wrap_OnKeyDown);
function HBPZQIPSZE_wrap_Valid(event) {
return HBPZQIPSZE_Valid(event);
}
SPBOUILib.SetInputExit('HBPZQIPSZE',HBPZQIPSZE_wrap_Valid);
function HBPZQIPSZE_wrap_OnFocus(event) {
return HBPZQIPSZE_OnFocus(event);
}
SPBOUILib.SetInputEnter('HBPZQIPSZE',HBPZQIPSZE_wrap_OnFocus);
function HBPZQIPSZE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HBPZQIPSZE',HBPZQIPSZE_wrap_OnKeyDown);
function HBPZQIPSZE_ZOOM_setHandlers() {
function HBPZQIPSZE_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?HBPZQIPSZE_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('HBPZQIPSZE_ZOOM',HBPZQIPSZE_ZOOM_wrap_OnClick);
function HBPZQIPSZE_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('HBPZQIPSZE_ZOOM',HBPZQIPSZE_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('HBPZQIPSZE',HBPZQIPSZE_ZOOM_setHandlers);
function SSYXHQXJLD_wrap_Valid(event) {
return SSYXHQXJLD_Valid(event);
}
SPBOUILib.SetInputExit('SSYXHQXJLD',SSYXHQXJLD_wrap_Valid);
function SSYXHQXJLD_wrap_OnFocus(event) {
return SSYXHQXJLD_OnFocus(event);
}
SPBOUILib.SetInputEnter('SSYXHQXJLD',SSYXHQXJLD_wrap_OnFocus);
function SSYXHQXJLD_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SSYXHQXJLD',SSYXHQXJLD_wrap_OnKeyDown);
function SSYXHQXJLD_ZOOM_setHandlers() {
function SSYXHQXJLD_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SSYXHQXJLD_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SSYXHQXJLD_ZOOM',SSYXHQXJLD_ZOOM_wrap_OnClick);
function SSYXHQXJLD_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SSYXHQXJLD_ZOOM',SSYXHQXJLD_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SSYXHQXJLD',SSYXHQXJLD_ZOOM_setHandlers);
function YSBAKLZECK_wrap_Valid(event) {
return YSBAKLZECK_Valid(event);
}
SPBOUILib.SetInputExit('YSBAKLZECK',YSBAKLZECK_wrap_Valid);
function YSBAKLZECK_wrap_OnFocus(event) {
return YSBAKLZECK_OnFocus(event);
}
SPBOUILib.SetInputEnter('YSBAKLZECK',YSBAKLZECK_wrap_OnFocus);
function YSBAKLZECK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YSBAKLZECK',YSBAKLZECK_wrap_OnKeyDown);
function UYHOJSIFEU_wrap_Valid(event) {
return UYHOJSIFEU_Valid(event);
}
SPBOUILib.SetInputExit('UYHOJSIFEU',UYHOJSIFEU_wrap_Valid);
function UYHOJSIFEU_wrap_OnFocus(event) {
return UYHOJSIFEU_OnFocus(event);
}
SPBOUILib.SetInputEnter('UYHOJSIFEU',UYHOJSIFEU_wrap_OnFocus);
function UYHOJSIFEU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UYHOJSIFEU',UYHOJSIFEU_wrap_OnKeyDown);
function UYHOJSIFEU_ZOOM_setHandlers() {
function UYHOJSIFEU_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?UYHOJSIFEU_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('UYHOJSIFEU_ZOOM',UYHOJSIFEU_ZOOM_wrap_OnClick);
function UYHOJSIFEU_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('UYHOJSIFEU_ZOOM',UYHOJSIFEU_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('UYHOJSIFEU',UYHOJSIFEU_ZOOM_setHandlers);
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
if (Ne(typeof(w_Delegati),'undefined')) {
w_Delegati.raiseEvent('armt_anarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Operazioni),'undefined')) {
w_Operazioni.raiseEvent('armt_anarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Frazionate),'undefined')) {
w_Frazionate.raiseEvent('armt_anarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Intestatari),'undefined')) {
w_Intestatari.raiseEvent('armt_anarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Informazioni),'undefined')) {
w_Informazioni.raiseEvent('armt_anarap_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.edit={"page_1":["AQAARAIPOR"],"page_2":["QIETKIRGON"],"page_5":["HBPZQIPSZE"],"page_7":["SSYXHQXJLD"]};
FocusFirstComponent.query={"page_1":["LXORWVRYJJ"],"page_5":["HBPZQIPSZE"],"page_7":["SSYXHQXJLD"]};
FocusFirstComponent.otherwise={"page_1":["LXORWVRYJJ"],"page_2":["QIETKIRGON"],"page_5":["HBPZQIPSZE"],"page_7":["SSYXHQXJLD"]};
function Help() {
windowOpenForeground('../doc/armt_anarap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_garantbo() {
SetModified();
}
function SetModified_ardt_ae_saldianno_rap() {
SetModified();
}
function SetModified_ardt_saldi_idp() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_5')) {
if (ChildToLoad('ZSYGOPYXSA')) {
LoadContext.lc(1,'ZSYGOPYXSA');
} else {
LibJavascript.RefreshChildGrid('ZSYGOPYXSA');
}
}
if (Eq(page,'page_6')) {
if (ChildToLoad('XUXHMWVHFR')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('XUXHMWVHFR')) {
LoadContext.lc(1,'XUXHMWVHFR');
}
} else {
LibJavascript.RefreshChildGrid('XUXHMWVHFR');
}
}
if (Eq(page,'page_7')) {
if (ChildToLoad('BOCKZFOGBL')) {
LoadContext.lc(1,'BOCKZFOGBL');
} else {
LibJavascript.RefreshChildGrid('BOCKZFOGBL');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"DatiBase"});
GetLayerID.Layers.push({"id":"RFAIYHSGII","name":"Categorie"});
GetLayerID.Layers.push({"id":"GJZISGEBVV","name":"DatiBase"});
GetLayerID.Layers.push({"id":"LZCEHELAXJ","name":"Rapporto"});
GetLayerID.Layers.push({"id":"EHSQLOIDHO","name":"Deleghe"});
GetLayerID.Layers.push({"id":"LWDMGLAEON","name":"Garantiti"});
GetLayerID.Layers.push({"id":"TUIMYVJMXF","name":"Dipendenza"});
GetLayerID.Layers.push({"id":"MUCCIMEJEB","name":"Saldi"});
GetLayerID.Layers.push({"id":"GURCMCSTQS","name":"SaldiCanali"});
GetLayerID.Layers.push({"id":"PHCJDNQLLF","name":"AltriDati"});
function DeclareWVs() {
var a = arguments;
w_CODDIP=a[0];
w_RAPPORTO=a[1];
w_DESCRAP=a[2];
w_TIPORAP=a[3];
w_TIPOAG=a[4];
w_ISOAGE=a[5];
w_NOPROT=a[6];
w_FLAGLIRE=a[7];
w_VALUTA=a[8];
w_PRGIMPRAP=a[9];
op_PRGIMPRAP=a[10];
w_IBAN=a[11];
w_CODOGG=a[12];
w_NATURA=a[13];
w_SCOPO=a[14];
w_DURAT=a[15];
w_RFREQ=a[16];
w_AMMONT=a[17];
w_RIMP=a[18];
w_AREAGEO=a[19];
w_RAREA=a[20];
w_MODSVOL=a[21];
w_RCOMP=a[22];
w_RAGIO=a[23];
w_RRAGIO=a[24];
w_TIPO=a[25];
w_RTIPO=a[26];
w_CODDIPE=a[27];
w_RISGLOB=a[28];
w_DATAPROF=a[29];
w_DATAREVPROF=a[30];
w_MITIG=a[31];
w_MITGDOC=a[32];
w_CATEG01=a[33];
w_CATEG02=a[34];
w_CATEG03=a[35];
w_CATEG04=a[36];
w_CATEG05=a[37];
w_CATEGORIA=a[38];
w_NOCANC=a[39];
w_MACODICE=a[40];
w_SPLITCODE=a[41];
w_CODICELR=a[42];
w_gTipInter=a[43];
w_gBrowser=a[44];
w_gTelepass=a[45];
w_gCodDip=a[46];
w_descval=a[47];
w_daticoll=a[48];
w_xdescmodsvo=a[49];
w_xdescareag=a[50];
w_xdescplauso=a[51];
w_xdesctipor=a[52];
w_xdescfreq=a[53];
w_xdescammo=a[54];
w_xDESDIPE=a[55];
w_xMADESCRI=a[56];
w_xRAGLEG=a[57];
w_mess=a[58];
w_xC1DESCRI=a[59];
w_xC2DESCRI=a[60];
w_xC3DESCRI=a[61];
w_xC4DESCRI=a[62];
w_xC5DESCRI=a[63];
w_titolo=a[64];
op_codazi=a[65];
o_RFAIYHSGII_expand=null;
o_RFAIYHSGII_collapse=null;
m_cWv_ardt_garantbo=a[66];
m_cWv_ardt_ae_saldianno_rap=a[67];
m_cWv_ardt_saldi_idp=a[68];
if (Gt(a.length,69)) {
m_cErrorInChild='';
}
if (Gt(a.length,69)) {
o_TIPOAG=w_TIPOAG;
o_FLAGLIRE=w_FLAGLIRE;
o_VALUTA=w_VALUTA;
o_DURAT=w_DURAT;
o_AMMONT=w_AMMONT;
o_AREAGEO=w_AREAGEO;
o_MODSVOL=w_MODSVOL;
o_RAGIO=w_RAGIO;
o_TIPO=w_TIPO;
o_CATEG01=w_CATEG01;
o_CATEG02=w_CATEG02;
o_CATEG03=w_CATEG03;
o_CATEG04=w_CATEG04;
o_CATEG05=w_CATEG05;
}
m_PrimaryKeys=['RAPPORTO'];
}
function i_PrimaryKey() {
return 'anarapbo'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
GetLinkPCKeys.set_o('ardt_garantbo',false);
GetLinkPCKeys.set_o('ardt_ae_saldianno_rap',false);
GetLinkPCKeys.set_o('ardt_saldi_idp',false);
GetLinkPCKeys.o['ardt_garantbo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_ae_saldianno_rap']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
GetLinkPCKeys.o['ardt_saldi_idp']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
resizeChildIframe.children['ardt_garantbo']=true;
resizeChildIframe.children['ardt_saldi_idp']=true;
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('ZSYGOPYXSA',function(){return FrameRef('ardt_garantbo')},1,'ardt_garantbo',0,5)
LoadContext.f('XUXHMWVHFR',function(){return FrameRef('ardt_ae_saldianno_rap')},1,'ardt_ae_saldianno_rap',0,6)
LoadContext.f('BOCKZFOGBL',function(){return FrameRef('ardt_saldi_idp')},1,'ardt_saldi_idp',0,7)
GetSelectedChildPage.child={'ardt_garantbo': function(){return FrameRef('ardt_garantbo')}, 'ardt_ae_saldianno_rap': function(){return FrameRef('ardt_ae_saldianno_rap')}, 'ardt_saldi_idp': function(){return FrameRef('ardt_saldi_idp')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_anarap',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_divise','C'),"fldValues":[{"expression":function() { return WtA(w_VALUTA,'C'); },"field":"CODVAL","type":"C"},{"expression":function() { return WtA(w_descval,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbvalute','C'),"uid":"RUMXLFCOKA"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('ammt_tbdurata','C'),"fldValues":[{"expression":function() { return WtA(w_DURAT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescfreq,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RFREQ,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbdurata','C'),"uid":"CKJQULDXKW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AMMONT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescammo,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbimporto','C'),"uid":"SXTYCPHBIM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AREAGEO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescareag,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbareegeog','C'),"uid":"QJSTZIPOQB"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_MODSVOL,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescmodsvo,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbsvolgim','C'),"uid":"SFFFOYOWNH"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAGIO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescplauso,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbplauso','C'),"uid":"NOBMPHKVTX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TIPO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdesctipor,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtiporisc','C'),"uid":"DJOWYRMDDC"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg01','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG01,'C'); },"field":"C1CODICE","type":"C"},{"expression":function() { return WtA(w_xC1DESCRI,'C'); },"field":"C1DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg01','C'),"uid":"CANUTVNGFD"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg02','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG02,'C'); },"field":"C2CODICE","type":"C"},{"expression":function() { return WtA(w_xC2DESCRI,'C'); },"field":"C2DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg02','C'),"uid":"IXGRJLAKIQ"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg03','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG03,'C'); },"field":"C3CODICE","type":"C"},{"expression":function() { return WtA(w_xC3DESCRI,'C'); },"field":"C3DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg03','C'),"uid":"NKIXCWZJHO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg04','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG04,'C'); },"field":"C4CODICE","type":"C"},{"expression":function() { return WtA(w_xC4DESCRI,'C'); },"field":"C4DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg04','C'),"uid":"JQLGHMLOKO"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('opemt_tbcateg05','C'),"fldValues":[{"expression":function() { return WtA(w_CATEG05,'C'); },"field":"C5CODICE","type":"C"},{"expression":function() { return WtA(w_xC5DESCRI,'C'); },"field":"C5DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcateg05','C'),"uid":"QVBZSFMTVP"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_anadip','C'),"fldValues":[{"expression":function() { return WtA(w_CODDIPE,'C'); },"field":"CODDIP","type":"C"},{"expression":function() { return WtA(w_xDESDIPE,'C'); },"field":"DESCRIZ","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('anadip','C'),"uid":"HBPZQIPSZE"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_MACODICE,'C'); },"field":"MACODICE","type":"C"},{"expression":function() { return WtA(w_xMADESCRI,'C'); },"field":"MADESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbmacage','C'),"uid":"SSYXHQXJLD"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_CODICELR,'C'); },"field":"CONNES","type":"C"},{"expression":function() { return WtA(w_xRAGLEG,'C'); },"field":"RAGSOC","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('personbo','C'),"uid":"UYHOJSIFEU"});
}
_Obli('RRAGIO',1,'QBTVZDKLCO',false)
_Obli('TIPO',0,'DJOWYRMDDC',false)
_Obli('TIPO',0,'DTDVSGUEWE',false)
_Obli('CODICELR',0,'UYHOJSIFEU',false,"11815361151")
_Obli('SPLITCODE',0,'YSBAKLZECK',false,"115410470")
_Obli('MACODICE',0,'SSYXHQXJLD',false,"11283631966")
_Obli('RAPPORTO',0,'LXORWVRYJJ',false,"11116511596")
_Obli('DESCRAP',0,'AQAARAIPOR',false,"285808099")
_Obli('TIPORAP',0,'ZFOHYLVPYN',true,"1723736132")
_Obli('TIPOAG',0,'BHAVHLFPAC',false)
_Obli('ISOAGE',0,'QBUCLWUNFT',true,"1529904207",null,null,function() { return Eq(w_TIPOAG,'96') || Eq(w_TIPOAG,'97') })
_Obli('NOPROT',1,'AABRTCZWUY',false,"10194595222")
_Obli('FLAGLIRE',0,'BCLYMGMBLK',true,"109710548")
_Obli('VALUTA',0,'RUMXLFCOKA',true,"1730321404",'RUMXLFCOKA')
_Obli('RTIPO',1,'RUWEXWJASG',false)
_Obli('CATEG05',0,'QVBZSFMTVP',false,"157154740")
_Obli('IBAN',0,'WRZZQXZUXK',false,"337257")
_Obli('CODOGG',0,'LSSRJEUOJW',false,"11635074230")
_Obli('CATEG04',0,'JQLGHMLOKO',false,"157154740")
_Obli('NATURA',0,'VSHUPFYWOC',false)
_Obli('SCOPO',0,'VASVGQZJGP',false)
_Obli('DURAT',0,'CKJQULDXKW',false)
_Obli('DURAT',0,'VEAKSOSZMJ',false)
_Obli('CATEG02',0,'IXGRJLAKIQ',false,"157154996")
_Obli('RFREQ',1,'MXYTQLATHC',false)
_Obli('AMMONT',0,'SXTYCPHBIM',false)
_Obli('AMMONT',0,'FLHYCYAKON',false)
_Obli('CATEG03',0,'NKIXCWZJHO',false,"157155252")
_Obli('RIMP',1,'KBIUAXUDXA',false)
_Obli('AREAGEO',0,'QJSTZIPOQB',false)
_Obli('AREAGEO',0,'MDMTUJRAZF',false)
_Obli('NOCANC',1,'GIJHAKTZAN',false,"10138432524")
_Obli('RAREA',1,'UDAYHICPVB',false)
_Obli('MODSVOL',0,'SFFFOYOWNH',false)
_Obli('MODSVOL',0,'ZKJUEEUNAK',false)
_Obli('CODDIPE',0,'HBPZQIPSZE',false,"350773234")
_Obli('RCOMP',1,'ETALZDRBSO',false)
_Obli('RAGIO',0,'NOBMPHKVTX',false)
_Obli('RAGIO',0,'EAWVSIWQBM',false)
_Obli('MITGDOC',0,'OXGBDTWKSX',false,"210895516")
_Obli('MITIG',1,'DOXBACRWUU',false,"307787605")
_Obli('DATAREVPROF',2,'QLLLNEUVYW',false,"11148260655")
_Obli('DATAPROF',2,'MXITFMGTNB',false,"10252637878")
_Obli('CATEG01',0,'CANUTVNGFD',false,"157154740")
_Obli('RISGLOB',0,'SMVVFHCEHA',false,"10500809751")
