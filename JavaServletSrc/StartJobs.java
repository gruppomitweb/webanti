import it.sauronsoftware.cron4j.Task;
import it.sauronsoftware.cron4j.TaskExecutionContext;
import java.util.*;


public class StartJobs extends Task {

	public boolean canBePaused() {
		return false;
	}

	public boolean canBeStopped() {
		return false;
	}

	public boolean supportsCompletenessTracking() {
		return false;
	}

	public boolean supportsStatusTracking() {
		return false;
	}

	public void execute(TaskExecutionContext executor) throws RuntimeException {
		// TODO Auto-generated method stub
     CPContext ctx = null;
     try {
          //Class[] cArg = new Class[1];
          //Object[] cValue = new Object[1];
          //cArg[0] = String.class;
          //cValue[0] = "B";
		  // System.out.println("creo il job...");
          CPPooler.Purge();
          ctx = new CPContext("",0,CPPooler.InstanceNames()[0]);
          // Class clazz = Class.forName("arrt_imp_dati_storico_schedR");
          Class clazz = Class.forName("rt_startprcbkgR");
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

}
