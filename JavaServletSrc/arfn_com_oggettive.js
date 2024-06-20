function arfn_com_oggettive() {
var pAnno;
var pMese;
var pLimite;
var pI3I4;
var m_Caller
arfn_com_oggettive._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pMese='';
pLimite=0;
pI3I4='';
}
if(arfn_com_oggettive._p.length>0)_rargs([[['pAnno',arfn_com_oggettive._p[0]],['pMese',arfn_com_oggettive._p[1]],['pLimite',arfn_com_oggettive._p[2]],['pI3I4',arfn_com_oggettive._p[3]]]],{eval:function(e){eval(e)}})
arfn_com_oggettive._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_com_oggettive._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_com_oggettive._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_com_oggettive._s.SetParameterString('pMese',WtA(pMese,'C'));
arfn_com_oggettive._s.SetParameterString('pLimite',WtA(pLimite,'N'));
arfn_com_oggettive._s.SetParameterString('pI3I4',WtA(pI3I4,'C'));
arfn_com_oggettive._s.SetParameterString('m_bApplet','true');
arfn_com_oggettive._s.CallServlet('arfn_com_oggettive');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_com_oggettive._s.errmsg;
}
return arfn_com_oggettive._s.GetString();
}
arfn_com_oggettive.CtxLoad_ = function(){return []}
