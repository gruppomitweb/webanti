public class MemoryCursorRow_mcvt_cliente_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcvt_cliente_mcrdef() {
  }
  public MemoryCursorRow_mcvt_cliente_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcvt_cliente_mcrdef toBuild = new MemoryCursor_mcvt_cliente_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcvt_cliente_mcrdef toBuild = new MemoryCursor_mcvt_cliente_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String cod_cliente = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(cod_cliente))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcvt_cliente_mcrdef p_row) {
    MemoryCursorRow_mcvt_cliente_mcrdef l_row = new MemoryCursorRow_mcvt_cliente_mcrdef();
    CopyOperation<MemoryCursorRow_mcvt_cliente_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcvt_cliente_mcrdef.this.cod_cliente = l_row.cod_cliente;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcvt_cliente_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcvt_cliente_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcvt_cliente_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcvt_cliente_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcvt_cliente_mcrdef p_From,MemoryCursorRow_mcvt_cliente_mcrdef p_To) {
        p_To.cod_cliente = copyAndCast(p_From.cod_cliente);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"cod_cliente"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Cliente"};
    return l_names;
  }
}
