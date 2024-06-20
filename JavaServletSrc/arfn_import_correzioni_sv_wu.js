function arfn_import_correzioni_sv_wu() {
var nomefile;
var m_Caller
arfn_import_correzioni_sv_wu._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
nomefile='';
}
if(arfn_import_correzioni_sv_wu._p.length>0)_rargs([[['nomefile',arfn_import_correzioni_sv_wu._p[0]]]],{eval:function(e){eval(e)}})
arfn_import_correzioni_sv_wu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_import_correzioni_sv_wu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_import_correzioni_sv_wu._s.SetParameterString('nomefile',WtA(nomefile,'C'));
arfn_import_correzioni_sv_wu._s.SetParameterString('m_bApplet','true');
arfn_import_correzioni_sv_wu._s.CallServlet('arfn_import_correzioni_sv_wu');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_import_correzioni_sv_wu._s.errmsg;
}
return arfn_import_correzioni_sv_wu._s.GetString();
}
arfn_import_correzioni_sv_wu.CtxLoad_ = function(){return []}
