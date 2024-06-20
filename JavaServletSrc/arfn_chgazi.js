function arfn_chgazi() {
var pCodAzi;
var m_Caller
arfn_chgazi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodAzi='';
}
if(arfn_chgazi._p.length>0)_rargs([[['pCodAzi',arfn_chgazi._p[0]]]],{eval:function(e){eval(e)}})
arfn_chgazi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chgazi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chgazi._s.SetParameterString('pCodAzi',WtA(pCodAzi,'C'));
arfn_chgazi._s.SetParameterString('m_bApplet','true');
arfn_chgazi._s.CallServlet('arfn_chgazi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chgazi._s.errmsg;
}
return arfn_chgazi._s.GetBoolean();
}
arfn_chgazi.CtxLoad_ = function(){return []}
