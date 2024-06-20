public class MemoryCursorRow_tbmacage extends CPMemoryCursorRow {
  public MemoryCursorRow_tbmacage() {
  }
  public MemoryCursorRow_tbmacage(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbmacage toBuild = new MemoryCursor_tbmacage(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbmacage toBuild = new MemoryCursor_tbmacage();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String MACODICE = "";
  String MADESCRI = "";
  String MAFLGRAP = "";
  String MAFLGOPE = "";
  String MAFLGBON = "";
  String MAFLGCKR = "";
  String MAFLGASR = "";
  String MAFLGNOX = "";
  String MADIPSTD = "";
  String MANAIDWU = "";
  String MAFLGCHKDAT = "";
  String MAFLGACT = "";
  String MARESSDEF = "";
  String MAFLGAUA = "";
  java.sql.Date MADATINI = CPLib.NullDate();
  java.sql.Date MADATFIN = CPLib.NullDate();
  String MAFISGIU = "";
  java.sql.Date MADATMOD = CPLib.NullDate();
  String MATIPAGE = "";
  String MACODFIS = "";
  String MACOGNOME = "";
  String MANOME = "";
  String MARESPAESE = "";
  String MARESIND = "";
  String MARESNCIV = "";
  String MARESCITTA = "";
  String MARESPRV = "";
  String MARESCAP = "";
  String MADOMPAESE = "";
  String MADOMIND = "";
  String MADOMNCIV = "";
  String MADOMCITTA = "";
  String MADOMPRV = "";
  String MADOMCAP = "";
  double MAFLGCOMPL = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(MACODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGBON))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGCKR))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGASR))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGNOX))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADIPSTD))) {
      return false;
    }
    if ( ! (CPLib.Empty(MANAIDWU))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGCHKDAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGACT))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESSDEF))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGAUA))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADATINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADATFIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFISGIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADATMOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(MATIPAGE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MACODFIS))) {
      return false;
    }
    if ( ! (CPLib.Empty(MACOGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(MANOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESIND))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESNCIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESCITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESPRV))) {
      return false;
    }
    if ( ! (CPLib.Empty(MARESCAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADOMPAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADOMIND))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADOMNCIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADOMCITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADOMPRV))) {
      return false;
    }
    if ( ! (CPLib.Empty(MADOMCAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAFLGCOMPL))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbmacage p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbmacage.this.MACODICE = copyAndCast(p_row.MACODICE);
      MemoryCursorRow_tbmacage.this.MADESCRI = copyAndCast(p_row.MADESCRI);
      MemoryCursorRow_tbmacage.this.MAFLGRAP = copyAndCast(p_row.MAFLGRAP);
      MemoryCursorRow_tbmacage.this.MAFLGOPE = copyAndCast(p_row.MAFLGOPE);
      MemoryCursorRow_tbmacage.this.MAFLGBON = copyAndCast(p_row.MAFLGBON);
      MemoryCursorRow_tbmacage.this.MAFLGCKR = copyAndCast(p_row.MAFLGCKR);
      MemoryCursorRow_tbmacage.this.MAFLGASR = copyAndCast(p_row.MAFLGASR);
      MemoryCursorRow_tbmacage.this.MAFLGNOX = copyAndCast(p_row.MAFLGNOX);
      MemoryCursorRow_tbmacage.this.MADIPSTD = copyAndCast(p_row.MADIPSTD);
      MemoryCursorRow_tbmacage.this.MANAIDWU = copyAndCast(p_row.MANAIDWU);
      MemoryCursorRow_tbmacage.this.MAFLGCHKDAT = copyAndCast(p_row.MAFLGCHKDAT);
      MemoryCursorRow_tbmacage.this.MAFLGACT = copyAndCast(p_row.MAFLGACT);
      MemoryCursorRow_tbmacage.this.MARESSDEF = copyAndCast(p_row.MARESSDEF);
      MemoryCursorRow_tbmacage.this.MAFLGAUA = copyAndCast(p_row.MAFLGAUA);
      MemoryCursorRow_tbmacage.this.MADATINI = copyAndCast(p_row.MADATINI);
      MemoryCursorRow_tbmacage.this.MADATFIN = copyAndCast(p_row.MADATFIN);
      MemoryCursorRow_tbmacage.this.MAFISGIU = copyAndCast(p_row.MAFISGIU);
      MemoryCursorRow_tbmacage.this.MADATMOD = copyAndCast(p_row.MADATMOD);
      MemoryCursorRow_tbmacage.this.MATIPAGE = copyAndCast(p_row.MATIPAGE);
      MemoryCursorRow_tbmacage.this.MACODFIS = copyAndCast(p_row.MACODFIS);
      MemoryCursorRow_tbmacage.this.MACOGNOME = copyAndCast(p_row.MACOGNOME);
      MemoryCursorRow_tbmacage.this.MANOME = copyAndCast(p_row.MANOME);
      MemoryCursorRow_tbmacage.this.MARESPAESE = copyAndCast(p_row.MARESPAESE);
      MemoryCursorRow_tbmacage.this.MARESIND = copyAndCast(p_row.MARESIND);
      MemoryCursorRow_tbmacage.this.MARESNCIV = copyAndCast(p_row.MARESNCIV);
      MemoryCursorRow_tbmacage.this.MARESCITTA = copyAndCast(p_row.MARESCITTA);
      MemoryCursorRow_tbmacage.this.MARESPRV = copyAndCast(p_row.MARESPRV);
      MemoryCursorRow_tbmacage.this.MARESCAP = copyAndCast(p_row.MARESCAP);
      MemoryCursorRow_tbmacage.this.MADOMPAESE = copyAndCast(p_row.MADOMPAESE);
      MemoryCursorRow_tbmacage.this.MADOMIND = copyAndCast(p_row.MADOMIND);
      MemoryCursorRow_tbmacage.this.MADOMNCIV = copyAndCast(p_row.MADOMNCIV);
      MemoryCursorRow_tbmacage.this.MADOMCITTA = copyAndCast(p_row.MADOMCITTA);
      MemoryCursorRow_tbmacage.this.MADOMPRV = copyAndCast(p_row.MADOMPRV);
      MemoryCursorRow_tbmacage.this.MADOMCAP = copyAndCast(p_row.MADOMCAP);
      MemoryCursorRow_tbmacage.this.MAFLGCOMPL = copyAndCast(p_row.MAFLGCOMPL);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"MACODICE","MADESCRI","MAFLGRAP","MAFLGOPE","MAFLGBON","MAFLGCKR","MAFLGASR","MAFLGNOX","MADIPSTD","MANAIDWU","MAFLGCHKDAT","MAFLGACT","MARESSDEF","MAFLGAUA","MADATINI","MADATFIN","MAFISGIU","MADATMOD","MATIPAGE","MACODFIS","MACOGNOME","MANOME","MARESPAESE","MARESIND","MARESNCIV","MARESCITTA","MARESPRV","MARESCAP","MADOMPAESE","MADOMIND","MADOMNCIV","MADOMCITTA","MADOMPRV","MADOMCAP","MAFLGCOMPL"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","D","D","C","D","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Denominazione","Generazione Rapporti da operazioni","Scrivi su Operazioni o Frazionate","Scrive tipo operazione come bonifico","Controllo esistenza Rapporto","Associa Operazione a Rapporto","No operazioni extraconto","Dipendenza Default","NAID","Dati certi per Soggetti","Macroagente non operativo","Paese Residenza Default","Escludi Controlli AUA","Data Inizio Rapporto","Data Fine Rapporto","Persona fisica - persona Giuridica","Data Aggiornamento","Agente - Convenzionato","Codice Fiscale","Cognome","Nome","Paese Residenza","Indirizzo Residenza","N. Civico Residenza","Città Residenza","Provincia Residenza","CAP Residenza","Paese Domicilio","Indirizzo Domicilio","N. Civico Domicilio","Città Domicilio","Provincia Domicilio","CAP Domicilio","Chiusura per compliance"};
    return l_names;
  }
}
