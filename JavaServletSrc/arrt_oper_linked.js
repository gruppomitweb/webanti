function arrt_oper_linked() {
var w_DaDatOpe;
var w_ADatOpe;
var w_DaDatReg;
var w_ADatReg;
var w_daCodCli;
var w_aCodCli;
var m_Caller
arrt_oper_linked._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_DaDatReg=NullDate();
w_ADatReg=NullDate();
w_daCodCli='';
w_aCodCli='';
}
if(arrt_oper_linked._p.length>0)_rargs([[['w_DaDatOpe',arrt_oper_linked._p[0]],['w_ADatOpe',arrt_oper_linked._p[1]],['w_DaDatReg',arrt_oper_linked._p[2]],['w_ADatReg',arrt_oper_linked._p[3]],['w_daCodCli',arrt_oper_linked._p[4]],['w_aCodCli',arrt_oper_linked._p[5]]]],{eval:function(e){eval(e)}})
arrt_oper_linked._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_oper_linked._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_oper_linked._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_oper_linked._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_oper_linked._s.SetParameterString('w_DaDatReg',WtA(w_DaDatReg,'D'));
arrt_oper_linked._s.SetParameterString('w_ADatReg',WtA(w_ADatReg,'D'));
arrt_oper_linked._s.SetParameterString('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_oper_linked._s.SetParameterString('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_oper_linked._s.SetParameterString('m_bApplet','true');
arrt_oper_linked._s.CallServlet('arrt_oper_linked');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_oper_linked._s.errmsg;
}
}
arrt_oper_linked.CtxLoad_ = function(){return []}
