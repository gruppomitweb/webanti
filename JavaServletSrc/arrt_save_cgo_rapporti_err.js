function arrt_save_cgo_rapporti_err() {
var pPRGRAP;
var m_Caller
arrt_save_cgo_rapporti_err._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pPRGRAP='';
}
if(arrt_save_cgo_rapporti_err._p.length>0)_rargs([[['pPRGRAP',arrt_save_cgo_rapporti_err._p[0]]]],{eval:function(e){eval(e)}})
arrt_save_cgo_rapporti_err._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_save_cgo_rapporti_err._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_save_cgo_rapporti_err._s.SetParameterString('pPRGRAP',WtA(pPRGRAP,'C'));
arrt_save_cgo_rapporti_err._s.SetParameterString('m_bApplet','true');
arrt_save_cgo_rapporti_err._s.CallServlet('arrt_save_cgo_rapporti_err');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_save_cgo_rapporti_err._s.errmsg;
}
}
arrt_save_cgo_rapporti_err.CtxLoad_ = function(){return []}
