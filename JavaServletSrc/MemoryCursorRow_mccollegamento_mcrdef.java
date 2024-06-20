public class MemoryCursorRow_mccollegamento_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccollegamento_mcrdef() {
  }
  public MemoryCursorRow_mccollegamento_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccollegamento_mcrdef toBuild = new MemoryCursor_mccollegamento_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccollegamento_mcrdef toBuild = new MemoryCursor_mccollegamento_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CodiceIstituto = "";
  String DataElaborazione = "";
  String ProceduraOrigine = "";
  String NumeroElettronicoOperante = "";
  String SottoNumeroOperazione = "";
  String CodiceCliente = "";
  String RuoloCliente = "";
  String EsecutoreOperazione = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CodiceIstituto))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataElaborazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProceduraOrigine))) {
      return false;
    }
    if ( ! (CPLib.Empty(NumeroElettronicoOperante))) {
      return false;
    }
    if ( ! (CPLib.Empty(SottoNumeroOperazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceCliente))) {
      return false;
    }
    if ( ! (CPLib.Empty(RuoloCliente))) {
      return false;
    }
    if ( ! (CPLib.Empty(EsecutoreOperazione))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccollegamento_mcrdef p_row) {
    MemoryCursorRow_mccollegamento_mcrdef l_row = new MemoryCursorRow_mccollegamento_mcrdef();
    CopyOperation<MemoryCursorRow_mccollegamento_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccollegamento_mcrdef.this.CodiceIstituto = l_row.CodiceIstituto;
      MemoryCursorRow_mccollegamento_mcrdef.this.DataElaborazione = l_row.DataElaborazione;
      MemoryCursorRow_mccollegamento_mcrdef.this.ProceduraOrigine = l_row.ProceduraOrigine;
      MemoryCursorRow_mccollegamento_mcrdef.this.NumeroElettronicoOperante = l_row.NumeroElettronicoOperante;
      MemoryCursorRow_mccollegamento_mcrdef.this.SottoNumeroOperazione = l_row.SottoNumeroOperazione;
      MemoryCursorRow_mccollegamento_mcrdef.this.CodiceCliente = l_row.CodiceCliente;
      MemoryCursorRow_mccollegamento_mcrdef.this.RuoloCliente = l_row.RuoloCliente;
      MemoryCursorRow_mccollegamento_mcrdef.this.EsecutoreOperazione = l_row.EsecutoreOperazione;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccollegamento_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccollegamento_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccollegamento_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccollegamento_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccollegamento_mcrdef p_From,MemoryCursorRow_mccollegamento_mcrdef p_To) {
        p_To.CodiceIstituto = copyAndCast(p_From.CodiceIstituto);
        p_To.DataElaborazione = copyAndCast(p_From.DataElaborazione);
        p_To.ProceduraOrigine = copyAndCast(p_From.ProceduraOrigine);
        p_To.NumeroElettronicoOperante = copyAndCast(p_From.NumeroElettronicoOperante);
        p_To.SottoNumeroOperazione = copyAndCast(p_From.SottoNumeroOperazione);
        p_To.CodiceCliente = copyAndCast(p_From.CodiceCliente);
        p_To.RuoloCliente = copyAndCast(p_From.RuoloCliente);
        p_To.EsecutoreOperazione = copyAndCast(p_From.EsecutoreOperazione);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CodiceIstituto","DataElaborazione","ProceduraOrigine","NumeroElettronicoOperante","SottoNumeroOperazione","CodiceCliente","RuoloCliente","EsecutoreOperazione"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice istituto","Data Elaborazione (AAAAMMGG)","Procedura Originante","Numero Elettronico Operante","Sotto numero dell'operazione","Codice Cliente Collegato","Ruolo del cliente collegato","Esecutore Operazione"};
    return l_names;
  }
}
