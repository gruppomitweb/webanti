function arrt_del_opextrbo() {
var w_CONNES;
var w_ANNO;
var w_TIPO;
var m_Caller
arrt_del_opextrbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_CONNES='';
w_ANNO='';
w_TIPO=0;
}
if(arrt_del_opextrbo._p.length>0)_rargs([[['w_CONNES',arrt_del_opextrbo._p[0]],['w_ANNO',arrt_del_opextrbo._p[1]],['w_TIPO',arrt_del_opextrbo._p[2]]]],{eval:function(e){eval(e)}})
arrt_del_opextrbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_del_opextrbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_del_opextrbo._s.SetParameterString('w_CONNES',WtA(w_CONNES,'C'));
arrt_del_opextrbo._s.SetParameterString('w_ANNO',WtA(w_ANNO,'C'));
arrt_del_opextrbo._s.SetParameterString('w_TIPO',WtA(w_TIPO,'N'));
arrt_del_opextrbo._s.SetParameterString('m_bApplet','true');
arrt_del_opextrbo._s.CallServlet('arrt_del_opextrbo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_del_opextrbo._s.errmsg;
}
return arrt_del_opextrbo._s.GetString();
}
arrt_del_opextrbo.CtxLoad_ = function(){return []}
