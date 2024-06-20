public class MemoryCursorRow_mcxlsritmcf_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcxlsritmcf_mcrdef() {
  }
  public MemoryCursorRow_mcxlsritmcf_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcxlsritmcf_mcrdef toBuild = new MemoryCursor_mcxlsritmcf_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcxlsritmcf_mcrdef toBuild = new MemoryCursor_mcxlsritmcf_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NDG = "";
  String CODFSC = "";
  String COGNOME = "";
  String NOME = "";
  String SESSO = "";
  String DATNASC = "";
  String NASCOD = "";
  String NASNOM = "";
  String NASPRV = "";
  String CODRIT = "";
  String DESRIT = "";
  String CODFSCAGE = "";
  String COGNOMEAGE = "";
  String NOMEAGE = "";
  String SESSOAGE = "";
  String DATNASCAGE = "";
  String NASNOMAGE = "";
  String NASPRVAGE = "";
  String CODFSCAUI = "";
  String COGNOMEAUI = "";
  String NOMEAUI = "";
  String SESSOAUI = "";
  String DATNASCAUI = "";
  String NASNOMAUI = "";
  String NASPRVAUI = "";
  String TIPDOCAUI = "";
  String NUMDOCAUI = "";
  String AUTRILAUI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NDG))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFSC))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATNASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASNOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASPRV))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODRIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESRIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFSCAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOMEAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMEAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSOAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATNASCAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASNOMAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASPRVAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFSCAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOMEAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMEAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSOAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATNASCAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASNOMAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASPRVAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPDOCAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDOCAUI))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTRILAUI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcxlsritmcf_mcrdef p_row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
    CopyOperation<MemoryCursorRow_mcxlsritmcf_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NDG = l_row.NDG;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.CODFSC = l_row.CODFSC;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.COGNOME = l_row.COGNOME;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NOME = l_row.NOME;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.SESSO = l_row.SESSO;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.DATNASC = l_row.DATNASC;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASCOD = l_row.NASCOD;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASNOM = l_row.NASNOM;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASPRV = l_row.NASPRV;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.CODRIT = l_row.CODRIT;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.DESRIT = l_row.DESRIT;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.CODFSCAGE = l_row.CODFSCAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.COGNOMEAGE = l_row.COGNOMEAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NOMEAGE = l_row.NOMEAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.SESSOAGE = l_row.SESSOAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.DATNASCAGE = l_row.DATNASCAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASNOMAGE = l_row.NASNOMAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASPRVAGE = l_row.NASPRVAGE;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.CODFSCAUI = l_row.CODFSCAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.COGNOMEAUI = l_row.COGNOMEAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NOMEAUI = l_row.NOMEAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.SESSOAUI = l_row.SESSOAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.DATNASCAUI = l_row.DATNASCAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASNOMAUI = l_row.NASNOMAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NASPRVAUI = l_row.NASPRVAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.TIPDOCAUI = l_row.TIPDOCAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.NUMDOCAUI = l_row.NUMDOCAUI;
      MemoryCursorRow_mcxlsritmcf_mcrdef.this.AUTRILAUI = l_row.AUTRILAUI;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcxlsritmcf_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcxlsritmcf_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcxlsritmcf_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcxlsritmcf_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcxlsritmcf_mcrdef p_From,MemoryCursorRow_mcxlsritmcf_mcrdef p_To) {
        p_To.NDG = copyAndCast(p_From.NDG);
        p_To.CODFSC = copyAndCast(p_From.CODFSC);
        p_To.COGNOME = copyAndCast(p_From.COGNOME);
        p_To.NOME = copyAndCast(p_From.NOME);
        p_To.SESSO = copyAndCast(p_From.SESSO);
        p_To.DATNASC = copyAndCast(p_From.DATNASC);
        p_To.NASCOD = copyAndCast(p_From.NASCOD);
        p_To.NASNOM = copyAndCast(p_From.NASNOM);
        p_To.NASPRV = copyAndCast(p_From.NASPRV);
        p_To.CODRIT = copyAndCast(p_From.CODRIT);
        p_To.DESRIT = copyAndCast(p_From.DESRIT);
        p_To.CODFSCAGE = copyAndCast(p_From.CODFSCAGE);
        p_To.COGNOMEAGE = copyAndCast(p_From.COGNOMEAGE);
        p_To.NOMEAGE = copyAndCast(p_From.NOMEAGE);
        p_To.SESSOAGE = copyAndCast(p_From.SESSOAGE);
        p_To.DATNASCAGE = copyAndCast(p_From.DATNASCAGE);
        p_To.NASNOMAGE = copyAndCast(p_From.NASNOMAGE);
        p_To.NASPRVAGE = copyAndCast(p_From.NASPRVAGE);
        p_To.CODFSCAUI = copyAndCast(p_From.CODFSCAUI);
        p_To.COGNOMEAUI = copyAndCast(p_From.COGNOMEAUI);
        p_To.NOMEAUI = copyAndCast(p_From.NOMEAUI);
        p_To.SESSOAUI = copyAndCast(p_From.SESSOAUI);
        p_To.DATNASCAUI = copyAndCast(p_From.DATNASCAUI);
        p_To.NASNOMAUI = copyAndCast(p_From.NASNOMAUI);
        p_To.NASPRVAUI = copyAndCast(p_From.NASPRVAUI);
        p_To.TIPDOCAUI = copyAndCast(p_From.TIPDOCAUI);
        p_To.NUMDOCAUI = copyAndCast(p_From.NUMDOCAUI);
        p_To.AUTRILAUI = copyAndCast(p_From.AUTRILAUI);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NDG","CODFSC","COGNOME","NOME","SESSO","DATNASC","NASCOD","NASNOM","NASPRV","CODRIT","DESRIT","CODFSCAGE","COGNOMEAGE","NOMEAGE","SESSOAGE","DATNASCAGE","NASNOMAGE","NASPRVAGE","CODFSCAUI","COGNOMEAUI","NOMEAUI","SESSOAUI","DATNASCAUI","NASNOMAUI","NASPRVAUI","TIPDOCAUI","NUMDOCAUI","AUTRILAUI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"NDG Soggetto","Codice Fiscale Inviato","Cognome","Nome","Sesso","Data DI Nascita","Codice Luogo Nascita","Luogo Nascita","Provincia di nascita","Codice Ritorno","Descrizione Ritorno","Codice Fiscale Agenzia Entrate","Cognome Agenzia Entrate","Nome Agenzia Entrate","Sesso Agenzia Entrate","Data DI Nascita Agenzia Entrate","Luogo Nascita Agenzia Entrate","Provincia di nascita Agenzia Entrate","Codice Fiscale AUI","Cognome AUI","Nome AUI","Sesso AUI","Data DI Nascita AUI","Luogo Nascita AUI","Provincia di nascita AUI","Tipo Documento AUI","N. Documento AUI","Autorità Rilascio Documento AUI"};
    return l_names;
  }
}
