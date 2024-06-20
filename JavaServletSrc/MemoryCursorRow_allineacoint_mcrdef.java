public class MemoryCursorRow_allineacoint_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_allineacoint_mcrdef() {
  }
  public MemoryCursorRow_allineacoint_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_allineacoint_mcrdef toBuild = new MemoryCursor_allineacoint_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_allineacoint_mcrdef toBuild = new MemoryCursor_allineacoint_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String RAPPORTO = "";
  String TIPO = "";
  double SCELTO_new = 0;
  double SCELTO_old = 0;
  String NEWRAPPORTO_new = "";
  String NEWRAPPORTO_OLD = "";
  String ps_rowstatus = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCELTO_new))) {
      return false;
    }
    if ( ! (CPLib.Empty(SCELTO_old))) {
      return false;
    }
    if ( ! (CPLib.Empty(NEWRAPPORTO_new))) {
      return false;
    }
    if ( ! (CPLib.Empty(NEWRAPPORTO_OLD))) {
      return false;
    }
    if ( ! (CPLib.Empty(ps_rowstatus))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_allineacoint_mcrdef p_row) {
    MemoryCursorRow_allineacoint_mcrdef l_row = new MemoryCursorRow_allineacoint_mcrdef();
    CopyOperation<MemoryCursorRow_allineacoint_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_allineacoint_mcrdef.this.IDBASE = l_row.IDBASE;
      MemoryCursorRow_allineacoint_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_allineacoint_mcrdef.this.TIPO = l_row.TIPO;
      MemoryCursorRow_allineacoint_mcrdef.this.SCELTO_new = l_row.SCELTO_new;
      MemoryCursorRow_allineacoint_mcrdef.this.SCELTO_old = l_row.SCELTO_old;
      MemoryCursorRow_allineacoint_mcrdef.this.NEWRAPPORTO_new = l_row.NEWRAPPORTO_new;
      MemoryCursorRow_allineacoint_mcrdef.this.NEWRAPPORTO_OLD = l_row.NEWRAPPORTO_OLD;
      MemoryCursorRow_allineacoint_mcrdef.this.ps_rowstatus = l_row.ps_rowstatus;
    }
  }
  protected CopyOperation<MemoryCursorRow_allineacoint_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_allineacoint_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_allineacoint_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_allineacoint_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_allineacoint_mcrdef p_From,MemoryCursorRow_allineacoint_mcrdef p_To) {
        p_To.IDBASE = copyAndCast(p_From.IDBASE);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.TIPO = copyAndCast(p_From.TIPO);
        p_To.SCELTO_new = copyAndCast(p_From.SCELTO_new);
        p_To.SCELTO_old = copyAndCast(p_From.SCELTO_old);
        p_To.NEWRAPPORTO_new = copyAndCast(p_From.NEWRAPPORTO_new);
        p_To.NEWRAPPORTO_OLD = copyAndCast(p_From.NEWRAPPORTO_OLD);
        p_To.ps_rowstatus = copyAndCast(p_From.ps_rowstatus);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","RAPPORTO","TIPO","SCELTO_new","SCELTO_old","NEWRAPPORTO_new","NEWRAPPORTO_OLD","ps_rowstatus"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","N","N","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Identificatore","Codice Rapporto","R=Rapporto D=Delegato","Se Selezionato","Vecchio Valore","Nuovo Codice Rapporto","Vecchio Codice Rapporto","Stato Riga"};
    return l_names;
  }
}
