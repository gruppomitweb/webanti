function arrt_stpverage_do() {
var w_DaDatOpe;
var w_ADatOpe;
var w_c_adata;
var w_cdadata;
var w_chkcfis;
var w_noninvio;
var m_Caller
arrt_stpverage_do._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_cdadata=m_Caller.GetString('w_cdadata','C',0,0);
w_chkcfis=m_Caller.GetString('w_chkcfis','C',0,0);
w_noninvio=m_Caller.GetString('w_noninvio','C',0,0);
arrt_stpverage_do._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stpverage_do._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stpverage_do._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stpverage_do._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stpverage_do._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_stpverage_do._s.SetCallerStringVar('w_cdadata',WtA(w_cdadata,'C'));
arrt_stpverage_do._s.SetCallerStringVar('w_chkcfis',WtA(w_chkcfis,'C'));
arrt_stpverage_do._s.SetCallerStringVar('w_noninvio',WtA(w_noninvio,'C'));
arrt_stpverage_do._s.SetParameterString('m_bApplet','true');
arrt_stpverage_do._s.CallServlet('arrt_stpverage_do');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_stpverage_do._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_stpverage_do._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_c_adata','C',0,0,arrt_stpverage_do._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetString('w_cdadata','C',0,0,arrt_stpverage_do._s.GetCallerStringVar('w_cdadata'));
m_Caller.SetString('w_chkcfis','C',0,0,arrt_stpverage_do._s.GetCallerStringVar('w_chkcfis'));
m_Caller.SetString('w_noninvio','C',0,0,arrt_stpverage_do._s.GetCallerStringVar('w_noninvio'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stpverage_do._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stpverage_do.CtxLoad_ = function(){return []}
