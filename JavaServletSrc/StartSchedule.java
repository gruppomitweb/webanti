import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StartSchedule extends HttpServlet implements SPInvokable {
	private ServletConfig config;
  static Vector<String> Instances;     
	/**
	* Init the servlet
	*/
	ServletContext servletcontext;
	
	final public void init(ServletConfig config) throws ServletException {
    super.init(config);	
	this.config = config;
	servletcontext = config.getServletContext();
    System.out.println("Start Scheduler Processi ..");
	Instances = new Vector<String>();
	CPContext ctx = null;     
    try {
          CPPooler.Purge();
          ctx = new CPContext("",0,CPPooler.InstanceNames()[0]);
          // Class clazz = Class.forName("arrt_imp_dati_storico_schedR");
          Class clazz = Class.forName("arrt_startprcbckR");
          Object r = clazz.getMethod("Make",new Class[]{CPContext.class,Caller.class}).
                       invoke(null,new Object[]{ctx,CPSecurity.EXECUTE_ALL_ROUTINES});
          clazz.getMethod("Run",(Class[])null).invoke(r,(Object[])null);         
        } catch(OutOfMemoryError oome) {
          ctx = null;
          throw oome;
        } catch(Throwable routineNotWorking) {
          CPStdCounter.Error(routineNotWorking);
        } finally {
          if (ctx!=null)
            //cancello eventuali temporanee
            ctx.DoLogout();
        }		    
    
  }  
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
  }
  public String getServletInfo() {
    return null;
  }
	final public ServletConfig getServletConfig() {
		return config;
	}
}
