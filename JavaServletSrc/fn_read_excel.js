function fn_read_excel() {
var path_file_import;
var m_Caller
fn_read_excel._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
path_file_import='';
}
if(fn_read_excel._p.length>0)_rargs([[['path_file_import',fn_read_excel._p[0]]]],{eval:function(e){eval(e)}})
fn_read_excel._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fn_read_excel._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fn_read_excel._s.SetParameterString('path_file_import',WtA(path_file_import,'C'));
fn_read_excel._s.SetParameterString('m_bApplet','true');
fn_read_excel._s.CallServlet('fn_read_excel');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fn_read_excel._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=fn_read_excel._s.errmsg;
fn_read_excel._res=new CPMemoryCursor();
} else {
fn_read_excel._res=fn_read_excel._s.GetMemoryCursor();
}
return fn_read_excel._res;
}
fn_read_excel.CtxLoad_ = function(){return []}
