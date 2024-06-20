function arrt_wutrxchk_aua_edit() {
var pIDTrx;
var m_Caller
arrt_wutrxchk_aua_edit._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIDTrx=0;
}
if(arrt_wutrxchk_aua_edit._p.length>0)_rargs([[['pIDTrx',arrt_wutrxchk_aua_edit._p[0]]]],{eval:function(e){eval(e)}})
arrt_wutrxchk_aua_edit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wutrxchk_aua_edit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wutrxchk_aua_edit._s.SetParameterString('pIDTrx',WtA(pIDTrx,'N'));
arrt_wutrxchk_aua_edit._s.SetParameterString('m_bApplet','true');
arrt_wutrxchk_aua_edit._s.CallServlet('arrt_wutrxchk_aua_edit');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wutrxchk_aua_edit._s.errmsg;
}
return arrt_wutrxchk_aua_edit._s.GetDouble();
}
arrt_wutrxchk_aua_edit.CtxLoad_ = function(){return []}
