function arrt_esito_rap_report() {
var pOut;
var w_tipoelab;
var m_Caller
arrt_esito_rap_report._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pOut='';
}
if(arrt_esito_rap_report._p.length>0)_rargs([[['pOut',arrt_esito_rap_report._p[0]]]],{eval:function(e){eval(e)}})
w_tipoelab=m_Caller.GetString('w_tipoelab','C',0,0);
arrt_esito_rap_report._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_esito_rap_report._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_esito_rap_report._s.SetCallerStringVar('w_tipoelab',WtA(w_tipoelab,'C'));
arrt_esito_rap_report._s.SetParameterString('pOut',WtA(pOut,'C'));
arrt_esito_rap_report._s.SetParameterString('m_bApplet','true');
arrt_esito_rap_report._s.CallServlet('arrt_esito_rap_report');
m_Caller.SetString('w_tipoelab','C',0,0,arrt_esito_rap_report._s.GetCallerStringVar('w_tipoelab'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_esito_rap_report._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_esito_rap_report.CtxLoad_ = function(){return []}
