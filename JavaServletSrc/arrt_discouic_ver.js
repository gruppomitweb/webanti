function arrt_discouic_ver() {
var pTipo;
var w_DaDatOpe;
var w_ADatOpe;
var w_tipocr;
var w_codcr;
var w_flgfrazionate;
var w_storico;
var m_Caller
arrt_discouic_ver._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pTipo='';
w_DaDatOpe=NullDate();
w_ADatOpe=NullDate();
w_tipocr='';
w_codcr='';
w_flgfrazionate='';
w_storico='';
}
if(arrt_discouic_ver._p.length>0)_rargs([[['pTipo',arrt_discouic_ver._p[0]],['w_DaDatOpe',arrt_discouic_ver._p[1]],['w_ADatOpe',arrt_discouic_ver._p[2]],['w_tipocr',arrt_discouic_ver._p[3]],['w_codcr',arrt_discouic_ver._p[4]],['w_flgfrazionate',arrt_discouic_ver._p[5]],['w_storico',arrt_discouic_ver._p[6]]]],{eval:function(e){eval(e)}})
arrt_discouic_ver._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_discouic_ver._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_discouic_ver._s.SetParameterString('pTipo',WtA(pTipo,'C'));
arrt_discouic_ver._s.SetParameterString('w_DaDatOpe',WtA(w_DaDatOpe,'D'));
arrt_discouic_ver._s.SetParameterString('w_ADatOpe',WtA(w_ADatOpe,'D'));
arrt_discouic_ver._s.SetParameterString('w_tipocr',WtA(w_tipocr,'C'));
arrt_discouic_ver._s.SetParameterString('w_codcr',WtA(w_codcr,'C'));
arrt_discouic_ver._s.SetParameterString('w_flgfrazionate',WtA(w_flgfrazionate,'C'));
arrt_discouic_ver._s.SetParameterString('w_storico',WtA(w_storico,'C'));
arrt_discouic_ver._s.SetParameterString('m_bApplet','true');
arrt_discouic_ver._s.CallServlet('arrt_discouic_ver');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_discouic_ver._s.errmsg;
}
return arrt_discouic_ver._s.GetDouble();
}
arrt_discouic_ver.CtxLoad_ = function(){return []}
