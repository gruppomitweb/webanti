public class MemoryCursorRow_mcsoggetti_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcsoggetti_mcrdef() {
  }
  public MemoryCursorRow_mcsoggetti_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcsoggetti_mcrdef toBuild = new MemoryCursor_mcsoggetti_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcsoggetti_mcrdef toBuild = new MemoryCursor_mcsoggetti_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
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
  String TIPINTER = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  public boolean IsEmpty() {
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
    if ( ! (CPLib.Empty(TIPINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcsoggetti_mcrdef p_row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_row = new MemoryCursorRow_mcsoggetti_mcrdef();
    CopyOperation<MemoryCursorRow_mcsoggetti_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcsoggetti_mcrdef.this.CONNES = l_row.CONNES;
      MemoryCursorRow_mcsoggetti_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcsoggetti_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcsoggetti_mcrdef.this.CODCAB = l_row.CODCAB;
      MemoryCursorRow_mcsoggetti_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcsoggetti_mcrdef.this.PROVINCIA = l_row.PROVINCIA;
      MemoryCursorRow_mcsoggetti_mcrdef.this.DOMICILIO = l_row.DOMICILIO;
      MemoryCursorRow_mcsoggetti_mcrdef.this.CAP = l_row.CAP;
      MemoryCursorRow_mcsoggetti_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcsoggetti_mcrdef.this.DATANASC = l_row.DATANASC;
      MemoryCursorRow_mcsoggetti_mcrdef.this.NASCOMUN = l_row.NASCOMUN;
      MemoryCursorRow_mcsoggetti_mcrdef.this.NASSTATO = l_row.NASSTATO;
      MemoryCursorRow_mcsoggetti_mcrdef.this.SOTGRUP = l_row.SOTGRUP;
      MemoryCursorRow_mcsoggetti_mcrdef.this.RAMOGRUP = l_row.RAMOGRUP;
      MemoryCursorRow_mcsoggetti_mcrdef.this.SETTSINT = l_row.SETTSINT;
      MemoryCursorRow_mcsoggetti_mcrdef.this.TIPODOC = l_row.TIPODOC;
      MemoryCursorRow_mcsoggetti_mcrdef.this.NUMDOCUM = l_row.NUMDOCUM;
      MemoryCursorRow_mcsoggetti_mcrdef.this.DATARILASC = l_row.DATARILASC;
      MemoryCursorRow_mcsoggetti_mcrdef.this.AUTRILASC = l_row.AUTRILASC;
      MemoryCursorRow_mcsoggetti_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcsoggetti_mcrdef.this.ATTIV = l_row.ATTIV;
      MemoryCursorRow_mcsoggetti_mcrdef.this.TIPINTER = l_row.TIPINTER;
      MemoryCursorRow_mcsoggetti_mcrdef.this.DATAVALI = l_row.DATAVALI;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcsoggetti_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcsoggetti_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcsoggetti_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcsoggetti_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcsoggetti_mcrdef p_From,MemoryCursorRow_mcsoggetti_mcrdef p_To) {
        p_To.CONNES = copyAndCast(p_From.CONNES);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.CODCAB = copyAndCast(p_From.CODCAB);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.PROVINCIA = copyAndCast(p_From.PROVINCIA);
        p_To.DOMICILIO = copyAndCast(p_From.DOMICILIO);
        p_To.CAP = copyAndCast(p_From.CAP);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.DATANASC = copyAndCast(p_From.DATANASC);
        p_To.NASCOMUN = copyAndCast(p_From.NASCOMUN);
        p_To.NASSTATO = copyAndCast(p_From.NASSTATO);
        p_To.SOTGRUP = copyAndCast(p_From.SOTGRUP);
        p_To.RAMOGRUP = copyAndCast(p_From.RAMOGRUP);
        p_To.SETTSINT = copyAndCast(p_From.SETTSINT);
        p_To.TIPODOC = copyAndCast(p_From.TIPODOC);
        p_To.NUMDOCUM = copyAndCast(p_From.NUMDOCUM);
        p_To.DATARILASC = copyAndCast(p_From.DATARILASC);
        p_To.AUTRILASC = copyAndCast(p_From.AUTRILASC);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.ATTIV = copyAndCast(p_From.ATTIV);
        p_To.TIPINTER = copyAndCast(p_From.TIPINTER);
        p_To.DATAVALI = copyAndCast(p_From.DATAVALI);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","RAGSOC","PAESE","CODCAB","DESCCIT","PROVINCIA","DOMICILIO","CAP","CODFISC","DATANASC","NASCOMUN","NASSTATO","SOTGRUP","RAMOGRUP","SETTSINT","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","SESSO","ATTIV","TIPINTER","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","D","C","C","C","C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"NDG","Nominativo","Paese Residenza","Codice CAB","Citta di Residenza","Provincia Residenza","Indirizzo Residenza","CAP Residenza","Codice Fiscale","Data di Nascita","Comune di nascita","Stato di Nascita","SAE","RAE","Settore Sintetico","Tipo Documento","Numero Documento","Data Rilascio","Autorita Rilascio","Sesso","ATECO","Provincia di Nascita","Data Fine Validità Documento"};
    return l_names;
  }
}
