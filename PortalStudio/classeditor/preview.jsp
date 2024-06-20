<%@ page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors"
%><%@ page import="com.zucchetti.sitepainter.SPPrxycizer"
%><!DOCTYPE html>
<html>
<head>
<title>Code generation preview</title>
<link type='text/css' rel='stylesheet' href='../portalstudio/portalstudioTheme.css'>
<link type="text/css" rel="stylesheet" href="../codemirror/lib/codemirror.css">
<link type="text/css" rel="stylesheet" href="../codemirror/theme/css-portalstudio.css">
<link type="text/css" rel="stylesheet" href="../codemirror/addon/scroll/simplescrollbars.css">
<style type="text/css">
  .html {
    overflow: hidden;
  }
  .standalone-page > div.standalone-container {
    vertical-align: top;
  }
  .standalone-container div {
    padding: 0;
  }
  .standalone-page h1 {
    text-align: center;
    font-weight: 300;
    padding: 6px;
    font-size: 14px;
    background-color: #c3c3c3;
    color: #676767;
  }
  .contenuto {
    height: 100%;
  }
  .CodeMirror {
    font-size: 14px;
    background-color: #F3F3F3;
    height: 290px;
    width: 480px;
    text-align: left;
    cursor: text;
  }
  .standalone-container .CodeMirror-scroll {
    padding-top: 7px;
    padding-bottom: 7px;
  }
  .cm-builtin {
    color: #C14D4D;
  }
  .cm-variable-2,
  .cm-number {
    color: #1000C9;
  }
  .cm-variable-3 {
    color: #00A0BD;
  }
</style>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("codemirror/addon/scroll/simplescrollbars.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("codemirror/mode/css/css.js")%>"></script>
<script>
  document.onkeydown = function(e) {
    if(e.keyCode === 27) { // ESC: chiudi finestra
      window.close();
    }
  };

  window.onload = function(e){
    var code = GetOpener().createAllCSS(GetOpener().newObj, GetOpener().newObj.type, true);
    code = cssbeautify(code, {
      indent: '  ',
      autosemicolon: true
    });

    var editor = CodeMirror.fromTextArea(document.getElementById("code_preview"), {
      lineNumbers: true,
      autofocus: true,
      lineWrapping: true,
      scrollbarStyle: 'simple',
      readOnly: true,
      showCursorWhenSelecting: true,
      mode: "text/css"
    });
    editor.setValue(code);
    editor.refresh();
  }
</script>
</head>

<body style='overflow: hidden;'>
  <div class='standalone-page'>
  <div class='standalone-container'>
    <h1 class="preview-title">Code generation preview</h1>
    <div class='contenuto'>
      <textarea id="code_preview" rows="4" cols="50">Code generation preview</textarea>
    </div>
  </div>
  </div>
  <script defer src="../<%=SPPrxycizer.proxycizedPath("classeditor/cssbeautify.js")%>"></script>
</body>
</html>
