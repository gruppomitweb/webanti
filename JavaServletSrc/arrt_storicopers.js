function arrt_storicopers() {
var m_Caller
arrt_storicopers._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_storicopers._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_storicopers._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_storicopers._s.SetParameterString('m_bApplet','true');
arrt_storicopers._s.CallServlet('arrt_storicopers');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_storicopers._s.errmsg;
}
}
arrt_storicopers.CtxLoad_ = function(){return []}
