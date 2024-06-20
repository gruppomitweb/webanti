function rt_mod_ind_def_int() {
var p_cEventName;
var m_Caller
rt_mod_ind_def_int._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
p_cEventName='';
}
if(rt_mod_ind_def_int._p.length>0)_rargs([[['p_cEventName',rt_mod_ind_def_int._p[0]]]],{eval:function(e){eval(e)}})
rt_mod_ind_def_int._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
rt_mod_ind_def_int._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
rt_mod_ind_def_int._s.SetParameterString('p_cEventName',WtA(p_cEventName,'C'));
rt_mod_ind_def_int._s.SetParameterString('m_bApplet','true');
rt_mod_ind_def_int._s.CallServlet('rt_mod_ind_def_int');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=rt_mod_ind_def_int._s.errmsg;
}
}
rt_mod_ind_def_int.CtxLoad_ = function(){return []}
