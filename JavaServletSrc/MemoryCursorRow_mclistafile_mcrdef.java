public class MemoryCursorRow_mclistafile_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mclistafile_mcrdef() {
  }
  public MemoryCursorRow_mclistafile_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mclistafile_mcrdef toBuild = new MemoryCursor_mclistafile_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mclistafile_mcrdef toBuild = new MemoryCursor_mclistafile_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String nomefile = "";
  double priorita = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(nomefile))) {
      return false;
    }
    if ( ! (CPLib.Empty(priorita))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mclistafile_mcrdef p_row) {
    MemoryCursorRow_mclistafile_mcrdef l_row = new MemoryCursorRow_mclistafile_mcrdef();
    CopyOperation<MemoryCursorRow_mclistafile_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mclistafile_mcrdef.this.nomefile = l_row.nomefile;
      MemoryCursorRow_mclistafile_mcrdef.this.priorita = l_row.priorita;
    }
  }
  protected CopyOperation<MemoryCursorRow_mclistafile_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mclistafile_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mclistafile_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mclistafile_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mclistafile_mcrdef p_From,MemoryCursorRow_mclistafile_mcrdef p_To) {
        p_To.nomefile = copyAndCast(p_From.nomefile);
        p_To.priorita = copyAndCast(p_From.priorita);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"nomefile","priorita"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"NomeFile","Indice Priorità"};
    return l_names;
  }
}
