function arrt_genera_opex() {
var w_DaDatOpe;
var w_ADatOpe;
var w_anno;
var m_Caller
arrt_genera_opex._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_anno=0;
}
if(arrt_genera_opex._p.length>0)_rargs([[['w_DaDatOpe',arrt_genera_opex._p[0]],['w_ADatOpe',arrt_genera_opex._p[1]],['w_anno',arrt_genera_opex._p[2]]]],{eval:function(e){eval(e)}})
arrt_genera_opex._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_genera_opex._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_genera_opex._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_genera_opex._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_genera_opex._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_genera_opex._s.SetParameterString('m_bApplet','true');
arrt_genera_opex._s.CallServlet('arrt_genera_opex');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_genera_opex._s.errmsg;
}
return arrt_genera_opex._s.GetString();
}
arrt_genera_opex.CtxLoad_ = function(){return []}
