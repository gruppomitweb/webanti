function arrt_cgo_operazioni_match() {
var m_Caller
arrt_cgo_operazioni_match._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_cgo_operazioni_match._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_operazioni_match._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_operazioni_match._s.SetParameterString('m_bApplet','true');
arrt_cgo_operazioni_match._s.CallServlet('arrt_cgo_operazioni_match');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_operazioni_match._s.errmsg;
}
}
arrt_cgo_operazioni_match.CtxLoad_ = function(){return []}
