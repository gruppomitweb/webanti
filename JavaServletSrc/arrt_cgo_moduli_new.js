function arrt_cgo_moduli_new() {
var w_SNAINUMOPE;
var m_Caller
arrt_cgo_moduli_new._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_SNAINUMOPE='';
}
if(arrt_cgo_moduli_new._p.length>0)_rargs([[['w_SNAINUMOPE',arrt_cgo_moduli_new._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_moduli_new._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_moduli_new._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_moduli_new._s.SetParameterString('w_SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
arrt_cgo_moduli_new._s.SetParameterString('m_bApplet','true');
arrt_cgo_moduli_new._s.CallServlet('arrt_cgo_moduli_new');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_moduli_new._s.errmsg;
}
return arrt_cgo_moduli_new._s.GetString();
}
arrt_cgo_moduli_new.CtxLoad_ = function(){return []}
