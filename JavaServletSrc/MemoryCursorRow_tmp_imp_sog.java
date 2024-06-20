public class MemoryCursorRow_tmp_imp_sog extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_imp_sog() {
  }
  public MemoryCursorRow_tmp_imp_sog(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_imp_sog toBuild = new MemoryCursor_tmp_imp_sog(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_imp_sog toBuild = new MemoryCursor_tmp_imp_sog();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPOOPER = "";
  String CODSTUDIO = "";
  String TIPOIDEN = "";
  String CONNES = "";
  String DATAIDENT = "";
  String RAGSOC = "";
  String PAESE = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String DOMICILIO = "";
  String CAP = "";
  String CODFISC = "";
  String DATANASC = "";
  String NASCOMUN = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  String DATARILASC = "";
  String AUTRILASC = "";
  String SESSO = "";
  String STATOREG = "";
  String DATARETT = "";
  String DATAVALI = "";
  String PROVNASC = "";
  String RESPINS = "";
  String CODCLI = "";
  String SPECIE = "";
  String COMPORT = "";
  String ATTIV = "";
  String AREAGEO = "";
  double RNATGIU = 0;
  double RCOMP = 0;
  double RATTIV = 0;
  double RAREA = 0;
  String RAPSEGNA = "";
  String PIVA = "";
  String PEP = "";
  String TIPSOG = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPOOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODSTUDIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOIDEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAIDENT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
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
    if ( ! (CPLib.Empty(STATOREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARETT))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVNASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(RESPINS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SPECIE))) {
      return false;
    }
    if ( ! (CPLib.Empty(COMPORT))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(AREAGEO))) {
      return false;
    }
    if ( ! (CPLib.Empty(RNATGIU))) {
      return false;
    }
    if ( ! (CPLib.Empty(RCOMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RATTIV))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAREA))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPSEGNA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPSOG))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_imp_sog p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_imp_sog.this.TIPOOPER = copyAndCast(p_row.TIPOOPER);
      MemoryCursorRow_tmp_imp_sog.this.CODSTUDIO = copyAndCast(p_row.CODSTUDIO);
      MemoryCursorRow_tmp_imp_sog.this.TIPOIDEN = copyAndCast(p_row.TIPOIDEN);
      MemoryCursorRow_tmp_imp_sog.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_tmp_imp_sog.this.DATAIDENT = copyAndCast(p_row.DATAIDENT);
      MemoryCursorRow_tmp_imp_sog.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_tmp_imp_sog.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_tmp_imp_sog.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_tmp_imp_sog.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_tmp_imp_sog.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_tmp_imp_sog.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_tmp_imp_sog.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_tmp_imp_sog.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_tmp_imp_sog.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_tmp_imp_sog.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_tmp_imp_sog.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_tmp_imp_sog.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_tmp_imp_sog.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_tmp_imp_sog.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_tmp_imp_sog.this.STATOREG = copyAndCast(p_row.STATOREG);
      MemoryCursorRow_tmp_imp_sog.this.DATARETT = copyAndCast(p_row.DATARETT);
      MemoryCursorRow_tmp_imp_sog.this.DATAVALI = copyAndCast(p_row.DATAVALI);
      MemoryCursorRow_tmp_imp_sog.this.PROVNASC = copyAndCast(p_row.PROVNASC);
      MemoryCursorRow_tmp_imp_sog.this.RESPINS = copyAndCast(p_row.RESPINS);
      MemoryCursorRow_tmp_imp_sog.this.CODCLI = copyAndCast(p_row.CODCLI);
      MemoryCursorRow_tmp_imp_sog.this.SPECIE = copyAndCast(p_row.SPECIE);
      MemoryCursorRow_tmp_imp_sog.this.COMPORT = copyAndCast(p_row.COMPORT);
      MemoryCursorRow_tmp_imp_sog.this.ATTIV = copyAndCast(p_row.ATTIV);
      MemoryCursorRow_tmp_imp_sog.this.AREAGEO = copyAndCast(p_row.AREAGEO);
      MemoryCursorRow_tmp_imp_sog.this.RNATGIU = copyAndCast(p_row.RNATGIU);
      MemoryCursorRow_tmp_imp_sog.this.RCOMP = copyAndCast(p_row.RCOMP);
      MemoryCursorRow_tmp_imp_sog.this.RATTIV = copyAndCast(p_row.RATTIV);
      MemoryCursorRow_tmp_imp_sog.this.RAREA = copyAndCast(p_row.RAREA);
      MemoryCursorRow_tmp_imp_sog.this.RAPSEGNA = copyAndCast(p_row.RAPSEGNA);
      MemoryCursorRow_tmp_imp_sog.this.PIVA = copyAndCast(p_row.PIVA);
      MemoryCursorRow_tmp_imp_sog.this.PEP = copyAndCast(p_row.PEP);
      MemoryCursorRow_tmp_imp_sog.this.TIPSOG = copyAndCast(p_row.TIPSOG);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPOOPER","CODSTUDIO","TIPOIDEN","CONNES","DATAIDENT","RAGSOC","PAESE","DESCCIT","PROVINCIA","DOMICILIO","CAP","CODFISC","DATANASC","NASCOMUN","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","SESSO","STATOREG","DATARETT","DATAVALI","PROVNASC","RESPINS","CODCLI","SPECIE","COMPORT","ATTIV","AREAGEO","RNATGIU","RCOMP","RATTIV","RAREA","RAPSEGNA","PIVA","PEP","TIPSOG"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N","N","N","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Operatore","Codice Studio","Tipo identificazione","Codice Cliente","Data Identificazione","Ragione Sociale","Stato Residenza","Città residenza","","","","","","","","","","","","","","","","","ID CLiente","","","","","","","","","Rapporto con il segnalante","Partita IVA","S/N","Tipologia Cliente"};
    return l_names;
  }
}
