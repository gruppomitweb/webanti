function arfn_cgo_chkidb() {
var pIDB;
var m_Caller
arfn_cgo_chkidb._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDB='';
}
if(arfn_cgo_chkidb._p.length>0)_rargs([[['pIDB',arfn_cgo_chkidb._p[0]]]],{eval:function(e){eval(e)}})
arfn_cgo_chkidb._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cgo_chkidb._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cgo_chkidb._s.SetParameterString('pIDB',WtA(pIDB,'C'));
arfn_cgo_chkidb._s.SetParameterString('m_bApplet','true');
arfn_cgo_chkidb._s.CallServlet('arfn_cgo_chkidb');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cgo_chkidb._s.errmsg;
}
return arfn_cgo_chkidb._s.GetBoolean();
}
arfn_cgo_chkidb.CtxLoad_ = function(){return []}
