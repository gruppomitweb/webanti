// * --- Area Manuale = BO - Header
// * --- arfn_readxml_rilievi
import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.XML;
// * --- Fine Area Manuale
public class arfn_readxml_rilieviR implements CallerWithObjs {
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
  public String pFile;
  public String gAzienda;
  public String gPathDoc;
  public String _datarif;
  public MemoryCursor_mcrilievisara_mcrdef mcRilievi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_readxml_rilieviR (CPContext p_ContextObject, Caller caller) {
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
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_readxml_rilievi",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_readxml_rilievi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("_datarif",p_cVarName)) {
      return _datarif;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcRilievi",p_cVarName)) {
      return mcRilievi;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_datarif",p_cVarName)) {
      _datarif = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcRilievi",p_cVarName)) {
      mcRilievi = (MemoryCursor_mcrilievisara_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* pFile Char(50) // Nome file contenente i rilievi */
    /* gAzienda Char(10) // Azienda */
    /* gPathDoc Char(128) // Path Documenti */
    /* _filexml Char(100) */
    String _filexml;
    _filexml = CPLib.Space(100);
    /* _xml Memo */
    String _xml;
    _xml = "";
    /* _datarif Char(8) */
    /* jsonObject Object(JSONObject) */
    JSONObject jsonObject;
    jsonObject = null;
    /* jsonMessage Object(JSONObject) */
    JSONObject jsonMessage;
    jsonMessage = null;
    /* jsonContent Object(JSONObject) */
    JSONObject jsonContent;
    jsonContent = null;
    /* jsonSection Object(JSONObject) */
    JSONObject jsonSection;
    jsonSection = null;
    /* jsonSections Object(JSONArray) */
    JSONArray jsonSections;
    jsonSections = null;
    /*  jsonRilievi Object(JSONArray) */
    JSONArray  jsonRilievi;
     jsonRilievi = null;
    /* jsonRilievo Object(JSONObject) */
    JSONObject jsonRilievo;
    jsonRilievo = null;
    /* jsonItem Object(JSONObject) */
    JSONObject jsonItem;
    jsonItem = null;
    /* jsonDimensions Object(JSONArray) */
    JSONArray jsonDimensions;
    jsonDimensions = null;
    /* jsonDimension Object(JSONObject) */
    JSONObject jsonDimension;
    jsonDimension = null;
    /* mcRilievi MemoryCursor(mcRilieviSara.MCRDef) */
    /* If Empty(pFile) */
    if (CPLib.Empty(pFile)) {
      for (int z = 0; CPLib.ne(z,20); z = z + (1)) {
        /* mcRilievi.AppendBlank() */
        mcRilievi.AppendBlank();
      }
    } else { // Else
      /* _filexml := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/"+LRTrim(pFile)) */
      _filexml = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pFile));
      /* _xml := '' */
      _xml = "";
      /* While not(FileLibMit.Eof(_filexml)) */
      while ( ! (FileLibMit.Eof(_filexml))) {
        /* _xml := _xml + FileLibMit.ReadLine(_filexml) */
        _xml = _xml+FileLibMit.ReadLine(_filexml);
      } // End While
      // Legge
      FileLibMit.Close(_filexml);
      /* jsonObject := new JSONObject(XML.toJSONObject(_xml,true).toString()) */
      jsonObject = new JSONObject(XML.toJSONObject(_xml,true).toString());
      /* jsonMessage := jsonObject.getJSONObject("ns2:message") */
      jsonMessage = jsonObject.getJSONObject("ns2:message");
      /* jsonContent := jsonMessage.getJSONObject("content") */
      jsonContent = jsonMessage.getJSONObject("content");
      /* If jsonContent.get("section") instanceof JSONArray */
      if (jsonContent.get("section") instanceof JSONArray) {
        /* jsonSections := jsonContent.getJSONArray("section") */
        jsonSections = jsonContent.getJSONArray("section");
        for (int _j = 0; CPLib.ne(_j,jsonSections.length()); _j = _j + (1)) {
          /* jsonSection := jsonSections.getJSONObject(_j) */
          jsonSection = jsonSections.getJSONObject(_j);
          /* If jsonSection.get("remark") instanceof JSONArray */
          if (jsonSection.get("remark") instanceof JSONArray) {
            /*  jsonRilievi := jsonSection.getJSONArray("remark"); */
             jsonRilievi = jsonSection.getJSONArray("remark");
            for (int _y = 0; CPLib.ne(_y,jsonRilievi.length()); _y = _y + (1)) {
              /* jsonRilievo := jsonRilievi.getJSONObject(_y) */
              jsonRilievo = jsonRilievi.getJSONObject(_y);
              /* jsonItem := jsonRilievo.getJSONObject("remarkItem") */
              jsonItem = jsonRilievo.getJSONObject("remarkItem");
              /* jsonDimensions := jsonItem.getJSONArray("dimensions"); */
              jsonDimensions = jsonItem.getJSONArray("dimensions");
              /* mcRilievi.AppendBlank() */
              mcRilievi.AppendBlank();
              /* mcRilievi.ID := jsonItem.get("uniqueId").toString() */
              mcRilievi.row.ID = jsonItem.get("uniqueId").toString();
              /* mcRilievi.MOTIVO := jsonItem.get("remarkDescription").toString() */
              mcRilievi.row.MOTIVO = jsonItem.get("remarkDescription").toString();
              /* mcRilievi.TIPOLOGIA := jsonItem.get("objectId").toString() */
              mcRilievi.row.TIPOLOGIA = jsonItem.get("objectId").toString();
              for (int _i = 0; CPLib.ne(_i,jsonDimensions.length()); _i = _i + (1)) {
                /* jsonDimension := jsonDimensions.getJSONObject(_i) */
                jsonDimension = jsonDimensions.getJSONObject(_i);
                /* Case jsonDimension.get("name").toString()="CAUSALE_AGGREGATA" */
                if (CPLib.eqr(jsonDimension.get("name").toString(),"CAUSALE_AGGREGATA")) {
                  /* mcRilievi.CAUSALE_AGGREGATA := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.CAUSALE_AGGREGATA = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.CAUSALE_AGGREGATA_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.CAUSALE_AGGREGATA_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="CODICE_INTERNO_DIP" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_INTERNO_DIP")) {
                  /* mcRilievi.CODICE_INTERNO_DIP := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.CODICE_INTERNO_DIP = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.CODICE_INTERNO_DIP_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.CODICE_INTERNO_DIP_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="CODICE_SEGNALANTE" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_SEGNALANTE")) {
                  /* mcRilievi.CODICE_SEGNALANTE := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.CODICE_SEGNALANTE = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.CODICE_SEGNALANTE_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.CODICE_SEGNALANTE_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="CODICE_VALUTA" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_VALUTA")) {
                  /* mcRilievi.CODICE_VALUTA := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.CODICE_VALUTA = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.CODICE_VALUTA_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.CODICE_VALUTA_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="COMUNE_CONTROPARTE" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_CONTROPARTE")) {
                  /* mcRilievi.COMUNE_CONTROPARTE := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.COMUNE_CONTROPARTE = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.COMUNE_CONTROPARTE_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.COMUNE_CONTROPARTE_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="COMUNE_INTERM_CTRP" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_INTERM_CTRP")) {
                  /* mcRilievi.COMUNE_INTERM_CTRP := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.COMUNE_INTERM_CTRP = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.COMUNE_INTERM_CTRP_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.COMUNE_INTERM_CTRP_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="COMUNE_DIP" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_DIP")) {
                  /* mcRilievi.COMUNE_DIP := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.COMUNE_DIP = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.COMUNE_DIP_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.COMUNE_DIP_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="COMUNE_RES_CLIENTE" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_RES_CLIENTE")) {
                  /* mcRilievi.COMUNE_RES_CLIENTE := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.COMUNE_RES_CLIENTE = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.COMUNE_RES_CLIENTE_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.COMUNE_RES_CLIENTE_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="DATA_RIFERIMENTO" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"DATA_RIFERIMENTO")) {
                  /* _datarif := jsonDimension.get("alphabeticValue").toString() */
                  _datarif = jsonDimension.get("alphabeticValue").toString();
                  /* mcRilievi.DATA_RIFERIMENTO := CharToDate(_datarif) */
                  mcRilievi.row.DATA_RIFERIMENTO = CPLib.CharToDate(_datarif);
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.DATA_RIFERIMENTO_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.DATA_RIFERIMENTO_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="PAESE_CONTROPARTE" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_CONTROPARTE")) {
                  /* mcRilievi.PAESE_CONTROPARTE := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.PAESE_CONTROPARTE = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.PAESE_CONTROPARTE_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.PAESE_CONTROPARTE_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="PAESE_INTERM_CTRP" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_INTERM_CTRP")) {
                  /* mcRilievi.PAESE_INTERM_CTRP := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.PAESE_INTERM_CTRP = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.PAESE_INTERM_CTRP_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.PAESE_INTERM_CTRP_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="PAESE_RES_CLIENTE" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_RES_CLIENTE")) {
                  /* mcRilievi.PAESE_RES_CLIENTE := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.PAESE_RES_CLIENTE = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.PAESE_RES_CLIENTE_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.PAESE_RES_CLIENTE_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="SEGNO_MONETARIO" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"SEGNO_MONETARIO")) {
                  /* mcRilievi.SEGNO_MONETARIO := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.SEGNO_MONETARIO = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.SEGNO_MONETARIO_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.SEGNO_MONETARIO_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="SETTORIZ_SINT_ECON" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"SETTORIZ_SINT_ECON")) {
                  /* mcRilievi.SETTORIZ_SINT_ECON := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.SETTORIZ_SINT_ECON = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.SETTORIZ_SINT_ECON_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.SETTORIZ_SINT_ECON_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="TIPO_SEGNALANTE" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"TIPO_SEGNALANTE")) {
                  /* mcRilievi.TIPO_SEGNALANTE := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.TIPO_SEGNALANTE = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.TIPO_SEGNALANTE_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.TIPO_SEGNALANTE_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="IMPORTO_TOT" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"IMPORTO_TOT")) {
                  /* mcRilievi.IMPORTO_TOT := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                  mcRilievi.row.IMPORTO_TOT = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.IMPORTO_TOT_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.IMPORTO_TOT_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="IMPORTO_TOT_CONTANTI" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"IMPORTO_TOT_CONTANTI")) {
                  /* mcRilievi.IMPORTO_TOT_CONTANTI := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                  mcRilievi.row.IMPORTO_TOT_CONTANTI = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.IMPORTO_TOT_CONTANTI_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.IMPORTO_TOT_CONTANTI_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="NUMERO_OPER_CONT" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"NUMERO_OPER_CONT")) {
                  /* mcRilievi.NUMERO_OPER_CONT := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                  mcRilievi.row.NUMERO_OPER_CONT = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.NUMERO_OPER_CONT_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.NUMERO_OPER_CONT_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="NUMERO_TOT_OPER" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"NUMERO_TOT_OPER")) {
                  /* mcRilievi.NUMERO_TOT_OPER := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                  mcRilievi.row.NUMERO_TOT_OPER = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.NUMERO_TOT_OPER_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.NUMERO_TOT_OPER_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                  /* Case jsonDimension.get("name").toString()="ABICAB_SPORTELLO" */
                } else if (CPLib.eqr(jsonDimension.get("name").toString(),"ABICAB_SPORTELLO")) {
                  /* mcRilievi.ABICAB_SPORTELLO := jsonDimension.get("alphabeticValue").toString() */
                  mcRilievi.row.ABICAB_SPORTELLO = jsonDimension.get("alphabeticValue").toString();
                  /* If jsonDimension.has("remarkDescription") */
                  if (jsonDimension.has("remarkDescription")) {
                    /* mcRilievi.ABICAB_SPORTELLO_ERR := jsonDimension.get("remarkDescription").toString() */
                    mcRilievi.row.ABICAB_SPORTELLO_ERR = jsonDimension.get("remarkDescription").toString();
                  } // End If
                } // End Case
              }
              /* mcRilievi.SaveRow() */
              mcRilievi.SaveRow();
            }
          } else { // Else
            /* jsonRilievo := jsonSection.getJSONObject("remark") */
            jsonRilievo = jsonSection.getJSONObject("remark");
            /* jsonItem := jsonRilievo.getJSONObject("remarkItem") */
            jsonItem = jsonRilievo.getJSONObject("remarkItem");
            /* jsonDimensions := jsonItem.getJSONArray("dimensions"); */
            jsonDimensions = jsonItem.getJSONArray("dimensions");
            /* mcRilievi.AppendBlank() */
            mcRilievi.AppendBlank();
            /* mcRilievi.ID := jsonItem.get("uniqueId").toString() */
            mcRilievi.row.ID = jsonItem.get("uniqueId").toString();
            /* mcRilievi.MOTIVO := jsonItem.get("remarkDescription").toString() */
            mcRilievi.row.MOTIVO = jsonItem.get("remarkDescription").toString();
            /* mcRilievi.TIPOLOGIA := jsonItem.get("objectId").toString() */
            mcRilievi.row.TIPOLOGIA = jsonItem.get("objectId").toString();
            for (int _i = 0; CPLib.ne(_i,jsonDimensions.length()); _i = _i + (1)) {
              /* jsonDimension := jsonDimensions.getJSONObject(_i) */
              jsonDimension = jsonDimensions.getJSONObject(_i);
              /* Case jsonDimension.get("name").toString()="CAUSALE_AGGREGATA" */
              if (CPLib.eqr(jsonDimension.get("name").toString(),"CAUSALE_AGGREGATA")) {
                /* mcRilievi.CAUSALE_AGGREGATA := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CAUSALE_AGGREGATA = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CAUSALE_AGGREGATA_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CAUSALE_AGGREGATA_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="CODICE_INTERNO_DIP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_INTERNO_DIP")) {
                /* mcRilievi.CODICE_INTERNO_DIP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CODICE_INTERNO_DIP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CODICE_INTERNO_DIP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CODICE_INTERNO_DIP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="CODICE_SEGNALANTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_SEGNALANTE")) {
                /* mcRilievi.CODICE_SEGNALANTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CODICE_SEGNALANTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CODICE_SEGNALANTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CODICE_SEGNALANTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="CODICE_VALUTA" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_VALUTA")) {
                /* mcRilievi.CODICE_VALUTA := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CODICE_VALUTA = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CODICE_VALUTA_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CODICE_VALUTA_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_CONTROPARTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_CONTROPARTE")) {
                /* mcRilievi.COMUNE_CONTROPARTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_CONTROPARTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_CONTROPARTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_CONTROPARTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_INTERM_CTRP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_INTERM_CTRP")) {
                /* mcRilievi.COMUNE_INTERM_CTRP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_INTERM_CTRP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_INTERM_CTRP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_INTERM_CTRP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_DIP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_DIP")) {
                /* mcRilievi.COMUNE_DIP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_DIP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_DIP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_DIP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_RES_CLIENTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_RES_CLIENTE")) {
                /* mcRilievi.COMUNE_RES_CLIENTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_RES_CLIENTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_RES_CLIENTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_RES_CLIENTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="DATA_RIFERIMENTO" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"DATA_RIFERIMENTO")) {
                /* _datarif := jsonDimension.get("alphabeticValue").toString() */
                _datarif = jsonDimension.get("alphabeticValue").toString();
                /* mcRilievi.DATA_RIFERIMENTO := CharToDate(_datarif) */
                mcRilievi.row.DATA_RIFERIMENTO = CPLib.CharToDate(_datarif);
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.DATA_RIFERIMENTO_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.DATA_RIFERIMENTO_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="PAESE_CONTROPARTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_CONTROPARTE")) {
                /* mcRilievi.PAESE_CONTROPARTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.PAESE_CONTROPARTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.PAESE_CONTROPARTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.PAESE_CONTROPARTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="PAESE_INTERM_CTRP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_INTERM_CTRP")) {
                /* mcRilievi.PAESE_INTERM_CTRP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.PAESE_INTERM_CTRP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.PAESE_INTERM_CTRP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.PAESE_INTERM_CTRP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="PAESE_RES_CLIENTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_RES_CLIENTE")) {
                /* mcRilievi.PAESE_RES_CLIENTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.PAESE_RES_CLIENTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.PAESE_RES_CLIENTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.PAESE_RES_CLIENTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="SEGNO_MONETARIO" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"SEGNO_MONETARIO")) {
                /* mcRilievi.SEGNO_MONETARIO := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.SEGNO_MONETARIO = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.SEGNO_MONETARIO_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.SEGNO_MONETARIO_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="SETTORIZ_SINT_ECON" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"SETTORIZ_SINT_ECON")) {
                /* mcRilievi.SETTORIZ_SINT_ECON := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.SETTORIZ_SINT_ECON = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.SETTORIZ_SINT_ECON_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.SETTORIZ_SINT_ECON_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="TIPO_SEGNALANTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"TIPO_SEGNALANTE")) {
                /* mcRilievi.TIPO_SEGNALANTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.TIPO_SEGNALANTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.TIPO_SEGNALANTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.TIPO_SEGNALANTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="IMPORTO_TOT" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"IMPORTO_TOT")) {
                /* mcRilievi.IMPORTO_TOT := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.IMPORTO_TOT = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.IMPORTO_TOT_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.IMPORTO_TOT_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="IMPORTO_TOT_CONTANTI" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"IMPORTO_TOT_CONTANTI")) {
                /* mcRilievi.IMPORTO_TOT_CONTANTI := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.IMPORTO_TOT_CONTANTI = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.IMPORTO_TOT_CONTANTI_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.IMPORTO_TOT_CONTANTI_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="NUMERO_OPER_CONT" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"NUMERO_OPER_CONT")) {
                /* mcRilievi.NUMERO_OPER_CONT := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.NUMERO_OPER_CONT = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.NUMERO_OPER_CONT_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.NUMERO_OPER_CONT_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="NUMERO_TOT_OPER" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"NUMERO_TOT_OPER")) {
                /* mcRilievi.NUMERO_TOT_OPER := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.NUMERO_TOT_OPER = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.NUMERO_TOT_OPER_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.NUMERO_TOT_OPER_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="ABICAB_SPORTELLO" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"ABICAB_SPORTELLO")) {
                /* mcRilievi.ABICAB_SPORTELLO := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.ABICAB_SPORTELLO = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.ABICAB_SPORTELLO_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.ABICAB_SPORTELLO_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
              } // End Case
            }
            /* mcRilievi.SaveRow() */
            mcRilievi.SaveRow();
          } // End If
        }
      } else { // Else
        /* jsonSection := jsonContent.getJSONObject("section") */
        jsonSection = jsonContent.getJSONObject("section");
        /* If jsonSection.get("remark") instanceof JSONArray */
        if (jsonSection.get("remark") instanceof JSONArray) {
          /*  jsonRilievi := jsonSection.getJSONArray("remark"); */
           jsonRilievi = jsonSection.getJSONArray("remark");
          for (int _z = 0; CPLib.ne(_z,jsonRilievi.length()); _z = _z + (1)) {
            /* jsonRilievo := jsonRilievi.getJSONObject(_z) */
            jsonRilievo = jsonRilievi.getJSONObject(_z);
            /* jsonItem := jsonRilievo.getJSONObject("remarkItem") */
            jsonItem = jsonRilievo.getJSONObject("remarkItem");
            /* jsonDimensions := jsonItem.getJSONArray("dimensions"); */
            jsonDimensions = jsonItem.getJSONArray("dimensions");
            /* mcRilievi.AppendBlank() */
            mcRilievi.AppendBlank();
            /* mcRilievi.ID := jsonItem.get("uniqueId").toString() */
            mcRilievi.row.ID = jsonItem.get("uniqueId").toString();
            /* mcRilievi.MOTIVO := jsonItem.get("remarkDescription").toString() */
            mcRilievi.row.MOTIVO = jsonItem.get("remarkDescription").toString();
            /* mcRilievi.TIPOLOGIA := jsonItem.get("objectId").toString() */
            mcRilievi.row.TIPOLOGIA = jsonItem.get("objectId").toString();
            for (int _i = 0; CPLib.ne(_i,jsonDimensions.length()); _i = _i + (1)) {
              /* jsonDimension := jsonDimensions.getJSONObject(_i) */
              jsonDimension = jsonDimensions.getJSONObject(_i);
              /* Case jsonDimension.get("name").toString()="CAUSALE_AGGREGATA" */
              if (CPLib.eqr(jsonDimension.get("name").toString(),"CAUSALE_AGGREGATA")) {
                /* mcRilievi.CAUSALE_AGGREGATA := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CAUSALE_AGGREGATA = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CAUSALE_AGGREGATA_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CAUSALE_AGGREGATA_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="CODICE_INTERNO_DIP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_INTERNO_DIP")) {
                /* mcRilievi.CODICE_INTERNO_DIP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CODICE_INTERNO_DIP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CODICE_INTERNO_DIP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CODICE_INTERNO_DIP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="CODICE_SEGNALANTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_SEGNALANTE")) {
                /* mcRilievi.CODICE_SEGNALANTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CODICE_SEGNALANTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CODICE_SEGNALANTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CODICE_SEGNALANTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="CODICE_VALUTA" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"CODICE_VALUTA")) {
                /* mcRilievi.CODICE_VALUTA := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.CODICE_VALUTA = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.CODICE_VALUTA_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.CODICE_VALUTA_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_CONTROPARTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_CONTROPARTE")) {
                /* mcRilievi.COMUNE_CONTROPARTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_CONTROPARTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_CONTROPARTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_CONTROPARTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_INTERM_CTRP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_INTERM_CTRP")) {
                /* mcRilievi.COMUNE_INTERM_CTRP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_INTERM_CTRP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_INTERM_CTRP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_INTERM_CTRP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_DIP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_DIP")) {
                /* mcRilievi.COMUNE_DIP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_DIP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_DIP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_DIP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="COMUNE_RES_CLIENTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"COMUNE_RES_CLIENTE")) {
                /* mcRilievi.COMUNE_RES_CLIENTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.COMUNE_RES_CLIENTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.COMUNE_RES_CLIENTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.COMUNE_RES_CLIENTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="DATA_RIFERIMENTO" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"DATA_RIFERIMENTO")) {
                /* _datarif := jsonDimension.get("alphabeticValue").toString() */
                _datarif = jsonDimension.get("alphabeticValue").toString();
                /* mcRilievi.DATA_RIFERIMENTO := CharToDate(_datarif) */
                mcRilievi.row.DATA_RIFERIMENTO = CPLib.CharToDate(_datarif);
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.DATA_RIFERIMENTO_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.DATA_RIFERIMENTO_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="PAESE_CONTROPARTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_CONTROPARTE")) {
                /* mcRilievi.PAESE_CONTROPARTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.PAESE_CONTROPARTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.PAESE_CONTROPARTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.PAESE_CONTROPARTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="PAESE_INTERM_CTRP" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_INTERM_CTRP")) {
                /* mcRilievi.PAESE_INTERM_CTRP := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.PAESE_INTERM_CTRP = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.PAESE_INTERM_CTRP_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.PAESE_INTERM_CTRP_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="PAESE_RES_CLIENTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"PAESE_RES_CLIENTE")) {
                /* mcRilievi.PAESE_RES_CLIENTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.PAESE_RES_CLIENTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.PAESE_RES_CLIENTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.PAESE_RES_CLIENTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="SEGNO_MONETARIO" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"SEGNO_MONETARIO")) {
                /* mcRilievi.SEGNO_MONETARIO := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.SEGNO_MONETARIO = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.SEGNO_MONETARIO_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.SEGNO_MONETARIO_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="SETTORIZ_SINT_ECON" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"SETTORIZ_SINT_ECON")) {
                /* mcRilievi.SETTORIZ_SINT_ECON := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.SETTORIZ_SINT_ECON = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.SETTORIZ_SINT_ECON_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.SETTORIZ_SINT_ECON_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="TIPO_SEGNALANTE" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"TIPO_SEGNALANTE")) {
                /* mcRilievi.TIPO_SEGNALANTE := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.TIPO_SEGNALANTE = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.TIPO_SEGNALANTE_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.TIPO_SEGNALANTE_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="IMPORTO_TOT" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"IMPORTO_TOT")) {
                /* mcRilievi.IMPORTO_TOT := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.IMPORTO_TOT = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.IMPORTO_TOT_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.IMPORTO_TOT_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="IMPORTO_TOT_CONTANTI" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"IMPORTO_TOT_CONTANTI")) {
                /* mcRilievi.IMPORTO_TOT_CONTANTI := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.IMPORTO_TOT_CONTANTI = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.IMPORTO_TOT_CONTANTI_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.IMPORTO_TOT_CONTANTI_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="NUMERO_OPER_CONT" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"NUMERO_OPER_CONT")) {
                /* mcRilievi.NUMERO_OPER_CONT := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.NUMERO_OPER_CONT = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.NUMERO_OPER_CONT_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.NUMERO_OPER_CONT_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="NUMERO_TOT_OPER" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"NUMERO_TOT_OPER")) {
                /* mcRilievi.NUMERO_TOT_OPER := Double.valueOf(jsonDimension.get("alphabeticValue").toString()) */
                mcRilievi.row.NUMERO_TOT_OPER = Double.valueOf(jsonDimension.get("alphabeticValue").toString());
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.NUMERO_TOT_OPER_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.NUMERO_TOT_OPER_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
                /* Case jsonDimension.get("name").toString()="ABICAB_SPORTELLO" */
              } else if (CPLib.eqr(jsonDimension.get("name").toString(),"ABICAB_SPORTELLO")) {
                /* mcRilievi.ABICAB_SPORTELLO := jsonDimension.get("alphabeticValue").toString() */
                mcRilievi.row.ABICAB_SPORTELLO = jsonDimension.get("alphabeticValue").toString();
                /* If jsonDimension.has("remarkDescription") */
                if (jsonDimension.has("remarkDescription")) {
                  /* mcRilievi.ABICAB_SPORTELLO_ERR := jsonDimension.get("remarkDescription").toString() */
                  mcRilievi.row.ABICAB_SPORTELLO_ERR = jsonDimension.get("remarkDescription").toString();
                } // End If
              } // End Case
            }
            /* mcRilievi.SaveRow() */
            mcRilievi.SaveRow();
          }
        } else { // Else
          /* jsonRilievo := jsonSection.getJSONObject("remark") */
          jsonRilievo = jsonSection.getJSONObject("remark");
        } // End If
      } // End If
    } // End If
    /* Return mcRilievi */
    throw new Stop(mcRilievi);
  }
  void _init_() {
  }
  public String RunAsync(String p_pFile) {
    pFile = p_pFile;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
        } finally {
          //evito di tenere nell'heap della virtual machine riferimenti non piu' usati
          m_Caller = null;
          m_Sql = null;
          m_Ctx = null;
        }
      }
    }
    );
  }
  public MemoryCursor_mcrilievisara_mcrdef Run(String p_pFile) {
    pFile = p_pFile;
    return Run();
  }
  public MemoryCursor_mcrilievisara_mcrdef Run() {
    MemoryCursor_mcrilievisara_mcrdef l_result;
    l_result = null;
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
      } catch(Stop stop_value) {
        l_result = (MemoryCursor_mcrilievisara_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_readxml_rilieviR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_readxml_rilieviR(p_Ctx, p_Caller);
  }
  public static arfn_readxml_rilieviR Make(CPContext p_Ctx) {
    return new arfn_readxml_rilieviR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pFile = CPLib.Space(50);
    _datarif = CPLib.Space(8);
    mcRilievi = new MemoryCursor_mcrilievisara_mcrdef();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_readxml_rilievi,
  public static final String i_InvokedRoutines = ",arfn_readxml_rilievi,";
  public static String[] m_cRunParameterNames={"pFile"};
}
