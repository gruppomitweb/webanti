function arrt_imp_dati_cgo_sched_tabs_multitry() {
var m_Caller
arrt_imp_dati_cgo_sched_tabs_multitry._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_imp_dati_cgo_sched_tabs_multitry._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_cgo_sched_tabs_multitry._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_cgo_sched_tabs_multitry._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_cgo_sched_tabs_multitry._s.CallServlet('arrt_imp_dati_cgo_sched_tabs_multitry');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_cgo_sched_tabs_multitry._s.errmsg;
}
}
arrt_imp_dati_cgo_sched_tabs_multitry.CtxLoad_ = function(){return []}
