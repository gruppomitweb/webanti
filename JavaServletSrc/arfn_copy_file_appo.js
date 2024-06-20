function arfn_copy_file_appo() {
var pNomeFile;
var pCartella;
var m_Caller
arfn_copy_file_appo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNomeFile='';
pCartella='';
}
if(arfn_copy_file_appo._p.length>0)_rargs([[['pNomeFile',arfn_copy_file_appo._p[0]],['pCartella',arfn_copy_file_appo._p[1]]]],{eval:function(e){eval(e)}})
arfn_copy_file_appo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_copy_file_appo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_copy_file_appo._s.SetParameterString('pNomeFile',WtA(pNomeFile,'C'));
arfn_copy_file_appo._s.SetParameterString('pCartella',WtA(pCartella,'C'));
arfn_copy_file_appo._s.SetParameterString('m_bApplet','true');
arfn_copy_file_appo._s.CallServlet('arfn_copy_file_appo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_copy_file_appo._s.errmsg;
}
return arfn_copy_file_appo._s.GetString();
}
arfn_copy_file_appo.CtxLoad_ = function(){return []}
