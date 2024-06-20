function arrt_stprappo_sto() {
var w_daRappo;
var w_aRappo;
var w_tipstp;
var m_Caller
arrt_stprappo_sto._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_daRappo=m_Caller.GetString('w_daRappo','C',0,0);
w_aRappo=m_Caller.GetString('w_aRappo','C',0,0);
w_tipstp=m_Caller.GetString('w_tipstp','C',0,0);
arrt_stprappo_sto._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stprappo_sto._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stprappo_sto._s.SetCallerStringVar('w_daRappo',WtA(w_daRappo,'C'));
arrt_stprappo_sto._s.SetCallerStringVar('w_aRappo',WtA(w_aRappo,'C'));
arrt_stprappo_sto._s.SetCallerStringVar('w_tipstp',WtA(w_tipstp,'C'));
arrt_stprappo_sto._s.SetParameterString('m_bApplet','true');
arrt_stprappo_sto._s.CallServlet('arrt_stprappo_sto');
m_Caller.SetString('w_daRappo','C',0,0,arrt_stprappo_sto._s.GetCallerStringVar('w_daRappo'));
m_Caller.SetString('w_aRappo','C',0,0,arrt_stprappo_sto._s.GetCallerStringVar('w_aRappo'));
m_Caller.SetString('w_tipstp','C',0,0,arrt_stprappo_sto._s.GetCallerStringVar('w_tipstp'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stprappo_sto._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stprappo_sto.CtxLoad_ = function(){return []}
