function arrt_fam_stampa() {
var w_DaRapporto;
var w_ARapporto;
var w_flgatt;
var m_Caller
arrt_fam_stampa._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaRapporto=m_Caller.GetString('w_DaRapporto','C',0,0);
w_ARapporto=m_Caller.GetString('w_ARapporto','C',0,0);
w_flgatt=m_Caller.GetString('w_flgatt','C',0,0);
arrt_fam_stampa._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_stampa._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_stampa._s.SetCallerStringVar('w_DaRapporto',WtA(w_DaRapporto,'C'));
arrt_fam_stampa._s.SetCallerStringVar('w_ARapporto',WtA(w_ARapporto,'C'));
arrt_fam_stampa._s.SetCallerStringVar('w_flgatt',WtA(w_flgatt,'C'));
arrt_fam_stampa._s.SetParameterString('m_bApplet','true');
arrt_fam_stampa._s.CallServlet('arrt_fam_stampa');
m_Caller.SetString('w_DaRapporto','C',0,0,arrt_fam_stampa._s.GetCallerStringVar('w_DaRapporto'));
m_Caller.SetString('w_ARapporto','C',0,0,arrt_fam_stampa._s.GetCallerStringVar('w_ARapporto'));
m_Caller.SetString('w_flgatt','C',0,0,arrt_fam_stampa._s.GetCallerStringVar('w_flgatt'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_stampa._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_fam_stampa.CtxLoad_ = function(){return []}
