function arrt_saldi_oro() {
var w_annoope;
var w_CONNES;
var w_imppagato;
var w_impricevuto;
var w_numope;
var w_risultato;
var m_Caller
arrt_saldi_oro._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_annoope=m_Caller.GetNumber('w_annoope','N',0,0);
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_imppagato=m_Caller.GetNumber('w_imppagato','N',0,0);
w_impricevuto=m_Caller.GetNumber('w_impricevuto','N',0,0);
w_numope=m_Caller.GetNumber('w_numope','N',0,0);
w_risultato=m_Caller.GetString('w_risultato','C',0,0);
arrt_saldi_oro._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_saldi_oro._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_saldi_oro._s.SetCallerStringVar('w_annoope',WtA(w_annoope,'N'));
arrt_saldi_oro._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_saldi_oro._s.SetCallerStringVar('w_imppagato',WtA(w_imppagato,'N'));
arrt_saldi_oro._s.SetCallerStringVar('w_impricevuto',WtA(w_impricevuto,'N'));
arrt_saldi_oro._s.SetCallerStringVar('w_numope',WtA(w_numope,'N'));
arrt_saldi_oro._s.SetCallerStringVar('w_risultato',WtA(w_risultato,'C'));
arrt_saldi_oro._s.SetParameterString('m_bApplet','true');
arrt_saldi_oro._s.CallServlet('arrt_saldi_oro');
m_Caller.SetNumber('w_annoope','N',0,0,arrt_saldi_oro._s.GetCallerDoubleVar('w_annoope'));
m_Caller.SetString('w_CONNES','C',0,0,arrt_saldi_oro._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetNumber('w_imppagato','N',0,0,arrt_saldi_oro._s.GetCallerDoubleVar('w_imppagato'));
m_Caller.SetNumber('w_impricevuto','N',0,0,arrt_saldi_oro._s.GetCallerDoubleVar('w_impricevuto'));
m_Caller.SetNumber('w_numope','N',0,0,arrt_saldi_oro._s.GetCallerDoubleVar('w_numope'));
m_Caller.SetString('w_risultato','C',0,0,arrt_saldi_oro._s.GetCallerStringVar('w_risultato'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_saldi_oro._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_saldi_oro.CtxLoad_ = function(){return []}
