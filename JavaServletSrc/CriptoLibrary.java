import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.MessageDigest;
public class CriptoLibrary {

//---Start function: CRIPTOLIBRARY_LIBRARY_CODE
private static String dumpBytes(byte[] bytes) {
  int i;
  StringBuffer sb = new StringBuffer();
  for (i=0; i<bytes.length; i++) {
    if (i%32 == 0 && i!=0) {
      sb.append("\n");
    }
    String s = Integer.toHexString(bytes[i]);
    if (s.length() < 2) {
      s = "0"+s;
    }
    if (s.length() > 2) {
      s = s.substring(s.length()-2);
    }
    sb.append(s);
  }
  return sb.toString();
}
private static String ByteArrayToHexString(byte[] b) throws Exception {
  String result = "";
  for (int i=0; i < b.length; i++) {
    result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
  }
  return result;
}
private static byte[] hexStringToByteArray(String s) { 
  int len = s.length();
  byte[] data = new byte[len / 2];
  for (int i = 0; i < len; i += 2) {
    data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)  + Character.digit(s.charAt(i+1), 16));
  }
  return data;
}
//---End function

//---Start function: AEScryptBytes
public static byte [] AEScryptBytes(String msg, String pwd) {
  try {
    int l = pwd.length()/16 + 1;
    pwd=(pwd+"j3a£Nhb39aCE0[a@").substring(0,16);
    byte [] raw=pwd.getBytes("ISO-8859-1");
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
       return cipher.doFinal(msg.getBytes("ISO-8859-1"));
      }catch(Exception e){
        CPStdCounter.Error(e);
      }
  return null;
}
//---End function

//---Start function: AEScryptFile
public static boolean AEScryptFile(String inputFile, String outputFile, String pwd) {
  java.io.FileInputStream fis = null;
  java.io.FileOutputStream fos = null;
  boolean res = true;
  try{
    int l = pwd.length()/16 + 1;
    pwd=(pwd+"j3a£Nhb39aCE0[a@").substring(0,16);
    byte [] raw=pwd.getBytes("ISO-8859-1");        
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    fis = new java.io.FileInputStream(inputFile);
    fos = new java.io.FileOutputStream(outputFile);
    CipherOutputStream cos = new CipherOutputStream(fos, cipher);
    byte[] block = new byte[128];
    int i;
    while ((i = fis.read(block)) != -1) {
      cos.write(block, 0, i);
    }
    cos.close();
    fis.close();
    fos.close();
  }
  catch(Exception e){
    CPStdCounter.Error(e);
    res = false;
    try{
    if(fis!=null)
      fis.close();
    if(fos!=null)
      fos.close();
    }
    catch(Exception ex){
      CPStdCounter.Error(ex);
    }
  }
  return res;
}
//---End function

//---Start function: AEScryptString
public static String AEScryptString(String msg, String pwd) {
  byte [] raw=AEScryptBytes(msg,pwd);
  char[] c=Base64Coder.encode(raw);
  return new String(c);
}
//---End function

//---Start function: AESdecryptBytes
public static String AESdecryptBytes(byte [] rawmsg, String pwd) {
  try {
    int l = pwd.length()/16 + 1;
    pwd=(pwd+"j3a£Nhb39aCE0[a@").substring(0,16);
    byte [] raw=pwd.getBytes("ISO-8859-1");        
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte [] original = cipher.doFinal(rawmsg);
    return new String(original);
  } catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: AESdecryptFile
public static boolean AESdecryptFile(String inputFile, String outputFile, String pwd) {
  java.io.FileInputStream fis = null;
  java.io.FileOutputStream fos = null;
  boolean res = true;
  try{
    int l = pwd.length()/16 + 1;
    pwd=(pwd+"j3a£Nhb39aCE0[a@").substring(0,16);
    byte [] raw=pwd.getBytes("ISO-8859-1");        
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte[] block = new byte[128];
    int i;
    fis = new java.io.FileInputStream(inputFile);
    CipherInputStream cis = new CipherInputStream(fis, cipher);
    fos = new java.io.FileOutputStream(outputFile);
    while ((i = cis.read(block)) != -1) {
      fos.write(block, 0, i);
    }
    fos.close();
    cis.close();
    fis.close();
  }
  catch(Exception e){
    CPStdCounter.Error(e);
    res = false;
    try{
      if(fis !=null)
        fis.close();
      if(fos != null)
        fos.close();
    }
    catch(Exception ex){
      CPStdCounter.Error(ex);
    }
  }
  return res;
}
//---End function

//---Start function: AESdecryptFileBytes
public static byte[] AESdecryptFileBytes(String inputFile, String pwd) {
  byte[] res = null;
  java.io.FileInputStream fis = null;
  java.io.ByteArrayOutputStream fos = null;
  try{
    int l = pwd.length()/16 + 1;
    pwd=(pwd+"j3a£Nhb39aCE0[a@").substring(0,16);
    byte [] raw=pwd.getBytes("ISO-8859-1");        
    SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte[] block = new byte[128];
    int i;
    fis = new java.io.FileInputStream(inputFile);
    CipherInputStream cis = new CipherInputStream(fis, cipher);
    fos = new java.io.ByteArrayOutputStream();
    while ((i = cis.read(block)) != -1) {
      fos.write(block, 0, i);
    }
    res = fos.toByteArray();
    fos.close();
    cis.close();
    fis.close();
  }
  catch(Exception e){
    CPStdCounter.Error(e);
    //res = false;
    try{
      if(fis !=null)
        fis.close(); 
      if(fos != null)
        fos.close();
    }
    catch(Exception ex){
      CPStdCounter.Error(ex);
    }
  }
  return res;
}
//---End function

//---Start function: AESdecryptString
public static String AESdecryptString(String base64msg, String pwd) {
  byte[] raw=Base64Coder.decode(base64msg);
  return AESdecryptBytes(raw,pwd);
}
//---End function

//---Start function: MD5
public static String MD5(String msg) {
  byte[] dg=MD5Bytes(msg);
  if (dg!=null){
    return dumpBytes(dg);
  }
  return null;
}
//---End function

//---Start function: MD5Base64
public static String MD5Base64(String msg) {
  byte[] dg=MD5Bytes(msg);
  if (dg!=null){
    return new String(Base64Coder.encode(dg));
  }
  return null;
}
//---End function

//---Start function: MD5Base64_deprecated
public static String MD5Base64_deprecated(String msg) {
  String res = "";
  return res;
}
//---End function

//---Start function: MD5Bytes
public static byte [] MD5Bytes(String msg) {
  try {
    MessageDigest md = MessageDigest.getInstance( "MD5" );
	md.update(msg.getBytes("ISO-8859-1"));
    byte[] digest=md.digest();
    return digest;
  } 
  catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: SHA1
public static String SHA1(String msg) {
  byte[] dg=SHA1Bytes(msg);
  if (dg!=null){
    return dumpBytes(dg);
  }
  return null;
}
//---End function

//---Start function: SHA1Base64_deprecated
public static String SHA1Base64_deprecated(String msg) {
  String res = "";
  return res;
}
//---End function

//---Start function: SHA1Bytes
public static byte [] SHA1Bytes(String msg) {
  try {
    MessageDigest md = MessageDigest.getInstance( "SHA-1" );
    md.update(msg.getBytes("ISO-8859-1"));
    byte[] digest=md.digest();
    return digest;
  } catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: SHA256
public static String SHA256(String msg) {
  byte[] dg=SHA256Bytes(msg);
  if (dg!=null){
    return dumpBytes(dg);
  }
  return null;
}
//---End function

//---Start function: SHA256Base64
public static String SHA256Base64(String msg) {
  byte[] dg=SHA256Bytes(msg);
  if (dg!=null){
    return new String(Base64Coder.encode(dg));
  }
  return null;
}
//---End function

//---Start function: SHA256Base64_deprecated
public static String SHA256Base64_deprecated(String msg) {
  String res = SHA256Base64(msg);
  return res;
}
//---End function

//---Start function: SHA256Bytes
public static byte [] SHA256Bytes(String msg) {
  try {
    MessageDigest md = MessageDigest.getInstance( "SHA-256" );
	md.update(msg.getBytes("ISO-8859-1"));
    byte[] digest=md.digest();
    return digest;
  } catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: cryptStringPrivKey
public static String cryptStringPrivKey(String msg, String key) {
  try {
    byte[] pr=hexStringToByteArray(key);
    PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(pr);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey pk = keyFactory.generatePrivate(privKeySpec);
    Cipher cipher = Cipher.getInstance("RSA"); 
    cipher.init(Cipher.ENCRYPT_MODE, pk);
   	byte[] ciphertext = cipher.doFinal(msg.getBytes("ISO-8859-1"));
    return encodeBytesBase64(ciphertext);
  } catch(Exception e){
     CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: cryptStringPublKey
public static String cryptStringPublKey(String msg, String key) {
  try {
    byte[] pb=hexStringToByteArray(key);
    X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pb);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PublicKey pk = keyFactory.generatePublic(pubKeySpec);
    Cipher cipher = Cipher.getInstance("RSA"); 
    cipher.init(Cipher.ENCRYPT_MODE, pk);
 	byte[] ciphertext = cipher.doFinal(msg.getBytes("ISO-8859-1"));
    return encodeBytesBase64(ciphertext);
  } catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: decodeBase64
public static String decodeBase64(String s) {
   return Base64Coder.decodeString(s);
}
//---End function

//---Start function: decodeBytesBase64
public static byte [] decodeBytesBase64(String s) {
  return Base64Coder.decode(s);
}
//---End function

//---Start function: decryptStringPrivKey
public static String decryptStringPrivKey(String msg, String key) {
  try {
    byte[] pr=hexStringToByteArray(key);
    PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(pr);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey pk = keyFactory.generatePrivate(privKeySpec);
    Cipher cipher = Cipher.getInstance("RSA"); 
    cipher.init(Cipher.DECRYPT_MODE, pk);
    byte[] raw=decodeBytesBase64(msg);
    byte[] decrypted = cipher.doFinal(raw);
    return new String(decrypted);
  } catch(Exception e){
        CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: decryptStringPublKey
public static String decryptStringPublKey(String msg, String key) {
  try {
    byte[] pb=hexStringToByteArray(key);
    X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pb);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PublicKey pk = keyFactory.generatePublic(pubKeySpec);
    Cipher cipher = Cipher.getInstance("RSA"); 
    cipher.init(Cipher.DECRYPT_MODE, pk);
    byte[] raw=decodeBytesBase64(msg);
    byte[] decrypted = cipher.doFinal(raw);
    return new String(decrypted);
  } catch(Exception e){
        CPStdCounter.Error(e);
  }
 return null;
}
//---End function

//---Start function: encodeBase64
public static String encodeBase64(String s) {
  return Base64Coder.encodeString(s);  
}
//---End function

//---Start function: encodeBytesBase64
public static String encodeBytesBase64(byte [] b) {
  char [] c=Base64Coder.encode(b);
  return new String(c);
}
//---End function

//---Start function: getRSA1024KeysPair
public static String getRSA1024KeysPair() {
  return getRSAKeysPair(1024);
}
//---End function

//---Start function: getRSAKeysPair
public static String getRSAKeysPair(double len) {
  try{
    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    gen.initialize((int)len,new SecureRandom());
    KeyPair kp = gen.generateKeyPair();
    PrivateKey kpriv = kp.getPrivate();
    PublicKey kpub = kp.getPublic();
    byte[] pribytes=kpriv.getEncoded(); 
    String base64priv=ByteArrayToHexString(pribytes);
    byte[] pubbytes=kpub.getEncoded();
    String base64pub=ByteArrayToHexString(pubbytes);
    return base64pub+"|"+base64priv;
  } catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: getRSAPrivateKey
public static String getRSAPrivateKey(String kpair) {
  int i=kpair.indexOf('|');
  return kpair.substring(i+1);
}
//---End function

//---Start function: getRSAPublicKey
public static String getRSAPublicKey(String kpair) {
  int i=kpair.indexOf('|');
  return kpair.substring(0,i);
}
//---End function

//---Start function: signature
public static String signature(String msg, String key) {
  try {
    byte[] pr=hexStringToByteArray(key);
    PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(pr);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privk = keyFactory.generatePrivate(privKeySpec);
    Signature sigS = Signature.getInstance("MD5withRSA");
    sigS.initSign(privk);
    sigS.update(msg.getBytes("ISO-8859-1"));
    byte[] s = sigS.sign();
    return encodeBytesBase64(s);
  } catch(Exception e){
    CPStdCounter.Error(e);
  }
  return null;
}
//---End function

//---Start function: verifySignature
public static boolean verifySignature(String msg, String signature, String key) {
  boolean res = false;
  try {
    byte[] pb=hexStringToByteArray(key);
    X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(pb);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PublicKey pubk = keyFactory.generatePublic(pubKeySpec);
    Signature sigV = Signature.getInstance("MD5withRSA");
    sigV.initVerify(pubk);
    sigV.update(msg.getBytes("ISO-8859-1"));
    res = sigV.verify(decodeBytesBase64(signature));
  } catch (Exception e) {
    CPStdCounter.Error(e);
    res = false;
  }
  return res;
}
//---End function

//---Start attributes
//---End attributes
}
