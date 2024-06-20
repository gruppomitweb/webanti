function arrt_calccodfis() {
var w_CODFISC;
var w_DATANASC;
var w_NASCOMUN;
var w_NASSTATO;
var w_COGNOME;
var w_RAGSOC;
var w_NOME;
var w_SESSO;
var w_TIPINTER;
var m_Caller
arrt_calccodfis._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CODFISC=m_Caller.GetString('w_CODFISC','C',0,0);
w_DATANASC=m_Caller.GetDate('w_DATANASC','D',0,0);
w_NASCOMUN=m_Caller.GetString('w_NASCOMUN','C',0,0);
w_NASSTATO=m_Caller.GetString('w_NASSTATO','C',0,0);
w_COGNOME=m_Caller.GetString('w_COGNOME','C',0,0);
w_RAGSOC=m_Caller.GetString('w_RAGSOC','C',0,0);
w_NOME=m_Caller.GetString('w_NOME','C',0,0);
w_SESSO=m_Caller.GetString('w_SESSO','C',0,0);
w_TIPINTER=m_Caller.GetString('w_TIPINTER','C',0,0);
arrt_calccodfis._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calccodfis._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calccodfis._s.SetCallerStringVar('w_CODFISC',WtA(w_CODFISC,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_DATANASC',WtA(w_DATANASC,'D'));
arrt_calccodfis._s.SetCallerStringVar('w_NASCOMUN',WtA(w_NASCOMUN,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_NASSTATO',WtA(w_NASSTATO,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_COGNOME',WtA(w_COGNOME,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_RAGSOC',WtA(w_RAGSOC,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_NOME',WtA(w_NOME,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_SESSO',WtA(w_SESSO,'C'));
arrt_calccodfis._s.SetCallerStringVar('w_TIPINTER',WtA(w_TIPINTER,'C'));
arrt_calccodfis._s.SetParameterString('m_bApplet','true');
arrt_calccodfis._s.CallServlet('arrt_calccodfis');
m_Caller.SetString('w_CODFISC','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_CODFISC'));
m_Caller.SetDate('w_DATANASC','D',0,0,DateFromApplet(arrt_calccodfis._s.GetCallerDateVar('w_DATANASC')));
m_Caller.SetString('w_NASCOMUN','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_NASCOMUN'));
m_Caller.SetString('w_NASSTATO','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_NASSTATO'));
m_Caller.SetString('w_COGNOME','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_COGNOME'));
m_Caller.SetString('w_RAGSOC','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_RAGSOC'));
m_Caller.SetString('w_NOME','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_NOME'));
m_Caller.SetString('w_SESSO','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_SESSO'));
m_Caller.SetString('w_TIPINTER','C',0,0,arrt_calccodfis._s.GetCallerStringVar('w_TIPINTER'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calccodfis._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_calccodfis.CtxLoad_ = function(){return []}
