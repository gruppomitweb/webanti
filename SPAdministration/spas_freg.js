function spas_freg() {
var isOnline;
var code;
var e_mail;
var fullname;
var company;
var note;
var appurl;
var m_Caller
spas_freg._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
isOnline=false;
code='';
e_mail='';
fullname='';
company='';
note='';
appurl='';
}
if(spas_freg._p.length>0)_rargs([[['isOnline',spas_freg._p[0]],['code',spas_freg._p[1]],['e_mail',spas_freg._p[2]],['fullname',spas_freg._p[3]],['company',spas_freg._p[4]],['note',spas_freg._p[5]],['appurl',spas_freg._p[6]]]],{eval:function(e){eval(e)}})
spas_freg._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
spas_freg._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
spas_freg._s.SetParameterString('isOnline',WtA(isOnline,'L'));
spas_freg._s.SetParameterString('code',WtA(code,'C'));
spas_freg._s.SetParameterString('e_mail',WtA(e_mail,'C'));
spas_freg._s.SetParameterString('fullname',WtA(fullname,'C'));
spas_freg._s.SetParameterString('company',WtA(company,'C'));
spas_freg._s.SetParameterString('note',WtA(note,'M'));
spas_freg._s.SetParameterString('appurl',WtA(appurl,'C'));
spas_freg._s.SetParameterString('m_bApplet','true');
spas_freg._s.CallServlet('spas_freg');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=spas_freg._s.errmsg;
}
return spas_freg._s.GetString();
}
spas_freg.CtxLoad_ = function(){return []}
