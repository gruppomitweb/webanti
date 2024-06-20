// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_ae_operazboBO extends armt_ae_operazboBL {
  class SqlLoader {
    public boolean m_bLink_1_16 = false;
    public boolean m_bLink_1_21 = false;
    public boolean m_bLink_1_22 = false;
    public boolean m_bLink_1_24 = false;
    public boolean m_bLink_1_27 = false;
    public boolean m_bLink_1_28 = false;
    public boolean m_bLink_1_35 = false;
    public boolean m_bLink_1_39 = false;
    public boolean m_bLink_1_49 = false;
    public boolean m_bLink_1_51 = false;
    public boolean m_bLink_1_162 = false;
    public boolean m_bLink_2_18 = false;
    public boolean m_bLink_2_29 = false;
    public boolean m_bLink_2_30 = false;
    public boolean m_bLink_2_31 = false;
    public boolean m_bLink_2_32 = false;
    public boolean m_bLink_2_55 = false;
    public boolean m_bLink_2_56 = false;
    double m_nColumns = 0;
    CPSql m_Sql;
    String m_cServer;
    String m_cMainTable;
    String m_cSelect;
    String m_cFrom;
    String m_cAlias;
    String m_cWhere;
    String m_cOrderBy;
    public SqlLoader(CPSql sql,String server,String from,String alias,String where,String orderby) {
      m_cAlias = alias;
      m_Sql = sql;
      m_cServer = server;
      m_cMainTable = alias;
      m_cSelect = m_cAlias+".*";
      m_cFrom = from+" "+m_cAlias;
      m_cWhere = where;
      m_cOrderBy = orderby;
    }
    public void AddJoinedLink_1_16(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_16.CODVAL AS CODVAL116";
        m_cSelect = m_cSelect+" ,link_1_16.DESCRI AS DESCRI116";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_16","VALUTA","CODVAL");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_16","VALUTA","CODVAL",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_16 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_21(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_21.RAPPORTO AS RAPPORTO121";
        m_cSelect = m_cSelect+" ,link_1_21.DESCRAP AS DESCRAP121";
        m_cSelect = m_cSelect+" ,link_1_21.TIPORAP AS TIPORAP121";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_21","RAPPORTO","RAPPORTO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_21","RAPPORTO","RAPPORTO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_21 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_22(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_22.CONNES AS CONNES122";
        m_cSelect = m_cSelect+" ,link_1_22.RAGSOC AS RAGSOC122";
        m_cSelect = m_cSelect+" ,link_1_22.CODFISC AS CODFISC122";
        m_cSelect = m_cSelect+" ,link_1_22.DATAVALI AS DATAVALI122";
        m_cSelect = m_cSelect+" ,link_1_22.DATARILASC AS DATARILASC122";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_22","CONNESCLI","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_22","CONNESCLI","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_22 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_24(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_24.CONNES AS CONNES124";
        m_cSelect = m_cSelect+" ,link_1_24.RAGSOC AS RAGSOC124";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_24","CONNESOPER","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_24","CONNESOPER","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_24 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_27(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_27.CONNES AS CONNES127";
        m_cSelect = m_cSelect+" ,link_1_27.RAGSOC AS RAGSOC127";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_27","CONNESBEN","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_27","CONNESBEN","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_27 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_28(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_28.CONNES AS CONNES128";
        m_cSelect = m_cSelect+" ,link_1_28.RAGSOC AS RAGSOC128";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_28","CONNALTRO","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_28","CONNALTRO","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_28 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_35(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_35.CODSTA AS CODSTA135";
        m_cSelect = m_cSelect+" ,link_1_35.DESCRI AS DESCRI135";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_35","C_STA","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_35","C_STA","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_35 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_39(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_39.CODSTA AS CODSTA139";
        m_cSelect = m_cSelect+" ,link_1_39.DESCRI AS DESCRI139";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_39","PAESE","CODSTA");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_39","PAESE","CODSTA",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_39 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_49(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_49.CODINTER AS CODINTER149";
        m_cSelect = m_cSelect+" ,link_1_49.DATANASC AS DATANASC149";
        m_cSelect = m_cSelect+" ,link_1_49.CODCAB AS CODCAB149";
        m_cSelect = m_cSelect+" ,link_1_49.PROVINCIA AS PROVINCIA149";
        m_cSelect = m_cSelect+" ,link_1_49.DESCCIT AS DESCCIT149";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_49","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_49","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_49 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_51(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_51.CODDIP AS CODDIP151";
        m_cSelect = m_cSelect+" ,link_1_51.DESCRIZ AS DESCRIZ151";
        m_cSelect = m_cSelect+" ,link_1_51.DESCCIT AS DESCCIT151";
        m_cSelect = m_cSelect+" ,link_1_51.PROVINCIA AS PROVINCIA151";
        m_cSelect = m_cSelect+" ,link_1_51.CAB AS CAB151";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_51","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_51","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_51 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_162(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_162.CODVOC AS CODVOC262";
        m_cSelect = m_cSelect+" ,link_1_162.DESCRIZ AS DESCRIZ262";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_162","CODVOC","CODVOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_162","CODVOC","CODVOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_162 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_18(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_18.CODICE AS CODICE218";
        m_cSelect = m_cSelect+" ,link_2_18.DESCRI AS DESCRI218";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_18","OPERAG","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_18","OPERAG","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_18 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_29(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_29.CODICE AS CODICE229";
        m_cSelect = m_cSelect+" ,link_2_29.DESCRI AS DESCRI229";
        m_cSelect = m_cSelect+" ,link_2_29.RISCHIO AS RISCHIO229";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_29","AREAGEO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_29","AREAGEO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_29 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_2_30(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_30.CODICE AS CODICE230";
        m_cSelect = m_cSelect+" ,link_2_30.DESCRI AS DESCRI230";
        m_cSelect = m_cSelect+" ,link_2_30.RISCHIO AS RISCHIO230";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_30","MODSVOL","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_30","MODSVOL","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_30 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_2_31(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_31.CODICE AS CODICE231";
        m_cSelect = m_cSelect+" ,link_2_31.DESCRI AS DESCRI231";
        m_cSelect = m_cSelect+" ,link_2_31.RISCHIO AS RISCHIO231";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_31","RAGIO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_31","RAGIO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_31 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_2_32(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_32.CODICE AS CODICE232";
        m_cSelect = m_cSelect+" ,link_2_32.DESCRI AS DESCRI232";
        m_cSelect = m_cSelect+" ,link_2_32.RISCHIO AS RISCHIO232";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_32","TIPO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_32","TIPO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_32 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_2_55(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_55.CODICE AS CODICE255";
        m_cSelect = m_cSelect+" ,link_2_55.DESCRI AS DESCRI255";
        m_cSelect = m_cSelect+" ,link_2_55.RISCHIO AS RISCHIO255";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_55","DURAT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_55","DURAT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_55 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_2_56(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_56.CODICE AS CODICE256";
        m_cSelect = m_cSelect+" ,link_2_56.DESCRI AS DESCRI256";
        m_cSelect = m_cSelect+" ,link_2_56.RISCHIO AS RISCHIO256";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_56","AMMONT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_56","AMMONT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_56 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public CPResultSet Query() {
      String l_cWhere = QueryFilter(m_Ctx);
      if (CPLib.Empty(l_cWhere)) {
        l_cWhere = m_cWhere;
      } else {
        if ( ! (CPLib.Empty(m_cWhere))) {
          l_cWhere = "("+m_cWhere+") and ("+l_cWhere+")";
        }
      }
      return m_Sql.Query(m_cServer,CPSql.BuildSQLPhrase(m_cSelect,m_cFrom,l_cWhere,m_cOrderBy));
    }
  }
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public armt_ae_operazboBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean CheckOTPSecurity() {
    boolean l_bResult;
    l_bResult = true;
    int accessType;
    boolean requiredOTP;
    boolean requiredPwd;
    requiredOTP = (m_bLoaded?false:false);
    requiredPwd = (m_bLoaded?false:false);
    if (requiredOTP) {
      accessType = 3;
    } else if (requiredPwd) {
      accessType = 2;
    } else {
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_ae_operazbo");
    }
    if (CPLib.eq(accessType,2)) {
      // richiesta password
      if ( ! (CPLib.CheckPwd(m_Ctx,m_cPassword))) {
        l_bResult = false;
        m_nLastError = 4;
        m_cLastMsgError = (CPLib.Empty(m_cPassword)?"MSG_NEED_PWD":"MSG_WRONG_PWD");
      }
    } else if (CPLib.eq(accessType,3)) {
      // richiesto otp
      if (CPLib.Empty(m_cOTP) ||  ! (CPLib.CheckOTP(m_Ctx.UserCode(),m_cOTP))) {
        l_bResult = false;
        m_nLastError = 5;
        m_cLastMsgError = (CPLib.Empty(m_cOTP)?"MSG_NEED_OTP":"MSG_WRONG_OTP");
      }
    }
    return l_bResult;
  }
  public boolean CanSave() {
    ResetErrorMessage();
    boolean l_bResult;
    l_bResult = true;
    if (l_bResult) {
      l_bResult = CanSaveChild(ardt_sogopeprov,m_cWv_ardt_sogopeprov,"m_cWv_ardt_sogopeprov");
      if (l_bResult) {
        l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
      } else {
        m_cLastMsgError = ardt_sogopeprov.m_cLastMsgError;
      }
    }
    return l_bResult;
  }
  public static String[] m_cSaveParameterNames = {"AlreadyAccepted"};
  public boolean Save() {
    return Save(false);
  }
  public boolean Save(boolean p_bAlreadyAccepted) {
    boolean l_bResult;
    l_bResult = true;
    // Se il record è stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
        // ne inizia una nuova ("begin transaction").
        m_Sql.RequireTransaction();
        if (m_bLoaded) {
          Update();
          BROnUpdated();
        } else {
          Insert();
          BROnInserted();
        }
        if (m_bLoaded) {
          NotifyEvent("Update children start");
        } else {
          NotifyEvent("Insert children start");
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (ardt_sogopeprov.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_sogopeprov)) {
            ardt_sogopeprov.SetFromContext(m_cWv_ardt_sogopeprov);
            m_cWv_ardt_sogopeprov = "_not_empty_";
          }
          if (ardt_sogopeprov.IsUpdated()) {
            ardt_sogopeprov.w_IDFILEBO = w_IDBASE;
            if ( ! (ardt_sogopeprov.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (m_bLoaded) {
          NotifyEvent("Update children end");
        } else {
          NotifyEvent("Insert children end");
        }
        /*  Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
                                    questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
                                    la parte di transazione corrente
                                  */
        // * --- Area Manuale = BO - Save End
        // * --- Fine Area Manuale
        BROnSaved();
        if (CPLib.ne(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          l_bResult = false;
        }
        m_Sql.CompleteTransaction();
      }
    }
    return l_bResult;
  }
  public static String[] m_cLoadParameterNames = {"IDBASE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDBASE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_jperazbo,m_cPhName_jperazbo,m_cVirtName_jperazbo,m_cVirtName_jperazbo+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_jperazbo,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_16(m_cPhName_tbvalute,m_cServer_tbvalute);
    l_oSqlLoader.AddJoinedLink_1_21(m_cPhName_jnarapbo,m_cServer_jnarapbo);
    l_oSqlLoader.AddJoinedLink_1_22(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_24(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_27(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_28(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_35(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_39(m_cPhName_tbstati,m_cServer_tbstati);
    l_oSqlLoader.AddJoinedLink_1_49(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_1_51(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_162(m_cPhName_tbcausin,m_cServer_tbcausin);
    l_oSqlLoader.AddJoinedLink_2_18(m_cPhName_tbtipope,m_cServer_tbtipope);
    l_oSqlLoader.AddJoinedLink_2_29(m_cPhName_tbareegeog,m_cServer_tbareegeog);
    l_oSqlLoader.AddJoinedLink_2_30(m_cPhName_tbsvolgim,m_cServer_tbsvolgim);
    l_oSqlLoader.AddJoinedLink_2_31(m_cPhName_tbplauso,m_cServer_tbplauso);
    l_oSqlLoader.AddJoinedLink_2_32(m_cPhName_tbtiporisc,m_cServer_tbtiporisc);
    l_oSqlLoader.AddJoinedLink_2_55(m_cPhName_tbdurata,m_cServer_tbdurata);
    l_oSqlLoader.AddJoinedLink_2_56(m_cPhName_tbimporto,m_cServer_tbimporto);
    // Cursore dei record caricati
    l_rsLoad = l_oSqlLoader.Query();
    try {
      m_bLoaded =  ! (l_rsLoad.Eof());
      if (m_bLoaded) {
        m_bCalculating = true;
        /*  Assegna il valore iniziale a tutte le variabili non calcolate/inizializzate.
                                    Queste variabili non vengono inizializzate nella lettura del record,
                                    quindi terrebbero il valore che avevano precedentemente.
                                 */
        w_xTOTLIRE = 0;
        w_xTOTCONT = 0;
        w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
        w_xdes1 = "";
        w_desccauana = "";
        w_xdesccausin = "";
        w_descdiv = "";
        w_xragsocper = "";
        w_xdescrap = "";
        w_xragsocct = "";
        w_xragsocben = "";
        w_xdestipleg = "";
        w_xragint2 = "";
        w_xdescpaese2 = "";
        w_datpaseuro = CPLib.NullDate();
        w_xDescDipe = "";
        w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
        w_errmsg = "";
        w_test = "";
        w_valflg2 = "";
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
        w_xcodfisc = "";
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gStatus = m_Ctx.GetGlobalString("gStatus");
        w_CITINT = "";
        w_CITDIP = "";
        w_PROVDIP = "";
        w_CABDIP = "";
        w_PROVINT = "";
        w_CABINT = "";
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_xtiporap = "";
        w_dessta = "";
        w_xragsocalt = "";
        w_xdciticon = "";
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_DATAVALI = CPLib.NullDate();
        w_DATARILASC = CPLib.NullDate();
        w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
        w_xFLGITAEST = "";
        w_xdescmodsvo = "";
        w_xdescareag = "";
        w_xdescplauso = "";
        w_xdesctipor = "";
        w_xdescopeage = "";
        w_xdescfreq = "";
        w_xdescammo = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_CDATOPE = l_rsLoad.GetString("CDATOPE");
        w_DATAREG = l_rsLoad.GetDate("DATAREG");
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        w_TIPOOPRAP = l_rsLoad.GetString("TIPOOPRAP");
        w_CODANA = l_rsLoad.GetString("CODANA");
        // Link con tbcauana non eseguito: riporta solo campi
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        w_SEGNO = "";
        w_desccauana = "";
        w_xFLGITAEST = "";
        Link_JFTTTRWQFB("Load");
        w_FLAGLIRE = l_rsLoad.GetString("FLAGLIRE");
        w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        if (l_oSqlLoader.m_bLink_1_16) {
          w_descdiv = l_rsLoad.GetString("DESCRI116");
        } else {
          Link_YGFXODFVYI("Load");
        }
        w_FLAGCONT = l_rsLoad.GetString("FLAGCONT");
        w_CAMBIO = l_rsLoad.GetDouble("CAMBIO");
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        if (l_oSqlLoader.m_bLink_1_21) {
          w_xdescrap = l_rsLoad.GetString("DESCRAP121");
          w_FLAGRAP = l_rsLoad.GetString("TIPORAP121");
        } else {
          Link_HLPFLQLILN("Load");
        }
        w_CONNESCLI = l_rsLoad.GetString("CONNESCLI");
        if (l_oSqlLoader.m_bLink_1_22) {
          w_xragsocper = l_rsLoad.GetString("RAGSOC122");
          w_xcodfisc = l_rsLoad.GetString("CODFISC122");
          w_DATAVALI = l_rsLoad.GetDate("DATAVALI122");
          w_DATARILASC = l_rsLoad.GetDate("DATARILASC122");
        } else {
          Link_MLQSWPUYXK("Load");
        }
        w_filtro = "O";
        w_CONNESOPER = l_rsLoad.GetString("CONNESOPER");
        if (l_oSqlLoader.m_bLink_1_24) {
          w_xragsocct = l_rsLoad.GetString("RAGSOC124");
        } else {
          Link_JHLWBNTKPL("Load");
        }
        w_TIPOLEG = l_rsLoad.GetString("TIPOLEG");
        w_PAGASOGOP = l_rsLoad.GetString("PAGASOGOP");
        w_CONNESBEN = l_rsLoad.GetString("CONNESBEN");
        if (l_oSqlLoader.m_bLink_1_27) {
          w_xragsocben = l_rsLoad.GetString("RAGSOC127");
        } else {
          Link_SYIIMUFSEQ("Load");
        }
        w_CONNALTRO = l_rsLoad.GetString("CONNALTRO");
        if (l_oSqlLoader.m_bLink_1_28) {
          w_xragsocalt = l_rsLoad.GetString("RAGSOC128");
        } else {
          Link_JVSBAIMQUS("Load");
        }
        w_C_RAG = l_rsLoad.GetString("C_RAG");
        w_C_CTA = l_rsLoad.GetString("C_CTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_C_PRV = l_rsLoad.GetString("C_PRV");
        w_C_CAP = l_rsLoad.GetString("C_CAP");
        w_C_CAB = l_rsLoad.GetString("C_CAB");
        w_C_IND = l_rsLoad.GetString("C_IND");
        w_C_STA = l_rsLoad.GetString("C_STA");
        if (l_oSqlLoader.m_bLink_1_35) {
          w_dessta = l_rsLoad.GetString("DESCRI135");
        } else {
          Link_YVIKEGPYPM("Load");
        }
        w_TIPOINT2 = l_rsLoad.GetString("TIPOINT2");
        w_CODINT2 = l_rsLoad.GetString("CODINT2");
        // Link con inter2bo non eseguito: riporta solo campi
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_PAESE = l_rsLoad.GetString("PAESE");
        if (l_oSqlLoader.m_bLink_1_39) {
          w_xdescpaese2 = l_rsLoad.GetString("DESCRI139");
        } else {
          Link_GYOQKYEVYP("Load");
        }
        w_C_RAPPORTO = l_rsLoad.GetString("C_RAPPORTO");
        w_CODCAB2 = l_rsLoad.GetString("CODCAB2");
        w_DESC2 = "";
        w_PROV2 = "";
        w_xdciticon = "";
        Link_LCQKOYRNRT("Load");
        w_PROV2 = l_rsLoad.GetString("PROV2");
        w_DESC2 = l_rsLoad.GetString("DESC2");
        w_ZCPARTE = l_rsLoad.GetString("ZCPARTE");
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        op_IDBASE = w_IDBASE;
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        op_NUMPROG = w_NUMPROG;
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        if (l_oSqlLoader.m_bLink_1_49) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC149");
          w_CABINT = l_rsLoad.GetString("CODCAB149");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA149");
          w_CITINT = l_rsLoad.GetString("DESCCIT149");
        } else {
          Link_ZUFPYFWAFU("Load");
        }
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_51) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ151");
          w_CITDIP = l_rsLoad.GetString("DESCCIT151");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA151");
          w_CABDIP = l_rsLoad.GetString("CAB151");
        } else {
          Link_KXEUVNBTBC("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_SEGNO = l_rsLoad.GetString("SEGNO");
        w_DATARETT = l_rsLoad.GetDate("DATARETT");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_tipope = "1";
        w_TOTLIRE = l_rsLoad.GetDouble("TOTLIRE");
        w_TOTCONT = l_rsLoad.GetDouble("TOTCONT");
        w_TIPOINF = l_rsLoad.GetString("TIPOINF");
        w_IDEREG = l_rsLoad.GetString("IDEREG");
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_FLAGRAP = l_rsLoad.GetString("FLAGRAP");
        w_OPRAP = l_rsLoad.GetString("OPRAP");
        w_OPERAZMOD = l_rsLoad.GetString("OPERAZMOD");
        w_RAPPORTBEN = l_rsLoad.GetString("RAPPORTBEN");
        w_OPERATORE = l_rsLoad.GetString("OPERATORE");
        w_AUTOM = l_rsLoad.GetString("AUTOM");
        w_sEdit = 0;
        w_FLAGRAP2 = l_rsLoad.GetString("FLAGRAP2");
        w_STATOREG = l_rsLoad.GetString("STATOREG");
        w_PRGIMPOPE = l_rsLoad.GetDouble("PRGIMPOPE");
        op_PRGIMPOPE = w_PRGIMPOPE;
        w_dataoggi = CPLib.Date();
        w_stringaflagrap2 = "ABCDEFGHI";
        w_CDATAOPE = l_rsLoad.GetString("CDATAOPE");
        w_CONNESDOC = l_rsLoad.GetString("CONNESDOC");
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        if (l_oSqlLoader.m_bLink_1_162) {
          w_xdesccausin = l_rsLoad.GetString("DESCRIZ262");
        } else {
          Link_KHRUYMSPDK("Load");
        }
        w_CDATREG = l_rsLoad.GetString("CDATREG");
        w_ANNOOPE = l_rsLoad.GetDouble("ANNOOPE");
        w_IMPIN = l_rsLoad.GetDouble("IMPIN");
        w_IMPOUT = l_rsLoad.GetDouble("IMPOUT");
        w_OPERAG = l_rsLoad.GetString("OPERAG");
        if (l_oSqlLoader.m_bLink_2_18) {
          w_xdescopeage = l_rsLoad.GetString("DESCRI218");
        } else {
          Link_QEFXECTWSF("Load");
        }
        w_NOPROT = l_rsLoad.GetDouble("NOPROT");
        w_RESPINS = l_rsLoad.GetString("RESPINS");
        w_INFORM = l_rsLoad.GetString("INFORM");
        w_NATURA = l_rsLoad.GetString("NATURA");
        w_SCOPO = l_rsLoad.GetString("SCOPO");
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        if (l_oSqlLoader.m_bLink_2_29) {
          w_xdescareag = l_rsLoad.GetString("DESCRI229");
          w_RAREA = l_rsLoad.GetDouble("RISCHIO229");
        } else {
          Link_QJSTZIPOQB("Load");
        }
        w_MODSVOL = l_rsLoad.GetString("MODSVOL");
        if (l_oSqlLoader.m_bLink_2_30) {
          w_xdescmodsvo = l_rsLoad.GetString("DESCRI230");
          w_RCOMP = l_rsLoad.GetDouble("RISCHIO230");
        } else {
          Link_SFFFOYOWNH("Load");
        }
        w_RAGIO = l_rsLoad.GetString("RAGIO");
        if (l_oSqlLoader.m_bLink_2_31) {
          w_xdescplauso = l_rsLoad.GetString("DESCRI231");
          w_RRAGIO = l_rsLoad.GetDouble("RISCHIO231");
        } else {
          Link_NOBMPHKVTX("Load");
        }
        w_TIPO = l_rsLoad.GetString("TIPO");
        if (l_oSqlLoader.m_bLink_2_32) {
          w_xdesctipor = l_rsLoad.GetString("DESCRI232");
          w_RTIPO = l_rsLoad.GetDouble("RISCHIO232");
        } else {
          Link_DJOWYRMDDC("Load");
        }
        w_RAREA = l_rsLoad.GetDouble("RAREA");
        w_RCOMP = l_rsLoad.GetDouble("RCOMP");
        w_RRAGIO = l_rsLoad.GetDouble("RRAGIO");
        w_RTIPO = l_rsLoad.GetDouble("RTIPO");
        w_RFREQ = l_rsLoad.GetDouble("RFREQ");
        w_RIMP = l_rsLoad.GetDouble("RIMP");
        w_DURAT = l_rsLoad.GetString("DURAT");
        if (l_oSqlLoader.m_bLink_2_55) {
          w_xdescfreq = l_rsLoad.GetString("DESCRI255");
          w_RFREQ = l_rsLoad.GetDouble("RISCHIO255");
        } else {
          Link_CKJQULDXKW("Load");
        }
        w_AMMONT = l_rsLoad.GetString("AMMONT");
        if (l_oSqlLoader.m_bLink_2_56) {
          w_xdescammo = l_rsLoad.GetString("DESCRI256");
          w_RIMP = l_rsLoad.GetDouble("RISCHIO256");
        } else {
          Link_SXTYCPHBIM("Load");
        }
        w_MITIG = l_rsLoad.GetDouble("MITIG");
        w_MITGDOC = l_rsLoad.GetString("MITGDOC");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_sogopeprov = "";
        ardt_sogopeprov.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"jperazbo")) {
          m_cOldCPCCCHK = l_rsLoad.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        m_bCalculating = false;
        SaveDependsOn();
        m_cPreviousState = GetCurrentState();
        NotifyEvent("Load");
      } else {
        Blank();
      }
    } finally {
      l_rsLoad.Close();
    }
    // * --- Area Manuale = BO - Load Record End
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_IDBASE);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // Aggiornamento dei progressivi
    SaveAutonumber();
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_jperazbo);
      l_cSql = "insert into "+m_oWrInfo_jperazbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"CDATOPE,";
      l_cSql = l_cSql+"DATAREG,";
      l_cSql = l_cSql+"FLAGFRAZ,";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"TIPOOPRAP,";
      l_cSql = l_cSql+"CODANA,";
      l_cSql = l_cSql+"CODVOC,";
      l_cSql = l_cSql+"FLAGLIRE,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"FLAGCONT,";
      l_cSql = l_cSql+"CAMBIO,";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"CONNESCLI,";
      l_cSql = l_cSql+"CONNESOPER,";
      l_cSql = l_cSql+"TIPOLEG,";
      l_cSql = l_cSql+"PAGASOGOP,";
      l_cSql = l_cSql+"CONNESBEN,";
      l_cSql = l_cSql+"CONNALTRO,";
      l_cSql = l_cSql+"C_RAG,";
      l_cSql = l_cSql+"C_CTA,";
      l_cSql = l_cSql+"C_PRV,";
      l_cSql = l_cSql+"C_CAP,";
      l_cSql = l_cSql+"C_CAB,";
      l_cSql = l_cSql+"C_IND,";
      l_cSql = l_cSql+"C_STA,";
      l_cSql = l_cSql+"TIPOINT2,";
      l_cSql = l_cSql+"CODINT2,";
      l_cSql = l_cSql+"DESCINTER,";
      l_cSql = l_cSql+"PAESE,";
      l_cSql = l_cSql+"C_RAPPORTO,";
      l_cSql = l_cSql+"CODCAB2,";
      l_cSql = l_cSql+"PROV2,";
      l_cSql = l_cSql+"DESC2,";
      l_cSql = l_cSql+"ZCPARTE,";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"SEGNO,";
      l_cSql = l_cSql+"DATARETT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"TOTCONT,";
      l_cSql = l_cSql+"TIPOINF,";
      l_cSql = l_cSql+"IDEREG,";
      l_cSql = l_cSql+"FLAGRAP,";
      l_cSql = l_cSql+"OPRAP,";
      l_cSql = l_cSql+"OPERAZMOD,";
      l_cSql = l_cSql+"RAPPORTBEN,";
      l_cSql = l_cSql+"OPERATORE,";
      l_cSql = l_cSql+"AUTOM,";
      l_cSql = l_cSql+"FLAGRAP2,";
      l_cSql = l_cSql+"STATOREG,";
      l_cSql = l_cSql+"PRGIMPOPE,";
      l_cSql = l_cSql+"CDATAOPE,";
      l_cSql = l_cSql+"CONNESDOC,";
      l_cSql = l_cSql+"CDATREG,";
      l_cSql = l_cSql+"ANNOOPE,";
      l_cSql = l_cSql+"IMPIN,";
      l_cSql = l_cSql+"IMPOUT,";
      l_cSql = l_cSql+"OPERAG,";
      l_cSql = l_cSql+"NOPROT,";
      l_cSql = l_cSql+"RESPINS,";
      l_cSql = l_cSql+"INFORM,";
      l_cSql = l_cSql+"NATURA,";
      l_cSql = l_cSql+"SCOPO,";
      l_cSql = l_cSql+"AREAGEO,";
      l_cSql = l_cSql+"MODSVOL,";
      l_cSql = l_cSql+"RAGIO,";
      l_cSql = l_cSql+"TIPO,";
      l_cSql = l_cSql+"RAREA,";
      l_cSql = l_cSql+"RCOMP,";
      l_cSql = l_cSql+"RRAGIO,";
      l_cSql = l_cSql+"RTIPO,";
      l_cSql = l_cSql+"RFREQ,";
      l_cSql = l_cSql+"RIMP,";
      l_cSql = l_cSql+"DURAT,";
      l_cSql = l_cSql+"AMMONT,";
      l_cSql = l_cSql+"MITIG,";
      l_cSql = l_cSql+"MITGDOC,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_jperazbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jperazbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLLEG,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOOPRAP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODANA,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODVOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGLIRE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGCONT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAMBIO,"N",9,4)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOLEG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PAGASOGOP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESBEN,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNALTRO,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_RAG,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CTA,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_PRV,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CAP,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_CAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_IND,"C",35,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_C_STA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINT2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODINT2,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCINTER,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB2,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROV2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESC2,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ZCPARTE,"C",69,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTCONT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDEREG,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERAZMOD,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTBEN,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERATORE,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTOM,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_STATOREG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGIMPOPE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATAOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESDOC,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATREG,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ANNOOPE,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPIN,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPOUT,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_OPERAG,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOPROT,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RESPINS,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_INFORM,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NATURA,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SCOPO,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AREAGEO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MODSVOL,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAGIO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RRAGIO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RTIPO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RFREQ,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RIMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DURAT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AMMONT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITIG,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITGDOC,"C",100,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_jperazbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jperazbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_jperazbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Insert end");
    // * --- Area Manuale = BO - Insert End
    // * --- Fine Area Manuale
  }
  void Update() {
    String l_cSql;
    int l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    // * --- Area Manuale = BO - Replace Init
    // * --- Fine Area Manuale
    NotifyEvent("Update start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_jperazbo);
      l_cSql = "Update "+m_oWrInfo_jperazbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", CDATOPE = "+CPLib.ToSQL(w_CDATOPE,"C",8,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"D",8,0);
      l_cSql = l_cSql+", FLAGFRAZ = "+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0);
      l_cSql = l_cSql+", COLLEG = "+CPLib.ToSQL(w_COLLEG,"C",12,0);
      l_cSql = l_cSql+", TIPOOPRAP = "+CPLib.ToSQL(w_TIPOOPRAP,"C",2,0);
      l_cSql = l_cSql+", CODANA = "+CPLib.ToSQLNull(w_CODANA,"C",4,0);
      l_cSql = l_cSql+", CODVOC = "+CPLib.ToSQL(w_CODVOC,"C",2,0);
      l_cSql = l_cSql+", FLAGLIRE = "+CPLib.ToSQL(w_FLAGLIRE,"C",1,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQLNull(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", FLAGCONT = "+CPLib.ToSQL(w_FLAGCONT,"C",1,0);
      l_cSql = l_cSql+", CAMBIO = "+CPLib.ToSQL(w_CAMBIO,"N",9,4);
      l_cSql = l_cSql+", RAPPORTO = "+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", CONNESCLI = "+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0);
      l_cSql = l_cSql+", CONNESOPER = "+CPLib.ToSQLNull(w_CONNESOPER,"C",16,0);
      l_cSql = l_cSql+", TIPOLEG = "+CPLib.ToSQL(w_TIPOLEG,"C",1,0);
      l_cSql = l_cSql+", PAGASOGOP = "+CPLib.ToSQL(w_PAGASOGOP,"C",1,0);
      l_cSql = l_cSql+", CONNESBEN = "+CPLib.ToSQLNull(w_CONNESBEN,"C",16,0);
      l_cSql = l_cSql+", CONNALTRO = "+CPLib.ToSQLNull(w_CONNALTRO,"C",16,0);
      l_cSql = l_cSql+", C_RAG = "+CPLib.ToSQL(w_C_RAG,"C",70,0);
      l_cSql = l_cSql+", C_CTA = "+CPLib.ToSQL(w_C_CTA,"C",30,0);
      l_cSql = l_cSql+", C_PRV = "+CPLib.ToSQL(w_C_PRV,"C",2,0);
      l_cSql = l_cSql+", C_CAP = "+CPLib.ToSQL(w_C_CAP,"C",5,0);
      l_cSql = l_cSql+", C_CAB = "+CPLib.ToSQL(w_C_CAB,"C",6,0);
      l_cSql = l_cSql+", C_IND = "+CPLib.ToSQL(w_C_IND,"C",35,0);
      l_cSql = l_cSql+", C_STA = "+CPLib.ToSQLNull(w_C_STA,"C",3,0);
      l_cSql = l_cSql+", TIPOINT2 = "+CPLib.ToSQL(w_TIPOINT2,"C",2,0);
      l_cSql = l_cSql+", CODINT2 = "+CPLib.ToSQL(w_CODINT2,"C",11,0);
      l_cSql = l_cSql+", DESCINTER = "+CPLib.ToSQL(w_DESCINTER,"C",50,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQLNull(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", C_RAPPORTO = "+CPLib.ToSQL(w_C_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", CODCAB2 = "+CPLib.ToSQL(w_CODCAB2,"C",6,0);
      l_cSql = l_cSql+", PROV2 = "+CPLib.ToSQL(w_PROV2,"C",2,0);
      l_cSql = l_cSql+", DESC2 = "+CPLib.ToSQL(w_DESC2,"C",30,0);
      l_cSql = l_cSql+", ZCPARTE = "+CPLib.ToSQL(w_ZCPARTE,"C",69,0);
      l_cSql = l_cSql+", NUMPROG = "+CPLib.ToSQL(w_NUMPROG,"C",11,0);
      l_cSql = l_cSql+", CODINTER = "+CPLib.ToSQLNull(w_CODINTER,"C",11,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", SEGNO = "+CPLib.ToSQL(w_SEGNO,"C",1,0);
      l_cSql = l_cSql+", DATARETT = "+CPLib.ToSQL(w_DATARETT,"D",8,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",15,0);
      l_cSql = l_cSql+", TOTCONT = "+CPLib.ToSQL(w_TOTCONT,"N",15,0);
      l_cSql = l_cSql+", TIPOINF = "+CPLib.ToSQL(w_TIPOINF,"C",1,0);
      l_cSql = l_cSql+", IDEREG = "+CPLib.ToSQL(w_IDEREG,"C",20,0);
      l_cSql = l_cSql+", FLAGRAP = "+CPLib.ToSQL(w_FLAGRAP,"C",1,0);
      l_cSql = l_cSql+", OPRAP = "+CPLib.ToSQL(w_OPRAP,"C",1,0);
      l_cSql = l_cSql+", OPERAZMOD = "+CPLib.ToSQL(w_OPERAZMOD,"C",20,0);
      l_cSql = l_cSql+", RAPPORTBEN = "+CPLib.ToSQL(w_RAPPORTBEN,"C",25,0);
      l_cSql = l_cSql+", OPERATORE = "+CPLib.ToSQL(w_OPERATORE,"C",70,0);
      l_cSql = l_cSql+", AUTOM = "+CPLib.ToSQL(w_AUTOM,"C",5,0);
      l_cSql = l_cSql+", FLAGRAP2 = "+CPLib.ToSQL(w_FLAGRAP2,"C",1,0);
      l_cSql = l_cSql+", STATOREG = "+CPLib.ToSQL(w_STATOREG,"C",1,0);
      l_cSql = l_cSql+", PRGIMPOPE = "+CPLib.ToSQL(w_PRGIMPOPE,"N",15,0);
      l_cSql = l_cSql+", CDATAOPE = "+CPLib.ToSQL(w_CDATAOPE,"C",8,0);
      l_cSql = l_cSql+", CONNESDOC = "+CPLib.ToSQL(w_CONNESDOC,"C",40,0);
      l_cSql = l_cSql+", CDATREG = "+CPLib.ToSQL(w_CDATREG,"C",8,0);
      l_cSql = l_cSql+", ANNOOPE = "+CPLib.ToSQL(w_ANNOOPE,"N",4,0);
      l_cSql = l_cSql+", IMPIN = "+CPLib.ToSQL(w_IMPIN,"N",15,2);
      l_cSql = l_cSql+", IMPOUT = "+CPLib.ToSQL(w_IMPOUT,"N",15,2);
      l_cSql = l_cSql+", OPERAG = "+CPLib.ToSQLNull(w_OPERAG,"C",3,0);
      l_cSql = l_cSql+", NOPROT = "+CPLib.ToSQL(w_NOPROT,"N",1,0);
      l_cSql = l_cSql+", RESPINS = "+CPLib.ToSQL(w_RESPINS,"C",30,0);
      l_cSql = l_cSql+", INFORM = "+CPLib.ToSQL(w_INFORM,"C",30,0);
      l_cSql = l_cSql+", NATURA = "+CPLib.ToSQL(w_NATURA,"C",50,0);
      l_cSql = l_cSql+", SCOPO = "+CPLib.ToSQL(w_SCOPO,"C",50,0);
      l_cSql = l_cSql+", AREAGEO = "+CPLib.ToSQLNull(w_AREAGEO,"C",5,0);
      l_cSql = l_cSql+", MODSVOL = "+CPLib.ToSQLNull(w_MODSVOL,"C",5,0);
      l_cSql = l_cSql+", RAGIO = "+CPLib.ToSQLNull(w_RAGIO,"C",5,0);
      l_cSql = l_cSql+", TIPO = "+CPLib.ToSQLNull(w_TIPO,"C",3,0);
      l_cSql = l_cSql+", RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0);
      l_cSql = l_cSql+", RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0);
      l_cSql = l_cSql+", RRAGIO = "+CPLib.ToSQL(w_RRAGIO,"N",3,0);
      l_cSql = l_cSql+", RTIPO = "+CPLib.ToSQL(w_RTIPO,"N",3,0);
      l_cSql = l_cSql+", RFREQ = "+CPLib.ToSQL(w_RFREQ,"N",3,0);
      l_cSql = l_cSql+", RIMP = "+CPLib.ToSQL(w_RIMP,"N",3,0);
      l_cSql = l_cSql+", DURAT = "+CPLib.ToSQLNull(w_DURAT,"C",5,0);
      l_cSql = l_cSql+", AMMONT = "+CPLib.ToSQLNull(w_AMMONT,"C",5,0);
      l_cSql = l_cSql+", MITIG = "+CPLib.ToSQL(w_MITIG,"N",4,0);
      l_cSql = l_cSql+", MITGDOC = "+CPLib.ToSQL(w_MITGDOC,"C",100,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jperazbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_jperazbo,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_jperazbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"jperazbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_jperazbo,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_IDBASE) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_IDBASE);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                    gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
                                    ne inizia una nuova ("begin transaction").
                                  */
        m_Sql.RequireTransaction();
        NotifyEvent("Delete start");
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio + Soggetti Oper. Conto Terzi
          ardt_sogopeprov.w_IDFILEBO = w_IDBASE;
          ardt_sogopeprov.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_jperazbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_jperazbo,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_jperazbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"jperazbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_jperazbo,l_cSql);
          if (CPLib.ne(l_nUpdatedRows,1)) {
            // AbortTransaction
            m_Sql.AbortTransaction();
          }
        }
        NotifyEvent("Delete end");
        BROnDeleted();
        l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
        // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
        // la parte di transazione corrente
        m_Sql.CompleteTransaction();
      } else {
        m_Sql.AbortTransaction(m_cLastMsgError);
      }
    }
    // * --- Area Manuale = BO - Delete End
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_IDBASE);
  }
  void SaveAutonumber() {
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a IDBASE
    w_IDBASE = CPLib.Left(w_IDBASE,10)+CPLib.Space(10-CPLib.Len(w_IDBASE));
    m_Sql.NextTableProg(this,"PPOPER1","i_codazi,w_IDBASE",m_cServer_jperazbo,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave IDBASE, altrimenti non si riesce a linkare da zoom
    w_IDBASE = CPLib.RTrim(w_IDBASE);
    op_IDBASE = w_IDBASE;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a NUMPROG
    w_NUMPROG = CPLib.Left(w_NUMPROG,11)+CPLib.Space(11-CPLib.Len(w_NUMPROG));
    m_Sql.NextTableProg(this,"PPOPER2","i_codazi,w_NUMPROG",m_cServer_jperazbo,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave NUMPROG, altrimenti non si riesce a linkare da zoom
    w_NUMPROG = CPLib.RTrim(w_NUMPROG);
    op_NUMPROG = w_NUMPROG;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPOPE","i_codazi,w_PRGIMPOPE",m_cServer_jperazbo,m_Ctx.GetCompany());
    op_PRGIMPOPE = w_PRGIMPOPE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"UTKMIHOWMH")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODCAU"};
      result.m_rdTypes = new String[]{"C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UTKMIHOWMH",CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"JFTTTRWQFB")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAUSINT" , "SEGNO" , "DESCRI" , "FLGINTER"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{"CODCAU"};
      result.m_kTypes = new String[]{"C"};
      result.AppendFieldsHash("JFTTTRWQFB",CPLib.GetLinkedFieldProps("CAUSINT","CODVOC","C",2,0),CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"YGFXODFVYI")) {
      result.m_TableName = "tbvalute";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODVAL" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YGFXODFVYI",CPLib.GetLinkedFieldProps("CODVAL","VALUTA","C",3,0));
    } else if (CPLib.eq(p_cID,"HLPFLQLILN")) {
      result.m_TableName = "jnarapbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAPPORTO" , "DESCRAP" , "TIPORAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HLPFLQLILN",CPLib.GetLinkedFieldProps("RAPPORTO","RAPPORTO","C",25,0));
    } else if (CPLib.eq(p_cID,"MLQSWPUYXK")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "CODFISC" , "DATAVALI" , "DATARILASC"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "D" , "D"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MLQSWPUYXK",CPLib.GetLinkedFieldProps("CONNES","CONNESCLI","C",16,0));
    } else if (CPLib.eq(p_cID,"JHLWBNTKPL")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JHLWBNTKPL",CPLib.GetLinkedFieldProps("CONNES","CONNESOPER","C",16,0));
    } else if (CPLib.eq(p_cID,"SYIIMUFSEQ")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SYIIMUFSEQ",CPLib.GetLinkedFieldProps("CONNES","CONNESBEN","C",16,0));
    } else if (CPLib.eq(p_cID,"JVSBAIMQUS")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JVSBAIMQUS",CPLib.GetLinkedFieldProps("CONNES","CONNALTRO","C",16,0));
    } else if (CPLib.eq(p_cID,"ODAYKSRECA")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CITTA" , "CAB" , "PROV" , "PKTBSTATI" , "CAP"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ODAYKSRECA",CPLib.GetLinkedFieldProps("CITTA","C_CTA","C",30,0));
    } else if (CPLib.eq(p_cID,"YVIKEGPYPM")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YVIKEGPYPM",CPLib.GetLinkedFieldProps("CODSTA","C_STA","C",3,0));
    } else if (CPLib.eq(p_cID,"NUZRBZHLLM")) {
      result.m_TableName = "inter2bo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODINTER" , "RAGSOC" , "CODCAB" , "PROVINCIA" , "PAESE" , "TIPINTER"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NUZRBZHLLM",CPLib.GetLinkedFieldProps("CODINTER","CODINT2","C",11,0));
    } else if (CPLib.eq(p_cID,"GYOQKYEVYP")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GYOQKYEVYP",CPLib.GetLinkedFieldProps("CODSTA","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"LCQKOYRNRT")) {
      result.m_TableName = "tbcitta";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CAB" , "CITTA" , "PROV" , "CITTA"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LCQKOYRNRT",CPLib.GetLinkedFieldProps("CAB","CODCAB2","C",6,0));
    } else if (CPLib.eq(p_cID,"ZUFPYFWAFU")) {
      result.m_TableName = "intermbo";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_intermbo";
      result.m_rdField = new String[]{"CODINTER" , "DATANASC" , "CODCAB" , "PROVINCIA" , "DESCCIT"};
      result.m_rdTypes = new String[]{"C" , "D" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZUFPYFWAFU",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0));
    } else if (CPLib.eq(p_cID,"KXEUVNBTBC")) {
      result.m_TableName = "anadip";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODDIP" , "DESCRIZ" , "DESCCIT" , "PROVINCIA" , "CAB"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KXEUVNBTBC",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    } else if (CPLib.eq(p_cID,"KHRUYMSPDK")) {
      result.m_TableName = "tbcausin";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODVOC" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KHRUYMSPDK",CPLib.GetLinkedFieldProps("CODVOC","CODVOC","C",2,0));
    } else if (CPLib.eq(p_cID,"QEFXECTWSF")) {
      result.m_TableName = "tbtipope";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QEFXECTWSF",CPLib.GetLinkedFieldProps("CODICE","OPERAG","C",3,0));
    } else if (CPLib.eq(p_cID,"QJSTZIPOQB")) {
      result.m_TableName = "tbareegeog";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QJSTZIPOQB",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",5,0));
    } else if (CPLib.eq(p_cID,"SFFFOYOWNH")) {
      result.m_TableName = "tbsvolgim";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SFFFOYOWNH",CPLib.GetLinkedFieldProps("CODICE","MODSVOL","C",5,0));
    } else if (CPLib.eq(p_cID,"NOBMPHKVTX")) {
      result.m_TableName = "tbplauso";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NOBMPHKVTX",CPLib.GetLinkedFieldProps("CODICE","RAGIO","C",5,0));
    } else if (CPLib.eq(p_cID,"DJOWYRMDDC")) {
      result.m_TableName = "tbtiporisc";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DJOWYRMDDC",CPLib.GetLinkedFieldProps("CODICE","TIPO","C",3,0));
    } else if (CPLib.eq(p_cID,"CKJQULDXKW")) {
      result.m_TableName = "tbdurata";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CKJQULDXKW",CPLib.GetLinkedFieldProps("CODICE","DURAT","C",5,0));
    } else if (CPLib.eq(p_cID,"SXTYCPHBIM")) {
      result.m_TableName = "tbimporto";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "DESCRI" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SXTYCPHBIM",CPLib.GetLinkedFieldProps("CODICE","AMMONT","C",5,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_calcflaglire,arfn_chkdatdoc,arfn_chksogg,arfn_chktotalelire,arfn_chktotalelire_cont,arfn_read_tipoleg,arrt_imp_frischio,arrt_val_benefic,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_calcflaglire,arfn_chkdatdoc,arfn_chksogg,arfn_chktotalelire,arfn_chktotalelire_cont,arfn_read_tipoleg,arrt_imp_frischio,arrt_val_benefic,arrt_writelog,";
}
