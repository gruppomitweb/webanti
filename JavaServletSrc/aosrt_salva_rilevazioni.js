function aosrt_salva_rilevazioni() {
var pConnes;
var pData;
var pModello;
var pTipo;
var m_Caller
aosrt_salva_rilevazioni._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pConnes='';
pData=NullDate();
pModello='';
pTipo='';
}
if(aosrt_salva_rilevazioni._p.length>0)_rargs([[['pConnes',aosrt_salva_rilevazioni._p[0]],['pData',aosrt_salva_rilevazioni._p[1]],['pModello',aosrt_salva_rilevazioni._p[2]],['pTipo',aosrt_salva_rilevazioni._p[3]]]],{eval:function(e){eval(e)}})
aosrt_salva_rilevazioni._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aosrt_salva_rilevazioni._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aosrt_salva_rilevazioni._s.SetParameterString('pConnes',WtA(pConnes,'C'));
aosrt_salva_rilevazioni._s.SetParameterString('pData',WtA(pData,'D'));
aosrt_salva_rilevazioni._s.SetParameterString('pModello',WtA(pModello,'C'));
aosrt_salva_rilevazioni._s.SetParameterString('pTipo',WtA(pTipo,'C'));
aosrt_salva_rilevazioni._s.SetParameterString('m_bApplet','true');
aosrt_salva_rilevazioni._s.CallServlet('aosrt_salva_rilevazioni');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aosrt_salva_rilevazioni._s.errmsg;
}
return aosrt_salva_rilevazioni._s.GetString();
}
aosrt_salva_rilevazioni.CtxLoad_ = function(){return []}
