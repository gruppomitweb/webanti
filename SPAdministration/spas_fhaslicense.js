function spas_fhaslicense() {
var m_Caller
spas_fhaslicense._p=_rargs(arguments,{eval:function(e){eval(e)}})
spas_fhaslicense._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_fhaslicense._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_fhaslicense._s.SetParameterString('m_bApplet','true');
spas_fhaslicense._s.CallServlet('spas_fhaslicense');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_fhaslicense._s.errmsg;
}
return spas_fhaslicense._s.GetBoolean();
}
spas_fhaslicense.CtxLoad_ = function(){return []}
