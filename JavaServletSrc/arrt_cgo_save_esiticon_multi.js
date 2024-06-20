function arrt_cgo_save_esiticon_multi() {
var pNumOpe;
var pDatCon;
var pEsiCon;
var pNotCon;
var pAll;
var m_Caller
arrt_cgo_save_esiticon_multi._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNumOpe='';
pDatCon=NullDate();
pEsiCon='';
pNotCon='';
pAll='';
}
if(arrt_cgo_save_esiticon_multi._p.length>0)_rargs([[['pNumOpe',arrt_cgo_save_esiticon_multi._p[0]],['pDatCon',arrt_cgo_save_esiticon_multi._p[1]],['pEsiCon',arrt_cgo_save_esiticon_multi._p[2]],['pNotCon',arrt_cgo_save_esiticon_multi._p[3]],['pAll',arrt_cgo_save_esiticon_multi._p[4]]]],{eval:function(e){eval(e)}})
arrt_cgo_save_esiticon_multi._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_cgo_save_esiticon_multi._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_cgo_save_esiticon_multi._s.SetParameterString('pNumOpe',WtA(pNumOpe,'C'));
arrt_cgo_save_esiticon_multi._s.SetParameterString('pDatCon',WtA(pDatCon,'D'));
arrt_cgo_save_esiticon_multi._s.SetParameterString('pEsiCon',WtA(pEsiCon,'C'));
arrt_cgo_save_esiticon_multi._s.SetParameterString('pNotCon',WtA(pNotCon,'M'));
arrt_cgo_save_esiticon_multi._s.SetParameterString('pAll',WtA(pAll,'C'));
arrt_cgo_save_esiticon_multi._s.SetParameterString('m_bApplet','true');
arrt_cgo_save_esiticon_multi._s.CallServlet('arrt_cgo_save_esiticon_multi');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_cgo_save_esiticon_multi._s.errmsg;
}
return arrt_cgo_save_esiticon_multi._s.GetString();
}
arrt_cgo_save_esiticon_multi.CtxLoad_ = function(){return []}
