function arfn_descruolo() {
var pRuolo;
var m_Caller
arfn_descruolo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRuolo='';
}
if(arfn_descruolo._p.length>0)_rargs([[['pRuolo',arfn_descruolo._p[0]]]],{eval:function(e){eval(e)}})
arfn_descruolo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_descruolo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_descruolo._s.SetParameterString('pRuolo',WtA(pRuolo,'C'));
arfn_descruolo._s.SetParameterString('m_bApplet','true');
arfn_descruolo._s.CallServlet('arfn_descruolo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_descruolo._s.errmsg;
}
return arfn_descruolo._s.GetString();
}
arfn_descruolo.CtxLoad_ = function(){return []}
