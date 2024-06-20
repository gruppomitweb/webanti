function spadministration_deletemobappdir() {
var w_oaappmenu;
var m_Caller
spadministration_deletemobappdir._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_oaappmenu=m_Caller.GetString('w_oaappmenu','C',0,0);
spadministration_deletemobappdir._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_deletemobappdir._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_deletemobappdir._s.SetCallerStringVar('w_oaappmenu',WtA(w_oaappmenu,'C'));
spadministration_deletemobappdir._s.SetParameterString('m_bApplet','true');
spadministration_deletemobappdir._s.CallServlet('spadministration_deletemobappdir');
m_Caller.SetString('w_oaappmenu','C',0,0,spadministration_deletemobappdir._s.GetCallerStringVar('w_oaappmenu'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_deletemobappdir._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
spadministration_deletemobappdir.CtxLoad_ = function(){return []}
