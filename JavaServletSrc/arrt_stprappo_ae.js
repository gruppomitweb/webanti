function arrt_stprappo_ae() {
var pTipo;
var w_daRappo;
var w_aRappo;
var w_DaData;
var w_AData;
var w_c_dadata;
var w_c_adata;
var w_detope;
var w_attiva;
var w_mod_attiva;
var w_cancellata;
var w_mod_copia;
var w_tipo;
var w_detana;
var w_flgtit;
var w_flgdel;
var w_coddip;
var w_noaui;
var m_Caller
arrt_stprappo_ae._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_stprappo_ae._p.length>0)_rargs([[['pTipo',arrt_stprappo_ae._p[0]]]],{eval:function(e){eval(e)}})
w_daRappo=m_Caller.GetString('w_daRappo','C',0,0);
w_aRappo=m_Caller.GetString('w_aRappo','C',0,0);
w_DaData=m_Caller.GetDate('w_DaData','D',0,0);
w_AData=m_Caller.GetDate('w_AData','D',0,0);
w_c_dadata=m_Caller.GetString('w_c_dadata','C',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_detope=m_Caller.GetString('w_detope','C',0,0);
w_attiva=m_Caller.GetString('w_attiva','C',0,0);
w_mod_attiva=m_Caller.GetString('w_mod_attiva','C',0,0);
w_cancellata=m_Caller.GetString('w_cancellata','C',0,0);
w_mod_copia=m_Caller.GetString('w_mod_copia','C',0,0);
w_tipo=m_Caller.GetString('w_tipo','C',0,0);
w_detana=m_Caller.GetString('w_detana','C',0,0);
w_flgtit=m_Caller.GetString('w_flgtit','C',0,0);
w_flgdel=m_Caller.GetString('w_flgdel','C',0,0);
w_coddip=m_Caller.GetString('w_coddip','C',0,0);
w_noaui=m_Caller.GetString('w_noaui','C',0,0);
arrt_stprappo_ae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stprappo_ae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stprappo_ae._s.SetCallerStringVar('w_daRappo',WtA(w_daRappo,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_aRappo',WtA(w_aRappo,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_DaData',WtA(w_DaData,'D'));
arrt_stprappo_ae._s.SetCallerStringVar('w_AData',WtA(w_AData,'D'));
arrt_stprappo_ae._s.SetCallerStringVar('w_c_dadata',WtA(w_c_dadata,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_detope',WtA(w_detope,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_attiva',WtA(w_attiva,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_mod_attiva',WtA(w_mod_attiva,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_cancellata',WtA(w_cancellata,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_mod_copia',WtA(w_mod_copia,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_tipo',WtA(w_tipo,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_detana',WtA(w_detana,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_flgtit',WtA(w_flgtit,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_flgdel',WtA(w_flgdel,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_coddip',WtA(w_coddip,'C'));
arrt_stprappo_ae._s.SetCallerStringVar('w_noaui',WtA(w_noaui,'C'));
arrt_stprappo_ae._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_stprappo_ae._s.SetParameterString('m_bApplet','true');
arrt_stprappo_ae._s.CallServlet('arrt_stprappo_ae');
m_Caller.SetString('w_daRappo','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_daRappo'));
m_Caller.SetString('w_aRappo','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_aRappo'));
m_Caller.SetDate('w_DaData','D',0,0,DateFromApplet(arrt_stprappo_ae._s.GetCallerDateVar('w_DaData')));
m_Caller.SetDate('w_AData','D',0,0,DateFromApplet(arrt_stprappo_ae._s.GetCallerDateVar('w_AData')));
m_Caller.SetString('w_c_dadata','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_c_dadata'));
m_Caller.SetString('w_c_adata','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetString('w_detope','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_detope'));
m_Caller.SetString('w_attiva','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_attiva'));
m_Caller.SetString('w_mod_attiva','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_mod_attiva'));
m_Caller.SetString('w_cancellata','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_cancellata'));
m_Caller.SetString('w_mod_copia','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_mod_copia'));
m_Caller.SetString('w_tipo','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_tipo'));
m_Caller.SetString('w_detana','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_detana'));
m_Caller.SetString('w_flgtit','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_flgtit'));
m_Caller.SetString('w_flgdel','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_flgdel'));
m_Caller.SetString('w_coddip','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_coddip'));
m_Caller.SetString('w_noaui','C',0,0,arrt_stprappo_ae._s.GetCallerStringVar('w_noaui'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stprappo_ae._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stprappo_ae.CtxLoad_ = function(){return []}
