function arrt_esitixls() {
var m_Caller
arrt_esitixls._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_esitixls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_esitixls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_esitixls._s.SetParameterString('m_bApplet','true');
arrt_esitixls._s.CallServlet('arrt_esitixls');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_esitixls._s.errmsg;
}
}
arrt_esitixls.CtxLoad_ = function(){return []}
