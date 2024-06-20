function arfn_cgo_chkdocs() {
var pIDDOC;
var pGioco;
var pTotale;
var pContanti;
var pFlgDoc;
var m_Caller
arfn_cgo_chkdocs._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDDOC='';
pGioco='';
pTotale=0;
pContanti=0;
pFlgDoc='';
}
if(arfn_cgo_chkdocs._p.length>0)_rargs([[['pIDDOC',arfn_cgo_chkdocs._p[0]],['pGioco',arfn_cgo_chkdocs._p[1]],['pTotale',arfn_cgo_chkdocs._p[2]],['pContanti',arfn_cgo_chkdocs._p[3]],['pFlgDoc',arfn_cgo_chkdocs._p[4]]]],{eval:function(e){eval(e)}})
arfn_cgo_chkdocs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_chkdocs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_chkdocs._s.SetParameterString('pIDDOC',WtA(pIDDOC,'C'));
arfn_cgo_chkdocs._s.SetParameterString('pGioco',WtA(pGioco,'C'));
arfn_cgo_chkdocs._s.SetParameterString('pTotale',WtA(pTotale,'N'));
arfn_cgo_chkdocs._s.SetParameterString('pContanti',WtA(pContanti,'N'));
arfn_cgo_chkdocs._s.SetParameterString('pFlgDoc',WtA(pFlgDoc,'C'));
arfn_cgo_chkdocs._s.SetParameterString('m_bApplet','true');
arfn_cgo_chkdocs._s.CallServlet('arfn_cgo_chkdocs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_chkdocs._s.errmsg;
}
return arfn_cgo_chkdocs._s.GetString();
}
arfn_cgo_chkdocs.CtxLoad_ = function(){return []}
