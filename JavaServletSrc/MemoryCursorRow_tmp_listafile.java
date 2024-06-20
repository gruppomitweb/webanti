public class MemoryCursorRow_tmp_listafile extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_listafile() {
  }
  public MemoryCursorRow_tmp_listafile(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_listafile toBuild = new MemoryCursor_tmp_listafile(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_listafile toBuild = new MemoryCursor_tmp_listafile();
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
  void Copy(MemoryCursorRow_tmp_listafile p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_listafile.this.nomefile = copyAndCast(p_row.nomefile);
      MemoryCursorRow_tmp_listafile.this.priorita = copyAndCast(p_row.priorita);
      MemoryCursorRow_tmp_listafile.this.hyperlynk = copyAndCast(p_row.hyperlynk);
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
