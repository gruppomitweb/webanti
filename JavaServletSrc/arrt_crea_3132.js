function arrt_crea_3132() {
var w_RAPPORTO;
var w_FLAGLIRE;
var w_VALUTA;
var w_TIPORAP;
var w_CODDIPE;
var w_DESCCIT;
var w_PROVINCIA;
var w_CODCAB;
var w_xDescDipe;
var m_Caller
arrt_crea_3132._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_RAPPORTO=m_Caller.GetString('w_RAPPORTO','C',0,0);
w_FLAGLIRE=m_Caller.GetString('w_FLAGLIRE','C',0,0);
w_VALUTA=m_Caller.GetString('w_VALUTA','C',0,0);
w_TIPORAP=m_Caller.GetString('w_TIPORAP','C',0,0);
w_CODDIPE=m_Caller.GetString('w_CODDIPE','C',0,0);
w_DESCCIT=m_Caller.GetString('w_DESCCIT','C',0,0);
w_PROVINCIA=m_Caller.GetString('w_PROVINCIA','C',0,0);
w_CODCAB=m_Caller.GetString('w_CODCAB','C',0,0);
w_xDescDipe=m_Caller.GetString('w_xDescDipe','C',0,0);
arrt_crea_3132._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_crea_3132._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_crea_3132._s.SetCallerStringVar('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_FLAGLIRE',WtA(w_FLAGLIRE,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_VALUTA',WtA(w_VALUTA,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_TIPORAP',WtA(w_TIPORAP,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_CODDIPE',WtA(w_CODDIPE,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_DESCCIT',WtA(w_DESCCIT,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_PROVINCIA',WtA(w_PROVINCIA,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_CODCAB',WtA(w_CODCAB,'C'));
arrt_crea_3132._s.SetCallerStringVar('w_xDescDipe',WtA(w_xDescDipe,'C'));
arrt_crea_3132._s.SetParameterString('m_bApplet','true');
arrt_crea_3132._s.CallServlet('arrt_crea_3132');
m_Caller.SetString('w_RAPPORTO','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_RAPPORTO'));
m_Caller.SetString('w_FLAGLIRE','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_FLAGLIRE'));
m_Caller.SetString('w_VALUTA','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_VALUTA'));
m_Caller.SetString('w_TIPORAP','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_TIPORAP'));
m_Caller.SetString('w_CODDIPE','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_CODDIPE'));
m_Caller.SetString('w_DESCCIT','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_DESCCIT'));
m_Caller.SetString('w_PROVINCIA','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_PROVINCIA'));
m_Caller.SetString('w_CODCAB','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_CODCAB'));
m_Caller.SetString('w_xDescDipe','C',0,0,arrt_crea_3132._s.GetCallerStringVar('w_xDescDipe'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_crea_3132._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_crea_3132.CtxLoad_ = function(){return []}
