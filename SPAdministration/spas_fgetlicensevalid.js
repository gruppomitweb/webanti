function spas_fgetlicensevalid() {
var m_Caller
spas_fgetlicensevalid._p=_rargs(arguments,{eval:function(e){eval(e)}})
spas_fgetlicensevalid._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_fgetlicensevalid._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_fgetlicensevalid._s.SetParameterString('m_bApplet','true');
spas_fgetlicensevalid._s.CallServlet('spas_fgetlicensevalid');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_fgetlicensevalid._s.errmsg;
}
return spas_fgetlicensevalid._s.GetBoolean();
}
spas_fgetlicensevalid.CtxLoad_ = function(){return []}
