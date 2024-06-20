function arrt_estrai_crs() {
var w_annofisc;
var m_Caller
arrt_estrai_crs._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_annofisc=0;
}
if(arrt_estrai_crs._p.length>0)_rargs([[['w_annofisc',arrt_estrai_crs._p[0]]]],{eval:function(e){eval(e)}})
arrt_estrai_crs._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_estrai_crs._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_estrai_crs._s.SetParameterString('w_annofisc',WtA(w_annofisc,'N'));
arrt_estrai_crs._s.SetParameterString('m_bApplet','true');
arrt_estrai_crs._s.CallServlet('arrt_estrai_crs');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_estrai_crs._s.errmsg;
}
return arrt_estrai_crs._s.GetString();
}
arrt_estrai_crs.CtxLoad_ = function(){return []}
