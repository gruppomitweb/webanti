function arrt_trasffrazdef() {
var w_DaDatOpe;
var w_ADatOpe;
var w_msgtxt;
var w_valelab;
var m_Caller
arrt_trasffrazdef._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_msgtxt=m_Caller.GetString('w_msgtxt','C',0,0);
w_valelab=m_Caller.GetNumber('w_valelab','N',0,0);
arrt_trasffrazdef._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasffrazdef._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasffrazdef._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_trasffrazdef._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_trasffrazdef._s.SetCallerStringVar('w_msgtxt',WtA(w_msgtxt,'C'));
arrt_trasffrazdef._s.SetCallerStringVar('w_valelab',WtA(w_valelab,'N'));
arrt_trasffrazdef._s.SetParameterString('m_bApplet','true');
arrt_trasffrazdef._s.CallServlet('arrt_trasffrazdef');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_trasffrazdef._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_trasffrazdef._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_msgtxt','C',0,0,arrt_trasffrazdef._s.GetCallerStringVar('w_msgtxt'));
m_Caller.SetNumber('w_valelab','N',0,0,arrt_trasffrazdef._s.GetCallerDoubleVar('w_valelab'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasffrazdef._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasffrazdef.CtxLoad_ = function(){return []}
