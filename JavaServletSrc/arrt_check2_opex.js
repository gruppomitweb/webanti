function arrt_check2_opex() {
var w_anno;
var m_Caller
arrt_check2_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno=0;
}
if(arrt_check2_opex._p.length>0)_rargs([[['w_anno',arrt_check2_opex._p[0]]]],{eval:function(e){eval(e)}})
arrt_check2_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_check2_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_check2_opex._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_check2_opex._s.SetParameterString('m_bApplet','true');
arrt_check2_opex._s.CallServlet('arrt_check2_opex');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_check2_opex._s.errmsg;
}
return arrt_check2_opex._s.GetDouble();
}
arrt_check2_opex.CtxLoad_ = function(){return []}
