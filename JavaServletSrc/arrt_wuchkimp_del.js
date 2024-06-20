function arrt_wuchkimp_del() {
var pMTCN;
var m_Caller
arrt_wuchkimp_del._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pMTCN=0;
}
if(arrt_wuchkimp_del._p.length>0)_rargs([[['pMTCN',arrt_wuchkimp_del._p[0]]]],{eval:function(e){eval(e)}})
arrt_wuchkimp_del._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wuchkimp_del._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wuchkimp_del._s.SetParameterString('pMTCN',WtA(pMTCN,'N'));
arrt_wuchkimp_del._s.SetParameterString('m_bApplet','true');
arrt_wuchkimp_del._s.CallServlet('arrt_wuchkimp_del');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wuchkimp_del._s.errmsg;
}
}
arrt_wuchkimp_del.CtxLoad_ = function(){return []}
