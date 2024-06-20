function arrt_storico_rapporti() {
var w_RAPPORTO;
var m_Caller
arrt_storico_rapporti._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
arrt_storico_rapporti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_storico_rapporti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_storico_rapporti._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_storico_rapporti._s.SetParameterString('m_bApplet','true');
arrt_storico_rapporti._s.CallServlet('arrt_storico_rapporti');
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_storico_rapporti._s.GetCallerStringVar('w_RAPPORTO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_storico_rapporti._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_storico_rapporti.CtxLoad_ = function(){return []}
