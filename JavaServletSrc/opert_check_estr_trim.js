function opert_check_estr_trim() {
var w_anno;
var w_trimestre;
var m_Caller
opert_check_estr_trim._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_anno='';
w_trimestre='';
}
if(opert_check_estr_trim._p.length>0)_rargs([[['w_anno',opert_check_estr_trim._p[0]],['w_trimestre',opert_check_estr_trim._p[1]]]],{eval:function(e){eval(e)}})
opert_check_estr_trim._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
opert_check_estr_trim._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
opert_check_estr_trim._s.SetParameterString('w_anno',WtA(w_anno,'C'));
opert_check_estr_trim._s.SetParameterString('w_trimestre',WtA(w_trimestre,'C'));
opert_check_estr_trim._s.SetParameterString('m_bApplet','true');
opert_check_estr_trim._s.CallServlet('opert_check_estr_trim');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=opert_check_estr_trim._s.errmsg;
}
return opert_check_estr_trim._s.GetDouble();
}
opert_check_estr_trim.CtxLoad_ = function(){return []}
