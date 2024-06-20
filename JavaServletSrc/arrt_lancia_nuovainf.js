function arrt_lancia_nuovainf() {
var w_rapporto;
var m_Caller
arrt_lancia_nuovainf._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_rapporto=m_Caller.GetString('w_rapporto','C',0,0);
arrt_lancia_nuovainf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_lancia_nuovainf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_lancia_nuovainf._s.SetCallerStringVar('w_rapporto',WtA(w_rapporto,'C'));
arrt_lancia_nuovainf._s.SetParameterString('m_bApplet','true');
arrt_lancia_nuovainf._s.CallServlet('arrt_lancia_nuovainf');
m_Caller.SetString('w_rapporto','C',0,0,arrt_lancia_nuovainf._s.GetCallerStringVar('w_rapporto'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_lancia_nuovainf._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_lancia_nuovainf.CtxLoad_ = function(){return []}
