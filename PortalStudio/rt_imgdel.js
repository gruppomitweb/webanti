function rt_imgdel() {
var image;
var folder_path;
var m_Caller
rt_imgdel._p=_rargs(arguments,{eval:function(e){eval(e)}})
function i_BlankParameters() {
image='';
folder_path='';
}
if(rt_imgdel._p.length>0)_rargs([[['image',rt_imgdel._p[0]],['folder_path',rt_imgdel._p[1]]]],{eval:function(e){eval(e)}})
rt_imgdel._s=new BatchJavascript();
if (Ne(typeof(document.FSender),'undefined') && Ne(typeof(document.FSender.m_cRegionalSettings),'undefined')) {
rt_imgdel._s.SetParameterString('m_cRegionalSettings',document.FSender.m_cRegionalSettings.value);
}
rt_imgdel._s.SetParameterString('image',WtA(image,'C'));
rt_imgdel._s.SetParameterString('folder_path',WtA(folder_path,'C'));
rt_imgdel._s.SetParameterString('m_bApplet','true');
rt_imgdel._s.CallServlet('rt_imgdel');
if (Eq(typeof(m_bCalculating),'undefined') ||  ! (m_bCalculating)) {
m_cErrorFromRoutine=rt_imgdel._s.errmsg;
}
return rt_imgdel._s.GetString();
}
rt_imgdel.CtxLoad_ = function(){return []}
