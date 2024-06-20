function spas_fgetlicense() {
var m_Caller
spas_fgetlicense._p=_rargs(arguments,{eval:function(e){eval(e)}})
spas_fgetlicense._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_fgetlicense._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_fgetlicense._s.SetParameterString('m_bApplet','true');
spas_fgetlicense._s.CallServlet('spas_fgetlicense');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_fgetlicense._s.errmsg;
}
return null;
}
spas_fgetlicense.CtxLoad_ = function(){return []}
