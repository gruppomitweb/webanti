public class MemoryCursorRow_mcsoggettiall1_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcsoggettiall1_mcrdef() {
  }
  public MemoryCursorRow_mcsoggettiall1_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcsoggettiall1_mcrdef toBuild = new MemoryCursor_mcsoggettiall1_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcsoggettiall1_mcrdef toBuild = new MemoryCursor_mcsoggettiall1_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODTIPSOG = "";
  String NDG = "";
  String RAGSOC = "";
  String SESSO = "";
  String CODFISC = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMU = "";
  String DESCCIT = "";
  String CODCAB = "";
  String STATO = "";
  String SAE = "";
  String ATECO = "";
  String SETSINT = "";
  String NOSARA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODTIPSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(NDG))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMU))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(STATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SAE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATECO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOSARA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcsoggettiall1_mcrdef p_row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
    CopyOperation<MemoryCursorRow_mcsoggettiall1_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.CODTIPSOG = l_row.CODTIPSOG;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.NDG = l_row.NDG;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.DATANASC = l_row.DATANASC;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.NASCOMU = l_row.NASCOMU;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.DESCCIT = l_row.DESCCIT;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.CODCAB = l_row.CODCAB;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.STATO = l_row.STATO;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.SAE = l_row.SAE;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.ATECO = l_row.ATECO;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.SETSINT = l_row.SETSINT;
      MemoryCursorRow_mcsoggettiall1_mcrdef.this.NOSARA = l_row.NOSARA;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcsoggettiall1_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcsoggettiall1_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcsoggettiall1_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcsoggettiall1_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcsoggettiall1_mcrdef p_From,MemoryCursorRow_mcsoggettiall1_mcrdef p_To) {
        p_To.CODTIPSOG = copyAndCast(p_From.CODTIPSOG);
        p_To.NDG = copyAndCast(p_From.NDG);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.DATANASC = copyAndCast(p_From.DATANASC);
        p_To.NASCOMU = copyAndCast(p_From.NASCOMU);
        p_To.DESCCIT = copyAndCast(p_From.DESCCIT);
        p_To.CODCAB = copyAndCast(p_From.CODCAB);
        p_To.STATO = copyAndCast(p_From.STATO);
        p_To.SAE = copyAndCast(p_From.SAE);
        p_To.ATECO = copyAndCast(p_From.ATECO);
        p_To.SETSINT = copyAndCast(p_From.SETSINT);
        p_To.NOSARA = copyAndCast(p_From.NOSARA);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODTIPSOG","NDG","RAGSOC","SESSO","CODFISC","DATANASC","NASCOMU","DESCCIT","CODCAB","STATO","SAE","ATECO","SETSINT","NOSARA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Tipo Soggetto","NDG","Nome Cognome/Ragione Sociale","Sesso","Codice Fiscale","Data di Nascita","Comune/Paese di Nascita","Comune di Residenza","CAB Comune di Residenza","Stato di Residenza","SAE","ATECO","Settore Sintetico","Escludi da S.AR.A."};
    return l_names;
  }
}
