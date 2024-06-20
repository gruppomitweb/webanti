import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class menu extends SPServlet implements SPInvokable {
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    CPContext context;
    context = SPLib.GetContext(SPLib.GetContextID(request),request);
    String theme;
    theme = "../"+SPLib.GetTheme(context);
    if ( ! (context.IsLoggedIgnoreGuest())) {
      SPLib.LoginPage(servletContext,request,response,SPLib.GetSource(request).GetURL(),true);
      return;
    } else {
      SPLib.SetContentType(response);
      PrintWriter out;
      out = response.getWriter();
      out.println(
       "<html>" +
      "");
      out.println(
       "<head>" +
      "");
      out.println(
       "<title>" +
       "AntiRiciclaggio WEB" +
       "</title>" +
      "");
      out.println(
       "<script src='../stdFunctions.js' type='text/javascript'>" +
       "</script>" +
      "");
      out.println(
       "<script src='../controls.js' type='text/javascript'>" +
       "</script>" +
      "");
      out.println(
       "<script type='text/javascript'>" +
      "");
      out.println("var m_cThemePath;");
      out.println("m_cThemePath=" + SPLib.ToJSValue(theme,"C",0,0)+ ";");
      out.println(
       "</script>" +
      "");
      out.println(
       "<script src='"+theme+"/menuPage.js' type='text/javascript'>" +
       "</script>" +
      "");
      out.println(
       "<script type='text/javascript'>" +
      "");
      out.println("var m_nUserCode;");
      out.println("m_nUserCode=" + SPLib.ToJSValue(context.UserCode(),"C",0,0)+ ";");
      out.println("var m_GroupsList = "+"["+context.GetGroupsList()+"]"+";");
      out.println("var m_RolesList = "+"["+context.GetAuthority().GetCurrentAssignement().GetRoleNames()+"]"+";");
      out.println("var m_cCompany;");
      out.println("m_cCompany=" + SPLib.ToJSValue(context.GetCompany(),"C",0,0)+ ";");
      out.println("var m_cLanguage;");
      out.println("m_cLanguage=" + SPLib.ToJSValue(context.GetLanguage(),"C",0,0)+ ";");
      out.println("var m_cBrowser;");
      out.println("m_cBrowser=" + SPLib.ToJSValue(SPLib.GetBrowser(request),"C",0,0)+ ";");
      out.println("function itm(label,icon,link,childitems) {");
      out.println("this.label=label;");
      out.println("this.icon=icon;");
      out.println("this.link=link;");
      out.println("this.childitems=childitems;");
      out.println("this.getItemString=getHTMLString;");
      out.println("}");
      if (context.HasAdministeredUsers() && context.UserCode()<=0) {
        String cpanel;
        String changePassword;
        cpanel = "";
        changePassword = "";
        if (CPLib.IsAdministrator(context) ||  ! (context.HasAdministeredUsers())) {
          cpanel = ",i_cpanel";
        }
        if (context.HasAdministeredUsers() && context.UserCode()>0) {
          changePassword = ",i_changepassword";
        }
        out.println("var i_login = new itm("+SPLib.ToJSValue(context.Translate("MSG_MENU_LOGIN"),"C",0,0)+",'Login','cp_login target=main');");
        out.println("var i_logout = new itm("+SPLib.ToJSValue(context.Translate("MSG_MENU_LOGOUT"),"C",0,0)+",'Logout','cp_logout target=main');");
        out.println("var i_changepassword = new itm("+SPLib.ToJSValue(context.Translate("MSG_CHANGE_PASSWORD"),"C",0,0)+",'ChangePassword','SPChangePassword target=main');");
        out.println("var i_cpanel = new itm("+SPLib.ToJSValue(context.Translate("MSG_CONTROL_PANEL"),"C",0,0)+",'ControlPanel','SPControlPanel target=main');");
        out.println("var i_logGRP = new itm("+SPLib.ToJSValue(context.Translate("MSG_MENU_LOGIN_GROUP"),"C",0,0)+",'Group',null,[i_login,i_logout"+changePassword+cpanel+"]);");
        out.println("var items = [i_logGRP];");
        out.println("var Tot_items = 5;");
      } else {
        String cpanel;
        String changePassword;
        cpanel = "";
        changePassword = "";
        if (CPLib.IsAdministrator(context) ||  ! (context.HasAdministeredUsers())) {
          cpanel = ",i_cpanel";
        }
        if (context.HasAdministeredUsers() && context.UserCode()>0) {
          changePassword = ",i_changepassword";
        }
        out.println("var i_login = new itm("+SPLib.ToJSValue(context.Translate("MSG_MENU_LOGIN"),"C",0,0)+",'Login','cp_login target=main');");
        out.println("var i_logout = new itm("+SPLib.ToJSValue(context.Translate("MSG_MENU_LOGOUT"),"C",0,0)+",'Logout','cp_logout target=main');");
        out.println("var i_changepassword = new itm("+SPLib.ToJSValue(context.Translate("MSG_CHANGE_PASSWORD"),"C",0,0)+",'ChangePassword','SPChangePassword target=main');");
        out.println("var i_cpanel = new itm("+SPLib.ToJSValue(context.Translate("MSG_CONTROL_PANEL"),"C",0,0)+",'ControlPanel','SPControlPanel target=main');");
        out.println("var i_2 = new itm("+SPLib.ToJSValue(context.Translate("Intermediario"),"C",0,0)+",'Master','armt_intermbo target=main');");
        out.println("var i_3 = new itm("+SPLib.ToJSValue(context.Translate("Dipendenze"),"C",0,0)+",'Master','armt_anadip target=main');");
        out.println("var i_4 = new itm("+SPLib.ToJSValue(context.Translate("Intermediari Controparte"),"C",0,0)+",'Master','armt_intercon target=main');");
        out.println("var i_5 = new itm("+SPLib.ToJSValue(context.Translate("MacroAgente"),"C",0,0)+",'Master','armt_tbmacage target=main');");
        out.println("var i_7 = new itm("+SPLib.ToJSValue(context.Translate("Stati"),"C",0,0)+",'Master','armt_stati target=main');");
        out.println("var i_8 = new itm("+SPLib.ToJSValue(context.Translate("Città"),"C",0,0)+",'Master','armt_citta target=main');");
        out.println("var i_9 = new itm("+SPLib.ToJSValue(context.Translate("Divise"),"C",0,0)+",'Master','armt_divise target=main');");
        out.println("var i_10 = new itm("+SPLib.ToJSValue(context.Translate("Causali Sintetiche"),"C",0,0)+",'Master','armt_causalis target=main');");
        out.println("var i_11 = new itm("+SPLib.ToJSValue(context.Translate("Causali Analitiche"),"C",0,0)+",'Master','armt_causalia target=main');");
        out.println("var i_12 = new itm("+SPLib.ToJSValue(context.Translate("Ramo Gruppo"),"C",0,0)+",'Master','armt_ramogruppo target=main');");
        out.println("var i_13 = new itm("+SPLib.ToJSValue(context.Translate("Sottogruppi Att.Ec."),"C",0,0)+",'Master','armt_sgruattec target=main');");
        out.println("var i_14 = new itm("+SPLib.ToJSValue(context.Translate("Settorizzazione UIC"),"C",0,0)+",'Master','armt_settoreuic target=main');");
        out.println("var i_15 = new itm("+SPLib.ToJSValue(context.Translate("Tipo Registrazione"),"C",0,0)+",'Master','armt_tipreg target=main');");
        out.println("var i_16 = new itm("+SPLib.ToJSValue(context.Translate("Natura Conti"),"C",0,0)+",'Master','armt_natcon target=main');");
        out.println("var i_17 = new itm("+SPLib.ToJSValue(context.Translate("Tipi Legami"),"C",0,0)+",'Master','armt_tipileg target=main');");
        out.println("var i_18 = new itm("+SPLib.ToJSValue(context.Translate("Tipo Documento"),"C",0,0)+",'Master','armt_tipdoc target=main');");
        out.println("var i_19 = new itm("+SPLib.ToJSValue(context.Translate("Tipo Intermediario"),"C",0,0)+",'Master','armt_tipinte target=main');");
        out.println("var i_20 = new itm("+SPLib.ToJSValue(context.Translate("Utenti"),"C",0,0)+",'Master','armt_utenti target=main');");
        out.println("var i_21 = new itm("+SPLib.ToJSValue(context.Translate("Tipi Rapporti Agenzia Entrate"),"C",0,0)+",'Master','armt_tbrapp target=main');");
        out.println("var i_22 = new itm("+SPLib.ToJSValue(context.Translate("Tipo di condotta"),"C",0,0)+",'Master','armt_tbcondotta target=main');");
        out.println("var i_23 = new itm("+SPLib.ToJSValue(context.Translate("Aree Geografiche Destinazione"),"C",0,0)+",'Master','armt_tbareegeog target=main');");
        out.println("var i_24 = new itm("+SPLib.ToJSValue(context.Translate("Ragionevolezza Operazione"),"C",0,0)+",'Master','armt_tbplauso target=main');");
        out.println("var i_25 = new itm("+SPLib.ToJSValue(context.Translate("Modalità Svolgimento"),"C",0,0)+",'Master','armt_tbsvolgim target=main');");
        out.println("var i_26 = new itm("+SPLib.ToJSValue(context.Translate("Tipo Operazioni Agenzia Entrate"),"C",0,0)+",'Master','armt_tbtipope target=main');");
        out.println("var i_27 = new itm("+SPLib.ToJSValue(context.Translate("Tipo Attività Svolta"),"C",0,0)+",'Master','armt_tbtipatt target=main');");
        out.println("var i_28 = new itm("+SPLib.ToJSValue(context.Translate("Specie Giuridica"),"C",0,0)+",'Master','armt_tbspecie target=main');");
        out.println("var i_29 = new itm("+SPLib.ToJSValue(context.Translate("Tipologia Rischio"),"C",0,0)+",'Master','armt_tbtiporisc target=main');");
        out.println("var i_30 = new itm("+SPLib.ToJSValue(context.Translate("Rischio Importo"),"C",0,0)+",'Master','ammt_tbimporto target=main');");
        out.println("var i_31 = new itm("+SPLib.ToJSValue(context.Translate("Frequenza Operazione"),"C",0,0)+",'Master','ammt_tbdurata target=main');");
        out.println("var i_33 = new itm("+SPLib.ToJSValue(context.Translate("Anagrafica Persone/Società/Legali Rappresentanti"),"C",0,0)+",'Master','armt_personbo target=main');");
        out.println("var i_34 = new itm("+SPLib.ToJSValue(context.Translate("Anagrafica Rapporti"),"C",0,0)+",'Master','armt_anarap target=main');");
        out.println("var i_35 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni"),"C",0,0)+",'Master','armt_operazioni target=main');");
        out.println("var i_36 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni Frazionate"),"C",0,0)+",'Master','armt_ofrazionate target=main');");
        out.println("var i_37 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni S.A.R.A Società Quotate"),"C",0,0)+",'Master','armt_kperazbo target=main');");
        out.println("var i_38 = new itm("+SPLib.ToJSValue(context.Translate("Informazioni su rapporti"),"C",0,0)+",'Master','armt_informazioni target=main');");
        out.println("var i_40 = new itm("+SPLib.ToJSValue(context.Translate("Titolari Effettivi"),"C",0,0)+",'Master','armt_titolabo target=main');");
        out.println("var i_41 = new itm("+SPLib.ToJSValue(context.Translate("MTSTATI"),"C",0,0)+",'Master','armt_mtstati target=main');");
        out.println("var i_42 = new itm("+SPLib.ToJSValue(context.Translate("WU Import Analisys"),"C",0,0)+",'Master','armt_wu_chkerr target=main');");
        out.println("var i_43 = new itm("+SPLib.ToJSValue(context.Translate("WU Import Unicredit Errors"),"C",0,0)+",'Master','armt_wu_chkerr_unicr target=main');");
        out.println("var i_46 = new itm("+SPLib.ToJSValue(context.Translate("Anagrafica Rapporti Provvisori"),"C",0,0)+",'Master','armt_provanarap target=main');");
        out.println("var i_47 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni Provvisorie"),"C",0,0)+",'Master','armt_oprovvisorie target=main');");
        out.println("var i_48 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni Frazionarie Provvisorie"),"C",0,0)+",'Master','armt_frazioprov target=main');");
        out.println("var i_50 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimento Rapporti Pagina)"),"C",0,0)+",'Page','"+(SPLib.OtherThanServlet("arpg_trasfrap") ? "../arpg_trasfrap" : "arpg_trasfrap")+" target=main');");
        out.println("var i_51 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimento Rapporti (Routine)"),"C",0,0)+",'Batch','arrt_trasfrap target=main');");
        out.println("var i_52 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimento Operazioni (Pagina)"),"C",0,0)+",'Page','"+(SPLib.OtherThanServlet("arpg_trasfope") ? "../arpg_trasfope" : "arpg_trasfope")+" target=main');");
        out.println("var i_53 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimento Operazioni Frazionate (Pagina)"),"C",0,0)+",'Page','"+(SPLib.OtherThanServlet("arpg_trasffra") ? "../arpg_trasffra" : "arpg_trasffra")+" target=main');");
        out.println("var i_54 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimento Operazioni (Routine)"),"C",0,0)+",'Batch','arrt_trasfope target=main');");
        out.println("var i_55 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimento Operazioni Frazionate (Routine)"),"C",0,0)+",'Batch','arrt_trasffra target=main');");
        out.println("var i_56 = new itm("+SPLib.ToJSValue(context.Translate("Informazioni su rapporti"),"C",0,0)+",'Master','armt_provinformazioni target=main');");
        out.println("var i_57 = new itm("+SPLib.ToJSValue(context.Translate(" Titolare Effettivo (Provvisorio)"),"C",0,0)+",'Master','armt_xapotit target=main');");
        out.println("var i_59 = new itm("+SPLib.ToJSValue(context.Translate("Storico Anagrafica Rapporti"),"C",0,0)+",'Master','armt_storanarap target=main');");
        out.println("var i_60 = new itm("+SPLib.ToJSValue(context.Translate("Storico Operazioni"),"C",0,0)+",'Master','armt_storope target=main');");
        out.println("var i_61 = new itm("+SPLib.ToJSValue(context.Translate("Storico Operazioni Frazionate"),"C",0,0)+",'Master','armt_storfra target=main');");
        out.println("var i_62 = new itm("+SPLib.ToJSValue(context.Translate("Informazioni su rapporti"),"C",0,0)+",'Master','armt_storinformazioni target=main');");
        out.println("var i_64 = new itm("+SPLib.ToJSValue(context.Translate("Anagrafica Rapporti"),"C",0,0)+",'Master','armt_ae_anarap target=main');");
        out.println("var i_65 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni"),"C",0,0)+",'Master','armt_ae_operazbo target=main');");
        out.println("var i_66 = new itm("+SPLib.ToJSValue(context.Translate("Informazioni su rapporti"),"C",0,0)+",'Master','armt_ae_rapopebo target=main');");
        out.println("var i_67 = new itm("+SPLib.ToJSValue(context.Translate(" Informazioni Rapporti per Agenzia delle Entrate (DDR 2007/9647)"),"C",0,0)+",'MasterDetail','armd_anagrappo target=main');");
        out.println("var i_68 = new itm("+SPLib.ToJSValue(context.Translate("Deleghe"),"C",0,0)+",'Master','armt_ae_aedelrig target=main');");
        out.println("var i_69 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni Extra Conto"),"C",0,0)+",'Master','armt_ae_aeoprig target=main');");
        out.println("var i_75 = new itm("+SPLib.ToJSValue(context.Translate("CGO Operazioni Agenzie (DL Multi)"),"C",0,0)+",'Master','armt_cgo_oper_multi target=main');");
        out.println("var i_76 = new itm("+SPLib.ToJSValue(context.Translate("CGO Operazioni Agenzie"),"C",0,0)+",'Master','armt_snai_oper target=main');");
        out.println("var i_77 = new itm("+SPLib.ToJSValue(context.Translate("CGO Operazioni Agenzie (DL)"),"C",0,0)+",'Master','armt_cgo_oper target=main');");
        out.println("var i_78 = new itm("+SPLib.ToJSValue(context.Translate("CGO Causali"),"C",0,0)+",'Master','armt_cgo_causali target=main');");
        out.println("var i_79 = new itm("+SPLib.ToJSValue(context.Translate("Rapporti Scartati (CGO)"),"C",0,0)+",'Master','armt_cgo_rapporti_err target=main');");
        out.println("var i_80 = new itm("+SPLib.ToJSValue(context.Translate("Soggetti Scartati (CGO)"),"C",0,0)+",'Master','armt_cgo_personbo target=main');");
        out.println("var i_81 = new itm("+SPLib.ToJSValue(context.Translate("Operazioni Scartate (CGO)"),"C",0,0)+",'Master','armt_cgo_telematico_err target=main');");
        out.println("var i_82 = new itm("+SPLib.ToJSValue(context.Translate("Agenzie Scartate (CGO)"),"C",0,0)+",'Master','armt_cgo_anadip_err target=main');");
        out.println("var i_85 = new itm("+SPLib.ToJSValue(context.Translate("Portal Studio"),"C",0,0)+",'Page','"+(SPLib.OtherThanServlet("[target:_blank]portalstudio/portalstudio.jsp") ? "../[target:_blank]portalstudio/portalstudio.jsp" : "[target:_blank]portalstudio/portalstudio.jsp")+" target=main');");
        out.println("var i_logGRP = new itm("+SPLib.ToJSValue(context.Translate("MSG_MENU_LOGIN_GROUP"),"C",0,0)+",'Group',null,[i_login,i_logout"+changePassword+cpanel+"]);");
        out.println("var i_84 = new itm("+SPLib.ToJSValue(context.Translate("Analisi AOS"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_83 = new itm("+SPLib.ToJSValue(context.Translate("Riordina"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_74 = new itm("+SPLib.ToJSValue(context.Translate("CGO"),"C",0,0)+",'Group',null,[i_75,i_76,i_77,i_78,i_79,i_80,i_81,i_82]);");
        out.println("var i_73 = new itm("+SPLib.ToJSValue(context.Translate("Import Da ARIU_M"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_72 = new itm("+SPLib.ToJSValue(context.Translate("Import su tabelle"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_71 = new itm("+SPLib.ToJSValue(context.Translate("AOS"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_70 = new itm("+SPLib.ToJSValue(context.Translate("Archivi per elaborazioni"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_63 = new itm("+SPLib.ToJSValue(context.Translate("Registrazioni Agenzia delle entrate"),"C",0,0)+",'Group',null,[i_64,i_65,i_66,i_67,i_68,i_69]);");
        out.println("var i_58 = new itm("+SPLib.ToJSValue(context.Translate("Storico"),"C",0,0)+",'Group',null,[i_59,i_60,i_61,i_62]);");
        out.println("var i_49 = new itm("+SPLib.ToJSValue(context.Translate("Trasferimenti"),"C",0,0)+",'Group',null,[i_50,i_51,i_52,i_53,i_54,i_55]);");
        out.println("var i_45 = new itm("+SPLib.ToJSValue(context.Translate("Provvisorie"),"C",0,0)+",'Group',null,[i_46,i_47,i_48,i_49,i_56,i_57]);");
        out.println("var i_44 = new itm("+SPLib.ToJSValue(context.Translate("Tabelle per modifiche (SOL)"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_39 = new itm("+SPLib.ToJSValue(context.Translate("Import"),"C",0,0)+",'Group',null,[]);");
        out.println("var i_32 = new itm("+SPLib.ToJSValue(context.Translate("Anagrafiche"),"C",0,0)+",'Group',null,[i_33,i_34,i_35,i_36,i_37,i_38,i_39,i_40,i_41,i_42,i_43,i_44]);");
        out.println("var i_6 = new itm("+SPLib.ToJSValue(context.Translate("Tabelle di Base"),"C",0,0)+",'Group',null,[i_7,i_8,i_9,i_10,i_11,i_12,i_13,i_14,i_15,i_16,i_17,i_18,i_19,i_20,i_21,i_22,i_23,i_24,i_25,i_26,i_27,i_28,i_29,i_30,i_31]);");
        out.println("var i_1 = new itm("+SPLib.ToJSValue(context.Translate("Anagrafica Intermediari"),"C",0,0)+",'Group',null,[i_2,i_3,i_4,i_5]);");
        out.println("var items = [i_1,i_6,i_32,i_45,i_58,i_63,i_70,i_71,i_72,i_73,i_74,i_83,i_84,i_85,i_logGRP];");
        out.println("var Tot_items = 90;");
      }
      out.println(
       "</script>" +
      "");
      out.println(
       "</head>" +
      "");
      out.println(
       "<script type='text/javascript'>" +
      "");
      out.println("initMenuPage();");
      out.println(
       "</script>" +
      "");
      out.println(
       "</html>" +
      "");
    }
  }
}
