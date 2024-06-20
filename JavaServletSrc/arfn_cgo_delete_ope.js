function arfn_cgo_delete_ope() {
var pOpe;
var pTipo;
var pIDDOC;
var pCodDip;
var m_Caller
arfn_cgo_delete_ope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOpe='';
pTipo='';
pIDDOC='';
pCodDip='';
}
if(arfn_cgo_delete_ope._p.length>0)_rargs([[['pOpe',arfn_cgo_delete_ope._p[0]],['pTipo',arfn_cgo_delete_ope._p[1]],['pIDDOC',arfn_cgo_delete_ope._p[2]],['pCodDip',arfn_cgo_delete_ope._p[3]]]],{eval:function(e){eval(e)}})
arfn_cgo_delete_ope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_delete_ope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_delete_ope._s.SetParameterString('pOpe',WtA(pOpe,'C'));
arfn_cgo_delete_ope._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_cgo_delete_ope._s.SetParameterString('pIDDOC',WtA(pIDDOC,'C'));
arfn_cgo_delete_ope._s.SetParameterString('pCodDip',WtA(pCodDip,'C'));
arfn_cgo_delete_ope._s.SetParameterString('m_bApplet','true');
arfn_cgo_delete_ope._s.CallServlet('arfn_cgo_delete_ope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_delete_ope._s.errmsg;
}
return arfn_cgo_delete_ope._s.GetString();
}
arfn_cgo_delete_ope.CtxLoad_ = function(){return []}
