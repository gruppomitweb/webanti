function arfn_upload_file_single() {
var pNomeFile;
var pDirDest;
var pFileTmp;
var m_Caller
arfn_upload_file_single._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNomeFile='';
pDirDest='';
pFileTmp='';
}
if(arfn_upload_file_single._p.length>0)_rargs([[['pNomeFile',arfn_upload_file_single._p[0]],['pDirDest',arfn_upload_file_single._p[1]],['pFileTmp',arfn_upload_file_single._p[2]]]],{eval:function(e){eval(e)}})
arfn_upload_file_single._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_upload_file_single._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_upload_file_single._s.SetParameterString('pNomeFile',WtA(pNomeFile,'C'));
arfn_upload_file_single._s.SetParameterString('pDirDest',WtA(pDirDest,'C'));
arfn_upload_file_single._s.SetParameterString('pFileTmp',WtA(pFileTmp,'C'));
arfn_upload_file_single._s.SetParameterString('m_bApplet','true');
arfn_upload_file_single._s.CallServlet('arfn_upload_file_single');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_upload_file_single._s.errmsg;
}
return arfn_upload_file_single._s.GetString();
}
arfn_upload_file_single.CtxLoad_ = function(){return []}
