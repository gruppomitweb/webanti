function arrt_chg_connes() {
var w_oldcon;
var w_newcon;
var m_Caller
arrt_chg_connes._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_oldcon='';
w_newcon='';
}
if(arrt_chg_connes._p.length>0)_rargs([[['w_oldcon',arrt_chg_connes._p[0]],['w_newcon',arrt_chg_connes._p[1]]]],{eval:function(e){eval(e)}})
arrt_chg_connes._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chg_connes._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chg_connes._s.SetParameterString('w_oldcon',WtA(w_oldcon,'C'));
arrt_chg_connes._s.SetParameterString('w_newcon',WtA(w_newcon,'C'));
arrt_chg_connes._s.SetParameterString('m_bApplet','true');
arrt_chg_connes._s.CallServlet('arrt_chg_connes');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chg_connes._s.errmsg;
}
return arrt_chg_connes._s.GetString();
}
arrt_chg_connes.CtxLoad_ = function(){return []}
