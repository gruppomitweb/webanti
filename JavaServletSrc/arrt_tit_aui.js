function arrt_tit_aui() {
var pTipo;
var pCliente;
var pMand;
var m_Caller
arrt_tit_aui._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pCliente='';
pMand='';
}
if(arrt_tit_aui._p.length>0)_rargs([[['pTipo',arrt_tit_aui._p[0]],['pCliente',arrt_tit_aui._p[1]],['pMand',arrt_tit_aui._p[2]]]],{eval:function(e){eval(e)}})
arrt_tit_aui._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_tit_aui._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_tit_aui._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_tit_aui._s.SetParameterString('pCliente',WtA(pCliente,'C'));
arrt_tit_aui._s.SetParameterString('pMand',WtA(pMand,'C'));
arrt_tit_aui._s.SetParameterString('m_bApplet','true');
arrt_tit_aui._s.CallServlet('arrt_tit_aui');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_tit_aui._s.errmsg;
}
}
arrt_tit_aui.CtxLoad_ = function(){return []}
