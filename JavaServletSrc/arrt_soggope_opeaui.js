function arrt_soggope_opeaui() {
var m_Caller
arrt_soggope_opeaui._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_soggope_opeaui._p.length>0)_rargs([[['pObj',arrt_soggope_opeaui._p[0]]]],{eval:function(e){eval(e)}})
arrt_soggope_opeaui._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_soggope_opeaui._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_soggope_opeaui._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_soggope_opeaui._s.SetParameterString('m_bApplet','true');
arrt_soggope_opeaui._s.CallServlet('arrt_soggope_opeaui');
if (Gt(arrt_soggope_opeaui._p.length,0)) {
arrt_soggope_opeaui._p[0].SetFromContext(arrt_soggope_opeaui._s.GetCallerStringVar('pObj'));
} else {
arrt_soggope_opeaui._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_soggope_opeaui._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_soggope_opeaui._search_par,'pObj')][1].SetFromContext(arrt_soggope_opeaui._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_soggope_opeaui._s.errmsg;
}
}
arrt_soggope_opeaui.CtxLoad_ = function(){return []}
