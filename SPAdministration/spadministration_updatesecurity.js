function spadministration_updatesecurity() {
var link;
var pType;
var usertype;
var code;
var opensecurity;
var hadSecurity;
var m_Caller
spadministration_updatesecurity._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
link='';
pType='';
usertype='';
code=0;
opensecurity=false;
hadSecurity=false;
}
if(spadministration_updatesecurity._p.length>0)_rargs([[['link',spadministration_updatesecurity._p[0]],['pType',spadministration_updatesecurity._p[1]],['usertype',spadministration_updatesecurity._p[2]],['code',spadministration_updatesecurity._p[3]],['opensecurity',spadministration_updatesecurity._p[4]],['hadSecurity',spadministration_updatesecurity._p[5]]]],{eval:function(e){eval(e)}})
spadministration_updatesecurity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_updatesecurity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_updatesecurity._s.SetParameterString('link',WtA(link,'C'));
spadministration_updatesecurity._s.SetParameterString('pType',WtA(pType,'C'));
spadministration_updatesecurity._s.SetParameterString('usertype',WtA(usertype,'C'));
spadministration_updatesecurity._s.SetParameterString('code',WtA(code,'N'));
spadministration_updatesecurity._s.SetParameterString('opensecurity',WtA(opensecurity,'L'));
spadministration_updatesecurity._s.SetParameterString('hadSecurity',WtA(hadSecurity,'L'));
spadministration_updatesecurity._s.SetParameterString('m_bApplet','true');
spadministration_updatesecurity._s.CallServlet('spadministration_updatesecurity');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_updatesecurity._s.errmsg;
}
return spadministration_updatesecurity._s.GetBoolean();
}
spadministration_updatesecurity.CtxLoad_ = function(){return []}
