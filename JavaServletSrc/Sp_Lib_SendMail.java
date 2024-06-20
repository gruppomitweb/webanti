import java.util.Properties;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Date;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.PasswordAuthentication;
import java.io.File;
import java.io.IOException;
public class Sp_Lib_SendMail {

//---Start function: SP_LIB_SENDMAIL_LIBRARY_CODE
//	Costruzione della stringa di controllo per la multiutenza
	  static public String NewCPCCCHK() {
	    char[] cpccchk = new char[10];
	    for (int i=0; i<10; i++)
	      cpccchk[i]=(char)(Math.random()*26+97);
	    return new String(cpccchk);
	  }
//---End function

//---Start function: sendMailPers
public static String sendMailPers(String msgText, String textType, String subject, String host, String to, String cc, String bcc, String from, String filename, String username, String password, String retopt, String portaSMTP, String protezioneSSL, String intesta) {
  // Trim dei parametri:
    msgText=msgText.trim();
    subject=subject.trim();
    host=host.trim();
    to=to.trim();
    cc=cc.trim();
    bcc=bcc.trim();
    from=from.trim();
    final String userName=username.trim();
    final String pwd=password.trim();
    portaSMTP=portaSMTP.trim();
    protezioneSSL=protezioneSSL.trim();
    intesta=intesta.trim();
  // Fine trim
  // Dichiarazione delle variabili:
    Session session;
    boolean debug = false;
  //
  // Messaggio di risposta alla funziona chiamante:
    String okMsg="OK";  //mail inviata con successo
    String errMsg="ERROR: ";  //errore nell'invio della mail
  //
	// Define textType:
    String contentType="text/plain; charset=utf-8";
    if(textType != null && textType.equalsIgnoreCase("HTML"))
      contentType="text/html";
  //
  // Create some properties and get the default Session:
    Properties props = System.getProperties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.sendpartial","true");
    if(protezioneSSL.equals("True")) {
      props.put("mail.smtp.starttls.enable", "true");
    } else {
      props.put("mail.smtp.starttls.enable", "false");
      props.put("mail.smtp.ssl.enable", "false");
    }
    if(username!=null && !username.equals("")) {
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.socketFactory.port", portaSMTP);
      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
      session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(userName,pwd);}});
    } else {
      props.put("mail.smtp.port", portaSMTP);
      props.put("mail.smtp.auth", "false");
      session = Session.getDefaultInstance(props, null);
    }
    session.setDebug(debug);
    try {
      // Create a message:
        MimeMessage msg = new MimeMessage(session);
        InternetAddress sender = new InternetAddress(from, intesta);
        msg.setFrom(sender);
        msg.setSubject(subject,"iso-8859-1");
      // Recipients To:
        StringTokenizer st=new StringTokenizer(to.trim(),";");
        ArrayList<InternetAddress> addressTo=new ArrayList<InternetAddress>();
        String recipient;
        for (int i=0;st.hasMoreTokens();i++) {
          recipient=st.nextToken();
          addressTo.add( new InternetAddress(recipient));
        }
        InternetAddress[] address = new InternetAddress[addressTo.size()];
        for (int i=0;i<addressTo.size();i++)
          address[i]=(InternetAddress)addressTo.get(i);
        msg.setRecipients(Message.RecipientType.TO, address);
      // Recipients Cc:
        st=new StringTokenizer(cc.trim(),";");
        ArrayList<InternetAddress> addressCc=new ArrayList<InternetAddress>();
        for (int i=0;st.hasMoreTokens();i++) {
          recipient=st.nextToken();
          addressCc.add(new InternetAddress(recipient));
        }
        address = new InternetAddress[addressCc.size()];
        for (int i=0;i<addressCc.size();i++)
          address[i]=(InternetAddress)addressCc.get(i);
        msg.setRecipients(Message.RecipientType.CC, address);
      // Recipients Bcc:
        st=new StringTokenizer(bcc.trim(),";");
        ArrayList<InternetAddress> addressBcc=new ArrayList<InternetAddress>();
        for (int i=0;st.hasMoreTokens();i++) {
          recipient=st.nextToken();
          addressBcc.add(new InternetAddress(recipient));
        }
        address = new InternetAddress[addressBcc.size()];
        for (int i=0;i<addressBcc.size();i++)
          address[i]=(InternetAddress)addressBcc.get(i);
        msg.setRecipients(Message.RecipientType.BCC, address);
      // Create the Multipart and its parts to it:
        Multipart mp = new MimeMultipart("mixed");
      // Add the Image to the MimeMultipart:
        if (textType.equalsIgnoreCase("HTML")) { //embeddo le immagini solo se  il messaggio è di tipo HTML
          int imgStartPosition=0;
          int imgEndPosition=0;
          String FileName="";
          String CIDID="";
          imgStartPosition=msgText.indexOf("<img src=\"",0);
          while (imgStartPosition > 0){
            if (msgText.substring(imgStartPosition + 10, imgStartPosition + 14).equalsIgnoreCase("cid:")){
              //è un'immagine già gestita
              imgStartPosition=msgText.indexOf("<img src=\"",imgStartPosition+10);
            } else {
              //è un'immagine non ancora gestita
              imgEndPosition=msgText.indexOf("\"",imgStartPosition + 10);
              FileName=msgText.substring(imgStartPosition+10, imgEndPosition);
              //Calcolo il nuovo CID:
                CIDID=NewCPCCCHK();
                msgText=msgText.replace(FileName, "cid:" + CIDID);
              //Inclusione dell'immagine:
                BodyPart embedImage1=new MimeBodyPart();
                DataSource ds1=new FileDataSource(new File(FileName));
                embedImage1.setDataHandler(new DataHandler(ds1));
                embedImage1.setHeader("Content-ID",CIDID);
                mp.addBodyPart(embedImage1);
                imgStartPosition=msgText.indexOf("<img src=\"",msgText.indexOf(CIDID,0));
            }
          }
        }
      // Create and fill the first message part:
        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setContent(msgText,contentType);
        mp.addBodyPart(mbp1);
      // Attach the file to the message
      if(filename!=null && !filename.equals("")) {
        st=new StringTokenizer(filename.trim(),"|");
        MimeBodyPart mbpn=null;
        FileDataSource fds=null;
        for (int i=0;st.hasMoreTokens();i++) {
          String att=st.nextToken();
          if(att.equals(""))
            continue;
          // Create a message part:
            mbpn = new MimeBodyPart();
            fds = new FileDataSource(att);
            mbpn.setDataHandler(new DataHandler(fds));
            mbpn.setFileName(fds.getName());
          // Add the attachment to the multipart:
            mp.addBodyPart(mbpn);
        }
      }
      // Add the Multipart to the message:
        msg.setContent(mp);
      // Set the Date: header
        msg.setSentDate(new Date());
      // Disposition-Notification-To - Ricevuta di Ritorno
        if (!(retopt == "N"))
          msg.addHeader("Disposition-Notification-To",""+from+"");
      //Custom End
        if (username!=null && !username.equals("")) {
          // Send con autentificazione:
            Transport transport = session.getTransport("smtp");
            transport.send(msg);
            msg.saveChanges();
            transport.close();
        } else {
          // Send senza autentificazione:
            Transport transport = session.getTransport("smtp");
            transport.send(msg);
            transport.close();
        }
        return okMsg;
    } catch (MessagingException mex) {
      mex.printStackTrace();
      return errMsg+mex.getMessage();
    } catch (IOException e) {
      return "Caught IOException: " + e.getMessage();
    }  
}  
//---End function

//---Start attributes
//---End attributes
}
