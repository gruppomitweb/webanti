function utrt_chgpwd() {
var w_newpwd;
var w_msgchg;
var m_Caller
utrt_chgpwd._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_newpwd=m_Caller.GetString('w_newpwd','C',0,0);
w_msgchg=m_Caller.GetString('w_msgchg','C',0,0);
utrt_chgpwd._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
utrt_chgpwd._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
utrt_chgpwd._s.SetCallerStringVar('w_newpwd',WtA(w_newpwd,'C'));
utrt_chgpwd._s.SetCallerStringVar('w_msgchg',WtA(w_msgchg,'C'));
utrt_chgpwd._s.SetParameterString('m_bApplet','true');
utrt_chgpwd._s.CallServlet('utrt_chgpwd');
m_Caller.SetString('w_newpwd','C',0,0,utrt_chgpwd._s.GetCallerStringVar('w_newpwd'));
m_Caller.SetString('w_msgchg','C',0,0,utrt_chgpwd._s.GetCallerStringVar('w_msgchg'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=utrt_chgpwd._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
utrt_chgpwd.CtxLoad_ = function(){return []}
