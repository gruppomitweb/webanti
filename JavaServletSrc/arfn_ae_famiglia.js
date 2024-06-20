function arfn_ae_famiglia() {
var pRapporto;
var pTipo;
var m_Caller
arfn_ae_famiglia._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
pTipo='';
}
if(arfn_ae_famiglia._p.length>0)_rargs([[['pRapporto',arfn_ae_famiglia._p[0]],['pTipo',arfn_ae_famiglia._p[1]]]],{eval:function(e){eval(e)}})
arfn_ae_famiglia._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_ae_famiglia._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_ae_famiglia._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_ae_famiglia._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_ae_famiglia._s.SetParameterString('m_bApplet','true');
arfn_ae_famiglia._s.CallServlet('arfn_ae_famiglia');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_ae_famiglia._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_ae_famiglia._s.errmsg;
arfn_ae_famiglia._res=new CPMemoryCursor();
} else {
arfn_ae_famiglia._res=arfn_ae_famiglia._s.GetMemoryCursor();
}
return arfn_ae_famiglia._res;
}
arfn_ae_famiglia.CtxLoad_ = function(){return []}
