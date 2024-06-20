import com.zucchetti.sitepainter.Library;
import static com.zucchetti.sitepainter.Library.Date;
import static com.zucchetti.sitepainter.Library.DateTimeToChar;
import static com.zucchetti.sitepainter.Library.NullDateTime;
import static com.zucchetti.sitepainter.Library.Val;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Utilities {

//---Start function: UTILITIES_LIBRARY_CODE
  CPContext m_Ctx;
  Caller m_Caller;
  private static AtomicBoolean m_OneSignal = new AtomicBoolean();
  public static Utilities Make(CPContext ctx) {
    Utilities l_Utilities = new Utilities();
    l_Utilities.m_Ctx = ctx;
    l_Utilities.m_Caller = CallerImpl.EMPTY_CALLER;
    return l_Utilities;
  }
  public static Utilities Make(CPContext ctx,Caller c) {
    Utilities l_Utilities = Make(ctx);
    l_Utilities.m_Caller = c;
    return l_Utilities;
  }
  int _AtSpace_(String p_cStr,int cnt) {
    int l=0;
    int pos=-1;
    while (l<cnt) {
      pos=p_cStr.indexOf(" ", pos+1) ;
      l++;
    }
    return pos+1;
  }
  public void SetTheme(String theme) {
    SetSkin(theme);
  }
  public String GetTheme() {
    return GetSkin();
  }
//---End function

//---Start function: AddToGroup
public void AddToGroup(double groupcode) {
  m_Ctx.GetAuthority().GetCurrentAssignement().AddToGroup(groupcode);
}
//---End function

//---Start function: AddToRole
public void AddToRole(String rolename) {
  m_Ctx.GetAuthority().GetCurrentAssignement().AddToRole(rolename);
}
//---End function

//---Start function: AskTableProg
public void AskTableProg(Caller obj, String dbserverlocator, String tablename, String autonumber) {
  CPSql l_sql=m_Ctx.GetSql();
  l_sql.AskTableProg(obj,
                     tablename,
                     autonumber,
                     m_Ctx.GetServer(dbserverlocator),
                     m_Ctx.GetCompany());
}
//---End function

//---Start function: BeginForceMasterDB
public void BeginForceMasterDB() {
  m_Ctx.GetSql().ForceMasterDB(true);
}
//---End function

//---Start function: BeginWritingIgnoringSlaveDB
public void BeginWritingIgnoringSlaveDB() {
  m_Ctx.GetSql().UpdateServerUsed(false);
}
//---End function

//---Start function: DateTimeBO
public java.sql.Timestamp DateTimeBO() {
  CPRegionalSettings rs = SPLib.GetRegionalSettings(m_Ctx);
  if (rs==null && m_Ctx instanceof SPContext && !"YES".equals(cp_login.m_cRegionalSettingsInterstitial) && m_OneSignal.compareAndSet(false,true))
    Library.error(new Error("I regional settings non sono disponibili in quanto cp_login.m_cRegionalSettingsInterstitial<>\"YES\""));
  if (rs == null)
    return NullDateTime();
  Long[] tzClientServerDateTime = rs.getTzClientServerDateTime();
  if (tzClientServerDateTime[0] == com.zucchetti.sitepainter.SPRegionalSettings.TIMEZONE_NOT_SET) {
    Error trackCallingSite = new Error("SPRegionalSettings.clientTimeZoneOffset non ancora impostato, la causa dell'eccezione è il punto in cui sono stati impostati l'ultima volta");
    trackCallingSite.initCause(rs.tzSet);
    Library.error(trackCallingSite);
    return NullDateTime();
  }
  //16:49
  Calendar now = Calendar.getInstance();
  //9:49 - 16:49 = -7 * 60 * 60 * 1000 (America centrale)
  long delta = tzClientServerDateTime[1];
  //...
  long millisecond = delta % 1000;
  now.add(Calendar.MILLISECOND, (int)millisecond );
  delta /= 1000;
  //0
  long second = delta % 60;
  now.add(Calendar.SECOND, (int)second );
  delta /= 60;
  //0
  long minute = delta % 60;
  now.add(Calendar.MINUTE, (int)minute );
  //-7
  delta /= 60;
  now.add(Calendar.HOUR, (int)delta );
  //6 * 60
  now.add(Calendar.MINUTE, tzClientServerDateTime[0].intValue() );
  //60*60*1000 (Italia)
  int localDelta = java.util.TimeZone.getDefault().getOffset(now.getTimeInMillis());
  now.add(Calendar.MILLISECOND, localDelta);
  //vedi CPLib.DateTime
  now.set(Calendar.MILLISECOND,0);
  return new java.sql.Timestamp(now.getTimeInMillis());
}
//---End function

//---Start function: DateTimeUI
public java.sql.Timestamp DateTimeUI() {
  CPRegionalSettings rs = SPLib.GetRegionalSettings(m_Ctx);
  if (rs==null && m_Ctx instanceof SPContext && !"YES".equals(cp_login.m_cRegionalSettingsInterstitial) && m_OneSignal.compareAndSet(false,true))
    Library.error(new Error("I regional settings non sono disponibili in quanto cp_login.m_cRegionalSettingsInterstitial<>\"YES\""));
  if (rs==null)
    return NullDateTime();
  Long[] tzClientServerDateTime = rs.getTzClientServerDateTime();
  if (tzClientServerDateTime[0] == com.zucchetti.sitepainter.SPRegionalSettings.TIMEZONE_NOT_SET) {
    Error trackCallingSite = new Error("SPRegionalSettings.clientTimeZoneOffset non ancora impostato, la causa dell'eccezione è il punto in cui sono stati impostati l'ultima volta");
    trackCallingSite.initCause(rs.tzSet);
    Library.error(trackCallingSite);
    return NullDateTime();
  }
  Calendar now = Calendar.getInstance();
  now.add(Calendar.MINUTE, -tzClientServerDateTime[0].intValue() );
  int localDelta = java.util.TimeZone.getDefault().getOffset(now.getTimeInMillis());
  now.add(Calendar.MILLISECOND, -localDelta);
  //vedi CPLib.DateTime
  now.set(Calendar.MILLISECOND,0);
  return new java.sql.Timestamp(now.getTimeInMillis());
}
//---End function

//---Start function: DefineConnection
public void DefineConnection(String connectionname, String serverurl) {
  m_Ctx.DefineConnection(connectionname,serverurl);
}
//---End function

//---Start function: EndForceMasterDB
public void EndForceMasterDB() {
  m_Ctx.GetSql().ForceMasterDB(false);
}
//---End function

//---Start function: EndWritingIgnoringSlaveDB
public void EndWritingIgnoringSlaveDB() {
  m_Ctx.GetSql().UpdateServerUsed(true);
}
//---End function

//---Start function: ForceTableProg
public void ForceTableProg(Caller obj, String dbserverlocator, String tablename, String autonumber) {
  CPSql l_sql=m_Ctx.GetSql();
  l_sql.RequireTransaction();
  l_sql.ForceTableProg(obj,
                       tablename,
                       autonumber,
                       m_Ctx.GetServer(dbserverlocator),
                       m_Ctx.GetCompany());
  l_sql.CompleteTransaction();
}
//---End function

//---Start function: FormatEx
public String FormatEx(String expression, double length, double decimals, String picture) {
  return CPLib.Format(expression, picture);
}
public String FormatEx(double expression, double length, double decimals, String picture) {
  return CPLib.Format(expression, picture);
}
public String FormatEx(java.sql.Date expression, double length, double decimals, String picture) {
  return CPLib.Format(expression, picture);
}
public String FormatEx(java.sql.Timestamp expression, double length, double decimals, String picture) {
  return CPLib.Format(expression, picture);
}
public String FormatEx(boolean expression, double length, double decimals, String picture) {
  return CPLib.Format(expression, picture);
}
//---End function

//---Start function: GetAutonumber
  public String GetAutonumber(String key, String workVar,int len) {
    CPSql l_sql=m_Ctx.GetSql();
    l_sql.RequireTransaction();
    String r=m_Ctx.NextTableProg(workVar,
                                 len,
                                 "",
                                 key,
                                 m_Ctx.GetServer("cpwarn",
                                                 true));
    l_sql.CompleteTransaction();
    return r;
  }
  public double GetAutonumber(String key, double workVar) {
    return GetAutonumber(key, workVar, 0);
  }
  public double GetAutonumber(String key, double workVar, int len) {
    CPSql l_sql=m_Ctx.GetSql();
    l_sql.RequireTransaction();
    double r=m_Ctx.NextTableProg(workVar,
                                 len,
                                 0,
                                 key,
                                 m_Ctx.GetServer("cpwarn",
                                                 true));
    l_sql.CompleteTransaction();
    return r;
  }
  public String GetAutonumber(String key, String workVar) {
    return GetAutonumber(key, workVar, 0);
  }
//---End function

//---Start function: GetCallerBO
public CallerBRImpl GetCallerBO() {
//implementare '<T extends CallerBRImpl> GetCallerBO()' espone l'utilizzatore ad eccezioni di cast giudicate poco intuitive
  if (m_Caller instanceof CallerBRImpl)
    return (CallerBRImpl)m_Caller;
  CallerWithObjsImpl wrapped = null;
  if (m_Caller instanceof CallerWithObjsImpl)
    wrapped = (CallerWithObjsImpl)m_Caller;
  if (wrapped != null && wrapped.m_Caller instanceof CallerBRImpl)
    return (CallerBRImpl)wrapped.m_Caller;
  return CallerBRImpl.EMPTY;
}
//---End function

//---Start function: GetCallerDate
public java.sql.Date GetCallerDate(String name) {
  return m_Caller.GetDate(name,"D",0,0);
}
//---End function

//---Start function: GetCallerDateTime
public java.sql.Timestamp GetCallerDateTime(String name) {
  return m_Caller.GetDateTime(name,"T",0,0);
}
//---End function

//---Start function: GetCallerLogic
public boolean GetCallerLogic(String name) {
  return m_Caller.GetLogic(name,"L",0,0);
}
//---End function

//---Start function: GetCallerNumber
public double GetCallerNumber(String name) {
  return m_Caller.GetNumber(name,"N",0,0);
}
//---End function

//---Start function: GetCallerString
public String GetCallerString(String name) {
  return m_Caller.GetString(name,"C",0,0);
}
//---End function

//---Start function: GetCompany
  public String GetCompany() {
    return m_Ctx.GetCompany();
  }
//---End function

//---Start function: GetFullName
public String GetFullName() {
  return m_Ctx.GetFullName();
}
//---End function

//---Start function: GetInstance
public String GetInstance() {
  return m_Ctx.GetInstance();
}
//---End function

//---Start function: GetLanguage
  public String GetLanguage() {
    return m_Ctx.GetLanguage();
  }
//---End function

//---Start function: GetSkin
  public String GetSkin() {
    return SPLib.GetSkin(m_Ctx);
  }
//---End function

//---Start function: GetSkinList
  public String GetSkinList() {
    return com.zucchetti.sitepainter.DefaultApplicationSkin.m_cInstalledApplicationSkin;
  }
//---End function

//---Start function: GetTimeout
  public double GetTimeout() {
    return m_Ctx.GetDuration()/(1000*60);
  }
//---End function

//---Start function: GetViewType
public double GetViewType() {
  double res = SPLib.GetViewType(m_Ctx);
  return res;
}
//---End function

//---Start function: IsAdministrator
public boolean IsAdministrator() {
  return IsInGroup(1);
}
//---End function

//---Start function: IsGuest
  public boolean IsGuest() {
    return m_Ctx.IsGuest();
  }
//---End function

//---Start function: IsInGroup
  public boolean IsInGroup(double p_nGroup) {
    return m_Ctx.GetGroupsList().indexOf(CPLib.ToSQL(p_nGroup,"N",6,0))!=-1;
  }
//---End function

//---Start function: IsInRole
public boolean IsInRole(String p_cRole) {
  return m_Ctx.GetAuthority().GetCurrentAssignement().IsInRole(CPLib.Lower(p_cRole));
}
//---End function

//---Start function: IsMobile
public boolean IsMobile() {
  boolean res = SPLib.IsMobile(m_Ctx);
  return res;
}
//---End function

//---Start function: IsUserReadingOnSlaveDB
public boolean IsUserReadingOnSlaveDB() {
  return m_Ctx.IsUserOnSecondaryDB();
}
//---End function

//---Start function: Logout
  public void Logout() throws Forward {
    if (CPLib.AL_APPLICATION.equals(CPLib.AfterloginPhase(m_Ctx))) {
      m_Ctx.SetDuration(0);
      throw CPLib.PROGRAMMATIC_LOGOUT;
    } else {
      if (!CPLib.AL_MODULE.equals(CPLib.AfterloginPhase(m_Ctx)))
        CPStdCounter.Error(new Error("Revise your application, Utilities.Logout should be called only from afterlogin routines.\nUse Utilities.SetTimeout(0) outside of afterlogin routines."));
      m_Ctx.DoLogout();
    }
  }
  public void Logout(String p_cName,double p_nValue) {
    CPContext.Logout(p_cName,p_nValue);
  }
  public void Logout(String p_cName,String p_cValue) {
    CPContext.Logout(p_cName,p_cValue);
  }
  public void Logout(String p_cName,java.sql.Date p_dValue) {
    CPContext.Logout(p_cName,p_dValue);
  }
  public void Logout(String p_cName,boolean p_lValue) {
    CPContext.Logout(p_cName,p_lValue);
  }
//---End function

//---Start function: NextTableProg
public void NextTableProg(Caller obj, String dbserverlocator, String tablename, String autonumber) {
  CPSql l_sql=m_Ctx.GetSql();
  l_sql.RequireTransaction();
  l_sql.NextTableProg(obj,
                      tablename,
                      autonumber,
                      m_Ctx.GetServer(dbserverlocator),
                      m_Ctx.GetCompany());
  l_sql.CompleteTransaction();
}
//---End function

//---Start function: PullFromGroup
public void PullFromGroup(double groupcode) {
  m_Ctx.GetAuthority().GetCurrentAssignement().PullFromGroup(groupcode);
}
//---End function

//---Start function: PullFromRole
public void PullFromRole(String rolename) {
  m_Ctx.GetAuthority().GetCurrentAssignement().PullFromRole(rolename);
}
//---End function

//---Start function: ResetAlternativeServer
public void ResetAlternativeServer(String queryname,String tablename) {
  if (!CPLib.Empty(queryname)) {
    VQRHolder l_holder=new VQRHolder(queryname, new SPVQRReaderFactory(m_Ctx.GetInstance()),CallerImpl.EMPTY_CALLER);
    l_holder.ql.SetContext(m_Ctx);
    java.util.Map<String,String> tables=l_holder.ql.GetTablesMap();
    for(java.util.Iterator it = tables.values().iterator(); it.hasNext(); ){	
      m_Ctx.RemoveRedefinedServer(
        l_holder.ql.GetTable((String)(it.next()))
      );
    }
  }
  if (!CPLib.Empty(tablename)) {
    m_Ctx.RemoveRedefinedServer(tablename);
  }
}
//---End function

//---Start function: ServerSetUITierSettings
public void ServerSetUITierSettings(String UITimeZone, String UIDateTime) {
  CPRegionalSettings rs = SPLib.GetRegionalSettings(m_Ctx);
  if (rs == null)
    rs = new CPRegionalSettings();
  SPLib.SetRegionalSettings(m_Ctx,
                            rs.decimalSeparator,
                            rs.thousandSeparator,
                            rs.datePattern,
                            rs.dateTimePattern,
                            UITimeZone,
                            UIDateTime,
                            DateTimeToChar(CPLib.DateTime()));
}
//---End function

//---Start function: ServerSetUnspecifiedPictureSettings
public String ServerSetUnspecifiedPictureSettings(String decimal_separator, String thousand_separator, String date_pattern, String datetime_pattern) {
  if (m_Ctx instanceof SPContext && "NO".equals(m_Ctx.GetGlobalObject("i_SendHttpRegionalSettings",null))) {
        HttpServletRequest[] l_Request={null};
        HttpServletResponse[] l_Response={null};
        class NoOp implements InvocationHandler {
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
          }
        }
        l_Request[0] = (HttpServletRequest)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{HttpServletRequest.class}, new NoOp());
        l_Response[0] = (HttpServletResponse)Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{HttpServletResponse.class}, new NoOp());
        Library.SetRequestResponse(l_Request, l_Response);
   try {return SPLib.SetUnspecifiedPictureSettings(m_Ctx, decimal_separator, thousand_separator, date_pattern, datetime_pattern);}
finally{Library.SetRequestResponse(l_Request, l_Response);}
  }
  return SPLib.SetUnspecifiedPictureSettings(m_Ctx, decimal_separator, thousand_separator, date_pattern, datetime_pattern);
}
//---End function

//---Start function: ServerTime
  public String ServerTime() {
    return CPLib.Time();
  }
//---End function

//---Start function: SetAlternativeServer
public void SetAlternativeServer(String queryname, String tablename, String serverurl) {
  if (!CPLib.Empty(queryname)) {
    VQRHolder l_holder=new VQRHolder(queryname, new SPVQRReaderFactory(m_Ctx.GetInstance()),CallerImpl.EMPTY_CALLER);
    l_holder.ql.SetContext(m_Ctx);
    java.util.Map<String,String> tables=l_holder.ql.GetTablesMap();
    for(java.util.Iterator it = tables.values().iterator(); it.hasNext(); ){	
			m_Ctx.RedefineServer(
        l_holder.ql.GetTable((String)(it.next())),
        serverurl
      );
		}
  }
  if(!CPLib.Empty(tablename)) {
    m_Ctx.RedefineServer(tablename,serverurl);
  }
}
//---End function

//---Start function: SetCompany
  public boolean SetCompany(String p_cCompany) {
    return m_Ctx.SetCompany(p_cCompany);
  }
//---End function

//---Start function: SetLanguage
  public void SetLanguage(String p_cLanguage) {
    m_Ctx.SetLanguage(p_cLanguage);
  }
//---End function

//---Start function: SetSkin
  public void SetSkin(String skin) {
    SPLib.SetSkin(m_Ctx, skin);
  }
//---End function

//---Start function: SetTimeout
  public void SetTimeout(double duration) {
    m_Ctx.SetDuration(((long)duration)*1000*60);
  }
//---End function

//---Start function: SetUserCode
public void SetUserCode(double p_nUserCode) {
  m_Ctx.SetUserCode(p_nUserCode);
}
//---End function

//---Start function: ShowHistoricalTodate
public java.sql.Date ShowHistoricalTodate(java.sql.Date cptodate) {
  if (CPSql.IsToDateCurrentlyValid(cptodate))
    return CPLib.NullDate();
  else
    return cptodate;
}
//---End function

//---Start function: SkipTableProg
public void SkipTableProg(Caller obj, String dbserverlocator, String tablename,String autonumber, double skip) {
  CPSql l_sql=m_Ctx.GetSql();
  l_sql.RequireTransaction();
  l_sql.SkipTableProg(obj,
                      tablename,
                      autonumber,
                      m_Ctx.GetServer(dbserverlocator),
                      m_Ctx.GetCompany(),
                      skip);
  l_sql.CompleteTransaction();
}
//---End function

//---Start function: ToHTML
public String ToHTML(String p_cString) {
  return SPLib.ToHTML(p_cString,"C",0,0);
}
//---End function

//---Start function: ToSQL
  public String ToSQL(boolean workingVariable,String type, int length, int decimals) {
    return CPLib.ToSQL(workingVariable, type, length, decimals);
  }
  public String ToSQL(String workingVariable,String type, int length, int decimals) {
    return CPLib.ToSQL(workingVariable, type, length, decimals);
  }
  public String ToSQL(double workingVariable,String type, int length, int decimals) {
    return CPLib.ToSQL(workingVariable, type, length, decimals);
  }
  public String ToSQL(java.sql.Date workingVariable,String type, int length, int decimals) {
    return CPLib.ToSQL(workingVariable, type, length, decimals);
  }
  public String ToSQL(java.sql.Timestamp workingVariable,String type, int length, int decimals) {
    return CPLib.ToSQL(workingVariable, type, length, decimals);
  }
//---End function

//---Start function: Translate
public String Translate(String p_cMessage, String p_cFirstParameter, String p_cSecondParameter) {
  String res = "";
  res=m_Ctx.Translate(p_cMessage,p_cFirstParameter,p_cSecondParameter);
  return res;
}
public String Translate(String p_cMessage, String p_cFirstParameter) {
  return Translate(p_cMessage,p_cFirstParameter,"%2");
}
public String Translate(String p_cMessage) {
  return Translate(p_cMessage,"%1","%2");
}
//---End function

//---Start function: UndefineConnection
public void UndefineConnection(String connectionname) {
  m_Ctx.UndefineConnection(connectionname);
}
//---End function

//---Start function: UserCode
  public double UserCode(){
    return m_Ctx.UserCode();
  }
//---End function

//---Start function: UserName
  public String UserName(){
    return m_Ctx.UserName();
  }
//---End function

//---Start function: Word
  public String Word(String str, int idx) {
    int p=_AtSpace_(str,idx),p1;
    if (idx==1) {
      if (p==0)
        return str;
      else
        return CPLib.Substr(str,1,p-1);
    } else {
      p1=_AtSpace_(str,idx-1);
      if (p==0)
        return CPLib.Substr(str,p1+1);
      else
        return CPLib.Substr(str,p1+1,p-p1);
    }
  }
//---End function

//---Start attributes
//---End attributes
}
