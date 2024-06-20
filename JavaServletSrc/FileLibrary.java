import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Properties;
import com.zucchetti.sitepainter.Library;
import com.zucchetti.sitepainter.Logger;
public class FileLibrary {

//---Start function: FILELIBRARY_LIBRARY_CODE
  static Hashtable files=new Hashtable();
  static volatile String location;
  static AtomicReference<String> m_StackTraceFirstSetLocation;
  static {
    m_StackTraceFirstSetLocation = new AtomicReference<String>();
    location = "uninitialized";
    try {
      InputStream is=FileLibrary.class.getResourceAsStream("FileLocation");
      Properties p=new Properties();
      p.load(is);
      SetLocation(p.getProperty("FileLocation"));
    } catch(Exception e) {
    }
    if (location == "uninitialized")
      SetLocation(Library.GetWebRootPath());
  }
  public static boolean CopyFile(File in, File out) {
    try {
      FileInputStream fis = null;
      FileOutputStream fos = null;
      byte[] buf = new byte[1024];
      int i = 0;
      boolean copied = false;
      try {
        fis = new FileInputStream(in);
        fos = new FileOutputStream(out);
        while((i=fis.read(buf))!=-1)
          fos.write(buf, 0, i);
        copied = true;
      } catch(OutOfMemoryError oome) {
        fis = null;
        fos = null;
        throw oome;
      } finally {
        if (fis!=null)
          try {
            fis.close();
          } catch(OutOfMemoryError oome) {
            if (copied)
              throw oome;
          } catch(Throwable cantClose) {
            CPStdCounter.Error(cantClose);
          }
        if (fos!=null)
          try {
            fos.close();
          } catch(OutOfMemoryError oome) {
            if (copied)
              throw oome;
          } catch(Throwable cantClose) {
            CPStdCounter.Error(cantClose);
          }
      }
      return true;
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return false;
    }
  }
  static File LocatedFile(String fileName) {
    File result = new File(fileName);
    if (result.isAbsolute())
      return result;
    else
      return new File(location+fileName);
  }
//---End function

//---Start function: Close
  public static boolean Close(String id) {
    boolean res = true;
    try {
      Object b=files.get(id);
      if (b instanceof BufferedReader)
        ((BufferedReader)b).close();
      else
        ((BufferedWriter)b).close();
      } catch(Exception e) {
      CPStdCounter.Error(e);
      res = false;
    }
    files.remove(id);
    return res;
  }
//---End function

//---Start function: CopyDirectory
public static boolean CopyDirectory(String srcDir, String dstDir) {
  try {
    File srcDirF=new File(srcDir);
    if(!srcDirF.isAbsolute())
      srcDirF=new File(location+srcDir);
		//controllo esistenza directoy di lettura
    if(!srcDirF.isDirectory()) {
      return false;
    }
		File dstDirF = new File(dstDir);
    if(!dstDirF.isAbsolute())
      dstDirF=new File(location+dstDir);
		dstDirF.mkdirs();
		dstDir = dstDirF.getAbsolutePath();
		File[] obj = srcDirF.listFiles();
		ArrayList l_files = new ArrayList();
		for(int i = 0; i < obj.length; i++) {
			if(obj[i].isDirectory()) {
				if(!CopyDirectory(obj[i].getAbsolutePath(), dstDir+File.separator+obj[i].getName()))//chiamata ricorsiva
          return false;
			} else {
				CPLib.AppendToTrs(l_files,obj[i]);//contenitore files "puri"
      }
    }
    //Copy files
    File cpFile, spFile;
		for(int i = 0; i < l_files.size(); i++) {
      cpFile = (File)l_files.get(i);
      spFile = new File(dstDirF.getAbsolutePath() + File.separator + cpFile.getName());
      CopyFile(cpFile,spFile);
    }
    return true;
  } catch(Exception e) {
    CPStdCounter.Error(e);
    return false;
  }
}
//---End function

//---Start function: CreateDir
public static boolean CreateDir(String path) {
  boolean res = false;
  File newdirectory=new File(location+path);
  try{
    res=newdirectory.mkdirs();
  } catch(Exception e) {
    CPStdCounter.Error(e);
    res=false;
  }
  return res;
}
//---End function

//---Start function: DeleteDirectory
public static boolean DeleteDirectory(String dir) {
  try {
    File dirF=new File(dir);
    if(!dirF.isAbsolute())
      dirF=new File(location+dir);
		//controllo esistenza directory
    if(!dirF.exists() || !dirF.isDirectory())
      return false;
    boolean res=true;
		File[] obj = dirF.listFiles();
		ArrayList l_files = new ArrayList();
    //Cancella tutto quello che riesce
		for(int i = 0; i < obj.length; i++) {
			if(obj[i].isDirectory()) {
				if(!DeleteDirectory(obj[i].getAbsolutePath()))//chiamata ricorsiva
          res=false;
			} else {
				CPLib.AppendToTrs(l_files,obj[i]);//contenitore files "puri"
      }
    }
    //Delete files
    File dFile;
		for(int i = 0; i < l_files.size(); i++) {
      dFile = (File)l_files.get(i);
      if(!dFile.delete())
        res=false;
    }
    //Cancello la directory
    res=res & dirF.delete();
    return res;
  } catch(Exception e) {
    CPStdCounter.Error(e);
    return false;
  }
}
//---End function

//---Start function: DeleteFile
  public static boolean DeleteFile(String filename) {
    boolean res = false;
    File objfile = new File(location+filename);
    try{
      res=objfile.delete();
    } catch(Exception e){
      CPStdCounter.Error(e);
      res=false;
    }
    return res;
  }
//---End function

//---Start function: Eof
  public static boolean Eof(String id) {
    try {
      BufferedReader b=((BufferedReader)files.get(id));
      b.mark(2);
      int i=b.read();
      b.reset();
      return (i==-1);
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return true;
    }
  }
//---End function

//---Start function: ExistFile
  public static boolean ExistFile(String filename) {
    try {
      return LocatedFile(filename).exists();
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return false;
    }
  }
//---End function

//---Start function: FileCopy
public static boolean FileCopy(String source, String destination) {
  boolean res = false;
  try {
    File srcFile=new File(source);
    if(!srcFile.isAbsolute())
      srcFile=new File(location+source);
    File destFile=new File(destination);
    if(!destFile.isAbsolute())
      destFile=new File(location+destination);
    res=CopyFile(srcFile,destFile);
  } catch(Exception e){
    CPStdCounter.Error(e);
    res=false;
  }
  return res;
}
//---End function

//---Start function: GetLastModified
public static java.sql.Timestamp GetLastModified(String filename) {
   java.sql.Timestamp res = CPLib.NullDateTime();
   //Check if file exist
   if(ExistFile(filename)){
     //New file object
     File objfile = LocatedFile(filename);
     //Time last modified in millisecond
     long dateMilliSec = 0;
     try{
       //Get the last modified datetime 
       dateMilliSec = objfile.lastModified();
       //Convert millisecond to timestamp
       res = new java.sql.Timestamp(dateMilliSec);
     } catch(Exception e){
       CPStdCounter.Error(e);
     }
   }
  return res;
}
//---End function

//---Start function: GetLocation
public static String GetLocation() {
  return location;
}
//---End function

//---Start function: MoveFile
public static boolean MoveFile(String source,String destination) {
  boolean res = false;
  File s = LocatedFile(source), d = LocatedFile(destination);
  if (!s.exists() || d.exists())
    CPStdCounter.Error(
      new IllegalArgumentException(
         "MoveFile(source="+s+",destination="+d+") failed:"+
         (s.exists() ? "": "source doesn't exist ")+
         (d.exists() ? "destination already exists" : "")));
  else {
    try {
      res = s.renameTo(d);
    } catch(Exception e) {
      res = false;
    }
    //renameTo potrebbe fallire, ad esempio, se sorgente e destinazione sono su filesystem diversi
    if (!res)
      try {
        res = CopyFile(s,d) && s.delete();
      } catch(Exception e){
        CPStdCounter.Error(e);
      }
  }
  return res;
}
//---End function

//---Start function: OpenAppend
public static String OpenAppend(String filename) {
    String id="file_"+CPLib.NewCPCCCHK();
    try {
      CPLib.PutInto(files,id,new BufferedWriter(new FileWriter(location+filename,true)));
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return OpenWrite(filename);
    }
    return id;
  }
public static String OpenAppend(String filename, String charSet) {
  String id="file_"+CPLib.NewCPCCCHK();
  try {
    CPLib.PutInto(files,id,new BufferedWriter(new OutputStreamWriter(new FileOutputStream(location+filename,true),charSet)));
  } catch(Exception e) {
    CPStdCounter.Error(e);
    return OpenWrite(filename, charSet);
  }
  return id;
}
//---End function

//---Start function: OpenRead
  public static String OpenRead(String filename) {
    String id="file_"+CPLib.NewCPCCCHK();
    try {
      CPLib.PutInto(files,id,new BufferedReader(new FileReader(location+filename)));
    } catch(Exception e) {
      CPStdCounter.Error(e);
      id="";
    }
    return id;
  }
  public static String OpenRead(String filename, String charSet) {
    String id="file_"+CPLib.NewCPCCCHK();
    try {
      CPLib.PutInto(files,id,new BufferedReader(new InputStreamReader(new FileInputStream(location+filename),charSet)));
    } catch(Exception e) {
      CPStdCounter.Error(e);
      id="";
    }
    return id;
  }
//---End function

//---Start function: OpenWrite
  public static String OpenWrite(String filename) {
    String id="file_"+CPLib.NewCPCCCHK();
    try {
      CPLib.PutInto(files,id,new BufferedWriter(new FileWriter(location+filename)));
    } catch(Exception e) {
      CPStdCounter.Error(e);
      id="";
    }
    return id;
  }
  public static String OpenWrite(String filename,String charSet) {
    String id="file_"+CPLib.NewCPCCCHK();
    try {
      CPLib.PutInto(files,id,new BufferedWriter(new OutputStreamWriter(new FileOutputStream(location+filename),charSet)));
    } catch(Exception e) {
      CPStdCounter.Error(e);
      id="";
    }
    return id;
  }
//---End function

//---Start function: ReadLine
  public static String ReadLine(String id) {
    try {
      return ((BufferedReader)files.get(id)).readLine();
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return "";
    }
  }
//---End function

//---Start function: RenameFile
  public static boolean RenameFile(String oldfilename, String newfilename) {
    boolean res = false;
    File objoldfile= new File(location+oldfilename);
    File objnewfile= new File(location+newfilename);
    try{
      res=objoldfile.renameTo(objnewfile);
    } catch(Exception e){
      res=false;
    }
    return res;
  }
//---End function

//---Start function: SetLocation
public static void SetLocation(String Location) {
    String l_cLocation = location;
    location = Location;
    boolean bark = false;

    if ("uninitialized" != l_cLocation && ((l_cLocation==null && Location!=null) || !l_cLocation.equals(Location)))
      bark = !m_StackTraceFirstSetLocation.compareAndSet(null, CPLib.DumpException(new Exception("Stack trace for first SetLocation")));
    //non per end user
    if (bark)
      Library.error(new Exception("SetLocation should be called only once, first time has been:"+m_StackTraceFirstSetLocation.get()));
  }
//---End function

//---Start function: Write
  public static double Write(String id,String line) {
    try {
      BufferedWriter b=(BufferedWriter)files.get(id);
      b.write(line);
      return 1;
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return -1;
    }
  }
//---End function

//---Start function: WriteLine
  public static double WriteLine(String id,String line) {
    try {
      BufferedWriter b=(BufferedWriter)files.get(id);
      b.write(line);
      b.newLine();
      return 1;
    } catch(Exception e) {
      CPStdCounter.Error(e);
      return -1;
    }
  }
//---End function

//---Start attributes
//---End attributes
}
