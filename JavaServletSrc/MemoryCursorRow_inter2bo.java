public class MemoryCursorRow_inter2bo extends CPMemoryCursorRow {
  public MemoryCursorRow_inter2bo() {
  }
  public MemoryCursorRow_inter2bo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_inter2bo toBuild = new MemoryCursor_inter2bo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_inter2bo toBuild = new MemoryCursor_inter2bo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINTER = "";
  String RAGSOC = "";
  String CODCAB = "";
  String DOMICILIO = "";
  String CODFISC = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String SOTGRUP = "";
  String RAMOGRUP = "";
  String SETTSINT = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String CAP = "";
  String TIPINTER = "";
  String TIPOPERS = "";
  String CONNES = "";
  String CODDIPE = "";
  String PARTIVA = "";
  String SESSO = "";
  String SOSPMAF = "";
  String IDCITTA = "";
  String CONTO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
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
    if ( ! (CPLib.Empty(TIPINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOPERS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOSPMAF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDCITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONTO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_inter2bo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_inter2bo.this.CODINTER = copyAndCast(p_row.CODINTER);
      MemoryCursorRow_inter2bo.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_inter2bo.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_inter2bo.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_inter2bo.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_inter2bo.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_inter2bo.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_inter2bo.this.SOTGRUP = copyAndCast(p_row.SOTGRUP);
      MemoryCursorRow_inter2bo.this.RAMOGRUP = copyAndCast(p_row.RAMOGRUP);
      MemoryCursorRow_inter2bo.this.SETTSINT = copyAndCast(p_row.SETTSINT);
      MemoryCursorRow_inter2bo.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_inter2bo.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_inter2bo.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_inter2bo.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_inter2bo.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_inter2bo.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_inter2bo.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_inter2bo.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_inter2bo.this.TIPINTER = copyAndCast(p_row.TIPINTER);
      MemoryCursorRow_inter2bo.this.TIPOPERS = copyAndCast(p_row.TIPOPERS);
      MemoryCursorRow_inter2bo.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_inter2bo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_inter2bo.this.PARTIVA = copyAndCast(p_row.PARTIVA);
      MemoryCursorRow_inter2bo.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_inter2bo.this.SOSPMAF = copyAndCast(p_row.SOSPMAF);
      MemoryCursorRow_inter2bo.this.IDCITTA = copyAndCast(p_row.IDCITTA);
      MemoryCursorRow_inter2bo.this.CONTO = copyAndCast(p_row.CONTO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINTER","RAGSOC","CODCAB","DOMICILIO","CODFISC","DATANASC","NASCOMUN","SOTGRUP","RAMOGRUP","SETTSINT","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","DESCCIT","PROVINCIA","PAESE","CAP","TIPINTER","TIPOPERS","CONNES","CODDIPE","PARTIVA","SESSO","SOSPMAF","IDCITTA","CONTO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice ","Ragione Sociale","Cab","Indirizzo","Codice Fiscale","","","","","","","","","","Città","Provincia","Stato","Cap","Tipo Intermediario","","","Codice Dipendenza","Partita IVA","","","Codice Città","Conto Bancario"};
    return l_names;
  }
}
