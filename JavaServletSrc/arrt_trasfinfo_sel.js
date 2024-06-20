function arrt_trasfinfo_sel() {
var w_DaDatOpe;
var w_ADatOpe;
var w_cdadata;
var w_c_adata;
var m_Caller
arrt_trasfinfo_sel._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_cdadata=m_Caller.GetString('w_cdadata','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
arrt_trasfinfo_sel._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfinfo_sel._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfinfo_sel._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_trasfinfo_sel._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_trasfinfo_sel._s.SetCallerStringVar('w_cdadata',WtA(w_cdadata,'C'));
arrt_trasfinfo_sel._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_trasfinfo_sel._s.SetParameterString('m_bApplet','true');
arrt_trasfinfo_sel._s.CallServlet('arrt_trasfinfo_sel');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_trasfinfo_sel._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_trasfinfo_sel._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_cdadata','C',0,0,arrt_trasfinfo_sel._s.GetCallerStringVar('w_cdadata'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_trasfinfo_sel._s.GetCallerStringVar('w_c_adata'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfinfo_sel._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_trasfinfo_sel.CtxLoad_ = function(){return []}
