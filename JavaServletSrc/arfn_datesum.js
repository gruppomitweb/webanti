function arfn_datesum() {
var begindate;
var numday;
var m_Caller
arfn_datesum._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
begindate=NullDate();
numday=0;
}
if(arfn_datesum._p.length>0)_rargs([[['begindate',arfn_datesum._p[0]],['numday',arfn_datesum._p[1]]]],{eval:function(e){eval(e)}})
arfn_datesum._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_datesum._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_datesum._s.SetParameterString('begindate',WtA(begindate,'D'));
arfn_datesum._s.SetParameterString('numday',WtA(numday,'N'));
arfn_datesum._s.SetParameterString('m_bApplet','true');
arfn_datesum._s.CallServlet('arfn_datesum');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_datesum._s.errmsg;
}
return DateFromApplet(arfn_datesum._s.GetDate());
}
arfn_datesum.CtxLoad_ = function(){return []}
