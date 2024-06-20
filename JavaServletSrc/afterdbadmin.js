function afterdbadmin() {
var m_Caller
afterdbadmin._p=_rargs(arguments,{eval:function(e){eval(e)}})
afterdbadmin._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
afterdbadmin._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
afterdbadmin._s.SetParameterString('m_bApplet','true');
afterdbadmin._s.CallServlet('afterdbadmin');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=afterdbadmin._s.errmsg;
}
}
afterdbadmin.CtxLoad_ = function(){return []}
