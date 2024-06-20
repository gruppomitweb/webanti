function arrt_tit_load_aui() {
var pOper;
var m_Caller
arrt_tit_load_aui._p=_rargs(arguments,{eval:function(e){eval(e)}},null,'arrt_tit_load_aui')
function i_BlankParameters() {
pOper='';
}
if(arrt_tit_load_aui._p.length>0)_rargs([[['pObj',arrt_tit_load_aui._p[0]],['pOper',arrt_tit_load_aui._p[1]]]],{eval:function(e){eval(e)}})
arrt_tit_load_aui._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_tit_load_aui._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_tit_load_aui._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_tit_load_aui._s.SetParameterString('pOper',WtA(pOper,'C'));
arrt_tit_load_aui._s.SetParameterString('m_bApplet','true');
arrt_tit_load_aui._s.CallServlet('arrt_tit_load_aui');
if (Gt(arrt_tit_load_aui._p.length,0)) {
arrt_tit_load_aui._p[0].SetFromContext(arrt_tit_load_aui._s.GetCallerStringVar('pObj'));
} else {
arrt_tit_load_aui._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_tit_load_aui._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_tit_load_aui._search_par,'pObj')][1].SetFromContext(arrt_tit_load_aui._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_tit_load_aui._s.errmsg;
}
}
arrt_tit_load_aui.CtxLoad_ = function(){return []}
