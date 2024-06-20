// This array holds all table data       |
// index      field info                 |
//   0        table logical name         |
//   1        table physical name        |
//   2        table comment              |
//   3        check                      |
//   4        company                    |
//   5        extender type              |
//   6        array of all fields        |
//      |~>                              |
//         1       field name            |
//         0       field description     |
//         2       field type            |
//         3       field len             |
//         4       field dec             |
//         5       extender type         |
//   7        array of all relation      |
//         0       Description           |
//         1       Linked Field          |
//         2       Linked Table          |
//         3       Linked Table Field    |
//         4       Join Type             |
//         5       Relation Type         |
//         6       extender type         |
//   8        array of all indexes       |
//         0       index expression      |
//         1       unique                |
//         2       extender type         |
//   9        external table             |
var allTables = new Array();

// This array holds all table data       |
// index      field info                 |
//   0        table logical name         |
//   1        table physical name        |
//   2        extender type              |
//   3        check                      |
//   4        company                    |
//   5        table date                 |
//   6        array of extender fields   |
//      0        field name              |
//      1        field type              |
//      2        field len               |
//      3        field dec               |
//      4        field comment           |
//      5        field check             |
//      6        field default           |
//      7        field not null          |
//      8        field key           |
//   7        array of extender relations|
//         0       Description           |
//         1       Linked Field          |
//         2       Linked Table          |
//         3       Linked Table Field    |
//         4       Join Type             |
//         5       Relation Type         |
//   8        array of extender indexes  |
//      0        expression              |
//      1        unique                  |
//   9        external table             |
//   10       server esterno             |
var extendedItems;
//var extendedTables=",";

var m_bUpdated;             //Lo stato della query: modificato o meno
var m_cAction="";
var associateServer=false;
var tempFilename = "";      //Il nome del file selezionato
var CSV_SEP = "#!$";
var selectedItem;
var m_cProgName="spadministration_table_extender";

function DoLoad(){
  GetTables(); //Richiede la lista delle tabelle al server e li salva nell'array "allTables"
  OpenExtenderXDC(); //Carica i dati dell'estensione

  for (var i=0; i<allTables.length; i++){
    DrawDictTablesRow(allTables[i][2], allTables[i][1], allTables[i][5]);
  }
  SelectDictionaryTable(QueryString('table'))
  m_bUpdated = false;
}

function OpenExtenderXDC(){
  var addedXDC = new JSURL("../servlet/SPXDCProxy?action=extender_data", true);
  addedXDC = addedXDC.Response();
  LoadExtenderTables(addedXDC);
}

function SaveExtenderXDC(admin) {
  if(admin){
    m_cAction="save_admin";
    associateServer=true;
  }
  else m_cAction="save";

  if(m_bUpdated || admin){
    SavingAlert(true);
    document.getElementById("FormSender").src="save_xdc.htm";
  }
}

function NotifySave(result) {
  switch(result) {
    case 'ok':
    case 'admin_ok':
      m_bUpdated=false;
      SavingAlert(false);
      break;
    case 'error':
      SavingAlert(false);
      alert("Error: unable to save file.");
      break;
    case 'admin_error':
      SavingAlert(false);
      alert("Error: unable to apply changes to database.");
      break;
    case 'admin_not_installed':
    case 'admin_generic_error':
      SavingAlert(false);
      alert("Error: please check log for more information.");
      break;
  }
}

function SavingAlert(show){
  document.getElementById("saving").style.display=(show?"block":"none");
  var leftPosition=(document.body.offsetWidth)?(document.body.offsetWidth-document.getElementById("saving").offsetWidth)/2:10;
  var topPosition=50;//(document.body.offsetHeight)?(document.body.offsetHeight-document.getElementById("saving").offsetHeight)/2:10;
  document.getElementById("saving").style.left=leftPosition;
  document.getElementById("saving").style.top=topPosition;
}

function GetTables(){
  var tables_prop = new JSURL("../servlet/SPXDCProxy?action=tables_prop", true);
  tables_prop = tables_prop.Response();

  //Se mancano le librerie sul server
  if (At("ACCESS DENIED", tables_prop)>0){
    alert("Access Denied.");
  }
  else if (At("ClassNotFoundException: SPXDCProxy", tables_prop)>0){
    alert("Installation incomplete: PortalStudio required to use SitePainter Extender.");
  } else {
    var l_oXdc = new TrsJavascript();
    l_oXdc.reset();
    l_oXdc.SetRow(0);
    l_oXdc.BuildProperties(tables_prop);
    var numTables = GetProperty(l_oXdc,'Rows','N');

    for(var i=0;i<numTables;i++){
      l_oXdc.SetRow(i);
      allTables[i] = new Array(GetProperty(l_oXdc,'lName','C'),
                               GetProperty(l_oXdc,'pName','C'),
                               GetProperty(l_oXdc,'comment','C'),
                               GetProperty(l_oXdc,'check','C'),
                               GetProperty(l_oXdc,'company','L'),
                               GetProperty(l_oXdc,'extender','C'),
                               null,null,null,
                               GetProperty(l_oXdc,'external','L'));
    }
    allTables.sort(TablesSortFunc);
  }
}

function DrawDictTablesRow(tDesc, tName, extending_table){
  var mytable = document.getElementById("dictTables");
  var newRow = mytable.insertRow(mytable.rows.length);
  //Table Description
  newCell = newRow.insertCell(newRow.cells.length);
  newCell.innerHTML = tDesc;
  newCell.width = "60%";
  if(extending_table) {
    newCell.className='extended';
  }
  //Table PName
  newCell = newRow.insertCell(newRow.cells.length);
  if (!tName) tName="";
  newCell.innerHTML = tName;
  newCell.style.borderLeft = "1 solid black";
  if(extending_table) {
    newCell.className='extended';
  }
}

function TablesSortFunc(a, b){
  var aa = a[1].toLowerCase();
  var bb = b[1].toLowerCase();
  if (aa > bb) return 1;
  if (aa < bb) return -1;
  return 0;
}

function SelectDictionaryTable(table){
  for (var i=0;i<allTables.length;i++){
    if(allTables[i][1]==table){
      o_dictTables.setItemSelected(o_dictTables.getItem(i), true);
    }
  }
}

function UpdateFields(){
  if (parseInt(o_dictTables.getSelectedIndexes())>-1){
    document.getElementById("lbl_fields").innerHTML = "Fields of " + "<span>" + allTables[parseInt(o_dictTables.getSelectedIndexes())][2] + "</span>";
    document.getElementById("lbl_indexes").innerHTML = "Indexes of " + "<span>" + allTables[parseInt(o_dictTables.getSelectedIndexes())][2] + "</span>";
    document.getElementById("lbl_relations").innerHTML = "Relations of " + "<span>" + allTables[parseInt(o_dictTables.getSelectedIndexes())][2] + "</span>";
    GetFieldsIndexesRelations(parseInt(o_dictTables.getSelectedIndexes()));
  }
}

function GetFieldsIndexesRelations(ofTable){
  FetchData(ofTable);
  var mytable = document.getElementById("dictFields");
  var numRows = mytable.rows.length;
  for(var i=0; i<numRows; i++){
    mytable.deleteRow(0);
  }

  for (var i=0; i<allTables[ofTable][6].length; i++){
    UpDownMove="";
    newRow = mytable.insertRow(mytable.rows.length);

    //Field Description
    newCell = newRow.insertCell(newRow.cells.length);
    newCell.innerHTML = allTables[ofTable][6][i][1];
    newCell.width = "55%";
    if(allTables[ofTable][6][i][5]=="C") {
      newCell.className='extended';
    }
    else if(allTables[ofTable][6][i][5]=="M") {
      newCell.style.color = "blue";
      newCell.style.fontWeight = "bold";
    }

    //Field Name
    newCell = newRow.insertCell(newRow.cells.length);
    newCell.innerHTML = allTables[ofTable][6][i][0];
    newCell.style.borderLeft = "1 solid black";
    if(allTables[ofTable][6][i][5]=="C") {
      newCell.className='extended';
    }
    if(allTables[ofTable][6][i][5]=="M") {
      newCell.style.color = "blue";
      newCell.style.fontWeight = "bold";
    }
  }

  mytable = document.getElementById("dictIndexes");
  numRows = mytable.rows.length;
  for (var i=0; i<numRows; i++){
    mytable.deleteRow(0);
  }

  for (var i=0; i<allTables[ofTable][8].length; i++){
    newRow = mytable.insertRow(mytable.rows.length);
    newCell = newRow.insertCell(newRow.cells.length);
    newCell.width = "75%";
    newCell.innerHTML = allTables[ofTable][8][i][0];
    if(allTables[ofTable][8][i][2]=="C") {
      newCell.className='extended';
    }
    if(allTables[ofTable][8][i][2]=="M") {
      newCell.style.color = "blue";
      newCell.style.fontWeight = "bold";
    }

    newCell = newRow.insertCell(newRow.cells.length);
    newCell.innerHTML = allTables[ofTable][8][i][1] ? "UNIQUE" : "";
    if(allTables[ofTable][8][i][2]=="C") {
      newCell.className='extended';
    }
    if(allTables[ofTable][8][i][2]=="M") {
      newCell.style.color = "blue";
      newCell.style.fontWeight = "bold";
    }
  }

  mytable = document.getElementById("dictRelations");
  numRows = mytable.rows.length;
  for (var i=0; i<numRows; i++){
    mytable.deleteRow(0);
  }

  for (var i=0; i<allTables[ofTable][7].length; i++){
    newRow = mytable.insertRow(mytable.rows.length);

    newCell = newRow.insertCell(newRow.cells.length);
    newCell.innerHTML = allTables[ofTable][7][i][0];
    if(allTables[ofTable][7][i][6]=="C") {
      newCell.className='extended';
    }
    if(allTables[ofTable][7][i][6]=="M") {
      newCell.style.color = "blue";
      newCell.style.fontWeight = "bold";
    }
  }
}

/* Carica le propriet� della tabella dal server se � la prima volta che viene selezionata */
function FetchData(ofTable){
  var response;

  if (ofTable>-1 && allTables[ofTable][6]==null){
    var oField;

    //Fields
    response = new JSURL("../servlet/SPXDCProxy?action=fields&table=" + allTables[ofTable][0], true);
    response = response.Response();

    oFields = response.split(CSV_SEP);
    allTables[ofTable][6] = new Array();

    if (oFields[0]=="* --- Visual Query Fields 1.0 ---*") {
      for (var i=1; i<oFields.length; i++){
        if(!Empty(oFields[i])){
          oField = oFields[i].split("|");
          allTables[ofTable][6][i-1] = new Array(oField[0],oField[2],oField[1],oField[3],oField[4],oField[5]);
        }
      }
    }
    else {
      allTables[ofTable][6][0] = new Array("Server Error","Server Error","","","","");
    }

    //Indexes
    response = new JSURL("../servlet/SPXDCProxy?action=indexes&table=" + allTables[ofTable][0], true);
    response = response.Response();

    oIndexes = response.split(CSV_SEP);
    allTables[ofTable][8] = new Array();
    allIndexes = allTables[ofTable][8];

    if (oIndexes[0]=="* --- Visual Query Indexes 1.0 ---*") {
      var unique;
      for (var i=1; i<oIndexes.length && Len(response)>0; i++){
        oIndex = oIndexes[i].split("|");
        unique = (Lower(Left(oIndex[0],6))=="unique" ? true : false);
        allIndexes[i-1] = new Array ((unique ? Substr(oIndex[0], 8) : oIndex[0]), unique, oIndex[1]);
      }
    }
    else {
      allIndexes[0] = new Array("Server Error","","");
    }

    //Relations
    response = new JSURL("../servlet/SPXDCProxy?action=relations&table=" + allTables[ofTable][0], true);
    response = response.Response();

    oRelations = response.split(CSV_SEP);
    allTables[ofTable][7] = new Array();
    allRelations = allTables[ofTable][7];

    if (oRelations[0]=="* --- Visual Query Relations 1.0 ---*") {
      for (var i=1; i<oRelations.length && Len(response)>0; i++){
        oRelation = oRelations[i].split("|");
        allRelations[i-1] = new Array (oRelation[0],oRelation[1],oRelation[2],oRelation[3],oRelation[4],oRelation[5],oRelation[6]);
      }
    }
    else {
      allRelations[0] = new Array("Server Error","","","","","","");
    }
  }
}

function MoveUpDownDictTables(){
  var keyCode = GetKeyCode((IsIE())?event:e);
  if (keyCode==38 || keyCode==40){
    var currentPos = parseInt(o_dictTables.getSelectedIndexes());
    moveOffset=0;
    if (keyCode==38){
      if (currentPos>0)
        moveOffset=-1; //UP
    }
    else if (keyCode==40){
      if (currentPos+1<document.getElementById("dictTables").rows.length)
        moveOffset=1; //Down
    }
    if (currentPos>-1 && moveOffset!=0)
      o_dictTables.setItemSelected(o_dictTables.getItem(currentPos+moveOffset), true);
  }
  else if (keyCode==35){ //End = 35
    o_dictTables.setItemSelected(o_dictTables.getItem(document.getElementById("dictTables").rows.length-1), true);
  }
  else if (keyCode==36){ //Home = 36
    o_dictTables.setItemSelected(o_dictTables.getItem(0), true);
  }
}

function MoveUpDownDictFields(){
  var keyCode = GetKeyCode((IsIE())?event:e);
  if (keyCode==38 || keyCode==40){
    var currentPos = parseInt(o_dictFields.getSelectedIndexes());
    moveOffset=0;
    if (keyCode==38){
      if (currentPos>0)
        moveOffset=-1; //UP
    }
    else if (keyCode==40){
      if (currentPos+1<document.getElementById("dictFields").rows.length)
        moveOffset=1; //Down
    }
    if (currentPos>-1 && moveOffset!=0)
      o_dictFields.setItemSelected(o_dictFields.getItem(currentPos+moveOffset), true);
  }
  else if (keyCode==35){ //End=35
    o_dictFields.setItemSelected(o_dictFields.getItem(document.getElementById("dictFields").rows.length-1), true);
  }
  else if (keyCode==36){ //Home=36
    o_dictFields.setItemSelected(o_dictFields.getItem(0), true);
  }
  else if (keyCode==13){
    EditField();
  }
}

function MoveUpDownDictIndexes(){
  var keyCode = GetKeyCode((IsIE())?event:e);
  if (keyCode==38 || keyCode==40){
    var currentPos = parseInt(o_dictIndexes.getSelectedIndexes());
    moveOffset=0;
    if (keyCode==38){
      if (currentPos>0)
        moveOffset=-1; //UP
    }
    else if (keyCode==40){
      if (currentPos+1<document.getElementById("dictIndexes").rows.length)
        moveOffset=1; //Down
    }
    if (currentPos>-1 && moveOffset!=0)
      o_dictIndexes.setItemSelected(o_dictIndexes.getItem(currentPos+moveOffset), true);
  }
  else if (keyCode==35){ //End=35
    o_dictIndexes.setItemSelected(o_dictIndexes.getItem(document.getElementById("dictIndexes").rows.length-1), true);
  }
  else if (keyCode==36){ //Home=36
    o_dictIndexes.setItemSelected(o_dictIndexes.getItem(0), true);
  }
  else if (keyCode==13){
    EditField();
  }
}

function MoveUpDownDictRelations(){
  var keyCode = GetKeyCode((IsIE())?event:e);
  if (keyCode==38 || keyCode==40){
    var currentPos = parseInt(o_dictRelations.getSelectedIndexes());
    moveOffset=0;
    if (keyCode==38){
      if (currentPos>0)
        moveOffset=-1; //UP
    }
    else if (keyCode==40){
      if (currentPos+1<document.getElementById("dictRelations").rows.length)
        moveOffset=1; //Down
    }
    if (currentPos>-1 && moveOffset!=0)
      o_dictRelations.setItemSelected(o_dictRelations.getItem(currentPos+moveOffset), true);
  }
  else if (keyCode==35){ //End=35
    o_dictRelations.setItemSelected(o_dictRelations.getItem(document.getElementById("dictRelations").rows.length-1), true);
  }
  else if (keyCode==36){ //Home=36
    o_dictRelations.setItemSelected(o_dictRelations.getItem(0), true);
  }
  else if (keyCode==13){
    EditField();
  }
}

function LoadExtenderTables(prop){
  var numTables, numFields, numIndexes, numRelations, idx;

  var l_oXdc = new TrsJavascript();
  l_oXdc.reset();
  l_oXdc.SetRow(0);
  var l_oFields = new TrsJavascript();
  l_oFields.reset();
  l_oFields.SetRow(0);
  var l_oIndexes = new TrsJavascript();
  l_oIndexes.reset();
  l_oIndexes.SetRow(0);
  var l_oRelations = new TrsJavascript();
  l_oRelations.reset();
  l_oRelations.SetRow(0);

  extendedItems = new Array();
  l_oXdc.BuildProperties(prop);
  numTables = GetProperty(l_oXdc,'Rows','N');

  for (var i=0; i<numTables; i++){
    l_oXdc.SetRow(i);
    extendedItems.push(new Array(GetProperty(l_oXdc,'lName','C'),
                                 GetProperty(l_oXdc,'pName','C'),
                                 GetProperty(l_oXdc,'extending_table','L'),
                                 GetProperty(l_oXdc,'check','C'),
                                 GetProperty(l_oXdc,'company','L'),
                                 GetProperty(l_oXdc,'modifyDate','C'),
                                 new Array(), new Array(), new Array(),
                                 GetProperty(l_oXdc,'external','L'),
                                 ""));

    //extendedTables+=GetProperty(l_oXdc,'lName','C')+",";

    l_oFields.BuildProperties(GetProperty(l_oXdc,'fields','C'));
    l_oFields.SetRow(0);
    numFields = GetProperty(l_oFields,'Rows','N');
    for (var j=0; j<numFields; j++){
      l_oFields.SetRow(j);
      extendedItems[i][6][j]=new Array(GetProperty(l_oFields,'name','C'),
                                       GetProperty(l_oFields,'type','C'),
                                       GetProperty(l_oFields,'len','C'),
                                       GetProperty(l_oFields,'dec','C'),
                                       GetProperty(l_oFields,'desc','C'),
                                       GetProperty(l_oFields,'check','C'),
                                       GetProperty(l_oFields,'defa','C'),
                                       GetProperty(l_oFields,'noNull','C'),
                                       GetProperty(l_oFields,'index','C'));
    }

    l_oIndexes.BuildProperties(GetProperty(l_oXdc,'indexes','C'));
    l_oIndexes.SetRow(0);
    numIndexes = GetProperty(l_oIndexes,'Rows','N');
    for (var j=0; j<numIndexes; j++){
      l_oIndexes.SetRow(j);
      extendedItems[i][8][j]=new Array(GetProperty(l_oIndexes,'expression','C'),
                                       GetProperty(l_oIndexes,'unique','L'));
    }

    l_oRelations.BuildProperties(GetProperty(l_oXdc,'relations','C'));
    l_oRelations.SetRow(0);
    numRelations = GetProperty(l_oRelations,'Rows','N');
    for (var j=0; j<numRelations; j++){
      l_oRelations.SetRow(j);

      extendedItems[i][7][j]=new Array(GetProperty(l_oRelations,'desc','C'),
                                       GetProperty(l_oRelations,'field','C'),
                                       GetProperty(l_oRelations,'table','C'),
                                       GetProperty(l_oRelations,'fKey','C'),
                                       GetProperty(l_oRelations,'type','C'));
    }
  }
  //alert(extendedItems)
}

function GetExtenderTablesAsProperties(){
  var l_oFields = new TrsJavascript();
  var l_oIndexes = new TrsJavascript();
  var l_oRelations = new TrsJavascript();
  var l_oXdc = new TrsJavascript();
  l_oXdc.reset();
  l_oXdc.SetRow(0);
  for (var i=0; i<extendedItems.length; i++){
    l_oXdc.setValue('lName', WtA(extendedItems[i][0],'C'));
    l_oXdc.setValue('modifyDate', WtA(extendedItems[i][5],'C'));
    if(extendedItems[i][2]==true){
      l_oXdc.setValue('pName', WtA(extendedItems[i][1],'C'));
      l_oXdc.setValue('check', WtA(extendedItems[i][3],'C'));
      l_oXdc.setValue('company', WtA(extendedItems[i][4],'L'));
      l_oXdc.setValue('external', WtA(extendedItems[i][9],'L'));
      l_oXdc.setValue('serverAssociated', WtA(extendedItems[i][10],'C'));
    }

    l_oFields.reset();
    l_oFields.SetRow(0);
    for (var j=0; j<extendedItems[i][6].length; j++){
      l_oFields.setValue('name', WtA(extendedItems[i][6][j][0],'C'));
      l_oFields.setValue('type', WtA(extendedItems[i][6][j][1],'C'));
      l_oFields.setValue('len', WtA(extendedItems[i][6][j][2],'N'));
      l_oFields.setValue('dec', WtA(extendedItems[i][6][j][3],'N'));
      l_oFields.setValue('desc', WtA(extendedItems[i][6][j][4],'C'));
      l_oFields.setValue('check', WtA(extendedItems[i][6][j][5],'C'));
      l_oFields.setValue('defa', WtA(extendedItems[i][6][j][6],'C'));
      l_oFields.setValue('noNull', WtA(CharToBool(extendedItems[i][6][j][7]),'L'));
      l_oFields.setValue('index', WtA(extendedItems[i][6][j][8],'N'));
      l_oFields.SetRow(j+1);
    }
    l_oXdc.setValue('fields', l_oFields.asString());

    l_oIndexes.reset();
    l_oIndexes.SetRow(0);
    for (var j=0; j<extendedItems[i][8].length; j++){
      l_oIndexes.setValue('expression', WtA(extendedItems[i][8][j][0],'C'));
      l_oIndexes.setValue('unique', WtA(extendedItems[i][8][j][1],'L'));
      l_oIndexes.SetRow(j+1);
    }
    l_oXdc.setValue('indexes', l_oIndexes.asString());

    l_oRelations.reset();
    l_oRelations.SetRow(0);
    for (var j=0; j<extendedItems[i][7].length; j++){
      l_oRelations.setValue('table', WtA(extendedItems[i][7][j][2],'C'));
      l_oRelations.setValue('type', WtA(extendedItems[i][7][j][4],'N'));
      l_oRelations.setValue('fKey', WtA(extendedItems[i][7][j][3],'C'));
      l_oRelations.setValue('field', WtA(extendedItems[i][7][j][1],'C'));
      l_oRelations.SetRow(j+1);
    }
    l_oXdc.setValue('relations', l_oRelations.asString());

    l_oXdc.SetRow(i+1);
  }
  return l_oXdc.asString();
}

function AddTable() {
  TableProperties("add");
}

function AddTableFrom(){
  AddFrom("table")
}

function AddFieldFrom(){
  var tblIdx = parseInt(o_dictTables.getSelectedIndexes()); //Indice della tabella selezionata
  if(tblIdx>-1) {
    var tableName = allTables[tblIdx][0];
    var eTblIdx=-1;
    var stop = false;
    for (var i=0; i<extendedItems.length && !stop; i++){
      if(extendedItems[i][0]==tableName) {
        eTblIdx = i;
        stop = true;
      }
    }
    AddFrom("field",eTblIdx, -1, tblIdx, -1);
  }
  else {
    alert("Select a table.");
  }

}

function AddFrom(action,etIdx,efIdx,tIdx,fIdx){
  var height = 290;
  var width = 430;

  windowLeft = (screen.width)?(screen.width-width)/2:100;
  windowTop = (screen.height)?(screen.height-height-(height/4))/2:100;
  var url = "table_from.htm?action="+action+(action=='field'?"&et="+etIdx+"&t="+tIdx:'');
  window.layerOpenForeground(url,"ExtenderAddFrom",'width=330,height=350',330,350,true,1);
  // window.open("table_from.htm?action="+action+(action=='field'?"&et="+etIdx+"&t="+tIdx:''),"table", "height="+height+",width="+width+",left="+windowLeft+",top="+windowTop);


}

function AddField() {
  var tblIdx = parseInt(o_dictTables.getSelectedIndexes()); //Indice della tabella selezionata
  if(tblIdx>-1) {
    var tableName = allTables[tblIdx][0];
    var eTblIdx=-1, eFldIdx=-1;
    var stop = false;

    for (var i=0; i<extendedItems.length && !stop; i++){
      if(extendedItems[i][0]==tableName) {
        eTblIdx = i;
        stop = true;
      }
    }
    FieldProperties("add", eTblIdx, -1, tblIdx, -1);
  }
  else {
    alert("Select a table.");
  }
}

function AddIndex() {
  var tblIdx = parseInt(o_dictTables.getSelectedIndexes()); //Indice della tabella selezionata
  if(tblIdx>-1) {
    var tableName = allTables[tblIdx][0];
    var eTblIdx=-1, eIdxIdx=-1;
    var stop = false;

    for (var i=0; i<extendedItems.length && !stop; i++){
      if(extendedItems[i][0]==tableName) {
        eTblIdx = i;
        stop = true;
      }
    }
    IndexProperties("add", eTblIdx, -1, tblIdx, -1);
  }
  else {
    alert("Select a table.");
  }
}

function AddRelation() {
  var tblIdx = parseInt(o_dictTables.getSelectedIndexes()); //Indice della tabella selezionata
  if(tblIdx>-1) {
    var tableName = allTables[tblIdx][0];
    var eTblIdx=-1, eIdxIdx=-1;
    var stop = false;

    for (var i=0; i<extendedItems.length && !stop; i++){
      if(extendedItems[i][0]==tableName) {
        eTblIdx = i;
        stop = true;
      }
    }
    RelationProperties("add", eTblIdx, -1, tblIdx, -1);
  }
  else {
    alert("Select a table.");
  }
}

function ItemAction(action) {
  var tblIdx = o_dictTables.getSelectedIndexes(); //Indice della tabella selezionata

  if(tblIdx!="" && selectedItem!=null) {
    tblIdx = parseInt(tblIdx);

    switch(selectedItem.id) {
      case "dictTables":
        var stop = false;
        var eTblIdx;

        if(allTables[tblIdx][5]=="C") {
          for (var i=0; i<extendedItems.length && !stop; i++){
            if(extendedItems[i][0]==allTables[tblIdx][0]) {
              eTblIdx=i;
              stop=true;
            }
          }
          if (action=="edit")
            TableProperties("edit", eTblIdx, tblIdx);
          else if (action=="delete") {
            if((window.WindowConfirm||window.confirm)("Are you sure you want to delete the selected extender table?")==1) {
              DeleteElement("table", eTblIdx, null, tblIdx, null);
            }
          }
        }
        else {
          alert("Select extender table.");
        }
        break;

      case "dictFields":
        var fldIdx = parseInt(o_dictFields.getSelectedIndexes()); //Indice del campo selezionato
        if(fldIdx>-1) {
          var tableName = allTables[tblIdx][0];
          var fieldName = allTables[tblIdx][6][fldIdx][0];
          var stop = false;
          var eTblIdx, eFldIdx;

          if(FieldIsExtender(tableName, fieldName)) {
            for (var i=0; i<extendedItems.length && !stop; i++){
              if(extendedItems[i][0]==tableName) {
                eTblIdx=i;
                for (var j=0; j<extendedItems[i][6].length && !stop; j++){
                  if(extendedItems[i][6][j][0]==fieldName) {
                    eFldIdx=j;
                    stop=true;
                  }
                }
              }
            }
            if (action=="edit")
              FieldProperties("edit", eTblIdx, eFldIdx, tblIdx, fldIdx);
            else if (action=="delete") {
              if((window.WindowConfirm||window.confirm)("Are you sure you want to delete the selected extender field?")==1) {
                DeleteElement("field", eTblIdx, eFldIdx, tblIdx, fldIdx);
              }
            }
          }
          else {
            alert("Select extender field.");
          }
        }
        else {
          alert("Select a field.");
        }
        break;

      case "dictIndexes":
        var indexIdx = parseInt(o_dictIndexes.getSelectedIndexes()); //Indice del indice selezionato
        if(indexIdx>-1) {
          var tableName = allTables[tblIdx][0];
          var indexExp = allTables[tblIdx][8][indexIdx][0];
          var stop = false;
          var eTblIdx, eIndexIdx;

          if(IndexIsExtender(tableName, indexExp)) {
            for (var i=0; i<extendedItems.length && !stop; i++){
              if(extendedItems[i][0]==tableName) {
                eTblIdx=i;
                for (var j=0; j<extendedItems[i][8].length && !stop; j++){
                  if(extendedItems[i][8][j][0]==indexExp) {
                    eIndexIdx=j;
                    stop=true;
                  }
                }
              }
            }
            if (action=="edit")
              IndexProperties("edit", eTblIdx, eIndexIdx, tblIdx, indexIdx);
            else if (action=="delete") {
              if((window.WindowConfirm||window.confirm)("Are you sure you want to delete the selected extender index?")==1) {
                DeleteElement("index", eTblIdx, eIndexIdx, tblIdx, indexIdx);
              }
            }
          }
          else {
            alert("Select extender index.");
          }
        }
        else {
          alert("Select an index.");
        }
        break;

      case "dictRelations":
        var relationIdx = parseInt(o_dictRelations.getSelectedIndexes()); //Indice della relazione selezionata
        if(relationIdx>-1) {
          var tableName = allTables[tblIdx][0];
          var relDesc = allTables[tblIdx][7][relationIdx][0];
          var stop = false;
          var eTblIdx, eRelationIdx;

          if(RelationIsExtender(tableName, relDesc)) {
            for (var i=0; i<extendedItems.length && !stop; i++){
              if(extendedItems[i][0]==tableName) {
                eTblIdx=i;
                for (var j=0; j<extendedItems[i][7].length && !stop; j++){
                  if(extendedItems[i][7][j][0]==relDesc) {
                    eRelationIdx=j;
                    stop=true;
                  }
                }
              }
            }
            if (action=="edit")
              RelationProperties("edit", eTblIdx, eRelationIdx, tblIdx, relationIdx);
            else if (action=="delete") {
              if((window.WindowConfirm||window.confirm)("Are you sure you want to delete the selected extender relation?")==1) {
                DeleteElement("relation", eTblIdx, eRelationIdx, tblIdx, relationIdx);
              }
            }
          }
          else {
            alert("Select extender relation.");
          }
        }
        else {
          alert("Select a relation.");
        }
        break;
    }
  }
  else if (tblIdx==""){
    alert("Select a table.");
  }
  else if (selectedItem==null){
    alert("Select an item.");
  }
}

function TableProperties(action, etIdx, tIdx) {
  var height = 150;
  var width = 430;

  windowLeft = (screen.width)?(screen.width-width)/2:100;
  windowTop = (screen.height)?(screen.height-height-(height/4))/2:100;

  if (IsNetscape() || IsMozilla()) {
    width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height+=4;
  }
  var url = "table_prop.htm?action="+action+"&et="+etIdx+"&t="+tIdx;
  window.layerOpenForeground(url,"ExtenderTableProperties",'width=300,height=350',300,350,true,1);
  // win = window.open("table_prop.htm?action="+action+"&et="+etIdx+"&t="+tIdx, "table", "height="+height+",width="+width+",left="+windowLeft+",top="+windowTop);
}

function FieldProperties(action, etIdx, efIdx, tIdx, fIdx) {
  var height = 242;
  var width = 480;

  windowLeft = (screen.width)?(screen.width-width)/2:100;
  windowTop = (screen.height)?(screen.height-height-(height/4))/2:100;

  if (IsNetscape() || IsMozilla()) {
    width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height+=4;
  }
  var url = "field_prop.htm?action="+action+"&et="+etIdx+"&ef="+efIdx+"&t="+tIdx+"&f="+fIdx;
  window.layerOpenForeground(url,"ExtenderFieldProperties",'width=300,height=300',300,300,true,1);
  // win = window.open("field_prop.htm?action="+action+"&et="+etIdx+"&ef="+efIdx+"&t="+tIdx+"&f="+fIdx, "field", "height="+height+",width="+width+",left="+windowLeft+",top="+windowTop);
}

function IndexProperties(action, etIdx, efIdx, tIdx, fIdx) {
  var height = 282;
  var width = 480;

  windowLeft = (screen.width)?(screen.width-width)/2:100;
  windowTop = (screen.height)?(screen.height-height-(height/4))/2:100;

  if (IsNetscape() || IsMozilla()) {
    width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height+=4;
  }
  var url = "index_prop.htm?action="+action+"&et="+etIdx+"&ef="+efIdx+"&t="+tIdx+"&f="+fIdx;
  window.layerOpenForeground(url,"ExtenderIndexProperties",'width=300,height=350',300,350,true,1);
  // win = window.open("index_prop.htm?action="+action+"&et="+etIdx+"&ef="+efIdx+"&t="+tIdx+"&f="+fIdx, "index", "height="+height+",width="+width+",left="+windowLeft+",top="+windowTop);
}

function RelationProperties(action, etIdx, erIdx, tIdx, rIdx) {
  var height = 282;
  var width = 480;

  windowLeft = (screen.width)?(screen.width-width)/2:100;
  windowTop = (screen.height)?(screen.height-height-(height/4))/2:100;

  if (IsNetscape() || IsMozilla()) {
    width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height+=4;
  }
  var url = "relation_prop.htm?action="+action+"&et="+etIdx+"&er="+erIdx+"&t="+tIdx+"&r="+rIdx;
  window.layerOpenForeground(url,"ExtenderRelationProperties",'width=300,height=350',300,350,true,1);
  // win = window.open("relation_prop.htm?action="+action+"&et="+etIdx+"&er="+erIdx+"&t="+tIdx+"&r="+rIdx, "relation", "height="+height+",width="+width+",left="+windowLeft+",top="+windowTop);
}

function UpdateTable(table, action, et, t) {
  if(action=="edit") {
    extendedItems[et][0]=table[0];
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    extendedItems[et][1]=table[1];
    extendedItems[et][3]=table[3];
    extendedItems[et][4]=table[2];
    extendedItems[et][9]=table[4];

    allTables[t][0]=table[0];
    allTables[t][1]=table[1];
    allTables[t][3]=table[3];
    allTables[t][4]=table[2];
    allTables[t][9]=table[4];
  }
  else if(action=="add"){
    et=AddEmptyExtentionTable();
    t=allTables.length;

    extendedItems[et][0]=table[0];
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    extendedItems[et][1]=table[1];
    extendedItems[et][3]=table[3];
    extendedItems[et][4]=table[2];
    extendedItems[et][9]=table[4];
    extendedItems[et][10]=table[5]||"";
    extendedItems[et][2]=true;

    allTables[t]=new Array(table[0],table[1],table[0],table[3],table[2],"C", null,null,null,table[4]);
    DrawDictTablesRow(table[0], table[1], true);
  }
  m_bUpdated=true;
}

function UpdateField(field, action, et, ef, t, f) {
  if (action=="edit") {
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server

    for(var i=0;i<extendedItems[et][6][ef].length;i++) {
      extendedItems[et][6][ef][i]=field[i];
    }
    allTables[t][6][f][0]=field[0]; //Aggiorno il nome del campo nella tabella allTables
    allTables[t][6][f][1]=field[4]; //Aggiorno il nome del campo nella tabella allTables
  }
  else if (action=="add"){
    if (et==-1) {
      et=AddEmptyExtentionTable();
    }

    ef=extendedItems[et][6].length;
    extendedItems[et][0]=allTables[t][0];
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    extendedItems[et][6][ef]=new Array();

    for(var i=0;i<field.length;i++) {
      extendedItems[et][6][ef][i]=field[i];
    }
    f=allTables[t][6].length;
    allTables[t][6][f]=new Array(field[0], field[4], field[1], field[2], field[3], "C");
  }

  UpdateFields();
  m_bUpdated=true;
}

function MergeFields(fields, et, ef, t, f){
  if (et==-1) {
    et=AddEmptyExtentionTable();
  }
  ef=extendedItems[et][6].length;
  extendedItems[et][0]=allTables[t][0];
  extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
  for (var i=0; i<ef; i++){
    var idx=-1;
    for (var j=0; j<fields.length && idx==-1; j++){
      if (Lower(extendedItems[et][6][i][0])==Lower(fields[j][0])){
        idx=j;
      }
    }
    if (idx!=-1){
      if (FieldIsExtender(extendedItems[et][0], extendedItems[et][6][i][0])){ // se il campo � esteso faccio il merge altrimenti non si pu� modificare e quindi tengo quello che c'� gi�
        for (var j=1; j<fields[idx].length; j++){
          if (!Empty(fields[idx][j])){
            extendedItems[et][6][i][j]=fields[idx][j]
          }
        }
        var fldIdx=-1
        for (var j=0; j<allTables[et][6].length && fldIdx==-1; j++){
          if (extendedItems[et][6][j][0]==fieldName)
            fldIdx=j;
        }
        allTables[t][6][fldx]=new Array(extendedItems[et][6][i][0], extendedItems[et][6][i][4], extendedItems[et][6][i][1], extendedItems[et][6][i][2], extendedItems[et][6][i][3], "C");
      }
      fields.splice(idx,1)
    }
  }
  for (var i=0; i<fields.length; i++){
    extendedItems[et][6][ef+i]=new Array();
    for(var j=0;j<fields[i].length;j++) {
      extendedItems[et][6][ef+i][j]=fields[i][j];
    }
    f=allTables[t][6].length;
    allTables[t][6][f]=new Array(fields[i][0], fields[i][4], fields[i][1], fields[i][2], fields[i][3], "C");
  }
  UpdateFields();
  m_bUpdated=true;
}

function ReplaceFields(fields, et, ef, t, f){
  if (et==-1) {
    et=AddEmptyExtentionTable();
  }
  if(allTables[t][5]=="C") { // tabella estesa
    extendedItems[et][6]=new Array()
    allTables[t][6]=new Array();
    extendedItems[et][0]=allTables[t][0];
    extendedItems[et][5]=DateTimeToChar(DateTime())

    for (var i=0; i<fields.length; i++){
      extendedItems[et][6][i]=new Array();
      for (var j=0; j<fields[i].length; j++){
        extendedItems[et][6][i][j]=fields[i][j];
      }
      allTables[t][6][i]=new Array(fields[i][0], fields[i][4], fields[i][1], fields[i][2], fields[i][3], "C");
    }
    UpdateFields();
    m_bUpdated=true;
  }
  else {
    var tableName=allTables[t][0];
    //elimino tutti i campi estesi
    var idx=0, eFldIdx=-1;
    while (idx<allTables[t][6].length){
      var fieldName=allTables[t][6][idx][0];
      if(FieldIsExtender(tableName, fieldName)) {
        for (var i=0; i<extendedItems[et][6].length && eFldIdx==-1; i++){
          if (extendedItems[et][6][i][0]==fieldName)
            eFldIdx=i;
        }
        allTables[t][6].splice(idx,1);
        if (eFldIdx>-1)
          extendedItems[et][6].splice(eFldIdx,1);
      }
      else idx++;
    }
    // posso fare il merge
    MergeFields(fields, et, ef, t, f)
  }


}

function UpdateIndex(action, exp, unique, et, eidx, t, idx) {
  if (action=="edit") {
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    allTables[t][8][idx][0]=extendedItems[et][8][eidx][0]=exp;
    allTables[t][8][idx][1]=extendedItems[et][8][eidx][1]=unique;
  }
  else if (action=="add"){
    if (et==-1) {
      et=AddEmptyExtentionTable();
    }

    idx=allTables[t][8].length;
    allTables[t][8][idx]=new Array();

    eidx=extendedItems[et][8].length;
    extendedItems[et][0]=allTables[t][0];
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    extendedItems[et][8][eidx]=new Array();

    allTables[t][8][idx][0]=extendedItems[et][8][eidx][0]=exp;
    allTables[t][8][idx][1]=extendedItems[et][8][eidx][1]=unique;
    allTables[t][8][idx][2]="C";
  }
  UpdateFields();
  m_bUpdated=true;
}

function UpdateRelation(action, linkedTable, linkedTableDesc, fieldString, fkFieldString, fieldDescString, et, er, t, r) {
  if (action=="edit") {
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    allTables[t][7][r][0]=extendedItems[et][7][er][0]=linkedTableDesc+"("+fieldDescString+")";
    allTables[t][7][r][1]=extendedItems[et][7][er][1]=fieldString;
    allTables[t][7][r][2]=extendedItems[et][7][er][2]=linkedTable;
    allTables[t][7][r][3]=extendedItems[et][7][er][3]=fkFieldString;
    allTables[t][7][r][4]=extendedItems[et][7][er][4]=1;
  }
  else if (action=="add"){
    if (et==-1) {
      et=AddEmptyExtentionTable();
    }

    r=allTables[t][7].length;
    allTables[t][7][r]=new Array();

    er=extendedItems[et][7].length;
    extendedItems[et][0]=allTables[t][0];
    extendedItems[et][5]=DateTimeToChar(DateTime()); //Bisogna mettere qui la data del server
    extendedItems[et][7][er]=new Array();

    allTables[t][7][r][0]=extendedItems[et][7][er][0]=linkedTableDesc+"("+fieldDescString+")";
    allTables[t][7][r][1]=extendedItems[et][7][er][1]=fieldString;
    allTables[t][7][r][2]=extendedItems[et][7][er][2]=linkedTable;
    allTables[t][7][r][3]=extendedItems[et][7][er][3]=fkFieldString;
    allTables[t][7][r][4]=extendedItems[et][7][er][4]=1;
    allTables[t][7][r][6]="C";
  }
  UpdateFields();
  m_bUpdated=true;
}

function AddEmptyExtentionTable(){
  var et=extendedItems.length;
  extendedItems[et]=new Array();
  extendedItems[et][6]=new Array();
  extendedItems[et][7]=new Array();
  extendedItems[et][8]=new Array();
  return et;
}

function DeleteElement(type, et, eElm, t, elm) {
  switch(type) {
    case "table":
      allTables.splice(t,1);
      extendedItems.splice(et,1);
      break;
    case "field":
      allTables[t][6].splice(elm,1);
      extendedItems[et][6].splice(eElm,1);
      break;
    case "index":
      allTables[t][8].splice(elm,1);
      extendedItems[et][8].splice(eElm,1);
      break;
    case "relation":
      allTables[t][7].splice(elm,1);
      extendedItems[et][7].splice(eElm,1);
      break;
  }
  if(eElm==null){
    document.getElementById("dictTables").deleteRow(t);
    if(t>0) o_dictTables.setItemSelected(o_dictTables.getItem(t-1), true);
  }
  else {
    if(extendedItems[et][6].length==0 && extendedItems[et][8].length==0 && extendedItems[et][7].length==0) {
      extendedItems.splice(et, 1);
    }
  }
  UpdateFields();
  m_bUpdated=true;
}

function FieldIsExtender(t,f) {
  var result=false;
  for (var i=0; i<extendedItems.length && !result; i++){
    if(extendedItems[i][0]==t) {
      for (var j=0; j<extendedItems[i][6].length && !result; j++){
        if(extendedItems[i][6][j][0]==f) {
          result=true;
        }
      }
    }
  }
  return result;
}
function IndexIsExtender(t,i) {
  var result=false;
  for (var k=0; k<extendedItems.length && !result; k++){
    if(extendedItems[k][0]==t) {
      for (var j=0; j<extendedItems[k][8].length && !result; j++){
        if(extendedItems[k][8][j][0]==i) {
          result=true;
        }
      }
    }
  }
  return result;
}
function RelationIsExtender(t,r) {
  var result=false;
  for (var i=0; i<extendedItems.length && !result; i++){
    if(extendedItems[i][0]==t) {
      for (var j=0; j<extendedItems[i][7].length && !result; j++){
        if(extendedItems[i][7][j][0]==r) {
          result=true;
        }
      }
    }
  }
  return result;
}

function UnSelectOthers(obj) {
  selectedItem = obj;

  switch(obj.id) {
    case "dictFields":
      if(o_dictIndexes.getSelectedIndexes()!="")
        o_dictIndexes.setItemSelected(o_dictIndexes.getItem(o_dictIndexes.getSelectedIndexes()), false);
      if(o_dictRelations.getSelectedIndexes()!="")
        o_dictRelations.setItemSelected(o_dictRelations.getItem(o_dictRelations.getSelectedIndexes()), false);
      break;
    case "dictIndexes":
      if(o_dictFields.getSelectedIndexes()!="")
        o_dictFields.setItemSelected(o_dictFields.getItem(o_dictFields.getSelectedIndexes()), false);
      if(o_dictRelations.getSelectedIndexes()!="")
        o_dictRelations.setItemSelected(o_dictRelations.getItem(o_dictRelations.getSelectedIndexes()), false);
      break;
    case "dictRelations":
      if(o_dictFields.getSelectedIndexes()!="")
        o_dictFields.setItemSelected(o_dictFields.getItem(o_dictFields.getSelectedIndexes()), false);
      if(o_dictIndexes.getSelectedIndexes()!="")
        o_dictIndexes.setItemSelected(o_dictIndexes.getItem(o_dictIndexes.getSelectedIndexes()), false);
      break;
  }
}

function selectTable(index){
  var td=document.getElementById("dictTables").getElementsByTagName('tr')[index].getElementsByTagName('td')[0];
  o_dictTables.click({target:td})
}
