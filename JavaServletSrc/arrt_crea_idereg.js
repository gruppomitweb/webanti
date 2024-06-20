function arrt_crea_idereg() {
var pTab;
var pIDB;
var pTipo;
var m_Caller
arrt_crea_idereg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTab='';
pIDB='';
pTipo='';
}
if(arrt_crea_idereg._p.length>0)_rargs([[['pTab',arrt_crea_idereg._p[0]],['pIDB',arrt_crea_idereg._p[1]],['pTipo',arrt_crea_idereg._p[2]]]],{eval:function(e){eval(e)}})
arrt_crea_idereg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_idereg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_idereg._s.SetParameterString('pTab',WtA(pTab,'C'));
arrt_crea_idereg._s.SetParameterString('pIDB',WtA(pIDB,'C'));
arrt_crea_idereg._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_crea_idereg._s.SetParameterString('m_bApplet','true');
arrt_crea_idereg._s.CallServlet('arrt_crea_idereg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_idereg._s.errmsg;
}
}
arrt_crea_idereg.CtxLoad_ = function(){return []}
