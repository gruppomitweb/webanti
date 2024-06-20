function arrt_view_doc() {
var pFile;
var pID;
var pCodDip;
var m_Caller
arrt_view_doc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFile='';
pID='';
pCodDip='';
}
if(arrt_view_doc._p.length>0)_rargs([[['pFile',arrt_view_doc._p[0]],['pID',arrt_view_doc._p[1]],['pCodDip',arrt_view_doc._p[2]]]],{eval:function(e){eval(e)}})
arrt_view_doc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_view_doc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_view_doc._s.SetParameterString('pFile',WtA(pFile,'C'));
arrt_view_doc._s.SetParameterString('pID',WtA(pID,'C'));
arrt_view_doc._s.SetParameterString('pCodDip',WtA(pCodDip,'C'));
arrt_view_doc._s.SetParameterString('m_bApplet','true');
arrt_view_doc._s.CallServlet('arrt_view_doc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_view_doc._s.errmsg;
}
}
arrt_view_doc.CtxLoad_ = function(){return []}
