public class MemoryCursorRow_qbe_genera_opex_ope_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_genera_opex_ope_vqr() {
  }
  public MemoryCursorRow_qbe_genera_opex_ope_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_genera_opex_ope_vqr toBuild = new MemoryCursor_qbe_genera_opex_ope_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_genera_opex_ope_vqr toBuild = new MemoryCursor_qbe_genera_opex_ope_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNESCLI = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String IDFILE = "";
  String NUMPROG = "";
  String RIFIMP = "";
  String INFORM = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_genera_opex_ope_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_genera_opex_ope_vqr.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_qbe_genera_opex_ope_vqr.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_qbe_genera_opex_ope_vqr.this.IDFILE = copyAndCast(p_row.IDFILE);
      MemoryCursorRow_qbe_genera_opex_ope_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_genera_opex_ope_vqr.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_qbe_genera_opex_ope_vqr.this.INFORM = copyAndCast(p_row.INFORM);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNESCLI","DATAOPE","IDFILE","NUMPROG","RIFIMP","INFORM"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","D","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Cliente Occasionale","Data Operazione","Identificativo File","Numero Progressivo","Riferimento Import 1","Riferimento Import 2"};
    return l_names;
  }
}
