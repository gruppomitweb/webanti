function arrt_sistemat() {
var w_datchi;
var w_datreg;
var w_msgproc;
var w_tipoarch;
var m_Caller
arrt_sistemat._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datchi=m_Caller.GetDate('w_datchi','D',0,0);
w_datreg=m_Caller.GetDate('w_datreg','D',0,0);
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_tipoarch=m_Caller.GetString('w_tipoarch','C',0,0);
arrt_sistemat._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sistemat._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sistemat._s.SetCallerStringVar('w_datchi',WtA(w_datchi,'D'));
arrt_sistemat._s.SetCallerStringVar('w_datreg',WtA(w_datreg,'D'));
arrt_sistemat._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_sistemat._s.SetCallerStringVar('w_tipoarch',WtA(w_tipoarch,'C'));
arrt_sistemat._s.SetParameterString('m_bApplet','true');
arrt_sistemat._s.CallServlet('arrt_sistemat');
m_Caller.SetDate('w_datchi','D',0,0,DateFromApplet(arrt_sistemat._s.GetCallerDateVar('w_datchi')));
m_Caller.SetDate('w_datreg','D',0,0,DateFromApplet(arrt_sistemat._s.GetCallerDateVar('w_datreg')));
m_Caller.SetString('w_msgproc','M',0,0,arrt_sistemat._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetString('w_tipoarch','C',0,0,arrt_sistemat._s.GetCallerStringVar('w_tipoarch'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sistemat._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_sistemat.CtxLoad_ = function(){return []}
