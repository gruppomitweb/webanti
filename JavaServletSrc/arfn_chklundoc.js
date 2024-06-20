function arfn_chklundoc() {
var pTipo;
var pPaese;
var pNumDoc;
var pDatDoc;
var m_Caller
arfn_chklundoc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pPaese='';
pNumDoc='';
pDatDoc=NullDate();
}
if(arfn_chklundoc._p.length>0)_rargs([[['pTipo',arfn_chklundoc._p[0]],['pPaese',arfn_chklundoc._p[1]],['pNumDoc',arfn_chklundoc._p[2]],['pDatDoc',arfn_chklundoc._p[3]]]],{eval:function(e){eval(e)}})
arfn_chklundoc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chklundoc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chklundoc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_chklundoc._s.SetParameterString('pPaese',WtA(pPaese,'C'));
arfn_chklundoc._s.SetParameterString('pNumDoc',WtA(pNumDoc,'C'));
arfn_chklundoc._s.SetParameterString('pDatDoc',WtA(pDatDoc,'D'));
arfn_chklundoc._s.SetParameterString('m_bApplet','true');
arfn_chklundoc._s.CallServlet('arfn_chklundoc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chklundoc._s.errmsg;
}
return arfn_chklundoc._s.GetBoolean();
}
arfn_chklundoc.CtxLoad_ = function(){return []}
