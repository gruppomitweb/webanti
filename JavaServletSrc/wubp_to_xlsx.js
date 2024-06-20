function wubp_to_xlsx() {
var m_Caller
wubp_to_xlsx._p=_rargs(arguments,{eval:function(e){eval(e)}})
wubp_to_xlsx._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
wubp_to_xlsx._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
wubp_to_xlsx._s.SetParameterString('m_bApplet','true');
wubp_to_xlsx._s.CallServlet('wubp_to_xlsx');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=wubp_to_xlsx._s.errmsg;
}
}
wubp_to_xlsx.CtxLoad_ = function(){return []}
