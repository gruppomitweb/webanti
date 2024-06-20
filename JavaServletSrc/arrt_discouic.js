function arrt_discouic() {
var w_DaDatOpe;
var w_ADatOpe;
var w_tipocr;
var w_codcr;
var w_datinv;
var w_numinv;
var m_Caller
arrt_discouic._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_tipocr=m_Caller.GetString('w_tipocr','C',0,0);
w_codcr=m_Caller.GetString('w_codcr','C',0,0);
w_datinv=m_Caller.GetDate('w_datinv','D',0,0);
w_numinv=m_Caller.GetNumber('w_numinv','N',0,0);
arrt_discouic._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_discouic._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_discouic._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_discouic._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_discouic._s.SetCallerStringVar('w_tipocr',WtA(w_tipocr,'C'));
arrt_discouic._s.SetCallerStringVar('w_codcr',WtA(w_codcr,'C'));
arrt_discouic._s.SetCallerStringVar('w_datinv',WtA(w_datinv,'D'));
arrt_discouic._s.SetCallerStringVar('w_numinv',WtA(w_numinv,'N'));
arrt_discouic._s.SetParameterString('m_bApplet','true');
arrt_discouic._s.CallServlet('arrt_discouic');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_discouic._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_discouic._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_tipocr','C',0,0,arrt_discouic._s.GetCallerStringVar('w_tipocr'));
m_Caller.SetString('w_codcr','C',0,0,arrt_discouic._s.GetCallerStringVar('w_codcr'));
m_Caller.SetDate('w_datinv','D',0,0,DateFromApplet(arrt_discouic._s.GetCallerDateVar('w_datinv')));
m_Caller.SetNumber('w_numinv','N',0,0,arrt_discouic._s.GetCallerDoubleVar('w_numinv'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_discouic._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_discouic.CtxLoad_ = function(){return []}
