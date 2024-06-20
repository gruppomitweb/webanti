import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zucchetti.sitepainter.Library;
import com.zucchetti.sitepainter.EntityItem;
public class UserAdmin {

//---Start function: USERADMIN_LIBRARY_CODE
CPContext m_Ctx;
CPSql m_Sql;
String m_cServer, m_cSql, m_cLastMsgError;
private String strLog;
int m_nUpdatedRows;
boolean m_bError;
public static UserAdmin Make(CPContext ctx) {
  UserAdmin l_UserAdmin = new UserAdmin();
  l_UserAdmin.m_Ctx = ctx;
  return l_UserAdmin;
}
public static class PasswordTranslations extends SPServlet implements SPInvokable {
  protected void doAlways(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    //ispirato da SPServlet.GenTranslations
    CPContext context = SPLib.GetContext(SPLib.GetContextID(request),request );
    SPLib.SetMimeType(response,"text/javascript");
    PrintWriter out = response.getWriter();
    out.println("function(s,p1,p2){");
    out.println("var t = new Array();");
    String[ ][ ] Client = {{"ADMIN_PASSWORD_VERY_WEAK",context.Translate("ADMIN_PASSWORD_VERY_WEAK")},
                           {"ADMIN_PASSWORD_WEAK",context.Translate("ADMIN_PASSWORD_WEAK")},
                           {"ADMIN_PASSWORD_MEDIOCRE",context.Translate("ADMIN_PASSWORD_MEDIOCRE")},
                           {"ADMIN_PASSWORD_STRONG",context.Translate("ADMIN_PASSWORD_STRONG")},
                           {"ADMIN_PASSWORD_STRONGER",context.Translate("ADMIN_PASSWORD_STRONGER")},
                           {"ADMIN_PASSWORD_RATE",context.Translate("ADMIN_PASSWORD_RATE")},
                           {"ADMIN_PASSWORD_LENGTH",context.Translate("ADMIN_PASSWORD_POINTS_LENGTH")},
                           {"ADMIN_PASSWORD_LOWER",context.Translate("ADMIN_PASSWORD_LOWER")},
                           {"ADMIN_PASSWORD_UPPER",context.Translate("ADMIN_PASSWORD_UPPER")},
                           {"ADMIN_PASSWORD_DIGITS",context.Translate("ADMIN_PASSWORD_DIGITS")},
                           {"ADMIN_PASSWORD_SPECIAL",context.Translate("ADMIN_PASSWORD_SPECIAL")},
                           {"ADMIN_PASSWORD_UL",context.Translate("ADMIN_PASSWORD_UL")},
                           {"ADMIN_PASSWORD_LD",context.Translate("ADMIN_PASSWORD_LD")},
                           {"ADMIN_PASSWORD_LD_SPECIAL",context.Translate("ADMIN_PASSWORD_LD_SPECIAL")},
                           {"ADMIN_PASSWORD_NON_ASCII",context.Translate("ADMIN_PASSWORD_NON_ASCII")},
                           {"ADMIN_PASSWORD_PENALTY_LENGTH",context.Translate("ADMIN_PASSWORD_PENALTY_LENGTH")},
                           {"ADMIN_PASSWORD_OWASP_PENALTY_SPECIAL_CHARACTER",context.Translate("ADMIN_PASSWORD_OWASP_PENALTY_SPECIAL_CHARACTER")},
                           {"ADMIN_PASSWORD_OWASP_PENALTY_DIGIT",context.Translate("ADMIN_PASSWORD_OWASP_PENALTY_DIGIT")},
                           {"ADMIN_PASSWORD_OWASP_PENALTY_UPPERCASE",context.Translate("ADMIN_PASSWORD_OWASP_PENALTY_UPPERCASE")},
                           {"ADMIN_PASSWORD_OWASP_PENALTY_LOWERCASE",context.Translate("ADMIN_PASSWORD_OWASP_PENALTY_LOWERCASE")}
    };
    for (int i=0;i<Client.length ;i++) {
      out.println("t['"+Client[i ][ 0]+"']= "+SPLib.ToJSValue(Translate(context,Client,i),"C",0,0));
    }
    out.println("var r=t[s]");
    out.println("if(r==null)r=s");
    out.println("if(!Empty(p1)){");
    out.println("r=Strtran(r,'%1',p1)");
    out.println("if(!Empty(p2)){");
    out.println("r=Strtran(r,'%2',p2)}}");
    out.println("return r}");
  }
  private String Translate(CPContext context,String[ ][ ] Client,int i) {
    String key=Client[i ][ 0];
    String t=context.Translate(key,"%1","%2");
    if (t.equals(key))
      return Client[i ][ 1];
    else
      return t;
  }
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    //doAlways ridefinita in questa classe non chiama doProcess, quindi non deve essere implementato questo metodo
  }
  //alla prima istanziazione di questa classe viene associata l'ultima modifica, se cambiano le traduzioni
  //i browser hanno l'opportunita' di ricaricarle (vedi ad esempi SPServlet.TranslationFileModified)
  private final long firstUsed = System.currentTimeMillis();
  //si vuole mantenere in cache queste traduzioni
  protected long redefinedLastModified(HttpServletRequest request) {
    return firstUsed;
  }
}
private static class JSString {
  private static Map<String, Pattern> patterns = new HashMap<>();
  private final String str;
  public final int length;
  JSString(String s) {
    str = s;
    length = s.length();
  }
  boolean match(String p_cPattern) {
    Pattern pattern = patterns.get(p_cPattern);
    if (pattern == null) {
      pattern = Pattern.compile(p_cPattern);
      patterns.put(p_cPattern, pattern);
    }
    return pattern.matcher(str).find();
  }
}
//---End function

//---Start function: AddCompany
public void AddCompany(String codazi, String desazi) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpazi", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpazi")+" (codazi,desazi,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(codazi,"C",10,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(desazi,"C",30,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: AddGroup
public void AddGroup(double groupcode, String groupname, String grptype) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpgroups", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpgroups")+" (code,name,grptype,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(groupcode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(groupname,"C",DBAdm.CPGROUPS_NAME_LEN,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(grptype,"C",1,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: AddGroupOfGroups
public boolean AddGroupOfGroups(double groupcode, double groupbase) {
  boolean retval=true;
  m_Sql=m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer=m_Ctx.GetServer("cpgrpgrp", true);
  m_cSql="insert into "+m_Ctx.PhNameAdapter("cpgrpgrp")+" (groupcode,groupbase,cpccchk) values (";
  m_cSql=m_cSql+CPLib.ToSQL(groupcode,"N",6,0)+", ";
  m_cSql=m_cSql+CPLib.ToSQL(groupbase,"N",6,0)+", ";
  m_cSql=m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows=m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError=m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError=true;
    retval=false;
  }
  return retval;
}
//---End function

//---Start function: AddGroupToUser
public void AddGroupToUser(double usercode, double groupcode) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusrgrp", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpusrgrp")+" (groupcode,usercode,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(groupcode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(usercode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: AddLanguage
public void AddLanguage(String code, String name) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cplangs", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cplangs")+" (code,name,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(code,"C",3,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(name,"C",25,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: AddSSOMap
public void AddSSOMap(String ssoid, double userid) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpssomap", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpssomap")+" (ssoid,userid,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(ssoid,"C",100,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(userid,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: AddSecurityRecord
public void AddSecurityRecord(String progname, double groupcode, double usercode, double sec1, double sec2, double sec3, double sec4) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpprgsec", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpprgsec")+" (progname,grpcode,usrcode,sec1,sec2,sec3,sec4,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(progname,"C",50,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(groupcode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(usercode,"N",9,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(sec1,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(sec2,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(sec3,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(sec4,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  if (!m_bError) {
    ReloadSecurityForProgname(progname);
  }
}
//---End function

//---Start function: AddServer
public void AddServer(String servername, String serverdesc, String odbc, String databasetype) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer(""); //server di default
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cptsrvr")+" (ServerName,ServerDesc,ODBCDataSource,DatabaseType,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(servername,"C",10,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(serverdesc,"C",30,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(odbc,"C",200,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(databasetype,"C",60,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: AddUser
public void AddUser(double usercode, String username, String password, String language, String enabled) {
  CPResultSet Cursor_cpusers;
  boolean hasEnabledColumn, makeAdmin = false;
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusers", true);
  int dbType = CPSql.GetDataBaseType(m_cServer);
  String lang_field = (dbType==CPSql.m_nDBMaker ? "lang" : "language");
  if (!m_Ctx.HasAdministeredUsers()) {
    makeAdmin = true;
    if (!CheckGroupExists(1)) {
      AddGroup(1, "Administrators", "");
    }
  }
  //Controllo se esiste il campo enabled
  Cursor_cpusers = m_Sql.Query(m_cServer,"select enabled from "+m_Ctx.PhNameAdapter("cpusers")+" where 1=1");
  hasEnabledColumn = Cursor_cpusers.HasColumnNamed("enabled");
  Cursor_cpusers.Close();
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpusers")+" (code,name,passwd,";
  if (hasEnabledColumn) {
    m_cSql = m_cSql+"enabled,";
  }
  m_cSql = m_cSql+lang_field;
  m_cSql = m_cSql+",cpccchk";
  m_cSql = m_cSql+") values (";
  m_cSql = m_cSql+CPLib.ToSQL(usercode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(username,"C",50,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.CriptPwd(usercode,password),"C",20,0)+", ";
  if (hasEnabledColumn) {
    m_cSql = m_cSql+CPLib.ToSQL(enabled,"C",1,0)+", ";
  }
  m_cSql = m_cSql+CPLib.ToSQL(language,"C",3,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  if (makeAdmin) {
    AddGroupToUser(usercode, 1);
    m_Ctx.SetUserCode(usercode);
  }
}
//---End function

//---Start function: AddUserToGroup
public void AddUserToGroup(double groupcode, double usercode) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusrgrp", true);
  m_cSql = "insert into "+m_Ctx.PhNameAdapter("cpusrgrp")+" (groupcode,usercode,cpccchk) values (";
  m_cSql = m_cSql+CPLib.ToSQL(groupcode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(usercode,"N",6,0)+", ";
  m_cSql = m_cSql+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  if (CPLib.lt(m_nUpdatedRows,0)) {
    m_Sql.AbortTransaction();
  }
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: CanAdminDatabase
public boolean CanAdminDatabase() {
  boolean result = m_Ctx.CanBecomeSuperUser();
  if (!result) {
    m_Sql = m_Ctx.GetSql();
    m_cServer = m_Ctx.GetServer("", true);
    m_Sql.Update(m_cServer , "drop table "+m_Ctx.PhNameAdapter("cpchkadmrght"), false, false, false, false, false);
    result = m_Sql.Update(m_cServer, "create table "+m_Ctx.PhNameAdapter("cpchkadmrght")+" (codice Char(1))", true, false, false, false, false)!= -1;
    m_Sql.Update(m_cServer , "drop table "+m_Ctx.PhNameAdapter("cpchkadmrght"), false, false, false, false, false);
  }
  return result;
}
//---End function

//---Start function: ChangePassword
public boolean ChangePassword(double usercode, String oldpassword, String newpassword) {
  boolean success = true;
  CPResultSet Cursor_cpusers;
  String currentPassword = "";
  m_cServer = m_Ctx.GetServer("cpusers", true);
  m_Sql = m_Ctx.GetSql();
  Cursor_cpusers = m_Sql.Query(m_cServer,"select passwd from "+m_Ctx.PhNameAdapter("cpusers")+" where code="+CPLib.ToSQL(usercode,"N",6,0));
  if ( ! (Cursor_cpusers.Eof())) {
    currentPassword = Cursor_cpusers.GetString("passwd");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cpusers.Close();
  success = CPLib.CheckPwd(usercode,oldpassword,currentPassword);
  if (success){
    m_Sql.RequireTransaction();
    m_cSql = "Update "+m_Ctx.PhNameAdapter("cpusers")+" set ";
    m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(CPLib.CriptPwd(usercode,newpassword),"C",20,0)+" where ";
    m_cSql = m_cSql+"code = "+CPLib.ToSQL(usercode,"N",6,0);
    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
  }
  return success;
}
//---End function

//---Start function: CheckCompanyExists
public boolean CheckCompanyExists(String codazi) {
  CPResultSet Cursor_cpazi;
  String codeExist = "";
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("cpazi", true);
  Cursor_cpazi = m_Sql.Query(m_cServer,"select codazi from "+m_Ctx.PhNameAdapter("cpazi")+" where codazi="+CPLib.ToSQL(codazi,"C",10,0));
  if ( ! (Cursor_cpazi.Eof())) {
    codeExist = Cursor_cpazi.GetString("codazi");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cpazi.Close();
  return !CPLib.Empty(codeExist);
}
//---End function

//---Start function: CheckGroupExists
public boolean CheckGroupExists(double groupcode) {
  CPResultSet Cursor_cpgroups;
  double codeExist = -1000;
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("cpgroups", true);
  Cursor_cpgroups = m_Sql.Query(m_cServer,"select code from "+m_Ctx.PhNameAdapter("cpgroups")+" where code="+CPLib.ToSQL(groupcode,"N",6,0));
  if ( ! (Cursor_cpgroups.Eof())) {
    codeExist = Cursor_cpgroups.GetDouble("code");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cpgroups.Close();
  return CPLib.ne(codeExist, -1000);
}
//---End function

//---Start function: CheckLanguageExists
public boolean CheckLanguageExists(String code) {
  CPResultSet Cursor_cplangs;
  String codeExist = "";
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("cplangs",true);
  Cursor_cplangs = m_Sql.Query(m_cServer,"select code from "+m_Ctx.PhNameAdapter("cplangs")+" where code="+CPLib.ToSQL(code,"C",3,0));
  if ( ! (Cursor_cplangs.Eof())) {
    codeExist = Cursor_cplangs.GetString("code");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cplangs.Close();
  return !CPLib.Empty(codeExist);
}
//---End function

//---Start function: CheckPasswordStrength
public boolean CheckPasswordStrength(String password, double strength) {
  return GetPasswordRating(password)>=strength;
}
//---End function

//---Start function: CheckSSPMapExists
public boolean CheckSSPMapExists(String ssoid) {
  CPResultSet Cursor_cpssomap;
  String codeExist = "";
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("cpssomap",true);
  Cursor_cpssomap = m_Sql.Query(m_cServer,"select ssoid from "+m_Ctx.PhNameAdapter("cpssomap")+" where ssoid="+CPLib.ToSQL(ssoid,"C",100,0));
  if ( ! (Cursor_cpssomap.Eof())) {
    codeExist = Cursor_cpssomap.GetString("ssoid");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cpssomap.Close();
  return !CPLib.Empty(codeExist);
}
//---End function

//---Start function: CheckServerExists
public boolean CheckServerExists(String ServerName) {
  CPResultSet Cursor_cptsrvr;
  String codeExist = "";
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("");
  Cursor_cptsrvr = m_Sql.Query(m_cServer,"select ServerName from "+m_Ctx.PhNameAdapter("cptsrvr")+" where ServerName="+CPLib.ToSQL(ServerName,"C",10,0));
  if ( ! (Cursor_cptsrvr.Eof())) {
    codeExist = Cursor_cptsrvr.GetString("ServerName");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cptsrvr.Close();
  return !CPLib.Empty(codeExist);
}
//---End function

//---Start function: CheckUserExists
public boolean CheckUserExists(double usercode) {
  CPResultSet Cursor_cpusers;
  double codeExist = -1000;
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("cpusers", true);
  Cursor_cpusers = m_Sql.Query(m_cServer,"select code from "+m_Ctx.PhNameAdapter("cpusers")+" where code="+CPLib.ToSQL(usercode,"N",6,0));
  if ( ! (Cursor_cpusers.Eof())) {
    codeExist = Cursor_cpusers.GetDouble("code");
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
  }
  Cursor_cpusers.Close();
  return CPLib.ne(codeExist, -1000);
}
//---End function

//---Start function: FirstLogin
public void FirstLogin(double usercode) {
  if(!m_Ctx.HasAdministeredUsers()) {
    if(!CheckGroupExists(1)){
      AddGroup(1,"Administrators","");
    }
    AddGroupToUser(usercode,1);
    CPSecurity.GetAuthentication().RefreshAuthentication();
    m_Ctx.RescanUserSecurity();
    m_Ctx.SetUserCode(usercode);
  }
}
//---End function

//---Start function: GetLanguageName
public String GetLanguageName(String code) {
  CPResultSet cursor;
  String result = "";
  m_cServer = m_Ctx.GetServer("cplangs", true);
  m_Sql = m_Ctx.GetSql();
  int dbType = CPSql.GetDataBaseType(m_cServer);
  cursor = m_Sql.Query(m_cServer,"select name from "+m_Ctx.PhNameAdapter("cplangs")+" where code="+CPLib.ToSQL(code,"C",3,0));
  if (!cursor.Eof()) {
    result = cursor.GetString("name");
  }
  cursor.Close();
  return result;
}
//---End function

//---Start function: GetNextCode
public double GetNextCode(String tablename) {
  String tblname=null;
  if (CPLib.eq(tablename,"users")) {
    tblname="cpusers";
  } else if (CPLib.eq(tablename,"groups")){
    tblname="cpgroups";
  }
  CPResultSet cursor=null;
  double next_val = 1;
  m_Sql = m_Ctx.GetSql();
  if (tblname!=null) {
    try {
      m_cServer = m_Ctx.GetServer(tblname, true);
      cursor = m_Sql.Query(m_cServer,"select max(code) as maxcode from "+m_Ctx.PhNameAdapter(tblname));
      if ( !cursor.Eof() && !cursor.IsNull("maxcode") ) {
        next_val = cursor.GetDouble("maxcode")+1;
    }
    } finally {
      if (cursor!=null)
    cursor.Close();
    }
  }
  return next_val;
}
//---End function

//---Start function: GetPasswordRating
public double GetPasswordRating(String password) {
  JSString passwd = new JSString(password);
  int intScore = 0;
  String strVerdict= CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_VERY_WEAK");
  strLog = "";
  String causeLog = "";
  int causePoints  = 0;
  int maxReachable = 0;
  final int OWASP_CRITERIA_LENGTH = 8;
  final int OWASP_CRITERIA_PENALTY = 5;
  final String OWASP_CRITERIA_SPECIAL_CHARACTERS = Pattern.quote(" !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"); // https://owasp.org/www-community/password-special-characters
  boolean fits_OWASP_CRITERIA_LENGTH = false;
  boolean fits_OWASP_CRITERIA_CHARACTER_UPPERCASE = false;
  boolean fits_OWASP_CRITERIA_CHARACTER_LOWERCASE = false;
  boolean fits_OWASP_CRITERIA_CHARACTER_DIGIT = false;
  boolean fits_OWASP_CRITERIA_CHARACTER_SPECIAL = false;
  int fits_OWASP_CRITERIA_CHARACTER_count = 0;
  //score
  // PASSWORD LENGTH
  if (passwd.length>7 && passwd.length<16)// length between 8 and 15
  {
    causePoints  = 12;
    causeLog      = CPLib.FormatMsg(m_Ctx, "ADMIN_PASSWORD_LENGTH", causePoints, passwd.length) + "\n";
    fits_OWASP_CRITERIA_LENGTH = true;
  }
  else if (passwd.length>15)                    // length 16 or more
  {
    causePoints   = 18;
    causeLog      = CPLib.FormatMsg(m_Ctx, "ADMIN_PASSWORD_LENGTH", causePoints, passwd.length) + "\n";
    fits_OWASP_CRITERIA_LENGTH = true;
  }
  intScore     += causePoints;
  maxReachable += 18;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("[a-z]"))                              // at least one lower case letter
  {
    causePoints = 1;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_LOWER",causePoints) + "\n";
    fits_OWASP_CRITERIA_CHARACTER_LOWERCASE = true;
    fits_OWASP_CRITERIA_CHARACTER_count++;
  }
  intScore     += causePoints;
  maxReachable += 1;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("[A-Z]"))                              // at least one upper case letter
  {
    causePoints = 5;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_UPPER",causePoints) + "\n";
    fits_OWASP_CRITERIA_CHARACTER_UPPERCASE = true;
    fits_OWASP_CRITERIA_CHARACTER_count++;
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  // NUMBERS
  if (passwd.match("\\d"))                                 // at least one number
  {
    causePoints = 5;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_DIGITS",causePoints,1) + "\n";
    fits_OWASP_CRITERIA_CHARACTER_DIGIT = true;
    fits_OWASP_CRITERIA_CHARACTER_count++;
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=\\d.*\\d.*\\d)"))             // at least three numbers
  {
    causePoints = 5;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_DIGITS",causePoints,3) + "\n";
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  // SPECIAL CHAR
  if (passwd.match("[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "]"))            // at least one special character
  {
    causePoints = 5;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_SPECIAL",causePoints,1) + "\n";
    if (passwd.match("[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "]"))
    {
      fits_OWASP_CRITERIA_CHARACTER_SPECIAL = true;
      fits_OWASP_CRITERIA_CHARACTER_count++;
    }
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "].*[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "])"))// at least two special characters https://stackoverflow.com/a/4670743/7991344
  {
    causePoints = 5;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_SPECIAL",causePoints,2) + "\n";
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  // COMBOS
  if (passwd.match("(?=[A-Z].*[a-z])|(?=[a-z].*[A-Z])"))        // both upper and lower case
  {
    causePoints = 2;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_UL",causePoints) + "\n";
  }
  intScore     += causePoints;
  maxReachable += 2;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=.*[A-Za-z])(?=.*\\d)")) // both letters and numbers
  {
    causePoints = 2;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_LD",causePoints) + "\n";
  }
  intScore     += causePoints;
  maxReachable += 2;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=[^\\x00-\\x7F])")) // at least a non ASCII character
  {
    causePoints = 5;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_NON_ASCII",causePoints) + "\n";
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=.*[A-Za-z])(?=.*\\d)(?=.*[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "])")) // letters, numbers, and special characters
  {
    causePoints = 2;
    causeLog    = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_LD_SPECIAL",causePoints) + "\n";
  }
  intScore     += causePoints;
  maxReachable += 2;
  strLog       += causeLog;
  
  // penalizzazione per lunghezza insicura
  if (!fits_OWASP_CRITERIA_LENGTH)
  {
    strLog += CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_PENALTY_LENGTH", -6*OWASP_CRITERIA_PENALTY, OWASP_CRITERIA_LENGTH) + "\n";
    intScore = Math.max(0, intScore-6*OWASP_CRITERIA_PENALTY);
  }
   // penalizzazione per mancato soddisfacimento di almeno 3 regole sul tipo di carattere:
  if (fits_OWASP_CRITERIA_CHARACTER_count<3)
  {
    if (!fits_OWASP_CRITERIA_CHARACTER_SPECIAL)
    {
      strLog += CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_OWASP_PENALTY_SPECIAL_CHARACTER", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
    if (!fits_OWASP_CRITERIA_CHARACTER_DIGIT)
    {
      strLog += CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_OWASP_PENALTY_DIGIT", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
    if (!fits_OWASP_CRITERIA_CHARACTER_UPPERCASE)
    {
      strLog += CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_OWASP_PENALTY_UPPERCASE", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
    if (!fits_OWASP_CRITERIA_CHARACTER_LOWERCASE)
    {
      strLog += CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_OWASP_PENALTY_LOWERCASE", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
  }
  //verdict
  if(intScore < 16)
  {
     strVerdict = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_VERY_WEAK");
  }
  else if (intScore > 15 && intScore < 25)
  {
     strVerdict = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_WEAK");
  }
  else if (intScore > 24 && intScore < 35)
  {
     strVerdict = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_MEDIOCRE");
  }
  else if (intScore > 34 && intScore < 45)
  {
     strVerdict = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_STRONG");
  }
  else
  {
     strVerdict = CPLib.FormatMsg(m_Ctx,"ADMIN_PASSWORD_STRONGER");
  }
  // if(arguments.length>1){
    // arguments[1].log=strLog;
    // arguments[1].rating=arguments[1].score=intScore;
    // arguments[1].verdict=strVerdict;
    // arguments[1].maxReachable=maxReachable;
  // }
	return intScore;
}
//---End function

//---Start function: GetPasswordRatingExplaination
public String GetPasswordRatingExplaination(String password) {
  GetPasswordRating(password);
  return strLog;
}
//---End function

//---Start function: GetPasswordRatingMaxReachable
public double GetPasswordRatingMaxReachable() {
  double res = 50;
  return res;
}
//---End function

//---Start function: GetPasswordVerdict
public String GetPasswordVerdict(String password) {
  String res = "";
  return res;
}
//---End function

//---Start function: GetRoleStringForEntity
public String GetRoleStringForEntity(String entityName) {
  String res = "";
  String[] roles;
  if (entityName.startsWith("ps/")) {
    String[][][] l_PSFiles = new String[1][][];
    javax.servlet.http.HttpServletRequest[] req = {null};
    javax.servlet.http.HttpServletResponse[] resp = {null};
    Library.GetRequestResponse(req, resp);
    com.zucchetti.sitepainter.PSJSPRoleResolver l_RoleResolver = new SPVMNReaderFactory(req[0],resp[0]);
    roles = m_Ctx.GetAuthority().GetPSFileRoles(CPLib.Substr(entityName, 4), l_RoleResolver, l_PSFiles);
  } else if (entityName.startsWith("vrp/"))
    roles = VMNMenuLoader.GetVrpRoles(CPLib.Substr(entityName, 5),m_Ctx.GetInstance());
  else if (entityName.startsWith("svrp/"))
    roles = VMNMenuLoader.GetSvrpRoles(CPLib.Substr(entityName, 6),m_Ctx.GetInstance());
  else if (entityName.indexOf(".")>-1) {
    String[][] l_ZonesRole = null;
    double l_nZoneSeparator = Library.At(".",entityName);
    String l_cEntity = Library.Left(entityName,l_nZoneSeparator-1);
    String l_cZoneName = Library.Substr(entityName,l_nZoneSeparator+1);
    l_ZonesRole = EntityItem.getSecuredItems(l_cEntity);
    java.util.ArrayList<String> l_Roles = new java.util.ArrayList<String>();
    for (String[] l_ZoneRole : l_ZonesRole) if (l_ZoneRole[0].equals(l_cZoneName)) {
      l_Roles.add(l_ZoneRole[1]);
    }
    roles = l_Roles.toArray(new String[]{});
  } else
    roles = com.zucchetti.sitepainter.EntityItem.getRolesForEntity(entityName);
  String sep = "";
  if (roles!=null) {
    for (String r : roles) {
      res += sep+r;
      sep = ", ";
    }
  }
  return res;
}
//---End function

//---Start function: GetUserData
public String GetUserData(double usercode, String info) {
  CPResultSet cursor;
  String result = "";
  m_cServer = m_Ctx.GetServer("cpusers", true);
  m_Sql = m_Ctx.GetSql();
  int dbType = CPSql.GetDataBaseType(m_cServer);
  if(CPLib.eq(info,"language")) {
    String lang_field = (dbType==CPSql.m_nDBMaker ? "lang" : "language");
    cursor = m_Sql.Query(m_cServer,"select "+lang_field+" from "+m_Ctx.PhNameAdapter("cpusers")+" where code="+CPLib.ToSQL(usercode,"N",6,0));
    if (!cursor.Eof()) {
      result = CPLib.Upper(cursor.GetString(lang_field));
    }
    cursor.Close();
  }
  else if (CPLib.eq(info,"enabled")) {
    cursor = m_Sql.Query(m_cServer,"select enabled from "+m_Ctx.PhNameAdapter("cpusers")+" where code="+CPLib.ToSQL(usercode,"N",6,0));
    if (cursor.HasColumnNamed("enabled")) {
      if (!cursor.Eof()) {
        result = cursor.GetString("enabled");
      }
    }
    else {
      result = "U";
    }
    cursor.Close();
  }
  return result;
}
//---End function

//---Start function: HasAdminRights
public boolean HasAdminRights() {
  return !m_Ctx.HasAdministeredUsers() || (m_Ctx.IsLogged() && CPLib.IsAdministrator(m_Ctx));
}
//---End function

//---Start function: HasAdministratedUsers
public boolean HasAdministratedUsers() {
  return m_Ctx.HasAdministeredUsers();
}
//---End function

//---Start function: HasCode
public boolean HasCode(String tablename, double curr_code) {
  CPResultSet cursor;
  m_Sql = m_Ctx.GetSql();
  boolean found = false;
  if (CPLib.eq(tablename,"users")) {
    m_cServer = m_Ctx.GetServer("cpusers", true);
    cursor = m_Sql.Query(m_cServer,"select code from "+m_Ctx.PhNameAdapter("cpusers")+" where code = "+curr_code);
    if ( ! (cursor.Eof())) {
      if (curr_code == cursor.GetDouble("code")) found = true;
    }
    cursor.Close();
  } else if (CPLib.eq(tablename,"groups")){
    m_cServer = m_Ctx.GetServer("cpgroups", true);
    cursor = m_Sql.Query(m_cServer,"select code from "+m_Ctx.PhNameAdapter("cpgroups")+" where code = "+curr_code);
    if ( ! (cursor.Eof())) {
      if (curr_code == cursor.GetDouble("code")) found = true;
    }
    cursor.Close();
  }
  return found;
}
//---End function

//---Start function: ReloadSecurityForProgname
public boolean ReloadSecurityForProgname(String progname) {
  boolean result=false;
  if (!CPLib.Empty(progname)) { //Svalido tutte le sicurezze
    m_Ctx.InvalidateUserAuthorization();
    CPSecurity.AuthorizationMethod.InvalidateAuthorization(progname);
    result=true;
  }
  return result;
}
//---End function

//---Start function: RemoveFromSecurity
public void RemoveFromSecurity(String progname, double groupcode, double usercode) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpprgsec", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpprgsec")+" where ";
  m_cSql = m_cSql+"progname = "+CPLib.ToSQL(progname,"C",50,0);
  m_cSql = m_cSql+" and grpcode = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_cSql = m_cSql+" and usrcode = "+CPLib.ToSQL(usercode,"N",9,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  if (!m_bError) {
    ReloadSecurityForProgname(progname);
  }
}
//---End function

//---Start function: RemoveGroup
public void RemoveGroup(double groupcode) {
  m_Sql = m_Ctx.GetSql();
  m_cServer = m_Ctx.GetServer("cpgroups", true);
  // * --- Delete from cpgroups
  m_Sql.RequireTransaction();
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpgroups")+" where code = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  // * --- Delete from cpusrgrp
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusrgrp", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpusrgrp")+" where groupcode = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  // * --- Delete from cpprgsec
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpprgsec", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpprgsec")+" where grpcode = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: RemoveGroupFromUser
public void RemoveGroupFromUser(double groupcode, double usercode) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusrgrp", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpusrgrp")+" where groupcode = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_cSql = m_cSql+" and usercode = "+CPLib.ToSQL(usercode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: RemoveGroupOfGroups
public boolean RemoveGroupOfGroups(double groupcode, double groupbase) {
  boolean retval=true;
  m_Sql=m_Ctx.GetSql();
  m_cServer=m_Ctx.GetServer("cpgrpgrp", true);
  m_Sql.RequireTransaction();
  m_cSql="delete from "+m_Ctx.PhNameAdapter("cpgrpgrp")+" where groupcode = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_cSql=m_cSql+" and groupbase = "+CPLib.ToSQL(groupbase,"N",6,0);
  m_nUpdatedRows=m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError=m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError=true;
    retval=false;
  }
  return retval;
}
//---End function

//---Start function: RemoveLanguage
public void RemoveLanguage(String code) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cplangs", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cplangs")+" where code = "+CPLib.ToSQL(code,"C",3,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: RemoveSSOMap
public void RemoveSSOMap(String ssoid) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpssomap", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpssomap")+" where ssoid = "+CPLib.ToSQL(ssoid,"C",100,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: RemoveSecurity
public void RemoveSecurity(String progname) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpprgsec", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpprgsec")+" where progname = "+CPLib.ToSQL(progname,"C",50,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  if (!m_bError) {
    ReloadSecurityForProgname(progname);
  }
}
//---End function

//---Start function: RemoveServer
public void RemoveServer(String servername) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("");
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cptsrvr")+" where ServerName = "+CPLib.ToSQL(servername,"C",10,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: RemoveUser
public void RemoveUser(double usercode) {
  m_Sql = m_Ctx.GetSql();
  // * --- Delete from cpusrgrp
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusrgrp", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpusrgrp")+" where usercode = "+CPLib.ToSQL(usercode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  // * --- Delete from cpprgsec
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpprgsec", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpprgsec")+" where usrcode = "+CPLib.ToSQL(usercode,"N",9,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  // * --- Delete from cpssomap
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpssomap", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpssomap")+" where userid = "+CPLib.ToSQL(usercode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  // * --- Delete from cpusers
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusers", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpusers")+" where code = "+CPLib.ToSQL(usercode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
  if(usercode==m_Ctx.UserCode()) {
    m_Ctx.DoLogout();
    CPSecurity.GetAuthentication().RefreshAuthentication();
    m_Ctx.RescanUserSecurity();
  }
}
//---End function

//---Start function: RemoveUserFromGroup
public void RemoveUserFromGroup(double groupcode, double usercode) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpusrgrp", true);
  m_cSql = "delete from "+m_Ctx.PhNameAdapter("cpusrgrp")+" where groupcode = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_cSql = m_cSql+" and usercode = "+CPLib.ToSQL(usercode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: SaveCompany
public void SaveCompany(String codazi, String desazi) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpazi", true);
  m_cSql = "Update "+m_Ctx.PhNameAdapter("cpazi")+" set ";
  m_cSql = m_cSql+"desazi = "+CPLib.ToSQL(desazi,"C",30,0)+" where ";
  m_cSql = m_cSql+"codazi= "+CPLib.ToSQL(codazi,"C",10,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: SaveGroup
public void SaveGroup(double groupcode, String groupname, String grptype) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpgroups", true);
  m_cSql = "Update "+m_Ctx.PhNameAdapter("cpgroups")+" set ";
  m_cSql = m_cSql+"name = "+CPLib.ToSQL(groupname,"C",20,0)+", ";
  m_cSql = m_cSql+"grptype = "+CPLib.ToSQL(grptype,"C",1,0)+" where ";
  m_cSql = m_cSql+"code = "+CPLib.ToSQL(groupcode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: SaveLanguage
public void SaveLanguage(String code, String name) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cplangs", true);
  m_cSql = "Update "+m_Ctx.PhNameAdapter("cplangs")+" set ";
  m_cSql = m_cSql+"name = "+CPLib.ToSQL(name,"C",25,0)+" where ";
  m_cSql = m_cSql+"code = "+CPLib.ToSQL(code,"C",3,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: SaveSSOMap
public void SaveSSOMap(String ssoid, double userid) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("cpssomap", true);
  m_cSql = "Update "+m_Ctx.PhNameAdapter("cpssomap")+" set ";
  m_cSql = m_cSql+"userid = "+CPLib.ToSQL(userid,"N",6,0)+" where ";
  m_cSql = m_cSql+"ssoid = "+CPLib.ToSQL(ssoid,"C",100,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: SaveServer
public void SaveServer(String servername, String serverdesc, String odbc, String databasetype) {
  m_Sql = m_Ctx.GetSql();
  m_Sql.RequireTransaction();
  m_cServer = m_Ctx.GetServer("");
  m_cSql = "Update "+m_Ctx.PhNameAdapter("cptsrvr")+" set ";
  m_cSql = m_cSql+"ServerDesc = "+CPLib.ToSQL(serverdesc,"C",30,0)+", ";
  m_cSql = m_cSql+"ODBCDataSource = "+CPLib.ToSQL(odbc,"C",200,0)+", ";
  m_cSql = m_cSql+"DatabaseType = "+CPLib.ToSQL(databasetype,"C",60,0)+" where ";
  m_cSql = m_cSql+"ServerName = "+CPLib.ToSQL(servername,"C",10,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start function: SaveUser
public void SaveUser(double usercode, String username, String password, String language, String enabled) {
  CPResultSet Cursor_cpusers;
  String currentPassword = "";
  boolean hasEnabledColumn;
  m_cServer = m_Ctx.GetServer("cpusers", true);
  m_Sql = m_Ctx.GetSql();
  int dbType = CPSql.GetDataBaseType(m_cServer);
  String lang_field = (dbType==CPSql.m_nDBMaker ? "lang" : "language");
  Cursor_cpusers = m_Sql.Query(m_cServer,"select passwd from "+m_Ctx.PhNameAdapter("cpusers")+" where code="+CPLib.ToSQL(usercode,"N",6,0));
  if ( ! (Cursor_cpusers.Eof())) {
    currentPassword = Cursor_cpusers.GetString("passwd");
    Cursor_cpusers.Close();
  } else {
    // Error: no record found!
    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
    Cursor_cpusers.Close();
  }
  if (CPLib.ne(password,currentPassword)) {
    password = CPLib.CriptPwd(usercode,password);
  }
  //Controllo se esiste il campo enabled
  Cursor_cpusers = m_Sql.Query(m_cServer,"select enabled from "+m_Ctx.PhNameAdapter("cpusers")+" where 1=1");
  hasEnabledColumn = Cursor_cpusers.HasColumnNamed("enabled");
  Cursor_cpusers.Close();
  m_Sql.RequireTransaction();
  m_cSql = "Update "+m_Ctx.PhNameAdapter("cpusers")+" set ";
  m_cSql = m_cSql+"name = "+CPLib.ToSQL(username,"C",50,0)+", ";
  m_cSql = m_cSql+lang_field+" = "+CPLib.ToSQL(language,"C",3,0)+", ";
  if (hasEnabledColumn) {
    m_cSql = m_cSql+"enabled = "+CPLib.ToSQL(enabled,"C",1,0)+", ";
  }
  m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(password,"C",20,0)+" where ";
  m_cSql = m_cSql+"code = "+CPLib.ToSQL(usercode,"N",6,0);
  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
  m_Sql.CompleteTransaction();
  m_cLastMsgError = m_Sql.TransactionErrorMessage();
  if (CPLib.ne(m_cLastMsgError,"")) {
    m_bError = true;
  }
}
//---End function

//---Start attributes
//---End attributes
}
