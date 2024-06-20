function arrt_trasffra_wu() {
var w_DaDatOpe;
var w_ADatOpe;
var m_Caller
arrt_trasffra_wu._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
arrt_trasffra_wu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasffra_wu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasffra_wu._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_trasffra_wu._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_trasffra_wu._s.SetParameterString('m_bApplet','true');
arrt_trasffra_wu._s.CallServlet('arrt_trasffra_wu');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_trasffra_wu._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_trasffra_wu._s.GetCallerDateVar('w_ADatOpe')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasffra_wu._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasffra_wu.CtxLoad_ = function(){return []}
