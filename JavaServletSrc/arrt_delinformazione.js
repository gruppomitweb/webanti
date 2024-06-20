function arrt_delinformazione() {
var w_IDBASE;
var w_RAPPORTO;
var w_TIPOOPRAP;
var w_DATAVARIA;
var m_Caller
arrt_delinformazione._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_IDBASE=m_Caller.GetString('w_IDBASE','C',0,0);
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
w_TIPOOPRAP=m_Caller.GetString('w_TIPOOPRAP','C',0,0);
w_DATAVARIA=m_Caller.GetDate('w_DATAVARIA','D',0,0);
arrt_delinformazione._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_delinformazione._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_delinformazione._s.SetCallerStringVar('w_IDBASE',WtA(w_IDBASE,'C'));
arrt_delinformazione._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_delinformazione._s.SetCallerStringVar('w_TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
arrt_delinformazione._s.SetCallerStringVar('w_DATAVARIA',WtA(w_DATAVARIA,'D'));
arrt_delinformazione._s.SetParameterString('m_bApplet','true');
arrt_delinformazione._s.CallServlet('arrt_delinformazione');
m_Caller.SetString('w_IDBASE','C',0,0,arrt_delinformazione._s.GetCallerStringVar('w_IDBASE'));
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_delinformazione._s.GetCallerStringVar('w_RAPPORTO'));
m_Caller.SetString('w_TIPOOPRAP','C',0,0,arrt_delinformazione._s.GetCallerStringVar('w_TIPOOPRAP'));
m_Caller.SetDate('w_DATAVARIA','D',0,0,DateFromApplet(arrt_delinformazione._s.GetCallerDateVar('w_DATAVARIA')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_delinformazione._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_delinformazione.CtxLoad_ = function(){return []}
