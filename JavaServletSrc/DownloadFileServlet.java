import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zucchetti.sitepainter.SPPrxycizer;
 
public class DownloadFileServlet extends HttpServlet implements SPInvokable {
   
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        CPContext _context = SPLib.GetContext(SPLib.GetContextID(request),request );
        String gDip = _context.GetGlobalString("gCodDip");
        // reads input file from an absolute path
        String _id=request.getParameter("id");
        String filePath = arfn_cgo_nomefile_reportR.Make(_context,null).Run(_id,gDip);        
        
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
                 
        // obtains ServletContext
        ServletContext context = getServletContext();
         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();
        FileLibMit.DeleteFilePath(filePath);     
    }
}