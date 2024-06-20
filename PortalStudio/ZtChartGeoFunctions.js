/* exported getGRSubdivisions removeAllMapsFromLocalStorage getFirstAdminSubdivision getISSubdivisions
    getGBSubdivisions getIESubdivisions getDKSubdivisions getNOSubdivisions getSESubdivisions
    getFISubdivisions getEESubdivisions getLVSubdivisions getLTSubdivisions getPTSubdivisions
    getESSubdivisions getITSubdivisions getSISubdivisions getHRSubdivisions getBASubdivisions
    getRSSubdivisions getMESubdivisions getALSubdivisions getMKSubdivisions getCountries
    getUASubdivisions getBYSubdivisions getPLSubdivisions getCZSubdivisions getSKSubdivisions
    getHUSubdivisions getROSubdivisions getBGSubdivisions getMDSubdivisions getATSubdivisions
    getBESubdivisions getCHSubdivisions getDESubdivisions getFRSubdivisions getLISubdivisions
    getMCSubdivisions getMTSubdivisions getNLSubdivisions getLUSubdivisions getISOCode
    checkISOInList
*/

function removeMapFromLocalStorage(mapcode) {
  localStorage.removeItem('ZtChart' + mapcode);
}

function removeAllMapsFromLocalStorage() {
  var allmapsobj = getContinents();
  var allmaps = Object.keys(allmapsobj);
  for (var i = 0; i < allmaps.length; i++) {
    removeMapFromLocalStorage(allmaps[i]);
  }
}

function getContinents() {
  var continents = {};
  continents.EU = {name: "Europe", code: "EU", topoVersion: 1.0};
  continents.AF = {name: "Africa", code: "AF", topoVersion: 1.0};
  continents.AS = {name: "Asia", code: "AS", topoVersion: 1.0};
  continents.NA = {name: "North America", code: "NA", topoVersion: 1.0};
  continents.SA = {name: "South America", code: "SA", topoVersion: 1.0};
  continents.OC = {name: "Oceania", code: "OC", topoVersion: 1.0};
  continents.AN = {name: "Antarctica", code: "AN", topoVersion: 1.0};
  return continents;
}

function getCountries(continent) {
  var countries = {};
  switch (continent) {
    case "EU":
      countries = getEuropeanCountries();
      break;
  }
  return countries;
}

function getEuropeanCountries() {
  var europe = {};
  europe.IS = {localName: "Ísland", name: "Iceland", code: "IS", country: "IS", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.GB = {localName: "United Kingdom of Great Britain and Northern Ireland", name: "United Kingdom of Great Britain and Northern Ireland", code: "GB", country: "GB", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.IE = {localName: "Éire", name: "Ireland", code: "IE", country: "IE", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.DK = {localName: "Danmark", name: "Denmark", code: "DK", country: "DK", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.NO = {localName: "Norge", name: "Norway", code: "NO", country: "NO", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.SE = {localName: "Sverige", name: "Sweden", code: "SE", country: "SE", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.FI = {localName: "Suomi", name: "Finland", code: "FI", country: "FI", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.EE = {localName: "Eesti", name: "Estonia", code: "EE", country: "EE", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.LV = {localName: "Latvija", name: "Latvia", code: "LV", country: "LV", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.LT = {localName: "Lietuva", name: "Lithuania", code: "LT", country: "LT", subname: "Northern Europe", subcode: "N-EU", contname: "Europe", contcode: "EU"};
  europe.PT = {localName: "Portugal", name: "Portugal", code: "PT", country: "PT", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.ES = {localName: "España", name: "Spain", code: "ES", country: "ES", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.IT = {localName: "Italia", name: "Italy", code: "IT", country: "IT", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.SI = {localName: "Slovenija", name: "Slovenia", code: "SI", country: "SI", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.HR = {localName: "Hrvatska", name: "Croatia", code: "HR", country: "HR", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.BA = {localName: "Bosna i Hercegovina", name: "Bosnia and Herzegovina", code: "BA", country: "BA", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
 // europe.SM = {localName: "San Marino", name: "San Marino", code: "SM", country: "SM", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.RS = {localName: "Srbija", name: "Serbia", code: "RS", country: "RS", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.ME = {localName: "Crna Gora", name: "Montenegro", code: "ME", country: "ME", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.AL = {localName: "Shqipëria", name: "Albania", code: "AL", country: "AL", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.MK = {localName: "Makedonija", name: "The former Yugoslav Republic of Macedonia", code: "MK", country: "MK", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.GR = {localName: "Ελλάδα", name: "Greece", code: "GR", country: "GR", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.AD = {localName: "Andorra", name: "Andorra", code: "AD", country: "AD", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
 // europe.VA = {localName: "Città del Vaticano", name: "Vatican City State", code: "VA", country: "VA", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.GI = {localName: "Gibraltar", name: "Gibraltar", code: "GI", country: "GI", subname: "Southern Europe", subcode: "S-EU", contname: "Europe", contcode: "EU"};
  europe.RU = {localName: "Россия", name: "Russian Federation", code: "RU", country: "RU", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.UA = {localName: "Україна", name: "Ukraine", code: "UA", country: "UA", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.BY = {localName: "Белару́сь", name: "Belarus", code: "BY", country: "BY", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.PL = {localName: "Polska", name: "Poland", code: "PL", country: "PL", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.CZ = {localName: "Česká republika", name: "Czech Republic", code: "CZ", country: "CZ", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.SK = {localName: "Slovensko", name: "Slovakia", code: "SK", country: "SK", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.HU = {localName: "Magyarország", name: "Hungary", code: "HU", country: "HU", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.RO = {localName: "România", name: "Romania", code: "RO", country: "RO", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.BG = {localName: "България", name: "Bulgaria", code: "BG", country: "BG", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.MD = {localName: "Republica Moldova", name: "Republic of Moldova", code: "MD", country: "MD", subname: "Eastern Europe", subcode: "E-EU", contname: "Europe", contcode: "EU"};
  europe.AT = {localName: "Österreich", name: "Austria", code: "AT", country: "AT", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.BE = {localName: "", name: "Belgium", code: "BE", country: "BE", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.CH = {localName: "", name: "Switzerland", code: "CH", country: "CH", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.DE = {localName: "Deutschland", name: "Germany", code: "DE", country: "DE", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.FR = {localName: "France", name: "France", code: "FR", country: "FR", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.LI = {localName: "Liechtenstein", name: "Liechtenstein", code: "LI", country: "LI", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.MC = {localName: "Monaco", name: "Monaco", code: "MC", country: "MC", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.MT = {localName: "Malta", name: "Malta", code: "MT", country: "MT", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.NL = {localName: "Nederland", name: "Netherlands", code: "NL", country: "NL", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  europe.LU = {localName: "Lëtzebuerg", name: "Luxembourg", code: "LU", country: "LU", subname: "Western Europe", subcode: "W-EU", contname: "Europe", contcode: "EU"};
  return europe;
}

function getFirstAdminSubdivision(isocode) {
  var subd = {};
  var mfunc = "get" + isocode + "Subdivisions";
  if (window[mfunc]) {
    subd = window[mfunc]();
  }
  return subd;
}

function getISSubdivisions() {
  var is = {};
  is._3 = {localName: "Vesturland", name: "", code: "3"};
  is._4 = {localName: "Vestfirðir", name: "", code: "4"};
  is._2 = {localName: "Suðurnes", name: "", code: "2"};
  is._8 = {localName: "Suðurland", name: "", code: "8"};
  is._0 = {localName: "Reykjavík", name: "", code: "0"};
  is._5 = {localName: "Norðurland vestra", name: "", code: "5"};
  is._6 = {localName: "Norðurland eystra", name: "", code: "6"};
  is._1 = {localName: "Höfuðborgarsvæði utan Reykjavíkur", name: "", code: "1"};
  is._7 = {localName: "Austurland", name: "", code: "7"};
  return is;
}

function getGBSubdivisions() {
  var gb = {};
  gb._ENG = {localName: "England", name: "", code: "ENG"};
  gb._WLS = {localName: "Wales", name: "", code: "WLS"};
  gb._SCT = {localName: "Scotland", name: "", code: "SCT"};
  gb._NIR = {localName: "Northern Ireland", name: "", code: "NIR"};
  return gb;
}

function getIESubdivisions() {
  var ie = {};
  ie._U = {localName: "Ulster", name: "", code: "U"};
  ie._M = {localName: "Munster", name: "", code: "M"};
  ie._L = {localName: "Leinster", name: "", code: "L"};
  ie._C = {localName: "Connaught", name: "", code: "C"};
  return ie;
}

function getDKSubdivisions() {
  var dk = {};
  dk._83 = {localName: "Syddanmark", name: "", code: "83"};
  dk._85 = {localName: "Sjælland", name: "", code: "85"};
  dk._81 = {localName: "Nordjylland", name: "", code: "81"};
  dk._82 = {localName: "Midtjylland", name: "", code: "82"};
  dk._84 = {localName: "Hovedstaden", name: "", code: "84"};
  return dk;
}

function getNOSubdivisions() {
  var no = {};
  no._07 = {localName: "Vestfold", name: "", code: "07"};
  no._10 = {localName: "Vest-Agder", name: "", code: "10"};
  no._19 = {localName: "Troms", name: "", code: "19"};
  no._08 = {localName: "Telemark", name: "", code: "08"};
  no._16 = {localName: "Sør-Trøndelag", name: "", code: "16"};
  no._14 = {localName: "Sogn og Fjordane", name: "", code: "14"};
  no._11 = {localName: "Rogaland", name: "", code: "11"};
  no._01 = {localName: "Østfold", name: "", code: "01"};
  no._03 = {localName: "Oslo", name: "", code: "03"};
  no._05 = {localName: "Oppland", name: "", code: "05"};
  no._18 = {localName: "Nordland", name: "", code: "18"};
  no._17 = {localName: "Nord-Trøndelag", name: "", code: "17"};
  no._15 = {localName: "Møre og Romsdal", name: "", code: "15"};
  no._12 = {localName: "Hordaland", name: "", code: "12"};
  no._04 = {localName: "Hedmark", name: "", code: "04"};
  no._20 = {localName: "Finnmark", name: "", code: "20"};
  no._06 = {localName: "Buskerud", name: "", code: "06"};
  no._09 = {localName: "Aust-Agder", name: "", code: "09"};
  no._02 = {localName: "Akershus", name: "", code: "02"};
  no._84 = {localName: "Hovedstaden", name: "", code: "84"};
  return no;
}

function getSESubdivisions() {
  var se = {};
  se._O = {localName: "Västra Götalands län", name: "", code: "O"};
  se._U = {localName: "Västmanlands län", name: "", code: "U"};
  se._Y = {localName: "Västernorrlands län", name: "", code: "Y"};
  se._AC = {localName: "Västerbottens län", name: "", code: "AC"};
  se._S = {localName: "Värmlands län", name: "", code: "S"};
  se._C = {localName: "Uppsala län", name: "", code: "C"};
  se._AB = {localName: "Stockholms län", name: "", code: "AB"};
  se._D = {localName: "Södermanlands län", name: "", code: "D"};
  se._M = {localName: "Skåne län", name: "", code: "M"};
  se._E = {localName: "Östergötlands län", name: "", code: "E"};
  se._BD = {localName: "Norrbottens län", name: "", code: "BD"};
  se._G = {localName: "Kronobergs län", name: "", code: "G"};
  se._H = {localName: "Kalmar län", name: "", code: "H"};
  se._F = {localName: "Jönköpings län", name: "", code: "F"};
  se._Z = {localName: "Jämtlands län", name: "", code: "Z"};
  se._N = {localName: "Hallands län", name: "", code: "N"};
  se._I = {localName: "Gotlands län", name: "", code: "I"};
  se._X = {localName: "Gävleborgs län", name: "", code: "X"};
  se._W = {localName: "Dalarnas län", name: "", code: "W"};
  se._K = {localName: "Blekinge län", name: "", code: "K"};
  se._T = {localName: "Örebro län", name: "", code: "T"};
  return se;
}

function getFISubdivisions() {
  var fi = {};
  return fi;
}

function getEESubdivisions() {
  var ee = {};
  ee._86 = {localName: "Võrumaa", name: "", code: "86"};
  ee._84 = {localName: "Viljandimaa", name: "", code: "84"};
  ee._82 = {localName: "Valgamaa", name: "", code: "82"};
  ee._78 = {localName: "Tartumaa", name: "", code: "78"};
  ee._74 = {localName: "Saaremaa", name: "", code: "74"};
  ee._70 = {localName: "Raplamaa", name: "", code: "70"};
  ee._65 = {localName: "Põlvamaa", name: "", code: "65"};
  ee._67 = {localName: "Pärnumaa", name: "", code: "67"};
  ee._57 = {localName: "Läänemaa", name: "", code: "57"};
  ee._59 = {localName: "Lääne-Virumaa", name: "", code: "59"};
  ee._49 = {localName: "Jõgevamaa", name: "", code: "49"};
  ee._51 = {localName: "Järvamaa", name: "", code: "51"};
  ee._44 = {localName: "Ida-Virumaa", name: "", code: "44"};
  ee._39 = {localName: "Hiiumaa", name: "", code: "39"};
  ee._37 = {localName: "Harjumaa", name: "", code: "37"};
  return ee;
}

function getLVSubdivisions() {
  var lv = {};
  return lv;
}

function getLTSubdivisions() {
  var lt = {};
  lt._VL = {localName: "Vilniaus Apskritis", name: "", code: "VL"};
  lt._UT = {localName: "Utenos Apskritis", name: "", code: "UT"};
  lt._TE = {localName: "Telšių Apskritis", name: "", code: "TE"};
  lt._TA = {localName: "Tauragės Apskritis", name: "", code: "TA"};
  lt._SA = {localName: "Šiaulių Apskritis", name: "", code: "SA"};
  lt._PN = {localName: "Panevėžio Apskritis", name: "", code: "PN"};
  lt._MR = {localName: "Marijampolės Apskritis", name: "", code: "MR"};
  lt._KL = {localName: "Klaipėdos Apskritis", name: "", code: "KL"};
  lt._KU = {localName: "Kauno Apskritis", name: "", code: "KU"};
  lt._AL = {localName: "Alytaus Apskritis", name: "", code: "AL"};
  return lt;
}

function getPTSubdivisions() {
  var pt = {};
  pt._18 = {localName: "Viseu", name: "", code: "18"};
  pt._17 = {localName: "Vila Real", name: "", code: "17"};
  pt._16 = {localName: "Viana do Castelo", name: "", code: "16"};
  pt._15 = {localName: "Setúbal", name: "", code: "15"};
  pt._14 = {localName: "Santarém", name: "", code: "14"};
  pt._20 = {localName: "Região Autónoma dos Açores", name: "", code: "20"};
  pt._13 = {localName: "Porto", name: "", code: "13"};
  pt._12 = {localName: "Portalegre", name: "", code: "12"};
  pt._11 = {localName: "Lisboa", name: "", code: "11"};
  pt._10 = {localName: "Leiria", name: "", code: "10"};
  pt._09 = {localName: "Guarda", name: "", code: "09"};
  pt._08 = {localName: "Faro", name: "", code: "08"};
  pt._07 = {localName: "Évora", name: "", code: "07"};
  pt._06 = {localName: "Coimbra", name: "", code: "06"};
  pt._05 = {localName: "Castelo Branco", name: "", code: "05"};
  pt._04 = {localName: "Bragança", name: "", code: "04"};
  pt._03 = {localName: "Braga", name: "", code: "03"};
  pt._02 = {localName: "Beja", name: "", code: "02"};
  pt._01 = {localName: "Aveiro", name: "", code: "01"};
  return pt;
}

function getESSubdivisions() {
  var es = {};
  es._VC = {localName: "Valencia", name: "", code: "VC"};
  es._AR = {localName: "Aragón", name: "", code: "AR"};
  es._IB = {localName: "Illes Balears", name: "", code: "IB"};
  es._CT = {localName: "Cataluña", name: "", code: "CT"};
  es._PV = {localName: "País Vasco", name: "", code: "PV"};
  es._NC = {localName: "Navarra", name: "", code: "NC"};
  es._MC = {localName: "Murcia", name: "", code: "MC"};
  es._MD = {localName: "Madrid", name: "", code: "MD"};
  es._RI = {localName: "La Rioja", name: "", code: "RI"};
  es._GA = {localName: "Galicia", name: "", code: "GA"};
  es._EX = {localName: "Extremadura", name: "", code: "EX"};
  es._CL = {localName: "Castilla y León", name: "", code: "CL"};
  es._CM = {localName: "Castilla-La Mancha", name: "", code: "CM"};
  es._CB = {localName: "Cantabria", name: "", code: "CB"};
  es._AS = {localName: "Asturias", name: "", code: "AS"};
  es._AN = {localName: "Andalucía", name: "", code: "AN"};
  return es;
}

function getITSubdivisions() {
  var it = {};
  it._65 = {localName: "Abruzzo", name: "", code: "65"};
  it._77 = {localName: "Basilicata", name: "", code: "77"};
  it._78 = {localName: "Calabria", name: "", code: "78"};
  it._72 = {localName: "Campania", name: "", code: "72"};
  it._45 = {localName: "Emilia-Romagna", name: "", code: "45"};
  it._36 = {localName: "Friuli-Venezia Giulia", name: "", code: "36"};
  it._62 = {localName: "Lazio", name: "", code: "62"};
  it._42 = {localName: "Liguria", name: "", code: "42"};
  it._25 = {localName: "Lombardia", name: "", code: "25"};
  it._57 = {localName: "Marche", name: "", code: "57"};
  it._67 = {localName: "Molise", name: "", code: "67"};
  it._21 = {localName: "Piemonte", name: "", code: "21"};
  it._75 = {localName: "Puglia", name: "", code: "75"};
  it._88 = {localName: "Sardegna", name: "", code: "88"};
  it._82 = {localName: "Sicilia", name: "", code: "82"};
  it._52 = {localName: "Toscana", name: "", code: "52"};
  it._32 = {localName: "Trentino-Alto Adige", name: "", code: "32"};
  it._55 = {localName: "Umbria", name: "", code: "55"};
  it._23 = {localName: "Valle D'Aosta", name: "", code: "23"};
  it._34 = {localName: "Veneto", name: "", code: "34"};
  it._SM = {localName: "San Marino", name: "", code: "SM"};
  it._VA = {localName: "Citta' del Vaticano", name: "", code: "VA"};
  return it;
}

function getSISubdivisions() {
  var si = {};
  si._001 = {localName: "Aidussina", name: "", code:"001"};
  si._002 = {localName: "Beltinci", name: "", code:"002"};
  si._020 = {localName: "Dobrepolje", name: "", code:"20"};
  si._146 = {localName: "Železniki", name: "", code:"146"};
  si._147 = {localName: "Žiri", name: "", code:"147"};
  si._148 = {localName: "Benedikt", name: "", code:"148"};
  si._149 = {localName: "Bistrica ob Sotli", name: "", code:"149"};
  si._150 = {localName: "Bloke", name: "", code:"150"};
  si._151 = {localName: "Braslovče", name: "", code:"151"};
  si._152 = {localName: "Cankova", name: "", code:"152"};
  si._153 = {localName: "Cerkvenjak", name: "", code:"153"};
  si._154 = {localName: "Dobje", name: "", code:"154"};
  si._155 = {localName: "Dobrna", name: "", code:"155"};
  si._156 = {localName: "Dobrovnik", name: "", code:"156"};
  si._157 = {localName: "Dolenjske Toplice", name: "", code:"157"};
  si._158 = {localName: "Grad", name: "", code:"158"};
  si._159 = {localName: "Hajdina", name: "", code:"159"};
  si._160 = {localName: "Hoče-Slivnica", name: "", code:"160"};
  si._161 = {localName: "Hodoš", name: "", code:"161"};
  si._162 = {localName: "Horjul", name: "", code:"162"};
  si._163 = {localName: "Jezersko", name: "", code:"163"};
  si._164 = {localName: "Komenda", name: "", code:"164"};
  si._165 = {localName: "Kostel", name: "", code:"165"};
  si._166 = {localName: "Križevci", name: "", code:"166"};
  si._167 = {localName: "Lovrenc na Pohorju", name: "", code:"167"};
  si._168 = {localName: "Markovci", name: "", code:"168"};
  si._169 = {localName: "Miklavž na Dravskem polju", name: "", code:"169"};
  si._170 = {localName: "Mirna Peč", name: "", code:"170"};
  si._171 = {localName: "Oplotnica", name: "", code:"171"};
  si._172 = {localName: "Podlehnik", name: "", code:"172"};
  si._173 = {localName: "Polzela", name: "", code:"173"};
  si._174 = {localName: "Prebold", name: "", code:"174"};
  si._175 = {localName: "Prevalje", name: "", code:"175"};
  si._176 = {localName: "Razkrižje", name: "", code:"176"};
  si._177 = {localName: "Ribnica na Pohorju", name: "", code:"177"};
  si._178 = {localName: "Selnica ob Dravi", name: "", code:"178"};
  si._179 = {localName: "Sodražica", name: "", code:"179"};
  si._180 = {localName: "Solčava", name: "", code:"180"};
  si._181 = {localName: "Sveta Ana", name: "", code:"181"};
  si._182 = {localName: "Sveti Andraž v Slovenskih goricah", name: "", code:"182"};
  si._183 = {localName: "San Pietro-Vertoiba", name: "", code:"183"};
  si._184 = {localName: "Tabor", name: "", code:"184"};
  si._185 = {localName: "Trnovska vas", name: "", code:"185"};
  si._186 = {localName: "Trzin", name: "", code:"186"};
  si._187 = {localName: "Velika Polana", name: "", code:"187"};
  si._188 = {localName: "Veržej", name: "", code:"188"};
  si._189 = {localName: "Vransko", name: "", code:"189"};
  si._190 = {localName: "Žalec", name: "", code:"190"};
  si._191 = {localName: "Žetale", name: "", code:"191"};
  si._192 = {localName: "Žirovnica", name: "", code:"192"};
  si._193 = {localName: "Žužemberk", name: "", code:"193"};
  si._194 = {localName: "Šmartno pri Litiji", name: "", code:"194"};
  si._003 = {localName: "Bled", name: "", code:"003"};
  si._004 = {localName: "Bohinj", name: "", code:"004"};
  si._005 = {localName: "Borovnica", name: "", code:"005"};
  si._006 = {localName: "Plezzo", name: "", code:"006"};
  si._007 = {localName: "Collio", name: "", code:"007"};
  si._008 = {localName: "Brezovica", name: "", code:"008"};
  si._009 = {localName: "Brežice", name: "", code:"009"};
  si._010 = {localName: "Tišina", name: "", code:"010"};
  si._011 = {localName: "Celje", name: "", code:"011"};
  si._012 = {localName: "Cerklje na Gorenjskem", name: "", code:"012"};
  si._013 = {localName: "Circonio", name: "", code:"013"};
  si._014 = {localName: "Circhina", name: "", code:"014"};
  si._015 = {localName: "Črenšovci", name: "", code:"015"};
  si._016 = {localName: "Črna na Koroškem", name: "", code:"016"};
  si._017 = {localName: "Črnomelj", name: "", code:"017"};
  si._018 = {localName: "Destrnik", name: "", code:"018"};
  si._019 = {localName: "Divaccia", name: "", code:"019"};
  si._021 = {localName: "Dobrova-Polhov Gradec", name: "", code:"021"};
  si._022 = {localName: "Dol pri Ljubljani", name: "", code:"022"};
  si._023 = {localName: "Domžale", name: "", code:"023"};
  si._024 = {localName: "Dornava", name: "", code:"024"};
  si._025 = {localName: "Dravograd", name: "", code:"025"};
  si._026 = {localName: "Duplek", name: "", code:"026"};
  si._027 = {localName: "Gorenja vas-Poljane", name: "", code:"027"};
  si._028 = {localName: "Gorišnica", name: "", code:"028"};
  si._029 = {localName: "Gornja Radgona", name: "", code:"029"};
  si._030 = {localName: "Gornji Grad", name: "", code:"030"};
  si._031 = {localName: "Gornji Petrovci", name: "", code:"031"};
  si._032 = {localName: "Grosuplje", name: "", code:"032"};
  si._033 = {localName: "Šalovci", name: "", code:"033"};
  si._034 = {localName: "Hrastnik", name: "", code:"034"};
  si._035 = {localName: "Erpelle-Cosina", name: "", code:"035"};
  si._036 = {localName: "Idria", name: "", code:"036"};
  si._037 = {localName: "Ig", name: "", code:"037"};
  si._038 = {localName: "Bisterza", name: "", code:"038"};
  si._039 = {localName: "Ivančna Gorica", name: "", code:"039"};
  si._040 = {localName: "Isola", name: "", code:"040"};
  si._041 = {localName: "Jesenice", name: "", code:"041"};
  si._042 = {localName: "Juršinci", name: "", code:"042"};
  si._043 = {localName: "Kamnik", name: "", code:"043"};
  si._044 = {localName: "Canale d'Isonzo", name: "", code:"044"};
  si._045 = {localName: "Kidričevo", name: "", code:"045"};
  si._046 = {localName: "Caporetto", name: "", code:"046"};
  si._047 = {localName: "Kobilje", name: "", code:"047"};
  si._048 = {localName: "Kočevje", name: "", code:"048"};
  si._049 = {localName: "Comeno", name: "", code:"049"};
  si._050 = {localName: "Capodistria", name: "", code:"050"};
  si._051 = {localName: "Kozje", name: "", code:"051"};
  si._052 = {localName: "Kranj", name: "", code:"052"};
  si._053 = {localName: "Kranjska Gora", name: "", code:"053"};
  si._054 = {localName: "Krško", name: "", code:"054"};
  si._055 = {localName: "Kungota", name: "", code:"055"};
  si._056 = {localName: "Kuzma", name: "", code:"056"};
  si._057 = {localName: "Laško", name: "", code:"057"};
  si._058 = {localName: "Lenart", name: "", code:"058"};
  si._059 = {localName: "Lendava", name: "", code:"059"};
  si._060 = {localName: "Litija", name: "", code:"060"};
  si._061 = {localName: "Lubiana", name: "", code:"061"};
  si._062 = {localName: "Ljubno", name: "", code:"062"};
  si._063 = {localName: "Ljutomer", name: "", code:"063"};
  si._064 = {localName: "Logatec", name: "", code:"064"};
  si._065 = {localName: "Loška dolina", name: "", code:"065"};
  si._066 = {localName: "Loški Potok", name: "", code:"066"};
  si._067 = {localName: "Luče", name: "", code:"067"};
  si._068 = {localName: "Lukovica", name: "", code:"068"};
  si._069 = {localName: "Majšperk", name: "", code:"069"};
  si._070 = {localName: "Maribor", name: "", code:"070"};
  si._071 = {localName: "Medvode", name: "", code:"071"};
  si._072 = {localName: "Mengeš", name: "", code:"072"};
  si._073 = {localName: "Metlika", name: "", code:"073"};
  si._074 = {localName: "Mežica", name: "", code:"074"};
  si._075 = {localName: "Merna-Castagnevizza", name: "", code:"075"};
  si._076 = {localName: "Mislinja", name: "", code:"076"};
  si._077 = {localName: "Moravče", name: "", code:"077"};
  si._078 = {localName: "Moravske Toplice", name: "", code:"078"};
  si._079 = {localName: "Mozirje", name: "", code:"079"};
  si._080 = {localName: "Murska Sobota", name: "", code:"080"};
  si._081 = {localName: "Muta", name: "", code:"081"};
  si._082 = {localName: "Naklo", name: "", code:"082"};
  si._083 = {localName: "Nazarje", name: "", code:"083"};
  si._084 = {localName: "Nova Gorica", name: "", code:"084"};
  si._085 = {localName: "Novo Mesto", name: "", code:"085"};
  si._086 = {localName: "Odranci", name: "", code:"086"};
  si._087 = {localName: "Ormož", name: "", code:"087"};
  si._088 = {localName: "Osilnica", name: "", code:"088"};
  si._089 = {localName: "Pesnica", name: "", code:"089"};
  si._090 = {localName: "Pirano", name: "", code:"090"};
  si._091 = {localName: "San Pietro del Carso", name: "", code:"091"};
  si._092 = {localName: "Podčetrtek", name: "", code:"092"};
  si._093 = {localName: "Podvelka", name: "", code:"093"};
  si._094 = {localName: "Postumia", name: "", code:"094"};
  si._095 = {localName: "Preddvor", name: "", code:"095"};
  si._096 = {localName: "Ptuj", name: "", code:"096"};
  si._097 = {localName: "Puconci", name: "", code:"097"};
  si._098 = {localName: "Rače-Fram", name: "", code:"098"};
  si._099 = {localName: "Radeče", name: "", code:"099"};
  si._100 = {localName: "Radenci", name: "", code:"100"};
  si._101 = {localName: "Radlje ob Dravi", name: "", code:"101"};
  si._102 = {localName: "Radovljica", name: "", code:"102"};
  si._103 = {localName: "Ravne na Koroškem", name: "", code:"103"};
  si._104 = {localName: "Ribnica", name: "", code:"104"};
  si._105 = {localName: "Rogašovci", name: "", code:"105"};
  si._106 = {localName: "Rogaška Slatina", name: "", code:"106"};
  si._107 = {localName: "Rogatec", name: "", code:"107"};
  si._108 = {localName: "Ruše", name: "", code:"108"};
  si._109 = {localName: "Semič", name: "", code:"109"};
  si._110 = {localName: "Sevnica", name: "", code:"110"};
  si._111 = {localName: "Sesana", name: "", code:"111"};
  si._112 = {localName: "Slovenj Gradec", name: "", code:"112"};
  si._113 = {localName: "Slovenska Bistrica", name: "", code:"113"};
  si._114 = {localName: "Slovenske Konjice", name: "", code:"114"};
  si._115 = {localName: "Starše", name: "", code:"115"};
  si._116 = {localName: "Sveti Jurij v Slovenskih goricah", name: "", code:"116"};
  si._117 = {localName: "Šenčur", name: "", code:"117"};
  si._118 = {localName: "Šentilj", name: "", code:"118"};
  si._119 = {localName: "Šentjernej", name: "", code:"119"};
  si._120 = {localName: "Šentjur pri Celju", name: "", code:"120"};
  si._121 = {localName: "Škocjan", name: "", code:"121"};
  si._122 = {localName: "Škofja Loka", name: "", code:"122"};
  si._123 = {localName: "Škofljica", name: "", code:"123"};
  si._124 = {localName: "Šmarje pri Jelšah", name: "", code:"124"};
  si._125 = {localName: "Šmartno ob Paki", name: "", code:"125"};
  si._126 = {localName: "Šoštanj", name: "", code:"126"};
  si._127 = {localName: "Štore", name: "", code:"127"};
  si._128 = {localName: "Tolmino", name: "", code:"128"};
  si._129 = {localName: "Trbovlje", name: "", code:"129"};
  si._130 = {localName: "Trebnje", name: "", code:"130"};
  si._131 = {localName: "Tržič", name: "", code:"131"};
  si._132 = {localName: "Turnišče", name: "", code:"132"};
  si._133 = {localName: "Velenje", name: "", code:"133"};
  si._134 = {localName: "Velike Lašče", name: "", code:"134"};
  si._135 = {localName: "Videm", name: "", code:"135"};
  si._136 = {localName: "Vipacco", name: "", code:"136"};
  si._137 = {localName: "Vitanje", name: "", code:"137"};
  si._138 = {localName: "Vodice", name: "", code:"138"};
  si._139 = {localName: "Vojnik", name: "", code:"139"};
  si._140 = {localName: "Vrhnika", name: "", code:"140"};
  si._141 = {localName: "Vuzenica", name: "", code:"141"};
  si._142 = {localName: "Zagorje ob Savi", name: "", code:"142"};
  si._143 = {localName: "Zavrč", name: "", code:"143"};
  si._144 = {localName: "Zreče", name: "", code:"144"};
  return si;
}

function getHRSubdivisions() {
  var hr = {};
  hr._21 = {localName: "Grad Zagreb", name: "Zagreb City", code: "21"};
  hr._07 = {localName: "Bjelovarsko-bilogorska županija", name: "Bjelovar-Bilogora", code: "07"};
  hr._12 = {localName: "Brodsko-posavska županija", name: "Brod-Posavina", code: "12"};
  hr._19 = {localName: "Dubrovačko-neretvanska županija", name: "Dubrovnik-Neretva", code: "19"};
  hr._18 = {localName: "Istarska županija", name: "Istria", code: "18"};
  hr._04 = {localName: "Karlovačka županija", name: "Karlovac", code: "04"};
  hr._06 = {localName: "Koprivničko-križevačka županija", name: "Koprivnica-Križevci", code: "06"};
  hr._02 = {localName: "Krapinsko-zagorska županija", name: "Krapina-Zagorje", code: "02"};
  hr._09 = {localName: "Ličko-senjska županija", name: "Lika-Senj", code: "09"};
  hr._20 = {localName: "Međimurska županija", name: "Međimurje", code: "20"};
  hr._14 = {localName: "Osječko-baranjska županija", name: "Osijek-Baranja", code: "14"};
  hr._11 = {localName: "Požeško-slavonska županija", name: "Požega-Slavonia", code: "11"};
  hr._08 = {localName: "Primorsko-goranska županija", name: "Primorje-Gorski Kotar", code: "08"};
  hr._03 = {localName: "Sisačko-moslavačka županija", name: "Sisak-Moslavina", code: "03"};
  hr._17 = {localName: "Splitsko-dalmatinska županija", name: "Split-Dalmatia", code: "17"};
  hr._15 = {localName: "Šibensko-kninska županija", name: "Šibenik-Knin", code: "15"};
  hr._05 = {localName: "Varaždinska županija", name: "Varaždin", code: "05"};
  hr._10 = {localName: "Virovitičko-podravska županija", name: "Virovitica-Podravina", code: "10"};
  hr._16 = {localName: "Vukovarsko-srijemska županija", name: "Vukovar-Srijem", code: "16"};
  hr._13 = {localName: "Zadarska županija", name: "Zadar", code: "13"};
  hr._01 = {localName: "Zagrebačka županija", name: "Zagreb County", code: "01"};
  return hr;
}

function getBASubdivisions() {
  var ba = {};
  ba._BIH = {localName: "Federacija Bosna i Hercegovina", name: "Federation of Bosnia and Herzegovina", code: "BIH"};
  ba._SRP = {localName: "Republika Srpska", name: "Republika Srpska", code: "SRP"};
  ba._BRC = {localName: "Brčko distrikt", name: "Brčko District", code: "BRC"};
  return ba;
}

function getRSSubdivisions() {
  var rs = {};
  return rs;
}

function getMESubdivisions() {
  var me = {};
  return me;
}

function getALSubdivisions() {
  var al = {};
  al._1 = {localName: "Berat", name: "", code: "1"};
  al._9 = {localName: "Dibër", name: "", code: "9"};
  al._2 = {localName: "Durrës", name: "", code: "2"};
  al._3 = {localName: "Elbasan", name: "", code: "3"};
  al._4 = {localName: "Fier", name: "", code: "4"};
  al._5 = {localName: "Gjirokastër", name: "", code: "5"};
  al._6 = {localName: "Korçë", name: "", code: "6"};
  al._7 = {localName: "Kukës", name: "", code: "7"};
  al._8 = {localName: "Lezhë", name: "", code: "8"};
  al._10 = {localName: "Shkodër", name: "", code: "10"};
  al._11 = {localName: "Tiranë", name: "", code: "11"};
  al._12 = {localName: "Vlorë", name: "", code: "12"};
  return al;
}

function getMKSubdivisions() {
  var mk = {};
  mk._01 = {localName: "Aerodrom", name: "", code: "01"};
  mk._02 = {localName: "Aračinovo", name: "", code: "02"};
  mk._03 = {localName: "Berovo", name: "", code: "03"};
  mk._04 = {localName: "Bitola", name: "", code: "04"};
  mk._05 = {localName: "Bogdanci", name: "", code: "05"};
  mk._06 = {localName: "Bogovinje", name: "", code: "06"};
  mk._07 = {localName: "Bosilovo", name: "", code: "07"};
  mk._08 = {localName: "Brvenica", name: "", code: "08"};
  mk._09 = {localName: "Butel", name: "", code: "09"};
  mk._10 = {localName: "Valandovo", name: "", code: "10"};
  mk._11 = {localName: "Vasilevo", name: "", code: "11"};
  mk._12 = {localName: "Vevčani", name: "", code: "12"};
  mk._13 = {localName: "Veles", name: "", code: "13"};
  mk._14 = {localName: "Vinica", name: "", code: "14"};
  mk._15 = {localName: "Vraneštica", name: "", code: "15"};
  mk._16 = {localName: "Vrapčište", name: "", code: "16"};
  mk._17 = {localName: "Gazi Baba", name: "", code: "17"};
  mk._18 = {localName: "Gevgelija", name: "", code: "18"};
  mk._19 = {localName: "Gostivar", name: "", code: "19"};
  mk._20 = {localName: "Gradsko", name: "", code: "20"};
  mk._21 = {localName: "Debar", name: "", code: "21"};
  mk._22 = {localName: "Debarca", name: "", code: "22"};
  mk._23 = {localName: "Delčevo", name: "", code: "23"};
  mk._24 = {localName: "Demir Kapija", name: "", code: "24"};
  mk._25 = {localName: "Demir Hisar", name: "", code: "25"};
  mk._26 = {localName: "Dojran", name: "", code: "26"};
  mk._27 = {localName: "Dolneni", name: "", code: "27"};
  mk._28 = {localName: "Drugovo", name: "", code: "28"};
  mk._29 = {localName: "Gjorče Petrov", name: "", code: "29"};
  mk._30 = {localName: "Želino", name: "", code: "30"};
  mk._31 = {localName: "Zajas", name: "", code: "31"};
  mk._32 = {localName: "Zelenikovo", name: "", code: "32"};
  mk._33 = {localName: "Zrnovci", name: "", code: "33"};
  mk._34 = {localName: "Ilinden", name: "", code: "34"};
  mk._35 = {localName: "Jegunovce", name: "", code: "35"};
  mk._36 = {localName: "Kavadarci", name: "", code: "36"};
  mk._37 = {localName: "Karbinci", name: "", code: "37"};
  mk._38 = {localName: "Karpoš", name: "", code: "38"};
  mk._39 = {localName: "Kisela Voda", name: "", code: "39"};
  mk._40 = {localName: "Kičevo", name: "", code: "40"};
  mk._41 = {localName: "Konče", name: "", code: "41"};
  mk._42 = {localName: "Kočani", name: "", code: "42"};
  mk._43 = {localName: "Kratovo", name: "", code: "43"};
  mk._44 = {localName: "Kriva Palanka", name: "", code: "44"};
  mk._45 = {localName: "Krivogaštani", name: "", code: "45"};
  mk._46 = {localName: "Kruševo", name: "", code: "46"};
  mk._47 = {localName: "Kumanovo", name: "", code: "47"};
  mk._48 = {localName: "Lipkovo", name: "", code: "48"};
  mk._49 = {localName: "Lozovo", name: "", code: "49"};
  mk._50 = {localName: "Mavrovo i Rostuša", name: "", code: "50"};
  mk._51 = {localName: "Makedonska Kamenica", name: "", code: "51"};
  mk._52 = {localName: "Makedonski Brod", name: "", code: "52"};
  mk._53 = {localName: "Mogila", name: "", code: "53"};
  mk._54 = {localName: "Negotino", name: "", code: "54"};
  mk._55 = {localName: "Novaci", name: "", code: "55"};
  mk._56 = {localName: "Novo Selo", name: "", code: "56"};
  mk._57 = {localName: "Oslomej", name: "", code: "57"};
  mk._58 = {localName: "Ohrid", name: "", code: "58"};
  mk._59 = {localName: "Petrovec", name: "", code: "59"};
  mk._60 = {localName: "Pehčevo", name: "", code: "60"};
  mk._61 = {localName: "Plasnica", name: "", code: "61"};
  mk._62 = {localName: "Prilep", name: "", code: "62"};
  mk._63 = {localName: "Probištip", name: "", code: "63"};
  mk._64 = {localName: "Radoviš", name: "", code: "64"};
  mk._65 = {localName: "Rankovce", name: "", code: "65"};
  mk._66 = {localName: "Resen", name: "", code: "66"};
  mk._67 = {localName: "Rosoman", name: "", code: "67"};
  mk._68 = {localName: "Saraj", name: "", code: "68"};
  mk._69 = {localName: "Sveti Nikole", name: "", code: "69"};
  mk._70 = {localName: "Sopište", name: "", code: "70"};
  mk._71 = {localName: "Staro Nagoričane", name: "", code: "71"};
  mk._72 = {localName: "Struga", name: "", code: "72"};
  mk._73 = {localName: "Strumica", name: "", code: "73"};
  mk._74 = {localName: "Studeničani", name: "", code: "74"};
  mk._75 = {localName: "Tearce", name: "", code: "75"};
  mk._76 = {localName: "Tetovo", name: "", code: "76"};
  mk._77 = {localName: "Centar", name: "", code: "77"};
  mk._78 = {localName: "Centar Župa", name: "", code: "78"};
  mk._79 = {localName: "Čair", name: "", code: "79"};
  mk._80 = {localName: "Čaška", name: "", code: "80"};
  mk._81 = {localName: "Češinovo-Obleševo", name: "", code: "81"};
  mk._82 = {localName: "Čučer Sandevo", name: "", code: "82"};
  mk._83 = {localName: "Štip", name: "", code: "83"};
  mk._84 = {localName: "Šuto Orizari", name: "", code: "84"};
  return mk;
}

function getGRSubdivisions() {
  var gr = {};
  gr._I = {localName: "Anatoliki Makedonia kai Thraki", name: "Eastern Macedonia and Thrace", code: "I"};
  gr._IX = {localName: "Attiki", name: "Attica", code: "IX"};
  gr._VII = {localName: "Dytiki Ellada", name: "Western Greece", code: "VII"};
  gr._III = {localName: "Dytiki Makedonia", name: "Western Macedonia", code: "III"};
  gr._VI = {localName: "Ionia Nisia", name: "Ionian Islands", code: "VI"};
  gr._IV = {localName: "Ipeiros", name: "Epirus", code: "IV"};
  gr._III = {localName: "Kentriki Makedonia", name: "Central Macedonia", code: "III"};
  gr._XIII = {localName: "Kriti", name: "Crete", code: "XIII"};
  gr._XII = {localName: "Notio Aigaio", name: "Southern Aegean", code: "XII"};
  gr._X = {localName: "Peloponnisos", name: "Peloponnese", code: "X"};
  gr._VIII = {localName: "Sterea Ellada", name: "Central Greece", code: "VIII"};
  gr._V = {localName: "Thessalia", name: "Thessaly", code: "V"};
  gr._XI = {localName: "Voreio Aigaio", name: "Northern Aegean", code: "XI"};
  return gr;
}

function getUASubdivisions() {
  var ua = {};
  ua._71 = {localName: "Cherkas'ka Oblast'", name: "", code: "71"};
  ua._74 = {localName: "Chernihivs'ka Oblast'", name: "", code: "74"};
  ua._77 = {localName: "Chernivets'ka Oblast'", name: "", code: "77"};
  ua._12 = {localName: "Dnipropetrovs'ka Oblast'", name: "", code: "12"};
  ua._14 = {localName: "Donets'ka Oblast'", name: "", code: "14"};
  ua._26 = {localName: "Ivano-Frankivs'ka Oblast'", name: "", code: "26"};
  ua._63 = {localName: "Kharkivs'ka Oblast'", name: "", code: "63"};
  ua._65 = {localName: "Khersons'ka Oblast'", name: "", code: "65"};
  ua._68 = {localName: "Khmel'nyts'ka Oblast'", name: "", code: "68"};
  ua._35 = {localName: "Kirovohrads'ka Oblast'", name: "", code: "35"};
  ua._32 = {localName: "Kyïvs'ka Oblast'", name: "", code: "32"};
  ua._09 = {localName: "Luhans'ka Oblast'", name: "", code: "09"};
  ua._46 = {localName: "L'vivs'ka Oblast'", name: "", code: "46"};
  return ua;
}

function getBYSubdivisions() {
  var by = {};
  by._BR = {localName: "Brestskaya voblasts'", name: "Brest Region", code: "BR"};
  by._HO = {localName: "Homyel'skaya voblasts'", name: "Gomel Region", code: "HO"};
  by._HR = {localName: "Hrodzenskaya voblasts'", name: "Grodno Region", code: "HR"};
  by._MA = {localName: "Mahilyowskaya voblasts'", name: "Mogilev Region", code: "MA"};
  by._MI = {localName: "Minskaya voblasts'", name: "Minsk Region", code: "MI"};
  by._VI = {localName: "Vitsyebskaya voblasts'", name: "Vitebsk Region", code: "VI"};
  return by;
}

function getPLSubdivisions() {
  var pl = {};
  pl._DS = {localName: "Dolnośląskie", name: "Lower Silesia", code: "DS"};
  pl._KP = {localName: "Kujawsko-pomorskie", name: "Kuyavia-Pomerania", code: "KP"};
  pl._LU = {localName: "Lubelskie", name: "Lublin", code: "LU"};
  pl._LB = {localName: "Lubuskie", name: "Lubusz", code: "LB"};
  pl._LD = {localName: "Łódzkie", name: "Łódź", code: "LD"};
  pl._MA = {localName: "Małopolskie", name: "Lesser Poland", code: "MA"};
  pl._MZ = {localName: "Mazowieckie", name: "Mazovia", code: "MZ"};
  pl._OP = {localName: "Opolskie", name: "Opole (Upper Silesia)", code: "OP"};
  pl._PK = {localName: "Podkarpackie", name: "Subcarpathia", code: "PK"};
  pl._PD = {localName: "Podlaskie", name: "Podlaskie", code: "PD"};
  pl._PM = {localName: "Pomorskie", name: "Pomerania", code: "PM"};
  pl._SL = {localName: "Śląskie", name: "Silesia", code: "SL"};
  pl._SK = {localName: "Świętokrzyskie", name: "Holy Cross", code: "SK"};
  pl._WN = {localName: "Warmińsko-mazurskie", name: "Warmia-Masuria", code: "WN"};
  pl._WP = {localName: "Wielkopolskie", name: "Greater Poland", code: "WP"};
  pl._ZP = {localName: "Zachodniopomorskie", name: "West Pomerania", code: "ZP"};
  return pl;
}

function getCZSubdivisions() {
  var cz = {};
  cz._JC = {localName: "Jihočeský kraj", name: "South Bohemia", code: "JC"};
  cz._JM = {localName: "Jihomoravský kraj", name: "South Moravia", code: "JM"};
  cz._KA = {localName: "Karlovarský kraj", name: "Karlovy Vary", code: "KA"};
  cz._KR = {localName: "Královéhradecký kraj", name: "Hradec Králové", code: "KR"};
  cz._LI = {localName: "Liberecký kraj", name: "Liberec", code: "LI"};
  cz._MO = {localName: "Moravskoslezský kraj", name: "Moravia-Silesia", code: "MO"};
  cz._OL = {localName: "Olomoucký kraj", name: "Olomouc", code: "OL"};
  cz._PA = {localName: "Pardubický kraj", name: "Pardubice", code: "PA"};
  cz._PL = {localName: "Plzeňský kraj", name: "Plzeň", code: "PL"};
  cz._PR = {localName: "Praha, hlavní město", name: "Prague", code: "PR"};
  cz._ST = {localName: "Středočeský kraj", name: "Central Bohemia", code: "ST"};
  cz._US = {localName: "Ústecký kraj", name: "Ústí nad Labem", code: "US"};
  cz._VY = {localName: "Vysočina", name: "Vysočina", code: "VY"};
  cz._ZL = {localName: "Zlínský kraj", name: "Zlín", code: "ZL"};
  return cz;
}

function getSKSubdivisions() {
  var sk = {};
  sk._BC = {localName: "Banskobystrický kraj", name: "", code: "BC"};
  sk._BL = {localName: "Bratislavský kraj", name: "", code: "BL"};
  sk._KI = {localName: "Košický kraj", name: "", code: "KI"};
  sk._NI = {localName: "Nitriansky kraj", name: "", code: "NI"};
  sk._PV = {localName: "Prešovský kraj", name: "", code: "PV"};
  sk._TC = {localName: "Trenčiansky kraj", name: "", code: "TC"};
  sk._TA = {localName: "Trnavský kraj", name: "", code: "TA"};
  sk._ZI = {localName: "Žilinský kraj", name: "", code: "ZI"};
  return sk;
}

function getHUSubdivisions() {
  var hu = {};
  hu._BU = {localName: "Budapest", name: "", code: "BU"};
  hu._BK = {localName: "Bács-Kiskun", name: "", code: "BK"};
  hu._BA = {localName: "Baranya", name: "", code: "BA"};
  hu._BE = {localName: "Békés", name: "", code: "BE"};
  hu._BZ = {localName: "Borsod-Abaúj-Zemplén", name: "", code: "BZ"};
  hu._CS = {localName: "Csongrád", name: "", code: "CS"};
  hu._FE = {localName: "Fejér", name: "", code: "FE"};
  hu._GS = {localName: "Győr-Moson-Sopron", name: "", code: "GS"};
  hu._HB = {localName: "Hajdú-Bihar", name: "", code: "HB"};
  hu._HE = {localName: "Heves", name: "", code: "HE"};
  hu._JN = {localName: "Jász-Nagykun-Szolnok", name: "", code: "JN"};
  hu._KE = {localName: "Komárom-Esztergom", name: "", code: "KE"};
  hu._NO = {localName: "Nógrád", name: "", code: "NO"};
  hu._PE = {localName: "Pest", name: "", code: "PE"};
  hu._SO = {localName: "Somogy", name: "", code: "SO"};
  hu._SZ = {localName: "Szabolcs-Szatmár-Bereg", name: "", code: "SZ"};
  hu._TO = {localName: "Tolna", name: "", code: "TO"};
  hu._VA = {localName: "Vas", name: "", code: "VA"};
  hu._VE = {localName: "Veszprém", name: "", code: "VE"};
  hu._ZA = {localName: "Zala", name: "", code: "ZA"};
  return hu;
}

function getROSubdivisions() {
  var ro = {};
  ro._AB = {localName: "Alba", name: "", code: "AB"};
  ro._AR = {localName: "Arad", name: "", code: "AR"};
  ro._AG = {localName: "Argeș", name: "", code: "AG"};
  ro._BC = {localName: "Bacău", name: "", code: "BC"};
  ro._BH = {localName: "Bihor", name: "", code: "BH"};
  ro._BN = {localName: "Bistrița-Năsăud", name: "", code: "BN"};
  ro._BT = {localName: "Botoșani", name: "", code: "BT"};
  ro._BV = {localName: "Brașov", name: "", code: "BV"};
  ro._BR = {localName: "Brăila", name: "", code: "BR"};
  ro._BZ = {localName: "Buzău", name: "", code: "BZ"};
  ro._CS = {localName: "Caraș-Severin", name: "", code: "CS"};
  ro._CL = {localName: "Călărași", name: "", code: "CL"};
  ro._CJ = {localName: "Cluj", name: "", code: "CJ"};
  ro._CT = {localName: "Constanța", name: "", code: "CT"};
  ro._CV = {localName: "Covasna", name: "", code: "CV"};
  ro._DB = {localName: "Dâmbovița", name: "", code: "DB"};
  ro._DJ = {localName: "Dolj", name: "", code: "DJ"};
  ro._GL = {localName: "Galați", name: "", code: "GL"};
  ro._GR = {localName: "Giurgiu", name: "", code: "GR"};
  ro._GJ = {localName: "Gorj", name: "", code: "GJ"};
  ro._HR = {localName: "Harghita", name: "", code: "HR"};
  ro._HD = {localName: "Hunedoara", name: "", code: "HD"};
  ro._IL = {localName: "Ialomița", name: "", code: "IL"};
  ro._IS = {localName: "Iași", name: "", code: "IS"};
  ro._IF = {localName: "Ilfov", name: "", code: "IF"};
  ro._MM = {localName: "Maramureș", name: "", code: "MM"};
  ro._MH = {localName: "Mehedinți", name: "", code: "MH"};
  ro._MS = {localName: "Mureș", name: "", code: "MS"};
  ro._NT = {localName: "Neamț", name: "", code: "NT"};
  ro._OT = {localName: "Olt", name: "", code: "OT"};
  ro._PH = {localName: "Prahova", name: "", code: "PH"};
  ro._SM = {localName: "Satu Mare", name: "", code: "SM"};
  ro._SJ = {localName: "Sălaj", name: "", code: "SJ"};
  ro._SB = {localName: "Sibiu", name: "", code: "SB"};
  ro._SV = {localName: "Suceava", name: "", code: "SV"};
  ro._TR = {localName: "Teleorman", name: "", code: "TR"};
  ro._TM = {localName: "Timiș", name: "", code: "TM"};
  ro._TL = {localName: "Tulcea", name: "", code: "TL"};
  ro._VS = {localName: "Vaslui", name: "", code: "VS"};
  ro._VL = {localName: "Vâlcea", name: "", code: "VL"};
  ro._VN = {localName: "Vrancea", name: "", code: "VN"};
  ro._B = {localName: "București", name: "", code: "B"};
  return ro;
}

function getBGSubdivisions() {
  var bg = {};
  bg._01 = {localName: "Blagoevgrad", name: "", code: "01"};
  bg._02 = {localName: "Burgas", name: "", code: "02"};
  bg._08 = {localName: "Dobrich", name: "", code: "08"};
  bg._07 = {localName: "Gabrovo", name: "", code: "07"};
  bg._26 = {localName: "Haskovo", name: "", code: "26"};
  bg._09 = {localName: "Kardzhali", name: "", code: "09"};
  bg._10 = {localName: "Kyustendil", name: "", code: "10"};
  bg._11 = {localName: "Lovech", name: "", code: "11"};
  bg._12 = {localName: "Montana", name: "", code: "12"};
  bg._13 = {localName: "Pazardzhik", name: "", code: "13"};
  bg._14 = {localName: "Pernik", name: "", code: "14"};
  bg._15 = {localName: "Pleven", name: "", code: "15"};
  bg._16 = {localName: "Plovdiv", name: "", code: "16"};
  bg._17 = {localName: "Razgrad", name: "", code: "17"};
  bg._18 = {localName: "Ruse", name: "", code: "18"};
  bg._27 = {localName: "Shumen", name: "", code: "27"};
  bg._19 = {localName: "Silistra", name: "", code: "19"};
  bg._20 = {localName: "Sliven", name: "", code: "20"};
  bg._21 = {localName: "Smolyan", name: "", code: "21"};
  bg._23 = {localName: "Sofia", name: "", code: "23"};
  bg._22 = {localName: "Sofia (stolitsa)", name: "", code: "22"};
  bg._24 = {localName: "Stara Zagora", name: "", code: "24"};
  bg._25 = {localName: "Targovishte", name: "", code: "25"};
  bg._03 = {localName: "Varna", name: "", code: "03"};
  bg._04 = {localName: "Veliko Tarnovo", name: "", code: "04"};
  bg._05 = {localName: "Vidin", name: "", code: "05"};
  bg._06 = {localName: "Vratsa", name: "", code: "06"};
  bg._28 = {localName: "Yambol", name: "", code: "28"};
  return bg;
}

function getMDSubdivisions() {
  var md = {};
  md._GA = {localName: "Găgăuzia, Unitate Teritorială Autonomă (UTAG)", name: "", code: "GA"};
  md._CU = {localName: "Chişinău", name: "", code: "CU"};
  md._BA = {localName: "Bălţi", name: "", code: "BA"};
  md._CA = {localName: "Cahul", name: "", code: "CA"};
  md._CH = {localName: "Chişinău", name: "", code: "CH"};
  md._ED = {localName: "Edineţ", name: "", code: "ED"};
  md._LA = {localName: "Lăpuşna", name: "", code: "LA"};
  md._OR = {localName: "Orhei", name: "", code: "OR"};
  md._SO = {localName: "Soroca", name: "", code: "SO"};
  md._TA = {localName: "Taraclia", name: "", code: "TA"};
  md._TI = {localName: "Tighina [Bender]", name: "", code: "TI"};
  md._UN = {localName: "Ungheni", name: "", code: "UN"};
  md._SN = {localName: "Stînga Nistrului, unitatea teritorială din", name: "", code: "SN"};
  return md;
}

function getATSubdivisions() {
  var at = {};
  at._1 = {localName: "Burgenland", name: "Burgenland", code: "1"};
  at._2 = {localName: "Kärnten", name: "Carinthia", code: "2"};
  at._3 = {localName: "Niederösterreich", name: "Lower Austria", code: "3"};
  at._4 = {localName: "Oberösterreich", name: "Upper Austria", code: "4"};
  at._5 = {localName: "Salzburg", name: "Salzburg", code: "5"};
  at._6 = {localName: "Steiermark", name: "Styria", code: "6"};
  at._7 = {localName: "Tirol", name: "Tyrol", code: "7"};
  at._8 = {localName: "Vorarlberg", name: "Vorarlberg", code: "8"};
  at._9 = {localName: "Wien", name: "Vienna", code: "9"};
  return at;
}

function getBESubdivisions() {
  var be = {};
  be._BRU = {localName: "Région de Bruxelles-Capitale", name: "Brussels-Capital Region", code: "BRU"};
  be._VLG = {localName: "Région Flamande", name: "Flemish Region", code: "VLG"};
  be._WAL = {localName: "Région Wallonne", name: "Walloon Region", code: "WAL"};
  return be;
}

function getCHSubdivisions() {
  var ch = {};
  ch._AG = {localName: "Aargau", name: "", code: "AG"};
  ch._AR = {localName: "Appenzell Ausserrhoden", name: "", code: "AR"};
  ch._AI = {localName: "Appenzell Innerrhoden", name: "", code: "AI"};
  ch._BL = {localName: "Basel-Landschaft", name: "", code: "BL"};
  ch._BS = {localName: "Basel-Stadt", name: "", code: "BS"};
  ch._BE = {localName: "Bern", name: "", code: "BE"};
  ch._FR = {localName: "Freiburg", name: "", code: "FR"};
  ch._GE = {localName: "Genève", name: "", code: "GE"};
  ch._GL = {localName: "Glarus", name: "", code: "GL"};
  ch._GR = {localName: "Graubünden", name: "", code: "GR"};
  ch._JU = {localName: "Jura", name: "", code: "JU"};
  ch._LU = {localName: "Luzern", name: "", code: "LU"};
  ch._NE = {localName: "Neuchâtel", name: "", code: "NE"};
  ch._NW = {localName: "Nidwalden", name: "", code: "NW"};
  ch._OW = {localName: "Obwalden", name: "", code: "OW"};
  ch._SG = {localName: "Sankt Gallen", name: "", code: "SG"};
  ch._SH = {localName: "Schaffhausen", name: "", code: "SH"};
  ch._SZ = {localName: "Schwyz", name: "", code: "SZ"};
  ch._SO = {localName: "Solothurn", name: "", code: "SO"};
  ch._TG = {localName: "Thurgau", name: "", code: "TG"};
  ch._TI = {localName: "Ticino", name: "", code: "TI"};
  ch._UR = {localName: "Uri", name: "", code: "UR"};
  ch._VS = {localName: "Wallis", name: "", code: "VS"};
  ch._VD = {localName: "Vaud", name: "", code: "VD"};
  ch._ZG = {localName: "Zug", name: "", code: "ZG"};
  ch._ZH = {localName: "Zürich", name: "", code: "ZH"};
  return ch;
}

function getDESubdivisions() {
  var de = {};
  de._BW = {localName: "Baden-Württemberg", name: "Baden-Württemberg", code: "BW"};
  de._BY = {localName: "Bayern", name: "Bavaria", code: "BY"};
  de._BE = {localName: "Berlin", name: "Berlin", code: "BE"};
  de._BB = {localName: "Brandenburg", name: "Brandenburg", code: "BB"};
  de._HB = {localName: "Bremen", name: "Bremen", code: "HB"};
  de._HH = {localName: "Hamburg", name: "Hamburg", code: "HH"};
  de._HE = {localName: "Hessen", name: "Hesse", code: "HE"};
  de._MV = {localName: "Mecklenburg-Vorpommern", name: "Mecklenburg-Western Pomerania", code: "MV"};
  de._NI = {localName: "Niedersachsen", name: "Lower Saxony", code: "NI"};
  de._NW = {localName: "Nordrhein-Westfalen", name: "North Rhine-Westphalia", code: "NW"};
  de._RP = {localName: "Rheinland-Pfalz", name: "Rhineland-Palatinate", code: "RP"};
  de._SL = {localName: "Saarland", name: "Saarland", code: "SL"};
  de._SN = {localName: "Sachsen", name: "Saxony", code: "SN"};
  de._ST = {localName: "Sachsen-Anhalt", name: "Saxony-Anhalt", code: "ST"};
  de._SH = {localName: "Schleswig-Holstein", name: "Schleswig-Holstein", code: "SH"};
  de._TH = {localName: "Thüringen", name: "Thuringia", code: "TH"};
  return de;
}

function getFRSubdivisions() {
  var fr = {};
  fr._A = {localName: "Alsace", name: "Alsace", code: "A"};
  fr._B = {localName: "Aquitaine", name: "Aquitaine", code: "B"};
  fr._C = {localName: "Auvergne", name: "Auvergne", code: "C"};
  fr._P = {localName: "Basse-Normandie", name: "Lower Normandy", code: "P"};
  fr._D = {localName: "Bourgogne", name: "Burgundy", code: "D"};
  fr._E = {localName: "Bretagne", name: "Brittany", code: "E"};
  fr._F = {localName: "Centre", name: "Centre-Val de Loire", code: "F"};
  fr._G = {localName: "Champagne-Ardenne", name: "Champagne-Ardenne", code: "G"};
  fr._H = {localName: "Corse", name: "Corsica", code: "H"};
  fr._I = {localName: "Franche-Comté", name: "Franche-Comté", code: "I"};
  fr._Q = {localName: "Haute-Normandie", name: "Upper Normandy", code: "Q"};
  fr._J = {localName: "Île-de-France", name: "Île-de-France", code: "J"};
  fr._K = {localName: "Languedoc-Roussillon", name: "Languedoc-Roussillon", code: "K"};
  fr._L = {localName: "Limousin", name: "Limousin", code: "L"};
  fr._M = {localName: "Lorraine", name: "Lorraine", code: "M"};
  fr._N = {localName: "Midi-Pyrénées", name: "Midi-Pyrénées", code: "N"};
  fr._O = {localName: "Nord-Pas-de-Calais", name: "Nord-Pas-de-Calais", code: "O"};
  fr._R = {localName: "Pays de la Loire", name: "Pays de la Loire", code: "R"};
  fr._S = {localName: "Picardie", name: "Picardy", code: "S"};
  fr._T = {localName: "Poitou-Charentes", name: "Poitou-Charentes", code: "T"};
  fr._U = {localName: "Provence-Alpes-Côte d'Azur", name: "Provence-Alpes-Côte d'Azur", code: "U"};
  fr._V = {localName: "Rhône-Alpes", name: "Rhône-Alpes", code: "V"};
  return fr;
}

function getLISubdivisions() {
  var li = {};
  return li;
}

function getMCSubdivisions() {
  var mc = {};
  return mc;
}

function getMTSubdivisions() {
  var mt = {};
  return mt;
}

function getNLSubdivisions() {
  var nl = {};
  nl._DR = {localName: "Drenthe", name: "", code: "DR"};
  nl._FL = {localName: "Flevoland", name: "", code: "FL"};
  nl._FR = {localName: "Fryslân", name: "", code: "FR"};
  nl._GE = {localName: "Gelderland", name: "", code: "GE"};
  nl._GR = {localName: "Groningen", name: "", code: "GR"};
  nl._LI = {localName: "Limburg", name: "", code: "LI"};
  nl._NB = {localName: "Noord-Brabant", name: "", code: "NB"};
  nl._NH = {localName: "Noord-Holland", name: "", code: "NH"};
  nl._OV = {localName: "Overijssel", name: "", code: "OV"};
  nl._UT = {localName: "Utrecht", name: "", code: "UT"};
  nl._ZE = {localName: "Zeeland", name: "", code: "ZE"};
  nl._ZH = {localName: "Zuid-Holland", name: "", code: "ZH"};
  return nl;
}

function getLUSubdivisions() {
  var lu = {};
  lu._D = {localName: "Diekirch", name: "", code: "D"};
  lu._G = {localName: "Grevenmacher", name: "", code: "G"};
  lu._L = {localName: "Luxembourg", name: "", code: "L"};
  return lu;
}

function getISOCode(cstr, list, countries) {
  var iso = "",
  found = false;
  if (countries.indexOf(cstr) < 0 && !Empty(cstr)) {
    found = false;
    for (var k = 0; k < countries.length && !found; k++) {
      if (
        list[countries[k]].localName.toLowerCase() == cstr.toLowerCase() ||
        list[countries[k]].name.toLowerCase() == cstr.toLowerCase() ||
        list[countries[k]].code.toLowerCase() == cstr.toLowerCase()
      ) {
        iso = list[countries[k]].code;
        found = true;
      }
    }
  }
  else
    iso = cstr;
  return iso;
}

function checkISOInList(isoObject, list) {
  var lowList = list.map(function (string) { return (string + "").toLowerCase(); });
  var cfr = isoObject.localName.toLowerCase();
  if (lowList.indexOf(cfr) >= 0)
    return true;

  cfr = isoObject.name.toLowerCase();
  if (lowList.indexOf(cfr) >= 0)
    return true;

  cfr = isoObject.code.toLowerCase();
  if (lowList.indexOf(cfr) >= 0)
    return true;

  return false;
}
