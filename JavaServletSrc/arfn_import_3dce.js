function arfn_import_3dce() {
var w_tbareegeog;
var w_tbspecie;
var w_tbtiporisc;
var w_tbsvolgim;
var w_tbcondotta;
var w_tbimporto;
var w_tbdurata;
var w_tbplauso;
var w_tbtipatt;
var m_Caller
arfn_import_3dce._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
w_tbareegeog='';
w_tbspecie='';
w_tbtiporisc='';
w_tbsvolgim='';
w_tbcondotta='';
w_tbimporto='';
w_tbdurata='';
w_tbplauso='';
w_tbtipatt='';
}
if(arfn_import_3dce._p.length>0)_rargs([[['w_tbareegeog',arfn_import_3dce._p[0]],['w_tbspecie',arfn_import_3dce._p[1]],['w_tbtiporisc',arfn_import_3dce._p[2]],['w_tbsvolgim',arfn_import_3dce._p[3]],['w_tbcondotta',arfn_import_3dce._p[4]],['w_tbimporto',arfn_import_3dce._p[5]],['w_tbdurata',arfn_import_3dce._p[6]],['w_tbplauso',arfn_import_3dce._p[7]],['w_tbtipatt',arfn_import_3dce._p[8]]]],{eval:function(e){eval(e)}})
arfn_import_3dce._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
arfn_import_3dce._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
arfn_import_3dce._s.SetParameterString('w_tbareegeog',WtA(w_tbareegeog,'C'));
arfn_import_3dce._s.SetParameterString('w_tbspecie',WtA(w_tbspecie,'C'));
arfn_import_3dce._s.SetParameterString('w_tbtiporisc',WtA(w_tbtiporisc,'C'));
arfn_import_3dce._s.SetParameterString('w_tbsvolgim',WtA(w_tbsvolgim,'C'));
arfn_import_3dce._s.SetParameterString('w_tbcondotta',WtA(w_tbcondotta,'C'));
arfn_import_3dce._s.SetParameterString('w_tbimporto',WtA(w_tbimporto,'C'));
arfn_import_3dce._s.SetParameterString('w_tbdurata',WtA(w_tbdurata,'C'));
arfn_import_3dce._s.SetParameterString('w_tbplauso',WtA(w_tbplauso,'C'));
arfn_import_3dce._s.SetParameterString('w_tbtipatt',WtA(w_tbtipatt,'C'));
arfn_import_3dce._s.SetParameterString('m_bApplet','true');
arfn_import_3dce._s.CallServlet('arfn_import_3dce');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=arfn_import_3dce._s.errmsg;
}
return arfn_import_3dce._s.GetString();
}
arfn_import_3dce.CtxLoad_ = function(){return []}
