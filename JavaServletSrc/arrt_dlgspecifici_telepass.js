function arrt_dlgspecifici_telepass() {
var w_codinter;
var w_tipinter;
var m_Caller
arrt_dlgspecifici_telepass._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_codinter=m_Caller.GetString('w_codinter','C',0,0);
w_tipinter=m_Caller.GetString('w_tipinter','C',0,0);
arrt_dlgspecifici_telepass._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_dlgspecifici_telepass._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_dlgspecifici_telepass._s.SetCallerStringVar('w_codinter',WtA(w_codinter,'C'));
arrt_dlgspecifici_telepass._s.SetCallerStringVar('w_tipinter',WtA(w_tipinter,'C'));
arrt_dlgspecifici_telepass._s.SetParameterString('m_bApplet','true');
arrt_dlgspecifici_telepass._s.CallServlet('arrt_dlgspecifici_telepass');
m_Caller.SetString('w_codinter','C',0,0,arrt_dlgspecifici_telepass._s.GetCallerStringVar('w_codinter'));
m_Caller.SetString('w_tipinter','C',0,0,arrt_dlgspecifici_telepass._s.GetCallerStringVar('w_tipinter'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_dlgspecifici_telepass._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_dlgspecifici_telepass.CtxLoad_ = function(){return []}
