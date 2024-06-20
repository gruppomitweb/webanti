function arrt_trasfope_scheduler() {
var m_Caller
arrt_trasfope_scheduler._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_trasfope_scheduler._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfope_scheduler._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfope_scheduler._s.SetParameterString('m_bApplet','true');
arrt_trasfope_scheduler._s.CallServlet('arrt_trasfope_scheduler');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfope_scheduler._s.errmsg;
}
}
arrt_trasfope_scheduler.CtxLoad_ = function(){return []}
