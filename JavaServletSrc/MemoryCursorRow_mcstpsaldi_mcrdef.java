public class MemoryCursorRow_mcstpsaldi_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcstpsaldi_mcrdef() {
  }
  public MemoryCursorRow_mcstpsaldi_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcstpsaldi_mcrdef toBuild = new MemoryCursor_mcstpsaldi_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcstpsaldi_mcrdef toBuild = new MemoryCursor_mcstpsaldi_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPORAP = "";
  String RAPPORTO = "";
  String CONNESINT = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  String IDEREG = "";
  String IDBASE = "";
  String UNIQUE = "";
  String ANNO = "";
  double SALDO = 0;
  double QUANTITA = 0;
  String VALUTA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ANNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SALDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(QUANTITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcstpsaldi_mcrdef p_row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_row = new MemoryCursorRow_mcstpsaldi_mcrdef();
    CopyOperation<MemoryCursorRow_mcstpsaldi_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcstpsaldi_mcrdef.this.TIPORAP = l_row.TIPORAP;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.CONNESINT = l_row.CONNESINT;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.DATAINI = l_row.DATAINI;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.IDEREG = l_row.IDEREG;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.IDBASE = l_row.IDBASE;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.UNIQUE = l_row.UNIQUE;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.ANNO = l_row.ANNO;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.SALDO = l_row.SALDO;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.QUANTITA = l_row.QUANTITA;
      MemoryCursorRow_mcstpsaldi_mcrdef.this.VALUTA = l_row.VALUTA;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcstpsaldi_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcstpsaldi_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcstpsaldi_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcstpsaldi_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcstpsaldi_mcrdef p_From,MemoryCursorRow_mcstpsaldi_mcrdef p_To) {
        p_To.TIPORAP = copyAndCast(p_From.TIPORAP);
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.CONNESINT = copyAndCast(p_From.CONNESINT);
        p_To.DATAINI = copyAndCast(p_From.DATAINI);
        p_To.IDEREG = copyAndCast(p_From.IDEREG);
        p_To.IDBASE = copyAndCast(p_From.IDBASE);
        p_To.UNIQUE = copyAndCast(p_From.UNIQUE);
        p_To.ANNO = copyAndCast(p_From.ANNO);
        p_To.SALDO = copyAndCast(p_From.SALDO);
        p_To.QUANTITA = copyAndCast(p_From.QUANTITA);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPORAP","RAPPORTO","CONNESINT","DATAINI","IDEREG","IDBASE","UNIQUE","ANNO","SALDO","QUANTITA","VALUTA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","C","C","C","C","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Rapporto","Rapporto","Soggetto OPEX","Data Operazione","Tipo","ID Operazione","Codice Univoco","Anno Riferimento","Saldo Annuo","N. Operazioni","Codice Valuta"};
    return l_names;
  }
}
