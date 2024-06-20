function arfn_estrai_bp_wu() {
var pAnno;
var pMese;
var m_Caller
arfn_estrai_bp_wu._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pMese=0;
}
if(arfn_estrai_bp_wu._p.length>0)_rargs([[['pAnno',arfn_estrai_bp_wu._p[0]],['pMese',arfn_estrai_bp_wu._p[1]]]],{eval:function(e){eval(e)}})
arfn_estrai_bp_wu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_estrai_bp_wu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_estrai_bp_wu._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_estrai_bp_wu._s.SetParameterString('pMese',WtA(pMese,'N'));
arfn_estrai_bp_wu._s.SetParameterString('m_bApplet','true');
arfn_estrai_bp_wu._s.CallServlet('arfn_estrai_bp_wu');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_estrai_bp_wu._s.errmsg;
}
return arfn_estrai_bp_wu._s.GetString();
}
arfn_estrai_bp_wu.CtxLoad_ = function(){return []}
