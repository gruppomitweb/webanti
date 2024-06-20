function arfn_anompers_oam() {
var pNDG;
var pTipo;
var pRapporto;
var pDatOpe;
var pNOCF;
var m_Caller
arfn_anompers_oam._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pNDG='';
pTipo='';
pRapporto='';
pDatOpe=NullDate();
pNOCF='';
}
if(arfn_anompers_oam._p.length>0)_rargs([[['pNDG',arfn_anompers_oam._p[0]],['pTipo',arfn_anompers_oam._p[1]],['pRapporto',arfn_anompers_oam._p[2]],['pDatOpe',arfn_anompers_oam._p[3]],['pNOCF',arfn_anompers_oam._p[4]]]],{eval:function(e){eval(e)}})
arfn_anompers_oam._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_anompers_oam._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_anompers_oam._s.SetParameterString('pNDG',WtA(pNDG,'C'));
arfn_anompers_oam._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_anompers_oam._s.SetParameterString('pRapporto',WtA(pRapporto,'C'));
arfn_anompers_oam._s.SetParameterString('pDatOpe',WtA(pDatOpe,'D'));
arfn_anompers_oam._s.SetParameterString('pNOCF',WtA(pNOCF,'C'));
arfn_anompers_oam._s.SetParameterString('m_bApplet','true');
arfn_anompers_oam._s.CallServlet('arfn_anompers_oam');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_anompers_oam._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_anompers_oam._s.errmsg;
arfn_anompers_oam._res=new CPMemoryCursor();
} else {
arfn_anompers_oam._res=arfn_anompers_oam._s.GetMemoryCursor();
}
return arfn_anompers_oam._res;
}
arfn_anompers_oam.CtxLoad_ = function(){return []}
