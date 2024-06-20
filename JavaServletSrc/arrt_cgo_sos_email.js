function arrt_cgo_sos_email() {
var pCodice;
var m_Caller
arrt_cgo_sos_email._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice=0;
}
if(arrt_cgo_sos_email._p.length>0)_rargs([[['pCodice',arrt_cgo_sos_email._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_sos_email._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_sos_email._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_sos_email._s.SetParameterString('pCodice',WtA(pCodice,'N'));
arrt_cgo_sos_email._s.SetParameterString('m_bApplet','true');
arrt_cgo_sos_email._s.CallServlet('arrt_cgo_sos_email');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_sos_email._s.errmsg;
}
}
arrt_cgo_sos_email.CtxLoad_ = function(){return []}
