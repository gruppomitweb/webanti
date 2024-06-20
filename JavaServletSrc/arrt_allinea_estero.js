function arrt_allinea_estero() {
var w_COLLEG;
var w_ANNO;
var m_Caller
arrt_allinea_estero._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_COLLEG=m_Caller.GetString('w_COLLEG','C',0,0);
w_ANNO=m_Caller.GetString('w_ANNO','C',0,0);
arrt_allinea_estero._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_estero._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_estero._s.SetCallerStringVar('w_COLLEG',WtA(w_COLLEG,'C'));
arrt_allinea_estero._s.SetCallerStringVar('w_ANNO',WtA(w_ANNO,'C'));
arrt_allinea_estero._s.SetParameterString('m_bApplet','true');
arrt_allinea_estero._s.CallServlet('arrt_allinea_estero');
m_Caller.SetString('w_COLLEG','C',0,0,arrt_allinea_estero._s.GetCallerStringVar('w_COLLEG'));
m_Caller.SetString('w_ANNO','C',0,0,arrt_allinea_estero._s.GetCallerStringVar('w_ANNO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_estero._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_estero.CtxLoad_ = function(){return []}
