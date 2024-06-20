function arfn_chksint() {
var pSet;
var m_Caller
arfn_chksint._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSet='';
}
if(arfn_chksint._p.length>0)_rargs([[['pSet',arfn_chksint._p[0]]]],{eval:function(e){eval(e)}})
arfn_chksint._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chksint._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chksint._s.SetParameterString('pSet',WtA(pSet,'C'));
arfn_chksint._s.SetParameterString('m_bApplet','true');
arfn_chksint._s.CallServlet('arfn_chksint');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chksint._s.errmsg;
}
return arfn_chksint._s.GetBoolean();
}
arfn_chksint.CtxLoad_ = function(){return []}
