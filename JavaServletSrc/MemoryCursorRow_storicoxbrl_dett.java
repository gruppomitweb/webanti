public class MemoryCursorRow_storicoxbrl_dett extends CPMemoryCursorRow {
  public MemoryCursorRow_storicoxbrl_dett() {
  }
  public MemoryCursorRow_storicoxbrl_dett(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_storicoxbrl_dett toBuild = new MemoryCursor_storicoxbrl_dett(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_storicoxbrl_dett toBuild = new MemoryCursor_storicoxbrl_dett();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ANNORIF = "";
  String MESERIF = "";
  String PROGRIF = "";
  String TIPOPE = "";
  String NUMPROG = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String CODVOC = "";
  String FLAGLIRE = "";
  String SEGNO = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  String CODINTDIP = "";
  String ABICABDIP = "";
  String CODCABDIP = "";
  String RAPPORTO = "";
  String CONNESCLI = "";
  String PERPAESE = "";
  String PERCAB = "";
  String SETTSINT = "";
  String CONNESBEN = "";
  String PAESECP = "";
  String CODCABCP = "";
  String INTCONTRO = "";
  String PAESEICP = "";
  String CABICP = "";
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
    if ( ! (CPLib.Empty(TIPOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
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
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
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
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PERCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESBEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESECP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCABCP))) {
      return false;
    }
    if ( ! (CPLib.Empty(INTCONTRO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESEICP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABICP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_storicoxbrl_dett p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_storicoxbrl_dett.this.ANNORIF = copyAndCast(p_row.ANNORIF);
      MemoryCursorRow_storicoxbrl_dett.this.MESERIF = copyAndCast(p_row.MESERIF);
      MemoryCursorRow_storicoxbrl_dett.this.PROGRIF = copyAndCast(p_row.PROGRIF);
      MemoryCursorRow_storicoxbrl_dett.this.TIPOPE = copyAndCast(p_row.TIPOPE);
      MemoryCursorRow_storicoxbrl_dett.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_storicoxbrl_dett.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_storicoxbrl_dett.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_storicoxbrl_dett.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_storicoxbrl_dett.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_storicoxbrl_dett.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_storicoxbrl_dett.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_storicoxbrl_dett.this.CODINTDIP = copyAndCast(p_row.CODINTDIP);
      MemoryCursorRow_storicoxbrl_dett.this.ABICABDIP = copyAndCast(p_row.ABICABDIP);
      MemoryCursorRow_storicoxbrl_dett.this.CODCABDIP = copyAndCast(p_row.CODCABDIP);
      MemoryCursorRow_storicoxbrl_dett.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_storicoxbrl_dett.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_storicoxbrl_dett.this.PERPAESE = copyAndCast(p_row.PERPAESE);
      MemoryCursorRow_storicoxbrl_dett.this.PERCAB = copyAndCast(p_row.PERCAB);
      MemoryCursorRow_storicoxbrl_dett.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_storicoxbrl_dett.this.CONNESBEN = copyAndCast(p_row.CONNESBEN);
      MemoryCursorRow_storicoxbrl_dett.this.PAESECP = copyAndCast(p_row.PAESECP);
      MemoryCursorRow_storicoxbrl_dett.this.CODCABCP = copyAndCast(p_row.CODCABCP);
      MemoryCursorRow_storicoxbrl_dett.this.INTCONTRO = copyAndCast(p_row.INTCONTRO);
      MemoryCursorRow_storicoxbrl_dett.this.PAESEICP = copyAndCast(p_row.PAESEICP);
      MemoryCursorRow_storicoxbrl_dett.this.CABICP = copyAndCast(p_row.CABICP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ANNORIF","MESERIF","PROGRIF","TIPOPE","NUMPROG","DATAOPE","CODVOC","FLAGLIRE","SEGNO","TOTLIRE","TOTCONT","CODINTDIP","ABICABDIP","CODCABDIP","RAPPORTO","CONNESCLI","PERPAESE","PERCAB","SETTSINT","CONNESBEN","PAESECP","CODCABCP","INTCONTRO","PAESEICP","CABICP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","C","C","N","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Anno di Riferimento","Mese di Riferimento","Progressivo di riferimento","Operazione-Frazionata-Quotata","Progressivo Operazione","Data operazione","Causale Aggregata","Valuta","Segno (Dare - Avere)","Totale Generale","Totale Contanti","Codice Dipendenza","ABI CAB della DIPENDENZA","CAB DIPENDENZA","","Cliente","Paese Residenza Cliente","CAB Comune Residenza Cliente","Settorizzazione Sintetica","Controparte","PAESE Controparte","CAB Comune Controparte","Intermediario Controparte","Paese Intermediario Controparte","CAB Comune Intermediario Controparte"};
    return l_names;
  }
}
