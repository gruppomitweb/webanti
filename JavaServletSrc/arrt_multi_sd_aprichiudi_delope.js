function arrt_multi_sd_aprichiudi_delope() {
var w_daanno;
var w_a_anno;
var w_CAFINVIO;
var w_CFINVIO;
var w_DATAINVIO;
var w_FILEINVIO;
var m_Caller
arrt_multi_sd_aprichiudi_delope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daanno=0;
w_a_anno=0;
w_CAFINVIO='';
w_CFINVIO='';
w_DATAINVIO=NullDate();
w_FILEINVIO='';
}
if(arrt_multi_sd_aprichiudi_delope._p.length>0)_rargs([[['w_daanno',arrt_multi_sd_aprichiudi_delope._p[0]],['w_a_anno',arrt_multi_sd_aprichiudi_delope._p[1]],['w_CAFINVIO',arrt_multi_sd_aprichiudi_delope._p[2]],['w_CFINVIO',arrt_multi_sd_aprichiudi_delope._p[3]],['w_DATAINVIO',arrt_multi_sd_aprichiudi_delope._p[4]],['w_FILEINVIO',arrt_multi_sd_aprichiudi_delope._p[5]]]],{eval:function(e){eval(e)}})
arrt_multi_sd_aprichiudi_delope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('w_daanno',WtA(w_daanno,'N'));
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('w_a_anno',WtA(w_a_anno,'N'));
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('w_CAFINVIO',WtA(w_CAFINVIO,'C'));
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('w_CFINVIO',WtA(w_CFINVIO,'C'));
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('w_DATAINVIO',WtA(w_DATAINVIO,'D'));
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('w_FILEINVIO',WtA(w_FILEINVIO,'C'));
arrt_multi_sd_aprichiudi_delope._s.SetParameterString('m_bApplet','true');
arrt_multi_sd_aprichiudi_delope._s.CallServlet('arrt_multi_sd_aprichiudi_delope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_multi_sd_aprichiudi_delope._s.errmsg;
}
}
arrt_multi_sd_aprichiudi_delope.CtxLoad_ = function(){return []}
