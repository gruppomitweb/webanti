var m_cHelpUrl=null;
function Help(ctrlname) {
  var anchor="";
  if(typeof(anchorToFeature)!='undefined'){
    if(typeof(ctrlname)!='undefined'){
      anchor=anchorToFeature[ctrlname];
    }
    else if(typeof(SPAdmin_makeanchor)=='function') {
      anchor=anchorToFeature[SPAdmin_makeanchor()];
    }
    else if(typeof(m_cProgName)!='undefined'){
      anchor=anchorToFeature[m_cProgName]||anchorToFeature[m_cProgName.replace(/_/g, "")];
    }
  }
  var jsToLoad = "help/spadministration/spadministration_dictionary.js";
  var urlToFind = "help/spadministration/images/spr_urg/spr_fronte.jpg";
  var urls = ['https://www.zucchettitools.com/build61.7/','https://www.zucchettitools.com/build61/', '../'];
  var i = 0;
  var img = document.createElement('img');
  img.style.visibility='hidden';
  img.style.top='0px';
  img.style.left='0px';
  img.style.width='1px';
  img.style.height='1px';
  document.body.appendChild(img);
  img.onload = function() {
    //file trovato, ricerca conclusa
    m_cHelpUrl = urls[i];
    img.parentNode.removeChild(img);
    EndWhile();
  };
  img.onerror = function() {
    //file non trovato, continuo la ricerca
    i++;
    WhileBody();
  };
  function WhileBody() {
    if (urls[i]) {
      img.src = urls[i] + urlToFind;
    } else {
      m_cHelpUrl = '../';
      img.parentNode.removeChild(img);
      EndWhile();
    }
  }
  WhileBody();
  function EndWhile() {
    if (m_cHelpUrl!=null) {
      var fileref=document.createElement('script');
      fileref.setAttribute("src",m_cHelpUrl+jsToLoad);
      document.getElementsByTagName("head")[0].appendChild(fileref);
    }
    window.open((m_cHelpUrl||'../')+'help/spadministration/spadministration_navigator.htm?'+anchor,'','toolbar=0,menubar=0,directories=0,width=800,height=600,resizable=1');
  }
}