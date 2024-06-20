function arfn_datetimefchar() {
var pCDate;
var m_Caller
arfn_datetimefchar._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCDate='';
}
if(arfn_datetimefchar._p.length>0)_rargs([[['pCDate',arfn_datetimefchar._p[0]]]],{eval:function(e){eval(e)}})
arfn_datetimefchar._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_datetimefchar._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_datetimefchar._s.SetParameterString('pCDate',WtA(pCDate,'C'));
arfn_datetimefchar._s.SetParameterString('m_bApplet','true');
arfn_datetimefchar._s.CallServlet('arfn_datetimefchar');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_datetimefchar._s.errmsg;
}
return DateTimeFromApplet(arfn_datetimefchar._s.GetDateTime());
}
arfn_datetimefchar.CtxLoad_ = function(){return []}
