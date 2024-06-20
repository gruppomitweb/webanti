function arrt_cgo_ctiticita() {
var w_ctipo;
var m_Caller
arrt_cgo_ctiticita._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_ctipo=m_Caller.GetString('w_ctipo','C',0,0);
arrt_cgo_ctiticita._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_ctiticita._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_ctiticita._s.SetCallerStringVar('w_ctipo',WtA(w_ctipo,'C'));
arrt_cgo_ctiticita._s.SetParameterString('m_bApplet','true');
arrt_cgo_ctiticita._s.CallServlet('arrt_cgo_ctiticita');
m_Caller.SetString('w_ctipo','C',0,0,arrt_cgo_ctiticita._s.GetCallerStringVar('w_ctipo'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_ctiticita._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cgo_ctiticita.CtxLoad_ = function(){return []}
