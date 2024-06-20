function arfn_selezione() {
var mcStringa;
var m_Caller
arfn_selezione._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_selezione._p.length>0)_rargs([[['mcStringa',arfn_selezione._p[0]]]],{eval:function(e){eval(e)}})
arfn_selezione._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_selezione._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_selezione._s.SetParameterString('mcStringa',WtA(mcStringa,'MC'),mcStringa);
arfn_selezione._s.SetParameterString('m_bApplet','true');
arfn_selezione._s.CallServlet('arfn_selezione');
mcStringa._Copy(arfn_selezione._s.GetCallerMemoryCursorVar('mcStringa'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_selezione._s.errmsg;
}
return arfn_selezione._s.GetString();
}
arfn_selezione.CtxLoad_ = function(){return []}
