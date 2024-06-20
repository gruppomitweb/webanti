function arrt_dlgspecifici() {
var w_codinter;
var w_tipinter;
var w_flgint;
var w_flgrae;
var w_flgsto;
var w_flgdel;
var w_passwd;
var w_tipofile;
var w_numreg;
var w_numrec;
var m_Caller
arrt_dlgspecifici._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_codinter=m_Caller.GetString('w_codinter','C',0,0);
w_tipinter=m_Caller.GetString('w_tipinter','C',0,0);
w_flgint=m_Caller.GetString('w_flgint','C',0,0);
w_flgrae=m_Caller.GetString('w_flgrae','C',0,0);
w_flgsto=m_Caller.GetString('w_flgsto','C',0,0);
w_flgdel=m_Caller.GetString('w_flgdel','C',0,0);
w_passwd=m_Caller.GetString('w_passwd','C',0,0);
w_tipofile=m_Caller.GetString('w_tipofile','C',0,0);
w_numreg=m_Caller.GetNumber('w_numreg','N',0,0);
w_numrec=m_Caller.GetNumber('w_numrec','N',0,0);
arrt_dlgspecifici._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_dlgspecifici._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_dlgspecifici._s.SetCallerStringVar('w_codinter',WtA(w_codinter,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_tipinter',WtA(w_tipinter,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_flgint',WtA(w_flgint,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_flgrae',WtA(w_flgrae,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_flgsto',WtA(w_flgsto,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_flgdel',WtA(w_flgdel,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_passwd',WtA(w_passwd,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_tipofile',WtA(w_tipofile,'C'));
arrt_dlgspecifici._s.SetCallerStringVar('w_numreg',WtA(w_numreg,'N'));
arrt_dlgspecifici._s.SetCallerStringVar('w_numrec',WtA(w_numrec,'N'));
arrt_dlgspecifici._s.SetParameterString('m_bApplet','true');
arrt_dlgspecifici._s.CallServlet('arrt_dlgspecifici');
m_Caller.SetString('w_codinter','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_codinter'));
m_Caller.SetString('w_tipinter','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_tipinter'));
m_Caller.SetString('w_flgint','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_flgint'));
m_Caller.SetString('w_flgrae','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_flgrae'));
m_Caller.SetString('w_flgsto','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_flgsto'));
m_Caller.SetString('w_flgdel','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_flgdel'));
m_Caller.SetString('w_passwd','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_passwd'));
m_Caller.SetString('w_tipofile','C',0,0,arrt_dlgspecifici._s.GetCallerStringVar('w_tipofile'));
m_Caller.SetNumber('w_numreg','N',0,0,arrt_dlgspecifici._s.GetCallerDoubleVar('w_numreg'));
m_Caller.SetNumber('w_numrec','N',0,0,arrt_dlgspecifici._s.GetCallerDoubleVar('w_numrec'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_dlgspecifici._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_dlgspecifici.CtxLoad_ = function(){return []}
