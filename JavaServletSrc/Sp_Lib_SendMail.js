//---Start function: sendMailPers
function sp_lib_sendmail_sendMailPers(msgText, textType, subject, host, to, cc, bcc, from, filename, username, password, retopt, portaSMTP, protezioneSSL, intesta) {  var res = "";  return res;}
//---End function

//---Start function: MakeSp_Lib_SendMail
function MakeSp_Lib_SendMail() {
  this.sendMailPers=sp_lib_sendmail_sendMailPers
}
//---End function

var Sp_Lib_SendMail = new MakeSp_Lib_SendMail()
