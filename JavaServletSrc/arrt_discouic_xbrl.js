function arrt_discouic_xbrl() {
var w_DaDatOpe;
var w_ADatOpe;
var w_tipocr;
var w_codcr;
var w_datinv;
var w_numinv;
var w_flgfrazionate;
var w_storico;
var m_Caller
arrt_discouic_xbrl._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_tipocr='';
w_codcr='';
w_datinv=NullDate();
w_numinv=0;
w_flgfrazionate='';
w_storico='';
}
if(arrt_discouic_xbrl._p.length>0)_rargs([[['w_DaDatOpe',arrt_discouic_xbrl._p[0]],['w_ADatOpe',arrt_discouic_xbrl._p[1]],['w_tipocr',arrt_discouic_xbrl._p[2]],['w_codcr',arrt_discouic_xbrl._p[3]],['w_datinv',arrt_discouic_xbrl._p[4]],['w_numinv',arrt_discouic_xbrl._p[5]],['w_flgfrazionate',arrt_discouic_xbrl._p[6]],['w_storico',arrt_discouic_xbrl._p[7]]]],{eval:function(e){eval(e)}})
arrt_discouic_xbrl._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_discouic_xbrl._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_discouic_xbrl._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_discouic_xbrl._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_discouic_xbrl._s.SetParameterString('w_tipocr',WtA(w_tipocr,'C'));
arrt_discouic_xbrl._s.SetParameterString('w_codcr',WtA(w_codcr,'C'));
arrt_discouic_xbrl._s.SetParameterString('w_datinv',WtA(w_datinv,'D'));
arrt_discouic_xbrl._s.SetParameterString('w_numinv',WtA(w_numinv,'N'));
arrt_discouic_xbrl._s.SetParameterString('w_flgfrazionate',WtA(w_flgfrazionate,'C'));
arrt_discouic_xbrl._s.SetParameterString('w_storico',WtA(w_storico,'C'));
arrt_discouic_xbrl._s.SetParameterString('m_bApplet','true');
arrt_discouic_xbrl._s.CallServlet('arrt_discouic_xbrl');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_discouic_xbrl._s.errmsg;
}
return arrt_discouic_xbrl._s.GetDouble();
}
arrt_discouic_xbrl.CtxLoad_ = function(){return []}
