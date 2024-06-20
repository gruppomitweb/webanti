function allinea_wubs() {
var w_tipodest;
var w_impzip;
var w_opextc;
var w_codmage;
var w_destfin;
var w_xMAFLGRAP;
var w_xMAFLGBON;
var m_Caller
allinea_wubs._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_opextc=m_Caller.GetString('w_opextc','C',0,0);
w_codmage=m_Caller.GetString('w_codmage','C',0,0);
w_destfin=m_Caller.GetString('w_destfin','C',0,0);
w_xMAFLGRAP=m_Caller.GetString('w_xMAFLGRAP','C',0,0);
w_xMAFLGBON=m_Caller.GetString('w_xMAFLGBON','C',0,0);
allinea_wubs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_wubs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_wubs._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
allinea_wubs._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
allinea_wubs._s.SetCallerStringVar('w_opextc',WtA(w_opextc,'C'));
allinea_wubs._s.SetCallerStringVar('w_codmage',WtA(w_codmage,'C'));
allinea_wubs._s.SetCallerStringVar('w_destfin',WtA(w_destfin,'C'));
allinea_wubs._s.SetCallerStringVar('w_xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
allinea_wubs._s.SetCallerStringVar('w_xMAFLGBON',WtA(w_xMAFLGBON,'C'));
allinea_wubs._s.SetParameterString('m_bApplet','true');
allinea_wubs._s.CallServlet('allinea_wubs');
m_Caller.SetString('w_tipodest','C',0,0,allinea_wubs._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetNumber('w_impzip','N',0,0,allinea_wubs._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetString('w_opextc','C',0,0,allinea_wubs._s.GetCallerStringVar('w_opextc'));
m_Caller.SetString('w_codmage','C',0,0,allinea_wubs._s.GetCallerStringVar('w_codmage'));
m_Caller.SetString('w_destfin','C',0,0,allinea_wubs._s.GetCallerStringVar('w_destfin'));
m_Caller.SetString('w_xMAFLGRAP','C',0,0,allinea_wubs._s.GetCallerStringVar('w_xMAFLGRAP'));
m_Caller.SetString('w_xMAFLGBON','C',0,0,allinea_wubs._s.GetCallerStringVar('w_xMAFLGBON'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_wubs._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
allinea_wubs.CtxLoad_ = function(){return []}
