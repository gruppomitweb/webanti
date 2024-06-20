function arrt_cgo_blockope() {
var w_FLGDDOC;
var w_DATADOC;
var m_Caller
arrt_cgo_blockope._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_FLGDDOC=m_Caller.GetString('w_FLGDDOC','C',0,0);
w_DATADOC=m_Caller.GetDate('w_DATADOC','D',0,0);
arrt_cgo_blockope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_blockope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_blockope._s.SetCallerStringVar('w_FLGDDOC',WtA(w_FLGDDOC,'C'));
arrt_cgo_blockope._s.SetCallerStringVar('w_DATADOC',WtA(w_DATADOC,'D'));
arrt_cgo_blockope._s.SetParameterString('m_bApplet','true');
arrt_cgo_blockope._s.CallServlet('arrt_cgo_blockope');
m_Caller.SetString('w_FLGDDOC','C',0,0,arrt_cgo_blockope._s.GetCallerStringVar('w_FLGDDOC'));
m_Caller.SetDate('w_DATADOC','D',0,0,DateFromApplet(arrt_cgo_blockope._s.GetCallerDateVar('w_DATADOC')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_blockope._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cgo_blockope.CtxLoad_ = function(){return []}
