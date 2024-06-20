function arrt_allinea_cointestatari() {
var mcValues;
var pTipo;
var pAgg;
var m_Caller
arrt_allinea_cointestatari._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pAgg='';
}
if(arrt_allinea_cointestatari._p.length>0)_rargs([[['mcValues',arrt_allinea_cointestatari._p[0]],['pTipo',arrt_allinea_cointestatari._p[1]],['pAgg',arrt_allinea_cointestatari._p[2]]]],{eval:function(e){eval(e)}})
arrt_allinea_cointestatari._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_allinea_cointestatari._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_allinea_cointestatari._s.SetParameterString('mcValues',WtA(mcValues,'MC'),mcValues);
arrt_allinea_cointestatari._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_allinea_cointestatari._s.SetParameterString('pAgg',WtA(pAgg,'C'));
arrt_allinea_cointestatari._s.SetParameterString('m_bApplet','true');
arrt_allinea_cointestatari._s.CallServlet('arrt_allinea_cointestatari');
mcValues._Copy(arrt_allinea_cointestatari._s.GetCallerMemoryCursorVar('mcValues'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_allinea_cointestatari._s.errmsg;
}
return arrt_allinea_cointestatari._s.GetString();
}
arrt_allinea_cointestatari.CtxLoad_ = function(){return []}
