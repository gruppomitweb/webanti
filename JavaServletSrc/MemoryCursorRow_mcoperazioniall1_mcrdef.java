public class MemoryCursorRow_mcoperazioniall1_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcoperazioniall1_mcrdef() {
  }
  public MemoryCursorRow_mcoperazioniall1_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcoperazioniall1_mcrdef toBuild = new MemoryCursor_mcoperazioniall1_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcoperazioniall1_mcrdef toBuild = new MemoryCursor_mcoperazioniall1_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOINTER = "";
  String CODINTER = "";
  String IDEREG = "";
  String CODDIPE = "";
  String CABFIL = "";
  String CABCOMU = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String CODANA = "";
  String SEGNO = "";
  String VALUTA = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  String RAPPORTO = "";
  String CODTIPSOGG = "";
  String CONNESSOGG = "";
  String RAGSOGSOGG = "";
  String SESSOSOGG = "";
  String CODFISCSOGG = "";
  java.sql.Date DATANASCSOGG = CPLib.NullDate();
  String NASCOMUNSOGG = "";
  String COMUNRESSOGG = "";
  String CABRESISOGG = "";
  String PAESESOGG = "";
  String SAESOGG = "";
  String ATECOSOGG = "";
  String CONNESESE = "";
  String RAGSOGESE = "";
  String CODFISCESE = "";
  java.sql.Date DATANASCESE = CPLib.NullDate();
  String NASCCOMUNESE = "";
  String C_RAG = "";
  String C_STA = "";
  String C_CAB = "";
  String C_CTA = "";
  String CODINT2 = "";
  String DESCINTER = "";
  String PAESE = "";
  String CODCAB2 = "";
  String C_RAPPORTO = "";
  String FILLER = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABFIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABCOMU))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODANA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODTIPSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOGSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSOSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISCSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASCSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUNSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNRESSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABRESISOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESESOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(SAESOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATECOSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOGESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISCESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASCESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCCOMUNESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_RAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_STA))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_CTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINT2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB2))) {
      return false;
    }
    if ( ! (CPLib.Empty(C_RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FILLER))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcoperazioniall1_mcrdef p_row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
    CopyOperation<MemoryCursorRow_mcoperazioniall1_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.TIPOINTER = l_row.TIPOINTER;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODINTER = l_row.CODINTER;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.IDEREG = l_row.IDEREG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODDIPE = l_row.CODDIPE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CABFIL = l_row.CABFIL;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CABCOMU = l_row.CABCOMU;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.PROVINCIA = l_row.PROVINCIA;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.DATAOPE = l_row.DATAOPE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODANA = l_row.CODANA;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.SEGNO = l_row.SEGNO;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.VALUTA = l_row.VALUTA;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.TOTLIRE = l_row.TOTLIRE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.TOTCONT = l_row.TOTCONT;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODTIPSOGG = l_row.CODTIPSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CONNESSOGG = l_row.CONNESSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.RAGSOGSOGG = l_row.RAGSOGSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.SESSOSOGG = l_row.SESSOSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODFISCSOGG = l_row.CODFISCSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.DATANASCSOGG = l_row.DATANASCSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.NASCOMUNSOGG = l_row.NASCOMUNSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.COMUNRESSOGG = l_row.COMUNRESSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CABRESISOGG = l_row.CABRESISOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.PAESESOGG = l_row.PAESESOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.SAESOGG = l_row.SAESOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.ATECOSOGG = l_row.ATECOSOGG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CONNESESE = l_row.CONNESESE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.RAGSOGESE = l_row.RAGSOGESE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODFISCESE = l_row.CODFISCESE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.DATANASCESE = l_row.DATANASCESE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.NASCCOMUNESE = l_row.NASCCOMUNESE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.C_RAG = l_row.C_RAG;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.C_STA = l_row.C_STA;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.C_CAB = l_row.C_CAB;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.C_CTA = l_row.C_CTA;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODINT2 = l_row.CODINT2;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.DESCINTER = l_row.DESCINTER;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.CODCAB2 = l_row.CODCAB2;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.C_RAPPORTO = l_row.C_RAPPORTO;
      MemoryCursorRow_mcoperazioniall1_mcrdef.this.FILLER = l_row.FILLER;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcoperazioniall1_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcoperazioniall1_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcoperazioniall1_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcoperazioniall1_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcoperazioniall1_mcrdef p_From,MemoryCursorRow_mcoperazioniall1_mcrdef p_To) {
        p_To.TIPOINTER = copyAndCast(p_From.TIPOINTER);
        p_To.CODINTER = copyAndCast(p_From.CODINTER);
        p_To.IDEREG = copyAndCast(p_From.IDEREG);
        p_To.CODDIPE = copyAndCast(p_From.CODDIPE);
        p_To.CABFIL = copyAndCast(p_From.CABFIL);
        p_To.CABCOMU = copyAndCast(p_From.CABCOMU);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.PROVINCIA = copyAndCast(p_From.PROVINCIA);
        p_To.DATAOPE = copyAndCast(p_From.DATAOPE);
        p_To.CODANA = copyAndCast(p_From.CODANA);
        p_To.SEGNO = copyAndCast(p_From.SEGNO);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
        p_To.TOTLIRE = copyAndCast(p_From.TOTLIRE);
        p_To.TOTCONT = copyAndCast(p_From.TOTCONT);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.CODTIPSOGG = copyAndCast(p_From.CODTIPSOGG);
        p_To.CONNESSOGG = copyAndCast(p_From.CONNESSOGG);
        p_To.RAGSOGSOGG = copyAndCast(p_From.RAGSOGSOGG);
        p_To.SESSOSOGG = copyAndCast(p_From.SESSOSOGG);
        p_To.CODFISCSOGG = copyAndCast(p_From.CODFISCSOGG);
        p_To.DATANASCSOGG = copyAndCast(p_From.DATANASCSOGG);
        p_To.NASCOMUNSOGG = copyAndCast(p_From.NASCOMUNSOGG);
        p_To.COMUNRESSOGG = copyAndCast(p_From.COMUNRESSOGG);
        p_To.CABRESISOGG = copyAndCast(p_From.CABRESISOGG);
        p_To.PAESESOGG = copyAndCast(p_From.PAESESOGG);
        p_To.SAESOGG = copyAndCast(p_From.SAESOGG);
        p_To.ATECOSOGG = copyAndCast(p_From.ATECOSOGG);
        p_To.CONNESESE = copyAndCast(p_From.CONNESESE);
        p_To.RAGSOGESE = copyAndCast(p_From.RAGSOGESE);
        p_To.CODFISCESE = copyAndCast(p_From.CODFISCESE);
        p_To.DATANASCESE = copyAndCast(p_From.DATANASCESE);
        p_To.NASCCOMUNESE = copyAndCast(p_From.NASCCOMUNESE);
        p_To.C_RAG = copyAndCast(p_From.C_RAG);
        p_To.C_STA = copyAndCast(p_From.C_STA);
        p_To.C_CAB = copyAndCast(p_From.C_CAB);
        p_To.C_CTA = copyAndCast(p_From.C_CTA);
        p_To.CODINT2 = copyAndCast(p_From.CODINT2);
        p_To.DESCINTER = copyAndCast(p_From.DESCINTER);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.CODCAB2 = copyAndCast(p_From.CODCAB2);
        p_To.C_RAPPORTO = copyAndCast(p_From.C_RAPPORTO);
        p_To.FILLER = copyAndCast(p_From.FILLER);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOINTER","CODINTER","IDEREG","CODDIPE","CABFIL","CABCOMU","DESCCIT","PROVINCIA","DATAOPE","CODANA","SEGNO","VALUTA","TOTLIRE","TOTCONT","RAPPORTO","CODTIPSOGG","CONNESSOGG","RAGSOGSOGG","SESSOSOGG","CODFISCSOGG","DATANASCSOGG","NASCOMUNSOGG","COMUNRESSOGG","CABRESISOGG","PAESESOGG","SAESOGG","ATECOSOGG","CONNESESE","RAGSOGESE","CODFISCESE","DATANASCESE","NASCCOMUNESE","C_RAG","C_STA","C_CAB","C_CTA","CODINT2","DESCINTER","PAESE","CODCAB2","C_RAPPORTO","FILLER"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","D","C","C","C","N","N","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Inermediario","Codice inermediario","Identificativo operazione","Codice Filiale/Punto Operativo","CAB Filiale","CAB Comune","Comune Filiale","Provincia","Data Operazione","Causale Analitica","Segno","Valuta","Importo euro","Importo parte in contanti","Identificativo Rapporto","Codice Tipo Sogetto","NDG Soggetto","Cognome e Nome/Ragione Sociale","Sesso Soggetto","Codice Fiscale Soggetto","Data di Nascita Soggetto","Comune/Paese di nascita","Comune di residenza Soggetto","CAB residenza del Soggetto","Stato di residenza Soggetto","SAE del Soggetto","ATECO del Soggetto","NDG Esecutore","Cognome Nome/Ragione Sociale ","Codice Fiscale Esecutore","Data di Nascita Esecutore","Comune/Stato di Nascita Esecutore","Cognome Nome/Ragione Sociale","Stato Controparte","CAB Controparte","Comune Controparte","Codice Intermediario Controparte","Denominazione Intermediario Controparte","Paese Intermediario Controparte","CAB Intermediario Controparte","IBAN / Rapporto Controparte","Campo libero (69 Caratteri)"};
    return l_names;
  }
}
