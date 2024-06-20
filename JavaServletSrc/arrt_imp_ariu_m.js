function arrt_imp_ariu_m() {
var m_Caller
arrt_imp_ariu_m._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_imp_ariu_m._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_ariu_m._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_ariu_m._s.SetParameterString('m_bApplet','true');
arrt_imp_ariu_m._s.CallServlet('arrt_imp_ariu_m');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_ariu_m._s.errmsg;
}
}
arrt_imp_ariu_m.CtxLoad_ = function(){return []}
