function arrt_oam_invio() {
var w_dadata;
var w_a_data;
var w_anno;
var w_mese;
var w_tipofile;
var m_Caller
arrt_oam_invio._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_dadata=NullDate();
w_a_data=NullDate();
w_anno=0;
w_mese='';
w_tipofile=0;
}
if(arrt_oam_invio._p.length>0)_rargs([[['w_dadata',arrt_oam_invio._p[0]],['w_a_data',arrt_oam_invio._p[1]],['w_anno',arrt_oam_invio._p[2]],['w_mese',arrt_oam_invio._p[3]],['w_tipofile',arrt_oam_invio._p[4]]]],{eval:function(e){eval(e)}})
arrt_oam_invio._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_oam_invio._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_oam_invio._s.SetParameterString('w_dadata',WtA(w_dadata,'D'));
arrt_oam_invio._s.SetParameterString('w_a_data',WtA(w_a_data,'D'));
arrt_oam_invio._s.SetParameterString('w_anno',WtA(w_anno,'N'));
arrt_oam_invio._s.SetParameterString('w_mese',WtA(w_mese,'C'));
arrt_oam_invio._s.SetParameterString('w_tipofile',WtA(w_tipofile,'N'));
arrt_oam_invio._s.SetParameterString('m_bApplet','true');
arrt_oam_invio._s.CallServlet('arrt_oam_invio');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_oam_invio._s.errmsg;
}
return arrt_oam_invio._s.GetString();
}
arrt_oam_invio.CtxLoad_ = function(){return []}
