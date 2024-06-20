function arfn_conv_stato_uic() {
var _codice;
var m_Caller
arfn_conv_stato_uic._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
_codice='';
}
if(arfn_conv_stato_uic._p.length>0)_rargs([[['_codice',arfn_conv_stato_uic._p[0]]]],{eval:function(e){eval(e)}})
arfn_conv_stato_uic._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_conv_stato_uic._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_conv_stato_uic._s.SetParameterString('_codice',WtA(_codice,'C'));
arfn_conv_stato_uic._s.SetParameterString('m_bApplet','true');
arfn_conv_stato_uic._s.CallServlet('arfn_conv_stato_uic');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_conv_stato_uic._s.errmsg;
}
return arfn_conv_stato_uic._s.GetString();
}
arfn_conv_stato_uic.CtxLoad_ = function(){return []}
