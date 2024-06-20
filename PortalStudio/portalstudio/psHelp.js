var m_cHelpUrl=null;
document.addEventListener('DOMContentLoaded',function() {
  var tophtml = LibJavascript.Browser.TopFrame( 'm_cHelpUrl' );
  var jsToLoad = "help/portalstudio/ps_urg_dictionary.js";
  if (tophtml.m_cHelpUrl!=null) {
    m_cHelpUrl = tophtml.m_cHelpUrl;
    EndWhile();
  } else {
    var urlToFind = "help/portalstudio/images/ps_urg/ps_fronte.jpg";
    var urls = ['https://www.zucchettitools.com/build61.9/','https://www.zucchettitools.com/build61.7/','https://www.zucchettitools.com/build61/'];
    var i = 0;
    var img = document.createElement('img');
    img.style.visibility='hidden';
    img.style.top='0px';
    img.style.left='0px';
    img.style.width='1px';
    img.style.height='1px';
    // document.body.appendChild(img);
    img.onload = function() {
      //file trovato, ricerca conclusa
      tophtml.m_cHelpUrl = m_cHelpUrl = urls[i];
      // document.body.removeChild(img);
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
        tophtml.m_cHelpUrl = m_cHelpUrl = '../';
        // document.body.removeChild(img);
        EndWhile();
      }
    }
    WhileBody();
  }
  function EndWhile() {
    if (m_cHelpUrl!=null) {
      var fileref = document.createElement('script');
      fileref.setAttribute( "defer", true );
      fileref.setAttribute( "async", true );
      fileref.setAttribute("src",m_cHelpUrl+jsToLoad);
      document.getElementsByTagName("head")[0].appendChild(fileref);
    }
  }
});
