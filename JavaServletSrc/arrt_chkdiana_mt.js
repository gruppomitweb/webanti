function arrt_chkdiana_mt() {
var w_codinter;
var w_tipinter;
var w_DaData;
var w_AData;
var w_tipoarch;
var w_codage;
var w_flgope;
var w_flgfrz;
var m_Caller
arrt_chkdiana_mt._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_codinter=m_Caller.GetString('w_codinter','C',0,0);
w_tipinter=m_Caller.GetString('w_tipinter','C',0,0);
w_DaData=m_Caller.GetDate('w_DaData','D',0,0);
w_AData=m_Caller.GetDate('w_AData','D',0,0);
w_tipoarch=m_Caller.GetString('w_tipoarch','C',0,0);
w_codage=m_Caller.GetString('w_codage','C',0,0);
w_flgope=m_Caller.GetString('w_flgope','C',0,0);
w_flgfrz=m_Caller.GetString('w_flgfrz','C',0,0);
arrt_chkdiana_mt._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chkdiana_mt._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chkdiana_mt._s.SetCallerStringVar('w_codinter',WtA(w_codinter,'C'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_tipinter',WtA(w_tipinter,'C'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_DaData',WtA(w_DaData,'D'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_AData',WtA(w_AData,'D'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_tipoarch',WtA(w_tipoarch,'C'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_codage',WtA(w_codage,'C'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_flgope',WtA(w_flgope,'C'));
arrt_chkdiana_mt._s.SetCallerStringVar('w_flgfrz',WtA(w_flgfrz,'C'));
arrt_chkdiana_mt._s.SetParameterString('m_bApplet','true');
arrt_chkdiana_mt._s.CallServlet('arrt_chkdiana_mt');
m_Caller.SetString('w_codinter','C',0,0,arrt_chkdiana_mt._s.GetCallerStringVar('w_codinter'));
m_Caller.SetString('w_tipinter','C',0,0,arrt_chkdiana_mt._s.GetCallerStringVar('w_tipinter'));
m_Caller.SetDate('w_DaData','D',0,0,DateFromApplet(arrt_chkdiana_mt._s.GetCallerDateVar('w_DaData')));
m_Caller.SetDate('w_AData','D',0,0,DateFromApplet(arrt_chkdiana_mt._s.GetCallerDateVar('w_AData')));
m_Caller.SetString('w_tipoarch','C',0,0,arrt_chkdiana_mt._s.GetCallerStringVar('w_tipoarch'));
m_Caller.SetString('w_codage','C',0,0,arrt_chkdiana_mt._s.GetCallerStringVar('w_codage'));
m_Caller.SetString('w_flgope','C',0,0,arrt_chkdiana_mt._s.GetCallerStringVar('w_flgope'));
m_Caller.SetString('w_flgfrz','C',0,0,arrt_chkdiana_mt._s.GetCallerStringVar('w_flgfrz'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chkdiana_mt._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_chkdiana_mt.CtxLoad_ = function(){return []}
