function arrt_downloadfile_code() {
var pCodice;
var pTipo;
var m_Caller
arrt_downloadfile_code._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice='';
pTipo='';
}
if(arrt_downloadfile_code._p.length>0)_rargs([[['pCodice',arrt_downloadfile_code._p[0]],['pTipo',arrt_downloadfile_code._p[1]]]],{eval:function(e){eval(e)}})
arrt_downloadfile_code._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_downloadfile_code._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_downloadfile_code._s.SetParameterString('pCodice',WtA(pCodice,'C'));
arrt_downloadfile_code._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_downloadfile_code._s.SetParameterString('m_bApplet','true');
arrt_downloadfile_code._s.CallServlet('arrt_downloadfile_code');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_downloadfile_code._s.errmsg;
}
}
arrt_downloadfile_code.CtxLoad_ = function(){return []}
