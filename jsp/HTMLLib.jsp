<%@ page import = "com.zucchetti.SPBridge.*" %>
<%@ page import = "com.zucchetti.PortalStudio.*" %>
<%@ page import = "com.zucchetti.sitepainter.*" %>

<%
	Sitepainter sp = new Sitepainter(request);
%>

  if (typeof TransDict == 'undefined') {
    TransDict = {};
  }

	TransDict['un mese fa'] = <%=Library.ToJSValue(sp.translate("un mese fa"), "C", 0, 0)%>;
	TransDict['%1 mesi fa'] = <%=Library.ToJSValue(sp.translate("%1 mesi fa"), "C", 0, 0)%>;
	TransDict['un giorno fa'] = <%=Library.ToJSValue(sp.translate("un giorno fa"), "C", 0, 0)%>;
	TransDict['%1 giorni fa'] = <%=Library.ToJSValue(sp.translate("%1 giorni fa"), "C", 0, 0)%>;
	TransDict['un\'ora fa'] = <%=Library.ToJSValue(sp.translate("un'ora fa"), "C", 0, 0)%>;
	TransDict['%1 ore fa'] = <%=Library.ToJSValue(sp.translate("%1 ore fa"), "C", 0, 0)%>;
	TransDict['un minuto fa'] = <%=Library.ToJSValue(sp.translate("un minuto fa"), "C", 0, 0)%>;
	TransDict['%1 minuti fa'] = <%=Library.ToJSValue(sp.translate("%1 minuti fa"), "C", 0, 0)%>;
	TransDict['adesso'] = <%=Library.ToJSValue(sp.translate("adesso"), "C", 0, 0)%>;