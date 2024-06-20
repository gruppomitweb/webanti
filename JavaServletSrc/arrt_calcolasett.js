function arrt_calcolasett() {
var w_SOTGRUP;
var w_RAMOGRUP;
var w_SETTSINT;
var w_OLDSETSIN;
var w_DESCUIC;
var w_ATTIV;
var w_tipsot;
var m_Caller
arrt_calcolasett._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_SOTGRUP=m_Caller.GetString('w_SOTGRUP','C',0,0);
w_RAMOGRUP=m_Caller.GetString('w_RAMOGRUP','C',0,0);
w_SETTSINT=m_Caller.GetString('w_SETTSINT','C',0,0);
w_OLDSETSIN=m_Caller.GetString('w_OLDSETSIN','C',0,0);
w_DESCUIC=m_Caller.GetString('w_DESCUIC','C',0,0);
w_ATTIV=m_Caller.GetString('w_ATTIV','C',0,0);
w_tipsot=m_Caller.GetString('w_tipsot','C',0,0);
arrt_calcolasett._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calcolasett._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calcolasett._s.SetCallerStringVar('w_SOTGRUP',WtA(w_SOTGRUP,'C'));
arrt_calcolasett._s.SetCallerStringVar('w_RAMOGRUP',WtA(w_RAMOGRUP,'C'));
arrt_calcolasett._s.SetCallerStringVar('w_SETTSINT',WtA(w_SETTSINT,'C'));
arrt_calcolasett._s.SetCallerStringVar('w_OLDSETSIN',WtA(w_OLDSETSIN,'C'));
arrt_calcolasett._s.SetCallerStringVar('w_DESCUIC',WtA(w_DESCUIC,'C'));
arrt_calcolasett._s.SetCallerStringVar('w_ATTIV',WtA(w_ATTIV,'C'));
arrt_calcolasett._s.SetCallerStringVar('w_tipsot',WtA(w_tipsot,'C'));
arrt_calcolasett._s.SetParameterString('m_bApplet','true');
arrt_calcolasett._s.CallServlet('arrt_calcolasett');
m_Caller.SetString('w_SOTGRUP','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_SOTGRUP'));
m_Caller.SetString('w_RAMOGRUP','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_RAMOGRUP'));
m_Caller.SetString('w_SETTSINT','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_SETTSINT'));
m_Caller.SetString('w_OLDSETSIN','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_OLDSETSIN'));
m_Caller.SetString('w_DESCUIC','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_DESCUIC'));
m_Caller.SetString('w_ATTIV','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_ATTIV'));
m_Caller.SetString('w_tipsot','C',0,0,arrt_calcolasett._s.GetCallerStringVar('w_tipsot'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calcolasett._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_calcolasett.CtxLoad_ = function(){return []}
