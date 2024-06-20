function spgetentityroles() {
var progname;
var m_Caller
spgetentityroles._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
progname='';
}
if(spgetentityroles._p.length>0)_rargs([[['progname',spgetentityroles._p[0]]]],{eval:function(e){eval(e)}})
spgetentityroles._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spgetentityroles._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spgetentityroles._s.SetParameterString('progname',WtA(progname,'C'));
spgetentityroles._s.SetParameterString('m_bApplet','true');
spgetentityroles._s.CallServlet('spgetentityroles');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spgetentityroles._s.errmsg;
}
return spgetentityroles._s.GetString();
}
spgetentityroles.CtxLoad_ = function(){return []}
