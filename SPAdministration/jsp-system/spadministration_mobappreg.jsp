<%@ page extends="com.zucchetti.PortalStudio.PortalStudioBase"
%><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%

    response.setHeader("Access-Control-Allow-Origin", "*");

    Sitepainter sp = new Sitepainter(request);
	boolean isOnline;
	try{
		isOnline = Boolean.valueOf(sp.getParameter("isOnline","false"));	
	}catch(Exception e){
		response.sendError(400, "invalid isOnline param");
		return;
	}
	String code = sp.getParameter("code","");
    String e_mail = sp.getParameter("e_mail","");
    String fullname = sp.getParameter("fullname","");
    String company = sp.getParameter("company","");
    String note = sp.getParameter("note","");
    String appurl = sp.getParameter("appurl","");

    ArrayList<Object> arrayParam = new ArrayList<Object>();
    // attenzione all'ordine dei parametri
	arrayParam.add(isOnline);
	arrayParam.add(code);
    arrayParam.add(e_mail);
    arrayParam.add(fullname);
    arrayParam.add(company);
    arrayParam.add(note);
    arrayParam.add(appurl);

    // per funzioni sp.callFunction("","spas_freg", arrayParam);
    // per funzioni che ritornano object
    // Object myobject=sp.callFunction("spas_freg", arrayParam);
    //sp.callRoutine("spas_breg", arrayParam);
    String cResult=sp.callFunction("","spas_freg", arrayParam);
%>