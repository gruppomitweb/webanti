function spadministration_checkpasswordciclicity() {
var usercode;
var password;
var m_Caller
spadministration_checkpasswordciclicity._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
usercode=0;
password='';
}
if(spadministration_checkpasswordciclicity._p.length>0)_rargs([[['usercode',spadministration_checkpasswordciclicity._p[0]],['password',spadministration_checkpasswordciclicity._p[1]]]],{eval:function(e){eval(e)}})
spadministration_checkpasswordciclicity._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spadministration_checkpasswordciclicity._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spadministration_checkpasswordciclicity._s.SetParameterString('usercode',WtA(usercode,'N'));
spadministration_checkpasswordciclicity._s.SetParameterString('password',WtA(password,'C'));
spadministration_checkpasswordciclicity._s.SetParameterString('m_bApplet','true');
spadministration_checkpasswordciclicity._s.CallServlet('spadministration_checkpasswordciclicity');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spadministration_checkpasswordciclicity._s.errmsg;
}
return spadministration_checkpasswordciclicity._s.GetBoolean();
}
spadministration_checkpasswordciclicity.CtxLoad_ = function(){return []}
