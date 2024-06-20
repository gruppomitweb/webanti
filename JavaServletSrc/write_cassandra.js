function write_cassandra() {
var m_Caller
write_cassandra._p=_rargs(arguments,{eval:function(e){eval(e)}})
write_cassandra._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
write_cassandra._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
write_cassandra._s.SetParameterString('m_bApplet','true');
write_cassandra._s.CallServlet('write_cassandra');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=write_cassandra._s.errmsg;
}
}
write_cassandra.CtxLoad_ = function(){return []}
