function agg_foto_moneygram() {
var m_Caller
agg_foto_moneygram._p=_rargs(arguments,{eval:function(e){eval(e)}})
agg_foto_moneygram._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
agg_foto_moneygram._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
agg_foto_moneygram._s.SetParameterString('m_bApplet','true');
agg_foto_moneygram._s.CallServlet('agg_foto_moneygram');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=agg_foto_moneygram._s.errmsg;
}
}
agg_foto_moneygram.CtxLoad_ = function(){return []}
