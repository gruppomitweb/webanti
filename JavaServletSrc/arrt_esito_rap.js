function arrt_esito_rap() {
var w_gMsgProc;
var w_tipoelab;
var w_impzip;
var m_Caller
arrt_esito_rap._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_gMsgProc=m_Caller.GetString('gMsgProc','M',0,0);
w_tipoelab=m_Caller.GetString('w_tipoelab','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
arrt_esito_rap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_esito_rap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_esito_rap._s.SetCallerStringVar('gMsgProc',WtA(w_gMsgProc,'M'));
arrt_esito_rap._s.SetCallerStringVar('w_tipoelab',WtA(w_tipoelab,'C'));
arrt_esito_rap._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_esito_rap._s.SetParameterString('m_bApplet','true');
arrt_esito_rap._s.CallServlet('arrt_esito_rap');
m_Caller.SetString('w_gMsgProc','M',0,0,arrt_esito_rap._s.GetCallerStringVar('gMsgProc'));
m_Caller.SetString('w_tipoelab','C',0,0,arrt_esito_rap._s.GetCallerStringVar('w_tipoelab'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_esito_rap._s.GetCallerDoubleVar('w_impzip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_esito_rap._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_esito_rap.CtxLoad_ = function(){return []}
