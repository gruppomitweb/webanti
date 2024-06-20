// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_operazioniBO extends armt_operazioniBL {
  class SqlLoader {
    public boolean m_bLink_1_28 = false;
    public boolean m_bLink_1_30 = false;
    public boolean m_bLink_1_51 = false;
    public boolean m_bLink_1_54 = false;
    public boolean m_bLink_1_63 = false;
    public boolean m_bLink_1_64 = false;
    public boolean m_bLink_1_69 = false;
    public boolean m_bLink_1_72 = false;
    public boolean m_bLink_1_73 = false;
    public boolean m_bLink_4_16 = false;
    public boolean m_bLink_5_8 = false;
    public boolean m_bLink_6_4 = false;
    public boolean m_bLink_6_6 = false;
    public boolean m_bLink_6_8 = false;
    public boolean m_bLink_6_10 = false;
    public boolean m_bLink_6_12 = false;
    public boolean m_bLink_6_14 = false;
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
    public void AddJoinedLink_1_28(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_28.CODINTER AS CODINTER128";
        m_cSelect = m_cSelect+" ,link_1_28.DATANASC AS DATANASC128";
        m_cSelect = m_cSelect+" ,link_1_28.CODCAB AS CODCAB128";
        m_cSelect = m_cSelect+" ,link_1_28.PROVINCIA AS PROVINCIA128";
        m_cSelect = m_cSelect+" ,link_1_28.DESCCIT AS DESCCIT128";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_28","CODINTER","CODINTER");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_28","CODINTER","CODINTER",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_28 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_30(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_30.CODDIP AS CODDIP130";
        m_cSelect = m_cSelect+" ,link_1_30.DESCRIZ AS DESCRIZ130";
        m_cSelect = m_cSelect+" ,link_1_30.DESCCIT AS DESCCIT130";
        m_cSelect = m_cSelect+" ,link_1_30.PROVINCIA AS PROVINCIA130";
        m_cSelect = m_cSelect+" ,link_1_30.CAB AS CAB130";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_30","CODDIPE","CODDIP");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_30","CODDIPE","CODDIP",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_30 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_51(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_51.CODVOC AS CODVOC151";
        m_cSelect = m_cSelect+" ,link_1_51.DESCRIZ AS DESCRIZ151";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_51","CODVOC","CODVOC");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_51","CODVOC","CODVOC",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_51 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_54(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_54.CODVAL AS CODVAL154";
        m_cSelect = m_cSelect+" ,link_1_54.DESCRI AS DESCRI154";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_54","VALUTA","CODVAL");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_54","VALUTA","CODVAL",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_54 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_63(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_63.RAPPORTO AS RAPPORTO163";
        m_cSelect = m_cSelect+" ,link_1_63.DESCRAP AS DESCRAP163";
        m_cSelect = m_cSelect+" ,link_1_63.TIPORAP AS TIPORAP163";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_63","RAPPORTO","RAPPORTO");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_63","RAPPORTO","RAPPORTO",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_63 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_64(String rightTable,String rightServer) {
      // questo link aggiunge 5 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+5,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_64.CONNES AS CONNES164";
        m_cSelect = m_cSelect+" ,link_1_64.RAGSOC AS RAGSOC164";
        m_cSelect = m_cSelect+" ,link_1_64.CODFISC AS CODFISC164";
        m_cSelect = m_cSelect+" ,link_1_64.DATAVALI AS DATAVALI164";
        m_cSelect = m_cSelect+" ,link_1_64.DATARILASC AS DATARILASC164";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_64","CONNESCLI","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_64","CONNESCLI","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_64 = true;
          m_nColumns = m_nColumns+5;
        }
      }
    }
    public void AddJoinedLink_1_69(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_69.CONNES AS CONNES169";
        m_cSelect = m_cSelect+" ,link_1_69.RAGSOC AS RAGSOC169";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_69","CONNESOPER","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_69","CONNESOPER","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_69 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_72(String rightTable,String rightServer) {
      // questo link aggiunge 3 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+3,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_72.CONNES AS CONNES172";
        m_cSelect = m_cSelect+" ,link_1_72.RAGSOC AS RAGSOC172";
        m_cSelect = m_cSelect+" ,link_1_72.CONTO AS CONTO172";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_72","CONNESBEN","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_72","CONNESBEN","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_72 = true;
          m_nColumns = m_nColumns+3;
        }
      }
    }
    public void AddJoinedLink_1_73(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_73.CONNES AS CONNES173";
        m_cSelect = m_cSelect+" ,link_1_73.RAGSOC AS RAGSOC173";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_73","CONNALTRO","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_73","CONNALTRO","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_73 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_4_16(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_4_16.CODICE AS CODICE416";
        m_cSelect = m_cSelect+" ,link_4_16.DESCRI AS DESCRI416";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_4_16","OPERAG","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_4_16","OPERAG","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_4_16 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_5_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_5_8.CONNES AS CONNES508";
        m_cSelect = m_cSelect+" ,link_5_8.RAGSOC AS RAGSOC508";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_5_8","CONNESDOC","CONNES");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_5_8","CONNESDOC","CONNES",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_5_8 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_4(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_4.CODICE AS CODICE604";
        m_cSelect = m_cSelect+" ,link_6_4.DESCRI AS DESCRI604";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_4","DURAT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_4","DURAT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_4 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_6(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_6.CODICE AS CODICE606";
        m_cSelect = m_cSelect+" ,link_6_6.DESCRI AS DESCRI606";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_6","AMMONT","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_6","AMMONT","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_6 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_8(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_8.CODICE AS CODICE608";
        m_cSelect = m_cSelect+" ,link_6_8.DESCRI AS DESCRI608";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_8","AREAGEO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_8","AREAGEO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_8 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_10(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_10.CODICE AS CODICE610";
        m_cSelect = m_cSelect+" ,link_6_10.DESCRI AS DESCRI610";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_10","MODSVOL","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_10","MODSVOL","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_10 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_12(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_12.CODICE AS CODICE612";
        m_cSelect = m_cSelect+" ,link_6_12.DESCRI AS DESCRI612";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_12","RAGIO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_12","RAGIO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_12 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_6_14(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_6_14.CODICE AS CODICE614";
        m_cSelect = m_cSelect+" ,link_6_14.DESCRI AS DESCRI614";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_6_14","TIPO","CODICE");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_6_14","TIPO","CODICE",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_6_14 = true;
          m_nColumns = m_nColumns+2;
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
  public armt_operazioniBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_operazioni");
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
    l_bResult = (w_COMPLETA?arfn_chkdatregR.Make(m_Ctx,this).Run(w_DATAOPE,w_DATAREG,w_gChkDate,EntityStatus()):true);
    if (l_bResult) {
      l_bResult = (w_COMPLETA? ! (CPLib.Empty(w_CONNESCLI)):true);
      if (l_bResult && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      } else {
        m_cLastMsgError = "Indispensabile inserire un valore nel campo C11";
      }
    } else {
      m_cLastMsgError = CPLib.Strtran("'%ERRORMESSAGE%'","%ERRORMESSAGE%",m_cLastMsgError);
    }
    if (l_bResult) {
      l_bResult = CanSaveChild(ardt_sogope,m_cWv_ardt_sogope,"m_cWv_ardt_sogope");
      if (l_bResult) {
        l_bResult = CanSaveChild(ardt_clientiope,m_cWv_ardt_clientiope,"m_cWv_ardt_clientiope");
        if (l_bResult) {
          l_bResult = CanSaveChild(ardt_mlientiope,m_cWv_ardt_mlientiope,"m_cWv_ardt_mlientiope");
          if (l_bResult) {
            l_bResult = CanSaveChild(ardt_mogopebo,m_cWv_ardt_mogopebo,"m_cWv_ardt_mogopebo");
            if (l_bResult) {
              l_bResult = CanSaveChild(ardt_beneficope,m_cWv_ardt_beneficope,"m_cWv_ardt_beneficope");
              if (l_bResult) {
                l_bResult = CanSaveChild(ardt_meneficope,m_cWv_ardt_meneficope,"m_cWv_ardt_meneficope");
                if (l_bResult) {
                  l_bResult = CanSaveChild(ardt_terzistiope,m_cWv_ardt_terzistiope,"m_cWv_ardt_terzistiope");
                  if (l_bResult) {
                    l_bResult = CanSaveChild(ardt_merzistiope,m_cWv_ardt_merzistiope,"m_cWv_ardt_merzistiope");
                    if (l_bResult) {
                      l_bResult = CanSaveChild(ardt_rapcoll,m_cWv_ardt_rapcoll,"m_cWv_ardt_rapcoll");
                      if (l_bResult) {
                        l_bResult = CanSaveChild(ardt_docopebo,m_cWv_ardt_docopebo,"m_cWv_ardt_docopebo");
                        if (l_bResult) {
                          l_bResult = CanSaveChild(armt_operazbo_agg,m_cWv_armt_operazbo_agg,"m_cWv_armt_operazbo_agg");
                          if (l_bResult) {
                            l_bResult = CanSaveChild(ardt_ope_contante,m_cWv_ardt_ope_contante,"m_cWv_ardt_ope_contante");
                            if (l_bResult) {
                              l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
                            } else {
                              m_cLastMsgError = ardt_ope_contante.m_cLastMsgError;
                            }
                          } else {
                            m_cLastMsgError = armt_operazbo_agg.m_cLastMsgError;
                          }
                        } else {
                          m_cLastMsgError = ardt_docopebo.m_cLastMsgError;
                        }
                      } else {
                        m_cLastMsgError = ardt_rapcoll.m_cLastMsgError;
                      }
                    } else {
                      m_cLastMsgError = ardt_merzistiope.m_cLastMsgError;
                    }
                  } else {
                    m_cLastMsgError = ardt_terzistiope.m_cLastMsgError;
                  }
                } else {
                  m_cLastMsgError = ardt_meneficope.m_cLastMsgError;
                }
              } else {
                m_cLastMsgError = ardt_beneficope.m_cLastMsgError;
              }
            } else {
              m_cLastMsgError = ardt_mogopebo.m_cLastMsgError;
            }
          } else {
            m_cLastMsgError = ardt_mlientiope.m_cLastMsgError;
          }
        } else {
          m_cLastMsgError = ardt_clientiope.m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = ardt_sogope.m_cLastMsgError;
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
        if (l_bResult && CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
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
            if ( ! (ardt_sogope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_sogope)) {
              ardt_sogope.SetFromContext(m_cWv_ardt_sogope);
              m_cWv_ardt_sogope = "_not_empty_";
            }
            if (ardt_sogope.IsUpdated()) {
              ardt_sogope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_sogope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_clientiope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_clientiope)) {
              ardt_clientiope.SetFromContext(m_cWv_ardt_clientiope);
              m_cWv_ardt_clientiope = "_not_empty_";
            }
            if (ardt_clientiope.IsUpdated()) {
              ardt_clientiope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_clientiope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_mlientiope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_mlientiope)) {
              ardt_mlientiope.SetFromContext(m_cWv_ardt_mlientiope);
              m_cWv_ardt_mlientiope = "_not_empty_";
            }
            if (ardt_mlientiope.IsUpdated()) {
              ardt_mlientiope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_mlientiope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_mogopebo.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_mogopebo)) {
              ardt_mogopebo.SetFromContext(m_cWv_ardt_mogopebo);
              m_cWv_ardt_mogopebo = "_not_empty_";
            }
            if (ardt_mogopebo.IsUpdated()) {
              ardt_mogopebo.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_mogopebo.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_beneficope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_beneficope)) {
              ardt_beneficope.SetFromContext(m_cWv_ardt_beneficope);
              m_cWv_ardt_beneficope = "_not_empty_";
            }
            if (ardt_beneficope.IsUpdated()) {
              ardt_beneficope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_beneficope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_meneficope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_meneficope)) {
              ardt_meneficope.SetFromContext(m_cWv_ardt_meneficope);
              m_cWv_ardt_meneficope = "_not_empty_";
            }
            if (ardt_meneficope.IsUpdated()) {
              ardt_meneficope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_meneficope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_terzistiope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_terzistiope)) {
              ardt_terzistiope.SetFromContext(m_cWv_ardt_terzistiope);
              m_cWv_ardt_terzistiope = "_not_empty_";
            }
            if (ardt_terzistiope.IsUpdated()) {
              ardt_terzistiope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_terzistiope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_merzistiope.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_merzistiope)) {
              ardt_merzistiope.SetFromContext(m_cWv_ardt_merzistiope);
              m_cWv_ardt_merzistiope = "_not_empty_";
            }
            if (ardt_merzistiope.IsUpdated()) {
              ardt_merzistiope.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_merzistiope.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_rapcoll.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_rapcoll)) {
              ardt_rapcoll.SetFromContext(m_cWv_ardt_rapcoll);
              m_cWv_ardt_rapcoll = "_not_empty_";
            }
            if (ardt_rapcoll.IsUpdated()) {
              ardt_rapcoll.w_IDFILEBO = w_IDBASE;
              if ( ! (ardt_rapcoll.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_docopebo.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_docopebo)) {
              ardt_docopebo.SetFromContext(m_cWv_ardt_docopebo);
              m_cWv_ardt_docopebo = "_not_empty_";
            }
            if (ardt_docopebo.IsUpdated()) {
              ardt_docopebo.w_NUMPROG = w_NUMPROG;
              if ( ! (ardt_docopebo.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (armt_operazbo_agg.IsUpdated()) && CPLib.IsUpdated(m_cWv_armt_operazbo_agg)) {
              armt_operazbo_agg.SetFromContext(m_cWv_armt_operazbo_agg);
              m_cWv_armt_operazbo_agg = "_not_empty_";
            }
            if (armt_operazbo_agg.IsUpdated()) {
              armt_operazbo_agg.w_IDBASE = w_IDBASE;
              if ( ! (armt_operazbo_agg.Save(true))) {
                m_Sql.AbortTransaction();
              }
            }
          }
          if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
            if ( ! (ardt_ope_contante.IsUpdated()) && CPLib.IsUpdated(m_cWv_ardt_ope_contante)) {
              ardt_ope_contante.SetFromContext(m_cWv_ardt_ope_contante);
              m_cWv_ardt_ope_contante = "_not_empty_";
            }
            if (ardt_ope_contante.IsUpdated()) {
              ardt_ope_contante.w_IDOPE = w_IDBASE;
              if ( ! (ardt_ope_contante.Save(true))) {
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
    }
    return l_bResult;
  }
  public static String[] m_cLoadParameterNames = {"IDBASE"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_IDBASE) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_operazbo,m_cPhName_operazbo,m_cVirtName_operazbo,m_cVirtName_operazbo+".IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDBASE,"C",10,0),m_cServer_operazbo,p_IDBASE),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_28(m_cPhName_intermbo,m_cServer_intermbo);
    l_oSqlLoader.AddJoinedLink_1_30(m_cPhName_anadip,m_cServer_anadip);
    l_oSqlLoader.AddJoinedLink_1_51(m_cPhName_tbcausin,m_cServer_tbcausin);
    l_oSqlLoader.AddJoinedLink_1_54(m_cPhName_tbvalute,m_cServer_tbvalute);
    l_oSqlLoader.AddJoinedLink_1_63(m_cPhName_anarapbo,m_cServer_anarapbo);
    l_oSqlLoader.AddJoinedLink_1_64(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_69(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_72(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_1_73(m_cPhName_personbo,m_cServer_personbo);
    l_oSqlLoader.AddJoinedLink_4_16(m_cPhName_tbtipope,m_cServer_tbtipope);
    l_oSqlLoader.AddJoinedLink_5_8(m_cPhName_kersonbo,m_cServer_kersonbo);
    l_oSqlLoader.AddJoinedLink_6_4(m_cPhName_tbdurata,m_cServer_tbdurata);
    l_oSqlLoader.AddJoinedLink_6_6(m_cPhName_tbimporto,m_cServer_tbimporto);
    l_oSqlLoader.AddJoinedLink_6_8(m_cPhName_tbareegeog,m_cServer_tbareegeog);
    l_oSqlLoader.AddJoinedLink_6_10(m_cPhName_tbsvolgim,m_cServer_tbsvolgim);
    l_oSqlLoader.AddJoinedLink_6_12(m_cPhName_tbplauso,m_cServer_tbplauso);
    l_oSqlLoader.AddJoinedLink_6_14(m_cPhName_tbtiporisc,m_cServer_tbtiporisc);
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
        w_gIntemediario = m_Ctx.GetGlobalString("gIntemediario");
        w_gChkDate = m_Ctx.GetGlobalString("gChkDate");
        w_gTipInter = m_Ctx.GetGlobalString("gTipInter");
        w_gSblocco = m_Ctx.GetGlobalString("gSblocco");
        w_gDataVaria = m_Ctx.GetGlobalDate("gDataVaria");
        w_gStatus = m_Ctx.GetGlobalString("gStatus");
        w_gFlgDoc = m_Ctx.GetGlobalString("gFlgDoc");
        w_gFlgWU = m_Ctx.GetGlobalString("gFlgWU");
        w_gFlgDTP = m_Ctx.GetGlobalNumber("gFlgDTP");
        w_gSeekAos = m_Ctx.GetGlobalString("gSeekAos");
        w_gVerSim = m_Ctx.GetGlobalString("gVerSim");
        w_test = "";
        w_datpaseuro = CPLib.NullDate();
        w_xTOTLIRE = 0;
        w_xTOTCONT = 0;
        w_xdestipleg = "";
        w_xragsocct = "";
        w_xDescDipe = "";
        w_descdiv = "";
        w_valflg2 = "";
        w_xragint2 = "";
        w_errmsg = "";
        w_xragsocper = "";
        w_desccauana = "";
        w_xragsocben = "";
        w_xdesccausin = "";
        w_xdescpaese2 = "";
        w_xdescrap = "";
        w_xdes1 = "";
        w_xcodfisc = "";
        w_xdciticon = "";
        w_dessta = "";
        w_xragsocalt = "";
        w_xFLGITAEST = "";
        w_CITINT = "";
        w_CITDIP = "";
        w_PROVDIP = "";
        w_CABDIP = "";
        w_PROVINT = "";
        w_CABINT = "";
        w_DATAVALI = CPLib.NullDate();
        w_DATARILASC = CPLib.NullDate();
        w_xdescopeage = "";
        w_xdescfreq = "";
        w_xdescammo = "";
        w_xdescareag = "";
        w_xdescmodsvo = "";
        w_xdescplauso = "";
        w_xdesctipor = "";
        w_xRAGSOCDOC = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_dataoggi = CPLib.Date();
        w_filtro = "O";
        w_sEdit = 0;
        w_tipope = "1";
        w_stringaflagrap2 = "ABCDEFGHI";
        w_IDBASE = l_rsLoad.GetString("IDBASE");
        op_IDBASE = w_IDBASE;
        w_CODINTER = l_rsLoad.GetString("CODINTER");
        if (l_oSqlLoader.m_bLink_1_28) {
          w_datpaseuro = l_rsLoad.GetDate("DATANASC128");
          w_CABINT = l_rsLoad.GetString("CODCAB128");
          w_PROVINT = l_rsLoad.GetString("PROVINCIA128");
          w_CITINT = l_rsLoad.GetString("DESCCIT128");
        } else {
          Link_WJSVGWKSFC("Load");
        }
        w_CODDIPE = l_rsLoad.GetString("CODDIPE");
        if (l_oSqlLoader.m_bLink_1_30) {
          w_xDescDipe = l_rsLoad.GetString("DESCRIZ130");
          w_CITDIP = l_rsLoad.GetString("DESCCIT130");
          w_PROVDIP = l_rsLoad.GetString("PROVINCIA130");
          w_CABDIP = l_rsLoad.GetString("CAB130");
        } else {
          Link_AVHTGZTOSZ("Load");
        }
        w_DESCCIT = l_rsLoad.GetString("DESCCIT");
        w_PROVINCIA = l_rsLoad.GetString("PROVINCIA");
        w_CODCAB = l_rsLoad.GetString("CODCAB");
        w_DATAOPE = l_rsLoad.GetDate("DATAOPE");
        w_NUMPROG = l_rsLoad.GetString("NUMPROG");
        op_NUMPROG = w_NUMPROG;
        w_CDATOPE = l_rsLoad.GetString("CDATOPE");
        w_CDATAOPE = l_rsLoad.GetString("CDATAOPE");
        w_ANNOOPE = l_rsLoad.GetDouble("ANNOOPE");
        w_IDEREG = l_rsLoad.GetString("IDEREG");
        w_DATAREG = l_rsLoad.GetDate("DATAREG");
        w_CDATREG = l_rsLoad.GetString("CDATREG");
        w_FLAGFRAZ = l_rsLoad.GetString("FLAGFRAZ");
        w_COLLEG = l_rsLoad.GetString("COLLEG");
        w_TIPOOPRAP = l_rsLoad.GetString("TIPOOPRAP");
        w_idcauana = l_rsLoad.GetString("idcauana");
        w_CODANA = "";
        w_CODVOC = "";
        w_SEGNO = "";
        w_NOSARA = "";
        w_xFLGITAEST = "";
        w_desccauana = "";
        Link_XDPPAEWQFR("Load");
        w_CODANA = l_rsLoad.GetString("CODANA");
        w_desccauana = "";
        Link_SQVJLYRFKQ("Load");
        w_CODVOC = l_rsLoad.GetString("CODVOC");
        if (l_oSqlLoader.m_bLink_1_51) {
          w_xdesccausin = l_rsLoad.GetString("DESCRIZ151");
        } else {
          Link_SRWWPHPCUB("Load");
        }
        w_FLAGLIRE = l_rsLoad.GetString("FLAGLIRE");
        w_appolire = (CPLib.eq(w_FLAGLIRE,"1") || CPLib.eq(w_FLAGLIRE,"7")?"L":(CPLib.eq(w_FLAGLIRE,"3") || CPLib.eq(w_FLAGLIRE,"5") || CPLib.Empty(w_FLAGLIRE)?"E":"V"));
        w_VALUTA = l_rsLoad.GetString("VALUTA");
        if (l_oSqlLoader.m_bLink_1_54) {
          w_descdiv = l_rsLoad.GetString("DESCRI154");
        } else {
          Link_MKCXJZEKIG("Load");
        }
        w_FLAGCONT = l_rsLoad.GetString("FLAGCONT");
        w_CAMBIO = l_rsLoad.GetDouble("CAMBIO");
        w_IMPIN = l_rsLoad.GetDouble("IMPIN");
        w_IMPOUT = l_rsLoad.GetDouble("IMPOUT");
        w_RAPPORTO = l_rsLoad.GetString("RAPPORTO");
        if (l_oSqlLoader.m_bLink_1_63) {
          w_xdescrap = l_rsLoad.GetString("DESCRAP163");
          w_FLAGRAP = l_rsLoad.GetString("TIPORAP163");
        } else {
          Link_RZIQZFKPUE("Load");
        }
        w_CONNESCLI = l_rsLoad.GetString("CONNESCLI");
        if (l_oSqlLoader.m_bLink_1_64) {
          w_xragsocper = l_rsLoad.GetString("RAGSOC164");
          w_xcodfisc = l_rsLoad.GetString("CODFISC164");
          w_DATAVALI = l_rsLoad.GetDate("DATAVALI164");
          w_DATARILASC = l_rsLoad.GetDate("DATARILASC164");
        } else {
          Link_QBLXDBODXR("Load");
        }
        w_PROQUOTA = l_rsLoad.GetDouble("PROQUOTA");
        w_IMPSARA = l_rsLoad.GetDouble("IMPSARA");
        w_CONNESOPER = l_rsLoad.GetString("CONNESOPER");
        if (l_oSqlLoader.m_bLink_1_69) {
          w_xragsocct = l_rsLoad.GetString("RAGSOC169");
        } else {
          Link_TCOTJNZLGM("Load");
        }
        w_TIPOLEG = l_rsLoad.GetString("TIPOLEG");
        w_PAGASOGOP = l_rsLoad.GetString("PAGASOGOP");
        w_CONNESBEN = l_rsLoad.GetString("CONNESBEN");
        if (l_oSqlLoader.m_bLink_1_72) {
          w_xragsocben = l_rsLoad.GetString("RAGSOC172");
          w_C_RAPPORTO = l_rsLoad.GetString("CONTO172");
        } else {
          Link_ULVCBLFVEU("Load");
        }
        w_CONNALTRO = l_rsLoad.GetString("CONNALTRO");
        if (l_oSqlLoader.m_bLink_1_73) {
          w_xragsocalt = l_rsLoad.GetString("RAGSOC173");
        } else {
          Link_HWFHDWYMIU("Load");
        }
        w_C_RAG = l_rsLoad.GetString("C_RAG");
        w_C_CTA = l_rsLoad.GetString("C_CTA");
        // Link con tbcitta non eseguito: riporta solo campi
        w_C_PRV = l_rsLoad.GetString("C_PRV");
        w_C_CAP = l_rsLoad.GetString("C_CAP");
        w_C_CAB = l_rsLoad.GetString("C_CAB");
        w_C_IND = l_rsLoad.GetString("C_IND");
        w_C_STA = l_rsLoad.GetString("C_STA");
        w_dessta = "";
        Link_YVIKEGPYPM("Load");
        w_TIPOINT2 = l_rsLoad.GetString("TIPOINT2");
        w_CODINT2 = l_rsLoad.GetString("CODINT2");
        // Link con inter2bo non eseguito: riporta solo campi
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_PAESE = l_rsLoad.GetString("PAESE");
        w_xdescpaese2 = "";
        Link_NYRJHOZOON("Load");
        w_C_RAPPORTO = l_rsLoad.GetString("C_RAPPORTO");
        w_CODCAB2 = l_rsLoad.GetString("CODCAB2");
        w_DESC2 = "";
        w_PROV2 = "";
        w_xdciticon = "";
        Link_YQINIDXZSL("Load");
        w_DESC2 = l_rsLoad.GetString("DESC2");
        w_PROV2 = l_rsLoad.GetString("PROV2");
        w_ZCPARTE = l_rsLoad.GetString("ZCPARTE");
        w_STATOREG = l_rsLoad.GetString("STATOREG");
        w_DATARETT = l_rsLoad.GetDate("DATARETT");
        w_OPERAZMOD = l_rsLoad.GetString("OPERAZMOD");
        w_apporeg = CPLib.DateToChar(w_DATAREG);
        w_TIPOINF = l_rsLoad.GetString("TIPOINF");
        w_SEGNO = l_rsLoad.GetString("SEGNO");
        w_TOTLIRE = l_rsLoad.GetDouble("TOTLIRE");
        w_TOTCONT = l_rsLoad.GetDouble("TOTCONT");
        w_DESCINTER = l_rsLoad.GetString("DESCINTER");
        w_FLAGRAP = l_rsLoad.GetString("FLAGRAP");
        w_OPRAP = l_rsLoad.GetString("OPRAP");
        w_RAPPORTBEN = l_rsLoad.GetString("RAPPORTBEN");
        w_OPERATORE = l_rsLoad.GetString("OPERATORE");
        w_AUTOM = l_rsLoad.GetString("AUTOM");
        w_FLAGRAP2 = l_rsLoad.GetString("FLAGRAP2");
        w_PRGIMPOPE = l_rsLoad.GetDouble("PRGIMPOPE");
        op_PRGIMPOPE = w_PRGIMPOPE;
        w_CONNESDOC = l_rsLoad.GetString("CONNESDOC");
        w_IDBASE2 = l_rsLoad.GetString("IDBASE2");
        w_NOSARA = l_rsLoad.GetString("NOSARA");
        w_CALCOLI = true;
        w_COMPLETA = true;
        w_IPCOLLEG = l_rsLoad.GetString("IPCOLLEG");
        w_ORACOLLEG = l_rsLoad.GetDateTime("ORACOLLEG");
        w_DUCOLLEG = l_rsLoad.GetDouble("DUCOLLEG");
        w_NOPROT = l_rsLoad.GetDouble("NOPROT");
        w_OPERAG = l_rsLoad.GetString("OPERAG");
        if (l_oSqlLoader.m_bLink_4_16) {
          w_xdescopeage = l_rsLoad.GetString("DESCRI416");
        } else {
          Link_QEFXECTWSF("Load");
        }
        w_RESPINS = l_rsLoad.GetString("RESPINS");
        w_INFORM = l_rsLoad.GetString("INFORM");
        w_NATURA = l_rsLoad.GetString("NATURA");
        w_SCOPO = l_rsLoad.GetString("SCOPO");
        w_SV58550 = l_rsLoad.GetString("SV58550");
        w_SV58550MA = l_rsLoad.GetString("SV58550MA");
        w_DURAT = l_rsLoad.GetString("DURAT");
        // Link con tbdurata_p non eseguito: riporta solo campi
        w_AMMONT = l_rsLoad.GetString("AMMONT");
        // Link con tbimporto_p non eseguito: riporta solo campi
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        // Link con tbareegeog_p non eseguito: riporta solo campi
        w_MODSVOL = l_rsLoad.GetString("MODSVOL");
        // Link con tbsvolgim_p non eseguito: riporta solo campi
        w_RAGIO = l_rsLoad.GetString("RAGIO");
        // Link con tbplauso_p non eseguito: riporta solo campi
        w_TIPO = l_rsLoad.GetString("TIPO");
        // Link con tbtiporisc_p non eseguito: riporta solo campi
        w_MEZPAG = l_rsLoad.GetString("MEZPAG");
        w_PRESTAZ = l_rsLoad.GetString("PRESTAZ");
        w_DESPUNTO = l_rsLoad.GetString("DESPUNTO");
        w_CODCLICON = l_rsLoad.GetString("CODCLICON");
        w_TIPATT = l_rsLoad.GetString("TIPATT");
        w_VASP = l_rsLoad.GetString("VASP");
        w_RIFIMP = l_rsLoad.GetString("RIFIMP");
        w_CONNESDOC = l_rsLoad.GetString("CONNESDOC");
        if (l_oSqlLoader.m_bLink_5_8) {
          w_xRAGSOCDOC = l_rsLoad.GetString("RAGSOC508");
        } else {
          Link_WNMMMNSARU("Load");
        }
        w_IDFILE = l_rsLoad.GetString("IDFILE");
        w_MTCN = l_rsLoad.GetString("MTCN");
        w_DURAT = l_rsLoad.GetString("DURAT");
        if (l_oSqlLoader.m_bLink_6_4) {
          w_xdescfreq = l_rsLoad.GetString("DESCRI604");
        } else {
          Link_CKJQULDXKW("Load");
        }
        w_RFREQ = l_rsLoad.GetDouble("RFREQ");
        w_AMMONT = l_rsLoad.GetString("AMMONT");
        if (l_oSqlLoader.m_bLink_6_6) {
          w_xdescammo = l_rsLoad.GetString("DESCRI606");
        } else {
          Link_SXTYCPHBIM("Load");
        }
        w_RIMP = l_rsLoad.GetDouble("RIMP");
        w_AREAGEO = l_rsLoad.GetString("AREAGEO");
        if (l_oSqlLoader.m_bLink_6_8) {
          w_xdescareag = l_rsLoad.GetString("DESCRI608");
        } else {
          Link_QJSTZIPOQB("Load");
        }
        w_RAREA = l_rsLoad.GetDouble("RAREA");
        w_MODSVOL = l_rsLoad.GetString("MODSVOL");
        if (l_oSqlLoader.m_bLink_6_10) {
          w_xdescmodsvo = l_rsLoad.GetString("DESCRI610");
        } else {
          Link_SFFFOYOWNH("Load");
        }
        w_RCOMP = l_rsLoad.GetDouble("RCOMP");
        w_RAGIO = l_rsLoad.GetString("RAGIO");
        if (l_oSqlLoader.m_bLink_6_12) {
          w_xdescplauso = l_rsLoad.GetString("DESCRI612");
        } else {
          Link_NOBMPHKVTX("Load");
        }
        w_RRAGIO = l_rsLoad.GetDouble("RRAGIO");
        w_TIPO = l_rsLoad.GetString("TIPO");
        if (l_oSqlLoader.m_bLink_6_14) {
          w_xdesctipor = l_rsLoad.GetString("DESCRI614");
        } else {
          Link_DJOWYRMDDC("Load");
        }
        w_RTIPO = l_rsLoad.GetDouble("RTIPO");
        w_RISGLOB = l_rsLoad.GetString("RISGLOB");
        w_MITIG = l_rsLoad.GetDouble("MITIG");
        w_MITIGDOC = l_rsLoad.GetString("MITIGDOC");
        // Assegna i valori degli op_
        op_codazi = m_Ctx.GetCompany();
        // Assegna il contesto dei figli a Empty
        m_cWv_ardt_sogope = "";
        ardt_sogope.m_lCtxLoaded = false;
        m_cWv_ardt_clientiope = "";
        ardt_clientiope.m_lCtxLoaded = false;
        m_cWv_ardt_mlientiope = "";
        ardt_mlientiope.m_lCtxLoaded = false;
        m_cWv_ardt_mogopebo = "";
        ardt_mogopebo.m_lCtxLoaded = false;
        m_cWv_ardt_beneficope = "";
        ardt_beneficope.m_lCtxLoaded = false;
        m_cWv_ardt_meneficope = "";
        ardt_meneficope.m_lCtxLoaded = false;
        m_cWv_ardt_terzistiope = "";
        ardt_terzistiope.m_lCtxLoaded = false;
        m_cWv_ardt_merzistiope = "";
        ardt_merzistiope.m_lCtxLoaded = false;
        m_cWv_ardt_rapcoll = "";
        ardt_rapcoll.m_lCtxLoaded = false;
        m_cWv_ardt_docopebo = "";
        ardt_docopebo.m_lCtxLoaded = false;
        m_cWv_armt_operazbo_agg = "";
        armt_operazbo_agg.m_lCtxLoaded = false;
        m_cWv_ardt_ope_contante = "";
        ardt_ope_contante.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"operazbo")) {
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
    // * --- armt_operazioni
    SetUpdated();
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_operazbo);
      l_cSql = "insert into "+m_oWrInfo_operazbo.GetTableWriteName()+" (";
      l_cSql = l_cSql+"IDBASE,";
      l_cSql = l_cSql+"CODINTER,";
      l_cSql = l_cSql+"CODDIPE,";
      l_cSql = l_cSql+"DESCCIT,";
      l_cSql = l_cSql+"PROVINCIA,";
      l_cSql = l_cSql+"CODCAB,";
      l_cSql = l_cSql+"DATAOPE,";
      l_cSql = l_cSql+"NUMPROG,";
      l_cSql = l_cSql+"CDATOPE,";
      l_cSql = l_cSql+"CDATAOPE,";
      l_cSql = l_cSql+"ANNOOPE,";
      l_cSql = l_cSql+"IDEREG,";
      l_cSql = l_cSql+"DATAREG,";
      l_cSql = l_cSql+"CDATREG,";
      l_cSql = l_cSql+"FLAGFRAZ,";
      l_cSql = l_cSql+"COLLEG,";
      l_cSql = l_cSql+"TIPOOPRAP,";
      l_cSql = l_cSql+"idcauana,";
      l_cSql = l_cSql+"CODANA,";
      l_cSql = l_cSql+"CODVOC,";
      l_cSql = l_cSql+"FLAGLIRE,";
      l_cSql = l_cSql+"VALUTA,";
      l_cSql = l_cSql+"FLAGCONT,";
      l_cSql = l_cSql+"CAMBIO,";
      l_cSql = l_cSql+"IMPIN,";
      l_cSql = l_cSql+"IMPOUT,";
      l_cSql = l_cSql+"RAPPORTO,";
      l_cSql = l_cSql+"CONNESCLI,";
      l_cSql = l_cSql+"PROQUOTA,";
      l_cSql = l_cSql+"IMPSARA,";
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
      l_cSql = l_cSql+"DESC2,";
      l_cSql = l_cSql+"PROV2,";
      l_cSql = l_cSql+"ZCPARTE,";
      l_cSql = l_cSql+"STATOREG,";
      l_cSql = l_cSql+"DATARETT,";
      l_cSql = l_cSql+"OPERAZMOD,";
      l_cSql = l_cSql+"TIPOINF,";
      l_cSql = l_cSql+"SEGNO,";
      l_cSql = l_cSql+"TOTLIRE,";
      l_cSql = l_cSql+"TOTCONT,";
      l_cSql = l_cSql+"FLAGRAP,";
      l_cSql = l_cSql+"OPRAP,";
      l_cSql = l_cSql+"RAPPORTBEN,";
      l_cSql = l_cSql+"OPERATORE,";
      l_cSql = l_cSql+"AUTOM,";
      l_cSql = l_cSql+"FLAGRAP2,";
      l_cSql = l_cSql+"PRGIMPOPE,";
      l_cSql = l_cSql+"CONNESDOC,";
      l_cSql = l_cSql+"IDBASE2,";
      l_cSql = l_cSql+"NOSARA,";
      l_cSql = l_cSql+"IPCOLLEG,";
      l_cSql = l_cSql+"ORACOLLEG,";
      l_cSql = l_cSql+"DUCOLLEG,";
      l_cSql = l_cSql+"NOPROT,";
      l_cSql = l_cSql+"OPERAG,";
      l_cSql = l_cSql+"RESPINS,";
      l_cSql = l_cSql+"INFORM,";
      l_cSql = l_cSql+"NATURA,";
      l_cSql = l_cSql+"SCOPO,";
      l_cSql = l_cSql+"SV58550,";
      l_cSql = l_cSql+"SV58550MA,";
      l_cSql = l_cSql+"DURAT,";
      l_cSql = l_cSql+"AMMONT,";
      l_cSql = l_cSql+"AREAGEO,";
      l_cSql = l_cSql+"MODSVOL,";
      l_cSql = l_cSql+"RAGIO,";
      l_cSql = l_cSql+"TIPO,";
      l_cSql = l_cSql+"MEZPAG,";
      l_cSql = l_cSql+"PRESTAZ,";
      l_cSql = l_cSql+"DESPUNTO,";
      l_cSql = l_cSql+"CODCLICON,";
      l_cSql = l_cSql+"TIPATT,";
      l_cSql = l_cSql+"VASP,";
      l_cSql = l_cSql+"RIFIMP,";
      l_cSql = l_cSql+"IDFILE,";
      l_cSql = l_cSql+"MTCN,";
      l_cSql = l_cSql+"RFREQ,";
      l_cSql = l_cSql+"RIMP,";
      l_cSql = l_cSql+"RAREA,";
      l_cSql = l_cSql+"RCOMP,";
      l_cSql = l_cSql+"RRAGIO,";
      l_cSql = l_cSql+"RTIPO,";
      l_cSql = l_cSql+"RISGLOB,";
      l_cSql = l_cSql+"MITIG,";
      l_cSql = l_cSql+"MITIGDOC,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_operazbo.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"operazbo")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODINTER,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODDIPE,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCCIT,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROVINCIA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAOPE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NUMPROG,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATOPE,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATAOPE,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ANNOOPE,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDEREG,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAREG,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CDATREG,"C",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_COLLEG,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOOPRAP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_idcauana,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODANA,"C",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CODVOC,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGLIRE,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_VALUTA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGCONT,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CAMBIO,"N",9,4)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPIN,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPOUT,"N",15,2)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROQUOTA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IMPSARA,"N",19,2)+", ";
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
      l_cSql = l_cSql+CPLib.ToSQL(w_C_STA,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINT2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODINT2,"C",11,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCINTER,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PAESE,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_C_RAPPORTO,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCAB2,"C",6,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESC2,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PROV2,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ZCPARTE,"C",69,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_STATOREG,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERAZMOD,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPOINF,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SEGNO,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTLIRE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TOTCONT,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPRAP,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAPPORTBEN,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_OPERATORE,"C",70,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AUTOM,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_FLAGRAP2,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRGIMPOPE,"N",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CONNESDOC,"C",40,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDBASE2,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOSARA,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IPCOLLEG,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_ORACOLLEG,"T",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DUCOLLEG,"N",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NOPROT,"N",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_OPERAG,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RESPINS,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_INFORM,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_NATURA,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SCOPO,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SV58550,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_SV58550MA,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DURAT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AMMONT,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AREAGEO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_MODSVOL,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_RAGIO,"C",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_TIPO,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MEZPAG,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_PRESTAZ,"C",30,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESPUNTO,"C",80,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_CODCLICON,"C",20,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_TIPATT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_VASP,"C",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RIFIMP,"C",15,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDFILE,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MTCN,"C",10,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RFREQ,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RIMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RRAGIO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RTIPO,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_RISGLOB,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITIG,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_MITIGDOC,"C",100,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_operazbo.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"operazbo")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_operazbo,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_operazbo);
      l_cSql = "Update "+m_oWrInfo_operazbo.GetTableWriteName()+" set";
      l_cSql = l_cSql+" CODINTER = "+CPLib.ToSQLNull(w_CODINTER,"C",11,0);
      l_cSql = l_cSql+", CODDIPE = "+CPLib.ToSQLNull(w_CODDIPE,"C",6,0);
      l_cSql = l_cSql+", DESCCIT = "+CPLib.ToSQL(w_DESCCIT,"C",30,0);
      l_cSql = l_cSql+", PROVINCIA = "+CPLib.ToSQL(w_PROVINCIA,"C",2,0);
      l_cSql = l_cSql+", CODCAB = "+CPLib.ToSQL(w_CODCAB,"C",6,0);
      l_cSql = l_cSql+", DATAOPE = "+CPLib.ToSQL(w_DATAOPE,"D",8,0);
      l_cSql = l_cSql+", NUMPROG = "+CPLib.ToSQL(w_NUMPROG,"C",11,0);
      l_cSql = l_cSql+", CDATOPE = "+CPLib.ToSQL(w_CDATOPE,"C",8,0);
      l_cSql = l_cSql+", CDATAOPE = "+CPLib.ToSQL(w_CDATAOPE,"C",10,0);
      l_cSql = l_cSql+", ANNOOPE = "+CPLib.ToSQL(w_ANNOOPE,"N",4,0);
      l_cSql = l_cSql+", IDEREG = "+CPLib.ToSQL(w_IDEREG,"C",20,0);
      l_cSql = l_cSql+", DATAREG = "+CPLib.ToSQL(w_DATAREG,"D",8,0);
      l_cSql = l_cSql+", CDATREG = "+CPLib.ToSQL(w_CDATREG,"C",8,0);
      l_cSql = l_cSql+", FLAGFRAZ = "+CPLib.ToSQL(w_FLAGFRAZ,"C",1,0);
      l_cSql = l_cSql+", COLLEG = "+CPLib.ToSQL(w_COLLEG,"C",12,0);
      l_cSql = l_cSql+", TIPOOPRAP = "+CPLib.ToSQL(w_TIPOOPRAP,"C",2,0);
      l_cSql = l_cSql+", idcauana = "+CPLib.ToSQL(w_idcauana,"C",4,0);
      l_cSql = l_cSql+", CODANA = "+CPLib.ToSQLNull(w_CODANA,"C",4,0);
      l_cSql = l_cSql+", CODVOC = "+CPLib.ToSQLNull(w_CODVOC,"C",2,0);
      l_cSql = l_cSql+", FLAGLIRE = "+CPLib.ToSQL(w_FLAGLIRE,"C",1,0);
      l_cSql = l_cSql+", VALUTA = "+CPLib.ToSQLNull(w_VALUTA,"C",3,0);
      l_cSql = l_cSql+", FLAGCONT = "+CPLib.ToSQL(w_FLAGCONT,"C",1,0);
      l_cSql = l_cSql+", CAMBIO = "+CPLib.ToSQL(w_CAMBIO,"N",9,4);
      l_cSql = l_cSql+", IMPIN = "+CPLib.ToSQL(w_IMPIN,"N",15,2);
      l_cSql = l_cSql+", IMPOUT = "+CPLib.ToSQL(w_IMPOUT,"N",15,2);
      l_cSql = l_cSql+", RAPPORTO = "+CPLib.ToSQLNull(w_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", CONNESCLI = "+CPLib.ToSQLNull(w_CONNESCLI,"C",16,0);
      l_cSql = l_cSql+", PROQUOTA = "+CPLib.ToSQL(w_PROQUOTA,"N",3,0);
      l_cSql = l_cSql+", IMPSARA = "+CPLib.ToSQL(w_IMPSARA,"N",19,2);
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
      l_cSql = l_cSql+", C_STA = "+CPLib.ToSQL(w_C_STA,"C",3,0);
      l_cSql = l_cSql+", TIPOINT2 = "+CPLib.ToSQL(w_TIPOINT2,"C",2,0);
      l_cSql = l_cSql+", CODINT2 = "+CPLib.ToSQL(w_CODINT2,"C",11,0);
      l_cSql = l_cSql+", DESCINTER = "+CPLib.ToSQL(w_DESCINTER,"C",50,0);
      l_cSql = l_cSql+", PAESE = "+CPLib.ToSQL(w_PAESE,"C",3,0);
      l_cSql = l_cSql+", C_RAPPORTO = "+CPLib.ToSQL(w_C_RAPPORTO,"C",25,0);
      l_cSql = l_cSql+", CODCAB2 = "+CPLib.ToSQL(w_CODCAB2,"C",6,0);
      l_cSql = l_cSql+", DESC2 = "+CPLib.ToSQL(w_DESC2,"C",30,0);
      l_cSql = l_cSql+", PROV2 = "+CPLib.ToSQL(w_PROV2,"C",2,0);
      l_cSql = l_cSql+", ZCPARTE = "+CPLib.ToSQL(w_ZCPARTE,"C",69,0);
      l_cSql = l_cSql+", STATOREG = "+CPLib.ToSQL(w_STATOREG,"C",1,0);
      l_cSql = l_cSql+", DATARETT = "+CPLib.ToSQL(w_DATARETT,"D",8,0);
      l_cSql = l_cSql+", OPERAZMOD = "+CPLib.ToSQL(w_OPERAZMOD,"C",20,0);
      l_cSql = l_cSql+", TIPOINF = "+CPLib.ToSQL(w_TIPOINF,"C",1,0);
      l_cSql = l_cSql+", SEGNO = "+CPLib.ToSQL(w_SEGNO,"C",1,0);
      l_cSql = l_cSql+", TOTLIRE = "+CPLib.ToSQL(w_TOTLIRE,"N",15,0);
      l_cSql = l_cSql+", TOTCONT = "+CPLib.ToSQL(w_TOTCONT,"N",15,0);
      l_cSql = l_cSql+", FLAGRAP = "+CPLib.ToSQL(w_FLAGRAP,"C",1,0);
      l_cSql = l_cSql+", OPRAP = "+CPLib.ToSQL(w_OPRAP,"C",1,0);
      l_cSql = l_cSql+", RAPPORTBEN = "+CPLib.ToSQL(w_RAPPORTBEN,"C",25,0);
      l_cSql = l_cSql+", OPERATORE = "+CPLib.ToSQL(w_OPERATORE,"C",70,0);
      l_cSql = l_cSql+", AUTOM = "+CPLib.ToSQL(w_AUTOM,"C",5,0);
      l_cSql = l_cSql+", FLAGRAP2 = "+CPLib.ToSQL(w_FLAGRAP2,"C",1,0);
      l_cSql = l_cSql+", PRGIMPOPE = "+CPLib.ToSQL(w_PRGIMPOPE,"N",15,0);
      l_cSql = l_cSql+", CONNESDOC = "+CPLib.ToSQL(w_CONNESDOC,"C",40,0);
      l_cSql = l_cSql+", IDBASE2 = "+CPLib.ToSQL(w_IDBASE2,"C",10,0);
      l_cSql = l_cSql+", NOSARA = "+CPLib.ToSQL(w_NOSARA,"C",1,0);
      l_cSql = l_cSql+", IPCOLLEG = "+CPLib.ToSQL(w_IPCOLLEG,"C",15,0);
      l_cSql = l_cSql+", ORACOLLEG = "+CPLib.ToSQL(w_ORACOLLEG,"T",8,0);
      l_cSql = l_cSql+", DUCOLLEG = "+CPLib.ToSQL(w_DUCOLLEG,"N",10,0);
      l_cSql = l_cSql+", NOPROT = "+CPLib.ToSQL(w_NOPROT,"N",1,0);
      l_cSql = l_cSql+", OPERAG = "+CPLib.ToSQLNull(w_OPERAG,"C",3,0);
      l_cSql = l_cSql+", RESPINS = "+CPLib.ToSQL(w_RESPINS,"C",30,0);
      l_cSql = l_cSql+", INFORM = "+CPLib.ToSQL(w_INFORM,"C",30,0);
      l_cSql = l_cSql+", NATURA = "+CPLib.ToSQL(w_NATURA,"C",50,0);
      l_cSql = l_cSql+", SCOPO = "+CPLib.ToSQL(w_SCOPO,"C",50,0);
      l_cSql = l_cSql+", SV58550 = "+CPLib.ToSQL(w_SV58550,"C",1,0);
      l_cSql = l_cSql+", SV58550MA = "+CPLib.ToSQL(w_SV58550MA,"C",2,0);
      l_cSql = l_cSql+", DURAT = "+CPLib.ToSQLNull(w_DURAT,"C",5,0);
      l_cSql = l_cSql+", AMMONT = "+CPLib.ToSQLNull(w_AMMONT,"C",5,0);
      l_cSql = l_cSql+", AREAGEO = "+CPLib.ToSQLNull(w_AREAGEO,"C",5,0);
      l_cSql = l_cSql+", MODSVOL = "+CPLib.ToSQLNull(w_MODSVOL,"C",5,0);
      l_cSql = l_cSql+", RAGIO = "+CPLib.ToSQLNull(w_RAGIO,"C",5,0);
      l_cSql = l_cSql+", TIPO = "+CPLib.ToSQLNull(w_TIPO,"C",3,0);
      l_cSql = l_cSql+", MEZPAG = "+CPLib.ToSQL(w_MEZPAG,"C",30,0);
      l_cSql = l_cSql+", PRESTAZ = "+CPLib.ToSQL(w_PRESTAZ,"C",30,0);
      l_cSql = l_cSql+", DESPUNTO = "+CPLib.ToSQL(w_DESPUNTO,"C",80,0);
      l_cSql = l_cSql+", CODCLICON = "+CPLib.ToSQL(w_CODCLICON,"C",20,0);
      l_cSql = l_cSql+", TIPATT = "+CPLib.ToSQL(w_TIPATT,"C",3,0);
      l_cSql = l_cSql+", VASP = "+CPLib.ToSQL(w_VASP,"C",2,0);
      l_cSql = l_cSql+", RIFIMP = "+CPLib.ToSQL(w_RIFIMP,"C",15,0);
      l_cSql = l_cSql+", IDFILE = "+CPLib.ToSQL(w_IDFILE,"C",60,0);
      l_cSql = l_cSql+", MTCN = "+CPLib.ToSQL(w_MTCN,"C",10,0);
      l_cSql = l_cSql+", RFREQ = "+CPLib.ToSQL(w_RFREQ,"N",3,0);
      l_cSql = l_cSql+", RIMP = "+CPLib.ToSQL(w_RIMP,"N",3,0);
      l_cSql = l_cSql+", RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0);
      l_cSql = l_cSql+", RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0);
      l_cSql = l_cSql+", RRAGIO = "+CPLib.ToSQL(w_RRAGIO,"N",3,0);
      l_cSql = l_cSql+", RTIPO = "+CPLib.ToSQL(w_RTIPO,"N",3,0);
      l_cSql = l_cSql+", RISGLOB = "+CPLib.ToSQL(w_RISGLOB,"C",1,0);
      l_cSql = l_cSql+", MITIG = "+CPLib.ToSQL(w_MITIG,"N",4,0);
      l_cSql = l_cSql+", MITIGDOC = "+CPLib.ToSQL(w_MITIGDOC,"C",100,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"operazbo")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_operazbo,w_IDBASE);
      l_cSql = l_cSql+m_oWrInfo_operazbo.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"operazbo")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_operazbo,l_cSql,m_oParameters);
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
    // * --- armt_operazioni
    m_bLoaded = false;
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
          ardt_sogope.w_IDFILEBO = w_IDBASE;
          ardt_sogope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio Intestatari Operazioni
          ardt_clientiope.w_IDFILEBO = w_IDBASE;
          ardt_clientiope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio Intestatari Operazioni
          ardt_mlientiope.w_IDFILEBO = w_IDBASE;
          ardt_mlientiope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio + Soggetti Oper. Conto Terzi
          ardt_mogopebo.w_IDFILEBO = w_IDBASE;
          ardt_mogopebo.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_beneficope.w_IDFILEBO = w_IDBASE;
          ardt_beneficope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_meneficope.w_IDFILEBO = w_IDBASE;
          ardt_meneficope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_terzistiope.w_IDFILEBO = w_IDBASE;
          ardt_terzistiope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_merzistiope.w_IDFILEBO = w_IDBASE;
          ardt_merzistiope.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio Rapporti Collegati
          ardt_rapcoll.w_IDFILEBO = w_IDBASE;
          ardt_rapcoll.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_docopebo.w_NUMPROG = w_NUMPROG;
          ardt_docopebo.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          armt_operazbo_agg.w_IDBASE = w_IDBASE;
          armt_operazbo_agg.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          ardt_ope_contante.w_IDOPE = w_IDBASE;
          ardt_ope_contante.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_operazbo.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0),m_cServer_operazbo,w_IDBASE);
          l_cSql = l_cSql+m_oWrInfo_operazbo.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"operazbo")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_operazbo,l_cSql);
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
    // * --- armt_operazioni
    m_Sql.RequireTransaction();
    NotifyEvent("Delete end");
    // BROnDeleted();        
    l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
    // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
    // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
    // la parte di transazione corrente
    m_Sql.CompleteTransaction();  
    if (l_bTrsOk) {
      NotifyEvent("Record Deleted");
    }  
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
    m_Sql.NextTableProg(this,"POPERAZ1","i_codazi,w_IDBASE",m_cServer_operazbo,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave IDBASE, altrimenti non si riesce a linkare da zoom
    w_IDBASE = CPLib.RTrim(w_IDBASE);
    op_IDBASE = w_IDBASE;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    // I dati dal browser arrivano senza spazi suffissi, NextTableProg usa la lunghezza della stringa per anteporre gli 0 a NUMPROG
    w_NUMPROG = CPLib.Left(w_NUMPROG,11)+CPLib.Space(11-CPLib.Len(w_NUMPROG));
    m_Sql.NextTableProg(this,"POPERAZ2","i_codazi,w_NUMPROG",m_cServer_operazbo,m_Ctx.GetCompany());
    // Per compatibilita' con PostgreSQL effettuo il Trim della chiave NUMPROG, altrimenti non si riesce a linkare da zoom
    w_NUMPROG = CPLib.RTrim(w_NUMPROG);
    op_NUMPROG = w_NUMPROG;
    // Segna le variabili coinvolte in un progressivo: se al salvataggio hanno lo stesso valore vuol dire che l' utente accetta il progressivo proposto.
    m_Sql.NextTableProg(this,"PRGIMPOPE","i_codazi,w_PRGIMPOPE",m_cServer_operazbo,m_Ctx.GetCompany());
    op_PRGIMPOPE = w_PRGIMPOPE;
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"WJSVGWKSFC")) {
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
      result.AppendFieldsHash("WJSVGWKSFC",CPLib.GetLinkedFieldProps("CODINTER","CODINTER","C",11,0),CPLib.GetLinkedFieldProps("DATANASC","datpaseuro","D",8,0),CPLib.GetLinkedFieldProps("CODCAB","CABINT","C",6,0),CPLib.GetLinkedFieldProps("PROVINCIA","PROVINT","C",2,0),CPLib.GetLinkedFieldProps("DESCCIT","CITINT","C",30,0));
    } else if (CPLib.eq(p_cID,"AVHTGZTOSZ")) {
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
      result.AppendFieldsHash("AVHTGZTOSZ",CPLib.GetLinkedFieldProps("CODDIP","CODDIPE","C",6,0));
    } else if (CPLib.eq(p_cID,"XDPPAEWQFR")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"idbase" , "CODCAU" , "CAUSINT" , "SEGNO" , "NOSARA" , "FLGINTER" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C" , "C" , "C" , "C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XDPPAEWQFR",CPLib.GetLinkedFieldProps("idbase","idcauana","C",4,0));
      result.AppendFilter("VALPERINT","C","like",true);
    } else if (CPLib.eq(p_cID,"SQVJLYRFKQ")) {
      result.m_TableName = "tbcauana";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_causalia";
      result.m_rdField = new String[]{"CODCAU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SQVJLYRFKQ",CPLib.GetLinkedFieldProps("CODCAU","CODANA","C",4,0));
    } else if (CPLib.eq(p_cID,"SRWWPHPCUB")) {
      result.m_TableName = "tbcausin";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "armt_causalis";
      result.m_rdField = new String[]{"CODVOC" , "DESCRIZ"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("SRWWPHPCUB",CPLib.GetLinkedFieldProps("CODVOC","CODVOC","C",2,0));
    } else if (CPLib.eq(p_cID,"MKCXJZEKIG")) {
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
      result.AppendFieldsHash("MKCXJZEKIG",CPLib.GetLinkedFieldProps("CODVAL","VALUTA","C",3,0));
    } else if (CPLib.eq(p_cID,"RZIQZFKPUE")) {
      result.m_TableName = "anarapbo";
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
      result.AppendFieldsHash("RZIQZFKPUE",CPLib.GetLinkedFieldProps("RAPPORTO","RAPPORTO","C",25,0));
    } else if (CPLib.eq(p_cID,"QBLXDBODXR")) {
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
      result.AppendFieldsHash("QBLXDBODXR",CPLib.GetLinkedFieldProps("CONNES","CONNESCLI","C",16,0));
    } else if (CPLib.eq(p_cID,"TCOTJNZLGM")) {
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
      result.AppendFieldsHash("TCOTJNZLGM",CPLib.GetLinkedFieldProps("CONNES","CONNESOPER","C",16,0));
    } else if (CPLib.eq(p_cID,"ULVCBLFVEU")) {
      result.m_TableName = "personbo";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CONNES" , "RAGSOC" , "CONTO"};
      result.m_rdTypes = new String[]{"C" , "C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ULVCBLFVEU",CPLib.GetLinkedFieldProps("CONNES","CONNESBEN","C",16,0));
    } else if (CPLib.eq(p_cID,"HWFHDWYMIU")) {
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
      result.AppendFieldsHash("HWFHDWYMIU",CPLib.GetLinkedFieldProps("CONNES","CONNALTRO","C",16,0));
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
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YVIKEGPYPM",CPLib.GetLinkedFieldProps("CODSTA","C_STA","C",3,0));
    } else if (CPLib.eq(p_cID,"CDJFSCCGNX")) {
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
      result.AppendFieldsHash("CDJFSCCGNX",CPLib.GetLinkedFieldProps("CODINTER","CODINT2","C",11,0));
    } else if (CPLib.eq(p_cID,"NYRJHOZOON")) {
      result.m_TableName = "tbstati";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODSTA" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NYRJHOZOON",CPLib.GetLinkedFieldProps("CODSTA","PAESE","C",3,0));
    } else if (CPLib.eq(p_cID,"YQINIDXZSL")) {
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
      result.AppendFieldsHash("YQINIDXZSL",CPLib.GetLinkedFieldProps("CAB","CODCAB2","C",6,0));
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
    } else if (CPLib.eq(p_cID,"VMVNJQLPEN")) {
      result.m_TableName = "tbdurata_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VMVNJQLPEN",CPLib.GetLinkedFieldProps("CODICE","DURAT","C",5,0));
    } else if (CPLib.eq(p_cID,"ASETEUZIOS")) {
      result.m_TableName = "tbimporto_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ASETEUZIOS",CPLib.GetLinkedFieldProps("CODICE","AMMONT","C",5,0));
    } else if (CPLib.eq(p_cID,"UXDPSYOTRU")) {
      result.m_TableName = "tbareegeog_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("UXDPSYOTRU",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",5,0));
    } else if (CPLib.eq(p_cID,"VZKBEOYRRK")) {
      result.m_TableName = "tbsvolgim_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VZKBEOYRRK",CPLib.GetLinkedFieldProps("CODICE","MODSVOL","C",5,0));
    } else if (CPLib.eq(p_cID,"NVHOMNEASH")) {
      result.m_TableName = "tbplauso_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NVHOMNEASH",CPLib.GetLinkedFieldProps("CODICE","RAGIO","C",5,0));
    } else if (CPLib.eq(p_cID,"XSVOIKCEKR")) {
      result.m_TableName = "tbtiporisc_p";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"CODICE" , "RISCHIO"};
      result.m_rdTypes = new String[]{"C" , "N"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XSVOIKCEKR",CPLib.GetLinkedFieldProps("CODICE","TIPO","C",3,0));
    } else if (CPLib.eq(p_cID,"WNMMMNSARU")) {
      result.m_TableName = "kersonbo";
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
      result.AppendFieldsHash("WNMMMNSARU",CPLib.GetLinkedFieldProps("CONNES","CONNESDOC","C",50,0));
    } else if (CPLib.eq(p_cID,"CKJQULDXKW")) {
      result.m_TableName = "tbdurata";
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
      result.AppendFieldsHash("CKJQULDXKW",CPLib.GetLinkedFieldProps("CODICE","DURAT","C",5,0));
    } else if (CPLib.eq(p_cID,"SXTYCPHBIM")) {
      result.m_TableName = "tbimporto";
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
      result.AppendFieldsHash("SXTYCPHBIM",CPLib.GetLinkedFieldProps("CODICE","AMMONT","C",5,0));
    } else if (CPLib.eq(p_cID,"QJSTZIPOQB")) {
      result.m_TableName = "tbareegeog";
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
      result.AppendFieldsHash("QJSTZIPOQB",CPLib.GetLinkedFieldProps("CODICE","AREAGEO","C",5,0));
    } else if (CPLib.eq(p_cID,"SFFFOYOWNH")) {
      result.m_TableName = "tbsvolgim";
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
      result.AppendFieldsHash("SFFFOYOWNH",CPLib.GetLinkedFieldProps("CODICE","MODSVOL","C",5,0));
    } else if (CPLib.eq(p_cID,"NOBMPHKVTX")) {
      result.m_TableName = "tbplauso";
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
      result.AppendFieldsHash("NOBMPHKVTX",CPLib.GetLinkedFieldProps("CODICE","RAGIO","C",5,0));
    } else if (CPLib.eq(p_cID,"DJOWYRMDDC")) {
      result.m_TableName = "tbtiporisc";
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
      result.AppendFieldsHash("DJOWYRMDDC",CPLib.GetLinkedFieldProps("CODICE","TIPO","C",3,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_calcflaglire,arfn_chkdatdoc,arfn_chkdatreg,arfn_chksogg,arfn_chktotalelire,arfn_chktotalelire_cont,arfn_read_tipoleg,arrt_copiaoperazione,arrt_crea_idereg,arrt_deloperazione,arrt_imp_frischio,arrt_li_operazbo,arrt_updel_opextrbo,arrt_val_benefic,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_calcflaglire,arfn_chkdatdoc,arfn_chkdatreg,arfn_chksogg,arfn_chktotalelire,arfn_chktotalelire_cont,arfn_read_tipoleg,arrt_copiaoperazione,arrt_crea_idereg,arrt_deloperazione,arrt_imp_frischio,arrt_li_operazbo,arrt_updel_opextrbo,arrt_val_benefic,arrt_writelog,";
}
