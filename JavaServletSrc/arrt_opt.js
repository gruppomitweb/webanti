function arrt_opt() {
var m_Caller
arrt_opt._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_opt._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_opt._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_opt._s.SetParameterString('m_bApplet','true');
arrt_opt._s.CallServlet('arrt_opt');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_opt._s.errmsg;
}
return arrt_opt._s.GetString();
}
arrt_opt.CtxLoad_ = function(){return []}
