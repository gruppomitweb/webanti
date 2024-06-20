function arrt_wu_autocorrect() {
var w_TRXCODPRG;
var w_TRXCOGNOM;
var w_TRXNOME;
var w_TRXLUONAS;
var w_TRXDATNAS;
var w_TRXSESSO;
var w_TRXTIPDOC;
var w_TRXNUMDOC;
var w_TRXCODFIS;
var w_FLGDATIOLD;
var w_TRXFLGFOR;
var w_TRXDATOPE;
var w_TRXNASSTATO;
var w_TRXNASCOMUN;
var w_TRXDATRIL;
var w_finalized;
var m_Caller
arrt_wu_autocorrect._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_TRXCODPRG=m_Caller.GetNumber('w_TRXCODPRG','N',0,0);
w_TRXCOGNOM=m_Caller.GetString('w_TRXCOGNOM','C',0,0);
w_TRXNOME=m_Caller.GetString('w_TRXNOME','C',0,0);
w_TRXLUONAS=m_Caller.GetString('w_TRXLUONAS','C',0,0);
w_TRXDATNAS=m_Caller.GetDate('w_TRXDATNAS','D',0,0);
w_TRXSESSO=m_Caller.GetString('w_TRXSESSO','C',0,0);
w_TRXTIPDOC=m_Caller.GetString('w_TRXTIPDOC','C',0,0);
w_TRXNUMDOC=m_Caller.GetString('w_TRXNUMDOC','C',0,0);
w_TRXCODFIS=m_Caller.GetString('w_TRXCODFIS','C',0,0);
w_FLGDATIOLD=m_Caller.GetString('w_FLGDATIOLD','C',0,0);
w_TRXFLGFOR=m_Caller.GetString('w_TRXFLGFOR','C',0,0);
w_TRXDATOPE=m_Caller.GetDate('w_TRXDATOPE','D',0,0);
w_TRXNASSTATO=m_Caller.GetString('w_TRXNASSTATO','C',0,0);
w_TRXNASCOMUN=m_Caller.GetString('w_TRXNASCOMUN','C',0,0);
w_TRXDATRIL=m_Caller.GetDate('w_TRXDATRIL','D',0,0);
w_finalized=m_Caller.GetString('w_finalized','C',0,0);
arrt_wu_autocorrect._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wu_autocorrect._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXCODPRG',WtA(w_TRXCODPRG,'N'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXCOGNOM',WtA(w_TRXCOGNOM,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXNOME',WtA(w_TRXNOME,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXLUONAS',WtA(w_TRXLUONAS,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXDATNAS',WtA(w_TRXDATNAS,'D'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXSESSO',WtA(w_TRXSESSO,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXTIPDOC',WtA(w_TRXTIPDOC,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXNUMDOC',WtA(w_TRXNUMDOC,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXCODFIS',WtA(w_TRXCODFIS,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_FLGDATIOLD',WtA(w_FLGDATIOLD,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXFLGFOR',WtA(w_TRXFLGFOR,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXDATOPE',WtA(w_TRXDATOPE,'D'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXNASSTATO',WtA(w_TRXNASSTATO,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXNASCOMUN',WtA(w_TRXNASCOMUN,'C'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_TRXDATRIL',WtA(w_TRXDATRIL,'D'));
arrt_wu_autocorrect._s.SetCallerStringVar('w_finalized',WtA(w_finalized,'C'));
arrt_wu_autocorrect._s.SetParameterString('m_bApplet','true');
arrt_wu_autocorrect._s.CallServlet('arrt_wu_autocorrect');
m_Caller.SetNumber('w_TRXCODPRG','N',0,0,arrt_wu_autocorrect._s.GetCallerDoubleVar('w_TRXCODPRG'));
m_Caller.SetString('w_TRXCOGNOM','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXCOGNOM'));
m_Caller.SetString('w_TRXNOME','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXNOME'));
m_Caller.SetString('w_TRXLUONAS','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXLUONAS'));
m_Caller.SetDate('w_TRXDATNAS','D',0,0,DateFromApplet(arrt_wu_autocorrect._s.GetCallerDateVar('w_TRXDATNAS')));
m_Caller.SetString('w_TRXSESSO','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXSESSO'));
m_Caller.SetString('w_TRXTIPDOC','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXTIPDOC'));
m_Caller.SetString('w_TRXNUMDOC','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXNUMDOC'));
m_Caller.SetString('w_TRXCODFIS','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXCODFIS'));
m_Caller.SetString('w_FLGDATIOLD','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_FLGDATIOLD'));
m_Caller.SetString('w_TRXFLGFOR','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXFLGFOR'));
m_Caller.SetDate('w_TRXDATOPE','D',0,0,DateFromApplet(arrt_wu_autocorrect._s.GetCallerDateVar('w_TRXDATOPE')));
m_Caller.SetString('w_TRXNASSTATO','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXNASSTATO'));
m_Caller.SetString('w_TRXNASCOMUN','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_TRXNASCOMUN'));
m_Caller.SetDate('w_TRXDATRIL','D',0,0,DateFromApplet(arrt_wu_autocorrect._s.GetCallerDateVar('w_TRXDATRIL')));
m_Caller.SetString('w_finalized','C',0,0,arrt_wu_autocorrect._s.GetCallerStringVar('w_finalized'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wu_autocorrect._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_wu_autocorrect.CtxLoad_ = function(){return []}
