function arfn_chktiporeg() {
var pData;
var pOper;
var m_Caller
arfn_chktiporeg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pData=NullDate();
pOper='';
}
if(arfn_chktiporeg._p.length>0)_rargs([[['pData',arfn_chktiporeg._p[0]],['pOper',arfn_chktiporeg._p[1]]]],{eval:function(e){eval(e)}})
arfn_chktiporeg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chktiporeg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chktiporeg._s.SetParameterString('pData',WtA(pData,'D'));
arfn_chktiporeg._s.SetParameterString('pOper',WtA(pOper,'C'));
arfn_chktiporeg._s.SetParameterString('m_bApplet','true');
arfn_chktiporeg._s.CallServlet('arfn_chktiporeg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chktiporeg._s.errmsg;
}
return arfn_chktiporeg._s.GetBoolean();
}
arfn_chktiporeg.CtxLoad_ = function(){return []}
