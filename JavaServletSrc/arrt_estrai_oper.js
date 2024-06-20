function arrt_estrai_oper() {
var w_dadata;
var w_adata;
var w_cdadata;
var w_c_adata;
var w_cCODFISC;
var w_cDIP;
var w_cMTCN;
var w_xdesdip;
var m_Caller
arrt_estrai_oper._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_adata=m_Caller.GetDate('w_adata','D',0,0);
w_cdadata=m_Caller.GetString('w_cdadata','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_cCODFISC=m_Caller.GetString('w_cCODFISC','C',0,0);
w_cDIP=m_Caller.GetString('w_cDIP','C',0,0);
w_cMTCN=m_Caller.GetString('w_cMTCN','C',0,0);
w_xdesdip=m_Caller.GetString('w_xdesdip','C',0,0);
arrt_estrai_oper._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_oper._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_oper._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_estrai_oper._s.SetCallerStringVar('w_adata',WtA(w_adata,'D'));
arrt_estrai_oper._s.SetCallerStringVar('w_cdadata',WtA(w_cdadata,'C'));
arrt_estrai_oper._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_estrai_oper._s.SetCallerStringVar('w_cCODFISC',WtA(w_cCODFISC,'C'));
arrt_estrai_oper._s.SetCallerStringVar('w_cDIP',WtA(w_cDIP,'C'));
arrt_estrai_oper._s.SetCallerStringVar('w_cMTCN',WtA(w_cMTCN,'C'));
arrt_estrai_oper._s.SetCallerStringVar('w_xdesdip',WtA(w_xdesdip,'C'));
arrt_estrai_oper._s.SetParameterString('m_bApplet','true');
arrt_estrai_oper._s.CallServlet('arrt_estrai_oper');
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_estrai_oper._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_adata','D',0,0,DateFromApplet(arrt_estrai_oper._s.GetCallerDateVar('w_adata')));
m_Caller.SetString('w_cdadata','C',0,0,arrt_estrai_oper._s.GetCallerStringVar('w_cdadata'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_estrai_oper._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetString('w_cCODFISC','C',0,0,arrt_estrai_oper._s.GetCallerStringVar('w_cCODFISC'));
m_Caller.SetString('w_cDIP','C',0,0,arrt_estrai_oper._s.GetCallerStringVar('w_cDIP'));
m_Caller.SetString('w_cMTCN','C',0,0,arrt_estrai_oper._s.GetCallerStringVar('w_cMTCN'));
m_Caller.SetString('w_xdesdip','C',0,0,arrt_estrai_oper._s.GetCallerStringVar('w_xdesdip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_oper._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_estrai_oper.CtxLoad_ = function(){return []}
