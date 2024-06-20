function arrt_aggstatorap_gen() {
var m_Caller
arrt_aggstatorap_gen._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_aggstatorap_gen._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_aggstatorap_gen._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_aggstatorap_gen._s.SetParameterString('m_bApplet','true');
arrt_aggstatorap_gen._s.CallServlet('arrt_aggstatorap_gen');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_aggstatorap_gen._s.errmsg;
}
}
arrt_aggstatorap_gen.CtxLoad_ = function(){return []}
