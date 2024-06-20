function arrt_sd_aprichiudi_delope() {
var w_a_data;
var w_dadata;
var w_FILEINVIO;
var w_DATAINVIO;
var w_CFINVIO;
var w_CAFINVIO;
var w_anno;
var w_mese;
var m_Caller
arrt_sd_aprichiudi_delope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_a_data=NullDate();
w_dadata=NullDate();
w_FILEINVIO='';
w_DATAINVIO=NullDate();
w_CFINVIO='';
w_CAFINVIO='';
w_anno=0;
w_mese='';
}
if(arrt_sd_aprichiudi_delope._p.length>0)_rargs([[['w_a_data',arrt_sd_aprichiudi_delope._p[0]],['w_dadata',arrt_sd_aprichiudi_delope._p[1]],['w_FILEINVIO',arrt_sd_aprichiudi_delope._p[2]],['w_DATAINVIO',arrt_sd_aprichiudi_delope._p[3]],['w_CFINVIO',arrt_sd_aprichiudi_delope._p[4]],['w_CAFINVIO',arrt_sd_aprichiudi_delope._p[5]],['w_anno',arrt_sd_aprichiudi_delope._p[6]],['w_mese',arrt_sd_aprichiudi_delope._p[7]]]],{eval:function(e){eval(e)}})
arrt_sd_aprichiudi_delope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_sd_aprichiudi_delope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_sd_aprichiudi_delope._s.SetParameterString('w_a_data',WtA(w_a_data,'D'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_dadata',WtA(w_dadata,'D'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_FILEINVIO',WtA(w_FILEINVIO,'C'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_DATAINVIO',WtA(w_DATAINVIO,'D'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_CFINVIO',WtA(w_CFINVIO,'C'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_CAFINVIO',WtA(w_CAFINVIO,'C'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_sd_aprichiudi_delope._s.SetParameterString('w_mese',WtA(w_mese,'C'));
arrt_sd_aprichiudi_delope._s.SetParameterString('m_bApplet','true');
arrt_sd_aprichiudi_delope._s.CallServlet('arrt_sd_aprichiudi_delope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_sd_aprichiudi_delope._s.errmsg;
}
}
arrt_sd_aprichiudi_delope.CtxLoad_ = function(){return []}
