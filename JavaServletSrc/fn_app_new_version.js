function fn_app_new_version() {
var pAppl;
var pRelease;
var m_Caller
fn_app_new_version._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAppl='';
pRelease='';
}
if(fn_app_new_version._p.length>0)_rargs([[['pAppl',fn_app_new_version._p[0]],['pRelease',fn_app_new_version._p[1]]]],{eval:function(e){eval(e)}})
fn_app_new_version._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fn_app_new_version._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fn_app_new_version._s.SetParameterString('pAppl',WtA(pAppl,'C'));
fn_app_new_version._s.SetParameterString('pRelease',WtA(pRelease,'C'));
fn_app_new_version._s.SetParameterString('m_bApplet','true');
fn_app_new_version._s.CallServlet('fn_app_new_version');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fn_app_new_version._s.errmsg;
}
return fn_app_new_version._s.GetString();
}
fn_app_new_version.CtxLoad_ = function(){return []}
