function arrt_stpfraz_xls() {
var w_DaDatOpe;
var w_ADatOpe;
var w_daCodCli;
var w_aCodCli;
var w_tipstp;
var w_c_adata;
var w_c_dadata;
var m_Caller
arrt_stpfraz_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_daCodCli=m_Caller.GetString('w_daCodCli','C',0,0);
w_aCodCli=m_Caller.GetString('w_aCodCli','C',0,0);
w_tipstp=m_Caller.GetString('w_tipstp','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_c_dadata=m_Caller.GetString('w_c_dadata','C',0,0);
arrt_stpfraz_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stpfraz_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stpfraz_xls._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stpfraz_xls._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stpfraz_xls._s.SetCallerStringVar('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_stpfraz_xls._s.SetCallerStringVar('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_stpfraz_xls._s.SetCallerStringVar('w_tipstp',WtA(w_tipstp,'C'));
arrt_stpfraz_xls._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_stpfraz_xls._s.SetCallerStringVar('w_c_dadata',WtA(w_c_dadata,'C'));
arrt_stpfraz_xls._s.SetParameterString('m_bApplet','true');
arrt_stpfraz_xls._s.CallServlet('arrt_stpfraz_xls');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_stpfraz_xls._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_stpfraz_xls._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_daCodCli','C',0,0,arrt_stpfraz_xls._s.GetCallerStringVar('w_daCodCli'));
m_Caller.SetString('w_aCodCli','C',0,0,arrt_stpfraz_xls._s.GetCallerStringVar('w_aCodCli'));
m_Caller.SetString('w_tipstp','C',0,0,arrt_stpfraz_xls._s.GetCallerStringVar('w_tipstp'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_stpfraz_xls._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetString('w_c_dadata','C',0,0,arrt_stpfraz_xls._s.GetCallerStringVar('w_c_dadata'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stpfraz_xls._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stpfraz_xls.CtxLoad_ = function(){return []}
