function arrt_estrai_sv_check() {
var pAnno;
var pTri;
var m_Caller
arrt_estrai_sv_check._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
}
if(arrt_estrai_sv_check._p.length>0)_rargs([[['pAnno',arrt_estrai_sv_check._p[0]],['pTri',arrt_estrai_sv_check._p[1]]]],{eval:function(e){eval(e)}})
arrt_estrai_sv_check._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_sv_check._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_sv_check._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arrt_estrai_sv_check._s.SetParameterString('pTri',WtA(pTri,'N'));
arrt_estrai_sv_check._s.SetParameterString('m_bApplet','true');
arrt_estrai_sv_check._s.CallServlet('arrt_estrai_sv_check');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_sv_check._s.errmsg;
}
}
arrt_estrai_sv_check.CtxLoad_ = function(){return []}
