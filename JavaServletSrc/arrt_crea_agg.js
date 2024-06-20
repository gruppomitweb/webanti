function arrt_crea_agg() {
var pCONNES;
var m_Caller
arrt_crea_agg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCONNES='';
}
if(arrt_crea_agg._p.length>0)_rargs([[['pCONNES',arrt_crea_agg._p[0]]]],{eval:function(e){eval(e)}})
arrt_crea_agg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_agg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_agg._s.SetParameterString('pCONNES',WtA(pCONNES,'C'));
arrt_crea_agg._s.SetParameterString('m_bApplet','true');
arrt_crea_agg._s.CallServlet('arrt_crea_agg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_agg._s.errmsg;
}
}
arrt_crea_agg.CtxLoad_ = function(){return []}
