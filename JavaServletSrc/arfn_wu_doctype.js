function arfn_wu_doctype() {
var pTipo;
var m_Caller
arfn_wu_doctype._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arfn_wu_doctype._p.length>0)_rargs([[['pTipo',arfn_wu_doctype._p[0]]]],{eval:function(e){eval(e)}})
arfn_wu_doctype._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_wu_doctype._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_wu_doctype._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_wu_doctype._s.SetParameterString('m_bApplet','true');
arfn_wu_doctype._s.CallServlet('arfn_wu_doctype');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_wu_doctype._s.errmsg;
}
return arfn_wu_doctype._s.GetString();
}
arfn_wu_doctype.CtxLoad_ = function(){return []}
