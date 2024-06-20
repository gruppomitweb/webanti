function arrt_seekpep_rs() {
var pRagSoc;
var pCognome;
var pNome;
var pCodFisc;
var pTipo;
var m_Caller
arrt_seekpep_rs._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRagSoc='';
pCognome='';
pNome='';
pCodFisc='';
pTipo='';
}
if(arrt_seekpep_rs._p.length>0)_rargs([[['pRagSoc',arrt_seekpep_rs._p[0]],['pCognome',arrt_seekpep_rs._p[1]],['pNome',arrt_seekpep_rs._p[2]],['pCodFisc',arrt_seekpep_rs._p[3]],['pTipo',arrt_seekpep_rs._p[4]]]],{eval:function(e){eval(e)}})
arrt_seekpep_rs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_seekpep_rs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_seekpep_rs._s.SetParameterString('pRagSoc',WtA(pRagSoc,'C'));
arrt_seekpep_rs._s.SetParameterString('pCognome',WtA(pCognome,'C'));
arrt_seekpep_rs._s.SetParameterString('pNome',WtA(pNome,'C'));
arrt_seekpep_rs._s.SetParameterString('pCodFisc',WtA(pCodFisc,'C'));
arrt_seekpep_rs._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_seekpep_rs._s.SetParameterString('m_bApplet','true');
arrt_seekpep_rs._s.CallServlet('arrt_seekpep_rs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_seekpep_rs._s.errmsg;
}
return arrt_seekpep_rs._s.GetString();
}
arrt_seekpep_rs.CtxLoad_ = function(){return []}
