function arrt_ope_modopen2() {
var w_datarett;
var w_oldidbase;
var w_oldprog;
var w_oldrappo;
var w_oldfile;
var m_Caller
arrt_ope_modopen2._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_datarett=m_Caller.GetDate('w_datarett','D',0,0);
w_oldidbase=m_Caller.GetString('w_oldidbase','C',0,0);
w_oldprog=m_Caller.GetString('w_oldprog','C',0,0);
w_oldrappo=m_Caller.GetString('w_oldrappo','C',0,0);
w_oldfile=m_Caller.GetString('w_oldfile','C',0,0);
arrt_ope_modopen2._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ope_modopen2._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ope_modopen2._s.SetCallerStringVar('w_datarett',WtA(w_datarett,'D'));
arrt_ope_modopen2._s.SetCallerStringVar('w_oldidbase',WtA(w_oldidbase,'C'));
arrt_ope_modopen2._s.SetCallerStringVar('w_oldprog',WtA(w_oldprog,'C'));
arrt_ope_modopen2._s.SetCallerStringVar('w_oldrappo',WtA(w_oldrappo,'C'));
arrt_ope_modopen2._s.SetCallerStringVar('w_oldfile',WtA(w_oldfile,'C'));
arrt_ope_modopen2._s.SetParameterString('m_bApplet','true');
arrt_ope_modopen2._s.CallServlet('arrt_ope_modopen2');
m_Caller.SetDate('w_datarett','D',0,0,DateFromApplet(arrt_ope_modopen2._s.GetCallerDateVar('w_datarett')));
m_Caller.SetString('w_oldidbase','C',0,0,arrt_ope_modopen2._s.GetCallerStringVar('w_oldidbase'));
m_Caller.SetString('w_oldprog','C',0,0,arrt_ope_modopen2._s.GetCallerStringVar('w_oldprog'));
m_Caller.SetString('w_oldrappo','C',0,0,arrt_ope_modopen2._s.GetCallerStringVar('w_oldrappo'));
m_Caller.SetString('w_oldfile','C',0,0,arrt_ope_modopen2._s.GetCallerStringVar('w_oldfile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ope_modopen2._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_ope_modopen2.CtxLoad_ = function(){return []}
