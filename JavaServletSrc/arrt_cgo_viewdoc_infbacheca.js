function arrt_cgo_viewdoc_infbacheca() {
var pCodice;
var pDoc;
var m_Caller
arrt_cgo_viewdoc_infbacheca._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice=0;
pDoc='';
}
if(arrt_cgo_viewdoc_infbacheca._p.length>0)_rargs([[['pCodice',arrt_cgo_viewdoc_infbacheca._p[0]],['pDoc',arrt_cgo_viewdoc_infbacheca._p[1]]]],{eval:function(e){eval(e)}})
arrt_cgo_viewdoc_infbacheca._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_viewdoc_infbacheca._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_viewdoc_infbacheca._s.SetParameterString('pCodice',WtA(pCodice,'N'));
arrt_cgo_viewdoc_infbacheca._s.SetParameterString('pDoc',WtA(pDoc,'C'));
arrt_cgo_viewdoc_infbacheca._s.SetParameterString('m_bApplet','true');
arrt_cgo_viewdoc_infbacheca._s.CallServlet('arrt_cgo_viewdoc_infbacheca');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_viewdoc_infbacheca._s.errmsg;
}
}
arrt_cgo_viewdoc_infbacheca.CtxLoad_ = function(){return []}
