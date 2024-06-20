function arfn_calccodfis() {
var w_COGNOME;
var w_NOME;
var w_DATANASC;
var w_NASCOMUN;
var w_NASSTATO;
var w_SESSO;
var w_TIPINTER;
var m_Caller
arfn_calccodfis._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_COGNOME='';
w_NOME='';
w_DATANASC=NullDate();
w_NASCOMUN='';
w_NASSTATO='';
w_SESSO='';
w_TIPINTER='';
}
if(arfn_calccodfis._p.length>0)_rargs([[['w_COGNOME',arfn_calccodfis._p[0]],['w_NOME',arfn_calccodfis._p[1]],['w_DATANASC',arfn_calccodfis._p[2]],['w_NASCOMUN',arfn_calccodfis._p[3]],['w_NASSTATO',arfn_calccodfis._p[4]],['w_SESSO',arfn_calccodfis._p[5]],['w_TIPINTER',arfn_calccodfis._p[6]]]],{eval:function(e){eval(e)}})
arfn_calccodfis._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_calccodfis._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_calccodfis._s.SetParameterString('w_COGNOME',WtA(w_COGNOME,'C'));
arfn_calccodfis._s.SetParameterString('w_NOME',WtA(w_NOME,'C'));
arfn_calccodfis._s.SetParameterString('w_DATANASC',WtA(w_DATANASC,'D'));
arfn_calccodfis._s.SetParameterString('w_NASCOMUN',WtA(w_NASCOMUN,'C'));
arfn_calccodfis._s.SetParameterString('w_NASSTATO',WtA(w_NASSTATO,'C'));
arfn_calccodfis._s.SetParameterString('w_SESSO',WtA(w_SESSO,'C'));
arfn_calccodfis._s.SetParameterString('w_TIPINTER',WtA(w_TIPINTER,'C'));
arfn_calccodfis._s.SetParameterString('m_bApplet','true');
arfn_calccodfis._s.CallServlet('arfn_calccodfis');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_calccodfis._s.errmsg;
}
return arfn_calccodfis._s.GetString();
}
arfn_calccodfis.CtxLoad_ = function(){return []}
