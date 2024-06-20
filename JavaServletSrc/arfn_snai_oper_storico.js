function arfn_snai_oper_storico() {
var pID;
var m_Caller
arfn_snai_oper_storico._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pID='';
}
if(arfn_snai_oper_storico._p.length>0)_rargs([[['pID',arfn_snai_oper_storico._p[0]]]],{eval:function(e){eval(e)}})
arfn_snai_oper_storico._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_snai_oper_storico._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_snai_oper_storico._s.SetParameterString('pID',WtA(pID,'C'));
arfn_snai_oper_storico._s.SetParameterString('m_bApplet','true');
arfn_snai_oper_storico._s.CallServlet('arfn_snai_oper_storico');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_snai_oper_storico._s.errmsg;
}
return arfn_snai_oper_storico._s.GetString();
}
arfn_snai_oper_storico.CtxLoad_ = function(){return []}
