import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FilenameFilter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.zucchetti.sitepainter.Library.Empty;
import com.zucchetti.sitepainter.Library;
import com.zucchetti.SPBridge.SPJSPBridge;

public class SPDBAdministration extends SPServlet implements SPInvokable {
  static public class ServletStatus extends SPPageServletStatus {
  }

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    entityGlobals.name = "SPDBAdministration";
    entityGlobals.userName = "SPDBAdministration";
  }

  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    ServletStatus status = new ServletStatus();
    SPParameterSource source = SPLib.GetSource(request);
    status.request=request;
    status.response=response;
    status.containing = this;
    status.context = SPLib.GetContext(SPLib.GetContextID(request), request);
    status.m_cTheme = SPLib.GetTheme(status.context);
    status.m_cBrowser = SPLib.GetBrowser(request);
    SPLib.SetContentType(response);
    status.out=response.getWriter();

    status.out.println("<!DOCTYPE html>");
    status.out.println("<html>");
    status.out.println("<head>");
    status.out.println("<title>"+status.context.Translate("ADMIN_DATABASE_ADMINISTRATION")+"</title>");
    status.out.println("<link type='text/css' rel='stylesheet' href='../portalstudio/portalstudioTheme.css'>");
    status.out.println("<script src='../stdFunctions.js'></script>");
    status.out.println("<script src='../controls.js'></script>");
    status.out.println("<script>");
    status.out.println("function PlatformPathStart(p_cName) {");
    status.out.println("return p_cName;");
    status.out.println("}");
    status.out.println("function ShowLoading() {");
    status.out.print  ("  document.body.innerHTML = ");
    status.out.print  ("'<div class=\"standalone-page\"><div><div class=\"standalone-container\" id=\"loading\">' + ");
    status.out.print  ("'<h1>"+Library.ToJSValue(status.context.Translate("ADMIN_PLEASE_WAIT"),"C",0,0,true,false)+"</h1>' + ");
    status.out.print  ("'<div><p>"+Library.ToJSValue(status.context.Translate("ADMIN_DATABASE_RUNNING"),"C",0,0,true,false)+"<br>"+Library.ToJSValue(status.context.Translate("ADMIN_PLEASE_WAIT"),"C",0,0,true,false)+"...</p>' + ");
    status.out.print  ("'<i class=\"mi mi-spinner mi-spin\"></i></div>' + ");
    status.out.println("'</div></div></div>';");
    status.out.println("}");
    status.out.println("function CloseLoading() {");
    status.out.println("if(Ctrl('loading')!=null)");
    status.out.println("Ctrl('loading').style.visibility='hidden'");
    status.out.println("}");
    status.out.println("var m_cCaption = "+SPLib.ToJSValue(status.context.Translate("ADMIN_DATABASE_ADMINISTRATION"),"C",0,0)+";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cFunction = 'dbadm';");
    status.out.println("</script>");
    status.out.println("<script src='../"+status.m_cTheme+"/styleVariables.js'></script>");
    status.out.println("<script src='../"+status.m_cTheme+"/calendar.js'></script>");
    status.out.println("<script src='../"+status.m_cTheme+"/calculator.js'></script>");
    status.out.println("<style>");
    status.out.println("p.black {padding-top:0px; padding-bottom:0px; margin:0px; font-size:11px;}");
    status.out.println("p.redFont {padding-top:0px; padding-bottom:0px; margin:0px; font-size:11px; color:red;}");
    status.out.println("p.red::before {content: '\\F048'; font-family: 'icons8_win10'; color: #F22613; margin-right: 8px;}");
    status.out.println("p.green::before {content: '\\EF8B'; font-family: 'icons8_win10'; color: #87D37C; margin-right: 8px;}");
    status.out.println(".dblist {margin-top: 30px; text-align:left; padding: 0 30px;}");
    status.out.println(".dblist p {margin: 5px 0; font-size: 14px;}");
    status.out.println(".dblist p.result {text-align: center; margin: 30px 0 15px; font-size: 16px;}");
    status.out.println(".standalone-container {width: 80%; max-width: 80%;}");
    status.out.println("#importData { vertical-align: baseline; display: inline-block; }");
    status.out.println("</style>");
    status.out.println("<body onunload='DoOnUnLoad()' onload='DoOnLoad()' style='overflow: auto' >");
    status.out.println("</head>");
    status.out.println("<div class='standalone-page'><div><div class='standalone-container'>");
    status.out.println("<h1>Administration</h1>");


    if (!CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("<script>");
      status.out.println("function DoOnLoad() {");
      status.out.println("}");
      status.out.println("function DoOnUnLoad() {");
      status.out.println("}");
      status.out.println("</script>");
      status.out.println("<p>"+status.context.Translate("MSG_ACC_NOT_ALLOWED")+"</p>");
    }
    else {
      String result;
      boolean administrated=false;
      //action indica l'operazione da eseguire
      String action = source.GetParameter("action", "dbadmin");
      //forceExecute obbliga il DBAdm a eseguire l'amministrazione ignorando che la data del plan non e' cambiata
      boolean forceExecute = source.GetParameter("force", false);
      //showSql indica se visualizzare o meno il codice eseguito nul database
      boolean showSql = source.GetParameter("showsql", true);
      String initializeDataFrom = status.context.GetInitializeDataFrom();
      String defaultFrom = ( source.GetParameter("importData", false) ? initializeDataFrom : "");
      String importDataFromConfig = source.GetParameter("importDataFrom",defaultFrom);

      DBAdm dbadm = new DBAdm(status.context, new SPXDCReaderFactory(status.context.GetInstance()), SPLib.GetClassesPath(servletContext), action);

      if (!"".equals(importDataFromConfig) && !status.context.GetInstance().equals(importDataFromConfig) && !"".equals(CPPooler.GetServer(importDataFromConfig))) {
        dbadm.setImportDataFrom(importDataFromConfig,source.GetParameter("RemoveExistingData",false));
      }
      if ("dbadmin_preview".equals(action)) {
        String modifiedXDCFiles = CPLib.MustAdmin(status.context, new SPXDCReaderFactory(status.context.GetInstance()), SPLib.GetClassesPath(servletContext));


        status.out.println("<script>");
        status.out.println("function RunDBAdmin(executeDBAdminRoutines) {");
        status.out.println(" var params = '?action=dbadmin&runBatch='+executeDBAdminRoutines");
        if (!CPLib.Empty( initializeDataFrom )) {
          status.out.println(" if (document.getElementById('importData').checked) { params += '&importData=true'; }");
        }
        // il metodo ShowLoading svuota il contenuto del body, quindi e' necessario valutare prima eventuali proprieta' definite
        status.out.println(" ShowLoading();");
        status.out.println(" window.location.href='../servlet/SPDBAdministration'+params;");
        status.out.println("}");
        status.out.println("function DoOnLoad() {");
        if (Empty(modifiedXDCFiles)) try {
          if (SPJSPBridge.MustAdmin(status.context)) {
            modifiedXDCFiles = "ALL";
          }
        } catch(Exception signal) {
          CPStdCounter.Error(signal);
        }
        if (CPLib.eq(modifiedXDCFiles, "ALL") && !CPLib.Empty( initializeDataFrom )) {
          modifiedXDCFiles += "_TOINIT";
        }
        if (CPLib.Empty(modifiedXDCFiles)) {
          status.out.println("RunDBAdmin(false);");
        }
        else if (CPLib.eq(modifiedXDCFiles, "ALL")) {
          status.out.println("RunDBAdmin(true);");
        }
        status.out.println("}");
        status.out.println("function DoOnUnLoad() {");
        status.out.println("}");
        status.out.println("</script>");

        if (!(CPLib.Empty(modifiedXDCFiles) || CPLib.eq(modifiedXDCFiles, "ALL"))) {
          if ( ! CPLib.eq(modifiedXDCFiles, "ALL_TOINIT") ) {
            status.out.print("<h2>"+status.context.Translate("ADMIN_MODIFIED_XDC_FILES")+":</h2>");
            status.out.println(modifiedXDCFiles);
          }
          status.out.println("<div class='group-button'>");
          status.out.println("<span class='normal-button' title='"+status.context.Translate("CP_RUN_DATABASE_ADMIN")+"' onclick='RunDBAdmin(true)'>"+status.context.Translate("ADMIN_DATABASE_RUN")+"</span>");
          if (!CPLib.Empty( initializeDataFrom )) {
            status.out.println("<div><input id='importData' type='checkbox' name='importData' value='true'><label for='importData'>"+status.context.Translate("ADMIN_DATABASE_IMPORT_FROM_INSTANCE")+"</label></div>");
          }
          status.out.println("<span class='normal-button gray-button' title='"+status.context.Translate("ADMIN_DATABASE_CANCEL")+"' onclick='window.close()'>"+status.context.Translate("ADMIN_CANCEL")+"</span>");
          status.out.println("</div>");
        }
      }
      else if ("dbadmin".equals(action) || "createcompany".equals(action) || "script".equals(action)) {
        //se viene passato il nome di un'azienda, amministro le tabelle solo di quella azienda
        String company = source.GetParameter("codazi", ""),
               companyDesc = source.GetParameter("desazi", "");
        boolean executeDBAdminRoutines = source.GetParameter("runBatch", true),
                scriptOnly = "script".equals(action);

        if (scriptOnly) {
          forceExecute = true;
        }

        status.out.println("<div class=\"dblist\">");
        if(CPLib.GetDBAdminRunning(status.context.GetInstance())){
          status.out.println(status.context.Translate("ADMIN_DATABASE_ALREADY_RUNNING")+"!");
        }
        else {
          String dbUser = source.GetParameter("dbUser","");
          String dbPassword = source.GetParameter("dbPassword","");
          // if(dbadm.AdminDatabase(forceExecute, company, companyDesc, "script".equals(action), executeDBAdminRoutines,status.out)){
          if(dbadm.AdminDatabase(forceExecute, company, companyDesc, "script".equals(action), executeDBAdminRoutines,status.out, dbUser, dbPassword)){
            if(!scriptOnly && showSql){
              result = dbadm.GetExecutedText();
              if(CPLib.Empty(result)){
                result = "<p class='result'>"+status.context.Translate("ADMIN_DATABASE_NO_OPERATION")+".</p>";
              }
              else if (CPLib.eq(result, "ERROR_DB_LOGIN")) {
                result = "<p class='result'>"+status.context.Translate("ADMIN_DATABASE_ERROR_LOGIN")+".</p>";
                result += "<form id='formSubmit' action='../servlet/SPDBAdministration' method='post'>"+
                            "<input type='hidden' name='force' value='true'>"+
                            //"<label for='dbUser'>DB Username:</label>"+
                            "<input type='text' name='dbUser' placeholder='DB Username'><br/>"+
                            //"<label for='dbPassword'>DB Password:</label>"+
                            "<input type='password' name='dbPassword' placeholder='DB Password'><br/>"+
                            "<button type='submit' value='"+status.context.Translate("CP_RUN_DATABASE_ADMIN")+"'>"+
                            status.context.Translate("ADMIN_DATABASE_RUN")+"</button>"+
                          "</form>";
              }
              else if (CPLib.eq(result, "NOT_RUN")) {
                result = "<p class='result'>"+status.context.Translate("ADMIN_DATABASE_DESIGN_NOT_MODIFIED")+". <a href=\"javascript:ForceDBAdmin()\">"+status.context.Translate("ADMIN_DATABASE_RUN_ANYWAY")+"</a>.</p>";
              }
              else if (CPLib.eq(result, "ERROR_REGISTRY")) {
                result = "";
                status.out.println("<p class='result'>"+status.context.Translate("ADMIN_DATABASE_NOT_COMPLETE")+"</p>");
                com.zucchetti.PortalStudio.JSPLib.PutMustAdminDatabase(status.context.GetInstance(),false);
              }
              else {
                if (CPLib.eq(result, "DO_SOMETHING")) result="";
                administrated=true;
              }

              status.out.println(result);

              if(administrated){
                status.out.println("<p class='result'>"+status.context.Translate("ADMIN_DATABASE_COMPLETE")+"</p>");
                com.zucchetti.PortalStudio.JSPLib.PutMustAdminDatabase(status.context.GetInstance(),false);
              }
            }
            else {
              status.out.println("<p class='result'>");
              status.out.println(status.context.Translate("System tables created")+"<br>");
              status.out.println(status.context.Translate("Database administration script created"));
              status.out.println("</p>");
            }

            com.zucchetti.SPBridge.Sitepainter sp = new com.zucchetti.SPBridge.Sitepainter(request);
            sp.resetAdminPageShowed("db");
            try {
              CPPooler.ReloadTableNames2();
            } catch(Exception e) {
            }
          }
          else {
            if(showSql){
              status.out.println(status.context.Translate("ADMIN_DATABASE_NOT_COMPLETE"));
            }
          }
        }
        status.out.println("</div>");

        if(!CPLib.Empty(company)){
          status.out.println("<div>");
          status.out.println("<span id='SPAdminClose' class='normal-button gray-button' title='"+status.context.Translate("ADMIN_CLOSE_CONTINUE")+"' onclick='SPAdminCompaniesContinue()'>"+status.context.Translate("ADMIN_CONTINUE")+"</span>");
          status.out.println("</div>");
          status.out.println("<script>");
          status.out.println("function SPAdminCompaniesContinue() {");
          status.out.println("window.close();");
          status.out.println("}");
          status.out.println("function DoOnLoad() {");
          status.out.println("CloseLoading();");
          status.out.println("}");
          status.out.println("function DoOnUnLoad() {");
          status.out.println("window.opener.location.href = '../servlet/SPManageCompanies';");
          status.out.println("}");
          status.out.println("window.resizeTo(630, 470)");
          status.out.println("</script>");
        }
        else {
          status.out.println("<div>");
          status.out.println("<span id='SPAdminClose' class='normal-button gray-button' title='"+status.context.Translate("ADMIN_CLOSE")+"' onclick='window.close()'>"+status.context.Translate("ADMIN_CLOSE")+"</span>");
          status.out.println("</div>");
          status.out.println("<script>");
          status.out.println("function DoOnLoad() {");
          status.out.println("CloseLoading();");
          status.out.println("}");
          status.out.println("function DoOnUnLoad() {");
          status.out.println("}");
          status.out.println("function DBAdminWithUserAndPassword() {");
          status.out.println(" document.getElementById('formSubmit').style.display='block'");
          status.out.println("}");
          status.out.println("function ForceDBAdmin() {");
          status.out.println("ShowLoading();");
          status.out.println("window.location.href='../servlet/SPDBAdministration?force=true';");
          status.out.println("}");
          status.out.println("</script>");
        }
        status.out.println("<br>");
      }
      else if ("systemtables".equals(action)) { //Create System Tables
        status.out.println("<div>");

        if (dbadm.AdminSystemTables()) {
          if (showSql) {
            result = dbadm.GetExecutedText();
            status.out.println("<p>");
            if (CPLib.Empty(result)) {
              status.out.println("<br>"+status.context.Translate("System tables created successfully")+".<br>");
            }
            else if (CPLib.eq(result, "NOT_RUN")) {
              status.out.println("<br>"+status.context.Translate("System tables already exist")+".<br>");
            }
            else {
              status.out.println("<br>"+CPLib.Strtran(result, "\n", "<br>"));
            }
            status.out.println("</p>");
          }
        }
        status.out.println("</div>");
        status.out.println("<div>");
        status.out.println("<span id='SPAdminClose' class='normal-button gray-button' title='"+status.context.Translate("ADMIN_CLOSE")+"' onclick='window.close()'>"+status.context.Translate("ADMIN_CLOSE")+"</span>");
        status.out.println("</div>");
        status.out.println("<script>");
        status.out.println("function DoOnLoad() {");
        status.out.println("}");
        status.out.println("function DoOnUnLoad() {");
        status.out.println("window.opener.location.href = window.opener.w_entity;");
        status.out.println("}");
        status.out.println("</script>");
      }
      else if ("deletecompany".equals(action)) { //Delete Company
        String company = source.GetParameter("codazi", "");
        status.out.println("<div>");

        if (dbadm.DeleteCompany(company)) {
          result = dbadm.GetExecutedText();

          try {
            CPPooler.ReloadTableNames2();
          } catch(Exception e) {
          }
        }
        else {
          result = status.context.Translate("Errors while deleting company")+".";
        }
        status.out.println("<p>");
        status.out.println("<br>"+CPLib.Strtran(result, "\n", "<br>"));
        status.out.println("</p>");
        status.out.println("</div>");
        status.out.println("<div>");
        status.out.println("<span id='SPAdminClose' class='normal-button gray-button' title='"+status.context.Translate("ADMIN_CLOSE_CONTINUE")+"' onclick='window.close()'>"+status.context.Translate("ADMIN_CONTINUE")+"</span>");
        status.out.println("</div>");
        status.out.println("<script>");
        status.out.println("function DoOnLoad() {");
        status.out.println("}");
        status.out.println("function DoOnUnLoad() {");
        status.out.println("window.opener.location.href = '../servlet/SPManageCompanies';");
        status.out.println("}");
        status.out.println("</script>");
        status.out.println("<br>");
      }
      else if ("addlanguage".equals(action)) { //Adds a new language
        status.out.println("<div>");

        if (dbadm.AdminDatabase(true, "", "", false, false)) {
          result = dbadm.GetExecutedText();

          if (CPLib.Empty(result)) {
            result = status.context.Translate("ADMIN_DATABASE_NO_OPERATION")+".";
          }
          else {
            administrated=true;
          }

          if (administrated) {
            status.out.println("<p>"+status.context.Translate("Language added successfully")+"</p>");
          }

          try {
            CPPooler.ReloadTableNames2();
          } catch(Exception e) {
          }
        }
        else {
          result = status.context.Translate("Errors while adding language")+".";
        }
        status.out.println("<div>");
        status.out.println("<span id='SPAdminClose' class='normal-button gray-button' title='"+status.context.Translate("ADMIN_CLOSE_CONTINUE")+"' onclick='SPAdminLanguagesContinue()'>"+status.context.Translate("ADMIN_CONTINUE")+"</span>");
        status.out.println("</div>");
        status.out.println("<script>");
        status.out.println("function SPAdminLanguagesContinue() {");
        status.out.println("window.close();");
        status.out.println("}");
        status.out.println("function DoOnLoad() {");
        status.out.println("CloseLoading();");
        status.out.println("}");
        status.out.println("function DoOnUnLoad() {");
        status.out.println("window.opener.location.href = '../servlet/SPManageLanguages';");
        status.out.println("}");
        status.out.println("</script>");
      }
    }
    status.out.println("</div></div></div>");
    status.out.println("</body>");
    status.out.println("</html>");
  }
}
