function arrt_cgo_moduli_multi_report() {
var pSNAINUMOPE;
var m_Caller
arrt_cgo_moduli_multi_report._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
}
if(arrt_cgo_moduli_multi_report._p.length>0)_rargs([[['pSNAINUMOPE',arrt_cgo_moduli_multi_report._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_moduli_multi_report._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_moduli_multi_report._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_moduli_multi_report._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arrt_cgo_moduli_multi_report._s.SetParameterString('m_bApplet','true');
arrt_cgo_moduli_multi_report._s.CallServlet('arrt_cgo_moduli_multi_report');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_moduli_multi_report._s.errmsg;
}
return arrt_cgo_moduli_multi_report._s.GetString();
}
arrt_cgo_moduli_multi_report.CtxLoad_ = function(){return []}
