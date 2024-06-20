function arrt_wuchkpas() {
var w_tipodest;
var w_opextc;
var w_destfin;
var m_Caller
arrt_wuchkpas._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_opextc=m_Caller.GetString('w_opextc','C',0,0);
w_destfin=m_Caller.GetString('w_destfin','C',0,0);
arrt_wuchkpas._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wuchkpas._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wuchkpas._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_wuchkpas._s.SetCallerStringVar('w_opextc',WtA(w_opextc,'C'));
arrt_wuchkpas._s.SetCallerStringVar('w_destfin',WtA(w_destfin,'C'));
arrt_wuchkpas._s.SetParameterString('m_bApplet','true');
arrt_wuchkpas._s.CallServlet('arrt_wuchkpas');
m_Caller.SetString('w_tipodest','C',0,0,arrt_wuchkpas._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetString('w_opextc','C',0,0,arrt_wuchkpas._s.GetCallerStringVar('w_opextc'));
m_Caller.SetString('w_destfin','C',0,0,arrt_wuchkpas._s.GetCallerStringVar('w_destfin'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wuchkpas._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_wuchkpas.CtxLoad_ = function(){return []}
