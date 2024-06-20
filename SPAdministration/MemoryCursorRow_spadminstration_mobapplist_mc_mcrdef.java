public class MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef() {
  }
  public MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_spadminstration_mobapplist_mc_mcrdef toBuild = new MemoryCursor_spadminstration_mobapplist_mc_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_spadminstration_mobapplist_mc_mcrdef toBuild = new MemoryCursor_spadminstration_mobapplist_mc_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String oa__code = "";
  String oaappmenu = "";
  String oaappchecksum = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(oa__code))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaappmenu))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaappchecksum))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef p_row) {
    MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef l_row = new MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef();
    CopyOperation<MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef.this.oa__code = l_row.oa__code;
      MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef.this.oaappmenu = l_row.oaappmenu;
      MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef.this.oaappchecksum = l_row.oaappchecksum;
    }
  }
  protected CopyOperation<MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef p_From,MemoryCursorRow_spadminstration_mobapplist_mc_mcrdef p_To) {
        p_To.oa__code = copyAndCast(p_From.oa__code);
        p_To.oaappmenu = copyAndCast(p_From.oaappmenu);
        p_To.oaappchecksum = copyAndCast(p_From.oaappchecksum);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"oa__code","oaappmenu","oaappchecksum"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Menu app\n\nPermetto i nulli per gli inserimenti\neffettuati manualmente\nIndice UNIQUE perche' e' permessa solo\nun'applicazione offline per modulo","Cheksum\n\nChecksum dell"+"'"+"oggetto serializzato:\nquando il valore di questo campo e"+"'"+" diverso\nrispetto al valore della proprieta"+"'"+" \"quid\"\ndel dizionario prodotto dal plan\nallora significa che questo record e"+"'"+"\nobsoleto rispetto al plan e\ndeve essere riallineato"};
    return l_names;
  }
}
