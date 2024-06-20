public class MemoryCursorRow_mcelencofile_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcelencofile_mcrdef() {
  }
  public MemoryCursorRow_mcelencofile_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcelencofile_mcrdef toBuild = new MemoryCursor_mcelencofile_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcelencofile_mcrdef toBuild = new MemoryCursor_mcelencofile_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String Path = "";
  String File = "";
  boolean Directory = false;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(Path))) {
      return false;
    }
    if ( ! (CPLib.Empty(File))) {
      return false;
    }
    if ( ! (CPLib.Empty(Directory))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcelencofile_mcrdef p_row) {
    MemoryCursorRow_mcelencofile_mcrdef l_row = new MemoryCursorRow_mcelencofile_mcrdef();
    CopyOperation<MemoryCursorRow_mcelencofile_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcelencofile_mcrdef.this.Path = l_row.Path;
      MemoryCursorRow_mcelencofile_mcrdef.this.File = l_row.File;
      MemoryCursorRow_mcelencofile_mcrdef.this.Directory = l_row.Directory;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcelencofile_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcelencofile_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcelencofile_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcelencofile_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcelencofile_mcrdef p_From,MemoryCursorRow_mcelencofile_mcrdef p_To) {
        p_To.Path = copyAndCast(p_From.Path);
        p_To.File = copyAndCast(p_From.File);
        p_To.Directory = copyAndCast(p_From.Directory);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"Path","File","Directory"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","L"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Percoro del file compresivo del nome","Nome del file","True/False"};
    return l_names;
  }
}
