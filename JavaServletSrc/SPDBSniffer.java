import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet che configura il sistema di logging di CPPooler per
//visualizzare i relativi messaggi nel browser collegato in formato HTML
//estende SPServlet per comodita', non e' necessario
//L'interfaccio SPInvokable e' invece obbligatoria a meno che non
//si configuri manualmente web.xml
public class SPDBSniffer extends SPServlet implements SPInvokable {
  //classe usata per riconfigurare il sistema di logging di CPPooler
  static class BrowserSink extends CPPooler.CPPoolerSink {

    //necessario per attivare il loggin:IsLogging()=true implica logging attivato
    protected boolean IsLogging() {
      return true;
    }
    //Questo metodo viene chiamato da CPPooler.FlushLogBuffer()
    //il formato di uscita e' HTML perche' questa servlet e' 
    //pensata per produrre HTML, ma non ci sono vincoli al riguardo
    protected void LogMessage(CPPooler.LogEvent p_data) {
      //uno o piu' membri di p_data potrebbe essere null
      
      //il server su cui e' stata eseguita la frase
      out.print(p_data.server);
      // System.out.print(p_data.server);
      out.print(";");
      // System.out.print(";");
      //al momento potrebbe valere "starting" od "ending" per capire quanto
      //tempo richiede l'esecuzione di una frase
      out.print(p_data.marker);
      // System.out.print(p_data.marker);
      out.print("@");
      // System.out.print("@");
      //momento in cui e' stato registrato l'evento di log
      out.print(new java.sql.Timestamp(p_data.when));
      // System.out.print(new java.sql.Timestamp(p_data.when));
      out.print(";");
      // System.out.print(";");
      //cause=null implica che l'evento di log sia relativo all'esecuzione
      //di una frase
      if (p_data.cause==null) {
        out.print(p_data.message);
        // System.out.print(p_data.message);
        
      } else {
        out.print(CPLib.DumpException(p_data.cause));
        // System.out.print(CPLib.DumpException(p_data.cause));
      }  
      //fine della riga HTML
      out.println();
      // System.out.println();
    }
    
    //Memorizzo il writer connesso al browser per usarlo in LogMessage
    PrintWriter out;
    BrowserSink(PrintWriter printwriter) {
      out = printwriter;
    }
  }

  public void doProcess(HttpServletRequest httpservletrequest, 
                        HttpServletResponse httpservletresponse)
              throws IOException, ServletException {
    //memorizzo CPPooler.sink per ripristinarlo una volta che l'utente 
    //si e' sconnesso(chiuso il browser oppure ha stoppato con
    //l'apposito bottone del browser)
    CPPooler.CPPoolerSink cppoolersink = CPPooler.sink;
    //evito che chiamate successive a SPDBSniffer da parte dell'utente
    //vengano cachate
    SPLib.NoCache(httpservletresponse);
    //questa versione di SPDBSniffer produce HTML, vedi LogMessage
    SPLib.SetContentType(httpservletresponse,"text/plain");
    PrintWriter printwriter = httpservletresponse.getWriter();
    try {
      //Installo la mia classe di logging
      CPPooler.sink = new BrowserSink(printwriter);
      //printwriter.checkError()=true implica che l'utente non riesce piu'
      //a leggere il logging perche' sconnesso dalla servlet
      //il for e' in pratica un ciclo di polling su CPPooler
      //2000L=2 secondi, ogni 2 secondi viene aggiornata
      //la pagina nel browser con gli ultimi dati
      //se passa troppo tempo il buffer di log potrebbe perdere degli eventi
      //perche' ha dimensioni limitate
      for(; !printwriter.checkError(); Thread.sleep(250L))
        CPPooler.FlushLogBuffer();
    }
    catch(Exception exception) {
        printwriter.println(CPLib.DumpException(exception));
    }
    //ripristino la situazione precedente alla chiamata a SPDBSniffer
    CPPooler.sink = cppoolersink;
  }
}
