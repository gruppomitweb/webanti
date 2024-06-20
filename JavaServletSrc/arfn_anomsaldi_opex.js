function arfn_anomsaldi_opex() {
var pRapporto;
var pTipo;
var pAnno;
var m_Caller
arfn_anomsaldi_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
pTipo='';
pAnno='';
}
if(arfn_anomsaldi_opex._p.length>0)_rargs([[['pRapporto',arfn_anomsaldi_opex._p[0]],['pTipo',arfn_anomsaldi_opex._p[1]],['pAnno',arfn_anomsaldi_opex._p[2]]]],{eval:function(e){eval(e)}})
arfn_anomsaldi_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_anomsaldi_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_anomsaldi_opex._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_anomsaldi_opex._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_anomsaldi_opex._s.SetParameterString('pAnno',WtA(pAnno,'C'));
arfn_anomsaldi_opex._s.SetParameterString('m_bApplet','true');
arfn_anomsaldi_opex._s.CallServlet('arfn_anomsaldi_opex');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_anomsaldi_opex._s.errmsg;
}
return arfn_anomsaldi_opex._s.GetString();
}
arfn_anomsaldi_opex.CtxLoad_ = function(){return []}
