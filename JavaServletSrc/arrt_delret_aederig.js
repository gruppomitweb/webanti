function arrt_delret_aederig() {
var w_IDBASE;
var w_RAPPORTO;
var w_ADATARET;
var m_Caller
arrt_delret_aederig._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
w_ADATARET=m_Caller.GetDate('w_ADATARET','D',0,0);
arrt_delret_aederig._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_delret_aederig._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_delret_aederig._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_delret_aederig._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_delret_aederig._s.SetCallerStringVar('w_ADATARET',WtA(w_ADATARET,'D'));
arrt_delret_aederig._s.SetParameterString('m_bApplet','true');
arrt_delret_aederig._s.CallServlet('arrt_delret_aederig');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_delret_aederig._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_delret_aederig._s.GetCallerStringVar('w_RAPPORTO'));
m_Caller.SetDate('w_ADATARET','D',0,0,DateFromApplet(arrt_delret_aederig._s.GetCallerDateVar('w_ADATARET')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_delret_aederig._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_delret_aederig.CtxLoad_ = function(){return []}
