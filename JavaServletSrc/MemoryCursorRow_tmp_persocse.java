public class MemoryCursorRow_tmp_persocse extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_persocse() {
  }
  public MemoryCursorRow_tmp_persocse(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_persocse toBuild = new MemoryCursor_tmp_persocse(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_persocse toBuild = new MemoryCursor_tmp_persocse();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String RAGSOC = "";
  String DOMICILIO = "";
  String CODFISC = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String CAP = "";
  String PARTIVA = "";
  String SESSO = "";
  String NOME = "";
  String COGNOME = "";
  double CFESTERO = 0;
  String PKTBSPECIE = "";
  String OCSE = "";
  String TIN = "";
  double ODB = 0;
  String TIPINTER = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  String CODCAB = "";
  String CONNES = "";
  String ACCTHOLDERTYPE = "";
  String IMP_ANTI = "";
  String NAMETYPE = "";
  String RESFISC = "";
  String TINRESFISC = "";
  String ADDRESSFREE = "";
  String CTRLGPERSONTYPE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPODOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDOCUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTRILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PKTBSPECIE))) {
      return false;
    }
    if ( ! (CPLib.Empty(OCSE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(ODB))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(ACCTHOLDERTYPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMP_ANTI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NAMETYPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(TINRESFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(ADDRESSFREE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CTRLGPERSONTYPE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_persocse p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_persocse.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_persocse.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_persocse.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_tmp_persocse.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_tmp_persocse.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_tmp_persocse.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_tmp_persocse.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_tmp_persocse.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_tmp_persocse.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_tmp_persocse.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_tmp_persocse.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_tmp_persocse.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_tmp_persocse.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_tmp_persocse.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_tmp_persocse.this.PARTIVA = copyAndCast(p_row.PARTIVA);
      MemoryCursorRow_tmp_persocse.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_tmp_persocse.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_tmp_persocse.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_tmp_persocse.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_tmp_persocse.this.PKTBSPECIE = copyAndCast(p_row.PKTBSPECIE);
      MemoryCursorRow_tmp_persocse.this.OCSE = copyAndCast(p_row.OCSE);
      MemoryCursorRow_tmp_persocse.this.TIN = copyAndCast(p_row.TIN);
      MemoryCursorRow_tmp_persocse.this.ODB = copyAndCast(p_row.ODB);
      MemoryCursorRow_tmp_persocse.this.TIPINTER = copyAndCast(p_row.TIPINTER);
      MemoryCursorRow_tmp_persocse.this.DATAVALI = copyAndCast(p_row.DATAVALI);
      MemoryCursorRow_tmp_persocse.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_tmp_persocse.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_tmp_persocse.this.ACCTHOLDERTYPE = copyAndCast(p_row.ACCTHOLDERTYPE);
      MemoryCursorRow_tmp_persocse.this.IMP_ANTI = copyAndCast(p_row.IMP_ANTI);
      MemoryCursorRow_tmp_persocse.this.NAMETYPE = copyAndCast(p_row.NAMETYPE);
      MemoryCursorRow_tmp_persocse.this.RESFISC = copyAndCast(p_row.RESFISC);
      MemoryCursorRow_tmp_persocse.this.TINRESFISC = copyAndCast(p_row.TINRESFISC);
      MemoryCursorRow_tmp_persocse.this.ADDRESSFREE = copyAndCast(p_row.ADDRESSFREE);
      MemoryCursorRow_tmp_persocse.this.CTRLGPERSONTYPE = copyAndCast(p_row.CTRLGPERSONTYPE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","RAGSOC","DOMICILIO","CODFISC","DATANASC","NASCOMUN","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","DESCCIT","PROVINCIA","PAESE","CAP","PARTIVA","SESSO","NOME","COGNOME","CFESTERO","PKTBSPECIE","OCSE","TIN","ODB","TIPINTER","DATAVALI","CODCAB","CONNES","ACCTHOLDERTYPE","IMP_ANTI","NAMETYPE","RESFISC","TINRESFISC","ADDRESSFREE","CTRLGPERSONTYPE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","D","C","C","C","D","C","C","C","C","C","C","C","C","C","N","C","C","C","N","C","D","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","Ragione Sociale","Indirizzo","Codice Fiscale","Data Nascita","Luogo di Nascita","Tipo Documento","Numero Doc.","Data Rilascio Doc.","Autorità di rilascio","Città","Provincia","Stato","CAP","Partita IVA","Sesso","Nome","Cognome","Codice Fiscale Estero","","","Codice FATCA","Ordine di Bonifico Permanente","Provincia di Nascita","Data Scadenza Documento","","Codice Collegamento","","","","","","",""};
    return l_names;
  }
}
