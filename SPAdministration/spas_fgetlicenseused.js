function spas_fgetlicenseused() {
var m_Caller
spas_fgetlicenseused._p=_rargs(arguments,{eval:function(e){eval(e)}})
spas_fgetlicenseused._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_fgetlicenseused._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_fgetlicenseused._s.SetParameterString('m_bApplet','true');
spas_fgetlicenseused._s.CallServlet('spas_fgetlicenseused');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_fgetlicenseused._s.errmsg;
}
return spas_fgetlicenseused._s.GetDouble();
}
spas_fgetlicenseused.CtxLoad_ = function(){return []}
