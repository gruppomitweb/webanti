function arrt_imp_amexxls() {
var w_msgproc;
var m_Caller
arrt_imp_amexxls._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
arrt_imp_amexxls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_amexxls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_amexxls._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_imp_amexxls._s.SetParameterString('m_bApplet','true');
arrt_imp_amexxls._s.CallServlet('arrt_imp_amexxls');
m_Caller.SetString('w_msgproc','M',0,0,arrt_imp_amexxls._s.GetCallerStringVar('w_msgproc'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_amexxls._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_imp_amexxls.CtxLoad_ = function(){return []}
