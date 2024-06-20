function arrt_del_duplicati() {
var w_DaDatOpe;
var w_ADatOpe;
var w_anno;
var m_Caller
arrt_del_duplicati._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
arrt_del_duplicati._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_del_duplicati._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_del_duplicati._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_del_duplicati._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_del_duplicati._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_del_duplicati._s.SetParameterString('m_bApplet','true');
arrt_del_duplicati._s.CallServlet('arrt_del_duplicati');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_del_duplicati._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_del_duplicati._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetNumber('w_anno','N',0,0,arrt_del_duplicati._s.GetCallerDoubleVar('w_anno'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_del_duplicati._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_del_duplicati.CtxLoad_ = function(){return []}
