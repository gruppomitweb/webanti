function arrt_wu_sblocco() {
var m_Caller
arrt_wu_sblocco._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_wu_sblocco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wu_sblocco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wu_sblocco._s.SetParameterString('m_bApplet','true');
arrt_wu_sblocco._s.CallServlet('arrt_wu_sblocco');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wu_sblocco._s.errmsg;
}
}
arrt_wu_sblocco.CtxLoad_ = function(){return []}
