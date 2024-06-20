function arrt_ae_agg_aetesta_anarap() {
var pRif;
var w_RAPPORTO;
var w_DESCRAP;
var w_TIPORAP;
var w_TIPOAG;
var w_VALUTA;
var w_NOPROT;
var m_Caller
arrt_ae_agg_aetesta_anarap._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
pRif='';
w_RAPPORTO='';
w_DESCRAP='';
w_TIPORAP='';
w_TIPOAG='';
w_VALUTA='';
w_NOPROT=0;
}
if(arrt_ae_agg_aetesta_anarap._p.length>0)_rargs([[['pRif',arrt_ae_agg_aetesta_anarap._p[0]],['w_RAPPORTO',arrt_ae_agg_aetesta_anarap._p[1]],['w_DESCRAP',arrt_ae_agg_aetesta_anarap._p[2]],['w_TIPORAP',arrt_ae_agg_aetesta_anarap._p[3]],['w_TIPOAG',arrt_ae_agg_aetesta_anarap._p[4]],['w_VALUTA',arrt_ae_agg_aetesta_anarap._p[5]],['w_NOPROT',arrt_ae_agg_aetesta_anarap._p[6]]]],{eval:function(e){eval(e)}})
arrt_ae_agg_aetesta_anarap._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_ae_agg_aetesta_anarap._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_ae_agg_aetesta_anarap._s.SetParameterString('pRif',WtA(pRif,'C'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('w_RAPPORTO',WtA(w_RAPPORTO,'C'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('w_DESCRAP',WtA(w_DESCRAP,'C'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('w_TIPORAP',WtA(w_TIPORAP,'C'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('w_TIPOAG',WtA(w_TIPOAG,'C'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('w_VALUTA',WtA(w_VALUTA,'C'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('w_NOPROT',WtA(w_NOPROT,'N'));
arrt_ae_agg_aetesta_anarap._s.SetParameterString('m_bApplet','true');
arrt_ae_agg_aetesta_anarap._s.CallServlet('arrt_ae_agg_aetesta_anarap');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_ae_agg_aetesta_anarap._s.errmsg;
}
}
arrt_ae_agg_aetesta_anarap.CtxLoad_ = function(){return []}
