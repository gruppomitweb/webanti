function arrt_cgo_read_flgope() {
var w_CACODICE;
var w_CAFLGOPE;
var m_Caller
arrt_cgo_read_flgope._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CACODICE=m_Caller.GetNumber('w_CACODICE','N',0,0);
w_CAFLGOPE=m_Caller.GetString('w_CAFLGOPE','C',0,0);
arrt_cgo_read_flgope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_read_flgope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_read_flgope._s.SetCallerStringVar('w_CACODICE',WtA(w_CACODICE,'N'));
arrt_cgo_read_flgope._s.SetCallerStringVar('w_CAFLGOPE',WtA(w_CAFLGOPE,'C'));
arrt_cgo_read_flgope._s.SetParameterString('m_bApplet','true');
arrt_cgo_read_flgope._s.CallServlet('arrt_cgo_read_flgope');
m_Caller.SetNumber('w_CACODICE','N',0,0,arrt_cgo_read_flgope._s.GetCallerDoubleVar('w_CACODICE'));
m_Caller.SetString('w_CAFLGOPE','C',0,0,arrt_cgo_read_flgope._s.GetCallerStringVar('w_CAFLGOPE'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_read_flgope._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cgo_read_flgope.CtxLoad_ = function(){return []}
