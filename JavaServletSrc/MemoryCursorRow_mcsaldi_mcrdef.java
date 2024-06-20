public class MemoryCursorRow_mcsaldi_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcsaldi_mcrdef() {
  }
  public MemoryCursorRow_mcsaldi_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcsaldi_mcrdef toBuild = new MemoryCursor_mcsaldi_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcsaldi_mcrdef toBuild = new MemoryCursor_mcsaldi_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String TIPOAG = "";
  String TIPORAP = "";
  String DESCRAP = "";
  String VALUTA = "";
  double INVIATO = 0;
  String TIPO = "";
  String CAB = "";
  String UNIQUECODE = "";
  String OLDINTER = "";
  double SALDO = 0;
  double QUANTITA = 0;
  String NATURA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(INVIATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUECODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OLDINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(SALDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(QUANTITA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NATURA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcsaldi_mcrdef p_row) {
    MemoryCursorRow_mcsaldi_mcrdef l_row = new MemoryCursorRow_mcsaldi_mcrdef();
    CopyOperation<MemoryCursorRow_mcsaldi_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcsaldi_mcrdef.this.RAPPORTO = l_row.RAPPORTO;
      MemoryCursorRow_mcsaldi_mcrdef.this.DATAINI = l_row.DATAINI;
      MemoryCursorRow_mcsaldi_mcrdef.this.DATAFINE = l_row.DATAFINE;
      MemoryCursorRow_mcsaldi_mcrdef.this.TIPOAG = l_row.TIPOAG;
      MemoryCursorRow_mcsaldi_mcrdef.this.TIPORAP = l_row.TIPORAP;
      MemoryCursorRow_mcsaldi_mcrdef.this.DESCRAP = l_row.DESCRAP;
      MemoryCursorRow_mcsaldi_mcrdef.this.VALUTA = l_row.VALUTA;
      MemoryCursorRow_mcsaldi_mcrdef.this.INVIATO = l_row.INVIATO;
      MemoryCursorRow_mcsaldi_mcrdef.this.TIPO = l_row.TIPO;
      MemoryCursorRow_mcsaldi_mcrdef.this.CAB = l_row.CAB;
      MemoryCursorRow_mcsaldi_mcrdef.this.UNIQUECODE = l_row.UNIQUECODE;
      MemoryCursorRow_mcsaldi_mcrdef.this.OLDINTER = l_row.OLDINTER;
      MemoryCursorRow_mcsaldi_mcrdef.this.SALDO = l_row.SALDO;
      MemoryCursorRow_mcsaldi_mcrdef.this.QUANTITA = l_row.QUANTITA;
      MemoryCursorRow_mcsaldi_mcrdef.this.NATURA = l_row.NATURA;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcsaldi_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcsaldi_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcsaldi_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcsaldi_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcsaldi_mcrdef p_From,MemoryCursorRow_mcsaldi_mcrdef p_To) {
        p_To.RAPPORTO = copyAndCast(p_From.RAPPORTO);
        p_To.DATAINI = copyAndCast(p_From.DATAINI);
        p_To.DATAFINE = copyAndCast(p_From.DATAFINE);
        p_To.TIPOAG = copyAndCast(p_From.TIPOAG);
        p_To.TIPORAP = copyAndCast(p_From.TIPORAP);
        p_To.DESCRAP = copyAndCast(p_From.DESCRAP);
        p_To.VALUTA = copyAndCast(p_From.VALUTA);
        p_To.INVIATO = copyAndCast(p_From.INVIATO);
        p_To.TIPO = copyAndCast(p_From.TIPO);
        p_To.CAB = copyAndCast(p_From.CAB);
        p_To.UNIQUECODE = copyAndCast(p_From.UNIQUECODE);
        p_To.OLDINTER = copyAndCast(p_From.OLDINTER);
        p_To.SALDO = copyAndCast(p_From.SALDO);
        p_To.QUANTITA = copyAndCast(p_From.QUANTITA);
        p_To.NATURA = copyAndCast(p_From.NATURA);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DATAINI","DATAFINE","TIPOAG","TIPORAP","DESCRAP","VALUTA","INVIATO","TIPO","CAB","UNIQUECODE","OLDINTER","SALDO","QUANTITA","NATURA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","D","C","C","C","C","N","C","C","C","C","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Rapporto","Data Inizio","Data Fine","Tipo Agenzia Entrate","Tipo Rapporto","Descrizione Rapporto","Codice Valuta","Inviato","Tipo Registrazione","Codice CAB","Codice Univoco","Vecchio Intermediario","Saldo","Quantità","Natura"};
    return l_names;
  }
}
