function arrt_stplegami_elenco() {
var w_daRappo;
var w_aRappo;
var w_DaDatIni;
var w_ADatIni;
var w_DaDatFin;
var w_ADatFin;
var m_Caller
arrt_stplegami_elenco._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_daRappo=m_Caller.GetString('w_daRappo','C',0,0);
w_aRappo=m_Caller.GetString('w_aRappo','C',0,0);
w_DaDatIni=m_Caller.GetDate('w_DaDatIni','D',0,0);
w_ADatIni=m_Caller.GetDate('w_ADatIni','D',0,0);
w_DaDatFin=m_Caller.GetDate('w_DaDatFin','D',0,0);
w_ADatFin=m_Caller.GetDate('w_ADatFin','D',0,0);
arrt_stplegami_elenco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stplegami_elenco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stplegami_elenco._s.SetCallerStringVar('w_daRappo',WtA(w_daRappo,'C'));
arrt_stplegami_elenco._s.SetCallerStringVar('w_aRappo',WtA(w_aRappo,'C'));
arrt_stplegami_elenco._s.SetCallerStringVar('w_DaDatIni',WtA(w_DaDatIni,'D'));
arrt_stplegami_elenco._s.SetCallerStringVar('w_ADatIni',WtA(w_ADatIni,'D'));
arrt_stplegami_elenco._s.SetCallerStringVar('w_DaDatFin',WtA(w_DaDatFin,'D'));
arrt_stplegami_elenco._s.SetCallerStringVar('w_ADatFin',WtA(w_ADatFin,'D'));
arrt_stplegami_elenco._s.SetParameterString('m_bApplet','true');
arrt_stplegami_elenco._s.CallServlet('arrt_stplegami_elenco');
m_Caller.SetString('w_daRappo','C',0,0,arrt_stplegami_elenco._s.GetCallerStringVar('w_daRappo'));
m_Caller.SetString('w_aRappo','C',0,0,arrt_stplegami_elenco._s.GetCallerStringVar('w_aRappo'));
m_Caller.SetDate('w_DaDatIni','D',0,0,DateFromApplet(arrt_stplegami_elenco._s.GetCallerDateVar('w_DaDatIni')));
m_Caller.SetDate('w_ADatIni','D',0,0,DateFromApplet(arrt_stplegami_elenco._s.GetCallerDateVar('w_ADatIni')));
m_Caller.SetDate('w_DaDatFin','D',0,0,DateFromApplet(arrt_stplegami_elenco._s.GetCallerDateVar('w_DaDatFin')));
m_Caller.SetDate('w_ADatFin','D',0,0,DateFromApplet(arrt_stplegami_elenco._s.GetCallerDateVar('w_ADatFin')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stplegami_elenco._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stplegami_elenco.CtxLoad_ = function(){return []}
