function SPAdministration_afterlogin() {
var m_Caller
SPAdministration_afterlogin._p=_rargs(arguments,{eval:function(e){eval(e)}})
SPAdministration_afterlogin._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
SPAdministration_afterlogin._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
SPAdministration_afterlogin._s.SetParameterString('m_bApplet','true');
SPAdministration_afterlogin._s.CallServlet('SPAdministration_afterlogin');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=SPAdministration_afterlogin._s.errmsg;
}
}
SPAdministration_afterlogin.CtxLoad_ = function(){return []}
