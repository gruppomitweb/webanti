function arfn_snai_oper_load_multi() {
var pNumOpe;
var pFlgT;
var pAgenzia;
var m_Caller
arfn_snai_oper_load_multi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNumOpe='';
pFlgT='';
pAgenzia='';
}
if(arfn_snai_oper_load_multi._p.length>0)_rargs([[['pNumOpe',arfn_snai_oper_load_multi._p[0]],['pFlgT',arfn_snai_oper_load_multi._p[1]],['pAgenzia',arfn_snai_oper_load_multi._p[2]]]],{eval:function(e){eval(e)}})
arfn_snai_oper_load_multi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_snai_oper_load_multi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_snai_oper_load_multi._s.SetParameterString('pNumOpe',WtA(pNumOpe,'C'));
arfn_snai_oper_load_multi._s.SetParameterString('pFlgT',WtA(pFlgT,'C'));
arfn_snai_oper_load_multi._s.SetParameterString('pAgenzia',WtA(pAgenzia,'C'));
arfn_snai_oper_load_multi._s.SetParameterString('m_bApplet','true');
arfn_snai_oper_load_multi._s.CallServlet('arfn_snai_oper_load_multi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_snai_oper_load_multi._s.errmsg;
}
return arfn_snai_oper_load_multi._s.GetString();
}
arfn_snai_oper_load_multi.CtxLoad_ = function(){return []}
