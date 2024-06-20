function arfn_linkxper_save() {
var oValues;
var pColleg;
var pTipo;
var m_Caller
arfn_linkxper_save._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pColleg='';
pTipo='';
}
if(arfn_linkxper_save._p.length>0)_rargs([[['oValues',arfn_linkxper_save._p[0]],['pColleg',arfn_linkxper_save._p[1]],['pTipo',arfn_linkxper_save._p[2]]]],{eval:function(e){eval(e)}})
arfn_linkxper_save._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_linkxper_save._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_linkxper_save._s.SetParameterString('oValues',WtA(oValues,'MC'),oValues);
arfn_linkxper_save._s.SetParameterString('pColleg',WtA(pColleg,'C'));
arfn_linkxper_save._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_linkxper_save._s.SetParameterString('m_bApplet','true');
arfn_linkxper_save._s.CallServlet('arfn_linkxper_save');
oValues._Copy(arfn_linkxper_save._s.GetCallerMemoryCursorVar('oValues'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_linkxper_save._s.errmsg;
}
return arfn_linkxper_save._s.GetBoolean();
}
arfn_linkxper_save.CtxLoad_ = function(){return []}
