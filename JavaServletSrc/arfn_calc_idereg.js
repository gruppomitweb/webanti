function arfn_calc_idereg() {
var pTipo;
var pNP;
var pIDR;
var m_Caller
arfn_calc_idereg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pNP='';
pIDR='';
}
if(arfn_calc_idereg._p.length>0)_rargs([[['pTipo',arfn_calc_idereg._p[0]],['pNP',arfn_calc_idereg._p[1]],['pIDR',arfn_calc_idereg._p[2]]]],{eval:function(e){eval(e)}})
arfn_calc_idereg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_calc_idereg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_calc_idereg._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_calc_idereg._s.SetParameterString('pNP',WtA(pNP,'C'));
arfn_calc_idereg._s.SetParameterString('pIDR',WtA(pIDR,'C'));
arfn_calc_idereg._s.SetParameterString('m_bApplet','true');
arfn_calc_idereg._s.CallServlet('arfn_calc_idereg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_calc_idereg._s.errmsg;
}
return arfn_calc_idereg._s.GetString();
}
arfn_calc_idereg.CtxLoad_ = function(){return []}
