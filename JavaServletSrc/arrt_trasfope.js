function arrt_trasfope() {
var pDatIni;
var pDatFin;
var pForza;
var pInform;
var m_Caller
arrt_trasfope._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
pDatFin=NullDate();
pForza='';
pInform='';
}
if(arrt_trasfope._p.length>0)_rargs([[['pDatIni',arrt_trasfope._p[0]],['pDatFin',arrt_trasfope._p[1]],['pForza',arrt_trasfope._p[2]],['pInform',arrt_trasfope._p[3]]]],{eval:function(e){eval(e)}})
arrt_trasfope._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasfope._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasfope._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
arrt_trasfope._s.SetParameterString('pDatFin',WtA(pDatFin,'D'));
arrt_trasfope._s.SetParameterString('pForza',WtA(pForza,'C'));
arrt_trasfope._s.SetParameterString('pInform',WtA(pInform,'C'));
arrt_trasfope._s.SetParameterString('m_bApplet','true');
arrt_trasfope._s.CallServlet('arrt_trasfope');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasfope._s.errmsg;
}
return arrt_trasfope._s.GetString();
}
arrt_trasfope.CtxLoad_ = function(){return []}
