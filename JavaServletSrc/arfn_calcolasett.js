function arfn_calcolasett() {
var w_SOTGRUP;
var w_RAMOGRUP;
var w_ATTIV;
var m_Caller
arfn_calcolasett._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_SOTGRUP='';
w_RAMOGRUP='';
w_ATTIV='';
}
if(arfn_calcolasett._p.length>0)_rargs([[['w_SOTGRUP',arfn_calcolasett._p[0]],['w_RAMOGRUP',arfn_calcolasett._p[1]],['w_ATTIV',arfn_calcolasett._p[2]]]],{eval:function(e){eval(e)}})
arfn_calcolasett._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_calcolasett._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_calcolasett._s.SetParameterString('w_SOTGRUP',WtA(w_SOTGRUP,'C'));
arfn_calcolasett._s.SetParameterString('w_RAMOGRUP',WtA(w_RAMOGRUP,'C'));
arfn_calcolasett._s.SetParameterString('w_ATTIV',WtA(w_ATTIV,'C'));
arfn_calcolasett._s.SetParameterString('m_bApplet','true');
arfn_calcolasett._s.CallServlet('arfn_calcolasett');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_calcolasett._s.errmsg;
}
return arfn_calcolasett._s.GetString();
}
arfn_calcolasett.CtxLoad_ = function(){return []}
