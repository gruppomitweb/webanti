/* exported
    SelectThisParameter FillList addRemoveRow selectRow
  */
var CSV_SEP = '#!$';
var fieldSelected, multiple, tableName, configName, offline,
  allParameters = new Array(),
  visibleParameters = new Array(),
  tabSelected = 'name';
var oldFilter = '';
var fieldsList = new Array();

function getOpener() {
  return window.opener ? window.opener : window.parent;
}

function SelectThisParameter() {
  var value = document.getElementById('result').value;
  if (getOpener().loadFieldName) {
    getOpener().loadFieldName(value, document.getElementById('action').value);
  }
  closeWindow();
}

function closeWindow() {
  if (getOpener().closeSPModalLayer && !Empty(document.getElementById('SPModalLayerId').value)) {
    getOpener().closeSPModalLayer();
  } else {
    window.close();
  }
}

function Filter() {
  var _filter = Lower(document.getElementById('search').value);
  if (_filter.length > 2 || _filter.length == 0 && _filter != oldFilter) {
    var innerHtml = '';
    var idx = 0;
    visibleParameters = [];
    var j = tabSelected == 'name' ? 0 : 1;
    for (var i = 0; i < allParameters.length; i++) {
      if (Lower(allParameters[i][j]).indexOf(_filter) != -1) {
        visibleParameters.push(allParameters[i]);
        innerHtml += "<li";
        if (multiple) {
          // modalità con selezione multipla dei filds
          innerHtml += "><i id='icon" + idx + "' onclick='addRemoveRow(event, " + idx + ")'  class='zicon add-zicon'></i>";
        } else {
          innerHtml += " ondblclick='SelectThisParameter()' onclick='selectRow(" + idx + ")'>";
        }
        innerHtml += "<p id='name" + idx + "' class='field'>" + allParameters[i][0] + '</p>';
        innerHtml += "<p id='description" + idx + "' class='description'>" + (allParameters[i][1] || allParameters[i][0]) + '</p></li>';
        idx++;
      }
    }
    document.getElementById('tableContent').innerHTML = innerHtml;
    oldFilter = _filter;
  }
}

function FillList() {
  var posPoint;
  tableName=document.getElementById('tableName');
  configName=document.getElementById('configName');
  offline=document.getElementById('offline');
  tableName = tableName ? tableName.value : '';
  configName = configName ? configName.value : '';
  offline = offline ? offline.value : '';

  if (tableName){
    posPoint=tableName.indexOf('.');
    if (posPoint!=-1)
      tableName=Left(tableName,posPoint)
  }
  GetParameters()

  multiple = document.getElementById('multiple').value;
  fieldSelected = document.getElementById('fieldSelected').value;
  var tableContent = document.getElementById('content');
  var innerHtml = " <ul id='tableContent' class='customTable'>";
  for (var i = 0; i < allParameters.length; i++) {
    innerHtml += "<li";
    if (multiple) {
      // modalità con selezione multipla dei filds
      innerHtml += "><i id='icon" + i + "' onclick='addRemoveRow(event, " + i + ")'  class='zicon add-zicon'></i>";
    } else {
      innerHtml += " ondblclick='SelectThisParameter()' onclick='selectRow(" + i + ")'>";
    }
    innerHtml += "<p id='name" + i + "' class='field'>" + allParameters[i][0] + '</p>';
    innerHtml += "<p id='description" + i + "' class='description'>" + (allParameters[i][1] || allParameters[i][0]) + '</p></li>';
  }
  innerHtml += '</ul>';
  tableContent.innerHTML = innerHtml;
  var index = -1;
  for (i = 0; i < allParameters.length && index == -1; i++) {
    if (fieldSelected == allParameters[i][0]) {
      index = i;
    }
  }
  visibleParameters = allParameters;

  document.getElementById('search').addEventListener('keyup', function () {
    Filter();
  });

  resize();
}


function GetParameters(){
  var i;
  if(configName) {
    var jsonfields = new JSURL("../servlet/SPVZMProxy?action=load&table="+URLenc(tableName)+"&configname="+URLenc(configName)+"&offlinemode="+URLenc(offline), true);
    try {
      jsonfields = JSON.parse(jsonfields.Response());
      for(i=0;i<jsonfields.cols.length;i++){
        var col = jsonfields.cols[i];
        allParameters[i] = new Array(col.field, col.title);
      }
    } catch (e) {
      console.error('Errore in caricamento del def della configurazione: ' + configName);
      return;
    }
  } else {
    var fieldsCSV = new JSURL("../servlet/SPXDCProxy?action=fields&table=" + tableName+'&format=properties', true);
    fieldsCSV = fieldsCSV.Response();
     if (At(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP)==0){
        var oFields = new TrsJavascript();
        oFields.reset();
        oFields.SetRow(0);
        oFields.BuildProperties(Strtran(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP,''));
        var rows=GetProperty(oFields,'Rows','N');
        for(i=0;i<rows;i++){
          oFields.SetRow(i);
          allParameters[i] = new Array(GetProperty(oFields,'alias','C'),GetProperty(oFields,'desc','C'),GetProperty(oFields,'type','C'),GetProperty(oFields,'len','N'),GetProperty(oFields,'dec','N'));
        }
      }
    else {
      allParameters[0] = new Array ("Server Error", "Server Error", "", "", "");
    }
  }
}

function addRemoveRow(event, i) {
  event.stopPropagation(); // se clicco sull'icona addRow impedisco l'esecuzione di altri eventi
  var icon = document.getElementById('icon' + i);
  var isAddAction = icon.classList.contains('add-zicon');
  var field = document.getElementById('name' + i).innerText;
  if (isAddAction) {
    fieldsList.push(field);
    icon.classList.add('remove-zicon');
    icon.classList.remove('add-zicon');
  } else {
    var index = fieldsList.indexOf(field);
    if (index > -1) {
      fieldsList.splice(index, 1);
    }
    icon.classList.add('add-zicon');
    icon.classList.remove('remove-zicon');
  }
  document.getElementById('result').value = fieldsList.join();
}

function selectRow(i) {
  if (i < visibleParameters.length && i >= 0) {
    document.getElementById('result').value = visibleParameters[i][0];
  }
}

function resize() {
  document.getElementById('content').style.height = GetWindowSize().h - document.getElementById('title').offsetHeight - document.getElementById('footer').offsetHeight + 'px';
}
