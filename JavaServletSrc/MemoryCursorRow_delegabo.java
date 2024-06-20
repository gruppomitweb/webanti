public class MemoryCursorRow_delegabo extends CPMemoryCursorRow {
  public MemoryCursorRow_delegabo() {
  }
  public MemoryCursorRow_delegabo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_delegabo toBuild = new MemoryCursor_delegabo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_delegabo toBuild = new MemoryCursor_delegabo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  double CPROWNUM = 0;
  String CODINTER = "";
  String DESCINTER = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  String TIPORAP = "";
  String TIPOPERS = "";
  String STATOREG = "";
  String OPERAZMOD = "";
  java.sql.Date DATARETT = CPLib.NullDate();
  String IDEREG = "";
  String COLLEGAMEN = "";
  java.sql.Date DATAFINE = CPLib.NullDate();
  String NUMPROG1 = "";
  String NUMPROG2 = "";
  String IDBASE = "";
  String UCODE = "";
  double ABBINATO = 0;
  String NOAGE = "";
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CPROWNUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOPERS))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATOREG))) {
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
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG1))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG2))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(UCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABBINATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_delegabo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_delegabo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_delegabo.this.CPROWNUM = copyAndCast(p_row.CPROWNUM);
      MemoryCursorRow_delegabo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_delegabo.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_delegabo.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_delegabo.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_delegabo.this.TIPOPERS = copyAndCast(p_row.TIPOPERS);
      MemoryCursorRow_delegabo.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_delegabo.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_delegabo.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_delegabo.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_delegabo.this.COLLEGAMEN = copyAndCast(p_row.COLLEGAMEN);
      MemoryCursorRow_delegabo.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_delegabo.this.NUMPROG1 = copyAndCast(p_row.NUMPROG1);
      MemoryCursorRow_delegabo.this.NUMPROG2 = copyAndCast(p_row.NUMPROG2);
      MemoryCursorRow_delegabo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_delegabo.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_delegabo.this.ABBINATO = copyAndCast(p_row.ABBINATO);
      MemoryCursorRow_delegabo.this.NOAGE = copyAndCast(p_row.NOAGE);
      MemoryCursorRow_delegabo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","CPROWNUM","CODINTER","DESCINTER","DATAINI","TIPORAP","TIPOPERS","STATOREG","OPERAZMOD","DATARETT","IDEREG","COLLEGAMEN","DATAFINE","NUMPROG1","NUMPROG2","IDBASE","UCODE","ABBINATO","NOAGE","NUMIMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","C","D","C","C","C","C","D","C","C","D","C","C","C","C","N","C","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","N° Riga","","","Data Inizio","Tipo Rapporto","Tipo Persona","Stato Registrazione","","Data Rettifica","Identificativo Registrazione","Collegamento","Data Fine","N° Progressivo","N° Registrazione","IDBASE","","","","Mark Importazione"};
    return l_names;
  }
}
