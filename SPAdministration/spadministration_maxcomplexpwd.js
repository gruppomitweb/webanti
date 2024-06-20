function spadministration_maxcomplexpwd() {
spadministration_maxcomplexpwd._deps(false)
var m_cLastMsgError;
var m_bError;
var m_Sql;
var m_Ctx;
var m_Caller;
function _extra(){return{cllr:{eval:function(e){return eval(e)}}}}
_rargs(arguments,_extra().cllr)
var usersgroups;
var maxpwdcomplexity;
Blank();
var m_r = _rargs(arguments,_extra().cllr,0);
if (CtxLoad_(arguments)) {
return;
} else {
if ( ! (LibJavascript.LoadChildren.reRun.ready())) {
return;
}
}
return Run.apply(null,m_r)
function Page_1() {
for (var usersgroups_itr_00000003 = 0; usersgroups_itr_00000003<usersgroups.Rows(); usersgroups_itr_00000003 = usersgroups_itr_00000003 + (1)) {
usersgroups.SetRow(usersgroups_itr_00000003);
maxpwdcomplexity=Round(Max(maxpwdcomplexity,usersgroups.w_pwd_complexity),0);
usersgroups.SaveRow();
}
throw maxpwdcomplexity
}
function _init_() {
}
function Run(p_usersgroups) {
if (Ne(p_usersgroups,null) && Ne(typeof(p_usersgroups),'undefined')) {
usersgroups=p_usersgroups;
}
var l_result;
l_result=0;
try {
try {
if (typeof(NotifyEvent)!='undefined') {
NotifyEvent('Run start');
}
Page_1();
} finally {
if (typeof(NotifyEvent)!='undefined') {
NotifyEvent('Run end');
}
}
} catch(stop_value) {
l_result=stop_value;
}
if (m_Caller.__first && (Eqr(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating))) {
m_cErrorFromRoutine=m_cLastMsgError;
}
return l_result;
}
function Blank() {
usersgroups=null;
maxpwdcomplexity=0;
}
function CtxLoad_(i_fn) {
return spadministration_maxcomplexpwd.CtxLoad_(i_fn,[]);
}
}
spadministration_maxcomplexpwd._deps=function(){};
spadministration_maxcomplexpwd.CtxLoad_ = function(i_fn,children) {
spadministration_maxcomplexpwd._deps(false);
var wait = 0;
if (i_fn) {
if (children.length>0) {
wait=LibJavascript.LoadChildren(window,children,i_fn.callee,i_fn);
}
return wait;
} else {
return children;
}
}
