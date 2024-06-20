public class MemoryCursorRow_mcerrsvip_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcerrsvip_mcrdef() {
  }
  public MemoryCursorRow_mcerrsvip_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcerrsvip_mcrdef toBuild = new MemoryCursor_mcerrsvip_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcerrsvip_mcrdef toBuild = new MemoryCursor_mcerrsvip_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String tipodato = "";
  String id_dato = "";
  String info = "";
  String errore = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(tipodato))) {
      return false;
    }
    if ( ! (CPLib.Empty(id_dato))) {
      return false;
    }
    if ( ! (CPLib.Empty(info))) {
      return false;
    }
    if ( ! (CPLib.Empty(errore))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcerrsvip_mcrdef p_row) {
    MemoryCursorRow_mcerrsvip_mcrdef l_row = new MemoryCursorRow_mcerrsvip_mcrdef();
    CopyOperation<MemoryCursorRow_mcerrsvip_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcerrsvip_mcrdef.this.tipodato = l_row.tipodato;
      MemoryCursorRow_mcerrsvip_mcrdef.this.id_dato = l_row.id_dato;
      MemoryCursorRow_mcerrsvip_mcrdef.this.info = l_row.info;
      MemoryCursorRow_mcerrsvip_mcrdef.this.errore = l_row.errore;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcerrsvip_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcerrsvip_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcerrsvip_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcerrsvip_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcerrsvip_mcrdef p_From,MemoryCursorRow_mcerrsvip_mcrdef p_To) {
        p_To.tipodato = copyAndCast(p_From.tipodato);
        p_To.id_dato = copyAndCast(p_From.id_dato);
        p_To.info = copyAndCast(p_From.info);
        p_To.errore = copyAndCast(p_From.errore);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"tipodato","id_dato","info","errore"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","",""};
    return l_names;
  }
}
