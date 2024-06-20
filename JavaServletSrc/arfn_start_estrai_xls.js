function arfn_start_estrai_xls() {
var mcParam;
var m_Caller
arfn_start_estrai_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arfn_start_estrai_xls._p.length>0)_rargs([[['mcParam',arfn_start_estrai_xls._p[0]]]],{eval:function(e){eval(e)}})
arfn_start_estrai_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_start_estrai_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_start_estrai_xls._s.SetParameterString('mcParam',WtA(mcParam,'MC'),mcParam);
arfn_start_estrai_xls._s.SetParameterString('m_bApplet','true');
arfn_start_estrai_xls._s.CallServlet('arfn_start_estrai_xls');
mcParam._Copy(arfn_start_estrai_xls._s.GetCallerMemoryCursorVar('mcParam'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_start_estrai_xls._s.errmsg;
}
return arfn_start_estrai_xls._s.GetString();
}
arfn_start_estrai_xls.CtxLoad_ = function(){return []}
