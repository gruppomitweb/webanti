function arfn_inimese() {
var pData;
var pPeriodo;
var m_Caller
arfn_inimese._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pData=NullDate();
pPeriodo=0;
}
if(arfn_inimese._p.length>0)_rargs([[['pData',arfn_inimese._p[0]],['pPeriodo',arfn_inimese._p[1]]]],{eval:function(e){eval(e)}})
arfn_inimese._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_inimese._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_inimese._s.SetParameterString('pData',WtA(pData,'D'));
arfn_inimese._s.SetParameterString('pPeriodo',WtA(pPeriodo,'N'));
arfn_inimese._s.SetParameterString('m_bApplet','true');
arfn_inimese._s.CallServlet('arfn_inimese');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_inimese._s.errmsg;
}
return arfn_inimese._s.GetString();
}
arfn_inimese.CtxLoad_ = function(){return []}
