(function() {//MakeFileLibrary
//---Start function: Close
function filelibrary_Close(){
  return;
}
//---End function

//---Start function: CopyDirectory
function filelibrary_CopyDirectory(srcDir, dstDir) {
  var res = false;
  return res;
}
//---End function

//---Start function: CreateDir
function filelibrary_CreateDir(path) {
  var res = false;
  return res;
}
//---End function

//---Start function: DeleteDirectory
function filelibrary_DeleteDirectory(dir) {
  var res = false;
  return res;
}
//---End function

//---Start function: DeleteFile
function filelibrary_DeleteFile(filename) {
  var res = false;
  return res;
}
//---End function

//---Start function: Eof
function filelibrary_Eof(){
  return;
}
//---End function

//---Start function: ExistFile
function filelibrary_ExistFile(filename) {
  var res = false;
  return res;
}
//---End function

//---Start function: FileCopy
function filelibrary_FileCopy(source, destination) {
  var res = false;
  return res;
}
//---End function

//---Start function: GetLastModified
function filelibrary_GetLastModified(filename) {
  return new Date()
}
//---End function

//---Start function: GetLocation
function filelibrary_GetLocation() {
  var res = "";
  return res;
}
//---End function

//---Start function: MoveFile
function filelibrary_MoveFile() {
  var res = false;
  return res;
}
//---End function

//---Start function: OpenAppend
function filelibrary_OpenAppend(filename, CharSet) {
  var res = "";
  return res;
}
//---End function

//---Start function: OpenRead
function filelibrary_OpenRead(Name, CharSet) {
  return;
}
//---End function

//---Start function: OpenWrite
function filelibrary_OpenWrite(Name, CharSet) {
  return;
}
//---End function

//---Start function: ReadLine
function filelibrary_ReadLine(){
  return;
}
//---End function

//---Start function: RenameFile
function filelibrary_RenameFile(oldfilename, newfilename) {
  var res = false;
  return res;
}
//---End function

//---Start function: SetLocation
function filelibrary_SetLocation(){
  return;
}
//---End function

//---Start function: Write
function filelibrary_Write(){
  return;
}
//---End function

//---Start function: WriteLine
function filelibrary_WriteLine(){
  return;
}
//---End function

//---Start function: MakeFileLibrary
function MakeFileLibrary() {
  this.Close=filelibrary_Close
  this.CopyDirectory=filelibrary_CopyDirectory
  this.CreateDir=filelibrary_CreateDir
  this.DeleteDirectory=filelibrary_DeleteDirectory
  this.DeleteFile=filelibrary_DeleteFile
  this.Eof=filelibrary_Eof
  this.ExistFile=filelibrary_ExistFile
  this.FileCopy=filelibrary_FileCopy
  this.GetLastModified=filelibrary_GetLastModified
  this.GetLocation=filelibrary_GetLocation
  this.MoveFile=filelibrary_MoveFile
  this.OpenAppend=filelibrary_OpenAppend
  this.OpenRead=filelibrary_OpenRead
  this.OpenWrite=filelibrary_OpenWrite
  this.ReadLine=filelibrary_ReadLine
  this.RenameFile=filelibrary_RenameFile
  this.SetLocation=filelibrary_SetLocation
  this.Write=filelibrary_Write
  this.WriteLine=filelibrary_WriteLine
}
//---End function

arguments[0].FileLibrary = new MakeFileLibrary()
})(window);//MakeFileLibrary
