function arrt_fammigra_old() {
var pAzzera;
var m_Caller
arrt_fammigra_old._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAzzera='';
}
if(arrt_fammigra_old._p.length>0)_rargs([[['pAzzera',arrt_fammigra_old._p[0]]]],{eval:function(e){eval(e)}})
arrt_fammigra_old._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fammigra_old._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fammigra_old._s.SetParameterString('pAzzera',WtA(pAzzera,'C'));
arrt_fammigra_old._s.SetParameterString('m_bApplet','true');
arrt_fammigra_old._s.CallServlet('arrt_fammigra_old');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fammigra_old._s.errmsg;
}
return arrt_fammigra_old._s.GetString();
}
arrt_fammigra_old.CtxLoad_ = function(){return []}