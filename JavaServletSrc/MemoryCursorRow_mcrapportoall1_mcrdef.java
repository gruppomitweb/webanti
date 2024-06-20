public class MemoryCursorRow_mcrapportoall1_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcrapportoall1_mcrdef() {
  }
  public MemoryCursorRow_mcrapportoall1_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcrapportoall1_mcrdef toBuild = new MemoryCursor_mcrapportoall1_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcrapportoall1_mcrdef toBuild = new MemoryCursor_mcrapportoall1_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOINTER = "";
  String CODINTER = "";
  String RAPPORTO = "";
  String CODFIL = "";
  String CABFIL = "";
  java.sql.Date DATAPERT = CPLib.NullDate();
  java.sql.Date DATACHIU = CPLib.NullDate();
  String TIPORAPP = "";
  String VALUTA = "";
  String NDG = "";
  java.sql.Date DATAINISOGG = CPLib.NullDate();
  java.sql.Date DATAFINSOGG = CPLib.NullDate();
  String TIPOSOGG = "";
  String NDGSOGG = "";
  String RAGSOG = "";
  String SESSOSOGG = "";
  String CODFISCSOGG = "";
  java.sql.Date DATANASCSOGG = CPLib.NullDate();
  String COMUNASCSOGG = "";
  String DENOMSOGG = "";
  String COMUNRESSOGG = "";
  String STATOSOGG = "";
  String SAESOGG = "";
  String FILLER = "";
  String ATECOSOGG = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABFIL))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAPERT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATACHIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAPP))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NDG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINISOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(NDGSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOG))) {
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
    if ( ! (CPLib.Empty(COMUNASCSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DENOMSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMUNRESSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOSOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(SAESOGG))) {
      return false;
    }
    if ( ! (CPLib.Empty(FILLER))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATECOSOGG))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcrapportoall1_mcrdef p_row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_row = new MemoryCursorRow_mcrapportoall1_mcrdef();
    CopyOperation<MemoryCursorRow_mcrapportoall1_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcrapportoall1_mcrdef.this.TIPOINTER = l_row.TIPOINTER;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.CODINTER = l_row.CODINTER;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.CODFIL = l_row.CODFIL;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.CABFIL = l_row.CABFIL;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.DATAPERT = l_row.DATAPERT;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.DATACHIU = l_row.DATACHIU;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.TIPORAPP = l_row.TIPORAPP;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.VALUTA = l_row.VALUTA;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.NDG = l_row.NDG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.DATAINISOGG = l_row.DATAINISOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.DATAFINSOGG = l_row.DATAFINSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.TIPOSOGG = l_row.TIPOSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.NDGSOGG = l_row.NDGSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.RAGSOG = l_row.RAGSOG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.SESSOSOGG = l_row.SESSOSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.CODFISCSOGG = l_row.CODFISCSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.DATANASCSOGG = l_row.DATANASCSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.COMUNASCSOGG = l_row.COMUNASCSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.DENOMSOGG = l_row.DENOMSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.COMUNRESSOGG = l_row.COMUNRESSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.STATOSOGG = l_row.STATOSOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.SAESOGG = l_row.SAESOGG;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.FILLER = l_row.FILLER;
      MemoryCursorRow_mcrapportoall1_mcrdef.this.ATECOSOGG = l_row.ATECOSOGG;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcrapportoall1_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcrapportoall1_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcrapportoall1_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcrapportoall1_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcrapportoall1_mcrdef p_From,MemoryCursorRow_mcrapportoall1_mcrdef p_To) {
        p_To.TIPOINTER = copyAndCast(p_From.TIPOINTER);
        p_To.CODINTER = copyAndCast(p_From.CODINTER);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.CODFIL = copyAndCast(p_From.CODFIL);
        p_To.CABFIL = copyAndCast(p_From.CABFIL);
        p_To.DATAPERT = copyAndCast(p_From.DATAPERT);
        p_To.DATACHIU = copyAndCast(p_From.DATACHIU);
        p_To.TIPORAPP = copyAndCast(p_From.TIPORAPP);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
        p_To.NDG = copyAndCast(p_From.NDG);
        p_To.DATAINISOGG = copyAndCast(p_From.DATAINISOGG);
        p_To.DATAFINSOGG = copyAndCast(p_From.DATAFINSOGG);
        p_To.TIPOSOGG = copyAndCast(p_From.TIPOSOGG);
        p_To.NDGSOGG = copyAndCast(p_From.NDGSOGG);
        p_To.RAGSOG = copyAndCast(p_From.RAGSOG);
        p_To.SESSOSOGG = copyAndCast(p_From.SESSOSOGG);
        p_To.CODFISCSOGG = copyAndCast(p_From.CODFISCSOGG);
        p_To.DATANASCSOGG = copyAndCast(p_From.DATANASCSOGG);
        p_To.COMUNASCSOGG = copyAndCast(p_From.COMUNASCSOGG);
        p_To.DENOMSOGG = copyAndCast(p_From.DENOMSOGG);
        p_To.COMUNRESSOGG = copyAndCast(p_From.COMUNRESSOGG);
        p_To.STATOSOGG = copyAndCast(p_From.STATOSOGG);
        p_To.SAESOGG = copyAndCast(p_From.SAESOGG);
        p_To.FILLER = copyAndCast(p_From.FILLER);
        p_To.ATECOSOGG = copyAndCast(p_From.ATECOSOGG);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOINTER","CODINTER","RAPPORTO","CODFIL","CABFIL","DATAPERT","DATACHIU","TIPORAPP","VALUTA","NDG","DATAINISOGG","DATAFINSOGG","TIPOSOGG","NDGSOGG","RAGSOG","SESSOSOGG","CODFISCSOGG","DATANASCSOGG","COMUNASCSOGG","DENOMSOGG","COMUNRESSOGG","STATOSOGG","SAESOGG","FILLER","ATECOSOGG"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","D","C","C","C","D","D","C","C","C","C","C","D","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo inermediario","Codice Intermediario","Identificativo Rapporto","Codice Filiale/Punto Operativo","CAB Filiale/Punto Operativo","Data apertura Rapporto","Data chiusura Rapporto","Tipo Rapporto","Valuta","NDG","Data inizio validità Soggetto","Data fine validità Soggetto","Tipo di Soggetto","NDG Soggetto","Cognome Nome/Ragione Sociale","Sesso del Soggetto","Codice Fiscale del Soggetto","Data di Nascita del Soggetto","Comune/Paese di Nascita del Soggetto","Indirizzo di residenza Soggetto","Comune di residenza Soggetto","Stato di Residenza del Soggetto","Sot.grup. Attiv. Econ. del Soggetto","A disposizione (69 caratteri)","ATECO del Soggetto"};
    return l_names;
  }
}
