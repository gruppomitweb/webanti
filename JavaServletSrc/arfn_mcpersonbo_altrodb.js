function arfn_mcpersonbo_altrodb() {
var likeconnes;
var likeragsoc;
var likecodfisc;
var likecitta;
var m_Caller
arfn_mcpersonbo_altrodb._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
likeconnes='';
likeragsoc='';
likecodfisc='';
likecitta='';
}
if(arfn_mcpersonbo_altrodb._p.length>0)_rargs([[['likeconnes',arfn_mcpersonbo_altrodb._p[0]],['likeragsoc',arfn_mcpersonbo_altrodb._p[1]],['likecodfisc',arfn_mcpersonbo_altrodb._p[2]],['likecitta',arfn_mcpersonbo_altrodb._p[3]]]],{eval:function(e){eval(e)}})
arfn_mcpersonbo_altrodb._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_mcpersonbo_altrodb._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_mcpersonbo_altrodb._s.SetParameterString('likeconnes',WtA(likeconnes,'C'));
arfn_mcpersonbo_altrodb._s.SetParameterString('likeragsoc',WtA(likeragsoc,'C'));
arfn_mcpersonbo_altrodb._s.SetParameterString('likecodfisc',WtA(likecodfisc,'C'));
arfn_mcpersonbo_altrodb._s.SetParameterString('likecitta',WtA(likecitta,'C'));
arfn_mcpersonbo_altrodb._s.SetParameterString('m_bApplet','true');
arfn_mcpersonbo_altrodb._s.CallServlet('arfn_mcpersonbo_altrodb');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_mcpersonbo_altrodb._s.errmsg;
}
if ( ! (Empty(m_cErrorFromRoutine))) {
m_cErrorFromRoutine=arfn_mcpersonbo_altrodb._s.errmsg;
arfn_mcpersonbo_altrodb._res=new CPMemoryCursor();
} else {
arfn_mcpersonbo_altrodb._res=arfn_mcpersonbo_altrodb._s.GetMemoryCursor();
}
return arfn_mcpersonbo_altrodb._res;
}
arfn_mcpersonbo_altrodb.CtxLoad_ = function(){return []}
