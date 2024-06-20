function arfn_verifica_cf_nome_cognome() {
var CF;
var NOME;
var COGNOME;
var m_Caller
arfn_verifica_cf_nome_cognome._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
CF='';
NOME='';
COGNOME='';
}
if(arfn_verifica_cf_nome_cognome._p.length>0)_rargs([[['CF',arfn_verifica_cf_nome_cognome._p[0]],['NOME',arfn_verifica_cf_nome_cognome._p[1]],['COGNOME',arfn_verifica_cf_nome_cognome._p[2]]]],{eval:function(e){eval(e)}})
arfn_verifica_cf_nome_cognome._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_verifica_cf_nome_cognome._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_verifica_cf_nome_cognome._s.SetParameterString('CF',WtA(CF,'C'));
arfn_verifica_cf_nome_cognome._s.SetParameterString('NOME',WtA(NOME,'C'));
arfn_verifica_cf_nome_cognome._s.SetParameterString('COGNOME',WtA(COGNOME,'C'));
arfn_verifica_cf_nome_cognome._s.SetParameterString('m_bApplet','true');
arfn_verifica_cf_nome_cognome._s.CallServlet('arfn_verifica_cf_nome_cognome');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_verifica_cf_nome_cognome._s.errmsg;
}
return arfn_verifica_cf_nome_cognome._s.GetBoolean();
}
arfn_verifica_cf_nome_cognome.CtxLoad_ = function(){return []}
