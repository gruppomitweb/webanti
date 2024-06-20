function arrt_cgo_operazioni_xls() {
var pTipo;
var w_agenzia;
var w_xagenzia;
var m_Caller
arrt_cgo_operazioni_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_cgo_operazioni_xls._p.length>0)_rargs([[['pTipo',arrt_cgo_operazioni_xls._p[0]]]],{eval:function(e){eval(e)}})
w_agenzia=m_Caller.GetString('w_agenzia','C',0,0);
w_xagenzia=m_Caller.GetString('w_xagenzia','C',0,0);
arrt_cgo_operazioni_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_operazioni_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_operazioni_xls._s.SetCallerStringVar('w_agenzia',WtA(w_agenzia,'C'));
arrt_cgo_operazioni_xls._s.SetCallerStringVar('w_xagenzia',WtA(w_xagenzia,'C'));
arrt_cgo_operazioni_xls._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_cgo_operazioni_xls._s.SetParameterString('m_bApplet','true');
arrt_cgo_operazioni_xls._s.CallServlet('arrt_cgo_operazioni_xls');
m_Caller.SetString('w_agenzia','C',0,0,arrt_cgo_operazioni_xls._s.GetCallerStringVar('w_agenzia'));
m_Caller.SetString('w_xagenzia','C',0,0,arrt_cgo_operazioni_xls._s.GetCallerStringVar('w_xagenzia'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_operazioni_xls._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cgo_operazioni_xls.CtxLoad_ = function(){return []}
