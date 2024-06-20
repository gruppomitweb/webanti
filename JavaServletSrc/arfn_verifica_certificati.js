function arfn_verifica_certificati() {
var m_Caller
arfn_verifica_certificati._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_verifica_certificati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_verifica_certificati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_verifica_certificati._s.SetParameterString('m_bApplet','true');
arfn_verifica_certificati._s.CallServlet('arfn_verifica_certificati');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_verifica_certificati._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_verifica_certificati._s.errmsg;
arfn_verifica_certificati._res=new CPMemoryCursor();
} else {
arfn_verifica_certificati._res=arfn_verifica_certificati._s.GetMemoryCursor();
}
return arfn_verifica_certificati._res;
}
arfn_verifica_certificati.CtxLoad_ = function(){return []}
