function arrt_ae_agg_aetesta_sog() {
var pSoggetto;
var pEstero;
var m_Caller
arrt_ae_agg_aetesta_sog._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSoggetto='';
pEstero=0;
}
if(arrt_ae_agg_aetesta_sog._p.length>0)_rargs([[['pSoggetto',arrt_ae_agg_aetesta_sog._p[0]],['pEstero',arrt_ae_agg_aetesta_sog._p[1]]]],{eval:function(e){eval(e)}})
arrt_ae_agg_aetesta_sog._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_agg_aetesta_sog._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_agg_aetesta_sog._s.SetParameterString('pSoggetto',WtA(pSoggetto,'C'));
arrt_ae_agg_aetesta_sog._s.SetParameterString('pEstero',WtA(pEstero,'N'));
arrt_ae_agg_aetesta_sog._s.SetParameterString('m_bApplet','true');
arrt_ae_agg_aetesta_sog._s.CallServlet('arrt_ae_agg_aetesta_sog');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_agg_aetesta_sog._s.errmsg;
}
}
arrt_ae_agg_aetesta_sog.CtxLoad_ = function(){return []}
