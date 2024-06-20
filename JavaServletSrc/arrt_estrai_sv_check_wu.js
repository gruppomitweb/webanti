function arrt_estrai_sv_check_wu() {
var pAnno;
var pTri;
var pTipo;
var pFile;
var m_Caller
arrt_estrai_sv_check_wu._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
pTipo='';
pFile='';
}
if(arrt_estrai_sv_check_wu._p.length>0)_rargs([[['pAnno',arrt_estrai_sv_check_wu._p[0]],['pTri',arrt_estrai_sv_check_wu._p[1]],['pTipo',arrt_estrai_sv_check_wu._p[2]],['pFile',arrt_estrai_sv_check_wu._p[3]]]],{eval:function(e){eval(e)}})
arrt_estrai_sv_check_wu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_sv_check_wu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_sv_check_wu._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arrt_estrai_sv_check_wu._s.SetParameterString('pTri',WtA(pTri,'N'));
arrt_estrai_sv_check_wu._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_estrai_sv_check_wu._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_estrai_sv_check_wu._s.SetParameterString('m_bApplet','true');
arrt_estrai_sv_check_wu._s.CallServlet('arrt_estrai_sv_check_wu');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_sv_check_wu._s.errmsg;
}
return arrt_estrai_sv_check_wu._s.GetString();
}
arrt_estrai_sv_check_wu.CtxLoad_ = function(){return []}
