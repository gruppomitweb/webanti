function arrt_wu_alllinea_luonas() {
var pNomeFile;
var m_Caller
arrt_wu_alllinea_luonas._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNomeFile='';
}
if(arrt_wu_alllinea_luonas._p.length>0)_rargs([[['pNomeFile',arrt_wu_alllinea_luonas._p[0]]]],{eval:function(e){eval(e)}})
arrt_wu_alllinea_luonas._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wu_alllinea_luonas._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wu_alllinea_luonas._s.SetParameterString('pNomeFile',WtA(pNomeFile,'C'));
arrt_wu_alllinea_luonas._s.SetParameterString('m_bApplet','true');
arrt_wu_alllinea_luonas._s.CallServlet('arrt_wu_alllinea_luonas');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wu_alllinea_luonas._s.errmsg;
}
return arrt_wu_alllinea_luonas._s.GetString();
}
arrt_wu_alllinea_luonas.CtxLoad_ = function(){return []}
