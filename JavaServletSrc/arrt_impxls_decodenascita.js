function arrt_impxls_decodenascita() {
var pNome;
var m_Caller
arrt_impxls_decodenascita._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNome='';
}
if(arrt_impxls_decodenascita._p.length>0)_rargs([[['pNome',arrt_impxls_decodenascita._p[0]]]],{eval:function(e){eval(e)}})
arrt_impxls_decodenascita._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_impxls_decodenascita._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_impxls_decodenascita._s.SetParameterString('pNome',WtA(pNome,'C'));
arrt_impxls_decodenascita._s.SetParameterString('m_bApplet','true');
arrt_impxls_decodenascita._s.CallServlet('arrt_impxls_decodenascita');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_impxls_decodenascita._s.errmsg;
}
}
arrt_impxls_decodenascita.CtxLoad_ = function(){return []}
