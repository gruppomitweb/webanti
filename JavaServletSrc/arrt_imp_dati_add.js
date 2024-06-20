function arrt_imp_dati_add() {
var w_impzip;
var m_Caller
arrt_imp_dati_add._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
arrt_imp_dati_add._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_add._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_add._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_add._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_add._s.CallServlet('arrt_imp_dati_add');
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_add._s.GetCallerDoubleVar('w_impzip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_add._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_imp_dati_add.CtxLoad_ = function(){return []}
