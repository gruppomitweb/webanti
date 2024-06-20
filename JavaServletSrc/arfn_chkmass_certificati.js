function arfn_chkmass_certificati() {
var m_Caller
arfn_chkmass_certificati._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_chkmass_certificati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkmass_certificati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkmass_certificati._s.SetParameterString('m_bApplet','true');
arfn_chkmass_certificati._s.CallServlet('arfn_chkmass_certificati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkmass_certificati._s.errmsg;
}
return arfn_chkmass_certificati._s.GetString();
}
arfn_chkmass_certificati.CtxLoad_ = function(){return []}
