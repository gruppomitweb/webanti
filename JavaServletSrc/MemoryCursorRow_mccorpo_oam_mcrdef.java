public class MemoryCursorRow_mccorpo_oam_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccorpo_oam_mcrdef() {
  }
  public MemoryCursorRow_mccorpo_oam_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccorpo_oam_mcrdef toBuild = new MemoryCursor_mccorpo_oam_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccorpo_oam_mcrdef toBuild = new MemoryCursor_mccorpo_oam_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String B01 = "";
  double B02 = 0;
  String B03 = "";
  String B04 = "";
  String B05 = "";
  String B06 = "";
  java.sql.Date B07 = CPLib.NullDate();
  String B08 = "";
  String B09 = "";
  String B10 = "";
  String B11 = "";
  String B12 = "";
  String B13 = "";
  java.sql.Date B14 = CPLib.NullDate();
  String B15 = "";
  String B16 = "";
  java.sql.Date B17 = CPLib.NullDate();
  String B18 = "";
  String B19 = "";
  String B20 = "";
  double B21 = 0;
  double B22 = 0;
  double B23 = 0;
  String B24 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(B01))) {
      return false;
    }
    if ( ! (CPLib.Empty(B02))) {
      return false;
    }
    if ( ! (CPLib.Empty(B03))) {
      return false;
    }
    if ( ! (CPLib.Empty(B04))) {
      return false;
    }
    if ( ! (CPLib.Empty(B05))) {
      return false;
    }
    if ( ! (CPLib.Empty(B06))) {
      return false;
    }
    if ( ! (CPLib.Empty(B07))) {
      return false;
    }
    if ( ! (CPLib.Empty(B08))) {
      return false;
    }
    if ( ! (CPLib.Empty(B09))) {
      return false;
    }
    if ( ! (CPLib.Empty(B10))) {
      return false;
    }
    if ( ! (CPLib.Empty(B11))) {
      return false;
    }
    if ( ! (CPLib.Empty(B12))) {
      return false;
    }
    if ( ! (CPLib.Empty(B13))) {
      return false;
    }
    if ( ! (CPLib.Empty(B14))) {
      return false;
    }
    if ( ! (CPLib.Empty(B15))) {
      return false;
    }
    if ( ! (CPLib.Empty(B16))) {
      return false;
    }
    if ( ! (CPLib.Empty(B17))) {
      return false;
    }
    if ( ! (CPLib.Empty(B18))) {
      return false;
    }
    if ( ! (CPLib.Empty(B19))) {
      return false;
    }
    if ( ! (CPLib.Empty(B20))) {
      return false;
    }
    if ( ! (CPLib.Empty(B21))) {
      return false;
    }
    if ( ! (CPLib.Empty(B22))) {
      return false;
    }
    if ( ! (CPLib.Empty(B23))) {
      return false;
    }
    if ( ! (CPLib.Empty(B24))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccorpo_oam_mcrdef p_row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_row = new MemoryCursorRow_mccorpo_oam_mcrdef();
    CopyOperation<MemoryCursorRow_mccorpo_oam_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B01 = l_row.B01;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B02 = l_row.B02;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B03 = l_row.B03;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B04 = l_row.B04;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B05 = l_row.B05;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B06 = l_row.B06;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B07 = l_row.B07;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B08 = l_row.B08;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B09 = l_row.B09;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B10 = l_row.B10;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B11 = l_row.B11;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B12 = l_row.B12;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B13 = l_row.B13;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B14 = l_row.B14;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B15 = l_row.B15;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B16 = l_row.B16;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B17 = l_row.B17;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B18 = l_row.B18;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B19 = l_row.B19;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B20 = l_row.B20;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B21 = l_row.B21;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B22 = l_row.B22;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B23 = l_row.B23;
      MemoryCursorRow_mccorpo_oam_mcrdef.this.B24 = l_row.B24;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccorpo_oam_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccorpo_oam_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccorpo_oam_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccorpo_oam_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccorpo_oam_mcrdef p_From,MemoryCursorRow_mccorpo_oam_mcrdef p_To) {
        p_To.B01 = copyAndCast(p_From.B01);
        p_To.B02 = copyAndCast(p_From.B02);
        p_To.B03 = copyAndCast(p_From.B03);
        p_To.B04 = copyAndCast(p_From.B04);
        p_To.B05 = copyAndCast(p_From.B05);
        p_To.B06 = copyAndCast(p_From.B06);
        p_To.B07 = copyAndCast(p_From.B07);
        p_To.B08 = copyAndCast(p_From.B08);
        p_To.B09 = copyAndCast(p_From.B09);
        p_To.B10 = copyAndCast(p_From.B10);
        p_To.B11 = copyAndCast(p_From.B11);
        p_To.B12 = copyAndCast(p_From.B12);
        p_To.B13 = copyAndCast(p_From.B13);
        p_To.B14 = copyAndCast(p_From.B14);
        p_To.B15 = copyAndCast(p_From.B15);
        p_To.B16 = copyAndCast(p_From.B16);
        p_To.B17 = copyAndCast(p_From.B17);
        p_To.B18 = copyAndCast(p_From.B18);
        p_To.B19 = copyAndCast(p_From.B19);
        p_To.B20 = copyAndCast(p_From.B20);
        p_To.B21 = copyAndCast(p_From.B21);
        p_To.B22 = copyAndCast(p_From.B22);
        p_To.B23 = copyAndCast(p_From.B23);
        p_To.B24 = copyAndCast(p_From.B24);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"B01","B02","B03","B04","B05","B06","B07","B08","B09","B10","B11","B12","B13","B14","B15","B16","B17","B18","B19","B20","B21","B22","B23","B24"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","C","C","C","D","C","C","C","C","C","C","D","C","C","D","C","C","C","N","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Record","Progressivo","Cognome","Nome","Sesso","Codice Fiscale","Data di Nascita","Luogo di nascita","Provincia di Nascita","Paese Residenza","Sigla Paese Residenza","Tipo Documento","Numero Documento","Data Scadenza del documento","Autorità Rilascio Documento","Luogo Rilascio Documento","Data Operazione","Luogo Operazione","Tipo Operazione","Divisa Estera","Tasso di cambio","Importo IN","Importo OUT","ID Transazione"};
    return l_names;
  }
}
