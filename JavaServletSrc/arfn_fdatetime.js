function arfn_fdatetime() {
var pDate;
var pTipo;
var m_Caller
arfn_fdatetime._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDate=NullDateTime();
pTipo='1';
}
if(arfn_fdatetime._p.length>0)_rargs([[['pDate',arfn_fdatetime._p[0]],['pTipo',arfn_fdatetime._p[1]]]],{eval:function(e){eval(e)}})
arfn_fdatetime._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fdatetime._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fdatetime._s.SetParameterString('pDate',WtA(pDate,'T'));
arfn_fdatetime._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_fdatetime._s.SetParameterString('m_bApplet','true');
arfn_fdatetime._s.CallServlet('arfn_fdatetime');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fdatetime._s.errmsg;
}
return arfn_fdatetime._s.GetString();
}
arfn_fdatetime.CtxLoad_ = function(){return []}
