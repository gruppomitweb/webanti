function arrt_estrai_bp_check_wu() {
var pAnno;
var pMese;
var pTipo;
var m_Caller
arrt_estrai_bp_check_wu._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pMese=0;
pTipo='';
}
if(arrt_estrai_bp_check_wu._p.length>0)_rargs([[['pAnno',arrt_estrai_bp_check_wu._p[0]],['pMese',arrt_estrai_bp_check_wu._p[1]],['pTipo',arrt_estrai_bp_check_wu._p[2]]]],{eval:function(e){eval(e)}})
arrt_estrai_bp_check_wu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_bp_check_wu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_bp_check_wu._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arrt_estrai_bp_check_wu._s.SetParameterString('pMese',WtA(pMese,'N'));
arrt_estrai_bp_check_wu._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_estrai_bp_check_wu._s.SetParameterString('m_bApplet','true');
arrt_estrai_bp_check_wu._s.CallServlet('arrt_estrai_bp_check_wu');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_bp_check_wu._s.errmsg;
}
return arrt_estrai_bp_check_wu._s.GetString();
}
arrt_estrai_bp_check_wu.CtxLoad_ = function(){return []}
