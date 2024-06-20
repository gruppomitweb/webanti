function arfn_cgo_contarm() {
var pOpe;
var m_Caller
arfn_cgo_contarm._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOpe='';
}
if(arfn_cgo_contarm._p.length>0)_rargs([[['pOpe',arfn_cgo_contarm._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_contarm._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_contarm._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_contarm._s.SetParameterString('pOpe',WtA(pOpe,'C'));
arfn_cgo_contarm._s.SetParameterString('m_bApplet','true');
arfn_cgo_contarm._s.CallServlet('arfn_cgo_contarm');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_contarm._s.errmsg;
}
return arfn_cgo_contarm._s.GetDouble();
}
arfn_cgo_contarm.CtxLoad_ = function(){return []}
