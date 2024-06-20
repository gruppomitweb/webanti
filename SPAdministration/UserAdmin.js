(function() {//MakeUserAdmin
function useradmin_PasswordTranslations(){
var s=new JSURL((typeof(ZtVWeb)!='undefined' && ZtVWeb.SPWebRootURL?ZtVWeb.SPWebRootURL:'..')+'/servlet/UserAdmin$PasswordTranslations').Response()
eval('useradmin_PasswordTranslations='+s)
return useradmin_PasswordTranslations.apply(null,arguments)
}


//---Start function: AddCompany
function useradmin_AddCompany(codazi, desazi) {
}
//---End function

//---Start function: AddGroup
function useradmin_AddGroup(groupcode, groupname) {
}
//---End function

//---Start function: AddGroupOfGroups
function useradmin_AddGroupOfGroups(groupcode, groupbase) {
  var res = false;
  return res;
}
//---End function

//---Start function: AddGroupToUser
function useradmin_AddGroupToUser(usercode, groupcode) {
}
//---End function

//---Start function: AddLanguage
function useradmin_AddLanguage(code, name) {
}
//---End function

//---Start function: AddSSOMap
function useradmin_AddSSOMap(ssoid, userid) {
}
//---End function

//---Start function: AddSecurityRecord
function useradmin_AddSecurityRecord(progname, groupcode, usercode, sec1, sec2, sec3, sec4) {
}
//---End function

//---Start function: AddServer
function useradmin_AddServer(servername, serverdesc, odbc, whenconn) {
}
//---End function

//---Start function: AddUser
function useradmin_AddUser(usercode, username, password, language) {
}
//---End function

//---Start function: AddUserToGroup
function useradmin_AddUserToGroup(groupcode, usercode) {
}
//---End function

//---Start function: CanAdminDatabase
function useradmin_CanAdminDatabase() {
  var res = false;
  return res;
}
//---End function

//---Start function: ChangePassword
function useradmin_ChangePassword(usercode, oldpassword, newpassword) {
  var res = false;
  return res;
}
//---End function

//---Start function: CheckCompanyExists
function useradmin_CheckCompanyExists(codazi) {
  var res = false;
  return res;
}
//---End function

//---Start function: CheckGroupExists
function useradmin_CheckGroupExists(groupcode) {
  var res = false;
  return res;
}
//---End function

//---Start function: CheckLanguageExists
function useradmin_CheckLanguageExists(code) {
  var res = false;
  return res;
}
//---End function

//---Start function: CheckPasswordStrength
function useradmin_CheckPasswordStrength(password, strength) {
  return useradmin_GetPasswordRating(password)>=strength;
}
//---End function

//---Start function: CheckSSPMapExists
function useradmin_CheckSSPMapExists(ssoid) {
  var res = false;
  return res;
}
//---End function

//---Start function: CheckServerExists
function useradmin_CheckServerExists(ServerName) {
  var res = false;
  return res;
}
//---End function

//---Start function: CheckUserExists
function useradmin_CheckUserExists(usercode) {
  var res = false;
  return res;
}
//---End function

//---Start function: FirstLogin
function useradmin_FirstLogin() {
  var res = "";
  return res;
}
//---End function

//---Start function: GetLanguageName
function useradmin_GetLanguageName(code) {
  var res = "";
  return res;
}
//---End function

//---Start function: GetNextCode
function useradmin_GetNextCode(tablename) {
  var res = 0;
  return res;
}
//---End function

//---Start function: GetPasswordRating
function useradmin_GetPasswordRating(passwd) {
  var transl=useradmin_PasswordTranslations
  var intScore     = 0;
  var strVerdict   = transl("ADMIN_PASSWORD_VERY_WEAK")
  var strLog       = "";
  var causeLog     ="";
  var causePoints  = 0;
  var maxReachable = 0;
  const OWASP_CRITERIA_LENGTH = 8;
  const OWASP_CRITERIA_PENALTY = 5;
  const OWASP_CRITERIA_SPECIAL_CHARACTERS = " !\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~"; // https://owasp.org/www-community/password-special-characters
  let fits_OWASP_CRITERIA_LENGTH = false;
  let fits_OWASP_CRITERIA_CHARACTER_UPPERCASE = false;
  let fits_OWASP_CRITERIA_CHARACTER_LOWERCASE = false;
  let fits_OWASP_CRITERIA_CHARACTER_DIGIT = false;
  let fits_OWASP_CRITERIA_CHARACTER_SPECIAL = false;
  let fits_OWASP_CRITERIA_CHARACTER_count = 0;
  //score
  // PASSWORD LENGTH
  if (passwd.length>7 && passwd.length<16) // length between 8 and 15
  {
    causePoints  = 12;
    causeLog     = transl("ADMIN_PASSWORD_LENGTH", causePoints, passwd.length) + "\n";
    fits_OWASP_CRITERIA_LENGTH = true;
  }
  else if (passwd.length>15)                    // length 16 or more
  {
    causePoints   = 18;
    causeLog      = transl("ADMIN_PASSWORD_LENGTH", causePoints, passwd.length) + "\n";
    fits_OWASP_CRITERIA_LENGTH = true;
  }
  intScore     += causePoints;
  maxReachable += 18;
  strLog       += causeLog;
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match(/[a-z]/))                              // at least one lower case letter
  {
    causePoints = 1;
    causeLog    = transl("ADMIN_PASSWORD_LOWER",causePoints) + "\n"
    fits_OWASP_CRITERIA_CHARACTER_LOWERCASE = true;
    fits_OWASP_CRITERIA_CHARACTER_count++;
  }
  intScore     += causePoints;
  maxReachable += 1;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match(/[A-Z]/))                              // at least one upper case letter
  {
    causePoints = 5;
    causeLog    = transl("ADMIN_PASSWORD_UPPER",causePoints) + "\n"
    fits_OWASP_CRITERIA_CHARACTER_UPPERCASE = true;
    fits_OWASP_CRITERIA_CHARACTER_count++;
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  // NUMBERS
  if (passwd.match(/\d+/))                                 // at least one number
  {
    causePoints = 5;
    causeLog    = transl("ADMIN_PASSWORD_DIGITS",causePoints,1) + "\n"
    fits_OWASP_CRITERIA_CHARACTER_DIGIT = true;
    fits_OWASP_CRITERIA_CHARACTER_count++;
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=\\d.*\\d.*\\d)"))             // at least three numbers
  {
    causePoints = 5;
    causeLog    = transl("ADMIN_PASSWORD_DIGITS",causePoints,3) + "\n"
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  // SPECIAL CHAR
  if (passwd.match("[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "]"))            // at least one special character
  {
    causePoints = 5;
    causeLog    = transl("ADMIN_PASSWORD_SPECIAL",causePoints,1) + "\n"
    if (passwd.match("[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "]"))
    {
      fits_OWASP_CRITERIA_CHARACTER_SPECIAL = true;
      fits_OWASP_CRITERIA_CHARACTER_count++;
    }
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "].*[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "])"))// at least two special characters // https://stackoverflow.com/a/4670743/7991344
  {
    causePoints = 5;
    causeLog    = transl("ADMIN_PASSWORD_SPECIAL",causePoints,2) + "\n"
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  // COMBOS
  if (passwd.match("(?=[A-Z].*[a-z])|(?=[a-z].*[A-Z])"))        // both upper and lower case
  {
    causePoints = 2;
    causeLog    = transl("ADMIN_PASSWORD_UL",causePoints) + "\n"
  }
  intScore     += causePoints;
  maxReachable += 2;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=.*[A-Za-z])(?=.*\\d)")) // both letters and numbers
  {
    causePoints = 2;
    causeLog    = transl("ADMIN_PASSWORD_LD",causePoints) + "\n"
  }
  intScore     += causePoints;
  maxReachable += 2;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=[^\\x00-\\x7F])")) // at least a non ASCII character
  {
    causePoints = 5;
    causeLog    = transl("ADMIN_PASSWORD_NON_ASCII",causePoints) + "\n"
  }
  intScore     += causePoints;
  maxReachable += 5;
  strLog       += causeLog
  causePoints   = 0;
  causeLog      = "";
  if (passwd.match("(?=.*[A-Za-z])(?=.*\\d)(?=.*[" + OWASP_CRITERIA_SPECIAL_CHARACTERS + "])"))// letters, numbers, and special characters
  {
    causePoints = 2;
    causeLog    = transl("ADMIN_PASSWORD_LD_SPECIAL",causePoints) + "\n"
  }
  intScore     += causePoints;
  maxReachable += 2;
  strLog       += causeLog
    
  // penalizzazione per lunghezza insicura
  if (!fits_OWASP_CRITERIA_LENGTH)
  {
    strLog += transl("ADMIN_PASSWORD_PENALTY_LENGTH", -6*OWASP_CRITERIA_PENALTY, OWASP_CRITERIA_LENGTH) + "\n";
    intScore = Math.max(0, intScore-6*OWASP_CRITERIA_PENALTY);
  }
   // penalizzazione per mancato soddisfacimento di almeno 3 regole sul tipo di carattere:
  if (fits_OWASP_CRITERIA_CHARACTER_count<3)
  {
    if (!fits_OWASP_CRITERIA_CHARACTER_SPECIAL)
    {
      strLog += transl("ADMIN_PASSWORD_OWASP_PENALTY_SPECIAL_CHARACTER", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
    if (!fits_OWASP_CRITERIA_CHARACTER_DIGIT)
    {
      strLog += transl("ADMIN_PASSWORD_OWASP_PENALTY_DIGIT", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
    if (!fits_OWASP_CRITERIA_CHARACTER_UPPERCASE)
    {
      strLog += transl("ADMIN_PASSWORD_OWASP_PENALTY_UPPERCASE", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
    if (!fits_OWASP_CRITERIA_CHARACTER_LOWERCASE)
    {
      strLog += transl("ADMIN_PASSWORD_OWASP_PENALTY_LOWERCASE", -OWASP_CRITERIA_PENALTY) + "\n";
      intScore = Math.max(0, intScore-OWASP_CRITERIA_PENALTY);
    }
  }
  //verdict
  if(intScore < 16)
  {
     strVerdict = transl("ADMIN_PASSWORD_VERY_WEAK")
  }
  else if (intScore > 15 && intScore < 25)
  {
     strVerdict = transl("ADMIN_PASSWORD_WEAK")
  }
  else if (intScore > 24 && intScore < 35)
  {
     strVerdict = transl("ADMIN_PASSWORD_MEDIOCRE")
  }
  else if (intScore > 34 && intScore < 45)
  {
     strVerdict = transl("ADMIN_PASSWORD_STRONG")
  }
  else
  {
     strVerdict = transl("ADMIN_PASSWORD_STRONGER")
  }
  if(arguments.length>1){
    arguments[1].log=strLog;
    arguments[1].rating=arguments[1].score=intScore;
    arguments[1].verdict=strVerdict;
    arguments[1].maxReachable=maxReachable;
  }
	return(intScore);
}
//---End function

//---Start function: GetPasswordRatingExplaination
function useradmin_GetPasswordRatingExplaination(password) {
  var res = {};
  useradmin_GetPasswordRating(password, res);
  return res.log;
}
//---End function

//---Start function: GetPasswordRatingMaxReachable
function useradmin_GetPasswordRatingMaxReachable() {
  var res = {};
  useradmin_GetPasswordRating('', res);
  return res.maxReachable;
}
//---End function

//---Start function: GetPasswordVerdict
function useradmin_GetPasswordVerdict(password,plusComment) {
  var res = {};
  useradmin_GetPasswordRating(password, res);
  return (plusComment ? useradmin_PasswordTranslations('ADMIN_PASSWORD_RATE') : '') + res.verdict;
}
//---End function

//---Start function: GetRoleStringForEntity
function useradmin_GetRoleStringForEntity(entityName) {
  var res = "";
  return res;
}
//---End function

//---Start function: GetUserData
function useradmin_GetUserData(usercode) {
}
//---End function

//---Start function: HasAdminRights
function useradmin_HasAdminRights() {
  var res = false;
  return res;
}
//---End function

//---Start function: HasAdministratedUsers
function useradmin_HasAdministratedUsers() {
  var res = false;
  return res;
}
//---End function

//---Start function: HasCode
function useradmin_HasCode(tablename, curr_code) {
  var res = false;
  return res;
}
//---End function

//---Start function: ReloadSecurityForProgname
function useradmin_ReloadSecurityForProgname(progname) {
}
//---End function

//---Start function: RemoveFromSecurity
function useradmin_RemoveFromSecurity() {
}
//---End function

//---Start function: RemoveGroup
function useradmin_RemoveGroup(groupcode) {
}
//---End function

//---Start function: RemoveGroupFromUser
function useradmin_RemoveGroupFromUser(groupcode, usercode) {
}
//---End function

//---Start function: RemoveGroupOfGroups
function useradmin_RemoveGroupOfGroups(groupcode, groupbase) {
  var res = false;
  return res;
}
//---End function

//---Start function: RemoveLanguage
function useradmin_RemoveLanguage() {
}
//---End function

//---Start function: RemoveSSOMap
function useradmin_RemoveSSOMap() {
}
//---End function

//---Start function: RemoveSecurity
function useradmin_RemoveSecurity(progname) {
}
//---End function

//---Start function: RemoveServer
function useradmin_RemoveServer(servername) {
}
//---End function

//---Start function: RemoveUser
function useradmin_RemoveUser(usercode) {
}
//---End function

//---Start function: RemoveUserFromGroup
function useradmin_RemoveUserFromGroup(groupcode, usercode) {
}
//---End function

//---Start function: SaveCompany
function useradmin_SaveCompany(codazi, desazi) {
}
//---End function

//---Start function: SaveGroup
function useradmin_SaveGroup(groupcode, groupname) {
}
//---End function

//---Start function: SaveLanguage
function useradmin_SaveLanguage(code) {
}
//---End function

//---Start function: SaveSSOMap
function useradmin_SaveSSOMap(ssoid, userid) {
}
//---End function

//---Start function: SaveServer
function useradmin_SaveServer() {
}
//---End function

//---Start function: SaveUser
function useradmin_SaveUser(usercode, username, password, language) {
}
//---End function

//---Start function: MakeUserAdmin
function MakeUserAdmin() {
  this.AddCompany=useradmin_AddCompany
  this.AddGroup=useradmin_AddGroup
  this.AddGroupOfGroups=useradmin_AddGroupOfGroups
  this.AddGroupToUser=useradmin_AddGroupToUser
  this.AddLanguage=useradmin_AddLanguage
  this.AddSSOMap=useradmin_AddSSOMap
  this.AddSecurityRecord=useradmin_AddSecurityRecord
  this.AddServer=useradmin_AddServer
  this.AddUser=useradmin_AddUser
  this.AddUserToGroup=useradmin_AddUserToGroup
  this.CanAdminDatabase=useradmin_CanAdminDatabase
  this.ChangePassword=useradmin_ChangePassword
  this.CheckCompanyExists=useradmin_CheckCompanyExists
  this.CheckGroupExists=useradmin_CheckGroupExists
  this.CheckLanguageExists=useradmin_CheckLanguageExists
  this.CheckPasswordStrength=useradmin_CheckPasswordStrength
  this.CheckSSPMapExists=useradmin_CheckSSPMapExists
  this.CheckServerExists=useradmin_CheckServerExists
  this.CheckUserExists=useradmin_CheckUserExists
  this.FirstLogin=useradmin_FirstLogin
  this.GetLanguageName=useradmin_GetLanguageName
  this.GetNextCode=useradmin_GetNextCode
  this.GetPasswordRating=useradmin_GetPasswordRating
  this.GetPasswordRatingExplaination=useradmin_GetPasswordRatingExplaination
  this.GetPasswordRatingMaxReachable=useradmin_GetPasswordRatingMaxReachable
  this.GetPasswordVerdict=useradmin_GetPasswordVerdict
  this.GetRoleStringForEntity=useradmin_GetRoleStringForEntity
  this.GetUserData=useradmin_GetUserData
  this.HasAdminRights=useradmin_HasAdminRights
  this.HasAdministratedUsers=useradmin_HasAdministratedUsers
  this.HasCode=useradmin_HasCode
  this.ReloadSecurityForProgname=useradmin_ReloadSecurityForProgname
  this.RemoveFromSecurity=useradmin_RemoveFromSecurity
  this.RemoveGroup=useradmin_RemoveGroup
  this.RemoveGroupFromUser=useradmin_RemoveGroupFromUser
  this.RemoveGroupOfGroups=useradmin_RemoveGroupOfGroups
  this.RemoveLanguage=useradmin_RemoveLanguage
  this.RemoveSSOMap=useradmin_RemoveSSOMap
  this.RemoveSecurity=useradmin_RemoveSecurity
  this.RemoveServer=useradmin_RemoveServer
  this.RemoveUser=useradmin_RemoveUser
  this.RemoveUserFromGroup=useradmin_RemoveUserFromGroup
  this.SaveCompany=useradmin_SaveCompany
  this.SaveGroup=useradmin_SaveGroup
  this.SaveLanguage=useradmin_SaveLanguage
  this.SaveSSOMap=useradmin_SaveSSOMap
  this.SaveServer=useradmin_SaveServer
  this.SaveUser=useradmin_SaveUser
}
//---End function

arguments[0].UserAdmin = new MakeUserAdmin()
})(window);//MakeUserAdmin
