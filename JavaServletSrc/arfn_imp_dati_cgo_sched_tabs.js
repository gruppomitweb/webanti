function arfn_imp_dati_cgo_sched_tabs() {
var m_Caller
arfn_imp_dati_cgo_sched_tabs._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_imp_dati_cgo_sched_tabs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_imp_dati_cgo_sched_tabs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_imp_dati_cgo_sched_tabs._s.SetParameterString('m_bApplet','true');
arfn_imp_dati_cgo_sched_tabs._s.CallServlet('arfn_imp_dati_cgo_sched_tabs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_imp_dati_cgo_sched_tabs._s.errmsg;
}
return arfn_imp_dati_cgo_sched_tabs._s.GetString();
}
arfn_imp_dati_cgo_sched_tabs.CtxLoad_ = function(){return []}
