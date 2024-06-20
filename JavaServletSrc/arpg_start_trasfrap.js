function arpg_start_trasfrap() {
var m_Caller
arpg_start_trasfrap._p=_rargs(arguments,{eval:function(e){eval(e)}})
arpg_start_trasfrap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arpg_start_trasfrap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arpg_start_trasfrap._s.SetParameterString('m_bApplet','true');
arpg_start_trasfrap._s.CallServlet('arpg_start_trasfrap');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arpg_start_trasfrap._s.errmsg;
}
}
arpg_start_trasfrap.CtxLoad_ = function(){return []}
