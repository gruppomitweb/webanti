function arrt_all_opextrbo() {
var w_DaDatOpe;
var w_ADatOpe;
var w_c_dadata;
var w_c_adata;
var m_Caller
arrt_all_opextrbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_c_dadata=m_Caller.GetString('w_c_dadata','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
arrt_all_opextrbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_all_opextrbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_all_opextrbo._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_all_opextrbo._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_all_opextrbo._s.SetCallerStringVar('w_c_dadata',WtA(w_c_dadata,'C'));
arrt_all_opextrbo._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_all_opextrbo._s.SetParameterString('m_bApplet','true');
arrt_all_opextrbo._s.CallServlet('arrt_all_opextrbo');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_all_opextrbo._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_all_opextrbo._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_c_dadata','C',0,0,arrt_all_opextrbo._s.GetCallerStringVar('w_c_dadata'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_all_opextrbo._s.GetCallerStringVar('w_c_adata'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_all_opextrbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_all_opextrbo.CtxLoad_ = function(){return []}
