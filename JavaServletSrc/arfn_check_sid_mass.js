function arfn_check_sid_mass() {
var m_Caller
arfn_check_sid_mass._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_check_sid_mass._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_check_sid_mass._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_check_sid_mass._s.SetParameterString('m_bApplet','true');
arfn_check_sid_mass._s.CallServlet('arfn_check_sid_mass');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_check_sid_mass._s.errmsg;
}
return arfn_check_sid_mass._s.GetString();
}
arfn_check_sid_mass.CtxLoad_ = function(){return []}
