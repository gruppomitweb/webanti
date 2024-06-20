function arrt_cgo_criticita_xls() {
var pTipo;
var m_Caller
arrt_cgo_criticita_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_cgo_criticita_xls._p.length>0)_rargs([[['pTipo',arrt_cgo_criticita_xls._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_criticita_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_criticita_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_criticita_xls._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_cgo_criticita_xls._s.SetParameterString('m_bApplet','true');
arrt_cgo_criticita_xls._s.CallServlet('arrt_cgo_criticita_xls');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_criticita_xls._s.errmsg;
}
}
arrt_cgo_criticita_xls.CtxLoad_ = function(){return []}
