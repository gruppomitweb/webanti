function arrt_storrap() {
var w_DaDatOpe;
var w_ADatOpe;
var w_tipoope;
var m_Caller
arrt_storrap._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_tipoope=m_Caller.GetString('w_tipoope','C',0,0);
arrt_storrap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_storrap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_storrap._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_storrap._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_storrap._s.SetCallerStringVar('w_tipoope',WtA(w_tipoope,'C'));
arrt_storrap._s.SetParameterString('m_bApplet','true');
arrt_storrap._s.CallServlet('arrt_storrap');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_storrap._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_storrap._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_tipoope','C',0,0,arrt_storrap._s.GetCallerStringVar('w_tipoope'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_storrap._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_storrap.CtxLoad_ = function(){return []}
