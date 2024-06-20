public class MemoryCursorRow_spmc_mobappstore_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_spmc_mobappstore_mcrdef() {
  }
  public MemoryCursorRow_spmc_mobappstore_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_spmc_mobappstore_mcrdef toBuild = new MemoryCursor_spmc_mobappstore_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_spmc_mobappstore_mcrdef toBuild = new MemoryCursor_spmc_mobappstore_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String oa__code = "";
  String oaapptitle = "";
  String oaapplogo = "";
  String oaappmenu = "";
  String oareserved = "";
  String oaappchecksum = "";
  double oatoadmin = 0;
  double oaapptype = 0;
  double oaapppublished = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(oa__code))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaapptitle))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaapplogo))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaappmenu))) {
      return false;
    }
    if ( ! (CPLib.Empty(oareserved))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaappchecksum))) {
      return false;
    }
    if ( ! (CPLib.Empty(oatoadmin))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaapptype))) {
      return false;
    }
    if ( ! (CPLib.Empty(oaapppublished))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_spmc_mobappstore_mcrdef p_row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
    CopyOperation<MemoryCursorRow_spmc_mobappstore_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oa__code = l_row.oa__code;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oaapptitle = l_row.oaapptitle;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oaapplogo = l_row.oaapplogo;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oaappmenu = l_row.oaappmenu;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oareserved = l_row.oareserved;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oaappchecksum = l_row.oaappchecksum;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oatoadmin = l_row.oatoadmin;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oaapptype = l_row.oaapptype;
      MemoryCursorRow_spmc_mobappstore_mcrdef.this.oaapppublished = l_row.oaapppublished;
    }
  }
  protected CopyOperation<MemoryCursorRow_spmc_mobappstore_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_spmc_mobappstore_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_spmc_mobappstore_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_spmc_mobappstore_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_spmc_mobappstore_mcrdef p_From,MemoryCursorRow_spmc_mobappstore_mcrdef p_To) {
        p_To.oa__code = copyAndCast(p_From.oa__code);
        p_To.oaapptitle = copyAndCast(p_From.oaapptitle);
        p_To.oaapplogo = copyAndCast(p_From.oaapplogo);
        p_To.oaappmenu = copyAndCast(p_From.oaappmenu);
        p_To.oareserved = copyAndCast(p_From.oareserved);
        p_To.oaappchecksum = copyAndCast(p_From.oaappchecksum);
        p_To.oatoadmin = copyAndCast(p_From.oatoadmin);
        p_To.oaapptype = copyAndCast(p_From.oaapptype);
        p_To.oaapppublished = copyAndCast(p_From.oaapppublished);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"oa__code","oaapptitle","oaapplogo","oaappmenu","oareserved","oaappchecksum","oatoadmin","oaapptype","oaapppublished"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Titolo","Logo","Menu appl","Profilata","Checksum","To admin","Type app","Published"};
    return l_names;
  }
}
