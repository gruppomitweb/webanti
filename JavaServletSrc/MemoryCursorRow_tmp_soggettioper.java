public class MemoryCursorRow_tmp_soggettioper extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_soggettioper() {
  }
  public MemoryCursorRow_tmp_soggettioper(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_soggettioper toBuild = new MemoryCursor_tmp_soggettioper(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_soggettioper toBuild = new MemoryCursor_tmp_soggettioper();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String TIPOPERS = "";
  String NUMPROG = "";
  String TIPOINTER = "";
  String CODINTER = "";
  String TIPOINF = "";
  String IDEREG = "";
  String CONNES = "";
  String RAGSOC = "";
  String PAESE = "";
  String CODCAB = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String DOMICILIO = "";
  String CAP = "";
  String CODFISC = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String NASSTATO = "";
  String SOTGRUP = "";
  String RAMOGRUP = "";
  String SETTSINT = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String SESSO = "";
  String ATTIV = "";
  String RAPPORTO = "";
  String FLAGRAP = "";
  String PROVANAS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOPERS))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOINF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
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
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOTGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAMOGRUP))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETTSINT))) {
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
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVANAS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_soggettioper p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_soggettioper.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tmp_soggettioper.this.TIPOPERS = copyAndCast(p_row.TIPOPERS);
      MemoryCursorRow_tmp_soggettioper.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_tmp_soggettioper.this.TIPOINTER = copyAndCast(p_row.TIPOINTER);
      MemoryCursorRow_tmp_soggettioper.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_tmp_soggettioper.this.TIPOINF = copyAndCast(p_row.TIPOINF);
      MemoryCursorRow_tmp_soggettioper.this.IDEREG = copyAndCast(p_row.IDEREG);
      MemoryCursorRow_tmp_soggettioper.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_tmp_soggettioper.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_soggettioper.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_tmp_soggettioper.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_tmp_soggettioper.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_tmp_soggettioper.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_tmp_soggettioper.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_tmp_soggettioper.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_tmp_soggettioper.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_tmp_soggettioper.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_tmp_soggettioper.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_tmp_soggettioper.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_tmp_soggettioper.this.SOTGRUP = copyAndCast(p_row.SOTGRUP);
      MemoryCursorRow_tmp_soggettioper.this.RAMOGRUP = copyAndCast(p_row.RAMOGRUP);
      MemoryCursorRow_tmp_soggettioper.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_tmp_soggettioper.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_tmp_soggettioper.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_tmp_soggettioper.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_tmp_soggettioper.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_tmp_soggettioper.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_tmp_soggettioper.this.ATTIV = copyAndCast(p_row.ATTIV);
      MemoryCursorRow_tmp_soggettioper.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_tmp_soggettioper.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_tmp_soggettioper.this.PROVANAS = copyAndCast(p_row.PROVANAS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","TIPOPERS","NUMPROG","TIPOINTER","CODINTER","TIPOINF","IDEREG","CONNES","RAGSOC","PAESE","CODCAB","DESCCIT","PROVINCIA","DOMICILIO","CAP","CODFISC","DATANASC","NASCOMUN","NASSTATO","SOTGRUP","RAMOGRUP","SETTSINT","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","SESSO","ATTIV","RAPPORTO","FLAGRAP","PROVANAS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","D","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase","I=Intestatario - T=Terzo - C=Controparte","Numero Progressivo","Tipo Intermediaro","Codice Intermediario","Tipo Informazione","ID Registrazione","Codice Collegamento","Ragione Sociale","Stato","CAB","Città","Provincia","Indirizzo","CAP","Codice Fiscale","Data Nascita","Luogo di Nascita","Stato di nascita","Sottogruppo Att. Ec.","Ramo Gruppo Att. Ec.","Settorizzazione UIC","Tipo Documento","Numero Doc.","Data Rilascio Doc.","Autorità di rilascio","Sesso","","Rapporto","Tipo Rapporto","Provincia di Nascita"};
    return l_names;
  }
}
