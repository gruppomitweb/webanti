import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDOC extends javax.servlet.http.HttpServlet implements SPInvokable {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String docFileName = request.getParameter("NomeFile");
		String contextPath = request.getParameter("DocPath");
        String subDir = request.getParameter("InfoPath");
        String docType = request.getParameter("DocType");
		File docFile = new File(contextPath+"/"+subDir+"/"+docFileName);
    String contentType="";
    
    switch (docType) {
      case "pdf":
        contentType="application/pdf";
        break;
      case "doc":
        contentType="application/msword";
        break;
      case "docx":
        contentType="application/msword";
        break;
      case "xls":
        contentType="application/vnd.ms-excel";
        break;
      case "xlsx":
        contentType="application/vnd.ms-excel";
        break;
      case "ppt":
        contentType="application/vnd.ms-powerpoint";
        break;
      case "pptx":
        contentType="application/vnd.ms-powerpoint";
        break;       
      case "jpg":
        contentType="image/jpeg";
        break;
      case "jpeg":
        contentType="image/jpeg";
        break;                      
      case "gif":
        contentType="image/gif";
        break;
      case "txt":
        contentType="text/plain";
        break;                                  
    }
    
    response.setContentType(contentType);    
		response.addHeader("Content-Disposition", "inline; filename=" + docFileName);
		response.setContentLength((int) docFile.length());

		FileInputStream fileInputStream = new FileInputStream(docFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
  }
}
