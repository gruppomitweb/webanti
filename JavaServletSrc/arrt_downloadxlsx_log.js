function arrt_downloadxlsx_log() {
var pNomeFile;
var m_Caller
arrt_downloadxlsx_log._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNomeFile='';
}
if(arrt_downloadxlsx_log._p.length>0)_rargs([[['pNomeFile',arrt_downloadxlsx_log._p[0]]]],{eval:function(e){eval(e)}})
arrt_downloadxlsx_log._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_downloadxlsx_log._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_downloadxlsx_log._s.SetParameterString('pNomeFile',WtA(pNomeFile,'C'));
arrt_downloadxlsx_log._s.SetParameterString('m_bApplet','true');
arrt_downloadxlsx_log._s.CallServlet('arrt_downloadxlsx_log');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_downloadxlsx_log._s.errmsg;
}
return arrt_downloadxlsx_log._s.GetString();
}
arrt_downloadxlsx_log.CtxLoad_ = function(){return []}
