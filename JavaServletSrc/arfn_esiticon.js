function arfn_esiticon() {
var pCode;
var m_Caller
arfn_esiticon._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCode='';
}
if(arfn_esiticon._p.length>0)_rargs([[['pCode',arfn_esiticon._p[0]]]],{eval:function(e){eval(e)}})
arfn_esiticon._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_esiticon._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_esiticon._s.SetParameterString('pCode',WtA(pCode,'C'));
arfn_esiticon._s.SetParameterString('m_bApplet','true');
arfn_esiticon._s.CallServlet('arfn_esiticon');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_esiticon._s.errmsg;
}
return arfn_esiticon._s.GetString();
}
arfn_esiticon.CtxLoad_ = function(){return []}
