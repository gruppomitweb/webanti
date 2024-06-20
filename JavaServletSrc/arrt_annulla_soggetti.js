function arrt_annulla_soggetti() {
var m_Caller
arrt_annulla_soggetti._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_annulla_soggetti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_annulla_soggetti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_annulla_soggetti._s.SetParameterString('m_bApplet','true');
arrt_annulla_soggetti._s.CallServlet('arrt_annulla_soggetti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_annulla_soggetti._s.errmsg;
}
}
arrt_annulla_soggetti.CtxLoad_ = function(){return []}
