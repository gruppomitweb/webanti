function arrt_diasble_g12() {
var m_Caller
arrt_diasble_g12._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_diasble_g12._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_diasble_g12._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_diasble_g12._s.SetParameterString('m_bApplet','true');
arrt_diasble_g12._s.CallServlet('arrt_diasble_g12');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_diasble_g12._s.errmsg;
}
}
arrt_diasble_g12.CtxLoad_ = function(){return []}
