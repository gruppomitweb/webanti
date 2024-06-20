function arrt_mod_opextrbo() {
var w_annorif;
var w_codval;
var w_CONNES;
var w_dataope;
var w_impsaldo;
var w_nummov;
var w_txtnote;
var w_xdesval;
var m_Caller
arrt_mod_opextrbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_annorif=m_Caller.GetString('w_annorif','C',0,0);
w_codval=m_Caller.GetString('w_codval','C',0,0);
w_CONNES=m_Caller.GetString('w_CONNES','C',0,0);
w_dataope=m_Caller.GetDate('w_dataope','D',0,0);
w_impsaldo=m_Caller.GetNumber('w_impsaldo','N',0,0);
w_nummov=m_Caller.GetNumber('w_nummov','N',0,0);
w_txtnote=m_Caller.GetString('w_txtnote','C',0,0);
w_xdesval=m_Caller.GetString('w_xdesval','C',0,0);
arrt_mod_opextrbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_mod_opextrbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_mod_opextrbo._s.SetCallerStringVar('w_annorif',WtA(w_annorif,'C'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_codval',WtA(w_codval,'C'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_CONNES',WtA(w_CONNES,'C'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_dataope',WtA(w_dataope,'D'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_impsaldo',WtA(w_impsaldo,'N'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_nummov',WtA(w_nummov,'N'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_txtnote',WtA(w_txtnote,'C'));
arrt_mod_opextrbo._s.SetCallerStringVar('w_xdesval',WtA(w_xdesval,'C'));
arrt_mod_opextrbo._s.SetParameterString('m_bApplet','true');
arrt_mod_opextrbo._s.CallServlet('arrt_mod_opextrbo');
m_Caller.SetString('w_annorif','C',0,0,arrt_mod_opextrbo._s.GetCallerStringVar('w_annorif'));
m_Caller.SetString('w_codval','C',0,0,arrt_mod_opextrbo._s.GetCallerStringVar('w_codval'));
m_Caller.SetString('w_CONNES','C',0,0,arrt_mod_opextrbo._s.GetCallerStringVar('w_CONNES'));
m_Caller.SetDate('w_dataope','D',0,0,DateFromApplet(arrt_mod_opextrbo._s.GetCallerDateVar('w_dataope')));
m_Caller.SetNumber('w_impsaldo','N',0,0,arrt_mod_opextrbo._s.GetCallerDoubleVar('w_impsaldo'));
m_Caller.SetNumber('w_nummov','N',0,0,arrt_mod_opextrbo._s.GetCallerDoubleVar('w_nummov'));
m_Caller.SetString('w_txtnote','C',0,0,arrt_mod_opextrbo._s.GetCallerStringVar('w_txtnote'));
m_Caller.SetString('w_xdesval','C',0,0,arrt_mod_opextrbo._s.GetCallerStringVar('w_xdesval'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_mod_opextrbo._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_mod_opextrbo.CtxLoad_ = function(){return []}
