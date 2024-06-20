function arrt_stprappo_elenco() {
var w_daRappo;
var w_aRappo;
var w_DaDatIni;
var w_ADatIni;
var w_DaDatFin;
var w_ADatFin;
var w_tipo;
var m_Caller
arrt_stprappo_elenco._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_daRappo='';
w_aRappo='';
w_DaDatIni=NullDate();
w_ADatIni=NullDate();
w_DaDatFin=NullDate();
w_ADatFin=NullDate();
w_tipo='';
}
if(arrt_stprappo_elenco._p.length>0)_rargs([[['w_daRappo',arrt_stprappo_elenco._p[0]],['w_aRappo',arrt_stprappo_elenco._p[1]],['w_DaDatIni',arrt_stprappo_elenco._p[2]],['w_ADatIni',arrt_stprappo_elenco._p[3]],['w_DaDatFin',arrt_stprappo_elenco._p[4]],['w_ADatFin',arrt_stprappo_elenco._p[5]],['w_tipo',arrt_stprappo_elenco._p[6]]]],{eval:function(e){eval(e)}})
arrt_stprappo_elenco._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stprappo_elenco._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stprappo_elenco._s.SetParameterString('w_daRappo',WtA(w_daRappo,'C'));
arrt_stprappo_elenco._s.SetParameterString('w_aRappo',WtA(w_aRappo,'C'));
arrt_stprappo_elenco._s.SetParameterString('w_DaDatIni',WtA(w_DaDatIni,'D'));
arrt_stprappo_elenco._s.SetParameterString('w_ADatIni',WtA(w_ADatIni,'D'));
arrt_stprappo_elenco._s.SetParameterString('w_DaDatFin',WtA(w_DaDatFin,'D'));
arrt_stprappo_elenco._s.SetParameterString('w_ADatFin',WtA(w_ADatFin,'D'));
arrt_stprappo_elenco._s.SetParameterString('w_tipo',WtA(w_tipo,'C'));
arrt_stprappo_elenco._s.SetParameterString('m_bApplet','true');
arrt_stprappo_elenco._s.CallServlet('arrt_stprappo_elenco');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stprappo_elenco._s.errmsg;
}
}
arrt_stprappo_elenco.CtxLoad_ = function(){return []}
