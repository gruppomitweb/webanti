function arrt_wutrxchk_upddata() {
var w_TRXCOGNOM;
var w_TRXNOME;
var w_TRXCODFIS;
var w_TRXLUONAS;
var w_TRXDATNAS;
var w_TRXSESSO;
var w_TRXFLGCF;
var w_xtipdoc;
var w_xtnumdoc;
var w_xluonas;
var m_Caller
arrt_wutrxchk_upddata._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_TRXCOGNOM=m_Caller.GetString('w_TRXCOGNOM','C',0,0);
w_TRXNOME=m_Caller.GetString('w_TRXNOME','C',0,0);
w_TRXCODFIS=m_Caller.GetString('w_TRXCODFIS','C',0,0);
w_TRXLUONAS=m_Caller.GetString('w_TRXLUONAS','C',0,0);
w_TRXDATNAS=m_Caller.GetDate('w_TRXDATNAS','D',0,0);
w_TRXSESSO=m_Caller.GetString('w_TRXSESSO','C',0,0);
w_TRXFLGCF=m_Caller.GetString('w_TRXFLGCF','C',0,0);
w_xtipdoc=m_Caller.GetString('w_xtipdoc','C',0,0);
w_xtnumdoc=m_Caller.GetString('w_xtnumdoc','C',0,0);
w_xluonas=m_Caller.GetString('w_xluonas','C',0,0);
arrt_wutrxchk_upddata._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_wutrxchk_upddata._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXCOGNOM',WtA(w_TRXCOGNOM,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXNOME',WtA(w_TRXNOME,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXCODFIS',WtA(w_TRXCODFIS,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXLUONAS',WtA(w_TRXLUONAS,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXDATNAS',WtA(w_TRXDATNAS,'D'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXSESSO',WtA(w_TRXSESSO,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_TRXFLGCF',WtA(w_TRXFLGCF,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_xtipdoc',WtA(w_xtipdoc,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_xtnumdoc',WtA(w_xtnumdoc,'C'));
arrt_wutrxchk_upddata._s.SetCallerStringVar('w_xluonas',WtA(w_xluonas,'C'));
arrt_wutrxchk_upddata._s.SetParameterString('m_bApplet','true');
arrt_wutrxchk_upddata._s.CallServlet('arrt_wutrxchk_upddata');
m_Caller.SetString('w_TRXCOGNOM','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_TRXCOGNOM'));
m_Caller.SetString('w_TRXNOME','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_TRXNOME'));
m_Caller.SetString('w_TRXCODFIS','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_TRXCODFIS'));
m_Caller.SetString('w_TRXLUONAS','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_TRXLUONAS'));
m_Caller.SetDate('w_TRXDATNAS','D',0,0,DateFromApplet(arrt_wutrxchk_upddata._s.GetCallerDateVar('w_TRXDATNAS')));
m_Caller.SetString('w_TRXSESSO','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_TRXSESSO'));
m_Caller.SetString('w_TRXFLGCF','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_TRXFLGCF'));
m_Caller.SetString('w_xtipdoc','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_xtipdoc'));
m_Caller.SetString('w_xtnumdoc','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_xtnumdoc'));
m_Caller.SetString('w_xluonas','C',0,0,arrt_wutrxchk_upddata._s.GetCallerStringVar('w_xluonas'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_wutrxchk_upddata._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_wutrxchk_upddata.CtxLoad_ = function(){return []}
