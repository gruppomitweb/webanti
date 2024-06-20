function arrt_collegamenti_save() {
var tValues;
var oValues;
var fValues;
var pColleg;
var pTipo;
var m_Caller
arrt_collegamenti_save._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pColleg='';
pTipo='';
}
if(arrt_collegamenti_save._p.length>0)_rargs([[['tValues',arrt_collegamenti_save._p[0]],['oValues',arrt_collegamenti_save._p[1]],['fValues',arrt_collegamenti_save._p[2]],['pColleg',arrt_collegamenti_save._p[3]],['pTipo',arrt_collegamenti_save._p[4]]]],{eval:function(e){eval(e)}})
arrt_collegamenti_save._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_collegamenti_save._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_collegamenti_save._s.SetParameterString('tValues',WtA(tValues,'MC'),tValues);
arrt_collegamenti_save._s.SetParameterString('oValues',WtA(oValues,'MC'),oValues);
arrt_collegamenti_save._s.SetParameterString('fValues',WtA(fValues,'MC'),fValues);
arrt_collegamenti_save._s.SetParameterString('pColleg',WtA(pColleg,'C'));
arrt_collegamenti_save._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_collegamenti_save._s.SetParameterString('m_bApplet','true');
arrt_collegamenti_save._s.CallServlet('arrt_collegamenti_save');
tValues._Copy(arrt_collegamenti_save._s.GetCallerMemoryCursorVar('tValues'))
oValues._Copy(arrt_collegamenti_save._s.GetCallerMemoryCursorVar('oValues'))
fValues._Copy(arrt_collegamenti_save._s.GetCallerMemoryCursorVar('fValues'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_collegamenti_save._s.errmsg;
}
return arrt_collegamenti_save._s.GetBoolean();
}
arrt_collegamenti_save.CtxLoad_ = function(){return []}
