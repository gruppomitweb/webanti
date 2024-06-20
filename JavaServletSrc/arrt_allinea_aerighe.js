function arrt_allinea_aerighe() {
var w_msgproc;
var w_scelta;
var w_impzip;
var w_gMsgProc;
var w_nomefile;
var m_Caller
arrt_allinea_aerighe._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_scelta=m_Caller.GetNumber('w_scelta','N',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_gMsgProc=m_Caller.GetString('gMsgProc','M',0,0);
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
arrt_allinea_aerighe._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_aerighe._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_aerighe._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_allinea_aerighe._s.SetCallerStringVar('w_scelta',WtA(w_scelta,'N'));
arrt_allinea_aerighe._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_allinea_aerighe._s.SetCallerStringVar('gMsgProc',WtA(w_gMsgProc,'M'));
arrt_allinea_aerighe._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_allinea_aerighe._s.SetParameterString('m_bApplet','true');
arrt_allinea_aerighe._s.CallServlet('arrt_allinea_aerighe');
m_Caller.SetString('w_msgproc','M',0,0,arrt_allinea_aerighe._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetNumber('w_scelta','N',0,0,arrt_allinea_aerighe._s.GetCallerDoubleVar('w_scelta'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_allinea_aerighe._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetString('w_gMsgProc','M',0,0,arrt_allinea_aerighe._s.GetCallerStringVar('gMsgProc'));
m_Caller.SetString('w_nomefile','C',0,0,arrt_allinea_aerighe._s.GetCallerStringVar('w_nomefile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_aerighe._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_aerighe.CtxLoad_ = function(){return []}
