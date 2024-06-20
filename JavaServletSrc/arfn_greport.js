function arfn_greport() {
var m_Caller
arfn_greport._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_greport._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_greport._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_greport._s.SetParameterString('m_bApplet','true');
arfn_greport._s.CallServlet('arfn_greport');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_greport._s.errmsg;
}
return arfn_greport._s.GetDouble();
}
arfn_greport.CtxLoad_ = function(){return []}
