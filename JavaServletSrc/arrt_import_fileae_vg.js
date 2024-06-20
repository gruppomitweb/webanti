function arrt_import_fileae_vg() {
var w_offset;
var w_f_denom;
var w_prefrap;
var w_f_ricaui;
var w_codval;
var m_Caller
arrt_import_fileae_vg._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_offset=m_Caller.GetNumber('w_offset','N',0,0);
w_f_denom=m_Caller.GetString('w_f_denom','C',0,0);
w_prefrap=m_Caller.GetString('w_prefrap','C',0,0);
w_f_ricaui=m_Caller.GetString('w_f_ricaui','C',0,0);
w_codval=m_Caller.GetString('w_codval','C',0,0);
arrt_import_fileae_vg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_import_fileae_vg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_import_fileae_vg._s.SetCallerStringVar('w_offset',WtA(w_offset,'N'));
arrt_import_fileae_vg._s.SetCallerStringVar('w_f_denom',WtA(w_f_denom,'C'));
arrt_import_fileae_vg._s.SetCallerStringVar('w_prefrap',WtA(w_prefrap,'C'));
arrt_import_fileae_vg._s.SetCallerStringVar('w_f_ricaui',WtA(w_f_ricaui,'C'));
arrt_import_fileae_vg._s.SetCallerStringVar('w_codval',WtA(w_codval,'C'));
arrt_import_fileae_vg._s.SetParameterString('m_bApplet','true');
arrt_import_fileae_vg._s.CallServlet('arrt_import_fileae_vg');
m_Caller.SetNumber('w_offset','N',0,0,arrt_import_fileae_vg._s.GetCallerDoubleVar('w_offset'));
m_Caller.SetString('w_f_denom','C',0,0,arrt_import_fileae_vg._s.GetCallerStringVar('w_f_denom'));
m_Caller.SetString('w_prefrap','C',0,0,arrt_import_fileae_vg._s.GetCallerStringVar('w_prefrap'));
m_Caller.SetString('w_f_ricaui','C',0,0,arrt_import_fileae_vg._s.GetCallerStringVar('w_f_ricaui'));
m_Caller.SetString('w_codval','C',0,0,arrt_import_fileae_vg._s.GetCallerStringVar('w_codval'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_import_fileae_vg._s.errmsg;
}
CalledBatchEnd();
}
arrt_import_fileae_vg.CtxLoad_ = function(){return []}
