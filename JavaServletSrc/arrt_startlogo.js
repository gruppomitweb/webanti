function arrt_startlogo() {
var m_Caller
arrt_startlogo._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_startlogo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_startlogo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_startlogo._s.SetParameterString('m_bApplet','true');
arrt_startlogo._s.CallServlet('arrt_startlogo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_startlogo._s.errmsg;
}
}
arrt_startlogo.CtxLoad_ = function(){return []}
