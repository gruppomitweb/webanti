import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.jspsmart.upload.*;

public class sp_hservletupload extends HttpServlet implements SPInvokable{

	private ServletConfig config;
	/**
	* Init the servlet
	*/
	ServletContext servletcontext;

	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
		servletcontext = config.getServletContext();
	}

	final public ServletConfig getServletConfig() {
		return config;
	}
	/**
	* Handles GET requests
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<script>");
    	out.println("document.title = unescape('Upload File')");
		out.println("</script>");
		out.println("<BODY BGCOLOR='#6699FF'>");
		out.println("<script>");
		out.println("document.body.style.borderStyle=\"none\"");
		out.println("</script>");
		out.println("<H1>RICEZIONE ALLEGATO</H1>");
		out.println("<HR><BR>");
		//out.println("The method of the HTML form must be POST.");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	/**
	* Handles POST requests
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HTML>");
		out.println("<script>");
    	out.println("document.title = unescape('Upload File')");
		out.println("</script>");
		out.println("<STYLE>.InsNome {text-decoration=none; font:verdana; font-size=12pt}</STYLE>");
        //out.println("<BODY bgcolor=#6699FF style=\"overflow:hidden\">");
        out.println("<BODY bgcolor=#CCCCCC style=\"overflow:hidden\">");
        out.println("<script>");
		out.println("document.body.style.borderStyle=\"none\"");
		out.println("</script>");
		// Variables
		int count=0;
		SmartUpload mySmartUpload = new SmartUpload();

		try {
			// Initialization
			//PARAMETRI: Dichiarazione del nome locale dei Parametri ricevuti
			String pDirectory="",pAtExit="",pVarReturn="";
			mySmartUpload.initialize(config,request,response);

			// Upload
			mySmartUpload.setMaxFileSize(400000000);
			mySmartUpload.upload();

			//Retreive the current file
		        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0);
                        // Save it only if this file exists
                if (myFile.getSize()> 0) {
		          if (!myFile.isMissing()) {
                     // Save the files with its original names in a virtual path of the web server

                    // PARAMETRI RICEVUTI

                    pDirectory = mySmartUpload.getRequest().getParameter("pDirectory");
                    pAtExit = mySmartUpload.getRequest().getParameter("pAtExit");
                    pVarReturn = mySmartUpload.getRequest().getParameter("pVarReturn");


			 		 // SALVA IL FILE NELLA DIR. contenuta in pDirectory
			  		myFile.saveAs("/"+pDirectory+"/" +myFile.getFileName(), mySmartUpload.SAVE_VIRTUAL);
			  		count = 1;
			  		// Display the result
		   			//out.println(count + " file uploaded.");

					if (pAtExit.equals("AutoClose")){
						//Chiusura Automatica al completamento
					    out.println("<script>");
			    		out.println("window.close()");
			    		out.println("</script>");
					}
					else if (pAtExit.equals("Return") && !(pVarReturn==null || pVarReturn.length()==0 || pVarReturn.equals("null"))){
						//Ritorno del Nome della funzione
			    		out.println("<script>");
              out.println("var caller=null,eventSrcID=(window.ZtVWeb && ZtVWeb.UID)||(window.location.origin + window.location.pathname + window.location.search);");
              out.println("try{");
              out.println("if(opener && opener.ZtVWeb){");
              out.println("caller=opener;");
              out.println("}");
              out.println("}catch(e){}");
              out.println("if(!caller && frameElement && parent.ZtVWeb){");
              out.println("caller=parent;");
              out.println("}");
              out.println("if (caller){");
              out.println("if (window.LibJavascript){");
              out.println("LibJavascript.Events.addEvent(window,'unload',function(){");
              out.println("caller.ZtVWeb.purgeEventsCache(eventSrcID);");
              out.println("});");
              out.println("}");
              out.println("}");
			    		out.println("if (typeof(caller)!= undefined && typeof(caller.Set_" +pVarReturn+")) {");
			    		out.println("caller.Set_" +pVarReturn +"(\""+myFile.getFileName()+"\")");
			    		out.println("}");
			    		out.println("window.close()");
			    		out.println("</script>");
					}
					else {
						//Messaggio di Conferma + Pulsante per Chiusura
						out.println("<center><label class=InsNome>File uploaded</label></center>");
						out.println("<center><input type='button' value='Close' onclick=\"javascript:window.close()\"></center>");
					}
					//RICHIAMO DI UNA ROUTINE:
					//Esempio di richiamo di una routine:
					//La routine ha nome sp_afterupload e prende in input i parametri
					//w_nomefile e Tipo
					//Forward f=null;
					//f=new Forward("sp_afterupload",false,Forward.QueryStatus,false);
                        //PASSAGGIO PARAMETRI
              			//f.SetParameter("w_nomefile","/" + pDirectory +"/" + myFile.getFileName());
                        //f.SetParameter("Tipo",'File');
                //        SPLib.ForwardTo(f,servletcontext,request,response);

                  }
                  else {
                  	//File is Missing
                  	out.println("<center><label class=InsNome>File is Missing</label></center>");
                  }
            }
            else {
            	//File is Empty
            	out.println("<center><label class=InsNome>File is Empty</label></center>");
            	out.println("<center><input type='button' value='Chiudi' onclick=\"javascript:window.close()\"></center>");
            }
		} catch (Exception e){
			out.println("<center><label class=InsNome>Upload Impossibile</label></center>");
			out.println("<center><label class=InsNome>ERROR : " + e.toString()+"</label></center>");
			out.println("<center><input type='button' value='Close' onclick=\"javascript:window.close()\"></center>");
		}
		out.println("</BODY>");
		out.println("</HTML>");
          }
	/**
	* Destroy the servlet
	*/
	public void  destroy () {
	}

}
