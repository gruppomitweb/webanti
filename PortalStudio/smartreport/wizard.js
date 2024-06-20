/* exported fldcheck ptTomm typeF defaultFont showInputBtn inputComplete setFields
    selectAllFields drawBreadcrumb convertMarginsToPerc generateReport divLen ToStringHTML
    setBoName selectzoom getFieldIdx m_function SendData
*/
var reportflds = [];
var breakFields=[];
var headerFields=[];
var footerFields=[];
var reportmodel = "";
var datasource = "";
var fields = null;
var titler = "";
var fldcheck = [];
var ptTomm = 0.35;
m_bUpdated = false;
var mWizardBody = "";
var _myPortlet = null;

var page = {format: "A4", orientation: "portrait"};
var margins = { top: (parseFloat(docSettingsMM[page.format].h)*0.04).toFixed(2),
                bottom: (parseFloat(docSettingsMM[page.format].h)*0.04).toFixed(2),
                left: (parseFloat(docSettingsMM[page.format].w)*0.04).toFixed(2),
                right: 0,
                unit: "mm",
                type: "automatic"
              };
var model = ["list","table"];
var orient = orientation_select.split(",");
var format = format_select.split(",");
var mar = ["top","bottom","left"];  //,"right"];
var typeF = [  {text:"field", css:"fld", type:"field"},
               {text:"column layer field", css:"cl", type:"collayer"},
               {text:"row layer field", css:"rl", type:"rowlayer"},
               {text:"extendible field", css:"ext", type:"extfield"},
               {text:"hidden field", css:"hid", type:"hiddenfield"}
            ];
var pTitles = ["Datasource","Title and model","Report fields","Grouping fields","Header fields","Footer fields","Page settings"];
var currentpage = 0;
var opt = ["automatic","none","minimum","custom"];
var typeSource = [  {text:"Visual Query", type:"vqr"},
                    {text:"Business Object", type:"bo"}
                 ];

var defaultFont = {name:"Open Sans Light,lucida grande,tahoma,verdana,arial,sans-serif",size:14,weight:"normal"};
var roffline = false;
function getOpener(){
  return GetOpener();
}

function CloseWindow(iscancel){
  if(iscancel)
    datasource = "";
  if (window.closeFrame)
    closeFrame();
  else if (!Empty(window.SPModalLayerId))
    getOpener().closeSPModalLayer();
  else
    window.close();
  if(getOpener() && getOpener().closeERWizard)
    getOpener().closeERWizard(datasource,m_bUpdated);
}

function SetUpdated(){
  m_bUpdated = true;
}

function drawPage(n){
  switch(n){
    case "0":
      drawDatasourcePage();
      break;
    case "1":
      page1(_myPortlet);
      break;
    case "2":
      pageGen(parseInt(n),"report");
      break;
    case "3":
      pageGen(parseInt(n),"break");
      break;
    case "4":
      pageGen(parseInt(n),"header");
      break;
    case "5":
      pageGen(parseInt(n),"footer");
      break;
    case "6":
      pageSettings();
      break;
  }
  verifyArray(breakFields);
  verifyArray(headerFields);
  verifyArray(footerFields);
}

var allFields = [];
function setAllFields(ds){
  if(!Empty(ds)){
    datasource = ds;
    if(fields) {
      allFields = fields;
      for (var i=0; i<allFields.length; i++){
       if(!allFields[i].collayer && !allFields[i].rowlayer && !allFields[i].extfield && !allFields[i].hiddenfield)
          reportflds.push(i)
      }
    }
    else
      allFields = getDatasourceFields(ds,roffline);
  }
}

function filterFields(idxArray){
  var ret = [];
  for(var i=0; i<idxArray.length; i++){
    ret.push(allFields[idxArray[i]]);
  }
  return ret;
}

function verifyArray(array){
  for(var i=0; i<array.length; i++){
    if(reportflds.indexOf(array[i])<0)
      array.splice(i,1);
  }
}

function resetContent(currentpage){
  mWizardBody.innerHTML = "";
 // $("moref").addClass("hide");
  applyCurrent(currentpage);
}

function page1(portletObj){
  //$("drawreport").addClass("hide");
  _myPortlet = portletObj;
  if(Empty(datasource))
    drawDatasourcePage();
  else
    drawTitlesPage();
}

function drawDatasourcePage(){
  currentpage = 0;
  validatePage();
  resetContent(currentpage);

  var pdiv,elem;

  pdiv = document.createElement("div");
  pdiv.id = "dscont";
  pdiv.className = "unselectable";
  pdiv.style.marginLeft = "15px";
  elem = document.createElement("div");
  elem.className = "unselectable description";
  elem.textContent = getTranslated("SMR_SELECTDATASOURCE", "Select data from available sources");
  pdiv.appendChild(elem);
  mWizardBody.appendChild(pdiv);

  for(var i=0; i<typeSource.length; i++){
    pdiv = document.createElement("div");
    pdiv.className = "unselectable sourcecont";
    elem = document.createElement("span");
    elem.id = "source_"+typeSource[i].type;
    elem.className = "sourcepic";
    pdiv.appendChild(elem);
    elem.onclick = setClicked;
    elem = document.createElement("span");
    elem.id = "source_"+typeSource[i].type+"_label";
    elem.className = "unselectable sourcetxt";
    elem.textContent = typeSource[i].text;
    pdiv.appendChild(elem);
    elem.onclick = setClicked;
    mWizardBody.appendChild(pdiv);
  }

  pdiv = document.createElement("div");
  pdiv.className = "unselectable";
  pdiv.style.marginTop = "210px";
  pdiv.style.marginLeft = "15px";
  elem = document.createElement("div");
  elem.className = "unselectable description";
  elem.textContent = getTranslated("SMR_DATASOURCENAME", "or specify datasource name");
  pdiv.appendChild(elem);
  elem = document.createElement("input");
  elem.id = "sourcename";
  elem.className = "unselectable inputtxt textbox";
  elem.type = "text";
  if(!Empty(datasource))
    elem.value = datasource;
  elem.style.fontWeight = "600";
  elem.style.marginLeft = "3px";
  elem.style.cursor = "default";
  elem.textContent = "";
  pdiv.appendChild(elem);
  elem.onchange = setDataSName;
  mWizardBody.appendChild(pdiv);
}

function drawTitlesPage(){
  currentpage = 1;
  validatePage();
  resetContent(currentpage);

  var cdiv,pdiv,elem;
  cdiv = mWizardBody;

  // titolo
  pdiv = document.createElement("div");
  pdiv.id = "titlecont";
  pdiv.className = "unselectable";
  pdiv.style.marginLeft = "15px";
  elem = document.createElement("div");
  elem.className = "unselectable description";
  elem.textContent = getTranslated("SMR_REPORTTITLE", "Specify report title");
  pdiv.appendChild(elem);
  elem = document.createElement("input");
  elem.id = "reporttitle";
  elem.className = "inputtxt textbox";
  elem.style.marginLeft = "3px";
  elem.type = "text";
  if(!Empty(titler))
    elem.value = titler;
  pdiv.appendChild(elem);
  elem.onchange = setTitle;
  cdiv.appendChild(pdiv);

  // model
  pdiv = document.createElement("div");
  pdiv.id = "modelcont";
  pdiv.className = "unselectable";
  pdiv.style.marginTop = "80px";
  pdiv.style.marginLeft = "15px";
  elem = document.createElement("div");
  elem.className = "unselectable description";
  elem.textContent = getTranslated("SMR_REPORTLAYOUT", "Select report layout model");
  pdiv.appendChild(elem);
  elem = document.createElement("span");
  elem.id = "model_list";
  elem.className = "reportpics";
  elem.style.marginTop = "20px";
  elem.style.marginLeft = "15px";
  elem.style.backgroundImage = "url(../reporteditor/images/reportList.png)";
  pdiv.appendChild(elem);
  elem.onclick = setClicked;
  elem = document.createElement("span");
  elem.id = "model_list_label";
  elem.className = "unselectable reportmodeltxt";
  elem.textContent = getTranslated("SMR_REPORTMODELLIST", "List");
  elem.style.paddingLeft = "12px";
  pdiv.appendChild(elem);
  elem.onclick = setClicked;
  elem = document.createElement("span");
  elem.id = "model_table";
  elem.className = "reportpics";
  elem.style.marginTop = "20px";
  elem.style.marginLeft = "100px";
  elem.style.backgroundImage = "url(../reporteditor/images/reportTable.png)";
  pdiv.appendChild(elem);
  elem.onclick = setClicked;
  elem = document.createElement("span");
  elem.id = "model_table_label";
  elem.className = "unselectable reportmodeltxt";
  elem.textContent = getTranslated("SMR_REPORTMODELTABLE", "Tabular");
  elem.style.paddingLeft = "4px";
  pdiv.appendChild(elem);
  elem.onclick = setClicked;
  cdiv.appendChild(pdiv);
  if(!Empty(reportmodel))
    $("model_"+reportmodel).addClass("clicked");
  else {
    $("model_table").addClass("clicked");
    reportmodel = "table";
  }
}

function showInputBtn(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);

  $(ctrl.id+"_btnok").removeClass("hide");
}

function inputComplete(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);

  setTitle();
  $(ctrl.id).addClass("hide");
}

function pageGen(n,zone){
  currentpage = n;
  validatePage();
  resetContent(currentpage);

  // carico i fields
  if(Empty(allFields))
    setAllFields(datasource);

  var cdiv = mWizardBody;
  var mtop = 0;
  var mleft = ((cdiv.offsetWidth/2)-118);

  var pdiv = document.createElement("div");
  pdiv.id = "fieldstitle";
  pdiv.className = "unselectable";
  pdiv.style.marginLeft = "15px";
  var elem = document.createElement("div");
  elem.className = "unselectable description";
  if(n==3)
    elem.textContent = getTranslated("SMR_BREAKGROUPFIELDS", "Select breaking fields to be applied to group");
  else if(n==4)
    elem.textContent = getTranslated("SMR_HEADERGROUPFIELDS", "Select the fields you want to be included in the group header section");
  else if(n==5)
    elem.textContent = getTranslated("SMR_FOOTERGROUPFIELDS", "Select the fields you want to be included in the group footer section");
  else // all - 2
    elem.textContent = getTranslated("SMR_SELECTREPORTFIELDS", "Select the fields you want to be used in report sections");
  pdiv.appendChild(elem);
  cdiv.appendChild(pdiv);

  // selectall
  if (zone != "break") {
    var switchObj = {name: "select all",
             propID: "all_checkbox_"+zone,
             tooltip: "",
             actions: "selectAllFields"
            };
    drawSwitch(switchObj,cdiv.id);
    Ctrl("switch_all_checkbox_"+zone).style.marginLeft = "199px";
    Ctrl("switch_all_checkbox_"+zone).style.marginTop = "10px";
  }

  if(zone=="report" || zone=="break")
    drawFields(cdiv,mtop,mleft,zone);
  else
    drawFields(cdiv,mtop,mleft,zone,reportflds);

  switch(zone){
    case "report":
      checkFields(reportflds,zone);
      break;
    case "break":
      checkFields(breakFields,zone);
      break;
    case "header":
      checkFields(headerFields,zone);
      break;
    case "footer":
      checkFields(footerFields,zone);
      break;
  }
}

function pageSettings(){
  currentpage = pTitles.length-1;
  validatePage();
  resetContent(currentpage);

  var cdiv = mWizardBody;
  var div = document.createElement("div");
  div.className = "unselectable description";
  div.textContent = getTranslated("SMR_PAGESETTINGS","Specify report page settings");
  div.style.marginLeft = "25px";
  cdiv.appendChild(div);
  cdiv.appendChild(drawPSettings(format,"Format"));
  cdiv.appendChild(drawPSettings(orient,"Orientation"));
  cdiv.appendChild(drawPMargins());
}

function drawPSettings(array,type){
  var pdiv,elem,div,pic,text;

  var wi = 100;
  var w = (mWizardBody.offsetWidth-wi)/array.length;

  if(w>=150)
    w=150;

  pdiv = document.createElement("div");
  pdiv.className = "tdiv";
  elem = document.createElement("div");
  elem.className = "unselectable description pagetext";
  elem.textContent = getTranslated("SMR_PAPER" ,"Paper")+ " " + getTranslated("SMR_" + type, type.toLowerCase()).toLowerCase();
  pdiv.appendChild(elem);
  for(var i=0; i<array.length; i++){
    if(type.toLowerCase()=="format" && !docSettingsMM[array[i]]) continue;
    elem = document.createElement("div");
    elem.id = type.toLowerCase()+"_"+array[i]+"_div";
    elem.className = "textpiccont";
    if(i==0)
      elem.style.marginLeft = "20px";
    pic = document.createElement("span");
    pic.id = type.toLowerCase()+"_"+array[i];
    pic.className = "pagepic";
    if(type.toLowerCase()!="orientation")
      pic.className+=" "+page.orientation;
    else
      pic.className+=" "+array[i].toLowerCase();
    if(page.orientation == array[i] || page.format == array[i])
      pic.className+=" clicked";
    if(type.toLowerCase()!="orientation")
      pic.style.backgroundImage = "url(../smartreport/images/wizard/"+array[i]+"_"+page.orientation+".png)";
    else
      pic.style.backgroundImage = "url(../smartreport/images/wizard/"+page.format+"_"+array[i]+".png)";
    elem.appendChild(pic);
    text = document.createElement("div");
    text.id = type.toLowerCase()+"_"+array[i]+"_desc";
    if(type.toLowerCase()!="orientation")
      text.className = "unselectable descpic "+page.orientation[0]+"text";
    else
      text.className = "unselectable descpic "+array[i][0]+"text";
    text.textContent = getTranslated("SMR_" + array[i], array[i]) //array[i]; //SMR_PORTRAIT //SMR_LANDSCAPE
    text.style.cursor = "pointer";
    elem.appendChild(text);
    pdiv.appendChild(elem);
    elem.onclick = setClicked;
    if(type.toLowerCase()=="format"){
      div = document.createElement("div");
      div.id = type.toLowerCase()+"_"+array[i]+"_size";
      div.className = "descpic size "+page.orientation[0]+"size";
      pic = document.createElement("span");
      pic.className = "sizepicw";
      pic.style.cursor = "pointer";
      div.appendChild(pic);
      text = document.createElement("div");
      text.id = type.toLowerCase()+"_"+array[i]+"_sizew";
      text.style.float = "right";
      text.style.cursor = "pointer";
      if(page.orientation=="portrait")
        text.textContent = docSettingsMM[array[i]].w+" mm";
      else
        text.textContent = docSettingsMM[array[i]].h+" mm";
      div.appendChild(text);
      pic = document.createElement("span");
      pic.className = "sizepich";
      pic.style.cursor = "pointer";
      div.appendChild(pic);
      text = document.createElement("div");
      text.id = type.toLowerCase()+"_"+array[i]+"_sizeh";
      text.style.float = "right";
      text.style.cursor = "pointer";
      if(page.orientation=="portrait")
        text.textContent = docSettingsMM[array[i]].h+" mm";
      else
        text.textContent = docSettingsMM[array[i]].w+" mm";
      div.appendChild(text);
      elem.appendChild(div);
    }
  }
  return pdiv;
}

function drawPMargins(){
  var pdiv,elem,div,pic,text;
  pdiv = document.createElement("div");
  pdiv.className = "tdiv";
  elem = document.createElement("div");
  elem.className = "unselectable description pagetext";
  elem.textContent = getTranslated("SMR_PAGEMARGINS", "Page margins");
  pdiv.appendChild(elem);
  div = document.createElement("div");
  div.style.width = "85%";
  div.style.float = "left";
  div.style.height = "25px";
  div.style.marginTop = "10px";
  div.style.marginLeft = "15px";
  text = document.createElement("select");
  for(var i=0; i<opt.length; i++){
    elem = document.createElement("option");
    elem.className = "unselectable";
    var t = getTranslated("SMR_" + opt[i], opt[i]);
    t = t.charAt(0).toUpperCase()+t.slice(1); //SMR_AUTOMATIC //SMR_NONE //SMR_CUSTOM //SMR_MINIMUM
    elem.textContent = t;
    elem.value = opt[i];
    text.appendChild(elem);
  }
  div.appendChild(text);
  text.onchange = setMarginsType;
  pdiv.appendChild(div);
  for(i=0; i<mar.length; i++){
    elem = document.createElement("div");
    elem.id = mar[i]+"_div";
    elem.className = "textpiccont pmargin";
    if(i==0)
      elem.style.marginLeft = "70px";
    pic = document.createElement("span");
    pic.id = "margin_"+mar[i];
    pic.className = "pagepic "+page.orientation;
    pic.style.backgroundImage = "url(../smartreport/images/wizard/"+mar[i]+"_"+page.format+"_"+page.orientation+".png)";
    pic.style.cursor = "default";
    elem.appendChild(pic);
    text = document.createElement("input");
    text.id = mar[i]+"_unit";
    text.type = "number";
    text.step = "any";
    text.className = "desctxt "+page.orientation[0]+"input inputdisabled";
    text.value = margins[mar[i]];
    text.readOnly = true;
    elem.appendChild(text);
    text.onchange = convertMargin;
    text = document.createElement("div");
    text.id = mar[i]+"_u";
    text.className = "unselectable descpic unitm"+page.orientation[0];
    text.style.fontSize = 10+"px";
    text.textContent = "mm";
    elem.appendChild(text);
    pdiv.appendChild(elem);
  }
  return pdiv;
}

function setMarginsType(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  margins.type = ctrl.value;
  calculateMargins();
  validatePage();
}

function setTitle(){
  titler = Ctrl("reporttitle").value;
  validatePage();
}

function validatePage(){
  var i;
  for(i=currentpage;i>=0; i--)
    validatePreviousStep(i);
  var valid = false;
  switch(currentpage){
    case 0:
      valid = !Empty(datasource);
      if(valid) {
        if(datasource.indexOf("BO:") == 0) {
          valid = (new JSURL("../servlet/SPXDCProxy?action=procedure_fields&entity=" + URLenc(datasource.substring(3)), true).Response()) != "[]";
          if(!valid)
            PSAlert.alert("BO not found.");
        }
        else {
          valid = (new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename=" + URLenc(datasource), true).Response()) == 1;
          if(!valid)
            PSAlert.alert("Query not found.");
        }
      }
      validateNextStep(valid,currentpage);
      break;
    case 1:
      valid = (!Empty(reportmodel));
      validateNextStep(valid,currentpage);
      break;
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
      valid = !Empty(reportflds);
      validateNextStep(valid,currentpage);
      break;
    default:
      valid = !Empty(reportflds);
      for(i=currentpage;i<pTitles.length-1; i++)
        validateNextStep(valid,i);
      break;
  }
  applyCurrent(currentpage);

}

function checkFields(marray,zone){
  if(!Empty(marray)){
    for(var i=0; i<marray.length; i++){
      if(Ctrl(allFields[marray[i]].alias+"_checkbox_"+zone) && !Ctrl(allFields[marray[i]].alias+"_checkbox_"+zone).checked)
        manageOnOffWizard(null,Ctrl(allFields[marray[i]].alias+"_checkbox_"+zone));
    }
  }
}

function setClicked(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  var pid = "";
  var old = "";
  if(ctrl.id.indexOf("model")>=0){  // click sul report model
    reportmodel = propClickedClass(model,Strtran(ctrl.id,"_label",""),"model");
  }
  else if(ctrl.id.indexOf("orientation")>=0){  // click su page orientation
    pid = ctrl.parentElement.id;
    old = page.orientation;
    page.orientation = propClickedClass(orient,Strtran(pid,"_div",""),"orientation");
    changePageOrientation(old);
  }
  else if(ctrl.id.indexOf("format")>=0){  // click su page format
    pid = ctrl.parentElement.id;
    old = page.format;
    if(pid.indexOf("_div")<0)
      page.format = propClickedClass(format,Strtran(pid,"_size",""),"format");
    else
      page.format = propClickedClass(format,Strtran(pid,"_div",""),"format");
    changePageFormat(old);
  }
  else if(ctrl.id.indexOf("source")>=0){
    if(ctrl.id.indexOf("vqr")>=0)
      selectvqr("sourcename");
    else if(ctrl.id.indexOf("bo")>=0)
      selectbo();
    /*else
      selectzoom();*/
  }

  validatePage();
}

function propClickedClass(array,id,pid){
  var prop = "";
  if(!Ctrl(id))
    return;
  for(var i=0; i<array.length; i++){
    if(!$(id).hasClass("clicked") && id.indexOf(array[i])>=0){  // e' quello che ho scelto
      prop = array[i];
      $(id).addClass("clicked");
    }
    else if($(pid+"_"+array[i]))
      $(pid+"_"+array[i]).removeClass("clicked");
  }
  return prop;
}

function changePageOrientation(old){
  var pics = [];
  var text = [];
  var ips = [];
  var newc = page.orientation;
  if(newc==old || Empty(newc) || Empty(page.format))
    return;

  pics = document.getElementsByClassName(old);
  text = document.getElementsByClassName(old[0]+"text");
  ips = document.getElementsByClassName(old[0]+"input");

  var i;
  for(i=pics.length-1; i>=0; i--){
    if(pics[i].id.indexOf("orientation")<0){
      $(pics[i].id).addClass(newc);
      $(pics[i].id).removeClass(old);
    }
  }

  for(i=text.length-1; i>=0; i--){
    $(text[i].id).addClass(newc[0]+"text");
    $(text[i].id).removeClass(old[0]+"text");
  }

  for(i=ips.length-1; i>=0; i--){
    $(ips[i].id).addClass(newc[0]+"input");
    $(ips[i].id).removeClass(old[0]+"input");
  }

  for(i=0; i<format.length; i++){
    if(!Ctrl("format_"+format[i]))
      continue;
    Ctrl("format_"+format[i]).style.backgroundImage = "url(../smartreport/images/wizard/"+format[i]+"_"+newc+".png)";
    if(newc=="portrait"){
      $("format_"+format[i]+"_size").removeClass("lsize");
      $("format_"+format[i]+"_size").addClass("psize");
      Ctrl("format_"+format[i]+"_sizew").textContent = docSettingsMM[format[i]].w+" mm";
      Ctrl("format_"+format[i]+"_sizeh").textContent = docSettingsMM[format[i]].h+" mm";
    }
    else{
      $("format_"+format[i]+"_size").removeClass("psize");
      $("format_"+format[i]+"_size").addClass("lsize");
      Ctrl("format_"+format[i]+"_sizew").textContent = docSettingsMM[format[i]].h+" mm";
      Ctrl("format_"+format[i]+"_sizeh").textContent = docSettingsMM[format[i]].w+" mm";
    }
  }

  for(i=0; i<mar.length; i++){
    Ctrl("margin_"+mar[i]).style.backgroundImage = "url(../smartreport/images/wizard/"+mar[i]+"_"+page.format+"_"+newc+".png)";
    convertMargin(null,Ctrl("margin_"+mar[i]));
    if(newc=="portrait"){
      $(mar[i]+"_u").removeClass("unitml");
      $(mar[i]+"_u").addClass("unitmp");
    }
    else{
      $(mar[i]+"_u").addClass("unitml");
      $(mar[i]+"_u").removeClass("unitmp");
    }
  }

}

function changePageFormat(old){
  var newc = page.format;
  if(newc==old || Empty(newc) || Empty(page.orientation))
    return;
  var i;
  for(i=0; i<orient.length; i++)
    Ctrl("orientation_"+orient[i]).style.backgroundImage = "url(../smartreport/images/wizard/"+newc+"_"+orient[i]+".png)";

  for(i=0; i<mar.length; i++){
    Ctrl("margin_"+mar[i]).style.backgroundImage = "url(../smartreport/images/wizard/"+mar[i]+"_"+newc+"_"+page.orientation+".png)";
    convertMargin(null,Ctrl("margin_"+mar[i]));
  }
}

function setFields(e){
  // memorizzo i fld da disegnare nei loro array
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  var mid = -1;

  var type = ctrl.id.substring(ctrl.id.indexOf("checkbox_")+9);
  var array = [];
  switch(type){
    case "report":
      array = reportflds;
      break;
    case "break":
      array = breakFields;
      break;
    case "header":
      array = headerFields;
      break;
    case "footer":
      array = footerFields;
      break;
  }

  mid = parseInt(getDataAttr(Ctrl(getDataAttr(ctrl)+"_space").firstChild));
  if(ctrl.checked && array.indexOf(mid)<0)
    array.push(mid);
  else if(!ctrl.checked && array.indexOf(mid)>=0)
    array.splice(array.indexOf(mid),1);

  enableDragCtrl(ctrl);

  array.sort();
  checkSetAll(array);
  validatePage();
}

function selectAllFields(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);

  var chks = Ctrl("fldcontainer").firstChild.childNodes;

  var array = [];
  for(var i=0; i<chks.length-1; i=i+2){
    if(ctrl.checked)
      array.push(parseInt(getDataAttr(chks[i].firstChild)));
    if((i+1)<chks.length){
      chks[i+1].childNodes[3].firstChild.checked = ctrl.checked;
      manageOnOffWizard(null,chks[i+1].childNodes[3].firstChild,true);
      enableDragCtrl(chks[i+1].childNodes[3].firstChild);
    }
  }

  switch(currentpage){
    case 2:
      reportflds = array;
      break;
    case 3:
      breakFields = array;
      break;
    case 4:
      headerFields = array;
      break;
    case 5:
      footerFields = array;
      break;
  }

  validatePage();
}

function checkSetAll(array){
  var totarray = [];
  var id = "all_checkbox_";
  switch(currentpage){
    case 2:
      id+="report";
      totarray = allFields;
      break;
    case 3:
      id+="header";
      totarray = reportflds;
      break;
    case 4:
      id+="footer";
      totarray = reportflds;
      break;
  }

  if(!Ctrl(id))
    return;
  if(!Ctrl(id).checked && array.length<totarray.length)
    return;

  if(Ctrl(id).checked && array.length<totarray.length)
    Ctrl(id).checked = false;
  if(!Ctrl(id).checked && array.length==totarray.length)
    Ctrl(id).checked = true;
  manageOnOffWizard(null,Ctrl(id),true);
}

function enableDragCtrl(ctrl){
  var mdrag = Ctrl(getDataAttr(ctrl)+"_drag");
  if(ctrl.checked)
    $(mdrag.id).removeClass("hiddenAdd");
  else
    $(mdrag.id).addClass("hiddenAdd");
}

function convertMargin(e,ctrl){
  e = !e ? window.event : e;
  ctrl = !ctrl ? GetEventSrcElement(e) : ctrl;
  var marg;
  if(ctrl.tagName.toLowerCase()=="span" && margins.type=="automatic"){  // cambiamento di pagina o/f
    marg = ctrl.id.substring(ctrl.id.indexOf("_")+1);
    Ctrl(marg+"_unit").value = calcToAuto(marg);
  }
  else if(margins.type=="custom"){
    marg = ctrl.id.substring(0,ctrl.id.indexOf("_"));
    margins[marg] = parseFloat(ctrl.value);
  }
  validatePage();
}

function calcToAuto(type){
  // calcolo dei margini 4% sul lato di riferimento
  var value = 0;
  var perc = 4;

  if(page.orientation == "portrait"){
    if(type=="top" || type=="bottom")
      value = (parseFloat(docSettingsMM[page.format].h)*(perc/100)).toFixed(2);
    else
      value = (parseFloat(docSettingsMM[page.format].w)*(perc/100)).toFixed(2);
  }
  else{
    if(type=="top" || type=="bottom")
      value = (parseFloat(docSettingsMM[page.format].w)*(perc/100)).toFixed(2);
    else
      value = (parseFloat(docSettingsMM[page.format].h)*(perc/100)).toFixed(2);
  }
  return value;
}

function applyCurrent(n){
  if(Empty(Ctrl(n+"_step")))
    return;
  Ctrl(n+"_step").onclick = stepPage;
  $(n+"_step").addClass("selected");
  $(n+"_step").removeClass("curpoint");
  if( _myPortlet ) {
    if( _myPortlet.AddGenerateOnToolbar && n==6) _myPortlet.AddGenerateOnToolbar();
    if( _myPortlet.RemoveGenerateOnToolbar && n!=6) _myPortlet.RemoveGenerateOnToolbar();
  }
}

function applyEnabled(n){
  if(Empty(Ctrl(n+"_step")))
    return;
  Ctrl(n+"_step").onclick = stepPage;
  $(n+"_step").removeClass("selected");
  $(n+"_step").addClass("actived");
  $(n+"_step").addClass("curpoint");
}

function applyDisabled(n){
  if(Empty(Ctrl(n+"_step")))
    return;
  Ctrl(n+"_step").onclick = null;
  $(n+"_step").removeClass("selected");
  $(n+"_step").removeClass("actived");
  $(n+"_step").removeClass("curpoint");
}

function drawBreadcrumb(datas, cont){
  var div,elem,inn;
  div = document.createElement("div");
  div.id = "wizard_navigator";
  div.className = "navi WizardTabstrip wizardWrapper";
  cont.appendChild(div);

  var init=0;
  if(!Empty(datas)){
    datasource = datas;
    init=1;
  }
  var t = pTitles;

  var ctrl = Ctrl("wizard_navigator");
  var count = 1;
  for(var i=init; i<t.length; i++){
    if(!Empty(t[i])){
      div = document.createElement("div");
      div.id = i+"_step";
      div.className = "step tab_item";
      elem = document.createElement("div");
      elem.id = i+"_stepnum";
      elem.className = "tab_wizard_number";
      elem.textContent = count;
      div.appendChild(elem);
      elem = document.createElement("span");
      elem.className = "tab_span";
      inn = document.createElement("a");
      inn.id = i+"_steptext";
      inn.textContent = getTranslated("SMR_" + t[i], t[i]); //t[i];
      //SMR_DATASOURCE //SMR_TITLEANDMODEL
      //SMR_GROUPINGFIELDS //SMR_HEADERFIELDS //SMR_FOOTERFIELDS
      elem.appendChild(inn);
      div.appendChild(elem);
      ctrl.appendChild(div);
      count++;
    }
  }
}

function stepPage(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  var idx = ctrl.id.substring(0,ctrl.id.indexOf("_"));
  drawPage(idx);
}

function convertMarginsToPerc(){
  var value = 0;
  margins.unit = "%";
  for(var i=0; i<mar.length; i++){
    if(margins.auto)
      value = 4;
    else if(page.orientation == "portrait"){
      if(mar[i]=="top" || mar[i]=="bottom")
        value = ((parseFloat(margins[mar[i]])*100)/parseFloat(docSettingsMM[page.format].h)).toFixed(0);
      else
        value = ((parseFloat(margins[mar[i]])*100)/parseFloat(docSettingsMM[page.format].w)).toFixed(0);
    }
    else{
      if(mar[i]=="top" || mar[i]=="bottom")
        value = ((parseFloat(margins[mar[i]])*100)/parseFloat(docSettingsMM[page.format].w)).toFixed(0);
      else
        value = ((parseFloat(margins[mar[i]])*100)/parseFloat(docSettingsMM[page.format].h)).toFixed(0);
    }

    margins[mar[i]] = value;
  }
}

function generateReport(){
  if (!validateReportFields()) {
    PSAlert.alert("Select at least one field");
    return;
  }
  var opts_obj = {},
  opener = getOpener();
  opts_obj.datasource = datasource;
  opts_obj.title = titler;
  opts_obj.reportmodel = reportmodel;
  opts_obj.allFields = allFields;
  opts_obj.reportflds = reportflds;
  opts_obj.breakflds = breakFields;
  opts_obj.headerflds = headerFields;
  opts_obj.footerflds = footerFields;
  opts_obj.filterfooter = null;
  opts_obj.page = page;
  opts_obj.margins = margins;
  opts_obj.pageswitch = 1;
  opts_obj.offline = roffline;
  opts_obj.fromprint = null;
  opts_obj.printprops = null;
  opts_obj.totalsA = JSON.stringify([]);
  opener.generateReport(opts_obj);
  SetUpdated();
  CloseWindow();
}

window.onunload = function(){
  if(getOpener() && getOpener().closeERWizard) getOpener().closeERWizard(datasource,m_bUpdated);
}

function validateNextStep(isvalid,currentpage){
  var i;
  if(isvalid){
    applyEnabled(currentpage+1);
    for(i=currentpage+1;i<pTitles.length-1; i++)
      applyDisabled(i+1);
  }
  else{
    for(i=currentpage;i<pTitles.length-1; i++)
      applyDisabled(i+1);
  }
}

function validatePreviousStep(pagen){
  applyEnabled(pagen);
}

var divLen = 172;
function drawFields(cdiv,mtop,mleft,type,idxArray){
  var maxF = 8;
  var marr = [];
  if(idxArray)
    marr = filterFields(idxArray);

  var farray = allFields;
  var pdiv = document.createElement("div");
  if(Empty(farray))
    return pdiv;

  var ul,elem,elem2;
  pdiv = document.createElement("div");
  pdiv.id = "fldcontainer";
  if(allFields.length<=maxF)
    pdiv.style.overflowY = "hidden";
  else
    pdiv.style.width = "319px";

  ul = document.createElement("ul");
  ul.className = "fld_ul";
  ul.style.float = "left";
  ul.style.width = "100%";
  pdiv.appendChild(ul);
  cdiv.appendChild(pdiv);
  for(var i=0; i<farray.length; i++)
    addField(i,farray[i],type,marr,ul);
  elem = document.createElement("li");
  elem.id = allFields.length+"_last_space";
  elem2 = document.createElement("div");
  elem2.id = "fld_last_space";
  elem2.className = "unselectable fieldspace";
  elem.appendChild(elem2);
  ul.appendChild(elem);
  Ctrl("fld_last_space").setAttribute("data-attr",allFields.length);
}

function addField(idx,fldobj,type,marr,ul){
  var elem, elem2;
  elem = document.createElement("li");
  elem.id = idx+"_"+fldobj.alias+"_space";
  elem2 = document.createElement("div");
  elem2.id = "fld_"+fldobj.alias+"_space";
  elem2.className = "unselectable fieldspace";
  elem.appendChild(elem2);
  ul.appendChild(elem);
  elem = document.createElement("li");
  elem.id = "fld_"+fldobj.alias;
  elem.className = "divFieldList";
  elem.style.cursor = "default";
  elem2 = document.createElement("span");
  elem2.id = idx+"_"+fldobj.alias+"_drag";
  elem2.className = "unselectable dragSpan usedField hiddenAdd";
  elem.appendChild(elem2);
  addFieldInList(idx,fldobj,elem);
  ul.appendChild(elem);

  var switchObj = {name: "S",
       propID: fldobj.alias+"_checkbox_"+type,
       tooltip: "",
       actions: "setFields"
      };
  drawSwitch(switchObj,"fld_"+fldobj.alias,false,true);
  Ctrl("switch_"+fldobj.alias+"_checkbox_"+type).style.cssFloat = "right";
  Ctrl("switch_"+fldobj.alias+"_checkbox_"+type).style.marginTop = "-29px";
  Ctrl("switch_"+fldobj.alias+"_checkbox_"+type).style.marginRight = "10px";
  Ctrl("switch_"+fldobj.alias+"_checkbox_"+type).style.width = "47px";
  Ctrl(idx+"_"+fldobj.alias+"_fld").style.marginLeft = "20px";
  Ctrl(idx+"_"+fldobj.alias+"_fld").style.cursor = "default";
  Ctrl(idx+"_"+fldobj.alias+"_fld").firstChild.style.cursor = "default";
  Ctrl(idx+"_"+fldobj.alias+"_fldlen").style.marginLeft = "20px";
  Ctrl(idx+"_"+fldobj.alias+"_fldlen").style.cursor = "default";
  Ctrl(idx+"_"+fldobj.alias+"_drag").onmouseenter = drawShadowField;
  Ctrl(idx+"_"+fldobj.alias+"_drag").onmousedown = dragShadowField;
  $(idx+"_"+fldobj.alias+"_drag").addClass("hiddenAdd");
  Ctrl("fld_"+fldobj.alias+"_space").setAttribute("data-attr",idx);
  Ctrl("fld_"+fldobj.alias).setAttribute("data-attr",fldobj.alias);
  Ctrl("switch_"+fldobj.alias+"_checkbox_"+type).setAttribute("data-attr",idx+"_"+fldobj.alias);

  if(!Empty(marr)){
    if(marr.indexOf(fldobj)<0){
      $(idx+"_"+fldobj.alias+"_space").addClass("hiddenAdd");
      $("fld_"+fldobj.alias).addClass("hiddenAdd");
    }
    else{
      $(idx+"_"+fldobj.alias+"_space").removeClass("hiddenAdd");
      $("fld_"+fldobj.alias).removeClass("hiddenAdd");
    }
  }
}

function ToStringHTML(p_cVar) {
  p_cVar = ToHTML(p_cVar);
  p_cVar = Strtran(p_cVar, " ", "&nbsp;");
  return p_cVar;
}

function calculateMargins(){
  switch(margins.type){
    case "automatic":
      setMargins("auto");
      break;
    case "none":
      setMargins("none");
      break;
    case "minimum":
      setMargins("min");
      break;
    case "custom":
      setMargins("custom");
      break;
  }
}

function setMargins(type){
  for(var i=0; i<mar.length; i++){
    if(type=="custom"){
      Ctrl(mar[i]+"_unit").readOnly = false;
      $(mar[i]+"_unit").removeClass("inputdisabled");
    }
    else{
      Ctrl(mar[i]+"_unit").readOnly = true;
      $(mar[i]+"_unit").addClass("inputdisabled");
      if(type=="auto")  // 4%
        margins[mar[i]] = calcToAuto(mar[i]);
      else if(type=="none")  // 0mm
        margins[mar[i]] = 0;
      else  // 5mm
        margins[mar[i]] = 5;
      Ctrl(mar[i]+"_unit").value = margins[mar[i]];
    }
  }
}

function selectvqr(){
  var ctrlid = "sourcename";
  var url = "../portalstudio/open.jsp?tool=visualquery&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionBuilderReturn";
    //openSPModalLayer(url,20,0,width,height,true,1,false);
  var additionalUrl = "width=580,height=600"
  layerOpenForeground(url,"querySPModalLayer",additionalUrl,"","","",1);  // messo x mobile
}

function ExpressionBuilderReturn(id,value,params){
  roffline = params.offlinemode;
  if(id){
    var el = Ctrl(id);
    if(el){
        el.value = value;
        el.focus();
        el.blur();
      }
  }
  setDataSName();
}

function selectbo() {
  var url = "../smartreport/selectDatasource.jsp?datasource=bo&offlinemode="+roffline+"&callerFunction=setBoName";
  var additionalUrl = "width=580,height=535"
  layerOpenForeground(url,"boSPModalLayer",additionalUrl,"","","",1);  // messo x mobile
}

function setBoName(boname,offline){
  ExpressionBuilderReturn("sourcename",boname,offline);
}

function selectzoom(){
  var ctrlid = "sourcename";
  var url = "../portalstudio/open.jsp?tool=portalzoom&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionBuilderReturn";
  //openSPModalLayer(url,20,0,width,height,true,1,false);
  var additionalUrl = "width=580,height=600"
  layerOpenForeground(url,"vzmSPModalLayer",additionalUrl,"","","",1);  // messo x mobile
}

function setDataSName(){
  if(!Empty(datasource) && Ctrl("sourcename").value!=datasource){
    resetAll();
	setAllFields(Ctrl("sourcename").value);
  }
  datasource = Ctrl("sourcename").value;
  validatePage();
}

function drawSwitch(prop, pID, value, hidetext) {
  var check = false,
  appFont = {name: "Open Sans", size: 13, weight: 400},
  switchW = 20,
  offsetH = switchW;

  var propSwitch = document.createElement("div");
  propSwitch.id = "switch_" + prop.propID;
  propSwitch.className = "onoffprop";
  prop.name = getTranslated("SMR_" + prop.name, prop.name);
  //SMR_SELECTALL
  propSwitch.style.width = (getOffsetWidth(prop.name, appFont) + switchW + offsetH) + "px";
  if (prop.margin)
    propSwitch.style.marginTop = prop.margin + "px";
  propSwitch.title = prop.tooltip;
  Ctrl(pID).appendChild(propSwitch);

  var input = document.createElement("INPUT");
  input.id = prop.propID;
  input.className = "onoffprop-checkbox";
  input.type = "checkbox";
  input.name = prop.propID;
  if (value) {
    input.checked = true;
    check = true;
  }
  propSwitch.appendChild(input);
  if (prop.actions)
    input.onclick = window[prop.actions];

  var label = document.createElement("LABEL");
  label.className = "onoffprop-label";
  label.for = prop.propID;
  propSwitch.appendChild(label);
  label.onclick = manageOnOffWizard;
  label.setAttribute("data-prop", prop.propID);

  var div = document.createElement("div");
  div.className = "onoffprop-inner";
  if (hidetext)
    div.className += " hidetextcolor";
  else
    div.className += " whitetextcolor";
  label.appendChild(div);
  div.setAttribute("data-attr", prop.name);
  div.setAttribute("data-prop", prop.propID);

  var span = document.createElement("span");
  span.id = prop.propID + "onoffswitch";
  span.className = "onoffprop-switch";
  if (check)
    span.style.right = 2 + "px";
  else
    span.style.right = (getOffsetWidth(prop.name, appFont) + offsetH - 2) + "px";
  label.appendChild(span);
  span.setAttribute("data-prop", prop.propID);

  removeSpanTag();
}

function manageOnOffWizard(e, src, noClick) {
  e = !e ? window.event : e;
  var btn;
  if (!Empty(src))
    btn = src;
  else
    btn = Ctrl(GetEventSrcElement(e).getAttribute("data-prop"));

  if (!noClick)
    btn.dispatchEvent(new MouseEvent("click"));

  if(Ctrl(btn.id + "onoffswitch")) {
    if (btn.checked)
      Ctrl(btn.id + "onoffswitch").style.right = 2 + "px";
    else
      Ctrl(btn.id + "onoffswitch").style.right = (btn.parentNode.offsetWidth - 20 - 2) + "px";
  }
}

function getFieldDesc(alias){
  for(var i=0; i<allFields.length; i++){
    if(allFields[i].alias == alias){
      if(Empty(allFields[i].desc))
        return allFields[i].alias;
      return allFields[i].desc;
    }
  }
}

function getFieldIdx(alias){
  for(var i=0; i<allFields.length; i++){
    if(allFields[i].alias == alias){
      return i;
    }
  }
}

function getFieldObj(alias){
  for(var i=0; i<allFields.length; i++){
    if(allFields[i].alias == alias){
      return allFields[i];
    }
  }
}

var idFld = "";
var posinlist = -1;
var dx,dy,xpos,ypos;
function drawShadowField(e){
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  if(!ctrl)
    return;
  idFld = "fld_"+getDataAttr(ctrl);
  ctrl = document.getElementById(idFld);
  posinlist = parseInt(getDataAttr(Ctrl(idFld+"_space")));

  if(idFld.indexOf("_shadow")>=0){
    ctrl.onmousedown = null;
    document.body.style.cursor = "auto";
    document.body.onmousemove = null;
    document.body.onmouseup = null;
    document.body.removeChild(ctrl);
    return;
  }

  if(document.getElementsByClassName("dragdropshadow").length>0){
    for(var i=0; i<document.getElementsByClassName("dragdropshadow").length; i++)
      document.body.removeChild(document.getElementsByClassName("dragdropshadow")[i]);
  }

  var shadowDD = document.createElement("div");
  shadowDD.id = idFld+"_shadow";
  shadowDD.className = "unselectable dragdropshadow";

  var abpos = (getAbsolutePos(ctrl));
  shadowDD.style.left = abpos.x + "px";
  shadowDD.style.top = (abpos.y-Ctrl("fldcontainer").scrollTop)+"px";
  shadowDD.style.marginTop = "";
  shadowDD.style.marginLeft = "";
  shadowDD.style.width = "220px";
  shadowDD.style.height = ctrl.offsetHeight + "px";
  shadowDD.style.fontSize = "12px";
  document.body.appendChild(shadowDD);
  var elem = document.createElement("div");
  elem.id = idFld+"_shadow_first";
  elem.style.float = "left";
  elem.style.height = "50%";
  elem.style.width = "97%";
  elem.style.overflow = "hidden";
  elem.style.textOverflow = "ellipsis";
  elem.style.textAlign = "center";
  shadowDD.appendChild(elem);
  elem = document.createElement("div");
  elem.id = idFld+"_shadow_second";
  elem.style.float = "left";
  elem.style.height = "49%";
  elem.style.width = "100%";
  elem.style.textAlign = "center";
  shadowDD.appendChild(elem);

  shadowDD.onmousedown = dragShadowField;
  shadowDD.onmouseup = putShadowField;
}

function dragShadowField(e){
  e = (e) ? e : window.event;
  addClassToItems("fieldspace","fieldspacehigh");
  $(idFld+"_shadow").addClass("dragdropshadowmovefield");
  var fielddesc = "";
  if(Empty(Ctrl(idFld+"_shadow_first").textContent)){
    fielddesc = getFieldDesc(Strtran(idFld,"fld_",""));
    if(fielddesc.length>6)
      fielddesc = fielddesc.substring(0,7)+"...";
    Ctrl(idFld+"_shadow_first").textContent = "Dragging ["+fielddesc+"]";
  }

  xpos = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
    ypos = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;

  dx = Ctrl(idFld+"_shadow").offsetLeft-xpos;
  dy = Ctrl(idFld+"_shadow").offsetTop-ypos;

  document.body.style.cursor = "move";
  document.body.onmousemove = moveShadowField;
}

var oldmid = -1;
function moveShadowField(e){
  e = (e) ? e : window.event;
  xpos = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
    ypos = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;

  var mx = xpos-(mWizardBody.offsetLeft+Ctrl("fldcontainer").offsetLeft);
  var my = ypos-Ctrl("fldcontainer").offsetTop+Ctrl("fldcontainer").scrollTop;

  var mid = highlightFieldSpace(mx,my);
  if(mid>=0 && mid!=posinlist && mid!=(posinlist+1) && mid!=oldmid){
    highlightFieldName(mid);
    oldmid = mid;
    var fielddesc,text;
    var rid = getRealPosList(mid);
    if((rid-1)<0){
      fielddesc = getFieldDesc(getDataAttr(Ctrl("fldcontainer").firstChild.childNodes[(mid*2)+1]));
      if(fielddesc.length>6)
        fielddesc = fielddesc.substring(0,7)+"...";
      text = "Before ["+fielddesc+"]";
    }
    else if((mid*2)==Ctrl("fldcontainer").firstChild.childNodes.length-1){
      fielddesc = getFieldDesc(getDataAttr(Ctrl("fldcontainer").firstChild.childNodes[(mid*2)-1]));
      if(fielddesc.length>6)
        fielddesc = fielddesc.substring(0,7)+"...";
      text = "In last position";
    }
    else{
      rid = getBeforePosList(mid);
      fielddesc = getFieldDesc(getDataAttr(Ctrl("fldcontainer").firstChild.childNodes[(rid*2)+1]));
      if(fielddesc.length>6)
        fielddesc = fielddesc.substring(0,7)+"...";
      text = "Between ["+fielddesc+"] and [";
      fielddesc = getFieldDesc(getDataAttr(Ctrl("fldcontainer").firstChild.childNodes[(mid*2)+1]));
      if(fielddesc.length>6)
        fielddesc = fielddesc.substring(0,7)+"...";
      text+=(fielddesc+"]");
    }
    Ctrl(idFld+"_shadow_second").textContent = text;
  }
  else if(mid<0 || mid==posinlist || mid==(posinlist+1)){
    highlightFieldName(-1);
    Ctrl(idFld+"_shadow_second").textContent = "";
    oldmid = -1;
  }

  var hp = Ctrl(idFld).offsetHeight;
  var limy = getY(Ctrl("fldcontainer"));
  var limyy = limy + Ctrl("fldcontainer").offsetHeight;
  if(limy<ypos && limyy>ypos){
    if(ypos+hp>limyy)
      Ctrl("fldcontainer").scrollTop+=hp;
    else if(ypos-hp<limy)
      Ctrl("fldcontainer").scrollTop-=hp;
  }
  xpos+=dx;
  ypos+=dy;
  document.getElementById(idFld+"_shadow").style.left = xpos+"px";
  document.getElementById(idFld+"_shadow").style.top = ypos+"px";
  document.body.onmouseup = putShadowField;
}

function getRealPosList(poslist){
  var items = Ctrl("fldcontainer").firstChild.childNodes;
  var count = 0;
  for(var i=0; i<items.length && i<poslist*2; i++){
    if(items[i].id.indexOf("fld_")>=0 && $(items[i].id).hasClass("hiddenAdd"))
      count++;
  }
  return poslist - count;
}

function getBeforePosList(poslist){
  var items = Ctrl("fldcontainer").firstChild.childNodes;
  for(var i=(poslist*2)-1; i>=0; i=i-2){
    if(items[i].id.indexOf("fld_")>=0 && !$(items[i].id).hasClass("hiddenAdd"))
      return Math.floor((i/2));
  }
}

function highlightFieldSpace(xp,yp){
  var items = document.getElementsByClassName("fieldspace");
  var l = items.length;
  var idx = -1;
  for(var i=0; i<l; i++){
    $(items[i].id).removeClass("fieldspacehighlight");
    if(xp>=items[i].offsetLeft && xp<=(items[i].offsetLeft+items[i].offsetWidth)){
      if(yp>=items[i].offsetTop && yp<=(items[i].offsetTop+items[i].offsetHeight)){
        $(items[i].id).addClass("fieldspacehighlight");
        idx = parseInt(getDataAttr(items[i]));
      }
    }
  }
  return idx;
}

function highlightFieldName(idx){
  var flds = Ctrl("fldcontainer").firstChild.childNodes;
  var mid = "", ipos = -1;
  for(var i=1; i<flds.length; i=i+2){
    ipos = parseInt(getDataAttr(Ctrl("fld_"+getDataAttr(flds[i])+"_space")));
    mid = ipos+"_"+getDataAttr(flds[i])+"_fld";
    if(!Empty(Ctrl(mid)) && ipos!=getBeforePosList(idx) && ipos!=idx){
      $(mid).addClass("fieldObjectDrag");
      $(mid+"len").addClass("fieldObjectLenDrag");
      $(mid+"lenColor").addClass("fieldObjectLenCDrag");
    }
    else if(!Empty(Ctrl(mid))){
      $(mid).removeClass("fieldObjectDrag");
      $(mid+"len").removeClass("fieldObjectLenDrag");
      $(mid+"lenColor").removeClass("fieldObjectLenCDrag");
    }
  }
}

function putShadowField(/*e*/){
  var dest = document.getElementsByClassName("fieldspacehighlight")[0];
  if(!Empty(dest)){
    moveField(idFld,posinlist,dest);
    setFieldListPositions("fldcontainer");
    if(currentpage<=2)
      allFields = updateAllFieldsArray();
  }
  removeClassFromItems("fieldspacehigh");
  removeClassFromItems("fieldspacehighlight");
  removeClassFromItems("fieldObjectDrag");
  removeClassFromItems("fieldObjectLenDrag");
  removeClassFromItems("fieldObjectLenCDrag");
  document.body.removeChild(Ctrl(idFld+"_shadow"));
  document.body.style.cursor = "default";
  document.body.onmousedown = null;
  document.body.onmousemove = null;
  document.body.onmouseup = null;

  idFld = "";
  dx=dy=xpos=ypos=null;
  posinlist = -1;
}

function moveField(idFld,posinlist,dest){
  var itemtomove = Ctrl(idFld);
  Ctrl("fldcontainer").firstChild.insertBefore(itemtomove,dest.parentNode);
  var itemtomovespace = Ctrl(Strtran(idFld,"fld_",posinlist+"_")+"_space");
  Ctrl("fldcontainer").firstChild.insertBefore(itemtomovespace,itemtomove);
}

function setFieldListPositions(idcont){
  var listul = Ctrl(idcont).firstChild.children;
  var tid = "";
  var idx = -1;
  for(var i=0; i<listul.length; i++){
    idx = Math.floor((i/2));
    if(listul[i].id.indexOf("_space")>=0){
      listul[i].firstChild.setAttribute("data-attr",idx);
      tid = listul[i].id;
      listul[i].id = idx+tid.substring(tid.indexOf("_"));
    }
    else{
      tid = getDataAttr(listul[i]);
      listul[i].childNodes[0].id = idx+"_"+tid+"_drag";
      listul[i].childNodes[1].id = idx+"_"+tid+"_fld";
      listul[i].childNodes[2].firstChild.id = idx+"_"+tid+"_fldlenColor";
      listul[i].childNodes[2].id = idx+"_"+tid+"_fldlen";
    }
  }
}

function updateAllFieldsArray(){
  var listul = Ctrl("fldcontainer").firstChild.children;
  var ret = [];
  for(var i = 1; i < listul.length; i=i+2){
    ret.push(getFieldObj(getDataAttr(listul[i])));
  }
  return ret;
}

function validateReportFields(){
  return !Empty(reportflds);
}

function resetAll(){
  reportflds = [];
  breakFields = [];
  headerFields = [];
  footerFields = [];
  reportmodel = "";
  titler = "";
}

var m_function = 'discard'
function SendData(/*action*/) { //simulate BO - sendData - per chiusura da spmodallayer
  CloseWindow(true);
}
