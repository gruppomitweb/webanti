function arrt_imp_utf8() {
var w_impzip;
var w_errchk;
var m_Caller
arrt_imp_utf8._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_errchk=m_Caller.GetNumber('w_errchk','N',0,0);
arrt_imp_utf8._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_utf8._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_utf8._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_utf8._s.SetCallerStringVar('w_errchk',WtA(w_errchk,'N'));
arrt_imp_utf8._s.SetParameterString('m_bApplet','true');
arrt_imp_utf8._s.CallServlet('arrt_imp_utf8');
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_utf8._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetNumber('w_errchk','N',0,0,arrt_imp_utf8._s.GetCallerDoubleVar('w_errchk'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_utf8._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_imp_utf8.CtxLoad_ = function(){return []}
