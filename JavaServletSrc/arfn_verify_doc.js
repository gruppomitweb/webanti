function arfn_verify_doc() {
var pTipo;
var pNomeDoc;
var pTipoGioco;
var pImpTick;
var pImpCont;
var pCodDip;
var m_Caller
arfn_verify_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo=0;
pNomeDoc='';
pTipoGioco='';
pImpTick=0;
pImpCont=0;
pCodDip='';
}
if(arfn_verify_doc._p.length>0)_rargs([[['pTipo',arfn_verify_doc._p[0]],['pNomeDoc',arfn_verify_doc._p[1]],['pTipoGioco',arfn_verify_doc._p[2]],['pImpTick',arfn_verify_doc._p[3]],['pImpCont',arfn_verify_doc._p[4]],['pCodDip',arfn_verify_doc._p[5]]]],{eval:function(e){eval(e)}})
arfn_verify_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_verify_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_verify_doc._s.SetParameterString('pTipo',WtA(pTipo,'N'));
arfn_verify_doc._s.SetParameterString('pNomeDoc',WtA(pNomeDoc,'C'));
arfn_verify_doc._s.SetParameterString('pTipoGioco',WtA(pTipoGioco,'C'));
arfn_verify_doc._s.SetParameterString('pImpTick',WtA(pImpTick,'N'));
arfn_verify_doc._s.SetParameterString('pImpCont',WtA(pImpCont,'N'));
arfn_verify_doc._s.SetParameterString('pCodDip',WtA(pCodDip,'C'));
arfn_verify_doc._s.SetParameterString('m_bApplet','true');
arfn_verify_doc._s.CallServlet('arfn_verify_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_verify_doc._s.errmsg;
}
return arfn_verify_doc._s.GetString();
}
arfn_verify_doc.CtxLoad_ = function(){return []}
