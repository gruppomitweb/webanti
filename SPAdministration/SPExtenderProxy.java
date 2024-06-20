import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.PrintWriter;
import java.io.IOException;
import com.zucchetti.sitepainter.Library;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SPExtenderProxy extends SPServlet implements SPInvokable {
  static public class ServletStatus extends SPPageServletStatus {
  }

  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // System.out.println("passato");
    ServletStatus status = new ServletStatus();
    SPParameterSource source = SPLib.GetSource(request);
    status.request=request;
    status.response=response;
    status.context = SPLib.GetContext(SPLib.GetContextID(request), request);
    SPLib.SetContentType(response);
    PrintWriter out = response.getWriter();
    if ( ! (CPLib.IsAdministrator(status.context)) && status.context.HasAdministeredUsers()) {
      out.print("-1");
    }
    else {
      String pAction = request.getParameter("action");
      String pServer="", pTable="";
      if ("servers".equals(pAction)){
        CPResultSet rs=null;
        CPSql m_Sql;
        m_Sql = status.context.GetSql();
        String l_cServer = status.context.GetServer("cptsrvr", true);
        rs=m_Sql.Query(l_cServer,"select ServerName, ODBCDataSource from " + status.context.GetPhName("cptsrvr") + " order by ServerName");
        JSONArray listServer= new JSONArray();
        JSONObject tmpObj=new JSONObject();
        // tmpObj.put("serverName", "Application DB");
        // tmpObj.put("ODBCDataSource","-1");
        while ( ! (rs.Eof())) {
          tmpObj=new JSONObject();
          tmpObj.put("serverName",rs.GetString("ServerName"));
          tmpObj.put("ODBCDataSource",CPLib.LRTrim(rs.GetString("ServerName")));
          listServer.put(tmpObj);
          rs.Next();
        }
        rs.Close();
        out.print(listServer.toString());
      }
      else if ("tables".equals(pAction)){
        pServer=request.getParameter("server");
        if (!Library.Empty(pServer)){
          if ("default".equals(pServer)) {
            pServer = status.context.GetServer("cptsrvr", true);
          } else {
            CPSql m_Sql = status.context.GetSql();
            String l_cServer = status.context.GetServer("cptsrvr", true);
            CPResultSet cprs = m_Sql.Query(l_cServer,"select ODBCDataSource from " + 
                                                  status.context.GetPhName("cptsrvr") + 
                                                  " where ServerName = " + CPLib.ToSQL(pServer, "C", 10, 0));
            if (!cprs.Eof()) {
              pServer = cprs.GetString("ODBCDataSource");
            } else {
              pServer = "";
            }
            cprs.Close();
          }
          if (!Library.Empty(pServer)) {
            int connId=-1;
            try{
              connId=CPPooler.ReserveConnection(pServer);
              try{
                int dbType =  CPSql.GetDataBaseType(pServer);
                DatabaseMetaData metaData=CPPooler.GetMetaData(connId);
                ResultSet rs=metaData.getTables(null,null,null,null);
                JSONArray listTable = new JSONArray();
                while(rs.next()) {
                  String cTableType = rs.getString("TABLE_TYPE");
                  String cSchema = (dbType == CPSql.m_nMySQL ? rs.getString("TABLE_CAT") : rs.getString("TABLE_SCHEM"));
                  String cTableName = rs.getString("TABLE_NAME");
                  // System.out.println("Table name: " + cTableName + ", schema: " + cSchema + ", type: " + cTableType);
                  boolean validTable = "TABLE".equals(cTableType) || "VIEW".equals(cTableType);
                  if (dbType == CPSql.m_nSQLServer) {
                    validTable = validTable && ( !"sys".equals(cSchema) && !"INFORMATION_SCHEMA".equals(cSchema) );
                  } else if (dbType == CPSql.m_nMySQL) {
                    validTable = validTable && ( !"sys".equals(cSchema) && !"mysql".equals(cSchema) && !"INFORMATION_SCHEMA".equals(cSchema) );
                  }
                  if ( validTable ){
                    listTable.put(cTableName);
                  }
                }
                out.print(listTable.toString());
                rs.close();
                try {
                  CPPooler.FreeConnection(connId);
                } catch(Throwable cantFreeConnection) {
                  CPStdCounter.DatabaseError(cantFreeConnection);
                }
              }
              catch (SQLException e){
                try {
                  CPPooler.FreeConnection(connId);
                } catch(Throwable cantFreeConnection) {
                  CPStdCounter.DatabaseError(cantFreeConnection);
                }
                out.print("");
              }
            }
            catch (ConnectionNotAvailableException e){
              out.print("");
            }
          }
          else {
            out.print("");
          }
        }
        else out.print("");
      }
      else if ("columns".equals(pAction)){
        pServer=request.getParameter("server");

        if ("default".equals(pServer)) {
          pServer = status.context.GetServer("cptsrvr", true);
        } else {
          CPSql m_Sql = status.context.GetSql();
          String l_cServer = status.context.GetServer("cptsrvr", true);
          CPResultSet cprs = m_Sql.Query(l_cServer,"select ODBCDataSource from " + 
                                                status.context.GetPhName("cptsrvr") + 
                                                " where ServerName = " + CPLib.ToSQL(pServer, "C", 10, 0));
          if (!cprs.Eof()) {
            pServer = cprs.GetString("ODBCDataSource");
          } else {
            pServer = "";
          }
          cprs.Close();
        }
        pTable=request.getParameter("table");
        if (!Library.Empty(pServer) && ! Library.Empty(pTable)){
          int connId=-1;
          try{
            connId=CPPooler.ReserveConnection(pServer);
          }
          catch (ConnectionNotAvailableException e){
            out.print("");
          }
          CPResultSet cprs=null;
          CPSql m_Sql;
          m_Sql = status.context.GetSql();
          status.context.RedefineServer(pTable,pServer);
          cprs=m_Sql.Query(pServer,"select * from "+pTable+" where 0=1");
          JSONArray listColumn = new JSONArray();
          for (int i=1; i<=cprs.GetColumnCount(); i++) {
            if (!"cpccchk".equals(cprs.GetColumnName(i))){
              JSONObject tmpObj=new JSONObject();
              tmpObj.put("name",cprs.GetColumnName(i))
                    .put("type",cprs.GetColumnCPType(i))
                    .put("nullable",cprs.IsNullable(i));
               listColumn.put(tmpObj); 
            }
          }
          cprs.Close();
          status.context.RemoveRedefinedServer(pTable);
          out.print(listColumn.toString());
        }
      }
    }
  }
}