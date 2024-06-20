public class MemoryCursorRow_intestbo extends CPMemoryCursorRow {
  public MemoryCursorRow_intestbo() {
  }
  public MemoryCursorRow_intestbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_intestbo toBuild = new MemoryCursor_intestbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_intestbo toBuild = new MemoryCursor_intestbo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  double CPROWNUM = 0;
  java.sql.Date DATAINI = CPLib.NullDate();
  String TIPOPERS = "";
  String CODINTER = "";
  java.sql.Date DATAFINE = CPLib.NullDate();
  String NUMPROG1 = "";
  String NUMPROG2 = "";
  String RAPPORTO = "";
  String TIPORAP = "";
  String STATOREG = "";
  String DESCINTER = "";
  String OPERAZMOD = "";
  java.sql.Date DATARETT = CPLib.NullDate();
  String IDEREG = "";
  String COLLEGAMEN = "";
  String UCODE = "";
  double ABBINATO = 0;
  double PRGIMPSOG = 0;
  double PROQUOTA = 0;
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CPROWNUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOPERS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG1))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG2))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZMOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(COLLEGAMEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(UCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABBINATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PRGIMPSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROQUOTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_intestbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_intestbo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_intestbo.this.CPROWNUM = copyAndCast(p_row.CPROWNUM);
      MemoryCursorRow_intestbo.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_intestbo.this.TIPOPERS = copyAndCast(p_row.TIPOPERS);
      MemoryCursorRow_intestbo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_intestbo.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_intestbo.this.NUMPROG1 = copyAndCast(p_row.NUMPROG1);
      MemoryCursorRow_intestbo.this.NUMPROG2 = copyAndCast(p_row.NUMPROG2);
      MemoryCursorRow_intestbo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_intestbo.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_intestbo.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_intestbo.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_intestbo.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_intestbo.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_intestbo.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_intestbo.this.COLLEGAMEN = copyAndCast(p_row.COLLEGAMEN);
      MemoryCursorRow_intestbo.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_intestbo.this.ABBINATO = copyAndCast(p_row.ABBINATO);
      MemoryCursorRow_intestbo.this.PRGIMPSOG = copyAndCast(p_row.PRGIMPSOG);
      MemoryCursorRow_intestbo.this.PROQUOTA = copyAndCast(p_row.PROQUOTA);
      MemoryCursorRow_intestbo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","CPROWNUM","DATAINI","TIPOPERS","CODINTER","DATAFINE","NUMPROG1","NUMPROG2","RAPPORTO","TIPORAP","STATOREG","DESCINTER","OPERAZMOD","DATARETT","IDEREG","COLLEGAMEN","UCODE","ABBINATO","PRGIMPSOG","PROQUOTA","NUMIMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","D","C","C","D","C","C","C","C","C","C","C","D","C","C","C","N","N","N","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"idbase","Numero riga","Data Inizio","Tipo Soggetto","Intestatario (Non Intermediario)","Data Fine","Numero Progressivo relativo","Numero Progressivo Relativo Chiusura","Rapporto (Copia della testata)","Tipo Rapporto","Stato Registrazione","","Operazione modificata","Data Rettifica","IDEREG","Collegamento","","","Progressivo Import","Pro Quota","Mark Importazione"};
    return l_names;
  }
}
