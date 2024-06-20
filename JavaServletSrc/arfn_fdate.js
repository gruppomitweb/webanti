function arfn_fdate() {
var pDate;
var m_Caller
arfn_fdate._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDate=NullDate();
}
if(arfn_fdate._p.length>0)_rargs([[['pDate',arfn_fdate._p[0]]]],{eval:function(e){eval(e)}})
arfn_fdate._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fdate._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fdate._s.SetParameterString('pDate',WtA(pDate,'D'));
arfn_fdate._s.SetParameterString('m_bApplet','true');
arfn_fdate._s.CallServlet('arfn_fdate');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fdate._s.errmsg;
}
return arfn_fdate._s.GetString();
}
arfn_fdate.CtxLoad_ = function(){return []}
