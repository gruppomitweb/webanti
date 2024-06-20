function arrt_trasfinfo() {
var w_DaDatOpe;
var w_ADatOpe;
var w_DaDatReg;
var w_ADatReg;
var m_Caller
arrt_trasfinfo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_DaDatReg=m_Caller.GetDate('w_DaDatReg','D',0,0);
w_ADatReg=m_Caller.GetDate('w_ADatReg','D',0,0);
arrt_trasfinfo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfinfo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfinfo._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_trasfinfo._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_trasfinfo._s.SetCallerStringVar('w_DaDatReg',WtA(w_DaDatReg,'D'));
arrt_trasfinfo._s.SetCallerStringVar('w_ADatReg',WtA(w_ADatReg,'D'));
arrt_trasfinfo._s.SetParameterString('m_bApplet','true');
arrt_trasfinfo._s.CallServlet('arrt_trasfinfo');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_trasfinfo._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_trasfinfo._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetDate('w_DaDatReg','D',0,0,DateFromApplet(arrt_trasfinfo._s.GetCallerDateVar('w_DaDatReg')));
m_Caller.SetDate('w_ADatReg','D',0,0,DateFromApplet(arrt_trasfinfo._s.GetCallerDateVar('w_ADatReg')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfinfo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasfinfo.CtxLoad_ = function(){return []}
