function arrt_famextra_stp() {
var m_Caller
arrt_famextra_stp._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_famextra_stp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famextra_stp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famextra_stp._s.SetParameterString('m_bApplet','true');
arrt_famextra_stp._s.CallServlet('arrt_famextra_stp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famextra_stp._s.errmsg;
}
}
arrt_famextra_stp.CtxLoad_ = function(){return []}
