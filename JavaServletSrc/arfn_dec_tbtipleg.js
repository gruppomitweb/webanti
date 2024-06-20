function arfn_dec_tbtipleg() {
var pDatOpe;
var pTipo;
var m_Caller
arfn_dec_tbtipleg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatOpe=NullDate();
pTipo='';
}
if(arfn_dec_tbtipleg._p.length>0)_rargs([[['pDatOpe',arfn_dec_tbtipleg._p[0]],['pTipo',arfn_dec_tbtipleg._p[1]]]],{eval:function(e){eval(e)}})
arfn_dec_tbtipleg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_dec_tbtipleg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_dec_tbtipleg._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_dec_tbtipleg._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_dec_tbtipleg._s.SetParameterString('m_bApplet','true');
arfn_dec_tbtipleg._s.CallServlet('arfn_dec_tbtipleg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_dec_tbtipleg._s.errmsg;
}
return arfn_dec_tbtipleg._s.GetString();
}
arfn_dec_tbtipleg.CtxLoad_ = function(){return []}
