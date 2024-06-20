function aosrt_utility_indicatori_anomalie() {
var m_Caller
aosrt_utility_indicatori_anomalie._p=_rargs(arguments,{eval:function(e){eval(e)}})
aosrt_utility_indicatori_anomalie._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aosrt_utility_indicatori_anomalie._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aosrt_utility_indicatori_anomalie._s.SetParameterString('m_bApplet','true');
aosrt_utility_indicatori_anomalie._s.CallServlet('aosrt_utility_indicatori_anomalie');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aosrt_utility_indicatori_anomalie._s.errmsg;
}
}
aosrt_utility_indicatori_anomalie.CtxLoad_ = function(){return []}
