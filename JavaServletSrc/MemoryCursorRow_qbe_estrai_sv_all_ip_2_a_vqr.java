public class MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr() {
  }
  public MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr toBuild = new MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr toBuild = new MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String RAPPORTO = "";
  double TOTLIRE = 0;
  java.sql.Date DATAOPE = CPLib.NullDate();
  String SV58550 = "";
  String PAESE = "";
  String PROVINCIA = "";
  String SV58550MA = "";
  String VALUTA = "";
  String FONTE = "";
  String NUMPROG = "";
  String SEGNO = "";
  String SV58724 = "";
  String SV58726SCA = "";
  String SV58726SA = "";
  String SV58726PISP = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58550))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58550MA))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(FONTE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58724))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58726SCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58726SA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SV58726PISP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SV58550 = copyAndCast(p_row.SV58550);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SV58550MA = copyAndCast(p_row.SV58550MA);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.FONTE = copyAndCast(p_row.FONTE);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SV58724 = copyAndCast(p_row.SV58724);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SV58726SCA = copyAndCast(p_row.SV58726SCA);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SV58726SA = copyAndCast(p_row.SV58726SA);
      MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr.this.SV58726PISP = copyAndCast(p_row.SV58726PISP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","RAPPORTO","TOTLIRE","DATAOPE","SV58550","PAESE","PROVINCIA","SV58550MA","VALUTA","FONTE","NUMPROG","SEGNO","SV58724","SV58726SCA","SV58726SA","SV58726PISP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","N","D","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase","Rapporto Collegato","Totale Operazione","Data Operazione","Stato Beneficiario","Stato Intermediario C/Parte","Provincia Dipendenza","Modalità di avvio bonifico (SV)","Divisa","Fonte","Numero Progressivo","Segno","Modalità BONIFICI EFFETTUATI SULLA BASE DI DISPOSIZIONI SINGOLE","Autorizzazione Forte (S/N)","Schema di addebito","Modalità PISP"};
    return l_names;
  }
}
