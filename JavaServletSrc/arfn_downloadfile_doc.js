function arfn_downloadfile_doc() {
var pFile;
var pCartella;
var pTipo;
var m_Caller
arfn_downloadfile_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pCartella='';
pTipo='';
}
if(arfn_downloadfile_doc._p.length>0)_rargs([[['pFile',arfn_downloadfile_doc._p[0]],['pCartella',arfn_downloadfile_doc._p[1]],['pTipo',arfn_downloadfile_doc._p[2]]]],{eval:function(e){eval(e)}})
arfn_downloadfile_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_downloadfile_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_downloadfile_doc._s.SetParameterString('pFile',WtA(pFile,'C'));
arfn_downloadfile_doc._s.SetParameterString('pCartella',WtA(pCartella,'C'));
arfn_downloadfile_doc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_downloadfile_doc._s.SetParameterString('m_bApplet','true');
arfn_downloadfile_doc._s.CallServlet('arfn_downloadfile_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_downloadfile_doc._s.errmsg;
}
return arfn_downloadfile_doc._s.GetString();
}
arfn_downloadfile_doc.CtxLoad_ = function(){return []}
