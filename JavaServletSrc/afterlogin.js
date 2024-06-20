function afterlogin() {
var m_Caller
afterlogin._p=_rargs(arguments,{eval:function(e){eval(e)}})
afterlogin._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
afterlogin._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
afterlogin._s.SetParameterString('m_bApplet','true');
afterlogin._s.CallServlet('afterlogin');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=afterlogin._s.errmsg;
}
}
afterlogin.CtxLoad_ = function(){return []}
