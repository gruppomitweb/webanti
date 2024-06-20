function opert_estr_trim() {
var w_anno;
var w_trimestre;
var w_tipo;
var m_Caller
opert_estr_trim._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno='';
w_trimestre='';
w_tipo='';
}
if(opert_estr_trim._p.length>0)_rargs([[['w_anno',opert_estr_trim._p[0]],['w_trimestre',opert_estr_trim._p[1]],['w_tipo',opert_estr_trim._p[2]]]],{eval:function(e){eval(e)}})
opert_estr_trim._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_estr_trim._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_estr_trim._s.SetParameterString('w_anno',WtA(w_anno,'C'));
opert_estr_trim._s.SetParameterString('w_trimestre',WtA(w_trimestre,'C'));
opert_estr_trim._s.SetParameterString('w_tipo',WtA(w_tipo,'C'));
opert_estr_trim._s.SetParameterString('m_bApplet','true');
opert_estr_trim._s.CallServlet('opert_estr_trim');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_estr_trim._s.errmsg;
}
return opert_estr_trim._s.GetString();
}
opert_estr_trim.CtxLoad_ = function(){return []}
