public class MemoryCursorRow_mcarchope_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcarchope_mcrdef() {
  }
  public MemoryCursorRow_mcarchope_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcarchope_mcrdef toBuild = new MemoryCursor_mcarchope_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcarchope_mcrdef toBuild = new MemoryCursor_mcarchope_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  java.sql.Date DATAOPE = CPLib.NullDate();
  String FLAGCONT = "";
  String CODANA = "";
  String CODVOC = "";
  String TIPOINT2 = "";
  String CODINT2 = "";
  String PAESE = "";
  String DESC2 = "";
  String PROV2 = "";
  String CODCAB2 = "";
  String DESCINTER = "";
  String RAPPORTO = "";
  String FLAGRAP = "";
  String TIPOLEG = "";
  java.sql.Date DATAREG = CPLib.NullDate();
  String FLAGLIRE = "";
  String VALUTA = "";
  String SEGNO = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  String CONNESCLI = "";
  String CONNESOPER = "";
  double CAMBIO = 0;
  String NUMPROG = "";
  String TIPOOPRAP = "";
  String TIPOINTER = "";
  String CODINTER = "";
  String CODDIPE = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String CODCAB = "";
  String FLAGFRAZ = "";
  String CONNESBEN = "";
  String UNIQUECODE = "";
  String AGOPER = "";
  String RIFIMP = "";
  String ZCPARTE = "";
  String RAGIO = "";
  String MODSVOL = "";
  String AREAGEO = "";
  String INFORM = "";
  String AMMONT = "";
  String DURATA = "";
  String TIPO = "";
  double RRAGIO = 0;
  double RCOMP = 0;
  double RAREA = 0;
  double RIMP = 0;
  double RFREQ = 0;
  String CONNALTRO = "";
  java.sql.Date DATAIMP = CPLib.NullDate();
  double RTIPO = 0;
  String C_RAG = "";
  String C_STA = "";
  String C_CTA = "";
  String C_CAB = "";
  String C_PRV = "";
  String C_IND = "";
  String C_CAP = "";
  String NATURA = "";
  String SCOPO = "";
  String C_RAPPORTO = "";
  String RAPPORTOBEN = "";
  String PAGASOGOP = "";
  String IPCOLLEG = "";
  java.sql.Timestamp ORACOLLEG = CPLib.NullDateTime();
  double DUCOLLEG = 0;
  double IMPIN = 0;
  double IMPOUT = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODANA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODVOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESC2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROV2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOOPRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGFRAZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(AGOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ZCPARTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MODSVOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(AREAGEO))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    if ( ! (CPLib.Empty(AMMONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DURATA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RRAGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RCOMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAREA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RFREQ))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNALTRO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RTIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_RAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_STA))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_PRV))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_IND))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCOPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTOBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAGASOGOP))) {
      return false;
    }
    if ( ! (CPLib.Empty(IPCOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ORACOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DUCOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPOUT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcarchope_mcrdef p_row) {
    MemoryCursorRow_mcarchope_mcrdef l_row = new MemoryCursorRow_mcarchope_mcrdef();
    CopyOperation<MemoryCursorRow_mcarchope_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcarchope_mcrdef.this.DATAOPE = l_row.DATAOPE;
      MemoryCursorRow_mcarchope_mcrdef.this.FLAGCONT = l_row.FLAGCONT;
      MemoryCursorRow_mcarchope_mcrdef.this.CODANA = l_row.CODANA;
      MemoryCursorRow_mcarchope_mcrdef.this.CODVOC = l_row.CODVOC;
      MemoryCursorRow_mcarchope_mcrdef.this.TIPOINT2 = l_row.TIPOINT2;
      MemoryCursorRow_mcarchope_mcrdef.this.CODINT2 = l_row.CODINT2;
      MemoryCursorRow_mcarchope_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcarchope_mcrdef.this.DESC2 = l_row.DESC2;
      MemoryCursorRow_mcarchope_mcrdef.this.PROV2 = l_row.PROV2;
      MemoryCursorRow_mcarchope_mcrdef.this.CODCAB2 = l_row.CODCAB2;
      MemoryCursorRow_mcarchope_mcrdef.this.DESCINTER = l_row.DESCINTER;
      MemoryCursorRow_mcarchope_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcarchope_mcrdef.this.FLAGRAP = l_row.FLAGRAP;
      MemoryCursorRow_mcarchope_mcrdef.this.TIPOLEG = l_row.TIPOLEG;
      MemoryCursorRow_mcarchope_mcrdef.this.DATAREG = l_row.DATAREG;
      MemoryCursorRow_mcarchope_mcrdef.this.FLAGLIRE = l_row.FLAGLIRE;
      MemoryCursorRow_mcarchope_mcrdef.this.VALUTA = l_row.VALUTA;
      MemoryCursorRow_mcarchope_mcrdef.this.SEGNO = l_row.SEGNO;
      MemoryCursorRow_mcarchope_mcrdef.this.TOTLIRE = l_row.TOTLIRE;
      MemoryCursorRow_mcarchope_mcrdef.this.TOTCONT = l_row.TOTCONT;
      MemoryCursorRow_mcarchope_mcrdef.this.CONNESCLI = l_row.CONNESCLI;
      MemoryCursorRow_mcarchope_mcrdef.this.CONNESOPER = l_row.CONNESOPER;
      MemoryCursorRow_mcarchope_mcrdef.this.CAMBIO = l_row.CAMBIO;
      MemoryCursorRow_mcarchope_mcrdef.this.NUMPROG = l_row.NUMPROG;
      MemoryCursorRow_mcarchope_mcrdef.this.TIPOOPRAP = l_row.TIPOOPRAP;
      MemoryCursorRow_mcarchope_mcrdef.this.TIPOINTER = l_row.TIPOINTER;
      MemoryCursorRow_mcarchope_mcrdef.this.CODINTER = l_row.CODINTER;
      MemoryCursorRow_mcarchope_mcrdef.this.CODDIPE = l_row.CODDIPE;
      MemoryCursorRow_mcarchope_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcarchope_mcrdef.this.PROVINCIA = l_row.PROVINCIA;
      MemoryCursorRow_mcarchope_mcrdef.this.CODCAB = l_row.CODCAB;
      MemoryCursorRow_mcarchope_mcrdef.this.FLAGFRAZ = l_row.FLAGFRAZ;
      MemoryCursorRow_mcarchope_mcrdef.this.CONNESBEN = l_row.CONNESBEN;
      MemoryCursorRow_mcarchope_mcrdef.this.UNIQUECODE = l_row.UNIQUECODE;
      MemoryCursorRow_mcarchope_mcrdef.this.AGOPER = l_row.AGOPER;
      MemoryCursorRow_mcarchope_mcrdef.this.RIFIMP = l_row.RIFIMP;
      MemoryCursorRow_mcarchope_mcrdef.this.ZCPARTE = l_row.ZCPARTE;
      MemoryCursorRow_mcarchope_mcrdef.this.RAGIO = l_row.RAGIO;
      MemoryCursorRow_mcarchope_mcrdef.this.MODSVOL = l_row.MODSVOL;
      MemoryCursorRow_mcarchope_mcrdef.this.AREAGEO = l_row.AREAGEO;
      MemoryCursorRow_mcarchope_mcrdef.this.INFORM = l_row.INFORM;
      MemoryCursorRow_mcarchope_mcrdef.this.AMMONT = l_row.AMMONT;
      MemoryCursorRow_mcarchope_mcrdef.this.DURATA = l_row.DURATA;
      MemoryCursorRow_mcarchope_mcrdef.this.TIPO = l_row.TIPO;
      MemoryCursorRow_mcarchope_mcrdef.this.RRAGIO = l_row.RRAGIO;
      MemoryCursorRow_mcarchope_mcrdef.this.RCOMP = l_row.RCOMP;
      MemoryCursorRow_mcarchope_mcrdef.this.RAREA = l_row.RAREA;
      MemoryCursorRow_mcarchope_mcrdef.this.RIMP = l_row.RIMP;
      MemoryCursorRow_mcarchope_mcrdef.this.RFREQ = l_row.RFREQ;
      MemoryCursorRow_mcarchope_mcrdef.this.CONNALTRO = l_row.CONNALTRO;
      MemoryCursorRow_mcarchope_mcrdef.this.DATAIMP = l_row.DATAIMP;
      MemoryCursorRow_mcarchope_mcrdef.this.RTIPO = l_row.RTIPO;
      MemoryCursorRow_mcarchope_mcrdef.this.C_RAG = l_row.C_RAG;
      MemoryCursorRow_mcarchope_mcrdef.this.C_STA = l_row.C_STA;
      MemoryCursorRow_mcarchope_mcrdef.this.C_CTA = l_row.C_CTA;
      MemoryCursorRow_mcarchope_mcrdef.this.C_CAB = l_row.C_CAB;
      MemoryCursorRow_mcarchope_mcrdef.this.C_PRV = l_row.C_PRV;
      MemoryCursorRow_mcarchope_mcrdef.this.C_IND = l_row.C_IND;
      MemoryCursorRow_mcarchope_mcrdef.this.C_CAP = l_row.C_CAP;
      MemoryCursorRow_mcarchope_mcrdef.this.NATURA = l_row.NATURA;
      MemoryCursorRow_mcarchope_mcrdef.this.SCOPO = l_row.SCOPO;
      MemoryCursorRow_mcarchope_mcrdef.this.C_RAPPORTO = l_row.C_RAPPORTO;
      MemoryCursorRow_mcarchope_mcrdef.this.RAPPORTOBEN = l_row.RAPPORTOBEN;
      MemoryCursorRow_mcarchope_mcrdef.this.PAGASOGOP = l_row.PAGASOGOP;
      MemoryCursorRow_mcarchope_mcrdef.this.IPCOLLEG = l_row.IPCOLLEG;
      MemoryCursorRow_mcarchope_mcrdef.this.ORACOLLEG = l_row.ORACOLLEG;
      MemoryCursorRow_mcarchope_mcrdef.this.DUCOLLEG = l_row.DUCOLLEG;
      MemoryCursorRow_mcarchope_mcrdef.this.IMPIN = l_row.IMPIN;
      MemoryCursorRow_mcarchope_mcrdef.this.IMPOUT = l_row.IMPOUT;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcarchope_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcarchope_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcarchope_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcarchope_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcarchope_mcrdef p_From,MemoryCursorRow_mcarchope_mcrdef p_To) {
        p_To.DATAOPE = copyAndCast(p_From.DATAOPE);
        p_To.FLAGCONT = copyAndCast(p_From.FLAGCONT);
        p_To.CODANA = copyAndCast(p_From.CODANA);
        p_To.CODVOC = copyAndCast(p_From.CODVOC);
        p_To.TIPOINT2 = copyAndCast(p_From.TIPOINT2);
        p_To.CODINT2 = copyAndCast(p_From.CODINT2);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.DESC2 = copyAndCast(p_From.DESC2);
        p_To.PROV2 = copyAndCast(p_From.PROV2);
        p_To.CODCAB2 = copyAndCast(p_From.CODCAB2);
        p_To.DESCINTER = copyAndCast(p_From.DESCINTER);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.FLAGRAP = copyAndCast(p_From.FLAGRAP);
        p_To.TIPOLEG = copyAndCast(p_From.TIPOLEG);
        p_To.DATAREG = copyAndCast(p_From.DATAREG);
        p_To.FLAGLIRE = copyAndCast(p_From.FLAGLIRE);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
        p_To.SEGNO = copyAndCast(p_From.SEGNO);
        p_To.TOTLIRE = copyAndCast(p_From.TOTLIRE);
        p_To.TOTCONT = copyAndCast(p_From.TOTCONT);
        p_To.CONNESCLI = copyAndCast(p_From.CONNESCLI);
        p_To.CONNESOPER = copyAndCast(p_From.CONNESOPER);
        p_To.CAMBIO = copyAndCast(p_From.CAMBIO);
        p_To.NUMPROG = copyAndCast(p_From.NUMPROG);
        p_To.TIPOOPRAP = copyAndCast(p_From.TIPOOPRAP);
        p_To.TIPOINTER = copyAndCast(p_From.TIPOINTER);
        p_To.CODINTER = copyAndCast(p_From.CODINTER);
        p_To.CODDIPE = copyAndCast(p_From.CODDIPE);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.PROVINCIA = copyAndCast(p_From.PROVINCIA);
        p_To.CODCAB = copyAndCast(p_From.CODCAB);
        p_To.FLAGFRAZ = copyAndCast(p_From.FLAGFRAZ);
        p_To.CONNESBEN = copyAndCast(p_From.CONNESBEN);
        p_To.UNIQUECODE = copyAndCast(p_From.UNIQUECODE);
        p_To.AGOPER = copyAndCast(p_From.AGOPER);
        p_To.RIFIMP = copyAndCast(p_From.RIFIMP);
        p_To.ZCPARTE = copyAndCast(p_From.ZCPARTE);
        p_To.RAGIO = copyAndCast(p_From.RAGIO);
        p_To.MODSVOL = copyAndCast(p_From.MODSVOL);
        p_To.AREAGEO = copyAndCast(p_From.AREAGEO);
        p_To.INFORM = copyAndCast(p_From.INFORM);
        p_To.AMMONT = copyAndCast(p_From.AMMONT);
        p_To.DURATA = copyAndCast(p_From.DURATA);
        p_To.TIPO = copyAndCast(p_From.TIPO);
        p_To.RRAGIO = copyAndCast(p_From.RRAGIO);
        p_To.RCOMP = copyAndCast(p_From.RCOMP);
        p_To.RAREA = copyAndCast(p_From.RAREA);
        p_To.RIMP = copyAndCast(p_From.RIMP);
        p_To.RFREQ = copyAndCast(p_From.RFREQ);
        p_To.CONNALTRO = copyAndCast(p_From.CONNALTRO);
        p_To.DATAIMP = copyAndCast(p_From.DATAIMP);
        p_To.RTIPO = copyAndCast(p_From.RTIPO);
        p_To.C_RAG = copyAndCast(p_From.C_RAG);
        p_To.C_STA = copyAndCast(p_From.C_STA);
        p_To.C_CTA = copyAndCast(p_From.C_CTA);
        p_To.C_CAB = copyAndCast(p_From.C_CAB);
        p_To.C_PRV = copyAndCast(p_From.C_PRV);
        p_To.C_IND = copyAndCast(p_From.C_IND);
        p_To.C_CAP = copyAndCast(p_From.C_CAP);
        p_To.NATURA = copyAndCast(p_From.NATURA);
        p_To.SCOPO = copyAndCast(p_From.SCOPO);
        p_To.C_RAPPORTO = copyAndCast(p_From.C_RAPPORTO);
        p_To.RAPPORTOBEN = copyAndCast(p_From.RAPPORTOBEN);
        p_To.PAGASOGOP = copyAndCast(p_From.PAGASOGOP);
        p_To.IPCOLLEG = copyAndCast(p_From.IPCOLLEG);
        p_To.ORACOLLEG = copyAndCast(p_From.ORACOLLEG);
        p_To.DUCOLLEG = copyAndCast(p_From.DUCOLLEG);
        p_To.IMPIN = copyAndCast(p_From.IMPIN);
        p_To.IMPOUT = copyAndCast(p_From.IMPOUT);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"DATAOPE","FLAGCONT","CODANA","CODVOC","TIPOINT2","CODINT2","PAESE","DESC2","PROV2","CODCAB2","DESCINTER","RAPPORTO","FLAGRAP","TIPOLEG","DATAREG","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","CONNESCLI","CONNESOPER","CAMBIO","NUMPROG","TIPOOPRAP","TIPOINTER","CODINTER","CODDIPE","DESCCIT","PROVINCIA","CODCAB","FLAGFRAZ","CONNESBEN","UNIQUECODE","AGOPER","RIFIMP","ZCPARTE","RAGIO","MODSVOL","AREAGEO","INFORM","AMMONT","DURATA","TIPO","RRAGIO","RCOMP","RAREA","RIMP","RFREQ","CONNALTRO","DATAIMP","RTIPO","C_RAG","C_STA","C_CTA","C_CAB","C_PRV","C_IND","C_CAP","NATURA","SCOPO","C_RAPPORTO","RAPPORTOBEN","PAGASOGOP","IPCOLLEG","ORACOLLEG","DUCOLLEG","IMPIN","IMPOUT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"D","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","N","N","C","C","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","N","N","N","C","D","N","C","C","C","C","C","C","C","C","C","C","C","C","C","T","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Data Operazione","Flag Contanti","Causale Analitica","Causale Sintetica","Tipo Intermediario Controparte","Codice Intermediario Controparte","Paese Intermediario Controparte","Comune Intermediario Controparte","Provincia Intermediario Controparte","CAB Intermediario Controparte","Descrizione Intermediario Controparte","Codice Rapporto Continuativo","Tipo Rapporto Continuativo","Tipo Legame Soggetto Operante","Data Registrazione Operazione","Tipo Valuta","Codice Valuta","Segno Operazione","Importo Operazione","Totale Contanti","Codice Cliente Occasionale","Codice Soggetto Operante","Cambio se operazione in valuta","N. Progressivo Operazione","Tipo Registrazione","Tipo Intermediario","Codice Intermediario","Codice Dipendenza","Città Intermediario/Dipendenza","Provincia Intermediario/Dipendenza","CAB Intermediario/Dipendenza","Flag Operazione Frazionata/Multipla","Codice Beneficiario","Codice Univoco Operazione","Tipo Operazione Agenzia Entrate","RIferimento Import","Descrizione Completa Intermediario Controparte","Classe di rischio ragionevolezza","Classe di rischio Modalità di svolgimento","Classe di Rischio area geografica","Annotazioni Varie/Codice esterno operazione","Classe di rischio Ammontare Operazione","Classe di rischio Durata/Frequenza Operazione","Classe di ricchio Tipo Operazione","Valore Rischio Ragionevolezza","Valore Rischio Comportamento","Valore Rischio Area Geografica","Valore Rischio Importo","Valore Rischio Durata/Frequenza","Soggetto per il quale è svolta l'operazione","Data Importazione","Valore Rischio Tipo Operazione","Nominativo Controparte","Stato Controparte","Città Residenza Controparte","CAB Città Residenza Controparte","Provincia Città Residenza Controparte","Indirizzo Città Residenza Controparte","CAP Città Residenza Controparte","Natura Operazione","Scopo Operazione","Conto Intermediario Controparte","Codice rapporto conroparte","Soggetto Operante paga con mezzi propri","IP Collegamento","Data e Ora Collegamento","Minuti di collegamento","Importo IN Cambiavalute","Importo OUT Cambiavalute"};
    return l_names;
  }
}
