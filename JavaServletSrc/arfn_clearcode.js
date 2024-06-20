function arfn_clearcode() {
var pCode;
var m_Caller
arfn_clearcode._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCode='';
}
if(arfn_clearcode._p.length>0)_rargs([[['pCode',arfn_clearcode._p[0]]]],{eval:function(e){eval(e)}})
arfn_clearcode._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_clearcode._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_clearcode._s.SetParameterString('pCode',WtA(pCode,'C'));
arfn_clearcode._s.SetParameterString('m_bApplet','true');
arfn_clearcode._s.CallServlet('arfn_clearcode');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_clearcode._s.errmsg;
}
return arfn_clearcode._s.GetString();
}
arfn_clearcode.CtxLoad_ = function(){return []}
