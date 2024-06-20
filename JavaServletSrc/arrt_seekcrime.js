function arrt_seekcrime() {
var pCognome;
var pNome;
var pCodFisc;
var m_Caller
arrt_seekcrime._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCognome='';
pNome='';
pCodFisc='';
}
if(arrt_seekcrime._p.length>0)_rargs([[['pCognome',arrt_seekcrime._p[0]],['pNome',arrt_seekcrime._p[1]],['pCodFisc',arrt_seekcrime._p[2]]]],{eval:function(e){eval(e)}})
arrt_seekcrime._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seekcrime._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seekcrime._s.SetParameterString('pCognome',WtA(pCognome,'C'));
arrt_seekcrime._s.SetParameterString('pNome',WtA(pNome,'C'));
arrt_seekcrime._s.SetParameterString('pCodFisc',WtA(pCodFisc,'C'));
arrt_seekcrime._s.SetParameterString('m_bApplet','true');
arrt_seekcrime._s.CallServlet('arrt_seekcrime');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seekcrime._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arrt_seekcrime._s.errmsg;
arrt_seekcrime._res=new CPMemoryCursor();
} else {
arrt_seekcrime._res=arrt_seekcrime._s.GetMemoryCursor();
}
return arrt_seekcrime._res;
}
arrt_seekcrime.CtxLoad_ = function(){return []}
