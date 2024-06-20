function arrt_downloadfile() {
var pFile;
var pCartella;
var pTipo;
var pDir;
var m_Caller
arrt_downloadfile._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pCartella='';
pTipo='';
pDir='';
}
if(arrt_downloadfile._p.length>0)_rargs([[['pFile',arrt_downloadfile._p[0]],['pCartella',arrt_downloadfile._p[1]],['pTipo',arrt_downloadfile._p[2]],['pDir',arrt_downloadfile._p[3]]]],{eval:function(e){eval(e)}})
arrt_downloadfile._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_downloadfile._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_downloadfile._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_downloadfile._s.SetParameterString('pCartella',WtA(pCartella,'C'));
arrt_downloadfile._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_downloadfile._s.SetParameterString('pDir',WtA(pDir,'C'));
arrt_downloadfile._s.SetParameterString('m_bApplet','true');
arrt_downloadfile._s.CallServlet('arrt_downloadfile');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_downloadfile._s.errmsg;
}
}
arrt_downloadfile.CtxLoad_ = function(){return []}
