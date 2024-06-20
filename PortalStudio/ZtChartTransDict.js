if (typeof ZtChartDict == 'undefined') {
  var ZtChartDict = new function () {
    var lmap = {};
    lmap.ZTC_ERROR = {
      eng: "Chart not available - an error has occurred",
      ita: "Grafico non disponibile - si e' verificato un errore",
      spa: "Grafico no disponible - se ha producido un error",
      deu: "Grafik nicht verfugbar - ein Fehler ist aufgetreten",
      fra: "Graphique non disponible - une erreur s'est produite",
      ron: "Graficul nu este disponibil - a aparut o eroare"
    };
    lmap.ZTC_ERRSIZE = {
      eng: "Chart not available - smallest sizes",
      ita: "Grafico non disponibile - dimensioni troppo ridotte",
      spa: "Grafico no disponible - talla demasiado pequena",
      deu: "Diagramm nicht verfugbar - Abmessungen zu klein",
      fra: "Graphique non disponible - taille trop petite",
      ron: "Graficul nu este disponibil - dimensiunea prea mica"
    };
    lmap.ZTC_NODATA = {
      eng: "Empty dataset",
      ita: "Nessun dato",
      spa: "Sin datos",
      deu: "Keine Daten",
      fra: "Pas de donnees",
      ron: "Nu exista date"
    };
    lmap.ZTC_NOTREPDATA = {
      eng: "Not represented data",
      ita: "Dati non rappresentati",
      spa: "Datos no representados",
      deu: "Daten nicht dargestellt",
      fra: "Donnees non representees",
      ron: "Datele nu sunt reprezentate"
    };
    lmap.ZTC_OTHERDATA = {
      eng: "Others aggregation data",
      ita: "Dati aggregati",
      spa: "Datos agregados",
      deu: "Aggregierte Daten",
      fra: "Donnees agregees",
      ron: "Date agregate"
    };
    lmap.ZTC_EXCTITLE = {
      eng: "Double click to exclude/include",
      ita: "Doppio click per escludere/includere",
      spa: "Doble clic para excluir/incluir",
      deu: "Zum Ausschluss/Einschluss doppelklicken",
      fra: "Double-cliquez pour exclure/inclure",
      ron: "Dublu clic pentru a exclude/include"
    };
    lmap.ZTC_SELTITLE = {
      eng: "Click to select/unselect",
      ita: "Click per selezionare/deselezionare",
      spa: "Clic para seleccionar/deseleccionar",
      deu: "Klicken Sie zum Auswahlen/Abwahlen",
      fra: "Cliquez pour selectionner/deselectionner",
      ron: "Clic pentru a selecta/deselecta"
    };
    lmap.ZTC_ADM0LAB = {
      eng: "Geographic domain",
      ita: "Dominio geografico",
      spa: "Dominio geografico",
      deu: "Geografische Domane",
      fra: "Domaine geographique",
      ron: "Domeniul geografic"
    };
    lmap.ZTC_ADM1LAB = {
      eng: "Subdivision",
      ita: "Suddivisione",
      spa: "Subdivision",
      deu: "Unterteilung",
      fra: "Subdivision",
      ron: "Subdiviziune"
    };
    lmap.ZTC_SERLAB = {
      eng: "Serie",
      ita: "Serie",
      spa: "Serie",
      deu: "Serie",
      fra: "Serie",
      ron: "Serie"
    };
    lmap.ZTC_VALLAB = {
      eng: "Value",
      ita: "Valore",
      spa: "Valor",
      deu: "Wert",
      fra: "Valeur",
      ron: "Valoare"
    };
    lmap.ZTC_CATLAB = {
      eng: "Category",
      ita: "Categoria",
      spa: "Categoria",
      deu: "Kategorie",
      fra: "Categorie",
      ron: "Categorie"
    };
    lmap.ZTC_CKEYLAB = {
      eng: "Category key",
      ita: "Chiave di categoria",
      spa: "Clave de categoria",
      deu: "Kategorieschlussel",
      fra: "Cle de categorie",
      ron: "Cheie de categorie"
    };
    lmap.ZTC_PERCLAB = {
      eng: "Percentage",
      ita: "Percentuale",
      spa: "Porcentaje",
      deu: "Prozentsatz",
      fra: "Pourcentage",
      ron: "Procent"
    };
    lmap.ZTC_VALSLAB = {
      eng: "Values",
      ita: "Valori",
      spa: "Valores",
      deu: "Werte",
      fra: "Valeurs",
      ron: "Valori"
    };
    lmap.ZTC_PLAPAU = {
      eng: "Play/Pause",
      ita: "Avvia/Pausa",
      spa: "Iniciar/Pausa",
      deu: "Anfang/Pause",
      fra: "Demarrer/Pause",
      ron: "Pornire/Pauza"
    };
    lmap.ZTC_MENUCTX = {
      eng: "Actions",
      ita: "Azioni",
      spa: "Acciones",
      deu: "Aktionen",
      fra: "Actions",
      ron: "Actiuni"
    };
    lmap.ZTC_DATAORDER = {
      eng: "Switch data order",
      ita: "Inverti ordinamento dati",
      spa: "Ordenacion inversa de datos",
      deu: "Datenreihenfolge wechseln",
      fra: "Inverser le tri des donnees",
      ron: "Inversati sortarea datelor"
    };
    lmap.ZTC_SELMIN = {
      eng: "Select minimum values",
      ita: "Seleziona i valori minimi",
      spa: "Seleccione los valores minimos",
      deu: "Wahlen Sie die Mindestwerte aus",
      fra: "Selectionnez les valeurs minimales",
      ron: "Selectati valorile minime"
    };
    lmap.ZTC_SELMAX = {
      eng: "Select maximum values",
      ita: "Seleziona i valori massimi",
      spa: "Seleccione los valores maximos",
      deu: "Wahlen Sie die Maximalwerte aus",
      fra: "Selectionnez les valeurs maximales",
      ron: "Selectati valorile maxime"
    };
    lmap.ZTC_SELREM = {
      eng: "Unselect all values",
      ita: "Deseleziona tutti i valori",
      spa: "Desmarque todos los valores",
      deu: "Alle Werte abwahlen",
      fra: "Decocher toutes les valeurs",
      ron: "Deselectati toate valorile"
    };
    lmap.ZTC_SHOWOTH = {
      eng: "Show grouped data details",
      ita: "Mostra dettaglio dati aggregati",
      spa: "Mostrar detalles de datos agrupados",
      deu: "Gruppierte Datendetails anzeigen",
      fra: "Afficher les details des donnees groupees",
      ron: "Afisati detaliile datelor grupate"
    };
    lmap.ZTC_SHOWLEG = {
      eng: "Show legend",
      ita: "Mostra legenda",
      spa: "Mostrar leyenda",
      deu: "Legende zeigen",
      fra: "Afficher la legende",
      ron: "Arata legenda"
    };
    lmap.ZTC_RANLAB = {
      eng: "Range",
      ita: "Intervallo",
      spa: "Intervalo",
      deu: "Intervall",
      fra: "Intervalle",
      ron: "Interval"
    };
    lmap.ZTC_SKEYLAB = {
      eng: "Serie key",
      ita: "Chiave di serie",
      spa: "Clave de serie",
      deu: "Serienschlussel",
      fra: "Cle de serie",
      ron: "Cheia seriei"
    };
    lmap.ZTC_SELECTITEM = {
      eng: "Values selection",
      ita: "Selezione valori",
      spa: "Seleccion de valores",
      deu: "Auswahl von Werten",
      fra: "Selection de valeurs",
      ron: "Selectarea valorilor"
    };
    lmap.ZTC_HBARS = {
      eng: "Horizontal bars",
      ita: "Barre orizzontali",
      spa: "Barras horizontales",
      deu: "Horizontale Balken",
      fra: "Barres horizontales",
      ron: "Bare orizontale"
    };
    lmap.ZTC_PIES = {
      eng: "Pies",
      ita: "Torte",
      spa: "Graficos circulares",
      deu: "Kreisdiagramme",
      fra: "Camemberts",
      ron: "Diagrame circulare"
    };
    lmap.ZTC_MAPS = {
      eng: "Maps",
      ita: "Mappe",
      spa: "Mapas",
      deu: "Karten",
      fra: "Plans",
      ron: "Harti"
    };
    lmap.ZTC_STACKEDBARS = {
      eng: "Stacked bars",
      ita: "Barre in pila",
      spa: "Barras apiladas",
      deu: "Gestapelte Balken",
      fra: "Barres empilees",
      ron: "Baruri stivuite"
    };
    lmap.ZTC_LINE = {
      eng: "Lines-Areas-Radars",
      ita: "Linee-Aree-Radars",
      spa: "Lineas-Areas-Radares",
      deu: "Linien-Bereiche-Radare",
      fra: "Lignes-Zones-Radars",
      ron: "Linii-Zone-Radare"
    };
    lmap.ZTC_VBARS = {
      eng: "Vertical bars",
      ita: "Barre verticali",
      spa: "Barras verticales",
      deu: "Vertikale Balken",
      fra: "Barres verticales",
      ron: "Bare verticale"
    };
    lmap.ZTC_HBAR = {
      eng: "Horizontal bar",
      ita: "Barra orizzontale",
      spa: "Barra horizontal",
      deu: "Horizontale Bar",
      fra: "Barre horizontale",
      ron: "Bara orizontala"
    };
    lmap.ZTC_HBAR3D = {
      eng: "Horizontal bar 3D",
      ita: "Barra orizzontale 3D",
      spa: "Barra horizontal 3D",
      deu: "3D Horizontale Bar",
      fra: "Barre horizontale 3D",
      ron: "Bara orizontala 3D"
    };
    lmap.ZTC_PYRAMID = {
      eng: "Pyramid distribution",
      ita: "Distribuzione a piramide",
      spa: "Distribucion piramidal",
      deu: "Pyramidale Verteilung",
      fra: "Repartition pyramidale",
      ron: "Distributie piramidala"
    };
    lmap.ZTC_LAYEREDBARH = {
      eng: "Layered horizontal bar",
      ita: "Barre orizzontali stratificate",
      spa: "Barra horizontal en capas",
      deu: "Geschichtete horizontale Balken",
      fra: "Barre horizontale en couches",
      ron: "Bara orizontala stratificata"
    };
    lmap.ZTC_PIE = {
      eng: "Pie",
      ita: "Torta",
      spa: "Grafico circular",
      deu: "Kreisdiagramm",
      fra: "Camembert",
      ron: "Diagram circulare"
    };
    lmap.ZTC_PIE3D = {
      eng: "Pie 3D",
      ita: "Torta 3D",
      spa: "Grafico circular 3D",
      deu: "3D-Kreisdiagramm",
      fra: "Camembert 3D",
      ron: "Diagram circulare 3D"
    };
    lmap.ZTC_RING = {
      eng: "Ring",
      ita: "Anello",
      spa: "Anillo",
      deu: "Ringdiagramm",
      fra: "Bague",
      ron: "Inel"
    };
    lmap.ZTC_TREEMAP = {
      eng: "Treemap",
      ita: "Mappa ad albero",
      spa: "Treemap",
      deu: "Treemap",
      fra: "Treemap",
      ron: "Treemap"
    };
    lmap.ZTC_TREEMAPBAR = {
      eng: "Treemap bar",
      ita: "Barre verticali mappate ad albero",
      spa: "Treemap barras verticales",
      deu: "Treemap vertikale Balken",
      fra: "Treemap barres verticales",
      ron: "Treemap bare verticale"
    };
    lmap.ZTC_TREEMAPBARH = {
      eng: "Treemap horizontal bar",
      ita: "Barre orizzontali mappate ad albero",
      spa: "Treemap barra horizontal",
      deu: "Treemap horizontale Bar",
      fra: "Treemap barre horizontale",
      ron: "Treemap bara orizontala"
    };
    lmap.ZTC_WORDCLOUD = {
      eng: "Word cloud",
      ita: "Nuvola concettuale",
      spa: "Nube de palabras",
      deu: "Wortwolke",
      fra: "Mot nuage",
      ron: "Nor de cuvinte"
    };
    lmap.ZTC_HSTACKBAR = {
      eng: "Horizontal stacked-bar",
      ita: "Barra orizzontale in pila",
      spa: "Barra horizontal apilada",
      deu: "Gestapelte horizontale Balken",
      fra: "Barre horizontale empilee",
      ron: "Bara orizontala stivuita"
    };
    lmap.ZTC_HSTACKBAR3D = {
      eng: "Horizontal stacked-bar 3D",
      ita: "Barra orizzontale in pila 3D",
      spa: "Barra horizontal apilada 3D",
      deu: "3D Gestapelte horizontale Balken",
      fra: "Barre horizontale empilee 3D",
      ron: "Bara orizontala stivuita ED"
    };
    lmap.ZTC_VSTACKBAR = {
      eng: "Vertical stacked-bar",
      ita: "Barra verticale in pila",
      spa: "Barra vertical apilada",
      deu: "Gestapelter vertikaler Balken",
      fra: "Barre verticale empilee",
      ron: "Bara verticala stivuita"
    };
    lmap.ZTC_VSTACKBAR3D = {
      eng: "Vertical stacked-bar 3D",
      ita: "Barra verticale in pila 3D",
      spa: "Barra vertical apilada 3D",
      deu: "3D Gestapelter vertikaler Balken",
      fra: "Barre verticale empilee 3D",
      ron: "Bara verticala stivuita 3D"
    };
    lmap.ZTC_LINES = {
      eng: "Line",
      ita: "Linea",
      spa: "Linea",
      deu: "Linie",
      fra: "Ligne",
      ron: "Linia"
    };
    lmap.ZTC_AREA = {
      eng: "Area",
      ita: "Area",
      spa: "Area",
      deu: "Bereich",
      fra: "Zone",
      ron: "Zona"
    };
    lmap.ZTC_STACKEDAREA = {
      eng: "Stacked-area",
      ita: "Area in pila",
      spa: "Area apilada",
      deu: "Gestapelter Bereich",
      fra: "Zone empilee",
      ron: "Zona stivuita"
    };
    lmap.ZTC_RADARLINE = {
      eng: "Radar-line",
      ita: "Radar",
      spa: "Radar",
      deu: "Radar",
      fra: "Radar",
      ron: "Radar"
    };
    lmap.ZTC_RADARAREA = {
      eng: "Radar-area",
      ita: "Radar area",
      spa: "Radar-area",
      deu: "Radar-Bereich",
      fra: "Radar-zone",
      ron: "Radar-zona"
    };
    lmap.ZTC_VBAR = {
      eng: "Vertical bar",
      ita: "Barra verticale",
      spa: "Barra vertical",
      deu: "Vertikaler Balken",
      fra: "Barre verticale",
      ron: "Bara verticala"
    };
    lmap.ZTC_VBAR3D = {
      eng: "Vertical bar 3D",
      ita: "Barra verticale 3D",
      spa: "Barra vertical 3D",
      deu: "3D Vertikaler Balken",
      fra: "Barre verticale 3D",
      ron: "Bara verticala 3D"
    };
    lmap.ZTC_PARETO = {
      eng: "Pareto",
      ita: "Pareto",
      spa: "Pareto",
      deu: "Pareto",
      fra: "Pareto",
      ron: "Pareto"
    };
    lmap.ZTC_WATERF = {
      eng: "Waterfall",
      ita: "Cascata",
      spa: "Cascada",
      deu: "Wasserfall",
      fra: "Cascade",
      ron: "Cascada"
    };
    lmap.ZTC_LAYEREDBAR = {
      eng: "Layered vertical bar",
      ita: "Barre verticali stratificate",
      spa: "Barra vertical en capas",
      deu: "Geschichteter vertikaler Balken",
      fra: "Barre verticale en couches",
      ron: "Bara verticala stratificata"
    };
    lmap.ZTC_SCATTER = {
      eng: "Scatter",
      ita: "Dispersione",
      spa: "Dispersion",
      deu: "Streuung",
      fra: "Dispersion",
      ron: "Dispersia"
    };
    lmap.ZTC_BUBBLE = {
      eng: "Bubble",
      ita: "Bolle",
      spa: "Burbujas",
      deu: "Blaschen",
      fra: "Bulles",
      ron: "Bule"
    };
    lmap.ZTC_ARCDIAL = {
      eng: "Dial",
      ita: "Cruscotto",
      spa: "Taquimetro",
      deu: "Tachometer",
      fra: "Compteur de vitesse",
      ron: "Vitezometru"
    };
    lmap.ZTC_THERMO = {
      eng: "Thermometer",
      ita: "Termometro",
      spa: "Termometro",
      deu: "Thermometer",
      fra: "Thermometre",
      ron: "Termometru"
    };
    lmap.ZTC_LIGHTS = {
      eng: "Lights",
      ita: "Semaforo",
      spa: "Semaforo",
      deu: "Ampel",
      fra: "Semaphore",
      ron: "Semafor"
    };
    lmap.ZTC_IMAGES = {
      eng: "Images",
      ita: "Immagine",
      spa: "Imagen",
      deu: "Bild",
      fra: "Image",
      ron: "Imagine"
    };
    lmap.ZTC_DISPLAY = {
      eng: "Display",
      ita: "Display",
      spa: "Display",
      deu: "Display",
      fra: "Display",
      ron: "Display"
    };
    lmap.ZTC_COUNTER = {
      eng: "Counter",
      ita: "Contatori",
      spa: "Contador",
      deu: "Zahler",
      fra: "Compteur",
      ron: "Counter"
    };
    lmap.ZTC_PADDLE = {
      eng: "Paddle counter",
      ita: "Contatori a scheda",
      spa: "Paddle counter",
      deu: "Paddle counter",
      fra: "Paddle counter",
      ron: "Paddle counter"
    };
    lmap.ZTC_GEOMAP = {
      eng: "Geographic map",
      ita: "Mappa geografica",
      spa: "Mapa geografico",
      deu: "Geografische Karte",
      fra: "Carte geographique",
      ron: "Harta geografica"
    };
    lmap.ZTC_SVG = {
      eng: "SVG document",
      ita: "Documento SVG",
      spa: "Documento SVG",
      deu: "SVG-Dokument",
      fra: "Document SVG",
      ron: "Document SVG"
    };
    lmap.ZTC_SVGF = {
      eng: "SVG document w/fonts",
      ita: "Documento SVG con fonts",
      spa: "Documento SVG con fuentes",
      deu: "SVG-Dokument mit Schriftarten",
      fra: "Document SVG avec polices",
      ron: "Document SVG cu fonturi"
    };
    lmap.ZTC_PNG = {
      eng: "PNG image",
      ita: "Immagine PNG",
      spa: "Imagen PNG",
      deu: "PNG-Bild",
      fra: "Image PNG",
      ron: "Imagine PNG"
    };
    lmap.ZTC_JPEG = {
      eng: "JPEG image",
      ita: "Immagine JPEG",
      spa: "Immagine JPEG",
      deu: "JPEG-Bild",
      fra: "Image JPEG",
      ron: "Imagine JPEG"
    };
    lmap.ZTC_PDF = {
      eng: "PDF document",
      ita: "Documento PDF",
      spa: "Documento PDF",
      deu: "PDF-Dokument",
      fra: "Document PDF",
      ron: "Document PDF"
    };
    lmap.ZTC_CSV = {
      eng: "CSV document",
      ita: "Documento CSV",
      spa: "Documento CSV",
      deu: "CSV-Dokument",
      fra: "Document CSV",
      ron: "Document CSV"
    };
    lmap.ZTC_XML = {
      eng: "XML document",
      ita: "Documento XML",
      spa: "Documento XML",
      deu: "XML-Dokument",
      fra: "Document XML",
      ron: "Document XML"
    };
    lmap.ZTC_MENUTYPES = {
      eng: "Chart types",
      ita: "Tipi di grafico",
      spa: "Tipos de graficos",
      deu: "Diagrammtypen",
      fra: "Types de graphiques",
      ron: "Tipuri de diagrame"
    };
    lmap.ZTC_MENUEXPORT = {
      eng: "Download",
      ita: "Download",
      spa: "Download",
      deu: "Download",
      fra: "Download",
      ron: "Download"
    };
    lmap.ZTC_XY = {
      eng: "XY axis",
      ita: "Assi XY",
      spa: "Ejes XY",
      deu: "XY-Achsen",
      fra: "Axes XY",
      ron: "Axele XY"
    };
    lmap.ZTC_YZ = {
      eng: "XYZ axis",
      ita: "Assi XYZ",
      spa: "Ejes XYZ",
      deu: "XYZ-Achsen",
      fra: "Axes XYZ",
      ron: "Axele XYZ"
    };
    lmap.ZTC_METER = {
      eng: "Meters",
      ita: "Misuratori",
      spa: "Metros",
      deu: "Meter",
      fra: "Metres",
      ron: "Contoare"
    };
    lmap.ZTC_STATE = {
      eng: "Status meters",
      ita: "Indicatori di stato",
      spa: "Indicadores de estado",
      deu: "Statusanzeigen",
      fra: "Indicateurs d'etat",
      ron: "Indicatori de stare"
    };
    lmap.ZTC_COUNTERS = {
      eng: "Counters",
      ita: "Contatori",
      spa: "Contadores",
      deu: "Zahler",
      fra: "Compteurs",
      ron: "Contoare"
    };
    lmap.ZTC_OTHERS = {
      eng: "Other",
      ita: "Altro",
      spa: "Otro",
      deu: "Andere",
      fra: "Autre",
      ron: "Alte"
    };
    lmap.ZTC_NEGVAL = {
      eng: "Negative value",
      ita: "Valore negativo",
      spa: "Valor negativo",
      deu: "Negativer Wert",
      fra: "Valeur negative",
      ron: "Valoare negativa"
    };
    lmap.ZTC_MENULEGEND = {
      eng: "Legend",
      ita: "Legenda",
      spa: "Leyenda",
      deu: "Legende",
      fra: "Legende",
      ron: "Legenda"
    };
    lmap.ZTC_TOTAL = {
      eng: "Total",
      ita: "Totale",
      spa: "Total",
      deu: "Gesamt",
      fra: "Total",
      ron: "Total"
    };
    lmap.ZTC_SELALL = {
      eng: "Select all values",
      ita: "Seleziona tutti i valori",
      spa: "Seleccionar todos los valores",
      deu: "Wahlen Sie alle Werte aus",
      fra: "Selectionner toutes les valeurs",
      ron: "Selectati toate valorile"
    };
    lmap.ZTC_CURRENTCHART = {
      eng: "Back to initial chart",
      ita: "Torna al grafico iniziale",
      spa: "Volver al grafico inicial",
      deu: "Gehen Sie zuruck zum Ausgangsdiagramm",
      fra: "Revenir au tableau initial",
      ron: "Reveniti la diagrama initiala"
    };
    lmap.ZTC_MENUFILTER = {
      eng: "Filters",
      ita: "Filtri",
      spa: "Filtros",
      deu: "Filter",
      fra: "Filtres",
      ron: "Filtre"
    };
    lmap.ZTC_RESETZOOM = {
      eng: "Reset and show all",
      ita: "Ripristina selezione",
      spa: "Restablecer seleccion",
      deu: "Auswahl zurucksetzen",
      fra: "Reinitialiser la selection",
      ron: "Resetati selectia"
    };
    lmap.ZTC_ASTER = {
      eng: "Aster plot",
      ita: "Anello Aster",
      spa: "Anillo Aster",
      deu: "Aster-Ring",
      fra: "Bague Aster",
      ron: "Inel Aster"
    };
    lmap.ZTC_AREABAR = {
      eng: "Area bar",
      ita: "Barre ad area",
      spa: "Barra de area",
      deu: "Bereichsleiste",
      fra: "Barre de zone",
      ron: "Bara de zona"
    };
    lmap.ZTC_HIE = {
      eng: "Hierarchical",
      ita: "Gerarchici",
      spa: "Jerarquico",
      deu: "Hierarchisch",
      fra: "Hierarchique",
      ron: "Ierarhic"
    };
    lmap.ZTC_SUNB = {
      eng: "Sunburst",
      ita: "Raggiera",
      spa: "Sunburst",
      deu: "Sunburst",
      fra: "Sunburst",
      ron: "Sunburst"
    };
    lmap.ZTC_SUNBSTR = {
      eng: "Sunburst structure",
      ita: "Struttura gerarchica a raggiera",
      spa: "Estructura Sunburst",
      deu: "Sunburst-Struktur",
      fra: "Structure Sunburst",
      ron: "Structura Sunburst",
    };
    lmap.ZTC_TREE = {
      eng: "Tree",
      ita: "Albero",
      spa: "Arbol",
      deu: "Baum",
      fra: "Arbre",
      ron: "Copac"
    };
    lmap.ZTC_TREESTR = {
      eng: "Tree structure",
      ita: "Struttura gerarchica ad albero",
      spa: "Arbol jerarquico",
      deu: "Hierarchische Baumstruktur",
      fra: "Arborescence hierarchique",
      ron: "Arborele ierarhic"
    };
    lmap.ZTC_CPACK = {
      eng: "Bubble cloud",
      ita: "Nuvola di bolle",
      spa: "Nube de burbujas",
      deu: "Blasenwolke",
      fra: "Nuage de bulles",
      ron: "Nor cu bule"
    };
    lmap.ZTC_CPACKSTR = {
      eng: "Circle Pack",
      ita: "Circle Pack",
      spa: "Circle Pack",
      deu: "Circle Pack",
      fra: "Circle Pack",
      ron: "Circle Pack"
    };
    lmap.ZTC_FORCE = {
      eng: "Force Layout",
      ita: "Force Layout",
      spa: "Force Layout",
      deu: "Force Layout",
      fra: "Force Layout",
      ron: "Force Layout"
    };
    lmap.ZTC_FORCESTR = {
      eng: "Force Layout structure",
      ita: "Struttura gerarchica Force Layout",
      spa: "Estructura Force Layout",
      deu: "Struktur Force Layout",
      fra: "Structure Force Layout",
      ron: "Structura Force Layout"
    };
    lmap.ZTC_COMP = {
      eng: "Comparison",
      ita: "Confronto",
      spa: "Comparacion",
      deu: "Vergleich",
      fra: "Comparaison",
      ron: "Comparatie"
    };
    lmap.ZTC_DISTR = {
      eng: "Distribution",
      ita: "Distribuzione",
      spa: "Distribucion",
      deu: "Verteilung",
      fra: "Distribution",
      ron: "Distributie"
    };
    lmap.ZTC_REL = {
      eng: "Relationship",
      ita: "Relazione",
      spa: "Relacion",
      deu: "Beziehung",
      fra: "Relation",
      ron: "Relatie"
    };
    lmap.ZTC_OVTIME = {
      eng: "Data over time",
      ita: "Andamento nel tempo",
      spa: "Tendencia en el tiempo",
      deu: "Trend im Laufe der Zeit",
      fra: "Tendance dans le temps",
      ron: "Tendinta in timp"
    };
    lmap.ZTC_FHIE = {
      eng: "Hierarchy",
      ita: "Gerarchia",
      spa: "Jerarquia",
      deu: "Hierarchie",
      fra: "Hierarchie",
      ron: "Ierarhie"
    };
    lmap.ZTC_PTW = {
      eng: "Part to whole",
      ita: "Proporzione",
      spa: "Proporcion",
      deu: "Anteil",
      fra: "Proportion",
      ron: "Proportie"
    };
    lmap.ZTC_CON = {
      eng: "Concept",
      ita: "Concettuale",
      spa: "Concepto",
      deu: "Konzept",
      fra: "Concept",
      ron: "Concept"
    };
    lmap.ZTC_LOC = {
      eng: "Location",
      ita: "Luogo geografico",
      spa: "Localizacion geografica",
      deu: "Geografische Position",
      fra: "Localisation geographique",
      ron: "Locatie geografica"
    };
    lmap.ZTC_CAR = {
      eng: "Graph",
      ita: "Cartesiano",
      spa: "Cartesiano",
      deu: "Kartesisch",
      fra: "Cartesien",
      ron: "Carteziana"
    };
    lmap.ZTC_IND = {
      eng: "Meter",
      ita: "Indicatore",
      spa: "Indicador",
      deu: "Indikator",
      fra: "Indicateur",
      ron: "Indicator"
    };
    lmap.ZTC_AER = {
      eng: "Proportional",
      ita: "Areogramma",
      spa: "Areograma",
      deu: "Areogramm",
      fra: "Areogramme",
      ron: "Areograma"
    };
    lmap.ZTC_GRA = {
      eng: "Diagram",
      ita: "Grafo",
      spa: "Diagrama",
      deu: "Graph",
      fra: "Diagramme",
      ron: "Diagrama"
    };
    lmap.ZTC_GSP = {
      eng: "Geospatial",
      ita: "Geospaziale",
      spa: "Geoespacial",
      deu: "Geodaten",
      fra: "Geospatial",
      ron: "Geospatial"
    };
    lmap.ZTC_TAB = {
      eng: "Table",
      ita: "Tabella",
      spa: "Tabla",
      deu: "Tabelle",
      fra: "Tableau",
      ron: "Tabel"
    };
    lmap.ZTC_FUNNEL = {
      eng: "Funnel",
      ita: "Funnel",
      spa: "Funnel",
      deu: "Funnel",
      fra: "Funnel",
      ron: "Funnel"
    };
    lmap.ZTC_PYR = {
      eng: "Pyramid",
      ita: "Piramide",
      spa: "Piramide",
      deu: "Pyramide",
      fra: "Pyramide",
      ron: "Piramida"
    };
    lmap.ZTC_PYRSTR = {
      eng: "Pyramid structure",
      ita: "Struttura piramidale",
      spa: "Estructura piramidal",
      deu: "Pyramidale Struktur",
      fra: "Structure pyramidale",
      ron: "Structura piramidala"
    };
    lmap.ZTC_NECKEDPYR = {
      eng: "Necked pyramid",
      ita: "Piramide (forma imbuto)",
      spa: "Piramide (forma embudo)",
      deu: "Pyramide (Trichterform)",
      fra: "Pyramide (forme d'entonnoir)",
      ron: "Piramida (forma palnie)"
    };
    lmap.ZTC_NECKEDPYRSTR = {
      eng: "Necked pyramid structure",
      ita: "Struttura piramidale (forma imbuto)",
      spa: "Estructura piramidal (forma embudo)",
      deu: "Pyramidale Struktur (Trichterform)",
      fra: "Structure pyramidale (forme d'entonnoir)",
      ron: "Structura piramidala (forma palnie)"
    };
    lmap.ZTC_BCMATRIX = {
      eng: "BCG-Matrix",
      ita: "Matrice BCG",
      spa: "Matriz BCG",
      deu: "BCG-Matrix",
      fra: "Matrice BCG",
      ron: "Matricea BCG"
    };
    lmap.ZTC_MARIMEKKO = {
      eng: "Marimekko",
      ita: "Marimekko",
      spa: "Marimekko",
      deu: "Marimekko",
      fra: "Marimekko",
      ron: "Marimekko"
    };
    lmap.ZTC_MATRIX = {
      eng: "Adjacency matrix",
      ita: "Matrice di adiacenza",
      spa: "Matriz de adyacencia",
      deu: "Nachbarschaftsmatrix",
      fra: "Matrice de contiguite",
      ron: "Matricea adiacentei"
    };
    lmap.ZTC_CHORD = {
      eng: "Chord",
      ita: "Diagramma a corde",
      spa: "Diagrama de cuerdas",
      deu: "String-Diagramm",
      fra: "Diagramme de chaine",
      ron: "Diagrama sirurilor"
    };
    lmap.ZTC_CAL = {
      eng: "Calendar",
      ita: "Calendario",
      spa: "Calendario",
      deu: "Kalender",
      fra: "Calendrier",
      ron: "Calendar"
    };
    lmap.ZTC_PCOORDS = {
      eng: "Parallel coordinates",
      ita: "Coordinate parallele",
      spa: "Coordenadas paralelas",
      deu: "Parallele Koordinaten",
      fra: "Coordonnees paralleles",
      ron: "Coordonate paralele"
    };
    lmap.ZTC_VORONOI = {
      eng: "Voronoi",
      ita: "Voronoi",
      spa: "Voronoi",
      deu: "Voronoi",
      fra: "Voronoi",
      ron: "Voronoi"
    };
    lmap.ZTC_SANKEY = {
      eng: "Sankey",
      ita: "Sankey",
      spa: "Sankey",
      deu: "Sankey",
      fra: "Sankey",
      ron: "Sankey"
    };
    lmap.ZTC_DATAGRID = {
      eng: "Show/hide grid",
      ita: "Mostra/nascondi tabella",
      spa: "Mostrar/ocultar tabla",
      deu: "Anzeigen/Ausblenden tabelle",
      fra: "Afficher/masquer tableau",
      ron: "Arata/ascunde tabel"
    };
    lmap.ZTC_RINGPERC = {
      eng: "Percentage ring",
      ita: "Anello percentuale",
      spa: "Anillo de porcentaje",
      deu: "Prozentring",
      fra: "Anneau de pourcentage",
      ron: "Inel procentual"
    };
    lmap.ZTC_GEOERROR = {
      eng: "Error in loading geomap file",
      ita: "Errore nel carimento del file geomap"
    };
    lmap.ZTC_LINEAREA = {
      eng: "Lines-Areas",
      ita: "Linee-Aree",
      spa: "Lineas-Areas",
      deu: "Linien-Bereiche",
      fra: "Lignes-Zones",
      ron: "Linii-Zone"
    };
    lmap.ZTC_RADARS = {
      eng: "Radars",
      ita: "Radars",
      spa: "Radares",
      deu: "Radare",
      fra: "Radars",
      ron: "Radare"
    };
    lmap.ZTC_BARS = {
      eng: "Bars",
      ita: "Barre",
      spa: "Barras",
      deu: "Balken",
      fra: "Barres",
      ron: "Bare"
    };


    this.Translate = function (key) { return (lmap[key] || key); }
  }
}

if (typeof ZtChart != 'undefined') {
  ZtChart.prototype.SetTranslationString = function (key, lang, trad) {
    var dict = this.ZtChartTransDict;
    if (!(key in dict))
      dict[key] = {};
    dict[key][lang.toLowerCase()] = trad;
  }

  ZtChart.prototype.SetTranslationObject = function (key, tradobj) {
    for (var lang in tradobj)
      this.SetTranslationString(key, lang, tradobj[lang]);
  }
}