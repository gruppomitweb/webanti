function arfn_initdate() {
var pTipo;
var m_Caller
arfn_initdate._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arfn_initdate._p.length>0)_rargs([[['pTipo',arfn_initdate._p[0]]]],{eval:function(e){eval(e)}})
arfn_initdate._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_initdate._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_initdate._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_initdate._s.SetParameterString('m_bApplet','true');
arfn_initdate._s.CallServlet('arfn_initdate');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_initdate._s.errmsg;
}
return arfn_initdate._s.GetString();
}
arfn_initdate.CtxLoad_ = function(){return []}
