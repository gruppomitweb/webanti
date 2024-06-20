function arrt_trasffra() {
var pDatIni;
var pDatFin;
var pForza;
var pInform;
var m_Caller
arrt_trasffra._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
pDatFin=NullDate();
pForza='';
pInform='';
}
if(arrt_trasffra._p.length>0)_rargs([[['pDatIni',arrt_trasffra._p[0]],['pDatFin',arrt_trasffra._p[1]],['pForza',arrt_trasffra._p[2]],['pInform',arrt_trasffra._p[3]]]],{eval:function(e){eval(e)}})
arrt_trasffra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasffra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasffra._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
arrt_trasffra._s.SetParameterString('pDatFin',WtA(pDatFin,'D'));
arrt_trasffra._s.SetParameterString('pForza',WtA(pForza,'C'));
arrt_trasffra._s.SetParameterString('pInform',WtA(pInform,'C'));
arrt_trasffra._s.SetParameterString('m_bApplet','true');
arrt_trasffra._s.CallServlet('arrt_trasffra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasffra._s.errmsg;
}
return arrt_trasffra._s.GetString();
}
arrt_trasffra.CtxLoad_ = function(){return []}
