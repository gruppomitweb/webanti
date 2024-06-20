function arrt_copia51() {
var w_RAPPORTO;
var w_flgclose;
var w_flgallinea;
var m_Caller
arrt_copia51._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_RAPPORTO='';
w_flgclose='';
w_flgallinea='';
}
if(arrt_copia51._p.length>0)_rargs([[['w_RAPPORTO',arrt_copia51._p[0]],['w_flgclose',arrt_copia51._p[1]],['w_flgallinea',arrt_copia51._p[2]]]],{eval:function(e){eval(e)}})
arrt_copia51._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_copia51._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_copia51._s.SetParameterString('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_copia51._s.SetParameterString('w_flgclose',WtA(w_flgclose,'C'));
arrt_copia51._s.SetParameterString('w_flgallinea',WtA(w_flgallinea,'C'));
arrt_copia51._s.SetParameterString('m_bApplet','true');
arrt_copia51._s.CallServlet('arrt_copia51');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_copia51._s.errmsg;
}
return arrt_copia51._s.GetString();
}
arrt_copia51.CtxLoad_ = function(){return []}
