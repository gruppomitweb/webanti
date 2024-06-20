function arrt_faminvio_rettifiche() {
var w_anno;
var w_mese;
var w_dadata;
var w_a_data;
var w_flgagg;
var w_flgdel;
var w_flgnew;
var w_flgstp;
var w_flgdett;
var m_Caller
arrt_faminvio_rettifiche._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_anno=m_Caller.GetNumber('w_anno','N',0,0);
w_mese=m_Caller.GetString('w_mese','C',0,0);
w_dadata=m_Caller.GetDate('w_dadata','D',0,0);
w_a_data=m_Caller.GetDate('w_a_data','D',0,0);
w_flgagg=m_Caller.GetString('w_flgagg','C',0,0);
w_flgdel=m_Caller.GetString('w_flgdel','C',0,0);
w_flgnew=m_Caller.GetString('w_flgnew','C',0,0);
w_flgstp=m_Caller.GetString('w_flgstp','C',0,0);
w_flgdett=m_Caller.GetString('w_flgdett','C',0,0);
arrt_faminvio_rettifiche._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_faminvio_rettifiche._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_anno',WtA(w_anno,'N'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_mese',WtA(w_mese,'C'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_dadata',WtA(w_dadata,'D'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_a_data',WtA(w_a_data,'D'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_flgagg',WtA(w_flgagg,'C'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_flgdel',WtA(w_flgdel,'C'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_flgnew',WtA(w_flgnew,'C'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_flgstp',WtA(w_flgstp,'C'));
arrt_faminvio_rettifiche._s.SetCallerStringVar('w_flgdett',WtA(w_flgdett,'C'));
arrt_faminvio_rettifiche._s.SetParameterString('m_bApplet','true');
arrt_faminvio_rettifiche._s.CallServlet('arrt_faminvio_rettifiche');
m_Caller.SetNumber('w_anno','N',0,0,arrt_faminvio_rettifiche._s.GetCallerDoubleVar('w_anno'));
m_Caller.SetString('w_mese','C',0,0,arrt_faminvio_rettifiche._s.GetCallerStringVar('w_mese'));
m_Caller.SetDate('w_dadata','D',0,0,DateFromApplet(arrt_faminvio_rettifiche._s.GetCallerDateVar('w_dadata')));
m_Caller.SetDate('w_a_data','D',0,0,DateFromApplet(arrt_faminvio_rettifiche._s.GetCallerDateVar('w_a_data')));
m_Caller.SetString('w_flgagg','C',0,0,arrt_faminvio_rettifiche._s.GetCallerStringVar('w_flgagg'));
m_Caller.SetString('w_flgdel','C',0,0,arrt_faminvio_rettifiche._s.GetCallerStringVar('w_flgdel'));
m_Caller.SetString('w_flgnew','C',0,0,arrt_faminvio_rettifiche._s.GetCallerStringVar('w_flgnew'));
m_Caller.SetString('w_flgstp','C',0,0,arrt_faminvio_rettifiche._s.GetCallerStringVar('w_flgstp'));
m_Caller.SetString('w_flgdett','C',0,0,arrt_faminvio_rettifiche._s.GetCallerStringVar('w_flgdett'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_faminvio_rettifiche._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_faminvio_rettifiche.CtxLoad_ = function(){return []}
