function arfn_save_user_agency() {
var pCode;
var pName;
var pUser;
var pDisable;
var pResetPWD;
var pResetOTP;
var pNewPwd;
var m_Caller
arfn_save_user_agency._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCode=0;
pName='';
pUser='';
pDisable='';
pResetPWD='';
pResetOTP='';
pNewPwd='';
}
if(arfn_save_user_agency._p.length>0)_rargs([[['pCode',arfn_save_user_agency._p[0]],['pName',arfn_save_user_agency._p[1]],['pUser',arfn_save_user_agency._p[2]],['pDisable',arfn_save_user_agency._p[3]],['pResetPWD',arfn_save_user_agency._p[4]],['pResetOTP',arfn_save_user_agency._p[5]],['pNewPwd',arfn_save_user_agency._p[6]]]],{eval:function(e){eval(e)}})
arfn_save_user_agency._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_save_user_agency._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_save_user_agency._s.SetParameterString('pCode',WtA(pCode,'N'));
arfn_save_user_agency._s.SetParameterString('pName',WtA(pName,'C'));
arfn_save_user_agency._s.SetParameterString('pUser',WtA(pUser,'C'));
arfn_save_user_agency._s.SetParameterString('pDisable',WtA(pDisable,'C'));
arfn_save_user_agency._s.SetParameterString('pResetPWD',WtA(pResetPWD,'C'));
arfn_save_user_agency._s.SetParameterString('pResetOTP',WtA(pResetOTP,'C'));
arfn_save_user_agency._s.SetParameterString('pNewPwd',WtA(pNewPwd,'C'));
arfn_save_user_agency._s.SetParameterString('m_bApplet','true');
arfn_save_user_agency._s.CallServlet('arfn_save_user_agency');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_save_user_agency._s.errmsg;
}
return arfn_save_user_agency._s.GetString();
}
arfn_save_user_agency.CtxLoad_ = function(){return []}
