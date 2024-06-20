function arrt_inverti_causali() {
var m_Caller
arrt_inverti_causali._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_inverti_causali._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_inverti_causali._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_inverti_causali._s.SetParameterString('m_bApplet','true');
arrt_inverti_causali._s.CallServlet('arrt_inverti_causali');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_inverti_causali._s.errmsg;
}
}
arrt_inverti_causali.CtxLoad_ = function(){return []}
