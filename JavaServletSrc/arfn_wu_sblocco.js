function arfn_wu_sblocco() {
var m_Caller
arfn_wu_sblocco._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_wu_sblocco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_wu_sblocco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_wu_sblocco._s.SetParameterString('m_bApplet','true');
arfn_wu_sblocco._s.CallServlet('arfn_wu_sblocco');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_wu_sblocco._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_wu_sblocco._s.errmsg;
arfn_wu_sblocco._res=new CPMemoryCursor();
} else {
arfn_wu_sblocco._res=arfn_wu_sblocco._s.GetMemoryCursor();
}
return arfn_wu_sblocco._res;
}
arfn_wu_sblocco.CtxLoad_ = function(){return []}
