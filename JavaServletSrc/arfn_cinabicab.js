function arfn_cinabicab() {
var pCodice;
var m_Caller
arfn_cinabicab._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCodice='';
}
if(arfn_cinabicab._p.length>0)_rargs([[['pCodice',arfn_cinabicab._p[0]]]],{eval:function(e){eval(e)}})
arfn_cinabicab._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_cinabicab._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_cinabicab._s.SetParameterString('pCodice',WtA(pCodice,'C'));
arfn_cinabicab._s.SetParameterString('m_bApplet','true');
arfn_cinabicab._s.CallServlet('arfn_cinabicab');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_cinabicab._s.errmsg;
}
return arfn_cinabicab._s.GetString();
}
arfn_cinabicab.CtxLoad_ = function(){return []}
