function arrt_cancella_opex() {
var w_datarett;
var w_nomefile;
var w_anno;
var m_Caller
arrt_cancella_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datarett=m_Caller.GetDate('w_datarett','D',0,0);
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
arrt_cancella_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cancella_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cancella_opex._s.SetCallerStringVar('w_datarett',WtA(w_datarett,'D'));
arrt_cancella_opex._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_cancella_opex._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_cancella_opex._s.SetParameterString('m_bApplet','true');
arrt_cancella_opex._s.CallServlet('arrt_cancella_opex');
m_Caller.SetDate('w_datarett','D',0,0,DateFromApplet(arrt_cancella_opex._s.GetCallerDateVar('w_datarett')));
m_Caller.SetString('w_nomefile','C',0,0,arrt_cancella_opex._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetNumber('w_anno','N',0,0,arrt_cancella_opex._s.GetCallerDoubleVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cancella_opex._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cancella_opex.CtxLoad_ = function(){return []}
