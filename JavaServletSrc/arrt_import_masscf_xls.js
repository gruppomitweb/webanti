function arrt_import_masscf_xls() {
var w_nomefile;
var w_flgfam;
var w_flgwuker;
var m_Caller
arrt_import_masscf_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
w_flgfam=m_Caller.GetString('w_flgfam','C',0,0);
w_flgwuker=m_Caller.GetString('w_flgwuker','C',0,0);
arrt_import_masscf_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_masscf_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_masscf_xls._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_import_masscf_xls._s.SetCallerStringVar('w_flgfam',WtA(w_flgfam,'C'));
arrt_import_masscf_xls._s.SetCallerStringVar('w_flgwuker',WtA(w_flgwuker,'C'));
arrt_import_masscf_xls._s.SetParameterString('m_bApplet','true');
arrt_import_masscf_xls._s.CallServlet('arrt_import_masscf_xls');
m_Caller.SetString('w_nomefile','C',0,0,arrt_import_masscf_xls._s.GetCallerStringVar('w_nomefile'));
m_Caller.SetString('w_flgfam','C',0,0,arrt_import_masscf_xls._s.GetCallerStringVar('w_flgfam'));
m_Caller.SetString('w_flgwuker','C',0,0,arrt_import_masscf_xls._s.GetCallerStringVar('w_flgwuker'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_masscf_xls._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_import_masscf_xls.CtxLoad_ = function(){return []}
