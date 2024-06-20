function arrt_allinea_age() {
var w_anno;
var m_Caller
arrt_allinea_age._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetString('w_anno','C',0,0);
arrt_allinea_age._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_age._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_age._s.SetCallerStringVar('w_anno',WtA(w_anno,'C'));
arrt_allinea_age._s.SetParameterString('m_bApplet','true');
arrt_allinea_age._s.CallServlet('arrt_allinea_age');
m_Caller.SetString('w_anno','C',0,0,arrt_allinea_age._s.GetCallerStringVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_age._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_age.CtxLoad_ = function(){return []}
