public class MemoryCursorRow_mcfamiglia_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcfamiglia_mcrdef() {
  }
  public MemoryCursorRow_mcfamiglia_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcfamiglia_mcrdef toBuild = new MemoryCursor_mcfamiglia_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcfamiglia_mcrdef toBuild = new MemoryCursor_mcfamiglia_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOSOG = "";
  String CODINTER = "";
  String RAGSOC = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  String CODFISC = "";
  String COGNOME = "";
  String NOME = "";
  String LUONAS = "";
  java.sql.Date DATNAS = CPLib.NullDate();
  String SESSO = "";
  String PAESE = "";
  String SEDELEG = "";
  String PROVLEG = "";
  String PROVNAS = "";
  double CFESTERO = 0;
  String ORIGINE = "";
  String MATCH = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(LUONAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEDELEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ORIGINE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MATCH))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcfamiglia_mcrdef p_row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_row = new MemoryCursorRow_mcfamiglia_mcrdef();
    CopyOperation<MemoryCursorRow_mcfamiglia_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcfamiglia_mcrdef.this.TIPOSOG = l_row.TIPOSOG;
      MemoryCursorRow_mcfamiglia_mcrdef.this.CODINTER = l_row.CODINTER;
      MemoryCursorRow_mcfamiglia_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcfamiglia_mcrdef.this.DATAINI = l_row.DATAINI;
      MemoryCursorRow_mcfamiglia_mcrdef.this.DATAFINE = l_row.DATAFINE;
      MemoryCursorRow_mcfamiglia_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcfamiglia_mcrdef.this.COGNOME = l_row.COGNOME;
      MemoryCursorRow_mcfamiglia_mcrdef.this.NOME = l_row.NOME;
      MemoryCursorRow_mcfamiglia_mcrdef.this.LUONAS = l_row.LUONAS;
      MemoryCursorRow_mcfamiglia_mcrdef.this.DATNAS = l_row.DATNAS;
      MemoryCursorRow_mcfamiglia_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcfamiglia_mcrdef.this.PAESE = l_row.PAESE;
      MemoryCursorRow_mcfamiglia_mcrdef.this.SEDELEG = l_row.SEDELEG;
      MemoryCursorRow_mcfamiglia_mcrdef.this.PROVLEG = l_row.PROVLEG;
      MemoryCursorRow_mcfamiglia_mcrdef.this.PROVNAS = l_row.PROVNAS;
      MemoryCursorRow_mcfamiglia_mcrdef.this.CFESTERO = l_row.CFESTERO;
      MemoryCursorRow_mcfamiglia_mcrdef.this.ORIGINE = l_row.ORIGINE;
      MemoryCursorRow_mcfamiglia_mcrdef.this.MATCH = l_row.MATCH;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcfamiglia_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcfamiglia_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcfamiglia_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcfamiglia_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcfamiglia_mcrdef p_From,MemoryCursorRow_mcfamiglia_mcrdef p_To) {
        p_To.TIPOSOG = copyAndCast(p_From.TIPOSOG);
        p_To.CODINTER = copyAndCast(p_From.CODINTER);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.DATAINI = copyAndCast(p_From.DATAINI);
        p_To.DATAFINE = copyAndCast(p_From.DATAFINE);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.COGNOME = copyAndCast(p_From.COGNOME);
        p_To.NOME = copyAndCast(p_From.NOME);
        p_To.LUONAS = copyAndCast(p_From.LUONAS);
        p_To.DATNAS = copyAndCast(p_From.DATNAS);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.PAESE = copyAndCast(p_From.PAESE);
        p_To.SEDELEG = copyAndCast(p_From.SEDELEG);
        p_To.PROVLEG = copyAndCast(p_From.PROVLEG);
        p_To.PROVNAS = copyAndCast(p_From.PROVNAS);
        p_To.CFESTERO = copyAndCast(p_From.CFESTERO);
        p_To.ORIGINE = copyAndCast(p_From.ORIGINE);
        p_To.MATCH = copyAndCast(p_From.MATCH);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOSOG","CODINTER","RAGSOC","DATAINI","DATAFINE","CODFISC","COGNOME","NOME","LUONAS","DATNAS","SESSO","PAESE","SEDELEG","PROVLEG","PROVNAS","CFESTERO","ORIGINE","MATCH"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","D","C","C","C","C","D","C","C","C","C","C","N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Soggetto","Codice Soggetto","Nominativo","Data Inizio","Data Fine","Codice Fiscale","Cognome","Nome","Luogo DI Nascita","Data Di Nascita","Sesso","Paese Sede Legale","Luogo Sede Legale","Provincia Sede Legale","Provincia di nascita","Senza Codice Fiscale","Origine (U-A)","Matchato"};
    return l_names;
  }
}
