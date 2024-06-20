function arfn_release() {
var m_Caller
arfn_release._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_release._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_release._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_release._s.SetParameterString('m_bApplet','true');
arfn_release._s.CallServlet('arfn_release');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_release._s.errmsg;
}
return arfn_release._s.GetString();
}
arfn_release.CtxLoad_ = function(){return []}
