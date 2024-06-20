function arfn_famanag() {
var pNDG;
var pRuolo;
var m_Caller
arfn_famanag._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNDG='';
pRuolo='';
}
if(arfn_famanag._p.length>0)_rargs([[['pNDG',arfn_famanag._p[0]],['pRuolo',arfn_famanag._p[1]]]],{eval:function(e){eval(e)}})
arfn_famanag._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_famanag._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_famanag._s.SetParameterString('pNDG',WtA(pNDG,'C'));
arfn_famanag._s.SetParameterString('pRuolo',WtA(pRuolo,'C'));
arfn_famanag._s.SetParameterString('m_bApplet','true');
arfn_famanag._s.CallServlet('arfn_famanag');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_famanag._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_famanag._s.errmsg;
arfn_famanag._res=new CPMemoryCursor();
} else {
arfn_famanag._res=arfn_famanag._s.GetMemoryCursorRow();
}
return arfn_famanag._res;
}
arfn_famanag.CtxLoad_ = function(){return []}
