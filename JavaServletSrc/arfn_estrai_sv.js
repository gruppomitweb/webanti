function arfn_estrai_sv() {
var pAnno;
var pTri;
var pSegno;
var m_Caller
arfn_estrai_sv._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
pSegno='';
}
if(arfn_estrai_sv._p.length>0)_rargs([[['pAnno',arfn_estrai_sv._p[0]],['pTri',arfn_estrai_sv._p[1]],['pSegno',arfn_estrai_sv._p[2]]]],{eval:function(e){eval(e)}})
arfn_estrai_sv._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_estrai_sv._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_estrai_sv._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_estrai_sv._s.SetParameterString('pTri',WtA(pTri,'N'));
arfn_estrai_sv._s.SetParameterString('pSegno',WtA(pSegno,'C'));
arfn_estrai_sv._s.SetParameterString('m_bApplet','true');
arfn_estrai_sv._s.CallServlet('arfn_estrai_sv');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_estrai_sv._s.errmsg;
}
return arfn_estrai_sv._s.GetString();
}
arfn_estrai_sv.CtxLoad_ = function(){return []}
