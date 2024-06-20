function arfn_dcausali() {
var pTipo;
var pCode;
var m_Caller
arfn_dcausali._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pCode='';
}
if(arfn_dcausali._p.length>0)_rargs([[['pTipo',arfn_dcausali._p[0]],['pCode',arfn_dcausali._p[1]]]],{eval:function(e){eval(e)}})
arfn_dcausali._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_dcausali._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_dcausali._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_dcausali._s.SetParameterString('pCode',WtA(pCode,'C'));
arfn_dcausali._s.SetParameterString('m_bApplet','true');
arfn_dcausali._s.CallServlet('arfn_dcausali');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_dcausali._s.errmsg;
}
return arfn_dcausali._s.GetString();
}
arfn_dcausali.CtxLoad_ = function(){return []}
