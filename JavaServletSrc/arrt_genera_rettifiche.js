function arrt_genera_rettifiche() {
var w_DaDatOpe;
var w_ADatOpe;
var w_anno;
var w_mese;
var m_Caller
arrt_genera_rettifiche._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_mese=m_Caller.GetString('w_mese','C',0,0);
arrt_genera_rettifiche._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_genera_rettifiche._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_genera_rettifiche._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_genera_rettifiche._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_genera_rettifiche._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_genera_rettifiche._s.SetCallerStringVar('w_mese',WtA(w_mese,'C'));
arrt_genera_rettifiche._s.SetParameterString('m_bApplet','true');
arrt_genera_rettifiche._s.CallServlet('arrt_genera_rettifiche');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_genera_rettifiche._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_genera_rettifiche._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetNumber('w_anno','N',0,0,arrt_genera_rettifiche._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_mese','C',0,0,arrt_genera_rettifiche._s.GetCallerStringVar('w_mese'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_genera_rettifiche._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_genera_rettifiche.CtxLoad_ = function(){return []}
