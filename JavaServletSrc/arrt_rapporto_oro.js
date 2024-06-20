function arrt_rapporto_oro() {
var w_CONNES;
var w_dataope;
var w_FLGCLOSE;
var w_risultato;
var m_Caller
arrt_rapporto_oro._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_dataope=m_Caller.GetDate('w_dataope','D',0,0);
w_FLGCLOSE=m_Caller.GetString('w_FLGCLOSE','C',0,0);
w_risultato=m_Caller.GetString('w_risultato','C',0,0);
arrt_rapporto_oro._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_rapporto_oro._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_rapporto_oro._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_rapporto_oro._s.SetCallerStringVar('w_dataope',WtA(w_dataope,'D'));
arrt_rapporto_oro._s.SetCallerStringVar('w_FLGCLOSE',WtA(w_FLGCLOSE,'C'));
arrt_rapporto_oro._s.SetCallerStringVar('w_risultato',WtA(w_risultato,'C'));
arrt_rapporto_oro._s.SetParameterString('m_bApplet','true');
arrt_rapporto_oro._s.CallServlet('arrt_rapporto_oro');
m_Caller.SetString('w_CONNES','C',0,0,arrt_rapporto_oro._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetDate('w_dataope','D',0,0,DateFromApplet(arrt_rapporto_oro._s.GetCallerDateVar('w_dataope')));
m_Caller.SetString('w_FLGCLOSE','C',0,0,arrt_rapporto_oro._s.GetCallerStringVar('w_FLGCLOSE'));
m_Caller.SetString('w_risultato','C',0,0,arrt_rapporto_oro._s.GetCallerStringVar('w_risultato'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_rapporto_oro._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_rapporto_oro.CtxLoad_ = function(){return []}
