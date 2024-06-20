function arrt_chg_connes_xls() {
var w_nomefile;
var m_Caller
arrt_chg_connes_xls._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_nomefile='';
}
if(arrt_chg_connes_xls._p.length>0)_rargs([[['w_nomefile',arrt_chg_connes_xls._p[0]]]],{eval:function(e){eval(e)}})
arrt_chg_connes_xls._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chg_connes_xls._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chg_connes_xls._s.SetParameterString('w_nomefile',WtA(w_nomefile,'C'));
arrt_chg_connes_xls._s.SetParameterString('m_bApplet','true');
arrt_chg_connes_xls._s.CallServlet('arrt_chg_connes_xls');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chg_connes_xls._s.errmsg;
}
return arrt_chg_connes_xls._s.GetString();
}
arrt_chg_connes_xls.CtxLoad_ = function(){return []}
