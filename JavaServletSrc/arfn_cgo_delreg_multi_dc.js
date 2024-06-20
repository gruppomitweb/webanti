function arfn_cgo_delreg_multi_dc() {
var pSNAINUMOPE;
var m_Caller
arfn_cgo_delreg_multi_dc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
}
if(arfn_cgo_delreg_multi_dc._p.length>0)_rargs([[['pSNAINUMOPE',arfn_cgo_delreg_multi_dc._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_delreg_multi_dc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_delreg_multi_dc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_delreg_multi_dc._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arfn_cgo_delreg_multi_dc._s.SetParameterString('m_bApplet','true');
arfn_cgo_delreg_multi_dc._s.CallServlet('arfn_cgo_delreg_multi_dc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_delreg_multi_dc._s.errmsg;
}
return arfn_cgo_delreg_multi_dc._s.GetString();
}
arfn_cgo_delreg_multi_dc.CtxLoad_ = function(){return []}
