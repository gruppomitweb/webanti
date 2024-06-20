function spadministration_addsecurity_record() {
var type;
var code;
var progname;
var backto;
var m_Caller
spadministration_addsecurity_record._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
type='';
code=0;
progname='';
backto='';
}
if(spadministration_addsecurity_record._p.length>0)_rargs([[['type',spadministration_addsecurity_record._p[0]],['code',spadministration_addsecurity_record._p[1]],['progname',spadministration_addsecurity_record._p[2]],['backto',spadministration_addsecurity_record._p[3]]]],{eval:function(e){eval(e)}})
spadministration_addsecurity_record._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_addsecurity_record._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_addsecurity_record._s.SetParameterString('type',WtA(type,'C'));
spadministration_addsecurity_record._s.SetParameterString('code',WtA(code,'N'));
spadministration_addsecurity_record._s.SetParameterString('progname',WtA(progname,'C'));
spadministration_addsecurity_record._s.SetParameterString('backto',WtA(backto,'C'));
spadministration_addsecurity_record._s.SetParameterString('m_bApplet','true');
spadministration_addsecurity_record._s.CallServlet('spadministration_addsecurity_record');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_addsecurity_record._s.errmsg;
}
}
spadministration_addsecurity_record.CtxLoad_ = function(){return []}
