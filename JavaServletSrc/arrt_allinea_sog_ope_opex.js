function arrt_allinea_sog_ope_opex() {
var w_nomefile;
var w_tipoall;
var w_anno;
var m_Caller
arrt_allinea_sog_ope_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_tipoall=m_Caller.GetString('w_tipoall','C',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
arrt_allinea_sog_ope_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_sog_ope_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_sog_ope_opex._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_allinea_sog_ope_opex._s.SetCallerStringVar('w_tipoall',WtA(w_tipoall,'C'));
arrt_allinea_sog_ope_opex._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_allinea_sog_ope_opex._s.SetParameterString('m_bApplet','true');
arrt_allinea_sog_ope_opex._s.CallServlet('arrt_allinea_sog_ope_opex');
m_Caller.SetString('w_nomefile','C',0,0,arrt_allinea_sog_ope_opex._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetString('w_tipoall','C',0,0,arrt_allinea_sog_ope_opex._s.GetCallerStringVar('w_tipoall'));
m_Caller.SetNumber('w_anno','N',0,0,arrt_allinea_sog_ope_opex._s.GetCallerDoubleVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_sog_ope_opex._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_sog_ope_opex.CtxLoad_ = function(){return []}
