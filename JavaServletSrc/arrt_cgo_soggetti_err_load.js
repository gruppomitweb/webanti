function arrt_cgo_soggetti_err_load() {
var pPRGSOG;
var m_Caller
arrt_cgo_soggetti_err_load._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pPRGSOG='';
}
if(arrt_cgo_soggetti_err_load._p.length>0)_rargs([[['pPRGSOG',arrt_cgo_soggetti_err_load._p[0]]]],{eval:function(e){eval(e)}})
arrt_cgo_soggetti_err_load._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_soggetti_err_load._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_soggetti_err_load._s.SetParameterString('pPRGSOG',WtA(pPRGSOG,'C'));
arrt_cgo_soggetti_err_load._s.SetParameterString('m_bApplet','true');
arrt_cgo_soggetti_err_load._s.CallServlet('arrt_cgo_soggetti_err_load');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_soggetti_err_load._s.errmsg;
}
}
arrt_cgo_soggetti_err_load.CtxLoad_ = function(){return []}
