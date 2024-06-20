function arfn_moneygram_allineamenti() {
var mcParam;
var m_Caller
arfn_moneygram_allineamenti._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_moneygram_allineamenti._p.length>0)_rargs([[['mcParam',arfn_moneygram_allineamenti._p[0]]]],{eval:function(e){eval(e)}})
arfn_moneygram_allineamenti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_moneygram_allineamenti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_moneygram_allineamenti._s.SetParameterString('mcParam',WtA(mcParam,'MC'),mcParam);
arfn_moneygram_allineamenti._s.SetParameterString('m_bApplet','true');
arfn_moneygram_allineamenti._s.CallServlet('arfn_moneygram_allineamenti');
mcParam._Copy(arfn_moneygram_allineamenti._s.GetCallerMemoryCursorVar('mcParam'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_moneygram_allineamenti._s.errmsg;
}
return arfn_moneygram_allineamenti._s.GetBoolean();
}
arfn_moneygram_allineamenti.CtxLoad_ = function(){return []}
