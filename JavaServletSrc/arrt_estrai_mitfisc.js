function arrt_estrai_mitfisc() {
var pTipo;
var w_annofisc;
var pImporto;
var m_Caller
arrt_estrai_mitfisc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
w_annofisc=0;
pImporto=0;
}
if(arrt_estrai_mitfisc._p.length>0)_rargs([[['pTipo',arrt_estrai_mitfisc._p[0]],['w_annofisc',arrt_estrai_mitfisc._p[1]],['pImporto',arrt_estrai_mitfisc._p[2]]]],{eval:function(e){eval(e)}})
arrt_estrai_mitfisc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_mitfisc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_mitfisc._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_estrai_mitfisc._s.SetParameterString('w_annofisc',WtA(w_annofisc,'N'));
arrt_estrai_mitfisc._s.SetParameterString('pImporto',WtA(pImporto,'N'));
arrt_estrai_mitfisc._s.SetParameterString('m_bApplet','true');
arrt_estrai_mitfisc._s.CallServlet('arrt_estrai_mitfisc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_mitfisc._s.errmsg;
}
}
arrt_estrai_mitfisc.CtxLoad_ = function(){return []}
