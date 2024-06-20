function moneytest() {
var m_Caller
moneytest._p=_rargs(arguments,{eval:function(e){eval(e)}})
moneytest._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
moneytest._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
moneytest._s.SetParameterString('m_bApplet','true');
moneytest._s.CallServlet('moneytest');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=moneytest._s.errmsg;
}
}
moneytest.CtxLoad_ = function(){return []}
