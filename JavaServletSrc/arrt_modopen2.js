function arrt_modopen2() {
var w_datarett;
var w_newcoint;
var w_newtipoag;
var w_oldcoint;
var w_oldfile;
var w_oldidbase;
var w_oldprog;
var w_oldrappo;
var w_oldrnumrig;
var w_oldtipoag;
var w_ragione;
var m_Caller
arrt_modopen2._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datarett=m_Caller.GetDate('w_datarett','D',0,0);
w_newcoint=m_Caller.GetString('w_newcoint','C',0,0);
w_newtipoag=m_Caller.GetString('w_newtipoag','C',0,0);
w_oldcoint=m_Caller.GetString('w_oldcoint','C',0,0);
w_oldfile=m_Caller.GetString('w_oldfile','C',0,0);
w_oldidbase=m_Caller.GetString('w_oldidbase','C',0,0);
w_oldprog=m_Caller.GetString('w_oldprog','C',0,0);
w_oldrappo=m_Caller.GetString('w_oldrappo','C',0,0);
w_oldrnumrig=m_Caller.GetNumber('w_oldrnumrig','N',0,0);
w_oldtipoag=m_Caller.GetString('w_oldtipoag','C',0,0);
w_ragione=m_Caller.GetString('w_ragione','C',0,0);
arrt_modopen2._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_modopen2._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_modopen2._s.SetCallerStringVar('w_datarett',WtA(w_datarett,'D'));
arrt_modopen2._s.SetCallerStringVar('w_newcoint',WtA(w_newcoint,'C'));
arrt_modopen2._s.SetCallerStringVar('w_newtipoag',WtA(w_newtipoag,'C'));
arrt_modopen2._s.SetCallerStringVar('w_oldcoint',WtA(w_oldcoint,'C'));
arrt_modopen2._s.SetCallerStringVar('w_oldfile',WtA(w_oldfile,'C'));
arrt_modopen2._s.SetCallerStringVar('w_oldidbase',WtA(w_oldidbase,'C'));
arrt_modopen2._s.SetCallerStringVar('w_oldprog',WtA(w_oldprog,'C'));
arrt_modopen2._s.SetCallerStringVar('w_oldrappo',WtA(w_oldrappo,'C'));
arrt_modopen2._s.SetCallerStringVar('w_oldrnumrig',WtA(w_oldrnumrig,'N'));
arrt_modopen2._s.SetCallerStringVar('w_oldtipoag',WtA(w_oldtipoag,'C'));
arrt_modopen2._s.SetCallerStringVar('w_ragione',WtA(w_ragione,'C'));
arrt_modopen2._s.SetParameterString('m_bApplet','true');
arrt_modopen2._s.CallServlet('arrt_modopen2');
m_Caller.SetDate('w_datarett','D',0,0,DateFromApplet(arrt_modopen2._s.GetCallerDateVar('w_datarett')));
m_Caller.SetString('w_newcoint','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_newcoint'));
m_Caller.SetString('w_newtipoag','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_newtipoag'));
m_Caller.SetString('w_oldcoint','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_oldcoint'));
m_Caller.SetString('w_oldfile','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_oldfile'));
m_Caller.SetString('w_oldidbase','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_oldidbase'));
m_Caller.SetString('w_oldprog','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_oldprog'));
m_Caller.SetString('w_oldrappo','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_oldrappo'));
m_Caller.SetNumber('w_oldrnumrig','N',0,0,arrt_modopen2._s.GetCallerDoubleVar('w_oldrnumrig'));
m_Caller.SetString('w_oldtipoag','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_oldtipoag'));
m_Caller.SetString('w_ragione','C',0,0,arrt_modopen2._s.GetCallerStringVar('w_ragione'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_modopen2._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_modopen2.CtxLoad_ = function(){return []}
