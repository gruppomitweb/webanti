function arrt_wutrxchk_save_mask() {
var m_Caller
arrt_wutrxchk_save_mask._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrt_wutrxchk_save_mask._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wutrxchk_save_mask._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wutrxchk_save_mask._s.SetParameterString('m_bApplet','true');
arrt_wutrxchk_save_mask._s.CallServlet('arrt_wutrxchk_save_mask');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wutrxchk_save_mask._s.errmsg;
}
return arrt_wutrxchk_save_mask._s.GetString();
}
arrt_wutrxchk_save_mask.CtxLoad_ = function(){return []}
