function arfn_oam_vasp_xml() {
var pAnno;
var pTri;
var m_Caller
arfn_oam_vasp_xml._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pAnno=0;
pTri=0;
}
if(arfn_oam_vasp_xml._p.length>0)_rargs([[['pAnno',arfn_oam_vasp_xml._p[0]],['pTri',arfn_oam_vasp_xml._p[1]]]],{eval:function(e){eval(e)}})
arfn_oam_vasp_xml._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_oam_vasp_xml._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_oam_vasp_xml._s.SetParameterString('pAnno',WtA(pAnno,'N'));
arfn_oam_vasp_xml._s.SetParameterString('pTri',WtA(pTri,'N'));
arfn_oam_vasp_xml._s.SetParameterString('m_bApplet','true');
arfn_oam_vasp_xml._s.CallServlet('arfn_oam_vasp_xml');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_oam_vasp_xml._s.errmsg;
}
return arfn_oam_vasp_xml._s.GetString();
}
arfn_oam_vasp_xml.CtxLoad_ = function(){return []}
