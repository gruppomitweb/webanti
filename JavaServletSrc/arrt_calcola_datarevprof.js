function arrt_calcola_datarevprof() {
var m_Caller
arrt_calcola_datarevprof._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_calcola_datarevprof._p.length>0)_rargs([[['pObj',arrt_calcola_datarevprof._p[0]]]],{eval:function(e){eval(e)}})
arrt_calcola_datarevprof._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calcola_datarevprof._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calcola_datarevprof._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_calcola_datarevprof._s.SetParameterString('m_bApplet','true');
arrt_calcola_datarevprof._s.CallServlet('arrt_calcola_datarevprof');
if (Gt(arrt_calcola_datarevprof._p.length,0)) {
arrt_calcola_datarevprof._p[0].SetFromContext(arrt_calcola_datarevprof._s.GetCallerStringVar('pObj'));
} else {
arrt_calcola_datarevprof._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_calcola_datarevprof._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_calcola_datarevprof._search_par,'pObj')][1].SetFromContext(arrt_calcola_datarevprof._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calcola_datarevprof._s.errmsg;
}
}
arrt_calcola_datarevprof.CtxLoad_ = function(){return []}
