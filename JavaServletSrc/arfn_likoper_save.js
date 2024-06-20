function arfn_likoper_save() {
var oValues;
var pColleg;
var pTipo;
var pOper;
var m_Caller
arfn_likoper_save._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pColleg='';
pTipo='';
pOper='';
}
if(arfn_likoper_save._p.length>0)_rargs([[['oValues',arfn_likoper_save._p[0]],['pColleg',arfn_likoper_save._p[1]],['pTipo',arfn_likoper_save._p[2]],['pOper',arfn_likoper_save._p[3]]]],{eval:function(e){eval(e)}})
arfn_likoper_save._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_likoper_save._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_likoper_save._s.SetParameterString('oValues',WtA(oValues,'MC'),oValues);
arfn_likoper_save._s.SetParameterString('pColleg',WtA(pColleg,'C'));
arfn_likoper_save._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_likoper_save._s.SetParameterString('pOper',WtA(pOper,'C'));
arfn_likoper_save._s.SetParameterString('m_bApplet','true');
arfn_likoper_save._s.CallServlet('arfn_likoper_save');
oValues._Copy(arfn_likoper_save._s.GetCallerMemoryCursorVar('oValues'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_likoper_save._s.errmsg;
}
return arfn_likoper_save._s.GetBoolean();
}
arfn_likoper_save.CtxLoad_ = function(){return []}
