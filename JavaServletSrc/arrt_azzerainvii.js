function arrt_azzerainvii() {
var w_logoperaz;
var m_Caller
arrt_azzerainvii._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_logoperaz=m_Caller.GetString('w_logoperaz','M',0,0);
arrt_azzerainvii._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_azzerainvii._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_azzerainvii._s.SetCallerStringVar('w_logoperaz',WtA(w_logoperaz,'M'));
arrt_azzerainvii._s.SetParameterString('m_bApplet','true');
arrt_azzerainvii._s.CallServlet('arrt_azzerainvii');
m_Caller.SetString('w_logoperaz','M',0,0,arrt_azzerainvii._s.GetCallerStringVar('w_logoperaz'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_azzerainvii._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_azzerainvii.CtxLoad_ = function(){return []}
