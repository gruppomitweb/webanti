function arfn_wutrxchk_cases() {
var pCognome;
var pNome;
var pSesso;
var pTipoDoc;
var pNumDoc;
var pNasCom;
var pNasSta;
var pDatNas;
var pCodFis;
var pDatRil;
var pQuery;
var pDatOpe;
var pLuoNas;
var pFLGNCF;
var m_Caller
arfn_wutrxchk_cases._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCognome='';
pNome='';
pSesso='';
pTipoDoc='';
pNumDoc='';
pNasCom='';
pNasSta='';
pDatNas='';
pCodFis='';
pDatRil='';
pQuery='';
pDatOpe='';
pLuoNas='';
pFLGNCF='';
}
if(arfn_wutrxchk_cases._p.length>0)_rargs([[['pCognome',arfn_wutrxchk_cases._p[0]],['pNome',arfn_wutrxchk_cases._p[1]],['pSesso',arfn_wutrxchk_cases._p[2]],['pTipoDoc',arfn_wutrxchk_cases._p[3]],['pNumDoc',arfn_wutrxchk_cases._p[4]],['pNasCom',arfn_wutrxchk_cases._p[5]],['pNasSta',arfn_wutrxchk_cases._p[6]],['pDatNas',arfn_wutrxchk_cases._p[7]],['pCodFis',arfn_wutrxchk_cases._p[8]],['pDatRil',arfn_wutrxchk_cases._p[9]],['pQuery',arfn_wutrxchk_cases._p[10]],['pDatOpe',arfn_wutrxchk_cases._p[11]],['pLuoNas',arfn_wutrxchk_cases._p[12]],['pFLGNCF',arfn_wutrxchk_cases._p[13]]]],{eval:function(e){eval(e)}})
arfn_wutrxchk_cases._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_wutrxchk_cases._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_wutrxchk_cases._s.SetParameterString('pCognome',WtA(pCognome,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pNome',WtA(pNome,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pSesso',WtA(pSesso,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pTipoDoc',WtA(pTipoDoc,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pNumDoc',WtA(pNumDoc,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pNasCom',WtA(pNasCom,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pNasSta',WtA(pNasSta,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pDatNas',WtA(pDatNas,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pCodFis',WtA(pCodFis,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pDatRil',WtA(pDatRil,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pQuery',WtA(pQuery,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pDatOpe',WtA(pDatOpe,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pLuoNas',WtA(pLuoNas,'C'));
arfn_wutrxchk_cases._s.SetParameterString('pFLGNCF',WtA(pFLGNCF,'C'));
arfn_wutrxchk_cases._s.SetParameterString('m_bApplet','true');
arfn_wutrxchk_cases._s.CallServlet('arfn_wutrxchk_cases');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_wutrxchk_cases._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_wutrxchk_cases._s.errmsg;
arfn_wutrxchk_cases._res=new CPMemoryCursor();
} else {
arfn_wutrxchk_cases._res=arfn_wutrxchk_cases._s.GetMemoryCursor();
}
return arfn_wutrxchk_cases._res;
}
arfn_wutrxchk_cases.CtxLoad_ = function(){return []}
