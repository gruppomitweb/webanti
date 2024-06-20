function arfn_creamc() {
var m_Caller
arfn_creamc._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_creamc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_creamc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_creamc._s.SetParameterString('m_bApplet','true');
arfn_creamc._s.CallServlet('arfn_creamc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_creamc._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_creamc._s.errmsg;
arfn_creamc._res=new CPMemoryCursor();
} else {
arfn_creamc._res=arfn_creamc._s.GetMemoryCursor();
}
return arfn_creamc._res;
}
arfn_creamc.CtxLoad_ = function(){return []}
