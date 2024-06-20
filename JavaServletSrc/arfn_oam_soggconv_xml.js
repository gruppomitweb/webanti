function arfn_oam_soggconv_xml() {
var pAnno;
var pSem;
var pPrimo;
var m_Caller
arfn_oam_soggconv_xml._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pSem=0;
pPrimo='';
}
if(arfn_oam_soggconv_xml._p.length>0)_rargs([[['pAnno',arfn_oam_soggconv_xml._p[0]],['pSem',arfn_oam_soggconv_xml._p[1]],['pPrimo',arfn_oam_soggconv_xml._p[2]]]],{eval:function(e){eval(e)}})
arfn_oam_soggconv_xml._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_oam_soggconv_xml._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_oam_soggconv_xml._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_oam_soggconv_xml._s.SetParameterString('pSem',WtA(pSem,'N'));
arfn_oam_soggconv_xml._s.SetParameterString('pPrimo',WtA(pPrimo,'C'));
arfn_oam_soggconv_xml._s.SetParameterString('m_bApplet','true');
arfn_oam_soggconv_xml._s.CallServlet('arfn_oam_soggconv_xml');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_oam_soggconv_xml._s.errmsg;
}
return arfn_oam_soggconv_xml._s.GetString();
}
arfn_oam_soggconv_xml.CtxLoad_ = function(){return []}
