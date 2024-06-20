function arrt_inviomese_delope_globale() {
var w_a_datag;
var w_dadatag;
var m_Caller
arrt_inviomese_delope_globale._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_a_datag=m_Caller.GetDate('w_a_datag','D',0,0);
w_dadatag=m_Caller.GetDate('w_dadatag','D',0,0);
arrt_inviomese_delope_globale._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_inviomese_delope_globale._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_inviomese_delope_globale._s.SetCallerStringVar('w_a_datag',WtA(w_a_datag,'D'));
arrt_inviomese_delope_globale._s.SetCallerStringVar('w_dadatag',WtA(w_dadatag,'D'));
arrt_inviomese_delope_globale._s.SetParameterString('m_bApplet','true');
arrt_inviomese_delope_globale._s.CallServlet('arrt_inviomese_delope_globale');
m_Caller.SetDate('w_a_datag','D',0,0,DateFromApplet(arrt_inviomese_delope_globale._s.GetCallerDateVar('w_a_datag')));
m_Caller.SetDate('w_dadatag','D',0,0,DateFromApplet(arrt_inviomese_delope_globale._s.GetCallerDateVar('w_dadatag')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_inviomese_delope_globale._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_inviomese_delope_globale.CtxLoad_ = function(){return []}
