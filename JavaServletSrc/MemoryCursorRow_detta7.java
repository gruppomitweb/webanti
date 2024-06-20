public class MemoryCursorRow_detta7 extends CPMemoryCursorRow {
  public MemoryCursorRow_detta7() {
  }
  public MemoryCursorRow_detta7(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_detta7 toBuild = new MemoryCursor_detta7(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_detta7 toBuild = new MemoryCursor_detta7();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ANNO = "";
  String SEMESTRE = "";
  double CPROWNUM = 0;
  String VOCE = "";
  String SOTTOVOCE = "";
  String RESID = "";
  String PROVINCIA = "";
  String STATO = "";
  String VAL01217 = "";
  String VAL02147 = "";
  java.sql.Date VAL02148 = CPLib.NullDate();
  String VAL02149 = "";
  java.sql.Date DATAEFF = CPLib.NullDate();
  double IMPORTO = 0;
  String IDBASEA7 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ANNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEMESTRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CPROWNUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(VOCE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTTOVOCE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESID))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(VAL01217))) {
      return false;
    }
    if ( ! (CPLib.Empty(VAL02147))) {
      return false;
    }
    if ( ! (CPLib.Empty(VAL02148))) {
      return false;
    }
    if ( ! (CPLib.Empty(VAL02149))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAEFF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASEA7))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_detta7 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_detta7.this.ANNO = copyAndCast(p_row.ANNO);
      MemoryCursorRow_detta7.this.SEMESTRE = copyAndCast(p_row.SEMESTRE);
      MemoryCursorRow_detta7.this.CPROWNUM = copyAndCast(p_row.CPROWNUM);
      MemoryCursorRow_detta7.this.VOCE = copyAndCast(p_row.VOCE);
      MemoryCursorRow_detta7.this.SOTTOVOCE = copyAndCast(p_row.SOTTOVOCE);
      MemoryCursorRow_detta7.this.RESID = copyAndCast(p_row.RESID);
      MemoryCursorRow_detta7.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_detta7.this.STATO = copyAndCast(p_row.STATO);
      MemoryCursorRow_detta7.this.VAL01217 = copyAndCast(p_row.VAL01217);
      MemoryCursorRow_detta7.this.VAL02147 = copyAndCast(p_row.VAL02147);
      MemoryCursorRow_detta7.this.VAL02148 = copyAndCast(p_row.VAL02148);
      MemoryCursorRow_detta7.this.VAL02149 = copyAndCast(p_row.VAL02149);
      MemoryCursorRow_detta7.this.DATAEFF = copyAndCast(p_row.DATAEFF);
      MemoryCursorRow_detta7.this.IMPORTO = copyAndCast(p_row.IMPORTO);
      MemoryCursorRow_detta7.this.IDBASEA7 = copyAndCast(p_row.IDBASEA7);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ANNO","SEMESTRE","CPROWNUM","VOCE","SOTTOVOCE","RESID","PROVINCIA","STATO","VAL01217","VAL02147","VAL02148","VAL02149","DATAEFF","IMPORTO","IDBASEA7"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","N","C","C","C","C","C","C","C","D","C","D","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Annno","SEMESTRE","N. Riga","Voce","Sottovoce","Residenza","Provincia","Stato","Oggett dei reclami","Tipo Restituzione","Data Efficacia","Progressivo Manovra","Data Effettuazione","Valore","IDBASE RIga"};
    return l_names;
  }
}
