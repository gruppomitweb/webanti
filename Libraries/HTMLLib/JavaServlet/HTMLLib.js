(function() {//MakeHTMLLib
if (typeof(MooTools) == 'undefined') {
  if (typeof(LibJavascript) != 'undefined') {
    LibJavascript.RequireLibrary((typeof(SPWebRootURL) != 'undefined' ? SPWebRootURL + '/' : '../') + 'visualweb/mootools-core.js', true);
  } else { 
    document.write('<' + "script src='" + (typeof(SPWebRootURL) != 'undefined' ? SPWebRootURL + '/' : '../') + "visualweb/mootools-core.js'></" + 'script>');
  }
}
if (typeof(LibJavascript) != 'undefined') {
	LibJavascript.RequireLibrary((typeof(SPWebRootURL) != 'undefined' ? SPWebRootURL + '/' : '../') + 'jsp/HTMLLib.jsp', true);
} else {
	document.write('<' + "script src='" + (typeof(SPWebRootURL) != 'undefined' ? SPWebRootURL + '/' : '../') + "jsp/HTMLLib.jsp'></" + 'script>');
}


//---Start function: changeBg
function htmllib_changeBg(oCtrl) {
  var arr = new Array();
  var min = 0;
  var max = 3;
  var lastRandom = -1;
  //var JQ = jQuery.noConflict();
  arr[0] = "../images/login/1.jpg";
  arr[1] = "../images/login/2.jpg";
  arr[2] = "../images/login/3.jpg";
  arr[3] = "../images/login/4.jpg";
  arr[4] = "../images/login/5.jpg";
  arr[5] = "../images/login/6.jpg";
  arr[6] = "../images/login/7.jpg";
  arr[7] = "../images/login/8.jpg";
  arr[8] = "../images/login/9.jpg";
  arr[9] = "../images/login/10.jpg";
  arr[10] = "../images/login/11.jpg";
  arr[11] = "../images/login/12.jpg";
  arr[12] = "../images/login/13.jpg";
  arr[13] = "../images/login/14.jpg";
  arr[14] = "../images/login/15.jpg";
  arr[15] = "../images/login/16.jpg";
  arr[16] = "../images/login/17.jpg";
  arr[17] = "../images/login/18.jpg";
  arr[18] = "../images/login/19.jpg";
  // Funzione che restituisce un nuovo background random
  var nextBg = function randomBg(){    
    var randomNumber = 0;
    randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
    if (lastRandom > -1) {
      if (randomNumber == lastRandom) {
        if (randomNumber > 0){
          randomNumber--;
        }
        else{
          randomNumber = 1;
        }
      }
    }
    lastRandom = randomNumber;
    $(oCtrl).css({ 'background-image': 'url("' + arr[lastRandom] + '")','transition': 'all 1.54s ease-in-out','background-size':'cover'});
  }
  nextBg();
  setInterval(function(){nextBg();}, 15000)
}
//---End function

//---Start function: decodeDate
function htmllib_decodeDate(when) {
  var messaggio = '';
  var d2 = new Date(); //Oggi
  var d1 = new Date(when);
  var quando = "";
  diff = d2- d1;
   // Quando 
  var sign = (diff < 0) ? -1 : 1, milliseconds, seconds, minutes, hours, days;
    diff /= sign; // or diff=Math.abs(diff);
    diff = (diff - (milliseconds = diff % 1000)) / 1000;
    diff = (diff - (seconds = diff % 60)) / 60;
    diff = (diff - (minutes = diff % 60)) / 60;
    days = (diff - (hours = diff % 24)) / 24;
    if (days > 25) {
      mm =  Math.round(days / 30);
    } else {
      mm = 0;
    }
    if (mm > 6) {
      quando = FormatDate(d1, "DD/MM/YYYY");
    }
  if (mm == 1 && quando == "") {
    quando = FormatMsg("un mese fa");
  }
  if (mm >= 1 && quando == "") {
    quando = FormatMsg("%1 mesi fa", mm);
  }
  if (days == 1 && quando == "") {
    quando = FormatMsg("un giorno fa");
  }
  if (days >= 1 && quando == "") {
    quando = FormatMsg("%1 giorni fa", days);
  }
  if (hours == 1 && quando == "") {
    quando = FormatMsg("un'ora fa");
  }
  if (hours > 0 && quando == "") {
    quando = FormatMsg("%1 ore fa", hours);
  }
  if (minutes == 1 && quando == "") {
    quando = FormatMsg("un minuto fa");
  }
  if (minutes > 0 && quando == "") {
    quando = FormatMsg("%1 minuti fa", minutes);
  }
  if (minutes == 0 && quando == "") {
    quando = FormatMsg("adesso");
  }
  return quando;
}
//---End function

//---Start function: getControlIdByName
function htmllib_getControlIdByName(pName) {
  var res = document.getElementsByName(pName)[0].id;
  return res;
}
//---End function

//---Start function: getPortletDecoratorId
function htmllib_getPortletDecoratorId() {
  var res = "";
  var portlets=ZtVWeb.getPortletsById();
  var portletId=ZtVWeb.getPortletId();
  for (var i=portletId.length-1;i>=0;i--){	
    if (portlets[portletId[i]] && typeof(portlet_list)!='undefined' && portlets[portletId[i]].portletname==portlet_list[portlet_list.length-1] && portlets[portletId[i]].SetGadgetActions){
      res = portletId[i];
      break;
    }
  }
  return res;
}
//---End function

//---Start function: getScrollTop
function htmllib_getScrollTop() {
  if(typeof parent.pageYOffset!= 'undefined'){
    //most browsers
    return parent.pageYOffset;
  } else {
    var B= parent.top.document.body; //IE 'quirks'
    var D= parent.top.document.documentElement; //IE with doctype
    D= (D.clientHeight)? D: B;
    return D.scrollTop;
  }
}
//---End function

//---Start function: getWindowSize
function htmllib_getWindowSize(pMode) {
  var myWidth = 0, myHeight = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    //Non-IE
    myWidth = window.innerWidth;
    myHeight = window.innerHeight;
  } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
    //IE 6+ in 'standards compliant mode'
    myWidth = document.documentElement.clientWidth;
    myHeight = document.documentElement.clientHeight;
  } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
    //IE 4 compatible
    myWidth = document.body.clientWidth;
    myHeight = document.body.clientHeight;
  }
  if (pMode == "w"){
    return myWidth;
  }
  else{    
    return myHeight;
  }
}
//---End function

//---Start function: setGadgetStyle
function htmllib_setGadgetStyle(caller, hideTitle, hideCard) {
  if(!Empty(caller.title_pagelet_decorator_id)){
    var decorator = ZtVWeb.getPortletById(caller.title_pagelet_decorator_id);
    if(decorator.setGadgetStyle){
      decorator.setGadgetStyle(hideTitle,hideCard);
    }
  }
}
//---End function

//---Start function: splitWithStyle
function htmllib_splitWithStyle(pText, pSplit, pClass, pFirst) {
  //Splitto per spazio
  var res = pText;
  var aText = res.split(pSplit);
  if(aText.length>1){
    if(!pFirst)
      res = aText[0] + '<span class="'+pClass+'">'+pText.replace(aText[0],"")+'</span>';
    else
      res = '<span class="'+pClass+'">'+aText[0]+'</span>'+pText.replace(aText[0],"");
  }
  return res;
}
//---End function

//---Start function: MakeHTMLLib
function MakeHTMLLib() {
  this.changeBg=htmllib_changeBg
  this.decodeDate=htmllib_decodeDate
  this.getControlIdByName=htmllib_getControlIdByName
  this.getPortletDecoratorId=htmllib_getPortletDecoratorId
  this.getScrollTop=htmllib_getScrollTop
  this.getWindowSize=htmllib_getWindowSize
  this.setGadgetStyle=htmllib_setGadgetStyle
  this.splitWithStyle=htmllib_splitWithStyle
}
//---End function

arguments[0].HTMLLib = new MakeHTMLLib()
})(window);//MakeHTMLLib
