function arfn_dt_to_date() {
var pDate;
var m_Caller
arfn_dt_to_date._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDate=NullDateTime();
}
if(arfn_dt_to_date._p.length>0)_rargs([[['pDate',arfn_dt_to_date._p[0]]]],{eval:function(e){eval(e)}})
arfn_dt_to_date._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_dt_to_date._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_dt_to_date._s.SetParameterString('pDate',WtA(pDate,'T'));
arfn_dt_to_date._s.SetParameterString('m_bApplet','true');
arfn_dt_to_date._s.CallServlet('arfn_dt_to_date');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_dt_to_date._s.errmsg;
}
return DateFromApplet(arfn_dt_to_date._s.GetDate());
}
arfn_dt_to_date.CtxLoad_ = function(){return []}
