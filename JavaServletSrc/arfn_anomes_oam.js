function arfn_anomes_oam() {
var pRiga;
var pNCF;
var m_Caller
arfn_anomes_oam._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNCF='';
}
if(arfn_anomes_oam._p.length>0)_rargs([[['pRiga',arfn_anomes_oam._p[0]],['pNCF',arfn_anomes_oam._p[1]]]],{eval:function(e){eval(e)}})
arfn_anomes_oam._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_anomes_oam._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_anomes_oam._s.SetParameterString('pRiga',WtA(pRiga,'R'),pRiga);
arfn_anomes_oam._s.SetParameterString('pNCF',WtA(pNCF,'C'));
arfn_anomes_oam._s.SetParameterString('m_bApplet','true');
arfn_anomes_oam._s.CallServlet('arfn_anomes_oam');
pRiga.Copy(arfn_anomes_oam._s.GetCallerMemoryCursorRowVar('pRiga'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_anomes_oam._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_anomes_oam._s.errmsg;
arfn_anomes_oam._res=new CPMemoryCursor();
} else {
arfn_anomes_oam._res=arfn_anomes_oam._s.GetMemoryCursor();
if (Eq(arfn_anomes_oam._res,arfn_anomes_oam._s.GetCallerMemoryCursorRowVar('pRiga'))) {
arfn_anomes_oam._res=pRiga;
}
}
return arfn_anomes_oam._res;
}
arfn_anomes_oam.CtxLoad_ = function(){return []}
