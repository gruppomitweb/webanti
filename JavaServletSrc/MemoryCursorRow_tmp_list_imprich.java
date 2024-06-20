public class MemoryCursorRow_tmp_list_imprich extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_list_imprich() {
  }
  public MemoryCursorRow_tmp_list_imprich(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_list_imprich toBuild = new MemoryCursor_tmp_list_imprich(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_list_imprich toBuild = new MemoryCursor_tmp_list_imprich();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String nomefile = "";
  double priorita = 0;
  String hyperlynk = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(nomefile))) {
      return false;
    }
    if ( ! (CPLib.Empty(priorita))) {
      return false;
    }
    if ( ! (CPLib.Empty(hyperlynk))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_list_imprich p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_list_imprich.this.nomefile = copyAndCast(p_row.nomefile);
      MemoryCursorRow_tmp_list_imprich.this.priorita = copyAndCast(p_row.priorita);
      MemoryCursorRow_tmp_list_imprich.this.hyperlynk = copyAndCast(p_row.hyperlynk);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"nomefile","priorita","hyperlynk"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Nome file da importare","Priorità del file da importare",""};
    return l_names;
  }
}
