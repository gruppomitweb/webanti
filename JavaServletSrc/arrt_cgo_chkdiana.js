function arrt_cgo_chkdiana() {
var pTipo;
var m_Caller
arrt_cgo_chkdiana._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_cgo_chkdiana._p.length>0)_rargs([[['pTipo',arrt_cgo_chkdiana._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_chkdiana._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_chkdiana._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_chkdiana._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_cgo_chkdiana._s.SetParameterString('m_bApplet','true');
arrt_cgo_chkdiana._s.CallServlet('arrt_cgo_chkdiana');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_chkdiana._s.errmsg;
}
}
arrt_cgo_chkdiana.CtxLoad_ = function(){return []}
