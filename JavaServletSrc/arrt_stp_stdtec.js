function arrt_stp_stdtec() {
var pTipo;
var pAUI;
var w_DaDatOpe;
var w_ADatOpe;
var w_daCodCli;
var w_aCodCli;
var w_daCodDip;
var w_aCodDip;
var w_flgrae;
var m_Caller
arrt_stp_stdtec._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
pAUI='';
}
if(arrt_stp_stdtec._p.length>0)_rargs([[['pTipo',arrt_stp_stdtec._p[0]],['pAUI',arrt_stp_stdtec._p[1]]]],{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_daCodCli=m_Caller.GetString('w_daCodCli','C',0,0);
w_aCodCli=m_Caller.GetString('w_aCodCli','C',0,0);
w_daCodDip=m_Caller.GetString('w_daCodDip','C',0,0);
w_aCodDip=m_Caller.GetString('w_aCodDip','C',0,0);
w_flgrae=m_Caller.GetString('w_flgrae','C',0,0);
arrt_stp_stdtec._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_stdtec._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_stdtec._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stp_stdtec._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stp_stdtec._s.SetCallerStringVar('w_daCodCli',WtA(w_daCodCli,'C'));
arrt_stp_stdtec._s.SetCallerStringVar('w_aCodCli',WtA(w_aCodCli,'C'));
arrt_stp_stdtec._s.SetCallerStringVar('w_daCodDip',WtA(w_daCodDip,'C'));
arrt_stp_stdtec._s.SetCallerStringVar('w_aCodDip',WtA(w_aCodDip,'C'));
arrt_stp_stdtec._s.SetCallerStringVar('w_flgrae',WtA(w_flgrae,'C'));
arrt_stp_stdtec._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_stp_stdtec._s.SetParameterString('pAUI',WtA(pAUI,'C'));
arrt_stp_stdtec._s.SetParameterString('m_bApplet','true');
arrt_stp_stdtec._s.CallServlet('arrt_stp_stdtec');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_stp_stdtec._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_stp_stdtec._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_daCodCli','C',0,0,arrt_stp_stdtec._s.GetCallerStringVar('w_daCodCli'));
m_Caller.SetString('w_aCodCli','C',0,0,arrt_stp_stdtec._s.GetCallerStringVar('w_aCodCli'));
m_Caller.SetString('w_daCodDip','C',0,0,arrt_stp_stdtec._s.GetCallerStringVar('w_daCodDip'));
m_Caller.SetString('w_aCodDip','C',0,0,arrt_stp_stdtec._s.GetCallerStringVar('w_aCodDip'));
m_Caller.SetString('w_flgrae','C',0,0,arrt_stp_stdtec._s.GetCallerStringVar('w_flgrae'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_stdtec._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stp_stdtec.CtxLoad_ = function(){return []}
