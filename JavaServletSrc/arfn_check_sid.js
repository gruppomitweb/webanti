function arfn_check_sid() {
var pTipo;
var m_Caller
arfn_check_sid._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arfn_check_sid._p.length>0)_rargs([[['pTipo',arfn_check_sid._p[0]]]],{eval:function(e){eval(e)}})
arfn_check_sid._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_check_sid._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_check_sid._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_check_sid._s.SetParameterString('m_bApplet','true');
arfn_check_sid._s.CallServlet('arfn_check_sid');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_check_sid._s.errmsg;
}
return arfn_check_sid._s.GetBoolean();
}
arfn_check_sid.CtxLoad_ = function(){return []}
