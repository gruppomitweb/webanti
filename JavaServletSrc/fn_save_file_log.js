function fn_save_file_log() {
var Messaggio;
var m_Caller
fn_save_file_log._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
Messaggio='';
}
if(fn_save_file_log._p.length>0)_rargs([[['Messaggio',fn_save_file_log._p[0]]]],{eval:function(e){eval(e)}})
fn_save_file_log._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fn_save_file_log._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fn_save_file_log._s.SetParameterString('Messaggio',WtA(Messaggio,'M'));
fn_save_file_log._s.SetParameterString('m_bApplet','true');
fn_save_file_log._s.CallServlet('fn_save_file_log');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fn_save_file_log._s.errmsg;
}
return fn_save_file_log._s.GetString();
}
fn_save_file_log.CtxLoad_ = function(){return []}
