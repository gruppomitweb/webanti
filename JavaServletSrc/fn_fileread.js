function fn_fileread() {
var dir;
var level;
var filtro;
var estenzione;
var fileName;
var m_Caller
fn_fileread._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
dir='';
level=0;
filtro='';
estenzione='';
fileName='';
}
if(fn_fileread._p.length>0)_rargs([[['dir',fn_fileread._p[0]],['level',fn_fileread._p[1]],['filtro',fn_fileread._p[2]],['estenzione',fn_fileread._p[3]],['fileName',fn_fileread._p[4]]]],{eval:function(e){eval(e)}})
fn_fileread._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fn_fileread._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fn_fileread._s.SetParameterString('dir',WtA(dir,'C'));
fn_fileread._s.SetParameterString('level',WtA(level,'N'));
fn_fileread._s.SetParameterString('filtro',WtA(filtro,'C'));
fn_fileread._s.SetParameterString('estenzione',WtA(estenzione,'C'));
fn_fileread._s.SetParameterString('fileName',WtA(fileName,'C'));
fn_fileread._s.SetParameterString('m_bApplet','true');
fn_fileread._s.CallServlet('fn_fileread');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fn_fileread._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=fn_fileread._s.errmsg;
fn_fileread._res=new CPMemoryCursor();
} else {
fn_fileread._res=fn_fileread._s.GetMemoryCursor();
}
return fn_fileread._res;
}
fn_fileread.CtxLoad_ = function(){return []}
