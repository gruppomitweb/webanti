function aosfn_unifonia() {
var pStr;
var pBlk;
var m_Caller
aosfn_unifonia._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pStr='';
pBlk='';
}
if(aosfn_unifonia._p.length>0)_rargs([[['pStr',aosfn_unifonia._p[0]],['pBlk',aosfn_unifonia._p[1]]]],{eval:function(e){eval(e)}})
aosfn_unifonia._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
aosfn_unifonia._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
aosfn_unifonia._s.SetParameterString('pStr',WtA(pStr,'C'));
aosfn_unifonia._s.SetParameterString('pBlk',WtA(pBlk,'C'));
aosfn_unifonia._s.SetParameterString('m_bApplet','true');
aosfn_unifonia._s.CallServlet('aosfn_unifonia');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=aosfn_unifonia._s.errmsg;
}
return aosfn_unifonia._s.GetString();
}
aosfn_unifonia.CtxLoad_ = function(){return []}
