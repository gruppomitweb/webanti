function arfn_datefchar() {
var pCDate;
var m_Caller
arfn_datefchar._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCDate='';
}
if(arfn_datefchar._p.length>0)_rargs([[['pCDate',arfn_datefchar._p[0]]]],{eval:function(e){eval(e)}})
arfn_datefchar._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_datefchar._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_datefchar._s.SetParameterString('pCDate',WtA(pCDate,'C'));
arfn_datefchar._s.SetParameterString('m_bApplet','true');
arfn_datefchar._s.CallServlet('arfn_datefchar');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_datefchar._s.errmsg;
}
return DateFromApplet(arfn_datefchar._s.GetDate());
}
arfn_datefchar.CtxLoad_ = function(){return []}
