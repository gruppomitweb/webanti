public class MailLibrary {

//---Start function: MAILLIBRARY_LIBRARY_CODE
private static final double defaultTimeOut = 60000; // Un minuto
private static final int defaultSMTPPort = 25; // Porta di default per smpt della libreria JavaMail
/* sendMail */
// Parametri opzionali: SMTPPort, readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains, STARTTLSProtection
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt) {
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, Integer.toString(defaultSMTPPort), false);
}
// Parametri opzionali: readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains, STARTTLSProtection
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, double SMTPPort, boolean SSLProtection) {
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, defaultTimeOut, defaultTimeOut);
}
// Parametri opzionali: mailReplyTo, mailToDomains, STARTTLSProtection
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, double SMTPPort, boolean SSLProtection, double readTimeOut, double connectionTimeOut) {
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, readTimeOut, connectionTimeOut, "");
}
// Parametri opzionali: mailToDomains, STARTTLSProtection
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, double SMTPPort, boolean SSLProtection, double readTimeOut, double connectionTimeOut, String mailReplyTo) {
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, readTimeOut, connectionTimeOut, mailReplyTo, "");
}
// Parametri opzionali: STARTTLSProtection
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, double SMTPPort, boolean SSLProtection, double readTimeOut, double connectionTimeOut, String mailReplyTo, String mailToDomains) {
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains, SSLProtection);
}
/* sendMailByMailConfig */
// Parametri opzionali: requestedReceipt, readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains
public static String sendMailByMailConfig(String msgText, String textType, String subject, String mailTo, String mailCc, String mailBcc, String mailFrom, String filename) {
  return sendMailByMailConfig(msgText, textType, subject, mailTo, mailCc, mailBcc, mailFrom, filename, false);
}
// Parametri opzionali: readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains
public static String sendMailByMailConfig(String msgText, String textType, String subject, String mailTo, String mailCc, String mailBcc, String mailFrom, String filename, boolean requestedReceipt) {
  return sendMailByMailConfig(msgText, textType, subject, mailTo, mailCc, mailBcc, mailFrom, filename, requestedReceipt, defaultTimeOut);
}
// Parametri opzionali: connectionTimeOut, mailReplyTo, mailToDomains
public static String sendMailByMailConfig(String msgText, String textType, String subject, String mailTo, String mailCc, String mailBcc, String mailFrom, String filename, boolean requestedReceipt, double readTimeOut) {
  return sendMailByMailConfig(msgText, textType, subject, mailTo, mailCc, mailBcc, mailFrom, filename, requestedReceipt, readTimeOut, defaultTimeOut);
}
// Parametri opzionali: mailReplyTo, mailToDomains
public static String sendMailByMailConfig(String msgText, String textType, String subject, String mailTo, String mailCc, String mailBcc, String mailFrom, String filename, boolean requestedReceipt, double readTimeOut, double connectionTimeOut) {
  return sendMailByMailConfig(msgText, textType, subject, mailTo, mailCc, mailBcc, mailFrom, filename, requestedReceipt, readTimeOut, connectionTimeOut, "");
}
// Parametri opzionali: mailToDomains
public static String sendMailByMailConfig(String msgText, String textType, String subject, String mailTo, String mailCc, String mailBcc, String mailFrom, String filename, boolean requestedReceipt, double readTimeOut, double connectionTimeOut, String mailReplyTo) {
  return sendMailByMailConfig(msgText, textType, subject, mailTo, mailCc, mailBcc, mailFrom, filename, requestedReceipt, readTimeOut, connectionTimeOut, mailReplyTo, "");
}
/* *** Compatibilita' con vecchie versioni *** */
/* * Seconda versione della libreria* */
// SMTPPort di tipo String, mancano readTimeOut e connectionTimeOut
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, String SMTPPort, boolean SSLProtection) {
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, Double.toString(defaultTimeOut), Double.toString(defaultTimeOut));
}
// SMTPPort, readTimeOut e connectionTimeOut di tipo String
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, String SMTPPort, boolean SSLProtection, String readTimeOut, String connectionTimeOut) {
  return CPSendMail.sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, readTimeOut, connectionTimeOut);
}
/* * Prima versione della libreria* */
// Mancano SMTPPort, SSLProtection
public static String sendMailPers(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, String requestedReceipt) {
  return sendMailPers(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, "", "false");
}
// Metodo utilizzato in prima versione della libreria
public static String sendMailPers(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, String requestedReceipt, String SMTPPort, String SSLProtection) {
  boolean reqReceipt = false;
  boolean SSLProtect = false;
  if (!(requestedReceipt.equalsIgnoreCase("N")) && !(requestedReceipt.equals("0")) && !(requestedReceipt.equalsIgnoreCase("false")) && !(requestedReceipt.equalsIgnoreCase("no"))&& !(requestedReceipt.equalsIgnoreCase("F"))) {
    reqReceipt = true;
  }
  if (!(SSLProtection.equalsIgnoreCase("N")) && !(SSLProtection.equals("0")) && !(SSLProtection.equalsIgnoreCase("false")) && !(SSLProtection.equalsIgnoreCase("no"))&& !(SSLProtection.equalsIgnoreCase("F"))) {
    SSLProtect = true;
  }
  return sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, reqReceipt, SMTPPort, SSLProtect);
}
//---End function

//---Start function: sendMail
public static String sendMail(String msgText, String txtType, String subject, String host, String mailTo, String mailCc, String mailBcc, String mailFrom, String fileName, String userName, String password, boolean requestedReceipt, double SMTPPort, boolean SSLProtection, double readTimeOut, double connectionTimeOut, String mailReplyTo, String mailToDomains, boolean STARTTLSProtection) {
  return CPSendMail.sendMail(msgText, txtType, subject, host, mailTo, mailCc, mailBcc, mailFrom, fileName, userName, password, requestedReceipt, SMTPPort, SSLProtection, readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains, STARTTLSProtection);
}
//---End function

//---Start function: sendMailByMailConfig
public static String sendMailByMailConfig(String msgText, String textType, String subject, String mailTo, String mailCc, String mailBcc, String mailFrom, String filename, boolean requestedReceipt, double readTimeOut, double connectionTimeOut, String mailReplyTo, String mailToDomains) {
  return CPSendMail.sendMailByMailConfig(msgText, textType, subject, mailTo, mailCc, mailBcc, mailFrom, filename, requestedReceipt, readTimeOut, connectionTimeOut, mailReplyTo, mailToDomains);
}
//---End function

//---Start attributes
//---End attributes
}
