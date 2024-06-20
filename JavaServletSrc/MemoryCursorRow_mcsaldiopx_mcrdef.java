public class MemoryCursorRow_mcsaldiopx_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcsaldiopx_mcrdef() {
  }
  public MemoryCursorRow_mcsaldiopx_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcsaldiopx_mcrdef toBuild = new MemoryCursor_mcsaldiopx_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcsaldiopx_mcrdef toBuild = new MemoryCursor_mcsaldiopx_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNESCLI = "";
  String IDFILE = "";
  double TOTLIRE = 0;
  String NUMPROG = "";
  String MACODICE = "";
  String MAFLGNOX = "";
  String COLLEG = "";
  String RAPPORTO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(MACODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGNOX))) {
      return false;
    }
    if ( ! (CPLib.Empty(COLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcsaldiopx_mcrdef p_row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_row = new MemoryCursorRow_mcsaldiopx_mcrdef();
    CopyOperation<MemoryCursorRow_mcsaldiopx_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcsaldiopx_mcrdef.this.CONNESCLI = l_row.CONNESCLI;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.IDFILE = l_row.IDFILE;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.TOTLIRE = l_row.TOTLIRE;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.NUMPROG = l_row.NUMPROG;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.MACODICE = l_row.MACODICE;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.MAFLGNOX = l_row.MAFLGNOX;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.COLLEG = l_row.COLLEG;
      MemoryCursorRow_mcsaldiopx_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcsaldiopx_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcsaldiopx_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcsaldiopx_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcsaldiopx_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcsaldiopx_mcrdef p_From,MemoryCursorRow_mcsaldiopx_mcrdef p_To) {
        p_To.CONNESCLI = copyAndCast(p_From.CONNESCLI);
        p_To.IDFILE = copyAndCast(p_From.IDFILE);
        p_To.TOTLIRE = copyAndCast(p_From.TOTLIRE);
        p_To.NUMPROG = copyAndCast(p_From.NUMPROG);
        p_To.MACODICE = copyAndCast(p_From.MACODICE);
        p_To.MAFLGNOX = copyAndCast(p_From.MAFLGNOX);
        p_To.COLLEG = copyAndCast(p_From.COLLEG);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNESCLI","IDFILE","TOTLIRE","NUMPROG","MACODICE","MAFLGNOX","COLLEG","RAPPORTO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","N","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"NDG","ID File","Importo Operazione","N. Operazione","Macroagente","No Operazione Extraconto","Operazione Extraconto","Codice Rapporto"};
    return l_names;
  }
}
