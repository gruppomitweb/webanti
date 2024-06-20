function arfn_anompers() {
var pNDG;
var pTipoRap;
var pRapporto;
var pCoerenza;
var pTipo;
var pTipoPers;
var pNOCF;
var m_Caller
arfn_anompers._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNDG='';
pTipoRap='';
pRapporto='';
pCoerenza='';
pTipo='';
pTipoPers='';
pNOCF='';
}
if(arfn_anompers._p.length>0)_rargs([[['pNDG',arfn_anompers._p[0]],['pTipoRap',arfn_anompers._p[1]],['pRapporto',arfn_anompers._p[2]],['pCoerenza',arfn_anompers._p[3]],['pTipo',arfn_anompers._p[4]],['pTipoPers',arfn_anompers._p[5]],['pNOCF',arfn_anompers._p[6]]]],{eval:function(e){eval(e)}})
arfn_anompers._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_anompers._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_anompers._s.SetParameterString('pNDG',WtA(pNDG,'C'));
arfn_anompers._s.SetParameterString('pTipoRap',WtA(pTipoRap,'C'));
arfn_anompers._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_anompers._s.SetParameterString('pCoerenza',WtA(pCoerenza,'C'));
arfn_anompers._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_anompers._s.SetParameterString('pTipoPers',WtA(pTipoPers,'C'));
arfn_anompers._s.SetParameterString('pNOCF',WtA(pNOCF,'C'));
arfn_anompers._s.SetParameterString('m_bApplet','true');
arfn_anompers._s.CallServlet('arfn_anompers');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_anompers._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_anompers._s.errmsg;
arfn_anompers._res=new CPMemoryCursor();
} else {
arfn_anompers._res=arfn_anompers._s.GetMemoryCursor();
}
return arfn_anompers._res;
}
arfn_anompers.CtxLoad_ = function(){return []}
