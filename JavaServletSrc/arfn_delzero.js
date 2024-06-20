function arfn_delzero() {
var pCode;
var m_Caller
arfn_delzero._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCode='';
}
if(arfn_delzero._p.length>0)_rargs([[['pCode',arfn_delzero._p[0]]]],{eval:function(e){eval(e)}})
arfn_delzero._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_delzero._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_delzero._s.SetParameterString('pCode',WtA(pCode,'C'));
arfn_delzero._s.SetParameterString('m_bApplet','true');
arfn_delzero._s.CallServlet('arfn_delzero');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_delzero._s.errmsg;
}
return arfn_delzero._s.GetString();
}
arfn_delzero.CtxLoad_ = function(){return []}
