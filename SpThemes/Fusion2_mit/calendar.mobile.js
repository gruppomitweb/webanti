//* ***********************
// Configuration variables:
//* ***********************

var gotoString,
  todayString,
  weekString,
  selectDateMessage,
  monthName,
  dayName,
  calendarObj,
  monthSelected,
  yearSelected,
  dateSelected,
  omonthSelected,
  oyearSelected,
  odateSelected,
  monthConstructed,
  yearConstructed,
  ctlToPlaceValue,
  ctlNow,
  dateFormat,
  nStartingYear,
  imgDir = '../' + (typeof ZtVWeb != 'undefined' ? ZtVWeb.theme : window.m_cThemePath ? m_cThemePath : 'SpTheme_2') + '/formPage/',
  calendarWidth = SPTheme.mobileCalendarWidth || 250,
  imgsrc = [
    SPTheme.mobileCalendarDrop1 || imgDir + 'drop1.gif',
    SPTheme.mobileCalendarLeft1 || imgDir + 'left1.gif',
    SPTheme.mobileCalendarRight1 || imgDir + 'right1.gif',
    SPTheme.mobileCalendarClose || imgDir + 'close.gif',
    SPTheme.mobileCalendarDivider || imgDir + 'divider.gif'
  ],
  calendarReady = false,
  startAt = 1, // 0 - sunday ; 1 - monday
  showWeekNumber = 1, // 0 - don't show; 1 - show
  showToday = 1, // 0 - don't show; 1 - show
  bPageLoaded = false,
  today = new Date(),
  dateNow = today.getDate(),
  monthNow = today.getMonth(),
  yearNow = today.getFullYear ? today.getFullYear() : today.getYear() > 1000 ? today.getYear() : today.getYear() + 1900,
  img = [],
  bShow = false,
  styleAnchor = 'text-decoration:none;vertical-align:baseline;',
  styleLightBorder = 'border-style:solid;border-width:1px;border-color:#a0a0a0;', // Colore del riquadro del giorni selezionato
  calendarFixedPos = false;

function PrepareJsCalendar(documentOpened, fixed) {
  calendarFixedPos = fixed || false;
  if (documentOpened !== true && documentOpened !== false) {
    documentOpened = document.readyState === 'loading';
  }
  // Prepara il calendario per visualizzazrlo appena si chiama il metodo ShowPopUpCalendar
  if (typeof monthName == 'undefined') {
    // Non e' ancora preparato
    InitCalendarVars();
    BuildCalendar(documentOpened);
  }
}

function InitCalendarVars() {
  monthName = [
    Translate('MSG_CALENDAR_JANUARY'),
    Translate('MSG_CALENDAR_FEBRUARY'),
    Translate('MSG_CALENDAR_MARCH'),
    Translate('MSG_CALENDAR_APRIL'),
    Translate('MSG_CALENDAR_MAY'),
    Translate('MSG_CALENDAR_JUNE'),
    Translate('MSG_CALENDAR_JULY'),
    Translate('MSG_CALENDAR_AUGUST'),
    Translate('MSG_CALENDAR_SEPTEMBER'),
    Translate('MSG_CALENDAR_OCTOBER'),
    Translate('MSG_CALENDAR_NOVEMBER'),
    Translate('MSG_CALENDAR_DECEMBER')
  ];

  dayName = [
    Translate('MSG_CALENDAR_MON'),
    Translate('MSG_CALENDAR_TUE'),
    Translate('MSG_CALENDAR_WED'),
    Translate('MSG_CALENDAR_THU'),
    Translate('MSG_CALENDAR_FRI'),
    Translate('MSG_CALENDAR_SAT')
  ];
  if (startAt == 0) {
    dayName.splice(0, 0, Translate('MSG_CALENDAR_SUN'));
  } else {
    dayName.push(Translate('MSG_CALENDAR_SUN'));
  }

  gotoString = Translate('MSG_CALENDAR_GOTO_CURRENTMONTH');
  todayString = Translate('MSG_CALENDAR_TODAY_IS');
  weekString = Translate('MSG_CALENDAR_WEEK');
  var lang = typeof m_cLanguage != 'undefined' ? m_cLanguage : null;
  lang = lang == null && typeof ZtVWeb != 'undefined' && typeof ZtVWeb.Language != 'undefined' ? ZtVWeb.Language : lang;
  if (typeof lang == 'undefined') {
    lang = 'default';
  }
  if (gotoString === 'MSG_CALENDAR_GOTO_CURRENTMONTH') {
    // traduzioni non disponibili nel file
    switch (lang) {
    case 'ita':
    case 'default':
      monthName = new Array('Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre');
      if (startAt == 0) {
        dayName = new Array('Dom', 'Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab');
      } else {
        dayName = new Array('Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab', 'Dom');
      }

      gotoString = 'Vai al mese corrente';
      todayString = 'Oggi \u00e8';
      weekString = 'Sett';
      break;
    case 'eng':
      monthName = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
      if (startAt == 0) {
        dayName = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
      } else {
        dayName = new Array('Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun');
      }

      gotoString = 'Go to current month';
      todayString = 'Today is';
      weekString = 'Wk';
      break;
    case 'spa':
      monthName = new Array('Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre');
      if (startAt == 0) {
        dayName = new Array('Dom', 'Lun', 'Mar', 'Mi\u00e9', 'Jue', 'Vie', 'S\u00e1b');
      } else {
        dayName = new Array('Lun', 'Mar', 'Mi\u00e8', 'Jue', 'Vie', 'S\u00e1b', 'Dom');
      }

      gotoString = 'Ir al mes actual';
      todayString = 'Hoy es';
      weekString = 'Sem';
      break;
    case 'deu':
      monthName = new Array('Januar', 'Februar', 'M\u00e4rz', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember');
      if (startAt == 0) {
        dayName = new Array('Son', 'Mon', 'Die', 'Mit', 'Don', 'Fre', 'Sam');
      } else {
        dayName = new Array('Mon', 'Die', 'Mit', 'Don', 'Fre', 'Sam', 'Son');
      }

      gotoString = 'Zum aktuellen Monat wechseln';
      todayString = 'Heute';
      weekString = 'W';
      break;
    case 'fra':
      monthName = new Array('Janvier', 'F\u00e9vrier', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Ao\u00fbt', 'Septembre', 'Octobre', 'Novembre', 'D\u00e9cembre');
      if (startAt == 0) {
        dayName = new Array('Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam');
      } else {
        dayName = new Array('Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam', 'Dim');
      }

      gotoString = 'Mois en cours';
      todayString = 'Nous sommes le';
      weekString = 'Sem.';
      break;
    }
  }
}

function BuildCalendar(documentOpened) {
  documentOpened = documentOpened || window.document.readyState && window.document.readyState != 'complete' && window.document.readyState != 'interactive';
  var document = documentOpened ? window.document : [];
  if (!document.write) {
    document.write = function(s) {
      this.push(s);
    };
  }
  document.write("<div class='SPCalendar_mobile' id='Calendar' style='display:none;'>");
  document.write("<div class='SPCalendarHeader'>");
  document.write("<ol class='SPCalendarHeaderAll' id='calendar_caption'></ol>");
  document.write('</div>');
  document.write("<div class='SPCalendarContent' id='content'></div>");
  if (showToday == 1) {
    document.write("<div class='SPCalendarFooter' id='lblToday'></div>");
  }
  document.write('</div>');
  // document.write("<div id='selectMonth' class='SPCalendarMonth' style='position:absolute;left:0;right:auto;z-index:+999;display:none;'></div>")
  // document.write("<div id='selectYear' class='SPCalendarYear' style='position:absolute;left:0;right:auto;z-index:+999;display:none;'></div>")
  if (!documentOpened) {
    var d = window.document.createElement('div');
    d.innerHTML = document.join('');
    window.document.body.appendChild(d);
  }
}

function InitCalendar() {
  for (var i = 0; i < imgsrc.length; i++) {
    (img[i] = new Image()).src = imgsrc[i];
  }

  calendarObj = LibJavascript.DOM.Ctrl('Calendar').style;
  monthConstructed = false;
  yearConstructed = false;
  hideCalendar();

  if (showToday == 1) {
    LibJavascript.DOM.Ctrl('lblToday').innerHTML =
      todayString +
      " <a class='SPCalendarFooter' title='" +
      gotoString +
      "' style='" +
      styleAnchor +
      "' href='javascript:monthSelected=monthNow;yearSelected=yearNow;constructCalendar();'>" +
      dayName[today.getDay() - startAt == -1 ? 6 : today.getDay() - startAt] +
      ', ' +
      dateNow +
      ' ' +
      monthName[monthNow].substring(0, 3) +
      ' ' +
      yearNow +
      '</a>';
  }
  var sHTML1;
  sHTML1 = "<li id='spanLeft'>";
  sHTML1 += "<a href='javascript:decMonth();'><img id='changeLeft' src='" + img[1].src + "'></a>";
  sHTML1 += '</li>';

  sHTML1 += "<li id='spanRight'>";
  sHTML1 += "<a href='javascript:incMonth();'><img id='changeRight' src='" + img[2].src + "'></a>";
  sHTML1 += '</li>';

  sHTML1 += "<li id='spanMonth'>";
  sHTML1 += "<a href='javascript:popUpMonth();'><span id='currentMonth'></span><img src='" + img[0].src + "'></a>";
  sHTML1 += "<div id='selectMonth' class='SPCalendarMonth' style='position:absolute;left:0;right:auto;z-index:+999;display:none;'></div>";
  sHTML1 += '</li>';

  sHTML1 += "<li id='spanYear'>";
  sHTML1 += "<a href='javascript:popUpYear();'><span id='currentYear'></span><img id='changeYear' src='" + img[0].src + "'><a>";
  sHTML1 += "<div id='selectYear' class='SPCalendarYear' style='position:absolute;left:0;right:auto;z-index:+999;display:none;'></div>";
  sHTML1 += '</li>';

  sHTML1 += "<li><a href='javascript:hideCalendar()' style='float:right;'>";
  sHTML1 += "<img src='" + imgsrc[3] + "' alt='Close the Calendar'>";
  sHTML1 += '</a></li>';

  LibJavascript.DOM.Ctrl('calendar_caption').innerHTML = sHTML1;
  bPageLoaded = true;
}

function hideCalendar() {
  var calendarParent;
  if (typeof calendarObj != 'undefined') {
    calendarParent = document.getElementById('Calendar').parentNode;
    if (calendarParent.id.match(/_calendar_dock/)) {
      calendarParent.style.display = '';
    }
    calendarObj.display = 'none';
    if (monthConstructed) {
      LibJavascript.DOM.Ctrl('selectMonth').style.display = 'none';
    }
    if (yearConstructed) {
      LibJavascript.DOM.Ctrl('selectYear').style.display = 'none';
    }
  }
}

function padZero(num) {
  return num < 10 ? '0' + num : num;
}

function constructDate(d, m, y) {
  var sTmp = dateFormat;
  sTmp = sTmp.replace('DD', '<e>');
  sTmp = sTmp.replace('D', '<d>');
  sTmp = sTmp.replace('<e>', padZero(d));
  sTmp = sTmp.replace('<d>', d);
  sTmp = sTmp.replace('mmm', '<o>');
  sTmp = sTmp.replace('MM', '<n>');
  sTmp = sTmp.replace('m', '<m>');
  sTmp = sTmp.replace('<m>', m + 1);
  sTmp = sTmp.replace('<n>', padZero(m + 1));
  sTmp = sTmp.replace('<o>', monthName[m]);
  return sTmp.replace('YYYY', y);
}

function closeCalendar(notClose) {
  if (!notClose) {
    hideCalendar();
  }
  if (typeof ZtVWeb != 'undefined' && ctlToPlaceValue instanceof ZtVWeb.StdControl)
  // e' un Ctrl di PS
  {
    ctlToPlaceValue.Set(new Date(yearSelected, monthSelected, dateSelected));
  } else {
    ctlToPlaceValue.value = constructDate(dateSelected, monthSelected, yearSelected);
    try {
      if (typeof window[ctlToPlaceValue.id + '_Valid'] == 'function') {
        // i campi aggiunti hanno un id uguale al nome e di lunghezza variabile
        window[ctlToPlaceValue.id + '_Valid']();
      } else if (typeof window[Left(ctlToPlaceValue.id, 10) + '_Valid'] == 'function') {
        // Nello zoom, la procedura _Valid non e' presente
        window[Left(ctlToPlaceValue.id, 10) + '_Valid']();
      }
      SetControlFocus(ctlToPlaceValue.id);
    } catch (e) {}
  }
}

/** * Month Pulldown ***/

function incMonth() {
  monthSelected++;
  if (monthSelected > 11) {
    monthSelected = 0;
    yearSelected++;
  }
  constructCalendar();
}

function decMonth() {
  monthSelected--;
  if (monthSelected < 0) {
    monthSelected = 11;
    yearSelected--;
  }
  constructCalendar();
}

function constructMonth() {
  popDownYear();
  if (!monthConstructed) {
    var sHTML = '';
    for (var i = 0; i < 12; i++) {
      sHTML +=
        "<li id='m" + i + "' style='cursor:pointer;" + (i == monthSelected ? 'font-weight:bold;' : '') + "' onclick='MonthChanged(" + i + ",event)'>" + monthName[i] + '</li>';
    }
    LibJavascript.DOM.Ctrl('selectMonth').innerHTML = "<ol class='SPCalendarHeader SPCalendarComboYearsMonths'>" + sHTML + '</ol>';
    monthConstructed = true;
  }
}

function stopEvent(evt) {
  evt || window.event;
  if (evt.stopPropagation) {
    evt.stopPropagation();
    evt.preventDefault();
  } else if (typeof evt.cancelBubble != 'undefined') {
    evt.cancelBubble = true;
    evt.returnValue = false;
  }
  return false;
}

function MonthChanged(i, evt) {
  monthConstructed = false;
  monthSelected = i;
  constructCalendar();
  popDownMonth();
  stopEvent(evt);
}

function popUpMonth() {
  constructMonth();
  LibJavascript.DOM.Ctrl('selectMonth').style.display = '';
}

function popDownMonth() {
  LibJavascript.DOM.Ctrl('selectMonth').style.display = 'none';
}

/** * Year Pulldown ***/
function incYear() {
  for (i = 0; i < 7; i++) {
    newYear = i + nStartingYear + 1;
    if (newYear == yearSelected) {
      txtYear = '&nbsp;<B>' + newYear + '</B>&nbsp;';
    } else {
      txtYear = '&nbsp;' + newYear + '&nbsp;';
    }
    LibJavascript.DOM.Ctrl('y' + i).innerHTML = txtYear;
  }
  nStartingYear++;
  bShow = true;
}

function decYear() {
  for (i = 0; i < 7; i++) {
    newYear = i + nStartingYear - 1;
    if (newYear == yearSelected) {
      txtYear = '&nbsp;<B>' + newYear + '</B>&nbsp;';
    } else {
      txtYear = '&nbsp;' + newYear + '&nbsp;';
    }
    LibJavascript.DOM.Ctrl('y' + i).innerHTML = txtYear;
  }
  nStartingYear--;
  bShow = true;
}

function selectYear(nYear) {
  yearSelected = parseInt(nYear + nStartingYear);
  yearConstructed = false;
  constructCalendar();
  popDownYear();
}

function constructYear() {
  popDownMonth();
  if (!yearConstructed) {
    var sHTML;
    sHTML = '<li>-</li>';
    nStartingYear = yearSelected - 3;
    for (var j = 0, i = yearSelected - 3; i <= yearSelected + 3; i++) {
      sHTML += "<li id='y" + j + "' style='cursor:pointer;" + (i == yearSelected ? 'font-weight:bold;' : '') + "' onclick='selectYear(" + j + ");stopEvent(event);'>" + i + '</li>';
      j++;
    }
    sHTML += '<li>+</li>';
    LibJavascript.DOM.Ctrl('selectYear').innerHTML = "<ol class='SPCalendarHeader SPCalendarComboYearsMonths'>" + sHTML + '</ol>';
    yearConstructed = true;
  }
}

function popDownYear() {
  LibJavascript.DOM.Ctrl('selectYear').style.display = 'none';
}

function popUpYear() {
  constructYear();
  LibJavascript.DOM.Ctrl('selectYear').style.display = '';
}

/** * calendar ***/
function WeekNbr(n) {
  var year = n.getFullYear(),
    month = n.getMonth() + 1,
    day = n.getDate() + (startAt == 0 ? 1 : 0);
  var a = Math.floor((14 - month) / 12),
    y = year + 4800 - a,
    m = month + 12 * a - 3,
    b = Math.floor(y / 4) - Math.floor(y / 100) + Math.floor(y / 400),
    J = day + Math.floor((153 * m + 2) / 5) + 365 * y + b - 32045,
    d4 = (J + 31741 - J % 7) % 146097 % 36524 % 1461,
    L = Math.floor(d4 / 1460);
  var d1 = (d4 - L) % 365 + L,
    week = Math.floor(d1 / 7) + 1;
  return week;
}

function constructCalendar() {
  var startDate = new Date(yearSelected, monthSelected, 1),
    href,
    sClass = '',
    dayPointer,
    numDaysInMonth;

  if (monthSelected == 1) {
    var endDate = new Date(yearSelected, monthSelected + 1, 1);
    endDate = new Date(endDate - 24 * 60 * 60 * 1000);
    numDaysInMonth = endDate.getDate();
  } else {
    numDaysInMonth = [31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][monthSelected];
  }
  dayPointer = startDate.getDay() - startAt;

  if (dayPointer < 0) {
    dayPointer = 6;
  }
  var sHTML = "<table class='SPCalendarBodyTable' border='0'><tr>";

  if (showWeekNumber == 1) {
    sHTML += "<td align='right'><div class='SPCalendarWeeks' style='font-weight:bold;'>" + weekString + '</div></td>';
    sHTML += "<td rowspan='7' bgcolor='#d0d0d0' class='SPCalendarWeekDivider' style='padding:0px'><img src='" + img[4].src + "'></td>";
  }

  for (var i = 0; i < 7; i++) {
    if (i == 6 && startAt == 1 || i == 0 && startAt == 0) {
      sHTML += "<td align='right' class='SPCalendarSunday' style='font-weight:bold;'>" + dayName[i] + '</td>';
    } else {
      sHTML += "<td align='right' style='font-weight:bold;'>" + dayName[i] + '</td>';
    }
  }
  sHTML += '</tr><tr>';

  if (showWeekNumber == 1) {
    sHTML += "<td align='right'><div class='SPCalendarWeeks'>" + WeekNbr(startDate) + '</div></td>';
  }
  for (var i = 1; i <= dayPointer; i++) {
    sHTML += '<td>&nbsp;</td>';
  }
  for (var datePointer = 1, sClass; datePointer <= numDaysInMonth; datePointer++) {
    dayPointer++;
    href = 'javascript:dateSelected=' + datePointer + ';closeCalendar(' + (calendarFixedPos ? 'true' : '') + ');';
    sHTML += '<td align=right>';
    sClass = datePointer == odateSelected && monthSelected == omonthSelected && yearSelected == oyearSelected ? 'SPCalendarCurrentDay' : '';
    if (datePointer == dateNow && monthSelected == monthNow && yearSelected == yearNow) {
      sHTML +=
        "<a class='" + sClass + " SPCalendarToday' style='font-weight:bold;" + styleAnchor + "' href='" + href + "'><span class='SPCalendarToday'>" + datePointer + '</span></a>';
    } else if (dayPointer % 7 == startAt * -1 + 1) {
      sHTML += "<a class='" + sClass + "' style='" + styleAnchor + "' href='" + href + "'><span class='SPCalendarSunday'>" + datePointer + '</span></a>';
    } else {
      sHTML += "<a class='SPCalendarBody " + sClass + "' style='" + styleAnchor + "' href='" + href + "'>" + datePointer + '</a>';
    }

    if ((dayPointer + startAt) % 7 == startAt) {
      sHTML += '</tr><tr>';
      if (showWeekNumber == 1 && datePointer < numDaysInMonth) {
        sHTML += "<td align='right'><div class='SPCalendarWeeks'>" + WeekNbr(new Date(yearSelected, monthSelected, datePointer + 1)) + '</div></td>';
      }
    }
  }
  LibJavascript.DOM.Ctrl('content').innerHTML = sHTML;
  LibJavascript.DOM.Ctrl('currentMonth').innerHTML = monthName[monthSelected];
  LibJavascript.DOM.Ctrl('currentYear').innerHTML = yearSelected;
}

function ShowPopUpCalendar(ctrl, getPicture, sayPicture) {
  var calendar,
    calendarParent,
    calendarDock,
    origCtrl = ctrl;
  if (!calendarReady) {
    InitCalendar();
    calendarReady = true;
  }
  if (bPageLoaded) {
    calendarDock = LibJavascript.DOM.Ctrl(ctrl.id + '_calendar_dock');
    calendar = LibJavascript.DOM.Ctrl('Calendar');
    calendarParent = calendar.parentNode;
    if ((calendarObj.display = 'none')) {
      ctlToPlaceValue = ctrl;
      dateFormat = sayPicture;
      if (typeof ZtVWeb != 'undefined' && ctlToPlaceValue instanceof ZtVWeb.StdControl) {
        // e' un Ctrl di PS
        currentDate = ZtVWeb.applyPicture(ctrl.Value(), ctrl.type, 0, ctrl.picture);
        ctrl = ctlToPlaceValue.Ctrl_input;
      } else {
        currentDate = ctrl.value;
      }
      if (currentDate == '') {
        dateSelected = dateNow;
        monthSelected = monthNow;
        yearSelected = yearNow;
      } else {
        dateSelected = Val(Substr(currentDate, At('DD', getPicture), 2));
        monthSelected = Val(Substr(currentDate, At('MM', getPicture), 2)) - 1;
        yearSelected = Val(Substr(currentDate, At('YYYY', getPicture), 4));
        // Se la data inserita e' sbagliata, seleziono quella attuale
        if (!CheckDate(dateSelected, monthSelected, yearSelected)) {
          dateSelected = dateNow;
          monthSelected = monthNow;
          yearSelected = yearNow;
        }
      }
      odateSelected = dateSelected;
      omonthSelected = monthSelected;
      oyearSelected = yearSelected;

      /* Se non siamo in una gestione non abbiamo il calendarDock
       *quindi il calendario rimane nel body e viene solo riposizionato
      */
      if (calendarDock) {
        if (calendarParent != calendarDock) {
          calendarDock.style.display = 'block';
          if (calendarParent.id.match(/_calendar_dock/)) {
            calendarParent.style.display = '';
          }
        }
        LibJavascript.DOM.addNode(calendarDock, calendar);
        calendarObj.float = 'left';
      } else {
        calendarObj.position = 'absolute';
        var aTag = ctrl;
        var a = LibJavascript.DOM.getAbsolutePos(aTag);
        calendarObj.left = a.x + 'px';
        calendarObj.top = a.y + ctrl.offsetHeight + 'px';
      }
      constructCalendar(1, monthSelected, yearSelected);
      calendarObj.display = '';
      if (document.body.offsetLeft + document.body.offsetWidth < parseInt(calendarObj.left) + LibJavascript.DOM.Ctrl('Calendar').offsetWidth) {
        if (parseInt(calendarObj.left = parseInt(calendarObj.left) - LibJavascript.DOM.Ctrl('Calendar').offsetWidth + ctrl.offsetWidth + 'px') < 0) {
          calendarObj.left = '0px';
        }
      }
      if (document.body.offsetTop + document.body.offsetHeight < parseInt(calendarObj.top) + LibJavascript.DOM.Ctrl('Calendar').offsetHeight) {
        if (parseInt(calendarObj.top = parseInt(calendarObj.top) - LibJavascript.DOM.Ctrl('Calendar').offsetHeight - ctrl.offsetHeight + 'px') < 0) {
          calendarObj.top = '0px';
        }
      }

      bShow = true;
    } else {
      hideCalendar();
      if (ctlNow != origCtrl) {
        ShowPopUpCalendar(origCtrl, getPicture, sayPicture);
      }
    }
    ctlNow = origCtrl;
  }
}
function PrepareToDoNotHide() {}
function PrepareToHide() {}
function dragCalendar(event, obj, dragger) {}

PrepareJsCalendar();
