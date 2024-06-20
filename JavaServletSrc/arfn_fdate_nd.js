function arfn_fdate_nd() {
var pDate;
var pSpace;
var m_Caller
arfn_fdate_nd._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDate=NullDate();
pSpace='';
}
if(arfn_fdate_nd._p.length>0)_rargs([[['pDate',arfn_fdate_nd._p[0]],['pSpace',arfn_fdate_nd._p[1]]]],{eval:function(e){eval(e)}})
arfn_fdate_nd._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fdate_nd._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fdate_nd._s.SetParameterString('pDate',WtA(pDate,'D'));
arfn_fdate_nd._s.SetParameterString('pSpace',WtA(pSpace,'C'));
arfn_fdate_nd._s.SetParameterString('m_bApplet','true');
arfn_fdate_nd._s.CallServlet('arfn_fdate_nd');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fdate_nd._s.errmsg;
}
return arfn_fdate_nd._s.GetString();
}
arfn_fdate_nd.CtxLoad_ = function(){return []}
