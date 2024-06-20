function arrt_estrai_sv_check_all() {
var pAnno;
var pTri;
var pTipo;
var pFile;
var pTipoBase3;
var pFraudo;
var m_Caller
arrt_estrai_sv_check_all._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
pTipo='';
pFile='';
pTipoBase3='';
pFraudo='';
}
if(arrt_estrai_sv_check_all._p.length>0)_rargs([[['pAnno',arrt_estrai_sv_check_all._p[0]],['pTri',arrt_estrai_sv_check_all._p[1]],['pTipo',arrt_estrai_sv_check_all._p[2]],['pFile',arrt_estrai_sv_check_all._p[3]],['pTipoBase3',arrt_estrai_sv_check_all._p[4]],['pFraudo',arrt_estrai_sv_check_all._p[5]]]],{eval:function(e){eval(e)}})
arrt_estrai_sv_check_all._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_sv_check_all._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_sv_check_all._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arrt_estrai_sv_check_all._s.SetParameterString('pTri',WtA(pTri,'N'));
arrt_estrai_sv_check_all._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_estrai_sv_check_all._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_estrai_sv_check_all._s.SetParameterString('pTipoBase3',WtA(pTipoBase3,'C'));
arrt_estrai_sv_check_all._s.SetParameterString('pFraudo',WtA(pFraudo,'C'));
arrt_estrai_sv_check_all._s.SetParameterString('m_bApplet','true');
arrt_estrai_sv_check_all._s.CallServlet('arrt_estrai_sv_check_all');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_sv_check_all._s.errmsg;
}
return arrt_estrai_sv_check_all._s.GetString();
}
arrt_estrai_sv_check_all.CtxLoad_ = function(){return []}
