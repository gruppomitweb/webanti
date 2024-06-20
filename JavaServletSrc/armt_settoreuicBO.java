// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class armt_settoreuicBO extends armt_settoreuicBL {
  class SqlLoader {
    public boolean m_bLink_1_24 = false;
    public boolean m_bLink_1_25 = false;
    public boolean m_bLink_1_27 = false;
    public boolean m_bLink_1_29 = false;
    public boolean m_bLink_1_30 = false;
    public boolean m_bLink_1_32 = false;
    public boolean m_bLink_1_33 = false;
    public boolean m_bLink_1_35 = false;
    public boolean m_bLink_1_36 = false;
    public boolean m_bLink_1_38 = false;
    public boolean m_bLink_1_49 = false;
    public boolean m_bLink_1_51 = false;
    public boolean m_bLink_2_2 = false;
    public boolean m_bLink_2_4 = false;
    public boolean m_bLink_2_21 = false;
    public boolean m_bLink_2_22 = false;
    public boolean m_bLink_2_23 = false;
    public boolean m_bLink_2_24 = false;
    public boolean m_bLink_2_25 = false;
    public boolean m_bLink_2_26 = false;
    public boolean m_bLink_2_27 = false;
    public boolean m_bLink_2_28 = false;
    public boolean m_bLink_2_29 = false;
    public boolean m_bLink_2_30 = false;
    public boolean m_bLink_2_49 = false;
    public boolean m_bLink_2_50 = false;
    public boolean m_bLink_2_51 = false;
    public boolean m_bLink_2_52 = false;
    public boolean m_bLink_2_53 = false;
    public boolean m_bLink_2_54 = false;
    public boolean m_bLink_2_55 = false;
    public boolean m_bLink_2_56 = false;
    public boolean m_bLink_2_57 = false;
    public boolean m_bLink_2_58 = false;
    public boolean m_bLink_2_59 = false;
    public boolean m_bLink_2_60 = false;
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
    public void AddJoinedLink_2_2(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_2.SOTGRU AS SOTGRU202";
        m_cSelect = m_cSelect+" ,link_2_2.DESCRI AS DESCRI202";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_2","DASOT1","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_2","DASOT1","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_2 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_4(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_4.SOTGRU AS SOTGRU204";
        m_cSelect = m_cSelect+" ,link_2_4.DESCRI AS DESCRI204";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_4","ASOT1","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_4","ASOT1","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_4 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_21(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_21.SOTGRU AS SOTGRU221";
        m_cSelect = m_cSelect+" ,link_2_21.DESCRI AS DESCRI221";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_21","DASOT2","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_21","DASOT2","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_21 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_22(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_22.SOTGRU AS SOTGRU222";
        m_cSelect = m_cSelect+" ,link_2_22.DESCRI AS DESCRI222";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_22","ASOT2","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_22","ASOT2","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_22 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_23(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_23.SOTGRU AS SOTGRU223";
        m_cSelect = m_cSelect+" ,link_2_23.DESCRI AS DESCRI223";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_23","DASOT3","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_23","DASOT3","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_23 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_24(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_24.SOTGRU AS SOTGRU224";
        m_cSelect = m_cSelect+" ,link_2_24.DESCRI AS DESCRI224";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_24","ASOT3","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_24","ASOT3","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_24 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_25(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_25.SOTGRU AS SOTGRU225";
        m_cSelect = m_cSelect+" ,link_2_25.DESCRI AS DESCRI225";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_25","DASOT4","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_25","DASOT4","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_25 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_26(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_26.SOTGRU AS SOTGRU226";
        m_cSelect = m_cSelect+" ,link_2_26.DESCRI AS DESCRI226";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_26","ASOT4","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_26","ASOT4","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_26 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_27(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_27.SOTGRU AS SOTGRU227";
        m_cSelect = m_cSelect+" ,link_2_27.DESCRI AS DESCRI227";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_27","DASOT5","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_27","DASOT5","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_27 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_28(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_28.SOTGRU AS SOTGRU228";
        m_cSelect = m_cSelect+" ,link_2_28.DESCRI AS DESCRI228";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_28","ASOT5","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_28","ASOT5","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_28 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_29(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_29.SOTGRU AS SOTGRU229";
        m_cSelect = m_cSelect+" ,link_2_29.DESCRI AS DESCRI229";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_29","DASOT6","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_29","DASOT6","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_29 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_30(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_30.SOTGRU AS SOTGRU230";
        m_cSelect = m_cSelect+" ,link_2_30.DESCRI AS DESCRI230";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_30","ASOT6","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_30","ASOT6","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_30 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_49(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_49.SOTGRU AS SOTGRU249";
        m_cSelect = m_cSelect+" ,link_2_49.DESCRI AS DESCRI249";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_49","DASOT7","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_49","DASOT7","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_49 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_50(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_50.SOTGRU AS SOTGRU250";
        m_cSelect = m_cSelect+" ,link_2_50.DESCRI AS DESCRI250";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_50","ASOT7","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_50","ASOT7","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_50 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_51(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_51.SOTGRU AS SOTGRU251";
        m_cSelect = m_cSelect+" ,link_2_51.DESCRI AS DESCRI251";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_51","DASOT8","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_51","DASOT8","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_51 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_52(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_52.SOTGRU AS SOTGRU252";
        m_cSelect = m_cSelect+" ,link_2_52.DESCRI AS DESCRI252";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_52","ASOT8","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_52","ASOT8","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_52 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_53(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_53.SOTGRU AS SOTGRU253";
        m_cSelect = m_cSelect+" ,link_2_53.DESCRI AS DESCRI253";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_53","DASOT9","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_53","DASOT9","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_53 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_54(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_54.SOTGRU AS SOTGRU254";
        m_cSelect = m_cSelect+" ,link_2_54.DESCRI AS DESCRI254";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_54","ASOT9","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_54","ASOT9","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_54 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_55(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_55.SOTGRU AS SOTGRU255";
        m_cSelect = m_cSelect+" ,link_2_55.DESCRI AS DESCRI255";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_55","DASOT10","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_55","DASOT10","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_55 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_56(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_56.SOTGRU AS SOTGRU256";
        m_cSelect = m_cSelect+" ,link_2_56.DESCRI AS DESCRI256";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_56","ASOT10","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_56","ASOT10","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_56 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_57(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_57.SOTGRU AS SOTGRU257";
        m_cSelect = m_cSelect+" ,link_2_57.DESCRI AS DESCRI257";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_57","DASOT11","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_57","DASOT11","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_57 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_58(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_58.SOTGRU AS SOTGRU258";
        m_cSelect = m_cSelect+" ,link_2_58.DESCRI AS DESCRI258";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_58","ASOT11","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_58","ASOT11","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_58 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_59(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_59.SOTGRU AS SOTGRU259";
        m_cSelect = m_cSelect+" ,link_2_59.DESCRI AS DESCRI259";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_59","DASOT12","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_59","DASOT12","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_59 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_2_60(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_2_60.SOTGRU AS SOTGRU260";
        m_cSelect = m_cSelect+" ,link_2_60.DESCRI AS DESCRI260";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_2_60","ASOT12","SOTGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_2_60","ASOT12","SOTGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_2_60 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_24(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_24.RAMGRU AS RAMGRU124";
        m_cSelect = m_cSelect+" ,link_1_24.DESCRI AS DESCRI124";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_24","DAGRU1","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_24","DAGRU1","RAMGRU",true);
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
    public void AddJoinedLink_1_25(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_25.RAMGRU AS RAMGRU125";
        m_cSelect = m_cSelect+" ,link_1_25.DESCRI AS DESCRI125";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_25","AGRU1","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_25","AGRU1","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_25 = true;
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
        m_cSelect = m_cSelect+" ,link_1_27.RAMGRU AS RAMGRU127";
        m_cSelect = m_cSelect+" ,link_1_27.DESCRI AS DESCRI127";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_27","DAGRU2","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_27","DAGRU2","RAMGRU",true);
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
    public void AddJoinedLink_1_29(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_29.RAMGRU AS RAMGRU129";
        m_cSelect = m_cSelect+" ,link_1_29.DESCRI AS DESCRI129";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_29","AGRU2","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_29","AGRU2","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_29 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_30(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_30.RAMGRU AS RAMGRU130";
        m_cSelect = m_cSelect+" ,link_1_30.DESCRI AS DESCRI130";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_30","DAGRU3","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_30","DAGRU3","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_30 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_32(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_32.RAMGRU AS RAMGRU132";
        m_cSelect = m_cSelect+" ,link_1_32.DESCRI AS DESCRI132";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_32","AGRU3","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_32","AGRU3","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_32 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_33(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_33.RAMGRU AS RAMGRU133";
        m_cSelect = m_cSelect+" ,link_1_33.DESCRI AS DESCRI133";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_33","DAGRU4","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_33","DAGRU4","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_33 = true;
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
        m_cSelect = m_cSelect+" ,link_1_35.RAMGRU AS RAMGRU135";
        m_cSelect = m_cSelect+" ,link_1_35.DESCRI AS DESCRI135";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_35","AGRU4","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_35","AGRU4","RAMGRU",true);
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
    public void AddJoinedLink_1_36(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_36.RAMGRU AS RAMGRU136";
        m_cSelect = m_cSelect+" ,link_1_36.DESCRI AS DESCRI136";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_36","DAGRU5","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_36","DAGRU5","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_36 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_38(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_38.RAMGRU AS RAMGRU138";
        m_cSelect = m_cSelect+" ,link_1_38.DESCRI AS DESCRI138";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_38","AGRU5","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_38","AGRU5","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_38 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_49(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_49.RAMGRU AS RAMGRU149";
        m_cSelect = m_cSelect+" ,link_1_49.DESCRI AS DESCRI149";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_49","DAGRU6","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_49","DAGRU6","RAMGRU",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_49 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public void AddJoinedLink_1_51(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_51.RAMGRU AS RAMGRU151";
        m_cSelect = m_cSelect+" ,link_1_51.DESCRI AS DESCRI151";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_51","AGRU6","RAMGRU");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_51","AGRU6","RAMGRU",true);
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
  public armt_settoreuicBO (CPContext p_ContextObject) {
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
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"armt_settoreuic");
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
      l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
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
        if (CPLib.gt(m_MNTs.length,0)) {
          if (m_bLoaded) {
            NotifyEvent("Update children start");
          } else {
            NotifyEvent("Insert children start");
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (CPLib.gt(m_MNTs.length,0)) {
          if (m_bLoaded) {
            NotifyEvent("Update children end");
          } else {
            NotifyEvent("Insert children end");
          }
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
  public static String[] m_cLoadParameterNames = {"SETSINT","IDSETSIN"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(String p_SETSINT,double p_IDSETSIN) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_tbsetsin,m_cPhName_tbsetsin,m_cVirtName_tbsetsin,m_cVirtName_tbsetsin+".SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_SETSINT,"C",3,0),m_cServer_tbsetsin,p_SETSINT)+" AND "+m_cVirtName_tbsetsin+".IDSETSIN="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_IDSETSIN,"N",5,0),m_cServer_tbsetsin,p_IDSETSIN),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_2_2(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_4(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_21(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_22(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_23(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_24(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_25(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_26(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_27(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_28(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_29(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_30(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_49(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_50(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_51(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_52(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_53(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_54(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_55(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_56(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_57(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_58(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_59(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_2_60(m_cPhName_tbstgru,m_cServer_tbstgru);
    l_oSqlLoader.AddJoinedLink_1_24(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_25(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_27(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_29(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_30(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_32(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_33(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_35(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_36(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_38(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_49(m_cPhName_tbramgru,m_cServer_tbramgru);
    l_oSqlLoader.AddJoinedLink_1_51(m_cPhName_tbramgru,m_cServer_tbramgru);
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
        w_descg1 = "";
        w_descg2 = "";
        w_descg3 = "";
        w_descg4 = "";
        w_descg5 = "";
        w_descg6 = "";
        w_descg7 = "";
        w_descg8 = "";
        w_descg9 = "";
        w_descg10 = "";
        w_descg11 = "";
        w_descg12 = "";
        w_descsg1 = "";
        w_descsg2 = "";
        w_descsg3 = "";
        w_descsg4 = "";
        w_descsg5 = "";
        w_descsg6 = "";
        w_descsg7 = "";
        w_descsg8 = "";
        w_descsg9 = "";
        w_descsg10 = "";
        w_descsg11 = "";
        w_descsg12 = "";
        w_descsg13 = "";
        w_descsg14 = "";
        w_descsg15 = "";
        w_descsg16 = "";
        w_descsg17 = "";
        w_descsg18 = "";
        w_descsg19 = "";
        w_descsg20 = "";
        w_descsg21 = "";
        w_descsg22 = "";
        w_descsg23 = "";
        w_descsg24 = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_SETSINT = l_rsLoad.GetString("SETSINT");
        w_DESCRI = l_rsLoad.GetString("DESCRI");
        w_DATAINI = l_rsLoad.GetDate("DATAINI");
        w_DATAFINE = l_rsLoad.GetDate("DATAFINE");
        w_IDSETSIN = l_rsLoad.GetDouble("IDSETSIN");
        w_DAGRU1 = l_rsLoad.GetString("DAGRU1");
        if (l_oSqlLoader.m_bLink_1_24) {
          w_descg1 = l_rsLoad.GetString("DESCRI124");
        } else {
          Link_BMLJXZOHDR("Load");
        }
        w_AGRU1 = l_rsLoad.GetString("AGRU1");
        if (l_oSqlLoader.m_bLink_1_25) {
          w_descg2 = l_rsLoad.GetString("DESCRI125");
        } else {
          Link_PIMPFADLTV("Load");
        }
        w_DAGRU2 = l_rsLoad.GetString("DAGRU2");
        if (l_oSqlLoader.m_bLink_1_27) {
          w_descg3 = l_rsLoad.GetString("DESCRI127");
        } else {
          Link_NFMNJIJKQG("Load");
        }
        w_AGRU2 = l_rsLoad.GetString("AGRU2");
        if (l_oSqlLoader.m_bLink_1_29) {
          w_descg4 = l_rsLoad.GetString("DESCRI129");
        } else {
          Link_EGVTWLPYYK("Load");
        }
        w_DAGRU3 = l_rsLoad.GetString("DAGRU3");
        if (l_oSqlLoader.m_bLink_1_30) {
          w_descg5 = l_rsLoad.GetString("DESCRI130");
        } else {
          Link_PBXUYJXCDV("Load");
        }
        w_AGRU3 = l_rsLoad.GetString("AGRU3");
        if (l_oSqlLoader.m_bLink_1_32) {
          w_descg6 = l_rsLoad.GetString("DESCRI132");
        } else {
          Link_LKRRMRMXCU("Load");
        }
        w_DAGRU4 = l_rsLoad.GetString("DAGRU4");
        if (l_oSqlLoader.m_bLink_1_33) {
          w_descg7 = l_rsLoad.GetString("DESCRI133");
        } else {
          Link_NQYJKRPMAY("Load");
        }
        w_AGRU4 = l_rsLoad.GetString("AGRU4");
        if (l_oSqlLoader.m_bLink_1_35) {
          w_descg8 = l_rsLoad.GetString("DESCRI135");
        } else {
          Link_XLQJSGTFOG("Load");
        }
        w_DAGRU5 = l_rsLoad.GetString("DAGRU5");
        if (l_oSqlLoader.m_bLink_1_36) {
          w_descg9 = l_rsLoad.GetString("DESCRI136");
        } else {
          Link_VVLLCWNYJU("Load");
        }
        w_AGRU5 = l_rsLoad.GetString("AGRU5");
        if (l_oSqlLoader.m_bLink_1_38) {
          w_descg10 = l_rsLoad.GetString("DESCRI138");
        } else {
          Link_GPJQCCUFYH("Load");
        }
        w_DAGRU6 = l_rsLoad.GetString("DAGRU6");
        if (l_oSqlLoader.m_bLink_1_49) {
          w_descg11 = l_rsLoad.GetString("DESCRI149");
        } else {
          Link_OWCFHGKVPB("Load");
        }
        w_AGRU6 = l_rsLoad.GetString("AGRU6");
        if (l_oSqlLoader.m_bLink_1_51) {
          w_descg12 = l_rsLoad.GetString("DESCRI151");
        } else {
          Link_ZDTAXGFPRF("Load");
        }
        w_DASOT1 = l_rsLoad.GetString("DASOT1");
        if (l_oSqlLoader.m_bLink_2_2) {
          w_descsg1 = l_rsLoad.GetString("DESCRI202");
        } else {
          Link_QSAEKELBZF("Load");
        }
        w_ASOT1 = l_rsLoad.GetString("ASOT1");
        if (l_oSqlLoader.m_bLink_2_4) {
          w_descsg2 = l_rsLoad.GetString("DESCRI204");
        } else {
          Link_TXKEYYFXPE("Load");
        }
        w_DASOT2 = l_rsLoad.GetString("DASOT2");
        if (l_oSqlLoader.m_bLink_2_21) {
          w_descsg3 = l_rsLoad.GetString("DESCRI221");
        } else {
          Link_XJEPLEAUZI("Load");
        }
        w_ASOT2 = l_rsLoad.GetString("ASOT2");
        if (l_oSqlLoader.m_bLink_2_22) {
          w_descsg4 = l_rsLoad.GetString("DESCRI222");
        } else {
          Link_DSBUADQBZO("Load");
        }
        w_DASOT3 = l_rsLoad.GetString("DASOT3");
        if (l_oSqlLoader.m_bLink_2_23) {
          w_descsg5 = l_rsLoad.GetString("DESCRI223");
        } else {
          Link_YMUIBONOPY("Load");
        }
        w_ASOT3 = l_rsLoad.GetString("ASOT3");
        if (l_oSqlLoader.m_bLink_2_24) {
          w_descsg6 = l_rsLoad.GetString("DESCRI224");
        } else {
          Link_YFLBURGYJF("Load");
        }
        w_DASOT4 = l_rsLoad.GetString("DASOT4");
        if (l_oSqlLoader.m_bLink_2_25) {
          w_descsg7 = l_rsLoad.GetString("DESCRI225");
        } else {
          Link_CZWHSOLRJS("Load");
        }
        w_ASOT4 = l_rsLoad.GetString("ASOT4");
        if (l_oSqlLoader.m_bLink_2_26) {
          w_descsg8 = l_rsLoad.GetString("DESCRI226");
        } else {
          Link_CQDPGDHEVA("Load");
        }
        w_DASOT5 = l_rsLoad.GetString("DASOT5");
        if (l_oSqlLoader.m_bLink_2_27) {
          w_descsg9 = l_rsLoad.GetString("DESCRI227");
        } else {
          Link_EVMGYBVTME("Load");
        }
        w_ASOT5 = l_rsLoad.GetString("ASOT5");
        if (l_oSqlLoader.m_bLink_2_28) {
          w_descsg10 = l_rsLoad.GetString("DESCRI228");
        } else {
          Link_YCLLVDJDPC("Load");
        }
        w_DASOT6 = l_rsLoad.GetString("DASOT6");
        if (l_oSqlLoader.m_bLink_2_29) {
          w_descsg11 = l_rsLoad.GetString("DESCRI229");
        } else {
          Link_MWJSVBWARF("Load");
        }
        w_ASOT6 = l_rsLoad.GetString("ASOT6");
        if (l_oSqlLoader.m_bLink_2_30) {
          w_descsg12 = l_rsLoad.GetString("DESCRI230");
        } else {
          Link_AKTWQWJXMU("Load");
        }
        w_DASOT7 = l_rsLoad.GetString("DASOT7");
        if (l_oSqlLoader.m_bLink_2_49) {
          w_descsg13 = l_rsLoad.GetString("DESCRI249");
        } else {
          Link_HGBIEMZYHZ("Load");
        }
        w_ASOT7 = l_rsLoad.GetString("ASOT7");
        if (l_oSqlLoader.m_bLink_2_50) {
          w_descsg14 = l_rsLoad.GetString("DESCRI250");
        } else {
          Link_JIXSOXOUMP("Load");
        }
        w_DASOT8 = l_rsLoad.GetString("DASOT8");
        if (l_oSqlLoader.m_bLink_2_51) {
          w_descsg15 = l_rsLoad.GetString("DESCRI251");
        } else {
          Link_NHXQYOJWPY("Load");
        }
        w_ASOT8 = l_rsLoad.GetString("ASOT8");
        if (l_oSqlLoader.m_bLink_2_52) {
          w_descsg16 = l_rsLoad.GetString("DESCRI252");
        } else {
          Link_FQHPMPIEFY("Load");
        }
        w_DASOT9 = l_rsLoad.GetString("DASOT9");
        if (l_oSqlLoader.m_bLink_2_53) {
          w_descsg17 = l_rsLoad.GetString("DESCRI253");
        } else {
          Link_KGVPSOERYT("Load");
        }
        w_ASOT9 = l_rsLoad.GetString("ASOT9");
        if (l_oSqlLoader.m_bLink_2_54) {
          w_descsg18 = l_rsLoad.GetString("DESCRI254");
        } else {
          Link_GWWXIEOXZQ("Load");
        }
        w_DASOT10 = l_rsLoad.GetString("DASOT10");
        if (l_oSqlLoader.m_bLink_2_55) {
          w_descsg19 = l_rsLoad.GetString("DESCRI255");
        } else {
          Link_TWZIVFFWLR("Load");
        }
        w_ASOT10 = l_rsLoad.GetString("ASOT10");
        if (l_oSqlLoader.m_bLink_2_56) {
          w_descsg20 = l_rsLoad.GetString("DESCRI256");
        } else {
          Link_ESIHSDXQVO("Load");
        }
        w_DASOT11 = l_rsLoad.GetString("DASOT11");
        if (l_oSqlLoader.m_bLink_2_57) {
          w_descsg21 = l_rsLoad.GetString("DESCRI257");
        } else {
          Link_LXNKGCWVDI("Load");
        }
        w_ASOT11 = l_rsLoad.GetString("ASOT11");
        if (l_oSqlLoader.m_bLink_2_58) {
          w_descsg22 = l_rsLoad.GetString("DESCRI258");
        } else {
          Link_QYOHOTJSEN("Load");
        }
        w_DASOT12 = l_rsLoad.GetString("DASOT12");
        if (l_oSqlLoader.m_bLink_2_59) {
          w_descsg23 = l_rsLoad.GetString("DESCRI259");
        } else {
          Link_AWBDLKZHRC("Load");
        }
        w_ASOT12 = l_rsLoad.GetString("ASOT12");
        if (l_oSqlLoader.m_bLink_2_60) {
          w_descsg24 = l_rsLoad.GetString("DESCRI260");
        } else {
          Link_AZBXLFMDVT("Load");
        }
        w_DAATE2 = l_rsLoad.GetString("DAATE2");
        w_AATE2 = l_rsLoad.GetString("AATE2");
        w_DAATE3 = l_rsLoad.GetString("DAATE3");
        w_AATE3 = l_rsLoad.GetString("AATE3");
        w_DAATE4 = l_rsLoad.GetString("DAATE4");
        w_AATE4 = l_rsLoad.GetString("AATE4");
        w_DAATE5 = l_rsLoad.GetString("DAATE5");
        w_AATE5 = l_rsLoad.GetString("AATE5");
        w_DAATE6 = l_rsLoad.GetString("DAATE6");
        w_AATE6 = l_rsLoad.GetString("AATE6");
        w_DAATE1 = l_rsLoad.GetString("DAATE1");
        w_AATE1 = l_rsLoad.GetString("AATE1");
        // Assegna i valori degli op_
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"tbsetsin")) {
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
    return Load(w_SETSINT,w_IDSETSIN);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- Fine Area Manuale
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_tbsetsin);
      l_cSql = "insert into "+m_oWrInfo_tbsetsin.GetTableWriteName()+" (";
      l_cSql = l_cSql+"SETSINT,";
      l_cSql = l_cSql+"DESCRI,";
      l_cSql = l_cSql+"DATAINI,";
      l_cSql = l_cSql+"DATAFINE,";
      l_cSql = l_cSql+"IDSETSIN,";
      l_cSql = l_cSql+"DAGRU1,";
      l_cSql = l_cSql+"AGRU1,";
      l_cSql = l_cSql+"DAGRU2,";
      l_cSql = l_cSql+"AGRU2,";
      l_cSql = l_cSql+"DAGRU3,";
      l_cSql = l_cSql+"AGRU3,";
      l_cSql = l_cSql+"DAGRU4,";
      l_cSql = l_cSql+"AGRU4,";
      l_cSql = l_cSql+"DAGRU5,";
      l_cSql = l_cSql+"AGRU5,";
      l_cSql = l_cSql+"DAGRU6,";
      l_cSql = l_cSql+"AGRU6,";
      l_cSql = l_cSql+"DASOT1,";
      l_cSql = l_cSql+"ASOT1,";
      l_cSql = l_cSql+"DASOT2,";
      l_cSql = l_cSql+"ASOT2,";
      l_cSql = l_cSql+"DASOT3,";
      l_cSql = l_cSql+"ASOT3,";
      l_cSql = l_cSql+"DASOT4,";
      l_cSql = l_cSql+"ASOT4,";
      l_cSql = l_cSql+"DASOT5,";
      l_cSql = l_cSql+"ASOT5,";
      l_cSql = l_cSql+"DASOT6,";
      l_cSql = l_cSql+"ASOT6,";
      l_cSql = l_cSql+"DASOT7,";
      l_cSql = l_cSql+"ASOT7,";
      l_cSql = l_cSql+"DASOT8,";
      l_cSql = l_cSql+"ASOT8,";
      l_cSql = l_cSql+"DASOT9,";
      l_cSql = l_cSql+"ASOT9,";
      l_cSql = l_cSql+"DASOT10,";
      l_cSql = l_cSql+"ASOT10,";
      l_cSql = l_cSql+"DASOT11,";
      l_cSql = l_cSql+"ASOT11,";
      l_cSql = l_cSql+"DASOT12,";
      l_cSql = l_cSql+"ASOT12,";
      l_cSql = l_cSql+"DAATE2,";
      l_cSql = l_cSql+"AATE2,";
      l_cSql = l_cSql+"DAATE3,";
      l_cSql = l_cSql+"AATE3,";
      l_cSql = l_cSql+"DAATE4,";
      l_cSql = l_cSql+"AATE4,";
      l_cSql = l_cSql+"DAATE5,";
      l_cSql = l_cSql+"AATE5,";
      l_cSql = l_cSql+"DAATE6,";
      l_cSql = l_cSql+"AATE6,";
      l_cSql = l_cSql+"DAATE1,";
      l_cSql = l_cSql+"AATE1,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_tbsetsin.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbsetsin")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_SETSINT,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DESCRI,"C",200,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAINI,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DATAFINE,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_IDSETSIN,"N",5,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DAGRU1,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AGRU1,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DAGRU2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AGRU2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DAGRU3,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AGRU3,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DAGRU4,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AGRU4,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DAGRU5,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AGRU5,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DAGRU6,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_AGRU6,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT1,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT1,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT3,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT3,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT4,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT4,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT5,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT5,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT6,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT6,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT7,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT7,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT8,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT8,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT9,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT9,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT10,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT10,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT11,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT11,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_DASOT12,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_ASOT12,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAATE2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AATE2,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAATE3,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AATE3,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAATE4,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AATE4,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAATE5,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AATE5,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAATE6,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AATE6,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_DAATE1,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_AATE1,"C",3,0)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_tbsetsin.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbsetsin")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_tbsetsin,l_cSql,m_oParameters);
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
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_tbsetsin);
      l_cSql = "Update "+m_oWrInfo_tbsetsin.GetTableWriteName()+" set";
      l_cSql = l_cSql+" DESCRI = "+CPLib.ToSQL(w_DESCRI,"C",200,0);
      l_cSql = l_cSql+", DATAINI = "+CPLib.ToSQL(w_DATAINI,"D",8,0);
      l_cSql = l_cSql+", DATAFINE = "+CPLib.ToSQL(w_DATAFINE,"D",8,0);
      l_cSql = l_cSql+", DAGRU1 = "+CPLib.ToSQLNull(w_DAGRU1,"C",3,0);
      l_cSql = l_cSql+", AGRU1 = "+CPLib.ToSQLNull(w_AGRU1,"C",3,0);
      l_cSql = l_cSql+", DAGRU2 = "+CPLib.ToSQLNull(w_DAGRU2,"C",3,0);
      l_cSql = l_cSql+", AGRU2 = "+CPLib.ToSQLNull(w_AGRU2,"C",3,0);
      l_cSql = l_cSql+", DAGRU3 = "+CPLib.ToSQLNull(w_DAGRU3,"C",3,0);
      l_cSql = l_cSql+", AGRU3 = "+CPLib.ToSQLNull(w_AGRU3,"C",3,0);
      l_cSql = l_cSql+", DAGRU4 = "+CPLib.ToSQLNull(w_DAGRU4,"C",3,0);
      l_cSql = l_cSql+", AGRU4 = "+CPLib.ToSQLNull(w_AGRU4,"C",3,0);
      l_cSql = l_cSql+", DAGRU5 = "+CPLib.ToSQLNull(w_DAGRU5,"C",3,0);
      l_cSql = l_cSql+", AGRU5 = "+CPLib.ToSQLNull(w_AGRU5,"C",3,0);
      l_cSql = l_cSql+", DAGRU6 = "+CPLib.ToSQLNull(w_DAGRU6,"C",3,0);
      l_cSql = l_cSql+", AGRU6 = "+CPLib.ToSQLNull(w_AGRU6,"C",3,0);
      l_cSql = l_cSql+", DASOT1 = "+CPLib.ToSQLNull(w_DASOT1,"C",3,0);
      l_cSql = l_cSql+", ASOT1 = "+CPLib.ToSQLNull(w_ASOT1,"C",3,0);
      l_cSql = l_cSql+", DASOT2 = "+CPLib.ToSQLNull(w_DASOT2,"C",3,0);
      l_cSql = l_cSql+", ASOT2 = "+CPLib.ToSQLNull(w_ASOT2,"C",3,0);
      l_cSql = l_cSql+", DASOT3 = "+CPLib.ToSQLNull(w_DASOT3,"C",3,0);
      l_cSql = l_cSql+", ASOT3 = "+CPLib.ToSQLNull(w_ASOT3,"C",3,0);
      l_cSql = l_cSql+", DASOT4 = "+CPLib.ToSQLNull(w_DASOT4,"C",3,0);
      l_cSql = l_cSql+", ASOT4 = "+CPLib.ToSQLNull(w_ASOT4,"C",3,0);
      l_cSql = l_cSql+", DASOT5 = "+CPLib.ToSQLNull(w_DASOT5,"C",3,0);
      l_cSql = l_cSql+", ASOT5 = "+CPLib.ToSQLNull(w_ASOT5,"C",3,0);
      l_cSql = l_cSql+", DASOT6 = "+CPLib.ToSQLNull(w_DASOT6,"C",3,0);
      l_cSql = l_cSql+", ASOT6 = "+CPLib.ToSQLNull(w_ASOT6,"C",3,0);
      l_cSql = l_cSql+", DASOT7 = "+CPLib.ToSQLNull(w_DASOT7,"C",3,0);
      l_cSql = l_cSql+", ASOT7 = "+CPLib.ToSQLNull(w_ASOT7,"C",3,0);
      l_cSql = l_cSql+", DASOT8 = "+CPLib.ToSQLNull(w_DASOT8,"C",3,0);
      l_cSql = l_cSql+", ASOT8 = "+CPLib.ToSQLNull(w_ASOT8,"C",3,0);
      l_cSql = l_cSql+", DASOT9 = "+CPLib.ToSQLNull(w_DASOT9,"C",3,0);
      l_cSql = l_cSql+", ASOT9 = "+CPLib.ToSQLNull(w_ASOT9,"C",3,0);
      l_cSql = l_cSql+", DASOT10 = "+CPLib.ToSQLNull(w_DASOT10,"C",3,0);
      l_cSql = l_cSql+", ASOT10 = "+CPLib.ToSQLNull(w_ASOT10,"C",3,0);
      l_cSql = l_cSql+", DASOT11 = "+CPLib.ToSQLNull(w_DASOT11,"C",3,0);
      l_cSql = l_cSql+", ASOT11 = "+CPLib.ToSQLNull(w_ASOT11,"C",3,0);
      l_cSql = l_cSql+", DASOT12 = "+CPLib.ToSQLNull(w_DASOT12,"C",3,0);
      l_cSql = l_cSql+", ASOT12 = "+CPLib.ToSQLNull(w_ASOT12,"C",3,0);
      l_cSql = l_cSql+", DAATE2 = "+CPLib.ToSQL(w_DAATE2,"C",3,0);
      l_cSql = l_cSql+", AATE2 = "+CPLib.ToSQL(w_AATE2,"C",3,0);
      l_cSql = l_cSql+", DAATE3 = "+CPLib.ToSQL(w_DAATE3,"C",3,0);
      l_cSql = l_cSql+", AATE3 = "+CPLib.ToSQL(w_AATE3,"C",3,0);
      l_cSql = l_cSql+", DAATE4 = "+CPLib.ToSQL(w_DAATE4,"C",3,0);
      l_cSql = l_cSql+", AATE4 = "+CPLib.ToSQL(w_AATE4,"C",3,0);
      l_cSql = l_cSql+", DAATE5 = "+CPLib.ToSQL(w_DAATE5,"C",3,0);
      l_cSql = l_cSql+", AATE5 = "+CPLib.ToSQL(w_AATE5,"C",3,0);
      l_cSql = l_cSql+", DAATE6 = "+CPLib.ToSQL(w_DAATE6,"C",3,0);
      l_cSql = l_cSql+", AATE6 = "+CPLib.ToSQL(w_AATE6,"C",3,0);
      l_cSql = l_cSql+", DAATE1 = "+CPLib.ToSQL(w_DAATE1,"C",3,0);
      l_cSql = l_cSql+", AATE1 = "+CPLib.ToSQL(w_AATE1,"C",3,0);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbsetsin")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETSINT,"C",3,0),m_cServer_tbsetsin,w_SETSINT)+" AND "+"IDSETSIN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDSETSIN,"N",5,0),m_cServer_tbsetsin,w_IDSETSIN);
      l_cSql = l_cSql+m_oWrInfo_tbsetsin.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"tbsetsin")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_tbsetsin,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(String p_SETSINT,double p_IDSETSIN) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_SETSINT,p_IDSETSIN);
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
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_tbsetsin.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"SETSINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_SETSINT,"C",3,0),m_cServer_tbsetsin,w_SETSINT)+" AND "+"IDSETSIN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDSETSIN,"N",5,0),m_cServer_tbsetsin,w_IDSETSIN);
          l_cSql = l_cSql+m_oWrInfo_tbsetsin.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"tbsetsin")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_tbsetsin,l_cSql);
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
    return Delete(w_SETSINT,w_IDSETSIN);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"BMLJXZOHDR")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("BMLJXZOHDR",CPLib.GetLinkedFieldProps("RAMGRU","DAGRU1","C",3,0));
    } else if (CPLib.eq(p_cID,"PIMPFADLTV")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("PIMPFADLTV",CPLib.GetLinkedFieldProps("RAMGRU","AGRU1","C",3,0));
    } else if (CPLib.eq(p_cID,"NFMNJIJKQG")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NFMNJIJKQG",CPLib.GetLinkedFieldProps("RAMGRU","DAGRU2","C",3,0));
    } else if (CPLib.eq(p_cID,"EGVTWLPYYK")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("EGVTWLPYYK",CPLib.GetLinkedFieldProps("RAMGRU","AGRU2","C",3,0));
    } else if (CPLib.eq(p_cID,"PBXUYJXCDV")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("PBXUYJXCDV",CPLib.GetLinkedFieldProps("RAMGRU","DAGRU3","C",3,0));
    } else if (CPLib.eq(p_cID,"LKRRMRMXCU")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LKRRMRMXCU",CPLib.GetLinkedFieldProps("RAMGRU","AGRU3","C",3,0));
    } else if (CPLib.eq(p_cID,"NQYJKRPMAY")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NQYJKRPMAY",CPLib.GetLinkedFieldProps("RAMGRU","DAGRU4","C",3,0));
    } else if (CPLib.eq(p_cID,"XLQJSGTFOG")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XLQJSGTFOG",CPLib.GetLinkedFieldProps("RAMGRU","AGRU4","C",3,0));
    } else if (CPLib.eq(p_cID,"VVLLCWNYJU")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("VVLLCWNYJU",CPLib.GetLinkedFieldProps("RAMGRU","DAGRU5","C",3,0));
    } else if (CPLib.eq(p_cID,"GPJQCCUFYH")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GPJQCCUFYH",CPLib.GetLinkedFieldProps("RAMGRU","AGRU5","C",3,0));
    } else if (CPLib.eq(p_cID,"OWCFHGKVPB")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("OWCFHGKVPB",CPLib.GetLinkedFieldProps("RAMGRU","DAGRU6","C",3,0));
    } else if (CPLib.eq(p_cID,"ZDTAXGFPRF")) {
      result.m_TableName = "tbramgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"RAMGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ZDTAXGFPRF",CPLib.GetLinkedFieldProps("RAMGRU","AGRU6","C",3,0));
    } else if (CPLib.eq(p_cID,"QSAEKELBZF")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QSAEKELBZF",CPLib.GetLinkedFieldProps("SOTGRU","DASOT1","C",3,0));
    } else if (CPLib.eq(p_cID,"TXKEYYFXPE")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TXKEYYFXPE",CPLib.GetLinkedFieldProps("SOTGRU","ASOT1","C",3,0));
    } else if (CPLib.eq(p_cID,"XJEPLEAUZI")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XJEPLEAUZI",CPLib.GetLinkedFieldProps("SOTGRU","DASOT2","C",3,0));
    } else if (CPLib.eq(p_cID,"DSBUADQBZO")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("DSBUADQBZO",CPLib.GetLinkedFieldProps("SOTGRU","ASOT2","C",3,0));
    } else if (CPLib.eq(p_cID,"YMUIBONOPY")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YMUIBONOPY",CPLib.GetLinkedFieldProps("SOTGRU","DASOT3","C",3,0));
    } else if (CPLib.eq(p_cID,"YFLBURGYJF")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YFLBURGYJF",CPLib.GetLinkedFieldProps("SOTGRU","ASOT3","C",3,0));
    } else if (CPLib.eq(p_cID,"CZWHSOLRJS")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CZWHSOLRJS",CPLib.GetLinkedFieldProps("SOTGRU","DASOT4","C",3,0));
    } else if (CPLib.eq(p_cID,"CQDPGDHEVA")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CQDPGDHEVA",CPLib.GetLinkedFieldProps("SOTGRU","ASOT4","C",3,0));
    } else if (CPLib.eq(p_cID,"EVMGYBVTME")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("EVMGYBVTME",CPLib.GetLinkedFieldProps("SOTGRU","DASOT5","C",3,0));
    } else if (CPLib.eq(p_cID,"YCLLVDJDPC")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("YCLLVDJDPC",CPLib.GetLinkedFieldProps("SOTGRU","ASOT5","C",3,0));
    } else if (CPLib.eq(p_cID,"MWJSVBWARF")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("MWJSVBWARF",CPLib.GetLinkedFieldProps("SOTGRU","DASOT6","C",3,0));
    } else if (CPLib.eq(p_cID,"AKTWQWJXMU")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AKTWQWJXMU",CPLib.GetLinkedFieldProps("SOTGRU","ASOT6","C",3,0));
    } else if (CPLib.eq(p_cID,"HGBIEMZYHZ")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("HGBIEMZYHZ",CPLib.GetLinkedFieldProps("SOTGRU","DASOT7","C",3,0));
    } else if (CPLib.eq(p_cID,"JIXSOXOUMP")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("JIXSOXOUMP",CPLib.GetLinkedFieldProps("SOTGRU","ASOT7","C",3,0));
    } else if (CPLib.eq(p_cID,"NHXQYOJWPY")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("NHXQYOJWPY",CPLib.GetLinkedFieldProps("SOTGRU","DASOT8","C",3,0));
    } else if (CPLib.eq(p_cID,"FQHPMPIEFY")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("FQHPMPIEFY",CPLib.GetLinkedFieldProps("SOTGRU","ASOT8","C",3,0));
    } else if (CPLib.eq(p_cID,"KGVPSOERYT")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("KGVPSOERYT",CPLib.GetLinkedFieldProps("SOTGRU","DASOT9","C",3,0));
    } else if (CPLib.eq(p_cID,"GWWXIEOXZQ")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("GWWXIEOXZQ",CPLib.GetLinkedFieldProps("SOTGRU","ASOT9","C",3,0));
    } else if (CPLib.eq(p_cID,"TWZIVFFWLR")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("TWZIVFFWLR",CPLib.GetLinkedFieldProps("SOTGRU","DASOT10","C",3,0));
    } else if (CPLib.eq(p_cID,"ESIHSDXQVO")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("ESIHSDXQVO",CPLib.GetLinkedFieldProps("SOTGRU","ASOT10","C",3,0));
    } else if (CPLib.eq(p_cID,"LXNKGCWVDI")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("LXNKGCWVDI",CPLib.GetLinkedFieldProps("SOTGRU","DASOT11","C",3,0));
    } else if (CPLib.eq(p_cID,"QYOHOTJSEN")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("QYOHOTJSEN",CPLib.GetLinkedFieldProps("SOTGRU","ASOT11","C",3,0));
    } else if (CPLib.eq(p_cID,"AWBDLKZHRC")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AWBDLKZHRC",CPLib.GetLinkedFieldProps("SOTGRU","DASOT12","C",3,0));
    } else if (CPLib.eq(p_cID,"AZBXLFMDVT")) {
      result.m_TableName = "tbstgru";
      result.n_KMode = 2;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"SOTGRU" , "DESCRI"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("AZBXLFMDVT",CPLib.GetLinkedFieldProps("SOTGRU","ASOT12","C",3,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
