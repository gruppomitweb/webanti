function arfn_chkdatdoc() {
var pCli;
var pOpe;
var m_Caller
arfn_chkdatdoc._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pCli='';
pOpe=NullDate();
}
if(arfn_chkdatdoc._p.length>0)_rargs([[['pCli',arfn_chkdatdoc._p[0]],['pOpe',arfn_chkdatdoc._p[1]]]],{eval:function(e){eval(e)}})
arfn_chkdatdoc._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkdatdoc._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkdatdoc._s.SetParameterString('pCli',WtA(pCli,'C'));
arfn_chkdatdoc._s.SetParameterString('pOpe',WtA(pOpe,'D'));
arfn_chkdatdoc._s.SetParameterString('m_bApplet','true');
arfn_chkdatdoc._s.CallServlet('arfn_chkdatdoc');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkdatdoc._s.errmsg;
}
return arfn_chkdatdoc._s.GetBoolean();
}
arfn_chkdatdoc.CtxLoad_ = function(){return []}
