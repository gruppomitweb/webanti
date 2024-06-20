function arrt_newinfo() {
var cRapporto;
var pTipo;
var m_Caller
arrt_newinfo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
cRapporto='';
pTipo='';
}
if(arrt_newinfo._p.length>0)_rargs([[['cRapporto',arrt_newinfo._p[0]],['pTipo',arrt_newinfo._p[1]]]],{eval:function(e){eval(e)}})
arrt_newinfo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_newinfo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_newinfo._s.SetParameterString('cRapporto',WtA(cRapporto,'C'));
arrt_newinfo._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_newinfo._s.SetParameterString('m_bApplet','true');
arrt_newinfo._s.CallServlet('arrt_newinfo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_newinfo._s.errmsg;
}
return arrt_newinfo._s.GetString();
}
arrt_newinfo.CtxLoad_ = function(){return []}
