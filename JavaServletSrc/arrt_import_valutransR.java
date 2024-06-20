// * --- Area Manuale = BO - Header
// * --- arrt_import_valutrans
import java.io.*;
// * --- Fine Area Manuale
public class arrt_import_valutransR implements CallerWithObjs {
  // gestori associati a particolari eventi ('Routine start')
  public static volatile java.util.Map<String,java.util.List<com.zucchetti.sitepainter.EventHandler>> specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile java.util.List<com.zucchetti.sitepainter.EventHandler> allEventsHandlers;
  // indica se si sta gestendo un evento scatenato da questa routine per restituire il valore corretto di i_EntityName ed i_EntityType
  static boolean m_bEventRunning;
  public String m_cLastMsgError;
  public boolean m_bError;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabile di caller (variabili di caller): passata nel costruttore
  public CallerWithObjs m_Caller;
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_vt_cambios;
  public String m_cServer_vt_cambios;
  public String m_cPhName_vt_cis_agt_webaos;
  public String m_cServer_vt_cis_agt_webaos;
  public String m_cPhName_vt_cis_gir_otradiv;
  public String m_cServer_vt_cis_gir_otradiv;
  public String m_cPhName_vt_cis_giros_pagados;
  public String m_cServer_vt_cis_giros_pagados;
  public String m_cPhName_vt_cis_mit_cliente_connes;
  public String m_cServer_vt_cis_mit_cliente_connes;
  public String m_cPhName_vt_cis_ptos_prueba;
  public String m_cServer_vt_cis_ptos_prueba;
  public String m_cPhName_vt_cis_transmisores;
  public String m_cServer_vt_cis_transmisores;
  public String m_cPhName_vt_ciudades;
  public String m_cServer_vt_ciudades;
  public String m_cPhName_vt_cliente;
  public String m_cServer_vt_cliente;
  public String m_cPhName_vt_cliente_prueba;
  public String m_cServer_vt_cliente_prueba;
  public String m_cPhName_vt_doc_catinstitucionexpide;
  public String m_cServer_vt_doc_catinstitucionexpide;
  public String m_cPhName_vt_documento_extras;
  public String m_cServer_vt_documento_extras;
  public String m_cPhName_vt_documentos;
  public String m_cServer_vt_documentos;
  public String m_cPhName_vt_documentos_bit;
  public String m_cServer_vt_documentos_bit;
  public String m_cPhName_vt_estados;
  public String m_cServer_vt_estados;
  public String m_cPhName_vt_giros;
  public String m_cServer_vt_giros;
  public String m_cPhName_vt_historico_giros;
  public String m_cServer_vt_historico_giros;
  public String m_cPhName_vt_ide_ctbe_bol;
  public String m_cServer_vt_ide_ctbe_bol;
  public String m_cPhName_vt_ide_mon_cancelacion;
  public String m_cServer_vt_ide_mon_cancelacion;
  public String m_cPhName_vt_mit_citta;
  public String m_cServer_vt_mit_citta;
  public String m_cPhName_vt_mit_paises;
  public String m_cServer_vt_mit_paises;
  public String m_cPhName_vt_mit_tip_doc;
  public String m_cServer_vt_mit_tip_doc;
  public String m_cPhName_vt_ocupaciones;
  public String m_cServer_vt_ocupaciones;
  public String m_cPhName_vt_paises;
  public String m_cServer_vt_paises;
  public String m_cPhName_vt_regiones;
  public String m_cServer_vt_regiones;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  String m_cServer;
  String m_cPhName;
  CPPhTableWrInfo m_oWrInfo;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public String pTipo;
  public String fhand;
  public String _riga;
  public String _citta;
  public String _nazage;
  public String _isonaz;
  public double _agentep;
  public String _regione;
  public double _regval;
  public double _datiaos;
  public java.sql.Date _dataestrai;
  public java.sql.Date _dataestcmb;
  public String _luonas;
  public double _occupazione;
  public double _bl;
  public double _paesedoc;
  public String _emettidoc;
  public java.sql.Date _datainidoc;
  public java.sql.Date _datafindoc;
  public String _autorita;
  public String _tipdoc;
  public String _paese;
  public String _provres;
  public String _isopais;
  public String _codstades;
  public String _cabdip;
  public String _desintcon;
  public double _ntrx;
  public double _cambio;
  public String _cambioc;
  public String _gAzienda;
  public String _messaggio;
  public double _conta;
  public String cProg;
  public String _numdoc;
  public double _iddoc;
  public String _connes;
  public String _datacanc;
  public double _cliprov;
  public double _foliocli;
  public double _paisnas;
  public String _statomit;
  public double _citres;
  public double _paisres;
  public double _numdays;
  public double _numdcmb;
  public java.sql.Date _lastmod;
  public double _iddocumento;
  public double _codinstu;
  public String _comrila;
  public String _desaut;
  public String _descitaut;
  public MemoryCursor_mcvt_cliente_mcrdef mcClienti;
  public java.sql.Date _datainizio;
  public double _ncliente;
  public String _provnas;
  public double _import;
  public String _codmit;
  public String _desmit;
  public String _pathapp;
  public String _capcli;
  public String _codsae;
  public String _setsint;
  public MemoryCursor_tbcitta mcTBCITTA;
  public MemoryCursor_tbcitta mcTBCITTA_SIG;
  public MemoryCursor_tbstati mcTBSTATI;
  public MemoryCursor_tbstati mcTBSTATI_SIG;
  public MemoryCursor_tbstati mcTBSTATI_AUI;
  public MemoryCursor_vt_mit_citta mcMIT_CITTA;
  public MemoryCursor_vt_paises mcPAISES;
  public MemoryCursor_vt_regiones mcREGIONES;
  public MemoryCursor_vt_mit_paises mcMIT_PAISES;
  public String gMsgProc;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_import_valutransR (CPContext p_ContextObject, Caller caller) {
    if (caller == null)
      m_Caller = CallerWithObjsImpl.EMPTY;
    else if (caller instanceof CallerWithObjs)
      m_Caller = (CallerWithObjs)caller;
    else
      m_Caller = new CallerWithObjsImpl(caller);
    m_Ctx=p_ContextObject;
    // Assegnazione della variabile di collegamento con il database
    m_Sql=m_Ctx.GetSql();
    /*  Impostazione dell'ambiente globale: il businness object si collega
                                all'oggetto globale (unico per più istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda è contenuta nel global object.
                             */
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_import_valutrans",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_vt_cambios = p_ContextObject.GetPhName("vt_cambios");
    if (m_cPhName_vt_cambios.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cambios = m_cPhName_vt_cambios+" "+m_Ctx.GetWritePhName("vt_cambios");
    }
    m_cServer_vt_cambios = p_ContextObject.GetServer("vt_cambios");
    m_cPhName_vt_cis_agt_webaos = p_ContextObject.GetPhName("vt_cis_agt_webaos");
    if (m_cPhName_vt_cis_agt_webaos.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cis_agt_webaos = m_cPhName_vt_cis_agt_webaos+" "+m_Ctx.GetWritePhName("vt_cis_agt_webaos");
    }
    m_cServer_vt_cis_agt_webaos = p_ContextObject.GetServer("vt_cis_agt_webaos");
    m_cPhName_vt_cis_gir_otradiv = p_ContextObject.GetPhName("vt_cis_gir_otradiv");
    if (m_cPhName_vt_cis_gir_otradiv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cis_gir_otradiv = m_cPhName_vt_cis_gir_otradiv+" "+m_Ctx.GetWritePhName("vt_cis_gir_otradiv");
    }
    m_cServer_vt_cis_gir_otradiv = p_ContextObject.GetServer("vt_cis_gir_otradiv");
    m_cPhName_vt_cis_giros_pagados = p_ContextObject.GetPhName("vt_cis_giros_pagados");
    if (m_cPhName_vt_cis_giros_pagados.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cis_giros_pagados = m_cPhName_vt_cis_giros_pagados+" "+m_Ctx.GetWritePhName("vt_cis_giros_pagados");
    }
    m_cServer_vt_cis_giros_pagados = p_ContextObject.GetServer("vt_cis_giros_pagados");
    m_cPhName_vt_cis_mit_cliente_connes = p_ContextObject.GetPhName("vt_cis_mit_cliente_connes");
    if (m_cPhName_vt_cis_mit_cliente_connes.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cis_mit_cliente_connes = m_cPhName_vt_cis_mit_cliente_connes+" "+m_Ctx.GetWritePhName("vt_cis_mit_cliente_connes");
    }
    m_cServer_vt_cis_mit_cliente_connes = p_ContextObject.GetServer("vt_cis_mit_cliente_connes");
    m_cPhName_vt_cis_ptos_prueba = p_ContextObject.GetPhName("vt_cis_ptos_prueba");
    if (m_cPhName_vt_cis_ptos_prueba.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cis_ptos_prueba = m_cPhName_vt_cis_ptos_prueba+" "+m_Ctx.GetWritePhName("vt_cis_ptos_prueba");
    }
    m_cServer_vt_cis_ptos_prueba = p_ContextObject.GetServer("vt_cis_ptos_prueba");
    m_cPhName_vt_cis_transmisores = p_ContextObject.GetPhName("vt_cis_transmisores");
    if (m_cPhName_vt_cis_transmisores.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cis_transmisores = m_cPhName_vt_cis_transmisores+" "+m_Ctx.GetWritePhName("vt_cis_transmisores");
    }
    m_cServer_vt_cis_transmisores = p_ContextObject.GetServer("vt_cis_transmisores");
    m_cPhName_vt_ciudades = p_ContextObject.GetPhName("vt_ciudades");
    if (m_cPhName_vt_ciudades.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_ciudades = m_cPhName_vt_ciudades+" "+m_Ctx.GetWritePhName("vt_ciudades");
    }
    m_cServer_vt_ciudades = p_ContextObject.GetServer("vt_ciudades");
    m_cPhName_vt_cliente = p_ContextObject.GetPhName("vt_cliente");
    if (m_cPhName_vt_cliente.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cliente = m_cPhName_vt_cliente+" "+m_Ctx.GetWritePhName("vt_cliente");
    }
    m_cServer_vt_cliente = p_ContextObject.GetServer("vt_cliente");
    m_cPhName_vt_cliente_prueba = p_ContextObject.GetPhName("vt_cliente_prueba");
    if (m_cPhName_vt_cliente_prueba.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_cliente_prueba = m_cPhName_vt_cliente_prueba+" "+m_Ctx.GetWritePhName("vt_cliente_prueba");
    }
    m_cServer_vt_cliente_prueba = p_ContextObject.GetServer("vt_cliente_prueba");
    m_cPhName_vt_doc_catinstitucionexpide = p_ContextObject.GetPhName("vt_doc_catinstitucionexpide");
    if (m_cPhName_vt_doc_catinstitucionexpide.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_doc_catinstitucionexpide = m_cPhName_vt_doc_catinstitucionexpide+" "+m_Ctx.GetWritePhName("vt_doc_catinstitucionexpide");
    }
    m_cServer_vt_doc_catinstitucionexpide = p_ContextObject.GetServer("vt_doc_catinstitucionexpide");
    m_cPhName_vt_documento_extras = p_ContextObject.GetPhName("vt_documento_extras");
    if (m_cPhName_vt_documento_extras.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_documento_extras = m_cPhName_vt_documento_extras+" "+m_Ctx.GetWritePhName("vt_documento_extras");
    }
    m_cServer_vt_documento_extras = p_ContextObject.GetServer("vt_documento_extras");
    m_cPhName_vt_documentos = p_ContextObject.GetPhName("vt_documentos");
    if (m_cPhName_vt_documentos.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_documentos = m_cPhName_vt_documentos+" "+m_Ctx.GetWritePhName("vt_documentos");
    }
    m_cServer_vt_documentos = p_ContextObject.GetServer("vt_documentos");
    m_cPhName_vt_documentos_bit = p_ContextObject.GetPhName("vt_documentos_bit");
    if (m_cPhName_vt_documentos_bit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_documentos_bit = m_cPhName_vt_documentos_bit+" "+m_Ctx.GetWritePhName("vt_documentos_bit");
    }
    m_cServer_vt_documentos_bit = p_ContextObject.GetServer("vt_documentos_bit");
    m_cPhName_vt_estados = p_ContextObject.GetPhName("vt_estados");
    if (m_cPhName_vt_estados.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_estados = m_cPhName_vt_estados+" "+m_Ctx.GetWritePhName("vt_estados");
    }
    m_cServer_vt_estados = p_ContextObject.GetServer("vt_estados");
    m_cPhName_vt_giros = p_ContextObject.GetPhName("vt_giros");
    if (m_cPhName_vt_giros.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_giros = m_cPhName_vt_giros+" "+m_Ctx.GetWritePhName("vt_giros");
    }
    m_cServer_vt_giros = p_ContextObject.GetServer("vt_giros");
    m_cPhName_vt_historico_giros = p_ContextObject.GetPhName("vt_historico_giros");
    if (m_cPhName_vt_historico_giros.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_historico_giros = m_cPhName_vt_historico_giros+" "+m_Ctx.GetWritePhName("vt_historico_giros");
    }
    m_cServer_vt_historico_giros = p_ContextObject.GetServer("vt_historico_giros");
    m_cPhName_vt_ide_ctbe_bol = p_ContextObject.GetPhName("vt_ide_ctbe_bol");
    if (m_cPhName_vt_ide_ctbe_bol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_ide_ctbe_bol = m_cPhName_vt_ide_ctbe_bol+" "+m_Ctx.GetWritePhName("vt_ide_ctbe_bol");
    }
    m_cServer_vt_ide_ctbe_bol = p_ContextObject.GetServer("vt_ide_ctbe_bol");
    m_cPhName_vt_ide_mon_cancelacion = p_ContextObject.GetPhName("vt_ide_mon_cancelacion");
    if (m_cPhName_vt_ide_mon_cancelacion.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_ide_mon_cancelacion = m_cPhName_vt_ide_mon_cancelacion+" "+m_Ctx.GetWritePhName("vt_ide_mon_cancelacion");
    }
    m_cServer_vt_ide_mon_cancelacion = p_ContextObject.GetServer("vt_ide_mon_cancelacion");
    m_cPhName_vt_mit_citta = p_ContextObject.GetPhName("vt_mit_citta");
    if (m_cPhName_vt_mit_citta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_mit_citta = m_cPhName_vt_mit_citta+" "+m_Ctx.GetWritePhName("vt_mit_citta");
    }
    m_cServer_vt_mit_citta = p_ContextObject.GetServer("vt_mit_citta");
    m_cPhName_vt_mit_paises = p_ContextObject.GetPhName("vt_mit_paises");
    if (m_cPhName_vt_mit_paises.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_mit_paises = m_cPhName_vt_mit_paises+" "+m_Ctx.GetWritePhName("vt_mit_paises");
    }
    m_cServer_vt_mit_paises = p_ContextObject.GetServer("vt_mit_paises");
    m_cPhName_vt_mit_tip_doc = p_ContextObject.GetPhName("vt_mit_tip_doc");
    if (m_cPhName_vt_mit_tip_doc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_mit_tip_doc = m_cPhName_vt_mit_tip_doc+" "+m_Ctx.GetWritePhName("vt_mit_tip_doc");
    }
    m_cServer_vt_mit_tip_doc = p_ContextObject.GetServer("vt_mit_tip_doc");
    m_cPhName_vt_ocupaciones = p_ContextObject.GetPhName("vt_ocupaciones");
    if (m_cPhName_vt_ocupaciones.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_ocupaciones = m_cPhName_vt_ocupaciones+" "+m_Ctx.GetWritePhName("vt_ocupaciones");
    }
    m_cServer_vt_ocupaciones = p_ContextObject.GetServer("vt_ocupaciones");
    m_cPhName_vt_paises = p_ContextObject.GetPhName("vt_paises");
    if (m_cPhName_vt_paises.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_paises = m_cPhName_vt_paises+" "+m_Ctx.GetWritePhName("vt_paises");
    }
    m_cServer_vt_paises = p_ContextObject.GetServer("vt_paises");
    m_cPhName_vt_regiones = p_ContextObject.GetPhName("vt_regiones");
    if (m_cPhName_vt_regiones.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_vt_regiones = m_cPhName_vt_regiones+" "+m_Ctx.GetWritePhName("vt_regiones");
    }
    m_cServer_vt_regiones = p_ContextObject.GetServer("vt_regiones");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_agentep",p_cVarName)) {
      return _agentep;
    }
    if (CPLib.eqr("_regval",p_cVarName)) {
      return _regval;
    }
    if (CPLib.eqr("_datiaos",p_cVarName)) {
      return _datiaos;
    }
    if (CPLib.eqr("_occupazione",p_cVarName)) {
      return _occupazione;
    }
    if (CPLib.eqr("_bl",p_cVarName)) {
      return _bl;
    }
    if (CPLib.eqr("_paesedoc",p_cVarName)) {
      return _paesedoc;
    }
    if (CPLib.eqr("_ntrx",p_cVarName)) {
      return _ntrx;
    }
    if (CPLib.eqr("_cambio",p_cVarName)) {
      return _cambio;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_iddoc",p_cVarName)) {
      return _iddoc;
    }
    if (CPLib.eqr("_cliprov",p_cVarName)) {
      return _cliprov;
    }
    if (CPLib.eqr("_foliocli",p_cVarName)) {
      return _foliocli;
    }
    if (CPLib.eqr("_paisnas",p_cVarName)) {
      return _paisnas;
    }
    if (CPLib.eqr("_citres",p_cVarName)) {
      return _citres;
    }
    if (CPLib.eqr("_paisres",p_cVarName)) {
      return _paisres;
    }
    if (CPLib.eqr("_numdays",p_cVarName)) {
      return _numdays;
    }
    if (CPLib.eqr("_numdcmb",p_cVarName)) {
      return _numdcmb;
    }
    if (CPLib.eqr("_iddocumento",p_cVarName)) {
      return _iddocumento;
    }
    if (CPLib.eqr("_codinstu",p_cVarName)) {
      return _codinstu;
    }
    if (CPLib.eqr("_ncliente",p_cVarName)) {
      return _ncliente;
    }
    if (CPLib.eqr("_import",p_cVarName)) {
      return _import;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_valutrans";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_citta",p_cVarName)) {
      return _citta;
    }
    if (CPLib.eqr("_nazage",p_cVarName)) {
      return _nazage;
    }
    if (CPLib.eqr("_isonaz",p_cVarName)) {
      return _isonaz;
    }
    if (CPLib.eqr("_regione",p_cVarName)) {
      return _regione;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("_emettidoc",p_cVarName)) {
      return _emettidoc;
    }
    if (CPLib.eqr("_autorita",p_cVarName)) {
      return _autorita;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      return _tipdoc;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      return _provres;
    }
    if (CPLib.eqr("_isopais",p_cVarName)) {
      return _isopais;
    }
    if (CPLib.eqr("_codstades",p_cVarName)) {
      return _codstades;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      return _cabdip;
    }
    if (CPLib.eqr("_desintcon",p_cVarName)) {
      return _desintcon;
    }
    if (CPLib.eqr("_cambioc",p_cVarName)) {
      return _cambioc;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_messaggio",p_cVarName)) {
      return _messaggio;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_datacanc",p_cVarName)) {
      return _datacanc;
    }
    if (CPLib.eqr("_statomit",p_cVarName)) {
      return _statomit;
    }
    if (CPLib.eqr("_comrila",p_cVarName)) {
      return _comrila;
    }
    if (CPLib.eqr("_desaut",p_cVarName)) {
      return _desaut;
    }
    if (CPLib.eqr("_descitaut",p_cVarName)) {
      return _descitaut;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      return _provnas;
    }
    if (CPLib.eqr("_codmit",p_cVarName)) {
      return _codmit;
    }
    if (CPLib.eqr("_desmit",p_cVarName)) {
      return _desmit;
    }
    if (CPLib.eqr("_pathapp",p_cVarName)) {
      return _pathapp;
    }
    if (CPLib.eqr("_capcli",p_cVarName)) {
      return _capcli;
    }
    if (CPLib.eqr("_codsae",p_cVarName)) {
      return _codsae;
    }
    if (CPLib.eqr("_setsint",p_cVarName)) {
      return _setsint;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataestrai",p_cVarName)) {
      return _dataestrai;
    }
    if (CPLib.eqr("_dataestcmb",p_cVarName)) {
      return _dataestcmb;
    }
    if (CPLib.eqr("_datainidoc",p_cVarName)) {
      return _datainidoc;
    }
    if (CPLib.eqr("_datafindoc",p_cVarName)) {
      return _datafindoc;
    }
    if (CPLib.eqr("_lastmod",p_cVarName)) {
      return _lastmod;
    }
    if (CPLib.eqr("_datainizio",p_cVarName)) {
      return _datainizio;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcClienti",p_cVarName)) {
      return mcClienti;
    }
    if (CPLib.eqr("mcTBCITTA",p_cVarName)) {
      return mcTBCITTA;
    }
    if (CPLib.eqr("mcTBCITTA_SIG",p_cVarName)) {
      return mcTBCITTA_SIG;
    }
    if (CPLib.eqr("mcTBSTATI",p_cVarName)) {
      return mcTBSTATI;
    }
    if (CPLib.eqr("mcTBSTATI_SIG",p_cVarName)) {
      return mcTBSTATI_SIG;
    }
    if (CPLib.eqr("mcTBSTATI_AUI",p_cVarName)) {
      return mcTBSTATI_AUI;
    }
    if (CPLib.eqr("mcMIT_CITTA",p_cVarName)) {
      return mcMIT_CITTA;
    }
    if (CPLib.eqr("mcPAISES",p_cVarName)) {
      return mcPAISES;
    }
    if (CPLib.eqr("mcREGIONES",p_cVarName)) {
      return mcREGIONES;
    }
    if (CPLib.eqr("mcMIT_PAISES",p_cVarName)) {
      return mcMIT_PAISES;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_agentep",p_cVarName)) {
      _agentep = value;
      return;
    }
    if (CPLib.eqr("_regval",p_cVarName)) {
      _regval = value;
      return;
    }
    if (CPLib.eqr("_datiaos",p_cVarName)) {
      _datiaos = value;
      return;
    }
    if (CPLib.eqr("_occupazione",p_cVarName)) {
      _occupazione = value;
      return;
    }
    if (CPLib.eqr("_bl",p_cVarName)) {
      _bl = value;
      return;
    }
    if (CPLib.eqr("_paesedoc",p_cVarName)) {
      _paesedoc = value;
      return;
    }
    if (CPLib.eqr("_ntrx",p_cVarName)) {
      _ntrx = value;
      return;
    }
    if (CPLib.eqr("_cambio",p_cVarName)) {
      _cambio = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_iddoc",p_cVarName)) {
      _iddoc = value;
      return;
    }
    if (CPLib.eqr("_cliprov",p_cVarName)) {
      _cliprov = value;
      return;
    }
    if (CPLib.eqr("_foliocli",p_cVarName)) {
      _foliocli = value;
      return;
    }
    if (CPLib.eqr("_paisnas",p_cVarName)) {
      _paisnas = value;
      return;
    }
    if (CPLib.eqr("_citres",p_cVarName)) {
      _citres = value;
      return;
    }
    if (CPLib.eqr("_paisres",p_cVarName)) {
      _paisres = value;
      return;
    }
    if (CPLib.eqr("_numdays",p_cVarName)) {
      _numdays = value;
      return;
    }
    if (CPLib.eqr("_numdcmb",p_cVarName)) {
      _numdcmb = value;
      return;
    }
    if (CPLib.eqr("_iddocumento",p_cVarName)) {
      _iddocumento = value;
      return;
    }
    if (CPLib.eqr("_codinstu",p_cVarName)) {
      _codinstu = value;
      return;
    }
    if (CPLib.eqr("_ncliente",p_cVarName)) {
      _ncliente = value;
      return;
    }
    if (CPLib.eqr("_import",p_cVarName)) {
      _import = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_citta",p_cVarName)) {
      _citta = value;
      return;
    }
    if (CPLib.eqr("_nazage",p_cVarName)) {
      _nazage = value;
      return;
    }
    if (CPLib.eqr("_isonaz",p_cVarName)) {
      _isonaz = value;
      return;
    }
    if (CPLib.eqr("_regione",p_cVarName)) {
      _regione = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("_emettidoc",p_cVarName)) {
      _emettidoc = value;
      return;
    }
    if (CPLib.eqr("_autorita",p_cVarName)) {
      _autorita = value;
      return;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      _tipdoc = value;
      return;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      _provres = value;
      return;
    }
    if (CPLib.eqr("_isopais",p_cVarName)) {
      _isopais = value;
      return;
    }
    if (CPLib.eqr("_codstades",p_cVarName)) {
      _codstades = value;
      return;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      _cabdip = value;
      return;
    }
    if (CPLib.eqr("_desintcon",p_cVarName)) {
      _desintcon = value;
      return;
    }
    if (CPLib.eqr("_cambioc",p_cVarName)) {
      _cambioc = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_messaggio",p_cVarName)) {
      _messaggio = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_datacanc",p_cVarName)) {
      _datacanc = value;
      return;
    }
    if (CPLib.eqr("_statomit",p_cVarName)) {
      _statomit = value;
      return;
    }
    if (CPLib.eqr("_comrila",p_cVarName)) {
      _comrila = value;
      return;
    }
    if (CPLib.eqr("_desaut",p_cVarName)) {
      _desaut = value;
      return;
    }
    if (CPLib.eqr("_descitaut",p_cVarName)) {
      _descitaut = value;
      return;
    }
    if (CPLib.eqr("_provnas",p_cVarName)) {
      _provnas = value;
      return;
    }
    if (CPLib.eqr("_codmit",p_cVarName)) {
      _codmit = value;
      return;
    }
    if (CPLib.eqr("_desmit",p_cVarName)) {
      _desmit = value;
      return;
    }
    if (CPLib.eqr("_pathapp",p_cVarName)) {
      _pathapp = value;
      return;
    }
    if (CPLib.eqr("_capcli",p_cVarName)) {
      _capcli = value;
      return;
    }
    if (CPLib.eqr("_codsae",p_cVarName)) {
      _codsae = value;
      return;
    }
    if (CPLib.eqr("_setsint",p_cVarName)) {
      _setsint = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataestrai",p_cVarName)) {
      _dataestrai = value;
      return;
    }
    if (CPLib.eqr("_dataestcmb",p_cVarName)) {
      _dataestcmb = value;
      return;
    }
    if (CPLib.eqr("_datainidoc",p_cVarName)) {
      _datainidoc = value;
      return;
    }
    if (CPLib.eqr("_datafindoc",p_cVarName)) {
      _datafindoc = value;
      return;
    }
    if (CPLib.eqr("_lastmod",p_cVarName)) {
      _lastmod = value;
      return;
    }
    if (CPLib.eqr("_datainizio",p_cVarName)) {
      _datainizio = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcClienti",p_cVarName)) {
      mcClienti = (MemoryCursor_mcvt_cliente_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcTBCITTA",p_cVarName)) {
      mcTBCITTA = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcTBCITTA_SIG",p_cVarName)) {
      mcTBCITTA_SIG = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcTBSTATI",p_cVarName)) {
      mcTBSTATI = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcTBSTATI_SIG",p_cVarName)) {
      mcTBSTATI_SIG = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcTBSTATI_AUI",p_cVarName)) {
      mcTBSTATI_AUI = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcMIT_CITTA",p_cVarName)) {
      mcMIT_CITTA = (MemoryCursor_vt_mit_citta)value;
      return;
    }
    if (CPLib.eqr("mcPAISES",p_cVarName)) {
      mcPAISES = (MemoryCursor_vt_paises)value;
      return;
    }
    if (CPLib.eqr("mcREGIONES",p_cVarName)) {
      mcREGIONES = (MemoryCursor_vt_regiones)value;
      return;
    }
    if (CPLib.eqr("mcMIT_PAISES",p_cVarName)) {
      mcMIT_PAISES = (MemoryCursor_vt_mit_paises)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_tbstati=null;
    CPResultSet Cursor_vt_mit_citta=null;
    CPResultSet Cursor_vt_paises=null;
    CPResultSet Cursor_vt_regiones=null;
    CPResultSet Cursor_vt_mit_paises=null;
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* pTipo Char(1) // Tipo Import (Scheduler-Online) */
      /* fhand Char(1) // Variabile per collegamento al file di scrittura */
      /* _riga Memo // Riga su cui scrivere i dati prima di scriverli sul file */
      /* _citta Char(50) */
      /* _nazage Char(3) */
      /* _isonaz Char(3) */
      /* _agentep Numeric(10, 0) */
      /* _regione Char(2) */
      /* _regval Numeric(3, 0) */
      /* _datiaos Numeric(1, 0) */
      /* _dataestrai Date */
      /* _dataestcmb Date */
      /* _luonas Char(50) */
      /* _occupazione Numeric(10, 0) */
      /* _bl Numeric(1, 0) */
      /* _paesedoc Numeric(10, 0) */
      /* _emettidoc Char(2) */
      /* _datainidoc Date */
      /* _datafindoc Date */
      /* _autorita Char(100) */
      /* _tipdoc Char(2) */
      /* _paese Char(60) */
      /* _provres Char(5) */
      /* _isopais Char(4) */
      /* _codstades Char(3) // Codice Stato Destinazione */
      /* _cabdip Char(6) */
      /* _desintcon Char(40) */
      /* _ntrx Numeric(1, 0) */
      /* _cambio Numeric(15, 10) */
      /* _cambioc Char(5) */
      /* _gAzienda Char(10) // Azienda */
      /* _messaggio Memo */
      /* _conta Numeric(10, 0) */
      /* cProg Char(20) */
      /* _numdoc Char(25) */
      /* _iddoc Numeric(3, 0) */
      /* _connes Char(16) */
      /* _datacanc Char(10) */
      /* _cliprov Numeric(10, 0) */
      /* _foliocli Numeric(10, 0) */
      /* _paisnas Numeric(10, 0) */
      /* _statomit Char(3) */
      /* _citres Numeric(10, 0) */
      /* _paisres Numeric(10, 0) */
      /* _numdays Numeric(2, 0) */
      /* _numdcmb Numeric(2, 0) */
      /* _lastmod Date */
      /* _iddocumento Numeric(10, 0) */
      /* _codinstu Numeric(10, 0) */
      /* _comrila Char(10) */
      /* _desaut Char(100) */
      /* _descitaut Char(40) */
      /* mcClienti MemoryCursor(mcVT_CLIENTE.MCRDef) */
      /* _datainizio Date */
      /* _ncliente Numeric(10, 0) */
      /* _provnas Char(2) */
      /* _import Numeric(1, 0) */
      /* _codmit Char(3) */
      /* _desmit Char(40) */
      /* _pathapp Char(80) */
      /* _capcli Char(5) */
      /* _codsae Char(3) */
      /* _setsint Char(3) */
      /* mcTBCITTA MemoryCursor(tbcitta) */
      /* mcTBCITTA_SIG MemoryCursor(tbcitta) */
      /* mcTBSTATI MemoryCursor(tbstati) */
      /* mcTBSTATI_SIG MemoryCursor(tbstati) */
      /* mcTBSTATI_AUI MemoryCursor(tbstati) */
      /* mcMIT_CITTA MemoryCursor(vt_mit_citta) */
      /* mcPAISES MemoryCursor(vt_paises) */
      /* mcREGIONES MemoryCursor(vt_regiones) */
      /* mcMIT_PAISES MemoryCursor(vt_mit_paises) */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) */
      // * --- Fill memory cursor mcTBCITTA on tbcitta
      mcTBCITTA.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcTBCITTA.AppendWithTrimmedKey(Cursor_tbcitta.GetString("CITTA"));
        mcTBCITTA.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcTBCITTA.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcTBCITTA.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcTBCITTA.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcTBCITTA.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcTBCITTA.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcTBCITTA.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcTBCITTA.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcTBCITTA.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcTBCITTA.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcTBCITTA.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcTBCITTA.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcTBCITTA.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcTBCITTA.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcTBCITTA.GoTop();
      // * --- Fill memory cursor mcTBCITTA_SIG on tbcitta
      mcTBCITTA_SIG.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcTBCITTA_SIG.AppendWithTrimmedKey(Cursor_tbcitta.GetString("SIGLA"));
        mcTBCITTA_SIG.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcTBCITTA_SIG.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcTBCITTA_SIG.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcTBCITTA_SIG.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcTBCITTA_SIG.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcTBCITTA_SIG.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcTBCITTA_SIG.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcTBCITTA_SIG.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcTBCITTA_SIG.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcTBCITTA_SIG.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcTBCITTA_SIG.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcTBCITTA_SIG.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcTBCITTA_SIG.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcTBCITTA_SIG.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcTBCITTA_SIG.GoTop();
      // * --- Fill memory cursor mcTBSTATI on tbstati
      mcTBSTATI.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTBSTATI.AppendWithTrimmedKey(Cursor_tbstati.GetString("ISO"));
        mcTBSTATI.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTBSTATI.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTBSTATI.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTBSTATI.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTBSTATI.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTBSTATI.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTBSTATI.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTBSTATI.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTBSTATI.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTBSTATI.GoTop();
      // * --- Fill memory cursor mcTBSTATI_SIG on tbstati
      mcTBSTATI_SIG.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTBSTATI_SIG.AppendWithTrimmedKey(Cursor_tbstati.GetString("SIGLA"));
        mcTBSTATI_SIG.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTBSTATI_SIG.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTBSTATI_SIG.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTBSTATI_SIG.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTBSTATI_SIG.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTBSTATI_SIG.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTBSTATI_SIG.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTBSTATI_SIG.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTBSTATI_SIG.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTBSTATI_SIG.GoTop();
      // * --- Fill memory cursor mcTBSTATI_AUI on tbstati
      mcTBSTATI_AUI.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTBSTATI_AUI.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
        mcTBSTATI_AUI.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTBSTATI_AUI.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTBSTATI_AUI.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTBSTATI_AUI.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTBSTATI_AUI.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTBSTATI_AUI.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTBSTATI_AUI.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTBSTATI_AUI.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTBSTATI_AUI.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTBSTATI_AUI.GoTop();
      // * --- Fill memory cursor mcMIT_CITTA on vt_mit_citta
      mcMIT_CITTA.Zap();
      m_cServer = m_Ctx.GetServer("vt_mit_citta");
      m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
      if (Cursor_vt_mit_citta!=null)
        Cursor_vt_mit_citta.Close();
      Cursor_vt_mit_citta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("vt_mit_citta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_vt_mit_citta;
        Cursor_vt_mit_citta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on vt_mit_citta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_vt_mit_citta.Eof())) {
        mcMIT_CITTA.AppendWithTrimmedKey(Cursor_vt_mit_citta.GetDouble("cod_ciudad_sitrop"));
        mcMIT_CITTA.row.cab = Cursor_vt_mit_citta.GetString("cab");
        mcMIT_CITTA.row.citta = Cursor_vt_mit_citta.GetString("citta");
        mcMIT_CITTA.row.prov = Cursor_vt_mit_citta.GetString("prov");
        mcMIT_CITTA.row.cap = Cursor_vt_mit_citta.GetString("cap");
        mcMIT_CITTA.row.pktbstati = Cursor_vt_mit_citta.GetString("pktbstati");
        mcMIT_CITTA.row.sigla = Cursor_vt_mit_citta.GetString("sigla");
        mcMIT_CITTA.row.pref = Cursor_vt_mit_citta.GetString("pref");
        mcMIT_CITTA.row.cod_ciudad_sitrop = Cursor_vt_mit_citta.GetDouble("cod_ciudad_sitrop");
        Cursor_vt_mit_citta.Next();
      }
      m_cConnectivityError = Cursor_vt_mit_citta.ErrorMessage();
      Cursor_vt_mit_citta.Close();
      mcMIT_CITTA.GoTop();
      // * --- Fill memory cursor mcPAISES on vt_paises
      mcPAISES.Zap();
      m_cServer = m_Ctx.GetServer("vt_paises");
      m_cPhName = m_Ctx.GetPhName("vt_paises");
      if (Cursor_vt_paises!=null)
        Cursor_vt_paises.Close();
      Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("vt_paises")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_vt_paises;
        Cursor_vt_paises.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on vt_paises returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_vt_paises.Eof())) {
        mcPAISES.AppendWithTrimmedKey(Cursor_vt_paises.GetDouble("cod_pais"));
        mcPAISES.row.cod_pais = Cursor_vt_paises.GetDouble("cod_pais");
        mcPAISES.row.id_divisa = Cursor_vt_paises.GetString("id_divisa");
        mcPAISES.row.nom_pais = Cursor_vt_paises.GetString("nom_pais");
        mcPAISES.row.fec_alta = Cursor_vt_paises.GetDate("fec_alta");
        mcPAISES.row.status = Cursor_vt_paises.GetString("status");
        mcPAISES.row.fec_baja = Cursor_vt_paises.GetDate("fec_baja");
        mcPAISES.row.fec_cambio = Cursor_vt_paises.GetDate("fec_cambio");
        mcPAISES.row.nom_estado = Cursor_vt_paises.GetString("nom_estado");
        mcPAISES.row.con_edocta = Cursor_vt_paises.GetDouble("con_edocta");
        mcPAISES.row.con_edocda = Cursor_vt_paises.GetDouble("con_edocda");
        mcPAISES.row.monto_sospechoso = Cursor_vt_paises.GetDouble("monto_sospechoso");
        mcPAISES.row.periodo = Cursor_vt_paises.GetDouble("periodo");
        mcPAISES.row.long_telefono = Cursor_vt_paises.GetDouble("long_telefono");
        mcPAISES.row.long_min_tel = Cursor_vt_paises.GetDouble("long_min_tel");
        mcPAISES.row.mon_min_sosp = Cursor_vt_paises.GetDouble("mon_min_sosp");
        mcPAISES.row.modifica = Cursor_vt_paises.GetDouble("modifica");
        mcPAISES.row.aci_pais = Cursor_vt_paises.GetDouble("aci_pais");
        mcPAISES.row.bts_cve = Cursor_vt_paises.GetString("bts_cve");
        mcPAISES.row.muestra_ben = Cursor_vt_paises.GetDouble("muestra_ben");
        mcPAISES.row.obliga_ben = Cursor_vt_paises.GetString("obliga_ben");
        mcPAISES.row.pos = Cursor_vt_paises.GetDouble("pos");
        mcPAISES.row.pais_q = Cursor_vt_paises.GetString("pais_q");
        mcPAISES.row.id_continente = Cursor_vt_paises.GetDouble("id_continente");
        mcPAISES.row.nm_pai_italiano = Cursor_vt_paises.GetString("nm_pai_italiano");
        mcPAISES.row.EN = Cursor_vt_paises.GetString("EN");
        mcPAISES.row.ES = Cursor_vt_paises.GetString("ES");
        mcPAISES.row.IT = Cursor_vt_paises.GetString("IT");
        mcPAISES.row.FR = Cursor_vt_paises.GetString("FR");
        mcPAISES.row.cod_pais_equiv = Cursor_vt_paises.GetDouble("cod_pais_equiv");
        Cursor_vt_paises.Next();
      }
      m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
      Cursor_vt_paises.Close();
      mcPAISES.GoTop();
      // * --- Fill memory cursor mcREGIONES on vt_regiones
      mcREGIONES.Zap();
      m_cServer = m_Ctx.GetServer("vt_regiones");
      m_cPhName = m_Ctx.GetPhName("vt_regiones");
      if (Cursor_vt_regiones!=null)
        Cursor_vt_regiones.Close();
      Cursor_vt_regiones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("vt_regiones")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_vt_regiones;
        Cursor_vt_regiones.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on vt_regiones returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_vt_regiones.Eof())) {
        mcREGIONES.AppendWithTrimmedKey(Cursor_vt_regiones.GetDouble("id_region"));
        mcREGIONES.row.id_region = Cursor_vt_regiones.GetDouble("id_region");
        mcREGIONES.row.region = Cursor_vt_regiones.GetString("region");
        mcREGIONES.row.id_regional = Cursor_vt_regiones.GetDouble("id_regional");
        mcREGIONES.row.codice_MIT = Cursor_vt_regiones.GetString("codice_MIT");
        mcREGIONES.row.cod_pais = Cursor_vt_regiones.GetDouble("cod_pais");
        Cursor_vt_regiones.Next();
      }
      m_cConnectivityError = Cursor_vt_regiones.ErrorMessage();
      Cursor_vt_regiones.Close();
      mcREGIONES.GoTop();
      // * --- Fill memory cursor mcMIT_PAISES on vt_mit_paises
      mcMIT_PAISES.Zap();
      m_cServer = m_Ctx.GetServer("vt_mit_paises");
      m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
      if (Cursor_vt_mit_paises!=null)
        Cursor_vt_mit_paises.Close();
      Cursor_vt_mit_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("vt_mit_paises")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_vt_mit_paises;
        Cursor_vt_mit_paises.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_valutrans: query on vt_mit_paises returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_vt_mit_paises.Eof())) {
        mcMIT_PAISES.AppendWithTrimmedKey(Cursor_vt_mit_paises.GetDouble("cod_pais"));
        mcMIT_PAISES.row.cod_pais = Cursor_vt_mit_paises.GetDouble("cod_pais");
        mcMIT_PAISES.row.cod_comune = Cursor_vt_mit_paises.GetString("cod_comune");
        mcMIT_PAISES.row.cod_mit = Cursor_vt_mit_paises.GetString("cod_mit");
        mcMIT_PAISES.row.pais_q = Cursor_vt_mit_paises.GetString("pais_q");
        Cursor_vt_mit_paises.Next();
      }
      m_cConnectivityError = Cursor_vt_mit_paises.ErrorMessage();
      Cursor_vt_mit_paises.Close();
      mcMIT_PAISES.GoTop();
      /* Info Msg 'Lancio Import Schedulato' */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log(CPLib.FormatMsg(m_Ctx,"Lancio Import Schedulato"));
      }
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000005Astatus;
      nTry0000005Astatus = m_Sql.GetTransactionStatus();
      String cTry0000005Amsg;
      cTry0000005Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* _pathapp := Strtran(FileLibMit.GetLocation(),'\','/') */
        _pathapp = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
        // * --- Select from cpazi
        m_cServer = m_Ctx.GetServer("cpazi");
        m_cPhName = m_Ctx.GetPhName("cpazi");
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
        Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpazi.Eof())) {
          /* _gAzienda := cpazi->codazi // Azienda */
          _gAzienda = Cursor_cpazi.GetString("codazi");
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
        /* Utilities.SetCompany(_gAzienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_gAzienda);
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *,DAYSIMPORT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _numdays := intermbo->DAYSIMPORT */
          _numdays = CPLib.Round(Cursor_intermbo.GetDouble("DAYSIMPORT"),0);
          /* _numdcmb := intermbo->DAYSIMPCMB */
          _numdcmb = CPLib.Round(Cursor_intermbo.GetDouble("DAYSIMPCMB"),0);
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _dataestrai := arfn_dateminus(Date(),_numdays) */
        _dataestrai = arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),_numdays);
        /* _dataestcmb := arfn_dateminus(Date(),_numdcmb) */
        _dataestcmb = arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),_numdcmb);
        /* _import := 1 */
        _import = CPLib.Round(1,0);
        /* _messaggio := 'Ora Inizio Estrazione Transazioni del : '+arfn_fdate(_dataestrai)+" - Cambiavalute del "+arfn_fdate(_dataestcmb)+NL */
        _messaggio = "Ora Inizio Estrazione Transazioni del : "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestrai)+" - Cambiavalute del "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestcmb)+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := 'Ora Inizio Estrazione Transazioni del : '+arfn_fdate(_dataestrai)+" - Cambiavalute del "+arfn_fdate(_dataestcmb)+NL */
          gMsgProc = "Ora Inizio Estrazione Transazioni del : "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestrai)+" - Cambiavalute del "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestcmb)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // Cancella vecchi file esiti
        File di = new File(CPLib.LRTrim(_pathapp)+"/appo/"+CPLib.LRTrim(_gAzienda)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
        //  System.out.println(""+fl[_i]);
          fl[_i].delete();
        }
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione Agenzie: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione Agenzie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "Agenti" Page 2:Page_Agenti */
        Page_Agenti();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione Agenzie: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione Agenzie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* fhand := FileLibMit.OpenWrite('appo/'+LRTrim(_gAzienda)+"/AUITRX_"+DateToChar(_dataestrai)) */
        fhand = FileLibMit.OpenWrite("appo/"+CPLib.LRTrim(_gAzienda)+"/AUITRX_"+CPLib.DateToChar(_dataestrai));
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione SEND: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione SEND: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "TRX (Send)" Page 3:Page_TRX */
        Page_TRX();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione SEND: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione SEND: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione RECEIVE: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione RECEIVE: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "TRX (Receive)" Page 4:Page_RECEIVE */
        Page_RECEIVE();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione RECEIVE: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione RECEIVE: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione CANCELLAZIONI: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione CANCELLAZIONI: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "TRX (Delete)" Page 5:Page_DELETE */
        Page_DELETE();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione CANCELLAZIONI: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione CANCELLAZIONI: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione CAMBIAVALUTE: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione CAMBIAVALUTE: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "TRX (Cambiavalute)" Page 6:Page_CV */
        Page_CV();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione CAMBIAVALUTE: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione CAMBIAVALUTE: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione OTROS: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione OTROS: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "TRX (Scarti)" Page 7:Page_OTROS */
        Page_OTROS();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione OTROS: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione OTROS: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _messaggio := _messaggio + 'Ora Inizio Estrazione PERSNEW: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Inizio Estrazione PERSNEW: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "CLI (Variazioni)" Page 8:Page_CLIENTI */
        Page_CLIENTI();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione PERSNEW: '+arfn_fdatetime(DateTime())+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione PERSNEW: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_valutrans",354,"0000009B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000009B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_messaggio,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("ESTRAZIONE","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          throw new RoutineException();
        }
        /* _messaggio := _messaggio + 'Ora Fine Estrazione Transazioni del : '+arfn_fdate(_dataestrai)+" - Cambiavalute del "+arfn_fdate(_dataestcmb)+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione Transazioni del : "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestrai)+" - Cambiavalute del "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestcmb)+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* _import := 0 */
        _import = CPLib.Round(0,0);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* _messaggio := _messaggio + "Import Abortito. Presenti errori durante l'elaborazione! Contattare l'assistenza"+NL */
        _messaggio = _messaggio+"Import Abortito. Presenti errori durante l'elaborazione! Contattare l'assistenza"+"\n";
        /* _messaggio := _messaggio + 'Ora Fine Estrazione Transazioni del : '+arfn_fdate(_dataestrai)+" - Cambiavalute del "+arfn_fdate(_dataestcmb)+NL */
        _messaggio = _messaggio+"Ora Fine Estrazione Transazioni del : "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestrai)+" - Cambiavalute del "+arfn_fdateR.Make(m_Ctx,this).Run(_dataestcmb)+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_gAzienda)+"'",'',20) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_gAzienda)+"'","",20);
        // * --- Insert into log_app from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("log_app");
        m_cPhName = m_Ctx.GetPhName("log_app");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_valutrans",354,"000000A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000A6(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_messaggio+"\n"+"Errore durante la creazione dei file","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("ESTRAZIONE","?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
        m_cSql = m_cSql+")";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000005Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000005Astatus,cTry0000005Amsg);
        }
      }
      /* If _import=1 */
      if (CPLib.eqr(_import,1)) {
        /* Exec Routine arrt_import_rtra(pTipo) */
        arrt_import_rtraR.Make(m_Ctx,this).Run(pTipo);
      } else { // Else
      } // End If
    } finally {
      try {
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_mit_citta!=null)
          Cursor_vt_mit_citta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_paises!=null)
          Cursor_vt_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_regiones!=null)
          Cursor_vt_regiones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_mit_paises!=null)
          Cursor_vt_mit_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_Agenti() throws Exception {
    CPResultSet Cursor_qbe_vt_agentes=null;
    CPResultSet Cursor_vt_cis_agt_webaos=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* fhand := FileLibMit.OpenWrite('appo/'+LRTrim(_gAzienda)+"/AUIPOS_"+DateToChar(_dataestrai)) */
      fhand = FileLibMit.OpenWrite("appo/"+CPLib.LRTrim(_gAzienda)+"/AUIPOS_"+CPLib.DateToChar(_dataestrai));
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_vt_agentes
      if (Cursor_qbe_vt_agentes!=null)
        Cursor_qbe_vt_agentes.Close();
      Cursor_qbe_vt_agentes = new VQRHolder("qbe_vt_agentes",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_vt_agentes.Eof())) {
        /* _riga := Right('0000000000'+LRTrim(Str(qbe_vt_agentes->cod_agente,10,0)),10) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_agentes.GetDouble("cod_agente"),10,0)),10);
        /* _riga := _riga + LibreriaMit.SpacePad(qbe_vt_agentes->raz_social,100) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+LibreriaMit.SpacePad(Cursor_qbe_vt_agentes.GetString("raz_social"),100);
        /* _riga := _riga + LibreriaMit.SpacePad(qbe_vt_agentes->domicilio,100) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+LibreriaMit.SpacePad(Cursor_qbe_vt_agentes.GetString("domicilio"),100);
        /* _citta := '' */
        _citta = "";
        /* If mcMIT_CITTA.HasKey(qbe_vt_agentes->cod_ciudad) */
        if (mcMIT_CITTA.HasKey(Cursor_qbe_vt_agentes.GetDouble("cod_ciudad"))) {
          /* mcMIT_CITTA.GoToKey(qbe_vt_agentes->cod_ciudad) */
          mcMIT_CITTA.GoToKey(Cursor_qbe_vt_agentes.GetDouble("cod_ciudad"));
          /* _citta := mcMIT_CITTA.citta */
          _citta = mcMIT_CITTA.row.citta;
        } // End If
        /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_citta),50) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_citta),50);
        /* _nazage := '' */
        _nazage = "";
        /* _isonaz := '' */
        _isonaz = "";
        /* If mcPAISES.HasKey(qbe_vt_agentes->cod_pais_nacionalidad) */
        if (mcPAISES.HasKey(Cursor_qbe_vt_agentes.GetDouble("cod_pais_nacionalidad"))) {
          /* mcPAISES.GoToKey(qbe_vt_agentes->cod_pais_nacionalidad) */
          mcPAISES.GoToKey(Cursor_qbe_vt_agentes.GetDouble("cod_pais_nacionalidad"));
          /* _isonaz := mcPAISES.pais_q */
          _isonaz = mcPAISES.row.pais_q;
        } // End If
        /* If mcTBSTATI.HasKey(_isonaz) */
        if (mcTBSTATI.HasKey(_isonaz)) {
          /* mcTBSTATI.GoToKey(_isonaz) */
          mcTBSTATI.GoToKey(_isonaz);
          /* _nazage := mcTBSTATI.CODSTA */
          _nazage = mcTBSTATI.row.CODSTA;
        } // End If
        /* _riga := _riga + LibreriaMit.SpacePad(_nazage,3) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+LibreriaMit.SpacePad(_nazage,3);
        /* _datiaos := 0 */
        _datiaos = CPLib.Round(0,0);
        // * --- Select from vt_cis_agt_webaos
        m_cServer = m_Ctx.GetServer("vt_cis_agt_webaos");
        m_cPhName = m_Ctx.GetPhName("vt_cis_agt_webaos");
        if (Cursor_vt_cis_agt_webaos!=null)
          Cursor_vt_cis_agt_webaos.Close();
        Cursor_vt_cis_agt_webaos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_agente="+CPLib.ToSQL(Cursor_qbe_vt_agentes.GetDouble("cod_agente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cis_agt_webaos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_vt_cis_agt_webaos.Eof())) {
          /* _datiaos := 1 */
          _datiaos = CPLib.Round(1,0);
          /* _riga := _riga + LibreriaMit.SpacePad(vt_cis_agt_webaos->AnomOperRis,2) // Riga su cui scrivere i dati prima di scriverli sul file */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_vt_cis_agt_webaos.GetString("AnomOperRis"),2);
          /* _riga := _riga + LibreriaMit.SpacePad(vt_cis_agt_webaos->visitComp,2) // Riga su cui scrivere i dati prima di scriverli sul file */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_vt_cis_agt_webaos.GetString("visitComp"),2);
          /* _riga := _riga + Str(vt_cis_agt_webaos->OperSos_agt,10,0) // Riga su cui scrivere i dati prima di scriverli sul file */
          _riga = _riga+CPLib.Str(Cursor_vt_cis_agt_webaos.GetDouble("OperSos_agt"),10,0);
          /* _riga := _riga + Str(vt_cis_agt_webaos->OperSos_CBA,10,0) // Riga su cui scrivere i dati prima di scriverli sul file */
          _riga = _riga+CPLib.Str(Cursor_vt_cis_agt_webaos.GetDouble("OperSos_CBA"),10,0);
          Cursor_vt_cis_agt_webaos.Next();
        }
        m_cConnectivityError = Cursor_vt_cis_agt_webaos.ErrorMessage();
        Cursor_vt_cis_agt_webaos.Close();
        // * --- End Select
        /* If _datiaos=0 */
        if (CPLib.eqr(_datiaos,0)) {
          /* _riga := _riga + '0000         0         0' // Riga su cui scrivere i dati prima di scriverli sul file */
          _riga = _riga+"0000         0         0";
        } // End If
        /* _riga := _riga + LibreriaMit.SpacePad(qbe_vt_agentes->nom_corto,10) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+LibreriaMit.SpacePad(Cursor_qbe_vt_agentes.GetString("nom_corto"),10);
        /* _regione := '' */
        _regione = "";
        /* If mcREGIONES.HasKey(qbe_vt_agentes->id_cr_bancos) */
        if (mcREGIONES.HasKey(Cursor_qbe_vt_agentes.GetDouble("id_cr_bancos"))) {
          /* mcREGIONES.GoToKey(qbe_vt_agentes->id_cr_bancos) */
          mcREGIONES.GoToKey(Cursor_qbe_vt_agentes.GetDouble("id_cr_bancos"));
          /* _regione := mcREGIONES.codice_MIT */
          _regione = mcREGIONES.row.codice_MIT;
        } // End If
        /* _riga := _riga + LibreriaMit.SpacePad(_regione,2) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+LibreriaMit.SpacePad(_regione,2);
        /* _riga := _riga + iif(qbe_vt_agentes->prioridad='A' or qbe_vt_agentes->prioridad='B','S','N') // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+(CPLib.eqr(Cursor_qbe_vt_agentes.GetString("prioridad"),"A") || CPLib.eqr(Cursor_qbe_vt_agentes.GetString("prioridad"),"B")?"S":"N");
        /* _riga := _riga + Left(LRTrim(qbe_vt_agentes->cod_postal),5) // Riga su cui scrivere i dati prima di scriverli sul file */
        _riga = _riga+CPLib.Left(CPLib.LRTrim(Cursor_qbe_vt_agentes.GetString("cod_postal")),5);
        /* FileLibMit.WriteLine(fhand,_riga) */
        FileLibMit.WriteLine(fhand,_riga);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        Cursor_qbe_vt_agentes.Next();
      }
      m_cConnectivityError = Cursor_qbe_vt_agentes.ErrorMessage();
      Cursor_qbe_vt_agentes.Close();
      // * --- End Select
      // Chiude il file e cancella se vuoto
      FileLibMit.Close(fhand);
      if (_conta==0) {
        FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(_gAzienda)+"/AUIPOS_"+CPLib.DateToChar(_dataestrai));
      }
      /* _messaggio := _messaggio + 'Estrazione Agenzie - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
      _messaggio = _messaggio+"Estrazione Agenzie - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      /* If pTipo='O' */
      if (CPLib.eqr(pTipo,"O")) {
        /* gMsgProc := _messaggio */
        gMsgProc = _messaggio;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_vt_agentes!=null)
          Cursor_qbe_vt_agentes.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cis_agt_webaos!=null)
          Cursor_vt_cis_agt_webaos.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_TRX() throws Exception {
    CPResultSet Cursor_qbe_vt_giros=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_vt_historico_giros=null;
    CPResultSet Cursor_qbe_vt_cliente_lastmod=null;
    CPResultSet Cursor_vt_cliente=null;
    CPResultSet Cursor_vt_documentos=null;
    CPResultSet Cursor_vt_ocupaciones=null;
    CPResultSet Cursor_vt_ide_ctbe_bol=null;
    CPResultSet Cursor_vt_paises=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_vt_giros
      SPBridge.HMCaller _h000000D7;
      _h000000D7 = new SPBridge.HMCaller();
      _h000000D7.Set("m_cVQRList",m_cVQRList);
      _h000000D7.Set("_dataestrai",_dataestrai);
      if (Cursor_qbe_vt_giros!=null)
        Cursor_qbe_vt_giros.Close();
      Cursor_qbe_vt_giros = new VQRHolder("qbe_vt_giros",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000D7,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_vt_giros.Eof())) {
        /* If Empty(qbe_vt_giros->age_prueba) */
        if (CPLib.Empty(Cursor_qbe_vt_giros.GetDouble("age_prueba"))) {
          /* If pTipo='O' */
          if (CPLib.eqr(pTipo,"O")) {
            /* gMsgImp := 'Elaboro Send con codice: '+qbe_vt_giros->folio // Messaggio Import */
            gMsgImp = "Elaboro Send con codice: "+Cursor_qbe_vt_giros.GetString("folio");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _ntrx := iif(qbe_vt_giros->id_forma_pago='01',1,2) */
          _ntrx = CPLib.Round((CPLib.eqr(Cursor_qbe_vt_giros.GetString("id_forma_pago"),"01")?1:2),0);
          /* _connes := '' */
          _connes = "";
          // * --- Read from vt_cis_mit_cliente_connes
          m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
          m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
          m_cSql = "";
          m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_vt_giros.GetDouble("cod_cliente"));
          if (m_Ctx.IsSharedTemp("vt_cis_mit_cliente_connes")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("connes",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("connes");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_cis_mit_cliente_connes into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_connes)) */
          if ( ! (CPLib.Empty(_connes))) {
            /* _riga := LibreriaMit.SpacePad(LRTrim(_connes),16) */
            _riga = LibreriaMit.SpacePad(CPLib.LRTrim(_connes),16);
          } else { // Else
            /* _riga := 'C'+Right('000000000000000'+LRTrim(Str(qbe_vt_giros->cod_cliente,10,0)),15) */
            _riga = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),10,0)),15);
            /* _connes := 'C'+Right('000000000000000'+LRTrim(Str(qbe_vt_giros->cod_cliente,10,0)),15) */
            _connes = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),10,0)),15);
            // * --- Insert into vt_cis_mit_cliente_connes from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
            m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"vt_cis_mit_cliente_connes",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_valutrans",354,"000000E2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E2(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),10,0)),15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"vt_cis_mit_cliente_connes",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          // * --- Select from vt_historico_giros
          m_cServer = m_Ctx.GetServer("vt_historico_giros");
          m_cPhName = m_Ctx.GetPhName("vt_historico_giros");
          if (Cursor_vt_historico_giros!=null)
            Cursor_vt_historico_giros.Close();
          Cursor_vt_historico_giros = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"folio="+CPLib.ToSQL(Cursor_qbe_vt_giros.GetString("folio"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_historico_giros")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_vt_historico_giros.Eof())) {
            /* _capcli := vt_historico_giros->CP_cte */
            _capcli = Cursor_vt_historico_giros.GetString("CP_cte");
            /* If _ntrx=2 */
            if (CPLib.eqr(_ntrx,2)) {
              /* _cabdip := '' */
              _cabdip = "";
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),"C",6,0,m_cServer),m_cServer,CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6));
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cabdip = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cabdip = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _lastmod := NullDate() */
              _lastmod = CPLib.NullDate();
              // * --- Select from qbe_vt_cliente_lastmod
              SPBridge.HMCaller _h000000E9;
              _h000000E9 = new SPBridge.HMCaller();
              _h000000E9.Set("m_cVQRList",m_cVQRList);
              _h000000E9.Set("pTipo",1);
              _h000000E9.Set("pCodice","%"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),10,0))+"%");
              if (Cursor_qbe_vt_cliente_lastmod!=null)
                Cursor_qbe_vt_cliente_lastmod.Close();
              Cursor_qbe_vt_cliente_lastmod = new VQRHolder("qbe_vt_cliente_lastmod",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000E9,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_vt_cliente_lastmod.Eof())) {
                /* _lastmod := qbe_vt_cliente_lastmod->fecha_registro */
                _lastmod = Cursor_qbe_vt_cliente_lastmod.GetDate("fecha_registro");
                Cursor_qbe_vt_cliente_lastmod.Next();
              }
              m_cConnectivityError = Cursor_qbe_vt_cliente_lastmod.ErrorMessage();
              Cursor_qbe_vt_cliente_lastmod.Close();
              // * --- End Select
              /* If not(Empty(_lastmod)) and _lastmod >= _dataestrai and _lastmod <= Date() */
              if ( ! (CPLib.Empty(_lastmod)) && CPLib.ge(_lastmod,_dataestrai) && CPLib.le(_lastmod,CPLib.Date())) {
                // * --- Select from vt_cliente
                m_cServer = m_Ctx.GetServer("vt_cliente");
                m_cPhName = m_Ctx.GetPhName("vt_cliente");
                if (Cursor_vt_cliente!=null)
                  Cursor_vt_cliente.Close();
                Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_cliente.Eof())) {
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),50) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),50);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),50) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),50);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),100) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),100);
                  /* _riga := _riga + iif(Len(LRTrim(vt_cliente->cve_identificacion)) < 16,'N','S') */
                  _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)?"N":"S");
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
                  /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
                  if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
                    /* _paisnas := vt_cliente->cod_paisnacim */
                    _paisnas = CPLib.Round(Cursor_vt_cliente.GetDouble("cod_paisnacim"),0);
                    /* _statomit := '' */
                    _statomit = "";
                    /* If mcMIT_PAISES.HasKey(_paisnas) */
                    if (mcMIT_PAISES.HasKey(_paisnas)) {
                      /* mcMIT_PAISES.GoToKey(_paisnas) */
                      mcMIT_PAISES.GoToKey(_paisnas);
                      /* _statomit := mcMIT_PAISES.cod_mit */
                      _statomit = mcMIT_PAISES.row.cod_mit;
                    } // End If
                    /* If mcTBSTATI_AUI.HasKey(_statomit) */
                    if (mcTBSTATI_AUI.HasKey(_statomit)) {
                      /* mcTBSTATI_AUI.GoToKey(_statomit) */
                      mcTBSTATI_AUI.GoToKey(_statomit);
                      /* _luonas := mcTBSTATI_AUI.DESCRI */
                      _luonas = mcTBSTATI_AUI.row.DESCRI;
                    } // End If
                  } else { // Else
                    /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
                    if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                      /* If mcTBSTATI_SIG.HasKey(Substr(vt_cliente->cve_identificacion,12,4)) */
                      if (mcTBSTATI_SIG.HasKey(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4))) {
                        /* mcTBSTATI_SIG.GoToKey(Substr(vt_cliente->cve_identificacion,12,4)) */
                        mcTBSTATI_SIG.GoToKey(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                        /* _luonas := mcTBSTATI_SIG.DESCRI */
                        _luonas = mcTBSTATI_SIG.row.DESCRI;
                      } // End If
                    } else { // Else
                      /* If mcTBCITTA_SIG.HasKey(Substr(vt_cliente->cve_identificacion,12,4)) */
                      if (mcTBCITTA_SIG.HasKey(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4))) {
                        /* mcTBCITTA_SIG.GoToKey(Substr(vt_cliente->cve_identificacion,12,4)) */
                        mcTBCITTA_SIG.GoToKey(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                        /* _luonas := mcTBCITTA_SIG.CITTA */
                        _luonas = mcTBCITTA_SIG.row.CITTA;
                      } // End If
                    } // End If
                    /* If Empty(_luonas) */
                    if (CPLib.Empty(_luonas)) {
                      /* If Left(vt_cliente->cve_cardex,1)='Z' */
                      if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                        /* If mcTBSTATI_SIG.HasKey(LRTrim(vt_cliente->cve_cardex)) */
                        if (mcTBSTATI_SIG.HasKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")))) {
                          /* mcTBSTATI_SIG.GoToKey(LRTrim(vt_cliente->cve_cardex)) */
                          mcTBSTATI_SIG.GoToKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                          /* _luonas := mcTBSTATI_SIG.DESCRI */
                          _luonas = mcTBSTATI_SIG.row.DESCRI;
                        } // End If
                      } else { // Else
                        /* If mcTBCITTA_SIG.HasKey(LRTrim(vt_cliente->cve_cardex)) */
                        if (mcTBCITTA_SIG.HasKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")))) {
                          /* mcTBCITTA_SIG.GoToKey(LRTrim(vt_cliente->cve_cardex)) */
                          mcTBCITTA_SIG.GoToKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                          /* _luonas := mcTBCITTA_SIG.CITTA */
                          _luonas = mcTBCITTA_SIG.row.CITTA;
                        } // End If
                      } // End If
                    } // End If
                  } // End If
                  Cursor_vt_cliente.Next();
                }
                m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                Cursor_vt_cliente.Close();
                // * --- End Select
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_cte)+" "+LRTrim(vt_historico_giros->seg_apellido_cte),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_cte"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_cte")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_cliente),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_cliente")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->domicilio_cte)+","+LRTrim(vt_historico_giros->num_domicilio_cte),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_cte"))+","+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_cte")),100);
                /* _riga := _riga + iif(Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16,'N','S') */
                _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)?"N":"S");
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->cod_fiscal_cte),16) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte")),16);
                /* _luonas := '' */
                _luonas = "";
                /* If Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16 */
                if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)) {
                  /* _paisnas := 0 */
                  _paisnas = CPLib.Round(0,0);
                  // * --- Read from vt_cliente
                  m_cServer = m_Ctx.GetServer("vt_cliente");
                  m_cPhName = m_Ctx.GetPhName("vt_cliente");
                  m_cSql = "";
                  m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_vt_giros.GetDouble("cod_cliente"));
                  if (m_Ctx.IsSharedTemp("vt_cliente")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_paisnacim",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _paisnas = CPLib.Round(Read_Cursor.GetDouble("cod_paisnacim"),0);
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_cliente into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _paisnas = 0;
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _statomit := '' */
                  _statomit = "";
                  /* If mcMIT_PAISES.HasKey(_paisnas) */
                  if (mcMIT_PAISES.HasKey(_paisnas)) {
                    /* mcMIT_PAISES.GoToKey(_paisnas) */
                    mcMIT_PAISES.GoToKey(_paisnas);
                    /* _statomit := mcMIT_PAISES.cod_mit */
                    _statomit = mcMIT_PAISES.row.cod_mit;
                  } // End If
                  /* If mcTBSTATI_AUI.HasKey(_statomit) */
                  if (mcTBSTATI_AUI.HasKey(_statomit)) {
                    /* mcTBSTATI_AUI.GoToKey(_statomit) */
                    mcTBSTATI_AUI.GoToKey(_statomit);
                    /* _luonas := mcTBSTATI_AUI.DESCRI */
                    _luonas = mcTBSTATI_AUI.row.DESCRI;
                  } // End If
                } else { // Else
                  /* If Substr(vt_historico_giros->cod_fiscal_cte,12,1)='Z' */
                  if (CPLib.eqr(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,1),"Z")) {
                    /* If mcTBSTATI_SIG.HasKey(Substr(vt_historico_giros->cod_fiscal_cte,12,4)) */
                    if (mcTBSTATI_SIG.HasKey(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4))) {
                      /* mcTBSTATI_SIG.GoToKey(Substr(vt_historico_giros->cod_fiscal_cte,12,4)) */
                      mcTBSTATI_SIG.GoToKey(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                      /* _luonas := mcTBSTATI_SIG.DESCRI */
                      _luonas = mcTBSTATI_SIG.row.DESCRI;
                    } // End If
                  } else { // Else
                    /* If mcTBCITTA_SIG.HasKey(Substr(vt_historico_giros->cod_fiscal_cte,12,4)) */
                    if (mcTBCITTA_SIG.HasKey(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4))) {
                      /* mcTBCITTA_SIG.GoToKey(Substr(vt_historico_giros->cod_fiscal_cte,12,4)) */
                      mcTBCITTA_SIG.GoToKey(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                      /* _luonas := mcTBCITTA_SIG.CITTA */
                      _luonas = mcTBCITTA_SIG.row.CITTA;
                    } // End If
                  } // End If
                  /* If Empty(_luonas) */
                  if (CPLib.Empty(_luonas)) {
                    // * --- Select from vt_cliente
                    m_cServer = m_Ctx.GetServer("vt_cliente");
                    m_cPhName = m_Ctx.GetPhName("vt_cliente");
                    if (Cursor_vt_cliente!=null)
                      Cursor_vt_cliente.Close();
                    Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cve_cardex  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_vt_cliente.Eof())) {
                      /* If Left(vt_cliente->cve_cardex,1)='Z' */
                      if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                        /* If mcTBSTATI_SIG.HasKey(LRTrim(vt_cliente->cve_cardex)) */
                        if (mcTBSTATI_SIG.HasKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")))) {
                          /* mcTBSTATI_SIG.GoToKey(LRTrim(vt_cliente->cve_cardex)) */
                          mcTBSTATI_SIG.GoToKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                          /* _luonas := mcTBSTATI_SIG.DESCRI */
                          _luonas = mcTBSTATI_SIG.row.DESCRI;
                        } // End If
                      } else { // Else
                        /* If mcTBCITTA_SIG.HasKey(LRTrim(vt_cliente->cve_cardex)) */
                        if (mcTBCITTA_SIG.HasKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")))) {
                          /* mcTBCITTA_SIG.GoToKey(LRTrim(vt_cliente->cve_cardex)) */
                          mcTBCITTA_SIG.GoToKey(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                          /* _luonas := mcTBCITTA_SIG.CITTA */
                          _luonas = mcTBCITTA_SIG.row.CITTA;
                        } // End If
                      } // End If
                      Cursor_vt_cliente.Next();
                    }
                    m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                    Cursor_vt_cliente.Close();
                    // * --- End Select
                  } // End If
                } // End If
              } // End If
              /* If Empty(LRTrim(_luonas)) */
              if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                /* _luonas := LRTrim(vt_historico_giros->nompaisnac) */
                _luonas = CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nompaisnac"));
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_luonas),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->num_identificacion_cte),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),30);
              /* _riga := _riga + iif(Empty(vt_historico_giros->fecha_vencimiento_ident),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fecha_vencimiento_ident),8)) */
              _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident")),8));
              /* _riga := _riga + iif(Empty(vt_historico_giros->fec_alta_id),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fec_alta_id),8)) */
              _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fec_alta_id"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fec_alta_id")),8));
              /* _autorita := '' */
              _autorita = "";
              /* _iddocumento := 0 */
              _iddocumento = CPLib.Round(0,0);
              // * --- Select from vt_documentos
              m_cServer = m_Ctx.GetServer("vt_documentos");
              m_cPhName = m_Ctx.GetPhName("vt_documentos");
              if (Cursor_vt_documentos!=null)
                Cursor_vt_documentos.Close();
              Cursor_vt_documentos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")))+" "+")"+(m_Ctx.IsSharedTemp("vt_documentos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"id_documento desc ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_documentos.Eof())) {
                /* _paesedoc := vt_documentos->id_pais */
                _paesedoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_pais"),0);
                /* _datainidoc := vt_documentos->fecha_alta */
                _datainidoc = Cursor_vt_documentos.GetDate("fecha_alta");
                /* _datafindoc := vt_documentos->fecha_vencimiento */
                _datafindoc = Cursor_vt_documentos.GetDate("fecha_vencimiento");
                /* _autorita := vt_documentos->institucion_expide */
                _autorita = Cursor_vt_documentos.GetString("institucion_expide");
                /* _iddocumento := vt_documentos->id_documento */
                _iddocumento = CPLib.Round(Cursor_vt_documentos.GetDouble("id_documento"),0);
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_vt_documentos.Next();
              }
              m_cConnectivityError = Cursor_vt_documentos.ErrorMessage();
              Cursor_vt_documentos.Close();
              // * --- End Select
              /* If _iddocumento=0 */
              if (CPLib.eqr(_iddocumento,0)) {
                // * --- Read from vt_documentos_bit
                m_cServer = m_Ctx.GetServer("vt_documentos_bit");
                m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
                m_cSql = "";
                m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("cod_cliente"));
                m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")));
                if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _iddocumento = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _iddocumento <> 0 */
                if (CPLib.ne(_iddocumento,0)) {
                  // * --- Read from vt_documentos
                  m_cServer = m_Ctx.GetServer("vt_documentos");
                  m_cPhName = m_Ctx.GetPhName("vt_documentos");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                  if (m_Ctx.IsSharedTemp("vt_documentos")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                    _datainidoc = Read_Cursor.GetDate("fecha_alta");
                    _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                    _autorita = Read_Cursor.GetString("institucion_expide");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _paesedoc = 0;
                    _datainidoc = CPLib.NullDate();
                    _datafindoc = CPLib.NullDate();
                    _autorita = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
              } // End If
              /* If _iddocumento <> 0 */
              if (CPLib.ne(_iddocumento,0)) {
                /* If _paesedoc=380 */
                if (CPLib.eqr(_paesedoc,380)) {
                  /* _codinstu := 0 */
                  _codinstu = CPLib.Round(0,0);
                  /* _comrila := '' */
                  _comrila = "";
                  // * --- Read from vt_documento_extras
                  m_cServer = m_Ctx.GetServer("vt_documento_extras");
                  m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                  if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                    _comrila = Read_Cursor.GetString("comune");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codinstu = 0;
                    _comrila = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If _codinstu <> 0 */
                  if (CPLib.ne(_codinstu,0)) {
                    /* _desaut := '' */
                    _desaut = "";
                    // * --- Read from vt_doc_catinstitucionexpide
                    m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                    m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                    m_cSql = "";
                    m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                    if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _desaut = Read_Cursor.GetString("descripcion");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _desaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _descitaut := '' */
                    _descitaut = "";
                    /* If mcTBCITTA_SIG.HasKey(LRTrim(_comrila)) */
                    if (mcTBCITTA_SIG.HasKey(CPLib.LRTrim(_comrila))) {
                      /* mcTBCITTA_SIG.GoToKey(LRTrim(_comrila)) */
                      mcTBCITTA_SIG.GoToKey(CPLib.LRTrim(_comrila));
                      /* _descitaut := mcTBCITTA_SIG.CITTA */
                      _descitaut = mcTBCITTA_SIG.row.CITTA;
                      /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                      _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                    } // End If
                  } else { // Else
                    /* If not(Empty(_comrila)) */
                    if ( ! (CPLib.Empty(_comrila))) {
                      /* If mcTBCITTA_SIG.HasKey(LRTrim(_comrila)) */
                      if (mcTBCITTA_SIG.HasKey(CPLib.LRTrim(_comrila))) {
                        /* mcTBCITTA_SIG.GoToKey(LRTrim(_comrila)) */
                        mcTBCITTA_SIG.GoToKey(CPLib.LRTrim(_comrila));
                        /* _descitaut := mcTBCITTA_SIG.CITTA */
                        _descitaut = mcTBCITTA_SIG.row.CITTA;
                        /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                        _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                      } // End If
                    } else { // Else
                      /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                      _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                    } // End If
                  } // End If
                } else { // Else
                  /* If mcPAISES.HasKey(_paesedoc) */
                  if (mcPAISES.HasKey(_paesedoc)) {
                    /* mcPAISES.GoToKey(_paesedoc) */
                    mcPAISES.GoToKey(_paesedoc);
                    /* _descitaut := mcPAISES.nom_pais */
                    _descitaut = mcPAISES.row.nom_pais;
                    /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                    _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                  } // End If
                } // End If
              } else { // Else
                /* If mcPAISES.HasKey(_paesedoc) */
                if (mcPAISES.HasKey(_paesedoc)) {
                  /* mcPAISES.GoToKey(_paesedoc) */
                  mcPAISES.GoToKey(_paesedoc);
                  /* _descitaut := mcPAISES.nom_pais */
                  _descitaut = mcPAISES.row.nom_pais;
                  /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                  _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                } // End If
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,50)),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,50)),50);
              /* _codmit := '' */
              _codmit = "";
              /* If vt_historico_giros->id_pais_cte=380 */
              if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
                /* _codmit := '086' */
                _codmit = "086";
                /* _desmit := 'ITALIA' */
                _desmit = "ITALIA";
              } else { // Else
                /* If mcMIT_PAISES.HasKey(vt_historico_giros->id_pais_cte) */
                if (mcMIT_PAISES.HasKey(Cursor_vt_historico_giros.GetDouble("id_pais_cte"))) {
                  /* mcMIT_PAISES.GoToKey(vt_historico_giros->id_pais_cte) */
                  mcMIT_PAISES.GoToKey(Cursor_vt_historico_giros.GetDouble("id_pais_cte"));
                  /* _codmit := mcMIT_PAISES.cod_mit */
                  _codmit = mcMIT_PAISES.row.cod_mit;
                } // End If
                /* If mcTBSTATI_AUI.HasKey(_codmit) */
                if (mcTBSTATI_AUI.HasKey(_codmit)) {
                  /* mcTBSTATI_AUI.GoToKey(_codmit) */
                  mcTBSTATI_AUI.GoToKey(_codmit);
                  /* _desmit := mcTBSTATI_AUI.DESCRI */
                  _desmit = mcTBSTATI_AUI.row.DESCRI;
                } // End If
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(iif(Empty(_desmit),vt_historico_giros->nom_pais_cte,_desmit)),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim((CPLib.Empty(_desmit)?Cursor_vt_historico_giros.GetString("nom_pais_cte"):_desmit)),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_ciudad_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_cte")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->doc_codice),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("doc_codice")),2);
              /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(qbe_vt_giros->fec_captura),8) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_qbe_vt_giros.GetDate("fec_captura")),8);
              /* _riga := _riga + 'N' */
              _riga = _riga+"N";
              /* _riga := _riga + 'A' */
              _riga = _riga+"A";
              /* _riga := _riga + Right('000000000000000'+LRTrim(Str(vt_historico_giros->cantidad_trans*100,15,0)),15) */
              _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cantidad_trans")*100,15,0)),15);
              /* _riga := _riga + Replicate('0',15) */
              _riga = _riga+CPLib.Replicate("0",15);
              /* _riga := _riga + '10000'+Space(5) */
              _riga = _riga+"10000"+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(Right('000000'+LRTrim(Str(vt_historico_giros->cod_agente,10,0)),6),10) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),10);
              /* _foliocli := 0 */
              _foliocli = CPLib.Round(0,0);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_cte)+" "+LRTrim(vt_historico_giros->seg_apellido_cte),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_cte"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_cte")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_cliente),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_cliente")),100);
              /* _codstades := '' // Codice Stato Destinazione */
              _codstades = "";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_pais_cte),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_pais_cte")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_ciudad_cte),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_cte")),30);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->domicilio_cte)+","+LRTrim(vt_historico_giros->num_domicilio_cte),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_cte"))+","+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_cte")),30);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_capcli),5) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_capcli),5);
              /* _riga := _riga + Space(5) */
              _riga = _riga+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(Right(LRTrim(vt_historico_giros->fec_nacim),4)+Substr(LRTrim(vt_historico_giros->fec_nacim),4,2)+Left(LRTrim(vt_historico_giros->fec_nacim),2),8) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Right(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4)+CPLib.Substr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4,2)+CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),2),8);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->sexo),1) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("sexo")),1);
              /* If LRTrim(vt_historico_giros->id_divisa_cte)='DLS' */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),"DLS")) {
                /* _riga := _riga + 'USD ' */
                _riga = _riga+"USD ";
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_divisa_cte),4) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),4);
              } // End If
              /* _riga := _riga + 'I' */
              _riga = _riga+"I";
              /* _riga := _riga + Space(5) */
              _riga = _riga+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->folio)+"-D",18) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("folio"))+"-D",18);
              /* _regval := 0 */
              _regval = CPLib.Round(0,0);
              /* _regione := '' */
              _regione = "";
              // * --- Read from vt_estados
              m_cServer = m_Ctx.GetServer("vt_estados");
              m_cPhName = m_Ctx.GetPhName("vt_estados");
              m_cSql = "";
              m_cSql = m_cSql+"cve_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetString("id_estado_cte"),"C",5,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetString("id_estado_cte"));
              m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_cte"));
              if (m_Ctx.IsSharedTemp("vt_estados")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _regval = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from vt_regiones
              m_cServer = m_Ctx.GetServer("vt_regiones");
              m_cPhName = m_Ctx.GetPhName("vt_regiones");
              m_cSql = "";
              m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
              if (m_Ctx.IsSharedTemp("vt_regiones")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _regione = Read_Cursor.GetString("codice_MIT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _regione = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If mcREGIONES.HasKey(_regval) */
              if (mcREGIONES.HasKey(_regval)) {
                /* mcREGIONES.GoToKey(_regval) */
                mcREGIONES.GoToKey(_regval);
                /* _regione := mcREGIONES.codice_MIT */
                _regione = mcREGIONES.row.codice_MIT;
              } // End If
              /* If Empty(_regione) */
              if (CPLib.Empty(_regione)) {
                /* _riga := _riga + '00' */
                _riga = _riga+"00";
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
              } // End If
              /* _occupazione := 0 */
              _occupazione = CPLib.Round(0,0);
              // * --- Select from vt_ocupaciones
              m_cServer = m_Ctx.GetServer("vt_ocupaciones");
              m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
              if (Cursor_vt_ocupaciones!=null)
                Cursor_vt_ocupaciones.Close();
              Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_ocupaciones.Eof())) {
                /* _occupazione := vt_ocupaciones->id_tipoocupacion */
                _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
                Cursor_vt_ocupaciones.Next();
              }
              m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
              Cursor_vt_ocupaciones.Close();
              // * --- End Select
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
              /* _bl := 0 */
              _bl = CPLib.Round(0,0);
              // * --- Select from vt_ide_ctbe_bol
              m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
              m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
              if (Cursor_vt_ide_ctbe_bol!=null)
                Cursor_vt_ide_ctbe_bol.Close();
              Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
                /* _bl := 1 */
                _bl = CPLib.Round(1,0);
                Cursor_vt_ide_ctbe_bol.Next();
              }
              m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
              Cursor_vt_ide_ctbe_bol.Close();
              // * --- End Select
              /* _riga := _riga + iif(_bl=1,'S','N') */
              _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _emettidoc := 'IT' */
                _emettidoc = "IT";
                /* ElseIf _paesedoc=0 */
              } else if (CPLib.eqr(_paesedoc,0)) {
                /* _emettidoc := 'ND' */
                _emettidoc = "ND";
              } else { // Else
                // * --- Read from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
                if (m_Ctx.IsSharedTemp("vt_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If mcPAISES.HasKey(_paesedoc) */
                if (mcPAISES.HasKey(_paesedoc)) {
                  /* mcPAISES.GoToKey(_paesedoc) */
                  mcPAISES.GoToKey(_paesedoc);
                  /* _paesedoc := mcPAISES.con_edocta */
                  _paesedoc = CPLib.Round(mcPAISES.row.con_edocta,0);
                } // End If
                /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
                _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
              /* _riga := _riga + Space(3) */
              _riga = _riga+CPLib.Space(3);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(vt_historico_giros->cod_cliente,10,0)),10) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_cliente"),10,0)),10);
              /* If vt_historico_giros->id_pais_cte=380 */
              if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_estado_cte),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_estado_cte")),2);
              } else { // Else
                /* _riga := _riga + 'EE' */
                _riga = _riga+"EE";
              } // End If
              /* _riga := _riga + '02' */
              _riga = _riga+"02";
              /* _riga := _riga + Space(50) */
              _riga = _riga+CPLib.Space(50);
              /* _riga := _riga + '086' */
              _riga = _riga+"086";
              /* _riga := _riga + Space(6) */
              _riga = _riga+CPLib.Space(6);
              /* _riga := _riga+Space(10) */
              _riga = _riga+CPLib.Space(10);
              /* _riga := _riga+Space(10) */
              _riga = _riga+CPLib.Space(10);
              /* _riga := _riga+qbe_vt_giros->cod_status */
              _riga = _riga+Cursor_qbe_vt_giros.GetString("cod_status");
              /* FileLibMit.WriteLine(fhand,_riga) */
              FileLibMit.WriteLine(fhand,_riga);
              /* If not(Empty(qbe_vt_giros->connes)) */
              if ( ! (CPLib.Empty(Cursor_qbe_vt_giros.GetString("connes")))) {
                /* _riga := LibreriaMit.SpacePad(LRTrim(qbe_vt_giros->connes),16) */
                _riga = LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_vt_giros.GetString("connes")),16);
              } else { // Else
                /* _riga := 'C'+Right('000000000000000'+LRTrim(Str(qbe_vt_giros->cod_cliente,10,0)),15) */
                _riga = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),10,0)),15);
              } // End If
            } // End If
            /* _cabdip := '' */
            _cabdip = "";
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),"C",6,0,m_cServer),m_cServer,CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _cabdip = Read_Cursor.GetString("CAB");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _cabdip = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _lastmod := NullDate() */
            _lastmod = CPLib.NullDate();
            // * --- Select from qbe_vt_cliente_lastmod
            SPBridge.HMCaller _h000001AF;
            _h000001AF = new SPBridge.HMCaller();
            _h000001AF.Set("m_cVQRList",m_cVQRList);
            _h000001AF.Set("pTipo",1);
            _h000001AF.Set("pCodice","%"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),10,0))+"%");
            if (Cursor_qbe_vt_cliente_lastmod!=null)
              Cursor_qbe_vt_cliente_lastmod.Close();
            Cursor_qbe_vt_cliente_lastmod = new VQRHolder("qbe_vt_cliente_lastmod",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001AF,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_vt_cliente_lastmod.Eof())) {
              /* _lastmod := qbe_vt_cliente_lastmod->fecha_registro */
              _lastmod = Cursor_qbe_vt_cliente_lastmod.GetDate("fecha_registro");
              Cursor_qbe_vt_cliente_lastmod.Next();
            }
            m_cConnectivityError = Cursor_qbe_vt_cliente_lastmod.ErrorMessage();
            Cursor_qbe_vt_cliente_lastmod.Close();
            // * --- End Select
            /* If not(Empty(_lastmod)) and _lastmod >= _dataestrai and _lastmod <= Date() */
            if ( ! (CPLib.Empty(_lastmod)) && CPLib.ge(_lastmod,_dataestrai) && CPLib.le(_lastmod,CPLib.Date())) {
              // * --- Select from vt_cliente
              m_cServer = m_Ctx.GetServer("vt_cliente");
              m_cPhName = m_Ctx.GetPhName("vt_cliente");
              if (Cursor_vt_cliente!=null)
                Cursor_vt_cliente.Close();
              Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_cliente.Eof())) {
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),100);
                /* _riga := _riga + iif(Len(LRTrim(vt_cliente->cve_identificacion)) < 16,'N','S') */
                _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)?"N":"S");
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
                /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
                if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
                  /* _paisnas := vt_cliente->cod_paisnacim */
                  _paisnas = CPLib.Round(Cursor_vt_cliente.GetDouble("cod_paisnacim"),0);
                  /* _statomit := '' */
                  _statomit = "";
                  // * --- Read from vt_mit_paises
                  m_cServer = m_Ctx.GetServer("vt_mit_paises");
                  m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                  m_cSql = "";
                  m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                  if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _statomit = Read_Cursor.GetString("cod_mit");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _statomit = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
                  if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                  /* If Empty(_luonas) */
                  if (CPLib.Empty(_luonas)) {
                    /* If Left(vt_cliente->cve_cardex,1)='Z' */
                    if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                      // * --- Read from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbstati")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("DESCRI");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } else { // Else
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                  } // End If
                } // End If
                Cursor_vt_cliente.Next();
              }
              m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
              Cursor_vt_cliente.Close();
              // * --- End Select
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_cte)+" "+LRTrim(vt_historico_giros->seg_apellido_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_cte"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_cte")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_cliente),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_cliente")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->domicilio_cte)+","+LRTrim(vt_historico_giros->num_domicilio_cte),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_cte"))+","+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_cte")),100);
              /* _riga := _riga + iif(Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16,'N','S') */
              _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)?"N":"S");
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->cod_fiscal_cte),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte")),16);
              /* _luonas := '' */
              _luonas = "";
              /* If Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)) {
                /* _paisnas := 0 */
                _paisnas = CPLib.Round(0,0);
                // * --- Read from vt_cliente
                m_cServer = m_Ctx.GetServer("vt_cliente");
                m_cPhName = m_Ctx.GetPhName("vt_cliente");
                m_cSql = "";
                m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_vt_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_vt_giros.GetDouble("cod_cliente"));
                if (m_Ctx.IsSharedTemp("vt_cliente")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_paisnacim",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paisnas = CPLib.Round(Read_Cursor.GetDouble("cod_paisnacim"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_cliente into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paisnas = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _statomit := '' */
                _statomit = "";
                // * --- Read from vt_mit_paises
                m_cServer = m_Ctx.GetServer("vt_mit_paises");
                m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _statomit = Read_Cursor.GetString("cod_mit");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _statomit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                /* If Substr(vt_historico_giros->cod_fiscal_cte,12,1)='Z' */
                if (CPLib.eqr(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,1),"Z")) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* If Empty(_luonas) */
                if (CPLib.Empty(_luonas)) {
                  // * --- Select from vt_cliente
                  m_cServer = m_Ctx.GetServer("vt_cliente");
                  m_cPhName = m_Ctx.GetPhName("vt_cliente");
                  if (Cursor_vt_cliente!=null)
                    Cursor_vt_cliente.Close();
                  Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cve_cardex  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_vt_cliente.Eof())) {
                    /* If Left(vt_cliente->cve_cardex,1)='Z' */
                    if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                      // * --- Read from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbstati")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("DESCRI");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } else { // Else
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                    Cursor_vt_cliente.Next();
                  }
                  m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                  Cursor_vt_cliente.Close();
                  // * --- End Select
                } // End If
              } // End If
            } // End If
            /* If Empty(LRTrim(_luonas)) */
            if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
              /* _luonas := LRTrim(vt_historico_giros->nompaisnac) */
              _luonas = CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nompaisnac"));
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_luonas),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->num_identificacion_cte),30) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),30);
            /* _riga := _riga + iif(Empty(vt_historico_giros->fecha_vencimiento_ident),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fecha_vencimiento_ident),8)) */
            _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident")),8));
            /* _riga := _riga + iif(Empty(vt_historico_giros->fec_alta_id),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fec_alta_id),8)) */
            _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fec_alta_id"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fec_alta_id")),8));
            /* _autorita := '' */
            _autorita = "";
            /* _iddocumento := 0 */
            _iddocumento = CPLib.Round(0,0);
            // * --- Select from vt_documentos
            m_cServer = m_Ctx.GetServer("vt_documentos");
            m_cPhName = m_Ctx.GetPhName("vt_documentos");
            if (Cursor_vt_documentos!=null)
              Cursor_vt_documentos.Close();
            Cursor_vt_documentos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")))+" "+")"+(m_Ctx.IsSharedTemp("vt_documentos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"id_documento desc ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_documentos.Eof())) {
              /* _paesedoc := vt_documentos->id_pais */
              _paesedoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_pais"),0);
              /* _datainidoc := vt_documentos->fecha_alta */
              _datainidoc = Cursor_vt_documentos.GetDate("fecha_alta");
              /* _datafindoc := vt_documentos->fecha_vencimiento */
              _datafindoc = Cursor_vt_documentos.GetDate("fecha_vencimiento");
              /* _autorita := vt_documentos->institucion_expide */
              _autorita = Cursor_vt_documentos.GetString("institucion_expide");
              /* _iddocumento := vt_documentos->id_documento */
              _iddocumento = CPLib.Round(Cursor_vt_documentos.GetDouble("id_documento"),0);
              // Exit Loop
              if (true) {
                break;
              }
              Cursor_vt_documentos.Next();
            }
            m_cConnectivityError = Cursor_vt_documentos.ErrorMessage();
            Cursor_vt_documentos.Close();
            // * --- End Select
            /* If _iddocumento=0 */
            if (CPLib.eqr(_iddocumento,0)) {
              // * --- Read from vt_documentos_bit
              m_cServer = m_Ctx.GetServer("vt_documentos_bit");
              m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
              m_cSql = "";
              m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("cod_cliente"));
              m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")));
              if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _iddocumento = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _iddocumento <> 0 */
              if (CPLib.ne(_iddocumento,0)) {
                // * --- Read from vt_documentos
                m_cServer = m_Ctx.GetServer("vt_documentos");
                m_cPhName = m_Ctx.GetPhName("vt_documentos");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documentos")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                  _datainidoc = Read_Cursor.GetDate("fecha_alta");
                  _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                  _autorita = Read_Cursor.GetString("institucion_expide");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  _datainidoc = CPLib.NullDate();
                  _datafindoc = CPLib.NullDate();
                  _autorita = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If _iddocumento <> 0 */
            if (CPLib.ne(_iddocumento,0)) {
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _codinstu := 0 */
                _codinstu = CPLib.Round(0,0);
                /* _comrila := '' */
                _comrila = "";
                // * --- Read from vt_documento_extras
                m_cServer = m_Ctx.GetServer("vt_documento_extras");
                m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                  _comrila = Read_Cursor.GetString("comune");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codinstu = 0;
                  _comrila = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _codinstu <> 0 */
                if (CPLib.ne(_codinstu,0)) {
                  /* _desaut := '' */
                  _desaut = "";
                  // * --- Read from vt_doc_catinstitucionexpide
                  m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                  m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                  if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _desaut = Read_Cursor.GetString("descripcion");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _desaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _descitaut := '' */
                  _descitaut = "";
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _descitaut = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _descitaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                  _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                } else { // Else
                  /* If not(Empty(_comrila)) */
                  if ( ! (CPLib.Empty(_comrila))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _descitaut = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _descitaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(_descitaut) */
                    _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(_descitaut);
                  } else { // Else
                    /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                    _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                  } // End If
                } // End If
              } else { // Else
                // * --- Select from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                if (Cursor_vt_paises!=null)
                  Cursor_vt_paises.Close();
                Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_paises.Eof())) {
                  /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                  _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                  Cursor_vt_paises.Next();
                }
                m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
                Cursor_vt_paises.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              if (Cursor_vt_paises!=null)
                Cursor_vt_paises.Close();
              Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_paises.Eof())) {
                /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                Cursor_vt_paises.Next();
              }
              m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
              Cursor_vt_paises.Close();
              // * --- End Select
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,50)),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,50)),50);
            /* _codmit := '' */
            _codmit = "";
            /* If vt_historico_giros->id_pais_cte=380 */
            if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
              /* _codmit := '086' */
              _codmit = "086";
              /* _desmit := 'ITALIA' */
              _desmit = "ITALIA";
            } else { // Else
              // * --- Read from vt_mit_paises
              m_cServer = m_Ctx.GetServer("vt_mit_paises");
              m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_cte"));
              if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codmit = Read_Cursor.GetString("cod_mit");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codmit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _desmit := '' */
              _desmit = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codmit,"C",3,0,m_cServer),m_cServer,_codmit);
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _desmit = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _desmit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(iif(Empty(_desmit),vt_historico_giros->nom_pais_cte,_desmit)),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim((CPLib.Empty(_desmit)?Cursor_vt_historico_giros.GetString("nom_pais_cte"):_desmit)),50);
            /* If vt_historico_giros->id_pais_cte=380 */
            if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
              /* _citta := '' */
              _citta = "";
              // * --- Read from vt_mit_citta
              m_cServer = m_Ctx.GetServer("vt_mit_citta");
              m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
              m_cSql = "";
              m_cSql = m_cSql+"cod_ciudad_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_ciudad_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_ciudad_cte"));
              if (m_Ctx.IsSharedTemp("vt_mit_citta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("citta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _citta = Read_Cursor.GetString("citta");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_citta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _citta = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_citta),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_citta),50);
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_ciudad_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_cte")),50);
            } // End If
            /* If Empty(LRTrim(vt_historico_giros->doc_codice)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("doc_codice")))) {
              /* _riga := _riga + '06' */
              _riga = _riga+"06";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->doc_codice),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("doc_codice")),2);
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(qbe_vt_giros->fec_captura),8) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_qbe_vt_giros.GetDate("fec_captura")),8);
            /* _riga := _riga + iif(qbe_vt_giros->id_forma_pago='01','S','N') */
            _riga = _riga+(CPLib.eqr(Cursor_qbe_vt_giros.GetString("id_forma_pago"),"01")?"S":"N");
            /* _riga := _riga + 'D' */
            _riga = _riga+"D";
            /* If vt_historico_giros->id_divisa_cte<>'EUR' */
            if (CPLib.ne(Cursor_vt_historico_giros.GetString("id_divisa_cte"),"EUR")) {
              /* _cambio := 0 */
              _cambio = CPLib.Round(0,10);
              // * --- Read from vt_cis_gir_otradiv
              m_cServer = m_Ctx.GetServer("vt_cis_gir_otradiv");
              m_cPhName = m_Ctx.GetPhName("vt_cis_gir_otradiv");
              m_cSql = "";
              m_cSql = m_cSql+"folio="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_vt_giros.GetString("folio")),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_qbe_vt_giros.GetString("folio")));
              if (m_Ctx.IsSharedTemp("vt_cis_gir_otradiv")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("tc",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cambio = CPLib.Round(Read_Cursor.GetDouble("tc"),10);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_cis_gir_otradiv into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cambio = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _cambio := Round(_cambio,4) */
              _cambio = CPLib.Round(CPLib.Round(_cambio,4),10);
              /* _cambioc := Right('00000'+LRTrim(Str(Int(_cambio*10000),5,0)),5) */
              _cambioc = CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(CPLib.Int(_cambio*10000),5,0)),5);
            } else { // Else
              /* _cambio := 1 */
              _cambio = CPLib.Round(1,10);
              /* _cambioc := '10000' */
              _cambioc = "10000";
            } // End If
            /* _riga := _riga + Right('000000000000000'+LRTrim(Str((vt_historico_giros->cantidad_trans*100)*_cambio,15,0)),15) */
            _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str((Cursor_vt_historico_giros.GetDouble("cantidad_trans")*100)*_cambio,15,0)),15);
            /* _riga := _riga + iif(qbe_vt_giros->id_forma_pago='01',Right('000000000000000'+LRTrim(Str((vt_historico_giros->cantidad_trans*100)*_cambio,15,0)),15),Replicate('0',15)) */
            _riga = _riga+(CPLib.eqr(Cursor_qbe_vt_giros.GetString("id_forma_pago"),"01")?CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str((Cursor_vt_historico_giros.GetDouble("cantidad_trans")*100)*_cambio,15,0)),15):CPLib.Replicate("0",15));
            /* _riga := _riga +  _cambioc */
            _riga = _riga+_cambioc;
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(Right('000000'+LRTrim(Str(vt_historico_giros->cod_agente,10,0)),6),10) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),10);
            /* _foliocli := 0 */
            _foliocli = CPLib.Round(0,0);
            // * --- Read from vt_cis_giros_pagados
            m_cServer = m_Ctx.GetServer("vt_cis_giros_pagados");
            m_cPhName = m_Ctx.GetPhName("vt_cis_giros_pagados");
            m_cSql = "";
            m_cSql = m_cSql+"folio="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetString("folio"),"C",20,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetString("folio"));
            if (m_Ctx.IsSharedTemp("vt_cis_giros_pagados")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_cliente",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _foliocli = CPLib.Round(Read_Cursor.GetDouble("cod_cliente"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_cis_giros_pagados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _foliocli = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _foliocli = 0 */
            if (CPLib.eqr(_foliocli,0)) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_benef)+" "+LRTrim(vt_historico_giros->seg_apellido_benef),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_benef"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_benef")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_beneficiario),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_beneficiario")),100);
              /* _paese := '' */
              _paese = "";
              /* _isopais := '' */
              _isopais = "";
              /* _codstades := '' // Codice Stato Destinazione */
              _codstades = "";
              // * --- Read from vt_mit_paises
              m_cServer = m_Ctx.GetServer("vt_mit_paises");
              m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_benef"));
              if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isopais = Read_Cursor.GetString("pais_q");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isopais = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(_isopais)) */
              if ( ! (CPLib.Empty(_isopais))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codstades = Read_Cursor.GetString("CODSTA");
                  _paese = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codstades = "";
                  _paese = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),100);
              /* If vt_historico_giros->id_pais_benef=380 */
              if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),380)) {
                /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_historico_giros->nom_ciudad_benef),30),30) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_benef")),30),30);
                /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_historico_giros->domicilio_benef)+" "+LRTrim(vt_historico_giros->num_domicilio_benef),30),30) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_benef"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_benef")),30),30);
              } else { // Else
                /* _riga := _riga + Space(60) */
                _riga = _riga+CPLib.Space(60);
              } // End If
            } else { // Else
              // * --- Select from vt_cliente
              m_cServer = m_Ctx.GetServer("vt_cliente");
              m_cPhName = m_Ctx.GetPhName("vt_cliente");
              if (Cursor_vt_cliente!=null)
                Cursor_vt_cliente.Close();
              Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_foliocli,"?",0,0,m_cServer, m_oParameters),m_cServer,_foliocli)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_cliente.Eof())) {
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),100);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),100);
                /* _paese := '' */
                _paese = "";
                /* _isopais := '' */
                _isopais = "";
                /* _codstades := '' // Codice Stato Destinazione */
                _codstades = "";
                // * --- Read from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_benef"));
                if (m_Ctx.IsSharedTemp("vt_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nm_pai_italiano",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paese = Read_Cursor.GetString("nm_pai_italiano");
                  _isopais = Read_Cursor.GetString("pais_q");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paese = "";
                  _isopais = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If not(Empty(_isopais)) */
                if ( ! (CPLib.Empty(_isopais))) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codstades = Read_Cursor.GetString("CODSTA");
                    _paese = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codstades = "";
                    _paese = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),100);
                /* If vt_historico_giros->id_pais_benef=380 */
                if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),380)) {
                  /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_historico_giros->nom_ciudad_benef),30),30) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_benef")),30),30);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),30) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),30);
                } else { // Else
                  /* _riga := _riga + Space(60) */
                  _riga = _riga+CPLib.Space(60);
                } // End If
                Cursor_vt_cliente.Next();
              }
              m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
              Cursor_vt_cliente.Close();
              // * --- End Select
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_capcli),5) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_capcli),5);
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(Right(LRTrim(vt_historico_giros->fec_nacim),4)+Substr(LRTrim(vt_historico_giros->fec_nacim),4,2)+Left(LRTrim(vt_historico_giros->fec_nacim),2),8) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.Right(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4)+CPLib.Substr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4,2)+CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),2),8);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->sexo),1) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("sexo")),1);
            /* If LRTrim(vt_historico_giros->id_divisa_cte)='DLS' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),"DLS")) {
              /* _riga := _riga + 'USD ' */
              _riga = _riga+"USD ";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_divisa_cte),4) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),4);
            } // End If
            /* _riga := _riga + 'I' */
            _riga = _riga+"I";
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->folio)+"-D",18) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("folio"))+"-D",18);
            /* _regval := 0 */
            _regval = CPLib.Round(0,0);
            /* _regione := '' */
            _regione = "";
            // * --- Read from vt_estados
            m_cServer = m_Ctx.GetServer("vt_estados");
            m_cPhName = m_Ctx.GetPhName("vt_estados");
            m_cSql = "";
            m_cSql = m_cSql+"cve_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetString("id_estado_cte"),"C",5,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetString("id_estado_cte"));
            m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_cte"));
            if (m_Ctx.IsSharedTemp("vt_estados")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _regval = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from vt_regiones
            m_cServer = m_Ctx.GetServer("vt_regiones");
            m_cPhName = m_Ctx.GetPhName("vt_regiones");
            m_cSql = "";
            m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
            if (m_Ctx.IsSharedTemp("vt_regiones")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _regione = Read_Cursor.GetString("codice_MIT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _regione = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_regione) */
            if (CPLib.Empty(_regione)) {
              /* _riga := _riga + '00' */
              _riga = _riga+"00";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
            } // End If
            /* _occupazione := 0 */
            _occupazione = CPLib.Round(0,0);
            // * --- Select from vt_ocupaciones
            m_cServer = m_Ctx.GetServer("vt_ocupaciones");
            m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
            if (Cursor_vt_ocupaciones!=null)
              Cursor_vt_ocupaciones.Close();
            Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_ocupaciones.Eof())) {
              /* _occupazione := vt_ocupaciones->id_tipoocupacion */
              _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
              Cursor_vt_ocupaciones.Next();
            }
            m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
            Cursor_vt_ocupaciones.Close();
            // * --- End Select
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
            /* _bl := 0 */
            _bl = CPLib.Round(0,0);
            // * --- Select from vt_ide_ctbe_bol
            m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
            m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
            if (Cursor_vt_ide_ctbe_bol!=null)
              Cursor_vt_ide_ctbe_bol.Close();
            Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
              /* _bl := 1 */
              _bl = CPLib.Round(1,0);
              Cursor_vt_ide_ctbe_bol.Next();
            }
            m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
            Cursor_vt_ide_ctbe_bol.Close();
            // * --- End Select
            /* _riga := _riga + iif(_bl=1,'S','N') */
            _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
            /* If _paesedoc=380 */
            if (CPLib.eqr(_paesedoc,380)) {
              /* _emettidoc := 'IT' */
              _emettidoc = "IT";
              /* ElseIf _paesedoc=0 */
            } else if (CPLib.eqr(_paesedoc,0)) {
              /* _emettidoc := 'ND' */
              _emettidoc = "ND";
            } else { // Else
              // * --- Read from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
              if (m_Ctx.IsSharedTemp("vt_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paesedoc = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
              _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
            /* _riga := _riga + Space(3) */
            _riga = _riga+CPLib.Space(3);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(vt_historico_giros->cod_cliente,10,0)),10) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_cliente"),10,0)),10);
            /* If vt_historico_giros->id_pais_cte=380 */
            if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_estado_cte),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_estado_cte")),2);
            } else { // Else
              /* _riga := _riga + 'EE' */
              _riga = _riga+"EE";
            } // End If
            /* If vt_historico_giros->id_pais_sucursal <> 380 */
            if (CPLib.ne(Cursor_vt_historico_giros.GetDouble("id_pais_sucursal"),380)) {
              /* _riga := _riga + '12' */
              _riga = _riga+"12";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_institucion),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_institucion")),50);
              /* _riga := _riga + _codstades */
              _riga = _riga+_codstades;
              /* _riga := _riga + Space(6) */
              _riga = _riga+CPLib.Space(6);
            } else { // Else
              /* _riga := _riga + '46' */
              _riga = _riga+"46";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_institucion),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_institucion")),50);
              /* _riga := _riga + '086' */
              _riga = _riga+"086";
              /* _riga := _riga + _cabdip */
              _riga = _riga+_cabdip;
            } // End If
            Cursor_vt_historico_giros.Next();
          }
          m_cConnectivityError = Cursor_vt_historico_giros.ErrorMessage();
          Cursor_vt_historico_giros.Close();
          // * --- End Select
          /* _riga := _riga+Space(10) */
          _riga = _riga+CPLib.Space(10);
          /* _riga := _riga+Space(10) */
          _riga = _riga+CPLib.Space(10);
          /* _riga := _riga+qbe_vt_giros->cod_status */
          _riga = _riga+Cursor_qbe_vt_giros.GetString("cod_status");
          /* FileLibMit.WriteLine(fhand,_riga) */
          FileLibMit.WriteLine(fhand,_riga);
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End If
        Cursor_qbe_vt_giros.Next();
      }
      m_cConnectivityError = Cursor_qbe_vt_giros.ErrorMessage();
      Cursor_qbe_vt_giros.Close();
      // * --- End Select
      /* _messaggio := _messaggio + 'Estrazione SEND - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
      _messaggio = _messaggio+"Estrazione SEND - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      /* If pTipo='O' */
      if (CPLib.eqr(pTipo,"O")) {
        /* gMsgProc := _messaggio */
        gMsgProc = _messaggio;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_vt_giros!=null)
          Cursor_qbe_vt_giros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_historico_giros!=null)
          Cursor_vt_historico_giros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_cliente_lastmod!=null)
          Cursor_qbe_vt_cliente_lastmod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cliente!=null)
          Cursor_vt_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_documentos!=null)
          Cursor_vt_documentos.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ocupaciones!=null)
          Cursor_vt_ocupaciones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ide_ctbe_bol!=null)
          Cursor_vt_ide_ctbe_bol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_paises!=null)
          Cursor_vt_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_RECEIVE() throws Exception {
    CPResultSet Cursor_vt_cis_giros_pagados=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_vt_cliente_lastmod=null;
    CPResultSet Cursor_vt_cliente=null;
    CPResultSet Cursor_vt_documentos=null;
    CPResultSet Cursor_vt_paises=null;
    CPResultSet Cursor_vt_ocupaciones=null;
    CPResultSet Cursor_vt_ide_ctbe_bol=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from vt_cis_giros_pagados
      m_cServer = m_Ctx.GetServer("vt_cis_giros_pagados");
      m_cPhName = m_Ctx.GetPhName("vt_cis_giros_pagados");
      if (Cursor_vt_cis_giros_pagados!=null)
        Cursor_vt_cis_giros_pagados.Close();
      Cursor_vt_cis_giros_pagados = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"fec_cobro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_dataestrai,"?",0,0,m_cServer, m_oParameters),m_cServer,_dataestrai)+"  "+")"+(m_Ctx.IsSharedTemp("vt_cis_giros_pagados")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_vt_cis_giros_pagados.Eof())) {
        /* _cliprov := 0 */
        _cliprov = CPLib.Round(0,0);
        // * --- Read from vt_cis_ptos_prueba
        m_cServer = m_Ctx.GetServer("vt_cis_ptos_prueba");
        m_cPhName = m_Ctx.GetPhName("vt_cis_ptos_prueba");
        m_cSql = "";
        m_cSql = m_cSql+"cod_agente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_agente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetDouble("cod_agente"));
        if (m_Ctx.IsSharedTemp("vt_cis_ptos_prueba")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_agente",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cliprov = CPLib.Round(Read_Cursor.GetDouble("cod_agente"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on vt_cis_ptos_prueba into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cliprov = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If _cliprov=0 */
        if (CPLib.eqr(_cliprov,0)) {
          /* If pTipo='O' */
          if (CPLib.eqr(pTipo,"O")) {
            /* gMsgImp := 'Elaboro Receive con codice: '+vt_cis_giros_pagados->folio // Messaggio Import */
            gMsgImp = "Elaboro Receive con codice: "+Cursor_vt_cis_giros_pagados.GetString("folio");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _capcli := Left(LRTrim(vt_cis_giros_pagados->ben_dom_cp),5) */
          _capcli = CPLib.Left(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_dom_cp")),5);
          /* _connes := '' */
          _connes = "";
          // * --- Read from vt_cis_mit_cliente_connes
          m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
          m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
          m_cSql = "";
          m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"));
          if (m_Ctx.IsSharedTemp("vt_cis_mit_cliente_connes")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("connes",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("connes");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_cis_mit_cliente_connes into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_connes)) */
          if ( ! (CPLib.Empty(_connes))) {
            /* _riga := LibreriaMit.SpacePad(LRTrim(_connes),16) */
            _riga = LibreriaMit.SpacePad(CPLib.LRTrim(_connes),16);
          } else { // Else
            /* _riga := 'C'+Right('000000000000000'+LRTrim(Str(vt_cis_giros_pagados->cod_cliente,10,0)),15) */
            _riga = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),10,0)),15);
            /* _connes := 'C'+Right('000000000000000'+LRTrim(Str(vt_cis_giros_pagados->cod_cliente,10,0)),15) */
            _connes = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),10,0)),15);
            // * --- Insert into vt_cis_mit_cliente_connes from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
            m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"vt_cis_mit_cliente_connes",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_valutrans",354,"00000282")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000282(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),10,0)),15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"vt_cis_mit_cliente_connes",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          /* _cabdip := '' */
          _cabdip = "";
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_agente"),10,0)),6),"C",6,0,m_cServer),m_cServer,CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_agente"),10,0)),6));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _cabdip = Read_Cursor.GetString("CAB");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _cabdip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Select from qbe_vt_cliente_lastmod
          SPBridge.HMCaller _h00000285;
          _h00000285 = new SPBridge.HMCaller();
          _h00000285.Set("m_cVQRList",m_cVQRList);
          _h00000285.Set("pTipo",1);
          _h00000285.Set("pCodice","%"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),10,0))+"%");
          if (Cursor_qbe_vt_cliente_lastmod!=null)
            Cursor_qbe_vt_cliente_lastmod.Close();
          Cursor_qbe_vt_cliente_lastmod = new VQRHolder("qbe_vt_cliente_lastmod",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000285,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_vt_cliente_lastmod.Eof())) {
            /* _lastmod := qbe_vt_cliente_lastmod->fecha_registro */
            _lastmod = Cursor_qbe_vt_cliente_lastmod.GetDate("fecha_registro");
            Cursor_qbe_vt_cliente_lastmod.Next();
          }
          m_cConnectivityError = Cursor_qbe_vt_cliente_lastmod.ErrorMessage();
          Cursor_qbe_vt_cliente_lastmod.Close();
          // * --- End Select
          /* If not(Empty(_lastmod)) and _lastmod >= _dataestrai and _lastmod <= Date() */
          if ( ! (CPLib.Empty(_lastmod)) && CPLib.ge(_lastmod,_dataestrai) && CPLib.le(_lastmod,CPLib.Date())) {
            // * --- Select from vt_cliente
            m_cServer = m_Ctx.GetServer("vt_cliente");
            m_cPhName = m_Ctx.GetPhName("vt_cliente");
            if (Cursor_vt_cliente!=null)
              Cursor_vt_cliente.Close();
            Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_cliente.Eof())) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),100);
              /* _riga := _riga + iif(Len(LRTrim(vt_cliente->cve_identificacion)) < 16,'N','S') */
              _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)?"N":"S");
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
              /* _paisnas := vt_cliente->cod_paisnacim */
              _paisnas = CPLib.Round(Cursor_vt_cliente.GetDouble("cod_paisnacim"),0);
              /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
                /* _statomit := '' */
                _statomit = "";
                // * --- Read from vt_mit_paises
                m_cServer = m_Ctx.GetServer("vt_mit_paises");
                m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _statomit = Read_Cursor.GetString("cod_mit");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _statomit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_luonas)) */
                if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                  /* _statomit := '' */
                  _statomit = "";
                  // * --- Read from vt_mit_paises
                  m_cServer = m_Ctx.GetServer("vt_mit_paises");
                  m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                  m_cSql = "";
                  m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetString("pais_nac_ben"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetString("pais_nac_ben"));
                  if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _statomit = Read_Cursor.GetString("pais_q");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _statomit = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statomit,"C",3,0,m_cServer),m_cServer,_statomit);
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* If Empty(LRTrim(_luonas)) */
                if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                  // * --- Read from vt_paises
                  m_cServer = m_Ctx.GetServer("vt_paises");
                  m_cPhName = m_Ctx.GetPhName("vt_paises");
                  m_cSql = "";
                  m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_paisnacim"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_paisnacim"));
                  if (m_Ctx.IsSharedTemp("vt_paises")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_pais",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("nom_pais");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
              } else { // Else
                /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
                if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* If Empty(_luonas) */
                if (CPLib.Empty(_luonas)) {
                  /* If Left(vt_cliente->cve_cardex,1)='Z' */
                  if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                  /* If Empty(LRTrim(_luonas)) */
                  if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                    // * --- Read from vt_paises
                    m_cServer = m_Ctx.GetServer("vt_paises");
                    m_cPhName = m_Ctx.GetPhName("vt_paises");
                    m_cSql = "";
                    m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_paisnacim"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_paisnacim"));
                    if (m_Ctx.IsSharedTemp("vt_paises")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_pais",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("nom_pais");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                } // End If
              } // End If
              Cursor_vt_cliente.Next();
            }
            m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
            Cursor_vt_cliente.Close();
            // * --- End Select
          } else { // Else
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->app_benef)+" "+LRTrim(vt_cis_giros_pagados->apm_benef),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("app_benef"))+" "+CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("apm_benef")),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->nom_beneficiario),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("nom_beneficiario")),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->ben_domicilio)+","+LRTrim(vt_cis_giros_pagados->ben_dom_num),100) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_domicilio"))+","+CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_dom_num")),100);
            /* _riga := _riga + iif(Len(LRTrim(vt_cis_giros_pagados->ben_codfiscal)) < 16,'N','S') */
            _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"))),16)?"N":"S");
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->ben_codfiscal),16) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal")),16);
            /* _luonas := '' */
            _luonas = "";
            /* _paisnas := Val(LRTrim(vt_cis_giros_pagados->pais_nac_ben)) */
            _paisnas = CPLib.Round(CPLib.Val(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("pais_nac_ben"))),0);
            /* If Len(LRTrim(vt_cis_giros_pagados->ben_codfiscal)) < 16 */
            if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"))),16)) {
              /* _statomit := '' */
              _statomit = "";
              // * --- Read from vt_mit_paises
              m_cServer = m_Ctx.GetServer("vt_mit_paises");
              m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetString("pais_nac_ben"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetString("pais_nac_ben"));
              if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _statomit = Read_Cursor.GetString("cod_mit");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _statomit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _luonas = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _luonas = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* If Substr(vt_cis_giros_pagados->ben_codfiscal,12,1)='Z' */
              if (CPLib.eqr(CPLib.Substr(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"),12,1),"Z")) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"),12,4));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                // * --- Read from tbcitta
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_cSql = "";
                m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cis_giros_pagados.GetString("ben_codfiscal"),12,4));
                if (m_Ctx.IsSharedTemp("tbcitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("CITTA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* If Empty(_luonas) */
              if (CPLib.Empty(_luonas)) {
                // * --- Select from vt_cliente
                m_cServer = m_Ctx.GetServer("vt_cliente");
                m_cPhName = m_Ctx.GetPhName("vt_cliente");
                if (Cursor_vt_cliente!=null)
                  Cursor_vt_cliente.Close();
                Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cve_cardex  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_cliente.Eof())) {
                  /* If Left(vt_cliente->cve_cardex,1)='Z' */
                  if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                  Cursor_vt_cliente.Next();
                }
                m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                Cursor_vt_cliente.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          /* If Empty(LRTrim(_luonas)) */
          if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
            // * --- Read from vt_paises
            m_cServer = m_Ctx.GetServer("vt_paises");
            m_cPhName = m_Ctx.GetPhName("vt_paises");
            m_cSql = "";
            m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
            if (m_Ctx.IsSharedTemp("vt_paises")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_pais",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _luonas = Read_Cursor.GetString("nom_pais");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _luonas = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_luonas),50) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),50);
          /* _paesedoc := 0 */
          _paesedoc = CPLib.Round(0,0);
          /* _datainidoc := NullDate() */
          _datainidoc = CPLib.NullDate();
          /* _datafindoc := NullDate() */
          _datafindoc = CPLib.NullDate();
          /* _autorita := '' */
          _autorita = "";
          /* _iddocumento := 0 */
          _iddocumento = CPLib.Round(0,0);
          // * --- Select from vt_documentos
          m_cServer = m_Ctx.GetServer("vt_documentos");
          m_cPhName = m_Ctx.GetPhName("vt_documentos");
          if (Cursor_vt_documentos!=null)
            Cursor_vt_documentos.Close();
          Cursor_vt_documentos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"?",0,0)+"  and  num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("num_id_ben")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("num_id_ben")))+" "+")"+(m_Ctx.IsSharedTemp("vt_documentos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"id_documento desc ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_vt_documentos.Eof())) {
            /* _paesedoc := vt_documentos->id_pais */
            _paesedoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_pais"),0);
            /* _datainidoc := vt_documentos->fecha_alta */
            _datainidoc = Cursor_vt_documentos.GetDate("fecha_alta");
            /* _datafindoc := vt_documentos->fecha_vencimiento */
            _datafindoc = Cursor_vt_documentos.GetDate("fecha_vencimiento");
            /* _autorita := vt_documentos->institucion_expide */
            _autorita = Cursor_vt_documentos.GetString("institucion_expide");
            /* _iddocumento := vt_documentos->id_documento */
            _iddocumento = CPLib.Round(Cursor_vt_documentos.GetDouble("id_documento"),0);
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_vt_documentos.Next();
          }
          m_cConnectivityError = Cursor_vt_documentos.ErrorMessage();
          Cursor_vt_documentos.Close();
          // * --- End Select
          /* If _iddocumento=0 */
          if (CPLib.eqr(_iddocumento,0)) {
            // * --- Read from vt_documentos_bit
            m_cServer = m_Ctx.GetServer("vt_documentos_bit");
            m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
            m_cSql = "";
            m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"));
            m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("num_id_ben")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("num_id_ben")));
            if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _iddocumento = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _iddocumento <> 0 */
            if (CPLib.ne(_iddocumento,0)) {
              // * --- Read from vt_documentos
              m_cServer = m_Ctx.GetServer("vt_documentos");
              m_cPhName = m_Ctx.GetPhName("vt_documentos");
              m_cSql = "";
              m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
              if (m_Ctx.IsSharedTemp("vt_documentos")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                _datainidoc = Read_Cursor.GetDate("fecha_alta");
                _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                _autorita = Read_Cursor.GetString("institucion_expide");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paesedoc = 0;
                _datainidoc = CPLib.NullDate();
                _datafindoc = CPLib.NullDate();
                _autorita = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
          } // End If
          /* If _iddocumento <> 0 */
          if (CPLib.ne(_iddocumento,0)) {
            /* If _paesedoc=380 */
            if (CPLib.eqr(_paesedoc,380)) {
              /* _codinstu := 0 */
              _codinstu = CPLib.Round(0,0);
              /* _comrila := '' */
              _comrila = "";
              // * --- Read from vt_documento_extras
              m_cServer = m_Ctx.GetServer("vt_documento_extras");
              m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
              m_cSql = "";
              m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
              if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                _comrila = Read_Cursor.GetString("comune");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codinstu = 0;
                _comrila = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _codinstu <> 0 */
              if (CPLib.ne(_codinstu,0)) {
                /* _desaut := '' */
                _desaut = "";
                // * --- Read from vt_doc_catinstitucionexpide
                m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                m_cSql = "";
                m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _desaut = Read_Cursor.GetString("descripcion");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _desaut = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descitaut := '' */
                _descitaut = "";
                // * --- Read from tbcitta
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_cSql = "";
                m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                if (m_Ctx.IsSharedTemp("tbcitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descitaut = Read_Cursor.GetString("CITTA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descitaut = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
              } else { // Else
                /* If not(Empty(_comrila)) */
                if ( ! (CPLib.Empty(_comrila))) {
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _descitaut = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _descitaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(_descitaut) */
                  _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(_descitaut);
                } else { // Else
                  /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                  _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                } // End If
              } // End If
            } else { // Else
              // * --- Select from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              if (Cursor_vt_paises!=null)
                Cursor_vt_paises.Close();
              Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_paises.Eof())) {
                /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                Cursor_vt_paises.Next();
              }
              m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
              Cursor_vt_paises.Close();
              // * --- End Select
            } // End If
          } else { // Else
            // * --- Select from vt_paises
            m_cServer = m_Ctx.GetServer("vt_paises");
            m_cPhName = m_Ctx.GetPhName("vt_paises");
            if (Cursor_vt_paises!=null)
              Cursor_vt_paises.Close();
            Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_paises.Eof())) {
              /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
              _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
              Cursor_vt_paises.Next();
            }
            m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
            Cursor_vt_paises.Close();
            // * --- End Select
          } // End If
          /* _tipdoc := '' */
          _tipdoc = "";
          // * --- Read from vt_mit_tip_doc
          m_cServer = m_Ctx.GetServer("vt_mit_tip_doc");
          m_cPhName = m_Ctx.GetPhName("vt_mit_tip_doc");
          m_cSql = "";
          m_cSql = m_cSql+"tip_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddoc,"N",10,0,m_cServer),m_cServer,_iddoc);
          if (m_Ctx.IsSharedTemp("vt_mit_tip_doc")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("doc_codice",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tipdoc = Read_Cursor.GetString("doc_codice");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_mit_tip_doc into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tipdoc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _tipdoc := iif(Empty(LRTrim(_tipdoc)),'06',_tipdoc) */
          _tipdoc = (CPLib.Empty(CPLib.LRTrim(_tipdoc))?"06":_tipdoc);
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->num_id_ben),30) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("num_id_ben")),30);
          /* _riga := _riga + iif(Empty(_datafindoc),'00000000',LibreriaMit.SpacePad(DateToChar(_datafindoc),8)) */
          _riga = _riga+(CPLib.Empty(_datafindoc)?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(_datafindoc),8));
          /* _riga := _riga + iif(Empty(_datainidoc),'00000000',LibreriaMit.SpacePad(DateToChar(_datainidoc),8)) */
          _riga = _riga+(CPLib.Empty(_datainidoc)?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(_datainidoc),8));
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,50)),50) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,50)),50);
          /* _citres := 0 */
          _citres = CPLib.Round(0,0);
          /* _paisres := 0 */
          _paisres = CPLib.Round(0,0);
          // * --- Read from vt_cliente
          m_cServer = m_Ctx.GetServer("vt_cliente");
          m_cPhName = m_Ctx.GetPhName("vt_cliente");
          m_cSql = "";
          m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"));
          if (m_Ctx.IsSharedTemp("vt_cliente")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_ciudad",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("cod_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("cve_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _citres = CPLib.Round(Read_Cursor.GetDouble("cod_ciudad"),0);
            _paisres = CPLib.Round(Read_Cursor.GetDouble("cod_pais"),0);
            _provres = Read_Cursor.GetString("cve_estado");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_cliente into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _citres = 0;
            _paisres = 0;
            _provres = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _paisres=380 */
          if (CPLib.eqr(_paisres,380)) {
            /* _paese := 'ITALIA' */
            _paese = "ITALIA";
            /* _riga := _riga + LibreriaMit.SpacePad(_paese,50) */
            _riga = _riga+LibreriaMit.SpacePad(_paese,50);
            /* _citta := '' */
            _citta = "";
            // * --- Read from vt_mit_citta
            m_cServer = m_Ctx.GetServer("vt_mit_citta");
            m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
            m_cSql = "";
            m_cSql = m_cSql+"cod_ciudad_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citres,"N",10,0,m_cServer),m_cServer,_citres);
            if (m_Ctx.IsSharedTemp("vt_mit_citta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("citta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _citta = Read_Cursor.GetString("citta");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_mit_citta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _citta = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_citta),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_citta),50);
            /* ElseIf _paisres <> 0 and _paisres <> 380 */
          } else if (CPLib.ne(_paisres,0) && CPLib.ne(_paisres,380)) {
            /* _paese := '' */
            _paese = "";
            /* _statomit := '' */
            _statomit = "";
            // * --- Read from vt_mit_paises
            m_cServer = m_Ctx.GetServer("vt_mit_paises");
            m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
            m_cSql = "";
            m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisres,"N",10,0,m_cServer),m_cServer,_paisres);
            if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _statomit = Read_Cursor.GetString("pais_q");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _statomit = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _codsae := '' */
            _codsae = "";
            /* If not(Empty(_isopais)) */
            if ( ! (CPLib.Empty(_isopais))) {
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codstades = Read_Cursor.GetString("CODSTA");
                _paese = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codstades = "";
                _paese = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If Empty(LRTrim(_paese)) */
            if (CPLib.Empty(CPLib.LRTrim(_paese))) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->ben_dom_pais),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_dom_pais")),50);
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),50);
            } // End If
            /* _citta := '' */
            _citta = "";
            // * --- Read from vt_mit_citta
            m_cServer = m_Ctx.GetServer("vt_mit_citta");
            m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
            m_cSql = "";
            m_cSql = m_cSql+"cod_ciudad_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citres,"N",10,0,m_cServer),m_cServer,_citres);
            if (m_Ctx.IsSharedTemp("vt_mit_citta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("citta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _citta = Read_Cursor.GetString("citta");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_mit_citta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _citta = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_citta),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_citta),50);
          } else { // Else
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->ben_dom_pais),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_dom_pais")),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->ben_dom_ciudad),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("ben_dom_ciudad")),50);
          } // End If
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_tipdoc),2) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_tipdoc),2);
          /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(vt_cis_giros_pagados->fec_cobro),8) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_cis_giros_pagados.GetDate("fec_cobro")),8);
          /* _riga := _riga + 'S' */
          _riga = _riga+"S";
          /* _riga := _riga + 'A' */
          _riga = _riga+"A";
          /* _riga := _riga + Right('000000000000000'+LRTrim(Str(vt_cis_giros_pagados->mon_beneficiario*100,15,0)),15) */
          _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("mon_beneficiario")*100,15,0)),15);
          /* _riga := _riga + Right('000000000000000'+LRTrim(Str(vt_cis_giros_pagados->mon_beneficiario*100,15,0)),15) */
          _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("mon_beneficiario")*100,15,0)),15);
          /* _riga := _riga + '10000'+Space(5) */
          _riga = _riga+"10000"+CPLib.Space(5);
          /* _riga := _riga + LibreriaMit.SpacePad(Right('000000'+LRTrim(Str(vt_cis_giros_pagados->cod_agente,10,0)),6),10) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_agente"),10,0)),6),10);
          /* _foliocli := 0 */
          _foliocli = CPLib.Round(0,0);
          // * --- Read from vt_historico_giros
          m_cServer = m_Ctx.GetServer("vt_historico_giros");
          m_cPhName = m_Ctx.GetPhName("vt_historico_giros");
          m_cSql = "";
          m_cSql = m_cSql+"folio="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetString("folio"),"C",20,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetString("folio"));
          if (m_Ctx.IsSharedTemp("vt_historico_giros")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_cliente",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _foliocli = CPLib.Round(Read_Cursor.GetDouble("cod_cliente"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_historico_giros into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _foliocli = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _foliocli = 0 */
          if (CPLib.eqr(_foliocli,0)) {
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->app_cte)+" "+LRTrim(vt_cis_giros_pagados->apm_cte),100) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("app_cte"))+" "+CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("apm_cte")),100);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->nom_cte),100) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("nom_cte")),100);
            /* _paese := '' */
            _paese = "";
            /* _isopais := '' */
            _isopais = "";
            /* _codstades := '' // Codice Stato Destinazione */
            _codstades = "";
            // * --- Read from vt_paises
            m_cServer = m_Ctx.GetServer("vt_paises");
            m_cPhName = m_Ctx.GetPhName("vt_paises");
            m_cSql = "";
            m_cSql = m_cSql+"pais_q="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_vt_cis_giros_pagados.GetString("pais_cte"),4)),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(Cursor_vt_cis_giros_pagados.GetString("pais_cte"),4)));
            if (m_Ctx.IsSharedTemp("vt_paises")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nm_pai_italiano",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _paese = Read_Cursor.GetString("nm_pai_italiano");
              _isopais = Read_Cursor.GetString("pais_q");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _paese = "";
              _isopais = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_isopais)) */
            if ( ! (CPLib.Empty(_isopais))) {
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codstades = Read_Cursor.GetString("CODSTA");
                _paese = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codstades = "";
                _paese = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),100) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),100);
            /* If vt_cis_giros_pagados->pais_cte='ITA' */
            if (CPLib.eqr(Cursor_vt_cis_giros_pagados.GetString("pais_cte"),"ITA")) {
              /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_cis_giros_pagados->cdad_cte),30),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("cdad_cte")),30),30);
              /* _riga := _riga + Space(30) */
              _riga = _riga+CPLib.Space(30);
            } else { // Else
              /* _riga := _riga + Space(60) */
              _riga = _riga+CPLib.Space(60);
            } // End If
          } else { // Else
            // * --- Select from vt_cliente
            m_cServer = m_Ctx.GetServer("vt_cliente");
            m_cPhName = m_Ctx.GetPhName("vt_cliente");
            if (Cursor_vt_cliente!=null)
              Cursor_vt_cliente.Close();
            Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_foliocli,"?",0,0,m_cServer, m_oParameters),m_cServer,_foliocli)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_cliente.Eof())) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),100);
              /* _codstades := '' // Codice Stato Destinazione */
              _codstades = "";
              /* _paese := '' */
              _paese = "";
              /* _isopais := '' */
              _isopais = "";
              // * --- Read from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              m_cSql = "";
              m_cSql = m_cSql+"pais_q="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(Cursor_vt_cis_giros_pagados.GetString("pais_cte"),4)),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(Cursor_vt_cis_giros_pagados.GetString("pais_cte"),4)));
              if (m_Ctx.IsSharedTemp("vt_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nm_pai_italiano",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paese = Read_Cursor.GetString("nm_pai_italiano");
                _isopais = Read_Cursor.GetString("pais_q");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paese = "";
                _isopais = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codstades = Read_Cursor.GetString("CODSTA");
                _paese = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codstades = "";
                _paese = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),100);
              /* If vt_cis_giros_pagados->pais_cte='ITA' */
              if (CPLib.eqr(Cursor_vt_cis_giros_pagados.GetString("pais_cte"),"ITA")) {
                /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_cis_giros_pagados->cdad_cte),30),30) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("cdad_cte")),30),30);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),30) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),30);
              } else { // Else
                /* _riga := _riga + Space(60) */
                _riga = _riga+CPLib.Space(60);
              } // End If
              Cursor_vt_cliente.Next();
            }
            m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
            Cursor_vt_cliente.Close();
            // * --- End Select
          } // End If
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_capcli),5) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_capcli),5);
          /* _riga := _riga + Space(5) */
          _riga = _riga+CPLib.Space(5);
          /* _riga := _riga + iif(Empty(vt_cis_giros_pagados->fec_nac_ben),'00000000',LibreriaMit.SpacePad(DateToChar(vt_cis_giros_pagados->fec_nac_ben),8)) */
          _riga = _riga+(CPLib.Empty(Cursor_vt_cis_giros_pagados.GetDate("fec_nac_ben"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_cis_giros_pagados.GetDate("fec_nac_ben")),8));
          /* _riga := _riga + LibreriaMit.SpacePad(Left(vt_cis_giros_pagados->ben_sexo,1),1) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(Cursor_vt_cis_giros_pagados.GetString("ben_sexo"),1),1);
          /* _riga := _riga + 'EUR ' */
          _riga = _riga+"EUR ";
          /* _riga := _riga + 'I' */
          _riga = _riga+"I";
          /* _riga := _riga + Space(5) */
          _riga = _riga+CPLib.Space(5);
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cis_giros_pagados->folio)+"-A",18) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("folio"))+"-A",18);
          /* _regval := 0 */
          _regval = CPLib.Round(0,0);
          /* _regione := '' */
          _regione = "";
          // * --- Read from vt_estados
          m_cServer = m_Ctx.GetServer("vt_estados");
          m_cPhName = m_Ctx.GetPhName("vt_estados");
          m_cSql = "";
          m_cSql = m_cSql+"nom_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetString("ben_dom_edo"),"C",40,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetString("ben_dom_edo"));
          m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(380,"N",10,0,m_cServer),m_cServer,380);
          if (m_Ctx.IsSharedTemp("vt_estados")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _regval = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Read from vt_regiones
          m_cServer = m_Ctx.GetServer("vt_regiones");
          m_cPhName = m_Ctx.GetPhName("vt_regiones");
          m_cSql = "";
          m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
          if (m_Ctx.IsSharedTemp("vt_regiones")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _regione = Read_Cursor.GetString("codice_MIT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _regione = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_regione) */
          if (CPLib.Empty(_regione)) {
            /* _riga := _riga + '00' */
            _riga = _riga+"00";
          } else { // Else
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
          } // End If
          /* _occupazione := 0 */
          _occupazione = CPLib.Round(0,0);
          // * --- Select from vt_ocupaciones
          m_cServer = m_Ctx.GetServer("vt_ocupaciones");
          m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
          if (Cursor_vt_ocupaciones!=null)
            Cursor_vt_ocupaciones.Close();
          Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_vt_ocupaciones.Eof())) {
            /* _occupazione := vt_ocupaciones->id_tipoocupacion */
            _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
            Cursor_vt_ocupaciones.Next();
          }
          m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
          Cursor_vt_ocupaciones.Close();
          // * --- End Select
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
          /* _bl := 0 */
          _bl = CPLib.Round(0,0);
          // * --- Select from vt_ide_ctbe_bol
          m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
          m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
          if (Cursor_vt_ide_ctbe_bol!=null)
            Cursor_vt_ide_ctbe_bol.Close();
          Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
            /* _bl := 1 */
            _bl = CPLib.Round(1,0);
            Cursor_vt_ide_ctbe_bol.Next();
          }
          m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
          Cursor_vt_ide_ctbe_bol.Close();
          // * --- End Select
          /* _riga := _riga + iif(_bl=1,'S','N') */
          _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
          /* If _paesedoc=380 */
          if (CPLib.eqr(_paesedoc,380)) {
            /* _emettidoc := 'IT' */
            _emettidoc = "IT";
            /* ElseIf _paesedoc=0 */
          } else if (CPLib.eqr(_paesedoc,0)) {
            /* _emettidoc := 'ND' */
            _emettidoc = "ND";
          } else { // Else
            // * --- Read from vt_paises
            m_cServer = m_Ctx.GetServer("vt_paises");
            m_cPhName = m_Ctx.GetPhName("vt_paises");
            m_cSql = "";
            m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
            if (m_Ctx.IsSharedTemp("vt_paises")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _paesedoc = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
            _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
          } // End If
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
          /* _riga := _riga + Space(3) */
          _riga = _riga+CPLib.Space(3);
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(vt_cis_giros_pagados->cod_cliente,10,0)),10) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(Cursor_vt_cis_giros_pagados.GetDouble("cod_cliente"),10,0)),10);
          /* If _paisres=380 */
          if (CPLib.eqr(_paisres,380)) {
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_provres),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_provres),2);
          } else { // Else
            /* _riga := _riga + 'EE' */
            _riga = _riga+"EE";
          } // End If
          /* If vt_cis_giros_pagados->cod_trans <> '88' */
          if (CPLib.ne(Cursor_vt_cis_giros_pagados.GetString("cod_trans"),"88")) {
            /* _desintcon := '' */
            _desintcon = "";
            // * --- Read from vt_cis_transmisores
            m_cServer = m_Ctx.GetServer("vt_cis_transmisores");
            m_cPhName = m_Ctx.GetPhName("vt_cis_transmisores");
            m_cSql = "";
            m_cSql = m_cSql+"cod_trans="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cis_giros_pagados.GetString("cod_trans"),"C",3,0,m_cServer),m_cServer,Cursor_vt_cis_giros_pagados.GetString("cod_trans"));
            if (m_Ctx.IsSharedTemp("vt_cis_transmisores")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_transmisor",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _desintcon = Read_Cursor.GetString("nom_transmisor");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_cis_transmisores into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _desintcon = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _riga := _riga + '12' */
            _riga = _riga+"12";
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_desintcon),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_desintcon),50);
            /* _riga := _riga + _codstades */
            _riga = _riga+_codstades;
            /* _riga := _riga + Space(6) */
            _riga = _riga+CPLib.Space(6);
          } else { // Else
            /* _riga := _riga + '46' */
            _riga = _riga+"46";
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim("VALUTRANS SPA"),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim("VALUTRANS SPA"),50);
            /* _riga := _riga + '086' */
            _riga = _riga+"086";
            /* _riga := _riga + _cabdip */
            _riga = _riga+_cabdip;
          } // End If
          /* _riga := _riga+Space(10) */
          _riga = _riga+CPLib.Space(10);
          /* _riga := _riga+Space(10) */
          _riga = _riga+CPLib.Space(10);
          /* _riga := _riga+" " */
          _riga = _riga+" ";
          /* FileLibMit.WriteLine(fhand,_riga) */
          FileLibMit.WriteLine(fhand,_riga);
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End If
        Cursor_vt_cis_giros_pagados.Next();
      }
      m_cConnectivityError = Cursor_vt_cis_giros_pagados.ErrorMessage();
      Cursor_vt_cis_giros_pagados.Close();
      // * --- End Select
      /* _messaggio := _messaggio + 'Estrazione RECEIVE - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
      _messaggio = _messaggio+"Estrazione RECEIVE - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      /* If pTipo='O' */
      if (CPLib.eqr(pTipo,"O")) {
        /* gMsgProc := _messaggio */
        gMsgProc = _messaggio;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_vt_cis_giros_pagados!=null)
          Cursor_vt_cis_giros_pagados.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_cliente_lastmod!=null)
          Cursor_qbe_vt_cliente_lastmod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cliente!=null)
          Cursor_vt_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_documentos!=null)
          Cursor_vt_documentos.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_paises!=null)
          Cursor_vt_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ocupaciones!=null)
          Cursor_vt_ocupaciones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ide_ctbe_bol!=null)
          Cursor_vt_ide_ctbe_bol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_DELETE() throws Exception {
    CPResultSet Cursor_qbe_vt_ide_mon_cancelacion=null;
    CPResultSet Cursor_vt_giros=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Legge le cancellazioni */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* _datacanc := arfn_fdate(_dataestrai) */
      _datacanc = arfn_fdateR.Make(m_Ctx,this).Run(_dataestrai);
      // * --- Select from qbe_vt_ide_mon_cancelacion
      SPBridge.HMCaller _h00000358;
      _h00000358 = new SPBridge.HMCaller();
      _h00000358.Set("m_cVQRList",m_cVQRList);
      _h00000358.Set("pData",_datacanc);
      if (Cursor_qbe_vt_ide_mon_cancelacion!=null)
        Cursor_qbe_vt_ide_mon_cancelacion.Close();
      Cursor_qbe_vt_ide_mon_cancelacion = new VQRHolder("qbe_vt_ide_mon_cancelacion",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000358,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_vt_ide_mon_cancelacion.Eof())) {
        // * --- Select from vt_giros
        m_cServer = m_Ctx.GetServer("vt_giros");
        m_cPhName = m_Ctx.GetPhName("vt_giros");
        if (Cursor_vt_giros!=null)
          Cursor_vt_giros.Close();
        Cursor_vt_giros = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select fec_captura,cod_agente  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"folio="+CPLib.ToSQL(Cursor_qbe_vt_ide_mon_cancelacion.GetString("folio"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_giros")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_vt_giros.Eof())) {
          /* _cliprov := 0 */
          _cliprov = CPLib.Round(0,0);
          // * --- Read from vt_cis_ptos_prueba
          m_cServer = m_Ctx.GetServer("vt_cis_ptos_prueba");
          m_cPhName = m_Ctx.GetPhName("vt_cis_ptos_prueba");
          m_cSql = "";
          m_cSql = m_cSql+"cod_agente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_giros.GetDouble("cod_agente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_giros.GetDouble("cod_agente"));
          if (m_Ctx.IsSharedTemp("vt_cis_ptos_prueba")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_agente",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _cliprov = CPLib.Round(Read_Cursor.GetDouble("cod_agente"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_cis_ptos_prueba into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _cliprov = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _cliprov=0 */
          if (CPLib.eqr(_cliprov,0)) {
            /* If pTipo='O' */
            if (CPLib.eqr(pTipo,"O")) {
              /* gMsgImp := 'Elaboro Cancellazione con codice: '+qbe_vt_ide_mon_cancelacion->folio // Messaggio Import */
              gMsgImp = "Elaboro Cancellazione con codice: "+Cursor_qbe_vt_ide_mon_cancelacion.GetString("folio");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* If DateDiff(vt_giros->fec_captura,_dataestrai) >= 1 */
            if (CPLib.ge(CPLib.DateDiff(Cursor_vt_giros.GetDate("fec_captura"),_dataestrai),1)) {
              /* _riga := Space(481) */
              _riga = CPLib.Space(481);
              /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(_dataestrai),8) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(_dataestrai),8);
              /* _riga := _riga  + Space(375) */
              _riga = _riga+CPLib.Space(375);
              /* _riga := _riga  + Space(60) */
              _riga = _riga+CPLib.Space(60);
              /* _riga := _riga + "D" */
              _riga = _riga+"D";
              /* _riga := _riga + Space(5) */
              _riga = _riga+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(qbe_vt_ide_mon_cancelacion->folio)+"-D",18) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_vt_ide_mon_cancelacion.GetString("folio"))+"-D",18);
              /* _riga := _riga + Space(25) */
              _riga = _riga+CPLib.Space(25);
              /* _riga := _riga + Space(72) */
              _riga = _riga+CPLib.Space(72);
              /* FileLibMit.WriteLine(fhand,_riga) */
              FileLibMit.WriteLine(fhand,_riga);
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
            } // End If
          } // End If
          Cursor_vt_giros.Next();
        }
        m_cConnectivityError = Cursor_vt_giros.ErrorMessage();
        Cursor_vt_giros.Close();
        // * --- End Select
        Cursor_qbe_vt_ide_mon_cancelacion.Next();
      }
      m_cConnectivityError = Cursor_qbe_vt_ide_mon_cancelacion.ErrorMessage();
      Cursor_qbe_vt_ide_mon_cancelacion.Close();
      // * --- End Select
      /* _messaggio := _messaggio + 'Estrazione CANCELLAZIONI - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
      _messaggio = _messaggio+"Estrazione CANCELLAZIONI - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      /* If pTipo='O' */
      if (CPLib.eqr(pTipo,"O")) {
        /* gMsgProc := _messaggio */
        gMsgProc = _messaggio;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_vt_ide_mon_cancelacion!=null)
          Cursor_qbe_vt_ide_mon_cancelacion.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_giros!=null)
          Cursor_vt_giros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_CV() throws Exception {
    CPResultSet Cursor_vt_cambios=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_vt_cliente=null;
    CPResultSet Cursor_vt_documentos=null;
    CPResultSet Cursor_vt_paises=null;
    CPResultSet Cursor_vt_ocupaciones=null;
    CPResultSet Cursor_vt_ide_ctbe_bol=null;
    try {
      /* _impin Numeric(12, 2) */
      double _impin;
      _impin = 0;
      /* _impout Numeric(12, 2) */
      double _impout;
      _impout = 0;
      /* _impin_w Numeric(10, 0) */
      double _impin_w;
      _impin_w = 0;
      /* _impout_w Numeric(10, 0) */
      double _impout_w;
      _impout_w = 0;
      /* Legge le operazioni di cambiavaluta */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from vt_cambios
      m_cServer = m_Ctx.GetServer("vt_cambios");
      m_cPhName = m_Ctx.GetPhName("vt_cambios");
      if (Cursor_vt_cambios!=null)
        Cursor_vt_cambios.Close();
      Cursor_vt_cambios = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"fec_captura="+CPSql.SQLValueAdapter(CPLib.ToSQL(_dataestcmb,"?",0,0,m_cServer, m_oParameters),m_cServer,_dataestcmb)+"  and  cod_status <> 'C' "+")"+(m_Ctx.IsSharedTemp("vt_cambios")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_vt_cambios.Eof())) {
        /* _cliprov := 0 */
        _cliprov = CPLib.Round(0,0);
        // * --- Read from vt_cis_ptos_prueba
        m_cServer = m_Ctx.GetServer("vt_cis_ptos_prueba");
        m_cPhName = m_Ctx.GetPhName("vt_cis_ptos_prueba");
        m_cSql = "";
        m_cSql = m_cSql+"cod_agente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cambios.GetDouble("cod_agente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cambios.GetDouble("cod_agente"));
        if (m_Ctx.IsSharedTemp("vt_cis_ptos_prueba")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_agente",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _cliprov = CPLib.Round(Read_Cursor.GetDouble("cod_agente"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on vt_cis_ptos_prueba into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _cliprov = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If _cliprov=0 */
        if (CPLib.eqr(_cliprov,0)) {
          /* If pTipo='O' */
          if (CPLib.eqr(pTipo,"O")) {
            /* gMsgImp := 'Elaboro Cambiavalute con codice: '+vt_cambios->folio // Messaggio Import */
            gMsgImp = "Elaboro Cambiavalute con codice: "+Cursor_vt_cambios.GetString("folio");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _cabdip := '' */
          _cabdip = "";
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_agente"),10,0)),6),"C",6,0,m_cServer),m_cServer,CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_agente"),10,0)),6));
          if (m_Ctx.IsSharedTemp("anadip")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _cabdip = Read_Cursor.GetString("CAB");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _cabdip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _connes := '' */
          _connes = "";
          // * --- Read from vt_cis_mit_cliente_connes
          m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
          m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
          m_cSql = "";
          m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cambios.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cambios.GetDouble("cod_cliente"));
          if (m_Ctx.IsSharedTemp("vt_cis_mit_cliente_connes")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("connes",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("connes");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_cis_mit_cliente_connes into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_connes)) */
          if ( ! (CPLib.Empty(_connes))) {
            /* _riga := LibreriaMit.SpacePad(LRTrim(_connes),16) */
            _riga = LibreriaMit.SpacePad(CPLib.LRTrim(_connes),16);
          } else { // Else
            /* _riga := 'C'+Right('000000000000000'+LRTrim(Str(vt_cambios->cod_cliente,10,0)),15) */
            _riga = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_cliente"),10,0)),15);
            /* _connes := 'C'+Right('000000000000000'+LRTrim(Str(vt_cambios->cod_cliente,10,0)),15) */
            _connes = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_cliente"),10,0)),15);
            // * --- Insert into vt_cis_mit_cliente_connes from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
            m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"vt_cis_mit_cliente_connes",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_valutrans",354,"00000383")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000383(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_vt_cambios.GetDouble("cod_cliente"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_cliente"),10,0)),15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"vt_cis_mit_cliente_connes",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          // * --- Select from vt_cliente
          m_cServer = m_Ctx.GetServer("vt_cliente");
          m_cPhName = m_Ctx.GetPhName("vt_cliente");
          if (Cursor_vt_cliente!=null)
            Cursor_vt_cliente.Close();
          Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cambios.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_vt_cliente.Eof())) {
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),100) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),100);
            /* _riga := _riga + iif(Len(LRTrim(vt_cliente->cve_identificacion)) < 16,'N','S') */
            _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)?"N":"S");
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
            /* _luonas := '' */
            _luonas = "";
            /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
            if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
              /* _statomit := '' */
              _statomit = "";
              // * --- Read from vt_mit_paises
              m_cServer = m_Ctx.GetServer("vt_mit_paises");
              m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_paisnacim"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_paisnacim"));
              if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _statomit = Read_Cursor.GetString("cod_mit");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _statomit = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _luonas = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _luonas = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } else { // Else
              /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
              if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } else { // Else
                // * --- Read from tbcitta
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_cSql = "";
                m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                if (m_Ctx.IsSharedTemp("tbcitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("CITTA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* If Empty(_luonas) */
              if (CPLib.Empty(_luonas)) {
                /* If Left(vt_cliente->cve_cardex,1)='Z' */
                if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
              } // End If
            } // End If
            /* If Empty(LRTrim(_luonas)) */
            if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
              // * --- Read from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_paisnacim"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_paisnacim"));
              if (m_Ctx.IsSharedTemp("vt_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_pais",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _luonas = Read_Cursor.GetString("nom_pais");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _luonas = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_luonas),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),50);
            /* _paesedoc := 0 */
            _paesedoc = CPLib.Round(0,0);
            /* _datainidoc := NullDate() */
            _datainidoc = CPLib.NullDate();
            /* _datafindoc := NullDate() */
            _datafindoc = CPLib.NullDate();
            /* _autorita := '' */
            _autorita = "";
            /* _numdoc := '' */
            _numdoc = "";
            /* _iddoc := 0 */
            _iddoc = CPLib.Round(0,0);
            /* _iddocumento := 0 */
            _iddocumento = CPLib.Round(0,0);
            // * --- Select from vt_documentos
            m_cServer = m_Ctx.GetServer("vt_documentos");
            m_cPhName = m_Ctx.GetPhName("vt_documentos");
            if (Cursor_vt_documentos!=null)
              Cursor_vt_documentos.Close();
            Cursor_vt_documentos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_cliente"),"?",0,0)+"  and  id_documento="+CPLib.ToSQL(Cursor_vt_cambios.GetDouble("id_documento"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_documentos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"id_documento desc ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_documentos.Eof())) {
              /* _paesedoc := vt_documentos->id_pais */
              _paesedoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_pais"),0);
              /* _datainidoc := vt_documentos->fecha_alta */
              _datainidoc = Cursor_vt_documentos.GetDate("fecha_alta");
              /* _datafindoc := vt_documentos->fecha_vencimiento */
              _datafindoc = Cursor_vt_documentos.GetDate("fecha_vencimiento");
              /* _autorita := vt_documentos->institucion_expide */
              _autorita = Cursor_vt_documentos.GetString("institucion_expide");
              /* _numdoc := vt_documentos->num_identificacion */
              _numdoc = Cursor_vt_documentos.GetString("num_identificacion");
              /* _iddocumento := vt_documentos->id_documento */
              _iddocumento = CPLib.Round(Cursor_vt_documentos.GetDouble("id_documento"),0);
              /* _iddoc := vt_documentos->id_tipodocumento */
              _iddoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_tipodocumento"),0);
              // Exit Loop
              if (true) {
                break;
              }
              Cursor_vt_documentos.Next();
            }
            m_cConnectivityError = Cursor_vt_documentos.ErrorMessage();
            Cursor_vt_documentos.Close();
            // * --- End Select
            /* If _iddocumento=0 */
            if (CPLib.eqr(_iddocumento,0)) {
              // * --- Read from vt_documentos_bit
              m_cServer = m_Ctx.GetServer("vt_documentos_bit");
              m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
              m_cSql = "";
              m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_cliente"));
              m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")));
              if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _iddocumento = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _iddocumento <> 0 */
              if (CPLib.ne(_iddocumento,0)) {
                // * --- Read from vt_documentos
                m_cServer = m_Ctx.GetServer("vt_documentos");
                m_cPhName = m_Ctx.GetPhName("vt_documentos");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documentos")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("num_identificacion",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("id_tipodocumento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                  _datainidoc = Read_Cursor.GetDate("fecha_alta");
                  _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                  _autorita = Read_Cursor.GetString("institucion_expide");
                  _numdoc = Read_Cursor.GetString("num_identificacion");
                  _iddoc = CPLib.Round(Read_Cursor.GetDouble("id_tipodocumento"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  _datainidoc = CPLib.NullDate();
                  _datafindoc = CPLib.NullDate();
                  _autorita = "";
                  _numdoc = "";
                  _iddoc = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If _iddocumento <> 0 */
            if (CPLib.ne(_iddocumento,0)) {
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _codinstu := 0 */
                _codinstu = CPLib.Round(0,0);
                /* _comrila := '' */
                _comrila = "";
                // * --- Read from vt_documento_extras
                m_cServer = m_Ctx.GetServer("vt_documento_extras");
                m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                  _comrila = Read_Cursor.GetString("comune");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codinstu = 0;
                  _comrila = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _codinstu <> 0 */
                if (CPLib.ne(_codinstu,0)) {
                  /* _desaut := '' */
                  _desaut = "";
                  // * --- Read from vt_doc_catinstitucionexpide
                  m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                  m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                  if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _desaut = Read_Cursor.GetString("descripcion");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _desaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _descitaut := '' */
                  _descitaut = "";
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _descitaut = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _descitaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                  _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                } else { // Else
                  /* If not(Empty(_comrila)) */
                  if ( ! (CPLib.Empty(_comrila))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _descitaut = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _descitaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(_descitaut) */
                    _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(_descitaut);
                  } else { // Else
                    /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                    _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                  } // End If
                } // End If
              } else { // Else
                // * --- Select from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                if (Cursor_vt_paises!=null)
                  Cursor_vt_paises.Close();
                Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_paises.Eof())) {
                  /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                  _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                  Cursor_vt_paises.Next();
                }
                m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
                Cursor_vt_paises.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              if (Cursor_vt_paises!=null)
                Cursor_vt_paises.Close();
              Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_paises.Eof())) {
                /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                Cursor_vt_paises.Next();
              }
              m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
              Cursor_vt_paises.Close();
              // * --- End Select
            } // End If
            /* _tipdoc := '' */
            _tipdoc = "";
            // * --- Read from vt_mit_tip_doc
            m_cServer = m_Ctx.GetServer("vt_mit_tip_doc");
            m_cPhName = m_Ctx.GetPhName("vt_mit_tip_doc");
            m_cSql = "";
            m_cSql = m_cSql+"tip_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddoc,"N",10,0,m_cServer),m_cServer,_iddoc);
            if (m_Ctx.IsSharedTemp("vt_mit_tip_doc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("doc_codice",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tipdoc = Read_Cursor.GetString("doc_codice");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_mit_tip_doc into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tipdoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _tipdoc := iif(Empty(LRTrim(_tipdoc)),'06',_tipdoc) */
            _tipdoc = (CPLib.Empty(CPLib.LRTrim(_tipdoc))?"06":_tipdoc);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_numdoc),30) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_numdoc),30);
            /* _riga := _riga + iif(Empty(_datafindoc),'00000000',LibreriaMit.SpacePad(DateToChar(_datafindoc),8)) */
            _riga = _riga+(CPLib.Empty(_datafindoc)?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(_datafindoc),8));
            /* _riga := _riga + iif(Empty(_datainidoc),'00000000',LibreriaMit.SpacePad(DateToChar(_datainidoc),8)) */
            _riga = _riga+(CPLib.Empty(_datainidoc)?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(_datainidoc),8));
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,50)),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,50)),50);
            /* _paese := '' */
            _paese = "";
            /* If vt_cliente->cod_pais=380 */
            if (CPLib.eqr(Cursor_vt_cliente.GetDouble("cod_pais"),380)) {
              /* _codstades := '086' */
              _codstades = "086";
              /* _paese := 'ITALIA' */
              _paese = "ITALIA";
            } else { // Else
              // * --- Read from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_pais"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_pais"));
              if (m_Ctx.IsSharedTemp("vt_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codstades = Read_Cursor.GetString("pais_q");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codstades = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codstades,"C",3,0,m_cServer),m_cServer,_codstades);
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paese = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paese = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),50);
            /* _citta := '' */
            _citta = "";
            // * --- Read from vt_ciudades
            m_cServer = m_Ctx.GetServer("vt_ciudades");
            m_cPhName = m_Ctx.GetPhName("vt_ciudades");
            m_cSql = "";
            m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_pais"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_pais"));
            m_cSql = m_cSql+" and cod_ciudad="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_ciudad"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_ciudad"));
            if (m_Ctx.IsSharedTemp("vt_ciudades")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_ciudad",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _citta = Read_Cursor.GetString("nom_ciudad");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_ciudades into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _citta = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from vt_mit_citta
            m_cServer = m_Ctx.GetServer("vt_mit_citta");
            m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
            m_cSql = "";
            m_cSql = m_cSql+"cod_ciudad_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_ciudad"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_ciudad"));
            if (m_Ctx.IsSharedTemp("vt_mit_citta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("citta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _citta = Read_Cursor.GetString("citta");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_mit_citta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _citta = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_citta),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_citta),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_tipdoc),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_tipdoc),2);
            /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(vt_cambios->fec_captura),8) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_cambios.GetDate("fec_captura")),8);
            /* _riga := _riga + vt_cambios->tipoOperacion */
            _riga = _riga+Cursor_vt_cambios.GetString("tipoOperacion");
            /* _riga := _riga + iif(vt_cambios->tipoOperacion='C','A','D') */
            _riga = _riga+(CPLib.eqr(Cursor_vt_cambios.GetString("tipoOperacion"),"C")?"A":"D");
            /* _riga := _riga + Right('000000000000000'+LRTrim(Str(vt_cambios->montoEntregado*100,15,0)),15) */
            _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("montoEntregado")*100,15,0)),15);
            /* _riga := _riga + Right('000000000000000'+LRTrim(Str(vt_cambios->montoEntregado*100,15,0)),15) */
            _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("montoEntregado")*100,15,0)),15);
            /* _cambio := Round(vt_cambios->tip_cambio,4) */
            _cambio = CPLib.Round(CPLib.Round(Cursor_vt_cambios.GetDouble("tip_cambio"),4),10);
            /* _cambioc := Right('00000'+LRTrim(Str(Int(_cambio*10000),5,0)),5) */
            _cambioc = CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(CPLib.Int(_cambio*10000),5,0)),5);
            /* _riga := _riga +  _cambioc */
            _riga = _riga+_cambioc;
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(Right('000000'+LRTrim(Str(vt_cambios->cod_agente,10,0)),6),10) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_agente"),10,0)),6),10);
            /* _riga := _riga + Space(100) */
            _riga = _riga+CPLib.Space(100);
            /* _riga := _riga + Space(100) */
            _riga = _riga+CPLib.Space(100);
            /* _riga := _riga + Space(100) */
            _riga = _riga+CPLib.Space(100);
            /* _riga := _riga + Space(60) */
            _riga = _riga+CPLib.Space(60);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cod_postal),5) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cod_postal")),5);
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + iif(Empty(vt_cliente->fec_nacimiento),'00000000',LibreriaMit.SpacePad(DateToChar(vt_cliente->fec_nacimiento),8)) */
            _riga = _riga+(CPLib.Empty(Cursor_vt_cliente.GetDate("fec_nacimiento"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_cliente.GetDate("fec_nacimiento")),8));
            /* _riga := _riga + iif(vt_cliente->genero='1','M','F') */
            _riga = _riga+(CPLib.eqr(Cursor_vt_cliente.GetString("genero"),"1")?"M":"F");
            /* If LRTrim(vt_cambios->divisa_Origen)='DLS' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_vt_cambios.GetString("divisa_Origen")),"DLS")) {
              /* _riga := _riga + 'USD ' */
              _riga = _riga+"USD ";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cambios->divisa_Origen),4) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cambios.GetString("divisa_Origen")),4);
            } // End If
            /* _riga := _riga + 'I' */
            _riga = _riga+"I";
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cambios->folio)+"-"+iif(vt_cambios->tipoOperacion='C','A','D'),18) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cambios.GetString("folio"))+"-"+(CPLib.eqr(Cursor_vt_cambios.GetString("tipoOperacion"),"C")?"A":"D"),18);
            /* _regval := 0 */
            _regval = CPLib.Round(0,0);
            /* _regione := '' */
            _regione = "";
            /* _provres := '' */
            _provres = "";
            // * --- Read from vt_estados
            m_cServer = m_Ctx.GetServer("vt_estados");
            m_cPhName = m_Ctx.GetPhName("vt_estados");
            m_cSql = "";
            m_cSql = m_cSql+"cve_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetString("cve_estado"),"C",5,0,m_cServer),m_cServer,Cursor_vt_cliente.GetString("cve_estado"));
            m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(380,"N",10,0,m_cServer),m_cServer,380);
            if (m_Ctx.IsSharedTemp("vt_estados")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("cve_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
              _provres = Read_Cursor.GetString("cve_estado");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _regval = 0;
              _provres = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from vt_regiones
            m_cServer = m_Ctx.GetServer("vt_regiones");
            m_cPhName = m_Ctx.GetPhName("vt_regiones");
            m_cSql = "";
            m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
            if (m_Ctx.IsSharedTemp("vt_regiones")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _regione = Read_Cursor.GetString("codice_MIT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _regione = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
            /* _occupazione := 0 */
            _occupazione = CPLib.Round(0,0);
            // * --- Select from vt_ocupaciones
            m_cServer = m_Ctx.GetServer("vt_ocupaciones");
            m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
            if (Cursor_vt_ocupaciones!=null)
              Cursor_vt_ocupaciones.Close();
            Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cambios.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_ocupaciones.Eof())) {
              /* _occupazione := vt_ocupaciones->id_tipoocupacion */
              _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
              Cursor_vt_ocupaciones.Next();
            }
            m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
            Cursor_vt_ocupaciones.Close();
            // * --- End Select
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
            /* _bl := 0 */
            _bl = CPLib.Round(0,0);
            // * --- Select from vt_ide_ctbe_bol
            m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
            m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
            if (Cursor_vt_ide_ctbe_bol!=null)
              Cursor_vt_ide_ctbe_bol.Close();
            Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_cambios.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
              /* _bl := 1 */
              _bl = CPLib.Round(1,0);
              Cursor_vt_ide_ctbe_bol.Next();
            }
            m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
            Cursor_vt_ide_ctbe_bol.Close();
            // * --- End Select
            /* _riga := _riga + iif(_bl=1,'S','N') */
            _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
            /* If _paesedoc=380 */
            if (CPLib.eqr(_paesedoc,380)) {
              /* _emettidoc := 'IT' */
              _emettidoc = "IT";
              /* ElseIf _paesedoc=0 */
            } else if (CPLib.eqr(_paesedoc,0)) {
              /* _emettidoc := 'ND' */
              _emettidoc = "ND";
            } else { // Else
              // * --- Read from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
              if (m_Ctx.IsSharedTemp("vt_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paesedoc = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
              _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
            /* _riga := _riga + Space(3) */
            _riga = _riga+CPLib.Space(3);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(vt_cambios->cod_cliente,10,0)),10) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(Cursor_vt_cambios.GetDouble("cod_cliente"),10,0)),10);
            /* If vt_cliente->cod_pais=380 */
            if (CPLib.eqr(Cursor_vt_cliente.GetDouble("cod_pais"),380)) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_provres),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_provres),2);
            } else { // Else
              /* _riga := _riga + 'EE' */
              _riga = _riga+"EE";
            } // End If
            /* _riga := _riga + Space(2) */
            _riga = _riga+CPLib.Space(2);
            /* _riga := _riga + Space(50) */
            _riga = _riga+CPLib.Space(50);
            /* _riga := _riga + Space(3) */
            _riga = _riga+CPLib.Space(3);
            /* _riga := _riga + Space(6) */
            _riga = _riga+CPLib.Space(6);
            Cursor_vt_cliente.Next();
          }
          m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
          Cursor_vt_cliente.Close();
          // * --- End Select
          /* _impin := vt_cambios->montoRecibido */
          _impin = CPLib.Round(Cursor_vt_cambios.GetDouble("montoRecibido"),2);
          /* _impout := vt_cambios->montoEntregado */
          _impout = CPLib.Round(Cursor_vt_cambios.GetDouble("montoEntregado"),2);
          /* If vt_cambios->tipoOperacion='C' */
          if (CPLib.eqr(Cursor_vt_cambios.GetString("tipoOperacion"),"C")) {
            /* _impout := _impout - vt_cambios->comision */
            _impout = CPLib.Round(_impout-Cursor_vt_cambios.GetDouble("comision"),2);
          } else { // Else
            /* _impin := vt_cambios->montoRecibido - vt_cambios->comision */
            _impin = CPLib.Round(Cursor_vt_cambios.GetDouble("montoRecibido")-Cursor_vt_cambios.GetDouble("comision"),2);
          } // End If
          /* _impin_w := _impin * 100 */
          _impin_w = CPLib.Round(_impin*100,0);
          /* _impout_w := _impout * 100 */
          _impout_w = CPLib.Round(_impout*100,0);
          /* _riga := _riga+Str(_impin_w,10,0) */
          _riga = _riga+CPLib.Str(_impin_w,10,0);
          /* _riga := _riga+Str(_impout_w,10,0) */
          _riga = _riga+CPLib.Str(_impout_w,10,0);
          /* _riga := _riga+vt_cambios->cod_status */
          _riga = _riga+Cursor_vt_cambios.GetString("cod_status");
          /* FileLibMit.WriteLine(fhand,_riga) */
          FileLibMit.WriteLine(fhand,_riga);
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End If
        Cursor_vt_cambios.Next();
      }
      m_cConnectivityError = Cursor_vt_cambios.ErrorMessage();
      Cursor_vt_cambios.Close();
      // * --- End Select
      /* _messaggio := _messaggio + 'Estrazione CAMBIAVALUTE - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
      _messaggio = _messaggio+"Estrazione CAMBIAVALUTE - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      /* If pTipo='O' */
      if (CPLib.eqr(pTipo,"O")) {
        /* gMsgProc := _messaggio */
        gMsgProc = _messaggio;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_vt_cambios!=null)
          Cursor_vt_cambios.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cliente!=null)
          Cursor_vt_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_documentos!=null)
          Cursor_vt_documentos.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_paises!=null)
          Cursor_vt_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ocupaciones!=null)
          Cursor_vt_ocupaciones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ide_ctbe_bol!=null)
          Cursor_vt_ide_ctbe_bol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_OTROS() throws Exception {
    CPResultSet Cursor_qbe_vt_giros_otros=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_vt_historico_giros=null;
    CPResultSet Cursor_qbe_vt_cliente_lastmod=null;
    CPResultSet Cursor_vt_cliente=null;
    CPResultSet Cursor_vt_paises=null;
    CPResultSet Cursor_vt_ocupaciones=null;
    CPResultSet Cursor_vt_ide_ctbe_bol=null;
    CPResultSet Cursor_vt_documentos=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Apre il file per la scrittura */
      /* fhand := FileLibMit.OpenWrite('appo/'+LRTrim(_gAzienda)+"/AUIOTR_"+DateToChar(_dataestrai)) */
      fhand = FileLibMit.OpenWrite("appo/"+CPLib.LRTrim(_gAzienda)+"/AUIOTR_"+CPLib.DateToChar(_dataestrai));
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_vt_giros_otros
      SPBridge.HMCaller _h0000041C;
      _h0000041C = new SPBridge.HMCaller();
      _h0000041C.Set("m_cVQRList",m_cVQRList);
      _h0000041C.Set("_dataestrai",_dataestrai);
      if (Cursor_qbe_vt_giros_otros!=null)
        Cursor_qbe_vt_giros_otros.Close();
      Cursor_qbe_vt_giros_otros = new VQRHolder("qbe_vt_giros_otros",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000041C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_vt_giros_otros.Eof())) {
        /* If Empty(qbe_vt_giros_otros->age_prueba) */
        if (CPLib.Empty(Cursor_qbe_vt_giros_otros.GetDouble("age_prueba"))) {
          /* If pTipo='O' */
          if (CPLib.eqr(pTipo,"O")) {
            /* gMsgImp := 'Elaboro Scarto con codice: '+qbe_vt_giros_otros->folio // Messaggio Import */
            gMsgImp = "Elaboro Scarto con codice: "+Cursor_qbe_vt_giros_otros.GetString("folio");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _ntrx := iif(qbe_vt_giros_otros->id_forma_pago='01',1,2) */
          _ntrx = CPLib.Round((CPLib.eqr(Cursor_qbe_vt_giros_otros.GetString("id_forma_pago"),"01")?1:2),0);
          /* _connes := '' */
          _connes = "";
          // * --- Read from vt_cis_mit_cliente_connes
          m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
          m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
          m_cSql = "";
          m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"));
          if (m_Ctx.IsSharedTemp("vt_cis_mit_cliente_connes")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("connes",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("connes");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on vt_cis_mit_cliente_connes into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_connes)) */
          if ( ! (CPLib.Empty(_connes))) {
            /* _riga := LibreriaMit.SpacePad(LRTrim(_connes),16) */
            _riga = LibreriaMit.SpacePad(CPLib.LRTrim(_connes),16);
          } else { // Else
            /* _riga := 'C'+Right('000000000000000'+LRTrim(Str(qbe_vt_giros_otros->cod_cliente,10,0)),15) */
            _riga = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),10,0)),15);
            /* _connes := 'C'+Right('000000000000000'+LRTrim(Str(qbe_vt_giros_otros->cod_cliente,10,0)),15) */
            _connes = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),10,0)),15);
            // * --- Insert into vt_cis_mit_cliente_connes from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
            m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"vt_cis_mit_cliente_connes",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_valutrans",354,"00000427")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000427(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),10,0)),15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"vt_cis_mit_cliente_connes",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          // * --- Select from vt_historico_giros
          m_cServer = m_Ctx.GetServer("vt_historico_giros");
          m_cPhName = m_Ctx.GetPhName("vt_historico_giros");
          if (Cursor_vt_historico_giros!=null)
            Cursor_vt_historico_giros.Close();
          Cursor_vt_historico_giros = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"folio="+CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetString("folio"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_historico_giros")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_vt_historico_giros.Eof())) {
            /* _capcli := vt_historico_giros->CP_cte */
            _capcli = Cursor_vt_historico_giros.GetString("CP_cte");
            /* If _ntrx=2 */
            if (CPLib.eqr(_ntrx,2)) {
              /* _cabdip := '' */
              _cabdip = "";
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),"C",6,0,m_cServer),m_cServer,CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6));
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cabdip = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cabdip = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _lastmod := NullDate() */
              _lastmod = CPLib.NullDate();
              // * --- Select from qbe_vt_cliente_lastmod
              SPBridge.HMCaller _h0000042E;
              _h0000042E = new SPBridge.HMCaller();
              _h0000042E.Set("m_cVQRList",m_cVQRList);
              _h0000042E.Set("pTipo",1);
              _h0000042E.Set("pCodice","%"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),10,0))+"%");
              if (Cursor_qbe_vt_cliente_lastmod!=null)
                Cursor_qbe_vt_cliente_lastmod.Close();
              Cursor_qbe_vt_cliente_lastmod = new VQRHolder("qbe_vt_cliente_lastmod",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000042E,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_vt_cliente_lastmod.Eof())) {
                /* _lastmod := qbe_vt_cliente_lastmod->fecha_registro */
                _lastmod = Cursor_qbe_vt_cliente_lastmod.GetDate("fecha_registro");
                Cursor_qbe_vt_cliente_lastmod.Next();
              }
              m_cConnectivityError = Cursor_qbe_vt_cliente_lastmod.ErrorMessage();
              Cursor_qbe_vt_cliente_lastmod.Close();
              // * --- End Select
              /* If not(Empty(_lastmod)) and _lastmod >= _dataestrai and _lastmod <= Date() */
              if ( ! (CPLib.Empty(_lastmod)) && CPLib.ge(_lastmod,_dataestrai) && CPLib.le(_lastmod,CPLib.Date())) {
                // * --- Select from vt_cliente
                m_cServer = m_Ctx.GetServer("vt_cliente");
                m_cPhName = m_Ctx.GetPhName("vt_cliente");
                if (Cursor_vt_cliente!=null)
                  Cursor_vt_cliente.Close();
                Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_cliente.Eof())) {
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),50) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),50);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),50) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),50);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),100) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),100);
                  /* _riga := _riga + iif(Len(LRTrim(vt_cliente->cve_identificacion)) < 16,'N','S') */
                  _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)?"N":"S");
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
                  /* _paisnas := vt_cliente->cod_paisnacim */
                  _paisnas = CPLib.Round(Cursor_vt_cliente.GetDouble("cod_paisnacim"),0);
                  /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
                  if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
                    /* _statomit := '' */
                    _statomit = "";
                    // * --- Read from vt_mit_paises
                    m_cServer = m_Ctx.GetServer("vt_mit_paises");
                    m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                    m_cSql = "";
                    m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                    if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _statomit = Read_Cursor.GetString("cod_mit");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _statomit = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(LRTrim(_luonas)) */
                    if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                      /* _luonas := LRTrim(vt_historico_giros->nompaisnac) */
                      _luonas = CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nompaisnac"));
                    } // End If
                  } else { // Else
                    /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
                    if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                      // * --- Read from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                      if (m_Ctx.IsSharedTemp("tbstati")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("DESCRI");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } else { // Else
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                    /* If Empty(_luonas) */
                    if (CPLib.Empty(_luonas)) {
                      /* If Left(vt_cliente->cve_cardex,1)='Z' */
                      if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                        // * --- Read from tbstati
                        m_cServer = m_Ctx.GetServer("tbstati");
                        m_cPhName = m_Ctx.GetPhName("tbstati");
                        m_cSql = "";
                        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                        if (m_Ctx.IsSharedTemp("tbstati")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _luonas = Read_Cursor.GetString("DESCRI");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _luonas = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                      } else { // Else
                        // * --- Read from tbcitta
                        m_cServer = m_Ctx.GetServer("tbcitta");
                        m_cPhName = m_Ctx.GetPhName("tbcitta");
                        m_cSql = "";
                        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                        if (m_Ctx.IsSharedTemp("tbcitta")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _luonas = Read_Cursor.GetString("CITTA");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _luonas = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                      } // End If
                    } // End If
                  } // End If
                  Cursor_vt_cliente.Next();
                }
                m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                Cursor_vt_cliente.Close();
                // * --- End Select
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_cte)+" "+LRTrim(vt_historico_giros->seg_apellido_cte),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_cte"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_cte")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_cliente),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_cliente")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->domicilio_cte)+","+LRTrim(vt_historico_giros->num_domicilio_cte),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_cte"))+","+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_cte")),100);
                /* _riga := _riga + iif(Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16,'N','S') */
                _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)?"N":"S");
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->cod_fiscal_cte),16) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte")),16);
                /* _luonas := '' */
                _luonas = "";
                /* _paisnas := 0 */
                _paisnas = CPLib.Round(0,0);
                // * --- Read from vt_cliente
                m_cServer = m_Ctx.GetServer("vt_cliente");
                m_cPhName = m_Ctx.GetPhName("vt_cliente");
                m_cSql = "";
                m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"));
                if (m_Ctx.IsSharedTemp("vt_cliente")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_paisnacim",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paisnas = CPLib.Round(Read_Cursor.GetDouble("cod_paisnacim"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_cliente into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paisnas = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16 */
                if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)) {
                  /* _statomit := '' */
                  _statomit = "";
                  // * --- Read from vt_mit_paises
                  m_cServer = m_Ctx.GetServer("vt_mit_paises");
                  m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                  m_cSql = "";
                  m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                  if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _statomit = Read_Cursor.GetString("cod_mit");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _statomit = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* If Substr(vt_historico_giros->cod_fiscal_cte,12,1)='Z' */
                  if (CPLib.eqr(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,1),"Z")) {
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                  /* If Empty(_luonas) */
                  if (CPLib.Empty(_luonas)) {
                    // * --- Select from vt_cliente
                    m_cServer = m_Ctx.GetServer("vt_cliente");
                    m_cPhName = m_Ctx.GetPhName("vt_cliente");
                    if (Cursor_vt_cliente!=null)
                      Cursor_vt_cliente.Close();
                    Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cve_cardex  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_vt_cliente.Eof())) {
                      /* If Left(vt_cliente->cve_cardex,1)='Z' */
                      if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                        // * --- Read from tbstati
                        m_cServer = m_Ctx.GetServer("tbstati");
                        m_cPhName = m_Ctx.GetPhName("tbstati");
                        m_cSql = "";
                        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                        if (m_Ctx.IsSharedTemp("tbstati")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _luonas = Read_Cursor.GetString("DESCRI");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _luonas = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                      } else { // Else
                        // * --- Read from tbcitta
                        m_cServer = m_Ctx.GetServer("tbcitta");
                        m_cPhName = m_Ctx.GetPhName("tbcitta");
                        m_cSql = "";
                        m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                        if (m_Ctx.IsSharedTemp("tbcitta")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _luonas = Read_Cursor.GetString("CITTA");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _luonas = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                      } // End If
                      Cursor_vt_cliente.Next();
                    }
                    m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                    Cursor_vt_cliente.Close();
                    // * --- End Select
                  } // End If
                } // End If
              } // End If
              /* If Empty(LRTrim(_luonas)) */
              if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                // * --- Read from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                if (m_Ctx.IsSharedTemp("vt_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nom_pais",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("nom_pais");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_luonas),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->num_identificacion_cte),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),30);
              /* _riga := _riga + iif(Empty(vt_historico_giros->fecha_vencimiento_ident),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fecha_vencimiento_ident),8)) */
              _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident")),8));
              /* _riga := _riga + iif(Empty(vt_historico_giros->fec_alta_id),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fec_alta_id),8)) */
              _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fec_alta_id"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fec_alta_id")),8));
              /* _autorita := '' */
              _autorita = "";
              /* _iddocumento := 0 */
              _iddocumento = CPLib.Round(0,0);
              // * --- Read from vt_documentos
              m_cServer = m_Ctx.GetServer("vt_documentos");
              m_cPhName = m_Ctx.GetPhName("vt_documentos");
              m_cSql = "";
              m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("cod_cliente"));
              m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")));
              if (m_Ctx.IsSharedTemp("vt_documentos")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                _datainidoc = Read_Cursor.GetDate("fecha_alta");
                _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                _autorita = Read_Cursor.GetString("institucion_expide");
                _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paesedoc = 0;
                _datainidoc = CPLib.NullDate();
                _datafindoc = CPLib.NullDate();
                _autorita = "";
                _iddocumento = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _iddocumento=0 */
              if (CPLib.eqr(_iddocumento,0)) {
                // * --- Read from vt_documentos_bit
                m_cServer = m_Ctx.GetServer("vt_documentos_bit");
                m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
                m_cSql = "";
                m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("cod_cliente"));
                m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")));
                if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _iddocumento = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _iddocumento <> 0 */
                if (CPLib.ne(_iddocumento,0)) {
                  // * --- Read from vt_documentos
                  m_cServer = m_Ctx.GetServer("vt_documentos");
                  m_cPhName = m_Ctx.GetPhName("vt_documentos");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                  if (m_Ctx.IsSharedTemp("vt_documentos")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                    _datainidoc = Read_Cursor.GetDate("fecha_alta");
                    _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                    _autorita = Read_Cursor.GetString("institucion_expide");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _paesedoc = 0;
                    _datainidoc = CPLib.NullDate();
                    _datafindoc = CPLib.NullDate();
                    _autorita = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
              } // End If
              /* If _iddocumento <> 0 */
              if (CPLib.ne(_iddocumento,0)) {
                /* If _paesedoc=380 */
                if (CPLib.eqr(_paesedoc,380)) {
                  /* _codinstu := 0 */
                  _codinstu = CPLib.Round(0,0);
                  /* _comrila := '' */
                  _comrila = "";
                  // * --- Read from vt_documento_extras
                  m_cServer = m_Ctx.GetServer("vt_documento_extras");
                  m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                  if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                    _comrila = Read_Cursor.GetString("comune");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codinstu = 0;
                    _comrila = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If _codinstu <> 0 */
                  if (CPLib.ne(_codinstu,0)) {
                    /* _desaut := '' */
                    _desaut = "";
                    // * --- Read from vt_doc_catinstitucionexpide
                    m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                    m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                    m_cSql = "";
                    m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                    if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _desaut = Read_Cursor.GetString("descripcion");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _desaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _descitaut := '' */
                    _descitaut = "";
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _descitaut = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _descitaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                    _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                  } else { // Else
                    /* If not(Empty(_comrila)) */
                    if ( ! (CPLib.Empty(_comrila))) {
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _descitaut = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _descitaut = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                      /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(_descitaut) */
                      _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(_descitaut);
                    } else { // Else
                      /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                      _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                    } // End If
                  } // End If
                } else { // Else
                  // * --- Select from vt_paises
                  m_cServer = m_Ctx.GetServer("vt_paises");
                  m_cPhName = m_Ctx.GetPhName("vt_paises");
                  if (Cursor_vt_paises!=null)
                    Cursor_vt_paises.Close();
                  Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_vt_paises.Eof())) {
                    /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                    _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                    Cursor_vt_paises.Next();
                  }
                  m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
                  Cursor_vt_paises.Close();
                  // * --- End Select
                } // End If
              } else { // Else
                // * --- Select from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                if (Cursor_vt_paises!=null)
                  Cursor_vt_paises.Close();
                Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_paises.Eof())) {
                  /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                  _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                  Cursor_vt_paises.Next();
                }
                m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
                Cursor_vt_paises.Close();
                // * --- End Select
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,50)),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,50)),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_pais_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_pais_cte")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_ciudad_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_cte")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->doc_codice),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("doc_codice")),2);
              /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(qbe_vt_giros_otros->fec_captura),8) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_qbe_vt_giros_otros.GetDate("fec_captura")),8);
              /* _riga := _riga + 'N' */
              _riga = _riga+"N";
              /* _riga := _riga + 'A' */
              _riga = _riga+"A";
              /* _riga := _riga + Right('000000000000000'+LRTrim(Str(vt_historico_giros->cantidad_trans*100,15,0)),15) */
              _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cantidad_trans")*100,15,0)),15);
              /* _riga := _riga + Replicate('0',15) */
              _riga = _riga+CPLib.Replicate("0",15);
              /* _riga := _riga + '10000'+Space(5) */
              _riga = _riga+"10000"+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(Right('000000'+LRTrim(Str(vt_historico_giros->cod_agente,10,0)),6),10) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),10);
              /* _foliocli := 0 */
              _foliocli = CPLib.Round(0,0);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_cte)+" "+LRTrim(vt_historico_giros->seg_apellido_cte),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_cte"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_cte")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_cliente),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_cliente")),100);
              /* _codstades := '' // Codice Stato Destinazione */
              _codstades = "";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_pais_cte),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_pais_cte")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_ciudad_cte),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_cte")),30);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->domicilio_cte)+","+LRTrim(vt_historico_giros->num_domicilio_cte),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_cte"))+","+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_cte")),30);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_capcli),5) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_capcli),5);
              /* _riga := _riga + Space(5) */
              _riga = _riga+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(Right(LRTrim(vt_historico_giros->fec_nacim),4)+Substr(LRTrim(vt_historico_giros->fec_nacim),4,2)+Left(LRTrim(vt_historico_giros->fec_nacim),2),8) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Right(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4)+CPLib.Substr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4,2)+CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),2),8);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->sexo),1) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("sexo")),1);
              /* If LRTrim(vt_historico_giros->id_divisa_cte)='DLS' */
              if (CPLib.eqr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),"DLS")) {
                /* _riga := _riga + 'USD ' */
                _riga = _riga+"USD ";
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_divisa_cte),4) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),4);
              } // End If
              /* _riga := _riga + 'I' */
              _riga = _riga+"I";
              /* _riga := _riga + Space(5) */
              _riga = _riga+CPLib.Space(5);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->folio)+"-D",18) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("folio"))+"-D",18);
              /* _regval := 0 */
              _regval = CPLib.Round(0,0);
              /* _regione := '' */
              _regione = "";
              // * --- Read from vt_estados
              m_cServer = m_Ctx.GetServer("vt_estados");
              m_cPhName = m_Ctx.GetPhName("vt_estados");
              m_cSql = "";
              m_cSql = m_cSql+"cve_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetString("id_estado_cte"),"C",5,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetString("id_estado_cte"));
              m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_cte"));
              if (m_Ctx.IsSharedTemp("vt_estados")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _regval = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from vt_regiones
              m_cServer = m_Ctx.GetServer("vt_regiones");
              m_cPhName = m_Ctx.GetPhName("vt_regiones");
              m_cSql = "";
              m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
              if (m_Ctx.IsSharedTemp("vt_regiones")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _regione = Read_Cursor.GetString("codice_MIT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _regione = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_regione) */
              if (CPLib.Empty(_regione)) {
                /* _riga := _riga + '00' */
                _riga = _riga+"00";
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
              } // End If
              /* _occupazione := 0 */
              _occupazione = CPLib.Round(0,0);
              // * --- Select from vt_ocupaciones
              m_cServer = m_Ctx.GetServer("vt_ocupaciones");
              m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
              if (Cursor_vt_ocupaciones!=null)
                Cursor_vt_ocupaciones.Close();
              Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_ocupaciones.Eof())) {
                /* _occupazione := vt_ocupaciones->id_tipoocupacion */
                _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
                Cursor_vt_ocupaciones.Next();
              }
              m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
              Cursor_vt_ocupaciones.Close();
              // * --- End Select
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
              /* _bl := 0 */
              _bl = CPLib.Round(0,0);
              // * --- Select from vt_ide_ctbe_bol
              m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
              m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
              if (Cursor_vt_ide_ctbe_bol!=null)
                Cursor_vt_ide_ctbe_bol.Close();
              Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
                /* _bl := 1 */
                _bl = CPLib.Round(1,0);
                Cursor_vt_ide_ctbe_bol.Next();
              }
              m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
              Cursor_vt_ide_ctbe_bol.Close();
              // * --- End Select
              /* _riga := _riga + iif(_bl=1,'S','N') */
              _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _emettidoc := 'IT' */
                _emettidoc = "IT";
                /* ElseIf _paesedoc=0 */
              } else if (CPLib.eqr(_paesedoc,0)) {
                /* _emettidoc := 'ND' */
                _emettidoc = "ND";
              } else { // Else
                // * --- Read from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
                if (m_Ctx.IsSharedTemp("vt_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
                _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
              /* _riga := _riga + Space(3) */
              _riga = _riga+CPLib.Space(3);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(vt_historico_giros->cod_cliente,10,0)),10) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_cliente"),10,0)),10);
              /* If vt_historico_giros->id_pais_cte=380 */
              if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_estado_cte),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_estado_cte")),2);
              } else { // Else
                /* _riga := _riga + 'EE' */
                _riga = _riga+"EE";
              } // End If
              /* _riga := _riga + '02' */
              _riga = _riga+"02";
              /* _riga := _riga + Space(50) */
              _riga = _riga+CPLib.Space(50);
              /* _riga := _riga + '086' */
              _riga = _riga+"086";
              /* _riga := _riga + Space(6) */
              _riga = _riga+CPLib.Space(6);
              /* FileLibMit.WriteLine(fhand,_riga) */
              FileLibMit.WriteLine(fhand,_riga);
              /* If not(Empty(qbe_vt_giros_otros->connes)) */
              if ( ! (CPLib.Empty(Cursor_qbe_vt_giros_otros.GetString("connes")))) {
                /* _riga := LibreriaMit.SpacePad(LRTrim(qbe_vt_giros_otros->connes),16) */
                _riga = LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_vt_giros_otros.GetString("connes")),16);
              } else { // Else
                /* _riga := 'C'+Right('000000000000000'+LRTrim(Str(qbe_vt_giros_otros->cod_cliente,10,0)),15) */
                _riga = "C"+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),10,0)),15);
              } // End If
            } // End If
            /* _cabdip := '' */
            _cabdip = "";
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),"C",6,0,m_cServer),m_cServer,CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _cabdip = Read_Cursor.GetString("CAB");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _cabdip = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _lastmod := NullDate() */
            _lastmod = CPLib.NullDate();
            // * --- Select from qbe_vt_cliente_lastmod
            SPBridge.HMCaller _h000004BC;
            _h000004BC = new SPBridge.HMCaller();
            _h000004BC.Set("m_cVQRList",m_cVQRList);
            _h000004BC.Set("pTipo",1);
            _h000004BC.Set("pCodice","%"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),10,0))+"%");
            if (Cursor_qbe_vt_cliente_lastmod!=null)
              Cursor_qbe_vt_cliente_lastmod.Close();
            Cursor_qbe_vt_cliente_lastmod = new VQRHolder("qbe_vt_cliente_lastmod",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004BC,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_vt_cliente_lastmod.Eof())) {
              /* _lastmod := qbe_vt_cliente_lastmod->fecha_registro */
              _lastmod = Cursor_qbe_vt_cliente_lastmod.GetDate("fecha_registro");
              Cursor_qbe_vt_cliente_lastmod.Next();
            }
            m_cConnectivityError = Cursor_qbe_vt_cliente_lastmod.ErrorMessage();
            Cursor_qbe_vt_cliente_lastmod.Close();
            // * --- End Select
            /* If not(Empty(_lastmod)) and _lastmod >= _dataestrai and _lastmod <= Date() */
            if ( ! (CPLib.Empty(_lastmod)) && CPLib.ge(_lastmod,_dataestrai) && CPLib.le(_lastmod,CPLib.Date())) {
              // * --- Select from vt_cliente
              m_cServer = m_Ctx.GetServer("vt_cliente");
              m_cPhName = m_Ctx.GetPhName("vt_cliente");
              if (Cursor_vt_cliente!=null)
                Cursor_vt_cliente.Close();
              Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_cliente.Eof())) {
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),100);
                /* _riga := _riga + iif(Len(LRTrim(vt_cliente->cve_identificacion)) < 16,'N','S') */
                _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)?"N":"S");
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
                /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
                if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
                  /* _paisnas := vt_cliente->cod_paisnacim */
                  _paisnas = CPLib.Round(Cursor_vt_cliente.GetDouble("cod_paisnacim"),0);
                  /* _statomit := '' */
                  _statomit = "";
                  // * --- Read from vt_mit_paises
                  m_cServer = m_Ctx.GetServer("vt_mit_paises");
                  m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                  m_cSql = "";
                  m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                  if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _statomit = Read_Cursor.GetString("cod_mit");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _statomit = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(LRTrim(_luonas)) */
                  if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                    /* _luonas := LRTrim(vt_historico_giros->nompaisnac) */
                    _luonas = CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nompaisnac"));
                  } // End If
                } else { // Else
                  /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
                  if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                  /* If Empty(_luonas) */
                  if (CPLib.Empty(_luonas)) {
                    /* If Left(vt_cliente->cve_cardex,1)='Z' */
                    if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                      // * --- Read from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbstati")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("DESCRI");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } else { // Else
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                  } // End If
                } // End If
                Cursor_vt_cliente.Next();
              }
              m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
              Cursor_vt_cliente.Close();
              // * --- End Select
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_cte)+" "+LRTrim(vt_historico_giros->seg_apellido_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_cte"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_cte")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_cliente),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_cliente")),50);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->domicilio_cte)+","+LRTrim(vt_historico_giros->num_domicilio_cte),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_cte"))+","+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_cte")),100);
              /* _riga := _riga + iif(Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16,'N','S') */
              _riga = _riga+(CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)?"N":"S");
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->cod_fiscal_cte),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte")),16);
              /* _luonas := '' */
              _luonas = "";
              /* If Len(LRTrim(vt_historico_giros->cod_fiscal_cte)) < 16 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"))),16)) {
                /* _paisnas := 0 */
                _paisnas = CPLib.Round(0,0);
                // * --- Read from vt_cliente
                m_cServer = m_Ctx.GetServer("vt_cliente");
                m_cPhName = m_Ctx.GetPhName("vt_cliente");
                m_cSql = "";
                m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_vt_giros_otros.GetDouble("cod_cliente"));
                if (m_Ctx.IsSharedTemp("vt_cliente")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_paisnacim",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paisnas = CPLib.Round(Read_Cursor.GetDouble("cod_paisnacim"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_cliente into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paisnas = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _statomit := '' */
                _statomit = "";
                // * --- Read from vt_mit_paises
                m_cServer = m_Ctx.GetServer("vt_mit_paises");
                m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _statomit = Read_Cursor.GetString("cod_mit");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _statomit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_luonas)) */
                if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                  /* _luonas := LRTrim(vt_historico_giros->nompaisnac) */
                  _luonas = CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nompaisnac"));
                } // End If
              } else { // Else
                /* If Substr(vt_historico_giros->cod_fiscal_cte,12,1)='Z' */
                if (CPLib.eqr(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,1),"Z")) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_historico_giros.GetString("cod_fiscal_cte"),12,4));
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* If Empty(_luonas) */
                if (CPLib.Empty(_luonas)) {
                  // * --- Select from vt_cliente
                  m_cServer = m_Ctx.GetServer("vt_cliente");
                  m_cPhName = m_Ctx.GetPhName("vt_cliente");
                  if (Cursor_vt_cliente!=null)
                    Cursor_vt_cliente.Close();
                  Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cve_cardex  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_vt_cliente.Eof())) {
                    /* If Left(vt_cliente->cve_cardex,1)='Z' */
                    if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                      // * --- Read from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbstati")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("DESCRI");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } else { // Else
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _luonas = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _luonas = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                    Cursor_vt_cliente.Next();
                  }
                  m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
                  Cursor_vt_cliente.Close();
                  // * --- End Select
                } // End If
              } // End If
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_luonas),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->num_identificacion_cte),30) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),30);
            /* _riga := _riga + iif(Empty(vt_historico_giros->fecha_vencimiento_ident),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fecha_vencimiento_ident),8)) */
            _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fecha_vencimiento_ident")),8));
            /* _riga := _riga + iif(Empty(vt_historico_giros->fec_alta_id),'00000000',LibreriaMit.SpacePad(DateToChar(vt_historico_giros->fec_alta_id),8)) */
            _riga = _riga+(CPLib.Empty(Cursor_vt_historico_giros.GetDate("fec_alta_id"))?"00000000":LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_vt_historico_giros.GetDate("fec_alta_id")),8));
            /* _autorita := '' */
            _autorita = "";
            /* _iddocumento := 0 */
            _iddocumento = CPLib.Round(0,0);
            // * --- Select from vt_documentos
            m_cServer = m_Ctx.GetServer("vt_documentos");
            m_cPhName = m_Ctx.GetPhName("vt_documentos");
            if (Cursor_vt_documentos!=null)
              Cursor_vt_documentos.Close();
            Cursor_vt_documentos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")))+" "+")"+(m_Ctx.IsSharedTemp("vt_documentos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"id_documento desc ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_documentos.Eof())) {
              /* _paesedoc := vt_documentos->id_pais */
              _paesedoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_pais"),0);
              /* _datainidoc := vt_documentos->fecha_alta */
              _datainidoc = Cursor_vt_documentos.GetDate("fecha_alta");
              /* _datafindoc := vt_documentos->fecha_vencimiento */
              _datafindoc = Cursor_vt_documentos.GetDate("fecha_vencimiento");
              /* _autorita := vt_documentos->institucion_expide */
              _autorita = Cursor_vt_documentos.GetString("institucion_expide");
              /* _iddocumento := vt_documentos->id_documento */
              _iddocumento = CPLib.Round(Cursor_vt_documentos.GetDouble("id_documento"),0);
              // Exit Loop
              if (true) {
                break;
              }
              Cursor_vt_documentos.Next();
            }
            m_cConnectivityError = Cursor_vt_documentos.ErrorMessage();
            Cursor_vt_documentos.Close();
            // * --- End Select
            /* If _iddocumento=0 */
            if (CPLib.eqr(_iddocumento,0)) {
              // * --- Read from vt_documentos_bit
              m_cServer = m_Ctx.GetServer("vt_documentos_bit");
              m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
              m_cSql = "";
              m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("cod_cliente"));
              m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")));
              if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _iddocumento = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _iddocumento <> 0 */
              if (CPLib.ne(_iddocumento,0)) {
                // * --- Read from vt_documentos
                m_cServer = m_Ctx.GetServer("vt_documentos");
                m_cPhName = m_Ctx.GetPhName("vt_documentos");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documentos")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                  _datainidoc = Read_Cursor.GetDate("fecha_alta");
                  _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                  _autorita = Read_Cursor.GetString("institucion_expide");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  _datainidoc = CPLib.NullDate();
                  _datafindoc = CPLib.NullDate();
                  _autorita = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If _iddocumento <> 0 */
            if (CPLib.ne(_iddocumento,0)) {
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _codinstu := 0 */
                _codinstu = CPLib.Round(0,0);
                /* _comrila := '' */
                _comrila = "";
                // * --- Read from vt_documento_extras
                m_cServer = m_Ctx.GetServer("vt_documento_extras");
                m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                  _comrila = Read_Cursor.GetString("comune");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codinstu = 0;
                  _comrila = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _codinstu <> 0 */
                if (CPLib.ne(_codinstu,0)) {
                  /* _desaut := '' */
                  _desaut = "";
                  // * --- Read from vt_doc_catinstitucionexpide
                  m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                  m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                  if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _desaut = Read_Cursor.GetString("descripcion");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _desaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _descitaut := '' */
                  _descitaut = "";
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _descitaut = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _descitaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                  _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                } else { // Else
                  /* If not(Empty(_comrila)) */
                  if ( ! (CPLib.Empty(_comrila))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _descitaut = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _descitaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(_descitaut) */
                    _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(_descitaut);
                  } else { // Else
                    /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                    _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                  } // End If
                } // End If
              } else { // Else
                // * --- Select from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                if (Cursor_vt_paises!=null)
                  Cursor_vt_paises.Close();
                Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_paises.Eof())) {
                  /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                  _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                  Cursor_vt_paises.Next();
                }
                m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
                Cursor_vt_paises.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              if (Cursor_vt_paises!=null)
                Cursor_vt_paises.Close();
              Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_paises.Eof())) {
                /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                Cursor_vt_paises.Next();
              }
              m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
              Cursor_vt_paises.Close();
              // * --- End Select
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,50)),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,50)),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_pais_cte),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_pais_cte")),50);
            /* If vt_historico_giros->id_pais_cte=380 */
            if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
              /* _citta := '' */
              _citta = "";
              // * --- Read from vt_mit_citta
              m_cServer = m_Ctx.GetServer("vt_mit_citta");
              m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
              m_cSql = "";
              m_cSql = m_cSql+"cod_ciudad_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_ciudad_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_ciudad_cte"));
              if (m_Ctx.IsSharedTemp("vt_mit_citta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("citta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _citta = Read_Cursor.GetString("citta");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_citta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _citta = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_citta),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_citta),50);
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_ciudad_cte),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_cte")),50);
            } // End If
            /* If Empty(LRTrim(vt_historico_giros->doc_codice)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("doc_codice")))) {
              /* _riga := _riga + '06' */
              _riga = _riga+"06";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->doc_codice),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("doc_codice")),2);
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(DateToChar(qbe_vt_giros_otros->fec_captura),8) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_qbe_vt_giros_otros.GetDate("fec_captura")),8);
            /* _riga := _riga + iif(qbe_vt_giros_otros->id_forma_pago='01','S','N') */
            _riga = _riga+(CPLib.eqr(Cursor_qbe_vt_giros_otros.GetString("id_forma_pago"),"01")?"S":"N");
            /* _riga := _riga + 'D' */
            _riga = _riga+"D";
            /* If vt_historico_giros->id_divisa_cte<>'EUR' */
            if (CPLib.ne(Cursor_vt_historico_giros.GetString("id_divisa_cte"),"EUR")) {
              /* _cambio := 0 */
              _cambio = CPLib.Round(0,10);
              // * --- Read from vt_cis_gir_otradiv
              m_cServer = m_Ctx.GetServer("vt_cis_gir_otradiv");
              m_cPhName = m_Ctx.GetPhName("vt_cis_gir_otradiv");
              m_cSql = "";
              m_cSql = m_cSql+"folio="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_vt_giros_otros.GetString("folio")),"C",20,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_qbe_vt_giros_otros.GetString("folio")));
              if (m_Ctx.IsSharedTemp("vt_cis_gir_otradiv")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("tc",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cambio = CPLib.Round(Read_Cursor.GetDouble("tc"),10);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_cis_gir_otradiv into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cambio = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _cambio := Round(_cambio,4) */
              _cambio = CPLib.Round(CPLib.Round(_cambio,4),10);
              /* _cambioc := Right('00000'+LRTrim(Str(Int(_cambio*10000),5,0)),5) */
              _cambioc = CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(CPLib.Int(_cambio*10000),5,0)),5);
            } else { // Else
              /* _cambio := 1 */
              _cambio = CPLib.Round(1,10);
              /* _cambioc := '10000' */
              _cambioc = "10000";
            } // End If
            /* _riga := _riga + Right('000000000000000'+LRTrim(Str((vt_historico_giros->cantidad_trans*100)*_cambio,15,0)),15) */
            _riga = _riga+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str((Cursor_vt_historico_giros.GetDouble("cantidad_trans")*100)*_cambio,15,0)),15);
            /* _riga := _riga + iif(qbe_vt_giros_otros->id_forma_pago='01',Right('000000000000000'+LRTrim(Str((vt_historico_giros->cantidad_trans*100)*_cambio,15,0)),15),Replicate('0',15)) */
            _riga = _riga+(CPLib.eqr(Cursor_qbe_vt_giros_otros.GetString("id_forma_pago"),"01")?CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str((Cursor_vt_historico_giros.GetDouble("cantidad_trans")*100)*_cambio,15,0)),15):CPLib.Replicate("0",15));
            /* _riga := _riga +  _cambioc */
            _riga = _riga+_cambioc;
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(Right('000000'+LRTrim(Str(vt_historico_giros->cod_agente,10,0)),6),10) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_agente"),10,0)),6),10);
            /* _foliocli := 0 */
            _foliocli = CPLib.Round(0,0);
            // * --- Read from vt_cis_giros_pagados
            m_cServer = m_Ctx.GetServer("vt_cis_giros_pagados");
            m_cPhName = m_Ctx.GetPhName("vt_cis_giros_pagados");
            m_cSql = "";
            m_cSql = m_cSql+"folio="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetString("folio"),"C",20,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetString("folio"));
            if (m_Ctx.IsSharedTemp("vt_cis_giros_pagados")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_cliente",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _foliocli = CPLib.Round(Read_Cursor.GetDouble("cod_cliente"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_cis_giros_pagados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _foliocli = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If _foliocli = 0 */
            if (CPLib.eqr(_foliocli,0)) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->pri_apellido_benef)+" "+LRTrim(vt_historico_giros->seg_apellido_benef),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("pri_apellido_benef"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("seg_apellido_benef")),100);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_beneficiario),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_beneficiario")),100);
              /* _paese := '' */
              _paese = "";
              /* _isopais := '' */
              _isopais = "";
              /* _codstades := '' // Codice Stato Destinazione */
              _codstades = "";
              // * --- Read from vt_mit_paises
              m_cServer = m_Ctx.GetServer("vt_mit_paises");
              m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_benef"));
              if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isopais = Read_Cursor.GetString("pais_q");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isopais = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(_isopais)) */
              if ( ! (CPLib.Empty(_isopais))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codstades = Read_Cursor.GetString("CODSTA");
                  _paese = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codstades = "";
                  _paese = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),100) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),100);
              /* If vt_historico_giros->id_pais_benef=380 */
              if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),380)) {
                /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_historico_giros->nom_ciudad_benef),30),30) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_benef")),30),30);
                /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_historico_giros->domicilio_benef)+" "+LRTrim(vt_historico_giros->num_domicilio_benef),30),30) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("domicilio_benef"))+" "+CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_domicilio_benef")),30),30);
              } else { // Else
                /* _riga := _riga + Space(60) */
                _riga = _riga+CPLib.Space(60);
              } // End If
            } else { // Else
              // * --- Select from vt_cliente
              m_cServer = m_Ctx.GetServer("vt_cliente");
              m_cPhName = m_Ctx.GetPhName("vt_cliente");
              if (Cursor_vt_cliente!=null)
                Cursor_vt_cliente.Close();
              Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_foliocli,"?",0,0,m_cServer, m_oParameters),m_cServer,_foliocli)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_cliente.Eof())) {
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),100);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->nom_cliente),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),100);
                /* _paese := '' */
                _paese = "";
                /* _isopais := '' */
                _isopais = "";
                /* _codstades := '' // Codice Stato Destinazione */
                _codstades = "";
                // * --- Read from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_benef"));
                if (m_Ctx.IsSharedTemp("vt_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("nm_pai_italiano",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("pais_q",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paese = Read_Cursor.GetString("nm_pai_italiano");
                  _isopais = Read_Cursor.GetString("pais_q");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paese = "";
                  _isopais = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If not(Empty(_isopais)) */
                if ( ! (CPLib.Empty(_isopais))) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_isopais),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_isopais));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codstades = Read_Cursor.GetString("CODSTA");
                    _paese = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codstades = "";
                    _paese = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_paese),100) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_paese),100);
                /* If vt_historico_giros->id_pais_benef=380 */
                if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_benef"),380)) {
                  /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_historico_giros->nom_ciudad_benef),30),30) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_ciudad_benef")),30),30);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),30) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),30);
                } else { // Else
                  /* _riga := _riga + Space(60) */
                  _riga = _riga+CPLib.Space(60);
                } // End If
                Cursor_vt_cliente.Next();
              }
              m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
              Cursor_vt_cliente.Close();
              // * --- End Select
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_capcli),5) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_capcli),5);
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(Right(LRTrim(vt_historico_giros->fec_nacim),4)+Substr(LRTrim(vt_historico_giros->fec_nacim),4,2)+Left(LRTrim(vt_historico_giros->fec_nacim),2),8) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.Right(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4)+CPLib.Substr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),4,2)+CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("fec_nacim")),2),8);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->sexo),1) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("sexo")),1);
            /* If LRTrim(vt_historico_giros->id_divisa_cte)='DLS' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),"DLS")) {
              /* _riga := _riga + 'USD ' */
              _riga = _riga+"USD ";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_divisa_cte),4) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_divisa_cte")),4);
            } // End If
            /* _riga := _riga + 'I' */
            _riga = _riga+"I";
            /* _riga := _riga + Space(5) */
            _riga = _riga+CPLib.Space(5);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->folio)+"-D",18) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("folio"))+"-D",18);
            /* _regval := 0 */
            _regval = CPLib.Round(0,0);
            /* _regione := '' */
            _regione = "";
            // * --- Read from vt_estados
            m_cServer = m_Ctx.GetServer("vt_estados");
            m_cPhName = m_Ctx.GetPhName("vt_estados");
            m_cSql = "";
            m_cSql = m_cSql+"cve_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetString("id_estado_cte"),"C",5,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetString("id_estado_cte"));
            m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),"N",10,0,m_cServer),m_cServer,Cursor_vt_historico_giros.GetDouble("id_pais_cte"));
            if (m_Ctx.IsSharedTemp("vt_estados")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _regval = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from vt_regiones
            m_cServer = m_Ctx.GetServer("vt_regiones");
            m_cPhName = m_Ctx.GetPhName("vt_regiones");
            m_cSql = "";
            m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
            if (m_Ctx.IsSharedTemp("vt_regiones")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _regione = Read_Cursor.GetString("codice_MIT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _regione = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_regione) */
            if (CPLib.Empty(_regione)) {
              /* _riga := _riga + '00' */
              _riga = _riga+"00";
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
            } // End If
            /* _occupazione := 0 */
            _occupazione = CPLib.Round(0,0);
            // * --- Select from vt_ocupaciones
            m_cServer = m_Ctx.GetServer("vt_ocupaciones");
            m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
            if (Cursor_vt_ocupaciones!=null)
              Cursor_vt_ocupaciones.Close();
            Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_ocupaciones.Eof())) {
              /* _occupazione := vt_ocupaciones->id_tipoocupacion */
              _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
              Cursor_vt_ocupaciones.Next();
            }
            m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
            Cursor_vt_ocupaciones.Close();
            // * --- End Select
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
            /* _bl := 0 */
            _bl = CPLib.Round(0,0);
            // * --- Select from vt_ide_ctbe_bol
            m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
            m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
            if (Cursor_vt_ide_ctbe_bol!=null)
              Cursor_vt_ide_ctbe_bol.Close();
            Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_historico_giros.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
              /* _bl := 1 */
              _bl = CPLib.Round(1,0);
              Cursor_vt_ide_ctbe_bol.Next();
            }
            m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
            Cursor_vt_ide_ctbe_bol.Close();
            // * --- End Select
            /* _riga := _riga + iif(_bl=1,'S','N') */
            _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
            /* If _paesedoc=380 */
            if (CPLib.eqr(_paesedoc,380)) {
              /* _emettidoc := 'IT' */
              _emettidoc = "IT";
              /* ElseIf _paesedoc=0 */
            } else if (CPLib.eqr(_paesedoc,0)) {
              /* _emettidoc := 'ND' */
              _emettidoc = "ND";
            } else { // Else
              // * --- Read from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              m_cSql = "";
              m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
              if (m_Ctx.IsSharedTemp("vt_paises")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _paesedoc = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
              _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
            } // End If
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
            /* _riga := _riga + Space(3) */
            _riga = _riga+CPLib.Space(3);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(vt_historico_giros->cod_cliente,10,0)),10) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(Cursor_vt_historico_giros.GetDouble("cod_cliente"),10,0)),10);
            /* If vt_historico_giros->id_pais_cte=380 */
            if (CPLib.eqr(Cursor_vt_historico_giros.GetDouble("id_pais_cte"),380)) {
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->id_estado_cte),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("id_estado_cte")),2);
            } else { // Else
              /* _riga := _riga + 'EE' */
              _riga = _riga+"EE";
            } // End If
            /* If vt_historico_giros->id_pais_sucursal <> 380 */
            if (CPLib.ne(Cursor_vt_historico_giros.GetDouble("id_pais_sucursal"),380)) {
              /* _riga := _riga + '12' */
              _riga = _riga+"12";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_institucion),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_institucion")),50);
              /* _riga := _riga + _codstades */
              _riga = _riga+_codstades;
              /* _riga := _riga + Space(6) */
              _riga = _riga+CPLib.Space(6);
            } else { // Else
              /* _riga := _riga + '46' */
              _riga = _riga+"46";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_historico_giros->nom_institucion),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nom_institucion")),50);
              /* _riga := _riga + '086' */
              _riga = _riga+"086";
              /* _riga := _riga + _cabdip */
              _riga = _riga+_cabdip;
            } // End If
            Cursor_vt_historico_giros.Next();
          }
          m_cConnectivityError = Cursor_vt_historico_giros.ErrorMessage();
          Cursor_vt_historico_giros.Close();
          // * --- End Select
          /* _riga := _riga+Space(10) */
          _riga = _riga+CPLib.Space(10);
          /* _riga := _riga+Space(10) */
          _riga = _riga+CPLib.Space(10);
          /* _riga := _riga+qbe_vt_giros_otros->cod_status */
          _riga = _riga+Cursor_qbe_vt_giros_otros.GetString("cod_status");
          /* FileLibMit.WriteLine(fhand,_riga) */
          FileLibMit.WriteLine(fhand,_riga);
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End If
        Cursor_qbe_vt_giros_otros.Next();
      }
      m_cConnectivityError = Cursor_qbe_vt_giros_otros.ErrorMessage();
      Cursor_qbe_vt_giros_otros.Close();
      // * --- End Select
      /* _messaggio := _messaggio + 'Estrazione OTROS - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
      _messaggio = _messaggio+"Estrazione OTROS - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
      /* If pTipo='O' */
      if (CPLib.eqr(pTipo,"O")) {
        /* gMsgProc := _messaggio */
        gMsgProc = _messaggio;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      // Chiude il file e lo cancella se vuoto
      FileLibMit.Close(fhand);
      if (_conta==0) {
        FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(_gAzienda)+"/AUIOTR_"+CPLib.DateToChar(_dataestrai));
      }
    } finally {
      try {
        if (Cursor_qbe_vt_giros_otros!=null)
          Cursor_qbe_vt_giros_otros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_historico_giros!=null)
          Cursor_vt_historico_giros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_cliente_lastmod!=null)
          Cursor_qbe_vt_cliente_lastmod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cliente!=null)
          Cursor_vt_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_paises!=null)
          Cursor_vt_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ocupaciones!=null)
          Cursor_vt_ocupaciones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ide_ctbe_bol!=null)
          Cursor_vt_ide_ctbe_bol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_documentos!=null)
          Cursor_vt_documentos.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_CLIENTI() throws Exception {
    CPResultSet Cursor_qbe_vt_cis_his_alteraciones=null;
    CPResultSet Cursor_qbe_vt_giros_cliente=null;
    CPResultSet Cursor_qbe_vt_cis_giros_pagados_cliente=null;
    CPResultSet Cursor_qbe_vt_cambios_cliente=null;
    CPResultSet Cursor_qbe_vt_maxdata_snd=null;
    CPResultSet Cursor_vt_giros=null;
    CPResultSet Cursor_vt_historico_giros=null;
    CPResultSet Cursor_vt_cis_giros_pagados=null;
    CPResultSet Cursor_vt_cambios=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_vt_documentos=null;
    CPResultSet Cursor_vt_paises=null;
    CPResultSet Cursor_vt_cliente=null;
    CPResultSet Cursor_vt_mit_citta=null;
    CPResultSet Cursor_vt_ocupaciones=null;
    CPResultSet Cursor_vt_ide_ctbe_bol=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Apre il file per la scrittura */
      /* _cliente Char(500) */
      String _cliente;
      _cliente = CPLib.Space(500);
      /* _tipo Char(1) */
      String _tipo;
      _tipo = CPLib.Space(1);
      /* _datamax Date */
      java.sql.Date _datamax;
      _datamax = CPLib.NullDate();
      /* _numid Char(25) */
      String _numid;
      _numid = CPLib.Space(25);
      /* _contacli Numeric(5, 0) */
      double _contacli;
      _contacli = 0;
      /* _nccliente Char(16) */
      String _nccliente;
      _nccliente = CPLib.Space(16);
      /* _cabres Char(6) */
      String _cabres;
      _cabres = CPLib.Space(6);
      /* _nazres Char(3) */
      String _nazres;
      _nazres = CPLib.Space(3);
      /* _capres Char(9) */
      String _capres;
      _capres = CPLib.Space(9);
      /* _datainizio := arfn_dateminus(_dataestrai,_numdays) */
      _datainizio = arfn_dateminusR.Make(m_Ctx,this).Run(_dataestrai,_numdays);
      /* mcClienti.Zap() */
      mcClienti.Zap();
      /* _contacli := 0 */
      _contacli = CPLib.Round(0,0);
      // * --- Select from qbe_vt_cis_his_alteraciones
      SPBridge.HMCaller _h0000058A;
      _h0000058A = new SPBridge.HMCaller();
      _h0000058A.Set("m_cVQRList",m_cVQRList);
      _h0000058A.Set("pData",_dataestrai);
      _h0000058A.Set("pTipo",1);
      if (Cursor_qbe_vt_cis_his_alteraciones!=null)
        Cursor_qbe_vt_cis_his_alteraciones.Close();
      Cursor_qbe_vt_cis_his_alteraciones = new VQRHolder("qbe_vt_cis_his_alteraciones",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000058A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_vt_cis_his_alteraciones.Eof())) {
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgImp := 'Elaboro Variazione Soggetto: '+Left(qbe_vt_cis_his_alteraciones->descripcion,50) // Messaggio Import */
          gMsgImp = "Elaboro Variazione Soggetto: "+CPLib.Left(Cursor_qbe_vt_cis_his_alteraciones.GetString("descripcion"),50);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* _cliente := Substr(qbe_vt_cis_his_alteraciones->descripcion,3,498) */
        _cliente = CPLib.Substr(Cursor_qbe_vt_cis_his_alteraciones.GetString("descripcion"),3,498);
        /* _nccliente := Left(_cliente,At("|",_cliente)-1) */
        _nccliente = CPLib.Left(_cliente,CPLib.At("|",_cliente)-1);
        /* _ncliente := Val(_nccliente) */
        _ncliente = CPLib.Round(CPLib.Val(_nccliente),0);
        // * --- Select from qbe_vt_giros_cliente
        SPBridge.HMCaller _h00000591;
        _h00000591 = new SPBridge.HMCaller();
        _h00000591.Set("m_cVQRList",m_cVQRList);
        _h00000591.Set("_dataestrai",_dataestrai);
        _h00000591.Set("_datainizio",_datainizio);
        _h00000591.Set("_connes",_ncliente);
        if (Cursor_qbe_vt_giros_cliente!=null)
          Cursor_qbe_vt_giros_cliente.Close();
        Cursor_qbe_vt_giros_cliente = new VQRHolder("qbe_vt_giros_cliente",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000591,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_vt_giros_cliente.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_qbe_vt_giros_cliente.Next();
        }
        m_cConnectivityError = Cursor_qbe_vt_giros_cliente.ErrorMessage();
        Cursor_qbe_vt_giros_cliente.Close();
        // * --- End Select
        // * --- Select from qbe_vt_cis_giros_pagados_cliente
        SPBridge.HMCaller _h00000593;
        _h00000593 = new SPBridge.HMCaller();
        _h00000593.Set("m_cVQRList",m_cVQRList);
        _h00000593.Set("_dataestrai",_dataestrai);
        _h00000593.Set("_datainizio",_datainizio);
        _h00000593.Set("_ncliente",_ncliente);
        if (Cursor_qbe_vt_cis_giros_pagados_cliente!=null)
          Cursor_qbe_vt_cis_giros_pagados_cliente.Close();
        Cursor_qbe_vt_cis_giros_pagados_cliente = new VQRHolder("qbe_vt_cis_giros_pagados_cliente",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000593,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_vt_cis_giros_pagados_cliente.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_qbe_vt_cis_giros_pagados_cliente.Next();
        }
        m_cConnectivityError = Cursor_qbe_vt_cis_giros_pagados_cliente.ErrorMessage();
        Cursor_qbe_vt_cis_giros_pagados_cliente.Close();
        // * --- End Select
        // * --- Select from qbe_vt_cambios_cliente
        SPBridge.HMCaller _h00000595;
        _h00000595 = new SPBridge.HMCaller();
        _h00000595.Set("m_cVQRList",m_cVQRList);
        _h00000595.Set("_dataestrai",_dataestrai);
        _h00000595.Set("_datainizio",_datainizio);
        _h00000595.Set("_ncliente",_ncliente);
        if (Cursor_qbe_vt_cambios_cliente!=null)
          Cursor_qbe_vt_cambios_cliente.Close();
        Cursor_qbe_vt_cambios_cliente = new VQRHolder("qbe_vt_cambios_cliente",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000595,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_vt_cambios_cliente.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          Cursor_qbe_vt_cambios_cliente.Next();
        }
        m_cConnectivityError = Cursor_qbe_vt_cambios_cliente.ErrorMessage();
        Cursor_qbe_vt_cambios_cliente.Close();
        // * --- End Select
        /* If _conta = 0 */
        if (CPLib.eqr(_conta,0)) {
          /* If not(mcClienti.GoToKey(_nccliente)) */
          if ( ! (mcClienti.GoToKey(_nccliente))) {
            /* _contacli := _contacli + 1 */
            _contacli = CPLib.Round(_contacli+1,0);
            /* mcClienti.AppendBlank() */
            mcClienti.AppendBlank();
            /* mcClienti.SetKey(_nccliente) */
            mcClienti.SetKey(_nccliente);
            /* mcClienti.cod_cliente := _nccliente */
            mcClienti.row.cod_cliente = _nccliente;
            /* mcClienti.SaveRow() */
            mcClienti.SaveRow();
          } // End If
        } // End If
        Cursor_qbe_vt_cis_his_alteraciones.Next();
      }
      m_cConnectivityError = Cursor_qbe_vt_cis_his_alteraciones.ErrorMessage();
      Cursor_qbe_vt_cis_his_alteraciones.Close();
      // * --- End Select
      /* If _contacli > 0 */
      if (CPLib.gt(_contacli,0)) {
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* fhand := FileLibMit.OpenWrite('appo/'+LRTrim(_gAzienda)+"/AUINEW_"+DateToChar(_dataestrai)) */
        fhand = FileLibMit.OpenWrite("appo/"+CPLib.LRTrim(_gAzienda)+"/AUINEW_"+CPLib.DateToChar(_dataestrai));
        for (MemoryCursorRow_mcvt_cliente_mcrdef rowClienti : mcClienti._iterable_()) {
          /* _riga := '' */
          _riga = "";
          /* _ncliente := Val(rowClienti.cod_cliente) */
          _ncliente = CPLib.Round(CPLib.Val(rowClienti.cod_cliente),0);
          /* _connes := '' */
          _connes = "";
          /* _tipo := '' */
          _tipo = "";
          /* _datamax := NullDate() */
          _datamax = CPLib.NullDate();
          /* _numid := '' */
          _numid = "";
          // * --- Select from qbe_vt_maxdata_snd
          SPBridge.HMCaller _h000005AA;
          _h000005AA = new SPBridge.HMCaller();
          _h000005AA.Set("m_cVQRList",m_cVQRList);
          _h000005AA.Set("pcod_cliente",_ncliente);
          if (Cursor_qbe_vt_maxdata_snd!=null)
            Cursor_qbe_vt_maxdata_snd.Close();
          Cursor_qbe_vt_maxdata_snd = new VQRHolder("qbe_vt_maxdata_snd",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005AA,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_vt_maxdata_snd.Eof())) {
            /* _tipo := qbe_vt_maxdata_snd->TIPO */
            _tipo = Cursor_qbe_vt_maxdata_snd.GetString("TIPO");
            /* _datamax := qbe_vt_maxdata_snd->DATAMAX */
            _datamax = Cursor_qbe_vt_maxdata_snd.GetDate("DATAMAX");
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_qbe_vt_maxdata_snd.Next();
          }
          m_cConnectivityError = Cursor_qbe_vt_maxdata_snd.ErrorMessage();
          Cursor_qbe_vt_maxdata_snd.Close();
          // * --- End Select
          /* If not(Empty(_datamax)) */
          if ( ! (CPLib.Empty(_datamax))) {
            /* Case _tipo='S' */
            if (CPLib.eqr(_tipo,"S")) {
              // * --- Select from vt_giros
              m_cServer = m_Ctx.GetServer("vt_giros");
              m_cPhName = m_Ctx.GetPhName("vt_giros");
              if (Cursor_vt_giros!=null)
                Cursor_vt_giros.Close();
              Cursor_vt_giros = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select folio  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"?",0,0,m_cServer, m_oParameters),m_cServer,_ncliente)+"  and  fec_captura="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datamax,"?",0,0,m_cServer, m_oParameters),m_cServer,_datamax)+" "+")"+(m_Ctx.IsSharedTemp("vt_giros")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_giros.Eof())) {
                // * --- Select from vt_historico_giros
                m_cServer = m_Ctx.GetServer("vt_historico_giros");
                m_cPhName = m_Ctx.GetPhName("vt_historico_giros");
                if (Cursor_vt_historico_giros!=null)
                  Cursor_vt_historico_giros.Close();
                Cursor_vt_historico_giros = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select num_identificacion_cte  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"folio="+CPLib.ToSQL(Cursor_vt_giros.GetString("folio"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_historico_giros")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_historico_giros.Eof())) {
                  /* _numid := Left(LRTrim(vt_historico_giros->num_identificacion_cte),25) */
                  _numid = CPLib.Left(CPLib.LRTrim(Cursor_vt_historico_giros.GetString("num_identificacion_cte")),25);
                  Cursor_vt_historico_giros.Next();
                }
                m_cConnectivityError = Cursor_vt_historico_giros.ErrorMessage();
                Cursor_vt_historico_giros.Close();
                // * --- End Select
                Cursor_vt_giros.Next();
              }
              m_cConnectivityError = Cursor_vt_giros.ErrorMessage();
              Cursor_vt_giros.Close();
              // * --- End Select
              /* Case _tipo='R' */
            } else if (CPLib.eqr(_tipo,"R")) {
              // * --- Select from vt_cis_giros_pagados
              m_cServer = m_Ctx.GetServer("vt_cis_giros_pagados");
              m_cPhName = m_Ctx.GetPhName("vt_cis_giros_pagados");
              if (Cursor_vt_cis_giros_pagados!=null)
                Cursor_vt_cis_giros_pagados.Close();
              Cursor_vt_cis_giros_pagados = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select num_id_ben  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"?",0,0,m_cServer, m_oParameters),m_cServer,_ncliente)+"  and  fec_cobro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datamax,"?",0,0,m_cServer, m_oParameters),m_cServer,_datamax)+" "+")"+(m_Ctx.IsSharedTemp("vt_cis_giros_pagados")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_cis_giros_pagados.Eof())) {
                /* _numid := LRTrim(vt_cis_giros_pagados->num_id_ben) */
                _numid = CPLib.LRTrim(Cursor_vt_cis_giros_pagados.GetString("num_id_ben"));
                Cursor_vt_cis_giros_pagados.Next();
              }
              m_cConnectivityError = Cursor_vt_cis_giros_pagados.ErrorMessage();
              Cursor_vt_cis_giros_pagados.Close();
              // * --- End Select
              /* Case _tipo='C' */
            } else if (CPLib.eqr(_tipo,"C")) {
              // * --- Select from vt_cambios
              m_cServer = m_Ctx.GetServer("vt_cambios");
              m_cPhName = m_Ctx.GetPhName("vt_cambios");
              if (Cursor_vt_cambios!=null)
                Cursor_vt_cambios.Close();
              Cursor_vt_cambios = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select id_documento  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"?",0,0,m_cServer, m_oParameters),m_cServer,_ncliente)+"  and  fec_captura="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datamax,"?",0,0,m_cServer, m_oParameters),m_cServer,_datamax)+" "+")"+(m_Ctx.IsSharedTemp("vt_cambios")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_cambios.Eof())) {
                /* _iddocumento := vt_cambios->id_documento */
                _iddocumento = CPLib.Round(Cursor_vt_cambios.GetDouble("id_documento"),0);
                Cursor_vt_cambios.Next();
              }
              m_cConnectivityError = Cursor_vt_cambios.ErrorMessage();
              Cursor_vt_cambios.Close();
              // * --- End Select
              // * --- Read from vt_documentos
              m_cServer = m_Ctx.GetServer("vt_documentos");
              m_cPhName = m_Ctx.GetPhName("vt_documentos");
              m_cSql = "";
              m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"N",10,0,m_cServer),m_cServer,_ncliente);
              m_cSql = m_cSql+" and id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
              if (m_Ctx.IsSharedTemp("vt_documentos")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("num_identificacion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _numid = Read_Cursor.GetString("num_identificacion");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _numid = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End Case
            /* _autorita := '' */
            _autorita = "";
            /* _iddocumento := 0 */
            _iddocumento = CPLib.Round(0,0);
            /* _iddoc := 0 */
            _iddoc = CPLib.Round(0,0);
            /* _paesedoc := 0 */
            _paesedoc = CPLib.Round(0,0);
            /* _datainidoc := NullDate() */
            _datainidoc = CPLib.NullDate();
            /* _datafindoc := NullDate() */
            _datafindoc = CPLib.NullDate();
            /* _tipdoc := '' */
            _tipdoc = "";
            // * --- Select from vt_documentos
            m_cServer = m_Ctx.GetServer("vt_documentos");
            m_cPhName = m_Ctx.GetPhName("vt_documentos");
            if (Cursor_vt_documentos!=null)
              Cursor_vt_documentos.Close();
            Cursor_vt_documentos = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"?",0,0,m_cServer, m_oParameters),m_cServer,_ncliente)+"  and  num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numid,"?",0,0,m_cServer, m_oParameters),m_cServer,_numid)+" "+")"+(m_Ctx.IsSharedTemp("vt_documentos")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"id_documento desc ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_documentos.Eof())) {
              /* _paesedoc := vt_documentos->id_pais */
              _paesedoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_pais"),0);
              /* _datainidoc := vt_documentos->fecha_alta */
              _datainidoc = Cursor_vt_documentos.GetDate("fecha_alta");
              /* _datafindoc := vt_documentos->fecha_vencimiento */
              _datafindoc = Cursor_vt_documentos.GetDate("fecha_vencimiento");
              /* _autorita := vt_documentos->institucion_expide */
              _autorita = Cursor_vt_documentos.GetString("institucion_expide");
              /* _iddocumento := vt_documentos->id_documento */
              _iddocumento = CPLib.Round(Cursor_vt_documentos.GetDouble("id_documento"),0);
              /* _iddoc := vt_documentos->id_tipodocumento */
              _iddoc = CPLib.Round(Cursor_vt_documentos.GetDouble("id_tipodocumento"),0);
              // Exit Loop
              if (true) {
                break;
              }
              Cursor_vt_documentos.Next();
            }
            m_cConnectivityError = Cursor_vt_documentos.ErrorMessage();
            Cursor_vt_documentos.Close();
            // * --- End Select
            /* If _iddocumento=0 */
            if (CPLib.eqr(_iddocumento,0)) {
              // * --- Read from vt_documentos_bit
              m_cServer = m_Ctx.GetServer("vt_documentos_bit");
              m_cPhName = m_Ctx.GetPhName("vt_documentos_bit");
              m_cSql = "";
              m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"N",10,0,m_cServer),m_cServer,_ncliente);
              m_cSql = m_cSql+" and num_identificacion="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numid,"C",25,0,m_cServer),m_cServer,_numid);
              if (m_Ctx.IsSharedTemp("vt_documentos_bit")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_documento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _iddocumento = CPLib.Round(Read_Cursor.GetDouble("id_documento"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_documentos_bit into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _iddocumento = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If _iddocumento <> 0 */
              if (CPLib.ne(_iddocumento,0)) {
                // * --- Read from vt_documentos
                m_cServer = m_Ctx.GetServer("vt_documentos");
                m_cPhName = m_Ctx.GetPhName("vt_documentos");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documentos")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_pais",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_alta",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("fecha_vencimiento",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("institucion_expide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("id_tipodocumento",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("id_pais"),0);
                  _datainidoc = Read_Cursor.GetDate("fecha_alta");
                  _datafindoc = Read_Cursor.GetDate("fecha_vencimiento");
                  _autorita = Read_Cursor.GetString("institucion_expide");
                  _iddoc = CPLib.Round(Read_Cursor.GetDouble("id_tipodocumento"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documentos into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  _datainidoc = CPLib.NullDate();
                  _datafindoc = CPLib.NullDate();
                  _autorita = "";
                  _iddoc = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
            } // End If
            /* If _iddocumento <> 0 */
            if (CPLib.ne(_iddocumento,0)) {
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _codinstu := 0 */
                _codinstu = CPLib.Round(0,0);
                /* _comrila := '' */
                _comrila = "";
                // * --- Read from vt_documento_extras
                m_cServer = m_Ctx.GetServer("vt_documento_extras");
                m_cPhName = m_Ctx.GetPhName("vt_documento_extras");
                m_cSql = "";
                m_cSql = m_cSql+"id_documento="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddocumento,"N",10,0,m_cServer),m_cServer,_iddocumento);
                if (m_Ctx.IsSharedTemp("vt_documento_extras")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_instutcionexpide",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("comune",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codinstu = CPLib.Round(Read_Cursor.GetDouble("id_instutcionexpide"),0);
                  _comrila = Read_Cursor.GetString("comune");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_documento_extras into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codinstu = 0;
                  _comrila = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _codinstu <> 0 */
                if (CPLib.ne(_codinstu,0)) {
                  /* _desaut := '' */
                  _desaut = "";
                  // * --- Read from vt_doc_catinstitucionexpide
                  m_cServer = m_Ctx.GetServer("vt_doc_catinstitucionexpide");
                  m_cPhName = m_Ctx.GetPhName("vt_doc_catinstitucionexpide");
                  m_cSql = "";
                  m_cSql = m_cSql+"id_cie="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinstu,"N",10,0,m_cServer),m_cServer,_codinstu);
                  if (m_Ctx.IsSharedTemp("vt_doc_catinstitucionexpide")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("descripcion",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _desaut = Read_Cursor.GetString("descripcion");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on vt_doc_catinstitucionexpide into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _desaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _descitaut := '' */
                  _descitaut = "";
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _descitaut = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _descitaut = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _autorita := LRTrim(_desaut)+" DI "+LRTrim(_descitaut) */
                  _autorita = CPLib.LRTrim(_desaut)+" DI "+CPLib.LRTrim(_descitaut);
                } else { // Else
                  /* If not(Empty(_comrila)) */
                  if ( ! (CPLib.Empty(_comrila))) {
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comrila,"C",4,0,m_cServer),m_cServer,_comrila);
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _descitaut = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _descitaut = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(_descitaut) */
                    _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(_descitaut);
                  } else { // Else
                    /* _autorita := LRTrim(_autorita)+" DI ITALIA" */
                    _autorita = CPLib.LRTrim(_autorita)+" DI ITALIA";
                  } // End If
                } // End If
              } else { // Else
                // * --- Select from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                if (Cursor_vt_paises!=null)
                  Cursor_vt_paises.Close();
                Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_paises.Eof())) {
                  /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                  _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                  Cursor_vt_paises.Next();
                }
                m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
                Cursor_vt_paises.Close();
                // * --- End Select
              } // End If
            } else { // Else
              // * --- Select from vt_paises
              m_cServer = m_Ctx.GetServer("vt_paises");
              m_cPhName = m_Ctx.GetPhName("vt_paises");
              if (Cursor_vt_paises!=null)
                Cursor_vt_paises.Close();
              Cursor_vt_paises = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cod_pais,nom_pais  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_paesedoc)+" "+")"+(m_Ctx.IsSharedTemp("vt_paises")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_paises.Eof())) {
                /* _autorita := LRTrim(_autorita)+" DI "+LRTrim(vt_paises->nom_pais) */
                _autorita = CPLib.LRTrim(_autorita)+" DI "+CPLib.LRTrim(Cursor_vt_paises.GetString("nom_pais"));
                Cursor_vt_paises.Next();
              }
              m_cConnectivityError = Cursor_vt_paises.ErrorMessage();
              Cursor_vt_paises.Close();
              // * --- End Select
            } // End If
            /* _tipdoc := '' */
            _tipdoc = "";
            // * --- Read from vt_mit_tip_doc
            m_cServer = m_Ctx.GetServer("vt_mit_tip_doc");
            m_cPhName = m_Ctx.GetPhName("vt_mit_tip_doc");
            m_cSql = "";
            m_cSql = m_cSql+"tip_sitrop="+CPSql.SQLValueAdapter(CPLib.ToSQL(_iddoc,"N",10,0,m_cServer),m_cServer,_iddoc);
            if (m_Ctx.IsSharedTemp("vt_mit_tip_doc")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("doc_codice",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tipdoc = Read_Cursor.GetString("doc_codice");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_mit_tip_doc into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tipdoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _tipdoc := iif(Empty(LRTrim(_tipdoc)),'06',_tipdoc) */
            _tipdoc = (CPLib.Empty(CPLib.LRTrim(_tipdoc))?"06":_tipdoc);
            // * --- Read from vt_cis_mit_cliente_connes
            m_cServer = m_Ctx.GetServer("vt_cis_mit_cliente_connes");
            m_cPhName = m_Ctx.GetPhName("vt_cis_mit_cliente_connes");
            m_cSql = "";
            m_cSql = m_cSql+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"N",10,0,m_cServer),m_cServer,_ncliente);
            if (m_Ctx.IsSharedTemp("vt_cis_mit_cliente_connes")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("connes",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("connes");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on vt_cis_mit_cliente_connes into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Select from vt_cliente
            m_cServer = m_Ctx.GetServer("vt_cliente");
            m_cPhName = m_Ctx.GetPhName("vt_cliente");
            if (Cursor_vt_cliente!=null)
              Cursor_vt_cliente.Close();
            Cursor_vt_cliente = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ncliente,"?",0,0,m_cServer, m_oParameters),m_cServer,_ncliente)+" "+")"+(m_Ctx.IsSharedTemp("vt_cliente")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_vt_cliente.Eof())) {
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* If vt_cliente->cod_pais=380 */
              if (CPLib.eqr(Cursor_vt_cliente.GetDouble("cod_pais"),380)) {
                // * --- Select from vt_mit_citta
                m_cServer = m_Ctx.GetServer("vt_mit_citta");
                m_cPhName = m_Ctx.GetPhName("vt_mit_citta");
                if (Cursor_vt_mit_citta!=null)
                  Cursor_vt_mit_citta.Close();
                Cursor_vt_mit_citta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select cab,citta,prov,cap  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_ciudad_sitrop="+CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_ciudad"),"?",0,0)+"  and  prov="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_estado")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_estado")))+" "+")"+(m_Ctx.IsSharedTemp("vt_mit_citta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_vt_mit_citta.Eof())) {
                  /* _citta := Left(LRTrim(vt_mit_citta->citta),30) */
                  _citta = CPLib.Left(CPLib.LRTrim(Cursor_vt_mit_citta.GetString("citta")),30);
                  /* _cabres := vt_mit_citta->cab */
                  _cabres = Cursor_vt_mit_citta.GetString("cab");
                  /* _provres := LRTrim(vt_mit_citta->prov) */
                  _provres = CPLib.LRTrim(Cursor_vt_mit_citta.GetString("prov"));
                  /* _nazres := '086' */
                  _nazres = "086";
                  /* _capres := LRTrim(vt_cliente->cod_postal) */
                  _capres = CPLib.LRTrim(Cursor_vt_cliente.GetString("cod_postal"));
                  Cursor_vt_mit_citta.Next();
                }
                m_cConnectivityError = Cursor_vt_mit_citta.ErrorMessage();
                Cursor_vt_mit_citta.Close();
                // * --- End Select
                /* _codsae := '600' */
                _codsae = "600";
                /* _setsint := '600' */
                _setsint = "600";
              } else { // Else
                /* _citta := Space(30) */
                _citta = CPLib.Space(30);
                /* _cabres := Space(6) */
                _cabres = CPLib.Space(6);
                /* _provres := 'EE' */
                _provres = "EE";
                // * --- Read from vt_mit_paises
                m_cServer = m_Ctx.GetServer("vt_mit_paises");
                m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_pais"),"N",10,0,m_cServer),m_cServer,Cursor_vt_cliente.GetDouble("cod_pais"));
                if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _nazres = Read_Cursor.GetString("cod_mit");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _nazres = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nazres,"C",3,0,m_cServer),m_cServer,_nazres);
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGSAE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codsae = Read_Cursor.GetString("FLGSAE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codsae = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _capres := Space(9) */
                _capres = CPLib.Space(9);
                /* _setsint := '711' */
                _setsint = "711";
              } // End If
              /* _riga := LibreriaMit.SpacePad(LRTrim(_cabres),6) // Riga su cui scrivere i dati prima di scriverli sul file */
              _riga = LibreriaMit.SpacePad(CPLib.LRTrim(_cabres),6);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->pri_apellido)+iif(not(Empty(LRTrim(vt_cliente->seg_apellido)))," "+LRTrim(vt_cliente->seg_apellido),'')+" "+LRTrim(vt_cliente->nom_cliente),70) // Riga su cui scrivere i dati prima di scriverli sul file */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido"))))?" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")):"")+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),70);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->domicilio)+","+LRTrim(vt_cliente->num_domicilio),35) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("domicilio"))+","+CPLib.LRTrim(Cursor_vt_cliente.GetString("num_domicilio")),35);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(vt_cliente->cve_identificacion),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),16);
              /* _riga := _riga + arfn_fdate_nd(vt_cliente->fec_nacimiento,"S") */
              _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_vt_cliente.GetDate("fec_nacimiento"),"S");
              /* If Len(LRTrim(vt_cliente->cve_identificacion)) < 16 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion"))),16)) {
                /* _paisnas := vt_cliente->cod_paisnacim */
                _paisnas = CPLib.Round(Cursor_vt_cliente.GetDouble("cod_paisnacim"),0);
                /* _statomit := '' */
                _statomit = "";
                // * --- Read from vt_mit_paises
                m_cServer = m_Ctx.GetServer("vt_mit_paises");
                m_cPhName = m_Ctx.GetPhName("vt_mit_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paisnas,"N",10,0,m_cServer),m_cServer,_paisnas);
                if (m_Ctx.IsSharedTemp("vt_mit_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("cod_mit",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _statomit = Read_Cursor.GetString("cod_mit");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_mit_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _statomit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_statomit),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(_statomit));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _luonas = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _luonas = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_luonas)) */
                if (CPLib.Empty(CPLib.LRTrim(_luonas))) {
                  /* _luonas := LRTrim(vt_historico_giros->nompaisnac) */
                  _luonas = CPLib.LRTrim(Cursor_vt_historico_giros.GetString("nompaisnac"));
                } // End If
                /* _provnas := 'EE' */
                _provnas = "EE";
              } else { // Else
                /* If Substr(vt_cliente->cve_identificacion,12,1)='Z' */
                if (CPLib.eqr(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,1),"Z")) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* _provnas := 'EE' */
                  _provnas = "EE";
                } else { // Else
                  /* _provnas := '' */
                  _provnas = "";
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _luonas = Read_Cursor.GetString("CITTA");
                    _provnas = Read_Cursor.GetString("PROV");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _luonas = "";
                    _provnas = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(_luonas) */
                  if (CPLib.Empty(_luonas)) {
                    // * --- Read from tbcittna
                    m_cServer = m_Ctx.GetServer("tbcittna");
                    m_cPhName = m_Ctx.GetPhName("tbcittna");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(Cursor_vt_cliente.GetString("cve_identificacion"),12,4));
                    if (m_Ctx.IsSharedTemp("tbcittna")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      _provnas = Read_Cursor.GetString("PROV");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcittna into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      _provnas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                } // End If
                /* If Empty(_luonas) */
                if (CPLib.Empty(_luonas)) {
                  /* If Left(vt_cliente->cve_cardex,1)='Z' */
                  if (CPLib.eqr(CPLib.Left(Cursor_vt_cliente.GetString("cve_cardex"),1),"Z")) {
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")),"C",4,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_cardex")));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _luonas = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _luonas = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                } // End If
              } // End If
              /* _riga := _riga +  LibreriaMit.SpacePad(LRTrim(_luonas),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_luonas),30);
              /* _riga := _riga +  _codsae */
              _riga = _riga+_codsae;
              /* _riga := _riga +  Space(3) */
              _riga = _riga+CPLib.Space(3);
              /* _riga := _riga +  _setsint */
              _riga = _riga+_setsint;
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_tipdoc),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_tipdoc),2);
              /* _riga := _riga +  LibreriaMit.SpacePad(LRTrim(_numid),15) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_numid),15);
              /* _riga := _riga + arfn_fdate_nd(_datainidoc,"S") */
              _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(_datainidoc,"S");
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Left(_autorita,30)),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Left(_autorita,30)),30);
              /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(_citta),30),30) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(_citta),30),30);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_provres),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_provres),2);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_nazres),3) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_nazres),3);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_capres),9) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_capres),9);
              /* _riga := _riga + Space(14) */
              _riga = _riga+CPLib.Space(14);
              /* _riga := _riga + iif(vt_cliente->genero='1','M','F') */
              _riga = _riga+(CPLib.eqr(Cursor_vt_cliente.GetString("genero"),"1")?"M":"F");
              /* _riga := _riga + arfn_fdate_nd(_datafindoc,"S") */
              _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(_datafindoc,"S");
              /* _riga := _riga + arfn_fdate_nd(_datainizio,'S') */
              _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(_datainizio,"S");
              /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_cliente->pri_apellido)+" "+LRTrim(vt_cliente->seg_apellido),26),26) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_cliente.GetString("pri_apellido"))+" "+CPLib.LRTrim(Cursor_vt_cliente.GetString("seg_apellido")),26),26);
              /* _riga := _riga + LibreriaMit.SpacePad(Left(LRTrim(vt_cliente->nom_cliente),25),25) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(CPLib.LRTrim(Cursor_vt_cliente.GetString("nom_cliente")),25),25);
              /* _riga := _riga + Space(100) */
              _riga = _riga+CPLib.Space(100);
              /* _riga := _riga + LibreriaMit.SpacePad(_provnas,2) */
              _riga = _riga+LibreriaMit.SpacePad(_provnas,2);
              /* _riga := _riga + iif((Empty(vt_cliente->cve_identificacion) or LRTrim(vt_cliente->cve_identificacion)='TURISTA') ,'N','S') */
              _riga = _riga+((CPLib.Empty(Cursor_vt_cliente.GetString("cve_identificacion")) || CPLib.eqr(CPLib.LRTrim(Cursor_vt_cliente.GetString("cve_identificacion")),"TURISTA"))?"N":"S");
              /* _riga := _riga + Space(37) */
              _riga = _riga+CPLib.Space(37);
              /* _riga := _riga + LibreriaMit.SpacePad(_connes,16) */
              _riga = _riga+LibreriaMit.SpacePad(_connes,16);
              /* _riga := _riga + Space(56) */
              _riga = _riga+CPLib.Space(56);
              /* _regval := 0 */
              _regval = CPLib.Round(0,0);
              /* _regione := '' */
              _regione = "";
              /* _provres := '' */
              _provres = "";
              // * --- Read from vt_estados
              m_cServer = m_Ctx.GetServer("vt_estados");
              m_cPhName = m_Ctx.GetPhName("vt_estados");
              m_cSql = "";
              m_cSql = m_cSql+"cve_estado="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_vt_cliente.GetString("cve_estado"),"C",5,0,m_cServer),m_cServer,Cursor_vt_cliente.GetString("cve_estado"));
              m_cSql = m_cSql+" and cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(380,"N",10,0,m_cServer),m_cServer,380);
              if (m_Ctx.IsSharedTemp("vt_estados")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id_estado",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("cve_estado",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _regval = CPLib.Round(Read_Cursor.GetDouble("id_estado"),0);
                _provres = Read_Cursor.GetString("cve_estado");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_estados into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _regval = 0;
                _provres = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from vt_regiones
              m_cServer = m_Ctx.GetServer("vt_regiones");
              m_cPhName = m_Ctx.GetPhName("vt_regiones");
              m_cSql = "";
              m_cSql = m_cSql+"id_region="+CPSql.SQLValueAdapter(CPLib.ToSQL(_regval,"N",10,0,m_cServer),m_cServer,_regval);
              if (m_Ctx.IsSharedTemp("vt_regiones")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("codice_MIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _regione = Read_Cursor.GetString("codice_MIT");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on vt_regiones into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _regione = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_regione) */
              if (CPLib.Empty(_regione)) {
                /* _riga := _riga + '00' */
                _riga = _riga+"00";
              } else { // Else
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_regione),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_regione),2);
              } // End If
              /* _occupazione := 0 */
              _occupazione = CPLib.Round(0,0);
              // * --- Select from vt_ocupaciones
              m_cServer = m_Ctx.GetServer("vt_ocupaciones");
              m_cPhName = m_Ctx.GetPhName("vt_ocupaciones");
              if (Cursor_vt_ocupaciones!=null)
                Cursor_vt_ocupaciones.Close();
              Cursor_vt_ocupaciones = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cliente="+CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_cliente"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("vt_ocupaciones")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"fecha_alta ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_ocupaciones.Eof())) {
                /* _occupazione := vt_ocupaciones->id_tipoocupacion */
                _occupazione = CPLib.Round(Cursor_vt_ocupaciones.GetDouble("id_tipoocupacion"),0);
                Cursor_vt_ocupaciones.Next();
              }
              m_cConnectivityError = Cursor_vt_ocupaciones.ErrorMessage();
              Cursor_vt_ocupaciones.Close();
              // * --- End Select
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Str(_occupazione,5,0)),5) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Str(_occupazione,5,0)),5);
              /* _bl := 0 */
              _bl = CPLib.Round(0,0);
              // * --- Select from vt_ide_ctbe_bol
              m_cServer = m_Ctx.GetServer("vt_ide_ctbe_bol");
              m_cPhName = m_Ctx.GetPhName("vt_ide_ctbe_bol");
              if (Cursor_vt_ide_ctbe_bol!=null)
                Cursor_vt_ide_ctbe_bol.Close();
              Cursor_vt_ide_ctbe_bol = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"cod_cte_ben="+CPLib.ToSQL(Cursor_vt_cliente.GetDouble("cod_cliente"),"?",0,0)+"  and  cod_status='A'  and  tipo=1 "+")"+(m_Ctx.IsSharedTemp("vt_ide_ctbe_bol")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_vt_ide_ctbe_bol.Eof())) {
                /* _bl := 1 */
                _bl = CPLib.Round(1,0);
                Cursor_vt_ide_ctbe_bol.Next();
              }
              m_cConnectivityError = Cursor_vt_ide_ctbe_bol.ErrorMessage();
              Cursor_vt_ide_ctbe_bol.Close();
              // * --- End Select
              /* _riga := _riga + iif(_bl=1,'S','N') */
              _riga = _riga+(CPLib.eqr(_bl,1)?"S":"N");
              /* If _paesedoc=380 */
              if (CPLib.eqr(_paesedoc,380)) {
                /* _emettidoc := 'IT' */
                _emettidoc = "IT";
                /* ElseIf _paesedoc=0 */
              } else if (CPLib.eqr(_paesedoc,0)) {
                /* _emettidoc := 'ND' */
                _emettidoc = "ND";
              } else { // Else
                // * --- Read from vt_paises
                m_cServer = m_Ctx.GetServer("vt_paises");
                m_cPhName = m_Ctx.GetPhName("vt_paises");
                m_cSql = "";
                m_cSql = m_cSql+"cod_pais="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paesedoc,"N",10,0,m_cServer),m_cServer,_paesedoc);
                if (m_Ctx.IsSharedTemp("vt_paises")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("con_edocta",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _paesedoc = CPLib.Round(Read_Cursor.GetDouble("con_edocta"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on vt_paises into routine arrt_import_valutrans returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _paesedoc = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _emettidoc := iif(_paesedoc=1,'UE','XX') */
                _emettidoc = (CPLib.eqr(_paesedoc,1)?"UE":"XX");
              } // End If
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_emettidoc),2) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_emettidoc),2);
              Cursor_vt_cliente.Next();
            }
            m_cConnectivityError = Cursor_vt_cliente.ErrorMessage();
            Cursor_vt_cliente.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(LRTrim(_riga))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_riga)))) {
            /* FileLibMit.WriteLine(fhand,_riga) */
            FileLibMit.WriteLine(fhand,_riga);
          } // End If
        }
        /* _messaggio := _messaggio + 'Estrazione Aggiornamento Soggetti - N. Record Elaborati: '+LRTrim(Str(_conta,10,0))+NL */
        _messaggio = _messaggio+"Estrazione Aggiornamento Soggetti - N. Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\n";
        /* If pTipo='O' */
        if (CPLib.eqr(pTipo,"O")) {
          /* gMsgProc := _messaggio */
          gMsgProc = _messaggio;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // Chiude il file e lo cancella se vuoto
        FileLibMit.Close(fhand);
        if (_conta==0) {
          FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(_gAzienda)+"/AUINEW_"+CPLib.DateToChar(_dataestrai));
        }
      } // End If
    } finally {
      try {
        if (Cursor_qbe_vt_cis_his_alteraciones!=null)
          Cursor_qbe_vt_cis_his_alteraciones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_giros_cliente!=null)
          Cursor_qbe_vt_giros_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_cis_giros_pagados_cliente!=null)
          Cursor_qbe_vt_cis_giros_pagados_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_cambios_cliente!=null)
          Cursor_qbe_vt_cambios_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_vt_maxdata_snd!=null)
          Cursor_qbe_vt_maxdata_snd.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_giros!=null)
          Cursor_vt_giros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_historico_giros!=null)
          Cursor_vt_historico_giros.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cis_giros_pagados!=null)
          Cursor_vt_cis_giros_pagados.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cambios!=null)
          Cursor_vt_cambios.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_documentos!=null)
          Cursor_vt_documentos.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_paises!=null)
          Cursor_vt_paises.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_cliente!=null)
          Cursor_vt_cliente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_mit_citta!=null)
          Cursor_vt_mit_citta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ocupaciones!=null)
          Cursor_vt_ocupaciones.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_vt_ide_ctbe_bol!=null)
          Cursor_vt_ide_ctbe_bol.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=Run();
        } finally {
          //evito di tenere nell'heap della virtual machine riferimenti non piu' usati
          m_Caller = null;
          m_Sql = null;
          m_Ctx = null;
        }
      }
    }
    ,m_MessageSink
    );
  }
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
    return Run();
  }
  public Forward Run() {
    Forward f;
    f = Forward.Unforwarded;
    m_Ctx = m_Ctx.DisabledDataFilteringVersion();
    try {
      try {
        try {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent("Run start",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
          Page_1();
        } finally {
          try {
            m_bEventRunning = true;
            com.zucchetti.sitepainter.EventHandler.notifyEvent(com.zucchetti.sitepainter.EventHandler.RUN_END,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
          } finally {
            m_bEventRunning = false;
          }
        }
      } catch(Forward forward) {
        f=forward;
      } catch(Stop stop_value) {
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        CPStdCounter.Error(fault);
        CallerExImpl l_oTraceSink;
        l_oTraceSink = new CallerExImpl(m_Caller,"");
        if (l_oTraceSink.HasWorkingVar("m_cFaultTrace")) {
          if ( ! (CPLib.IsAdministrator(m_Ctx)) && m_Ctx.HasAdministeredUsers()) {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,"MSG_ADMIN_REQUIRED");
          } else {
            l_oTraceSink.SetString("m_cFaultTrace","C",0,0,CPLib.DumpException(fault));
          }
        }
      }
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_valutransR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_valutransR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    fhand = CPLib.Space(1);
    _riga = "";
    _citta = CPLib.Space(50);
    _nazage = CPLib.Space(3);
    _isonaz = CPLib.Space(3);
    _agentep = 0;
    _regione = CPLib.Space(2);
    _regval = 0;
    _datiaos = 0;
    _dataestrai = CPLib.NullDate();
    _dataestcmb = CPLib.NullDate();
    _luonas = CPLib.Space(50);
    _occupazione = 0;
    _bl = 0;
    _paesedoc = 0;
    _emettidoc = CPLib.Space(2);
    _datainidoc = CPLib.NullDate();
    _datafindoc = CPLib.NullDate();
    _autorita = CPLib.Space(100);
    _tipdoc = CPLib.Space(2);
    _paese = CPLib.Space(60);
    _provres = CPLib.Space(5);
    _isopais = CPLib.Space(4);
    _codstades = CPLib.Space(3);
    _cabdip = CPLib.Space(6);
    _desintcon = CPLib.Space(40);
    _ntrx = 0;
    _cambio = 0;
    _cambioc = CPLib.Space(5);
    _gAzienda = CPLib.Space(10);
    _messaggio = "";
    _conta = 0;
    cProg = CPLib.Space(20);
    _numdoc = CPLib.Space(25);
    _iddoc = 0;
    _connes = CPLib.Space(16);
    _datacanc = CPLib.Space(10);
    _cliprov = 0;
    _foliocli = 0;
    _paisnas = 0;
    _statomit = CPLib.Space(3);
    _citres = 0;
    _paisres = 0;
    _numdays = 0;
    _numdcmb = 0;
    _lastmod = CPLib.NullDate();
    _iddocumento = 0;
    _codinstu = 0;
    _comrila = CPLib.Space(10);
    _desaut = CPLib.Space(100);
    _descitaut = CPLib.Space(40);
    mcClienti = new MemoryCursor_mcvt_cliente_mcrdef();
    _datainizio = CPLib.NullDate();
    _ncliente = 0;
    _provnas = CPLib.Space(2);
    _import = 0;
    _codmit = CPLib.Space(3);
    _desmit = CPLib.Space(40);
    _pathapp = CPLib.Space(80);
    _capcli = CPLib.Space(5);
    _codsae = CPLib.Space(3);
    _setsint = CPLib.Space(3);
    mcTBCITTA = new MemoryCursor_tbcitta();
    mcTBCITTA_SIG = new MemoryCursor_tbcitta();
    mcTBSTATI = new MemoryCursor_tbstati();
    mcTBSTATI_SIG = new MemoryCursor_tbstati();
    mcTBSTATI_AUI = new MemoryCursor_tbstati();
    mcMIT_CITTA = new MemoryCursor_vt_mit_citta();
    mcPAISES = new MemoryCursor_vt_paises();
    mcREGIONES = new MemoryCursor_vt_regiones();
    mcMIT_PAISES = new MemoryCursor_vt_mit_paises();
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_vt_agentes,qbe_vt_giros,qbe_vt_cliente_lastmod,qbe_vt_cliente_lastmod,qbe_vt_cliente_lastmod,qbe_vt_ide_mon_cancelacion,qbe_vt_giros_otros,qbe_vt_cliente_lastmod,qbe_vt_cliente_lastmod,qbe_vt_cis_his_alteraciones,qbe_vt_giros_cliente,qbe_vt_cis_giros_pagados_cliente,qbe_vt_cambios_cliente,qbe_vt_maxdata_snd,
  public static final String m_cVQRList = ",qbe_vt_agentes,qbe_vt_giros,qbe_vt_cliente_lastmod,qbe_vt_cliente_lastmod,qbe_vt_cliente_lastmod,qbe_vt_ide_mon_cancelacion,qbe_vt_giros_otros,qbe_vt_cliente_lastmod,qbe_vt_cliente_lastmod,qbe_vt_cis_his_alteraciones,qbe_vt_giros_cliente,qbe_vt_cis_giros_pagados_cliente,qbe_vt_cambios_cliente,qbe_vt_maxdata_snd,";
  // ENTITY_BATCHES: ,arfn_dateminus,arfn_fdate,arfn_fdate_nd,arfn_fdatetime,arrt_import_rtra,
  public static final String i_InvokedRoutines = ",arfn_dateminus,arfn_fdate,arfn_fdate_nd,arfn_fdatetime,arrt_import_rtra,";
  public static String[] m_cRunParameterNames={"pTipo"};
  protected static String GetFieldsName_0000009B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+"LOGTYPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+"LOGTYPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"cod_cliente,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"dtinsert,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"vt_cis_mit_cliente_connes",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000282(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"cod_cliente,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"dtinsert,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"vt_cis_mit_cliente_connes",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000383(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"cod_cliente,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"dtinsert,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"vt_cis_mit_cliente_connes",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000427(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"cod_cliente,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"dtinsert,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"vt_cis_mit_cliente_connes",true);
    return p_cSql;
  }
}
