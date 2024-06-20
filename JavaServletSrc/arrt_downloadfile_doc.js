function arrt_downloadfile_doc() {
var pFile;
var pCartella;
var pTipo;
var m_Caller
arrt_downloadfile_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pCartella='';
pTipo='';
}
if(arrt_downloadfile_doc._p.length>0)_rargs([[['pFile',arrt_downloadfile_doc._p[0]],['pCartella',arrt_downloadfile_doc._p[1]],['pTipo',arrt_downloadfile_doc._p[2]]]],{eval:function(e){eval(e)}})
arrt_downloadfile_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_downloadfile_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_downloadfile_doc._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_downloadfile_doc._s.SetParameterString('pCartella',WtA(pCartella,'C'));
arrt_downloadfile_doc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_downloadfile_doc._s.SetParameterString('m_bApplet','true');
arrt_downloadfile_doc._s.CallServlet('arrt_downloadfile_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_downloadfile_doc._s.errmsg;
}
}
arrt_downloadfile_doc.CtxLoad_ = function(){return []}
