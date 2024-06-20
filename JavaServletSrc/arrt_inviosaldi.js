function arrt_inviosaldi() {
var w_anno;
var w_a_data;
var w_dadata;
var w_flgcod;
var w_flgstp;
var w_flgnum;
var m_Caller
arrt_inviosaldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_flgcod=m_Caller.GetString('w_flgcod','C',0,0);
w_flgstp=m_Caller.GetString('w_flgstp','C',0,0);
w_flgnum=m_Caller.GetString('w_flgnum','C',0,0);
arrt_inviosaldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_inviosaldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_inviosaldi._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_inviosaldi._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_inviosaldi._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_inviosaldi._s.SetCallerStringVar('w_flgcod',WtA(w_flgcod,'C'));
arrt_inviosaldi._s.SetCallerStringVar('w_flgstp',WtA(w_flgstp,'C'));
arrt_inviosaldi._s.SetCallerStringVar('w_flgnum',WtA(w_flgnum,'C'));
arrt_inviosaldi._s.SetParameterString('m_bApplet','true');
arrt_inviosaldi._s.CallServlet('arrt_inviosaldi');
m_Caller.SetNumber('w_anno','N',0,0,arrt_inviosaldi._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_inviosaldi._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_inviosaldi._s.GetCallerDateVar('w_dadata')));
m_Caller.SetString('w_flgcod','C',0,0,arrt_inviosaldi._s.GetCallerStringVar('w_flgcod'));
m_Caller.SetString('w_flgstp','C',0,0,arrt_inviosaldi._s.GetCallerStringVar('w_flgstp'));
m_Caller.SetString('w_flgnum','C',0,0,arrt_inviosaldi._s.GetCallerStringVar('w_flgnum'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_inviosaldi._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_inviosaldi.CtxLoad_ = function(){return []}
