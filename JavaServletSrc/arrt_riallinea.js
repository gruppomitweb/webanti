function arrt_riallinea() {
var w_rapage;
var w_rapuif;
var m_Caller
arrt_riallinea._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_rapage=m_Caller.GetString('w_rapage','C',0,0);
w_rapuif=m_Caller.GetString('w_rapuif','C',0,0);
arrt_riallinea._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_riallinea._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_riallinea._s.SetCallerStringVar('w_rapage',WtA(w_rapage,'C'));
arrt_riallinea._s.SetCallerStringVar('w_rapuif',WtA(w_rapuif,'C'));
arrt_riallinea._s.SetParameterString('m_bApplet','true');
arrt_riallinea._s.CallServlet('arrt_riallinea');
m_Caller.SetString('w_rapage','C',0,0,arrt_riallinea._s.GetCallerStringVar('w_rapage'));
m_Caller.SetString('w_rapuif','C',0,0,arrt_riallinea._s.GetCallerStringVar('w_rapuif'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_riallinea._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_riallinea.CtxLoad_ = function(){return []}
