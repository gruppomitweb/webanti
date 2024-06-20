function arrt_ae_agg_aetesta_tit() {
var pSoggetto;
var m_Caller
arrt_ae_agg_aetesta_tit._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pSoggetto='';
}
if(arrt_ae_agg_aetesta_tit._p.length>0)_rargs([[['pSoggetto',arrt_ae_agg_aetesta_tit._p[0]]]],{eval:function(e){eval(e)}})
arrt_ae_agg_aetesta_tit._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_agg_aetesta_tit._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_agg_aetesta_tit._s.SetParameterString('pSoggetto',WtA(pSoggetto,'C'));
arrt_ae_agg_aetesta_tit._s.SetParameterString('m_bApplet','true');
arrt_ae_agg_aetesta_tit._s.CallServlet('arrt_ae_agg_aetesta_tit');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_agg_aetesta_tit._s.errmsg;
}
}
arrt_ae_agg_aetesta_tit.CtxLoad_ = function(){return []}
