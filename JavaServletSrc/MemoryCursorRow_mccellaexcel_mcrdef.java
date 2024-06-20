public class MemoryCursorRow_mccellaexcel_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccellaexcel_mcrdef() {
  }
  public MemoryCursorRow_mccellaexcel_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccellaexcel_mcrdef toBuild = new MemoryCursor_mccellaexcel_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccellaexcel_mcrdef toBuild = new MemoryCursor_mccellaexcel_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String stringa = "";
  double numeric = 0;
  java.sql.Date date = CPLib.NullDate();
  java.sql.Timestamp datetime = CPLib.NullDateTime();
  boolean logic = false;
  String memo = "";
  double riga = 0;
  double colonna = 0;
  String cellType = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(stringa))) {
      return false;
    }
    if ( ! (CPLib.Empty(numeric))) {
      return false;
    }
    if ( ! (CPLib.Empty(date))) {
      return false;
    }
    if ( ! (CPLib.Empty(datetime))) {
      return false;
    }
    if ( ! (CPLib.Empty(logic))) {
      return false;
    }
    if ( ! (CPLib.Empty(memo))) {
      return false;
    }
    if ( ! (CPLib.Empty(riga))) {
      return false;
    }
    if ( ! (CPLib.Empty(colonna))) {
      return false;
    }
    if ( ! (CPLib.Empty(cellType))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccellaexcel_mcrdef p_row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_row = new MemoryCursorRow_mccellaexcel_mcrdef();
    CopyOperation<MemoryCursorRow_mccellaexcel_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccellaexcel_mcrdef.this.stringa = l_row.stringa;
      MemoryCursorRow_mccellaexcel_mcrdef.this.numeric = l_row.numeric;
      MemoryCursorRow_mccellaexcel_mcrdef.this.date = l_row.date;
      MemoryCursorRow_mccellaexcel_mcrdef.this.datetime = l_row.datetime;
      MemoryCursorRow_mccellaexcel_mcrdef.this.logic = l_row.logic;
      MemoryCursorRow_mccellaexcel_mcrdef.this.memo = l_row.memo;
      MemoryCursorRow_mccellaexcel_mcrdef.this.riga = l_row.riga;
      MemoryCursorRow_mccellaexcel_mcrdef.this.colonna = l_row.colonna;
      MemoryCursorRow_mccellaexcel_mcrdef.this.cellType = l_row.cellType;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccellaexcel_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccellaexcel_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccellaexcel_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccellaexcel_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccellaexcel_mcrdef p_From,MemoryCursorRow_mccellaexcel_mcrdef p_To) {
        p_To.stringa = copyAndCast(p_From.stringa);
        p_To.numeric = copyAndCast(p_From.numeric);
        p_To.date = copyAndCast(p_From.date);
        p_To.datetime = copyAndCast(p_From.datetime);
        p_To.logic = copyAndCast(p_From.logic);
        p_To.memo = copyAndCast(p_From.memo);
        p_To.riga = copyAndCast(p_From.riga);
        p_To.colonna = copyAndCast(p_From.colonna);
        p_To.cellType = copyAndCast(p_From.cellType);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"stringa","numeric","date","datetime","logic","memo","riga","colonna","cellType"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","D","T","L","M","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Valore di tipo Charater","Valore di tipo Numeric","Valore di tipo Date","Valore di tipo Datetime","Valore di tipo Logic","Valore di tipo memo","Numero di riga","numero di colonna","tipo di dato letto nella cella"};
    return l_names;
  }
}
