function arfn_estrai_sv_all() {
var pAnno;
var pTri;
var pSegno;
var pLCC;
var pTipoBase3;
var pFraudo;
var m_Caller
arfn_estrai_sv_all._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
pSegno='';
pLCC='';
pTipoBase3='';
pFraudo='';
}
if(arfn_estrai_sv_all._p.length>0)_rargs([[['pAnno',arfn_estrai_sv_all._p[0]],['pTri',arfn_estrai_sv_all._p[1]],['pSegno',arfn_estrai_sv_all._p[2]],['pLCC',arfn_estrai_sv_all._p[3]],['pTipoBase3',arfn_estrai_sv_all._p[4]],['pFraudo',arfn_estrai_sv_all._p[5]]]],{eval:function(e){eval(e)}})
arfn_estrai_sv_all._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_estrai_sv_all._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_estrai_sv_all._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_estrai_sv_all._s.SetParameterString('pTri',WtA(pTri,'N'));
arfn_estrai_sv_all._s.SetParameterString('pSegno',WtA(pSegno,'C'));
arfn_estrai_sv_all._s.SetParameterString('pLCC',WtA(pLCC,'C'));
arfn_estrai_sv_all._s.SetParameterString('pTipoBase3',WtA(pTipoBase3,'C'));
arfn_estrai_sv_all._s.SetParameterString('pFraudo',WtA(pFraudo,'C'));
arfn_estrai_sv_all._s.SetParameterString('m_bApplet','true');
arfn_estrai_sv_all._s.CallServlet('arfn_estrai_sv_all');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_estrai_sv_all._s.errmsg;
}
return arfn_estrai_sv_all._s.GetString();
}
arfn_estrai_sv_all.CtxLoad_ = function(){return []}
