function allinea_anadip() {
var w_rfile;
var m_Caller
allinea_anadip._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_rfile='';
}
if(allinea_anadip._p.length>0)_rargs([[['w_rfile',allinea_anadip._p[0]]]],{eval:function(e){eval(e)}})
allinea_anadip._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
allinea_anadip._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
allinea_anadip._s.SetParameterString('w_rfile',WtA(w_rfile,'C'));
allinea_anadip._s.SetParameterString('m_bApplet','true');
allinea_anadip._s.CallServlet('allinea_anadip');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=allinea_anadip._s.errmsg;
}
}
allinea_anadip.CtxLoad_ = function(){return []}
