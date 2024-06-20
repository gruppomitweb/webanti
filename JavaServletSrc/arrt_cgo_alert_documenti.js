function arrt_cgo_alert_documenti() {
var m_Caller
arrt_cgo_alert_documenti._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_cgo_alert_documenti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_alert_documenti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_alert_documenti._s.SetParameterString('m_bApplet','true');
arrt_cgo_alert_documenti._s.CallServlet('arrt_cgo_alert_documenti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_alert_documenti._s.errmsg;
}
}
arrt_cgo_alert_documenti.CtxLoad_ = function(){return []}
