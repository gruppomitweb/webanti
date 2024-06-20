function arrt_riordina() {
var w_frzuif;
var w_opeage;
var w_opeuif;
var w_rapage;
var w_rapuif;
var w_titaui;
var w_flgpart;
var w_prgidb;
var w_prgnprg;
var w_prgiope;
var w_daData;
var w_dataover;
var w_ngiorni;
var m_Caller
arrt_riordina._p=_rargs(arguments,{eval:function(e){eval(e)}})
w_frzuif=m_Caller.GetString('w_frzuif','C',0,0);
w_opeage=m_Caller.GetString('w_opeage','C',0,0);
w_opeuif=m_Caller.GetString('w_opeuif','C',0,0);
w_rapage=m_Caller.GetString('w_rapage','C',0,0);
w_rapuif=m_Caller.GetString('w_rapuif','C',0,0);
w_titaui=m_Caller.GetString('w_titaui','C',0,0);
w_flgpart=m_Caller.GetString('w_flgpart','C',0,0);
w_prgidb=m_Caller.GetNumber('w_prgidb','N',0,0);
w_prgnprg=m_Caller.GetNumber('w_prgnprg','N',0,0);
w_prgiope=m_Caller.GetNumber('w_prgiope','N',0,0);
w_daData=m_Caller.GetDate('w_daData','D',0,0);
w_dataover=m_Caller.GetString('w_dataover','C',0,0);
w_ngiorni=m_Caller.GetNumber('w_ngiorni','N',0,0);
arrt_riordina._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arrt_riordina._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arrt_riordina._s.SetCallerStringVar('w_frzuif',WtA(w_frzuif,'C'));
arrt_riordina._s.SetCallerStringVar('w_opeage',WtA(w_opeage,'C'));
arrt_riordina._s.SetCallerStringVar('w_opeuif',WtA(w_opeuif,'C'));
arrt_riordina._s.SetCallerStringVar('w_rapage',WtA(w_rapage,'C'));
arrt_riordina._s.SetCallerStringVar('w_rapuif',WtA(w_rapuif,'C'));
arrt_riordina._s.SetCallerStringVar('w_titaui',WtA(w_titaui,'C'));
arrt_riordina._s.SetCallerStringVar('w_flgpart',WtA(w_flgpart,'C'));
arrt_riordina._s.SetCallerStringVar('w_prgidb',WtA(w_prgidb,'N'));
arrt_riordina._s.SetCallerStringVar('w_prgnprg',WtA(w_prgnprg,'N'));
arrt_riordina._s.SetCallerStringVar('w_prgiope',WtA(w_prgiope,'N'));
arrt_riordina._s.SetCallerStringVar('w_daData',WtA(w_daData,'D'));
arrt_riordina._s.SetCallerStringVar('w_dataover',WtA(w_dataover,'C'));
arrt_riordina._s.SetCallerStringVar('w_ngiorni',WtA(w_ngiorni,'N'));
arrt_riordina._s.SetParameterString('m_bApplet','true');
arrt_riordina._s.CallServlet('arrt_riordina');
m_Caller.SetString('w_frzuif','C',0,0,arrt_riordina._s.GetCallerStringVar('w_frzuif'));
m_Caller.SetString('w_opeage','C',0,0,arrt_riordina._s.GetCallerStringVar('w_opeage'));
m_Caller.SetString('w_opeuif','C',0,0,arrt_riordina._s.GetCallerStringVar('w_opeuif'));
m_Caller.SetString('w_rapage','C',0,0,arrt_riordina._s.GetCallerStringVar('w_rapage'));
m_Caller.SetString('w_rapuif','C',0,0,arrt_riordina._s.GetCallerStringVar('w_rapuif'));
m_Caller.SetString('w_titaui','C',0,0,arrt_riordina._s.GetCallerStringVar('w_titaui'));
m_Caller.SetString('w_flgpart','C',0,0,arrt_riordina._s.GetCallerStringVar('w_flgpart'));
m_Caller.SetNumber('w_prgidb','N',0,0,arrt_riordina._s.GetCallerDoubleVar('w_prgidb'));
m_Caller.SetNumber('w_prgnprg','N',0,0,arrt_riordina._s.GetCallerDoubleVar('w_prgnprg'));
m_Caller.SetNumber('w_prgiope','N',0,0,arrt_riordina._s.GetCallerDoubleVar('w_prgiope'));
m_Caller.SetDate('w_daData','D',0,0,DateFromApplet(arrt_riordina._s.GetCallerDateVar('w_daData')));
m_Caller.SetString('w_dataover','C',0,0,arrt_riordina._s.GetCallerStringVar('w_dataover'));
m_Caller.SetNumber('w_ngiorni','N',0,0,arrt_riordina._s.GetCallerDoubleVar('w_ngiorni'));
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arrt_riordina._s.errmsg;
}
if (Ne(typeof(CalledBatchEnd),'undefined')) {
CalledBatchEnd();
}
}
arrt_riordina.CtxLoad_ = function(){return []}
