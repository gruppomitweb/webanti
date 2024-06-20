function allinea_sigue() {
var w_DaDatOpe;
var w_ADatOpe;
var m_Caller
allinea_sigue._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
allinea_sigue._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_sigue._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_sigue._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
allinea_sigue._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
allinea_sigue._s.SetParameterString('m_bApplet','true');
allinea_sigue._s.CallServlet('allinea_sigue');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(allinea_sigue._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(allinea_sigue._s.GetCallerDateVar('w_ADatOpe')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_sigue._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
allinea_sigue.CtxLoad_ = function(){return []}
