function arrt_save_cgo_telematico_err() {
var pSNAINUMOPE;
var m_Caller
arrt_save_cgo_telematico_err._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
}
if(arrt_save_cgo_telematico_err._p.length>0)_rargs([[['pSNAINUMOPE',arrt_save_cgo_telematico_err._p[0]]]],{eval:function(e){eval(e)}})
arrt_save_cgo_telematico_err._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_save_cgo_telematico_err._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_save_cgo_telematico_err._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arrt_save_cgo_telematico_err._s.SetParameterString('m_bApplet','true');
arrt_save_cgo_telematico_err._s.CallServlet('arrt_save_cgo_telematico_err');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_save_cgo_telematico_err._s.errmsg;
}
}
arrt_save_cgo_telematico_err.CtxLoad_ = function(){return []}
