function arrt_fam_delete() {
var m_Caller
arrt_fam_delete._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_fam_delete._p.length>0)_rargs([[['pObj',arrt_fam_delete._p[0]]]],{eval:function(e){eval(e)}})
arrt_fam_delete._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_fam_delete._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_fam_delete._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_fam_delete._s.SetParameterString('m_bApplet','true');
arrt_fam_delete._s.CallServlet('arrt_fam_delete');
if (Gt(arrt_fam_delete._p.length,0)) {
arrt_fam_delete._p[0].SetFromContext(arrt_fam_delete._s.GetCallerStringVar('pObj'));
} else {
arrt_fam_delete._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_fam_delete._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_fam_delete._search_par,'pObj')][1].SetFromContext(arrt_fam_delete._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_fam_delete._s.errmsg;
}
}
arrt_fam_delete.CtxLoad_ = function(){return []}
