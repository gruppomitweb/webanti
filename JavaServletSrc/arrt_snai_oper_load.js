function arrt_snai_oper_load() {
var pNumOpe;
var pFlgT;
var pAgenzia;
var m_Caller
arrt_snai_oper_load._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNumOpe='';
pFlgT='';
pAgenzia='';
}
if(arrt_snai_oper_load._p.length>0)_rargs([[['pNumOpe',arrt_snai_oper_load._p[0]],['pFlgT',arrt_snai_oper_load._p[1]],['pAgenzia',arrt_snai_oper_load._p[2]]]],{eval:function(e){eval(e)}})
arrt_snai_oper_load._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_snai_oper_load._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_snai_oper_load._s.SetParameterString('pNumOpe',WtA(pNumOpe,'C'));
arrt_snai_oper_load._s.SetParameterString('pFlgT',WtA(pFlgT,'C'));
arrt_snai_oper_load._s.SetParameterString('pAgenzia',WtA(pAgenzia,'C'));
arrt_snai_oper_load._s.SetParameterString('m_bApplet','true');
arrt_snai_oper_load._s.CallServlet('arrt_snai_oper_load');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_snai_oper_load._s.errmsg;
}
}
arrt_snai_oper_load.CtxLoad_ = function(){return []}
