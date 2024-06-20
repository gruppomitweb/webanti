function arfn_dateminus() {
var begindate;
var numday;
var m_Caller
arfn_dateminus._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
begindate=NullDate();
numday=0;
}
if(arfn_dateminus._p.length>0)_rargs([[['begindate',arfn_dateminus._p[0]],['numday',arfn_dateminus._p[1]]]],{eval:function(e){eval(e)}})
arfn_dateminus._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_dateminus._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_dateminus._s.SetParameterString('begindate',WtA(begindate,'D'));
arfn_dateminus._s.SetParameterString('numday',WtA(numday,'N'));
arfn_dateminus._s.SetParameterString('m_bApplet','true');
arfn_dateminus._s.CallServlet('arfn_dateminus');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_dateminus._s.errmsg;
}
return DateFromApplet(arfn_dateminus._s.GetDate());
}
arfn_dateminus.CtxLoad_ = function(){return []}
