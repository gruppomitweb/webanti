function arrt_aggstatorapprv() {
var w_RAPPORTO;
var w_CODINTER;
var w_DATAINI;
var w_DATAFINE;
var w_TIPOPERS;
var w_tiporegr;
var m_Caller
arrt_aggstatorapprv._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
w_CODINTER=m_Caller.GetString('w_CODINTER','C',0,0);
w_DATAINI=m_Caller.GetDate('w_DATAINI','D',0,0);
w_DATAFINE=m_Caller.GetDate('w_DATAFINE','D',0,0);
w_TIPOPERS=m_Caller.GetString('w_TIPOPERS','C',0,0);
w_tiporegr=m_Caller.GetString('w_tiporegr','C',0,0);
arrt_aggstatorapprv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_aggstatorapprv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_aggstatorapprv._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_aggstatorapprv._s.SetCallerStringVar('w_CODINTER',WtA(w_CODINTER,'C'));
arrt_aggstatorapprv._s.SetCallerStringVar('w_DATAINI',WtA(w_DATAINI,'D'));
arrt_aggstatorapprv._s.SetCallerStringVar('w_DATAFINE',WtA(w_DATAFINE,'D'));
arrt_aggstatorapprv._s.SetCallerStringVar('w_TIPOPERS',WtA(w_TIPOPERS,'C'));
arrt_aggstatorapprv._s.SetCallerStringVar('w_tiporegr',WtA(w_tiporegr,'C'));
arrt_aggstatorapprv._s.SetParameterString('m_bApplet','true');
arrt_aggstatorapprv._s.CallServlet('arrt_aggstatorapprv');
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_aggstatorapprv._s.GetCallerStringVar('w_RAPPORTO'));
m_Caller.SetString('w_CODINTER','C',0,0,arrt_aggstatorapprv._s.GetCallerStringVar('w_CODINTER'));
m_Caller.SetDate('w_DATAINI','D',0,0,DateFromApplet(arrt_aggstatorapprv._s.GetCallerDateVar('w_DATAINI')));
m_Caller.SetDate('w_DATAFINE','D',0,0,DateFromApplet(arrt_aggstatorapprv._s.GetCallerDateVar('w_DATAFINE')));
m_Caller.SetString('w_TIPOPERS','C',0,0,arrt_aggstatorapprv._s.GetCallerStringVar('w_TIPOPERS'));
m_Caller.SetString('w_tiporegr','C',0,0,arrt_aggstatorapprv._s.GetCallerStringVar('w_tiporegr'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_aggstatorapprv._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_aggstatorapprv.CtxLoad_ = function(){return []}
