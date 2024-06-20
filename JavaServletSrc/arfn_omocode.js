function arfn_omocode() {
var pCode;
var pValid;
var m_Caller
arfn_omocode._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCode='';
pValid=0;
}
if(arfn_omocode._p.length>0)_rargs([[['pCode',arfn_omocode._p[0]],['pValid',arfn_omocode._p[1]]]],{eval:function(e){eval(e)}})
arfn_omocode._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_omocode._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_omocode._s.SetParameterString('pCode',WtA(pCode,'C'));
arfn_omocode._s.SetParameterString('pValid',WtA(pValid,'N'));
arfn_omocode._s.SetParameterString('m_bApplet','true');
arfn_omocode._s.CallServlet('arfn_omocode');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_omocode._s.errmsg;
}
return arfn_omocode._s.GetBoolean();
}
arfn_omocode.CtxLoad_ = function(){return []}
