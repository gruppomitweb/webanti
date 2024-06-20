function arfn_save_opextrbo() {
var mcOpex;
var pTipo;
var m_Caller
arfn_save_opextrbo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
}
if(arfn_save_opextrbo._p.length>0)_rargs([[['mcOpex',arfn_save_opextrbo._p[0]],['pTipo',arfn_save_opextrbo._p[1]]]],{eval:function(e){eval(e)}})
arfn_save_opextrbo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_save_opextrbo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_save_opextrbo._s.SetParameterString('mcOpex',WtA(mcOpex,'MC'),mcOpex);
arfn_save_opextrbo._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arfn_save_opextrbo._s.SetParameterString('m_bApplet','true');
arfn_save_opextrbo._s.CallServlet('arfn_save_opextrbo');
mcOpex._Copy(arfn_save_opextrbo._s.GetCallerMemoryCursorVar('mcOpex'))
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_save_opextrbo._s.errmsg;
}
return arfn_save_opextrbo._s.GetString();
}
arfn_save_opextrbo.CtxLoad_ = function(){return []}
