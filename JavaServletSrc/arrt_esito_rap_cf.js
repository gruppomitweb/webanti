function arrt_esito_rap_cf() {
var w_tipodoc;
var m_Caller
arrt_esito_rap_cf._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodoc=m_Caller.GetString('w_tipodoc','C',0,0);
arrt_esito_rap_cf._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_esito_rap_cf._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_esito_rap_cf._s.SetCallerStringVar('w_tipodoc',WtA(w_tipodoc,'C'));
arrt_esito_rap_cf._s.SetParameterString('m_bApplet','true');
arrt_esito_rap_cf._s.CallServlet('arrt_esito_rap_cf');
m_Caller.SetString('w_tipodoc','C',0,0,arrt_esito_rap_cf._s.GetCallerStringVar('w_tipodoc'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_esito_rap_cf._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_esito_rap_cf.CtxLoad_ = function(){return []}
