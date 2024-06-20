function arfn_oamchar() {
var pString;
var pChar;
var m_Caller
arfn_oamchar._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pString='';
pChar='';
}
if(arfn_oamchar._p.length>0)_rargs([[['pString',arfn_oamchar._p[0]],['pChar',arfn_oamchar._p[1]]]],{eval:function(e){eval(e)}})
arfn_oamchar._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_oamchar._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_oamchar._s.SetParameterString('pString',WtA(pString,'C'));
arfn_oamchar._s.SetParameterString('pChar',WtA(pChar,'C'));
arfn_oamchar._s.SetParameterString('m_bApplet','true');
arfn_oamchar._s.CallServlet('arfn_oamchar');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_oamchar._s.errmsg;
}
return arfn_oamchar._s.GetString();
}
arfn_oamchar.CtxLoad_ = function(){return []}
