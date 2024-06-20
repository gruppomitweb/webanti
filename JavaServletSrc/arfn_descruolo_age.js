function arfn_descruolo_age() {
var pRuolo;
var m_Caller
arfn_descruolo_age._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRuolo=0;
}
if(arfn_descruolo_age._p.length>0)_rargs([[['pRuolo',arfn_descruolo_age._p[0]]]],{eval:function(e){eval(e)}})
arfn_descruolo_age._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_descruolo_age._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_descruolo_age._s.SetParameterString('pRuolo',WtA(pRuolo,'N'));
arfn_descruolo_age._s.SetParameterString('m_bApplet','true');
arfn_descruolo_age._s.CallServlet('arfn_descruolo_age');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_descruolo_age._s.errmsg;
}
return arfn_descruolo_age._s.GetString();
}
arfn_descruolo_age.CtxLoad_ = function(){return []}
