function arrt_setsblocco() {
var w_PWDSER;
var m_Caller
arrt_setsblocco._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_PWDSER=m_Caller.GetString('w_PWDSER','C',0,0);
arrt_setsblocco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_setsblocco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_setsblocco._s.SetCallerStringVar('w_PWDSER',WtA(w_PWDSER,'C'));
arrt_setsblocco._s.SetParameterString('m_bApplet','true');
arrt_setsblocco._s.CallServlet('arrt_setsblocco');
m_Caller.SetString('w_PWDSER','C',0,0,arrt_setsblocco._s.GetCallerStringVar('w_PWDSER'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_setsblocco._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_setsblocco.CtxLoad_ = function(){return []}
