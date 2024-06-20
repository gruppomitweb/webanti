public class MemoryCursorRow_storicoxbrl extends CPMemoryCursorRow {
  public MemoryCursorRow_storicoxbrl() {
  }
  public MemoryCursorRow_storicoxbrl(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_storicoxbrl toBuild = new MemoryCursor_storicoxbrl(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_storicoxbrl toBuild = new MemoryCursor_storicoxbrl();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ANNORIF = "";
  String MESERIF = "";
  String PROGRIF = "";
  String CODINTDIP = "";
  String ABICABDIP = "";
  String CODCABDIP = "";
  String PERPAESE = "";
  String PERCAB = "";
  String CODVOC = "";
  String FLAGLIRE = "";
  String SEGNO = "";
  String SETTSINT = "";
  String PAESECP = "";
  String CODCABCP = "";
  String PAESEICP = "";
  String CABICP = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  double OPERAZIONI = 0;
  double CONTANTI = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ANNORIF))) {
      return false;
    }
    if ( ! (CPLib.Empty(MESERIF))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROGRIF))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(ABICABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODVOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESECP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABCP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESEICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZIONI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONTANTI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_storicoxbrl p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_storicoxbrl.this.ANNORIF = copyAndCast(p_row.ANNORIF);
      MemoryCursorRow_storicoxbrl.this.MESERIF = copyAndCast(p_row.MESERIF);
      MemoryCursorRow_storicoxbrl.this.PROGRIF = copyAndCast(p_row.PROGRIF);
      MemoryCursorRow_storicoxbrl.this.CODINTDIP = copyAndCast(p_row.CODINTDIP);
      MemoryCursorRow_storicoxbrl.this.ABICABDIP = copyAndCast(p_row.ABICABDIP);
      MemoryCursorRow_storicoxbrl.this.CODCABDIP = copyAndCast(p_row.CODCABDIP);
      MemoryCursorRow_storicoxbrl.this.PERPAESE = copyAndCast(p_row.PERPAESE);
      MemoryCursorRow_storicoxbrl.this.PERCAB = copyAndCast(p_row.PERCAB);
      MemoryCursorRow_storicoxbrl.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_storicoxbrl.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_storicoxbrl.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_storicoxbrl.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_storicoxbrl.this.PAESECP = copyAndCast(p_row.PAESECP);
      MemoryCursorRow_storicoxbrl.this.CODCABCP = copyAndCast(p_row.CODCABCP);
      MemoryCursorRow_storicoxbrl.this.PAESEICP = copyAndCast(p_row.PAESEICP);
      MemoryCursorRow_storicoxbrl.this.CABICP = copyAndCast(p_row.CABICP);
      MemoryCursorRow_storicoxbrl.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_storicoxbrl.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_storicoxbrl.this.OPERAZIONI = copyAndCast(p_row.OPERAZIONI);
      MemoryCursorRow_storicoxbrl.this.CONTANTI = copyAndCast(p_row.CONTANTI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ANNORIF","MESERIF","PROGRIF","CODINTDIP","ABICABDIP","CODCABDIP","PERPAESE","PERCAB","CODVOC","FLAGLIRE","SEGNO","SETTSINT","PAESECP","CODCABCP","PAESEICP","CABICP","TOTLIRE","TOTCONT","OPERAZIONI","CONTANTI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Anno di Riferimento","Mese di Riferimento","Progressivo di riferimento","Codice Dipendenza","ABI CAB della DIPENDENZA","CAB DIPENDENZA","Paese Residenza Cliente","CAB Comune Residenza Cliente","Causale Aggregata","Valuta","Segno (Dare - Avere)","Settorizzazione Sintetica","PAESE Controparte","CAB Comune Controparte","Paese Intermediario Controparte","CAB Comune Intermediario Controparte","Totale Generale","Totale Contanti","Operazioni Totali","Operazioni in contanti"};
    return l_names;
  }
}
