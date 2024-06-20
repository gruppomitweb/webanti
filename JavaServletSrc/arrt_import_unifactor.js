function arrt_import_unifactor() {
var pmcListaFile;
var m_Caller
arrt_import_unifactor._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_import_unifactor._p.length>0)_rargs([[['pmcListaFile',arrt_import_unifactor._p[0]]]],{eval:function(e){eval(e)}})
arrt_import_unifactor._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_unifactor._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_unifactor._s.SetParameterString('pmcListaFile',WtA(pmcListaFile,'MC'),pmcListaFile);
arrt_import_unifactor._s.SetParameterString('m_bApplet','true');
arrt_import_unifactor._s.CallServlet('arrt_import_unifactor');
pmcListaFile._Copy(arrt_import_unifactor._s.GetCallerMemoryCursorVar('pmcListaFile'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_unifactor._s.errmsg;
}
return arrt_import_unifactor._s.GetString();
}
arrt_import_unifactor.CtxLoad_ = function(){return []}
