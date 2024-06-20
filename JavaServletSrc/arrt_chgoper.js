function arrt_chgoper() {
var w_daCodCli;
var w_aCodCli;
var w_DaDatOpe;
var w_ADatOpe;
var m_Caller
arrt_chgoper._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daCodCli='';
w_aCodCli='';
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
}
if(arrt_chgoper._p.length>0)_rargs([[['w_daCodCli',arrt_chgoper._p[0]],['w_aCodCli',arrt_chgoper._p[1]],['w_DaDatOpe',arrt_chgoper._p[2]],['w_ADatOpe',arrt_chgoper._p[3]]]],{eval:function(e){eval(e)}})
arrt_chgoper._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_chgoper._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_chgoper._s.SetParameterString('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_chgoper._s.SetParameterString('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_chgoper._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_chgoper._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_chgoper._s.SetParameterString('m_bApplet','true');
arrt_chgoper._s.CallServlet('arrt_chgoper');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_chgoper._s.errmsg;
}
return arrt_chgoper._s.GetString();
}
arrt_chgoper.CtxLoad_ = function(){return []}
