function arfn_chkiban() {
var pIBAN;
var pTipo;
var m_Caller
arfn_chkiban._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pIBAN='';
pTipo='';
}
if(arfn_chkiban._p.length>0)_rargs([[['pIBAN',arfn_chkiban._p[0]],['pTipo',arfn_chkiban._p[1]]]],{eval:function(e){eval(e)}})
arfn_chkiban._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkiban._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkiban._s.SetParameterString('pIBAN',WtA(pIBAN,'C'));
arfn_chkiban._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_chkiban._s.SetParameterString('m_bApplet','true');
arfn_chkiban._s.CallServlet('arfn_chkiban');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkiban._s.errmsg;
}
return arfn_chkiban._s.GetBoolean();
}
arfn_chkiban.CtxLoad_ = function(){return []}
