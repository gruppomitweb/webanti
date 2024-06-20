function arfn_cgo_chkcap() {
var pCAP;
var pTipo;
var m_Caller
arfn_cgo_chkcap._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCAP='';
pTipo='';
}
if(arfn_cgo_chkcap._p.length>0)_rargs([[['pCAP',arfn_cgo_chkcap._p[0]],['pTipo',arfn_cgo_chkcap._p[1]]]],{eval:function(e){eval(e)}})
arfn_cgo_chkcap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_chkcap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_chkcap._s.SetParameterString('pCAP',WtA(pCAP,'C'));
arfn_cgo_chkcap._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_cgo_chkcap._s.SetParameterString('m_bApplet','true');
arfn_cgo_chkcap._s.CallServlet('arfn_cgo_chkcap');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_chkcap._s.errmsg;
}
return arfn_cgo_chkcap._s.GetBoolean();
}
arfn_cgo_chkcap.CtxLoad_ = function(){return []}
