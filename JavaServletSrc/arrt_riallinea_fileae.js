function arrt_riallinea_fileae() {
var w_offset;
var w_f_denom;
var w_prefrap;
var w_f_ricaui;
var w_codval;
var w_impzip;
var w_tipofile;
var m_Caller
arrt_riallinea_fileae._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_offset=m_Caller.GetNumber('w_offset','N',0,0);
w_f_denom=m_Caller.GetString('w_f_denom','C',0,0);
w_prefrap=m_Caller.GetString('w_prefrap','C',0,0);
w_f_ricaui=m_Caller.GetString('w_f_ricaui','C',0,0);
w_codval=m_Caller.GetString('w_codval','C',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_tipofile=m_Caller.GetNumber('w_tipofile','N',0,0);
arrt_riallinea_fileae._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_riallinea_fileae._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_riallinea_fileae._s.SetCallerStringVar('w_offset',WtA(w_offset,'N'));
arrt_riallinea_fileae._s.SetCallerStringVar('w_f_denom',WtA(w_f_denom,'C'));
arrt_riallinea_fileae._s.SetCallerStringVar('w_prefrap',WtA(w_prefrap,'C'));
arrt_riallinea_fileae._s.SetCallerStringVar('w_f_ricaui',WtA(w_f_ricaui,'C'));
arrt_riallinea_fileae._s.SetCallerStringVar('w_codval',WtA(w_codval,'C'));
arrt_riallinea_fileae._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_riallinea_fileae._s.SetCallerStringVar('w_tipofile',WtA(w_tipofile,'N'));
arrt_riallinea_fileae._s.SetParameterString('m_bApplet','true');
arrt_riallinea_fileae._s.CallServlet('arrt_riallinea_fileae');
m_Caller.SetNumber('w_offset','N',0,0,arrt_riallinea_fileae._s.GetCallerDoubleVar('w_offset'));
m_Caller.SetString('w_f_denom','C',0,0,arrt_riallinea_fileae._s.GetCallerStringVar('w_f_denom'));
m_Caller.SetString('w_prefrap','C',0,0,arrt_riallinea_fileae._s.GetCallerStringVar('w_prefrap'));
m_Caller.SetString('w_f_ricaui','C',0,0,arrt_riallinea_fileae._s.GetCallerStringVar('w_f_ricaui'));
m_Caller.SetString('w_codval','C',0,0,arrt_riallinea_fileae._s.GetCallerStringVar('w_codval'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_riallinea_fileae._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetNumber('w_tipofile','N',0,0,arrt_riallinea_fileae._s.GetCallerDoubleVar('w_tipofile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_riallinea_fileae._s.errmsg;
}
CalledBatchEnd();
}
arrt_riallinea_fileae.CtxLoad_ = function(){return []}
