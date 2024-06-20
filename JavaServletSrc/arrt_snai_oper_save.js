function arrt_snai_oper_save() {
var pSNAINUMOPE;
var pTipo;
var pAzi;
var m_Caller
arrt_snai_oper_save._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSNAINUMOPE='';
pTipo='';
pAzi='';
}
if(arrt_snai_oper_save._p.length>0)_rargs([[['pSNAINUMOPE',arrt_snai_oper_save._p[0]],['pTipo',arrt_snai_oper_save._p[1]],['pAzi',arrt_snai_oper_save._p[2]]]],{eval:function(e){eval(e)}})
arrt_snai_oper_save._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_snai_oper_save._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_snai_oper_save._s.SetParameterString('pSNAINUMOPE',WtA(pSNAINUMOPE,'C'));
arrt_snai_oper_save._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_snai_oper_save._s.SetParameterString('pAzi',WtA(pAzi,'C'));
arrt_snai_oper_save._s.SetParameterString('m_bApplet','true');
arrt_snai_oper_save._s.CallServlet('arrt_snai_oper_save');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_snai_oper_save._s.errmsg;
}
}
arrt_snai_oper_save.CtxLoad_ = function(){return []}
