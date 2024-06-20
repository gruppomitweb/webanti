function arfn_anomsaldi_rapp() {
var pRapporto;
var pTipo;
var pAnno;
var m_Caller
arfn_anomsaldi_rapp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRapporto='';
pTipo='';
pAnno=0;
}
if(arfn_anomsaldi_rapp._p.length>0)_rargs([[['pRapporto',arfn_anomsaldi_rapp._p[0]],['pTipo',arfn_anomsaldi_rapp._p[1]],['pAnno',arfn_anomsaldi_rapp._p[2]]]],{eval:function(e){eval(e)}})
arfn_anomsaldi_rapp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_anomsaldi_rapp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_anomsaldi_rapp._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_anomsaldi_rapp._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_anomsaldi_rapp._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_anomsaldi_rapp._s.SetParameterString('m_bApplet','true');
arfn_anomsaldi_rapp._s.CallServlet('arfn_anomsaldi_rapp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_anomsaldi_rapp._s.errmsg;
}
return arfn_anomsaldi_rapp._s.GetString();
}
arfn_anomsaldi_rapp.CtxLoad_ = function(){return []}
