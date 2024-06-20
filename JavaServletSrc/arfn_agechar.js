function arfn_agechar() {
var pString;
var pChar;
var m_Caller
arfn_agechar._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pString='';
pChar='';
}
if(arfn_agechar._p.length>0)_rargs([[['pString',arfn_agechar._p[0]],['pChar',arfn_agechar._p[1]]]],{eval:function(e){eval(e)}})
arfn_agechar._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_agechar._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_agechar._s.SetParameterString('pString',WtA(pString,'C'));
arfn_agechar._s.SetParameterString('pChar',WtA(pChar,'C'));
arfn_agechar._s.SetParameterString('m_bApplet','true');
arfn_agechar._s.CallServlet('arfn_agechar');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_agechar._s.errmsg;
}
return arfn_agechar._s.GetString();
}
arfn_agechar.CtxLoad_ = function(){return []}
