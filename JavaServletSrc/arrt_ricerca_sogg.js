function arrt_ricerca_sogg() {
var w_criterio;
var w_denomin;
var w_codfisc;
var w_simili;
var w_flgnega;
var w_flgnote;
var m_Caller
arrt_ricerca_sogg._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_criterio=m_Caller.GetString('w_criterio','C',0,0);
w_denomin=m_Caller.GetString('w_denomin','C',0,0);
w_codfisc=m_Caller.GetString('w_codfisc','C',0,0);
w_simili=m_Caller.GetString('w_simili','C',0,0);
w_flgnega=m_Caller.GetString('w_flgnega','C',0,0);
w_flgnote=m_Caller.GetString('w_flgnote','C',0,0);
arrt_ricerca_sogg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ricerca_sogg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ricerca_sogg._s.SetCallerStringVar('w_criterio',WtA(w_criterio,'C'));
arrt_ricerca_sogg._s.SetCallerStringVar('w_denomin',WtA(w_denomin,'C'));
arrt_ricerca_sogg._s.SetCallerStringVar('w_codfisc',WtA(w_codfisc,'C'));
arrt_ricerca_sogg._s.SetCallerStringVar('w_simili',WtA(w_simili,'C'));
arrt_ricerca_sogg._s.SetCallerStringVar('w_flgnega',WtA(w_flgnega,'C'));
arrt_ricerca_sogg._s.SetCallerStringVar('w_flgnote',WtA(w_flgnote,'C'));
arrt_ricerca_sogg._s.SetParameterString('m_bApplet','true');
arrt_ricerca_sogg._s.CallServlet('arrt_ricerca_sogg');
m_Caller.SetString('w_criterio','C',0,0,arrt_ricerca_sogg._s.GetCallerStringVar('w_criterio'));
m_Caller.SetString('w_denomin','C',0,0,arrt_ricerca_sogg._s.GetCallerStringVar('w_denomin'));
m_Caller.SetString('w_codfisc','C',0,0,arrt_ricerca_sogg._s.GetCallerStringVar('w_codfisc'));
m_Caller.SetString('w_simili','C',0,0,arrt_ricerca_sogg._s.GetCallerStringVar('w_simili'));
m_Caller.SetString('w_flgnega','C',0,0,arrt_ricerca_sogg._s.GetCallerStringVar('w_flgnega'));
m_Caller.SetString('w_flgnote','C',0,0,arrt_ricerca_sogg._s.GetCallerStringVar('w_flgnote'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ricerca_sogg._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_ricerca_sogg.CtxLoad_ = function(){return []}
