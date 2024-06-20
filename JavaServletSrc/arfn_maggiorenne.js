function arfn_maggiorenne() {
var pDatNas;
var pDatOpe;
var m_Caller
arfn_maggiorenne._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatNas=NullDate();
pDatOpe=NullDate();
}
if(arfn_maggiorenne._p.length>0)_rargs([[['pDatNas',arfn_maggiorenne._p[0]],['pDatOpe',arfn_maggiorenne._p[1]]]],{eval:function(e){eval(e)}})
arfn_maggiorenne._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_maggiorenne._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_maggiorenne._s.SetParameterString('pDatNas',WtA(pDatNas,'D'));
arfn_maggiorenne._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_maggiorenne._s.SetParameterString('m_bApplet','true');
arfn_maggiorenne._s.CallServlet('arfn_maggiorenne');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_maggiorenne._s.errmsg;
}
return arfn_maggiorenne._s.GetBoolean();
}
arfn_maggiorenne.CtxLoad_ = function(){return []}
