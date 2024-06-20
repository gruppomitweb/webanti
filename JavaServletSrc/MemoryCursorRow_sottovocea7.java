public class MemoryCursorRow_sottovocea7 extends CPMemoryCursorRow {
  public MemoryCursorRow_sottovocea7() {
  }
  public MemoryCursorRow_sottovocea7(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sottovocea7 toBuild = new MemoryCursor_sottovocea7(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sottovocea7 toBuild = new MemoryCursor_sottovocea7();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String VOCE = "";
  String SOTTOVOCE = "";
  String DESCRI = "";
  String FLGRESID = "";
  String FLG00015 = "";
  String FLG00016 = "";
  String FLG01217 = "";
  String FLG02147 = "";
  String FLG02148 = "";
  String FLG02149 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(VOCE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTTOVOCE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGRESID))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLG00015))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLG00016))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLG01217))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLG02147))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLG02148))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLG02149))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sottovocea7 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sottovocea7.this.VOCE = copyAndCast(p_row.VOCE);
      MemoryCursorRow_sottovocea7.this.SOTTOVOCE = copyAndCast(p_row.SOTTOVOCE);
      MemoryCursorRow_sottovocea7.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_sottovocea7.this.FLGRESID = copyAndCast(p_row.FLGRESID);
      MemoryCursorRow_sottovocea7.this.FLG00015 = copyAndCast(p_row.FLG00015);
      MemoryCursorRow_sottovocea7.this.FLG00016 = copyAndCast(p_row.FLG00016);
      MemoryCursorRow_sottovocea7.this.FLG01217 = copyAndCast(p_row.FLG01217);
      MemoryCursorRow_sottovocea7.this.FLG02147 = copyAndCast(p_row.FLG02147);
      MemoryCursorRow_sottovocea7.this.FLG02148 = copyAndCast(p_row.FLG02148);
      MemoryCursorRow_sottovocea7.this.FLG02149 = copyAndCast(p_row.FLG02149);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"VOCE","SOTTOVOCE","DESCRI","FLGRESID","FLG00015","FLG00016","FLG01217","FLG02147","FLG02148","FLG02149"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Voce","Codice Sottovoce","Descrizione","Flag Residenza","Attiva Provincia","Attiva Stato","Attiva Tab 1217","Attiva Tab 2147","Attiva Tab 2148","Attiva Tab 2149"};
    return l_names;
  }
}
