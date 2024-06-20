public class MemoryCursorRow_opextrbo extends CPMemoryCursorRow {
  public MemoryCursorRow_opextrbo() {
  }
  public MemoryCursorRow_opextrbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_opextrbo toBuild = new MemoryCursor_opextrbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_opextrbo toBuild = new MemoryCursor_opextrbo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String COLLEG = "";
  String ANNO = "";
  String IDBASE = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String COINT = "";
  String NOTE = "";
  String NUMPROG1 = "";
  String RIFIMP = "";
  String IDFILE = "";
  double PROGOPEX = 0;
  double SALDO = 0;
  double QUANTITA = 0;
  String VALUTA = "";
  String UNIQUER = "";
  String CODINTER = "";
  String OLDINTER = "";
  java.sql.Date DATAMODI = CPLib.NullDate();
  double INVIATO = 0;
  java.sql.Date DATAINVIO = CPLib.NullDate();
  double ANNULLA = 0;
  java.sql.Date DATAANNU = CPLib.NullDate();
  String OLDUNIQUE = "";
  java.sql.Date DATAOLDUNI = CPLib.NullDate();
  String IDESITO = "";
  String CONNESOPER = "";
  String RAPPORTO = "";
  double INVSALDO = 0;
  java.sql.Date DTSALDO = CPLib.NullDate();
  String CFESTERO = "";
  String INFORM = "";
  String NATURA = "";
  String FLGNOE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(COLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG1))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGOPEX))) {
      return false;
    }
    if ( ! (CPLib.Empty(SALDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(QUANTITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAMODI))) {
      return false;
    }
    if ( ! (CPLib.Empty(INVIATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINVIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNULLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAANNU))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDUNIQUE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOLDUNI))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDESITO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(INVSALDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DTSALDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGNOE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_opextrbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_opextrbo.this.COLLEG = copyAndCast(p_row.COLLEG);
      MemoryCursorRow_opextrbo.this.ANNO = copyAndCast(p_row.ANNO);
      MemoryCursorRow_opextrbo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_opextrbo.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_opextrbo.this.COINT = copyAndCast(p_row.COINT);
      MemoryCursorRow_opextrbo.this.NOTE = copyAndCast(p_row.NOTE);
      MemoryCursorRow_opextrbo.this.NUMPROG1 = copyAndCast(p_row.NUMPROG1);
      MemoryCursorRow_opextrbo.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_opextrbo.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_opextrbo.this.PROGOPEX = copyAndCast(p_row.PROGOPEX);
      MemoryCursorRow_opextrbo.this.SALDO = copyAndCast(p_row.SALDO);
      MemoryCursorRow_opextrbo.this.QUANTITA = copyAndCast(p_row.QUANTITA);
      MemoryCursorRow_opextrbo.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_opextrbo.this.UNIQUER = copyAndCast(p_row.UNIQUER);
      MemoryCursorRow_opextrbo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_opextrbo.this.OLDINTER = copyAndCast(p_row.OLDINTER);
      MemoryCursorRow_opextrbo.this.DATAMODI = copyAndCast(p_row.DATAMODI);
      MemoryCursorRow_opextrbo.this.INVIATO = copyAndCast(p_row.INVIATO);
      MemoryCursorRow_opextrbo.this.DATAINVIO = copyAndCast(p_row.DATAINVIO);
      MemoryCursorRow_opextrbo.this.ANNULLA = copyAndCast(p_row.ANNULLA);
      MemoryCursorRow_opextrbo.this.DATAANNU = copyAndCast(p_row.DATAANNU);
      MemoryCursorRow_opextrbo.this.OLDUNIQUE = copyAndCast(p_row.OLDUNIQUE);
      MemoryCursorRow_opextrbo.this.DATAOLDUNI = copyAndCast(p_row.DATAOLDUNI);
      MemoryCursorRow_opextrbo.this.IDESITO = copyAndCast(p_row.IDESITO);
      MemoryCursorRow_opextrbo.this.CONNESOPER = copyAndCast(p_row.CONNESOPER);
      MemoryCursorRow_opextrbo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_opextrbo.this.INVSALDO = copyAndCast(p_row.INVSALDO);
      MemoryCursorRow_opextrbo.this.DTSALDO = copyAndCast(p_row.DTSALDO);
      MemoryCursorRow_opextrbo.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_opextrbo.this.INFORM = copyAndCast(p_row.INFORM);
      MemoryCursorRow_opextrbo.this.NATURA = copyAndCast(p_row.NATURA);
      MemoryCursorRow_opextrbo.this.FLGNOE = copyAndCast(p_row.FLGNOE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"COLLEG","ANNO","IDBASE","DATAOPE","COINT","NOTE","NUMPROG1","RIFIMP","IDFILE","PROGOPEX","SALDO","QUANTITA","VALUTA","UNIQUER","CODINTER","OLDINTER","DATAMODI","INVIATO","DATAINVIO","ANNULLA","DATAANNU","OLDUNIQUE","DATAOLDUNI","IDESITO","CONNESOPER","RAPPORTO","INVSALDO","DTSALDO","CFESTERO","INFORM","NATURA","FLGNOE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","C","C","C","C","C","N","N","N","C","C","C","C","D","N","D","N","D","C","D","C","C","C","N","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Collegamento","Anno riferimento","Chiave Riga","Data Operazione","Delega Conto Terzi","Note","Collegamento a file per agenzia entrate","Riferimento Import","ID FIle Import","Progressivo Import","","","","","","","","","","","","","","","","","","","","Riferimento 2 Import","Natura valuta non UIF","Non presente in fotografia"};
    return l_names;
  }
}
