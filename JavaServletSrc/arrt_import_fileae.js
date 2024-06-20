function arrt_import_fileae() {
var w_offset;
var w_f_denom;
var w_prefrap;
var w_f_ricaui;
var w_codval;
var w_impzip;
var w_tipofile;
var w_faggp;
var w_faggr;
var w_oldinter;
var m_Caller
arrt_import_fileae._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_offset=m_Caller.GetNumber('w_offset','N',0,0);
w_f_denom=m_Caller.GetString('w_f_denom','C',0,0);
w_prefrap=m_Caller.GetString('w_prefrap','C',0,0);
w_f_ricaui=m_Caller.GetString('w_f_ricaui','C',0,0);
w_codval=m_Caller.GetString('w_codval','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_tipofile=m_Caller.GetString('w_tipofile','C',0,0);
w_faggp=m_Caller.GetString('w_faggp','C',0,0);
w_faggr=m_Caller.GetString('w_faggr','C',0,0);
w_oldinter=m_Caller.GetString('w_oldinter','C',0,0);
arrt_import_fileae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_fileae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_fileae._s.SetCallerStringVar('w_offset',WtA(w_offset,'N'));
arrt_import_fileae._s.SetCallerStringVar('w_f_denom',WtA(w_f_denom,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_prefrap',WtA(w_prefrap,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_f_ricaui',WtA(w_f_ricaui,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_codval',WtA(w_codval,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_import_fileae._s.SetCallerStringVar('w_tipofile',WtA(w_tipofile,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_faggp',WtA(w_faggp,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_faggr',WtA(w_faggr,'C'));
arrt_import_fileae._s.SetCallerStringVar('w_oldinter',WtA(w_oldinter,'C'));
arrt_import_fileae._s.SetParameterString('m_bApplet','true');
arrt_import_fileae._s.CallServlet('arrt_import_fileae');
m_Caller.SetNumber('w_offset','N',0,0,arrt_import_fileae._s.GetCallerDoubleVar('w_offset'));
m_Caller.SetString('w_f_denom','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_f_denom'));
m_Caller.SetString('w_prefrap','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_prefrap'));
m_Caller.SetString('w_f_ricaui','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_f_ricaui'));
m_Caller.SetString('w_codval','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_codval'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_import_fileae._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetString('w_tipofile','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_tipofile'));
m_Caller.SetString('w_faggp','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_faggp'));
m_Caller.SetString('w_faggr','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_faggr'));
m_Caller.SetString('w_oldinter','C',0,0,arrt_import_fileae._s.GetCallerStringVar('w_oldinter'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_fileae._s.errmsg;
}
CalledBatchEnd();
}
arrt_import_fileae.CtxLoad_ = function(){return []}
