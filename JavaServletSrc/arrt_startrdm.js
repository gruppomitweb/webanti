function arrt_startrdm() {
var m_Caller
arrt_startrdm._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_startrdm._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_startrdm._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_startrdm._s.SetParameterString('m_bApplet','true');
arrt_startrdm._s.CallServlet('arrt_startrdm');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_startrdm._s.errmsg;
}
}
arrt_startrdm.CtxLoad_ = function(){return []}
