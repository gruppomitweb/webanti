function arfn_dttod() {
var pDT;
var m_Caller
arfn_dttod._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDT=NullDateTime();
}
if(arfn_dttod._p.length>0)_rargs([[['pDT',arfn_dttod._p[0]]]],{eval:function(e){eval(e)}})
arfn_dttod._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_dttod._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_dttod._s.SetParameterString('pDT',WtA(pDT,'T'));
arfn_dttod._s.SetParameterString('m_bApplet','true');
arfn_dttod._s.CallServlet('arfn_dttod');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_dttod._s.errmsg;
}
return DateFromApplet(arfn_dttod._s.GetDate());
}
arfn_dttod.CtxLoad_ = function(){return []}
