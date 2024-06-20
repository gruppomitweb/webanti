<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  var macroType = getZFChartMacroType(this.type.Value()),\n      font = { name : \"Open Sans\", size : 11, style : \"normal\", weight : \"normal\" },\n      fontb = { name : \"Open Sans\", size : 11, style : \"normal\", weight : \"bold\" },\n      w,\n      h,\n      icon,\n      ifr,\n      tabs = document.getElementById(this.formid + \"_tabcontainer\"),\n      _this = this;\n\tif (this.isMarker.Value()) {\n    this.ZtTabs.Select(\"page7\");\n    this._DrawPage7();\n    w = this._GetOffsetWidthPage7(font);\n    h = this._GetOffsetHeightPage7(font);\n    this._ResizeCtrlsPage7(font, w);\n  }\n  else {\n    switch (macroType) {\n      case \"xyz\":\n        this.ZtTabs.Select(\"page2\");\n        this._DrawPage2();\n        w = this._GetOffsetWidthPage2(font);\n        h = this._GetOffsetHeightPage2(font);\n        this._ResizeCtrlsPage2(font, w);\n        break;\n      case \"geo\":\n        this.ZtTabs.Select(\"page3\");\n        this._DrawPage3();\n        w = this._GetOffsetWidthPage3(font);\n        h = this._GetOffsetHeightPage3(font);\n        this._ResizeCtrlsPage3(font, w);\n        break;\n      case \"hie\":\n        this.ZtTabs.Select(\"page4\");\n        this._DrawPage4();\n        w = this._GetOffsetWidthPage4(font);\n        h = this._GetOffsetHeightPage4(font);\n        this._ResizeCtrlsPage4(font, w);\n        break;\n      case \"dep\":\n        this.ZtTabs.Select(\"page5\");\n        this._DrawPage5();\n        w = this._GetOffsetWidthPage5(font);\n        h = this._GetOffsetHeightPage5(font);\n        this._ResizeCtrlsPage5(font, w);\n        break;\n      case \"classif\":\n        this.ZtTabs.Select(\"page6\");\n        this._DrawPage6();\n        w = this._GetOffsetWidthPage6(font);\n        h = this._GetOffsetHeightPage6(font);\n        this._ResizeCtrlsPage6(font, w);\n        break;\n      default:\t\u002f\u002f category\n        this.ZtTabs.Select(\"page1\");\n        this._DrawPage1();\n        w = this._GetOffsetWidthPage1(fontb);\n        h = this._GetOffsetHeightPage1(fontb);\n        this._ResizeCtrlsPage1(fontb, w);\n        break;\n    }\n  }\n\n \tif (tabs)\n  \ttabs.style.display = \"none\";\n  \n  if (window.parent && window.parent.document.getElementById(this.id.Value() + \"tooltipI\")) {\n    ifr = window.parent.document.getElementById(this.id.Value() + \"tooltipI\");\n    ifr.contentDocument.body.style.overflow = \"hidden\";\n  }\n  \n  this.Ctrl.style.width = w + \"px\";\n  this.Ctrl.style.minWidth = w + \"px\";\n  this.Ctrl.style.height = h + \"px\";\n\n  var color = this.color.Value().indexOf(\"rgb\") \u003e= 0 ? this.color.Value() : \"#\" + this.color.Value();\n  \u002f\u002fthis.Ctrl.style.backgroundColor = toRgbA(color);\n  this.Ctrl.style.border = \"solid 1px \" + color;\n  this.Ctrl.style.borderRadius = \"5px\";\n  this.Ctrl.style.padding = \"5px\";\n  \n  this.Ctrl_container.style.width = w + \"px\";\n  this.Ctrl_container.style.height = h + \"px\";\n  this.Ctrl_container.style.borderRadius = \"5px\";\n\n  var span = this.GetSpan();\n  span.parentNode.removeChild(span);\n\n  setTimeout(function () {   \n    if (window.parent && window.parent.document.getElementById(_this.id.Value() + \"tooltipDiv\")) {\n      ifr = window.parent.document.getElementById(_this.id.Value() + \"tooltipDiv\");\n      ifr.style.width = w + \"px\";\n      ifr.style.height = h + \"px\";\n      var \u002f\u002fpwidth = parseInt(ifr.getAttribute(\"par-width\")),\n         \tpleft = parseInt(ifr.getAttribute(\"par-left\")),\n          cur_left = pleft + ifr.offsetLeft,\n      \t\tmaxw = window.parent.visualViewport.width;\n     \tif ((cur_left + w) \u003e (maxw - 1)) {\t\u002f\u002f sposto il tooltip per limite margine destro\n      \tifr.style.left = (maxw - 1 - w - pleft) + \"px\";\n      }\n    }\n  }, 100);\n}\n\n\u002f**** PAGINA 1 ****\u002f\nfunction _DrawPage1() {\n\t\u002f\u002fthis.labelkey.Value(this.key.Value());\n  this.labelcategory.Value(this.category.Value());\n  this.labelserie.Value(this.serie.Value());\n  this.labelvalue.Value(this.value.Value());\n  this.labelrange.Value(this.range.Value());\n  this.labelmultikeyvalue.Value(this.multikeyvalue.Value());\n  \u002f\u002fthis.labelmultikey.Value(this.multikey.Value());\n  this.icon.Hide();\n  \n}\n\nfunction _GetOffsetHeightPage1(font) {\n  var h = 0;\n  h += this.GetOffsetHeight(this.labelkey.Value(), font);\n  h += this.GetOffsetHeight(this.labelcategory.Value(), font);\n  h += this.GetOffsetHeight(this.labelserie.Value(), font);\n  h += this.GetOffsetHeight(this.labelvalue.Value(), font);\n  h += this.GetOffsetHeight(this.labelrange.Value(), font);\n  h += this.GetOffsetHeight(this.labelmultikeyvalue.Value(), font);\n  if (Empty(this.labelcategory.Value()) || Empty(this.labelserie.Value()) || Empty(this.labelvalue.Value() + \"\"))\n    h = h + 10;\n  \n  return h + 3*5;\n}\n\nfunction _GetOffsetWidthPage1(font) {\n  var w = 0,\n      xIni = 5,\t\u002f\u002f offset tra una stringa e l'altra\n  \t\tcw = !Empty(this.cseries.Value()) ? (this.icon.controlwidth + xIni) : 0;\n  w = Math.max(w, this.GetOffsetWidth(this.labelcategory.Value(), font) + 2 * xIni + cw);\n  w = Math.max(w, this.GetOffsetWidth(this.labelkey.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelserie.Value(), font) + this.GetOffsetWidth(this.labelvalue.Value(), font) + 3 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelrange.Value(), font) + 2 * xIni);\n  \u002f\u002fw = Math.max(w, this.GetOffsetWidth(this.labelmultikey.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelmultikeyvalue.Value(), font) + 2 * xIni);\n  w += 2 * xIni;\n  return w;\n}\n\nfunction _ResizeCtrlsPage1(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labelcategory.Ctrl.style.width = this.GetOffsetWidth(this.labelcategory.Value(), font) + \"px\";\n  if (!Empty(this.cseries.Value())) {\n  \tthis.icon.Show();\n    this.icon.Ctrl.style.left = (width - xIni) + \"px\";\n  \tthis.icon.Ctrl.style.color = \"#\" + this.cseries.Value();\n  }\n  this.labelkey.Ctrl.style.width = this.GetOffsetWidth(this.labelkey.Value(), font) + \"px\";\n  this.labelserie.Ctrl.style.width = this.GetOffsetWidth(this.labelserie.Value(), font) + \"px\";\n  this.labelvalue.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelserie.Value(), font) + 2 * xIni) + \"px\";\n  this.labelvalue.Ctrl.style.width = this.GetOffsetWidth(this.labelvalue.Value(), font) + \"px\";\n  this.labelrange.Ctrl.style.width = this.GetOffsetWidth(this.labelrange.Value(), font) + \"px\";\n  \u002f\u002fthis.labelmultikey.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikey.Value(), font) + \"px\";\n  this.labelmultikeyvalue.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikeyvalue.Value(), font) + \"px\";\n  \n  \u002f\u002f adeguamenti y\n  var upd = false;\n  if (Empty(this.labelcategory.Value())) {\n    this.labelkey.Ctrl.style.top = (this.labelkey.y - this.labelcategory.h) + \"px\";\n    this.labelserie.Ctrl.style.top = (this.labelserie.y - this.labelcategory.h) + \"px\";\n    this.labelvalue.Ctrl.style.top = (this.labelvalue.y - this.labelcategory.h) + \"px\";\n    this.labelrange.Ctrl.style.top = (this.labelrange.y - this.labelcategory.h) + \"px\";\n    this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.y - this.labelcategory.h) + \"px\";\n    upd = true;\n  }\n \tif (Empty(this.labelkey.Value())) {\n    if (upd) {\n      this.labelserie.Ctrl.style.top = (this.labelserie.Ctrl.offsetTop - this.labelkey.h) + \"px\";\n      this.labelvalue.Ctrl.style.top = (this.labelvalue.Ctrl.offsetTop - this.labelkey.h) + \"px\";\n      this.labelrange.Ctrl.style.top = (this.labelrange.Ctrl.offsetTop - this.labelkey.h) + \"px\";\n      this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.Ctrl.offsetTop - this.labelkey.h) + \"px\";\n    }\n    else {\n      this.labelserie.Ctrl.style.top = (this.labelserie.y - this.labelkey.h) + \"px\";\n      this.labelvalue.Ctrl.style.top = (this.labelvalue.y - this.labelkey.h) + \"px\";\n      this.labelrange.Ctrl.style.top = (this.labelrange.y - this.labelkey.h) + \"px\";\n      this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.y - this.labelkey.h) + \"px\";\n      upd = true;\n    }\n  }\n  if (Empty(this.labelrange.Value())) {\n \t\tif (upd)\n      this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.Ctrl.offsetTop - this.labelrange.h) + \"px\";\n    else\n    \tthis.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.y - this.labelrange.h) + \"px\";\n  }\n}\n\n\u002f**** PAGINA 2 ****\u002f\nfunction _DrawPage2() {\n  this.labelkeyxyz.Value(this.key.Value());\n  this.labelseriexyz.Value(this.serie.Value());\n  this.labelvaluez.Value(this.z.Value());\n  var value = \"x\";\n  if (!Empty(this.xlabel.Value()))\n    value = this.xlabel.Value();\n \tvalue += \": \";\n  value += this.x.Value();\n  this.labelvaluex.Value(value);\n  value = \"y\";\n  if (!Empty(this.ylabel.Value()))\n    value = this.ylabel.Value();\n \tvalue += \": \";\n  value += this.y.Value();\n  this.labelvaluey.Value(value);\n  this.labelrangexyz.Value(this.range.Value());\n  this.labelmultikeyxyz.Value(this.multikey.Value());\n  this.iconxyz.Hide();\n}\n\nfunction _GetOffsetHeightPage2(font) {\n  var h = 0;\n  h += this.GetOffsetHeight(this.labelkeyxyz.Value(), font);\n  h += this.GetOffsetHeight(this.labelseriexyz.Value(), font);\n  h += this.GetOffsetHeight(this.labelvaluex.Value(), font);\n  h += this.GetOffsetHeight(this.labelvaluey.Value(), font);\n  h += (this.GetOffsetHeight(this.labelvaluez.Value(), font) || this.GetOffsetHeight(\"w\", font));\n  h += this.GetOffsetHeight(this.labelrangexyz.Value(), font);\n  h += this.GetOffsetHeight(this.labelmultikeyxyz.Value(), font);\n  return h;\n}\n\nfunction _GetOffsetWidthPage2(font) {\n  var w = 0,\n      xIni = 5,\t\u002f\u002f offset tra una stringa e l'altra\n  \t\tcw = !Empty(this.cseries.Value()) ? (this.iconxyz.controlwidth + xIni) : 0;\n  w = Math.max(w, this.GetOffsetWidth(this.labelseriexyz.Value(), font) + this.GetOffsetWidth(this.labelvaluez.Value(), font) + cw + 5 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelkeyxyz.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelvaluex.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelvaluey.Value(), font) + 2 * xIni);  \n  w = Math.max(w, this.GetOffsetWidth(this.labelrangexyz.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelmultikeyxyz.Value(), font) + 2 * xIni);\n  w += 2 * xIni;\n  return w;\n}\n\nfunction _ResizeCtrlsPage2(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labelseriexyz.Ctrl.style.width = this.GetOffsetWidth(this.labelseriexyz.Value(), font) + \"px\";\n  if (!Empty(this.cseries.Value())) {\n  \tthis.iconxyz.Show();\n    this.iconxyz.Ctrl.style.left = (width - xIni) + \"px\";\n  \tthis.iconxyz.Ctrl.style.color = \"#\" + this.cseries.Value();\n  }\n  this.labelkeyxyz.Ctrl.style.width = this.GetOffsetWidth(this.labelkeyxyz.Value(), font) + \"px\";\n  this.labelvaluez.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelseriexyz.Value(), font) + 2 * xIni) + \"px\";\n  this.labelvaluez.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluez.Value(), font) + \"px\";\n  this.labelvaluex.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluex.Value(), font) + \"px\";\n  this.labelvaluey.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluey.Value(), font) + \"px\";\n  this.labelrangexyz.Ctrl.style.width = this.GetOffsetWidth(this.labelrangexyz.Value(), font) + \"px\";\n  this.labelmultikeyxyz.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikeyxyz.Value(), font) + \"px\";\n  \n  \u002f\u002f adeguamenti y\n \tif (Empty(this.labelkeyxyz.Value())) {\n    this.labelvaluex.Ctrl.style.top = (this.labelvaluex.y - this.labelkeyxyz.h) + \"px\";\n    this.labelvaluey.Ctrl.style.top = (this.labelvaluey.y - this.labelkeyxyz.h) + \"px\";\n    this.labelrangexyz.Ctrl.style.top = (this.labelrangexyz.y - this.labelkeyxyz.h) + \"px\";\n    this.labelmultikeyxyz.Ctrl.style.top = (this.labelmultikeyxyz.y - this.labelkeyxyz.h) + \"px\";\n  }\n  if (Empty(this.labelrangexyz.Value()))\n \t this.labelmultikeyxyz.Ctrl.style.top = (this.labelmultikeyxyz.y - this.labelrangexyz.h) + \"px\";\n}\n\n\u002f**** PAGINA 3 ****\u002f\nfunction _DrawPage3() {\n\tthis.labelname.Value(this.name.Value());\n  this.labelnamesub.Value(this.namesub.Value());\n  this.labelseriegeo.Value(this.serie.Value());\n  if (!Empty(this.serie.Value()))\n    this.labelvaluegeo_2.Value(this.value.Value());\n  else\n  \tthis.labelvaluegeo_1.Value(this.value.Value());\n  this.labelrangegeo.Value(this.range.Value());\n  this.labelmultikeygeo.Value(this.multikey.Value());\n  this.icongeo.Hide();\n}\n\nfunction _GetOffsetHeightPage3(font) {\n  var h = 0;\n  h += this.GetOffsetHeight(this.labelname.Value(), font);\n  h += this.GetOffsetHeight(this.labelnamesub.Value(), font);\n  h += this.GetOffsetHeight(this.labelseriegeo.Value(), font);\n  h += this.GetOffsetHeight(this.labelvaluegeo_1.Value(), font);\n  h += this.GetOffsetHeight(this.labelvaluegeo_2.Value(), font);\n  h += this.GetOffsetHeight(this.labelrangegeo.Value(), font);\n  h += this.GetOffsetHeight(this.labelmultikeygeo.Value(), font);\n  return h;\n}\n\nfunction _GetOffsetWidthPage3(font) {\n  var w = 0,\n      xIni = 5,\t\u002f\u002f offset tra una stringa e l'altra\n  \t\tcw = !Empty(this.cseries.Value()) ? (this.icongeo.controlwidth + xIni) : 0;\n  w = Math.max(w, this.GetOffsetWidth(this.labelname.Value(), font) + this.GetOffsetWidth(this.labelvaluegeo_1.Value(), font) + 3 * xIni + cw);\n  w = Math.max(w, this.GetOffsetWidth(this.labelnamesub.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelseriegeo.Value(), font) + this.GetOffsetWidth(this.labelvaluegeo_2.Value(), font) + 3 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelrangegeo.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelmultikeygeo.Value(), font) + 2 * xIni);\n  w += 2 * xIni;\n  return w;\n}\n\nfunction _ResizeCtrlsPage3(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labelname.Ctrl.style.width = this.GetOffsetWidth(this.labelname.Value(), font) + \"px\";\n  this.labelvaluegeo_1.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelname.Value(), font) + 2 * xIni) + \"px\";\n  this.labelvaluegeo_1.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluegeo_1.Value(), font) + \"px\";\n  if (!Empty(this.cseries.Value())) {\n  \tthis.icongeo.Show();\n    this.icongeo.Ctrl.style.left = (width - xIni) + \"px\";\n  \tthis.icongeo.Ctrl.style.color = \"#\" + this.cseries.Value();\n  }\n  this.labelnamesub.Ctrl.style.width = this.GetOffsetWidth(this.labelnamesub.Value(), font) + \"px\";\n  this.labelseriegeo.Ctrl.style.width = this.GetOffsetWidth(this.labelseriegeo.Value(), font) + \"px\";\n  this.labelvaluegeo_2.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelseriegeo.Value(), font) + 2 * xIni) + \"px\";\n  this.labelvaluegeo_2.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluegeo_2.Value(), font) + \"px\";\n  this.labelrangegeo.Ctrl.style.width = this.GetOffsetWidth(this.labelrangegeo.Value(), font) + \"px\";\n  this.labelmultikeygeo.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikeygeo.Value(), font) + \"px\";\n  \n  \u002f\u002f adeguamenti y\n  var upd = false;\n \tif (Empty(this.labelnamesub.Value())) {\n    this.labelseriegeo.Ctrl.style.top = (this.labelseriegeo.y - this.labelnamesub.h) + \"px\";\n    this.labelvaluegeo_2.Ctrl.style.top = (this.labelvaluegeo_2.y - this.labelnamesub.h) + \"px\";\n    this.labelrangegeo.Ctrl.style.top = (this.labelrangegeo.y - this.labelnamesub.h) + \"px\";\n    this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.y - this.labelnamesub.h) + \"px\";\n    upd = true;\n  }\n  if (Empty(this.labelseriegeo.Value())) {\n    if (upd) {\n    \tthis.labelrangegeo.Ctrl.style.top = (this.labelrangegeo.Ctrl.offsetTop - this.labelseriegeo.h) + \"px\";\n    \tthis.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.Ctrl.offsetTop - this.labelseriegeo.h) + \"px\";\n    }\n    else {\n      this.labelrangegeo.Ctrl.style.top = (this.labelrangegeo.y - this.labelseriegeo.h) + \"px\";\n    \tthis.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.y - this.labelseriegeo.h) + \"px\";\n    }\n    upd = true;\n  }\n  if (Empty(this.labelrangegeo.Value())) {\n \t \tif (upd)\n      this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.Ctrl.offsetTop - this.labelrangegeo.h) + \"px\";\n    else\n    \tthis.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.y - this.labelrangegeo.h) + \"px\";\n  }\n}\n\n\u002f**** PAGINA 4 ****\u002f\nfunction _DrawPage4() {\n  this.labelcategoryhie.Value(this.category.Value());\n  this.labelvaluehie.Value(this.value.Value());\n}\n\nfunction _GetOffsetHeightPage4(font) {\n  var h = 10;\n  h += this.GetOffsetHeight(this.labelcategoryhie.Value(), font);\n  h += this.GetOffsetHeight(this.labelvaluehie.Value(), font);\n  \n  if (Empty(this.labelvaluehie.Value() + \"\"))\n    h = h + 10;\n  \n  return h;\n}\n\nfunction _GetOffsetWidthPage4(font) {\n  var w = 0,\n      xIni = 5;\t\u002f\u002f offset tra una stringa e l'altra\n  w = Math.max(w, this.GetOffsetWidth(this.labelcategoryhie.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelvaluehie.Value(), font) + 2 * xIni);\n  w += 2 * xIni;\n  return w;\n}\n\nfunction _ResizeCtrlsPage4(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labelcategoryhie.Ctrl.style.width = this.GetOffsetWidth(this.labelcategoryhie.Value(), font) + \"px\";\n  this.labelvaluehie.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluehie.Value(), font) + \"px\";\n}\n\n\u002f**** PAGINA 5 ****\u002f\nfunction _DrawPage5() {\n\tthis.labelsource.Value(this.source.Value());\n  this.labeltarget.Value(this.target.Value());\n  this.labelvaluedep.Value(this.value.Value());\n  this.labelsource2.Value(this.source.Value());\n  this.labeltarget2.Value(this.target.Value());\n  this.labelvaluedep2.Value(this.value2.Value());\n}\n\nfunction _GetOffsetHeightPage5(font) {\n  var h = 0;\n  h += this.GetOffsetHeight(this.labelsource.Value(), font);\n  h += this.GetOffsetHeight(this.labelsource2.Value(), font);\n  return h;\n}\n\nfunction _GetOffsetWidthPage5(font) {\n  var w = 0,\n      xIni = 5,\t\u002f\u002f offset tra una stringa e l'altra\n  \t\tcw = this.arrowLeft.controlwidth + 2 * xIni;\n  w = Math.max(w, this.GetOffsetWidth(this.labelsource.Value(), font) + 5 * xIni + cw + this.GetOffsetWidth(this.labeltarget.Value(), font) + this.GetOffsetWidth(this.labelvaluedep.Value(), font));\n  w = Math.max(w, this.GetOffsetWidth(this.labelsource2.Value(), font) + 5 * xIni + cw + this.GetOffsetWidth(this.labeltarget2.Value(), font) + this.GetOffsetWidth(this.labelvaluedep2.Value(), font));\n  return w;\n}\n\nfunction _ResizeCtrlsPage5(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labelsource.Ctrl.style.width = this.GetOffsetWidth(this.labelsource.Value(), font) + \"px\";\n  this.labeltarget.Ctrl.style.width = this.GetOffsetWidth(this.labeltarget.Value(), font) + \"px\";\n  this.labelsource2.Ctrl.style.width = this.GetOffsetWidth(this.labelsource2.Value(), font) + \"px\";\n  this.labeltarget2.Ctrl.style.width = this.GetOffsetWidth(this.labeltarget2.Value(), font) + \"px\";\n  this.labelvaluedep.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluedep.Value(), font) + \"px\";\n  this.labelvaluedep2.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluedep2.Value(), font) + \"px\";\n  \n  this.arrowLeft.Ctrl.style.left = (this.GetOffsetWidth(this.labelsource.Value(), font) + 2 * xIni) + \"px\";\n  this.labeltarget.Ctrl.style.left = (this.arrowLeft.Ctrl.offsetLeft + xIni + this.arrowLeft.controlwidth) + \"px\";\n  this.labelvaluedep.Ctrl.style.left = (this.labeltarget.Ctrl.offsetLeft + this.labeltarget.Ctrl.offsetWidth + 3 * xIni) + \"px\";\n  \n  this.arrowRight.Ctrl.style.left = (this.GetOffsetWidth(this.labelsource2.Value(), font) + 2 * xIni) + \"px\";\n  this.labeltarget2.Ctrl.style.left = (this.arrowRight.Ctrl.offsetLeft + xIni + this.arrowRight.controlwidth) + \"px\";\n  this.labelvaluedep2.Ctrl.style.left = (this.labeltarget2.Ctrl.offsetLeft + this.labeltarget2.Ctrl.offsetWidth + 3 * xIni) + \"px\";\n  \n  if (Empty(this.labelvaluedep.Value()) || this.type.Value() == \"SANKEY\") {\n  \tthis.labelsource2.Hide();\n    this.labeltarget2.Hide();\n    this.labelvaluedep2.Hide();\n    this.arrowRight.Hide();\n  }  \n}\n\n\u002f**** PAGINA 6 ****\u002f\nfunction _DrawPage6() {\n  this.labelclass_cat.Value(this.category.Value());\n  this.labelclass_cls.Value(this.serie.Value());\n  var value = \"x\";\n  if (!Empty(this.xlabel.Value()))\n    value = this.xlabel.Value();\n \tvalue += \": \";\n  value += this.x.Value();\n  this.labelclass_x.Value(value);\n  value = \"y\";\n  if (!Empty(this.ylabel.Value()))\n    value = this.ylabel.Value();\n \tvalue += \": \";\n  value += this.y.Value();\n  this.labelclass_y.Value(value);\n  this.labelclass_z.Value(this.z.Value());\n}\n\nfunction _GetOffsetHeightPage6(font) {\n  var h = 10;\n  h += this.GetOffsetHeight(this.labelclass_cat.Value(), font);\n  h += this.GetOffsetHeight(this.labelclass_cls.Value(), font);\n  h += this.GetOffsetHeight(this.labelclass_x.Value(), font);\n  h += this.GetOffsetHeight(this.labelclass_y.Value(), font);\n  h += this.GetOffsetHeight(this.labelclass_z.Value(), font);\n  return h;\n}\n\nfunction _GetOffsetWidthPage6(font) {\n  var w = 0,\n      xIni = 5;\n  w = Math.max(w, this.GetOffsetWidth(this.labelclass_cat.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelclass_cls.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelclass_x.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labelclass_y.Value(), font) + 2 * xIni);  \n  w = Math.max(w, this.GetOffsetWidth(this.labelclass_z.Value(), font) + 2 * xIni);\n  w += 2 * xIni;\n  return w;\n}\n\nfunction _ResizeCtrlsPage6(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labelclass_cat.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_cat.Value(), font) + \"px\";\n  this.labelclass_cls.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_cls.Value(), font) + \"px\";\n  this.labelclass_x.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_x.Value(), font) + \"px\";\n  this.labelclass_y.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_y.Value(), font) + \"px\";\n  this.labelclass_z.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_z.Value(), font) + \"px\";\n  \n  \u002f\u002f adeguamenti y\n \t\u002f\u002fif (Empty(this.labelclass_catkey.Value())) {\n    this.labelclass_x.Ctrl.style.top = (this.labelclass_x.y - this.labelclass_catkey.h) + \"px\";\n    this.labelclass_y.Ctrl.style.top = (this.labelclass_y.y - this.labelclass_catkey.h) + \"px\";\n    this.labelclass_z.Ctrl.style.top = (this.labelclass_z.y - this.labelclass_catkey.h) + \"px\";\n  \tthis.labelclass_z.y = this.labelclass_z.y - this.labelclass_catkey.h;\n    this.labelclass_cls.Ctrl.style.top = (this.labelclass_cls.y - this.labelclass_catkey.h) + \"px\";\n  \tthis.labelclass_cls.y = this.labelclass_cls.y - this.labelclass_catkey.h;\n \u002f\u002f }\n  if (Empty(this.labelclass_z.Value()))\n \t this.labelclass_cls.Ctrl.style.top = (this.labelclass_cls.y - this.labelclass_z.h) + \"px\";\n}\n\n\u002f**** PAGINA 7 ****\u002f\nfunction _DrawPage7() {\n  this.labeldesc.Value(this.category.Value());\n  var coords = this.value.Value().split(\",\");\n  this.labellat.Value(coords[0] + \",\");\n  this.labellng.Value(coords[1]);\n  \u002f\u002f key\n}\n\nfunction _GetOffsetHeightPage7(font) {\n  var h = 10;\n  h += this.GetOffsetHeight(this.labeldesc.Value(), font);\n  h += Math.max(this.GetOffsetHeight(this.labellat.Value(), font), this.GetOffsetHeight(this.labellng.Value(), font));\n  return h;\n}\n\nfunction _GetOffsetWidthPage7(font) {\n  var w = 0,\n      xIni = 5;\n  w = Math.max(w, this.GetOffsetWidth(this.labeldesc.Value(), font) + 2 * xIni);\n  w = Math.max(w, this.GetOffsetWidth(this.labellat.Value() + this.labellng.Value(), font) + 2 * xIni);\n  w += 2 * xIni;\n  return w;\n}\n\nfunction _ResizeCtrlsPage7(font, width) {\n  var xIni = 5;\n  \u002f\u002f adeguamenti testo\n  this.labeldesc.Ctrl.style.width = this.GetOffsetWidth(this.labeldesc.Value(), font) + \"px\";\n  this.labellat.Ctrl.style.width = this.GetOffsetWidth(this.labellat.Value(), font) + \"px\";\n  this.labellng.Ctrl.style.width = this.GetOffsetWidth(this.labellng.Value(), font) + \"px\";\n  \n  \u002f\u002f adeguamenti y\n\u002f\u002f    this.labelclass_x.Ctrl.style.top = (this.labelclass_x.y - this.labelclass_catkey.h) + \"px\";\n\n}\n\n\u002f**** GENERICHE ****\u002f\nfunction GetOffsetHeight(labelText, labelFont) {\n\tvar mySpan = this.GetSpan();\n\tif (labelText != \"\") {\n\t\tmySpan.textContent = labelText;\n\t\tmySpan.style.fontFamily = labelFont.name;\n\t\tmySpan.style.fontStyle = labelFont.style;\n\t\tmySpan.style.fontWeight = labelFont.weight;\n\t\tmySpan.style.fontSize = labelFont.size+'px';\n\t\treturn mySpan.offsetHeight;\n\t}\n\telse\n\t\treturn 0;\n}\n\nfunction GetOffsetWidth(labelText, labelFont) {\n\tvar mySpan = this.GetSpan();\n\tif (labelText != \"\") {\n\t\tmySpan.textContent = labelText;\n\t\tmySpan.style.fontFamily = labelFont.name;\n\t\tmySpan.style.fontStyle = labelFont.style;\n\t\tmySpan.style.fontWeight = labelFont.weight;\n\t\tmySpan.style.fontSize = labelFont.size+'px';\n\t\treturn mySpan.offsetWidth;\n\t}\n\telse\n\t\treturn 0;\n}\n\nfunction GetSpan() {\n\tvar spanId = this.formid + \"myspan\",\n\tmySpan = document.getElementById(spanId);\n\tif (Empty(mySpan)) {\n\t\tmySpan = document.createElement(\"div\");\n\t\tmySpan.id = spanId;\n\t\tthis.Ctrl_container.appendChild(mySpan); \n\t\tmySpan.style.visibility = 'hidden';\n\t\tmySpan.style.display = 'inline-block';\n    mySpan.style.whiteSpace = \"nowrap\";\n    mySpan.style.width = \"auto\";\n    mySpan.style.height = \"auto\";\n    mySpan.style.position = \"absolute\";\n\t}\n\treturn mySpan;\n}\n\nfunction toRgbA(col){\n  var c,\n      hex = col.indexOf(\"#\") \u003e= 0 ? col : \"\",\n      rgb = col;\n  if (!Empty(hex)) {\n    if(\u002f^#([A-Fa-f0-9]{3}){1,2}$\u002f.test(hex)){\n      c= hex.substring(1).split('');\n      if(c.length== 3){\n        c= [c[0], c[0], c[1], c[1], c[2], c[2]];\n      }\n      c= '0x'+c.join('');\n      return 'rgba('+[(c\u003e\u003e16)&255, (c\u003e\u003e8)&255, c&255].join(',')+',0.3)';\n    }\n  }\n  else {\n  \treturn rgb.replace(')', ', 0.3)').replace('rgb', 'rgba');\n  }\n  throw new Error('Bad Hex');\n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"#FAFAFA","container_bg_image":"","container_bg_pos":"left top","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"border_type\":\"solid\",\"shadow_type\":\"outline\",\"font\":\"Open Sans, sans-serif\",\"size\":\"11px\",\"weight\":\"normal\",\"style\":\"normal\",\"decoration\":\"none\",\"transform\":\"none\",\"font_color\":\"#0D0F12\",\"align\":\"left\",\"code\":\"white-space: nowrap;\\noverflow: visible !important;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"labelTP\",\"selector\":\".labelTP\",\"value\":\"\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".labelTP {\\n  white-space: nowrap;\\n  overflow: visible !important;\\n  font-family: Open Sans, sans-serif;\\n  color: #0D0F12;\\n  text-decoration: none;\\n  text-transform: none;\\n  font-style: normal;\\n  font-weight: normal;\\n  font-size: 11px;\\n  text-align: left;\\n}\\n\",\"fontoffline\":\"Open Sans, sans-serif\"}]","description":"","fixed_top":"true","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"100","hsl":"","htmlcode":"\n{{ @labellng }}\n{{ @labellat }}\n{{ @labeldesc }}\n{{ @labelclass_cat }}\n{{ @labelcategoryhie }}\n{{ @labelsource2 }}\n{{ @arrowLeft }}\n{{ @labelvaluedep }}\n{{ @labeltarget }}\n{{ @labelsource }}\n{{ @icongeo }}\n{{ @iconxyz }}\n{{ @icon }}\n{{ @labelkey }}\n{{ @labelmultikeygeo }}\n{{ @labelrangegeo }}\n{{ @labelmultikeyvalue }}\n{{ @labelrange }}\n{{ @labelvaluegeo_2 }}\n{{ @labelvalue }}\n{{ @labelseriegeo }}\n{{ @labelvaluegeo_1 }}\n{{ @labelnamesub }}\n{{ @labelname }}\n{{ @labelrangexyz }}\n{{ @labelmultikeyxyz }}\n{{ @labelvaluey }}\n{{ @labelvaluex }}\n{{ @labelvaluez }}\n{{ @labelkeyxyz }}\n{{ @arrowRight }}\n{{ @labelclass_z }}\n{{ @labelseriexyz }}\n{{ @labelclass_cls }}\n{{ @labelvaluedep2 }}\n{{ @labelclass_y }}\n{{ @labelvaluehie }}\n{{ @labelclass_x }}\n{{ @labelserie }}\n{{ @labeltarget2 }}\n{{ @labelclass_catkey }}\n{{ @labelcategory }}\n{{ labelclass_catkey }}\n{{ labelclass_x }}\n{{ labelclass_y }}\n{{ labelclass_cls }}\n{{ labelclass_z }}\n{{ labelclass_cat }}\n{{ labelcategory }}\n{{ labeltarget2 }}\n{{ labelserie }}\n{{ labelvaluehie }}\n{{ labelvaluedep2 }}\n{{ labelseriexyz }}\n{{ arrowRight }}\n{{ labelkeyxyz }}\n{{ labelvaluez }}\n{{ value2 }}\n{{ labelvaluex }}\n{{ labelvaluey }}\n{{ labelmultikeyxyz }}\n{{ labelrangexyz }}\n{{ labelname }}\n{{ labelnamesub }}\n{{ labelvaluegeo_1 }}\n{{ labelseriegeo }}\n{{ labelvalue }}\n{{ labelvaluegeo_2 }}\n{{ labelrange }}\n{{ labelmultikey }}\n{{ labelrangegeo }}\n{{ labelmultikeygeo }}\n{{ labelkey }}\n{{ category }}\n{{ serie }}\n{{ value }}\n{{ range }}\n{{ key }}\n{{ type }}\n{{ color }}\n{{ multikey }}\n{{ id }}\n{{ icon }}\n{{ iconxyz }}\n{{ icongeo }}\n{{ cseries }}\n{{ xlabel }}\n{{ ylabel }}\n{{ x }}\n{{ y }}\n{{ z }}\n{{ name }}\n{{ namesub }}\n{{ source }}\n{{ target }}\n{{ labelsource }}\n{{ labeltarget }}\n{{ labelvaluedep }}\n{{ arrowLeft }}\n{{ labelsource2 }}\n{{ labelcategoryhie }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"false","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"ZtChartFunctions.js","offline":"false","on_security_failure":"login","pages_names":"category,xyz,geo,hie,dep,classif,marker","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"250","version":"37","w":"100%","wizard":""},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelcategory","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"218","wireframe_props":"align,value,n_col","x":"5","y":"4","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labellat","nowrap":"false","page":"7","picture":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"105","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelclass_catkey","nowrap":"false","page":"6","picture":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labeltarget2","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"50","wireframe_props":"align,value,n_col","x":"84","y":"20","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labellng","nowrap":"false","page":"7","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"105","wireframe_props":"align,value,n_col","x":"120","y":"20","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelserie","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"150","wireframe_props":"align,value,n_col","x":"5","y":"40","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelclass_x","nowrap":"false","page":"6","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"35","zindex":"1"},{"align":"left","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluehie","nowrap":"false","page":"4","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"2"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelclass_y","nowrap":"false","page":"6","picture":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"50","zindex":"1"},{"align":"left","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluedep2","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"150","y":"20","zindex":"2"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelclass_cls","nowrap":"false","page":"6","picture":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"80","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelseriexyz","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"150","wireframe_props":"align,value,n_col","x":"5","y":"5","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelclass_z","nowrap":"false","page":"6","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"65","zindex":"1"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf167;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"arrowRight","page":"5","path_type":"","sequence":"14","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"62","y":"20","zindex":"13"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelkeyxyz","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"1"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluez","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"160","y":"5","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"value2","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"156"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluex","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"35","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluey","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"19","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"50","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelmultikeyxyz","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"80","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelrangexyz","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"65","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelname","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"150","wireframe_props":"align,value,n_col","x":"5","y":"5","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelnamesub","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"1"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluegeo_1","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"160","y":"5","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelseriegeo","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"25","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"150","wireframe_props":"align,value,n_col","x":"5","y":"35","zindex":"1"},{"align":"left","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvalue","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"160","y":"40","zindex":"2"},{"align":"left","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluegeo_2","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"160","y":"35","zindex":"2"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelrange","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"28","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"59","zindex":"3"},{"align":"center","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelmultikeyvalue","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"77","zindex":"3"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelrangegeo","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"50","zindex":"3"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelmultikeygeo","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"65","zindex":"3"},{"align":"left","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelkey","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"32","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"22","zindex":"4"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"category","page":"1","reactive":"","sequence":"33","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"-28"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"serie","page":"1","reactive":"","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"133"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"value","page":"1","reactive":"","sequence":"35","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"-5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"range","page":"1","reactive":"","sequence":"36","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"18"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"key","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"-28"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"type","page":"1","reactive":"","sequence":"38","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"156"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"color","page":"1","reactive":"","sequence":"39","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"41"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"multikey","page":"1","reactive":"","sequence":"40","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"64"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"id","page":"1","reactive":"","sequence":"41","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"87"},{"alt":"","anchor":"","bounded_position":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xf02e;","font_image_hover":"","font_name":"fontawesome-webfont","font_size":"14","h":"14","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"icon","page":"1","path_type":"","sequence":"42","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"14","wireframe_props":"","x":"230","y":"5","zindex":"5"},{"alt":"","anchor":"","bounded_position":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xf02e;","font_image_hover":"","font_name":"fontawesome-webfont","font_size":"14","h":"14","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"iconxyz","page":"2","path_type":"","sequence":"43","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"14","wireframe_props":"","x":"230","y":"5","zindex":"5"},{"alt":"","anchor":"","bounded_position":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xf02e;","font_image_hover":"","font_name":"fontawesome-webfont","font_size":"14","h":"14","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"icongeo","page":"3","path_type":"","sequence":"44","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"14","wireframe_props":"","x":"230","y":"5","zindex":"5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"cseries","page":"1","reactive":"","sequence":"45","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"272","y":"110"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"xlabel","page":"1","reactive":"","sequence":"46","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"544","y":"-28"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ylabel","page":"1","reactive":"","sequence":"47","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"544","y":"-5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"x","page":"1","reactive":"","sequence":"48","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"-5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"y","page":"1","reactive":"","sequence":"49","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"18"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"z","page":"1","reactive":"","sequence":"50","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"41"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"name","page":"1","reactive":"","sequence":"51","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"64"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"namesub","page":"1","reactive":"","sequence":"52","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"87"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"source","page":"1","reactive":"","sequence":"53","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"110"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"target","page":"1","reactive":"","sequence":"54","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"133"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelsource","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"55","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"50","wireframe_props":"align,value,n_col","x":"5","y":"5","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labeltarget","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"56","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"50","wireframe_props":"align,value,n_col","x":"84","y":"5","zindex":"1"},{"align":"left","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelvaluedep","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"57","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"65","wireframe_props":"align,value,n_col","x":"150","y":"5","zindex":"2"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf168;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"15","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"arrowLeft","page":"5","path_type":"","sequence":"58","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"15","wireframe_props":"","x":"62","y":"5","zindex":"13"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelsource2","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"59","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"50","wireframe_props":"align,value,n_col","x":"5","y":"20","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelcategoryhie","nowrap":"false","page":"4","picture":"","sanitize":"","sanitize_tags":"","sequence":"60","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"218","wireframe_props":"align,value,n_col","x":"5","y":"5","zindex":"1"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelclass_cat","nowrap":"false","page":"6","picture":"","sanitize":"","sanitize_tags":"","sequence":"61","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"5","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"isMarker","page":"1","reactive":"","sequence":"62","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"544","y":"18"},{"align":"","anchor":"top-left-bottom","assoc_input":"","bg_color":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labeldesc","nowrap":"false","page":"7","picture":"","sanitize":"","sanitize_tags":"","sequence":"63","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"5","y":"5","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"multikeyvalue","page":"1","reactive":"","sequence":"65","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"544","y":"41"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:value2,category,serie,value,range,key,type,color,multikey,id,cseries,xlabel,ylabel,x,y,z,name,namesub,source,target,isMarker,multikeyvalue*/%>
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
window.SPChartTooltipsR_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof _DrawPage1 !='undefined')this._DrawPage1=_DrawPage1;
if(typeof _GetOffsetHeightPage1 !='undefined')this._GetOffsetHeightPage1=_GetOffsetHeightPage1;
if(typeof _GetOffsetWidthPage1 !='undefined')this._GetOffsetWidthPage1=_GetOffsetWidthPage1;
if(typeof _ResizeCtrlsPage1 !='undefined')this._ResizeCtrlsPage1=_ResizeCtrlsPage1;
if(typeof _DrawPage2 !='undefined')this._DrawPage2=_DrawPage2;
if(typeof _GetOffsetHeightPage2 !='undefined')this._GetOffsetHeightPage2=_GetOffsetHeightPage2;
if(typeof _GetOffsetWidthPage2 !='undefined')this._GetOffsetWidthPage2=_GetOffsetWidthPage2;
if(typeof _ResizeCtrlsPage2 !='undefined')this._ResizeCtrlsPage2=_ResizeCtrlsPage2;
if(typeof _DrawPage3 !='undefined')this._DrawPage3=_DrawPage3;
if(typeof _GetOffsetHeightPage3 !='undefined')this._GetOffsetHeightPage3=_GetOffsetHeightPage3;
if(typeof _GetOffsetWidthPage3 !='undefined')this._GetOffsetWidthPage3=_GetOffsetWidthPage3;
if(typeof _ResizeCtrlsPage3 !='undefined')this._ResizeCtrlsPage3=_ResizeCtrlsPage3;
if(typeof _DrawPage4 !='undefined')this._DrawPage4=_DrawPage4;
if(typeof _GetOffsetHeightPage4 !='undefined')this._GetOffsetHeightPage4=_GetOffsetHeightPage4;
if(typeof _GetOffsetWidthPage4 !='undefined')this._GetOffsetWidthPage4=_GetOffsetWidthPage4;
if(typeof _ResizeCtrlsPage4 !='undefined')this._ResizeCtrlsPage4=_ResizeCtrlsPage4;
if(typeof _DrawPage5 !='undefined')this._DrawPage5=_DrawPage5;
if(typeof _GetOffsetHeightPage5 !='undefined')this._GetOffsetHeightPage5=_GetOffsetHeightPage5;
if(typeof _GetOffsetWidthPage5 !='undefined')this._GetOffsetWidthPage5=_GetOffsetWidthPage5;
if(typeof _ResizeCtrlsPage5 !='undefined')this._ResizeCtrlsPage5=_ResizeCtrlsPage5;
if(typeof _DrawPage6 !='undefined')this._DrawPage6=_DrawPage6;
if(typeof _GetOffsetHeightPage6 !='undefined')this._GetOffsetHeightPage6=_GetOffsetHeightPage6;
if(typeof _GetOffsetWidthPage6 !='undefined')this._GetOffsetWidthPage6=_GetOffsetWidthPage6;
if(typeof _ResizeCtrlsPage6 !='undefined')this._ResizeCtrlsPage6=_ResizeCtrlsPage6;
if(typeof _DrawPage7 !='undefined')this._DrawPage7=_DrawPage7;
if(typeof _GetOffsetHeightPage7 !='undefined')this._GetOffsetHeightPage7=_GetOffsetHeightPage7;
if(typeof _GetOffsetWidthPage7 !='undefined')this._GetOffsetWidthPage7=_GetOffsetWidthPage7;
if(typeof _ResizeCtrlsPage7 !='undefined')this._ResizeCtrlsPage7=_ResizeCtrlsPage7;
if(typeof GetOffsetHeight !='undefined')this.GetOffsetHeight=GetOffsetHeight;
if(typeof GetOffsetWidth !='undefined')this.GetOffsetWidth=GetOffsetWidth;
if(typeof GetSpan !='undefined')this.GetSpan=GetSpan;
if(typeof toRgbA !='undefined')this.toRgbA=toRgbA;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
  this.EnablePage(3);
  this.EnablePage(4);
  this.EnablePage(5);
  this.EnablePage(6);
  this.EnablePage(7);
}
this.EnablePage(1);
this.EnablePage(2);
this.EnablePage(3);
this.EnablePage(4);
this.EnablePage(5);
this.EnablePage(6);
this.EnablePage(7);
function this_Loaded(){
  var macroType = getZFChartMacroType(this.type.Value()),
      font = { name : "Open Sans", size : 11, style : "normal", weight : "normal" },
      fontb = { name : "Open Sans", size : 11, style : "normal", weight : "bold" },
      w,
      h,
      icon,
      ifr,
      tabs = document.getElementById(this.formid + "_tabcontainer"),
      _this = this;
	if (this.isMarker.Value()) {
    this.ZtTabs.Select("page7");
    this._DrawPage7();
    w = this._GetOffsetWidthPage7(font);
    h = this._GetOffsetHeightPage7(font);
    this._ResizeCtrlsPage7(font, w);
  }
  else {
    switch (macroType) {
      case "xyz":
        this.ZtTabs.Select("page2");
        this._DrawPage2();
        w = this._GetOffsetWidthPage2(font);
        h = this._GetOffsetHeightPage2(font);
        this._ResizeCtrlsPage2(font, w);
        break;
      case "geo":
        this.ZtTabs.Select("page3");
        this._DrawPage3();
        w = this._GetOffsetWidthPage3(font);
        h = this._GetOffsetHeightPage3(font);
        this._ResizeCtrlsPage3(font, w);
        break;
      case "hie":
        this.ZtTabs.Select("page4");
        this._DrawPage4();
        w = this._GetOffsetWidthPage4(font);
        h = this._GetOffsetHeightPage4(font);
        this._ResizeCtrlsPage4(font, w);
        break;
      case "dep":
        this.ZtTabs.Select("page5");
        this._DrawPage5();
        w = this._GetOffsetWidthPage5(font);
        h = this._GetOffsetHeightPage5(font);
        this._ResizeCtrlsPage5(font, w);
        break;
      case "classif":
        this.ZtTabs.Select("page6");
        this._DrawPage6();
        w = this._GetOffsetWidthPage6(font);
        h = this._GetOffsetHeightPage6(font);
        this._ResizeCtrlsPage6(font, w);
        break;
      default:	// category
        this.ZtTabs.Select("page1");
        this._DrawPage1();
        w = this._GetOffsetWidthPage1(fontb);
        h = this._GetOffsetHeightPage1(fontb);
        this._ResizeCtrlsPage1(fontb, w);
        break;
    }
  }
 	if (tabs)
  	tabs.style.display = "none";
  
  if (window.parent && window.parent.document.getElementById(this.id.Value() + "tooltipI")) {
    ifr = window.parent.document.getElementById(this.id.Value() + "tooltipI");
    ifr.contentDocument.body.style.overflow = "hidden";
  }
  
  this.Ctrl.style.width = w + "px";
  this.Ctrl.style.minWidth = w + "px";
  this.Ctrl.style.height = h + "px";
  var color = this.color.Value().indexOf("rgb") >= 0 ? this.color.Value() : "#" + this.color.Value();
  //this.Ctrl.style.backgroundColor = toRgbA(color);
  this.Ctrl.style.border = "solid 1px " + color;
  this.Ctrl.style.borderRadius = "5px";
  this.Ctrl.style.padding = "5px";
  
  this.Ctrl_container.style.width = w + "px";
  this.Ctrl_container.style.height = h + "px";
  this.Ctrl_container.style.borderRadius = "5px";
  var span = this.GetSpan();
  span.parentNode.removeChild(span);
  setTimeout(function () {   
    if (window.parent && window.parent.document.getElementById(_this.id.Value() + "tooltipDiv")) {
      ifr = window.parent.document.getElementById(_this.id.Value() + "tooltipDiv");
      ifr.style.width = w + "px";
      ifr.style.height = h + "px";
      var //pwidth = parseInt(ifr.getAttribute("par-width")),
         	pleft = parseInt(ifr.getAttribute("par-left")),
          cur_left = pleft + ifr.offsetLeft,
      		maxw = window.parent.visualViewport.width;
     	if ((cur_left + w) > (maxw - 1)) {	// sposto il tooltip per limite margine destro
      	ifr.style.left = (maxw - 1 - w - pleft) + "px";
      }
    }
  }, 100);
}
function _DrawPage1() {
	//this.labelkey.Value(this.key.Value());
  this.labelcategory.Value(this.category.Value());
  this.labelserie.Value(this.serie.Value());
  this.labelvalue.Value(this.value.Value());
  this.labelrange.Value(this.range.Value());
  this.labelmultikeyvalue.Value(this.multikeyvalue.Value());
  //this.labelmultikey.Value(this.multikey.Value());
  this.icon.Hide();
  
}
function _GetOffsetHeightPage1(font) {
  var h = 0;
  h += this.GetOffsetHeight(this.labelkey.Value(), font);
  h += this.GetOffsetHeight(this.labelcategory.Value(), font);
  h += this.GetOffsetHeight(this.labelserie.Value(), font);
  h += this.GetOffsetHeight(this.labelvalue.Value(), font);
  h += this.GetOffsetHeight(this.labelrange.Value(), font);
  h += this.GetOffsetHeight(this.labelmultikeyvalue.Value(), font);
  if (Empty(this.labelcategory.Value()) || Empty(this.labelserie.Value()) || Empty(this.labelvalue.Value() + ""))
    h = h + 10;
  
  return h + 3*5;
}
function _GetOffsetWidthPage1(font) {
  var w = 0,
      xIni = 5,	// offset tra una stringa e l'altra
  		cw = !Empty(this.cseries.Value()) ? (this.icon.controlwidth + xIni) : 0;
  w = Math.max(w, this.GetOffsetWidth(this.labelcategory.Value(), font) + 2 * xIni + cw);
  w = Math.max(w, this.GetOffsetWidth(this.labelkey.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelserie.Value(), font) + this.GetOffsetWidth(this.labelvalue.Value(), font) + 3 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelrange.Value(), font) + 2 * xIni);
  //w = Math.max(w, this.GetOffsetWidth(this.labelmultikey.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelmultikeyvalue.Value(), font) + 2 * xIni);
  w += 2 * xIni;
  return w;
}
function _ResizeCtrlsPage1(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labelcategory.Ctrl.style.width = this.GetOffsetWidth(this.labelcategory.Value(), font) + "px";
  if (!Empty(this.cseries.Value())) {
  	this.icon.Show();
    this.icon.Ctrl.style.left = (width - xIni) + "px";
  	this.icon.Ctrl.style.color = "#" + this.cseries.Value();
  }
  this.labelkey.Ctrl.style.width = this.GetOffsetWidth(this.labelkey.Value(), font) + "px";
  this.labelserie.Ctrl.style.width = this.GetOffsetWidth(this.labelserie.Value(), font) + "px";
  this.labelvalue.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelserie.Value(), font) + 2 * xIni) + "px";
  this.labelvalue.Ctrl.style.width = this.GetOffsetWidth(this.labelvalue.Value(), font) + "px";
  this.labelrange.Ctrl.style.width = this.GetOffsetWidth(this.labelrange.Value(), font) + "px";
  //this.labelmultikey.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikey.Value(), font) + "px";
  this.labelmultikeyvalue.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikeyvalue.Value(), font) + "px";
  
  // adeguamenti y
  var upd = false;
  if (Empty(this.labelcategory.Value())) {
    this.labelkey.Ctrl.style.top = (this.labelkey.y - this.labelcategory.h) + "px";
    this.labelserie.Ctrl.style.top = (this.labelserie.y - this.labelcategory.h) + "px";
    this.labelvalue.Ctrl.style.top = (this.labelvalue.y - this.labelcategory.h) + "px";
    this.labelrange.Ctrl.style.top = (this.labelrange.y - this.labelcategory.h) + "px";
    this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.y - this.labelcategory.h) + "px";
    upd = true;
  }
 	if (Empty(this.labelkey.Value())) {
    if (upd) {
      this.labelserie.Ctrl.style.top = (this.labelserie.Ctrl.offsetTop - this.labelkey.h) + "px";
      this.labelvalue.Ctrl.style.top = (this.labelvalue.Ctrl.offsetTop - this.labelkey.h) + "px";
      this.labelrange.Ctrl.style.top = (this.labelrange.Ctrl.offsetTop - this.labelkey.h) + "px";
      this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.Ctrl.offsetTop - this.labelkey.h) + "px";
    }
    else {
      this.labelserie.Ctrl.style.top = (this.labelserie.y - this.labelkey.h) + "px";
      this.labelvalue.Ctrl.style.top = (this.labelvalue.y - this.labelkey.h) + "px";
      this.labelrange.Ctrl.style.top = (this.labelrange.y - this.labelkey.h) + "px";
      this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.y - this.labelkey.h) + "px";
      upd = true;
    }
  }
  if (Empty(this.labelrange.Value())) {
 		if (upd)
      this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.Ctrl.offsetTop - this.labelrange.h) + "px";
    else
    	this.labelmultikeyvalue.Ctrl.style.top = (this.labelmultikeyvalue.y - this.labelrange.h) + "px";
  }
}
function _DrawPage2() {
  this.labelkeyxyz.Value(this.key.Value());
  this.labelseriexyz.Value(this.serie.Value());
  this.labelvaluez.Value(this.z.Value());
  var value = "x";
  if (!Empty(this.xlabel.Value()))
    value = this.xlabel.Value();
 	value += ": ";
  value += this.x.Value();
  this.labelvaluex.Value(value);
  value = "y";
  if (!Empty(this.ylabel.Value()))
    value = this.ylabel.Value();
 	value += ": ";
  value += this.y.Value();
  this.labelvaluey.Value(value);
  this.labelrangexyz.Value(this.range.Value());
  this.labelmultikeyxyz.Value(this.multikey.Value());
  this.iconxyz.Hide();
}
function _GetOffsetHeightPage2(font) {
  var h = 0;
  h += this.GetOffsetHeight(this.labelkeyxyz.Value(), font);
  h += this.GetOffsetHeight(this.labelseriexyz.Value(), font);
  h += this.GetOffsetHeight(this.labelvaluex.Value(), font);
  h += this.GetOffsetHeight(this.labelvaluey.Value(), font);
  h += (this.GetOffsetHeight(this.labelvaluez.Value(), font) || this.GetOffsetHeight("w", font));
  h += this.GetOffsetHeight(this.labelrangexyz.Value(), font);
  h += this.GetOffsetHeight(this.labelmultikeyxyz.Value(), font);
  return h;
}
function _GetOffsetWidthPage2(font) {
  var w = 0,
      xIni = 5,	// offset tra una stringa e l'altra
  		cw = !Empty(this.cseries.Value()) ? (this.iconxyz.controlwidth + xIni) : 0;
  w = Math.max(w, this.GetOffsetWidth(this.labelseriexyz.Value(), font) + this.GetOffsetWidth(this.labelvaluez.Value(), font) + cw + 5 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelkeyxyz.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelvaluex.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelvaluey.Value(), font) + 2 * xIni);  
  w = Math.max(w, this.GetOffsetWidth(this.labelrangexyz.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelmultikeyxyz.Value(), font) + 2 * xIni);
  w += 2 * xIni;
  return w;
}
function _ResizeCtrlsPage2(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labelseriexyz.Ctrl.style.width = this.GetOffsetWidth(this.labelseriexyz.Value(), font) + "px";
  if (!Empty(this.cseries.Value())) {
  	this.iconxyz.Show();
    this.iconxyz.Ctrl.style.left = (width - xIni) + "px";
  	this.iconxyz.Ctrl.style.color = "#" + this.cseries.Value();
  }
  this.labelkeyxyz.Ctrl.style.width = this.GetOffsetWidth(this.labelkeyxyz.Value(), font) + "px";
  this.labelvaluez.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelseriexyz.Value(), font) + 2 * xIni) + "px";
  this.labelvaluez.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluez.Value(), font) + "px";
  this.labelvaluex.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluex.Value(), font) + "px";
  this.labelvaluey.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluey.Value(), font) + "px";
  this.labelrangexyz.Ctrl.style.width = this.GetOffsetWidth(this.labelrangexyz.Value(), font) + "px";
  this.labelmultikeyxyz.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikeyxyz.Value(), font) + "px";
  
  // adeguamenti y
 	if (Empty(this.labelkeyxyz.Value())) {
    this.labelvaluex.Ctrl.style.top = (this.labelvaluex.y - this.labelkeyxyz.h) + "px";
    this.labelvaluey.Ctrl.style.top = (this.labelvaluey.y - this.labelkeyxyz.h) + "px";
    this.labelrangexyz.Ctrl.style.top = (this.labelrangexyz.y - this.labelkeyxyz.h) + "px";
    this.labelmultikeyxyz.Ctrl.style.top = (this.labelmultikeyxyz.y - this.labelkeyxyz.h) + "px";
  }
  if (Empty(this.labelrangexyz.Value()))
 	 this.labelmultikeyxyz.Ctrl.style.top = (this.labelmultikeyxyz.y - this.labelrangexyz.h) + "px";
}
function _DrawPage3() {
	this.labelname.Value(this.name.Value());
  this.labelnamesub.Value(this.namesub.Value());
  this.labelseriegeo.Value(this.serie.Value());
  if (!Empty(this.serie.Value()))
    this.labelvaluegeo_2.Value(this.value.Value());
  else
  	this.labelvaluegeo_1.Value(this.value.Value());
  this.labelrangegeo.Value(this.range.Value());
  this.labelmultikeygeo.Value(this.multikey.Value());
  this.icongeo.Hide();
}
function _GetOffsetHeightPage3(font) {
  var h = 0;
  h += this.GetOffsetHeight(this.labelname.Value(), font);
  h += this.GetOffsetHeight(this.labelnamesub.Value(), font);
  h += this.GetOffsetHeight(this.labelseriegeo.Value(), font);
  h += this.GetOffsetHeight(this.labelvaluegeo_1.Value(), font);
  h += this.GetOffsetHeight(this.labelvaluegeo_2.Value(), font);
  h += this.GetOffsetHeight(this.labelrangegeo.Value(), font);
  h += this.GetOffsetHeight(this.labelmultikeygeo.Value(), font);
  return h;
}
function _GetOffsetWidthPage3(font) {
  var w = 0,
      xIni = 5,	// offset tra una stringa e l'altra
  		cw = !Empty(this.cseries.Value()) ? (this.icongeo.controlwidth + xIni) : 0;
  w = Math.max(w, this.GetOffsetWidth(this.labelname.Value(), font) + this.GetOffsetWidth(this.labelvaluegeo_1.Value(), font) + 3 * xIni + cw);
  w = Math.max(w, this.GetOffsetWidth(this.labelnamesub.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelseriegeo.Value(), font) + this.GetOffsetWidth(this.labelvaluegeo_2.Value(), font) + 3 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelrangegeo.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelmultikeygeo.Value(), font) + 2 * xIni);
  w += 2 * xIni;
  return w;
}
function _ResizeCtrlsPage3(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labelname.Ctrl.style.width = this.GetOffsetWidth(this.labelname.Value(), font) + "px";
  this.labelvaluegeo_1.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelname.Value(), font) + 2 * xIni) + "px";
  this.labelvaluegeo_1.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluegeo_1.Value(), font) + "px";
  if (!Empty(this.cseries.Value())) {
  	this.icongeo.Show();
    this.icongeo.Ctrl.style.left = (width - xIni) + "px";
  	this.icongeo.Ctrl.style.color = "#" + this.cseries.Value();
  }
  this.labelnamesub.Ctrl.style.width = this.GetOffsetWidth(this.labelnamesub.Value(), font) + "px";
  this.labelseriegeo.Ctrl.style.width = this.GetOffsetWidth(this.labelseriegeo.Value(), font) + "px";
  this.labelvaluegeo_2.Ctrl.style.left = (xIni + this.GetOffsetWidth(this.labelseriegeo.Value(), font) + 2 * xIni) + "px";
  this.labelvaluegeo_2.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluegeo_2.Value(), font) + "px";
  this.labelrangegeo.Ctrl.style.width = this.GetOffsetWidth(this.labelrangegeo.Value(), font) + "px";
  this.labelmultikeygeo.Ctrl.style.width = this.GetOffsetWidth(this.labelmultikeygeo.Value(), font) + "px";
  
  // adeguamenti y
  var upd = false;
 	if (Empty(this.labelnamesub.Value())) {
    this.labelseriegeo.Ctrl.style.top = (this.labelseriegeo.y - this.labelnamesub.h) + "px";
    this.labelvaluegeo_2.Ctrl.style.top = (this.labelvaluegeo_2.y - this.labelnamesub.h) + "px";
    this.labelrangegeo.Ctrl.style.top = (this.labelrangegeo.y - this.labelnamesub.h) + "px";
    this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.y - this.labelnamesub.h) + "px";
    upd = true;
  }
  if (Empty(this.labelseriegeo.Value())) {
    if (upd) {
    	this.labelrangegeo.Ctrl.style.top = (this.labelrangegeo.Ctrl.offsetTop - this.labelseriegeo.h) + "px";
    	this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.Ctrl.offsetTop - this.labelseriegeo.h) + "px";
    }
    else {
      this.labelrangegeo.Ctrl.style.top = (this.labelrangegeo.y - this.labelseriegeo.h) + "px";
    	this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.y - this.labelseriegeo.h) + "px";
    }
    upd = true;
  }
  if (Empty(this.labelrangegeo.Value())) {
 	 	if (upd)
      this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.Ctrl.offsetTop - this.labelrangegeo.h) + "px";
    else
    	this.labelmultikeygeo.Ctrl.style.top = (this.labelmultikeygeo.y - this.labelrangegeo.h) + "px";
  }
}
function _DrawPage4() {
  this.labelcategoryhie.Value(this.category.Value());
  this.labelvaluehie.Value(this.value.Value());
}
function _GetOffsetHeightPage4(font) {
  var h = 10;
  h += this.GetOffsetHeight(this.labelcategoryhie.Value(), font);
  h += this.GetOffsetHeight(this.labelvaluehie.Value(), font);
  
  if (Empty(this.labelvaluehie.Value() + ""))
    h = h + 10;
  
  return h;
}
function _GetOffsetWidthPage4(font) {
  var w = 0,
      xIni = 5;	// offset tra una stringa e l'altra
  w = Math.max(w, this.GetOffsetWidth(this.labelcategoryhie.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelvaluehie.Value(), font) + 2 * xIni);
  w += 2 * xIni;
  return w;
}
function _ResizeCtrlsPage4(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labelcategoryhie.Ctrl.style.width = this.GetOffsetWidth(this.labelcategoryhie.Value(), font) + "px";
  this.labelvaluehie.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluehie.Value(), font) + "px";
}
function _DrawPage5() {
	this.labelsource.Value(this.source.Value());
  this.labeltarget.Value(this.target.Value());
  this.labelvaluedep.Value(this.value.Value());
  this.labelsource2.Value(this.source.Value());
  this.labeltarget2.Value(this.target.Value());
  this.labelvaluedep2.Value(this.value2.Value());
}
function _GetOffsetHeightPage5(font) {
  var h = 0;
  h += this.GetOffsetHeight(this.labelsource.Value(), font);
  h += this.GetOffsetHeight(this.labelsource2.Value(), font);
  return h;
}
function _GetOffsetWidthPage5(font) {
  var w = 0,
      xIni = 5,	// offset tra una stringa e l'altra
  		cw = this.arrowLeft.controlwidth + 2 * xIni;
  w = Math.max(w, this.GetOffsetWidth(this.labelsource.Value(), font) + 5 * xIni + cw + this.GetOffsetWidth(this.labeltarget.Value(), font) + this.GetOffsetWidth(this.labelvaluedep.Value(), font));
  w = Math.max(w, this.GetOffsetWidth(this.labelsource2.Value(), font) + 5 * xIni + cw + this.GetOffsetWidth(this.labeltarget2.Value(), font) + this.GetOffsetWidth(this.labelvaluedep2.Value(), font));
  return w;
}
function _ResizeCtrlsPage5(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labelsource.Ctrl.style.width = this.GetOffsetWidth(this.labelsource.Value(), font) + "px";
  this.labeltarget.Ctrl.style.width = this.GetOffsetWidth(this.labeltarget.Value(), font) + "px";
  this.labelsource2.Ctrl.style.width = this.GetOffsetWidth(this.labelsource2.Value(), font) + "px";
  this.labeltarget2.Ctrl.style.width = this.GetOffsetWidth(this.labeltarget2.Value(), font) + "px";
  this.labelvaluedep.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluedep.Value(), font) + "px";
  this.labelvaluedep2.Ctrl.style.width = this.GetOffsetWidth(this.labelvaluedep2.Value(), font) + "px";
  
  this.arrowLeft.Ctrl.style.left = (this.GetOffsetWidth(this.labelsource.Value(), font) + 2 * xIni) + "px";
  this.labeltarget.Ctrl.style.left = (this.arrowLeft.Ctrl.offsetLeft + xIni + this.arrowLeft.controlwidth) + "px";
  this.labelvaluedep.Ctrl.style.left = (this.labeltarget.Ctrl.offsetLeft + this.labeltarget.Ctrl.offsetWidth + 3 * xIni) + "px";
  
  this.arrowRight.Ctrl.style.left = (this.GetOffsetWidth(this.labelsource2.Value(), font) + 2 * xIni) + "px";
  this.labeltarget2.Ctrl.style.left = (this.arrowRight.Ctrl.offsetLeft + xIni + this.arrowRight.controlwidth) + "px";
  this.labelvaluedep2.Ctrl.style.left = (this.labeltarget2.Ctrl.offsetLeft + this.labeltarget2.Ctrl.offsetWidth + 3 * xIni) + "px";
  
  if (Empty(this.labelvaluedep.Value()) || this.type.Value() == "SANKEY") {
  	this.labelsource2.Hide();
    this.labeltarget2.Hide();
    this.labelvaluedep2.Hide();
    this.arrowRight.Hide();
  }  
}
function _DrawPage6() {
  this.labelclass_cat.Value(this.category.Value());
  this.labelclass_cls.Value(this.serie.Value());
  var value = "x";
  if (!Empty(this.xlabel.Value()))
    value = this.xlabel.Value();
 	value += ": ";
  value += this.x.Value();
  this.labelclass_x.Value(value);
  value = "y";
  if (!Empty(this.ylabel.Value()))
    value = this.ylabel.Value();
 	value += ": ";
  value += this.y.Value();
  this.labelclass_y.Value(value);
  this.labelclass_z.Value(this.z.Value());
}
function _GetOffsetHeightPage6(font) {
  var h = 10;
  h += this.GetOffsetHeight(this.labelclass_cat.Value(), font);
  h += this.GetOffsetHeight(this.labelclass_cls.Value(), font);
  h += this.GetOffsetHeight(this.labelclass_x.Value(), font);
  h += this.GetOffsetHeight(this.labelclass_y.Value(), font);
  h += this.GetOffsetHeight(this.labelclass_z.Value(), font);
  return h;
}
function _GetOffsetWidthPage6(font) {
  var w = 0,
      xIni = 5;
  w = Math.max(w, this.GetOffsetWidth(this.labelclass_cat.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelclass_cls.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelclass_x.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labelclass_y.Value(), font) + 2 * xIni);  
  w = Math.max(w, this.GetOffsetWidth(this.labelclass_z.Value(), font) + 2 * xIni);
  w += 2 * xIni;
  return w;
}
function _ResizeCtrlsPage6(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labelclass_cat.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_cat.Value(), font) + "px";
  this.labelclass_cls.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_cls.Value(), font) + "px";
  this.labelclass_x.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_x.Value(), font) + "px";
  this.labelclass_y.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_y.Value(), font) + "px";
  this.labelclass_z.Ctrl.style.width = this.GetOffsetWidth(this.labelclass_z.Value(), font) + "px";
  
  // adeguamenti y
 	//if (Empty(this.labelclass_catkey.Value())) {
    this.labelclass_x.Ctrl.style.top = (this.labelclass_x.y - this.labelclass_catkey.h) + "px";
    this.labelclass_y.Ctrl.style.top = (this.labelclass_y.y - this.labelclass_catkey.h) + "px";
    this.labelclass_z.Ctrl.style.top = (this.labelclass_z.y - this.labelclass_catkey.h) + "px";
  	this.labelclass_z.y = this.labelclass_z.y - this.labelclass_catkey.h;
    this.labelclass_cls.Ctrl.style.top = (this.labelclass_cls.y - this.labelclass_catkey.h) + "px";
  	this.labelclass_cls.y = this.labelclass_cls.y - this.labelclass_catkey.h;
 // }
  if (Empty(this.labelclass_z.Value()))
 	 this.labelclass_cls.Ctrl.style.top = (this.labelclass_cls.y - this.labelclass_z.h) + "px";
}
function _DrawPage7() {
  this.labeldesc.Value(this.category.Value());
  var coords = this.value.Value().split(",");
  this.labellat.Value(coords[0] + ",");
  this.labellng.Value(coords[1]);
  // key
}
function _GetOffsetHeightPage7(font) {
  var h = 10;
  h += this.GetOffsetHeight(this.labeldesc.Value(), font);
  h += Math.max(this.GetOffsetHeight(this.labellat.Value(), font), this.GetOffsetHeight(this.labellng.Value(), font));
  return h;
}
function _GetOffsetWidthPage7(font) {
  var w = 0,
      xIni = 5;
  w = Math.max(w, this.GetOffsetWidth(this.labeldesc.Value(), font) + 2 * xIni);
  w = Math.max(w, this.GetOffsetWidth(this.labellat.Value() + this.labellng.Value(), font) + 2 * xIni);
  w += 2 * xIni;
  return w;
}
function _ResizeCtrlsPage7(font, width) {
  var xIni = 5;
  // adeguamenti testo
  this.labeldesc.Ctrl.style.width = this.GetOffsetWidth(this.labeldesc.Value(), font) + "px";
  this.labellat.Ctrl.style.width = this.GetOffsetWidth(this.labellat.Value(), font) + "px";
  this.labellng.Ctrl.style.width = this.GetOffsetWidth(this.labellng.Value(), font) + "px";
  
  // adeguamenti y
//    this.labelclass_x.Ctrl.style.top = (this.labelclass_x.y - this.labelclass_catkey.h) + "px";
}
function GetOffsetHeight(labelText, labelFont) {
	var mySpan = this.GetSpan();
	if (labelText != "") {
		mySpan.textContent = labelText;
		mySpan.style.fontFamily = labelFont.name;
		mySpan.style.fontStyle = labelFont.style;
		mySpan.style.fontWeight = labelFont.weight;
		mySpan.style.fontSize = labelFont.size+'px';
		return mySpan.offsetHeight;
	}
	else
		return 0;
}
function GetOffsetWidth(labelText, labelFont) {
	var mySpan = this.GetSpan();
	if (labelText != "") {
		mySpan.textContent = labelText;
		mySpan.style.fontFamily = labelFont.name;
		mySpan.style.fontStyle = labelFont.style;
		mySpan.style.fontWeight = labelFont.weight;
		mySpan.style.fontSize = labelFont.size+'px';
		return mySpan.offsetWidth;
	}
	else
		return 0;
}
function GetSpan() {
	var spanId = this.formid + "myspan",
	mySpan = document.getElementById(spanId);
	if (Empty(mySpan)) {
		mySpan = document.createElement("div");
		mySpan.id = spanId;
		this.Ctrl_container.appendChild(mySpan); 
		mySpan.style.visibility = 'hidden';
		mySpan.style.display = 'inline-block';
    mySpan.style.whiteSpace = "nowrap";
    mySpan.style.width = "auto";
    mySpan.style.height = "auto";
    mySpan.style.position = "absolute";
	}
	return mySpan;
}
function toRgbA(col){
  var c,
      hex = col.indexOf("#") >= 0 ? col : "",
      rgb = col;
  if (!Empty(hex)) {
    if(/^#([A-Fa-f0-9]{3}){1,2}$/.test(hex)){
      c= hex.substring(1).split('');
      if(c.length== 3){
        c= [c[0], c[0], c[1], c[1], c[2], c[2]];
      }
      c= '0x'+c.join('');
      return 'rgba('+[(c>>16)&255, (c>>8)&255, c&255].join(',')+',0.3)';
    }
  }
  else {
  	return rgb.replace(')', ', 0.3)').replace('rgb', 'rgba');
  }
  throw new Error('Bad Hex');
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
.SPChartTooltipsR_container .labelTP{  white-space: nowrap;
  overflow: visible !important;
  font-family: Open Sans, sans-serif;
  color: #0D0F12;
  text-decoration: none;
  text-transform: none;
  font-style: normal;
  font-weight: normal;
  font-size: 11px;
  text-align: left;
}
.SPChartTooltipsR_container {
  background-color:#FAFAFA;
}
.SPChartTooltipsR_portlet{
  position:relative;
  min-width:250px;
  height:100px;
}
.SPChartTooltipsR_portlet[Data-page="1"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet[Data-page="2"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet[Data-page="3"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet[Data-page="4"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet[Data-page="5"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet[Data-page="6"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet[Data-page="7"]{
  height:100px;
  width:100%;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelcategory_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  left:5px;
  bottom:81px;
  width:218px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelcategory_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labellat_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  bottom:65px;
  width:105px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labellat_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_catkey_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  bottom:65px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_catkey_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labeltarget2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:84px;
  bottom:65px;
  width:50px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labeltarget2_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labellng_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:120px;
  bottom:65px;
  width:105px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labellng_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelserie_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:5px;
  bottom:45px;
  width:150px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelserie_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_x_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:5px;
  bottom:50px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_x_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluehie_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  bottom:65px;
  width:65px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluehie_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_y_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:5px;
  bottom:35px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_y_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluedep2_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:20px;
  left:150px;
  bottom:65px;
  width:65px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluedep2_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_cls_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:80px;
  left:5px;
  bottom:5px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_cls_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelseriexyz_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  bottom:80px;
  width:150px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelseriexyz_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_z_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:5px;
  bottom:20px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_z_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .arrowRight_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:20px;
  left:62px;
  left:24.8%;
  right:173px;
  right:69.2%;
  width:auto;
  height:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .arrowRight_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:15px;
  font-size:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelkeyxyz_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  bottom:65px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelkeyxyz_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluez_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:160px;
  left:64.0%;
  right:25px;
  right:10.0%;
  width:auto;
  height:auto;
  min-height:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluez_ctrl {
  height:auto;
  min-height:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluez_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluex_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:5px;
  bottom:50px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluex_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluey_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:5px;
  bottom:35px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluey_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelmultikeyxyz_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:80px;
  left:5px;
  bottom:5px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelmultikeyxyz_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelrangexyz_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:65px;
  left:5px;
  bottom:20px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelrangexyz_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelname_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  bottom:80px;
  width:150px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelname_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelnamesub_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  bottom:65px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelnamesub_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluegeo_1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:160px;
  left:64.0%;
  right:25px;
  right:10.0%;
  width:auto;
  height:auto;
  min-height:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluegeo_1_ctrl {
  height:auto;
  min-height:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluegeo_1_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelseriegeo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:5px;
  bottom:50px;
  width:150px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelseriegeo_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvalue_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:40px;
  left:160px;
  bottom:45px;
  width:65px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvalue_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluegeo_2_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:35px;
  left:160px;
  bottom:50px;
  width:65px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluegeo_2_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelrange_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:59px;
  left:5px;
  bottom:26px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelrange_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelmultikeyvalue_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:77px;
  left:5px;
  bottom:8px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelmultikeyvalue_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelrangegeo_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:50px;
  left:5px;
  bottom:35px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelrangegeo_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelmultikeygeo_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:65px;
  left:5px;
  bottom:20px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelmultikeygeo_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelkey_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:22px;
  left:5px;
  bottom:63px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelkey_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .icon_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:230px;
  left:92.0%;
  right:6px;
  right:2.4%;
  width:auto;
  height:14px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .icon_ctrl {
  text-decoration:none;
  font-family:fontawesome-webfont;
  text-align:center;
  line-height:14px;
  font-size:14px;
  color:#000000;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .iconxyz_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:230px;
  left:92.0%;
  right:6px;
  right:2.4%;
  width:auto;
  height:14px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .iconxyz_ctrl {
  text-decoration:none;
  font-family:fontawesome-webfont;
  text-align:center;
  line-height:14px;
  font-size:14px;
  color:#000000;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .icongeo_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:5px;
  left:230px;
  left:92.0%;
  right:6px;
  right:2.4%;
  width:auto;
  height:14px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .icongeo_ctrl {
  text-decoration:none;
  font-family:fontawesome-webfont;
  text-align:center;
  line-height:14px;
  font-size:14px;
  color:#000000;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelsource_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  bottom:80px;
  width:50px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelsource_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labeltarget_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:84px;
  bottom:80px;
  width:50px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labeltarget_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluedep_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:5px;
  left:150px;
  bottom:80px;
  width:65px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelvaluedep_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .arrowLeft_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:5px;
  left:62px;
  left:24.8%;
  right:173px;
  right:69.2%;
  width:auto;
  height:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .arrowLeft_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:15px;
  font-size:15px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelsource2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:5px;
  bottom:65px;
  width:50px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelsource2_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelcategoryhie_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  bottom:80px;
  width:218px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelcategoryhie_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_cat_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  bottom:80px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labelclass_cat_ctrl {
  overflow:hidden;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labeldesc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:5px;
  bottom:80px;
  width:220px;
}
.SPChartTooltipsR_portlet > .SPChartTooltipsR_page > .labeldesc_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"100\",\"layout_steps_values\":{},\"pages_names\":\"category,xyz,geo,hie,dep,classif,marker\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"250\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"218\",\"x\":\"5\",\"y\":\"4\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"7\",\"type\":\"Label\",\"value\":\"\",\"w\":\"105\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"6\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"\",\"w\":\"50\",\"x\":\"84\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"7\",\"type\":\"Label\",\"value\":\"\",\"w\":\"105\",\"x\":\"120\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"150\",\"x\":\"5\",\"y\":\"40\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"6\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"4\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"2\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"6\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"50\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"150\",\"y\":\"20\",\"zindex\":\"2\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"6\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"80\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"150\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"6\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"65\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"page\":\"5\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"62\",\"y\":\"20\",\"zindex\":\"13\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"160\",\"y\":\"5\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"156\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"50\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"80\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"65\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"150\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"160\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"150\",\"x\":\"5\",\"y\":\"35\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"160\",\"y\":\"40\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"160\",\"y\":\"35\",\"zindex\":\"2\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"59\",\"zindex\":\"3\"},{\"align\":\"center\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"77\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"50\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"65\",\"zindex\":\"3\"},{\"align\":\"left\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"22\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"-28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"133\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"-5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"18\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"-28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"156\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"41\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"64\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"87\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"14\",\"x\":\"230\",\"y\":\"5\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"page\":\"2\",\"type\":\"Image\",\"w\":\"14\",\"x\":\"230\",\"y\":\"5\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"14\",\"layout_steps_values\":{},\"page\":\"3\",\"type\":\"Image\",\"w\":\"14\",\"x\":\"230\",\"y\":\"5\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"272\",\"y\":\"110\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"544\",\"y\":\"-28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"544\",\"y\":\"-5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"-5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"18\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"41\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"64\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"87\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"110\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"133\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"\",\"w\":\"50\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"\",\"w\":\"50\",\"x\":\"84\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"\",\"w\":\"65\",\"x\":\"150\",\"y\":\"5\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"15\",\"layout_steps_values\":{},\"page\":\"5\",\"type\":\"Image\",\"w\":\"15\",\"x\":\"62\",\"y\":\"5\",\"zindex\":\"13\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"\",\"w\":\"50\",\"x\":\"5\",\"y\":\"20\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"4\",\"type\":\"Label\",\"value\":\"\",\"w\":\"218\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"6\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"544\",\"y\":\"18\"},{\"align\":\"\",\"anchor\":\"top-left-bottom\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"7\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"5\",\"y\":\"5\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"544\",\"y\":\"41\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPChartTooltipsR","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPChartTooltipsR_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><link href='../<%=SPPrxycizer.proxycizedPath("fonts/OpenSans.css", SPPrxycizer.Mode.QUERYSTRING)%>' rel='stylesheet' type='text/css'>
<script>
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
<script src="../<%=SPPrxycizer.proxycizedPath("ZtChartFunctions.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPChartTooltipsR','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String labelcategory= "";
String labellat= "";
String labelclass_catkey= "";
String labeltarget2= "";
String labellng= "";
String labelserie= "";
String labelclass_x= "";
String labelvaluehie= "";
String labelclass_y= "";
String labelvaluedep2= "";
String labelclass_cls= "";
String labelseriexyz= "";
String labelclass_z= "";
String labelkeyxyz= "";
String labelvaluez= "";
String value2=JSPLib.translateXSS(sp.getParameter("value2",""));
String labelvaluex= "";
String labelvaluey= "";
String labelmultikeyxyz= "";
String labelrangexyz= "";
String labelname= "";
String labelnamesub= "";
String labelvaluegeo_1= "";
String labelseriegeo= "";
String labelvalue= "";
String labelvaluegeo_2= "";
String labelrange= "";
String labelmultikeyvalue= "";
String labelrangegeo= "";
String labelmultikeygeo= "";
String labelkey= "";
String category=JSPLib.translateXSS(sp.getParameter("category",""));
String serie=JSPLib.translateXSS(sp.getParameter("serie",""));
String value=JSPLib.translateXSS(sp.getParameter("value",""));
String range=JSPLib.translateXSS(sp.getParameter("range",""));
String key=JSPLib.translateXSS(sp.getParameter("key",""));
String type=JSPLib.translateXSS(sp.getParameter("type",""));
String color=JSPLib.translateXSS(sp.getParameter("color",""));
String multikey=JSPLib.translateXSS(sp.getParameter("multikey",""));
String id=JSPLib.translateXSS(sp.getParameter("id",""));
String cseries=JSPLib.translateXSS(sp.getParameter("cseries",""));
String xlabel=JSPLib.translateXSS(sp.getParameter("xlabel",""));
String ylabel=JSPLib.translateXSS(sp.getParameter("ylabel",""));
String x=JSPLib.translateXSS(sp.getParameter("x",""));
String y=JSPLib.translateXSS(sp.getParameter("y",""));
String z=JSPLib.translateXSS(sp.getParameter("z",""));
String name=JSPLib.translateXSS(sp.getParameter("name",""));
String namesub=JSPLib.translateXSS(sp.getParameter("namesub",""));
String source=JSPLib.translateXSS(sp.getParameter("source",""));
String target=JSPLib.translateXSS(sp.getParameter("target",""));
String labelsource= "";
String labeltarget= "";
String labelvaluedep= "";
String labelsource2= "";
String labelcategoryhie= "";
String labelclass_cat= "";
boolean isMarker=sp.getParameter("isMarker",false);
String labeldesc= "";
String multikeyvalue=JSPLib.translateXSS(sp.getParameter("multikeyvalue",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPChartTooltipsR_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPChartTooltipsR_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPChartTooltipsR','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPChartTooltipsR_page' style='display:block'>
<span id='<%=idPortlet%>_labelcategory'  formid='<%=idPortlet%>' ps-name='labelcategory'    class='labelTP labelcategory_ctrl'><div id='<%=idPortlet%>_labelcategorytbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelserie'  formid='<%=idPortlet%>' ps-name='labelserie'    class='labelTP labelserie_ctrl'><div id='<%=idPortlet%>_labelserietbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvalue'  formid='<%=idPortlet%>' ps-name='labelvalue'    class='labelTP labelvalue_ctrl'><div id='<%=idPortlet%>_labelvaluetbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelrange'  formid='<%=idPortlet%>' ps-name='labelrange'    class='labelTP labelrange_ctrl'><div id='<%=idPortlet%>_labelrangetbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelmultikeyvalue'  formid='<%=idPortlet%>' ps-name='labelmultikeyvalue'    class='labelTP labelmultikeyvalue_ctrl'><div id='<%=idPortlet%>_labelmultikeyvaluetbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelkey'  formid='<%=idPortlet%>' ps-name='labelkey'    class='labelTP labelkey_ctrl'><div id='<%=idPortlet%>_labelkeytbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_icon' class=' icon_ctrl'   target=''>&#xf02e;</a>
</div>
<div id='<%=idPortlet%>_page_2' class='SPChartTooltipsR_page' style='display:none'>
<span id='<%=idPortlet%>_labelseriexyz'  formid='<%=idPortlet%>' ps-name='labelseriexyz'    class='labelTP labelseriexyz_ctrl'><div id='<%=idPortlet%>_labelseriexyztbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelkeyxyz'  formid='<%=idPortlet%>' ps-name='labelkeyxyz'    class='labelTP labelkeyxyz_ctrl'><div id='<%=idPortlet%>_labelkeyxyztbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluez'  formid='<%=idPortlet%>' ps-name='labelvaluez'    class='labelTP labelvaluez_ctrl'><div id='<%=idPortlet%>_labelvalueztbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluex'  formid='<%=idPortlet%>' ps-name='labelvaluex'    class='labelTP labelvaluex_ctrl'><div id='<%=idPortlet%>_labelvaluextbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluey'  formid='<%=idPortlet%>' ps-name='labelvaluey'    class='labelTP labelvaluey_ctrl'><div id='<%=idPortlet%>_labelvalueytbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelmultikeyxyz'  formid='<%=idPortlet%>' ps-name='labelmultikeyxyz'    class='labelTP labelmultikeyxyz_ctrl'><div id='<%=idPortlet%>_labelmultikeyxyztbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelrangexyz'  formid='<%=idPortlet%>' ps-name='labelrangexyz'    class='labelTP labelrangexyz_ctrl'><div id='<%=idPortlet%>_labelrangexyztbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_iconxyz' class=' iconxyz_ctrl'   target=''>&#xf02e;</a>
</div>
<div id='<%=idPortlet%>_page_3' class='SPChartTooltipsR_page' style='display:none'>
<span id='<%=idPortlet%>_labelname'  formid='<%=idPortlet%>' ps-name='labelname'    class='labelTP labelname_ctrl'><div id='<%=idPortlet%>_labelnametbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelnamesub'  formid='<%=idPortlet%>' ps-name='labelnamesub'    class='labelTP labelnamesub_ctrl'><div id='<%=idPortlet%>_labelnamesubtbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluegeo_1'  formid='<%=idPortlet%>' ps-name='labelvaluegeo_1'    class='labelTP labelvaluegeo_1_ctrl'><div id='<%=idPortlet%>_labelvaluegeo_1tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelseriegeo'  formid='<%=idPortlet%>' ps-name='labelseriegeo'    class='labelTP labelseriegeo_ctrl'><div id='<%=idPortlet%>_labelseriegeotbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluegeo_2'  formid='<%=idPortlet%>' ps-name='labelvaluegeo_2'    class='labelTP labelvaluegeo_2_ctrl'><div id='<%=idPortlet%>_labelvaluegeo_2tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelrangegeo'  formid='<%=idPortlet%>' ps-name='labelrangegeo'    class='labelTP labelrangegeo_ctrl'><div id='<%=idPortlet%>_labelrangegeotbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelmultikeygeo'  formid='<%=idPortlet%>' ps-name='labelmultikeygeo'    class='labelTP labelmultikeygeo_ctrl'><div id='<%=idPortlet%>_labelmultikeygeotbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_icongeo' class=' icongeo_ctrl'   target=''>&#xf02e;</a>
</div>
<div id='<%=idPortlet%>_page_4' class='SPChartTooltipsR_page' style='display:none'>
<span id='<%=idPortlet%>_labelvaluehie'  formid='<%=idPortlet%>' ps-name='labelvaluehie'    class='labelTP labelvaluehie_ctrl'><div id='<%=idPortlet%>_labelvaluehietbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelcategoryhie'  formid='<%=idPortlet%>' ps-name='labelcategoryhie'    class='labelTP labelcategoryhie_ctrl'><div id='<%=idPortlet%>_labelcategoryhietbl' style='width:100%;'></div></span>
</div>
<div id='<%=idPortlet%>_page_5' class='SPChartTooltipsR_page' style='display:none'>
<span id='<%=idPortlet%>_labeltarget2'  formid='<%=idPortlet%>' ps-name='labeltarget2'    class='labelTP labeltarget2_ctrl'><div id='<%=idPortlet%>_labeltarget2tbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluedep2'  formid='<%=idPortlet%>' ps-name='labelvaluedep2'    class='labelTP labelvaluedep2_ctrl'><div id='<%=idPortlet%>_labelvaluedep2tbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_arrowRight' class='image-default arrowRight_ctrl'   target=''>&#xf167;</a>
<span id='<%=idPortlet%>_labelsource'  formid='<%=idPortlet%>' ps-name='labelsource'    class='labelTP labelsource_ctrl'><div id='<%=idPortlet%>_labelsourcetbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labeltarget'  formid='<%=idPortlet%>' ps-name='labeltarget'    class='labelTP labeltarget_ctrl'><div id='<%=idPortlet%>_labeltargettbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelvaluedep'  formid='<%=idPortlet%>' ps-name='labelvaluedep'    class='labelTP labelvaluedep_ctrl'><div id='<%=idPortlet%>_labelvaluedeptbl' style='width:100%;'></div></span>
<a id='<%=idPortlet%>_arrowLeft' class='image-default arrowLeft_ctrl'   target=''>&#xf168;</a>
<span id='<%=idPortlet%>_labelsource2'  formid='<%=idPortlet%>' ps-name='labelsource2'    class='labelTP labelsource2_ctrl'><div id='<%=idPortlet%>_labelsource2tbl' style='width:100%;'></div></span>
</div>
<div id='<%=idPortlet%>_page_6' class='SPChartTooltipsR_page' style='display:none'>
<span id='<%=idPortlet%>_labelclass_catkey'  formid='<%=idPortlet%>' ps-name='labelclass_catkey'    class='labelTP labelclass_catkey_ctrl'><div id='<%=idPortlet%>_labelclass_catkeytbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelclass_x'  formid='<%=idPortlet%>' ps-name='labelclass_x'    class='labelTP labelclass_x_ctrl'><div id='<%=idPortlet%>_labelclass_xtbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelclass_y'  formid='<%=idPortlet%>' ps-name='labelclass_y'    class='labelTP labelclass_y_ctrl'><div id='<%=idPortlet%>_labelclass_ytbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelclass_cls'  formid='<%=idPortlet%>' ps-name='labelclass_cls'    class='labelTP labelclass_cls_ctrl'><div id='<%=idPortlet%>_labelclass_clstbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelclass_z'  formid='<%=idPortlet%>' ps-name='labelclass_z'    class='labelTP labelclass_z_ctrl'><div id='<%=idPortlet%>_labelclass_ztbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labelclass_cat'  formid='<%=idPortlet%>' ps-name='labelclass_cat'    class='labelTP labelclass_cat_ctrl'><div id='<%=idPortlet%>_labelclass_cattbl' style='width:100%;'></div></span>
</div>
<div id='<%=idPortlet%>_page_7' class='SPChartTooltipsR_page' style='display:none'>
<span id='<%=idPortlet%>_labellat'  formid='<%=idPortlet%>' ps-name='labellat'    class='labelTP labellat_ctrl'><div id='<%=idPortlet%>_labellattbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labellng'  formid='<%=idPortlet%>' ps-name='labellng'    class='labelTP labellng_ctrl'><div id='<%=idPortlet%>_labellngtbl' style='width:100%;'></div></span>
<span id='<%=idPortlet%>_labeldesc'  formid='<%=idPortlet%>' ps-name='labeldesc'    class='labelTP labeldesc_ctrl'><div id='<%=idPortlet%>_labeldesctbl' style='width:100%;'></div></span>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPChartTooltipsR');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPChartTooltipsR_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("category"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("xyz"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page3', element:'<%=idPortlet%>_page_3',caption:'<%=JSPLib.ToJSValue(sp.translate("geo"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page4', element:'<%=idPortlet%>_page_4',caption:'<%=JSPLib.ToJSValue(sp.translate("hie"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page5', element:'<%=idPortlet%>_page_5',caption:'<%=JSPLib.ToJSValue(sp.translate("dep"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page6', element:'<%=idPortlet%>_page_6',caption:'<%=JSPLib.ToJSValue(sp.translate("classif"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page7', element:'<%=idPortlet%>_page_7',caption:'<%=JSPLib.ToJSValue(sp.translate("marker"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPChartTooltipsR',["250","250","250","250","250","250","250"],["100"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','true',{},false,false,7,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"250","h":"100","title":"category","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"250","h":"100","title":"xyz","layer":"false","npage":"2"},{"layout_steps_values":{},"w":"250","h":"100","title":"geo","layer":"false","npage":"3"},{"layout_steps_values":{},"w":"250","h":"100","title":"hie","layer":"false","npage":"4"},{"layout_steps_values":{},"w":"250","h":"100","title":"dep","layer":"false","npage":"5"},{"layout_steps_values":{},"w":"250","h":"100","title":"classif","layer":"false","npage":"6"},{"layout_steps_values":{},"w":"250","h":"100","title":"marker","layer":"false","npage":"7"}]);
this.labelcategory=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelcategory","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelcategory","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelcategory,false,true)%>","type":"Label","w":218,"x":5,"y":4,"zindex":"1"});
this.labellat=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labellat","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labellat","nowrap":"false","page":7,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labellat,false,true)%>","type":"Label","w":105,"x":5,"y":20,"zindex":"1"});
this.labelclass_catkey=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelclass_catkey","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelclass_catkey","nowrap":"false","page":6,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelclass_catkey,false,true)%>","type":"Label","w":220,"x":5,"y":20,"zindex":"1"});
this.labeltarget2=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labeltarget2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labeltarget2","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labeltarget2,false,true)%>","type":"Label","w":50,"x":84,"y":20,"zindex":"1"});
this.labellng=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labellng","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labellng","nowrap":"false","page":7,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labellng,false,true)%>","type":"Label","w":105,"x":120,"y":20,"zindex":"1"});
this.labelserie=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelserie","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelserie","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelserie,false,true)%>","type":"Label","w":150,"x":5,"y":40,"zindex":"1"});
this.labelclass_x=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelclass_x","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelclass_x","nowrap":"false","page":6,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelclass_x,false,true)%>","type":"Label","w":220,"x":5,"y":35,"zindex":"1"});
this.labelvaluehie=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluehie","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluehie","nowrap":"false","page":4,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluehie,false,true)%>","type":"Label","w":65,"x":5,"y":20,"zindex":"2"});
this.labelclass_y=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelclass_y","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelclass_y","nowrap":"false","page":6,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelclass_y,false,true)%>","type":"Label","w":220,"x":5,"y":50,"zindex":"1"});
this.labelvaluedep2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluedep2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluedep2","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluedep2,false,true)%>","type":"Label","w":65,"x":150,"y":20,"zindex":"2"});
this.labelclass_cls=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelclass_cls","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelclass_cls","nowrap":"false","page":6,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelclass_cls,false,true)%>","type":"Label","w":220,"x":5,"y":80,"zindex":"1"});
this.labelseriexyz=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelseriexyz","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelseriexyz","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelseriexyz,false,true)%>","type":"Label","w":150,"x":5,"y":5,"zindex":"1"});
this.labelclass_z=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelclass_z","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelclass_z","nowrap":"false","page":6,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelclass_z,false,true)%>","type":"Label","w":220,"x":5,"y":65,"zindex":"1"});
this.arrowRight=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default arrowRight_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_arrowRight","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf167;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"arrowRight","page":5,"path_type":"","server_side":"","spuid":"","src":"&#xf167;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":62,"y":20,"zindex":"13"});
 ZtVWeb.RequireFont("icons8_win10","");
this.labelkeyxyz=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelkeyxyz","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelkeyxyz","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelkeyxyz,false,true)%>","type":"Label","w":220,"x":5,"y":20,"zindex":"1"});
this.labelvaluez=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluez","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluez","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluez,false,true)%>","type":"Label","w":65,"x":160,"y":5,"zindex":"1"});
this.value2=new ZtVWeb._VC(this,'value2',null,'character','<%=JSPLib.ToJSValue(value2,false,true)%>',false,false);
this.labelvaluex=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluex","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluex","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluex,false,true)%>","type":"Label","w":220,"x":5,"y":35,"zindex":"1"});
this.labelvaluey=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluey","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluey","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluey,false,true)%>","type":"Label","w":220,"x":5,"y":50,"zindex":"1"});
this.labelmultikeyxyz=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelmultikeyxyz","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelmultikeyxyz","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelmultikeyxyz,false,true)%>","type":"Label","w":220,"x":5,"y":80,"zindex":"1"});
this.labelrangexyz=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelrangexyz","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelrangexyz","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelrangexyz,false,true)%>","type":"Label","w":220,"x":5,"y":65,"zindex":"1"});
this.labelname=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelname","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelname","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelname,false,true)%>","type":"Label","w":150,"x":5,"y":5,"zindex":"1"});
this.labelnamesub=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelnamesub","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelnamesub","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelnamesub,false,true)%>","type":"Label","w":220,"x":5,"y":20,"zindex":"1"});
this.labelvaluegeo_1=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluegeo_1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluegeo_1","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluegeo_1,false,true)%>","type":"Label","w":65,"x":160,"y":5,"zindex":"1"});
this.labelseriegeo=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelseriegeo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelseriegeo","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelseriegeo,false,true)%>","type":"Label","w":150,"x":5,"y":35,"zindex":"1"});
this.labelvalue=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvalue","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvalue","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvalue,false,true)%>","type":"Label","w":65,"x":160,"y":40,"zindex":"2"});
this.labelvaluegeo_2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluegeo_2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluegeo_2","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluegeo_2,false,true)%>","type":"Label","w":65,"x":160,"y":35,"zindex":"2"});
this.labelrange=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelrange","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelrange","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelrange,false,true)%>","type":"Label","w":220,"x":5,"y":59,"zindex":"3"});
this.labelmultikeyvalue=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelmultikeyvalue","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelmultikeyvalue","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelmultikeyvalue,false,true)%>","type":"Label","w":220,"x":5,"y":77,"zindex":"3"});
this.labelrangegeo=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelrangegeo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelrangegeo","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelrangegeo,false,true)%>","type":"Label","w":220,"x":5,"y":50,"zindex":"3"});
this.labelmultikeygeo=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelmultikeygeo","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelmultikeygeo","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelmultikeygeo,false,true)%>","type":"Label","w":220,"x":5,"y":65,"zindex":"3"});
this.labelkey=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelkey","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelkey","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelkey,false,true)%>","type":"Label","w":220,"x":5,"y":22,"zindex":"4"});
this.category=new ZtVWeb._VC(this,'category',null,'character','<%=JSPLib.ToJSValue(category,false,true)%>',false,false);
this.serie=new ZtVWeb._VC(this,'serie',null,'character','<%=JSPLib.ToJSValue(serie,false,true)%>',false,false);
this.value=new ZtVWeb._VC(this,'value',null,'character','<%=JSPLib.ToJSValue(value,false,true)%>',false,false);
this.range=new ZtVWeb._VC(this,'range',null,'character','<%=JSPLib.ToJSValue(range,false,true)%>',false,false);
this.key=new ZtVWeb._VC(this,'key',null,'character','<%=JSPLib.ToJSValue(key,false,true)%>',false,false);
this.type=new ZtVWeb._VC(this,'type',null,'character','<%=JSPLib.ToJSValue(type,false,true)%>',false,false);
this.color=new ZtVWeb._VC(this,'color',null,'character','<%=JSPLib.ToJSValue(color,false,true)%>',false,false);
this.multikey=new ZtVWeb._VC(this,'multikey',null,'character','<%=JSPLib.ToJSValue(multikey,false,true)%>',false,false);
this.id=new ZtVWeb._VC(this,'id',null,'character','<%=JSPLib.ToJSValue(id,false,true)%>',false,false);
this.icon=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":" icon_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_icon","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xf02e;","font_image_hover":"","font_name":"fontawesome-webfont","font_path":"","font_size":"14","h":14,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"icon","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xf02e;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":14,"x":230,"y":5,"zindex":"5"});
 ZtVWeb.RequireFont("fontawesome-webfont","");
this.iconxyz=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":" iconxyz_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_iconxyz","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xf02e;","font_image_hover":"","font_name":"fontawesome-webfont","font_path":"","font_size":"14","h":14,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"iconxyz","page":2,"path_type":"","server_side":"","spuid":"","src":"&#xf02e;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":14,"x":230,"y":5,"zindex":"5"});
 ZtVWeb.RequireFont("fontawesome-webfont","");
this.icongeo=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":" icongeo_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_icongeo","edit_undercond":"","field":"","font_color":"#000000","font_color_hover":"","font_image":"&#xf02e;","font_image_hover":"","font_name":"fontawesome-webfont","font_path":"","font_size":"14","h":14,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"icongeo","page":3,"path_type":"","server_side":"","spuid":"","src":"&#xf02e;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":14,"x":230,"y":5,"zindex":"5"});
 ZtVWeb.RequireFont("fontawesome-webfont","");
this.cseries=new ZtVWeb._VC(this,'cseries',null,'character','<%=JSPLib.ToJSValue(cseries,false,true)%>',false,false);
this.xlabel=new ZtVWeb._VC(this,'xlabel',null,'character','<%=JSPLib.ToJSValue(xlabel,false,true)%>',false,false);
this.ylabel=new ZtVWeb._VC(this,'ylabel',null,'character','<%=JSPLib.ToJSValue(ylabel,false,true)%>',false,false);
this.x=new ZtVWeb._VC(this,'x',null,'character','<%=JSPLib.ToJSValue(x,false,true)%>',false,false);
this.y=new ZtVWeb._VC(this,'y',null,'character','<%=JSPLib.ToJSValue(y,false,true)%>',false,false);
this.z=new ZtVWeb._VC(this,'z',null,'character','<%=JSPLib.ToJSValue(z,false,true)%>',false,false);
this.name=new ZtVWeb._VC(this,'name',null,'character','<%=JSPLib.ToJSValue(name,false,true)%>',false,false);
this.namesub=new ZtVWeb._VC(this,'namesub',null,'character','<%=JSPLib.ToJSValue(namesub,false,true)%>',false,false);
this.source=new ZtVWeb._VC(this,'source',null,'character','<%=JSPLib.ToJSValue(source,false,true)%>',false,false);
this.target=new ZtVWeb._VC(this,'target',null,'character','<%=JSPLib.ToJSValue(target,false,true)%>',false,false);
this.labelsource=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelsource","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelsource","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelsource,false,true)%>","type":"Label","w":50,"x":5,"y":5,"zindex":"1"});
this.labeltarget=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labeltarget","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labeltarget","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labeltarget,false,true)%>","type":"Label","w":50,"x":84,"y":5,"zindex":"1"});
this.labelvaluedep=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelvaluedep","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelvaluedep","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelvaluedep,false,true)%>","type":"Label","w":65,"x":150,"y":5,"zindex":"2"});
this.arrowLeft=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default arrowLeft_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_arrowLeft","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xf168;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":15,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"arrowLeft","page":5,"path_type":"","server_side":"","spuid":"","src":"&#xf168;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":15,"x":62,"y":5,"zindex":"13"});
 ZtVWeb.RequireFont("icons8_win10","");
this.labelsource2=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelsource2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelsource2","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelsource2,false,true)%>","type":"Label","w":50,"x":5,"y":20,"zindex":"1"});
this.labelcategoryhie=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelcategoryhie","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelcategoryhie","nowrap":"false","page":4,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelcategoryhie,false,true)%>","type":"Label","w":218,"x":5,"y":5,"zindex":"1"});
this.labelclass_cat=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labelclass_cat","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelclass_cat","nowrap":"false","page":6,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelclass_cat,false,true)%>","type":"Label","w":220,"x":5,"y":5,"zindex":"1"});
this.isMarker=new ZtVWeb._VC(this,'isMarker',null,'logic',<%=isMarker%>,false,false);
this.labeldesc=new ZtVWeb._LC(this,{"align":"","anchor":"top-left-bottom","assoc_input":"","calculate":"","class_Css":"labelTP","create_undercond":"","ctrlid":"<%=idPortlet%>_labeldesc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labeldesc","nowrap":"false","page":7,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labeldesc,false,true)%>","type":"Label","w":220,"x":5,"y":5,"zindex":"1"});
this.multikeyvalue=new ZtVWeb._VC(this,'multikeyvalue',null,'character','<%=JSPLib.ToJSValue(multikeyvalue,false,true)%>',false,false);
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
<%if(request.getAttribute("SPChartTooltipsR_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPChartTooltipsR_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPChartTooltipsR_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.arrowRight.dispatchEvent('OnLoad');
window.<%=idPortlet%>.icon.dispatchEvent('OnLoad');
window.<%=idPortlet%>.iconxyz.dispatchEvent('OnLoad');
window.<%=idPortlet%>.icongeo.dispatchEvent('OnLoad');
window.<%=idPortlet%>.arrowLeft.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','SPChartTooltipsR',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPChartTooltipsR');
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
sp.endPage("SPChartTooltipsR");
}%>
<%! public String getJSPUID() { return "2354677061"; } %>