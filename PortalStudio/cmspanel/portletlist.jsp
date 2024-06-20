<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.Library" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  String zone=sp.getParameter("zone","");
	String type=sp.getParameter("type","");
	String mode=sp.getParameter("mode","");
	String resource_id=sp.getParameter("resource_id","");
	String parameters=sp.getParameter("parameters","");
	String portletName=sp.getParameter("portletName","");
	try{
		if(!parameters.equals("")) {
			JSONObject j = new JSONObject(parameters);
			parameters= j.toString();
		}
	} catch(Exception e) {
	  Library.error(e);
	}
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Portlet List</title>
	<style>
		@font-face {
		  font-family: 'iMobileIcon';
		  src: url('../fonts/iMobileIcon.eot');
		  src: url('../fonts/iMobileIcon.eot#iMobileIcon') format('embedded-opentype'),
		  		 url('../fonts/iMobileIcon.svg#iMobileIcon') format('svg'),
		  		 url('../fonts/iMobileIcon.woff') format('woff'),
		  		 url('../fonts/iMobileIcon.ttf') format('truetype');
		}

		body {
		  background: #E8E8E8;
		}

		.main {
		  display: none;
		  font-family: 'Open Sans';
		  font-size: 11px;
		}

		#parameters.main {
		  padding-bottom: 50px;
		}

		#loader_container {
		  position: fixed;
		  top: calc(50% - 24px);
		  left: calc(50% - 24px);
		}

		#searchline {
		  position: fixed;
		  cursor: pointer;
		  top: 45px;
		  right: 35px;
		  background: #c3c3c3;
		  padding: 12px;
		}

		#searchline input {
		  outline: 0;
		  width: 150px;
		  padding: 4px 2px;
		  font-size: 11px;
		  color: #676767;
		}

		.row {
		  margin: 0;
		  padding: 2px;
		  background: #E8E8E8;
		}

		.row input {
		  width: 45%;
		  padding: 2px;
		  margin: 2px;
		  margin-right: 5px;
		  font-size: 11px;
		  color: #676767;
		}

		p.portlet_p,
		p#title_portlet {
		  margin: 0;
		  padding: 4px;
		  padding-left: 15px;
		  font-size: 11px;
		  cursor: pointer;
		  color: #999999;
		  border-top: 1px solid #FFFFFF;
		  border-bottom: 1px solid #CCCCCC;
		}

		p#not_found {
		  margin: 0;
		  padding: 4px;
		  padding-left: 15px;
		  font-size: 11px;
		  cursor: pointer;
		  color: #FF0000;
		  display: none;
		}

		p.portlet_p:hover {
		  background: #FFFFFF;
		}

		p.portlet_selected {
		  color: #232323;
		  background: #FFFFFF;
		}

		.result_text {
		  color: #454545;
		  font-weight: bold;
		  background: #D8DFEA;
		}

		.row > span,
		.row > input {
		  display: inline-block;
		  vertical-align: top;
		}

		.icon {
		  display: inline-block;
		  font-family: 'iMobileIcon';
		  font-style: normal;
		  font-size: inherit;
		  text-rendering: auto;
		  -webkit-font-smoothing: antialiased;
		  -moz-osx-font-smoothing: grayscale;
		}

		.icon-delete {
		  margin-left: 5px;
		  font-size: 16px;
		  line-height: 22px;
		  color: #676767;
		  cursor: pointer;
		}

		.icon-delete::after {
		  display: inline-block;
		  content: '\e6a8';
		}

		.footbar_config {
		  display: none;
		}

		.icon-spinner::before {
		  content: '\e679';
		  font-size: 48px;
		}

		.icon-spin {
		  -webkit-animation: icon-spin 2s infinite linear;
		  animation: icon-spin 2s infinite linear;
		}

		@-webkit-keyframes icon-spin {
		  0% {
		    -webkit-transform: rotate(0deg);
		    transform: rotate(0deg);
		  }
		  100% {
		    -webkit-transform: rotate(359deg);
		    transform: rotate(359deg);
		  }
		}

		@keyframes icon-spin {
		  0% {
		    -webkit-transform: rotate(0deg);
		    transform: rotate(0deg);
		  }
		  100% {
		    -webkit-transform: rotate(359deg);
		    transform: rotate(359deg);
		  }
		}

		#toolbar-top {
		  margin: 10px;
		}

		#toolbar-bottom {
		  position: fixed;
		  width: 100%;
		  bottom: 0;
		  background-color: #c3c3c3;
		}

		.toolbar .actions {
		  list-style-type: none;
		  padding: 0;
		  margin: 0 auto;
		  display: table;
		  -webkit-user-select: none;
		  -moz-user-select: none;
		  -ms-user-select: none;
		  user-select: none;
		}

		.toolbar .actions .btn {
		  display: inline-block;
		  color: #ffffff;
		  background: #000000;
		  text-transform: capitalize;
		  cursor: pointer;
		  padding: 8px;
		  margin: 8px;
		  font-weight: 100;
		}

		.toolbar .actions .btn-confirm {
		  background-color: #00a0bd;
		  color: #ffffff;
		}

		.toolbar .actions .btn-tools {
		  background-color: #777;
		  color: #ffffff;
		}

		#title_portlet {
		  cursor: default;
		  font-size: 13px;
		  text-align: center;
		  padding-left: 0;
		  background: #FFFFFF;
		}
	</style>
</head>

<body>
	<div id="list" class="main">
	  <div id="contentlist"></div>
	  <div id="loader_container">
	    <span class="icon icon-spinner icon-spin"></span>
	  </div>
	  <div id="searchline">
	    <input name="search" id="search" type="text" placeholder="Search" />
	  </div>
	  <footer class="toolbar" id="toolbar-bottom">
	    <ul class="actions">
	      <li class="btn btn-tools" id="pick">Next</li>	      
	    </ul>
	  </footer>
	</div>
	<div id="parameters" class="main">
	  <p id="title_portlet"><span id="title_portlet_content"></span></p>
	  <div class="toolbar" id="toolbar-top">
	    <ul class="actions">
	      <li class="btn btn-tools" id="addParameter">Add parameter</li>
	    </ul>
	  </div>
	  <div id="paramcontainer" class="container">
	    <p class="row" id="paramrow" style="display:none">
	      <input type="text" class="inputname parameter" placeholder="Name" value="" />
	      <input type="text" class="inputvalue value" placeholder="Value" value="" />
	      <span id="paramrow_delete" class='icon icon-delete' title="Delete parameter"></span>
	    </p>
	  </div>
	  <footer class="toolbar" id="toolbar-bottom">
	    <ul class="actions">
	      <li class="btn btn-tools" id="prevPage">Prev</li>
	      <li class="btn btn-confirm" id="submit">Save</li>
	    </ul>
	  </footer>
	</div>

	<script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
	<script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
	<script src="../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>"></script>
	<script>
	  // Per compatibilita con PortalStudio
	  $('list').setAttribute('portlet_id', 'manualPortletList');

	  var SPWebRootURL = "<%=JSPLib.SPWebRootURL(request)%>";
	  var mode = '<%= JSPLib.ToJSValue(mode) %>';

	  $('searchline').fade(0.3);
	  $('searchline').addEvents({
	    'click': function() { $('search').focus(); }
	  });

	  if (mode != "edit") {
	    $('list').setStyle('display', 'block');
	    portletFiles = new JSURL(SPWebRootURL + "/servlet/JSPReader?type=portlet", true);
	    portletFiles = portletFiles.Response();
	    var Files = portletFiles.split(',');
	    var container = $('contentlist');
	    container.setStyle('display', 'none')
	    var pContainer = new Element('div');
	    var html = "<p id='not_found'>No element matching filter value</p>";
	    for (var i = 0; i < Files.length; i++) {
	      if (Files[i].indexOf('[icons...]') == -1) {
	        var name = Strtran(Files[i], "_portlet.jsp", "");
	        var cl = 'portlet_p ';
	        html += "<p name='" + name + "' id='portlet_" + i + "' class='" + cl + "'>" + name + "</p>";
	      }
	    }
	    container.innerHTML = html;

	    $$('.portlet_p').each(function(elem, index) {
	      elem.addEvents({
	        'dblclick': function() {
	          $('parameters').setStyle('display', 'block');
	          $('list').setStyle('display', 'none');
	          $('title_portlet_content').set('text', elem.get('text'))
	          $('submit').portlet = elem.get('text');
	        },
	        'click': function() {
	          $('pick').setStyle('display', 'block');
	          if (!elem.hasClass('portlet_selected')) {
	            $$('.portlet_selected').each(function(el) {
	              el.removeClass('portlet_selected');
	            });
	            elem.addClass('portlet_selected');
	            if (Empty(elem.description)) {
	              var des = new JSURL(SPWebRootURL + "/servlet/JSPReader?type=portlet&action=description&name=" + elem.get('text'));
	              des = des.Response();
	              if (des == "undefined") des = "No description";
	              elem.description = des;
	              elem.title = des;
	            }
	          }
	        }
	      });
	    });

	    var myTimer = null;
	    var currValue = "";
	    var found = false;

	    $('search').value = "";
	    var searchP = function() {
	      var txtToSearch = $('search').value;
	      currValue = txtToSearch;
	      $$('.portlet_p').each(function(el, index) {
	        var txt = el.get('text');
	        el.innerHTML = txt;
	        txt = el.get('text');
	        if (txt.indexOf(txtToSearch) == -1) {
	          el.setStyle('display', 'none');
	        } else {
	          found = true;
	          var nTxt = txt.replace(txtToSearch, "<span class='result_text'>" + txtToSearch + "</span>")
	          el.innerHTML = nTxt;
	          el.setStyle('display', 'block');
	        }
	      });

	      if (!found) {
	        $('not_found').setStyle('display', 'block');
	      }
	      if ($('search').value != "") {
	        $('searchline').setStyle('opacity', '0.8');
	      } else {
	        $('searchline').setStyle('opacity', '0.3');
	      }

	      $('loader_container').hide();
	    }

	    $('pick').addEvent('click', function() {	      
		  	var title = "";
	      $$('.portlet_selected').each(function(el) {
	        title = el.get('text');
	      })
			  if($$('.portlet_selected').length > 0) {
					$('parameters').setStyle('display', 'block');
					$('list').setStyle('display', 'none');
					$('title_portlet_content').set('text', title)
					$('submit').portlet = title;
			  }
	    })

	    $('search').addEvent('keyup', function() {
	      if (currValue != $('search').value) {
	        $('not_found').setStyle('display', 'none');
	        $('loader_container').show();
	        clearTimeout(myTimer);
	        myTimer = searchP.delay(200);
	        found = false;
	      }
	    });

	    var fnTD = function() {
	      $('loader_container').hide();
	      $('contentlist').show();
	    }
	    fnTD.delay(1000);

	    $('prevPage').addEvent('click', function() {
	      $('parameters').setStyle('display', 'none');
	      $('list').setStyle('display', 'block');
	    });
	  } else {
	    // modalità Edit
	    $('prevPage').setStyle('display', 'none');
	    <% if(!parameters.equals("")){ %>
	    var parameters = JSON.parse(<%= JSPLib.ToJSValue(parameters,true) %>);
	    <% } %>
	    var resource_id = '<%= JSPLib.ToJSValue(resource_id) %>';
	    var portletName = '<%= JSPLib.ToJSValue(portletName) %>';

	    $('title_portlet').set('text', portletName);

	    $('parameters').setStyle('display', 'block');
	    if (!Empty(parameters)) {
	      $('paramrow').setStyle('display', 'none');
	    }
	    for (name in parameters) {
	      var valToAssign = parameters[name];
	      var nmToAssign = name;
	      var row = $('paramrow');
	      var newRow = row.clone();
	      var maxIndex = 0;

	      $$('.row').each(function(elem, index) {
	        maxIndex++;
	      });
	      newRow.id = "paramrow" + maxIndex;
	      newRow.inject($('paramcontainer'));
	      var nm = newRow.getElement('.inputname');
	      var val = newRow.getElement('.inputvalue');
	      var del = newRow.getElement('span.icon-delete');
	      del.id = newRow.id + "_delete";
	      val.value = valToAssign;

	      nm.value = nmToAssign;
	      newRow.setStyle('display', 'block');
	      $(del.id).addEvent('click', function() {
	        var target = $(Strtran(this.id, "_delete", ""));
	        target.fade(0);
	        (function() { target.destroy() }).delay(500);
	      });
	    }
	  }

	  var zone = '<%= JSPLib.ToJSValue(zone) %>';
	  var type = '<%= JSPLib.ToJSValue(type) %>';

	  $('addParameter').addEvent('click', function(evt) {
	    var row = $('paramrow');
	    var newRow = row.clone();
	    var maxIndex = 0;
	    $$('.row').each(function(elem, index) {
	      maxIndex++;
	    });
	    newRow.id = "paramrow" + maxIndex;
	    newRow.inject($('paramcontainer'));
	    var nm = newRow.getElement('.inputname');
	    var val = newRow.getElement('.inputvalue');
	    var del = newRow.getElement('span.icon-delete');
	    del.id = newRow.id + "_delete";
	    newRow.setStyle('display', 'block');
	    nm.focus();

	    $(del.id).addEvent('click', function() {
	      $(newRow.id).destroy()
	    });

	  });
	  $('submit').addEvent('click', function(evt) {
	    var params = "";
	    $$('.row').each(function(elem, index) {
	      if (elem.getStyle('display') != 'none') {
	        var nm = elem.getElement('.inputname');
	        var val = elem.getElement('.inputvalue');
	        if (!Empty(nm.value) && !Empty(val.value)) {
	          params += nm.value + "=" + val.value + "&";
	        }
	      }
	    });
	    params = params.substr(0, params.length - 1);

	    if (mode == "edit") {
	      GetOpener().updateResource(resource_id, params);
	    } else {
	      GetOpener().insertResource($('submit').portlet + "_portlet.jsp", zone, params, type);
	    }
	    WindowClose();
	  });
	</script>

</body>
</html>