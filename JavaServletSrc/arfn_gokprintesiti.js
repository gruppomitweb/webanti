function arfn_gokprintesiti() {
var m_Caller
arfn_gokprintesiti._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_gokprintesiti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_gokprintesiti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_gokprintesiti._s.SetParameterString('m_bApplet','true');
arfn_gokprintesiti._s.CallServlet('arfn_gokprintesiti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_gokprintesiti._s.errmsg;
}
return arfn_gokprintesiti._s.GetDouble();
}
arfn_gokprintesiti.CtxLoad_ = function(){return []}
