public class TransactionLibrary {

//---Start function: TRANSACTIONLIBRARY_LIBRARY_CODE
  CPContext m_Ctx;
  public static TransactionLibrary Make(CPContext ctx) {
    TransactionLibrary l_TransactionLibrary = new TransactionLibrary();
    l_TransactionLibrary.m_Ctx = ctx;
    return l_TransactionLibrary;
  }
//---End function

//---Start function: CurrentTransactionStatus
public String CurrentTransactionStatus() {
  return m_Ctx.GetSql().CurrentTransactionStatus();
}
//---End function

//---Start function: IsTransactionOk
public boolean IsTransactionOk() {
  return m_Ctx.GetSql().IsTransactionOk("FileLibrary.IsTransactionOk");
}
//---End function

//---Start function: LastTransactionStatus
public String LastTransactionStatus() {
  return m_Ctx.GetSql().LastTransactionStatus();
}
//---End function

//---Start function: WasTransactionOk
public boolean WasTransactionOk() {
  return CPSql.TransactionWasOk("TransactionLibrary.WasTransactionOk");
}
//---End function

//---Start attributes
//---End attributes
}
