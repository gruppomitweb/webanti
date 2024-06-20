function arfn_fdate_bp() {
var pDate;
var m_Caller
arfn_fdate_bp._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDate=NullDate();
}
if(arfn_fdate_bp._p.length>0)_rargs([[['pDate',arfn_fdate_bp._p[0]]]],{eval:function(e){eval(e)}})
arfn_fdate_bp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_fdate_bp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_fdate_bp._s.SetParameterString('pDate',WtA(pDate,'D'));
arfn_fdate_bp._s.SetParameterString('m_bApplet','true');
arfn_fdate_bp._s.CallServlet('arfn_fdate_bp');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_fdate_bp._s.errmsg;
}
return arfn_fdate_bp._s.GetString();
}
arfn_fdate_bp.CtxLoad_ = function(){return []}
