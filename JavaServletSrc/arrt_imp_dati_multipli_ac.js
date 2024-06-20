function arrt_imp_dati_multipli_ac() {
var w_tipodest;
var w_impzip;
var w_opextc;
var w_codmage;
var w_destfin;
var w_xMAFLGRAP;
var w_xMAFLGBON;
var w_xMAFLGCKR;
var w_xMAFLGASR;
var w_xMADIPSTD;
var m_Caller
arrt_imp_dati_multipli_ac._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_opextc=m_Caller.GetString('w_opextc','C',0,0);
w_codmage=m_Caller.GetString('w_codmage','C',0,0);
w_destfin=m_Caller.GetString('w_destfin','C',0,0);
w_xMAFLGRAP=m_Caller.GetString('w_xMAFLGRAP','C',0,0);
w_xMAFLGBON=m_Caller.GetString('w_xMAFLGBON','C',0,0);
w_xMAFLGCKR=m_Caller.GetString('w_xMAFLGCKR','C',0,0);
w_xMAFLGASR=m_Caller.GetString('w_xMAFLGASR','C',0,0);
w_xMADIPSTD=m_Caller.GetString('w_xMADIPSTD','C',0,0);
arrt_imp_dati_multipli_ac._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_imp_dati_multipli_ac._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_opextc',WtA(w_opextc,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_codmage',WtA(w_codmage,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_destfin',WtA(w_destfin,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_xMAFLGBON',WtA(w_xMAFLGBON,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_xMAFLGCKR',WtA(w_xMAFLGCKR,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_xMAFLGASR',WtA(w_xMAFLGASR,'C'));
arrt_imp_dati_multipli_ac._s.SetCallerStringVar('w_xMADIPSTD',WtA(w_xMADIPSTD,'C'));
arrt_imp_dati_multipli_ac._s.SetParameterString('m_bApplet','true');
arrt_imp_dati_multipli_ac._s.CallServlet('arrt_imp_dati_multipli_ac');
m_Caller.SetString('w_tipodest','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_imp_dati_multipli_ac._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetString('w_opextc','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_opextc'));
m_Caller.SetString('w_codmage','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_codmage'));
m_Caller.SetString('w_destfin','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_destfin'));
m_Caller.SetString('w_xMAFLGRAP','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_xMAFLGRAP'));
m_Caller.SetString('w_xMAFLGBON','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_xMAFLGBON'));
m_Caller.SetString('w_xMAFLGCKR','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_xMAFLGCKR'));
m_Caller.SetString('w_xMAFLGASR','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_xMAFLGASR'));
m_Caller.SetString('w_xMADIPSTD','C',0,0,arrt_imp_dati_multipli_ac._s.GetCallerStringVar('w_xMADIPSTD'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_imp_dati_multipli_ac._s.errmsg;
}
CalledBatchEnd();
}
arrt_imp_dati_multipli_ac.CtxLoad_ = function(){return []}
