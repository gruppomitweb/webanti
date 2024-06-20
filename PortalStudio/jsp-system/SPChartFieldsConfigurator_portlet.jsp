<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  document.getElementById(this.formid + \"_tabcontainer\").style.display = \"none\";\n  this._isloaded = true;\n  var tptl = this.getTitlePortlet();\n  if (!Empty(this.ptlwizard.Value())) {\n    tptl.Ctrl_container.style.display = \"none\";\n  }\n  else {\n    var _this = this;\n    tptl.toolbar.Append({\tid: \"apply\",\n                          title: FormatMsg(\"RPT_APPLY\"),\n                          tooltip: FormatMsg(\"RPT_APPLY\"),\n                          action: function () { _this.returnFieldsConfiguration(); },\n                          image: {\tFontName: \"icons8_win10\",\n                          \t        Size: 24,\n                                    Char: parseInt(\"ef8b\",16),\n                                    FontWeight: \"normal\"\n                                 }\n                        });\n  }\n  \n  this._isloaded = false;\n  if (!CharToBool(this.isdataobj.Value() + \"\")) {\n  \tthis._Loaded();\n    this.ZtTabs.Select(\"page1\");\n  }\n  else {\n    tptl.SetTitle(\"Query fields\");\n    tptl.SetSubTitle(\"Choose field to insert in chart property\");\n    this._Load2();\n    this.ZtTabs.Select(\"page2\");\n  }\n}\n\nvar rows_check = [];\nfunction _Load2() {\n\tvar fields_array = GetOpener().GetFieldsForChart(this.vqr.Value()),\n      data = [],\n      val_array = this.values.Value().split(\",\");\n  for (var i = 0; i \u003c fields_array[0].length; i++) {\n  \tdata.push([fields_array[0][i], fields_array[1][i]]);\n    if (val_array.indexOf(fields_array[0][i]) \u003e= 0)\n      rows_check.push(i);\n  }\n  this.dataobj_fields.FillData(data);\n}\n\nfunction Grid30_Rendered(){\n  for (var i = 0; i \u003c rows_check.length; i++) {\n    this.Grid30.CurrRow(rows_check[i])\n  \tthis.Grid30.RowChecked(true)\n  }\n}\n\n\nfunction _Loaded() {\n  \u002f\u002f variabili di lavoro\n  this.queryFields = [];\n  this.snames = \"\";\n  this.isDemo = true;\n  this._startDrag = false;\n  this.showparms = false;\n\n\tthis.hideAllBoxes();\n  this.initChart();\n  this.initData();\n}\n\nfunction initFields() {\n  var _this = this;\n  setTimeout( function () {\n    var ctype = _this.chartfields.chart_type;\n    if (!Empty(_this.domain.Value()))\n      _this.domainfield_Drop({value : _this.domain.Value()});\n    if (!Empty(_this.values.Value())) {\n      if (ctype != \"category\" && ctype != \"measure\")\n        _this.valuesfields_Drop({value : _this.values.Value()});\n      else {\n        var vfs = _this.values.Value().split(\",\");\n        _this.values.Value(\"\");\n        for (var i = 0; i \u003c vfs.length; i++) {\n          _this.valuesfields_Drop({value : vfs[i], type : \"N\"});\n        }\n      }\n    }\n    if (!Empty(_this.z.Value()))\n      _this.zfield_Drop({value : _this.z.Value(), type : \"N\"});\n    if (!Empty(_this.series.Value()))\n      _this.seriesfield_Drop({value : _this.series.Value()});\n    if (!Empty(_this.key.Value())) {\n      if (ctype != \"category\" && ctype != \"measure\")\n        _this.skeyfield_Drop({value : _this.key.Value()});\n      else\n        _this.keyfield_Drop({value : _this.key.Value()});\n    }\n  }, 10);\n}\n\nfunction hideAllBoxes() {\n  \u002f\u002f chart\n  this.chartfields.Hide();\n  \u002f\u002f fieldbox\n  this.fieldbox.Hide();\n  this.fieldboxtitle.Hide();\n  \u002f\u002f fields\n\tthis.lblDomainField.Hide();\n  this.lblCDomainField.Hide();\n  this.lblKeyField.Hide();\n  this.lblSeriesField.Hide();\n  this.lblSKeyField.Hide();\n  this.lblValuesField.Hide();\n  this.lblZField.Hide();\n  this.domainfield.Hide();\n  this.keyfield.Hide();\n  this.seriesfield.Hide();\n  this.skeyfield.Hide();\n  this.valuesfields.Hide();\n  this.zfield.Hide();\n}\n\nfunction initChart() {\n  if (this.frompreview.Value()) {\n    if (GetOpener() && GetOpener().ZtVWeb) {\n      var ptlprev = GetOpener().ZtVWeb.getPortletWindow(\"SPChartPreview\");\n  \t\tthis.chartfields.chartConfig = ptlprev.getPreviewChartConfig();\n    }\n  }\n  else if (!Empty(this.ptlwizard.Value())) {\n\t\tif (window.parent && window.parent.ZtVWeb) {\n      var pobj = window.parent.ZtVWeb.getPortletById(this.ptlwizard.Value());\n      if (pobj && pobj.getChartConfigurationObject)\n      \tthis.chartfields.chartConfig = pobj.getChartConfigurationObject();\n    }\n  }\n  else if (!Empty(this.defname.Value())) {\n  \tthis.chartfields.SetChartDef(this.defname.Value());\n  \tthis.chartfields._loadDefAndSetCConfig();\n  }\n  \n  if (this.chartfields.chartConfig) {\n    this.chartfields.chart_type = getZFChartMacroType(this.chartfields.chartConfig.graphSettings.chartType);\n    this.chartfields.chartConfig.globalSettings.width = this.chartfields.w;\n    this.chartfields.chartConfig.globalSettings.height = this.chartfields.h;\n    this.setDatasetToChart();\n  }\n}\n\nfunction setDatasetToChart() {\n  this.chartfields.Show();\n  var fwiz = !Empty(this.ptlwizard.Value()) && Empty(this.chartfields.propertyValue);\n  if ((Empty(this.ptlwizard.Value()) && (Empty(this.vqr.Value()) || !this.checkFieldsForChart(this.chartfields.chart_type))) || fwiz) {\n    this.chartfields.gendataset = true;\n    this.chartfields.propertyValue = getDatasetDemo(this.chartfields.chart_type);\n    if (this.chartfields.chart_type == \"category\" || this.chartfields.chart_type == \"measure\")\n      this.chartfields.setFieldsCategoryChart(\"COD\", \"RA1,RA2,RA3\", \"Rappresentante area 1,Rappresentante area 2,Rappresentante area 3\");\n    else if (this.chartfields.chart_type == \"xyz\")\n      this.chartfields.SetFieldsXYZChart(\"x_fld\", \"y_fld\", \"z_fld\", \"serie_fld\");\n    else \u002f\u002f geo\n      this.chartfields.SetFieldsGeoChart(\"CNT\", \"\", \"VAL\", \"WHO\", \"0\");\n    delete this.chartfields.ztChart;\n  \tthis.chartfields._drawChart();\n  }\n  else if (Empty(this.ptlwizard.Value())){\n    this.chartfields.gendataset = false;\n    if (this.chartfields.chart_type == \"category\" || this.chartfields.chart_type == \"measure\")\n      this.chartfields.setFieldsCategoryChart(this.domain.Value(), this.values.Value(), this.snames, this.key.Value());\n    else if (this.chartfields.chart_type == \"xyz\")\n      this.chartfields.SetFieldsXYZChart(this.domain.Value(), this.values.Value(), this.z.Value(), this.series.Value(), this.key.Value());\n    else \u002f\u002f geo\n      this.chartfields.SetFieldsGeoChart(this.domain.Value(), \"\", this.values.Value(), this.series.Value(), \"0\");\n    this.SQLDataobj.Query();\n  }\n}\n\nfunction checkFieldsForChart(type) {\n  var evret = false;\n\tif (type == \"category\" || type == \"measure\" || type == \"geo\")\n    evret = !Empty(this.domain.Value()) && !Empty(this.values.Value());\n  else \u002f\u002f if (type == \"xyz\")\n    evret = !Empty(this.domain.Value()) && !Empty(this.values.Value()) && !Empty(this.series.Value());\n\treturn evret;\n}\n\nfunction initData(){\n  if (!Empty(this.ptlwizard.Value())) {\n    if (window.parent && window.parent.ZtVWeb) {\n    \tvar pobj = window.parent.ZtVWeb.getPortletById(this.ptlwizard.Value());\n      if (pobj && pobj.getFields)\n      \tthis.queryFields = JSON.parse(pobj.getFields());\n      if (!Empty(this.queryFields)) {\n        this.fieldbox.Show();\n    \t\tthis.fieldboxtitle.Show();\n      }\n    }\n  }\n  else {\n    if (Empty(this.vqr.Value())) {\n      this.hideAllBoxes();\n      return;\n    }\n    this.fieldbox.Show();\n    this.fieldboxtitle.Show();\n    this.updateSQLCtrl();\n    this.queryFields = getQueryFields(this.vqr.Value());\n  }\n  this.addDatasourceFields(this.queryFields);\n  this.loadFieldBoxes();\n  if (this._isloaded)\n    this.initFields();\n}\n\nfunction updateSQLCtrl(onlyparms) {\n  this.SQLDataobj.ChangeQuery(this.vqr.Value());\n  this.SQLDataobj.parms = getQueryParams(this.parms.Value());\n}\n\nfunction addDatasourceFields(fieldsArr){\n  var fields = this.manageFieldsArray(fieldsArr);\n  this.fieldbox.Ctrl.innerHTML = \"\";\n  console.log(fields)\n  var bh = 460;\n  var isLong = (21*fields.length)\u003ebh;\n  var div, elem;\n\n  \u002f\u002f creo e disegno i campi\n  div = document.createElement(\"div\");\n  div.id = this.formid+\"maskFrameFldsCont\";\n  div.className = \"unselectable maskfldContainer\";\n\n  if(!isLong)\n    div.style.overflow = \"hidden\";\n\n  for(var i=0; i\u003cfields.length; i++){\n    elem = this.drawField(fields[i],this.formid,isLong);\n    elem.setAttribute(\"formid\", this.formid);\n    elem.setAttribute(\"ps-name\", \"fieldbox_\" + fields[i].alias);\n    elem.setAttribute(\"data-transfer\", \"allfield\");\n    elem.setAttribute(\"field-type\", fields[i].type);\n    div.appendChild(elem);\n    \n    window[this.formid][\"fieldbox_\" + fields[i].alias] = {\n      fieldId : fields[i].alias,\n      fieldType : fields[i].type,\n      fielddesc : fields[i].desc,\n      formid : this.formid,\n      getDragObj : function () {\n        if (!this.DraggerObj) {\u002f\u002f Oggetto drag data generico\n          this.DraggerObj = { value : this.fieldId, type : this.fieldType };\n        }\n        return this.DraggerObj;\n      },\n     \tDragCancel : function () { },\n      DragEnter : function () { \n        window[this.formid]._startDrag = true;\n        window[this.formid][this.field].Show();\n      },\n      DragLeave : function () { }\n    };\n  }\n  \n  this.fieldbox.Ctrl.appendChild(div);\n  ZtVWeb.DragDropHtml5.initEvents(this.formid);\n}\n\nfunction manageFieldsArray(fieldsArr) {\n  if (Empty(fieldsArr))\n    return [];\n\tvar otype = Object.prototype.toString.call(fieldsArr[0]);\n  if (otype === \"[object Object]\")\n    return fieldsArr;\n  \u002f\u002f tipo [ [alias],[desc],[type] ]\n  var rflds = [];\n  for (var i = 0; i \u003c fieldsArr[0].length; i++) {\n    var f = {};\n    f.alias = fieldsArr[0][i];\n    f.desc = Empty(fieldsArr[1][i]) ? fieldsArr[0][i] : fieldsArr[1][i];\n    f.alias = fieldsArr[2][i];\n    rflds.push(f);\n  }\n  return rflds;\n}\n\nfunction drawField(fobj,pid,isLong,wColor,idx){\n  var elem = document.createElement(\"div\");\n  elem.id = pid+\"field_\"+fobj.alias;\n  elem.className = \"label labelfieldbox\";\n  elem.draggable = true;\n  if(isLong)\n    elem.className+=\" maskfieldObjectLong\";\n\n  var econt = document.createElement(\"div\");\n  econt.className = \"labelfieldcont\";\n  elem.appendChild(econt);\n  \n\tvar elem2 = document.createElement(\"div\");\n  elem2.className = \"fielddesc\";\n  if(isLong)\n    elem2.className+=\" maskfieldObjectDescLong\";\n  if(fobj.desc.length\u003e=22)\n    elem2.textContent = fobj.desc.substring(0,18)+\"...\";\n  else\n    elem2.textContent = fobj.desc;\n  econt.appendChild(elem2);\n  \n  elem2 = document.createElement(\"div\");\n  elem2.className = \"fieldalias\";\n\u002f\u002f  if(isLong)\n \u002f\u002f   elem2.className+=\" maskfieldObjectDescLong\";\n  elem2.textContent = fobj.alias;\n  econt.appendChild(elem2);\n\n    elem2 = document.createElement(\"div\");\n    elem2.className = \"fieldicon\";\n  elem2.textContent = String.fromCharCode(parseInt(getFieldTypeIcon(fobj.type), 16));\n    \n    elem.appendChild(elem2);\n\n  return elem;\n}\n\nfunction loadFieldBoxes() {\n\tif (this.chartfields.chart_type == \"category\" || this.chartfields.chart_type == \"measure\") {\n    this.lblDomainField.Show();\n    this.lblKeyField.Show();\n    this.lblValuesField.Show();\n    this.domainfield.Show();\n    this.keyfield.Show();\n    this.valuesfields.Show();\n  }\n  else if (this.chartfields.chart_type == \"xyz\") {\n    this.lblDomainField.Show();\n    this.lblValuesField.Show();\n    this.lblZField.Show();\n    this.lblSKeyField.Show();\n    this.lblSeriesField.Show();\n    this.domainfield.Show();\n    this.valuesfields.Show();\n    this.zfield.Show();\n    this.skeyfield.Show();\n    this.seriesfield.Show();\n  }\n  else {\t\u002f\u002fgeo\n    this.lblCDomainField.Show();\n    this.lblValuesField.Show();\n    this.lblSeriesField.Show();\n    this.domainfield.Show();\n    this.valuesfields.Show();\n    this.seriesfield.Show();\n  }\n}\n\nfunction getFieldTypeIcon(type) {\n  var code = \"\";\n\tswitch (type) {\n    case \"C\":\n      code = \"eea1\";\n      break;\n    case \"M\":\n      code = \"ee04\";\n      break;\n    case \"N\":\n      code = \"f0e9\";\n      break;\n    case \"L\":\n      code = \"f788\";\n      break;\n    case \"D\":\n      code = \"f20f\";\n      break;\n    case \"T\":\n      code = \"e973\";\n      break;\n    case \"remove\":\n      code = \"ed93\";\n      break;\n  }\n  return code;\n}\n\n\u002f** generica x drag and drop **\u002f\nfunction genericDragDropField(alias, ctrlObj, ctrlVar, acceptType) {\n  var fieldDrag = document.getElementById(this.formid + \"field_\" + alias);\n  if (!fieldDrag)\n    return;\n  var pos = { top : ctrlObj.Ctrl.offsetTop, left : ctrlObj.Ctrl.offsetLeft };\n  ctrlObj.Hide();\n  \n  var ctrlDrag = fieldDrag.cloneNode();\n  ctrlDrag.id = ctrlDrag.id + \"_drag\";\n  ctrlDrag.innerHTML = fieldDrag.innerHTML;\n  ctrlDrag.style.position = \"absolute\";\n  ctrlDrag.style.top = pos.top + \"px\";\n  ctrlDrag.style.left = pos.left + \"px\";\n  ctrlObj.Ctrl.parentNode.appendChild(ctrlDrag);\n  ctrlObj.Ctrl.parentNode.insertBefore(ctrlDrag, ctrlObj.Ctrl);\n  \n  ctrlDrag.onmouseover = fielddrop_mouseover;\n  ctrlDrag.onmouseout = fielddrop_mouseout;\n  ctrlDrag.lastChild.onclick = fielddrop_click;\n  ctrlDrag.style.cursor = \"default\";\n\n  \u002f\u002f nascondo dalla lista\n  fieldDrag.style.display = \"none\";\n  \n  \u002f\u002f rimpiazzo eventuale sostituzione\n  if (!Empty(ctrlVar.Value()) && ctrlVar.Value() != alias) {\t\u002f\u002f gia' presente un campo\n    \u002f\u002f rimuovo campo\n    var oldField = document.getElementById(this.formid + \"field_\" + ctrlVar.Value() + \"_drag\");\n    if (oldField)\n    \toldField.parentNode.removeChild(oldField);\n    oldField = document.getElementById(this.formid + \"field_\" + ctrlVar.Value());\n    if (oldField)\n      oldField.style.display = \"block\";\n  }\n  \n  ctrlDrag.setAttribute(\"data-transfer-accept\", acceptType);\n  ZtVWeb.DragDropHtml5.initEvents(this.formid);\n  ctrlVar.Value(alias);\n  \n  this._startDrag = false;\n  \n  this.setDatasetToChart();\n}\n\nfunction valuesDragDropField(alias, ctrlObj, ctrlVar, acceptType) {\n  var fieldDrag = document.getElementById(this.formid + \"field_\" + alias);\n  if (!fieldDrag)\n    return;\n  var pos = { top : ctrlObj.Ctrl.offsetTop, left : ctrlObj.Ctrl.offsetLeft };\n\n  var ctrlDrag = fieldDrag.cloneNode();\n  ctrlDrag.id = ctrlDrag.id + \"_drag\";\n  ctrlDrag.innerHTML = fieldDrag.innerHTML;\n  ctrlDrag.style.position = \"absolute\";\n  ctrlDrag.style.top = pos.top + \"px\";\n  ctrlDrag.style.left = pos.left + \"px\";\n  ctrlObj.Ctrl.parentNode.appendChild(ctrlDrag);\n  ctrlObj.Ctrl.parentNode.insertBefore(ctrlDrag, ctrlObj.Ctrl);\n  \n  ctrlObj.Ctrl.style.top = (pos.top + ctrlDrag.offsetHeight) + \"px\";\n  ctrlObj.topposition = pos.top + ctrlDrag.offsetHeight;\n  \n  ctrlDrag.onmouseover = fielddrop_mouseover;\n  ctrlDrag.onmouseout = fielddrop_mouseout;\n  ctrlDrag.lastChild.onclick = fielddrop_click;\n  ctrlDrag.style.cursor = \"default\";\n\n  \u002f\u002f nascondo dalla lista\n  fieldDrag.style.display = \"none\";\n\t\n  \u002f\u002f aggiungo campo separato da ','\n  var old_val = \"\";\n  if (!Empty(ctrlVar.Value()))\n    old_val = ctrlVar.Value() + \",\";\n  ctrlVar.Value(old_val + alias);\n  old_val = \"\";\n  if (!Empty(this.snames))\n    old_val = this.snames + \",\";\n  this.snames = old_val + window[this.formid][\"fieldbox_\" + alias].fielddesc;\n  \n  this._startDrag = false;\n  \n  this.setDatasetToChart();\n}\n\nfunction genericDragLeave(ctrlObj, ctrlVar) {\n\tif (!Empty(ctrlVar.Value()) && this._startDrag) {\n    ctrlObj.Hide();\n    this._startDrag = false;\n  }\n}\n\nfunction fielddrop_mouseover() {\n\t\u002f\u002f this è elemento html\n  var field = this;\n  field.lastChild.textContent = String.fromCharCode(parseInt(getFieldTypeIcon(\"remove\"), 16));\n  field.lastChild.style.cursor = \"pointer\";\n}\n\nfunction fielddrop_mouseout() {\n\t\u002f\u002f this è elemento html\n  var field = this;\n  field.lastChild.textContent = String.fromCharCode(parseInt(getFieldTypeIcon(field.getAttribute(\"field-type\")), 16));\n}\n\nfunction fielddrop_click() {\n\t\u002f\u002f this è elemento html icona\n  var field = this.parentNode,\n      orgField = document.getElementById(field.id.replace(\"_drag\", \"\"));\n  if (!orgField)\n    return;\n\n  var fieldObject = window[field.getAttribute(\"formid\")][field.getAttribute(\"ps-name\")];\n  if (fieldObject && fieldObject.fieldVar) {\n    var chart_type = window[field.getAttribute(\"formid\")].chartfields.chart_type,\n        ctrlVar = window[field.getAttribute(\"formid\")][fieldObject.fieldVar];\n    if (fieldObject.fieldVar == \"values\" && (chart_type == \"category\" || chart_type == \"measure\")) {\n      if (ctrlVar.Value().indexOf(fieldObject.fieldId + \",\") \u003e= 0) {\n        ctrlVar.Value(ctrlVar.Value().replace(fieldObject.fieldId + \",\", \"\"));\n        window[field.getAttribute(\"formid\")].snames = window[field.getAttribute(\"formid\")].snames.replace(fieldObject.fielddesc + \",\", \"\");\n      }\n      else if (ctrlVar.Value().indexOf(fieldObject.fieldId) \u003e= 0) {\n        ctrlVar.Value(ctrlVar.Value().replace(fieldObject.fieldId, \"\"));\n        window[field.getAttribute(\"formid\")].snames = window[field.getAttribute(\"formid\")].snames.replace(fieldObject.fielddesc, \"\");\n      }\n      \n      if (Empty(ctrlVar.Value())) {\n        delete fieldObject.fieldVar;\n        window[field.getAttribute(\"formid\")][fieldObject.field].Ctrl.style.top = window[field.getAttribute(\"formid\")][fieldObject.field].y + \"px\";\n      }\n      else\n        window[field.getAttribute(\"formid\")][fieldObject.field].Ctrl.style.top = (window[field.getAttribute(\"formid\")][fieldObject.field].Ctrl.offsetTop - field.offsetHeight) + \"px\";\n      \n      var mflds = ctrlVar.Value().split(\",\");\n      for (var i = 0; i \u003c mflds.length; i++) {\n      \tvar fctrl = document.getElementById(field.getAttribute(\"formid\") + \"field_\" + mflds[i] + \"_drag\");\n        if (fctrl && fctrl.offsetTop \u003e= window[field.getAttribute(\"formid\")][fieldObject.field].Ctrl.offsetTop)\n          fctrl.style.top = (fctrl.offsetTop - field.offsetHeight) + \"px\";\n      }\n    }\n    else {\n    \tctrlVar.Value(\"\");\n    \tdelete fieldObject.fieldVar;\n      window[field.getAttribute(\"formid\")][fieldObject.field].Show();\n      delete fieldObject.field;\n    }\n  }\n  \n  window[field.getAttribute(\"formid\")].setDatasetToChart();\n  window[field.getAttribute(\"formid\")].chartfields.Draw();\n  \n  orgField.style.display = \"block\";\n  field.parentNode.removeChild(field);\n}\n\n\u002f** DOMAIN **\u002f\nfunction domainfield_DragLeave(objTarget){\n\tthis.genericDragLeave(this.domainfield, this.domain);\n}\n\nfunction domainfield_Drop(val_obj,drop_obj){\n  this.genericDragDropField(val_obj.value, this.domainfield, this.domain, \"allfield\");\n  window[this.formid][\"fieldbox_\" + val_obj.value].field = \"domainfield\";\n  window[this.formid][\"fieldbox_\" + val_obj.value].fieldVar = \"domain\";\n}\n\n\u002f** KEYS **\u002f\nfunction keyfield_DragLeave(objTarget){\n\tthis.genericDragLeave(this.keyfield, this.key);\n}\n\nfunction keyfield_Drop(val_obj,drop_obj){\n  this.genericDragDropField(val_obj.value, this.keyfield, this.key, \"allfield\");\n  window[this.formid][\"fieldbox_\" + val_obj.value].field = \"keyfield\";\n  window[this.formid][\"fieldbox_\" + val_obj.value].fieldVar = \"key\";\n}\n\nfunction skeyfield_DragLeave(objTarget){\n\tthis.genericDragLeave(this.skeyfield, this.key);\n}\n\nfunction skeyfield_Drop(val_obj,drop_obj){\n  this.genericDragDropField(val_obj.value, this.skeyfield, this.key, \"allfield\");\n  window[this.formid][\"fieldbox_\" + val_obj.value].field = \"skeyfield\";\n  window[this.formid][\"fieldbox_\" + val_obj.value].fieldVar = \"key\";\n}\n\n\u002f** VALUES + Z **\u002f\nfunction valuesfields_DragLeave(objTarget){\n  if (this.chartfields.chart_type != \"category\" && this.chartfields.chart_type != \"measure\")\n  \tthis.genericDragLeave(this.valuesfields, this.values);\n  else\n    this.valuesfields.Show();\n}\n\nfunction valuesfields_Drop(val_obj,drop_obj){\n  if (val_obj.type != \"N\") {\n    alert(\"Only numeric types\")\n    return;\n  }\n  \n  if (this.chartfields.chart_type != \"category\" && this.chartfields.chart_type != \"measure\")\n  \tthis.genericDragDropField(val_obj.value, this.valuesfields, this.values, \"allfield\");\n  else\n    this.valuesDragDropField(val_obj.value, this.valuesfields, this.values, \"allfield\");\n  window[this.formid][\"fieldbox_\" + val_obj.value].field = \"valuesfields\";\n  window[this.formid][\"fieldbox_\" + val_obj.value].fieldVar = \"values\";\n}\n\nfunction zfield_DragLeave(objTarget){\n  this.genericDragLeave(this.zfield, this.z);\n}\n\nfunction zfield_Drop(val_obj,drop_obj){\n  if (val_obj.type != \"N\") {\n    alert(\"Only numeric types\")\n    return;\n  }\n  \n  this.genericDragDropField(val_obj.value, this.zfield, this.z, \"allfield\");\n  window[this.formid][\"fieldbox_\" + val_obj.value].field = \"zfield\";\n  window[this.formid][\"fieldbox_\" + val_obj.value].fieldVar = \"z\";\n}\n\n\u002f** SERIES **\u002f\nfunction seriesfield_DragLeave(objTarget){\n  this.genericDragLeave(this.seriesfield, this.series);\n}\n\nfunction seriesfield_Drop(val_obj,drop_obj){\n  this.genericDragDropField(val_obj.value, this.seriesfield, this.series, \"allfield\");\n  window[this.formid][\"fieldbox_\" + val_obj.value].field = \"seriesfield\";\n  window[this.formid][\"fieldbox_\" + val_obj.value].fieldVar = \"series\";\n}\n\nfunction returnFieldsConfiguration() {\n  var rfobj = null;\n  if (!CharToBool(this.isdataobj.Value() + \"\")) {\n    rfobj = {\t vqr : this.vqr.Value(),\n               parms : this.parms.Value(),\n               domain : this.domain.Value(),\n               values : this.values.Value(),\n               snames : this.snames,\n               key : this.key.Value(),\n               z : this.z.Value(),\n               series : this.series.Value()\n            };\n    if (this.frompreview.Value()) {\n      if (GetOpener() && GetOpener().ZtVWeb) {\n        var ptlprev = GetOpener().ZtVWeb.getPortletWindow(\"SPChartPreview\");\n        ptlprev.receiveConfigFields(rfobj);\n      }\n    }\n    else {\n      if (GetOpener() && GetOpener().receiveConfigFields)\n        GetOpener().receiveConfigFields(rfobj);\n    }\n  }\n  else {\n    rfobj = {\tData : this.Grid30.GetSelectedData().Data.slice(),\n             \tpropid : this.key.Value(),\n             \tisdataobj : true\n    \t\t\t\t}\n  \tif (GetOpener() && GetOpener().receiveConfigFields)\n    \tGetOpener().receiveConfigFields(rfobj);\n  }\n  window.close();\n}\n\nfunction returnFieldsConfigurationForWizard() {\n\tvar rfobj = { domain : this.domain.Value(),\n                values : this.values.Value(),\n                snames : this.snames,\n                key : this.key.Value(),\n                z : this.z.Value(),\n                series : this.series.Value()\n              };\n\treturn rfobj;\n}","adaptive":"fixed","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"type\":\"label\",\"name\":\"labelbox\",\"selector\":\".labelbox\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"display\\\":\\\"block\\\",\\\"pad_top\\\":\\\"\\\",\\\"pad_bottom\\\":\\\"\\\",\\\"pad_left\\\":\\\"5px\\\",\\\"pad_right\\\":\\\"\\\",\\\"bg_color\\\":\\\"#02A8F3\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_hl\\\":\\\"\\\",\\\"shadow_color\\\":\\\"\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"\\\",\\\"cursor\\\":\\\"default\\\",\\\"border_width\\\":\\\"0px\\\",\\\"border_color\\\":\\\"transparent\\\",\\\"font_color\\\":\\\"#FAFAFA\\\",\\\"lheight\\\":\\\"25px\\\",\\\"size\\\":\\\"14px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"labelbox\\\",\\\"selector\\\":\\\".labelbox\\\",\\\"value\\\":\\\"Values fields (y axis)\\\",\\\"h\\\":\\\"480\\\",\\\"w\\\":\\\"200\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"display\\\":\\\"block\\\",\\\"pad_top\\\":\\\"\\\",\\\"pad_bottom\\\":\\\"\\\",\\\"pad_left\\\":\\\"5px\\\",\\\"pad_right\\\":\\\"\\\",\\\"bg_color\\\":\\\"#02A8F3\\\",\\\"shadow_hl\\\":\\\"\\\",\\\"shadow_color\\\":\\\"\\\",\\\"code\\\":\\\"\\\",\\\"cursor\\\":\\\"default\\\",\\\"border_width\\\":\\\"0px\\\",\\\"border_color\\\":\\\"transparent\\\",\\\"font_color\\\":\\\"#FAFAFA\\\",\\\"lheight\\\":\\\"25px\\\",\\\"size\\\":\\\"14px\\\"}\",\"code\":\".labelbox {\\n  display: block;\\n  padding-left: 5px;\\n  border: 0;\\n  background-color: #02A8F3;\\n  cursor: default;\\n  color: #FAFAFA;\\n  font-size: 14px;\\n  line-height: 25px;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"fielddesc\",\"selector\":\".fielddesc\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"size\\\":\\\"11px\\\",\\\"weight\\\":\\\"normal\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"fielddesc\\\",\\\"selector\\\":\\\".fielddesc\\\",\\\"h\\\":\\\"240\\\",\\\"w\\\":\\\"480\\\",\\\"id\\\":\\\"form\\\",\\\"size\\\":\\\"11px\\\",\\\"weight\\\":\\\"normal\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".fielddesc {\\n  font-weight: normal;\\n  font-size: 11px;\\n}\\n\"},{\"type\":\"undefined_type\",\"name\":\"fieldalias\",\"selector\":\".fieldalias\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"size\\\":\\\"11px\\\",\\\"weight\\\":\\\" 300\\\",\\\"transform\\\":\\\"uppercase\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"fieldalias\\\",\\\"selector\\\":\\\".fieldalias\\\",\\\"h\\\":\\\"240\\\",\\\"w\\\":\\\"480\\\",\\\"id\\\":\\\"form\\\",\\\"size\\\":\\\"11px\\\",\\\"weight\\\":\\\" 300\\\",\\\"transform\\\":\\\"uppercase\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".fieldalias {\\n  text-transform: uppercase;\\n  font-weight: 300;\\n  font-size: 11px;\\n}\\n\"},{\"type\":\"label\",\"name\":\"labelfieldcont\",\"selector\":\".labelfieldcont\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"pad_left\\\":\\\"5px\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"float:left;\\\\nwidth:195px;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"labelfieldcont\\\",\\\"selector\\\":\\\".labelfieldcont\\\",\\\"value\\\":\\\"Values fields (y axis)\\\",\\\"h\\\":\\\"480\\\",\\\"w\\\":\\\"200\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"pad_left\\\":\\\"5px\\\",\\\"code\\\":\\\"float:left;\\\\nwidth:195px;\\\"}\",\"code\":\".labelfieldcont {\\n  padding-left: 5px;\\n  float: left;\\n  width: 195px;\\n}\\n\"},{\"type\":\"label\",\"name\":\"fieldicon\",\"selector\":\".fieldicon\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"size\\\":\\\"19px\\\",\\\"code\\\":\\\"font-family:icons8_win10;\\\\nfloat:right;\\\",\\\"lheight\\\":\\\"30px\\\",\\\"pad_right\\\":\\\"5px\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"fieldicon\\\",\\\"selector\\\":\\\".fieldicon\\\",\\\"value\\\":\\\"Values fields (y axis)\\\",\\\"h\\\":\\\"480\\\",\\\"w\\\":\\\"200\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"size\\\":\\\"19px\\\",\\\"code\\\":\\\"font-family:icons8_win10;\\\\nfloat:right;\\\",\\\"lheight\\\":\\\"30px\\\",\\\"pad_right\\\":\\\"5px\\\"}\",\"code\":\".fieldicon {\\n  padding-right: 5px;\\n  font-family: icons8_win10;\\n  float: right;\\n  font-size: 19px;\\n  line-height: 30px;\\n}\\n\"},{\"type\":\"label\",\"name\":\"labelfieldbox\",\"selector\":\".labelfieldbox\",\"obj\":\"{\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"hover\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"cursor\\\":\\\"move\\\",\\\"max_width\\\":\\\"\\\",\\\"code\\\":\\\"color: rgba(0,0,0,.93);\\\\nborder-width: 0px 0px 1px 0px;\\\\nborder-style: solid;\\\\nborder-color: rgba(0,0,0, 0.16);\\\\nheight: 33px;\\\",\\\"font_color\\\":\\\"\\\"},\\\"hover\\\":{\\\"code\\\":\\\"border-color:#02A8F3;\\\\ncolor:#02A8F3;\\\"},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"label\\\",\\\"class_name\\\":\\\"labelfieldbox\\\",\\\"selector\\\":\\\".labelfieldbox\\\",\\\"value\\\":\\\"Values fields (y axis)\\\",\\\"h\\\":\\\"480\\\",\\\"w\\\":\\\"200\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"code\\\":\\\"border-color:#02A8F3;\\\\ncolor:#02A8F3;\\\"}\",\"code\":\".labelfieldbox {\\n  color: rgba(0,0,0,.93);\\n  border-width: 0px 0px 1px 0px;\\n  border-style: solid;\\n  border-color: rgba(0,0,0, 0.16);\\n  height: 33px;\\n  cursor: move;\\n}\\n\\n.labelfieldbox:hover {\\n  border-color: #02A8F3;\\n  color: #02A8F3;\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"545","hsl":"","htmlcode":"{{ SQLDataobj }}\n{{ fieldbox }}\n{{ chartfields }}\n{{ domainfield }}\n{{ keyfield }}\n{{ valuesfields }}\n{{ zfield }}\n{{ seriesfield }}\n{{ skeyfield }}\n{{ lblDomainField }}\n{{ lblKeyField }}\n{{ lblValuesField }}\n{{ lblZField }}\n{{ lblSeriesField }}\n{{ lblSKeyField }}\n{{ fieldboxtitle }}\n{{ defname }}\n{{ vqr }}\n{{ domain }}\n{{ values }}\n{{ series }}\n{{ key }}\n{{ z }}\n{{ lblCDomainField }}\n{{ parms }}\n{{ frompreview }}\n{{ StaticDataobj }}\n{{ ptlwizard }}\n{{ isdataobj }}{{ Label29 }}{{ Grid30 }}{{ dataobj_fields }}{{ Label32 }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"1150","layout_steps_values":"{\"978\":{\"h\":\"480\",\"w\":\"978\"},\"980\":{\"h\":\"545\",\"w\":\"980\"},\"1150\":{\"h\":\"545\",\"w\":\"1150\"}}","lock_items":"false","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"controls.js,PortalCommonJS.js,ChartObj.js,chart\u002fdemoDataSet.js,ZtChartFunctions.js","offline":"false","on_security_failure":"login","pages_names":"a,b","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"978,1150","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1150","version":"37","w":"1150","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"10","name":"SQLDataobj","offline":"false","page":"1","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"30","x":"1203","y":"0"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","create_undercond":"","h":"501","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{\"978\":{\"x\":5,\"y\":31,\"w\":\"227\",\"h\":444,\"anchor\":\"top-left\",\"hide\":\"false\"},\"980\":{\"x\":5,\"y\":31,\"w\":\"227\",\"h\":501,\"anchor\":\"top-left\",\"hide\":\"false\"},\"1150\":{\"x\":5,\"y\":31,\"w\":\"227\",\"h\":501,\"anchor\":\"top-left\",\"hide\":\"false\"}}","name":"fieldbox","page":"1","sequence":"2","shrinkable":"","stretch":"false","target":"","type":"Box","w":"227","wireframe_props":"","x":"5","y":"31","zindex":"4"},{"add_dataobj":"","anchor":"top-left","auto_exec":"false","categoryKeyName":"","categoryname":"","ccolor":"","chartH":"","chartNavbar":"false","chartNavbarAddRemove":"","chartNavbarChangepage":"","chartNavbarFirstlast":"","chartNavbarLastpage":"","chartNavbarPagepanel":"","chartW":"","chart_type":"category","class_cat":"","class_key":"","class_keycat":"","class_label":"","class_subaxis":"","class_xfrom":"","class_xto":"","class_xval":"","class_yfrom":"","class_yto":"","class_yval":"","compactChart":"","countryname":"","cstroke":"","csubname":"","ctooltip":"hide","ctype":"","cursorAlignment":"","cursorPosition":"","cursorType":"","danimation":"","data_order":"default","dataobj":"SQLDataobj","def":"","depclass":"","depfield_1":"","depfield_1class":"","depfield_1label":"","depfield_2":"","depfield_2class":"","depfield_2label":"","depvalue":"","downloadlist":"","elanimate":"disable","enable_change_order":"false","enable_menu_sel":"false","exclSer":"","exclicks":"false","expcolhie":"","exportFileName":"","fieldpath":"","fieldvalue":"","focuskey":"","gendataset":"false","geo_0_field":"","geo_1_field":"","geo_dom_field":"","geo_level":"0","geo_value_field":"","geo_view":"","grch_domain":"","grch_fields":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":"450","hide":"false","key_start":"","keyfieldpath":"","labelKey_field":"","label_field":"","label_series":"","layout_steps_values":"{\"978\":{\"x\":504,\"y\":7,\"w\":\"467\",\"h\":390,\"anchor\":\"top-left\",\"hide\":\"false\"},\"980\":{\"x\":505,\"y\":7,\"w\":467,\"h\":390,\"anchor\":\"top-left\",\"hide\":\"false\"},\"1150\":{\"x\":609,\"y\":6,\"w\":\"535\",\"h\":450,\"anchor\":\"top-left\",\"hide\":\"false\"}}","legend":"hide","legendlimit":"","linkparms":"","manualScale":"","mapSeries":"","max_field":"","max_value":"","measureKey_series_field":"","measure_series_field":"","menuPosition":"hide","min_field":"","min_value":"","mulsel":"","multi_key_field":"","multi_label_field":"","multi_scale":"true","multidimKeyName":"","multisubdivision":"","multisubheight":"","name":"chartfields","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othtype":"","page":"1","parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":"true","popup_height":"","popup_type":"","popup_width":"","portletsrc":"","query":"","rangebands":"","rangefunc":"","selclicks":"false","sequence":"3","seriesname":"","sfield":"","sfieldlabel":"","subtitle":"","target":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"fixed","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","val_field":"","value_fields":"","value_labels":"default","valuename":"","valuezname":"","vaxis_precision":"","vmode":"","voro_cat":"","voro_class":"","voro_coords":"","w":"535","wireframe_props":"","x":"609","xKey_field":"","x_field":"","x_label":"","xyz_series_field":"","y":"6","y_field":"","y_label":"","z_field":"","zfseries":"","zfshow":"","zftype":"default","zindex":"5"},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"40","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":506,\"y\":435,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":507,\"y\":435,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":609,\"y\":498,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"domainfield","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Drop here","w":"227","wireframe_props":"align,value,n_col","x":"609","y":"498","zindex":"9000"},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"40","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":741,\"y\":435,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":742,\"y\":435,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":870,\"y\":498,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"keyfield","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Drop here","w":"227","wireframe_props":"align,value,n_col","x":"870","y":"498","zindex":"16"},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"40","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":268,\"y\":36,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":269,\"y\":36,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":368,\"y\":35,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"valuesfields","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Drop here","w":"227","wireframe_props":"align,value,n_col","x":"368","y":"35","zindex":"16"},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"40","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":268,\"y\":112,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":269,\"y\":112,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":368,\"y\":133,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"zfield","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Drop here","w":"227","wireframe_props":"align,value,n_col","x":"368","y":"133","zindex":"16"},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"40","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":268,\"y\":281,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":269,\"y\":281,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":368,\"y\":318,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"seriesfield","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Drop here","w":"227","wireframe_props":"align,value,n_col","x":"368","y":"318","zindex":"16"},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"40","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":268,\"y\":357,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":269,\"y\":357,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":368,\"y\":416,\"w\":\"227\",\"h\":40,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"skeyfield","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Drop here","w":"227","wireframe_props":"align,value,n_col","x":"368","y":"416","zindex":"16"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":506,\"y\":407,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":507,\"y\":407,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":609,\"y\":470,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblDomainField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Domain field (x axis)","w":"227","wireframe_props":"align,value,n_col","x":"609","y":"470","zindex":"17"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":741,\"y\":407,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":742,\"y\":407,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":870,\"y\":470,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblKeyField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Domain key field","w":"227","wireframe_props":"align,value,n_col","x":"870","y":"470","zindex":"17"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":268,\"y\":7,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":269,\"y\":7,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":368,\"y\":6,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblValuesField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Values fields (y axis)","w":"227","wireframe_props":"align,value,n_col","x":"368","y":"6","zindex":"17"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":267,\"y\":83,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":268,\"y\":83,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":367,\"y\":104,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblZField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Radius field (z axis)","w":"227","wireframe_props":"align,value,n_col","x":"367","y":"104","zindex":"18"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":267,\"y\":252,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":268,\"y\":252,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":367,\"y\":289,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblSeriesField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Series field","w":"227","wireframe_props":"align,value,n_col","x":"367","y":"289","zindex":"17"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":267,\"y\":328,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":268,\"y\":328,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":367,\"y\":387,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblSKeyField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Series key field","w":"227","wireframe_props":"align,value,n_col","x":"367","y":"387","zindex":"18"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label labelbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":5,\"y\":6,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":5,\"y\":6,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":5,\"y\":6,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"fieldboxtitle","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Fields list","w":"227","wireframe_props":"align,value,n_col","x":"5","y":"6","zindex":"17"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"defname","page":"1","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"40"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"vqr","page":"1","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"64"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"domain","page":"1","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"112"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"values","page":"1","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"136"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"series","page":"1","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"160"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"key","page":"1","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"184"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"z","page":"1","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"208"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"978\":{\"x\":505,\"y\":407,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"980\":{\"x\":506,\"y\":407,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1150\":{\"x\":608,\"y\":470,\"w\":\"227\",\"h\":25,\"anchor\":\"top-left\",\"hide\":\"false\",\"align\":\"left\",\"n_col\":\"1\",\"fontpct\":\"\"}}","n_col":"1","name":"lblCDomainField","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Country field","w":"227","wireframe_props":"align,value,n_col","x":"608","y":"470","zindex":"9002"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"parms","page":"1","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"88"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"frompreview","page":"1","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"232"},{"alias":"","auto_exec":"true","dataproviders":"","fieldsType":"","h":"30","man_query":"","name":"StaticDataobj","page":"1","parms":"","parms_source":"","sequence":"27","type":"StaticDataProvider","w":"30","x":"1245","y":"0"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"ptlwizard","page":"1","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1203","y":"256"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"isdataobj","page":"1","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1204","y":"281"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"ALIAS","colProperties":"[{\"field\":\"ALIAS\",\"title\":\"Alias\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"DESC\",\"title\":\"Description\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj_fields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"525","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{\"978\":{\"x\":20,\"y\":10,\"w\":\"938\",\"h\":460,\"anchor\":\"\",\"hide\":\"false\"},\"1150\":{\"x\":20,\"y\":10,\"w\":\"1110\",\"h\":525,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"","name":"Grid30","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"9999","scroll_bars":"infinite_scroll","sequence":"30","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"1110","wireframe_props":"colProperties,checkbox,rows","x":"20","y":"10","zindex":"9005"},{"alias":"ALIAS,DESC","auto_exec":"true","dataproviders":"","fieldsType":"C,C","h":"20","man_query":"","name":"dataobj_fields","page":"2","parms":"","parms_source":"","sequence":"31","type":"StaticDataProvider","w":"120","x":"1179","y":"99"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:defname,vqr,domain,values,series,key,z,parms,frompreview,ptlwizard,isdataobj*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
window.SPChartFieldsConfigurator_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof _Load2 !='undefined')this._Load2=_Load2;
if(typeof Grid30_Rendered !='undefined')this.Grid30_Rendered=Grid30_Rendered;
if(typeof _Loaded !='undefined')this._Loaded=_Loaded;
if(typeof initFields !='undefined')this.initFields=initFields;
if(typeof hideAllBoxes !='undefined')this.hideAllBoxes=hideAllBoxes;
if(typeof initChart !='undefined')this.initChart=initChart;
if(typeof setDatasetToChart !='undefined')this.setDatasetToChart=setDatasetToChart;
if(typeof checkFieldsForChart !='undefined')this.checkFieldsForChart=checkFieldsForChart;
if(typeof initData !='undefined')this.initData=initData;
if(typeof updateSQLCtrl !='undefined')this.updateSQLCtrl=updateSQLCtrl;
if(typeof addDatasourceFields !='undefined')this.addDatasourceFields=addDatasourceFields;
if(typeof manageFieldsArray !='undefined')this.manageFieldsArray=manageFieldsArray;
if(typeof drawField !='undefined')this.drawField=drawField;
if(typeof loadFieldBoxes !='undefined')this.loadFieldBoxes=loadFieldBoxes;
if(typeof getFieldTypeIcon !='undefined')this.getFieldTypeIcon=getFieldTypeIcon;
if(typeof genericDragDropField !='undefined')this.genericDragDropField=genericDragDropField;
if(typeof valuesDragDropField !='undefined')this.valuesDragDropField=valuesDragDropField;
if(typeof genericDragLeave !='undefined')this.genericDragLeave=genericDragLeave;
if(typeof fielddrop_mouseover !='undefined')this.fielddrop_mouseover=fielddrop_mouseover;
if(typeof fielddrop_mouseout !='undefined')this.fielddrop_mouseout=fielddrop_mouseout;
if(typeof fielddrop_click !='undefined')this.fielddrop_click=fielddrop_click;
if(typeof domainfield_DragLeave !='undefined')this.domainfield_DragLeave=domainfield_DragLeave;
if(typeof domainfield_Drop !='undefined')this.domainfield_Drop=domainfield_Drop;
if(typeof keyfield_DragLeave !='undefined')this.keyfield_DragLeave=keyfield_DragLeave;
if(typeof keyfield_Drop !='undefined')this.keyfield_Drop=keyfield_Drop;
if(typeof skeyfield_DragLeave !='undefined')this.skeyfield_DragLeave=skeyfield_DragLeave;
if(typeof skeyfield_Drop !='undefined')this.skeyfield_Drop=skeyfield_Drop;
if(typeof valuesfields_DragLeave !='undefined')this.valuesfields_DragLeave=valuesfields_DragLeave;
if(typeof valuesfields_Drop !='undefined')this.valuesfields_Drop=valuesfields_Drop;
if(typeof zfield_DragLeave !='undefined')this.zfield_DragLeave=zfield_DragLeave;
if(typeof zfield_Drop !='undefined')this.zfield_Drop=zfield_Drop;
if(typeof seriesfield_DragLeave !='undefined')this.seriesfield_DragLeave=seriesfield_DragLeave;
if(typeof seriesfield_Drop !='undefined')this.seriesfield_Drop=seriesfield_Drop;
if(typeof returnFieldsConfiguration !='undefined')this.returnFieldsConfiguration=returnFieldsConfiguration;
if(typeof returnFieldsConfigurationForWizard !='undefined')this.returnFieldsConfigurationForWizard=returnFieldsConfigurationForWizard;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.SQLDataobj.addRowConsumer(this.chartfields);
this.dataobj_fields.addRowConsumer(this.Grid30);
function this_Loaded(){
  document.getElementById(this.formid + "_tabcontainer").style.display = "none";
  this._isloaded = true;
  var tptl = this.getTitlePortlet();
  if (!Empty(this.ptlwizard.Value())) {
    tptl.Ctrl_container.style.display = "none";
  }
  else {
    var _this = this;
    tptl.toolbar.Append({	id: "apply",
                          title: FormatMsg("RPT_APPLY"),
                          tooltip: FormatMsg("RPT_APPLY"),
                          action: function () { _this.returnFieldsConfiguration(); },
                          image: {	FontName: "icons8_win10",
                          	        Size: 24,
                                    Char: parseInt("ef8b",16),
                                    FontWeight: "normal"
                                 }
                        });
  }
  
  this._isloaded = false;
  if (!CharToBool(this.isdataobj.Value() + "")) {
  	this._Loaded();
    this.ZtTabs.Select("page1");
  }
  else {
    tptl.SetTitle("Query fields");
    tptl.SetSubTitle("Choose field to insert in chart property");
    this._Load2();
    this.ZtTabs.Select("page2");
  }
}
var rows_check = [];
function _Load2() {
	var fields_array = GetOpener().GetFieldsForChart(this.vqr.Value()),
      data = [],
      val_array = this.values.Value().split(",");
  for (var i = 0; i < fields_array[0].length; i++) {
  	data.push([fields_array[0][i], fields_array[1][i]]);
    if (val_array.indexOf(fields_array[0][i]) >= 0)
      rows_check.push(i);
  }
  this.dataobj_fields.FillData(data);
}
function Grid30_Rendered(){
  for (var i = 0; i < rows_check.length; i++) {
    this.Grid30.CurrRow(rows_check[i])
  	this.Grid30.RowChecked(true)
  }
}
function _Loaded() {
  // variabili di lavoro
  this.queryFields = [];
  this.snames = "";
  this.isDemo = true;
  this._startDrag = false;
  this.showparms = false;
	this.hideAllBoxes();
  this.initChart();
  this.initData();
}
function initFields() {
  var _this = this;
  setTimeout( function () {
    var ctype = _this.chartfields.chart_type;
    if (!Empty(_this.domain.Value()))
      _this.domainfield_Drop({value : _this.domain.Value()});
    if (!Empty(_this.values.Value())) {
      if (ctype != "category" && ctype != "measure")
        _this.valuesfields_Drop({value : _this.values.Value()});
      else {
        var vfs = _this.values.Value().split(",");
        _this.values.Value("");
        for (var i = 0; i < vfs.length; i++) {
          _this.valuesfields_Drop({value : vfs[i], type : "N"});
        }
      }
    }
    if (!Empty(_this.z.Value()))
      _this.zfield_Drop({value : _this.z.Value(), type : "N"});
    if (!Empty(_this.series.Value()))
      _this.seriesfield_Drop({value : _this.series.Value()});
    if (!Empty(_this.key.Value())) {
      if (ctype != "category" && ctype != "measure")
        _this.skeyfield_Drop({value : _this.key.Value()});
      else
        _this.keyfield_Drop({value : _this.key.Value()});
    }
  }, 10);
}
function hideAllBoxes() {
  // chart
  this.chartfields.Hide();
  // fieldbox
  this.fieldbox.Hide();
  this.fieldboxtitle.Hide();
  // fields
	this.lblDomainField.Hide();
  this.lblCDomainField.Hide();
  this.lblKeyField.Hide();
  this.lblSeriesField.Hide();
  this.lblSKeyField.Hide();
  this.lblValuesField.Hide();
  this.lblZField.Hide();
  this.domainfield.Hide();
  this.keyfield.Hide();
  this.seriesfield.Hide();
  this.skeyfield.Hide();
  this.valuesfields.Hide();
  this.zfield.Hide();
}
function initChart() {
  if (this.frompreview.Value()) {
    if (GetOpener() && GetOpener().ZtVWeb) {
      var ptlprev = GetOpener().ZtVWeb.getPortletWindow("SPChartPreview");
  		this.chartfields.chartConfig = ptlprev.getPreviewChartConfig();
    }
  }
  else if (!Empty(this.ptlwizard.Value())) {
		if (window.parent && window.parent.ZtVWeb) {
      var pobj = window.parent.ZtVWeb.getPortletById(this.ptlwizard.Value());
      if (pobj && pobj.getChartConfigurationObject)
      	this.chartfields.chartConfig = pobj.getChartConfigurationObject();
    }
  }
  else if (!Empty(this.defname.Value())) {
  	this.chartfields.SetChartDef(this.defname.Value());
  	this.chartfields._loadDefAndSetCConfig();
  }
  
  if (this.chartfields.chartConfig) {
    this.chartfields.chart_type = getZFChartMacroType(this.chartfields.chartConfig.graphSettings.chartType);
    this.chartfields.chartConfig.globalSettings.width = this.chartfields.w;
    this.chartfields.chartConfig.globalSettings.height = this.chartfields.h;
    this.setDatasetToChart();
  }
}
function setDatasetToChart() {
  this.chartfields.Show();
  var fwiz = !Empty(this.ptlwizard.Value()) && Empty(this.chartfields.propertyValue);
  if ((Empty(this.ptlwizard.Value()) && (Empty(this.vqr.Value()) || !this.checkFieldsForChart(this.chartfields.chart_type))) || fwiz) {
    this.chartfields.gendataset = true;
    this.chartfields.propertyValue = getDatasetDemo(this.chartfields.chart_type);
    if (this.chartfields.chart_type == "category" || this.chartfields.chart_type == "measure")
      this.chartfields.setFieldsCategoryChart("COD", "RA1,RA2,RA3", "Rappresentante area 1,Rappresentante area 2,Rappresentante area 3");
    else if (this.chartfields.chart_type == "xyz")
      this.chartfields.SetFieldsXYZChart("x_fld", "y_fld", "z_fld", "serie_fld");
    else // geo
      this.chartfields.SetFieldsGeoChart("CNT", "", "VAL", "WHO", "0");
    delete this.chartfields.ztChart;
  	this.chartfields._drawChart();
  }
  else if (Empty(this.ptlwizard.Value())){
    this.chartfields.gendataset = false;
    if (this.chartfields.chart_type == "category" || this.chartfields.chart_type == "measure")
      this.chartfields.setFieldsCategoryChart(this.domain.Value(), this.values.Value(), this.snames, this.key.Value());
    else if (this.chartfields.chart_type == "xyz")
      this.chartfields.SetFieldsXYZChart(this.domain.Value(), this.values.Value(), this.z.Value(), this.series.Value(), this.key.Value());
    else // geo
      this.chartfields.SetFieldsGeoChart(this.domain.Value(), "", this.values.Value(), this.series.Value(), "0");
    this.SQLDataobj.Query();
  }
}
function checkFieldsForChart(type) {
  var evret = false;
	if (type == "category" || type == "measure" || type == "geo")
    evret = !Empty(this.domain.Value()) && !Empty(this.values.Value());
  else // if (type == "xyz")
    evret = !Empty(this.domain.Value()) && !Empty(this.values.Value()) && !Empty(this.series.Value());
	return evret;
}
function initData(){
  if (!Empty(this.ptlwizard.Value())) {
    if (window.parent && window.parent.ZtVWeb) {
    	var pobj = window.parent.ZtVWeb.getPortletById(this.ptlwizard.Value());
      if (pobj && pobj.getFields)
      	this.queryFields = JSON.parse(pobj.getFields());
      if (!Empty(this.queryFields)) {
        this.fieldbox.Show();
    		this.fieldboxtitle.Show();
      }
    }
  }
  else {
    if (Empty(this.vqr.Value())) {
      this.hideAllBoxes();
      return;
    }
    this.fieldbox.Show();
    this.fieldboxtitle.Show();
    this.updateSQLCtrl();
    this.queryFields = getQueryFields(this.vqr.Value());
  }
  this.addDatasourceFields(this.queryFields);
  this.loadFieldBoxes();
  if (this._isloaded)
    this.initFields();
}
function updateSQLCtrl(onlyparms) {
  this.SQLDataobj.ChangeQuery(this.vqr.Value());
  this.SQLDataobj.parms = getQueryParams(this.parms.Value());
}
function addDatasourceFields(fieldsArr){
  var fields = this.manageFieldsArray(fieldsArr);
  this.fieldbox.Ctrl.innerHTML = "";
  console.log(fields)
  var bh = 460;
  var isLong = (21*fields.length)>bh;
  var div, elem;
  // creo e disegno i campi
  div = document.createElement("div");
  div.id = this.formid+"maskFrameFldsCont";
  div.className = "unselectable maskfldContainer";
  if(!isLong)
    div.style.overflow = "hidden";
  for(var i=0; i<fields.length; i++){
    elem = this.drawField(fields[i],this.formid,isLong);
    elem.setAttribute("formid", this.formid);
    elem.setAttribute("ps-name", "fieldbox_" + fields[i].alias);
    elem.setAttribute("data-transfer", "allfield");
    elem.setAttribute("field-type", fields[i].type);
    div.appendChild(elem);
    
    window[this.formid]["fieldbox_" + fields[i].alias] = {
      fieldId : fields[i].alias,
      fieldType : fields[i].type,
      fielddesc : fields[i].desc,
      formid : this.formid,
      getDragObj : function () {
        if (!this.DraggerObj) {// Oggetto drag data generico
          this.DraggerObj = { value : this.fieldId, type : this.fieldType };
        }
        return this.DraggerObj;
      },
     	DragCancel : function () { },
      DragEnter : function () { 
        window[this.formid]._startDrag = true;
        window[this.formid][this.field].Show();
      },
      DragLeave : function () { }
    };
  }
  
  this.fieldbox.Ctrl.appendChild(div);
  ZtVWeb.DragDropHtml5.initEvents(this.formid);
}
function manageFieldsArray(fieldsArr) {
  if (Empty(fieldsArr))
    return [];
	var otype = Object.prototype.toString.call(fieldsArr[0]);
  if (otype === "[object Object]")
    return fieldsArr;
  // tipo [ [alias],[desc],[type] ]
  var rflds = [];
  for (var i = 0; i < fieldsArr[0].length; i++) {
    var f = {};
    f.alias = fieldsArr[0][i];
    f.desc = Empty(fieldsArr[1][i]) ? fieldsArr[0][i] : fieldsArr[1][i];
    f.alias = fieldsArr[2][i];
    rflds.push(f);
  }
  return rflds;
}
function drawField(fobj,pid,isLong,wColor,idx){
  var elem = document.createElement("div");
  elem.id = pid+"field_"+fobj.alias;
  elem.className = "label labelfieldbox";
  elem.draggable = true;
  if(isLong)
    elem.className+=" maskfieldObjectLong";
  var econt = document.createElement("div");
  econt.className = "labelfieldcont";
  elem.appendChild(econt);
  
	var elem2 = document.createElement("div");
  elem2.className = "fielddesc";
  if(isLong)
    elem2.className+=" maskfieldObjectDescLong";
  if(fobj.desc.length>=22)
    elem2.textContent = fobj.desc.substring(0,18)+"...";
  else
    elem2.textContent = fobj.desc;
  econt.appendChild(elem2);
  
  elem2 = document.createElement("div");
  elem2.className = "fieldalias";
//  if(isLong)
 //   elem2.className+=" maskfieldObjectDescLong";
  elem2.textContent = fobj.alias;
  econt.appendChild(elem2);
    elem2 = document.createElement("div");
    elem2.className = "fieldicon";
  elem2.textContent = String.fromCharCode(parseInt(getFieldTypeIcon(fobj.type), 16));
    
    elem.appendChild(elem2);
  return elem;
}
function loadFieldBoxes() {
	if (this.chartfields.chart_type == "category" || this.chartfields.chart_type == "measure") {
    this.lblDomainField.Show();
    this.lblKeyField.Show();
    this.lblValuesField.Show();
    this.domainfield.Show();
    this.keyfield.Show();
    this.valuesfields.Show();
  }
  else if (this.chartfields.chart_type == "xyz") {
    this.lblDomainField.Show();
    this.lblValuesField.Show();
    this.lblZField.Show();
    this.lblSKeyField.Show();
    this.lblSeriesField.Show();
    this.domainfield.Show();
    this.valuesfields.Show();
    this.zfield.Show();
    this.skeyfield.Show();
    this.seriesfield.Show();
  }
  else {	//geo
    this.lblCDomainField.Show();
    this.lblValuesField.Show();
    this.lblSeriesField.Show();
    this.domainfield.Show();
    this.valuesfields.Show();
    this.seriesfield.Show();
  }
}
function getFieldTypeIcon(type) {
  var code = "";
	switch (type) {
    case "C":
      code = "eea1";
      break;
    case "M":
      code = "ee04";
      break;
    case "N":
      code = "f0e9";
      break;
    case "L":
      code = "f788";
      break;
    case "D":
      code = "f20f";
      break;
    case "T":
      code = "e973";
      break;
    case "remove":
      code = "ed93";
      break;
  }
  return code;
}
function genericDragDropField(alias, ctrlObj, ctrlVar, acceptType) {
  var fieldDrag = document.getElementById(this.formid + "field_" + alias);
  if (!fieldDrag)
    return;
  var pos = { top : ctrlObj.Ctrl.offsetTop, left : ctrlObj.Ctrl.offsetLeft };
  ctrlObj.Hide();
  
  var ctrlDrag = fieldDrag.cloneNode();
  ctrlDrag.id = ctrlDrag.id + "_drag";
  ctrlDrag.innerHTML = fieldDrag.innerHTML;
  ctrlDrag.style.position = "absolute";
  ctrlDrag.style.top = pos.top + "px";
  ctrlDrag.style.left = pos.left + "px";
  ctrlObj.Ctrl.parentNode.appendChild(ctrlDrag);
  ctrlObj.Ctrl.parentNode.insertBefore(ctrlDrag, ctrlObj.Ctrl);
  
  ctrlDrag.onmouseover = fielddrop_mouseover;
  ctrlDrag.onmouseout = fielddrop_mouseout;
  ctrlDrag.lastChild.onclick = fielddrop_click;
  ctrlDrag.style.cursor = "default";
  // nascondo dalla lista
  fieldDrag.style.display = "none";
  
  // rimpiazzo eventuale sostituzione
  if (!Empty(ctrlVar.Value()) && ctrlVar.Value() != alias) {	// gia' presente un campo
    // rimuovo campo
    var oldField = document.getElementById(this.formid + "field_" + ctrlVar.Value() + "_drag");
    if (oldField)
    	oldField.parentNode.removeChild(oldField);
    oldField = document.getElementById(this.formid + "field_" + ctrlVar.Value());
    if (oldField)
      oldField.style.display = "block";
  }
  
  ctrlDrag.setAttribute("data-transfer-accept", acceptType);
  ZtVWeb.DragDropHtml5.initEvents(this.formid);
  ctrlVar.Value(alias);
  
  this._startDrag = false;
  
  this.setDatasetToChart();
}
function valuesDragDropField(alias, ctrlObj, ctrlVar, acceptType) {
  var fieldDrag = document.getElementById(this.formid + "field_" + alias);
  if (!fieldDrag)
    return;
  var pos = { top : ctrlObj.Ctrl.offsetTop, left : ctrlObj.Ctrl.offsetLeft };
  var ctrlDrag = fieldDrag.cloneNode();
  ctrlDrag.id = ctrlDrag.id + "_drag";
  ctrlDrag.innerHTML = fieldDrag.innerHTML;
  ctrlDrag.style.position = "absolute";
  ctrlDrag.style.top = pos.top + "px";
  ctrlDrag.style.left = pos.left + "px";
  ctrlObj.Ctrl.parentNode.appendChild(ctrlDrag);
  ctrlObj.Ctrl.parentNode.insertBefore(ctrlDrag, ctrlObj.Ctrl);
  
  ctrlObj.Ctrl.style.top = (pos.top + ctrlDrag.offsetHeight) + "px";
  ctrlObj.topposition = pos.top + ctrlDrag.offsetHeight;
  
  ctrlDrag.onmouseover = fielddrop_mouseover;
  ctrlDrag.onmouseout = fielddrop_mouseout;
  ctrlDrag.lastChild.onclick = fielddrop_click;
  ctrlDrag.style.cursor = "default";
  // nascondo dalla lista
  fieldDrag.style.display = "none";
	
  // aggiungo campo separato da ','
  var old_val = "";
  if (!Empty(ctrlVar.Value()))
    old_val = ctrlVar.Value() + ",";
  ctrlVar.Value(old_val + alias);
  old_val = "";
  if (!Empty(this.snames))
    old_val = this.snames + ",";
  this.snames = old_val + window[this.formid]["fieldbox_" + alias].fielddesc;
  
  this._startDrag = false;
  
  this.setDatasetToChart();
}
function genericDragLeave(ctrlObj, ctrlVar) {
	if (!Empty(ctrlVar.Value()) && this._startDrag) {
    ctrlObj.Hide();
    this._startDrag = false;
  }
}
function fielddrop_mouseover() {
	// this è elemento html
  var field = this;
  field.lastChild.textContent = String.fromCharCode(parseInt(getFieldTypeIcon("remove"), 16));
  field.lastChild.style.cursor = "pointer";
}
function fielddrop_mouseout() {
	// this è elemento html
  var field = this;
  field.lastChild.textContent = String.fromCharCode(parseInt(getFieldTypeIcon(field.getAttribute("field-type")), 16));
}
function fielddrop_click() {
	// this è elemento html icona
  var field = this.parentNode,
      orgField = document.getElementById(field.id.replace("_drag", ""));
  if (!orgField)
    return;
  var fieldObject = window[field.getAttribute("formid")][field.getAttribute("ps-name")];
  if (fieldObject && fieldObject.fieldVar) {
    var chart_type = window[field.getAttribute("formid")].chartfields.chart_type,
        ctrlVar = window[field.getAttribute("formid")][fieldObject.fieldVar];
    if (fieldObject.fieldVar == "values" && (chart_type == "category" || chart_type == "measure")) {
      if (ctrlVar.Value().indexOf(fieldObject.fieldId + ",") >= 0) {
        ctrlVar.Value(ctrlVar.Value().replace(fieldObject.fieldId + ",", ""));
        window[field.getAttribute("formid")].snames = window[field.getAttribute("formid")].snames.replace(fieldObject.fielddesc + ",", "");
      }
      else if (ctrlVar.Value().indexOf(fieldObject.fieldId) >= 0) {
        ctrlVar.Value(ctrlVar.Value().replace(fieldObject.fieldId, ""));
        window[field.getAttribute("formid")].snames = window[field.getAttribute("formid")].snames.replace(fieldObject.fielddesc, "");
      }
      
      if (Empty(ctrlVar.Value())) {
        delete fieldObject.fieldVar;
        window[field.getAttribute("formid")][fieldObject.field].Ctrl.style.top = window[field.getAttribute("formid")][fieldObject.field].y + "px";
      }
      else
        window[field.getAttribute("formid")][fieldObject.field].Ctrl.style.top = (window[field.getAttribute("formid")][fieldObject.field].Ctrl.offsetTop - field.offsetHeight) + "px";
      
      var mflds = ctrlVar.Value().split(",");
      for (var i = 0; i < mflds.length; i++) {
      	var fctrl = document.getElementById(field.getAttribute("formid") + "field_" + mflds[i] + "_drag");
        if (fctrl && fctrl.offsetTop >= window[field.getAttribute("formid")][fieldObject.field].Ctrl.offsetTop)
          fctrl.style.top = (fctrl.offsetTop - field.offsetHeight) + "px";
      }
    }
    else {
    	ctrlVar.Value("");
    	delete fieldObject.fieldVar;
      window[field.getAttribute("formid")][fieldObject.field].Show();
      delete fieldObject.field;
    }
  }
  
  window[field.getAttribute("formid")].setDatasetToChart();
  window[field.getAttribute("formid")].chartfields.Draw();
  
  orgField.style.display = "block";
  field.parentNode.removeChild(field);
}
function domainfield_DragLeave(objTarget){
	this.genericDragLeave(this.domainfield, this.domain);
}
function domainfield_Drop(val_obj,drop_obj){
  this.genericDragDropField(val_obj.value, this.domainfield, this.domain, "allfield");
  window[this.formid]["fieldbox_" + val_obj.value].field = "domainfield";
  window[this.formid]["fieldbox_" + val_obj.value].fieldVar = "domain";
}
function keyfield_DragLeave(objTarget){
	this.genericDragLeave(this.keyfield, this.key);
}
function keyfield_Drop(val_obj,drop_obj){
  this.genericDragDropField(val_obj.value, this.keyfield, this.key, "allfield");
  window[this.formid]["fieldbox_" + val_obj.value].field = "keyfield";
  window[this.formid]["fieldbox_" + val_obj.value].fieldVar = "key";
}
function skeyfield_DragLeave(objTarget){
	this.genericDragLeave(this.skeyfield, this.key);
}
function skeyfield_Drop(val_obj,drop_obj){
  this.genericDragDropField(val_obj.value, this.skeyfield, this.key, "allfield");
  window[this.formid]["fieldbox_" + val_obj.value].field = "skeyfield";
  window[this.formid]["fieldbox_" + val_obj.value].fieldVar = "key";
}
function valuesfields_DragLeave(objTarget){
  if (this.chartfields.chart_type != "category" && this.chartfields.chart_type != "measure")
  	this.genericDragLeave(this.valuesfields, this.values);
  else
    this.valuesfields.Show();
}
function valuesfields_Drop(val_obj,drop_obj){
  if (val_obj.type != "N") {
    alert("Only numeric types")
    return;
  }
  
  if (this.chartfields.chart_type != "category" && this.chartfields.chart_type != "measure")
  	this.genericDragDropField(val_obj.value, this.valuesfields, this.values, "allfield");
  else
    this.valuesDragDropField(val_obj.value, this.valuesfields, this.values, "allfield");
  window[this.formid]["fieldbox_" + val_obj.value].field = "valuesfields";
  window[this.formid]["fieldbox_" + val_obj.value].fieldVar = "values";
}
function zfield_DragLeave(objTarget){
  this.genericDragLeave(this.zfield, this.z);
}
function zfield_Drop(val_obj,drop_obj){
  if (val_obj.type != "N") {
    alert("Only numeric types")
    return;
  }
  
  this.genericDragDropField(val_obj.value, this.zfield, this.z, "allfield");
  window[this.formid]["fieldbox_" + val_obj.value].field = "zfield";
  window[this.formid]["fieldbox_" + val_obj.value].fieldVar = "z";
}
function seriesfield_DragLeave(objTarget){
  this.genericDragLeave(this.seriesfield, this.series);
}
function seriesfield_Drop(val_obj,drop_obj){
  this.genericDragDropField(val_obj.value, this.seriesfield, this.series, "allfield");
  window[this.formid]["fieldbox_" + val_obj.value].field = "seriesfield";
  window[this.formid]["fieldbox_" + val_obj.value].fieldVar = "series";
}
function returnFieldsConfiguration() {
  var rfobj = null;
  if (!CharToBool(this.isdataobj.Value() + "")) {
    rfobj = {	 vqr : this.vqr.Value(),
               parms : this.parms.Value(),
               domain : this.domain.Value(),
               values : this.values.Value(),
               snames : this.snames,
               key : this.key.Value(),
               z : this.z.Value(),
               series : this.series.Value()
            };
    if (this.frompreview.Value()) {
      if (GetOpener() && GetOpener().ZtVWeb) {
        var ptlprev = GetOpener().ZtVWeb.getPortletWindow("SPChartPreview");
        ptlprev.receiveConfigFields(rfobj);
      }
    }
    else {
      if (GetOpener() && GetOpener().receiveConfigFields)
        GetOpener().receiveConfigFields(rfobj);
    }
  }
  else {
    rfobj = {	Data : this.Grid30.GetSelectedData().Data.slice(),
             	propid : this.key.Value(),
             	isdataobj : true
    				}
  	if (GetOpener() && GetOpener().receiveConfigFields)
    	GetOpener().receiveConfigFields(rfobj);
  }
  window.close();
}
function returnFieldsConfigurationForWizard() {
	var rfobj = { domain : this.domain.Value(),
                values : this.values.Value(),
                snames : this.snames,
                key : this.key.Value(),
                z : this.z.Value(),
                series : this.series.Value()
              };
	return rfobj;
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
.SPChartFieldsConfigurator_container .labelbox{  display: block;
  padding-left: 5px;
  border: 0;
  background-color: #02A8F3;
  cursor: default;
  color: #FAFAFA;
  font-size: 14px;
  line-height: 25px;
}
.SPChartFieldsConfigurator_container .fielddesc{
  font-weight: normal;
  font-size: 11px;
}
.SPChartFieldsConfigurator_container .fieldalias{
  text-transform: uppercase;
  font-weight:  300;
  font-size: 11px;
}
.SPChartFieldsConfigurator_container .labelfieldcont{
  padding-left: 5px;
  float:left;
  width:195px;
}
.SPChartFieldsConfigurator_container .fieldicon{
  padding-right: 5px;
  font-family:icons8_win10;
  float:right;
  font-size: 19px;
  line-height: 30px;
}
.SPChartFieldsConfigurator_container .labelfieldbox{
  color: rgba(0,0,0,.93);
  border-width: 0px 0px 1px 0px;
  border-style: solid;
  border-color: rgba(0,0,0, 0.16);
  height: 33px;
  cursor: move;
}
.SPChartFieldsConfigurator_container .labelfieldbox:hover{
  border-color:#02A8F3;
  color:#02A8F3;
}
.SPChartFieldsConfigurator_container {
}
.SPChartFieldsConfigurator_title_container {
  margin: auto;
}
.SPChartFieldsConfigurator_portlet{
  position:relative;
  margin: auto;
  min-width:978px;
  height:545px;
  background-color:#FFFFFF;
}
.SPChartFieldsConfigurator_portlet[Data-page="1"]{
  height:545px;
  width:1150px;
}
.SPChartFieldsConfigurator_portlet[Data-page="2"]{
  height:545px;
  width:1150px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"][Data-page="1"] {
  height:480px;
  width:978px;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"][Data-page="1"] {
  height:545px;
  width:1150px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"][Data-page="2"] {
  height:480px;
  width:978px;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"][Data-page="2"] {
  height:545px;
  width:1150px;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .fieldbox_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:31px;
  left:5px;
  width:227px;
  height:auto;
  min-height:501px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .fieldbox_ctrl {
  height:501px;
  display:flex;
  flex-direction:column;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .fieldbox_ctrl > .box_content {
  height:100%;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .fieldbox_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:31px;
  left:5px;
  width:227px;
  height:auto;
  min-height:444px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .fieldbox_ctrl {
  height:444px;
  display:flex;
  flex-direction:column;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .fieldbox_ctrl > .box_content {
  height:100%;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .fieldbox_ctrl {
  min-height:444px;
  border-width:0px;
  border-style:solid;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .chartfields_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:6px;
  left:609px;
  width:535px;
  height:450px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .chartfields_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:7px;
  left:504px;
  width:467px;
  height:390px;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl {
  box-sizing:border-box;
  z-index:9000;
  position:absolute;
  display:inline-block;
  top:498px;
  left:609px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl {
  box-sizing:border-box;
  z-index:9000;
  position:absolute;
  display:inline-block;
  top:435px;
  left:506px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .domainfield_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .domainfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:498px;
  left:870px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:435px;
  left:741px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .keyfield_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .keyfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:35px;
  left:368px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:36px;
  left:268px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .valuesfields_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .valuesfields_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .zfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:133px;
  left:368px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .zfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .zfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:112px;
  left:268px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .zfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .zfield_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .zfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .zfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .zfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:318px;
  left:368px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:281px;
  left:268px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .seriesfield_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .seriesfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:416px;
  left:368px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:357px;
  left:268px;
  width:227px;
  height:auto;
  min-height:40px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl {
  height:auto;
  min-height:40px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .skeyfield_ctrl {
  overflow:hidden;
  text-align:center;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .skeyfield_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:470px;
  left:609px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:407px;
  left:506px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblDomainField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:470px;
  left:870px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:407px;
  left:741px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblKeyField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:6px;
  left:368px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:7px;
  left:268px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblValuesField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:104px;
  left:367px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:83px;
  left:267px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblZField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblZField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:289px;
  left:367px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:252px;
  left:267px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblSeriesField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:387px;
  left:367px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:328px;
  left:267px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblSKeyField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:6px;
  left:5px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:6px;
  left:5px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .fieldboxtitle_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl {
  box-sizing:border-box;
  z-index:9002;
  position:absolute;
  display:inline-block;
  top:470px;
  left:608px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl {
  box-sizing:border-box;
  z-index:9002;
  position:absolute;
  display:inline-block;
  top:407px;
  left:505px;
  width:227px;
  height:auto;
  min-height:25px;
}.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl {
  height:auto;
  min-height:25px;
}
.SPChartFieldsConfigurator_portlet > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="980"] > .SPChartFieldsConfigurator_page > .lblCDomainField_ctrl > div{
  text-align:left;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.SPChartFieldsConfigurator_portlet[Data-step="1150"] > .SPChartFieldsConfigurator_page > .Grid30_ctrl {
  box-sizing:border-box;
  z-index:9005;
  position:absolute;
  display:inline-block;
  top:10px;
  left:20px;
  width:1110px;
  height:525px;
}
.SPChartFieldsConfigurator_portlet[Data-step="978"] > .SPChartFieldsConfigurator_page > .Grid30_ctrl {
  box-sizing:border-box;
  z-index:9005;
  position:absolute;
  display:inline-block;
  top:10px;
  left:20px;
  width:938px;
  height:460px;
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
 String def="[{\"h\":\"545\",\"layout_steps_values\":{\"1150\":{\"h\":\"545\",\"w\":\"1150\"},\"978\":{\"h\":\"480\",\"w\":\"978\"},\"980\":{\"h\":\"545\",\"w\":\"980\"}},\"pages_names\":\"a,b\",\"steps\":\"978,1150\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1150\",\"w\":\"1150\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"1203\",\"y\":\"0\"},{\"anchor\":\"top-left\",\"h\":\"501\",\"layout_steps_values\":{\"1150\":{\"anchor\":\"top-left\",\"h\":501,\"hide\":\"false\",\"w\":\"227\",\"x\":5,\"y\":31},\"978\":{\"anchor\":\"top-left\",\"h\":444,\"hide\":\"false\",\"w\":\"227\",\"x\":5,\"y\":31},\"980\":{\"anchor\":\"top-left\",\"h\":501,\"hide\":\"false\",\"w\":\"227\",\"x\":5,\"y\":31}},\"page\":\"1\",\"type\":\"Box\",\"w\":\"227\",\"x\":\"5\",\"y\":\"31\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"450\",\"layout_steps_values\":{\"1150\":{\"anchor\":\"top-left\",\"h\":450,\"hide\":\"false\",\"w\":\"535\",\"x\":609,\"y\":6},\"978\":{\"anchor\":\"top-left\",\"h\":390,\"hide\":\"false\",\"w\":\"467\",\"x\":504,\"y\":7},\"980\":{\"anchor\":\"top-left\",\"h\":390,\"hide\":\"false\",\"w\":467,\"x\":505,\"y\":7}},\"page\":\"1\",\"title\":\"\",\"type\":\"Chart\",\"w\":\"535\",\"x\":\"609\",\"y\":\"6\",\"zindex\":\"5\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{\"1150\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":609,\"y\":498},\"978\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":506,\"y\":435},\"980\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":507,\"y\":435}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Drop here\",\"w\":\"227\",\"x\":\"609\",\"y\":\"498\",\"zindex\":\"9000\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{\"1150\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":870,\"y\":498},\"978\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":741,\"y\":435},\"980\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":742,\"y\":435}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Drop here\",\"w\":\"227\",\"x\":\"870\",\"y\":\"498\",\"zindex\":\"16\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{\"1150\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":368,\"y\":35},\"978\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":36},\"980\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":269,\"y\":36}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Drop here\",\"w\":\"227\",\"x\":\"368\",\"y\":\"35\",\"zindex\":\"16\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{\"1150\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":368,\"y\":133},\"978\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":112},\"980\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":269,\"y\":112}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Drop here\",\"w\":\"227\",\"x\":\"368\",\"y\":\"133\",\"zindex\":\"16\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{\"1150\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":368,\"y\":318},\"978\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":281},\"980\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":269,\"y\":281}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Drop here\",\"w\":\"227\",\"x\":\"368\",\"y\":\"318\",\"zindex\":\"16\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"40\",\"layout_steps_values\":{\"1150\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":368,\"y\":416},\"978\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":357},\"980\":{\"align\":\"center\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":40,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":269,\"y\":357}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Drop here\",\"w\":\"227\",\"x\":\"368\",\"y\":\"416\",\"zindex\":\"16\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":609,\"y\":470},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":506,\"y\":407},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":507,\"y\":407}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Domain field (x axis)\",\"w\":\"227\",\"x\":\"609\",\"y\":\"470\",\"zindex\":\"17\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":870,\"y\":470},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":741,\"y\":407},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":742,\"y\":407}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Domain key field\",\"w\":\"227\",\"x\":\"870\",\"y\":\"470\",\"zindex\":\"17\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":368,\"y\":6},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":7},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":269,\"y\":7}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Values fields (y axis)\",\"w\":\"227\",\"x\":\"368\",\"y\":\"6\",\"zindex\":\"17\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":367,\"y\":104},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":267,\"y\":83},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":83}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Radius field (z axis)\",\"w\":\"227\",\"x\":\"367\",\"y\":\"104\",\"zindex\":\"18\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":367,\"y\":289},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":267,\"y\":252},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":252}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Series field\",\"w\":\"227\",\"x\":\"367\",\"y\":\"289\",\"zindex\":\"17\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":367,\"y\":387},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":267,\"y\":328},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":268,\"y\":328}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Series key field\",\"w\":\"227\",\"x\":\"367\",\"y\":\"387\",\"zindex\":\"18\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":5,\"y\":6},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":5,\"y\":6},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":5,\"y\":6}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Fields list\",\"w\":\"227\",\"x\":\"5\",\"y\":\"6\",\"zindex\":\"17\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"40\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"64\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"112\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"136\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"160\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"184\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"208\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{\"1150\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":608,\"y\":470},\"978\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":505,\"y\":407},\"980\":{\"align\":\"left\",\"anchor\":\"top-left\",\"fontpct\":\"\",\"h\":25,\"hide\":\"false\",\"n_col\":\"1\",\"w\":\"227\",\"x\":506,\"y\":407}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Country field\",\"w\":\"227\",\"x\":\"608\",\"y\":\"470\",\"zindex\":\"9002\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"88\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"232\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"30\",\"x\":\"1245\",\"y\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1203\",\"y\":\"256\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1204\",\"y\":\"281\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Alias\"},{\"title\":\"Description\"}],\"h\":\"525\",\"layout_steps_values\":{\"1150\":{\"anchor\":\"\",\"h\":525,\"hide\":\"false\",\"w\":\"1110\",\"x\":20,\"y\":10},\"978\":{\"anchor\":\"\",\"h\":460,\"hide\":\"false\",\"w\":\"938\",\"x\":20,\"y\":10}},\"page\":\"2\",\"rows\":\"9999\",\"type\":\"Grid\",\"w\":\"1110\",\"x\":\"20\",\"y\":\"10\",\"zindex\":\"9005\"},{\"h\":\"20\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"1179\",\"y\":\"99\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPChartFieldsConfigurator","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPChartFieldsConfigurator_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("ChartObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("chart/demoDataSet.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("ZtChartFunctions.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPChartFieldsConfigurator','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPChartFieldsConfigurator_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.ChartControl.ChartTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/ChartCtrl.js")%>'></script>
<jsp:include page="../chart/ZtChartLibs.jsp"/>
<script src='../<%=SPPrxycizer.proxycizedPath("ZtChart.js")%>'></script>
<%}
String domainfield= "Drop here";
String keyfield= "Drop here";
String valuesfields= "Drop here";
String zfield= "Drop here";
String seriesfield= "Drop here";
String skeyfield= "Drop here";
String lblDomainField= "Domain field (x axis)";
String lblKeyField= "Domain key field";
String lblValuesField= "Values fields (y axis)";
String lblZField= "Radius field (z axis)";
String lblSeriesField= "Series field";
String lblSKeyField= "Series key field";
String fieldboxtitle= "Fields list";
String defname=JSPLib.translateXSS(sp.getParameter("defname",""));
String vqr=JSPLib.translateXSS(sp.getParameter("vqr",""));
String domain=JSPLib.translateXSS(sp.getParameter("domain",""));
String values=JSPLib.translateXSS(sp.getParameter("values",""));
String series=JSPLib.translateXSS(sp.getParameter("series",""));
String key=JSPLib.translateXSS(sp.getParameter("key",""));
String z=JSPLib.translateXSS(sp.getParameter("z",""));
String lblCDomainField= "Country field";
String parms=JSPLib.translateXSS(sp.getParameter("parms",""));
String frompreview=JSPLib.translateXSS(sp.getParameter("frompreview",""));
if(request.getAttribute("SPChartFieldsConfigurator_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
String ptlwizard=JSPLib.translateXSS(sp.getParameter("ptlwizard",""));
String isdataobj=JSPLib.translateXSS(sp.getParameter("isdataobj",""));
if(request.getAttribute("SPChartFieldsConfigurator_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPChartFieldsConfigurator_title_container' style='width:1150px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPChartFieldsConfigurator_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPChartFieldsConfigurator_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPChartFieldsConfigurator','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPChartFieldsConfigurator_page' style='display:block'>
<div id='<%=idPortlet%>_fieldbox' class='fieldbox_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_fieldbox_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_chartfields'></div>
<span id='<%=idPortlet%>_domainfield'  formid='<%=idPortlet%>' ps-name='domainfield'   data-transfer-accept='allfield' class='textbox domainfield_ctrl'><div id='<%=idPortlet%>_domainfieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Drop here")%></div></span>
<span id='<%=idPortlet%>_keyfield'  formid='<%=idPortlet%>' ps-name='keyfield'   data-transfer-accept='allfield' class='textbox keyfield_ctrl'><div id='<%=idPortlet%>_keyfieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Drop here")%></div></span>
<span id='<%=idPortlet%>_valuesfields'  formid='<%=idPortlet%>' ps-name='valuesfields'   data-transfer-accept='allfield' class='textbox valuesfields_ctrl'><div id='<%=idPortlet%>_valuesfieldstbl' style='width:100%;'><%=JSPLib.ToHTML("Drop here")%></div></span>
<span id='<%=idPortlet%>_zfield'  formid='<%=idPortlet%>' ps-name='zfield'   data-transfer-accept='allfield' class='textbox zfield_ctrl'><div id='<%=idPortlet%>_zfieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Drop here")%></div></span>
<span id='<%=idPortlet%>_seriesfield'  formid='<%=idPortlet%>' ps-name='seriesfield'   data-transfer-accept='allfield' class='textbox seriesfield_ctrl'><div id='<%=idPortlet%>_seriesfieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Drop here")%></div></span>
<span id='<%=idPortlet%>_skeyfield'  formid='<%=idPortlet%>' ps-name='skeyfield'   data-transfer-accept='allfield' class='textbox skeyfield_ctrl'><div id='<%=idPortlet%>_skeyfieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Drop here")%></div></span>
<span id='<%=idPortlet%>_lblDomainField'  formid='<%=idPortlet%>' ps-name='lblDomainField'    class='label labelbox lblDomainField_ctrl'><div id='<%=idPortlet%>_lblDomainFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Domain field (x axis)")%></div></span>
<span id='<%=idPortlet%>_lblKeyField'  formid='<%=idPortlet%>' ps-name='lblKeyField'    class='label labelbox lblKeyField_ctrl'><div id='<%=idPortlet%>_lblKeyFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Domain key field")%></div></span>
<span id='<%=idPortlet%>_lblValuesField'  formid='<%=idPortlet%>' ps-name='lblValuesField'    class='label labelbox lblValuesField_ctrl'><div id='<%=idPortlet%>_lblValuesFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Values fields (y axis)")%></div></span>
<span id='<%=idPortlet%>_lblZField'  formid='<%=idPortlet%>' ps-name='lblZField'    class='label labelbox lblZField_ctrl'><div id='<%=idPortlet%>_lblZFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Radius field (z axis)")%></div></span>
<span id='<%=idPortlet%>_lblSeriesField'  formid='<%=idPortlet%>' ps-name='lblSeriesField'    class='label labelbox lblSeriesField_ctrl'><div id='<%=idPortlet%>_lblSeriesFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Series field")%></div></span>
<span id='<%=idPortlet%>_lblSKeyField'  formid='<%=idPortlet%>' ps-name='lblSKeyField'    class='label labelbox lblSKeyField_ctrl'><div id='<%=idPortlet%>_lblSKeyFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Series key field")%></div></span>
<span id='<%=idPortlet%>_fieldboxtitle'  formid='<%=idPortlet%>' ps-name='fieldboxtitle'    class='label labelbox fieldboxtitle_ctrl'><div id='<%=idPortlet%>_fieldboxtitletbl' style='width:100%;'><%=JSPLib.ToHTML("Fields list")%></div></span>
<span id='<%=idPortlet%>_lblCDomainField'  formid='<%=idPortlet%>' ps-name='lblCDomainField'    class='label lblCDomainField_ctrl'><div id='<%=idPortlet%>_lblCDomainFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Country field")%></div></span>
</div>
<div id='<%=idPortlet%>_page_2' class='SPChartFieldsConfigurator_page' style='display:none'>
<div id='<%=idPortlet%>_Grid30' formid='<%=idPortlet%>' ps-name='Grid30'   class='grid' style=''>&nbsp;</div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPChartFieldsConfigurator');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_APPLY",true)+","+JSPLib.ToJSValue(sp.translate("RPT_APPLY"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPChartFieldsConfigurator_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("a"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("b"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPChartFieldsConfigurator',["1150"],["545"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'978,1150', 'fixed','<%=m_cTITLEUID%>','',{"1150":{"h":"545","w":"1150"},"978":{"h":"480","w":"978"},"980":{"h":"545","w":"980"}},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"980":{"w":"980","h":"545"},"978":{"w":"978","h":"480"},"1150":{"w":"1150","h":"545"}},"w":"1150","h":"545","title":"a","layer":"false","npage":"1"},{"layout_steps_values":{"980":{"w":"980","h":"545"},"978":{"w":"978","h":"480"},"1150":{"w":"1150","h":"545"}},"w":"1150","h":"545","title":"b","layer":"false","npage":"2"}]);
this.SQLDataobj=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":30,"x":1203,"y":0});
this.fieldbox=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_fieldbox","groupName":"","h":444,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{"1150":{"anchor":"top-left","h":501,"hide":"false","w":"227","x":5,"y":31},"978":{"anchor":"top-left","h":444,"hide":"false","w":"227","x":5,"y":31},"980":{"anchor":"top-left","h":501,"hide":"false","w":"227","x":5,"y":31}},"name":"fieldbox","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":227,"x":5,"y":31,"zindex":"4"});
this.chartfields=new ZtVWeb.ChartCtrl(this,{"add_dataobj":"","anchor":"top-left","auto_exec":false,"categoryKeyName":"","categoryname":"","ccolor":"","chartH":"","chartNavbar":false,"chartNavbarAddRemove":false,"chartNavbarChangepage":false,"chartNavbarFirstlast":false,"chartNavbarLastpage":false,"chartNavbarPagepanel":false,"chartW":"","chart_type":"category","class_cat":"","class_key":"","class_keycat":"","class_label":"","class_subaxis":"","class_xfrom":"","class_xto":"","class_xval":"","class_yfrom":"","class_yto":"","class_yval":"","compactChart":"","countryname":"","cstroke":"","csubname":"","ctooltip":"hide","ctrlid":"<%=idPortlet%>_chartfields","ctype":"","cursorAlignment":"","cursorPosition":"","cursorType":"","danimation":"","data_order":"default","dataload_datelimit":"","dataobj":"SQLDataobj","dateformat":"","def":"","depclass":"","depfield_1":"","depfield_1class":"","depfield_1label":"","depfield_2":"","depfield_2class":"","depfield_2label":"","depvalue":"","domain_type":"","downloadlist":"","dsetFunct":"","elanimate":"disable","enable_change_order":false,"enable_menu_sel":false,"exclSer":"","exclicks":false,"exportFileName":"","fieldpath":"","fieldvalue":"","focuskey":"","gendataset":false,"geo_0_field":"","geo_1_field":"","geo_dom_field":"","geo_level":"0","geo_level_2":"","geo_level_3":"","geo_onlydata":"","geo_value_field":"","geo_view":"","geo_view_select":"","grch_domain":"","grch_fields":"","grch_key":"","grch_serie":"","grch_values":"","grid_chart":"","h":390,"hide":"false","ismulti":false,"key_start":"","keyfieldpath":"","labelKey_field":"","label_field":"","label_series":"","layer":false,"layout_steps_values":{"1150":{"anchor":"top-left","h":450,"hide":"false","w":"535","x":609,"y":6},"978":{"anchor":"top-left","h":390,"hide":"false","w":"467","x":504,"y":7},"980":{"anchor":"top-left","h":390,"hide":"false","w":467,"x":505,"y":7}},"legend":"hide","legendlimit":"","linkparms":"","manualScale":"","mapSeries":"","markers_dataobj":"","markers_desc":"","markers_key":"","markers_lat":"","markers_lng":"","markers_type":"","max_field":"","max_value":"","measureKey_series_field":"","measure_series_field":"","menuPosition":"hide","min_field":"","min_value":"","multi_autochange":false,"multi_key_field":"","multi_label_field":"","multi_scale":true,"multidimKeyName":"","multisubdivision":"","multisubheight":"","name":"chartfields","other_chart":"","othfunc":"","othlabel":"","othlimits":"","othmenu":"","othtype":"","page":1,"parms":"","percent_label":"","pic_cust":"","pic_prefix":"","pic_suffix":"","pic_type":"","popup":true,"popup_height":"","popup_type":"","popup_width":"","portletsrc":"","ptl_translate":false,"query":"","rangebands":"","rangefunc":"","refline":"","reflinecol":"","selclicks":false,"seriesname":"","sfield":"","sfieldlabel":"","subtitle":"","target":"","tcustformat":"","tdomainunit":"","tdomainvalue":"","tick_unit":"","title":"","titleSeries":"","tth":"","ttout":"","ttpos":"fixed","ttw":"","ttx":"","tty":"","type":"Chart","typecondform":"","url":"","urlType":"","val_field":"","value_fields":"","value_labels":"default","valuename":"","valuezname":"","vaxis_precision":"","vmode":"","voro_cat":"","voro_class":"","voro_coords":"","w":467,"x":504,"xKey_field":"","x_field":"","x_label":"","xmax_value":"","xmin_value":"","xrefline":"","xreflinecol":"","xtick_unit":"","xyz_series_field":"","y":7,"y_field":"","y_label":"","z_field":"","zfseries":"","zfshow":"","zftype":"default","zindex":"5"});
this.domainfield=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlid":"<%=idPortlet%>_domainfield","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":609,"y":498},"978":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":506,"y":435},"980":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":507,"y":435}},"n_col":1,"name":"domainfield","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(domainfield,false,true)%>","type":"Label","w":227,"x":506,"y":435,"zindex":"9000"});
this.keyfield=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlid":"<%=idPortlet%>_keyfield","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":870,"y":498},"978":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":741,"y":435},"980":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":742,"y":435}},"n_col":1,"name":"keyfield","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(keyfield,false,true)%>","type":"Label","w":227,"x":741,"y":435,"zindex":"16"});
this.valuesfields=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlid":"<%=idPortlet%>_valuesfields","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":368,"y":35},"978":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":268,"y":36},"980":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":269,"y":36}},"n_col":1,"name":"valuesfields","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(valuesfields,false,true)%>","type":"Label","w":227,"x":268,"y":36,"zindex":"16"});
this.zfield=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlid":"<%=idPortlet%>_zfield","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":368,"y":133},"978":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":268,"y":112},"980":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":269,"y":112}},"n_col":1,"name":"zfield","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(zfield,false,true)%>","type":"Label","w":227,"x":268,"y":112,"zindex":"16"});
this.seriesfield=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlid":"<%=idPortlet%>_seriesfield","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":368,"y":318},"978":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":268,"y":281},"980":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":269,"y":281}},"n_col":1,"name":"seriesfield","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(seriesfield,false,true)%>","type":"Label","w":227,"x":268,"y":281,"zindex":"16"});
this.skeyfield=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlid":"<%=idPortlet%>_skeyfield","draggable":"","draggable_name":"","droppable":"true","droppable_name":"allfield","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":40,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":368,"y":416},"978":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":268,"y":357},"980":{"align":"center","anchor":"top-left","fontpct":"","h":40,"hide":"false","n_col":"1","w":"227","x":269,"y":357}},"n_col":1,"name":"skeyfield","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(skeyfield,false,true)%>","type":"Label","w":227,"x":268,"y":357,"zindex":"16"});
this.lblDomainField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDomainField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":609,"y":470},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":506,"y":407},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":507,"y":407}},"n_col":1,"name":"lblDomainField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblDomainField,false,true)%>","type":"Label","w":227,"x":506,"y":407,"zindex":"17"});
this.lblKeyField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_lblKeyField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":870,"y":470},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":741,"y":407},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":742,"y":407}},"n_col":1,"name":"lblKeyField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblKeyField,false,true)%>","type":"Label","w":227,"x":741,"y":407,"zindex":"17"});
this.lblValuesField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_lblValuesField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":368,"y":6},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":268,"y":7},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":269,"y":7}},"n_col":1,"name":"lblValuesField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblValuesField,false,true)%>","type":"Label","w":227,"x":268,"y":7,"zindex":"17"});
this.lblZField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_lblZField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":367,"y":104},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":267,"y":83},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":268,"y":83}},"n_col":1,"name":"lblZField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblZField,false,true)%>","type":"Label","w":227,"x":267,"y":83,"zindex":"18"});
this.lblSeriesField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSeriesField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":367,"y":289},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":267,"y":252},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":268,"y":252}},"n_col":1,"name":"lblSeriesField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblSeriesField,false,true)%>","type":"Label","w":227,"x":267,"y":252,"zindex":"17"});
this.lblSKeyField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSKeyField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":367,"y":387},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":267,"y":328},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":268,"y":328}},"n_col":1,"name":"lblSKeyField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblSKeyField,false,true)%>","type":"Label","w":227,"x":267,"y":328,"zindex":"18"});
this.fieldboxtitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label labelbox","create_undercond":"","ctrlid":"<%=idPortlet%>_fieldboxtitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":5,"y":6},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":5,"y":6},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":5,"y":6}},"n_col":1,"name":"fieldboxtitle","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(fieldboxtitle,false,true)%>","type":"Label","w":227,"x":5,"y":6,"zindex":"17"});
this.defname=new ZtVWeb._VC(this,'defname',null,'character','<%=JSPLib.ToJSValue(defname,false,true)%>',false,false);
this.vqr=new ZtVWeb._VC(this,'vqr',null,'character','<%=JSPLib.ToJSValue(vqr,false,true)%>',false,false);
this.domain=new ZtVWeb._VC(this,'domain',null,'character','<%=JSPLib.ToJSValue(domain,false,true)%>',false,false);
this.values=new ZtVWeb._VC(this,'values',null,'character','<%=JSPLib.ToJSValue(values,false,true)%>',false,false);
this.series=new ZtVWeb._VC(this,'series',null,'character','<%=JSPLib.ToJSValue(series,false,true)%>',false,false);
this.key=new ZtVWeb._VC(this,'key',null,'character','<%=JSPLib.ToJSValue(key,false,true)%>',false,false);
this.z=new ZtVWeb._VC(this,'z',null,'character','<%=JSPLib.ToJSValue(z,false,true)%>',false,false);
this.lblCDomainField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCDomainField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1150":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":608,"y":470},"978":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":505,"y":407},"980":{"align":"left","anchor":"top-left","fontpct":"","h":25,"hide":"false","n_col":"1","w":"227","x":506,"y":407}},"n_col":1,"name":"lblCDomainField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblCDomainField,false,true)%>","type":"Label","w":227,"x":505,"y":407,"zindex":"9002"});
this.parms=new ZtVWeb._VC(this,'parms',null,'character','<%=JSPLib.ToJSValue(parms,false,true)%>',false,false);
this.frompreview=new ZtVWeb._VC(this,'frompreview',null,'character','<%=JSPLib.ToJSValue(frompreview,false,true)%>',false,false);
this.StaticDataobj=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StaticDataobj","dataproviders":"","fieldsString":"","fieldstypeString":"","h":30,"hide":"false","layer":false,"layout_steps_values":{},"name":"StaticDataobj","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":30,"x":1245,"y":0});
this.ptlwizard=new ZtVWeb._VC(this,'ptlwizard',null,'character','<%=JSPLib.ToJSValue(ptlwizard,false,true)%>',false,false);
this.isdataobj=new ZtVWeb._VC(this,'isdataobj',null,'character','<%=JSPLib.ToJSValue(isdataobj,false,true)%>',false,false);
this.Grid30=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"ALIAS","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid30","dataobj":"dataobj_fields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":460,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{"1150":{"anchor":"","h":525,"hide":"false","w":"1110","x":20,"y":10},"978":{"anchor":"","h":460,"hide":"false","w":"938","x":20,"y":10}},"line_color":"","link_underlined":"","name":"Grid30","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":938,"x":20,"y":10,"zindex":"9005"});
this.Grid30.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":9999,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Alias","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"ALIAS","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Description","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DESC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.dataobj_fields=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_dataobj_fields","dataproviders":"","fieldsString":"ALIAS,DESC","fieldstypeString":"C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"dataobj_fields","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":1179,"y":99});
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
<%if(request.getAttribute("SPChartFieldsConfigurator_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPChartFieldsConfigurator_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPChartFieldsConfigurator_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.chartfields._ChartTranslations = {title:'<%=JSPLib.ToJSValue(sp.translate(""))%>',subtitle:'<%=JSPLib.ToJSValue(sp.translate(""))%>',x_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',y_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',percent_label:'<%=JSPLib.ToJSValue(sp.translate(""))%>',titleSeries:'<%=JSPLib.ToJSValue(sp.translate(""))%>',othlabel:'<%=JSPLib.ToJSValue(sp.translate(""))%>',label_series:''}
window.<%=idPortlet%>.chartfields._createChart()
ZtVWeb.addPortletObj('<%=idPortlet%>','SPChartFieldsConfigurator',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPChartFieldsConfigurator');
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
sp.endPage("SPChartFieldsConfigurator");
}%>
<%! public String getJSPUID() { return "3079104790"; } %>