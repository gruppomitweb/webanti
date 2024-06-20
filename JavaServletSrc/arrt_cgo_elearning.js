function arrt_cgo_elearning() {
var m_Caller
arrt_cgo_elearning._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_cgo_elearning._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_elearning._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_elearning._s.SetParameterString('m_bApplet','true');
arrt_cgo_elearning._s.CallServlet('arrt_cgo_elearning');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_elearning._s.errmsg;
}
return arrt_cgo_elearning._s.GetString();
}
arrt_cgo_elearning.CtxLoad_ = function(){return []}
