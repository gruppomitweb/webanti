function arrt_cf_inviosaldi() {
var w_anno;
var w_a_data;
var w_dadata;
var w_fileprodotto;
var w_flgann;
var w_flgsos;
var w_flgope;
var w_nomefile;
var m_Caller
arrt_cf_inviosaldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_fileprodotto=m_Caller.GetString('w_fileprodotto','C',0,0);
w_flgann=m_Caller.GetString('w_flgann','C',0,0);
w_flgsos=m_Caller.GetString('w_flgsos','C',0,0);
w_flgope=m_Caller.GetString('w_flgope','C',0,0);
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
arrt_cf_inviosaldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cf_inviosaldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cf_inviosaldi._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_fileprodotto',WtA(w_fileprodotto,'C'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_flgann',WtA(w_flgann,'C'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_flgsos',WtA(w_flgsos,'C'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_flgope',WtA(w_flgope,'C'));
arrt_cf_inviosaldi._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_cf_inviosaldi._s.SetParameterString('m_bApplet','true');
arrt_cf_inviosaldi._s.CallServlet('arrt_cf_inviosaldi');
m_Caller.SetNumber('w_anno','N',0,0,arrt_cf_inviosaldi._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_cf_inviosaldi._s.GetCallerDateVar('w_a_data')));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_cf_inviosaldi._s.GetCallerDateVar('w_dadata')));
m_Caller.SetString('w_fileprodotto','C',0,0,arrt_cf_inviosaldi._s.GetCallerStringVar('w_fileprodotto'));
m_Caller.SetString('w_flgann','C',0,0,arrt_cf_inviosaldi._s.GetCallerStringVar('w_flgann'));
m_Caller.SetString('w_flgsos','C',0,0,arrt_cf_inviosaldi._s.GetCallerStringVar('w_flgsos'));
m_Caller.SetString('w_flgope','C',0,0,arrt_cf_inviosaldi._s.GetCallerStringVar('w_flgope'));
m_Caller.SetString('w_nomefile','C',0,0,arrt_cf_inviosaldi._s.GetCallerStringVar('w_nomefile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cf_inviosaldi._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_cf_inviosaldi.CtxLoad_ = function(){return []}
