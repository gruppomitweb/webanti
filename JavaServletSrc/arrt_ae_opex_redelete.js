function arrt_ae_opex_redelete() {
var pTipo;
var w_COLLEG;
var w_ANNO;
var m_Caller
arrt_ae_opex_redelete._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_ae_opex_redelete._p.length>0)_rargs([[['pTipo',arrt_ae_opex_redelete._p[0]]]],{eval:function(e){eval(e)}})
w_COLLEG=m_Caller.GetString('w_COLLEG','C',0,0);
w_ANNO=m_Caller.GetString('w_ANNO','C',0,0);
arrt_ae_opex_redelete._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_opex_redelete._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_opex_redelete._s.SetCallerStringVar('w_COLLEG',WtA(w_COLLEG,'C'));
arrt_ae_opex_redelete._s.SetCallerStringVar('w_ANNO',WtA(w_ANNO,'C'));
arrt_ae_opex_redelete._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_ae_opex_redelete._s.SetParameterString('m_bApplet','true');
arrt_ae_opex_redelete._s.CallServlet('arrt_ae_opex_redelete');
m_Caller.SetString('w_COLLEG','C',0,0,arrt_ae_opex_redelete._s.GetCallerStringVar('w_COLLEG'));
m_Caller.SetString('w_ANNO','C',0,0,arrt_ae_opex_redelete._s.GetCallerStringVar('w_ANNO'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_opex_redelete._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_ae_opex_redelete.CtxLoad_ = function(){return []}
