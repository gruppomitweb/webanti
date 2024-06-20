(function() {//MakeFileLibMit
//---Start function: Close
function filelibmit_Close(){
  return;
}
//---End function

//---Start function: CopyDirectory
function filelibmit_CopyDirectory(srcDir, dstDir) {
  var res = false;
  return res;
}
//---End function

//---Start function: CreateDir
function filelibmit_CreateDir(path) {
  var res = false;
  return res;
}
//---End function

//---Start function: CreateDirPath
function filelibmit_CreateDirPath(path) {
  var res = false;
  return res;
}
//---End function

//---Start function: DeleteDirectory
function filelibmit_DeleteDirectory(dir) {
  var res = false;
  return res;
}
//---End function

//---Start function: DeleteFile
function filelibmit_DeleteFile(filename) {
  var res = false;
  return res;
}
//---End function

//---Start function: DeleteFilePath
function filelibmit_DeleteFilePath(filename) {
  var res = false;
  return res;
}
//---End function

//---Start function: Eof
function filelibmit_Eof(){
  return;
}
//---End function

//---Start function: ExistFile
function filelibmit_ExistFile(filename) {
  var res = false;
  return res;
}
//---End function

//---Start function: FileCopy
function filelibmit_FileCopy(source, destination) {
  var res = false;
  return res;
}
//---End function

//---Start function: FileCopyPath
function filelibmit_FileCopyPath(src, dest) {
  var res = false;
  return res;
}
//---End function

//---Start function: GetLastModified
function filelibmit_GetLastModified(filename) {
  return new Date()
}
//---End function

//---Start function: GetLocation
function filelibmit_GetLocation() {
  var res = "";
  return res;
}
//---End function

//---Start function: MoveFile
function filelibmit_MoveFile() {
  var res = false;
  return res;
}
//---End function

//---Start function: OpenAppend
function filelibmit_OpenAppend(filename, charSet) {
  var res = "";
  return res;
}
//---End function

//---Start function: OpenAppendPath
function filelibmit_OpenAppendPath(filename, charSet) {
  var res = false;
  return res;
}
//---End function

//---Start function: OpenRead
function filelibmit_OpenRead(filename, charSet) {
  return;
}
//---End function

//---Start function: OpenReadPath
function filelibmit_OpenReadPath(filename, charSet) {
  var res = "";
  return res;
}
//---End function

//---Start function: OpenWrite
function filelibmit_OpenWrite(filename, charSet) {
  return;
}
//---End function

//---Start function: OpenWritePath
function filelibmit_OpenWritePath(filename, charSet) {
  var res = "";
  return res;
}
//---End function

//---Start function: ReadLine
function filelibmit_ReadLine(){
  return;
}
//---End function

//---Start function: RenameFile
function filelibmit_RenameFile(oldfilename, newfilename) {
  var res = false;
  return res;
}
//---End function

//---Start function: SetLocation
function filelibmit_SetLocation(){
  return;
}
//---End function

//---Start function: Write
function filelibmit_Write(){
  return;
}
//---End function

//---Start function: WriteLine
function filelibmit_WriteLine(){
  return;
}
//---End function

//---Start function: MakeFileLibMit
function MakeFileLibMit() {
  this.Close=filelibmit_Close
  this.CopyDirectory=filelibmit_CopyDirectory
  this.CreateDir=filelibmit_CreateDir
  this.CreateDirPath=filelibmit_CreateDirPath
  this.DeleteDirectory=filelibmit_DeleteDirectory
  this.DeleteFile=filelibmit_DeleteFile
  this.DeleteFilePath=filelibmit_DeleteFilePath
  this.Eof=filelibmit_Eof
  this.ExistFile=filelibmit_ExistFile
  this.FileCopy=filelibmit_FileCopy
  this.FileCopyPath=filelibmit_FileCopyPath
  this.GetLastModified=filelibmit_GetLastModified
  this.GetLocation=filelibmit_GetLocation
  this.MoveFile=filelibmit_MoveFile
  this.OpenAppend=filelibmit_OpenAppend
  this.OpenAppendPath=filelibmit_OpenAppendPath
  this.OpenRead=filelibmit_OpenRead
  this.OpenReadPath=filelibmit_OpenReadPath
  this.OpenWrite=filelibmit_OpenWrite
  this.OpenWritePath=filelibmit_OpenWritePath
  this.ReadLine=filelibmit_ReadLine
  this.RenameFile=filelibmit_RenameFile
  this.SetLocation=filelibmit_SetLocation
  this.Write=filelibmit_Write
  this.WriteLine=filelibmit_WriteLine
}
//---End function

arguments[0].FileLibMit = new MakeFileLibMit()
})(window);//MakeFileLibMit
