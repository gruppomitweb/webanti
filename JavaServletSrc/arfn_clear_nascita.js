function arfn_clear_nascita() {
var pLuogo;
var m_Caller
arfn_clear_nascita._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pLuogo='';
}
if(arfn_clear_nascita._p.length>0)_rargs([[['pLuogo',arfn_clear_nascita._p[0]]]],{eval:function(e){eval(e)}})
arfn_clear_nascita._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_clear_nascita._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_clear_nascita._s.SetParameterString('pLuogo',WtA(pLuogo,'C'));
arfn_clear_nascita._s.SetParameterString('m_bApplet','true');
arfn_clear_nascita._s.CallServlet('arfn_clear_nascita');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_clear_nascita._s.errmsg;
}
return arfn_clear_nascita._s.GetString();
}
arfn_clear_nascita.CtxLoad_ = function(){return []}
