function arfn_cgo_delreg() {
var pSNAINUMOPE;
var m_Caller
arfn_cgo_delreg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
}
if(arfn_cgo_delreg._p.length>0)_rargs([[['pSNAINUMOPE',arfn_cgo_delreg._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_delreg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_delreg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_delreg._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arfn_cgo_delreg._s.SetParameterString('m_bApplet','true');
arfn_cgo_delreg._s.CallServlet('arfn_cgo_delreg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_delreg._s.errmsg;
}
return arfn_cgo_delreg._s.GetString();
}
arfn_cgo_delreg.CtxLoad_ = function(){return []}
