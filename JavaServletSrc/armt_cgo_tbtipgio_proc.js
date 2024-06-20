function FillCombosValues() {
}
function SetControlsValue() {
var c;
SPBOUILib.SetInputValue('RCAIOHOYCN',function(){return WtH(w_CODTPGIO,'C',3,0,'')},w_CODTPGIO);
SPBOUILib.SetInputValue('PLTDFOMPMX',function(){return WtH(w_DESTPGIO,'C',50,0,'')},w_DESTPGIO);
SPBOUILib.SetInputValue('DLCJAPAHNK',function(){return WtH(w_SOGTPGIO,'N',12,2,'999,999,999.99')},w_SOGTPGIO);
if(c=Ctrl('PPZWLBHZXY')) ChkboxCheckUncheck(c,'S',w_EDTTPGIO)
if(c=Ctrl('PPZWLBHZXY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('SOFGJQQNFS')) selectCombo(c,w_DEFTPGIO,'C')
if(c=Ctrl('GOFVHZECXL')) ChkboxCheckUncheck(c,'S',w_EDTSPGIO)
if(c=Ctrl('GOFVHZECXL')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NZZQBPTZYU')) selectCombo(c,w_DEFSPGIO,'C')
if(c=Ctrl('MRDEGXONBG')) ChkboxCheckUncheck(c,'S',w_FLGPLGIO)
if(c=Ctrl('MRDEGXONBG')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('FMLKVYWRZP')) ChkboxCheckUncheck(c,'S',w_FLGMLGIO)
if(c=Ctrl('FMLKVYWRZP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('RNGJQLKVFO',function(){return WtH(w_MAGPAGGIO,'N',2,0,'')},w_MAGPAGGIO);
SPBOUILib.SetInputValue('UFVJWZLULG',function(){return WtH(w_MINPAGGIO,'N',2,0,'')},w_MINPAGGIO);
if(c=Ctrl('CAUFCTBRNM')) ChkboxCheckUncheck(c,'S',w_FDC1OSGIO)
if(c=Ctrl('CAUFCTBRNM')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('UGCFKKQJNN')) ChkboxCheckUncheck(c,'S',w_FDC2OSGIO)
if(c=Ctrl('UGCFKKQJNN')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XNNAMCGSXP')) ChkboxCheckUncheck(c,'S',w_FDC3OSGIO)
if(c=Ctrl('XNNAMCGSXP')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('MYUZABATXZ')) ChkboxCheckUncheck(c,'S',w_FDC4OSGIO)
if(c=Ctrl('MYUZABATXZ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RSGIDFYOLS')) ChkboxCheckUncheck(c,'S',w_FDC5OSGIO)
if(c=Ctrl('RSGIDFYOLS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('YPMOMULORE')) ChkboxCheckUncheck(c,'S',w_FDC6OSGIO)
if(c=Ctrl('YPMOMULORE')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('QEKBNPGOBS')) ChkboxCheckUncheck(c,'S',w_FDC1SSGIO)
if(c=Ctrl('QEKBNPGOBS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('NFHGTEJQNE')) ChkboxCheckUncheck(c,'S',w_FDC2SSGIO)
if(c=Ctrl('NFHGTEJQNE')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('GJLCDJIDAY')) ChkboxCheckUncheck(c,'S',w_FDC3SSGIO)
if(c=Ctrl('GJLCDJIDAY')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('RBOWBOPVOA')) ChkboxCheckUncheck(c,'S',w_FDC4SSGIO)
if(c=Ctrl('RBOWBOPVOA')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('DHNVKQKTHK')) ChkboxCheckUncheck(c,'S',w_FDC5SSGIO)
if(c=Ctrl('DHNVKQKTHK')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('CBJEEAJCGS')) ChkboxCheckUncheck(c,'S',w_FDC6SSGIO)
if(c=Ctrl('CBJEEAJCGS')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('UXGJFWIPXB')) ChkboxCheckUncheck(c,'S',w_FDC1ACGIO)
if(c=Ctrl('UXGJFWIPXB')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('TKEHQQFQUC')) ChkboxCheckUncheck(c,'S',w_FDC2ACGIO)
if(c=Ctrl('TKEHQQFQUC')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('XBPDZFAWFR')) ChkboxCheckUncheck(c,'S',w_FDC3ACGIO)
if(c=Ctrl('XBPDZFAWFR')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('ZJMEDHEECW')) ChkboxCheckUncheck(c,'S',w_FDC4ACGIO)
if(c=Ctrl('ZJMEDHEECW')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('TOJFZPDKWJ')) ChkboxCheckUncheck(c,'S',w_FDC5ACGIO)
if(c=Ctrl('TOJFZPDKWJ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
if(c=Ctrl('UXAYRLQXMN')) ChkboxCheckUncheck(c,'S',w_FDC6ACGIO)
if(c=Ctrl('UXAYRLQXMN')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('MXUUACEBJE',function(){return WtH(w_NCOPAGGIO,'N',2,0,'')},w_NCOPAGGIO);
if(c=Ctrl('LTMWIPFDRU')) selectRadio(c,w_FLTIPGIO,'C')
if(c=Ctrl('RVLRRQTSCQ')) ChkboxCheckUncheck(c,'S',w_FLGATTIVO)
if(c=Ctrl('RVLRRQTSCQ')) ChkboxValueAssign(c,'S','N','C',1,0,'')
SPBOUILib.SetInputValue('UFVFYVMNVG',function(){return WtH(w_IMPMINGIO,'N',10,2,'9,999,999.99')},w_IMPMINGIO);
SPBOUILib.SetInputValue('UVKSMYBGBT',function(){return WtH(w_IMPMINTOT,'N',12,2,'9,999,999.99')},w_IMPMINTOT);
if (m_bExtended) {
SetExtensions();
}
if (window.SPMobileLib) {
window.SPMobileLib.iOSRepaint();
}
}
function HideControlsUnderCondition() {
var h;
SetDisplay('YORQOIOBQN_DIV',IsHiddenByStateDriver('Base'));
SetDisplay('GIMNJEFKNF_DIV',IsHiddenByStateDriver('box_GIMNJEFKNF'));
SetDisplay('MFCHEDYPZM_DIV',IsHiddenByStateDriver('box_MFCHEDYPZM'));
SetDisplay('OERGIOTKFK_DIV',IsHiddenByStateDriver('box_OERGIOTKFK'));
SetDisplay('PBPNWREDVO_DIV',IsHiddenByStateDriver('TipReg'));
LibJavascript.forEachItem(m_FoundlingHideExpression,i_body_2)
function i_body_2(child){
child();
}
HideUI();
}
HideUI.lblids["CODTPGIO"]=['HHFRUECYAF'];
HideUI.lblids["DEFSPGIO"]=['VPKIKBZRVZ'];
HideUI.lblids["DEFTPGIO"]=['TENXMNLTTK'];
HideUI.lblids["DESTPGIO"]=['RSSVRXXCCP'];
HideUI.lblids["FLTIPGIO"]=['DJYCCVWMOP'];
HideUI.lblids["IMPMINGIO"]=['ZZOTBVRTLQ'];
HideUI.lblids["IMPMINTOT"]=['BKOBIZPXGR'];
HideUI.lblids["MAGPAGGIO"]=['ITKWXOHKBK','QPPLTIMJLH','GPUIIBJKGO'];
HideUI.lblids["SOGTPGIO"]=['BEHWXHTIBN'];
function ExpandCollapseBoxesUnderCondition() {
var cond;
}
function RCAIOHOYCN_Valid(e) {
SetActiveField(Ctrl('RCAIOHOYCN'),false);
if (Eq(m_cFunction,'query')) {
if (IsLastInPk('RCAIOHOYCN') ||  ! (m_bQueryOnLatestKeyOnly)) {
DoQuery('CODTPGIO','C',w_CODTPGIO,HtW(Ctrl('RCAIOHOYCN').value,'C'),m_bQueryOnLatestKeyOnly);
}
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_CODTPGIO(HtW(Ctrl('RCAIOHOYCN').value,'C'),null,e);
return l_bSetResult;
}
}
function RCAIOHOYCN_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RCAIOHOYCN'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RCAIOHOYCN'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RCAIOHOYCN'),e);
}
function PLTDFOMPMX_Valid(e) {
SetActiveField(Ctrl('PLTDFOMPMX'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('DESTPGIO','C',w_DESTPGIO,HtW(Ctrl('PLTDFOMPMX').value,'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DESTPGIO(HtW(Ctrl('PLTDFOMPMX').value,'C'),null,e);
return l_bSetResult;
}
}
function PLTDFOMPMX_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('PLTDFOMPMX'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('PLTDFOMPMX'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('PLTDFOMPMX'),e);
}
function DLCJAPAHNK_Valid(e) {
SetActiveField(Ctrl('DLCJAPAHNK'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('SOGTPGIO','N',w_SOGTPGIO,HtW(Ctrl('DLCJAPAHNK').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_SOGTPGIO(HtW(Ctrl('DLCJAPAHNK').value,'N'),null,e);
return l_bSetResult;
}
}
function DLCJAPAHNK_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('DLCJAPAHNK'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('DLCJAPAHNK',w_SOGTPGIO,'N',12,2,'999999999.99');
SetActiveField(Ctrl('DLCJAPAHNK'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('DLCJAPAHNK'),e);
}
function DLCJAPAHNK_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("999999999.99"));
}
function PPZWLBHZXY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('EDTTPGIO','C',w_EDTTPGIO,ChkboxValueAssign(Ctrl('PPZWLBHZXY'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EDTTPGIO(ChkboxValueAssign(Ctrl('PPZWLBHZXY'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function PPZWLBHZXY_OnFocus(e) {
SetActiveField(Ctrl('PPZWLBHZXY'),true);
}
function PPZWLBHZXY_OnBlur(e) {
SetActiveField(Ctrl('PPZWLBHZXY'),false);
}
function SOFGJQQNFS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DEFTPGIO','C',w_DEFTPGIO,HtW(getComboValue(Ctrl('SOFGJQQNFS')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DEFTPGIO(HtW(getComboValue(Ctrl('SOFGJQQNFS')),'C'),null,e);
return l_bSetResult;
}
}
function SOFGJQQNFS_OnFocus(e) {
SetActiveField(Ctrl('SOFGJQQNFS'),true);
}
function SOFGJQQNFS_OnBlur(e) {
SetActiveField(Ctrl('SOFGJQQNFS'),false);
}
function GOFVHZECXL_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('EDTSPGIO','C',w_EDTSPGIO,ChkboxValueAssign(Ctrl('GOFVHZECXL'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_EDTSPGIO(ChkboxValueAssign(Ctrl('GOFVHZECXL'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function GOFVHZECXL_OnFocus(e) {
SetActiveField(Ctrl('GOFVHZECXL'),true);
}
function GOFVHZECXL_OnBlur(e) {
SetActiveField(Ctrl('GOFVHZECXL'),false);
}
function NZZQBPTZYU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('DEFSPGIO','C',w_DEFSPGIO,HtW(getComboValue(Ctrl('NZZQBPTZYU')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_DEFSPGIO(HtW(getComboValue(Ctrl('NZZQBPTZYU')),'C'),null,e);
return l_bSetResult;
}
}
function NZZQBPTZYU_OnFocus(e) {
SetActiveField(Ctrl('NZZQBPTZYU'),true);
}
function NZZQBPTZYU_OnBlur(e) {
SetActiveField(Ctrl('NZZQBPTZYU'),false);
}
function MRDEGXONBG_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGPLGIO','C',w_FLGPLGIO,ChkboxValueAssign(Ctrl('MRDEGXONBG'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGPLGIO(ChkboxValueAssign(Ctrl('MRDEGXONBG'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function MRDEGXONBG_OnFocus(e) {
SetActiveField(Ctrl('MRDEGXONBG'),true);
}
function MRDEGXONBG_OnBlur(e) {
SetActiveField(Ctrl('MRDEGXONBG'),false);
}
function FMLKVYWRZP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGMLGIO','C',w_FLGMLGIO,ChkboxValueAssign(Ctrl('FMLKVYWRZP'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGMLGIO(ChkboxValueAssign(Ctrl('FMLKVYWRZP'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function FMLKVYWRZP_OnFocus(e) {
SetActiveField(Ctrl('FMLKVYWRZP'),true);
}
function FMLKVYWRZP_OnBlur(e) {
SetActiveField(Ctrl('FMLKVYWRZP'),false);
}
function RNGJQLKVFO_Valid(e) {
SetActiveField(Ctrl('RNGJQLKVFO'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MAGPAGGIO','N',w_MAGPAGGIO,HtW(Ctrl('RNGJQLKVFO').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MAGPAGGIO(HtW(Ctrl('RNGJQLKVFO').value,'N'),null,e);
return l_bSetResult;
}
}
function RNGJQLKVFO_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('RNGJQLKVFO'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('RNGJQLKVFO'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('RNGJQLKVFO'),e);
}
function UFVJWZLULG_Valid(e) {
SetActiveField(Ctrl('UFVJWZLULG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('MINPAGGIO','N',w_MINPAGGIO,HtW(Ctrl('UFVJWZLULG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_MINPAGGIO(HtW(Ctrl('UFVJWZLULG').value,'N'),null,e);
return l_bSetResult;
}
}
function UFVJWZLULG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UFVJWZLULG'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('UFVJWZLULG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UFVJWZLULG'),e);
}
function CAUFCTBRNM_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC1OSGIO','C',w_FDC1OSGIO,ChkboxValueAssign(Ctrl('CAUFCTBRNM'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC1OSGIO(ChkboxValueAssign(Ctrl('CAUFCTBRNM'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CAUFCTBRNM_OnFocus(e) {
SetActiveField(Ctrl('CAUFCTBRNM'),true);
}
function CAUFCTBRNM_OnBlur(e) {
SetActiveField(Ctrl('CAUFCTBRNM'),false);
}
function UGCFKKQJNN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC2OSGIO','C',w_FDC2OSGIO,ChkboxValueAssign(Ctrl('UGCFKKQJNN'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC2OSGIO(ChkboxValueAssign(Ctrl('UGCFKKQJNN'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UGCFKKQJNN_OnFocus(e) {
SetActiveField(Ctrl('UGCFKKQJNN'),true);
}
function UGCFKKQJNN_OnBlur(e) {
SetActiveField(Ctrl('UGCFKKQJNN'),false);
}
function XNNAMCGSXP_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC3OSGIO','C',w_FDC3OSGIO,ChkboxValueAssign(Ctrl('XNNAMCGSXP'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC3OSGIO(ChkboxValueAssign(Ctrl('XNNAMCGSXP'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XNNAMCGSXP_OnFocus(e) {
SetActiveField(Ctrl('XNNAMCGSXP'),true);
}
function XNNAMCGSXP_OnBlur(e) {
SetActiveField(Ctrl('XNNAMCGSXP'),false);
}
function MYUZABATXZ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC4OSGIO','C',w_FDC4OSGIO,ChkboxValueAssign(Ctrl('MYUZABATXZ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC4OSGIO(ChkboxValueAssign(Ctrl('MYUZABATXZ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function MYUZABATXZ_OnFocus(e) {
SetActiveField(Ctrl('MYUZABATXZ'),true);
}
function MYUZABATXZ_OnBlur(e) {
SetActiveField(Ctrl('MYUZABATXZ'),false);
}
function RSGIDFYOLS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC5OSGIO','C',w_FDC5OSGIO,ChkboxValueAssign(Ctrl('RSGIDFYOLS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC5OSGIO(ChkboxValueAssign(Ctrl('RSGIDFYOLS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RSGIDFYOLS_OnFocus(e) {
SetActiveField(Ctrl('RSGIDFYOLS'),true);
}
function RSGIDFYOLS_OnBlur(e) {
SetActiveField(Ctrl('RSGIDFYOLS'),false);
}
function YPMOMULORE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC6OSGIO','C',w_FDC6OSGIO,ChkboxValueAssign(Ctrl('YPMOMULORE'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC6OSGIO(ChkboxValueAssign(Ctrl('YPMOMULORE'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function YPMOMULORE_OnFocus(e) {
SetActiveField(Ctrl('YPMOMULORE'),true);
}
function YPMOMULORE_OnBlur(e) {
SetActiveField(Ctrl('YPMOMULORE'),false);
}
function QEKBNPGOBS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC1SSGIO','C',w_FDC1SSGIO,ChkboxValueAssign(Ctrl('QEKBNPGOBS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC1SSGIO(ChkboxValueAssign(Ctrl('QEKBNPGOBS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function QEKBNPGOBS_OnFocus(e) {
SetActiveField(Ctrl('QEKBNPGOBS'),true);
}
function QEKBNPGOBS_OnBlur(e) {
SetActiveField(Ctrl('QEKBNPGOBS'),false);
}
function NFHGTEJQNE_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC2SSGIO','C',w_FDC2SSGIO,ChkboxValueAssign(Ctrl('NFHGTEJQNE'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC2SSGIO(ChkboxValueAssign(Ctrl('NFHGTEJQNE'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function NFHGTEJQNE_OnFocus(e) {
SetActiveField(Ctrl('NFHGTEJQNE'),true);
}
function NFHGTEJQNE_OnBlur(e) {
SetActiveField(Ctrl('NFHGTEJQNE'),false);
}
function GJLCDJIDAY_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC3SSGIO','C',w_FDC3SSGIO,ChkboxValueAssign(Ctrl('GJLCDJIDAY'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC3SSGIO(ChkboxValueAssign(Ctrl('GJLCDJIDAY'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function GJLCDJIDAY_OnFocus(e) {
SetActiveField(Ctrl('GJLCDJIDAY'),true);
}
function GJLCDJIDAY_OnBlur(e) {
SetActiveField(Ctrl('GJLCDJIDAY'),false);
}
function RBOWBOPVOA_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC4SSGIO','C',w_FDC4SSGIO,ChkboxValueAssign(Ctrl('RBOWBOPVOA'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC4SSGIO(ChkboxValueAssign(Ctrl('RBOWBOPVOA'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RBOWBOPVOA_OnFocus(e) {
SetActiveField(Ctrl('RBOWBOPVOA'),true);
}
function RBOWBOPVOA_OnBlur(e) {
SetActiveField(Ctrl('RBOWBOPVOA'),false);
}
function DHNVKQKTHK_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC5SSGIO','C',w_FDC5SSGIO,ChkboxValueAssign(Ctrl('DHNVKQKTHK'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC5SSGIO(ChkboxValueAssign(Ctrl('DHNVKQKTHK'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function DHNVKQKTHK_OnFocus(e) {
SetActiveField(Ctrl('DHNVKQKTHK'),true);
}
function DHNVKQKTHK_OnBlur(e) {
SetActiveField(Ctrl('DHNVKQKTHK'),false);
}
function CBJEEAJCGS_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC6SSGIO','C',w_FDC6SSGIO,ChkboxValueAssign(Ctrl('CBJEEAJCGS'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC6SSGIO(ChkboxValueAssign(Ctrl('CBJEEAJCGS'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function CBJEEAJCGS_OnFocus(e) {
SetActiveField(Ctrl('CBJEEAJCGS'),true);
}
function CBJEEAJCGS_OnBlur(e) {
SetActiveField(Ctrl('CBJEEAJCGS'),false);
}
function UXGJFWIPXB_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC1ACGIO','C',w_FDC1ACGIO,ChkboxValueAssign(Ctrl('UXGJFWIPXB'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC1ACGIO(ChkboxValueAssign(Ctrl('UXGJFWIPXB'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UXGJFWIPXB_OnFocus(e) {
SetActiveField(Ctrl('UXGJFWIPXB'),true);
}
function UXGJFWIPXB_OnBlur(e) {
SetActiveField(Ctrl('UXGJFWIPXB'),false);
}
function TKEHQQFQUC_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC2ACGIO','C',w_FDC2ACGIO,ChkboxValueAssign(Ctrl('TKEHQQFQUC'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC2ACGIO(ChkboxValueAssign(Ctrl('TKEHQQFQUC'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function TKEHQQFQUC_OnFocus(e) {
SetActiveField(Ctrl('TKEHQQFQUC'),true);
}
function TKEHQQFQUC_OnBlur(e) {
SetActiveField(Ctrl('TKEHQQFQUC'),false);
}
function XBPDZFAWFR_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC3ACGIO','C',w_FDC3ACGIO,ChkboxValueAssign(Ctrl('XBPDZFAWFR'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC3ACGIO(ChkboxValueAssign(Ctrl('XBPDZFAWFR'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function XBPDZFAWFR_OnFocus(e) {
SetActiveField(Ctrl('XBPDZFAWFR'),true);
}
function XBPDZFAWFR_OnBlur(e) {
SetActiveField(Ctrl('XBPDZFAWFR'),false);
}
function ZJMEDHEECW_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC4ACGIO','C',w_FDC4ACGIO,ChkboxValueAssign(Ctrl('ZJMEDHEECW'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC4ACGIO(ChkboxValueAssign(Ctrl('ZJMEDHEECW'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function ZJMEDHEECW_OnFocus(e) {
SetActiveField(Ctrl('ZJMEDHEECW'),true);
}
function ZJMEDHEECW_OnBlur(e) {
SetActiveField(Ctrl('ZJMEDHEECW'),false);
}
function TOJFZPDKWJ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC5ACGIO','C',w_FDC5ACGIO,ChkboxValueAssign(Ctrl('TOJFZPDKWJ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC5ACGIO(ChkboxValueAssign(Ctrl('TOJFZPDKWJ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function TOJFZPDKWJ_OnFocus(e) {
SetActiveField(Ctrl('TOJFZPDKWJ'),true);
}
function TOJFZPDKWJ_OnBlur(e) {
SetActiveField(Ctrl('TOJFZPDKWJ'),false);
}
function UXAYRLQXMN_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FDC6ACGIO','C',w_FDC6ACGIO,ChkboxValueAssign(Ctrl('UXAYRLQXMN'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FDC6ACGIO(ChkboxValueAssign(Ctrl('UXAYRLQXMN'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function UXAYRLQXMN_OnFocus(e) {
SetActiveField(Ctrl('UXAYRLQXMN'),true);
}
function UXAYRLQXMN_OnBlur(e) {
SetActiveField(Ctrl('UXAYRLQXMN'),false);
}
function MXUUACEBJE_Valid(e) {
SetActiveField(Ctrl('MXUUACEBJE'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('NCOPAGGIO','N',w_NCOPAGGIO,HtW(Ctrl('MXUUACEBJE').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_NCOPAGGIO(HtW(Ctrl('MXUUACEBJE').value,'N'),null,e);
return l_bSetResult;
}
}
function MXUUACEBJE_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('MXUUACEBJE'))) {
DisplayErrorMessage();
}
SetActiveField(Ctrl('MXUUACEBJE'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('MXUUACEBJE'),e);
}
function LTMWIPFDRU_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLTIPGIO','C',w_FLTIPGIO,HtW(getRadioValue(Ctrl('LTMWIPFDRU')),'C'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLTIPGIO(HtW(getRadioValue(Ctrl('LTMWIPFDRU')),'C'),null,e);
return l_bSetResult;
}
}
function RVLRRQTSCQ_Valid(e) {
if (Eq(m_cFunction,'query')) {
DoQuery('FLGATTIVO','C',w_FLGATTIVO,ChkboxValueAssign(Ctrl('RVLRRQTSCQ'),'S','N','C',1,0,''));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_FLGATTIVO(ChkboxValueAssign(Ctrl('RVLRRQTSCQ'),'S','N','C',1,0,''),null,e);
return l_bSetResult;
}
}
function RVLRRQTSCQ_OnFocus(e) {
SetActiveField(Ctrl('RVLRRQTSCQ'),true);
}
function RVLRRQTSCQ_OnBlur(e) {
SetActiveField(Ctrl('RVLRRQTSCQ'),false);
}
function UFVFYVMNVG_Valid(e) {
SetActiveField(Ctrl('UFVFYVMNVG'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPMINGIO','N',w_IMPMINGIO,HtW(Ctrl('UFVFYVMNVG').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPMINGIO(HtW(Ctrl('UFVFYVMNVG').value,'N'),null,e);
return l_bSetResult;
}
}
function UFVFYVMNVG_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UFVFYVMNVG'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('UFVFYVMNVG',w_IMPMINGIO,'N',10,2,'9999999.99');
SetActiveField(Ctrl('UFVFYVMNVG'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UFVFYVMNVG'),e);
}
function UFVFYVMNVG_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999.99"));
}
function UVKSMYBGBT_Valid(e) {
SetActiveField(Ctrl('UVKSMYBGBT'),false);
if (Eq(m_cFunction,'query')) {
DoQuery('IMPMINTOT','N',w_IMPMINTOT,HtW(Ctrl('UVKSMYBGBT').value,'N'));
} else {
e=(Ne(e,null)?e:window.event);
var l_bSetResult;
l_bSetResult=Set_IMPMINTOT(HtW(Ctrl('UVKSMYBGBT').value,'N'),null,e);
return l_bSetResult;
}
}
function UVKSMYBGBT_OnFocus(e) {
if (Ne(m_cFunction,'query') &&  ! (CheckZone('UVKSMYBGBT'))) {
DisplayErrorMessage();
}
SPBOUILib.WtH('UVKSMYBGBT',w_IMPMINTOT,'N',12,2,'9999999.99');
SetActiveField(Ctrl('UVKSMYBGBT'),true);
SetLastFocusedOnParent();
SPSelectCtrl(Ctrl('UVKSMYBGBT'),e);
}
function UVKSMYBGBT_CheckNumWithPict(e) {
return CheckNumWithPict(e,GetModDecPict("9999999.99"));
}
linkpc_url.u('EKQWOMODBX',function(){return 'ardt_cgo_tgtiporeg?m_bInnerChild=true'+GetLinkPCKeys('ardt_cgo_tgtiporeg')+'&m_bRowsChild='+EnableChild('ardt_cgo_tgtiporeg')})
_ResetTracker();
function setEventHandlers() {
var c;
if (Ne(m_cFunction,'view')) {
function RCAIOHOYCN_wrap_Valid(event) {
return RCAIOHOYCN_Valid(event);
}
SPBOUILib.SetInputExit('RCAIOHOYCN',RCAIOHOYCN_wrap_Valid);
function RCAIOHOYCN_wrap_OnFocus(event) {
return RCAIOHOYCN_OnFocus(event);
}
SPBOUILib.SetInputEnter('RCAIOHOYCN',RCAIOHOYCN_wrap_OnFocus);
function RCAIOHOYCN_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RCAIOHOYCN',RCAIOHOYCN_wrap_OnKeyDown);
function PLTDFOMPMX_wrap_Valid(event) {
return PLTDFOMPMX_Valid(event);
}
SPBOUILib.SetInputExit('PLTDFOMPMX',PLTDFOMPMX_wrap_Valid);
function PLTDFOMPMX_wrap_OnFocus(event) {
return PLTDFOMPMX_OnFocus(event);
}
SPBOUILib.SetInputEnter('PLTDFOMPMX',PLTDFOMPMX_wrap_OnFocus);
function PLTDFOMPMX_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('PLTDFOMPMX',PLTDFOMPMX_wrap_OnKeyDown);
function DLCJAPAHNK_wrap_Valid(event) {
return DLCJAPAHNK_Valid(event);
}
SPBOUILib.SetInputExit('DLCJAPAHNK',DLCJAPAHNK_wrap_Valid);
function DLCJAPAHNK_wrap_OnFocus(event) {
return DLCJAPAHNK_OnFocus(event);
}
SPBOUILib.SetInputEnter('DLCJAPAHNK',DLCJAPAHNK_wrap_OnFocus);
function DLCJAPAHNK_wrap_OnKeyPress(event) {
return DLCJAPAHNK_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('DLCJAPAHNK',DLCJAPAHNK_wrap_OnKeyPress);
function DLCJAPAHNK_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('DLCJAPAHNK',DLCJAPAHNK_wrap_OnKeyDown);
function PPZWLBHZXY_wrap_Valid(event) {
return PPZWLBHZXY_Valid(event);
}
SPBOUILib.SetCheckboxClick('PPZWLBHZXY',PPZWLBHZXY_wrap_Valid);
function PPZWLBHZXY_wrap_OnFocus(event) {
return PPZWLBHZXY_OnFocus(event);
}
SPBOUILib.SetInputEnter('PPZWLBHZXY',PPZWLBHZXY_wrap_OnFocus);
function PPZWLBHZXY_wrap_Blur(event) {
return PPZWLBHZXY_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('PPZWLBHZXY',PPZWLBHZXY_wrap_Blur);
function SOFGJQQNFS_wrap_Valid(event) {
return SOFGJQQNFS_Valid(event);
}
SPBOUILib.SetComboChange('SOFGJQQNFS',SOFGJQQNFS_wrap_Valid);
function SOFGJQQNFS_wrap_OnFocus(event) {
return SOFGJQQNFS_OnFocus(event);
}
SPBOUILib.SetInputEnter('SOFGJQQNFS',SOFGJQQNFS_wrap_OnFocus);
function SOFGJQQNFS_wrap_Blur(event) {
return SOFGJQQNFS_OnBlur(event);
}
SPBOUILib.SetInputExit('SOFGJQQNFS',SOFGJQQNFS_wrap_Blur);
function GOFVHZECXL_wrap_Valid(event) {
return GOFVHZECXL_Valid(event);
}
SPBOUILib.SetCheckboxClick('GOFVHZECXL',GOFVHZECXL_wrap_Valid);
function GOFVHZECXL_wrap_OnFocus(event) {
return GOFVHZECXL_OnFocus(event);
}
SPBOUILib.SetInputEnter('GOFVHZECXL',GOFVHZECXL_wrap_OnFocus);
function GOFVHZECXL_wrap_Blur(event) {
return GOFVHZECXL_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GOFVHZECXL',GOFVHZECXL_wrap_Blur);
function NZZQBPTZYU_wrap_Valid(event) {
return NZZQBPTZYU_Valid(event);
}
SPBOUILib.SetComboChange('NZZQBPTZYU',NZZQBPTZYU_wrap_Valid);
function NZZQBPTZYU_wrap_OnFocus(event) {
return NZZQBPTZYU_OnFocus(event);
}
SPBOUILib.SetInputEnter('NZZQBPTZYU',NZZQBPTZYU_wrap_OnFocus);
function NZZQBPTZYU_wrap_Blur(event) {
return NZZQBPTZYU_OnBlur(event);
}
SPBOUILib.SetInputExit('NZZQBPTZYU',NZZQBPTZYU_wrap_Blur);
function MRDEGXONBG_wrap_Valid(event) {
return MRDEGXONBG_Valid(event);
}
SPBOUILib.SetCheckboxClick('MRDEGXONBG',MRDEGXONBG_wrap_Valid);
function MRDEGXONBG_wrap_OnFocus(event) {
return MRDEGXONBG_OnFocus(event);
}
SPBOUILib.SetInputEnter('MRDEGXONBG',MRDEGXONBG_wrap_OnFocus);
function MRDEGXONBG_wrap_Blur(event) {
return MRDEGXONBG_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('MRDEGXONBG',MRDEGXONBG_wrap_Blur);
function FMLKVYWRZP_wrap_Valid(event) {
return FMLKVYWRZP_Valid(event);
}
SPBOUILib.SetCheckboxClick('FMLKVYWRZP',FMLKVYWRZP_wrap_Valid);
function FMLKVYWRZP_wrap_OnFocus(event) {
return FMLKVYWRZP_OnFocus(event);
}
SPBOUILib.SetInputEnter('FMLKVYWRZP',FMLKVYWRZP_wrap_OnFocus);
function FMLKVYWRZP_wrap_Blur(event) {
return FMLKVYWRZP_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('FMLKVYWRZP',FMLKVYWRZP_wrap_Blur);
function RNGJQLKVFO_wrap_Valid(event) {
return RNGJQLKVFO_Valid(event);
}
SPBOUILib.SetInputExit('RNGJQLKVFO',RNGJQLKVFO_wrap_Valid);
function RNGJQLKVFO_wrap_OnFocus(event) {
return RNGJQLKVFO_OnFocus(event);
}
SPBOUILib.SetInputEnter('RNGJQLKVFO',RNGJQLKVFO_wrap_OnFocus);
function RNGJQLKVFO_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('RNGJQLKVFO',RNGJQLKVFO_wrap_OnKeyPress);
function RNGJQLKVFO_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('RNGJQLKVFO',RNGJQLKVFO_wrap_OnKeyDown);
function UFVJWZLULG_wrap_Valid(event) {
return UFVJWZLULG_Valid(event);
}
SPBOUILib.SetInputExit('UFVJWZLULG',UFVJWZLULG_wrap_Valid);
function UFVJWZLULG_wrap_OnFocus(event) {
return UFVJWZLULG_OnFocus(event);
}
SPBOUILib.SetInputEnter('UFVJWZLULG',UFVJWZLULG_wrap_OnFocus);
function UFVJWZLULG_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('UFVJWZLULG',UFVJWZLULG_wrap_OnKeyPress);
function UFVJWZLULG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UFVJWZLULG',UFVJWZLULG_wrap_OnKeyDown);
function CAUFCTBRNM_wrap_Valid(event) {
return CAUFCTBRNM_Valid(event);
}
SPBOUILib.SetCheckboxClick('CAUFCTBRNM',CAUFCTBRNM_wrap_Valid);
function CAUFCTBRNM_wrap_OnFocus(event) {
return CAUFCTBRNM_OnFocus(event);
}
SPBOUILib.SetInputEnter('CAUFCTBRNM',CAUFCTBRNM_wrap_OnFocus);
function CAUFCTBRNM_wrap_Blur(event) {
return CAUFCTBRNM_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CAUFCTBRNM',CAUFCTBRNM_wrap_Blur);
function UGCFKKQJNN_wrap_Valid(event) {
return UGCFKKQJNN_Valid(event);
}
SPBOUILib.SetCheckboxClick('UGCFKKQJNN',UGCFKKQJNN_wrap_Valid);
function UGCFKKQJNN_wrap_OnFocus(event) {
return UGCFKKQJNN_OnFocus(event);
}
SPBOUILib.SetInputEnter('UGCFKKQJNN',UGCFKKQJNN_wrap_OnFocus);
function UGCFKKQJNN_wrap_Blur(event) {
return UGCFKKQJNN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UGCFKKQJNN',UGCFKKQJNN_wrap_Blur);
function XNNAMCGSXP_wrap_Valid(event) {
return XNNAMCGSXP_Valid(event);
}
SPBOUILib.SetCheckboxClick('XNNAMCGSXP',XNNAMCGSXP_wrap_Valid);
function XNNAMCGSXP_wrap_OnFocus(event) {
return XNNAMCGSXP_OnFocus(event);
}
SPBOUILib.SetInputEnter('XNNAMCGSXP',XNNAMCGSXP_wrap_OnFocus);
function XNNAMCGSXP_wrap_Blur(event) {
return XNNAMCGSXP_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XNNAMCGSXP',XNNAMCGSXP_wrap_Blur);
function MYUZABATXZ_wrap_Valid(event) {
return MYUZABATXZ_Valid(event);
}
SPBOUILib.SetCheckboxClick('MYUZABATXZ',MYUZABATXZ_wrap_Valid);
function MYUZABATXZ_wrap_OnFocus(event) {
return MYUZABATXZ_OnFocus(event);
}
SPBOUILib.SetInputEnter('MYUZABATXZ',MYUZABATXZ_wrap_OnFocus);
function MYUZABATXZ_wrap_Blur(event) {
return MYUZABATXZ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('MYUZABATXZ',MYUZABATXZ_wrap_Blur);
function RSGIDFYOLS_wrap_Valid(event) {
return RSGIDFYOLS_Valid(event);
}
SPBOUILib.SetCheckboxClick('RSGIDFYOLS',RSGIDFYOLS_wrap_Valid);
function RSGIDFYOLS_wrap_OnFocus(event) {
return RSGIDFYOLS_OnFocus(event);
}
SPBOUILib.SetInputEnter('RSGIDFYOLS',RSGIDFYOLS_wrap_OnFocus);
function RSGIDFYOLS_wrap_Blur(event) {
return RSGIDFYOLS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RSGIDFYOLS',RSGIDFYOLS_wrap_Blur);
function YPMOMULORE_wrap_Valid(event) {
return YPMOMULORE_Valid(event);
}
SPBOUILib.SetCheckboxClick('YPMOMULORE',YPMOMULORE_wrap_Valid);
function YPMOMULORE_wrap_OnFocus(event) {
return YPMOMULORE_OnFocus(event);
}
SPBOUILib.SetInputEnter('YPMOMULORE',YPMOMULORE_wrap_OnFocus);
function YPMOMULORE_wrap_Blur(event) {
return YPMOMULORE_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('YPMOMULORE',YPMOMULORE_wrap_Blur);
function QEKBNPGOBS_wrap_Valid(event) {
return QEKBNPGOBS_Valid(event);
}
SPBOUILib.SetCheckboxClick('QEKBNPGOBS',QEKBNPGOBS_wrap_Valid);
function QEKBNPGOBS_wrap_OnFocus(event) {
return QEKBNPGOBS_OnFocus(event);
}
SPBOUILib.SetInputEnter('QEKBNPGOBS',QEKBNPGOBS_wrap_OnFocus);
function QEKBNPGOBS_wrap_Blur(event) {
return QEKBNPGOBS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('QEKBNPGOBS',QEKBNPGOBS_wrap_Blur);
function NFHGTEJQNE_wrap_Valid(event) {
return NFHGTEJQNE_Valid(event);
}
SPBOUILib.SetCheckboxClick('NFHGTEJQNE',NFHGTEJQNE_wrap_Valid);
function NFHGTEJQNE_wrap_OnFocus(event) {
return NFHGTEJQNE_OnFocus(event);
}
SPBOUILib.SetInputEnter('NFHGTEJQNE',NFHGTEJQNE_wrap_OnFocus);
function NFHGTEJQNE_wrap_Blur(event) {
return NFHGTEJQNE_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('NFHGTEJQNE',NFHGTEJQNE_wrap_Blur);
function GJLCDJIDAY_wrap_Valid(event) {
return GJLCDJIDAY_Valid(event);
}
SPBOUILib.SetCheckboxClick('GJLCDJIDAY',GJLCDJIDAY_wrap_Valid);
function GJLCDJIDAY_wrap_OnFocus(event) {
return GJLCDJIDAY_OnFocus(event);
}
SPBOUILib.SetInputEnter('GJLCDJIDAY',GJLCDJIDAY_wrap_OnFocus);
function GJLCDJIDAY_wrap_Blur(event) {
return GJLCDJIDAY_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('GJLCDJIDAY',GJLCDJIDAY_wrap_Blur);
function RBOWBOPVOA_wrap_Valid(event) {
return RBOWBOPVOA_Valid(event);
}
SPBOUILib.SetCheckboxClick('RBOWBOPVOA',RBOWBOPVOA_wrap_Valid);
function RBOWBOPVOA_wrap_OnFocus(event) {
return RBOWBOPVOA_OnFocus(event);
}
SPBOUILib.SetInputEnter('RBOWBOPVOA',RBOWBOPVOA_wrap_OnFocus);
function RBOWBOPVOA_wrap_Blur(event) {
return RBOWBOPVOA_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RBOWBOPVOA',RBOWBOPVOA_wrap_Blur);
function DHNVKQKTHK_wrap_Valid(event) {
return DHNVKQKTHK_Valid(event);
}
SPBOUILib.SetCheckboxClick('DHNVKQKTHK',DHNVKQKTHK_wrap_Valid);
function DHNVKQKTHK_wrap_OnFocus(event) {
return DHNVKQKTHK_OnFocus(event);
}
SPBOUILib.SetInputEnter('DHNVKQKTHK',DHNVKQKTHK_wrap_OnFocus);
function DHNVKQKTHK_wrap_Blur(event) {
return DHNVKQKTHK_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('DHNVKQKTHK',DHNVKQKTHK_wrap_Blur);
function CBJEEAJCGS_wrap_Valid(event) {
return CBJEEAJCGS_Valid(event);
}
SPBOUILib.SetCheckboxClick('CBJEEAJCGS',CBJEEAJCGS_wrap_Valid);
function CBJEEAJCGS_wrap_OnFocus(event) {
return CBJEEAJCGS_OnFocus(event);
}
SPBOUILib.SetInputEnter('CBJEEAJCGS',CBJEEAJCGS_wrap_OnFocus);
function CBJEEAJCGS_wrap_Blur(event) {
return CBJEEAJCGS_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('CBJEEAJCGS',CBJEEAJCGS_wrap_Blur);
function UXGJFWIPXB_wrap_Valid(event) {
return UXGJFWIPXB_Valid(event);
}
SPBOUILib.SetCheckboxClick('UXGJFWIPXB',UXGJFWIPXB_wrap_Valid);
function UXGJFWIPXB_wrap_OnFocus(event) {
return UXGJFWIPXB_OnFocus(event);
}
SPBOUILib.SetInputEnter('UXGJFWIPXB',UXGJFWIPXB_wrap_OnFocus);
function UXGJFWIPXB_wrap_Blur(event) {
return UXGJFWIPXB_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UXGJFWIPXB',UXGJFWIPXB_wrap_Blur);
function TKEHQQFQUC_wrap_Valid(event) {
return TKEHQQFQUC_Valid(event);
}
SPBOUILib.SetCheckboxClick('TKEHQQFQUC',TKEHQQFQUC_wrap_Valid);
function TKEHQQFQUC_wrap_OnFocus(event) {
return TKEHQQFQUC_OnFocus(event);
}
SPBOUILib.SetInputEnter('TKEHQQFQUC',TKEHQQFQUC_wrap_OnFocus);
function TKEHQQFQUC_wrap_Blur(event) {
return TKEHQQFQUC_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('TKEHQQFQUC',TKEHQQFQUC_wrap_Blur);
function XBPDZFAWFR_wrap_Valid(event) {
return XBPDZFAWFR_Valid(event);
}
SPBOUILib.SetCheckboxClick('XBPDZFAWFR',XBPDZFAWFR_wrap_Valid);
function XBPDZFAWFR_wrap_OnFocus(event) {
return XBPDZFAWFR_OnFocus(event);
}
SPBOUILib.SetInputEnter('XBPDZFAWFR',XBPDZFAWFR_wrap_OnFocus);
function XBPDZFAWFR_wrap_Blur(event) {
return XBPDZFAWFR_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('XBPDZFAWFR',XBPDZFAWFR_wrap_Blur);
function ZJMEDHEECW_wrap_Valid(event) {
return ZJMEDHEECW_Valid(event);
}
SPBOUILib.SetCheckboxClick('ZJMEDHEECW',ZJMEDHEECW_wrap_Valid);
function ZJMEDHEECW_wrap_OnFocus(event) {
return ZJMEDHEECW_OnFocus(event);
}
SPBOUILib.SetInputEnter('ZJMEDHEECW',ZJMEDHEECW_wrap_OnFocus);
function ZJMEDHEECW_wrap_Blur(event) {
return ZJMEDHEECW_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('ZJMEDHEECW',ZJMEDHEECW_wrap_Blur);
function TOJFZPDKWJ_wrap_Valid(event) {
return TOJFZPDKWJ_Valid(event);
}
SPBOUILib.SetCheckboxClick('TOJFZPDKWJ',TOJFZPDKWJ_wrap_Valid);
function TOJFZPDKWJ_wrap_OnFocus(event) {
return TOJFZPDKWJ_OnFocus(event);
}
SPBOUILib.SetInputEnter('TOJFZPDKWJ',TOJFZPDKWJ_wrap_OnFocus);
function TOJFZPDKWJ_wrap_Blur(event) {
return TOJFZPDKWJ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('TOJFZPDKWJ',TOJFZPDKWJ_wrap_Blur);
function UXAYRLQXMN_wrap_Valid(event) {
return UXAYRLQXMN_Valid(event);
}
SPBOUILib.SetCheckboxClick('UXAYRLQXMN',UXAYRLQXMN_wrap_Valid);
function UXAYRLQXMN_wrap_OnFocus(event) {
return UXAYRLQXMN_OnFocus(event);
}
SPBOUILib.SetInputEnter('UXAYRLQXMN',UXAYRLQXMN_wrap_OnFocus);
function UXAYRLQXMN_wrap_Blur(event) {
return UXAYRLQXMN_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('UXAYRLQXMN',UXAYRLQXMN_wrap_Blur);
function MXUUACEBJE_wrap_Valid(event) {
return MXUUACEBJE_Valid(event);
}
SPBOUILib.SetInputExit('MXUUACEBJE',MXUUACEBJE_wrap_Valid);
function MXUUACEBJE_wrap_OnFocus(event) {
return MXUUACEBJE_OnFocus(event);
}
SPBOUILib.SetInputEnter('MXUUACEBJE',MXUUACEBJE_wrap_OnFocus);
function MXUUACEBJE_wrap_OnKeyPress(event) {
return CheckNum(event);
}
SPBOUILib.SetInputKeyPress('MXUUACEBJE',MXUUACEBJE_wrap_OnKeyPress);
function MXUUACEBJE_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('MXUUACEBJE',MXUUACEBJE_wrap_OnKeyDown);
function LTMWIPFDRU_wrap_Valid(event) {
return LTMWIPFDRU_Valid(event);
}
SPBOUILib.SetRadioClick('LTMWIPFDRU',LTMWIPFDRU_wrap_Valid);
function RVLRRQTSCQ_wrap_Valid(event) {
return RVLRRQTSCQ_Valid(event);
}
SPBOUILib.SetCheckboxClick('RVLRRQTSCQ',RVLRRQTSCQ_wrap_Valid);
function RVLRRQTSCQ_wrap_OnFocus(event) {
return RVLRRQTSCQ_OnFocus(event);
}
SPBOUILib.SetInputEnter('RVLRRQTSCQ',RVLRRQTSCQ_wrap_OnFocus);
function RVLRRQTSCQ_wrap_Blur(event) {
return RVLRRQTSCQ_OnBlur(event);
}
SPBOUILib.SetCheckboxExit('RVLRRQTSCQ',RVLRRQTSCQ_wrap_Blur);
function UFVFYVMNVG_wrap_Valid(event) {
return UFVFYVMNVG_Valid(event);
}
SPBOUILib.SetInputExit('UFVFYVMNVG',UFVFYVMNVG_wrap_Valid);
function UFVFYVMNVG_wrap_OnFocus(event) {
return UFVFYVMNVG_OnFocus(event);
}
SPBOUILib.SetInputEnter('UFVFYVMNVG',UFVFYVMNVG_wrap_OnFocus);
function UFVFYVMNVG_wrap_OnKeyPress(event) {
return UFVFYVMNVG_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('UFVFYVMNVG',UFVFYVMNVG_wrap_OnKeyPress);
function UFVFYVMNVG_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UFVFYVMNVG',UFVFYVMNVG_wrap_OnKeyDown);
function UVKSMYBGBT_wrap_Valid(event) {
return UVKSMYBGBT_Valid(event);
}
SPBOUILib.SetInputExit('UVKSMYBGBT',UVKSMYBGBT_wrap_Valid);
function UVKSMYBGBT_wrap_OnFocus(event) {
return UVKSMYBGBT_OnFocus(event);
}
SPBOUILib.SetInputEnter('UVKSMYBGBT',UVKSMYBGBT_wrap_OnFocus);
function UVKSMYBGBT_wrap_OnKeyPress(event) {
return UVKSMYBGBT_CheckNumWithPict(event);
}
SPBOUILib.SetInputKeyPress('UVKSMYBGBT',UVKSMYBGBT_wrap_OnKeyPress);
function UVKSMYBGBT_wrap_OnKeyDown(event) {
return ManageKeys(event,Eq(window.m_cFunction,'query'),false,false,false);
}
SPBOUILib.SetInputKeyDown('UVKSMYBGBT',UVKSMYBGBT_wrap_OnKeyDown);
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
FocusFirstComponent.edit={"page_1":["PLTDFOMPMX"]};
FocusFirstComponent.query={"page_1":["RCAIOHOYCN"]};
FocusFirstComponent.otherwise={"page_1":["RCAIOHOYCN"]};
function Help() {
windowOpenForeground('../doc/armt_cgo_tbtipgio_usr.xml','','toolbar=0,menubar=0,directories=0,width=500,height=450,resizable=1');
}
function CalledBatchEnd() {
if ( ! (m_bCalculating)) {
DoUpdate(true);
}
}
function SetModified_ardt_cgo_tgtiporeg() {
SetModified();
}
function LoadChildrenInPage(page,lazy) {
if (Eq(page,'page_1')) {
if (ChildToLoad('EKQWOMODBX')) {
if (Eq(lazy,null) || LibJavascript.UserCanSee('EKQWOMODBX')) {
LoadContext.lc(1,'EKQWOMODBX');
}
} else {
LibJavascript.RefreshChildGrid('EKQWOMODBX');
}
}
}
GetLayerID.Layers.push({"id":"YORQOIOBQN","name":"Base"});
GetLayerID.Layers.push({"id":"GIMNJEFKNF","name":"box_GIMNJEFKNF"});
GetLayerID.Layers.push({"id":"MFCHEDYPZM","name":"box_MFCHEDYPZM"});
GetLayerID.Layers.push({"id":"OERGIOTKFK","name":"box_OERGIOTKFK"});
GetLayerID.Layers.push({"id":"PBPNWREDVO","name":"TipReg"});
function DeclareWVs() {
var a = arguments;
w_CODTPGIO=a[0];
w_DESTPGIO=a[1];
w_SOGTPGIO=a[2];
w_EDTTPGIO=a[3];
w_DEFTPGIO=a[4];
w_EDTSPGIO=a[5];
w_DEFSPGIO=a[6];
w_FLGPLGIO=a[7];
w_FLGMLGIO=a[8];
w_MAGPAGGIO=a[9];
w_MINPAGGIO=a[10];
w_FDC1OSGIO=a[11];
w_FDC2OSGIO=a[12];
w_FDC3OSGIO=a[13];
w_FDC4OSGIO=a[14];
w_FDC5OSGIO=a[15];
w_FDC6OSGIO=a[16];
w_FDC1SSGIO=a[17];
w_FDC2SSGIO=a[18];
w_FDC3SSGIO=a[19];
w_FDC4SSGIO=a[20];
w_FDC5SSGIO=a[21];
w_FDC6SSGIO=a[22];
w_FDC1ACGIO=a[23];
w_FDC2ACGIO=a[24];
w_FDC3ACGIO=a[25];
w_FDC4ACGIO=a[26];
w_FDC5ACGIO=a[27];
w_FDC6ACGIO=a[28];
w_NCOPAGGIO=a[29];
w_FLTIPGIO=a[30];
w_FLGATTIVO=a[31];
w_IMPMINGIO=a[32];
w_IMPMINTOT=a[33];
m_cWv_ardt_cgo_tgtiporeg=a[34];
if (Gt(a.length,35)) {
m_cErrorInChild='';
}
m_PrimaryKeys=['CODTPGIO'];
}
function i_PrimaryKey() {
return 'cgo_tbtipgio'+'\\'+CPLib.ToCPStr(w_CODTPGIO);
}
GetLinkPCKeys.set_o('ardt_cgo_tgtiporeg',false);
GetLinkPCKeys.o['ardt_cgo_tgtiporeg']['TRCODGIO']=function(t){
if (Ne(m_cFunction,'new')) {
return t(w_CODTPGIO,'C');
}
}
function EnableChild(name) {
var l_bRes = false;
return l_bRes;
}
function CheckZone(me) {
return true;
}
LoadContext.f('EKQWOMODBX',function(){return FrameRef('ardt_cgo_tgtiporeg')},1,'ardt_cgo_tgtiporeg',1,1)
GetSelectedChildPage.child={'ardt_cgo_tgtiporeg': function(){return FrameRef('ardt_cgo_tgtiporeg')}}
function GetSelectedPage(p_d) {
p_d.setValue('armt_cgo_tbtipgio',m_cSelectedPage);
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
_Obli('CODTPGIO',0,'RCAIOHOYCN',false,"1570205239")
_Obli('DESTPGIO',0,'PLTDFOMPMX',false,"285808099")
_Obli('SOGTPGIO',1,'DLCJAPAHNK',false,"11848875500")
_Obli('EDTTPGIO',0,'PPZWLBHZXY',false,"1264575246")
_Obli('DEFTPGIO',0,'SOFGJQQNFS',false,"805239427")
_Obli('EDTSPGIO',0,'GOFVHZECXL',false,"981524941")
_Obli('DEFSPGIO',0,'NZZQBPTZYU',false,"11061636098")
_Obli('FLGPLGIO',0,'MRDEGXONBG',false,"1255218623")
_Obli('FLGMLGIO',0,'FMLKVYWRZP',false,"11281970931")
_Obli('MAGPAGGIO',1,'RNGJQLKVFO',false,"106476627")
_Obli('MINPAGGIO',1,'UFVJWZLULG',false,"721888449")
_Obli('FDC1OSGIO',0,'CAUFCTBRNM',false,"11720460891")
_Obli('FDC2OSGIO',0,'UGCFKKQJNN',false,"1260570458")
_Obli('FDC3OSGIO',0,'XNNAMCGSXP',false,"11921223220")
_Obli('FDC4OSGIO',0,'MYUZABATXZ',false,"11921223220")
_Obli('FDC5OSGIO',0,'RSGIDFYOLS',false,"11921223220")
_Obli('FDC6OSGIO',0,'YPMOMULORE',false,"11921223220")
_Obli('FDC1SSGIO',0,'QEKBNPGOBS',false,"11720460891")
_Obli('FDC2SSGIO',0,'NFHGTEJQNE',false,"1260570458")
_Obli('FDC3SSGIO',0,'GJLCDJIDAY',false,"11921223220")
_Obli('FDC4SSGIO',0,'RBOWBOPVOA',false,"11921223220")
_Obli('FDC5SSGIO',0,'DHNVKQKTHK',false,"11921223220")
_Obli('FDC6SSGIO',0,'CBJEEAJCGS',false,"11921223220")
_Obli('FDC1ACGIO',0,'UXGJFWIPXB',false,"11720460891")
_Obli('FDC2ACGIO',0,'TKEHQQFQUC',false,"1260570458")
_Obli('FDC3ACGIO',0,'XBPDZFAWFR',false,"11921223220")
_Obli('FDC4ACGIO',0,'ZJMEDHEECW',false,"11921223220")
_Obli('FDC5ACGIO',0,'TOJFZPDKWJ',false,"11921223220")
_Obli('FDC6ACGIO',0,'UXAYRLQXMN',false,"11921223220")
_Obli('NCOPAGGIO',1,'MXUUACEBJE',false,"10615149648")
_Obli('FLTIPGIO',0,'LTMWIPFDRU',true,"10027039931")
_Obli('FLGATTIVO',0,'RVLRRQTSCQ',false,"776969894")
_Obli('IMPMINGIO',1,'UFVFYVMNVG',false,"11052594431")
_Obli('IMPMINTOT',1,'UVKSMYBGBT',false,"12075327151")
