public class MemoryCursorRow_mcrtraaua_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcrtraaua_mcrdef() {
  }
  public MemoryCursorRow_mcrtraaua_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcrtraaua_mcrdef toBuild = new MemoryCursor_mcrtraaua_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcrtraaua_mcrdef toBuild = new MemoryCursor_mcrtraaua_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String COGNOME = "";
  String NOME = "";
  String NASSTATO = "";
  String NASCOMUN = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String SESSO = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String CODFISC = "";
  String RAGSOC = "";
  String FLGCFVALIDO = "";
  String FLGCGFORMAT = "";
  String ERR01 = "";
  String ERR02 = "";
  String ERR03 = "";
  String ERR04 = "";
  String ERR05 = "";
  String ERR06 = "";
  String ERR07 = "";
  String ERR08 = "";
  String ERR09 = "";
  String ERR10 = "";
  String DOCTYPE = "";
  String LUOGONAS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
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
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGCFVALIDO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGCGFORMAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR01))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR02))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR03))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR04))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR05))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR06))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR07))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR08))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR09))) {
      return false;
    }
    if ( ! (CPLib.Empty(ERR10))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOCTYPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(LUOGONAS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcrtraaua_mcrdef p_row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_row = new MemoryCursorRow_mcrtraaua_mcrdef();
    CopyOperation<MemoryCursorRow_mcrtraaua_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcrtraaua_mcrdef.this.CONNES = l_row.CONNES;
      MemoryCursorRow_mcrtraaua_mcrdef.this.COGNOME = l_row.COGNOME;
      MemoryCursorRow_mcrtraaua_mcrdef.this.NOME = l_row.NOME;
      MemoryCursorRow_mcrtraaua_mcrdef.this.NASSTATO = l_row.NASSTATO;
      MemoryCursorRow_mcrtraaua_mcrdef.this.NASCOMUN = l_row.NASCOMUN;
      MemoryCursorRow_mcrtraaua_mcrdef.this.DATANASC = l_row.DATANASC;
      MemoryCursorRow_mcrtraaua_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcrtraaua_mcrdef.this.TIPODOC = l_row.TIPODOC;
      MemoryCursorRow_mcrtraaua_mcrdef.this.NUMDOCUM = l_row.NUMDOCUM;
      MemoryCursorRow_mcrtraaua_mcrdef.this.DATARILASC = l_row.DATARILASC;
      MemoryCursorRow_mcrtraaua_mcrdef.this.CODFISC = l_row.CODFISC;
      MemoryCursorRow_mcrtraaua_mcrdef.this.RAGSOC = l_row.RAGSOC;
      MemoryCursorRow_mcrtraaua_mcrdef.this.FLGCFVALIDO = l_row.FLGCFVALIDO;
      MemoryCursorRow_mcrtraaua_mcrdef.this.FLGCGFORMAT = l_row.FLGCGFORMAT;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR01 = l_row.ERR01;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR02 = l_row.ERR02;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR03 = l_row.ERR03;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR04 = l_row.ERR04;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR05 = l_row.ERR05;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR06 = l_row.ERR06;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR07 = l_row.ERR07;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR08 = l_row.ERR08;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR09 = l_row.ERR09;
      MemoryCursorRow_mcrtraaua_mcrdef.this.ERR10 = l_row.ERR10;
      MemoryCursorRow_mcrtraaua_mcrdef.this.DOCTYPE = l_row.DOCTYPE;
      MemoryCursorRow_mcrtraaua_mcrdef.this.LUOGONAS = l_row.LUOGONAS;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcrtraaua_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcrtraaua_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcrtraaua_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcrtraaua_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcrtraaua_mcrdef p_From,MemoryCursorRow_mcrtraaua_mcrdef p_To) {
        p_To.CONNES = copyAndCast(p_From.CONNES);
        p_To.COGNOME = copyAndCast(p_From.COGNOME);
        p_To.NOME = copyAndCast(p_From.NOME);
        p_To.NASSTATO = copyAndCast(p_From.NASSTATO);
        p_To.NASCOMUN = copyAndCast(p_From.NASCOMUN);
        p_To.DATANASC = copyAndCast(p_From.DATANASC);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.TIPODOC = copyAndCast(p_From.TIPODOC);
        p_To.NUMDOCUM = copyAndCast(p_From.NUMDOCUM);
        p_To.DATARILASC = copyAndCast(p_From.DATARILASC);
        p_To.CODFISC = copyAndCast(p_From.CODFISC);
        p_To.RAGSOC = copyAndCast(p_From.RAGSOC);
        p_To.FLGCFVALIDO = copyAndCast(p_From.FLGCFVALIDO);
        p_To.FLGCGFORMAT = copyAndCast(p_From.FLGCGFORMAT);
        p_To.ERR01 = copyAndCast(p_From.ERR01);
        p_To.ERR02 = copyAndCast(p_From.ERR02);
        p_To.ERR03 = copyAndCast(p_From.ERR03);
        p_To.ERR04 = copyAndCast(p_From.ERR04);
        p_To.ERR05 = copyAndCast(p_From.ERR05);
        p_To.ERR06 = copyAndCast(p_From.ERR06);
        p_To.ERR07 = copyAndCast(p_From.ERR07);
        p_To.ERR08 = copyAndCast(p_From.ERR08);
        p_To.ERR09 = copyAndCast(p_From.ERR09);
        p_To.ERR10 = copyAndCast(p_From.ERR10);
        p_To.DOCTYPE = copyAndCast(p_From.DOCTYPE);
        p_To.LUOGONAS = copyAndCast(p_From.LUOGONAS);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","COGNOME","NOME","NASSTATO","NASCOMUN","DATANASC","SESSO","TIPODOC","NUMDOCUM","DATARILASC","CODFISC","RAGSOC","FLGCFVALIDO","FLGCGFORMAT","ERR01","ERR02","ERR03","ERR04","ERR05","ERR06","ERR07","ERR08","ERR09","ERR10","DOCTYPE","LUOGONAS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","C","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"NDG","Cognome","Nome","Stato di Nascita","Città di Nascita","Data di Nascita","Sesso","Tipo Documento","Numero Documento","Data Rilascio Documento","Codice Fiscale","Nominativo","Codice Fiscale Valido AGE","Codice Fiscale Formalmente Valido","","","","","","","","","","","Codice Documento (AUI)","Luogo Nascita\n"};
    return l_names;
  }
}
