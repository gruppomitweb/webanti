function arrt_inssecurity() {
var m_Caller
arrt_inssecurity._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_inssecurity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_inssecurity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_inssecurity._s.SetParameterString('m_bApplet','true');
arrt_inssecurity._s.CallServlet('arrt_inssecurity');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_inssecurity._s.errmsg;
}
}
arrt_inssecurity.CtxLoad_ = function(){return []}
