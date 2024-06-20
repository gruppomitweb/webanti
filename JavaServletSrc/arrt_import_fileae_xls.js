function arrt_import_fileae_xls() {
var w_msgproc;
var w_prefrap;
var w_codval;
var w_f_ricaui;
var m_Caller
arrt_import_fileae_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_prefrap=m_Caller.GetString('w_prefrap','C',0,0);
w_codval=m_Caller.GetString('w_codval','C',0,0);
w_f_ricaui=m_Caller.GetString('w_f_ricaui','C',0,0);
arrt_import_fileae_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_fileae_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_fileae_xls._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_import_fileae_xls._s.SetCallerStringVar('w_prefrap',WtA(w_prefrap,'C'));
arrt_import_fileae_xls._s.SetCallerStringVar('w_codval',WtA(w_codval,'C'));
arrt_import_fileae_xls._s.SetCallerStringVar('w_f_ricaui',WtA(w_f_ricaui,'C'));
arrt_import_fileae_xls._s.SetParameterString('m_bApplet','true');
arrt_import_fileae_xls._s.CallServlet('arrt_import_fileae_xls');
m_Caller.SetString('w_msgproc','M',0,0,arrt_import_fileae_xls._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetString('w_prefrap','C',0,0,arrt_import_fileae_xls._s.GetCallerStringVar('w_prefrap'));
m_Caller.SetString('w_codval','C',0,0,arrt_import_fileae_xls._s.GetCallerStringVar('w_codval'));
m_Caller.SetString('w_f_ricaui','C',0,0,arrt_import_fileae_xls._s.GetCallerStringVar('w_f_ricaui'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_fileae_xls._s.errmsg;
}
CalledBatchEnd();
}
arrt_import_fileae_xls.CtxLoad_ = function(){return []}
