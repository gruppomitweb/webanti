function arrt_cgo_moduli_storico() {
var w_SNAINUMOPE;
var m_Caller
arrt_cgo_moduli_storico._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_SNAINUMOPE='';
}
if(arrt_cgo_moduli_storico._p.length>0)_rargs([[['w_SNAINUMOPE',arrt_cgo_moduli_storico._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_moduli_storico._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_moduli_storico._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_moduli_storico._s.SetParameterString('w_SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
arrt_cgo_moduli_storico._s.SetParameterString('m_bApplet','true');
arrt_cgo_moduli_storico._s.CallServlet('arrt_cgo_moduli_storico');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_moduli_storico._s.errmsg;
}
return arrt_cgo_moduli_storico._s.GetString();
}
arrt_cgo_moduli_storico.CtxLoad_ = function(){return []}
