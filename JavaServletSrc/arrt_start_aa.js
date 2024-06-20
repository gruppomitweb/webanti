function arrt_start_aa() {
var w_tipoallin;
var w_showdata;
var w__top;
var w__bottom;
var w_Countot;
var w_Countok;
var w_Countpr;
var w_Countpr2;
var w_Countko;
var w_bloccaedit;
var m_Caller
arrt_start_aa._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipoallin=m_Caller.GetString('w_tipoallin','C',0,0);
w_showdata=m_Caller.GetNumber('w_showdata','N',0,0);
w__top=m_Caller.GetNumber('_top','N',0,0);
w__bottom=m_Caller.GetNumber('_bottom','N',0,0);
w_Countot=m_Caller.GetNumber('w_Countot','N',0,0);
w_Countok=m_Caller.GetNumber('w_Countok','N',0,0);
w_Countpr=m_Caller.GetNumber('w_Countpr','N',0,0);
w_Countpr2=m_Caller.GetNumber('w_Countpr2','N',0,0);
w_Countko=m_Caller.GetNumber('w_Countko','N',0,0);
w_bloccaedit=m_Caller.GetString('w_bloccaedit','C',0,0);
arrt_start_aa._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_start_aa._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_start_aa._s.SetCallerStringVar('w_tipoallin',WtA(w_tipoallin,'C'));
arrt_start_aa._s.SetCallerStringVar('w_showdata',WtA(w_showdata,'N'));
arrt_start_aa._s.SetCallerStringVar('_top',WtA(w__top,'N'));
arrt_start_aa._s.SetCallerStringVar('_bottom',WtA(w__bottom,'N'));
arrt_start_aa._s.SetCallerStringVar('w_Countot',WtA(w_Countot,'N'));
arrt_start_aa._s.SetCallerStringVar('w_Countok',WtA(w_Countok,'N'));
arrt_start_aa._s.SetCallerStringVar('w_Countpr',WtA(w_Countpr,'N'));
arrt_start_aa._s.SetCallerStringVar('w_Countpr2',WtA(w_Countpr2,'N'));
arrt_start_aa._s.SetCallerStringVar('w_Countko',WtA(w_Countko,'N'));
arrt_start_aa._s.SetCallerStringVar('w_bloccaedit',WtA(w_bloccaedit,'C'));
arrt_start_aa._s.SetParameterString('m_bApplet','true');
arrt_start_aa._s.CallServlet('arrt_start_aa');
m_Caller.SetString('w_tipoallin','C',0,0,arrt_start_aa._s.GetCallerStringVar('w_tipoallin'));
m_Caller.SetNumber('w_showdata','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('w_showdata'));
m_Caller.SetNumber('w__top','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('_top'));
m_Caller.SetNumber('w__bottom','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('_bottom'));
m_Caller.SetNumber('w_Countot','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('w_Countot'));
m_Caller.SetNumber('w_Countok','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('w_Countok'));
m_Caller.SetNumber('w_Countpr','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('w_Countpr'));
m_Caller.SetNumber('w_Countpr2','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('w_Countpr2'));
m_Caller.SetNumber('w_Countko','N',0,0,arrt_start_aa._s.GetCallerDoubleVar('w_Countko'));
m_Caller.SetString('w_bloccaedit','C',0,0,arrt_start_aa._s.GetCallerStringVar('w_bloccaedit'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_start_aa._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_start_aa.CtxLoad_ = function(){return []}
