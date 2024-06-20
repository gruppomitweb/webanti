public class MemoryCursorRow_mcscartimcf_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcscartimcf_mcrdef() {
  }
  public MemoryCursorRow_mcscartimcf_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcscartimcf_mcrdef toBuild = new MemoryCursor_mcscartimcf_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcscartimcf_mcrdef toBuild = new MemoryCursor_mcscartimcf_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ERCONNES = "";
  String ERRAGSOC = "";
  String ERCODFIS = "";
  String ERCODICE = "";
  String ERDESCRI = "";
  String ERTESTO = "";
  String ERAZIONE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ERCONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERRAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERCODFIS))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERCODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERTESTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERAZIONE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcscartimcf_mcrdef p_row) {
    MemoryCursorRow_mcscartimcf_mcrdef l_row = new MemoryCursorRow_mcscartimcf_mcrdef();
    CopyOperation<MemoryCursorRow_mcscartimcf_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERCONNES = l_row.ERCONNES;
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERRAGSOC = l_row.ERRAGSOC;
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERCODFIS = l_row.ERCODFIS;
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERCODICE = l_row.ERCODICE;
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERDESCRI = l_row.ERDESCRI;
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERTESTO = l_row.ERTESTO;
      MemoryCursorRow_mcscartimcf_mcrdef.this.ERAZIONE = l_row.ERAZIONE;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcscartimcf_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcscartimcf_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcscartimcf_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcscartimcf_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcscartimcf_mcrdef p_From,MemoryCursorRow_mcscartimcf_mcrdef p_To) {
        p_To.ERCONNES = copyAndCast(p_From.ERCONNES);
        p_To.ERRAGSOC = copyAndCast(p_From.ERRAGSOC);
        p_To.ERCODFIS = copyAndCast(p_From.ERCODFIS);
        p_To.ERCODICE = copyAndCast(p_From.ERCODICE);
        p_To.ERDESCRI = copyAndCast(p_From.ERDESCRI);
        p_To.ERTESTO = copyAndCast(p_From.ERTESTO);
        p_To.ERAZIONE = copyAndCast(p_From.ERAZIONE);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ERCONNES","ERRAGSOC","ERCODFIS","ERCODICE","ERDESCRI","ERTESTO","ERAZIONE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Soggetto","Nominativo","Codice Fiscale","Codice","Descrizione","Note","Azione / Esito"};
    return l_names;
  }
}
