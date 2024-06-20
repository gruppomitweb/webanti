function arrrt_lanciainter() {
var m_Caller
arrrt_lanciainter._p=_rargs(arguments,{eval:function(e){eval(e)}})
arrrt_lanciainter._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrrt_lanciainter._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrrt_lanciainter._s.SetParameterString('m_bApplet','true');
arrrt_lanciainter._s.CallServlet('arrrt_lanciainter');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrrt_lanciainter._s.errmsg;
}
}
arrrt_lanciainter.CtxLoad_ = function(){return []}
