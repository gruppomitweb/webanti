function FillCombosValues() {
FillCombo('ZFOHYLVPYN','ZFOHYLVPYN');
FillCombo('BHAVHLFPAC','BHAVHLFPAC');
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('LXORWVRYJJ',function(){return WtH(w_RAPPORTO,'C',25,0,'')},w_RAPPORTO);
SPBOUILib.SetInputValue('AQAARAIPOR',function(){return WtH(w_DESCRAP,'C',50,0,'')},w_DESCRAP);
if(c=Ctrl('ZFOHYLVPYN')) selectCombo(c,w_TIPORAP,'C')
if(c=Ctrl('BHAVHLFPAC')) selectCombo(c,w_TIPOAG,'C')
if(c=Ctrl('BCLYMGMBLK')) selectCombo(c,w_FLAGLIRE,'C')
SPBOUILib.SetInputValue('RUMXLFCOKA',function(){return WtH(w_VALUTA,'C',3,0,'')},w_VALUTA);
var tmp_XQILBJQNNS = ToHTag(AsControlValue(w_descval));
if (Ne(e_XQILBJQNNS,tmp_XQILBJQNNS)) {
SPBOUILib.SetLabelValue('XQILBJQNNS','innerHTML',tmp_XQILBJQNNS);
e_XQILBJQNNS=tmp_XQILBJQNNS;
}
if(c=Ctrl('AABRTCZWUY')) ChkboxCheckUncheck(c,1,w_NOPROT)
if(c=Ctrl('AABRTCZWUY')) ChkboxValueAssign(c,1,0,'N',1,0,'')
SPBOUILib.SetInputValue('VSHUPFYWOC',function(){return WtH(w_NATURA,'C',50,0,'')},w_NATURA);
SPBOUILib.SetInputValue('VASVGQZJGP',function(){return WtH(w_SCOPO,'C',50,0,'')},w_SCOPO);
SPBOUILib.SetInputValue('QJSTZIPOQB',function(){return WtH(w_AREAGEO,'C',5,0,'')},w_AREAGEO);
SPBOUILib.SetInputValue('SFFFOYOWNH',function(){return WtH(w_MODSVOL,'C',5,0,'')},w_MODSVOL);
SPBOUILib.SetInputValue('NOBMPHKVTX',function(){return WtH(w_RAGIO,'C',5,0,'')},w_RAGIO);
SPBOUILib.SetInputValue('DJOWYRMDDC',function(){return WtH(w_TIPO,'C',3,0,'')},w_TIPO);
SPBOUILib.SetInputValue('MXYTQLATHC',function(){return WtH(w_RFREQ,'N',3,0,'')},w_RFREQ);
SPBOUILib.SetInputValue('KBIUAXUDXA',function(){return WtH(w_RIMP,'N',3,0,'')},w_RIMP);
SPBOUILib.SetInputValue('UDAYHICPVB',function(){return WtH(w_RAREA,'N',3,0,'')},w_RAREA);
SPBOUILib.SetInputValue('ETALZDRBSO',function(){return WtH(w_RCOMP,'N',3,0,'')},w_RCOMP);
SPBOUILib.SetInputValue('QBTVZDKLCO',function(){return WtH(w_RRAGIO,'N',3,0,'')},w_RRAGIO);
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
SPBOUILib.SetInputValue('CKJQULDXKW',function(){return WtH(w_DURAT,'C',5,0,'')},w_DURAT);
SPBOUILib.SetInputValue('SXTYCPHBIM',function(){return WtH(w_AMMONT,'C',5,0,'')},w_AMMONT);
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
var tmp_AZOLSYJQIB = ToHTag(AsControlValue(w_RAPPORTO));
if (Ne(e_AZOLSYJQIB,tmp_AZOLSYJQIB)) {
SPBOUILib.SetLabelValue('AZOLSYJQIB','innerHTML',tmp_AZOLSYJQIB);
e_AZOLSYJQIB=tmp_AZOLSYJQIB;
}
var tmp_EEDUDVVNBY = ToHTag(AsControlValue(w_DESCRAP));
if (Ne(e_EEDUDVVNBY,tmp_EEDUDVVNBY)) {
SPBOUILib.SetLabelValue('EEDUDVVNBY','innerHTML',tmp_EEDUDVVNBY);
e_EEDUDVVNBY=tmp_EEDUDVVNBY;
}
var tmp_VLVNGHBBRK = ToHTag(AsControlValue(w_RAPPORTO));
if (Ne(e_VLVNGHBBRK,tmp_VLVNGHBBRK)) {
SPBOUILib.SetLabelValue('VLVNGHBBRK','innerHTML',tmp_VLVNGHBBRK);
e_VLVNGHBBRK=tmp_VLVNGHBBRK;
}
var tmp_MVSPJPANDF = ToHTag(AsControlValue(w_DESCRAP));
if (Ne(e_MVSPJPANDF,tmp_MVSPJPANDF)) {
SPBOUILib.SetLabelValue('MVSPJPANDF','innerHTML',tmp_MVSPJPANDF);
e_MVSPJPANDF=tmp_MVSPJPANDF;
}
SPBOUILib.SetInputValue('YSBAKLZECK',function(){return WtH(w_SPLITCODE,'C',15,0,'')},w_SPLITCODE);
SPBOUILib.SetInputValue('SSYXHQXJLD',function(){return WtH(w_MACODICE,'C',5,0,'')},w_MACODICE);
var tmp_TWSRQQLPNA = ToHTag(AsControlValue(w_xMADESCRI));
if (Ne(e_TWSRQQLPNA,tmp_TWSRQQLPNA)) {
SPBOUILib.SetLabelValue('TWSRQQLPNA','innerHTML',tmp_TWSRQQLPNA);
e_TWSRQQLPNA=tmp_TWSRQQLPNA;
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
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('box_YORQOIOBQN'));
SetDisplay('YYHBZYTHNJ_DIV',IsHiddenByStateDriver('box_YYHBZYTHNJ'));
SetDisplay(Ctrl('MMQZUMTDEV'),Ne(w_gBrowser,'I'));
SetDisplay('LZCEHELAXJ_DIV',IsHiddenByStateDriver('box_LZCEHELAXJ'));
SetDisplay('EHSQLOIDHO_DIV',IsHiddenByStateDriver('box_EHSQLOIDHO'));
SetDisplay(Ctrl('YSBAKLZECK'),Ne(w_gTelepass,'6') || IsHiddenByStateDriver('SPLITCODE'));
SetDisplay(Ctrl('FFCVEAIHJV'),Ne(w_gTelepass,'6'));
SetDisplay(Ctrl('SSYXHQXJLD'),Ne(w_gTelepass,'5') || IsHiddenByStateDriver('MACODICE'));
SetDisplay(Ctrl('SSYXHQXJLD_ZOOM'),Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('JIHVKRMSZD'),Ne(w_gTelepass,'5'));
SetDisplay(Ctrl('TWSRQQLPNA'),Ne(w_gTelepass,'5'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["AMMONT"]=['LXNMWSOUMF'];
HideUI.lblids["AREAGEO"]=['NAVNOGNZNE'];
HideUI.lblids["DESCRAP"]=['VEBJKDHMDC'];
HideUI.lblids["DURAT"]=['ZUVXJIZOSF'];
HideUI.lblids["FLAGLIRE"]=['OUQKLNQVMP'];
HideUI.lblids["MACODICE"]=['JIHVKRMSZD'];
HideUI.lblids["MODSVOL"]=['LHTXLTQYIK'];
HideUI.lblids["NATURA"]=['BVGYBYGMJB'];
HideUI.lblids["RAGIO"]=['HGXSBHTFKF'];
HideUI.lblids["RAPPORTO"]=['OICGZUOZYP'];
HideUI.lblids["SCOPO"]=['EWATRAIADP'];
HideUI.lblids["SPLITCODE"]=['FFCVEAIHJV'];
HideUI.lblids["TIPO"]=['OKFGBGYVWD'];
HideUI.lblids["TIPOAG"]=['CTCKWHZVTZ'];
HideUI.lblids["TIPORAP"]=['GDCHKTFQUK'];
HideUI.lblids["VALUTA"]=['MILRATMPIJ'];
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
SetActiveField(Ctrl('LXORWVRYJJ'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('LXORWVRYJJ'),e);
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
function MMQZUMTDEV_Click() {
nuovainf()
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
function QIETKIRGON_Click() {
Crea3132()
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
linkpc_url.u('OYYXUVDIWN',function(){return 'ardt_delegabo?m_bInnerChild=true'+GetLinkPCKeys('ardt_delegabo')+'&m_bRowsChild='+EnableChild('ardt_delegabo')})
_ResetTracker();
function setEventHandlers() {
var c;
function MMQZUMTDEV_wrap_OnClick(event) {
return MMQZUMTDEV_Click();
}
SPBOUILib.SetButtonClick('MMQZUMTDEV',MMQZUMTDEV_wrap_OnClick);
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
function MMQZUMTDEV_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('MMQZUMTDEV',MMQZUMTDEV_wrap_OnKeyDown);
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
function QIETKIRGON_wrap_OnKeyDown(event) {
return ManageKeys(event,true,false);
}
SPBOUILib.SetButtonKeyDown('QIETKIRGON',QIETKIRGON_wrap_OnKeyDown);
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
if (Ne(typeof(w_Intestatati),'undefined')) {
w_Intestatati.raiseEvent('armt_storanarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Informazioni),'undefined')) {
w_Informazioni.raiseEvent('armt_storanarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Operazioni),'undefined')) {
w_Operazioni.raiseEvent('armt_storanarap_'+Strtran(p_cEvent,' ','_'));
}
if (Ne(typeof(w_Frazionate),'undefined')) {
w_Frazionate.raiseEvent('armt_storanarap_'+Strtran(p_cEvent,' ','_'));
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
FocusFirstComponent.edit={"page_1":["AQAARAIPOR"],"page_2":["QIETKIRGON"],"page_3":["YSBAKLZECK","SSYXHQXJLD"]};
FocusFirstComponent.query={"page_1":["LXORWVRYJJ"],"page_3":["YSBAKLZECK","SSYXHQXJLD"]};
FocusFirstComponent.otherwise={"page_1":["LXORWVRYJJ"],"page_2":["QIETKIRGON"],"page_3":["YSBAKLZECK","SSYXHQXJLD"]};
function Help() {
windowOpenForeground('../doc/armt_storanarap_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_delegabo() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_3')) {
if (ChildToLoad('OYYXUVDIWN')) {
LoadContext.lc(1,'OYYXUVDIWN');
} else {
LibJavascript.RefreshChildGrid('OYYXUVDIWN');
}
}
}
function DeclareWVs() {
var a = arguments;
w_RAPPORTO=a[0];
w_DESCRAP=a[1];
w_TIPORAP=a[2];
w_TIPOAG=a[3];
w_FLAGLIRE=a[4];
w_VALUTA=a[5];
w_NOPROT=a[6];
w_NATURA=a[7];
w_SCOPO=a[8];
w_AREAGEO=a[9];
w_MODSVOL=a[10];
w_RAGIO=a[11];
w_TIPO=a[12];
w_RFREQ=a[13];
w_RIMP=a[14];
w_RAREA=a[15];
w_RCOMP=a[16];
w_RRAGIO=a[17];
w_RTIPO=a[18];
w_PRGIMPRAP=a[19];
op_PRGIMPRAP=a[20];
w_DURAT=a[21];
w_AMMONT=a[22];
w_SPLITCODE=a[23];
w_MACODICE=a[24];
w_CODDIP=a[25];
w_descval=a[26];
w_daticoll=a[27];
w_xdescmodsvo=a[28];
w_xdescareag=a[29];
w_xdescplauso=a[30];
w_xdesctipor=a[31];
w_xdescfreq=a[32];
w_xdescammo=a[33];
w_gTelepass=a[34];
w_xMADESCRI=a[35];
w_mess=a[36];
w_gBrowser=a[37];
w_gCodDip=a[38];
op_codazi=a[39];
m_cWv_ardt_delegabo=a[40];
if (Gt(a.length,41)) {
m_cErrorInChild='';
}
if (Gt(a.length,41)) {
o_FLAGLIRE=w_FLAGLIRE;
o_VALUTA=w_VALUTA;
}
m_PrimaryKeys=['RAPPORTO'];
}
function i_PrimaryKey() {
return 'wnarapbo'+'\\'+CPLib.ToCPStr(w_RAPPORTO);
}
GetLinkPCKeys.set_o('ardt_delegabo',false);
GetLinkPCKeys.o['ardt_delegabo']['RAPPORTO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_RAPPORTO,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('OYYXUVDIWN',function(){return FrameRef('ardt_delegabo')},1,'ardt_delegabo',1,3)
GetSelectedChildPage.child={'ardt_delegabo': function(){return FrameRef('ardt_delegabo')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_storanarap',m_cSelectedPage);
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
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AREAGEO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescareag,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RAREA,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbareegeog','C'),"uid":"QJSTZIPOQB"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_MODSVOL,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescmodsvo,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RCOMP,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbsvolgim','C'),"uid":"SFFFOYOWNH"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_RAGIO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescplauso,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RRAGIO,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbplauso','C'),"uid":"NOBMPHKVTX"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_TIPO,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdesctipor,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RTIPO,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbtiporisc','C'),"uid":"DJOWYRMDDC"});
ExtendedMenu({"configName":WtA('','C'),"entityName":WtA('ammt_tbdurata','C'),"fldValues":[{"expression":function() { return WtA(w_DURAT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescfreq,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RFREQ,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbdurata','C'),"uid":"CKJQULDXKW"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_AMMONT,'C'); },"field":"CODICE","type":"C"},{"expression":function() { return WtA(w_xdescammo,'C'); },"field":"DESCRI","type":"C"},{"expression":function() { return WtA(w_RIMP,'N'); },"field":"RISCHIO","type":"N"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbimporto','C'),"uid":"SXTYCPHBIM"});
ExtendedMenu({"configName":WtA('','C'),"fldValues":[{"expression":function() { return WtA(w_MACODICE,'C'); },"field":"MACODICE","type":"C"},{"expression":function() { return WtA(w_xMADESCRI,'C'); },"field":"MADESCRI","type":"C"}],"keyValues":[],"linkedUsings":[],"prgInitFields":[],"tableName":WtA('tbmacage','C'),"uid":"SSYXHQXJLD"});
}
_Obli('RAPPORTO',0,'LXORWVRYJJ',false,"11116511596")
_Obli('DESCRAP',0,'AQAARAIPOR',false,"285808099")
_Obli('TIPORAP',0,'ZFOHYLVPYN',false,"1723736132")
_Obli('TIPOAG',0,'BHAVHLFPAC',false)
_Obli('FLAGLIRE',0,'BCLYMGMBLK',false,"109710548")
_Obli('VALUTA',0,'RUMXLFCOKA',false,"1730321404")
_Obli('RCOMP',1,'ETALZDRBSO',false)
_Obli('RAREA',1,'UDAYHICPVB',false)
_Obli('NOPROT',1,'AABRTCZWUY',false,"10194595222")
_Obli('NATURA',0,'VSHUPFYWOC',false)
_Obli('SCOPO',0,'VASVGQZJGP',false)
_Obli('AREAGEO',0,'QJSTZIPOQB',false)
_Obli('MODSVOL',0,'SFFFOYOWNH',false)
_Obli('RAGIO',0,'NOBMPHKVTX',false)
_Obli('TIPO',0,'DJOWYRMDDC',false)
_Obli('RFREQ',1,'MXYTQLATHC',false)
_Obli('RIMP',1,'KBIUAXUDXA',false)
_Obli('MACODICE',0,'SSYXHQXJLD',false,"11283631966")
_Obli('AMMONT',0,'SXTYCPHBIM',false)
_Obli('RRAGIO',1,'QBTVZDKLCO',false)
_Obli('RTIPO',1,'RUWEXWJASG',false)
_Obli('SPLITCODE',0,'YSBAKLZECK',true,"115410470",null,null,function() { return Eq(w_gTelepass,'6') })
_Obli('DURAT',0,'CKJQULDXKW',false)
