function arrt_cgo_imp_dati_ext() {
var w_nomefile;
var m_Caller
arrt_cgo_imp_dati_ext._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
}
if(arrt_cgo_imp_dati_ext._p.length>0)_rargs([[['w_nomefile',arrt_cgo_imp_dati_ext._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_imp_dati_ext._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_imp_dati_ext._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_imp_dati_ext._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_cgo_imp_dati_ext._s.SetParameterString('m_bApplet','true');
arrt_cgo_imp_dati_ext._s.CallServlet('arrt_cgo_imp_dati_ext');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_imp_dati_ext._s.errmsg;
}
return arrt_cgo_imp_dati_ext._s.GetDouble();
}
arrt_cgo_imp_dati_ext.CtxLoad_ = function(){return []}
