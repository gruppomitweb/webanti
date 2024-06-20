function arrt_login() {
var w_CodUte;
var w_PwdUte;
var w_ErrLogin;
var m_Caller
arrt_login._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CodUte=m_Caller.GetString('w_CodUte','C',0,0);
w_PwdUte=m_Caller.GetString('w_PwdUte','C',0,0);
w_ErrLogin=m_Caller.GetString('w_ErrLogin','C',0,0);
arrt_login._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_login._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_login._s.SetCallerStringVar('w_CodUte',WtA(w_CodUte,'C'));
arrt_login._s.SetCallerStringVar('w_PwdUte',WtA(w_PwdUte,'C'));
arrt_login._s.SetCallerStringVar('w_ErrLogin',WtA(w_ErrLogin,'C'));
arrt_login._s.SetParameterString('m_bApplet','true');
arrt_login._s.CallServlet('arrt_login');
m_Caller.SetString('w_CodUte','C',0,0,arrt_login._s.GetCallerStringVar('w_CodUte'));
m_Caller.SetString('w_PwdUte','C',0,0,arrt_login._s.GetCallerStringVar('w_PwdUte'));
m_Caller.SetString('w_ErrLogin','C',0,0,arrt_login._s.GetCallerStringVar('w_ErrLogin'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_login._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_login.CtxLoad_ = function(){return []}
