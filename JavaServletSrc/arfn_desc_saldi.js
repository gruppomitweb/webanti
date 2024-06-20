function arfn_desc_saldi() {
var pTipRap;
var pAnno;
var pImporto;
var m_Caller
arfn_desc_saldi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipRap='';
pAnno=0;
pImporto=0;
}
if(arfn_desc_saldi._p.length>0)_rargs([[['pTipRap',arfn_desc_saldi._p[0]],['pAnno',arfn_desc_saldi._p[1]],['pImporto',arfn_desc_saldi._p[2]]]],{eval:function(e){eval(e)}})
arfn_desc_saldi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_desc_saldi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_desc_saldi._s.SetParameterString('pTipRap',WtA(pTipRap,'C'));
arfn_desc_saldi._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_desc_saldi._s.SetParameterString('pImporto',WtA(pImporto,'N'));
arfn_desc_saldi._s.SetParameterString('m_bApplet','true');
arfn_desc_saldi._s.CallServlet('arfn_desc_saldi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_desc_saldi._s.errmsg;
}
return arfn_desc_saldi._s.GetString();
}
arfn_desc_saldi.CtxLoad_ = function(){return []}
