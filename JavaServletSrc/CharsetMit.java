import java.io.File;
import java.nio.charset.Charset;
import org.mozilla.universalchardet.UniversalDetector;
public class CharsetMit {

//---Start function: detectCharset
public Charset detectCharset(String path) {
  return Charset.forName(detectCharsetString(path));
}
//---End function

//---Start function: detectCharsetString
public String detectCharsetString(String path) {
  String encoding="";
  // Cerca Encoding del file
  try{
    File file = new File(path);
    encoding = UniversalDetector.detectCharset(file);
    
//    if (encoding != null) {
//      System.out.println("Detected encoding = " + encoding);
//    } else {
//      System.out.println("No encoding detected.");
//    }
  }
  catch(Exception e) {
    CPStdCounter.Error(e);
  }
  return encoding;
}
//---End function

//---Start attributes
//---End attributes
}
