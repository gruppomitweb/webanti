function arrt_chkdiana_sched() {
var w_codinter;
var w_tipinter;
var w_codage;
var w_codcli;
var w_ragben;
var daope;
var a_ope;
var dareg;
var a_reg;
var w_tipoarchd;
var w_tipoarchp;
var w_stoper;
var w_flgope;
var w_flgfrz;
var w_flgrae;
var w_flgrap;
var w_tiprap;
var w_flgtit;
var w_tiptit;
var w_flgint;
var w_flgdel;
var w_flgchk;
var w_flgxls;
var w_flgsto;
var w_allsto;
var w_multifile;
var m_Caller
arrt_chkdiana_sched._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_codinter='';
w_tipinter='';
w_codage='';
w_codcli='';
w_ragben='';
daope='';
a_ope='';
dareg='';
a_reg='';
w_tipoarchd='';
w_tipoarchp='';
w_stoper='';
w_flgope='';
w_flgfrz='';
w_flgrae='';
w_flgrap='';
w_tiprap='';
w_flgtit='';
w_tiptit='';
w_flgint='';
w_flgdel='';
w_flgchk='';
w_flgxls='';
w_flgsto='';
w_allsto='';
w_multifile='';
}
if(arrt_chkdiana_sched._p.length>0)_rargs([[['w_codinter',arrt_chkdiana_sched._p[0]],['w_tipinter',arrt_chkdiana_sched._p[1]],['w_codage',arrt_chkdiana_sched._p[2]],['w_codcli',arrt_chkdiana_sched._p[3]],['w_ragben',arrt_chkdiana_sched._p[4]],['daope',arrt_chkdiana_sched._p[5]],['a_ope',arrt_chkdiana_sched._p[6]],['dareg',arrt_chkdiana_sched._p[7]],['a_reg',arrt_chkdiana_sched._p[8]],['w_tipoarchd',arrt_chkdiana_sched._p[9]],['w_tipoarchp',arrt_chkdiana_sched._p[10]],['w_stoper',arrt_chkdiana_sched._p[11]],['w_flgope',arrt_chkdiana_sched._p[12]],['w_flgfrz',arrt_chkdiana_sched._p[13]],['w_flgrae',arrt_chkdiana_sched._p[14]],['w_flgrap',arrt_chkdiana_sched._p[15]],['w_tiprap',arrt_chkdiana_sched._p[16]],['w_flgtit',arrt_chkdiana_sched._p[17]],['w_tiptit',arrt_chkdiana_sched._p[18]],['w_flgint',arrt_chkdiana_sched._p[19]],['w_flgdel',arrt_chkdiana_sched._p[20]],['w_flgchk',arrt_chkdiana_sched._p[21]],['w_flgxls',arrt_chkdiana_sched._p[22]],['w_flgsto',arrt_chkdiana_sched._p[23]],['w_allsto',arrt_chkdiana_sched._p[24]],['w_multifile',arrt_chkdiana_sched._p[25]]]],{eval:function(e){eval(e)}})
arrt_chkdiana_sched._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chkdiana_sched._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chkdiana_sched._s.SetParameterString('w_codinter',WtA(w_codinter,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_tipinter',WtA(w_tipinter,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_codage',WtA(w_codage,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_codcli',WtA(w_codcli,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_ragben',WtA(w_ragben,'C'));
arrt_chkdiana_sched._s.SetParameterString('daope',WtA(daope,'C'));
arrt_chkdiana_sched._s.SetParameterString('a_ope',WtA(a_ope,'C'));
arrt_chkdiana_sched._s.SetParameterString('dareg',WtA(dareg,'C'));
arrt_chkdiana_sched._s.SetParameterString('a_reg',WtA(a_reg,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_tipoarchd',WtA(w_tipoarchd,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_tipoarchp',WtA(w_tipoarchp,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_stoper',WtA(w_stoper,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgope',WtA(w_flgope,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgfrz',WtA(w_flgfrz,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgrae',WtA(w_flgrae,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgrap',WtA(w_flgrap,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_tiprap',WtA(w_tiprap,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgtit',WtA(w_flgtit,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_tiptit',WtA(w_tiptit,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgint',WtA(w_flgint,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgdel',WtA(w_flgdel,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgchk',WtA(w_flgchk,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgxls',WtA(w_flgxls,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_flgsto',WtA(w_flgsto,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_allsto',WtA(w_allsto,'C'));
arrt_chkdiana_sched._s.SetParameterString('w_multifile',WtA(w_multifile,'C'));
arrt_chkdiana_sched._s.SetParameterString('m_bApplet','true');
arrt_chkdiana_sched._s.CallServlet('arrt_chkdiana_sched');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chkdiana_sched._s.errmsg;
}
return arrt_chkdiana_sched._s.GetString();
}
arrt_chkdiana_sched.CtxLoad_ = function(){return []}
