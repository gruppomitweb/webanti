function arrt_chkdiana() {
var w_codinter;
var w_tipinter;
var w_DaData;
var w_AData;
var w_tipoarch;
var w_codage;
var w_flgope;
var w_flgfrz;
var w_flgint;
var w_flgrae;
var w_flgrap;
var w_tiprap;
var w_codcli;
var w_ragben;
var w_flgsto;
var w_flgchk;
var w_flgdel;
var m_Caller
arrt_chkdiana._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_codinter=m_Caller.GetString('w_codinter','C',0,0);
w_tipinter=m_Caller.GetString('w_tipinter','C',0,0);
w_DaData=m_Caller.GetDate('w_DaData','D',0,0);
w_AData=m_Caller.GetDate('w_AData','D',0,0);
w_tipoarch=m_Caller.GetString('w_tipoarch','C',0,0);
w_codage=m_Caller.GetString('w_codage','C',0,0);
w_flgope=m_Caller.GetString('w_flgope','C',0,0);
w_flgfrz=m_Caller.GetString('w_flgfrz','C',0,0);
w_flgint=m_Caller.GetString('w_flgint','C',0,0);
w_flgrae=m_Caller.GetString('w_flgrae','C',0,0);
w_flgrap=m_Caller.GetString('w_flgrap','C',0,0);
w_tiprap=m_Caller.GetString('w_tiprap','C',0,0);
w_codcli=m_Caller.GetString('w_codcli','C',0,0);
w_ragben=m_Caller.GetString('w_ragben','C',0,0);
w_flgsto=m_Caller.GetString('w_flgsto','C',0,0);
w_flgchk=m_Caller.GetString('w_flgchk','C',0,0);
w_flgdel=m_Caller.GetString('w_flgdel','C',0,0);
arrt_chkdiana._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chkdiana._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chkdiana._s.SetCallerStringVar('w_codinter',WtA(w_codinter,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_tipinter',WtA(w_tipinter,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_DaData',WtA(w_DaData,'D'));
arrt_chkdiana._s.SetCallerStringVar('w_AData',WtA(w_AData,'D'));
arrt_chkdiana._s.SetCallerStringVar('w_tipoarch',WtA(w_tipoarch,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_codage',WtA(w_codage,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgope',WtA(w_flgope,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgfrz',WtA(w_flgfrz,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgint',WtA(w_flgint,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgrae',WtA(w_flgrae,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgrap',WtA(w_flgrap,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_tiprap',WtA(w_tiprap,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_codcli',WtA(w_codcli,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_ragben',WtA(w_ragben,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgsto',WtA(w_flgsto,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgchk',WtA(w_flgchk,'C'));
arrt_chkdiana._s.SetCallerStringVar('w_flgdel',WtA(w_flgdel,'C'));
arrt_chkdiana._s.SetParameterString('m_bApplet','true');
arrt_chkdiana._s.CallServlet('arrt_chkdiana');
m_Caller.SetString('w_codinter','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_codinter'));
m_Caller.SetString('w_tipinter','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_tipinter'));
m_Caller.SetDate('w_DaData','D',0,0,DateFromApplet(arrt_chkdiana._s.GetCallerDateVar('w_DaData')));
m_Caller.SetDate('w_AData','D',0,0,DateFromApplet(arrt_chkdiana._s.GetCallerDateVar('w_AData')));
m_Caller.SetString('w_tipoarch','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_tipoarch'));
m_Caller.SetString('w_codage','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_codage'));
m_Caller.SetString('w_flgope','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgope'));
m_Caller.SetString('w_flgfrz','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgfrz'));
m_Caller.SetString('w_flgint','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgint'));
m_Caller.SetString('w_flgrae','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgrae'));
m_Caller.SetString('w_flgrap','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgrap'));
m_Caller.SetString('w_tiprap','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_tiprap'));
m_Caller.SetString('w_codcli','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_codcli'));
m_Caller.SetString('w_ragben','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_ragben'));
m_Caller.SetString('w_flgsto','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgsto'));
m_Caller.SetString('w_flgchk','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgchk'));
m_Caller.SetString('w_flgdel','C',0,0,arrt_chkdiana._s.GetCallerStringVar('w_flgdel'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chkdiana._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_chkdiana.CtxLoad_ = function(){return []}
