function arfn_verify_opex() {
var pCODICE;
var pAnno;
var m_Caller
arfn_verify_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCODICE='';
pAnno='';
}
if(arfn_verify_opex._p.length>0)_rargs([[['pCODICE',arfn_verify_opex._p[0]],['pAnno',arfn_verify_opex._p[1]]]],{eval:function(e){eval(e)}})
arfn_verify_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_verify_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_verify_opex._s.SetParameterString('pCODICE',WtA(pCODICE,'C'));
arfn_verify_opex._s.SetParameterString('pAnno',WtA(pAnno,'C'));
arfn_verify_opex._s.SetParameterString('m_bApplet','true');
arfn_verify_opex._s.CallServlet('arfn_verify_opex');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_verify_opex._s.errmsg;
}
return arfn_verify_opex._s.GetBoolean();
}
arfn_verify_opex.CtxLoad_ = function(){return []}
