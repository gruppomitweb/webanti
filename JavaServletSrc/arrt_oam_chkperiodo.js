function arrt_oam_chkperiodo() {
var w_DaDatOpe;
var w_ADatOpe;
var w_flgncf;
var m_Caller
arrt_oam_chkperiodo._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_flgncf='';
}
if(arrt_oam_chkperiodo._p.length>0)_rargs([[['w_DaDatOpe',arrt_oam_chkperiodo._p[0]],['w_ADatOpe',arrt_oam_chkperiodo._p[1]],['w_flgncf',arrt_oam_chkperiodo._p[2]]]],{eval:function(e){eval(e)}})
arrt_oam_chkperiodo._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_oam_chkperiodo._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_oam_chkperiodo._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_oam_chkperiodo._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_oam_chkperiodo._s.SetParameterString('w_flgncf',WtA(w_flgncf,'C'));
arrt_oam_chkperiodo._s.SetParameterString('m_bApplet','true');
arrt_oam_chkperiodo._s.CallServlet('arrt_oam_chkperiodo');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_oam_chkperiodo._s.errmsg;
}
}
arrt_oam_chkperiodo.CtxLoad_ = function(){return []}
