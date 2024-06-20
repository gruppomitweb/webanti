function aosrt_ricerca_sogg_blacklist() {
var w_criterio;
var w_denomin;
var w_simili;
var w_flgnega;
var w_flgnote;
var w_flgafon;
var m_Caller
aosrt_ricerca_sogg_blacklist._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_criterio='';
w_denomin='';
w_simili='';
w_flgnega='';
w_flgnote='';
w_flgafon='';
}
if(aosrt_ricerca_sogg_blacklist._p.length>0)_rargs([[['w_criterio',aosrt_ricerca_sogg_blacklist._p[0]],['w_denomin',aosrt_ricerca_sogg_blacklist._p[1]],['w_simili',aosrt_ricerca_sogg_blacklist._p[2]],['w_flgnega',aosrt_ricerca_sogg_blacklist._p[3]],['w_flgnote',aosrt_ricerca_sogg_blacklist._p[4]],['w_flgafon',aosrt_ricerca_sogg_blacklist._p[5]]]],{eval:function(e){eval(e)}})
aosrt_ricerca_sogg_blacklist._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aosrt_ricerca_sogg_blacklist._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aosrt_ricerca_sogg_blacklist._s.SetParameterString('w_criterio',WtA(w_criterio,'C'));
aosrt_ricerca_sogg_blacklist._s.SetParameterString('w_denomin',WtA(w_denomin,'C'));
aosrt_ricerca_sogg_blacklist._s.SetParameterString('w_simili',WtA(w_simili,'C'));
aosrt_ricerca_sogg_blacklist._s.SetParameterString('w_flgnega',WtA(w_flgnega,'C'));
aosrt_ricerca_sogg_blacklist._s.SetParameterString('w_flgnote',WtA(w_flgnote,'C'));
aosrt_ricerca_sogg_blacklist._s.SetParameterString('w_flgafon',WtA(w_flgafon,'C'));
aosrt_ricerca_sogg_blacklist._s.SetParameterString('m_bApplet','true');
aosrt_ricerca_sogg_blacklist._s.CallServlet('aosrt_ricerca_sogg_blacklist');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aosrt_ricerca_sogg_blacklist._s.errmsg;
}
}
aosrt_ricerca_sogg_blacklist.CtxLoad_ = function(){return []}
