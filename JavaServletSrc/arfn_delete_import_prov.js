function arfn_delete_import_prov() {
var w_numimp;
var m_Caller
arfn_delete_import_prov._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_numimp=NullDateTime();
}
if(arfn_delete_import_prov._p.length>0)_rargs([[['w_numimp',arfn_delete_import_prov._p[0]]]],{eval:function(e){eval(e)}})
arfn_delete_import_prov._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_delete_import_prov._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_delete_import_prov._s.SetParameterString('w_numimp',WtA(w_numimp,'T'));
arfn_delete_import_prov._s.SetParameterString('m_bApplet','true');
arfn_delete_import_prov._s.CallServlet('arfn_delete_import_prov');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_delete_import_prov._s.errmsg;
}
return arfn_delete_import_prov._s.GetString();
}
arfn_delete_import_prov.CtxLoad_ = function(){return []}
