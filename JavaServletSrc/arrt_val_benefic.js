function arrt_val_benefic() {
var w_CONNESBEN;
var w_C_CAB;
var w_C_CAP;
var w_C_CTA;
var w_C_IND;
var w_C_PRV;
var w_C_RAG;
var w_C_STA;
var w_dessta;
var m_Caller
arrt_val_benefic._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_CONNESBEN=m_Caller.GetString('w_CONNESBEN','C',0,0);
w_C_CAB=m_Caller.GetString('w_C_CAB','C',0,0);
w_C_CAP=m_Caller.GetString('w_C_CAP','C',0,0);
w_C_CTA=m_Caller.GetString('w_C_CTA','C',0,0);
w_C_IND=m_Caller.GetString('w_C_IND','C',0,0);
w_C_PRV=m_Caller.GetString('w_C_PRV','C',0,0);
w_C_RAG=m_Caller.GetString('w_C_RAG','C',0,0);
w_C_STA=m_Caller.GetString('w_C_STA','C',0,0);
w_dessta=m_Caller.GetString('w_dessta','C',0,0);
arrt_val_benefic._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_val_benefic._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_val_benefic._s.SetCallerStringVar('w_CONNESBEN',WtA(w_CONNESBEN,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_CAB',WtA(w_C_CAB,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_CAP',WtA(w_C_CAP,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_CTA',WtA(w_C_CTA,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_IND',WtA(w_C_IND,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_PRV',WtA(w_C_PRV,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_RAG',WtA(w_C_RAG,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_C_STA',WtA(w_C_STA,'C'));
arrt_val_benefic._s.SetCallerStringVar('w_dessta',WtA(w_dessta,'C'));
arrt_val_benefic._s.SetParameterString('m_bApplet','true');
arrt_val_benefic._s.CallServlet('arrt_val_benefic');
m_Caller.SetString('w_CONNESBEN','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_CONNESBEN'));
m_Caller.SetString('w_C_CAB','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_CAB'));
m_Caller.SetString('w_C_CAP','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_CAP'));
m_Caller.SetString('w_C_CTA','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_CTA'));
m_Caller.SetString('w_C_IND','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_IND'));
m_Caller.SetString('w_C_PRV','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_PRV'));
m_Caller.SetString('w_C_RAG','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_RAG'));
m_Caller.SetString('w_C_STA','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_C_STA'));
m_Caller.SetString('w_dessta','C',0,0,arrt_val_benefic._s.GetCallerStringVar('w_dessta'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_val_benefic._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_val_benefic.CtxLoad_ = function(){return []}
