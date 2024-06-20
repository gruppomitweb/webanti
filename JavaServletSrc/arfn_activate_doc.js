function arfn_activate_doc() {
var pGioco;
var pTotale;
var pContanti;
var m_Caller
arfn_activate_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pGioco='';
pTotale=0;
pContanti=0;
}
if(arfn_activate_doc._p.length>0)_rargs([[['pGioco',arfn_activate_doc._p[0]],['pTotale',arfn_activate_doc._p[1]],['pContanti',arfn_activate_doc._p[2]]]],{eval:function(e){eval(e)}})
arfn_activate_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_activate_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_activate_doc._s.SetParameterString('pGioco',WtA(pGioco,'C'));
arfn_activate_doc._s.SetParameterString('pTotale',WtA(pTotale,'N'));
arfn_activate_doc._s.SetParameterString('pContanti',WtA(pContanti,'N'));
arfn_activate_doc._s.SetParameterString('m_bApplet','true');
arfn_activate_doc._s.CallServlet('arfn_activate_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_activate_doc._s.errmsg;
}
return arfn_activate_doc._s.GetString();
}
arfn_activate_doc.CtxLoad_ = function(){return []}
