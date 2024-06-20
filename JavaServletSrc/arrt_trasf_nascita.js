function arrt_trasf_nascita() {
var w_nomefile;
var m_Caller
arrt_trasf_nascita._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
}
if(arrt_trasf_nascita._p.length>0)_rargs([[['w_nomefile',arrt_trasf_nascita._p[0]]]],{eval:function(e){eval(e)}})
arrt_trasf_nascita._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasf_nascita._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasf_nascita._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_trasf_nascita._s.SetParameterString('m_bApplet','true');
arrt_trasf_nascita._s.CallServlet('arrt_trasf_nascita');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasf_nascita._s.errmsg;
}
return arrt_trasf_nascita._s.GetString();
}
arrt_trasf_nascita.CtxLoad_ = function(){return []}
