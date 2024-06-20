function arfn_cgo_sblocco() {
var pCodice;
var m_Caller
arfn_cgo_sblocco._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice='';
}
if(arfn_cgo_sblocco._p.length>0)_rargs([[['pCodice',arfn_cgo_sblocco._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_sblocco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_sblocco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_sblocco._s.SetParameterString('pCodice',WtA(pCodice,'C'));
arfn_cgo_sblocco._s.SetParameterString('m_bApplet','true');
arfn_cgo_sblocco._s.CallServlet('arfn_cgo_sblocco');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_sblocco._s.errmsg;
}
return arfn_cgo_sblocco._s.GetString();
}
arfn_cgo_sblocco.CtxLoad_ = function(){return []}
