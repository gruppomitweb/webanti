function arfn_fam_mesefile() {
var pRow;
var pInvio;
var pTipo;
var m_Caller
arfn_fam_mesefile._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pInvio='';
pTipo='';
}
if(arfn_fam_mesefile._p.length>0)_rargs([[['pRow',arfn_fam_mesefile._p[0]],['pInvio',arfn_fam_mesefile._p[1]],['pTipo',arfn_fam_mesefile._p[2]]]],{eval:function(e){eval(e)}})
arfn_fam_mesefile._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fam_mesefile._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fam_mesefile._s.SetParameterString('pRow',WtA(pRow,'R'),pRow);
arfn_fam_mesefile._s.SetParameterString('pInvio',WtA(pInvio,'C'));
arfn_fam_mesefile._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_fam_mesefile._s.SetParameterString('m_bApplet','true');
arfn_fam_mesefile._s.CallServlet('arfn_fam_mesefile');
pRow.Copy(arfn_fam_mesefile._s.GetCallerMemoryCursorRowVar('pRow'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fam_mesefile._s.errmsg;
}
return arfn_fam_mesefile._s.GetBoolean();
}
arfn_fam_mesefile.CtxLoad_ = function(){return []}
