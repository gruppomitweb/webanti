<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<%
	boolean isMultipart = FileUpload.isMultipartContent(request);
	Sitepainter sp = new Sitepainter(request);

/***************** PARAMETRI ****************************
  Root:       directory di base per l'upload di file
  Directory:  percorso all'interno della directory Root
  mFileName:  nome del file (senza percorso) che viene ritornato (solo servlet)
********************************************************/

String Root = sp.getParameter("Root","");
String Directory = sp.getParameter("Directory","");
String mFileName = sp.getParameter("mFileName","");

%>
<html>
<title>Upload file</title>
<head>
<script type="text/javascript">
	var height = 250;
	var width = 500 ;
	window.resizeTo(width,height);
	var left = Math.ceil((screen.width - width) / 2);
	var top = Math.ceil((screen.height - height) / 2);
  var caller=null,eventSrcID=(window.ZtVWeb && ZtVWeb.UID)||(window.location.origin + window.location.pathname + window.location.search);
  try{
    if(opener && opener.ZtVWeb){
      caller=opener;
    }
  }catch(e){}
  if(!caller && frameElement && parent.ZtVWeb){
    caller=parent;
  }
  if (caller){
    if (window.LibJavascript){
      LibJavascript.Events.addEvent(window,"unload",function(){
      caller.ZtVWeb.purgeEventsCache(eventSrcID);
    }
  }  
	window.moveTo(left,top);
	if (navigator.userAgent.indexOf("MSIE 7") > -1){
		window.resizeBy(0,20);
	}
	// Funzione di controllo prima di eseguire il SUBMIT del form
	function checkForm(){
		// Controlla se è stato selezionato un file
		if (formUpload.file1.value == ""){
			alert("E' necessario selezionare un file prima di eseguire l'upload!");
			return false;
		}
		uploading();
		return true;
	}
	// Funzione che visualizza la barra di scorrimento e nasconde il pulsante upload
	function uploading(){
		document.getElementById("progressBarImage").style.display = "block";
		document.getElementById("divUpload").style.display = "block";
		try{
			document.getElementById("buttonMultiUpload").style.display = "none";
		}
		catch(e){}
	}

	// Funzione che copia il contenuto dell'iframe "frameUpload" sul parent
	function copyToParent(){
		parent.document.body.innerHTML = document.body.innerHTML;
	}
</script>
<style>
</style>
<link rel='stylesheet' href='../<%=sp.getTheme()%>/portalstudio.css' type='text/css'>
</head>
<%
	// Controllo che l'utente abbia eseguito la login
	//if (sp.getGlobal("g_UserCode",0) > 0){
	if (sp.getUserCode() > 0) {
		String realPath = "";
		String tempPath = "";
		String fileName = "";
		// Controllo se ci sono dei file da copiare sul server
		if (isMultipart){
			//tempPath = sp.getGlobal("g_PathInst","") + "WEB-INF/update/in";
			realPath = application.getRealPath("/");
			//System.out.println("realPath:"+realPath);
			if(Root.compareTo("") != 0) {
				//System.out.println("Root 2:"+Root);
				tempPath = realPath+Root+File.separator;
				if(Directory.compareTo("") != 0) {
					tempPath = tempPath+Directory;
				}
			}
			//System.out.println("tempPath:"+tempPath);
			File uploadDir=new File(tempPath);
			boolean bOk=true;
			try {
				//SPLib.GetWebRootPath(); // + "WEB-INF/update/in";
				DiskFileUpload upload = new DiskFileUpload();
				List items = upload.parseRequest(request);
				Iterator itr = items.iterator();
				// Ora controlliamo tutti gli item presenti
				// salvando tutti i file che sono stati inviati
				while(itr.hasNext()) {
				 FileItem item = (FileItem) itr.next();
				 if(!item.isFormField() && !item.getName().equalsIgnoreCase("")) {
					fileName = item.getName().replace("\\","/");
					fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
					// Salvataggio file nella cartella temporanea WEB-INF/update/in del contesto
					File savedFile = new File(tempPath, fileName);
					item.write(savedFile);
				 }
				}
			} catch(IOException e) {
				bOk=false;
%>
        		   <body topmargin="4px" leftmargin="0" scroll="no" style="border: 0px; background-color:#F9F9F9">
        		     <center>
        			<font face="Verdana" size="2">Il percorso specificato per l'upload non esiste!</font>
        			<br><br>
        			<input type="button" value="Chiudi" class="button" onClick="javascript:window.close();">
        		     </center>
        		   </body>
				   <script>			 
				   copyToParent();
			       </script> 
<%
            }
			if (bOk) {
%>
			<body topmargin="4px" leftmargin="0" scroll="no" style="border: 0px; background-color:#F9F9F9">
			<center>
				<font face="Verdana" size="2">Upload file terminato</font>
				<br><br>
				<input type="button" value="Chiudi" class="button" onClick="javascript:window.close();">
				</center>
			</body>
           <script>		
	        if ('<%=mFileName%>'=='') {
				//alert('cacchione')
				var parms={NomeFile:'<%=fileName%>'};
				caller.ZtVWeb.raiseEvent('Refresh',parms);
			 } else {
			 	//alert('cacchi')
                // esiste il parametro
				try {
					miavar="caller.Set_<%=mFileName%>('<%=fileName%>')"
					eval(miavar)
				} catch(e) {
				   miavar="caller.w_<%=mFileName%>='<%=fileName%>'"
				   eval(miavar)
				}					
			 }
			 copyToParent();
			</script>
<%
		}
		} else {
%>
		<body style="background-color:#F9F9F9;">
			<div id="divUpload" style="display:none;position:absolute;z-index:100;background-color:#F9F9F9;width:100%;height:100%;filter:alpha(opacity=30);moz-opacity:.30;opacity:.30">&nbsp;</div>
			<iframe src="nulla_portlet.jsp" name="frameUpload" style="display:none"></iframe>
			<form name="formUpload" target="frameUpload" enctype="multipart/form-data" method="post" action="sp_upload.jsp?Root=<%=Root%>&Directory=<%=Directory%>&mFileName=<%=mFileName%>" onSubmit="return checkForm()">
				<input type="file" name="file1" class="textbox" size="51" style="height:18px" title="Premere per selezionare un file">
				<input type="submit" id="buttonSingleUpload" value="Upload" class="button" title="Premere per eseguire l'upload del file">
				<img id="progressBarImage" title="Upload in corso ..." src="../images/progressbar.gif" border="0" style="display:none;position:relative;bottom:-2px" />
			</form>
		</body>
<%
		}
	}
	else{
		// L'utente non ha eseguito la login o la sessione è scaduta
%>

		<body topmargin="4px" leftmargin="0" scroll="no" style="border: 0px; background-color:#F9F9F9">
			<center>
				<font face="Verdana" size="2">E' necessario eseguire la login!</font>
				<br><br>
				<input type="button" value="Chiudi" class="button" onClick="javascript:window.close();">
			</center>
		</body>

<%
	}
%>
</html>