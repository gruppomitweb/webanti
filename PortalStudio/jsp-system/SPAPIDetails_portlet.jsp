<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.wServiceParams = 'paramNames=tool|component,paramValues=';\nthis.appSamplesUrl = this.SPApiGetUrl.Link();\nthis.itemAPI = null;\nthis.loadtimeout = false;\nthis.timeoutid = null;\nthis.mySamples = null;\nthis.tool = 'portlet';\nthis.LabelOtherFld.Hide();\nthis.LabelOtherFnc.Hide();\nthis.LabelOtherEvt.Hide();\n\nfunction showOtherSamples() {\n  var mysamples = this.mySamples;\n  if(mysamples == null) {\n    return;\n  }\n  \u002f*if(!mysamples[key] && !mysamples.oth._undef_) {\n    return;\n  }*\u002f\n  var keys = ['fld', 'fnc', 'evt', 'oth'];\n  var keysS = ['Fields', 'Functions', 'Events', 'Not classified'];\n  var html = \"\";\n  \n  for(var i=0; i\u003ckeys.length; i++) {\n    var kkey = keys[i];\n    if(!mysamples[kkey] && !mysamples.oth._undef_) {\n    \tcontinue;\n  \t}\n    var xhtml = \"\";\n    \n    for(var o in mysamples[kkey]) {\n      var s = mysamples[kkey][o];\n      for (var j=0; j\u003cs.length; j++) {\n        if ( !s[j].found ) {\n          xhtml+=this.getSamplesHTMLLink(this.tool, s[j]);\n        }\n      }\n    }\n    if(!Empty(xhtml)) {\n      html += '\u003cdiv\u003e\u003cspan class=\"label\"\u003e' + keysS[i] +'\u003c\u002fspan\u003e';\n    \txhtml = '\u003cul class=\"grid\"\u003e' + xhtml + '\u003c\u002ful\u003e';\n      html += xhtml + '\u003c\u002fdiv\u003e';\n  \t}\n    \n  }\n  \n  if(!Empty(html)) {\n    var myWindow = windowOpenForeground(\"..\u002fjsp-system\u002fSPReportMaskMessage_portlet.jsp?m_cDecoration=none&hideWarning=true\", \"\", \"toolbar=0,menubar=0,directories=0,width=720,height=100,resizable=1,scrollbars=1\");\n  \tmyWindow.frameElement.onload = function() {\n  \tif (typeof(this.contentWindow.ZtVWeb) != 'undefined') {\n    \tvar pmsg = this.contentWindow.ZtVWeb.getPortletWindow(\"SPReportMaskMessage\");\n      if (pmsg && pmsg.labelText && pmsg.labelText.Value) {\n        pmsg.labelText.Value(html);\n      }\n      else {\n        this.contentWindow.document.body.innerHTML =  html;\n      }\n  \t}\n    else {\n      this.contentWindow.document.body.innerHTML =  html;\n    }\n  }\n  }\n}\n\nfunction LabelOtherFld_Click(){\n  this.showOtherSamples();\n}\n\nfunction LabelOtherFnc_Click(){\n  this.showOtherSamples();\n}\n\nfunction LabelOtherEvt_Click(){\n  this.showOtherSamples();\n}\n\nfunction translateTabToWrite(tab) {\n  var t = tab.split(\"_\");\n  var ret = initialCap(t[0]);\n  for (var i = 1; i\u003ct.length; i++) {\n    ret = ret + \" \" + initialCap(t[i]);\n  }\n  return ret;\n}\n\nfunction translateTabToCheck(tab) {\n  var t = tab.split(\"_\");\n  var ret = t[0];\n  for (var i = 1; i\u003ct.length; i++) {\n    ret = ret + t[i];\n  }\n  return Strtran(Lower(ret),\" \", \"\");\n}\n\nfunction SPHelpWService_Response(cMsg){\n  if ( !this.loadtimeout ) {\n    if (this.timeoutid != null) {\n      clearTimeout (this.timeoutid);\n    }\n    this.mySamples = this.RegisterWSXML(cMsg);\n    this.myLoaded(this.mySamples);\n  }\n}\n\nfunction RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, key, prop) {\n  var fln = fl.split(\u002f[0-9]\u002f)[0];\n  \u002f\u002fvar prop = \"\";\n  var ind = fln.indexOf(itemAPI + '_' + key + '_');\n  if (Empty(prop) && (ind \u003e=0) ) {\n    prop = fln.substring((itemAPI + '_' + key + '_').length);\n  }\n  if(!Empty(prop)) {\n    if( !( mysamples[key][prop] ) ) {\n      mysamples[key][prop] = [];\n    }\n    mysamples[key][prop].push ( { link:fl, desc:ds });\n  }\n  else {\n    prop = '_undef_'\n    if( !( mysamples[key][prop] ) ) {\n      mysamples[key][prop] = [];\n    }\n    mysamples[key][prop].push ( { link:fl, desc:ds });\n  }\n}\n\nfunction RegisterToMySamples(itemAPI, fl, ds, as, mysamples) {\n  var found = false;\n  if (as) {\n    var itemObj = this.itemAPI.apiObj;\n  \tvar hiddenObj = this.itemAPI.apiHidden;\n    if (itemObj && itemObj.newProperties) { \u002f\u002ffld\n      var tab, ii, regkey=[];\n      for (var i in itemObj.newProperties) {\n        tab = itemObj.newProperties[i];\n      \tfor (ii = 0; ii \u003c tab.length; ii++) {\n          if((tab[ii].disabled != true && !Empty(tab[ii].name))) {\n            if (hiddenObj && hiddenObj.indexOf(tab[ii].propID) \u003e= 0) {\n              continue;\n            }\n            var name = tab[ii].name ? this.translateTabToCheck(tab[ii].name) : undefined;\n          \tvar tabname = this.translateTabToCheck(i);\n          \tvar section = tab[ii].section ? this.translateTabToCheck(tab[ii].section) : undefined;\n            var propID = tab[ii].propID ? this.translateTabToCheck(tab[ii].propID) : undefined;\n            var _in = (as.indexOf(name)\u003e=0) || (as.indexOf(tabname)\u003e=0) || (as.indexOf(section)\u003e=0) || (as.indexOf(propID)\u003e=0);\n            if( _in ) {\n              found = true;\n              var px;\n              if((as.indexOf(name)\u003e=0)) px = name;\n              else if((as.indexOf(tabname)\u003e=0)) px = tabname;\n              else if((as.indexOf(section)\u003e=0)) px = section;\n              else if((as.indexOf(propID)\u003e=0)) px = propID;\n              px = Strtran(px,' ', '');\n              if ( regkey.indexOf(px) \u003c 0 ) {\n                regkey.push(px);\n              \tthis.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, 'fld', px);\n              }\n            }\n      \t\t}\n      \t}\n    \t}\n    }\n    if (itemObj && itemObj.functions) { \u002f\u002ffnc\n      for (var i=0; i\u003citemObj.functions.length; i++) {\n        if( itemObj.generateSignatureObject ) {\n          var robj = itemObj.generateSignatureObject(itemObj.functions[i], 'function');\n          var name = robj.name;\n          if (name.indexOf(\"(\") \u003e= 0)\n            \tname = name.substring(0, name.indexOf(\"(\"));\n          \tname = this.translateTabToCheck(name);\n          \tvar _in = (as.indexOf(name)\u003e=0);\n            if( _in ) {\n              found = true;\n              this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, 'fnc', name);\n            }\n      \t\t}\n        \telse {\n          \tcontinue;\n        \t}\n      }\n    }\n    if (itemObj && itemObj.events) { \u002f\u002fevt\n      for (var i=0; i\u003citemObj.events.length; i++) {\n        if( itemObj.generateSignatureObject ) {\n          var robj = itemObj.generateSignatureObject(itemObj.events[i], 'event');\n          var name = robj.name;\n          if (name.indexOf(\"(\") \u003e= 0)\n            name = name.substring(0, name.indexOf(\"(\"));\n          name = this.translateTabToCheck(name);\n          var _in = (as.indexOf(name)\u003e=0);\n          if( _in ) {\n            found = true;\n            this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, 'evt', name);\n          }\n      \t}\n        else {\n          continue;\n        }\n      }\n    }\n  }\n  else {\n    var keys = ['fld', 'fnc', 'evt'];\n    for( var k=0; !found && k\u003ckeys.length; k++ ) {\n      var key = keys[k];\n      if (fl.indexOf(itemAPI + '_' + key + '_') == 0) {\n        found = true;\n        this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, key);\n      }\n    }\n  }\n  if( !found ) {\n    var keys = ['fld', 'fnc', 'evt'];\n    for( var k=0; !found && k\u003ckeys.length; k++ ) {\n      var key = keys[k];\n      if (fl.indexOf(itemAPI + '_' + key + '_') == 0) {\n        found = true;\n        this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, key);\n      }\n    }\n    if( !found ) {\n      key = 'oth';\n      var prop = '_undef_'\n      if( !( mysamples[key][prop] ) ) {\n        mysamples[key][prop] = [];\n      }\n      mysamples[key][prop].push ( { link:fl, desc:ds });\n    }\n  }\n}\n\nfunction RegisterWSXML(xmlstring) {\n  \u002f\u002fdebugger\n  var opener = GetOpener();\n  var itemAPI = Lower(opener.getRenderApiObjClass().apiType);\n  var mysamples = {};\n  mysamples.fld = {};\n  mysamples.fnc = {};\n  mysamples.evt = {};\n  mysamples.oth = {};\n  var err = false;\n  try {\n    this.XMLHelpWService.setXMLString(xmlstring);\n    this.XMLHelpWService.Query();\n     do {\n      var fl = this.XMLHelpWService.rs.PTL;\n      var ds = this.XMLHelpWService.rs.DESCR;\n      var as = this.XMLHelpWService.rs.ARGS;\n      if( as ) {\n        as = as.split(\",\");\n        for(var i=0; i\u003cas.length; i++) {\n          as[i] = this.translateTabToCheck(LRTrim(as[i]));\n        }\n      }\n      this.RegisterToMySamples(itemAPI, fl, ds, as, mysamples);\n    } \u002f\u002fout while\n    while(this.XMLHelpWService.Next())\n  }\n  catch(e) {\n    err = true;\n  }\n  if (!err && opener.setComponentSamples) {\n   opener.setComponentSamples(itemAPI, mysamples);\n  }\n  return mysamples;\n}\n\nfunction this_Loaded(){\n  var opener = GetOpener();\n  if( !( opener && opener.getRenderApiObjClass) ) {\n    return;\n  }\n  if(!( opener && opener.tool) ) {\n    return;\n  }\n  this.tool = opener.tool;\n  this.itemAPI = opener.getRenderApiObjClass(true);\n  var apiType = Lower(this.itemAPI.apiType);\n  if (opener.getComponentSamples) {\n    this.mySamples = opener.getComponentSamples(apiType);\n  }\n  if(!this.mySamples || this.mySamples==null) {\n    this.SPHelpWService.Parameters(this.wServiceParams + this.tool + '|' + apiType);\n    this.SPHelpWService.Link(); \u002f\u002fasync\n    var _this = this;\n    this.timeoutid = setTimeout( function(){\n      _this.loadtimeout = true;\n    \t_this.myLoaded();\n    }, 2000 );\n  }\n  else {\n    this.myLoaded(this.mySamples);\n  }\n}\n\nfunction myLoaded(mysamples){\n  var pages = ['Fields','Functions','Events'];\n  var opener = GetOpener(); \n  var setSteppable = false;\n  var tool = this.tool; \n  if( tool=='pageleteditor' || tool=='portlet' ) {\n  \tsetSteppable = true\n  }\n  \n  var apiType = this.itemAPI.apiType;\n  var itemObj = this.itemAPI.apiObj;\n  var hiddenObj = this.itemAPI.apiHidden;\n  \n  if (itemObj && itemObj.newProperties) {\n    var tab, ii;\n    var dataMatrix = [];\n    for (var i in itemObj.newProperties) {\n      tab = itemObj.newProperties[i];\n      for (ii = 0; ii \u003c tab.length; ii++) {\n          if((tab[ii].disabled != true && !Empty(tab[ii].name))) {\n            if (hiddenObj && hiddenObj.indexOf(tab[ii].propID) \u003e= 0) {\n              continue;\n            }\n          var name = tab[ii].name;\n          var type = this.setTypeDescription(tab[ii].type);\n          var desc = tab[ii].tooltip;\n          var tabname = (tab[ii].api_tab ? tab[ii].api_tab : i);\n          var section = (tab[ii].api_sect ? tab[ii].api_sect : tab[ii].section);\n          var defvalue = tab[ii].defaultValue;\n          var defvalueHTML = '';\n          var samples = '';\n          if ( defvalue == undefined ) {\n            defvalue = '( none )';\n          }\n          else {\n            defvalue = defvalue.toString();\n            defvalueHTML = '\u003cbr\u003e\u003cb\u003eDefault value:\u003c\u002fb\u003e '+ToHTML(defvalue);\n          }\n\n          \u002f\u002fsamples\n          var fld = 'fld';\n          var ssamples;\n          samples += this.getSamplesHTML(tool, mysamples, fld, tab[ii].propID);\n          ssamples = this.getSamplesHTML(tool, mysamples, fld, name);\n          if ( samples.indexOf(ssamples) \u003c 0 ) {\n\t\t\t\t\t\tsamples += ssamples;\n          }\n         \tssamples = this.getSamplesHTML(tool, mysamples, fld, section);\n          if ( samples.indexOf(ssamples) \u003c 0 ) {\n\t\t\t\t\t\tsamples += ssamples;\n          }\n          ssamples = this.getSamplesHTML(tool, mysamples, fld, tabname);\n          if ( samples.indexOf(ssamples) \u003c 0 ) {\n\t\t\t\t\t\tsamples += ssamples;\n          }\n          \n          \u002f\u002fci provo come tags\n          ssamples = this.getSamplesHTMLTag(tool, mysamples, fld, name);\n          if ( Empty (ssamples) ) {\n            ssamples = this.getSamplesHTMLTag(tool, mysamples, fld, section);\n          }\n          if ( Empty (ssamples) ) {\n            ssamples = this.getSamplesHTMLTag(tool, mysamples, fld, tabname);\n          }\n          if ( samples.indexOf(ssamples) \u003c 0 ) {\n\t\t\t\t\t\tsamples += ssamples;\n          }\n          if (!Empty(samples)) {\n            samples = '\u003cul\u003e' + samples + '\u003c\u002ful\u003e';\n          }\n            \n          var steppable = tab[ii].steppable;\n          if(steppable == undefined) {\n            steppable = false;\n          }\n          if(steppable == true) {\n            name = name + \"*\";\n          }\n          var rec = [];\n          rec.push(this.setMyValue(name));\n          rec.push(this.setMyValue(this.translateTabToWrite(tabname)));\n          rec.push(this.setMyValue(section));\n          rec.push(this.setMyValue(type, false)+defvalueHTML);\n          rec.push(this.setMyValue(desc, false));\n          rec.push(this.setMyValue(samples));\n          dataMatrix.push(rec);\n        }\n      }\n    }\n    this.StaticDataProviderItemsObj.FillData(dataMatrix);\n    if( !setSteppable ) {\n      this.LabelInfoFld.Hide();\n    }\n  }\n  else {\n    this.LabelInfoFld.Hide();\n    this.HidePage(pages, 'Events');\n  }\n  \n  this.loadFunctionsEvents(itemObj, 'functions', 'Functions', this.StaticDataProviderItemsFunc, false, pages, mysamples, tool);\n  this.loadFunctionsEvents(itemObj, 'events', 'Events', this.StaticDataProviderItemsEvt, true, pages, mysamples, tool);\n  \n  this.enableOtherSamples(mysamples);\n}\n  \nfunction enableOtherSamples(mysamples) {\n  if(mysamples == null) {\n    return;\n  }\n  if(mysamples.oth && mysamples.oth._undef_) {\n    this.LabelOtherFld.Show();\n    this.LabelOtherFnc.Show();\n    this.LabelOtherEvt.Show();\n    return;\n  }\n  var keys = ['fld','fnc','evt'];\n  for (var j=0; j\u003ckeys.length; j++) {\n    var key = keys[j];\n    for(var o in mysamples[key]) {\n      var s = mysamples[key][o];\n        for (var i=0; i\u003cs.length; i++) {\n          if( !s[i].found ) {\n            this.LabelOtherFld.Show();\n    \t\t\t\tthis.LabelOtherFnc.Show();\n    \t\t\t\t\tthis.LabelOtherEvt.Show();\n            i = s.length;\n            j = keys.length;\n        }\n      }\n  \t}\n  }\n  \n}\n\nfunction getSamplesHTMLTag(tool, mysamples, keytab, stringToTag) {\n  var samples = \"\";\n  if (stringToTag == undefined)\n    return samples;\n  if( mysamples && mysamples[keytab] ) {\n    var tsplists = Strtran(stringToTag, \"_\", \" \").split(\" \");\n    var keys = Object.keys(mysamples[keytab]);\n    var found = false;\n    for( var n=0; !found && n\u003ckeys.length; n++) {\n      for ( var k=0; !found && k\u003ctsplists.length; k++) {\n        var ts = Lower(tsplists[k]);\n        if ( ts.length \u003e= 3 && keys[n].indexOf(ts) \u003e=0 ) {\n          found = true;\n          samples += this.getSamplesHTML(tool, mysamples, keytab, keys[n]);\n        }\n      }\n    }\n  }\n  return samples;\n}\n\nfunction getSamplesHTMLLink(tool, s, key) {\n  var samples = '\u003cli\u003e';\n  var link = '';\n  var fileid = s.link;\n  var ext = '';\n  var toolurl = '';\n  if (tool == 'portlet') {\n    ext = '_portlet.jsp';\n    toolurl = '\u002fvisualweb\u002feditor.jsp?autopreview=true&id=';\n  }\n  else if (tool == 'pageleteditor') {\n    ext = '.jsp';\n    toolurl = '\u002fpageleteditor\u002fpagelet_editor.jsp?&autopreview=true&name=';\n  }\n  else if (tool == 'report') {\n    ext = '.vrp';\n    toolurl = '\u002freporteditor\u002findex.jsp?autopreview=true&id=';\n  }\n  else if (tool == 'chart') {\n    ext = '.chartdef';\n    toolurl = '\u002fchart\u002findex.jsp?autopreview=true&filename=';\n  }\n  else if (tool == 'module') {\n    ext = '.mrp';\n    toolurl = '\u002fmoduleeditor\u002fmoduleeditor.jsp?autopreview=true&id=';\n  }\n  else if (tool == 'maskparameters') {\n    ext = '.vdm';\n    toolurl = '\u002fmaskparameters\u002fmaskparameters.jsp?autopreview=true&filename=';\n  }\n  if(!Empty(ext)) {\n    var pos = fileid.indexOf(ext);\n    if ( pos \u003e= 0 ) {\n      fileid = fileid.substring(0, pos);\n    }\n  }\n  link = this.appSamplesUrl + toolurl + fileid;\n  \n  if ( key ) {\n    s.found = true;\n    if ( key != s.desc ) {\n      samples += '\u003ca target=\"_blank\" href=\"' + link + '\"\u003e [' + key + '] ' + s.desc + '\u003c\u002fa\u003e';\n    }\n    else {\n      samples += '\u003ca target=\"_blank\" href=\"' + link + '\"\u003e' + s.desc + '\u003c\u002fa\u003e';\n    }\n  }\n  else {\n    if ( s.link != s.desc ) {\n      samples += '\u003ca target=\"_blank\" href=\"' + link + '\"\u003e [' + s.link + '] ' + s.desc + '\u003c\u002fa\u003e';\n    }\n    else {\n      samples += '\u003ca target=\"_blank\" href=\"' + link + '\"\u003e' + s.desc + '\u003c\u002fa\u003e';\n    }\n  }\n  samples += '\u003c\u002fli\u003e';\n  return samples;\n}\n  \nfunction getSamplesHTML(tool, mysamples, keytab, key) {\n  var samples = \"\";\n  if (key == undefined)\n    return samples;\n  key = this.translateTabToCheck(key);\n  if( mysamples && mysamples[keytab] && mysamples[keytab][key]) {\n    for (var n=0; n\u003cmysamples[keytab][key].length; n++) {\n      var s = mysamples[keytab][key][n];\n      samples += this.getSamplesHTMLLink(tool, s, key);\n    }\n  }\n  return samples;\n}\n\nfunction loadFunctionsEvents(itemObj, itemObjKey, PageKey, dataProvider, asEvt, pages, mysamples, tool) {\n  if (itemObj && itemObj[itemObjKey] && (itemObj[itemObjKey].length \u003e 0)) {\n    var dataMatrix = [];\n    for(var i=0; i\u003citemObj[itemObjKey].length; i++) {\n      var ff = itemObj[itemObjKey][i];\n      var name = '';\n      var sign = '';\n      var desc = '';\n      var ashtml = false;\n      var samples = '';\n      if( itemObj.generateSignatureObject ) {\n        var robj = itemObj.generateSignatureObject(ff, asEvt ? 'event' : 'function');\n        name = robj.name;\n        sign = robj.signature;\n        desc = robj.tooltip;\n      }\n      var rec = [];\n      if(!Empty(name)) {\n        name = name.split('(')[0];\n        rec.push(this.setMyValue(name));\n        var samplekey = 'fnc';\n        if(asEvt == true) {\n          sign = 'function [ObjectName]_' + sign;\n          samplekey = 'evt';\n        }\n        if(sign.indexOf('(') \u003c 0) {\n          sign = sign + '()';\n        }\n        samples = this.getSamplesHTML(tool, mysamples, samplekey, name);\n        \u002f\u002fci provo come tags\n        var ssamples = this.getSamplesHTMLTag(tool, mysamples, samplekey, name);\n        if ( samples.indexOf(ssamples) \u003c 0 ) {\n          samples += ssamples;\n        }\n        if (!Empty(samples)) {\n          samples = '\u003cul\u003e' + samples + '\u003c\u002ful\u003e';\n        }\n        rec.push(this.setMyValue(sign));\n        rec.push(this.setMyValue(desc, ashtml));\n        rec.push(this.setMyValue(samples));\n        dataMatrix.push(rec);\n      }\n    }\n    dataProvider.FillData(dataMatrix);\n  }\n  else {\n    this.HidePage(pages, PageKey);\n  }\n}\n\nfunction HidePage(mypageskey, pagekey) {\n  var index = mypageskey.indexOf(pagekey);\n  if(index \u003e= 0) {\n    index = index + 1;\n    this.ZtTabs.Hide(index,true);\n  }\n}\n\nfunction initialCap(txt) {\n  if( txt.substr )\n    return txt.substr(0, 1).toUpperCase() + txt.substr(1);\n  else return \"\"\n}\n\nfunction setMyValue(value, ashtml) {\n  if(Empty(value)) {\n    return '';\n  }\n  if(ashtml == undefined) {\n    ashtml = false;\n  }\n  if(ashtml == true) {\n  \treturn ToHTML(this.initialCap(value));\n  }\n  else {\n    return this.initialCap(value);\n  }\n}\n\nfunction setTypeDescription(type) {\n  if(Empty(type))\n    return '';\n  if ( type == 'str' )\n    return 'string';\n  if ( type == 'int' )\n    return 'numeric';\n  if (type == 'checkbox' )\n    return 'logic';\n  if( type.indexOf('select[') == 0 ) {\n    var ret = 'selection values\u003cbr\u003e\u003cul\u003e';\n    type = Strtran(type, 'select[', '');\n    type = Strtran(type, ']', '');\n    var types = type.split(',');\n    for(var i=0; i\u003ctypes.length; i++) {\n      var t = types[i];\n      if(Empty(t)) {\n        t = '(none)';\n      }\n      if( t.indexOf(':') \u003e= 0) {\n        var tt = t.split(':')\n        t = tt[0] + ' ( ' + tt[1] + ' )';\n      }\n      ret = ret + '\u003cli\u003e' + t + '\u003c\u002fli\u003e';\n    }\n    ret = ret + '\u003c\u002ful\u003e'\n    return ret;\n  }\n  return type;\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"blockquote","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"bg_color\":\"#F3F3F3\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"oddrow\",\"selector\":\".oddrow\",\"id\":\"form\",\"code\":\".oddrow {\\n  background-color: #F3F3F3;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"bg_color\":\"transparent\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"hoverrow\",\"selector\":\".hoverrow\",\"id\":\"form\",\"code\":\".hoverrow {\\n  background-color: transparent;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"border_color\":\"\",\"code\":\"    padding: 10px;\\n    border-bottom: 0px;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"mgrid\",\"selector\":\".mgrid\",\"id\":\"form\",\"code\":\".mgrid {\\n  padding: 10px;\\n  border-bottom: 0px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"border_color\":\"\",\"code\":\"    padding: 10px;\\n    border-bottom: 0px;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"mgrid\",\"selector\":\".grid .mgrid td\",\"id\":\"form\",\"code\":\".grid .mgrid td {\\n  padding: 10px;\\n  border-bottom: 0px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"mgridbline\",\"selector\":\".mgridbline\",\"id\":\"form\",\"code\":\"\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"padding: 5px;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"mgridbline\",\"selector\":\".grid .mgridbline td\",\"id\":\"form\",\"code\":\".grid .mgridbline td {\\n  padding: 5px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"decoration\":\"underline\",\"font_color\":\"#0000EE\",\"code\":\"\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"csslink\",\"selector\":\".csslink\",\"value\":\"Other samples\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".csslink {\\n  cursor: pointer;\\n  color: #0000EE;\\n  text-decoration: underline;\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"margin: 5px;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"ul\",\"selector\":\"ul\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"decoration\":\"underline\",\"code\":\"\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"labellink\",\"selector\":\".labellink\",\"value\":\"API View by tag\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"margin-block-start: 2px;\\nmargin-block-end: 2px;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"blockquote\",\"selector\":\"blockquote\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @GridA }}{{ @GridE }}{{ @GridF }}{{ @LabelInfoFld }}{{ @LabelInfoFunc }}{{ @LabelInfoEvt }}{{ @LabelOtherFld }}{{ @LabelOtherFnc }}{{ @LabelOtherEvt }}\u003c\u002fbody\u003e","grapesCss":"","h":"500,500,500","hsl":"","htmlcode":"{{ @GridA }} \n{{ GridA }}\n{{ GridE }}\n{{ GridF }}\n{{ StaticDataProviderItemsObj }}\n{{ StaticDataProviderItemsEvt }}\n{{ StaticDataProviderItemsFunc }}\n{{ LabelInfoFld }}\n{{ LabelInfoFunc }}\n{{ LabelInfoEvt }}\n{{ LabelOtherFld }}\n{{ LabelOtherFnc }}\n{{ LabelOtherEvt }}\n{{ SPHelpWService }}\n{{ SPApiGetUrl }}\n{{ XMLHelpWService }}\n{{ @GridE }} \n{{ @GridF }} \n{{ @LabelInfoFld }} \n{{ @LabelInfoFunc }} \n{{ @LabelInfoEvt }} \n{{ @LabelOtherFld }} \n{{ @LabelOtherFnc }} \n{{ @LabelOtherEvt }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1,2,3","pagesProp":"[{\"title\":\"Fields\",\"layer\":\"\",\"h\":\"500\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"Functions\",\"layer\":\"\",\"h\":\"500\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"Events\",\"layer\":\"\",\"h\":\"500\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Fields,Functions,Events","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"false","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%,100%,100%","wizard":"false"},{"align":"left","anchor":"top-left-right(%)","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"Name\",\"title\":\"Name\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"bold\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"\",\"RowSpan\":\"\",\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Tab\",\"title\":\"Tab\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Section\",\"title\":\"Section\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Type\",\"title\":\"Type\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Description\",\"title\":\"Description\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Samples\",\"title\":\"Samples\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"show_extra_title\":false,\"hidden\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"grid_row mgrid","css_class_row_odd":"grid_rowodd mgrid","css_class_row_over":"hoverrow","css_class_row_selected":"hoverrow","css_class_title":"grid_cell_title mgridbline","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"StaticDataProviderItemsObj","disabled_fld":"","draggable_name":"","draggable_row":"false","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"457","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"GridA","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"#ECECEC","row_color_odd":"#FFFFFF","rows":"250","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"#ECECEC","type":"Grid","valign":"top","w":"780","wireframe_props":"colProperties,checkbox,rows","x":"10","y":"38","zindex":"2","zone":""},{"align":"left","anchor":"top-left-right(%)","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"Name\",\"title\":\"Name\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"bold\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Signature\",\"title\":\"Signature\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Description\",\"title\":\"Description\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Samples\",\"title\":\"Samples\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"grid_row mgrid","css_class_row_odd":"grid_rowodd mgrid","css_class_row_over":"hoverrow","css_class_row_selected":"hoverrow","css_class_title":"grid_cell_title mgridbline","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"StaticDataProviderItemsEvt","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"457","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"GridE","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"3","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"#ECECEC","row_color_odd":"#FFFFFF","rows":"250","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"#ECECEC","type":"Grid","valign":"top","w":"780","wireframe_props":"colProperties,checkbox,rows","x":"10","y":"39","zindex":"2","zone":""},{"align":"left","anchor":"top-left-right(%)","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"Name\",\"title\":\"Name\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"bold\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Signature\",\"title\":\"Signature\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Description\",\"title\":\"Description\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"Samples\",\"title\":\"Samples\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"grid_row mgrid","css_class_row_odd":"grid_rowodd mgrid","css_class_row_over":"hoverrow","css_class_row_selected":"hoverrow","css_class_title":"grid_cell_title mgridbline","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"StaticDataProviderItemsFunc","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"457","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"GridF","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"#ECECEC","row_color_odd":"#FFFFFF","rows":"250","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"#ECECEC","type":"Grid","valign":"top","w":"780","wireframe_props":"colProperties,checkbox,rows","x":"10","y":"39","zindex":"2","zone":""},{"alias":"Name,Tab,Section,Type,Description,Samples","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C,C,C,C","h":"20","man_query":"","name":"StaticDataProviderItemsObj","page":"1","parms":"","parms_source":"","sequence":"3","type":"StaticDataProvider","w":"204","x":"813","y":"20"},{"alias":"Name,Signature,Description,Samples","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C,C","h":"26","man_query":"","name":"StaticDataProviderItemsEvt","page":"3","parms":"","parms_source":"","sequence":"4","type":"StaticDataProvider","w":"204","x":"810","y":"20"},{"alias":"Name,Signature,Description,Samples","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C,C","h":"20","man_query":"","name":"StaticDataProviderItemsFunc","page":"2","parms":"","parms_source":"","sequence":"5","type":"StaticDataProvider","w":"204","x":"810","y":"20"},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelInfoFld","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":" * steppable field","w":"487","wireframe_props":"align,value,n_col","x":"10","y":"18","zindex":"5","zone":""},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelInfoFunc","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Function parameters describe between # (#parameter#) are optional","w":"466","wireframe_props":"align,value,n_col","x":"10","y":"18","zindex":"5","zone":""},{"align":"left","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelInfoEvt","nowrap":"false","page":"3","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"[ObjectName] will be replace in the Event Signature with the component name","w":"526","wireframe_props":"align,value,n_col","x":"10","y":"18","zindex":"5","zone":""},{"align":"right","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labellink","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelOtherFld","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"none","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Other samples","w":"149","wireframe_props":"align,value,n_col","x":"641","y":"18","zindex":"5","zone":""},{"align":"right","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labellink","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelOtherFnc","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"none","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Other samples","w":"149","wireframe_props":"align,value,n_col","x":"641","y":"18","zindex":"5","zone":""},{"align":"right","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labellink","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelOtherEvt","nowrap":"false","page":"3","picture":"","rapp":"","sanitize":"none","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Other samples","w":"152","wireframe_props":"align,value,n_col","x":"638","y":"18","zindex":"5","zone":""},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"","name":"SPHelpWService","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"false","refresh":"","sequence":"12","servlet":"spgetapihelpws","target":"","type":"SPLinker","w":"204","x":"814","y":"44"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPApiGetUrl","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"false","refresh":"","sequence":"13","servlet":"spgetapihelpurl","target":"","type":"SPLinker","w":"204","x":"814","y":"92"},{"async":"false","auto_exec":"false","ctrlOfVariant":"","h":"20","n_records":"","name":"XMLHelpWService","page":"1","parms":"","parms_source":"","root":"\u002fRECORDS\u002fRECORD","sequence":"14","source":"","type":"XMLDataobj","w":"204","x":"814","xmldataobj":"","y":"68"}]%>
<%/*Description:*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(sp.getParameter("SpStaticCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/javascript");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
window.SPAPIDetails_Static=function(){
if(typeof showOtherSamples !='undefined')this.showOtherSamples=showOtherSamples;
if(typeof LabelOtherFld_Click !='undefined')this.LabelOtherFld_Click=LabelOtherFld_Click;
if(typeof LabelOtherFnc_Click !='undefined')this.LabelOtherFnc_Click=LabelOtherFnc_Click;
if(typeof LabelOtherEvt_Click !='undefined')this.LabelOtherEvt_Click=LabelOtherEvt_Click;
if(typeof translateTabToWrite !='undefined')this.translateTabToWrite=translateTabToWrite;
if(typeof translateTabToCheck !='undefined')this.translateTabToCheck=translateTabToCheck;
if(typeof SPHelpWService_Response !='undefined')this.SPHelpWService_Response=SPHelpWService_Response;
if(typeof RegisterToMySamplesKey !='undefined')this.RegisterToMySamplesKey=RegisterToMySamplesKey;
if(typeof RegisterToMySamples !='undefined')this.RegisterToMySamples=RegisterToMySamples;
if(typeof RegisterWSXML !='undefined')this.RegisterWSXML=RegisterWSXML;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof myLoaded !='undefined')this.myLoaded=myLoaded;
if(typeof enableOtherSamples !='undefined')this.enableOtherSamples=enableOtherSamples;
if(typeof getSamplesHTMLTag !='undefined')this.getSamplesHTMLTag=getSamplesHTMLTag;
if(typeof getSamplesHTMLLink !='undefined')this.getSamplesHTMLLink=getSamplesHTMLLink;
if(typeof getSamplesHTML !='undefined')this.getSamplesHTML=getSamplesHTML;
if(typeof loadFunctionsEvents !='undefined')this.loadFunctionsEvents=loadFunctionsEvents;
if(typeof HidePage !='undefined')this.HidePage=HidePage;
if(typeof initialCap !='undefined')this.initialCap=initialCap;
if(typeof setMyValue !='undefined')this.setMyValue=setMyValue;
if(typeof setTypeDescription !='undefined')this.setTypeDescription=setTypeDescription;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
  this.EnablePage(3);
}
this.EnablePage(1);
this.EnablePage(2);
this.EnablePage(3);
this.StaticDataProviderItemsObj.addRowConsumer(this.GridA);
this.StaticDataProviderItemsEvt.addRowConsumer(this.GridE);
this.StaticDataProviderItemsFunc.addRowConsumer(this.GridF);
this.wServiceParams = 'paramNames=tool|component,paramValues=';
this.appSamplesUrl = this.SPApiGetUrl.Link();
this.itemAPI = null;
this.loadtimeout = false;
this.timeoutid = null;
this.mySamples = null;
this.tool = 'portlet';
this.LabelOtherFld.Hide();
this.LabelOtherFnc.Hide();
this.LabelOtherEvt.Hide();
function showOtherSamples() {
  var mysamples = this.mySamples;
  if(mysamples == null) {
    return;
  }
  
  var keys = ['fld', 'fnc', 'evt', 'oth'];
  var keysS = ['Fields', 'Functions', 'Events', 'Not classified'];
  var html = "";
  
  for(var i=0; i<keys.length; i++) {
    var kkey = keys[i];
    if(!mysamples[kkey] && !mysamples.oth._undef_) {
    	continue;
  	}
    var xhtml = "";
    
    for(var o in mysamples[kkey]) {
      var s = mysamples[kkey][o];
      for (var j=0; j<s.length; j++) {
        if ( !s[j].found ) {
          xhtml+=this.getSamplesHTMLLink(this.tool, s[j]);
        }
      }
    }
    if(!Empty(xhtml)) {
      html += '<div><span class="label">' + keysS[i] +'</span>';
    	xhtml = '<ul class="grid">' + xhtml + '</ul>';
      html += xhtml + '</div>';
  	}
    
  }
  
  if(!Empty(html)) {
    var myWindow = windowOpenForeground("../jsp-system/SPReportMaskMessage_portlet.jsp?m_cDecoration=none&hideWarning=true", "", "toolbar=0,menubar=0,directories=0,width=720,height=100,resizable=1,scrollbars=1");
  	myWindow.frameElement.onload = function() {
  	if (typeof(this.contentWindow.ZtVWeb) != 'undefined') {
    	var pmsg = this.contentWindow.ZtVWeb.getPortletWindow("SPReportMaskMessage");
      if (pmsg && pmsg.labelText && pmsg.labelText.Value) {
        pmsg.labelText.Value(html);
      }
      else {
        this.contentWindow.document.body.innerHTML =  html;
      }
  	}
    else {
      this.contentWindow.document.body.innerHTML =  html;
    }
  }
  }
}
function LabelOtherFld_Click(){
  this.showOtherSamples();
}
function LabelOtherFnc_Click(){
  this.showOtherSamples();
}
function LabelOtherEvt_Click(){
  this.showOtherSamples();
}
function translateTabToWrite(tab) {
  var t = tab.split("_");
  var ret = initialCap(t[0]);
  for (var i = 1; i<t.length; i++) {
    ret = ret + " " + initialCap(t[i]);
  }
  return ret;
}
function translateTabToCheck(tab) {
  var t = tab.split("_");
  var ret = t[0];
  for (var i = 1; i<t.length; i++) {
    ret = ret + t[i];
  }
  return Strtran(Lower(ret)," ", "");
}
function SPHelpWService_Response(cMsg){
  if ( !this.loadtimeout ) {
    if (this.timeoutid != null) {
      clearTimeout (this.timeoutid);
    }
    this.mySamples = this.RegisterWSXML(cMsg);
    this.myLoaded(this.mySamples);
  }
}
function RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, key, prop) {
  var fln = fl.split(/[0-9]/)[0];
  //var prop = "";
  var ind = fln.indexOf(itemAPI + '_' + key + '_');
  if (Empty(prop) && (ind >=0) ) {
    prop = fln.substring((itemAPI + '_' + key + '_').length);
  }
  if(!Empty(prop)) {
    if( !( mysamples[key][prop] ) ) {
      mysamples[key][prop] = [];
    }
    mysamples[key][prop].push ( { link:fl, desc:ds });
  }
  else {
    prop = '_undef_'
    if( !( mysamples[key][prop] ) ) {
      mysamples[key][prop] = [];
    }
    mysamples[key][prop].push ( { link:fl, desc:ds });
  }
}
function RegisterToMySamples(itemAPI, fl, ds, as, mysamples) {
  var found = false;
  if (as) {
    var itemObj = this.itemAPI.apiObj;
  	var hiddenObj = this.itemAPI.apiHidden;
    if (itemObj && itemObj.newProperties) { //fld
      var tab, ii, regkey=[];
      for (var i in itemObj.newProperties) {
        tab = itemObj.newProperties[i];
      	for (ii = 0; ii < tab.length; ii++) {
          if((tab[ii].disabled != true && !Empty(tab[ii].name))) {
            if (hiddenObj && hiddenObj.indexOf(tab[ii].propID) >= 0) {
              continue;
            }
            var name = tab[ii].name ? this.translateTabToCheck(tab[ii].name) : undefined;
          	var tabname = this.translateTabToCheck(i);
          	var section = tab[ii].section ? this.translateTabToCheck(tab[ii].section) : undefined;
            var propID = tab[ii].propID ? this.translateTabToCheck(tab[ii].propID) : undefined;
            var _in = (as.indexOf(name)>=0) || (as.indexOf(tabname)>=0) || (as.indexOf(section)>=0) || (as.indexOf(propID)>=0);
            if( _in ) {
              found = true;
              var px;
              if((as.indexOf(name)>=0)) px = name;
              else if((as.indexOf(tabname)>=0)) px = tabname;
              else if((as.indexOf(section)>=0)) px = section;
              else if((as.indexOf(propID)>=0)) px = propID;
              px = Strtran(px,' ', '');
              if ( regkey.indexOf(px) < 0 ) {
                regkey.push(px);
              	this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, 'fld', px);
              }
            }
      		}
      	}
    	}
    }
    if (itemObj && itemObj.functions) { //fnc
      for (var i=0; i<itemObj.functions.length; i++) {
        if( itemObj.generateSignatureObject ) {
          var robj = itemObj.generateSignatureObject(itemObj.functions[i], 'function');
          var name = robj.name;
          if (name.indexOf("(") >= 0)
            	name = name.substring(0, name.indexOf("("));
          	name = this.translateTabToCheck(name);
          	var _in = (as.indexOf(name)>=0);
            if( _in ) {
              found = true;
              this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, 'fnc', name);
            }
      		}
        	else {
          	continue;
        	}
      }
    }
    if (itemObj && itemObj.events) { //evt
      for (var i=0; i<itemObj.events.length; i++) {
        if( itemObj.generateSignatureObject ) {
          var robj = itemObj.generateSignatureObject(itemObj.events[i], 'event');
          var name = robj.name;
          if (name.indexOf("(") >= 0)
            name = name.substring(0, name.indexOf("("));
          name = this.translateTabToCheck(name);
          var _in = (as.indexOf(name)>=0);
          if( _in ) {
            found = true;
            this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, 'evt', name);
          }
      	}
        else {
          continue;
        }
      }
    }
  }
  else {
    var keys = ['fld', 'fnc', 'evt'];
    for( var k=0; !found && k<keys.length; k++ ) {
      var key = keys[k];
      if (fl.indexOf(itemAPI + '_' + key + '_') == 0) {
        found = true;
        this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, key);
      }
    }
  }
  if( !found ) {
    var keys = ['fld', 'fnc', 'evt'];
    for( var k=0; !found && k<keys.length; k++ ) {
      var key = keys[k];
      if (fl.indexOf(itemAPI + '_' + key + '_') == 0) {
        found = true;
        this.RegisterToMySamplesKey(itemAPI, fl, ds, mysamples, key);
      }
    }
    if( !found ) {
      key = 'oth';
      var prop = '_undef_'
      if( !( mysamples[key][prop] ) ) {
        mysamples[key][prop] = [];
      }
      mysamples[key][prop].push ( { link:fl, desc:ds });
    }
  }
}
function RegisterWSXML(xmlstring) {
  //debugger
  var opener = GetOpener();
  var itemAPI = Lower(opener.getRenderApiObjClass().apiType);
  var mysamples = {};
  mysamples.fld = {};
  mysamples.fnc = {};
  mysamples.evt = {};
  mysamples.oth = {};
  var err = false;
  try {
    this.XMLHelpWService.setXMLString(xmlstring);
    this.XMLHelpWService.Query();
     do {
      var fl = this.XMLHelpWService.rs.PTL;
      var ds = this.XMLHelpWService.rs.DESCR;
      var as = this.XMLHelpWService.rs.ARGS;
      if( as ) {
        as = as.split(",");
        for(var i=0; i<as.length; i++) {
          as[i] = this.translateTabToCheck(LRTrim(as[i]));
        }
      }
      this.RegisterToMySamples(itemAPI, fl, ds, as, mysamples);
    } //out while
    while(this.XMLHelpWService.Next())
  }
  catch(e) {
    err = true;
  }
  if (!err && opener.setComponentSamples) {
   opener.setComponentSamples(itemAPI, mysamples);
  }
  return mysamples;
}
function this_Loaded(){
  var opener = GetOpener();
  if( !( opener && opener.getRenderApiObjClass) ) {
    return;
  }
  if(!( opener && opener.tool) ) {
    return;
  }
  this.tool = opener.tool;
  this.itemAPI = opener.getRenderApiObjClass(true);
  var apiType = Lower(this.itemAPI.apiType);
  if (opener.getComponentSamples) {
    this.mySamples = opener.getComponentSamples(apiType);
  }
  if(!this.mySamples || this.mySamples==null) {
    this.SPHelpWService.Parameters(this.wServiceParams + this.tool + '|' + apiType);
    this.SPHelpWService.Link(); //async
    var _this = this;
    this.timeoutid = setTimeout( function(){
      _this.loadtimeout = true;
    	_this.myLoaded();
    }, 2000 );
  }
  else {
    this.myLoaded(this.mySamples);
  }
}
function myLoaded(mysamples){
  var pages = ['Fields','Functions','Events'];
  var opener = GetOpener(); 
  var setSteppable = false;
  var tool = this.tool; 
  if( tool=='pageleteditor' || tool=='portlet' ) {
  	setSteppable = true
  }
  
  var apiType = this.itemAPI.apiType;
  var itemObj = this.itemAPI.apiObj;
  var hiddenObj = this.itemAPI.apiHidden;
  
  if (itemObj && itemObj.newProperties) {
    var tab, ii;
    var dataMatrix = [];
    for (var i in itemObj.newProperties) {
      tab = itemObj.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
          if((tab[ii].disabled != true && !Empty(tab[ii].name))) {
            if (hiddenObj && hiddenObj.indexOf(tab[ii].propID) >= 0) {
              continue;
            }
          var name = tab[ii].name;
          var type = this.setTypeDescription(tab[ii].type);
          var desc = tab[ii].tooltip;
          var tabname = (tab[ii].api_tab ? tab[ii].api_tab : i);
          var section = (tab[ii].api_sect ? tab[ii].api_sect : tab[ii].section);
          var defvalue = tab[ii].defaultValue;
          var defvalueHTML = '';
          var samples = '';
          if ( defvalue == undefined ) {
            defvalue = '( none )';
          }
          else {
            defvalue = defvalue.toString();
            defvalueHTML = '<br><b>Default value:</b> '+ToHTML(defvalue);
          }
          //samples
          var fld = 'fld';
          var ssamples;
          samples += this.getSamplesHTML(tool, mysamples, fld, tab[ii].propID);
          ssamples = this.getSamplesHTML(tool, mysamples, fld, name);
          if ( samples.indexOf(ssamples) < 0 ) {
						samples += ssamples;
          }
         	ssamples = this.getSamplesHTML(tool, mysamples, fld, section);
          if ( samples.indexOf(ssamples) < 0 ) {
						samples += ssamples;
          }
          ssamples = this.getSamplesHTML(tool, mysamples, fld, tabname);
          if ( samples.indexOf(ssamples) < 0 ) {
						samples += ssamples;
          }
          
          //ci provo come tags
          ssamples = this.getSamplesHTMLTag(tool, mysamples, fld, name);
          if ( Empty (ssamples) ) {
            ssamples = this.getSamplesHTMLTag(tool, mysamples, fld, section);
          }
          if ( Empty (ssamples) ) {
            ssamples = this.getSamplesHTMLTag(tool, mysamples, fld, tabname);
          }
          if ( samples.indexOf(ssamples) < 0 ) {
						samples += ssamples;
          }
          if (!Empty(samples)) {
            samples = '<ul>' + samples + '</ul>';
          }
            
          var steppable = tab[ii].steppable;
          if(steppable == undefined) {
            steppable = false;
          }
          if(steppable == true) {
            name = name + "*";
          }
          var rec = [];
          rec.push(this.setMyValue(name));
          rec.push(this.setMyValue(this.translateTabToWrite(tabname)));
          rec.push(this.setMyValue(section));
          rec.push(this.setMyValue(type, false)+defvalueHTML);
          rec.push(this.setMyValue(desc, false));
          rec.push(this.setMyValue(samples));
          dataMatrix.push(rec);
        }
      }
    }
    this.StaticDataProviderItemsObj.FillData(dataMatrix);
    if( !setSteppable ) {
      this.LabelInfoFld.Hide();
    }
  }
  else {
    this.LabelInfoFld.Hide();
    this.HidePage(pages, 'Events');
  }
  
  this.loadFunctionsEvents(itemObj, 'functions', 'Functions', this.StaticDataProviderItemsFunc, false, pages, mysamples, tool);
  this.loadFunctionsEvents(itemObj, 'events', 'Events', this.StaticDataProviderItemsEvt, true, pages, mysamples, tool);
  
  this.enableOtherSamples(mysamples);
}
  
function enableOtherSamples(mysamples) {
  if(mysamples == null) {
    return;
  }
  if(mysamples.oth && mysamples.oth._undef_) {
    this.LabelOtherFld.Show();
    this.LabelOtherFnc.Show();
    this.LabelOtherEvt.Show();
    return;
  }
  var keys = ['fld','fnc','evt'];
  for (var j=0; j<keys.length; j++) {
    var key = keys[j];
    for(var o in mysamples[key]) {
      var s = mysamples[key][o];
        for (var i=0; i<s.length; i++) {
          if( !s[i].found ) {
            this.LabelOtherFld.Show();
    				this.LabelOtherFnc.Show();
    					this.LabelOtherEvt.Show();
            i = s.length;
            j = keys.length;
        }
      }
  	}
  }
  
}
function getSamplesHTMLTag(tool, mysamples, keytab, stringToTag) {
  var samples = "";
  if (stringToTag == undefined)
    return samples;
  if( mysamples && mysamples[keytab] ) {
    var tsplists = Strtran(stringToTag, "_", " ").split(" ");
    var keys = Object.keys(mysamples[keytab]);
    var found = false;
    for( var n=0; !found && n<keys.length; n++) {
      for ( var k=0; !found && k<tsplists.length; k++) {
        var ts = Lower(tsplists[k]);
        if ( ts.length >= 3 && keys[n].indexOf(ts) >=0 ) {
          found = true;
          samples += this.getSamplesHTML(tool, mysamples, keytab, keys[n]);
        }
      }
    }
  }
  return samples;
}
function getSamplesHTMLLink(tool, s, key) {
  var samples = '<li>';
  var link = '';
  var fileid = s.link;
  var ext = '';
  var toolurl = '';
  if (tool == 'portlet') {
    ext = '_portlet.jsp';
    toolurl = '/visualweb/editor.jsp?autopreview=true&id=';
  }
  else if (tool == 'pageleteditor') {
    ext = '.jsp';
    toolurl = '/pageleteditor/pagelet_editor.jsp?&autopreview=true&name=';
  }
  else if (tool == 'report') {
    ext = '.vrp';
    toolurl = '/reporteditor/index.jsp?autopreview=true&id=';
  }
  else if (tool == 'chart') {
    ext = '.chartdef';
    toolurl = '/chart/index.jsp?autopreview=true&filename=';
  }
  else if (tool == 'module') {
    ext = '.mrp';
    toolurl = '/moduleeditor/moduleeditor.jsp?autopreview=true&id=';
  }
  else if (tool == 'maskparameters') {
    ext = '.vdm';
    toolurl = '/maskparameters/maskparameters.jsp?autopreview=true&filename=';
  }
  if(!Empty(ext)) {
    var pos = fileid.indexOf(ext);
    if ( pos >= 0 ) {
      fileid = fileid.substring(0, pos);
    }
  }
  link = this.appSamplesUrl + toolurl + fileid;
  
  if ( key ) {
    s.found = true;
    if ( key != s.desc ) {
      samples += '<a target="_blank" href="' + link + '"> [' + key + '] ' + s.desc + '</a>';
    }
    else {
      samples += '<a target="_blank" href="' + link + '">' + s.desc + '</a>';
    }
  }
  else {
    if ( s.link != s.desc ) {
      samples += '<a target="_blank" href="' + link + '"> [' + s.link + '] ' + s.desc + '</a>';
    }
    else {
      samples += '<a target="_blank" href="' + link + '">' + s.desc + '</a>';
    }
  }
  samples += '</li>';
  return samples;
}
  
function getSamplesHTML(tool, mysamples, keytab, key) {
  var samples = "";
  if (key == undefined)
    return samples;
  key = this.translateTabToCheck(key);
  if( mysamples && mysamples[keytab] && mysamples[keytab][key]) {
    for (var n=0; n<mysamples[keytab][key].length; n++) {
      var s = mysamples[keytab][key][n];
      samples += this.getSamplesHTMLLink(tool, s, key);
    }
  }
  return samples;
}
function loadFunctionsEvents(itemObj, itemObjKey, PageKey, dataProvider, asEvt, pages, mysamples, tool) {
  if (itemObj && itemObj[itemObjKey] && (itemObj[itemObjKey].length > 0)) {
    var dataMatrix = [];
    for(var i=0; i<itemObj[itemObjKey].length; i++) {
      var ff = itemObj[itemObjKey][i];
      var name = '';
      var sign = '';
      var desc = '';
      var ashtml = false;
      var samples = '';
      if( itemObj.generateSignatureObject ) {
        var robj = itemObj.generateSignatureObject(ff, asEvt ? 'event' : 'function');
        name = robj.name;
        sign = robj.signature;
        desc = robj.tooltip;
      }
      var rec = [];
      if(!Empty(name)) {
        name = name.split('(')[0];
        rec.push(this.setMyValue(name));
        var samplekey = 'fnc';
        if(asEvt == true) {
          sign = 'function [ObjectName]_' + sign;
          samplekey = 'evt';
        }
        if(sign.indexOf('(') < 0) {
          sign = sign + '()';
        }
        samples = this.getSamplesHTML(tool, mysamples, samplekey, name);
        //ci provo come tags
        var ssamples = this.getSamplesHTMLTag(tool, mysamples, samplekey, name);
        if ( samples.indexOf(ssamples) < 0 ) {
          samples += ssamples;
        }
        if (!Empty(samples)) {
          samples = '<ul>' + samples + '</ul>';
        }
        rec.push(this.setMyValue(sign));
        rec.push(this.setMyValue(desc, ashtml));
        rec.push(this.setMyValue(samples));
        dataMatrix.push(rec);
      }
    }
    dataProvider.FillData(dataMatrix);
  }
  else {
    this.HidePage(pages, PageKey);
  }
}
function HidePage(mypageskey, pagekey) {
  var index = mypageskey.indexOf(pagekey);
  if(index >= 0) {
    index = index + 1;
    this.ZtTabs.Hide(index,true);
  }
}
function initialCap(txt) {
  if( txt.substr )
    return txt.substr(0, 1).toUpperCase() + txt.substr(1);
  else return ""
}
function setMyValue(value, ashtml) {
  if(Empty(value)) {
    return '';
  }
  if(ashtml == undefined) {
    ashtml = false;
  }
  if(ashtml == true) {
  	return ToHTML(this.initialCap(value));
  }
  else {
    return this.initialCap(value);
  }
}
function setTypeDescription(type) {
  if(Empty(type))
    return '';
  if ( type == 'str' )
    return 'string';
  if ( type == 'int' )
    return 'numeric';
  if (type == 'checkbox' )
    return 'logic';
  if( type.indexOf('select[') == 0 ) {
    var ret = 'selection values<br><ul>';
    type = Strtran(type, 'select[', '');
    type = Strtran(type, ']', '');
    var types = type.split(',');
    for(var i=0; i<types.length; i++) {
      var t = types[i];
      if(Empty(t)) {
        t = '(none)';
      }
      if( t.indexOf(':') >= 0) {
        var tt = t.split(':')
        t = tt[0] + ' ( ' + tt[1] + ' )';
      }
      ret = ret + '<li>' + t + '</li>';
    }
    ret = ret + '</ul>'
    return ret;
  }
  return type;
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPAPIDetails_container .oddrow{  background-color: #F3F3F3;
}
.SPAPIDetails_container .hoverrow{
  background-color: transparent;
}
.SPAPIDetails_container .mgrid{
      padding: 10px;
      border-bottom: 0px;
}
.SPAPIDetails_container .grid .mgrid td{
      padding: 10px;
      border-bottom: 0px;
}
.SPAPIDetails_container .grid .mgridbline td{
  padding: 5px;
}
.SPAPIDetails_container .csslink{
  cursor: pointer;
  color: #0000EE;
  text-decoration: underline;
}
.SPAPIDetails_container ul{
  margin: 5px;
}
.SPAPIDetails_container .labellink{
  cursor: pointer;
  text-decoration: underline;
}
.SPAPIDetails_container blockquote{
  margin-block-start: 2px;
  margin-block-end: 2px;
}
.SPAPIDetails_container {
}
.SPAPIDetails_title_container {
  margin: auto;
}
.SPAPIDetails_portlet{
  position:relative;
  margin: auto;
  min-width:800px;
  height:500px;
}
.SPAPIDetails_portlet[Data-page="1"]{
  height:500px;
  width:100%;
}
.SPAPIDetails_portlet[Data-page="2"]{
  height:500px;
  width:100%;
}
.SPAPIDetails_portlet[Data-page="3"]{
  height:500px;
  width:100%;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .GridA_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:38px;
  left:10px;
  right:10px;
  right:1.25%;
  width:auto;
  height:auto;
  min-height:457px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .GridE_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:39px;
  left:10px;
  right:10px;
  right:1.25%;
  width:auto;
  height:auto;
  min-height:457px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .GridF_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:39px;
  left:10px;
  right:10px;
  right:1.25%;
  width:auto;
  height:auto;
  min-height:457px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoFld_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:10px;
  right:303px;
  right:37.875%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoFld_ctrl {
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoFld_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoFunc_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:10px;
  right:324px;
  right:40.5%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoFunc_ctrl {
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoFunc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoEvt_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:10px;
  right:264px;
  right:33.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoEvt_ctrl {
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelInfoEvt_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFld_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:641px;
  right:10px;
  right:1.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFld_ctrl a {
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFld_ctrl a {
  overflow:hidden;
  text-align:right;
 display:block;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFld_ctrl > div > a:hover{
  text-align:right;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFnc_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:641px;
  right:10px;
  right:1.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFnc_ctrl a {
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFnc_ctrl a {
  overflow:hidden;
  text-align:right;
 display:block;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherFnc_ctrl > div > a:hover{
  text-align:right;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherEvt_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:18px;
  left:638px;
  right:10px;
  right:1.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherEvt_ctrl a {
  height:auto;
  min-height:20px;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherEvt_ctrl a {
  overflow:hidden;
  text-align:right;
 display:block;
}
.SPAPIDetails_portlet > .SPAPIDetails_page > .LabelOtherEvt_ctrl > div > a:hover{
  text-align:right;
}
<%}else if(sp.getParameter("SpWireframe","").equals("true")){
String containerId=sp.getParameter("containerID",idPortlet);
Library.SetMimeType(response,"text/html");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
PrintWireFrame(containerId,out);
%>
<%!
void PrintWireFrame(String containerId, java.io.Writer out) throws java.lang.Throwable {
 String def="[{\"h\":\"500,500,500\",\"layout_steps_values\":{},\"pages_names\":\"Fields,Functions,Events\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%,100%,100%\",\"wizard\":\"false\"},{\"anchor\":\"top-left-right(%)\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Name\"},{\"title\":\"Tab\"},{\"title\":\"Section\"},{\"title\":\"Type\"},{\"title\":\"Description\"},{\"title\":\"Samples\"}],\"h\":\"457\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"250\",\"type\":\"Grid\",\"w\":\"780\",\"x\":\"10\",\"y\":\"38\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right(%)\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Name\"},{\"title\":\"Signature\"},{\"title\":\"Description\"},{\"title\":\"Samples\"}],\"h\":\"457\",\"layout_steps_values\":{},\"page\":\"3\",\"rows\":\"250\",\"type\":\"Grid\",\"w\":\"780\",\"x\":\"10\",\"y\":\"39\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right(%)\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Name\"},{\"title\":\"Signature\"},{\"title\":\"Description\"},{\"title\":\"Samples\"}],\"h\":\"457\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"250\",\"type\":\"Grid\",\"w\":\"780\",\"x\":\"10\",\"y\":\"39\",\"zindex\":\"2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"204\",\"x\":\"813\",\"y\":\"20\"},{\"h\":\"26\",\"page\":\"3\",\"type\":\"StaticDataProvider\",\"w\":\"204\",\"x\":\"810\",\"y\":\"20\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"204\",\"x\":\"810\",\"y\":\"20\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"* steppable field\",\"w\":\"487\",\"x\":\"10\",\"y\":\"18\",\"zindex\":\"5\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Function parameters describe between # (#parameter#) are optional\",\"w\":\"466\",\"x\":\"10\",\"y\":\"18\",\"zindex\":\"5\"},{\"align\":\"left\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"[ObjectName] will be replace in the Event Signature with the component name\",\"w\":\"526\",\"x\":\"10\",\"y\":\"18\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Other samples\",\"w\":\"149\",\"x\":\"641\",\"y\":\"18\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Other samples\",\"w\":\"149\",\"x\":\"641\",\"y\":\"18\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"top-left-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"Other samples\",\"w\":\"152\",\"x\":\"638\",\"y\":\"18\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"204\",\"x\":\"814\",\"y\":\"44\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"204\",\"x\":\"814\",\"y\":\"92\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"XMLDataobj\",\"w\":\"204\",\"x\":\"814\",\"y\":\"68\"}]";
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("stdFunctions.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("portalstudio/renderDef.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("visualweb/itemsObj.js")+"'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../visualweb/itemsObj.css'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../portalstudio/renderDef.css'></script>\n");
 out.write("<div id="+JSPLib.ToHTMLValue(containerId)+"></div>\n");
 out.write("<script> /*JS_MARKER_START*/\n");
 out.write("new renderDef({\n");
 out.write("def: "+def+",\n");
 out.write("container: '"+JSPLib.ToJSValue(containerId)+"',\n");
 out.write("replaceContainer: true\n");
 out.write("})\n");
 out.write("/*JS_MARKER_END*/ </script>\n");
}/**/%>
<%}else{
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPAPIDetails","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPAPIDetails_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<% sp.WritePortalStudioCSS(request, out); 
if(Library.IsMobile(request)){%><%}%>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPAPIDetails','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPAPIDetails_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("SPAPIDetails_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
String LabelInfoFld= " * steppable field";
String LabelInfoFunc= "Function parameters describe between # (#parameter#) are optional";
String LabelInfoEvt= "[ObjectName] will be replace in the Event Signature with the component name";
String LabelOtherFld= "Other samples";
String LabelOtherFnc= "Other samples";
String LabelOtherEvt= "Other samples";
if(request.getAttribute("SPAPIDetails_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPAPIDetails_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPAPIDetails_portlet blockquote'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPAPIDetails','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPAPIDetails_page' style='display:block'>
<div id='<%=idPortlet%>_GridA' formid='<%=idPortlet%>' ps-name='GridA'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_LabelInfoFld'  formid='<%=idPortlet%>' ps-name='LabelInfoFld'    class='label LabelInfoFld_ctrl'><div id='<%=idPortlet%>_LabelInfoFldtbl' style='width:100%;'><%=JSPLib.ToHTML(" * steppable field")%></div></span>
<span id='<%=idPortlet%>_LabelOtherFld'  formid='<%=idPortlet%>' ps-name='LabelOtherFld'    class='label labellink LabelOtherFld_ctrl'><div id='<%=idPortlet%>_LabelOtherFldtbl' style='width:100%;'><a id='<%=idPortlet%>_LabelOtherFldhref' title='<%=JSPLib.ToHTML("Other samples")%>' href='#'  ><%=JSPLib.ToHTML("Other samples")%></a></div></span>
</div>
<div id='<%=idPortlet%>_page_2' class='SPAPIDetails_page' style='display:none'>
<div id='<%=idPortlet%>_GridF' formid='<%=idPortlet%>' ps-name='GridF'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_LabelInfoFunc'  formid='<%=idPortlet%>' ps-name='LabelInfoFunc'    class='label LabelInfoFunc_ctrl'><div id='<%=idPortlet%>_LabelInfoFunctbl' style='width:100%;'><%=JSPLib.ToHTML("Function parameters describe between # (#parameter#) are optional")%></div></span>
<span id='<%=idPortlet%>_LabelOtherFnc'  formid='<%=idPortlet%>' ps-name='LabelOtherFnc'    class='label labellink LabelOtherFnc_ctrl'><div id='<%=idPortlet%>_LabelOtherFnctbl' style='width:100%;'><a id='<%=idPortlet%>_LabelOtherFnchref' title='<%=JSPLib.ToHTML("Other samples")%>' href='#'  ><%=JSPLib.ToHTML("Other samples")%></a></div></span>
</div>
<div id='<%=idPortlet%>_page_3' class='SPAPIDetails_page' style='display:none'>
<div id='<%=idPortlet%>_GridE' formid='<%=idPortlet%>' ps-name='GridE'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_LabelInfoEvt'  formid='<%=idPortlet%>' ps-name='LabelInfoEvt'    class='label LabelInfoEvt_ctrl'><div id='<%=idPortlet%>_LabelInfoEvttbl' style='width:100%;'><%=JSPLib.ToHTML("[ObjectName] will be replace in the Event Signature with the component name")%></div></span>
<span id='<%=idPortlet%>_LabelOtherEvt'  formid='<%=idPortlet%>' ps-name='LabelOtherEvt'    class='label labellink LabelOtherEvt_ctrl'><div id='<%=idPortlet%>_LabelOtherEvttbl' style='width:100%;'><a id='<%=idPortlet%>_LabelOtherEvthref' title='<%=JSPLib.ToHTML("Other samples")%>' href='#'  ><%=JSPLib.ToHTML("Other samples")%></a></div></span>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPAPIDetails');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPAPIDetails_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Fields"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Functions"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page3', element:'<%=idPortlet%>_page_3',caption:'<%=JSPLib.ToJSValue(sp.translate("Events"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPAPIDetails',["800","800","800"],["500","500","500"],'blockquote',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,3,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"500","title":"Fields","layer":""},{"layout_steps_values":{},"w":"800","h":"500","title":"Functions","layer":""},{"layout_steps_values":{},"w":"800","h":"500","title":"Events","layer":""}]);
this.GridA=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right(%)","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row mgrid","class_row_odd":"grid_rowodd mgrid","class_row_over":"hoverrow","class_row_selected":"hoverrow","class_table":"grid","class_title":"grid_cell_title mgridbline","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridA","dataobj":"StaticDataProviderItemsObj","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":457,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"GridA","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"#ECECEC","row_color_odd":"#FFFFFF","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"#ECECEC","type":"Grid","valign":"top","w":780,"x":10,"y":38,"zindex":"2"});
this.GridA.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":250,"colProperties":[{"font_weight":"bold","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Name","align":"","type":"C","ColSpan":"","layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Name","droppable_name":"","fg_color":"","width":"","RowSpan":"","font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tab","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Tab","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Section","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Section","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Type","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Type","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Description","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Description","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":false,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"Samples","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","show_extra_title":false,"enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Samples","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.GridE=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right(%)","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row mgrid","class_row_odd":"grid_rowodd mgrid","class_row_over":"hoverrow","class_row_selected":"hoverrow","class_table":"grid","class_title":"grid_cell_title mgridbline","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridE","dataobj":"StaticDataProviderItemsEvt","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":457,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"GridE","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":3,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"#ECECEC","row_color_odd":"#FFFFFF","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"#ECECEC","type":"Grid","valign":"top","w":780,"x":10,"y":39,"zindex":"2"});
this.GridE.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":250,"colProperties":[{"font_weight":"bold","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Name","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Name","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Signature","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Signature","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Description","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Description","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Samples","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Samples","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.GridF=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right(%)","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row mgrid","class_row_odd":"grid_rowodd mgrid","class_row_over":"hoverrow","class_row_selected":"hoverrow","class_table":"grid","class_title":"grid_cell_title mgridbline","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_GridF","dataobj":"StaticDataProviderItemsFunc","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":457,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"GridF","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"#ECECEC","row_color_odd":"#FFFFFF","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"#ECECEC","type":"Grid","valign":"top","w":780,"x":10,"y":39,"zindex":"2"});
this.GridF.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":250,"colProperties":[{"font_weight":"bold","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Name","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Name","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Signature","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Signature","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Description","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Description","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Samples","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Samples","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.StaticDataProviderItemsObj=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProviderItemsObj","dataproviders":"","fieldsString":"Name,Tab,Section,Type,Description,Samples","fieldstypeString":"C,C,C,C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProviderItemsObj","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":204,"x":813,"y":20});
this.StaticDataProviderItemsEvt=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProviderItemsEvt","dataproviders":"","fieldsString":"Name,Signature,Description,Samples","fieldstypeString":"C,C,C,C","h":26,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProviderItemsEvt","page":3,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":204,"x":810,"y":20});
this.StaticDataProviderItemsFunc=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataProviderItemsFunc","dataproviders":"","fieldsString":"Name,Signature,Description,Samples","fieldstypeString":"C,C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataProviderItemsFunc","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":204,"x":810,"y":20});
this.LabelInfoFld=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelInfoFld","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelInfoFld","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelInfoFld,false,true)%>","type":"Label","w":487,"x":10,"y":18,"zindex":"5"});
this.LabelInfoFunc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelInfoFunc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelInfoFunc","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelInfoFunc,false,true)%>","type":"Label","w":466,"x":10,"y":18,"zindex":"5"});
this.LabelInfoEvt=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelInfoEvt","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelInfoEvt","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelInfoEvt,false,true)%>","type":"Label","w":526,"x":10,"y":18,"zindex":"5"});
this.LabelOtherFld=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label labellink","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelOtherFld","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelOtherFld","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelOtherFld,false,true)%>","type":"Label","w":149,"x":641,"y":18,"zindex":"5"});
this.LabelOtherFnc=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label labellink","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelOtherFnc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelOtherFnc","nowrap":"false","page":2,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelOtherFnc,false,true)%>","type":"Label","w":149,"x":641,"y":18,"zindex":"5"});
this.LabelOtherEvt=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label labellink","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelOtherEvt","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"#","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelOtherEvt","nowrap":"false","page":3,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelOtherEvt,false,true)%>","type":"Label","w":152,"x":638,"y":18,"zindex":"5"});
this.SPHelpWService=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_SPHelpWService","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPHelpWService","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spgetapihelpws","target":"","type":"SPLinker","w":204,"x":814,"y":44});
this.SPHelpWService.m_cID='<%=JSPLib.cmdHash("routine,spgetapihelpws",request.getSession())%>';
this.SPApiGetUrl=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPApiGetUrl","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPApiGetUrl","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spgetapihelpurl","target":"","type":"SPLinker","w":204,"x":814,"y":92});
this.SPApiGetUrl.m_cID='<%=JSPLib.cmdHash("routine,spgetapihelpurl",request.getSession())%>';
this.XMLHelpWService=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":false,"auto_exec":"false","ctrlid":"<%=idPortlet%>_XMLHelpWService","field":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"n_records":"","name":"XMLHelpWService","page":1,"parms":"","parms_source":"","root":"\u002fRECORDS\u002fRECORD","source":"","type":"XMLDataobj","w":204,"x":814,"xmldataobj":"","y":68});
<%if(!Library.Empty(PageletId) ){%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
<%}%>

}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPAPIDetails_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPAPIDetails_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPAPIDetails_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPAPIDetails',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPAPIDetails');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{
}%>
<%if(!included){%>
</html>
<%}
sp.endPage("SPAPIDetails");
}%>
<%! public String getJSPUID() { return "39552915"; } %>