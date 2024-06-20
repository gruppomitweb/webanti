function arfn_cgo_delreg_multi() {
var pSNAINUMOPE;
var m_Caller
arfn_cgo_delreg_multi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
}
if(arfn_cgo_delreg_multi._p.length>0)_rargs([[['pSNAINUMOPE',arfn_cgo_delreg_multi._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_delreg_multi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_delreg_multi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_delreg_multi._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arfn_cgo_delreg_multi._s.SetParameterString('m_bApplet','true');
arfn_cgo_delreg_multi._s.CallServlet('arfn_cgo_delreg_multi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_delreg_multi._s.errmsg;
}
return arfn_cgo_delreg_multi._s.GetString();
}
arfn_cgo_delreg_multi.CtxLoad_ = function(){return []}
