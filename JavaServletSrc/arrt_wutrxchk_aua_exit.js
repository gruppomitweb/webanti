function arrt_wutrxchk_aua_exit() {
var pIDTrx;
var pTipo;
var w_TRXUTENTE;
var w_TRFLGINLAV;
var w_TRXTINILAV;
var w_TRXDINILAV;
var m_Caller
arrt_wutrxchk_aua_exit._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDTrx=0;
pTipo='';
}
if(arrt_wutrxchk_aua_exit._p.length>0)_rargs([[['pIDTrx',arrt_wutrxchk_aua_exit._p[0]],['pTipo',arrt_wutrxchk_aua_exit._p[1]]]],{eval:function(e){eval(e)}})
w_TRXUTENTE=m_Caller.GetNumber('w_TRXUTENTE','N',0,0);
w_TRFLGINLAV=m_Caller.GetString('w_TRFLGINLAV','C',0,0);
w_TRXTINILAV=m_Caller.GetDateTime('w_TRXTINILAV','T',0,0);
w_TRXDINILAV=m_Caller.GetDate('w_TRXDINILAV','D',0,0);
arrt_wutrxchk_aua_exit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wutrxchk_aua_exit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wutrxchk_aua_exit._s.SetCallerStringVar('w_TRXUTENTE',WtA(w_TRXUTENTE,'N'));
arrt_wutrxchk_aua_exit._s.SetCallerStringVar('w_TRFLGINLAV',WtA(w_TRFLGINLAV,'C'));
arrt_wutrxchk_aua_exit._s.SetCallerStringVar('w_TRXTINILAV',WtA(w_TRXTINILAV,'T'));
arrt_wutrxchk_aua_exit._s.SetCallerStringVar('w_TRXDINILAV',WtA(w_TRXDINILAV,'D'));
arrt_wutrxchk_aua_exit._s.SetParameterString('pIDTrx',WtA(pIDTrx,'N'));
arrt_wutrxchk_aua_exit._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_wutrxchk_aua_exit._s.SetParameterString('m_bApplet','true');
arrt_wutrxchk_aua_exit._s.CallServlet('arrt_wutrxchk_aua_exit');
m_Caller.SetNumber('w_TRXUTENTE','N',0,0,arrt_wutrxchk_aua_exit._s.GetCallerDoubleVar('w_TRXUTENTE'));
m_Caller.SetString('w_TRFLGINLAV','C',0,0,arrt_wutrxchk_aua_exit._s.GetCallerStringVar('w_TRFLGINLAV'));
m_Caller.SetDateTime('w_TRXTINILAV','T',0,0,DateTimeFromApplet(arrt_wutrxchk_aua_exit._s.GetCallerDateTimeVar('w_TRXTINILAV')));
m_Caller.SetDate('w_TRXDINILAV','D',0,0,DateFromApplet(arrt_wutrxchk_aua_exit._s.GetCallerDateVar('w_TRXDINILAV')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wutrxchk_aua_exit._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_wutrxchk_aua_exit.CtxLoad_ = function(){return []}
