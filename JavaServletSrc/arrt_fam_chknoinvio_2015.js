function arrt_fam_chknoinvio_2015() {
var w_flgexist;
var m_Caller
arrt_fam_chknoinvio_2015._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_flgexist=m_Caller.GetString('w_flgexist','C',0,0);
arrt_fam_chknoinvio_2015._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_chknoinvio_2015._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_chknoinvio_2015._s.SetCallerStringVar('w_flgexist',WtA(w_flgexist,'C'));
arrt_fam_chknoinvio_2015._s.SetParameterString('m_bApplet','true');
arrt_fam_chknoinvio_2015._s.CallServlet('arrt_fam_chknoinvio_2015');
m_Caller.SetString('w_flgexist','C',0,0,arrt_fam_chknoinvio_2015._s.GetCallerStringVar('w_flgexist'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_chknoinvio_2015._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_fam_chknoinvio_2015.CtxLoad_ = function(){return []}
