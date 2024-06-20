/* exported drawReportWizard */

/* ***** Metodi necessari il Wizard SPWebReporWizard_portlet ***** */
function drawReportWizard() {
  //var customToolbar; // Riferimento all'oggetto portlet utilizzato come titolo dalla maschera di stampa
  var campi = ['field', 'desc'];
  var campiTotal = ['field', 'desc', 'total'];
  this.boxImage1.Hide();
  this.TempAllFields = null;
  this.TempQueryFields = null;
  //customToolbar = this.getTitlePortlet();

  this.drawWizard = function() {
    this.setDecoratorTitle();
    this.reportName.SetFocus();
    var data = ['t,CC,-1'];

    this.dataObjFields.FillExtData(campi, data);
    this.dataObjGrH1.FillExtData(campi, data);
    this.dataObjGrF1.FillExtData(campiTotal, data);
  }

  this.getOpener = function () {
    return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));
  }

  /* Gestione delle pagine del Wizard */
  this.this_EnablePage1 = function () {
    return true;
  }

  this.this_EnablePage2 = function () {
    if (this._enablePage2 == undefined) {
      this._enablePage2 = false;
    }
    return this._enablePage2;
  }

  this.this_EnablePage3 = function () {
    if (this._enablePage3 == undefined) {
      this._enablePage3 = false;
    }
    return this._enablePage3;
  }

  this.this_EnablePage4 = function () {
    if (this._enablePage4 == undefined) {
      this._enablePage4 = false;
    }
    return this._enablePage4;
  }

  this.this_EnablePage5 = function () {
    if (this._enablePage5 == undefined) {
      this._enablePage5 = false;
    }
    return this._enablePage5;
  }

  this.this_AfterPageChange = function (n) {
    if (n == 1) {
      this.reportName.SetFocus();
      this.RemoveGenerateOnToolbar();
      this._enablePage2 = this.validateReport();
      this._enablePage3 = false;
      this._enablePage4 = false;
      this._enablePage5 = false;
    }
    else if (n == 2) {
      this.queryName.SetFocus();
      this.RemoveGenerateOnToolbar();
      this._enablePage3 = this.validateQueryAndSelection();
      this._enablePage4 = false;
      this._enablePage5 = false;
    }
    else if (n == 3) {
      this.popolateDataobjNoTotal(this.MemCurGrH1, this.dataObjGrH1);
      this.popolateDataobjWTotal(this.MemCurGrF1, this.dataObjGrF1);
      this.hideTotalField(this.MemCurGrF1, this.gridFieldsF1);
      this.groupDesc1.SetFocus();
      this.RemoveGenerateOnToolbar();
      this._enablePage4 = true;
      this._enablePage5 = false;
    }
    else if (n == 4) {
      this.popolateDataobjNoTotal(this.MemCurGrH2, this.dataObjGrH2);
      this.popolateDataobjWTotal(this.MemCurGrF2, this.dataObjGrF2);
      this.hideTotalField(this.MemCurGrF2, this.gridFieldsF2);
      this.groupDesc2.SetFocus();
      this.RemoveGenerateOnToolbar();
      this._enablePage5 = true;
    }
    else if (n == 5) {
      this.popolateDataobjNoTotal(this.MemCurGrH3, this.dataObjGrH3);
      this.popolateDataobjWTotal(this.MemCurGrF3, this.dataObjGrF3);
      this.hideTotalField(this.MemCurGrF3, this.gridFieldsF3);
      this.groupDesc3.SetFocus();
      this.AddGenerateOnToolbar();
    }
    for (var i = 1; i <= this.nPages; i++) {
      this.EnablePage(i);
    }
  }

  /* Inserisce i campi selezionati nella griglia gridFields nei memory cursor usati dalle pagine 3, 4, 5. */
  this.popolateDataobj = function(memcurs, fieldsProp, datasource) {
    while (memcurs.RecCount() > 0) {
      memcurs.Remove(memcurs.RecCount());
    }

    var i = 0;
    for (i = 0; i < fieldsProp.length; i++) {
      memcurs.CreateFld(fieldsProp[i], "C");
    }

    var data, s;
    if (this.gridFields.AllChecked()) {
      data = this.TempAllFields;
    }
    else {
      data = this.gridFields.GetSelectedData().Data;
    }
    for (i = 0; i < data.length - 1; i++) {
      s = data[i];
      memcurs.AppendBlank();
      memcurs.Set(fieldsProp[0], s[0]);
      memcurs.Set(fieldsProp[1], s[1]);
    }
    memcurs.InToDatasource(datasource);
  }

  this.popolateDataobjNoTotal = function (memcurs, datasource) {
    this.popolateDataobj(memcurs, campi, datasource);
    /*while (memcurs.RecCount() > 0) {
      memcurs.Remove(memcurs.RecCount());
    }

    for (var i = 0; i < campiTotal.length - 1; i++) {
      memcurs.CreateFld(campiTotal[i], "C");
    }
    memcurs.CreateFld(campiTotal[campiTotal.length - 1], "L");

    var data;
    if (this.gridFields.AllChecked()) {
      data = this.TempAllFields;
    }
    else {
      data = this.gridFields.GetSelectedData().Data;
    }
    for (var i = 0; i < data.length - 1; i++) {
      s = data[i];
      memcurs.AppendBlank();
      memcurs.Set(campiTotal[0], s[0]);
      memcurs.Set(campiTotal[1], s[1]);
    }
    memcurs.InToDatasource(datasource);*/
  }

  this.popolateDataobjWTotal = function (memcurs, datasource) {
    this.popolateDataobj(memcurs, campiTotal, datasource);
    /*while (memcurs.RecCount() > 0) {
      memcurs.Remove(memcurs.RecCount());
    }

    for (var i = 0; i < campiTotal.length - 1; i++) {
      memcurs.CreateFld(campiTotal[i], "C");
    }
    memcurs.CreateFld(campiTotal[campiTotal.length - 1], "L");

    var data;
    if (this.gridFields.AllChecked()) {
      data = this.TempAllFields;
    }
    else {
      data = this.gridFields.GetSelectedData().Data;
    }
    for (var i = 0; i < data.length - 1; i++) {
      s = data[i];
      memcurs.AppendBlank();
      memcurs.Set(campiTotal[0], s[0]);
      memcurs.Set(campiTotal[1], s[1]);
    }
    memcurs.InToDatasource(datasource);*/
  }
  /* Nasconde il check Total per i campi di tipo diverso dal Numerico */
  this.hideTotalField = function (memcurs, datagrid) {
    var col = 2;
    for (var i = 0; i < memcurs.RecCount(); i++) {
      memcurs.GoTo(i + 1);
      var pos = LibJavascript.Array.indexOf(this.TempQueryFields[0], memcurs.Get("field"));
      if (pos >= 0) {
        var type = this.TempQueryFields[2][pos];
        if (type != "N") {
          var ctrl = Ctrl(datagrid.ctrlid + "_" + i + "_" + col + "_input");
          if (ctrl) {
            ctrl.style.display = 'none';
          }
        }
      }
    }
  }

  /* Creazione dell'espressione di Group. */
  this.groupBuildExpr_Click = function (groupID) {
    //wizardquery = this.queryName.Value();
    var url = "../portalstudio/expression_builder.jsp?ExpressionID=" + URLenc(this.formid + "_groupBy" + groupID ) + "&callerFunction=ExpressionBuilderReturn&tool=report";
    if (IsIE() && getInternetExplorerVersion() <= 8) {
      var width = 600, height = 400;
      var left = (screen.width) ? (screen.width - width) / 2 : 100;
      var top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
      window.open(url, "Build_Expression_Group_" + groupID, "height=500,width=600,left=" + left + ",top=" + top + ",resizable=yes");
    }
    else {
      url += "&Build_Expression_Group_" + groupID + "&SPModalLayerId=g" + groupID + "ExpBuildSPModalLayer";
      layerOpenForeground(url, '', '', null, null, null, 1);
    }
  }

  /* ***** Pagina 1 ***** */

  /* Validazione del nome del report.*/
  /* Se il nome del report e' valido, si abilita la pagina successiva.
     Nel caso non sia valido, il focus torna sulla Textbox dove indicare il nome.
  */
  this.reportName_onChange = function () {
    this._enablePage2 = this.validateReport(true);
    for (var i = 2; i <= this.nPages; i++) {
      this.EnablePage(i);
    }
  }

  /* Validazione del nome del report.
     Il nome del report non deve:
     * essere formato da soli spazi,
     * contenere caratteri che non siano alfanumerici o il carattere '_',
     * essere gia' stato utilizzato.
  */
  this.validateReport = function (withAlert) {
    if (Empty(Trim(this.reportName.Value()))) {
      return false;
    }
    else if (!(/^[a-zA-Z][A-Za-z0-9-_]*$/.test(this.reportName.Value()))) {
      if (withAlert == true) {
        PSAlert.alert('Invalid report file name...');
      }
      return false;
    }
    var url = new JSURL("../servlet/JSPReader?type=webreport&name=" + Trim(this.reportName.Value()) + "&check=true", true);
    var output = url.Response();
    if (output == "found") {
      if (withAlert == true) {
        PSAlert.alert("File already existing, cannot overwrite.");
        this.reportName.SetFocus();
      }
      return false;
    }
    return true;
  }

  /* Selezione del modello del report
     Selezionando uno dei due modelli, l'altro deve essere deselezionato. La selezione e' mutualmente esclusiva.
     Si visualizza un box di sfondo al modello selezionato.
  */
  this.reportmodel1_onChange = function () {
    this.reportmodel2.Value(!this.reportmodel1.Value())
  }

  this.reportmodel2_onChange = function () {
    this.reportmodel1.Value(!this.reportmodel2.Value())
  }

  this.model1img_Click = function () {
    this.reportmodel1.Value(true);
    this.reportmodel2.Value(false);
    this.boxImage1.Show();
    this.boxImage2.Hide();
  }

  this.model2img_Click = function () {
    this.reportmodel1.Value(false);
    this.reportmodel2.Value(true);
    this.boxImage1.Hide();
    this.boxImage2.Show();
  }

  /* ***** Pagina 2 ***** */

  /* Selezione della query da usare nel report */
  this.bPage1SelectQuery_Click = function () {
    var url = "../portalstudio/open.jsp?tool=visualquery&onetool=true&ExpressionID=" + URLenc(this.formid + "_queryName") + "&callerFunction=ExpressionBuilderReturn";
    if (IsIE() && getInternetExplorerVersion() <= 8) {
      var width = 600, height = 400;
      var left = (screen.width) ? (screen.width - width) / 2 : 100;
      var top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
      window.open(url, "visualquery", "height=500,width=600,left=" + left + ",top=" + top + ",resizable=yes");
    }
    else {
      url += "&visualquery&SPModalLayerId=querySPModalLayer";
      layerOpenForeground(url, '', '', null, null, null, 1);
    }
  }

  /* Modifica della query da usare nel report */
  this.bPage1EditQuery_Click = function () {
    layerOpenForeground("../visualquery/index.jsp?filename=" + this.queryName.Value(), "Edit_Query", '', '', null, null, null, 1);
  }

  /* Creazione della query da usare nel report */
  this.bPage1NewQuery_Click = function () {
    layerOpenForeground("../visualquery/index.jsp", "New_Query", '', '', null, null, null, 1);
  }

  /*
  this.queryName_Lostfocus = function () {
    var v = this.queryName.Value();
    if (EmptyString(v)){
      this.bPage1EditQuery.Disabled();
    }
    else {
      this.bPage1EditQuery.Enabled();
    }
  }*/

  /* Estrae i campi dalla query selezionata e li carica in un dataObj per visualizzarli in una griglia. */
  this.queryName_onChange = function () {
    this.TempQueryFields = this.GetQueryFields(this.queryName.Value(), true);
    // definisco le colonne
    var data = "[";
    var i = 0;
    for (i = 0; i < this.TempQueryFields[0].length; i++) {
      data = data + "['" + LRTrim(this.TempQueryFields[0][i]) + "',";
      data = data + "'" + Strtran(LRTrim(this.TempQueryFields[1][i]), "'", " ") + "'],";
    }
    data = data + "'t,CC,-1']";
    this.TempAllFields = eval(data);
    // popolo il DataObj
    this.dataObjFields.FillExtData(campi, this.TempAllFields);
    //svuota le grid
    this.dataObjGrH1.FillExtData(campi, this.TempAllFields);
    this.dataObjGrF1.FillExtData(campiTotal, this.TempAllFields);
    this.MemCurGrH1.RemoveAll();
    this.MemCurGrF1.RemoveAll();
    this.MemCurGrH2.RemoveAll();
    this.MemCurGrF1.RemoveAll();
    this.MemCurGrH3.RemoveAll();
    this.MemCurGrF3.RemoveAll();
    if (Trim(this.queryName.Value()) != '' && this.TempQueryFields[0].length == 0) {
      PSAlert.alert('Invalid Visual Query.');
    }
    this._enablePage3 = false;
    this.gridFields.AllChecked(false);
    for (i = 3; i <= this.nPages; i++) {
      this.EnablePage(i);
    }
  }

  /* Estrae i campi dalla query selezionata. */
  this.GetQueryFields = function (queryname, retDesc) {
    var res = [], types = [], len = [], dec = [], desc = [];
    var rows;
    var AllField = new JSURL("../servlet/SPVQRProxy?action=fields&filename=" + queryname, true);
    AllField = AllField.Response();

    if (Left(AllField, 9) == "BO_QUERY:") {
      AllField = Substr(AllField, 10);
      var CSV_SEP = "#!$";
      var row;
      rows = AllField.split(CSV_SEP);
      for (var i = 0; i < rows.length; i++) {
        row = rows[i].split("|");
        res.push(row[0]);
        if (retDesc == true) {
          desc.push(row[2]);
        }
        types.push(row[1]);
        len.push(row[3]);
        dec.push(row[4]);
      }
    }
    else {
      var l_oFields = new TrsJavascript();
      l_oFields.reset();
      l_oFields.SetRow(0);
      l_oFields.BuildProperties(AllField);
      rows = GetProperty(l_oFields, 'Rows', 'N');
      for (var k = 0; k < rows; k++) {
        l_oFields.SetRow(k);
        res.push(GetProperty(l_oFields, 'alias', 'C'));
        if (retDesc == true) {
          desc.push(GetProperty(l_oFields, 'desc', 'C'));
        }
        types.push(GetProperty(l_oFields, 'type', 'C'));
        len.push(GetProperty(l_oFields, 'len', 'N'));
        dec.push(GetProperty(l_oFields, 'dec', 'N'));
      }
    }
    return retDesc ? [res, desc, types, len, dec] : [res, types, len, dec];
  }

  this.validateQueryAndSelection = function () {
    var dataSelected = this.gridFields.AllChecked() || this.gridFields.GetSelectedData().Data.length > 1;
    if (dataSelected && !Empty(this.queryName.Value()) && this.TempQueryFields != null && this.TempQueryFields[0] && this.TempQueryFields[0].length > 0) {
      return true;
    }
    return false;
  }

  this.gridFields_SelectionChange = function () {
    this._enablePage3 = this.validateQueryAndSelection();
    for (var i = 3; i <= this.nPages; i++) {
      this.EnablePage(i);
    }
  }

  this.gridFields_SelectAllChange = function () {
    this._enablePage3 = this.validateQueryAndSelection();
    for (var i = 3; i <= this.nPages; i++) {
      this.EnablePage(i);
    }
  }

  /* ***** Pagina 3 ***** */
  this.groupBuild11_Click = function () {
    this.groupBuildExpr_Click('1');
  }

  this.gridFieldsF1_SelectionChange = function () {
    this.hideTotalField(this.MemCurGrF1, this.gridFieldsF1);
  }

  /* ***** Pagina 4 ***** */

  this.groupBuild21_Click = function () {
    this.groupBuildExpr_Click('2');
  }

  this.gridFieldsF2_SelectionChange = function () {
    this.hideTotalField(this.MemCurGrF2, this.gridFieldsF2);
  }

  /* ***** Pagina 5 ***** */
  this.groupBuild31_Click = function () {
    this.groupBuildExpr_Click('3');
  }

  this.gridFieldsF3_SelectionChange = function () {
    this.hideTotalField(this.MemCurGrF3, this.gridFieldsF3);
  }

  /* Salvataggio del report */
   this.bSave_Click = function () {
    var opener = getOpener();
    var JsonWizardReport = {
      type: 'report-wizard'
    };

    var i = 0;
    var JsonGroups = [], data = [], tmpFields = {};
    var JsonGroup1 = { 'groupName': 'group1' }, JsonGroup2 = { 'groupName': 'group2' }, JsonGroup3 = { 'groupName': 'group3' };

    JsonWizardReport["reportTitle"] = URLenc(Trim(this.reportTitle.Value()));
    JsonWizardReport["reportQuery"] = Trim(this.queryName.Value());
    if (this.reportmodel1.Value() == true) {
      JsonWizardReport["reportModel"] = "modelreportwizard_2";
    }
    else {
      JsonWizardReport["reportModel"] = "modelreportwizard_1";
    }
    JsonWizardReport["fieldsOutputName"]  = this.radioFieldsOutputName.Value();

    if (this.gridFields.AllChecked()) {
      JsonWizardReport["allFields"] = "true";
    }
    else {
      var reportFields = "";
      data = this.gridFields.mem_curs ? this.gridFields.GetSelectedData().Data : [];
      JsonWizardReport["allFields"] = "false";
      for (i = 0; i < data.length - 1; i++) {
        reportFields += data[i][0] + ",";
      }
      JsonWizardReport["reportFields"] = reportFields;
    }

    // Espressioni e descrizione dei gruppi
    JsonGroup1["groupBy"] = (!Empty(Trim(this.groupBy1.Value())) ? URLenc(Trim(this.groupBy1.Value())) : '1=1');
    JsonGroup2["groupBy"] = URLenc(Trim(this.groupBy2.Value()));
    JsonGroup3["groupBy"] = URLenc(Trim(this.groupBy3.Value()));
    JsonGroup1["groupDesc"] = URLenc(Trim(this.groupDesc1.Value()));
    JsonGroup2["groupDesc"] = URLenc(Trim(this.groupDesc2.Value()));
    JsonGroup3["groupDesc"] = URLenc(Trim(this.groupDesc3.Value()));

    //Headers
    data = this.gridFieldsH1.mem_curs ? this.gridFieldsH1.GetSelectedData().Data : [];
    for (i = 0; i < data.length - 1; i++) {
      tmpFields[data[i][0]] = "false";
    }
    JsonGroup1["groupHeader"] = tmpFields;
    data = [], tmpFields = {};
    data = this.gridFieldsH2.mem_curs ? this.gridFieldsH2.GetSelectedData().Data : [];
    for (i = 0; i < data.length - 1; i++) {
      tmpFields[data[i][0]] = 'false';
    }
    JsonGroup2["groupHeader"] = tmpFields;
    data = [], tmpFields = {};
    data = this.gridFieldsH3.mem_curs ? this.gridFieldsH3.GetSelectedData().Data : [];
    for (i = 0; i < data.length - 1; i++) {
      tmpFields[data[i][0]] = 'false';
    }
    JsonGroup3["groupHeader"] = tmpFields;

    //Footers
    data = [], tmpFields = {};
    data = this.gridFieldsF1.mem_curs ? this.gridFieldsF1.GetSelectedData().Data : [];
    for (i = 0; i < data.length - 1; i++) {
      tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));
    }
    JsonGroup1["groupFooter"] = tmpFields;
    data = [], tmpFields = {};
    data = this.gridFieldsF2.mem_curs ? this.gridFieldsF2.GetSelectedData().Data : [];
    for (i = 0; i < data.length - 1; i++) {
      tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));
    }
    JsonGroup2["groupFooter"] = tmpFields;
    data = [], tmpFields = {};
    data = this.gridFieldsF3.mem_curs ? this.gridFieldsF3.GetSelectedData().Data : [];
    for (i = 0; i < data.length - 1; i++) {
      tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));
    }
    JsonGroup3["groupFooter"] = tmpFields;
    JsonGroups.push(JsonGroup1);
    JsonGroups.push(JsonGroup2);
    JsonGroups.push(JsonGroup3);
    JsonWizardReport["groups"] = JsonGroups;
    var serv = new JSURL('../servlet/spreportwizard?reportName=' + Trim(this.reportName.Value()) + "&JsonWizardReport=" + URLenc(JSON.stringify(JsonWizardReport))).Response();
    if (serv.indexOf('Function return value:true') >= 0) {
      if (opener) {
        if (opener.newCurrentObj) {
          opener.newCurrentObj(Trim(this.reportName.Value()), 'report');
          if (opener.NavForm) {
            opener.NavForm();
          }
          window.close();
        }
        else {
          window.open("../reporteditor/index.jsp?id=" + Trim(this.reportName.Value()) + "&custom=false", '_self');
        }
      }
      else {
        window.open("../reporteditor/index.jsp?id=" + Trim(this.reportName.Value()) + "&custom=false", '_self');
      }
    }
    else {
      var err = 'RPT_REPORT_WIZARD_ERROR';
      window.open("../jsp-system/SPReportMaskMessage_portlet.jsp?msgBox=" + err, '_self')
    }
  }

  /* *** Esecuzione *** */
  try{
    this.drawWizard();
  }
  catch(e){
    console.log(e.stack)
  }
}