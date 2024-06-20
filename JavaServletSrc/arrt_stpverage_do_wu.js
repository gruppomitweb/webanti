function arrt_stpverage_do_wu() {
var pTipo;
var w_DaDatOpe;
var w_ADatOpe;
var w_c_adata;
var w_cdadata;
var w_chkcfis;
var w_noninvio;
var w_codmage;
var w_fisccod;
var w_statonas;
var w_tipoerr;
var m_Caller
arrt_stpverage_do_wu._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arrt_stpverage_do_wu._p.length>0)_rargs([[['pTipo',arrt_stpverage_do_wu._p[0]]]],{eval:function(e){eval(e)}})
w_DaDatOpe=m_Caller.GetDate('w_DaDatOpe','D',0,0);
w_ADatOpe=m_Caller.GetDate('w_ADatOpe','D',0,0);
w_c_adata=m_Caller.GetString('w_c_adata','C',0,0);
w_cdadata=m_Caller.GetString('w_cdadata','C',0,0);
w_chkcfis=m_Caller.GetString('w_chkcfis','C',0,0);
w_noninvio=m_Caller.GetString('w_noninvio','C',0,0);
w_codmage=m_Caller.GetString('w_codmage','C',0,0);
w_fisccod=m_Caller.GetString('w_fisccod','C',0,0);
w_statonas=m_Caller.GetString('w_statonas','C',0,0);
w_tipoerr=m_Caller.GetString('w_tipoerr','C',0,0);
arrt_stpverage_do_wu._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_stpverage_do_wu._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_stpverage_do_wu._s.SetCallerStringVar('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_c_adata',WtA(w_c_adata,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_cdadata',WtA(w_cdadata,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_chkcfis',WtA(w_chkcfis,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_noninvio',WtA(w_noninvio,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_codmage',WtA(w_codmage,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_fisccod',WtA(w_fisccod,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_statonas',WtA(w_statonas,'C'));
arrt_stpverage_do_wu._s.SetCallerStringVar('w_tipoerr',WtA(w_tipoerr,'C'));
arrt_stpverage_do_wu._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_stpverage_do_wu._s.SetParameterString('m_bApplet','true');
arrt_stpverage_do_wu._s.CallServlet('arrt_stpverage_do_wu');
m_Caller.SetDate('w_DaDatOpe','D',0,0,DateFromApplet(arrt_stpverage_do_wu._s.GetCallerDateVar('w_DaDatOpe')));
m_Caller.SetDate('w_ADatOpe','D',0,0,DateFromApplet(arrt_stpverage_do_wu._s.GetCallerDateVar('w_ADatOpe')));
m_Caller.SetString('w_c_adata','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_c_adata'));
m_Caller.SetString('w_cdadata','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_cdadata'));
m_Caller.SetString('w_chkcfis','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_chkcfis'));
m_Caller.SetString('w_noninvio','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_noninvio'));
m_Caller.SetString('w_codmage','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_codmage'));
m_Caller.SetString('w_fisccod','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_fisccod'));
m_Caller.SetString('w_statonas','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_statonas'));
m_Caller.SetString('w_tipoerr','C',0,0,arrt_stpverage_do_wu._s.GetCallerStringVar('w_tipoerr'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_stpverage_do_wu._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_stpverage_do_wu.CtxLoad_ = function(){return []}
