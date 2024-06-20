(function() {//MakeExcelMit
//---Start function: closeWb
function excelmit_closeWb(path) {
  var res = "";
  return res;
}
//---End function

//---Start function: getCells
function excelmit_getCells() {
}
//---End function

//---Start function: getMcCelle
function excelmit_getMcCelle() {
}
//---End function

//---Start function: getRow
function excelmit_getRow() {
}
//---End function

//---Start function: getRows
function excelmit_getRows() {
}
//---End function

//---Start function: hasNextRows
function excelmit_hasNextRows() {
  var res = false;
  return res;
}
//---End function

//---Start function: newCell
function excelmit_newCell(cellNum) {
}
//---End function

//---Start function: newRow
function excelmit_newRow(rowNum) {
  var res = "";
  return res;
}
//---End function

//---Start function: newSheet
function excelmit_newSheet(namesheet) {
}
//---End function

//---Start function: newWb
function excelmit_newWb(xlsx) {
}
//---End function

//---Start function: openWb
function excelmit_openWb(path) {
}
//---End function

//---Start function: readall
function excelmit_readall() {
}
//---End function

//---Start function: setCellValue
function excelmit_setCellValue(pCellStyle) {
  var res = "";
  return res;
}
//---End function

//---Start function: setMcCelle
function excelmit_setMcCelle(pmcCelle) {
}
//---End function

//---Start function: setSheet
function excelmit_setSheet(numeric_sheet) {
}
//---End function

//---Start function: writeall
function excelmit_writeall(autoSizeHeader) {
}
//---End function

//---Start function: MakeExcelMit
function MakeExcelMit() {
  this.closeWb=excelmit_closeWb
  this.getCells=excelmit_getCells
  this.getMcCelle=excelmit_getMcCelle
  this.getRow=excelmit_getRow
  this.getRows=excelmit_getRows
  this.hasNextRows=excelmit_hasNextRows
  this.newCell=excelmit_newCell
  this.newRow=excelmit_newRow
  this.newSheet=excelmit_newSheet
  this.newWb=excelmit_newWb
  this.openWb=excelmit_openWb
  this.readall=excelmit_readall
  this.setCellValue=excelmit_setCellValue
  this.setMcCelle=excelmit_setMcCelle
  this.setSheet=excelmit_setSheet
  this.writeall=excelmit_writeall
}
//---End function

arguments[0].ExcelMit = new MakeExcelMit()
})(window);//MakeExcelMit
