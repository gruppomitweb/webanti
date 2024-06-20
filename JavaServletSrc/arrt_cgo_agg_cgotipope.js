function arrt_cgo_agg_cgotipope() {
var pCodGio;
var pTipGio;
var m_Caller
arrt_cgo_agg_cgotipope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodGio='';
pTipGio='';
}
if(arrt_cgo_agg_cgotipope._p.length>0)_rargs([[['pCodGio',arrt_cgo_agg_cgotipope._p[0]],['pTipGio',arrt_cgo_agg_cgotipope._p[1]]]],{eval:function(e){eval(e)}})
arrt_cgo_agg_cgotipope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_agg_cgotipope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_agg_cgotipope._s.SetParameterString('pCodGio',WtA(pCodGio,'C'));
arrt_cgo_agg_cgotipope._s.SetParameterString('pTipGio',WtA(pTipGio,'C'));
arrt_cgo_agg_cgotipope._s.SetParameterString('m_bApplet','true');
arrt_cgo_agg_cgotipope._s.CallServlet('arrt_cgo_agg_cgotipope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_agg_cgotipope._s.errmsg;
}
}
arrt_cgo_agg_cgotipope.CtxLoad_ = function(){return []}
