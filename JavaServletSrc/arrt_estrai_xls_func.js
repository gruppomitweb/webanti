function arrt_estrai_xls_func() {
var pmcParametri;
var pAzienda;
var pPath;
var m_Caller
arrt_estrai_xls_func._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAzienda='';
pPath='';
}
if(arrt_estrai_xls_func._p.length>0)_rargs([[['pmcParametri',arrt_estrai_xls_func._p[0]],['pAzienda',arrt_estrai_xls_func._p[1]],['pPath',arrt_estrai_xls_func._p[2]]]],{eval:function(e){eval(e)}})
arrt_estrai_xls_func._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_xls_func._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_xls_func._s.SetParameterString('pmcParametri',WtA(pmcParametri,'MC'),pmcParametri);
arrt_estrai_xls_func._s.SetParameterString('pAzienda',WtA(pAzienda,'C'));
arrt_estrai_xls_func._s.SetParameterString('pPath',WtA(pPath,'C'));
arrt_estrai_xls_func._s.SetParameterString('m_bApplet','true');
arrt_estrai_xls_func._s.CallServlet('arrt_estrai_xls_func');
pmcParametri._Copy(arrt_estrai_xls_func._s.GetCallerMemoryCursorVar('pmcParametri'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_xls_func._s.errmsg;
}
}
arrt_estrai_xls_func.CtxLoad_ = function(){return []}
