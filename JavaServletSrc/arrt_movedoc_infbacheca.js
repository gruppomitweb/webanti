function arrt_movedoc_infbacheca() {
var pTipo;
var m_Caller
arrt_movedoc_infbacheca._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_movedoc_infbacheca')
function i_BlankParameters() {
pTipo='';
}
if(arrt_movedoc_infbacheca._p.length>0)_rargs([[['pObj',arrt_movedoc_infbacheca._p[0]],['pTipo',arrt_movedoc_infbacheca._p[1]]]],{eval:function(e){eval(e)}})
arrt_movedoc_infbacheca._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_movedoc_infbacheca._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_movedoc_infbacheca._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_movedoc_infbacheca._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_movedoc_infbacheca._s.SetParameterString('m_bApplet','true');
arrt_movedoc_infbacheca._s.CallServlet('arrt_movedoc_infbacheca');
if (Gt(arrt_movedoc_infbacheca._p.length,0)) {
arrt_movedoc_infbacheca._p[0].SetFromContext(arrt_movedoc_infbacheca._s.GetCallerStringVar('pObj'));
} else {
arrt_movedoc_infbacheca._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_movedoc_infbacheca._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_movedoc_infbacheca._search_par,'pObj')][1].SetFromContext(arrt_movedoc_infbacheca._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_movedoc_infbacheca._s.errmsg;
}
}
arrt_movedoc_infbacheca.CtxLoad_ = function(){return []}
