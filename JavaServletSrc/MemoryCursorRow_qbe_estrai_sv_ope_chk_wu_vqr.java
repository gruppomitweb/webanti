public class MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr() {
  }
  public MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr toBuild = new MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr toBuild = new MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPO = "";
  String NUMPROG = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String SEGNO = "";
  String CODDIPE = "";
  String DESCRIZ = "";
  String PROVINCIA1 = "";
  String TIPOSV = "";
  String CONNESCLI = "";
  String RAGSOC = "";
  String SOTGRUP = "";
  String PROVINCIA = "";
  String PAESE = "";
  double IMPOUT = 0;
  String CODFISC = "";
  String DESCCIT = "";
  String NASCOMUN = "";
  String NASSTATO = "";
  String TIPINTER = "";
  String CITAGE = "";
  String PAESERES = "";
  String MTCN = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRIZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA1))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOSV))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPOUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESERES))) {
      return false;
    }
    if ( ! (CPLib.Empty(MTCN))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.DESCRIZ = copyAndCast(p_row.DESCRIZ);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.PROVINCIA1 = copyAndCast(p_row.PROVINCIA1);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.TIPOSV = copyAndCast(p_row.TIPOSV);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.SOTGRUP = copyAndCast(p_row.SOTGRUP);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.IMPOUT = copyAndCast(p_row.IMPOUT);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.TIPINTER = copyAndCast(p_row.TIPINTER);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.CITAGE = copyAndCast(p_row.CITAGE);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.PAESERES = copyAndCast(p_row.PAESERES);
      MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr.this.MTCN = copyAndCast(p_row.MTCN);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPO","NUMPROG","DATAOPE","SEGNO","CODDIPE","DESCRIZ","PROVINCIA1","TIPOSV","CONNESCLI","RAGSOC","SOTGRUP","PROVINCIA","PAESE","IMPOUT","CODFISC","DESCCIT","NASCOMUN","NASSTATO","TIPINTER","CITAGE","PAESERES","MTCN"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","C","C","C","C","C","C","C","C","C","C","N","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"TIPO","Numero Progressivo","Data Operazione","Segno","Codice Dipendenza","Descrizione Dipendenza","Provincia","Canale Distributivo (SV)","Codice Cliente Occasionale","Ragione Sociale","Sottogruppo Att. Ec.","Provincia","Stato","Importo OUT","Codice Fiscale","Città","Luogo di Nascita","Stato di nascita","Provincia di Nascita","Città Dipendenza","Stato Cliente","Riferimento operazione WU"};
    return l_names;
  }
}
