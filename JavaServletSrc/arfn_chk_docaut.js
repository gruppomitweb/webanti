function arfn_chk_docaut() {
var pAut;
var pDoc;
var m_Caller
arfn_chk_docaut._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAut='';
pDoc='';
}
if(arfn_chk_docaut._p.length>0)_rargs([[['pAut',arfn_chk_docaut._p[0]],['pDoc',arfn_chk_docaut._p[1]]]],{eval:function(e){eval(e)}})
arfn_chk_docaut._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chk_docaut._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chk_docaut._s.SetParameterString('pAut',WtA(pAut,'C'));
arfn_chk_docaut._s.SetParameterString('pDoc',WtA(pDoc,'C'));
arfn_chk_docaut._s.SetParameterString('m_bApplet','true');
arfn_chk_docaut._s.CallServlet('arfn_chk_docaut');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chk_docaut._s.errmsg;
}
return arfn_chk_docaut._s.GetBoolean();
}
arfn_chk_docaut.CtxLoad_ = function(){return []}
