function arfn_flaglire() {
var pFlag;
var pData;
var m_Caller
arfn_flaglire._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pFlag='';
pData=NullDate();
}
if(arfn_flaglire._p.length>0)_rargs([[['pFlag',arfn_flaglire._p[0]],['pData',arfn_flaglire._p[1]]]],{eval:function(e){eval(e)}})
arfn_flaglire._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_flaglire._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_flaglire._s.SetParameterString('pFlag',WtA(pFlag,'C'));
arfn_flaglire._s.SetParameterString('pData',WtA(pData,'D'));
arfn_flaglire._s.SetParameterString('m_bApplet','true');
arfn_flaglire._s.CallServlet('arfn_flaglire');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_flaglire._s.errmsg;
}
return arfn_flaglire._s.GetString();
}
arfn_flaglire.CtxLoad_ = function(){return []}
