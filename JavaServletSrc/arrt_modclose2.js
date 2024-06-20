function arrt_modclose2() {
var w_datarett;
var w_oldidbase;
var w_oldprog;
var w_oldrappo;
var w_oldrnumrig;
var w_oldfile;
var m_Caller
arrt_modclose2._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datarett=m_Caller.GetDate('w_datarett','D',0,0);
w_oldidbase=m_Caller.GetString('w_oldidbase','C',0,0);
w_oldprog=m_Caller.GetString('w_oldprog','C',0,0);
w_oldrappo=m_Caller.GetString('w_oldrappo','C',0,0);
w_oldrnumrig=m_Caller.GetNumber('w_oldrnumrig','N',0,0);
w_oldfile=m_Caller.GetString('w_oldfile','C',0,0);
arrt_modclose2._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_modclose2._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_modclose2._s.SetCallerStringVar('w_datarett',WtA(w_datarett,'D'));
arrt_modclose2._s.SetCallerStringVar('w_oldidbase',WtA(w_oldidbase,'C'));
arrt_modclose2._s.SetCallerStringVar('w_oldprog',WtA(w_oldprog,'C'));
arrt_modclose2._s.SetCallerStringVar('w_oldrappo',WtA(w_oldrappo,'C'));
arrt_modclose2._s.SetCallerStringVar('w_oldrnumrig',WtA(w_oldrnumrig,'N'));
arrt_modclose2._s.SetCallerStringVar('w_oldfile',WtA(w_oldfile,'C'));
arrt_modclose2._s.SetParameterString('m_bApplet','true');
arrt_modclose2._s.CallServlet('arrt_modclose2');
m_Caller.SetDate('w_datarett','D',0,0,DateFromApplet(arrt_modclose2._s.GetCallerDateVar('w_datarett')));
m_Caller.SetString('w_oldidbase','C',0,0,arrt_modclose2._s.GetCallerStringVar('w_oldidbase'));
m_Caller.SetString('w_oldprog','C',0,0,arrt_modclose2._s.GetCallerStringVar('w_oldprog'));
m_Caller.SetString('w_oldrappo','C',0,0,arrt_modclose2._s.GetCallerStringVar('w_oldrappo'));
m_Caller.SetNumber('w_oldrnumrig','N',0,0,arrt_modclose2._s.GetCallerDoubleVar('w_oldrnumrig'));
m_Caller.SetString('w_oldfile','C',0,0,arrt_modclose2._s.GetCallerStringVar('w_oldfile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_modclose2._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_modclose2.CtxLoad_ = function(){return []}
