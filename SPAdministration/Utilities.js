(function() {//MakeUtilities
function _AtSpace_(p_cStr,cnt) {
  var l=0
  var pos=-1;
  while (l<cnt) {
    pos=p_cStr.indexOf(" ", pos+1) ;
    l++;
  }
  return pos+1;
}
function utilities_Make(p_ctx,p_caller){
if(p_caller==null){
if(parent!=null)p_caller=parent;
if(opener!=null)p_caller=opener;
}
this.m_Caller=p_caller
this.GetTheme=function(){return m_cThemePath}
this.SetTheme=function(){}
return this
}


//---Start function: AddToGroup
function utilities_AddToGroup(groupcode) {
}
//---End function

//---Start function: AddToRole
function utilities_AddToRole(rolename) {
}
//---End function

//---Start function: AskTableProg
function utilities_AskTableProg() {
}
//---End function

//---Start function: BeginForceMasterDB
function utilities_BeginForceMasterDB() {
}
//---End function

//---Start function: BeginWritingIgnoringSlaveDB
function utilities_BeginWritingIgnoringSlaveDB() {
}
//---End function

//---Start function: DateTimeBO
function utilities_DateTimeBO() {
  var serverTZ = DateTime.tzData()
  if (serverTZ.lenght<2)
    return NullDateTime()
  return new Date(DateTime().getTime() + Val(serverTZ[1]))
}
//---End function

//---Start function: DateTimeUI
function utilities_DateTimeUI() {
  var delta = DateTime.tzData()
  if (delta.lenght<1)
    return NullDateTime()
  return new Date(DateTime().getTime() + Val(delta[0]) - new Date().getTimezoneOffset() * 60 * 1000)
}
//---End function

//---Start function: DefineConnection
function utilities_DefineConnection(connectionname, serverurl) {
}
//---End function

//---Start function: EndForceMasterDB
function utilities_EndForceMasterDB() {
}
//---End function

//---Start function: EndWritingIgnoringSlaveDB
function utilities_EndWritingIgnoringSlaveDB() {
}
//---End function

//---Start function: ForceTableProg
function utilities_ForceTableProg(obj, dbserverlocator, tablename, autonumber) {
  var res = "";
  return res;
}
//---End function

//---Start function: FormatEx
function utilities_FormatEx(expression, length, decimals, picture) {
  return Format(expression, length, decimals, picture);
}
//---End function

//---Start function: GetAutonumber
function utilities_GetAutonumber(key, workVar, len, p_MethodCallback) {
  if ('SPOfflineLib' in window) {
    CPPooler.connect(SPOfflineLib.getDataBaseName(), null, function () {
      CPPooler.RequireTransaction(next1);
    } );
    function next1() {
      CPSql.NextTableProgWithoutObj(workVar, len, (IsA(workVar, 'C') ? "": 0 ), key, next2);
      function next2(r) {
        CPPooler.CompleteTransaction(next3);
        function next3() {
          p_MethodCallback(r);
        }
      }
    }
  }
  //online not implemented
}
//---End function

//---Start function: GetCallerBO
function utilities_GetCallerBO() {
  if (this.m_Caller == window)
    return window
  else
    return new Caller()
}
//---End function

//---Start function: GetCallerDate
function utilities_GetCallerDate(name) {
return this.GetCallerDateTime(name)
}
//---End function

//---Start function: GetCallerDateTime
function utilities_GetCallerDateTime(name) {
var o
if(this.m_Caller!=null)o=this.m_Caller['w_'+name];
if(o==null)o=NullDateTime();else{
if(o.getFullYear && o.getMonth && o.getDate && o.getHours && o.getMinutes && o.getSeconds && o.getMilliseconds)
o=new Date(o.getFullYear(),o.getMonth(),o.getDate(),o.getHours(),o.getMinutes(),o.getSeconds(),o.getMilliseconds());
else o=NullDateTime()
}
return o
}
//---End function

//---Start function: GetCallerLogic
function utilities_GetCallerLogic(name) {
var res
if(this.m_Caller!=null)res=this.m_Caller['w_'+name];
if(res==null || typeof res!='boolean')res=false;
return res;
}
//---End function

//---Start function: GetCallerNumber
function utilities_GetCallerNumber(name) {
var res
if(this.m_Caller!=null)res=this.m_Caller['w_'+name];
if(res==null || typeof res!='number')res=0;
return res;
}
//---End function

//---Start function: GetCallerString
function utilities_GetCallerString(name) {
var res
if(this.m_Caller!=null)res=this.m_Caller['w_'+name];
if(res==null || typeof res!='string')res='';
return res;
}
//---End function

//---Start function: GetCompany
function utilities_GetCompany() {
  return m_cCompany;
}
//---End function

//---Start function: GetFullName
function utilities_GetFullName() {
  var res = "";
  return res;
}
//---End function

//---Start function: GetInstance
function utilities_GetInstance() {
  var res = "";
  return res;
}
//---End function

//---Start function: GetLanguage
function utilities_GetLanguage() {
  return m_cLanguage;
}
//---End function

//---Start function: GetSkin
function utilities_GetSkin() {
  return m_cThemePath;
}
//---End function

//---Start function: GetSkinList
function utilities_GetSkinList() {
  return "";
}
//---End function

//---Start function: GetViewType
function utilities_GetViewType() {
  var wnd = window;
  while (!wnd.ZtVWeb && wnd!=wnd.parent) {
    wnd = wnd.parent;
  }
  var res = (wnd.ZtVWeb ? wnd.ZtVWeb.ViewType() : 0);
  return res;
}
//---End function

//---Start function: IsAdministrator
function utilities_IsAdministrator() {
  return this.IsInGroup(1);
}
//---End function

//---Start function: IsGuest
function utilities_IsGuest(){
  return m_nUserCode==-1;
}
//---End function

//---Start function: IsInGroup
function utilities_IsInGroup(p_nGroup){
  if (typeof(m_GroupsList)=='undefined') {
   return false
  }
  for(var i=0;i<m_GroupsList.length;i++) {
    if (m_GroupsList[i]==p_nGroup) return true
  }
  return false
}
//---End function

//---Start function: IsInRole
function utilities_IsInRole(p_cRole) {
  if (typeof(m_RolesList)=='undefined') {
   return false
  }
  for(var i=0;i<m_RolesList.length;i++) {
    if (Trim(m_RolesList[i])==Lower(p_cRole)) return true
  }
  return false
}
//---End function

//---Start function: IsMobile
function utilities_IsMobile() {
  var wnd = window;
  while (!wnd.ZtVWeb && wnd!=wnd.parent) {
    wnd = wnd.parent;
  }
  var res = (wnd.ZtVWeb ? wnd.ZtVWeb.IsMobile() : false);
  return res;
}
//---End function

//---Start function: IsUserReadingOnSlaveDB
function utilities_IsUserReadingOnSlaveDB() {
  var res = false;
  return res;
}
//---End function

//---Start function: NextTableProg
function utilities_NextTableProg(valorize, dbserverlocator, tablename, autonumber) {
}
//---End function

//---Start function: PullFromGroup
function utilities_PullFromGroup(groupcode) {
}
//---End function

//---Start function: PullFromRole
function utilities_PullFromRole(rolename) {
}
//---End function

//---Start function: ResetAlternativeServer
function utilities_ResetAlternativeServer() {
  var res = "";
  return res;
}
//---End function

//---Start function: ServerSetUITierSettings
function utilities_ServerSetUITierSettings(UITimeZone, UIDateTime) {
  alert("ServerSetUITierSettings can be called only server side")
  return "ServerSetUITierSettings can be called only server side"
}
//---End function

//---Start function: ServerSetUnspecifiedPictureSettings
function utilities_ServerSetUnspecifiedPictureSettings(decimal_separator, thousand_separator, date_pattern, datetime_pattern) {
  alert("ServerSetUnspecifiedPictureSettings can be called only server side")
  return "ServerSetUnspecifiedPictureSettings can be called only server side"
}
//---End function

//---Start function: SetAlternativeServer
function utilities_SetAlternativeServer(queryname, serverurl) {
  var res = "";
  return res;
}
//---End function

//---Start function: SetCompany
function utilities_SetCompany() {
}
//---End function

//---Start function: SetLanguage
function utilities_SetLanguage() {
}
//---End function

//---Start function: SetSkin
function utilities_SetSkin() {
}
//---End function

//---Start function: SetUserCode
function utilities_SetUserCode(p_nUserCode) {
}
//---End function

//---Start function: ShowHistoricalTodate
function utilities_ShowHistoricalTodate(cptodate) {
return _ShowHistoricalTodate(cptodate)
}
//---End function

//---Start function: SkipTableProg
function utilities_SkipTableProg(obj, dbserverlocator, autonumber, skip) {
}
//---End function

//---Start function: ToHTML
function utilities_ToHTML(p_cString) {
  return ToHTML(p_cString);
}
//---End function

//---Start function: ToSQL
function utilities_ToSQL() {
}
//---End function

//---Start function: Translate
function utilities_Translate(p_cMessage, p_cFirstParameter, p_cSecondMessage) {
  var res = "";
  return res;
}
//---End function

//---Start function: UndefineConnection
function utilities_UndefineConnection() {
  var res = "";
  return res;
}
//---End function

//---Start function: UserCode
function utilities_UserCode(){
  return m_nUserCode;
}
//---End function

//---Start function: UserName
function utilities_UserName(){
  return m_cUserName;
}
//---End function

//---Start function: Word
function utilities_Word(s,idx) {
  var p=_AtSpace_(s,idx),p1;
  if (idx==1) {
    if (p==0)
      return s;
    else
      return Substr(s,1,p-1);
  } else {
    p1=_AtSpace_(s,idx-1);
    if (p1==0)
      return "";
    if (p==0)
      return Substr(s,p1+1);
    else
      return Substr(s,p1+1,p-p1-1);
  }
}
//---End function

//---Start function: MakeUtilities
function MakeUtilities() {
  this.AddToGroup=utilities_AddToGroup
  this.AddToRole=utilities_AddToRole
  this.AskTableProg=utilities_AskTableProg
  this.BeginForceMasterDB=utilities_BeginForceMasterDB
  this.BeginWritingIgnoringSlaveDB=utilities_BeginWritingIgnoringSlaveDB
  this.DateTimeBO=utilities_DateTimeBO
  this.DateTimeUI=utilities_DateTimeUI
  this.DefineConnection=utilities_DefineConnection
  this.EndForceMasterDB=utilities_EndForceMasterDB
  this.EndWritingIgnoringSlaveDB=utilities_EndWritingIgnoringSlaveDB
  this.ForceTableProg=utilities_ForceTableProg
  this.FormatEx=utilities_FormatEx
  this.GetAutonumber=utilities_GetAutonumber
  this.GetCallerBO=utilities_GetCallerBO
  this.GetCallerDate=utilities_GetCallerDate
  this.GetCallerDateTime=utilities_GetCallerDateTime
  this.GetCallerLogic=utilities_GetCallerLogic
  this.GetCallerNumber=utilities_GetCallerNumber
  this.GetCallerString=utilities_GetCallerString
  this.GetCompany=utilities_GetCompany
  this.GetFullName=utilities_GetFullName
  this.GetInstance=utilities_GetInstance
  this.GetLanguage=utilities_GetLanguage
  this.GetSkin=utilities_GetSkin
  this.GetSkinList=utilities_GetSkinList
  this.GetViewType=utilities_GetViewType
  this.IsAdministrator=utilities_IsAdministrator
  this.IsGuest=utilities_IsGuest
  this.IsInGroup=utilities_IsInGroup
  this.IsInRole=utilities_IsInRole
  this.IsMobile=utilities_IsMobile
  this.IsUserReadingOnSlaveDB=utilities_IsUserReadingOnSlaveDB
  this.NextTableProg=utilities_NextTableProg
  this.PullFromGroup=utilities_PullFromGroup
  this.PullFromRole=utilities_PullFromRole
  this.ResetAlternativeServer=utilities_ResetAlternativeServer
  this.ServerSetUITierSettings=utilities_ServerSetUITierSettings
  this.ServerSetUnspecifiedPictureSettings=utilities_ServerSetUnspecifiedPictureSettings
  this.SetAlternativeServer=utilities_SetAlternativeServer
  this.SetCompany=utilities_SetCompany
  this.SetLanguage=utilities_SetLanguage
  this.SetSkin=utilities_SetSkin
  this.SetUserCode=utilities_SetUserCode
  this.ShowHistoricalTodate=utilities_ShowHistoricalTodate
  this.SkipTableProg=utilities_SkipTableProg
  this.ToHTML=utilities_ToHTML
  this.ToSQL=utilities_ToSQL
  this.Translate=utilities_Translate
  this.UndefineConnection=utilities_UndefineConnection
  this.UserCode=utilities_UserCode
  this.UserName=utilities_UserName
  this.Word=utilities_Word
  this.Make=utilities_Make
  this.Make()
}
//---End function

arguments[0].Utilities = new MakeUtilities()
})(window);//MakeUtilities
