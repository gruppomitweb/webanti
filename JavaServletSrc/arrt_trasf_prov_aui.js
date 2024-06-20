function arrt_trasf_prov_aui() {
var pDatIni;
var pDatFin;
var pForza;
var pInform;
var pSource;
var pDoCheck;
var m_Caller
arrt_trasf_prov_aui._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDatIni=NullDate();
pDatFin=NullDate();
pForza='';
pInform='';
pSource='';
pDoCheck='';
}
if(arrt_trasf_prov_aui._p.length>0)_rargs([[['pDatIni',arrt_trasf_prov_aui._p[0]],['pDatFin',arrt_trasf_prov_aui._p[1]],['pForza',arrt_trasf_prov_aui._p[2]],['pInform',arrt_trasf_prov_aui._p[3]],['pSource',arrt_trasf_prov_aui._p[4]],['pDoCheck',arrt_trasf_prov_aui._p[5]]]],{eval:function(e){eval(e)}})
arrt_trasf_prov_aui._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_trasf_prov_aui._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_trasf_prov_aui._s.SetParameterString('pDatIni',WtA(pDatIni,'D'));
arrt_trasf_prov_aui._s.SetParameterString('pDatFin',WtA(pDatFin,'D'));
arrt_trasf_prov_aui._s.SetParameterString('pForza',WtA(pForza,'C'));
arrt_trasf_prov_aui._s.SetParameterString('pInform',WtA(pInform,'C'));
arrt_trasf_prov_aui._s.SetParameterString('pSource',WtA(pSource,'C'));
arrt_trasf_prov_aui._s.SetParameterString('pDoCheck',WtA(pDoCheck,'C'));
arrt_trasf_prov_aui._s.SetParameterString('m_bApplet','true');
arrt_trasf_prov_aui._s.CallServlet('arrt_trasf_prov_aui');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_trasf_prov_aui._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arrt_trasf_prov_aui._s.errmsg;
arrt_trasf_prov_aui._res=new CPMemoryCursor();
} else {
arrt_trasf_prov_aui._res=arrt_trasf_prov_aui._s.GetMemoryCursor();
}
return arrt_trasf_prov_aui._res;
}
arrt_trasf_prov_aui.CtxLoad_ = function(){return []}
