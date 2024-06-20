import java.nio.charset.*;
import java.nio.CharBuffer;
import java.util.UUID;
import java.util.regex.Pattern;
import java.nio.ByteBuffer;
import java.net.URLEncoder;
import java.util.Random;
import java.util.Arrays;
public class LibreriaMit {

//---Start function: CalcCond
public static boolean CalcCond() {
  boolean res = true;
  return res;
}
//---End function

//---Start function: CloseLine
public static String CloseLine() {
  String res = CPLib.Chr(13)+CPLib.Chr(10);
  return res;
}
//---End function

//---Start function: FreeMem
public static void FreeMem() {
  System.gc();
//  System.out.println("Runtime reports "+Runtime.getRuntime().freeMemory()+" bytes free.");
}
//---End function

//---Start function: GeneraCodice
public static String GeneraCodice(int numeroCaratteriRandom, boolean conSpeciali, boolean conTimeStamp, String separatore) {
  // array delle lettere
  String[] Caratteri = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
	  "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "z", "y",
		"j", "k", "x", "w", "A", "B", "C", "D", "E", "F", "G", "H", "I",
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Z", "Y",
		"J", "K", "X", "W", "à", "è", "é", "ì", "ò", "ù" };
  // array dei numeri
  String[] Numeri = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
  // array dei caratteri speciali
  String[] Speciali = {"!","£","$","%","&","@","*",",","_","-","#",";","^",":", ".", "+", "§", "?", "ç","/"};  
  // creo l'oggetto random
	Random rand = new Random();
  // ottengo la lunghezza di ogni array
	int lunghezzaCaratteri = Caratteri.length;
	int lunghezzaNumeri = Numeri.length;
	int lunghezzaSpeciali = Speciali.length;
	// istanzio la variabile che conterrà il prodotto finale
	String stringaRandom = "";
	while (stringaRandom.length() < numeroCaratteriRandom) {
		// ottengo un elemento casuale per ogni array
		int c = rand.nextInt(lunghezzaCaratteri);
		int n = rand.nextInt(lunghezzaNumeri);
		int s = rand.nextInt(lunghezzaSpeciali);
		// aggiungo una lettera casuale
		stringaRandom += Caratteri[c];
		// aggiungo un numero random
		stringaRandom += Numeri[n];
		// se l'opzione conSpeciali è true aggiungo un carattere speciale
		if (conSpeciali) {
			stringaRandom += Speciali[s];
		}
	}
	// se la stringa generata dovesse superare il numero di caratteri
	// richiesto, la taglio.
	if (stringaRandom.length() > numeroCaratteriRandom) {
		stringaRandom = stringaRandom.substring(0, numeroCaratteriRandom);
	}
	// se abbiamo deciso di mettere il timestamp
	if (conTimeStamp) {
		// recupero il timestamp
		long timestamp = System.currentTimeMillis();
		stringaRandom += separatore + timestamp;
	}
	// restituisco la stringa generata
	return stringaRandom;
}
//---End function

//---Start function: NewStato
public static String NewStato(String cTbRif, String cFlag) {
  String res = "!";
  String _oper = "ABCDEFGHI";
  String _fraz = "JLMNOTUV?";
  if (cTbRif == "OPERAZBO") {
    for (int i=1;i<=9;i++) {
      if (i == CPLib.Val(cFlag)) {
        res = CPLib.Substr(_oper,i,1);
      }
    }
  }
  else {
    for (int i=1;i<=9;i++) {
      if (i == CPLib.Val(cFlag)) {
        res = CPLib.Substr(_fraz,i,1);
      }
    }    
  }  
  return res;
}
//---End function

//---Start function: Occurs
public static double Occurs(String cOrigin, String cSearch) {
  double result = 0;
  int len = cSearch.length();
	if (len > 0) {  
	  int start = cOrigin.indexOf(cSearch);
		while (start != -1) {
				result++;
				start = cOrigin.indexOf(cSearch, start+len);
	  }
  }
  return result;
}
//---End function

//---Start function: SpacePad
public static String SpacePad(String cStringa, double nLen) {
  String res = "";
  res = CPLib.Left(CPLib.LRTrim(CPLib.Left(cStringa,nLen))+CPLib.Space(nLen),nLen);
  return res;
}
//---End function

//---Start function: StatoReg
public static String StatoReg(String cTbRif, String nStato) {
  String res = nStato;
//  if (cTbRif == 'RAPOPEBO') {
//    if (nStato == '1') {
//      res = 'M'
//    }  
//    else if (nStato == '2') {
//      res = 'C'
//    }  
//    else if (nStato == '3') {
//      res = 'V'
//    }  
//    else {
//      res = 'B'
//    }
//    res = nStato
//  }
  if (cTbRif == "SIMINFBO") {
    if (nStato == "1") {
      res = "M";
    }  
    else if (nStato == "2") {
      res = "C";
    }  
    else if (nStato == "3") {
      res = "V";
    }  
    else {
      res = "B";
    }
  }
  if (cTbRif == "OPERAZBO") {
    if (nStato == "1") {
      res = "P";
    }  
    else if (nStato == "2") {
      res = "Q";
    }  
    else if (nStato == "3") {
      res = "R";
    }  
    else {
      res = "S";
    }
  }
  if (cTbRif == "FRAZIOBO") {
    if (nStato == "1") {
      res = "K";
    }  
    else if (nStato == "2") {
      res = "X";
    }  
    else if (nStato == "3") {
      res = "Y";
    }  
    else {
      res = "Z";
    }
  }  
  if (cTbRif == "SIMOPEBO") {
    if (nStato == "1") {
      res = "P";
    }  
    else if (nStato == "2") {
      res = "Q";
    }  
    else if (nStato == "3") {
      res = "R";
    }  
    else {
      res = "S";
    }
  }
  return res;
}  
//---End function

//---Start function: TestAscii
public static boolean TestAscii(String sStringa, String sCharSet) {
  boolean res;
  byte bytearray []  = sStringa.getBytes();
  CharsetDecoder d = Charset.forName(sCharSet).newDecoder();
  try {
       CharBuffer r = d.decode(ByteBuffer.wrap(bytearray));
       res = true;
  }
  catch(CharacterCodingException e) {
       res = false;
  }  
  return res;
}
//---End function

//---Start function: URL_enc
public static String URL_enc(String pValue) {
  String value;
  value=pValue;
  try {
    value=URLEncoder.encode(pValue,com.zucchetti.sitepainter.Library.m_cResponseEncoding);
  } catch(Exception couldntEncode) {
    CPStdCounter.Error(couldntEncode);
  }
  return value;
}
//---End function

//---Start function: UTFtoISO
public static String UTFtoISO(String s1) {
  String s = new String(s1.getBytes(StandardCharsets.UTF_8));
  byte[] b = s.getBytes(StandardCharsets.ISO_8859_1);
  return new String(b, StandardCharsets.ISO_8859_1);
}
//---End function

//---Start function: UniqueId
public static String UniqueId() {
  char[] cpccchk = new char[10];
  for (int i=0; i<10; i++)
    cpccchk[i]=(char)(Math.random()*26+97);
  return new String(cpccchk);
}
//---End function

//---Start function: cWarnOpe
public static String cWarnOpe(String cErrMsg, String cTipCon) {
  String res = "";
  return res;
}
//---End function

//---Start function: cWarning
public static String cWarning(String cErrMsg) {
  String res = "";
  return res;
}
//---End function

//---Start function: inter_art1
public static boolean inter_art1(String pTipo) {
  boolean res = false;
  if(CPLib.At(pTipo,"|02|03|04|06|07|11|16|18|46|47|49|81|82")>0)
    res=true;
  return res;
}
//---End function

//---Start function: isAlpha
public static boolean isAlpha(String pString) {
  boolean res = false;
  Pattern p = Pattern.compile("[a-zA-Z]+");
  res = p.matcher(pString).find();
  return res;
}
//---End function

//---Start function: isAlphaNum
public static boolean isAlphaNum(String pStringa) {
  boolean res = false;
  Pattern p = Pattern.compile("[a-zA-Z0-9]+");
  res = p.matcher(pStringa).find();
  return res;
}
//---End function

//---Start function: isNumeric
public static boolean isNumeric(String pString) {
  boolean res = false;
  String regex="\\d+";
  res = pString.matches(regex);
  return res;
}
//---End function

//---Start function: nextUID
public static String nextUID() {
  UUID uuid = UUID.randomUUID();
  String res = uuid.toString();
  return res;
}
//---End function

//---Start function: uuidToStr15
public static String uuidToStr15(UUID uuid) {
  long[] longs = new long[2];
  longs[0] = uuid.getLeastSignificantBits();
  longs[1] = uuid.getMostSignificantBits();
  System.out.println("uuidToStr15: " + Arrays.toString(longs));
  char[] chars = new char[15];
  // 15 chars x 9 bits payload == 135 >=  128.
  final int bitsPerChar = (128 + chars.length - 1) / chars.length;
  final int char0 = 0x2000;
  long mask = (1L << bitsPerChar) - 1;
  for (int i = 0; i < chars.length; ++i) {
    int payload = (int)(longs[0] & mask);
    chars[i] = (char)(char0 + payload);
    longs[0] >>>= bitsPerChar;
    longs[0] |= (longs[1] & mask) << (64 - bitsPerChar);
    longs[1] >>>= bitsPerChar;
  }
  System.out.println(chars);
  return new String(chars);
}
//---End function

//---Start attributes
//---End attributes
}
