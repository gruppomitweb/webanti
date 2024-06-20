function arrt_cgo_alert_operazioni() {
var m_Caller
arrt_cgo_alert_operazioni._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_cgo_alert_operazioni._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_alert_operazioni._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_alert_operazioni._s.SetParameterString('m_bApplet','true');
arrt_cgo_alert_operazioni._s.CallServlet('arrt_cgo_alert_operazioni');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_alert_operazioni._s.errmsg;
}
}
arrt_cgo_alert_operazioni.CtxLoad_ = function(){return []}
