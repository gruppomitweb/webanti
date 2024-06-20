function arrt_esito_dettagliato_report() {
var m_Caller
arrt_esito_dettagliato_report._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_esito_dettagliato_report._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_esito_dettagliato_report._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_esito_dettagliato_report._s.SetParameterString('m_bApplet','true');
arrt_esito_dettagliato_report._s.CallServlet('arrt_esito_dettagliato_report');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_esito_dettagliato_report._s.errmsg;
}
}
arrt_esito_dettagliato_report.CtxLoad_ = function(){return []}
