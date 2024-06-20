function arrt_calccodfis_obj() {
var m_Caller
arrt_calccodfis_obj._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
}
if(arrt_calccodfis_obj._p.length>0)_rargs([[['pObj',arrt_calccodfis_obj._p[0]]]],{eval:function(e){eval(e)}})
arrt_calccodfis_obj._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_calccodfis_obj._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_calccodfis_obj._s.SetParameterString('pObj',WtA(pObj,'C'));
arrt_calccodfis_obj._s.SetParameterString('m_bApplet','true');
arrt_calccodfis_obj._s.CallServlet('arrt_calccodfis_obj');
if (Gt(arrt_calccodfis_obj._p.length,0)) {
arrt_calccodfis_obj._p[0].SetFromContext(arrt_calccodfis_obj._s.GetCallerStringVar('pObj'));
} else {
arrt_calccodfis_obj._search_par=[];
for (var i=0;i<arguments[0].length;i++) arrt_calccodfis_obj._search_par[i]=arguments[0][i][0];
arguments[0][LibJavascript.Array.indexOf(arrt_calccodfis_obj._search_par,'pObj')][1].SetFromContext(arrt_calccodfis_obj._s.GetCallerStringVar('pObj'));
}
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_calccodfis_obj._s.errmsg;
}
}
arrt_calccodfis_obj.CtxLoad_ = function(){return []}
