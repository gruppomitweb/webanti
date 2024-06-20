function allinea_doppioni() {
var w_rfile;
var m_Caller
allinea_doppioni._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_rfile='';
}
if(allinea_doppioni._p.length>0)_rargs([[['w_rfile',allinea_doppioni._p[0]]]],{eval:function(e){eval(e)}})
allinea_doppioni._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_doppioni._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_doppioni._s.SetParameterString('w_rfile',WtA(w_rfile,'C'));
allinea_doppioni._s.SetParameterString('m_bApplet','true');
allinea_doppioni._s.CallServlet('allinea_doppioni');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_doppioni._s.errmsg;
}
}
allinea_doppioni.CtxLoad_ = function(){return []}
