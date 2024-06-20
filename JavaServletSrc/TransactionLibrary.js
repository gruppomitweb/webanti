//---Start function: CurrentTransactionStatus
function transactionlibrary_CurrentTransactionStatus() {
  return "";
}
//---End function

//---Start function: IsTransactionOk
function transactionlibrary_IsTransactionOk() {
  return true;
}
//---End function

//---Start function: LastTransactionStatus
function transactionlibrary_LastTransactionStatus() {
  return "";
}
//---End function

//---Start function: WasTransactionOk
function transactionlibrary_WasTransactionOk() {
  return true;
}
//---End function

//---Start function: MakeTransactionLibrary
function MakeTransactionLibrary() {
  this.CurrentTransactionStatus=transactionlibrary_CurrentTransactionStatus
  this.IsTransactionOk=transactionlibrary_IsTransactionOk
  this.LastTransactionStatus=transactionlibrary_LastTransactionStatus
  this.WasTransactionOk=transactionlibrary_WasTransactionOk
}
//---End function

var TransactionLibrary = new MakeTransactionLibrary()
