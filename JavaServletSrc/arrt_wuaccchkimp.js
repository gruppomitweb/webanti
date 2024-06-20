function arrt_wuaccchkimp() {
var w_tipodest;
var w_msgproc;
var w_impzip;
var w_opextc;
var w_codmage;
var w_destfin;
var w_xMAFLGRAP;
var w_xMAFLGBON;
var w_nomefile;
var m_Caller
arrt_wuaccchkimp._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_tipodest=m_Caller.GetString('w_tipodest','C',0,0);
w_msgproc=m_Caller.GetString('w_msgproc','M',0,0);
w_impzip=m_Caller.GetNumber('w_impzip','N',0,0);
w_opextc=m_Caller.GetString('w_opextc','C',0,0);
w_codmage=m_Caller.GetString('w_codmage','C',0,0);
w_destfin=m_Caller.GetString('w_destfin','C',0,0);
w_xMAFLGRAP=m_Caller.GetString('w_xMAFLGRAP','C',0,0);
w_xMAFLGBON=m_Caller.GetString('w_xMAFLGBON','C',0,0);
w_nomefile=m_Caller.GetString('w_nomefile','C',0,0);
arrt_wuaccchkimp._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wuaccchkimp._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wuaccchkimp._s.SetCallerStringVar('w_tipodest',WtA(w_tipodest,'C'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_msgproc',WtA(w_msgproc,'M'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_impzip',WtA(w_impzip,'N'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_opextc',WtA(w_opextc,'C'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_codmage',WtA(w_codmage,'C'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_destfin',WtA(w_destfin,'C'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_xMAFLGRAP',WtA(w_xMAFLGRAP,'C'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_xMAFLGBON',WtA(w_xMAFLGBON,'C'));
arrt_wuaccchkimp._s.SetCallerStringVar('w_nomefile',WtA(w_nomefile,'C'));
arrt_wuaccchkimp._s.SetParameterString('m_bApplet','true');
arrt_wuaccchkimp._s.CallServlet('arrt_wuaccchkimp');
m_Caller.SetString('w_tipodest','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_tipodest'));
m_Caller.SetString('w_msgproc','M',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_msgproc'));
m_Caller.SetNumber('w_impzip','N',0,0,arrt_wuaccchkimp._s.GetCallerDoubleVar('w_impzip'));
m_Caller.SetString('w_opextc','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_opextc'));
m_Caller.SetString('w_codmage','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_codmage'));
m_Caller.SetString('w_destfin','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_destfin'));
m_Caller.SetString('w_xMAFLGRAP','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_xMAFLGRAP'));
m_Caller.SetString('w_xMAFLGBON','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_xMAFLGBON'));
m_Caller.SetString('w_nomefile','C',0,0,arrt_wuaccchkimp._s.GetCallerStringVar('w_nomefile'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wuaccchkimp._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_wuaccchkimp.CtxLoad_ = function(){return []}
