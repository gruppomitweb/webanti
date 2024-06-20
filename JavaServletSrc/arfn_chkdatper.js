function arfn_chkdatper() {
var pDaDatOpe;
var pADatOpe;
var pTipOpe;
var m_Caller
arfn_chkdatper._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pDaDatOpe=NullDate();
pADatOpe=NullDate();
pTipOpe='';
}
if(arfn_chkdatper._p.length>0)_rargs([[['pDaDatOpe',arfn_chkdatper._p[0]],['pADatOpe',arfn_chkdatper._p[1]],['pTipOpe',arfn_chkdatper._p[2]]]],{eval:function(e){eval(e)}})
arfn_chkdatper._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_chkdatper._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_chkdatper._s.SetParameterString('pDaDatOpe',WtA(pDaDatOpe,'D'));
arfn_chkdatper._s.SetParameterString('pADatOpe',WtA(pADatOpe,'D'));
arfn_chkdatper._s.SetParameterString('pTipOpe',WtA(pTipOpe,'C'));
arfn_chkdatper._s.SetParameterString('m_bApplet','true');
arfn_chkdatper._s.CallServlet('arfn_chkdatper');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_chkdatper._s.errmsg;
}
return arfn_chkdatper._s.GetString();
}
arfn_chkdatper.CtxLoad_ = function(){return []}
