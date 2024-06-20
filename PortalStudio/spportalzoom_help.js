if (typeof(ZtVWeb)!='undefined')
  ZtVWeb.RequireLibrary("../help/portalstudio/spportalzoom_dictionary.js",true);
else
  document.write("<script src='../help/portalstudio/spportalzoom_dictionary.js' type='text/javascript'></script>");
/* exported Help */
function Help(ctrlname) {
  var anchor="";
  if(typeof(anchorToFeature)!='undefined'){
    if(typeof(ctrlname)!='undefined'){
      anchor=anchorToFeature[ctrlname];
    }
    else if(typeof(m_cProgName)!='undefined'){
      anchor=anchorToFeature[m_cProgName];
    }
  }
  window.open('../help/portalstudio/spportalzoom_navigator.htm?'+anchor,'','toolbar=0,menubar=0,directories=0,width=800,height=600,resizable=1');
}
