function arrt_famsaldi_stp() {
var w_anno;
var m_Caller
arrt_famsaldi_stp._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetString('w_anno','C',0,0);
arrt_famsaldi_stp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_famsaldi_stp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_famsaldi_stp._s.SetCallerStringVar('w_anno',WtA(w_anno,'C'));
arrt_famsaldi_stp._s.SetParameterString('m_bApplet','true');
arrt_famsaldi_stp._s.CallServlet('arrt_famsaldi_stp');
m_Caller.SetString('w_anno','C',0,0,arrt_famsaldi_stp._s.GetCallerStringVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_famsaldi_stp._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_famsaldi_stp.CtxLoad_ = function(){return []}
