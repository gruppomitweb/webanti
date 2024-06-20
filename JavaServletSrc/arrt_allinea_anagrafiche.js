function arrt_allinea_anagrafiche() {
var w_ccab;
var w_ccodfisc;
var w_rvalcampi;
var w_cutf8;
var w_cstandard;
var m_Caller
arrt_allinea_anagrafiche._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_ccab=m_Caller.GetNumber('w_ccab','N',0,0);
w_ccodfisc=m_Caller.GetNumber('w_ccodfisc','N',0,0);
w_rvalcampi=m_Caller.GetString('w_rvalcampi','C',0,0);
w_cutf8=m_Caller.GetNumber('w_cutf8','N',0,0);
w_cstandard=m_Caller.GetNumber('w_cstandard','N',0,0);
arrt_allinea_anagrafiche._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_anagrafiche._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_anagrafiche._s.SetCallerStringVar('w_ccab',WtA(w_ccab,'N'));
arrt_allinea_anagrafiche._s.SetCallerStringVar('w_ccodfisc',WtA(w_ccodfisc,'N'));
arrt_allinea_anagrafiche._s.SetCallerStringVar('w_rvalcampi',WtA(w_rvalcampi,'C'));
arrt_allinea_anagrafiche._s.SetCallerStringVar('w_cutf8',WtA(w_cutf8,'N'));
arrt_allinea_anagrafiche._s.SetCallerStringVar('w_cstandard',WtA(w_cstandard,'N'));
arrt_allinea_anagrafiche._s.SetParameterString('m_bApplet','true');
arrt_allinea_anagrafiche._s.CallServlet('arrt_allinea_anagrafiche');
m_Caller.SetNumber('w_ccab','N',0,0,arrt_allinea_anagrafiche._s.GetCallerDoubleVar('w_ccab'));
m_Caller.SetNumber('w_ccodfisc','N',0,0,arrt_allinea_anagrafiche._s.GetCallerDoubleVar('w_ccodfisc'));
m_Caller.SetString('w_rvalcampi','C',0,0,arrt_allinea_anagrafiche._s.GetCallerStringVar('w_rvalcampi'));
m_Caller.SetNumber('w_cutf8','N',0,0,arrt_allinea_anagrafiche._s.GetCallerDoubleVar('w_cutf8'));
m_Caller.SetNumber('w_cstandard','N',0,0,arrt_allinea_anagrafiche._s.GetCallerDoubleVar('w_cstandard'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_anagrafiche._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_allinea_anagrafiche.CtxLoad_ = function(){return []}
