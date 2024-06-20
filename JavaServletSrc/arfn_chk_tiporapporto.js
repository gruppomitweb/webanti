function arfn_chk_tiporapporto() {
var pSog;
var pRap;
var m_Caller
arfn_chk_tiporapporto._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSog='';
pRap='';
}
if(arfn_chk_tiporapporto._p.length>0)_rargs([[['pSog',arfn_chk_tiporapporto._p[0]],['pRap',arfn_chk_tiporapporto._p[1]]]],{eval:function(e){eval(e)}})
arfn_chk_tiporapporto._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chk_tiporapporto._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chk_tiporapporto._s.SetParameterString('pSog',WtA(pSog,'C'));
arfn_chk_tiporapporto._s.SetParameterString('pRap',WtA(pRap,'C'));
arfn_chk_tiporapporto._s.SetParameterString('m_bApplet','true');
arfn_chk_tiporapporto._s.CallServlet('arfn_chk_tiporapporto');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chk_tiporapporto._s.errmsg;
}
return arfn_chk_tiporapporto._s.GetBoolean();
}
arfn_chk_tiporapporto.CtxLoad_ = function(){return []}
