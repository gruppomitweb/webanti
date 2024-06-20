/* exported
  getChartObjconfig getChartPropertyName getChartDataset
  getChartAddDataset getChartAddPropertyName getDatasetDemo
*/
var isTimeDemo = false;
if (typeof ZTObjects == "undefined")
	var ZTObjects = {};

/* PROPERTY NAME */
ZTObjects.FieldList1V = function () {
  return ["LABEL", "VALUE1"];
}

ZTObjects.FieldList2V = function () {
  return ["LABEL", "VALUE1", "VALUE2"];
}

ZTObjects.FieldList3V = function () {
  return ["LABEL", "VALUE1", "VALUE2", "VALUE3"];
}

ZTObjects.FieldList4V = function () {
  return ["LABEL", "VALUE1", "VALUE2", "VALUE3", "VALUE4"];
}

ZTObjects.FieldList8V = function () {
  return ["LABEL", "VALUE1", "VALUE2", "VALUE3", "VALUE4", "VALUE5", "VALUE6", "VALUE7", "VALUE8"];
}

ZTObjects.GeoFieldList = function () {
  return ["COUNTRY", "SUB1", "SUB2", "SUB3", "VALUE"]; 
}

ZTObjects.FieldList5V = function () {
  return ["LABEL", "VALUE1", "VALUE2", "VALUE3", "VALUE4", "VALUE5"];
}

/* OBJCONFIG */
ZTObjects.GENERICcobj = {
}

ZTObjects.LINEScobj = {
	//title: "Analisi articoli venduti nel negozio di Torino",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2,VALUE3",
  labelSeries: "Venduto 2015,Venduto 2016,Venduto 2017"
}

ZTObjects.BARScobj = {
	//title: "Trend per area geografica - Fatturato",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2",
  labelSeries: "2016,2017"
}

ZTObjects.WATERFcobj = {
	//title: "Guadagno su azioni investite - 2017",
	labelField: "LABEL",
	valueFields: "VALUE1",
	labelSeries: "Valore azioni"
}

ZTObjects.FUNNELcobj = {
	//title: "Andamento di un processo",
	labelField: "LABEL",
	valueFields: "VALUE1",
	labelSeries: "Valore attività"
}

ZTObjects.WORDCLOUDcobj = {
	//title: "Le parole piu' utilizzate nella Divina Commedia",
	labelField: "LABEL",
	valueFields: "VALUE1",
	labelSeries: "Parola"
}

ZTObjects.PIEcobj = {
  //title: "Analisi costi - budget preventivato per reparto",
  labelField: "LABEL",
  valueFields: "VALUE1",
  labelSeries: "Budget"
}

ZTObjects.RINGcobj = {
  //title: "Personale dipendente per titolo di studio",
  labelField: "LABEL",
  valueFields: "VALUE1",
  labelSeries: "Studio"
}

ZTObjects.PYRAMIDDISTRcobj = {
	//title: "Popolazione italiana",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2",
	labelSeries: "Maschi,Femmine"
}

ZTObjects.PARETOcobj = {
	//title: "Problemi comuni riscontrato nell'utilizzo di un app",
	labelField: "LABEL",
	valueFields: "VALUE1",
	labelSeries: "Problema"
}

ZTObjects.SCATTERcobj = {
	//title: "Abitanti per regione",
	labelField: "VALUE1",
	valueFields: "VALUE2",
	labelSeries: "LABEL"
}

ZTObjects.BUBBLEcobj = {
	//title: "Giovani laureati per regione",
	labelField: "VALUE1",
	valueFields: "VALUE3,VALUE2",
	labelSeries: "LABEL"
}

ZTObjects.RADARcobj = {
	//title: "Analisi costi",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2",
  labelSeries: "Budget,Spesa",
  dataOrder: "column"
}

ZTObjects.ARCDIALcobj = {
	//title: "Analisi rendita aziendale - settore commerciale",
	labelField: "LABEL",
	valueFields: "VALUE1",
  labelSeries: "Valore percentuale",
  minFields: "",
  maxFields: ""
}

ZTObjects.LIGHTScobj = {
	//title: "Giacenza magazzino per articolo",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2,VALUE3",
	labelSeries: "Lavatrice,Lavastoviglie,Frigorifero"
}

/*
ZTObjects.TREEMAPcobj = {
	title: "Densita' di popolazione per stato - USA",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2,VALUE3,VALUE4",
	labelSeries: "Northeast,Midwest,South,West"
}*/

ZTObjects.GEOMAPcobj = {
	title: "Densita' di popolazione per stato - USA",
  geoFields: "COUNTRY,SUB3",
  geoLevel: "1",
  valueFields: "VALUE",
  geoViews: ""
}

ZTObjects.GEOMAPITcobj = {
  //title: "Analisi quantitativo venduto",
  /*geoFields: "COUNTRY,SUB1",
  geoLevel: "1",
  valueFields: "VALUE",
  geoViews: "IT"
*/
  geoFields: "COUNTRY,SUB1",
  geoOpts: {
    level: "1",
    markers: { lat: 'LAT', lng: 'LNG', desc: 'DESC', key: '', type: 1 },
    onlyData: true,
    typeView: 3,
    view: "IT"
  },
  zooming: {},
  valueFields: "VALUE"
}

ZTObjects.AREAcobj = {
	//title: "Totale vendite 2016",
  labelField: "LABEL",
	valueFields: "VALUE1",
  labelSeries: "2016"
}

ZTObjects.SUNBcobj = {
	//title: "Densita' di popolazione per stato - USA",
  labelField: "COUNTRY,SUB1,SUB2,SUB3",
	valueFields: "VALUE",
  labelSeries: ""
}

ZTObjects.SUNBSTRcobj = {
	//title: "Densita' di popolazione per stato - USA",
  labelField: "COUNTRY,SUB1,SUB2,SUB3",
	valueFields: "VALUE",
  labelSeries: ""
}

ZTObjects.FORCEcobj = {
	//title: "Skills",
  labelField: "LABEL,VALUE1",
	valueFields: "VALUE2",
  labelSeries: ""
}

ZTObjects.FORCESTRcobj = {
	//title: "Skills",
  labelField: "LABEL,VALUE1,VALUE2,VALUE3",
  fieldClass: "",
	valueFields: "VALUE4",
  labelSeries: ""
}

ZTObjects.MATRIXcobj = {
  labelField: "LABEL,VALUE1",
  valueFields: "",
  fieldClass : "",
  labelSeries : ""
  ,oneDomain: true
}

ZTObjects.TIMEcobj = {
  labelField: "LABEL",
  valueFields: "VALUE1",
  labelSeries: "Analisi fatturato in migliaia di EURO"
}

ZTObjects.TREEMAPBARcobj = {
	//title: "Quantitativo venduto per area nell'anno 2017",
	labelField: "LABEL",
	valueFields: "VALUE1,VALUE2,VALUE3,VALUE4,VALUE5,VALUE6,VALUE7,VALUE8",
  labelSeries: "Area A,Area B,Area C,Area D,Area A1,Area B1,Area C1,Area D1"
}

ZTObjects.TREEMAPcobj = {
	//title: "Stati per popolazione",
	labelField: "LABEL,VALUE1",
	valueFields: "VALUE2",
	labelSeries: ""
}

ZTObjects.MARIMEKKOcobj = {
	//title: "",
	labelField: "LABEL,VALUE1",
	valueFields: "VALUE2"
}

ZTObjects.BCMATRIXcobj = {
  //additional
  labelSeries: "liv",
  xValues: "xda,xa",
  yValues: "yda_a",
  keyField: "classcode",
  additionalFieldsType: ["C", "N", "N", "C", "C"],
  // normal
  labelField: "VALUE1",
  valueFields: "VALUE2;VALUE3",
  labelFieldKey: "",
  classField: "VALUE4"
}

ZTObjects.SANKEYcobj = {
  labelField: "LABEL,VALUE1",
  valueFields: "VALUE2"
}

ZTObjects.PCOORDScobj = {
  keyField: "VALUE1",
  labelField: "LABEL",
  valueFields: "VALUE2,VALUE3,VALUE4,VALUE5",
  labelSeries: "area,0_14,15_64,65_max"
}

ZTObjects.VORONOIcobj = {
  labelField: "LABEL",
  valueFields: "VALUE2,VALUE3",
  labelSeries: "VALUE1"
}

/* DATASET */
ZTObjects.LINESData = function () {
  return [
    [ "Gennaio", 13, 37, 71, 120 ],
    [ "Febbraio", 11, 42, 67, 150 ],
    [ "Marzo", 15, 49, 63, 110 ],
    [ "Aprile", 16, 46, 48, 15 ],
    [ "Maggio", 18, 47, 32, 123 ],
    [ "Giugno", 13, 55, 21, 74 ],
    [ "Luglio", 22, 59, 18, 45 ],
    [ "Agosto", 23, 58, 21, 12 ],
    [ "Settembre", 20, 57, 28, 30 ],
    [ "Ottobre", 17, 61, 27, 88 ],
    [ "Novembre", 16, 59, 36, 90 ],
    [ "Dicembre", 18, 67, 33, 10 ]
  ];
}

ZTObjects.TREEMAPBARData = function () {
  return [
    [ "Gennaio", 13, 37, 71, 120, 10, 25, 30, 65 ],
    [ "Febbraio", 11, 42, 67, 150, 100, 99, 78, 12 ],
    [ "Marzo", 15, 49, 63, 110, 20, 35, 74, 110 ],
    [ "Aprile", 16, 46, 48, 15, 32, 78, 96, 60 ],
    [ "Maggio", 18, 47, 32, 123, 54, 67, 98, 12 ],
    [ "Giugno", 13, 55, 21, 74, 22, 59, 18, 45 ],
    [ "Luglio", 22, 59, 18, 45, 18, 67, 33, 10 ],
    [ "Agosto", 23, 58, 21, 12, 11, 42, 67, 150 ],
    [ "Settembre", 20, 57, 28, 30, 13, 55, 21, 74 ],
    [ "Ottobre", 10, 25, 30, 65, 17, 61, 27, 88 ],
    [ "Novembre", 16, 59, 36, 90, 77, 41, 99, 10 ],
    [ "Dicembre", 18, 67, 33, 10, 17, 61, 27, 88 ]
  ];
}

ZTObjects.BARSData = function () {
  return [
    [ "Area 1", 37, 0/*71*/ ],
    [ "Area 2", 42, 67 ],
    [ "Area 3", 49, 0/*63*/ ],
    [ "Area 4", 46, 48 ],
    [ "Area 5", 47, 32 ],
    [ "Area 6", 55, 21 ],
    [ "Area 7", 59, 18 ],
    [ "Area 8", 58, 21 ],
    [ "Area 9", 57, 28 ],
    [ "Area 10", 61, 27 ]
  ];
}

ZTObjects.WATERFData = function () {
  return [
    [ "Gennaio", 2000 ],
    [ "Febbraio", 2500 ],
    [ "Marzo", 3500 ],
    [ "Aprile", 4500 ],
    [ "Maggio", 3000 ],
    [ "Giugno", 2250 ],
    [ "Luglio", 2700 ],
    [ "Agosto", 3200 ],
    [ "Settembre", 2500 ],
    [ "Ottobre", 4000 ],
    [ "Novembre", 3500 ],
    [ "Dicembre", 4100 ]
  ];
}

ZTObjects.WORDCLOUDData = function () {
  return [
    [ "come", 644 ],
    [ "quando", 277 ],
    [ "tanto", 249 ],
    [ "altro", 225 ],
    [ "qual", 213 ],
    [ "occhi", 212 ],
    [ "disse", 208 ],
    [ "questo", 188 ],
    [ "tutto", 175 ],
    [ "vidi", 166 ],
    [ "elli", 165 ],
    [ "dove", 129 ],
    [ "avea", 127 ],
    [ "gente", 125 ],
    [ "parte", 117 ],
    [ "altri", 117 ],
    [ "dentro", 116 ],
    [ "tutti", 114 ],
    [ "maestro", 111 ],
    [ "colui", 108 ],
    [ "sotto", 107 ],
    [ "ciel", 106 ],
    [ "veder", 105 ],
    [ "contrario", 99  ],
    [ "nascose", 89 ],
    [ "costoro", 79 ],
    [ "bolle", 60 ],
    [ "crede", 100 ],
    [ "offerse", 150 ],
    [ "tratti", 100 ],
    [ "crudele", 60 ],
    [ "omero", 40 ],
    [ "trovar", 96 ],
    [ "grato", 152 ],
    [ "dallato", 30 ],
    [ "devota", 300 ],
    [ "sorde", 250 ],
    [ "somigliante", 155 ],
    [ "diavol", 133 ]
  ];
}

ZTObjects.RINGData = function () {
  return [
    [ "Diplomati", 1275 ],
    [ "Laureati", 345 ]
  ];
}

ZTObjects.RINGPERCData = function () {
  return [
    [ "Diplomati", 78.70 ],
    [ "Laureati", 21.30 ]
  ];
}

ZTObjects.PARETOData = function () {
  return [
    [ "Applicazione bloccata", 8500 ],
    [ "Non funziona come dovuto", 2500 ],
    [ "Lento a caricare", 10000 ],
    [ "Non compatibile", 700 ],
    [ "Non disponibile", 1000 ],
    [ "Difficile da visualizzare", 6000 ]
  ];
}

ZTObjects.BUBBLEData = function () {
  return  [
    [ "Valle dAosta", 39, 29.7, 3261 ],
    [ "Piemonte", 173, 28.9, 25387 ],
    [ "Lombardia", 419, 29.6, 23865 ],
    [ "Veneto", 267, 33, 18407 ],
    [ "Trentino Alto-Adige", 157, 24.6, 13606 ],
    [ "Friuli Venezia-Giulia", 155, 32.8, 7862 ],
    [ "Liguria", 290, 34.7, 5416 ],
    [ "Emilia-Romagna", 198, 31.9, 22453 ],
    [ "Toscana", 163, 29.9, 22987 ],
    [ "Marche", 164, 36.3, 9401 ],
    [ "Lazio", 342, 36.1, 17232 ],
    [ "Umbria", 105, 32, 8464 ],
    [ "Campania", 428, 30.1, 13671 ],
    [ "Abruzzo", 123, 35.8, 10832 ],
    [ "Molise", 70, 39.4, 4461 ],
    [ "Basilicata", 57, 34.8, 10073 ],
    [ "Puglia", 209, 30.4, 19541 ],
    [ "Calabria", 130, 31.4, 15222 ],
    [ "Sicilia", 196, 29, 25832 ],
    [ "Sardegna", 69, 32, 24100 ]
  ];
}

ZTObjects.RADARData = function () {
  return [
    [ "Commerciale", 50, 42 ],
    [ "Marketing", 42, 20 ],
    [ "Produzione", 20, 60 ],
    [ "Servizio clienti", 20, 27 ],
    [ "IT", 25, 33 ],
    [ "Amministrazione", 23, 18 ]
  ];
}

ZTObjects.ARCDIALData = function () {
  return [
    [ "Rendita", 62 ],
    [ "Rendita per dipendente", 94 ]
  ];
}

ZTObjects.LIGHTSData = function () {
  return [
    [ "Sede di Milano", 40, 0, 10 ],
    [ "Sede di Padova", 0, 0, 50 ],
    [ "Sede di Roma", 2, 5, 10 ]
  ];
}

// gerarchico geografico
ZTObjects.GEOMAPData = function () {
  return [
    [ "US", "Northeast", "New England", "CT", 741.2 ],
    [ "US", "Northeast", "New England", "ME", 43.1 ],
    [ "US", "Northeast", "New England", "MA", 866.6 ],
    [ "US", "Northeast", "New England", "NH", 148.4 ],
    [ "US", "Northeast", "New England", "RI", 1010.8],
    [ "US", "Northeast", "New England", "VT", 67.7 ],
    [ "US", "Northeast", "Mid-Atlantic", "NJ", 1207.8 ],
    [ "US", "Northeast", "Mid-Atlantic", "NY", 419.3 ],
    [ "US", "Northeast", "Mid-Atlantic", "PA", 285.7 ],
    [ "US", "Midwest", "East North Central"/*, "", 980.6],/*/, "IL", 231.4 ],
    [ "US", "Midwest", "East North Central", "IN", 184.6 ],
    [ "US", "Midwest", "East North Central", "MI", 174.7 ],
    [ "US", "Midwest", "East North Central", "OH", 283.6 ],
    [ "US", "Midwest", "East North Central", "WI", 106.3 ],
    [ "US", "Midwest", "West North Central", "IA", 55.9 ],
    [ "US", "Midwest", "West North Central", "KS", 35.6 ],
    [ "US", "Midwest", "West North Central", "MN", 69 ],
    [ "US", "Midwest", "West North Central", "MO", 88.3 ],
    [ "US", "Midwest", "West North Central", "NE", 24.7 ],
    [ "US", "Midwest", "West North Central", "ND", 11 ],
    [ "US", "Midwest", "West North Central"/*, "", 295.8],/*/, "SD", 11.3 ],
    [ "US", "South", "South Atlantic", "DE", 484.1 ],
    [ "US", "South", "South Atlantic", "VA", 211.7 ],
    [ "US", "South", "South Atlantic", "FL", 375.9 ],
    [ "US", "South", "South Atlantic", "GA", 176.4 ],
    [ "US", "South", "South Atlantic", "MD", 614.5 ],
    [ "US", "South", "South Atlantic", "WV", 76.6 ],
    [ "US", "South", "South Atlantic", "NC", 206.2 ],
    [ "US", "South", "South Atlantic", "SC", 162.6 ],
    [ "US", "South", "East South Central", "AL", 95.8 ],
    [ "US", "South", "East South Central", "KY", 111.4 ],
    [ "US", "South", "East South Central", "MS", 63.8 ],
    [ "US", "South", "East South Central", "TN", 160.1 ],
    [ "US", "South", "West South Central", "AR", 57.2 ],
    [ "US", "South", "West South Central", "LA", 107.2 ],
    [ "US", "South", "West South Central", "OK", 57 ],
    [ "US", "South", "West South Central", "TX", 104.9 ],
 /*   [ "US", "West", "Mountain", "AZ", 60.1 ],
    [ "US", "West", "Mountain", "CO", 52.6 ],
    [ "US", "West", "Mountain", "ID", 20 ],
    [ "US", "West", "Mountain", "MT", 7.1 ],
    [ "US", "West", "Mountain", "NV", 26.3 ],
    [ "US", "West", "Mountain", "NM", 17.2 ],
    [ "US", "West", "Mountain", "UT", 36.5 ],*/
    [ "US", "West", "Mountain", "", 225.8],//, "WY", 6 ],
    [ "US", "West", "Pacific", "", 625]/*, "AK", 1.3 ],
    [ "US", "West", "Pacific", "CA", 251 ],
    [ "US", "West", "Pacific", "HI", 222.9 ],
    [ "US", "West", "Pacific", "OR", 42 ],
    [ "US", "West", "Pacific", "WA", 107.8 ]*/
  ];
}

ZTObjects.GEOMAPITData = function () {
  return [
    [ "IT", "55", "", "", 741.2 ],
    [ "IT", "65", "", "", 43.1 ],
    [ "IT", "88", "", "", 866.6 ],
    [ "IT", "34", "", "", 148.4 ],
    [ "IT", "25", "", "", 1010.8],
    [ "IT", "67", "", "", 67.7 ],
    [ "IT", "57", "", "", 1207.8 ],
    [ "IT", "62", "", "", 419.3 ],
    [ "IT", "42", "", "", 285.7 ]
  ];
}

ZTObjects.TREEMAPData = function () {
  return [
    ["Asia","Cina",1393336748],
    ["Asia","India",1333250000],
    ["America","Stati Uniti d'America ",324119805],
    ["Asia","Indonesia",249865631],
    ["America","Brasile",200361925],
    ["Asia","Pakistan",182142594],
    ["Africa","Nigeria",173615345],
    ["Asia","Bangladesh",156594962],
    ["Europa","Russia",142833689],
    ["Asia","Giappone",127143577],
    ["America","Messico",122332399],
    ["Asia","Filippine",98393574],
    ["Asia","Vietnam",91679733],
    ["Africa","Etiopia",94100756],
    ["Europa","Germania",82726626],
    ["Africa","Egitto",82056378],
    ["Asia","Iran",77447168],
    ["Asia","Turchia",74932641],
    ["Africa","RD del Congo",67513677],
    ["Europa","Francia",67060158],
    ["Asia","Thailandia",67010502],
    ["Europa","Regno Unito",63625260],
    ["Europa","Italia",60497174],
    ["Asia","Birmania",53259018],
    ["Africa","Sudafrica",52776130],
    ["Asia","Corea del Sud",49262698],
    ["Africa","Tanzania",49253126],
    ["America","Colombia",48321405],
    ["Europa","Spagna",46926963],
    ["Europa","Ucraina",45238805]
  ];
}

ZTObjects.PYRAMIDDISTRData = function () {
  return [
    [ "0-4", 1500, 1500 ],
    [ "5-9", 1600, 1600 ],
    [ "10-14", 1550, 1550 ],
    [ "15-19", 1550, 1500 ],
    [ "20-24", 1700, 1650 ],
    [ "25-29", 1800, 1800 ],
    [ "30-34", 2100, 2100 ],
    [ "35-39", 2500, 2450 ],
    [ "40-44", 3090, 2700 ],
    [ "45-49", 3000, 2750 ],
    [ "50-54", 2500, 2600 ],
    [ "55-59", 2000, 2300 ],
    [ "60-64", 1700, 1950 ],
    [ "65-69", 1600, 1900 ],
    [ "70-74", 1300, 1600 ],
    [ "75-79", 1200, 1500 ],
    [ "80-84", 950, 1250 ],
    [ "85-89", 450, 850 ],
    [ "90-94", 100, 400 ],
    [ "95-99", 50, 80 ],
    [ "100+", 0, 20 ]
  ].reverse();
}

ZTObjects.FORCEData = function () {
  return [
    ["CALIBRAZIONE","","","",4],
    ["CALIBRAZIONE2","","","",5],
    ["ERP_ZUCCHETTI","1_CONTABILITA","1_1_CONTGEN","",8],
    ["ERP_ZUCCHETTI","1_CONTABILITA","1_2_CONTANALITICA","",7],
    ["ERP_ZUCCHETTI","2_LOGISTICA","2_1_GLAMOUR","",8],
    ["ERP_ZUCCHETTI","2_LOGISTICA","2_2_ATTIVITASERVIZI","",6],
    ["ERP_ZUCCHETTI","2_LOGISTICA","2_3_GESTIONEPROGETTI","",5],
    ["ERP_ZUCCHETTI","3_PRODUZIONE","3_1_GLAMOUR","",3],
    ["ERP_ZUCCHETTI","3_PRODUZIONE","3_2_GESTIONEPROGETTI","",3],
    ["ERP_ZUCCHETTI","3_PRODUZIONE","3_3_BASE","",4],
    ["ERP_ZUCCHETTI","3_PRODUZIONE","3_4_AVANZATA","",4],
    ["ERP_ZUCCHETTI","4_ADDONINTEGRAZIONI","","",3],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_1_IAF","",2],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_2_CRM","5_2_1_CRMMARKETING", 10],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_2_CRM","5_2_2_CRMSALES", 9],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_2_CRM","5_2_3_CRMPOSTVENDITA", 8],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_3_DMS","5_3_1_DMSCS", 4],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_3_DMS","5_3_2_DMSI", 10],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_4_BPM","",1],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_5_ECOMMERCE","",1],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_6_CMS","",1],
    ["ERP_ZUCCHETTI","5_CROSSAPP","5_7_APP","",1],
    ["ERP_ZUCCHETTI","6_MODULISISTEMA","","",1],
    ["GENERALEINFORMATICA","","","",10],
    ["INTELLIGENZAEMOTIVA","","","",8],
    ["INVALSI","","","",8],
    ["LOGICA","","","",9],
    ["MATEMATICA","","","",9],
    ["PAINTER","","","",9],
    ["PROGRAMMAZIONE","JAVA","","",10],
    ["PROGRAMMAZIONE","JS","JSP","",10],
    ["RAGIONERIA","CONTABGENERALE","","",1],
    ["RAGIONERIA","LOGISTICA","","",10],
    ["SICUREZZA","ATTACCHIINFO","","",5],
    ["SICUREZZA","CRITTOGRAFIA","","",5],
    ["SICUREZZA","PRIVACY","PRIVACYINASSISTENZA","",5],
    ["SISTEMISTICA","DBA002","","",5],
    ["SISTEMISTICA","DTMGT001","","",5],
    ["SISTEMISTICA","RT002","","",4],
    ["SISTEMISTICA","SCRZ001","","",4],
    ["SISTEMISTICA","SO_LINUX","","",10],
    ["SISTEMISTICA","SO_WINDOWS","","",10],
    ["SQL","ESEMPISQL","","",10],
    ["SQL","TRANSAZIONI","","",9],
    ["TESTEMPTY","","","",8],
    ["USABILITY","PRINCIPI","","",4]
  ];
}

ZTObjects.MATRIXData = function () {
  return [
    ["ptwccskjcf", "osvluiqhbp", 0.575], 
    ["ptwccskjcf", "dpzaqasqro", 0.537], 
    ["zcflqcwpgh", "lqyvhqfmqd", 0.634], 
    ["zqrfurehmz", "xmqopkamew", 0.664], 
    ["heusbnnnto", "bkfstjjeaw", 0.549],
    ["xmqopkamew", "fbekkymdja", 1.000], 
    ["xvbullwvol", "nrawevuhkv", 0.607], 
    ["oaszeadbqh", "mnrnuysydx", 0.679], 
    ["pfsvqgsfen", "kprsxjkubz", 0.565], 
    ["lqyvhqfmqd", "fupxesqveq", 0.682], 
    ["zcflqcwpgh", "jnxymdjdxl", 1.086],
    ["voqwkjnxuv", "pfctjunpxs", 1.194], 
    ["ptwccskjcf", "oaszeadbqh", 0.614], 
    ["oaszeadbqh", "lqyvhqfmqd", 1.024], 
    ["ptwccskjcf", "pfctjunpxs", 1.619], 
    ["xvbullwvol", "dpzaqasqro", 1.008], 
    ["ungslccrdw", "lqyvhqfmqd", 0.682], 
    ["pfctjunpxs", "mhaimflmrt", 0.863], 
    ["fbekkymdja", "cfxigdfgsu", 1.098], 
    ["upmqfdzqqd", "mhaimflmrt", 0.684], 
    ["zqrfurehmz", "fupxesqveq", 1.299],
    ["mnrnuysydx", "jnxymdjdxl", 1.038], 
    ["fbekkymdja", "ectvbesohs", 0.524], 
    ["fupxesqveq", "cfkjhtcjjp", 1.118], 
    ["zcflqcwpgh", "nrawevuhkv", 0.583],
    ["ptwccskjcf", "cfkjhtcjjp", 0.861], 
    ["kprsxjkubz", "fbekkymdja", 0.510], 
    ["gilviisrcb", "cfxigdfgsu", 0.741], 
    ["mnrnuysydx", "bajsownqty", 0.681], 
    ["ptwccskjcf", "cxwrjrltfv", 1.561], 
    ["upmqfdzqqd", "obwqtgpxek", 0.635], 
    ["uoohruqjig", "mnrnuysydx", 1.932],
    ["uoohruqjig", "nrawevuhkv", 0.762],
    ["hacwlyvymr", "cfxigdfgsu", 1.566], 
    ["mnrnuysydx", "cfxigdfgsu", 1.634],
    ["xmqopkamew", "ptwccskjcf", 0.553], 
    ["voqwkjnxuv", "mhaimflmrt", 0.905], 
    ["xvbullwvol", "ptwccskjcf", 0.704], 
    ["zqrfurehmz", "mnrnuysydx", 0.647], 
    ["xvbullwvol", "mnrnuysydx", 1.090], 
    ["mnrnuysydx", "jwvreihjvv", 1.550], 
    ["xmqopkamew", "jwvreihjvv", 0.807], 
    ["nrawevuhkv", "kprsxjkubz", 0.702], 
    ["lqyvhqfmqd", "bajsownqty", 1.140], 
    ["xvbullwvol", "xmqopkamew", 0.533], 
    ["zqrfurehmz", "nrawevuhkv", 1.272], 
    ["xmqopkamew", "mnrnuysydx", 2.006],
    ["pfctjunpxs", "heusbnnnto", 1.293], 
    ["pfsvqgsfen", "fbekkymdja", 1.367], 
    ["upmqfdzqqd", "ptwccskjcf", 0.960], 
    ["mhaimflmrt", "cfxigdfgsu", 1.868], 
    ["xmqopkamew", "uoohruqjig", 1.609], 
    ["upmqfdzqqd", "mnrnuysydx", 0.764],
    ["pfctjunpxs", "kprsxjkubz", 1.066]
  ];
}

ZTObjects.TIMEData = function () {
  return [
    [ "2018-01-08", 8],
    [ "2018-01-09", 8.5],
    [ "2018-01-10", 8.5],
    [ "2018-01-11", 9],
    [ "2018-01-12", 9],
    [ "2018-01-15", 8.5],
    [ "2018-01-16", 8],
    [ "2018-01-17", 8.5],
    [ "2018-01-18", 8.5],
    [ "2018-01-19", 9],
    [ "2018-01-22", 9],
    [ "2018-02-05", 8],
    [ "2018-02-06", 8.5],
    [ "2018-02-07", 8],
    [ "2018-02-08", 8.5],
    [ "2018-02-09", 8],
    [ "2018-02-12", 10],
    [ "2018-02-13", 8.5],
    [ "2018-02-14", 8],
    [ "2018-02-15", 8],
    [ "2018-02-16", 8],
    [ "2018-02-19", 8],
    [ "2018-02-20", 8.5],
    [ "2018-02-21", 8.5],
    [ "2018-02-22", 8.5],
    [ "2018-02-23", 8.5],
    [ "2018-03-12", 8],
    [ "2018-03-13", 9],
    [ "2018-03-14", 8],
    [ "2018-03-15", 9],
    [ "2018-03-16", 10],
    [ "2018-05-19", 8],
    [ "2018-05-20", 8.5],
    [ "2018-07-21", 8.5],
    [ "2018-07-22", 8.5],
    [ "2018-07-23", 8.5],
    [ "2018-09-12", 8],
    [ "2018-09-13", 9],
    [ "2018-09-14", 8],
  ];
}

ZTObjects.FUNNELData = function () {
  return [
    ["step1", 50],
    ["step2", 47],
    ["step3", 44],
    ["step4", 42],
    ["step5", 39],
    ["step6", 38],
    ["step7", 35],
    ["step8", 34],
    /*["step9", 36],
    ["step10", 31],
    ["step11", 28],
    ["step12", 25],
    ["step13", 21],
    ["step14", 19],
    ["step15", 15],
    ["step16", 14],
    ["step17", 8],
    ["step18", 5],
    ["step19", -2],
    ["step20", 0]*/
  ];
}

ZTObjects.DEPData = function () {
  return [
    ["XYZ", "Lines", 10],
    ["XYZ", "Std", 5],
    ["Lines", "Std", 4],
    ["Lines", "Bar", 3],
    ["Bar", "Lines", 1],
    ["Bar", "Std", 8],
    ["Area", "Lines", 6],
    ["Area", "Std", 4],
    ["Area", "Bar", 1],
    ["StackArea", "Area", 2],
    ["StackArea", "StackBar", 1],
    ["StackBar", "Bar", 2],
    ["StackBar", "Std", 1],
    ["Container", "Std", 4],
    ["Container", "Bar", 2],
    ["Container", "Lines", 10],
    ["Geographic", "Std", 6],
    ["Geographic", "Pie", 9],
    ["Dial", "Std", 4],
    ["Dial", "Bar", 1],
    ["Dial", "Pie", 11],
    ["Pie", "Std", 4],
    ["Pie", "Bars", 1],
    ["Pareto", "Std", 7],
    ["Pareto", "Bar", 3],
    ["Pareto", "Pie", 3],
    ["Pareto", "Lines", 2],
    ["Pareto", "Waterfall", 2],
    ["Pareto", "TreeMapBar", 2],
    ["Image", "Bars", 1],
    ["Image", "Radar", 1],
    ["Image", "Lights", 2],
    ["Waterfall", "Std", 5],
    ["Waterfall", "Bar", 5],
    ["Waterfall", "Pie", 3],
    ["Waterfall", "TreeMapBar", 2],
    ["Pyramid", "Std", 1],
    ["Pyramid", "Bar", 2],
    ["Pyramid", "Pie", 1],
    ["Pyramid", "Waterfall", 3],
    ["Pyramid", "TreeMapBar", 22],
    ["TreeMap", "Std", 6],
    ["TreeMap", "Pie", 1],
    ["LayeredBar", "Bar", 1],
    ["TreeMapBar", "Std", 3],
    ["TreeMapBar", "Bar", 3],
    ["TreeMapBar", "TreeMap", 6],
    ["Lights", "Std", 3],
    ["Lights", "Dial", 5],
    ["Lights", "Bar", 1],
    ["Lights", "Pie", 13],
    ["Lights", "Radar", 1],
    ["MultiDimCursor", "Std", 3],
    ["MultiDimCursor", "Pie", 1],
    ["Display", "Dial", 1],
    ["Display", "Lights", 2],
    ["Display", "Radar", 1],
    ["Radar", "Std", 2],
    ["Radar", "Lines", 10],
    ["Radar", "Pie", 5],
    ["Thermo", "Dial", 2],
    ["Thermo", "Std", 1],
    ["Thermo", "Radar", 1],
    ["Thermo", "LayeredBar", 2],
    ["Word", "Std", 2],
    ["Word", "Pie", 1],
    ["Sunburst", "Pie", 2],
    ["Tree", "Sunburst", 3],
    ["Tree", "Std", 1],
    ["Aster", "Pie", 1],
    ["Aster", "XYZ", 11],
    ["CirclePack", "Sunburst", 2],
    ["CirclePack", "StackBar", 1],
    ["Matrix", "Bar", 1],
    ["Matrix", "Sunburst", 2],
    ["Force", "Tree", 1],
    ["AreaBar", "StackBar", 2],
    ["AreaBar", "XYZ", 10],
    ["AreaBar", "Bar", 2],
    ["AreaBar", "Std", 1]
  ];
}

ZTObjects.MARIMEKKOData = function () {
  return [
   /* ["FOSSIL FUEL", "Oil-Petroleum", 515],
    ["FOSSIL FUEL", "Natural gas", 362],
    ["FOSSIL FUEL", "Coal", 160],
    ["FOSSIL FUEL", "Other", 36],
    ["RENEWABLES", "Solar", 373], 
    ["RENEWABLES", "Bioenergy-CHP", 130],
    ["RENEWABLES", "Wind", 101],
    ["RENEWABLES", "Traditional hydropower", 56],
    ["RENEWABLES", "Other", 15],
    ["OTHER", "Nuclear", 76], 
    ["OTHER", "Other", 115]/*/
    ["Europa", "Petrolio", 723.35],
    ["Europa", "Gas naturale", 449.65],
    ["Europa", "Carbone", 293.25],
    ["Europa", "Idrica", 136.85],
    ["Europa", "Altro", 332.35],
    ["Com. Stati Indipendenti", "Petrolio", 204.75],
    ["Com. Stati Indipendenti", "Gas naturale", 497.25],
    ["Com. Stati Indipendenti", "Carbone", 156],
    ["Com. Stati Indipendenti", "Idrica", 58.50],
    ["Com. Stati Indipendenti", "Altro", 68.25],
    ["Medio-Oriente", "Petrolio", 421.59],
    ["Medio-Oriente", "Gas naturale", 457.47],
    ["Medio-Oriente", "Carbone", 8.97],
    ["Medio-Oriente", "Idrica", 8.97],
    ["Medio-Oriente", "Altro", 0],
    ["Asia e Pacifico", "Petrolio", 1654.16],
    ["Asia e Pacifico", "Gas naturale", 684.48],
    ["Asia e Pacifico", "Carbone", 2794.96],
    ["Asia e Pacifico", "Idrica", 399.28],
    ["Asia e Pacifico", "Altro", 288.16],
    ["Nord America", "Petrolio", 1104],
    ["Nord America", "Gas naturale", 800.40],
    ["Nord America", "Carbone", 358.80],
    ["Nord America", "Idrica", 165.60],
    ["Nord America", "Altro", 303.60],
    ["Centro e Sud America", "Petrolio", 320.62],
    ["Centro e Sud America", "Gas naturale", 146.37],
    ["Centro e Sud America", "Carbone", 34.85],
    ["Centro e Sud America", "Idrica", 160.31],
    ["Centro e Sud America", "Altro", 34.85],
    ["Africa", "Petrolio", 197.56],
    ["Africa", "Gas naturale", 121.23],
    ["Africa", "Carbone", 94.29],
    ["Africa", "Idrica", 26.94],
    ["Africa", "Altro", 8.98]
  ];
}

ZTObjects.SANKEYData = function () {
  return [
    ["L1.1", "L2.1", 50],
    ["L1.2", "L2.1", 10],
    ["L1.3", "L2.1", 40],
    ["L1.4", "L2.2", 20],
    ["L1.5", "L2.2", 5],
    ["L1.6", "L2.3", 15],
    ["L1.7", "L2.4", 45],
    ["L1.8", "L2.5", 100],
    ["L1.9", "L2.5", 80],
    ["L1.10", "L2.6", 55],
    ["L2.6", "L3.1", 50],
    ["L2.6", "L3.2", 5]
  ]
}

ZTObjects.BCMATRIXAddData = function () {
  return [
    ["SCARSO",0,2,"L","L_02"],
    ["SCARSO",0,2,"M","M_02"],
    ["RISCHIO",0,2,"H","H_02"],
    ["MIGLIORABILE",2,2.80,"L","L_228"],
    ["MIGLIORABILE",2,2.80,"M","M_228"],
    ["RISCHIO",2,2.80,"H","H_228"],
    ["ADEGUATO",2.80,3.40,"L","L_2834"],
    ["ADEGUATO",2.80,3.40,"M","M_2834"],
    ["RISCHIO",2.80,3.40,"H","H_2834"],
    ["ADEGUATO",3.40,4,"L","L_344"],
    ["ADEGUATO",3.40,4,"M","M_344"],
    ["ECCELLENTE",3.40,4,"H","H_344"]
  ].reverse();
}

ZTObjects.BCMATRIXData = function () {
  return [
    ["MKT102","ART029",3.3,"H","RISCHIO"],
    ["MKT101","ART007",2.6,"M","MIGLIORABILE"],
    ["MKT101","ART008",2.9,"M","ADEGUATO"],
    ["MKT101","ART009",3.3,"M","ADEGUATO"],
    ["MKT102","ART030",2.0,"L","SCARSO"],
    ["MKT102","ART031",2.6,"L","MIGLIORABILE"],
    ["MKT102","ART032",1.3,"L","SCARSO"],
    ["MKT102","ART033",2.6,"M","MIGLIORABILE"],
    ["MKT102","ART034",2.3,"L","MIGLIORABILE"],
    ["MKT102","ART035",2.0,"L","SCARSO"],
    ["MKT103","ART001",1.0,"L","SCARSO"],
    ["MKT103","ART001",3.7,"H","ECCELLENTE"],
    ["MKT103","ART002",2.4,"M","MIGLIORABILE"],
    ["MKT103","ART003",3.0,"M","ADEGUATO"],
    ["MKT104","ART014",3.3,"H","RISCHIO"],
    ["MKT104","ART015",3.0,"M","ADEGUATO"],
    ["MKT104","ART016",2.9,"M","ADEGUATO"],
    ["MKT104","ART017",2.7,"M","MIGLIORABILE"],
    ["MKT104","ART018",3.0,"M","ADEGUATO"],
    ["MKT105","ART023",2.6,"M","MIGLIORABILE"],
    ["MKT105","ART024",3.7,"H","ECCELLENTE"],
    ["MKT105","ART025",1.6,"L","SCARSO"],
    ["MKT105","ART026",3.0,"M","ADEGUATO"],
    ["MKT105","ART027",3.0,"M","ADEGUATO"],
    ["MKT105","ART028",3.3,"H","RISCHIO"],
    ["MKT106","ART019",2.6,"M","MIGLIORABILE"],
    ["MKT106","ART020",2.1,"L","MIGLIORABILE"],
    ["MKT106","ART021",2.7,"M","MIGLIORABILE"],
    ["MKT106","ART022",2.3,"M","MIGLIORABILE"],
    ["MKT107","ART004",2.9,"M","ADEGUATO"],
    ["MKT107","ART005",3.1,"H","RISCHIO"],
    ["MKT107","ART006",3.3,"H","RISCHIO"],
    ["MKT108","ART010",2.4,"M","MIGLIORABILE"],
    ["MKT108","ART011",2.9,"M","ADEGUATO"],
    ["MKT108","ART012",3.0,"M","ADEGUATO"],
    ["MKT108","ART013",2.7,"M","MIGLIORABILE"]
  ];
}

ZTObjects.PCOORDSData = function () {
  return [
      ['America','usa',17,59,24,9.8],
      ['America','can',16,53,31,9.9],
      ['America','mex',34,84,8,1.9],
   //   ['America','arg',6,23,5,2.8],
      ['America','col',12,33,4,1.1],
      ['America','bra',44,138,15,8.5],
   //   ['America','chi',3,14,1.5,0.7],
   //   ['America','ven',9,19,2,0.9],
   /*   ['Africa','egi',30,54,5,1],
      ['Africa','alg',10,27,2,2.3],
      ['Africa','ken',18,28,0.5,0.5],
      ['Africa','sud',15,36,2.5,1.2],
  //    ['Africa','tun',3,6.5,0.5,0.1],*/
      ['Asia','rus',23,94,16,17],
    //  ['Asia','cin',237,991,138,9.5],
    //  ['Asia','ind',374,876,76,3.2],
      ['Asia','tur',18,50,7,0.7],
      ['Asia','jap',15,68,33,0.3],
      ['Europa','ita',13,68,19,0.3],
      ['Europa','ger',11,51,16,0.3],
      ['Europa','fra',12,40,14,0.6],
      ['Europa','gbr',12,53,13,0.2],
      ['Europa','spa',6,29,10,0.5],
      ['Europa','ucr',9,27,9,0.6],
      ['Oceania','aus',5,17,6,7.6]
    ];
}

ZTObjects.VORONOIData = function () {
  return [
    ["punto_0","tipo A",294,89],
    ["punto_1","tipo B",256,206],
    ["punto_2","tipo C",30,45],
    ["punto_3","tipo D",541,215],
    ["punto_4","tipo A",117,108],
    ["punto_5","tipo B",60,33],
    ["punto_6","tipo C",100,82],
    ["punto_7","tipo D",578,90],
    ["punto_8","tipo A",387,200],
    ["punto_9","tipo B",41,189],
    ["punto_10","tipo C",364,143],
    ["punto_11","tipo D",152,26],
    ["punto_12","tipo A",269,73],
    ["punto_13","tipo B",115,22],
    ["punto_14","tipo C",502,49],
    ["punto_15","tipo D",123,202],
    ["punto_16","tipo A",354,83],
    ["punto_17","tipo B",54,104],
    ["punto_18","tipo C",409,103],
    ["punto_19","tipo D",320,109],
    ["punto_20","tipo A",253,178],
    ["punto_21","tipo B",144,60],
    ["punto_22","tipo C",257,68],
    ["punto_23","tipo D",479,60],
    ["punto_24","tipo A",106,89],
    ["punto_25","tipo B",336,105],
    ["punto_26","tipo C",49,181],
    ["punto_27","tipo D",250,111],
    ["punto_28","tipo A",462,71],
    ["punto_29","tipo B",264,26],
    ["punto_30","tipo C",379,216],
    ["punto_31","tipo D",262,64],
    ["punto_32","tipo A",123,69],
    ["punto_33","tipo B",139,66],
    ["punto_34","tipo C",345,64],
    ["punto_35","tipo D",461,191],
    ["punto_36","tipo A",249,143],
    ["punto_37","tipo B",494,125],
    ["punto_38","tipo C",531,127],
    ["punto_39","tipo D",103,146],
    ["punto_40","tipo A",559,175],
    ["punto_41","tipo B",323,151],
    ["punto_42","tipo C",314,213],
    ["punto_43","tipo D",186,110],
    ["punto_44","tipo A",352,207],
    ["punto_45","tipo B",482,22],
    ["punto_46","tipo C",248,93],
    ["punto_47","tipo D",592,50],
    ["punto_48","tipo A",444,30],
    ["punto_49","tipo B",505,86],
    ["punto_50","tipo C",67,50],
    ["punto_51","tipo D",474,141],
    ["punto_52","tipo A",453,140],
    ["punto_53","tipo B",161,205],
    ["punto_54","tipo C",87,156],
    ["punto_55","tipo D",372,63],
    ["punto_56","tipo A",408,36],
    ["punto_57","tipo B",579,77],
    ["punto_58","tipo C",516,135],
    ["punto_59","tipo D",484,26],
    ["punto_60","tipo A",443,167],
    ["punto_61","tipo B",422,161],
    ["punto_62","tipo C",367,154],
    ["punto_63","tipo D",164,79],
    ["punto_64","tipo A",565,152],
    ["punto_65","tipo B",524,106],
    ["punto_66","tipo C",274,141],
    ["punto_67","tipo D",189,114],
    ["punto_68","tipo A",312,137],
    ["punto_69","tipo B",531,126],
    ["punto_70","tipo C",267,197]
  ]
}

function getDatasetDemo(type) { //chiamato da fuori
  return getChartDataset(type);
}

function getChartDataset(type) {
	switch (type) {
    case "SCATTER":
		case "ASTER":
		case "AREABAR":
			return ZTObjects.BUBBLEData();
		case "VBAR":
		case "VBAR3D":
		case "HBAR":
		case "HBAR3D":
		case "LAYEREDBARH":
		case "LAYEREDBAR":
      return ZTObjects.BARSData();
		case "PYRAMID":
			return ZTObjects.PYRAMIDDISTRData();		
    case "AREA":
    case "STACKEDAREA":
    case "HSTACKBAR":
    case "HSTACKBAR3D":
    case "VSTACKBAR":
    case "VSTACKBAR3D":
			if (isTimeDemo && type == "AREA")
				return ZTObjects.TIMEData();
      return ZTObjects.LINESData();
    case "TREEMAPBAR":
    case "TREEMAPBARH":
    case "SUNB":
    case "SUNBSTR":
      return ZTObjects.TREEMAPData();
      //return ZTObjects.TREEMAPBARData();
		case "RADARLINE" :
		case "RADARAREA":
		case "PIE":
		case "PIE3D":
		case "PYR":
		case "NECKEDPYR":
		case "PYRSTR":
		case "NECKEDPYRSTR":
			return ZTObjects.RADARData();
    case "ARCDIAL":
		case "THERMO":
		case "LIGHTS":
		case "IMAGES":
    case "DISPLAY":
    case "COUNTER":
		case "PADDLE":
			return ZTObjects.ARCDIALData();
    /*case "LIGHTS":
    case "IMAGES":
    case "DISPLAY":
    case "COUNTER":
		case "PADDLE":
			return ZTObjects.LIGHTSData();*/
		case "GEOMAP":
			return ZTObjects.GEOMAPITData();
    /*case "SUNB":
    case "SUNBSTR":*/
		case "TREE":
		case "TREESTR":
		case "CPACK":
    case "CPACKSTR":
//case "TREEMAP":
			return ZTObjects.GEOMAPData();
		case "MATRIX":
		case "CHORD":
		case "FORCESTR":
			return ZTObjects.DEPData();
		case "CAL":
			return ZTObjects.TIMEData();
		default:
			return ZTObjects[type + "Data"]() || [];
	}
}

function getChartPropertyName(type) {
	switch (type) {
		case "WORDCLOUD":
		case "WATERF":
		case "PARETO":
		case "ARCDIAL":
		case "THERMO":
		case "LIGHTS":
		case "IMAGES":
    case "DISPLAY":
    case "COUNTER":
		case "PADDLE":
		case "TIME":
		case "CAL":
		case "FUNNEL":
			return ZTObjects.FieldList1V();
		case "VBAR":
		case "VBAR3D":
		case "HBAR":
		case "HBAR3D":
    case "PYRAMID":
		case "LAYEREDBARH":
		case "LAYEREDBAR":
		case "PIE":
    case "PIE3D":
		case "RING":
    case "RINGPERC":
		case "RADARLINE" :
		case "RADARAREA":
		case "ASTER":
		case "AREABAR":
		case "MATRIX":
		case "FORCESTR":
		case "CHORD":
		case "PYR":
		case "NECKEDPYR":
		case "PYRSTR":
    case "NECKEDPYRSTR":
    case "TREEMAP":
    case "MARIMEKKO":	
    case "SANKEY":
    case "SUNB":
    case "SUNBSTR":
			return ZTObjects.FieldList2V();
		case "SCATTER":
    case "BUBBLE":
		case "LINES":
		case "AREA":
    case "STACKEDAREA":
    case "HSTACKBAR":
    case "HSTACKBAR3D":
    case "VSTACKBAR":
    case "VSTACKBAR3D":
    case "VORONOI":
			if (type == "AREA") {
        if (isTimeDemo)
          return ZTObjects.FieldList1V();
      }
			return ZTObjects.FieldList3V();
		case "FORCE":
    case "BCMATRIX":
    //case "LINES":
      return ZTObjects.FieldList4V();
    case "TREEMAPBAR":
    case "TREEMAPBARH":
      //return ZTObjects.FieldList8V();
      return ZTObjects.FieldList2V();
		case "GEOMAP":
    /*case "SUNB":
    case "SUNBSTR":*/
		case "TREE":
		case "TREESTR":
		case "CPACK":
    case "CPACKSTR":
//case "TREEMAP":    
      return ZTObjects.GeoFieldList();
    case "PCOORDS":
      return ZTObjects.FieldList5V();
		default:
			return [];
	}
}

function getChartObjconfig(type) {
	switch (type) {
		case "WORDCLOUD":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.WORDCLOUDcobj );
		case "WATERF":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.WATERFcobj );
		case "SCATTER":
		case "ASTER":
		case "AREABAR":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.SCATTERcobj );
		case "BUBBLE":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.BUBBLEcobj );
		case "PARETO":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.PARETOcobj );
		case "VBAR":
		case "VBAR3D":
		case "HBAR":
		case "HBAR3D":
		case "LAYEREDBARH":
		case "LAYEREDBAR":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.BARScobj );
		case "PYRAMID":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.PYRAMIDDISTRcobj );
		case "PIE":
		case "PIE3D":
	  case "PYR":
		case "NECKEDPYR":
		case "PYRSTR":
		case "NECKEDPYRSTR":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.PIEcobj );
		case "RING":
    case "RINGPERC":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.RINGcobj );
    case "TREEMAP":
    case "SUNB":
    case "SUNBSTR":
      return merge_options( ZTObjects.GENERICcobj, ZTObjects.TREEMAPcobj );
    case "TREEMAPBAR":
    case "TREEMAPBARH":
      //return ZTObjects.TREEMAPBARcobj;
      return merge_options( ZTObjects.GENERICcobj, ZTObjects.TREEMAPcobj );
		case "LINES":
		case "AREA":
    case "STACKEDAREA":
    case "HSTACKBAR":
		case "HSTACKBAR3D":
		case "VSTACKBAR":
    case "VSTACKBAR3D":
      if (isTimeDemo)
				return merge_options( ZTObjects.GENERICcobj, ZTObjects.TIMEcobj );
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.LINEScobj );
		case "RADARLINE" :
		case "RADARAREA":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.RADARcobj );
    case "ARCDIAL":
		case "THERMO":
    case "LIGHTS":
    case "IMAGES":
    case "DISPLAY":
    case "COUNTER":
		case "PADDLE":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.ARCDIALcobj );
			//return ZTObjects.LIGHTScobj;
		case "GEOMAP":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.GEOMAPITcobj );
	//	case "SUNB":
		case "CPACK":
		case "TREE":
    case "CPACKSTR":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.SUNBcobj );
//		case "SUNBSTR":
    case "TREESTR":
// case "TREEMAP":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.SUNBSTRcobj );
		//case "FORCESTR":
		//	return ZTObjects.FORCEcobj;
		case "FORCE":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.FORCESTRcobj );
		case "FORCESTR":
		case "MATRIX":
		case "CHORD":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.MATRIXcobj );
    case "SANKEY":
      return merge_options( ZTObjects.GENERICcobj, ZTObjects.SANKEYcobj );
		case "TIME":
		case "CAL":
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.TIMEcobj );
		case "FUNNEL":	
      return merge_options( ZTObjects.GENERICcobj, ZTObjects.FUNNELcobj );
    case "MARIMEKKO":	
      return merge_options( ZTObjects.GENERICcobj, ZTObjects.MARIMEKKOcobj );
    case "BCMATRIX":	
      return merge_options( ZTObjects.GENERICcobj, ZTObjects.BCMATRIXcobj );
    case "PCOORDS":	
			return merge_options( ZTObjects.GENERICcobj, ZTObjects.PCOORDScobj );
		default:
			return ZTObjects[type + "cobj"] || {};
	}
}

function getChartAddDataset(type) {
  if (type == "BCMATRIX")
    return ZTObjects.BCMATRIXAddData();
  return undefined;
}

function getChartAddPropertyName(type) {
	if (type == "BCMATRIX")
		return ['liv','xda','xa','yda_a','classcode'];
  return undefined;
}

/**
 * Overwrites obj1's values with obj2's and adds obj2's if non existent in obj1
 * @param obj1
 * @param obj2
 * @returns obj3 a new object based on obj1 and obj2
 */
function merge_options(obj1,obj2){
    var obj3 = {},
    attrname;
    for (attrname in obj1) { obj3[attrname] = obj1[attrname]; }
    for (attrname in obj2) { obj3[attrname] = obj2[attrname]; }
    return obj3;
}