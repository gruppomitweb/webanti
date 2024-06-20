function imp_newtabs() {
var w_tbcitta;
var w_tbstati;
var w_tbsetsin;
var w_tbcauana;
var w_inter2bo;
var w_tbvalute;
var w_tbtipreg;
var w_tbtipint;
var w_tbesitoage;
var w_tbrapp;
var w_tbstgru;
var w_tbramgru;
var w_tbtipdoc;
var w_tbtipleg;
var w_tbtipnat;
var w_tberrorisid;
var w_tberrsiddgn;
var w_tbricevutesid;
var w_tbcittna;
var w_tbstatna;
var w_tberrdge;
var w_tbprvreg;
var w_tbesielb;
var w_convgio;
var w_staticrs;
var w_tbcandistr;
var w_tbluonas;
var w_tbprovsv;
var w_rapogg;
var w_tbnatura;
var w_tbscopo;
var w_tbrisglob;
var pTipo;
var m_Caller
imp_newtabs._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tbcitta='';
w_tbstati='';
w_tbsetsin='';
w_tbcauana='';
w_inter2bo='';
w_tbvalute='';
w_tbtipreg='';
w_tbtipint='';
w_tbesitoage='';
w_tbrapp='';
w_tbstgru='';
w_tbramgru='';
w_tbtipdoc='';
w_tbtipleg='';
w_tbtipnat='';
w_tberrorisid='';
w_tberrsiddgn='';
w_tbricevutesid='';
w_tbcittna='';
w_tbstatna='';
w_tberrdge='';
w_tbprvreg='';
w_tbesielb='';
w_convgio='';
w_staticrs='';
w_tbcandistr='';
w_tbluonas='';
w_tbprovsv='';
w_rapogg='';
w_tbnatura='';
w_tbscopo='';
w_tbrisglob='';
pTipo='';
}
if(imp_newtabs._p.length>0)_rargs([[['w_tbcitta',imp_newtabs._p[0]],['w_tbstati',imp_newtabs._p[1]],['w_tbsetsin',imp_newtabs._p[2]],['w_tbcauana',imp_newtabs._p[3]],['w_inter2bo',imp_newtabs._p[4]],['w_tbvalute',imp_newtabs._p[5]],['w_tbtipreg',imp_newtabs._p[6]],['w_tbtipint',imp_newtabs._p[7]],['w_tbesitoage',imp_newtabs._p[8]],['w_tbrapp',imp_newtabs._p[9]],['w_tbstgru',imp_newtabs._p[10]],['w_tbramgru',imp_newtabs._p[11]],['w_tbtipdoc',imp_newtabs._p[12]],['w_tbtipleg',imp_newtabs._p[13]],['w_tbtipnat',imp_newtabs._p[14]],['w_tberrorisid',imp_newtabs._p[15]],['w_tberrsiddgn',imp_newtabs._p[16]],['w_tbricevutesid',imp_newtabs._p[17]],['w_tbcittna',imp_newtabs._p[18]],['w_tbstatna',imp_newtabs._p[19]],['w_tberrdge',imp_newtabs._p[20]],['w_tbprvreg',imp_newtabs._p[21]],['w_tbesielb',imp_newtabs._p[22]],['w_convgio',imp_newtabs._p[23]],['w_staticrs',imp_newtabs._p[24]],['w_tbcandistr',imp_newtabs._p[25]],['w_tbluonas',imp_newtabs._p[26]],['w_tbprovsv',imp_newtabs._p[27]],['w_rapogg',imp_newtabs._p[28]],['w_tbnatura',imp_newtabs._p[29]],['w_tbscopo',imp_newtabs._p[30]],['w_tbrisglob',imp_newtabs._p[31]],['pTipo',imp_newtabs._p[32]]]],{eval:function(e){eval(e)}})
imp_newtabs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
imp_newtabs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
imp_newtabs._s.SetParameterString('w_tbcitta',WtA(w_tbcitta,'C'));
imp_newtabs._s.SetParameterString('w_tbstati',WtA(w_tbstati,'C'));
imp_newtabs._s.SetParameterString('w_tbsetsin',WtA(w_tbsetsin,'C'));
imp_newtabs._s.SetParameterString('w_tbcauana',WtA(w_tbcauana,'C'));
imp_newtabs._s.SetParameterString('w_inter2bo',WtA(w_inter2bo,'C'));
imp_newtabs._s.SetParameterString('w_tbvalute',WtA(w_tbvalute,'C'));
imp_newtabs._s.SetParameterString('w_tbtipreg',WtA(w_tbtipreg,'C'));
imp_newtabs._s.SetParameterString('w_tbtipint',WtA(w_tbtipint,'C'));
imp_newtabs._s.SetParameterString('w_tbesitoage',WtA(w_tbesitoage,'C'));
imp_newtabs._s.SetParameterString('w_tbrapp',WtA(w_tbrapp,'C'));
imp_newtabs._s.SetParameterString('w_tbstgru',WtA(w_tbstgru,'C'));
imp_newtabs._s.SetParameterString('w_tbramgru',WtA(w_tbramgru,'C'));
imp_newtabs._s.SetParameterString('w_tbtipdoc',WtA(w_tbtipdoc,'C'));
imp_newtabs._s.SetParameterString('w_tbtipleg',WtA(w_tbtipleg,'C'));
imp_newtabs._s.SetParameterString('w_tbtipnat',WtA(w_tbtipnat,'C'));
imp_newtabs._s.SetParameterString('w_tberrorisid',WtA(w_tberrorisid,'C'));
imp_newtabs._s.SetParameterString('w_tberrsiddgn',WtA(w_tberrsiddgn,'C'));
imp_newtabs._s.SetParameterString('w_tbricevutesid',WtA(w_tbricevutesid,'C'));
imp_newtabs._s.SetParameterString('w_tbcittna',WtA(w_tbcittna,'C'));
imp_newtabs._s.SetParameterString('w_tbstatna',WtA(w_tbstatna,'C'));
imp_newtabs._s.SetParameterString('w_tberrdge',WtA(w_tberrdge,'C'));
imp_newtabs._s.SetParameterString('w_tbprvreg',WtA(w_tbprvreg,'C'));
imp_newtabs._s.SetParameterString('w_tbesielb',WtA(w_tbesielb,'C'));
imp_newtabs._s.SetParameterString('w_convgio',WtA(w_convgio,'C'));
imp_newtabs._s.SetParameterString('w_staticrs',WtA(w_staticrs,'C'));
imp_newtabs._s.SetParameterString('w_tbcandistr',WtA(w_tbcandistr,'C'));
imp_newtabs._s.SetParameterString('w_tbluonas',WtA(w_tbluonas,'C'));
imp_newtabs._s.SetParameterString('w_tbprovsv',WtA(w_tbprovsv,'C'));
imp_newtabs._s.SetParameterString('w_rapogg',WtA(w_rapogg,'C'));
imp_newtabs._s.SetParameterString('w_tbnatura',WtA(w_tbnatura,'C'));
imp_newtabs._s.SetParameterString('w_tbscopo',WtA(w_tbscopo,'C'));
imp_newtabs._s.SetParameterString('w_tbrisglob',WtA(w_tbrisglob,'C'));
imp_newtabs._s.SetParameterString('pTipo',WtA(pTipo,'C'));
imp_newtabs._s.SetParameterString('m_bApplet','true');
imp_newtabs._s.CallServlet('imp_newtabs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=imp_newtabs._s.errmsg;
}
}
imp_newtabs.CtxLoad_ = function(){return []}
