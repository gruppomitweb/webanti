function arrt_seekpep() {
var pRagSoc;
var pCodFisc;
var m_Caller
arrt_seekpep._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRagSoc='';
pCodFisc='';
}
if(arrt_seekpep._p.length>0)_rargs([[['pRagSoc',arrt_seekpep._p[0]],['pCodFisc',arrt_seekpep._p[1]]]],{eval:function(e){eval(e)}})
arrt_seekpep._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seekpep._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seekpep._s.SetParameterString('pRagSoc',WtA(pRagSoc,'C'));
arrt_seekpep._s.SetParameterString('pCodFisc',WtA(pCodFisc,'C'));
arrt_seekpep._s.SetParameterString('m_bApplet','true');
arrt_seekpep._s.CallServlet('arrt_seekpep');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seekpep._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arrt_seekpep._s.errmsg;
arrt_seekpep._res=new CPMemoryCursor();
} else {
arrt_seekpep._res=arrt_seekpep._s.GetMemoryCursor();
}
return arrt_seekpep._res;
}
arrt_seekpep.CtxLoad_ = function(){return []}
