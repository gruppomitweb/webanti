function arrt_calcsaldi_opex_periodo() {
var w_annorif;
var w_valuta;
var w_DaData;
var w_A_Data;
var m_Caller
arrt_calcsaldi_opex_periodo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_annorif=m_Caller.GetNumber('w_annorif','N',0,0);
w_valuta=m_Caller.GetString('w_valuta','C',0,0);
w_DaData=m_Caller.GetDate('w_DaData','D',0,0);
w_A_Data=m_Caller.GetDate('w_A_Data','D',0,0);
arrt_calcsaldi_opex_periodo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calcsaldi_opex_periodo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calcsaldi_opex_periodo._s.SetCallerStringVar('w_annorif',WtA(w_annorif,'N'));
arrt_calcsaldi_opex_periodo._s.SetCallerStringVar('w_valuta',WtA(w_valuta,'C'));
arrt_calcsaldi_opex_periodo._s.SetCallerStringVar('w_DaData',WtA(w_DaData,'D'));
arrt_calcsaldi_opex_periodo._s.SetCallerStringVar('w_A_Data',WtA(w_A_Data,'D'));
arrt_calcsaldi_opex_periodo._s.SetParameterString('m_bApplet','true');
arrt_calcsaldi_opex_periodo._s.CallServlet('arrt_calcsaldi_opex_periodo');
m_Caller.SetNumber('w_annorif','N',0,0,arrt_calcsaldi_opex_periodo._s.GetCallerDoubleVar('w_annorif'));
m_Caller.SetString('w_valuta','C',0,0,arrt_calcsaldi_opex_periodo._s.GetCallerStringVar('w_valuta'));
m_Caller.SetDate('w_DaData','D',0,0,DateFromApplet(arrt_calcsaldi_opex_periodo._s.GetCallerDateVar('w_DaData')));
m_Caller.SetDate('w_A_Data','D',0,0,DateFromApplet(arrt_calcsaldi_opex_periodo._s.GetCallerDateVar('w_A_Data')));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calcsaldi_opex_periodo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_calcsaldi_opex_periodo.CtxLoad_ = function(){return []}
