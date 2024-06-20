function arfn_scarti_import() {
var m_Caller
arfn_scarti_import._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_scarti_import._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_scarti_import._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_scarti_import._s.SetParameterString('m_bApplet','true');
arfn_scarti_import._s.CallServlet('arfn_scarti_import');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_scarti_import._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_scarti_import._s.errmsg;
arfn_scarti_import._res=new CPMemoryCursor();
} else {
arfn_scarti_import._res=arfn_scarti_import._s.GetMemoryCursor();
}
return arfn_scarti_import._res;
}
arfn_scarti_import.CtxLoad_ = function(){return []}
