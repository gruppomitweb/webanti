<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<!DOCTYPE html>
<head>
  <script src="../jquery.js"></script>
  <script src="../jquery-ui.js"></script>
  <script src="../fSelect.js"></script>
  <script src="font_icon_picker.js"></script>

  <link rel="stylesheet" href="../properties.css">
  <link rel="stylesheet" href="font_icon_picker.css">
  <link rel="stylesheet" href="../fSelect.css">

</head>
<body >
  <div id="container">
    <select name="" id="fonts" multiple="multiple"></select>
    <select name="" id="glyphs"></select>
    <div id="example">
      <label for="unicode">HTML entity</label>
      <label for="html">Markup</label>
      <label for="hex">HEX</label>
      <label for="css">CSS content entity</label>
      <div>
        <input id="unicode" type="text" readonly="readonly">
        <i class="copy">C</i>
      </div>
      <div>
        <input id="html" type="text" readonly="readonly">
        <i class="copy">C</i>
      </div>
      <div>
        <input id="hex" type="text" readonly="readonly">
        <i class="copy">C</i>
      </div>
      <div>
        <input id="css" type="text" readonly="readonly">
        <i class="copy">C</i>
      </div>
    </div>
    <div id="footer">
      <div id="ok" class="button">SAVE</div><div id="cancel" class="button">CANCEL</div>
    </div>
  </div>
</body>
