<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="java.util.*" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
%>
<html>
<head>
  <title>Pagelet Picker - Sitepainter Infinity Portalstudio</title>
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("fonts/OpenSans.css")%>">
  <style>
    html,
    body {
      margin: 0;
      width: 100%;
      height: 100%;
      overflow: hidden;
      font-family: 'Open Sans';
      font-size: 12px;
    }

    ul,
    li {
      border: 0;
      margin: 0;
      padding: 0;
    }

    .header {
      text-align: center;
      position: relative;
      background-color: #E3E3E3;
      font-weight: 400;
      padding: 5px 7px;
      font-size: 14px;
      color: rgba(0, 0, 0, .87);
      min-height: 18px;
    }

    .file-content {
      font-size: 13px;
      list-style-type: none;
    }

    .file-content li {
      padding: 3px 6px;
      color: #898989;
      font-size: 12px;
      border-bottom: 1px dotted #DEDEDE;
      cursor: pointer;
    }

    .file-content li:hover {
      background-color: #F0F4FE;
    }
  </style>

  <script>
    var editor = getParent();
    var pickerPagelet = editor.pickerObj;

    function generateFileManager() {
      var content = document.getElementById('file-content');
      var path, name, li,
        count = 0;

      for (var i = 0; pickerPagelet && i < pickerPagelet.length; i++) {
        count++;
        path = pickerPagelet[i].path;
        name = pickerPagelet[i].name;
        li = document.createElement('li');
        li.setAttribute('id', 'link-' + count);
        li.innerHTML = '<em>' + path + '</em> | ' + name;
        li.addEventListener('click', function(name, path) {
          editor.openType(name, '/../' + path);
        }.bind(this, name, path));
        content.appendChild(li);
      }
      document.getElementById('header').innerHTML = count > 0 ? count + ' pagelet found in:' : 'No pagelet found.';
      if (count == 1) {
        document.getElementById('link-1').click();
      }
      window.onblur = function(){ WindowClose(); }
    }

    document.onkeydown = function(e) {
      if (e.keyCode === 27) { // ESC
        if (window.parent.spModalLayer && window.frameElement && window.parent.spModalLayer[window.frameElement.id]) {
          window.parent.spModalLayer[window.frameElement.id].close();
        } else {
          window.close();
        }
        return false;
      }
    };

    function GetOpener() {
      if (window.opener) {
        return window.opener;
      }
      try {
        if (window.parent.spModalLayer && window.frameElement && window.parent.spModalLayer[window.frameElement.id]) {
          return window.parent.spModalLayer[window.frameElement.id].getOpenerRef();
        }
      } catch (e) { }
      return null;
    }

    function WindowClose() {
      if(window.parent.spModalLayer && window.frameElement && window.parent.spModalLayer[window.frameElement.id]) {
        window.parent.spModalLayer[window.frameElement.id].close();
      } else {
        window.close();
      }
    }

    function getParent() {
      var result = GetOpener();
      while (result.GetOpener() != null) {
        result = result.GetOpener();
      }
      return result;
    }

    window.onload = generateFileManager;
  </script>
</head>

<body>
  <header class="header" id="header"></header>
  <section>
    <ul class="file-content" id="file-content"></ul>
  </section>
</body>

</html>
