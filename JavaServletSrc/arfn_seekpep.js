function arfn_seekpep() {
var pRagSoc;
var pCodFisc;
var m_Caller
arfn_seekpep._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRagSoc='';
pCodFisc='';
}
if(arfn_seekpep._p.length>0)_rargs([[['pRagSoc',arfn_seekpep._p[0]],['pCodFisc',arfn_seekpep._p[1]]]],{eval:function(e){eval(e)}})
arfn_seekpep._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_seekpep._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_seekpep._s.SetParameterString('pRagSoc',WtA(pRagSoc,'C'));
arfn_seekpep._s.SetParameterString('pCodFisc',WtA(pCodFisc,'C'));
arfn_seekpep._s.SetParameterString('m_bApplet','true');
arfn_seekpep._s.CallServlet('arfn_seekpep');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_seekpep._s.errmsg;
}
return arfn_seekpep._s.GetString();
}
arfn_seekpep.CtxLoad_ = function(){return []}
