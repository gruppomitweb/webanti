function arrt_closerap() {
var w_dataope;
var w_datareg;
var w_tipope;
var w_xdes1;
var m_Caller
arrt_closerap._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_dataope=m_Caller.GetDate('w_dataope','D',0,0);
w_datareg=m_Caller.GetDate('w_datareg','D',0,0);
w_tipope=m_Caller.GetString('w_tipope','C',0,0);
w_xdes1=m_Caller.GetString('w_xdes1','C',0,0);
arrt_closerap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_closerap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_closerap._s.SetCallerStringVar('w_dataope',WtA(w_dataope,'D'));
arrt_closerap._s.SetCallerStringVar('w_datareg',WtA(w_datareg,'D'));
arrt_closerap._s.SetCallerStringVar('w_tipope',WtA(w_tipope,'C'));
arrt_closerap._s.SetCallerStringVar('w_xdes1',WtA(w_xdes1,'C'));
arrt_closerap._s.SetParameterString('m_bApplet','true');
arrt_closerap._s.CallServlet('arrt_closerap');
m_Caller.SetDate('w_dataope','D',0,0,DateFromApplet(arrt_closerap._s.GetCallerDateVar('w_dataope')));
m_Caller.SetDate('w_datareg','D',0,0,DateFromApplet(arrt_closerap._s.GetCallerDateVar('w_datareg')));
m_Caller.SetString('w_tipope','C',0,0,arrt_closerap._s.GetCallerStringVar('w_tipope'));
m_Caller.SetString('w_xdes1','C',0,0,arrt_closerap._s.GetCallerStringVar('w_xdes1'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_closerap._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_closerap.CtxLoad_ = function(){return []}
