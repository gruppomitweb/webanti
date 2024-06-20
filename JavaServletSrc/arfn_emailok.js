function arfn_emailok() {
var pEmail;
var m_Caller
arfn_emailok._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pEmail='';
}
if(arfn_emailok._p.length>0)_rargs([[['pEmail',arfn_emailok._p[0]]]],{eval:function(e){eval(e)}})
arfn_emailok._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_emailok._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_emailok._s.SetParameterString('pEmail',WtA(pEmail,'C'));
arfn_emailok._s.SetParameterString('m_bApplet','true');
arfn_emailok._s.CallServlet('arfn_emailok');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_emailok._s.errmsg;
}
return arfn_emailok._s.GetBoolean();
}
arfn_emailok.CtxLoad_ = function(){return []}
