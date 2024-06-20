function arfn_read_p12() {
var m_Caller
arfn_read_p12._p=_rargs(arguments,{eval:function(e){eval(e)}})
arfn_read_p12._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_read_p12._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_read_p12._s.SetParameterString('m_bApplet','true');
arfn_read_p12._s.CallServlet('arfn_read_p12');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_read_p12._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_read_p12._s.errmsg;
arfn_read_p12._res=new CPMemoryCursor();
} else {
arfn_read_p12._res=arfn_read_p12._s.GetMemoryCursor();
}
return arfn_read_p12._res;
}
arfn_read_p12.CtxLoad_ = function(){return []}
