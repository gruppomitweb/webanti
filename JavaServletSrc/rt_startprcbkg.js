function rt_startprcbkg() {
var m_Caller
rt_startprcbkg._p=_rargs(arguments,{eval:function(e){eval(e)}})
rt_startprcbkg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
rt_startprcbkg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
rt_startprcbkg._s.SetParameterString('m_bApplet','true');
rt_startprcbkg._s.CallServlet('rt_startprcbkg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=rt_startprcbkg._s.errmsg;
}
}
rt_startprcbkg.CtxLoad_ = function(){return []}
