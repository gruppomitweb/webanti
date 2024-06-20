function arfn_fdatetime_bp() {
var pDate;
var m_Caller
arfn_fdatetime_bp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDate=NullDateTime();
}
if(arfn_fdatetime_bp._p.length>0)_rargs([[['pDate',arfn_fdatetime_bp._p[0]]]],{eval:function(e){eval(e)}})
arfn_fdatetime_bp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fdatetime_bp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fdatetime_bp._s.SetParameterString('pDate',WtA(pDate,'T'));
arfn_fdatetime_bp._s.SetParameterString('m_bApplet','true');
arfn_fdatetime_bp._s.CallServlet('arfn_fdatetime_bp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fdatetime_bp._s.errmsg;
}
return arfn_fdatetime_bp._s.GetString();
}
arfn_fdatetime_bp.CtxLoad_ = function(){return []}
