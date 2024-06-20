function arfn_allinea_cointestatari() {
var mcValues;
var m_Caller
arfn_allinea_cointestatari._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_allinea_cointestatari._p.length>0)_rargs([[['mcValues',arfn_allinea_cointestatari._p[0]]]],{eval:function(e){eval(e)}})
arfn_allinea_cointestatari._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_allinea_cointestatari._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_allinea_cointestatari._s.SetParameterString('mcValues',WtA(mcValues,'MC'),mcValues);
arfn_allinea_cointestatari._s.SetParameterString('m_bApplet','true');
arfn_allinea_cointestatari._s.CallServlet('arfn_allinea_cointestatari');
mcValues._Copy(arfn_allinea_cointestatari._s.GetCallerMemoryCursorVar('mcValues'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_allinea_cointestatari._s.errmsg;
}
return arfn_allinea_cointestatari._s.GetString();
}
arfn_allinea_cointestatari.CtxLoad_ = function(){return []}
