public class DatabaseLibrary {

//---Start function: DATABASELIBRARY_LIBRARY_CODE
CPContext m_Ctx;
public static DatabaseLibrary Make(CPContext ctx) {
  DatabaseLibrary l_DatabaseLibrary = new DatabaseLibrary();
  l_DatabaseLibrary.m_Ctx = ctx;
  return l_DatabaseLibrary;
}
//---End function

//---Start function: AdminDatabase
public boolean AdminDatabase() {
  return AdminDatabase(true);
}
public boolean AdminDatabase(boolean executeDBAdminRoutines) {
  boolean res;
  DBAdm dbadm = new DBAdm(m_Ctx, new SPXDCReaderFactory(m_Ctx.GetInstance()), "dbadmin");
  res = dbadm.AdminDatabase(true, "", "", false, executeDBAdminRoutines);
  if(res) {
    try {
      CPPooler.ReloadTableNames2();
    } catch(Exception e) {
    }
  }
  return res;
}
//---End function

//---Start function: CreateCompany
public boolean CreateCompany(String codazi, String desazi) {
  return CreateCompany(codazi, desazi, true);
}
public boolean CreateCompany(String codazi, String desazi, boolean addCompany) {
  boolean res;
  DBAdm dbadm = new DBAdm(m_Ctx, new SPXDCReaderFactory(m_Ctx.GetInstance()), "createcompany");
  res = dbadm.AdminDatabase(true, codazi, desazi, false, true, addCompany);
  if(res) {
    try {
      CPPooler.ReloadTableNames2();
    } catch(Exception e) {
    }
  }
  return res;
}
//---End function

//---Start function: DeleteCompany
public boolean DeleteCompany(String codazi) {
  boolean res;
  DBAdm dbadm = new DBAdm(m_Ctx, new SPXDCReaderFactory(m_Ctx.GetInstance()), "deletecompany");
  res = dbadm.DeleteAzi(codazi);
  if(res) {
    try {
      CPPooler.ReloadTableNames2();
    } catch(Exception e) {
    }
  }
  return res;
}
//---End function

//---Start function: GetPrimaryKey
public String GetPrimaryKey(String tablename) {
  String res="";
  XDCHolder xdc=new XDCHolder(CPLib.GetXDCFilenames(SPLib.GetClassesPath()),new SPXDCReaderFactory(m_Ctx.GetInstance()));
  XDCTable t=xdc.GetXDCTable(tablename);
  if(t!=null && t.GetIndex(0)!=null){
    res=t.GetIndex(0).name;
  }
  return res;
}
//---End function

//---Start function: RemakeIndex
public double RemakeIndex(String tablename) {
  double res=0;
  XDCHolder xdc=new XDCHolder(CPLib.GetXDCFilenames(SPLib.GetClassesPath(),m_Ctx.GetInstance()),new SPXDCReaderFactory(m_Ctx.GetInstance()));
  XDCTable t=xdc.GetXDCTable(tablename);
  if(t!=null && xdc!=null){
   DBAdm dbadm = new DBAdm(m_Ctx, new SPXDCReaderFactory(m_Ctx.GetInstance()), "dbadmin");
   dbadm.CompanyFill(); 
   res =  dbadm.CreateTableStruct(t, xdc, "index");
  }
  return res;
}
//---End function

//---Start attributes
//---End attributes
}
