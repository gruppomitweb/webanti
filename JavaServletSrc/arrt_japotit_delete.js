function arrt_japotit_delete() {
var w_IDBASE;
var w_NUMPROG;
var m_Caller
arrt_japotit_delete._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_NUMPROG=m_Caller.GetString('w_NUMPROG','C',0,0);
arrt_japotit_delete._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_japotit_delete._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_japotit_delete._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_japotit_delete._s.SetCallerStringVar('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_japotit_delete._s.SetParameterString('m_bApplet','true');
arrt_japotit_delete._s.CallServlet('arrt_japotit_delete');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_japotit_delete._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_NUMPROG','C',0,0,arrt_japotit_delete._s.GetCallerStringVar('w_NUMPROG'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_japotit_delete._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_japotit_delete.CtxLoad_ = function(){return []}
