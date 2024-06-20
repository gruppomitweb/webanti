//---Start function: AdminDatabase
function databaselibrary_AdminDatabase() {
}
//---End function

//---Start function: CreateCompany
function databaselibrary_CreateCompany(codazi, desazi) {
  var res = "";
  return res;
}
//---End function

//---Start function: DeleteCompany
function databaselibrary_DeleteCompany(codazi) {
  var res = false;
  return res;
}
//---End function

//---Start function: GetPrimaryKey
function databaselibrary_GetPrimaryKey(tablename) {
  var res = "";
  return res;
}
//---End function

//---Start function: RemakeIndex
function databaselibrary_RemakeIndex() {
  var res = 0;
  return res;
}
//---End function

//---Start function: MakeDatabaseLibrary
function MakeDatabaseLibrary() {
  this.AdminDatabase=databaselibrary_AdminDatabase
  this.CreateCompany=databaselibrary_CreateCompany
  this.DeleteCompany=databaselibrary_DeleteCompany
  this.GetPrimaryKey=databaselibrary_GetPrimaryKey
  this.RemakeIndex=databaselibrary_RemakeIndex
}
//---End function

var DatabaseLibrary = new MakeDatabaseLibrary()
