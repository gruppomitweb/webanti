function arfn_anomes_rapp() {
var pRapporto;
var pTipo;
var pNCF;
var m_Caller
arfn_anomes_rapp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
pTipo='';
pNCF='';
}
if(arfn_anomes_rapp._p.length>0)_rargs([[['pRapporto',arfn_anomes_rapp._p[0]],['pTipo',arfn_anomes_rapp._p[1]],['pNCF',arfn_anomes_rapp._p[2]]]],{eval:function(e){eval(e)}})
arfn_anomes_rapp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_anomes_rapp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_anomes_rapp._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_anomes_rapp._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_anomes_rapp._s.SetParameterString('pNCF',WtA(pNCF,'C'));
arfn_anomes_rapp._s.SetParameterString('m_bApplet','true');
arfn_anomes_rapp._s.CallServlet('arfn_anomes_rapp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_anomes_rapp._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_anomes_rapp._s.errmsg;
arfn_anomes_rapp._res=new CPMemoryCursor();
} else {
arfn_anomes_rapp._res=arfn_anomes_rapp._s.GetMemoryCursor();
}
return arfn_anomes_rapp._res;
}
arfn_anomes_rapp.CtxLoad_ = function(){return []}
