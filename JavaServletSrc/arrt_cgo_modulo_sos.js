function arrt_cgo_modulo_sos() {
var pSOS;
var m_Caller
arrt_cgo_modulo_sos._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSOS=0;
}
if(arrt_cgo_modulo_sos._p.length>0)_rargs([[['pSOS',arrt_cgo_modulo_sos._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_modulo_sos._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_modulo_sos._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_modulo_sos._s.SetParameterString('pSOS',WtA(pSOS,'N'));
arrt_cgo_modulo_sos._s.SetParameterString('m_bApplet','true');
arrt_cgo_modulo_sos._s.CallServlet('arrt_cgo_modulo_sos');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_modulo_sos._s.errmsg;
}
}
arrt_cgo_modulo_sos.CtxLoad_ = function(){return []}
