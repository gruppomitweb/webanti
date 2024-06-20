(function() {//MakeZipMit
//---Start function: getMcCelle
function zipmit_getMcCelle() {
}
//---End function

//---Start function: setMcCelle
function zipmit_setMcCelle(pmcCelle) {
  var res = "";
  return res;
}
//---End function

//---Start function: unzip
function untitled_unzip(zipFilePath, destDirPath) {
}
//---End function

//---Start function: zip
function zipmit_zip(zipFilePath, files, filetozip) {
}
//---End function

//---Start function: MakeZipMit
function MakeZipMit() {
  this.getMcCelle=zipmit_getMcCelle
  this.setMcCelle=zipmit_setMcCelle
  this.unzip=zipmit_unzip
  this.zip=zipmit_zip
}
//---End function

arguments[0].ZipMit = new MakeZipMit()
})(window);//MakeZipMit
