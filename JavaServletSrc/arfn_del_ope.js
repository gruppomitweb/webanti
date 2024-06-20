function arfn_del_ope() {
var mcParam;
var m_Caller
arfn_del_ope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_del_ope._p.length>0)_rargs([[['mcParam',arfn_del_ope._p[0]]]],{eval:function(e){eval(e)}})
arfn_del_ope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_del_ope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_del_ope._s.SetParameterString('mcParam',WtA(mcParam,'MC'),mcParam);
arfn_del_ope._s.SetParameterString('m_bApplet','true');
arfn_del_ope._s.CallServlet('arfn_del_ope');
mcParam._Copy(arfn_del_ope._s.GetCallerMemoryCursorVar('mcParam'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_del_ope._s.errmsg;
}
return arfn_del_ope._s.GetBoolean();
}
arfn_del_ope.CtxLoad_ = function(){return []}
