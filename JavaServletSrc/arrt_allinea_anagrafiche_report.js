function arrt_allinea_anagrafiche_report() {
var m_Caller
arrt_allinea_anagrafiche_report._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_allinea_anagrafiche_report._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_anagrafiche_report._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_anagrafiche_report._s.SetParameterString('m_bApplet','true');
arrt_allinea_anagrafiche_report._s.CallServlet('arrt_allinea_anagrafiche_report');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_anagrafiche_report._s.errmsg;
}
}
arrt_allinea_anagrafiche_report.CtxLoad_ = function(){return []}
