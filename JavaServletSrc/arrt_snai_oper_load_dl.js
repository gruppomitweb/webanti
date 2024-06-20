function arrt_snai_oper_load_dl() {
var pNumOpe;
var pFlgT;
var m_Caller
arrt_snai_oper_load_dl._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNumOpe='';
pFlgT='';
}
if(arrt_snai_oper_load_dl._p.length>0)_rargs([[['pNumOpe',arrt_snai_oper_load_dl._p[0]],['pFlgT',arrt_snai_oper_load_dl._p[1]]]],{eval:function(e){eval(e)}})
arrt_snai_oper_load_dl._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_snai_oper_load_dl._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_snai_oper_load_dl._s.SetParameterString('pNumOpe',WtA(pNumOpe,'C'));
arrt_snai_oper_load_dl._s.SetParameterString('pFlgT',WtA(pFlgT,'C'));
arrt_snai_oper_load_dl._s.SetParameterString('m_bApplet','true');
arrt_snai_oper_load_dl._s.CallServlet('arrt_snai_oper_load_dl');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_snai_oper_load_dl._s.errmsg;
}
}
arrt_snai_oper_load_dl.CtxLoad_ = function(){return []}
