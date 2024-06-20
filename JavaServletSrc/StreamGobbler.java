import java.util.*;
import java.io.*;
class StreamGobbler extends Thread
{
    InputStream is;
    String type;
    String gMsgProc;
    CPContext m_Ctx;
    
    StreamGobbler(InputStream is, String type, CPContext m_Ctx)
    {
        this.m_Ctx =m_Ctx;
        this.is = is;
        this.type = type;
    }
    
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
            while ( (line = br.readLine()) != null)
              System.out.println(type + "> " + line);
            } catch (IOException ioe)
              {
                ioe.printStackTrace();  
              }
    }
}