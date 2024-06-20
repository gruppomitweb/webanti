public class MemoryCursorRow_mcritorno_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcritorno_mcrdef() {
  }
  public MemoryCursorRow_mcritorno_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcritorno_mcrdef toBuild = new MemoryCursor_mcritorno_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcritorno_mcrdef toBuild = new MemoryCursor_mcritorno_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String tipo = "";
  double numero = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(tipo))) {
      return false;
    }
    if ( ! (CPLib.Empty(numero))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcritorno_mcrdef p_row) {
    MemoryCursorRow_mcritorno_mcrdef l_row = new MemoryCursorRow_mcritorno_mcrdef();
    CopyOperation<MemoryCursorRow_mcritorno_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcritorno_mcrdef.this.tipo = l_row.tipo;
      MemoryCursorRow_mcritorno_mcrdef.this.numero = l_row.numero;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcritorno_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcritorno_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcritorno_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcritorno_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcritorno_mcrdef p_From,MemoryCursorRow_mcritorno_mcrdef p_To) {
        p_To.tipo = copyAndCast(p_From.tipo);
        p_To.numero = copyAndCast(p_From.numero);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"tipo","numero"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo OPerazione","Numero OPerazioni"};
    return l_names;
  }
}
