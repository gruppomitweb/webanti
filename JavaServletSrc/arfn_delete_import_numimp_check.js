function arfn_delete_import_numimp_check() {
var w_NUMIMP;
var m_Caller
arfn_delete_import_numimp_check._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_NUMIMP=NullDateTime();
}
if(arfn_delete_import_numimp_check._p.length>0)_rargs([[['w_NUMIMP',arfn_delete_import_numimp_check._p[0]]]],{eval:function(e){eval(e)}})
arfn_delete_import_numimp_check._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_delete_import_numimp_check._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_delete_import_numimp_check._s.SetParameterString('w_NUMIMP',WtA(w_NUMIMP,'T'));
arfn_delete_import_numimp_check._s.SetParameterString('m_bApplet','true');
arfn_delete_import_numimp_check._s.CallServlet('arfn_delete_import_numimp_check');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_delete_import_numimp_check._s.errmsg;
}
return arfn_delete_import_numimp_check._s.GetBoolean();
}
arfn_delete_import_numimp_check.CtxLoad_ = function(){return []}
