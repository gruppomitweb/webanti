function arrt_trasfope_sel() {
var w_DaDatOpe;
var w_ADatOpe;
var w_cdadata;
var w_c_adata;
var w_DaDatReg;
var w_ADatReg;
var m_Caller
arrt_trasfope_sel._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_cdadata=m_Caller.GetString('w_cdadata','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_DaDatReg=m_Caller.GetDate('w_DaDatReg','D',0,0);
w_ADatReg=m_Caller.GetDate('w_ADatReg','D',0,0);
arrt_trasfope_sel._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfope_sel._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfope_sel._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_trasfope_sel._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_trasfope_sel._s.SetCallerStringVar('w_cdadata',WtA(w_cdadata,'C'));
arrt_trasfope_sel._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_trasfope_sel._s.SetCallerStringVar('w_DaDatReg',WtA(w_DaDatReg,'D'));
arrt_trasfope_sel._s.SetCallerStringVar('w_ADatReg',WtA(w_ADatReg,'D'));
arrt_trasfope_sel._s.SetParameterString('m_bApplet','true');
arrt_trasfope_sel._s.CallServlet('arrt_trasfope_sel');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_trasfope_sel._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_trasfope_sel._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_cdadata','C',0,0,arrt_trasfope_sel._s.GetCallerStringVar('w_cdadata'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_trasfope_sel._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetDate('w_DaDatReg','D',0,0,DateFromApplet(arrt_trasfope_sel._s.GetCallerDateVar('w_DaDatReg')));
m_Caller.SetDate('w_ADatReg','D',0,0,DateFromApplet(arrt_trasfope_sel._s.GetCallerDateVar('w_ADatReg')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfope_sel._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasfope_sel.CtxLoad_ = function(){return []}
