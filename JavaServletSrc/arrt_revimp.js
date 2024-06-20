function arrt_revimp() {
var m_Caller
arrt_revimp._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_revimp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_revimp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_revimp._s.SetParameterString('m_bApplet','true');
arrt_revimp._s.CallServlet('arrt_revimp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_revimp._s.errmsg;
}
}
arrt_revimp.CtxLoad_ = function(){return []}
