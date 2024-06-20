function arrt_stp_stdtec_rap() {
var pAUI;
var w_DaDatOpe;
var w_ADatOpe;
var w_daRapporto;
var w_aRapporto;
var w_daCodDip;
var w_aCodDip;
var m_Caller
arrt_stp_stdtec_rap._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAUI='';
}
if(arrt_stp_stdtec_rap._p.length>0)_rargs([[['pAUI',arrt_stp_stdtec_rap._p[0]]]],{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_daRapporto=m_Caller.GetString('w_daRapporto','C',0,0);
w_aRapporto=m_Caller.GetString('w_aRapporto','C',0,0);
w_daCodDip=m_Caller.GetString('w_daCodDip','C',0,0);
w_aCodDip=m_Caller.GetString('w_aCodDip','C',0,0);
arrt_stp_stdtec_rap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stp_stdtec_rap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stp_stdtec_rap._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stp_stdtec_rap._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stp_stdtec_rap._s.SetCallerStringVar('w_daRapporto',WtA(w_daRapporto,'C'));
arrt_stp_stdtec_rap._s.SetCallerStringVar('w_aRapporto',WtA(w_aRapporto,'C'));
arrt_stp_stdtec_rap._s.SetCallerStringVar('w_daCodDip',WtA(w_daCodDip,'C'));
arrt_stp_stdtec_rap._s.SetCallerStringVar('w_aCodDip',WtA(w_aCodDip,'C'));
arrt_stp_stdtec_rap._s.SetParameterString('pAUI',WtA(pAUI,'C'));
arrt_stp_stdtec_rap._s.SetParameterString('m_bApplet','true');
arrt_stp_stdtec_rap._s.CallServlet('arrt_stp_stdtec_rap');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_stp_stdtec_rap._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_stp_stdtec_rap._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_daRapporto','C',0,0,arrt_stp_stdtec_rap._s.GetCallerStringVar('w_daRapporto'));
m_Caller.SetString('w_aRapporto','C',0,0,arrt_stp_stdtec_rap._s.GetCallerStringVar('w_aRapporto'));
m_Caller.SetString('w_daCodDip','C',0,0,arrt_stp_stdtec_rap._s.GetCallerStringVar('w_daCodDip'));
m_Caller.SetString('w_aCodDip','C',0,0,arrt_stp_stdtec_rap._s.GetCallerStringVar('w_aCodDip'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stp_stdtec_rap._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stp_stdtec_rap.CtxLoad_ = function(){return []}
