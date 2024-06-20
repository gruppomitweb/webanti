public class MemoryCursorRow_intestit extends CPMemoryCursorRow {
  public MemoryCursorRow_intestit() {
  }
  public MemoryCursorRow_intestit(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_intestit toBuild = new MemoryCursor_intestit(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_intestit toBuild = new MemoryCursor_intestit();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODCLI = "";
  String RAPPORTO = "";
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
  double PRGIMPTITE = 0;
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  String NOAGE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
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
    if ( ! (CPLib.Empty(PRGIMPTITE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOAGE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_intestit p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_intestit.this.CODCLI = copyAndCast(p_row.CODCLI);
      MemoryCursorRow_intestit.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_intestit.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_intestit.this.DESCINTER = copyAndCast(p_row.DESCINTER);
      MemoryCursorRow_intestit.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_intestit.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_intestit.this.TIPOPERS = copyAndCast(p_row.TIPOPERS);
      MemoryCursorRow_intestit.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_intestit.this.OPERAZMOD = copyAndCast(p_row.OPERAZMOD);
      MemoryCursorRow_intestit.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_intestit.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_intestit.this.COLLEGAMEN = copyAndCast(p_row.COLLEGAMEN);
      MemoryCursorRow_intestit.this.DATAFINE = copyAndCast(p_row.DATAFINE);
      MemoryCursorRow_intestit.this.NUMPROG1 = copyAndCast(p_row.NUMPROG1);
      MemoryCursorRow_intestit.this.NUMPROG2 = copyAndCast(p_row.NUMPROG2);
      MemoryCursorRow_intestit.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_intestit.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_intestit.this.ABBINATO = copyAndCast(p_row.ABBINATO);
      MemoryCursorRow_intestit.this.PRGIMPTITE = copyAndCast(p_row.PRGIMPTITE);
      MemoryCursorRow_intestit.this.NUMIMP = copyAndCast(p_row.NUMIMP);
      MemoryCursorRow_intestit.this.NOAGE = copyAndCast(p_row.NOAGE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODCLI","RAPPORTO","CODINTER","DESCINTER","DATAINI","TIPORAP","TIPOPERS","STATOREG","OPERAZMOD","DATARETT","IDEREG","COLLEGAMEN","DATAFINE","NUMPROG1","NUMPROG2","IDBASE","UCODE","ABBINATO","PRGIMPTITE","NUMIMP","NOAGE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","D","C","C","C","C","D","C","C","D","C","C","C","C","N","N","T","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","Mark Importazione","Da non inviare all'agenzia delle entrate"};
    return l_names;
  }
}
