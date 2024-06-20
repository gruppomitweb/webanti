function arrt_ae_agg_aetesta_age() {
var w_RAPPORTO;
var w_TIPOOPRAP;
var w_NUMPROG;
var m_Caller
arrt_ae_agg_aetesta_age._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_RAPPORTO='';
w_TIPOOPRAP='';
w_NUMPROG='';
}
if(arrt_ae_agg_aetesta_age._p.length>0)_rargs([[['w_RAPPORTO',arrt_ae_agg_aetesta_age._p[0]],['w_TIPOOPRAP',arrt_ae_agg_aetesta_age._p[1]],['w_NUMPROG',arrt_ae_agg_aetesta_age._p[2]]]],{eval:function(e){eval(e)}})
arrt_ae_agg_aetesta_age._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_agg_aetesta_age._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_agg_aetesta_age._s.SetParameterString('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_ae_agg_aetesta_age._s.SetParameterString('w_TIPOOPRAP',WtA(w_TIPOOPRAP,'C'));
arrt_ae_agg_aetesta_age._s.SetParameterString('w_NUMPROG',WtA(w_NUMPROG,'C'));
arrt_ae_agg_aetesta_age._s.SetParameterString('m_bApplet','true');
arrt_ae_agg_aetesta_age._s.CallServlet('arrt_ae_agg_aetesta_age');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_agg_aetesta_age._s.errmsg;
}
}
arrt_ae_agg_aetesta_age.CtxLoad_ = function(){return []}
