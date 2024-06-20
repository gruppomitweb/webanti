function arrt_cgo_delete_doc() {
var pIDDOC;
var pSaved;
var pStato;
var m_Caller
arrt_cgo_delete_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDDOC='';
pSaved='';
pStato='';
}
if(arrt_cgo_delete_doc._p.length>0)_rargs([[['pIDDOC',arrt_cgo_delete_doc._p[0]],['pSaved',arrt_cgo_delete_doc._p[1]],['pStato',arrt_cgo_delete_doc._p[2]]]],{eval:function(e){eval(e)}})
arrt_cgo_delete_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_delete_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_delete_doc._s.SetParameterString('pIDDOC',WtA(pIDDOC,'C'));
arrt_cgo_delete_doc._s.SetParameterString('pSaved',WtA(pSaved,'C'));
arrt_cgo_delete_doc._s.SetParameterString('pStato',WtA(pStato,'C'));
arrt_cgo_delete_doc._s.SetParameterString('m_bApplet','true');
arrt_cgo_delete_doc._s.CallServlet('arrt_cgo_delete_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_delete_doc._s.errmsg;
}
}
arrt_cgo_delete_doc.CtxLoad_ = function(){return []}
