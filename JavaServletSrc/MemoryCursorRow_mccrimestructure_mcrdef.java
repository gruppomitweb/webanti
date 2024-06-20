public class MemoryCursorRow_mccrimestructure_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mccrimestructure_mcrdef() {
  }
  public MemoryCursorRow_mccrimestructure_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mccrimestructure_mcrdef toBuild = new MemoryCursor_mccrimestructure_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mccrimestructure_mcrdef toBuild = new MemoryCursor_mccrimestructure_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double annoDelibera = 0;
  double attinenza = 0;
  String chiaveArticolo = "";
  String cognomeNome = "";
  java.sql.Date dataNascita = CPLib.NullDate();
  String luogoNascita = "";
  java.sql.Date dataPubblicazione = CPLib.NullDate();
  String edizione = "";
  String fonte = "";
  String origine = "";
  double percentuale = 0;
  String oggetto = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(annoDelibera))) {
      return false;
    }
    if ( ! (CPLib.Empty(attinenza))) {
      return false;
    }
    if ( ! (CPLib.Empty(chiaveArticolo))) {
      return false;
    }
    if ( ! (CPLib.Empty(cognomeNome))) {
      return false;
    }
    if ( ! (CPLib.Empty(dataNascita))) {
      return false;
    }
    if ( ! (CPLib.Empty(luogoNascita))) {
      return false;
    }
    if ( ! (CPLib.Empty(dataPubblicazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(edizione))) {
      return false;
    }
    if ( ! (CPLib.Empty(fonte))) {
      return false;
    }
    if ( ! (CPLib.Empty(origine))) {
      return false;
    }
    if ( ! (CPLib.Empty(percentuale))) {
      return false;
    }
    if ( ! (CPLib.Empty(oggetto))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mccrimestructure_mcrdef p_row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_row = new MemoryCursorRow_mccrimestructure_mcrdef();
    CopyOperation<MemoryCursorRow_mccrimestructure_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mccrimestructure_mcrdef.this.annoDelibera = l_row.annoDelibera;
      MemoryCursorRow_mccrimestructure_mcrdef.this.attinenza = l_row.attinenza;
      MemoryCursorRow_mccrimestructure_mcrdef.this.chiaveArticolo = l_row.chiaveArticolo;
      MemoryCursorRow_mccrimestructure_mcrdef.this.cognomeNome = l_row.cognomeNome;
      MemoryCursorRow_mccrimestructure_mcrdef.this.dataNascita = l_row.dataNascita;
      MemoryCursorRow_mccrimestructure_mcrdef.this.luogoNascita = l_row.luogoNascita;
      MemoryCursorRow_mccrimestructure_mcrdef.this.dataPubblicazione = l_row.dataPubblicazione;
      MemoryCursorRow_mccrimestructure_mcrdef.this.edizione = l_row.edizione;
      MemoryCursorRow_mccrimestructure_mcrdef.this.fonte = l_row.fonte;
      MemoryCursorRow_mccrimestructure_mcrdef.this.origine = l_row.origine;
      MemoryCursorRow_mccrimestructure_mcrdef.this.percentuale = l_row.percentuale;
      MemoryCursorRow_mccrimestructure_mcrdef.this.oggetto = l_row.oggetto;
    }
  }
  protected CopyOperation<MemoryCursorRow_mccrimestructure_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mccrimestructure_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mccrimestructure_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mccrimestructure_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mccrimestructure_mcrdef p_From,MemoryCursorRow_mccrimestructure_mcrdef p_To) {
        p_To.annoDelibera = copyAndCast(p_From.annoDelibera);
        p_To.attinenza = copyAndCast(p_From.attinenza);
        p_To.chiaveArticolo = copyAndCast(p_From.chiaveArticolo);
        p_To.cognomeNome = copyAndCast(p_From.cognomeNome);
        p_To.dataNascita = copyAndCast(p_From.dataNascita);
        p_To.luogoNascita = copyAndCast(p_From.luogoNascita);
        p_To.dataPubblicazione = copyAndCast(p_From.dataPubblicazione);
        p_To.edizione = copyAndCast(p_From.edizione);
        p_To.fonte = copyAndCast(p_From.fonte);
        p_To.origine = copyAndCast(p_From.origine);
        p_To.percentuale = copyAndCast(p_From.percentuale);
        p_To.oggetto = copyAndCast(p_From.oggetto);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"annoDelibera","attinenza","chiaveArticolo","cognomeNome","dataNascita","luogoNascita","dataPubblicazione","edizione","fonte","origine","percentuale","oggetto"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","N","C","C","D","C","D","C","C","C","N","M"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Anno","Attinenza","Chiave Articolo","Nominativo","Data dio Nascita","Luogo di Nascita","Data Pubblicazione","Edizione","Fonte non codificata dalla quale la persona risulta","Reato non codificato per cui la persona è stata censita","Percentuale","Oggetto"};
    return l_names;
  }
}
