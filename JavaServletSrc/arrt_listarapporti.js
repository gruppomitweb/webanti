function arrt_listarapporti() {
var pTipo;
var pConnes;
var m_Caller
arrt_listarapporti._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pConnes='';
}
if(arrt_listarapporti._p.length>0)_rargs([[['pTipo',arrt_listarapporti._p[0]],['pConnes',arrt_listarapporti._p[1]]]],{eval:function(e){eval(e)}})
arrt_listarapporti._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_listarapporti._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_listarapporti._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_listarapporti._s.SetParameterString('pConnes',WtA(pConnes,'C'));
arrt_listarapporti._s.SetParameterString('m_bApplet','true');
arrt_listarapporti._s.CallServlet('arrt_listarapporti');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_listarapporti._s.errmsg;
}
}
arrt_listarapporti.CtxLoad_ = function(){return []}
