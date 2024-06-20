function arfn_dectabs() {
var pTab;
var pCodice;
var m_Caller
arfn_dectabs._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTab='';
pCodice='';
}
if(arfn_dectabs._p.length>0)_rargs([[['pTab',arfn_dectabs._p[0]],['pCodice',arfn_dectabs._p[1]]]],{eval:function(e){eval(e)}})
arfn_dectabs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_dectabs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_dectabs._s.SetParameterString('pTab',WtA(pTab,'C'));
arfn_dectabs._s.SetParameterString('pCodice',WtA(pCodice,'C'));
arfn_dectabs._s.SetParameterString('m_bApplet','true');
arfn_dectabs._s.CallServlet('arfn_dectabs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_dectabs._s.errmsg;
}
return arfn_dectabs._s.GetString();
}
arfn_dectabs.CtxLoad_ = function(){return []}
