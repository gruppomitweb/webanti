import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class sp_huploadfile extends HttpServlet implements SPInvokable{
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // PARAMETRI RICEVUTI
    String pDirectory=request.getParameter("pDirectory");
    String pAtExit=request.getParameter("pAtExit");
    String pVarReturn=request.getParameter("pVarReturn");


    out.println("<HTML>");
    out.println("<script>");
    out.println("document.title = unescape('Upload File')");
	out.println("resizeTo(450,150)");
	out.println("moveTo((screen.availWidth-375) / 2, (screen.availHeight-50) / 2)");
	out.println("</script>");
    //out.println("<BODY bgcolor=#6699FF style=\"overflow:hidden\">");
    out.println("<BODY bgcolor=#CCCCCC style=\"overflow:hidden\">");
    out.println("<script>");
	out.println("document.body.style.borderStyle=\"none\"");
	out.println("</script>");
    out.println("<STYLE>.InsNome {text-decoration=none; font:verdana; font-size=8pt}</STYLE>");
    out.println("<FORM METHOD=POST ACTION=\"sp_hservletupload\" ENCTYPE=\"multipart/form-data\">");
    out.println("<table border=\"0\">");
    out.println("<TR>");
    out.println("<TD width=\"100%\" height=\"30\">");
    out.println("<B>Upload attach file</B>&nbsp;&nbsp;(Max. 400MByte)<BR>");

    // PARAMETRI DA PASSARE
    out.println("   <INPUT type=\"HIDDEN\" name=\"pDirectory\" value="+pDirectory+">");
    out.println("   <INPUT type=\"HIDDEN\" name=\"pAtExit\" value="+pAtExit+">");
    out.println("   <INPUT type=\"HIDDEN\" name=\"pVarReturn\" value="+pVarReturn+">");

    // Elementi per l'Upload
    out.println("   <INPUT TYPE=\"FILE\" NAME=\"FILE1\" SIZE=\"40\" class=InsNome style=\"height:20px;\">");
    out.println("   <INPUT TYPE=\"SUBMIT\" VALUE=\"Upload\" class=InsNome style=\"height:20px;width:60px\">");
    out.println("</TD>");
    out.println("</TR>");
    out.println("</table>");
    out.println("</FORM>");
    out.println("</BODY></HTML>");
  }
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    doProcess(request,response);
  }
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    doProcess(request,response);
  }
}
