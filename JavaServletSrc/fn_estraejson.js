function fn_estraejson() {
var mcObjects;
var oldValue;
var m_Caller
fn_estraejson._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
oldValue='';
}
if(fn_estraejson._p.length>0)_rargs([[['jsonSorgente',fn_estraejson._p[0]],['mcObjects',fn_estraejson._p[1]],['oldValue',fn_estraejson._p[2]]]],{eval:function(e){eval(e)}})
fn_estraejson._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
fn_estraejson._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
fn_estraejson._s.SetParameterString('jsonSorgente',WtA(jsonSorgente,'C'));
fn_estraejson._s.SetParameterString('mcObjects',WtA(mcObjects,'MC'),mcObjects);
fn_estraejson._s.SetParameterString('oldValue',WtA(oldValue,'C'));
fn_estraejson._s.SetParameterString('m_bApplet','true');
fn_estraejson._s.CallServlet('fn_estraejson');
mcObjects._Copy(fn_estraejson._s.GetCallerMemoryCursorVar('mcObjects'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=fn_estraejson._s.errmsg;
}
return fn_estraejson._s.GetString();
}
fn_estraejson.CtxLoad_ = function(){return []}
