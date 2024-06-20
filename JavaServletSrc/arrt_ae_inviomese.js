function arrt_ae_inviomese() {
var w_anno;
var w_mese;
var m_Caller
arrt_ae_inviomese._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_mese=m_Caller.GetString('w_mese','C',0,0);
arrt_ae_inviomese._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_inviomese._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_inviomese._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_ae_inviomese._s.SetCallerStringVar('w_mese',WtA(w_mese,'C'));
arrt_ae_inviomese._s.SetParameterString('m_bApplet','true');
arrt_ae_inviomese._s.CallServlet('arrt_ae_inviomese');
m_Caller.SetNumber('w_anno','N',0,0,arrt_ae_inviomese._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_mese','C',0,0,arrt_ae_inviomese._s.GetCallerStringVar('w_mese'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_inviomese._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_ae_inviomese.CtxLoad_ = function(){return []}
