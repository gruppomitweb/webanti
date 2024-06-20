function arrt_cgo_save_multi_dl_dc() {
var w_SNAINUMOPE;
var _gAzienda;
var m_Caller
arrt_cgo_save_multi_dl_dc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_SNAINUMOPE='';
_gAzienda='';
}
if(arrt_cgo_save_multi_dl_dc._p.length>0)_rargs([[['w_SNAINUMOPE',arrt_cgo_save_multi_dl_dc._p[0]],['_gAzienda',arrt_cgo_save_multi_dl_dc._p[1]]]],{eval:function(e){eval(e)}})
arrt_cgo_save_multi_dl_dc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_save_multi_dl_dc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_save_multi_dl_dc._s.SetParameterString('w_SNAINUMOPE',WtA(w_SNAINUMOPE,'C'));
arrt_cgo_save_multi_dl_dc._s.SetParameterString('_gAzienda',WtA(_gAzienda,'C'));
arrt_cgo_save_multi_dl_dc._s.SetParameterString('m_bApplet','true');
arrt_cgo_save_multi_dl_dc._s.CallServlet('arrt_cgo_save_multi_dl_dc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_save_multi_dl_dc._s.errmsg;
}
}
arrt_cgo_save_multi_dl_dc.CtxLoad_ = function(){return []}
