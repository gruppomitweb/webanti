function arrt_extrope_varia() {
var w_annorif;
var pSaldi;
var m_Caller
arrt_extrope_varia._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_annorif=0;
pSaldi='';
}
if(arrt_extrope_varia._p.length>0)_rargs([[['w_annorif',arrt_extrope_varia._p[0]],['pSaldi',arrt_extrope_varia._p[1]]]],{eval:function(e){eval(e)}})
arrt_extrope_varia._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_extrope_varia._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_extrope_varia._s.SetParameterString('w_annorif',WtA(w_annorif,'N'));
arrt_extrope_varia._s.SetParameterString('pSaldi',WtA(pSaldi,'C'));
arrt_extrope_varia._s.SetParameterString('m_bApplet','true');
arrt_extrope_varia._s.CallServlet('arrt_extrope_varia');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_extrope_varia._s.errmsg;
}
return arrt_extrope_varia._s.GetString();
}
arrt_extrope_varia.CtxLoad_ = function(){return []}
