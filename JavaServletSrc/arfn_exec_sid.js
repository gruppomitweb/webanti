function arfn_exec_sid() {
var pFile;
var pAnno;
var m_Caller
arfn_exec_sid._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pAnno='';
}
if(arfn_exec_sid._p.length>0)_rargs([[['pFile',arfn_exec_sid._p[0]],['pAnno',arfn_exec_sid._p[1]]]],{eval:function(e){eval(e)}})
arfn_exec_sid._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_exec_sid._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_exec_sid._s.SetParameterString('pFile',WtA(pFile,'C'));
arfn_exec_sid._s.SetParameterString('pAnno',WtA(pAnno,'C'));
arfn_exec_sid._s.SetParameterString('m_bApplet','true');
arfn_exec_sid._s.CallServlet('arfn_exec_sid');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_exec_sid._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_exec_sid._s.errmsg;
arfn_exec_sid._res=new CPMemoryCursor();
} else {
arfn_exec_sid._res=arfn_exec_sid._s.GetMemoryCursor();
}
return arfn_exec_sid._res;
}
arfn_exec_sid.CtxLoad_ = function(){return []}
