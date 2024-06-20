function FillCombosValues() {
FillCombo('IRLEJAUHCB','IRLEJAUHCB');
FillCombo('MBGANUUHRA','MBGANUUHRA');
FillCombo('LLYIGAMXRH','LLYIGAMXRH');
FillCombo('ZGNLLSFQHC','ZGNLLSFQHC');
}
function SetControlsValue() {
var c;
var tmp_subtitle = ToHTag(AsControlValue('NDG: '+LRTrim(w_CONNES)+' - '+'Nominativo: '+LRTrim(w_RAGSOC)));
if (Ne(e_subtitle,tmp_subtitle)) {
SetSubTitle(tmp_subtitle);
e_subtitle=tmp_subtitle;
}
SPBOUILib.SetInputValue('BGWRHXCTFO',function(){return WtH(w_gVerSim,'C',1,0,'')},w_gVerSim);
if(c=Ctrl('UYWIEUHCAL')) selectRadio(c,w_TIPOPERS,'C')
SPBOUILib.SetInputValue('TWTTDWKCRG',function(){return WtH(w_COGNOME,'C',26,0,'@!')},w_COGNOME);
SPBOUILib.SetInputValue('WWGIVGNUDW',function(){return WtH(w_NOME,'C',25,0,'@!')},w_NOME);
if(c=Ctrl('CZTHKEDVCO')) ChkboxCheckUncheck(c,1,w_CFESTERO)
if(c=Ctrl('CZTHKEDVCO')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('AWPNTOJIRR',function(){return WtH(w_RAGSOC,'C',70,0,'@!')},w_RAGSOC);
SPBOUILib.SetInputValue('YVIKEGPYPM',function(){return WtH(w_PAESE,'C',3,0,'')},w_PAESE);
SPBOUILib.SetInputValue('ODAYKSRECA',function(){return WtH(w_DESCCIT,'C',30,0,'@!')},w_DESCCIT);
SPBOUILib.SetInputValue('NOTZPDMYIA',function(){return WtH(w_PROVINCIA,'C',2,0,'')},w_PROVINCIA);
SPBOUILib.SetInputValue('RDAVOEETJG',function(){return WtH(w_CAP,'C',9,0,'')},w_CAP);
SPBOUILib.SetInputValue('BOTAJBWHHY',function(){return WtH(w_CODCAB,'C',6,0,'')},w_CODCAB);
SPBOUILib.SetInputValue('VYLHWTRQNX',function(){return WtH(w_DOMICILIO,'C',35,0,'')},w_DOMICILIO);
if(c=Ctrl('IRLEJAUHCB')) selectCombo(c,w_IDENT,'C')
SPBOUILib.SetInputValue('BYPEBFEOAJ',function(){return WtH(w_IDNASCOMUN,'C',40,0,'')},w_IDNASCOMUN);
SPBOUILib.SetInputValue('NEUBQNUEOJ',function(){return WtH(w_NASCOMUN,'C',30,0,'@!')},w_NASCOMUN);
SPBOUILib.SetInputValue('KPSCOABZLB',function(){return WtH(w_TIPINTER,'C',2,0,'')},w_TIPINTER);
SPBOUILib.SetInputValue('IOAMSFCCVV',function(){return WtH(w_IDNASSTATO,'C',10,0,'')},w_IDNASSTATO);
SPBOUILib.SetInputValue('HODZKKOSYW',function(){return WtH(w_NASSTATO,'C',30,0,'@!')},w_NASSTATO);
if(c=Ctrl('QPALJZMFCL')) selectCombo(c,w_SESSO,'C')
SPBOUILib.SetInputValue('XMGRWGFSFV',function(){return WtH(w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATANASC);
if(c=Ctrl('MBGANUUHRA')) selectCombo(c,w_TIPODOC,'C')
SPBOUILib.SetInputValue('HVEEMUJUUY',function(){return WtH(w_NUMDOCUM,'C',15,0,'')},w_NUMDOCUM);
SPBOUILib.SetInputValue('XHWYGOPPUN',function(){return WtH(w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARILASC);
SPBOUILib.SetInputValue('BNWXBPSIDG',function(){return WtH(w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATAVALI);
SPBOUILib.SetInputValue('HRNCPADUFU',function(){return WtH(w_AUTRILASC,'C',30,0,'')},w_AUTRILASC);
SPBOUILib.SetInputValue('OJJHIUDPFY',function(){return WtH(w_CODFISC,'C',16,0,'')},w_CODFISC);
SPBOUILib.SetInputValue('FHXWUTBNKI',function(){return WtH(w_PARTIVA,'C',14,0,'')},w_PARTIVA);
SPBOUILib.SetInputValue('JLTVZXPMKM',function(){return WtH(w_CONTO,'C',25,0,'')},w_CONTO);
if(c=Ctrl('LLYIGAMXRH')) selectCombo(c,w_SOTGRUP,'C')
SPBOUILib.SetInputValue('RVNHQCXNEM',function(){return WtH(w_RAMOGRUP,'C',3,0,'')},w_RAMOGRUP);
SPBOUILib.SetInputValue('SAQTIHOALW',function(){return WtH(w_ATTIV,'C',10,0,'')},w_ATTIV);
if(c=Ctrl('ZGNLLSFQHC')) selectCombo(c,w_SETTSINT,'C')
SPBOUILib.SetInputValue('YTPWDRMFUS',function(){return WtH(w_CONNES,'C',16,0,'')},w_CONNES);
if(c=Ctrl('RARXYHBSLM')) ChkboxCheckUncheck(c,1,w_NOTIT)
if(c=Ctrl('RARXYHBSLM')) ChkboxValueAssign(c,1,0,'N',1,0,'')
if(c=Ctrl('XFKXBQYUIU')) ChkboxCheckUncheck(c,'S',w_PEP)
if(c=Ctrl('XFKXBQYUIU')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DFNZBCOVFH')) ChkboxCheckUncheck(c,'S',w_flgaggfam)
if(c=Ctrl('DFNZBCOVFH')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RHCYCLTWOT')) ChkboxCheckUncheck(c,'S',w_CRIME)
if(c=Ctrl('RHCYCLTWOT')) ChkboxValueAssign(c,'S','N','C',1,0,'')
var tmp_PFEQRACAUA = ToHTag(AsControlValue((Ne(w_TIPOPERS,'G')?'Nominativo:':'Ragione Sociale:')));
if (Ne(e_PFEQRACAUA,tmp_PFEQRACAUA)) {
SPBOUILib.SetLabelValue('PFEQRACAUA','innerHTML',tmp_PFEQRACAUA);
e_PFEQRACAUA=tmp_PFEQRACAUA;
}
var tmp_ESVLUSNYWB = ToHTag(AsControlValue(w_dessta));
if (Ne(e_ESVLUSNYWB,tmp_ESVLUSNYWB)) {
SPBOUILib.SetLabelValue('ESVLUSNYWB','innerHTML',tmp_ESVLUSNYWB);
e_ESVLUSNYWB=tmp_ESVLUSNYWB;
}
var tmp_JCWRPFWYVW = ToHTag(AsControlValue(w_DESCRAMGRU));
if (Ne(e_JCWRPFWYVW,tmp_JCWRPFWYVW)) {
SPBOUILib.SetLabelValue('JCWRPFWYVW','innerHTML',tmp_JCWRPFWYVW);
e_JCWRPFWYVW=tmp_JCWRPFWYVW;
}
SPBOUILib.SetInputValue('FROMUIZATY',function(){return WtH(w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))},w_DATARETT);
var tmp_CPWCFGHBVH = ToHTag(AsControlValue(w_xdesctipatt));
if (Ne(e_CPWCFGHBVH,tmp_CPWCFGHBVH)) {
SPBOUILib.SetLabelValue('CPWCFGHBVH','innerHTML',tmp_CPWCFGHBVH);
e_CPWCFGHBVH=tmp_CPWCFGHBVH;
}
SPBOUILib.SetInputValue('UMKFMWBVUO',function(){return WtH(w_NOTE,'M',10,0,'')},w_NOTE);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('AQSQVBKXAL_DIV',IsHiddenByStateDriver('DatiBase'));
SetDisplay('EWPTTWSBMT_DIV',IsHiddenByStateDriver('PF'));
SetDisplay('OQFTKYDCIW_DIV',IsHiddenByStateDriver('AD'));
SetDisplay('RARXYHBSLM_DIV',Ne(w_TIPOPERS,'G'));
SetDisplay(Ctrl('BCZWUTGYEU'),Ne(w_xITFLGPEP,'S') || IsHiddenByStateDriver('P.E.P.'));
SetDisplay(Ctrl('ESBPIXCOCR'),Ne(w_xITFLGPEP,'S') || IsHiddenByStateDriver('Crime'));
SetDisplay(Ctrl('IVKDCKCDQZ'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('KRNBWYKUXF'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('HCIJRBXGCX'),Eq(w_CFESTERO,1) || Eq(w_TIPOPERS,'G') || Eq(w_xFLGVALIDO,'S'));
SetDisplay(Ctrl('FROMUIZATY'),true || IsHiddenByStateDriver('DATARETT'));
SetDisplay(Ctrl('BYFMKHYARA'),Ne(w_gSeekAos,'S') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('PAHSBQSDGU'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('VVZBQJZQFF'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('GSYDJTTEZF'),(Ne(w_xFLGVALIDO,'S') && Ne(w_xFLGANAVAL,'S')) || Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
SetDisplay(Ctrl('VEHZFMLUPL'),Ne(m_cFunction,'view') || Utilities.Make(window).IsInGroup(9));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["ATTIV"]=['LRKNJREBPN'];
HideUI.lblids["AUTRILASC"]=['ZPQIEJPWJC'];
HideUI.lblids["CAP"]=['GDOCAGKROT'];
HideUI.lblids["CODCAB"]=['WHMXTGXWGC'];
HideUI.lblids["CODFISC"]=['WZDAFMDKJE'];
HideUI.lblids["COGNOME"]=['TVSLWOCERI'];
HideUI.lblids["CONNES"]=['EKULYOXTJM'];
HideUI.lblids["CONTO"]=['LHMWHZJZVJ'];
HideUI.lblids["DATANASC"]=['HZYTDOZFPI'];
HideUI.lblids["DATARILASC"]=['MLJVDLOITR'];
HideUI.lblids["DATAVALI"]=['UYGHJPRVKH'];
HideUI.lblids["DESCCIT"]=['XPSQTBKQQZ'];
HideUI.lblids["DOMICILIO"]=['TWTXGZJTAR'];
HideUI.lblids["IDENT"]=['XYHCZSITMJ'];
HideUI.lblids["IDNASCOMUN"]=['WVJSUIKYEY'];
HideUI.lblids["IDNASSTATO"]=['ZBRDCBHLZC'];
HideUI.lblids["NOME"]=['KUPYKSUBXV'];
HideUI.lblids["NOTE"]=['GXTICCPRBI'];
HideUI.lblids["NUMDOCUM"]=['YXFGMWZGNN'];
HideUI.lblids["PAESE"]=['RZBLEGCFJJ'];
HideUI.lblids["PARTIVA"]=['WRVDNZJCDE'];
HideUI.lblids["PROVINCIA"]=['SBJQIAQUCN'];
HideUI.lblids["RAGSOC"]=['PFEQRACAUA'];
HideUI.lblids["RAMOGRUP"]=['QOLFDIWXXC'];
HideUI.lblids["SESSO"]=['KRSCDPQZTQ'];
HideUI.lblids["SETTSINT"]=['LHHLIWFNCK'];
HideUI.lblids["SOTGRUP"]=['ZZDCRCKYFX'];
HideUI.lblids["TIPINTER"]=['IVAWYVSUQI'];
HideUI.lblids["TIPODOC"]=['YRARWMJPPV'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
cond=Ne(w_TIPOPERS,'G');
if (Ne(o_EWPTTWSBMT_expand,cond)) {
ExpandCollapsibleBox('EWPTTWSBMT',cond);
o_EWPTTWSBMT_expand=cond;
}
cond=Eq(w_TIPOPERS,'G');
if (Ne(o_EWPTTWSBMT_collapse,cond)) {
CollapseCollapsibleBox('EWPTTWSBMT',cond);
o_EWPTTWSBMT_collapse=cond;
}
}
function UYWIEUHCAL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPOPERS','C',w_TIPOPERS,HtW(getRadioValue(Ctrl('UYWIEUHCAL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPOPERS(HtW(getRadioValue(Ctrl('UYWIEUHCAL')),'C'),null,e);
return l_bSetResult;
}
}
function TWTTDWKCRG_Valid(e) {
SetActiveField(Ctrl('TWTTDWKCRG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('COGNOME','C',w_COGNOME,HtW(Ctrl('TWTTDWKCRG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_COGNOME(HtW(Ctrl('TWTTDWKCRG').value,'C'),null,e);
return l_bSetResult;
}
}
function TWTTDWKCRG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('TWTTDWKCRG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('TWTTDWKCRG',w_COGNOME,'C',26,0,'@!');
SetActiveField(Ctrl('TWTTDWKCRG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('TWTTDWKCRG'),e);
}
function TWTTDWKCRG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function WWGIVGNUDW_Valid(e) {
SetActiveField(Ctrl('WWGIVGNUDW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOME','C',w_NOME,HtW(Ctrl('WWGIVGNUDW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOME(HtW(Ctrl('WWGIVGNUDW').value,'C'),null,e);
return l_bSetResult;
}
}
function WWGIVGNUDW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('WWGIVGNUDW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('WWGIVGNUDW',w_NOME,'C',25,0,'@!');
SetActiveField(Ctrl('WWGIVGNUDW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('WWGIVGNUDW'),e);
}
function WWGIVGNUDW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function CZTHKEDVCO_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CFESTERO','N',w_CFESTERO,ChkboxValueAssign(Ctrl('CZTHKEDVCO'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CFESTERO(ChkboxValueAssign(Ctrl('CZTHKEDVCO'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function CZTHKEDVCO_OnFocus(e) {
SetActiveField(Ctrl('CZTHKEDVCO'),true);
}
function CZTHKEDVCO_OnBlur(e) {
SetActiveField(Ctrl('CZTHKEDVCO'),false);
}
function AWPNTOJIRR_Valid(e) {
SetActiveField(Ctrl('AWPNTOJIRR'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('RAGSOC','C',w_RAGSOC,HtW(Ctrl('AWPNTOJIRR').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_RAGSOC(HtW(Ctrl('AWPNTOJIRR').value,'C'),null,e);
return l_bSetResult;
}
}
function AWPNTOJIRR_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('AWPNTOJIRR'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('AWPNTOJIRR',w_RAGSOC,'C',70,0,'@!');
SetActiveField(Ctrl('AWPNTOJIRR'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('AWPNTOJIRR'),e);
}
function AWPNTOJIRR_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function YVIKEGPYPM_Valid(e) {
SetActiveField(Ctrl('YVIKEGPYPM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PAESE','C',w_PAESE,HtW(Ctrl('YVIKEGPYPM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PAESE(HtW(Ctrl('YVIKEGPYPM').value,'C'),null,e);
return l_bSetResult;
}
}
function YVIKEGPYPM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YVIKEGPYPM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('YVIKEGPYPM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YVIKEGPYPM'),e);
}
function YVIKEGPYPM_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('YVIKEGPYPM')),'linkview_YVIKEGPYPM','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ODAYKSRECA_Valid(e) {
SetActiveField(Ctrl('ODAYKSRECA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESCCIT','C',w_DESCCIT,HtW(Ctrl('ODAYKSRECA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESCCIT(HtW(Ctrl('ODAYKSRECA').value,'C'),null,e);
return l_bSetResult;
}
}
function ODAYKSRECA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('ODAYKSRECA'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('ODAYKSRECA',w_DESCCIT,'C',30,0,'@!');
SetActiveField(Ctrl('ODAYKSRECA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('ODAYKSRECA'),e);
}
function ODAYKSRECA_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function ODAYKSRECA_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('ODAYKSRECA')),'linkview_ODAYKSRECA','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NOTZPDMYIA_Valid(e) {
SetActiveField(Ctrl('NOTZPDMYIA'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PROVINCIA','C',w_PROVINCIA,HtW(Ctrl('NOTZPDMYIA').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PROVINCIA(HtW(Ctrl('NOTZPDMYIA').value,'C'),null,e);
return l_bSetResult;
}
}
function NOTZPDMYIA_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NOTZPDMYIA'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('NOTZPDMYIA'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NOTZPDMYIA'),e);
}
function RDAVOEETJG_Valid(e) {
SetActiveField(Ctrl('RDAVOEETJG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CAP','C',w_CAP,HtW(Ctrl('RDAVOEETJG').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CAP(HtW(Ctrl('RDAVOEETJG').value,'C'),null,e);
return l_bSetResult;
}
}
function RDAVOEETJG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RDAVOEETJG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RDAVOEETJG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RDAVOEETJG'),e);
}
function BOTAJBWHHY_Valid(e) {
SetActiveField(Ctrl('BOTAJBWHHY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODCAB','C',w_CODCAB,HtW(Ctrl('BOTAJBWHHY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODCAB(HtW(Ctrl('BOTAJBWHHY').value,'C'),null,e);
return l_bSetResult;
}
}
function BOTAJBWHHY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BOTAJBWHHY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BOTAJBWHHY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BOTAJBWHHY'),e);
}
function VYLHWTRQNX_Valid(e) {
SetActiveField(Ctrl('VYLHWTRQNX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DOMICILIO','C',w_DOMICILIO,HtW(Ctrl('VYLHWTRQNX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DOMICILIO(HtW(Ctrl('VYLHWTRQNX').value,'C'),null,e);
return l_bSetResult;
}
}
function VYLHWTRQNX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('VYLHWTRQNX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('VYLHWTRQNX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('VYLHWTRQNX'),e);
}
function IRLEJAUHCB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('IDENT','C',w_IDENT,HtW(getComboValue(Ctrl('IRLEJAUHCB')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDENT(HtW(getComboValue(Ctrl('IRLEJAUHCB')),'C'),null,e);
return l_bSetResult;
}
}
function IRLEJAUHCB_OnFocus(e) {
SetActiveField(Ctrl('IRLEJAUHCB'),true);
}
function IRLEJAUHCB_OnBlur(e) {
SetActiveField(Ctrl('IRLEJAUHCB'),false);
}
function BYPEBFEOAJ_Valid(e) {
SetActiveField(Ctrl('BYPEBFEOAJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDNASCOMUN','C',w_IDNASCOMUN,HtW(Ctrl('BYPEBFEOAJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDNASCOMUN(HtW(Ctrl('BYPEBFEOAJ').value,'C'),null,e);
return l_bSetResult;
}
}
function BYPEBFEOAJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BYPEBFEOAJ'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('BYPEBFEOAJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BYPEBFEOAJ'),e);
}
function BYPEBFEOAJ_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('BYPEBFEOAJ')),'linkview_BYPEBFEOAJ','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function NEUBQNUEOJ_Valid(e) {
SetActiveField(Ctrl('NEUBQNUEOJ'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASCOMUN','C',w_NASCOMUN,HtW(Ctrl('NEUBQNUEOJ').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASCOMUN(HtW(Ctrl('NEUBQNUEOJ').value,'C'),null,e);
return l_bSetResult;
}
}
function NEUBQNUEOJ_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('NEUBQNUEOJ'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('NEUBQNUEOJ',w_NASCOMUN,'C',30,0,'@!');
SetActiveField(Ctrl('NEUBQNUEOJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('NEUBQNUEOJ'),e);
}
function NEUBQNUEOJ_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function KPSCOABZLB_Valid(e) {
SetActiveField(Ctrl('KPSCOABZLB'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('TIPINTER','C',w_TIPINTER,HtW(Ctrl('KPSCOABZLB').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPINTER(HtW(Ctrl('KPSCOABZLB').value,'C'),null,e);
return l_bSetResult;
}
}
function KPSCOABZLB_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('KPSCOABZLB'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('KPSCOABZLB'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('KPSCOABZLB'),e);
}
function IOAMSFCCVV_Valid(e) {
SetActiveField(Ctrl('IOAMSFCCVV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IDNASSTATO','C',w_IDNASSTATO,HtW(Ctrl('IOAMSFCCVV').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IDNASSTATO(HtW(Ctrl('IOAMSFCCVV').value,'C'),null,e);
return l_bSetResult;
}
}
function IOAMSFCCVV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('IOAMSFCCVV'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('IOAMSFCCVV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('IOAMSFCCVV'),e);
}
function IOAMSFCCVV_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('IOAMSFCCVV')),'linkview_IOAMSFCCVV','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function HODZKKOSYW_Valid(e) {
SetActiveField(Ctrl('HODZKKOSYW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NASSTATO','C',w_NASSTATO,HtW(Ctrl('HODZKKOSYW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NASSTATO(HtW(Ctrl('HODZKKOSYW').value,'C'),null,e);
return l_bSetResult;
}
}
function HODZKKOSYW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HODZKKOSYW'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('HODZKKOSYW',w_NASSTATO,'C',30,0,'@!');
SetActiveField(Ctrl('HODZKKOSYW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HODZKKOSYW'),e);
}
function HODZKKOSYW_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("@!"));
}
function QPALJZMFCL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SESSO','C',w_SESSO,HtW(getComboValue(Ctrl('QPALJZMFCL')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SESSO(HtW(getComboValue(Ctrl('QPALJZMFCL')),'C'),null,e);
return l_bSetResult;
}
}
function QPALJZMFCL_OnFocus(e) {
SetActiveField(Ctrl('QPALJZMFCL'),true);
}
function QPALJZMFCL_OnBlur(e) {
SetActiveField(Ctrl('QPALJZMFCL'),false);
}
function XMGRWGFSFV_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XMGRWGFSFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XMGRWGFSFV').value=ApplyPictureToDate(Ctrl('XMGRWGFSFV').value,TranslatePicture(datePattern),'XMGRWGFSFV');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XMGRWGFSFV'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XMGRWGFSFV');
}
}
}
SetActiveField(Ctrl('XMGRWGFSFV'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATANASC','D',w_DATANASC,HtW(Ctrl('XMGRWGFSFV').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATANASC(HtW(Ctrl('XMGRWGFSFV').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XMGRWGFSFV_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XMGRWGFSFV'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('XMGRWGFSFV'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XMGRWGFSFV',w_DATANASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('XMGRWGFSFV');
SetActiveField(Ctrl('XMGRWGFSFV'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XMGRWGFSFV'),e);
}
function XMGRWGFSFV_ZOOM_Click() {
LaunchCalendar(Ctrl('XMGRWGFSFV'));
}
function MBGANUUHRA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('TIPODOC','C',w_TIPODOC,HtW(getComboValue(Ctrl('MBGANUUHRA')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_TIPODOC(HtW(getComboValue(Ctrl('MBGANUUHRA')),'C'),null,e);
return l_bSetResult;
}
}
function MBGANUUHRA_OnFocus(e) {
SetActiveField(Ctrl('MBGANUUHRA'),true);
}
function MBGANUUHRA_OnBlur(e) {
SetActiveField(Ctrl('MBGANUUHRA'),false);
}
function HVEEMUJUUY_Valid(e) {
SetActiveField(Ctrl('HVEEMUJUUY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NUMDOCUM','C',w_NUMDOCUM,HtW(Ctrl('HVEEMUJUUY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NUMDOCUM(HtW(Ctrl('HVEEMUJUUY').value,'C'),null,e);
return l_bSetResult;
}
}
function HVEEMUJUUY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HVEEMUJUUY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HVEEMUJUUY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HVEEMUJUUY'),e);
}
function XHWYGOPPUN_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('XHWYGOPPUN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('XHWYGOPPUN').value=ApplyPictureToDate(Ctrl('XHWYGOPPUN').value,TranslatePicture(datePattern),'XHWYGOPPUN');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('XHWYGOPPUN'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('XHWYGOPPUN');
}
}
}
SetActiveField(Ctrl('XHWYGOPPUN'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARILASC','D',w_DATARILASC,HtW(Ctrl('XHWYGOPPUN').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARILASC(HtW(Ctrl('XHWYGOPPUN').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function XHWYGOPPUN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('XHWYGOPPUN'))) {
DisplayErrorMessage();
}
if (Ne(_tracker.ctrl,Ctrl('XHWYGOPPUN'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('XHWYGOPPUN',w_DATARILASC,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
}
m_oEnteredInDate=Ctrl('XHWYGOPPUN');
SetActiveField(Ctrl('XHWYGOPPUN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('XHWYGOPPUN'),e);
}
function XHWYGOPPUN_ZOOM_Click() {
LaunchCalendar(Ctrl('XHWYGOPPUN'));
}
function BNWXBPSIDG_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('BNWXBPSIDG'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('BNWXBPSIDG').value=ApplyPictureToDate(Ctrl('BNWXBPSIDG').value,TranslatePicture(datePattern),'BNWXBPSIDG');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('BNWXBPSIDG'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
}
}
}
SetActiveField(Ctrl('BNWXBPSIDG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATAVALI','D',w_DATAVALI,HtW(Ctrl('BNWXBPSIDG').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATAVALI(HtW(Ctrl('BNWXBPSIDG').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function BNWXBPSIDG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('BNWXBPSIDG'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('BNWXBPSIDG',w_DATAVALI,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('BNWXBPSIDG');
SetActiveField(Ctrl('BNWXBPSIDG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('BNWXBPSIDG'),e);
}
function BNWXBPSIDG_ZOOM_Click() {
LaunchCalendar(Ctrl('BNWXBPSIDG'));
}
function HRNCPADUFU_Valid(e) {
SetActiveField(Ctrl('HRNCPADUFU'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('AUTRILASC','C',w_AUTRILASC,HtW(Ctrl('HRNCPADUFU').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_AUTRILASC(HtW(Ctrl('HRNCPADUFU').value,'C'),null,e);
return l_bSetResult;
}
}
function HRNCPADUFU_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('HRNCPADUFU'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('HRNCPADUFU'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('HRNCPADUFU'),e);
}
function OJJHIUDPFY_Valid(e) {
SetActiveField(Ctrl('OJJHIUDPFY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CODFISC','C',w_CODFISC,HtW(Ctrl('OJJHIUDPFY').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODFISC(HtW(Ctrl('OJJHIUDPFY').value,'C'),null,e);
return l_bSetResult;
}
}
function OJJHIUDPFY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('OJJHIUDPFY'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('OJJHIUDPFY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('OJJHIUDPFY'),e);
}
function FHXWUTBNKI_Valid(e) {
SetActiveField(Ctrl('FHXWUTBNKI'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('PARTIVA','C',w_PARTIVA,HtW(Ctrl('FHXWUTBNKI').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PARTIVA(HtW(Ctrl('FHXWUTBNKI').value,'C'),null,e);
return l_bSetResult;
}
}
function FHXWUTBNKI_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FHXWUTBNKI'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('FHXWUTBNKI'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FHXWUTBNKI'),e);
}
function JLTVZXPMKM_Valid(e) {
SetActiveField(Ctrl('JLTVZXPMKM'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('CONTO','C',w_CONTO,HtW(Ctrl('JLTVZXPMKM').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONTO(HtW(Ctrl('JLTVZXPMKM').value,'C'),null,e);
return l_bSetResult;
}
}
function JLTVZXPMKM_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('JLTVZXPMKM'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('JLTVZXPMKM'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('JLTVZXPMKM'),e);
}
function LLYIGAMXRH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SOTGRUP','C',w_SOTGRUP,HtW(getComboValue(Ctrl('LLYIGAMXRH')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOTGRUP(HtW(getComboValue(Ctrl('LLYIGAMXRH')),'C'),null,e);
return l_bSetResult;
}
}
function LLYIGAMXRH_OnFocus(e) {
SetActiveField(Ctrl('LLYIGAMXRH'),true);
}
function LLYIGAMXRH_OnBlur(e) {
SetActiveField(Ctrl('LLYIGAMXRH'),false);
}
function SAQTIHOALW_Valid(e) {
SetActiveField(Ctrl('SAQTIHOALW'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('ATTIV','C',w_ATTIV,HtW(Ctrl('SAQTIHOALW').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_ATTIV(HtW(Ctrl('SAQTIHOALW').value,'C'),null,e);
return l_bSetResult;
}
}
function SAQTIHOALW_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('SAQTIHOALW'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('SAQTIHOALW'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('SAQTIHOALW'),e);
}
function SAQTIHOALW_ZOOM_Click() {
if (Ne(typeof(link_url),'undefined')) {
layerOpenForeground(link_url(link_index('SAQTIHOALW')),'linkview_SAQTIHOALW','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null,null,null,null,null,null,'-d-g');
}
}
function ZGNLLSFQHC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('SETTSINT','C',w_SETTSINT,HtW(getComboValue(Ctrl('ZGNLLSFQHC')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SETTSINT(HtW(getComboValue(Ctrl('ZGNLLSFQHC')),'C'),null,e);
return l_bSetResult;
}
}
function ZGNLLSFQHC_OnFocus(e) {
SetActiveField(Ctrl('ZGNLLSFQHC'),true);
}
function ZGNLLSFQHC_OnBlur(e) {
SetActiveField(Ctrl('ZGNLLSFQHC'),false);
}
function href_UQJBFPCIGV() {
if (false || WindowConfirm(Translate('2021305833'))) {
arrt_calcolasett([])
}
}
function YTPWDRMFUS_Valid(e) {
SetActiveField(Ctrl('YTPWDRMFUS'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('YTPWDRMFUS') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CONNES','C',w_CONNES,HtW(Ctrl('YTPWDRMFUS').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CONNES(HtW(Ctrl('YTPWDRMFUS').value,'C'),null,e);
return l_bSetResult;
}
}
function YTPWDRMFUS_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('YTPWDRMFUS'))) {
DisplayErrorMessage();
}
if ( ! (GetDisabled('YTPWDRMFUS'))) {
if (Eq(w_CONNES,'') && Eq(_tracker.ctrl,null)) {
Ctrl('YTPWDRMFUS').value=WtH(w_CODFISC,'C',16,0,'');
} else {
}
}
SetActiveField(Ctrl('YTPWDRMFUS'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('YTPWDRMFUS'),e);
}
function RARXYHBSLM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('NOTIT','N',w_NOTIT,ChkboxValueAssign(Ctrl('RARXYHBSLM'),1,0,'N',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTIT(ChkboxValueAssign(Ctrl('RARXYHBSLM'),1,0,'N',1,0,''),null,e);
return l_bSetResult;
}
}
function RARXYHBSLM_OnFocus(e) {
SetActiveField(Ctrl('RARXYHBSLM'),true);
}
function RARXYHBSLM_OnBlur(e) {
SetActiveField(Ctrl('RARXYHBSLM'),false);
}
function XFKXBQYUIU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('PEP','C',w_PEP,ChkboxValueAssign(Ctrl('XFKXBQYUIU'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_PEP(ChkboxValueAssign(Ctrl('XFKXBQYUIU'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XFKXBQYUIU_OnFocus(e) {
SetActiveField(Ctrl('XFKXBQYUIU'),true);
}
function XFKXBQYUIU_OnBlur(e) {
SetActiveField(Ctrl('XFKXBQYUIU'),false);
}
function href_BCZWUTGYEU() {
_modifyandopen(ToResource('jsp/pg_soggettipep_portlet.jsp'+'?w_ragsoc='+URLenc(w_RAGSOC)+'&w_codfisc='+URLenc(w_CODFISC)+'&w_cognome='+URLenc(w_COGNOME)+'&w_nome='+URLenc(w_NOME)+'&w_tipo='+URLenc('F')+'&m_cParameterSequence=w_ragsoc,w_codfisc,w_cognome,w_nome,w_tipo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function DFNZBCOVFH_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('flgaggfam','C',w_flgaggfam,ChkboxValueAssign(Ctrl('DFNZBCOVFH'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_flgaggfam(ChkboxValueAssign(Ctrl('DFNZBCOVFH'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function DFNZBCOVFH_OnFocus(e) {
SetActiveField(Ctrl('DFNZBCOVFH'),true);
}
function DFNZBCOVFH_OnBlur(e) {
SetActiveField(Ctrl('DFNZBCOVFH'),false);
}
function RHCYCLTWOT_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('CRIME','C',w_CRIME,ChkboxValueAssign(Ctrl('RHCYCLTWOT'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CRIME(ChkboxValueAssign(Ctrl('RHCYCLTWOT'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RHCYCLTWOT_OnFocus(e) {
SetActiveField(Ctrl('RHCYCLTWOT'),true);
}
function RHCYCLTWOT_OnBlur(e) {
SetActiveField(Ctrl('RHCYCLTWOT'),false);
}
function href_ESBPIXCOCR() {
_modifyandopen(ToResource('jsp/pg_soggetticrime_portlet.jsp'+'?w_ragsoc='+URLenc(w_RAGSOC)+'&w_codfisc='+URLenc(w_CODFISC)+'&w_cognome='+URLenc(w_COGNOME)+'&w_nome='+URLenc(w_NOME)+'&w_tipo='+URLenc('F')+'&m_cParameterSequence=w_ragsoc,w_codfisc,w_cognome,w_nome,w_tipo')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function IVKDCKCDQZ_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(w_CONNES));
l_oWv.setValue('dataope',AsAppletValue(SystemDate()));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES,dataope'));
_modifyandopen('aprg_rapporto_oro'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=300,width=400',false)
}
function KRNBWYKUXF_Click() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CONNES',AsAppletValue(w_CONNES));
l_oWv.setValue('annoope',AsAppletValue(Year(SystemDate())-1));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CONNES,annoope'));
_modifyandopen('aprg_saldi_oro'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=300,width=550',false)
}
function href_HCIJRBXGCX() {
arrt_calccodfis_obj([["pObj",this]])
}
function FROMUIZATY_Valid(e) {
var dateisok = false;
if (Eq(m_oEnteredInDate,Ctrl('FROMUIZATY'))) {
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
Ctrl('FROMUIZATY').value=ApplyPictureToDate(Ctrl('FROMUIZATY').value,TranslatePicture(datePattern),'FROMUIZATY');
} else if (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date) {
CheckDateValidity(Ctrl('FROMUIZATY'));
}
m_oEnteredInDate=null;
dateisok=lastDateIsOk;
if ( ! (dateisok)) {
m_nLastError=-2;
if (IsMobile()) {
m_oEnteredInDate=Ctrl('FROMUIZATY');
}
}
}
SetActiveField(Ctrl('FROMUIZATY'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DATARETT','D',w_DATARETT,HtW(Ctrl('FROMUIZATY').value,'D'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DATARETT(HtW(Ctrl('FROMUIZATY').value,'D'),null,e) && dateisok;
return l_bSetResult;
}
}
function FROMUIZATY_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('FROMUIZATY'))) {
DisplayErrorMessage();
}
if ( ! (IsMobile() && LibJavascript.HTML5Tests && LibJavascript.HTML5Tests.InputTypes && LibJavascript.HTML5Tests.InputTypes.date)) {
SPBOUILib.WtH('FROMUIZATY',w_DATARETT,'D',8,0,TranslatePicture(GetDatePicture(false,'D'),'D'));
}
m_oEnteredInDate=Ctrl('FROMUIZATY');
SetActiveField(Ctrl('FROMUIZATY'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('FROMUIZATY'),e);
}
function href_BYFMKHYARA() {
var l_oWv = InitWvApplet();
l_oWv.setValue('denomin',AsAppletValue(w_RAGSOC));
l_oWv.setValue('simili',AsAppletValue(w_RAGSOC));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('denomin,simili'));
_modifyandopen('aos_stampa_ricerca_web'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_HGVEMKOKYZ() {
var l_oWv = InitWvApplet();
l_oWv.setValue('SESSO',AsAppletValue(w_SESSO));
l_oWv.setValue('RAGSOCM',AsAppletValue(w_RAGSOC));
l_oWv.setValue('CONNES',AsAppletValue(w_CONNES));
l_oWv.setValue('CFESTERO',AsAppletValue(w_CFESTERO));
l_oWv.setValue('CODFISC',AsAppletValue(w_CODFISC));
l_oWv.setValue('PARTIVA',AsAppletValue(w_PARTIVA));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('SESSO,RAGSOCM,CONNES,CFESTERO,CODFISC,PARTIVA'));
_modifyandopen('arpg_info_pre_prn_scheda_adeguata_ver_clientela'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes,height=280,width=675',null)
}
function href_PAHSBQSDGU() {
_modifyandopen(ToResource('jsp/pg_chg_connes_portlet.jsp'+'?DaCodCli='+URLenc(w_CONNES)+'&m_cParameterSequence=DaCodCli')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_VVZBQJZQFF() {
_modifyandopen(ToResource('jsp/pg_chg_create_portlet.jsp'+'?DaCodCli='+URLenc(w_CONNES)+'&m_cParameterSequence=DaCodCli')+'&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function href_GSYDJTTEZF() {
if (false || WindowConfirm(Translate('640277248'))) {
arrt_sblocco_modifica([["pConnes",w_CONNES],["w_xFLGANAVAL",w_xFLGANAVAL],["w_xFLGVALIDO",w_xFLGVALIDO]])
}
}
function href_VEHZFMLUPL() {
var l_oWv = InitWvApplet();
l_oWv.setValue('CodCli',AsAppletValue(w_CONNES));
l_oWv.setValue('m_cParameterSequence',AsAppletValue('CodCli'));
_modifyandopen('arpg_stampe_sog'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)
}
function UMKFMWBVUO_Valid(e) {
SetActiveField(Ctrl('UMKFMWBVUO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NOTE','M',w_NOTE,HtW(Ctrl('UMKFMWBVUO').value,'M'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NOTE(HtW(Ctrl('UMKFMWBVUO').value,'M'),null,e);
return l_bSetResult;
}
}
function UMKFMWBVUO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UMKFMWBVUO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UMKFMWBVUO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UMKFMWBVUO'),e);
}
_ResetTracker();
function setEventHandlers() {
var c;
function UQJBFPCIGV_wrap_OnClick(event) {
return href_UQJBFPCIGV();
}
SPBOUILib.SetImageClick('UQJBFPCIGV',UQJBFPCIGV_wrap_OnClick);
function UQJBFPCIGV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('UQJBFPCIGV',UQJBFPCIGV_wrap_OnKeyDown);
function BCZWUTGYEU_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_BCZWUTGYEU():void(0));
}
SPBOUILib.SetImageClick('BCZWUTGYEU',BCZWUTGYEU_wrap_OnClick);
function BCZWUTGYEU_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BCZWUTGYEU',BCZWUTGYEU_wrap_OnKeyDown);
function ESBPIXCOCR_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?href_ESBPIXCOCR():void(0));
}
SPBOUILib.SetImageClick('ESBPIXCOCR',ESBPIXCOCR_wrap_OnClick);
function ESBPIXCOCR_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('ESBPIXCOCR',ESBPIXCOCR_wrap_OnKeyDown);
function IVKDCKCDQZ_wrap_OnClick(event) {
return IVKDCKCDQZ_Click();
}
SPBOUILib.SetButtonClick('IVKDCKCDQZ',IVKDCKCDQZ_wrap_OnClick);
function KRNBWYKUXF_wrap_OnClick(event) {
return KRNBWYKUXF_Click();
}
SPBOUILib.SetButtonClick('KRNBWYKUXF',KRNBWYKUXF_wrap_OnClick);
function HCIJRBXGCX_wrap_OnClick(event) {
return href_HCIJRBXGCX();
}
SPBOUILib.SetImageClick('HCIJRBXGCX',HCIJRBXGCX_wrap_OnClick);
function HCIJRBXGCX_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('HCIJRBXGCX',HCIJRBXGCX_wrap_OnKeyDown);
function BYFMKHYARA_wrap_OnClick(event) {
return href_BYFMKHYARA();
}
SPBOUILib.SetImageClick('BYFMKHYARA',BYFMKHYARA_wrap_OnClick);
function BYFMKHYARA_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('BYFMKHYARA',BYFMKHYARA_wrap_OnKeyDown);
function HGVEMKOKYZ_wrap_OnClick(event) {
return href_HGVEMKOKYZ();
}
SPBOUILib.SetImageClick('HGVEMKOKYZ',HGVEMKOKYZ_wrap_OnClick);
function HGVEMKOKYZ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('HGVEMKOKYZ',HGVEMKOKYZ_wrap_OnKeyDown);
function PAHSBQSDGU_wrap_OnClick(event) {
return href_PAHSBQSDGU();
}
SPBOUILib.SetImageClick('PAHSBQSDGU',PAHSBQSDGU_wrap_OnClick);
function PAHSBQSDGU_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('PAHSBQSDGU',PAHSBQSDGU_wrap_OnKeyDown);
function VVZBQJZQFF_wrap_OnClick(event) {
return href_VVZBQJZQFF();
}
SPBOUILib.SetImageClick('VVZBQJZQFF',VVZBQJZQFF_wrap_OnClick);
function VVZBQJZQFF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('VVZBQJZQFF',VVZBQJZQFF_wrap_OnKeyDown);
function GSYDJTTEZF_wrap_OnClick(event) {
return href_GSYDJTTEZF();
}
SPBOUILib.SetImageClick('GSYDJTTEZF',GSYDJTTEZF_wrap_OnClick);
function GSYDJTTEZF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('GSYDJTTEZF',GSYDJTTEZF_wrap_OnKeyDown);
function VEHZFMLUPL_wrap_OnClick(event) {
return href_VEHZFMLUPL();
}
SPBOUILib.SetImageClick('VEHZFMLUPL',VEHZFMLUPL_wrap_OnClick);
function VEHZFMLUPL_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetKeyDown('VEHZFMLUPL',VEHZFMLUPL_wrap_OnKeyDown);
if (Ne(m_cFunction,'view')) {
function UYWIEUHCAL_wrap_Valid(event) {
return UYWIEUHCAL_Valid(event);
}
SPBOUILib.SetRadioClick('UYWIEUHCAL',UYWIEUHCAL_wrap_Valid);
function TWTTDWKCRG_wrap_Valid(event) {
return TWTTDWKCRG_Valid(event);
}
SPBOUILib.SetInputExit('TWTTDWKCRG',TWTTDWKCRG_wrap_Valid);
function TWTTDWKCRG_wrap_OnFocus(event) {
return TWTTDWKCRG_OnFocus(event);
}
SPBOUILib.SetInputEnter('TWTTDWKCRG',TWTTDWKCRG_wrap_OnFocus);
function TWTTDWKCRG_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('TWTTDWKCRG',TWTTDWKCRG_wrap_OnKeyPress);
function TWTTDWKCRG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('TWTTDWKCRG',TWTTDWKCRG_wrap_OnKeyDown);
function WWGIVGNUDW_wrap_Valid(event) {
return WWGIVGNUDW_Valid(event);
}
SPBOUILib.SetInputExit('WWGIVGNUDW',WWGIVGNUDW_wrap_Valid);
function WWGIVGNUDW_wrap_OnFocus(event) {
return WWGIVGNUDW_OnFocus(event);
}
SPBOUILib.SetInputEnter('WWGIVGNUDW',WWGIVGNUDW_wrap_OnFocus);
function WWGIVGNUDW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('WWGIVGNUDW',WWGIVGNUDW_wrap_OnKeyPress);
function WWGIVGNUDW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('WWGIVGNUDW',WWGIVGNUDW_wrap_OnKeyDown);
function CZTHKEDVCO_wrap_Valid(event) {
return CZTHKEDVCO_Valid(event);
}
SPBOUILib.SetCheckboxClick('CZTHKEDVCO',CZTHKEDVCO_wrap_Valid);
function CZTHKEDVCO_wrap_OnFocus(event) {
return CZTHKEDVCO_OnFocus(event);
}
SPBOUILib.SetInputEnter('CZTHKEDVCO',CZTHKEDVCO_wrap_OnFocus);
function CZTHKEDVCO_wrap_Blur(event) {
return CZTHKEDVCO_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CZTHKEDVCO',CZTHKEDVCO_wrap_Blur);
function AWPNTOJIRR_wrap_Valid(event) {
return AWPNTOJIRR_Valid(event);
}
SPBOUILib.SetInputExit('AWPNTOJIRR',AWPNTOJIRR_wrap_Valid);
function AWPNTOJIRR_wrap_OnFocus(event) {
return AWPNTOJIRR_OnFocus(event);
}
SPBOUILib.SetInputEnter('AWPNTOJIRR',AWPNTOJIRR_wrap_OnFocus);
function AWPNTOJIRR_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('AWPNTOJIRR',AWPNTOJIRR_wrap_OnKeyPress);
function AWPNTOJIRR_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('AWPNTOJIRR',AWPNTOJIRR_wrap_OnKeyDown);
function YVIKEGPYPM_wrap_Valid(event) {
return YVIKEGPYPM_Valid(event);
}
SPBOUILib.SetInputExit('YVIKEGPYPM',YVIKEGPYPM_wrap_Valid);
function YVIKEGPYPM_wrap_OnFocus(event) {
return YVIKEGPYPM_OnFocus(event);
}
SPBOUILib.SetInputEnter('YVIKEGPYPM',YVIKEGPYPM_wrap_OnFocus);
function YVIKEGPYPM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YVIKEGPYPM',YVIKEGPYPM_wrap_OnKeyDown);
function YVIKEGPYPM_ZOOM_setHandlers() {
function YVIKEGPYPM_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?YVIKEGPYPM_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('YVIKEGPYPM_ZOOM',YVIKEGPYPM_ZOOM_wrap_OnClick);
function YVIKEGPYPM_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('YVIKEGPYPM_ZOOM',YVIKEGPYPM_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('YVIKEGPYPM',YVIKEGPYPM_ZOOM_setHandlers);
function ODAYKSRECA_wrap_Valid(event) {
return ODAYKSRECA_Valid(event);
}
SPBOUILib.SetInputExit('ODAYKSRECA',ODAYKSRECA_wrap_Valid);
function ODAYKSRECA_wrap_OnFocus(event) {
return ODAYKSRECA_OnFocus(event);
}
SPBOUILib.SetInputEnter('ODAYKSRECA',ODAYKSRECA_wrap_OnFocus);
function ODAYKSRECA_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('ODAYKSRECA',ODAYKSRECA_wrap_OnKeyPress);
function ODAYKSRECA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('ODAYKSRECA',ODAYKSRECA_wrap_OnKeyDown);
function ODAYKSRECA_ZOOM_setHandlers() {
function ODAYKSRECA_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?ODAYKSRECA_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('ODAYKSRECA_ZOOM',ODAYKSRECA_ZOOM_wrap_OnClick);
function ODAYKSRECA_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('ODAYKSRECA_ZOOM',ODAYKSRECA_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('ODAYKSRECA',ODAYKSRECA_ZOOM_setHandlers);
function NOTZPDMYIA_wrap_Valid(event) {
return NOTZPDMYIA_Valid(event);
}
SPBOUILib.SetInputExit('NOTZPDMYIA',NOTZPDMYIA_wrap_Valid);
function NOTZPDMYIA_wrap_OnFocus(event) {
return NOTZPDMYIA_OnFocus(event);
}
SPBOUILib.SetInputEnter('NOTZPDMYIA',NOTZPDMYIA_wrap_OnFocus);
function NOTZPDMYIA_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NOTZPDMYIA',NOTZPDMYIA_wrap_OnKeyDown);
function RDAVOEETJG_wrap_Valid(event) {
return RDAVOEETJG_Valid(event);
}
SPBOUILib.SetInputExit('RDAVOEETJG',RDAVOEETJG_wrap_Valid);
function RDAVOEETJG_wrap_OnFocus(event) {
return RDAVOEETJG_OnFocus(event);
}
SPBOUILib.SetInputEnter('RDAVOEETJG',RDAVOEETJG_wrap_OnFocus);
function RDAVOEETJG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RDAVOEETJG',RDAVOEETJG_wrap_OnKeyDown);
function BOTAJBWHHY_wrap_Valid(event) {
return BOTAJBWHHY_Valid(event);
}
SPBOUILib.SetInputExit('BOTAJBWHHY',BOTAJBWHHY_wrap_Valid);
function BOTAJBWHHY_wrap_OnFocus(event) {
return BOTAJBWHHY_OnFocus(event);
}
SPBOUILib.SetInputEnter('BOTAJBWHHY',BOTAJBWHHY_wrap_OnFocus);
function BOTAJBWHHY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BOTAJBWHHY',BOTAJBWHHY_wrap_OnKeyDown);
function VYLHWTRQNX_wrap_Valid(event) {
return VYLHWTRQNX_Valid(event);
}
SPBOUILib.SetInputExit('VYLHWTRQNX',VYLHWTRQNX_wrap_Valid);
function VYLHWTRQNX_wrap_OnFocus(event) {
return VYLHWTRQNX_OnFocus(event);
}
SPBOUILib.SetInputEnter('VYLHWTRQNX',VYLHWTRQNX_wrap_OnFocus);
function VYLHWTRQNX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('VYLHWTRQNX',VYLHWTRQNX_wrap_OnKeyDown);
function IRLEJAUHCB_wrap_Valid(event) {
return IRLEJAUHCB_Valid(event);
}
SPBOUILib.SetComboChange('IRLEJAUHCB',IRLEJAUHCB_wrap_Valid);
function IRLEJAUHCB_wrap_OnFocus(event) {
return IRLEJAUHCB_OnFocus(event);
}
SPBOUILib.SetInputEnter('IRLEJAUHCB',IRLEJAUHCB_wrap_OnFocus);
function IRLEJAUHCB_wrap_Blur(event) {
return IRLEJAUHCB_OnBlur(event);
}
SPBOUILib.SetInputExit('IRLEJAUHCB',IRLEJAUHCB_wrap_Blur);
function BYPEBFEOAJ_wrap_Valid(event) {
return BYPEBFEOAJ_Valid(event);
}
SPBOUILib.SetInputExit('BYPEBFEOAJ',BYPEBFEOAJ_wrap_Valid);
function BYPEBFEOAJ_wrap_OnFocus(event) {
return BYPEBFEOAJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('BYPEBFEOAJ',BYPEBFEOAJ_wrap_OnFocus);
function BYPEBFEOAJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('BYPEBFEOAJ',BYPEBFEOAJ_wrap_OnKeyDown);
function BYPEBFEOAJ_ZOOM_setHandlers() {
function BYPEBFEOAJ_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BYPEBFEOAJ_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BYPEBFEOAJ_ZOOM',BYPEBFEOAJ_ZOOM_wrap_OnClick);
function BYPEBFEOAJ_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BYPEBFEOAJ_ZOOM',BYPEBFEOAJ_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BYPEBFEOAJ',BYPEBFEOAJ_ZOOM_setHandlers);
function NEUBQNUEOJ_wrap_Valid(event) {
return NEUBQNUEOJ_Valid(event);
}
SPBOUILib.SetInputExit('NEUBQNUEOJ',NEUBQNUEOJ_wrap_Valid);
function NEUBQNUEOJ_wrap_OnFocus(event) {
return NEUBQNUEOJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnFocus);
function NEUBQNUEOJ_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnKeyPress);
function NEUBQNUEOJ_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('NEUBQNUEOJ',NEUBQNUEOJ_wrap_OnKeyDown);
function KPSCOABZLB_wrap_Valid(event) {
return KPSCOABZLB_Valid(event);
}
SPBOUILib.SetInputExit('KPSCOABZLB',KPSCOABZLB_wrap_Valid);
function KPSCOABZLB_wrap_OnFocus(event) {
return KPSCOABZLB_OnFocus(event);
}
SPBOUILib.SetInputEnter('KPSCOABZLB',KPSCOABZLB_wrap_OnFocus);
function KPSCOABZLB_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('KPSCOABZLB',KPSCOABZLB_wrap_OnKeyDown);
function IOAMSFCCVV_wrap_Valid(event) {
return IOAMSFCCVV_Valid(event);
}
SPBOUILib.SetInputExit('IOAMSFCCVV',IOAMSFCCVV_wrap_Valid);
function IOAMSFCCVV_wrap_OnFocus(event) {
return IOAMSFCCVV_OnFocus(event);
}
SPBOUILib.SetInputEnter('IOAMSFCCVV',IOAMSFCCVV_wrap_OnFocus);
function IOAMSFCCVV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('IOAMSFCCVV',IOAMSFCCVV_wrap_OnKeyDown);
function IOAMSFCCVV_ZOOM_setHandlers() {
function IOAMSFCCVV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?IOAMSFCCVV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('IOAMSFCCVV_ZOOM',IOAMSFCCVV_ZOOM_wrap_OnClick);
function IOAMSFCCVV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IOAMSFCCVV_ZOOM',IOAMSFCCVV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('IOAMSFCCVV',IOAMSFCCVV_ZOOM_setHandlers);
function HODZKKOSYW_wrap_Valid(event) {
return HODZKKOSYW_Valid(event);
}
SPBOUILib.SetInputExit('HODZKKOSYW',HODZKKOSYW_wrap_Valid);
function HODZKKOSYW_wrap_OnFocus(event) {
return HODZKKOSYW_OnFocus(event);
}
SPBOUILib.SetInputEnter('HODZKKOSYW',HODZKKOSYW_wrap_OnFocus);
function HODZKKOSYW_wrap_OnKeyPress(event) {
return CheckUpper(event);
}
SPBOUILib.SetInputKeyPress('HODZKKOSYW',HODZKKOSYW_wrap_OnKeyPress);
function HODZKKOSYW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HODZKKOSYW',HODZKKOSYW_wrap_OnKeyDown);
function QPALJZMFCL_wrap_Valid(event) {
return QPALJZMFCL_Valid(event);
}
SPBOUILib.SetComboChange('QPALJZMFCL',QPALJZMFCL_wrap_Valid);
function QPALJZMFCL_wrap_OnFocus(event) {
return QPALJZMFCL_OnFocus(event);
}
SPBOUILib.SetInputEnter('QPALJZMFCL',QPALJZMFCL_wrap_OnFocus);
function QPALJZMFCL_wrap_Blur(event) {
return QPALJZMFCL_OnBlur(event);
}
SPBOUILib.SetInputExit('QPALJZMFCL',QPALJZMFCL_wrap_Blur);
function XMGRWGFSFV_wrap_Valid(event) {
return XMGRWGFSFV_Valid(event);
}
SPBOUILib.SetInputExit('XMGRWGFSFV',XMGRWGFSFV_wrap_Valid);
function XMGRWGFSFV_wrap_OnFocus(event) {
return XMGRWGFSFV_OnFocus(event);
}
SPBOUILib.SetInputEnter('XMGRWGFSFV',XMGRWGFSFV_wrap_OnFocus);
function XMGRWGFSFV_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XMGRWGFSFV',XMGRWGFSFV_wrap_OnKeyPress);
function XMGRWGFSFV_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XMGRWGFSFV',XMGRWGFSFV_wrap_OnKeyDown);
function XMGRWGFSFV_ZOOM_setHandlers() {
function XMGRWGFSFV_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XMGRWGFSFV_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XMGRWGFSFV_ZOOM',XMGRWGFSFV_ZOOM_wrap_OnClick);
function XMGRWGFSFV_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XMGRWGFSFV_ZOOM',XMGRWGFSFV_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XMGRWGFSFV',XMGRWGFSFV_ZOOM_setHandlers);
function MBGANUUHRA_wrap_Valid(event) {
return MBGANUUHRA_Valid(event);
}
SPBOUILib.SetComboChange('MBGANUUHRA',MBGANUUHRA_wrap_Valid);
function MBGANUUHRA_wrap_OnFocus(event) {
return MBGANUUHRA_OnFocus(event);
}
SPBOUILib.SetInputEnter('MBGANUUHRA',MBGANUUHRA_wrap_OnFocus);
function MBGANUUHRA_wrap_Blur(event) {
return MBGANUUHRA_OnBlur(event);
}
SPBOUILib.SetInputExit('MBGANUUHRA',MBGANUUHRA_wrap_Blur);
function HVEEMUJUUY_wrap_Valid(event) {
return HVEEMUJUUY_Valid(event);
}
SPBOUILib.SetInputExit('HVEEMUJUUY',HVEEMUJUUY_wrap_Valid);
function HVEEMUJUUY_wrap_OnFocus(event) {
return HVEEMUJUUY_OnFocus(event);
}
SPBOUILib.SetInputEnter('HVEEMUJUUY',HVEEMUJUUY_wrap_OnFocus);
function HVEEMUJUUY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HVEEMUJUUY',HVEEMUJUUY_wrap_OnKeyDown);
function XHWYGOPPUN_wrap_Valid(event) {
return XHWYGOPPUN_Valid(event);
}
SPBOUILib.SetInputExit('XHWYGOPPUN',XHWYGOPPUN_wrap_Valid);
function XHWYGOPPUN_wrap_OnFocus(event) {
return XHWYGOPPUN_OnFocus(event);
}
SPBOUILib.SetInputEnter('XHWYGOPPUN',XHWYGOPPUN_wrap_OnFocus);
function XHWYGOPPUN_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('XHWYGOPPUN',XHWYGOPPUN_wrap_OnKeyPress);
function XHWYGOPPUN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('XHWYGOPPUN',XHWYGOPPUN_wrap_OnKeyDown);
function XHWYGOPPUN_ZOOM_setHandlers() {
function XHWYGOPPUN_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?XHWYGOPPUN_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('XHWYGOPPUN_ZOOM',XHWYGOPPUN_ZOOM_wrap_OnClick);
function XHWYGOPPUN_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('XHWYGOPPUN_ZOOM',XHWYGOPPUN_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('XHWYGOPPUN',XHWYGOPPUN_ZOOM_setHandlers);
function BNWXBPSIDG_wrap_Valid(event) {
return BNWXBPSIDG_Valid(event);
}
SPBOUILib.SetInputExit('BNWXBPSIDG',BNWXBPSIDG_wrap_Valid);
function BNWXBPSIDG_wrap_OnFocus(event) {
return BNWXBPSIDG_OnFocus(event);
}
SPBOUILib.SetInputEnter('BNWXBPSIDG',BNWXBPSIDG_wrap_OnFocus);
function BNWXBPSIDG_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('BNWXBPSIDG',BNWXBPSIDG_wrap_OnKeyPress);
function BNWXBPSIDG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('BNWXBPSIDG',BNWXBPSIDG_wrap_OnKeyDown);
function BNWXBPSIDG_ZOOM_setHandlers() {
function BNWXBPSIDG_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?BNWXBPSIDG_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('BNWXBPSIDG_ZOOM',BNWXBPSIDG_ZOOM_wrap_OnClick);
function BNWXBPSIDG_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('BNWXBPSIDG_ZOOM',BNWXBPSIDG_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('BNWXBPSIDG',BNWXBPSIDG_ZOOM_setHandlers);
function HRNCPADUFU_wrap_Valid(event) {
return HRNCPADUFU_Valid(event);
}
SPBOUILib.SetInputExit('HRNCPADUFU',HRNCPADUFU_wrap_Valid);
function HRNCPADUFU_wrap_OnFocus(event) {
return HRNCPADUFU_OnFocus(event);
}
SPBOUILib.SetInputEnter('HRNCPADUFU',HRNCPADUFU_wrap_OnFocus);
function HRNCPADUFU_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('HRNCPADUFU',HRNCPADUFU_wrap_OnKeyDown);
function OJJHIUDPFY_wrap_Valid(event) {
return OJJHIUDPFY_Valid(event);
}
SPBOUILib.SetInputExit('OJJHIUDPFY',OJJHIUDPFY_wrap_Valid);
function OJJHIUDPFY_wrap_OnFocus(event) {
return OJJHIUDPFY_OnFocus(event);
}
SPBOUILib.SetInputEnter('OJJHIUDPFY',OJJHIUDPFY_wrap_OnFocus);
function OJJHIUDPFY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('OJJHIUDPFY',OJJHIUDPFY_wrap_OnKeyDown);
function FHXWUTBNKI_wrap_Valid(event) {
return FHXWUTBNKI_Valid(event);
}
SPBOUILib.SetInputExit('FHXWUTBNKI',FHXWUTBNKI_wrap_Valid);
function FHXWUTBNKI_wrap_OnFocus(event) {
return FHXWUTBNKI_OnFocus(event);
}
SPBOUILib.SetInputEnter('FHXWUTBNKI',FHXWUTBNKI_wrap_OnFocus);
function FHXWUTBNKI_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('FHXWUTBNKI',FHXWUTBNKI_wrap_OnKeyDown);
function JLTVZXPMKM_wrap_Valid(event) {
return JLTVZXPMKM_Valid(event);
}
SPBOUILib.SetInputExit('JLTVZXPMKM',JLTVZXPMKM_wrap_Valid);
function JLTVZXPMKM_wrap_OnFocus(event) {
return JLTVZXPMKM_OnFocus(event);
}
SPBOUILib.SetInputEnter('JLTVZXPMKM',JLTVZXPMKM_wrap_OnFocus);
function JLTVZXPMKM_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('JLTVZXPMKM',JLTVZXPMKM_wrap_OnKeyDown);
function LLYIGAMXRH_wrap_Valid(event) {
return LLYIGAMXRH_Valid(event);
}
SPBOUILib.SetComboChange('LLYIGAMXRH',LLYIGAMXRH_wrap_Valid);
function LLYIGAMXRH_wrap_OnFocus(event) {
return LLYIGAMXRH_OnFocus(event);
}
SPBOUILib.SetInputEnter('LLYIGAMXRH',LLYIGAMXRH_wrap_OnFocus);
function LLYIGAMXRH_wrap_Blur(event) {
return LLYIGAMXRH_OnBlur(event);
}
SPBOUILib.SetInputExit('LLYIGAMXRH',LLYIGAMXRH_wrap_Blur);
function SAQTIHOALW_wrap_Valid(event) {
return SAQTIHOALW_Valid(event);
}
SPBOUILib.SetInputExit('SAQTIHOALW',SAQTIHOALW_wrap_Valid);
function SAQTIHOALW_wrap_OnFocus(event) {
return SAQTIHOALW_OnFocus(event);
}
SPBOUILib.SetInputEnter('SAQTIHOALW',SAQTIHOALW_wrap_OnFocus);
function SAQTIHOALW_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('SAQTIHOALW',SAQTIHOALW_wrap_OnKeyDown);
function SAQTIHOALW_ZOOM_setHandlers() {
function SAQTIHOALW_ZOOM_wrap_OnClick(event) {
return (Ne(m_cFunction,'view') && Ne(m_cFunction,'query')?SAQTIHOALW_ZOOM_Click():void(0));
}
SPBOUILib.SetButtonClick('SAQTIHOALW_ZOOM',SAQTIHOALW_ZOOM_wrap_OnClick);
function SAQTIHOALW_ZOOM_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('SAQTIHOALW_ZOOM',SAQTIHOALW_ZOOM_wrap_OnKeyDown);
}
SPBOUILib.SetPicker('SAQTIHOALW',SAQTIHOALW_ZOOM_setHandlers);
function ZGNLLSFQHC_wrap_Valid(event) {
return ZGNLLSFQHC_Valid(event);
}
SPBOUILib.SetComboChange('ZGNLLSFQHC',ZGNLLSFQHC_wrap_Valid);
function ZGNLLSFQHC_wrap_OnFocus(event) {
return ZGNLLSFQHC_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZGNLLSFQHC',ZGNLLSFQHC_wrap_OnFocus);
function ZGNLLSFQHC_wrap_Blur(event) {
return ZGNLLSFQHC_OnBlur(event);
}
SPBOUILib.SetInputExit('ZGNLLSFQHC',ZGNLLSFQHC_wrap_Blur);
function YTPWDRMFUS_wrap_Valid(event) {
return YTPWDRMFUS_Valid(event);
}
SPBOUILib.SetInputExit('YTPWDRMFUS',YTPWDRMFUS_wrap_Valid);
function YTPWDRMFUS_wrap_OnFocus(event) {
return YTPWDRMFUS_OnFocus(event);
}
SPBOUILib.SetInputEnter('YTPWDRMFUS',YTPWDRMFUS_wrap_OnFocus);
function YTPWDRMFUS_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('YTPWDRMFUS',YTPWDRMFUS_wrap_OnKeyDown);
function RARXYHBSLM_wrap_Valid(event) {
return RARXYHBSLM_Valid(event);
}
SPBOUILib.SetCheckboxClick('RARXYHBSLM',RARXYHBSLM_wrap_Valid);
function RARXYHBSLM_wrap_OnFocus(event) {
return RARXYHBSLM_OnFocus(event);
}
SPBOUILib.SetInputEnter('RARXYHBSLM',RARXYHBSLM_wrap_OnFocus);
function RARXYHBSLM_wrap_Blur(event) {
return RARXYHBSLM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RARXYHBSLM',RARXYHBSLM_wrap_Blur);
function XFKXBQYUIU_wrap_Valid(event) {
return XFKXBQYUIU_Valid(event);
}
SPBOUILib.SetCheckboxClick('XFKXBQYUIU',XFKXBQYUIU_wrap_Valid);
function XFKXBQYUIU_wrap_OnFocus(event) {
return XFKXBQYUIU_OnFocus(event);
}
SPBOUILib.SetInputEnter('XFKXBQYUIU',XFKXBQYUIU_wrap_OnFocus);
function XFKXBQYUIU_wrap_Blur(event) {
return XFKXBQYUIU_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XFKXBQYUIU',XFKXBQYUIU_wrap_Blur);
function DFNZBCOVFH_wrap_Valid(event) {
return DFNZBCOVFH_Valid(event);
}
SPBOUILib.SetCheckboxClick('DFNZBCOVFH',DFNZBCOVFH_wrap_Valid);
function DFNZBCOVFH_wrap_OnFocus(event) {
return DFNZBCOVFH_OnFocus(event);
}
SPBOUILib.SetInputEnter('DFNZBCOVFH',DFNZBCOVFH_wrap_OnFocus);
function DFNZBCOVFH_wrap_Blur(event) {
return DFNZBCOVFH_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('DFNZBCOVFH',DFNZBCOVFH_wrap_Blur);
function RHCYCLTWOT_wrap_Valid(event) {
return RHCYCLTWOT_Valid(event);
}
SPBOUILib.SetCheckboxClick('RHCYCLTWOT',RHCYCLTWOT_wrap_Valid);
function RHCYCLTWOT_wrap_OnFocus(event) {
return RHCYCLTWOT_OnFocus(event);
}
SPBOUILib.SetInputEnter('RHCYCLTWOT',RHCYCLTWOT_wrap_OnFocus);
function RHCYCLTWOT_wrap_Blur(event) {
return RHCYCLTWOT_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RHCYCLTWOT',RHCYCLTWOT_wrap_Blur);
function IVKDCKCDQZ_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('IVKDCKCDQZ',IVKDCKCDQZ_wrap_OnKeyDown);
function KRNBWYKUXF_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('KRNBWYKUXF',KRNBWYKUXF_wrap_OnKeyDown);
function FROMUIZATY_wrap_Valid(event) {
return FROMUIZATY_Valid(event);
}
SPBOUILib.SetInputExit('FROMUIZATY',FROMUIZATY_wrap_Valid);
function FROMUIZATY_wrap_OnFocus(event) {
return FROMUIZATY_OnFocus(event);
}
SPBOUILib.SetInputEnter('FROMUIZATY',FROMUIZATY_wrap_OnFocus);
function FROMUIZATY_wrap_OnKeyPress(event) {
return CheckDateChar(event);
}
SPBOUILib.SetInputKeyPress('FROMUIZATY',FROMUIZATY_wrap_OnKeyPress);
function FROMUIZATY_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,true);
}
SPBOUILib.SetInputKeyDown('FROMUIZATY',FROMUIZATY_wrap_OnKeyDown);
function UMKFMWBVUO_wrap_Valid(event) {
return UMKFMWBVUO_Valid(event);
}
SPBOUILib.SetInputExit('UMKFMWBVUO',UMKFMWBVUO_wrap_Valid);
function UMKFMWBVUO_wrap_OnFocus(event) {
return UMKFMWBVUO_OnFocus(event);
}
SPBOUILib.SetInputEnter('UMKFMWBVUO',UMKFMWBVUO_wrap_OnFocus);
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
if (Eq(p_cEvent,'Record Loaded')) {
if (Ne(typeof(Calculation_AFKBPWDUSP),'undefined')) {
old_c=m_bCalculating;
m_bCalculating=true;
Calculation_AFKBPWDUSP();
m_bCalculating=old_c;
if ( ! (old_c)) {
DoUpdate(true);
}
}
}
if (Ne(typeof(w_Opextrbo),'undefined')) {
w_Opextrbo.raiseEvent('armt_personbo_age_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.edit={"page_1":["UYWIEUHCAL"],"page_2":["UMKFMWBVUO"]};
FocusFirstComponent.query={"page_1":["UYWIEUHCAL"],"page_2":["UMKFMWBVUO"]};
FocusFirstComponent.otherwise={"page_1":["UYWIEUHCAL"],"page_2":["UMKFMWBVUO"]};
function Help() {
windowOpenForeground('../doc/armt_personbo_age_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function LoadChildrenInPage(page,lazy) {
}
GetLayerID.Layers.push({"id":"AQSQVBKXAL","name":"DatiBase"});
GetLayerID.Layers.push({"id":"EWPTTWSBMT","name":"PF"});
GetLayerID.Layers.push({"id":"OQFTKYDCIW","name":"AD"});
function DeclareWVs() {
var a = arguments;
w_TIPOPERS=a[0];
w_COGNOME=a[1];
w_NOME=a[2];
w_CFESTERO=a[3];
w_RAGSOC=a[4];
w_PAESE=a[5];
w_DESCCIT=a[6];
w_PROVINCIA=a[7];
w_idcitta=a[8];
w_CAP=a[9];
w_CODCAB=a[10];
w_DOMICILIO=a[11];
w_IDENT=a[12];
w_IDNASCOMUN=a[13];
w_NASCOMUN=a[14];
w_TIPINTER=a[15];
w_IDNASSTATO=a[16];
w_NASSTATO=a[17];
w_SESSO=a[18];
w_DATANASC=a[19];
w_TIPODOC=a[20];
w_NUMDOCUM=a[21];
w_DATARILASC=a[22];
w_DATAVALI=a[23];
w_AUTRILASC=a[24];
w_CODFISC=a[25];
w_PARTIVA=a[26];
w_CONTO=a[27];
w_SOTGRUP=a[28];
w_RAMOGRUP=a[29];
w_ATTIV=a[30];
w_SETTSINT=a[31];
w_CONNES=a[32];
w_NOTIT=a[33];
w_PEP=a[34];
w_CRIME=a[35];
w_PROGIMPORT=a[36];
op_PROGIMPORT=a[37];
w_NOTE=a[38];
w_OLDSETSIN=a[39];
w_NOSARA=a[40];
w_CRIMEDATE=a[41];
w_PEPDATE=a[42];
w_gSeekAos=a[43];
w_gDataVaria=a[44];
w_gFlgDoc=a[45];
w_gTipInter=a[46];
w_gIntemediario=a[47];
w_gVerSim=a[48];
w_gFlgWU=a[49];
w_nascomunid=a[50];
w_nasstatoid=a[51];
w_dataoggi=a[52];
w_tipsot=a[53];
w_flgaggfam=a[54];
w_DESCSGRU=a[55];
w_DESCRAMGRU=a[56];
w_DESCUIC=a[57];
w_dessta=a[58];
w_DATARETT=a[59];
w_STATOREG=a[60];
w_NUMPROG=a[61];
w_DESCRI=a[62];
w_xdescareag=a[63];
w_xdescnatgiu=a[64];
w_xdesctipatt=a[65];
w_xdesccomp=a[66];
w_xstatonas=a[67];
w_finesae=a[68];
w_finesint=a[69];
w_xFLGVALIDO=a[70];
w_xFLGANAVAL=a[71];
w_CONADD=a[72];
w_xDSETSIN=a[73];
w_xITFLGPEP=a[74];
op_codazi=a[75];
o_EWPTTWSBMT_expand=null;
o_EWPTTWSBMT_collapse=null;
if (Gt(a.length,76)) {
o_gIntemediario=w_gIntemediario;
o_COGNOME=w_COGNOME;
o_NOME=w_NOME;
o_PAESE=w_PAESE;
o_DESCCIT=w_DESCCIT;
o_idcitta=w_idcitta;
o_IDNASCOMUN=w_IDNASCOMUN;
o_IDNASSTATO=w_IDNASSTATO;
o_NASSTATO=w_NASSTATO;
o_DATANASC=w_DATANASC;
o_TIPODOC=w_TIPODOC;
o_NUMDOCUM=w_NUMDOCUM;
o_DATARILASC=w_DATARILASC;
o_DATAVALI=w_DATAVALI;
o_SOTGRUP=w_SOTGRUP;
o_RAMOGRUP=w_RAMOGRUP;
o_ATTIV=w_ATTIV;
}
m_PrimaryKeys=['CONNES'];
}
function i_PrimaryKey() {
return 'personbo'+'\\'+CPLib.ToCPStr(w_CONNES);
}
function CheckZone(me) {
return true;
}
GetSelectedChildPage.child={}
function GetSelectedPage(p_d) {
p_d.setValue('armt_personbo_age',m_cSelectedPage);
return GetSelectedChildPage(p_d);
}
function GetEntityActions() {
var l_aActions=[];
return l_aActions;
}
function RenderDynamicCombo(p_id) {
}
function LinkZoomExtendedMenu() {
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"CODSTA","type":"C"},{"expression":function() { return WtA(w_dessta,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstati','C'),"uid":"YVIKEGPYPM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_DESCCIT,'C'); },"field":"CITTA","type":"C"},{"expression":function() { return WtA(w_idcitta,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[{"expression":function() { return WtA(w_PAESE,'C'); },"field":"PKTBSTATI","type":"C"}],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcitta','C'),"uid":"ODAYKSRECA"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDNASCOMUN,'C'); },"field":"IDBASE","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbcittna','C'),"uid":"BYPEBFEOAJ"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_IDNASSTATO,'C'); },"field":"IDBASE","type":"C"},{"expression":function() { return WtA(w_xstatonas,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbstatna','C'),"uid":"IOAMSFCCVV"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('armt_tbtipatt','C'),"fldValues":[{"expression":function() { return WtA(w_ATTIV,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdesctipatt,'C'); },"field":"DESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtipatt','C'),"uid":"SAQTIHOALW"});
}
_Obli('CONTO',0,'JLTVZXPMKM',false,"1715428852")
_Obli('NASSTATO',0,'HODZKKOSYW',false,"12123284333")
_Obli('SESSO',0,'QPALJZMFCL',false,"7776675")
_Obli('IDNASSTATO',0,'IOAMSFCCVV',false,"10175904119")
_Obli('CRIME',0,'RHCYCLTWOT',false,"10242518395")
_Obli('flgaggfam',0,'DFNZBCOVFH',false)
_Obli('PEP',0,'XFKXBQYUIU',false,"1513560829")
_Obli('TIPOPERS',0,'UYWIEUHCAL',true,"10456253029")
_Obli('COGNOME',0,'TWTTDWKCRG',false,"1816546867")
_Obli('NOME',0,'WWGIVGNUDW',false,"443454")
_Obli('CFESTERO',1,'CZTHKEDVCO',false,"10034405761")
_Obli('RAGSOC',0,'AWPNTOJIRR',false,"10662833243")
_Obli('PAESE',0,'YVIKEGPYPM',true,"7776403",'YVIKEGPYPM')
_Obli('DESCCIT',0,'ODAYKSRECA',true,"15186643",'ODAYKSRECA',null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('PROVINCIA',0,'NOTZPDMYIA',true,"10095365423",null,null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('TIPODOC',0,'MBGANUUHRA',false,"11429032151")
_Obli('CAP',0,'RDAVOEETJG',true,"21587",null,null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('CODCAB',0,'BOTAJBWHHY',true,"18003",null,null,function() { return Eq(w_PAESE,'086') || Eq(w_PAESE,'139') })
_Obli('DOMICILIO',0,'VYLHWTRQNX',true,"554236824",null,null,function() { return (Eq(w_PAESE,'086') || Eq(w_PAESE,'139')) && Eq(w_gVerSim,'N') })
_Obli('IDENT',0,'IRLEJAUHCB',false,"1767988220")
_Obli('IDNASCOMUN',0,'BYPEBFEOAJ',false,"200062287")
_Obli('DATAVALI',2,'BNWXBPSIDG',false)
_Obli('NASCOMUN',0,'NEUBQNUEOJ',false,"12123334500")
_Obli('TIPINTER',0,'KPSCOABZLB',false,"3528304")
_Obli('CODFISC',0,'OJJHIUDPFY',false,"11921223220")
_Obli('NOTIT',1,'RARXYHBSLM',false,"327723579")
_Obli('CONNES',0,'YTPWDRMFUS',true,"439891216")
_Obli('DATARETT',2,'FROMUIZATY',false)
_Obli('DATANASC',2,'XMGRWGFSFV',false,"11777527481")
_Obli('PARTIVA',0,'FHXWUTBNKI',false,"1756430089")
_Obli('NUMDOCUM',0,'HVEEMUJUUY',false,"1734932797")
_Obli('DATARILASC',2,'XHWYGOPPUN',false,"1690077224")
_Obli('NOTE',0,'UMKFMWBVUO',false,"445246")
_Obli('AUTRILASC',0,'HRNCPADUFU',false,"10032163180")
_Obli('SOTGRUP',0,'LLYIGAMXRH',false,"611154211")
_Obli('SETTSINT',0,'ZGNLLSFQHC',false,"2095911698")
_Obli('ATTIV',0,'SAQTIHOALW',true,"2134156131",'SAQTIHOALW',"11909346815",function() { return Eq(w_tipsot,'1') })
