function spas_flicensepurchased() {
var m_Caller
spas_flicensepurchased._p=_rargs(arguments,{eval:function(e){eval(e)}})
spas_flicensepurchased._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_flicensepurchased._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_flicensepurchased._s.SetParameterString('m_bApplet','true');
spas_flicensepurchased._s.CallServlet('spas_flicensepurchased');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_flicensepurchased._s.errmsg;
}
return spas_flicensepurchased._s.GetDouble();
}
spas_flicensepurchased.CtxLoad_ = function(){return []}
