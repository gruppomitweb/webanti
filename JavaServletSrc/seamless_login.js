function seamless_login() {
var w_pUser;
var w_pPwd;
var w_pAzienda;
var w_pURL;
var w_pURLOE;
var w_pOTP;
var w_pIPC;
var w_pIPS;
var w_pIPSP;
var w_pIPRP;
var w_pBrowser;
var m_Caller
seamless_login._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_pUser=m_Caller.GetString('pUser','C',0,0);
w_pPwd=m_Caller.GetString('pPwd','C',0,0);
w_pAzienda=m_Caller.GetString('pAzienda','C',0,0);
w_pURL=m_Caller.GetString('pURL','C',0,0);
w_pURLOE=m_Caller.GetString('pURLOE','C',0,0);
w_pOTP=m_Caller.GetString('pOTP','C',0,0);
w_pIPC=m_Caller.GetString('pIPC','C',0,0);
w_pIPS=m_Caller.GetString('pIPS','C',0,0);
w_pIPSP=m_Caller.GetString('pIPSP','C',0,0);
w_pIPRP=m_Caller.GetString('pIPRP','C',0,0);
w_pBrowser=m_Caller.GetString('pBrowser','C',0,0);
seamless_login._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
seamless_login._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
seamless_login._s.SetCallerStringVar('pUser',WtA(w_pUser,'C'));
seamless_login._s.SetCallerStringVar('pPwd',WtA(w_pPwd,'C'));
seamless_login._s.SetCallerStringVar('pAzienda',WtA(w_pAzienda,'C'));
seamless_login._s.SetCallerStringVar('pURL',WtA(w_pURL,'C'));
seamless_login._s.SetCallerStringVar('pURLOE',WtA(w_pURLOE,'C'));
seamless_login._s.SetCallerStringVar('pOTP',WtA(w_pOTP,'C'));
seamless_login._s.SetCallerStringVar('pIPC',WtA(w_pIPC,'C'));
seamless_login._s.SetCallerStringVar('pIPS',WtA(w_pIPS,'C'));
seamless_login._s.SetCallerStringVar('pIPSP',WtA(w_pIPSP,'C'));
seamless_login._s.SetCallerStringVar('pIPRP',WtA(w_pIPRP,'C'));
seamless_login._s.SetCallerStringVar('pBrowser',WtA(w_pBrowser,'C'));
seamless_login._s.SetParameterString('m_bApplet','true');
seamless_login._s.CallServlet('seamless_login');
m_Caller.SetString('w_pUser','C',0,0,seamless_login._s.GetCallerStringVar('pUser'));
m_Caller.SetString('w_pPwd','C',0,0,seamless_login._s.GetCallerStringVar('pPwd'));
m_Caller.SetString('w_pAzienda','C',0,0,seamless_login._s.GetCallerStringVar('pAzienda'));
m_Caller.SetString('w_pURL','C',0,0,seamless_login._s.GetCallerStringVar('pURL'));
m_Caller.SetString('w_pURLOE','C',0,0,seamless_login._s.GetCallerStringVar('pURLOE'));
m_Caller.SetString('w_pOTP','C',0,0,seamless_login._s.GetCallerStringVar('pOTP'));
m_Caller.SetString('w_pIPC','C',0,0,seamless_login._s.GetCallerStringVar('pIPC'));
m_Caller.SetString('w_pIPS','C',0,0,seamless_login._s.GetCallerStringVar('pIPS'));
m_Caller.SetString('w_pIPSP','C',0,0,seamless_login._s.GetCallerStringVar('pIPSP'));
m_Caller.SetString('w_pIPRP','C',0,0,seamless_login._s.GetCallerStringVar('pIPRP'));
m_Caller.SetString('w_pBrowser','C',0,0,seamless_login._s.GetCallerStringVar('pBrowser'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=seamless_login._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
seamless_login.CtxLoad_ = function(){return []}
